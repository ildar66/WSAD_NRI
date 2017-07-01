package com.hps.july.arenda.sessionbean;

import com.hps.july.jdbcpersistence.*;
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
 * Процедура расчета акта взаимозачета
 */
public class CalculateArendaActBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
	private Integer RUR = null;
	private Integer BASE_RATETYPE_ARENDA = null;
	private Integer ARENDA_RES_EQUIPMENT = null;
	private Integer OUR_COMPANY = null;
	private Integer DEFRULELINKMUTUALCONTRACTS = null;	
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
	private ArendaTransactionMethodAccessBean atab = null;
	private JournalAccessBean journal = null;
	private PrintWriter out = null;
	private boolean vaj = false;
	private boolean debug = true;
	private boolean ifTaskStart = true;
/**
 * Insert the method's description here.
 * Creation date: (19.11.2002 15:41:10)
 * @return java.lang.Integer
 * @param lcab com.hps.july.persistence.LeasePaymentAccessBean
 */
public Integer _makeCompensationChargeTemp(Integer idAct, Integer paymentId) {
    try {
        taskStart(1, "4", null, null, null, idAct);
        initial(idAct);

        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        lpab.setInitKey_leaseDocPosition(paymentId.intValue());
        lpab.refreshCopyHelper();

        return atab._makeCompensationCharge(lpab.getEJBRef().getHandle());
    } catch (Exception ex) {
        pr(ex, "_makeCompensationCharge(LeasePaymentAccessBean lcab)");
        String msg = "Техническая ошибка в _makeCompensationChargeTemp";
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
public Integer _makeCompensationPaymentTemp(Integer idAct, Integer chargeId) {
	try{

		taskStart(1, "4", null, null, null, idAct);
		initial(idAct);

		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
		lcab.setInitKey_leaseDocPosition(chargeId.intValue());
		lcab.refreshCopyHelper();

		return atab._makeCompensationPayment(lcab.getEJBRef().getHandle());
	}catch(Exception ex){
		pr(ex, "makeBalancingPayment(LeaseChargesAccessBean lcab)");
		String msg = "Техническая ошибка в _makeBalancingPayment";
        addMsgInJournal(idtask, "E", msg);	
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
public Integer _makeMutualChargeTemp(Integer idAct, Integer paymentId, BigDecimal minSum) {
    try {

        taskStart(1, "4", null, null, null, idAct);
        initial(idAct);

        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        lpab.setInitKey_leaseDocPosition(paymentId.intValue());
        lpab.refreshCopyHelper();
        return atab._makeMutualCharge(lpab.getEJBRef().getHandle(), minSum);
    } catch (Exception ex) {
        pr(ex, "_makeMutualCharge(LeasePaymentAccessBean lpab, BigDecimal minSum)");
        String msg = "Техническая ошибка в _makeMutualCharge";
        addMsgInJournal(idtask, "E", msg);	
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (15.11.2002 16:43:11)
 * @return java.lang.Integer
 * @param lcab com.hps.july.persistence.LeaseChargesAccessBean
 * @param minSum java.math.BigDecimal
 */
public Integer _makeMutualPaymentTemp(Integer idAct, Integer chargeId, BigDecimal minSum) {
    try {
	 
	    taskStart(1, "4", null, null, null, idAct);
		initial(idAct);
		
	    LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
	    lcab.setInitKey_leaseDocPosition(chargeId.intValue());
	    lcab.refreshCopyHelper();
	    return atab._makeMutualPayment(lcab.getEJBRef().getHandle(), minSum);
    } catch (Exception ex) {
        pr(ex, "_makeMutualPayment(LeaseChargesAccessBean lcab, BigDecimal minSum)");
        String msg = "Техническая ошибка в _makeMutualPayment";
        addMsgInJournal(idtask, "E", msg);	
    }

    return null;
}
private boolean addMsgInJournal(
	int jrnAction, String jrnType, int leaseRule, int leaseDocument, 
	int leaseDocPosition, int leaseDocPosition2, Date date1, Date date2, BigDecimal summ1, BigDecimal summ2, 
	int currency1, int currency2, int resource1, int resource2){

	try{
		return journal.addMsgInJournal(
			jrnAction, jrnType, leaseRule, leaseDocument, leaseDocPosition, leaseDocPosition2,
			date1, date2, summ1, summ2, currency1, currency2, resource1, resource2, idtask
			);
	}catch(Exception ex){
		pr(ex, "addMsgInJournal");
	}
	return false;
}
private boolean addMsgInJournal(int idtask, String jrnType, String jrnMsg){

	try{
		return new JournalAccessBean().addMsgInJournal(idtask, jrnType, jrnMsg);
	}catch(Exception ex){
		pr(ex, "addMsgInJournal");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 17:02:38)
 * @return boolean
 * @param idAct java.lang.Integer
 */
public boolean calcAct(Integer idAct, int operator, Integer economist) throws java.rmi.RemoteException{
    try {
	    pr("\n-------------------------------------------------------------------------------------------");
	    pr("////////calcAct Started!!!////////////");
	    this.act = idAct.intValue();
	    atab = new ArendaTransactionMethodAccessBean();
	    journal = new JournalAccessBean();

	    if(ifTaskStart){
		    pr("------------------------------------------");
		    pr("before taskStart");
		    pr("------------------------------------------");
		    taskStart(operator, "4", null, null, economist, idAct);
	    }
	    ifTaskStart = true;

	    pr("------------------------------------------");
	    pr("before initial");
	    pr("------------------------------------------");
	    if(!initial(idAct)){
		    errorCalcAct();
	    	return false;
	    }

		//pr("////////////Before rollbackTempAct/////////////");
	    //if(!rollbackTempAct()){
		     //errorCalcAct();
	    	//return false;
	    //}

	    pr("////////////Before checkBeginCalcAct/////////////");
	    if(!checkBeginCalcAct(idAct.intValue(), idtask)){
		     errorCalcAct();
	         return false;
	    }
	    pr("////////////Before rollbackAct/////////////");
	    if(!atab.rollbackCalcAct(idAct, idtask)){
		     errorCalcAct();
	    	return false;
	    }
	    

	    
	    if(!checkPayChargeProcessedInNri(idtask)){
		    errorCalcAct();
	    	return false;
	    }
	    pr("------------------------------------------");
	    pr("before checkReglament");
	    pr("------------------------------------------");	    
	    if(!checkReglament()) {
		    errorCalcAct();
	    	return false;
	    }

	    pr("------------------------------------------");
	    pr("before checkPossibilityCreateAct");
	    pr("------------------------------------------");	    
        if (!checkPossibilityCreateAct(idAct)){
		    errorCalcAct();
	    	return false;
	    }

	    pr("------------------------------------------");
	    pr("before calculateContractSaldo");
	    pr("------------------------------------------");	            
        if (!calculateContractSaldo(idAct)){
		    errorCalcAct();
	    	return false;
	    }

	    pr("------------------------------------------");
	    pr("before findAndCalcComplementaryContracts");
	    pr("------------------------------------------");	            
        if (!findAndCalcComplementaryContracts()){
		    errorCalcAct();
	    	return false;
	    }

	    pr("------------------------------------------");
	    pr("before createPayChargeSaldo");
	    pr("------------------------------------------");        
        if (!createPayChargeSaldo(idAct)){
		    errorCalcAct();
	    	return false;
	    }

  	    pr("------------------------------------------");
	    pr("before createStartChargesInOpenPeriod");
	    pr("------------------------------------------");
        if(!createStartChargesInOpenPeriod()){
      	    errorCalcAct();
	    	return false;
	    }

	    pr("------------------------------------------");
	    pr("before closeChargesInPeriodAct");
	    pr("------------------------------------------");        
        if (!closeChargesInPeriodAct()){
		    errorCalcAct();
	    	return false;
	    }
        pr("------------------------------------------");
	    pr("After closeChargesInPeriodAct");
	    pr("------------------------------------------");          

        mutualAct.setActState("R");
        mutualAct.commitCopyHelper();

        pr("------------------------------------------");
	    pr("before fill");
	    pr("------------------------------------------");          
		atab.fillUsedInAct(true);
	    
        taskEnd();

	    pr("CalcActEnd OK");
	    
	    return true;
    } catch (Exception ex) {
	    //if(RemoteException.class.isInstance(ex))
			//throw (RemoteException)ex;
        pr(ex, "calcAct(Integer idAct)");
        String msg = "Техническая ошибка в calcACt";
        addMsgInJournal(idtask, "E", msg);	
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 17:02:38)
 * @return boolean
 * @param idAct java.lang.Integer
 */
public boolean calcAct(Integer idAct, int operator, Integer economist, int argIdtask) throws java.rmi.RemoteException{

	idtask = argIdtask;
	ifTaskStart = false;
	return calcAct(idAct, operator, economist);

}
public boolean calculateContractSaldo(Integer idAct) throws java.rmi.RemoteException{
    try {
        // Отбираем платежи с остатком больше 0		
        ArrayList payments = new ArrayList();
        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        for (int i = 1; i < 4; i++) {
            payments.clear();
            for (int j = 0; j < contracts.size(); j++) {
                Enumeration enum =
                    lpab.findByQBE4(
                        (Integer) contracts.get(j),
                        new Boolean(true), getSqldate(actStartDate),
                        new Boolean(true), getSqldate(actEndDate),
                        new Boolean(true), getDec(0,2),
                        new Boolean(true), (Integer) resources.get(j),
                        new Boolean(false),
                        new Boolean(false),
                        new Boolean(false));
                while (enum.hasMoreElements()) {
                    payments.add(enum.nextElement());
                }
            }

            for (int j = 0; j < payments.size(); j++) {
                LeasePaymentAccessBean temp = (LeasePaymentAccessBean) payments.get(j);
                /*
                    LeaseChargesAccessBean lcab = // Подбираем комплементарное начисление.
                	    getComplementaryChargeByPay(i, temp);
                while (lcab != null) {
                    int chargeid=lcab.getLeaseDocPosition();
                	int paymentid=temp.getLeaseDocPosition();
                    if (!linkCharge2Pay(temp, lcab))
                        return false;
                    if (temp.getRurremainder().compareTo(
                        new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP)) >= 0)
                        break;
                    lcab = getComplementaryChargeByPay(i, temp);
                }
                */
                BigDecimal nulval = getDec(0, 2);
                BigDecimal rurremainder = temp.getRurremainder();
                pr("-----calculateContractSaldo pay="+temp.getLeaseDocPosition());
                while (rurremainder.compareTo(nulval) > 0) {
                        LeaseChargesAccessBean lcab = // Подбираем комплементарное начисление.
    						getComplementaryChargeByPay(i, temp);    											
                	
                    //if null then next payment;
                    if (lcab != null){
	                    //int chargeid=lcab.getLeaseDocPosition();
	                	//int paymentid=temp.getLeaseDocPosition();
						pr("Нашли начисление № "+lcab.getLeaseDocPosition()+"для платежа № "+temp.getLeaseDocPosition());
							
                        if (!linkCharge2Pay(temp, lcab))
                            return false;
                        temp.refreshCopyHelper();
                        rurremainder = temp.getRurremainder();
                        pr("-----rurremainder  платежа № "+lcab.getLeaseDocPosition()+" после linkCharge2Pay = "+rurremainder);
                    }
                    else break;
                }
            }
        }

        // Отбираем все платежи для данного акта
        payments.clear();
        for (int i = 0; i < contracts.size(); i++) {
            Enumeration enum =
                lpab.findByQBE4((Integer) contracts.get(i), new Boolean(true), getSqldate(actStartDate), new Boolean(true), getSqldate(actEndDate), new Boolean(false), null, new Boolean(true), (Integer) resources.get(i), new Boolean(false), new Boolean(false), new Boolean(false));
            while (enum.hasMoreElements())
                payments.add(enum.nextElement());
        }
        // Приведение к основной и дополнительной валюте акта взаимозачета
        for (int i = 0; i < payments.size(); i++) {
            LeasePaymentAccessBean temp = (LeasePaymentAccessBean) payments.get(i);
            if (atab.getPaymentRate(temp.getEJBRef().getHandle(), mainCurrency, false, new Integer(act), false) == null)
                return false;
            if (additionalCurrency != null)
                if (atab.getPaymentRate(temp.getEJBRef().getHandle(), additionalCurrency.intValue(), 
	                false, new Integer(act), false) == null)
                    return false;
        }

        // Отбираем все начисления для данного акта
        ArrayList charges = new ArrayList();
        LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
        for (int i = 0; i < contracts.size(); i++) {
                Enumeration enum = lcab.findByQBE4((Integer) contracts.get(i), new Boolean(true), getSqldate(actStartDate), new Boolean(true), getSqldate(actEndDate), new Boolean(false), null, new Boolean(true), (Integer) resources.get(i), new Boolean(false), //isCalcPosOnly
        new Integer(1) // orderByDate
    );
            while (enum.hasMoreElements())
                charges.add(enum.nextElement());
        }
        //Рассчитываем рублевую сумму для суммы начисления, Привести начисления к основной и дополнительной валюте акта 		
        for (int i = 0; i < charges.size(); i++) {
            LeaseChargesAccessBean temp = (LeaseChargesAccessBean) charges.get(i);
            if (!setChargesRURRate(temp))
                return false;
            if (atab.getChargeRate(temp.getEJBRef().getHandle(), mainCurrency, false) == null)
                return false;
            if (additionalCurrency != null)
                if (atab.getChargeRate(temp.getEJBRef().getHandle(), additionalCurrency.intValue(), false) == null)
                    return false;
        }
        return true;
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
        try {
            String msg = "Техническая ошибка в calculateContractSaldo";
        addMsgInJournal(idtask, "E", msg);	
        } catch (Exception e) {
        }
        pr(ex, "calculateContractSaldo");
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 10:37:59)
 * @return boolean
 * @param idAct java.lang.Integer
 */
//Ресурс платежа и ресурсы оплаченных им начислений все принадлежат или все не принадлежат списку услуг регламента
private boolean checkAllResourcesInPayments(Integer idAct) {
	try{
			
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
		for(int i=0; i<contracts.size(); i++){
			boolean pay = true;
			Enumeration enum = lpab.findByQBE4(// Платежи по дате и контракту
				(Integer) contracts.get(i),
                new Boolean(true), getSqldate(actStartDate),
                new Boolean(true), getSqldate(actEndDate),
                new Boolean(false), null,
                new Boolean(false), null,
                new Boolean(false),
                new Boolean(false), new Boolean(false)
                );
			while(enum.hasMoreElements()){ 
				LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
				int pResource = temp.getResourceKey().resource;
				if(!resources.contains(new Integer(pResource))){					
					pay = false;
				}
				LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean();
				Enumeration dnop = dnab.findLeaseDNOPPayByLeasePayment(
					new LeaseDocPositionKey(temp.getLeaseDocPosition()));
				while(dnop.hasMoreElements()){
					LeaseDNOPAccessBean dn = (LeaseDNOPAccessBean)dnop.nextElement();
					LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();// Начисление данного платежа
					lcab.setInitKey_leaseDocPosition(dn.getLeaseChargeKey().leaseDocPosition);
					lcab.refreshCopyHelper();
					int chResource = lcab.getResourceKey().resource;
					if(!resources.contains(new Integer(chResource))){
						if(pay){
							pr("checkAllResourcesInPayments (); Resource not exist !!!");
							addMsgInJournal(104, "E", -1, act, 
								temp.getLeaseDocPosition(), lcab.getLeaseDocPosition(),
								null, null, null, null,
								-1, -1, pResource, chResource);
							return false;// Платеж принадлежит, начисление не принадлежит
						}
					} else if(resources.contains(new Integer(chResource))){
						if(!pay){
							pr("checkAllResourcesInPayments (); Resource not exist !!!");
							addMsgInJournal(105, "E", -1, act,
								temp.getLeaseDocPosition(), lcab.getLeaseDocPosition(),
								null, null, null, null,
								-1, -1, pResource, chResource);
							return false;// Платеж не принадлежит, начисление принадлежит
						}
					}
				}
			}
		}
	return true;
    } catch (Exception ex) {        
        try{
	        String msg = "Техническая ошибка в checkAllResourcesInPayments";
        addMsgInJournal(idtask, "E", msg);	
	    }catch(Exception e){}
        pr(ex, "checkAllResourcesInPayments(Integer idAct)");
    }
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 10:37:59)
 * @return boolean
 * @param idAct java.lang.Integer
 */
//Ресурс платежа и ресурсы оплаченных им начислений все принадлежат или все не принадлежат списку услуг регламента
public boolean checkAllResourcesInPaymentsTemp(Integer idAct)throws java.rmi.RemoteException {
	try{
		
		taskStart(1, "4", null, null, null, idAct);
		initial(idAct);




		
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
		for(int i=0; i<contracts.size(); i++){
			boolean pay = true;
			Enumeration enum = lpab.findByQBE4(// Платежи по дате и контракту
				(Integer) contracts.get(i),
                new Boolean(true), getSqldate(actStartDate),
                new Boolean(true), getSqldate(actEndDate),
                new Boolean(false), null,
                new Boolean(false), null,
                new Boolean(false),
                new Boolean(false), new Boolean(false)
                );
			while(enum.hasMoreElements()){ 
				LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
				int pResource = temp.getResourceKey().resource;
				if(!resources.contains(new Integer(pResource))){					
					//pr(null, "checkAllResourcesInPayments (); Resource not exist !!!");
					pay = false;
				}
				LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean();
				Enumeration dnop = dnab.findLeaseDNOPPayByLeasePayment(
					new LeaseDocPositionKey(temp.getLeaseDocPosition()));
				while(dnop.hasMoreElements()){
					LeaseDNOPAccessBean dn = (LeaseDNOPAccessBean)dnop.nextElement();
					LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();// Начисление данного платежа
					lcab.setInitKey_leaseDocPosition(dn.getLeaseChargeKey().leaseDocPosition);
					lcab.refreshCopyHelper();
					int chResource = lcab.getResourceKey().resource;
					if(!resources.contains(new Integer(chResource))){
						if(pay){
							pr("checkAllResourcesInPayments (); Resource not exist !!!");
							addMsgInJournal(104, "E", -1, act, 
								temp.getLeaseDocPosition(), lcab.getLeaseDocPosition(),
								null, null, null, null,
								-1, -1, pResource, chResource);
							return false;// Платеж принадлежит, начисление не принадлежит
						}
					} else if(resources.contains(new Integer(chResource))){
						if(!pay){
							pr("checkAllResourcesInPayments (); Resource not exist !!!");
							addMsgInJournal(105, "E", -1, act,
								temp.getLeaseDocPosition(), lcab.getLeaseDocPosition(),
								null, null, null, null,
								-1, -1, pResource, chResource);
							return false;// Платеж не принадлежит, начисление принадлежит
						}
					}
				}
			}
		}
	return true;
    } catch (Exception ex) {
        pr(ex, "checkAllResourcesInPaymentsTemp(Integer idAct)");
        String msg = "Техническая ошибка в checkAllResourcesInPaymentsTemp";
        addMsgInJournal(idtask, "E", msg);	
    }
	return false;
}
private boolean checkBeginCalcAct(int actid, int taskid){
	
	java.sql.Connection con = null;
	java.sql.PreparedStatement ps = null;
	java.sql.ResultSet rs = null;
	try {
		con = getConnection();
		ps = con.prepareStatement("execute procedure CheckBeginCalcAct(?, ?)");
		ps.setInt(1, taskid);
		ps.setInt(2, actid);
		rs = ps.executeQuery();
		if(!rs.next()){
			return false;
		}
		if(rs.getInt(1) != 0){
			return false;
		}
		return true;	
	} catch (Exception e) {
		pr("Error in CalculateArendaAct.checkBeginCalcAct()");
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
 * Creation date: (06.11.2002 10:37:59)
 * @return boolean
 * @param idAct java.lang.Integer
 */
private boolean checkOplCharges(Integer idAct) throws RemoteException{
    try {
        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        for (int i = 0; i < contracts.size(); i++) {
                Enumeration enum = lpab.findByQBE4(// Платежи по контракту
     				(Integer) contracts.get(i),
     				new Boolean(true), getSqldate(actStartDate), 
     				new Boolean(true), getSqldate(actEndDate), 
     				new Boolean(false), null, 
     				new Boolean(true), (Integer) resources.get(i), 
     				new Boolean(false),
     				new Boolean(false), new Boolean(false)
     				);
            while (enum.hasMoreElements()) {
                LeasePaymentAccessBean temp = (LeasePaymentAccessBean) enum.nextElement();
                
                BigDecimal sumrub = temp.getSumRub();
                BigDecimal sum = temp.getSumm();
                if((sumrub == null || //Если нет рублевой суммы
	                sumrub.compareTo(getDec(0,2)) == 0) &&
                	sum.compareTo(getDec(0,2)) >0){
                	addMsgInJournal(181, "E", -1, act,
	                            temp.getLeaseDocPosition(), -1,
	                            temp.getDate(), null, null, null,
	                            -1, -1, -1, -1) ;
                	return false;
                }
				if(!temp.getPaymentstate().equalsIgnoreCase("P")){//Если платеж в состоянии "не оплачено"
					addMsgInJournal(183, "E", -1, act,
	                            temp.getLeaseDocPosition(), -1,
	                            actStartDate, actEndDate, null, null,
	                            -1, -1, -1, -1) ;
					return false;
				}
                	
                LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean();
                Enumeration dnop = dnab.findLeaseDNOPPayByLeasePayment(
	                new LeaseDocPositionKey(temp.getLeaseDocPosition()));
                while (dnop.hasMoreElements()) {
                    LeaseDNOPAccessBean dn = (LeaseDNOPAccessBean) dnop.nextElement();
                    LeaseChargesAccessBean lcab = new LeaseChargesAccessBean(); // Начисление данного платежа
                    lcab.setInitKey_leaseDocPosition(dn.getLeaseChargeKey().leaseDocPosition);
                    try {
                        lcab.refreshCopyHelper();
                        long chargedate = lcab.getDate().getTime();
                        if ((chargedate <= actStartDate.getTime()) || (chargedate >= actEndDate.getTime())) {
                            addMsgInJournal(106, "E", -1, act,
	                            temp.getLeaseDocPosition(), lcab.getLeaseDocPosition(),
	                            actStartDate, actEndDate, null, null,
	                            -1, -1, -1, -1) ;
                            return false;
                        }
                    } catch (Exception ex) {
                        if (!(ex instanceof FinderException)){
	                        addMsgInJournal(125, "E", -1, idAct.intValue(),
	                            temp.getLeaseDocPosition(), dn.getLeaseChargeKey().leaseDocPosition,
	                            null, null, null, null,
	                            -1, -1, -1, -1) ;
                            throw ex;
                        }
                    }
                }
            }
        }

        LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
        for (int i = 0; i < contracts.size(); i++) {
            Enumeration enum = lcab.findByQBE4( // Начисления по контракту
	        	(Integer)contracts.get(i), 
	        	new Boolean(true), getSqldate(actStartDate), 
	        	new Boolean(true), getSqldate(actEndDate),
	        	new Boolean(false), null,
	        	new Boolean(true), (Integer)resources.get(i),
	            new Boolean(false),//isCalcPosOnly
	            new Integer(1)// orderByDate
	        	);
            while (enum.hasMoreElements()) {
                LeaseChargesAccessBean temp = (LeaseChargesAccessBean) enum.nextElement();
                LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean();
                Enumeration dnop = dnab.findLeaseDNOPByLeaseCharge(
	                new LeaseDocPositionKey(temp.getLeaseDocPosition()));
                while (dnop.hasMoreElements()) {
                    LeaseDNOPAccessBean dn = (LeaseDNOPAccessBean) dnop.nextElement();
                    LeasePaymentAccessBean pab = new LeasePaymentAccessBean(); // Платеж данного начисления
                    pab.setInitKey_leaseDocPosition(dn.getLeasePaymentKey().leaseDocPosition);
                    try{
                    	pab.refreshCopyHelper();
                    	long paydate = pab.getDate().getTime();
                    	if ((paydate <= actStartDate.getTime()) || (paydate >= actEndDate.getTime())) {
                     	   addMsgInJournal(107, "E", -1, act,
	                            temp.getLeaseDocPosition(), pab.getLeaseDocPosition(),
	                            actStartDate, actEndDate, null, null,
	                            -1, -1, -1, -1) ;
                      	  return false;
                    	}
                    }catch(Exception ex){
	                    if (!(ex instanceof FinderException)){
		                    addMsgInJournal(126, "E", -1, idAct.intValue(),
	                            temp.getLeaseDocPosition(), dn.getLeaseChargeKey().leaseDocPosition,
	                            null, null, null, null,
	                            -1, -1, -1, -1) ;
                            throw ex;
	                    }
                    }
                }
            }
        }

        return true;
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в checkOplCharges";
        addMsgInJournal(idtask, "E", msg);	
        pr(ex, "checkOplCharges(Integer idAct)");
        throw (RemoteException)ex;
    }
    //return false;
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 10:37:59)
 * @return boolean
 * @param idAct java.lang.Integer
 */
public boolean checkOplChargesTemp(Integer idAct)throws java.rmi.RemoteException {
    try {
		taskStart(1, "4", null, null, null, idAct);
		initial(idAct);
	    
        return checkOplCharges(idAct);
    } catch (Exception ex) {
        pr(ex, "checkOplChargesTemp(Integer idAct)");
        String msg = "Техническая ошибка в checkOplChargesTemp";
        addMsgInJournal(idtask, "E", msg);	
    }
    return false;
}
/**
При обсчете акта, когда производятся проверки возможности рассчета
надо проверить, что все платежи и счета абонентских договоров,
которые указаны в Регламенте, обработаны в системе NRI

 */
private boolean checkPayChargeProcessedInNri(int taskid) throws RemoteException{
	
	try {
		boolean result = true;
		
        for(int i=0; i < contractsUnic.size(); i++){
	        AbonentBillAccessBean abab = new AbonentBillAccessBean();
			Enumeration enum = abab.findByQBE(
				Boolean.TRUE, (Integer)contractsUnic.get(i),
				Boolean.TRUE, getSqldate(actStartDate), getSqldate(actEndDate),
				Boolean.FALSE, null,
				new Integer(1)
				);
			while(enum.hasMoreElements()){
				AbonentBillAccessBean temp = (AbonentBillAccessBean)enum.nextElement();
				if(temp.getUseinnri().booleanValue()){
					if(!temp.getFlagworknri()){//Если не обработан в системе
						String msg = "В акте №="+act+" по договору №="+(Integer)contractsUnic.get(i)
						+" есть необработанный счет (из биллинга) №="+temp.getLeasebill();
						addMsgInJournal(taskid, "E", msg);
						result = false;
					}
				}
			}
///////////////////
			AbonentPaymentAccessBean apab = new AbonentPaymentAccessBean();
			enum = apab.findByDocumentQBE(
				(Integer)contractsUnic.get(i),
				Boolean.TRUE, getSqldate(actStartDate), getSqldate(actEndDate),
				new Integer(1)
				);
			while(enum.hasMoreElements()){
				AbonentPaymentAccessBean temp = (AbonentPaymentAccessBean)enum.nextElement();
				if(temp.getNeedpay()){
					if(!temp.getFlagworknri()){//Если не обработан в системе
						String msg = "В акте №="+act+" по договору №="+(Integer)contractsUnic.get(i)
						+" есть необработанный платеж (из биллинга) №="+temp.getPaypos();
						addMsgInJournal(taskid, "E", msg);
						result = false;
					}
				}
			}
        }
	    
	    return result;
    } catch (Exception ex) {
	    String msg = "Техническая ошибка в CalculateArendaAct.checkPayChargeProcessedInNri"
	    	+" msg is"+ex.getMessage();
	    	addMsgInJournal(taskid, "E", msg);
        pr(ex, "checkPayChargeProcessedInNri(int taskid)");
        throw (RemoteException)ex;
    }    
}
private boolean checkPaysInAct() {
    try { 
        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        for (int i = 0; i < contracts.size(); i++) {
                Enumeration enum = lpab.findByQBE4(// Платежи по дате и контракту
				        (Integer) contracts.get(i),
			            new Boolean(true),  getSqldate(actStartDate),
			            new Boolean(true),  getSqldate(actEndDate),
			            new Boolean(false), null, //remaider
				        new Boolean(true), (Integer) resources.get(i), //resource
				        new Boolean(false), //isCalcposOnly
				        new Boolean(false), new Boolean(false) //isAutoRUR
					    );
                while(enum.hasMoreElements()){
	                LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
	                if(temp.getDocposvid().equals("Q") || temp.getDocposvid().equals("K")){
		                addMsgInJournal(180, "E", -1, act, 
			                temp.getLeaseDocPosition(), -1, null, null, null, null, -1, -1, -1, -1);
		                return false;
	                }
	                if(temp.getDocposvid().equals("N") && 
		                (temp.getSumRub() == null || temp.getRurremainder() == null)){
			                addMsgInJournal(181, "E", -1, act,
		                            temp.getLeaseDocPosition(), -1,
		                            temp.getDate(), null, null, null, -1, -1, -1, -1);
		                return false;
	                }
	   				if(temp.getPaymentstate().equals("P") && temp.getRurremainder() == null){
						addMsgInJournal(181, "E", -1, act,
		                            temp.getLeaseDocPosition(), -1,
		                            temp.getDate(), null, null, null,
		                            -1, -1, -1, -1);
						return false;
					}
                }

        }
        return true;
    } catch (Exception ex) {        
        try {
        String msg = "Техническая ошибка в checkPaysInAct";
        addMsgInJournal(idtask, "E", msg);	
        } catch (Exception e) {
        }
        pr(ex, "checkPaysInAct()");
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 10:37:59)
 * @return boolean
 * @param idAct java.lang.Integer
 */
private boolean checkPossibilityCreateAct(Integer idAct) throws RemoteException{
	try{ 
		if(!getPreviousSaldo(idAct)) return false;
		if(!checkAllResourcesInPayments(idAct)) return false;
		if(!atab.setRateRurForPayment()) return false;
		if(!checkPaysInAct()) return false;
		if(!checkOplCharges(idAct)) return false;
	return true;
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
			throw (RemoteException)ex;
        pr(ex, "checkPossibilityCreateAct(Integer idAct)");
        String msg = "Техническая ошибка в checkPossibilityCreateAct";
        addMsgInJournal(idtask, "E", msg);	 
    }
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2002 16:32:12)
 * @return boolean
 */
private boolean checkReglament() {
	try{
	if(reglamentState.equalsIgnoreCase("B")) return true;
	// Сообщение в журнал
	int iderror;
	if(reglamentState.equalsIgnoreCase("A"))//вводится
		iderror = 101;
	else
		iderror = 102;// закрыт
	 addMsgInJournal(iderror, "E", -1, reglament, -1, -1, actStartDate, actEndDate, null, null, -1, -1, -1, -1 );
	}catch(Exception ex){		
		String msg = "Техническая ошибка в checkReglament";
        addMsgInJournal(idtask, "E", msg);	
		pr(ex, "Error in CalculateArendaAct.checkReglament");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 11:47:32)
 * @return boolean
 * @param idPayment java.lang.Integer
 * @param idCharge java.lang.Integer
 */
public boolean clearCharge2Pay(Integer idPayment, Integer idCharge) throws java.rmi.RemoteException{
	try{
		LeaseDNOPAccessBean ab = new LeaseDNOPAccessBean();
		ab.setInitKey_leasePayment_leaseDocPosition(idPayment);
		ab.setInitKey_leaseCharge_leaseDocPosition(idCharge);
		ab.refreshCopyHelper();
		return atab.clearCharge2Pay(ab.getEJBRef().getHandle(), idtask);
	}catch(Exception ex){		
		String msg = "Техническая ошибка в CalculateArendaAct.clearCharge2Pay";
        addMsgInJournal(idtask, "E", msg);	
		pr(ex, "clearCharge2Pay");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (04.11.2002 18:24:45)
 */
private boolean clearCharge2PayOnAktLink(Integer idAkt) {
//1 Удаляем автоматические связи в периоде акта и производим соответствующую коррекцию остатков
    try {
        LeaseDNOPAccessBean ab = new LeaseDNOPAccessBean();
		Enumeration enum = ab.findByActAndHand(idAkt, "N");//New Finder !!!
		while(enum.hasMoreElements()){
			LeaseDNOPAccessBean temp = (LeaseDNOPAccessBean)enum.nextElement();
			if(! atab.clearCharge2Pay(temp.getEJBRef().getHandle(), idtask) )
			return false;
		}

        return true;
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в CalculateArendaAct.clearCharge2PayOnAktLink";
        addMsgInJournal(idtask, "E", msg);	
        pr(ex, "clearCharge2PayOnAktLink(Integer idAkt)");
    }

    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (05.11.2002 11:47:32)
 * @return boolean
 * @param idPayment java.lang.Integer
 * @param idCharge java.lang.Integer
 */
public boolean clearCharge2PayTemp(Integer idAct, Integer idPayment, Integer idCharge)throws java.rmi.RemoteException {
	
	try{
		taskStart(1, "4", null, null, null, idAct);
		initial(idAct);

		
	
		LeaseDNOPAccessBean ab = new LeaseDNOPAccessBean();
		ab.setInitKey_leasePayment_leaseDocPosition(idPayment);
		ab.setInitKey_leaseCharge_leaseDocPosition(idCharge);
		ab.refreshCopyHelper();
		return atab.clearCharge2Pay(ab.getEJBRef().getHandle(), idtask);
	}catch(Exception ex){
		pr(ex, "clearCharge2PayTemp");
		String msg = "Техническая ошибка в CalculateArendaAct.clearCharge2PayTemp";
        addMsgInJournal(idtask, "E", msg);	
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2002 10:47:48)
 * @return boolean
 */
public boolean closeChargesInPeriodAct() throws java.rmi.RemoteException{
	try{
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
		for(int i=0; i<contracts.size(); i++){			        
        	Enumeration enum = lcab.findByQBE4(
	        	(Integer)contracts.get(i), 
	        	new Boolean(true), getSqldate(actStartDate), 
	        	new Boolean(true), getSqldate(actEndDate),
	        	new Boolean(true), getDec(0,2),
	        	new Boolean(true), (Integer)resources.get(i),
	            new Boolean(false),//isCalcPosOnly
	            new Integer(1)// orderByDate
	        	);	        	
        	while(enum.hasMoreElements()){
	        	LeaseChargesAccessBean temp = (LeaseChargesAccessBean)enum.nextElement();
	        	if(atab._makeCompensationPayment(temp.getEJBRef().getHandle()) == null){
					addMsgInJournal(123, "E", -1, act,
						temp.getLeaseDocPosition(), -1, null, null, null, null, 
						-1, -1, -1, -1);
		        	return false;
	        	}
        	}

	        enum = lpab.findByQBE4(		        
			    (Integer)contracts.get(i), 
		  	    new Boolean(true), getSqldate(actStartDate), 
	        	new Boolean(true), getSqldate(actEndDate),
	        	new Boolean(true), getDec(0,2),
	        	new Boolean(true), (Integer)resources.get(i),
	        	new Boolean(false),
	        	new Boolean(false), new Boolean(false)
	        	);
	        	while(enum.hasMoreElements()){
		        	LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
	        		if(atab._makeCompensationCharge(temp.getEJBRef().getHandle()) == null){
		        		addMsgInJournal(124, "E", -1, act, 
						temp.getLeaseDocPosition(), -1, null, null, null, null, 
						-1, -1, -1, -1);
		        		return false;
	        		}
	        	}
		}
		return true;
	}catch(Exception ex){		
		String msg = "Техническая ошибка в CalculateArendaAct.closeChargesInPeriodAct";
        addMsgInJournal(idtask, "E", msg);	
		pr(ex, "closeChargesInPeriodAct");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 10:36:18)
 * @return boolean
 * @param contract1 com.hps.july.persistence.LeaseContractAccessBean
 * @param contract2 com.hps.july.persistence.LeaseContractAccessBean
 */
private boolean compareContracts(int idContract1, int idContract2) throws RemoteException{
    try {
	    LeaseContractAccessBean lcon1 = new LeaseContractAccessBean();
	    lcon1.setInitKey_leaseDocument(idContract1);
	    lcon1.refreshCopyHelper();

	    LeaseContractAccessBean lcon2 = new LeaseContractAccessBean();
	    lcon2.setInitKey_leaseDocument(idContract2);
	    lcon2.refreshCopyHelper();
	    return compareContracts(lcon1, lcon2);
	    
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
			throw (RemoteException)ex;
        pr(ex, "compareContracts(int idContract1, int idContract2)");
        String msg = "Техническая ошибка в CalculateArendaAct.compareContracts(int, int)";
        addMsgInJournal(idtask, "E", msg);	
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 10:36:18)
 * @return boolean
 * @param contract1 com.hps.july.persistence.LeaseContractAccessBean
 * @param contract2 com.hps.july.persistence.LeaseContractAccessBean
 */
private boolean compareContracts(LeaseContractAccessBean contract1, LeaseContractAccessBean contract2) throws RemoteException{
    try {
        BigDecimal dolg1 = getSaldoContract(contract1);
        if(dolg1 == null){
	        String msg = "Не рассчитано сальдо для договора "+contract1.getLeaseDocument();
	        addMsgInJournal(idtask, "E", msg);
	        throw new RemoteException();
        }
        BigDecimal dolg2 = getSaldoContract(contract2);
        if(dolg2 == null){
	        String msg = "Не рассчитано сальдо для договора "+contract2.getLeaseDocument();
	        addMsgInJournal(idtask, "E", msg);
	        throw new RemoteException();
        }
        

	    int znakDolg1 = dolg1.compareTo(getDec(0,2));
	    int znakDolg2 = dolg2.compareTo(getDec(0,2));
	    if( (znakDolg1 + znakDolg2) == -2 )return true;
	    if( (znakDolg1 + znakDolg2) == 2 )return true;
	    else return false;
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
			throw (RemoteException)ex;
        String msg = "Техническая ошибка в CalculateArendaAct.clearCharge2PaycompareContracts(LeaseContractAccessBean contract1, LeaseContractAccessBean contract2)";
        addMsgInJournal(idtask, "E", msg);	
        pr(ex, "compareContracts(LeaseContractAccessBean contract1, LeaseContractAccessBean contract2)");
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 10:36:18)
 * @return boolean
 * @param contract1 com.hps.july.persistence.LeaseContractAccessBean
 * @param contract2 com.hps.july.persistence.LeaseContractAccessBean
 */
public boolean compareContracts(Integer idAct, int idContract1, int idContract2) throws java.rmi.RemoteException{
    try {
	    taskStart(1, "4", null, null, null, idAct);
		initial(idAct);

		return compareContracts(idContract1, idContract2);
	    
    } catch (Exception ex) {
        pr(ex, "compareContracts(Integer act, int idContract1, int idContract2)");   
        String msg = "Техническая ошибка в CalculateArendaAct.compareContracts(Integer act, int idContract1, int idContract2)";
        addMsgInJournal(idtask, "E", msg);	 
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 12:24:48)
 * @return boolean
 * @param idAct java.lang.Integer
 */
public boolean createPayChargeSaldo(Integer idAct) throws java.rmi.RemoteException{
	try{ 
		for(int i=0; i<contracts.size(); i++){
			BigDecimal[]sums = getSaldoContractResource(
				(Integer)contracts.get(i), (Integer)resources.get(i), mainCurrency);
			BigDecimal[] additionalSums = null;
			if(additionalCurrency != null)
				additionalSums = getSaldoContractResource(
				(Integer)contracts.get(i), (Integer)resources.get(i), additionalCurrency.intValue());
			BigDecimal additionalSum = additionalSums == null? null:additionalSums[0];
			BigDecimal additionalNds = additionalSums == null? null:additionalSums[1];
			if(!atab._addToLeaseSaldo((Integer)contracts.get(i), (Integer)resources.get(i),
				sums[0], additionalSum,	sums[1], additionalNds)){
					addMsgInJournal(121, "E", -1, ((Integer)contracts.get(i)).intValue(), 
						-1, -1, actEndDate, null, sums[0], additionalSum,
						-1, -1, ((Integer)resources.get(i)).intValue(), -1);
					return false;
				}
		}

		
		return true;
	}catch(Exception ex){
		if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
		String msg = "Техническая ошибка в CalculateArendaAct.createPayChargeSaldo";
        addMsgInJournal(idtask, "E", msg);	
		pr(ex, "createPayChargeSaldo(Integer idAct)");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 15:04:12)
 * @return boolean
 */
private boolean createStartChargesInOpenPeriod() {
	try{
		LeaseSaldoAccessBean lsab = null;
		for(int i=0; i<contracts.size(); i++){
			lsab = new LeaseSaldoAccessBean();
			lsab.setInitKey_leaseContract((Integer)contracts.get(i));
			lsab.setInitKey_resource_resource((Integer)resources.get(i));
			lsab.setInitKey_SalDate(getSqldate(actEndDate));
			lsab.refreshCopyHelper();
			BigDecimal mainSum = lsab.getMainsum();
			int znakSum = mainSum.compareTo(getDec(0,2));
			if(znakSum >0){
				if(!atab._makeSaldoCharge(lsab.getEJBRef().getHandle()))
					return false;
			} else if(znakSum <0) {
				if(!atab._makeSaldoPayment(lsab.getEJBRef().getHandle()))
					return false;
			}
		}
		return true;
	}catch(Exception ex){		
		String msg = "Техническая ошибка в CalculateArendaAct.createStartChargesInOpenPeriod";
        addMsgInJournal(idtask, "E", msg);	
		pr(ex, "createStartChargesInOpenPeriod()");
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
        pr(ex, "Error in CalculateArendaAct.ejbActivate");
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
        pr(ex, "Error in CalculateArendaAct.ejbCreate");
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
		System.out.println("((((((((((((((( Error in CalculateArendaAct - ejbPassivate ))))))))))))))");
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
		System.out.println("((((((((((((((( Error in CalculateArendaAct - ejbRemove ))))))))))))))");
	}

}
private void errorCalcAct(){
	try{
		String msg = "Рассчет акта "+act+" завершился не удачно";
        addMsgInJournal(idtask, "E", msg);	
	}catch(Exception ex){}
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 16:27:24)
 * @return boolean
 */
public boolean findAndCalcComplementaryContracts() throws java.rmi.RemoteException{
	java.sql.Connection con = null;
	java.sql.PreparedStatement ps = null;
	try{
		if(contractsUnic.size() == 1) 
			return true;
		else if(contractsUnic.size() == 0){
        	addMsgInJournal(128, "E", -1, act, 
	        	-1, -1, null, null, null, null,  
	        	-1, -1, -1, -1);		    
			return false;
		}
		Object[][] contractProps = new Object[contractsUnic.size()][5];
// договор, заказчик, исполнитель, Компания заказчика-Beeline/NoBeeline, Компания исполнителя-Beeline/NoBeeline
		LeaseContractAccessBean lconab = null;
	    for(int i=0; i<contractsUnic.size(); i++){
		    lconab = new LeaseContractAccessBean();
		    lconab.setInitKey_leaseDocument(((Integer)contractsUnic.get(i)).intValue());
		    lconab.refreshCopyHelper();
		    contractProps[i][0] = new Integer(lconab.getLeaseDocument());
		    contractProps[i][1] = lconab.getOrgCustomer();//OrganizationNfsAccessBean
		    contractProps[i][2] = lconab.getOrgExecutor();//OrganizationNfsAccessBean
		    contractProps[i][3] = new Boolean(isMemberBeeline(lconab.getOrgCustomer()));
		    contractProps[i][4] = new Boolean(isMemberBeeline(lconab.getOrgExecutor()));
	    }
	    
		if(getNamedValueInt("DEFRULELINKMUTUALCONTRACTS", idtask) == 1) {
			con = getConnection();
			ps = con.prepareStatement("execute procedure linkMutualContract(?,?,?,?);");
			for(int i=1; i<=5; i++){
				for(int j=0; j<contractsUnic.size(); j++){
					Integer contract1 = (Integer)contractsUnic.get(j);
					Integer contract2 = getComplimentaryContracts(i, contract1, contractProps);
pr("Contract1="+contract1);
					if(contract2 == null) continue;
pr("Contract2="+contract2);
					ps.setInt(1, act);
					ps.setInt(2, contract1.intValue());
					ps.setInt(3, contract2.intValue());
					ps.setInt(4, idtask);
					java.sql.ResultSet rs = ps.executeQuery();
					rs.next();
					if(rs.getInt(1)==0){
						addMsgInJournal(idtask, "E", "Ошибка в процедуре linkMutualContract");
						throw new RemoteException("Процедура linkMutualContract не отработала");
					}
				}
			}			
		} else {
			for(int i=1; i<=5; i++){
				for(int j=0; j<contractsUnic.size(); j++){
					Integer contract1 = (Integer)contractsUnic.get(j);
					Integer contract2 = getComplimentaryContracts(i, contract1, contractProps);
pr("Contract1="+contract1);
					if(contract2 == null) continue;
pr("Contract2="+contract2);
					makeMutualCharges (contract1, contract2);
				}
			}			
		}
	    
		for(int i=1; i<=5; i++){
			for(int j=0; j<contractsUnic.size(); j++){
				Integer contract1 = (Integer)contractsUnic.get(j);
				Integer contract2 = getComplimentaryContracts(i, contract1, contractProps);
pr("Contract1="+contract1);
				if(contract2 == null) continue;
pr("Contract2="+contract2);
				makeMutualCharges (contract1, contract2);
			}
		}
		return true;
	}catch(Exception ex){	
		if(RemoteException.class.isInstance(ex))
			throw (RemoteException)ex;
		String msg = "Техническая ошибка в CalculateArendaAct.findAndCalcComplementaryContracts";
        addMsgInJournal(idtask, "E", msg);	
		pr(ex, "findAndCalcComplementaryContracts()");
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){};
		try{if(con != null) con.close();}catch(Exception e){};
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 16:27:24)
 * @return boolean
 */
public boolean findAndCalcComplementaryContractsTemp(Integer idAct)throws java.rmi.RemoteException {
	try{
		taskStart(1, "4", null, null, null, idAct);
		initial(idAct);

		return findAndCalcComplementaryContracts();
	}catch(Exception ex){
		pr(ex, "findAndCalcComplementaryContractsTemp()");
		String msg = "Техническая ошибка в CalculateArendaAct.findAndCalcComplementaryContractsTemp";
        addMsgInJournal(idtask, "E", msg);	
	}
	return false;
}
private Object[] findSidesOfContract(Integer contract, int compare) throws Exception{ 
    try {
	    Enumeration enum = null;
        if (compare > 0) {
            LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
            enum = lcab.findByQBE4(
            	contract, 
	        	new Boolean(true), getSqldate(actStartDate), 
	        	new Boolean(true), getSqldate(actEndDate),
	        	new Boolean(true), getDec(0,2),
	        	new Boolean(false), null,//resource
	            new Boolean(false),//isCalcPosOnly
	            new Integer(1)// orderByDate
				);
        } else {
	        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
            enum = lpab.findByQBE4(
            	contract, 
	        	new Boolean(true), getSqldate(actStartDate), 
	        	new Boolean(true), getSqldate(actEndDate),
	        	new Boolean(true), getDec(0,2),
	        	new Boolean(false), null,//resource
	        	new Boolean(false),
	        	new Boolean(false), new Boolean(false)
	        	);            
        }
        ArrayList ar = new ArrayList();
        while(enum.hasMoreElements())
        	ar.add(enum.nextElement());
        if(ar.isEmpty())
        	return new Object[]{};
        else
        	return ar.toArray();
    } catch (Exception ex) {
	    pr(ex, "findSidesOfContract");	    
        String msg = "Ошибка при поиске начислений/платежей для договора "+contract.intValue();
    	addMsgInJournal(idtask, "E", msg);
		throw ex;
    }
}
private BigDecimal[] getAddSumForSaldo(BigDecimal allSumOst, BigDecimal allNdsOst,
	Integer idContract, Integer resource)throws RemoteException{
    try {
	    pr("((((((((((((((((getAddSumForSaldo start)))))))))))))))))");
	    pr("На входе allSumOst="+allSumOst+" allNdsOst="+allNdsOst+" idContract="+idContract+" resource="+resource);
	    BigDecimal addSum = getDec(0, 2);
	    BigDecimal addNds = getDec(0, 2);
        LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
        Enumeration enum = lcab.findByQBE4(
	        idContract, 
	        new Boolean(true), getSqldate(actStartDate), 
	        new Boolean(true), getSqldate(actEndDate),
	        new Boolean(false), null,
	        new Boolean(true), resource,
	        new Boolean(false),//isCalcPosOnly
	        new Integer(1)// orderByDate
	        );

        pr("!!!!!!!!!Найденные начисления!!!!!!!!!!!!!");
        while(enum.hasMoreElements()){
	        LeaseChargesAccessBean temp = (LeaseChargesAccessBean)enum.nextElement();
	        printCharge(temp);
	        Enumeration dnops = temp.getLeaseDNOP();
	        BigDecimal tempSum = getDec(0, 2);
	        while(dnops.hasMoreElements()){
		       LeaseDNOP dnop = (LeaseDNOP)javax.rmi.PortableRemoteObject.narrow(
			       dnops.nextElement(), LeaseDNOP.class);
		       tempSum = tempSum.add(
			       dnop.getChargerursum().subtract(dnop.getPayrursum()) );
	        }	        
	        addSum = addSum.add(tempSum);
	        addNds = addNds.add(atab.calcNds(resource, temp.getDate(), tempSum, "1", idtask));
	        //pr("TempSum for LeaseDocPosition "+temp.getLeaseDocPosition()+" ="+tempSum);
	        pr("В цикле addSum="+addSum+"  addNds="+addNds); 
        }
        pr("!!!!!!!!!Конец найденных начислений!!!!!!!!!!!!!");
        //pr("Дополнительная сумма= "+addSum);
        //pr("Дополнительный НДС="+addNds);

        pr("Возвращаем allSumOst.add(addSum)/allNdsOst.add(addNds) --- Посчитать самому исходя из входных параметров");
        pr("((((((((((((((((getAddSumForSaldo start)))))))))))))))))");
        return new BigDecimal[]{
	        allSumOst.add(addSum), allNdsOst.add(addNds)
	        };
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
        String msg = "Техническая ошибка в CalculateArendaAct.getAddSumForSaldo()";
        addMsgInJournal(idtask, "E", msg);	
        pr(ex, "getAddSumForSaldo()");
    }
    return null;
}
private int getBeeline(Object[] arr, boolean isBeeline) throws RemoteException{
// договор, заказчик, исполнитель, Компания заказчика-Beeline/NoBeeline, Компания исполнителя-Beeline/NoBeeline							
    try {
		boolean isCustomerBee = ((Boolean)arr[3]).booleanValue();
		boolean isExecutorBee = ((Boolean)arr[4]).booleanValue();
		if(isCustomerBee == isExecutorBee && isCustomerBee){
			String msg = "В акте "+act+" у договора "+((Integer)arr[0]).intValue()+" обе организации принадлежат Билайн";
	    	addMsgInJournal(idtask, "E", msg);
	    	throw new Exception();
		} else if(isCustomerBee == isExecutorBee && !isCustomerBee){
			String msg = "В акте "+act+" у договора "+((Integer)arr[0]).intValue()+" обе организации не принадлежат Билайн";
	    	addMsgInJournal(idtask, "E", msg);
	    	throw new Exception();
		}
		if(isBeeline && isCustomerBee)
			return ((OrganizationNfsAccessBean)arr[1]).getOrganization();
		else if(isBeeline && isExecutorBee)
			return ((OrganizationNfsAccessBean)arr[2]).getOrganization();
		else if(!isBeeline && !isCustomerBee)
			return ((OrganizationNfsAccessBean)arr[1]).getOrganization();
		else
			return ((OrganizationNfsAccessBean)arr[2]).getOrganization();
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в CalculateArendaActBean.getBeeline";
    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "getBeeline");
        throw (RemoteException)ex;
    }
}
private int getBeeline(OrganizationNfsAccessBean customer, OrganizationNfsAccessBean executor, 
						boolean isBeeline, int contract) throws RemoteException{
    try {
		boolean isCustomerBee = isMemberBeeline(customer);
		boolean isExecutorBee = isMemberBeeline(executor);
		if(isCustomerBee == isExecutorBee && isCustomerBee){
			String msg = "В акте "+act+" у договора "+contract+" обе организации принадлежат Билайн";
	    	addMsgInJournal(idtask, "E", msg);
	    	throw new Exception();
		} else if(isCustomerBee == isExecutorBee && !isCustomerBee){
			String msg = "В акте "+act+" у договора "+contract+" обе организации не принадлежат Билайн";
	    	addMsgInJournal(idtask, "E", msg);
	    	throw new Exception();
		}
		if(isBeeline && isCustomerBee)
			return customer.getOrganization();
		else if(isBeeline && isExecutorBee)
			return executor.getOrganization();
		else if(!isBeeline && !isCustomerBee)
			return customer.getOrganization();
		else
			return executor.getOrganization();
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в CalculateArendaAct.getBeeline";
        addMsgInJournal(idtask, "E", msg);	
        pr(ex, "getBeeline");
        throw (RemoteException)ex;
    }
}
private BigDecimal getChargeRate(int idCharges, int paramCurrency, boolean onlyRead) {
    try {
	    LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
	    lcab.setInitKey_leaseDocPosition(idCharges);
	    lcab.refreshCopyHelper();
		return atab.getChargeRate(lcab.getEJBRef().getHandle(), paramCurrency, onlyRead);
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в CalculateArendaAct.getChargeRate";
        addMsgInJournal(idtask, "E", msg);	
        pr(ex, "getChargeRate(int idCharges, int paramCurrency, boolean onlyRead)");
    }
    return null;
}
public BigDecimal getChargeRateTemp(int idAct, int idCharges, int paramCurrency, boolean onlyRead) throws java.rmi.RemoteException{
    try {
		taskStart(1, "4", null, null, null, new Integer(idAct));
		initial(new Integer(idAct));
	    
	    LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
	    lcab.setInitKey_leaseDocPosition(idCharges);
	    lcab.refreshCopyHelper();
		return new ArendaTransactionMethodAccessBean().getChargeRateTemp(
			lcab.getEJBRef().getHandle(), paramCurrency, onlyRead, idAct);
    } catch (Exception ex) {
        pr(ex, "getChargeRateTemp(int idCharges, int paramCurrency, boolean onlyRead)");
        String msg = "Техническая ошибка в CalculateArendaAct.getChargeRateTemp";
        addMsgInJournal(idtask, "E", msg);	
    }
    return null;
}
private LeaseChargesAccessBean getComplementaryChargeByPay(int level, LeasePaymentAccessBean lpab) 
	throws Exception {
		//Вызывается из calculateContractSaldo
		//Находим начисление соответствующее платежу
    try {
	    long payStart = lpab.getBegindate().getTime();
	    long payEnd = lpab.getEnddate().getTime();
	    int payResource = lpab.getResourceKey().resource;	    
        int contract = lpab.getLeaseContractKey().leaseDocument;
        
        LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
        Enumeration enum = lcab.findByQBE4(
	        new Integer(contract), 
	        new Boolean(true), getSqldate(actStartDate), 
	        new Boolean(true), getSqldate(actEndDate),
	        new Boolean(true), getDec(0,2),
	        new Boolean(false), null, //resource
	        new Boolean(false),//isCalcPosOnly
	        new Integer(1)// orderByDate
	        );
        
        while (enum.hasMoreElements()) {
	        LeaseChargesAccessBean temp = (LeaseChargesAccessBean)enum.nextElement();
	        if(!resources.contains(new Integer(temp.getResourceKey().resource)))//Вместо того, чтобы искать по ресурсу
	        	continue;
	        int chargeResource = temp.getResourceKey().resource;
	        int chargeid = temp.getLeaseDocPosition();

	        boolean date = false, resource = false;
            if (level == 1) {
	            pr("getComplementaryChargeByPay level 1. Charge="+temp.getLeaseDocPosition());
	            long chargeStart = temp.getBegindate().getTime();
		        long chargeEnd = temp.getEnddate().getTime();
	            if(chargeStart >= payStart && chargeStart <= payEnd) date = true;
	            else if(payStart >= chargeStart && payStart <= chargeEnd) date = true;

	            if(payResource == chargeResource) resource = true;
	            if(date && resource) 
	            	return temp;
            } else if (level == 2) {
	            pr("getComplementaryChargeByPay level 2. Charge="+temp.getLeaseDocPosition());
	            if(payResource == chargeResource) resource = true;
	            if(resource) 
	            	return temp;
            } else if (level == 3) {
	            pr("getComplementaryChargeByPay level 3. Charge="+temp.getLeaseDocPosition());
	            return temp;
            }
        }
		return null;
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в CalculateArendaAct.getComplementaryChargeByPay";
        addMsgInJournal(idtask, "E", msg);	
        pr(ex, "getComplementaryChargeByPay(int level, LeasePaymentAccessBean lpab)");
        throw ex;
    }
}
public int getComplementaryChargeByPayTemp(Integer idAct, int level, Integer paymentId) 
	throws java.rmi.RemoteException {
		
		taskStart(1, "4", null, null, null, idAct);
		initial(idAct);
		
    try {
	    LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
	    lpab.setInitKey_leaseDocPosition(paymentId.intValue());
	    lpab.refreshCopyHelper();
	    return getComplementaryChargeByPay(level, lpab).getLeaseDocPosition();
    } catch (Exception ex) {
        pr(ex, "getComplementaryChargeByPayTemp(int level, LeasePaymentAccessBean lpab)");
        String msg = "Техническая ошибка в CalculateArendaAct.getComplementaryChargeByPayTemp";
        addMsgInJournal(idtask, "E", msg);	
    }
	     return -1;
}
private Integer getComplimentaryContracts(int level, Integer contract1, Object[][] contractProps) throws RemoteException{
    try {
        //Object[][] contractProps = new Object[contracts.size()][5];
// договор, заказчик, исполнитель, Компания заказчика-Beeline/NoBeeline, Компания исполнителя-Beeline/NoBeeline
        //contrProps[i][0] = new Integer(lconab.getLeaseDocument());
        //contrProps[i][1] = lconab.getOrgCustomer();//OrganizationNfsAccessBean
        //contrProps[i][2] = lconab.getOrgExecutor();//OrganizationNfsAccessBean
        //contrProps[i][3] = new Boolean(isMemberBeeline(lconab.getOrgCustomer()));
        //contrProps[i][4] = new Boolean(isMemberBeeline(lconab.getOrgExecutor()));	    

		int inOrgCustomer=0, inOrgExecutor=0;
		boolean orgCustomerBee=false, orgExecutorBee=false;
		int inOrgBee = 0, inOrgNoBee = 0;
		if(level >1){
	        LeaseContractAccessBean lconab = new LeaseContractAccessBean();
	        lconab.setInitKey_leaseDocument(contract1.intValue());
	        lconab.refreshCopyHelper();
	        inOrgCustomer = lconab.getOrgCustomerKey().organization;
	        inOrgExecutor = lconab.getOrgExecutorKey().organization;
	        inOrgBee = getBeeline(lconab.getOrgCustomer(), lconab.getOrgExecutor(), true, lconab.getLeaseDocument());
	        inOrgNoBee = getBeeline(lconab.getOrgCustomer(), lconab.getOrgExecutor(), false, lconab.getLeaseDocument());
		}

		if (level == 1) {
	        LeaseMRCntPriorAccessBean mrcab = new LeaseMRCntPriorAccessBean();
	        Enumeration enum = mrcab.findByReglamentContractOrderbyPriorityAsc(
		        new Integer(reglament), contract1, contract1);
	        while(enum.hasMoreElements()){
		        LeaseMRCntPriorAccessBean temp = (LeaseMRCntPriorAccessBean)enum.nextElement();
		        int contract2;
		        if(contract1.intValue()==temp.getContract1Key().leaseDocument)
		        	contract2 = temp.getContract2Key().leaseDocument;
		        else
		        	contract2 = temp.getContract1Key().leaseDocument;
		        if(compareContracts(contract1.intValue(), contract2)) return new Integer(contract2);
	        }
        } else {
	        for(int i=0; i<contractProps.length; i++){
		        Object[] arr = (Object[])contractProps[i];
		        int contract2 = ((Integer)arr[0]).intValue();
		        if(contract1.intValue() == contract2)
		        	continue;
		        int curOrgBee = getBeeline( (OrganizationNfsAccessBean)arr[1], (OrganizationNfsAccessBean)arr[2], 
			        true, ((Integer)arr[0]).intValue() );
		        int curOrgNoBee = getBeeline( (OrganizationNfsAccessBean)arr[1], (OrganizationNfsAccessBean)arr[2], 
			        false, ((Integer)arr[0]).intValue() );
		        int curOrgCustomer = ((OrganizationNfsAccessBean)arr[1]).getOrganization();
		        int curOrgExecutor = ((OrganizationNfsAccessBean)arr[2]).getOrganization();

pr("getComplimentaryContracts: Level="+level+"; inOrgCustomer, curOrgCustomer, inOrgExecutor, curOrgExecutor"+
				        inOrgCustomer+","+curOrgCustomer+","+inOrgExecutor+","+curOrgExecutor);
		        if(level == 2){
		        	if(inOrgCustomer == curOrgCustomer && inOrgExecutor == curOrgExecutor)
		        		return new Integer(contract2);
		        		
		        }else if(level == 3){
		        	if(inOrgNoBee == curOrgNoBee)
		        		if(compareContracts(contract1.intValue(), contract2)) return new Integer(contract2);
		        }else if(level == 4){
		        	if(inOrgBee == curOrgBee)
		        		if(compareContracts(contract1.intValue(), contract2)) return new Integer(contract2);
		        }else if(level == 5){
		        	if(compareContracts(contract1.intValue(), contract2)) return new Integer(contract2);
		        }
	        }
        }
		
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в CalculateArendaAct.getComplimentaryContracts(int level, Integer Contract1)"
        +"level/contract="+level+"/"+contract1.toString();
        addMsgInJournal(idtask, "E", msg);	
        pr(ex, "getComplimentaryContracts(int level, Integer Contract1)");
        throw (RemoteException)ex;
    }
    return null;
}
private java.sql.Connection getConnection() throws Exception {

	try{
		Properties prp = new EnvironmentAccessBean().getEnvironmentProperties();

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
/**
 * Insert the method's description here.
 * Creation date: (20.11.2002 12:06:10)
 * @return java.lang.Integer
 * @param lpab com.hps.july.persistence.LeasePaymentAccessBean
 * @param lcab com.hps.july.persistence.LeaseChargesAccessBean
 */
private Integer getCreditContract(LeasePaymentAccessBean lpab, LeaseChargesAccessBean lcab) {
    try {
        return lpab != null ? 
        new Integer(lpab.getLeaseContractKey().leaseDocument) : 
        new Integer(lcab.getLeaseContractKey().leaseDocument);
    } catch (Exception ex) {
        pr(ex, "getCreditContract(LeasePaymentAccessBean lpab, LeaseChargesAccessBean lcab)");
        String msg = "Техническая ошибка в CalculateArendaAct.getCreditContract";
        addMsgInJournal(idtask, "E", msg);	
    }
    return null;
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
        } else if (namedValueId.equals("OUR_COMPANY")) {
	        if(OUR_COMPANY == null){
		        try{
		            NamedValueAccessBean nvab = new NamedValueAccessBean();
		            nvab.setInitKey_id("OUR_COMPANY");
		            nvab.refreshCopyHelper();
		            OUR_COMPANY = new Integer(nvab.getIntvalue());
		            return OUR_COMPANY.intValue();
		        }catch(Exception e){
		            addMsgInJournal(idtask, "E", "Не найдена именованная константа OUR_COMPANY");
		            pr(e, "getNamedValueInt");
		            throw e;
	            }
	        } else
	        	return OUR_COMPANY.intValue();
        } else if (namedValueId.equals("DEFRULELINKMUTUALCONTRACTS")) {
	        if(DEFRULELINKMUTUALCONTRACTS == null){
		        try{
		            NamedValueAccessBean nvab = new NamedValueAccessBean();
		            nvab.setInitKey_id("DEFRULELINKMUTUALCONTRACTS");
		            nvab.refreshCopyHelper();
		            DEFRULELINKMUTUALCONTRACTS = new Integer(nvab.getIntvalue());
		            return DEFRULELINKMUTUALCONTRACTS.intValue();
		        }catch(Exception e){
		            addMsgInJournal(idtask, "E", "Не найдена именованная константа DEFRULELINKMUTUALCONTRACTS");
		            pr(e, "getNamedValueInt");
		            throw e;
	            }
	        } else
	        	return DEFRULELINKMUTUALCONTRACTS.intValue();
        } else
            throw new Exception("Unknown name for named value "+namedValueId);

    } catch (Exception ex) {
        pr(ex, "getNamedValue");
        throw ex;
    }
}
private BigDecimal getPaymentRate(int idPaiment, int inCurrency, int idAct, boolean flagAutoSaveRate) {
    try {
	    this.act = idAct; 
        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        lpab.setInitKey_leaseDocPosition(idPaiment);
        lpab.refreshCopyHelper();
        return atab.getPaymentRate(lpab.getEJBRef().getHandle(), inCurrency, flagAutoSaveRate,
	        new Integer(act), false);
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в CalculateArendaAct.getPaymentRate";
        addMsgInJournal(idtask, "E", msg);	
        pr(ex, "getPaymentRate");
    }
    return null;
}
public BigDecimal getPaymentRateTemp(int idPaiment, int inCurrency, int idAct, boolean flagAutoSaveRate)throws java.rmi.RemoteException {
    try {
	    taskStart(1, "4", null, null, null, new Integer(idAct));
		//if(!isInit)
		initial(new Integer(idAct));
		
	    this.act = idAct;
        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        lpab.setInitKey_leaseDocPosition(idPaiment);
        lpab.refreshCopyHelper();
        return new ArendaTransactionMethodAccessBean().getPaymentRateTemp(
	        lpab.getEJBRef().getHandle(), inCurrency, flagAutoSaveRate, idAct);
    } catch (Exception ex) {
        pr(ex, "getPaymentRateTemp");
        String msg = "Техническая ошибка в CalculateArendaAct.getPaymentRateTemp";
        addMsgInJournal(idtask, "E", msg);	
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 10:37:59)
 * @return boolean
 * @param idAct java.lang.Integer
 */
// Проверяем наличие сальдо на дату начала периода акта по всем услугам и договорам регламента 
private boolean getPreviousSaldo(Integer idAct) throws RemoteException{
	
	Integer contract = null;
	java.sql.Date date = null;
	Integer resource = null;
	try{
		Calendar cal = Calendar.getInstance();
		cal.setTime(actStartDate);
		cal.add(Calendar.DATE, -1);
		Date previous = cal.getTime();
		date = getSqldate(previous);
		
		LeaseSaldoAccessBean lsab = null;
		for(int i=0; i<contracts.size(); i++){
			lsab = new LeaseSaldoAccessBean();
			contract = (Integer)contracts.get(i);
			resource = (Integer)resources.get(i);
			//lsab.setInitKey_leaseContract(contract);
			//lsab.setInitKey_resource_resource(resource);
			//lsab.setInitKey_SalDate(date);
			//lsab.refreshCopyHelper();
			Enumeration enum = lsab.findByLeaseContractAndResourceOrderDateDesc(contract, resource);
			if(!enum.hasMoreElements())
				throw new FinderException("Not found saldo for contract="+contract + " and resource="+resource);
			LeaseSaldoAccessBean temp = (LeaseSaldoAccessBean)enum.nextElement();
			if(!temp.getSalDate().equals(date))
				throw new FinderException("Not found saldo for contract="+contract + " and resource="+resource);
		}
		 //если дошли до этого места значит все было найдено
		
	return true;
    } catch (Exception ex) {        
        if(contract == null) contract = new Integer(-1);
       	String msg = "Не найдено сальдо для "+contract.intValue()+" на дату "+date.toString()
   	       	+" с ресурсом "+resource.intValue()+" (getPreviousSaldo(Integer idAct))";
        if(ex instanceof FinderException){
 	        addMsgInJournal(idtask, "E", msg);
        }
        pr(ex, msg+" getPreviousSaldo(Integer idAct)");
        throw (RemoteException)ex;
    }
	//return false;
}
/**
 * Insert the method's description here.
 * Creation date: (06.11.2002 10:37:59)
 * @return boolean
 * @param idAct java.lang.Integer
 */
// Проверяем наличие сальдо на дату начала периода акта по всем услугам и договорам регламента 
public boolean getPreviousSaldoTemp(Integer idAct)throws java.rmi.RemoteException {

	try{
		taskStart(1, "4", null, null, null, idAct);
		initial(idAct);
		
		return getPreviousSaldo(idAct);
	}catch(Exception ex){
		pr(ex, "getPreviousSaldoTemp(Integer idAct)");
		String msg = "Техническая ошибка в CalculateArendaActBean.getPreviousSaldoTemp";
    	addMsgInJournal(idtask, "E", msg);
	}
	return false;
}
private BigDecimal getSaldoContract(LeaseContractAccessBean contract) throws RemoteException{
    try {
	    pr("getSaldoContract 1");
	    pr("getSaldoContract contract="+contract.getLeaseDocument());
	    LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();  
	    Enumeration enum = lcab.findByQBE4(
		    new Integer(contract.getLeaseDocument()), 
	        new Boolean(true), getSqldate(actStartDate), 
	        new Boolean(true), getSqldate(actEndDate),
	        new Boolean(true), getDec(0,2),
	        new Boolean(false), null,//resource
	        new Boolean(false),//isCalcPosOnly
	        new Integer(1)// orderByDate
			);
		pr("getSaldoContract 2");
	    BigDecimal allSumCharge = getDec(0,2);
		while(enum.hasMoreElements()){	
			LeaseChargesAccessBean temp = (LeaseChargesAccessBean)enum.nextElement();
			int id = temp.getLeaseDocPosition();
			pr("getSaldoContract 22");
			BigDecimal rateCharge = atab.getChargeRate(temp.getEJBRef().getHandle(), mainCurrency, false);
			pr("getSaldoContract 23");
			if(mainCurrency != temp.getCurrencyKey().currency){
				if(getNamedValueInt("RUR", idtask) != temp.getCurrencyKey().currency)
					allSumCharge = allSumCharge.add(
					  temp.getRemaindersum().multiply(
						temp.getRemainderrate2rur()).divide(
							rateCharge, 2, BigDecimal.ROUND_HALF_UP) ).setScale(2, BigDecimal.ROUND_HALF_UP);
				else
					allSumCharge = allSumCharge.add(
						temp.getRemaindersum().divide(
								rateCharge, 2, BigDecimal.ROUND_HALF_UP) ).setScale(2, BigDecimal.ROUND_HALF_UP);
			} else
				allSumCharge = allSumCharge.add(temp.getRemaindersum());
		} 
		 pr("getSaldoContract 3");
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean(); 
		enum = lpab.findByQBE4(
		    new Integer(contract.getLeaseDocument()), 
	        new Boolean(true), getSqldate(actStartDate), 
	        new Boolean(true), getSqldate(actEndDate),
	        new Boolean(true), getDec(0,2),
	        new Boolean(false), null,//resource
	        new Boolean(false),
	        new Boolean(false), new Boolean(false)
	        );

		pr("getSaldoContract 4");
		BigDecimal allSumPay = getDec(0,2); 
		while(enum.hasMoreElements()){
			LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
			int id = temp.getLeaseDocPosition();
			BigDecimal ratePay = atab.getPaymentRate(temp.getEJBRef().getHandle(), mainCurrency, true,
				new Integer(act), false);
			if(ratePay == null)
				return null;
			pr("getSaldoContract 4 LeasePaymentDocPosition="+temp.getLeaseDocPosition());
			pr("getSaldoContract 4 ratePay="+ratePay);
			pr("getSaldoContract 4 temp.getRurremainder="+temp.getRurremainder());
			allSumPay = allSumPay.add(
				temp.getRurremainder().divide(ratePay, 2, BigDecimal.ROUND_HALF_UP) ).setScale(
					2, BigDecimal.ROUND_HALF_UP);
		}

		pr("getSaldoContract 5. allSumCharge/allSumPay"+allSumCharge+"/"+allSumPay);
		return allSumCharge.subtract(allSumPay).setScale(2, BigDecimal.ROUND_HALF_UP);
    } catch (Exception ex) {         
        String msg = "Техническая ошибка в getSaldoContract";
        addMsgInJournal(idtask, "E", msg);
        pr(ex, "getSaldoContract(LeaseContractAccessBean idConract)");
        throw (RemoteException)ex;
    }
    //return null;
}
private BigDecimal getSaldoContract(Integer contract) throws RemoteException {
    try {
	    LeaseContractAccessBean lconab = new LeaseContractAccessBean();
	    lconab.setInitKey_leaseDocument(contract.intValue());
	    lconab.refreshCopyHelper();
	    return getSaldoContract(lconab);
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
			throw (RemoteException)ex;
        pr(ex, "getSaldoContract(Integer conract)");
        String msg = "Техническая ошибка в CalculateArendaActBean.getSaldoContract";
    	addMsgInJournal(idtask, "E", msg);
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 10:48:29)
 * @return java.math.BigDecimal[]
 * @param idConract java.lang.Integer
 * @param Resource java.lang.Integer
 * @param currency java.lang.Integer
 */
private BigDecimal[] getSaldoContractResource(Integer idContract, Integer resource, int currency) throws RemoteException{
    try {
	    pr("((((((((((((((((((((getSaldoContractResource start))))))))))))))");
	    pr("params: idContract="+idContract+" resource="+resource+" currency="+currency);
        LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
        Enumeration enum = lcab.findByQBE4(
	        idContract, 
	        new Boolean(true), getSqldate(actStartDate), 
	        new Boolean(true), getSqldate(actEndDate),
	        new Boolean(true), getDec(0,2),
	        new Boolean(true), resource,
	        new Boolean(false),//isCalcPosOnly
	        new Integer(1)// orderByDate
	        );
        
        BigDecimal allSumCharge = getDec(0,2), allOstNdsCharge = getDec(0,2);
        pr("!!!!!Найденные начисления!!!!!");
        while(enum.hasMoreElements()){
	        LeaseChargesAccessBean temp = (LeaseChargesAccessBean)enum.nextElement();
	        printCharge(temp);
	        BigDecimal rateCharge = atab.getChargeRate(temp.getEJBRef().getHandle(), currency, false);///////////
	        if(rateCharge == null){
		        String msg = "В договоре "+idContract.intValue()+" не найден курс для начисления "
		        +temp.getLeaseDocPosition();
				addMsgInJournal(idtask, "E", msg);
				return null;
	        }
	        BigDecimal ostSumCharge = temp.getRemaindersum().multiply(temp.getRemainderrate2rur()).divide(
			        rateCharge, 2, BigDecimal.ROUND_HALF_UP);
	        allSumCharge = allSumCharge.add(ostSumCharge);
	        ////BigDecimal ostNdsCharge = calcNds(resource, temp.getDate(), ostSumCharge, "1");
	        //BigDecimal ostNdsCharge = temp.getSumnds();
	        BigDecimal ostNdsCharge = ostSumCharge.multiply(temp.getSumnds()).divide(
		        temp.getSumm(), 2, BigDecimal.ROUND_HALF_UP);
	        allOstNdsCharge = allOstNdsCharge.add(ostNdsCharge);
	        pr("В цикле по начислениям.      allSumCharge="+allSumCharge+"  allOstNdsCharge="+allOstNdsCharge);
        }
        pr("!!!!!Конец найденных начислений!!!!!");

        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
        enum = lpab.findByQBE4(
		    idContract, 
	        new Boolean(true), getSqldate(actStartDate), 
	        new Boolean(true), getSqldate(actEndDate),
	        new Boolean(true), getDec(0,2),
	        new Boolean(true), resource,
	        new Boolean(false),
	        new Boolean(false), new Boolean(false)
	        );

        pr("!!!!!Найденные платежи!!!!!");
        BigDecimal allSumPayment = getDec(0,2), allOstNdsPay = getDec(0,2);
        while(enum.hasMoreElements()){
	        LeasePaymentAccessBean temp = (LeasePaymentAccessBean)enum.nextElement();
	        printPay(temp);
	        BigDecimal ratePay = atab.getPaymentRate(temp.getEJBRef().getHandle(), currency, true,
		        new Integer(act), false);
	        if(ratePay == null){
       	       	String msg = "В договоре "+idContract.intValue()+
       	       		" не найден курс для начисления "+temp.getLeaseDocPosition();
		        addMsgInJournal(idtask, "E", msg);	
		        return null;
	        }
	        BigDecimal ostSumPay = temp.getRurremainder().divide(ratePay, 2, BigDecimal.ROUND_HALF_UP);
	        allSumPayment = allSumPayment.add(ostSumPay);
	        ////BigDecimal ostNdsPay = calcNds(resource, temp.getDate(), ostSumPay, "1");
	        //BigDecimal ostNdsPay = temp.getSumnds();
	        BigDecimal ostNdsPay = ostSumPay.multiply(temp.getSumnds()).divide(
		        temp.getSumm(), 2, BigDecimal.ROUND_HALF_UP);
	        allOstNdsPay = allOstNdsPay.add(ostNdsPay);
	        pr("В цикле по платежам    allSumPayment="+allSumPayment+"   allOstNdsPay="+allOstNdsPay);
        }
        pr("!!!!!Конец найденных платежей!!!!!");
        
        BigDecimal allSumOst = allSumCharge.subtract(allSumPayment).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal allNdsOst = allOstNdsCharge.subtract(allOstNdsPay).setScale(2, BigDecimal.ROUND_HALF_UP);

        pr("До вызова getAddSumForSaldo");
        if(allSumOst.compareTo(getDec(0, 2)) != 0){
	        if(getNamedValueInt("RUR", idtask) == currency){
		        pr("Вызов getAddSumForSaldo");
	        	return getAddSumForSaldo(allSumOst, allNdsOst, idContract, resource);
	        }
        }

        pr("Возвращаем allSumOst/allNdsOst="+allSumOst+"/"+allNdsOst);
        pr("((((((((((((((((((((getSaldoContractResource end))))))))))))))");
        return new BigDecimal[]{allSumOst, allNdsOst};
    } catch (Exception ex) {   
	    if(RemoteException.class.isInstance(ex))
			throw (RemoteException)ex; 
        String msg = "Техническая ошибка в CalculateArendaActBean.getSaldoContractResource";
    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "getSaldoContractResource(Integer idConract, Integer Resource, Integer currency)");
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2002 10:48:29)
 * @return java.math.BigDecimal[]
 * @param idConract java.lang.Integer
 * @param Resource java.lang.Integer
 * @param currency java.lang.Integer
 */
public BigDecimal[] getSaldoContractResourceTemp(Integer idAct, Integer idContract, Integer resource, int currency) throws java.rmi.RemoteException{
    try {
	    taskStart(1, "4", null, null, null, idAct);
		initial(idAct);

		return getSaldoContractResource(idContract, resource, currency);
		
    } catch (Exception ex) {
        pr(ex, "getSaldoContractResourceTemp(Integer idConract, Integer Resource, Integer currency)");
        String msg = "Техническая ошибка в CalculateArendaActBean.getSaldoContractResourceTemp";
    	addMsgInJournal(idtask, "E", msg);
    }
    return null;
}
public BigDecimal getSaldoContractTemp(Integer idAct, Integer contract) throws java.rmi.RemoteException{
    try {

	    taskStart(1, "4", null, null, null, idAct);
		initial(idAct);

	    return getSaldoContract(contract);
    } catch (Exception ex) {
        pr(ex, "getSaldoContractTemp(Integer conract)");
        String msg = "Техническая ошибка в CalculateArendaActBean.getSaldoContractTemp";
    	addMsgInJournal(idtask, "E", msg);
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
RUR = null;
BASE_RATETYPE_ARENDA = null;
ARENDA_RES_EQUIPMENT = null;
OUR_COMPANY = null;
DEFRULELINKMUTUALCONTRACTS = null;

    try {
	    contracts = new ArrayList();
		resources = new ArrayList();
		contractsUnic = new ArrayList();
	    act = idAct.intValue();
        mutualAct = new LeaseMutualActNewAccessBean();
        mutualAct.setInitKey_leaseDocument(idAct.intValue());
        mutualAct.refreshCopyHelper();
        actStartDate = mutualAct.getActstartdate();
        actEndDate = mutualAct.getActenddate();
        
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
        //arab = new ArendaDocumentProcessorAccessBean();

        return true;
    } catch (Exception ex) {
        pr(ex, "initial(Integer idAct)");
        String msg = "Техническая ошибка в CalculateArendaActBean.initial()";
    	addMsgInJournal(idtask, "E", msg);
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2002 19:10:03)
 * @return boolean
 * @param organization com.hps.july.persistence.OrganizationNfsAccessBean
 */
private boolean isMemberBeeline(OrganizationNfsAccessBean organization) {
	int org = -1;
    try {
	    org = organization.getOrganization();        
        //if (organization.getCompanyKey().company == getNamedValueInt("OUR_COMPANY", idtask))
        //    return true;
    } catch (Exception ex) {
        //pr("isMemberBeeline(OrganizationNfsAccessBean organization). org="+org);
        //pr("Organization "+org+" is not Beeline");
        //String msg = "Техническая ошибка в CalculateArendaActBean.isMemberBeeline";
    	//addMsgInJournal(idtask, "E", msg);
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2002 19:10:03)
 * @return boolean
 * @param organization com.hps.july.persistence.OrganizationNfsAccessBean
 */
public boolean isMemberBeelineTemp(Integer idAct, OrganizationAccessBean organization) throws java.rmi.RemoteException{
    try {
	    taskStart(1, "4", null, null, null, idAct);
		initial(idAct);
		
        if (organization.getCompanyKey().company == getNamedValueInt("OUR_COMPANY", idtask))
            return true;
    } catch (Exception ex) {
        pr(ex, "isMemberBeelineTemp(OrganizationNfsAccessBean organization)");
        String msg = "Техническая ошибка в CalculateArendaActBean.isMemberBeelineTemp";
    	addMsgInJournal(idtask, "E", msg);
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
private boolean linkCharge2Pay(LeasePaymentAccessBean lpab, LeaseChargesAccessBean lcab) throws RemoteException{
	try{
		//if(!(lpab.getSumnds() != null && lpab.getSumnds().intValue() != 0)){
			//String msg = "Не определена сумма НДС для платежа "+lpab.getLeaseDocPosition();
	        //addMsgInJournal(idtask, "E", msg);
	        //throw new RemoteException();
		//}
		//if(!(lcab.getSumnds() != null && lcab.getSumnds().intValue() != 0)){
			//String msg = "Не определена сумма НДС для начмсления "+lcab.getLeaseDocPosition();
	        //addMsgInJournal(idtask, "E", msg);
	        //throw new RemoteException();
		//}
		//BigDecimal payfactor = lpab.getSumRub().divide(lpab.getSumnds(), 0, BigDecimal.ROUND_HALF_UP);
		//BigDecimal chargefactor = lcab.getRemaindersum().divide(lcab.getSumnds(), 0, BigDecimal.ROUND_HALF_UP);
		//if(payfactor.compareTo(chargefactor) != 0){
			//String msg = "Ставка НДС у платежа "+lpab.getLeaseDocPosition()
				//+" не совпадает со ставкой НДС у начисления "+lcab.getLeaseDocPosition();
	        //addMsgInJournal(idtask, "W", msg);
		//}
		
		BigDecimal payRate = atab.getPaymentRate(lpab.getEJBRef().getHandle(),
			lcab.getCurrencyKey().currency, false, new Integer(act), false );
		if(payRate != null){
			if(atab._linkCharge2Pay(lpab.getEJBRef().getHandle(), lcab.getEJBRef().getHandle(), payRate,
				new Integer(act), new Boolean(false), "A", idtask   ))
				return true;
			else
				return false;
		} else
			return false;
	}catch(Exception ex){
		if(RemoteException.class.isInstance(ex))
			throw (RemoteException)ex;
		String msg = "Техническая ошибка в CalculateArendaAct.linkCharge2Pay(LeasePaymentAccessBean lpab, LeaseChargesAccessBean lcab)";
        addMsgInJournal(idtask, "E", msg); 
		pr(ex, "linkCharge2Pay(LeasePaymentAccessBean lpab, LeaseChargesAccessBean lcab)");
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2002 19:00:04)
 * @return boolean
 * @param idPaymentl java.lang.Integer
 * @param idCharge java.lang.Integer
 */
private boolean linkCharge2Pay(Integer idPayment, Integer idCharge) throws RemoteException{

	try{
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
		lpab.setInitKey_leaseDocPosition(idPayment.intValue());
		lpab.refreshCopyHelper();
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
		lcab.setInitKey_leaseDocPosition(idCharge.intValue());
		lcab.refreshCopyHelper();
		return linkCharge2Pay(lpab, lcab);
	}catch(Exception ex){
		if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
		pr(ex, "linkCharge2Pay(Integer idPayment, Integer idCharge)");
		String msg = "Техническая ошибка в CalculateArendaActBean.linkCharge2Pay(Integer idPayment, Integer idCharge)";
    	addMsgInJournal(idtask, "E", msg);
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2002 19:00:04)
 * @return boolean
 * @param idPaymentl java.lang.Integer
 * @param idCharge java.lang.Integer
 */
public boolean linkCharge2PayTemp(Integer idAct, Integer idPayment, Integer idCharge) throws java.rmi.RemoteException{

	try{
		taskStart(1, "4", null, null, null, idAct);
		initial(idAct);

		
		LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
		lpab.setInitKey_leaseDocPosition(idPayment.intValue());
		lpab.refreshCopyHelper();
		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
		lcab.setInitKey_leaseDocPosition(idCharge.intValue());
		lcab.refreshCopyHelper();
		return linkCharge2Pay(lpab, lcab);
	}catch(Exception ex){
		if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
		pr(ex, "linkCharge2PayTemp(Integer idPayment, Integer idCharge)");
		String msg = "Техническая ошибка в CalculateArendaAct.linkCharge2PayTemp(LeasePaymentAccessBean lpab, LeaseChargesAccessBean lcab)";
        addMsgInJournal(idtask, "E", msg); 
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (15.11.2002 12:43:10)
 * @return boolean
 * @param doc1 java.lang.Object 
 * @param doc2 java.lang.Object
 */
private boolean makeBalansingCharge(Object doc1, Object doc2) throws RemoteException{
// Производит формирование зачета между начислениями\платежами
//Object  LeaseDocPosition1 - код начисления\платежа
//Object LeaseDocPosition2 - код начисления\платежа

    try {
        LeasePaymentAccessBean lpab1 = null, lpab2 = null;
        LeaseChargesAccessBean lcab1 = null, lcab2 = null;
        BigDecimal ostSum1, ostSum2;
        int leasedoc1, leasedoc2;
        
        if (LeasePaymentAccessBean.class.isInstance(doc1)){
            lpab1 = (LeasePaymentAccessBean) doc1;
            leasedoc1 = lpab1.getLeaseDocPosition();
        }else{
            lcab1 = (LeaseChargesAccessBean) doc1;
            leasedoc1 = lcab1.getLeaseDocPosition();
        }
        if (LeasePaymentAccessBean.class.isInstance(doc2)){
            lpab2 = (LeasePaymentAccessBean) doc2;
            leasedoc2 = lpab2.getLeaseDocPosition();
        }else{
            lcab2 = (LeaseChargesAccessBean) doc2;
            leasedoc2 = lcab2.getLeaseDocPosition();
        }
pr("---into makeBalansingCharge()---");
pr("---leasedocposition1="+leasedoc1);
pr("---leasedocposition2="+leasedoc2);

        if (lpab1 != null) {
            BigDecimal rate = atab.getPaymentRate(lpab1.getEJBRef().getHandle(), mainCurrency, true,
	            new Integer(act), false);
            if(rate == null)
            	throw new RemoteException();
            pr("---Определяем остаток для lpab1---");
            printPay(lpab1);
            ostSum1 = lpab1.getRurremainder().divide(rate, 2, BigDecimal.ROUND_HALF_UP);
        } else {
	        pr("---Определяем остаток для lcab1---");
	        printCharge(lcab1);
	        if(lcab1.getCurrencyKey().currency == mainCurrency)
	        	ostSum1 = lcab1.getRemaindersum();
	        else{
	            BigDecimal rate = atab.getChargeRate(lcab1.getEJBRef().getHandle(), mainCurrency, false);
	            ostSum1 = lcab1.getRemaindersum().multiply(lcab1.getRemainderrate2rur()).divide(
		            rate, 2, BigDecimal.ROUND_HALF_UP);
	        }
        }
        if (lpab2 != null) {
	        pr("---Определяем остаток для lpab2---");
	        printPay(lpab2);
            BigDecimal rate = atab.getPaymentRate(lpab2.getEJBRef().getHandle(), mainCurrency, true,
	            new Integer(act), false);
            if(rate == null)
            	throw new RemoteException();
            ostSum2 = lpab2.getRurremainder().divide(rate, 2, BigDecimal.ROUND_HALF_UP);
        } else {
	        pr("---Определяем остаток для lcab2---");
	        printCharge(lcab2);
	        if(lcab2.getCurrencyKey().currency == mainCurrency)
	        	ostSum2 = lcab2.getRemaindersum();
	        else{
	            BigDecimal rate = atab.getChargeRate(lcab2.getEJBRef().getHandle(), mainCurrency, false);
	            ostSum2 = lcab2.getRemaindersum().multiply(lcab2.getRemainderrate2rur()).divide(
		            rate, 2, BigDecimal.ROUND_HALF_UP);
	        }
        }

        int min = ostSum1.compareTo(ostSum2);
        if (min == 0)
            min = 1;
        BigDecimal minSum;
        minSum = min > 0 ? ostSum2 : ostSum1;
pr("---ostSum2/ostSum1="+ostSum2 +"/"+ ostSum1);

        if (lpab1 != null){
pr("---Формируем взаимозачет по leasePayment1="+lpab1.getLeaseDocPosition());
            if (atab._makeMutualCharge(lpab1.getEJBRef().getHandle(), minSum) == null) return false;
            Integer debet = new Integer(lpab1.getLeaseContractKey().leaseDocument);
            Integer credit = getCreditContract(lpab2, lcab2);
            if(!atab._addMutuallyBetweenContract(debet, credit, minSum)) return false;
        } else {
pr("---Формируем взаимозачет по leaseCharge1="+lcab1.getLeaseDocPosition());
	        if (atab._makeMutualPayment(lcab1.getEJBRef().getHandle(), minSum) == null) return false;
	        Integer debet = new Integer(lcab1.getLeaseContractKey().leaseDocument);
	        Integer credit = getCreditContract(lpab2, lcab2);
            if(!atab._addMutuallyBetweenContract(debet, credit, minSum)) return false;
        }

        if (lpab2 != null){
pr("---Формируем взаимозачет по leasePayment2="+lpab2.getLeaseDocPosition());
            if (atab._makeMutualCharge(lpab2.getEJBRef().getHandle(), minSum) == null) return false;
            //Integer debet = new Integer(lpab1.getLeaseContractKey().leaseDocument);
            //Integer credit = getCreditContract(lpab2, lcab2);
            //if(!atab._addMutuallyBetweenContract(debet, credit, minSum)) return false;
        } else {
pr("---Формируем взаимозачет по leaseCharge2="+lcab2.getLeaseDocPosition());
	        if (atab._makeMutualPayment(lcab2.getEJBRef().getHandle(), minSum) == null) return false;
	        //Integer debet = new Integer(lcab1.getLeaseContractKey().leaseDocument);
	        //Integer credit = getCreditContract(lpab2, lcab2);
            //if(!atab._addMutuallyBetweenContract(debet, credit, minSum)) return false;
        }
         
pr("(((((((((((exit makeBalansingCharge())))))))))))");
        return true;      
    } catch (Exception ex) {
	    if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
        String msg = "Техническая ошибка в CalculateArendaActBean.makeBalansingCharge(Object doc1, Object doc2)";
    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "makeBalansingCharge(Object doc1, Object doc2)");
    }
pr("exit makeBalansingCharge()");            
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (15.11.2002 11:15:38)
 * @param contract1 java.lang.Integer
 * @param contract2 java.lang.Integer
 * @exception java.lang.Exception The exception description.
 */ 
private boolean makeMutualCharges(Integer contract1, Integer contract2) throws RemoteException{ 
    try {
        Enumeration enum1 = null, enum2 = null;
        BigDecimal saldo1 = getSaldoContract(contract1);
        BigDecimal saldo2 = getSaldoContract(contract2);

        int compare1=0, compare2=0;
        if (saldo1 != null && saldo2 != null) {
            compare1 = saldo1.compareTo(getDec(0,2));
            compare2 = saldo2.compareTo(getDec(0,2));
            if (compare1 == 0) {
                addMsgInJournal(117, "W", -1, act,
	                contract1.intValue(), contract2.intValue(), null, null, null, null,
	                -1, -1, -1, -1);
                return false;
            }
            if (compare2 == 0) {
                addMsgInJournal(117, "W", -1, act,
	                contract2.intValue(), contract1.intValue(), null, null, null, null,
	                -1, -1, -1, -1);
                return false;
            }
        } else {
	        if(saldo1 == null)
	        	addMsgInJournal(118, "E", -1, act,
		        	contract1.intValue(), contract2.intValue(), null, null, null, null,
	                -1, -1, -1, -1);
	        if(saldo2 == null)
	        	addMsgInJournal(118, "E", -1, act,
		        	contract2.intValue(), contract1.intValue(), null, null, null, null,
	                -1, -1, -1, -1);
        }
 /*       	
        if (compare1 > 0) {
            LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
            enum1 = lcab.findByQBE4(
            	contract1, 
	        	new Boolean(true), getSqldate(actStartDate), 
	        	new Boolean(true), getSqldate(actEndDate),
	        	new Boolean(true), getDec(0,2),
	        	new Boolean(false), null,//resource
	            new Boolean(false),//isCalcPosOnly
	            new Integer(1)// orderByDate
				);
        } else {
	        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
            enum1 = lpab.findByQBE4(
            	contract1, 
	        	new Boolean(true), getSqldate(actStartDate), 
	        	new Boolean(true), getSqldate(actEndDate),
	        	new Boolean(true), getDec(0,2),
	        	new Boolean(false), null,//resource
	        	new Boolean(false),
	        	new Boolean(false), new Boolean(false)
	        	);            
        }
        if (compare2 > 0) {
            LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
            enum2 = lcab.findByQBE4(
            	contract2, 
	        	new Boolean(true), getSqldate(actStartDate), 
	        	new Boolean(true), getSqldate(actEndDate),
	        	new Boolean(true), getDec(0,2),
	        	new Boolean(false), null,//resource
	            new Boolean(false),//isCalcPosOnly
	            new Integer(1)// orderByDate
				);
        } else {
	        LeasePaymentAccessBean lpab = new LeasePaymentAccessBean();
            enum2 = lpab.findByQBE4(
            	contract2, 
	        	new Boolean(true), getSqldate(actStartDate), 
	        	new Boolean(true), getSqldate(actEndDate),
	        	new Boolean(true), getDec(0,2),
	        	new Boolean(false), null,//resource
	        	new Boolean(false),
	        	new Boolean(false), new Boolean(false)
	        	);            
        }

        ArrayList en2 = new ArrayList();
        while(enum2.hasMoreElements())
        	en2.add(enum2.nextElement());
        Object[] arr = en2.toArray();
        while (enum1.hasMoreElements()){
	        Object obj = enum1.nextElement();
        	for(int i=0; i<arr.length; i++){

	        	int leaseDocPosition = LeasePaymentAccessBean.class.isInstance(obj) ?
						((LeasePaymentAccessBean)obj).getLeaseDocPosition() :
						((LeaseChargesAccessBean)obj).getLeaseDocPosition();
				int leaseDocPosition2 = LeasePaymentAccessBean.class.isInstance(arr[i]) ?
						((LeasePaymentAccessBean)arr[i]).getLeaseDocPosition() :
						((LeaseChargesAccessBean)arr[i]).getLeaseDocPosition();
pr("makeMutualCharges:leaseDocPosition/leaseDocPosition2="+leaseDocPosition+"/"+leaseDocPosition2);
	        
            	if (!makeBalansingCharge(obj, arr[i])){
						String msg = "Ошибка при формировании зачета между документами "+leaseDocPosition
						+" и "+leaseDocPosition2 +"(CalculateArendaAct.makeBalansingCharge)";
				        addMsgInJournal(idtask, "E", msg);	
            	}
        	}
        }
*/
		boolean firsttime = true;
		int size1 = 0, size2 = 0;
		while(1==1){
			Object[] arr1 = findSidesOfContract(contract1, compare1);
			if(arr1.length == 0) break;
			Object[] arr2 = findSidesOfContract(contract2, compare2);
			if(arr2.length == 0) break;

			if(! firsttime){
				if(arr1.length == size1 && arr2.length == size2){
					String msg = "Ошибка при формировании зачета между документами "+contract1.intValue()
	 		       +" и "+contract2.intValue()+" (makeMutualCharges(Integer contract1, Integer contract2))";
			    	addMsgInJournal(idtask, "E", msg);
					throw new RemoteException();
				}
			}
			firsttime = false;
			size1 = arr1.length;
			size2 = arr2.length;
			int leaseDocPosition = LeasePaymentAccessBean.class.isInstance(arr1[0]) ?
						((LeasePaymentAccessBean)arr1[0]).getLeaseDocPosition() :
						((LeaseChargesAccessBean)arr1[0]).getLeaseDocPosition();
			int leaseDocPosition2 = LeasePaymentAccessBean.class.isInstance(arr2[0]) ?
						((LeasePaymentAccessBean)arr2[0]).getLeaseDocPosition() :
						((LeaseChargesAccessBean)arr2[0]).getLeaseDocPosition();
pr("makeMutualCharges:leaseDocPosition/leaseDocPosition2="+leaseDocPosition+"/"+leaseDocPosition2);						
			if (!makeBalansingCharge(arr1[0], arr2[0])){
				String msg = "Ошибка при формировании зачета между документами "+leaseDocPosition
					+" и "+leaseDocPosition2 +"(CalculateArendaAct.makeBalansingCharge)";
		        addMsgInJournal(idtask, "E", msg);
		        throw new RemoteException();
           	}
		}
        return true;
    } catch (Exception ex) {
	    pr(ex, "makeMutualCharges(Integer contract1, Integer contract2) throws java.lang.Exception");	    
        try{
	        String msg = "Ошибка при формировании зачета между документами "+contract1.intValue()
	        +" и "+contract2.intValue()+" (makeMutualCharges(Integer contract1, Integer contract2))";
	    	addMsgInJournal(idtask, "E", msg);
        }catch(Exception exx){}
        if(RemoteException.class.isInstance(ex))
			throw (RemoteException)ex;
    }
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (15.11.2002 11:15:38)
 * @param contract1 java.lang.Integer
 * @param contract2 java.lang.Integer
 * @exception java.lang.Exception The exception description.
 */
public boolean makeMutualCharges(Integer idAct, Integer contract1, Integer contract2) throws java.lang.Exception {
    try {

	    taskStart(1, "4", null, null, null, idAct);
		initial(idAct);
	    
	    makeMutualCharges(contract1, contract2);

	    return true; 
         } catch (Exception ex) {        
	        try{
		        String msg = "Ошибка при формировании зачета между документами "+contract1.intValue()
        +" и "+contract2.intValue()+" (makeMutualCharges((Integer idAct, Integer contract1, Integer contract2))";
    	addMsgInJournal(idtask, "E", msg);
	        }catch(Exception exx){}
	        pr(ex, "makeMutualCharges(Integer idAct, Integer contract1, Integer contract2)");
    }
         return false;
}
private boolean needDelete_getChargesRurRate(LeaseChargesAccessBean lcab) {
    //try {
        //Integer type, currency;
        //int namedValueResource;
        //RateAccessBean rab = new RateAccessBean();
        //try {
            //type = new Integer(getNamedValueInt("BASE_RATETYPE_ARENDA", idtask));
            //currency = new Integer(getNamedValueInt("RUR", idtask));
            //namedValueResource = getNamedValueInt("ARENDA_RES_EQUIPMENT", idtask);
        //} catch (Exception ex) {
            //// ERROR !!!тогда выдаем ошибку и возвращаем null
            //return false;
        //}

        //boolean byHand = lcab.getByhandraterur().booleanValue();
        //BigDecimal rate = null;
        //LeaseMutualRuleNewAccessBean lmab = new LeaseMutualRuleNewAccessBean();
            //lmab.setInitKey_reglament_leaseDocument(new Integer(reglament));
            //lmab.setInitKey_resource_resource(new Integer(lcab.getResourceKey().resource));
            //lmab.refreshCopyHelper();

        //if (lcab.getSource().equalsIgnoreCase("Z")) {
            //java.sql.Date date;
            //if (dutyRateRule.equalsIgnoreCase("A")) {
                //Calendar cal = Calendar.getInstance();
                //cal.setTime(actStartDate);
                //cal.add(Calendar.DATE, -1);
                //date = new java.sql.Date(cal.getTime().getTime());
            //} else {
                //date = new java.sql.Date(actEndDate.getTime());
            //}
            //RateAccessBean rab2 = rab.findByTypeCurrencyForDate(type, currency, date);
            //rate = rab2.getValue().setScale(4, BigDecimal.ROUND_HALF_UP);
            //if (!byHand) {
                //atab._setLeaseChargesRemainderRate(lcab.getEJBRef().getHandle(), rate);
            //}
        //} else if (lcab.getResourceKey().resource == namedValueResource) {
            //java.sql.Date date = new java.sql.Date(lcab.getDate().getTime());
            //RateAccessBean rab2 = rab.findByTypeCurrencyForDate(type, currency, date);
            //rate = rab2.getValue().setScale(4, BigDecimal.ROUND_HALF_UP);
            //if (!byHand) {
                //atab._setLeaseChargesRemainderRate(lcab.getEJBRef().getHandle(), rate);
            //}
        //} else if (commonRate) {
            //java.sql.Date date=null;
            //if (calcRateType.equalsIgnoreCase("B"))
                //date = new java.sql.Date(actStartDate.getTime());
            //else if (calcRateType.equalsIgnoreCase("E"))
                //date = new java.sql.Date(actEndDate.getTime());
            //RateAccessBean rab2 = rab.findByTypeCurrencyForDate(type, currency, date);
            //rate = rab2.getValue().setScale(4, BigDecimal.ROUND_HALF_UP);
            //if (!byHand) {
                //atab._setLeaseChargesRemainderRate(lcab.getEJBRef().getHandle(), rate);
            //}
        //} else if (!commonRate) {
            //java.sql.Date date=null;
            //String chargeDateRule = lmab.getChargedaterule();
            //if (chargeDateRule.equalsIgnoreCase("A")) {
                //date = new java.sql.Date(lcab.getDate().getTime());
            //} else if (chargeDateRule.equalsIgnoreCase("B")) {
                //date = new java.sql.Date(actStartDate.getTime());
            //} else if (chargeDateRule.equalsIgnoreCase("C")) {
                //date = new java.sql.Date(actEndDate.getTime());
            //}
            //RateAccessBean rab2 = rab.findByTypeCurrencyForDate(type, currency, date);
            //rate = rab2.getValue().setScale(4, BigDecimal.ROUND_HALF_UP);
            //if (!byHand) {
                //atab._setLeaseChargesRemainderRate(lcab.getEJBRef().getHandle(), rate);
            //}
        //}
        //if(rate == null){
	        //// Error !!!
	        //return false;
        //}
        //LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean();
        //Enumeration enum = dnab.findLeaseDNOPByLeaseCharge(new LeaseDocPositionKey(lcab.getLeaseDocPosition()));
        //while (enum.hasMoreElements()) {
            //LeaseDNOPAccessBean temp = (LeaseDNOPAccessBean) enum.nextElement();
            //if (!temp.getByhandchangeraterur().booleanValue()) {
	            //if(!commonRate && lmab.getReglamentKey().leaseDocument==reglament
		            //&& lmab.getResourceKey().resource == lcab.getResourceKey().resource
		            //&& lmab.getDopchargdatrul())
	            	//rate = atab.getPaymentRate(temp.getLeasePayment().getEJBRef().getHandle(),
		            	//lcab.getCurrencyKey().currency, true);
	            //atab._setLeaseDnopRate(temp.getEJBRef().getHandle(), rate);
            //}
            //atab._setLeaseDnopChargeRURSum(dnab.getEJBRef().getHandle());
        //}

        //return true;
    //} catch (Exception ex) {        
        //try{addMsgInJournal(168, "E", -1, act, -1, -1, null, null, null, null, -1, -1, -1, -1 );}catch(Exception e){}
        //pr(ex, "setChargesRURRate(LeaseChargesAccessBean lcab)");
    //}
    return false;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2002 18:05:25)
 * @return boolean
 * @param idCharge java.lang.Integer
 * @param idAct java.lang.Integer
 */
public boolean needDelete_getChargesRurRate(Integer idCharge) throws java.rmi.RemoteException{
    //try {
        //LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
        //lcab.setInitKey_leaseDocPosition(idCharge.intValue());
        //lcab.refreshCopyHelper();
        //if (getChargesRURRate(lcab))
            //return true;
    //} catch (Exception ex) {
        //pr(ex, "getChargesRURRate(Integer idCharge)");
    //}
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
            if (out == null) {
                new File("/opt/WebSphere/AppServer/logs/calcact").mkdir();
                try {
                    out =new PrintWriter(new BufferedWriter(
                                new FileWriter("/opt/WebSphere/AppServer/logs/calcact/calcact.log", true)));
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
public boolean setChargesRURRate(LeaseChargesAccessBean lcab) throws RemoteException{
    try {

		BigDecimal rateCharge = atab.setChargeRemainderRate(lcab.getEJBRef().getHandle());	
		BigDecimal rateDnop = null;  
        
        LeaseDNOPAccessBean dnab = new LeaseDNOPAccessBean();
        Enumeration enum = dnab.findLeaseDNOPByLeaseCharge(new LeaseDocPositionKey(lcab.getLeaseDocPosition()));
        while (enum.hasMoreElements()) {
            LeaseDNOPAccessBean temp = (LeaseDNOPAccessBean) enum.nextElement();
            if (!commonRate) {
	            LeaseMutualRuleNewAccessBean lmab = new LeaseMutualRuleNewAccessBean();
            	lmab.setInitKey_reglament_leaseDocument(new Integer(reglament));
            	lmab.setInitKey_resource_resource(new Integer(lcab.getResourceKey().resource));
            	lmab.refreshCopyHelper();
	            if(!commonRate && lmab.getReglamentKey().leaseDocument==reglament
		            && lmab.getResourceKey().resource == lcab.getResourceKey().resource
		            && lmab.getDopchargdatrul()){
			            rateDnop = atab.getPaymentRate(temp.getLeasePayment().getEJBRef().getHandle(),
				            lcab.getCurrencyKey().currency, true, new Integer(act), false);
			            if(rateDnop == null){
				            String msg = "Не рассчитывается курс для платежа №"+temp.getLeasePayment().getLeaseDocPosition();
					    	addMsgInJournal(idtask, "E", msg);
			            	throw new RemoteException();
			            }
		         } else
		            rateDnop = rateCharge; 
            } else
            	rateDnop = rateCharge;

            //if (!temp.getByhandchangeraterur().booleanValue()) 
            	//atab._setLeaseDnopRate(temp.getEJBRef().getHandle(), rateDnop);
		            
            //atab._setLeaseDnopChargeRURSum(temp.getEJBRef().getHandle());
            atab._setLeaseDnopChargeRURSum(temp.getEJBRef().getHandle(), rateDnop);
        }

        return true;
    } catch (Exception ex) {
	    pr(ex, "setChargesRURRate(LeaseChargesAccessBean lcab)");
	    if(RemoteException.class.isInstance(ex))
	    	throw (RemoteException)ex;
        String msg = "Техническая ошибка в CalculateArendaActBean.setChargesRURRate(LeaseChargesAccessBean lcab)";
    	addMsgInJournal(idtask, "E", msg);       
    }
    return false;
}
public boolean setChargesRURRateTemp(Integer idAct, int idCharges) throws java.rmi.RemoteException{
    try {

	    taskStart(1, "4", null, null, null, idAct);
		initial(idAct);

		LeaseChargesAccessBean lcab = new LeaseChargesAccessBean();
		lcab.setInitKey_leaseDocPosition(idCharges);
		lcab.refreshCopyHelper();

		return setChargesRURRate(lcab);
    } catch (Exception ex) {
        pr(ex, "setChargesRURRate(Integer idAct, int idCharges)");
        String msg = "Техническая ошибка в CalculateArendaActBean.setChargesRURRateTemp(Integer idAct, int idCharges)";
    	addMsgInJournal(idtask, "E", msg);
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
private void taskEnd() throws Exception {
    try {
        journal.taskEnd(idtask);
    } catch (Exception ex) {        
        String msg = "Техническая ошибка в CalculateArendaActBean.taskEnd. idtask=" + idtask;
    	addMsgInJournal(idtask, "E", msg);
        pr(ex, "taskEnd. idtask=" + idtask);
    }
}
private int taskStart(int operator, String taskType, Date date1, Date date2,
	Integer economist, Integer document) {
    try {
	    idtask = journal.taskStart(operator, taskType, date1, date2, economist, document);
	    return idtask;
    } catch (Exception ex) {
        pr("Error in taskStart()");
        String msg = "Техническая ошибка в CalculateArendaActBean.taskStart().";
    	addMsgInJournal(idtask, "E", msg);
    }
    return -1;
}
}
