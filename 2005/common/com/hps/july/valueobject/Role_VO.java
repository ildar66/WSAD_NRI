package com.hps.july.valueobject;

/**
 * "Роль для операторов".
 * Creation date: (03.11.2005 12:00:51)
 * @author: Shafigullin Ildar
 */
public class Role_VO {
	private java.lang.String role = null; //Идентификатор роли
	private java.lang.String rolename = null; //Наименование роли
	private java.lang.String comment = null; //Описание роли
	private java.lang.Integer sortOrder = null; //Сортировка
	private java.lang.String taskComment = null; //К каким задачам относится?
	
	/**
	 * Role_VO constructor comment.
	 */
	public Role_VO(String id, String name) {
		super();
		role = id;
		rolename = name;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.11.2005 12:03:58)
	 * @return java.lang.String
	 */
	public java.lang.String getRole() {
		return role;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.11.2005 12:04:24)
	 * @return java.lang.String
	 */
	public java.lang.String getRolename() {
		return rolename;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.11.2005 12:03:58)
	 * @param newRole java.lang.String
	 */
	public void setRole(java.lang.String newRole) {
		role = newRole;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.11.2005 12:04:24)
	 * @param newRolename java.lang.String
	 */
	public void setRolename(java.lang.String newRolename) {
		rolename = newRolename;
	}
	/**
	 * @return
	 */
	public java.lang.String getComment() {
		return comment;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getSortOrder() {
		return sortOrder;
	}

	/**
	 * @return
	 */
	public java.lang.String getTaskComment() {
		return taskComment;
	}

	/**
	 * @param string
	 */
	public void setComment(java.lang.String string) {
		comment = string;
	}

	/**
	 * @param integer
	 */
	public void setSortOrder(java.lang.Integer integer) {
		sortOrder = integer;
	}

	/**
	 * @param string
	 */
	public void setTaskComment(java.lang.String string) {
		taskComment = string;
	}

}
