package com.hps.july.dictionary.formbean;

import java.util.Vector;
import java.util.Enumeration;
import com.hps.july.web.util.*;
import com.hps.july.dictionary.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;


/**
 * Форма списка антенн радиорелейных линий
 */
public class RRLAntenaListForm
	extends ResourceListForm
{
public RRLAntenaListForm() {
	super();
	setFinderMethodName("1");

	setShowType("Y");
	setIsResourcetype(Boolean.FALSE);
	getResourcetype().setInteger(null);
	setIsResourcesubtype(Boolean.FALSE);
	//getResourcesubtype().setInteger(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("Dict_ANTTYPE")));
	getResourcesubtype().setInteger(null);
	setName("Комплект оборудования РРЛ");
	setIsName(Boolean.TRUE);
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCResourcesObject";
}
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList(2);
		roles.add("administrator");
		roles.add("dictResAdmin");
		//roles.add("dictResOperator");
		return roles;
	}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		getIsResourcetype(),
		(getResourcetype().getInteger() != null)?getResourcetype().getInteger():new Integer(0),
		getIsResourcesubtype(),
		(getResourcesubtype().getInteger() != null)?getResourcesubtype().getInteger():new Integer(0),
		getIsModel(), getModel(),
		getIsName(), getName(),
		getIsManuf(), (getManuf().getInteger() != null)?getManuf().getInteger():new Integer(0),
		getIsManucode(), getManucode(),
		getIsNfscode(), getNfscode(),
		getIsNricode(), getNricode(),
		getShowType(),
		new Integer(getSortmode())
	};
}
/**
 * Возвращает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findRRLResourcesList";
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request,
    	HttpServletResponse response) throws IOException, ServletException {
	    	
	  	ParamsParser.setState( request, Applications.DICTIONARY, APPStates.RRLANTRESOURCE_LIST );
	  	return null;
}
}
