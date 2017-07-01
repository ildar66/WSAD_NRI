package com.hps.july.persistence;

public class Operators2RolesKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer operator_operator;
	public java.lang.String role_role;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Operators2RolesKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argOperator com.hps.july.persistence.OperatorKey
 * @param argRole com.hps.july.persistence.RoleKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Operators2RolesKey(OperatorKey argOperator, RoleKey argRole) {
	privateSetOperatorKey(argOperator);
	privateSetRoleKey(argRole);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof Operators2RolesKey) {
		Operators2RolesKey otherKey = (Operators2RolesKey) o;
		return ((this.operator_operator.equals(otherKey.operator_operator)
		 && this.role_role.equals(otherKey.role_role)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.OperatorKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OperatorKey getOperatorKey() {
	com.hps.july.persistence.OperatorKey temp = null;
	temp = new com.hps.july.persistence.OperatorKey();
	boolean operator_NULLTEST = true;
	operator_NULLTEST &= (operator_operator == null);
	temp.operator = ((operator_operator == null) ? 0 : operator_operator.intValue());
	if (operator_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named operators2roles2role.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.RoleKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.RoleKey getRoleKey() {
	com.hps.july.persistence.RoleKey temp = null;
	temp = new com.hps.july.persistence.RoleKey();
	boolean role_NULLTEST = true;
	role_NULLTEST &= (role_role == null);
	temp.role = role_role;
	if (role_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (operator_operator.hashCode()
		 + role_role.hashCode());
}
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.OperatorKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOperatorKey(com.hps.july.persistence.OperatorKey inKey) {
	boolean operator_NULLTEST = (inKey == null);
	if (operator_NULLTEST) operator_operator = null; else operator_operator = (new Integer(inKey.operator));
}
/**
 * This method was generated for supporting the association named operators2roles2role.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.RoleKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetRoleKey(com.hps.july.persistence.RoleKey inKey) {
	boolean role_NULLTEST = (inKey == null);
	if (role_NULLTEST) role_role = null; else role_role = inKey.role;
}
}
