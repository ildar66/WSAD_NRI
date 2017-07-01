package com.hps.july.arenda.billing;

import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.math.BigDecimal;
import com.hps.july.arenda.sessionbean.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import java.util.Properties;
import javax.ejb.*;
/** 
 * This is a Session Bean Class
 * Перенос данных биллинга из PIE в буфер системы NRI
 */
public class Pie2NriBean implements SessionBean {
    private javax.ejb.SessionContext mySessionCtx = null;
    private final static long serialVersionUID = 3206093459760846163L;

    private DataSource july = null;
    private DataSource pie = null;
    private JournalAccessBean journal = null;

    int ARENDA_RES_EQUIPMENT = -1;
    int ARENDA_RES_CONNECT = -1;
    int USD = -1;
    String ARENDA_CARGO_COUNTRY = null;
    
    private class LeasePay {
        int contract, act;
        public LeasePay(int paramAct, int paramContract) {
            contract = paramContract;
            act = paramAct;
        }
        public int hashCode() {
            return contract;
        }
        public boolean equals(Object o) {
            try {
                LeasePay pay = (LeasePay) o;
                return (pay.contract == contract && pay.act == act);
            } catch (Exception e) {
                return false;
            }
        }
    }
private boolean addMsgInJournal(int idtask, String jrnType, String jrnMsg){

	try{
		return getJournal().addMsgInJournal(idtask, jrnType, jrnMsg);
	}catch(Exception ex){
		pr(ex, "addMsgInJournal");
	}
	return false;
}
private void check_UpdateBan(Statement stateJ, Statement stateP, int idtask) throws Exception {

    String pie = "select  ban from billing_account where FlagWorkNri='N' and IdLeaseDocument is null";
    String nri = "SELECT leaseDocument from leaseAbonentBan WHERE ban=";
    try {
        ResultSet res = stateP.executeQuery(pie);
        while (res.next()) {
            int ban = res.getInt(1);
            ResultSet rs = stateJ.executeQuery("SELECT count(*) from leaseAbonentBan WHERE ban=" + ban);
            if (rs.next()) {
                int count = rs.getInt(1);
                if (rs.wasNull() || count > 1) {
	                String msg = "LeaseAbonentBan содержит больше одной записи с ban="+ban;
	                addMsgInJournal(idtask, "E", msg);
                    throw new SQLException("in NRI count ban " + ban +" > 1");
                }
            } else {
	            String msg = "LeaseAbonentBan не содержит записей с ban="+ban;
	            addMsgInJournal(idtask, "E", msg);
                throw new SQLException("in NRI not exist ban " + res.getInt(1));
            }            
            rs = stateJ.executeQuery(nri + ban);
            if (!rs.next()) {
	            String msg = "LeaseAbonentBan не содержит записей с ban="+ban;
	            addMsgInJournal(idtask, "E", msg);
                throw new SQLException("in NRI not exist ban " + res.getInt(1));
            } else
                stateP.executeUpdate("update billing_account set idLeaseDocument=" 
	                + rs.getInt(1) + " where ban=" + ban);
        }
    } catch (SQLException ex) {
	    String msg = "Техническая ошибка в check_UpdateBan";
	    addMsgInJournal(idtask, "E", msg);
        pr(ex, "check_UpdateBan");
        pr("Exception is=" + ex.getMessage());
        pr("ErrorCode is=" + ex.getErrorCode());
        pr("-------------------");
        throw ex;
    }
}
private ArrayList[] checkPaymentInPie(Connection con, int idtask) throws Exception{
	Statement state = null;
	PreparedStatement ps1 = null;
	ResultSet rs = null;
	

String query4 = "select ban, ENT_SEQ_NO from payment where pym_type in ('CA', 'BT')";

String query = "execute procedure checkPayment(?, ?)";
	try{
		state = con.createStatement();
		ps1 = con.prepareStatement(query);

		ArrayList ban = new ArrayList(), pay = new ArrayList();
		rs = state.executeQuery(query4);
		while(rs.next()){
			int iban = rs.getInt(1);
			int ipay = rs.getInt(2);
			ps1.setInt(1, iban);
			ps1.setInt(2, ipay);
			ResultSet res = ps1.executeQuery();
			res.next();
			int cod = res.getInt(1);
			res.close();
			if(cod != 0){
				if(cod==301){
					String msg = "Процедура checkPayment. Не найден платеж для ban="+iban+" ent_seq_no="+ipay;
					addMsgInJournal(idtask, "E", msg);
				}else if(cod==302){
					String msg = "Процедура checkPayment. Найденo более одного платежа для ban="+iban+" ent_seq_no="+ipay;
					addMsgInJournal(idtask, "E", msg);
				}else if(cod==303){
					String msg = "Процедура checkPayment. Обычный платеж не имеет рублевой суммы для ban="+iban+" ent_seq_no="+ipay;
					addMsgInJournal(idtask, "E", msg);
				}else if(cod==304){
					String msg = "Процедура checkPayment. Сумма обычного платежа равна нулю для ban="+iban+" ent_seq_no="+ipay;
					addMsgInJournal(idtask, "E", msg);
				}else if(cod==305){
					String msg = "Процедура checkPayment. Платеж оплачивает начисления на сумму больше суммы платежа для ban="+iban+" ent_seq_no="+ipay;
					addMsgInJournal(idtask, "E", msg);
				}else if(cod==306){
					String msg = "Процедура checkPayment. Есть неоплаченные счета по данному BAN, а платеж их не закрывает для ban="+iban+" ent_seq_no="+ipay;
					addMsgInJournal(idtask, "E", msg);
				}
				continue;
			}
			ban.add(new Integer(iban));
			pay.add(new Integer(ipay));
		}
		return new ArrayList[]{ban, pay};
	}catch(Exception ex){
		String msg = "Техническая ошибка в checkPaymentInPie";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "checkPaymentInPie");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		throw ex;
	} 
	finally{
		try{
			if(rs != null) rs.close();
			if(state != null) state.close();
			if(ps1 != null) ps1.close();
		}catch(SQLException sql){}
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 12:24:23)
 * @return boolean
 * @exception java.lang.Exception The exception description.
 */
public boolean checkWorkBanInPie(int idtask) throws java.rmi.RemoteException{

	Connection conP = null;
	Statement state = null;
	ResultSet rs = null;

	String sql = "select ban, SyncErrTxt from ban_list where SyncState=2";
	try{
		conP = getPie(idtask);
		state = conP.createStatement();

		rs = state.executeQuery(sql);
		while(rs.next()){			
			int ban = rs.getInt(1);
			String err = rs.getString(2);
			String msg = "По данному BAN невозможно получить данные из системы PIE SyncErrTxt="+err;
			addMsgInJournal(idtask, "E", msg);			
		}		
		return true;
	}catch(Exception ex){
		String msg = "Техническая ошибка в checkWorkBanInPie";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "checkWorkBanInPie");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
	} 
	finally{
		try{
			if(rs != null) rs.close();
			if(state != null) state.close();
			if(conP != null) conP.close();
		}catch(SQLException e){}
	}
}
private int defineResourceForAbonentBill(String idresbilling, boolean equpment, 
	int pk1, int pk2, String pk3, String pk4, Connection con, int idtask) throws Exception {

    Statement state = null;
    ResultSet rs = null;
    String sql = "select resource from LeaseResBil2NRI where idresbilling='" + idresbilling+"'";
    try {
        state = con.createStatement();
        if (!equpment) {
            if (idresbilling == null) {
	            String msg = "В разделе счета за услуги связи не указан ресурс (ban="+pk1+", ENT_SEQ_NO="+pk2+")";
			    addMsgInJournal(idtask, "W", msg);
                return getNamedValue("ARENDA_RES_CONNECT", idtask);
            } else {
                rs = state.executeQuery(sql);
                if (!rs.next()) {
	                String msg = "В LeaseResBil2NRI для счета за услуги связи не найден ресурс("+idresbilling+"). Счет(ban="+pk1+", ENT_SEQ_NO="+pk2+")";
				    addMsgInJournal(idtask, "W", msg);
                    return getNamedValue("ARENDA_RES_CONNECT", idtask);
                } else
                    return rs.getInt(1);
            }
        } else {
            if (idresbilling == null) {
	            String msg = "В разделе счета за оборудование не указан ресурс (order_oid="+pk1+", line_seq="+pk2+", store_id="+pk3+", activity_type="+pk4+")";
			    addMsgInJournal(idtask, "E", msg);
                return getNamedValue("ARENDA_RES_EQUIPMENT", idtask);
            } else {
	            rs = state.executeQuery(sql);
                if (!rs.next()) {
	                String msg = "В LeaseResBil2NRI для счета за оборудование не найден ресурс("+idresbilling+"). Счет(order_oid="+pk1+", line_seq="+pk2+", store_id="+pk3+", activity_type="+pk4+")";
				    addMsgInJournal(idtask, "E", msg);
                    return getNamedValue("ARENDA_RES_EQUIPMENT", idtask);
                } else
                    return rs.getInt(1);
            }
        }
    } catch (Exception ex) {
	    String msg = "Техническая ошибка в defineResourceForAbonentBill";
	    addMsgInJournal(idtask, "E", msg);
        pr(ex, "defineResourceForAbonentBill");
        if (ex instanceof SQLException) {
            pr("-----------------------");
            pr("ErrorCode is=" + ((SQLException) ex).getErrorCode());
            pr("-----------------------");
        }
        throw ex;
    } finally {
        if (rs != null)
            rs.close();
        if (state != null)
            state.close();
    }
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	pr("-----------------ejbActivate---------------------");
	pie = null;
	july = null;
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
	pr("-----------------ejbPassivate start---------------------");
	july = null;
    pie = null;
    journal = null;
    pr("-----------------ejbPassivate end---------------------");
}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {
	pr("-----------------ejbRemove---------------------");
	pie = null;
	july = null;
	journal = null;
}
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 12:01:35)
 * @return int
 * @param resource int
 * @param equpment boolean
 * @exception java.lang.Exception The exception description.
 */
private String getCargoCountry(int idtask) throws Exception {

	try{
			if(ARENDA_CARGO_COUNTRY == null){
				NamedValueAccessBean nvab = new NamedValueAccessBean();
				nvab.setInitKey_id("ARENDA_CARGO_COUNTRY");
				nvab.refreshCopyHelper();
				ARENDA_CARGO_COUNTRY = nvab.getCharvalue();
				return ARENDA_CARGO_COUNTRY;
			} else
				return ARENDA_CARGO_COUNTRY; 
	}catch(Exception ex){
		String msg = "Техническая ошибка в getCargoCountry";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "getCargoCountry");
		throw ex;
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
private Connection getJuly(int idtask) throws Exception {
    try {
	    if(july != null)
	    	return july.getConnection();
        Properties prp = getSessionContext().getEnvironment();
        for (Iterator i = prp.keySet().iterator(); i.hasNext();) {
            String key = (String) i.next();
            System.out.println("key=" + key + " value=" + prp.get(key));
        }
        String dsName = prp.getProperty("DATASOURCE_NAME_JULY");
        String factoryClass = prp.getProperty("FACTORY_CLASS");

        javax.naming.InitialContext ctx = null;
        Properties prop = new Properties();
        prop.put(javax.naming.Context.PROVIDER_URL, "iiop://");
        prop.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass);
        ctx = new javax.naming.InitialContext();
        july = (DataSource) ctx.lookup(dsName);

        return july.getConnection();
    } catch (Exception ex) {
	    String msg = "Техническая ошибка в getJuly";
	    addMsgInJournal(idtask, "E", msg);
	    pr(ex, "getJuly");
        throw ex;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (28.01.2003 12:01:35)
 * @return int
 * @param resource int
 * @param equpment boolean
 * @exception java.lang.Exception The exception description.
 */
private int getNamedValue(String namedValueId, int idtask) throws Exception {

	try{
		if(namedValueId.equals("ARENDA_RES_EQUIPMENT")){
			if(ARENDA_RES_EQUIPMENT == -1){
				NamedValueAccessBean nvab = new NamedValueAccessBean();
				nvab.setInitKey_id("ARENDA_RES_EQUIPMENT");
				nvab.refreshCopyHelper();
				ARENDA_RES_EQUIPMENT = nvab.getIntvalue();
				return ARENDA_RES_EQUIPMENT;
			} else 
				return ARENDA_RES_EQUIPMENT;
		} else if(namedValueId.equals("ARENDA_RES_CONNECT")) {
			if(ARENDA_RES_CONNECT == -1){
				NamedValueAccessBean nvab = new NamedValueAccessBean();
				nvab.setInitKey_id("ARENDA_RES_CONNECT");
				nvab.refreshCopyHelper();
				ARENDA_RES_CONNECT = nvab.getIntvalue();
				return ARENDA_RES_CONNECT;
			} else 
				return ARENDA_RES_CONNECT;
		} else {
			if(USD == -1){
				NamedValueAccessBean nvab = new NamedValueAccessBean();
				nvab.setInitKey_id("USD");
				nvab.refreshCopyHelper();
				USD = nvab.getIntvalue();
				return USD;
			} else
				return USD;
		} 
	}catch(Exception ex){
		String msg = "Техническая ошибка в getNamedValue";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "getNamedValue");
		throw ex;
	} 
}
private Connection getPie(int idtask) throws Exception {
    try {
	    if(pie != null)
	    	return pie.getConnection();
        Properties prp = getSessionContext().getEnvironment();
        for (Iterator i = prp.keySet().iterator(); i.hasNext();) {
            String key = (String) i.next();
            System.out.println("key=" + key + " value=" + prp.get(key));
        }
        String dsName = prp.getProperty("DATASOURCE_NAME_PIE");
        String factoryClass = prp.getProperty("FACTORY_CLASS");

        javax.naming.InitialContext ctx = null;
        Properties prop = new Properties();
        prop.put(javax.naming.Context.PROVIDER_URL, "iiop://");
        prop.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass);
        ctx = new javax.naming.InitialContext();
        pie = (DataSource) ctx.lookup(dsName);

        return pie.getConnection();
    } catch (Exception ex) {
	    String msg = "Техническая ошибка в getPie";
	    addMsgInJournal(idtask, "E", msg);
	    pr(ex, "getPie");
        throw ex;
    }
}
private String getQuery(ArrayList list) {
	try{
		StringBuffer contract = new StringBuffer(), act = new StringBuffer();
		for(int i=0; i<list.size(); i++){
			contract.append( ((LeasePay)list.get(i)).contract+"," );
			act.append( ((LeasePay)list.get(i)).act+","  );
		}
		
		String query = "select lp.leasemutualact, lp.leasecontract, lp.summusd, lp.record_status, "
						+"ban.ban, doc.docnumber, doc.docdate "
						+"from LEASEPAY2BILL lp, LeaseAbonentBan ban, LeaseDocuments doc "
						+"where lp.leasemutualact in("
						+act.deleteCharAt(act.length()-1).toString()
						+") and lp.leasecontract in ("
						+contract.deleteCharAt(contract.length()-1).toString()
						+") and lp.leasecontract=ban.leaseDocument "
						+"and lp.leasecontract=doc.leaseDocument";
		return query;
	}catch(Exception ex){
		pr(ex, "getQuery");
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
private void go3(int idtask) throws Exception {
    Connection conJ = getJuly(idtask);
    Connection conP = getPie(idtask);
    Statement stateJ = null;
    Statement stateP = null;
    PreparedStatement psJ = null;
    PreparedStatement psJ2 = null;
    ResultSet rsJ = null;
    ResultSet rsP = null;
    try {
        String query =
            "select  acc.ban, acc.at_account_type, acc.inn, acc.name, "
                + "acc.cntrct_status, acc.cntrct_status_date, acc.start_service_date, "
                + "acc.suspended_date, acc.bill_address, 'N' flagWorkPie, "
                + "acc.contract_date, types.at_account_type_de,  pw.pw_description "
                + "from billing_account acc, outer account_types types, outer paper_work_status pw "
                + "where FlagWorkNri='N' and IdLeaseDocument is not null and "
                + "types.at_account_type=acc.at_account_type and pw.pw_status=acc.CNTRCT_STATUS";

        String query10 =
            "update leaseabonentban set bil_accountType=?, bil_AccTypeName=?, "
                + "bil_inn=?, bil_name=?, bil_contrStatus=?, bil_ContrStName=?, bil_ContrStDate=?, "
                + "bil_startServDate=?, bil_SuspDate=?, bil_billAddress=?, flagWorkPie=? WHERE ban=?";

        String query12 =
            "update LeaseDocuments set docdate=?,"
                + "docnumber=?,  doctype='B' where leaseDocument=?";

        String query13 = "update billing_account set flagworknri = 'Y' where ban in (";

        stateJ = conJ.createStatement();
        stateP = conP.createStatement();
        psJ = conJ.prepareStatement(query10);
        psJ2 = conJ.prepareStatement(query12);

        rsP = stateP.executeQuery(query);

        StringBuffer buf = new StringBuffer();
        while (rsP.next()) {
            int ban = updateLeaseAbonentBan(query10, psJ, rsP, idtask);
            buf.append(ban);
            buf.append(',');
            updateLeaseDocument(stateJ, psJ2, rsP, idtask);
        }

        if (buf.length() > 0) {
            String updateBilling_account =
                query13 + buf.deleteCharAt(buf.length() - 1).toString() + ")";
            //pr("updateBilling_account=" + updateBilling_account);
            check_UpdateBan(stateJ, stateP, idtask);
            stateP.executeUpdate(updateBilling_account);
        }

    } catch (Exception ex) {
        String msg = "Техническая ошибка в go3";
        addMsgInJournal(idtask, "E", msg);
        pr(ex, "go3");
        if (ex instanceof SQLException) {
            pr("-----------------------");
            pr("ErrorCode is=" + ((SQLException) ex).getErrorCode());
            pr("-----------------------");
        }
        throw ex;
    } finally {
        try {
            if (rsJ != null)
                rsJ.close();
            if (rsP != null)
                rsP.close();
            if (stateJ != null)
                stateJ.close();
            if (stateP != null)
                stateP.close();
            if (psJ != null)
                psJ.close();
            if (psJ2 != null)
                psJ2.close();
            if (conJ != null)
                conJ.close();
            if (conP != null)
                conP.close();
        } catch (SQLException sql) {
        }
    }
}
private void go4(int idtask) throws Exception{
	
	Connection conJ = getJuly(idtask);
	Connection conP = getPie(idtask);
	Statement stateJ = null;
	Statement stateP = null;
	Statement stateP2 = null;
	PreparedStatement psJ = null;
	ResultSet rsP = null;
	try{
String query1 = "select acc.IDLEASEDOCUMENT, s.SUBSCRIBER_NO, s.SUB_STATUS, s.NET_STANDARD, s.IMSI, s.ban "
+"from subscriber s, billing_account acc "
+"where s.ban=acc.ban and s.record_status <> 'D' and s.flagWorkNri='N'";

String query2 = "update LeaseAbonentPhones set PhoneStatus=?, NetStandard=?, IMSI=? "
+"where LeaseDocument=? and PhoneNumber=?";

////////////// Для отката
			//StringBuffer deletePhoneLeaseDoc = new StringBuffer(), deletePhoneNumber = new StringBuffer();
            //StringBuffer updateSubscriberban = new StringBuffer(), updateSubscribeNo = new StringBuffer();
/////////////////////		

		stateP = conP.createStatement();
		stateP2 = conP.createStatement();
		stateJ = conJ.createStatement();
		psJ = conJ.prepareStatement(query2);

		rsP = stateP.executeQuery(query1);
		while (rsP.next()) {//Вставляем/обновляем записи в LeaseAbonentPhones
            int idleasedocument = rsP.getInt("idleasedocument");
            String phoneNumber = rsP.getString("subscriber_no").trim();
            int ban = rsP.getInt("ban");
            String sub_status = rsP.getString("sub_status");
            String net_standart = rsP.getString("NET_STANDARD");
            String imsi = rsP.getString("IMSI");
            String query = "select count(*) from LeaseAbonentPhones where LeaseDocument="
				            	+idleasedocument
				            	+" and PhoneNumber='"
				            	+phoneNumber+"'";
            ResultSet res = stateJ.executeQuery(query);
            res.next();
            int i = res.getInt(1);
            res.close();
            if (i > 1) {
	            String msg = "В.системе NRI(LeaseAbonentPhones) больше одного абонентского телефона с номером "+phoneNumber;
			    addMsgInJournal(idtask, "E", msg);
                throw new SQLException("Duplicate phone number - "+phoneNumber);
            }
            query = null;
            if (i == 0){
	            query = "insert into LeaseAbonentPhones values("
	            	+idleasedocument
	            	+", '"+phoneNumber+"', '"
	            	+sub_status+"', '"
	            	+net_standart+"', '"
	            	+imsi+"')";
            	stateJ.executeUpdate(query);
            	//deletePhoneLeaseDoc.append(","+idleasedocument);
            	//deletePhoneNumber.append(",'"+phoneNumber+"'");
            }
            else{
                psJ.setString(1, sub_status);
		        psJ.setString(2, net_standart);
		        psJ.setString(3, imsi);
		        psJ.setInt(4, idleasedocument);
		        psJ.setString(5, phoneNumber);
		        psJ.executeUpdate();
            }

            stateP2.executeUpdate("update subscriber set flagWorkNri='Y' where ban="+ban
	            +" and subscriber_no='"+phoneNumber+"'");
            //updateSubscriberban.append(","+ban);
            //updateSubscribeNo.append(",'"+phoneNumber+"'");
        }
		// Для отката
		//pr("delete LeaseAbonentPhones=delete from LeaseAbonentPhones where leaseDocument in("
			//+deletePhoneLeaseDoc.deleteCharAt(0).toString()+
			//") and phoneNumber in ("
			//+deletePhoneNumber.deleteCharAt(0).toString()+")");
		//pr("update subscriber=update subscriber set flagWorkNri='N' where ban in("
			//+updateSubscriberban.deleteCharAt(0).toString()
			//+") and subscriber_no in ("
			//+updateSubscribeNo.deleteCharAt(0).toString()+")");
		
		//Удаляем записи помеченные к удалению
		String sql4 = "delete from LeaseAbonentPhones where phoneNumber in (";
		rsP = stateP.executeQuery("select SUBSCRIBER_NO from subscriber where record_status='D'");
		StringBuffer buf = new StringBuffer();
		while(rsP.next())
			buf.append(rsP.getString(1)+',');
		if(buf.length() != 0)
			stateJ.executeUpdate(sql4+buf.deleteCharAt(buf.length()-1).toString()+")")	;
				
			
	}catch(Exception ex){
		String msg = "Техническая ошибка в go4";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "go4");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		throw ex;
	} 
	finally{
		try{
			if(rsP != null) rsP.close();
			if(stateP != null) stateP.close();
			if(stateP2 != null) stateP2.close();
			if(stateJ != null) stateJ.close();
			if(psJ != null) psJ.close();
			if(conJ != null) conJ.close();
			if(conP != null) conP.close();
		}catch(SQLException sql){}
	}
}
private void insertUpdate2LeaseAbonentPhone(ResultSet rs, PreparedStatement ps, Statement state, int idtask) throws Exception {

    String query1 = "select count(*) from LeaseAbonentPhones where LeaseDocument=";
    String query2 = " and PhoneNumber='";
    String query = "begin";
    try {
        while (rs.next()) {
            int idleasedocument = rs.getInt("idleasedocument");
            //if(rs.wasNull());
            String phoneNumber = rs.getString("subscriber_no").trim();
            int ban = rs.getInt("ban");
            //if(rs.wasNull());
            String sub_status = rs.getString("sub_status");
            String net_standart = rs.getString("NET_STANDARD");
            String imsi = rs.getString("IMSI");
            query = query1+idleasedocument+query2+phoneNumber+"'";
            ResultSet res = state.executeQuery(query);
            res.next();
            int i = res.getInt(1);
            res.close();
            if (i > 1) {
	            String msg = "В.системе NRI(LeaseAbonentPhones) больше одного абонентского телефона с номером "+phoneNumber;
			    addMsgInJournal(idtask, "E", msg);
                throw new SQLException("Duplicate phone number - "+phoneNumber);
            }
            query = null;
            if (i == 0){
	            query = "insert into LeaseAbonentPhones values("
	            	+idleasedocument
	            	+", '"+phoneNumber+"', '"
	            	+sub_status+"', '"
	            	+net_standart+"', '"
	            	+imsi+"')";
            	state.executeUpdate(query);
            }
            else{
                ps.setString(1, sub_status);
		        ps.setString(2, net_standart);
		        ps.setString(3, imsi);
		        ps.setInt(4, idleasedocument);
		        ps.setString(5, phoneNumber);
		        ps.executeUpdate();
            }

            state.executeUpdate("update subscriber set flagWorkNri='Y' where ban="+ban
	            +" and subscriber_no='"+phoneNumber+"'");
        }
    } catch (SQLException ex) {
	    String msg = "Техническая ошибка в insertUpdate2LeaseAbonentPhone";
	    addMsgInJournal(idtask, "E", msg);
        pr(ex, "insertUpdate2LeaseAbonentPhone");
        pr("Query="+query);
        pr("ErrorCode is=" + ex.getErrorCode());
        pr("-------------------");
        throw ex;
    }
}
public void moveAbonentDogovorsPie2BufferNri(int idtask) throws java.rmi.RemoteException{

	Connection conP = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try{
		conP = getPie(idtask);
		ps = conP.prepareStatement("execute procedure moveContracts(?, ?)");
		ps.setInt(1, idtask);
		ps.setString(2, "N");
		rs = ps.executeQuery();
	} catch(Exception ex){
		String msg = "Техническая ошибка в moveAbonentDogovorsPie2BufferNri";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveAbonentDogovorsPie2BufferNri");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);

	} finally{
		try{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conP != null) conP.close();
		}catch(SQLException sql){}
	}


	//go3(idtask);
	//go4(idtask);
}
public void moveAllBillPie2BufferNri(int idtask) throws java.rmi.RemoteException{

	Connection conJ = null;
	Connection conP = null;
	Statement stateP = null;
	Statement stateP2 = null;
	PreparedStatement psP = null;
	PreparedStatement psP2 = null;
	PreparedStatement psJ = null;
	PreparedStatement psJ2 = null;
	ResultSet rsP = null;
	
//String query1 = "select acc.idLeaseDocument, b.ban, b.ben, b.bill_seq_no, b.invoice_number, b.bill_date, "
//+"b.prd_st_dat, b.prd_en_dat, b.total_invoice_amt, b.billing_status, b.TypeWorkNri, b.IdBillNri, b.record_status "
//+"from bill b, billing_account acc where b.flagWorkNri='N' and b.ban=acc.ban";


//String query2 = "insert into AbonentBills (LeaseBill, LeaseDocument, BillDate, BillNumber, BillPeriodStart, "
//+"BillPeriodEnd, BillStatus, BillType, Ben, UseInNri, ChangeUseInNri, BenSource, FlagWorkNri) values"
//+"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

//String query3 = "update AbonentBills set BillDate=?, BillNumber=?, BillPeriodStart=?, BillPeriodEnd=?, "
//+"BillStatus=?, BillType=?, Ben=?, UseInNri=?, ChangeUseInNri=?, BenSource=?, FlagWorkNri=? "
//+"where LeaseBill=? and LeaseDocument=? ";

//String query4 = "execute procedure checkBillCon(?, ?)"; 

	try{
		conJ = getJuly(idtask);
		conP = getPie(idtask);
		psP = conP.prepareStatement("execute procedure movebills(?)");
		psP.setInt(1, idtask);
		rsP = psP.executeQuery();
		//stateP = conP.createStatement();
		//stateP2 = conP.createStatement();
		//psP = conP.prepareStatement(query4);
		//psJ = conJ.prepareStatement(query2);
		//psJ2 = conJ.prepareStatement(query3);
		//KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		//ArrayList bills = new ArrayList();

		//rsP = stateP.executeQuery(query1);
		//while(rsP.next()){// переносим счета за услуги связи
			//String invoiceNumber = rsP.getString("invoice_number");
			//int ban = rsP.getInt("ban");
			//int ben = rsP.getInt("ben");
			//int billnum = rsP.getInt("bill_seq_no");
			//int IdBillNri = rsP.getInt("IdBillNri");
			//psP.setInt(1, ban);
			//psP.setString(2, invoiceNumber);
			//ResultSet res = psP.executeQuery();
			//res.next();
			//int kod = res.getInt(1);
			//res.close();
			//if(kod != 0){
				//if(kod==201){
					//String msg = "Процедура checkBillCon. Не найден счет. ban="+ban+" invoice_number="+invoiceNumber;
				    //addMsgInJournal(idtask, "E", msg);
				//} else if(kod==202){
					//String msg = "Процедура checkBillCon. Найдено несколько счетов по ключу. ban="+ban+" invoice_number="+invoiceNumber;
				    //addMsgInJournal(idtask, "E", msg);
				//} else if(kod==203){
					//String msg = "Процедура checkBillCon. Сумма счета не совпадает с суммой позиций счета. ban="+ban+" invoice_number="+invoiceNumber;
				    //addMsgInJournal(idtask, "E", msg);
				//} else if(kod==204){
					//String msg = "Процедура checkBillCon. Cумма счета меньше оплаченной суммы счета. ban="+ban+" invoice_number="+invoiceNumber;
				    //addMsgInJournal(idtask, "E", msg);
				//}
				//continue;
			//}
			//if(rsP.wasNull()){// вставляем
				//int key = keygen.getNextKey("tables.abonentbills");
				//bills.add(new Integer(key));
				
				//psJ.setInt(1, key);//leaseBill
				//psJ.setInt(2, rsP.getInt("idLeaseDocument"));//leaseDocument
				//psJ.setDate(3, rsP.getDate("bill_date"));//billDate
				//psJ.setString(4, rsP.getString("invoice_number"));//billNumber
				//psJ.setDate(5, rsP.getDate("prd_st_dat"));//billPeriodStart
				//psJ.setDate(6, rsP.getDate("prd_en_dat"));//billPeriodEnd
				//psJ.setString(7, rsP.getString("record_status"));//billStatus
				//psJ.setString(8, "U");//billType - услуги
				//psJ.setInt(9, ben);//ben
				//psJ.setString(10, "Y");//useInNri
				//psJ.setString(11, "A");//changeUseInNri
				//psJ.setString(12, "A");//benSource
				//psJ.setString(13, "N");//flafWorkNri
				//psJ.executeUpdate();

				//stateP2.executeUpdate("update bill set idBillNri="+key+", flagWorkNri='Y'"
					//+" where ban="+ban+" and ben="+ben+" and bill_seq_no="+billnum); 
			//} else {// обновляем						
				//psJ2.setDate(1, rsP.getDate("bill_date"));//billDate
				//psJ2.setString(2, rsP.getString("invoice_number"));//billNumber
				//psJ2.setDate(3, rsP.getDate("prd_st_dat"));//billPeriodStart
				//psJ2.setDate(4, rsP.getDate("prd_en_dat"));//billPeriodEnd
				//psJ2.setString(5, rsP.getString("record_status"));//billStatus
				//psJ2.setString(6, "U");//billType - услуги
				//psJ2.setInt(7, ben);//ben
				//psJ2.setString(8, "Y");//useInNri
				//psJ2.setString(9, "A");//changeUseInNri
				//psJ2.setString(10, "A");//benSource
				//psJ2.setString(11, "N");//flafWorkNri
				//psJ2.setInt(12, IdBillNri);//leaseBill
				//psJ2.setInt(13, rsP.getInt("idLeaseDocument"));//leaseDocument
				//psJ2.executeUpdate();

				//stateP2.executeUpdate("update bill set flagWorkNri='Y'"
					//+" where ban="+ban+" and ben="+ben+" and bill_seq_no="+billnum)	;
			//}	
		//}
//String query5 = "select acc.idLeaseDocument, p.idPosOrderNri, p.store_id, p.activity_type, p.order_oid, p.ban, "
//+"p.bar_code_number, p.initial_date, p.nsp, p.nsp_percent, p.record_status, p.invoice_number, p.ben "
//+"from pos_order p, billing_account acc where p.flagWorkNri='N' and p.ban=acc.ban";

//String query6 = "execute procedure checkBillEqp(?, ?, ?)";
		//psP2 = conP.prepareStatement(query6);
		//rsP = stateP.executeQuery(query5);
		//while(rsP.next()){// переносим счета за оборудование
			//String storeid = rsP.getString("store_id");
			//String activity = rsP.getString("activity_type");
			//int order = rsP.getInt("order_oid");						
			//psP2.setString(1, storeid);
			//psP2.setString(2, activity);
			//psP2.setInt(3, order);
			//ResultSet res = psP2.executeQuery();
			//res.next();
			//int cod = res.getInt(1);
			//res.close();
			//if(cod != 0){
				//if(cod==401){
					//String msg = "Процедура checkBillEqp. Не найден счет. store_id="+storeid+" activity_type="+activity+" order_oid="+order;
				    //addMsgInJournal(idtask, "E", msg);
				//} else if(cod==402){
					//String msg = "Процедура checkBillEqp. Найдено несколько счетов по ключу. store_id="+storeid+" activity_type="+activity+" order_oid="+order;
				    //addMsgInJournal(idtask, "E", msg);
				//} else if(cod==403){
					//String msg = "Процедура checkBillEqp. Сумма счета меньше оплаченной суммы счета. store_id="+storeid+" activity_type="+activity+" order_oid="+order;
				    //addMsgInJournal(idtask, "E", msg);
				//}
				//continue;
			//}
			
			//int idPosOrderNri = rsP.getInt("idPosOrderNri");			
			//if(rsP.wasNull()){ //   вставляем
				//int key = keygen.getNextKey("tables.abonentbills");
				//bills.add(new Integer(key));
				
				//psJ.setInt(1, key);//leaseBill
				//psJ.setInt(2, rsP.getInt("idLeaseDocument"));//leaseDocument
				//psJ.setDate(3, rsP.getDate("initial_date"));//billDate
				//psJ.setString(4, rsP.getString("bar_code_number"));//billNumber
				//psJ.setDate(5, rsP.getDate("initial_date"));//billPeriodStart
				//psJ.setDate(6, rsP.getDate("initial_date"));//billPeriodEnd
				//psJ.setString(7, rsP.getString("record_status"));//billStatus
				//psJ.setString(8, "O");//billType - услуги
				//psJ.setInt(9, rsP.getInt("ben"));//ben
				//psJ.setString(10, "Y");//useInNri
				//psJ.setString(11, "A");//changeUseInNri
				//psJ.setString(12, "A");//benSource
				//psJ.setString(13, "N");//flafWorkNri
				//psJ.executeUpdate();

				//stateP2.executeUpdate("update pos_order set idPosOrderNri="+key+", flagWorkNri='Y'"
					//+" where store_id="+storeid+" and activity_type='"+activity+"' and order_oid="+order);
			//} else {// обновляем						
				//psJ2.setDate(1, rsP.getDate("initial_date"));//billDate
				//psJ2.setString(2, rsP.getString("bar_code_number"));//billNumber
				//psJ2.setDate(3, rsP.getDate("initial_date"));//billPeriodStart
				//psJ2.setDate(4, rsP.getDate("initial_date"));//billPeriodEnd
				//psJ2.setString(5, rsP.getString("record_status"));//billStatus
				//psJ2.setString(6, "O");//billType - услуги
				//psJ2.setInt(7, rsP.getInt("ben"));//ben
				//psJ2.setString(8, "Y");//useInNri
				//psJ2.setString(9, "A");//changeUseInNri
				//psJ2.setString(10, "A");//benSource
				//psJ2.setString(11, "N");//flafWorkNri
				//psJ2.setInt(12, idPosOrderNri);//leaseBill
				//psJ2.setInt(13, rsP.getInt("idLeaseDocument"));//leaseDocument
				//psJ2.executeUpdate();

				//stateP2.executeUpdate("update pos_order set flagWorkNri='Y'"
					//+" where store_id="+storeid+" and activity_type='"+activity+"' and order_oid="+order);
			//}
		//}




		
		moveAllInvoiceItem(idtask);
		//setBilltype(idtask, bills.toArray());
	}catch(Exception ex){
		String msg = "Техническая ошибка в moveAllBillPie2BufferNri";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveAllBillPie2BufferNri");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);

	} 
	finally{
		try{
			if(rsP != null) rsP.close();
			if(stateP != null) stateP.close();
			if(stateP2 != null) stateP2.close();
			if(psP != null) psP.close();
			if(psJ != null) psJ.close();
			if(psJ2 != null) psJ2.close();
			if(psP2 != null) psP2.close();
			if(conJ != null) conJ.close();
			if(conP != null) conP.close();
		}catch(SQLException sql){}
	}
}
public boolean moveAllDnopPie2BufferNri(int idtask) throws java.rmi.RemoteException{
    //Перенести данные по связи счетов и платежей из системы PIE в буфер системы NRI

    Connection conJ = null;
    Connection conP = null;
    Statement stateP = null;
    Statement stateP2 = null;
    PreparedStatement insert = null;
    PreparedStatement update = null;
    PreparedStatement psP = null;
    ResultSet rsP = null;

    //String sql1 =
        //"select cr.ban, cr.ent_seq_no, cr.credit_seq_no, cr.inv_seq_no, cr.invoice_number, "
            //+ "cr.credit_type, cr.link_amt, cr.record_status, cr.idlinknri, inv.invoice_type "
            //+ "from credit_debit_link cr, invoices inv "
            //+ "where flagworknri='N' AND credit_type='P' "
            //+ "AND cr.ban=inv.ban AND cr.invoice_number=inv.invoice_number";

    //String sql2 =
        //"insert into LeaseAbonentDnop(idAbonentDNOP, leaseBill, payPos, sumLinkUsd, flagWorkNri, RecordStatus) "
            //+ "values(?, ?, ?, ?, ?, ?)";

    //String sql3 =
        //"update LeaseAbonentDnop set leaseBill=?, payPos=?, sumLinkUsd=?, flagWorkNri=?, RecordStatus=? "
            //+ "where idAbonentDNOP=?";
	
    try {
	    conJ = getJuly(idtask);
		conP = getPie(idtask);
	    psP = conP.prepareStatement("execute procedure moveDnop(?)");
		psP.setInt(1, idtask);
		rsP = psP.executeQuery();
        //stateP = conP.createStatement();
        //stateP2 = conP.createStatement();
        //insert = conJ.prepareStatement(sql2);
        //update = conJ.prepareStatement(sql3);

        //rsP = stateP.executeQuery(sql1);
        //KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
        //out : while (rsP.next()) {

            //int count = 0;
            //int ban = rsP.getInt("ban");
            //int ENT_SEQ_NO = rsP.getInt("ENT_SEQ_NO");
            //String invoice_number = rsP.getString("invoice_number");

            //ResultSet rs2 =
                //stateP2.executeQuery(
                    //"select * from payment where ban=" + ban + " and ent_seq_no=" + ENT_SEQ_NO);

            //int idPaymentNri = 0;
            //while (rs2.next()) {
                //idPaymentNri = rs2.getInt("IdPaymentNri");
                //if (rs2.wasNull() || rs2.getString("flagWorkNri").equals("N")) {
                    //String msg = "Платеж(ban=" + ban + 
                    //", ent_seq_no=" + ENT_SEQ_NO + ") не перенесен в систему NRI.";
                    //addMsgInJournal(idtask, "E", msg);
                    //continue out;
                //}
                //++count;
            //}
            //if (count == 0) {
                //String msg = "Платеж (ban=" + ban + ", ent_seq_no=" + ENT_SEQ_NO + ") не найден";
                //addMsgInJournal(idtask, "E", msg);
                //continue;
            //} else if (count > 1) {
                //String msg =
                    //"Найдено несколько платежей(ban=" + ban 
                    //+ ", ent_seq_no=" + ENT_SEQ_NO + ") для данной связи";
                //addMsgInJournal(idtask, "E", msg);
                //continue;
            //}
            //if (!rsP.getString("invoice_type").trim().equals("Q")) { //
	            //rs2 = null;
                //rs2 =
                    //stateP2.executeQuery(
                        //"select idBillNri from bill where ban="
                            //+ ban
                            //+ " and invoice_number='"
                            //+ invoice_number
                            //+ "'");
                //if (!rs2.next()) {
                    //String msg =
                        //"Не найден bill для связи счетов и оплаты(ban=" + ban
                            //+ ", invoice_number=" + invoice_number + ")";
                    //addMsgInJournal(idtask, "E", msg);
                    //continue;
                //}
                //int leasebill = rs2.getInt(1);
                //if (rs2.wasNull()) {
                    //String msg =
                        //"Найденый bill для связи счетов и оплаты(ban=" + ban
                            //+ ", invoice_number="+invoice_number+") не содержит "
                            //+ "ссылки на AbonentBills в системе NRI";
                    //addMsgInJournal(idtask, "E", msg);
                    //continue;
                //}
				//moveOneDnop(idtask, rsP, leasebill, idPaymentNri, ENT_SEQ_NO, ban, insert, update, stateP2, keygen);

            //} else if(rsP.getString("invoice_type").trim().equals("Q")){
	            //rs2 = null;
                //rs2 =
                    //stateP2.executeQuery(
                        //"select idposordernri from pos_order where ban="
                            //+ ban
                            //+ " and invoice_number='"
                            //+ invoice_number
                            //+ "'");
                //int leasebill=0;
                //count = 0;
                //while(rs2.next()){
	                //leasebill = rs2.getInt(1);
	                //if(rs2.wasNull()){
		                //String msg =
                        //"Найденный pos_order для связи счетов и оплаты(ban=" + ban
                            //+ ", invoice_number=" + invoice_number + ") "
                            //+"не содержит ссылки на AbonentBills в системе NRI";
                    	//addMsgInJournal(idtask, "E", msg);
                    	//continue out;
	                //}
	                //++count;
                //}
                //if(count == 0){
	                //String msg =
                        //"Не найден pos_order для связи счетов и оплаты(ban=" + ban
                            //+ ", invoice_number=" + invoice_number + ")";
                    //addMsgInJournal(idtask, "E", msg);
                    //continue;
                //} else if(count > 1){
	                //String msg =
                        //"Найдено несколько pos_order для связи счетов и оплаты(ban=" + ban
                            //+ ", invoice_number=" + invoice_number + ")";
                    //addMsgInJournal(idtask, "E", msg);
                    //continue;
                //}
				//moveOneDnop(idtask, rsP, leasebill, idPaymentNri, ENT_SEQ_NO, ban, insert, update, stateP2, keygen);                
            //}
            //rs2.close();
        //}

        return true;
    } catch (Exception ex) {
        String msg = "Техническая ошибка в moveAllDnopPie2BufferNri";
        addMsgInJournal(idtask, "E", msg);
        pr(ex, "moveAllDnopPie2BufferNri");
        if (ex instanceof SQLException) {
            pr("-----------------------");
            pr("ErrorCode is=" + ((SQLException) ex).getErrorCode());
            pr("-----------------------");
        }
        msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);

    } finally {
        try {
            if (rsP != null)
                rsP.close();
            if (stateP != null)
                stateP.close();
            if (stateP2 != null)
                stateP2.close();
            if (insert != null)
                insert.close();
            if (update != null)
                update.close();
            if (psP != null)
                psP.close();
            if (conJ != null)
                conJ.close();
            if (conP != null)
                conP.close();
        } catch (SQLException sql) {
        }
    }
}
private void moveAllInvoiceItem(int idtask) throws Exception{
	
	Connection conJ = getJuly(idtask);
	Connection conP = getPie(idtask);
	Statement stateP = null;
	Statement stateP2 = null;
	PreparedStatement psJ = null;
	PreparedStatement psJ2 = null;
	PreparedStatement psP = null;
	ResultSet rs = null;
	
//String sql1 = "select b.idBillNri, i.ban, i.ben, i.bill_seq_no, i.item_id, def.item_desc, i.unit_measure,"
//+"i.qty, i.price, i.amt_no_tax, i.tax_percent_rate, i.tot_pym_crd_amt, i.tax_tot_inv_amt, i.record_status, "
//+"i.idresourcenri, i.flagworknri, i.typeworknri, i.idchargenri, i.invoice_number "
//+"from invoice_item i, outer bill b, outer item_definition def "
//+"where i.FlagWorkNri='N' and i.ban=b.ban and i.ben=b.ben and i.bill_seq_no=b.bill_seq_no and i.item_id=def.item_id";


//String sql2 = "insert into AbonentBillPos(BillPos, LeaseBill, Resource, ItemID, ItemName, UnitName, Qty, "
//+"Currency, SummPure, SumPureNRI, Summ, SummNRI, NDSsumm, NDSSummNRI, NDSrate, NSPSumm, "
//+"NSPSummNRI, NSPrate, CargoCountry, CargoNumber, RecordStatus, SumByHand) values"
//+"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

//String sql3 = "update AbonentBillPos set Resource=?, ItemID=?, ItemName=?, UnitName=?, Qty=?, "
//+"Currency=?, SummPure=?, SumPureNRI=?, Summ=?, SummNRI=?, NDSsumm=?, NDSSummNRI=?, NDSrate=?, NSPSumm=?, "
//+"NSPSummNRI=?, NSPrate=?, CargoCountry=?, CargoNumber=?, RecordStatus=?, SumByHand=? "
//+"where BillPos=? and LeaseBill=?";

	try{
		psP = conP.prepareStatement("execute procedure movePosOrders(?)");
		psP.setInt(1, idtask);
		rs = psP.executeQuery();
		//stateP = conP.createStatement();
		//stateP2 = conP.createStatement();
		//psJ = conJ.prepareStatement(sql2);
		//psJ2 = conJ.prepareStatement(sql3);
			
		//KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		//rs = stateP.executeQuery(sql1);
		////int i=0, count=0;
		//while(rs.next()){// переносим разделы счета за услуги связи
			//int ban = rs.getInt("ban");
			//int bill_seq_no = rs.getInt("bill_seq_no");
			//int ben = rs.getInt("ben");

			//int idbillNri = rs.getInt("idBillNri");
			//if(rs.wasNull()){
				//String msg = "Разделы счета за услуги связи("+ban+", "+ben+", "+bill_seq_no+") "
				//+"перенесены не будут. Счет за оборудование не имеет ссылки на AbonentBills";
			    //addMsgInJournal(idtask, "E", msg);
				//continue;
			//}

			//int resource;
			//String item_id = rs.getString("item_id");			
			//if(rs.wasNull())
				//resource = defineResourceForAbonentBill(null, false, ban, bill_seq_no, null, null, conJ, idtask);
			//else
				//resource = defineResourceForAbonentBill(item_id, false, ban, bill_seq_no, null, null, conJ, idtask);
				
			//int idchargenri = rs.getInt("idchargenri");
			//if(rs.wasNull()){// вставляем
				//int key = keygen.getNextKey("tables.abonentbillpos");
				//psJ.setInt(1, key);//BillPos
				//psJ.setInt(2, idbillNri);//leaseBill
				//psJ.setInt(3, resource);//resource
				//psJ.setString(4, item_id);//itemId
				//psJ.setString(5, rs.getString("item_desc"));//item_name
				//psJ.setString(6, rs.getString("unit_measure"));//unit_name
				//psJ.setBigDecimal(7, rs.getBigDecimal("qty"));//qty
				//psJ.setInt(8, getNamedValue("USD", idtask));//currency
				//psJ.setBigDecimal(9, rs.getBigDecimal("amt_no_tax"));//summPure
				//psJ.setBigDecimal(10, rs.getBigDecimal("amt_no_tax"));//summPureNri
				//psJ.setBigDecimal(11, rs.getBigDecimal("tot_pym_crd_amt"));//summ
				//psJ.setBigDecimal(12, rs.getBigDecimal("tot_pym_crd_amt"));//summNri
				//psJ.setBigDecimal(13, rs.getBigDecimal("tax_tot_inv_amt"));//NdsSumm
				//psJ.setBigDecimal(14, rs.getBigDecimal("tax_tot_inv_amt"));//NdsSummNri
				//psJ.setBigDecimal(15, rs.getBigDecimal("tax_percent_rate"));//ndsrate
				//psJ.setBigDecimal(16, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPSumm
				//psJ.setBigDecimal(17, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPSummNri
				//psJ.setBigDecimal(18, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPRate
				//psJ.setString(19, getCargoCountry(idtask));//cargoCountry
				//psJ.setString(20, null);//cargoNumber
				//psJ.setString(21, rs.getString("record_status"));//record_status
				//psJ.setString(22, "N");//summByHand
				////psJ.executeUpdate();
				//psJ.addBatch();

				////stateP2.executeUpdate("update invoice_item set idChargenri="+key+", flagWorkNri='Y'"
					////+" where ban="+ban+" and bill_seq_no="+bill_seq_no);
				//stateP2.addBatch("update invoice_item set idChargenri="+key+", flagWorkNri='Y'"
					//+" where ban="+ban+" and bill_seq_no="+bill_seq_no);
				
			//} else {// обновляем	
				//psJ2.setInt(1, resource);//resource
				//psJ2.setString(2, item_id);//itemId
				//psJ2.setString(3, rs.getString("item_desc"));//item_name
				//psJ2.setString(4, rs.getString("unit_measure"));//unit_name
				//psJ2.setBigDecimal(5, rs.getBigDecimal("qty"));//qty
				//psJ2.setInt(6, getNamedValue("USD", idtask));//currency
				//psJ2.setBigDecimal(7, rs.getBigDecimal("amt_no_tax"));//summPure
				//psJ2.setBigDecimal(8, rs.getBigDecimal("amt_no_tax"));//summPureNri
				//psJ2.setBigDecimal(9, rs.getBigDecimal("tot_pym_crd_amt"));//summ
				//psJ2.setBigDecimal(10, rs.getBigDecimal("tot_pym_crd_amt"));//summNri
				//psJ2.setBigDecimal(11, rs.getBigDecimal("tax_tot_inv_amt"));//NdsSumm
				//psJ2.setBigDecimal(12, rs.getBigDecimal("tax_tot_inv_amt"));//NdsSummNri
				//psJ2.setBigDecimal(13, rs.getBigDecimal("tax_percent_rate"));//ndsrate
				//psJ2.setBigDecimal(14, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPSumm
				//psJ2.setBigDecimal(15, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPSummNri
				//psJ2.setBigDecimal(16, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPRate
				//psJ2.setString(17, getCargoCountry(idtask));//cargoCountry
				//psJ2.setString(18, null);//cargoNumber
				//psJ2.setString(19, rs.getString("record_status"));//record_status
				//psJ2.setString(20, "N");//summByHand
				//psJ2.setInt(21, idchargenri);//BillPos
				//psJ2.setInt(22, rs.getInt("idBillNri"));//leaseBill
				////psJ2.executeUpdate();
				//psJ2.addBatch();

				////stateP2.executeUpdate("update invoice_item set flagWorkNri='Y'"
					////+" where ban="+ban+" and bill_seq_no="+bill_seq_no);
				//stateP2.addBatch("update invoice_item set flagWorkNri='Y'"
					//+" where ban="+ban+" and bill_seq_no="+bill_seq_no);
			//}
		//}
		//psJ.executeBatch();
		//psJ2.executeBatch();
		//stateP2.executeBatch();
		//psJ.clearBatch();
		//psJ2.clearBatch();
		//stateP2.clearBatch();

//String sql4 = "select pos.store_id, pos.activity_type, pos.order_oid, pos.line_seq, pos.item_id, "
//+"pos.unit_measure, pos.qty_released, pos.unit_price, pos.eqp_amt_no_tax, pos.tax, pos.equipment_vat, "
//+"pos.eqp_amt, pos.cargo_country, pos.cargo_number, pos.record_status, "
//+"pos.typeworknri, pos.idchargenri, def.item_desc, ord.idPosOrderNri "
//+"from pos_order_line pos, outer pos_order ord, outer item_definition def "
//+"where pos.flagworknri='N' and pos.item_id=def.item_id and pos.store_id=ord.store_id and "
//+"pos.activity_type=ord.activity_type and pos.order_oid=ord.order_oid";

		//rs = stateP.executeQuery(sql4);		
		//while(rs.next()){// переносим разделы счета за оборудование 
			//String store_id = rs.getString("store_id");
			//String activity_type=rs.getString("activity_type");
			//int order_oid = rs.getInt("order_oid");

			//int idPosOrderNri = rs.getInt("idPosOrderNri");
			//if(rs.wasNull()){
				//String msg = "Разделы счета за оборудование("+store_id+", "+activity_type+", "+order_oid+") "
				//+"перенесены не будут. Счет за оборудование не имеет ссылки на AbonentBills";
			    //addMsgInJournal(idtask, "E", msg);
				//continue;
			//}
			
			//int line_seq = rs.getInt("line_seq"); 
			//int resource;
			//String item_id = rs.getString("item_id");
			//if(rs.wasNull())
				//resource = 
				//defineResourceForAbonentBill(null, true, order_oid, line_seq, store_id, activity_type, conJ, idtask);
			//else
				//resource = 
				//defineResourceForAbonentBill(item_id, true, order_oid, line_seq, store_id, activity_type, conJ, idtask);
				
			//int idchargenri = rs.getInt("idchargenri");

			//if(rs.wasNull()){ //   вставляем
				//int key = keygen.getNextKey("tables.abonentbillpos");
				//psJ.setInt(1, key);//BillPos
				//psJ.setInt(2, rs.getInt("idPosOrderNri"));//leaseBill
				//psJ.setInt(3, resource);//resource
				//psJ.setString(4, item_id);//itemId
				//psJ.setString(5, rs.getString("item_desc"));//item_name
				//psJ.setString(6, rs.getString("unit_measure"));//unit_name
				//psJ.setBigDecimal(7, rs.getBigDecimal("qty_released"));//qty
				//psJ.setInt(8, getNamedValue("USD", idtask));//currency
				//psJ.setBigDecimal(9, rs.getBigDecimal("eqp_amt_no_tax"));//summPure
				//psJ.setBigDecimal(10, rs.getBigDecimal("eqp_amt_no_tax"));//summPureNri
				//psJ.setBigDecimal(11, rs.getBigDecimal("eqp_amt"));//summ
				//psJ.setBigDecimal(12, rs.getBigDecimal("eqp_amt"));//summNri
				//psJ.setBigDecimal(13, rs.getBigDecimal("equipment_vat"));//NdsSum
				//psJ.setBigDecimal(14, rs.getBigDecimal("equipment_vat"));//NdsSummNr
				//psJ.setBigDecimal(15, rs.getBigDecimal("tax"));//ndsrate
				//psJ.setBigDecimal(16, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPSumm
				//psJ.setBigDecimal(17, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPSummNri
				//psJ.setBigDecimal(18, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPRate
				//psJ.setString(19, rs.getString("cargo_country"));//cargoCountry
				//psJ.setString(20, rs.getString("cargo_number"));//cargoNumber
				//psJ.setString(21, rs.getString("record_status"));//record_status
				//psJ.setString(22, "N");//summByHand
				////psJ.executeUpdate();
				//psJ.addBatch();

				////stateP2.executeUpdate("update pos_order_line set idChargenri="+key+", flagWorkNri='Y'"
					////+" where store_id='"+store_id+"' and activity_type='"+activity_type
					////+"' and order_oid="+order_oid+" and line_seq="+line_seq);
				//stateP2.addBatch("update pos_order_line set idChargenri="+key+", flagWorkNri='Y'"
					//+" where store_id='"+store_id+"' and activity_type='"+activity_type
					//+"' and order_oid="+order_oid+" and line_seq="+line_seq);
			//} else {// обновляем						
				//psJ2.setInt(1, resource);//resource
				//psJ2.setString(2, item_id);//itemId
				//psJ2.setString(3, rs.getString("item_desc"));//item_name
				//psJ2.setString(4, rs.getString("unit_measure"));//unit_name
				//psJ2.setBigDecimal(5, rs.getBigDecimal("qty_released"));//qty
				//psJ2.setInt(6, getNamedValue("USD", idtask));//currency
				//psJ2.setBigDecimal(7, rs.getBigDecimal("eqp_amt_no_tax"));//summPure
				//psJ2.setBigDecimal(8, rs.getBigDecimal("eqp_amt_no_tax"));//summPureNri
				//psJ2.setBigDecimal(9, rs.getBigDecimal("eqp_amt"));//summ
				//psJ2.setBigDecimal(10, rs.getBigDecimal("eqp_amt"));//summNri
				//psJ2.setBigDecimal(11, rs.getBigDecimal("equipment_vat"));//NdsSum
				//psJ2.setBigDecimal(12, rs.getBigDecimal("equipment_vat"));//NdsSummNr
				//psJ2.setBigDecimal(13, rs.getBigDecimal("tax"));//ndsrate
				//psJ2.setBigDecimal(14, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPSumm
				//psJ2.setBigDecimal(15, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPSummNri
				//psJ2.setBigDecimal(16, new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));//NSPRate
				//psJ2.setString(17, rs.getString("cargo_country"));//cargoCountry
				//psJ2.setString(18, rs.getString("cargo_number"));//cargoNumber
				//psJ2.setString(19, rs.getString("record_status"));//record_status
				//psJ2.setString(20, "N");//summByHand
				//psJ2.setInt(21, idchargenri);//BillPos
				//psJ2.setInt(22, rs.getInt("idPosOrderNri"));//leaseBill
				////psJ2.executeUpdate();
				//psJ2.addBatch();

				////stateP2.executeUpdate("update pos_order_line set flagWorkNri='Y'"
					////+" where store_id='"+store_id+"' and activity_type='"+activity_type
					////+"' and order_oid="+order_oid+" and line_seq="+line_seq);
				//stateP2.addBatch("update pos_order_line set flagWorkNri='Y'"
					//+" where store_id='"+store_id+"' and activity_type='"+activity_type
					//+"' and order_oid="+order_oid+" and line_seq="+line_seq);
			//}
		//}
		//psJ.executeBatch();
		//psJ2.executeBatch();
		//stateP2.executeBatch();

	}catch(Exception ex){
		String msg = "Техническая ошибка в moveAllInvoiceItem";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveAllInvoiceItem");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		throw ex;
	} 
	finally{
		try{
			if(rs != null) rs.close();
			if(stateP != null) stateP.close();
			if(stateP2 != null) stateP2.close();
			if(psJ != null) psJ.close();
			if(psP != null) psP.close();
			if(psJ2 != null) psJ2.close();
			if(conJ != null) conJ.close();
			if(conP != null) conP.close();
		}catch(SQLException sql){}
	}
}
public boolean moveAllNri2PIE(int idtask)  throws java.rmi.RemoteException {
	try{
		movePayOnAktBufferNri2Pie(idtask);
		moveListBanFromNri2Pie(idtask);
        return true;
    } catch (Exception ex) {
        pr(ex, "moveAllNri2PIE");
        if (ex instanceof SQLException) {
            pr("-----------------------");
            pr("ErrorCode is=" + ((SQLException) ex).getErrorCode());
            pr("-----------------------");
        }        
    }
    return false;
}
public void moveAllPaymentPie2BufferNri(int idtask) throws java.rmi.RemoteException{
	
	Connection conJ = null;
	Connection conP = null;
	Statement stateP = null;
	PreparedStatement psP = null;
	PreparedStatement psJ = null;
	PreparedStatement psJ2 = null;
	ResultSet rsP = null;
	
//String query1 = "select p.ban, t.type_desc, p.pym_type, p.ent_seq_no, p.cur_code, p.withdraw_date, p.cur_exch_date, "
//+"p.record_status, p.flagWorkNri, p.typeWorkNri, p.idPaymentNri, p.bank_pym_id, p.actual_amt, "
//+"p.cur_actual_amt, p.ben, bil.idLeaseDocument, p.withdraw_date, p.bank_pym_id  "
//+"from payment p, outer payment_type t, billing_account bil "
//+"where p.ban=? and p.ent_seq_no=? and p.pym_type=t.pym_type and bil.ban=p.ban";

//String query2 = "insert into AbonentPayments (PayPos, LeaseDocument, NeedPay, TypeName, SumPayUsd, SumPayRUR, "
//+"SumNRIrur, SumNRIUsd, SumFreeRur, SumFreeUsd, ByHand, resource, FlagWorkNRI, RecordStatus, paydate, paynumber) values"
//+"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

//String query3 = "update AbonentPayments set NeedPay=?, TypeName=?, SumPayUsd=?, SumPayRUR=?, "
//+"ByHand=?, FlagWorkNRI=?, RecordStatus=?, paydate=?, paynumber=? "
//+"where PayPos=? and LeaseDocument=?";
	try{
		conJ = getJuly(idtask);
		conP = getPie(idtask);
		psP = conP.prepareStatement("execute procedure movePayments(?)");
		psP.setInt(1, idtask);
		rsP = psP.executeQuery();
		//stateP = conP.createStatement();
		//psP = conP.prepareStatement(query1);
		//psJ = conJ.prepareStatement(query2);
		//psJ2 = conJ.prepareStatement(query3);
 
		//ArrayList[] ar = checkPaymentInPie(conP, idtask);
		//ArrayList ban = ar[0], pay = ar[1];
		//KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		//for(int i=0; i<ban.size(); i++){
			//psP.setInt(1, ((Integer)ban.get(i)).intValue());
			//psP.setInt(2, ((Integer)pay.get(i)).intValue());
			//rsP = psP.executeQuery();
			//rsP.next();
			//int payPos = rsP.getInt("idPaymentNri");
			//if(rsP.wasNull()){
			    //int paypos = keygen.getNextKey("tables.abonentpayments");
			    //psJ.setInt(1, paypos);//paypos
			    //psJ.setInt(2, rsP.getInt("idLeaseDocument"));
			    //psJ.setString(3, "N");//needpay
			    //psJ.setString(4, rsP.getString("type_desc"));//typeName
			    //psJ.setBigDecimal(5, rsP.getBigDecimal("actual_amt"));//sumPayUsd
			    //psJ.setBigDecimal(6, rsP.getBigDecimal("cur_actual_amt"));//sumPayRur
			    //psJ.setBigDecimal(7, null);//sumNriRur
			    //psJ.setBigDecimal(8, null);//sumNriUsd
			    //psJ.setBigDecimal(9, null);//sumFreeRur
			    //psJ.setBigDecimal(10, null);//sumFreeUsd
			    //psJ.setString(11, "N");//byHand
			    //psJ.setNull(12, Types.INTEGER);//resource---------------------null
			    //psJ.setString(13, "N");//flagWorkNRI
			    //psJ.setString(14, rsP.getString("record_status"));
			    //psJ.setDate(15, rsP.getDate("withdraw_date"));//paydate
			    //psJ.setString(16, ""+rsP.getInt("bank_pym_id"));//paynumber
			    //psJ.executeUpdate();

			    //stateP.executeUpdate("update payment set idPaymentNri="+paypos+", flagWorkNri='Y' "
				    //+" where ban="+rsP.getInt("ban")+" and ENT_SEQ_NO="+rsP.getInt("ent_seq_no"));

			//} else {
		
			    //psJ2.setString(1, "N");//needpay
			    //psJ2.setString(2, rsP.getString("type_desc"));//typeName
			    //psJ2.setBigDecimal(3, rsP.getBigDecimal("actual_amt"));//sumPayUsd
			    //psJ2.setBigDecimal(4, rsP.getBigDecimal("cur_actual_amt"));//sumPayRur
			    //psJ2.setString(5, "N");//byHand
			    //psJ2.setString(6, "N");//flagWorkNRI
			    //psJ2.setString(7, rsP.getString("record_status"));
			    //psJ2.setDate(8, rsP.getDate("withdraw_date"));//paydate
			    //psJ2.setString(9, ""+rsP.getInt("bank_pym_id"));//paynumber
			    //psJ2.setInt(10, payPos);//paypos
			    //psJ2.setInt(11, rsP.getInt("idLeaseDocument"));
			    //psJ2.executeUpdate();

			    //stateP.executeUpdate("update payment set flagWorkNri='Y' "
				    //+" where ban="+rsP.getInt("ban")+" and ENT_SEQ_NO="+rsP.getInt("ent_seq_no"));
			//}
		//}
		
	}catch(Exception ex){
		String msg = "Техническая ошибка в moveAllPaymentPie2BufferNri";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveAllPaymentPie2BufferNri");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);

	} 
	finally{
		try{
			if(rsP != null) rsP.close();
			if(stateP != null) stateP.close();
			if(psP != null) psP.close();
			if(psJ != null) psJ.close();
			if(psJ2 != null) psJ2.close();
			if(conJ != null) conJ.close();
			if(conP != null) conP.close();
		}catch(SQLException sql){}
	}
}
public boolean moveBilFromBilling(String bil, int billid, int idtask) throws java.rmi.RemoteException{

	Connection conJ = null;
	PreparedStatement psJ = null;
	ResultSet rs = null;
	
	try{
		boolean retval = false;
		conJ = getJuly(idtask);
		psJ = conJ.prepareStatement("execute procedure moveBilFromBilling(?, ?)");
		psJ.setInt(1, billid);
		psJ.setInt(2, idtask);
		rs = psJ.executeQuery();
		if(rs.next()){
			if(rs.getInt(1) == 1) retval = true;
		}
		
		return retval;
	}catch(Exception ex){
		String msg = "Техническая ошибка в movePayFromBilling";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "movePayFromBilling");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);

	} 
	finally{
		try{
			if(psJ != null) psJ.close();
			if(conJ != null) conJ.close();
		}catch(SQLException sql){}
	}
}
public void moveListBanFromNri2Pie(int idtask) throws java.rmi.RemoteException {
	Connection conJ = null;
	Connection conP = null;
	Statement stateJ = null;
	Statement stateP = null;
	PreparedStatement psP = null;
	ResultSet rsj = null;
	ResultSet rsp = null;
	
String sql1 = "select ban from LeaseAbonentBAN";
String sql2 = "delete from ban_list where ban not in(";//pie
	try{
		conJ = getJuly(idtask);
		conP = getPie(idtask);
		stateJ = conJ.createStatement();
		stateP = conP.createStatement();
		rsj = stateJ.executeQuery(sql1);
		StringBuffer buf = new StringBuffer();
		while(rsj.next()){//Собираем баны в LeaseAbonentBAN
			buf.append(rsj.getInt(1));
			buf.append(',');
		}
		if(buf.length() >0)//Удаляем баны из ban_list которых нету в LeaseAbonentBAN
			stateP.executeUpdate(sql2+buf.deleteCharAt(buf.length()-1).toString()+")");

//Подготавливаем StringBuffer, в котором будут баны, которых нет в ban_list
		String sql3 = "select ban from LeaseAbonentBan";
		String sql4 = "select ban from ban_list";//pie
		rsj = stateJ.executeQuery(sql3);
		ArrayList banJ = new ArrayList();
		while(rsj.next())
			banJ.add(new Integer(rsj.getInt(1)));
		rsp = stateP.executeQuery(sql4);
		while(rsp.next())
			if(!banJ.isEmpty())
				banJ.remove(new Integer(rsp.getInt(1)));
		buf = new StringBuffer();
		for(int i=0; i<banJ.size(); i++){
			buf.append(banJ.get(i).toString());
			buf.append(',');
		}
//Вставляем баны в ban_list, которых небыло		
		if(buf.length() != 0){
			buf.deleteCharAt(buf.length()-1);
			String sql5 = "select lb.BAN, lc.orgCustomer, 'N' from LeaseAbonentBAN lb, LeaseContracts lc "
			+"where lb.leaseDocument=lc.leaseDocument and lb.ban in("+buf.toString()+")";
			String sql6 = "insert into ban_list (ban, idOrganizationNri, flagWorkPie) values(?, ?, ?)";//pie
			psP = conP.prepareStatement(sql6);
			rsj = stateJ.executeQuery(sql5);
			while(rsj.next()){
				psP.setInt(1, rsj.getInt("ban"));
				psP.setInt(2, rsj.getInt("orgCustomer"));
				psP.setString(3, "N");
				psP.executeUpdate();
			}
		}
	}catch(Exception ex){
		String msg = "Техническая ошибка в moveListBanFromNri2Pie";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "moveListBanFromNri2Pie");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
	} 
	finally{
		try{
			if(rsj != null) rsj.close();
			if(rsp != null) rsp.close();
			if(stateJ != null) stateJ.close();
			if(stateP != null) stateP.close();
			if(psP != null) psP.close();
			if(conJ != null) conJ.close();
			if(conP != null) conP.close();
		}catch(SQLException sql){}
	}
}
public void moveOneDnop(
    int idtask,
    ResultSet rsP,
    int leasebill,
    int idPaymentNri,
    int ent_seq_no,
    int ban,
    PreparedStatement insert,
    PreparedStatement update,
    Statement stateP2,
    KeyGeneratorAccessBean keygen)
    throws java.rmi.RemoteException {
    try {
        int idLinkNri = rsP.getInt("idLinkNri");
        if (rsP.wasNull()) { //Вставляем
            int key = keygen.getNextKey("tables.leaseabonentdnop");
            insert.setInt(1, key); //idAbonentDNOP
            insert.setInt(2, leasebill); //leaseBill
            insert.setInt(3, idPaymentNri); //paypos
            insert.setBigDecimal(4, rsP.getBigDecimal("link_amt")); //flagWorkNri
            insert.setString(5, "N");
            insert.setString(6, rsP.getString("record_status")); //RecordStatus
            insert.executeUpdate();

            stateP2.executeUpdate(
                "update credit_debit_link set idLinkNri="
                    + key
                    + ", flagWorkNri='Y' where ent_seq_no="
                    + ent_seq_no
                    + " and ban="
                    + ban);
        } else { //Обновляем 
            update.setInt(1, leasebill); //leaseBill
            update.setInt(2, idPaymentNri); //paypos
            update.setBigDecimal(3, rsP.getBigDecimal("link_amt")); //sumLinkUsd
            update.setString(4, "N"); //flagWorkNri
            update.setString(5, rsP.getString("record_status")); //RecordStatus
            update.setInt(6, idLinkNri); //idAbonentDNOP
            update.executeUpdate();

            stateP2.executeUpdate(
                "update credit_debit_link set flagWorkNri='Y'"
                    + " where ent_seq_no="
                    + ent_seq_no
                    + " and ban="
                    + ban);
        }

    } catch (Exception ex) {
        String msg = "Техническая ошибка в moveOneDnop"; 
        addMsgInJournal(idtask, "E", msg);
        pr(ex, "moveOneDnop");
        if (ex instanceof SQLException) {
            pr("-----------------------");
            pr("ErrorCode is=" + ((SQLException) ex).getErrorCode());
            pr("-----------------------");
        }
        msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
    }
}
public boolean movePayFromBilling(int payid, int idtask, String autolink) throws java.rmi.RemoteException{

	Connection conJ = null;
	PreparedStatement psJ = null;
	ResultSet rs = null;
	
	try{
		boolean retval = false;
		conJ = getJuly(idtask);
		psJ = conJ.prepareStatement("execute procedure movePayFromBilling(?, ?, ?)");
		psJ.setInt(1, payid);
		psJ.setInt(2, idtask);
		psJ.setString(3, autolink);
		rs = psJ.executeQuery();
		if(rs.next()){
			int res = rs.getInt(1);
			if(res == 1) retval = true;
		}
		
		return retval;
	}catch(Exception ex){
		String msg = "Техническая ошибка в movePayFromBilling";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "movePayFromBilling");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);

	} 
	finally{
		try{
			if(psJ != null) psJ.close();
			if(conJ != null) conJ.close();
		}catch(SQLException sql){}
	}
}
public boolean movePayOnAktBufferNri2Pie(int idtask) throws java.rmi.RemoteException{
    //Перенести платежи по акту из буфера системы NRI в систему PIE

    Connection conJ = null;
    Connection conP = null;
    Statement stateJ = null;
    Statement stateJ2 = null;
    Statement stateP = null;
    PreparedStatement psP = null;
    ResultSet rsJ = null;
    ResultSet rsP = null;

    try { 
	    conJ = getJuly(idtask);
		conP = getPie(idtask);
        stateJ = conJ.createStatement();
        stateJ2 = conJ.createStatement();
        stateP = conP.createStatement();

        //Находим необработанные акты и контракты
        ArrayList pay2bill = new ArrayList(), acts = new ArrayList(), contracts = new ArrayList();
        String query = "select leaseMutualAct, leaseContract from leasePay2Bill where flagWorkPie='N'";
        rsJ = stateJ.executeQuery(query);
        while (rsJ.next()){
	        int act = rsJ.getInt(1), contract = rsJ.getInt(2);
	        pay2bill.add(new LeasePay(act, contract));
	        acts.add(new Integer(act));
	        contracts.add(new Integer(contract));
        }
		if(acts.size() == 0) return true;
        
        ArrayList insert = new ArrayList(), update = new ArrayList();
        //Формируем списки для вставки и обновления
	    query = "select aktnri, contractnri from info_akts where aktnri in ("
	    +acts.toString().substring(1, acts.toString().length()-1)
	    +") and contractnri in ("
	    +contracts.toString().substring(1, contracts.toString().length()-1)
	    +")";
		rsP = stateP.executeQuery(query);
		while(rsP.next()){
			LeasePay local = new LeasePay(rsP.getInt(1), rsP.getInt(2));			
			if(pay2bill.contains(local)){
				update.add(local);
			} else {
				insert.add(local);
			}
		}
		
		query = "insert into info_akts "
		+"(aktnri, contractnri, ban, numberakt, dateakt, summ, currencynri, flagworkpie, recordstatus) "
		+"values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		psP = conP.prepareStatement(query);

		int currency = getNamedValue("USD", idtask);

		rsJ = stateJ.executeQuery(getQuery(insert));
		while(rsJ.next()){//Вставляем по полученному списку
			psP.setInt(1, rsJ.getInt("leasemutualact"));//aktnri
			psP.setInt(2, rsJ.getInt("leasecontract"));//contractnri
			psP.setInt(3, rsJ.getInt("ban"));//ban
			psP.setString(4, rsJ.getString("docnumber"));//numberAkt
			psP.setDate(5, rsJ.getDate("docdate"));//dateakt
			psP.setBigDecimal(6, rsJ.getBigDecimal("summusd"));//summ
			psP.setInt(7, currency);//currency
			psP.setString(8, "N");//flagWorkPie
			psP.setString(9, rsJ.getString("record_status"));//recordStatus
			psP.executeUpdate();

			//Ставим флажок, что эта запись обработана
			stateJ2.executeUpdate("update LeasePay2Bill set flagWorkPie='Y' "
				+"where leaseMutualAct="+rsJ.getInt("leasemutualact")
				+" and leaseContract="+rsJ.getInt("leasecontract"));
		}

		query = "update info_akts set ban=?, numberakt=?, dateakt=?, summ=?, currencynri=?, "
		+"flagworkpie=?, recordstatus=? where aktnri=? and contractnri=?";
		psP = conP.prepareStatement(query);
		rsJ = stateJ.executeQuery(getQuery(update));
		while(rsJ.next()){//Обновляем по полученному списку		
			psP.setInt(1, rsJ.getInt("ban"));//ban
			psP.setString(2, rsJ.getString("docnumber"));//numberAkt
			psP.setDate(3, rsJ.getDate("docdate"));//dateakt
			psP.setBigDecimal(4, rsJ.getBigDecimal("summusd"));//summ
			psP.setInt(5, currency);//currency
			psP.setString(6, "N");//flagWorkPie
			psP.setString(7, rsJ.getString("record_status"));//recordStatus
			psP.setInt(8, rsJ.getInt("leasemutualact"));//aktnri
			psP.setInt(9, rsJ.getInt("leasecontract"));//contractnri
			
			psP.executeUpdate();

			//Ставим флажок, что эта запись обработана
			stateJ2.executeUpdate("update LeasePay2Bill set flagWorkPie='Y' "
				+"where leaseMutualAct="+rsJ.getInt("leasemutualact")
				+" and leaseContract="+rsJ.getInt("leasecontract"));
		}

        return true;
    } catch (Exception ex) {
	    String msg = "Техническая ошибка в movePayOnAktBufferNri2Pie";
	    addMsgInJournal(idtask, "E", msg);
        pr(ex, "movePayOnAktBufferNri2Pie");
        if (ex instanceof SQLException) {
            pr("-----------------------");
            pr("ErrorCode is=" + ((SQLException) ex).getErrorCode());
            pr("-----------------------");
        }
        msg = (ex.getMessage()==null?"No Message" : ex.getMessage());
		throw new RemoteException(msg);
    } finally {
        try {
            if (rsJ != null) rsJ.close();
            if (rsP != null) rsP.close();
            if (stateJ != null) stateJ.close();
            if (stateJ2 != null) stateJ2.close();
            if (stateP != null) stateP.close();
            if (psP != null) psP.close();
            if (conJ != null) conJ.close();
            if (conP != null) conP.close();
        } catch (SQLException sql) {
        }
    }
}
private void pr(Exception ex, String str) {
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
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
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
}
private void pr(String str) {
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println(this.getClass().getName() +"."+ str);
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
}
private void processEx(Exception ex) {
    //if (!(ex instanceof RemoteException) && !(ex instanceof EJBException) && !(ex instanceof RuntimeException))
        //mySessionCtx.setRollbackOnly();

    ////if(ex instanceof java.sql.SQLException)
    	////pr("//////// Error code="+((java.sql.SQLException)ex).getErrorCode()+" \\\\\\\\\\");

    	try{
    if (ex instanceof java.rmi.ServerException) {
        if (((java.rmi.ServerException) ex).detail instanceof com.ibm.ejs.persistence.EJSPersistenceException) {
            if (((com.ibm.ejs.persistence.EJSPersistenceException)
	            (((java.rmi.ServerException) ex).detail)).detail instanceof java.sql.SQLException) {
                int code = ((java.sql.SQLException) (((com.ibm.ejs.persistence.EJSPersistenceException)
	                (((java.rmi.ServerException) ex).detail)).detail)).getErrorCode();
                System.out.println("Error code from ProcessEx (instanceof EJSPersistenceException)= " + code);
            }
        } else if (((java.rmi.ServerException)ex).detail instanceof com.ibm.websphere.cpi.CPIException) {
            if (((com.ibm.websphere.cpi.CPIException) 
	            (((java.rmi.ServerException)ex).detail)).detail instanceof java.sql.SQLException) {
                int code = ((java.sql.SQLException) (((com.ibm.websphere.cpi.CPIException)
	                (((java.rmi.ServerException)ex).detail)).detail)).getErrorCode();
                System.out.println("Error code from ProcessEx (instanceof CPIException)= " + code);
            }
        }
    }
    	}catch(Exception exx){pr(exx, "processEx");}
}
private void setBilltype(int idtask, Object[] bills) throws Exception{
/*
Для каждого AbonentBill найти все AbonentBillPos
У этой выборки проверить ресурс
Если он хоть где-то разный, то AbonentBill.BillType ставим "S"
*/
	Connection con = getJuly(idtask);
	Statement state = null;
	ResultSet rs = null;
	
String sql1 = "select leaseBill, resource from AbonentBillPos where leaseBill = ";
String sql2 = "update AbonentBills set billType = 'S' where leaseBill = ";
	try{
		state = con.createStatement();

		begin:
		for(int i = 0; i < bills.length; i++){
			rs = state.executeQuery(sql1+((Integer)bills[i]).intValue());
			rs.next();
			int resource = rs.getInt(2);
			while(rs.next()){
				if(resource != rs.getInt(2)){
					state.executeUpdate(sql2+rs.getInt(1));
					continue begin;
				}
			}
		}

	}catch(Exception ex){
		String msg = "Техническая ошибка в setBilltype";
	    addMsgInJournal(idtask, "E", msg);
		pr(ex, "setBilltype");
		if(ex instanceof SQLException){
			pr("-----------------------");
			pr("ErrorCode is="+((SQLException)ex).getErrorCode());
			pr("-----------------------");
		}
		throw ex;
	} 
	finally{
		try{
			if(rs != null) rs.close();
			if(state != null) state.close();
			if(con != null) con.close();
		}catch(SQLException sql){}
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
public void taskEnd(int idtask) throws java.rmi.RemoteException{
    try {
        getJournal().taskEnd(idtask);
    } catch (Exception ex) {
        pr(ex, "taskEnd. idtask=" + idtask);
    }
}
public int taskStart(int operator, String taskType) throws java.rmi.RemoteException{
    try {
	    return getJournal().taskStart(operator, taskType);
    } catch (Exception ex) {
        pr(ex, "taskStart()");
    }
    return -1;
}
private int updateLeaseAbonentBan(String query, PreparedStatement ps, ResultSet rs, int idtask) throws Exception {

    try {
	    int ban = rs.getInt("ban");
        ps.setString(1, rs.getString("at_account_type"));
        ps.setString(2, rs.getString("at_account_type_de"));
        ps.setString(3, rs.getString("inn"));
        ps.setString(4, rs.getString("name"));
        ps.setString(5, rs.getString("cntrct_status"));
        ps.setString(6, rs.getString("pw_description"));
        ps.setTimestamp(7, rs.getTimestamp("cntrct_status_date"));
        ps.setDate(8, rs.getDate("start_service_date"));
        ps.setDate(9, rs.getDate("suspended_date"));
        ps.setString(10, rs.getString("bill_address"));
        ps.setString(11, "N");
        ps.setInt(12, ban);
        ps.executeUpdate();
        return ban;
    } catch (SQLException ex) {
	    String msg = "Техническая ошибка в updateLeaseAbonentBan";
	    addMsgInJournal(idtask, "E", msg);
	    pr(ex, "updateLeaseAbonentBan");
        pr("Query is=" + query);
        pr("Exception is=" + ex.getMessage());
        pr("ErrorCode is=" + ex.getErrorCode());
        pr("-------------------");
        throw ex;
    }
}
private void updateLeaseDocument(Statement state, PreparedStatement ps, ResultSet rs, int idtask) throws Exception {

    //"update LeaseDocuments set docdate=?,"
    //+"docnumber=?,  doctype='B' where leaseDocument=?";
    try {
	    int tban = rs.getInt("ban");
        ResultSet res = state.executeQuery(
	        "select leaseDocument from leaseAbonentBan where ban=" + tban);
        int leaseDocument = 0, count = 0;
        while (res.next()) {
            leaseDocument = res.getInt(1);
            ++count;
        }
        if (count > 1){
	        String msg = "В системе NRI ban("+tban+") не уникален";
		    addMsgInJournal(idtask, "E", msg);
		    throw new Exception("В системе NRI ban("+tban+") не уникален");
        }

        java.sql.Date date = rs.getDate("contract_date");
        if(rs.wasNull())
        	return;
        String ban = "" + rs.getInt("ban");
        ps.setDate(1, date);
        ps.setString(2, ban);
        ps.setInt(3, leaseDocument);
        //ps.setInt(3, 123);
        ps.executeUpdate();
    } catch (SQLException ex) {
	    String msg = "Техническая ошибка в updateLeaseDocument";
	    addMsgInJournal(idtask, "E", msg);
        pr(ex, "updateLeaseDocument");
        //pr("Query is=" + query);
        pr("Exception is=" + ex.getMessage());
        pr("ErrorCode is=" + ex.getErrorCode());
        pr("-------------------");
        throw ex;
    }
}
}
