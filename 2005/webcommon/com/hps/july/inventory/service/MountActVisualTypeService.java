package com.hps.july.inventory.service;

import java.util.Map;

import com.hps.july.inventory.valueobject.VisualType;

/**
 * @author dimitry
 * Created 26.04.2006
 */
public interface MountActVisualTypeService {

	Map getMountActVisualTypeMap();

	VisualType getVisualType(Integer visualTypeId);
	
}
