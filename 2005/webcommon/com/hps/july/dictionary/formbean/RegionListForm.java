package com.hps.july.dictionary.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import org.apache.struts.action.*;
import org.apache.struts.taglib.template.GetTag;

import com.hps.july.valueobject.AdminRegion_VO;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.CDBC_AdminRegion_Object;
/**
* "Административно-территориальное деление.".
* Creation date: (04.10.2005 11:37:58)
* @author: Shafigullin Ildar
*/
public class RegionListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String sortBy;
	private java.lang.Boolean isName;
	private java.lang.String name;
	private java.lang.Boolean isParentRegID;
	private java.lang.Integer parentRegID;
	private java.lang.String title;
	//для сохранения истории:
	private ArrayList historyList;
	//для текущих операций:
	private String operations = "";
	//для изменения родителя иерархии:
	private String regIDs = "";
	private Integer toParentRegID = null;
	/**
	 * RegionListForm constructor comment.
	 */
	public RegionListForm() {
		super();
		setFinderMethodName("getList");
		isName = java.lang.Boolean.TRUE;
		isParentRegID = java.lang.Boolean.FALSE;
		name = "";
		parentRegID = CDBC_AdminRegion_Object.NULL_PARENT_ID;
		sortBy = "regionname";
		historyList = new ArrayList();
		setLastVisited(true);
	}
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.cdbc.objects.CDBC_AdminRegion_Object";
	}
	/**
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (04.10.2005 11:37:58)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] { getIsName().booleanValue() ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE, getName(), getIsParentRegID(), getParentRegID(), getSortBy()};
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.10.2005 15:25:51)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getIsName() {
		return isName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.10.2005 12:10:25)
	 * @return java.lang.String
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.10.2005 11:38:47)
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
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		computeHistory();
		operationTasks();
		ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.REGION_LIST);
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.10.2005 15:25:51)
	 * @param newIsName java.lang.Boolean
	 */
	public void setIsName(java.lang.Boolean newIsName) {
		isName = newIsName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.10.2005 12:10:25)
	 * @param newName java.lang.String
	 */
	public void setName(java.lang.String newName) {
		name = newName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.10.2005 11:38:47)
	 * @param newSortBy java.lang.String
	 */
	public void setSortBy(java.lang.String newSortBy) {
		sortBy = newSortBy;
	}
	/**
	 * @return
	 */
	public java.lang.Boolean getIsParentRegID() {
		return isParentRegID;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getParentRegID() {
		return parentRegID;
	}

	/**
	 * @param boolean1
	 */
	public void setIsParentRegID(java.lang.Boolean boolean1) {
		isParentRegID = boolean1;
	}

	/**
	 * @param integer
	 */
	public void setParentRegID(java.lang.Integer integer) {
		parentRegID = integer;
	}

	protected void computeHistory() {
		if (getParentRegID() != null && getParentRegID().intValue() != CDBC_AdminRegion_Object.NULL_PARENT_ID.intValue()) {
			AdminRegionHistory hist = new AdminRegionHistory();
			hist.setIsName(getIsName());
			hist.setIsParentRegID(getIsParentRegID());
			hist.setName(getName());
			hist.setParentRegID(getParentRegID());
			hist.setSortBy(getSortBy());
			//hist.setTitle(getTitle());
			AdminRegion_VO vo = CDBC_AdminRegion_Object.find(getParentRegID().intValue());
			String titleParent = (vo != null) ? vo.getRegionname() : "NULL for getParentRegID()=" + getParentRegID();
			hist.setTitle(titleParent);
			if (!historyList.contains(hist)) {
				historyList.add(hist);
			} else {
				int pos = historyList.indexOf(hist);
				List list = historyList.subList(0, pos + 1);
				historyList = new ArrayList(list);
			}
		} else {
			setHistoryList(new ArrayList());
		}

	}

	/**
	 * @return
	 */
	public ArrayList getHistoryList() {
		return historyList;
	}

	/**
	 * @param list
	 */
	private void setHistoryList(ArrayList list) {
		historyList = list;
	}

	/**
	 * @return
	 */
	public java.lang.String getTitle() {
		return title;
	}

	/**
	 * @param string
	 */
	public void setTitle(java.lang.String string) {
		title = string;
	}

	/** 
	*
	*/
	private void operationTasks() {
		if (getOperations().equalsIgnoreCase("changeParentRegID")) {
			System.out.println("Selected = " + getRegIDs()); //temp
			if (getRegIDs() != null && !getRegIDs().trim().equals("")) {
				CDBC_AdminRegion_Object.setParentRegionID(getToParentRegID(), getRegIDs());
			} else {
				//CDBC_AdminRegion_Object.setParentRegionID(getToParentRegID(), getRegIDs());
				System.err.println("Неверное значение для getRegIDs=" + getRegIDs());
			}
			//сброс задачи:
			setRegIDs("");
			setToParentRegID(null);
		}
		setOperations("");
	} /**
					 * @return
					 */
	public String getOperations() {
		return operations;
	} /**
							 * @param string
							 */
	public void setOperations(String string) {
		operations = string;
	}

	/**
	 * @return
	 */
	public String getRegIDs() {
		return regIDs;
	}

	/**
	 * @param string
	 */
	public void setRegIDs(String string) {
		regIDs = string;
	}

	/**
	 * @return
	 */
	public Integer getToParentRegID() {
		return toParentRegID;
	}

	/**
	 * @param integer
	 */
	public void setToParentRegID(Integer integer) {
		toParentRegID = integer;
	}

}
