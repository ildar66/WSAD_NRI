/*
 * Created on 03.04.2006
 *
 * ���������� ����������� VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

import java.sql.*;

/**
 * @author IShaffigulin
 *
 * ���������� ��������� ����������� VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class VendorSite_VO extends DomainObject {
	private Integer idVendorSite = null; //pk
	private Integer idVendor = null; //pk ���������(������ �� VENDOR)
	private String isOwnerContract = null; //������� ����������� ������ ���������� private Integer idOwnerNfs = null; //����������� ���������(�� ������� ownerSystemNfs)
	private Integer idOwnerNfs = null; //idOwnerNfs
	private String vendorSiteCode = null; //��� ���������
	private String name = null; //������������ ���������
	private String matchOption = null; //?
	private String address = null; //?
	private String kpp = null; //���
	private String useInNri = null; //������������ � NRI (Y, N)
	private String recordStatus = null; //������� ���������� ������(A-�������; D-������)
	private Integer source = null; //�������� ������(1-�� ������� ���; 2-� ������ ������)
	private String accountManagerFio = null; //��� ������������
	private String directorFio = null; //��� ������������
	private String directorJob = null; //��������� ������������
	private String comment = null; //�����������
	private Integer idVendorSiteNFS = null; //������ �� ��������� � ���

	private String lastName = null; //
	private String firstName = null; //
	private String middleName = null; //
	private String passportSer = null; //	
	private String passportNum = null; //
	private Date passportDate = null; //
	private String passportWhom = null; //
	private String nameForPrintDoc = null; //
	private String addressForPrintDoc = null; //
	//��������� ��������� ������:
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
			str =  "�� ������� ���";
		} else if (getSource().intValue() == SOURCE_NRI) {
			str =  "�� ������� NRI";
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
