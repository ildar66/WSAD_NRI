package com.hps.july.logic;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import com.hps.july.cdbc.lib.*;

/**
 * Класс для работы с категориями ввода ресурсов.
 * Creation date: (24.09.2004 17:54:39)
 * @author: Dmitry Dneprov
 */
public class InputCategoryObject {
/**
 * CDBCInventoryDocumentError constructor comment.
 */
public InputCategoryObject() {
	super();
}
	/**
	 * Добавление ресурса в данную категорию.
	 * @TODO: Написать описание параметров
	 */
	public static boolean createCategoryResource(Integer argCategory, Integer argResource) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("INSERT INTO categresources (categid, resource) ");
		sqlb.append(" VALUES (?, ?) ");
		params.add(argCategory);
		params.add(argResource);

		CDBCResultSet res = new CDBCResultSet();
		return res.executeUpdate(sqlb.toString(), params.toArray());
	}
	/**
	 * Удаление ресурса из данной категории.
	 * @TODO: Написать описание параметров
	 */
	public static boolean deleteCategoryResource(Integer argCategory, Integer argResource) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("DELETE FROM categresources  ");
		sqlb.append(" WHERE categid = ? AND resource = ? ");
		params.add(argCategory);
		params.add(argResource);

		CDBCResultSet res = new CDBCResultSet();
		return res.executeUpdate(sqlb.toString(), params.toArray());
	}
/**
 * Выдаёт список ресурсов для данной категории ввода
 */
public CDBCResultSet findResourcesList(
    Integer argCategory,
    Boolean byCategoryOnly,
    Boolean isTypekey,
    Integer typeKey,
    Boolean isSubtypekey,
    Integer subtypeKey,
    Boolean isModel,
    String model,
    Boolean isName,
    String name,
    Boolean isManufid,
    Integer manufid,
    Boolean isManucode,
    String manucode,
    String show,
    Integer order) {
    StringBuffer sqlb = new StringBuffer();
    LinkedList params = new LinkedList();

    sqlb.append(
        "SELECT r.resource resource, TRIM(r.model) model, TRIM(r.name) name, TRIM(r.manucode) manucode, ");
    sqlb.append(
        "TRIM(u.shortname) shortname, r.countpolicy countpolicy, r.priceable priceable, r.complectpart complectpart, ");
    sqlb.append("r.resourceclass rtype, cr.resource crresource ");
    sqlb.append("FROM resources r, units u,  ");
    if (!byCategoryOnly.booleanValue())
        sqlb.append(" outer ");
    sqlb.append(" categresources cr ");
    sqlb.append(
        "WHERE r.unit = u.unit AND cr.resource = r.resource AND cr.categid = ? ");
    params.add(argCategory);

    if (!byCategoryOnly.booleanValue()) {
        if (show != null && !"*".equals(show)) {
            sqlb.append("AND r.active = ? ");
            params.add(show);
        }
        if (isSubtypekey != null && isSubtypekey.booleanValue()) {
            if (subtypeKey != null) {
                sqlb.append("AND r.resourcesubtype = ? ");
                params.add(subtypeKey);
            } else {
                sqlb.append("AND r.resourcesubtype IS NULL ");
            }
        } else
            if (isTypekey != null && isTypekey.booleanValue()) {
                if (typeKey != null) {
                    sqlb.append(
                        "AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype = ?) ");
                    params.add(typeKey);
                } else {
                    sqlb.append(
                        "AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype IS NULL) ");
                }
            }

        if (isModel != null && isModel.booleanValue()) {
            if (model != null) {
                sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
                params.add(model);
            } else {
                sqlb.append("AND r.model IS NULL ");
            }
        }
        if (isName != null && isName.booleanValue()) {
            if (name != null) {
                sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
                params.add(name);
            } else {
                sqlb.append("AND r.name IS NULL ");
            }
        }
        /*
        if (isManufacturer != null && isManufacturer.booleanValue()) {
            if (manufacturer != null) {
                sqlb.append("AND r.manufacturer = ? ");
                params.add(manufacturer);
            } else {
                sqlb.append("AND r.manufacturer IS NULL ");
            }
        }
		*/
		if (isManufid != null && isManufid.booleanValue()) {
			if (manufid != null) {
				sqlb.append("AND r.manufid = ? ");
				params.add(manufid);
			} else {
				sqlb.append("AND r.manufid IS NULL ");
			}
		}
		
		
        if (isManucode != null && isManucode.booleanValue()) {
            if (manucode != null) {
                sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
                params.add(manucode);
            } else {
                sqlb.append("AND r.manucode IS NULL ");
            }
        }
    }

    // ORDER BY
    if (order != null) {
        switch (order.intValue()) {
            case 1 :
                sqlb.append("ORDER BY model ASC ");
                break;
            case 2 :
                sqlb.append("ORDER BY model DESC ");
                break;
            case 3 :
                sqlb.append("ORDER BY name ASC ");
                break;
            case 4 :
                sqlb.append("ORDER BY name DESC ");
                break;
            case 5 :
                sqlb.append("ORDER BY manucode ASC ");
                break;
            case 6 :
                sqlb.append("ORDER BY manucode DESC ");
                break;
        }
    }
    System.out.println(sqlb.toString());
    CDBCResultSet res = new CDBCResultSet();
    res.executeQuery(sqlb.toString(), params.toArray());
    return res;
}
	/**
	 * Возвращает наименование для данной категории.
	 * @TODO: Написать описание параметров
	 */
	public static String getCategoryName(
		Integer argCategory
		)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT categname ");
		sqlb.append("FROM inputcategories ");
		sqlb.append("WHERE categid = ? ");
		params.add(argCategory);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		java.util.ListIterator it = res.listIterator();
		String result = "";
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			result = ro.getColumn("categname").asString();
		}
		return result;
	}
	/**
	 * Возвращает список ресурсов для данной категории.
	 * @TODO: Написать описание параметров
	 */
	public static CDBCResultSet listCategories()	{
		StringBuffer sqlb = new StringBuffer();

		sqlb.append("SELECT * ");
		sqlb.append("FROM inputcategories ");
		sqlb.append("ORDER BY categname ASC");

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), null);
		return res;
	}
	/**
	 * Возвращает список ресурсов для данной категории.
	 * @TODO: Написать описание параметров
	 */
	public static CDBCResultSet listCategoryResources(
		Integer argCategory
		)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT r.* ");
		sqlb.append("FROM resources r, categresources c2r ");
		sqlb.append("WHERE c2r.resource = r.resource AND c2r.categid = ? ");
		sqlb.append("ORDER BY r.name ASC");
		params.add(argCategory);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает список ресурсов типа антенна для данной категории.
	 * @TODO: Написать описание параметров
	 */
	public static CDBCResultSet listCategoryResourcesAntenna(
		Integer argCategory,
		String argDiap
		)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT r.* ");
		sqlb.append("FROM resources r, categresources c2r  ");
		sqlb.append("WHERE c2r.resource = r.resource AND r.resourceclass = 'A' AND c2r.categid = ? ");
		if (argDiap != null)
			sqlb.append(" AND r.resource IN (SELECT arb.resource FROM antennaresband arb WHERE arb.band = " + argDiap + " ) ");
		sqlb.append("ORDER BY r.name ASC");
		params.add(argCategory);

		CDBCResultSet res = new CDBCResultSet();
		//System.out.println(sqlb.toString());
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	/**
	 * Возвращает список ресурсов типа базовая станция GSM для данной категории.
	 * @TODO: Написать описание параметров
	 */
	public static CDBCResultSet listCategoryResourcesGSMBS(
		Integer argCategory
		)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT r.* ");
		sqlb.append("FROM resources r, categresources c2r  ");
		sqlb.append("WHERE c2r.resource = r.resource AND r.resourceclass = 'B' AND c2r.categid = ? ");
		sqlb.append(" AND r.resource IN (SELECT bsr.resource FROM basestationres bsr WHERE bsr.standard = 'G' ) ");
		sqlb.append("ORDER BY r.name ASC");
		params.add(argCategory);

		CDBCResultSet res = new CDBCResultSet();
		System.out.println(sqlb.toString());
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
}
