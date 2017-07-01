package com.hps.july.cdbc.objects;

import java.util.*;
import java.sql.Date;

import com.hps.july.cdbc.lib.*;

/**
 * —лужебный класс, предоставл€ющий методы дл€ работы с электросчЄтчиками
 * Creation date: (17.08.2004 19:51:45)
 * @author: Vadim Glushkov
 */
public class CDBCElectroCounterObject {

	public static String ALL = "*";
/**
 * CDBCElectroCounterObject constructor comment.
 */
public CDBCElectroCounterObject() {
	super();
}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.08.2004 16:00:55)
	 * @return com.hps.july.cdbc.lib.CDBCResultSet
	 * @param id java.lang.Integer
	 */
	public CDBCResultSet findElectroCountersByCounterInfoId(Integer id) {
		StringBuffer sqlQuery = new StringBuffer("SELECT ");
		sqlQuery.append(" c.counterid ");
		sqlQuery.append("FROM ");
		sqlQuery.append(" counters c ");
		sqlQuery.append("WHERE ");
		sqlQuery.append(" c.counterinfo_id = ? ");
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery(sqlQuery.toString(), new Object [] { id });
		return rs;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (18.08.2004 12:00:05)
	 * @return boolean
	 * @param s java.lang.String
	 */
	private boolean isValid(String s) {
		return (s != null & s.trim().length() > 0);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.08.2004 19:55:00)
	 * @return com.hps.july.cdbc.lib.CDBCResultSet
	 */
	public CDBCResultSet listElectroCounters(String searchFor, String searchValue, String state,
		String control, java.sql.Date controlValue) {

		GregorianCalendar calendar = new GregorianCalendar();
          
		StringBuffer sqlQuery = new StringBuffer("SELECT ");
		sqlQuery.append(" c.counterid, c.vendor_number, c.production_year, c.installation_date,");
  		sqlQuery.append(" c.last_verification, c.next_verification, c.cstate,");
    	sqlQuery.append(" NVL('D' || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) as name ");
     	sqlQuery.append("FROM ");
      	sqlQuery.append(" counters c, positions p, storageplaces sp ");
       	sqlQuery.append("WHERE ");
        sqlQuery.append(" sp.storageplace = p.storageplace AND p.storageplace = c.positionid ");

        StringBuffer sqlOrder = new StringBuffer(" ORDER BY c.next_verification ");

		Vector whereClause = new Vector();
  		Vector whereValues = new Vector();

            if(isValid(searchFor) && !searchFor.equals("1") && isValid(searchValue)) {
                if(searchFor.equals("2")) {
	                searchValue = searchValue + CDBCElectroCounterObject.ALL;
                    whereClause.add(" UPPER(c.vendor_number) MATCHES UPPER(?) ");
                    whereValues.add(searchValue);
                } else if(searchFor.equals("3")) {
                    Integer value = null;
                    try {
                        value = new Integer(searchValue);
                        whereClause.add(" p.gsmid = ? ");
                        whereValues.add(value);
                    } catch (Exception e) {}
                } else if(searchFor.equals("4")) {
                    Integer value = null;
                    try {
                        value = new Integer(searchValue);
                        whereClause.add(" p.dampsid = ? ");
                        whereValues.add(value);
                    } catch (Exception e) {}
                } else if(searchFor.equals("5")) {
	                searchValue = searchValue + CDBCElectroCounterObject.ALL;
                    whereClause.add(" UPPER(sp.name) MATCHES UPPER(?) ");
                    whereValues.add(searchValue);
                }
            }
            if(state != null && !state.equals("0")) {
                whereClause.add(" c.cstate = ? ");
                whereValues.add(state);
            }
            
            if(isValid(control) && !control.equals("1")) {
                if(control.equals("2")) {
                    calendar.setTime(new java.util.Date());
                    double month = calendar.get(Calendar.MONTH) + 1.0D - 0.1D;
                    double quarter = Math.ceil(month / 3);
                    if(quarter >= 4.0D) quarter = 1.0D;
                    else quarter += 1.0D;
                    calendar.set(Calendar.MONTH, (int)(quarter * 3));
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    calendar.add(Calendar.DAY_OF_MONTH, -1);
                    whereClause.add(" c.next_verification < ? ");
                    whereValues.add(new java.sql.Date(calendar.getTime().getTime()));
                } else if(control.equals("3")) {
                    if(controlValue != null) {
                        whereClause.add(" c.next_verification < ? ");
                        whereValues.add(controlValue);
                    }
                }
            }
		StringBuffer whereQuery = new StringBuffer("");
  		for (int i = 0; i < whereClause.size(); i++) {
    		whereQuery.append(" AND ");
      		whereQuery.append((String)whereClause.get(i));
        }
    	sqlQuery.append(whereQuery.toString());
  		sqlQuery.append(sqlOrder.toString());
            
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery(sqlQuery.toString(), whereValues.toArray());
		return rs;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.08.2004 19:55:00)
	 * @return com.hps.july.cdbc.lib.CDBCResultSet
	 */
	public CDBCResultSet listElectroCounters(String searchFor, String searchValue, String state,
		String control, java.sql.Date controlValue, Integer sortOrder) {

		GregorianCalendar calendar = new GregorianCalendar();
          
		StringBuffer sqlQuery = new StringBuffer("SELECT ");
		sqlQuery.append(" c.counterid, c.vendor_number, c.production_year, c.installation_date,");
  		sqlQuery.append(" c.last_verification, c.next_verification, c.cstate,");
    	sqlQuery.append(" NVL('D' || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) as name ");
     	sqlQuery.append("FROM ");
      	sqlQuery.append(" counters c, positions p, storageplaces sp ");
       	sqlQuery.append("WHERE ");
        sqlQuery.append(" sp.storageplace = p.storageplace AND p.storageplace = c.positionid ");

        StringBuffer sqlOrder = new StringBuffer(" ORDER BY ");
        if(sortOrder != null) {
	        switch(sortOrder.intValue()) {
		        case 1: sqlOrder.append(" c.next_verification "); break;
		        case 2: sqlOrder.append(" c.vendor_number "); break;
		        case 3: sqlOrder.append(" c.vendor_number DESC "); break;
		        case 4: sqlOrder.append(" name "); break;
		        case 5: sqlOrder.append(" name DESC "); break;
		        default: sqlOrder.append(" c.next_verification ");
	        }
        }

		Vector whereClause = new Vector();
  		Vector whereValues = new Vector();

            if(isValid(searchFor) && !searchFor.equals("1") && isValid(searchValue)) {
                if(searchFor.equals("2")) {
	                searchValue = searchValue + CDBCElectroCounterObject.ALL;
                    whereClause.add(" UPPER(c.vendor_number) MATCHES UPPER(?) ");
                    whereValues.add(searchValue);
                } else if(searchFor.equals("3")) {
                    Integer value = null;
                    try {
                        value = new Integer(searchValue);
                        whereClause.add(" p.gsmid = ? ");
                        whereValues.add(value);
                    } catch (Exception e) {}
                } else if(searchFor.equals("4")) {
                    Integer value = null;
                    try {
                        value = new Integer(searchValue);
                        whereClause.add(" p.dampsid = ? ");
                        whereValues.add(value);
                    } catch (Exception e) {}
                } else if(searchFor.equals("5")) {
	                searchValue = searchValue + CDBCElectroCounterObject.ALL;
                    whereClause.add(" UPPER(sp.name) MATCHES UPPER(?) ");
                    whereValues.add(searchValue);
                }
            }
            if(state != null && !state.equals("0")) {
                whereClause.add(" c.cstate = ? ");
                whereValues.add(state);
            }
            
            if(isValid(control) && !control.equals("1")) {
                if(control.equals("2")) {
                    calendar.setTime(new java.util.Date());
                    double month = calendar.get(Calendar.MONTH) + 1.0D - 0.1D;
                    double quarter = Math.ceil(month / 3);
                    if(quarter >= 4.0D) quarter = 1.0D;
                    else quarter += 1.0D;
                    calendar.set(Calendar.MONTH, (int)(quarter * 3));
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    calendar.add(Calendar.DAY_OF_MONTH, -1);
                    whereClause.add(" c.next_verification < ? ");
                    whereValues.add(new java.sql.Date(calendar.getTime().getTime()));
                } else if(control.equals("3")) {
                    if(controlValue != null) {
                        whereClause.add(" c.next_verification < ? ");
                        whereValues.add(controlValue);
                    }
                }
            }
		StringBuffer whereQuery = new StringBuffer("");
  		for (int i = 0; i < whereClause.size(); i++) {
    		whereQuery.append(" AND ");
      		whereQuery.append((String)whereClause.get(i));
        }
    	sqlQuery.append(whereQuery.toString());
  		sqlQuery.append(sqlOrder.toString());
  		//System.out.println("["+ sqlQuery.toString() +"]");
            
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery(sqlQuery.toString(), whereValues.toArray());
		return rs;
	}
	
	/**
	 * "ћеста размещени€ элетросчетчиков".
	 * Creation date: (17.08.2004 19:55:00)
	 * @return com.hps.july.cdbc.lib.CDBCResultSet(+)
	 */
	public CDBCResultSet listElectroCounters(String searchFor, String searchValue, String state,
		String control, java.sql.Date controlValue, String aSortBy) {

		GregorianCalendar calendar = new GregorianCalendar();
          
		StringBuffer sqlQuery = new StringBuffer("SELECT ");
		sqlQuery.append(" c.counterid, c.vendor_number, c.production_year, c.installation_date,");
		sqlQuery.append(" c.last_verification, c.next_verification, c.cstate, c.counterInfo_ID, c.isVendorPowerSupply, ");
		sqlQuery.append(" NVL('D' || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) as name, p.netzone, n.name zoneName, sp.name posName, ci.code ");
		sqlQuery.append("FROM ");
		sqlQuery.append(" counters c, positions p, storageplaces sp, netzones n, counters_info ci ");
		sqlQuery.append("WHERE ");
		sqlQuery.append(" sp.storageplace = p.storageplace AND p.storageplace = c.positionid AND n.netzone = p.netzone AND c.COUNTERINFO_ID = ci.id ");

		StringBuffer sqlOrder = new StringBuffer();
		if(aSortBy != null) {
			sqlOrder.append(" ORDER BY " + aSortBy);	
		}

		Vector whereClause = new Vector();
		Vector whereValues = new Vector();

			if(isValid(searchFor) && !searchFor.equals("1") && isValid(searchValue)) {
				if(searchFor.equals("2")) {
					searchValue = searchValue + CDBCElectroCounterObject.ALL;
					whereClause.add(" UPPER(c.vendor_number) MATCHES UPPER(?) ");
					whereValues.add(searchValue);
				} else if(searchFor.equals("3")) {
					Integer value = null;
					try {
						value = new Integer(searchValue);
						whereClause.add(" p.gsmid = ? ");
						whereValues.add(value);
					} catch (Exception e) {}
				} else if(searchFor.equals("4")) {
					Integer value = null;
					try {
						value = new Integer(searchValue);
						whereClause.add(" p.dampsid = ? ");
						whereValues.add(value);
					} catch (Exception e) {}
				} else if(searchFor.equals("5")) {
					searchValue = searchValue + CDBCElectroCounterObject.ALL;
					whereClause.add(" UPPER(sp.name) MATCHES UPPER(?) ");
					whereValues.add(searchValue);
				}
			}
			if(state != null && !state.equals("0")) {
				whereClause.add(" c.cstate = ? ");
				whereValues.add(state);
			}
            
			if(isValid(control) && !control.equals("1")) {
				if(control.equals("2")) {
					calendar.setTime(new java.util.Date());
					double month = calendar.get(Calendar.MONTH) + 1.0D - 0.1D;
					double quarter = Math.ceil(month / 3);
					if(quarter >= 4.0D) quarter = 1.0D;
					else quarter += 1.0D;
					calendar.set(Calendar.MONTH, (int)(quarter * 3));
					calendar.set(Calendar.DAY_OF_MONTH, 1);
					calendar.add(Calendar.DAY_OF_MONTH, -1);
					whereClause.add(" c.next_verification < ? ");
					whereValues.add(new java.sql.Date(calendar.getTime().getTime()));
				} else if(control.equals("3")) {
					if(controlValue != null) {
						whereClause.add(" c.next_verification < ? ");
						whereValues.add(controlValue);
					}
				}
			}
		StringBuffer whereQuery = new StringBuffer("");
		for (int i = 0; i < whereClause.size(); i++) {
			whereQuery.append(" AND ");
			whereQuery.append((String)whereClause.get(i));
		}
		sqlQuery.append(whereQuery.toString());
		sqlQuery.append(sqlOrder.toString());
		System.out.println("["+ sqlQuery.toString() +"]");
            
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery(sqlQuery.toString(), whereValues.toArray());
		return rs;
	}
		
	/**
	 * Insert the method's description here.
	 * Creation date: (19.08.2004 11:15:09)
	 * @return com.hps.july.cdbc.lib.CDBCResultSet
	 * @param code java.lang.String
	 * @param name java.lang.String
	 */
	public CDBCResultSet listElectroCountersInfo(String code, String name) {

		StringBuffer sqlQuery = new StringBuffer("SELECT ");
		sqlQuery.append(" * ");
    	sqlQuery.append("FROM ");
     	sqlQuery.append(" counters_info c ");

     	StringBuffer sqlOrder = new StringBuffer(" ORDER BY c.code ");

       	Vector whereClause = new Vector();
       	Vector whereValues = new Vector();

		if(isValid(code)) {
			code = code + CDBCElectroCounterObject.ALL;
			whereClause.add(" UPPER(c.code) MATCHES UPPER(?) ");
			whereValues.add(code);
		}
		if(isValid(name)) {
			name = name + CDBCElectroCounterObject.ALL;
			whereClause.add(" UPPER(c.name) MATCHES UPPER(?) ");
			whereValues.add(name);
		}
		StringBuffer whereQuery = new StringBuffer("");
		if(whereClause.size() > 0 && (whereClause.size() == whereValues.size())) {
			whereQuery.append("WHERE ");
            for (int i = 0; i < whereClause.size(); i++) {
                whereQuery.append((String)whereClause.get(i));
                if((i + 1) < whereClause.size()) whereQuery.append(" AND ");
            }
		}
		sqlQuery.append(whereQuery.toString());
		sqlQuery.append(sqlOrder.toString());
            
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery(sqlQuery.toString(), whereValues.toArray());
		return rs;
	}
}
