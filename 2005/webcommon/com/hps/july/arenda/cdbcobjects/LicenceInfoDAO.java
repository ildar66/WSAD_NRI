package com.hps.july.arenda.cdbcobjects;

import java.sql.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
/**
* Insert the type's description here.
* Creation date: (01.06.2005 14:32:38)
* @author: Shafigullin Ildar
*/
public class LicenceInfoDAO extends PageDAO {
/**
 * getSearchSQLString method comment.
 */
protected String getSearchSQLString(Object projCriteria, String orderBy) {
	return "EXECUTE PROCEDURE getAllLicencePosition("+projCriteria+")";
}
protected Object populateRow(ResultSet rs, int numberOfColumns) throws SQLException {
    /**		
    		Object[] values = new Object[numberOfColumns];
    		// Read values for current row and save
    		// them in the values array
    		for (int i = 0; i < numberOfColumns; i++) {
    			Object columnValue = rs.getObject(i+1);
    			values[i] = columnValue;
    		}
    */
    LicenciesOnPos_VO vo = new LicenciesOnPos_VO();
    vo.setTypeLicence((Integer) rs.getObject(1));
    vo.setDateLicence((java.sql.Date)rs.getObject(2));
    vo.setCreatedBy((Integer) rs.getObject(3));
    vo.setCreatedName(rs.getString(4) != null ? rs.getString(4): "" );
    vo.setCreated(rs.getTimestamp(5));
    vo.setModifiedBy((Integer) rs.getObject(6));
    vo.setModifiedName(rs.getString(7)!= null ? rs.getString(7): "");
    vo.setModified(rs.getTimestamp(8));
    vo.setNoteLicence(rs.getString(9)!= null ? rs.getString(9).trim(): ""); 
    
    return vo;
}
}
