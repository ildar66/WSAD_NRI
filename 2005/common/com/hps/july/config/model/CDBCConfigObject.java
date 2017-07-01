package com.hps.july.config.model;

import java.util.Iterator;
import java.util.LinkedList;

import com.hps.july.cdbc.lib.*;

/**
 * Объект для работы с документом конфигурации оборудования.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCConfigObject
{

	public CDBCConfigObject() {
		super();
	}
	
	/**
	 * Выдаёт список производителей шкафов БС
	 */
	public static CDBCResultSet findManufacturers()
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT DISTINCT organizations.organization,  organizations.shortname ");
		sqlb.append("FROM (resources LEFT JOIN organizations ON ");
		sqlb.append("resources.manufacturer = organizations.organization) ");
		sqlb.append("INNER JOIN basestationres ON resources.resource = basestationres.resource ");
		sqlb.append("WHERE basestationres.standard = 'G' AND resources.active = 'Y' AND ");
		sqlb.append("resources.manufacturer IS NOT NULL AND resources.resourceclass ='B' ");
		sqlb.append("ORDER BY organizations.shortname");
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	/**
	 * Выдаёт список мест размещения антенн
	 */
	public static CDBCResultSet findAntPlaces()
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT a.antplaceid, a.name ");
		sqlb.append("FROM antennplaces a ");
		sqlb.append("ORDER BY name");
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	/**
	 * Выдаёт список помещений
	 */
	public static CDBCResultSet findApartments(Integer position)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT a.apartmentid, a.apartname ");
		sqlb.append("FROM apartments a ");
		sqlb.append("WHERE a.position = ? ");
		sqlb.append("ORDER BY a.apartname");
		params.add(position);
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	/**
	 * Выдаёт список категорий оборудования
	 */
	public static CDBCResultSet findEquipcategories(boolean isChild)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		if (isChild) {
			sqlb.append("SELECT r.classid, r.classname, h.parent_classid, ");
			sqlb.append("s.sectorslink ");
			sqlb.append("FROM resourceclasses r, resourceclasseshierarhy h, outer EqObjSectorsLinkSetup s ");
			sqlb.append("WHERE r.classid = h.classid ");
			sqlb.append("AND s.classid = r.classid ");
			sqlb.append("ORDER BY r.classname");
		} else {
			sqlb.append("SELECT r.classid, r.classname, CAST(NULL AS INTEGER) parent_classid, ");
			sqlb.append("s.sectorslink ");
			sqlb.append("FROM resourceclasses r, outer EqObjSectorsLinkSetup s ");
			sqlb.append("WHERE r.classid NOT IN (SELECT d.classid FROM resourceclasseshierarhy d) ");
			sqlb.append("AND r.classid NOT IN (SELECT d.classid FROM equipobjresclassdisable d) ");
			sqlb.append("AND s.classid = r.classid ");
			sqlb.append("ORDER BY r.classname");
		}
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	/**
	 * Выдаёт список подчиненных категорий оборудования по родителю
	 */
	public static CDBCResultSet findChildEquipcategories(int parent)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT r.classid, r.classname, h.parent_classid, ");
		sqlb.append("s.sectorslink ");
		sqlb.append("FROM resourceclasses r, resourceclasseshierarhy h, outer EqObjSectorsLinkSetup s ");
		sqlb.append("WHERE r.classid = h.classid ");
		sqlb.append("AND h.parent_classid = ? ");
		sqlb.append("AND s.classid = r.classid ");
		sqlb.append("ORDER BY r.classname");
		
		params.add(new Integer(parent));
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	/**
	 * Ищет категорию оборудования по коду
	 */
	public static EquipCategoryVO findEquipcategory(int category)
	{
		EquipCategoryVO result = null;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT r.classid, r.classname, h.parent_classid, ");
		sqlb.append("s.sectorslink ");
		sqlb.append("FROM resourceclasses r, outer resourceclasseshierarhy h, outer EqObjSectorsLinkSetup s ");
		sqlb.append("WHERE r.classid = h.classid ");
		sqlb.append("AND r.classid = ? ");
		sqlb.append("AND s.classid = r.classid ");
		sqlb.append("ORDER BY r.classname");
		
		params.add(new Integer(category));
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			result = new EquipCategoryVO(
						((Integer)ro.getColumn("classid").asObject()).intValue(), 
						ro.getColumn("classname").asString(),
						(Integer)ro.getColumn("parent_classid").asObject(),
						ro.getColumn("sectorslink").asString()
						);
		}
		return result;
	}
	
	/**
	 * Выдаёт список производителей кабелей
	 */
	public static CDBCResultSet findCableManufacturers()
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT DISTINCT organizations.organization,  organizations.shortname ");
		sqlb.append("FROM (resources LEFT JOIN organizations ON ");
		sqlb.append("resources.manufacturer = organizations.organization) ");
		sqlb.append("INNER JOIN cableres ON resources.resource = cableres.resource ");
		sqlb.append("WHERE resources.active = 'Y' AND ");
		sqlb.append("resources.manufacturer IS NOT NULL AND resources.resourceclass='K' ");
		sqlb.append("ORDER BY organizations.shortname");
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	/**
	 * Выдаёт список ресурсов шкафов БС по производителю
	 */
	public static CDBCResultSet findResourcesByManuf(Integer manuf)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT r.resource, r.model ");
		sqlb.append("FROM resources r ");
		sqlb.append("JOIN basestationres br ON br.resource = r.resource ");
		sqlb.append("WHERE r.manufacturer = ? AND r.resourceclass2 = 1 AND r.active = 'Y' AND " +			"br.standard = 'G' AND countpolicy = 'S' ");
		sqlb.append("ORDER BY r.model");
		
		params.add(manuf);
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	/**
	 * Выдаёт список ресурсов шкафов БС по производителю
	 */
	public static CDBCResultSet findCableResourcesByManuf(Integer manuf)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT r.resource, r.model ");
		sqlb.append("FROM resources r ");
		sqlb.append("WHERE r.manufacturer = ? AND r.resourceclass2 = 2 AND " +			"r.active = 'Y' AND countpolicy = 'B' ");
		sqlb.append("ORDER BY r.model");
		
		params.add(manuf);
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	public static boolean checkAccess(Integer equipment, String operator, boolean needWriteAccess) {
		System.out.println("equipment = " + equipment);
		System.out.println("operator = " + operator);
		
		
		String query = "SELECT " +  
					   "    ra.* " +
					   "FROM equipment e " +
					   "JOIN positions p ON e.position = p.storageplace " +
					   "JOIN regions r ON r.regionid = p.regionid " +
					   "JOIN regionsaccess ra ON ra.regionid = r.regionid " +
					   "JOIN operators o ON o.operator = ra.operatorid " + 
					   "WHERE " +
					   "    ra.accesstype = 'R' " +
					   "AND o.loiginid = ? " +
					   "AND e.equipment = ? " +
					   (needWriteAccess ? "AND ra.editfact = 'Y' " : "AND ra.viewfact = 'Y' ") +
					   "UNION " +
					   "SELECT " +
					   "	  ra.* " +
					   "FROM equipment e " +
					   "JOIN positions p ON e.position = p.storageplace " +
					   "JOIN regions r ON r.regionid = p.regionid " +
					   "JOIN superregions sr ON r.supregid = sr.supregid " +
					   "JOIN regionsaccess ra ON ra.supregionid = sr.supregid " +
					   "JOIN operators o ON o.operator = ra.operatorid " +
					   "WHERE " +
					   "     ra.accesstype = 'S' " +
					   " AND o.loiginid = ? " +
					   " AND e.equipment = ? " +
				       (needWriteAccess ? "AND ra.editfact = 'Y' " : "AND ra.viewfact = 'Y' ");
		System.out.println(query);


		LinkedList params = new LinkedList();
		
		params.add(operator);
		params.add(equipment);
		params.add(operator);
		params.add(equipment);
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(query, params.toArray());

		return res.listIterator().hasNext();	
	}

	/**
	 * Поиск БС по номеру/названию
	 */
	public static CDBCResultSet findBaseStation(String searchBy, String searchParam)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.equipment, b.number, b.name, s.address, e.position ");
		sqlb.append("FROM basestations b, equipment e, storageplaces s ");
		sqlb.append("WHERE e.equipment = b.equipment AND s.storageplace = e.position ");
		sqlb.append("AND b.type IN ('S', 'C', 'G') ");
		
		if ("Названию".equals(searchBy)) {
			sqlb.append("AND UPPER(b.name) MATCHES(UPPER(?)) ");
			params.add(searchParam);
		} else if ("Номеру БС".equals(searchBy)) {
			sqlb.append("AND b.number = ? ");
			int n = 0;
			try {
				n = Integer.parseInt(searchParam);
			} catch (NumberFormatException e) {
				// Ignore errors
				e.printStackTrace(System.out);
			}
			params.add(new Integer(n));
		} else if ("Адресу".equals(searchBy)) {
				sqlb.append("AND UPPER(s.address) MATCHES(UPPER(?)) ");
				params.add(searchParam);
		}
		
		sqlb.append("ORDER BY b.name");
		
		//System.out.println("FindBS SQL=" + sqlb.toString());
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	/**
	 * Выдаёт список складов
	 */
	public static CDBCResultSet findStores()
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT s.storageplace, s.name ");
		sqlb.append("FROM storageplaces s ");
		sqlb.append("WHERE s.type = 'S' ");
		sqlb.append("ORDER BY s.name");
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	/**
	 * Выдаёт список контроллеров
	 */
	public static CDBCResultSet findControllers()
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT s.storageplace, c.number, s.name ");
		sqlb.append("FROM storageplaces s, controllers c ");
		sqlb.append("WHERE s.type = 'O' AND c.equipment = s.storageplace ");
		sqlb.append("ORDER BY s.name");
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
	
	/**
	 * Выдаёт список работников
	 */
	public static CDBCResultSet findWorkers(String alastname)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT w.worker, TRIM(p.lastname) || ' ' || TRIM(p.firstname) || ' ' || TRIM(p.middlename) name ");
		sqlb.append("FROM workers w, people p ");
		sqlb.append("WHERE p.isactive = 'Y' AND w.isactive = 'Y' AND w.man = p.man ");
		sqlb.append("AND UPPER(p.lastname) matches(UPPER(?)) ");
		params.add(alastname);
		sqlb.append("ORDER BY 2");
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + alastname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		
		return res;
	}
	
	/**
	 * Выдаёт список организаций
	 */
	public static CDBCResultSet findOrganizations(String aname)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT o.organization, o.name ");
		sqlb.append("FROM organizations o ");
		sqlb.append("WHERE  ");
		sqlb.append("UPPER(o.name) matches(UPPER(?)) ");
		params.add(aname);
		sqlb.append("ORDER BY 2");
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Copy config data from live objects to config tables
	 */
	public static CDBCResultSet cfgSaveConfig(int equipment)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("EXECUTE PROCEDURE cfgSaveConfig(?, ?)  ");
		params.add(new Integer(equipment));
		params.add("Исх. конфигурация " + equipment);
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Copy config data from one configuration to another
	 */
	public static CDBCResultSet cfgCopyConfig(int parentConfigID)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("EXECUTE PROCEDURE cfgCopyConfig(?, ?)  ");
		params.add("Измен. конфигурация " + parentConfigID);
		params.add(new Integer(parentConfigID));
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Read basestation data
	 */
	public static CDBCResultSet findBSInfo(int savConfigID)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.savconfigid, b.equipment, b.type, b.number, b.name,  ");
		sqlb.append("s.address, b.controller, c.number cnumber, cs.name cname, ");
		sqlb.append("b.date_assemb_afs, b.date_assemb_afs2, b.date_connect, b.date_connect2, ");
		sqlb.append("b.date_onair, b.date_onair2, b.date_assemb, b.date_assemb2, b.date_bldbeg, b.date_bldbeg2, ");
		sqlb.append("b.state900, b.state1800, b.objectstatus, b.equipcomment, ");
		sqlb.append("b.h_obj_ant, b.antplaceid, b.numgsmpermit, b.numdcspermit, b.apartmentid ");
		sqlb.append("FROM cfgBasestations b, equipment e, storageplaces s, outer (controllers c, storageplaces cs) ");
		sqlb.append("WHERE e.equipment = b.equipment AND s.storageplace = e.position AND ");
		sqlb.append("b.savconfigid = ? AND c.equipment = b.controller AND cs.storageplace = c.equipment ");
		params.add(new Integer(savConfigID));
		sqlb.append("ORDER BY b.number");
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}

	/**
	 * Read basestation stands data
	 */
	public static CDBCResultSet findBSStands(int savConfigID)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.savconfigid, b.standid, b.equipment, b.resource, b.stnomer, ");
		sqlb.append("b.storagecard, NVL(r.model, r.name) resname, s.policy, b.qty, s.broken, ");
		sqlb.append("s.serialnumber, s.inventserial, s.localserial, s.isfictserial, s.notes, ");
		sqlb.append("b.objectstatus ");
		sqlb.append("FROM cfgBsstands b, outer resources r, outer cfgStoragecards s ");
		sqlb.append("WHERE r.resource = b.resource AND s.storagecard = b.storagecard AND ");
		sqlb.append("b.savconfigid = ? AND s.savconfigid = b.savconfigid ");
		params.add(new Integer(savConfigID));
		sqlb.append("ORDER BY b.stnomer");
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Read other equipment data
	 */
	public static CDBCResultSet findOtherEquip(int savConfigID)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.savconfigid, b.objcfgid, b.equipment, r.resourceclass2, s.resource, ");
		sqlb.append("b.storagecard, NVL(r.model, r.name) resname, s.policy, b.qty, s.broken, ");
		sqlb.append("s.serialnumber, s.inventserial, s.localserial, s.isfictserial, s.notes, ");
		sqlb.append("b.objectstatus, b.parentobjcfgid ");
		sqlb.append("FROM cfgEquipObjectsCfg b, resources r, cfgStoragecards s ");
		sqlb.append("WHERE r.resource = s.resource AND s.storagecard = b.storagecard AND ");
		sqlb.append("b.savconfigid = ? AND s.savconfigid = b.savconfigid ");
		params.add(new Integer(savConfigID));
		sqlb.append("ORDER BY r.resourceclass2, b.objcfgid");
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + savConfigID);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Read basestation TRX data
	 */
	public static CDBCResultSet findTrxes(int savConfigID)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.savconfigid, b.trxid, b.equipment, b.resource, b.standid, ");
		sqlb.append("b.storagecard, NVL(r.model, r.name) resname, s.policy, b.qty, s.broken, ");
		sqlb.append("s.serialnumber, s.inventserial, s.localserial, s.isfictserial, s.notes, ");
		sqlb.append("b.objectstatus ");
		sqlb.append("FROM cfgTrx b, outer resources r, outer cfgStoragecards s ");
		sqlb.append("WHERE r.resource = b.resource AND s.storagecard = b.storagecard AND ");
		sqlb.append("b.savconfigid = ? AND s.savconfigid = b.savconfigid ");
		params.add(new Integer(savConfigID));
		sqlb.append("ORDER BY b.standid");
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Read basestation TRX sectors data
	 */
	public static CDBCResultSet findTrxSectors(int savConfigID, int trxid, short band)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.savconfigid, b.id_sect, b.equipment,   ");
		sqlb.append("b.name_sect, b.band, b.num_sect, b.lac, b.azimut, b.cellname,  ");
		sqlb.append("b.objectstatus ");
		sqlb.append("FROM cfgSectors b, cfgTrx2sectors a ");
		sqlb.append("WHERE b.savconfigid = ? AND b.id_sect = a.id_sect AND ");
		sqlb.append("a.savconfigid = b.savconfigid AND a.trxid = ? AND b.band = ? ");
		sqlb.append("ORDER BY b.band, b.name_sect");
		params.add(new Integer(savConfigID));
		params.add(new Integer(trxid));
		params.add(new Integer(band));
		
		CDBCResultSet res = new CDBCResultSet();
		
		System.out.println("SQL: " + sqlb.toString());
		System.out.println("SavConfig=" + savConfigID + ", trxid=" + trxid + ", band=" + band);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Read other equipment sectors data
	 */
	public static CDBCResultSet findOtherEquipSectors(int savConfigID, int equipid, short band)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.savconfigid, b.id_sect, b.equipment,   ");
		sqlb.append("b.name_sect, b.band, b.num_sect, b.lac, b.azimut, b.cellname,  ");
		sqlb.append("b.objectstatus ");
		sqlb.append("FROM cfgSectors b, cfgEquipObjCfg2Sectors a ");
		sqlb.append("WHERE b.savconfigid = ? AND b.id_sect = a.id_sect AND ");
		sqlb.append("a.savconfigid = b.savconfigid AND a.objcfgid = ? AND b.band = ? ");
		sqlb.append("ORDER BY b.band, b.name_sect");
		params.add(new Integer(savConfigID));
		params.add(new Integer(equipid));
		params.add(new Integer(band));
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("SavConfig=" + savConfigID + ", trxid=" + trxid + ", band=" + band);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Read basestation antennes data
	 */
	public static CDBCResultSet findAntennes(int savConfigID)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.savconfigid, b.id_anten, b.equipment, b.resource,  ");
		sqlb.append("b.az_ant, b.h_set1, b.nakl, b.kind_ant, b.locationtype, ");
		sqlb.append("b.commcable, ");
		sqlb.append("b.storagecard, NVL(r.model, r.name) resname, s.policy, b.qty, s.broken, ");
		sqlb.append("s.serialnumber, s.inventserial, s.localserial, s.isfictserial, s.notes, ");
		sqlb.append("b.objectstatus, ");
		sqlb.append("(SELECT min(a1.kind_ant) FROM cfgAntennesWorkBands a1 ");
		sqlb.append("   WHERE a1.id_anten = b.id_anten AND a1.savconfigid = b.savconfigid AND ");
		sqlb.append("   a1.band = 900) kind_ant900, ");
		sqlb.append("(SELECT min(a1.kind_ant) FROM cfgAntennesWorkBands a1 ");
		sqlb.append("   WHERE a1.id_anten = b.id_anten AND a1.savconfigid = b.savconfigid AND ");
		sqlb.append("   a1.band = 1800) kind_ant1800, ");
		
		sqlb.append("(SELECT min(a1.kswn) FROM cfgAntennesWorkBands a1 ");
		sqlb.append("   WHERE a1.id_anten = b.id_anten AND a1.savconfigid = b.savconfigid AND ");
		sqlb.append("   a1.band = 900) ksvn900, ");
		sqlb.append("(SELECT min(a1.kswn) FROM cfgAntennesWorkBands a1 ");
		sqlb.append("   WHERE a1.id_anten = b.id_anten AND a1.savconfigid = b.savconfigid AND ");
		sqlb.append("   a1.band = 1800) ksvn1800, ");
		
		sqlb.append("(SELECT min(s1.name_sect) FROM cfgSectors s1, cfgAnten2sectors a1 ");
		sqlb.append("   WHERE a1.id_sect = s1.id_sect AND a1.savconfigid = b.savconfigid AND ");
		sqlb.append("   s1.savconfigid = b.savconfigid AND s1.band = 900 AND ");		sqlb.append("   a1.id_anten = b.id_anten) sect900, "); 
		sqlb.append("(SELECT min(s1.name_sect) FROM cfgSectors s1, cfgAnten2sectors a1 ");
		sqlb.append("   WHERE a1.id_sect = s1.id_sect AND a1.savconfigid = b.savconfigid AND ");
		sqlb.append("   s1.savconfigid = b.savconfigid AND s1.band = 1800 AND ");
		sqlb.append("   a1.id_anten = b.id_anten) sect1800 "); 
		sqlb.append("FROM cfgAntennes b, outer resources r, outer cfgStoragecards s ");
		sqlb.append("WHERE r.resource = b.resource AND s.storagecard = b.storagecard AND ");
		sqlb.append("b.savconfigid = ? AND s.savconfigid = b.savconfigid ");
		params.add(new Integer(savConfigID));
		sqlb.append("ORDER BY b.num_ant");
		
		CDBCResultSet res = new CDBCResultSet();
		
		System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Read basestation sectors data
	 */
	public static CDBCResultSet findCablesForAntenna(int savConfigID, int antennid)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.savconfigid, b.id_cable, b.id_anten,   ");
		sqlb.append("b.len_cable, b.cableres, r.model, ");
		sqlb.append("b.objectstatus ");
		sqlb.append("FROM cfgAntennaCables b, resources r, outer cfgStoragecards s ");
		sqlb.append("WHERE b.savconfigid = ? AND b.id_anten = ? AND r.resource = b.cableres ");
		sqlb.append("AND s.storagecard = b.storagecard AND s.savconfigid = b.savconfigid ");
		sqlb.append("ORDER BY b.id_cable");
		params.add(new Integer(savConfigID));
		params.add(new Integer(antennid));
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Read basestation sectors data
	 */
	public static CDBCResultSet findSectorsForAntenna(int savConfigID, int antennid, int band)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT b.savconfigid, b.id_sect, b.equipment,   ");
		sqlb.append("b.name_sect, b.band, b.num_sect, b.lac, b.azimut, b.cellname, ");
		sqlb.append("b.objectstatus ");
		sqlb.append("FROM cfgSectors b, cfgAnten2sectors a ");
		sqlb.append("WHERE b.savconfigid = ? AND b.id_sect = a.id_sect AND ");
		sqlb.append("a.savconfigid = b.savconfigid AND a.id_anten = ? AND b.band = ? ");
		sqlb.append("ORDER BY b.band, b.name_sect");
		params.add(new Integer(savConfigID));
		params.add(new Integer(antennid));
		params.add(new Integer(band));
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Read config documents by basestation
	 */
	public static CDBCResultSet findCfgDocuments(int ibasestation)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT d.document, d.blanknumber, d.blankindex, d.blankdate, d.from, ");
		sqlb.append("c.savconfigid_old, c.savconfigid_new, s.name expname, d.state, d.insuranceman, ");
		sqlb.append("c.storedem, c.storebad, s1.name storedemname, s2.name storebadname, ");
		sqlb.append("e.expeditor, e.organization, ");
		sqlb.append("cfgCheckStatus(c.savconfigid_new, 'A') haveinserts, ");
		sqlb.append("cfgCheckStatus(c.savconfigid_new, 'U') havechanges, ");
		sqlb.append("cfgCheckStatus(c.savconfigid_new, 'D') havedeletes ");
		sqlb.append("FROM documents d, cfgDocument c, storageplaces s, expedition e, ");
		sqlb.append("outer storageplaces s1, outer storageplaces s2 ");
		sqlb.append("WHERE c.document = d.document AND s.storageplace = d.from AND e.expedition = s.storageplace AND ");
		sqlb.append("d.to = ? AND s1.storageplace = c.storedem AND s2.storageplace = c.storebad ");
		params.add(new Integer(ibasestation));
		sqlb.append("ORDER BY d.blankdate DESC, d.document DESC");
		
		CDBCResultSet res = new CDBCResultSet();
		
		System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}

	/**
	 * Load config document
	 */
	public static CDBCResultSet loadCfgDocument(int idocument)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT d.document, d.blanknumber, d.blankindex, d.blankdate, d.from, ");
		sqlb.append("c.savconfigid_old, c.savconfigid_new, s.name expname, d.state, d.insuranceman, ");
		sqlb.append("c.storedem, c.storebad, s1.name storedemname, s2.name storebadname, ");
		sqlb.append("e.expeditor, e.organization, ");
		sqlb.append("cfgCheckStatus(c.savconfigid_new, 'A') haveinserts, ");
		sqlb.append("cfgCheckStatus(c.savconfigid_new, 'U') havechanges, ");
		sqlb.append("cfgCheckStatus(c.savconfigid_new, 'D') havedeletes ");
		sqlb.append("FROM documents d, cfgDocument c, storageplaces s, expedition e, ");
		sqlb.append("outer storageplaces s1, outer storageplaces s2 ");
		sqlb.append("WHERE c.document = d.document AND s.storageplace = d.from AND e.expedition = s.storageplace AND ");
		sqlb.append("d.document = ? AND s1.storageplace = c.storedem AND s2.storageplace = c.storebad ");
		params.add(new Integer(idocument));
		sqlb.append("ORDER BY d.blankdate DESC, d.document DESC");
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	public static boolean clearConfig(int savconfigid) {
		boolean result = false;
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
		
		sqlb.append("EXECUTE PROCEDURE cfgClearConfig(?)");
		params.add(new Integer(savconfigid));
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		Iterator it = res.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();	
			Integer errCode = (Integer)ro.getColumn("col1").asObject();
			if ( (errCode != null) && (0 == errCode.intValue()) ) {
				result = true;
			}
		}
		
		return result;
	}

	public static CDBCResultSet findAntennaResources(Integer aband, String apolarization, String amodel) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT r.resource, r.model, r.name, a.polarization, b.band ");
		sqlb.append("FROM resources r, antennares a, antennaresband b  ");
		sqlb.append("WHERE a.resource = r.resource AND r.resourceclass = 'A' AND r.active = 'Y' AND b.resource = r.resource ");

		if (aband != null) {
			sqlb.append(" AND b.band = ? ");
			params.add(aband);
		}
		if ("Вертикальная".equals(apolarization)) {
			sqlb.append("AND a.polarization = 'V' ");
		} else if ("Кросс".equals(apolarization)) {
			sqlb.append("AND a.polarization = 'C' ");
		} 
		if ( (amodel != null) && (amodel.trim().length() > 0) ) {
			sqlb.append("AND UPPER(r.model) MATCHES(UPPER(?)) ");
			params.add(amodel);
		}
		sqlb.append("ORDER BY r.model");

		System.out.println("query = " + sqlb.toString());

		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	public static CDBCResultSet findResources(String searchby, String searchvalue, Integer equipCategory) {
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT r.resource, r.model, r.name, r.manucode, NVL(m.shortname, m.name) manufname, r.countpolicy, ");
		sqlb.append("(SELECT min(n1.segment1) FROM nfsres2nrires f1, nfsresources n1 ");
		sqlb.append("  WHERE n1.item_id = f1.item_id AND f1.resource = r.resource) nfscode ");
		sqlb.append("FROM resources r, outer organizations m ");
		if ("C".equals(searchby)) {
			sqlb.append(", nfsres2nrires f, nfsresources n ");
		}
		sqlb.append("WHERE r.active = 'Y' AND m.organization = r.manufacturer ");
		if ("T".equals(searchby)) {
			sqlb.append("AND UPPER(r.model) MATCHES(UPPER(?)) ");
			params.add(searchvalue);
		}
		if ("M".equals(searchby)) {
			sqlb.append("AND UPPER(r.manucode) MATCHES(UPPER(?)) ");
			params.add(searchvalue);
		}
		if ("C".equals(searchby)) {
			sqlb.append("AND UPPER(n.segment1) MATCHES(UPPER(?)) ");
			sqlb.append("AND n.item_id = f.item_id AND f.resource = r.resource ");
			params.add(searchvalue);
		}
		if (equipCategory != null) {
			sqlb.append("AND r.resourceclass2 = ? ");
			params.add(equipCategory);
		}
		sqlb.append("ORDER BY r.model");
		
		
		CDBCResultSet res = new CDBCResultSet();
		System.out.println("EquipCategory = " + equipCategory);
		System.out.println(sqlb.toString());
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	/**
	 * Read repiters data
	 */
	public static CDBCResultSet findRepiters(int bsEquipCode)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT r.number, r.donor_type, e.state, s.name_sect ");
		sqlb.append("FROM repiters r, equipment e, sectors s ");
		sqlb.append("WHERE r.equipment = e.equipment AND s.id_sect = r.donor_sect AND s.equipment = ? ");
		params.add(new Integer(bsEquipCode));
		sqlb.append("ORDER BY r.number");
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Find added equipment
	 *
	 */
	public static CDBCResultSet findModifiedEquipment(int config, String modifyStatus)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT c.classname, r.model, r.countpolicy, s.qty, s.serialnumber, s.inventserial, " +			"s.notes, r.name, " +			"s.localserial, s.isfictserial, b.stnomer btsnum, '' sect900, '' sect1800, ");
		sqlb.append("(SELECT min(n1.segment1) FROM nfsresources n1, nfsres2nrires n2 WHERE " +			"n1.item_id = n2.item_id AND n2.resource = r.resource AND n2.datatype IN ('A', 'U')) nfscode, ");
		sqlb.append("(SELECT u.shortname FROM units u WHERE u.unit = r.unit) unitname ");
		sqlb.append("FROM resourceclasses c, resources r, cfgstoragecards s, cfgBsStands b ");
		sqlb.append("WHERE c.classid = r.resourceclass2 AND r.resource = s.resource AND s.savconfigid = b.savconfigid AND " +			"s.storagecard = b.storagecard AND b.savconfigid = ? AND b.objectstatus = ? ");
		params.add(new Integer(config));
		params.add(modifyStatus);
		sqlb.append("UNION ");
		sqlb.append("SELECT c.classname, r.model, r.countpolicy, s.qty, s.serialnumber, s.inventserial, " +
			"s.notes, r.name, " +
			"s.localserial, s.isfictserial, a.stnomer btsnum, " +			"cfgReportTrxSectors(b.savconfigid, b.trxid, 900) sect900, " +			"cfgReportTrxSectors(b.savconfigid, b.trxid, 1800) sect1800, ");
		sqlb.append("(SELECT min(n1.segment1) FROM nfsresources n1, nfsres2nrires n2 WHERE " +
			"n1.item_id = n2.item_id AND n2.resource = r.resource AND n2.datatype IN ('A', 'U')) nfscode, ");
		sqlb.append("(SELECT u.shortname FROM units u WHERE u.unit = r.unit) unitname ");
		sqlb.append("FROM resourceclasses c, resources r, cfgstoragecards s, cfgTrx b, cfgBsStands a ");
		sqlb.append("WHERE c.classid = r.resourceclass2 AND r.resource = s.resource AND " +			"a.standid = b.standid AND a.savconfigid = b.savconfigid AND s.savconfigid = b.savconfigid AND " +
			"s.storagecard = b.storagecard AND b.savconfigid = ? AND b.objectstatus = ? ");
		params.add(new Integer(config));
		params.add(modifyStatus);
		sqlb.append("UNION ");
		sqlb.append("SELECT c.classname, r.model, r.countpolicy, s.qty, s.serialnumber, s.inventserial, " +
			"s.notes, r.name, " +
			"s.localserial, s.isfictserial, '' btsnum, " +			"cfgReportAntSectors(b.savconfigid, b.id_anten, 900) sect900, " +			"cfgReportAntSectors(b.savconfigid, b.id_anten, 1800) sect1800, ");
		sqlb.append("(SELECT min(n1.segment1) FROM nfsresources n1, nfsres2nrires n2 WHERE " +
			"n1.item_id = n2.item_id AND n2.resource = r.resource AND n2.datatype IN ('A', 'U')) nfscode, ");
		sqlb.append("(SELECT u.shortname FROM units u WHERE u.unit = r.unit) unitname ");
		sqlb.append("FROM resourceclasses c, resources r, cfgstoragecards s, cfgAntennes b ");
		sqlb.append("WHERE c.classid = r.resourceclass2 AND r.resource = s.resource AND s.savconfigid = b.savconfigid AND " +
			"s.storagecard = b.storagecard AND b.savconfigid = ? AND b.objectstatus = ? ");
		params.add(new Integer(config));
		params.add(modifyStatus);
		sqlb.append("UNION ");
		sqlb.append("SELECT c.classname, r.model, r.countpolicy, s.qty, s.serialnumber, s.inventserial, " +
			"s.notes, r.name, " +
			"s.localserial, s.isfictserial, '' btsnum, '' sect900, '' sect1800, ");
		sqlb.append("(SELECT min(n1.segment1) FROM nfsresources n1, nfsres2nrires n2 WHERE " +
			"n1.item_id = n2.item_id AND n2.resource = r.resource AND n2.datatype IN ('A', 'U')) nfscode, ");
		sqlb.append("(SELECT u.shortname FROM units u WHERE u.unit = r.unit) unitname ");
		sqlb.append("FROM resourceclasses c, resources r, cfgstoragecards s, cfgEquipObjectsCfg b ");
		sqlb.append("WHERE c.classid = r.resourceclass2 AND r.resource = s.resource AND s.savconfigid = b.savconfigid AND " +
			"s.storagecard = b.storagecard AND b.savconfigid = ? AND b.objectstatus = ? ");
		params.add(new Integer(config));
		params.add(modifyStatus);
		
		CDBCResultSet res = new CDBCResultSet();
		
		//System.out.println("SQL: " + sqlb.toString());
		//System.out.println("Search param=" + aname);
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}

	/**
	 * Find added equipment
	 *
	 */
	public static CDBCResultSet findModifiedAttributes(int configsrc, int configdest)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("EXECUTE PROCEDURE cfgReportModifiedAttributes(?, ?) ");
		params.add(new Integer(configsrc));
		params.add(new Integer(configdest));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Find TRX equipment count
	 *
	 */
	public static CDBCResultSet findTRXEquipCount(int config, String nameSect, short band)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("EXECUTE PROCEDURE cfgReportTRXEquipCount(?, ?, ?) ");
		params.add(new Integer(config));
		params.add(nameSect);
		params.add(new Short(band));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Find Antennes equipment count
	 *
	 */
	public static CDBCResultSet findAntEquipCount(int config, String nameSect, short band)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("EXECUTE PROCEDURE cfgReportAntEquipCount(?, ?, ?) ");
		params.add(new Integer(config));
		params.add(nameSect);
		params.add(new Short(band));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Find Antennes equipment count
	 *
	 */
	public static CDBCResultSet reportEquipmentTotals(int config)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT c.classname, sum(s.qty) qty ");		sqlb.append("FROM cfgStoragecards s, resources r, resourceclasses c ");
		sqlb.append("WHERE s.savconfigid = ? AND r.resource = s.resource AND ");
		sqlb.append("c.classid = r.resourceclass2 ");
		sqlb.append("GROUP BY c.classname ");
		sqlb.append("ORDER BY c.classname ");
		params.add(new Integer(config));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}

	/**
	 * Find BSStands equipment
	 *
	 */
	public static CDBCResultSet reportBSStandsConfig(int config)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT c.classname, r.model, s.policy, b.qty, s.notes, ");		sqlb.append("s.serialnumber, s.inventserial, s.localserial, s.isfictserial, ");
		sqlb.append("b.standid, b.stnomer, ");
		sqlb.append("(SELECT count(t.trxid) FROM cfgTrx t WHERE t.savconfigid=b.savconfigid AND t.standid = b.standid) trxcount ");
		sqlb.append("FROM cfgBsStands b, cfgStoragecards s, resources r, resourceclasses c ");
		sqlb.append("WHERE b.savconfigid = ? AND r.resource = s.resource AND ");
		sqlb.append("c.classid = r.resourceclass2 AND s.savconfigid = b.savconfigid AND s.storagecard = b.storagecard ");
		sqlb.append("ORDER BY b.standid ");
		params.add(new Integer(config));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}

	/**
	 * Find TRX equipment
	 *
	 */
	public static CDBCResultSet reportTRXConfig(int config)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT c.classname, r.model, s.policy, b.qty, s.notes, ");
		sqlb.append("s.serialnumber, s.inventserial, s.localserial, s.isfictserial, ");
		sqlb.append("b.trxid, a.stnomer, ");
		sqlb.append("(SELECT min(a.name_sect) FROM cfgTrx2sectors t, cfgSectors a " +			"WHERE t.savconfigid=b.savconfigid AND t.trxid = b.trxid AND " +			"a.savconfigid = t.savconfigid AND a.id_sect = t.id_sect AND a.band=900) sect900, ");
		sqlb.append("(SELECT min(a.name_sect) FROM cfgTrx2sectors t, cfgSectors a " +
			"WHERE t.savconfigid=b.savconfigid AND t.trxid = b.trxid AND " +
			"a.savconfigid = t.savconfigid AND a.id_sect = t.id_sect AND a.band=1800) sect1800 ");
		sqlb.append("FROM cfgTrx b, cfgBsStands a, cfgStoragecards s, resources r, resourceclasses c ");
		sqlb.append("WHERE b.savconfigid = ? AND r.resource = s.resource AND ");
		sqlb.append("c.classid = r.resourceclass2 AND s.savconfigid = b.savconfigid AND ");		sqlb.append("s.storagecard = b.storagecard AND a.savconfigid = b.savconfigid AND a.standid = b.standid ");
		sqlb.append("ORDER BY b.trxid ");
		params.add(new Integer(config));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}

	/**
	 * Find Antennes equipment
	 *
	 */
	public static CDBCResultSet reportAntennesConfig(int config)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT c.classname, r.model, s.policy, b.qty, s.notes, ");
		sqlb.append("s.serialnumber, s.inventserial, s.localserial, s.isfictserial, ");
		sqlb.append("b.id_anten, b.az_ant, b.h_set1, b.nakl, ");
		sqlb.append("(SELECT DECODE(a.kind_ant, 'R', 'Приемная', 'T', 'Передающая', 'D', 'Приемно-передающая') " +			"FROM cfgAntennesWorkBands a WHERE a.savconfigid = b.savconfigid AND a.id_anten = b.id_anten AND " +			"a.band = 900) kind_ant900, ");
		sqlb.append("(SELECT DECODE(a.kind_ant, 'R', 'Приемная', 'T', 'Передающая', 'D', 'Приемно-передающая') " +
			"FROM cfgAntennesWorkBands a WHERE a.savconfigid = b.savconfigid AND a.id_anten = b.id_anten AND " +
			"a.band = 1800) kind_ant1800, ");
		sqlb.append("DECODE(b.locationtype, 'I', 'Indoor', 'O', 'Outdoor') locationtype, ");
		sqlb.append("(SELECT min(a.name_sect) FROM cfgAnten2sectors t, cfgSectors a " +
			"WHERE t.savconfigid=b.savconfigid AND t.id_anten = b.id_anten AND " +
			"a.savconfigid = t.savconfigid AND a.id_sect = t.id_sect AND a.band=900) sect900, ");
		sqlb.append("(SELECT min(a.name_sect) FROM cfgAnten2sectors t, cfgSectors a " +
			"WHERE t.savconfigid=b.savconfigid AND t.id_anten = b.id_anten AND " +
			"a.savconfigid = t.savconfigid AND a.id_sect = t.id_sect AND a.band=1800) sect1800 ");
		sqlb.append("FROM cfgAntennes b, cfgStoragecards s, resources r, resourceclasses c ");
		sqlb.append("WHERE b.savconfigid = ? AND r.resource = s.resource AND ");
		sqlb.append("c.classid = r.resourceclass2 AND s.savconfigid = b.savconfigid AND ");
		sqlb.append("s.storagecard = b.storagecard ");
		sqlb.append("ORDER BY b.id_anten ");
		params.add(new Integer(config));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}

	/**
	 * Find Cables equipment
	 *
	 */
	public static CDBCResultSet reportCablesConfig(int config)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT c.classname, r.model, s.policy, b.qty, s.notes, ");
		sqlb.append("s.serialnumber, s.inventserial, s.localserial, s.isfictserial, ");
		sqlb.append("b.id_cable, ");
		sqlb.append("(SELECT min(t.ksvn) FROM cfgCableWorkParams t, cfgAntennes a " +
			"WHERE t.savconfigid=b.savconfigid AND t.id_anten = b.id_anten AND " +
			"a.savconfigid = t.savconfigid AND a.id_anten = t.id_anten AND t.band=900 AND " +			"t.id_cable = b.id_cable) kswn900, ");
		sqlb.append("(SELECT min(t.ksvn) FROM cfgCableWorkParams t, cfgAntennes a " +
			"WHERE t.savconfigid=b.savconfigid AND t.id_anten = b.id_anten AND " +
			"a.savconfigid = t.savconfigid AND a.id_anten = t.id_anten AND t.band=1800 AND " +
			"t.id_cable = b.id_cable) kswn1800 ");
		sqlb.append("FROM cfgAntennaCables b, cfgStoragecards s, resources r, resourceclasses c ");
		sqlb.append("WHERE b.savconfigid = ? AND r.resource = s.resource AND ");
		sqlb.append("c.classid = r.resourceclass2 AND s.savconfigid = b.savconfigid AND ");
		sqlb.append("s.storagecard = b.storagecard ");
		sqlb.append("ORDER BY b.id_cable ");
		params.add(new Integer(config));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}

	/**
	 * Find Cables equipment
	 *
	 */
	public static CDBCResultSet reportOtherConfig(int config)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT c.classname, r.model, s.policy, b.qty, s.notes, ");
		sqlb.append("s.serialnumber, s.inventserial, s.localserial, s.isfictserial, ");
		sqlb.append("b.objcfgid ");
		sqlb.append("FROM cfgEquipObjectsCfg b, cfgStoragecards s, resources r, resourceclasses c ");
		sqlb.append("WHERE b.savconfigid = ? AND r.resource = s.resource AND ");
		sqlb.append("c.classid = r.resourceclass2 AND s.savconfigid = b.savconfigid AND ");
		sqlb.append("s.storagecard = b.storagecard ");
		sqlb.append("ORDER BY b.objcfgid ");
		params.add(new Integer(config));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}
	
	/**
	 * Find Antennes equipment
	 *
	 */
	public static CDBCResultSet reportAFSAntennes(int config, String sector, short band)
	{
		System.out.println("reportAFSAntennes: config=" + config + ", sector=" + sector + ", band=" + band);
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT a.id_anten, r.name, r.model, s.serialnumber, a.h_set1, a.az_ant, a.nakl, w.kswn ");
		sqlb.append("FROM cfgAntennes a, cfgAnten2Sectors b, cfgSectors c, " +			"cfgStoragecards s, resources r, cfgAntennesWorkBands w ");
		sqlb.append("WHERE s.savconfigid = a.savconfigid AND r.resource = s.resource AND ");
		sqlb.append("s.storagecard = a.storagecard AND b.savconfigid = a.savconfigid AND ");
		sqlb.append("b.id_anten = a.id_anten AND c.savconfigid = a.savconfigid AND ");
		sqlb.append("c.id_sect = b.id_sect AND c.band = ? AND c.name_sect = ? AND a.savconfigid = ? AND ");
		sqlb.append("a.objectstatus IN ('K', 'A', 'U') AND w.savconfigid = a.savconfigid AND ");
		sqlb.append("w.id_anten = a.id_anten AND w.band = ? ");
		sqlb.append("ORDER BY a.id_anten ");
		params.add(new Short(band));
		params.add(sector);
		params.add(new Integer(config));
		params.add(new Short(band));
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	/**
	 * Find Antennes equipment
	 *
	 */
	public static CDBCResultSet reportOtherEquipByClass(int config, int classid)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT a.objcfgid, r.name, r.model, s.serialnumber, s.policy ");
		sqlb.append("FROM cfgEquipObjectsCfg a, cfgStoragecards s, resources r ");
		sqlb.append("WHERE s.savconfigid = a.savconfigid AND r.resource = s.resource AND ");
		sqlb.append("s.storagecard = a.storagecard AND ");
		sqlb.append("a.savconfigid = ? AND ");
		sqlb.append("a.objectstatus IN ('K', 'A', 'U') AND r.resourceclass2 = ? ");
		sqlb.append("ORDER BY a.objcfgid ");
		params.add(new Integer(config));
		params.add(new Integer(classid));
		CDBCResultSet res = new CDBCResultSet();
		
		res.executeQuery(sqlb.toString(), params.toArray());
		
		return res;
	}

	/**
	 * Find Cable equipment
	 *
	 */
	public static CDBCResultSet reportAFSCables(int config, String sector, short band, Integer cableDiam)
	{
		//System.out.println("reportAFSAntennes: config=" + config + ", sector=" + sector + ", band=" + band);
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT a.id_anten, w.id_cable, r.name, r.model, s.serialnumber, w.qty ");
		sqlb.append("FROM cfgAntennes a, cfgAnten2Sectors b, cfgSectors c, " +
			"cfgStoragecards s, resources r, cfgAntennaCables w, cableres r2 ");
		sqlb.append("WHERE s.savconfigid = w.savconfigid AND r.resource = s.resource AND ");
		sqlb.append("s.storagecard = w.storagecard AND b.savconfigid = a.savconfigid AND ");
		sqlb.append("b.id_anten = a.id_anten AND c.savconfigid = a.savconfigid AND ");
		sqlb.append("c.id_sect = b.id_sect AND c.band = ? AND c.name_sect = ? AND a.savconfigid = ? AND ");
		sqlb.append("a.objectstatus IN ('K', 'A', 'U') AND w.savconfigid = a.savconfigid AND ");
		sqlb.append("w.id_anten = a.id_anten AND r2.resource = r.resource ");
		params.add(new Short(band));
		params.add(sector);
		params.add(new Integer(config));
		if (cableDiam != null) {
			sqlb.append("AND r2.cablediamid = ? ");
			params.add(cableDiam);
		}
		sqlb.append("ORDER BY a.id_anten, w.id_cable ");
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}

	/**
	 * Report sectors
	 *
	 */
	public static CDBCResultSet reportSectors(int config)
	{
		StringBuffer sqlb = new StringBuffer();
		LinkedList params = new LinkedList();
	
		sqlb.append("SELECT c.id_sect, c.name_sect, c.band ");
		sqlb.append("FROM cfgSectors c ");
		sqlb.append("WHERE c.savconfigid = ? AND ");
		sqlb.append("c.objectstatus IN ('K', 'A', 'U') ");
		params.add(new Integer(config));
		
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sqlb.toString(), params.toArray());
		return res;
	}
}
