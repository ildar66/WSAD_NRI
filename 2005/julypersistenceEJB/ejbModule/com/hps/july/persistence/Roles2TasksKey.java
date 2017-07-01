package com.hps.july.persistence;

public class Roles2TasksKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.String role_role;
	public java.lang.Integer task_task;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Roles2TasksKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argRole com.hps.july.persistence.RoleKey
 * @param argTask com.hps.july.persistence.TaskKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Roles2TasksKey(RoleKey argRole, TaskKey argTask) {
	privateSetRoleKey(argRole);
	privateSetTaskKey(argTask);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof Roles2TasksKey) {
		Roles2TasksKey otherKey = (Roles2TasksKey) o;
		return ((this.role_role.equals(otherKey.role_role)
		 && this.task_task.equals(otherKey.task_task)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named role2roles2tasks.  
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
 * This method was generated for supporting the association named task2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.TaskKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.TaskKey getTaskKey() {
	com.hps.july.persistence.TaskKey temp = null;
	temp = new com.hps.july.persistence.TaskKey();
	boolean task_NULLTEST = true;
	task_NULLTEST &= (task_task == null);
	temp.task = ((task_task == null) ? 0 : task_task.intValue());
	if (task_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (role_role.hashCode()
		 + task_task.hashCode());
}
/**
 * This method was generated for supporting the association named role2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.RoleKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetRoleKey(com.hps.july.persistence.RoleKey inKey) {
	boolean role_NULLTEST = (inKey == null);
	if (role_NULLTEST) role_role = null; else role_role = inKey.role;
}
/**
 * This method was generated for supporting the association named task2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.TaskKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetTaskKey(com.hps.july.persistence.TaskKey inKey) {
	boolean task_NULLTEST = (inKey == null);
	if (task_NULLTEST) task_task = null; else task_task = (new Integer(inKey.task));
}
}
