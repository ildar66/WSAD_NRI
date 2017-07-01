package com.hps.july.arenda.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (16.06.2005 10:44:21)
 * @author: Shafigullin Ildar
 */
public class LeaseMutualReglament_TO {
    private LeaseMutualReglament_VO o;
    private java.lang.String contractList;
    private java.lang.String resourceList;
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:44:57)
 * @param o com.hps.july.arenda.valueobject.LeaseMutualReglament_VO
 */
public LeaseMutualReglament_TO(LeaseMutualReglament_VO o) {
    setO(o);
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 17:05:28)
 * @return java.lang.String
 */
public java.lang.String getContractList() {
	return contractList;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:46:50)
 * @return com.hps.july.arenda.valueobject.LeaseMutualReglament_VO
 */
public LeaseMutualReglament_VO getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 17:05:28)
 * @return java.lang.String
 */
public java.lang.String getResourceList() {
	return resourceList;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 17:05:28)
 * @param newContractList java.lang.String
 */
public void setContractList(java.lang.String newContractList) {
	contractList = newContractList;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 10:46:50)
 * @param newO com.hps.july.arenda.valueobject.LeaseMutualReglament_VO
 */
public void setO(LeaseMutualReglament_VO newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 17:05:28)
 * @param newResourceList java.lang.String
 */
public void setResourceList(java.lang.String newResourceList) {
	resourceList = newResourceList;
}
}
