package com.hps.july.basestation.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (27.07.2005 21:50:58)
 * @author: Shafigullin Ildar
 */
public class ReglamentWorks_TO {
	private ReglamentWorks_VO vo;
	private java.lang.String createdName;
	private java.lang.String modifiedName;
	private java.lang.String manName;
/**
 * ReglamentWorks_TO constructor comment.
 */
public ReglamentWorks_TO(ReglamentWorks_VO vo) {
	super();
	setVo(vo);
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:57:30)
 * @return java.lang.String
 */
public java.lang.String getCreatedName() {
	return createdName;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 19:21:36)
 * @return java.lang.String
 */
public java.lang.String getManName() {
	return manName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:58:09)
 * @return java.lang.String
 */
public java.lang.String getModifiedName() {
	return modifiedName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:51:43)
 * @return com.hps.july.basestation.valueobject.ReglamentWorks_VO
 */
public ReglamentWorks_VO getVo() {
	return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:57:30)
 * @param newCreatedName java.lang.String
 */
public void setCreatedName(java.lang.String newCreatedName) {
	createdName = newCreatedName;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 19:21:36)
 * @param newManName java.lang.String
 */
public void setManName(java.lang.String newManName) {
	manName = newManName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:58:09)
 * @param newModifiedName java.lang.String
 */
public void setModifiedName(java.lang.String newModifiedName) {
	modifiedName = newModifiedName;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 21:51:43)
 * @param newVo com.hps.july.basestation.valueobject.ReglamentWorks_VO
 */
public void setVo(ReglamentWorks_VO newVo) {
	vo = newVo;
}
}
