package com.hps.july.inventory.service.dao;

import java.util.List;

/**
 * @author dimitry
 * Created 21.04.2006
 */
public interface DocPositionsDao {

	void deleteDocPositions(Integer documentId);

	List loadDocPositionList(Integer documentId, Integer parentId);
	
}
