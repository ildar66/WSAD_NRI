/*
 * Created on 24.07.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nri.mapping;

import java.util.ArrayList;

import com.nri.domain.Role;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchRoleException;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface RoleMapper extends Mapper {
	public Role findById(String roleId) throws NoSuchRoleException;
	public ArrayList findByName(String roleName) throws MappingException;
	public ArrayList findByName(String roleName, String orderBy) throws MappingException;
}
