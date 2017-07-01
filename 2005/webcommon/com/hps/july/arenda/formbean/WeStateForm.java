package com.hps.july.arenda.formbean;

import com.hps.july.platinum.sessionbean.*;
import com.ibm.ivj.ejb.runtime.*;
import java.util.Enumeration;
import javax.servlet.http.*;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
/**
 * Хранит данные договора(доп. соглашения) аренды.
 * Creation date: (20.07.2002 13:14:54)
 * @author: Sergey Gourov
 */
public class WeStateForm extends StateForm {
	private java.lang.Integer mainDocument;
	protected java.lang.String forMove2pie;
	private java.lang.String orgRateCalcRule;
	private java.lang.Integer cur1code;
	private java.lang.Integer cur2code;
/**
 * Creation date: (07.04.2003 16:59:23)
 */
public WeStateForm() {
	forMove2pie = "westate";
}
/**
 * Вызывается после изменения договора(допсоглашения.)
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	//request.getSession().setAttribute(forMove2pie, new Object[] { new Integer(getLeaseDocument()), getInitialState(), getContractState()});
}
/**
 * Вызывается перед изменением договора(допсоглашения.)
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {
	// Check ratepayrule
	System.out.println("LCONTRACT: #0");
	if (initialState.equals("A") && getContractState().equals("B")) {
		System.out.println("LCONTRACT: #1");
		// Get paymentrules
		boolean isMutualOnly = true;
		Enumeration en = (new LeasePayRuleAccessBean()).findByLeaseDocument(new Integer(getLeaseDocument()), Boolean.FALSE, new Integer(1));
		while (en.hasMoreElements()) {
			System.out.println("LCONTRACT: #2");
			LeasePayRuleAccessBean plbean = (LeasePayRuleAccessBean)en.nextElement();
			// If we have at least one pay by money rule
			if ("P".equals(plbean.getPayType())) {
				System.out.println("LCONTRACT: #3");
				isMutualOnly = false;
				break;
			}
		}

		System.out.println("LCONTRACT: #4");
		if (!isMutualOnly) {
			System.out.println("LCONTRACT: #5");
			// Check calcratetype
			if (getOrgRateCalcRule() == null) {

				System.out.println("LCONTRACT: #6");
				
				// Determine RUR code
				int rurCode = com.hps.july.util.AppUtils.getNamedValueInt("RUR");
				System.out.println("LCONTRACT: #6.1 rurCode=" + rurCode);
	
				// If one of currencies is not RUR then - post error
				boolean isBadCurr = false;

				if  (getCur1code() != null)
					System.out.println("LCONTRACT: #6.2  curr1 = " + getCur1code().intValue());
				if  (getCur2code() != null)
					System.out.println("LCONTRACT: #6.3  curr2 = " + getCur2code().intValue());
					
				if ( (getCur1code() != null) && (getCur1code().intValue() != rurCode) )
					isBadCurr = true;
				if ( (getCur2code() != null) && (getCur2code().intValue() != rurCode) )
					isBadCurr = true;
				if (isBadCurr) {
					System.out.println("LCONTRACT: #7");
					throw new UpdateValidationException("error.invalid.we.nocalcraterule");
				}
			}
		}
	}
}
/**
 * Creation date: (20.11.2003 14:52:35)
 * @return java.lang.Integer
 */
public java.lang.Integer getCur1code() {
	return cur1code;
}
/**
 * Creation date: (20.11.2003 14:52:51)
 * @return java.lang.Integer
 */
public java.lang.Integer getCur2code() {
	return cur2code;
}
/**
 * Creation date: (05.07.2002 14:02:29)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
	bean.setInitKey_leaseDocument(getLeaseDocument());
	try {
		bean.refreshCopyHelper();
		setOrgRateCalcRule(bean.getRatecalcrule());
		if (bean.getCurrency1Key() != null)
			setCur1code(new Integer(bean.getCurrency1Key().currency));
		else
			setCur1code(null);
		if (bean.getCurrency2Key() != null)
			setCur2code(new Integer(bean.getCurrency2Key().currency));
		else
			setCur2code(null);
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return bean;
}
/**
 * Creation date: (19.11.2002 11:53:00)
 * @return java.lang.Integer
 */
public java.lang.Integer getMainDocument() {
	return mainDocument;
}
/**
 * Creation date: (20.11.2003 14:28:02)
 * @return java.lang.String
 */
public java.lang.String getOrgRateCalcRule() {
	return orgRateCalcRule;
}
/**
 * Creation date: (20.07.2002 13:14:54)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.STATE_WEARENDA_EDIT;
}
/**
 * Creation date: (18.11.2002 16:31:14)
 */
public java.util.ArrayList getStateRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	return roles;
}
/**
 * Creation date: (20.11.2003 14:52:35)
 * @param newCur1code java.lang.Integer
 */
public void setCur1code(java.lang.Integer newCur1code) {
	cur1code = newCur1code;
}
/**
 * Creation date: (20.11.2003 14:52:51)
 * @param newCur2code java.lang.Integer
 */
public void setCur2code(java.lang.Integer newCur2code) {
	cur2code = newCur2code;
}
/**
 * Creation date: (19.11.2002 11:53:00)
 * @param newMainDocument java.lang.Integer
 */
public void setMainDocument(java.lang.Integer newMainDocument) {
	mainDocument = newMainDocument;
}
/**
 * Creation date: (20.11.2003 14:28:02)
 * @param newOrgRateCalcRule java.lang.String
 */
public void setOrgRateCalcRule(java.lang.String newOrgRateCalcRule) {
	orgRateCalcRule = newOrgRateCalcRule;
}
/**Перевод состояния у цепочки договоров*/
private void updateContractStateChain(String state, Integer leaseDoc, boolean updateRoot) throws Exception{

	try {
		if(updateRoot){
			LeaseArendaAgreementNewAccessBean root = new LeaseArendaAgreementNewAccessBean();
			root.setInitKey_leaseDocument(leaseDoc.intValue());
			root.refreshCopyHelper();
			root.setContractState(state);
			root.commitCopyHelper();
		}
		Enumeration enum = new LeaseArendaAgreementNewAccessBean().findByQBE2(
			leaseDoc,
			Boolean.FALSE, Boolean.FALSE,
			Boolean.FALSE, null,
			new Integer(1));
		while(enum.hasMoreElements()){
			LeaseArendaAgreementNewAccessBean ab = (LeaseArendaAgreementNewAccessBean)enum.nextElement();
			ab.setContractState(state);
			ab.commitCopyHelper();
			updateContractStateChain(state, new Integer(ab.getLeaseDocument()), false);
		}
	} catch (Exception e) {
		if(!(e instanceof javax.ejb.ObjectNotFoundException)){
			System.out.println("Error in WeStateForm.updateContractStateChain()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
}
/**
 * Проверка данных договора(допсоглашения).
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors, HttpServletRequest request) throws Exception {
	//super.validateValues(errors);

	if (getContractState().equals("B")
		&& !(new LeaseArendaAgreementProcessorAccessBean()).isChangeState(getLeaseDocument())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.notchangestate"));
		//Невозможно перевести договор в состояние исполняется, суммы в договоре и правилах должны совпадать 
	}

	// проверить - не должно быть договоров в состоянии "A" (вводится) при переводе договора в состояние "A"
	if (getContractState().equals("A")
		&& !new LeaseArendaAgreementProcessorAccessBean().isChangeStateToEdit(getLeaseDocument(), true)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.history.haseditcontract"));
		//Нельзя создавать допсоглашение при наличии допсоглашений в состоянии "вводится"
	}
	/*	
		if (initialState.equals("B") && getContractState().equals("A")) {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(getLeaseDocument());
			bean.refreshCopyHelper();
			
			LeaseArendaAgreementProcessorAccessBean laapBean = new LeaseArendaAgreementProcessorAccessBean();
			Enumeration e = new LeaseSaldoAccessBean().findByQBE(
				new Integer(laapBean.getBaseContract(getLeaseDocument())), new Boolean(true), bean.getStartDate(),
				laapBean.getEndDateOfContract(getLeaseDocument()), new Integer(1));
			if (e.hasMoreElements()) {
				
				String[] rolesList = null;
				try {
			    	rolesList = org.apache.struts.util.BeanUtils.getArrayProperty(this, "stateRoles");
			    } catch (Exception ex) {
					ex.printStackTrace(System.out);
				}
				if (rolesList != null) {
					boolean isChange = false;
					
					for (int i = 0; i < rolesList.length; i++) {
						if (request.isUserInRole(rolesList[i])) {
							isChange = true;
							break;
						}
					}
					
					if (!isChange) {
						errors.add(ActionErrors.GLOBAL_ERROR, 
						new ActionError("error.invalid.we.notchangestate.saldo"));
					}
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.notchangestate.saldo"));
				}
			}
			
			/**
			 * Закоментировано на время!
			 * Таким образом вводится возможность изменять договор, до тех пор пока
			 * работники не приведут в порядок все договора введённые (блин!) в обход
			 * системы July в базу данных July
			 *
			 * @TODO: Раскоментировать когда будет нужно
			 */
	/* BEGIN CHECK COMMENT
	e = new LeaseDocPositionAccessBean().findByQBE(
		new Boolean(true), new Integer(laapBean.getBaseContract(getLeaseDocument())),
		new Boolean(true), bean.getStartDate(), laapBean.getEndDateOfContract(getLeaseDocument()), 
		new Boolean(false), null, new Integer(1));
	while (e.hasMoreElements()) {
		LeaseDocPositionAccessBean ldpBean = (LeaseDocPositionAccessBean) e.nextElement();
		if (!"Z".equals(ldpBean.getDocposvid())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.contract.hasdocpositions"));
			//По договору уже есть начисления или платежи
			break;
		}
	}
	  
	}
	END CHECK COMMENT 
	*/
	/*
	if (initialState.equals("A") && getContractState().equals("B") && getMainDocument() == null) {
		Enumeration e = new LeaseChargeRuleAccessBean().findByLeaseDocument(
		new Integer(getLeaseDocument()), new Integer(1));
		while (e.hasMoreElements()) {
			LeaseChargeRuleAccessBean lcrBean = (LeaseChargeRuleAccessBean) e.nextElement();
			
			boolean isError = true;
			Enumeration n = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateAsc(
				new Integer(getLeaseDocument()), new Integer(lcrBean.getResourceKey().resource));
			while (n.hasMoreElements()) {
				LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) n.nextElement();
				if (new LeaseArendaAgreementProcessorAccessBean().isInitialSaldo(
					getLeaseDocument(), lcrBean.getResourceKey().resource, lsBean.getSalDate())) {
					isError = false;
					break;
				}
			}
			
			if (isError) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.notinitialsaldo",
					new Integer(lcrBean.getResourceKey().resource), lcrBean.getResource().getName()));
			}
		}
	}
	*/
	if (initialState.equals("A") && getContractState().equals("B")) {
		if (new ArendaPlatinumProcessorAccessBean().isProcessingEnabled()) {
			try {
				PIEDopInfoContrAccessBean pieBean = new PIEDopInfoContrAccessBean();
				pieBean.setInitKey_leasedocument(new LeaseArendaAgreementProcessorAccessBean().getBaseContract(getLeaseDocument()));
				pieBean.refreshCopyHelper();

				if (pieBean.getVendor() == null
					|| pieBean.getVendor().equals("")
					|| pieBean.getIdbudjet() == null
					|| pieBean.getIdexpense() == null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.contract.pie.notexsist"));
					//Не заданы параметры для Platinum
				}
			} catch (javax.ejb.ObjectNotFoundException e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.contract.pie.notexsist"));
			}
		}
	}
/**
	if (initialState.equals("B") && getContractState().equals("C")) {
		try {
			updateContractStateChain("C", new Integer(getLeaseDocument()), true);
		} catch (Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("label.platinum.flagsync.d"));
		}
	}
	if (initialState.equals("C") && getContractState().equals("B")) {
		try {
			updateContractStateChain("B", new Integer(getLeaseDocument()), true);
		} catch (Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("label.platinum.flagsync.d"));
		}
	}
*/	
	if ((initialState.equals("C") && getContractState().equals("A"))
		|| (initialState.equals("A") && getContractState().equals("C"))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonent.state.invalid"));
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
