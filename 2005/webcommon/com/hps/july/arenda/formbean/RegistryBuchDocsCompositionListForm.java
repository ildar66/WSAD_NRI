package com.hps.july.arenda.formbean;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;

import com.hps.july.web.util.*;
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocs_Object;
import com.hps.july.arenda.valueobject.LeaseRegistryBuchDocs_TO;
import com.hps.july.constants.*;
import com.hps.july.valueobject.*;
/**
 * Insert the type's description here.
 * Creation date: (08.12.2005 11:47:17)
 * @author: Shafigullin Ildar
 */
public class RegistryBuchDocsCompositionListForm extends com.hps.july.web.util.BrowseForm {
	private String searchStr = "*";
	private Integer economist = null;
	private String orderBy = null;
	private java.lang.String operation = null;
	//выбранные документы:
	private String selectIds = "";
	private String stateSelectIds = "";
	private String selectIds2 = "";
	private Integer idRegistryDoc;
	private LeaseRegistryBuchDocs_TO to;
	//фильтр запроса:
	private boolean isEconomist = true;
	private boolean isCreatedBy = true;
	private boolean isModifiedBy = true;
	//группа запроса:
	private boolean isInitialGroup = true;
	//работаем с разделением по филиалам:
	//private Boolean isRegionID = new Boolean(true);
	private Integer regionID = null;
	/**
	 * RegistryBuchDocsCompositionListForm constructor comment.
	 */
	public RegistryBuchDocsCompositionListForm() {
		super();
		setOperation("");
	}
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocs_Object";
	}
	/**
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (08.12.2005 11:47:17)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		return new Object[] { getSearchStr() ,getEconomist(), getIdRegistryDoc(), getOrderBy(), getTo().getVo().getTypeRegistry(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, getRegionID() };
	}
	/**
	 * Возвращает имя метода поиска.
	 * Creation date: (22.01.2002 11:20:35)
	 * @return java.lang.String
	 */
	public java.lang.String getFinderMethodName() {
		return "getListComposition";
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 19:00:38)
	 * @return java.lang.String
	 */
	public java.lang.String getOperation() {
		return operation;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 12:52:49)
	 * @return java.lang.String
	 */
	public java.lang.String getOrderBy() {
		return orderBy;
	}
	/**
	 * Инициализация режима просмотра списка.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		setRegionID(ProfileAccessHelper.getCurrentRegionID(request));
		initLeaseRegistryBuchDocs_TO(getIdRegistryDoc());
		Integer typeRegistryBuchDoc = getTo().getVo().getTypeRegistry();
		String stateRegistryBuchDoc = getTo().getVo().getState();
		initOrderByFromTypeRegistry(typeRegistryBuchDoc);
		operationTask(typeRegistryBuchDoc.intValue(), stateRegistryBuchDoc);
		if(AbstractRegistryBuchDocsStateFactory.PREPARATION.equals(stateRegistryBuchDoc)){
			initListAccessDocsFromTypeRegistry(request, typeRegistryBuchDoc);
		}
		computeStateFromTypeRegistry(request, typeRegistryBuchDoc);
		return null;
	}
	/**
	 * 
	 * @param request
	 */
	private void initOrderByFromTypeRegistry(Integer typeRegistryBuchDoc) {
		if (getOrderBy() != null)
			return;
		if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF)
			setOrderBy("dateSchetFakt desc");
		else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_CWA) {
			setOrderBy("docDateCWA desc");
		} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_LeaseDoc) {
			setOrderBy("ld.docDate desc");
		} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF_CWA) {
			setOrderBy("ld.docDate desc");
		} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_MUTUAL_ACT) {
			setOrderBy("docDate desc");			
		}
	}
	/**
	 * 
	 * @param request
	 */
	private void computeStateFromTypeRegistry(HttpServletRequest request, Integer typeRegistryBuchDoc) {
		int state = -1;
		if(getIsInitialGroup()){
			if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_SF_IG;
			} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_CWA) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_CWA_IG;
			} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_LeaseDoc) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_LeaseDoc_IG;
			} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF_CWA) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_SF_CWA_IG;
			} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_MUTUAL_ACT) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_MUTUAL_ACT_IG;
			}			
		}else{
			if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_SF_RG;
			} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_CWA) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_CWA_RG;
			} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_LeaseDoc) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_LeaseDoc_RG;
			} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF_CWA) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_SF_CWA_RG;
			} else if (typeRegistryBuchDoc.intValue() == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_MUTUAL_ACT) {
				state = com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_COMPOSITION_MUTUAL_ACT_RG;
			}			
		}

		ParamsParser.setState(request, Applications.ARENDA, state);
	}
	/**
	 * 
	 * @param request
	 */
	private void initListAccessDocsFromTypeRegistry(HttpServletRequest request, Integer typeRegistryBuchDoc) {
		java.util.List list =
			CDBC_LeaseRegistryBuchDocs_Object.getListComposition(
				getSearchStr(),
				economist,
				null,
				getOrderBy(),
				typeRegistryBuchDoc,
				new Boolean(getIsEconomist()),
				new Boolean(getIsCreatedBy()),
				new Boolean(getIsModifiedBy()),
				getRegionID());
		//setListAccessDocs(list);
		//System.out.println("listAccessDocs.size()=" + list.size());//temp
		request.setAttribute("listAccessDocs", list);
		if(list != null){
			request.setAttribute("listAccessDocsSize", String.valueOf(list.size()));
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 19:04:25)
	 */
	private void operationTask(int typeRegistryBuchDoc, String stateRegistryBuchDoc) {
		//System.out.println("operation=" + operation); //temp
		if ("save".equals(getOperation())) {
			if (typeRegistryBuchDoc == CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF_CWA) {
				//Смешаный тип:
				saveComposition(getSelectIds2(), getIdRegistryDoc(), CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF);
				saveComposition(getSelectIds(), getIdRegistryDoc(), CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_CWA);
			} else {
				//Один тип:
				saveComposition(getSelectIds(), getIdRegistryDoc(), typeRegistryBuchDoc);
			}
			resetMass();
		} else if ("revertStateDocCWA".equals(getOperation())) {
			CDBC_LeaseRegistryBuchDocs_Object.revertStateDoc(Integer.valueOf(getSelectIds()), getStateSelectIds(), stateRegistryBuchDoc, CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_CWA);
			resetMass();
		} else if ("revertStateDocSF".equals(getOperation())) {
			CDBC_LeaseRegistryBuchDocs_Object.revertStateDoc(Integer.valueOf(getSelectIds()), getStateSelectIds(), stateRegistryBuchDoc, CDBC_LeaseRegistryBuchDocs_Object.typeRegistry_SF);
			resetMass();
		}
	}
	/**
	 * 
	 * @param selectIds
	 * @param idRegDoc
	 * @param typeRegDoc
	 */

	private void saveComposition(String selectIds, Integer idRegDoc, int typeRegDoc) {
		CDBC_LeaseRegistryBuchDocs_Object.detachDocs(idRegDoc, typeRegDoc);
		if (!"".equals(selectIds.trim())) {
			CDBC_LeaseRegistryBuchDocs_Object.attachDocs(idRegDoc, selectIds, typeRegDoc);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.12.2005 16:55:36)
	 */
	private void resetMass() {
		setSelectIds("");
		setStateSelectIds("");
		setSelectIds2("");
		setOperation("");
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.12.2005 12:52:49)
	 * @param newOrderBy java.lang.String
	 */
	public void setOrderBy(java.lang.String newOrderBy) {
		orderBy = newOrderBy;
	}
	/**
	 * @return
	 */
	public Integer getEconomist() {
		return economist;
	}

	/**
	 * @return
	 */
	public String getSelectIds() {
		return selectIds;
	}

	/**
	 * @param integer
	 */
	public void setEconomist(Integer integer) {
		economist = integer;
	}

	/**
	 * @param string
	 */
	public void setOperation(java.lang.String string) {
		operation = string;
	}

	/**
	 * @param is
	 */
	public void setSelectIds(String is) {
		selectIds = is;
	}

	/**
	 * @return
	 */
	public Integer getIdRegistryDoc() {
		return idRegistryDoc;
	}

	/**
	 * @param integer
	 */
	public void setIdRegistryDoc(Integer integer) {
		idRegistryDoc = integer;
	}

	/**
	 * @return
	 */
	public LeaseRegistryBuchDocs_TO getTo() {
		return to;
	}

	/**
	 * @param docs_TO
	 */
	private void setTo(LeaseRegistryBuchDocs_TO docs_TO) {
		to = docs_TO;
	}

	private void initLeaseRegistryBuchDocs_TO(Integer id) {
		setTo(CDBC_LeaseRegistryBuchDocs_Object.find(id.intValue()));
	}

	/**
	 * @return
	 */
	public String getSelectIds2() {
		return selectIds2;
	}

	/**
	 * @param string
	 */
	public void setSelectIds2(String string) {
		selectIds2 = string;
	}

	/**
	 * @return
	 */
	public boolean getIsCreatedBy() {
		return isCreatedBy;
	}

	/**
	 * @return
	 */
	public boolean getIsEconomist() {
		return isEconomist;
	}

	/**
	 * @return
	 */
	public boolean getIsModifiedBy() {
		return isModifiedBy;
	}

	/**
	 * @param b
	 */
	public void setIsCreatedBy(boolean b) {
		isCreatedBy = b;
	}

	/**
	 * @param b
	 */
	public void setIsEconomist(boolean b) {
		isEconomist = b;
	}

	/**
	 * @param b
	 */
	public void setIsModifiedBy(boolean b) {
		isModifiedBy = b;
	}

	/**
	 * @return
	 */
	public String getStateSelectIds() {
		return stateSelectIds;
	}

	/**
	 * @param string
	 */
	public void setStateSelectIds(String string) {
		stateSelectIds = string;
	}

	/**
	 * @return
	 */
	public boolean getIsInitialGroup() {
		return isInitialGroup;
	}

	/**
	 * @param b
	 */
	public void setIsInitialGroup(boolean b) {
		isInitialGroup = b;
	}

	/**
	 * @return
	 */
	private Integer getRegionID() {
		return regionID;
	}

	/**
	 * @param integer
	 */
	private void setRegionID(Integer regID) {
		regionID = regID;
	}

	/**
	 * @return
	 */
	public String getSearchStr() {
		return searchStr;
	}

	/**
	 * @param string
	 */
	public void setSearchStr(String string) {
		searchStr = string;
	}

}
