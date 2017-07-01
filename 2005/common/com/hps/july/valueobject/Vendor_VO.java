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
 * ���������� ����������� VO.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Vendor_VO extends DomainObject {
	private Integer idVendor = null; //pk
	private Integer vendorCode = null; //��� ����������
	private Timestamp end_date_active; //���� ��������� ������������� ���������� � ���
	private String name = null; //������������ ����������
	private String inn = null; //��� ����������
	private String type = null; //��� ���������� � ���
	private String useInNri = null; //������������ � NRI (Y, N)
	private Integer source = null; //�������� ������(1-�� ������� ���; 2-� ������ ������)
	//��������� ��������� ������:
	public final static int SOURCE_NFS = 1;
	public final static int SOURCE_NRI = 2;
	private String recordStatus = null; //������� ���������� ������(A-�������; D-������)
	private String accountManagerFio = null; //��� ����������
	private String directorFio = null; //��� ������������
	private String directorJob = null; //��������� ������������
	private String phisicalAddress = null; //���������� �����
	private String legalAddress = null; //����������� �����
	private String comment = null; //�����������
	private Integer idVendorNfs = null; //������ �� ����. � ���
	//��� (1-�����������, 2-����������, 3- ������):
	private Integer typeVendor = null;
	public final static int TYPE_VENDOR_JURIDICAL = 1;
	public final static int TYPE_VENDOR_PHYSICAL = 2;  
	public final static int TYPE_VENDOR_OTHER = 3;

	private String lastName = null;//
	private String firstName = null;//
	private String middleName = null;//
	private String passportSer = null;//	
	private String passportNum = null;//
	private Date passportDate = null;//
	private String passportWhom = null;//
	private String nameForPrintDoc = null;//
	private String addressForPrintDoc =null;//	
	/**
	 * 
	 */
	public Vendor_VO(Integer idVendor) {
		super();
		this.idVendor = idVendor;
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
	public String getLegalAddress() {
		return legalAddress;
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
	 * @param integer
	 */
	public void setIdVendor(Integer integer) {
		idVendor = integer;
	}

	/**
	 * @param string
	 */
	public void setLegalAddress(String string) {
		legalAddress = string;
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
	 * @return
	 */
	public Integer getVendorCode() {
		return vendorCode;
	}

	/**
	 * @param integer
	 */
	public void setVendorCode(Integer integer) {
		vendorCode = integer;
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
	public Timestamp getEnd_date_active() {
		return end_date_active;
	}

	/**
	 * @return
	 */
	public Integer getIdVendorNfs() {
		return idVendorNfs;
	}

	/**
	 * @return
	 */
	public String getInn() {
		return inn;
	}

	/**
	 * @return
	 */
	public String getPhisicalAddress() {
		return phisicalAddress;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return
	 */
	public String getUseInNri() {
		return useInNri;
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
	 * @param timestamp
	 */
	public void setEnd_date_active(Timestamp timestamp) {
		end_date_active = timestamp;
	}

	/**
	 * @param integer
	 */
	public void setIdVendorNfs(Integer integer) {
		idVendorNfs = integer;
	}

	/**
	 * @param string
	 */
	public void setInn(String string) {
		inn = string;
	}

	/**
	 * @param string
	 */
	public void setPhisicalAddress(String string) {
		phisicalAddress = string;
	}

	/**
	 * @param string
	 */
	public void setType(String string) {
		type = string;
	}

	/**
	 * @param string
	 */
	public void setUseInNri(String string) {
		useInNri = string;
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
	 * @return
	 */
	public Integer getTypeVendor() {
		return typeVendor;
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
	 * @param integer
	 */
	public void setTypeVendor(Integer integer) {
		typeVendor = integer;
	}
	/**
	 * @param integer
	 */
	public String getTypeVendorStr() {
		if(getTypeVendor() == null){
			return "";
		}
		String typeVendorStr = String.valueOf(getTypeVendor());
		if (TYPE_VENDOR_JURIDICAL == getTypeVendor().intValue()) {
			typeVendorStr = "����.";
		} else if (TYPE_VENDOR_PHYSICAL == getTypeVendor().intValue()) {
			typeVendorStr = "���.";
		} else if (TYPE_VENDOR_OTHER == getTypeVendor().intValue()) {
			typeVendorStr = "������";
		}
		return typeVendorStr;
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
