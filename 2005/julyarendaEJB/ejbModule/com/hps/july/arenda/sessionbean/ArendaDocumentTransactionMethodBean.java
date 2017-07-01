package com.hps.july.arenda.sessionbean;

import com.hps.july.commonbean.*;
import java.math.*;
import com.hps.july.persistence.*;
import java.util.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import java.sql.Date;
/**
 * This is a Session Bean Class
 * Вспомогательные расчеты по аренде, проводимые в транзакции
 */
public class ArendaDocumentTransactionMethodBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 18:08:03)
 * @return java.math.BigDecimal
 * @param resource java.lang.Integer
 * @param localDate java.sql.Date
 * @param localSum java.sql.Date
 * @param typeCalc java.lang.String
 */

/*
 * параметр typeCalc:
 *     1 - НДС включен в сумму
 *     2 - НДС НЕ включен в сумму
 *     other - ошибка
 */ 
public BigDecimal calcNds(Integer resource, Date localDate, BigDecimal localSum, String typeCalc) throws java.rmi.RemoteException {
	try {
		BigDecimal rateNds = null;
		
		Enumeration taxes = new ResourceTaxeAccessBean().findByResourceOrderByDateDesc(resource);
		while (taxes.hasMoreElements()) {
			ResourceTaxeAccessBean taxBean = (ResourceTaxeAccessBean) taxes.nextElement();
			if (taxBean.getDate().compareTo(localDate) <= 0) {
				rateNds = taxBean.getNds();
				break;
			}
		}
		
		if (rateNds == null) {
			return null;
		}
		
		if (typeCalc.equals("1")) {
			return (localSum.multiply(rateNds)).divide(rateNds.add(new BigDecimal(100)), 2, BigDecimal.ROUND_HALF_UP);
		} else if (typeCalc.equals("2")) {
			return (localSum.multiply(rateNds)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
		}
		
		return null;
	} catch (Exception e) {
		e.printStackTrace();
		throw new java.rmi.RemoteException("While calc nds", e);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 16:51:19)
 * @param baseContract java.lang.Integer
 * @param resource java.lang.Integer
 * @param dateStart java.sql.Date
 * @param dateFinish java.sql.Date
 */
private boolean clearCharges(Integer baseContract, Integer resource, Date dateStart, Date dateFinish, int codeTask) throws Exception {
	Enumeration e = new LeaseChargesAccessBean().findByQBE3(baseContract, resource, dateStart, dateFinish);
	while (e.hasMoreElements()) {
		LeaseChargesAccessBean bean = (LeaseChargesAccessBean) e.nextElement();
		if (bean.getDate().compareTo(dateStart) < 0) {
			new JournalAccessBean().addMsgInJournal(27, "W", -1, -1, bean.getLeaseDocPosition(), -1, null, null, null, null,
				-1, -1, -1, -1, codeTask);
			return false;
		}
		if (bean.getSource().equals("M")) {
			new JournalAccessBean().addMsgInJournal(28, "W", -1, -1, bean.getLeaseDocPosition(), -1, null, null, null, null,
				-1, -1, -1, -1, codeTask);
			return false;
		}
		Enumeration ednop = new LeaseDNOPAccessBean().findLeaseDNOPByLeaseCharge(new LeaseDocPositionKey(bean.getLeaseDocPosition()));
		if (ednop.hasMoreElements()) {
			new JournalAccessBean().addMsgInJournal(29, "W", -1, -1, bean.getLeaseDocPosition(), -1, null, null, null, null,
				-1, -1, -1, -1, codeTask);
			return false;
		}
		bean.getEJBRef().remove();
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2002 13:23:45)
 * @param baseContract java.lang.Integer
 * @param resource java.lang.Integer
 * @param dateStart java.sql.Date
 * @param dateFinish java.sql.Date
 */
private boolean clearPayments(Integer baseContract, Integer resource, Date dateStart, Date dateFinish, int codeTask) throws Exception {
	Enumeration e = new LeasePaymentAccessBean().findByQBE3(baseContract, resource, dateStart, dateFinish);
	while (e.hasMoreElements()) {
		LeasePaymentAccessBean bean = (LeasePaymentAccessBean) e.nextElement();
		if (!bean.getPaymentstate().equals("G")) {
			new JournalAccessBean().addMsgInJournal(67, "W", -1, -1, bean.getLeaseDocPosition(), -1, null, null, null, null,
				-1, -1, -1, -1, codeTask);
			return false;
		}
		bean.getEJBRef().remove();
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 16:29:17)
 * @return java.sql.Date
 * @param startSubInterval java.sql.Date
 * @param finishSubInterval java.sql.Date
 * @param chargeDateRule java.lang.String
 */
private Date defineDateCharge(java.util.Date startSubInterval, java.util.Date finishSubInterval, String chargeDateRule) {
	if (chargeDateRule.equals("S")) {
		return new Date(startSubInterval.getTime());
	} else if (chargeDateRule.equals("E")) {
		return new Date(finishSubInterval.getTime());
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2002 10:45:53)
 * @return java.sql.Date
 * @param startSubInterval java.sql.Date
 * @param finishSubInterval java.sql.Date
 * @param ppType java.lang.String
 * @param payBeforeDate java.lang.Short
 * @param dateSaldo java.sql.Date
 */
private Date defineDatePayment(java.util.Date startSubInterval, java.util.Date finishSubInterval, String ppType, short payBeforeDate, java.util.Date dateSaldo, int[] base) throws Exception {
	GregorianCalendar datePay = new GregorianCalendar();
	
	if (ppType.equals("A")) {
		datePay.setTime(startSubInterval);
	} else if (ppType.equals("C")) {
		datePay.setTime(finishSubInterval);
	} else {
		new JournalAccessBean().addMsgInJournal(68, "E", /*chargeRuleBean.getLeaseRule()*/ base[0], /*laanBean.getLeaseDocument()*/ base[1],
			-1, -1, null, null, null, null, -1, -1, -1, -1, base[2]);
		return null;
	}
	
	datePay.add(Calendar.DAY_OF_MONTH, -payBeforeDate);
	if (datePay.getTime().compareTo(dateSaldo) >= 0) {
		new JournalAccessBean().addMsgInJournal(69, "W", /*chargeRuleBean.getLeaseRule()*/ base[0], /*laanBean.getLeaseDocument()*/ base[1],
			-1, -1, null, null, null, null, -1, -1, -1, -1, base[2]);
		datePay.add(Calendar.DAY_OF_MONTH, 1);
	}
	
	return new Date(datePay.getTime().getTime());
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 13:03:07)
 * @return java.math.BigDecimal
 * @param startSubInterval java.sql.Date
 * @param finishSubInterval java.sql.Date
 * @param chargePeriod java.lang.String
 * @param summ java.math.BigDecimal
 */
private BigDecimal defineSumCharge(java.util.Date startSubInterval, java.util.Date finishSubInterval, java.util.Date startPeriod, java.util.Date finishPeriod, String chargePeriod, BigDecimal summ) {
	// сумма правила за период
	BigDecimal sumPeriod = new BigDecimal(0);
	if (chargePeriod.equals("M")) {
		sumPeriod = summ.divide(new BigDecimal(12), BigDecimal.ROUND_HALF_UP);
	} else if (chargePeriod.equals("Q")) {
		sumPeriod = summ.divide(new BigDecimal(4), BigDecimal.ROUND_HALF_UP);
	} else if (chargePeriod.equals("Y")) {
		// уже сумма за год
		sumPeriod = summ;
	} else {
		return null;
	}
	
	BigDecimal sumToBe = sumPeriod.multiply(new BigDecimal(
		((double) (finishSubInterval.getTime() - startSubInterval.getTime())) / 
		(finishPeriod.getTime() - startPeriod.getTime())));
	return sumToBe.setScale(2, BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 13:03:07)
 * @return java.math.BigDecimal
 * @param startSubInterval java.sql.Date
 * @param finishSubInterval java.sql.Date
 * @param chargePeriod java.lang.String
 * @param summ java.math.BigDecimal
 */
private BigDecimal defineSumPayment(java.util.Date startSubInterval, java.util.Date finishSubInterval, java.util.Date startPeriod, java.util.Date finishPeriod, String payPeriod, BigDecimal summ) {
	// сумма правила за период
	BigDecimal sumPeriod = new BigDecimal(0);
	if (payPeriod.equals("M")) {
		sumPeriod = summ.divide(new BigDecimal(12), BigDecimal.ROUND_HALF_UP);
	} else if (payPeriod.equals("Q")) {
		sumPeriod = summ.divide(new BigDecimal(4), BigDecimal.ROUND_HALF_UP);
	} else {
		return null;
	}
	
	BigDecimal sumToBe = sumPeriod.multiply(new BigDecimal(
		((double) (finishSubInterval.getTime() - startSubInterval.getTime())) / 
		(finishPeriod.getTime() - startPeriod.getTime())));
	return sumToBe.setScale(2, BigDecimal.ROUND_HALF_UP);
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 11:33:44)
 * @param dateFinish java.sql.Date
 * @param baseContract java.lang.Integer
 */
public void makeAutoChargeOneContract(Date dateFinish, Integer baseContract, int codeTask) throws Exception {
	try {
		Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(baseContract, new Boolean(false), null, 
			new Boolean(true), "B", new Integer(1));
		
		Vector v = new Vector();
		while (e.hasMoreElements()) {
			LeaseArendaAgreementNewAccessBean leaseBean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			v.addElement(new Integer(leaseBean.getLeaseDocument()));
		}
		
		LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
		laanBean.setInitKey_leaseDocument(baseContract.intValue());
		laanBean.refreshCopyHelper();
		v.add(0, new Integer(laanBean.getLeaseDocument()));
		
		e = new ResourceAccessBean().findResourcesByLeaseChargeRules(v); // определение уникального списка ресурсов из правил начислений договоров
		while (e.hasMoreElements()) {
			GregorianCalendar dateStart = new GregorianCalendar();
			Integer resource = new Integer(((ResourceAccessBean) e.nextElement()).getResource());
			
			Enumeration t = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(baseContract, resource);
			if (t.hasMoreElements()) {
				dateStart.setTime(((LeaseSaldoAccessBean) t.nextElement()).getSalDate());
			} else {
				// нет сальдо, что делаем? следующий ресурс... (+message)
				new JournalAccessBean().addMsgInJournal(26, "W", -1, baseContract.intValue(), -1, -1, null, null, null, null,
					-1, -1, resource.intValue(), -1, codeTask);
				continue;
			}
			
			dateStart.add(Calendar.DAY_OF_MONTH, 1);
			if (!clearCharges(baseContract, resource, new Date(dateStart.getTime().getTime()), dateFinish, codeTask)) {
				continue;
			}
			
			// цикл по договорам
			for (int i = 0; i < v.size(); i++) {
				laanBean = new LeaseArendaAgreementNewAccessBean();
				laanBean.setInitKey_leaseDocument(((Integer) v.elementAt(i)).intValue());
				laanBean.refreshCopyHelper();
				
				if (dateStart.getTime().compareTo(laanBean.getStartDate()) <= 0) {
					// получен период, разбиваем на подинтервалы
					GregorianCalendar startInterval = new GregorianCalendar();
					startInterval.setTime(dateStart.getTime());
					GregorianCalendar finishInterval = new GregorianCalendar();
					finishInterval.setTime(laanBean.getStartDate());
					finishInterval.add(Calendar.DAY_OF_MONTH, -1);
					if (finishInterval.getTime().compareTo(dateFinish) > 0) {
						finishInterval.setTime(dateFinish); // last period
					}
					
					Enumeration chargeRules = new LeaseChargeRuleAccessBean().findByLeaseDocument(
						new Integer(laanBean.getLeaseDocument()), new Integer(1));
					while (chargeRules.hasMoreElements()) {
						LeaseChargeRuleAccessBean chargeRuleBean = (LeaseChargeRuleAccessBean) chargeRules.nextElement();
						GregorianCalendar startSubInterval = new GregorianCalendar();
						startSubInterval.setTime(startInterval.getTime());
						
						while (true) {
							
							GregorianCalendar beginPeriod = new GregorianCalendar();
							beginPeriod.setTime(startSubInterval.getTime());
							GregorianCalendar endPeriod = new GregorianCalendar();
							endPeriod.setTime(startSubInterval.getTime());
							
							if (chargeRuleBean.getChargePeriod().equals("M")) {
								
								beginPeriod.set(Calendar.DAY_OF_MONTH, beginPeriod.getActualMinimum(Calendar.DAY_OF_MONTH));
								endPeriod.set(Calendar.DAY_OF_MONTH, endPeriod.getActualMaximum(Calendar.DAY_OF_MONTH));
								
							} else if (chargeRuleBean.getChargePeriod().equals("Q")) {
								
								GregorianCalendar quarter = new GregorianCalendar();
								quarter.clear();
								quarter.set(beginPeriod.get(Calendar.YEAR), 3, 1);
								while (beginPeriod.getTime().compareTo(quarter.getTime()) >= 0) {
									quarter.add(Calendar.MONTH, 3);
								}
								
								quarter.add(Calendar.DAY_OF_MONTH, -1);
								endPeriod.setTime(quarter.getTime());
								quarter.add(Calendar.DAY_OF_MONTH, 1);
								quarter.add(Calendar.MONTH, -3);
								beginPeriod.setTime(quarter.getTime());
								
							} else if (chargeRuleBean.getChargePeriod().equals("Y")) {
							
								beginPeriod.set(Calendar.MONTH, Calendar.JANUARY);
								beginPeriod.set(Calendar.DAY_OF_MONTH, beginPeriod.getActualMinimum(Calendar.DAY_OF_MONTH));
								endPeriod.set(Calendar.MONTH, Calendar.DECEMBER);
								endPeriod.set(Calendar.DAY_OF_MONTH, endPeriod.getActualMaximum(Calendar.DAY_OF_MONTH));
								
							}
							
							GregorianCalendar finishSubInterval = new GregorianCalendar();
							finishSubInterval.setTime(endPeriod.getTime());
							
							//new java.sql.Date(endPeriod.getTime().getTime());
							if (finishSubInterval.getTime().compareTo(finishInterval.getTime()) > 0) {
								finishSubInterval.setTime(finishInterval.getTime()); // и это последний период
							}
							
							// получен период от beginDate до endDate!!!
							
							BigDecimal sumCharge = defineSumCharge(startSubInterval.getTime(), finishSubInterval.getTime(),
								beginPeriod.getTime(), endPeriod.getTime(), chargeRuleBean.getChargePeriod(), chargeRuleBean.getSum());
							if (sumCharge != null) {
								Date dateCharge = defineDateCharge(startSubInterval.getTime(), finishSubInterval.getTime(), chargeRuleBean.getChargeDateRule());
								if (dateCharge != null) {
									BigDecimal nds = calcNds(new Integer(chargeRuleBean.getResource().getResource()), dateCharge, new BigDecimal(0), "1");
									if (nds != null) {
										// create new charge!
										makeNewCharge(dateCharge,
											new Integer(new LeaseArendaAgreementProcessorAccessBean().getBaseContract(laanBean.getLeaseDocument())),
											new Date(startSubInterval.getTime().getTime()),
											new Date(finishSubInterval.getTime().getTime()),
											new Integer(chargeRuleBean.getResource().getResource()),
											sumCharge, new Integer(chargeRuleBean.getCurency().getCurrency()),
											nds, new Integer(chargeRuleBean.getLeaseRule()));
									} else {
										new JournalAccessBean().addMsgInJournal(31, "E", -1, laanBean.getLeaseDocument(),
											-1, -1, dateCharge, null, null, null, -1, -1, chargeRuleBean.getResource().getResource(), -1, codeTask);
									}
								} else {
									new JournalAccessBean().addMsgInJournal(30, "E", chargeRuleBean.getLeaseRule(), laanBean.getLeaseDocument(),
										-1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
								}
							} else {
								new JournalAccessBean().addMsgInJournal(23, "E", chargeRuleBean.getLeaseRule(), laanBean.getLeaseDocument(),
									-1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
							}
							
							// end
							if (finishSubInterval.getTime().compareTo(finishInterval.getTime()) == 0) {
								break;
							}
							
							endPeriod.add(Calendar.DAY_OF_MONTH, 1);
							startSubInterval.setTime(endPeriod.getTime());
						}
						
					}
					
					// end
					if (finishInterval.getTime().compareTo(dateFinish) == 0) {
						break;
					}
					dateStart.setTime(laanBean.getStartDate());
				}
			}
		}
		
		new JournalAccessBean().addMsgInJournal(20, "S", -1, baseContract.intValue(),
			-1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
	} catch (Exception e) {
		e.printStackTrace();
		mySessionCtx.setRollbackOnly();
		new JournalAccessBean().addMsgInJournal(24, "E", -1, baseContract.intValue(),
			-1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.11.2002 12:38:24)
 * @param dateStart java.sql.Date
 * @param dateFinish java.sql.Date
 * @param baseContract java.lang.Integer
 */
public void makeAutoPaymentOneContract(Date dateStart, Date dateFinish, Integer baseContract, int codeTask) throws Exception {
	try {
		Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(baseContract, new Boolean(false), null, 
			new Boolean(true), "B", new Integer(1));
		
		Vector v = new Vector();
		while (e.hasMoreElements()) {
			LeaseArendaAgreementNewAccessBean leaseBean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			v.addElement(new Integer(leaseBean.getLeaseDocument()));
		}
		
		LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
		laanBean.setInitKey_leaseDocument(baseContract.intValue());
		laanBean.refreshCopyHelper();
		v.add(0, new Integer(laanBean.getLeaseDocument()));
		
		e = new ResourceAccessBean().findResourcesByLeasePayRules(v);
		while (e.hasMoreElements()) {
			Integer resource = new Integer(((ResourceAccessBean) e.nextElement()).getResource());
			
			GregorianCalendar dateSaldo = new GregorianCalendar();
			Enumeration t = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(baseContract, resource);
			if (t.hasMoreElements()) {
				dateSaldo.setTime(((LeaseSaldoAccessBean) t.nextElement()).getSalDate());
			} else {
				// нет сальдо, что делаем? следующий ресурс... (+message)
				new JournalAccessBean().addMsgInJournal(65, "W", -1, baseContract.intValue(), -1, -1, null, null, null, null,
					-1, -1, resource.intValue(), -1, codeTask);
				continue;
			}
			
			dateSaldo.add(Calendar.DAY_OF_MONTH, 1);
			if (dateSaldo.getTime().compareTo(dateStart) > 0) {
				new JournalAccessBean().addMsgInJournal(66, "W", -1, -1, -1, -1, dateSaldo.getTime(), dateStart,
					null, null, -1, -1, -1, -1, codeTask);
				dateStart.setTime(dateSaldo.getTime().getTime());
			}
			
			if (!clearPayments(baseContract, resource, dateStart, dateFinish, codeTask)) {
				continue;
			}
			
			// цикл по договорам
			for (int i = 0; i < v.size(); i++) {
				laanBean = new LeaseArendaAgreementNewAccessBean();
				laanBean.setInitKey_leaseDocument(((Integer) v.elementAt(i)).intValue());
				laanBean.refreshCopyHelper();
				
				if (dateStart.compareTo(laanBean.getStartDate()) < 0) {
					// получен период, разбиваем на подинтервалы
					GregorianCalendar startInterval = new GregorianCalendar();
					startInterval.setTime(dateStart);
					GregorianCalendar finishInterval = new GregorianCalendar();
					finishInterval.setTime(laanBean.getStartDate());
					finishInterval.add(Calendar.DAY_OF_MONTH, -1);
					if (finishInterval.getTime().compareTo(dateFinish) > 0) {
						finishInterval.setTime(dateFinish); // last period
					}
					
					Enumeration payRules = new LeasePayRuleAccessBean().findByLeaseDocument(
						new Integer(laanBean.getLeaseDocument()), new Boolean(true), new Integer(1));
					while (payRules.hasMoreElements()) {
						LeasePayRuleAccessBean payRuleBean = (LeasePayRuleAccessBean) payRules.nextElement();
						GregorianCalendar startSubInterval = new GregorianCalendar();
						startSubInterval.setTime(startInterval.getTime());
						
						while (true) {
							
							GregorianCalendar beginPeriod = new GregorianCalendar();
							beginPeriod.setTime(startSubInterval.getTime());
							GregorianCalendar endPeriod = new GregorianCalendar();
							endPeriod.setTime(startSubInterval.getTime());
							
							if (payRuleBean.getPayPeriod().equals("M")) {
								
								beginPeriod.set(Calendar.DAY_OF_MONTH, beginPeriod.getActualMinimum(Calendar.DAY_OF_MONTH));
								endPeriod.set(Calendar.DAY_OF_MONTH, endPeriod.getActualMaximum(Calendar.DAY_OF_MONTH));
								
							} else if (payRuleBean.getPayPeriod().equals("Q")) {
								
								GregorianCalendar quarter = new GregorianCalendar();
								quarter.clear();
								quarter.set(beginPeriod.get(Calendar.YEAR), 3, 1);
								while (beginPeriod.getTime().compareTo(quarter.getTime()) >= 0) {
									quarter.add(Calendar.MONTH, 3);
								}
								
								quarter.add(Calendar.DAY_OF_MONTH, -1);
								endPeriod.setTime(quarter.getTime());
								quarter.add(Calendar.DAY_OF_MONTH, 1);
								quarter.add(Calendar.MONTH, -3);
								beginPeriod.setTime(quarter.getTime());
								
							}
							
							GregorianCalendar finishSubInterval = new GregorianCalendar();
							finishSubInterval.setTime(endPeriod.getTime());
							
							if (finishSubInterval.getTime().compareTo(finishInterval.getTime()) > 0) {
								finishSubInterval.setTime(finishInterval.getTime()); // и это последний период
							}
							
							// определяем сумму here
							BigDecimal sumPay = defineSumPayment(startSubInterval.getTime(), finishSubInterval.getTime(),
								beginPeriod.getTime(), endPeriod.getTime(), payRuleBean.getPayPeriod(), payRuleBean.getSum());
							if (sumPay != null) {
								Date datePay = defineDatePayment(startSubInterval.getTime(), finishSubInterval.getTime(), payRuleBean.getPpType(), payRuleBean.getPayBeforeDate().shortValue(),
									dateSaldo.getTime(), new int[] { payRuleBean.getLeaseRule(), laanBean.getLeaseDocument(), codeTask });
								if (datePay != null) {
									BigDecimal nds = calcNds(new Integer(payRuleBean.getResource().getResource()), datePay, new BigDecimal(0), "1");
									if (nds != null) {
										int idPayment = makeNewPayment(
											new Integer(new LeaseArendaAgreementProcessorAccessBean().getBaseContract(laanBean.getLeaseDocument())),
											sumPay,
											new Integer(payRuleBean.getCurrencyKey().currency),
											datePay,
											new Integer(payRuleBean.getLeaseRule()),
											nds,
											new Integer(payRuleBean.getResource().getResource()),
											new Integer(payRuleBean.getOrgAcc().getAccount()),
											payRuleBean.getPayPurpose() != null ? payRuleBean.getPayPurpose() : "",
											payRuleBean.getPpType(),
											new Date(startSubInterval.getTime().getTime()),
											new Date(finishSubInterval.getTime().getTime())
										);
										try {
											Object[] o = new ArendaTransactionMethodAccessBean().defineRatePaymentOnContract(new Integer(idPayment),
												new Integer(payRuleBean.getCurrencyKey().currency));
											BigDecimal ratePay = (BigDecimal) o[0];
											
											if (ratePay != null) {
												LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
												lpBean.setInitKey_leaseDocPosition(idPayment);
												lpBean.refreshCopyHelper();
												
												lpBean.setPayrate(ratePay);
												lpBean.setSumRub(lpBean.getSumm().multiply(ratePay));
												lpBean.setNdsRub(lpBean.getSumnds().multiply(ratePay)); // nds for sumrub
												lpBean.commitCopyHelper();
											}
										} catch (Exception ex) {
											// add msg - ошибка рассчета rate
											new JournalAccessBean().addMsgInJournal(71, "E", -1, laanBean.getLeaseDocument(),
												idPayment, -1, null, null, null, null, -1, payRuleBean.getCurrencyKey().currency, -1, -1, codeTask);
										}
									} else {
										new JournalAccessBean().addMsgInJournal(70, "E", -1, laanBean.getLeaseDocument(),
											-1, -1, datePay, null, null, null, -1, -1, payRuleBean.getResource().getResource(), -1, codeTask);
									}
								}
							} else {
								new JournalAccessBean().addMsgInJournal(61, "E", payRuleBean.getLeaseRule(), laanBean.getLeaseDocument(),
									-1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
							}
							
							// end
							if (finishSubInterval.getTime().compareTo(finishInterval.getTime()) == 0) {
								break;
							}
							
							endPeriod.add(Calendar.DAY_OF_MONTH, 1);
							startSubInterval.setTime(endPeriod.getTime());
						} // while (true)
						
					}
					
					// end
					if (finishInterval.getTime().compareTo(dateFinish) == 0) {
						break;
					}
					dateStart.setTime(laanBean.getStartDate().getTime());
				}
			}
		}
		
		new JournalAccessBean().addMsgInJournal(60, "S", -1, baseContract.intValue(),
			-1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
	} catch (Exception e) {
		e.printStackTrace();
		mySessionCtx.setRollbackOnly();
		new JournalAccessBean().addMsgInJournal(63, "E", -1, baseContract.intValue(),
			-1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 18:34:25)
 * @param argDate java.sql.Date
 * @param argLeaseContract java.lang.Integer
 * @param argCustomer java.lang.Integer
 * @param argExecutor java.lang.Integer
 * @param argResource java.lang.Integer
 * @param argSum java.math.BigDecimal
 * @param argCurrency java.lang.Integer
 * @param argNDSum java.math.BigDecimal
 * @param argChargeRule java.lang.Integer
 */
private void makeNewCharge(Date argDate, Integer argLeaseContract, java.sql.Date argSDate, java.sql.Date argEDate, Integer argResource, BigDecimal argSum, Integer argCurrency, BigDecimal argNDSum, Integer argChargeRule) throws Exception {
	LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
	laanBean.setInitKey_leaseDocument(argLeaseContract.intValue());
	laanBean.refreshCopyHelper();

	LeaseChargesAccessBean bean = new LeaseChargesAccessBean(
		new KeyGeneratorAccessBean().getNextKey("tables.leasedocpositions"),	//argLeaseDocPosition int
		argDate,					//argDate java.sql.Date
		argLeaseContract,			//argLeaseContract java.lang.Integer
		"A",						//argSource java.lang.String
		"N",						//argVid java.lang.String
		argSDate,					//argSDate java.sql.Date
		argEDate,					//argEDate java.sql.Date
		argResource,				//argResource java.lang.Integer
		argSum,						//argSumm java.math.BigDecimal
		argCurrency,				//argCurrency java.lang.Integer
		argNDSum,					//argSumNds java.math.BigDecimal
		argSum,						//argRemainderSum java.math.BigDecimal
		new Boolean(false)			//argByHandRateRur java.lang.Boolean
	);

	LeaseChargeRuleAccessBean chargeRuleBean = new LeaseChargeRuleAccessBean();
	chargeRuleBean.setInitKey_leaseRule(argChargeRule.intValue());
	chargeRuleBean.refreshCopyHelper();
	
	bean.setLeaseRule((LeaseChargeRule) chargeRuleBean.getEJBRef());
	bean.commitCopyHelper();
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2002 12:13:02)
 * @param summ java.math.BigDecimal
 * @param currency java.lang.Integer
 * @param summRub java.math.BigDecimal
 * @param payDate java.sql.Date
 * @param leaseRule java.lang.Integer
 * @param nds java.math.BigDecimal
 * @param ndsRub java.math.BigDecimal
 * @param rurRemainder java.math.BigDecimal
 * @param resource java.lang.Integer
 * @param orgAcc java.lang.Integer
 * @param payPurpose java.lang.String
 * @param ppType java.lang.String
 * @param paymentState java.lang.String
 */
private int makeNewPayment(Integer leaseContract, BigDecimal summ, Integer currency, Date payDate, Integer leaseRule, BigDecimal nds, Integer resource, Integer orgAcc, String payPurpose, String ppType, java.sql.Date argSDate, java.sql.Date argEDate) throws Exception {
	LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
	laanBean.setInitKey_leaseDocument(leaseContract.intValue());
	laanBean.refreshCopyHelper();
	
	KeyGeneratorAccessBean keyGenerator = new KeyGeneratorAccessBean();
	int intCode = keyGenerator.getNextKey("tables.leasedocpositions");
	
	LeasePayOrderAccessBean bean = new LeasePayOrderAccessBean(
		intCode, // argLeaseDocPosition int
		payDate, // argDate java.sql.Date
		leaseContract, // argLeaseContract java.lang.Integer
		"A", // argSource java.lang.String
		"N", // argVid java.lang.String
		argSDate, // argSDate java.sql.Date
		argEDate, // argEDate java.sql.Date
		resource, // argResource java.lang.Integer
		summ, // argSumm java.math.BigDecimal
		currency, // argCurrency java.lang.Integer
		nds, // argSumNds java.math.BigDecimal
		"O", // argPaymentType java.lang.String
		"G", // argPaymentState java.lang.String
		orgAcc, // argOrgAcc java.lang.Integer
		payPurpose, // argPayPurpoise java.lang.String
		ppType // argppType java.lang.String
	);
	bean.setDocNumber(Integer.toString(keyGenerator.getNextKey("OUTERNUMBERPAYMENT")));
	
	LeasePayRuleAccessBean leasePayRule = new LeasePayRuleAccessBean();
	leasePayRule.setInitKey_leaseRule(leaseRule.intValue());
	leasePayRule.refreshCopyHelper();
	bean.setLeaseRule((LeasePayRule) leasePayRule.getEJBRef());
	
	bean.commitCopyHelper();
	return intCode;
}
/**
 * Insert the method's description here.
 * Creation date: (07.02.2003 16:08:34)
 * @param docHandle javax.ejb.Handle
 */
public void makeProlongationOneContract(Handle docHandle, int codeTask) {
	try {
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean(docHandle.getEJBObject());
		JournalAccessBean journal = new JournalAccessBean();
		
		Date oldDate = new Date(bean.getEndDate().getTime());
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(bean.getEndDate());
		
		if (bean.getExtendPeriod().equals("Y")) {
			calendar.add(Calendar.YEAR, 1);
		} else if (bean.getExtendPeriod().equals("M")) {
			calendar.add(Calendar.MONTH, 11);
		} else if (bean.getExtendPeriod().equals("D")) {
			calendar.add(Calendar.DATE, 360);
		} else {
			journal.addMsgInJournal(5, "E", -1, bean.getLeaseDocument(), -1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
			return;
		}
		bean.setEndDate(new Date(calendar.getTime().getTime()));
		bean.commitCopyHelper();
		journal.addMsgInJournal(1, "S", -1, bean.getLeaseDocument(), -1, -1, oldDate, new Date(calendar.getTime().getTime()),
			null, null, -1, -1, -1, -1, codeTask);
	} catch (Exception ex) {
		ex.printStackTrace();
		mySessionCtx.setRollbackOnly();
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean(docHandle.getEJBObject());
			new JournalAccessBean().addMsgInJournal(6, "E", -1, bean.getLeaseDocument(), -1, -1, null, null, null, null, -1, -1, -1, -1, codeTask);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}
