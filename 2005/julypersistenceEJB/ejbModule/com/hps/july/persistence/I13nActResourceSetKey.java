package com.hps.july.persistence;

public class I13nActResourceSetKey implements java.io.Serializable {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer i13nAct_document;
	public java.lang.Integer resource_resource;
/**
 * Default constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public I13nActResourceSetKey() {
	super();
}
/**
 * Initialize a key from the passed values
 * @param argI13nAct com.hps.july.persistence.DocumentKey
 * @param argResource com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public I13nActResourceSetKey(DocumentKey argI13nAct, ResourceKey argResource) {
	privateSetI13nActKey(argI13nAct);
	privateSetResourceKey(argResource);
}
/**
 * equals method
 * @return boolean
 * @param o java.lang.Object
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public boolean equals(java.lang.Object o) {
	if (o instanceof I13nActResourceSetKey) {
		I13nActResourceSetKey otherKey = (I13nActResourceSetKey) o;
		return ((this.i13nAct_document.equals(otherKey.i13nAct_document)
		 && this.resource_resource.equals(otherKey.resource_resource)));
	}
	else
		return false;
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.DocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getI13nActKey() {
	com.hps.july.persistence.DocumentKey temp = null;
	temp = new com.hps.july.persistence.DocumentKey();
	boolean i13nAct_NULLTEST = true;
	i13nAct_NULLTEST &= (i13nAct_document == null);
	temp.document = ((i13nAct_document == null) ? 0 : i13nAct_document.intValue());
	if (i13nAct_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean resource_NULLTEST = true;
	resource_NULLTEST &= (resource_resource == null);
	temp.resource = ((resource_resource == null) ? 0 : resource_resource.intValue());
	if (resource_NULLTEST) temp = null;
	return temp;
}
/**
 * hashCode method
 * @return int
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public int hashCode() {
	return (i13nAct_document.hashCode()
		 + resource_resource.hashCode());
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.DocumentKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetI13nActKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean i13nAct_NULLTEST = (inKey == null);
	if (i13nAct_NULLTEST) i13nAct_document = null; else i13nAct_document = (new Integer(inKey.document));
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @param inKey com.hps.july.persistence.ResourceKey
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
}
