package com.nri.mapping.memory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

import com.nri.domain.NriObject;
import com.nri.exception.NoSuchObjectException;
import com.nri.mapping.Mapper;
/**
 * This class represents a simple, "in-memory" mapper for NriObjects.
 * It stores the objects in a ArrayList.
 *
 * Creation date: (2/3/00 8:59:24 AM)
 * @author: Administrator
 */
public abstract class ObjectMapper implements Mapper, Serializable {
	//protected ArrayList cache = null;
	/**
	 * ObjectMapper constructor.
	 */
	public ObjectMapper() {
		super();
	}
	
	protected abstract ArrayList getCache();
	
	/**
	 * Remove all entries from the cache.
	 * Required for the JUnit Test Cases.
	 */
	public abstract void clearCache();
	
	/**
	 * Remove this NriObject from the cache.
	 */
	public void remove(NriObject anObject) {
		ArrayList cache = getCache();
		synchronized(this.getClass()) {
			cache.remove(anObject);
		}
	}
	/**
	 * Return a ArrayList of NriObjects for a Mapper.
	 * This should be overriden for each Mapper that requires
	 * an initial population of objects
	 *
	 * Creation date: (2/3/00 9:15:42 AM)
	 * @return java.util.ArrayList
	 */
	abstract ArrayList initialLoad();

	/**
	 * Insert NriObject into cache, and toggle persistent flag.
	 */
	public void insert(NriObject anObject) {
		synchronized(this.getClass()) {
			ArrayList cache = getCache();
			cache.add(anObject);
		}
	}

	/**
	 * Retrieve all objects in this mapper.
	 * if first access, load cache first.
	 */
	public java.util.ArrayList findAll() {
			ArrayList cache = getCache();
		return (ArrayList) cache.clone();
	}

	/**
	 * Default retrieveSingleObjectMatching() returns null
	 */
	public abstract NriObject findByPrimaryKey(NriObject anObject) throws NoSuchObjectException;
	
	/**
	 * The default update() method does a remove and an insert
	 */
	public void update(NriObject anObject) {
		remove(anObject);
		insert(anObject);
	}
}