package com.hps.july.inventory.service.dao;

import java.util.List;

import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.inventory.valueobject.Resource;
import com.hps.july.jdbcpersistence.dao.JdbcDaoSupport;
import com.hps.july.jdbcpersistence.dao.RowMapper;

/**
 * @author dimitry
 * Created 11.04.2006
 */
public class ResourceDaoJdbc extends JdbcDaoSupport implements ResourceDao {

	protected RowMapper resourceRowMapper = new RowMapper(){

		public Object mapRow(CDBCRowObject row, int count) {
			Resource resource = new Resource();
			resource.setId((Integer)row.getColumn("id").asObject());
			resource.setModelName(row.getColumn("model").asString());
			resource.setStockTakingType(row.getColumn("stockTakingType").asString());
			return resource;
		}};
	
	
	public List getResourcesByVisualCategory(Integer visualCategoryId) {
		return query(
				"SELECT r.resource as id, r.model, r.countpolicy as stockTakingType " +
				"FROM resources r, categresources c2r " + 
				"WHERE c2r.resource = r.resource AND c2r.categid = ? " + 
				"ORDER BY r.name ASC",  
				new Object[] {visualCategoryId}, resourceRowMapper );
	}

	public Resource getResource(Integer resourceId) {
		return (Resource) queryForObject(
				"SELECT r.resource as id, r.model, r.countpolicy as stockTakingType " + 
				"FROM resources r " + 
				"WHERE r.resource = ? ",  
				new Object[] { resourceId }, resourceRowMapper);
	}
	
	
}
