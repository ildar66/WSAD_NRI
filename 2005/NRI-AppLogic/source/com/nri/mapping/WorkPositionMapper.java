/*
 * Created on 17.07.2007
 *
 * Mapper Должность.
 */
package com.nri.mapping;

import java.util.ArrayList;

import com.nri.domain.WorkPosition;
import com.nri.exception.MappingException;

/**
 * @author IShaffigulin
 *
 * Mapper Должность.
 */
public interface WorkPositionMapper extends Mapper {
	public WorkPosition findById(Integer id) throws MappingException;
	public ArrayList findByName(String name, Boolean isActive, String orderBy) throws MappingException;
}
