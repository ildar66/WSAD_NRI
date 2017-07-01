/*
 * Created on 24.07.2007
 *
 * NriObject Ролей операторов
 */
package com.nri.domain;

/**
 * @author IShaffigulin
 *
 * NriObject Ролей операторов
 */
public class Role extends NriObject {
	private String role = null; //Идентификатор роли
	private String roleName = null; //Наименование роли
	private String comment = null; //Описание роли
	private Integer sortOrder = null; //групповая Сортировка
	private String taskComment = null; //К каким задачам относится

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * 
	 */
	public Role(String aRole) {
		super();
		setRole(aRole);
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
	public String getRole() {
		return role;
	}

	/**
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @return
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}

	/**
	 * @return
	 */
	public String getTaskComment() {
		return taskComment;
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
	public void setRole(String string) {
		role = string;
	}

	/**
	 * @param string
	 */
	public void setRoleName(String string) {
		roleName = string;
	}

	/**
	 * @param integer
	 */
	public void setSortOrder(Integer integer) {
		sortOrder = integer;
	}

	/**
	 * @param string
	 */
	public void setTaskComment(String string) {
		taskComment = string;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Role: ");
		sb.append(getRole() + "(" + getRoleName() + ")");
		//sb.append('\n');
		//sb.append(" Comment: ");
		//sb.append(getComment());

		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof Role)) {
			return false;
		}
		Role anRole = (Role) anObject;
		return anRole.getRole().equals(getRole());
	}

}
