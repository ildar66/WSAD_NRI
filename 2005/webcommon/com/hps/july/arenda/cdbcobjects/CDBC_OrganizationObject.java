package com.hps.july.arenda.cdbcobjects;

import java.util.*;

import com.hps.july.arenda.valueobject.CustomerValueObject;
import com.hps.july.cdbc.lib.*;
/**
 * Insert the type's description here.
 * Creation date: (18.03.2005 14:43:39)
 * @author: Shafigullin Ildar
 */
public class CDBC_OrganizationObject {
	private final static java.lang.String findOrganization_SQL =
		"SELECT first 1000 zip, contactlist, directorfio, isrenter, koraccount, isprovider, phone, organizationtype, phisicaladdress, shortname, organization, inn, accountmanagerfio, okpo, isbank, legaladdress, bik, name, kpp, swift, bossposition, okonh, fax, issupplier, company "
			+ "FROM organizations  WHERE isbank='N' ";
	private final static String findOurOrganizations_SQL =
		"SELECT nvl (shortname, name) nameOrg, organization from organizations WHERE company = (select n.intvalue from namedvalues n where n.id = \"OUR_COMPANY\" ) and organization in (select organization from orgbeelineinregion where  regionid = ?) ";
	/**
	 * CDBC_WorkerObject constructor comment.
	 */
	public CDBC_OrganizationObject() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.03.2005 15:06:12)
	 */
	public static CDBCResultSet findListOrganizations(Boolean isName, String argName, Boolean isSupplier, Boolean isProvider, Boolean isRenter, Boolean isInn, String argInn, String aSortBy) {
		StringBuffer sqlb = new StringBuffer();
		CDBCResultSet res = new CDBCResultSet();
		//add query string: 
		sqlb.append(findOrganization_SQL);
		//calculate filter clause
		if (isName.booleanValue())
			sqlb.append("and ( upper(name) matches upper('" + argName + "') or upper(shortname) matches upper('" + argName + "') )");
		if (isSupplier.booleanValue())
			sqlb.append("and issupplier = \"Y\" ");
		if (isProvider.booleanValue())
			sqlb.append("and isprovider = \"Y\" ");
		if (isRenter.booleanValue())
			sqlb.append("and isrenter = \"Y\" ");
		if (isInn.booleanValue())
			sqlb.append("and upper(inn) matches upper('" + argInn + "') ");

		//append order by clause:
		sqlb.append("order by " + aSortBy);

		res.executeQuery(sqlb.toString(), null);

		return res;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (18.04.2006 15:06:12)
	 */
	public static CDBCResultSet findListOrganizations(
		Boolean isName,
		String argName,
		Boolean isSupplier,
		Boolean isProvider,
		Boolean isRenter,
		Boolean isChannalRenter,
		Boolean isInn,
		String argInn,
		String aSortBy) {
		StringBuffer sqlb = new StringBuffer();
		CDBCResultSet res = new CDBCResultSet();
		//add query string: 
		sqlb.append(findOrganization_SQL);
		//calculate filter clause
		if (isName.booleanValue())
			sqlb.append("and ( upper(name) matches upper('" + argName + "') or upper(shortname) matches upper('" + argName + "') )");
		if (isSupplier.booleanValue())
			sqlb.append("and issupplier = \"Y\" ");
		if (isProvider.booleanValue())
			sqlb.append("and isprovider = \"Y\" ");
		if (isRenter.booleanValue())
			sqlb.append("and isrenter = \"Y\" ");
		if (isChannalRenter.booleanValue())
			sqlb.append("and isChannalRenter = \"Y\" ");
		if (isInn.booleanValue())
			sqlb.append("and upper(inn) matches upper('" + argInn + "') ");

		//append order by clause:
		sqlb.append("order by " + aSortBy);

		res.executeQuery(sqlb.toString(), null);

		return res;
	}
	/**
	 * 
	 * @author IShaffigulin
	 * Список заказчиков для договоров аренды
	 */
	public final static java.util.List findOurOrganizations(Integer regID, String aSortBy) {
		List ret = new ArrayList();
		StringBuffer sqlb = new StringBuffer(findOurOrganizations_SQL);
		CDBCResultSet res = new CDBCResultSet();
		//calculate filter clause
		Object[] params = { regID };
		//append order by clause:
		sqlb.append("order by " + aSortBy);
		//executeQuery:
		//System.out.println("sqlb.toString()=" + sqlb.toString()); //temp
		res.executeQuery(sqlb.toString(), params);
		ListIterator iter = res.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			CustomerValueObject valueObject = new CustomerValueObject((Integer) ro.getColumn("organization").asObject(), ro.getColumn("nameOrg").asString());
			ret.add(valueObject);
		}
		return ret;
	}
}
