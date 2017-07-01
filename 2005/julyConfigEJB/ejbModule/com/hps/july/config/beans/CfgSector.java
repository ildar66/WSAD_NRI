package com.hps.july.config.beans;
/**
 * Remote interface for Enterprise Bean: CfgSector
 */
public interface CfgSector extends javax.ejb.EJBObject, com.ibm.ivj.ejb.runtime.CopyHelper {

	/**
	 * Get accessor for persistent attribute: equipment
	 */
	public int getEquipment() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: equipment
	 */
	public void setEquipment(int newEquipment) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: name_sect
	 */
	public java.lang.String getName_sect() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: name_sect
	 */
	public void setName_sect(java.lang.String newName_sect)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: band
	 */
	public java.lang.Short getBand() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: band
	 */
	public void setBand(java.lang.Short newBand)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: num_sect
	 */
	public java.lang.String getNum_sect() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: num_sect
	 */
	public void setNum_sect(java.lang.String newNum_sect)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: azimut
	 */
	public java.math.BigDecimal getAzimut() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: azimut
	 */
	public void setAzimut(java.math.BigDecimal newAzimut)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: power
	 */
	public java.math.BigDecimal getPower() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: power
	 */
	public void setPower(java.math.BigDecimal newPower)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: bts_number
	 */
	public java.lang.String getBts_number() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: bts_number
	 */
	public void setBts_number(java.lang.String newBts_number)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: con_abis
	 */
	public java.lang.String getCon_abis() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: con_abis
	 */
	public void setCon_abis(java.lang.String newCon_abis)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: port_abis
	 */
	public java.lang.Integer getPort_abis() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: port_abis
	 */
	public void setPort_abis(java.lang.Integer newPort_abis)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: num_po
	 */
	public java.lang.String getNum_po() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: num_po
	 */
	public void setNum_po(java.lang.String newNum_po)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: ddk
	 */
	public java.lang.Boolean getDdk() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: ddk
	 */
	public void setDdk(java.lang.Boolean newDdk)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: trx_num
	 */
	public java.lang.Integer getTrx_num() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: trx_num
	 */
	public void setTrx_num(java.lang.Integer newTrx_num)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: tx_pwr
	 */
	public java.math.BigDecimal getTx_pwr() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: tx_pwr
	 */
	public void setTx_pwr(java.math.BigDecimal newTx_pwr)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: trx_num2
	 */
	public java.lang.Integer getTrx_num2() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: trx_num2
	 */
	public void setTrx_num2(java.lang.Integer newTrx_num2)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: tx_pwr2
	 */
	public java.math.BigDecimal getTx_pwr2() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: tx_pwr2
	 */
	public void setTx_pwr2(java.math.BigDecimal newTx_pwr2)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: tx_set_pwr
	 */
	public java.math.BigDecimal getTx_set_pwr()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: tx_set_pwr
	 */
	public void setTx_set_pwr(java.math.BigDecimal newTx_set_pwr)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: trx_ovr_num
	 */
	public java.lang.Integer getTrx_ovr_num() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: trx_ovr_num
	 */
	public void setTrx_ovr_num(java.lang.Integer newTrx_ovr_num)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: tx_ovr_set_pwr
	 */
	public java.math.BigDecimal getTx_ovr_set_pwr()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: tx_ovr_set_pwr
	 */
	public void setTx_ovr_set_pwr(java.math.BigDecimal newTx_ovr_set_pwr)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: has_flt
	 */
	public java.lang.Boolean getHas_flt() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: has_flt
	 */
	public void setHas_flt(java.lang.Boolean newHas_flt)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: has_lna
	 */
	public java.lang.Boolean getHas_lna() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: has_lna
	 */
	public void setHas_lna(java.lang.Boolean newHas_lna)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: has_buster
	 */
	public java.lang.Boolean getHas_buster() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: has_buster
	 */
	public void setHas_buster(java.lang.Boolean newHas_buster)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: conf
	 */
	public java.lang.String getConf() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: conf
	 */
	public void setConf(java.lang.String newConf)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: is_hr
	 */
	public java.lang.Boolean getIs_hr() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: is_hr
	 */
	public void setIs_hr(java.lang.Boolean newIs_hr)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: cap_gprs
	 */
	public java.lang.Boolean getCap_gprs() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: cap_gprs
	 */
	public void setCap_gprs(java.lang.Boolean newCap_gprs)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: operator
	 */
	public java.lang.Integer getOperator() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: operator
	 */
	public void setOperator(java.lang.Integer newOperator)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: byhand
	 */
	public java.lang.Boolean getByhand() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: byhand
	 */
	public void setByhand(java.lang.Boolean newByhand)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: lac
	 */
	public java.lang.Integer getLac() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: lac
	 */
	public void setLac(java.lang.Integer newLac)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: rac
	 */
	public java.lang.Integer getRac() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: rac
	 */
	public void setRac(java.lang.Integer newRac)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: cellname
	 */
	public java.lang.Integer getCellname() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: cellname
	 */
	public void setCellname(java.lang.Integer newCellname)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: ncc
	 */
	public java.lang.Short getNcc() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: ncc
	 */
	public void setNcc(java.lang.Short newNcc) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: bcc
	 */
	public java.lang.Short getBcc() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: bcc
	 */
	public void setBcc(java.lang.Short newBcc) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: standid
	 */
	public java.lang.Integer getStandid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: standid
	 */
	public void setStandid(java.lang.Integer newStandid)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: cellinfo
	 */
	public java.lang.String getCellinfo() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: cellinfo
	 */
	public void setCellinfo(java.lang.String newCellinfo)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: datasource
	 */
	public int getDatasource() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: datasource
	 */
	public void setDatasource(int newDatasource)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: ObjectStatus
	 */
	public java.lang.String getObjectStatus() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: ObjectStatus
	 */
	public void setObjectStatus(java.lang.String newObjectStatus)
		throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getId_sect() throws java.rmi.RemoteException;
	/**
	 * @return
	 */
	public int getSavconfigid() throws java.rmi.RemoteException;
}
