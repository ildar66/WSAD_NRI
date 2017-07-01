package com.hps.july.inventory.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик форм загрузки данных из Excel
 */
public class LoadExcelAction extends AbstractProcessAction {
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
