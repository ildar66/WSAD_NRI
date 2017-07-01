package com.hps.july.inventory.service.dao;

import java.util.List;

/**
 * @author dimitry
 * Created 20.04.2006
 */
public interface BaseStationDao {

	List getBSResSetFromPosition(Integer positionId);
	
	List findComplects(String positionNumber, String userName, Boolean isAdmin);
	
}
