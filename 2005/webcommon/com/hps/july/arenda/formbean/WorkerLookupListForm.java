package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.cdbc.lib.*;
import com.hps.july.arenda.valueobject.*;
/**
* Form-Bean для поиска из таблицы "Workers".
* Creation date: (15.01.2002 14:06:31)
* @author: Administrator
*/
public class WorkerLookupListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.String lastname;
	private java.lang.String sortBy = "lastname";
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerLookupListForm() {
	this.setFinderMethodName("findListWorkers");
	lastname = "";
	}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
    if (o == null) {
        return o;
    }
    if (!(o instanceof CDBCRowObject)) {
        System.out.println("WorkerLookupListForm: CLASS_CAST: " + o.getClass().getName());
        return o;
    }
    CDBCRowObject ro = (CDBCRowObject) o;
    WorkerVO vo = new WorkerVO((Integer) ro.getColumn("worker").asObject());
    vo.initMan(ro);
    vo.initPosition(ro);
    return vo;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.arenda.cdbcobjects.CDBC_WorkerObject";
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { lastname, getSortBy() };
}
/**
 * Insert the method's description here.
 * Creation date: (23.02.2002 11:20:12)
 * @return java.lang.String
 */
public java.lang.String getLastname() {
	return lastname;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 15:55:15)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.WORKER_LOOKUP);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.02.2002 11:20:12)
 * @param newLastname java.lang.String
 */
public void setLastname(java.lang.String newLastname) {
	lastname = newLastname;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 15:55:15)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
}
