/*
 * Created on 23.05.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.basestation.actionbean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.basestation.formbean.ChooseDocumentForm;
import com.hps.july.logic.InventoryDocumentLogic;

/**
 * @author ria
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChooseDocumentFormAction extends Action implements ChooseDocumentFormConstants {

	public final static String GOTO_I = "gotoDocCode_I";
	public final static String GOTO_N = "gotoDocCode_N";
	public final static String GOTO_A = "gotoDocCode_A";
	public final static String GOTO_H = "gotoDocCode_H";
	public final static String GOTO_T = "gotoDocCode_T";
	public final static String GOTO_T_2 = "gotoDocCode_T_2";
	public final static String GOTO_T_2_2 = "gotoDocCode_T_2_2";
	public final static String GOTO_F = "gotoDocCode_F";
	public final static String GOTO_B = "gotoDocCode_B";
	public final static String GOTO_B_2 = "gotoDocCode_B_2";
	public final static String GOTO_B_3 = "gotoDocCode_B_3";
	public final static String GOTO_Z = "gotoDocCode_Z";
	
	public final static String GOTO_BACK_BS_GSM = "gotoBackToBsGSM";
		
	/**
	 * ��� ������� ����� ������������� ����� ������ ������ ������������� ������ ���� ���������:
	 * 
	 * 			������� (?)
	 * "A" 		��� ������� ������					EditAssactB.do
	 * 			��� ��������� ������				EditDAssactB.do
	 * 			??? ��� �� ��������� (��� ����� �������� ����� ����) ???
	 * "B"		��� ������� ���						EditAfsMountAct3.do
	 * "T"		��� �������							EditAssemblingP.do
	 * 
	 * 			�������
	 * "N"		��� ���������						EditDemount.do
	 * 
	 * 			������
	 * "I"		��� ��������������					EditPositionInventory.do
	 * "H"		��� ������ / ������������			EditChangeP.do
	 * "F"		������� ������						EditFault.do
	 * "Z"		��� �������������� �� ����������	EditContractorInventory.do
	 */
	
	private final static String DOC_ACTION_PARAM_NAME = "?action=";
	private final static String DOC_ACTION_EDIT_NAME = "Edit";
	private final static String DOC_ACTION_VIEW_NAME = "View";
	private final static String DOC_DOCUMENT_PARAM_NAME = "&document=";
	private final static String DOC_DOC_PARAM_NAME = "&doc=";
	private final static String DOC_AKT_PARAM_NAME = "&act=";
		
	// public ActionForward execute(ActionMapping mapping, ActionForm form,
	public ActionForward perform(ActionMapping mapping, ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
									throws IOException, ServletException {
		System.out.println("ChooseDocumentFormAction perform begin");
		super.perform(mapping, form, request, response);
		Integer idDoc = null;
		String docTypeCode = null;
		Integer visualType = null;
		String state = null;
		String isAutoDoc = null;
		//	   Default target to success
		System.out.println("ChooseDocumentFormAction perform form = " + form);
		if (form != null) {
			ChooseDocumentForm chooseDocumentForm = (ChooseDocumentForm) form;
			idDoc = chooseDocumentForm.getIdDoc();
			docTypeCode = chooseDocumentForm.getDocTypeCode();
			visualType = chooseDocumentForm.getVisualType();
			state = chooseDocumentForm.getState();
			isAutoDoc = chooseDocumentForm.getIsAutoDoc();
		}
		System.out.println("ChooseDocumentFormAction perform idDoc = " + idDoc);
		System.out.println("ChooseDocumentFormAction perform docTypeCode = " + docTypeCode);
		System.out.println("ChooseDocumentFormAction perform visualType = " + visualType);
		System.out.println("ChooseDocumentFormAction perform state = " + state);
		System.out.println("ChooseDocumentFormAction perform isAutoDoc = " + isAutoDoc);
		String target = "";
		String docAction = null;
		ActionForward resultActionForward = null;
		String docParamName = null;
		//
		// ������ ������������ � ������������ ��������������
		// ����� ����� �������� �� ������
		// ����� �������� �� �������
		if (InventoryDocumentLogic.isDocForEdit(state, isAutoDoc)) {
			docAction = DOC_ACTION_EDIT_NAME;
		} else {
			docAction = DOC_ACTION_VIEW_NAME;
		}
		//
		if ((idDoc != null) && (docTypeCode != null)) {
			char firstDocTypeCodeChar = docTypeCode.charAt(0);
			switch (firstDocTypeCodeChar) {
				// ������
				// ���� �� ������
				case A_DOC_CODE:
					// ??? ����� ������� ������ ���� ��� �������� �� ������ � �� �������� ???
					// ??? ��� ����� ��������� ���-�� ???
					target = GOTO_A;
					docParamName = DOC_DOCUMENT_PARAM_NAME;
					break;
				// ���� �� AFS	
				case B_DOC_CODE:
					if (InventoryDocumentLogic.isAFS1800or900(visualType)) {
						target = GOTO_B_3;
						docParamName = DOC_DOCUMENT_PARAM_NAME;
					} else if (InventoryDocumentLogic.isAFS1800and900(visualType)) {
						target = GOTO_B_2;
						docParamName = DOC_DOCUMENT_PARAM_NAME;
					} else {
						target = GOTO_B;
						docParamName = DOC_DOC_PARAM_NAME;
					}
					break;
				// ���� �������	
				case T_DOC_CODE:
					if (InventoryDocumentLogic.isAssembleForEditMountAct2(visualType)) {
						target = GOTO_T_2;
						docParamName = DOC_DOCUMENT_PARAM_NAME;
					} else if (InventoryDocumentLogic.isAssembleForMountAct2Edit2(visualType)) {
						target = GOTO_T_2_2;
						docParamName = DOC_DOCUMENT_PARAM_NAME;
					} else {
						target = GOTO_T;
						docParamName = DOC_DOC_PARAM_NAME;
					}
					break;
				// ������
				// ��� ���������
				case N_DOC_CODE:
					target = GOTO_N;
					docParamName = DOC_DOC_PARAM_NAME;
					break;
				// ������	
				// ��� ��������������
				case I_DOC_CODE:
					target = GOTO_I;
					docParamName = DOC_DOCUMENT_PARAM_NAME;
					break;
				// 	
				case H_DOC_CODE:
					target = GOTO_H;
					docParamName = DOC_DOCUMENT_PARAM_NAME;
					break;
				// ������� �����	
				case F_DOC_CODE:
					target = GOTO_F;
					docParamName = DOC_DOCUMENT_PARAM_NAME;
					break;
				// ��� �������������� �� ����������	
				case Z_DOC_CODE:
					target = GOTO_Z;
					docParamName = DOC_AKT_PARAM_NAME;
					break;
				default:
					break;	
			} 
		}
		// ������ ����������� ��������� � �����
		resultActionForward = forwardSetup(mapping, target, docAction, docParamName, idDoc);
		System.out.println("ChooseDocumentFormAction perform end resultActionForward.getPath() = " + resultActionForward.getPath());
		return resultActionForward;
	}

	private ActionForward forwardSetup(ActionMapping mapping, String target, String actionValue, String docParamName, Integer docId) {
		ActionForward b;
		if (docParamName != null) {
			ActionForward a = mapping.findForward(target);
			b = new ActionForward();
			b.setPath(a.getPath() + DOC_ACTION_PARAM_NAME + actionValue + docParamName + docId); 
			b.setRedirect(a.getRedirect());
		} else {
			// �� ��������� ������� ����� (���� �� �������� ��������)
			b = mapping.findForward(GOTO_BACK_BS_GSM);
		}
		return b;		
	}
	
}
