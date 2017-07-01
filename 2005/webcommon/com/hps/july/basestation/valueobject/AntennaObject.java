package com.hps.july.basestation.valueobject;

import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.DebugSupport;

/**
 * Служебный класс позволяющий получать информацию об фнтенных из БД
 */
public class AntennaObject
	extends com.hps.july.persistence.AntennaAccessBean
{
	public static final String KINDANT_CHECK_T="T";
	public static final String KINDANT_CHECK_D="D";
	public static final String KINDANT_CHECK_R="R";	
	public static final String KINDANT_T_LABEL_T="T";
	public static final String KINDANT_D_LABEL_TR="TR";
	public static final String KINDANT_R_LABEL_R="R";
/**
 * AntennaObject constructor comment.
 */
public AntennaObject() {
	super();
}
/**
 * AntennaObject constructor comment.
 * @param arg0 int
 * @param arg1 int
 * @param arg2 java.lang.String
 * @param arg3 java.lang.String
 * @param arg4 java.math.BigDecimal
 * @param arg5 java.math.BigDecimal
 * @param arg6 java.math.BigDecimal
 * @param arg7 java.math.BigDecimal
 * @param arg8 int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.naming.NamingException The exception description.
 */
public AntennaObject(int arg0, int arg1, String arg2, String arg3, java.math.BigDecimal arg4, java.math.BigDecimal arg5, java.math.BigDecimal arg6, java.math.BigDecimal arg7, int arg8) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
	super(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
}
/**
 * AntennaObject constructor comment.
 * @param o javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
public AntennaObject(AntennaAccessBean bean) throws Exception{
	super(bean.getEJBRef());
}
/**
 * AntennaObject constructor comment.
 * @param o javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
public AntennaObject(javax.ejb.EJBObject o) throws java.rmi.RemoteException {
	super(o);
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 21:29:41)
 * @return boolean
 * @param sec int
 */
public void addToSector(int sec)
	throws Exception
{
	try {
		Antena2sectorAccessBean as = new Antena2sectorAccessBean(getIdanten(), sec,Boolean.TRUE);
	} catch (Exception e1) {
		new DebugSupport().printlnError(e1,"addToSector",this);
		throw e1;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 18:21:12)
 */
public void deleteCascade()
	throws Exception
{
	deleteWorkBands();
	deleteSectorLinks();
	this.getEJBRef().remove();
}
public void deleteSectorLinks() throws Exception {
    deleteSectorLinks(getIdanten());
}
public static void deleteSectorLinks(int id)
	throws Exception
{
    try {
		DebugSupport.printlnTest("deleteSectorLinks started ");
		//AntennaWorkBandAccessBean aBands = null;
		Antena2sectorAccessBeanTable table = new Antena2sectorAccessBeanTable();
		try {
			table.setAntena2sectorAccessBean(new Antena2sectorAccessBean().findAntena2sectorsByAntenna(new AntennaKey(id)));
            if (table.numberOfRows() == 0) {
				throw new javax.ejb.FinderException();
			}
		} catch (javax.ejb.FinderException e1) {
			DebugSupport.printlnTest("There are no sector links ");
			return;
        }
        for (int i = 0; i < table.numberOfRows(); i++) {
			table.getAntena2sectorAccessBean(i).getEJBRef().remove(); //delete
			DebugSupport.printlnTest("Sector link was deleted");
		}
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
    }
}
public void deleteWorkBands()
	throws Exception
{
   deleteWorkBands(getIdanten());
}
public static void deleteWorkBands(int id) throws Exception {
    try {
        AntennaWorkBandAccessBeanTable table = new AntennaWorkBandAccessBeanTable();
        try {
			table.setAntennaWorkBandAccessBean(new AntennaWorkBandAccessBean().findAntennaWorkBandsByAntenna(new AntennaKey(id)));
			if (table.numberOfRows() == 0)
				throw new javax.ejb.FinderException();
		} catch (javax.ejb.FinderException e1) {
			DebugSupport.printlnTest("Not to delete. findAntennaWorkBandsByAntenna not found for idAnten=" + id);
			return;
		}
		for (int i = 0; i < table.numberOfRows(); i++) {
			DebugSupport.printlnTest("before delete. WorkBands for idAnten=" + id);
			table.getAntennaWorkBandAccessBean(i).getEJBRef().remove(); //delete
			DebugSupport.printlnTest("WorkBands for idAnten=" + id + " was deleted");
		}
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
	}
}
public String findAmplificationForWorkBand(
    AntennaWorkBandAccessBean workBand) {
    StringBuffer buf = new StringBuffer("");
    try {
        AntennaResourceBandAccessBean resBand = new AntennaResourceBandAccessBean();
        resBand.setInitKey_band(workBand.getBand());
        resBand.setInitKey_resource_resource(
            new Integer(workBand.getAntenna().getResourceKey().resource));
        resBand.refreshCopyHelper();
        return resBand.getAmplification()==null?"":resBand.getAmplification()+"";
    } catch (Exception e) {
        return "";
    }
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2003 21:43:48)
 * @return java.util.Enumeration
 * @param sec int
 */
public static Enumeration findBySector(int sec)
	throws Exception
{
	Vector antennes = new Vector();
	try {
		Antena2sectorAccessBeanTable table1 = new Antena2sectorAccessBeanTable();
		table1.setAntena2sectorAccessBean(new Antena2sectorAccessBean().findAntena2sectorsBySector(new SectorKey(sec)));

		for (int i = 0; i < table1.numberOfRows(); i++) {
			antennes.addElement(new AntennaObject(table1.getAntena2sectorAccessBean(i).getAntenna().getEJBRef()));
        }
    } catch (Exception e1) {
		new com.hps.july.jdbcpersistence.lib.DebugSupport().printlnError(e1);
        throw e1;
    } finally {
        return antennes.elements();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 10:38:25)
 * @return java.lang.String
 */
public String getAmplificationStr() {
    StringBuffer buf = new StringBuffer("");

    try {
        AntennaWorkBandAccessBeanTable table = new AntennaWorkBandAccessBeanTable();
        table.setAntennaWorkBandAccessBean(
            new AntennaWorkBandAccessBean().findAntennaWorkBandsByAntenna(
                new AntennaKey(getIdanten())));
        for (int i = 0; i < table.numberOfRows(); i++) {
            if (i > 0) {
                buf.append("/");
            }

            buf.append(findAmplificationForWorkBand(table.getAntennaWorkBandAccessBean(i)));
        }
    } catch (Exception e) {
	   DebugSupport.println("getAmplificationStr "+e);
	   return "";
    }
    return buf.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2003 19:38:51)
 * @return java.lang.String
 */
public String getBandsString() throws Exception {
    StringBuffer buf = new StringBuffer("");
    AntennaWorkBandAccessBean bean=new AntennaWorkBandAccessBean();
    AntennaWorkBand antennaWorkBand=null;
    
    try {
        //Enumeration enum = getAntennaWorkBands();
        Enumeration enum=bean.findAntennaWorkBandsByAntenna(new AntennaKey(getIdanten()));
        
        while(enum.hasMoreElements()) {
         bean=(AntennaWorkBandAccessBean) enum.nextElement();
         antennaWorkBand=(AntennaWorkBand)javax.rmi.PortableRemoteObject.narrow(bean.getEJBRef(),AntennaWorkBand.class); 
	        if (buf.length() > 0) {
                buf.append("/");
            }
            buf.append(antennaWorkBand.getBand());
        }

        return buf.toString();
    } catch (Exception e) {
        com.hps.july.jdbcpersistence.lib.DebugSupport.printlnError(
            e,
            "getBandsString()",
            this);
        return "";
        //throw e;
    }
}
public static String getKindAntTitle(String kindAnt) {
	if(kindAnt != null) {
		if(KINDANT_CHECK_R.equals(kindAnt)) {
			return KINDANT_R_LABEL_R;
		} else if(KINDANT_CHECK_D.equals(kindAnt)) {
			return KINDANT_D_LABEL_TR;
		} else if(KINDANT_CHECK_T.equals(kindAnt)) {
			return KINDANT_T_LABEL_T;
		} else {
			return "";
		}
	} else {
		return "";
	}
}
public String getSectorLetters() {
	try {
		com.hps.july.cdbc.objects.CDBCEquipmentObject eo = new com.hps.july.cdbc.objects.CDBCEquipmentObject();
		return eo.getAntennesSectorLetters(new Integer(getIdanten()));
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2003 19:38:51)
 * @return java.lang.String
 */
public String getWidthAndLength() throws Exception {
    String width =
        getResource().getWidth() == null ? "" : getResource().getWidth().toString();
    String length =
        getResource().getLength() == null ? "" : getResource().getLength().toString();
    return width + "/" + length;

}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2003 22:12:10)
 * @return java.lang.String
 */
public String getWidthDiagram() throws Exception{
    String vertwidth = "";
    String horzwidth = "";
    AntennaResourceBandAccessBean arb = null;
    AntennaWorkBandAccessBean awb = null;
    try {
        awb = new AntennaWorkBandAccessBean();
        Enumeration en =
            awb.findAntennaWorkBandsByAntenna(new AntennaKey(getIdanten()));
        while (en.hasMoreElements()) {
            awb = (AntennaWorkBandAccessBean) en.nextElement();
            arb = new AntennaResourceBandAccessBean();
            arb.setInitKey_resource_resource(new Integer(getResourceKey().resource));
            arb.setInitKey_band(awb.getBand());
            arb.refreshCopyHelper();
            if (horzwidth.length() < 1) {
                horzwidth = arb.getHorzwidth() != null ? arb.getHorzwidth().toString() : "";
            } else {
                horzwidth += "/"
                    + (arb.getHorzwidth() != null ? arb.getHorzwidth().toString() : "");
            }
            if (vertwidth.length() < 1) {
                vertwidth = (arb.getVertwidth() != null ? arb.getVertwidth().toString() : "");
            } else {
                vertwidth += "/"
                    + (arb.getVertwidth() != null ? arb.getVertwidth().toString() : "");
            }
        }
        return horzwidth + (vertwidth.length() > 0 ? "/" + vertwidth : "");
    } catch (Exception e) {
        DebugSupport.println("getWidthDiagram "+e);
        //throw e;
        return "";
    }
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 21:29:41)
 * @return boolean
 * @param sec int
 */
public boolean hasSector(int sec) throws Exception {

    try {
        Antena2sectorAccessBean as = new Antena2sectorAccessBean();
        as.setInitKey_antenna_idanten(new Integer(getIdanten()));
        as.setInitKey_sector_idsect(new Integer(sec));
        as.refreshCopyHelper();
        return true;
    } catch (javax.ejb.FinderException e) {
        return false;
    } catch (Exception e1) {
        new com.hps.july.jdbcpersistence.lib.DebugSupport().printlnError(
            e1,
            "hasSector(int sec)",
            this);
        throw e1;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2003 20:53:30)
 */
public  boolean hasSectorLinks() throws Exception {

   return hasSectorLinks(getIdanten());
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2003 20:53:30)
 */
public static boolean hasSectorLinks(int id)
	throws Exception
{
    try {
		Antena2sectorAccessBeanTable table = new Antena2sectorAccessBeanTable();
		try {
			table.setAntena2sectorAccessBean(new Antena2sectorAccessBean().findAntena2sectorsByAntenna(new AntennaKey(id)));
			if (table.numberOfRows() == 0) {
				return false;
			}
		} catch (javax.ejb.FinderException e1) {
			return false;
		}
		return true;
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 21:29:41)
 * @return boolean
 * @param sec int
 */
public void removeFromSector(int sec) throws Exception {

    try {
        Antena2sectorAccessBean as = new Antena2sectorAccessBean();
        as.setInitKey_antenna_idanten(new Integer(getIdanten()));
        as.setInitKey_sector_idsect(new Integer(sec));
        as.refreshCopyHelper();
        as.getEJBRef().remove();
    
    } catch (Exception e1) {
        new com.hps.july.jdbcpersistence.lib.DebugSupport().printlnError(
            e1,
            "removeSector",
            this);
        throw e1;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2003 20:53:30)
 */
public void removeSectorLinks() {}
}
