package com.hps.july.basestation.valueobject;

import com.hps.july.siteinfo.formbean.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.DebugSupport;
import com.hps.july.basestation.formbean.*;
import com.hps.july.util.*; 
 
/**
 * Класс контейнер содержащий базовую станцию и связанную с ней позицию
 * @deprecated
 */
public class Position_BaseStation
	extends com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean 
	implements javax.ejb.EJBObject
{
	private PositionAccessBean position;
	private BaseStationAccessBean baseStation;
/**
 * Position_BaseStation constructor comment.
 */
public Position_BaseStation() {
	super();
}
/**
 * Position_BaseStation constructor comment.
 */
public Position_BaseStation(int storageplace) throws Exception {
    super();
    baseStation = new BaseStationAccessBean();
    position=new PositionAccessBean();
    baseStation.setInitKey_storageplace(storageplace);
    baseStation.refreshCopyHelper();
    position.setInitKey_storageplace(baseStation.getPositionKey().storageplace);
    position.refreshCopyHelper();
    DebugSupport.printlnTest("#####Position_BaseStation(int storageplace)");
        DebugSupport.printlnTest("#####Position_BaseStation(int storageplace) basestation="+baseStation);
        DebugSupport.printlnTest("#####Position_BaseStation(int storageplace) position="+position);
        }
/**
 * Position_BaseStation constructor comment.
 */
public Position_BaseStation(PositionAccessBean pos, BaseStationAccessBean bs) {
	super();
	baseStation=bs;
    position=pos;
}
/**
 * Commit the copy helper attributes stored in the access bean to
 * the remote enterprise bean.  The enterprise bean is instantiated
 * if it already is not.
 */
public void commitCopyHelper()
    throws
        javax.ejb.CreateException,
        java.rmi.RemoteException,
        javax.naming.NamingException,
        javax.ejb.FinderException {
    try {
     position.commitCopyHelper();    
	    baseStation.commitCopyHelper();
        
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
}
/**
 *
 */
protected String defaultJNDIName() {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 16:05:39)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
public com.hps.july.persistence.BaseStationAccessBean getBaseStation() {
	return baseStation;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 20:25:36)
 * @param bsForm com.hps.july.basestation.formbean.FactBaseStationForm
 */
public FactBaseStationForm getBsForm() throws Exception {
	DebugSupport.printlnTest("FactBaseStationForm getBsForm() started");
	FactBaseStationForm bsForm=new FactBaseStationForm();
	com.hps.july.util.BeanUtils.copyProperties( bsForm,baseStation);
	return bsForm; 
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 16:28:58)
 * @return javax.ejb.EJBHome
 */
public javax.ejb.EJBHome getEJBHome() {
	return null;
}
/**
 * Return the EJBObject reference of the enterprise bean.
 *
 * @return	<code>javax.ejb.EJBObject</code>
 */
 
public javax.ejb.EJBObject getEJBRef() throws javax.ejb.CreateException, javax.ejb.FinderException, java.rmi.RemoteException, javax.naming.NamingException {
	

	
	 
	return this;
	 
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 16:30:09)
 * @return javax.ejb.Handle
 */
public javax.ejb.Handle getHandle() {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 16:05:07)
 * @return com.hps.july.persistence.PositionAccessBean
 */
public com.hps.july.persistence.PositionAccessBean getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 20:25:36)
 * @param bsForm com.hps.july.basestation.formbean.FactBaseStationForm
 */
public PositionForm getPositionForm() throws Exception {
	PositionForm pForm=new PositionForm();
	com.hps.july.util.BeanUtils.copyProperties( pForm,position);
	return pForm; 
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 16:27:36)
 * @return java.lang.Object
 */
public Object getPrimaryKey() {
	return null;
}
/**
 * 
 */
protected void instantiateEJB() throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException, javax.ejb.FinderException {}
/**
 *
 */
protected boolean instantiateEJBByPrimaryKey() throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 16:32:00)
 * @return boolean
 * @param eb javax.ejb.EJBObject
 */
public boolean isIdentical(javax.ejb.EJBObject eb) {
	return false;
}
/**
 * Update the copy helper attributes by copying the attribute values
 * from the enterprise bean.
 * The enterprise bean is instantiated if it already is not.
 */
public void refreshCopyHelper() throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException, javax.ejb.FinderException {
	baseStation.refreshCopyHelper();
	position.refreshCopyHelper();
	}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 16:31:13)
 */
public void remove()
    throws java.rmi.RemoteException, javax.ejb.RemoveException {
    try {
        //getPosition().getEJBRef().remove();
        getBaseStation().getEJBRef().remove();
    } catch (javax.ejb.RemoveException e1) {
        DebugSupport.printlnError(e1, "remove", this);
        throw e1;
    
    } catch (Exception e2) {
        DebugSupport.printlnError(e2, "remove", this);
        throw new java.rmi.RemoteException();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 16:05:39)
 * @param newBaseStation com.hps.july.persistence.BaseStationAccessBean
 */
public void setBaseStation(com.hps.july.persistence.BaseStationAccessBean newBaseStation) {
	baseStation = newBaseStation;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 20:25:36)
 * @param bsForm com.hps.july.basestation.formbean.FactBaseStationForm
 */
public void setBsForm(FactBaseStationForm bsForm) throws Exception {
    try {
	    DebugSupport.printlnTest("!!!!Position_BaseStation setBsForm started");
        com.hps.july.util.BeanUtils.copyProperties(baseStation, bsForm);
    } catch (Exception e) {
	    DebugSupport.printlnTest("!!!!Position_BaseStation setBsForm error");
        DebugSupport.printlnError(e);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 21:10:08)
 * @param key int
 */
public void setInitKey_storageplace(int key) {}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 16:05:07)
 * @param newPosition com.hps.july.persistence.PositionAccessBean
 */
public void setPosition(com.hps.july.persistence.PositionAccessBean newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (12.03.2003 20:25:36)
 * @param bsForm com.hps.july.basestation.formbean.FactBaseStationForm
 */
public void setPositionForm(PositionForm pForm) throws Exception {

    if (pForm == null)
        return;

    try {
        com.hps.july.util.BeanUtils.copyProperties(position, pForm);
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
    return;
}
}
