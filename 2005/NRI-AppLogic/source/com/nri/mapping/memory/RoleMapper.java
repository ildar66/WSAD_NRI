/*
 * Created on 02.08.2007
 *
 * This is the default, in-memory Role mapper
 */
package com.nri.mapping.memory;

import java.util.ArrayList;
import java.util.ListIterator;

import com.nri.domain.NriObject;
import com.nri.domain.Role;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchRoleException;

/**
 * @author IShaffigulin
 *
 * This is the default, in-memory Role mapper
 */
public class RoleMapper extends ObjectMapper implements com.nri.mapping.RoleMapper {
	protected static ArrayList cache = null;
	/**
	 * 
	 */
	public RoleMapper() {
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
		Role role = new Role("Role1");
		role.setRoleName("Development at ABC Corp.");
		v.add(role);
		role = new Role("Role2");
		role.setRoleName("Role work at XYZ Corp.");
		v.add(role);
		return v;
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.Mapper#findByPrimaryKey(com.nri.domain.NriObject)
	 */
	public NriObject findByPrimaryKey(NriObject anObject) throws NoSuchRoleException {
		Role role = (Role) anObject;
		return findById(role.getRole());
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.RoleMapper#findByName(java.lang.String)
	 */
	public ArrayList findByName(String roleName) throws MappingException {
		ArrayList roles = findAll();
		if("*".equals(roleName) || "%".equals(roleName)){
			return roles;
		}
		ListIterator iter = roles.listIterator();
		Role current = null;
		while (iter.hasNext()) {
			current = (Role) iter.next();
			if (!current.getRoleName().equals(roleName)) {
				iter.remove();
			}
		}
		return roles;
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.RoleMapper#findById(java.lang.String)
	 */
	public Role findById(String id) throws NoSuchRoleException {
		ArrayList roles = findAll();
		ListIterator iter = roles.listIterator();
		Role current = null;
		while (iter.hasNext()) {
			current = (Role)iter.next();
			if (current.getRole().equals(id))
				return current;
		}
		throw new NoSuchRoleException("No role matching " + id + " found");

	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.RoleMapper#findByName(java.lang.String, java.lang.String)
	 */
	public ArrayList findByName(String roleName, String orderBy) throws MappingException {
		return findByName(roleName);
	}

}
