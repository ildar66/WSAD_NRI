package com.hps.july.inventory.sessionbean;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import com.hps.july.persistence.*;
import com.hps.july.persistence2.*;
import java.util.*;
import com.hps.july.commonbean.*;

/**
 * This is a Session Bean Class
 * Процессор актов монтажа АФС
 */
public class AfsActProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
	private final static String ANTENNES_KEY = "tables.antennes";
	private final static String ANTENWORKBAND_KEY = "tables.antennesworkbands";
	private final static String ANTENACABLE_KEY = "tables.antennacables";
	private final static String SECTORS_KEY = "tables.sectors";
	private final static String ANT2SECT_KEY = "tables.anten2sectors";
	private final static short SECT_BAND_NONE = (short)0;
	private final static short SECT_BAND_800 = (short)800;
	private final static short SECT_BAND_900 = (short)900;
	private final static short SECT_BAND_1800 = (short)1800;
	private final static short SECT_BAND_2000 = (short)2000;
	
		// AFS Mount Act calculation	

		public void applyAFSInfo(Integer argDocument, boolean recreateAddInfo) throws java.rmi.RemoteException {
		try {

			Integer equipmentCode = determineEquipmentCode(argDocument);
			
			// Find antennes array
			HashMap antennes = getAntennes(argDocument, equipmentCode);

			// Find sectors array
			HashMap sectors = getSectors(argDocument, equipmentCode);
			
			// Find links
			ArrayList ant2sect = getAnt2Sectors(antennes, sectors);
			
			if (recreateAddInfo) {
				// Delete old Antennes & Sectors
				deleteAnt2Sectors(ant2sect);
				deleteSectors(sectors);
				deleteAntennes(antennes);
			}
			
			// Create New Antennes & sectors
			createAntennes(argDocument, equipmentCode, antennes, sectors, ant2sect);
			
		}catch( Exception e ) { 
			throw new java.rmi.RemoteException( "While processing AfsAct apply afsinfo.", e );
		}
	}
		// AFS Mount Act calculation	

		public DocumentProcessingException applyDocument(Integer argDocument, boolean recreateAddInfo) throws java.rmi.RemoteException {
		try {

			applyAFSInfo(argDocument, recreateAddInfo);
			
			// Call document processor
			RealDocumentProcessorAccessBean processor = new RealDocumentProcessorAccessBean();
			return processor.applyDocument(argDocument);
			
		}catch( Exception e ) { 
			throw new java.rmi.RemoteException( "While processing AfsAct apply document.", e );
		}
	}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2003 10:00:10)
 * @return short
 */
private short calcSectorBand(String argDocPosType, String argSectCode) {
	short result = (short) 0;
	if ("A".equalsIgnoreCase(argDocPosType)) {
		if (
			"A".equalsIgnoreCase(argSectCode) ||
			"B".equalsIgnoreCase(argSectCode) ||
			"C".equalsIgnoreCase(argSectCode) ||
			"D".equalsIgnoreCase(argSectCode) ||
			"O1800".equalsIgnoreCase(argSectCode) )
				result = SECT_BAND_1800;
		else if (
			"E".equalsIgnoreCase(argSectCode) ||
			"F".equalsIgnoreCase(argSectCode) ||
			"G".equalsIgnoreCase(argSectCode) ||
			"H".equalsIgnoreCase(argSectCode) ||
			"O".equalsIgnoreCase(argSectCode) )
				result = SECT_BAND_900;
	} else if ("B".equalsIgnoreCase(argDocPosType)) {
		result = SECT_BAND_800;
	}
	return result;
}
/**
 * Calculates name of GSM sector.
 * Creation date: (02.07.2003 9:52:47)
 * @return java.lang.String
 * @param argEquipmentCode java.lang.Integer
 * @param argSectCode java.lang.String
 */
private String calcSectorNameDAMPS(Integer argEquipmentCode, String argSectCode) {
	String result = "";
	try {
		if (argSectCode != null)
			result = argSectCode.substring(0, 1);
	} catch (Exception e) {
		System.out.println("AFS: Error while calculating DAMPS sector name");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Calculates name of GSM sector.
 * Creation date: (02.07.2003 9:52:47)
 * @return java.lang.String
 * @param argEquipmentCode java.lang.Integer
 * @param argSectCode java.lang.String
 */
private String calcSectorNameGSM(Integer argEquipmentCode, String argSectCode) {
	String result = "";
	try {
		BaseStationAccessBean bab = new BaseStationAccessBean();
		bab.setInitKey_storageplace(argEquipmentCode.intValue());
		bab.refreshCopyHelper();
		if (argSectCode != null)
			result = bab.getName() + "_" + argSectCode.substring(0, 1);
		else
			result = bab.getName();
	} catch (Exception e) {
		System.out.println("AFS: Error while calculating GSM sector name");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Calculates sector number by evristic algorithm.
 * Creation date: (01.07.2003 15:18:45)
 * @return int
 */
private String calcSectorNumber(Integer argEquipmentCode, String argDocPosType, String argSectCode) {

	String result = "";
	try {
		// GSM sectors
		String [][] sectGSM = new String [][] { {"A", "1"}, {"B", "2"}, {"C", "3"}, {"D", "4"}, {"O1800", "0"},
			{"E", "5"}, {"F", "6"}, {"G", "7"}, {"H", "8"}, {"O", "9"} };

		// DAMPS sectors
		String [][] sectDAMPS = new String [][] { {"A", "1"}, {"B", "2"}, {"C", "3"}, {"D", "4"}, {"O", "0"},
			{"E", "5"} };

			
		String sectNum = "";

		if ("A".equalsIgnoreCase(argDocPosType)) {
			// GSM position
			for (int i=0; i < sectGSM.length; i++)
				if (argSectCode.equalsIgnoreCase(sectGSM [i][0])) {
					sectNum = sectGSM [i][1];
					break;
				}
			BaseStationAccessBean bab = new BaseStationAccessBean();
			bab.setInitKey_storageplace(argEquipmentCode.intValue());
			bab.refreshCopyHelper();
			result = bab.getPrefixcellid() + sectNum;
		} else if ("B".equalsIgnoreCase(argDocPosType)) {
			// DAMPS position
			for (int i=0; i < sectDAMPS.length; i++)
				if (argSectCode.equalsIgnoreCase(sectDAMPS [i][0])) {
					sectNum = sectDAMPS [i][1];
					break;
				}
			result = sectNum;
		} 
			
		
	} catch (Exception e) {
		System.out.println("AFS: Error while calculating sector number");
		e.printStackTrace(System.out);
	}
	return result;
}
	/**
	 * Cancelation of Afs Mount act.
	 * Creation date: (22.07.2002 18:17:00)
	 * @param actCode java.lang.Integer
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public void cancelAFSInfo( Integer argDocument, boolean deleteAddInfo ) throws java.rmi.RemoteException {

		try {
			Integer equipmentCode = determineEquipmentCode(argDocument);
			
			// Find antennes array
			HashMap antennes = getAntennes(argDocument, equipmentCode);

			// Find sectors array
			HashMap sectors = getSectors(argDocument, equipmentCode);
			
			// Find links
			ArrayList ant2sect = getAnt2Sectors(antennes, sectors);

			// Check modification
			boolean wasModified = pureCheckAddInfoModification(argDocument, antennes, sectors, ant2sect);

			if ( (wasModified && deleteAddInfo) || !wasModified) {
				deleteAnt2Sectors(ant2sect);
				deleteSectors(sectors);
				deleteAntennes(antennes);
			} else {
				deleteAnt2SectorsAuto(ant2sect);
				deleteSectorsAuto(sectors);
				deleteAntennesAuto(antennes);
			}
			
		}catch( Exception e ) {
			throw new java.rmi.RemoteException( "While cancelling afsinfo.", e );
		}

	}
	/**
	 * Cancelation of Afs Mount act.
	 * Creation date: (22.07.2002 18:17:00)
	 * @param actCode java.lang.Integer
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public DocumentProcessingException cancelDocument( Integer argDocument, boolean deleteAddInfo ) throws java.rmi.RemoteException {

		try {
			cancelAFSInfo(argDocument, deleteAddInfo);
			
			// Call document processor
			RealDocumentProcessorAccessBean processor = new RealDocumentProcessorAccessBean();
			return processor.cancelDocument(argDocument);
			
		}catch( Exception e ) {
			throw new java.rmi.RemoteException( "While cancelling afsmountact.", e );
		}

	}
	/**
	 * Checking if Afs Mount act antennes or sectors were modified by hand.
	 * Creation date: (22.07.2002 18:17:00)
	 * @param actCode java.lang.Integer
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public boolean checkAddInfoModification(Integer argDocument) throws java.rmi.RemoteException {

		System.out.println("AFS: Check add info modification called");
		try {
			Integer equipmentCode = determineEquipmentCode(argDocument);
			
			// Find antennes array
			HashMap antennes = getAntennes(argDocument, equipmentCode);

			// Find sectors array
			HashMap sectors = getSectors(argDocument, equipmentCode);
			
			// Find links
			ArrayList ant2sect = getAnt2Sectors(antennes, sectors);

			// Check modification
			return pureCheckAddInfoModification(argDocument, antennes, sectors, ant2sect);
						
		}catch( Exception e ) {
			throw new java.rmi.RemoteException( "While checking add info modification in afsmountact.", e );
		}
	}
/**
 * Checks if Ant2Sectors was modified by hand.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean checkAnt2SectorsModification(ArrayList ant2sectors) {
	boolean result = false;
	try {
		Iterator it = ant2sectors.iterator();
		while (it.hasNext()) {
			Antena2sectorAccessBean a2sab = (Antena2sectorAccessBean)it.next();
			if (a2sab.getByhand().booleanValue()) {
				result = true;
				break;
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while checking ant2sectors modification");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Checks if Antennes was modified by hand.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean checkAntennesModification(HashMap antennes) {
	boolean result = false;
	try {
		Iterator it = antennes.values().iterator();
		while (it.hasNext()) {
			AntennaAccessBean aab = (AntennaAccessBean)it.next();
			if (aab.getByhand().booleanValue()) {
				result = true;
				break;
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while checking antennes modification");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Checks if sector belongs to document.
 * Creation date: (01.07.2003 15:18:45)
 * @return int
 */
private boolean checkSector(Integer argEquipmentCode, String argDocPosType, String argSectCode, Boolean useSectorCode, String argNumsect) {

	boolean result = false;

	if (Boolean.TRUE.equals(useSectorCode)) {
		String sectNum = calcSectorNumber(argEquipmentCode, argDocPosType, argSectCode);
		if (argNumsect.equalsIgnoreCase(sectNum))
			result = true;
	}

	return result;
}
/**
 * Checks if Sectors was modified by hand.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean checkSectorsModification(HashMap sectors) {
	boolean result = false;
	try {
		Iterator it = sectors.values().iterator();
		while (it.hasNext()) {
			SectorAccessBean sab = (SectorAccessBean)it.next();
			if (sab.getByhand().booleanValue()) {
				result = true;
				break;
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while checking sectors modification");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Create cables for antennes.
 * Creation date: (08.07.2003 9:44:12)
 */
private void createAntenaCables(AfsMountPosAccessBean afspab, int antcode) {

	try {
		// Create AntenaCable
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		java.util.Enumeration en = new AfsMountPosAccessBean().findChildrenByParent(new Integer(afspab.getDocposition()));
		AfsMountPosAccessBean cableab = null;
		while (en.hasMoreElements()) {
			cableab = (AfsMountPosAccessBean)en.nextElement();

			int accode = keygen.getNextKey(ANTENACABLE_KEY);
			AntennaCableAccessBean acabab = new AntennaCableAccessBean(accode, antcode, cableab.getResource().getResource(), cableab.getLen_cable());
			if (cableab.getGroundresource() != null) {
				acabab.setGroundresource(new Integer(cableab.getGroundresource().getResource()));
				acabab.setGroundcnt(cableab.getGroundcnt());
			}
			acabab.commitCopyHelper();
			
			// Create CableWorkParams
			if (cableab.getKsvn1800() != null) {
				CableWorkParamsAccessBean cwpab = new CableWorkParamsAccessBean((short)1800, antcode, accode);
				cwpab.setKsvn(cableab.getKsvn1800());
				cwpab.commitCopyHelper();
			} else if (cableab.getKsvn900() != null) {
				CableWorkParamsAccessBean cwpab = new CableWorkParamsAccessBean((short)900, antcode, accode);
				cwpab.setKsvn(cableab.getKsvn900());
				cwpab.commitCopyHelper();
			}
		}
		
	} catch (Exception e) {
		System.out.println("AFS: cannot create antenna cables");
		e.printStackTrace(System.out);
	}
}
/**
 * Create workbands for antennes.
 * Creation date: (08.07.2003 9:44:12)
 */
private void createAntenaWorkBands(AfsMountPosAccessBean afspab, int antcode) {
	boolean isBand1800 = false;
	boolean isBand900 = false;
	boolean isBand800 = false;

	try {

		if ("A".equalsIgnoreCase(afspab.getDocpostype())) {
			if (
				((afspab.getSectorA() != null) && afspab.getSectorA().booleanValue()) ||
				((afspab.getSectorB() != null) && afspab.getSectorB().booleanValue()) ||
				((afspab.getSectorC() != null) && afspab.getSectorC().booleanValue()) ||
				((afspab.getSectorD() != null) && afspab.getSectorD().booleanValue()) ||
				((afspab.getSectorO1800() != null) && afspab.getSectorO1800().booleanValue()) )
					isBand1800 = true;
			if (
				((afspab.getSectorE() != null) && afspab.getSectorE().booleanValue()) ||
				((afspab.getSectorF() != null) && afspab.getSectorF().booleanValue()) ||
				((afspab.getSectorG() != null) && afspab.getSectorG().booleanValue()) ||
				((afspab.getSectorH() != null) && afspab.getSectorH().booleanValue()) ||
				((afspab.getSectorO() != null) && afspab.getSectorO().booleanValue()) )
					isBand900 = true;
		} else if ("B".equalsIgnoreCase(afspab.getDocpostype())) {
			if (
				((afspab.getSectorA() != null) && afspab.getSectorA().booleanValue()) ||
				((afspab.getSectorB() != null) && afspab.getSectorB().booleanValue()) ||
				((afspab.getSectorC() != null) && afspab.getSectorC().booleanValue()) ||
				((afspab.getSectorD() != null) && afspab.getSectorD().booleanValue()) ||
				((afspab.getSectorE() != null) && afspab.getSectorE().booleanValue()) ||
				((afspab.getSectorO() != null) && afspab.getSectorO().booleanValue()) )
					isBand800 = true;
		}

		// Create workbands
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();

		if (isBand1800) {
			int wbcode = keygen.getNextKey(ANTENWORKBAND_KEY);
			AntennaWorkBandAccessBean awb = new AntennaWorkBandAccessBean(antcode, SECT_BAND_1800);
		}
		if (isBand900) {
			int wbcode = keygen.getNextKey(ANTENWORKBAND_KEY);
			AntennaWorkBandAccessBean awb = new AntennaWorkBandAccessBean(antcode, SECT_BAND_900);
		}
		if (isBand800) {
			int wbcode = keygen.getNextKey(ANTENWORKBAND_KEY);
			AntennaWorkBandAccessBean awb = new AntennaWorkBandAccessBean(antcode, SECT_BAND_800);
		}

	} catch (Exception e) {
		System.out.println("AFS: cannot create antenna work bands");
		e.printStackTrace(System.out);
	}
}
/**
 * Create antennes/sectors/links by positions of document.
 * Creation date: (01.07.2003 12:21:51)
 * @return java.util.ArrayList
 */
private void createAntennes(Integer argDocCode, Integer argEquipmentCode, HashMap antennes, HashMap sectors, ArrayList ant2sect) {

	KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
	HashMap ourSectors = new HashMap();
	try {
		Enumeration en = new AfsMountPosAccessBean().findDocPositionsByDocOrderByOrderAsc(argDocCode);
		while (en.hasMoreElements()) {
			AfsMountPosAccessBean afspab = (AfsMountPosAccessBean)en.nextElement();
			// Check for antena line
			if ("A".equalsIgnoreCase(afspab.getDocpostype()) || "B".equalsIgnoreCase(afspab.getDocpostype())) {

				// Create antenna if we does not have one
				AntennaAccessBean aab = (AntennaAccessBean)antennes.get(afspab.getNum_ant());
				if (aab == null) {
					int antcode = keygen.getNextKey(ANTENNES_KEY);
					java.math.BigDecimal lencable = new java.math.BigDecimal(0);
					if (afspab.getLen_cable() != null)
						lencable = afspab.getLen_cable();
					java.math.BigDecimal hset1 = new java.math.BigDecimal(0);
					if (afspab.getH_set1() != null)
						hset1 = afspab.getH_set1();
					java.math.BigDecimal azant = new java.math.BigDecimal(0);
					if (afspab.getAz_ant() != null)
						azant = afspab.getAz_ant();
					java.math.BigDecimal nakl = new java.math.BigDecimal(0);
					if (afspab.getNakl() != null)
						nakl = afspab.getNakl();
					aab = new AntennaAccessBean(antcode, afspab.getResourceKey().resource,
						afspab.getNum_ant(), afspab.getKind_ant(), nakl, azant,
						hset1, lencable, argEquipmentCode.intValue(), Boolean.FALSE);
					aab.setKswn(afspab.getKswn());
					aab.setAzvariation(afspab.getAz_variation());
					aab.setNaklvariation(afspab.getNakl_variation());
					aab.setInputpower(afspab.getInput_power());
					aab.commitCopyHelper();
					createAntenaWorkBands(afspab, antcode);
					createAntenaCables(afspab, antcode);
				}
				
				createSectors(afspab, aab, argEquipmentCode, ourSectors, sectors);
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: cannot create antennes");
		e.printStackTrace(System.out);
	}
}
/**
 * Creates new sector.
 * Creation date: (01.07.2003 15:18:45)
 * @return int
 */
private int createSector(AfsMountPosAccessBean afspab, AntennaAccessBean aab, String argDocPosType, 
		String argSectCode, Integer argEquipmentCode, HashMap ourSectors, HashMap sectors) {

	int sectcode = 0;
	try {
		SectorAccessBean sab = null;
		String sectNum = calcSectorNumber(argEquipmentCode, argDocPosType, argSectCode);
		// Check if sector exists
		if (ourSectors.containsKey(sectNum)) {
			sab = (SectorAccessBean)ourSectors.get(sectNum);
			sectcode = sab.getIdsect();
		} else {
			sab = (SectorAccessBean)sectors.get(sectNum);
			if (sab == null) {
				KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
				sectcode = keygen.getNextKey(SECTORS_KEY);
				String sectname = "";
				if ("A".equalsIgnoreCase(argDocPosType))
					sectname = calcSectorNameGSM(argEquipmentCode, argSectCode);
				else if ("B".equalsIgnoreCase(argDocPosType))
					sectname = calcSectorNameDAMPS(argEquipmentCode, argSectCode);
				short sectband = calcSectorBand(argDocPosType, argSectCode);
				sab = new SectorAccessBean(sectcode, aab.getEquipmentKey().storageplace, sectname, sectband,
					sectNum, Boolean.FALSE);
				sab.setAzimut(afspab.getAz_ant());
				sab.setDdk(afspab.getDdk());
				sab.setHasflt(afspab.getHas_flt());
				sab.setHasbuster(afspab.getHas_buster());
				sab.setHaslna(afspab.getHas_lna());
				sab.commitCopyHelper();
				ourSectors.put(sectNum, sab);
			} else {
				sectcode = sab.getIdsect();
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: cannot create sector");
		e.printStackTrace(System.out);
	}

	return sectcode;
}
/**
 * Create link between antenna & sector.
 * Creation date: (02.07.2003 10:27:42)
 * @param antcode int
 * @param sectcode int
 */
private void createSector2AntennaLink(int antcode, int sectcode) {
	try {
		Antena2sectorAccessBean a2sab = new Antena2sectorAccessBean(antcode, sectcode, Boolean.FALSE);
	} catch (javax.ejb.DuplicateKeyException ee) {
		// Link already exists - skip it
		System.out.println("AFS: a2s link already exists antenna=" + antcode + ", sector=" + sectcode);
	} catch (Exception e) {
		System.out.println("AFS: cannot create a2s link");
		e.printStackTrace(System.out);
	}
}
/**
 * Create sectors/links by positions of document.
 * Creation date: (01.07.2003 12:21:51)
 * @return java.util.ArrayList
 */
private void createSectors(AfsMountPosAccessBean afspab, AntennaAccessBean aab, 
		Integer argEquipmentCode, HashMap ourSectors, HashMap sectors) {

	try {

		String docPosType = afspab.getDocpostype();
		int antcode = aab.getIdanten();

		// Common GSM/DAMPS sectors	
		if ("A".equalsIgnoreCase(afspab.getDocpostype()) || "B".equalsIgnoreCase(afspab.getDocpostype())) {
			if ((afspab.getSectorA() != null) && (afspab.getSectorA().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "A", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
			if ((afspab.getSectorB() != null) && (afspab.getSectorB().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "B", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
			if ((afspab.getSectorC() != null) && (afspab.getSectorC().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "C", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
			if ((afspab.getSectorD() != null) && (afspab.getSectorD().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "D", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
			if ((afspab.getSectorE() != null) && (afspab.getSectorE().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "E", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
			if ((afspab.getSectorO() != null) && (afspab.getSectorO().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "O", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
		}

		// GSM only sectors
		if ("A".equalsIgnoreCase(afspab.getDocpostype())) {
			if ((afspab.getSectorF() != null) && (afspab.getSectorF().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "F", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
			if ((afspab.getSectorG() != null) && (afspab.getSectorG().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "G", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
			if ((afspab.getSectorH() != null) && (afspab.getSectorH().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "H", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
			if ((afspab.getSectorO1800() != null) && (afspab.getSectorO1800().booleanValue())) {
				int sectcode = createSector(afspab, aab, docPosType, "O1800", argEquipmentCode, ourSectors, sectors);
				createSector2AntennaLink(antcode, sectcode);
			}
		}
		
		// DAMPS only sectors
		if ("B".equalsIgnoreCase(afspab.getDocpostype())) {
			// No sectors yet
		}

	} catch (Exception e) {
		System.out.println("AFS: cannot create sectors / links");
		e.printStackTrace(System.out);
	}
}
/**
 * Deleteing Ant2Sectors.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean deleteAnt2Sectors(ArrayList ant2sectors) {
	boolean result = false;
	try {
		Iterator it = ant2sectors.iterator();
		while (it.hasNext()) {
			Antena2sectorAccessBean a2sab = (Antena2sectorAccessBean)it.next();
			a2sab.getEJBRef().remove();
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while deleting ant2sectors");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Deleteing Ant2Sectors.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean deleteAnt2Sectors(Enumeration ant2sectors) {
	boolean result = false;
	try {
		while (ant2sectors.hasMoreElements()) {
			Antena2sectorAccessBean a2sab = new Antena2sectorAccessBean((Antena2sector)javax.rmi.PortableRemoteObject.narrow(ant2sectors.nextElement(), Antena2sector.class));
			a2sab.getEJBRef().remove();
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while deleting ant2sectors");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Deletes Ant2Sectors not modified by hand.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean deleteAnt2SectorsAuto(ArrayList ant2sectors) {
	boolean result = false;
	try {
		Iterator it = ant2sectors.iterator();
		while (it.hasNext()) {
			Antena2sectorAccessBean a2sab = (Antena2sectorAccessBean)it.next();
			if (!a2sab.getByhand().booleanValue())
				a2sab.getEJBRef().remove();
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while deleting ant2sectors");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Checks if Antennes was modified by hand.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean deleteAntennes(HashMap antennes) {
	boolean result = false;
	try {
		Iterator it = antennes.values().iterator();
		while (it.hasNext()) {
			AntennaAccessBean aab = (AntennaAccessBean)it.next();
			// Delete cables for antennes
			Enumeration cabtbl = new AntennaCableAccessBean().findByAnten(new Integer(aab.getIdanten()));
			while (cabtbl.hasMoreElements()) {
				// Delete Cable Params
				AntennaCableAccessBean acabab = (AntennaCableAccessBean)cabtbl.nextElement();
				Enumeration cabpartbl = new CableWorkParamsAccessBean().findByCable(new Integer(acabab.getIdcable()));
				while (cabpartbl.hasMoreElements()) {
					CableWorkParamsAccessBean cwpab = (CableWorkParamsAccessBean)cabpartbl.nextElement();
					cwpab.getEJBRef().remove();
				}
				acabab.getEJBRef().remove();
			}
			// Delete workbands for antennes
			Enumeration aawbtbl = aab.getAntennaWorkBands();
			while (aawbtbl.hasMoreElements()) {
				AntennaWorkBand aawb = (AntennaWorkBand)javax.rmi.PortableRemoteObject.narrow(aawbtbl.nextElement(), AntennaWorkBand.class);
				aawb.remove();
			}
			// Remove all links from this antenna
			deleteAnt2Sectors(aab.getAntena2sectors());
			// Remove antenna itself
			try {
				aab.getEJBRef().remove();
			} catch (Exception ee) {
				System.out.println("AFS: Cannot remove antenna");
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while removing antennes");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Checks if Antennes was modified by hand.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean deleteAntennesAuto(HashMap antennes) {
	boolean result = false;
	try {
		Iterator it = antennes.values().iterator();
		while (it.hasNext()) {
			AntennaAccessBean aab = (AntennaAccessBean)it.next();
			if (!aab.getByhand().booleanValue()) {
				// Delete cables for antennes
				Enumeration cabtbl = new AntennaCableAccessBean().findByAnten(new Integer(aab.getIdanten()));
				while (cabtbl.hasMoreElements()) {
					// Delete Cable Params
					AntennaCableAccessBean acabab = (AntennaCableAccessBean)cabtbl.nextElement();
					Enumeration cabpartbl = new CableWorkParamsAccessBean().findByCable(new Integer(acabab.getIdcable()));
					while (cabpartbl.hasMoreElements()) {
						CableWorkParamsAccessBean cwpab = (CableWorkParamsAccessBean)cabpartbl.nextElement();
						cwpab.getEJBRef().remove();
					}
					acabab.getEJBRef().remove();
				}
				
				// Delete workbands for antennes
				Enumeration aawbtbl = aab.getAntennaWorkBands();
				while (aawbtbl.hasMoreElements()) {
					AntennaWorkBand aawb = (AntennaWorkBand)javax.rmi.PortableRemoteObject.narrow(aawbtbl.nextElement(), AntennaWorkBand.class);
					aawb.remove();
				}
				// Remove all links from this antenna
				deleteAnt2Sectors(aab.getAntena2sectors());
				// Remove antenna itself
				try {
					aab.getEJBRef().remove();
				} catch (Exception ee) {
					System.out.println("AFS: Cannot remove antenna auto");
				}
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while removing antennes auto");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Checks if Sectors was modified by hand.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean deleteSectors(HashMap sectors) {
	boolean result = false;
	try {
		Iterator it = sectors.values().iterator();
		while (it.hasNext()) {
			SectorAccessBean sab = (SectorAccessBean)it.next();

			// Remove all links from this sector
			deleteAnt2Sectors(sab.getAntena2sectors());
			
			try {
				sab.getEJBRef().remove();
			} catch (Exception ee) {
				// Sector can be linked to other antennes - so we cannot remove it
				System.out.println("AFS: Cannot delete sector");
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while deleting sectors");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Delete Sectors not modified by hand.
 * Creation date: (01.07.2003 17:06:52)
 * @return boolean
 * @param antennes java.util.ArrayList
 */
private boolean deleteSectorsAuto(HashMap sectors) {
	boolean result = false;
	try {
		Iterator it = sectors.values().iterator();
		while (it.hasNext()) {
			SectorAccessBean sab = (SectorAccessBean)it.next();
			if (!sab.getByhand().booleanValue()) {
				// Remove all links from this sector
				deleteAnt2Sectors(sab.getAntena2sectors());
				// Delete sector itself
				try {
					sab.getEJBRef().remove();
				} catch (Exception ee) {
					// Sector can be linked to other antennes - so we cannot remove it
					System.out.println("AFS: Cannot delete sector auto");
				}
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: Error while deleting sectors auto");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * Determine EquipmentSet code (document->To).
 * Creation date: (01.07.2003 16:57:21)
 * @return java.lang.Integer
 * @param argDocCode java.lang.Integer
 */
private Integer determineEquipmentCode(Integer argDocCode) {
	Integer result = new Integer(0);
	try {
		DocumentAccessBean dab = new DocumentAccessBean();
		dab.setInitKey_document(argDocCode.intValue());
		dab.refreshCopyHelper();
		result = new Integer(dab.getToKey().storageplace);
	} catch (Exception e) {
		System.out.println("AFS: cannot determine equipment code");
		e.printStackTrace(System.out);
	}
	return result;
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * Get Antennes2Sectors link.
 * Creation date: (01.07.2003 17:19:06)
 * @return java.util.ArrayList
 * @param antennes java.util.ArrayList
 * @param sectors java.util.ArrayList
 */
private ArrayList getAnt2Sectors(ArrayList antennes, ArrayList sectors) {

	ArrayList ant2sectAr = new ArrayList();

	try {
		Iterator antIt = antennes.iterator();
		while (antIt.hasNext()) {
			AntennaAccessBean aab = (AntennaAccessBean)antIt.next();
			Enumeration ant2sectEn = aab.getAntena2sectors();
			while (ant2sectEn.hasMoreElements()) {
				Antena2sector ant2sectbn = (Antena2sector)javax.rmi.PortableRemoteObject.narrow(ant2sectEn.nextElement(), Antena2sector.class);
				Antena2sectorAccessBean ant2sectab = new Antena2sectorAccessBean(ant2sectbn);
				Iterator sectIt = sectors.iterator();
				while (sectIt.hasNext()) {
					SectorAccessBean sector = (SectorAccessBean)sectIt.next();
					if (sector.getIdsect() == ant2sectab.getSectorKey().idsect) {
						ant2sectAr.add(ant2sectab);
						break;
					}
				}
				
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: Error in getting anten2sectors");
		e.printStackTrace(System.out);
	}
	
	return ant2sectAr;
}
/**
 * Get Antennes2Sectors link.
 * Creation date: (01.07.2003 17:19:06)
 * @return java.util.ArrayList
 * @param antennes java.util.ArrayList
 * @param sectors java.util.ArrayList
 */
private ArrayList getAnt2Sectors(HashMap antennes, HashMap sectors) {

	ArrayList ant2sectAr = new ArrayList();

	try {
		Iterator antIt = antennes.values().iterator();
		while (antIt.hasNext()) {
			AntennaAccessBean aab = (AntennaAccessBean)antIt.next();
			Enumeration ant2sectEn = aab.getAntena2sectors();
			while (ant2sectEn.hasMoreElements()) {
				Antena2sector ant2sectbn = (Antena2sector)javax.rmi.PortableRemoteObject.narrow(ant2sectEn.nextElement(), Antena2sector.class);
				Antena2sectorAccessBean ant2sectab = new Antena2sectorAccessBean(ant2sectbn);
				Iterator sectIt = sectors.values().iterator();
				while (sectIt.hasNext()) {
					SectorAccessBean sector = (SectorAccessBean)sectIt.next();
					if (sector.getIdsect() == ant2sectab.getSectorKey().idsect) {
						ant2sectAr.add(ant2sectab);
						break;
					}
				}
				
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: Error in getting anten2sectors");
		e.printStackTrace(System.out);
	}
	
	return ant2sectAr;
}
/**
 * Find antennes by positions of document.
 * Creation date: (01.07.2003 12:21:51)
 * @return java.util.ArrayList
 */
private HashMap getAntennes(Integer argDocCode, Integer argEquipmentCode) {

	HashMap ant = new HashMap();
	AntennaAccessBeanTable anttbl = new AntennaAccessBeanTable();
	
	try {
		Enumeration anten = new AntennaAccessBean().findByEquipmentOrderByNumAsc(argEquipmentCode);
		anttbl.setAntennaAccessBean(anten);
	} catch (Exception e) {
		System.out.println("AFS: cannot find antennes");
		e.printStackTrace(System.out);
	}

	try {
		Enumeration en = new AfsMountPosAccessBean().findDocPositionsByDocOrderByOrderAsc(argDocCode);
		while (en.hasMoreElements()) {
			AfsMountPosAccessBean afspab = (AfsMountPosAccessBean)en.nextElement();
			// Check for antena line
			if ("A".equalsIgnoreCase(afspab.getDocpostype()) || "B".equalsIgnoreCase(afspab.getDocpostype())) {
				// Find corresponding antenna
				for (int i=0; i < anttbl.numberOfRows(); i++) {
					AntennaAccessBean aab = anttbl.getAntennaAccessBean(i);
					if (aab.getNumant().equalsIgnoreCase(afspab.getNum_ant())) {
						ant.put(aab.getNumant(), aab);
						break;
					}
				}
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: cannot find docpositions");
		e.printStackTrace(System.out);
	}
	return ant;
}
/**
 * Find sectors by positions of document.
 * Creation date: (01.07.2003 12:21:51)
 * @return java.util.ArrayList
 */
private HashMap getSectors(Integer argDocCode, Integer argEquipmentCode) {

	HashMap sect = new HashMap();
	SectorAccessBeanTable secttbl = new SectorAccessBeanTable();
	
	try {
		Enumeration secten = new SectorAccessBean().findByBasestationOrderByNumberAsc(argEquipmentCode);
		secttbl.setSectorAccessBean(secten);
	} catch (Exception e) {
		System.out.println("AFS: cannot find sectors");
		e.printStackTrace(System.out);
	}

	try {
		Enumeration en = new AfsMountPosAccessBean().findDocPositionsByDocOrderByOrderAsc(argDocCode);
		while (en.hasMoreElements()) {
			AfsMountPosAccessBean afspab = (AfsMountPosAccessBean)en.nextElement();
			// Check for antena line
			if ("A".equalsIgnoreCase(afspab.getDocpostype()) || "B".equalsIgnoreCase(afspab.getDocpostype())) {
				// Find corresponding sector
				for (int i=0; i < secttbl.numberOfRows(); i++) {
					SectorAccessBean sab = secttbl.getSectorAccessBean(i);

					if (
						checkSector(argEquipmentCode, afspab.getDocpostype(), "A", afspab.getSectorA(), sab.getNumsect()) ||
						checkSector(argEquipmentCode, afspab.getDocpostype(), "B", afspab.getSectorB(), sab.getNumsect()) ||
						checkSector(argEquipmentCode, afspab.getDocpostype(), "C", afspab.getSectorC(), sab.getNumsect()) ||
						checkSector(argEquipmentCode, afspab.getDocpostype(), "D", afspab.getSectorD(), sab.getNumsect()) ||
						checkSector(argEquipmentCode, afspab.getDocpostype(), "E", afspab.getSectorE(), sab.getNumsect()) ||
						checkSector(argEquipmentCode, afspab.getDocpostype(), "F", afspab.getSectorF(), sab.getNumsect()) ||
						checkSector(argEquipmentCode, afspab.getDocpostype(), "G", afspab.getSectorG(), sab.getNumsect()) ||
						checkSector(argEquipmentCode, afspab.getDocpostype(), "H", afspab.getSectorH(), sab.getNumsect()) ||
						checkSector(argEquipmentCode, afspab.getDocpostype(), "O", afspab.getSectorO(), sab.getNumsect()) ||
						checkSector(argEquipmentCode, afspab.getDocpostype(), "O1800", afspab.getSectorO1800(), sab.getNumsect())
						)
							sect.put(sab.getNumsect(), sab);
				}
			}
		}
	} catch (Exception e) {
		System.out.println("AFS: cannot find docpositions");
		e.printStackTrace(System.out);
	}
	return sect;
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
	/**
	 * Checking if Afs Mount act antennes or sectors were modified by hand.
	 * Creation date: (22.07.2002 18:17:00)
	 * @param actCode java.lang.Integer
	 * @exception java.rmi.RemoteException The exception description.
	 */
	private boolean pureCheckAddInfoModification(Integer argDocument, HashMap antennes, HashMap sectors, ArrayList ant2sect) throws java.rmi.RemoteException {

		try {
			// Check antennes modification
			if (checkAntennesModification(antennes))
				return true;
			
			// Check sectors modification
			if (checkSectorsModification(sectors))
				return true;
			
			// Check links modification
			if (checkAnt2SectorsModification(ant2sect))
				return true;
			
		}catch( Exception e ) {
			throw new java.rmi.RemoteException( "While pure checking add info modification in afsmountact.", e );
		}
		return false;
	}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}
