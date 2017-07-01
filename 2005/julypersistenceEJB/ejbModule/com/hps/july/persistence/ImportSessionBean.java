package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * ������ ������� ������
 */
public class ImportSessionBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	public int errcount;
	public String filename;
	public int filesize;
	public java.sql.Timestamp filetime;
	public java.sql.Timestamp importend;
	public java.sql.Timestamp importstart;
	public int impsesid;
	public int reccount;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer importtask_imptaskid;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink importtaskLink = null;
	public java.lang.Integer operator_operator;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink operatorLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink importRecordsLink = null;
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Hashtable _copyFromEJB() {
        com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

        h.put("operatorKey", getOperatorKey());
        h.put("errcount", new Integer(getErrcount()));
        h.put("importstart", getImportstart());
        h.put("importtaskKey", getImporttaskKey());
        h.put("importend", getImportend());
        h.put("filename", getFilename());
        h.put("filesize", new Integer(getFilesize()));
        h.put("filetime", getFiletime());
        h.put("impsesid", new Integer(getImpsesid()));
        h.put("reccount", new Integer(getReccount()));
        h.put("__Key", getEntityContext().getPrimaryKey());

        return h;

}
/**
 * This method was generated by the VisualAge for Java EJB AccessBean tool.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void _copyToEJB(java.util.Hashtable h) {
        Integer localErrcount = (Integer) h.get("errcount");
        java.sql.Timestamp localImportstart = (java.sql.Timestamp) h.get("importstart");
        java.sql.Timestamp localImportend = (java.sql.Timestamp) h.get("importend");
        java.lang.String localFilename = (java.lang.String) h.get("filename");
        Integer localFilesize = (Integer) h.get("filesize");
        java.sql.Timestamp localFiletime = (java.sql.Timestamp) h.get("filetime");
        Integer localReccount = (Integer) h.get("reccount");

        if ( h.containsKey("errcount") )
            setErrcount((localErrcount).intValue());
        if ( h.containsKey("importstart") )
            setImportstart((localImportstart));
        if ( h.containsKey("importend") )
            setImportend((localImportend));
        if ( h.containsKey("filename") )
            setFilename((localFilename));
        if ( h.containsKey("filesize") )
            setFilesize((localFilesize).intValue());
        if ( h.containsKey("filetime") )
            setFiletime((localFiletime));
        if ( h.containsKey("reccount") )
            setReccount((localReccount).intValue());

}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getImporttaskLink());
	links.addElement(getOperatorLink());
	links.addElement(getImportRecordsLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	importtaskLink = null;
	operatorLink = null;
	importRecordsLink = null;
}
/**
 * This method was generated for supporting the associations.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _removeLinks() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	java.util.Enumeration links = _getLinks().elements();
	while (links.hasMoreElements()) {
		try {
			((com.ibm.ivj.ejb.associations.interfaces.Link) (links.nextElement())).remove();
		}
		catch (javax.ejb.FinderException e) {} //Consume Finder error since I am going away
	}
}
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addImportRecords(com.hps.july.persistence.ImportRecord anImportRecords) throws java.rmi.RemoteException {
	this.getImportRecordsLink().addElement(anImportRecords);
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argImpsesid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argImpsesid, int argImpTaskid, java.sql.Timestamp argImportStart,
		java.sql.Timestamp argImportEnd, int argOperator, String argFilename, int argFilesize,
		int argReccount, int argErrcount) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	impsesid = argImpsesid;
	importtask_imptaskid = new Integer(argImpTaskid);
	importstart = argImportStart;
	importend = argImportEnd;
	operator_operator = new Integer(argOperator);
	filename = argFilename;
	filesize = argFilesize;
	reccount = argReccount;
	errcount = argErrcount;
	filetime = null;
}
/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argImpsesid int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argImpsesid) throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	_removeLinks();
}
/**
 * ejbStore method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbStore() throws java.rmi.RemoteException {}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for errcount
 * @return int
 */
public int getErrcount() {
	return errcount;
}
/**
 * Getter method for filename
 * @return java.lang.String
 */
public java.lang.String getFilename() {
	return filename;
}
/**
 * Getter method for filesize
 * @return int
 */
public int getFilesize() {
	return filesize;
}
/**
 * Getter method for filetime
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getFiletime() {
	return filetime;
}
/**
 * Getter method for importend
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getImportend() {
	return importend;
}
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getImportRecords() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getImportRecordsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getImportRecordsLink() {
	if (importRecordsLink == null)
		importRecordsLink = new ImportSessionToImportRecordsLink(this);
	return importRecordsLink;
}
/**
 * Getter method for importstart
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getImportstart() {
	return importstart;
}
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ImportTask getImporttask() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.ImportTask)this.getImporttaskLink().value();
}
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ImportTaskKey getImporttaskKey() {
	com.hps.july.persistence.ImportTaskKey temp = null;
	temp = new com.hps.july.persistence.ImportTaskKey();
	boolean importtask_NULLTEST = true;
	importtask_NULLTEST &= (importtask_imptaskid == null);
	temp.imptaskid = ((importtask_imptaskid == null) ? 0 : importtask_imptaskid.intValue());
	if (importtask_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getImporttaskLink() {
	if (importtaskLink == null)
		importtaskLink = new ImportSessionToImporttaskLink(this);
	return importtaskLink;
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 12:32:12)
 * @return int
 */
public int getImpsesid() {
	return impsesid;
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Operator getOperator() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Operator)this.getOperatorLink().value();
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OperatorKey getOperatorKey() {
	com.hps.july.persistence.OperatorKey temp = null;
	temp = new com.hps.july.persistence.OperatorKey();
	boolean operator_NULLTEST = true;
	operator_NULLTEST &= (operator_operator == null);
	temp.operator = ((operator_operator == null) ? 0 : operator_operator.intValue());
	if (operator_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOperatorLink() {
	if (operatorLink == null)
		operatorLink = new ImportSessionToOperatorLink(this);
	return operatorLink;
}
/**
 * Getter method for reccount
 * @return int
 */
public int getReccount() {
	return reccount;
}
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetImporttaskKey(com.hps.july.persistence.ImportTaskKey inKey) {
	boolean importtask_NULLTEST = (inKey == null);
	if (importtask_NULLTEST) importtask_imptaskid = null; else importtask_imptaskid = (new Integer(inKey.imptaskid));
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOperatorKey(com.hps.july.persistence.OperatorKey inKey) {
	boolean operator_NULLTEST = (inKey == null);
	if (operator_NULLTEST) operator_operator = null; else operator_operator = (new Integer(inKey.operator));
}
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddImportRecords(com.hps.july.persistence.ImportRecord anImportRecords) {
	this.getImportRecordsLink().secondaryAddElement(anImportRecords);
}
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveImportRecords(com.hps.july.persistence.ImportRecord anImportRecords) {
	this.getImportRecordsLink().secondaryRemoveElement(anImportRecords);
}
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetImporttask(com.hps.july.persistence.ImportTask anImporttask) throws java.rmi.RemoteException {
	this.getImporttaskLink().secondarySet(anImporttask);
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException {
	this.getOperatorLink().secondarySet(anOperator);
}
/**
 * setEntityContext method comment
 * @param ctx javax.ejb.EntityContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setEntityContext(javax.ejb.EntityContext ctx) throws java.rmi.RemoteException {
	entityContext = ctx;
}
/**
 * Setter method for errcount
 * @param newValue int
 */
public void setErrcount(int newValue) {
	this.errcount = newValue;
}
/**
 * Setter method for filename
 * @param newValue java.lang.String
 */
public void setFilename(java.lang.String newValue) {
	this.filename = newValue;
}
/**
 * Setter method for filesize
 * @param newValue int
 */
public void setFilesize(int newValue) {
	this.filesize = newValue;
}
/**
 * Setter method for filetime
 * @param newValue java.sql.Timestamp
 */
public void setFiletime(java.sql.Timestamp newValue) {
	this.filetime = newValue;
}
/**
 * Setter method for importend
 * @param newValue java.sql.Timestamp
 */
public void setImportend(java.sql.Timestamp newValue) {
	this.importend = newValue;
}
/**
 * Setter method for importstart
 * @param newValue java.sql.Timestamp
 */
public void setImportstart(java.sql.Timestamp newValue) {
	this.importstart = newValue;
}
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setImporttask(com.hps.july.persistence.ImportTask anImporttask) throws java.rmi.RemoteException {
	this.getImporttaskLink().set(anImporttask);
}
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException {
	this.getOperatorLink().set(anOperator);
}
/**
 * Setter method for reccount
 * @param newValue int
 */
public void setReccount(int newValue) {
	this.reccount = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}
