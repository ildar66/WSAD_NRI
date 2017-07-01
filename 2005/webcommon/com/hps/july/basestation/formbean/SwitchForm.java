package com.hps.july.basestation.formbean;

import java.util.Enumeration;
import javax.servlet.http.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import org.apache.struts.action.*;
import java.math.*;
import com.hps.july.basestation.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.sitedoc.valueobject.*;

/**
 * Форма редактирования коммутатора
 */
public class SwitchForm
	extends EquipmentPForm
{
	private StringAndInteger e1_qty_total = new StringAndInteger();
	private StringAndInteger e1_nss = new StringAndInteger();
	private StringAndInteger qtyconhlr = new StringAndInteger();
	private String switchType;

	private StringAndInteger number = new StringAndInteger();

	private String mscidFrm;

	private StringAndInteger e1_bss = new StringAndInteger();

	private Resource resource;
	private StringAndInteger resourceId = new StringAndInteger();
	private String resourcename;
    private String resourcemodel;
    private String resourcefullname;

	private StringAndInteger e1_hlr = new StringAndInteger();

    private StringAndInteger ss7nss = new StringAndInteger();

    private StringAndInteger maxvlr = new StringAndInteger();
    private StringAndInteger ss7bss = new StringAndInteger();

    private StringAndInteger qty_tkgroute_nss = new StringAndInteger();

    private StringAndInteger ss7_hlrin = new StringAndInteger();
    private StringAndBigDecimal e1_use_percent = new StringAndBigDecimal();
    private StringAndInteger qtyshell = new StringAndInteger();
    
	private StringAndInteger capacityused = new StringAndInteger();
	private StringAndInteger capacityplan = new StringAndInteger();
    
    
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
    throws Exception
{
	// Delete Switch Additional Info (SwitchDesc)
	try {
		SwitchAddInfoAccessBean sa = new SwitchAddInfoAccessBean();
		SwitchParamsAccessBean sp = new SwitchParamsAccessBean();
		Enumeration ensai = sa.findSwitchAddInfosBySwitch(new StoragePlaceKey(getStorageplace()));
		while(ensai.hasMoreElements()) {
			SwitchAddInfoAccessBean sao = (SwitchAddInfoAccessBean)ensai.nextElement();
			Enumeration en = sp.findByEquipmentAndActdateOrderByParamlevelAsc(new Integer(getStorageplace()),sao.getAct_date());
			while(en.hasMoreElements()) {
				SwitchParamsAccessBean s = (SwitchParamsAccessBean)en.nextElement();
				s.getEJBRef().remove();
			}
			sao.getEJBRef().remove();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.switch.delete_nested_records");
	}
	
	SiteDocObject.deleteDocuments(getStorageplace());
}
public boolean checkUnique(ActionErrors errors)
{
	/*
	try {
		SwitchAccessBean swf = new SwitchAccessBean();
		Enumeration en = swf.findByNN(getNumber(),getName(),getPlanstate(),getPositionId());
		if(en.hasMoreElements()) {
			errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.SwitchForm.unique",getPosTitle()));
		}
		return true;
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return false;
	}
	*/
	return true;
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
	throws java.lang.Exception
{
	super.constructBean(request);
	DebugSupport.printlnTest("SwitchForm constructBean getPositionId()="+getPositionId()); 

	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setStorageplace(keyGen.getNextKey(TablesRef.SWITCHES));
    //DebugSupport.printlnTest("getBand()="+getBand());

    SwitchAccessBean bean = new SwitchAccessBean(
    /*int argIdsect,*/ getStorageplace(),
    /*Integer argDivision,*/ null,
    /*Integer argName,*/ getName(),
    /*String argAddress,*/ "",
    /*Integer argPosition,*/ getPositionId(),
    /*String argType,*/ getSwitchType(),
    /*Integer argNumber)*/ new Integer(getNumber()));
   
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:47:11)
 */
private void constructResource() throws Exception {
	ResourceAccessBean bean =new ResourceAccessBean();
	bean.setInitKey_resource(resourceId.getInt());
	bean.refreshCopyHelper();
	resource=(Resource)bean.getEJBRef();
	
	
	}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
    super.fillRecord(bean);

}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2003 11:44:15)
 * @return int
 */
public int getContrl() throws Exception{

    if (getAction().equals("Add")) {
        return 0;
    } else {

        ControllerAccessBeanTable table = new ControllerAccessBeanTable();
        table.setControllerAccessBean(
            new ControllerAccessBean().findControllerBySwitch(
                new StoragePlaceKey(getStorageplace())));

        return table.numberOfRows();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {
    try {

        SwitchAccessBean bean = new SwitchAccessBean();
        bean.setInitKey_storageplace(getStorageplace());
        bean.refreshCopyHelper();

        return bean;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        return null;

    }

}
public Integer getE1_bss(){
return e1_bss.getInteger();
}
public String getE1_bssFrm(){
return e1_bss.getString();
}
public Integer getE1_hlr(){
return e1_hlr.getInteger();
}
public String getE1_hlrFrm(){
return e1_hlr.getString();
}
public Integer getE1_nss(){
return e1_nss.getInteger();
}
public String getE1_nssFrm(){
return e1_nss.getString();
}
public Integer getE1_qty_total(){
return e1_qty_total.getInteger();
}
public String getE1_qty_totalFrm(){
return e1_qty_total.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:43:29)
 * @return com.hps.july.jdbcpersistence.lib.StringAndBigDecimal
 */
public BigDecimal getE1_use_percent() {
	return e1_use_percent.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:43:29)
 * @return com.hps.july.jdbcpersistence.lib.StringAndBigDecimal
 */
public String getE1_use_percentFrm() {
	return e1_use_percent.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 17:52:10)
 * @return java.lang.String
 */
public String getListAttributeName() {
	return "SwitchListForm";
}
public Integer getMaxvlr(){
return maxvlr.getInteger();
}
public String getMaxvlrFrm(){
return maxvlr.getString();
}
public Integer getMscid() {
	try {
		return new Integer(Integer.parseInt(mscidFrm,16));
	} catch(Exception e) {
		return null;
	}
}
public String getMscidFrm() {
	return mscidFrm;
}
public int getNumber(){
return number.getInt();
}
public String getNumberFrm(){
return number.getString();
}
public Integer getQty_tkgroute_nss(){
return qty_tkgroute_nss.getInteger();
}
public String getQty_tkgroute_nssFrm(){
return qty_tkgroute_nss.getString();
}
public Integer getQtyconhlr(){
return qtyconhlr.getInteger();
}
public String getQtyconhlrFrm(){
return qtyconhlr.getString();
}
public Integer getQtyshell(){
return qtyshell.getInteger();
}
public String getQtyshellFrm(){
return qtyshell.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:36:07)
 * @return com.hps.july.persistence.PositionAccessBean
 */
public Resource getResource() {

    return resource;

}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2003 14:21:32)
 * @return java.lang.String
 */
public java.lang.String getResourcefullname() {
	return resourcefullname;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:42:21)
 * @return java.lang.String
 */
public String getResourceIdFrm() {
	return resourceId.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:09:21)
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:09:21)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getSs7_hlrin() {
	return ss7_hlrin.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getSs7_hlrinFrm() {
	return ss7_hlrin.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getSs7bss() {
	return ss7bss.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getSs7bssFrm() {
	return ss7bss.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getSs7nss() {
	return ss7nss.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getSs7nssFrm() {
	return ss7nss.getString();
}
public int getState() {
return APPStates.SwitchForm;
}
public String getSwitchType(){
return switchType;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
    throws Exception {

    super.initRecord(request);

    e1_qty_total = new StringAndInteger();
    e1_nss = new StringAndInteger();
    qtyconhlr = new StringAndInteger();
    switchType = null;

    number = new StringAndInteger();

    e1_bss = new StringAndInteger();

    Resource resource = null;
    resourceId = new StringAndInteger();
    resourcename = "";
    resourcemodel = "";
    resourcefullname="";

    e1_hlr = new StringAndInteger();

    ss7nss = new StringAndInteger();

    maxvlr = new StringAndInteger();
    ss7bss = new StringAndInteger();

    qty_tkgroute_nss = new StringAndInteger();

    ss7_hlrin = new StringAndInteger();
    e1_use_percent = new StringAndBigDecimal();
    qtyshell = new StringAndInteger();

	Object blist = request.getSession().getAttribute("SwitchListForm");
	if(blist != null && blist instanceof SwitchListForm) {
		SwitchListForm bl = (SwitchListForm)blist;
		Integer[] regs = bl.getRegionsSelector().getRegioncodes();
		if(regs != null && regs.length > 0) {
			getPositionForm().setRegioncode(""+regs[0]);
		}
		Integer[] nzc = bl.getRegionsSelector().getNetzonecodes();
		if(nzc != null && nzc.length > 0) {
			getPositionForm().setNetzonecode(nzc[0]);
		}
	}
}
public void setE1_bss(Integer arg){
e1_bss.setInteger(arg);
}
public void setE1_bssFrm(String arg){
e1_bss.setString(arg);
}
public void setE1_hlr(Integer arg){
e1_hlr.setInteger(arg);
}
public void setE1_hlrFrm(String arg){
e1_hlr.setString(arg);
}
public void setE1_nss(Integer arg){
e1_nss.setInteger(arg);
}
public void setE1_nssFrm(String arg){
e1_nss.setString(arg);
}
public void setE1_qty_total(Integer arg){
e1_qty_total.setInteger(arg);
}
public void setE1_qty_totalFrm(String arg){
e1_qty_total.setString(arg);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:43:29)
 * @param newE1_use_percent com.hps.july.jdbcpersistence.lib.StringAndBigDecimal
 */
public void setE1_use_percent(com.hps.july.jdbcpersistence.lib.StringAndBigDecimal newE1_use_percent) {
	e1_use_percent = newE1_use_percent;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:43:29)
 * @param newE1_use_percent com.hps.july.jdbcpersistence.lib.StringAndBigDecimal
 */
public void setE1_use_percent(BigDecimal newE1_use_percent) {
	e1_use_percent.setBigDecimal(newE1_use_percent);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:43:29)
 * @param newE1_use_percent com.hps.july.jdbcpersistence.lib.StringAndBigDecimal
 */
public void setE1_use_percentFrm(String newE1_use_percent) {
	e1_use_percent.setString(newE1_use_percent);
}
public void setMaxvlr(Integer arg){
maxvlr.setInteger(arg);
}
public void setMaxvlrFrm(String arg){
maxvlr.setString(arg);
}
public void setMscid(Integer newMscid) {
	if(newMscid != null) {
		mscidFrm = Integer.toHexString(newMscid.intValue()).toUpperCase();
	} else {
		mscidFrm = "";
	}
}
public void setMscidFrm(String newMscidFrm) {
	mscidFrm = newMscidFrm;
}
public void setNumber(int arg){
number.setInt(arg);
}
public void setNumberFrm(String arg){
number.setString(arg);
}
public void setQty_tkgroute_nss(Integer arg){
qty_tkgroute_nss.setInteger(arg);
}
public void setQty_tkgroute_nssFrm(String arg){
qty_tkgroute_nss.setString(arg);
}
public void setQtyconhlr(Integer arg){
qtyconhlr.setInteger(arg);
}
public void setQtyconhlrFrm(String arg){
qtyconhlr.setString(arg);
}
public void setQtyshell(Integer arg){
qtyshell.setInteger(arg);
}
public void setQtyshellFrm(String arg){
qtyshell.setString(arg);
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:36:07)
 * @param newPosition com.hps.july.persistence.PositionAccessBean
 */
public void setResource(ResourceAccessBean res) throws Exception {
    try {
        if (res == null) {
            resourceId.setInteger(null);
            resourcename=null;
            resourcemodel=null;
            resourcefullname=null;
            return;
        }

        resourceId.setInt(res.getResource());
        resourcename = res.getName();
        resourcemodel = res.getModel();
        resourcefullname=res.getName()+" "+res.getModel();
        DebugSupport.printlnTest(
            "SwitchForm setResource() res.getResource()=" + res.getResource());
        DebugSupport.printlnTest(
            "SwitchForm setResource() getResourceFrm()=" + getResourceIdFrm());
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2003 14:21:32)
 * @param newResourcefullname java.lang.String
 */
public void setResourcefullname(java.lang.String newResourcefullname) {
	resourcefullname = newResourcefullname;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:43:04)
 */
public void setResourceIdFrm(String res) {
	resourceId.setString(res);
	
	}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:09:21)
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 12:09:21)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @param newSs7bss com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSs7_hlrin(Integer newSs7bss) {
	ss7_hlrin.setInteger(newSs7bss);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @param newSs7bss com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSs7_hlrinFrm(String newSs7bss) {
	ss7_hlrin.setString(newSs7bss);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @param newSs7bss com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSs7bss(Integer newSs7bss) {
	ss7bss.setInteger(newSs7bss);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @param newSs7bss com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSs7bssFrm(String newSs7bss) {
	ss7bss.setString(newSs7bss);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @param newSs7bss com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSs7nss(Integer newSs7bss) {
	ss7nss.setInteger(newSs7bss);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:49:16)
 * @param newSs7bss com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSs7nssFrm(String newSs7bss) {
	ss7nss.setString(newSs7bss);
}
public void setSwitchType(String arg){
switchType=arg;
}
public void validateValues(ActionErrors errors)
	throws Exception
{
	super.validateValues(errors);

	if (!number.isOkAndNotEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.number"));
	}

	if(mscidFrm != null && !"".equals(mscidFrm.trim())) {
		try {
			Integer.parseInt(mscidFrm,16);
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.mscid"));
		}
	}
	
	try {
		if (!resourceId.isEmpty()) {
			constructResource();
		}
	} catch (Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.resource"));
	}

	if (!qtyshell.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.qtyshell"));
    }

	if (!maxvlr.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.maxvlr"));
	}

	if (!qtyconhlr.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.qtyconhlr"));
    }

	if ((switchType == null) || (!"1".equals(switchType) && !"2".equals(switchType))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.switchType"));
	}
	
	if (!qty_tkgroute_nss.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.qty_tkgroute_nss"));
	}

	if (!e1_qty_total.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.e1_qty_total"));
	}

	if (!e1_use_percent.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.e1_use_percent", e1_use_percent.formatMessage()));
	}

	if (!e1_bss.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.e1_bss"));
	}

	if (!ss7bss.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.ss7bss"));
	}

	if (!e1_nss.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.e1_nss"));
	}

	if (!ss7nss.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.ss7nss"));
	}

	if (!e1_hlr.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.e1_hlr"));
	}

	if (!ss7_hlrin.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.ss7_hlrin"));
	}
	
	if (!capacityused.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.capacityused"));
	}
	if (!capacityplan.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.capacityplan"));
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}

	checkEntityUnique(errors);
}
	/**
	 * @return
	 */
	public Integer getCapacityplan() {
		return capacityplan.getInteger();
	}

	/**
	 * @return
	 */
	public Integer getCapacityused() {
		return capacityused.getInteger();
	}

	/**
	 * @return
	 */
	public String getCapacityplanFrm() {
		return capacityplan.getString();
	}

	/**
	 * @return
	 */
	public String getCapacityusedFrm() {
		return capacityused.getString();
	}
	
	/**
	 * @param integer
	 */
	public void setCapacityplan(Integer integer) {
		capacityplan.setInteger(integer);
	}

	/**
	 * @param integer
	 */
	public void setCapacityused(Integer integer) {
		capacityused.setInteger(integer);
	}

	/**
	 * @param integer
	 */
	public void setCapacityplanFrm(String integer) {
		capacityplan.setString(integer);
	}

	/**
	 * @param integer
	 */
	public void setCapacityusedFrm(String integer) {
		capacityused.setString(integer);
	}
}
