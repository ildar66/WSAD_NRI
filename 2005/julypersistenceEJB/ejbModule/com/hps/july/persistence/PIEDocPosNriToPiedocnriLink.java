package com.hps.july.persistence;

import com.ibm.ivj.ejb.associations.interfaces.*;
import com.ibm.ivj.ejb.associations.links.*;
import java.rmi.*;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
public class PIEDocPosNriToPiedocnriLink extends ManyToSingleLink {
	private static PIEDocNriHome targetHome = null;
	private final static java.lang.String targetHomeName = "PIEDocNri";
/**
 * Create a link instance with the passed source bean
 * @param anEntityBean javax.ejb.EntityBean
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public PIEDocPosNriToPiedocnriLink(javax.ejb.EntityBean anEntityBean) {
	super(anEntityBean);
	isRequired = true;
}
/**
 * Fetch the target for this single link, return an instance of the target class.
 * @return javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected javax.ejb.EJBObject fetchTarget() throws java.rmi.RemoteException, javax.ejb.FinderException {
	EJBObject target = null;
	com.hps.july.persistence.PIEDocNriKey key = ((com.hps.july.persistence.PIEDocPosNriBean)source).getPiedocnriKey();
	try {
		target = ((com.hps.july.persistence.PIEDocNriHome)getTargetHome(this)).findByPrimaryKey(key);
	}
	catch (NamingException e) {
		throw new FinderException(e.toString());
	}
	return target;
}
/**
 * Get the entity context from the source bean.
 * @return javax.ejb.EntityContext
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public javax.ejb.EntityContext getEntityContext() {
	return ((com.hps.july.persistence.PIEDocPosNriBean)source).getEntityContext();
}
/**
 * Get the target home for the link.
 * @return com.hps.july.persistence.PIEDocNriHome
 * @param aLink com.ibm.ivj.ejb.associations.links.Link
 * @exception javax.naming.NamingException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected static synchronized PIEDocNriHome getTargetHome(com.ibm.ivj.ejb.associations.links.Link aLink) throws javax.naming.NamingException {
	if (targetHome == null) {
		String homeName = aLink.getEntityContext().getEnvironment().getProperty(targetHomeName);
		if (homeName == null)
			homeName = targetHomeName;
		targetHome = (com.hps.july.persistence.PIEDocNriHome)lookupTargetHome(homeName, com.hps.july.persistence.PIEDocNriHome.class);
	}
	return targetHome;
}
/**
 * Return whether or not the source key is valid for querying.
 * @return boolean
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected boolean isKeyValid() {
	return (((com.hps.july.persistence.PIEDocPosNriBean)source).getPiedocnriKey() != null);
}
/**
 * Reset my target key.
 * @exception java.rmi.RemoteException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void resetKey() throws java.rmi.RemoteException {
	((com.hps.july.persistence.PIEDocPosNriBean)source).privateSetPiedocnriKey(null);
}
/**
 * Forward inverse maintenance through my target EJB.
 * @param anEJB javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddElementCounterLinkOf(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
	if (anEJB != null)
		((com.hps.july.persistence.PIEDocNri)anEJB).secondaryAddPIEDocPosNris((com.hps.july.persistence.PIEDocPosNri)getEntityContext().getEJBObject());
}
/**
 * Forward inverse maintenance through my target EJB.
 * @param anEJB javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveElementCounterLinkOf(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
	if (anEJB != null)
		((com.hps.july.persistence.PIEDocNri)anEJB).secondaryRemovePIEDocPosNris((com.hps.july.persistence.PIEDocPosNri)getEntityContext().getEJBObject());
}
/**
 * Set the target for this single link, an instance of the target class.
 * @param targetEJB javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void set(javax.ejb.EJBObject targetEJB) throws java.rmi.RemoteException {
	super.set(targetEJB);
	if (targetEJB == null)
		((com.hps.july.persistence.PIEDocPosNriBean)source).privateSetPiedocnriKey(null);
	else
		((com.hps.july.persistence.PIEDocPosNriBean)source).privateSetPiedocnriKey((com.hps.july.persistence.PIEDocNriKey)targetEJB.getPrimaryKey());
}
}
