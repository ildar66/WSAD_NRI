package com.hps.july.persistence;

public class ProjectDivColValKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer project_project;
	public java.lang.Integer projectDivColumn_divcolid;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectDivColValKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argProject com.hps.july.persistence.ProjectKey
 * @param argProjectDivColumn com.hps.july.persistence.ProjectDivColumnsKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public ProjectDivColValKey(ProjectKey argProject, ProjectDivColumnsKey argProjectDivColumn) {
	privateSetProjectKey(argProject);
	privateSetProjectDivColumnKey(argProjectDivColumn);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof ProjectDivColValKey) {
		ProjectDivColValKey otherKey = (ProjectDivColValKey) o;
		return ((this.project_project.equals(otherKey.project_project)
		 && this.projectDivColumn_divcolid.equals(otherKey.projectDivColumn_divcolid)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectDivColVal.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ProjectDivColumnsKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectDivColumnsKey getProjectDivColumnKey() {
	com.hps.july.persistence.ProjectDivColumnsKey temp = null;
	temp = new com.hps.july.persistence.ProjectDivColumnsKey();
	boolean projectDivColumn_NULLTEST = true;
	projectDivColumn_NULLTEST &= (projectDivColumn_divcolid == null);
	temp.divcolid = ((projectDivColumn_divcolid == null) ? 0 : projectDivColumn_divcolid.intValue());
	if (projectDivColumn_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named ProjectDivColVal2Project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ProjectKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectKey getProjectKey() {
	com.hps.july.persistence.ProjectKey temp = null;
	temp = new com.hps.july.persistence.ProjectKey();
	boolean project_NULLTEST = true;
	project_NULLTEST &= (project_project == null);
	temp.project = ((project_project == null) ? 0 : project_project.intValue());
	if (project_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (project_project.hashCode()
		 + projectDivColumn_divcolid.hashCode());
}
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectDivColVal.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ProjectDivColumnsKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetProjectDivColumnKey(com.hps.july.persistence.ProjectDivColumnsKey inKey) {
	boolean projectDivColumn_NULLTEST = (inKey == null);
	if (projectDivColumn_NULLTEST) projectDivColumn_divcolid = null; else projectDivColumn_divcolid = (new Integer(inKey.divcolid));
}
/**
 * This method was generated for supporting the association named ProjectDivColVal2Project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ProjectKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetProjectKey(com.hps.july.persistence.ProjectKey inKey) {
	boolean project_NULLTEST = (inKey == null);
	if (project_NULLTEST) project_project = null; else project_project = (new Integer(inKey.project));
}
}
