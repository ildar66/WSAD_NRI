package com.hps.july.basestation.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.basestation.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.siteinfo.formbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.jdbcpersistence.lib.DebugSupport;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.basestation.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
 
/**
 * ‘орма выбора антенн дл€ сектора базовой станции
 */
public class AntennesChoiceForm extends com.hps.july.web.util.EditForm {
	private int[] choiceAntennes=new int[]{};
	private int sect;
	private SectorAccessBean sector;
	private int basestation;
	private Vector antennes;
	private String submit;	
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:07:32)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:37:31)
 * @return java.util.Enumeration
 */
public Vector getAntennes() {

    
    return antennes;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:07:32)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:54:12)
 * @return int
 */
public int getBasestation() {
	return basestation;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 22:52:56)
 * @return java.lang.Boolean[]
 */
public int[] getChoiceAntennes() {
	return choiceAntennes;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:07:32)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:54:12)
 * @return int
 */
public int getSect() {
	return sect;
}
/**
 * Insert the method's description here.
 * Creation date: (13.04.2003 17:50:46)
 * @return com.hps.july.persistence.SectorAccessBean
 */
public com.hps.july.persistence.SectorAccessBean getSector() {
	return sector;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:07:32)
 * @return int
 */
public int getState() {
	return APPStates.ANTENNES_CHOICE;
}
/**
 * Insert the method's description here.
 * Creation date: (13.04.2003 21:31:51)
 * @return java.lang.String
 */
public java.lang.String getSubmit() {
	return submit;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:37:31)
 * @return java.util.Enumeration
 */
public void initEditRecord(javax.servlet.http.HttpServletRequest request)
    throws Exception {
	   
    /*
	    SectorForm sForm = (SectorForm) request.getSession().getAttribute("SectorForm");
    sect = sForm.getIdsect();
    
    FactBaseStationForm bForm =
        (FactBaseStationForm) request.getSession().getAttribute("BaseStationForm");
    basestation = bForm.getBasestation();
    */
sector=new SectorAccessBean();
sector.setInitKey_idsect(sect);
sector.refreshCopyHelper();
basestation=sector.getEquipmentKey().storageplace;

    
     antennes = new Vector();
    AntennaObject antenna = null;

    AntennaAccessBeanTable table = new AntennaAccessBeanTable();
    table.setAntennaAccessBean(
        new AntennaAccessBean().findAntennesByEquipment(
            new StoragePlaceKey(getBasestation())));
    
    for (int i = 0; i < table.numberOfRows(); i++) {
        antenna = new AntennaObject(table.getAntennaAccessBean(i).getEJBRef());
        antennes.addElement(antenna);
    }

    Antena2sectorAccessBeanTable table1 = new Antena2sectorAccessBeanTable();
    table1
        .setAntena2sectorAccessBean(
            new Antena2sectorAccessBean().findAntena2sectorsBySector(
                new SectorKey(getSect())));

    choiceAntennes = new int[table1.numberOfRows()];
    for (int i = 0; i < table1.numberOfRows(); i++) {
        antenna = new AntennaObject(table1.getAntena2sectorAccessBean(i).getAntenna().getEJBRef());
        choiceAntennes[i] = antenna.getIdanten();
        DebugSupport.printlnTest(
            "choiceAntennes[" + i + "]=" + new Boolean(antenna.hasSector(getSect())));
    }

    return;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:37:31)
 * @return java.util.Enumeration
 */
public void initProcessRecord(javax.servlet.http.HttpServletRequest request)
    throws Exception {

    if (request.getParameterValues("choiceAntennes") == null) {
        choiceAntennes = new int[] {
        };
    }

}

/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:37:31)
 * @return java.util.Enumeration
 */
public void proccess() throws Exception {

    AntennaObject ant = null;
    Arrays.sort(choiceAntennes);

    for (int i = 0; i < antennes.size(); i++) {
        ant = (AntennaObject) antennes.elementAt(i);
        if (Arrays.binarySearch(choiceAntennes,ant.getIdanten())>-1 && !ant.hasSector(getSect())) {
            ant.addToSector(getSect());
        } else
            if (Arrays.binarySearch(choiceAntennes,ant.getIdanten())<0 && ant.hasSector(getSect())) {
                ant.removeFromSector(getSect());
            }

    }
	
	int[] ants = getChoiceAntennes();
    for(int i = 0; i<ants.length;i++){
	   Antena2sectorAccessBean atsb = new Antena2sectorAccessBean();
       atsb.setInitKey_sector_idsect(new Integer(getSect())); 
	   atsb.setInitKey_antenna_idanten(new Integer(ants[i]));
	   atsb.setDatasource(0);
	   atsb.commitCopyHelper();
    }
    
    return;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:54:12)
 * @param newBasestation int
 */
public void setBasestation(int newBasestation) {
	basestation = newBasestation;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 22:52:56)
 * @param newChoiceAntennes java.lang.Boolean[]
 */
public void setChoiceAntennes(int[] newChoiceAntennes) {
	choiceAntennes = newChoiceAntennes;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 20:54:12)
 * @param newSect int
 */
public void setSect(int newSect) {
	sect = newSect;
}
/**
 * Insert the method's description here.
 * Creation date: (13.04.2003 17:50:46)
 * @param newSector com.hps.july.persistence.SectorAccessBean
 */
public void setSector(com.hps.july.persistence.SectorAccessBean newSector) {
	sector = newSector;
}
/**
 * Insert the method's description here.
 * Creation date: (13.04.2003 21:31:51)
 * @param newSubmit java.lang.String
 */
public void setSubmit(java.lang.String newSubmit) {
	submit = newSubmit;
}
}
