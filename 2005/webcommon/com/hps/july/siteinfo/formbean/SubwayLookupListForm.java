package com.hps.july.siteinfo.formbean;

import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.hps.july.jdbcpersistence.EnvironmentAccessBean;

/**
 *  ласс описывающий форму выбора станции метро
 */
public class SubwayLookupListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.String subway;

    /**
     *   онструктор
     */ 
    public SubwayLookupListForm() {
        this.setFinderMethodName("findByName");
        subway = null;
    }

    /**
     * ѕрикладной метод дл€ поиска станций метро по названию
     * @param findparam java.lang.String условие поиска станций метрополитена
     * @return java.util.ArrayList возвращает список названий станций удовлетвор€ющих условию поиска
     * @throws Exception в случае ошибки
     */
    public ArrayList findByName(String findparam) throws Exception {

        if (findparam == null)
            return null;

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        HashSet unicname = new HashSet();
        ArrayList collection = new ArrayList();

        try {
            connection = getConnection();
            StringBuffer sql = new StringBuffer("SELECT s.st_name, s.sw_member FROM subwaystation s WHERE upper(s.st_name) matches upper(?) ORDER BY s.st_name");
            pstmt = connection.prepareStatement(sql.toString());
            pstmt.setString(1, findparam);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                String subwayName = rs.getString("st_name");
                if(isValid(subwayName)) subwayName = subwayName.trim();
                if(unicname.add(subwayName))
                    collection.add(new StreetObjectValue(subwayName, null));
            }
        } catch(Exception e) {
        } finally {
            try { if(rs != null) rs.close(); } catch(Exception e) {}
            try { if(pstmt != null) pstmt.close(); } catch(Exception e) {}
            try { if(connection != null) connection.close(); } catch(Exception e) {}
        }
        return collection;
    }
    
    /**
     * ѕрикладной метод дл€ определени€ параметров вызова метода
     * @return массив параметров
     */ 
    public java.lang.Object[] getFilterParams() {
        return new Object[] { subway };
    }
    /**
     * ¬озвращает наименование станции метрополитена
     * Creation date: (17.03.2003 19:01:49)
     * @return java.lang.String
     */
    public java.lang.String getSubway() {
        return subway;
    }
    /**
     * ”станавливает наименование станции метрополитена
     * Creation date: (17.03.2003 19:01:49)
     * @param newSubway java.lang.String
     */
    public void setSubway(java.lang.String newSubway) {
        subway = newSubway;
    }

    /**
     * ћетод <b>getConnection</b> позвол€ет получить connection из пула.
     * @return <code>java.sql.Connection</code>
     * @throws java.sql.SQLException в случае невозможности получить <code>javax.sql.DataSource</code>
     */
    private Connection getConnection() throws SQLException {
        try {
            DataSource ds = null;
            EnvironmentAccessBean access = new EnvironmentAccessBean();
            Properties properties = access.getEnvironmentProperties();
            String dataSourceName = properties.getProperty("DATASOURCE_MAP_NAME");
            String factoryClass = properties.getProperty("FACTORY_CLASS");
            properties = new Properties();
            properties.put(Context.PROVIDER_URL, "iiop://");
            properties.put(Context.INITIAL_CONTEXT_FACTORY, factoryClass);
            InitialContext context = new InitialContext(properties);
            ds = (DataSource)context.lookup(dataSourceName);
            if(ds == null) throw new Exception("Cannot get DataSource ");
            return ds.getConnection();
        } catch(Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    /**
     * ”тилитный метод проверки корректности строки  
     * @param s java.lang.String
     * @return boolean  
     */ 
    private boolean isValid(String s) {
        return (s != null && s.trim().length() > 0);
    }
}