package com.hps.july.cdbc.objects;

import java.util.LinkedList;
import com.hps.july.persistence.ResourceSubTypeKey;
import com.hps.july.cdbc.lib.*;

/**
 * Объект для работы с карточками хранения.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCStoragecardsObject {
public CDBCStoragecardsObject() {
	super();
}
public static int changeSerial(int storagecard, String newSerial, boolean useOwnTransaction)
{
	CDBCResultSet rs = new CDBCResultSet();
	
	rs.executeQuery(
		"EXECUTE PROCEDURE setrealserial(?,?,?)",
		new Object[] {
			new Integer(storagecard),
			newSerial,
			useOwnTransaction?new Integer(1):new Integer(0)
		}
	);

	java.util.Iterator it = rs.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Number n = (Number)ro.getColumn("col1").asObject();
		if(n != null) {
			return n.intValue();
		} else {
			return -1;
		}
	} else {
		return -1;
	}
}
public CDBCResultSet findAgregates(Integer storageplace) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT sc.storagecard, TRIM(r.name) name, TRIM(r.model) model, sc.policy, serial_for_sc(sc.storagecard) invnum, sc.serialnumber, sc.inventserial manufserial, sc.party, ac.qty, sc.place ");
	sqlb.append("FROM agregatecontents ac, storagecards sc, resources r ");
	sqlb.append("WHERE ac.agregatepart = sc.storagecard AND sc.resource = r.resource AND sc.closed = 'N' ");
	if(storageplace != null) {
		sqlb.append("AND ac.agregate = ? ");
		params.add(storageplace);
	} else {
		sqlb.append("AND ac.agregate = ? ");
	}
	sqlb.append("ORDER BY policy DESC, name ASC, model ASC, serialnumber ASC, inventserial ASC, party ASC, qty ASC, place ASC ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public static String findBySerial(String serialnumber) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT serial_for_sc(sc.storagecard) sn FROM storagecards sc ");
	sqlb.append("WHERE sc.policy = 'S' ");
	if(serialnumber != null) {
		sqlb.append("AND sc.serialnumber = ? ");
		params.add(serialnumber);
	} else {
		sqlb.append("AND sc.serialnumber <> sc.serialnumber ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		return ro.getColumn("sn").asString();
	} else {
		return "н/д";
	}
}
public static String findBySerial(java.sql.Connection con, String serialnumber) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT serial_for_sc(sc.storagecard) sn FROM storagecards sc ");
	sqlb.append("WHERE sc.policy = 'S' ");
	if(serialnumber != null) {
		sqlb.append("AND sc.serialnumber = ? ");
		params.add(serialnumber);
	} else {
		sqlb.append("AND sc.serialnumber <> sc.serialnumber ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(con, sqlb.toString(), params.toArray(), 0);
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		return ro.getColumn("sn").asString();
	} else {
		return "н/д";
	}
}
public static String findBySerial4SC(String serialnumber) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT serial_for_sc(sc.storagecard) sn FROM storagecards sc ");
	sqlb.append("WHERE sc.policy = 'S' ");
	if(serialnumber != null) {
		sqlb.append("AND sc.serialnumber = ? ");
		params.add(serialnumber);
	} else {
		sqlb.append("AND sc.serialnumber <> sc.serialnumber ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		return ro.getColumn("sn").asString();
	} else {
		return "н/д";
	}
}
public static int findBySerialM(java.sql.Connection con, String serialnumber) {
	StringBuffer result = new StringBuffer();
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT * FROM storagecards sc ");
	sqlb.append("WHERE sc.policy = 'S' ");
	if(serialnumber != null) {
		sqlb.append("AND sc.serialnumber = ? ");
		params.add(serialnumber);
	} else {
		sqlb.append("AND sc.serialnumber <> sc.serialnumber ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(con, sqlb.toString(), params.toArray(), 0);
	java.util.Iterator it = res.listIterator();
	/*while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		result.append(ro.getColumn("sn").asString()).append(" - ");
	}*/

	return res.getRowsCount();
}

public static int findBySerialM4Change(java.sql.Connection con, String serialnumber, String resource) {
	StringBuffer result = new StringBuffer();
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT * FROM storagecards sc ");
	sqlb.append("WHERE sc.policy = 'S' ");
	sqlb.append(" AND sc.resource =  ? ");
	params.add(resource);
	if(serialnumber != null) {
		sqlb.append("AND sc.serialnumber = ? ");
		params.add(serialnumber);
	} else {
		sqlb.append("AND sc.serialnumber <> sc.serialnumber ");
	}

	System.out.println("### findBySerialM4Change serialnumber = "+serialnumber);
	System.out.println("### findBySerialM4Change resource = "+resource);
	System.out.println("### findBySerialM4Change sqlb = "+sqlb);

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(con, sqlb.toString(), params.toArray(), 0);
	java.util.Iterator it = res.listIterator();

	return res.getRowsCount();
}

/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findRealStorageCards(
	Integer storageplace,
	Boolean isOwner, Integer owner,
	Boolean isAgregate, Integer agregate,
	Boolean isResource, Integer resource,
	Boolean isSubType, Integer resourceSubType,
	Boolean isModel, String model, 
	Boolean isName, String name, 
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean onlyWithoutParts,
	Integer brokenType,
	Integer documentKey,
	Boolean useExcludeFilter, Integer storageCard,
	Boolean usePolicy, String policy,
	Integer order
) {
	return findSC(
		storageplace,
		isOwner,owner,
		isAgregate, agregate,
		isResource, resource,
		isSubType, resourceSubType,
		isModel, model,
		isName, name,
		isManufacturer, manufacturer,
		isManucode, manucode,
		onlyWithoutParts,
		brokenType,
		documentKey,
		useExcludeFilter, storageCard,
		usePolicy, policy,
		true,
		order
	);
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findRealStorageCards(
	Integer storageplace,
	Boolean isOwner, Integer owner,
	Boolean isAgregate, Integer agregate,
	Boolean isResource, Integer resource,
	Boolean isSubType, Integer resourceSubType,
	Boolean isModel, String model, 
	Boolean isName, String name, 
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean isSer, String serialnum,
	Boolean onlyWithoutParts,
	Integer brokenType,
	Integer documentKey,
	Boolean useExcludeFilter, Integer storageCard,
	Boolean usePolicy, String policy,
	Integer order
) {
	return findSC(
		storageplace,
		isOwner,owner,
		isAgregate, agregate,
		isResource, resource,
		isSubType, resourceSubType,
		isModel, model,
		isName, name,
		isManufacturer, manufacturer,
		isManucode, manucode,
		isSer, serialnum,
		onlyWithoutParts,
		brokenType,
		documentKey,
		useExcludeFilter, storageCard,
		usePolicy, policy,
		true,
		order
	);
}
public static String findResourceIdentityByDP(int docpos) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT NVL(TRIM(r.name) || ', ' || TRIM(r.model), TRIM(r.name)) || ' [' || serial_for_docpos(dp.storagecard) || ']' reside ");
	sqlb.append("FROM docposition dp, resources r ");
	sqlb.append("WHERE dp.resource = r.resource AND dp.docposition = ? ");

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		return ro.getColumn("reside").asString();
	} else {
		return "н/д";
	}
}
public static String findResourceIdentityBySerial(String serialnumber) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT NVL(TRIM(r.name) || ', ' || TRIM(r.model), TRIM(r.name)) || ' [' || serial_for_sc(sc.storagecard) || ']' reside ");
	sqlb.append("FROM storagecards sc, resources r ");
	sqlb.append("WHERE sc.resource = r.resource AND sc.policy = 'S' ");
	if(serialnumber != null) {
		sqlb.append("AND sc.serialnumber = ? ");
		params.add(serialnumber);
	} else {
		sqlb.append("AND sc.serialnumber <> sc.serialnumber ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		return ro.getColumn("reside").asString();
	} else {
		if(serialnumber != null) {
			return "с/н: "+serialnumber;		
		} else {
			return "н/д";
		}
	}
}

/**
 * Форматирование строки [ресурс, сер. номер]
 * @param serialnumber
 * @return
 */
public static String formatResourceName(int resource, String serialnumber) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT NVL(TRIM(r.name) || ', ' || TRIM(r.model), TRIM(r.name)) || ' [' || serial_for_sc(sc.storagecard) || ']' reside ");
	sqlb.append("FROM storagecards sc, resources r ");
	sqlb.append("WHERE sc.resource = r.resource AND sc.policy = 'S' ");
	if(serialnumber != null) {
		sqlb.append("AND sc.serialnumber = ? ");
		params.add(serialnumber);
	} else {
		sqlb.append("AND sc.serialnumber <> sc.serialnumber ");
	}
	sqlb.append("AND sc.resource = ? ");
	params.add(new Integer(resource));

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		return ro.getColumn("reside").asString();
	} else {
		if(serialnumber != null) {
			return "с/н: "+serialnumber;		
		} else {
			return "н/д";
		}
	}
}

/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findSC(
	Integer storageplace,
	Boolean isOwner, Integer owner,
	Boolean isAgregate, Integer agregate,
	Boolean isResource, Integer resource,
	Boolean isSubType, Integer resourceSubType,
	Boolean isModel, String model, 
	Boolean isName, String name, 
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean onlyWithoutParts,
	Integer brokenType,
	Integer documentKey,
	Boolean useExcludeFilter, Integer storageCard,
	Boolean usePolicy, String policy,
	boolean realOnly,
	Integer order
) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT sc.storagecard, sc.owner, TRIM(o.name) ownername, sc.resource, TRIM(r.name) resname, TRIM(r.model) resmodel, TRIM(sc.configuration) resconfig, sc.policy, TRIM(sc.serialnumber) serial, TRIM(sc.party) party, TRIM(sc.inventserial) manuf, TRIM(sc.place) place, ");
	sqlb.append("sc.isfictserial, serial_for_sc(sc.storagecard) invnum, ");
	sqlb.append("sc.qty, sc.qty_broken, ");
	sqlb.append("(SELECT sum(a.qty) FROM agregatecontents a WHERE a.agregatepart = sc.storagecard) agrqty, ");
	if(documentKey != null && documentKey.intValue() > 0) {
		sqlb.append("CASE sc.policy ");
		sqlb.append("WHEN 'S' THEN (SELECT dp.qty FROM docpositions dp WHERE dp.document = ? AND dp.serialnumber = sc.serialnumber) ");
		sqlb.append("WHEN 'P' THEN (SELECT dp.qty FROM docpositions dp WHERE dp.document = ? AND dp.party = sc.party AND dp.owner = sc.owner) ");
		sqlb.append("WHEN 'B' THEN (SELECT dp.qty FROM docpositions dp WHERE dp.document = ? AND dp.resource = sc.resource AND dp.owner = sc.owner) ");
		sqlb.append("ELSE NULL ");
		sqlb.append("END docqty, ");
		params.add(documentKey);	
		params.add(documentKey);	
		params.add(documentKey);	
	} else {
		sqlb.append("CAST(NULL AS DECIMAL) docqty, ");
	}
	sqlb.append("(SELECT a.agregate FROM agregatecontents a WHERE a.agregatepart = sc.storagecard) agregate, ");
	sqlb.append("sc.price price ");
	sqlb.append("FROM storagecards sc, resources r, organizations o ");
	sqlb.append("WHERE sc.resource = r.resource AND sc.owner = o.organization AND sc.closed = 'N' ");

	if(storageplace != null) {
		sqlb.append("AND sc.storageplace = ? ");
		params.add(storageplace);
	} else {
		sqlb.append("AND sc.storageplace IS NULL ");
	}

	if(isOwner != null && isOwner.booleanValue()) {
		sqlb.append("AND sc.owner = ? " );
		params.add(owner);
	}

	if(isAgregate != null && isAgregate.booleanValue() && agregate != null) {
		sqlb.append("AND sc.storagecard IN (SELECT agregatepart FROM agregatecontents WHERE agregate = ?) ");
		params.add(agregate);
	}

	if(isResource != null && isResource.booleanValue()) {
		sqlb.append("AND sc.resource = ? ");
		params.add(resource);
	} else {
		if(isSubType != null && isSubType.booleanValue()) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(resourceSubType);
		}
		if(isModel != null && isModel.booleanValue()) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		}
		if(isName != null && isName.booleanValue()) {
			sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
			params.add(name);
		}
		if(isManufacturer != null && isManufacturer.booleanValue()) {
			sqlb.append("AND r.manufacturer = ? ");
			params.add(manufacturer);
		}
		if(isManucode != null && isManucode.booleanValue()) {
			sqlb.append("AND UPPER(manucode) MATCHES UPPER(?) ");
		}
	}

	if(onlyWithoutParts != null && onlyWithoutParts.booleanValue()) {
		sqlb.append("AND sc.qty > NVL((SELECT sum(a.qty) FROM agregatecontents a WHERE a.agregatepart = sc.storagecard),0) ");
	}

	if(brokenType != null) {
		if(brokenType.intValue() == 1) {
			sqlb.append("AND sc.broken = 'N' ");
		}
		if(brokenType.intValue() == 2) {
			sqlb.append("AND sc.broken = 'Y' ");
		}
	}

	if(documentKey != null && documentKey.intValue() > 0) {
		sqlb.append("AND (( ");
		sqlb.append("sc.policy = 'S' AND sc.serialnumber NOT IN (SELECT NVL(d.serialnumber,'') FROM docpositions d WHERE d.document = ?) ");
		sqlb.append(") OR ( ");
		sqlb.append("sc.policy = 'P' AND ( (sc.party NOT IN (SELECT NVL(d.party,'') FROM docpositions d WHERE d.document = ? AND d.owner = sc.owner) ) OR (sc.qty > (SELECT sum(d.qty) FROM docpositions d WHERE d.party = sc.party AND d.owner = sc.owner AND d.document=?))) ");
		sqlb.append(") OR ( ");
		sqlb.append("sc.policy = 'B' AND ((sc.resource NOT IN (SELECT d.resource FROM docpositions d WHERE d.document = ? AND d.owner = sc.owner) ) OR (sc.qty > (SELECT sum(d.qty) FROM docpositions d WHERE d.resource = sc.resource AND d.owner = sc.owner AND d.document=?))) ");
		sqlb.append(")) ");

		for(int i0 = 0; i0 < 5; i0++) params.add(documentKey);
	}

	if(useExcludeFilter != null && useExcludeFilter.booleanValue()) {
		sqlb.append("AND sc.storagecard <> ? ");
		params.add(storageCard);
	}

	if(usePolicy != null && usePolicy.booleanValue()) {
		sqlb.append("AND sc.policy = ? ");
		params.add(policy);
	}

	if(realOnly) {
		sqlb.append("AND sc.isfictserial = 'N' ");
	}

	/*
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY serial ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY serial DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY party ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY party DESC ");
			break;
		}
	}
	*/
	sqlb.append("ORDER BY resname, resmodel, resconfig, serial, party, manuf, ownername ");

//System.out.println("CARD SQL:\n\n"+sqlb.toString()+"\n\n");
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findSC(
	Integer storageplace,
	Boolean isOwner, Integer owner,
	Boolean isAgregate, Integer agregate,
	Boolean isResource, Integer resource,
	Boolean isSubType, Integer resourceSubType,
	Boolean isModel, String model, 
	Boolean isName, String name, 
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean isSer, String serialnum,
	Boolean onlyWithoutParts,
	Integer brokenType,
	Integer documentKey,
	Boolean useExcludeFilter, Integer storageCard,
	Boolean usePolicy, String policy,
	boolean realOnly,
	Integer order
) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT sc.storagecard, sc.owner, TRIM(o.name) ownername, sc.resource, TRIM(r.name) resname, TRIM(r.model) resmodel, TRIM(sc.configuration) resconfig, sc.policy, TRIM(sc.serialnumber) serial, TRIM(sc.party) party, TRIM(sc.inventserial) manuf, TRIM(sc.place) place, ");
	sqlb.append("sc.isfictserial, serial_for_sc(sc.storagecard) invnum, ");
	sqlb.append("sc.qty, sc.qty_broken, ");
	sqlb.append("(SELECT sum(a.qty) FROM agregatecontents a WHERE a.agregatepart = sc.storagecard) agrqty, ");
	if(documentKey != null && documentKey.intValue() > 0) {
		sqlb.append("CASE sc.policy ");
		sqlb.append("WHEN 'S' THEN (SELECT dp.qty FROM docpositions dp WHERE dp.document = ? AND dp.serialnumber = sc.serialnumber) ");
		sqlb.append("WHEN 'P' THEN (SELECT dp.qty FROM docpositions dp WHERE dp.document = ? AND dp.party = sc.party AND dp.owner = sc.owner) ");
		sqlb.append("WHEN 'B' THEN (SELECT dp.qty FROM docpositions dp WHERE dp.document = ? AND dp.resource = sc.resource AND dp.owner = sc.owner) ");
		sqlb.append("ELSE NULL ");
		sqlb.append("END docqty, ");
		params.add(documentKey);	
		params.add(documentKey);	
		params.add(documentKey);	
	} else {
		sqlb.append("CAST(NULL AS DECIMAL) docqty, ");
	}
	sqlb.append("(SELECT a.agregate FROM agregatecontents a WHERE a.agregatepart = sc.storagecard) agregate, ");
	sqlb.append("sc.price price ");
	sqlb.append("FROM storagecards sc, resources r, organizations o ");
	sqlb.append("WHERE sc.resource = r.resource AND sc.owner = o.organization AND sc.closed = 'N' ");

	if(storageplace != null) {
		sqlb.append("AND sc.storageplace = ? ");
		params.add(storageplace);
	} else {
		sqlb.append("AND sc.storageplace IS NULL ");
	}

	if(isOwner != null && isOwner.booleanValue()) {
		sqlb.append("AND sc.owner = ? " );
		params.add(owner);
	}

	if(isAgregate != null && isAgregate.booleanValue() && agregate != null) {
		sqlb.append("AND sc.storagecard IN (SELECT agregatepart FROM agregatecontents WHERE agregate = ?) ");
		params.add(agregate);
	}

	if(isResource != null && isResource.booleanValue()) {
		sqlb.append("AND sc.resource = ? ");
		params.add(resource);
	} else {
		if(isSubType != null && isSubType.booleanValue()) {
			sqlb.append("AND r.resourcesubtype = ? ");
			params.add(resourceSubType);
		}
		if(isModel != null && isModel.booleanValue()) {
			sqlb.append("AND UPPER(r.model) MATCHES UPPER(?) ");
			params.add(model);
		}
		if(isName != null && isName.booleanValue()) {
			sqlb.append("AND UPPER(r.name) MATCHES UPPER(?) ");
			params.add(name);
		}
		if(isManufacturer != null && isManufacturer.booleanValue()) {
			sqlb.append("AND r.manufacturer = ? ");
			params.add(manufacturer);
		}
		if(isManucode != null && isManucode.booleanValue()) {
			sqlb.append("AND UPPER(manucode) MATCHES UPPER(?) ");
		}
	}
	if(isSer != null && isSer.booleanValue()) {
		sqlb.append("AND UPPER(sc.serialnumber) MATCHES UPPER(?) ");
		params.add(serialnum);
	}

	if(onlyWithoutParts != null && onlyWithoutParts.booleanValue()) {
		sqlb.append("AND sc.qty > NVL((SELECT sum(a.qty) FROM agregatecontents a WHERE a.agregatepart = sc.storagecard),0) ");
	}

	if(brokenType != null) {
		if(brokenType.intValue() == 1) {
			sqlb.append("AND sc.broken = 'N' ");
		}
		if(brokenType.intValue() == 2) {
			sqlb.append("AND sc.broken = 'Y' ");
		}
	}

	if(documentKey != null && documentKey.intValue() > 0) {
		sqlb.append("AND (( ");
		sqlb.append("sc.policy = 'S' AND sc.serialnumber NOT IN (SELECT NVL(d.serialnumber,'') FROM docpositions d WHERE d.document = ?) ");
		sqlb.append("OR sc.resource NOT IN (SELECT d.resource FROM docpositions d WHERE d.document = ?) ");
		sqlb.append(") OR ( ");
		sqlb.append("sc.policy = 'P' AND ( (sc.party NOT IN (SELECT NVL(d.party,'') FROM docpositions d WHERE d.document = ? AND d.owner = sc.owner) ) OR (sc.qty > (SELECT sum(d.qty) FROM docpositions d WHERE d.party = sc.party AND d.owner = sc.owner AND d.document=?))) ");
		sqlb.append(") OR ( ");
		sqlb.append("sc.policy = 'B' AND ((sc.resource NOT IN (SELECT d.resource FROM docpositions d WHERE d.document = ? AND d.owner = sc.owner) ) OR (sc.qty > (SELECT sum(d.qty) FROM docpositions d WHERE d.resource = sc.resource AND d.owner = sc.owner AND d.document=?))) ");
		sqlb.append(")) ");

		for(int i0 = 0; i0 < 6; i0++) params.add(documentKey);
	}

	if(useExcludeFilter != null && useExcludeFilter.booleanValue()) {
		sqlb.append("AND sc.storagecard <> ? ");
		params.add(storageCard);
	}

	if(usePolicy != null && usePolicy.booleanValue()) {
		sqlb.append("AND sc.policy = ? ");
		params.add(policy);
	}

	if(realOnly) {
		sqlb.append("AND sc.isfictserial = 'N' ");
	}

	/*
	if(order != null) {
		switch( order.intValue() ) {
		case 1:
			sqlb.append("ORDER BY serial ASC ");
			break;
		case 2:
			sqlb.append("ORDER BY serial DESC ");
			break;
		case 3:
			sqlb.append("ORDER BY party ASC ");
			break;
		case 4:
			sqlb.append("ORDER BY party DESC ");
			break;
		}
	}
	*/
	sqlb.append("ORDER BY resname, resmodel, resconfig, serial, party, manuf, ownername ");

System.out.println("------CARD SQL:\n\n"+sqlb.toString()+"\n\n");
		
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	return res;
}
public static String findSerial4DP(int docposition) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT serial_for_docpos(dp.docposition) sn FROM docpositions dp ");
	sqlb.append("WHERE dp.docposition = ? ");
	params.add(new Integer(docposition));

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		return ro.getColumn("sn").asString();
	} else {
		return "н/д";
	}
}
public static String findSerialBySC(int storagecard) {
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT serial_for_sc(sc.storagecard) sn FROM storagecards sc ");
	sqlb.append("WHERE sc.policy = 'S' AND sc.closed = 'N' AND sc.storagecard = ? ");
	params.add(new Integer(storagecard));

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		return ro.getColumn("sn").asString();
	} else {
		return "н/д";
	}
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findStorageCards(
	Integer storageplace,
	Boolean isOwner, Integer owner,
	Boolean isAgregate, Integer agregate,
	Boolean isResource, Integer resource,
	Boolean isSubType, Integer resourceSubType,
	Boolean isModel, String model, 
	Boolean isName, String name, 
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean onlyWithoutParts,
	Integer brokenType,
	Integer documentKey,
	Boolean useExcludeFilter, Integer storageCard,
	Boolean usePolicy, String policy,
	Integer order
) {
	return findSC(
		storageplace,
		isOwner,owner,
		isAgregate, agregate,
		isResource, resource,
		isSubType, resourceSubType,
		isModel, model,
		isName, name,
		isManufacturer, manufacturer,
		isManucode, manucode,
		onlyWithoutParts,
		brokenType,
		documentKey,
		useExcludeFilter, storageCard,
		usePolicy, policy,
		false,
		order
	);
}
/**
 * @TODO: Написать описание параметров
 */
public CDBCResultSet findStorageCards(
	Integer storageplace,
	Boolean isOwner, Integer owner,
	Boolean isAgregate, Integer agregate,
	Boolean isResource, Integer resource,
	Boolean isSubType, Integer resourceSubType,
	Boolean isModel, String model, 
	Boolean isName, String name, 
	Boolean isManufacturer, Integer manufacturer,
	Boolean isManucode, String manucode,
	Boolean isSer, String serialnum,
	Boolean onlyWithoutParts,
	Integer brokenType,
	Integer documentKey,
	Boolean useExcludeFilter, Integer storageCard,
	Boolean usePolicy, String policy,
	Integer order
) {
	return findSC(
		storageplace,
		isOwner,owner,
		isAgregate, agregate,
		isResource, resource,
		isSubType, resourceSubType,
		isModel, model,
		isName, name,
		isManufacturer, manufacturer,
		isManucode, manucode,
		isSer, serialnum,
		onlyWithoutParts,
		brokenType,
		documentKey,
		useExcludeFilter, storageCard,
		usePolicy, policy,
		false,
		order
	);
}
public static String findStorageName(int storageplace)
{
	String result = "?";
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT getfullstoragename(sp.storageplace) fn FROM storageplaces sp WHERE sp.storageplace = ? ");
	params.add(new Integer(storageplace));
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		result = ro.getColumn("fn").asString();
	}
	return result;
}

public static String findStorageNameBySerial(String serial)
{
	String result = "?";
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT getfullstoragename(sc.storageplace) fullstoragename FROM storagecards sc ");
	sqlb.append("WHERE sc.policy = 'S' ");

	if(serial != null) {
		sqlb.append("AND sc.serialnumber = ? ");
		params.add(serial);
	} else {
		sqlb.append("AND sc.serialnumber <> sc.serialnumber ");
	}

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		result = ro.getColumn("fullstoragename").asString();
	}
	return result;
}

/**
 * Формирование имени места хранения по ресурсу/серийному номеру
 * @param serial
 * @return
 */
public static String findStorageNameBySerialResource(int resource, String serial)
{
	String result = "?";
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	sqlb.append("SELECT getfullstoragename(sc.storageplace) fullstoragename FROM storagecards sc ");
	sqlb.append("WHERE sc.policy = 'S' AND sc.closed = 'N' ");

	if(serial != null) {
		sqlb.append("AND sc.serialnumber = ? ");
		params.add(serial);
	} else {
		sqlb.append("AND sc.serialnumber <> sc.serialnumber ");
	}
	sqlb.append("AND sc.resource = ? ");
	params.add(new Integer(resource));

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		result = ro.getColumn("fullstoragename").asString();
	}
	return result;
}


public static boolean hasRealSerial(String serial)
{
	boolean result = false;
	StringBuffer sqlb = new StringBuffer();
	LinkedList params = new LinkedList();

	if(serial == null) { return false; }

	sqlb.append("SELECT count(storagecard) FROM storagecards WHERE serialnumber = ? AND isfictserial = 'N' AND policy = 'S' AND closed = 'N' ");
	params.add(serial);

	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sqlb.toString(), params.toArray());
	java.util.Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Number n = (Number)ro.getColumn("sn").asObject();
		if(n != null && n.intValue() > 0) {
			result = true;
		}
	}
	return result;
}
}
