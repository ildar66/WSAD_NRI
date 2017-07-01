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
public class MemoListForm extends BrowseForm {
	private int leaseDocument;
	private java.lang.String sortBy = "date desc"; //признак сортировки
	private LeaseAbonentBAN_VO abonent;
/**
 * MemoListForm constructor comment.
 */
public MemoListForm() {
	super();
	setFinderMethodName("findListMemo");
	init();
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2004 16:32:25)
 */
private void clearAllParams() {
	init();
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
 * Insert the method's description here.
 * Creation date: (23.07.2004 15:24:03)
 * @return com.hps.july.arenda.valueobject.LeaseAbonentBAN_VO
 */
public com.hps.july.arenda.valueobject.LeaseAbonentBAN_VO getAbonent() {
	return abonent;
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
private void init() {
	abonent = new LeaseAbonentBAN_VO();
	abonent.setOrgCustomer(new OrganizationVO());
	abonent.setOrgExecutor(new OrganizationVO());
	abonent.setMainpositionVO(new StoragePlaceVO());
	abonent.setManagerVO(new WorkerVO());
	abonent.setEconomistVO(new WorkerVO());
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(
    ActionMapping mapping,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.MEMO_LIST);

    try {
        init();
        LeaseAbonentBANAccessBean leaseban = new LeaseAbonentBANAccessBean();
        leaseban.setInitKey_leaseDocument(leaseDocument);
        leaseban.refreshCopyHelper();
       //BeanUtils.copyProperties(this.getAbonent(), leaseban);        
        this.getAbonent().setLeaseDocument(new Integer(leaseDocument));
        this.getAbonent().setDocnumber(leaseban.getDocumentNumber());
        this.getAbonent().setDocdate(leaseban.getDocumentDate());
        this.getAbonent().setBan(leaseban.getBan());

         //OrgCustomer:
        if (leaseban.getOrgCustomer() != null) {
            int key = leaseban.getOrgCustomer().getOrganization();
            OrganizationVO orgCustomer = new OrganizationVO(new Integer(key));
            orgCustomer.setName(leaseban.getOrgCustomer().getName());
            abonent.setOrgCustomer(orgCustomer);
        }
        /**
        		//OrgExecutor:	
        		if (leaseban.getOrgExecutor() != null) {
        			int key = leaseban.getOrgExecutor().getOrganization();
        			OrganizationVO orgExecutor = new OrganizationVO(new Integer(key));
        			orgExecutor.setName(leaseban.getOrgExecutor().getName());
        			abonent.setOrgExecutor(orgExecutor);
        		}
        */
        //Mainposition:
        if (leaseban.getMainposition() != null) {
            int key = leaseban.getMainposition().intValue();
            PositionAccessBean mainPosAB = new PositionAccessBean();
            mainPosAB.setInitKey_storageplace(key);
            mainPosAB.refreshCopyHelper();
            StoragePlaceVO mainPosVO = new StoragePlaceVO(key);
            mainPosVO.setName(mainPosAB.getName());
            String fullName =
                com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(
                    mainPosAB);
            mainPosVO.setFullName(fullName);
            abonent.setMainpositionVO(mainPosVO);
        }
        /**		
        		//Economist:
        		if (leaseban.getEconomist() != null) {
        			int key = leaseban.getEconomist().getWorker();
        			WorkerVO economist = new WorkerVO(new Integer(key));
        			economist.setName(leaseban.getEconomist().getMan().getFullName());
        			abonent.setEconomistVO(economist);
        		}
        		//Manager:
        		if (leaseban.getManager() != null) {
        			int key = leaseban.getManager().getWorker();
        			WorkerVO manager = new WorkerVO(new Integer(key));
        			manager.setName(leaseban.getManager().getMan().getFullName());
        			abonent.setManagerVO(manager);
        		}
        */
    } catch (Exception e) {
        e.printStackTrace(System.out);
        clearAllParams();
    }

    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 15:24:03)
 * @param newAbonent com.hps.july.arenda.valueobject.LeaseAbonentBAN_VO
 */
public void setAbonent(com.hps.july.arenda.valueobject.LeaseAbonentBAN_VO newAbonent) {
	abonent = newAbonent;
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
}
