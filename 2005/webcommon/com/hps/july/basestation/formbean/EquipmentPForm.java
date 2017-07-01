package com.hps.july.basestation.formbean;

import javax.servlet.http.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import org.apache.struts.action.*;
import java.math.*;
import com.hps.july.constants.*;

/**
 * Форма параметров позиции
 * Используется как включение в формах редактирования оборудования
 */
public abstract class EquipmentPForm extends EditForm {
	public static final String POSITION_ADD = "positionAdd";
    public static final String POSITION_LOOKUP = "positionLookup";
    private String radioPosition = POSITION_LOOKUP;

    private PositionEForm positionForm=new PositionEForm();
    private int storageplace;
    private Position position;
    private StringAndInteger positionId=new StringAndInteger();

    private StringAndSqlDateProperty datepr=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty datetest=new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateassemb=new StringAndSqlDateProperty();
	private StringAndBigDecimal pwrval=new StringAndBigDecimal(4,2);
	private String pwrrescat;
	private String pwrcat;
	private Boolean pwrreserve=Boolean.FALSE;
	private String equipmentState;
	private String equipcomment;
	private String name;

	private int state;

	private boolean onesave;
public void checkEntityUnique(ActionErrors errors)
	throws ValidationException
{
	if("Add".equals(getAction())) {
		if(!isOnesave()) {
			setOnesave(checkUnique(errors));
			if (!errors.empty()) {
				throw new ValidationException();
			}
		}
	}
}
public boolean checkUnique(ActionErrors errors)
{
	return false;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {
    DebugSupport.printlnTest("EquipmentPForm isAddPosition=" + isAddPosition());

    if (isAddPosition()) {
        PositionAccessBean pos =
            (PositionAccessBean) positionForm.constructBean(request);
        positionId.setInt(pos.getStorageplace());
        position = (Position)pos.getEJBRef();
        return pos;
    }
    
    //constructPosition();
    //DebugSupport.printlnTest("EquipmentPForm posId=" + getPositionId());
    //return pos;

    return null;
}
private void constructPosition() throws Exception {
	PositionAccessBean bean = new PositionAccessBean();
	bean.setInitKey_storageplace(positionId.getInt());
	bean.refreshCopyHelper();
	position=(Position)bean.getEJBRef();
}
public String editable(String name, HttpServletRequest request) {
	int rootApp = Applications.BASESTATION;
	try {
		rootApp = Integer.parseInt( (String)request.getSession().getAttribute( ParamsParser.ROOTAPP_PARAM_NAME ) );
	} catch (Exception e) {
		System.out.println("EXCEPTION ON GET ROOTAPP:"+e.getClass().getName());
	}
    if (getAction().equals("View") || getAction().equals("Edit") || rootApp == Applications.SITEINFO) {
        if (name.equals("positionFields")) {
            DebugSupport.printlnTest("editable name=" + name + " appHome=" + rootApp + " false");
            return "false";
        }
    }
    DebugSupport.printlnTest("editable name=" + name + " appHome=" + rootApp + " true");
    return "true";
}
public void fillRecord(AbstractEntityAccessBean bean) {
	setOnesave(false);
    try {
        constructPosition();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
}
public int getApplication() {
return Applications.BASESTATION;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request){
	return null;
}
public java.sql.Date getDateassemb(){
return dateassemb.getSqlDate();
}
public String getDateassembFrm(){
return dateassemb.getString();
}
public java.sql.Date getDatepr(){
return datepr.getSqlDate();
}
public String getDateprFrm(){
return datepr.getString();
}
public java.sql.Date getDatetest(){
return datetest.getSqlDate();
}
public String getDatetestFrm(){
return datetest.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:08:36)
 * @return java.lang.String
 */
public java.lang.String getEquipcomment() {
	return equipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:08:36)
 * @return java.lang.String
 */
public java.lang.String getEquipmentState() {
	return equipmentState;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 17:46:33)
 * @return java.lang.String
 */
public abstract String getListAttributeName();
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:18:46)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
public Position getPosition() {
    return position;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 17:35:31)
 * @return com.hps.july.basestation.formbean.PositionEForm
 */
public PositionEForm getPositionForm() {
	return positionForm;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:42:21)
 * @return java.lang.String
 */
public Integer getPositionId() {
	return positionId.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:42:21)
 * @return java.lang.String
 */
public String getPositionIdFrm() {
	return positionId.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 20:27:43)
 * @return java.lang.String
 */
public java.lang.String getPwrcat() {
	return pwrcat;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 20:28:00)
 * @return java.lang.String
 */
public java.lang.String getPwrrescat() {
	return pwrrescat;
}
public Boolean getPwrreserve(){
return pwrreserve;
}
public BigDecimal getPwrval(){
return pwrval.getBigDecimal();
}
public String getPwrvalFrm(){
return pwrval.getString();
}
public StringAndBigDecimal getPwrvalProp(){
return pwrval;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 16:27:51)
 * @return java.lang.String
 */
public java.lang.String getRadioPosition() {
	return radioPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 13:04:15)
 * @return int
 */
public int getState() {
	return state;
}
public int getStorageplace(){
return storageplace;
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
	setOnesave(false);
	EquipmentListForm listForm =
		(EquipmentListForm) request.getAttribute(getListAttributeName());
    getPositionForm().initRecord(listForm);

	radioPosition = POSITION_LOOKUP;

    //positionForm = new PositionEForm();

    //for siteinfo
    if (getAction().equals("Add")
        && !(request.getParameter("positionIdFrm") == null)) {
        try {
            DebugSupport.printlnTest(
                "!!!!!EquipmentPForm initRecord positionId.getInt()=" + positionId.getInt());

            PositionAccessBean bean = new PositionAccessBean();
            bean.setInitKey_storageplace(positionId.getInt());
            bean.refreshCopyHelper();

            positionForm.fillRecord(bean);
        } catch (Exception e) {
            DebugSupport.printlnError(e);
            throw e;
        }

    } else {
        positionId = new StringAndInteger();
    }

    datepr = new StringAndSqlDateProperty();
    datetest = new StringAndSqlDateProperty();
    dateassemb = new StringAndSqlDateProperty();
    pwrval = new StringAndBigDecimal(4, 2);
    pwrrescat = null;
    pwrcat = null;
    pwrreserve = Boolean.FALSE;
    equipmentState = null;
    equipcomment = null;
    name = null;
    

}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 16:29:21)
 * @return boolean
 */
public boolean isAddPosition() {
	return getRadioPosition().equals(POSITION_ADD);
}
/**
 * Insert the method's description here.
 * Creation date: (14.04.2003 22:31:31)
 * @return boolean
 * @param id java.lang.String
 */
public boolean isEditable(String id,HttpServletRequest request) {
	return editable(id,request).equals("true");
}
public boolean isOnesave() {
	return onesave;
}
public void setDateassemb(java.sql.Date arg){
dateassemb.setSqlDate(arg);
}
public void setDateassembFrm(String arg){
dateassemb.setString(arg);
}
public void setDatepr(java.sql.Date arg){
datepr.setSqlDate(arg);
}
public void setDateprFrm(String arg){
datepr.setString(arg);
}
public void setDatetest(java.sql.Date arg){
datetest.setSqlDate(arg);
}
public void setDatetestFrm(String arg){
datetest.setString(arg);
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:08:36)
 * @param newEquipcomment java.lang.String
 */
public void setEquipcomment(java.lang.String newEquipcomment) {
	equipcomment = newEquipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:08:36)
 * @param newEquipmentState java.lang.String
 */
public void setEquipmentState(java.lang.String newEquipmentState) {
	equipmentState = newEquipmentState;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 17:18:46)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
protected void setOnesave(boolean val) {
	onesave = val;
}
public void setPosition(PositionAccessBean newPosition)
	throws Exception
{
    try {
        positionId.setInt(newPosition.getStorageplace());
        positionForm.fillRecord(newPosition);
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 17:35:31)
 * @param newPositionForm com.hps.july.basestation.formbean.PositionEForm
 */
public void setPositionForm(PositionEForm newPositionForm) {
	positionForm = newPositionForm;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2003 20:43:04)
 */
public void setPositionIdFrm(String pos){
    positionId.setString(pos);
    

}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 20:27:43)
 * @param newPwrcat java.lang.String
 */
public void setPwrcat(java.lang.String newPwrcat) {
	pwrcat = newPwrcat;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2003 20:28:00)
 * @param newPwrrescat java.lang.String
 */
public void setPwrrescat(java.lang.String newPwrrescat) {
	pwrrescat = newPwrrescat;
}
public void setPwrreserve(Boolean arg){
pwrreserve=arg;
}
public void setPwrval(BigDecimal arg){
pwrval.setBigDecimal(arg);
}
public void setPwrvalFrm(String arg){
pwrval.setString(arg);
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 16:27:51)
 * @param newRadioPosition java.lang.String
 */
public void setRadioPosition(java.lang.String newRadioPosition) {
	radioPosition = newRadioPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 13:04:15)
 * @param newState int
 */
public void setState(int newState) {
	state = newState;
}
public void setStorageplace(int arg){
storageplace=arg;
}
public void validateValues(ActionErrors errors) throws Exception {
    if (!isAddPosition()) {
        try {
			constructPosition();
        } catch (Exception e) {
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.position"));
        }
    } else {
		positionForm.validateValues(errors);
    }

    if (getName() == null || getName().trim().length() == 0) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.name"));
    }

    if (!pwrval.isOk()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("SwitchForm.error.pwrval", pwrval.formatMessage()));
    }
}
}
