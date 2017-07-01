package com.hps.july.inventory.service.dao;

import java.util.List;

import com.hps.july.inventory.valueobject.Resource;

/**
 * @author dimitry
 * Created 11.04.2006
 */
public interface ResourceDao {

	List getResourcesByVisualCategory(Integer categoryId);

	Resource getResource(Integer resourceId);
	
}
