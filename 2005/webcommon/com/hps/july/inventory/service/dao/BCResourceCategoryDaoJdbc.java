package com.hps.july.inventory.service.dao;

import java.util.List;

import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.inventory.valueobject.Category;
import com.hps.july.inventory.valueobject.VisualCategory;
import com.hps.july.jdbcpersistence.dao.JdbcDaoSupport;
import com.hps.july.jdbcpersistence.dao.RowMapper;

/**
 * @author dimitry
 * Created 10.04.2006
 */
public class BCResourceCategoryDaoJdbc extends JdbcDaoSupport implements BCResourceCategoryDao {

	class CategoryWithVisualCategoryRowMapper implements RowMapper {

		public Object mapRow(CDBCRowObject row, int count) {
			Category category = new Category();
			
			category.setId((Integer)row.getColumn("category_id").asObject());
			category.setName(row.getColumn("category_name").asString());
			category.setIBPType(row.getColumn("category_IBPType").asString().equals("Y"));

			if (row.getColumn("visualCategory_id").asObject() != null){
				VisualCategory visualCategory = new VisualCategory();
				visualCategory.setId((Integer) row.getColumn("visualCategory_id").asObject());
				visualCategory.setName((String) row.getColumn("visualCategory_name").asObject());
				
				category.setVisualCategory(visualCategory);
			} 

			return category;
		}
	} 
	
		
		
		// TODO зависимость от фирмы ?
	public List getBCCategoryList(Integer parentId) {
		return query(
				"SELECT v.id as category_id, v.name as category_name, v.isIBPType as category_ibpType, " +
					"v.parentId as category_parentId, v.categoryId category_visualCategoryId, " +
					"c.categId as visualCategory_id, c.categname as visualCategory_name " +
				"FROM btsvisualtags as v LEFT JOIN inputcategories as c ON c.categid = v.categoryId " +
				"WHERE v.parentid " + ( parentId != null && parentId.intValue() != 0 ? " = ? " : " is null ") +
				"ORDER BY v.pos ASC", 
				(parentId != null && parentId.intValue() != 0 ? new Object[] { parentId } : null ),
			    new CategoryWithVisualCategoryRowMapper());
	}

	public Category getBCCategory(Integer categoryId) {
		if (categoryId == null || categoryId.intValue() == 0) return null;
		
		return (Category) queryForObject(
				"SELECT v.id as category_id, v.name as category_name, v.isIBPType as category_ibpType, " +
					"v.parentId as category_parentId, v.categoryId category_visualCategoryId, " +
					"c.categId as visualCategory_id, c.categname as visualCategory_name " +
				"FROM btsvisualtags as v LEFT JOIN inputcategories as c ON c.categid = v.categoryId " +
				"WHERE v.id = ? ORDER BY v.pos ASC", 
				new Object[] { categoryId }, 
			    new CategoryWithVisualCategoryRowMapper());
	}
}
