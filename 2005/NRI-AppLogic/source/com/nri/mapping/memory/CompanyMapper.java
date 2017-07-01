/*
 * Created on 06.08.2007
 *
 * This class is the "in-memory" Mapper for MsUsers.
 * It creates the default collection of MsUsers.
 */
package com.nri.mapping.memory;

import java.util.ArrayList;
import java.util.ListIterator;

import com.nri.domain.Company;
import com.nri.domain.NriObject;
import com.nri.exception.MappingException;
import com.nri.exception.NoSuchCompanyException;
import com.nri.exception.NoSuchObjectException;

/**
 * @author IShaffigulin
 *
 * This class is the "in-memory" Mapper for MsUsers.
 * It creates the default collection of MsUsers.
 */
public class CompanyMapper extends ObjectMapper implements com.nri.mapping.CompanyMapper {
	protected static ArrayList cache = null;
	/**
	 * 
	 */
	public CompanyMapper() {
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
		Company p = new Company(new Integer(1));
		p.setName("Development at ABC Corp.");
		p.setShortName("ShortName1");
		v.add(p);
		p = new Company(new Integer(2));
		p.setName("Company work at XYZ Corp.");
		p.setShortName("ShortName2");
		v.add(p);
		p = new Company(new Integer(3));
		p.setName("Company work at PRG Corp.");
		p.setShortName("ShortName3");
		v.add(p);
		return v;
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.Mapper#findByPrimaryKey(com.nri.domain.NriObject)
	 */
	public NriObject findByPrimaryKey(NriObject anObject) throws NoSuchObjectException {
		Company company = (Company) anObject;
		return findById(company.getCompany());
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.CompanyMapper#findById(java.lang.Integer)
	 */
	public Company findById(Integer id) throws NoSuchCompanyException {
		ArrayList companies = getCache();
		ListIterator iter = companies.listIterator();
		Company current = null;
		while (iter.hasNext()) {
			current = (Company) iter.next();
			if (current.getCompany().equals(id))
				return current;
		}
		throw new NoSuchCompanyException("No company matching " + id + " found");
	}

	/* (non-Javadoc)
	 * @see com.nri.mapping.CompanyMapper#findByName(java.lang.String, java.lang.String)
	 */
	public ArrayList findByName(String name, String orderBy) throws MappingException {
		ArrayList companies = findAll();
		if("*".equals(name) || "%".equals(name)){
			return companies;
		}		
		ListIterator iter = companies.listIterator();
		Company current = null;
		while (iter.hasNext()) {
			current = (Company) iter.next();
			if (!current.getName().equals(name)) {
				iter.remove();
			}
		}
		return companies;
	}

}
