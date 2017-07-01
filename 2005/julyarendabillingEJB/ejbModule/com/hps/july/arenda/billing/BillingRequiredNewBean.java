package com.hps.july.arenda.billing;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.persistence.*;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import javax.ejb.*;
/** 
 * This is a Session Bean Class
 * Обработка данных биллинга
 */
public class BillingRequiredNewBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
	private Integer systemUsd = null;
	private JournalAccessBean journal = null;
	private KeyGeneratorAccessBean keygen = null;
private boolean addMsgInJournal(int idtask, String jrnType, String jrnMsg){

	try{
		return getJournal().addMsgInJournal(idtask, jrnType, jrnMsg);
	}catch(Exception ex){
		pr(ex, "addMsgInJournal");
	}
	return false;
}
public boolean cancelMovePayOnAktNri2BufferNri(int idtask, Integer idAct)throws java.rmi.RemoteException{
	//Удалить список платежей из буфера системы NRI
	try{
		LeasePay2BillAccessBean lp2bill = new LeasePay2BillAccessBean();
		Enumeration enum = lp2bill.findByAct(idAct);
		while(enum.hasMoreElements()){
			LeasePay2BillAccessBean temp = (LeasePay2BillAccessBean)enum.nextElement();
			lp2bill.setRecordstatus("D");
		}
		lp2bill.commitCopyHelper();
				
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в cancelMovePayOnAktNri2BufferNri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "cancelMovePayOnAktNri2BufferNri");
	}
	return false;
}
private boolean checkAbonentDnopSumLink(
	int idtask, 
	LeaseAbonentDNOPAccessBean lad,
	LeasePaymentAccessBean lpab,
	LeaseChargesAccessBean lcab,
	BigDecimal payrate
	) throws Exception{
	try{
		BigDecimal rurremainderInCurrencyCharge = lpab.getRurremainder().divide(
					payrate, 2, BigDecimal.ROUND_HALF_UP);
		int minimum = rurremainderInCurrencyCharge.compareTo(lcab.getRemaindersum());
		
		BigDecimal sumdnop = getDec(0, 2), minimumSum = null;
		if(minimum == -1){
			Enumeration enum = lpab.getLeaseDNOPPay();
			while(enum.hasMoreElements())
				sumdnop = sumdnop.add( ((LeaseDNOP)enum.nextElement()).getChargesum() );
			minimumSum = sumdnop.add(rurremainderInCurrencyCharge);
		} else {
			Enumeration enum = lcab.getLeaseDNOP();
			while(enum.hasMoreElements())
				sumdnop = sumdnop.add( ((LeaseDNOP)enum.nextElement()).getChargesum() );
			minimumSum = sumdnop.add(lcab.getRemaindersum());
		}
		if(lad.getSumlinkusd().compareTo(minimumSum) <= 0)
			return true;
		else {
			String msg = "Сумма связи платежа "+lpab.getLeaseDocPosition()
			+"и начисления "+lpab.getLeaseDocPosition()+" в NRI превышает "
			+"сумму связи платежа и счета в системе биллинга LeaseAbonentDNOP - "+lad.getIdabonentdnop();
			addMsgInJournal(idtask, "E", msg);
			return false;
		}
	}catch(Exception ex){
		String msg="Техническая ошибка в checkAbonentDnopSumLink";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "checkAbonentDnopSumLink");
		throw ex;
	}
}
public boolean checkPossibleMoveBill2Nri(int idtask, Integer idBill)throws java.rmi.RemoteException{
	// Проверить возможность переноса счета из буфера системы NRI в систему NRI
	try{
		AbonentBillPosAccessBean abpab = new AbonentBillPosAccessBean();
		Enumeration enum = abpab.findByLeaseBill(idBill);
		while(enum.hasMoreElements()){
			AbonentBillPosAccessBean temp = (AbonentBillPosAccessBean)enum.nextElement();
			int billPos = temp.getBillpos();
			if(temp.getPos2resource() == null){
				String msg="В позиции абонентского счета № "+billPos+" не содержится услуга";
				addMsgInJournal(idtask, "E", msg);
				return false;
			}
			if(temp.getSummnri().compareTo(
				temp.getSummpurenri().add(temp.getNdssummnri()).add(temp.getNspsummnri())
				) != 0){
					String msg="В позиции абонентского счета № "+billPos+" указаны неверные суммы";
					addMsgInJournal(idtask, "E", msg);
					return false;
				}
			if(temp.getSumbyhand())
				if(temp.getSummnri().compareTo(temp.getSumm()) == 1){
					String msg="В позиции абонентского счета № "+billPos+" summNri > Summ";
					addMsgInJournal(idtask, "E", msg);
					return false;
				}
		}
		
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в сheckPossibleMoveBill2Nri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "сheckPossibleMoveBill2Nri");
	}
	return false;
}
public boolean checkPossibleMovePayment2Nri(int idtask, Integer idPay)throws java.rmi.RemoteException{
	//проверить возможность переноса платежей из буфера системы NRI в систему NRI
	try{
		AbonentPaymentAccessBean apab = getAbonentPayment(idtask, idPay);
		if((apab.getSumnriusd()==null || apab.getSumfreeusd()==null || apab.getSumpayusd()==null ||
			apab.getSumnrirur()==null || apab.getSumfreerur()==null || apab.getSumpayrur()==null)
		||
		   (apab.getSumnriusd().add(apab.getSumfreeusd()).compareTo(apab.getSumpayusd()) != 0 ||
		   apab.getSumnrirur().add(apab.getSumfreerur()).compareTo(apab.getSumpayrur()) != 0) ){
			   String msg="Нельзя определить какая часть суммы может быть передана в систему NRI"
			   +"AbonentPayment="+apab.getPaypos();
				addMsgInJournal(idtask, "E", msg);
			   return false;
		   }
		if(apab.getResource() == null){
			String msg="Необходимо установить за что выполнен платеж AbonentPayment="+apab.getPaypos();
				addMsgInJournal(idtask, "E", msg);
			return false;
		}
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в сheckPossibleMovePayment2Nri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "сheckPossibleMovePayment2Nri");
	}
	return false;
}
private Integer createChargeNri(
	int idtask, 
	java.sql.Date locdate,
	Integer contract, 
	Integer resource,
	BigDecimal sum,
	Integer currency,
	String billNumber,
	BigDecimal sumNds,
	BigDecimal remainderrate2RUR,
	String docposvid
	){
	// Создание начисления в системе NRI
	try{
		int key = getkey(idtask, "tables.leasedocpositions");
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(
			key,
			locdate,//date
			contract,//contract
			"B",//source
			docposvid,//docposvid
			locdate,//begindate 
			locdate,//enddate
			resource,//resourse  м.б. null
			sum,//summ 
			currency, // currency 
			sumNds, // summNds   
			sum,// remainderSum
			new Boolean(false) //byHandRateRur
			);
		lcab.setRemainderrate2rur(remainderrate2RUR);
		lcab.setBillnumber(billNumber);
		lcab.commitCopyHelper();

		return new Integer(key);
	}catch(Exception ex){
		String msg="Техническая ошибка в createChargeNri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "createChargeNri");
	}
	return null;
}
private BigDecimal createLeaseCalcRate(int idtask, LeasePaymentAccessBean lpab) throws Exception{
	//try{
		//ArendaTransactionMethodAccessBean atab = new ArendaTransactionMethodAccessBean();
		//BigDecimal payrate = atab.getPaymentRate(
			//lpab.getEJBRef().getHandle(),
			//lpab.getCurrencyKey().currency,
			//false
			//);
		
		//return payrate;
	//}catch(Exception ex){
		//String msg="Техническая ошибка в createLeaseCalcRate";
		//addMsgInJournal(idtask, "E", msg);
		//pr(ex, "createLeaseCalcRate");
		//throw ex;
	//}
	return null;
}
private Integer createPaymentNri(
	int idtask, 
	java.sql.Date locdate, 
	Integer contract,
	String docposvid,
	Integer resource,
	BigDecimal sum,
	BigDecimal sumnds,
	Integer currency,
	String docnumber,
	BigDecimal sumrub,
	BigDecimal sumrubnds,
	BigDecimal payrate
	){
	// Создание платежа в системе NRI
	try{
		int key = getkey(idtask, "tables.leasedocpositions");
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean(
			key,
			locdate,//date
			contract,//contract
			"B",//source
			docposvid,//docposvid
			locdate,//begindate 
			locdate,//enddate
			resource,//resourse  м.б. null
			sum,//summ это ли поле
			currency, // currency
			sumnds, // summNds
			"P", //paymentType
			"P" //paymentState
			);
		lpab.setDocNumber(docnumber);//docNumber
		lpab.setSumRub(sumrub);//summRub
		lpab.setNdsRub(sumrubnds);
		lpab.setRurremainder(sumrub);
		lpab.setPayrate(payrate);
		lpab.commitCopyHelper();

		return new Integer(key);
	}catch(Exception ex){
		String msg="Техническая ошибка в createPaymentNri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "createPaymentNri");
	}
	return null;
}
private boolean defineFlagNeedBill(int idtask, AbonentBillAccessBean bill){
	// Определить необходимость переноса счета в систему NRI
	try{
		try{
			LeaseAbonentBENAccessBean lab = new LeaseAbonentBENAccessBean();
			lab.setInitKey_ben(bill.getBen().shortValue());
			lab.setInitKey_leaseabonentban_leaseDocument(new Integer(
				bill.getLeaseabonentbanKey().leaseDocument));
			lab.refreshCopyHelper();

			bill.setUseinnri(new Boolean(true));
			bill.setChangeuseinnri("A");
			bill.commitCopyHelper();
			return true;
		}catch(Exception e){
			if(!(e instanceof FinderException)){
				//addMsgIn
				throw e;
			}
				String msg="Не можем перенести счет № "+bill.getLeasebill()+" из буфера "
				+"в систему NRI, т.к. для него не найден бен";
				addMsgInJournal(idtask, "E", msg);
			bill.setUseinnri(new Boolean(false));
			bill.setChangeuseinnri("A");
			bill.commitCopyHelper();
			return false;
		}
	}catch(Exception ex){
		String msg="Техническая ошибка в defineFlagNeedBill";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "defineFlagNeedBill");
	}
	return false;
}
public boolean defineSumPayNeedForNri(int idtask, Integer idPay)throws java.rmi.RemoteException{
	// Определить сумму платежа необходимую для переноса платежа из буфера системы NRI в систему NRI
	try{ 
		BigDecimal locSumNriUsd = getDec(0, 2), locSumFreeUsd = getDec(0, 2);
		HashMap bens_sum = new HashMap();//бены и суммы для них
		HashMap bens_leaseDoc = new HashMap();//бены и leaseDocument по платежу
		LeaseAbonentDNOPAccessBean ladab = new LeaseAbonentDNOPAccessBean();
		
		Enumeration enum = ladab.findByPayPos(idPay);
		while(enum.hasMoreElements()){//Находим бены и сумму для них
			LeaseAbonentDNOPAccessBean temp = (LeaseAbonentDNOPAccessBean)enum.nextElement();
			Short ben = temp.getAbonentbill().getBen();
			if(bens_sum.containsKey(ben)){
				BigDecimal sum = (BigDecimal)bens_sum.get(ben);
				bens_sum.put(ben, sum.add(temp.getSumlinkusd()));
			} else {
				bens_sum.put(ben, temp.getSumlinkusd());
				bens_leaseDoc.put(ben, new Integer(temp.getAbonentpayment().getLeaseabonentbanKey().leaseDocument));
			}
		}
// определяем какая сумма должна принадлежать сумме NRI, а какая не должна.
		Iterator it = bens_sum.keySet().iterator();		
		while(it.hasNext()){
			int countBen = 0;
			LeaseAbonentBENAccessBean lab = new LeaseAbonentBENAccessBean();
			Short ben = (Short)it.next();
			enum = lab.findByBen(ben);
			while(enum.hasMoreElements()){
				LeaseAbonentBENAccessBean temp = (LeaseAbonentBENAccessBean)enum.nextElement();
				if(temp.getLeaseabonentbanKey().leaseDocument == 
					((Integer)bens_leaseDoc.get(ben)).intValue())
					countBen++;
			}
			if(countBen == 1)
				locSumNriUsd = locSumNriUsd.add((BigDecimal)bens_sum.get(ben));
			else
				locSumFreeUsd = locSumFreeUsd.add((BigDecimal)bens_sum.get(ben));
		}
// Рассчитываем и сохраняем в таблице AbonentPayments найденные суммы(рублевые и долларовые)
		AbonentPaymentAccessBean apab = getAbonentPayment(idtask, idPay);

		apab.setSumnriusd(locSumNriUsd);
		apab.setSumfreeusd(locSumFreeUsd);

		BigDecimal locRate = apab.getSumpayrur().divide(apab.getSumpayusd(), 4, BigDecimal.ROUND_HALF_UP);
		BigDecimal sumNriRur = apab.getSumnriusd().multiply(locRate);
		BigDecimal sumFreeRur = getDec(0, 2);
		if(apab.getSumpayusd().compareTo(apab.getSumnriusd().add(apab.getSumfreeusd())) == 0)
			sumFreeRur = apab.getSumpayrur().subtract(apab.getSumnrirur());
		else
			sumFreeRur = apab.getSumfreeusd().multiply(locRate);

		apab.setSumnrirur(sumNriRur);
		apab.setSumfreerur(sumFreeRur);
		
		apab.commitCopyHelper();	
		
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в defineSumPayNeedForNri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "defineSumPayNeedForNri");
	}
	return false;
}
private boolean deleteDnopLinkBilling(int idtask, int docPosition){
	try{
		ArendaTransactionMethodAccessBean atab = new ArendaTransactionMethodAccessBean();
		LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean();
		
		Enumeration enum = dnab.findByLeaseChargeSource(new Integer(docPosition), "B");
		while(enum.hasMoreElements()){
			LeaseDNOPAccessBean dn = (LeaseDNOPAccessBean)enum.nextElement();
			atab.clearCharge2Pay(dn.getEJBRef().getHandle(), idtask);
		}
		enum = dnab.findByLeasePaymentSource(new Integer(docPosition), "B");
		while(enum.hasMoreElements()){
			LeaseDNOPAccessBean dn = (LeaseDNOPAccessBean)enum.nextElement();
			atab.clearCharge2Pay(dn.getEJBRef().getHandle(), idtask);
		}
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в deleteDnopLinkBilling";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "deleteDnopLinkBilling");
	}
	return false;
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	systemUsd = null;
	keygen = null;
	journal = null;	
}
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
public void ejbPassivate() throws java.rmi.RemoteException {
	systemUsd = null;
	keygen = null;
	journal = null;	
}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {
	systemUsd = null;
	keygen = null;
	journal = null;	
}
private AbonentBillAccessBean getAbonentBill(int idtask, Integer leaseBill) throws Exception{
	try{
		AbonentBillAccessBean abab = new AbonentBillAccessBean();
		abab.setInitKey_leasebill(leaseBill.intValue());
		abab.refreshCopyHelper();
		return abab;
	}catch(Exception ex){
		String msg="Техническая ошибка в getAbonentBill";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getAbonentBill");
		throw ex;
	}
}
private AbonentBillAccessBean getAbonentBillPos(int idtask, Integer leaseBill) throws Exception{
	try{
		AbonentBillAccessBean abab = new AbonentBillAccessBean();
		abab.setInitKey_leasebill(leaseBill.intValue());
		abab.refreshCopyHelper();
		return abab;
	}catch(Exception ex){
		String msg="Техническая ошибка в getAbonentBillPos";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getAbonentBillPos");
		throw ex;
	}
}
private LeaseAbonentDNOPAccessBean getAbonentDnop(int idtask, Integer idDnop) throws Exception{
	try{
		LeaseAbonentDNOPAccessBean lad = new LeaseAbonentDNOPAccessBean();
		lad.setInitKey_idabonentdnop(idDnop.intValue());
		lad.refreshCopyHelper();
		return lad;
	}catch(Exception ex){
		String msg="Техническая ошибка в getAbonentDnop";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getAbonentDnop");
		throw ex;
	}
}
private AbonentPaymentAccessBean getAbonentPayment(int idtask, Integer idPay) throws Exception{
	try{
		AbonentPaymentAccessBean apab = new AbonentPaymentAccessBean();
		apab.setInitKey_paypos(idPay.intValue());
		apab.refreshCopyHelper();
		return apab;
	}catch(Exception ex){
		String msg="Техническая ошибка в getAbonentPayment";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getAbonentPayment");
		throw ex;
	}
}
public boolean getAbonentPaymentByHand(int idtask, Integer idPay) throws java.rmi.RemoteException{
	try{
		AbonentPaymentAccessBean apab = getAbonentPayment(idtask, idPay);
		return apab.getByhand();
	}catch(Exception ex){
		String msg="Техническая ошибка в getAbonentPaymentByHand";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getAbonentPaymentByHand");
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
	}
}
public Object[] getAllAbonentBillsByFlag(int idtask, String flag)throws java.rmi.RemoteException{
// Получаем все необработанные счета
	try{
		ArrayList bills = new ArrayList();
		AbonentBillAccessBean abab = new AbonentBillAccessBean();
		Enumeration enum = abab.findByFlagWorkNRI(flag);
		while(enum.hasMoreElements())
			bills.add(new Integer(((AbonentBillAccessBean)enum.nextElement()).getLeasebill()));
		
		return bills.toArray();
	}catch(Exception ex){
		String msg="Техническая ошибка в getAllAbonentBillsByFlag";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getAllAbonentBillsByFlag");
	}
	return null;
}
public Object[] getAllAbonentDnopByFlag(int idtask, String flag)throws java.rmi.RemoteException{
// Получаем все необработанные счета
	try{
		ArrayList dnops = new ArrayList();
		LeaseAbonentDNOPAccessBean lad = new LeaseAbonentDNOPAccessBean();
		Enumeration enum = lad.findByFlagWorkNRI(flag);
		while(enum.hasMoreElements())
			dnops.add(new Integer(((LeaseAbonentDNOPAccessBean)enum.nextElement()).getIdabonentdnop()));
		
		return dnops.toArray();
	}catch(Exception ex){
		String msg="Техническая ошибка в getAllAbonentDnopByFlag";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getAllAbonentDnopByFlag");
	}
	return null;
}
public Object[] getAllPaymentByFlag(int idtask, String flag)throws java.rmi.RemoteException{
// Получаем все необработанные платежи
	try{
		ArrayList payments = new ArrayList();
		AbonentPaymentAccessBean apab = new AbonentPaymentAccessBean();
		Enumeration enum = apab.findByFlagWorkNRI(flag);
		while(enum.hasMoreElements())
			payments.add(new Integer(((AbonentPaymentAccessBean)enum.nextElement()).getPaypos()));
		
		return payments.toArray();
	}catch(Exception ex){
		String msg="Техническая ошибка в getAllPaymentByFlag";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getAllPaymentByFlag");
	}
	return null;
}
public Boolean getBillFlagNeed(int idtask, Integer idBill)throws java.rmi.RemoteException{
	try{
		AbonentBillAccessBean abab = getAbonentBill(idtask, idBill);
		return abab.getUseinnri();
	}catch(Exception ex){
		String msg="Техническая ошибка в getBillFlagNeed";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getBillFlagNeed");
	}
	return null;
}
private Date getDateLastSaldo(int idtask, Integer contract, Integer resource){
	try{
		LeaseSaldoAccessBean lsab = new LeaseSaldoAccessBean();
		Enumeration enum = lsab.findByLeaseContractAndResourceOrderDateDesc(contract, resource);
		if(enum.hasMoreElements())
			return ((LeaseSaldoAccessBean)enum.nextElement()).getSalDate();
	}catch(Exception ex){
		String msg="Техническая ошибка в getDateLastSaldo";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getDateLastSaldo");
	}
	return null;
}
private java.sql.Date getDatePlus(Date date, int amount){
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, amount);
        return new java.sql.Date(cal.getTime().getTime());	
}
private BigDecimal getDec(int value, int scale){
	return new BigDecimal(value).setScale(scale, BigDecimal.ROUND_HALF_UP);
}
public Object[] getDeletingAbonentBill(int idtask, Integer ban, Date dateStart) throws java.rmi.RemoteException{
	// Получаем AbonentBill которые предстоит удалить
	try{
		ArrayList ar = new ArrayList();
		 AbonentBillAccessBean abab = new AbonentBillAccessBean();
		 Enumeration enum = abab.findByBanStartServDate(ban, new java.sql.Date(dateStart.getTime()));
		 while(enum.hasMoreElements())
		 	ar.add(new Integer(((AbonentBillAccessBean)enum.nextElement()).getLeasebill()));
		 
		return ar.toArray();
	}catch(Exception ex){
		String msg="Техническая ошибка в getDeletingAbonentBill";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getDeletingAbonentBill");
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
	}	
}
public Object[] getDeletingAbonentPayment(int idtask, Integer ban, Date dateStart)throws java.rmi.RemoteException{
	// Получаем AbonentPayment которые предстоит удалить
	try{
		ArrayList ar = new ArrayList();
		 AbonentPaymentAccessBean apab = new AbonentPaymentAccessBean();
		 Enumeration enum = apab.findByBANDate(ban, new java.sql.Date(dateStart.getTime()));
		 while(enum.hasMoreElements())
		 	ar.add(new Integer(((AbonentPaymentAccessBean)enum.nextElement()).getPaypos()));
		 
		return ar.toArray();
	}catch(Exception ex){
		String msg="Техническая ошибка в getDeletingAbonentPayment";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getDeletingAbonentPayment");
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
	}
}
private JournalAccessBean getJournal() {
    try {
	    if(journal != null) return journal;
	    else {
		    journal = new JournalAccessBean();
		    return journal;
	    }
    } catch (Exception ex) {
        pr(ex, "getJournal()");
    }
    return null;
}
private int getkey(int idtask, String table) throws Exception {
    try {
	    if(keygen != null)
	    	return keygen.getNextKey(table);
	    	
	    keygen = new KeyGeneratorAccessBean();
        return keygen.getNextKey(table);
    } catch (Exception ex) {
	    String msg="Техническая ошибка в getkey";
		addMsgInJournal(idtask, "E", msg);
        pr(ex, "getkey");
        throw ex;
    }
}
private BigDecimal[] getLocSumm(int idtask, Integer idPay){
// Получаем суммы в рублях и баксах
	try{
		BigDecimal locSumNriUsd = getDec(0, 2),	locSumNriRur = getDec(0, 2);
		
		AbonPays2docposAccessBean apsab = new AbonPays2docposAccessBean();
		Enumeration enum = apsab.findAbonPays2docposesByPaypos(new AbonentPaymentKey(idPay.intValue()));
		while(enum.hasMoreElements()){
			AbonPays2docposAccessBean temp = (AbonPays2docposAccessBean)enum.nextElement();
			int leaseDocPosition = temp.getLeasedocpositionKey().leaseDocPosition;
			LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
			lpab.setInitKey_leaseDocPosition(leaseDocPosition);
			lpab.refreshCopyHelper();
			locSumNriRur = locSumNriRur.add(lpab.getSumRub());
			locSumNriUsd = locSumNriUsd.add(lpab.getSumm());
		}
		return new BigDecimal[]{locSumNriRur, locSumNriUsd};
	}catch(Exception ex){
		String msg="Техническая ошибка в getLocSumm";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getLocSumm");
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
private BigDecimal[] getSummBillPos(int idtask, Integer idBill) throws Exception{
// определить сумму позиции счета по начислениям
	try{
		BigDecimal locSumNri = getDec(0, 2), locNdsSumNri = getDec(0, 2);
		Enumeration enum = new AbonBillpos2docposAccessBean().findAbonBillpos2docposesByBillpos(
			new AbonentBillPosKey(idBill.intValue()));
		while(enum.hasMoreElements()){
			LeaseDocPositionAccessBean leaseDocPos = ((AbonBillpos2docposAccessBean)enum.nextElement()).getLeasedocposition();
			locSumNri = locSumNri.add(leaseDocPos.getSumm());
			locNdsSumNri = locNdsSumNri.add(leaseDocPos.getSumnds());
		}
		
		return new BigDecimal[]{locSumNri, locNdsSumNri};
	}catch(Exception ex){
		String msg="Техническая ошибка в getSummBillPos";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "getSummBillPos");
		throw ex;
	}
}
private Integer getSystemUsdCurrency(int idtask) throws Exception{

	if(systemUsd != null)
		return systemUsd;
	try{
		NamedValueAccessBean nvab = new NamedValueAccessBean();
		nvab.setInitKey_id("USD");
		nvab.refreshCopyHelper();
		systemUsd = new Integer(nvab.getIntvalue());
		return systemUsd;
	} catch(Exception ex){
		String msg="Не найдено значение системной константы USD";
		addMsgInJournal(idtask, "E", msg);
			pr(ex, "getSystemUsdCurrency");
			throw ex;
	}
}
public boolean moveOneDnopBufferNri2Nri(int idtask, Integer idDnop)throws java.rmi.RemoteException{
// Перенос данных по связи счетов и платежей из буфера системы NRI в систему NRI
	try{

		if(1==1)
			return true;

		
		LeaseAbonentDNOPAccessBean lad = getAbonentDnop(idtask, idDnop);

		if(!lad.getAbonentpayment().getFlagworknri()){
			String msg="При переносе связи "+idDnop+" платеж "+lad.getAbonentpayment().getPaypos()+" не обработан";
			addMsgInJournal(idtask, "E", msg);
			return false;
		}
		if(!lad.getAbonentbill().getFlagworknri()){
			String msg="При переносе связи "+idDnop+" счет "+lad.getAbonentbill().getLeasebill()+" не обработан";
			addMsgInJournal(idtask, "E", msg);
			return false;
		}

		AbonPays2docposAccessBean ap2docpos = new AbonPays2docposAccessBean();
		Enumeration tempPays = ap2docpos.findAbonPays2docposesByPaypos(
			new AbonentPaymentKey(lad.getAbonentpaymentKey().paypos));

		AbonBillpos2docposAccessBean abp2docpos = new AbonBillpos2docposAccessBean();
		Enumeration tempCharges = abp2docpos.findAbonBillpos2docposesByBillpos(
			new AbonentBillPosKey(lad.getAbonentbillKey().leasebill));

		begin:
		while(tempPays.hasMoreElements()){
			AbonPays2docposAccessBean temppay = (AbonPays2docposAccessBean)tempPays.nextElement();
			LeasePaymentAccessBean lpab = new LeasePaymentAccessBean(temppay.getLeasedocposition().getEJBRef());
			int compare = lpab.getDate().compareTo(
				getDateLastSaldo(
					idtask, 
					new Integer(lpab.getLeaseContractKey().leaseDocument),
					new Integer(lpab.getResourceKey().resource))
				);
			if(compare <= 0){// проверяем что дата платежа больше чем дата сальдо договора
				String msg="Дата платежа("+lpab.getLeaseDocPosition()+") больше чем дата сальдо договора";
				addMsgInJournal(idtask, "E", msg);
				continue;
			}
			compare = lpab.getRurremainder().compareTo(getDec(0, 2));
			if(compare == -1)// проверяем что остаток платежа больше нуля
				continue;
			while(tempCharges.hasMoreElements()){
				AbonBillpos2docposAccessBean tempbill = (AbonBillpos2docposAccessBean)tempCharges.nextElement();
				LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(tempbill.getLeasedocposition().getEJBRef());
				if(lcab.getRemaindersum().compareTo(getDec(0, 2)) == -1)// проверяем что остаток начисления больше нуля
					continue;
				if(lcab.getDate().compareTo(// проверяем что дата начисления больше даты сальдо
					getDateLastSaldo(
						idtask, 
						new Integer(lcab.getLeaseContractKey().leaseDocument),
						new Integer(lcab.getResourceKey().resource) )) <= 0){
							String msg="дата начисления ("+lcab.getLeaseDocPosition()
							+") меньше чем дата сальдо договора";
							addMsgInJournal(idtask, "E", msg);
							continue;
						}
				BigDecimal payrate = createLeaseCalcRate(idtask, lpab);
				if(payrate == null){
					String msg="Не смогли создать payrate для платежа "+lpab.getLeaseDocPosition();
					addMsgInJournal(idtask, "E", msg);
					return false;
				}
				
				if(!checkAbonentDnopSumLink(idtask, lad, lpab, lcab, payrate))
					return false;

				if(!(new ArendaTransactionMethodAccessBean()._linkCharge2Pay(
					lpab.getEJBRef().getHandle(),
					lcab.getEJBRef().getHandle(),
					payrate,
					null,// act
					new Boolean(false),// byHand
					"B", idtask
					))){
						String msg="Ошибка при связи платежа "+lpab.getLeaseDocPosition()
						+"и начисления "+lcab.getLeaseDocPosition();
						addMsgInJournal(idtask, "E", msg);
					}
				lpab.refreshCopyHelper();
				if(lpab.getRurremainder().compareTo(getDec(0, 2)) == 1)
					continue;
				else
					continue begin;
			}			
		}
		lad.setFlagworknri(true);
		lad.commitCopyHelper();
		
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в moveOneDnopBufferNri2Nri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveOneDnopBufferNri2Nri");
	}
	return false;
}
public boolean movePayOnAktNri2BufferNri(int idtask, Integer idAct)throws java.rmi.RemoteException{
	//Сформировать список платежей в буфер системы NRI из системы NRI
	try{
		LeaseMutualActNewAccessBean lma = new LeaseMutualActNewAccessBean();
		lma.setInitKey_leaseDocument(idAct.intValue());
		lma.refreshCopyHelper();
		java.sql.Date actStartDate = lma.getActstartdate();
		java.sql.Date actEndDate = lma.getActenddate();

		ArrayList contracts = new ArrayList(), resources = new ArrayList(), pays = new ArrayList();
		Enumeration enum = lma.getLeaseMutualReglament().getLeaseMutualContracts();
		while(enum.hasMoreElements()){
			LeaseMutualContractsAccessBean mutualContract = (LeaseMutualContractsAccessBean)enum.nextElement();
			LeaseContractAccessBean contract = mutualContract.getContract();
			if(contract.getContractType().equals("C")){
				contracts.add(new Integer(contract.getLeaseDocument()));
				resources.add(new Integer(mutualContract.getResourceKey().resource));
			}
		}

		ArendaTransactionMethodAccessBean atab = new ArendaTransactionMethodAccessBean();
		begin:
		for(int i=0; i<contracts.size(); i++){
			LeasePaymentAccessBean payments = new LeasePaymentAccessBean();
			enum = payments.findByQBE3(
				(Integer)contracts.get(i),
				(Integer)resources.get(i),
				actStartDate,
				actEndDate
				);
			BigDecimal sumpays = getDec(0, 2);
			while(enum.hasMoreElements()){
				LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
				if(temp.getDocposvid().equals("Q")){
					BigDecimal sumrub = temp.getSumRub();
					if(sumrub == null){
						String msg="Не сформирован список пдатежей из системы NRI в буфер системы NRI "
						+"для акта "+idAct+", контракта "+(Integer)contracts.get(i)
						+" платеж "+temp.getLeaseDocPosition()+" не имеет суммы в рублях";
						addMsgInJournal(idtask, "E", msg);
						continue begin;//пропускаем этот контракт
					}
					BigDecimal payrate = temp.getPayrate();
					if(payrate == null)
						payrate = atab.getPaymentRate(
							temp.getEJBRef().getHandle(),
							temp.getCurrencyKey().currency,
							false, idAct, true
							);
					sumpays = sumpays.add(sumrub.divide(payrate, 2, BigDecimal.ROUND_HALF_UP));
				}
			}
			LeasePay2BillAccessBean lp2bill = new LeasePay2BillAccessBean(
				idAct.intValue(),//act
				((Integer)contracts.get(i)).intValue(),//contract
				sumpays,//sumpayusd
				false,//flagworkpie
				"A"//recordstatus
				);
		}
				
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в movePayOnAktNri2BufferNri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "movePayOnAktNri2BufferNri");
	}
	return false;
}
void pr(Exception ex, String str) {
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
	System.out.println(new java.util.Date());
	if(ex != null){
		System.out.println(ex.getClass().getName() + " in " + this.getClass().getName() +"."+ str + 
		". Message is:" + ex.getMessage());
		processEx(ex);
		ex.printStackTrace();
	}
	else
		System.out.println(this.getClass().getName() +"."+ str);
	processEx(ex);
	System.out.println("_________________________________________________");
	System.out.println("_________________________________________________");
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
                System.out.println("Error code = " + code);
            }
        } else if (((java.rmi.ServerException)ex).detail instanceof com.ibm.websphere.cpi.CPIException) {
            if (((com.ibm.websphere.cpi.CPIException) 
	            (((java.rmi.ServerException)ex).detail)).detail instanceof java.sql.SQLException) {
                int code = ((java.sql.SQLException) (((com.ibm.websphere.cpi.CPIException)
	                (((java.rmi.ServerException)ex).detail)).detail)).getErrorCode();
                System.out.println("Error code = " + code);
            }
        }
    }
    	}catch(Exception exx){pr(exx, "processEx");}
}
public boolean removeBillPos2DocPos(int idtask, Integer idBillPos) throws java.rmi.RemoteException{
// Удалить начисления для переноса в систему NRI
	try{
		AbonBillpos2docposAccessBean abp = new AbonBillpos2docposAccessBean();
		Enumeration enum = abp.findAbonBillpos2docposesByBillpos(new AbonentBillPosKey(idBillPos.intValue()));
		
		while(enum.hasMoreElements()){
		
			AbonBillpos2docpos temp = (AbonBillpos2docpos)javax.rmi.PortableRemoteObject.narrow(
				enum.nextElement(), AbonBillpos2docpos.class);
			LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(temp.getLeasedocposition());
			Date saldate = getDateLastSaldo(
				idtask, 
				new Integer(lcab.getLeaseContractKey().leaseDocument),
				new Integer(lcab.getResourceKey().resource)
				);
			if(saldate.compareTo(lcab.getDate()) == -1){
				if(!deleteDnopLinkBilling(idtask, lcab.getLeaseDocPosition())){
					String msg="Не удалось удалить связи начисления и платежей созданных в автоматическом режиме";
				addMsgInJournal(idtask, "E", msg);
					return false;
				}
				temp.remove();
			}
		}
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в removeBillPos2DocPos";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "removeBillPos2DocPos");
	}
	return false;
}
public boolean removePayments2DocPos(int idtask, int idPay)throws java.rmi.RemoteException{
// Удалить платежи в системе NRI связанные с платежом billinga
	try{
		AbonPays2docposAccessBean apab = new AbonPays2docposAccessBean();
		Enumeration enum = apab.findAbonPays2docposesByPaypos(new AbonentPaymentKey(idPay));
		while(enum.hasMoreElements()){			
			AbonPays2docposAccessBean temp = (AbonPays2docposAccessBean)enum.nextElement();
			LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
			lpab.setInitKey_leaseDocPosition(temp.getLeasedocpositionKey().leaseDocPosition);
			lpab.refreshCopyHelper();
			Date paydate = lpab.getDate();
			Date saldate = getDateLastSaldo(
				idtask, 
				new Integer(lpab.getLeaseContractKey().leaseDocument),
				new Integer(lpab.getResourceKey().resource));
			if(paydate.compareTo(saldate) <= 0){
				String msg="Платеж "+idPay+" удален не будет. Платеж находится в закрытом периоде.";
				addMsgInJournal(idtask, "E", msg);
			} else {
				deleteDnopLinkBilling(idtask, lpab.getLeaseDocPosition());
				temp.getEJBRef().remove();
			}
		}
		
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в removePayments2DocPos";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "removePayments2DocPos");
	}
	return false;
}
public boolean setParamBillForMoveBill2Nri(int idtask, Integer idBill)throws java.rmi.RemoteException{
	// Установить параметры счета и позиций счта для переноса в систему NRI
	try{
		AbonentBillAccessBean ab = getAbonentBill(idtask, idBill);
		Boolean useInNri = ab.getUseinnri();
		if(useInNri == null)
			if(!defineFlagNeedBill(idtask, ab))
				return false;

		Enumeration enum = ab.getAbonentBillPoses();//все позиции данного счета
		while(enum.hasMoreElements()){
			AbonentBillPos abp = (AbonentBillPos)javax.rmi.PortableRemoteObject.narrow(
				enum.nextElement(), AbonentBillPos.class);
			if(!abp.getSumbyhand()){
				abp.setSummpurenri(abp.getSummpure());
				abp.setSummnri(abp.getSumm());
				abp.setNdssummnri(abp.getNdssumm());
				abp.setNspsummnri(abp.getNspsumm());
			}
		}
		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в setParamBillForMoveBill2Nri";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "setParamBillForMoveBill2Nri");
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
public boolean workAbonentBillPos(int idtask, Integer leaseBill) throws java.rmi.RemoteException{
    // Перенос начисления из буфера NRI в систему NRI
    try {
        AbonentBillAccessBean abab = new AbonentBillAccessBean();
//////////
		if(!abab.getUseinnri().booleanValue() || abab.getRecordstatus().equalsIgnoreCase("D")){
			removeBillPos2DocPos(idtask, leaseBill);
			abab.setFlagworknri(true);
			return true;
		}
//////////
        
        abab.setInitKey_leasebill(leaseBill.intValue());
        abab.refreshCopyHelper();
        Enumeration enum = abab.getAbonentBillPoses();
        while (enum.hasMoreElements()) {
	        AbonentBillPos abp = (AbonentBillPos)javax.rmi.PortableRemoteObject.narrow(
		        enum.nextElement(), AbonentBillPos.class);
	        Integer billpos = new Integer(abp.getBillpos());
	        
            BigDecimal[] sums = getSummBillPos(idtask, billpos);
            BigDecimal locSumNri = sums[0], locNdsSumNri = sums[1];
            if (abp.getSummnri().compareTo(locSumNri) != 0) {
                if (!removeBillPos2DocPos(idtask, billpos)) {
	                String msg="Не удалось удалить начисления для переноса в систему NRI"
	                +" Позиция счета "+billpos;
				addMsgInJournal(idtask, "E", msg);
                    return false;
                }
                sums = getSummBillPos(idtask, billpos);
                locSumNri = sums[0];
                locNdsSumNri = sums[1];
            }
            BigDecimal deltaSum = abp.getSummnri().subtract(locSumNri);
            BigDecimal deltaSumNds = abp.getNdssummnri();
            int contract = abp.getPos2bill().getLeaseabonentbanKey().leaseDocument;
            Date saldate = getDateLastSaldo(
	            idtask, 
	            new Integer(contract), 
	            new Integer(abp.getPos2resourceKey().resource));

            if( (deltaSum.compareTo(getDec(0, 2)) < 0 && deltaSumNds.compareTo(getDec(0, 2)) > 0) ||
			(deltaSum.compareTo(getDec(0, 2)) > 0 && deltaSumNds.compareTo(getDec(0, 2)) < 0)){
				String msg="В начислении "+leaseBill+" deltaSum и deltaSumNds имеют разные знаки";
				addMsgInJournal(idtask, "E", msg);
				return false;
			}

//////////////
			if(abab.getBilldate().compareTo(saldate) != 1){
				String msg="Счет "+leaseBill+" находится в закрытом периоде";
				addMsgInJournal(idtask, "E", msg);
				return false;
			}
//////////////	
            java.sql.Date locdate = null;
            String docposvid;
            if(abab.getBilldate().compareTo(saldate) != 1){
            	locdate = getDatePlus(saldate, 1);
            	docposvid = "C";
            } else {
	            locdate = abab.getBilldate();
	            docposvid = "N";
            }

            ArendaTransactionMethodAccessBean atab = new ArendaTransactionMethodAccessBean();
			Integer leasedocposition;
			if(deltaSum.compareTo(getDec(0, 2)) == 1)
	            leasedocposition = createChargeNri(
		            idtask, 
		            locdate,
		            new Integer(contract),
		            new Integer(abp.getPos2resourceKey().resource),
		            deltaSum,
		            new Integer(abp.getPos2currencyKey().currency),
		            abab.getBillnumber(),
		            atab.calcNds(new Integer(abp.getPos2resourceKey().resource), locdate, deltaSum, "1", idtask),
		            null,
		            docposvid
		            );
	        else
            	leasedocposition = createPaymentNri(
	            	idtask, 
	            	locdate,
	            	new Integer(contract),
	            	docposvid,
	            	new Integer(abp.getPos2resourceKey().resource),
	            	deltaSum,
	            	atab.calcNds(new Integer(abp.getPos2resourceKey().resource), locdate, deltaSum, "1", idtask),
	            	new Integer(abp.getPos2currencyKey().currency),
	            	abab.getBillnumber(),
	            	null,
	            	null,
	            	null
	            	);
            new AbonBillpos2docposAccessBean(
	            leasedocposition.intValue(),
	            abp.getBillpos()
	            );
        }
        return true;
    } catch (Exception ex) {
	    String msg="Техническая ошибка в workAbonentBillPos";
		addMsgInJournal(idtask, "E", msg);
        pr(ex, "workAbonentBillPos");
    }
    return false;
}
public boolean workAbonentPayment(int idtask, Integer idPay)throws java.rmi.RemoteException{
// Перенос платежа из буфера NRI в систему NRI
	try{
		AbonentPaymentAccessBean apab = getAbonentPayment(idtask, idPay);
///////////
		if(apab.getRecordstatus().equalsIgnoreCase("D") || !apab.getNeedpay()){
			removePayments2DocPos(idtask, idPay.intValue());
			apab.setFlagworknri(true);
			return true;
		}
///////////
		BigDecimal locRateNri = apab.getSumnrirur().divide(apab.getSumnriusd(), 4, BigDecimal.ROUND_HALF_UP);
		BigDecimal sumNriRur = apab.getSumnrirur();
		BigDecimal sumNriUsd = apab.getSumnriusd();

		BigDecimal[] locSum = getLocSumm(idtask, idPay);
		BigDecimal locSumNriUsd = locSum[1], locSumNriRur = locSum[0];	

		if(sumNriRur.compareTo(locSumNriRur) != 0 || sumNriUsd.compareTo(locSumNriUsd) != 0){
			removePayments2DocPos(idtask, idPay.intValue());
			locSum = getLocSumm(idtask, idPay);
			locSumNriRur = locSum[0];
			locSumNriUsd = locSum[1];			
		}
		BigDecimal deltaSumUsd = apab.getSumnriusd().subtract(locSumNriUsd);
		BigDecimal deltaSumRur = apab.getSumnrirur().subtract(locSumNriRur);

		Date saldate = getDateLastSaldo(
			idtask, 
			new Integer(apab.getLeaseabonentbanKey().leaseDocument),
			apab.getResource()
			);
		
		Date locdate = null;
		String docposvid = null, docpostype = null;
//////////
		if(apab.getPaydate().compareTo(saldate) != 1){
			String msg="Платеж "+idPay+" находится в закрытом периоде";
			addMsgInJournal(idtask, "E", msg);
			return false;
		}
//////////
		if(apab.getPaydate().compareTo(saldate) != 1){
			locdate = getDatePlus(saldate, 1);
			docposvid = "C";
		} else {
			locdate = apab.getPaydate();
			docposvid = "N";
		}
		if( (deltaSumRur.compareTo(getDec(0, 2)) < 0 && deltaSumUsd.compareTo(getDec(0, 2)) > 0) ||
			(deltaSumRur.compareTo(getDec(0, 2)) > 0 && deltaSumUsd.compareTo(getDec(0, 2)) < 0)){
				String msg="В платеже "+idPay+" deltaSumUsd и deltaSumRur имеют разные знаки";
				addMsgInJournal(idtask, "E", msg);
			return false;
		}
		ArendaTransactionMethodAccessBean atab = new ArendaTransactionMethodAccessBean();
		int znaksum = deltaSumRur.compareTo(getDec(0, 2));
		if(znaksum > 0)
/*locDate - paramdate, текущий договор - paramContract, locDocPosvid - paramDocPosvid, 
resource из платежа - paramResource,  deltaSumUsd paramSum, 
calcNds ( deltaSumUsd) -  paramSumNds,  из системной константы USD - paramCurrency, 
docNumber из платежа - paramDocNumber, deltaSumRub - paramSummRub,
calcNds (deltaSumRub) - paramSummRubNds, SumPayRur / SumPayUsd округляем до 4 знаков  - paramPayRate */		
			createPaymentNri(
				idtask, 
				new java.sql.Date(locdate.getTime()),
				new Integer(apab.getLeaseabonentbanKey().leaseDocument),//contract
				docposvid,
				apab.getResource(),
				deltaSumUsd,
				atab.calcNds(apab.getResource(), locdate, deltaSumUsd, "1", idtask),
				getSystemUsdCurrency(idtask),
				apab.getPaynumber(),
				deltaSumRur,
				atab.calcNds(apab.getResource(), locdate, deltaSumRur, "1", idtask),
				apab.getSumpayrur().divide(apab.getSumpayusd(), 4, BigDecimal.ROUND_HALF_UP)//remainderrate2RUR
				);
		else if(znaksum < 0)
/*locDate - paramdate, текущий договор - paramContract, resource из платежа - paramResource, 
DeltaSumUsd - paramSum, USD из системной константы - paramCurrency, null - paramBillNumber, 
calcnds(DeltaSumUsd, …в том числе НДС.)  - paramSumNds,
SumPayRur / SumPayUsd округляем до 4 знаков - paramRemainderrate2RUR*/		
			createChargeNri(
				idtask, 
				new java.sql.Date(locdate.getTime()),
				new Integer(apab.getLeaseabonentbanKey().leaseDocument),//contract
				apab.getResource(),
				deltaSumUsd,//sum
				getSystemUsdCurrency(idtask), //system currency
				null, //billNumber
				atab.calcNds(apab.getResource(), locdate, deltaSumUsd, "1", idtask),// sumNds
				apab.getSumpayrur().divide(apab.getSumpayusd(), 4, BigDecimal.ROUND_HALF_UP),//remainderrate2RUR
				docposvid
				);

		return true;
	}catch(Exception ex){
		String msg="Техническая ошибка в workAbonentPayment";
		addMsgInJournal(idtask, "E", msg);
		pr(ex, "workAbonentPayment");
	}
	return false;
}
}
