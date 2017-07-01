package com.hps.july.inventory.service;

import java.util.HashMap;
import java.util.Map;

import com.hps.july.inventory.valueobject.VisualType;
import com.hps.july.logic.VisualDocTypes;

/**
 * @author dimitry
 * Created 26.04.2006
 */
public class MountActVisualTypeServiceImpl implements MountActVisualTypeService {

	private Map visualTypeMap = new HashMap();
	
	public MountActVisualTypeServiceImpl() {
		init();
	}
	
	public void init(){
		visualTypeMap.put(VisualDocTypes.BTS_MOUNT_ACT_ALCATEL_N, 
				new VisualType(VisualDocTypes.BTS_MOUNT_ACT_ALCATEL_N, "Alcatel"));
		
		visualTypeMap.put(VisualDocTypes.BTS_MOUNT_ACT_ERIC_N, 
				new VisualType(VisualDocTypes.BTS_MOUNT_ACT_ERIC_N, "Ericsson"));

		visualTypeMap.put(VisualDocTypes.BTS_MOUNT_ACT_NOKIA_N, 
				new VisualType(VisualDocTypes.BTS_MOUNT_ACT_NOKIA_N, "Nokia"));

		visualTypeMap.put(VisualDocTypes.BTS_MOUNT_ACT_SIEMENS_N, 
				new VisualType(VisualDocTypes.BTS_MOUNT_ACT_SIEMENS_N, "Siemens"));

		visualTypeMap.put(VisualDocTypes.BTS_MOUNT_ACT_HUAWEI_N, 
				new VisualType(VisualDocTypes.BTS_MOUNT_ACT_HUAWEI_N, "Huawei"));
	}
	
	
	
	public Map getMountActVisualTypeMap() {
		return visualTypeMap;
	}

	public VisualType getVisualType(Integer visualTypeId){
		return (VisualType) visualTypeMap.get(visualTypeId);
	}
	
	
	
}
