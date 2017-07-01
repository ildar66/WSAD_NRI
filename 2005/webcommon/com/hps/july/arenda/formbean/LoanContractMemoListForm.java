package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.util.*;
/**
 * Form-Bean "лист Служебных записок"
 * Creation date: (22.07.2004 16:28:41)
 * @author: Shafigullin Ildar
 */
public class LoanContractMemoListForm extends BrowseForm {
	private int leaseDocument;
	private java.lang.String sortBy = "date desc"; //признак сортировки
    private LoanContractVO vo;
/**
 * MemoListForm constructor comment.
 */
public LoanContractMemoListForm() {
	super();
	setFinderMethodName("findLoanContractListMemo");
}
/**
 * Для каждой строки броуза можно переопределить возвращаемый объект.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	if (o == null) {
		return o;
	}
	if (!(o instanceof CDBCRowObject)) {
		System.out.println("Memo_LIST: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	return new Memo_VO((CDBCRowObject) o); 
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_Memo_Object"; 
}
/**
 * Возвращает список ролей, которым разрешено редактирование.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
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
 * Creation date: (22.07.2004 18:11:03)
 * @return java.lang.Object[]
 */
public Object[] getFilterParams() {
	return new Object[] {new Integer(getLeaseDocument()), getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 13:28:47)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 14:28:23)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2005 17:47:57)
 * @return com.hps.july.arenda.valueobject.LoanContractVO
 */
public com.hps.july.arenda.valueobject.LoanContractVO getVo() {
	return vo;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.LOAN_CONTRACT_MEMO_LIST);
    vo = com.hps.july.arenda.cdbcobjects.CDBC_LoanContract_Object.find(getLeaseDocument());
    if (vo.getMainpositionVO() == null)
        vo.setMainpositionVO(new StoragePlaceVO(0));
    if (vo.getManagerVO() == null)
        vo.setManagerVO(new WorkerVO(new Integer(0)));
    if (vo.getEconomistVO() == null)
        vo.setEconomistVO(new WorkerVO(new Integer(0)));    
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 13:28:47)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 14:28:23)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2005 17:47:57)
 * @param newVo com.hps.july.arenda.valueobject.LoanContractVO
 */
public void setVo(com.hps.july.arenda.valueobject.LoanContractVO newVo) {
	vo = newVo;
}
}
