package com.hps.july.basestation.formbean;

import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.servlet.http.*;
import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.hps.july.basestation.valueobject.Validator;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма редактирования сложных параметров в эксплуатационных характеристиках контроллера
 */
public class ControllerDescParamsForm extends ParamsEditForm {
	private int paramid;
	private int equipment;
	private StringAndSqlDateProperty date = new StringAndSqlDateProperty();
	private StringAndBigDecimal[] paramLevel = new StringAndBigDecimal[10];
	private StringAndBigDecimal[] paramValue = new StringAndBigDecimal[10];
public ControllerDescParamsForm() {
	for (int i = 0; i < 10; i++) {
		paramLevel[i] = new StringAndBigDecimal(10,2);
		paramValue[i] = new StringAndBigDecimal(10,2);
	}
}
/**
 * doSave method comment.
 */
public void doSave(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.apache.struts.action.ActionErrors errors) throws Exception {
	// validate values
	for (int i = 0; i < 10; i++) {
		if (!paramLevel[i].isEmpty()) {
			if (!paramLevel[i].isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cntrdparams.level.invalid", new Integer(i + 1)));
			}
			if (paramValue[i].isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cntrdparams.value.empty", new Integer(i + 1)));
			} else if (!paramValue[i].isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cntrdparams.value.invalid", new Integer(i + 1)));
			}
		} else {
			if (!paramValue[i].isEmpty()) {
				if (!paramValue[i].isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cntrdparams.value.invalid", new Integer(i + 1)));
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cntrdparams.level.empty", new Integer(i + 1)));
				}
			} 
		}
		
		// check duplicates of levels
		for (int j = i; j < 10; j++) {
			if (i != j && !paramLevel[i].isEmpty() && paramLevel[i].getString().equals(paramLevel[j].getString())) {
				errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.cntrdparams.duplicate", new Integer(i + 1)));
			}
		}
	}
	
	if (!errors.empty()) throw new com.hps.july.web.util.ValidationException();
	
	try {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		
		Enumeration e = new ContrParamsAccessBean().findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(
			new Integer(equipment), date.getSqlDate(), new Integer(paramid));
		ContrParamsAccessBean cpBean;
		while (e.hasMoreElements()) {
			cpBean = (ContrParamsAccessBean) e.nextElement();
			cpBean.getEJBRef().remove();
		}
		for (int i = 0; i < 10; i++) {
			if (paramLevel[i].getBigDecimal() != null) {
				int key = keyGen.getNextKey("tables.contrparams");
				System.out.println("Create PR:" + key+ ", " + equipment + ", " + date.getSqlDate() + ", " +
					paramLevel[i].getBigDecimal() + ", " + paramValue[i].getBigDecimal() + ", " + paramid + ".");
				cpBean = new ContrParamsAccessBean(key, equipment, date.getSqlDate(),
					paramLevel[i].getBigDecimal(), paramValue[i].getBigDecimal(), paramid);
				cpBean.commitCopyHelper();
				
			}
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.cntrdparams.saveerror", e.getClass().getName()));
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
public StringAndSqlDateProperty getDate() {
	return date;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 17:39:49)
 * @return int
 */
public int getEquipment() {
	return equipment;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 17:39:49)
 * @return int
 */
public int getParamid() {
	return paramid;
}
public StringAndBigDecimalProperty getParamLevel(int index) {
	return paramLevel[index];
}
public StringAndBigDecimalProperty getParamValue(int index) {
	return paramValue[index];
}
public int getState() {
	return com.hps.july.basestation.APPStates.CONTROLLER_PARAMS;
}
public void initData(HttpServletRequest request) throws Exception {
	ControllerDescForm form = (ControllerDescForm) request.getSession().getAttribute("ControllerDescForm");
	
	setEquipment(form.getControllercode());
	date.setSqlDate(form.getAct_date());
	
	int i = 0;
	Enumeration e = new ContrParamsAccessBean().findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(
		new Integer(equipment), date.getSqlDate(), new Integer(paramid));
	while (e.hasMoreElements()) {
		ContrParamsAccessBean cpBean = (ContrParamsAccessBean) e.nextElement();
		paramLevel[i].setBigDecimal(cpBean.getParam_level());
		paramValue[i].setBigDecimal(cpBean.getParam_value());
		if (++i > 10) break;
	}
	
	super.initData(request);
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 17:39:49)
 * @param newEquipment int
 */
public void setEquipment(int newEquipment) {
	equipment = newEquipment;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2003 17:39:49)
 * @param newParamid int
 */
public void setParamid(int newParamid) {
	paramid = newParamid;
}
}
