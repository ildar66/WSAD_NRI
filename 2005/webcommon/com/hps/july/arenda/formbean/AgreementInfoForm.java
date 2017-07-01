package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.persistence.*;
/**
 * Form-Bean
 * »нформаци€ о доп. соглашени€х договоров аренды.
 * Creation date: (31.03.2004 17:35:17)
 * @author: Shafigullin Ildar
 */
public class AgreementInfoForm extends WeArendaForm {
	private String mainOrgExecutorName;
	private String mainOrgCustomerName;
	private java.sql.Date mainStartDate;
	private String mainEconomistName;
	private String mainManagerName;
/**
 * AgreementInfoForm constructor
 */
public AgreementInfoForm() {
	super();
}
/**
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
    LeaseArendaAgreementNewAccessBean activeBean = (LeaseArendaAgreementNewAccessBean) bean;
    if (getMainDocument() != null) {
        //заполнение формы данными из базового:
        try {
            LeaseArendaAgreementNewAccessBean mainBean = new LeaseArendaAgreementNewAccessBean();
            mainBean.setInitKey_leaseDocument(getMainDocument().intValue());
            mainBean.refreshCopyHelper();
            setMainParams(mainBean);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else {
        //активный сам €вл€етс€ базовым:
        try {
            setMainParams(activeBean);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //"ѕредмет договора" и " омментарий к договору" из активного.
    LeaseContractBLOBAccessBean beanBLOB = new LeaseContractBLOBAccessBean();
    beanBLOB.setInitKey_leaseDocument(getLeaseDocument());
    try {
        setComment(beanBLOB.getComment());
        setSubject(beanBLOB.getSubject());
    } catch (Exception e) {
        e.printStackTrace();
        setComment("");
        setSubject("");
    }
}
/**
 * –оли, которым разрешено смотреть суммы аренды.
 * Creation date: (17.04.2004 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getArendaMoneyRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("ArendaEconomist");
	roles.add("ArendaManager");
	roles.add("ArendaMainEconomist");
	roles.add("ArendaMainManager");
	roles.add("ArendaDirector");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2004 17:32:48)
 * @return java.lang.String
 */
public java.lang.String getMainEconomistName() {
	return mainEconomistName;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2004 17:32:48)
 * @return java.lang.String
 */
public java.lang.String getMainManagerName() {
	return mainManagerName;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2004 17:32:48)
 * @return java.lang.String
 */
public java.lang.String getMainOrgCustomerName() {
	return mainOrgCustomerName;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2004 17:32:48)
 * @return java.lang.String
 */
public java.lang.String getMainOrgExecutorName() {
	return mainOrgExecutorName;
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2004 17:32:48)
 * @return java.sql.Date
 */
public java.sql.Date getMainStartDate() {
	return mainStartDate;
}
	/**
	 * Creation date: (27.06.2002 17:40:14)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.AGREEMENT_INFO;
	}
/**
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    /**
     *правила оплаты договора:
   :*/
    java.util.Enumeration e =
        new LeasePayRuleAccessBean().findByLeaseDocument(new Integer(getLeaseDocument()), new Boolean(false), new Integer(1));
    if (e.hasMoreElements()) {
        request.setAttribute("payrulesList", e);
    }
}
/**
 * Creation date: (05.04.2004 11:28:30)
 * @param mainEconomist com.hps.july.persistence.WorkerAccessBean
 * @exception java.lang.Exception The exception description.
 */
private void setMainEconomist(WorkerAccessBean mainEconomist) throws java.lang.Exception {
	if (mainEconomist != null)
		setMainEconomistName(mainEconomist.getMan().getFullName());
	else
		setMainEconomistName(null);
}
/**
 * Creation date: (02.04.2004 17:32:48)
 * @param newMainEconomistName java.lang.String
 */
private void setMainEconomistName(java.lang.String newMainEconomistName) {
	mainEconomistName = newMainEconomistName;
}
/**
 * Creation date: (05.04.2004 11:21:12)
 */
private void setMainManager(WorkerAccessBean mainManager) throws Exception {
	if (mainManager != null)
		setMainManagerName(mainManager.getMan().getFullName());
	else
		setMainManagerName(null);
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2004 17:32:48)
 * @param newMainManagerName java.lang.String
 */
private void setMainManagerName(java.lang.String newMainManagerName) {
	mainManagerName = newMainManagerName;
}
/**
 * Creation date: (05.04.2004 11:37:10)
 * @param mainOrgCustomer com.hps.july.persistence.OrganizationNfsAccessBean
 * @exception java.lang.Exception The exception description.
 */
private void setMainOrgCustomer(OrganizationNfsAccessBean mainOrgCustomer) throws java.lang.Exception {
	if (mainOrgCustomer != null)
		setMainOrgCustomerName(mainOrgCustomer.getName());
	else
		setMainOrgCustomerName(null);
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2004 17:32:48)
 * @param newMainOrgCustomerName java.lang.String
 */
private void setMainOrgCustomerName(java.lang.String newMainOrgCustomerName) {
	mainOrgCustomerName = newMainOrgCustomerName;
}
/**
 * Creation date: (05.04.2004 11:37:10)
 * @param mainOrgExecutor com.hps.july.persistence.OrganizationNfsAccessBean
 * @exception java.lang.Exception The exception description.
 */
private void setMainOrgExecutor(OrganizationNfsAccessBean mainOrgExecutor) throws java.lang.Exception {
	if (mainOrgExecutor != null)
		setMainOrgExecutorName(mainOrgExecutor.getName());
	else
		setMainOrgExecutorName(null);
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2004 17:32:48)
 * @param newMainOrgExecutorName java.lang.String
 */
private void setMainOrgExecutorName(java.lang.String newMainOrgExecutorName) {
	mainOrgExecutorName = newMainOrgExecutorName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.02.2005 11:34:18)
 * @param mainBean com.hps.july.persistence.LeaseArendaAgreementNewAccessBean
 */
private void setMainParams(LeaseArendaAgreementNewAccessBean mainBean) throws Exception{
    setMainDocumentDate(mainBean.getDocumentDate()); //дата договора
    setMainDocumentNumber(mainBean.getDocumentNumber()); //номер договора
    setMainOrgExecutor(mainBean.getOrgExecutor()); //арендодатель
    setMainOrgCustomer(mainBean.getOrgCustomer()); //заказчик
    setMainStartDate(mainBean.getStartDate()); //дата начала действи€
    setMainEconomist(mainBean.getEconomist()); //отв. экономист
    setMainManager(mainBean.getManager()); //отв. менежер
    setMainPosition(mainBean.getMainposition()); //главна€ позици€
}
/**
 * главна€ позици€
 * Creation date: (02.04.2004 17:42:53)
 */
private void setMainPosition(PositionAccessBean mainPos) throws Exception {
	if (mainPos != null) {
		setPositionname(com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(mainPos));
		setPosition(new Integer(mainPos.getStorageplace()));
	} else {
		setPosition(null);
		setPositionname(null);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.04.2004 17:32:48)
 * @param newMainStartDate java.sql.Date
 */
private void setMainStartDate(java.sql.Date newMainStartDate) {
	mainStartDate = newMainStartDate;
}
}
