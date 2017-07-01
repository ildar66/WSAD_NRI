package com.hps.july.arenda.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (08.11.2005 17:21:53)
 * @author: Shafigullin Ildar
 */
public class LeaseRegistryBuchDocs_TO {
    private java.lang.String ownerName;
    private LeaseRegistryBuchDocs_VO vo;
    private String createdByName;
    private String modifiedByName;
/**
 * LeaseRegistryBuchDocs_TO constructor comment.
 * @param id java.lang.Integer
 * @param loanContractID java.lang.Integer
 */
public LeaseRegistryBuchDocs_TO(LeaseRegistryBuchDocs_VO vo) {
    super();
    this.vo = vo;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 17:23:17)
 * @return java.lang.String
 */
public java.lang.String getOwnerName() {
	return ownerName;
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2005 17:09:16)
 * @return com.hps.july.arenda.valueobject.LeaseRegistryBuchDocs_VO
 */
public LeaseRegistryBuchDocs_VO getVo() {
	return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (08.11.2005 17:23:17)
 * @param newOurManName java.lang.String
 */
public void setOwnerName(java.lang.String newOurManName) {
	ownerName = newOurManName;
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2005 17:09:16)
 * @param newVo com.hps.july.arenda.valueobject.LeaseRegistryBuchDocs_VO
 */
public void setVo(LeaseRegistryBuchDocs_VO newVo) {
	vo = newVo;
}
	/**
	 * @return
	 */
	public String getCreatedByName() {
		return createdByName;
	}

	/**
	 * @return
	 */
	public String getModifiedByName() {
		return modifiedByName;
	}

	/**
	 * @param string
	 */
	public void setCreatedByName(String string) {
		createdByName = string;
	}

	/**
	 * @param string
	 */
	public void setModifiedByName(String string) {
		modifiedByName = string;
	}

}
