package com.hps.july.web.util;

import javax.servlet.http.*;
/**
 * Insert the type's description here.
 * Creation date: (07.10.2004 12:35:55)
 * @author: Vadim Glushkov
 */
public class URLUtil {
	/**
	 * URLUtil constructor comment.
	 */
	public URLUtil() {
		super();
	}
	/**
	 * URL הכÿ גûחמגא Microstrategy.
	 * Creation date: (07.10.2004 13:04:01)
	 * @return java.lang.String
	 * @param userName java.lang.String
	 */
	public static String getMicrostrategyURL(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String userName = request.getRemoteUser();
		StringBuffer result = new StringBuffer();
		String s = com.hps.july.util.AppUtils.getNamedValueString("MICROSTRATEGY_URL");
		result.append(s);
		if(userName != null) {
			result.append("&nri_user=").append(userName);
		}
/*		
		if(session != null) {
			String currentUrl = (String)session.getAttribute(Constants.CURRENT_URL);
			if(currentUrl != null) {
				result.append("&back_url=").append(currentUrl);
			}
		}
*/		
		return result.toString();
	}
	/**
	 * URL הכÿ גûחמגא Molkom.
	 * Creation date: (07.10.2004 13:04:01)
	 * @return java.lang.String
	 */
	public static String getMolkomURL(HttpServletRequest request) {

		String userName = request.getRemoteUser();
		StringBuffer result = new StringBuffer();
		String s = com.hps.july.util.AppUtils.getNamedValueString("PathSkladMOLCOMTrailcom");
		result.append(s);
		if(userName != null) {
			result.append("&id=").append(userName);
		}
		return result.toString();
	}

	public static Integer isActiveFileExists(String type, Integer typeId, Integer objectId) {
		Integer result = null;
		
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append("	a.fileid as id ");
		sql.append(" FROM ");
		sql.append("	tb_activefiles a, tb_objects o ");
		sql.append(" WHERE ");
		sql.append(" o.id = a.objectTypeId AND o.type = ? ");
		sql.append(" AND a.typeId = ? AND a.objectId = ? ");
		com.hps.july.cdbc.lib.CDBCResultSet rs = new com.hps.july.cdbc.lib.CDBCResultSet();
		rs.executeQuery(sql.toString(), new Object[] { type, typeId, objectId });
		java.util.Iterator iterator = rs.listIterator();
		if(iterator.hasNext()) {
			result = (Integer)((com.hps.july.cdbc.lib.CDBCRowObject)iterator.next()).getColumn("id").asObject();
		}
		return result;
	}
	
	public static String getTerrabyteActiveFileURL(HttpServletRequest request) {
			String userName = request.getRemoteUser();
			StringBuffer result = new StringBuffer();
			String s = com.hps.july.util.AppUtils.getNamedValueString("TERRABYTE_GETFILE_URL");
			result.append(s);
			//result.append("&fileId=").append(fileId);
			if(userName != null) {
				result.append("&uid=").append(userName);
			}
			return result.toString();
	}
}
