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
 * Форма редактирования сложных параметров эксплуатационных характеристик коммутатора
 */
public class SwitchDescParamsForm
	extends ParamsEditForm
{
	private int paramid;
	private int equipment;
	private StringAndSqlDateProperty date;
	private StringAndBigDecimal[] paramLevel;
	private StringAndBigDecimal[] paramValue;
public SwitchDescParamsForm()
{
	int i;
	
	date = new StringAndSqlDateProperty();
	paramLevel = new StringAndBigDecimal[10];
	paramValue = new StringAndBigDecimal[10];
	for(i = 0; i < 10; i++) {
		paramLevel[i] = new StringAndBigDecimal(10,2);
		paramValue[i] = new StringAndBigDecimal(10,2);
	}
}
public void doSave(HttpServletRequest request, HttpServletResponse response, ActionErrors errors)
	throws Exception
{
	// validate values
	for(int i = 0; i < 10; i++) {
		if(!paramLevel[i].isEmpty()) {
			if(!paramLevel[i].isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.swdparams.level.invalid",new Integer(i+1)));
			}
			if(paramValue[i].isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.swdparams.value.empty",new Integer(i+1)));
			} else if(!paramValue[i].isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.swdparams.value.invalid",new Integer(i+1)));
			}
		} else {
			if(!paramValue[i].isEmpty()) {
				if(!paramValue[i].isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.swdparams.value.invalid",new Integer(i+1)));
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.swdparams.level.empty",new Integer(i+1)));
				}
			} 
		}
		// check duplicates of levels
		for(int j = i; j < 10; j++) {
			if(i != j && !paramLevel[i].isEmpty() && paramLevel[i].getString().equals(paramLevel[j].getString())) {
				errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.swdparams.duplicate",new Integer(i+1)));
			}
		}
	}
	
	if(!errors.empty()) {
		throw new com.hps.july.web.util.ValidationException();
	}
	
	try {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();

		SwitchParamsAccessBean bf = new SwitchParamsAccessBean();
		Enumeration en = bf.findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(
			new Integer(equipment),date.getSqlDate(),new Integer(paramid)
		);
		SwitchParamsAccessBean b = null;
		while(en.hasMoreElements()) {
			b = (SwitchParamsAccessBean)en.nextElement();
			b.getEJBRef().remove();
		}
		for(int i = 0; i < 10; i++) {
			if(paramLevel[i].getBigDecimal() != null) {
				int key = keyGen.getNextKey("tables.switchparams");
				System.out.println("Create PR:"+key+","+equipment+","+date.getSqlDate()+","+
					paramLevel[i].getBigDecimal()+","+paramValue[i].getBigDecimal()+","+paramid+".");
				b = new SwitchParamsAccessBean(
					key,equipment,date.getSqlDate(),
					paramLevel[i].getBigDecimal(),
					paramValue[i].getBigDecimal(),
					paramid
				);
			}
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.swdparams.saveerror",e.getClass().getName()));
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
public com.hps.july.web.util.StringAndSqlDateProperty getDate() {
	return date;
}
/**
 * 
 * @return int
 */
public int getEquipment() {
	return equipment;
}
/**
 * 
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
	return com.hps.july.basestation.APPStates.SWCH_PARAMS_EDIT;
}
public void initData(HttpServletRequest request)
	throws Exception
{
	SwitchDescForm frm = (SwitchDescForm)request.getSession().getAttribute("SwitchDescForm");

	int i = 0;
	for(i = 0; i < 10; i++) {
		paramLevel[i].setBigDecimal(null);
		paramValue[i].setBigDecimal(null);
	}
	
	if(frm.getEquipment() != null) {
		equipment = frm.getEquipment().intValue();
	}
	date.setSqlDate(frm.getDate().getSqlDate());
	
	SwitchParamsAccessBean bf = new SwitchParamsAccessBean();
	Enumeration en = bf.findByEquipment_Actdate_ParamtypeOrderByParamlevelAsc(
		new Integer(equipment),date.getSqlDate(),new Integer(paramid)
	);
	SwitchParamsAccessBean b = null;
	i = 0;
	while(en.hasMoreElements()) {
		b = (SwitchParamsAccessBean)en.nextElement();
		if(b != null) {
			paramLevel[i].setBigDecimal(b.getParam_level());
			paramValue[i].setBigDecimal(b.getParam_value());
		}
		i++;
		if(i > 10) break;
	}
	
	super.initData(request);
}
public void setEquipment(int newEquipment) {
	equipment = newEquipment;
}
public void setParamid(int newParamid) {
	paramid = newParamid;
}
}
