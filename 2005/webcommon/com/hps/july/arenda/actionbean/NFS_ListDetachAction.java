/*
 * Created on 03.07.2006
 *
 * Платежи NFS BrowseAction
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.formbean.NFS_ListDetachForm;
import com.hps.july.web.util.BrowseAction;

/**
 * @author IShaffigulin
 *
 * Платежи NFS BrowseAction
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NFS_ListDetachAction extends BrowseAction {
	//константы operation:
	public final static String PRINT_XLS = "printXLS";
	private int countRowsOnPage = 500;
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#perform(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		NFS_ListDetachForm iForm = (NFS_ListDetachForm) form;
		if (NFS_ListDetachAction.PRINT_XLS.equals(iForm.getOperation())) {
			setCountRowsOnPage(5000);
			super.perform(mapping, form, request, response);
			iForm.setOperation(NFS_ListDetachForm.OPERATION_NO);
			return mapping.findForward(NFS_ListDetachAction.PRINT_XLS);
		} else {
			setCountRowsOnPage(500);
			return super.perform(mapping, form, request, response);
		}
	}
	

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseAction#getRowsOnPage()
	 */
	public int getRowsOnPage() {
		return getCountRowsOnPage();
	}

	/**
	 * @param i
	 */
	private void setCountRowsOnPage(int i) {
		countRowsOnPage = i;
	}

	/**
	 * @return
	 */
	private int getCountRowsOnPage() {
		return countRowsOnPage;
	}

}
