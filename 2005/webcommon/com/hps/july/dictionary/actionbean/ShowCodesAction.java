/*
 * Created on 23.11.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.dictionary.valueobject.NFSResourceRow;
import com.hps.july.web.util.BrowseAction;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ShowCodesAction extends Action {
	/**
	 * Представляет набор результатов в виде коллекции
	 */
	private static ArrayList getNFSCollection(CDBCResultSet resultset){
		ArrayList array = new ArrayList();
		ListIterator it = resultset.listIterator();
		while (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			array.add(new NFSResourceRow(row));
		}
		return array;
	}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		CDBCResultSet sc = CDBCResourcesObject.findLinkedNFSResources(new Integer(Integer.parseInt(request.getParameter("resource"))));
		ArrayList array = getNFSCollection(sc);
		request.setAttribute("showCodes", array);
		return mapping.findForward("showall");
	}
}