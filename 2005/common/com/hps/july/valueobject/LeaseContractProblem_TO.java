/*
 * Created on 27.06.2006
 *
 * "Проблемы ведения договоров" TO.
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * "Проблемы ведения договоров" TO.
 */
public class LeaseContractProblem_TO extends Base_TO {
	private String executorName = null;
	private String ownerName = null;
	private String createdByName = null;
	private String modifiedByName = null;
	private String docNumber = null;
	private java.sql.Date docDate = null;
	private String listPosContract = null;
	private String mailAddressExecutor = null;
	private String mailAddressOwner = null;
	/**
	 * 
	 * @param aVO
	 */
	public LeaseContractProblem_TO(LeaseContractProblem_VO aVO) {
		vo = aVO;
	}
	private LeaseContractProblem_VO vo = null;
	/**
	 * @return
	 */
	public LeaseContractProblem_VO getVo() {
		return vo;
	}

	/**
	 * @param problem_VO
	 */
	public void setVo(LeaseContractProblem_VO problem_VO) {
		vo = problem_VO;
	}

	/**
	 * @return
	 */
	public String getExecutorName() {
		return executorName;
	}

	/**
	 * @param string
	 */
	public void setExecutorName(String string) {
		executorName = string;
	}

	/**
	 * @return
	 */
	public String getCreatedByName() {
		return createdByName;
	}

	/**
	 * @return
	 */
	public String getModifiedByName() {
		return modifiedByName;
	}

	/**
	 * @param string
	 */
	public void setCreatedByName(String string) {
		createdByName = string;
	}

	/**
	 * @param string
	 */
	public void setModifiedByName(String string) {
		modifiedByName = string;
	}

	/**
	 * @return
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param string
	 */
	public void setOwnerName(String string) {
		ownerName = string;
	}

	/**
	 * @return
	 */
	public java.sql.Date getDocDate() {
		return docDate;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @param date
	 */
	public void setDocDate(java.sql.Date date) {
		docDate = date;
	}

	/**
	 * @param string
	 */
	public void setDocNumber(String string) {
		docNumber = string;
	}

	/**
	 * @return
	 */
	public String getListPosContract() {
		return listPosContract;
	}

	/**
	 * @param string
	 */
	public void setListPosContract(String string) {
		listPosContract = string;
	}

	/**
	 * @return
	 */
	public String getMailAddressExecutor() {
		return mailAddressExecutor;
	}

	/**
	 * @return
	 */
	public String getMailAddressOwner() {
		return mailAddressOwner;
	}

	/**
	 * @param string
	 */
	public void setMailAddressExecutor(String string) {
		mailAddressExecutor = string;
	}

	/**
	 * @param string
	 */
	public void setMailAddressOwner(String string) {
		mailAddressOwner = string;
	}

}
