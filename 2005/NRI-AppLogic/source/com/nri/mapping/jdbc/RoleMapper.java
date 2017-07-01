/*
 * Created on 24.07.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nri.mapping.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nri.domain.NriObject;
import com.nri.domain.Role;
import com.nri.exception.DuplicateKeyException;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchRoleException;
import com.nri.util.ApplProperties;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RoleMapper extends JDBCMapper implements com.nri.mapping.RoleMapper {
	protected static final String findByNameSqlString =
		"SELECT role, roleName, comment, sortorder, taskcomment FROM " + ApplProperties.getDatasourceSchema() + ".roles WHERE LOWER(roleName) matches LOWER(?)";

	/**
	 * 
	 */
	public RoleMapper() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.jdbc.JDBCMapper#createImpl(java.sql.Connection, com.nri.domain.NriObject)
	 */
	protected Object createImpl(Connection conn, NriObject domainObject) throws SQLException, MappingException {
		throw new MappingException("createImpl not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.jdbc.JDBCMapper#findByPrimaryKeyImpl(java.sql.Connection, com.nri.domain.NriObject)
	 */
	protected NriObject findByPrimaryKeyImpl(Connection conn, NriObject domainObjectWithKeyValues) throws SQLException, MappingException {
		throw new MappingException("findByPrimaryKeyImpl not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.jdbc.JDBCMapper#removeImpl(java.sql.Connection, com.nri.domain.NriObject)
	 */
	protected void removeImpl(Connection conn, NriObject domainObject) throws SQLException, MappingException {
		throw new MappingException("removeImpl not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.jdbc.JDBCMapper#updateImpl(java.sql.Connection, com.nri.domain.NriObject)
	 */
	protected void updateImpl(Connection conn, NriObject anObject) throws SQLException, MappingException {
		throw new MappingException("updateImpl not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.RoleMapper#findById(java.lang.String)
	 */
	public Role findById(String roleId) throws NoSuchRoleException {
		throw new NoSuchRoleException("findById not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.Mapper#insert(com.nri.domain.NriObject)
	 */
	public void insert(NriObject anObject) throws DuplicateKeyException, MappingException {
		throw new MappingException("insert not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.Mapper#findAll()
	 */
	public ArrayList findAll() throws MappingException {
		throw new MappingException("findAll not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.RoleMapper#findByName(java.lang.String)
	 */
	public ArrayList findByName(String roleName) throws MappingException {
		throw new MappingException("findByName not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.RoleMapper#findByName(java.lang.String, java.lang.String)
	 */
	public ArrayList findByName(String roleName, String orderBy) throws MappingException {
		ArrayList list = new ArrayList();
		Role role = null;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = null;
			if (orderBy != null && !orderBy.equals("")) {
				ps = conn.prepareStatement(findByNameSqlString + " order by " + orderBy);
			} else {
				ps = conn.prepareStatement(findByNameSqlString);
			}
			ps.setString(1, roleName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				role = activate(rs);
				list.add(role);
			}
			return list;
		} catch (SQLException se) {
			se.printStackTrace(System.out);
			throw new MappingException(se, "SQLException findByName code=" + se.getErrorCode());
		} finally {
			close(conn);
		}
	}

	protected Role activate(ResultSet rs) throws SQLException {
		Role people = new Role(rs.getString(1).trim());
		people.setRoleName(rs.getString(2).trim());
		people.setComment((rs.getString(3) != null) ? rs.getString(3).trim() : "");
		people.setSortOrder((Integer) rs.getObject(4));
		people.setTaskComment((rs.getString(5) != null) ? rs.getString(5).trim() : "");
		return people;
	}

}
