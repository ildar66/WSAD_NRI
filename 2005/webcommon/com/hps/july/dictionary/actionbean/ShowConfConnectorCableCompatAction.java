/*
 * Created on 25.01.2007
 */
package com.hps.july.dictionary.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.cdbc.objects.CDBCDictionaryObject;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.formbean.ShowConfConnectorCableCompatForm;
import com.hps.july.util.ErrorProcessor;
import com.hps.july.web.util.NavigatedAction;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 */
public class ShowConfConnectorCableCompatAction extends NavigatedAction {

	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {
		super.perform(mapping, form, request, response);
		ActionErrors errors = new ActionErrors();
		ShowConfConnectorCableCompatForm theForm = (ShowConfConnectorCableCompatForm)form;
		// проверяем, что юзер в админных ролях
		theForm.setUserInAdminRole(request.isUserInRole("administrator") || 
			request.isUserInRole("developer") || request.isUserInRole("confResAdmin"));
		try {
			theForm.setupIsAdminRole(request);
			// System.out.println("### theForm.getIsCompatibilityNeedToRefresh() = " 
			// 		+ theForm.getIsNeedCrossToRefresh());
			ParamsParser.setState(request, theForm.getApplication(), theForm.getState());
			if (ShowConfConnectorCableCompatForm.TRUE_STR.equals(theForm.getIsConnectorSelectProcess())) {
				theForm.prepareConnectorsList();
				theForm.setIsConnectorSelectProcess(ShowConfConnectorCableCompatForm.FALSE_STR);
			}
			if (ShowConfConnectorCableCompatForm.TRUE_STR.equals(theForm.getIsCableSelectProcess())) {
				theForm.prepareCablesList();
				theForm.setIsCableSelectProcess(ShowConfConnectorCableCompatForm.FALSE_STR);
			}
			if (ShowConfConnectorCableCompatForm.TRUE_STR.equals(theForm.getIsNeedCrossToRefresh())) {
				// System.out.println("### IsCompatibilityNeedToRefresh");
				theForm.prepareCompatList();
				ParamsParser.setState(request, theForm.getApplication(), theForm.getCompatibilityNeedToRefreshState());
				theForm.setIsNeedCrossToRefresh(ShowConfConnectorCableCompatForm.FALSE_STR);
			}
			if (ShowConfConnectorCableCompatForm.TRUE_STR.equals(theForm.getIsSetNewCompat())) {
				insertNewResCompat(theForm.getCurConnectorSelectedID(), theForm.getCurCableSelectedID(), 
					ShowConfConnectorCableCompatForm.BEGIN_ID_INDEX); 
				theForm.prepareCompatList();
				theForm.setIsSetNewCompat(ShowConfConnectorCableCompatForm.FALSE_STR);
			}
			if (ShowConfConnectorCableCompatForm.TRUE_STR.equals(theForm.getIsDeleteResCompat())) {
				deleteResCompat(theForm.getSelectedCompatRes1(), theForm.getSelectedCompatRes2(), 
					ShowConfConnectorCableCompatForm.BEGIN_ID_INDEX); 
				theForm.prepareCompatList();
				theForm.setIsDeleteResCompat(ShowConfConnectorCableCompatForm.FALSE_STR);
			}
		} catch (Exception e) {
			// System.out.println("### ShowConfConnectorCableCompatAction error = "+e.getMessage());
			ErrorProcessor.processException( errors, e );
		}
		if( !errors.empty() ) {
			saveErrors(request, errors);
			// System.out.println("### ShowConfConnectorCableCompatAction saveError ");
		}
		//
		return mapping.findForward("main");
	}

	/**
	 * @param string
	 * @param string2
	 * @param string3
	 */
	private void deleteResCompat(String connectorIdStr, String cableIdStr, String beginIndex) throws Exception {
		if ((beginIndex.equals(connectorIdStr)) || (beginIndex.equals(cableIdStr))) {
			throw new Exception("Один или оба индекса не действительны для удаления!!!");
		}
		CDBCDictionaryObject.deleteResCompat(connectorIdStr, cableIdStr);
	}

	private void insertNewResCompat(String connectorIdStr, String cableIdStr, String beginIndex) throws Exception {
		if ((beginIndex.equals(connectorIdStr)) || (beginIndex.equals(cableIdStr))) {
			throw new Exception("Один или оба индекса не действительны для добавления!!!");
		}
		CDBCDictionaryObject.insertNewResCompat(connectorIdStr, cableIdStr);
	}    	

}
