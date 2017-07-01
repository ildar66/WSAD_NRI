package com.hps.july.arenda.formbean;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.cdbcobjects.CDBC_LeasePriorCntForAct_Object;
import com.hps.july.arenda.valueobject.*;

/**
 * "Приоритеты списания задолженности с договора" EditForm.
 * Creation date: (07.11.2005 11:56:14)
 * @author: Shafigullin Ildar
 */
public class PriorityContractForActListForm extends com.hps.july.web.util.EditForm {
	private java.lang.String sortBy;
	private List list;
	private int leaseDocument;
	private String operation;
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:08:01)
	 */
	public PriorityContractForActListForm() {
		setSortBy("5 desc,2");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:05:23)
	 * @return java.util.List
	 */
	public java.util.List getList() {
		return list;
	}
	/**
	 * Текущее приложение.
	 * Creation date: (07.11.2005 11:56:14)
	 * @return int
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:42:13)
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:04:33)
	 * @return java.lang.String
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}
	/**
	 * Текущее состояние приложения.
	 * Creation date: (07.11.2005 11:56:14)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.PRIORITY_CONTRACT_FOR_ACT_LIST;
	}
	/**
	 * Инициализация коллекций перед отображением пользователю.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		operationTask(request);
		if (getLeaseDocument() != 0) {
			List list = com.hps.july.arenda.cdbcobjects.CDBC_LeasePriorCntForAct_Object.getList(getLeaseDocument(), getSortBy());
			setList(list);
			//System.out.println("list size=" + list.size());//temp
		} else {
			setList(Collections.EMPTY_LIST);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:05:23)
	 * @param newAktList java.util.List
	 */
	public void setList(java.util.List newAktList) {
		list = newAktList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 12:04:33)
	 * @param newSortBy java.lang.String
	 */
	public void setSortBy(java.lang.String newSortBy) {
		sortBy = newSortBy;
	}
	/**
	 * @return
	 */
	public int getLeaseDocument() {
		return leaseDocument;
	}

	/**
	 * @param i
	 */
	public void setLeaseDocument(int i) {
		leaseDocument = i;
	}

	/**
	 * @return
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param string
	 */
	public void setOperation(String string) {
		operation = string;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 19:04:25)
	 */
	private void operationTask(javax.servlet.http.HttpServletRequest request) {
		//System.out.println("operation=" + operation); //temp
		if ("savePriority".equals(getOperation())) {
			String[] priorM = request.getParameterValues("vo.priority");
			for (int i = 0; i < priorM.length; i++) {
				//System.out.println("priorM[" + i + "]=" + priorM[i]); //temp
				LeasePriorCntForAct_VO vo = ((LeasePriorCntForAct_TO) getList().get(i)).getVo();
				//System.out.println(vo); //temp
				Integer fromPriority = vo.getPriority();
				Integer toPriority = null;
				try {
					toPriority = new Integer(priorM[i]);
				} catch (NumberFormatException e) {
					System.out.println("Недопустимый ввод для приоритета:'" + priorM[i] + "'");
					continue;
				}
				vo.setPriority(toPriority);
				LeasePriorCntForAct_VO findVO = CDBC_LeasePriorCntForAct_Object.find(vo.getIdact(), vo.getLeasedocument());
				if (findVO != null) {
					Integer findPriority = findVO.getPriority();
					if (!toPriority.equals(findPriority)) {
						CDBC_LeasePriorCntForAct_Object.edit(vo);
					}
				} else {
					if (!toPriority.equals(CDBC_LeasePriorCntForAct_Object.DEFAULT_PRIORITY)) {
						CDBC_LeasePriorCntForAct_Object.add(vo);
					}
				}
			}
			resetMass();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2005 16:55:36)
	 */
	private void resetMass() {
		setOperation("");
	}
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		resetMass();
	}

}
