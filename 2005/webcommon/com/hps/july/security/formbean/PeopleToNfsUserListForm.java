/*
 * Created on 06.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.security.formbean;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hps.july.valueobject.People_VO;
import com.hps.july.web.util.*;
import com.hps.july.security.*;
import com.hps.july.cdbc.objects.CDBC_People_Object;
import com.hps.july.constants.*;

/**
 * @author IShaffigulin
 *
 * Связь оператора с Пользователями системы NFS (BrowseForm)
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PeopleToNfsUserListForm extends BrowseForm {
	private java.lang.String name;
	private String orderBy;
	private java.lang.String activestate;
	private Integer man;
	private java.lang.String operation = "";
	private int selectedID;
	private People_VO vo;
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 13:30:34)
	 */
	public PeopleToNfsUserListForm() {
		name = "*";
		setActivestate("ALL");
		setOrderBy("fullName desc");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.07.2003 15:40:58)
	 * @return java.lang.String
	 */
	public java.lang.String getActivestate() {
		return activestate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 12:02:58)
	 * @return java.lang.String
	 */
	public java.lang.String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBC_Nfs_LnkUser_Object";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 12:00:34)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] {
			getMan(),
			//new Boolean(true),
			new Boolean(false),
			getName(),
			"ALL".equals(getActivestate()) ? new Boolean(false) : new Boolean(true),
			getActivestate(),
			getOrderBy()};
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 11:20:35)
	 * @return java.lang.String
	 */
	public java.lang.String getFinderMethodName() {
		return "findList";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.02.2002 16:35:20)
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 16:25:07)
	 * @return java.lang.String
	 */
	public java.lang.String getOrderBy() {
		return orderBy;
	}
	/**
	 * Для каждой строки броуза можно переопределить возвращаемый объект.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		vo = CDBC_People_Object.find(getMan().intValue());
		ParamsParser.setState(request, Applications.SECURITY, APPStates.PEOPLE_TO_NFS_USER_LIST);
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.07.2003 15:40:58)
	 * @param newActivestate java.lang.String
	 */
	public void setActivestate(java.lang.String newActivestate) {
		activestate = newActivestate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.02.2002 16:35:20)
	 * @param newName java.lang.String
	 */
	public void setName(java.lang.String newName) {
		name = newName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 16:25:07)
	 * @param newOrderBy java.lang.String
	 */
	public void setOrderBy(java.lang.String newOrderBy) {
		orderBy = newOrderBy;
	}

	/**
	 * @return
	 */
	public Integer getMan() {
		return man;
	}

	/**
	 * @param integer
	 */
	public void setMan(Integer integer) {
		man = integer;
	}

	/**
	 * @return
	 */
	public int getSelectedID() {
		return selectedID;
	}

	/**
	 * @param i
	 */
	public void setSelectedID(int i) {
		selectedID = i;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if (operation.equalsIgnoreCase("deleteLink")) {
			deleteLink(errors);
		} else if (operation.equalsIgnoreCase("addLink")) {
			addLink(errors);
		} else if(operation.equalsIgnoreCase("setMainLink")){
			setMainLink(errors);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:54:28)
	 * @param errors org.apache.struts.action.ActionErrors
	 */
	private void deleteLink(ActionErrors errors) {
		try {
			boolean ok = com.hps.july.cdbc.objects.CDBC_Nfs_LnkUser_Object.deleteLink(getMan().intValue(), getSelectedID());
			if (!ok) {
				String errorStr = "Ошибка удаления записи: getSelectedID()=" + getSelectedID();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			}
		} catch (Exception e) {
			System.out.println(this.getClass()+ ":validateValues():errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
	}	
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:54:28)
	 * @param errors org.apache.struts.action.ActionErrors
	 */
	private void addLink(ActionErrors errors) {
		try {
			boolean ok = com.hps.july.cdbc.objects.CDBC_Nfs_LnkUser_Object.addLink(getMan().intValue(), getSelectedID(), "N");
			if (!ok) {
				String errorStr = "Ошибка добавления записи: getSelectedID()=" + getSelectedID();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			}
		} catch (Exception e) {
			System.out.println(this.getClass()+ ":validateValues():errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:54:28)
	 * @param errors org.apache.struts.action.ActionErrors
	 */
	private void setMainLink(ActionErrors errors) {
		try {
			boolean ok = com.hps.july.cdbc.objects.CDBC_Nfs_LnkUser_Object.setMainLink(getMan().intValue(), getSelectedID());
			if (!ok) {
				String errorStr = "Ошибка setMainLink записи: getSelectedID()=" + getSelectedID();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			}
		} catch (Exception e) {
			System.out.println(this.getClass()+ ":validateValues():errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public java.lang.String getOperation() {
		return operation;
	}

	/**
	 * @param string
	 */
	public void setOperation(java.lang.String string) {
		operation = string;
	}

	/**
	 * @return
	 */
	public People_VO getVo() {
		return vo;
	}

	/**
	 * @param people_VO
	 */
	private void setVo(People_VO people_VO) {
		vo = people_VO;
	}

}
