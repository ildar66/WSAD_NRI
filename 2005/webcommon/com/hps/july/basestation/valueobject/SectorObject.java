package com.hps.july.basestation.valueobject;

import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Служебный класс позволяющий получать данные по сектору из БД
 */
public class SectorObject extends SectorAccessBean {
	public static final String CONABIS_CHECK_STAR_1="1";
	public static final String CONABIS_CHECK_RING_2="2";
	public static final String CONABIS_CHECK_RING_3="3";

	public static final String CONF_CHECK_1="1";
	public static final String CONF_CHECK_2="2";
	public static final String CONF_CHECK_3="3";
	public static final String CONF_CHECK_4="4";
/**
 * SectorObject constructor comment.
 */
public SectorObject() {
	super();
}
/**
 * SectorObject constructor comment.
 * @param arg0 int
 * @param arg1 int
 * @param arg2 java.lang.String
 * @param arg3 short
 * @param arg4 java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.naming.NamingException The exception description.
 */
public SectorObject(int arg0, int arg1, String arg2, short arg3, String arg4) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
	super(arg0, arg1, arg2, arg3, arg4);
}
/**
 * SectorObject constructor comment.
 * @param o javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
public SectorObject(SectorAccessBean bean) throws Exception {
	super(bean.getEJBRef());
}
/**
 * SectorObject constructor comment.
 * @param o javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
public SectorObject(javax.ejb.EJBObject o) throws java.rmi.RemoteException {
	super(o);
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2003 20:53:30)
 */
public void deleteAntennaLinks() throws Exception {

    deleteAntennaLinks(getIdsect());
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2003 20:53:30)
 */
public static void deleteAntennaLinks(int id) throws Exception {

    try {
        DebugSupport.printlnTest("findAntennaLinks started" + id);
        Antena2sectorAccessBeanTable table = new Antena2sectorAccessBeanTable();
        try {
            table.setAntena2sectorAccessBean(new Antena2sectorAccessBean().findAntena2sectorsBySector(new SectorKey(id)));
            if (table.numberOfRows() == 0)
                throw new javax.ejb.FinderException();
        } catch (javax.ejb.FinderException e1) {
            DebugSupport.printlnTest("No rows to delete. findAntennaLinks not found for idsect=" + id);
            return;
        }

        for (int i = 0; i < table.numberOfRows(); i++) {
            table.getAntena2sectorAccessBean(i).getEJBRef().remove(); //delete
            DebugSupport.printlnTest("antenna link for sect=" + id + " was deleted");
        }
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2003 15:52:39)
 * @return java.lang.String
 */
public String getTrxString() throws Exception {
    String res = "";
    if (getEquipment().getStationType().equals(Checks.BS_TYPE_DAMPS_D)) {
		if(getTrxnum2() != null && getTrxnum2().intValue() > 0) {
			res += getTrxnum2() + "A";
		}
		if(getTrxnum() != null && getTrxnum().intValue() > 0) {
			res += "/" + getTrxnum() + "D";
		}
		if(getTrxovrnum() != null && getTrxovrnum().intValue() > 0) {
			res += "/" + getTrxovrnum() + "O";
		}
//            (getTrxnum2() != null && getTrxnum2().intValue() > 0 ? getTrxnum2() + "A" : "")
//                + (getTrxnum() != null && getTrxnum().intValue() > 0 ? "/" + getTrxnum() + "D" : "")
//                + (getTrxovrnum() != null && getTrxovrnum().intValue() > 0 ? "/" + getTrxovrnum() + "O" : "");
    } else {
	    if(getTrxnum() != null && getTrxnum().intValue() > 0) {
		    res += String.valueOf(getTrxnum().intValue());
	    }
//        res = getTrxnum() != null && getTrxnum().intValue() > 0 ? getTrxnum() + "" : "";
    }
    return res;
}
public  boolean hasAntennaLinks() throws Exception {
	return hasAntennaLinks(getIdsect());
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2003 20:53:30)
 */
public static boolean hasAntennaLinks(int id) throws Exception {

    try {

        //AntennaWorkBandAccessBean aBands = null;

        Antena2sectorAccessBeanTable table = new Antena2sectorAccessBeanTable();

        try {
            table.setAntena2sectorAccessBean(
                new Antena2sectorAccessBean().findAntena2sectorsBySector(new SectorKey(id)));

            if (table.numberOfRows() == 0) {
                return false;
            }
        } catch (javax.ejb.FinderException e1) {
            /*    
                DebugSupport.printlnTest(
                    "Not to delete. findSectorLinks not found for idAnten="
                        + getIdanten());
              */
            return false;

        }
        return true;

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
}
