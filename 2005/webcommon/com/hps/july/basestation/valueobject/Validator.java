package com.hps.july.basestation.valueobject;

import java.util.Iterator;
import java.math.BigDecimal;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;

/**
 * Служебный класс. Облегчает проверку параметров в формах
 */
public class Validator {
	private String prefix;
	private String suffix;
	private ActionErrors errors;
	
	public Validator(String prefix, String suffix, ActionErrors errors) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.errors = errors;
	}
	public void checkBigDecimal(String fieldName, StringAndBigDecimalProperty val, boolean required)
	{
		if (required && val.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR,getError(fieldName,"empty"));
		}
		if (!val.isEmpty() && !val.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR,getError(fieldName,"invalid"));
		}
	}
	public void checkDate(String fieldName, StringAndSqlDateProperty val, boolean required)
	{
		if (required && val.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR,getError(fieldName,"empty"));
		}
		if (!val.isEmpty() && !val.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR,getError(fieldName,"invalid"));
		}
	}
	public void checkInteger(String fieldName, StringAndIntegerProperty val, boolean required) {
		if (required && val.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR,getError(fieldName,"empty"));
		}
		if (!val.isEmpty() && !val.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR,getError(fieldName,"invalid"));
		}
	}
	public void checkString(String fieldName, String val, int len, boolean required) {
		if (required && (val != null && !"".equals(val.trim()))) {
			errors.add(ActionErrors.GLOBAL_ERROR,getError(fieldName,"empty"));
		}
		if (val != null && (val.trim().length() > len)) {
			errors.add(ActionErrors.GLOBAL_ERROR,getError(fieldName,"length"));
		}
	}
	public void finishCheck() throws com.hps.july.web.util.ValidationException {
		if (!errors.empty()) {
			Iterator it = errors.get();
			while(it.hasNext()) {
				ActionError er = (ActionError)it.next();
				System.out.println("V:ERR: "+er.getKey());
			}
			throw new com.hps.july.web.util.ValidationException();
		}
	}
	private ActionError getError(String name, String type) {
		String s = (prefix != null ? prefix + "." : "")
			+ name
			+ "."
			+ type
			+ (suffix != null ? "."+suffix : "");

		System.out.println("ERROR: "+s);	
		return new ActionError(s);
	}
}
