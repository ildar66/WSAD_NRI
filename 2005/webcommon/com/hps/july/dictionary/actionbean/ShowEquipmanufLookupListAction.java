/*
 * Created on 07.05.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.dictionary.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.dictionary.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * @author AAErmolov
 *
 * Обработчик формы выбора производителя оборудования
 * 
 */
public class ShowEquipmanufLookupListAction extends LookupBrowseAction {
	public java.lang.String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBCDictionaryObject";
	}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform( mapping, form, request, response );
		ParamsParser.setState( request, Applications.DICTIONARY, APPStates.MANUFLOOKUP );
		return mapping.findForward( "main" );
	}
}