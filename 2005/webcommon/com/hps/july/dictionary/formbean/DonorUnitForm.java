/*
 * Created on 11.12.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import java.math.BigDecimal;

import org.apache.struts.action.ActionErrors;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.RepiterDonorUnitsAccessBean;
import com.hps.july.web.util.StringAndBigDecimalProperty;
import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.web.util.ValidationException;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DonorUnitForm extends ResourceForm {
	private StringAndBigDecimalProperty power;
	private StringAndIntegerProperty workband;
	private StringAndIntegerProperty linkband;
	private StringAndBigDecimalProperty gainfactor;
	private StringAndIntegerProperty voltageid;
	private StringAndBigDecimalProperty usedpower;
	private StringAndIntegerProperty entriescount;
	//
	private StringAndIntegerProperty antgatescount;
	private StringAndBigDecimalProperty signaldelay;
	private StringAndBigDecimalProperty noisefactor;
	
	private Boolean donotcommit=Boolean.FALSE;
	
	public void setDonotcommit(Boolean newDonotcommit){
		donotcommit = newDonotcommit;
	}
	
	public Boolean getDonotcommit(){
		return donotcommit;
	}

	
	public DonorUnitForm(){
		this.power = new StringAndBigDecimalProperty();
		this.workband = new StringAndIntegerProperty();
		this.linkband = new StringAndIntegerProperty();
		this.gainfactor = new StringAndBigDecimalProperty();
		this.voltageid = new StringAndIntegerProperty();
		this.usedpower = new StringAndBigDecimalProperty();
		this.entriescount = new StringAndIntegerProperty();
		//
		this.antgatescount = new StringAndIntegerProperty();
		this.signaldelay = new StringAndBigDecimalProperty();
		this.noisefactor = new StringAndBigDecimalProperty();
		fuse();
	}
	private void fuse(){
		setBoxable(Boolean.FALSE);
		setComplectpart(Boolean.FALSE);
	}
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		RepiterDonorUnitsAccessBean bean = new RepiterDonorUnitsAccessBean(
			getResource(),
			getName(), getModel(), getNotes(),
			getComplect(), getCountpolicy(),
			getBoxable(), getPriceable(), getComplectpart(),
			getActive(), getResourcesubtype()
		);
		return bean;
	}
	
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
		javax.servlet.http.HttpServletRequest request) {
		RepiterDonorUnitsAccessBean bean = new RepiterDonorUnitsAccessBean();
		bean.setInitKey_resource(getResource());
		return bean;
	}

	public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
		//super.fillRecord(bean);
		try {
			RepiterDonorUnitsAccessBean rdr = (RepiterDonorUnitsAccessBean)bean;
			setResourcesubtype(rdr.getSubtype_resourcesubtype().intValue());
			if(rdr.getManufid() != null) {
				setManufid(rdr.getManufid());
				setManufacturername(CDBCResourcesObject.getManufnameByManufid(rdr.getManufid()));
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public int getState() {
		return com.hps.july.dictionary.APPStates.EDIT_DONOR_UNIT;
	}

	public BigDecimal getPower() {
		return power.getBigDecimal();
	}

	public String getPowerFrm() {
		return power.getString();
	}
 
	public Integer getWorkband() {
		return workband.getInteger();
	}

	public String getWorkbandFrm() {
		return workband.getString();
	}

	public Integer getLinkband() {
		return linkband.getInteger();
	}

	public String getLinkbandFrm() {
		return linkband.getString();
	}

	public BigDecimal getGainfactor() {
		return gainfactor.getBigDecimal();
	}

	public String getGainfactorFrm() {
		return gainfactor.getString();
	}

	public Integer getVoltageid() {
		return voltageid.getInteger();
	}

	public String getVoltageidFrm() {
		return voltageid.getString();
	}

	public BigDecimal getUsedpower() {
		return usedpower.getBigDecimal();
	}

	public String getUsedpowerFrm() {
		return usedpower.getString();
	}

	public Integer getEntriescount() {
		return entriescount.getInteger();
	}

	public String getEntriescountFrm() {
		return entriescount.getString();
	}

	public Integer getAntgatescount() {
		return antgatescount.getInteger();
	}

	public String getAntgatescountFrm() {
		return antgatescount.getString();
	}

	public BigDecimal getSignaldelay() {
		return signaldelay.getBigDecimal();
	}

	public String getSignaldelayFrm() {
		return signaldelay.getString();
	}

	public BigDecimal getNoisefactor() {
		return noisefactor.getBigDecimal();
	}

	public String getNoisefactorFrm() {
		return noisefactor.getString();
	}
	
	public CDBCResultSet getVoltageList(){  
		return CDBCResourcesObject.findAllVoltages();
	}
	
	public CDBCResultSet getUsedBands(){
		return CDBCResourcesObject.findAllUsedBands();
	}
	
	public void initRecord(javax.servlet.http.HttpServletRequest request)
	{
		ResourcesCommonListForm frm = (ResourcesCommonListForm)request.getSession().getAttribute("ResourcesCommonListForm");
		setResourcesubtype(frm.getResourcesubtype().intValue());
		System.out.println("in initRecord");
		setResourcesubtype(com.hps.july.util.AppUtils.getNamedValueInt("Dict_SIMPLERES"));
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		try{
			setResource(keyGen.getNextKey("tables.resources"));
		}
		catch (Exception e){
		}
	}
	
	public void setPower(BigDecimal newPower) {
		power.setBigDecimal(newPower);
	}

	public void setPowerFrm(String newPower) {
		power.setString(newPower);
	}
 
	public void setWorkband(Integer newWorkband) {
		workband.setInteger(newWorkband);
	}

	public void setWorkbandFrm(String newWorkband) {
		workband.setString(newWorkband);
	}

	public void setLinkband(Integer newLinkband) {
		linkband.setInteger(newLinkband);
	}

	public void setLinkbandFrm(String newLinkband) {
		linkband.setString(newLinkband);
	}

	public void setGainfactor(BigDecimal newGainfactor) {
		gainfactor.setBigDecimal(newGainfactor);
	}

	public void setGainfactorFrm(String newGainfactor) {
		gainfactor.setString(newGainfactor);
	}

	public void setVoltageid(Integer newVoltageid) {
		voltageid.setInteger(newVoltageid);
	}

	public void setVoltageidFrm(String newVoltageid) {
		voltageid.setString(newVoltageid);
	}

	public void setUsedpower(BigDecimal newUsedpower) {
		usedpower.setBigDecimal(newUsedpower);
	}

	public void setUsedpowerFrm(String newUsedpower) {
		usedpower.setString(newUsedpower);
	}

	public void setEntriescount(Integer newEntriescount) {
		entriescount.setInteger(newEntriescount);
	}

	public void setEntriescountFrm(String newEntriescount) {
		entriescount.setString(newEntriescount);
	}

	public void setAntgatescount(Integer newAntgatescount) {
		antgatescount.setInteger(newAntgatescount);
	}

	public void setAntgatescountFrm(String newAntgatescount) {
		antgatescount.setString(newAntgatescount);
	}

	public void setSignaldelay(BigDecimal newSignaldelay) {
		signaldelay.setBigDecimal(newSignaldelay);
	}

	public void setSignaldelayFrm(String newSignaldelay) {
		signaldelay.setString(newSignaldelay);
	}

	public void setNoisefactor(BigDecimal newNoisefactor) {
		noisefactor.setBigDecimal(newNoisefactor);
	}

	public void setNoisefactorFrm(String newNoisefactor) {
		noisefactor.setString(newNoisefactor);
	}
	
	public void validateValues(ActionErrors errors) throws Exception {
		super.validateValues(errors);
		if (donotcommit==Boolean.TRUE){
			donotcommit=Boolean.FALSE;
			throw new ValidationException();
		}
	}
}