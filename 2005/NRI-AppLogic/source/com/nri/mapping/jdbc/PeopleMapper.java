/*
 * Created on 18.07.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nri.mapping.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nri.domain.NriObject;
import com.nri.domain.People;
import com.nri.exception.DuplicateKeyException;
import com.nri.exception.MappingException;
import com.nri.util.ApplProperties;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PeopleMapper extends JDBCMapper implements com.nri.mapping.PeopleMapper {
	protected static final String _createString =
		"INSERT INTO "
			+ ApplProperties.getDatasourceSchema()
			+ ".PEOPLE (man, firstname, lastname, middlename, passportser, passportdate, passportwhom, isactive, tabnum) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	protected static final String _removeString = "DELETE FROM " + ApplProperties.getDatasourceSchema() + ".PEOPLE  WHERE man = ?";
	protected static final String _storeString =
		"UPDATE "
			+ ApplProperties.getDatasourceSchema()
			+ ".PEOPLE  SET firstname = ?, lastname = ?, middlename = ?, passportser = ?, passportdate = ?, passportwhom = ?, isactive = ?, tabnum = ? WHERE man = ?";
	protected static final String _loadString =
		"SELECT man, firstname, lastname, middlename, passportser, passportdate, passportwhom, isactive, tabnum FROM " + ApplProperties.getDatasourceSchema() + ".PEOPLE WHERE man = ?";
	protected static final String _loadForUpdateString = _loadString + " FOR UPDATE";
	protected static final String findByNameSqlString =
		"SELECT man, firstname, lastname, middlename, passportser, passportdate, passportwhom, isactive, tabnum FROM " + ApplProperties.getDatasourceSchema() + ".PEOPLE WHERE LOWER(lastname) matches LOWER(?)";
	protected static final String findAllSqlString =
		"SELECT man, firstname, lastname, middlename, passportser, passportdate, passportwhom, isactive, tabnum FROM " + ApplProperties.getDatasourceSchema() + ".PEOPLE";

	/**
	 * Constructor for PeopleMapper
	 */
	public PeopleMapper() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.jdbc.JDBCMapper#createImpl(java.sql.Connection, com.nri.domain.NriObject)
	 */
	protected Object createImpl(Connection conn, NriObject domainObject) throws SQLException, MappingException {
		Integer man = null;
		String firstName = null;
		String lastName = null;
		String middleName = null;
		String passportSer = null;
		Date passportDate = null;
		String passportWhom = null;
		Boolean isActive = null;
		Integer tabNum = null;
		if (domainObject instanceof People) {
			man = ((People) domainObject).getMan();
			firstName = ((People) domainObject).getFirstName();
			lastName = ((People) domainObject).getLastName();
			middleName = ((People) domainObject).getMiddleName();
			passportSer = ((People) domainObject).getPassportSer();
			passportDate = ((People) domainObject).getPassportDate();
			passportWhom = ((People) domainObject).getPassportWhom();
			isActive = ((People) domainObject).getIsActive();
			tabNum = ((People) domainObject).getTabNum();
		} else {
			// update fails
			throw new DuplicateKeyException("Create Failed " + domainObject);
		}
		PreparedStatement ps = conn.prepareStatement(_createString);
		ps.setObject(1, man);
		ps.setObject(2, firstName);
		ps.setObject(3, lastName);
		ps.setObject(4, middleName);
		ps.setObject(5, passportSer);
		ps.setObject(6, passportDate);
		ps.setObject(7, passportWhom);
		ps.setObject(8, (Boolean.TRUE.equals(isActive)) ? "Y" : "N");
		ps.setObject(9, tabNum);

		int rows = ps.executeUpdate();
		if (rows == 1)
			return domainObject;
		else
			// failed
			throw new DuplicateKeyException("Create Failed " + domainObject);
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.jdbc.JDBCMapper#findByPrimaryKeyImpl(java.sql.Connection, com.nri.domain.NriObject)
	 */
	protected NriObject findByPrimaryKeyImpl(Connection conn, NriObject domainObjectWithKeyValues) throws SQLException, MappingException {
		People people = null;
		Integer peopleId = null;
		if (domainObjectWithKeyValues instanceof People) {
			peopleId = ((People) domainObjectWithKeyValues).getMan();
		} else
			return null;
		PreparedStatement ps = conn.prepareStatement(_loadString);
		ps.setObject(1, peopleId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		people = activate(rs);
		return people;
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.jdbc.JDBCMapper#removeImpl(java.sql.Connection, com.nri.domain.NriObject)
	 */
	protected void removeImpl(Connection conn, NriObject domainObject) throws SQLException, MappingException {
		Integer aId = null;
		if (domainObject instanceof People) {
			aId = ((People) domainObject).getMan();
		} else
			throw new MappingException("Removed Failed" + domainObject);
		PreparedStatement ps = conn.prepareStatement(_removeString);
		ps.setObject(1, aId);
		int rows = ps.executeUpdate();
		if (rows == 1)
			return;
		else
			// failed
			throw new MappingException("Remove Failed " + domainObject);

	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.jdbc.JDBCMapper#updateImpl(java.sql.Connection, com.nri.domain.NriObject)
	 */
	protected void updateImpl(Connection conn, NriObject domainObject) throws SQLException, MappingException {
		Integer man = null;
		String firstName = null;
		String lastName = null;
		String middleName = null;
		String passportSer = null;
		Date passportDate = null;
		String passportWhom = null;
		Boolean isActive = null;
		Integer tabNum = null;
		if (domainObject instanceof People) {
			man = ((People) domainObject).getMan();
			firstName = ((People) domainObject).getFirstName();
			lastName = ((People) domainObject).getLastName();
			middleName = ((People) domainObject).getMiddleName();
			passportSer = ((People) domainObject).getPassportSer();
			passportDate = ((People) domainObject).getPassportDate();
			passportWhom = ((People) domainObject).getPassportWhom();
			isActive = ((People) domainObject).getIsActive();
			tabNum = ((People) domainObject).getTabNum();
		} else {
			// update fails
			throw new MappingException("Update Failed " + domainObject);
		}
		PreparedStatement ps = conn.prepareStatement(_storeString);
		ps.setObject(1, firstName);
		ps.setObject(2, lastName);
		ps.setObject(3, middleName);
		ps.setObject(4, passportSer);
		ps.setObject(5, passportDate);
		ps.setObject(6, passportWhom);
		ps.setObject(7, (Boolean.TRUE.equals(isActive)) ? "Y" : "N");
		ps.setObject(8, tabNum);
		ps.setObject(9, man);
		int rows = ps.executeUpdate();
		if (rows == 1)
			return;
		else
			// failed
			throw new MappingException("Update Failed " + domainObject);
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.PeopleMapper#findByMan(java.lang.Integer)
	 */
	public People findByMan(Integer man) throws MappingException {
		Connection conn = null;
		try {
			conn = getConnection();
			return findById(conn, man);
		} catch (SQLException se) {
			return null;
		} finally {
			close(conn);
		}
	}

	public People findById(Connection conn, Integer manId) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(_loadString);
		ps.setObject(1, manId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return activate(rs);
	}

	protected People activate(ResultSet rs) throws SQLException {
		People people = new People((Integer) rs.getObject(1));
		people.setFirstName(rs.getString(2));
		people.setLastName(rs.getString(3));
		people.setMiddleName(rs.getString(4));
		people.setPassportSer(rs.getString(5));
		people.setPassportDate(rs.getDate(6));
		people.setPassportWhom(rs.getString(7));
		people.setIsActive(("Y".equals(rs.getString(8)) ? Boolean.TRUE : Boolean.FALSE));
		people.setTabNum((Integer) rs.getObject(9));
		return people;
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.Mapper#insert(com.nri.domain.NriObject)
	 */
	public void insert(NriObject anObject) throws DuplicateKeyException, MappingException {
		Connection conn = null;
		try {
			conn = getConnection();
			createImpl(conn, anObject);
			return;
		} catch (SQLException se) {
			throw new DuplicateKeyException(se, ("Insert Failed " + anObject));
		} finally {
			close(conn);
		}
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.Mapper#findAll()
	 */
	public ArrayList findAll() throws MappingException {
		ArrayList list = new ArrayList();
		People people = null;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(findAllSqlString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				people = activate(rs);
				list.add(people);
			}
			return list;
		} catch (SQLException se) {
			return null;
		} finally {
			close(conn);
		}
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.PeopleMapper#findByName(java.lang.String)
	 */
	public ArrayList findByName(String name) throws MappingException {
		ArrayList list = new ArrayList();
		People people = null;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(findByNameSqlString);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				people = activate(rs);
				list.add(people);
			}
			return list;
		} catch (SQLException se) {
			se.printStackTrace(System.out);
			throw new MappingException(se, "SQLException findByName code=" + se.getErrorCode());
		} finally {
			close(conn);
		}
	}

}
