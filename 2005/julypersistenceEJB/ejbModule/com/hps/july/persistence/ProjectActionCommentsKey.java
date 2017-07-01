package com.hps.july.persistence;

public class ProjectActionCommentsKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer projectaction_projectaction;
	public java.lang.Integer division_division;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectActionCommentsKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argProjectaction com.hps.july.persistence.ProjectActionKey
 * @param argDivision com.hps.july.persistence.DivisionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectActionCommentsKey(ProjectActionKey argProjectaction, DivisionKey argDivision) {
	privateSetProjectactionKey(argProjectaction);
	privateSetDivisionKey(argDivision);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof ProjectActionCommentsKey) {
		ProjectActionCommentsKey otherKey = (ProjectActionCommentsKey) o;
		return ((this.projectaction_projectaction.equals(otherKey.projectaction_projectaction)
		 && this.division_division.equals(otherKey.division_division)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named ProjectActionComments2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.DivisionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DivisionKey getDivisionKey() {
	com.hps.july.persistence.DivisionKey temp = null;
	temp = new com.hps.july.persistence.DivisionKey();
	boolean division_NULLTEST = true;
	division_NULLTEST &= (division_division == null);
	temp.division = ((division_division == null) ? 0 : division_division.intValue());
	if (division_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ProjectActionComments2projectaction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ProjectActionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectActionKey getProjectactionKey() {
	com.hps.july.persistence.ProjectActionKey temp = null;
	temp = new com.hps.july.persistence.ProjectActionKey();
	boolean projectaction_NULLTEST = true;
	projectaction_NULLTEST &= (projectaction_projectaction == null);
	temp.projectaction = ((projectaction_projectaction == null) ? 0 : projectaction_projectaction.intValue());
	if (projectaction_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (projectaction_projectaction.hashCode()
		 + division_division.hashCode());
}
/**
 * This method was generated for supporting the association named ProjectActionComments2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.DivisionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDivisionKey(com.hps.july.persistence.DivisionKey inKey) {
	boolean division_NULLTEST = (inKey == null);
	if (division_NULLTEST) division_division = null; else division_division = (new Integer(inKey.division));
}
/**
 * This method was generated for supporting the association named ProjectActionComments2projectaction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ProjectActionKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetProjectactionKey(com.hps.july.persistence.ProjectActionKey inKey) {
	boolean projectaction_NULLTEST = (inKey == null);
	if (projectaction_NULLTEST) projectaction_projectaction = null; else projectaction_projectaction = (new Integer(inKey.projectaction));
}
}
