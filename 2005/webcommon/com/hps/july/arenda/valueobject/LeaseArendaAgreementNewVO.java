package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.*;
import java.math.*;
import java.sql.*;
/**
 * Bean-Wrapper "Дополнительные соглашения по аренде"
 */
public class LeaseArendaAgreementNewVO {
	private LeaseArendaAgrmntVO o;
	private java.lang.String mainDocumentNumber;
	private java.sql.Date mainStartDate;
	private java.sql.Date mainDocumentDate;
	private int leaseDocument;
	private java.lang.String mainPosition;
	private java.lang.String allPositions;
	private BigDecimal trafic1;
	private java.math.BigDecimal trafic2;
	private java.lang.String resources;
	private WorkerVO mainEconomist; //ответственный экономист
	private WorkerVO mainManager; //отв. Поисковик
	private java.math.BigDecimal accept1;//сумму безакцептного трафика по договору в основной валюте
	private java.math.BigDecimal accept2;//сумму безакцептного трафика по договору в дополнительной валюте
	private Date mainEndDate;
	private OrganizationVO mainOrgCustomer;
	private OrganizationVO mainOrgExecutor;
	private String mainContractState;
	private java.sql.Date mainDateClose;
	private Integer countProblemOnContract;//кол-во проблем
	private String numRegistryDoc = null;//номер описи
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 16:21:48)
 */
public LeaseArendaAgreementNewVO() {}
/**
 * LeaseArendaAgreementNewValueObject constructor comment.
 */
public LeaseArendaAgreementNewVO(LeaseArendaAgrmntVO bean) {
	super();
	o = bean;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2004 11:36:31)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAccept1() {
	return accept1;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2004 11:37:02)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAccept2() {
	return accept2;
}
/**
 * Insert the method's description here.
 * Creation date: (24.02.2004 16:26:52)
 * @return java.lang.String
 */
public java.lang.String getAllPositions() {
	return allPositions;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 15:37:40)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (08.09.2004 17:37:40)
 * @return java.lang.String
 */
public java.lang.String getMainContractState() {
	return mainContractState;
}
/**
 * Insert the method's description here.
 * Creation date: (21.03.2005 16:25:23)
 * @return java.sql.Date
 */
public java.sql.Date getMainDateClose() {
	return mainDateClose;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 14:57:04)
 * @return java.sql.Date
 */
public java.sql.Date getMainDocumentDate() {
	return mainDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:20:38)
 * @return java.lang.String
 */
public java.lang.String getMainDocumentNumber() {
	return mainDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2004 19:16:30)
 * @return com.hps.july.arenda.valueobject.WorkerVO
 */
public WorkerVO getMainEconomist() {
	return mainEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 16:35:06)
 * @return java.sql.Date
 */
public Date getMainEndDate() {
	return mainEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2004 19:16:30)
 * @return com.hps.july.arenda.valueobject.WorkerVO
 */
public WorkerVO getMainManager() {
	return mainManager;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 17:05:48)
 * @return com.hps.july.arenda.valueobject.OrganizationVO
 */
public OrganizationVO getMainOrgCustomer() {
	return mainOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 17:06:29)
 * @return com.hps.july.arenda.valueobject.OrganizationVO
 */
public OrganizationVO getMainOrgExecutor() {
	return mainOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (06.02.2004 18:55:28)
 * @return java.lang.String
 */
public java.lang.String getMainPosition() {
	return mainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:19:46)
 * @return java.sql.Date
 */
public java.sql.Date getMainStartDate() {
	return mainStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:03:50)
 * @return com.hps.july.persistence.LeaseArendaAgreementNewAccessBean
 */
public LeaseArendaAgrmntVO getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 17:05:51)
 * @return java.lang.String
 */
public java.lang.String getResources() {
	return resources;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 16:01:13)
 * @return java.math.BigDecimal
 */
public BigDecimal getTrafic1() {
	return trafic1;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 16:01:41)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getTrafic2() {
	return trafic2;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2004 11:36:31)
 * @param newAccept1 java.math.BigDecimal
 */
public void setAccept1(java.math.BigDecimal newAccept1) {
	accept1 = newAccept1;
}
/**
 * Insert the method's description here.
 * Creation date: (20.05.2004 11:37:02)
 * @param newAccept2 java.math.BigDecimal
 */
public void setAccept2(java.math.BigDecimal newAccept2) {
	accept2 = newAccept2;
}
/**
 * Insert the method's description here.
 * Creation date: (24.02.2004 16:26:52)
 * @param newAllPositions java.lang.String
 */
public void setAllPositions(java.lang.String newAllPositions) {
	allPositions = newAllPositions;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 15:37:40)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (08.09.2004 17:37:40)
 * @param newMainContractState java.lang.String
 */
public void setMainContractState(java.lang.String newMainContractState) {
	mainContractState = newMainContractState;
}
/**
 * Insert the method's description here.
 * Creation date: (21.03.2005 16:25:23)
 * @param newMainDateClose java.sql.Date
 */
public void setMainDateClose(java.sql.Date newMainDateClose) {
	mainDateClose = newMainDateClose;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 14:57:04)
 * @param newMainDocumentDate java.sql.Date
 */
public void setMainDocumentDate(java.sql.Date newMainDocumentDate) {
	mainDocumentDate = newMainDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:20:38)
 * @param newMainDocumentNumber java.lang.String
 */
public void setMainDocumentNumber(java.lang.String newMainDocumentNumber) {
	mainDocumentNumber = newMainDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2004 19:16:30)
 * @param newMainEconomist com.hps.july.arenda.valueobject.WorkerVO
 */
public void setMainEconomist(WorkerVO newMainEconomist) {
	mainEconomist = newMainEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 16:35:06)
 * @param newMainEndDate java.sql.Date
 */
public void setMainEndDate(Date newMainEndDate) {
	mainEndDate = newMainEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2004 19:16:30)
 * @param newMainManager com.hps.july.arenda.valueobject.WorkerVO
 */
public void setMainManager(WorkerVO newMainManager) {
	mainManager = newMainManager;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 17:05:48)
 * @param newMainOrgCustomer com.hps.july.arenda.valueobject.OrganizationVO
 */
public void setMainOrgCustomer(OrganizationVO newMainOrgCustomer) {
	mainOrgCustomer = newMainOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 17:06:29)
 * @param newMainOrgExecutor com.hps.july.arenda.valueobject.OrganizationVO
 */
public void setMainOrgExecutor(OrganizationVO newMainOrgExecutor) {
	mainOrgExecutor = newMainOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (06.02.2004 18:55:28)
 * @param newNamePosition java.lang.String
 */
public void setMainPosition(java.lang.String newMainPosition) {
	mainPosition = newMainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:19:46)
 * @param newMainStartDate java.sql.Date
 */
public void setMainStartDate(java.sql.Date newMainStartDate) {
	mainStartDate = newMainStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2002 12:03:50)
 * @param newO com.hps.july.persistence.LeaseArendaAgreementNewAccessBean
 */
public void setO(LeaseArendaAgrmntVO newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 17:05:51)
 * @param newResources java.lang.String
 */
public void setResources(java.lang.String newResources) {
	resources = newResources;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 16:01:13)
 * @param newTrafic1 java.math.BigDecimal
 */
public void setTrafic1(BigDecimal newTrafic1) {
	trafic1 = newTrafic1;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 16:01:41)
 * @param newTrafic2 java.math.BigDecimal
 */
public void setTrafic2(java.math.BigDecimal newTrafic2) {
	trafic2 = newTrafic2;
}
	/**
	 * @return
	 */
	public Integer getCountProblemOnContract() {
		return countProblemOnContract;
	}

	/**
	 * @param integer
	 */
	public void setCountProblemOnContract(Integer integer) {
		countProblemOnContract = integer;
	}

	/**
	 * @return
	 */
	public String getNumRegistryDoc() {
		return numRegistryDoc;
	}

	/**
	 * @param string
	 */
	public void setNumRegistryDoc(String string) {
		numRegistryDoc = string;
	}

}
