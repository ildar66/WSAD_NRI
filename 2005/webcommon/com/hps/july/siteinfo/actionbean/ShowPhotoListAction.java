package com.hps.july.siteinfo.actionbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.siteinfo.*;
import com.hps.july.siteinfo.valueobject.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Обработчик списка фотографий
 * @author: Administrator
 */
public class ShowPhotoListAction extends com.hps.july.web.util.BrowseAction {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCPhotosObject";
}
/**
 * Возвращает кол-во строк перекрытия при листании страниц.
 * Creation date: (10.06.2003 13:39:08)
 * @return int
 */
public int getOverlapRows() {
	return 0;
}
/**
 * Определяет кол-во строк на странице.
 * Creation date: (22.01.2002 17:12:04)
 * @return int
 */
public int getRowsOnPage() {
	int result = -1;
	return result;
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	setJavaVersion(request);
    ParamsParser.setState(request, Applications.SITEINFO, APPStates.PHTLIST);
    PhotoListForm oform = (PhotoListForm) form;

    if (oform.photographerId.getInteger() == null) {
        oform.setIsPhotographer(new Boolean(false));
        ActionErrors errors = new ActionErrors();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.photographer"));
        saveErrors(request, errors);
    }

    try {
        PositionAccessBean bean = new PositionAccessBean();
        bean.setInitKey_storageplace(oform.getStorageplace());
        bean.refreshCopyHelper();
        oform.setPosid("");
        if (bean.getGsmid() != null)
            oform.setPosid("D" + bean.getGsmid() + " ");
        if (bean.getDampsid() != null)
            oform.setPosid(oform.getPosid() + "A" + bean.getDampsid());

        oform.setPosname(bean.getName());
        if ((bean.getDampsname() != null) && (bean.getDampsname().length() > 0))
            oform.setPosname(oform.getPosname() + " / " + bean.getDampsname());

    } catch (Exception e) {
        oform.setStorageplace(0);
        oform.setPosid("");
        oform.setPosname("");
    }

/*	Connection connection = null;
	PreparedStatement prepstatement = null;
	ResultSet rs = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		prepstatement = connection.prepareStatement(
			com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_SELECT_UNIQUE_GROUP
		);
		//System.out.println("SQL_PHOTO_SELECT_WITHOUT_IMAGES ["+SQL_PHOTO_SELECT_UNIQUE_GROUP+"]");
		rs = prepstatement.executeQuery();
		ArrayList groups = new ArrayList();
		if(rs.next()) {
			groups.add(rs.getString("gn"));
		}
		
	} catch(Exception e) {
		System.out.println("Error loading image with id ["+getPhoto()+"], cause " + e.toString());
		e.printStackTrace();
	} finally {
		try { if(rs != null) rs.close(); } catch(Exception e) {} 
		try { if(prepstatement != null) prepstatement.close(); } catch(Exception e) {} 
		try { if(connection != null) connection.close(); } catch(Exception e) {} 
	}
*/    

    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
private void setJavaVersion(HttpServletRequest request){

	String javaVer = request.getParameter("javaVer");
	if(javaVer != null){
		HttpSession session = request.getSession();
		session.setAttribute("javaVer", javaVer.compareTo("1.3") >= 0 ? "true" : "false");
	}
}
}
