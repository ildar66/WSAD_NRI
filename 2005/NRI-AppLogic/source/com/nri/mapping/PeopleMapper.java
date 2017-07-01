/*
 * Created on 17.07.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nri.mapping;

import java.util.ArrayList;

import com.nri.domain.People;
import com.nri.exception.MappingException;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface PeopleMapper extends Mapper {
	public People findByMan(Integer man) throws MappingException;
	public ArrayList findByName(String name) throws MappingException;
}
