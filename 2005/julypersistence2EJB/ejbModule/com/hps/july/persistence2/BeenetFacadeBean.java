package com.hps.july.persistence2;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * Логика работы с номерами beenet
 * This is a Session Bean Class
 */
public class BeenetFacadeBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Создание объекта Beenet и связей с оборудованием
 */
public void createBeenet(String beenetid, int categid, int position, int[] equipment)
	throws java.rmi.RemoteException
{
	try {
		BeenetObjectAccessBean bo = new BeenetObjectAccessBean(beenetid,categid,position);
		if(equipment != null) {
			for(int i = 0; i < equipment.length; i++) {
				new Beenet2EquipmentAccessBean(beenetid, equipment[i]);
			}
		}
	} catch(DuplicateKeyException dke) {
		throw new RemoteException("Can't create beenet object. Duplicate key ["+beenetid+"]");
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new RemoteException("Can't create beenet. See EJB Server log file.");
	}
}
/**
 * Удаление объекта Beenet и связей с оборудованием
 */
public void deleteBeenet(String beenetid)
	throws java.rmi.RemoteException
{
	if(beenetid == null) {
		throw new RemoteException("Can't delete beenet. Beenetid is NULL");
	}
	try {
		deleteBeenet2EquipmentLinks(beenetid);
		BeenetObjectAccessBean bo = new BeenetObjectAccessBean();
		bo.setInitKey_beenetid(beenetid);
		bo.refreshCopyHelper();
		bo.getEJBRef().remove();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new RemoteException("Can't delete beenet with number ["+beenetid+"]");
	}
}
private void deleteBeenet2EquipmentLinks(String beenetid)
{
	try {
		Beenet2EquipmentAccessBean b = new Beenet2EquipmentAccessBean();
		java.util.Enumeration en = b.findByBeenetid(beenetid);
		while(en.hasMoreElements()) {
			Beenet2EquipmentAccessBean be = (Beenet2EquipmentAccessBean)en.nextElement();
			be.getEJBRef().remove();
		}
	} catch(Exception e) {
		System.out.println("BEENET2Equipment, Delete links filed.");
	}
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
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
/**
 * Изменение связей объекта Beenet
 */
public void updateBeenet(String beenetid, int categid, int[] equipment)
	throws java.rmi.RemoteException
{
	if(beenetid == null) {
		throw new RemoteException("Can't update beenet. Beenetid is NULL");
	}
	try {
		deleteBeenet2EquipmentLinks(beenetid);
		
		BeenetObjectAccessBean bo = new BeenetObjectAccessBean();
		bo.setInitKey_beenetid(beenetid);
		bo.refreshCopyHelper();
		bo.setCategid(categid);
		bo.commitCopyHelper();

		if(equipment != null) {
			for(int i = 0; i < equipment.length; i++) {
				new Beenet2EquipmentAccessBean(beenetid, equipment[i]);
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new RemoteException("Can't update beenet. See EJB Server log file.");
	}
}
}
