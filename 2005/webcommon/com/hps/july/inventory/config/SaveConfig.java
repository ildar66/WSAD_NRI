/*
 * Created on 07.08.2006
 *
 * Сохранение данных конфигурации из аплета в БД
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCDocuments;
import com.hps.july.cdbc.objects.CDBCInventoryDocumentError;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.config.beans.CfgAnten2SectorAccessBean;
import com.hps.july.config.beans.CfgAntennaAccessBean;
import com.hps.july.config.beans.CfgAntennaCableAccessBean;
import com.hps.july.config.beans.CfgAntennaWorkBandAccessBean;
import com.hps.july.config.beans.CfgBasestationAccessBean;
import com.hps.july.config.beans.CfgBsstandsAccessBean;
import com.hps.july.config.beans.CfgEquipObjCfg2SectorAccessBean;
import com.hps.july.config.beans.CfgEquipObjectsCfgAccessBean;
import com.hps.july.config.beans.CfgSectorAccessBean;
import com.hps.july.config.beans.CfgStoragecardAccessBean;
import com.hps.july.config.beans.CfgTrx;
import com.hps.july.config.beans.CfgTrx2SectorAccessBean;
import com.hps.july.config.beans.CfgTrxAccessBean;
import com.hps.july.config.model.AntennaVO;
import com.hps.july.config.model.AppletPostResponse;
import com.hps.july.config.model.BSStandVO;
import com.hps.july.config.model.BaseStationVO;
import com.hps.july.config.model.BasestationData;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.CfgDataModel;
import com.hps.july.config.model.ConfigError;
import com.hps.july.config.model.DocumentVO;
import com.hps.july.config.model.EquipCategoryVO;
import com.hps.july.config.model.EquipObjectKeyVO;
import com.hps.july.config.model.EquipObjectVO;
import com.hps.july.config.model.ExpeditionVO;
import com.hps.july.config.model.SectorVO;
import com.hps.july.config.model.TrxVO;
import com.hps.july.inventory.actionbean.NIDocumentTranslateErrors;
import com.hps.july.inventory.sessionbean.DocumentProcessingException;
import com.hps.july.inventory.sessionbean.ProcessorFacadeAccessBean;
import com.hps.july.persistence.CfgDocumentAccessBean;
import com.hps.july.persistence.Expedition;
import com.hps.july.persistence.ExpeditionAccessBean;
import com.hps.july.persistence.Organization;
import com.hps.july.persistence.OrganizationAccessBean;
import com.hps.july.persistence.OrganizationKey;
import com.hps.july.persistence.Worker;
import com.hps.july.persistence.WorkerAccessBean;
import com.hps.july.persistence.WorkerKey;
import com.hps.july.util.AppUtils;


/**
 * @author dima
 *
 */
public class SaveConfig extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			System.out.println("In CfgService");
			int errorCode = 0;
			String errorMessage = "OK";
			ObjectInputStream in = new ObjectInputStream(request.getInputStream());
			CfgDataModel dm = null;
			try {
				dm = (CfgDataModel) in.readObject();
				System.out.println("RECEIVED CFG OBJECT: sourcedocnfig=" + dm.getDocument().getConfigSource() + ", DestConfig=" + dm.getDocument().getConfigDest());
				//request.getSession().setAttribute("cfgdatamodel", dm);
			} catch (OptionalDataException e) {
				errorCode = AppletPostResponse.PROGRAMM_ERROR;
				errorMessage = e.getMessage();
				e.printStackTrace(System.out);
			} catch (ClassNotFoundException e) {
				errorCode = AppletPostResponse.PROGRAMM_ERROR;
				errorMessage = e.getMessage();
				e.printStackTrace(System.out);
			} catch (IOException e) {
				errorCode = AppletPostResponse.PROGRAMM_ERROR;
				errorMessage = e.getMessage();
				e.printStackTrace(System.out);
			}
			in.close();

			if ( (errorCode == 0) && dm.getUndoCalc() ) {
				if (!unCalcDocument(dm)) {
					errorCode = AppletPostResponse.UNCALC_ERROR;
					errorMessage = "Ошибка снятия обсчета документа";
				}
			} else if ( (errorCode == 0) && dm.getDeleteDocument() ) {
				if (!deleteDocument(dm)) {
						errorCode = AppletPostResponse.DELETE_ERROR;
						errorMessage = "Ошибка удаления документа";
				}
			} else {
				if (errorCode == 0) {
					if (!doValidateDocument(dm)) {
						errorCode = AppletPostResponse.VALIDATION_ERROR;
						errorMessage = "Заполнены не все поля документа";
					}
				}

				if (errorCode == 0) {
					if (!doSaveDocument(dm)) {
						errorCode = AppletPostResponse.SAVE_ERROR;
						errorMessage = "Ошибка сохранения документа";
					}
				}
	
				if ( (errorCode == 0) && dm.isDoCalc() ) {
					if (!doCalcDocument(dm)) {
						errorCode = AppletPostResponse.CALC_ERROR;
						errorMessage = "Ошибка обсчета документа";
					}
				}
			}


			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());

			AppletPostResponse apresp = new AppletPostResponse();
			apresp.setErrorCode(errorCode);
			apresp.setErrorMessage(errorMessage);

			out.writeObject(apresp);
			out.writeObject(dm);
			out.flush();
	}

	private boolean deleteDocument(CfgDataModel dm) {
		boolean result = true;
		
		com.hps.july.cdbc.objects.CDBCInventoryDocumentError cdbcIDER;
		cdbcIDER = new com.hps.july.cdbc.objects.CDBCInventoryDocumentError();

		cdbcIDER.clearDocumentErrors(new Integer(dm.getDocument().getCode()));
		
		try {
			
			ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
			System.out.println("Before delete document with code = " + dm.getDocument().getCode());
			processor.deleteDocument(new Integer(dm.getDocument().getCode()));
		} catch (DocumentProcessingException e) {
			System.out.println("Document processing exception");
			NIDocumentTranslateErrors.translateDocErrors(new Integer(dm.getDocument().getCode()), e, null);
			CDBCInventoryDocumentError de = new CDBCInventoryDocumentError();
			CDBCResultSet errors = de.listDocumentErrors(new Integer(dm.getDocument().getCode()));
			java.util.ListIterator it = errors.listIterator();
			List errorsArr = dm.getDeleteErrors();
			while (it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				ConfigError err = extractConfigError(ro);
				errorsArr.add(err);
				result = false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			result = false;
		} catch (CreateException e) {
			e.printStackTrace();
			result = false;
		} catch (NamingException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	private ConfigError extractConfigError(CDBCRowObject ro) {
		ConfigError err = new ConfigError();
		err.setErrorsection(ConfigError.UNKNOWN);
		err.setErrordescr(ro.getColumn("errortext").asString());
		int docpos = ((Integer)ro.getColumn("docposition").asObject()).intValue();
		err.setErrorline(docpos);
		if (docpos > 10000) {
			docpos = docpos - 10000;  // 10000
			if (docpos < 10000) {
				err.setErrorsection(ConfigError.BSSTANDS);
				err.setErrorline(docpos);
			} else if (docpos > 10000) {
				docpos = docpos - 10000; // 20000
				if (docpos < 10000) {
					err.setErrorsection(ConfigError.TRX);
					err.setErrorline(docpos);
				} else if (docpos > 10000) {
					docpos = docpos - 10000; // 30000
					if (docpos < 10000) {
						err.setErrorsection(ConfigError.ANTENNES);
						err.setErrorline(docpos);
					} else if (docpos > 10000) {
						docpos = docpos - 10000; // 40000
						if (docpos < 10000) {
							err.setErrorsection(ConfigError.CABLES);
							err.setErrorline(docpos);
						} else if (docpos > 10000) {
							docpos = docpos - 10000; // 50000
							if (docpos < 10000) {
								err.setErrorsection(docpos/100 + "");
								err.setErrorline(docpos - docpos/100*100);
							}
						}
					}
				}
			}
		}
		return err;
	}
	
	private boolean doCalcDocument(CfgDataModel dm) {
		boolean result = true;
		
		com.hps.july.cdbc.objects.CDBCInventoryDocumentError cdbcIDER;
		cdbcIDER = new com.hps.july.cdbc.objects.CDBCInventoryDocumentError();

		cdbcIDER.clearDocumentErrors(new Integer(dm.getDocument().getCode()));
		
		try {
			
			ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
			System.out.println("Before process document with code = " + dm.getDocument().getCode());
			processor.processDocument(new Integer(dm.getDocument().getCode()), false, dm.isDoAutoCalc());
		} catch (DocumentProcessingException e) {
			System.out.println("Document processing exception");
			NIDocumentTranslateErrors.translateDocErrors(new Integer(dm.getDocument().getCode()), e, null);
			CDBCInventoryDocumentError de = new CDBCInventoryDocumentError();
			CDBCResultSet errors = de.listDocumentErrors(new Integer(dm.getDocument().getCode()));
			java.util.ListIterator it = errors.listIterator();
			ArrayList errorsArr = dm.getCalcErrors();
			while (it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				ConfigError err = extractConfigError(ro);
				errorsArr.add(err);
				result = false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			result = false;
		} catch (CreateException e) {
			e.printStackTrace();
			result = false;
		} catch (NamingException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	private boolean unCalcDocument(CfgDataModel dm) {
		boolean result = true;
		
		CDBCInventoryDocumentError cdbcIDER = new CDBCInventoryDocumentError();

		cdbcIDER.clearDocumentErrors(new Integer(dm.getDocument().getCode()));
		
		try {
			ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
			System.out.println("Before cancel document with code = " + dm.getDocument().getCode());
			processor.cancelDocument(new Integer(dm.getDocument().getCode()));
		} catch (DocumentProcessingException e) {
			System.out.println("Document cancel exception");
			NIDocumentTranslateErrors.translateDocErrors(new Integer(dm.getDocument().getCode()), e, null);
			CDBCInventoryDocumentError de = new CDBCInventoryDocumentError();
			CDBCResultSet errors = de.listDocumentErrors(new Integer(dm.getDocument().getCode()));
			ListIterator it = errors.listIterator();
			List errorsArr = dm.getUncalcErrors();
			while (it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				ConfigError err = extractConfigError(ro);
				errorsArr.add(err);
				System.out.println("Adding uncalc error: " + err.getErrordescr());
				result = false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			result = false;
		} catch (CreateException e) {
			e.printStackTrace();
			result = false;
		} catch (NamingException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}


	private boolean doSaveDocument(CfgDataModel dm) {
		boolean result = true;
		
		if (CDBCConfigObject.clearConfig(dm.getDocument().getConfigDest())) {
			if (!updateDocument(dm)) {
				System.out.println("Update document failed");
				result = false;
			}
			if (!updateBSInfo(dm)) {
				System.out.println("Update bsinfo failed");
				result = false;
			}
			if (!updateBSStands(dm)) {
				System.out.println("Update bsstands failed");
				result = false;
			}
			if (!updateSectors(dm)) {
				System.out.println("Update sectors failed");
				result = false;
			}
			if (!updateTRX(dm)) {
				System.out.println("Update TRX failed");
				result = false;
			}
			if (!updateAntennes(dm)) {
				System.out.println("Update antennes failed");
				result = false;
			}
			if (!updateOtherEquip(dm)) {
				System.out.println("Update OtherEquip failed");
				result = false;
			}
		} else
			result = false;
		
		return result;
	}
	
	/**
	 * Updating document header
	 * @param dm
	 * @return
	 */
	private boolean updateDocument(CfgDataModel dm) {
		boolean result = true;
		DocumentVO doc = dm.getDocument();
		BaseStationVO bsvo = dm.getBasestation();
		if (doc.getCode() == 0) {
			// New document
			try {
				doc.setCode((new KeyGeneratorAccessBean()).getNextKey("tables.documents"));
				int owner = AppUtils.getNamedValueInt("DefaultOwner"); // Get default owner here, as owning not fully supported 
				findExpeditorCode(doc.getExpeditor());
				//System.out.println("Before create doc: exped=" + doc.getExpeditor().getCode() +
				//	", bs=" + bsvo.getCode());
				CfgDocumentAccessBean dab = new CfgDocumentAccessBean(doc.getCode(), new Integer(owner), 
					new Integer(doc.getExpeditor().getCode()), new Integer(bsvo.getCode()), 
					dateFromTime(doc.getDocdate()), 
					doc.getDocindex(), doc.getDocnumber(), "1", new Boolean(false), new Boolean(false), 
					doc.getConfigSource(), doc.getConfigDest());
				if (doc.getExpeditor().getType() == ExpeditionVO.ORGANIZATION) {
					dab.setInsuranseMan(doc.getExpeditor().getOrganization().getRepresentfio());
				}
				if (doc.getStore1().getCode() != 0)
					dab.setStoredem(new Integer(doc.getStore1().getCode()));
				if (doc.getStore2().getCode() != 0)
					dab.setStorebad(new Integer(doc.getStore2().getCode()));
				dab.commitCopyHelper();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				result = false;
			}
		} else {
			// Update document
			try {
				findExpeditorCode(doc.getExpeditor());
				CfgDocumentAccessBean dab = new CfgDocumentAccessBean();
				dab.setInitKey_document(doc.getCode());
				dab.refreshCopyHelper();
				ExpeditionAccessBean eab = new ExpeditionAccessBean();
				eab.setInitKey_storageplace(doc.getExpeditor().getCode());
				eab.refreshCopyHelper();
				dab.setFrom((Expedition)eab.getEJBRef());
				dab.setBlankdate(dateFromTime(doc.getDocdate()));
				dab.setBlankindex(doc.getDocindex());
				dab.setBlanknumber(doc.getDocnumber());
				if (doc.getExpeditor().getType() == ExpeditionVO.ORGANIZATION) {
					dab.setInsuranseMan(doc.getExpeditor().getOrganization().getRepresentfio());
				}
				dab.commitCopyHelper();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				result = false;
			}
		}
		return result;
	}
	
	private void findExpeditorCode(ExpeditionVO expeditor) throws RemoteException, CreateException, FinderException, NamingException {
		ExpeditionAccessBean eab = new ExpeditionAccessBean();
		if (expeditor.getType() == ExpeditionVO.ORGANIZATION) {
			Enumeration expedit = eab.findExpeditionByOrganization(new OrganizationKey(expeditor.getOrganization().getCode()));
			if (expedit.hasMoreElements()) {
				ExpeditionAccessBean expedab = (ExpeditionAccessBean)expedit.nextElement();
				if (expedab != null)
					expeditor.setCode(expedab.getStorageplace()); 
			} else {
				OrganizationAccessBean org = new OrganizationAccessBean();
				org.setInitKey_organization(expeditor.getOrganization().getCode());
				org.refreshCopyHelper(); 
				int ecode = (new KeyGeneratorAccessBean()).getNextKey("tables.storageplaces");
				ExpeditionAccessBean expedab = new ExpeditionAccessBean(ecode,
					null, expeditor.getOrganization().getName(), "no address");
				expedab.setOrganization((Organization)org.getEJBRef());
				expedab.commitCopyHelper();
				expeditor.setCode(ecode);
			}
		} else {
			//System.out.println("Worker code=" + expeditor.getWorker().getCode());
			Enumeration expedit = eab.findExpeditionByExpeditor(new WorkerKey(expeditor.getWorker().getCode()));
			if (expedit.hasMoreElements()) {
				//System.out.println("Expeditor found");
				ExpeditionAccessBean expedab = (ExpeditionAccessBean)expedit.nextElement();
				if (expedab != null) {
					//System.out.println("Exped code=" + expedab.getStorageplace());
					expeditor.setCode(expedab.getStorageplace()); 
				}
			} else {
				//System.out.println("Expeditor not found - creating");
				WorkerAccessBean wrk = new WorkerAccessBean();
				wrk.setInitKey_worker(expeditor.getWorker().getCode());
				wrk.refreshCopyHelper();
				int ecode = (new KeyGeneratorAccessBean()).getNextKey("tables.storageplaces");
				ExpeditionAccessBean expedab = new ExpeditionAccessBean(ecode,
					null, expeditor.getWorker().getName(), "no address");
				expedab.setExpeditor((Worker)wrk.getEJBRef());
				expedab.commitCopyHelper();
				expeditor.setCode(ecode);
			}
		}
	}
	
	/**
	 * Updating basestation info
	 * @param dm
	 * @return
	 */
	private boolean updateBSInfo(CfgDataModel dm) {
		boolean result = true;
		DocumentVO doc = dm.getDocument();
		BasestationData bsdata = dm.getBSData();
		BaseStationVO bsvo = dm.getBasestation();
		if ("U".equals(bsdata.getRecordStatus())) {
			try {
				CfgBasestationAccessBean bsab = new CfgBasestationAccessBean();
				bsab.setInitKey_savconfigid(doc.getConfigDest());
				bsab.setInitKey_equipment(bsvo.getCode());
				bsab.refreshCopyHelper();
				
				if ("G".equals(bsdata.getType()) || "S".equals(bsdata.getType())) {
					// GSM 900
					bsab.setState900(bsdata.getState900());
					bsab.setDate_bldbeg(dateFromTime(bsdata.getMount900()));
					bsab.setDate_assemb(dateFromTime(bsdata.getTest900()));
					bsab.setDate_assemb_afs(dateFromTime(bsdata.getTestAfs900()));
					bsab.setDate_connect(dateFromTime(bsdata.getConnect900()));
					bsab.setDate_onair(dateFromTime(bsdata.getOnair900()));
				}
				if ("G".equals(bsdata.getType()) || "C".equals(bsdata.getType())) {
					// DCS 1800
					bsab.setState1800(bsdata.getState1800());
					bsab.setDate_bldbeg2(dateFromTime(bsdata.getMount1800()));
					bsab.setDate_assemb2(dateFromTime(bsdata.getTest1800()));
					bsab.setDate_assemb_afs2(dateFromTime(bsdata.getTestAfs1800()));
					bsab.setDate_connect2(dateFromTime(bsdata.getConnect1800()));
					bsab.setDate_onair2(dateFromTime(bsdata.getOnair1800()));
				}
				//System.out.println("Controller=" + bsdata.getController().getCode());
				if (bsdata.getController().getCode() == 0)
					bsab.setController(null);
				else
					bsab.setController(new Integer(bsdata.getController().getCode()));
				bsab.setObjectStatus(bsdata.getRecordStatus());
				
				bsab.setNumber(bsdata.getNumber().intValue());
				bsab.setName(bsdata.getName());
				bsab.setEquipcomment(bsdata.getDopInfo());
				bsab.setH_obj_ant(bsdata.getHset());
				bsab.setAntplaceid(bsdata.getAntPlace());
				bsab.setNumgsmpermit(bsdata.getPermitGSM());
				bsab.setNumdcspermit(bsdata.getPermitDCS());
				bsab.setApartmentid(bsdata.getApartment());
				bsab.setType(bsdata.getType());
				bsab.commitCopyHelper();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				result = false;
			}
		}
		return result;
	}
	
	private java.sql.Date dateFromTime(java.util.Date adate) {
		if (adate == null)
			return null;
		else
			return new java.sql.Date(adate.getTime());
	}

	/**
	 * Updating basestation stands 
	 * @param dm
	 * @return
	 */
	private boolean updateBSStands(CfgDataModel dm) {
		boolean result = true;
		DocumentVO doc = dm.getDocument();
		BaseStationVO bsvo = dm.getBasestation();
		
		ArrayList bsstands = dm.getBSStands();
		Iterator it = bsstands.iterator();
		while (it.hasNext()) {
			BSStandVO bsstand = (BSStandVO)it.next();
			try {
				if ("A".equals(bsstand.getRecordStatus())) {
					bsstand.setCode((new KeyGeneratorAccessBean()).getNextKey("tables.bsstands"));
					System.out.println("bsstand code=" + bsstand.getCode());
				}
				// Create storagecard
				int scardid;
				if (bsstand.getStoragecard() != null)
				 	scardid = bsstand.getStoragecard().intValue();
				 else
					scardid = (new KeyGeneratorAccessBean()).getNextKey("tables.storagecards");
				int owner = AppUtils.getNamedValueInt("DefaultOwner"); // Get default owner here, as owning not fully supported 
				CfgStoragecardAccessBean scab = new CfgStoragecardAccessBean(doc.getConfigDest(),
					scardid, bsstand.getResource().getCode(), new java.sql.Date(new java.util.Date().getTime()),
					owner, "S", "N", new java.math.BigDecimal(1), 
					new java.math.BigDecimal(0),
					!bsstand.isHaveSerial(), false, bsstand.getRecordStatus()
					);
				if (bsstand.isHaveSerial()) {
					scab.setIsfictserial(false);
					scab.setSerialnumber(bsstand.getSerialnumber());
				} else {
					scab.setIsfictserial(true);
					scab.setSerialnumber("");
				}
				if (bsstand.isHaveInventSerial()) {
					scab.setInventserial(bsstand.getInventserial());
				} else {
					scab.setInventserial(null);
				}
				if (bsstand.isHaveLocalSerial()) {
					scab.setLocalserial(bsstand.getLocalserial());
				} else {
					scab.setLocalserial(null);
				}
				scab.setNotes(bsstand.getComment());
				scab.setBoxed(new Boolean(false));
				scab.setBroken(new Boolean(bsstand.isBroken()));
				scab.setObjectStatus(bsstand.getRecordStatus());
				scab.commitCopyHelper();
				CfgBsstandsAccessBean bssab = new CfgBsstandsAccessBean(doc.getConfigDest(), bsstand.getCode(),
					bsvo.getCode(), bsstand.getRecordStatus());
				bssab.setResource(new Integer(bsstand.getResource().getCode()));
				bssab.setStnomer(bsstand.getStandno());
				bssab.setObjectStatus(bsstand.getRecordStatus());
				bssab.setStoragecard(new Integer(scardid));
				bssab.setQty(new BigDecimal(1.0));
				bssab.commitCopyHelper();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				result = false;
			}
		}
		
		return result;
	}
	
	
	/**
	 * Updating basestation sectors 
	 * @param dm
	 * @return
	 */
	private boolean updateSectors(CfgDataModel dm) {
		boolean result = true;
		DocumentVO doc = dm.getDocument();
		BaseStationVO bsvo = dm.getBasestation();
		
		/*
		// Collect sectors from trxes
		ArrayList trxes = dm.getTrxes();
		Iterator it2 = trxes.iterator();
		int num_sect = 0;
		while (it2.hasNext()) {
			num_sect++;
			TrxVO trx = (TrxVO)it2.next();
			if ("A".equals(trx.getRecordStatus()) || "U".equals(trx.getRecordStatus())) {
				for (int i=0; i<5; i++) {
					SectorVO sect900 = trx.getSectorInDiap(SectorVO.DIAP900, i);
					if (sect900 != null)
						trx.setSectorInDiap(SectorVO.DIAP900, i, dm.findSector(sect900)); 
					SectorVO sect1800 = trx.getSectorInDiap(SectorVO.DIAP1800, i);
					if (sect1800 != null)
						trx.setSectorInDiap(SectorVO.DIAP1800, i, dm.findSector(sect1800)); 
				}
			}
		}
		
		// Collect sectors from antennes
		ArrayList antennes = dm.getAntennes();
		Iterator it = antennes.iterator();
		int num_ant = 0;
		while (it.hasNext()) {
			num_ant++;
			AntennaVO anten = (AntennaVO)it.next();
			//if (anten.getSector900() != null)
			//	System.out.println("SAVE BEFORE TRANS: Sect = " + anten.getSector900().getNamesect() + ", band=" + anten.getSector900().getBand());
			//if (anten.getSector1800() != null)
			//	System.out.println("SAVE BEFORE TRANS: Sect = " + anten.getSector1800().getNamesect() + ", band=" + anten.getSector1800().getBand());
			
			if ("A".equals(anten.getRecordStatus()) || "U".equals(anten.getRecordStatus())) {
				anten.setSector900(dm.findSector(anten.getSector900()));
				anten.setSector1800(dm.findSector(anten.getSector1800()));
			}
			//if (anten.getSector900() != null)
			//	System.out.println("SAVE AFTER TRANS: Sect = " + anten.getSector900().getNamesect() + ", band=" + anten.getSector900().getBand());
			//if (anten.getSector1800() != null)
			//	System.out.println("SAVE AFTER TRANS: Sect = " + anten.getSector1800().getNamesect() + ", band=" + anten.getSector1800().getBand());
		}
		*/
		
		// Save sectors
		Iterator it1 = dm.getSectors().keySet().iterator();
		while (it1.hasNext()) {
			SectorVO sect = (SectorVO)it1.next();
			try {
				if ("A".equals(sect.getRecordStatus()))
					sect.setIdsect((new KeyGeneratorAccessBean()).getNextKey("tables.sectors"));
				CfgSectorAccessBean sectab = new CfgSectorAccessBean(doc.getConfigDest(), sect.getIdsect(),
					bsvo.getCode(), sect.getNamesect(), sect.getBand(), sect.getNumsect(), 0, 
					sect.getRecordStatus());
				sectab.setLac(sect.getLac());
				sectab.setCellname(sect.getCellname());
				sectab.setAzimut(sect.getAzimut());
				sectab.commitCopyHelper();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				result = false;
			}
		}
		
		return result;
	}
	
	/**
	 * Updating basestation TRX 
	 * @param dm
	 * @return
	 */
	private boolean updateTRX(CfgDataModel dm) {
		boolean result = true;
		DocumentVO doc = dm.getDocument();
		BaseStationVO bsvo = dm.getBasestation();
		
		ArrayList trxes = dm.getTrxes();
		Iterator it = trxes.iterator();
		while (it.hasNext()) {
			TrxVO trx = (TrxVO)it.next();
			try {
				if ("A".equals(trx.getRecordStatus())) {
					trx.setIdtrx((new KeyGeneratorAccessBean()).getNextKey("tables.trx"));
				}
				// Create storagecard
				int scardid;
				if (trx.getStoragecard() != null)
					scardid = trx.getStoragecard().intValue();
				 else
					scardid = (new KeyGeneratorAccessBean()).getNextKey("tables.storagecards");
				int owner = AppUtils.getNamedValueInt("DefaultOwner"); // Get default owner here, as owning not fully supported 
				CfgStoragecardAccessBean scab = new CfgStoragecardAccessBean(doc.getConfigDest(),
					scardid, trx.getResource().getCode(), new java.sql.Date(new java.util.Date().getTime()),
					owner, "S", "N", new java.math.BigDecimal(1), 
					new java.math.BigDecimal(0),
					!trx.isHaveSerial(), false, trx.getRecordStatus()
					);
				if (trx.isHaveSerial()) {
					scab.setIsfictserial(false);
					scab.setSerialnumber(trx.getSerialnumber());
				} else {
					scab.setIsfictserial(true);
					scab.setSerialnumber("");
				}
				if (trx.isHaveInventSerial()) {
					scab.setInventserial(trx.getInventserial());
				} else {
					scab.setInventserial(null);
				}
				if (trx.isHaveLocalSerial()) {
					scab.setLocalserial(trx.getLocalserial());
				} else {
					scab.setLocalserial(null);
				}
				scab.setNotes(trx.getComment());
				scab.setBoxed(new Boolean(false));
				scab.setBroken(new Boolean(trx.isBroken()));
				scab.setObjectStatus(trx.getRecordStatus());
				scab.commitCopyHelper();
				CfgTrxAccessBean trxab = new CfgTrxAccessBean(doc.getConfigDest(), bsvo.getCode(),
					trx.getIdtrx(), trx.getResource().getCode(), trx.getBsstand().getCode(), trx.getRecordStatus());
				trxab.setResource(trx.getResource().getCode());
				System.out.println("in trx bsstand code=" + trx.getBsstand().getCode());
				trxab.setStandid(trx.getBsstand().getCode());
				trxab.setObjectstatus(trx.getRecordStatus());
				trxab.setStoragecard(new Integer(scardid));
				trxab.setQty(new java.math.BigDecimal(1));
				trxab.commitCopyHelper();
				for (int i=0; i<5; i++) {
					SectorVO sect = dm.findSector(trx.getSectorInDiap(SectorVO.DIAP900, i));
					//if (sect != null)
					//	System.out.println("Sect = " + sect.getIdsect() + ", LET = " + sect.getNamesect() + ", band=" + sect.getBand() + ", i=" + i);
					//else
					//	System.out.println("Sect900 = null, i=" + i);
					createTRXSectorLink(doc.getConfigDest(), trx, sect);
					
					sect = dm.findSector(trx.getSectorInDiap(SectorVO.DIAP1800, i));
					//if (sect != null)
					//	System.out.println("Sect = " + sect.getIdsect() + ", LET = " + sect.getNamesect() + ", band=" + sect.getBand() + ", i=" + i);
					//else
					//	System.out.println("Sect1800 = null, i=" + i);
					createTRXSectorLink(doc.getConfigDest(), trx, sect);
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				result = false;
			}
		}
		
		return result;
	}
	
	private void createTRXSectorLink(int savConfigId, TrxVO trx, SectorVO sect) throws Exception {
		if (sect != null) {
			String recordStatus = "A";
			if ("D".equals(trx.getRecordStatus()))
				recordStatus = "D";
			CfgTrx2SectorAccessBean asab = new CfgTrx2SectorAccessBean(savConfigId,
				trx.getIdtrx(), sect.getIdsect(), recordStatus);
			asab.commitCopyHelper();
		}
	}
	
	/**
	 * Updating basestation antennes 
	 * @param dm
	 * @return
	 */
	private boolean updateAntennes(CfgDataModel dm) {
		boolean result = true;
		DocumentVO doc = dm.getDocument();
		BaseStationVO bsvo = dm.getBasestation();
		
		ArrayList antennes = dm.getAntennes();
		Iterator it = antennes.iterator();
		int num_ant = 0;
		while (it.hasNext()) {
			num_ant++;
			AntennaVO anten = (AntennaVO)it.next();
			try {
				if ("A".equals(anten.getRecordStatus())) {
					anten.setCode((new KeyGeneratorAccessBean()).getNextKey("tables.antennes"));
				}
				// Create storagecard
				int scardid;
				if (anten.getStoragecard() != null)
					scardid = anten.getStoragecard().intValue();
				 else
					scardid = (new KeyGeneratorAccessBean()).getNextKey("tables.storagecards");
				int owner = AppUtils.getNamedValueInt("DefaultOwner"); // Get default owner here, as owning not fully supported 
				CfgStoragecardAccessBean scab = new CfgStoragecardAccessBean(doc.getConfigDest(),
					scardid, anten.getResource().getCode(), new java.sql.Date(new java.util.Date().getTime()),
					owner, "S", "N", new java.math.BigDecimal(1), 
					new java.math.BigDecimal(0),
					!anten.isHaveSerial(), false, anten.getRecordStatus()
					);
				if (anten.isHaveSerial()) {
					scab.setIsfictserial(false);
					scab.setSerialnumber(anten.getSerialnumber());
				} else {
					scab.setIsfictserial(true);
					scab.setSerialnumber("");
				}
				if (anten.isHaveInventSerial()) {
					scab.setInventserial(anten.getInventserial());
				} else {
					scab.setInventserial(null);
				}
				if (anten.isHaveLocalSerial()) {
					scab.setLocalserial(anten.getLocalserial());
				} else {
					scab.setLocalserial(null);
				}
				scab.setNotes(anten.getComment());
				scab.setBoxed(new Boolean(false));
				scab.setBroken(new Boolean(anten.isBroken()));
				scab.setObjectStatus(anten.getRecordStatus());
				scab.commitCopyHelper();
				String kind_ant = calcKindAnt(anten.getKindant900().getValue(), anten.getKindant1800().getValue());
				if ( (kind_ant == null) || (kind_ant.trim().length() == 0) )
					kind_ant = "D";
				//System.out.println("Kind900=" + anten.getKindant900().getValue() + ", Kind1800=" + anten.getKindant1800().getValue() + ", Kind=" + kind_ant);
				CfgAntennaAccessBean antab = new CfgAntennaAccessBean(doc.getConfigDest(), anten.getCode(),
				anten.getResource().getCode(), ""+num_ant, kind_ant,
				anten.getNakl(), anten.getAzimuth(), anten.getHset(), new java.math.BigDecimal(0),
				bsvo.getCode(), true, anten.getLocationtype().getValue(), 0, anten.getRecordStatus());
				//antab.setKindant900(anten.getKindant900().getValue());
				//antab.setKindant1800(anten.getKindant1800().getValue());
				antab.setCommcable(new Boolean(anten.isCommoncable()));
				//antab.setKsvn900(anten.getKsvn900());
				//antab.setKsvn1800(anten.getKsvn1800());
				antab.setObjectStatus(anten.getRecordStatus());
				antab.setStorageCard(new Integer(scardid));
				antab.commitCopyHelper();
				
				CfgAntennaWorkBandAccessBean awbab900 = new CfgAntennaWorkBandAccessBean(doc.getConfigDest(), 
					anten.getCode(), SectorVO.DIAP900, "A");
				awbab900.setKswn(anten.getKsvn900());
				awbab900.setKind_ant(anten.getKindant900().getValue());
				awbab900.commitCopyHelper();
				
				CfgAntennaWorkBandAccessBean awbab1800 = new CfgAntennaWorkBandAccessBean(doc.getConfigDest(), 
					anten.getCode(), SectorVO.DIAP1800, "A");
				awbab1800.setKswn(anten.getKsvn1800());
				awbab1800.setKind_ant(anten.getKindant1800().getValue());
				awbab1800.commitCopyHelper();
				
				SectorVO sect900 = anten.getSector900();
				if (sect900 != null) {
					String recordStatus = "A";
					if ("D".equals(anten.getRecordStatus()))
						recordStatus = "D";
					//System.out.println("Sect = " + sect900.getNamesect() + ", band=" + sect900.getBand());
					CfgAnten2SectorAccessBean asab = new CfgAnten2SectorAccessBean(doc.getConfigDest(),
						anten.getCode(), sect900.getIdsect(), 0, recordStatus);
				}
				SectorVO sect1800 = anten.getSector1800();
				if (sect1800 != null) {
					String recordStatus = "A";
					if ("D".equals(anten.getRecordStatus()))
						recordStatus = "D";
					//System.out.println("Sect = " + sect1800.getNamesect() + ", band=" + sect1800.getBand());
					CfgAnten2SectorAccessBean asab = new CfgAnten2SectorAccessBean(doc.getConfigDest(),
						anten.getCode(), sect1800.getIdsect(), 0, recordStatus);
				}
				
				// Delete old antenna cables
				if ("U".equals(anten.getRecordStatus())) {
					CDBCResultSet rs = CDBCConfigObject.findCablesForAntenna(dm.getDocument().getConfigSource(), anten.getCode());
					Iterator it2 = rs.listIterator();
					while (it2.hasNext()) {
						CDBCRowObject ro = (CDBCRowObject)it2.next();
						Integer scard = (Integer)ro.getColumn("storagecard").asObject();
						if (scard != null) { 
							Integer resource = (Integer)ro.getColumn("cableres").asObject(); 
							BigDecimal len = (BigDecimal)ro.getColumn("len_cable").asObject(); 
							int scard1;
							scard1 = (new KeyGeneratorAccessBean()).getNextKey("tables.storagecards");
							int owner1 = AppUtils.getNamedValueInt("DefaultOwner"); // Get default owner here, as owning not fully supported 
							CfgStoragecardAccessBean scab1 = new CfgStoragecardAccessBean(doc.getConfigDest(),
								scard1, resource.intValue(), new java.sql.Date(new java.util.Date().getTime()),
								owner, "B", "N", len, 
								new java.math.BigDecimal(0),
								false, false, "A"
								);
							scab1.setObjectStatus("D");
							scab1.commitCopyHelper();
						}
					}
				}
				
				// Create antenna cables
				if ( (anten.getCable1() != null) && (anten.getCable1().getCode() != 0) ) {
					// Create storagecard
					int scard1;
					scard1 = (new KeyGeneratorAccessBean()).getNextKey("tables.storagecards");
					int owner1 = AppUtils.getNamedValueInt("DefaultOwner"); // Get default owner here, as owning not fully supported 
					CfgStoragecardAccessBean scab1 = new CfgStoragecardAccessBean(doc.getConfigDest(),
						scard1, anten.getCable1().getCode(), new java.sql.Date(new java.util.Date().getTime()),
						owner, "B", "N", anten.getCablen1(), 
						new java.math.BigDecimal(0),
						false, false, "A"
						);
					scab1.setBoxed(new Boolean(false));
					scab1.setBroken(new Boolean(false));
					if ("U".equals(anten.getRecordStatus()) || "A".equals(anten.getRecordStatus()))
						scab1.setObjectStatus("A");
					else
						scab1.setObjectStatus(anten.getRecordStatus());
					scab1.commitCopyHelper();
					int cabcode = (new KeyGeneratorAccessBean()).getNextKey("tables.antennacables");
					CfgAntennaCableAccessBean acab = new CfgAntennaCableAccessBean(doc.getConfigDest(),
						cabcode, anten.getCode(), anten.getCable1().getCode(), 
						anten.getCablen1(), 0, "A");
					acab.setStoragecard(new Integer(scard1));
					acab.setQty(anten.getCablen1());
					acab.commitCopyHelper();
				}
				if ( (anten.getCable2() != null) && (anten.getCable2().getCode() != 0) ) {
					// Create storagecard
					int scard1;
					scard1 = (new KeyGeneratorAccessBean()).getNextKey("tables.storagecards");
					int owner1 = AppUtils.getNamedValueInt("DefaultOwner"); // Get default owner here, as owning not fully supported 
					CfgStoragecardAccessBean scab1 = new CfgStoragecardAccessBean(doc.getConfigDest(),
						scard1, anten.getCable2().getCode(), new java.sql.Date(new java.util.Date().getTime()),
						owner, "B", "N", anten.getCablen2(), 
						new java.math.BigDecimal(0),
						false, false, "A"
						);
					scab1.setBoxed(new Boolean(false));
					scab1.setBroken(new Boolean(false));
					if ("U".equals(anten.getRecordStatus()) || "A".equals(anten.getRecordStatus()))
						scab1.setObjectStatus("A");
					else
						scab1.setObjectStatus(anten.getRecordStatus());
					scab1.commitCopyHelper();
					int cabcode = (new KeyGeneratorAccessBean()).getNextKey("tables.antennacables");
					CfgAntennaCableAccessBean acab = new CfgAntennaCableAccessBean(doc.getConfigDest(),
						cabcode, anten.getCode(), anten.getCable2().getCode(), 
						anten.getCablen2(), 0, "A");
					acab.setStoragecard(new Integer(scard1));
					acab.setQty(anten.getCablen2());
					acab.commitCopyHelper();
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				result = false;
			}
		}
		
		return result;
	}
	
	private String calcKindAnt(String kindAnt900, String kindAnt1800) {
		if ( (kindAnt900 == null) || (kindAnt900.trim().length() == 0) )
			return kindAnt1800;
		else if ( (kindAnt1800 == null)  || (kindAnt1800.trim().length() == 0) )
			return kindAnt900;
		else if (kindAnt900.equals(kindAnt1800))
			return kindAnt1800;
		else
			return "D";
	}

	private boolean recodeOtherEquipParents(CfgDataModel dm) {
		boolean result = true;
		HashMap resequip = new HashMap();
		
		// Move parent records (parentobject is null)
		System.out.println("### Recode parents start");
		Iterator itc = dm.getOtherequip().keySet().iterator();
		while (itc.hasNext()) {
			EquipObjectKeyVO key = (EquipObjectKeyVO)itc.next();
			if (key.getParentObject() == null) {
				System.out.println("### Recode parents get key with null parent, categ=" + key.getIdequipcategory());
				ArrayList equips = (ArrayList)dm.getOtherequip().get(key);
				if (equips != null) {
					System.out.println("### Recode parents have children");
					Iterator it = equips.iterator();
					while (it.hasNext()) {
						EquipObjectVO eovo = (EquipObjectVO)it.next();
						int oldId = eovo.getIdequipobject();
						System.out.println("### Recode parents children, id=" + oldId);
						if (oldId <= 0) {
							try {
								eovo.setIdequipobject((new KeyGeneratorAccessBean()).getNextKey("tables.equipobjectscfg"));
								System.out.println("Assigning new key=" + eovo.getIdequipobject());
							} catch (Exception e) {
								e.printStackTrace(System.out);
								result = false;
							}
						}
						
						CDBCResultSet rs = CDBCConfigObject.findChildEquipcategories(key.getIdequipcategory());
						ListIterator itcat = rs.listIterator();
						while (itcat.hasNext()) {
							CDBCRowObject ro = (CDBCRowObject)itcat.next();
							EquipObjectKeyVO keychild = new EquipObjectKeyVO();
							keychild.setIdequipcategory(((Integer)ro.getColumn("classid").asObject()).intValue()); 
							keychild.setParentObject(new Integer(oldId));
							System.out.println("### Cycle category id=" + keychild.getIdequipcategory());
							if (oldId <= 0) {
								// Find child records for parent key
								ArrayList childequips = (ArrayList)dm.getOtherequip().get(keychild);
								if (childequips != null) {
									System.out.println("### Have child records, recode to id=" + eovo.getIdequipobject());
									try {
										EquipObjectKeyVO key2 = (EquipObjectKeyVO)keychild.clone();
										key2.setParentObject(new Integer(eovo.getIdequipobject()));
										resequip.put(key2, childequips);
									} catch (CloneNotSupportedException e) {
										e.printStackTrace(System.out);
										result = false;
									}
								}
							} else {
								// Find child records for parent key
								ArrayList childequips = (ArrayList)dm.getOtherequip().get(keychild);
								if (childequips != null) {
									System.out.println("### Have child records, store");
									resequip.put(keychild, childequips);
								}
							}
						}
					}
					resequip.put(key, equips);
				}
			} else {
				if (key.getParentObject().intValue() > 0) {
					ArrayList equips = (ArrayList)dm.getOtherequip().get(key);
					if (equips != null) {
						resequip.put(key, equips);
					}
				}
			}
		}
		if (result) {
			dm.setOtherequip(resequip);
			System.out.println("### Recode parents end - success");
		} else {
			System.out.println("### Recode parents end - error");
		}
		return result;
	}

	/**
	 * Updating Other Equipment 
	 * @param dm
	 * @return
	 */
	private boolean updateOtherEquip(CfgDataModel dm) {
		boolean result = true;
		DocumentVO doc = dm.getDocument();
		BaseStationVO bsvo = dm.getBasestation();
		
		if (!recodeOtherEquipParents(dm))
			result = false;
		else {
			Iterator itc = dm.getOtherequip().keySet().iterator();
			while (itc.hasNext()) {
				EquipObjectKeyVO key = (EquipObjectKeyVO)itc.next();
				ArrayList equips = (ArrayList)dm.getOtherequip().get(key);
				if (equips != null) {
					Iterator it = equips.iterator();
					while (it.hasNext()) {
						EquipObjectVO eovo = (EquipObjectVO)it.next();
						try {
							if ("A".equals(eovo.getRecordStatus()) && (eovo.getIdequipobject() <= 0) ) {
								//System.out.println("Before Saving OtherEquip, code = " + eovo.getIdequipobject());
								eovo.setIdequipobject((new KeyGeneratorAccessBean()).getNextKey("tables.equipobjectscfg"));
							}
							// Create storagecard
							int scardid;
							if (eovo.getStoragecard() != null)
								scardid = eovo.getStoragecard().intValue();
							 else
								scardid = (new KeyGeneratorAccessBean()).getNextKey("tables.storagecards");
							int owner = AppUtils.getNamedValueInt("DefaultOwner"); // Get default owner here, as owning not fully supported 
							CfgStoragecardAccessBean scab = new CfgStoragecardAccessBean(doc.getConfigDest(),
								scardid, eovo.getResource().getCode(), new java.sql.Date(new java.util.Date().getTime()),
								owner, eovo.getResource().getPolicy(), "N", eovo.getQty(), 
								new java.math.BigDecimal(0),
								!eovo.isHaveSerial(), false, eovo.getRecordStatus()
								);
							if (eovo.isHaveSerial()) {
								scab.setIsfictserial(false);
								scab.setSerialnumber(eovo.getSerialnumber());
							} else {
								scab.setIsfictserial(true);
								scab.setSerialnumber("");
							}
							if (eovo.isHaveInventSerial()) {
								scab.setInventserial(eovo.getInventserial());
							} else {
								scab.setInventserial(null);
							}
							if (eovo.isHaveLocalSerial()) {
								scab.setLocalserial(eovo.getLocalserial());
							} else {
								scab.setLocalserial(null);
							}
							scab.setNotes(eovo.getComment());
							scab.setBoxed(new Boolean(false));
							scab.setBroken(new Boolean(eovo.isBroken()));
							scab.setObjectStatus(eovo.getRecordStatus());
							scab.commitCopyHelper();
							System.out.println("Saving EquipObject with code = " + eovo.getIdequipobject());
							CfgEquipObjectsCfgAccessBean eoab = new CfgEquipObjectsCfgAccessBean(doc.getConfigDest(), eovo.getIdequipobject(),
								bsvo.getCode(), eovo.getRecordStatus());
							eoab.setStoragecard(new Integer(scardid));
							eoab.setQty(eovo.getQty());
							eoab.setParentobjcfgid(key.getParentObject());
							eoab.commitCopyHelper();
							for (int i=0; i<5; i++) {
								SectorVO sect = dm.findSector(eovo.getSectorInDiap(SectorVO.DIAP900, i));
								createOtherEquipSectorLink(doc.getConfigDest(), eovo, sect);
					
								sect = dm.findSector(eovo.getSectorInDiap(SectorVO.DIAP1800, i));
								createOtherEquipSectorLink(doc.getConfigDest(), eovo, sect);
							}
						} catch (Exception e) {
							e.printStackTrace(System.out);
							result = false;
						}
					}
				}
			}
		}
		
		return result;
	}
	
	private void createOtherEquipSectorLink(int savConfigId, EquipObjectVO eovo, SectorVO sect) throws Exception {
		if (sect != null) {
			String recordStatus = "A";
			if ("D".equals(eovo.getRecordStatus()))
				recordStatus = "D";
			CfgEquipObjCfg2SectorAccessBean asab = new CfgEquipObjCfg2SectorAccessBean(savConfigId,
				eovo.getIdequipobject(), sect.getIdsect(), recordStatus);
			asab.commitCopyHelper();
		}
	}
	
	private boolean doValidateDocument(CfgDataModel dm) {
		boolean result = true;
		
		if (!doValidateSectors(dm))
			result = false;
		if (!doValidateBSStands(dm))
			result = false;
		if (!doValidateTRX(dm))
			result = false;
		if (!doValidateAntennes(dm))
			result = false;
		if (!doValidateOtherEquip(dm))
			result = false;
		
		return result;
	}
	
	private boolean doValidateSectors(CfgDataModel dm) {
		boolean result = true;
		
		// Check sector fields
		List sectar = new ArrayList(dm.getSectors().keySet());
		Collections.sort(sectar);
		Iterator it2 = sectar.iterator();
		int line = 0;
		while (it2.hasNext()) {
			line++;
			SectorVO sect = (SectorVO)it2.next();
			if ( (sect.getNumsect() == null) || (sect.getNumsect().trim().length() <= 0) ) {
				ConfigError err = new ConfigError("Сектор " + sect.getNamesect() + 
					": не указано Cell ID", ConfigError.SECTORS, line);
				dm.getSaveErrors().add(err);
				result = false;
			}
			if ( sect.getCellname() == null ) {
				ConfigError err = new ConfigError("Сектор " + sect.getNamesect() + 
					": не указано Cell Name", ConfigError.SECTORS, line);
				dm.getSaveErrors().add(err);
				result = false;
			}
			if ( sect.getBand() == 0 ) {
				ConfigError err = new ConfigError("Сектор " + sect.getNamesect() + 
					": не указан диапазон", ConfigError.SECTORS, line);
				dm.getSaveErrors().add(err);
				result = false;
			}
			if ( (sect.getNamesect() == null) || (sect.getNamesect().trim().length() <= 0) ) {
				ConfigError err = new ConfigError("Сектор " + sect.getNamesect() + 
					": не указано наименование сектора", ConfigError.SECTORS, line);
				dm.getSaveErrors().add(err);
				result = false;
			}
			if ( sect.getAzimut() == null ) {
				ConfigError err = new ConfigError("Сектор " + sect.getNamesect() + 
					": не указан азимут", ConfigError.SECTORS, line);
				dm.getSaveErrors().add(err);
				result = false;
			}
			
			if ( (sect.getBand() == SectorVO.DIAP900) && ("A".equals(sect.getNamesect()) || 
				"B".equals(sect.getNamesect()) || "C".equals(sect.getNamesect()) || "D".equals(sect.getNamesect()) )) {
					ConfigError err = new ConfigError("Сектор " + sect.getNamesect() + 
						": диапазон 900 может содержать только сектора E,F,G,H,O", ConfigError.SECTORS, line);
					dm.getSaveErrors().add(err);
					result = false;
			}
			if ( (sect.getBand() == SectorVO.DIAP1800) && ("E".equals(sect.getNamesect()) || 
				"F".equals(sect.getNamesect()) || "G".equals(sect.getNamesect()) || "H".equals(sect.getNamesect()) )) {
					ConfigError err = new ConfigError("Сектор " + sect.getNamesect() + 
						": диапазон 1800 может содержать только сектора A,B,C,D,O", ConfigError.SECTORS, line);
					dm.getSaveErrors().add(err);
					result = false;
			}
		}
		
		//check if all sector used
		Map sectors = (Map) dm.getSectors().clone();

		List antennes = dm.getAntennes();
		for (int i=0; i<antennes.size(); i++) {
			AntennaVO antennaVO = (AntennaVO) antennes.get(i);
			sectors.remove(antennaVO.getSector900());
			sectors.remove(antennaVO.getSector1800());
		}

		List trxes = dm.getTrxes();
		for (int i=0; i<trxes.size(); i++) {
			TrxVO trxVO = (TrxVO) trxes.get(i);

			SectorVO[] sectors900 = trxVO.getSectors900();
			for (int j = 0; j < sectors900.length; j++) {
				if (sectors900[j] != null) {
					sectors.remove(sectors900[j]);
				}
			}

			SectorVO[] sectors1800 = trxVO.getSectors1800();
			for (int j = 0; j < sectors1800.length; j++) {
				if (sectors1800[j] != null) {
					sectors.remove(sectors1800[j]);
				}
			}
		}

		Iterator itc = dm.getOtherequip().keySet().iterator();
		while (itc.hasNext()) {
			EquipObjectKeyVO key = (EquipObjectKeyVO)itc.next();
			ArrayList equips = (ArrayList)dm.getOtherequip().get(key);
			if (equips != null) {
				Iterator it = equips.iterator();
				while (it.hasNext()) {
					EquipObjectVO eovo = (EquipObjectVO)it.next();
					SectorVO[] sectors900 = eovo.getSectors900();
					for (int j = 0; j < sectors900.length; j++) {
						if (sectors900[j] != null) {
							sectors.remove(sectors900[j]);
						}
					}

					SectorVO[] sectors1800 = eovo.getSectors1800();
					for (int j = 0; j < sectors1800.length; j++) {
						if (sectors1800[j] != null) {
							sectors.remove(sectors1800[j]);
						}
					}
				}
			}
		}
		
		Iterator it = sectar.iterator();
		line = 0;
		while (it.hasNext()) {
			line++;								
			SectorVO sectorVO = (SectorVO)it.next();
			if (sectors.get(sectorVO) != null) {
				ConfigError err = new ConfigError("Сектор " + sectorVO.getNamesect() + 
					" открыт, но не содержит оборудования", ConfigError.SECTORS, line);
				dm.getSaveErrors().add(err);
				result = false;
			}
		}

		return result;
	}
		
	private boolean doValidateBSStands(CfgDataModel dm) {
		boolean result = true;
		
		ArrayList bsstands = dm.getBSStands();
		Iterator it = bsstands.iterator();
		int line = 0;
		while (it.hasNext()) {
			line++;
			BSStandVO bsstand = (BSStandVO)it.next();
			if (!"D".equals(bsstand.getRecordStatus())) {
				/*
				if (
					( (!bsstand.isHaveSerial()) && ((bsstand.getSerialnumber() == null) || (bsstand.getSerialnumber().trim().length() == 0)) ) &&
					( (!bsstand.isHaveInventSerial()) && ((bsstand.getInventserial() == null) || (bsstand.getInventserial().trim().length() == 0)) ) &&
					( (!bsstand.isHaveLocalSerial()) && ((bsstand.getLocalserial() == null) || (bsstand.getLocalserial().trim().length() == 0)) ) 
				) {
				*/
				if ( ("S".equals(bsstand.getCountPolicy())) && (bsstand.isEmptySerials()) ) {
					ConfigError err = new ConfigError("Не указаны серийные номера", ConfigError.BSSTANDS, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if ( (bsstand.getResource() == null) || (bsstand.getResource().getCode() == 0) ) {
					ConfigError err = new ConfigError("Не указан тип шкафа", ConfigError.BSSTANDS, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if ( (bsstand.getStandno() == null) || (bsstand.getStandno().trim().length() == 0) ) {
					ConfigError err = new ConfigError("Не указан номер шкафа", ConfigError.BSSTANDS, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
			}
		}
		
		return result;
	}
	
	private boolean doValidateTRX(CfgDataModel dm) {
		boolean result = true;
		
		ArrayList trxes = dm.getTrxes();
		Iterator it = trxes.iterator();
		int line = 0;
		while (it.hasNext()) {
			line++;
			TrxVO trx = (TrxVO)it.next();
			if (!"D".equals(trx.getRecordStatus())) {
				/*
				if (
					( (!trx.isHaveSerial()) && ((trx.getSerialnumber() == null) || (trx.getSerialnumber().trim().length() == 0)) ) &&
					( (!trx.isHaveInventSerial()) && ((trx.getInventserial() == null) || (trx.getInventserial().trim().length() == 0)) ) &&
					( (!trx.isHaveLocalSerial()) && ((trx.getLocalserial() == null) || (trx.getLocalserial().trim().length() == 0)) ) 
				) {
				*/
				if ( ("S".equals(trx.getCountPolicy())) && (trx.isEmptySerials()) ) {
					ConfigError err = new ConfigError("Не указаны серийные номера", ConfigError.TRX, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if ( (trx.getResource() == null) || (trx.getResource().getCode() == 0) ) {
					ConfigError err = new ConfigError("Не указан тип трансивера", ConfigError.TRX, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if ((trx.getBsstand() == null) || (trx.getBsstand().getCode() == 0) ) {
					ConfigError err = new ConfigError("Не указан номер шкафа", ConfigError.TRX, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
			}
		}
		
		return result;
	}
	
	private boolean doValidateAntennes(CfgDataModel dm) {
		boolean result = true;
		
		ArrayList antennes = dm.getAntennes();
		Iterator it = antennes.iterator();
		int line = 0;
		while (it.hasNext()) {
			line++;
			AntennaVO anten = (AntennaVO)it.next();
			if (!"D".equals(anten.getRecordStatus())) {
				/*
				if (
					( (!anten.isHaveSerial()) && ((anten.getSerialnumber() == null) || (anten.getSerialnumber().trim().length() == 0)) ) &&
					( (!anten.isHaveInventSerial()) && ((anten.getInventserial() == null) || (anten.getInventserial().trim().length() == 0)) ) &&
					( (!anten.isHaveLocalSerial()) && ((anten.getLocalserial() == null) || (anten.getLocalserial().trim().length() == 0)) ) 
				) {
				*/
				if ( ("S".equals(anten.getCountPolicy())) && (anten.isEmptySerials()) ) {
					ConfigError err = new ConfigError("Не указаны серийные номера", ConfigError.ANTENNES, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if ( (anten.getResource() == null) || (anten.getResource().getCode() == 0) ) {
					ConfigError err = new ConfigError("Не указан тип антенны", ConfigError.ANTENNES, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if (anten.getAzimuth() == null) {
					ConfigError err = new ConfigError("Не указан азимут", ConfigError.ANTENNES, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if (anten.getHset() == null) {
					ConfigError err = new ConfigError("Не указана высота подвеса", ConfigError.ANTENNES, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if (anten.getNakl() == null) {
					ConfigError err = new ConfigError("Не указан мех. наклон", ConfigError.ANTENNES, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if ( (anten.getCable1() != null) && (anten.getCable1().getCode() != 0) && (anten.getCablen1() == null) ) {
					ConfigError err = new ConfigError("Не указана длина кабеля 1", ConfigError.ANTENNES, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if ( (anten.getCable2() != null) && (anten.getCable2().getCode() != 0) && (anten.getCablen2() == null) ) {
					ConfigError err = new ConfigError("Не указана длина кабеля 2", ConfigError.ANTENNES, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if ( (anten.getCablen1() != null) && ((anten.getCable1() == null) || (anten.getCable1().getCode() == 0)) ) {
					ConfigError err = new ConfigError("Не указан тип кабеля 1", ConfigError.ANTENNES, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
				if ( (anten.getCablen2() != null) && ((anten.getCable2() == null) || (anten.getCable2().getCode() == 0)) ) {
					ConfigError err = new ConfigError("Не указан тип кабеля 2", ConfigError.ANTENNES, line);
					dm.getSaveErrors().add(err);
					result = false;
				}
			}
		}
		
		return result;
	}

	private boolean doValidateOtherEquip(CfgDataModel dm) {
		boolean result = true;
		
		Iterator itc = dm.getOtherequip().keySet().iterator();
		while (itc.hasNext()) {
			EquipObjectKeyVO key = (EquipObjectKeyVO)itc.next();
			ArrayList otherequip = (ArrayList)dm.getOtherequip().get(key);
			if (otherequip != null) {
				EquipCategoryVO equipcateg = CDBCConfigObject.findEquipcategory(key.getIdequipcategory());
				int line = 0;
				Iterator it = otherequip.iterator();
				while (it.hasNext()) {
					line++;
					EquipObjectVO eovo = (EquipObjectVO)it.next();
					if (!"D".equals(eovo.getRecordStatus())) {
						/*
						if (
							( (!eovo.isHaveSerial()) && ((eovo.getSerialnumber() == null) || (eovo.getSerialnumber().trim().length() == 0)) ) &&
							( (!eovo.isHaveInventSerial()) && ((eovo.getInventserial() == null) || (eovo.getInventserial().trim().length() == 0)) ) &&
							( (!eovo.isHaveLocalSerial()) && ((eovo.getLocalserial() == null) || (eovo.getLocalserial().trim().length() == 0)) ) 
						) {
						*/
						if ( ("S".equals(eovo.getCountPolicy())) && (eovo.isEmptySerials()) ) {
							ConfigError err = new ConfigError("Не указаны серийные номера", equipcateg.toString(), line);
							dm.getSaveErrors().add(err);
							result = false;
						}
						if ( (eovo.getResource() == null) || (eovo.getResource().getCode() == 0) ) {
							ConfigError err = new ConfigError("Не указан тип оборудования", equipcateg.toString(), line);
							dm.getSaveErrors().add(err);
							result = false;
						}
						if ( (eovo.getQty() == null) || eovo.getQty().equals(new BigDecimal(0)) ) {
							ConfigError err = new ConfigError("Не указано количество", equipcateg.toString(), line);
							dm.getSaveErrors().add(err);
							result = false;
						}
					}
				}
			}
		}
		
		return result;
	}
}
