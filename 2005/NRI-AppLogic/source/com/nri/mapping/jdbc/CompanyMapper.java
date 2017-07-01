/*
 * Created on 06.08.2007
 *
 * JDBCMapperImp Компании.
 */
package com.nri.mapping.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nri.domain.Company;
import com.nri.domain.NriObject;
import com.nri.exception.DuplicateKeyException;
import com.nri.exception.MappingException;

/**
 * @author IShaffigulin
 *
 * JDBCMapperImp Компании.
 */
public class CompanyMapper extends JDBCMapper implements com.nri.mapping.CompanyMapper {

	/**
	 * 
	 */
	public CompanyMapper() {
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
	 * @see com.nri.mapping.CompanyMapper#findById(java.lang.Integer)
	 */
	public Company findById(Integer id) throws MappingException {
		throw new MappingException("findById not valid for this type");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.CompanyMapper#findByName(java.lang.String, java.lang.String)
	 */
	public ArrayList findByName(String name, String orderBy) throws MappingException {
		throw new MappingException("findByName not valid for this type");
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
