/*
 * Created on 07.08.2006
 *
 * Загрузка данных конфигурации в аплет
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.config.model.*;


/**
 * @author dima
 *
 */
public class LoadConfig extends HttpServlet {

	public LoadConfig() {
		super();
	}
	
	/**
	 * Обработка GET-запроса
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());

			CfgDataModel dm = new CfgDataModel();
			String sDocument = request.getParameter("document");
			String sBasestation = request.getParameter("basestation");
			System.out.println("In load config, document=" + sDocument + ", basestation=" + sBasestation);

			int documentCode = 0;
			if ( (sDocument != null) && (sDocument.trim().length() > 0) ) {
				documentCode = Integer.parseInt(sDocument);
			}

			if (documentCode != 0) {
				doLoadByDocument(dm, documentCode);
				dm.setConfigChanged(true);
			} else {
				int basestationCode = Integer.parseInt(sBasestation);
				doLoadByBasestation(dm, basestationCode);
				dm.setConfigChanged(false);
			}

			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Loading data by document code
	 * @param dm
	 * @param documentCode
	 */
	private void doLoadByDocument(CfgDataModel dm, int documentCode) {
		System.out.println("doLoadByDocument");
		doLoadDocument(dm, documentCode);
		loadBSInfo(dm, dm.getDocument().getConfigDest());
		loadBSStands(dm, dm.getDocument().getConfigDest());
		loadTRX(dm, dm.getDocument().getConfigDest());
		loadAntennes(dm, dm.getDocument().getConfigDest());
		loadRepiters(dm, dm.getDocument().getConfigDest());
		loadOtherEquip(dm, dm.getDocument().getConfigDest());
	}
	
	/**
	 * Load document header fields
	 * @param dm
	 * @param documentCode
	 */
	private void doLoadDocument(CfgDataModel dm, int documentCode) {
		CDBCResultSet rs = CDBCConfigObject.loadCfgDocument(documentCode);
		ListIterator it = rs.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			DocumentVO doc = dm.getDocument();
			doc.setCode(((Integer)ro.getColumn("document").asObject()).intValue());
			doc.setConfigSource(((Integer)ro.getColumn("savconfigid_old").asObject()).intValue());
			doc.setConfigDest(((Integer)ro.getColumn("savconfigid_new").asObject()).intValue());
			doc.setDocindex(((Integer)ro.getColumn("blankindex").asObject()).intValue());
			doc.setDocnumber(ro.getColumn("blanknumber").asString());
			doc.setDocdate((java.util.Date)ro.getColumn("blankdate").asObject());
			doc.setState(ro.getColumn("state").asString());
			Integer storedem = (Integer)ro.getColumn("storedem").asObject();
			if (storedem != null) {
				doc.setStore1(new StoreVO(storedem.intValue(), 
					ro.getColumn("storedemname").asString()));
			}
			Integer storebad = (Integer)ro.getColumn("storebad").asObject();
			if (storebad != null) {
				doc.setStore2(new StoreVO(storebad.intValue(), 
					ro.getColumn("storebadname").asString()));
			}
			ExpeditionVO expvo = null;
			Integer iworker = (Integer)ro.getColumn("expeditor").asObject();
			Integer iorganization = (Integer)ro.getColumn("organization").asObject();
			int from = ((Integer)ro.getColumn("from").asObject()).intValue();
			System.out.println("From=" + from + ", worker=" + iworker + ", iorg=" + iorganization);
			if (iworker != null) {
				System.out.println("Worker, name=" + ro.getColumn("expname").asString());
				expvo = new ExpeditionVO(from,
					new WorkerVO(iworker.intValue(), ro.getColumn("expname").asString()));
			} else if (iorganization != null) {
				System.out.println("Org, name=" + ro.getColumn("expname").asString());
				expvo = new ExpeditionVO(from,
					new OrganizationVO(iorganization.intValue(), ro.getColumn("expname").asString(),
					ro.getColumn("insuranceman").asString()));
			}
			doc.setExpeditor(expvo);
			int haveInserts = ((Integer)ro.getColumn("haveinserts").asObject()).intValue();
			int haveChanges = ((Integer)ro.getColumn("havechanges").asObject()).intValue();
			int haveDeletes = ((Integer)ro.getColumn("havedeletes").asObject()).intValue();
			doc.setHaveInserts(haveInserts==1);
			doc.setHaveChanges(haveChanges==1);
			doc.setHaveDeletes(haveDeletes==1);
		}
	}
	
	/**
	 * Loading data by basestation code
	 * @param dm
	 * @param basestationCode
	 */	
	private void doLoadByBasestation(CfgDataModel dm, int basestationCode) {
		System.out.println("doLoadByBasestation");
		DocumentVO doc = dm.getDocument();
		CDBCResultSet rs = CDBCConfigObject.cfgSaveConfig(basestationCode);
		ListIterator it = rs.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			Integer errorCode = (Integer)ro.getColumn("col1").asObject();
			if ( (errorCode != null) && (errorCode.intValue() == 0) ) {
				Integer configId = (Integer)ro.getColumn("col2").asObject();
				if (configId != null) {
					doc.setConfigSource(configId.intValue());
					loadBSInfo(dm, configId.intValue());
					loadBSStands(dm, configId.intValue());
					loadTRX(dm, configId.intValue());
					loadAntennes(dm, configId.intValue());
					loadRepiters(dm, configId.intValue());
					loadOtherEquip(dm, configId.intValue());
				}
			}
		}
		if (doc.getConfigSource() != 0) {
			CDBCResultSet rs2 = CDBCConfigObject.cfgCopyConfig(doc.getConfigSource());
			ListIterator it2 = rs2.listIterator();
			if (it2.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it2.next();
				Integer errorCode = (Integer)ro.getColumn("col1").asObject();
				if ( (errorCode != null) && (errorCode.intValue() == 0) ) {
					Integer configId = (Integer)ro.getColumn("col2").asObject();
					if (configId != null) {
						doc.setConfigDest(configId.intValue());
					}
				}
			}
		}
	}
	
	/**
	 * Read Basestation data (common)
	 *
	 */
	public static void loadBSInfo(CfgDataModel dm, int savConfigID) {
		System.out.println("loadBSInfo");
		CDBCResultSet rs = CDBCConfigObject.findBSInfo(savConfigID);
		ListIterator it = rs.listIterator();
		if (it.hasNext()) { // Only one basestation can be returned
			CDBCRowObject ro = (CDBCRowObject)it.next();
			BasestationData bsdata = dm.getBSData();
			bsdata.setType(ro.getColumn("type").asString());
			bsdata.setState900(ro.getColumn("state900").asString());
			bsdata.setState1800(ro.getColumn("state1800").asString());
			bsdata.setMount900((java.util.Date)ro.getColumn("date_bldbeg").asObject());
			bsdata.setMount1800((java.util.Date)ro.getColumn("date_bldbeg2").asObject());
			bsdata.setTest900((java.util.Date)ro.getColumn("date_assemb").asObject());
			bsdata.setTest1800((java.util.Date)ro.getColumn("date_assemb2").asObject());
			bsdata.setTestAfs900((java.util.Date)ro.getColumn("date_assemb_afs").asObject());
			bsdata.setTestAfs1800((java.util.Date)ro.getColumn("date_assemb_afs2").asObject());
			bsdata.setConnect900((java.util.Date)ro.getColumn("date_connect").asObject());
			bsdata.setConnect1800((java.util.Date)ro.getColumn("date_connect2").asObject());
			bsdata.setOnair900((java.util.Date)ro.getColumn("date_onair").asObject());
			bsdata.setOnair1800((java.util.Date)ro.getColumn("date_onair2").asObject());

			bsdata.setNumber((Integer)ro.getColumn("number").asObject());
			bsdata.setName(ro.getColumn("name").asString());
			bsdata.setDopInfo(ro.getColumn("equipcomment").asString());
			bsdata.setHset((java.math.BigDecimal)ro.getColumn("h_obj_ant").asObject());
			bsdata.setAntPlace((Integer)ro.getColumn("antplaceid").asObject());
			bsdata.setPermitGSM(ro.getColumn("numgsmpermit").asString());
			bsdata.setPermitDCS(ro.getColumn("numdcspermit").asString());
			bsdata.setApartment((Integer)ro.getColumn("apartmentid").asObject());
			
			ControllerVO contr = bsdata.getController();
			Integer ccode = (Integer)ro.getColumn("controller").asObject();
			Integer cnumber = (Integer)ro.getColumn("cnumber").asObject();
			String cname = ro.getColumn("cname").asString();
			System.out.println("Loading controller=" + cname + ", ccode" + ccode);
			if ( (ccode != null) && (cnumber != null)) {
				contr.setCode(ccode.intValue());
				contr.setNumber(cnumber.intValue());
				contr.setName(cname);
			}
			
			bsdata.setRecordStatus("K");
			BaseStationVO bsvo = dm.getBasestation();
			bsvo.setCode(((Integer)ro.getColumn("equipment").asObject()).intValue());
			bsvo.setName(ro.getColumn("name").asString());
			bsvo.setAddress(ro.getColumn("address").asString());
			bsvo.setGsmid(((Integer)ro.getColumn("number").asObject()).intValue());
		}
	}
	
	/**
	 * Read Basestation stands data 
	 *
	 */
	public static void loadBSStands(CfgDataModel dm, int savConfigID) {
		System.out.println("loadBSStands");
		ArrayList bsstands = dm.getBSStands();
		CDBCResultSet rs = CDBCConfigObject.findBSStands(savConfigID);
		ListIterator it = rs.listIterator();
		int maxcode = 0;
		while (it.hasNext()) { 
			CDBCRowObject ro = (CDBCRowObject)it.next();
			BSStandVO bssvo = new BSStandVO();
			
			bssvo.setCode(((Integer)ro.getColumn("standid").asObject()).intValue());
			bssvo.setStandno(ro.getColumn("stnomer").asString());
			bssvo.setTrx_num(0);
			ResourceVO rvo = bssvo.getResource();
			Integer resource = (Integer)ro.getColumn("resource").asObject();
			if (resource != null) {
				rvo.setCode(resource.intValue());
				rvo.setName(ro.getColumn("resname").asString());
				rvo.setPolicy(ro.getColumn("policy").asString());
			}
			bssvo.setStoragecard((Integer)ro.getColumn("storagecard").asObject());
			bssvo.setSerialnumber(ro.getColumn("serialnumber").asString());
			bssvo.setInventserial(ro.getColumn("inventserial").asString());
			bssvo.setLocalserial(ro.getColumn("localserial").asString());
			String isFictSerial = ro.getColumn("isfictserial").asString();
			if ( "N".equals(isFictSerial) )
				bssvo.setHaveSerial(true);
			else
				bssvo.setHaveSerial(false);
			if ( (bssvo.getInventserial() != null) && (bssvo.getInventserial().trim().length() > 0) )
				bssvo.setHaveInventSerial(true);
			else
				bssvo.setHaveInventSerial(false);
			if ( (bssvo.getLocalserial() != null) && (bssvo.getLocalserial().trim().length() > 0) )
				bssvo.setHaveLocalSerial(true);
			else
				bssvo.setHaveLocalSerial(false);
			bssvo.setEmptySerials(false);
			
			String broken = ro.getColumn("broken").asString();
			if ("Y".equals(broken))
				bssvo.setBroken(true);
			bssvo.setComment(ro.getColumn("notes").asString());
			bssvo.setCountPolicy(ro.getColumn("policy").asString());
			
			bssvo.setRecordStatus(ro.getColumn("objectstatus").asString());
			//System.out.println("Code=" + bssvo.getCode() + ", Name=" + bssvo.getResource().getName());
			bsstands.add(bssvo);
			if (bssvo.getCode() > maxcode) {
				maxcode = bssvo.getCode();
			}
		}
		dm.setBsstandidcounter(maxcode);
	}
	
	// Find corresponding bsstand object by its primary key  
	private static BSStandVO findBSStand(ArrayList bsstands, int standid) {
		BSStandVO res = null;
		BSStandVO srch = new BSStandVO();
		//System.out.println("Finding Stand with code=" + standid);
		srch.setCode(standid);
		int i = Collections.binarySearch(bsstands, srch);
		//System.out.println("Found, index=" + i);
		if (i >= 0)
			res = (BSStandVO)bsstands.get(i);
		return res;
	}
	
	/**
	 * Read Basestation TRX data 
	 *
	 */
	public static void loadTRX(CfgDataModel dm, int savConfigID) {
		System.out.println("loadTRX");
		ArrayList trxes = dm.getTrxes();
		CDBCResultSet rs = CDBCConfigObject.findTrxes(savConfigID);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) { 
			CDBCRowObject ro = (CDBCRowObject)it.next();
			TrxVO trxvo = new TrxVO();
			
			trxvo.setIdtrx(((Integer)ro.getColumn("trxid").asObject()).intValue());
			int standid = ((Integer)ro.getColumn("standid").asObject()).intValue();
			ArrayList bsstands = dm.getBSStands();
			trxvo.setBsstand(findBSStand(bsstands, standid));
			ResourceVO rvo = trxvo.getResource();
			Integer resource = (Integer)ro.getColumn("resource").asObject();
			if (resource != null) {
				rvo.setCode(resource.intValue());
				rvo.setName(ro.getColumn("resname").asString());
				rvo.setPolicy(ro.getColumn("policy").asString());
			}
			trxvo.setStoragecard((Integer)ro.getColumn("storagecard").asObject());
			trxvo.setSerialnumber(ro.getColumn("serialnumber").asString());
			trxvo.setInventserial(ro.getColumn("inventserial").asString());
			trxvo.setLocalserial(ro.getColumn("localserial").asString());
			String isFictSerial = ro.getColumn("isfictserial").asString();
			if ( "N".equals(isFictSerial) )
				trxvo.setHaveSerial(true);
			else
				trxvo.setHaveSerial(false);
			if ( (trxvo.getInventserial() != null) && (trxvo.getInventserial().trim().length() > 0) )
				trxvo.setHaveInventSerial(true);
			else
				trxvo.setHaveInventSerial(false);
			if ( (trxvo.getLocalserial() != null) && (trxvo.getLocalserial().trim().length() > 0) )
				trxvo.setHaveLocalSerial(true);
			else
				trxvo.setHaveLocalSerial(false);
			trxvo.setEmptySerials(false);
			
			String broken = ro.getColumn("broken").asString();
			if ("Y".equals(broken))
				trxvo.setBroken(true);
			trxvo.setComment(ro.getColumn("notes").asString());
			trxvo.setCountPolicy(ro.getColumn("policy").asString());
			
			trxvo.setRecordStatus(ro.getColumn("objectstatus").asString());
			//System.out.println("Code=" + bssvo.getCode() + ", Name=" + bssvo.getResource().getName());
			
			loadTRXSectors(dm, trxvo, savConfigID, SectorVO.DIAP900);
			loadTRXSectors(dm, trxvo, savConfigID, SectorVO.DIAP1800);
			
			trxes.add(trxvo);
		}
	}
	
	private static void loadTRXSectors(CfgDataModel dm, TrxVO trxvo, int savConfigID, short diap) {
		System.out.println("In Load TRX sectors");
		CDBCResultSet rs = CDBCConfigObject.findTrxSectors(savConfigID, trxvo.getIdtrx(), diap);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) { 
			CDBCRowObject ro = (CDBCRowObject)it.next();
			SectorVO sectvo = new SectorVO();
			fillSectorFields(sectvo, ro);
			int numsect = getSectorIndex(sectvo.getNamesect());
			//System.out.println("Name_sect=" + sectvo.getNamesect() + ", numsect=" + numsect);
			if (numsect >= 0)
				trxvo.setSectorInDiap(diap, numsect, dm.findSector(sectvo));
		}
	}
	
	private static int getSectorIndex(String ns) {
		if ("O".equals(ns))
			return 0;
		else if ("A".equals(ns) || "E".equals(ns))
			return 1;
		else if ("B".equals(ns) || "F".equals(ns))
			return 2;
		else if ("C".equals(ns) || "G".equals(ns))
			return 3;
		else if ("D".equals(ns) || "H".equals(ns))
			return 4;
		return -1;
	}
	
	/**
	 * Read Antennes data 
	 *
	 */
	public static void loadAntennes(CfgDataModel dm, int savConfigID) {
		System.out.println("loadAntennes");
		ArrayList antennes = dm.getAntennes();
		CDBCResultSet rs = CDBCConfigObject.findAntennes(savConfigID);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) { 
			CDBCRowObject ro = (CDBCRowObject)it.next();
			AntennaVO antvo = new AntennaVO();
			
			antvo.setCode(((Integer)ro.getColumn("id_anten").asObject()).intValue());
			antvo.setAzimuth((java.math.BigDecimal)ro.getColumn("az_ant").asObject());
			antvo.setHset((java.math.BigDecimal)ro.getColumn("h_set1").asObject());
			antvo.setNakl((java.math.BigDecimal)ro.getColumn("nakl").asObject());
			antvo.setKsvn900((java.math.BigDecimal)ro.getColumn("ksvn900").asObject());
			antvo.setKsvn1800((java.math.BigDecimal)ro.getColumn("ksvn1800").asObject());
			String iscomcab = ro.getColumn("commcable").asString();
			antvo.setCommoncable("Y".equals(iscomcab));
			String kindant = ro.getColumn("kind_ant900").asString();
			antvo.setKindant900(new StringSelectorVO(kindant, AntennaVO.getKindAntName(kindant)));
			kindant = ro.getColumn("kind_ant1800").asString();
			antvo.setKindant1800(new StringSelectorVO(kindant, AntennaVO.getKindAntName(kindant)));
			String locat = ro.getColumn("locationtype").asString();
			antvo.setLocationtype(new StringSelectorVO(locat, AntennaVO.getLocationName(locat)));
			ResourceVO rvo = antvo.getResource();
			Integer resource = (Integer)ro.getColumn("resource").asObject();
			if (resource != null) {
				rvo.setCode(resource.intValue());
				rvo.setName(ro.getColumn("resname").asString());
				rvo.setPolicy(ro.getColumn("policy").asString());
			}
			antvo.setStoragecard((Integer)ro.getColumn("storagecard").asObject());
			antvo.setSerialnumber(ro.getColumn("serialnumber").asString());
			antvo.setInventserial(ro.getColumn("inventserial").asString());
			antvo.setLocalserial(ro.getColumn("localserial").asString());
			String isFictSerial = ro.getColumn("isfictserial").asString();
			if ( "N".equals(isFictSerial) )
				antvo.setHaveSerial(true);
			else
				antvo.setHaveSerial(false);
			if ( (antvo.getInventserial() != null) && (antvo.getInventserial().trim().length() > 0) )
				antvo.setHaveInventSerial(true);
			else
				antvo.setHaveInventSerial(false);
			if ( (antvo.getLocalserial() != null) && (antvo.getLocalserial().trim().length() > 0) )
				antvo.setHaveLocalSerial(true);
			else
				antvo.setHaveLocalSerial(false);
			antvo.setEmptySerials(false);
		
			String broken = ro.getColumn("broken").asString();
			if ("Y".equals(broken))
				antvo.setBroken(true);
			antvo.setComment(ro.getColumn("notes").asString());
			antvo.setCountPolicy(ro.getColumn("policy").asString());
			
			antvo.setRecordStatus(ro.getColumn("objectstatus").asString());
			//System.out.println("Code=" + bssvo.getCode() + ", Name=" + bssvo.getResource().getName());
			
			antvo.setSector900(dm.findSector(loadSector(savConfigID, antvo.getCode(), SectorVO.DIAP900)));
			antvo.setSector1800(dm.findSector(loadSector(savConfigID, antvo.getCode(), SectorVO.DIAP1800)));
			
			//if (antvo.getSector900() != null)
			//	System.out.println("LOAD Sect = " + antvo.getSector900().getNamesect() + ", band=" + antvo.getSector900().getBand());
			//if (antvo.getSector1800() != null)
			//	System.out.println("LOAD Sect = " + antvo.getSector1800().getNamesect() + ", band=" + antvo.getSector1800().getBand());
			
			readAntennaCables(savConfigID, antvo);
			
			antennes.add(antvo);
		}
	}
	
	/**
	 * Read Antenna cables data
	 *
	 */
	private static void readAntennaCables(int savConfigID, AntennaVO anten) {
		CDBCResultSet rs1 = CDBCConfigObject.findCablesForAntenna(savConfigID, anten.getCode());
		ListIterator it1 = rs1.listIterator();
		if (it1.hasNext()) { // First cable
			CDBCRowObject ro1 = (CDBCRowObject)it1.next();
			ResourceVO cableres = new ResourceVO(((Integer)ro1.getColumn("cableres").asObject()).intValue(),
				ro1.getColumn("model").asString());
			anten.setCable1(cableres);
			anten.setCablen1((java.math.BigDecimal)ro1.getColumn("len_cable").asObject());
		}
		if (it1.hasNext()) { // Second cable
			CDBCRowObject ro1 = (CDBCRowObject)it1.next();
			ResourceVO cableres = new ResourceVO(((Integer)ro1.getColumn("cableres").asObject()).intValue(),
				ro1.getColumn("model").asString());
			anten.setCable2(cableres);
			anten.setCablen2((java.math.BigDecimal)ro1.getColumn("len_cable").asObject());
		}
	}
	
	protected static void fillSectorFields(SectorVO sectvo, CDBCRowObject ro) {
		sectvo.setBand(((Short)ro.getColumn("band").asObject()).shortValue());
		sectvo.setIdsect(((Integer)ro.getColumn("id_sect").asObject()).intValue());
		String ns = ro.getColumn("name_sect").asString();
		if ( (ns != null) && (ns.length() > 0) ) {
			sectvo.setNamesect(ns.substring(ns.length()-1, ns.length()));
		}
		sectvo.setNumsect(ro.getColumn("num_sect").asString());
		sectvo.setLac((Integer)ro.getColumn("lac").asObject());
		sectvo.setCellname((Integer)ro.getColumn("cellname").asObject());
		sectvo.setAzimut((BigDecimal)ro.getColumn("azimut").asObject());
		sectvo.setRecordStatus(ro.getColumn("objectstatus").asString());
	}
	
	/**
	 * Read Sector for Antenna data (common)
	 *
	 */
	public static SectorVO loadSector(int savConfigID, int idAntenn, short diap) {
		SectorVO sectvo = new SectorVO();
		CDBCResultSet rs1 = CDBCConfigObject.findSectorsForAntenna(savConfigID, idAntenn, diap);
		ListIterator it1 = rs1.listIterator();
		if (it1.hasNext()) { // Only one sector can be returned
			CDBCRowObject ro1 = (CDBCRowObject)it1.next();
			fillSectorFields(sectvo, ro1);
		}
		int numsect = getSectorIndex(sectvo.getNamesect());
		//System.out.println("Name_sect=" + sectvo.getNamesect() + ", numsect=" + numsect);
		if (numsect >= 0)
			return sectvo;
		else
			return null;
	}

	/**
	 * Read Repiters data 
	 *
	 */
	public static void loadRepiters(CfgDataModel dm, int savConfigID) {
		System.out.println("loadRepiters");
		ArrayList repiters = dm.getRepiters();
		CDBCResultSet rs = CDBCConfigObject.findRepiters(dm.getBasestation().getCode());
		ListIterator it = rs.listIterator();
		while (it.hasNext()) { 
			CDBCRowObject ro = (CDBCRowObject)it.next();
			RepiterVO repvo = new RepiterVO();
			
			repvo.setRepnum((Integer)ro.getColumn("number").asObject());
			repvo.setSectnum(ro.getColumn("name_sect").asString());
			repvo.setConntype(ro.getColumn("donor_type").asString());
			repvo.setStatus(ro.getColumn("state").asString());
			repiters.add(repvo);
		}
	}

	/**
	 * Read Other Equipment data 
	 *
	 */
	public static void loadOtherEquip(CfgDataModel dm, int savConfigID) {
		System.out.println("loadOtherEquip, config=" + savConfigID);
		HashMap otherequipes = dm.getOtherequip();
		CDBCResultSet rs = CDBCConfigObject.findOtherEquip(savConfigID);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) { 
			System.out.println("New Equipment");
			CDBCRowObject ro = (CDBCRowObject)it.next();
			EquipObjectVO eovo = new EquipObjectVO();
			
			eovo.setIdequipobject(((Integer)ro.getColumn("objcfgid").asObject()).intValue());
			eovo.setParentObject((Integer)ro.getColumn("parentobjcfgid").asObject());
			Integer curCategory = (Integer)ro.getColumn("resourceclass2").asObject();
			eovo.setIdequipcategory(curCategory.intValue());
			ResourceVO rvo = eovo.getResource();
			Integer resource = (Integer)ro.getColumn("resource").asObject();
			if (resource != null) {
				rvo.setCode(resource.intValue());
				rvo.setName(ro.getColumn("resname").asString());
				rvo.setPolicy(ro.getColumn("policy").asString());
			}
			eovo.setResource(rvo);
			eovo.setStoragecard((Integer)ro.getColumn("storagecard").asObject());
			eovo.setSerialnumber(ro.getColumn("serialnumber").asString());
			eovo.setInventserial(ro.getColumn("inventserial").asString());
			eovo.setLocalserial(ro.getColumn("localserial").asString());
			String isFictSerial = ro.getColumn("isfictserial").asString();
			if ( "N".equals(isFictSerial) )
				eovo.setHaveSerial(true);
			else
				eovo.setHaveSerial(false);
			if ( (eovo.getInventserial() != null) && (eovo.getInventserial().trim().length() > 0) )
				eovo.setHaveInventSerial(true);
			else
				eovo.setHaveInventSerial(false);
			if ( (eovo.getLocalserial() != null) && (eovo.getLocalserial().trim().length() > 0) )
				eovo.setHaveLocalSerial(true);
			else
				eovo.setHaveLocalSerial(false);
			eovo.setEmptySerials(false);
			
			String broken = ro.getColumn("broken").asString();
			if ("Y".equals(broken))
				eovo.setBroken(true);
			eovo.setComment(ro.getColumn("notes").asString());
			eovo.setCountPolicy(ro.getColumn("policy").asString());
			eovo.setQty((BigDecimal)ro.getColumn("qty").asObject());
			
			eovo.setRecordStatus(ro.getColumn("objectstatus").asString());
			//System.out.println("Code=" + eovo.getIdequipobject() + ", categ=" + eovo.getIdequipcategory() + ", parent=" + eovo.getParentObject());
			ArrayList otherequip = EquipObjectKeyVO.getEquipList(otherequipes, eovo.getIdequipcategory(), eovo.getParentObject()); 
			otherequip.add(eovo);
			loadOtherEquipSectors(dm, eovo, savConfigID, SectorVO.DIAP900);
			loadOtherEquipSectors(dm, eovo, savConfigID, SectorVO.DIAP1800);
		}
	}
			
	private static void loadOtherEquipSectors(CfgDataModel dm, EquipObjectVO eovo, int savConfigID, short diap) {
		System.out.println("In Load OtherEquip sectors");
		CDBCResultSet rs = CDBCConfigObject.findOtherEquipSectors(savConfigID, eovo.getIdequipobject(), diap);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) { 
			CDBCRowObject ro = (CDBCRowObject)it.next();
			SectorVO sectvo = new SectorVO();
			fillSectorFields(sectvo, ro);
			int numsect = getSectorIndex(sectvo.getNamesect());
			//System.out.println("Name_sect=" + sectvo.getNamesect() + ", numsect=" + numsect);
			if (numsect >= 0)
				eovo.setSectorInDiap(diap, numsect, dm.findSector(sectvo));
		}
	}
	
}
