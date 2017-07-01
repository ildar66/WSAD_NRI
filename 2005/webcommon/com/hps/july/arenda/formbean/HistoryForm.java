package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseOnPosition_Object;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.arenda.valueobject.Position_TO;

import org.apache.struts.action.*;
import com.hps.july.commonbean.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.persistence.*;
import com.hps.july.logic.*;
/**
 * "»стори€"
 * Form-Bean.
 * Creation date: (30.07.2002 15:48:23)
 * @author: Sergey Gourov
 */
public class HistoryForm extends WeArendaForm {
	private java.lang.Integer leaseDocumentFromDocument;
/**
 * Insert the method's description here.
 * Creation date: (13.08.2002 17:39:26)
 */
public HistoryForm() {
	super();
	errorEmptyDocNumber = "error.empty.history.docnumber";
}
/**
 * Creation date: (13.02.2002 10:17:44)
 */
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception {
/**
 * признак активносити не может изменитьс€(редактируемое доп.соглашение  не активно)
	if (getMainDocument() != null) {
		new LeaseArendaAgreementProcessorAccessBean().changeActiveDocument(getMainDocument());
	}
*/	
}
/**
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean returnBean = super.constructBean(request);
	//каждое новое доп. соглашение (в отличие от базового) должно быть не активным.
	((LeaseArendaAgreementNewAccessBean)returnBean).setIsActive(new Boolean(false));
	
	LeaseArendaAgreementNewAccessBean bean = DocumentLogic.getActiveDocument(getMainDocument().intValue());
	//признак активности можно изменить только при смене состо€ни€ документа:
	//bean.setIsActive(new Boolean(false));
	//bean.commitCopyHelper();

	// copy chargeRules and payRules
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	Enumeration e = new LeaseChargeRuleAccessBean().findByLeaseDocument(new Integer(bean.getLeaseDocument()), new Integer(1));
	while (e.hasMoreElements()) {
		LeaseChargeRuleAccessBean chargeRuleBean = (LeaseChargeRuleAccessBean) e.nextElement();
	
		LeaseChargeRuleAccessBean newChargeRuleBean = new LeaseChargeRuleAccessBean(
			new Integer(keyGen.getNextKey("tables.leaserules")), // argLeaseRule java.lang.Integer
			new Integer(getLeaseDocument()), // argLeaseDocument java.lang.Integer
			new Integer(chargeRuleBean.getResource().getResource()), // argResource java.lang.Integer
			new Integer(chargeRuleBean.getCurency().getCurrency()), // argCurrency java.lang.Integer
			chargeRuleBean.getSum(), // argSum java.math.BigDecimal
			chargeRuleBean.getChargePeriod(), // argChargePeriod java.lang.String
			chargeRuleBean.getChargeDateRule()); // argChargeDateRule java.lang.String
		newChargeRuleBean.commitCopyHelper();
	}

	e = new LeasePayRuleAccessBean().findByLeaseDocument(new Integer(bean.getLeaseDocument()), new Boolean(false), new Integer(1));
	while (e.hasMoreElements()) {
		LeasePayRuleAccessBean payRuleBean = (LeasePayRuleAccessBean) e.nextElement();

		LeasePayRuleAccessBean newPayRuleBean = new LeasePayRuleAccessBean(
			new Integer(keyGen.getNextKey("tables.leaserules")), // argLeaseRule java.lang.Integer
			new Integer(getLeaseDocument()), // argLeaseDocument java.lang.Integer
			new Integer(payRuleBean.getCurrency().getCurrency()), // argCurrency java.lang.Integer
			payRuleBean.getSum(), // argSum java.math.BigDecimal
			payRuleBean.getPayType()); // argPayType java.lang.String
		if (payRuleBean.getResource() != null) {
			newPayRuleBean.setResource((Resource) payRuleBean.getResource().getEJBRef());
		}
		newPayRuleBean.setPayPeriod(payRuleBean.getPayPeriod());
		if (payRuleBean.getOrgToPay() != null) {
			newPayRuleBean.setOrgToPay((Organization) payRuleBean.getOrgToPay().getEJBRef());
		}
		if (payRuleBean.getOrgAcc() != null) {
			newPayRuleBean.setOrgAcc((Account) payRuleBean.getOrgAcc().getEJBRef());
		}
		newPayRuleBean.setPayBeforeDate(payRuleBean.getPayBeforeDate());
		newPayRuleBean.setPpType(payRuleBean.getPpType());
		newPayRuleBean.setPayPurpose(payRuleBean.getPayPurpose());
		newPayRuleBean.setPayTerms(payRuleBean.getPayTerms());
		newPayRuleBean.setSeparateNdsPay(payRuleBean.getSeparateNdsPay());
		newPayRuleBean.commitCopyHelper();
	}
	
	return returnBean;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:06:43)
 * @return java.util.Enumeration

public java.util.Enumeration getCustomers() {
	try {
		return new OrganizationAccessBean().findOurOrganizations();
	} catch (Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();	
	}
}
*/
/**
 * Insert the method's description here.
 * Creation date: (01.08.2002 20:21:57)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseDocumentFromDocument() {
	return leaseDocumentFromDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2002 15:48:23)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.HISTORY_FORM;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    HistoryListForm form = (HistoryListForm) request.getSession().getAttribute("HistoryListForm");
    setMainDocument(new Integer(form.getMainDocumentcode()));

    LeaseArendaAgreementNewAccessBean leaseBean = new LeaseArendaAgreementNewAccessBean();
    leaseBean.setInitKey_leaseDocument(getMainDocument().intValue());
    leaseBean.refreshCopyHelper();

    setMainDocumentDate(leaseBean.getDocumentDate());
    setMainDocumentNumber(leaseBean.getDocumentNumber());
    if (leaseBean.getEconomist() != null) {
        setEconomistcode(new Integer(leaseBean.getEconomistKey().worker));
        setEconomistname(leaseBean.getEconomist().getMan().getFullName());
    }

    setOrgCustomercode(form.getCustomercode());
    setOrgExecutorcode(form.getExecutorcode());
    OrganizationNfsAccessBean bean = new OrganizationNfsAccessBean();
    bean.setInitKey_organization(getOrgExecutorcode().intValue());
    bean.refreshCopyHelper();
    setOrgExecutorname(bean.getName());

    setLeaseDocumentFromDocument(new Integer(form.getLeaseDocument()));

    //поиск активного документа:
    int mainDocument = new LeaseArendaAgreementProcessorAccessBean().getBaseContract(form.getLeaseDocument());
    LeaseArendaAgreementNewAccessBean activeDoc = DocumentLogic.getActiveDocument(leaseBean, new Integer(mainDocument));

    setCalcElectroType(activeDoc.getCalcElectroType());
    setContractState("A");
    setContractType(activeDoc.getContractType());

    setDocumentDate(null);
    setDocumentNumber("");

    setEndDate(activeDoc.getEndDate());
    setBaseenddate(activeDoc.getEndDate());

    //устанавливаем главную позицию:
    PositionAccessBean mainPos = activeDoc.getMainposition();
    if (mainPos != null) {
        setPositionname(com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(mainPos));
        setPosition(new Integer(mainPos.getStorageplace()));
    } else {
        setPosition(null);
        setPositionname(null);
    }
    //инициализируем отв. менеджера:
    setManager(leaseBean.getManager());

    setExtendType(activeDoc.getExtendType());
    //если период продлени€ у активного документа "null", то устанавливаем в "год"
    //String extPeriod = (activeDoc.getExtendPeriod()==null)?"Y":activeDoc.getExtendPeriod();
    //setExtendPeriod(extPeriod);
	setExtenddays(activeDoc.getExtenddays());
	setExtendmonthes(activeDoc.getExtendmonthes());
	setExtendyears(activeDoc.getExtendyears());
    //setExtendPeriod(activeDoc.getExtendPeriod());
    //setHowGivePhones(activeDoc.getHowGivePhones());
    setIsDogElectro(activeDoc.getIsDogElectro());
    setDogelectonum(activeDoc.getDogelectonum());
    setDogelectrodate(activeDoc.getDogelectrodate());

    setNumberOfPhones(activeDoc.getNumberOfPhones());

    setReportPeriod(activeDoc.getReportPeriod());
    setStartDate(null); // activeDoc.getStartDate()

    setCurrencycode1(new Integer(activeDoc.getCurrency1().getCurrency()));

    if (activeDoc.getCurrency2() != null) {
        setCurrencycode2(new Integer(activeDoc.getCurrency2().getCurrency()));
        setIsSumm2(new Boolean(true));
    } else {
        setCurrencycode2(null);
        setIsSumm2(new Boolean(false));
    }

    setSumm1(activeDoc.getSumm1());
    setSumm2(activeDoc.getSumm2());
    setIsDocumentText(new Boolean(false));
    setDocFileName(null);

    setRatecalcrule(activeDoc.getRatecalcrule());
    setRatecalcruleday(activeDoc.getRatecalcruleday());
    setRatedelta(activeDoc.getRatedelta());

    LeaseContractBLOBAccessBean beanBlob = new LeaseContractBLOBAccessBean();
    beanBlob.setInitKey_leaseDocument(activeDoc.getLeaseDocument());
    beanBlob.refreshCopyHelper();

    setComment(beanBlob.getComment());
    setSubject(beanBlob.getSubject());
    setChangeenddate("H");
    //инициализаци€ "–егистраци€ договора в гос.органах":
    setNeedofficialdoc(false);
    setOfficialdoc(false);
	//инициализаци€ јкта приема-передачи:
	setHaveioact(leaseBean.getHaveioact());
	setIoactnumber(leaseBean.getIoactnumber());
	setIoactdate(leaseBean.getIoactdate());
	//инициализаци€ "признак Ќалоговый агент" и "—тавка Ќƒ—":
	setNalogAgent(activeDoc.getNalogAgent());
	setRateNDS(activeDoc.getRateNDS());
	setChargeNds(activeDoc.getChargeNds());
	/**инициализаци€ настройки по регионам*/
	setBuchdocnumber("");//Ќомер договора в системе бух учета
	setHavedocsigned(Boolean.FALSE);//” нас есть подписанный договор
	setHavedocsignedcustomer(Boolean.FALSE);//” заказчика есть подписанный договор
	setCreated(new java.sql.Timestamp(System.currentTimeMillis()));//дата создани€ договора		
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2002 20:21:57)
 * @param newLeaseDocumentFromDocument java.lang.Integer
 */
public void setLeaseDocumentFromDocument(java.lang.Integer newLeaseDocumentFromDocument) {
	leaseDocumentFromDocument = newLeaseDocumentFromDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	// проверить - при добавлении не должно быть договоров в состо€нии "A" (вводитс€)

	if (getAction().equals("Add")) {
		if (!new LeaseArendaAgreementProcessorAccessBean().isChangeStateToEdit(getMainDocument().intValue(), false)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.history.haseditcontract"));
		}
	}
	
	super.validateValues(errors);
}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#afterUpdate(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean, javax.servlet.http.HttpServletRequest)
	 */
	public void afterUpdate(AbstractEntityAccessBean bean, HttpServletRequest request) throws Exception {
		super.afterUpdate(bean, request);
		if (this.getAction().equals("Add")) {
			addListPositionFromActiveDocument(bean);
		}
	}
	/**
	 * ѕри создании доп.соглашени€ добавл€ем список позиций из активного договора
	 * @param bean
	 */
	private void addListPositionFromActiveDocument(AbstractEntityAccessBean bean){
		try {
			LeaseArendaAgreementNewAccessBean activeDoc = DocumentLogic.getActiveDocument(getLeaseDocument());
			List listPosition = CDBC_LeaseOnPosition_Object.findPositionsByLeaseArendaAgreementNew(new Integer(activeDoc.getLeaseDocument()), null);
			for (Iterator iter = listPosition.iterator(); iter.hasNext();) {
				Position_TO position_TO = (Position_TO) iter.next();
				int positionCurent = position_TO.getVo().getStorageplace();
				// ¬ключает позицию в доп.соглашение по указанному leaseDocument и position кроме главной:
				try {
					if( getPosition() != null){
						if( positionCurent != getPosition().intValue() ){
							LeaseOnPositionAccessBean lopBean = new LeaseOnPositionAccessBean(new Integer(getLeaseDocument()), new Integer(positionCurent));
						}
					}else{
						LeaseOnPositionAccessBean lopBean = new LeaseOnPositionAccessBean(new Integer(getLeaseDocument()), new Integer(positionCurent));
					}
				} catch (Exception e) {
					System.out.println(
						"HistoryForm.addListPositionFromActiveDocument() : Can't create leaseOnPositions(" + getLeaseDocument() + "," + positionCurent + ")");
					e.printStackTrace(System.out);
				}
			}
		} catch (Exception e) {
			System.out.println(
				"HistoryForm.addListPositionFromActiveDocument() : Can't create listPositions");
			e.printStackTrace(System.out);
		}
	}

}
