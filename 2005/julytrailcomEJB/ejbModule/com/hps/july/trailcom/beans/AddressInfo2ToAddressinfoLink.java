package com.hps.july.trailcom.beans;

import com.ibm.ivj.ejb.associations.interfaces.*;
import com.ibm.ivj.ejb.associations.links.*;
import java.rmi.*;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
public class AddressInfo2ToAddressinfoLink extends ManyToSingleLink {
	private static AddressInfoHome targetHome = null;
	private final static java.lang.String targetHomeName = "AddressInfo";
/**
 * Create a link instance with the passed source bean
 * @param anEntityBean javax.ejb.EntityBean
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public AddressInfo2ToAddressinfoLink(javax.ejb.EntityBean anEntityBean) {
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
	com.hps.july.trailcom.beans.AddressInfoKey key = ((com.hps.july.trailcom.beans.AddressInfo2Bean)source).getAddressinfoKey();
	try {
		target = ((com.hps.july.trailcom.beans.AddressInfoHome)getTargetHome(this)).findByPrimaryKey(key);
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
	return ((com.hps.july.trailcom.beans.AddressInfo2Bean)source).getEntityContext();
}
/**
 * Get the target home for the link.
 * @return com.hps.july.trailcom.beans.AddressInfoHome
 * @param aLink com.ibm.ivj.ejb.associations.links.Link
 * @exception javax.naming.NamingException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected static synchronized AddressInfoHome getTargetHome(com.ibm.ivj.ejb.associations.links.Link aLink) throws javax.naming.NamingException {
	if (targetHome == null) {
		String homeName = aLink.getEntityContext().getEnvironment().getProperty(targetHomeName);
		if (homeName == null)
			homeName = targetHomeName;
		targetHome = (com.hps.july.trailcom.beans.AddressInfoHome)lookupTargetHome(homeName, com.hps.july.trailcom.beans.AddressInfoHome.class);
	}
	return targetHome;
}
/**
 * Return whether or not the source key is valid for querying.
 * @return boolean
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected boolean isKeyValid() {
	return (((com.hps.july.trailcom.beans.AddressInfo2Bean)source).getAddressinfoKey() != null);
}
/**
 * Reset my target key.
 * @exception java.rmi.RemoteException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void resetKey() throws java.rmi.RemoteException {
	((com.hps.july.trailcom.beans.AddressInfo2Bean)source).privateSetAddressinfoKey(null);
}
/**
 * Forward inverse maintenance through my target EJB.
 * @param anEJB javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddElementCounterLinkOf(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
	if (anEJB != null)
		((com.hps.july.trailcom.beans.AddressInfo)anEJB).secondaryAddAddressInfo2s((com.hps.july.trailcom.beans.AddressInfo2)getEntityContext().getEJBObject());
}
/**
 * Forward inverse maintenance through my target EJB.
 * @param anEJB javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveElementCounterLinkOf(javax.ejb.EJBObject anEJB) throws java.rmi.RemoteException {
	if (anEJB != null)
		((com.hps.july.trailcom.beans.AddressInfo)anEJB).secondaryRemoveAddressInfo2s((com.hps.july.trailcom.beans.AddressInfo2)getEntityContext().getEJBObject());
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
		((com.hps.july.trailcom.beans.AddressInfo2Bean)source).privateSetAddressinfoKey(null);
	else
		((com.hps.july.trailcom.beans.AddressInfo2Bean)source).privateSetAddressinfoKey((com.hps.july.trailcom.beans.AddressInfoKey)targetEJB.getPrimaryKey());
}
}
