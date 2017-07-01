package com.hps.july.inventory.actionbean;

import com.hps.july.inventory.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.inventory.sessionbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * Обобщённый обработчик отчётов.
 * В отличии от AbstractProcessAction выполняет только проверку формы.
 */
public class ReportProcessAction
	extends AbstractProcessAction
{
public ActionForward processDelete( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.beforeDelete(null,request);
	editForm.validateValues(errors);
	editForm.afterDelete(request);
	return null;
}
public ActionForward processInsert( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.beforeUpdate(null,request);
	editForm.validateValues(errors);
	editForm.afterUpdate(null,request);
	return null;
}
public ActionForward processUpdate( HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	editForm.beforeUpdate(null,request);
	editForm.validateValues(errors);
	editForm.afterUpdate(null,request);
	return null;
}
}
