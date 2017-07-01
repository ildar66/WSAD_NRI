package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface DocumentsLink extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named DocumentsLink2FirstDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Document getDocumentfrom() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getDocumentfrom_document() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentsLink2FirstDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getDocumentfromKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentsLink2DocumentTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Document getDocumentTo() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getDocumentTo_document() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentsLink2DocumentTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getDocumentToKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getType() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newDocumentfrom_document java.lang.Integer
 * @exception String The exception description.
 */
void setDocumentfrom_document(java.lang.Integer newDocumentfrom_document) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newDocumentTo_document java.lang.Integer
 * @exception String The exception description.
 */
void setDocumentTo_document(java.lang.Integer newDocumentTo_document) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newType java.lang.String
 * @exception String The exception description.
 */
void setType(java.lang.String newType) throws java.rmi.RemoteException;
}
