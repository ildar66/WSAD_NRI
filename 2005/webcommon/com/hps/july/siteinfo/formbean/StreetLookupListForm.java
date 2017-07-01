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

public class StreetLookupListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.String street;
    private java.lang.String type;

    public StreetLookupListForm() {
        this.setFinderMethodName("findByName");
        street = null;
        type = null;
    }
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
            StringBuffer sql =
                new StringBuffer("SELECT r.name, r.sw_member, r.type FROM road r WHERE upper(r.name) matches upper(?) ORDER BY r.name");
            pstmt = connection.prepareStatement(sql.toString());
            pstmt.setString(1, findparam);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String roadName = rs.getString("name");
                String roadType = rs.getString("type");
                if (isValid(roadName))
                    roadName = roadName.trim();
                if (isValid(roadType))
                    roadType = roadType.trim();
                if (unicname.add(roadName + roadType))
                    collection.add(new StreetObjectValue(roadName, roadType));
            }
        } catch (Exception e) {
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (connection != null) connection.close(); } catch (Exception e) {}
        }

        return collection;
    }

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
            ds = (DataSource) context.lookup(dataSourceName);
            if (ds == null)
                throw new Exception("Cannot get DataSource ");
            return ds.getConnection();
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
    public java.lang.Object[] getFilterParams() {
        return new Object[] { street };
    }
    /**
     * Insert the method's description here.
     * Creation date: (06.03.2003 18:11:43)
     * @return java.lang.String
     */
    public java.lang.String getStreet() {
        return street;
    }
    /**
     * Insert the method's description here.
     * Creation date: (27.03.2003 17:52:19)
     * @return java.lang.String
     */
    public java.lang.String getType() {
        return type;
    }
    private boolean isValid(String s) {
        return (s != null && s.trim().length() > 0);
    }
    /**
     * Insert the method's description here.
     * Creation date: (06.03.2003 18:11:43)
     * @param newStreet java.lang.String
     */
    public void setStreet(java.lang.String newStreet) {
        street = newStreet;
    }
    /**
     * Insert the method's description here.
     * Creation date: (27.03.2003 17:52:19)
     * @param newType java.lang.String
     */
    public void setType(java.lang.String newType) {
        type = newType;
    }
}