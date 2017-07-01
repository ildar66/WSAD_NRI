/*
 * Created on 02.08.2007
 *
 * This class is the "in-memory" Mapper for MsUsers.
 * It creates the default collection of MsUsers.
 */
package com.nri.mapping.memory;

import java.util.ArrayList;
import java.util.ListIterator;

import com.nri.domain.NriObject;
import com.nri.domain.MsUser;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchObjectException;
import com.nri.exception.NoSuchMsUserException;

/**
 * @author IShaffigulin
 *
 * This class is the "in-memory" Mapper for MsUsers.
 * It creates the default collection of MsUsers.
 */
public class MsUserMapper extends ObjectMapper implements com.nri.mapping.MsUserMapper {
	protected static ArrayList cache = null;
	/**
	 * 
	 */
	public MsUserMapper() {
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
		MsUser p = new MsUser(new Integer(1));
		p.setMsUser("Development at ABC Corp.");
		p.setMsPassword("pass1");
		v.add(p);
		p = new MsUser(new Integer(2));
		p.setMsUser("MsUser work at XYZ Corp.");
		p.setMsPassword("pass2");
		v.add(p);
		p = new MsUser(new Integer(3));
		p.setMsUser("MsUser work at PRG Corp.");
		p.setMsPassword("pass3");
		v.add(p);
		return v;
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.Mapper#findByPrimaryKey(com.nri.domain.NriObject)
	 */
	public NriObject findByPrimaryKey(NriObject anObject) throws NoSuchObjectException {
		MsUser msUser = (MsUser) anObject;
		return findById(msUser.getMsuCode());
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.MsUserMapper#findById(java.lang.Integer)
	 */
	public MsUser findById(Integer id) throws NoSuchMsUserException {
		ArrayList msUsers = getCache();
		ListIterator iter = msUsers.listIterator();
		MsUser current = null;
		while (iter.hasNext()) {
			current = (MsUser) iter.next();
			if (current.getMsuCode().equals(id))
				return current;
		}
		throw new NoSuchMsUserException("No msUser matching " + id + " found");

	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.MsUserMapper#findByName(java.lang.String, java.lang.String)
	 */
	public ArrayList findByName(String name, String orderBy) throws MappingException {
		ArrayList msUsers = findAll();
		if("*".equals(name) || "%".equals(name)){
			return msUsers;
		}		
		ListIterator iter = msUsers.listIterator();
		MsUser current = null;
		while (iter.hasNext()) {
			current = (MsUser) iter.next();
			if (!current.getMsUser().equals(name)) {
				iter.remove();
			}
		}
		return msUsers;
	}

}
