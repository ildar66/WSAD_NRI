package com.hps.july.basestation.valueobject;

import java.sql.*;

import com.hps.july.basestation.actionbean.ChooseDocumentFormConstants;
/**
* Псевдо-обьект, отражающий список работ и документов.
* Creation date: (28.07.2005 10:43:03)
* @author: Shafigullin Ildar
*/
public class DocAndWorkForGSM_VO implements ChooseDocumentFormConstants {
    private java.lang.String type; //D - документ, W-работа
	private java.lang.String docTypeCode; //код типа документа
	private java.lang.Integer visualType; // тип визуального представления
	private java.lang.String state; // статус документа 1-в работе, 2-обсчитан
	private java.lang.String isAutoDoc; // автоматически созданный документ Y / N
    private java.lang.Integer idDoc; //код документа или код работы
    private java.lang.String numberDoc; //номер документа
    private Date dateDoc;//дата документа
	private java.lang.String fio;//ФИО работника
	private java.lang.String typeDoc;//тип работы
	private java.lang.String noteWork;//примечание
	private java.lang.String nameEquipment;//комплект
/**
 * DocAndWorkForGSM_VO constructor comment.
 */
public DocAndWorkForGSM_VO(String type, String docTypeCode, Integer visualType, String state, String isAutoDoc, Integer idDoc, String numberDoc, java.sql.Date dateDoc, String fio, String typeDoc, String noteWork, String nameEquipment) {
	super();
	this.type = type;
	this.docTypeCode = docTypeCode;
	this.visualType = visualType;
	this.state = state;
	this.isAutoDoc = isAutoDoc; 
	this.idDoc = idDoc;
	this.numberDoc = numberDoc;
	this.dateDoc = dateDoc;
	this.fio = fio;
	this.typeDoc = typeDoc;
	this.noteWork = noteWork;
	this.nameEquipment = nameEquipment;
}
public Boolean getIsDocTypeCodeCanBeLinked() {
	Boolean outBool = new Boolean(false);
	if ((docTypeCode != null) && (docTypeCode.length() > 0)) {
		char docTypeCodeChar = docTypeCode.charAt(0);
		for (int i = 0; i < DOC_CODES_ARRAY.length; i++) {
			if (docTypeCodeChar == DOC_CODES_ARRAY[i]) {
				outBool = new Boolean(true);
				break;
			}
		}
	}
	return outBool;
}
public void setIsDocTypeCodeCanBeLinked(Boolean mock) {
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:45:52)
 * @return java.sql.Date
 */
public java.sql.Date getDateDoc() {
	return dateDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:48:40)
 * @return java.lang.String
 */
public java.lang.String getFio() {
	return fio;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:44:27)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdDoc() {
	return idDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:50:15)
 * @return java.lang.String
 */
public java.lang.String getNameEquipment() {
	return nameEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:49:42)
 * @return java.lang.String
 */
public java.lang.String getNoteWork() {
	return noteWork;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:45:22)
 * @return java.lang.String
 */
public java.lang.String getNumberDoc() {
	return numberDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:43:47)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:49:06)
 * @return java.lang.String
 */
public java.lang.String getTypeDoc() {
	return typeDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:45:52)
 * @param newDateDoc java.sql.Date
 */
public void setDateDoc(java.sql.Date newDateDoc) {
	dateDoc = newDateDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:48:40)
 * @param newFio java.lang.String
 */
public void setFio(java.lang.String newFio) {
	fio = newFio;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:44:27)
 * @param newIdDoc java.lang.Integer
 */
public void setIdDoc(java.lang.Integer newIdDoc) {
	idDoc = newIdDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:50:15)
 * @param newNameEquipment java.lang.String
 */
public void setNameEquipment(java.lang.String newNameEquipment) {
	nameEquipment = newNameEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:49:42)
 * @param newNoteWork java.lang.String
 */
public void setNoteWork(java.lang.String newNoteWork) {
	noteWork = newNoteWork;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:45:22)
 * @param newNumberDoc java.lang.String
 */
public void setNumberDoc(java.lang.String newNumberDoc) {
	numberDoc = newNumberDoc;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:43:47)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 10:49:06)
 * @param newTypeDoc java.lang.String
 */
public void setTypeDoc(java.lang.String newTypeDoc) {
	typeDoc = newTypeDoc;
}
	/**
	 * @return
	 */
	public java.lang.String getDocTypeCode() {
		return docTypeCode;
	}

	/**
	 * @param string
	 */
	public void setDocTypeCode(java.lang.String string) {
		docTypeCode = string;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getVisualType() {
		return visualType;
	}

	/**
	 * @param integer
	 */
	public void setVisualType(java.lang.Integer integer) {
		visualType = integer;
	}

	/**
	 * @return
	 */
	public java.lang.String getIsAutoDoc() {
		return isAutoDoc;
	}

	/**
	 * @return
	 */
	public java.lang.String getState() {
		return state;
	}

	/**
	 * @param string
	 */
	public void setIsAutoDoc(java.lang.String string) {
		isAutoDoc = string;
	}

	/**
	 * @param string
	 */
	public void setState(java.lang.String string) {
		state = string;
	}

}
