/*
 * Created on 02.08.2007
 *
 * This class is the "in-memory" Mapper for WorkPositions.
 * It creates the default collection of WorkPositions.
 */
package com.nri.mapping.memory;

import java.util.ArrayList;
import java.util.ListIterator;

import com.nri.domain.NriObject;
import com.nri.domain.WorkPosition;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchObjectException;
import com.nri.exception.NoSuchWorkPositionException;

/**
 * @author IShaffigulin
 *
 * This class is the "in-memory" Mapper for WorkPositions.
 * It creates the default collection of WorkPositions.
 */
public class WorkPositionMapper extends ObjectMapper implements com.nri.mapping.WorkPositionMapper {
	protected static ArrayList cache = null;
	/**
	 * 
	 */
	public WorkPositionMapper() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.memory.ObjectMapper#getCache()
	 */
	protected ArrayList getCache() {
		if (cache == null) {
			cache = initialLoad();
		}

		return cache;
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.memory.ObjectMapper#clearCache()
	 */
	public void clearCache() {
		cache = new ArrayList();
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.memory.ObjectMapper#initialLoad()
	 */
	ArrayList initialLoad() {
		ArrayList v = new ArrayList();
		WorkPosition p = new WorkPosition(new Integer(1));
		p.setIsActive(Boolean.TRUE);
		p.setName("Development at ABC Corp.");
		v.add(p);
		p = new WorkPosition(new Integer(2));
		p.setIsActive(Boolean.FALSE);
		p.setName("WorkPosition work at XYZ Corp.");
		v.add(p);
		p = new WorkPosition(new Integer(3));
		p.setIsActive(Boolean.TRUE);
		p.setName("WorkPosition work at PRG Corp.");
		v.add(p);
		return v;
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.Mapper#findByPrimaryKey(com.nri.domain.NriObject)
	 */
	public NriObject findByPrimaryKey(NriObject anObject) throws NoSuchObjectException {
		WorkPosition workPosition = (WorkPosition) anObject;
		return findById(workPosition.getWorkPosition());
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.WorkPositionMapper#findById(java.lang.Integer)
	 */
	public WorkPosition findById(Integer id) throws NoSuchWorkPositionException {
		ArrayList workPositions = getCache();
		ListIterator iter = workPositions.listIterator();
		WorkPosition current = null;
		while (iter.hasNext()) {
			current = (WorkPosition) iter.next();
			if (current.getWorkPosition().equals(id))
				return current;
		}
		throw new NoSuchWorkPositionException("No workPosition matching " + id + " found");

	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.WorkPositionMapper#findByName(java.lang.String, java.lang.Boolean, java.lang.String)
	 */
	public ArrayList findByName(String name, Boolean isActive, String orderBy) throws MappingException {
		ArrayList workPositions = findAll();
		if("*".equals(name) || "%".equals(name)){
			return workPositions;
		}		
		ListIterator iter = workPositions.listIterator();
		WorkPosition current = null;
		while (iter.hasNext()) {
			current = (WorkPosition) iter.next();
			if (!current.getName().equals(name)) {
				iter.remove();
			}
			if(isActive != null && !current.getIsActive().equals(isActive)){
				iter.remove();
			}
		}
		return workPositions;
	}

}
