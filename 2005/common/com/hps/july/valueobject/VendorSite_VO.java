/*
 * Created on 03.04.2006
 *
 * Справочник Поставщиков VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

import java.sql.*;

/**
 * @author IShaffigulin
 *
 * Справочник отделений Поставщиков VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class VendorSite_VO extends DomainObject {
	private Integer idVendorSite = null; //pk
	private Integer idVendor = null; //pk отделение(ссылка на VENDOR)
	private String isOwnerContract = null; //Признак организации ФИЛИАЛ Вымпелкома private Integer idOwnerNfs = null; //собственник отделения(из таблицы ownerSystemNfs)
	private Integer idOwnerNfs = null; //idOwnerNfs
	private String vendorSiteCode = null; //код отделения
	private String name = null; //Наименование отделения
	private String matchOption = null; //?
	private String address = null; //?
	private String kpp = null; //КПП
	private String useInNri = null; //использовать в NRI (Y, N)
	private String recordStatus = null; //Признак активности записи(A-активен; D-удален)
	private Integer source = null; //Источник данных(1-из системы НФС; 2-в ручном режиме)
	private String accountManagerFio = null; //ФИО руководителя
	private String directorFio = null; //ФИО руководителя
	private String directorJob = null; //должность руководителя
	private String comment = null; //Комментарии
	private Integer idVendorSiteNFS = null; //ссылка на отделение в НФС

	private String lastName = null; //
	private String firstName = null; //
	private String middleName = null; //
	private String passportSer = null; //	
	private String passportNum = null; //
	private Date passportDate = null; //
	private String passportWhom = null; //
	private String nameForPrintDoc = null; //
	private String addressForPrintDoc = null; //
	//константы источника данных:
	public final static int SOURCE_NFS = 1;
	public final static int SOURCE_NRI = 2;    
	/**
	 * 
	 */
	public VendorSite_VO(Integer idVendorSite) {
		super();
		this.idVendorSite = idVendorSite;
	}

	/**
	 * @return
	 */
	public String getAccountManagerFio() {
		return accountManagerFio;
	}

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @return
	 */
	public String getDirectorFio() {
		return directorFio;
	}

	/**
	 * @return
	 */
	public Integer getIdOwnerNfs() {
		return idOwnerNfs;
	}

	/**
	 * @return
	 */
	public Integer getIdVendor() {
		return idVendor;
	}

	/**
	 * @return
	 */
	public Integer getIdVendorSite() {
		return idVendorSite;
	}

	/**
	 * @return
	 */
	public Integer getIdVendorSiteNFS() {
		return idVendorSiteNFS;
	}

	/**
	 * @return
	 */
	public String getKpp() {
		return kpp;
	}

	/**
	 * @return
	 */
	public String getMatchOption() {
		return matchOption;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @return
	 */
	public Integer getSource() {
		return source;
	}

	/**
	 * @return
	 */
	public String getSourceStr() {
		if (getSource() == null) {
			return "";
		}
		String str = String.valueOf(getSource());
		if (getSource().intValue() == SOURCE_NFS) {
			str =  "из системы НФС";
		} else if (getSource().intValue() == SOURCE_NRI) {
			str =  "из системы NRI";
		}
		return str;
	}

	/**
	 * @return
	 */
	public String getUseInNri() {
		return useInNri;
	}

	/**
	 * @return
	 */
	public String getVendorSiteCode() {
		return vendorSiteCode;
	}

	/**
	 * @param string
	 */
	public void setAccountManagerFio(String string) {
		accountManagerFio = string;
	}

	/**
	 * @param string
	 */
	public void setAddress(String string) {
		address = string;
	}

	/**
	 * @param string
	 */
	public void setComment(String string) {
		comment = string;
	}

	/**
	 * @param string
	 */
	public void setDirectorFio(String string) {
		directorFio = string;
	}

	/**
	 * @param integer
	 */
	public void setIdOwnerNfs(Integer integer) {
		idOwnerNfs = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdVendor(Integer integer) {
		idVendor = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdVendorSite(Integer integer) {
		idVendorSite = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdVendorSiteNFS(Integer integer) {
		idVendorSiteNFS = integer;
	}

	/**
	 * @param string
	 */
	public void setKpp(String string) {
		kpp = string;
	}

	/**
	 * @param string
	 */
	public void setMatchOption(String string) {
		matchOption = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param string
	 */
	public void setRecordStatus(String string) {
		recordStatus = string;
	}

	/**
	 * @param integer
	 */
	public void setSource(Integer integer) {
		source = integer;
	}

	/**
	 * @param string
	 */
	public void setUseInNri(String string) {
		useInNri = string;
	}

	/**
	 * @param string
	 */
	public void setVendorSiteCode(String string) {
		vendorSiteCode = string;
	}

	/**
	 * @return
	 */
	public String getDirectorJob() {
		return directorJob;
	}

	/**
	 * @param string
	 */
	public void setDirectorJob(String string) {
		directorJob = string;
	}

	/**
	 * @return
	 */
	public String getIsOwnerContract() {
		return isOwnerContract;
	}

	/**
	 * @param string
	 */
	public void setIsOwnerContract(String string) {
		isOwnerContract = string;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return
	 */
	public Date getPassportDate() {
		return passportDate;
	}

	/**
	 * @return
	 */
	public String getPassportNum() {
		return passportNum;
	}

	/**
	 * @return
	 */
	public String getPassportSer() {
		return passportSer;
	}

	/**
	 * @return
	 */
	public String getPassportWhom() {
		return passportWhom;
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param string
	 */
	public void setMiddleName(String string) {
		middleName = string;
	}

	/**
	 * @param date
	 */
	public void setPassportDate(Date date) {
		passportDate = date;
	}

	/**
	 * @param string
	 */
	public void setPassportNum(String string) {
		passportNum = string;
	}

	/**
	 * @param string
	 */
	public void setPassportSer(String string) {
		passportSer = string;
	}

	/**
	 * @param string
	 */
	public void setPassportWhom(String string) {
		passportWhom = string;
	}

	/**
	 * @return
	 */
	public String getAddressForPrintDoc() {
		return addressForPrintDoc;
	}

	/**
	 * @return
	 */
	public String getNameForPrintDoc() {
		return nameForPrintDoc;
	}

	/**
	 * @param string
	 */
	public void setAddressForPrintDoc(String string) {
		addressForPrintDoc = string;
	}

	/**
	 * @param string
	 */
	public void setNameForPrintDoc(String string) {
		nameForPrintDoc = string;
	}

}
