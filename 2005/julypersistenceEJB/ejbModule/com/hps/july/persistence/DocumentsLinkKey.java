package com.hps.july.persistence;

public class DocumentsLinkKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.String type;
	public java.lang.Integer documentfrom_document;
	public java.lang.Integer documentTo_document;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DocumentsLinkKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argType java.lang.String
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DocumentsLinkKey(java.lang.String argType) {
	type = argType;
}
/**
 * Initialize a key from the passed values
 * @param argType java.lang.String
 * @param argDocumentfrom com.hps.july.persistence.DocumentKey
 * @param argDocumentTo com.hps.july.persistence.DocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public DocumentsLinkKey(java.lang.String argType, DocumentKey argDocumentfrom, DocumentKey argDocumentTo) {
	type = argType;
	privateSetDocumentfromKey(argDocumentfrom);
	privateSetDocumentToKey(argDocumentTo);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof DocumentsLinkKey) {
		DocumentsLinkKey otherKey = (DocumentsLinkKey) o;
		return ((this.type.equals(otherKey.type)
		 && this.documentfrom_document.equals(otherKey.documentfrom_document)
		 && this.documentTo_document.equals(otherKey.documentTo_document)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named DocumentsLink2FirstDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.DocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getDocumentfromKey() {
	com.hps.july.persistence.DocumentKey temp = null;
	temp = new com.hps.july.persistence.DocumentKey();
	boolean documentfrom_NULLTEST = true;
	documentfrom_NULLTEST &= (documentfrom_document == null);
	temp.document = ((documentfrom_document == null) ? 0 : documentfrom_document.intValue());
	if (documentfrom_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named DocumentsLink2DocumentTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.DocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getDocumentToKey() {
	com.hps.july.persistence.DocumentKey temp = null;
	temp = new com.hps.july.persistence.DocumentKey();
	boolean documentTo_NULLTEST = true;
	documentTo_NULLTEST &= (documentTo_document == null);
	temp.document = ((documentTo_document == null) ? 0 : documentTo_document.intValue());
	if (documentTo_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (type.hashCode()
		 + documentfrom_document.hashCode()
		 + documentTo_document.hashCode());
}
/**
 * This method was generated for supporting the association named DocumentsLink2FirstDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.DocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDocumentfromKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean documentfrom_NULLTEST = (inKey == null);
	if (documentfrom_NULLTEST) documentfrom_document = null; else documentfrom_document = (new Integer(inKey.document));
}
/**
 * This method was generated for supporting the association named DocumentsLink2DocumentTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.DocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDocumentToKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean documentTo_NULLTEST = (inKey == null);
	if (documentTo_NULLTEST) documentTo_document = null; else documentTo_document = (new Integer(inKey.document));
}
}
