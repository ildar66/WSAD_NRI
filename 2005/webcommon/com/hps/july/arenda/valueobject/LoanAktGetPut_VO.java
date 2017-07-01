package com.hps.july.arenda.valueobject;

/**
 * Акты према-передачи VO.
 * Creation date: (07.11.2005 13:31:54)
 * @author: Shafigullin Ildar
 */
public class LoanAktGetPut_VO extends com.hps.july.valueobject.DomainObject {
    private java.lang.Integer idAct; //код акта
    private java.lang.Integer loanContract; //ссылка на договор
    private java.lang.String numberAct; //номер акта
    private java.sql.Date dateAct; //дата акта
    private java.lang.Integer ourMan; //ссылка на People (кто выдывал)
    private java.lang.String otherMan; // кто получал
	private java.lang.String typeAct;//1- выдача, 2-возарат
	private java.lang.Integer idLeasebill;// код счета для передачи (м.б. NULL)
/**
 * LoanAktGetPut_VO constructor comment.
 */
public LoanAktGetPut_VO(Integer id, Integer loanContractID) {
    super();
    idAct = id;
    loanContract = loanContractID;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:44:21)
 * @return java.sql.Date
 */
public java.sql.Date getDateAct() {
	return dateAct;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:42:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdAct() {
	return idAct;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:48:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdLeasebill() {
	return idLeasebill;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:43:07)
 * @return java.lang.Integer
 */
public java.lang.Integer getLoanContract() {
	return loanContract;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:43:38)
 * @return java.lang.String
 */
public java.lang.String getNumberAct() {
	return numberAct;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:46:21)
 * @return java.lang.String
 */
public java.lang.String getOtherMan() {
	return otherMan;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:45:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getOurMan() {
	return ourMan;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:47:18)
 * @return java.lang.String
 */
public java.lang.String getTypeAct() {
	return typeAct;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:44:21)
 * @param newDateAct java.sql.Date
 */
public void setDateAct(java.sql.Date newDateAct) {
	dateAct = newDateAct;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:42:42)
 * @param newIdAct java.lang.Integer
 */
public void setIdAct(java.lang.Integer newIdAct) {
	idAct = newIdAct;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:48:12)
 * @param newIdLeasebill java.lang.Integer
 */
public void setIdLeasebill(java.lang.Integer newIdLeasebill) {
	idLeasebill = newIdLeasebill;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:43:07)
 * @param newLoanContract java.lang.Integer
 */
public void setLoanContract(java.lang.Integer newLoanContract) {
	loanContract = newLoanContract;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:43:38)
 * @param newNumberAct java.lang.String
 */
public void setNumberAct(java.lang.String newNumberAct) {
	numberAct = newNumberAct;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:46:21)
 * @param newOtherMan java.lang.String
 */
public void setOtherMan(java.lang.String newOtherMan) {
	otherMan = newOtherMan;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:45:25)
 * @param newOurMan java.lang.Integer
 */
public void setOurMan(java.lang.Integer newOurMan) {
	ourMan = newOurMan;
}
/**
 * Insert the method's description here.
 * Creation date: (07.11.2005 13:47:18)
 * @param newTypeAct java.lang.String
 */
public void setTypeAct(java.lang.String newTypeAct) {
	typeAct = newTypeAct;
}
}
