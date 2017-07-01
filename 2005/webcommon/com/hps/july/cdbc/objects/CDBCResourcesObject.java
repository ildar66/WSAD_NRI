package com.hps.july.cdbc.objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.dictionary.valueobject.AfsSchemeRow;
import com.hps.july.dictionary.valueobject.NFSResourceRow;
import com.hps.july.dictionary.valueobject.ResourceCommonRow;
import com.hps.july.dictionary.valueobject.ResourceclassRow;

/**
 * Объект для работы с ресурсами.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCResourcesObject {
/**
 * CDBCPositionObject constructor comment.
 */
public CDBCResourcesObject() {
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
/**
 * Выдаёт список ресурсов анетенн базовых станций
 */
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
/**
 * Выдаёт список значений питания репитера
 */
public static CDBCResultSet findAllVoltages(){
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	sqlb.append("SELECT voltageid, voltagename FROM voltagelist");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * Выдаёт значение питания по коду значения
 */
public static String findVoltagesByCode(String voltageid){
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	sqlb.append("SELECT voltagename FROM voltagelist WHERE voltageid = "+voltageid);
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	ListIterator it = res.listIterator();
	String voltagename="";
	if (it.hasNext()){
		CDBCRowObject row = (CDBCRowObject) it.next();
		voltagename = row.getColumn("voltagename").asString();
	}
	return voltagename;
}
/**
 * Выдаёт список используемых репитером частот
 */
public static CDBCResultSet findAllUsedBands(){
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	sqlb.append("SELECT bandid, bandname FROM usedbandlist");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}

/**
 * Выдаёт список целочисленных классов ресурсов
 */
public static CDBCResultSet findAllResourceclasses2(){
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	sqlb.append("SELECT classid, classname FROM resourceclasses ");
	sqlb.append("ORDER BY classname");
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}


/**
 * Выдаёт список классов оборудования и комплектов
 */
public static ArrayList findResourceClasses(Boolean complects, Integer order){
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	sqlb.append("SELECT classid, classname FROM ");
	if (complects.booleanValue()) sqlb.append("resourcesetclasses");
	else sqlb.append("resourceclasses");
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append(" ORDER BY classid ASC");
			break;
		case 2:
			sqlb.append(" ORDER BY classid DESC");
			break;
		case 3:
			sqlb.append(" ORDER BY classname ASC");
			break;
		case 4:
			sqlb.append(" ORDER BY classname DESC");
			break;
		}
	}
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	ArrayList array = new ArrayList();
	ListIterator it = res.listIterator();
	while(it.hasNext()){
		CDBCRowObject row = (CDBCRowObject) it.next();
		array.add(new ResourceclassRow(row));
	}
	return array;
}



/**
 * Выдаёт список ресурсов анетенн базовых станций
 */
public CDBCResultSet findAntennesResources(
	Boolean isTypekey, Integer typeKey,
	Boolean isSubtypekey, Integer subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean isNfscode, String nfscode,
	Boolean isNricode, String nricode,
	String show,
	String polarization, /// '*' - все типы, 'C' - кросс, 'V' - вертикальная (если там 1 и 2 то можно и на них заменить)
	Boolean isRange, Integer[] ranges,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, a.entriescount, ");
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

	addNfsParamRoutine(isNfscode, nfscode, sqlb, params);

	addNriParamRoutine(isNricode, nricode, sqlb, params);

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
/**
 * @param isNricode
 * @param nricode
 * @param sqlb
 * @param params
 */
private void addNriParamRoutine(
	Boolean isNricode,
	String nricode,
	StringBuffer sqlb,
	LinkedList params) {
	System.out.println("### isNricode = " + isNricode);
	System.out.println("### nricode = " + nricode);
	if (isNricode != null && isNricode.booleanValue()) {
		if (nricode != null) {
			sqlb.append("AND r.resource = ? ");
			params.add(nricode);
		} else {
			sqlb.append("AND r.resource IS NULL ");
		}
	}
}
/**
 * Выдаёт список ресурсов анетенн базовых станций
 */
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

	sqlb.append("SELECT ar.resource, listnfsres(r.resource) nfslist, r.model, r.name, o.name orgname, ar.polarization ");
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
	Boolean isNfscode, String nfscode,
	Boolean isNricode, String nricode,
	String show,
	Boolean isGeneration, String generation,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, r.active active, ");
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

	addNfsParamRoutine(isNfscode, nfscode, sqlb, params);

	addNriParamRoutine(isNricode, nricode, sqlb, params);

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
	Boolean isNfscode, String nfscode,
	Boolean isNricode, String nricode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, r.active active, ");
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

	addNfsParamRoutine(isNfscode, nfscode, sqlb, params);

	addNriParamRoutine(isNricode, nricode, sqlb, params);

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
	Boolean isNfscode, String nfscode,
	Boolean isNricode, String nricode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, TRIM(r.active) active, ");
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

	addNfsParamRoutine(isNfscode, nfscode, sqlb, params);

	addNriParamRoutine(isNricode, nricode, sqlb, params);

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
	Boolean isManufid, Integer manufid,
	Boolean isManucode, String manucode,
	Integer order,
	Boolean isNfscode, String nfscode)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, r.model model, r.name name, r.manucode manucode, u.shortname shortname, r.countpolicy countpolicy ");
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
	if(isManufid != null && isManufid.booleanValue()) {
		if(manufid != null) {
			sqlb.append("AND r.manufid = ? " );
			params.add(manufid);
		} else {
			sqlb.append("AND r.manufid IS NULL ");
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

	// for NFS code
	addNfsParamRoutine(isNfscode, nfscode, sqlb, params);

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
 * Выдаёт список донорных блоков, соответствующих выбранному
 * репитерному блоку по рабочей и линковой частоте
 */
public static CDBCResultSet findDonorunitsByBands(
	Integer linkband,
	Integer workband)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	
	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, ");
	sqlb.append("d.power, d.workband, d.linkband, d.gainfactor, d.voltageid, d.usedpower, d.entriescount, d.antgatescount, d.signaldelay, d.noisefactor ");
	sqlb.append("FROM resources r, repdonorunitres d, units u, outer organizations o ");
	sqlb.append("WHERE d.resource = r.resource AND r.unit = u.unit AND o.organization = r.manufacturer ");

	if(linkband != null && !"*".equals(linkband)) {
		sqlb.append("AND d.linkband = ? ");
		params.add(linkband);
	}
	if(workband != null && !"*".equals(workband)) {
		sqlb.append("AND d.workband = ? ");
		params.add(workband);
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}


/**
 * Проверяет связь донорного блока с репитером
 */
public static boolean isLinkedRepeaterDU(Integer repeaterres, Integer donorunitres)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();
	
	sqlb.append("SELECT * FROM resourcesets rs, resourcesetparts rsp ");
	sqlb.append("WHERE rs.resourceset=rsp.resourceset ");

	if(repeaterres != null) {
		sqlb.append("AND mainpart = ? ");
		params.add(repeaterres);
	}
	if(donorunitres != null) {
		sqlb.append("AND rsp.resource = ? ");
		params.add(donorunitres);
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return (res.getRowsCount()>0);
}



/**
 * Выдаёт список ресурсов донорных блоков
 */
public CDBCResultSet findDonorunitResources(	
	Boolean isTypekey, Integer typeKey,
	Boolean isSubtypekey, Integer subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean isNfscode, String nfscode,
	Boolean isNricode, String nricode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, ");
	sqlb.append("d.power ");
	sqlb.append("FROM resources r, repdonorunitres d, units u, outer organizations o ");
	sqlb.append("WHERE d.resource = r.resource AND r.unit = u.unit AND o.organization = r.manufacturer ");

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

	addNfsParamRoutine(isNfscode, nfscode, sqlb, params);

	addNriParamRoutine(isNricode, nricode, sqlb, params);

	// ORDER BY
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY model ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY model DESC ");
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
public CDBCResultSet findResourcesBySerial(
	Boolean isSubtypekey, ResourceSubTypeKey subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean isSerial, String serial,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();


	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, r.model model, r.name name, r.manucode manucode, u.shortname shortname, r.countpolicy countpolicy ");
	sqlb.append("FROM resources r, units u ");

	if(isSerial != null && isSerial.booleanValue()) {
		if(serial != null) {
			sqlb.append(",storagecards s " );
		} 
	}
	
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

	if(isSerial != null && isSerial.booleanValue()) {
		if(serial != null) {
			sqlb.append("AND s.serialnumber = ? AND s.resource = r.resource " );
			params.add(serial);
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


	
	
	
	/*sqlb.append("SELECT r.resource resource, r.model model, r.name name, r.manucode manucode, u.shortname shortname, r.countpolicy countpolicy ");
	sqlb.append("FROM resources r, units u ,storagecards s ");
	sqlb.append("WHERE s.serialnumber = ? ");
	sqlb.append("AND s.resource = r.resource AND r.unit = u.unit AND r.active = 'Y' ");
	sqlb.append("ORDER BY r.model ASC");*/
	
	//System.err.println("////// " + sqlb.toString());
		
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
	Boolean isNfscode, String nfscode,
	Boolean isNricode, String nricode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, TRIM(r.manucode) manucode, ");
	sqlb.append("TRIM(u.shortname) shortname, r.countpolicy countpolicy, r.priceable priceable, r.complectpart complectpart, ");
	sqlb.append("r.resourceclass rtype, r.active active ");
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

	addNfsParamRoutine(isNfscode, nfscode, sqlb, params);

	addNriParamRoutine(isNricode, nricode, sqlb, params);
	
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
 * @param isNfscode
 * @param nfscode
 * @param sqlb
 * @param params
 */
private void addNfsParamRoutine(Boolean isNfscode, String nfscode, StringBuffer sqlb, LinkedList params) {
	System.out.println("### isNfscode = "+isNfscode);
	System.out.println("### nfscode = "+nfscode);
	if(isNfscode != null && isNfscode.booleanValue()) {
		if(nfscode != null) {
			sqlb.append("AND r.resource IN ( "+
						"SELECT n1.resource FROM nfsres2nrires n1, nfsresources n2 "+
						"WHERE n2.item_id = n1.item_id AND UPPER(n2.segment1) MATCHES (UPPER(?)) AND n1.datatype IN ('A', 'U') "+
						") ");
			params.add(nfscode);
		} else {
			sqlb.append("AND r.resource IS NULL ");
		}
	}
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
	Boolean isNfscode, String nfscode,
	Boolean isNricode, String nricode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, TRIM(r.manucode) manucode, TRIM(u.shortname) shortname, r.countpolicy countpolicy, r.priceable priceable, r.complectpart complectpart, r.resourceclass rtype ");
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

	addNfsParamRoutine(isNfscode, nfscode, sqlb, params);

	addNriParamRoutine(isNricode, nricode, sqlb, params);

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
 * Выдаёт список ресурсов трансиверов
 */
public CDBCResultSet findTranceiverResources(
	Boolean isTypekey, Integer typeKey,
	Boolean isSubtypekey, Integer subtypeKey,
	Boolean isModel, String model,
	Boolean isName, String name,
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean isNfscode, String nfscode,
	Boolean isNricode, String nricode,
	String show,
	Integer order)
{
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, TRIM(r.model) model, TRIM(r.name) name, NVL(TRIM(r.manucode),'') manucode, NVL(TRIM(o.name),'') manufname, TRIM(r.active) active, ");
	sqlb.append("t.band, t.doubletrx  ");
	sqlb.append("FROM resources r, trxres t, units u, outer organizations o ");
	sqlb.append("WHERE t.resource = r.resource AND r.unit = u.unit AND o.organization = r.manufacturer ");

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

	addNfsParamRoutine(isNfscode, nfscode, sqlb, params);

	addNriParamRoutine(isNricode, nricode, sqlb, params);

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


	sqlb.append("SELECT count(docposition) cnt FROM docpositions WHERE resource = ? ");
	params.add(resource);
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		if(((Number)ro.getColumn("cnt").asObject()).intValue() > 0) {
			return true;
		}
	}

	sqlb = new StringBuffer();
	params = new LinkedList();
	res = new CDBCResultSet();

	sqlb.append("SELECT count(changeactpos) cnt FROM changeactpos cp, resources r WHERE r.resource = ? AND (cp.oldresource = r.resource OR cp.newresource = r.resource)");
	params.add(resource);
	res.executeQuery(sqlb.toString(), params.toArray());
	it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		if(((Number)ro.getColumn("cnt").asObject()).intValue() > 0) {
			return true;
		}
	}

	sqlb = new StringBuffer();
	params = new LinkedList();
	res = new CDBCResultSet();

	sqlb.append("SELECT count(storagecard) cnt FROM storagecards WHERE resource = ? ");
	params.add(resource);
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
/**
 * Проверяет используется ли ресурс с указанным кодом в документах или хранилищах
 */
// public Integer recodeResource(Integer fromResource, Integer toResource)
public Object [] recodeResource(Integer fromResource, Integer toResource)
{
	// Integer result = new Integer(-999);
	Object [] result = new Object[3];
	Integer resultInt = new Integer(-999);
	String  strRes01 = "";
	String  strRes02 = "";
	CDBCResultSet res = new CDBCResultSet();
	// System.out.println("### recodeResource fromResource = "+fromResource+", toResource = "+toResource);
	res.executeQuery("EXECUTE  PROCEDURE recoderesource(?, ?) ", new Object[] {fromResource, toResource});
	System.out.println("### recodeResource After Execute");
	java.util.ListIterator it = res.listIterator();
	if (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		resultInt = (Integer)ro.getColumn("col1").asObject();
		strRes01 = ro.getColumn("col2").asString();
		strRes02 = ro.getColumn("col3").asString();;
	}
	// System.out.println("### recodeResource result = "+result);
	result[0] = resultInt;
	result[1] = strRes01;
	result[2] = strRes02;
	return result;
}

	/******************************************************
	 * Функции для установления связи с ресурсами NFS
	 */

	public static CDBCResultSet findNFSResources(
		Boolean isNFSCode, String argNFSCode,
		Boolean isManucode, String argManucode,
		Boolean isModel, String argModel,
		Boolean isName, String argName,
		Boolean isManuf, String argManuf
	) {
		CDBCResultSet rs = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT item_id a1, segment1 a2, manucode a3, model a4, shortname a5, name a6, \"<IMG SRC='/images/vkl.gif' BORDER=0 onclick='ins();'>\" a7 ");		buf.append("FROM nfsresources WHERE RecordStatus='A' ");
		if (isNFSCode.booleanValue()) {
			buf.append(" AND UPPER(segment1) MATCHES(UPPER(?)) ");
			params.add(argNFSCode);
		}
		if (isManucode.booleanValue()) {
			buf.append(" AND UPPER(manucode) MATCHES(UPPER(?)) ");
			params.add(argManucode);
		}
		if (isModel.booleanValue()) {
			buf.append(" AND UPPER(model) MATCHES(UPPER(?)) ");
			params.add(argModel);
		}
		if (isName.booleanValue()) {
			buf.append(" AND UPPER(name) MATCHES(UPPER(?)) ");
			params.add(argName);
		}
		if (isManuf.booleanValue()) {
			buf.append(" AND UPPER(shortname) MATCHES(UPPER(?)) ");
			params.add(argManuf);
		}
		buf.append("ORDER BY segment1 ");
		System.out.println(buf.toString());
		rs.executeQuery(buf.toString(), params.toArray());
		return rs;
	}
	
	// Нахождение связанных ресурсов NFS
	public static CDBCResultSet findLinkedNFSResources(
		Integer argResource
	) {
		CDBCResultSet rs = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT * FROM nfsresources r, nfsres2nrires n WHERE ");
		buf.append("r.item_id = n.item_id AND n.resource = ? AND n.datatype IN ('A', 'U') ");
		params.add(argResource);
		buf.append("ORDER BY segment1 ");
		rs.executeQuery(buf.toString(), params.toArray());
		return rs;
	}
	// Нахождение ресурса NRI
	public static CDBCResultSet findNRIResource(
		Integer argResource
	) {
		CDBCResultSet rs = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer buf = new StringBuffer();
		buf.append("SELECT r.*, e.shortname orgname ");		buf.append("FROM resources r, outer equipmanufacturers e ");
		buf.append("WHERE r.resource = ? AND e.manufid = r.manufid ");
		params.add(argResource);
		rs.executeQuery(buf.toString(), params.toArray());
		return rs;
	}
	
	public static boolean setNFSLinkedResources(Integer argResource, ArrayList argNFSResources, Integer argUser) {
		boolean result = false;
		Connection con = null;
		try {
			JdbcConnection jcon = new JdbcConnection();
			con = jcon.getConnection();
			con.setAutoCommit(false);
			
			// Mark all resources as Deleted
			CDBCResultSet rs = new CDBCResultSet();
			rs.executeUpdate(con, "UPDATE nfsres2nrires SET datatype='I' WHERE resource=?", new Object[] {argResource});
			Iterator it = argNFSResources.iterator();
			while (it.hasNext()) {
				String code = (String)it.next();
				rs.executeUpdate(con, "INSERT INTO nfsres2nrires (resource, item_id, datatype, createdby) " +
					"VALUES (?, ?, ?, ?)", new Object[] {argResource, code, "U", argUser});			
				rs.executeUpdate(con, "UPDATE nfsres2nrires SET datatype = ?, createdby = ? " +
					"WHERE resource = ? AND item_id = ?", new Object[] {"U", argUser, argResource, code});			
			}
			con.commit();
			result = true;
		} catch (Exception e) {
			try {con.rollback();} catch (Exception ee) {}
			e.printStackTrace(System.out);
		} finally {
			try {
				con.setAutoCommit(true);
				con.close();
			} catch (Exception ee) {}
		}
		return result;
	}
	
	public static String getFullStorageName(String eqCode, int withPosition) {
		String result = "";
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery("EXECUTE  PROCEDURE getFullStorageName(?, ?) ", new Object[] {eqCode, new Integer(withPosition)});
		java.util.ListIterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			result = ro.getColumn("col1").asString();
		}
		return result;
	}
	
	private static String nriResourceSelect =
	// " SELECT '' AS nullCol, informix.resources.resource AS nriCode, " + 
	" SELECT informix.resources.resource AS a_nriCode, " + 
	" Trim(informix.resources.name) AS b_resourceName, " + 
	" Trim(informix.resources.model) AS c_model " + 
	" , " +
	// " Trim(informix.units.shortname) AS unit_name " + 
	" Trim(informix.units.name) AS unit_name " + 
	" FROM informix.resources " +
	" LEFT JOIN informix.units ON informix.resources.unit = informix.units.unit ";
	private static String nriResourceWhereModel =
		" WHERE (UPPER(informix.resources.model) MATCHES UPPER(?)) ";
	private static String nriResourceWhereName =
		" WHERE (UPPER(informix.resources.name) MATCHES UPPER(?)) ";
	private static String nriResourceWhereNRICode =
		" WHERE (informix.resources.resource = ?) ";
	private static String nriResourceOrderBy =
		" ORDER BY informix.resources.resource ";
	
	/**
	 * @param isModel
	 * @param isName
	 * @param isNRICode
	 * @param searchparam
	 * @return
	 */
	public static CDBCResultSet findNRIResources(Boolean isModel, Boolean isName, Boolean isNRICode, String searchparam) {
		CDBCResultSet rs = new CDBCResultSet();
		ArrayList params = new ArrayList();
		StringBuffer buf = new StringBuffer(nriResourceSelect);
		if (isModel.booleanValue()) {
			buf.append(nriResourceWhereModel);
			params.add(searchparam);
		} else if (isName.booleanValue()) {
			buf.append(nriResourceWhereName);
			params.add(searchparam);
		} else if (isNRICode.booleanValue()) {
			buf.append(nriResourceWhereNRICode);
			params.add(searchparam);
		}
		buf.append(nriResourceOrderBy);
		System.out.println(buf.toString());
		rs.executeQuery(buf.toString(), params.toArray());
		return rs;
	}
	/**
	 * Возвращает ресурсы согласно заданным параметрам (новая версия справочника)
	 */
	public ArrayList findResourcesCommon(
		Integer resclass,
		Boolean isname, String name,
		Boolean ismanuf, Integer manuf,
		Boolean ismodel, String model,
		Boolean ismanucode, String manucode,
		Boolean isnfscode, String nfscode,
		Boolean isnricode, String nricode,
		String show,
		Integer order,
		Boolean donotrefresh
	){
		ArrayList list = new ArrayList();
		if (donotrefresh.booleanValue()) return list;

		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, NVL(TRIM(r.manucode),'') manucode, TRIM(r.model) model, "); 
		sqlb.append("TRIM(r.active) active, TRIM(r.name) name, u.shortname unit, r.countpolicy countpolicy, r.disablenfscodes disablenfscodes ");
		//sqlb.append("FROM resources r, outer units u, outer organizations o ");
		//sqlb.append("WHERE r.unit = u.unit AND o.organization = r.manufacturer ");
		sqlb.append("FROM resources r, outer units u, outer equipmanufacturers m ");
		sqlb.append("WHERE r.unit = u.unit AND m.manufid = r.manufid ");

		if(resclass != null) {
			sqlb.append("AND r.resourceclass2 = ? ");
			params.add(resclass);
		}

		if(show != null && !"*".equals(show)) {
			sqlb.append("AND r.active = ? ");
			params.add(show);
		}

		if(ismodel != null && ismodel.booleanValue()) {
			if(model != null) {
				sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
				params.add(model);
			} else {
				sqlb.append("AND r.model IS NULL ");
			}
		}
		if(isname != null && isname.booleanValue()) {
			if(name != null) {
				sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
				params.add(name);
			} else {
				sqlb.append("AND r.name IS NULL ");
			}
		}
		/*
		if(ismanuf != null && ismanuf.booleanValue()) {
			if(manuf != null) {
				sqlb.append("AND r.manufacturer = ? " );
				params.add(manuf);
			} else {
				sqlb.append("AND r.manufacturer IS NULL ");
			}
		}
		*/
		if(ismanuf != null && ismanuf.booleanValue()) {
			if(manuf != null) {
				sqlb.append("AND r.manufid = ? " );
				params.add(manuf);
			} else {
				sqlb.append("AND r.manufid IS NULL ");
			}
		}

		if(ismanucode != null && ismanucode.booleanValue()) {
			if(manucode != null) {
				sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
				params.add(manucode);
			} else {
				sqlb.append("AND r.manucode IS NULL ");
			}
		}

		addNfsParamRoutine(isnfscode, nfscode, sqlb, params);

		addNriParamRoutine(isnricode, nricode, sqlb, params);

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
		ListIterator it = res.listIterator();
		while (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			list.add(new ResourceCommonRow(row));
		}
		return list;
	}	
	public ArrayList findAfsSchemes(){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT schemeid, numscheme, sectcount900, sectcount1800, antx2, antx4, ");
		sqlb.append("antv1, antv2, dbc1, dbc2, df1, df2, tma, jo, ji, con, notes ");
		sqlb.append("FROM confafsschemes ");
		sqlb.append("ORDER BY numscheme ");
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		ArrayList list = new ArrayList();
		ListIterator it = res.listIterator();
		while (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			list.add(new AfsSchemeRow(row));
		}
		return list;
	}
	public static String getManufnameByManufid(Integer manufid){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT * FROM equipmanufacturers WHERE manufid = ? ");
		params.add(manufid);
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator it = res.listIterator();
		String result = "";
		if (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			if (row.hasColumn("shortname"))
				result = row.getColumn("shortname").asString();
		}
		return result;
	}
	public static String getGroupnameByGroupid(Integer groupid){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		sqlb.append("SELECT * FROM resgroups WHERE groupid = ? ");
		params.add(groupid);
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		ListIterator it = res.listIterator();
		String result = "";
		if (it.hasNext()){
			CDBCRowObject row = (CDBCRowObject) it.next();
			if (row.hasColumn("name"))
				result = row.getColumn("name").asString();
		}
		return result;
	}
	/**
	 * Возвращает ресурсы согласно заданным параметрам (отчет о ресурсах)
	 */
	public CDBCResultSet buildResourceReport(
		Boolean isname, String name,
		Boolean ismanuf, Integer manuf,
		Boolean ismodel, String model,
		Boolean ismanucode, String manucode,
		Boolean isnfscode, String nfscode,
		Boolean isnricode, String nricode,
		String show,
		Integer order,
		Boolean initialsort
	){
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();

		sqlb.append("SELECT r.resource resource, listnfsres(r.resource) nfslist, NVL(TRIM(r.manucode),'') manucodelst, TRIM(r.model) modellst, "); 
		sqlb.append("TRIM(r.active) active, TRIM(r.name) namelst, u.shortname unit, r.countpolicy countpolicy, r.disablenfscodes disablenfscodes, ");
		sqlb.append("TRIM(m.shortname) manufname, rc.classid classid, TRIM(rc.classname) classname ");
		sqlb.append("FROM resources r, outer units u, outer equipmanufacturers m, outer resourceclasses rc ");
		sqlb.append("WHERE r.unit = u.unit AND m.manufid = r.manufid AND rc.classid = r.resourceclass2 ");

		if(show != null && !"*".equals(show)) {
			sqlb.append("AND r.active = ? ");
			params.add(show);
		}

		if(ismodel != null && ismodel.booleanValue()) {
			if(model != null) {
				sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
				params.add(model);
			} else {
				sqlb.append("AND r.model IS NULL ");
			}
		}
		if(isname != null && isname.booleanValue()) {
			if(name != null) {
				sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
				params.add(name);
			} else {
				sqlb.append("AND r.name IS NULL ");
			}
		}
		if(ismanuf != null && ismanuf.booleanValue()) {
			if(manuf != null) {
				sqlb.append("AND r.manufid = ? " );
				params.add(manuf);
			} else {
				sqlb.append("AND r.manufid IS NULL ");
			}
		}

		if(ismanucode != null && ismanucode.booleanValue()) {
			if(manucode != null) {
				sqlb.append("AND UPPER(r.manucode) MATCHES UPPER(?) ");
				params.add(manucode);
			} else {
				sqlb.append("AND r.manucode IS NULL ");
			}
		}

		addNfsParamRoutine(isnfscode, nfscode, sqlb, params);

		addNriParamRoutine(isnricode, nricode, sqlb, params);

		// ORDER BY
		if (initialsort.booleanValue()){
			sqlb.append("ORDER BY classname ASC, resource ASC ");
		}
		else if(order != null) {
			switch( order.intValue() ) {
			case 1:
				sqlb.append("ORDER BY classid ASC ");
				break;
			case 2:
				sqlb.append("ORDER BY classid DESC ");
				break;
			case 3:
				sqlb.append("ORDER BY classname ASC ");
				break;
			case 4:
				sqlb.append("ORDER BY classname DESC ");
				break;
			case 5:
				sqlb.append("ORDER BY resource ASC ");
				break;
			case 6:
				sqlb.append("ORDER BY resource DESC ");
				break;
			case 7:
				sqlb.append("ORDER BY manucode ASC ");
				break;
			case 8:
				sqlb.append("ORDER BY manucode DESC ");
				break;
			case 9:
				sqlb.append("ORDER BY model ASC ");
				break;
			case 10:
				sqlb.append("ORDER BY model DESC ");
				break;
			case 11:
				sqlb.append("ORDER BY name ASC ");
				break;
			case 12:
				sqlb.append("ORDER BY name DESC ");
				break;
			case 13:
				sqlb.append("ORDER BY manufname ASC ");
				break;
			case 14:
				sqlb.append("ORDER BY manufname DESC ");
				break;
			}
		}
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}	
}


