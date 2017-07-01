/*
 * Created on 02.08.2007
 *
 * This is the default, in-memory People mapper
 */
package com.nri.mapping.memory;

import java.util.ArrayList;
import java.util.ListIterator;

import com.nri.domain.NriObject;
import com.nri.domain.People;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchPeopleException;

/**
 * @author IShaffigulin
 *
 * This is the default, in-memory People mapper
 */
public class PeopleMapper extends ObjectMapper implements com.nri.mapping.PeopleMapper {
	protected static ArrayList cache = null;
	/**
	 * 
	 */
	public PeopleMapper() {
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
		People e = new People(new Integer(1));
		e.setFirstName("John");
		e.setLastName("Doe");
		v.add(e);
		e = new People(new Integer(2));
		e.setFirstName("Jane");
		e.setLastName("Doe");
		v.add(e);
		e = new People(new Integer(3));
		e.setFirstName("Clark");
		e.setLastName("Griswold");
		v.add(e);
		return v;
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.Mapper#findByPrimaryKey(com.nri.domain.NriObject)
	 */
	public NriObject findByPrimaryKey(NriObject anObject) throws NoSuchPeopleException {
		People people = (People) anObject;
		return findByMan(people.getMan());
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.PeopleMapper#findByMan(java.lang.Integer)
	 */
	public People findByMan(Integer man) throws NoSuchPeopleException {
		ArrayList Peoples = getCache();
		ListIterator iter = Peoples.listIterator();
		People current = null;
		while (iter.hasNext()) {
			current = (People) iter.next();
			if (current.getMan().equals(man))
				return current;
		}
		throw new NoSuchPeopleException("No People matching " + man + " found");

	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.PeopleMapper#findByName(java.lang.String)
	 */
	public ArrayList findByName(String lastName) throws MappingException {
		ArrayList peoples = findAll();
		if("*".equals(lastName) || "%".equals(lastName)){
			return peoples;
		}		
		ListIterator iter = peoples.listIterator();
		People current = null;
		while (iter.hasNext()) {
			current = (People) iter.next();
			if (!current.getLastName().equals(lastName)) {
				iter.remove();
			}
		}
		return peoples;
	}

}
