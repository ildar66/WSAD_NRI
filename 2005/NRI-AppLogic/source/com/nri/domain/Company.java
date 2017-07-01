/*
 * Created on 06.08.2007
 *
 * NriObject компаний.
 */
package com.nri.domain;

/**
 * @author IShaffigulin
 *
 * NriObject компаний.
 */
public class Company extends NriObject {
	private Integer company = null; //Идентификатор компаниия
	private String name = null; //Наименование компании
	private String shortName = null; //Сокращенное наименование
	/**
	 * 
	 */
	public Company() {
		super();
	}

	/**
	 * 
	 */
	public Company(Integer aCompany) {
		super();
		setCompany(aCompany);
	}

	/**
	 * @return
	 */
	public Integer getCompany() {
		return company;
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
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param integer
	 */
	public void setCompany(Integer integer) {
		company = integer;
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
	public void setShortName(String string) {
		shortName = string;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof MsUser)) {
			return false;
		}
		Company aCompany = (Company) anObject;
		return aCompany.getCompany().intValue() == getCompany().intValue();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Company: ");
		sb.append(getCompany() + "(" + getName() + ")");
		//sb.append('\n');
		//sb.append(" IsActive: ");
		//sb.append(getIsActive());

		return sb.toString();
	}

}
