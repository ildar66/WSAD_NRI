/*
 * Created on 31.07.2007
 *
 * NriObject ���������.
 */
package com.nri.domain;

/**
 * @author IShaffigulin
 *
 * NriObject ���������.
 */
public class WorkPosition extends NriObject {
	private Integer workPosition = null; //������������� ����������
	private String name = null; //������������ ���������
	private Boolean isActive = null; //������� ���������� ���������

	/**
	 * 
	 */
	public WorkPosition() {
		super();
	}

	/**
	 * 
	 */
	public WorkPosition(Integer aWorkPosition) {
		super();
		setWorkPosition(aWorkPosition);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof WorkPosition)) {
			return false;
		}
		WorkPosition anWorkPosition = (WorkPosition) anObject;
		return anWorkPosition.getWorkPosition().equals(getWorkPosition());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("WorkPosition: ");
		sb.append(getWorkPosition() + "(" + getName() + ")");
		//sb.append('\n');
		//sb.append(" IsActive: ");
		//sb.append(getIsActive());

		return sb.toString();
	}

	/**
	 * @return
	 */
	public Boolean getIsActive() {
		return isActive;
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
	public Integer getWorkPosition() {
		return workPosition;
	}

	/**
	 * @param boolean1
	 */
	public void setIsActive(Boolean boolean1) {
		isActive = boolean1;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param integer
	 */
	public void setWorkPosition(Integer integer) {
		workPosition = integer;
	}

}
