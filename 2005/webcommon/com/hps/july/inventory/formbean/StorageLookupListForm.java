package com.hps.july.inventory.formbean;

import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * Форма выбора склада
 *
 * В настоящее время не используется и во всех формах модуля "Учёт оборудования"
 * замененя на выбпадающий список
 */
public class StorageLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
	private boolean _isadmin;
	private String _username;
public StorageLookupListForm()
{
	this.setFinderMethodName( "listStoragesFor" );
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		new Boolean(_isadmin),
		(_username!=null)?_username:""
	};
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	super.initBrowse(mapping,request,response);
	_isadmin = request.isUserInRole("administrator");
	_username = request.getRemoteUser();
	return null;
}
}
