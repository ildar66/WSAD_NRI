package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.arenda.cdbcobjects.CDBC_Helper;
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocs_Object;
import com.hps.july.arenda.valueobject.LeaseRegistryBuchDocs_TO;
/**
 * Insert the type's description here.
 * Creation date: (11.11.2005 16:18:55)
 * @author: Shafigullin Ildar
 */
public class RegistryBuchDocsWordForm extends WordForm {
	private int id;
	private LeaseRegistryBuchDocs_TO to;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private Integer economist = null;
	private java.lang.String sortBy = "numberPosition"; //признак сортировки
	private java.lang.String wordView = null; //признак печати(комплектом или простой)
	public final static String wordView_COMPLECT = "complect";
	public final static String wordView_SIMPLE = "simple";
	private LeaseRegistryBuchDocs_TO parent_to;//родитель для возвратной описи. 
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2005 17:30:16)
	 * @return int
	 */
	public int getId() {
		return id;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.11.2005 19:28:08)
	 * @return java.util.Enumeration
	 */
	private void initListPos(HttpServletRequest request) {
		java.util.List list = null;
		try {
			Integer keyRegistryDoc = to.getVo().getIdRegistryDoc();
			Integer typeRegistryDoc = to.getVo().getTypeRegistry();
			list = CDBC_LeaseRegistryBuchDocs_Object.getListComposition(null ,getEconomist(), keyRegistryDoc, getSortBy(), typeRegistryDoc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, null);
			if (wordView_COMPLECT.equalsIgnoreCase(getWordView())) {
				list = CDBC_LeaseRegistryBuchDocs_Object.calcComplectList(list, typeRegistryDoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("listAccessDocs", list);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.11.2005 12:41:31)
	 * @return com.hps.july.arenda.valueobject.LeaseRegistryBuchDocs_TO
	 */
	public com.hps.july.arenda.valueobject.LeaseRegistryBuchDocs_TO getTo() {
		return to;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2005 16:18:55)
	 */
	public void init(HttpServletRequest request) throws Exception {
		to = CDBC_LeaseRegistryBuchDocs_Object.find(getId());
		parent_to = CDBC_LeaseRegistryBuchDocs_Object.findParentTO(to.getVo());
		initListPos(request);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2005 17:30:16)
	 * @param newId int
	 */
	public void setId(int newId) {
		id = newId;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.11.2005 12:41:31)
	 * @param newTo com.hps.july.arenda.valueobject.LeaseRegistryBuchDocs_TO
	 */
	private void setTo(com.hps.july.arenda.valueobject.LeaseRegistryBuchDocs_TO newTo) {
		to = newTo;
	}

	/**
	 * @return
	 */
	public Integer getEconomist() {
		return economist;
	}

	/**
	 * @param integer
	 */
	public void setEconomist(Integer integer) {
		economist = integer;
	}

	/**
	 * @return
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}

	/**
	 * @param string
	 */
	public void setSortBy(java.lang.String string) {
		sortBy = string;
	}

	/**
	 * @return
	 */
	public java.lang.String getWordView() {
		return wordView;
	}

	/**
	 * @param string
	 */
	public void setWordView(java.lang.String string) {
		wordView = string;
	}

	/**
	 * @return
	 */
	public LeaseRegistryBuchDocs_TO getParent_to() {
		return parent_to;
	}

	/**
	 * @param docs_TO
	 */
	private void setParent_to(LeaseRegistryBuchDocs_TO docs_TO) {
		parent_to = docs_TO;
	}

}
