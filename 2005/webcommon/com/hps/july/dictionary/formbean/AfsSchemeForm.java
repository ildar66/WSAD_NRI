/*
 * Created on 02.04.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import com.hps.july.persistence2.AfsSchemeAccessBean;
import com.hps.july.web.util.EditForm;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ListIterator;
import java.util.Vector;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.web.util.StringAndSqlDateProperty;
import com.hps.july.web.util.ValidationException;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AfsSchemeForm extends EditForm{
	private Integer schemeid;
	private String numscheme;
	private StringAndIntegerProperty sectcount900 = new StringAndIntegerProperty();
	private StringAndIntegerProperty sectcount1800 = new StringAndIntegerProperty();
	private StringAndIntegerProperty antX2 = new StringAndIntegerProperty();
	private StringAndIntegerProperty antX4 = new StringAndIntegerProperty();
	private StringAndIntegerProperty antV1 = new StringAndIntegerProperty();
	private StringAndIntegerProperty antV2 = new StringAndIntegerProperty();
	private StringAndIntegerProperty dbc1 = new StringAndIntegerProperty();
	private StringAndIntegerProperty dbc2 = new StringAndIntegerProperty();
	private StringAndIntegerProperty df1 = new StringAndIntegerProperty();
	private StringAndIntegerProperty df2 = new StringAndIntegerProperty();
	private StringAndIntegerProperty tma = new StringAndIntegerProperty();
	private StringAndIntegerProperty jo = new StringAndIntegerProperty();
	private StringAndIntegerProperty ji = new StringAndIntegerProperty();
	private StringAndIntegerProperty conn = new StringAndIntegerProperty();
	private String notes;
	
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.DICTIONARY;
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.dictionary.APPStates.EDIT_AFSSCHEME;
	}
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		setSchemeid(new Integer(keyGen.getNextKey("tables.afsscheme")));
		AfsSchemeAccessBean bean = new AfsSchemeAccessBean(getSchemeid());
		return bean;
	}
	
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		AfsSchemeAccessBean bean = new AfsSchemeAccessBean();
		bean.setInitKey_schemeid(  getSchemeid() );
		return bean;
	}

	public Integer getSchemeid(){
		return schemeid;
	}
	public String getNumscheme(){
		return numscheme;
	}
	public Integer getSectcount900(){
		return sectcount900.getInteger();
	}
	public String getSectcount900Frm(){
		return sectcount900.getString();
	}
	public Integer getSectcount1800(){
		return sectcount1800.getInteger();
	}
	public String getSectcount1800Frm(){
		return sectcount1800.getString();
	}
	public Integer getAntX2(){
		return antX2.getInteger();
	}
	public String getAntX2Frm(){
		return antX2.getString();
	}
	public Integer getAntX4(){
		return antX4.getInteger();
	}
	public String getAntX4Frm(){
		return antX4.getString();
	}
	public Integer getAntV1(){
		return antV1.getInteger();
	}
	public String getAntV1Frm(){
		return antV1.getString();
	}
	public Integer getAntV2(){
		return antV2.getInteger();
	}
	public String getAntV2Frm(){
		return antV2.getString();
	}
	public Integer getDbc1(){
		return dbc1.getInteger();
	}
	public String getDbc1Frm(){
		return dbc1.getString();
	}
	public Integer getDbc2(){
		return dbc2.getInteger();
	}
	public String getDbc2Frm(){
		return dbc2.getString();
	}
	public Integer getDf1(){
		return df1.getInteger();
	}
	public String getDf1Frm(){
		return df1.getString();
	}
	public Integer getDf2(){
		return df2.getInteger();
	}
	public String getDf2Frm(){
		return df2.getString();
	}
	public Integer getTma(){
		return tma.getInteger();
	}
	public String getTmaFrm(){
		return tma.getString();
	}
	public Integer getJo(){
		return jo.getInteger();
	}
	public String getJoFrm(){
		return jo.getString();
	}
	public Integer getJi(){
		return ji.getInteger();
	}
	public String getJiFrm(){
		return ji.getString();
	}
	public Integer getConn(){
		return conn.getInteger();
	}
	public String getConnFrm(){
		return conn.getString();
	}
	public String getNotes(){
		return notes;
	}	

	public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean) {
		super.fillRecord(bean);
	}
	
	public void setSchemeid(Integer newSchemeid){
		schemeid = newSchemeid;
	}
	public void setNumscheme(String newNumscheme){
		numscheme = newNumscheme;
	}
	public void setSectcount900(Integer newSectcount900){
		sectcount900.setInteger(newSectcount900);
	}
	public void setSectcount900Frm(String newSectcount900){
		sectcount900.setString(newSectcount900);
	}
	public void setSectcount1800(Integer newSectcount1800){
		sectcount1800.setInteger(newSectcount1800);
	}
	public void setSectcount1800Frm(String newSectcount1800){
		sectcount1800.setString(newSectcount1800);
	}
	public void setAntX2(Integer newAntX2){
		antX2.setInteger(newAntX2);
	}
	public void setAntX2Frm(String newAntX2){
		antX2.setString(newAntX2);
	}
	public void setAntX4(Integer newAntX4){
		antX4.setInteger(newAntX4);
	}
	public void setAntX4Frm(String newAntX4){
		antX4.setString(newAntX4);
	}
	public void setAntV1(Integer newAntV1){
		antV1.setInteger(newAntV1);
	}
	public void setAntV1Frm(String newAntV1){
		antV1.setString(newAntV1);
	}
	public void setAntV2(Integer newAntV2){
		antV2.setInteger(newAntV2);
	}
	public void setAntV2Frm(String newAntV2){
		antV2.setString(newAntV2);
	}
	public void setDbc1(Integer newDbc1){
		dbc1.setInteger(newDbc1);
	}
	public void setDbc1Frm(String newDbc1){
		dbc1.setString(newDbc1);
	}
	public void setDbc2(Integer newDbc2){
		dbc2.setInteger(newDbc2);
	}
	public void setDbc2Frm(String newDbc2){
		dbc2.setString(newDbc2);
	}
	public void setDf1(Integer newDf1){
		df1.setInteger(newDf1);
	}
	public void setDf1Frm(String newDf1){
		df1.setString(newDf1);
	}
	public void setDf2(Integer newDf2){
		df2.setInteger(newDf2);
	}
	public void setDf2Frm(String newDf2){
		df2.setString(newDf2);
	}
	public void setTma(Integer newTma){
		tma.setInteger(newTma);
	}
	public void setTmaFrm(String newTma){
		tma.setString(newTma);
	}
	public void setJo(Integer newJo){
		jo.setInteger(newJo);
	}
	public void setJoFrm(String newJo){
		jo.setString(newJo);
	}
	public void setJi(Integer newJi){
		ji.setInteger(newJi);
	}
	public void setJiFrm(String newJi){
		ji.setString(newJi);
	}
	public void setConn(Integer newConn){
		conn.setInteger(newConn);
	}
	public void setConnFrm(String newConn){
		conn.setString(newConn);
	}
	public void setNotes(String newNotes){
		notes = newNotes;
	}
	
	public void validateValues(ActionErrors errors) throws Exception 
	{
		super.validateValues(errors);
		
		boolean emptyvalues = false;
		
		Field[] params = this.getClass().getDeclaredFields();
		for (int i=0; i<params.length; i++){
			if (params[i].getType().getName().equalsIgnoreCase("com.hps.july.web.util.StringAndIntegerProperty")){
				StringAndIntegerProperty prop = (StringAndIntegerProperty) params[i].get(this);
				if (prop.getString().equalsIgnoreCase("")){
					emptyvalues = true;
					break;
				}
			}
		}

		if (emptyvalues)		
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.afsscheme.emptyparams"));
		
		if (!errors.empty())
			throw new ValidationException();
	}
	
}


