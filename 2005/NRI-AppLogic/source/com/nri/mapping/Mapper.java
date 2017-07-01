package com.nri.mapping;

import java.util.ArrayList;

import com.nri.domain.NriObject;
import com.nri.exception.DuplicateKeyException;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchObjectException;
/**
 * Mapping API implemented by data source access mechanisms that access specific
 * data sources, such as JDBC or EJB, and "maps" results to objects. This interface specifies
 * a set of persistent operations in order to retrieve and store Objects to and
 * from specific data sources.
 */
public interface Mapper {
	/**
	 * Delete a TsObject from its store
	 */
	public void remove(NriObject anObject) throws NoSuchObjectException, MappingException;
	
	/**
	 * Insert a new NriObject into the store
	 */
	public void insert(NriObject anObject) throws DuplicateKeyException, MappingException;
	
	/**
	 * Return a ArrayList of all NriObjects (use carefully in practice!)
	 * We use this extensively in our example, but in fact more "wise" enumerators
	 * That would directly query the datasource (e.g. through EJB finders)
	 *
	 * @return ArrayList
	 */
	public ArrayList findAll() throws MappingException;
	
	/**
	 * Retrieve a single object matching this object.
	 *
	 * @return NriObject
	 */
	public NriObject findByPrimaryKey(NriObject anObject) throws NoSuchObjectException, MappingException;
	
	/**
	 * Update this object (e.g. change its state in the store)
	 *
	 */
	public void update(NriObject anObject) throws NoSuchObjectException, MappingException;
}