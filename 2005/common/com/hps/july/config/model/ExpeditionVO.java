/*
 * Created on 10.08.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * @author dima
 *
 */
public class ExpeditionVO implements Serializable, Comparable, Cloneable {
	
	public final static int ORGANIZATION = 1;
	public final static int WORKER = 2;

	private int code = 0;
	private int type = ORGANIZATION;
	private OrganizationVO organization = null;
	private WorkerVO worker = null;
	
	public ExpeditionVO() {
		super();
		type = ORGANIZATION;
		organization = new OrganizationVO();
		worker = new WorkerVO();
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();	
	}
	
	public ExpeditionVO(int acode, OrganizationVO aorg) {
		super();
		code = acode;
		type = ORGANIZATION;
		organization = aorg;
		worker = new WorkerVO();
	}
	
	public ExpeditionVO(int acode, WorkerVO aworker) {
		super();
		code = acode;
		type = WORKER;
		worker = aworker;
		organization = new OrganizationVO();
	}
	
	public String toString() {
		String result = "";
		if (type == ORGANIZATION) {
			if (getOrganization() != null)
				result = getOrganization().getName();
		} else if (type == WORKER) {
			if (getWorker() != null)
				result = getWorker().getName();
		}
		return result;
	}
	
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		
		if (otherObject == null) return false;
		
		if (getClass() != otherObject.getClass()) return false;
		
		ExpeditionVO other = (ExpeditionVO)otherObject;
		
		return (code == other.code);
	}
	
	public int hashCode() {
		return new Integer(code).hashCode();
	}
	
	// To Sort objects by name
	public int compareTo(Object other) {
		return toString().compareTo(((ExpeditionVO)other).toString());
	}

	/**
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param i
	 */
	public void setCode(int i) {
		code = i;
	}

	/**
	 * @return
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param i
	 */
	public void setType(int i) {
		type = i;
	}

	/**
	 * @return
	 */
	public OrganizationVO getOrganization() {
		return organization;
	}

	/**
	 * @return
	 */
	public WorkerVO getWorker() {
		return worker;
	}

	/**
	 * @param organizationVO
	 */
	public void setOrganization(OrganizationVO organizationVO) {
		organization = organizationVO;
	}

	/**
	 * @param workerVO
	 */
	public void setWorker(WorkerVO workerVO) {
		System.out.println("setWorker");
		System.out.println(workerVO.getName());
		worker = workerVO;
	}

}
