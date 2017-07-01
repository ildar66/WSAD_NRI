package com.hps.july.arenda.cdbcobjects;

import java.sql.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
/**
 * Insert the type's description here.
 * Creation date: (04.05.2005 16:59:06)
 * @author: Shafigullin Ildar
 */
public class LicenceDAO extends PageDAO {
    /**      -- для изменения данных используй процедуру
    create procedure updateLicence(
       i_position integer,        -- код позиции
       i_typeLicence integer,     -- тип разрешения
       i_dateLicence date,        -- дата разрешения
       i_operator CHAR(40)        -- оператор который изменяет запись
       i_noteLicence char(2000)   -- комментарии
     )
        returning 
         integer,                  -- код ошибки  0- нет ошибок
         varchar(255);             -- текст ошибки  
    */
    public final static java.lang.String updateDateLicence_SQL = "EXECUTE PROCEDURE updateLicence(?, ?, ?, ?, ?)";
    private static final String findLicenceOnPosition_SQL =
        "SELECT idlicence, position, typelicence, datelicence, notelicence, docNumber, docDate, created, createdby, modified, modifiedBy "
            + "FROM LicenciesOnPos ";
    private static final String viewLicencesOnPosition_SQL =
        "SELECT v.fas, v.rutsr,  v.air_gr,  v.air_w, v.gps, v.gasn, v.ses,  v.vch, v.tu, v.otvod, v.kadastr, v.property, nvl(v.isNote,'N') isNote "
            + "FROM viewlicenciesonpos v ";
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 13:38:51)
 */
public static LicenciesOnPos_VO findLicenceOnPosition(Integer positionID, Integer typeLicence) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { positionID, typeLicence };
    String sql = findLicenceOnPosition_SQL + "WHERE position=? AND typelicence=? " ;
    res.executeQuery(sql, params);
    java.util.ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    LicenciesOnPos_VO vo = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        vo = new LicenciesOnPos_VO((Integer) ro.getColumn("idlicence").asObject());
        vo.setPosition((Integer) ro.getColumn("position").asObject());
        vo.setTypeLicence((Integer) ro.getColumn("typelicence").asObject());
        vo.setDateLicence((Date)ro.getColumn("datelicence").asObject());
        vo.setNoteLicence(ro.getColumn("notelicence").asString());
    }
    return vo;
}
/**
 * getSearchSQLString method comment.
 */
protected String getSearchSQLString(Object projCriteria, String orderBy) {
    LicenceListForm listForm = (LicenceListForm) projCriteria;
    String searchString = listForm.getSearchstring();
    int filter = listForm.getFilter();
    String fromDate = listForm.getDataPeriod().getFromDateFrm();
    String toDate = listForm.getDataPeriod().getToDateFrm();
    String typesStr = listForm.getTypesStr();
    boolean isDateModified = listForm.getIsDateModified();
    boolean isDopFilter = listForm.getIsDopFilter();
    int regionid = listForm.getCurrRegionID();
    String select =
        "SELECT p.gsmid, p.dampsid, s.name,  v.fas fas, v.rutsr rutsr,  v.air_gr,  v.air_w air_w, v.gps gps, v.gasn gasn, v.ses ses,  v.vch vch, v.tu tu, v.otvod otvod, v.kadastr kadastr,  v.property property,  p.storagePlace, nvl(v.isNote,'N') ";
    StringBuffer sqlb = new StringBuffer(select);
    if(isDopFilter && isDateModified){
    	String selectAdd =  ", getIsModifyLicencie(p.storagePlace, 1, '"+fromDate+"', '"+toDate+"') fasM, getIsModifyLicencie(p.storagePlace, 2, '"+fromDate+"', '"+toDate+"') rutsrM,  getIsModifyLicencie(p.storagePlace, 3, '"+fromDate+"', '"+toDate+"') air_grM,  getIsModifyLicencie(p.storagePlace, 4, '"+fromDate+"', '"+toDate+"') air_wM, getIsModifyLicencie(p.storagePlace, 5, '"+fromDate+"', '"+toDate+"') gpsM, getIsModifyLicencie(p.storagePlace, 6, '"+fromDate+"', '"+toDate+"') gasnM, getIsModifyLicencie(p.storagePlace, 7, '"+fromDate+"', '"+toDate+"') sesM,  getIsModifyLicencie(p.storagePlace, 8, '"+fromDate+"', '"+toDate+"') vchM, getIsModifyLicencie(p.storagePlace, 9, '"+fromDate+"', '"+toDate+"') tuM, getIsModifyLicencie(p.storagePlace, 10, '"+fromDate+"', '"+toDate+"') otvodM, getIsModifyLicencie(p.storagePlace, 11, '"+fromDate+"', '"+toDate+"') kadastrM,  getIsModifyLicencie(p.storagePlace, 12, '"+fromDate+"', '"+toDate+"') propertyM,  getIsModifyLicencie(p.storagePlace, 13, '"+fromDate+"', '"+toDate+"') noteM  ";
	    sqlb.append(selectAdd);
	   }
    sqlb.append("FROM positions p, storageplaces s, outer viewlicenciesonpos v WHERE s.type != 'A' AND s.storageplace = p.storageplace AND p.storageplace = v.position AND  p.regionid = " + regionid);

    //фильтр по "По названию"(1) , "По № GSM/DCS" (2), "По № DAMPS"(3):
    if (filter == 1) {
        sqlb.append(" AND lower(s.name) matches '" + searchString.toLowerCase() + "' ");
    } else if (filter == 2) {
	    if("".equals(searchString.trim()))
        	sqlb.append(" AND p.gsmid is null ");
       	else
       		sqlb.append(" AND p.gsmid= " + searchString.toLowerCase() + " ");
    } else if (filter == 3) {
	     if("".equals(searchString.trim()))
	     	sqlb.append(" AND p.dampsid is null ");
	     else
        	sqlb.append(" AND p.dampsid=" + searchString.toLowerCase() + " ");
    }
    //"изменение данных в колонкеЭ" или "нет данных о разрешениях "
   if(isDopFilter && isDateModified){
	    sqlb.append("AND p.storageplace  IN (");
	    sqlb.append("SELECT l.Position FROM licenciesOnPos l ");
	    sqlb.append("WHERE date(modified) between '"+fromDate+"' and '"+toDate+"' ");
	    sqlb.append("and  typelicence in ("+typesStr+")");
	    sqlb.append(")");
	   }
    else if(isDopFilter && !isDateModified){
	    sqlb.append("AND p.storageplace  IN (");
	    sqlb.append("SELECT l.Position FROM licenciesOnPos l ");
	    sqlb.append("WHERE l.datelicence is null ");	    
	    sqlb.append("and  typelicence in ("+typesStr+")");
	    sqlb.append(")");
	   } 
    //сортировки: 
    if (orderBy != null && !orderBy.equals(""))
        sqlb.append(" order by " + orderBy);
    System.out.println("LicenceDAO sql=" + sqlb.toString()); //temp
    return sqlb.toString();
}
protected Object populateRow(ResultSet rs, int numberOfColumns) throws SQLException {
    LicenciesTO to = new LicenciesTO();
    //осн:
    Integer gsmId = (Integer) rs.getObject(1);
    if (gsmId != null)
        to.setGsmId(gsmId.toString());
    else
        to.setGsmId("");
    Integer dampsId = (Integer) rs.getObject(2);
    if (dampsId != null)
        to.setDampsId(dampsId.toString());
    else
        to.setDampsId("");
    to.setName(rs.getString(3));
    //даты:
    to.setFas(rs.getDate(4));
    to.setRutsr(rs.getDate(5));
    to.setAir_gr(rs.getDate(6));
    to.setAir_w(rs.getDate(7));
    to.setGps(rs.getDate(8));
    to.setGasn(rs.getDate(9));
    to.setSes(rs.getDate(10));
    to.setVch(rs.getDate(11));
    to.setTu(rs.getDate(12));
    to.setOtvod(rs.getDate(13));
    to.setKadastr(rs.getDate(14));
    to.setProperty(rs.getDate(15));
    //storagePlace:
    to.setStoragePlace(rs.getInt(16));
    //isNote:
    to.setIsNote(rs.getString(17));
    if (numberOfColumns > 17) {
        //признаки изменения дат:
        to.setFasM(rs.getString(18));
        to.setRutsrM(rs.getString(19));
        to.setAir_grM(rs.getString(20));
        to.setAir_wM(rs.getString(21));
        to.setGpsM(rs.getString(22));
        to.setGasnM(rs.getString(23));
        to.setSesM(rs.getString(24));
        to.setVchM(rs.getString(25));
        to.setTuM(rs.getString(26));
        to.setOtvodM(rs.getString(27));
        to.setKadastrM(rs.getString(28));
        to.setPropertyM(rs.getString(29));
        to.setNoteM(rs.getString(30));
    }
    return to;
}
/**
 * Creation date: (13.05.2005 15:11:10)
 */
public String updateDateLicence(int i_position, int i_type, Date i_date, String i_operator, String i_noteLicence)
    throws SQLException, ServiceLocatorException {
    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    String errorTxt = ""; //условие ОК(нет ошибок: errorTxt = "")
    try {
        conn = getDataSource().getConnection();
        st = conn.prepareCall(updateDateLicence_SQL);
        st.setInt(1, i_position);
        st.setInt(2, i_type);
        st.setDate(3, i_date);
        st.setString(4, i_operator);
        st.setString(5, i_noteLicence);
        rs = st.executeQuery();
        if (rs.next()) {
            int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
            if (result == 0) {
                System.out.println("Процедура 'updateDateLicence' ok"); //temp
            } else {
                errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
                System.out.println("Процедура 'updateDateLicence' errorTxt: " + errorTxt); //temp
            }
        } else {
            errorTxt = "no DATA: execute procedure 'updateDateLicence";
            System.out.println("no DATA: execute procedure 'updateDateLicence'"); //temp
        }
    } catch (SQLException e) {
        System.out.println("SQLException LicenceDAO.updateDateLicence: ");
        System.out.println("ERROR: code=" + e.getErrorCode() + ", msg=" + e.getMessage());
        e.printStackTrace();
        throw e;
    } catch (ServiceLocatorException exc) {
        System.out.println("ServiceLocatorException LicenceDAO.updateDateLicence: " + exc);
        exc.printStackTrace();
        throw exc;
    } finally {
        try {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
            if (conn != null)
                conn.close();
        } catch (Exception exc) {
            errorTxt = "LicenceDAO.updateDateLicence: не могу закрыть соединение!!!";
            System.out.println("LicenceDAO.updateDateLicence: не могу закрыть соединение!!!");
        }
    }
    return errorTxt;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2005 18:03:12)
 */
public static LicenciesTO viewLicencesOnPosition(Integer positionID) {
    CDBCResultSet res = new CDBCResultSet();
    Object[] params = { positionID };
    String sql = viewLicencesOnPosition_SQL + " WHERE position=? ";
    res.executeQuery(sql, params);
    java.util.ListIterator list = res.listIterator();
    CDBCRowObject ro = null;
    LicenciesTO to = null;
    if (list.hasNext()) {
        ro = (CDBCRowObject) list.next();
        to = new LicenciesTO();
        to.setFas((Date) ro.getColumn("fas").asObject());
        to.setRutsr((Date) ro.getColumn("rutsr").asObject());
        to.setAir_gr((Date) ro.getColumn("air_gr").asObject());
        to.setAir_w((Date) ro.getColumn("air_w").asObject());
        to.setGps((Date) ro.getColumn("gps").asObject());
        to.setGasn((Date) ro.getColumn("gasn").asObject());
        to.setSes((Date) ro.getColumn("ses").asObject());
        to.setVch((Date) ro.getColumn("vch").asObject());
        to.setTu((Date) ro.getColumn("tu").asObject());
        to.setOtvod((Date) ro.getColumn("otvod").asObject());
        to.setKadastr((Date) ro.getColumn("kadastr").asObject());
        to.setProperty((Date) ro.getColumn("property").asObject());
        to.setIsNote(ro.getColumn("isNote").asString().equals("Y")?"+" : "-");
    }
    return to;
}
}
