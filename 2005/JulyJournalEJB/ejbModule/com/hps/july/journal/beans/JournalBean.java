package com.hps.july.journal.beans;

import java.rmi.RemoteException;
import java.security.Identity;
import java.sql.*;
import java.util.Properties;
import javax.ejb.*;
import javax.naming.*;
import javax.sql.*;
import com.hps.july.jdbcpersistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
/**
 * This is a Session Bean Class
 * Журналирование изменения данных
 */
public class JournalBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
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
private Connection getConnection() throws Exception {

	Properties prp = new EnvironmentAccessBean().getEnvironmentProperties();

	String dsName = prp.getProperty("DATASOURCE_NAME_XA");
	String factoryClass = prp.getProperty( "FACTORY_CLASS" );
	
	javax.naming.InitialContext ctx = null;
	Properties prop = new Properties();
	prop.put( javax.naming.Context.PROVIDER_URL, "iiop://" );
	prop.put( javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass );
	ctx = new javax.naming.InitialContext( prop );
	javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup( dsName );
	//Context ctx = new InitialContext();
	//javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup( "july" );
	
	return ds.getConnection();
}
private int getOperator(String name, int equip)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {
	//try{
		int operator = 0;
		String operatorName = ((EJBContext)mySessionCtx).getCallerIdentity().getName();
		int index = operatorName.indexOf("/");
		if(index != -1)
			operatorName = operatorName.substring(index+1);
			operator = new OperatorAccessBean().findByLogin(operatorName).getOperator();
		if(operator == 0) {
			pr("Не найден оператор при удалении "+name+" № "+equip);
			throw new RemoteException();
		}
		return operator;
	//}catch(Exception e){
		//throw (RemoteException)e;
	//}
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
void pr(Exception ex, String str) {

        System.out.println("_________________________________________________");
        System.out.println(new java.util.Date());
        if (ex != null)
            System.out.println(ex.getClass().getName() + " in " + this.getClass().getName()
                    + "." + str + ". Message is:" + ex.getMessage());
        else
            System.out.println(this.getClass().getName() + "." + str);
        System.out.println("_________________________________________________");
}
void pr(String str) {
	pr(null, str);
}
private void processEx(Exception e)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	if(e instanceof java.rmi.ServerException){
		pr("Throw ServerException");
		if(((java.rmi.ServerException)e).detail instanceof java.rmi.ServerException)
			throw (java.rmi.ServerException)(((java.rmi.ServerException)e).detail);
		else
			System.out.println("Exception type="+(((java.rmi.ServerException)e).detail).getClass().getName());
	}
	if(e instanceof RemoteException){
		pr("throw RemoteException");
		throw (RemoteException)e;
	}
	if(e instanceof RemoveException){
		pr("Throw RemoveException");
		throw (RemoveException)e;
	}	
	if(e instanceof CreateException){
		pr("Throw CreateException");
		throw (CreateException)e;
	}
	if(e instanceof FinderException){
		pr("Throw FinderException");
		throw (FinderException)e;
	}
	if(e instanceof javax.naming.NamingException ){
		pr("Thow javax.naming.NamingException ");
		throw (javax.naming.NamingException )e;
	} else
		System.out.println("Exception type="+e.getClass().getName());
}
public boolean removeAntenna(int idAntenna)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {
	Connection con = null;
	PreparedStatement ps = null;
	AntennaAccessBean ab = null;
	//try{
		ab = new AntennaAccessBean();
		ab.setInitKey_idanten(idAntenna);
		ab.refreshCopyHelper();
	//}catch(Exception e){
		//pr("Не найдена антенна № "+idAntenna+" для удаления");
		//processEx(e);
	//}

	try{
		int operator = getOperator("антенны", idAntenna);
		//int operator = 1;
			
		String sql = "execute procedure antenna_proc("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?)";
		
		con = getConnection();
		ps = con.prepareStatement(sql);

		ps.setInt(1, ab.getIdanten());
		
		if(ab.getResourceKey() != null)
			ps.setInt(2, ab.getResourceKey().resource);
		else ps.setNull(2, Types.INTEGER);
		
		ps.setString(3, ab.getNumant());
		ps.setString(4, ab.getKindant());
		ps.setBigDecimal(5, ab.getNakl());
		ps.setBigDecimal(6, ab.getAzant());
		ps.setBigDecimal(7, ab.getKswn());
		ps.setBigDecimal(8, ab.getHset1());
		ps.setBigDecimal(9, ab.getLencable());
		
		if(ab.getCableresKey() != null)
			ps.setInt(10, ab.getCableresKey().resource);
		else setInt(ps, 10, null);
		if(ab.getEquipmentKey() != null)
			ps.setInt(11, ab.getEquipmentKey().storageplace);
		else ps.setNull(11, Types.INTEGER);
		
		ps.setString(12, ab.getAzvariation());
		ps.setString(13, ab.getNaklvariation());
		ps.setBigDecimal(14, ab.getInputpower());

		if(ab.getGroundresourceKey() != null)
			ps.setInt(15, ab.getGroundresourceKey().resource);
		else
			ps.setNull(15, Types.INTEGER);
		//setInt(ps, 15, ab.getGroundresource());
		
		setInt(ps, 16, ab.getGroundcnt());
		ps.setString(17, ab.getLocationtype());

		ps.setNull(18, Types.INTEGER);
		ps.setNull(19, Types.INTEGER);
		ps.setNull(20, Types.CHAR);
		ps.setNull(21, Types.CHAR);
		ps.setNull(22, Types.DECIMAL);
		ps.setNull(23, Types.DECIMAL);
		ps.setNull(24, Types.DECIMAL);
		ps.setNull(25, Types.DECIMAL);
		ps.setNull(26, Types.DECIMAL);
		ps.setNull(27, Types.INTEGER);
		ps.setNull(28, Types.INTEGER);
		ps.setNull(29, Types.CHAR);
		ps.setNull(30, Types.CHAR);
		ps.setNull(31, Types.DECIMAL);
		ps.setNull(32, Types.INTEGER);
		ps.setNull(33, Types.INTEGER);
		ps.setNull(34, Types.CHAR);

		ps.setInt(35, 3);
		ps.setInt(36, 3);
		ps.setInt(37, operator);

		ps.executeUpdate();
		
	}catch(Exception e){
		pr("Запись журнала для удаления антенны № "+idAntenna+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
		try{if(con != null) con.close();}catch(Exception e){}
	}

	//try{
		ab.getEJBRef().remove();
		return true;	
	//}catch(Exception e){
		//pr("Удаление антенны № "+idAntenna+" не произошло");
		//processEx(e);
	//}
	//return false;	
}
public boolean removeBasestation(int idBasestation)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	Connection con = null;
	PreparedStatement ps = null;
	BaseStationAccessBean ab = null;
	//try{
		ab = new BaseStationAccessBean();
		ab.setInitKey_storageplace(idBasestation);
		ab.refreshCopyHelper();
	//}catch(Exception e){
		//pr("Не найдена базовая станция № "+idBasestation+" для удаления");
		//processEx(e);
	//}

	try{
		int operator = getOperator("базовой станции", idBasestation);
		//int operator = 1;
		con = getConnection();
		
		if(!removeEquipment(idBasestation, "B", con, operator))
			throw new Exception();
			
		String sql = "execute procedure basestation_proc("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		ps = con.prepareStatement(sql);

	   ps.setInt(1, ab.getStorageplace());
	   
	   if(ab.getControllerKey() != null)
		   ps.setInt(2, ab.getControllerKey().storageplace);
	   else ps.setNull(2, Types.INTEGER);
	   if(ab.getSwitchKey() != null)
		   ps.setInt(3, ab.getSwitchKey().storageplace);
	   else ps.setNull(3, Types.INTEGER);
	   
	   ps.setString(4, ab.getStationType());
	   //ps.setString(5, byBoolean(ab.getRepeater()));
	   setBoolean(ps, 5, ab.getRepeater());
	   ps.setInt(6, ab.getNumber());
	   ps.setString(7, ab.getName());
	   //ps.setShort(8, ab.getNstoek().shortValue());
	   setShort(ps, 8, ab.getNstoek());
	   ps.setString(9, ab.getSttransp());
	   ps.setString(10, ab.getTimebackup());
	   ps.setDate(11, ab.getDateassembafs());
	   ps.setDate(12, ab.getDateassembafs2());
	   ps.setDate(13, ab.getDateconnect());
	   ps.setDate(14, ab.getDateconnect2());
	   ps.setDate(15, ab.getDateonair());
	   ps.setDate(16, ab.getDateonair2());
	   //ps.setShort(17, ab.getNetstage().shortValue());
	   setShort(ps, 17, ab.getNetstage());
	   ps.setString(18, ab.getContype());
	   //ps.setShort(19, ab.getE1qty().shortValue());
	   setShort(ps, 19, ab.getE1qty());
	   //ps.setString(20, byBoolean(ab.getOnair()));
	   setBoolean(ps, 20, ab.getOnair());
	   ps.setDate(21, ab.getDatebldbeg2());
	   ps.setDate(22, ab.getDateassemb2());
	   ps.setDate(23, ab.getDatetest2());
	   ps.setDate(24, ab.getDatepr2());
	   ps.setObject(25, ab.getPrefixcellid());

	   ps.setNull(26, Types.INTEGER);
	   ps.setNull(27, Types.INTEGER);
	   ps.setNull(28, Types.INTEGER);
	   ps.setNull(29, Types.CHAR);
	   ps.setNull(30, Types.CHAR);
	   ps.setNull(31, Types.INTEGER);
	   ps.setNull(32, Types.CHAR);
	   ps.setNull(33, Types.SMALLINT);
	   ps.setNull(34, Types.CHAR);
	   ps.setNull(35, Types.CHAR);
	   ps.setNull(36, Types.DATE);
	   ps.setNull(37, Types.DATE);
	   ps.setNull(38, Types.DATE);
	   ps.setNull(39, Types.DATE);
	   ps.setNull(40, Types.DATE);
	   ps.setNull(41, Types.DATE);
	   ps.setNull(42, Types.SMALLINT);
	   ps.setNull(43, Types.CHAR);
	   ps.setNull(44, Types.SMALLINT);
	   ps.setNull(45, Types.CHAR);
	   ps.setNull(46, Types.DATE);
	   ps.setNull(47, Types.DATE);
	   ps.setNull(48, Types.DATE);
	   ps.setNull(49, Types.DATE);
	   ps.setNull(50, Types.INTEGER);
   
		ps.executeUpdate();
		
	}catch(Exception e){
		pr("Запись журнала для базовой станции № "+idBasestation+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
		try{if(con != null) con.close();}catch(Exception e){}
	}
	//try{
		ab.getEJBRef().remove();
		return true;
	//}catch(Exception e){
		//processEx(e);
	//}
	//return false;
}
private boolean removeEquipment(int idStorageplace, String type, Connection con, int operator)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	if(!removeStorageplace(idStorageplace, type, con, operator))
		return false;
	
	PreparedStatement ps = null;
	EquipmentSetAccessBean ab = null;
	//try{
		ab = new EquipmentSetAccessBean();
		ab.setInitKey_storageplace(idStorageplace);
		ab.refreshCopyHelper();
	//}catch(Exception e){
		//pr("В equipment не найден idEquipment  № "+idStorageplace+" для удаления");
		//processEx(e);
	//}

	try{
		String sql = "execute procedure equipment_proc("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?)";
		ps = con.prepareStatement(sql);

		ps.setInt(1, ab.getStorageplace());
		
		if(ab.getPositionKey() != null)
			ps.setInt(2, ab.getPositionKey().storageplace);
		else ps.setNull(2, Types.INTEGER);
		
		ps.setString(3, ab.getEquipmentState());
		ps.setBigDecimal(4, ab.getPwrval());
		ps.setString(5, ab.getPwrcat());
		//ps.setString(6, byBoolean(ab.getPwrreserve()));
		setBoolean(ps, 6, ab.getPwrreserve());
		ps.setString(7, ab.getPwrrescat());
		ps.setDate(8, ab.getDatebldbeg());
		ps.setDate(9, ab.getDateassemb());
		ps.setDate(10, ab.getDatetest());
		ps.setDate(11, ab.getDatepr());
		ps.setString(12, ab.getEquipcomment());
			
		ps.setNull(13, Types.INTEGER);
		ps.setNull(14, Types.INTEGER);
		ps.setNull(15, Types.CHAR);
		ps.setNull(16, Types.DECIMAL);
		ps.setNull(17, Types.CHAR);
		ps.setNull(18, Types.CHAR);
		ps.setNull(19, Types.CHAR);
		ps.setNull(20, Types.DATE);
		ps.setNull(21, Types.DATE);
		ps.setNull(22, Types.DATE);
		ps.setNull(23, Types.DATE);
		ps.setNull(24, Types.VARCHAR);

		ps.executeUpdate();
		return true;
	}catch(Exception e){
		pr("Запись журнала для удаления equipment № "+idStorageplace+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );		
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
	}
	return false;
}
public boolean removeLeaseArendaAgrmnts(int idLeasedocument)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	Connection con = null;
	PreparedStatement ps = null;
	LeaseArendaAgreementNewAccessBean ab = null;
	ab = new LeaseArendaAgreementNewAccessBean();
	ab.setInitKey_leaseDocument(idLeasedocument);
	ab.refreshCopyHelper();

	try{
		int operator = getOperator("LeaseArendaAgreement", idLeasedocument);
		//int operator = 1;
		con = getConnection();
		
		if(!removeLeasecontract(idLeasedocument, "A", con, operator))
			throw new Exception();
			
		String sql = "execute procedure leaseArendaAgr("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?)";
		
		ps = con.prepareStatement(sql);

		ps.setInt(1, ab.getLeaseDocument());
		setInt(ps, 2, ab.getMainDocument());
		setBoolean(ps, 3, ab.getIsActive());
		//ps.setString(4, ab.getHowGivePhones());
		ps.setNull(4, Types.CHAR);
		setInt(ps, 5, ab.getNumberOfPhones());
		ps.setString(6, ab.getCalcElectroType());
		setBoolean(ps, 7, ab.getIsDogElectro());
		ps.setString(8, ab.getDogelectonum());
		ps.setDate(9, ab.getDogelectrodate());
   
		ps.setNull(10, Types.INTEGER);
		ps.setNull(11, Types.INTEGER);
		ps.setNull(12, Types.CHAR);
		ps.setNull(13, Types.CHAR);
		ps.setNull(14, Types.INTEGER);
		ps.setNull(15, Types.CHAR);
		ps.setNull(16, Types.CHAR);
		ps.setNull(17, Types.CHAR);
		ps.setNull(18, Types.DATE);

		ps.executeUpdate();
		
	}catch(Exception e){
		pr("Запись журнала для удаления LeaseArendaAgreement № "+idLeasedocument+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
		try{if(con != null) con.close();}catch(Exception e){}
	}
		ab.getEJBRef().remove();
		return true;
}
private boolean removeLeasecontract(int idLeasedocument, String type, Connection con, int operator)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	if(!removeLeasedocument(idLeasedocument, type, con, operator))
		return false;
	
	PreparedStatement ps = null;
	LeaseContractAccessBean ab = null;
	ab = new LeaseContractAccessBean();
	ab.setInitKey_leaseDocument(idLeasedocument);
	ab.refreshCopyHelper();
	LeaseContractBLOBAccessBean lcb = new LeaseContractBLOBAccessBean();
	lcb.setInitKey_leaseDocument(idLeasedocument);
	lcb.refreshCopyHelper();

	try{
		String sql = "execute procedure leaseContract("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?)";
		ps = con.prepareStatement(sql);

		ps.setInt(1, ab.getLeaseDocument());
		ps.setString(2, ab.getContractType());
		ps.setString(3, ab.getContractState());
		ps.setInt(4, ab.getOrgCustomerKey().organization);
		ps.setInt(5, ab.getOrgExecutorKey().organization);
		ps.setString(6, ab.getCustname());
		ps.setString(7, ab.getExecname());
		ps.setDate(8, ab.getStartDate());
		ps.setDate(9, ab.getEndDate());
		ps.setString(10, ab.getDocFileName());
		ps.setString(11, lcb.getComment());
		ps.setString(12, lcb.getSubject());
		ps.setString(13, ab.getExtendType());
		ps.setString(14, ab.getExtendPeriod());
		ps.setString(15, ab.getReportPeriod());
		if(ab.getEconomistKey() != null)
			ps.setInt(16, ab.getEconomistKey().worker);
		else
			ps.setNull(16, Types.INTEGER);
		if(ab.getCurrency1Key() != null)
			ps.setInt(17, ab.getCurrency1Key().currency);
		else
			ps.setNull(17, Types.INTEGER);
		if(ab.getCurrency2Key() != null)
			ps.setInt(18, ab.getCurrency2Key().currency);
		else
			ps.setNull(18, Types.INTEGER);
		ps.setBigDecimal(19, ab.getSumm1());
		ps.setBigDecimal(20, ab.getSumm2());
		ps.setString(21, ab.getRatecalcrule());
		setShort(ps, 22, ab.getRatecalcruleday());
		ps.setBigDecimal(23, ab.getRatedelta());

		ps.setNull(24, Types.INTEGER);
		ps.setNull(25, Types.CHAR);
		ps.setNull(26, Types.CHAR);
		ps.setNull(27, Types.INTEGER);
		ps.setNull(28, Types.INTEGER);
		ps.setNull(29, Types.CHAR);
		ps.setNull(30, Types.CHAR);
		ps.setNull(31, Types.DATE);
		ps.setNull(32, Types.DATE);
		ps.setNull(33, Types.CHAR);
		ps.setNull(34, Types.CHAR);
		ps.setNull(35, Types.CHAR);
		ps.setNull(36, Types.CHAR);
		ps.setNull(37, Types.CHAR);
		ps.setNull(38, Types.CHAR);
		ps.setNull(39, Types.INTEGER);
		ps.setNull(40, Types.INTEGER);
		ps.setNull(41, Types.INTEGER);
		ps.setNull(42, Types.DECIMAL);
		ps.setNull(43, Types.DECIMAL);
		ps.setNull(44, Types.CHAR);
		ps.setNull(45, Types.SMALLINT);
		ps.setNull(46, Types.DECIMAL);

		ps.executeUpdate();
			return true;
	}catch(Exception e){
		pr("Запись журнала для удаления LeaseContract № "+idLeasedocument+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );		
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
	}
	return false;
}
private boolean removeLeaseDocPosition(int idLeasedocposition, String type, Connection con, int operator)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	PreparedStatement ps = null;
	LeaseDocPositionAccessBean ab = null;
	ab = new LeaseDocPositionAccessBean();
	ab.setInitKey_leaseDocPosition(idLeasedocposition);
	ab.refreshCopyHelper();

	try{
		String sql = "execute procedure leaseDocPosition("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?)";
		ps = con.prepareStatement(sql);

		ps.setInt(1, ab.getLeaseDocPosition());
		ps.setString(2, type);
		ps.setDate(3, ab.getDate());
		ps.setInt(4, ab.getLeaseContractKey().leaseDocument);
		ps.setString(5, ab.getSource());
		ps.setString(6, ab.getDocposvid());
		ps.setDate(7, ab.getBegindate());
		ps.setDate(8, ab.getEnddate());
		if(ab.getActKey() != null)
			ps.setInt(9, ab.getActKey().leaseDocument);
		else
			ps.setNull(9, Types.INTEGER);
		ps.setNull(10, Types.INTEGER);//usedinact!!!
		ps.setInt(11, ab.getResourceKey().resource);
		ps.setBigDecimal(12, ab.getSumm());
		ps.setInt(13, ab.getCurrencyKey().currency);
		ps.setBigDecimal(14, ab.getSumnds());

		ps.setNull(15, Types.INTEGER);	
		ps.setNull(16, Types.CHAR);	
		ps.setNull(17, Types.DATE);	
		ps.setNull(18, Types.INTEGER);	
		ps.setNull(19, Types.CHAR);	
		ps.setNull(20, Types.CHAR);	
		ps.setNull(21, Types.DATE);	
		ps.setNull(22, Types.DATE);	
		ps.setNull(23, Types.INTEGER);	
		ps.setNull(24, Types.INTEGER);	
		ps.setNull(25, Types.INTEGER);	
		ps.setNull(26, Types.DECIMAL);	
		ps.setNull(27, Types.INTEGER);	
		ps.setNull(28, Types.DECIMAL);	

		ps.setInt(29, 11);
		ps.setInt(30, 3);
		ps.setInt(31, operator);
		ps.executeUpdate();
		return true;
	}catch(Exception e){
		pr("Запись журнала для удаления leasedocposition № "+idLeasedocposition+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );		
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
	}
	return false;
}
private boolean removeLeasedocument(int idLeasedocument, String type, Connection con, int operator)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	PreparedStatement ps = null;
	LeaseDocumentAccessBean ab = null;
	ab = new LeaseDocumentAccessBean();
	ab.setInitKey_leaseDocument(idLeasedocument);
	ab.refreshCopyHelper();

	try{
		String sql = "execute procedure leaseDocument("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?)";
		ps = con.prepareStatement(sql);

	ps.setInt(1, ab.getLeaseDocument());
	ps.setDate(2, ab.getDocumentDate());
	ps.setString(3, ab.getDocumentNumber());
	ps.setString(4, type);

	ps.setNull(5, Types.INTEGER);
	ps.setNull(6, Types.DATE);
	ps.setNull(7, Types.CHAR);
	ps.setNull(8, Types.CHAR);
		
	ps.setInt(9, 7);
	ps.setInt(10, 3);
	ps.setInt(11, operator);
	
		ps.executeUpdate();
		return true;
	}catch(Exception e){
		pr("Запись журнала для удаления LeaseDocument № "+idLeasedocument+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );		
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
	}
	return false;
}
public boolean removeLeaseMutualAct(int idLeasedocument)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	Connection con = null;
	PreparedStatement ps = null;
	LeaseMutualActNewAccessBean ab = null;
	ab = new LeaseMutualActNewAccessBean();
	ab.setInitKey_leaseDocument(idLeasedocument);
	ab.refreshCopyHelper();

	try{
		int operator = getOperator("LeaseMutualAct", idLeasedocument);
		//int operator = 1;
		con = getConnection();
		
		if(!removeLeasedocument(idLeasedocument, "M", con, operator))
			throw new Exception();
			
		String sql = "execute procedure leaseMutualAct("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?)";
		
		ps = con.prepareStatement(sql);

		ps.setInt(1, ab.getLeaseDocument());
		ps.setInt(2, ab.getLeaseMutualReglamentKey().leaseDocument);
		ps.setString(3, ab.getActState());
		ps.setDate(4, ab.getActstartdate());
		ps.setDate(5, ab.getActenddate());
		ps.setString(6, ab.getHeader());
		ps.setString(7, ab.getFooter());
		setBoolean(ps, 8, new Boolean(ab.getIstemp()));
		setBoolean(ps, 9, ab.getIsSchetFakt());

		ps.setNull(10, Types.INTEGER);
		ps.setNull(11, Types.INTEGER);
		ps.setNull(12, Types.CHAR);
		ps.setNull(13, Types.DATE);
		ps.setNull(14, Types.DATE);
		ps.setNull(15, Types.CHAR);
		ps.setNull(16, Types.CHAR);
		ps.setNull(17, Types.CHAR);
		ps.setNull(18, Types.CHAR);

		ps.executeUpdate();
		
	}catch(Exception e){
		pr("Запись журнала для удаления LeaseMutualAct № "+idLeasedocument+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
		try{if(con != null) con.close();}catch(Exception e){}
	}
		ab.getEJBRef().remove();
		return true;
}
public boolean removeLeasePayment(int idPay)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	Connection con = null;
	PreparedStatement ps = null;
	LeasePaymentAccessBean ab = null;
		ab = new LeasePaymentAccessBean();
		ab.setInitKey_leaseDocPosition(idPay);
		ab.refreshCopyHelper();

	try{
		int operator = getOperator("leasePayment", idPay);
		//int operator = 1;
		con = getConnection();
		
		if(!removeLeaseDocPosition(idPay, "P", con, operator))
			throw new Exception();
			
		String sql = "execute procedure leasePayment("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?)";
		
		ps = con.prepareStatement(sql);

	   ps.setInt(1, ab.getLeaseDocPosition());
	   ps.setString(2, ab.getDocNumber());
	   ps.setBigDecimal(3, ab.getSumRub());
	   ps.setBigDecimal(4, ab.getNdsRub());
	   if(ab.getLeaseRuleKey() != null)
		   ps.setInt(5, ab.getLeaseRuleKey().leaseRule);
	   else
		  ps.setNull(5, Types.INTEGER);	
	   ps.setString(6, ab.getPaymentType());
	   ps.setBigDecimal(7, ab.getRurremainder());
	   ps.setBigDecimal(8, ab.getPayrate());
	   ps.setString(9, ab.getPaymentstate());
	   setBoolean(ps, 10, new Boolean(ab.getByautorur()));
	   ps.setString(11, ab.getIsSchetFakt());

		ps.setNull(12, Types.INTEGER);	    
		ps.setNull(13, Types.CHAR);
		ps.setNull(14, Types.DECIMAL);
		ps.setNull(15, Types.DECIMAL);
		ps.setNull(16, Types.INTEGER);
		ps.setNull(17, Types.CHAR);
		ps.setNull(18, Types.DECIMAL);
		ps.setNull(19, Types.DECIMAL);
		ps.setNull(20, Types.CHAR);
		ps.setNull(21, Types.CHAR);
		ps.setNull(22, Types.CHAR);
   
		ps.executeUpdate();
		
	}catch(Exception e){
		pr("Запись журнала для leasePayment № "+idPay+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
		try{if(con != null) con.close();}catch(Exception e){}
	}

	ab.getEJBRef().remove();
	return true;
}
public boolean removePosition(int idPosition)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	Connection con = null;
	PreparedStatement ps = null;
	PositionAccessBean ab = null;
	//try{
		ab = new PositionAccessBean();
		ab.setInitKey_storageplace(idPosition);
		ab.refreshCopyHelper();
	//}catch(Exception e){
		//pr("Не найдена позиция № "+idPosition+" для удаления");
		//processEx(e);
	//}

	try{
		int operator = getOperator("позиции", idPosition);
		//int operator = 1;
		con = getConnection();
		
		if(!removeStorageplace(idPosition, "P", con, operator))
			throw new Exception();
			
		String sql = "execute procedure positions_proc("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		ps = con.prepareStatement(sql);

	   ps.setInt(1, ab.getStorageplace());
	  
	   if(ab.getNetZoneKey() != null)
		   ps.setInt(2, ab.getNetZoneKey().netzone);
		else ps.setNull(2, Types.INTEGER);
	   //ps.setInt(3, ab.getDcsid().intValue());
	   setInt(ps, 3, ab.getDcsid());
	   //ps.setInt(4, ab.getGsmid().intValue());
	   setInt(ps, 4, ab.getGsmid());
	   //ps.setInt(5, ab.getDampsid().intValue());
	   setInt(ps, 5, ab.getDampsid());
	   ps.setString(6, ab.getDampsname());
	   ps.setBigDecimal(7, ab.getLatitude());
	   ps.setBigDecimal(8, ab.getLongitude());
	   ps.setString(9, ab.getDetails());
	   
	   ps.setDate(10, ab.getAccesslistexp());
	   if(ab.getRenterKey() != null)
	   		ps.setInt(11, ab.getRenterKey().organization);
	   else ps.setNull(11, Types.INTEGER);
	   ps.setString(12, ab.getRentervolume());
	   //ps.setString(13, ab.getAссesslistfilename);//???????????????????????
	   ps.setNull(13, Types.CHAR);
	   
	   //ps.setString(14, byBoolean(ab.getInAction()));
	   setBoolean(ps, 14, ab.getInAction());
	  
	   if(ab.getRegionKey() != null)
		   ps.setInt(15, ab.getRegionKey().regionid);
	   else ps.setNull(15, Types.INTEGER);
	   
	   ps.setString(16, ab.getLinktogosnetlat());
	   ps.setString(17, ab.getLinktogosnetlon());
	   
	   ps.setDate(18, ab.getDatebeginbuild());
	   ps.setString(19, ab.getDognumber());
	   ps.setDate(20, ab.getDogdate());
	   ps.setBigDecimal(21, ab.getPaya());
	   ps.setBigDecimal(22, ab.getSqqty());
	   ps.setString(23, ab.getPlanstate());
	   
	   ps.setDate(24, ab.getDate_endbuild());
	   ps.setDate(25, ab.getDate_posclose());
	   ps.setObject(26, ab.getAntplaceid());
	   ps.setObject(27, ab.getOporplaceid());
	   ps.setBigDecimal(28, ab.getOporaheight());
	   ps.setDate(29, ab.getOporadate());
	   if (ab.getOporaour() == null)
	   		ps.setNull(30, Types.CHAR);
	   else if (ab.getOporaour().booleanValue())
	   		ps.setString(30, "Y");
	   else
	   		ps.setString(30, "N");
	   ps.setObject(31, ab.getAptypeid());
	   ps.setObject(32, ab.getApplacetypeid());
	   ps.setObject(33, ab.getApplaceid());
	   ps.setString(34, ab.getPosstate());
   
	   ps.setNull(35, Types.INTEGER);
	   ps.setNull(36, Types.INTEGER);
	   ps.setNull(37, Types.INTEGER);
	   ps.setNull(38, Types.INTEGER);
	   ps.setNull(39, Types.INTEGER);
	   ps.setNull(40, Types.CHAR);
	   ps.setNull(41, Types.DECIMAL);
	   ps.setNull(42, Types.DECIMAL);
	   ps.setNull(43, Types.VARCHAR);
	   
	   ps.setNull(44, Types.DATE);
	   ps.setNull(45, Types.INTEGER);
	   ps.setNull(46, Types.CHAR);
	   ps.setNull(47, Types.CHAR);
	   ps.setNull(48, Types.CHAR);
	   ps.setNull(49, Types.INTEGER);
	   ps.setNull(50, Types.CHAR);
	   ps.setNull(51, Types.CHAR);
	   
	   ps.setNull(52, Types.DATE);
	   ps.setNull(53, Types.CHAR);
	   ps.setNull(54, Types.DATE);
	   ps.setNull(55, Types.DECIMAL);
	   ps.setNull(56, Types.DECIMAL);
	   ps.setNull(57, Types.CHAR);

	   ps.setNull(58, Types.DATE);
	   ps.setNull(59, Types.DATE);
	   ps.setNull(60, Types.INTEGER);
	   ps.setNull(61, Types.INTEGER);
	   ps.setNull(62, Types.DECIMAL);
	   ps.setNull(63, Types.DATE);
	   ps.setNull(64, Types.CHAR);
	   ps.setNull(65, Types.INTEGER);
	   ps.setNull(66, Types.INTEGER);
	   ps.setNull(67, Types.INTEGER);
	   ps.setNull(68, Types.CHAR);
	   
		ps.executeUpdate();
		
	}catch(Exception e){
		pr("Запись журнала для позиции № "+idPosition+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );		
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
		try{if(con != null) con.close();}catch(Exception e){}
	}
	//try{
		ab.getEJBRef().remove();
		return true;
	//}catch(Exception e){
		//processEx(e);
	//}
	//return false;
}
public boolean removeSector(int idSector)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	Connection con = null;
	PreparedStatement ps = null;
	SectorAccessBean ab = null;
	//try{
		ab = new SectorAccessBean();
		ab.setInitKey_idsect(idSector);
		ab.refreshCopyHelper();
	//}catch(Exception e){
		//pr("Не найден сектор № "+idSector+" для удаления");
		//processEx(e);
	//}

	try{
		int operator = getOperator("сектора", idSector);
		//int operator = 1;
	
		String sql = "execute procedure sector_proc("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?)";
		con = getConnection();
		ps = con.prepareStatement(sql);

		ps.setInt(1, ab.getIdsect());
		
		if(ab.getEquipmentKey() != null)
			ps.setInt(2, ab.getEquipmentKey().storageplace);
		else ps.setInt(2, Types.INTEGER);
		
		ps.setString(3, ab.getNamesect());
		ps.setShort(4, ab.getBand());
		ps.setString(5, ab.getNumsect());
		ps.setBigDecimal(6, ab.getAzimut());
		ps.setBigDecimal(7, ab.getPower());
		ps.setString(8, ab.getBtsnumber());
		ps.setString(9, ab.getConabis());
		//ps.setInt(10, ab.getPortabis().intValue());
		setInt(ps, 10, ab.getPortabis());
		ps.setString(11, ab.getNumpo());
		//ps.setString(12, byBoolean(ab.getDdk()));
		setBoolean(ps, 12, ab.getDdk());
		//ps.setInt(13, ab.getTrxnum().intValue());
		setInt(ps, 13, ab.getTrxnum());
		ps.setBigDecimal(14, ab.getTxpwr());
		//ps.setInt(15, ab.getTrxnum2().intValue());
		setInt(ps, 15, ab.getTrxnum2());
		ps.setBigDecimal(16, ab.getTxpwr2());
		ps.setBigDecimal(17, ab.getTxsetpwr());
		//ps.setInt(18, ab.getTrxovrnum().intValue());
		setInt(ps, 18, ab.getTrxovrnum());
		ps.setBigDecimal(19, ab.getTxovrsetpwr());
		//ps.setString(20, byBoolean(ab.getHasflt()));
		setBoolean(ps, 20, ab.getHasflt());
		//ps.setString(21, byBoolean(ab.getHaslna()));
		setBoolean(ps, 21, ab.getHaslna());
		//ps.setString(22, byBoolean(ab.getHasbuster()));
		setBoolean(ps, 22, ab.getHasbuster());
		ps.setString(23, ab.getConf());
		//ps.setString(24, byBoolean(ab.getIshr()));
		setBoolean(ps, 24, ab.getIshr());
		//ps.setString(25, byBoolean(ab.getCapgprs()));
		setBoolean(ps, 25, ab.getCapgprs());
		setInt(ps, 26, ab.getLac());

		ps.setNull(27, Types.INTEGER);
		ps.setNull(28, Types.INTEGER);
		ps.setNull(29, Types.CHAR);
		ps.setNull(30, Types.SMALLINT);
		ps.setNull(31, Types.CHAR);
		ps.setNull(32, Types.DECIMAL);
		ps.setNull(33, Types.DECIMAL);
		ps.setNull(34, Types.CHAR);
		ps.setNull(35, Types.CHAR);
		ps.setNull(36, Types.INTEGER);
		ps.setNull(37, Types.CHAR);
		ps.setNull(38, Types.CHAR);
		ps.setNull(39, Types.INTEGER);
		ps.setNull(40, Types.DECIMAL);
		ps.setNull(41, Types.INTEGER);
		ps.setNull(42, Types.DECIMAL);
		ps.setNull(43, Types.DECIMAL);
		ps.setNull(44, Types.INTEGER);
		ps.setNull(45, Types.DECIMAL);
		ps.setNull(46, Types.CHAR);
		ps.setNull(47, Types.CHAR);
		ps.setNull(48, Types.CHAR);
		ps.setNull(49, Types.CHAR);
		ps.setNull(50, Types.CHAR);
		ps.setNull(51, Types.CHAR);
		ps.setNull(52, Types.INTEGER);

		ps.setInt(53, 2);
		ps.setInt(54, 3);
		ps.setInt(55, operator);
		
		ps.executeUpdate();
		
	}catch(Exception e){
		pr("Запись журнала для удаления сектора № "+idSector+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
		try{if(con != null) con.close();}catch(Exception e){}
	}
	//try{
		ab.getEJBRef().remove();
		return true;
	//}catch(Exception e){
		//pr("Удаление сектора № "+idSector+" завершилась неудачно");
		//processEx(e);
	//}
	//return false;
}
private boolean removeStorageplace(int idStorageplace, String type, Connection con, int operator)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {

	PreparedStatement ps = null;
	StoragePlaceAccessBean ab = null;
	//try{
		ab = new StoragePlaceAccessBean();
		ab.setInitKey_storageplace(idStorageplace);
		ab.refreshCopyHelper();
	//}catch(Exception e){
		//pr("Не найден idStorageplace № "+idStorageplace+" для удаления");
		//processEx(e);
	//}

	try{
		String sql = "execute procedure storageplace_proc("
			+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
			+"?, ?, ?, ?, ?)";
		ps = con.prepareStatement(sql);

		ps.setInt(1, ab.getStorageplace());
		ps.setString(2, ab.getName());
		
		if(ab.getDivisionKey() != null)
			ps.setInt(3, ab.getDivisionKey().division);
		else ps.setNull(3, Types.INTEGER);
		
		ps.setString(4, ab.getAddress());
		ps.setDate(5, ab.getClosedate());
		ps.setString(6, type);

		ps.setNull(7, Types.INTEGER);
		ps.setNull(8, Types.CHAR);
		ps.setNull(9, Types.INTEGER);
		ps.setNull(10, Types.VARCHAR);
		ps.setNull(11, Types.DATE);
		ps.setNull(12, Types.CHAR);

		ps.setInt(13, 5);
		ps.setInt(14, 3);
		ps.setInt(15, operator);
	
		ps.executeUpdate();
		return true;
	}catch(Exception e){
		pr("Запись журнала для удаления storageplace № "+idStorageplace+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );		
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
	}
	return false;
}
public boolean removeWorkresponsible(int idResponsibility, int idStorageplace, String idResptype)
throws java.rmi.RemoteException, RemoveException, java.rmi.ServerException, 
CreateException, FinderException, javax.naming.NamingException {
	Connection con = null;
	PreparedStatement ps = null;
	PositionResponsibleWorkersAccessBean ab = null;
	//try{
		ab = new PositionResponsibleWorkersAccessBean();
		ab.setInitKey_type_responsibilityType(new Integer(idResponsibility));
		ab.setInitKey_position_storageplace(new Integer(idStorageplace));
		ab.setInitKey_resptype(idResptype);
		ab.refreshCopyHelper();
	//}catch(Exception e){
		//pr("Не найдена антенна № "+idAntenna+" для удаления");
		//processEx(e);
	//}

	try{
		int operator = getOperator("ответственные", idStorageplace);
		//int operator = 1;
			
		String sql = "execute procedure wrkresp_proc("
			+"?, ?, ?, ?, ?,  "
			+"?, ?, ?, ?, ?,  "
			+"?, ?, ?)";
		
		con = getConnection();
		ps = con.prepareStatement(sql);

		if (ab.getWorkerKey() != null)
			ps.setInt(1, ab.getWorkerKey().worker);
		else
			ps.setNull(1, Types.INTEGER);

		ps.setInt(2, idResponsibility);
		ps.setInt(3, idStorageplace);
		ps.setString(4, idResptype);
		
		if(ab.getOrganizationKey() != null)
			ps.setInt(5, ab.getOrganizationKey().organization);
		else 
			ps.setNull(5, Types.INTEGER);
		
		ps.setNull(6, Types.INTEGER);
		ps.setNull(7, Types.INTEGER);
		ps.setNull(8, Types.INTEGER);
		ps.setNull(9, Types.CHAR);
		ps.setNull(10, Types.INTEGER);
		
		ps.setInt(11, 7);
		ps.setInt(12, 3);
		ps.setInt(13, operator);

		ps.executeUpdate();
		
	}catch(Exception e){
		pr("Запись журнала для удаления ответственного для поз. № "+idStorageplace+" завершилась неудачно");
		if(SQLException.class.isInstance(e))
			System.out.println( "Error code="+((SQLException)e).getErrorCode() );
		e.printStackTrace(System.out);
	} finally {
		try{if(ps != null) ps.close();}catch(Exception e){}
		try{if(con != null) con.close();}catch(Exception e){}
	}

	//try{
		ab.getEJBRef().remove();
		return true;	
	//}catch(Exception e){
		//pr("Удаление антенны № "+idAntenna+" не произошло");
		//processEx(e);
	//}
	//return false;	
}
private void setBoolean(PreparedStatement ps, int order, Boolean val)throws SQLException{
	if(val != null){
		if(val.booleanValue())
			ps.setString(order, "Y");
		else 
			ps.setString(order, "N");
	}
	else
		ps.setNull(order, Types.CHAR);
}
private void setInt(PreparedStatement ps, int order,Integer val) throws SQLException {
	if(val != null) 
		ps.setInt(order, val.intValue());
	else
		ps.setNull(order, Types.INTEGER);
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
private void setShort(PreparedStatement ps, int order,Short val) throws SQLException {
	if(val != null) 
		ps.setShort(order, val.shortValue());
	else
		ps.setNull(order, Types.SMALLINT);
}
}
