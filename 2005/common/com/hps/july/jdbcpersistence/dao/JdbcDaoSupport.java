package com.hps.july.jdbcpersistence.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.utils.Logger;

/**
 * @author dimitry
 * Created 18.04.2006
 */
public abstract class JdbcDaoSupport {
	
	protected Logger logger = new Logger(this.getClass());

	protected List query(String query, RowMapper rowMapper){
		return query(query, null, rowMapper);
	}
	
	protected List query(String query, Object[] params, RowMapper rowMapper){
		return execute(query, params, rowMapper);
	}
	
	protected Object queryForObject(String query, RowMapper rowMapper){
		return queryForObject(query, null, rowMapper);
	}
	
	
	
	
	protected Object queryForObject(String query, Object[] params, RowMapper rowMapper){
		List result = execute(query, params, rowMapper);
		if (!result.isEmpty() && result.size() == 1) return result.get(0);
		
		// TODO throw exception ?
		logger.warn("Incorrect result size: " + result.size() + ", expected: 1");
		if (!result.isEmpty()) return result.get(0);
		return null;
	} 
	
	
	
	private List execute(String query, Object[] params, RowMapper rowMapper){
//		String paramsStr = "";
//		if (params != null)
//			for (int i=0; i<params.length;i++)
//				paramsStr += params[i].toString() + ",";
//		logger.debug("ExecuteSQLQuery: '" + query + "', parameters("+(params != null ? params.length : 0) +"): [" + paramsStr + "]");
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(query, params);
		
		List result = new ArrayList();
		
		Iterator rows = res.listIterator(); int count = 0;
		while (rows.hasNext()){ count++;
			CDBCRowObject row = (CDBCRowObject) rows.next();
			Object rowObject = rowMapper.mapRow(row, count);
			result.add(rowObject);
		}

		return result;
	}
	
	protected void update(String query){
		update(query, null);
	}
	
	protected void update(String query, Object[] params){
		executeUpdate(query, params);
	}
	
	private void executeUpdate(String query, Object[] params){
		CDBCResultSet res = new CDBCResultSet();
		res.executeUpdate(query, params);
	}
	
}
