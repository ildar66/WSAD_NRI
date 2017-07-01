package com.hps.july.jdbcpersistence.dao;

import com.hps.july.cdbc.lib.CDBCRowObject;

/**
 * @author dimitry
 * Created 18.04.2006
 */
public interface RowMapper {

	Object mapRow(CDBCRowObject row, int count);
	
}
