/*
 * Created on 02.08.2007
 *
 * Mapper Компаний.
 */
package com.nri.mapping;

import java.util.ArrayList;

import com.nri.domain.Company;
import com.nri.exception.MappingException;

/**
 * @author IShaffigulin
 *
 * Mapper Компаний.
 */
public interface CompanyMapper extends Mapper {
	public Company findById(Integer id) throws MappingException;
	public ArrayList findByName(String name, String orderBy) throws MappingException;
}
