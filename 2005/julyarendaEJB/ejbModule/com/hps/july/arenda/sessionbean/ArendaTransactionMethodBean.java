package com.hps.july.arenda.sessionbean;

import com.hps.july.persistence.*;
import com.hps.july.arenda.sessionbean.ArendaDocumentProcessorAccessBean;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import java.math.BigDecimal;
import java.util.Properties;
import javax.ejb.*;
import java.io.*;
/**
 * This is a Session Bean Class
 * Вспомогательные расчеты по взаимозачету, проводимые в транзакции
 */
public class ArendaTransactionMethodBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
	private Integer RUR = null;
	private Integer BASE_RATETYPE_ARENDA = null;
	private Integer ARENDA_RES_EQUIPMENT = null;
	private Integer DEFRULECALCCHARGERURSUM = null;
	private Date actStartDate = null;
	private Date actEndDate = null;
	private ArrayList contracts = null;//договоры
	private ArrayList resources = null;//услуги
	private ArrayList contractsUnic = null;
	private String dutyRateRule = null;// Правило рассчета даты
	private boolean commonRate = false;
	private String calcRateType = null;
	private int reglament = -1;
	private int act = -1;
	private int mainCurrency = -1;
	private String reglamentState = null;
	private Integer additionalCurrency = null;
	private KeyGeneratorAccessBean keyGen = null;
	private LeaseMutualActNewAccessBean mutualAct = null;
	private int idtask = -1;
	private boolean isInit = false;
	private boolean isTempact = false;
	private PrintWriter out = null;
	private boolean vaj = false;
	private boolean debug = true;
/**
 * Insert the method's description here.
 * Creation date: (20.11.2002 11:10:35)
 * @return boolean
 * @param contractDebet java.lang.Integer
 * @param contractCredit java.lang.Integer
 * @param mutuallySum java.math.BigDecimal
 */
public boolean _addMutuallyBetweenContract(Integer contractDebet, Integer contractCredit, BigDecimal mutuallySum)
throws java.rmi.RemoteException{

	pr("((((((((((((((((((begin ArendaTransactionMethod._addMutuallyBetweenContract()))))))))))))");
	pr("contractDebet="+contractDebet+", contractCredit="+contractCredit
			+", mutuallySum="+mutuallySum+", act="+act);
	
	try{	
		LeaseVPaymentAccessBean lvpab = new LeaseVPaymentAccessBean();
		lvpab.setInitKey_act_leaseDocument(new Integer(act));
		lvpab.setInitKey_creditcontract_leaseDocument(contractCredit);
		lvpab.setInitKey_debetcontract_leaseDocument(contractDebet);
		lvpab.refreshCopyHelper();
		lvpab.setSumm(lvpab.getSumm().add(mutuallySum));
		lvpab.commitCopyHelper();
		pr("(((((((((((((((((((end ArendaTransactionMethod._addMutuallyBetweenContract()))))))))))))))");
		return true;
	}catch(Exception ex){		
		if(ex instanceof FinderException){
			try{
				LeaseVPaymentAccessBean lvpab = new LeaseVPaymentAccessBean(
					new Integer(act), 
					contractDebet,
					contractCredit,
					mutuallySum
				);
				pr("(((((((((((((((((((end ArendaTransactionMethod._addMutuallyBetweenContract()))))))))))))))");
				return true;
			}catch(Exception e){
				pr(e, "_addMutuallyBetweenContract error in create");
				String msg = "Техническая ошибка в ArendaTransactionMethodBean._addMutuallyBetweenContract error in create";
		    	addMsgInJournal(idtask, "E", msg);
		    	throw new RemoteException();
			}
		} else
			pr(ex, "_addMutuallyBetweenContract\n" +"act="+act
			+" contractDebet="+contractDebet+" contractCredit="+contractCredit+" mutuallySum="+mutuallySum);
			String msg = "Техническая ошибка в ArendaTransactionMethodBean._addMutuallyBetweenContract";
	    	addMsgInJournal(idtask, "E", msg);
	    	throw new RemoteException();
	}
	
	//try{
		//pr("((((((((((((((((((begin ArendaTransactionMethod._addMutuallyBetweenContract()))))))))))))");
		//pr("contractDebet="+contractDebet+", contractCredit="+contractCredit
			//+", mutuallySum="+mutuallySum+", act="+act);
		//LeaseVPaymentAccessBean lvpab = new LeaseVPaymentAccessBean(
			//new Integer(act), 
			//contractDebet,
			//contractCredit,
			//mutuallySum
			//);
		//pr("(((((((((((((((((((end ArendaTransactionMethod._addMutuallyBetweenContract()))))))))))))))");
		//return true;
	//}catch(Exception ex){		
		//if(ex instanceof DuplicateKeyException){
			//try{
				//LeaseVPaymentAccessBean lvpab = new LeaseVPaymentAccessBean();
				//lvpab.setInitKey_act_leaseDocument(new Integer(act));
				//lvpab.setInitKey_creditcontract_leaseDocument(contractCredit);
				//lvpab.setInitKey_debetcontract_leaseDocument(contractDebet);
				//lvpab.refreshCopyHelper();
				//lvpab.setSumm(lvpab.getSumm().add(mutuallySum));
				//lvpab.commitCopyHelper();
				//return true;
			//}catch(Exception e){
				//pr(e, "_addMutuallyBetweenContract error in update");
				//String msg = "Техническая ошибка в ArendaTransactionMethodBean._addMutuallyBetweenContract error in update";
		    	//addMsgInJournal(idtask, "E", msg);
		    	//throw new RemoteException();
			//}
		//} else
			//pr(ex, "_addMutuallyBetweenContract\n" +"act="+act
			//+" contractDebet="+contractDebet+" contractCredit="+contractCredit+" mutuallySum="+mutuallySum);
			//String msg = "Техническая ошибка в ArendaTransactionMethodBean._addMutuallyBetweenContract";
	    	//addMsgInJournal(idtask, "E", msg);
	    	//throw new RemoteException();
	//}
	////return false;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 12:45:11)
 * @return boolean
 * @param contract java.lang.Integer
 * @param resource java.lang.Integer
 * @param mainSum java.math.BigDecimal
 * @param additionalSum java.math.BigDecimal
 * @param ndsSum java.math.BigDecimal
 * @param additionalNdsSum java.math.BigDecimal
 */
public boolean _addToLeaseSaldo(
	Integer contract, Integer resource, BigDecimal mainSum, BigDecimal additionalSum, 
	BigDecimal ndsSum, BigDecimal additionalNdsSum) throws java.rmi.RemoteException{
		try{
			LeaseSaldoAccessBean lsab = new LeaseSaldoAccessBean(

//Integer leaseContract, java.sql.Date salDate, resource, 
//Integer mainCurrency,  BigDecimal mainSum, BigDecimal mainNdsSum, Boolean isTemp
//additionalcurrency_currency = null;act=null, additionalSum=null, additionalndssum=null 
								
				contract, 
				new java.sql.Date(actEndDate.getTime()),
				resource,
				new Integer(mainCurrency),
				mainSum,
				ndsSum,
				new Boolean(false)
				);
			if(additionalCurrency != null){
				CurrencyAccessBean cur = new CurrencyAccessBean(); 
				cur.setInitKey_currency(additionalCurrency.intValue());
				cur.refreshCopyHelper();
				lsab.setAdditionalcurrency((Currency)cur.getEJBRef());
			}
			LeaseMutualActNewAccessBean lmab = new LeaseMutualActNewAccessBean();
			lmab.setInitKey_leaseDocument(act);
			lmab.refreshCopyHelper();
			lsab.setAct((com.hps.july.persistence.LeaseMutualActNew)lmab.getEJBRef());

			lsab.setAdditionalsum(additionalSum);
			lsab.setAdditionalndssum(additionalNdsSum);
			lsab.setIstemp(new Boolean(isTempact));
			lsab.commitCopyHelper();
			
			return true;
		}catch(Exception ex){			
			String msg = "Техническая ошибка в ArendaTransactionMethodBean._addToLeaseSaldo";
	    	addMsgInJournal(idtask, "E", msg);
			pr(ex, "_addToLeaseSaldo");

		}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2002 19:02:09)
 * @return boolean
 * @param lpab com.hps.july.persistence.LeasePaymentAccessBean
 * @param lcab com.hps.july.persistence.LeaseChargesAccessBean
 */

public boolean _linkCharge2Pay(
	Handle payment,
	Handle charge, 
	BigDecimal payRate,
	Integer tempAct,
	Boolean byhand,
	String source, 
	int idtask)throws java.rmi.RemoteException{

	LeaseChargesAccessBean lcab = null;
	LeasePaymentAccessBean lpab = null;
	int chargeid=-1, paymentid=-1;
	try{
		lcab = new LeaseChargesAccessBean(charge.getEJBObject());
		lpab = new LeasePaymentAccessBean(payment.getEJBObject());
		chargeid=lcab.getLeaseDocPosition();
		paymentid=lpab.getLeaseDocPosition();

		try{
			NamedValueAccessBean nv = new NamedValueAccessBean();
			nv.setInitKey_id("DEFRULELINKCHARGE2PAY");
			nv.refreshCopyHelper();

			if(nv.getIntvalue() == 1){
				return _linkCharge2Pay2(paymentid, chargeid,  payRate, tempAct,	byhand,	source, idtask);
			}
		} catch(Exception e){
			pr(e, "_linkCharge2Pay._linkCharge2Pay2");
			String msg = "Техническая ошибка в ArendaTransactionMethodBean._linkCharge2Pay._linkCharge2Pay2()";
	    	addMsgInJournal(idtask, "E", msg);
			return false;
		}	
		//pr("lcab.getLeaseDocPosition()="+lcab.getLeaseDocPosition()+
			//" lpab.getLeaseDocPosition()="+lpab.getLeaseDocPosition());
		BigDecimal ostSumPay = lpab.getRurremainder().divide(payRate, 2, BigDecimal.ROUND_HALF_UP);
		BigDecimal ostCharge = lcab.getRemaindersum();
		int compare = ostSumPay.compareTo(ostCharge);
		
		if(compare <0){
			// мин - сумма платежа
			BigDecimal payRURSum = lpab.getRurremainder();
			//ostSumPay.multiply(payRate).setScale(2, BigDecimal.ROUND_HALF_UP);
			LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean(
				new Integer(lcab.getLeaseDocPosition()),
				new Integer(lpab.getLeaseDocPosition()),
				ostSumPay,
				payRURSum,
				source,
				byhand);
			LeaseMutualActNewAccessBean lmab = new LeaseMutualActNewAccessBean();
			if(tempAct != null){
				lmab.setInitKey_leaseDocument(act);
				lmab.refreshCopyHelper();
				dnab.setAct((com.hps.july.persistence.LeaseMutualActNew)lmab.getEJBRef());
			}
			/////////////////////
			dnab.commitCopyHelper();

			BigDecimal ost = lpab.getRurremainder().subtract(payRURSum).setScale(2, BigDecimal.ROUND_HALF_UP);
			lpab.setRurremainder(ost);
			lpab.commitCopyHelper();
			
			ost = lcab.getRemaindersum().subtract(ostSumPay).setScale(2, BigDecimal.ROUND_HALF_UP);
			lcab.setRemaindersum(ost);
			lcab.commitCopyHelper();
		} else if(compare >= 0){
			// мин - сумма начисления
			BigDecimal payRURSum = ostCharge.multiply(payRate).setScale(2, BigDecimal.ROUND_HALF_UP);
			LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean(
				new Integer(lcab.getLeaseDocPosition()),
				new Integer(lpab.getLeaseDocPosition()),
				ostCharge,
				payRURSum,
				source,
				byhand);
			if(tempAct != null){
				LeaseMutualActNewAccessBean lmab = new LeaseMutualActNewAccessBean();
				lmab.setInitKey_leaseDocument(act);
				lmab.refreshCopyHelper();
				dnab.setAct((com.hps.july.persistence.LeaseMutualActNew)lmab.getEJBRef());
			}
			dnab.commitCopyHelper();
			
			BigDecimal ost = lpab.getRurremainder().subtract(payRURSum).setScale(2, BigDecimal.ROUND_HALF_UP);
			lpab.setRurremainder(ost);
			lpab.commitCopyHelper();
			
			ost = lcab.getRemaindersum().subtract(ostCharge).setScale(2, BigDecimal.ROUND_HALF_UP);
			lcab.setRemaindersum(ost);
			lcab.commitCopyHelper();
		}
		return true;
	}catch(Exception ex){		
		String msg = "Техническая ошибка в ArendaTransactionMethodBean._linkCharge2Pay";
	    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "_linkCharge2Pay(LeasePaymentAccessBean lpab, LeaseChargesAccessBean lcab, BigDecimal payRate)");
		
	}
	return false;
}
private boolean _linkCharge2Pay2(
	int payment,
	int charge, 
	BigDecimal payRate,
	Integer tempAct,
	Boolean byhand,
	String source, 
	int idtask)throws Exception{

	java.sql.Connection con = null;
	java.sql.PreparedStatement ps = null;
	java.sql.ResultSet rs = null;
	try {
		con = getConnection();
		ps = con.prepareStatement("execute procedure linkCharge2Pay(?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setInt(1, act);
		ps.setInt(2, charge);
		ps.setInt(3, payment);
		ps.setBigDecimal(4, payRate);
		ps.setInt(5, tempAct.intValue());
		ps.setString(6, byhand.booleanValue() ? "Y" : "N");
		ps.setString(7, source);
		ps.setInt(8, idtask);
		rs = ps.executeQuery();
		rs.next();
		if(rs.getInt(1) == 1)
			return true;
		else
			return false;
	} catch (Exception e) {
		pr("Error in _linkCharge2Pay2");
		if(e instanceof java.sql.SQLException){
			pr("Error code="+((java.sql.SQLException)e).getErrorCode());
		}
		e.printStackTrace(System.out);
		return false;
	} finally {
		try {if(rs != null) rs.close();} catch(Exception e){e.printStackTrace(System.out);}
		try {if(ps != null) ps.close();} catch(Exception e){e.printStackTrace(System.out);}
		try {if(con != null) con.close();} catch(Exception e){e.printStackTrace(System.out);}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2002 15:41:10)
 * @return java.lang.Integer
 * @param lcab com.hps.july.persistence.LeasePaymentAccessBean
 */
public Integer _makeCompensationCharge(Handle payment)throws java.rmi.RemoteException {
	int payid = -1;
	try{
		pr("(((((((((((((((( _makeCompensationCharge start )))))))))))))))))");
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean(payment.getEJBObject());
		payid = lpab.getLeaseDocPosition();

		pr("---Payment для которого формируем компенсацию---");
		printPay(lpab);
		
		BigDecimal ratePaymentRur2CurrencyAkt = getPaymentRate(lpab, mainCurrency, true);
		BigDecimal sumOstPaymentCurrencyAct = lpab.getRurremainder().divide(
			ratePaymentRur2CurrencyAkt, 2, BigDecimal.ROUND_HALF_UP);
		BigDecimal sumOstPaymentCurrencyRub = lpab.getRurremainder();

		int chargeId = keyGen.getNextKey("tables.leasedocpositions"); 
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(

//int leaseDocPosition,	java.sql.Date date,	Integer leaseContract,	String source,
//String docposvid,	java.sql.Date beginDate, java.sql.Date enddate,	Integer resource, BigDecimal summ,
//Integer currency,	BigDecimal sumNds, BigDecimal remainderSum,	Boolean byHandRateRur
		
			chargeId,	
			new java.sql.Date(actEndDate.getTime()),
			new Integer(lpab.getLeaseContractKey().leaseDocument),
			"A",
			"K", 
			new java.sql.Date(lpab.getBegindate().getTime()),
			new java.sql.Date(lpab.getEnddate().getTime()),
			new Integer(lpab.getResourceKey().resource), 
			sumOstPaymentCurrencyRub, 
			new Integer(mainCurrency), 
			calcNds(new Integer(lpab.getResourceKey().resource), actEndDate, sumOstPaymentCurrencyRub, "1", idtask),
			getDec(0,2),
			new Boolean(false)
			);
		LeaseMutualActNewAccessBean lmaab = new LeaseMutualActNewAccessBean();
		lmaab.setInitKey_leaseDocument(act);
		lmaab.refreshCopyHelper();
		LeaseMutualActNew lma = (LeaseMutualActNew)lmaab.getEJBRef();
		lcab.setAct(lma);
		lcab.setRemainderrate2rur(ratePaymentRur2CurrencyAkt);
		lcab.setRemaindersum(getDec(0,2));
		lcab.commitCopyHelper();

		LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean(

//Integer leaseCharge, Integer leasePayment, BigDecimal chargeSum,
//BigDecimal payRurSum, String source, Boolean byHandChargeRateRur
//act_leaseDocument = null;
			
		new Integer(chargeId), 
		new Integer(lpab.getLeaseDocPosition()), 
		sumOstPaymentCurrencyRub,
		sumOstPaymentCurrencyRub,
		"A",
		new Boolean(false)
		);	
		dnab.setChargerurrate(getDec(1,4));
		dnab.setChargerursum(sumOstPaymentCurrencyRub);
		dnab.setAct(lma);
		dnab.commitCopyHelper();

		lpab.setRurremainder(getDec(0,2));
		lpab.commitCopyHelper();

		pr("---Созданный charge---");
		printCharge(lcab);
		pr("---Созданный dnop---");
		printDnop(dnab);
		pr("---Платеж после обработки---");
		printPay(lpab);
		pr("(((((((((((((((( _makeCompensationCharge end )))))))))))))))))");	
		return new Integer(chargeId);
	}catch(Exception ex){
		pr(ex, "_makeCompensationCharge");		
		if(RemoteException.class.isInstance(ex))
			throw (RemoteException)ex;
		String msg = "Техническая ошибка в ArendaTransactionMethodBean._makeCompensationCharge";
    	addMsgInJournal(idtask, "E", msg);		
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2002 10:55:19)
 * @return java.lang.Integer
 * @param lcab com.hps.july.persistence.LeaseChargesAccessBean
 */
public Integer _makeCompensationPayment(Handle charge) throws java.rmi.RemoteException{
	int chargeid = -1;
	try{
		pr("((((((((((((((((((((_makeCompensationPayment start))))))))))))))))");
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(charge.getEJBObject());
		chargeid = lcab.getLeaseDocPosition();

		pr("---Начисление для которого формируем компенсацию---");
		printCharge(lcab);
		BigDecimal rateChargeRur2CurrencyAkt = getChargeRate(lcab.getEJBRef().getHandle(), mainCurrency, false);
		BigDecimal sumOstChargeCurrencyAct = lcab.getRemaindersum().multiply(
			lcab.getRemainderrate2rur()).divide(rateChargeRur2CurrencyAkt, 2, BigDecimal.ROUND_HALF_UP);
		BigDecimal rateChargeRur2CurrencyCharge = lcab.getRemainderrate2rur();
		BigDecimal sumOstChargeCurrencyRub = lcab.getRemaindersum().multiply(
			rateChargeRur2CurrencyCharge).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal sumOstChargeCurrencyCharge = lcab.getRemaindersum();

		int paymentId = keyGen.getNextKey("tables.leasedocpositions");
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean(

//int leaseDocPosition, java.sql.Date date, Integer leaseContract, 
//String source, String docposvid, java.sql.Date begindate, java.sql.Date enddate,
//Integer resource, java.math.BigDecimal summ, Integer currency,
//java.math.BigDecimal sumNds,	String paymentType, String paymentState

//act = null		docNumber = null	sumRub = null	ndsRub = null	
//leaseRule_leaseRule = null	rurremainder = null	payrate = null;

			paymentId,
			new java.sql.Date(actEndDate.getTime()),
			new Integer(lcab.getLeaseContractKey().leaseDocument),
			"A",
			"K",
			new java.sql.Date(lcab.getBegindate().getTime()),
			new java.sql.Date(lcab.getEnddate().getTime()),
			new Integer(lcab.getResourceKey().resource),
			lcab.getRemaindersum(),
			new Integer(mainCurrency),
			calcNds(new Integer(lcab.getResourceKey().resource), actEndDate, lcab.getRemaindersum(), "1", idtask),
			"P",
			"P"
			);

		LeaseMutualActNewAccessBean lmab = new LeaseMutualActNewAccessBean();
		lmab.setInitKey_leaseDocument(act);
		lmab.refreshCopyHelper();
		LeaseMutualActNew lma = (com.hps.july.persistence.LeaseMutualActNew)lmab.getEJBRef();
		lpab.setAct(lma);
		lpab.setSumRub(sumOstChargeCurrencyRub);		

		BigDecimal sumRub = lpab.getSumRub();
		if(sumRub != null){
			lpab.setNdsRub(calcNds(
				new Integer(lcab.getResourceKey().resource), actEndDate, sumOstChargeCurrencyRub, "1", idtask));
			lpab.setRurremainder(getDec(0,2));
		}
		lpab.commitCopyHelper();

		LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean(

//Integer leaseCharge, Integer leasePayment, BigDecimal chargeSum,
//BigDecimal payRurSum, String source, Boolean byHandChargeRateRur
//act_leaseDocument = null;
			
		new Integer(lcab.getLeaseDocPosition()), 
		new Integer(paymentId), 
		sumOstChargeCurrencyCharge,
		sumOstChargeCurrencyRub,
		"A",
		new Boolean(false)
		);	
		dnab.setChargerurrate(rateChargeRur2CurrencyCharge);
		dnab.setChargerursum(sumOstChargeCurrencyRub);
		dnab.setAct(lma);
		dnab.commitCopyHelper();

		lcab.setRemaindersum(getDec(0,2));
		lcab.commitCopyHelper();

		pr("---Созданный платеж---");
		printPay(lpab);
		pr("---Созданный дноп---");
		printDnop(dnab);
		pr("---_makeCompensationPayment end---");
		pr("---Начисление после обработки---");
		printCharge(lcab);
		pr("((((((((((((((((((((_makeCompensationPayment end))))))))))))))))");
		return new Integer(paymentId);
	}catch(Exception ex){
		String msg = "Техническая ошибка в ArendaTransactionMethodBean._makeCompensationPayment";
    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "_makeCompensationPayment");		
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (15.11.2002 16:45:26)
 * @return java.lang.Integer
 * @param lpab com.hps.july.persistence.LeasePaymentAccessBean
 * @param minSum java.math.BigDecimal
 */
public Integer _makeMutualCharge(Handle payment, BigDecimal minSum)throws java.rmi.RemoteException{
	int payid = -1;
	try{
		pr("((((((((((((((((begin ArendaTransactionMethod._makeMutualCharge()))))))))))))))))))))");
		pr("minsum="+minSum);
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean(payment.getEJBObject());
		payid = lpab.getLeaseDocPosition();

		pr("---Payment до обработки---");
		printPay(lpab);
	
		BigDecimal ratePaymentRur2CurrencyAkt = getPaymentRate(lpab, mainCurrency, false);
		BigDecimal sumOstPaymentCurrencyAct = lpab.getRurremainder().divide(
			ratePaymentRur2CurrencyAkt, 2, BigDecimal.ROUND_HALF_UP);

		BigDecimal sumOstPaymentCurrencyRub = lpab.getRurremainder();
		BigDecimal leaseDnopChargeRURSum = minSum.multiply(
			ratePaymentRur2CurrencyAkt).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		BigDecimal leaseDnopPayRURSum = null;
		if(sumOstPaymentCurrencyAct.compareTo(minSum) == 0)
			leaseDnopPayRURSum = sumOstPaymentCurrencyRub;
		else
			leaseDnopPayRURSum = minSum.multiply(
				ratePaymentRur2CurrencyAkt).setScale(2, BigDecimal.ROUND_HALF_UP);

		int chargeId = keyGen.getNextKey("tables.leasedocpositions");
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(

//int leaseDocPosition,	java.sql.Date date,	Integer leaseContract,	String source,
//String docposvid,	java.sql.Date beginDate, java.sql.Date enddate,	Integer resource, BigDecimal summ,
//Integer currency,	BigDecimal sumNds, BigDecimal remainderSum,	Boolean byHandRateRur
		
			chargeId,	
			new java.sql.Date(actEndDate.getTime()),
			new Integer(lpab.getLeaseContractKey().leaseDocument),
			"A",
			"Q", 
			new java.sql.Date(lpab.getBegindate().getTime()),
			new java.sql.Date(lpab.getEnddate().getTime()),
			new Integer(lpab.getResourceKey().resource), 
			minSum, 
			new Integer(mainCurrency), 
			calcNds(new Integer(lpab.getResourceKey().resource), actEndDate, minSum, "1", idtask),
			getDec(0,2),
			new Boolean(false)
			);
		LeaseMutualActNewAccessBean lmaab = new LeaseMutualActNewAccessBean();
		lmaab.setInitKey_leaseDocument(act);
		lmaab.refreshCopyHelper();
		LeaseMutualActNew lma = (LeaseMutualActNew)lmaab.getEJBRef();
		lcab.setAct(lma);
		lcab.setRemainderrate2rur(ratePaymentRur2CurrencyAkt);
		lcab.commitCopyHelper();

		
		LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean(

//Integer leaseCharge, Integer leasePayment, BigDecimal chargeSum,
//BigDecimal payRurSum, String source, Boolean byHandChargeRateRur
//act_leaseDocument = null;
			
		new Integer(chargeId), 
		new Integer(lpab.getLeaseDocPosition()), 
		minSum,
		leaseDnopPayRURSum,
		"A",
		new Boolean(false)
		);	
		dnab.setChargerurrate(ratePaymentRur2CurrencyAkt);
		dnab.setChargerursum(leaseDnopChargeRURSum);
		dnab.setAct(lma);
		dnab.commitCopyHelper();

		BigDecimal lpRURReminder = null;
		if(sumOstPaymentCurrencyAct.compareTo(minSum) == 0)
			lpRURReminder = getDec(0,2);
		else
			lpRURReminder = lpab.getRurremainder().subtract(
					leaseDnopPayRURSum).setScale(2, BigDecimal.ROUND_HALF_UP);
		lpab.setRurremainder(lpRURReminder);
		lpab.commitCopyHelper();

		pr("---Созданный charge---");
		printCharge(lcab);
		pr("---Созданный dnop---");
		printDnop(dnab);
		pr("---Payment после обработки---");
		printPay(lpab);
	pr("(((((((((((((((((( end ArendaTransactionMethod._makeMutualCharge()))))))))))))))))))))))")	;
		return new Integer(chargeId);
	}catch(Exception ex){		
		String msg = "Техническая ошибка в ArendaTransactionMethodBean._makeMutualCharge";
    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "_makeMutualCharge(LeasePaymentAccessBean lpab, BigDecimal minSum)");
	}
	pr("end ArendaTransactionMethod._makeMutualCharge()")	;
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (15.11.2002 16:43:11)
 * @return java.lang.Integer
 * @param lcab com.hps.july.persistence.LeaseChargesAccessBean
 * @param minSum java.math.BigDecimal
 */
public Integer _makeMutualPayment(Handle charge, BigDecimal minSum)throws java.rmi.RemoteException{

	pr("(((((((((((((((((((((((ArendaTransactionMethod._makeMutualPayment start)))))))))))))))))");
	pr("minsum="+minSum);
	int chargeid = -1;
    try {
	    LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(charge.getEJBObject());
	    chargeid = lcab.getLeaseDocPosition();
	    pr("---Charge до обработки---");
	    printCharge(lcab);

        BigDecimal rateChargeRur2CurrencyAkt = getChargeRate(lcab.getEJBRef().getHandle(), mainCurrency, false);
        
        BigDecimal sumOstChargeCurrencyAct = lcab.getRemaindersum().multiply(
	        lcab.getRemainderrate2rur()).divide(rateChargeRur2CurrencyAkt, 2, BigDecimal.ROUND_HALF_UP);
	        
	    BigDecimal rateChargeRur2CurrencyCharge = lcab.getRemainderrate2rur();
	    
	    BigDecimal sumOstChargeCurrencyRub = lcab.getRemaindersum().multiply(
		    rateChargeRur2CurrencyCharge).setScale(2, BigDecimal.ROUND_HALF_UP);
		    
		BigDecimal sumOstChargeCurrencyCharge = lcab.getRemaindersum();

		BigDecimal leasePaymentSumRub;
		if(sumOstChargeCurrencyAct.compareTo(minSum) == 0)
			leasePaymentSumRub = sumOstChargeCurrencyRub;
		else
			leasePaymentSumRub = rateChargeRur2CurrencyAkt.multiply(
				minSum).setScale(2, BigDecimal.ROUND_HALF_UP);

		BigDecimal leaseDnopChargesum;
		if(sumOstChargeCurrencyAct.compareTo(minSum) == 0)
			leaseDnopChargesum = sumOstChargeCurrencyCharge;
		else
			leaseDnopChargesum = rateChargeRur2CurrencyAkt.multiply(minSum).divide(
				rateChargeRur2CurrencyCharge, 2, BigDecimal.ROUND_HALF_UP);

		BigDecimal leaseDnopChargeRURSum;
		leaseDnopChargeRURSum = leasePaymentSumRub;//вместо комментария ниже
/*		if(sumOstChargeCurrencyAct.compareTo(minSum) == 0){
			leaseDnopChargeRURSum = sumOstChargeCurrencyRub;
		} else if(mainCurrency == рублям ){
			leaseDnopChargeRURSum = minSum;
		}
		else
			leaseDnopChargeRURSum = rateChargeRur2CurrencyCharge.multiply(
				minSum).setScale(2, BigDecimal.ROUND_HALF_UP);
*/
//int leaseDocPosition, java.sql.Date date, Integer leaseContract, 
//String source, String docposvid, java.sql.Date begindate, java.sql.Date enddate,
//Integer resource, java.math.BigDecimal summ, Integer currency,
//java.math.BigDecimal sumNds,	String paymentType, String paymentState

//act = null		docNumber = null	sumRub = null	ndsRub = null	
//leaseRule_leaseRule = null	rurremainder = null	payrate = null;
		
		int paymentId = keyGen.getNextKey("tables.leasedocpositions");		
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean(
			paymentId,	
			new java.sql.Date(actEndDate.getTime()),
			new Integer(lcab.getLeaseContractKey().leaseDocument), 
			"A", 
			"Q",
			new java.sql.Date(lcab.getBegindate().getTime()),
			new java.sql.Date(lcab.getEnddate().getTime()),
			new Integer(lcab.getResourceKey().resource),
			minSum,
			new Integer(mainCurrency),
			calcNds(new Integer(lcab.getResourceKey().resource), actEndDate, minSum, "1", idtask),
			"P", 
			"P"
			);
		LeaseMutualActNewAccessBean lmaab = new LeaseMutualActNewAccessBean();
		lmaab.setInitKey_leaseDocument(act);
		lmaab.refreshCopyHelper();
		LeaseMutualActNew lma = (LeaseMutualActNew)lmaab.getEJBRef();
		lcab.setAct(lma);
		
		lpab.setSumRub(leasePaymentSumRub);
		lpab.setNdsRub(calcNds(new Integer(lcab.getResourceKey().resource), 
			actEndDate, leasePaymentSumRub, "1", idtask));
		lpab.setRurremainder(getDec(0,2));
		lpab.commitCopyHelper();

//Integer leaseCharge, Integer leasePayment, BigDecimal chargeSum,
//BigDecimal payRurSum, String source, Boolean byHandChargeRateRur
//act = null;		
		LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean(		
		new Integer(lcab.getLeaseDocPosition()),
		new Integer(paymentId), 
		leaseDnopChargesum,
		leasePaymentSumRub,
		"A",
		new Boolean(false)
		);
		
		dnab.setChargerurrate(rateChargeRur2CurrencyCharge);
		dnab.setChargerursum(leaseDnopChargeRURSum);
		dnab.setAct(lma);
		dnab.commitCopyHelper();
		
		BigDecimal leaseChargeRemaindersum = null;
		if(sumOstChargeCurrencyAct.compareTo(minSum) == 0)
			leaseChargeRemaindersum = getDec(0,2);
		else
			leaseChargeRemaindersum = lcab.getRemaindersum().subtract(
					leaseDnopChargesum).setScale(2, BigDecimal.ROUND_HALF_UP);
		lcab.setRemaindersum(leaseChargeRemaindersum);
		lcab.commitCopyHelper();

		pr("---Созданный в _makeMutualPayment dnop---");
		printDnop(dnab);
		pr("---Созданный в _makeMutualPayment payment---");
		printPay(lpab);
		pr("---Charge после обрабоки---");
		printCharge(lcab);
		pr("((((((((((((((((((((ArendaTransactionMethod._makeMutualPayment end)))))))))))))))))"); 
        return new Integer(paymentId);
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
		addMsgInJournal(135, "E", -1, act, chargeid, -1, null, null, null, null, -1, -1, -1, -1 );
		pr(ex, "_makeMutualPayment(LeaseChargesAccessBean lcab, BigDecimal minSum)");
		throw (RemoteException)ex;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 15:57:43)
 * @return boolean
 * @param lsab com.hps.july.persistence.LeaseSaldoAccessBean
 */
public boolean _makeSaldoCharge(Handle saldo) throws java.rmi.RemoteException{
	
	try{
		
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		
		LeaseSaldoAccessBean lsab = new LeaseSaldoAccessBean(saldo.getEJBObject());		
		
		BigDecimal mainSum = lsab.getMainsum().abs();
		BigDecimal ndsSum = lsab.getMainndssum().abs();
		int rurCurrency;
			try{
      	        rurCurrency = getNamedValueInt("RUR", idtask);
			}catch(Exception ex){
				addMsgInJournal(111, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
				return false;
			}
			
		int chargeId = keyGen.getNextKey("tables.leasedocpositions");
		Calendar cal = Calendar.getInstance();
        cal.setTime(lsab.getSalDate());
        cal.add(Calendar.DATE, 1);
        Date date = new java.sql.Date(cal.getTime().getTime());
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean( 
			
//int leaseDocPosition,	java.sql.Date date,	Integer leaseContract,	String source,
//String docposvid,	java.sql.Date beginDate, java.sql.Date enddate,	Integer resource, BigDecimal summ,
//Integer currency,	BigDecimal sumNds, BigDecimal remainderSum,	Boolean byHandRateRur

			chargeId,	
			new java.sql.Date(date.getTime()),
			lsab.getLeaseContract(),
			"A",
			"Z",	
			new java.sql.Date(date.getTime()),
			new java.sql.Date(date.getTime()), 
			new Integer(lsab.getResourceKey().resource), 
			lsab.getMainsum(),
			new Integer(lsab.getMaincurrencyKey().currency),
			//calcNds(new Integer(lsab.getResourceKey().resource), lsab.getSalDate(), lsab.getMainsum(), "1"),
			ndsSum,
			//lsab.getMainsum(),
			mainSum,
			new Boolean(false)
			);

		CurrencyKey maincurrencyKey = lsab.getMaincurrencyKey();
		CurrencyKey addcurrencyKey = lsab.getAdditionalcurrencyKey();
		
		LeaseDocumentKey key = lsab.getActKey();
		LeaseMutualActNew lma = null;
		if(key != null){
			LeaseMutualActNewAccessBean lmaab = new LeaseMutualActNewAccessBean();
			lmaab.setInitKey_leaseDocument(key.leaseDocument);
			lmaab.refreshCopyHelper();
			lma = (LeaseMutualActNew)lmaab.getEJBRef();
			lcab.setAct(lma);
		}
		
		


		if(addcurrencyKey != null && lsab.getAdditionalsum() != null){

			BigDecimal raterur = rurCurrency == maincurrencyKey.currency ?
	            	mainSum.divide(
		            	lsab.getAdditionalsum(), 4, BigDecimal.ROUND_HALF_UP):
	            	lsab.getAdditionalsum().divide(
		            	mainSum, 4, BigDecimal.ROUND_HALF_UP);
			lcab.setRemainderrate2rur(raterur);

            if(rurCurrency == maincurrencyKey.currency
	            && rurCurrency == addcurrencyKey.currency) return true;
            if(rurCurrency != maincurrencyKey.currency && rurCurrency != addcurrencyKey.currency){
	            //Предупреждение
	            return true;
            } else {
	            BigDecimal rate = rurCurrency == maincurrencyKey.currency ?
	            	mainSum.divide(
		            	lsab.getAdditionalsum(), 4, BigDecimal.ROUND_HALF_UP):
	            	lsab.getAdditionalsum().divide(
		            	mainSum, 4, BigDecimal.ROUND_HALF_UP);
	            
	            int notMainCurrency = rurCurrency == maincurrencyKey.currency ?
	            	addcurrencyKey.currency : maincurrencyKey.currency;
	            LeaseCalcRateAccessBean lcrab= new LeaseCalcRateAccessBean(

//Integer leaseDocPosition, Integer currency, BigDecimal rate, Boolean byHand
//act_leaseDocument = null;
		            new Integer(chargeId), 
		            new Integer(notMainCurrency), 
		            rate.abs(), 
		            new Boolean(false)
		            );
	            lcrab.setAct(lma);
		        lcrab.commitCopyHelper();
            }
		} else if(rurCurrency == maincurrencyKey.currency)
			lcab.setRemainderrate2rur(getDec(1,4));

		
		lcab.commitCopyHelper();
		
		return true;
	}catch(Exception ex){		
		String msg = "Техническая ошибка в ArendaTransactionMethodBean._makeSaldoCharge";
	    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "_makeSaldoCharge(LeaseSaldoAccessBean lsab)");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 16:01:12)
 * @return boolean
 * @param lsab com.hps.july.persistence.LeaseSaldoAccessBean
 */
public boolean _makeSaldoPayment(Handle saldo) throws java.rmi.RemoteException{
	try{ 
		LeaseSaldoAccessBean lsab = new LeaseSaldoAccessBean(saldo.getEJBObject());
		
		BigDecimal mainSum = lsab.getMainsum().abs();
		BigDecimal ndsSum = lsab.getMainndssum().abs();
		BigDecimal addSum = lsab.getAdditionalsum();
			addSum = addSum == null ? null : addSum.abs();
		BigDecimal addNdsSum = lsab.getAdditionalndssum();
			addNdsSum = addNdsSum == null ? null : addNdsSum.abs();
		
		CurrencyKey maincurrencyKey = lsab.getMaincurrencyKey();
		CurrencyKey addcurrencyKey = lsab.getAdditionalcurrencyKey();		
		LeaseDocumentKey key = lsab.getActKey();
		LeaseMutualActNew lma = null;


		int paymentId = new KeyGeneratorAccessBean().getNextKey("tables.leasedocpositions"); 
		Calendar cal = Calendar.getInstance();
        cal.setTime(lsab.getSalDate());
        cal.add(Calendar.DATE, 1);
        Date date = new java.sql.Date(cal.getTime().getTime());
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean(

//int leaseDocPosition, java.sql.Date date, Integer leaseContract, 
//String source, String docposvid, java.sql.Date begindate, java.sql.Date enddate,
//Integer resource, java.math.BigDecimal summ, Integer currency,
//java.math.BigDecimal sumNds,	String paymentType, String paymentState

//act = null		docNumber = null	sumRub = null	ndsRub = null	
//leaseRule_leaseRule = null	rurremainder = null	payrate = null;
			
			paymentId,	
			new java.sql.Date(date.getTime()),
			lsab.getLeaseContract(),
			"A", 
			"Z",	
			new java.sql.Date(date.getTime()),
			new java.sql.Date(date.getTime()),
			new Integer(lsab.getResourceKey().resource),			
			mainSum,
			new Integer(lsab.getMaincurrencyKey().currency),
//calcNds(new Integer(lsab.getResourceKey().resource), date, mainSum, "1"),//sumNds
			ndsSum,
			"P",
			"P"
			);
	

        int rurCurrency = getNamedValueInt("RUR", idtask);
        if(lsab.getMaincurrencyKey().currency == rurCurrency){
        	lpab.setSumRub(mainSum);
        	lpab.setRurremainder(mainSum);
        }
        else if(lsab.getAdditionalcurrencyKey() != null && lsab.getAdditionalcurrencyKey().currency == rurCurrency){
        	lpab.setSumRub(addSum);
        	lpab.setRurremainder(addSum);
        }
        // Иначе не устанавливаем ничего
		
        if(rurCurrency == maincurrencyKey.currency)
			lpab.setNdsRub(lsab.getMainndssum().abs());
		else if(addcurrencyKey != null && rurCurrency == addcurrencyKey.currency)
			lpab.setNdsRub(addNdsSum);
		
        BigDecimal rate = null;
        if(addcurrencyKey != null && addSum != null){//курс рубля к валюте платежа 
	        if(rurCurrency == maincurrencyKey.currency && rurCurrency == addcurrencyKey.currency);
	        else if(rurCurrency != maincurrencyKey.currency && rurCurrency != addcurrencyKey.currency);
	        else {
		        if(rurCurrency == maincurrencyKey.currency) {
			        if(addSum.doubleValue() == 0.0d) {
				        rate = new BigDecimal("0.0000");
			        } else {
				        rate = mainSum.divide(addSum, 4, BigDecimal.ROUND_HALF_UP);
			        }
		        } else {
			        if(mainSum.doubleValue() == 0.0d) {
				        rate = new BigDecimal("0.0000");
			        } else {
						rate = addSum.divide(mainSum, 4, BigDecimal.ROUND_HALF_UP);
			        }
		        }
	            lpab.setPayrate(rate);
	        }
        }
            			
		//lpab.setNds(arab.calcNds(new Integer(lpab.getResourceKey().resource), date, mainSum, "1"));
		//BigDecimal sumRub = lpab.getSumRub();
		//if(sumRub != null){
			//lpab.setNdsRub(calcNds(new Integer(lpab.getResourceKey().resource), 
			//date, sumRub, "1", idtask));
			//lpab.setRurremainder(new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));
		//}

		if(key != null){
			LeaseMutualActNewAccessBean lmaab = new LeaseMutualActNewAccessBean();
			lmaab.setInitKey_leaseDocument(key.leaseDocument);
			lmaab.refreshCopyHelper();
			lma = (LeaseMutualActNew)lmaab.getEJBRef();
			lpab.setAct(lma);			
		}
		lpab.commitCopyHelper();

		if(addcurrencyKey != null && addSum != null){

            if(rurCurrency == maincurrencyKey.currency && rurCurrency == addcurrencyKey.currency) return true;
            if(rurCurrency != maincurrencyKey.currency && rurCurrency != addcurrencyKey.currency){
	            //Предупреждение
	            return true;
            } else{
	            //BigDecimal rate = rurCurrency == mainCurrency ?
	            	//new BigDecimal(mainCurrency).divide(
		            	//new BigDecimal(additionalCurrency.intValue()), 4, BigDecimal.ROUND_HALF_UP):
	            	//new BigDecimal(additionalCurrency.intValue()).divide(
		            	//new BigDecimal(mainCurrency), 4, BigDecimal.ROUND_HALF_UP);
	            
	            int notMainCurrency = rurCurrency == maincurrencyKey.currency?
	            	addcurrencyKey.currency : maincurrencyKey.currency;
	            if(rate != null){
	            	LeaseCalcRateAccessBean lcrab= new LeaseCalcRateAccessBean(

//Integer leaseDocPosition, Integer currency, BigDecimal rate, Boolean byHand
//act_leaseDocument = null;		            
		   				new Integer(paymentId),         
						new Integer(notMainCurrency), 
		            	rate.abs(), 
		            	new Boolean(false));
	            	lcrab.setAct(lma);
		        	lcrab.commitCopyHelper();
	            }
            }
		}
		return true;
		
	}catch(Exception ex){		
		String msg = "Техническая ошибка в ArendaTransactionMethodBean._makeSaldoPayment";
	    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "_makeSaldoPayment(LeaseSaldoAccessBean lsab)");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2002 19:16:25)
 * @param lcab com.hps.july.persistence.LeaseChargesAccessBean
 * @exception java.lang.Exception The exception description.
 */
public void _newCalcRate(int leaseDocPosition, int currency, BigDecimal rate) 
throws java.rmi.RemoteException {
	try{
		LeaseCalcRateAccessBean lcrab = new LeaseCalcRateAccessBean(
			new Integer(leaseDocPosition),
			new Integer(currency),
			rate.abs(),
			new Boolean(false));
	}catch(Exception ex){		
		String msgg = "Техническая ошибка в ArendaTransactionMethodBean._newCalcRate";
	    	addMsgInJournal(idtask, "E", msgg);
		pr(ex, "_newCalcRate(int leaseDocPosition, int currency, BigDecimal rate)");
		String msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2002 19:16:25)
 * @param lcab com.hps.july.persistence.LeaseChargesAccessBean
 * @exception java.lang.Exception The exception description.
 */
public boolean _setLeaseChargesRemainderRate(Handle charge, BigDecimal rate) throws java.rmi.RemoteException{
	try{
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(charge.getEJBObject());

		lcab.setRemainderrate2rur(rate);
		lcab.setByhandraterur(new Boolean(false));
		lcab.commitCopyHelper();

		return true;
	}catch(Exception ex){		
		String msg = "Техническая ошибка в ArendaTransactionMethodBean._setLeaseChargesRemainderRate";
	    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "_setLeaseChargesRemainderRate");
	}
	return false;
}
public boolean _setLeaseDnopChargeRURSum(Handle dnop, BigDecimal rateCharge) throws java.rmi.RemoteException{
	try{
		// Рассчитываем значение DnopChargeRURSum для дноп
		LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean(dnop.getEJBObject());

		BigDecimal ratePayment = getPaymentRate(
			dnab.getLeasePayment(),
			dnab.getLeaseCharge().getCurrencyKey().currency,
			true
			);

		if (!dnab.getByhandchangeraterur().booleanValue())
			dnab.setChargerurrate(rateCharge);
		
		BigDecimal chargesum = dnab.getChargesum();
		BigDecimal chargeRURRate = dnab.getChargerurrate();
		BigDecimal payrursum = dnab.getPayrursum();

		BigDecimal chargeRURSum = null;
		if(getNamedValueInt("DEFRULECALCCHARGERURSUM", idtask) == 0){			
			if(ratePayment.equals(chargeRURRate))
				chargeRURSum = payrursum;
			else
				chargeRURSum = chargesum.multiply(chargeRURRate).setScale(2, BigDecimal.ROUND_HALF_UP);						
		} else {
			chargeRURSum = chargesum.multiply(chargeRURRate).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		dnab.setChargerursum(chargeRURSum);
		dnab.commitCopyHelper();

		return true;
	}catch(Exception ex){		
		String msg = "Техническая ошибка в ArendaTransactionMethodBean._setLeaseDnopChargeRURSum";
	    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "_setLeaseDnopChargeRURSum");
	}
	return false;
}
public boolean addMsgInJournal(
	int jrnAction, String jrnType, int leaseRule, int leaseDocument, 
	int leaseDocPosition, int leaseDocPosition2, Date date1, Date date2, BigDecimal summ1, BigDecimal summ2, 
	int currency1, int currency2, int resource1, int resource2){

    try {
        return new JournalAccessBean().addMsgInJournal(jrnAction, jrnType, leaseRule, leaseDocument,
	        leaseDocPosition, leaseDocPosition2, date1, date2, summ1, summ2,
	        currency1, currency2, resource1, resource2, idtask);
    } catch (Exception ex) {
        pr(ex, "addmsgInJournal");
        return false;
    }
}
public boolean addMsgInJournal(
	int jrnAction, String jrnType, int leaseRule, int leaseDocument, 
	int leaseDocPosition, int leaseDocPosition2, Date date1, Date date2, BigDecimal summ1, BigDecimal summ2, 
	int currency1, int currency2, int resource1, int resource2, int idTask){

    try {
        return new JournalAccessBean().addMsgInJournal(jrnAction, jrnType, leaseRule, leaseDocument,
	        leaseDocPosition, leaseDocPosition2, date1, date2, summ1, summ2,
	        currency1, currency2, resource1, resource2, idtask);
    } catch (Exception ex) {
        pr(ex, "addmsgInJournal");
        return false;
    }
}
private boolean addMsgInJournal(int idtask, String jrnType, String jrnMsg){

	try{
		return new JournalAccessBean().addMsgInJournal(idtask, jrnType, jrnMsg);
	}catch(Exception ex){
		pr(ex, "addMsgInJournal(int idtask, String jrnType, String jrnMsg)");
	}
	return false;
}
/*
 * параметр typeCalc:
 *     1 - НДС включен в сумму
 *     2 - НДС НЕ включен в сумму
 *     other - ошибка
 */ 
public BigDecimal calcNds(Integer resource, Date localDate, BigDecimal localSum, String typeCalc, int idTask) throws java.rmi.RemoteException {
	BigDecimal rateNds = null;
	try{
	Enumeration taxes = new ResourceTaxeAccessBean().findByResourceOrderByDateDesc(resource);
	while (taxes.hasMoreElements()) {
		ResourceTaxeAccessBean taxBean = (ResourceTaxeAccessBean) taxes.nextElement();
		if (taxBean.getDate().compareTo(localDate) <= 0) {
			rateNds = taxBean.getNds();
			break;
		}
	}
	
	if (rateNds == null) {
		//addMsgInJournal(182, "E", -1, act, -1, -1, null, null, null, null, -1, -1, resource.intValue(), -1, idTask);
		String msg = "Не найдена ставка НДС для услуги № "+resource.intValue();
    	addMsgInJournal(idtask, "E", msg);
		throw new RemoteException("Not found rate of NDS for resource "+resource.intValue());
	}
	
	if (typeCalc.equals("1")) {
		return (localSum.multiply(rateNds)).divide(rateNds.add(new BigDecimal(100)), 2, BigDecimal.ROUND_HALF_UP);
	} else if (typeCalc.equals("2")) {
		return (localSum.multiply(rateNds)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
	}
	}catch(Exception ex){
		String msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		if((ex.getMessage() != null && !ex.getMessage().startsWith("Not found rate")) || ex.getMessage() == null){
			String msgg = "Техническая ошибка в ArendaTransactionMethodBean.calcNds";
	    	addMsgInJournal(idtask, "E", msgg);
		}
		throw new RemoteException(msg);

	}
	
	return null;
}
private void checkExistSaldo()throws RemoteException{
	//Проверяем, чтобы небыло уже сформированного сальдо на дату превышающую период акта

	pr("checkExistSaldo begin");
	//Получаем дату на один день больше чем окончание периода акта
	Calendar cal = GregorianCalendar.getInstance();
	cal.setTime(actEndDate);
	cal.add(Calendar.DAY_OF_MONTH, 1);
	Date date = cal.getTime();
	for(int i = 0; i < contracts.size(); i++){		
		try{
			LeaseSaldoAccessBean lsab = new LeaseSaldoAccessBean();
			Enumeration enum = lsab.findByLeaseContractAndResourceOrderDateAsc(
				(Integer)contracts.get(i), (Integer)resources.get(i));
			while(enum.hasMoreElements()){
				LeaseSaldoAccessBean temp = (LeaseSaldoAccessBean)enum.nextElement();
				if(temp.getSalDate().compareTo(date)>0){
					String msg = "Обнаружено сальдо на дату, превышающую период акта на один день. "
					+"Договор="+(Integer)contracts.get(i)+", услуга="+(Integer)resources.get(i)
					+", дата="+getDateString(temp.getSalDate())+". "
					+" Дата сальдо данного акта "+getDateString(date)
					+". Откат рассчета акта не возможен.";
					pr("Дата акта плюс 1 день="+getDateString(date)+". Превышающая дата ="+getDateString(temp.getSalDate()));
					addMsgInJournal(idtask, "E", msg);
					throw new RemoteException();
				}
			}
		}catch(Exception e){
				String msg = "Техническая ошибка в checkExistSaldo. Msg="+e.getMessage();
				addMsgInJournal(idtask, "E", msg);
				pr(e, "checkExistSaldo");
				throw new RemoteException();
		}
	}
	pr("checkExistSaldo end");
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 11:47:32)
 * @return boolean
 * @param idPayment java.lang.Integer
 * @param idCharge java.lang.Integer
 */
public boolean clearCharge2Pay(Handle dnop, int idtask) throws java.rmi.RemoteException{
	LeaseDNOPAccessBean ab = null;
	try{
		ab = new LeaseDNOPAccessBean(dnop.getEJBObject());
		//pr("clearCharge2Pay dnop: pay="+ab.getLeasePaymentKey().leaseDocPosition+" charge="+ab.getLeaseChargeKey().leaseDocPosition);
		int leasePayment = ab.getLeasePaymentKey().leaseDocPosition;
		int leaseCharge  = ab.getLeaseChargeKey().leaseDocPosition;
		
		LeasePaymentAccessBean lpab = ab.getLeasePayment();
		BigDecimal RURRemainder = lpab.getRurremainder().add(ab.getPayrursum());
		lpab.setRurremainder(RURRemainder);
		BigDecimal summrub = lpab.getSumRub();
		if(summrub == null){
			String msg = "Не определена рублевая сумма платежа № "+lpab.getLeaseDocPosition()
			+" Откат акта не возможен.";
			addMsgInJournal(idtask, "E", msg);
			throw new RemoteException();
		}
		if(RURRemainder.compareTo(summrub) > 0){
			lpab.setSumRub(RURRemainder);
			String msg = "При удалении связи платежей и начислений (платеж № "+ab.getLeasePaymentKey().leaseDocPosition
			+" начисление № "+ab.getLeaseChargeKey().leaseDocPosition
			+") сумма остатка платежа превысила сумму платежа";
			addMsgInJournal(idtask, "W", msg);
		}
		lpab.commitCopyHelper();

		
		LeaseChargesAccessBean lcab = ab.getLeaseCharge();
		BigDecimal remaindersum = lcab.getRemaindersum().add(ab.getChargesum());
		lcab.setRemaindersum(remaindersum);
		BigDecimal summ = lcab.getSumm();
		if(remaindersum.compareTo(summ) > 0){
			lcab.setSumm(remaindersum);
			String msg = "При удалении связи платежей и начислений (платеж № "+ab.getLeasePaymentKey().leaseDocPosition
			+" начисление № "+ab.getLeaseChargeKey().leaseDocPosition
			+") сумма остатка начисления превысила сумму начисления";
			addMsgInJournal(idtask, "W", msg);
		}
		lcab.commitCopyHelper();

		ab.getEJBRef().remove();
		
		return true;
	}catch(Exception ex){
		if(RemoveException.class.isInstance(ex) && ab != null){
			String msg = null;
			try{msg = "Не удалось удалить LeaseDnop. LeaseCharge="+ab.getLeaseChargeKey().leaseDocPosition
				+" LeasePayment="+ab.getLeasePaymentKey().leaseDocPosition;}catch(Exception e){
					msg="Ошибка при удалении LeaseDnop";}
	    	addMsgInJournal(idtask, "E", msg);
			pr(ex, msg+". clearCharge2Pay");
		} else {
			String msg = "Техническая ошибка в ArendaTransactionMethodBean.clearCharge2Pay";
	    	addMsgInJournal(idtask, "E", msg);
			pr(ex, "clearCharge2Pay");
		}
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 18:24:45)
 */
public boolean clearCharge2PayOnAktLink(Integer idAkt)throws java.rmi.RemoteException {
//1 Удаляем автоматические связи в периоде акта и производим соответствующую коррекцию остатков
    try {
        pr("clearCharge2PayOnAktLink begin");
        LeaseDNOPAccessBean ab = new LeaseDNOPAccessBean();
		Enumeration enum = ab.findByActAndSource(idAkt, "A");
		while(enum.hasMoreElements()){
			LeaseDNOPAccessBean temp = (LeaseDNOPAccessBean)enum.nextElement();
//			pr("dnop: pay="+temp.getLeasePaymentKey().leaseDocPosition+" charge="+temp.getLeaseChargeKey().leaseDocPosition);
			if(! clearCharge2Pay(temp.getEJBRef().getHandle(), idtask) )
			return false;
		}
		pr("clearCharge2PayOnAktLink end");

        return true;
    } catch (Exception ex) {       
        String msg = "Техническая ошибка в ArendaTransactionMethodBean.clearCharge2PayOnAktLink";
	    	addMsgInJournal(idtask, "E", msg);
         pr(ex, "clearCharge2PayOnAktLink(Integer idAkt)");
    }

    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2002 16:38:53)
 * @return boolean
 */
public boolean clearLeasevpayment()throws java.rmi.RemoteException{
	try{
		LeaseVPaymentAccessBean lvpab = new LeaseVPaymentAccessBean();
		Enumeration enum = lvpab.findLeaseVPaymentsByAct(new LeaseDocumentKey(act));
		while(enum.hasMoreElements())
			((LeaseVPaymentAccessBean)enum.nextElement()).getEJBRef().remove();
		
		return true;
	}catch(Exception ex){		
		String msg = "Техническая ошибка в ArendaTransactionMethodBean.clearLeasevpayment()";
	    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "clearLeasevpayment()");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 15:04:12)
 * @return boolean
 */
  // @@@ Используется не только для рассчета акта
public boolean createChargeOrPaymentOnSaldo(Integer contract,Date sldDate ,Integer resource) throws java.rmi.RemoteException{
	try{
			
		LeaseSaldoAccessBean lsab = new LeaseSaldoAccessBean();
			lsab.setInitKey_leaseContract(contract);
			lsab.setInitKey_resource_resource(resource);
			lsab.setInitKey_SalDate(new java.sql.Date(sldDate.getTime()));
			lsab.refreshCopyHelper();
			BigDecimal mainSum = lsab.getMainsum();
			int znakSum = mainSum.compareTo(getDec(0,2));
			if(znakSum >0){
				if(!_makeSaldoCharge(lsab.getEJBRef().getHandle()))
					return false;
			} else if(znakSum <0){
				if(!_makeSaldoPayment(lsab.getEJBRef().getHandle()))
					return false;
			}
			
		return true;
	}catch(Exception ex){
		if(idtask != -1){
			String msg = "Техническая ошибка в ArendaTransactionMethodBean.createChargeOrPaymentOnSaldo";
	    	addMsgInJournal(idtask, "E", msg);
		}
		pr(ex, "createChargeOrPaymentOnSaldo()");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 12:44:09)
 */
public boolean createSaldo(Integer leaseContract, Date salDate, Integer resource,
	Integer mainCurrency, BigDecimal mainSum, BigDecimal mainNdsSum,
	int additionalCurrencycode, BigDecimal additionalSum, BigDecimal additionalNdsSum)throws java.rmi.RemoteException{

	try {
		LeaseSaldoAccessBean bean = new LeaseSaldoAccessBean(
			leaseContract,
			new java.sql.Date(salDate.getTime()),
			resource,
			mainCurrency,
			mainSum,
			mainNdsSum,
			new Boolean(false)
			);
		
		if (additionalCurrencycode != 0 && (additionalSum != null || additionalNdsSum != null)) {
			CurrencyAccessBean cBean = new CurrencyAccessBean();
			cBean.setInitKey_currency(additionalCurrencycode);
			cBean.refreshCopyHelper();
			bean.setAdditionalcurrency((Currency) cBean.getEJBRef());
		} else {
			bean.setAdditionalcurrency(null);
		}
		bean.setAdditionalsum(additionalSum);
		bean.setAdditionalndssum(additionalNdsSum);
		bean.commitCopyHelper();

		return true;
	} catch (Exception ex) {
		if(idtask != -1){
			String msg = "Техническая ошибка в ArendaTransactionMethodBean.createSaldo";
	    	addMsgInJournal(idtask, "E", msg);
		}
		pr(ex, "createSaldo");					
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 12:44:09)
 */
public void createSaldoSergey(Integer leaseContract, Date salDate, Integer resource,
	Integer mainCurrency, BigDecimal mainSum, BigDecimal mainNdsSum,
	int additionalCurrencycode, BigDecimal additionalSum, BigDecimal additionalNdsSum) throws java.rmi.RemoteException {

	try {
		if(!createSaldo(
			leaseContract, salDate, resource, mainCurrency, mainSum, mainNdsSum,
				additionalCurrencycode, additionalSum, additionalNdsSum))
		throw new Exception();

		if (!createChargeOrPaymentOnSaldo(leaseContract, salDate, resource)) {
			throw new Exception();
		}
	} catch (Exception e) {
		pr(e, "createSaldoSergey");
		String msg = (e.getMessage()==null?e.getClass().getName()+" "+"No Message" : 
			e.getClass().getName()+" "+e.getMessage());
		throw new RemoteException(msg);

	}
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2002 15:47:35)
 * @return java.math.BigDecimal
 * @param idPayment java.lang.Integer
 * @exception java.lang.Exception The exception description.
 */
  // @@@ Используется не только для рассчета акта
public Object[] defineRatePaymentOnContract(Integer idPayment, Integer currency) throws java.rmi.RemoteException {
try{
	pr("defineRatePaymentOnContract");
		LeasePaymentAccessBean payBean = new LeasePaymentAccessBean();
        payBean.setInitKey_leaseDocPosition(idPayment.intValue());
        payBean.refreshCopyHelper();
	 	Integer idContract = new Integer(payBean.getLeaseContractKey().leaseDocument);

		Date billDate = null;
		try{
	        LeasePayOrderAccessBean lpoBean = new LeasePayOrderAccessBean();
	        lpoBean.setInitKey_leaseDocPosition(idPayment.intValue());
	        lpoBean.refreshCopyHelper();
	        billDate = lpoBean.getBillDate();
		}catch(Exception e){}
		
        
        Date payDate = payBean.getDate();
        Date beginDate = payBean.getBegindate();
        Date endDate = payBean.getEnddate();

        return defineRatePaymentOnContract(currency, idContract, payDate, billDate, beginDate, endDate, idPayment);
}catch(Exception ex){
		String msg = (ex.getMessage()==null?ex.getClass().getName()+" "+"No Message" : 
			ex.getClass().getName()+" "+ex.getMessage());
		pr(ex, "defineRatePaymentOnContract(2 параметра) idPayment="+idPayment+" currency="+currency);
		String msglog = "Техническая ошибка в ArendaTransactionMethodBean.defineRatePaymentOnContract(2 параметра)";
    	addMsgInJournal(idtask, "E", msglog);
		throw new RemoteException(msg);
}
	    //NamedValueAccessBean namedValue = new NamedValueAccessBean();
	    //try{        	
        	//namedValue.setInitKey_id("RUR");
        	//namedValue.refreshCopyHelper();
	    //} catch (Exception ex){
		    //addMsgInJournal(111, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
		    //return null;
	    //}

        //if (currency.intValue() == namedValue.getIntvalue()) {
            //return new Object[]{new BigDecimal(1).setScale(4, BigDecimal.ROUND_HALF_UP),
	            //new Date(System.currentTimeMillis()) };
        //}

        //LeasePaymentAccessBean payBean = new LeasePaymentAccessBean();
        //payBean.setInitKey_leaseDocPosition(idPayment.intValue());
        //payBean.refreshCopyHelper();

        //LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
        //laanBean.setInitKey_leaseDocument(payBean.getLeaseContractKey().leaseDocument);
        //laanBean.refreshCopyHelper();

        //Date dateRate = null;

        //if (laanBean.getRatecalcrule().equals("A")) {
            //LeasePayOrderAccessBean lpoBean = new LeasePayOrderAccessBean();
            //lpoBean.setInitKey_leaseDocPosition(idPayment.intValue());
            //lpoBean.refreshCopyHelper();
            //dateRate = lpoBean.getBillDate();
        //} else if (laanBean.getRatecalcrule().equals("B")) {
            //dateRate = payBean.getDate();
        //} else if (laanBean.getRatecalcrule().equals("C")) {
            //GregorianCalendar c = new GregorianCalendar();
            //c.setTime(payBean.getDate());
            //c.add(Calendar.DAY_OF_MONTH, -1);
            //dateRate = c.getTime();
        //} else if (laanBean.getRatecalcrule().equals("D")) {
            //dateRate = payBean.getEnddate();
        //} else if (laanBean.getRatecalcrule().equals("E")) {
            //dateRate = payBean.getBegindate();
        //} else if (laanBean.getRatecalcrule().equals("F")) {
            //GregorianCalendar c = new GregorianCalendar();
            //c.setTime(payBean.getBegindate());
            //c.add(Calendar.MONTH, -1);
            //c.add(Calendar.DAY_OF_MONTH, laanBean.getRatecalcruleday().intValue());
            //dateRate = c.getTime();
        //} else if (laanBean.getRatecalcrule().equals("G")) {
            //GregorianCalendar c = new GregorianCalendar();
            //c.setTime(payBean.getBegindate());

            //GregorianCalendar quarter = new GregorianCalendar();
            //quarter.clear();
            //quarter.set(c.get(Calendar.YEAR), 3, 1);
            //while (c.getTime().compareTo(quarter.getTime()) >= 0) {
                //quarter.add(Calendar.MONTH, 3);
            //}
            //quarter.add(Calendar.MONTH, -4);
            //quarter.add(Calendar.DAY_OF_MONTH, laanBean.getRatecalcruleday().intValue());
            //dateRate = quarter.getTime();
        //}

        //try{
        	//namedValue = new NamedValueAccessBean();
        	//namedValue.setInitKey_id("BASE_RATETYPE_ARENDA");
        	//namedValue.refreshCopyHelper();
        //} catch(Exception ex){
	        //addMsgInJournal(109, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
        //}

        //// Integer type, Integer currency, java.sql.Date date
        //RateAccessBean rateBean = null;
        //if(dateRate != null)
        	//rateBean = new RateAccessBean().findByTypeCurrencyForDate(
	        	//new Integer(namedValue.getIntvalue()), currency, new java.sql.Date(dateRate.getTime()));
        //else {
////int jrnAction, String jrnType, int leaseRule, int leaseDocument, 
////int leaseDocPosition, int leaseDocPosition2, Date date1, Date date2, BigDecimal summ1, BigDecimal summ2, 
////int currency1, int currency2, int resource1, int resource2	         
        	//addMsgInJournal(114, "E", -1, act, 
	        	//payBean.getLeaseDocPosition(), -1, null, null, null, null,  
	        	//currency.intValue(), -1, -1, -1);
        	//return null;
        //}

        //if(rateBean == null){
        	//addMsgInJournal(113, "E", -1, act, 
	                //payBean.getLeaseDocPosition(), -1, dateRate, null, null, null,
	                //currency.intValue(), -1, -1, -1);
        	//return null;
        //}
        ////if (rateBean.getDate().compareTo(dateRate) < 0) {
            ////GregorianCalendar now = new GregorianCalendar();
            ////now.clear(Calendar.HOUR_OF_DAY);
            ////now.clear(Calendar.MINUTE);
            ////now.clear(Calendar.SECOND);
            ////now.clear(Calendar.MILLISECOND);
            ////now.add(Calendar.DAY_OF_MONTH, -1);
            ////if (dateRate.compareTo(now.getTime()) > 0) {
                ////addMsgInJournal(113, "E", -1, act, 
	                ////payBean.getLeaseDocPosition(), -1, null, null, null, null,
	                ////currency.intValue(), -1, -1, -1);
                ////return null;
            ////} else {
	            //////addMsgInJournal(115, "W", -1, act,
		            //////payBean.getLeaseDocPosition(), -1, dateRate, rateBean.getDate(), null, null,
		            //////currency.intValue(), -1, -1, -1);
            ////}
        ////}

        //BigDecimal delta = laanBean.getRatedelta();
        //BigDecimal ratePay = null;
        //if(delta != null && 
	        //delta.compareTo(new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP)) != 0){
        //ratePay = (rateBean.getValue().multiply(  
	        //delta.add(new BigDecimal(100)))).divide(
		        //new BigDecimal(100), 4, BigDecimal.ROUND_HALF_UP);
        //ratePay = ratePay.setScale(4, BigDecimal.ROUND_HALF_UP);
	        //}
	        //else ratePay = rateBean.getValue();

        //return new Object[]{ratePay, dateRate};
    //} catch (Exception ex) {
        //pr(ex, "defineRatePaymentOnContract()");
        //addMsgInJournal(146, "E", -1, act, -1, -1, null, null, null, null, -1, -1, -1, -1 );
    //}
	//return null;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2002 15:47:35)
 * @return java.math.BigDecimal
 * @param idPayment java.lang.Integer
 * @exception java.lang.Exception The exception description.
 */
  // @@@ Используется не только для рассчета акта
public Object[] defineRatePaymentOnContract(
	Integer currency, Integer idContract, Date payDate, 
	Date billDate, Date beginDate, Date endDate, Integer payId) throws java.rmi.RemoteException {
    try {
	    
	    try{        	
	        if (currency.intValue() == getNamedValueInt("RUR", idtask)) 
	            return new Object[]{getDec(1,4),
		            new Date(System.currentTimeMillis()) };
	                	
	    } catch (Exception ex){
		    addMsgInJournal(111, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
		    return null;
	    }

		pr("defineRatePaymentOnContract 1");
        //LeasePaymentAccessBean payBean = new LeasePaymentAccessBean();
        //payBean.setInitKey_leaseDocPosition(idPayment.intValue());
        //payBean.refreshCopyHelper();

        LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
        laanBean.setInitKey_leaseDocument(idContract.intValue());
        laanBean.refreshCopyHelper();

        Date dateRate = null;

        if (laanBean.getRatecalcrule().equals("A")) {
	        if(billDate == null){
	   			String msglog = "Не определена дата платежа № "+payId;
		    	addMsgInJournal(idtask, "E", msglog);
		    	return null;
	        }
            dateRate = billDate; /////if billdate == null addmsginjournal error
            pr("defineRatePaymentOnContract 2");
        } else if (laanBean.getRatecalcrule().equals("B")) {
	        pr("defineRatePaymentOnContract 3");
            dateRate = payDate;
        } else if (laanBean.getRatecalcrule().equals("C")) {
	        pr("defineRatePaymentOnContract 4");
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(payDate);
            c.add(Calendar.DAY_OF_MONTH, -1);
            dateRate = c.getTime();
        } else if (laanBean.getRatecalcrule().equals("D")) {
	        pr("defineRatePaymentOnContract 5");
            dateRate = endDate;
        } else if (laanBean.getRatecalcrule().equals("E")) {
	        pr("defineRatePaymentOnContract 6");
            dateRate = beginDate;
        } else if (laanBean.getRatecalcrule().equals("F")) {
	        pr("defineRatePaymentOnContract 7");
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(beginDate);
            c.add(Calendar.MONTH, -1);
            c.add(Calendar.DAY_OF_MONTH, laanBean.getRatecalcruleday().intValue());
            dateRate = c.getTime();
        } else if (laanBean.getRatecalcrule().equals("G")) {
	        pr("defineRatePaymentOnContract 8");
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(beginDate);

            GregorianCalendar quarter = new GregorianCalendar();
            quarter.clear();
            quarter.set(c.get(Calendar.YEAR), 3, 1);
            while (c.getTime().compareTo(quarter.getTime()) >= 0) {
                quarter.add(Calendar.MONTH, 3);
            }
            quarter.add(Calendar.MONTH, -4);
            quarter.add(Calendar.DAY_OF_MONTH, laanBean.getRatecalcruleday().intValue()-1);
            //quarter.add(Calendar.MONTH, -3);
			//quarter.add(Calendar.DATE, -1);
            dateRate = quarter.getTime();
        } else if (laanBean.getRatecalcrule().equals("H")) {
	        pr("defineRatePaymentOnContract 9");
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(beginDate);
            c.add(Calendar.DAY_OF_MONTH, -1);
            dateRate = c.getTime();
        } else if (laanBean.getRatecalcrule().equals("I")) {
	        pr("defineRatePaymentOnContract 10");
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(endDate);
            c.add(Calendar.DAY_OF_MONTH, 1);
            dateRate = c.getTime();
        }

        //try{
        	//namedValue.setInitKey_id("BASE_RATETYPE_ARENDA");
        	//namedValue.refreshCopyHelper();
        //} catch(Exception ex){
	        //addMsgInJournal(109, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
        //}

        int paymentId = payId == null ? -1 : payId.intValue();
        
        // Integer type, Integer currency, java.sql.Date date
        RateAccessBean rateBean = null;
        if(dateRate != null)
        	rateBean = new RateAccessBean().findByTypeCurrencyForDate(
	        	new Integer(getNamedValueInt("BASE_RATETYPE_ARENDA", idtask)),
	        	currency, 
	        	new java.sql.Date(dateRate.getTime()));
        else {
	        pr("defineRatePaymentOnContract 9");
        	addMsgInJournal(114, "E", -1, act, 
	        	paymentId, -1, null, null, null, null,  
	        	currency.intValue(), -1, -1, -1);
        	return null;
        }

        if(rateBean == null){
	        pr("defineRatePaymentOnContract 10");
        	addMsgInJournal(113, "E", -1, act, 
	                paymentId, -1, dateRate, null, null, null,
	                currency.intValue(), -1, -1, -1);
        	return null;
        }

        BigDecimal delta = laanBean.getRatedelta();
        BigDecimal ratePay = null;
        if(delta != null && delta.compareTo(getDec(0,2)) != 0){
	        pr("defineRatePaymentOnContract 11");
	        ratePay = (rateBean.getValue().multiply(delta.add(new BigDecimal(100)))
	        ).divide(new BigDecimal(100), 4, BigDecimal.ROUND_HALF_UP);
	        ratePay = ratePay.setScale(4, BigDecimal.ROUND_HALF_UP);
        } else {
	        pr("defineRatePaymentOnContract 12");
	        ratePay = rateBean.getValue();
        }

        return new Object[]{ratePay, dateRate};
    } catch (Exception ex) {        
	    String params = "currency="+currency+"; idContract="+idContract+"; payDate="+payDate
			+"; billDate="+billDate+"; beginDate"+beginDate+"; endDate="+endDate+"; payId"+payId;
        pr(ex, "defineRatePaymentOnContract("+params+")");

        String msg = "Техническая ошибка в ArendaTransactionMethodBean.defineRatePaymentOnContract";
    	addMsgInJournal(idtask, "E", msg);
    }
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 15:04:12)
 * @return boolean
 */
 // @@@ Используется не только для рассчета акта
public boolean deleteChargeOrPaymentOnSaldo(Integer contract,Date sldDate ,Integer resource) throws java.rmi.RemoteException{
	try{ 
		Calendar cal = Calendar.getInstance(); 
        cal.setTime(sldDate); 
        cal.add(Calendar.DATE, 1);
        java.sql.Date date = new java.sql.Date(cal.getTime().getTime()); 
        
		LeaseDocPositionAccessBean	ldab = new LeaseDocPositionAccessBean();
		Enumeration enum = ldab.findByQBE2(contract, resource, date, "Z");
		while(enum.hasMoreElements()){
			LeasePayOrderAccessBean lpoab = null;
			LeasePaymentAccessBean lpab = null;
			LeaseChargesAccessBean lcab = null;
			Object obj = enum.nextElement();
			ldab = ((LeaseDocPositionAccessBean)obj);
			int leaseDocPosition = ldab.getLeaseDocPosition();

			try{
				lpab = new LeasePaymentAccessBean();
				lpab.setInitKey_leaseDocPosition(leaseDocPosition);
				lpab.refreshCopyHelper();
			}catch(Exception ex){lpab = null;}
			try{
				lcab = new LeaseChargesAccessBean();
				lcab.setInitKey_leaseDocPosition(leaseDocPosition);
				lcab.refreshCopyHelper();
			}catch(Exception ex){lcab = null;}
			if(lpab == null && lcab == null){
				pr("/////////////Type object is="+obj.getClass().getName());
				pr("ну что за хуйня leasedocposition="+((LeaseDocPositionAccessBean)obj).getLeaseDocPosition());
				continue;
			}

			LeaseCalcRateAccessBean lcrab = new LeaseCalcRateAccessBean();
			Enumeration rateEnum = lcrab.findLeaseCalcRatesByDocposition(
				new LeaseDocPositionKey(leaseDocPosition));
			while(rateEnum.hasMoreElements()){
				((LeaseCalcRateAccessBean)rateEnum.nextElement()).getEJBRef().remove();
				//LeaseCalcRate calcrate = (LeaseCalcRate)javax.rmi.PortableRemoteObject.narrow(
					//rateEnum.nextElement(), LeaseCalcRate.class);
				//calcrate.remove();
			}
			if(lpab != null)
				lpab.getEJBRef().remove();
			else
				lcab.getEJBRef().remove();
		}
		return true;
	}catch(Exception ex){
		if(idtask != -1){
			String msg = "Техническая ошибка в ArendaTransactionMethodBean.deleteChargeOrPaymentOnSaldo";
	    	addMsgInJournal(idtask, "E", msg);
		}
		pr(ex, "deleteChargeOrPaymentOnSaldo()");
	}
	return false;
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {

	try {
        Properties prp = getSessionContext().getEnvironment();

        String vajval = prp.getProperty("vaj");
        if (vajval != null)
            vaj = new Boolean(vajval).booleanValue();

        String debugval = prp.getProperty("debug");
        if (debugval != null)
            debug = new Boolean(debugval).booleanValue();
    } catch (Exception ex) {
        pr(ex, "Error in ArendaTransactionMethodBean.ejbActivate");
    }
}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {
	try {
        Properties prp = getSessionContext().getEnvironment();

        String vajval = prp.getProperty("vaj");
        if (vajval != null)
            vaj = new Boolean(vajval).booleanValue();

        String debugval = prp.getProperty("debug");
        if (debugval != null)
            debug = new Boolean(debugval).booleanValue();
    } catch (Exception ex) {
        pr(ex, "Error in ArendaTransactionMethodBean.ejbCreate");
    }
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {
	try{		
		if(out != null){
			out.println("----------- ejbPassivate -----------");
			out.close();
			out = null;
		}
	}catch(Exception e){
		System.out.println("((((((((((((((( Error in ArendaTransactionMethod - ejbPassivate ))))))))))))))");
	}
}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {
		try{		
		if(out != null){
			out.println("----------- ejbRemove -----------");
			out.close();
			out = null;
		}
	}catch(Exception e){
		System.out.println("((((((((((((((( Error in ArendaTransactionMethod - ejbRemove ))))))))))))))");
	}

}
private void errRemove_C_P(int leaseDocPosition) {
    try {
	    
		LeaseDocPositionKey key = new LeaseDocPositionKey(leaseDocPosition);
		LeaseDNOPAccessBean ldab = new LeaseDNOPAccessBean();
		Enumeration enum = ldab.findLeaseDNOPPayByLeasePayment(key);
		while(enum.hasMoreElements()){
			//LeaseDNOP ld = (LeaseDNOP)javax.rmi.PortableRemoteObject.narrow(
				//enum.nextElement(), LeaseDNOP.class);
			LeaseDNOPAccessBean ld = (LeaseDNOPAccessBean)enum.nextElement();
			String errmsg = "Не удалось удалить платеж № "+leaseDocPosition+" в rollbackAct."
			+" На него есть ссылка из LeaseDnop(LeasePayment="+leaseDocPosition
			+", leaseCharge="+ld.getLeaseChargeKey().leaseDocPosition
			+"source="+ld.getSource()+")";
			addMsgInJournal(idtask, "E", errmsg);
		}
		ldab = new LeaseDNOPAccessBean();
		enum = ldab.findLeaseDNOPByLeaseCharge(key);
		while(enum.hasMoreElements()){
			//LeaseDNOP ld = (LeaseDNOP)javax.rmi.PortableRemoteObject.narrow(
				//enum.nextElement(), LeaseDNOP.class);
			LeaseDNOPAccessBean ld = (LeaseDNOPAccessBean)enum.nextElement();
			String errmsg = "Не удалось удалить начисление № "+leaseDocPosition+" в rollbackAct."
			+" На него есть ссылка из LeaseDnop(=LeasePayment"+ld.getLeasePaymentKey().leaseDocPosition
			+", leaseCharge="+leaseDocPosition
			+"source="+ld.getSource()+")";
			addMsgInJournal(idtask, "E", errmsg);
		}
    } catch (Exception ex) {
	    String errmsg = "Не удалось удалить платеж или начисление № "+leaseDocPosition+" в rollbackAct";
		addMsgInJournal(idtask, "E", errmsg);
	    pr(ex, "Error in errRemove_C_P");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 15:04:12)
 * @return boolean
 */
public boolean fillUsedInAct(boolean fill) throws java.rmi.RemoteException{
    try {
        LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
        for (int i = 0; i < contracts.size(); i++) {
            Enumeration enum = lcab.findByQBE4(// Начисления по контракту
			         (Integer) contracts.get(i), 
			         new Boolean(true), new java.sql.Date(actStartDate.getTime()), 
			         new Boolean(true), new java.sql.Date(actEndDate.getTime()), 
			         new Boolean(false), null, //remaider
			         new Boolean(true), (Integer) resources.get(i), 
			         new Boolean(false), //isCalcPosOnly
			         new Integer(1) // orderByDate
				    );
            while (enum.hasMoreElements()) {
                LeaseChargesAccessBean charge = (LeaseChargesAccessBean) enum.nextElement();
                if (fill)
                    charge.setUsedinact(new Integer(act));
                else
                    charge.setUsedinact(null);
                charge.commitCopyHelper();
                
                Enumeration dnops = charge.getLeaseDNOP();
                while(dnops.hasMoreElements()){
	                LeaseDNOP dnop = (LeaseDNOP)javax.rmi.PortableRemoteObject.narrow(
		                dnops.nextElement(), LeaseDNOP.class);
                    //pr("getLeaseChargeKey"+dnop.getLeaseChargeKey().leaseDocPosition);
                    //pr("getLeaseChargeKey"+dnop.getLeasePaymentKey().leaseDocPosition);
		
	                if(fill)
	                	dnop.setUsedinact(new Integer(act));
	                else
	                	dnop.setUsedinact(null);
                }
            }
        }
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
		for(int i=0; i<contracts.size(); i++){
			Enumeration enum = lpab.findByQBE4(// Платежи по дате и контракту
				(Integer) contracts.get(i),
                new Boolean(true), new java.sql.Date(actStartDate.getTime()),
                new Boolean(true), new java.sql.Date(actEndDate.getTime()),
                new Boolean(false), null,//remaider
                new Boolean(true), (Integer) resources.get(i),//resource
                new Boolean(false),//isCalcposOnly
                new Boolean(false), new Boolean(false)//isAutoRUR
                );
			while(enum.hasMoreElements()){
				LeasePaymentAccessBean pay = (LeasePaymentAccessBean)enum.nextElement();
				if(fill)
					pay.setUsedinact(new Integer(act));
				else
					pay.setUsedinact(null);
				pay.commitCopyHelper();
				
				Enumeration dnops = pay.getLeaseDNOPPay();
				while(dnops.hasMoreElements()){
					LeaseDNOP dnop = (LeaseDNOP)javax.rmi.PortableRemoteObject.narrow(
		                dnops.nextElement(), LeaseDNOP.class);
					//pr("getLeaseChargeKey"+dnop.getLeaseChargeKey().leaseDocPosition);
		            //pr("getLeaseChargeKey"+dnop.getLeasePaymentKey().leaseDocPosition);

	                if(fill)
	                	dnop.setUsedinact(new Integer(act));
	                else
	                	dnop.setUsedinact(null);
				}
			}
		} 
        return true;
    } catch (Exception ex) {        
        try {
            String msg = "Техническая ошибка в ArendaTransactionMethodBean.fillUsedInAct";
	    	addMsgInJournal(idtask, "E", msg);          
        } catch (Exception e) {
        }
        pr(ex, "fillUsedInAct()");
   		String msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);

    }
}
public boolean freeAutoRateRurForPayment() {
    try {
        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        for (int i = 0; i < contracts.size(); i++) {
                Enumeration enum = lpab.findByQBE4(// Платежи по дате и контракту
				        (Integer) contracts.get(i),
			            new Boolean(true),  new java.sql.Date(actStartDate.getTime()),
			            new Boolean(true),  new java.sql.Date(actEndDate.getTime()),
			            new Boolean(false), null, //remaider
				        new Boolean(true), (Integer) resources.get(i), //resource
				        new Boolean(false), //isCalcposOnly
				        new Boolean(true), new Boolean(true) //isAutoRUR
					    );
                while(enum.hasMoreElements()){
	                LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
	                temp.getLeaseDocPosition();
	                if(temp.getByautorur()){
		                temp.setSumRub(null);
		                temp.setRurremainder(null);
		                temp.setNdsRub(null);
		                //temp.setByautorur(false);
		                temp.commitCopyHelper();
	                }
                }
        }
        return true;
    } catch (Exception ex) {        
            String msg = "Техническая ошибка в ArendaTransactionMethodBean.freeAutoRateRurForPayment";
	    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "freeAutoRateRurForPayment()");
    }
    return false;
}
public BigDecimal getChargeRate(Handle charge, int paramCurrency, boolean onlyRead) throws java.rmi.RemoteException{ 
    try {
	    LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(charge.getEJBObject());

		try{        	
	        if (paramCurrency == getNamedValueInt("RUR", idtask)) 
	            return getDec(1,4);
	    } catch (Exception ex){
		    addMsgInJournal(111, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
		    return null;
	    }
                
        BigDecimal readRate = null;
        boolean byHand = lcab.getByhandraterur().booleanValue();
        if (paramCurrency == lcab.getCurrencyKey().currency) {
            readRate = lcab.getRemainderrate2rur();			
            if(readRate != null) {
	            try{
		            LeaseCalcRateAccessBean lcrab = new LeaseCalcRateAccessBean();
	                lcrab.setInitKey_currency_currency(new Integer(paramCurrency));
	                lcrab.setInitKey_docposition_leaseDocPosition(new Integer(lcab.getLeaseDocPosition()));
	                lcrab.refreshCopyHelper();
	                lcrab.setRate(readRate);
	                lcrab.commitCopyHelper();	                
	            }catch(Exception e){
					_newCalcRate(lcab.getLeaseDocPosition(), paramCurrency, readRate);		            
		        }	            
            	return readRate;
            }
        } 
            try {
                LeaseCalcRateAccessBean lcrab = new LeaseCalcRateAccessBean();
                lcrab.setInitKey_currency_currency(new Integer(paramCurrency));
                lcrab.setInitKey_docposition_leaseDocPosition(new Integer(lcab.getLeaseDocPosition()));
                lcrab.refreshCopyHelper();
                readRate = lcrab.getRate();
                if(readRate != null)
                	return readRate;
            } catch (Exception ex) {
            }

        if (onlyRead) {
            if (readRate != null && readRate.compareTo(getDec(0,4)) != 0 )
                return readRate;
            else {
                addMsgInJournal(108, "E", -1, act, 
	                lcab.getLeaseDocPosition(), -1, null, null, null, null,
	                paramCurrency, -1, -1, -1);
                return null;
            }
        }

        BigDecimal rate = null;
        java.sql.Date date = null;
        Integer type, currency;
        int namedValueResource;
        RateAccessBean rab = new RateAccessBean();
        
        try {     
            type = new Integer(getNamedValueInt("BASE_RATETYPE_ARENDA", idtask));
        } catch (Exception ex) {
            addMsgInJournal(109, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
            return null;
        }
        try{
            namedValueResource = getNamedValueInt("ARENDA_RES_EQUIPMENT", idtask);
        } catch (Exception ex) {
            addMsgInJournal(110, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
            return null;
        }
        
//1-й приоритет 
        if (lcab.getDocposvid().equalsIgnoreCase("Z")) {
            if (dutyRateRule.equalsIgnoreCase("A")) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(actStartDate);
                cal.add(Calendar.DATE, -1);
                date = new java.sql.Date(cal.getTime().getTime());
            } else {
                date = new java.sql.Date(actEndDate.getTime());
            }
        } 
//2-й приоритет        
        else if (lcab.getResourceKey().resource == namedValueResource) {
            date = new java.sql.Date(lcab.getDate().getTime());
        }
//3-й приоритет        
        else if (commonRate) { 
            if (calcRateType.equalsIgnoreCase("B"))
                date = new java.sql.Date(actStartDate.getTime());
            else if (calcRateType.equalsIgnoreCase("E"))
                date = new java.sql.Date(actEndDate.getTime());
        }
//4-й приоритет        
        else if (!commonRate) {
			LeaseMutualRuleNewAccessBean lmab = new LeaseMutualRuleNewAccessBean();
	        lmab.setInitKey_reglament_leaseDocument(new Integer(reglament));
			lmab.setInitKey_resource_resource(new Integer(lcab.getResourceKey().resource));
			lmab.refreshCopyHelper();
			
            String chargeDateRule = lmab.getChargedaterule();
            if (chargeDateRule.equalsIgnoreCase("A")) {
                date = new java.sql.Date(lcab.getDate().getTime());
            } else if (chargeDateRule.equalsIgnoreCase("B")) {
                date = new java.sql.Date(actStartDate.getTime());
            } else if (chargeDateRule.equalsIgnoreCase("C")) {
                date = new java.sql.Date(actEndDate.getTime());
            }
        }

        if (date != null) {
	        try{
            	RateAccessBean rab2 = rab.findByTypeCurrencyForDate(type, new Integer(paramCurrency), date);
            	rate = rab2.getValue().setScale(4, BigDecimal.ROUND_HALF_UP);
	        } catch(Exception ex){
		         addMsgInJournal(108, "E", -1, act, 
	                lcab.getLeaseDocPosition(), -1, null, null, null, null,
	                paramCurrency, -1, -1, -1);
                return null;
	        }
        } else {
        	addMsgInJournal(112, "E", -1, act, 
	                lcab.getLeaseDocPosition(), -1, null, null, null, null,
	                paramCurrency, -1, -1, -1);
        	return null;
        }
        if (rate != null && rate.compareTo(getDec(0,4)) != 0) {
	        if (paramCurrency == lcab.getCurrencyKey().currency)
         	   _setLeaseChargesRemainderRate(charge, rate);
         	//bdv   
	        _newCalcRate(lcab.getLeaseDocPosition(), paramCurrency, rate);
        } else {
	        addMsgInJournal(108, "E", -1, act, 
	                lcab.getLeaseDocPosition(), -1, null, null, null, null,
	                paramCurrency, -1, -1, -1);
                return null;
        }
        return rate;
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в ArendaTransactionMethodBean.getChargeRate";
	    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "getChargeRate(LeaseChargesAccessBean lcab, int paramCurrency, boolean onlyRead)");
    }
    return null;
}
public BigDecimal getChargeRateTemp(Handle charge, int paramCurrency, boolean onlyRead, int idAct) throws java.rmi.RemoteException{ 
    try {
	    initial(new Integer(idAct));		
	    this.act = idAct;
	    return getChargeRate(charge, paramCurrency, onlyRead);
   } catch (Exception ex) {        
        String msg = "Техническая ошибка в ArendaTransactionMethodBean.getChargeRateTemp";
	    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "getChargeRateTemp(LeaseChargesAccessBean lcab, int paramCurrency, boolean onlyRead)");
    }
    return null;
}
private java.sql.Connection getConnection() throws Exception {

	try{
		Properties prp = new com.hps.july.jdbcpersistence.EnvironmentAccessBean().getEnvironmentProperties();

		String dsName = prp.getProperty("DATASOURCE_NAME");
		String factoryClass = prp.getProperty( "FACTORY_CLASS" );
		
		javax.naming.InitialContext ctx = null;
		Properties prop = new Properties();
		prop.put( javax.naming.Context.PROVIDER_URL, "iiop://" );
		prop.put( javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass );
		ctx = new javax.naming.InitialContext( prop );
		javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup( dsName );
		
		return ds.getConnection();
	}catch(Exception e){
		String msg = "Техническая ошибка в getConnection()";
		addMsgInJournal(idtask, "E", msg);
		pr(e, "getConnection()");
		throw new RemoteException();
	}
}
private String getDateString(Date date){
	java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("dd.MM.yyyy");
	return f.format(date);
}
private BigDecimal getDec(int value, int scale){
	return new BigDecimal(value).setScale(scale, BigDecimal.ROUND_HALF_UP);
}
private int getNamedValueInt(String namedValueId, int idtask) throws Exception {

    try {
        if (namedValueId.equals("ARENDA_RES_EQUIPMENT")) {
            if (ARENDA_RES_EQUIPMENT == null) {
	            try{
	                NamedValueAccessBean nvab = new NamedValueAccessBean();
	                nvab.setInitKey_id("ARENDA_RES_EQUIPMENT");
	                nvab.refreshCopyHelper();
	                ARENDA_RES_EQUIPMENT = new Integer(nvab.getIntvalue());
	                return ARENDA_RES_EQUIPMENT.intValue();
	            }catch(Exception e){
		            addMsgInJournal(idtask, "E", "Не найдена именованная константа ARENDA_RES_EQUIPMENT");
		            pr(e, "getNamedValueInt");
		            throw e;
	            }
            } else
                return ARENDA_RES_EQUIPMENT.intValue();
        } else if (namedValueId.equals("BASE_RATETYPE_ARENDA")) {
            if (BASE_RATETYPE_ARENDA == null) {
	            try{
	                NamedValueAccessBean nvab = new NamedValueAccessBean();
	                nvab.setInitKey_id("BASE_RATETYPE_ARENDA");
	                nvab.refreshCopyHelper();
	                BASE_RATETYPE_ARENDA = new Integer(nvab.getIntvalue());
	                return BASE_RATETYPE_ARENDA.intValue();
	            }catch(Exception e){
		            addMsgInJournal(idtask, "E", "Не найдена именованная константа BASE_RATETYPE_ARENDA");
		            pr(e, "getNamedValueInt");
		            throw e;
	            }
            } else
                return BASE_RATETYPE_ARENDA.intValue();
        } else if (namedValueId.equals("RUR")) {
	        if(RUR == null){
		        try{
		            NamedValueAccessBean nvab = new NamedValueAccessBean();
		            nvab.setInitKey_id("RUR");
		            nvab.refreshCopyHelper();
		            RUR = new Integer(nvab.getIntvalue());
		            return RUR.intValue();
		        }catch(Exception e){
		            addMsgInJournal(idtask, "E", "Не найдена именованная константа RUR");
		            pr(e, "getNamedValueInt");
		            throw e;
	            }
	        } else
	        	return RUR.intValue();
        } else if (namedValueId.equals("DEFRULECALCCHARGERURSUM")) {
	        if(DEFRULECALCCHARGERURSUM == null){
		        try{
		            NamedValueAccessBean nvab = new NamedValueAccessBean();
		            nvab.setInitKey_id("DEFRULECALCCHARGERURSUM");
		            nvab.refreshCopyHelper();
		            DEFRULECALCCHARGERURSUM = new Integer(nvab.getIntvalue());
		            return DEFRULECALCCHARGERURSUM.intValue();
		        }catch(Exception e){
		            addMsgInJournal(idtask, "E", "Не найдена именованная константа DEFRULECALCCHARGERURSUM");
		            pr(e, "getNamedValueInt");
		            throw e;
	            }
	        } else
	        	return DEFRULECALCCHARGERURSUM.intValue();
        }else if (namedValueId.equals("DEFRULEFREEACT")) {
		        try{
		            NamedValueAccessBean nvab = new NamedValueAccessBean();
		            nvab.setInitKey_id("DEFRULEFREEACT");
		            nvab.refreshCopyHelper();
		            return nvab.getIntvalue();
		        }catch(Exception e){
		            addMsgInJournal(idtask, "E", "Не найдена именованная константа DEFRULEFREEACT");
		            pr(e, "getNamedValueInt");
		            throw e;
	            }
        } else
            throw new Exception("Unknown name for named value "+namedValueId);

    } catch (Exception ex) {
        pr(ex, "getNamedValue");
        throw ex;
    }
}
private BigDecimal getPaymentRate(LeasePaymentAccessBean lpab, int inCurrency, boolean readOnly) throws java.rmi.RemoteException{
// Определяет курс платежа в другую валюту
    try {

		try{        	
   	        if (inCurrency == getNamedValueInt("RUR", idtask))
	            return getDec(1,4);
	    } catch (Exception ex){
		    pr("getPaymentRate 0");
		    addMsgInJournal(111, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
		    return null;
	    }
	    
        BigDecimal payRate = null;
        try {
            LeaseCalcRateAccessBean lcrab = new LeaseCalcRateAccessBean(); 
            lcrab.setInitKey_currency_currency(new Integer(inCurrency));
            lcrab.setInitKey_docposition_leaseDocPosition(new Integer(lpab.getLeaseDocPosition()));
            lcrab.refreshCopyHelper();
            return payRate = lcrab.getRate();
        } catch (Exception ex) {}

        pr("getPaymentRate 01");

        if ((readOnly && payRate == null) ) {
	        pr("getPaymentRate 02");
	       	String msg = "В акте "+act+" не найден курс для платежа "+lpab.getLeaseDocPosition()
	       	+" для валюты "+inCurrency;
	        addMsgInJournal(idtask, "E", msg);
	        pr("getPaymentRate 022");
            return null;
        } else if(readOnly && payRate.compareTo(getDec(0,4)) == 0){
	        pr("getPaymentRate 03");
	        String msg = "В акте "+act+" не найден курс для платежа "+lpab.getLeaseDocPosition()
	       	+" для валюты "+inCurrency;
	        addMsgInJournal(idtask, "E", msg);	
            return null;
        }
        
        Integer type = null;
        try {
            type = new Integer(getNamedValueInt("BASE_RATETYPE_ARENDA", idtask));
        } catch (Exception ex) {
	        pr("getPaymentRate 004");
            addMsgInJournal(109, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
            return null;
        }

        pr("getPaymentRate 04");
        int payResource = lpab.getResourceKey().resource;
        int payCurrency = lpab.getCurrencyKey().currency;
        int namedValueResource;
        try{
        	namedValueResource = getNamedValueInt("ARENDA_RES_EQUIPMENT", idtask);
        }catch(Exception ex){
	        pr("getPaymentRate 05");
	        addMsgInJournal(110, "E", -1, -1, -1, -1, null, null, null, null, -1, -1, -1, -1);
	        return null;
        }

        BigDecimal rate = null;
        // 1 приоритет		
        if (lpab.getDocposvid().equals("Z")) {
	         pr("getPaymentRate 1 приоритет");
            java.sql.Date date;
            if (dutyRateRule.equalsIgnoreCase("A")) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(actStartDate);
                cal.add(Calendar.DATE, -1);
                date = new java.sql.Date(cal.getTime().getTime());
            } else {
                date = new java.sql.Date(actEndDate.getTime());
            }
            RateAccessBean rab = new RateAccessBean();
            try{
            	RateAccessBean rab2 = rab.findByTypeCurrencyForDate(type, new Integer(inCurrency), date);
            	rate = rab2.getValue();
            	if(rate != null)
            		rate = rate.setScale(4, BigDecimal.ROUND_HALF_UP);
            }catch(Exception e){
	            pr("getPaymentRate 06");
	            addMsgInJournal(idtask, "E", "Не найден rate для платежа "+lpab.getLeaseDocPosition()+
		            "по типу платежа BASE_RATETYPE_ARENDA на дату "+date);
	            pr(e, "getPaymentRate.RateAccessBean rab2 = rab.findByTypeCurrencyForDate");
	            return null;
            }            
        }
        // 2 приоритет				
        else if (payResource == namedValueResource) {
	        pr("getPaymentRate 2 приоритет");
            if (payCurrency == inCurrency){
                rate = lpab.getPayrate();
                if(rate != null)
                	rate = rate.setScale(4, BigDecimal.ROUND_HALF_UP);
            }
            else {
                Object[] obj = defineRatePaymentOnContract(
	                new Integer(lpab.getLeaseDocPosition()), 
	                new Integer(inCurrency));
                if(obj == null)
                	return null;
	            rate = ((BigDecimal)obj[0]).setScale(4, BigDecimal.ROUND_HALF_UP);
            }
        } 
        // 3 приоритет
        else if (commonRate) {
	         pr("getPaymentRate 3 приоритет");
            java.sql.Date date;
            if (calcRateType.equalsIgnoreCase("B")) {
                date = new java.sql.Date(actStartDate.getTime());
            } else {
                date = new java.sql.Date(actEndDate.getTime());
            }
            RateAccessBean rab = new RateAccessBean();
            try{
	            RateAccessBean rab2 = rab.findByTypeCurrencyForDate(type, new Integer(inCurrency), date);
	            rate = rab2.getValue();
	            if(rate != null)
	            	rate = rate.setScale(4, BigDecimal.ROUND_HALF_UP);
            }catch(Exception e){	
	            pr("getPaymentRate 0003"); 
	            addMsgInJournal(idtask, "E", "Не найден rate для платежа "+lpab.getLeaseDocPosition()+
		            "по типу платежа BASE_RATETYPE_ARENDA на дату "+date);
	            pr(e, "getPaymentRate.RateAccessBean rab2 = rab.findByTypeCurrencyForDate");
	            return null;
            }
        }
        // 4 приоритет
        else if (!commonRate) {
         pr("getPaymentRate 4 приоритет");
         LeaseMutualRuleNewAccessBean lmab = null;
         try{
            lmab = new LeaseMutualRuleNewAccessBean();
            lmab.setInitKey_reglament_leaseDocument(new Integer(reglament));
            lmab.setInitKey_resource_resource(new Integer(payResource));
            lmab.refreshCopyHelper();
         }catch(Exception e){
	         pr(e, "Не найден LeaseMutualRule по регламенту "+reglament+" и ресурсу "+payResource);
	         addMsgInJournal(idtask, "E", "Не найден LeaseMutualRule по регламенту "+reglament+
			            " и ресурсу "+payResource);	
	         return null; 
         }
            String payDateRule = lmab.getPaydaterule();
            if (payDateRule.equalsIgnoreCase("A")) {
	            pr("getPaymentRate 4 приоритет   payDateRule.equalsIgnoreCase('A')");
                //rate = lpab.getPayrate().setScale(4, BigDecimal.ROUND_HALF_UP);
                rate = lpab.getPayrate();
                if(rate != null)
                	rate = rate.setScale(4, BigDecimal.ROUND_HALF_UP);
                if (rate != null && inCurrency == lpab.getCurrencyKey().currency) {
	                //Не меняем 
                } else {
	                Object[] obj = defineRatePaymentOnContract(
	                    new Integer(lpab.getLeaseDocPosition()), 
	                    new Integer(inCurrency));
	                if(obj == null) 
	                	return null;
	                rate = ((BigDecimal)obj[0]).setScale(4, BigDecimal.ROUND_HALF_UP);
                }
            } else if (payDateRule.equalsIgnoreCase("B")) {
	            pr("getPaymentRate 4 приоритет   payDateRule.equalsIgnoreCase('B')");
                java.sql.Date date = new java.sql.Date(actStartDate.getTime());
                RateAccessBean rab = new RateAccessBean();
                try{
	                RateAccessBean rab2 = rab.findByTypeCurrencyForDate(type, new Integer(inCurrency), date);
	                rate = rab2.getValue();
	                if(rate != null)
	                	rate = rate.setScale(4, BigDecimal.ROUND_HALF_UP);
                }catch(Exception e){	
	                pr("getPaymentRate 0004"); 
		            addMsgInJournal(idtask, "E", "Не найден rate для платежа "+lpab.getLeaseDocPosition()+
			            "по типу платежа BASE_RATETYPE_ARENDA на дату "+date);
		            pr(e, "getPaymentRate.RateAccessBean rab2 = rab.findByTypeCurrencyForDate");
	 	           return null;
   		        }
            } else if (payDateRule.equalsIgnoreCase("C")) {
	            pr("getPaymentRate 4 приоритет   payDateRule.equalsIgnoreCase('C')");
                java.sql.Date date = new java.sql.Date(actEndDate.getTime());
                RateAccessBean rab = new RateAccessBean();
                try{
	                RateAccessBean rab2 = rab.findByTypeCurrencyForDate(type, new Integer(inCurrency), date);
	                rate = rab2.getValue();
	                if(rate != null)
	                	rate = rate.setScale(4, BigDecimal.ROUND_HALF_UP);
	            }catch(Exception e){	
		            pr("getPaymentRate 0005"); 
		            addMsgInJournal(idtask, "E", "Не найден rate для платежа "+lpab.getLeaseDocPosition()+
			            "по типу платежа BASE_RATETYPE_ARENDA на дату "+date);
		            pr(e, "getPaymentRate.RateAccessBean rab2 = rab.findByTypeCurrencyForDate");
		            return null;
	            }
            }
        }

        pr("getPaymentRate rate="+rate);
        if (rate != null && rate.compareTo(getDec(0,4)) != 0) {
	        pr("getPaymentRate 0006");
            //BigDecimal sum = lpab.getSumRub().divide(rate, 2, BigDecimal.ROUND_HALF_UP);
            LeaseCalcRateAccessBean lcrab = 
            	new LeaseCalcRateAccessBean(
	            	new Integer(lpab.getLeaseDocPosition()),
	            	new Integer(inCurrency),
	            	rate.abs(),
	            	new Boolean(false)
	            	);
            return rate;
        } else {
	        pr("getPaymentRate 0007");
            addMsgInJournal(113, "E", -1, act, 
	                lpab.getLeaseDocPosition(), -1, null, null, null, null,
	                inCurrency, -1, -1, -1);
            return null;
        }

    } catch (Exception ex) {        
        String msg = "Техническая ошибка в ArendaTransactionMethodBean.getPaymentRate";
	    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "getPaymentRate");
    }
    return null;
}
public BigDecimal getPaymentRate(Handle payment, int inCurrency, boolean readOnly, Integer actid, boolean otherUser) throws java.rmi.RemoteException{
// Определяет курс платежа в другую валюту  otherUser для вызова из BillingRequiredNew.movePayOnAktNri2BufferNri
    try {
	    if(otherUser){
		    act = actid.intValue();

		    String operatorName = mySessionCtx.getCallerIdentity().getName();
			int index = operatorName.indexOf("/");
			int operator;
			if(index != -1){
				operatorName = operatorName.substring(index+1);
				operator = new OperatorAccessBean().findByLogin(operatorName).getOperator();
			} else {
				operator = new OperatorAccessBean().findByLogin(operatorName).getOperator();
			}		    
		    taskStart(operator, "7");
	    }
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean(payment.getEJBObject());
		return getPaymentRate(lpab, inCurrency, readOnly);
    } catch (Exception ex) {        
        //addMsgInJournal(149, "E", -1, act, -1, -1, null, null, null, null, -1, -1, -1, -1 );
        String msg = "Техническая ошибка в ArendaTransactionMethodBean.getPaymentRate(Handle payment, int inCurrency, boolean readOnly, Integer actid)";
	    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "getPaymentRate");
    }
    return null;
}
public BigDecimal getPaymentRateTemp(Handle payment, int inCurrency, boolean readOnly, int idAct)throws java.rmi.RemoteException {
// Определяет курс платежа в другую валюту
    try {
		initial(new Integer(idAct));		
	    this.act = idAct;
	    return getPaymentRate(payment, inCurrency, readOnly, new Integer(idAct), false);
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в ArendaTransactionMethodBean.getPaymentRateTemp";
	    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "getPaymentRateTemp");
    }
    return null;
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
private java.sql.Date getSqldate(java.util.Date date){
	return new java.sql.Date(date.getTime());
}
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 17:07:54)
 * @param idAct java.lang.Integer
 Получаем дату начала акта и получаем список контрактов и услуг, и позиции документов
 */
private boolean initial(Integer idAct) {  

RUR = null;
BASE_RATETYPE_ARENDA = null;
ARENDA_RES_EQUIPMENT = null;
DEFRULECALCCHARGERURSUM = null;
actStartDate = null;
actEndDate = null;
contracts = null;
resources = null;
contractsUnic = null;
dutyRateRule = null;
commonRate = false;
calcRateType = null;
reglament = -1;
act = -1;
mainCurrency = -1;
reglamentState = null;
additionalCurrency = null;
keyGen = null;
mutualAct = null;

//idtask = -1;

isTempact = false;

    try { 
	    act=idAct.intValue();
	    contracts = new ArrayList();
		resources = new ArrayList();
		contractsUnic = new ArrayList();
	    act = idAct.intValue();
        mutualAct = new LeaseMutualActNewAccessBean();
        mutualAct.setInitKey_leaseDocument(idAct.intValue());
        mutualAct.refreshCopyHelper();
        actStartDate = mutualAct.getActstartdate();
        actEndDate = mutualAct.getActenddate();
        isTempact = mutualAct.getIstemp();
        
        LeaseMutualReglamentAccessBean lmab = mutualAct.getLeaseMutualReglament();
        reglamentState = lmab.getMutState();
        dutyRateRule = lmab.getDutyraterule();
        calcRateType = lmab.getCalcRateType();
        reglament = lmab.getLeaseDocument();
        commonRate = lmab.getCommonRate().booleanValue();
        mainCurrency = lmab.getMaincurrencyKey().currency;

        try{
        	additionalCurrency = new Integer(lmab.getAdditionalCurrencyKey().currency);
        }catch(Exception ex){}
        Enumeration enum = mutualAct.getLeaseMutualReglament().getLeaseMutualContracts();
        while(enum.hasMoreElements()){
	        LeaseMutualContracts temp = (LeaseMutualContracts)javax.rmi.PortableRemoteObject.narrow(
		        enum.nextElement(), LeaseMutualContracts.class);
	        contracts.add(new Integer(temp.getContractKey().leaseDocument));//Контракты
	        resources.add(new Integer(temp.getResourceKey().resource));//Услуги

	        if(!contractsUnic.contains(new Integer(temp.getContractKey().leaseDocument)))
	        	contractsUnic.add(new Integer(temp.getContractKey().leaseDocument));
        }

        keyGen = new KeyGeneratorAccessBean();

        isInit = true;
        return true;
    } catch (Exception ex) {
        pr(ex, "initial(Integer idAct)");
        String msg = "Техническая ошибка в ArendaTransactionMethodBean.initial";
	    	addMsgInJournal(idtask, "E", msg);
    }
    return false;
}
public boolean needDelite_setLeaseDnopChargeRURSum(Handle dnop) throws java.rmi.RemoteException{
	try{
		LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean(dnop.getEJBObject());
		
		BigDecimal chargesum = dnab.getChargesum();
		BigDecimal chargeRURRate = dnab.getChargerurrate();
		BigDecimal сhargeRURSum = chargesum.multiply(chargeRURRate).setScale(2, BigDecimal.ROUND_HALF_UP);
		dnab.setChargerursum(сhargeRURSum);
		dnab.commitCopyHelper();

		return true;
	}catch(Exception ex){		
		addMsgInJournal(140, "E", -1, act, -1, -1, null, null, null, null, -1, -1, -1, -1 );
		pr(ex, "_setLeaseDnopChargeRURSum");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2002 19:16:25)
 * @param lcab com.hps.july.persistence.LeaseChargesAccessBean
 * @exception java.lang.Exception The exception description.
 */
public boolean needDelite_setLeaseDnopRate(Handle dnop, BigDecimal rate) throws java.rmi.RemoteException{
	try{
		LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean(dnop.getEJBObject());
		
		dnab.setChargerurrate(rate);
		dnab.commitCopyHelper();
		return true;
	}catch(Exception ex){		
		addMsgInJournal(141, "E", -1, act, -1, -1, null, null, null, null, -1, -1, -1, -1 );
		pr(ex, "_setLeaseDnopRate");
	}
	return false;
}
void pr(Exception ex, String str) {

    if (!vaj) {
        if (!debug){
	        if(str != null) System.out.println(str);
	        if(ex != null) ex.printStackTrace(System.out);
	        return;
        }
        try {
	        String path;
	        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
	        if(isWindows){
		        path = "C:\\calcact.log";
	        } else {
		        path = "/opt/WebSphere/AppServer/logs/calcact/calcact.log";
	        }
            if (out == null) {
	            if(!isWindows){
                	new File("/opt/WebSphere/AppServer/logs/calcact").mkdir();
	            }
                try {
                    out =new PrintWriter(new BufferedWriter(
                                new FileWriter(path, true)));
                } catch (Exception e) {
                }
            }
            if (out == null) {
                System.out.println("(((((((( Can't create PrintWriter for calcAct )))))))))");
                return;
            }
            //out.println("_________________________________________________");
            //out.println(new java.util.Date());

            if (str != null && ex != null)
                out.println( ex.getClass().getName() + " in " + this.getClass().getName()
                        + "." + str + ". Message is:" + ex.getMessage());
            else if (str != null)
                out.println(this.getClass().getName() + "." + str);

            if (ex != null)
                ex.printStackTrace(out);

            //out.println("_________________________________________________");
            out.flush();
        } catch (Exception e) {
            System.out.println("((((((( Error in debug )))))))))");
        }
    } else {
        //System.out.println("_________________________________________________");
        System.out.println(new java.util.Date());
        if (ex != null)
            System.out.println(ex.getClass().getName() + " in " + this.getClass().getName()
                    + "." + str + ". Message is:" + ex.getMessage());
        else
            System.out.println(this.getClass().getName() + "." + str);
        //System.out.println("_________________________________________________");
    }
}
void pr(String str) {
	pr(null, str);
}
private void printCharge(LeaseChargesAccessBean lcab)throws Exception {
	pr("Start print LeaseChargesAccessBean");
	try{pr("currency="+lcab.getCurrencyKey().currency);}catch(Exception e){}
	try{pr("Docposvid="+lcab.getDocposvid());}catch(Exception e){}
	try{pr("LeaseContract="+lcab.getLeaseContractKey().leaseDocument);}catch(Exception e){}
	try{pr("LeaseDocPosition="+lcab.getLeaseDocPosition());}catch(Exception e){}
	try{pr("Remainderrate2rur="+lcab.getRemainderrate2rur());}catch(Exception e){}
	try{pr("Remaindersum="+lcab.getRemaindersum());}catch(Exception e){}
	try{pr("resource="+lcab.getResourceKey().resource);}catch(Exception e){}
	try{pr("Source="+lcab.getSource());}catch(Exception e){}
	try{pr("Summ="+lcab.getSumm());}catch(Exception e){}
	try{pr("Sumnds="+lcab.getSumnds());}catch(Exception e){}
	try{pr("Usedinact"+lcab.getUsedinact());	}catch(Exception e){}
	pr("Stop print LeaseChargesAccessBean");
}
private void printDnop(LeaseDNOPAccessBean dn)throws Exception {
	pr("Start print LeaseDnopAccessBean");
	try{pr("ChargeKey="+dn.getLeaseChargeKey().leaseDocPosition);}catch(Exception e){}
	try{pr("PaymentKey="+dn.getLeasePaymentKey().leaseDocPosition);}catch(Exception e){}
	try{pr("ActKey="+dn.getActKey().leaseDocument);}catch(Exception e){}
	try{pr("Byhandchangeraterur="+dn.getByhandchangeraterur());}catch(Exception e){}
	try{pr("Chargerurrate="+dn.getChargerurrate());}catch(Exception e){}
	try{pr("Chargerursum="+dn.getChargerursum());}catch(Exception e){}
	try{pr("Chargesum="+dn.getChargesum());}catch(Exception e){}
	try{pr("Payrursum="+dn.getPayrursum());}catch(Exception e){}
	try{pr("Source="+dn.getSource());}catch(Exception e){}
	try{pr("Usedinact="+dn.getUsedinact());}catch(Exception e){}
	pr("Stop print LeaseDnopAccessBean");
}
private void printPay(LeasePaymentAccessBean lpab)throws Exception {
	pr("Start print LeasePaymentAccessBean");
	try{pr("act="+lpab.getAct().getLeaseDocument());}catch(Exception e){}
	try{pr("currency="+lpab.getCurrencyKey().currency);}catch(Exception e){}
	try{pr("docposvid="+lpab.getDocposvid());}catch(Exception e){}
	try{pr("contract"+lpab.getLeaseContractKey().leaseDocument);}catch(Exception e){}
	try{pr("LeaseDocPosition="+lpab.getLeaseDocPosition());}catch(Exception e){}
	try{pr("Summ="+lpab.getSumm());}catch(Exception e){}
	try{pr("Sumnds="+lpab.getSumnds());}catch(Exception e){}
	try{pr("SumRub="+lpab.getSumRub());}catch(Exception e){}
	try{pr("Rurremainder="+lpab.getRurremainder());}catch(Exception e){}
	try{pr("Usedinact="+lpab.getUsedinact());}catch(Exception e){}
	try{pr("resource="+lpab.getResourceKey().resource);}catch(Exception e){}
	try{pr("Source="+lpab.getSource());}catch(Exception e){}
	try{pr("Payrate="+lpab.getPayrate());}catch(Exception e){}
	try{pr("NdsRub="+lpab.getNdsRub());}catch(Exception e){}
	pr("Stop print LeasePaymentAccessBean");
}
private void processEx(Exception ex) {
    if (!(ex instanceof RemoteException) && !(ex instanceof EJBException) && !(ex instanceof RuntimeException))
        mySessionCtx.setRollbackOnly();


    	try{
    if (ex instanceof java.rmi.ServerException) {
        if (((java.rmi.ServerException) ex).detail instanceof com.ibm.ejs.persistence.EJSPersistenceException) {
            if (((com.ibm.ejs.persistence.EJSPersistenceException)
	            (((java.rmi.ServerException) ex).detail)).detail instanceof java.sql.SQLException) {
                int code = ((java.sql.SQLException) (((com.ibm.ejs.persistence.EJSPersistenceException)
	                (((java.rmi.ServerException) ex).detail)).detail)).getErrorCode();
                pr("Error code = " + code);
            }
        } else if (((java.rmi.ServerException)ex).detail instanceof com.ibm.websphere.cpi.CPIException) {
            if (((com.ibm.websphere.cpi.CPIException) 
	            (((java.rmi.ServerException)ex).detail)).detail instanceof java.sql.SQLException) {
                int code = ((java.sql.SQLException) (((com.ibm.websphere.cpi.CPIException)
	                (((java.rmi.ServerException)ex).detail)).detail)).getErrorCode();
                pr("Error code = " + code);
            }
        }
    }
    	}catch(Exception exx){pr(exx, "processEx");}
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 15:04:12)
 * @return boolean
 */
public boolean removeSaldo(Integer contract,Date sldDate ,Integer resource)throws java.rmi.RemoteException {
	try{
		LeaseSaldoAccessBean lsab = new LeaseSaldoAccessBean();
			lsab.setInitKey_leaseContract(contract);
			lsab.setInitKey_resource_resource(resource);
			lsab.setInitKey_SalDate(new java.sql.Date(sldDate.getTime()));
			lsab.refreshCopyHelper();

			lsab.getEJBRef().remove();
			
		return true;
	}catch(Exception ex){		
		String msg = "Техническая ошибка в ArendaTransactionMethodBean.removeSaldo";
	    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "removeSaldo()");
	}
	return false;
}
public boolean rollbackCalcAct(int act) throws java.rmi.RemoteException{
	pr("(((((((((((((((((( rollbackCalcAct started  )))))))))))))))))))))");
    try {
	    this.act = act;
	    //////this.idtask = idtask;
	    if(!initial(new Integer(act)))
	    	return false;
	    	    	
        if (!clearCharge2PayOnAktLink(new Integer(act)))
            return false;      
// Удаляем все посчитанные курсы платежей/начислений,
//кроме тех что были установлены вручную.
// За интервал акта и за дату сформированного сальдо
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(actEndDate);
		cal.add(Calendar.DATE, 1);
		long time = cal.getTime().getTime();
		
		ArrayList leaseDocPositions = new ArrayList();
		for(int i=0; i<contracts.size(); i++){
			LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
			LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();

        	Enumeration enum = lcab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), //startDate
	        	new Boolean(true), new java.sql.Date(time),//endDate
	        	new Boolean(false), null,//reminder
	        	new Boolean(true), (Integer)resources.get(i),
	            new Boolean(false),//isCalcPosOnly source = 'A' AND + docposvid IN ('Q', 'K', 'Z') 
	            new Integer(1)// orderByDate
	        	);
        	while(enum.hasMoreElements()){
	        	LeaseChargesAccessBean temp = (LeaseChargesAccessBean)enum.nextElement();
	        	leaseDocPositions.add(new Integer(temp.getLeaseDocPosition()));
        	}

	        enum = lpab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), //startDate
	        	new Boolean(true), new java.sql.Date(time),//endDate
	        	new Boolean(false), null,//reminder
	        	new Boolean(true), (Integer)resources.get(i),
	        	new Boolean(false),//isCalcPosOnly source = 'A' AND + docposvid IN ('Q', 'K', 'Z') 
	        	new Boolean(false), new Boolean(false)//isAutoRUR
	        	);
	        while(enum.hasMoreElements()){
		        LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
		        leaseDocPositions.add(new Integer(temp.getLeaseDocPosition()));
	        }
		}
		
        LeaseCalcRateAccessBean lcrab= new LeaseCalcRateAccessBean(); 
        for(int i=0; i<leaseDocPositions.size(); i++){
	        Enumeration enum = lcrab.findBy_Hand_LeaseDocPosition("N", (Integer)leaseDocPositions.get(i));
			while(enum.hasMoreElements()){
				LeaseCalcRateAccessBean lcr = (LeaseCalcRateAccessBean)enum.nextElement();
				String errmsg = "Удаляем LeaseCalcRate в rollbackCalcAct. leaseDocPosition="+lcr.getDocpositionKey().leaseDocPosition	
					+" currency="+lcr.getCurrencyKey().currency;
				pr(errmsg);
				try{
					lcr.getEJBRef().remove();
				}catch(Exception e){
					addMsgInJournal(idtask, "E", "Не удалось удалить LeaseCalcRate в rollbackAct. "+errmsg);
					throw (RemoteException)e;
				}
			}
        }
pr("=1=");
// Удаляем фиктивные начисления и платежи по акту
		boolean error = false;
        for(int i=0; i<contracts.size(); i++){
       		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
			LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
			ArrayList ar = new ArrayList();

        	Enumeration enum = lpab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), 
	        	new Boolean(false), null,    //actEndDate
	        	new Boolean(false), null,
	        	new Boolean(true), (Integer)resources.get(i),
	        	new Boolean(true),//isCalcPosOnly
	        	new Boolean(false), new Boolean(false)
	        	);
        	while(enum.hasMoreElements()){
	        	ar.add(enum.nextElement());
	        	//LeasePaymentAccessBean t = ((LeasePaymentAccessBean)enum.nextElement());
	        	//int position = t.getLeaseDocPosition();
	        	//if(!(t.getDocposvid().equalsIgnoreCase("Z") && t.getDate().compareTo(actStartDate) == 0))
        			//t.getEJBRef().remove();
        	}
        	enum = lcab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), 
	        	new Boolean(false), null,
	        	new Boolean(false), null,
	        	new Boolean(true), (Integer)resources.get(i),
	            new Boolean(true),//isCalcPosOnly
	            new Integer(1)// orderByDate
				);
        	while(enum.hasMoreElements())
	        	ar.add(enum.nextElement());
	        System.out.println("contract="+(Integer)contracts.get(i)+"\tresource="+(Integer)resources.get(i));
	        for(int j=0; j<ar.size(); j++){
		        Object obj = ar.get(j);
		        LeaseDocPositionAccessBean t = null; 
		        if(obj instanceof LeaseChargesAccessBean)
		        	t = new LeaseDocPositionAccessBean(((LeaseChargesAccessBean)obj).getEJBRef());
		        else
		        	t = new LeaseDocPositionAccessBean(((LeasePaymentAccessBean)obj).getEJBRef());
		        	
	        	int position = t.getLeaseDocPosition();
	        	System.out.println("\t\tposition="+position);
	        	if (
		        	/*Нельзя удалять начисления и платежис признаклм "Z" и с датой равной дате начала акта,
		        	т.к. они сформированы предыдущим актом*/
	        	   (!(t.getDocposvid().equalsIgnoreCase("Z") && t.getDate().compareTo(actStartDate) == 0))){
        				try{
	        				//t.getEJBRef().remove();!!!!!!!!!!!!!!!!
        				}catch(Exception e){
	        				//String errmsg = "Не удалось удалить платеж или начисление № "+position+" в rollbackAct";
	        				//addMsgInJournal(idtask, "E", errmsg);
	        				errRemove_C_P(position);
	        				error = true;
        				}
	        	   }
	        }
        	//while(enum.hasMoreElements()){
	        	//LeaseChargesAccessBean t = ((LeaseChargesAccessBean)enum.nextElement());
	        	//int position = t.getLeaseDocPosition();
	        	//if (t.getDocposvid().equalsIgnoreCase("Q") || t.getDocposvid().equalsIgnoreCase("K")   &&
		        	///*Нельзя удалять начисления и платежис признаклм "Z" и с датой равной дате начала акта,
		        	//т.к. они сформированы предыдущим актом*/
	        	   //(!(t.getDocposvid().equalsIgnoreCase("Z") && t.getDate().compareTo(actStartDate) == 0)))
        			//t.getEJBRef().remove();
        			
        	//}
        }
        if(error)
        	throw new RemoteException();

        //Удаляем сальдо
pr("=2=");
		LeaseSaldoAccessBean lsab = new LeaseSaldoAccessBean();
		Enumeration enum = lsab.findLeaseSaldosByAct(new LeaseDocumentKey(act));
		while(enum.hasMoreElements()){
			LeaseSaldoAccessBean lsab2 = ((LeaseSaldoAccessBean)enum.nextElement());
			try{
				lsab2.getEJBRef().remove();
			}catch(Exception e){
				String errmsg = "Не удалось удалить сальдо. Contract= "+lsab2.getLeaseContract()
				+" salDate="+lsab2.getSalDate()+" resource="+lsab2.getResourceKey().resource+" в rollbackAct";
   				addMsgInJournal(idtask, "E", errmsg);
				throw (RemoteException)e;
			}
		}
pr("=3=");
// Перевести акт в состояние редактируется			
		mutualAct.setActState("O");
		mutualAct.commitCopyHelper();

// Проставить в таблице LeaseDNOP, LeaseDocPosition act=null where act=idAct 
		LeaseDNOPAccessBean ldnab = new LeaseDNOPAccessBean();
		enum = ldnab.findLeaseDNOPsByAct(new LeaseDocumentKey(act));
		while(enum.hasMoreElements()){
			LeaseDNOPAccessBean temp = (LeaseDNOPAccessBean)enum.nextElement();
			temp.setAct(null);
			temp.commitCopyHelper();
		}
		LeaseDocPositionAccessBean ldab = new LeaseDocPositionAccessBean();
		enum = ldab.findLeaseDocPositionsByAct(new LeaseDocumentKey(act));
		while(enum.hasMoreElements()){
			LeaseDocPositionAccessBean temp = (LeaseDocPositionAccessBean)enum.nextElement();
			temp.setAct(null);
			temp.commitCopyHelper();
		}
pr("=4=");
		if(!clearLeasevpayment()) return false;
pr("=5=");

		for(int i=0; i<contracts.size(); i++){
			LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
        	enum = lcab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), 
	        	new Boolean(true), new java.sql.Date(actEndDate.getTime()),
	        	new Boolean(false), null,
	        	new Boolean(true), (Integer)resources.get(i),
	            new Boolean(false),//isCalcPosOnly
	            new Integer(1)// orderByDate
	        	);
        	while(enum.hasMoreElements()){
	        	LeaseChargesAccessBean temp = (LeaseChargesAccessBean)enum.nextElement();
	        	if(temp.getByhandraterur().equals(new Boolean(false)))
		        	temp.setRemainderrate2rur(null);
		        	temp.commitCopyHelper();
        	}
		}
pr("=6=");
		
		fillUsedInAct(false);
		freeAutoRateRurForPayment();
		taskEnd();
		pr("(((((((((((((((((( rollbackCalcAct ended  )))))))))))))))))))))");
        return true;
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
        //addMsgInJournal(100, "E", -1, act, -1, -1, actStartDate, actEndDate, null, null, -1, -1, -1, -1);
        addMsgInJournal(idtask, "E", "Техническая ошибка в rollbackCalcAct");
        pr(ex, "rollbackCalcAct");
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 17:08:34)
 * @return boolean
 * @param idAkt java.lang.Integer
 */
  // @@@ Используется не только для рассчета акта
public boolean rollbackCalcAct(Integer idAct) throws java.rmi.RemoteException{
	
    try {
	    this.act = idAct.intValue();
	    if(!initial(idAct))
	    	return false;
	    
	    if(taskStart(1, "5", null, null, null, idAct) == -1) return false;
	    return rollbackCalcAct(idAct, idtask);
/*	    
        if (!clearCharge2PayOnAktLink(idAct))
            return false;        

// Удаляем все посчитанные курсы платежей, начислений кроме тех что были установлены вручную.
// За интервал акта и за дату сформированного сальдо
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(actEndDate);
		cal.add(Calendar.DATE, 1);
		long time = cal.getTime().getTime();
		
		ArrayList leaseDocPositions = new ArrayList();
		for(int i=0; i<contracts.size(); i++){
			LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
			LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();

        	Enumeration enum = lcab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), //startDate
	        	new Boolean(true), new java.sql.Date(time),//endDate
	        	new Boolean(false), null,//reminder
	        	new Boolean(true), (Integer)resources.get(i),
	            new Boolean(false),//isCalcPosOnly source = 'A' AND + docposvid IN ('Q', 'K', 'Z') 
	            new Integer(1)// orderByDate
	        	);
        	while(enum.hasMoreElements()){
	        	LeaseChargesAccessBean temp = (LeaseChargesAccessBean)enum.nextElement();
	        	leaseDocPositions.add(new Integer(temp.getLeaseDocPosition()));
        	}

	        enum = lpab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), //startDate
	        	new Boolean(true), new java.sql.Date(time),//endDate
	        	new Boolean(false), null,//reminder
	        	new Boolean(true), (Integer)resources.get(i),
	        	new Boolean(false),//isCalcPosOnly source = 'A' AND + docposvid IN ('Q', 'K', 'Z') 
	        	new Boolean(false), new Boolean(false)//isAutoRUR
	        	);
	        while(enum.hasMoreElements()){
		        LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
		        leaseDocPositions.add(new Integer(temp.getLeaseDocPosition()));
	        }
		}
		
        LeaseCalcRateAccessBean lcrab= new LeaseCalcRateAccessBean(); 
        for(int i=0; i<leaseDocPositions.size(); i++){
	        Enumeration enum = lcrab.findBy_Hand_LeaseDocPosition("N", (Integer)leaseDocPositions.get(i));
			while(enum.hasMoreElements()){
				LeaseCalcRateAccessBean lcr = (LeaseCalcRateAccessBean)enum.nextElement();
pr("leaseDocPosition="+lcr.getDocpositionKey().leaseDocPosition	
	+" currency="+lcr.getCurrencyKey().currency);
				lcr.getEJBRef().remove();
			}
        }
        
			

// Удаляем фиктивные начисления и платежи по акту
        for(int i=0; i<contracts.size(); i++){
       		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
			LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
			ArrayList ar = new ArrayList();

        	Enumeration enum = lpab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), 
	        	new Boolean(false), null,    //actEndDate
	        	new Boolean(false), null,
	        	new Boolean(true), (Integer)resources.get(i),
	        	new Boolean(true),//isCalcPosOnly
	        	new Boolean(false), new Boolean(false)
	        	);
        	while(enum.hasMoreElements()){
	        	ar.add(enum.nextElement());
	        	//LeasePaymentAccessBean t = ((LeasePaymentAccessBean)enum.nextElement());
	        	//int position = t.getLeaseDocPosition();
	        	//if(!(t.getDocposvid().equalsIgnoreCase("Z") && t.getDate().compareTo(actStartDate) == 0))
        			//t.getEJBRef().remove();
        	}
        	enum = lcab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), 
	        	new Boolean(false), null,
	        	new Boolean(false), null,
	        	new Boolean(true), (Integer)resources.get(i),
	            new Boolean(true),//isCalcPosOnly
	            new Integer(1)// orderByDate
				);
        	while(enum.hasMoreElements())
	        	ar.add(enum.nextElement());
	        for(int j=0; j<ar.size(); j++){
		        Object obj = ar.get(j);
		        LeaseDocPositionAccessBean t = null; 
		        if(obj instanceof LeaseChargesAccessBean)
		        	t = new LeaseDocPositionAccessBean(((LeaseChargesAccessBean)obj).getEJBRef());
		        else
		        	t = new LeaseDocPositionAccessBean(((LeasePaymentAccessBean)obj).getEJBRef());
		        	
	        	int position = t.getLeaseDocPosition();
	        	if (//t.getDocposvid().equalsIgnoreCase("Q") || t.getDocposvid().equalsIgnoreCase("K")   ||
		        	//Нельзя удалять начисления и платежис признаклм "Z" и с датой равной дате начала акта,
		        	//т.к. они сформированы предыдущим актом
	        	   (!(t.getDocposvid().equalsIgnoreCase("Z") && t.getDate().compareTo(actStartDate) == 0)))
        			t.getEJBRef().remove();
	        }
        	//while(enum.hasMoreElements()){
	        	//LeaseChargesAccessBean t = ((LeaseChargesAccessBean)enum.nextElement());
	        	//int position = t.getLeaseDocPosition();
	        	//if (t.getDocposvid().equalsIgnoreCase("Q") || t.getDocposvid().equalsIgnoreCase("K")   &&
		        	//Нельзя удалять начисления и платежис признаклм "Z" и с датой равной дате начала акта,
		        	//т.к. они сформированы предыдущим актом
	        	   //(!(t.getDocposvid().equalsIgnoreCase("Z") && t.getDate().compareTo(actStartDate) == 0)))
        			//t.getEJBRef().remove();
        			
        	//}
        }

		LeaseSaldoAccessBean lsab = new LeaseSaldoAccessBean();
		Enumeration enum = lsab.findLeaseSaldosByAct(new LeaseDocumentKey(idAct.intValue()));
		while(enum.hasMoreElements())
			((LeaseSaldoAccessBean)enum.nextElement()).getEJBRef().remove();

// Перевести акт в состояние редактируется			
		mutualAct.setActState("O");
		mutualAct.commitCopyHelper();

// Проставить в таблице LeaseDNOP, LeaseDocPosition act=null where act=idAct 
		LeaseDNOPAccessBean ldnab = new LeaseDNOPAccessBean();
		enum = ldnab.findLeaseDNOPsByAct(new LeaseDocumentKey(idAct.intValue()));
		while(enum.hasMoreElements()){
			LeaseDNOPAccessBean temp = (LeaseDNOPAccessBean)enum.nextElement();
			temp.setAct(null);
			temp.commitCopyHelper();
		}
		LeaseDocPositionAccessBean ldab = new LeaseDocPositionAccessBean();
		enum = ldab.findLeaseDocPositionsByAct(new LeaseDocumentKey(idAct.intValue()));
		while(enum.hasMoreElements()){
			LeaseDocPositionAccessBean temp = (LeaseDocPositionAccessBean)enum.nextElement();
			temp.setAct(null);
			temp.commitCopyHelper();
		}

		if(!clearLeasevpayment()) return false;


		for(int i=0; i<contracts.size(); i++){
			LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
        	enum = lcab.findByQBE4(
	        	(Integer)contracts.get(i),
	        	new Boolean(true), new java.sql.Date(actStartDate.getTime()), 
	        	new Boolean(true), new java.sql.Date(actEndDate.getTime()),
	        	new Boolean(false), null,
	        	new Boolean(true), (Integer)resources.get(i),
	            new Boolean(false),//isCalcPosOnly
	            new Integer(1)// orderByDate
	        	);
        	while(enum.hasMoreElements()){
	        	LeaseChargesAccessBean temp = (LeaseChargesAccessBean)enum.nextElement();
	        	if(temp.getByhandraterur().equals(new Boolean(false)))
		        	temp.setRemainderrate2rur(null);
		        	temp.commitCopyHelper();
        	}
		}

		
		fillUsedInAct(false);
		freeAutoRateRurForPayment();
		taskEnd();
		
        return true;
*/        
    } catch (Exception ex) {	            
        //addMsgInJournal(100, "E", -1, act, -1, -1, actStartDate, actEndDate, null, null, -1, -1, -1, -1);
        addMsgInJournal(idtask, "E", "Техническая ошибка в rollbackCalcAct");
        pr(ex, "rollbackCalcAct");
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 17:08:34)
 * @return boolean
 * @param idAkt java.lang.Integer
 */
  // @@@ Используется не только для рассчета акта
public boolean rollbackCalcAct(Integer idAct, int idtask) throws java.rmi.RemoteException{

	java.sql.Connection con = null;
	java.sql.PreparedStatement ps = null;
	try {
		this.act = idAct.intValue();
	    this.idtask = idtask;
	    if(!initial(idAct))
	    	return false;

	    /* Another constant - in calculate Act
		if(getNamedValueInt("DEFRULEFREEACT", idtask) == 1){
			con = getConnection();
			ps = con.prepareStatement("execute procedure freeact(?, ?)");
			ps.setInt(1, idAct.intValue());
			ps.setInt(2, idtask);
			int result = 0;
			java.sql.ResultSet rs = ps.executeQuery();
			if(rs.next())				
				result = rs.getInt(1);
			if(result == 0){
				pr("Процедура вернула 0");
				return false;
			}else{
				pr("Процедура вернула 1");
				return true;
			}
		}	
		*/ 
	    
	    checkExistSaldo();
	    
	    if(!rollbackTempAct())
	    	return false;
	    return rollbackCalcAct(idAct.intValue());


    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
        //addMsgInJournal(100, "E", -1, act, -1, -1, actStartDate, actEndDate, null, null, -1, -1, -1, -1);
        addMsgInJournal(idtask, "E", "Техническая ошибка в rollbackCalcAct");
        pr(ex, "rollbackCalcAct");
    } finally{
	    try{if(ps != null) ps.close();}catch(Exception e){}
	    try{if(con != null) con.close();}catch(Exception e){}
    }
    return false;
}
private boolean rollbackTempAct() throws java.rmi.RemoteException{

    try {
    	int reglament = mutualAct.getLeaseMutualReglamentKey().leaseDocument;
    	Enumeration acts = mutualAct.findByQBE(
	    	Boolean.TRUE, new Integer(reglament), Boolean.FALSE, null, null, new Integer(4));

    	ArrayList tempActs = new ArrayList();
    	while(acts.hasMoreElements()){
	    	LeaseMutualActNewAccessBean lma = (LeaseMutualActNewAccessBean)acts.nextElement();
	    	if(lma.getIstemp() && lma.getLeaseDocument() != act){
	    		tempActs.add(lma);
	    	}
    	}
    	for(int i = 0; i < tempActs.size(); i++){
	    	LeaseMutualActNewAccessBean lma = (LeaseMutualActNewAccessBean )tempActs.get(i);
	    	int tempAct = lma.getLeaseDocument();
	    	if(!rollbackCalcAct(tempAct)){
		    	String err = "Откат временного акта № "+tempAct+" завершился неудачно";
		    	addMsgInJournal(idtask, "E", err);	
	    		return false;
	    	}
	    	
	    	try{
		    	LeaseMutualActInfoAccessBean lmai = new LeaseMutualActInfoAccessBean();
		    	lmai.setInitKey_leasedocument(tempAct);
		    	lmai.refreshCopyHelper();
	    		lmai.getEJBRef().remove();
	    	}catch(Exception e){ 	}
	    	try{
	    		lma.getEJBRef().remove();
	    	}catch(Exception e){
		    	String err = "Удаление временного LeaseMutualAct № "+tempAct+" завершилось неудачно";
		    	addMsgInJournal(idtask, "E", err);	
	    		return false;
	    	}

	    	pr("Удалили временный актИнфо и акт № "+tempAct);
    	}
	    return true;
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
        pr(ex, "rollbackTempAct");
        String msg = "Техническая ошибка в rollbackTempAct";
        addMsgInJournal(idtask, "E", msg);	
    }
    return false;
}
public BigDecimal setChargeRemainderRate(Handle handle)throws java.rmi.RemoteException{
	try{
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(handle.getEJBObject());
		//lcab.refreshCopyHelper();
		BigDecimal rateCharge = getChargeRate(lcab.getEJBRef().getHandle(), lcab.getCurrencyKey().currency, false);
		lcab.setRemainderrate2rur(rateCharge); 
		lcab.setByhandraterur(new Boolean(false));
		lcab.commitCopyHelper();
		return rateCharge;
	}catch(Exception ex){		
		String msg = "Техническая ошибка в ArendaTransactionMethodBean.setChargeRemainderRate";
	    	addMsgInJournal(idtask, "E", msg);
		pr(ex, "setChargeRemainderRate");
	}
	return null;
}
public boolean setRateRurForPayment() throws java.rmi.RemoteException{
    try {
	    pr("setRateRurForPayment begin");
        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        for (int i = 0; i < contracts.size(); i++) {
                Enumeration enum = lpab.findByQBE4(// Платежи по дате и контракту
				        (Integer) contracts.get(i),
			            new Boolean(true),  new java.sql.Date(actStartDate.getTime()),
			            new Boolean(true),  new java.sql.Date(actEndDate.getTime()),
			            new Boolean(false), null, //remaider
				        new Boolean(true), (Integer) resources.get(i), //resource
				        new Boolean(false), //isCalcposOnly
				        new Boolean(false), new Boolean(false) //isAutoRUR
					    );
                while(enum.hasMoreElements()){
	                LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
	                temp.getLeaseDocPosition();
		            if((temp.getDocposvid().equals("Z") || temp.getDocposvid().equals("C")) &&
		            temp.getSumRub() == null){
			            if(temp.getCurrencyKey().currency == getNamedValueInt("RUR", idtask)){
				            temp.setPayrate(getDec(1,4));
				            temp.setSumRub(temp.getSumm());
				            temp.setRurremainder(temp.getSumm());			            
			            } else {
				            BigDecimal payrate = getPaymentRate(
					            temp, 
					            temp.getCurrencyKey().currency,
					            false);
				            BigDecimal nul = getDec(0,2);
				            BigDecimal sumpay = payrate.multiply(temp.getSumm()).setScale(2, BigDecimal.ROUND_HALF_UP);
				            BigDecimal ndsrub = null;
				            if(temp.getSumnds().compareTo(nul) == 0)
				            	ndsrub = nul;
				            else 
					            ndsrub = sumpay.multiply(temp.getSumnds()).divide(
						            temp.getSumm(), 2, BigDecimal.ROUND_HALF_UP);
					        temp.setPayrate(payrate);
					        temp.setSumRub(sumpay);
					        temp.setRurremainder(sumpay);
					        temp.setNdsRub(ndsrub);
			            }
			            temp.setByautorur(true);
				        temp.commitCopyHelper();
		            }	
                } 
        }
        pr("setRateRurForPayment end");
        return true;
    } catch (Exception ex) {        
        try {
            String msg = "Техническая ошибка в ArendaTransactionMethodBean.setRateRurForPayment";
	    	addMsgInJournal(idtask, "E", msg);
        } catch (Exception e) {
        }
        pr(ex, "setRateRurForPayment()");
    }
    return false;
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
public void taskEnd() throws Exception {
    try {
	    JournalAccessBean jab = new JournalAccessBean();
	    jab.taskEnd(idtask);
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в ArendaTransactionMethodBean._addMutuallyBetweenContracttaskEnd. idtask=" + idtask;
	    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "taskEnd. idtask=" + idtask);
    }
}
public int taskStart(int operator, String taskType) throws java.rmi.RemoteException{
    try {
	    idtask = new JournalAccessBean().taskStart(operator, taskType);

        return idtask;
    } catch (Exception ex) {
        pr(ex, "taskStart");
    }
    return -1;
}
public int taskStart(int operator, String taskType, Date date1, Date date2,
	Integer economist, Integer document) {
    try {
	    
	    if(!isInit)
	    	initial(new Integer(act));
	    idtask = new JournalAccessBean().taskStart(operator, taskType, date1, date2, economist, document);
        return idtask;
    } catch (Exception ex) {
	    pr(ex, "taskStart()");
        String msg = "Техническая ошибка в ArendaTransactionMethodBean.taskStart";
	    	addMsgInJournal(idtask, "E", msg);        
    }
    return -1;
}
public boolean updateSaldo(Integer leaseContract, Date salDate, Integer resource, int mainCurrency, BigDecimal mainSum,
	BigDecimal mainNdsSum, int additionalCurrencycode, BigDecimal additionalSum, BigDecimal additionalNdsSum) throws java.rmi.RemoteException {

	try	{
		LeaseSaldoAccessBean bean = new LeaseSaldoAccessBean();
		bean.setInitKey_leaseContract(leaseContract);
		bean.setInitKey_resource_resource(resource);
		bean.setInitKey_SalDate(new java.sql.Date(salDate.getTime()));
		bean.refreshCopyHelper();

		CurrencyAccessBean mainCurrBean = new CurrencyAccessBean();
		mainCurrBean.setInitKey_currency(mainCurrency);
		mainCurrBean.refreshCopyHelper();
		bean.setMaincurrency((Currency) mainCurrBean.getEJBRef());
		bean.setMainsum(mainSum);
		bean.setMainndssum(mainNdsSum);

		if (additionalCurrencycode != 0 && (additionalSum != null || additionalNdsSum != null)) {
			CurrencyAccessBean addCurrBean = new CurrencyAccessBean();
			addCurrBean.setInitKey_currency(additionalCurrencycode);
			addCurrBean.refreshCopyHelper();
			bean.setAdditionalcurrency((Currency) addCurrBean.getEJBRef());
		} else {
			bean.setAdditionalcurrency(null);
		}
		bean.setAdditionalsum(additionalSum);
		bean.setAdditionalndssum(additionalNdsSum);
		
		bean.commitCopyHelper();

		return true;
	} catch (Exception ex) {
		if(idtask != -1){
			String msg = "Техническая ошибка в ArendaTransactionMethodBean.updateSaldo";
		   	addMsgInJournal(idtask, "E", msg);
		}
		pr(ex, "updateSaldo");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2002 12:44:24)
 */
public void updateSaldoSergey(Integer leaseContract, Date salDate, Integer resource, int mainCurrency, BigDecimal mainSum,
	BigDecimal mainNdsSum, int additionalCurrencycode, BigDecimal additionalSum, BigDecimal additionalNdsSum) throws java.rmi.RemoteException {

	try	{
		if (!deleteChargeOrPaymentOnSaldo(leaseContract, salDate, resource)) {
			throw new Exception();
		}
		if(!updateSaldo(leaseContract, salDate, resource, mainCurrency, mainSum,
			mainNdsSum, additionalCurrencycode, additionalSum, additionalNdsSum))
				throw new Exception();

		if (!createChargeOrPaymentOnSaldo(leaseContract, salDate, resource)) {
			throw new Exception();
		}
	} catch (Exception e) {
		pr(e, "updateSaldoSergey");
		String msg = (e.getMessage()==null?"No Message" : e.getMessage());
		throw new RemoteException(msg);

	}
}
}
