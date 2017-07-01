package com.hps.july.web.util;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

import com.hps.july.terrabyte.core.TerrabyteServerInfo;
import com.hps.july.terrabyte.ext.client.TerrabyteExternalClientFactory;


public class ProcessProfile {

    private static final Integer NUMBER_TYPE = new Integer(1);
    private static final Integer STRING_TYPE = new Integer(2);
    private static final Integer DATE_TYPE = new Integer(3);
    private static final Integer TEXT_TYPE = new Integer(4);
    private static final String SELECT_OPERATOR_SQL = " SELECT operator FROM operators WHERE loiginid = ? ";
    private static final String SELECT_SQL = " SELECT trim(name) as name, type, num_value, str_value, date_value FROM profile WHERE operatorid = ? AND key = ? AND key_type = ? ";
    private static final String INSERT_SQL =
            (" INSERT INTO profile (operatorid, key, name, key_type, type, num_value, str_value, date_value) " +
            "  VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");
    private static final String UPDATE_SQL = (" UPDATE profile SET num_value = ?, str_value = ?," +
            " date_value = ?, modified = CURRENT WHERE operatorid = ? AND key = ? AND name = ? ");

    private DataSource dataSource = null;

    public ProcessProfile() {
        try {
            String dataSourceName = "julysec";
            InitialContext context = new InitialContext();
            this.dataSource = (DataSource)context.lookup(dataSourceName);
        } catch(Throwable e) {
            System.out.println("ERROR create processor : " + e.toString());
        }
    }
    private boolean createParameter(PreparedStatement pstmt, ProfileRow row) {
        boolean result = false;
        if(row.getOperatorId() == null) return false;
		if(row.getKey() == null) return false;
		if(row.getName() == null) return false;
		if(row.getKeyType() == null) return false;
		if(row.getRowType() == null) return false;
        try {
            pstmt.clearParameters();
			//INSERT INTO profile (operatorid, key, name, key_type, type, num_value, str_value, date_value)
			pstmt.setInt(1, row.getOperatorId().intValue());
			pstmt.setString(2, row.getKey());
			pstmt.setString(3, row.getName());
			pstmt.setInt(4, row.getRowType().intValue());
			pstmt.setInt(5, row.getKeyType().intValue());
			if(row.getNumberValue() != null) pstmt.setBigDecimal(6, new BigDecimal(row.getNumberValue().doubleValue()));
			else pstmt.setNull(6, Types.NUMERIC);
			if(row.getStringValue() != null) pstmt.setString(7, row.getStringValue());
			else pstmt.setNull(7, Types.VARCHAR);
			if(row.getDateValue() != null) pstmt.setTimestamp(8, row.getDateValue());
			else pstmt.setNull(8, Types.TIMESTAMP);
            pstmt.executeUpdate();
            result = true;
        } catch (Exception e) {
			//System.out.println("createParameter ERRRO ! " + (e).toString());
			//if(e instanceof SQLException) System.out.println("createParameter CODE ! " + ((SQLException)e).getErrorCode());
            //e.printStackTrace();
        } finally {
        }
        return result;
    }
    public void loadProfile(Profile profile) {
        loadSystemParameters(profile);
        profile.getProfileAccess();
    }
    public void loadSystemParameters(Profile profile) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //Class.forName("com.informix.jdbc.IfxDriver");
            //connection = DriverManager.getConnection("jdbc:informix-sqli://192.168.18.201:1542:INFORMIXSERVER=beeinfprg;user=vad;password=eclips;database=july;DB_LOCALE=ru_RU.1251;CLIENT_LOCALE=ru_RU.1251");
            connection = this.dataSource.getConnection();
            //System.out.println("Profile:loadProfile Login ["+profile.getLogin()+"]");
            String login = profile.getLogin();
            if(login == null) return;
            if(profile.getOperatorId() == null) {
                profile.setOperatorId(selectOperator(connection, login));
            }
            pstmt = connection.prepareStatement(SELECT_SQL);
            setObject(pstmt, profile.getOperatorId(), 1);
            setObject(pstmt, Profile.SYSTEM, 2);
            setObject(pstmt, new Integer(0), 3);
            rs = pstmt.executeQuery();
            //System.out.println("profile.getOperatorId() ["+profile.getOperatorId()+"]");
            while(rs.next()) {
                String name = rs.getString("name");
                String strVal = rs.getString("str_value");
                double d = rs.getDouble("num_value");
                Double numVal = null;
                if(!rs.wasNull()) numVal = new Double(d);
                Timestamp dateVal = rs.getTimestamp("date_value");
                //System.out.println("name ["+name+"]");
                if(name.equals(Profile.MENU_STATUS)) {
                    //System.out.println("MENUSTATUS ["+strVal+"]");
                    profile.setSystemParameter(Profile.MENU_STATUS, strVal, true);
                } else {
                    if(name.equals(Profile.LAST_VISITED_URL)) {
                        //System.out.println("LAST_VISITED_URL ["+strVal+"]");
                        profile.setSystemParameter(Profile.LAST_VISITED_URL, strVal, true);
                    } else {
	                    if(name.equals(Profile.MENU_ITEM)) {
	                        //System.out.println("MENU_ITEM ["+strVal+"]");
	                        profile.setSystemParameter(Profile.MENU_ITEM, strVal, true);
	                    } else {
							if(name.equals(Profile.TERRABYTE_SERVER)) {
								//System.out.println("TERRABYTE_SERVER ["+numVal+"]");
								if(numVal != null) {
									Integer serverId = new Integer(numVal.intValue());
									profile.setSystemParameter(Profile.TERRABYTE_SERVER, serverId, true);
								}
								TerrabyteServerInfo terrabyteServerInfo = TerrabyteExternalClientFactory.getServerInfo(connection, login);
								if(terrabyteServerInfo != null) {
									profile.setSystemParameter(Profile.TERRABYTE_HOST, terrabyteServerInfo.getHost(), true);																	
									profile.setSystemParameter(Profile.TERRABYTE_PORT, new Integer(terrabyteServerInfo.getPort()), true);
								}
							} else {
		                    
							}
	                    }
                    }
                }
            }
            if(profile.getSystemTerrabyteServer() == null) {
				TerrabyteServerInfo terrabyteServerInfo = TerrabyteExternalClientFactory.getServerInfo(connection, login);
				if(terrabyteServerInfo != null) {
					profile.setSystemParameter(Profile.TERRABYTE_HOST, terrabyteServerInfo.getHost(), true);																	
					profile.setSystemParameter(Profile.TERRABYTE_PORT, new Integer(terrabyteServerInfo.getPort()), true);
				}
            }
        } catch (Exception e) {
            System.out.println("Profile::loadSystemParameters for user ["+profile.getLogin()+"] Error ! " + e.toString());
            if(e instanceof SQLException) System.out.println("LOAD PARAMTER CODE ! " + ((SQLException)e).getErrorCode());
            e.printStackTrace();
        } finally {
            try { if(rs != null) rs.close(); } catch (Exception e) {}
            try { if(pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if(connection != null) connection.close(); } catch (Exception e) {}
        }
    }
    private Integer selectOperator(Connection connection, String login) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer result = null;
        try {
            pstmt = connection.prepareStatement(SELECT_OPERATOR_SQL);
            setObject(pstmt, login, 1);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                result = new Integer(rs.getInt("operator"));
            }
        } catch (Exception e) {
            System.out.println("Profile::selectOperator Error ! " + e.toString());
            if(e instanceof SQLException) System.out.println("selectOperator CODE ! " + ((SQLException)e).getErrorCode());
            e.printStackTrace();
        } finally {
            try { if(rs != null) rs.close(); } catch(Exception e1) {}
            try { if(pstmt != null) pstmt.close(); } catch(Exception e1) {}
        }
        return result;
    }
    private void setObject(PreparedStatement pstmt, Object value, int index) throws SQLException {
		pstmt.setObject(index, value);	
    }
    private boolean updateParameter(PreparedStatement pstmt, ProfileRow row) {
        boolean result = false;
		if(row.getOperatorId() == null) return false;
		if(row.getKey() == null) return false;
		if(row.getName() == null) return false;
		if(row.getKeyType() == null) return false;
		if(row.getRowType() == null) return false;
        try {
            pstmt.clearParameters();
//			private static final String UPDATE_SQL = (" UPDATE profile SET num_value = ?, str_value = ?," +
//					" date_value = ?, modified = CURRENT WHERE operatorid = ? AND key = ? AND name = ? ");

			if(row.getNumberValue() != null) pstmt.setBigDecimal(1, new BigDecimal(row.getNumberValue().doubleValue()));
			else pstmt.setNull(1, Types.NUMERIC);
			if(row.getStringValue() != null) pstmt.setString(2, row.getStringValue());
			else pstmt.setNull(2, Types.VARCHAR);
			if(row.getDateValue() != null) pstmt.setTimestamp(3, row.getDateValue());
			else pstmt.setNull(3, Types.TIMESTAMP);
			pstmt.setInt(4, row.getOperatorId().intValue());
			pstmt.setString(5, row.getKey());
			pstmt.setString(6, row.getName());

            pstmt.executeUpdate();
            result = true;
        } catch (Exception e) {
            System.out.println("Profile::updateParameter Error ! " + e.toString());
            if(e instanceof SQLException) System.out.println("updateParameter CODE ! " + ((SQLException)e).getErrorCode());
            e.printStackTrace();
        } finally {
        }
        return result;
    }
    public void updateProfile(Profile profile) {
        updateSystemParameters(profile);
    }
    public void updateSystemParameters(Profile profile) {
        Connection connection = null;
        PreparedStatement pstmtInsert = null;
        PreparedStatement pstmtUpdate = null;
        try {
            //Class.forName("com.informix.jdbc.IfxDriver");
            //connection = DriverManager.getConnection("jdbc:informix-sqli://192.168.18.201:1542:INFORMIXSERVER=beeinfprg;user=vad;password=eclips;database=july;DB_LOCALE=ru_RU.1251;CLIENT_LOCALE=ru_RU.1251");
            connection = this.dataSource.getConnection();
            String login = profile.getLogin();
            //System.out.println("Profile:updateSystemParameters ["+login+"]");
            if(login == null) return;
            if(profile.getOperatorId() == null) {
                profile.setOperatorId(selectOperator(connection, login));
            }
            pstmtInsert = connection.prepareStatement(INSERT_SQL);
            pstmtUpdate = connection.prepareStatement(UPDATE_SQL);
			ProfileRow row = new ProfileRow();
			row.setOperatorId(profile.getOperatorId());
			//System.out.println("Profile:updateSystemParameters oper id - " + profile.getOperatorId());
            Collection c = profile.getSystemParamsNames();
            for (Iterator iterator = c.iterator(); iterator.hasNext();) {
                String s = (String)iterator.next();
                if(!s.startsWith("ch__")) {
                    Object value = profile.getSystemParam(s);
		            //System.out.println("END ---- ["+s+"] ["+value+"] ");
		            Double num = null;
                    Timestamp ts = null;
                    if(value instanceof String) row.setStringValue((String)value);
                    else if(value instanceof Number) row.setNumberValue((Number)value);
					else if(value instanceof Timestamp) row.setDateValue((Timestamp)value);
					
                    if(s.equals(Profile.MENU_STATUS)) {
                        Character changed = (Character)profile.getSystemParam("ch__" + s);
				        //System.out.println("----["+profile.getLogin()+"]  ["+s+"] ["+value+"]  ["+changed.charValue()+"] ");
						row.setKey(Profile.SYSTEM);
						row.setName(Profile.MENU_STATUS);
						row.setKeyType(new Integer(0));
						row.setRowType(STRING_TYPE);
                        switch(changed.charValue()) {
                            case '2': {
                                boolean result = createParameter(pstmtInsert, row);
								if(!result)
									result = updateParameter(pstmtUpdate, row);
                                if(result) profile.setSystemParameter(Profile.MENU_STATUS, value);
                                
                                break;
                            }
                            case '1': {
                                boolean result = updateParameter(pstmtUpdate, row);
                                if(result) profile.setSystemParameter(Profile.MENU_STATUS, value);
                                break;
                            }
                        }
                    } else {
                        if(s.equals(Profile.LAST_VISITED_URL)) {
                            Character changed = (Character)profile.getSystemParam("ch__" + s);
				            //System.out.println("----["+profile.getLogin()+"]  ["+s+"] ["+value+"]  ["+changed.charValue()+"] ");
							row.setKey(Profile.SYSTEM);
							row.setName(Profile.LAST_VISITED_URL);
							row.setKeyType(new Integer(0));
							row.setRowType(STRING_TYPE);
                            switch(changed.charValue()) {
                                case '2': {
                                    boolean result = createParameter(pstmtInsert, row);
									if(!result) 
										result = updateParameter(pstmtUpdate, row);

                                    if(result) profile.setSystemParameter(Profile.LAST_VISITED_URL, value);
	                                break;
                                }
                                case '1': {
                                    boolean result = updateParameter(pstmtUpdate, row);
                                    if(result) profile.setSystemParameter(Profile.LAST_VISITED_URL, value);
									break;
                               }
                            }
                        } else {
							row.setKey(Profile.SYSTEM);
							row.setName(Profile.MENU_ITEM);
							row.setKeyType(new Integer(0));
							row.setRowType(STRING_TYPE);
	                        if(s.equals(Profile.MENU_ITEM)) {
	                            Character changed = (Character)profile.getSystemParam("ch__" + s);
				            	//System.out.println("----["+profile.getLogin()+"]  ["+s+"] ["+value+"]  ["+changed.charValue()+"] ");
            					switch(changed.charValue()) {
	                                case '2': {
	                                    boolean result = createParameter(pstmtInsert, row);
	                                    if(!result)
											result = updateParameter(pstmtUpdate, row);
	                                    if(result) profile.setSystemParameter(Profile.MENU_ITEM, value);
		                                break;
	                                }
	                                case '1': {
	                                    boolean result = updateParameter(pstmtUpdate, row);
	                                    if(result) profile.setSystemParameter(Profile.MENU_ITEM, value);
										break;
	                               }
	                            }
	                        } else {
		                        
	                        }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("updateParameter::updateSystemParameters for user ["+profile.getLogin()+"] Error ! " + e.toString());
            if(e instanceof SQLException) System.out.println("updateSystemParameters CODE ! " + ((SQLException)e).getErrorCode());

            e.printStackTrace();
        } finally {
            try { if(pstmtInsert != null) pstmtInsert.close(); } catch (Exception e) {}
            try { if(pstmtUpdate != null) pstmtUpdate.close(); } catch (Exception e) {}
            try { if(connection != null) connection.close(); } catch (Exception e) {}
        }
    }

	public String computeURL(ActionMapping mapping, HttpServletRequest request) {
		String path = mapping.getPath();
		String contextPath = request.getContextPath();
		StringBuffer url = new StringBuffer();
		url.append(contextPath).append(path).append(".do");
		String queryString = request.getQueryString();
		if(queryString != null) {
			url.append("?").append(queryString);
		}
		int app = ParamsParser.getRootApp(request.getSession());
		String roopApp = request.getParameter("rootapp");
		if(queryString != null) {
			if(roopApp == null) url.append("&rootapp=").append(app);
		} else {
			if(roopApp == null) url.append("?").append("rootapp=").append(app);
		}

		return url.toString();
	}
	
	public class ProfileRow {
		private Timestamp dateValue;
		private String stringValue;
		private Number numberValue;

		private Integer operatorId;
		private String key;
		private String name;
		private Integer rowType;
		private Integer keyType;

		public Timestamp getDateValue() {
			return dateValue;
		}

		public void setDateValue(Timestamp dateValue) {
			this.dateValue = dateValue;
		}

		public String getStringValue() {
			return stringValue;
		}

		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}

		public Number getNumberValue() {
			return numberValue;
		}

		public void setNumberValue(Number numberValue) {
			this.numberValue = numberValue;
		}

		public Integer getOperatorId() {
			return operatorId;
		}

		public void setOperatorId(Integer operatorId) {
			this.operatorId = operatorId;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getRowType() {
			return rowType;
		}

		public void setRowType(Integer rowType) {
			this.rowType = rowType;
		}

		public Integer getKeyType() {
			return keyType;
		}

		public void setKeyType(Integer keyType) {
			this.keyType = keyType;
		}
	}


    
}
