package com.hps.july.platinum.valueobject;

import java.util.*;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;

/**
 * Insert the type's description here.
 * Creation date: (18.02.2002 10:42:32)
 * @author: Oleg Gashnikov
 */
public class CardValue2 {
	
 
	private java.lang.Integer ownercode;	//from combo-box
	private java.util.Map url;
	private java.lang.String jspriznak;
	private int resourcenri;
	private java.lang.String modelnri;
	private java.lang.String namenri;
	private java.lang.String idresplatinum;
	private java.lang.String party;
	private java.lang.Integer resource;
	private java.lang.String partyplatinum;
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 14:16:54)
 * @return java.lang.String
 */
public java.lang.String getIdresplatinum() {
	return idresplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:36:20)
 * @return java.lang.String
 */
public java.lang.String getJspriznak() {
	return jspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 18:14:57)
 * @return java.lang.String
 */
public java.lang.String getModelnri() {
	return modelnri;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 18:25:39)
 * @return java.lang.String
 */
public java.lang.String getNamenri() {
	return namenri;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 10:44:21)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return ownercode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 14:26:37)
 * @return java.lang.String
 */
public java.lang.String getParty() {
	return party;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 14:41:11)
 * @return java.lang.String
 */
public java.lang.String getPartyplatinum() {
	return partyplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 14:27:00)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 18:13:41)
 * @return int
 */
public int getResourcenri() {
	return resourcenri;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:05:09)
 * @return java.util.Map
 */
public java.util.Map getUrl() {	
	return url;
	}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 14:16:54)
 * @param newIdresplatinum java.lang.String
 */
public void setIdresplatinum(java.lang.String newIdresplatinum) {
	idresplatinum = newIdresplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (26.12.2002 11:36:20)
 * @param newJspriznak java.lang.String
 */
public void setJspriznak(java.lang.String newJspriznak) {
	jspriznak = newJspriznak;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 18:14:57)
 * @param newModelnri java.lang.String
 */
public void setModelnri(java.lang.String newModelnri) {
	modelnri = newModelnri;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 18:25:39)
 * @param newNamenri java.lang.String
 */
public void setNamenri(java.lang.String newNamenri) {
	namenri = newNamenri;
}
/**
 * Insert the method's description here.
 * Creation date: (20.12.2002 10:44:21)
 * @param newOwnewcode java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 14:26:37)
 * @param newParty java.lang.String
 */
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 14:41:11)
 * @param newPartyplatinum java.lang.String
 */
public void setPartyplatinum(java.lang.String newPartyplatinum) {
	partyplatinum = newPartyplatinum;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 14:27:00)
 * @param newResource java.lang.Integer
 */
public void setResource(java.lang.Integer newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 18:13:41)
 * @param newResourcenri int
 */
public void setResourcenri(int newResourcenri) {
	resourcenri = newResourcenri;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:05:09)
 * @param newUrl java.util.Map
 */
public void setUrl(java.util.Map newUrl) {	
	url = newUrl;
	}
}
