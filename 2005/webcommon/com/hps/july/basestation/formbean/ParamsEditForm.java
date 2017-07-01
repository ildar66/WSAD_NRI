package com.hps.july.basestation.formbean;

import javax.servlet.http.*;
import org.apache.struts.action.ActionErrors;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;

/**
 * Форма редактирования сложных параметров эксплуатационных характеристик
 */
public abstract class ParamsEditForm extends EditForm {
	private boolean initialized = false;
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
abstract public void doSave(HttpServletRequest request, HttpServletResponse response, ActionErrors errors)
	throws Exception;
public int getApplication() {
	return 0;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
public int getState() {
	return 0;
}
public void initData(HttpServletRequest request)
	throws java.lang.Exception
{
	initialized = true;
}
public boolean isInitialized() {
	return initialized;
}
}
