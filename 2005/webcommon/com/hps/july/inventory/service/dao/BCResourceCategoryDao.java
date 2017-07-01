package com.hps.july.inventory.service.dao;

import java.util.List;

import com.hps.july.inventory.valueobject.Category;

/**
 * @author dimitry
 * Created 10.04.2006
 */
public interface BCResourceCategoryDao {

	List getBCCategoryList(Integer parentCategoryId);

	Category getBCCategory(Integer categoryId);

}
