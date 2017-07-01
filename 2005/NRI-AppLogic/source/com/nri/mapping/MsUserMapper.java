/*
 * Created on 02.08.2007
 *
 * Mapper Пользователи MicroStrategy.
 */
package com.nri.mapping;

import java.util.ArrayList;

import com.nri.domain.MsUser;
import com.nri.exception.MappingException;

/**
 * @author IShaffigulin
 *
 * Mapper Пользователи MicroStrategy.
 */
public interface MsUserMapper extends Mapper {
	public MsUser findById(Integer id) throws MappingException;
	public ArrayList findByName(String name, String orderBy) throws MappingException;
}
