package com.hps.july.sitedoc.actionbean;

import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.sitedoc.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.valueobject.ValueObject;
import com.hps.july.terrabyte.core.TerrabyteServerInfo;
import com.hps.july.terrabyte.ext.client.TerrabyteExternalClientFactory;


/**
 * Insert the type's description here.
 * Creation date: (19.08.2005 16:20:45)
 * @author: Vadim Glushkov
 */
public class ShowRegionDocumentsAction extends com.hps.july.web.util.BrowseAction {
    protected Collection getRegionsAndMaps(String userName, boolean isAdmin) {
        ArrayList objects = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JdbcConnection jdbc = new JdbcConnection();
        try {
            StringBuffer sql = new StringBuffer("SELECT ");
            sql.append("    DISTINCT ");
            sql.append("    s.supregid as sid, trim(s.supregname) as sname, ");
            sql.append("    r.regionid as rid, trim(r.regname) as rname, ");
            sql.append("    n.netzone as nid, trim(n.name) as nname, ");
            sql.append("    m.id as mid, trim(m.name) as mname ");
            sql.append(" FROM ");
            sql.append("    maps m, maps2supregions ms, superregions s, regions r, outer(netzones n) ");
            sql.append(" WHERE ");
            sql.append("    n.regionid = r.regionid AND ");
            sql.append("    r.supregid = s.supregid AND ");
            sql.append("    s.supregid = ms.supregid AND m.id = ms.mapid ");
            sql.append("    AND m.preview = 'N' AND m.visibility = 'Y' ");
            sql.append("    AND m.definition IS NOT NULL ");
            System.out.println("Remote user ["+userName+"]");

            if(userName != null && !isAdmin) {
                sql.append(" AND (r.regionid IN ( ");
                sql.append(" SELECT r1.regionid FROM ");
                sql.append("     regionsaccess ra, regions r1, superregions s, operators o ");
                sql.append(" WHERE ");
                sql.append("     ra.accesstype = 'S' ");
                sql.append("     AND ra.viewplan = 'Y'  ");
                sql.append("     AND s.supregid = ra.supregionid ");
                sql.append("     AND r1.supregid = s.supregid AND ");
                sql.append("     ra.operatorid=o.operator AND o.loiginid = ? )");
                sql.append(" OR r.regionid IN ( ");
                sql.append(" SELECT r1.regionid FROM ");
                sql.append("     regionsaccess ra, regions r1, operators o");
                sql.append(" WHERE ");
                sql.append("     ra.accesstype = 'R' ");
                sql.append("     AND ra.viewplan = 'Y' ");
                sql.append("     AND r1.regionid = ra.regionid ");
                sql.append("     AND ra.operatorid=o.operator AND o.loiginid = ? ");
                sql.append(" )) ");
            }
            StringBuffer orderQuery = new StringBuffer(" ORDER BY sid, sname ");
            sql.append(orderQuery.toString());

/*
            System.out.println(" SQL ["+sql.toString()+"]");
*/
            connection = jdbc.getConnection();
            pstmt = connection.prepareStatement(sql.toString());
            if(userName != null && !isAdmin) {
                pstmt.setString(1, userName);
                pstmt.setString(2, userName);
            }
            rs = pstmt.executeQuery();
            HashMap sr = new HashMap();
            HashMap sm = new HashMap();
            while(rs.next()) {
                Integer supregionId = new Integer(rs.getInt("sid"));
                String supregionName = rs.getString("sname");
                Integer regionId = new Integer(rs.getInt("rid"));
                String regionName = rs.getString("rname");
                Integer zoneId = new Integer(rs.getInt("nid"));
                String zoneName = rs.getString("nname");
                Integer mapId = new Integer(rs.getInt("mid"));
                if(rs.wasNull()) mapId = null;
                String mapName = rs.getString("mname");
                if(rs.wasNull()) mapName = null;

                ValueObject srVo = new ValueObject(supregionId, supregionName);
                ValueObject rVo = new ValueObject(regionId, regionName);
                ValueObject zVo = new ValueObject(zoneId, zoneName);
                ValueObject mVo = new ValueObject(mapId, mapName);

                HashMap r = (HashMap)sr.get(srVo);
                if(r == null) {
                    r = new HashMap();
                    sr.put(srVo, r);
                }
                HashMap z = (HashMap)r.get(rVo);
                if(z == null) {
                    z = new HashMap();
                    r.put(rVo, z);
                }
                z.put(zVo, null);

                HashMap m = (HashMap)sm.get(srVo);
                if(m == null) {
                    m = new HashMap();
                    sm.put(srVo, m);
                }
                m.put(mVo, null);


/*
                System.out.println(" ["+maps.toString()+"]");
*/

/*
                ValueObject region = new ValueObject(regionId, regionName);
                ValueObject map = null;
                if(mapId != null && mapName != null) {
                    if(mapName != null) mapName = mapName.trim();
                    map = new ValueObject(mapId, mapName);
                }
                //System.out.println("DATA : "+regionId+","+regionName+","+mapId+","+mapName+",");
                if(objects.containsKey(regionId)) {
                    RegionAndMap ram = (RegionAndMap)objects.get(regionId);
                    if(map != null) ram.addMap(map);
                } else {
                    RegionAndMap ram = new RegionAndMap(region);
                    if(map != null) ram.addMap(map);
                    objects.put(regionId, ram);
                }
*/
            }

            StringBuffer supregions = new StringBuffer(" var supregions = new Array( \n");
            StringBuffer regions = new StringBuffer(" var regions = new Array( \n");
            StringBuffer zones = new StringBuffer(" var zones = new Array( \n");
            Set set = sr.keySet();
            for (Iterator iterator = set.iterator(); iterator.hasNext();) {
                ValueObject vo = (ValueObject)iterator.next();
                supregions.append("\tnew ValueObject('").append(vo.getId()).append("', ").append("'").append(vo.getName()).append("')");
                if(iterator.hasNext()) supregions.append(", \n");
                HashMap hash = (HashMap)sr.get(vo);
                regions.append(" new Array( \n");
                zones.append(" new Array( \n");
                Set set1 = hash.keySet();
                for (Iterator iterator2 = set1.iterator(); iterator2.hasNext();) {
                    ValueObject vo1 = (ValueObject)iterator2.next();
                    regions.append("\t\tnew ValueObject('").append(vo1.getId()).append("', ").append("'").append(vo1.getName()).append("')");
                    if(iterator2.hasNext()) regions.append(", \n");
                    HashMap hash3 = (HashMap)hash.get(vo1);
                    Set set3 = hash3.keySet();
                    zones.append(" new Array( \n");
                    for (Iterator iterator3 = set3.iterator(); iterator3.hasNext();) {
                        ValueObject vo3 = (ValueObject)iterator3.next();
                        zones.append("\t\tnew ValueObject('").append(vo3.getId()).append("', ").append("'").append(vo3.getName()).append("')");
                        if(iterator3.hasNext()) zones.append(", \n");
                    }
                    zones.append(" ) \n");
                    if(iterator2.hasNext()) zones.append(", \n");
                }
                regions.append(" ) \n");
                zones.append(" ) \n");
                if(iterator.hasNext()) {
                    regions.append(", \n");
                    zones.append(", \n");
                }
            }
            supregions.append(" ); ");
            regions.append(" ); ");
            zones.append(" ); ");
            StringBuffer maps = new StringBuffer(" var maps = new Array( \n");
            Collection col = sm.values();
            for (Iterator iterator = col.iterator(); iterator.hasNext();) {
                HashMap mm = (HashMap)iterator.next();
                set = mm.keySet();
                maps.append("\t new Array( \n");
                for (Iterator iterator1 = set.iterator(); iterator1.hasNext();) {
                    ValueObject vo1 = (ValueObject)iterator1.next();
                    maps.append("\t\tnew ValueObject('").append(vo1.getId()).append("', ").append("'").append(vo1.getName()).append("')");
                    if(iterator1.hasNext()) maps.append(", \n");
                }
                maps.append(")");
                if(iterator.hasNext()) maps.append(", \n");
            }
            maps.append(" ); ");
            objects.add(supregions.toString());
            objects.add(regions.toString());
            objects.add(zones.toString());
            objects.add(maps.toString());

        } catch(Exception e) {
            System.out.println("Error !!! ["+e.toString()+"]");
            if(e instanceof SQLException) System.out.println("Message !!! ["+((SQLException)e).getErrorCode()+"]");
        } finally {
            try { if(rs != null) rs.close(); } catch(SQLException e) {}
            try { if(pstmt != null) pstmt.close(); } catch(SQLException e) {}
            try { if(connection != null) connection.close(); } catch(SQLException e) {}
        }
        return objects;
    }
	    /**
	     * Основной метод обработки запроса.
	     * Process the specified HTTP request, and create the corresponding HTTP
	     * response (or forward to another web component that will create it).
	     * Return an <code>ActionForward</code> instance describing where and how
	     * control should be forwarded, or <code>null</code> if the response has
	     * already been completed.
	     *
	     * @param mapping The ActionMapping used to select this instance
	     * @param actionForm The optional ActionForm bean for this request (if any)
	     * @param request The HTTP request we are processing
	     * @param response The HTTP response we are creating
	     *
	     * @exception IOException if an input/output error occurs
	     * @exception ServletException if a servlet exception occurs
	     */
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
        String userName = request.getRemoteUser();
        boolean isAdmin = request.isUserInRole("administrator");
		Collection rm = getRegionsAndMaps(userName, isAdmin);
		JdbcConnection jdbc = null;
		Connection connection = null;
		try {
			jdbc = new JdbcConnection();
			connection = jdbc.getConnection();
			Profile profile = (Profile)request.getSession().getAttribute(Profile.PROFILE);
			//получение урл для доступа к модулю террабайт
			TerrabyteServerInfo info =  TerrabyteExternalClientFactory.getServerInfo(connection, userName);
			//для оптимизации, чтобы не обращаться каждый раз к базе,
			// можно вызвать методы один раз и сохранить урли
			// в переменной пользовательской сессии (профиль пользователя)
			// рекомендуется так же сохранить сервер и порт
			// для более удобного вызова клиента
			//урл для проектов - аналог переменной TerrabyteURL_prj
			String terrabyteURL = TerrabyteExternalClientFactory.getTerrabyteURL(info);
			request.setAttribute("terrabyteURL", terrabyteURL);		
		} catch(SQLException e) {
			System.out.println("Message !!! ["+((SQLException)e).getErrorCode()+"]");
		} catch(Exception e) {
			System.out.println("Error !!! ["+e.toString()+"]");
		} finally {
			if(connection != null)  try { connection.close(); } catch(SQLException e) {}
		}
		
		request.setAttribute("supregAndReg", rm);		
		ParamsParser.setState( request, Applications.SITEDOC, APPStates.REGION_DOCUMENTS );
		return mapping.findForward( "main" );

	}
}
