package com.hps.july.cdbc.objects;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.*;

/**
 * Объект для работы с различными словарями.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Anthon Stefanov.
 */
public class CDBCDictionaryObject {
public CDBCDictionaryObject() {
	super();
}
public static void appendIN(StringBuffer sb, String param, Integer[] array)
{
	if(array == null) {
		return;
	} else if(array.length == 0)  {
		sb.append(param);
		sb.append(" IS NULL ");
	} else {
		sb.append(param);
		sb.append(" IN (");
		for(int i = 0; i < array.length; i++) {
			if(i > 0) sb.append(",");
			if(array[i] != null) {
				sb.append(array[i]);
			} else {
				sb.append(array[i]);
			}
		}
		sb.append(") ");
	}
}
public CDBCResultSet findAntennesBandsLookup(Integer antennares)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT band, horzwidth, vertwidth, amplification, electricangle FROM antennaresband WHERE ");
	if(antennares != null) {
		sqlb.append(" resource = ? ");
		params.add(antennares);
	} else {
		sqlb.append(" resource IS NULL ");
	}
	sqlb.append("ORDER BY band ");
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findAntennesResources(
	Boolean isTypekey, Integer typeKey,
	Boolean isSubtypekey, Integer subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	String show,
	String polarization, /// '*' - все типы, 'C' - кросс, 'V' - вертикальная (если там 1 и 2 то можно и на них заменить)
	Boolean isRange, Integer[] ranges,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, ");
	sqlb.append(" TRIM(r.active) active, ");
	sqlb.append("TRIM(u.shortname) shortname, a.polarization, NVL(a.length,'') || NVL('x' || a.width,'') || NVL('x' || a.height,'') bounds, ");
	sqlb.append("(SELECT ab.band FROM antennaresband ab WHERE ab.resource = r.resource AND ab.band = 800) band0, ");
	sqlb.append("(SELECT ab.band FROM antennaresband ab WHERE ab.resource = r.resource AND ab.band = 900) band1, ");
	sqlb.append("(SELECT ab.band FROM antennaresband ab WHERE ab.resource = r.resource AND ab.band = 1800) band2, ");
	sqlb.append("(SELECT ab.band FROM antennaresband ab WHERE ab.resource = r.resource AND ab.band = 2000) band3, ");
	sqlb.append("(SELECT ab.amplification FROM antennaresband ab WHERE ab.resource = r.resource AND ab.band = 800) amp0, ");
	sqlb.append("(SELECT ab.amplification FROM antennaresband ab WHERE ab.resource = r.resource AND ab.band = 900) amp1, ");
	sqlb.append("(SELECT ab.amplification FROM antennaresband ab WHERE ab.resource = r.resource AND ab.band = 1800) amp2, ");
	sqlb.append("(SELECT ab.amplification FROM antennaresband ab WHERE ab.resource = r.resource AND ab.band = 2000) amp3 ");
	sqlb.append("FROM resources r, antennares a, units u, outer organizations o ");
	sqlb.append("WHERE a.resource = r.resource AND r.unit = u.unit AND o.organization = r.manufacturer ");

	if(show != null && !"*".equals(show)) {
		sqlb.append("AND r.active = ? ");
		params.add(show);
	}
	if(isSubtypekey != null && isSubtypekey.booleanValue()) {
		if(subtypeKey != null) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(subtypeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IS NULL ");
		}
	} else if(isTypekey != null && isTypekey.booleanValue()) {
		if(typeKey != null) {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype = ?) ");
			params.add(typeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype IS NULL) ");
		}
	}
		
	if(isModel != null && isModel.booleanValue()) {
		if(model != null) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		} else {
			sqlb.append("AND r.model IS NULL ");
		}
	}
	if(isName != null && isName.booleanValue()) {
		if(name != null) {
			sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
			params.add(name);
		} else {
			sqlb.append("AND r.name IS NULL ");
		}
	}
	if(isManufacturer != null && isManufacturer.booleanValue()) {
		if(manufacturer != null) {
			sqlb.append("AND r.manufacturer = ? " );
			params.add(manufacturer);
		} else {
			sqlb.append("AND r.manufacturer IS NULL ");
		}
	}

	if(isManucode != null && isManucode.booleanValue()) {
		if(manucode != null) {
			sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
			params.add(manucode);
		} else {
			sqlb.append("AND r.manucode IS NULL ");
		}
	}

	if(polarization != null && !"*".equals(polarization)) {
		sqlb.append("AND a.polarization = ? ");
		params.add(polarization);
	}

	if(isRange != null && isRange.booleanValue()) {
		sqlb.append("AND r.resource IN (SELECT ab1.resource FROM antennaresband ab1 WHERE ");
		appendIN(sqlb,"ab1.band ",ranges);
		sqlb.append(") ");
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY model ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY model DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY name ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY name DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY manucode ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY manucode DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public CDBCResultSet findAntennesResourcesLookup(
	Boolean isType,	Integer type,
	Boolean isSubtype, Integer subtype,
	Integer ranges[], String polar,	String active,
	Boolean isModel, String model,
	Boolean isManu,	String manu,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT ar.resource, r.model, r.name, o.name orgname, ar.polarization ");
	sqlb.append("FROM antennares ar, resources r, outer organizations o ");
	sqlb.append("WHERE ar.resource = r.resource AND r.manufacturer = o.organization ");

	if(active != null && !"*".equals(active)) {
		sqlb.append("AND r.active = ? ");
		params.add(active);
	}
	if(isSubtype != null && isSubtype.booleanValue()) {
		if(subtype != null) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(subtype);
		} else {
			sqlb.append("AND r.resourcesubtype IS NULL ");
		}
	} else if(isType != null && isType.booleanValue()) {
		if(type != null) {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype = ?) ");
			params.add(type);
		} else {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype IS NULL) ");
		}
	}
		
	if(isModel != null && isModel.booleanValue()) {
		if(model != null) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		} else {
			sqlb.append("AND r.model IS NULL ");
		}
	}
	if(isManu != null && isManu.booleanValue()) {
		if(manu != null) {
			sqlb.append("AND UPPER(o.name) MATCHES UPPER(?) ");
			params.add(manu);
		} else {
			sqlb.append("AND o.name IS NULL ");
		}
	}

	if(polar != null && !"*".equals(polar)) {
		sqlb.append("AND a.polarization = ? ");
		params.add(polar);
	}

	if(ranges != null && ranges.length > 0) {
		sqlb.append("AND r.resource IN (SELECT ab1.resource FROM antennaresband ab1 WHERE ");
		appendIN(sqlb,"ab1.band ",ranges);
		sqlb.append(") ");
	} else {
		sqlb.append("AND r.resource IN (SELECT ab1.resource FROM antennaresband ab1 WHERE ab1.band IS NULL) ");
	}

	sqlb.append("ORDER BY r.model ASC, r.name ASC ");
	// ORDER BY
/*
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY model ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY model DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY name ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY name DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY manucode ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY manucode DESC ");
			break;
		}
	}
*/
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Выдаёт список ресурсов базовых станций
 */
public CDBCResultSet findBasestationResources(
	Boolean isTypekey, Integer typeKey,
	Boolean isSubtypekey, Integer subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	String show,
	Boolean isGeneration, String generation,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, r.active active, ");
	sqlb.append("TRIM(u.shortname) shortname, NVL(LOWER(b.standard),'') standart, NVL(b.generation,'') generation, NVL(b.length || 'x' || b.width || 'x' || b.height,'') bounds, NVL(TRIM(b.productline),'') productline, ");
	sqlb.append("LOWER(r.countpolicy) countpolicy, r.priceable priceable, r.complectpart complectpart ");
	sqlb.append("FROM resources r, basestationres b, units u, outer organizations o ");
	sqlb.append("WHERE b.resource = r.resource AND r.unit = u.unit AND o.organization = r.manufacturer ");

	if(show != null && !"*".equals(show)) {
		sqlb.append("AND r.active = ? ");
		params.add(show);
	}
	if(isSubtypekey != null && isSubtypekey.booleanValue()) {
		if(subtypeKey != null) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(subtypeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IS NULL ");
		}
	} else if(isTypekey != null && isTypekey.booleanValue()) {
		if(typeKey != null) {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype = ?) ");
			params.add(typeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype IS NULL) ");
		}
	}
		
	if(isModel != null && isModel.booleanValue()) {
		if(model != null) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		} else {
			sqlb.append("AND r.model IS NULL ");
		}
	}
	if(isName != null && isName.booleanValue()) {
		if(name != null) {
			sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
			params.add(name);
		} else {
			sqlb.append("AND r.name IS NULL ");
		}
	}
	if(isManufacturer != null && isManufacturer.booleanValue()) {
		if(manufacturer != null) {
			sqlb.append("AND r.manufacturer = ? " );
			params.add(manufacturer);
		} else {
			sqlb.append("AND r.manufacturer IS NULL ");
		}
	}

	if(isManucode != null && isManucode.booleanValue()) {
		if(manucode != null) {
			sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
			params.add(manucode);
		} else {
			sqlb.append("AND r.manucode IS NULL ");
		}
	}

	if(isGeneration != null && isGeneration.booleanValue()) {
		if(generation != null) {
			sqlb.append("AND UPPER(b.generation) MATCHES UPPER(?) ");
			params.add(generation);
		} else {
			sqlb.append("AND b.generation IS NULL ");
		}
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY model ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY model DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY name ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY name DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY manucode ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY manucode DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Выдаёт список ресурсов кабелей базовых станций
 */
public CDBCResultSet findCableResources(
	Boolean isTypekey, Integer typeKey,
	Boolean isSubtypekey, Integer subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, r.active active, ");
	sqlb.append("(SELECT cb.lostfactor FROM cableresband cb WHERE cb.resource = r.resource AND cb.band = 800) lost0, ");
	sqlb.append("(SELECT cb.lostfactor FROM cableresband cb WHERE cb.resource = r.resource AND cb.band = 900) lost1, ");
	sqlb.append("(SELECT cb.lostfactor FROM cableresband cb WHERE cb.resource = r.resource AND cb.band = 1800) lost2, ");
	sqlb.append("(SELECT cb.lostfactor FROM cableresband cb WHERE cb.resource = r.resource AND cb.band = 2000) lost3 ");
	sqlb.append("FROM resources r, cableres c, units u, outer organizations o ");
	sqlb.append("WHERE c.resource = r.resource AND r.unit = u.unit AND o.organization = r.manufacturer ");

	if(show != null && !"*".equals(show)) {
		sqlb.append("AND r.active = ? ");
		params.add(show);
	}
	if(isSubtypekey != null && isSubtypekey.booleanValue()) {
		if(subtypeKey != null) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(subtypeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IS NULL ");
		}
	} else if(isTypekey != null && isTypekey.booleanValue()) {
		if(typeKey != null) {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype = ?) ");
			params.add(typeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype IS NULL) ");
		}
	}
		
	if(isModel != null && isModel.booleanValue()) {
		if(model != null) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		} else {
			sqlb.append("AND r.model IS NULL ");
		}
	}
	if(isName != null && isName.booleanValue()) {
		if(name != null) {
			sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
			params.add(name);
		} else {
			sqlb.append("AND r.name IS NULL ");
		}
	}
	if(isManufacturer != null && isManufacturer.booleanValue()) {
		if(manufacturer != null) {
			sqlb.append("AND r.manufacturer = ? " );
			params.add(manufacturer);
		} else {
			sqlb.append("AND r.manufacturer IS NULL ");
		}
	}

	if(isManucode != null && isManucode.booleanValue()) {
		if(manucode != null) {
			sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
			params.add(manucode);
		} else {
			sqlb.append("AND r.manucode IS NULL ");
		}
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY model ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY model DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY name ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY name DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY manucode ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY manucode DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Выдаёт список ресурсов репитеров
 */
public CDBCResultSet findRepeaterResources(
	Boolean isTypekey, Integer typeKey,
	Boolean isSubtypekey, Integer subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, ");
	sqlb.append("CASE p.islinear WHEN 'Y' THEN 'polosovoi' ELSE 'chanalni' END type, p.reppower, CASE p.islinear WHEN 'Y' THEN p.bandwidth ELSE p.numchanals END nums ");
	sqlb.append("FROM resources r, repiterres p, units u, outer organizations o ");
	sqlb.append("WHERE p.resource = r.resource AND r.unit = u.unit AND o.organization = r.manufacturer ");

	if(show != null && !"*".equals(show)) {
		sqlb.append("AND r.active = ? ");
		params.add(show);
	}
	if(isSubtypekey != null && isSubtypekey.booleanValue()) {
		if(subtypeKey != null) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(subtypeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IS NULL ");
		}
	} else if(isTypekey != null && isTypekey.booleanValue()) {
		if(typeKey != null) {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype = ?) ");
			params.add(typeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype IS NULL) ");
		}
	}
		
	if(isModel != null && isModel.booleanValue()) {
		if(model != null) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		} else {
			sqlb.append("AND r.model IS NULL ");
		}
	}
	if(isName != null && isName.booleanValue()) {
		if(name != null) {
			sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
			params.add(name);
		} else {
			sqlb.append("AND r.name IS NULL ");
		}
	}
	if(isManufacturer != null && isManufacturer.booleanValue()) {
		if(manufacturer != null) {
			sqlb.append("AND r.manufacturer = ? " );
			params.add(manufacturer);
		} else {
			sqlb.append("AND r.manufacturer IS NULL ");
		}
	}

	if(isManucode != null && isManucode.booleanValue()) {
		if(manucode != null) {
			sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
			params.add(manucode);
		} else {
			sqlb.append("AND r.manucode IS NULL ");
		}
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY model ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY model DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY name ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY name DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY manucode ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY manucode DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Выдаёт список ресурсов для лукапов
 */
public CDBCResultSet findResources(
	Boolean isSubtypekey, ResourceSubTypeKey subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, r.model model, r.name name, r.manucode manucode, u.shortname shortname, r.countpolicy countpolicy ");
	sqlb.append("FROM resources r, units u ");
	sqlb.append("WHERE r.unit = u.unit AND r.active = 'Y' ");

	if(isSubtypekey != null && isSubtypekey.booleanValue()) {
		if(subtypeKey != null) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(new Integer(subtypeKey.resourcesubtype));
		} else {
			sqlb.append("AND r.resourcesubtype IS NULL ");
		}
	}
	if(isModel != null && isModel.booleanValue()) {
		if(model != null) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		} else {
			sqlb.append("AND r.model IS NULL ");
		}
	}
	if(isName != null && isName.booleanValue()) {
		if(name != null) {
			sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
			params.add(name);
		} else {
			sqlb.append("AND r.name IS NULL ");
		}
	}
	if(isManufacturer != null && isManufacturer.booleanValue()) {
		if(manufacturer != null) {
			sqlb.append("AND r.manufacturer = ? " );
			params.add(manufacturer);
		} else {
			sqlb.append("AND r.manufacturer IS NULL ");
		}
	}

	if(isManucode != null && isManucode.booleanValue()) {
		if(manucode != null) {
			sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
			params.add(manucode);
		} else {
			sqlb.append("AND r.manucode IS NULL ");
		}
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY r.model ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY r.model DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY r.name ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY r.name DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Выдаёт список наборов оборудования
 */
public CDBCResultSet findResourceSets(
	String searchType,
	String searchString,
	Integer order
) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT rt.resourcetype, rt.name rtname, rst.resourcesubtype, rst.name rstname, ");
	sqlb.append("rs.resourceset, rs.name, TRIM(r.name) || NVL(', ' || TRIM(r.model),'') mpname, rs.mainpartqty, u.shortname, rs.type  ");
	sqlb.append("FROM resourcesets rs, resources r, resourcesubtypes rst, resourcetypes rt, outer units u ");
	sqlb.append("WHERE rs.mainpart = r.resource AND r.resourcesubtype = rst.resourcesubtype AND rst.resourcetype = rt.resourcetype ");
	sqlb.append("AND r.unit = u.unit AND r.active = 'Y' ");

	// Поколдовать со строкой поиска
	
	if(searchType != null) {
		if("1".equals(searchType)) { // Поиск по наименованию комплекта
			sqlb.append("AND LOWER(rs.name) MATCHES ? ");
			params.add(searchString);
		} else
		if("2".equals(searchType)) { // Поиск по наим. типа оборудования
			sqlb.append("AND LOWER(rt.name) MATCHES ? ");
			params.add(searchString);
		} else
		if("3".equals(searchType)) { // Поиск по наим. вида оборудования
			sqlb.append("AND LOWER(rst.name) MATCHES ? ");
			params.add(searchString);
		} else
		if("4".equals(searchType)) { // Поиск по наименованию главной части
			sqlb.append("AND LOWER(TRIM(r.name) || ' ' || TRIM(r.model)) MATCHES ? ");
			params.add(searchString);
		}/* else
		if("5".equals(searchType)) {
		} else
		if("6".equals(searchType)) {
		} else
		if("7".equals(searchType)) {
		}*/
	} else {
		sqlb.append("AND rs.resourceset <> rs.resourceset ");
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY rs.name ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY rs.name DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY r.name ASC, r.model ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY r.name DESC, r.model DESC ");
			break;
/*
		case 5:
			sqlb.append("ORDER BY r.name ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY r.name DESC ");
			break;
*/
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Выдаёт список ресурсов
 */
public CDBCResultSet findResourcesList(
	Boolean isTypekey, Integer typeKey,
	Boolean isSubtypekey, Integer subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, TRIM(r.model) model, TRIM(r.name) name, TRIM(r.manucode) manucode, TRIM(u.shortname) shortname, r.countpolicy countpolicy, r.priceable priceable, r.complectpart complectpart, r.resourceclass rtype ");
	sqlb.append("FROM resources r, units u ");
	sqlb.append("WHERE r.unit = u.unit ");

	if(show != null && !"*".equals(show)) {
		sqlb.append("AND r.active = ? ");
		params.add(show);
	}
	if(isSubtypekey != null && isSubtypekey.booleanValue()) {
		if(subtypeKey != null) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(subtypeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IS NULL ");
		}
	} else if(isTypekey != null && isTypekey.booleanValue()) {
		if(typeKey != null) {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype = ?) ");
			params.add(typeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype IS NULL) ");
		}
	}
		
	if(isModel != null && isModel.booleanValue()) {
		if(model != null) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		} else {
			sqlb.append("AND r.model IS NULL ");
		}
	}
	if(isName != null && isName.booleanValue()) {
		if(name != null) {
			sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
			params.add(name);
		} else {
			sqlb.append("AND r.name IS NULL ");
		}
	}
	if(isManufacturer != null && isManufacturer.booleanValue()) {
		if(manufacturer != null) {
			sqlb.append("AND r.manufacturer = ? " );
			params.add(manufacturer);
		} else {
			sqlb.append("AND r.manufacturer IS NULL ");
		}
	}

	if(isManucode != null && isManucode.booleanValue()) {
		if(manucode != null) {
			sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
			params.add(manucode);
		} else {
			sqlb.append("AND r.manucode IS NULL ");
		}
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY model ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY model DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY name ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY name DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY manucode ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY manucode DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Выдаёт список ресурсов антенн РРЛ
 */
public CDBCResultSet findRRLResourcesList(
	Boolean isTypekey, Integer typeKey,
	Boolean isSubtypekey, Integer subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, TRIM(r.model) model, TRIM(r.name) name, TRIM(r.manucode) manucode, TRIM(u.shortname) shortname, r.countpolicy countpolicy, r.priceable priceable, r.complectpart complectpart, r.resourceclass rtype ");
	sqlb.append("FROM resources r, units u, rrlantennares rl ");
	sqlb.append("WHERE r.unit = u.unit AND rl.resource = r.resource ");

	if(show != null && !"*".equals(show)) {
		sqlb.append("AND r.active = ? ");
		params.add(show);
	}
	if(isSubtypekey != null && isSubtypekey.booleanValue()) {
		if(subtypeKey != null) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(subtypeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IS NULL ");
		}
	} else if(isTypekey != null && isTypekey.booleanValue()) {
		if(typeKey != null) {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype = ?) ");
			params.add(typeKey);
		} else {
			sqlb.append("AND r.resourcesubtype IN (SELECT resourcesubtype FROM resourcesubtypes WHERE resourcetype IS NULL) ");
		}
	}
		
	if(isModel != null && isModel.booleanValue()) {
		if(model != null) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		} else {
			sqlb.append("AND r.model IS NULL ");
		}
	}
	if(isName != null && isName.booleanValue()) {
		if(name != null) {
			sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
			params.add(name);
		} else {
			sqlb.append("AND r.name IS NULL ");
		}
	}
	if(isManufacturer != null && isManufacturer.booleanValue()) {
		if(manufacturer != null) {
			sqlb.append("AND r.manufacturer = ? " );
			params.add(manufacturer);
		} else {
			sqlb.append("AND r.manufacturer IS NULL ");
		}
	}

	if(isManucode != null && isManucode.booleanValue()) {
		if(manucode != null) {
			sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
			params.add(manucode);
		} else {
			sqlb.append("AND r.manucode IS NULL ");
		}
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY model ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY model DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY name ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY name DESC ");
			break;
		case 5:
			sqlb.append("ORDER BY manucode ASC ");
			break;
		case 6:
			sqlb.append("ORDER BY manucode DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * получение списка диаметров антенн для конкретного вида ррл антенн
 * Creation date: (15.07.2004 12:38:33)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 * @param resource java.lang.Integer
 */
public CDBCResultSet findRRLResourcesParamsAntdiams(Integer resource) {

	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	int resourseint = resource.intValue();
	sqlb.append("SELECT rrlantid, antdiam FROM rrlantparams ");
	sqlb.append("WHERE resource=" + resourseint);
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	System.out.println("sql = " + sqlb.toString());
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 12:38:33)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 * @param resource java.lang.Integer
 */
public CDBCResultSet findRRLResourcesParamsList(Integer resource) {

	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	int resourseint = resource.intValue();
	sqlb.append("SELECT * FROM rrlantparams ");
	sqlb.append("WHERE resource=" + resourseint);
	sqlb.append(" ORDER BY antdiam ASC");
	//sqlb.append(" ORDER BY antdiam ASC");
	//sqlb.append(" ORDER BY dnangleh ASC");
	//sqlb.append(" ORDER BY dnanglew ASC");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	System.out.println("sql = " + sqlb.toString());
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (20.07.2004 16:21:52)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 * @param resource java.lang.Integer
 */
public CDBCResultSet findRRLResourcesSpeedParamsList(Integer resource) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	int resourseint = resource.intValue();
	sqlb.append("SELECT * FROM rrlspeedparams ");
	sqlb.append("WHERE resource=" + resourseint);
	sqlb.append(" ORDER BY streamspeed ASC");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	System.out.println("sql = " + sqlb.toString());
	return res;
}
/**
 *  получение списка скоростей потоков для конкретного вида ррл антенн
 * Creation date: (20.07.2004 16:21:52)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 * @param resource java.lang.Integer
 */
public CDBCResultSet findRRLResourcesSpeedParamsStreamspeeds(Integer resource) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	int resourseint = resource.intValue();
	sqlb.append("SELECT rrlspeedid, streamspeed FROM rrlspeedparams ");
	sqlb.append("WHERE resource=" + resourseint);
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	System.out.println("sql = " + sqlb.toString());
	return res;
}
/**
 * Выдаёт список ресурсов репитеров
 */
public CDBCResultSet findStorages(
	Boolean useSuperregion, Integer[] argSuperregion,
	Boolean useRegion, Integer[] argRegion,
	Boolean useDivision, String argDivision,
	Boolean useName, String argName,
	Boolean isAdmin, String username,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT sp.storageplace, TRIM(sp.name) spname, dv.name, r.regname, sp.address ");
	sqlb.append("FROM storageplaces sp, storages s, regions r, outer divisions dv ");
	sqlb.append("WHERE sp.type = 'S' AND s.storageplace = sp.storageplace AND s.regionid = r.regionid AND sp.division = dv.division ");

	if(isAdmin != null && !isAdmin.booleanValue()) {
		sqlb.append("AND sp.storageplace IN ");
		sqlb.append("(SELECT s.storageplace "); 
		sqlb.append("FROM regionsaccess ra, operators op, regions r, storages s  ");
		sqlb.append("WHERE ra.operatorid = op.operator AND op.loiginid = ? ");
		sqlb.append("AND ra.viewfact = 'Y' AND ra.editfact ='Y'  ");
		sqlb.append("AND (r.regionid = ra.regionid OR r.supregid = ra.supregionid)  ");
		sqlb.append("AND r.regionid = s.regionid)  ");
		if(username != null) {
			params.add(username);
		} else {
			params.add("");
		}
	}

	if(useRegion != null && useRegion.booleanValue()) {
		appendIN(sqlb,"AND s.regionid ",argRegion);
	} else if(useSuperregion != null && useSuperregion.booleanValue()) {
		appendIN(sqlb,"AND r.supregid ",argSuperregion);
	}

	if(useDivision != null && useDivision.booleanValue()) {
		if(argDivision != null) {
			sqlb.append("AND dv.name MATCHES (?) ");
			params.add(argDivision);
		} else {
			sqlb.append("AND dv.name IS NULL ");
		}
	}

	if(useName != null && useName.booleanValue()) {
		if(argName != null) {
			sqlb.append("AND sp.name MATCHES (?) ");
			params.add(argDivision);
		} else {
			sqlb.append("AND sp.name IS NULL ");
		}
	}

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY spname ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY spname DESC ");
			break;
		}
	}
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Возвращает код ресурса заземления для указанного кабеля.
 */
public Integer getCableGroundResource(Integer cableres)
{
	
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT c.complectpart FROM cableres cr, resources r, complects c WHERE cr.resource = r.resource AND c.complect = r.resource ");
	if(cableres != null) {
		sqlb.append("AND cr.resource = ? ");
		params.add(cableres);
	} else {
		sqlb.append("AND cr.resource IS NULL ");
	}

	Integer result = null;
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Object o = ro.getColumn("complectpart").asObject();
		if(o != null) {
			result = new Integer(((Number)o).intValue());
		}
	}
	return result;
}
/**
 * Проверяет используется ли ресурс с указанным кодом в документах или хранилищах
 */
public boolean isResourceUsed(Integer resource)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	CDBCResultSet res = new CDBCResultSet();

	if(resource == null) {
		return false;
	}

	params.add(resource);

	sqlb.append("SELECT count(docposition) cnt FROM docpositions WHERE resource = ? ");
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		if(((Number)ro.getColumn("cnt").asObject()).intValue() > 0) {
			return true;
		}
	}

	sqlb.append("SELECT count(changeactpos) cnt FROM changeactpos cp, resources r WHERE r.resource = ? AND (cp.oldresource = r.resource OR cp.newresource = r.resource)");
	res.executeQuery(sqlb.toString(), params.toArray());
	it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		if(((Number)ro.getColumn("cnt").asObject()).intValue() > 0) {
			return true;
		}
	}

	sqlb.append("SELECT count(storagecard) cnt FROM storagecards WHERE resource = ? ");
	res.executeQuery(sqlb.toString(), params.toArray());
	it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		if(((Number)ro.getColumn("cnt").asObject()).intValue() > 0) {
			return true;
		}
	}

	return false;
}
public static CDBCResultSet listContrBSs()
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE r.resource, r.model, r.countpolicy FROM resources r  WHERE r.resourcesubtype=3 ORDER BY r.model ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public static CDBCResultSet listContrItemsByCateg(int[] categ)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE r.resource, r.model, r.countpolicy, c2r.categid FROM resources r, categresources c2r");
	sqlb.append(" WHERE c2r.resource = r.resource AND c2r.categid IN (");

	for(int i=0;i<categ.length;i++){	
		sqlb.append(categ[i]);
		if(!(i==categ.length-1)) sqlb.append(",");	
	}
	sqlb.append(") ORDER BY r.model ASC ");
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public static CDBCResultSet listContrItemsByCateg(Integer categ1,Integer categ2)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE r.resource, r.model, r.countpolicy FROM resources r, categresources c2r");
	sqlb.append(" WHERE c2r.resource = r.resource AND c2r.categid IN (");
	sqlb.append(categ1);sqlb.append(",");sqlb.append(categ2);sqlb.append(")");
	sqlb.append(" ORDER BY r.model ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public static CDBCResultSet listContrItemsByResource(int ressubtype)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE r.resource, r.model, r.countpolicy FROM resources r  WHERE r.resourcesubtype=");
	sqlb.append(ressubtype);
	sqlb.append(" ORDER BY r.model ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public static CDBCResultSet listMountItemACCs()
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE r.resource, r.model, r.countpolicy, u.shortname uname FROM resources r, categresources c2r, outer units u WHERE c2r.resource = r.resource AND c2r.categid IN (3,16) AND r.unit = u.unit ORDER BY r.model ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public static CDBCResultSet listMountItemBISs()
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE r.resource, r.model, r.countpolicy, u.shortname uname FROM resources r, categresources c2r, outer units u WHERE c2r.resource = r.resource AND c2r.categid IN (2,15) AND r.unit = u.unit ORDER BY r.model ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public static CDBCResultSet listMountItemUPSs()
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT UNIQUE r.resource, r.model, r.countpolicy, u.shortname uname FROM resources r, categresources c2r, outer units u WHERE c2r.resource = r.resource AND c2r.categid IN (1,14) AND r.unit = u.unit ORDER BY r.model ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public static CDBCResultSet getAllCableDiameters() {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append(
		"SELECT id, diamname FROM cablediameters ");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}

private static String configPowerSources = 
 " SELECT informix.resourcesets.resourceset AS complectCode, " + 
 " Trim(informix.nfsresources.segment1) AS nfsCode, " + 
 " Trim(informix.resourcesets.name) AS complectName, " +
 " informix.powersupplyset.power as power, " + 
 " Trim(informix.nfsresources.name) AS nfsName, " + 
 " informix.nfsresources.item_id AS nfsId "; 
private static String configPowerSourcesFrom_01_02 = 
 // " FROM informix.resourcesets INNER JOIN informix.nfsresources ON informix.resourcesets.nfsitem_id = informix.nfsresources.item_id " +
 " FROM informix.resourcesets LEFT OUTER JOIN informix.nfsresources ON informix.resourcesets.nfsitem_id = informix.nfsresources.item_id " +
 // " INNER JOIN informix.powersupplyset ON informix.resourcesets.resourceset  = informix.powersupplyset.resourceset ";
 " LEFT OUTER JOIN informix.powersupplyset ON informix.resourcesets.resourceset  = informix.powersupplyset.resourceset ";
private static String configPowerSourcesFrom_03 = 
 " FROM informix.resources INNER JOIN ((informix.resourcesets INNER JOIN informix.nfsresources ON " + 
 " informix.resourcesets.nfsitem_id = informix.nfsresources.item_id) " +
 " INNER JOIN informix.resourcesetparts ON informix.resourcesets.resourceset = informix.resourcesetparts.resourceset) " + 
 " ON informix.resources.resource = informix.resourcesetparts.resource " +
 // " INNER JOIN informix.powersupplyset ON informix.resourcesets.resourceset  = informix.powersupplyset.resourceset ";
 " LEFT OUTER JOIN informix.powersupplyset ON informix.resourcesets.resourceset  = informix.powersupplyset.resourceset ";
  
private static String  configPowerSourcesWherePart_01 = " WHERE (((Trim(informix.nfsresources.segment1))=?) AND ((informix.resourcesets.resourcesetclass)=?)) ";
private static String  configPowerSourcesWherePart_02 = " WHERE (((informix.resourcesets.resourceset)=?) AND ((informix.resourcesets.resourcesetclass)=?)) ";
private static String  configPowerSourcesWherePart_03 = " WHERE (((informix.resources.resource)=?) AND ((informix.resourcesets.resourcesetclass)=?)) ";
private static String  configPowerSourcesWherePart_04 = " WHERE ((UPPER(informix.resourcesets.name) MATCHES UPPER(?)) AND ((informix.resourcesets.resourcesetclass)=?)) ";
private static String  configPowerSourcesOrderPart = " ORDER BY informix.resourcesets.resourceset ";

public static CDBCResultSet findConfigPowerSources(int paramCode, String paramValue, String complectTypeCode) {
	System.out.println("### findConfigPowerSources "+paramCode+", "+paramValue+", "+complectTypeCode);
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append(configPowerSources);
	// if ((paramCode == 1) || (paramCode == 2)) {
	if ((paramCode == 1) || (paramCode == 2) || (paramCode == 4)) {
		sqlb.append(configPowerSourcesFrom_01_02);
	} else if (paramCode == 3) {
		sqlb.append(configPowerSourcesFrom_03);
	}

	if (paramCode == 1) {
		sqlb.append(configPowerSourcesWherePart_01);
	} else if (paramCode == 2) {
		sqlb.append(configPowerSourcesWherePart_02);
	} else if (paramCode == 3) {
		sqlb.append(configPowerSourcesWherePart_03);
	} else if (paramCode == 4) {
		sqlb.append(configPowerSourcesWherePart_04);
	}

	sqlb.append(configPowerSourcesOrderPart);

	params.add(paramValue);
	params.add(complectTypeCode);
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}

private static String cmplFromWherePartStruct =
 " FROM (((informix.resourcesets INNER JOIN informix.resourcesetparts ON informix.resourcesets.resourceset = informix.resourcesetparts.resourceset) INNER JOIN informix.resources ON informix.resourcesetparts.resource = informix.resources.resource " +
 " LEFT OUTER JOIN informix.nfsres2nrires ON informix.resources.resource=informix.nfsres2nrires.resource  LEFT OUTER JOIN informix.nfsresources on informix.nfsres2nrires.item_id=informix.nfsresources.item_id " + 
 " ) LEFT OUTER JOIN informix.units on informix.units.unit = informix.resources.unit ) " +
 " WHERE (((informix.resourcesets.resourceset)=?)) ";//AND datatype IN ('A', 'U') ";

private static String cmplStruct =
 " SELECT " + " distinct " + " informix.resourcesetparts.resource AS nriCode, " + 
 " Trim(informix.resources.name) AS resourceName, " + 
 " Trim(informix.resources.model) AS model, " + 
 " informix.resourcesetparts.qty AS quantity, " +
 " informix.resources.unit AS unit_id, " +
 " informix.units.name AS unit_name, " +
 //
 //" informix.nfsresources.segment1 as nfsid " +
 " '' as nfsid " +
 //
 cmplFromWherePartStruct +
 " ORDER BY informix.resourcesetparts.resource ";

public static CDBCResultSet findCmplStruct(int complectCode) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append(cmplStruct);
	params.add(new Integer(complectCode));

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}

private static String cmplStructNfsCount =
 " SELECT " +
 " informix.resourcesetparts.resource AS nriCode, " + 
 " min(trim(informix.nfsresources.segment1)) as nfsid," +
 " count(informix.nfsresources.segment1) as count_nfs " +
 //
 cmplFromWherePartStruct +
 " GROUP BY informix.resourcesetparts.resource " +
 " ORDER BY informix.resourcesetparts.resource ";

 public static CDBCResultSet findCmplStructNfsCount(int complectCode) {
	 StringBuffer sqlb = new StringBuffer();
	 LinkedList params = new LinkedList();

	 sqlb.append(cmplStructNfsCount);
	 params.add(new Integer(complectCode));

	 CDBCResultSet res = new CDBCResultSet();
	 res.executeQuery(sqlb.toString(), params.toArray());
	 return res;
 }

public static HashMap getCanShowNfsCodes(String complectCode) {
	HashMap parts = new HashMap();

	String partsCountSQL = 
	"SELECT rsp.resource AS resource " +	"FROM resourcesetparts rsp " +	"WHERE rsp.resourceset = ? ";	 
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append(partsCountSQL);
	params.add(new Integer(complectCode));

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());

	ListIterator it = res.listIterator();
	
	while(it.hasNext()){
		CDBCRowObject row = (CDBCRowObject) it.next();
		String part_id = row.getColumn("resource").asString();
		if (isEnabledNfsCode(part_id))
			parts.put(part_id,Boolean.TRUE);
		else
			parts.put(part_id,Boolean.FALSE);
	}
	return parts;
}

public static String nfsCodeCount(String partCode) {
	String result = "";
	
	String checkEnabledSQL = "SELECT COUNT(*) as enabledcount FROM nfsres2nrires " +
		"WHERE resource = ? AND datatype IN ('A', 'U')";
	
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	
	sqlb.append(checkEnabledSQL);
	params.add(new Integer(partCode));
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	
	ListIterator it = res.listIterator();
	if (it.hasNext()){
		CDBCRowObject row = (CDBCRowObject) it.next();
		result = row.getColumn("enabledcount").asString();
	}
	System.out.println("isEnabledNfsCode: partCode = "+partCode+"; result = "+result);
	return result;
}

public static boolean isEnabledNfsCode(String partCode) {
	return new Integer(nfsCodeCount(partCode)).intValue()>0;
}

public static String getFirstNFSCode(Integer partCode){
	String result = "";
	String firstNFSCodeSQL = "SELECT * FROM nfsres2nrires n2n " +		"JOIN nfsresources nr " +		"ON n2n.item_id=nr.item_id " +
		"WHERE resource = ? AND datatype IN ('A', 'U') " +		"ORDER BY segment1";
	
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append(firstNFSCodeSQL);
	params.add(partCode);	
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	
	ListIterator it = res.listIterator();
	if (it.hasNext()){
		CDBCRowObject row = (CDBCRowObject) it.next();
		result = row.getColumn("segment1").asString();
	}
	else result = "";
	System.out.println("getFirstNFSCode: partCode = "+partCode+"; result = "+result);
		
	return result;
}

private static String curCmplStruct =
 " SELECT informix.resourcesetparts.resource AS nriCode, " + 
 " Trim(informix.resources.name) AS resourceName, " + 
 " Trim(informix.resources.model) AS model, " +
 " informix.units.shortname AS unit_name, " +  
 " informix.resourcesetparts.qty AS quantity " +
 " FROM ((informix.resourcesets INNER JOIN informix.resourcesetparts ON informix.resourcesets.resourceset = informix.resourcesetparts.resourceset) INNER JOIN informix.resources ON informix.resourcesetparts.resource = informix.resources.resource) INNER JOIN informix.units ON informix.resources.unit = informix.units.unit" +
 " WHERE (((informix.resourcesets.resourceset)=?) AND ((informix.resourcesetparts.resource)=?)) ";

public static CDBCResultSet findCurCmplStruct(String complectCode, String nriCode) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append(curCmplStruct);
	params.add(complectCode);
	params.add(nriCode);

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}

private static String modelListSelect = 
 " SELECT trim(informix.resources.model) AS model, informix.resources.resource as id " + 
 " FROM informix.resources " +
 " WHERE (((informix.resources.active)='Y') AND ((informix.resources.resourceclass2)=?) AND (UPPER(informix.resources.model) like UPPER(?))) " + 
 " ORDER BY informix.resources.model ";

 public static CDBCResultSet findModelList(String modelFilterString, String typeCode) {
	 StringBuffer sqlb = new StringBuffer();
	 LinkedList params = new LinkedList();

	 sqlb.append(modelListSelect);
 	 params.add(typeCode);
	 params.add("%" + modelFilterString + "%");

	 CDBCResultSet res = new CDBCResultSet();
	 res.executeQuery(sqlb.toString(), params.toArray());
	 return res;
 }

 private static String manuflListSelect = 
  " SELECT distinct trim(informix.organizations.shortname) AS shortname,  informix.organizations.organization as organization " + 
  " FROM informix.resources INNER JOIN informix.organizations ON informix.resources.manufacturer=informix.organizations.organization " +  
  " WHERE (((informix.resources.manufacturer) Is Not Null) AND ((informix.resources.resourceclass)=\"B\") AND ((informix.organizations.shortname) Is Not Null)) " +  
  " ORDER BY shortname ";

public static CDBCResultSet findManufList() {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append(manuflListSelect);

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}

private static String standModelListSelect = 
	" SELECT informix.resources.model as model, informix.resources.resource as resource " +
	" FROM (informix.resources INNER JOIN informix.organizations ON informix.resources.manufacturer=informix.organizations.organization) " + 
	" 	INNER JOIN informix.basestationres ON informix.resources.resource=informix.basestationres.resource " +
	" WHERE " + 
	" 	( " +
	" 	(((informix.resources.active)= ?) Or ((informix.resources.active)= ?)) And " + 
	" 	((informix.resources.resourceclass)=\"B\") And " + 
	" 	((informix.organizations.organization)= ?) And " + 
	" 	((informix.basestationres.standard)=\"G\") " +
	" 	)  " +
	" ORDER BY informix.resources.model ";

	public static CDBCResultSet findStandModelList(String active, String orgCode) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(standModelListSelect);
		if ((active != null) && (active.length() == 1)) {
			params.add(active);
			params.add(active);
		} else {
			params.add("Y");
			params.add("N");
		}
		params.add(orgCode);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	private static String baseStationCurComplectListSelect = 
	" SELECT informix.confbsnfs.conftype AS К,  " +
	" 	informix.confbsnfs.sect_a AS A, informix.confbsnfs.sect_b AS B, informix.confbsnfs.sect_c AS C, informix.confbsnfs.sect_d AS D, " + 
	" 	informix.confbsnfs.sect_e AS E, informix.confbsnfs.sect_f AS F, informix.confbsnfs.sect_g AS G, informix.confbsnfs.sect_h AS H, " +
	" 	informix.confbsnfs.voltage AS voltage, Trim(informix.nfsresources.segment1) AS nfsCode, Trim(informix.nfsresources.name) AS nfsName, " +
	"   informix.confbsnfs.id AS id, " +
	" 	informix.nfsresources.item_id AS nfsId, " +
	" 	informix.confbsnfs.codenri AS codenri, " +
	"   informix.confbsnfs.sect_o900 AS o900, informix.confbsnfs.sect_o1800 AS o1800 " +
	" FROM informix.confbsnfs INNER JOIN informix.nfsresources ON informix.confbsnfs.nfsitem_id = informix.nfsresources.item_id " +
	"  WHERE ((informix.confbsnfs.codenri) = ?) " +
	" ORDER BY 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 ";

	public static CDBCResultSet findBaseStationCurComplectList(String standId) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(baseStationCurComplectListSelect);
		params.add(standId);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	private static String baseStationCurComplectSelect = 
	" SELECT informix.confbsnfs.conftype AS К,  " +
	" 	informix.confbsnfs.sect_a AS A, informix.confbsnfs.sect_b AS B, informix.confbsnfs.sect_c AS C, informix.confbsnfs.sect_d AS D, " + 
	" 	informix.confbsnfs.sect_e AS E, informix.confbsnfs.sect_f AS F, informix.confbsnfs.sect_g AS G, informix.confbsnfs.sect_h AS H, " +
	" 	informix.confbsnfs.voltage AS voltage, Trim(informix.nfsresources.segment1) AS nfsCode, Trim(informix.nfsresources.name) AS nfsName, " +
	" 	informix.nfsresources.item_id AS nfsId, " +
	" 	informix.confbsnfs.codenri AS codenri, " +	"   informix.confbsnfs.sect_o900 AS o900, informix.confbsnfs.sect_o1800 AS o1800 " +
	
	" FROM informix.confbsnfs INNER JOIN informix.nfsresources ON informix.confbsnfs.nfsitem_id = informix.nfsresources.item_id " +
	"  WHERE ((informix.confbsnfs.id) = ?) ";

	public static CDBCResultSet findBaseStationCurComplect(String complectId) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		//
		sqlb.append(baseStationCurComplectSelect);
		params.add(complectId);
		//
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	private static String findAllSelect =  	
	" select o.id as id from informix.ConfBSNfs o where " +  
	" o.conftype = ? AND " +
	" o.sect_a = ? AND o.sect_b = ? AND o.sect_c = ? AND o.sect_d = ? AND " + 
	" o.sect_e = ? AND o.sect_f = ? AND o.sect_g = ? AND o.sect_h = ? AND " +	" o.sect_o900 = ? AND o.sect_o1800 = ? AND " +
	" o.nfsitem_id = ? AND o.codenri = ? AND ";
	private static String findAllWhereVoltageNotNull =  	
	" o.voltage = ? ";
	private static String findAllWhereVoltageNull =  	
	" o.voltage is null ";
	
	public static CDBCResultSet findByAllBaseStationComplect(
		String argConfType,
		Integer argSectA,
		Integer argSectB,
		Integer argSectC,
		Integer argSectD,
		Integer argSectE,
		Integer argSectF,
		Integer argSectG,
		Integer argSectH,
		String argNFSId,
		Integer argCodeNRI,
		BigDecimal argVoltage,
		Integer argSect_o900,
		Integer argSect_o1800
	) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(findAllSelect);
		if (argVoltage != null) {
			sqlb.append(findAllWhereVoltageNotNull);
		} else {
			sqlb.append(findAllWhereVoltageNull);
		}
		//
		params.add(argConfType);
		params.add(argSectA);
		params.add(argSectB);
		params.add(argSectC);
		params.add(argSectD);
		params.add(argSectE);
		params.add(argSectF);
		params.add(argSectG);
		params.add(argSectH);
		params.add(argSect_o900);
		params.add(argSect_o1800);
		params.add(argNFSId);
		params.add(argCodeNRI);
		if (argVoltage != null) {
			params.add(argVoltage);
		}
		//
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	private static String nfsNameSelect = 
	" SELECT Trim(informix.nfsresources.name) as name " +
	" FROM informix.nfsresources " +
	" WHERE ((informix.nfsresources.item_id) = ?) ";
	public static CDBCResultSet getNfsName(String item_id) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		//
		sqlb.append(nfsNameSelect);
		params.add(item_id);
		//
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	private static String resourcesetpartsDelStr = "delete from informix.resourcesetparts where resourceset = ?";
	private static String powersupplysetDelStr = "delete from informix.powersupplyset where resourceset = ?";
	private static String uzopowersupplysetDelStr = "delete from informix.uzopowersupplyset where resourceset = ?";
	private static String bsinstcomplectresourcesetDelStr = "delete from informix.bsinstcomplectresourceset where resourceset = ?";
	private static String resourcesetsDelStr = "delete from informix.resourcesets where resourceset = ?";
	
	/**
	 * 
	 */
	public static void removePowerSource(String resourceSetId, 
						boolean isElAp, boolean isUzo, boolean isIkBs) throws Exception {
		Connection con = null;
		boolean oldAutocommit = true;
		try {
			JdbcConnection jcon = new JdbcConnection();
			con = jcon.getConnection();
			oldAutocommit = con.getAutoCommit();
			con.setAutoCommit(false);
			
			// 1. resourcesetparts
			executeDelRoutine(resourcesetpartsDelStr, resourceSetId, con);
			//
			if (isElAp) {
				// 2. powersupplyset
				executeDelRoutine(powersupplysetDelStr, resourceSetId, con);
			} else if (isUzo) {
				// 3. uzopowersupplyset
				executeDelRoutine(uzopowersupplysetDelStr, resourceSetId, con);
			} else if (isIkBs) {
				// 3++. bsinstcomplectresourceset
				executeDelRoutine(bsinstcomplectresourcesetDelStr, resourceSetId, con);
			}
			// 4. resourcesets
			executeDelRoutine(resourcesetsDelStr, resourceSetId, con);
			
			// !!!! Тестим ролбек
			// if (isElAp) {
			// 	throw new Exception("!!!!!!!!!! Igor Exception !!!!!");
			// }
			
			// коммитим и восстанавливаем флаг
			con.commit();
			con.setAutoCommit(oldAutocommit);
		} catch (Exception ee) {
			ee.printStackTrace(System.out);
			try {
				con.rollback();
				System.out.println("### Здесь роллбек возбудился...");
				con.setAutoCommit(oldAutocommit);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
			throw ee;
		} finally {
				try {
					System.out.println("### setAutoCommit на место old = " + oldAutocommit);
					con.setAutoCommit(oldAutocommit);
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
		}
	}
	
	/**
	 * @param delStr
	 * @param id
	 */
	private static void executeDelRoutine(String delStr, String id, Connection con) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append(delStr);
		params.add(id);
		//
		CDBCResultSet res = new CDBCResultSet();
		res.executeUpdate(con, sqlb.toString(), params.toArray());
	}
	
	private static String connector4CompatSelectStr = 
		" select " +
		" distinct " +	
		" informix.resources.resource as id, " +
		" trim(informix.organizations.name) as manuf, " +
		" trim(informix.resources.model) as model, " +
		" trim(informix.units.name) as unit, " +
		" trim(informix.resources.active) as active " +
		" from " +
		" (((informix.resources  LEFT JOIN informix.organizations ON informix.resources.manufacturer=informix.organizations.organization) " +
		" LEFT JOIN informix.units ON informix.resources.unit=informix.units.unit) " +
		" LEFT JOIN informix.nfsres2nrires ON informix.resources.resource=informix.nfsres2nrires.resource LEFT JOIN informix.nfsresources on informix.nfsres2nrires.item_id=informix.nfsresources.item_id) " +
		" where  " +
		" informix.resources.resourceclass2 = 16 " + 
		" AND " +
		" (informix.nfsres2nrires.datatype='A' OR informix.nfsres2nrires.datatype='U' ) " +
		"  ";

	private static String connector4CompatOrderByStr = 
		" order by " +
		" informix.resources.resource asc"; 
		
	private static String nriCompatWherePart = 
		" AND " +
		" informix.resources.resource =	? ";	

	private static String nfsCompatWherePart = 
		" AND " +
		// " UPPER(informix.nfsresources.segment1) MATCHES UPPER(?) ";	
		" informix.resources.resource in "+
		" ( SELECT informix.resources.resource "+
		" from informix.resources  "+
		" LEFT JOIN informix.nfsres2nrires ON informix.resources.resource=informix.nfsres2nrires.resource LEFT JOIN informix.nfsresources on informix.nfsres2nrires.item_id=informix.nfsresources.item_id " +
		" WHERE " +
        " UPPER(informix.nfsresources.segment1) MATCHES UPPER(?) ) ";	

	private static String modelCompatWherePart = 
		" AND " +
		" UPPER(informix.resources.model) MATCHES UPPER(?) ";	

	private static String activeCompatWherePart = 
		" AND " +
		" informix.resources.active = ? ";	
	
	private static String diamCompatWherePart = 
		" AND " +
		" informix.cableres.cablediamid = ? ";	
	
	public static CDBCResultSet findConnector4CompatList(int paramCode, String paramValue) {
		System.out.println("### findConnector4CompatList paramCode = "+paramCode+", paramValue = "+paramValue);
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(connector4CompatSelectStr);
		sqlb.append(insertCompatWherePart(paramCode, paramValue));
		sqlb.append(connector4CompatOrderByStr);
		
		System.out.println("### findConnector4CompatList sqlb = "+sqlb);
		
		if (needComatParameter(paramCode, paramValue)) {
			params.add(paramValue);
		}

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	private static boolean needComatParameter(int paramCode, String paramValue) {
		if ((paramCode == 4) && (paramValue.length() > 1)) {
			return false;
		} else {
			return true;
		}
	}
	private static String insertCompatWherePart(int paramCode, String paramValue) {
		String outStr = " ";
		switch (paramCode) {
			case 1: outStr = nriCompatWherePart; break;  
			case 2: outStr = nfsCompatWherePart; break;  
			case 3: outStr = modelCompatWherePart; break;  
			case 4:
					if (paramValue.length() == 1) { 
						outStr = activeCompatWherePart;  
					}
					break;
			case 5: outStr = diamCompatWherePart; break;  
		}
		return outStr;
	}
	
	private static String connector4CompatNFSCountSelectStr = 
		" select " + 
		" informix.resources.resource as id, " +
		" count(informix.nfsresources.segment1) as countnfs, " +
		" min(informix.nfsresources.segment1) as nfsid " +
		" from  " +
		" (informix.resources " +   
		" LEFT JOIN informix.nfsres2nrires ON informix.resources.resource=informix.nfsres2nrires.resource LEFT JOIN informix.nfsresources on informix.nfsres2nrires.item_id=informix.nfsresources.item_id) " +

		" where " + 
		" informix.resources.resourceclass2 = 16 " + 
		" AND " +
		" (informix.nfsres2nrires.datatype='A' OR informix.nfsres2nrires.datatype='U' ) ";

	private static String connector4CompatNFSCountGroupByStr = 
		" group by " +
		" informix.resources.resource ";

	private static String connector4CompatNFSCountOrderByStr = 
		" order by  " +
		" informix.resources.resource asc ";

	public static CDBCResultSet findConnector4CompatNFSCountList(int paramCode, String paramValue) {
		System.out.println("### findConnector4CompatNFSCountList paramCode = "+paramCode+", paramValue = "+paramValue);
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(connector4CompatNFSCountSelectStr);
		sqlb.append(insertCompatWherePart(paramCode, paramValue));
		sqlb.append(connector4CompatNFSCountGroupByStr);
		sqlb.append(connector4CompatNFSCountOrderByStr);
		System.out.println("### findConnector4CompatNFSCountList sqlb = "+sqlb);
		
		if (needComatParameter(paramCode, paramValue)) {
			params.add(paramValue);
		}	

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	private static String cable4CompatSelectStr = 
	" select " + 
	" distinct " +
	" informix.resources.resource as id, " + 
	" trim(informix.organizations.name) as manuf, " + 
	" trim(informix.resources.model) as model,  " +
	" trim(informix.units.name) as unit,  " +
	" trim(informix.resources.active) as active, " + 
	" informix.cableres.cablediamid as diamid, " +
	" informix.cablediameters.diamname as diamname  " +

	" 		from  " +
	" 		((((informix.resources  LEFT JOIN informix.organizations ON informix.resources.manufacturer=informix.organizations.organization) " + 
	" 		LEFT JOIN informix.units ON informix.resources.unit=informix.units.unit)  " +
	" 		LEFT JOIN informix.nfsres2nrires ON informix.resources.resource=informix.nfsres2nrires.resource LEFT JOIN informix.nfsresources on informix.nfsres2nrires.item_id=informix.nfsresources.item_id) " + 
	" 				LEFT JOIN informix.cableres on informix.resources.resource=informix.cableres.resource) " +
	" 				LEFT JOIN informix.cablediameters on informix.cableres.cablediamid=informix.cablediameters.id " +

	" 		where   " +
	" 		informix.resources.resourceclass2 = 2  " +
	" 		AND  " +
	" 		(informix.nfsres2nrires.datatype='A' OR informix.nfsres2nrires.datatype='U' )";
	private static String cable4CompatOrderByStr = 
	" 		order by  " +
	" 		informix.resources.resource asc " ;

	public static CDBCResultSet findCable4CompatList(int paramCode, String paramValue) {
		System.out.println("### findCable4CompatList paramCode = "+paramCode+", paramValue = "+paramValue);
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(cable4CompatSelectStr);
		sqlb.append(insertCompatWherePart(paramCode, paramValue));
		sqlb.append(cable4CompatOrderByStr);
		System.out.println("### findCable4CompatList sqlb = "+sqlb);
		
		if (needComatParameter(paramCode, paramValue)) {
			params.add(paramValue);
		}	

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	private static String cable4CompatNFSCountSelectStr = 
	" select  " +
	" informix.resources.resource as id, " +
	" count(informix.nfsresources.segment1) as countnfs, " +
	" min(informix.nfsresources.segment1) as nfsid " + 

	" from  " +
	" ((informix.resources    " +
	" LEFT JOIN informix.nfsres2nrires ON informix.resources.resource=informix.nfsres2nrires.resource LEFT JOIN informix.nfsresources on informix.nfsres2nrires.item_id=informix.nfsresources.item_id) " +
	" 				LEFT JOIN informix.cableres on informix.resources.resource=informix.cableres.resource) " +

	" where  " +
	" informix.resources.resourceclass2 = 2 " +
	" AND " +
	" (informix.nfsres2nrires.datatype='A' OR informix.nfsres2nrires.datatype='U' ) ";

	private static String cable4CompatNFSCountGroupByStr = 
	" group by " +
	" informix.resources.resource ";

	private static String cable4CompatNFSCountOrderByStr = 
	" order by " + 
	" informix.resources.resource asc "; 

	public static CDBCResultSet findCable4CompatNFSCountList(int paramCode, String paramValue) {
		System.out.println("### findCable4CompatNFSCountList paramCode = "+paramCode+", paramValue = "+paramValue);
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(cable4CompatNFSCountSelectStr);
		sqlb.append(insertCompatWherePart(paramCode, paramValue));
		sqlb.append(cable4CompatNFSCountGroupByStr);
		sqlb.append(cable4CompatNFSCountOrderByStr);
		System.out.println("### findCable4CompatNFSCountList sqlb = "+sqlb);
		
		if (needComatParameter(paramCode, paramValue)) {
			params.add(paramValue);
		}	

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	private static String cableDiamsListSelect = 
	" select " +  
	" informix.cablediameters.id as id, " + 
	" informix.cablediameters.diamname as name, " + 
	" informix.cablediameters.cablediam as diam " + 
	" from informix.cablediameters " +
	" order by informix.cablediameters.cablediam asc ";

	public static CDBCResultSet findCableDiamsList() {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(cableDiamsListSelect);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	private static String resourceCompatSelect = 
	" select resource1, resource2 " +
	" from informix.resourcecompatibility ";

	private static String resourceCompatWhereRes1 = 
	" where " +
	" resource1 = ? ";

	private static String resourceCompatWhereRes2 = 
	" where " +
	" resource2 = ? ";
	
	private static String resourceCompatWhereBoth = 
	" where " +
	" resource1 = ? " + 
	" AND " +
	" resource2  = ? ";
	
	private static String resourceCompatOrderBy = 
	" order by resource1, resource2 ";

	public static CDBCResultSet findResourceCompatList(String res1, String res2, String beginIndex) {
		System.out.println("### findResourceCompatList res1 = "+res1+", res2 = "+res2);
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(resourceCompatSelect);
		if (((res1 != null) && (! "".equals(res1)) && (! beginIndex.equals(res1))) && 
			((res2 != null) && (! "".equals(res2)) && (! beginIndex.equals(res2)))) {
				sqlb.append(resourceCompatWhereBoth);
				params.add(res1);
				params.add(res2);
		} else 
		if (((res1 != null) && (! "".equals(res1)) && (! beginIndex.equals(res1))) && 
		((res2 == null) || ("".equals(res2)) || (beginIndex.equals(res2)))) {
			sqlb.append(resourceCompatWhereRes1);
			params.add(res1);
		} else 
		if (((res2 != null) && (! "".equals(res2)) && (! beginIndex.equals(res2))) && 
		((res1 == null) || ("".equals(res1)) || (beginIndex.equals(res1)))) {
			sqlb.append(resourceCompatWhereRes2);
			params.add(res2);
		} else { // для пустого списка
			sqlb.append(resourceCompatWhereBoth);
			params.add("-9999");
			params.add("-9999");
		}

		sqlb.append(resourceCompatOrderBy);
		System.out.println("### findResourceCompatList sqlb = "+sqlb);

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	private static String insertNewResCompatSQL = 
	" INSERT into informix.resourcecompatibility VALUES (?, ?)";
	
	public static void insertNewResCompat(String connectorIdStr, String cableIdStr) throws SQLException {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(insertNewResCompatSQL);
		params.add(connectorIdStr);
		params.add(cableIdStr);

		CDBCResultSet res = new CDBCResultSet();
		if (! res.executeUpdate(sqlb.toString(), params.toArray())) {
			throw new SQLException("insertNewResCompat executeUpdate error");
		} 
	}
	
	private static String deleteResCompatSQL = 
	" DELETE FROM informix.resourcecompatibility " +
	" where " +
	" resource1 = ? " + 
	" AND " +
	" resource2  = ? ";
	
	/**
	 * @param connectorIdStr
	 * @param cableIdStr
	 */
	public static void deleteResCompat(String connectorIdStr, String cableIdStr) throws SQLException {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append(deleteResCompatSQL);
		params.add(connectorIdStr);
		params.add(cableIdStr);

		CDBCResultSet res = new CDBCResultSet();
		if (! res.executeUpdate(sqlb.toString(), params.toArray())) {
			throw new SQLException("deleteResCompat executeUpdate error");
		} 
	}
	public static String deleteResourceset(Integer resourceset){
		String result = "";
		
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		
		sqlb.append("EXECUTE PROCEDURE deleteResourceSet (?) ");
		params.add(resourceset);
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		
		ListIterator it = res.listIterator();
		
		if (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			result = row.getColumn("col2").asString();
		}
		return result;
	}
	public static CDBCResultSet findAllEquipmanuf(
		Boolean bymanufid,
		Integer manufid,
		Boolean byname,
		String name,
		Boolean byshortname,		
		String shortname,
		Boolean byequipcatalog,
		String equipcatalog,
		Boolean byofficialsite,
		String officialsite
	){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT * FROM equipmanufacturers ");
		SQLClauseBuilder builder = new SQLClauseBuilder();
		builder.setGlueOption("AND");
		StringBuffer clauses = new StringBuffer();
		if (bymanufid.booleanValue())
			if (manufid.intValue()!=0)
				builder.addParametrizedClause("manufid = ?", manufid);
			else
				builder.addClause("manufid = 0");
		if (byname.booleanValue())
			builder.addParametrizedClause("UPPER(name) LIKE UPPER(?)", name);
		if (byshortname.booleanValue())
			builder.addParametrizedClause("UPPER(shortname) LIKE UPPER(?)", shortname);
		if (byequipcatalog.booleanValue())
			builder.addParametrizedClause("UPPER(equipcatalog) LIKE UPPER(?)", equipcatalog);
		if (byofficialsite.booleanValue())
			builder.addParametrizedClause("UPPER(officialsite) LIKE UPPER(?)", officialsite);
		CDBCResultSet res = new CDBCResultSet();
		if (!builder.isEmpty()){
			sqlb.append("WHERE ");
			sqlb.append(builder.glueClauses());
			res.executeQuery(sqlb.toString(), builder.getParamsAsArray());
		}
		else res.executeQuery(sqlb.toString());
		return res;	
	}
	public static CDBCResultSet findAllResourceGroups(
		Boolean bygroupid,
		Integer groupid,
		Boolean byname,
		String name
	){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT * FROM resgroups ");
		SQLClauseBuilder builder = new SQLClauseBuilder();
		builder.setGlueOption("AND");
		StringBuffer clauses = new StringBuffer();
		if (bygroupid.booleanValue())
			if (groupid.intValue()!=0)
				builder.addParametrizedClause("groupid = ?", groupid);
			else
				builder.addClause("groupid = 0");
		if (byname.booleanValue())
			builder.addParametrizedClause("UPPER(name) LIKE UPPER(?)", name);
		CDBCResultSet res = new CDBCResultSet();
		if (!builder.isEmpty()){
			sqlb.append("WHERE ");
			sqlb.append(builder.glueClauses());
			res.executeQuery(sqlb.toString(), builder.getParamsAsArray());
		}
		else res.executeQuery(sqlb.toString());
		return res;	
	}
}
