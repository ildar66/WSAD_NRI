package com.hps.july.inventory.service.dao;

import java.math.BigDecimal;
import java.util.List;

import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.inventory.formbean.MountActDocPositionBean;
import com.hps.july.jdbcpersistence.dao.JdbcDaoSupport;
import com.hps.july.jdbcpersistence.dao.RowMapper;
import com.hps.july.utils.Logger;

/**
 * @author dimitry
 * Created 21.04.2006
 */
public class DocPositionsDaoJdbc extends JdbcDaoSupport implements DocPositionsDao {

	protected Logger logger = new Logger(this.getClass());
	
	protected RowMapper mountActDocPositionBeanMapper = new RowMapper(){

		public Object mapRow(CDBCRowObject row, int count) {
			MountActDocPositionBean bean = new MountActDocPositionBean();
			
			bean.setId((Integer) row.getColumn("id").asObject());
			bean.setResourceId((Integer) row.getColumn("resourceId").asObject());
			
			// TODO verify:
			bean.setCategoryId((Integer) row.getColumn("visualtagid").asObject());
			
			bean.setIndex(count-1); // or "pos"?
			
			bean.setWorksNumber((String) row.getColumn("worksNumber").asObject());
			bean.setInventoryNumber((String) row.getColumn("inventoryNumber").asObject());
			bean.setSubdivisionInventoryNumber((String) row.getColumn("subdivisionInventoryNumber").asObject());
			
			bean.setParentId((Integer) row.getColumn("parentId").asObject());
			bean.setQuantity(new Integer(((BigDecimal) row.getColumn("quantity").asObject()).intValue()));

			return bean;
		}};
	
	public void deleteDocPositions(Integer documentId) {
		update("DELETE FROM docpositions WHERE document = ? AND agregate IS NOT NULL ",
			new Object[] { documentId });
		
		// TODO ?? 
		update("  DELETE FROM docpositions WHERE document = ?",
			new Object[] { documentId});
	}

	public List loadDocPositionList(Integer documentId, Integer parentId) {
		logger.debug("loadDocPositionList: documentId=" + documentId + ", parentId=" + parentId);
		return query(
				"SELECT dp.docposition as id, dp.resource as resourceId, dp.order as pos, " +
					"TRIM(dp.serialNumber) as worksNumber, TRIM(dp.inventSerial) as inventoryNumber, " +
					"TRIM(dp.localSerial) as subdivisionInventoryNumber, dp.qty as quantity, " +
					"dp.parentbtsdocpos as parentId, dp.visualtagid " +
				"FROM docpositions as dp " +
				"WHERE dp.document = ? and dp.parentbtsdocpos " + (parentId != null ? " = ? " : " IS NULL ") +
				"ORDER BY dp.order ASC",
				(parentId != null ? new Object[]{ documentId, parentId } : new Object[] { documentId }), 
				mountActDocPositionBeanMapper);
	}
	
}
