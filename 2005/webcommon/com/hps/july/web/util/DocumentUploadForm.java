package com.hps.july.web.util;

/**
 * Общая форма загрузки документа (upload) - 
 * обработка загрузки документов WORD.
 * Creation date: (20.01.2004 18:17:48)
 * @author: Dmitry Dneprov
 */
public class DocumentUploadForm extends org.apache.struts.action.ActionForm {
	private int documentid;
	private org.apache.struts.upload.FormFile filebody;
	private Integer typeDoc = null;
	private String objectType = null;
/**
 * Returns document ID of the file.
 * Creation date: (20.01.2004 18:19:58)
 * @return int
 */
public int getDocumentid() {
	return documentid;
}
/**
 * Returns the file body object.
 * Creation date: (20.01.2004 18:20:38)
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getFilebody() {
	return filebody;
}
/**
 * Returns name of the file.
 * Creation date: (20.01.2004 18:19:25)
 * @return java.lang.String
 */
public java.lang.String getFilename() {
	if (!isEmpty())
		return getFilebody().getFileName();
	else
		return null;
}
/**
 * Checks if file has been received.
 * Creation date: (20.01.2004 18:26:01)
 * @return boolean
 */
public boolean isEmpty() {
	boolean result = false;
	try {
		if (  (getFilebody() == null)  || 
			  (getFilebody() != null && getFilebody().getFileData() == null) )
				result = true;
	} catch (Exception e) {
		e.printStackTrace(System.out);
		result = true;
	}
	return result;
}
/**
 * Sets document ID of the file.
 * Creation date: (20.01.2004 18:19:58)
 * @param newDocumentid int
 */
public void setDocumentid(int newDocumentid) {
	documentid = newDocumentid;
}
/**
 * Sets the file body object.
 * Creation date: (20.01.2004 18:20:38)
 * @param newFilebody org.apache.struts.upload.FormFile
 */
public void setFilebody(org.apache.struts.upload.FormFile newFilebody) {
	filebody = newFilebody;
}
	/**
	 * @return
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * @return
	 */
	public Integer getTypeDoc() {
		return typeDoc;
	}

	/**
	 * @param string
	 */
	public void setObjectType(String string) {
		objectType = string;
	}

	/**
	 * @param integer
	 */
	public void setTypeDoc(Integer integer) {
		typeDoc = integer;
	}

}
