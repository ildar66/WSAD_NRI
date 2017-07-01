/*
 * Created on 25.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.cdbcobjects;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TableNriDAO extends PageDAO {

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.cdbcobjects.PageDAO#getSearchSQLString(java.lang.Object, java.lang.String)
	 */
	protected String getSearchSQLString(Object projCriteria, String orderBy) {
		return "SELECT * FROM "+ projCriteria;
	}
}
