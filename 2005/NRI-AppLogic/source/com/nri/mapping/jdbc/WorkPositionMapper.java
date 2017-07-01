/*
 * Created on 31.07.2007
 *
 * MapperImp Должность.
 */
package com.nri.mapping.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nri.domain.NriObject;
import com.nri.domain.WorkPosition;
import com.nri.exception.DuplicateKeyException;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchWorkPositionException;
import com.nri.util.ApplProperties;

/**
 * @author IShaffigulin
 *
 * MapperImp Должность.
 */
public class WorkPositionMapper extends JDBCMapper implements com.nri.mapping.WorkPositionMapper {
	protected static final String findByNameSqlString = "SELECT workPosition, name, isActive FROM " + ApplProperties.getDatasourceSchema() + ".workPositions WHERE LOWER(name) matches LOWER(?)";

	/**
	 * 
	 */
	public WorkPositionMapper() {
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
	 * @see com.nri.mapping.WorkPositionMapper#findById(java.lang.Integer)
	 */
	public WorkPosition findById(Integer id) throws MappingException {
		throw new NoSuchWorkPositionException("findById not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.WorkPositionMapper#findByName(java.lang.String, java.lang.Boolean, java.lang.String)
	 */
	public ArrayList findByName(String name, Boolean isActive, String orderBy) throws MappingException {
		ArrayList list = new ArrayList();
		WorkPosition workPosition = null;
		Connection conn = null;
		StringBuffer sb = new StringBuffer(findByNameSqlString);
		try {
			conn = getConnection();
			PreparedStatement ps = null;
			if (isActive != null) {
				sb.append(" AND isActive = ? ");
			}
			if (orderBy != null && !orderBy.equals("")) {
				sb.append(" order by " + orderBy);
			}
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, name);
			if (isActive != null) {
				ps.setString(2, (isActive.equals(Boolean.TRUE) ? "Y" : "N"));
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				workPosition = activate(rs);
				list.add(workPosition);
			}
			return list;
		} catch (SQLException se) {
			se.printStackTrace(System.out);
			throw new MappingException(se, "SQLException findByName code=" + se.getErrorCode());
		} finally {
			close(conn);
		}
	}

	protected WorkPosition activate(ResultSet rs) throws SQLException {
		WorkPosition workPosition = new WorkPosition((Integer) rs.getObject(1));
		workPosition.setName(rs.getString(2).trim());
		workPosition.setIsActive(("Y".equals(rs.getString(3)) ? Boolean.TRUE : Boolean.FALSE));
		return workPosition;
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

}
