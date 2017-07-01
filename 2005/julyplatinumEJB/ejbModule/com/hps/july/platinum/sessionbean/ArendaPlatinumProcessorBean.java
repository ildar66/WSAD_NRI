package com.hps.july.platinum.sessionbean;

import com.hps.july.jdbcpersistence.*;
import java.sql.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.platinum.sessionbean.arenda.*;

/**
 * This is a Session Bean Class
 * Передача данных по аренде в Platinum
 */

public class ArendaPlatinumProcessorBean implements SessionBean {
    private javax.ejb.SessionContext mySessionCtx = null;
    private final static long serialVersionUID = 3206093459760846163L;

	private String testField;
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
 * Insert the method's description here.
 * Creation date: (27.03.2003 11:52:39)
 * @return java.sql.Connection
 * @exception java.lang.Exception The exception description.
 */
private Connection getConnection() throws java.lang.Exception {
	Properties prp = new EnvironmentAccessBean().getEnvironmentProperties();
	String dsName = prp.getProperty("DATASOURCE_NAME");
	String factoryClass = prp.getProperty("FACTORY_CLASS");
	
	javax.naming.InitialContext ctx = null;
	Properties prop = new Properties();
	prop.put(javax.naming.Context.PROVIDER_URL, "iiop://");
	prop.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass);
	ctx = new javax.naming.InitialContext(prop);
	
	return ((javax.sql.DataSource) ctx.lookup(dsName)).getConnection();
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (31.01.2003 20:29:32)
 * @return int
 */
private String getTestField() {
	System.out.println("getTestField: this="+this+" testField="+testField);
	return testField;
	
}
/**
 * Insert the method's description here.
 * Creation date: (21.01.2003 11:05:43)
 * @return boolean
 */
public boolean isProcessingEnabled() throws RemoteException {

    try {
         return Util_Alex.receiveIntConstant(SystemConstants.SYNCNRIPLATINARENDA) == 1;
    } catch (Exception e) {
     return false;   
	    //throw new RemoteException("SYNCNRIPLATINARENDA not received", e);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 10:08:24)
 * @param operator int
 * @param bank java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public int makeQryGetBanks(int operator, Integer bank) throws java.rmi.RemoteException {
	try {
		int ret = -1;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement("execute procedure makeQryGetBanks(?, " + bank + ")");
			ps.setInt(1, operator);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) ret = rs.getInt(1);
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While make qry get banks, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2003 14:41:44)
 * @return int
 * @param operator int
 * @param contract int
 * @param payment int
 */
public int makeQryGetPays(int operator, Integer contract, Integer payment, Date payDateStart, Date payDateFinish) throws java.rmi.RemoteException {
	try {
		int ret = -1;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement("execute procedure makeQryGetPays(?, " + contract + ", " + payment + ", ?, ?)");
			ps.setInt(1, operator);
			ps.setDate(2, payDateStart);
			ps.setDate(3, payDateFinish);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) ret = rs.getInt(1);
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While make qry get pays, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2003 10:05:27)
 * @return int
 * @param operator int
 */
public int makeQryGetSprArenda(int operator) throws java.rmi.RemoteException {
	try {
		int ret = -1;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement("execute procedure makeQryGetSprArend(?)");
			ps.setInt(1, operator);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) ret = rs.getInt(1);
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	} catch (Exception ex) {
		ex.printStackTrace();
		throw new java.rmi.RemoteException("While make qry get sprarenda, ", ex);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 13:35:17)
 * @return boolean
 * @param paramDateStart java.sql.Date
 * @param paramIdDogovor int
 */
public void makeQueryGetBanks(
 Integer paramIdBank, Integer operator)
    throws RemoteException {
    try {
	    setTestField(this.toString());
	    //Thread.currentThread().wait(30000);
        int owner = 0;
        OrganizationAccessBean org = new OrganizationAccessBean();
        java.util.Enumeration enum = org.findOurOrganizations();
        while (enum.hasMoreElements()) {
            org = (OrganizationAccessBean) enum.nextElement();
            owner = org.getOrganization();
            com.hps.july.commonbean.KeyGeneratorAccessBean keygen =
                new KeyGeneratorAccessBean();
            int key = keygen.getNextKey(TablesRef.PIE_QUERY);
            PIEQueryAccessBean bean = new PIEQueryAccessBean(key,
            /*type_query*/ paramIdBank == null
            || paramIdBank.intValue() == 0 ? REQUESTTYPES.IBANK1 : REQUESTTYPES.IBANK2,
            /*operation*/ OPERATIONTYPES.INF,
            /*status*/"D",
            /*status_op*/"1",
            /*vdat*/new java.sql.Timestamp(System.currentTimeMillis()));
            bean.commitCopyHelper();

            if (!(paramIdBank == null || paramIdBank.intValue() == 0)) {
                /*idObjNRIInt*/bean.setIdobjnriint(paramIdBank);
                /*TypeObjNri*/bean.setTypeobjnri(NRIOBJECTTYPES.PART);
            }
            /*
                        bean.setDatebeg(
                            paramDateStart == null
                                ? new java.sql.Timestamp(System.currentTimeMillis())
                                : paramDateStart);
            */
            /*voper*/bean.setVoper(operator);
            /*owner*/bean.setOwner(new Integer(owner));
            bean.commitCopyHelper();
            getTestField();
        }
    } catch (Exception e) {
        Util_Alex.pr(e, "makeQueryGetPaymentsFromPlatinum", this);
        throw new RemoteException("", e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 13:35:17)
 * @return boolean
 * @param paramDateStart java.sql.Date
 * @param paramIdDogovor int
 */
public void makeQueryGetPaymentsFromPlatinum(
    java.sql.Timestamp paramDateStart,
    Integer paramIdDogovor,
    Integer operator)
    throws RemoteException {
    try {
        int owner = 0;
        OrganizationAccessBean org = new OrganizationAccessBean();
        java.util.Enumeration enum = org.findOurOrganizations();
        while (enum.hasMoreElements()) {
            org = (OrganizationAccessBean) enum.nextElement();
            owner = org.getOrganization();
            com.hps.july.commonbean.KeyGeneratorAccessBean keygen =
                new KeyGeneratorAccessBean();
            int key = keygen.getNextKey(TablesRef.PIE_QUERY);
            PIEQueryAccessBean bean =
                new PIEQueryAccessBean(
                    key,
                    paramIdDogovor == null
                        || paramIdDogovor.intValue() == 0 ? REQUESTTYPES.IPAY1 : REQUESTTYPES.IPAY2,
                    OPERATIONTYPES.INF,
                    "D",
                    "1",
                    new java.sql.Timestamp(System.currentTimeMillis()));
            bean.commitCopyHelper();
            //bean.setTypequery(REQUESTTYPES.IPAY);
            if (!(paramIdDogovor == null || paramIdDogovor.intValue() == 0)) {
                bean.setIdobjnriint(paramIdDogovor);
                bean.setTypeobjnri(NRIOBJECTTYPES.LEASEDOGOV);
            }

            bean.setDatebeg(
                paramDateStart == null
                    ? new java.sql.Timestamp(System.currentTimeMillis())
                    : paramDateStart);
            bean.setVoper(operator);
            bean.setOwner(new Integer(owner));
            bean.commitCopyHelper();
        }
    } catch (Exception e) {
        Util_Alex.pr(e, "makeQueryGetPaymentsFromPlatinum", this);
        throw new RemoteException("",e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 13:35:17)
 * @return boolean
 * @param paramDateStart java.sql.Date
 * @param paramIdDogovor int
 */
public void makeQueryGetSimpleSprav(Integer operator) throws RemoteException {

    com.hps.july.commonbean.KeyGeneratorAccessBean keygen =
        new KeyGeneratorAccessBean();
    String[] arr =
        {
            REQUESTTYPES.IBUD,
            REQUESTTYPES.IZATR,
            REQUESTTYPES.IZPOD,
            REQUESTTYPES.IPROJ,
            REQUESTTYPES.ITDIR };
    try {

        OrganizationAccessBeanTable table = new OrganizationAccessBeanTable();
        table.setOrganizationAccessBean(
            new OrganizationAccessBean().findOurOrganizations());

        for (int i = 0; i < table.numberOfRows(); i++) {

            for (int j = 0; j < arr.length; j++) {

                int key = keygen.getNextKey(TablesRef.PIE_QUERY);
                PIEQueryAccessBean bean =
                    new PIEQueryAccessBean(
                        key,
                        arr[j],
                        OPERATIONTYPES.INF,
                        "D",
                        "1",
                        new java.sql.Timestamp(System.currentTimeMillis()));
                bean.commitCopyHelper();

                bean.setVoper(operator);
                bean.setOwner(
                    new Integer(table.getOrganizationAccessBean(i).getOrganization()));
                bean.commitCopyHelper();
            }
        }
    } catch (Exception e) {
        Util_Alex.pr(e, "makeQueryGetPaymentsFromPlatinum", this);
        throw new RemoteException("",e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 13:35:17)
 * @return boolean
 * @param paramDateStart java.sql.Date
 * @param paramIdDogovor int
 */
public void makeQueryMoveAccountInPlatinum(
    String paramTypeAction,
    Integer paramAccount,
    Integer operator)
    throws RemoteException {

    com.hps.july.commonbean.KeyGeneratorAccessBean keygen =
        new KeyGeneratorAccessBean();
    String operation = null;
    if (paramTypeAction.equals("I"))
        operation = OPERATIONTYPES.INSERT;
    else
        if (paramTypeAction.equals("U"))
            operation = OPERATIONTYPES.UPDATE;
        else
            if (paramTypeAction.equals("D"))
                operation = OPERATIONTYPES.DELETE;
            else
                throw new RemoteException("illegal parameter N1 in makeQueryMoveAccountInPlatinum");
    try {

        OrganizationAccessBeanTable table = new OrganizationAccessBeanTable();
        table.setOrganizationAccessBean(
            new OrganizationAccessBean().findOurOrganizations());

        for (int i = 0; i < table.numberOfRows(); i++) {

            int key = keygen.getNextKey(TablesRef.PIE_QUERY);
            PIEQueryAccessBean bean =
                new PIEQueryAccessBean(
                    key,
                    REQUESTTYPES.A_SCHET,
                    operation,
                    "D",
                    "1",
                    new java.sql.Timestamp(System.currentTimeMillis()));
            bean.commitCopyHelper();

            bean.setIdobjnriint(paramAccount);
            bean.setTypeobjnri(NRIOBJECTTYPES.ACCOUNT);

            bean.setVoper(operator);
            bean.setOwner(
                new Integer(table.getOrganizationAccessBean(i).getOrganization()));
            bean.commitCopyHelper();

        }
    } catch (Exception e) {
        Util_Alex.pr(e, "makeQueryGetPaymentsFromPlatinum", this);
        throw new RemoteException("",e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (14.01.2003 13:35:17)
 * @return boolean
 * @param paramDateStart java.sql.Date
 * @param paramIdDogovor int
 */
public void makeQueryMovePartnerInPlatinum(
    String paramTypeAction,
    Integer paramPartner,
    Integer operator)
    throws RemoteException {

    com.hps.july.commonbean.KeyGeneratorAccessBean keygen =
        new KeyGeneratorAccessBean();
    String operation = null;
    if (paramTypeAction.equals("I"))
        operation = OPERATIONTYPES.INSERT;
    else
        if (paramTypeAction.equals("U"))
            operation = OPERATIONTYPES.UPDATE;
        else
            if (paramTypeAction.equals("D"))
                operation = OPERATIONTYPES.DELETE;
            else
                throw new RemoteException("illegal parameter N1 in makeQueryMoveAccountInPlatinum");
    try {

        OrganizationAccessBeanTable table = new OrganizationAccessBeanTable();
        table.setOrganizationAccessBean(
            new OrganizationAccessBean().findOurOrganizations());

        for (int i = 0; i < table.numberOfRows(); i++) {

            int key = keygen.getNextKey(TablesRef.PIE_QUERY);
            PIEQueryAccessBean bean =
                new PIEQueryAccessBean(
                    key,
                    REQUESTTYPES.A_PARTNER,
                    operation,
                    "D",
                    "1",
                    new java.sql.Timestamp(System.currentTimeMillis()));
            bean.commitCopyHelper();

            bean.setIdobjnriint(paramPartner);
            bean.setTypeobjnri(NRIOBJECTTYPES.PART);

            bean.setVoper(operator);
            bean.setOwner(
                new Integer(table.getOrganizationAccessBean(i).getOrganization()));
            bean.commitCopyHelper();

        }
    } catch (Exception e) {
        Util_Alex.pr(e, "makeQueryGetPaymentsFromPlatinum", this);
        throw new RemoteException("",e);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (23.01.2003 11:41:45)
 */
public void moveAllPaymentsPlatinum2Nri(int paramOperator) throws Exception {
    javax.transaction.UserTransaction tr = getSessionContext().getUserTransaction();

    try {
        new MoveAllPaymentsPlatinum2NriImpl(getSessionContext()).process(paramOperator);
    } catch (Exception e) {
        throw new RemoteException("from " + this.getClass().getName(), e);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:47:44)
 */
public void moveBanksPlatinumToNri(int operatorId) throws Exception {

    try {
        new MoveBanksPlatinumToNriImpl(getSessionContext()).process(operatorId);
    } catch (Exception e) {
        throw new RemoteException("from " + this.getClass().getName(), e);
    }
}
public void moveDogovorNriToPlatinum(
    int paramOperator,
    Integer idDogovor,
    String stateFrom,
    String stateTo)
    throws
        javax.naming.NamingException,
        javax.ejb.CreateException,
        java.rmi.RemoteException,
        java.lang.Exception {
    try {
        new MoveDogovorNriToPlatinumImpl(getSessionContext()).process(
            paramOperator,
            idDogovor,
            stateFrom,
            stateTo);
    } catch (Exception e) {
        throw new RemoteException("from " + this.getClass().getName(), e);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 10:47:44)
 */
public void movePaymentNriToPlatinum(
    int operatorId,
    String typeAction,
    Integer idPaiment,
    String stateFrom,
    String stateTo)
    throws Exception {
    try {
        new MovePaymentNriToPlatinumImpl(getSessionContext()).process(
            operatorId,
            typeAction,
            idPaiment,
            stateFrom,
            stateTo);
    } catch (Exception e) {
        throw new RemoteException("from " + this.getClass().getName(), e);
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
/**
 * Insert the method's description here.
 * Creation date: (31.01.2003 20:29:32)
 * @param newTestField int
 */
private void setTestField(String newTestField) {
    testField = newTestField;
    System.out.println("setTestString: this=" + this +" testField=" + testField);
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 12:56:42)
 */
public void test(int i) {
 /*   
	testField = i;
    System.out.println(
        this +"started i=" + i + new java.sql.Timestamp(System.currentTimeMillis()));
    try {
        Thread.currentThread().wait(30000);
    } catch (InterruptedException e) {
    }
    System.out.println(
        this +"ended i=" + i + new java.sql.Timestamp(System.currentTimeMillis()));
*/
        }
}
