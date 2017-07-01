package com.nri.mapping.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

import com.nri.domain.NriObject;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchObjectException;
import com.nri.mapping.Mapper;
import com.nri.system.AppService;
import com.nri.system.TraceCapable;
import com.nri.util.ApplProperties;
import com.nri.util.EJBClientHelper;
/**
 * This is the abstract superclass of all DomainFactories.
 *
 * Creation date: (2/26/00 3:48:50 PM)
 * @author:ILSUser
 */
public abstract class JDBCMapper implements Mapper {

	static Properties contextProperties = new Properties();

	{
		contextProperties.put("java.naming.provider.url", "iiop:///");
		contextProperties.put("java.naming.factory.initial", "com.ibm.websphere.naming.WsnInitialContextFactory");
	}

	/**
	 * DomainFactory constructor.
	 */
	public JDBCMapper() {
		super();
	}

	/**
	 * Create a new object into the persistent store; return the
	 * primary key object
	 */
	public java.lang.Object create(NriObject domainObject) throws MappingException {
		Connection conn = null;
		try {
			// get a connection
			conn = getConnection();
			// single transaction.
			//conn.setAutoCommit(false);
			Object key = createImpl(conn, domainObject);
			//conn.commit();
			return key;
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in create()");
			throw new MappingException("Wrapped Exception " + e + " caught in create()");
		} finally {
			close(conn);
		}

	}

	/**
	 * Create a new object into the persistent store; return the
	 * primary key object
	 */
	protected java.lang.Object create(Connection conn, NriObject domainObject) throws SQLException, MappingException {
		return createImpl(conn, domainObject);
	}

	/**
	 * Create a new object into the persistent store; return the
	 * primary key object
	 */
	protected abstract java.lang.Object createImpl(Connection conn, NriObject domainObject) throws SQLException, MappingException;

	/**
	 * Return a List of all ILSDomainObject (use carefully in practice!)
	 * We use this extensively in our example, but in fact more "wise" enumerators
	 * That would directly query the datasource (e.g. through EJB finders)
	 *
	 * @return List
	 */
	public java.util.List findAllObjects() throws MappingException {
		throw new MappingException("Create not valid for this type");
	}

	/**
	 * Retrieve a single object matching this object.
	 *
	 * @return ILSDomainObject
	 */
	public NriObject findByPrimaryKey(NriObject domainObjectWithKeyValues) throws NoSuchObjectException {
		Connection conn = null;
		NriObject object = null;
		try {
			// get a connection
			conn = getConnection();
			// single transaction.
			//conn.setAutoCommit(false);
			object = findByPrimaryKeyImpl(conn, domainObjectWithKeyValues);
			//conn.commit();
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in findByPrimaryKey()");
			throw new NoSuchObjectException("Wrapped Exception " + e + " caught in findByPrimaryKey()");
		} finally {
			close(conn);
		}
		if (object == null)
			throw new NoSuchObjectException("No object found");
		return object;

	}

	/**
	 * Retrieve a single object matching this object.
	 *
	 * @return ILSDomainObject
	 */
	protected NriObject findByPrimaryKey(Connection conn, NriObject domainObjectWithKeyValues) throws SQLException, MappingException {
		return findByPrimaryKeyImpl(conn, domainObjectWithKeyValues);
	}

	/**
	 * Retrieve a single object matching this object.
	 *
	 * @return ILSDomainObject
	 */
	protected abstract NriObject findByPrimaryKeyImpl(Connection conn, NriObject domainObjectWithKeyValues) throws SQLException, MappingException;

	/**
	 * Remove the domain object from the persistent store.
	 *
	 * Creation date: (3/20/00 11:55:18 AM)
	 * @param domainObject ILSDomainObject
	 */
	public void remove(NriObject domainObject) throws NoSuchObjectException {
		Connection conn = null;
		try {
			// get a connection
			conn = getConnection();
			// single transaction.
			//conn.setAutoCommit(false);
			removeImpl(conn, domainObject);
			//conn.commit();
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in remove()");
			throw new NoSuchObjectException("Wrapped Exception " + e + " caught in remove()");
		} finally {
			close(conn);
		}

	}

	/**
	 * Remove the domain object from the persistent store.
	 *
	 * Creation date: (3/20/00 11:55:18 AM)
	 * @param domainObject ILSDomainObject
	 */
	public void remove(Connection conn, NriObject domainObject) throws SQLException, MappingException {
		removeImpl(conn, domainObject);
	}

	/**
	 * Remove the domain object from the persistent store.
	 *
	 */
	protected abstract void removeImpl(Connection conn, NriObject domainObject) throws SQLException, MappingException;

	/**
	 * Update this object (e.g. change its state in the store)
	 *
	 */
	public void update(NriObject domainObject) throws NoSuchObjectException {
		Connection conn = null;
		try {
			// get a connection
			conn = getConnection();
			// single transaction.
			//conn.setAutoCommit(false);
			updateImpl(conn, domainObject);
			//conn.commit();
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in update()");
			throw new NoSuchObjectException("Wrapped Exception " + e + " caught in update()");
		} finally {
			close(conn);
		}
	}

	/**
	 * Update this object (e.g. change its state in the store)
	 *
	 */
	protected void update(Connection conn, NriObject anObject) throws SQLException, MappingException {
		updateImpl(conn, anObject);
	}

	/**
	 * Update this object (e.g. change its state in the store)
	 *
	 */
	protected abstract void updateImpl(Connection conn, NriObject anObject) throws SQLException, MappingException;

	/**
	 * Access a Connection from the Datasource
	 * @return a managed Connection
	 */
	public static Connection getConnection() throws SQLException {
		// get a connection
		DataSource ds = getDataSource();
		return ds.getConnection();

	}

	public static void commitConnection() throws SQLException {
		// in XA transaction 
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (8/8/00 12:24:41 PM)
	 * @return javax.sql.DataSource
	 */
	public static DataSource getDataSource() {
		DataSource ds = null;
		try {
			InitialContext context = EJBClientHelper.getInitialContext();
			//javax.naming.InitialContext context = new InitialContext(contextProperties);
			ds = (DataSource) context.lookup(ApplProperties.getDatasourceJndiName());
		} catch (javax.naming.NamingException ne) {
			MappingException e = new MappingException("NamingException: cannot find DataSource in initialContext");
			AppService.handle(e);
		}
		return ds;
	}

	protected void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}

}