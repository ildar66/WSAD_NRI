/*
 * Created on 14.09.2006
 *
 * ��� ������ ���� ����������� �����.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

/**
 * @author IShaffigulin
 *
 * ��� ������ ���� ����������� �����.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PrintComplectAct_TO {
	WorkerVO workVO = null;//��� ���������, ���������  ���������
	OrganizationVO orgVO = null;//��� ���������, ������������ ���������
	String executorName = null;//������������ �����������
	String executorAddress = null;//����� �����������
	String executorFio = null;//��� �����������
	String executorWorkPosition = null;// ���������  �����������
	String positionName = null;//������������ �������
	/**
	 * 
	 */
	public PrintComplectAct_TO(OrganizationVO aOrgVO, WorkerVO aWorkVO) {
		super();
		setOrgVO(aOrgVO);
		setWorkVO(aWorkVO);
	}

	/**
	 * @return
	 */
	public OrganizationVO getOrgVO() {
		return orgVO;
	}

	/**
	 * @return
	 */
	public WorkerVO getWorkVO() {
		return workVO;
	}

	/**
	 * @param organizationVO
	 */
	private void setOrgVO(OrganizationVO organizationVO) {
		orgVO = organizationVO;
	}

	/**
	 * @param workerVO
	 */
	private void setWorkVO(WorkerVO workerVO) {
		workVO = workerVO;
	}

	/**
	 * @return
	 */
	public String getExecutorAddress() {
		return executorAddress;
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
	public void setExecutorAddress(String string) {
		executorAddress = string;
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
	public String getExecutorFio() {
		return executorFio;
	}

	/**
	 * @return
	 */
	public String getExecutorWorkPosition() {
		return executorWorkPosition;
	}

	/**
	 * @return
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * @param string
	 */
	public void setExecutorFio(String string) {
		executorFio = string;
	}

	/**
	 * @param string
	 */
	public void setExecutorWorkPosition(String string) {
		executorWorkPosition = string;
	}

	/**
	 * @param string
	 */
	public void setPositionName(String string) {
		positionName = string;
	}

}
