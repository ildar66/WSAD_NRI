package com.hps.july.basestation.actionbean;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.basestation.APPStates;
import com.hps.july.basestation.formbean.*;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.constants.*;
import com.hps.july.web.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * ќбработчик формы редактировани€ мощности по каналам
 */
public class EditChanalPowerAction
	extends org.apache.struts.action.Action
{
private String[][] createParams(HttpServletRequest request) throws Exception{
//—оздаем двумерный массив. Ёто параметры дл€ ChanalPowerAccessBean
//ѕервый элемент - канал, второй - пол€ризаци€, третий - мощность

	try{		
		Enumeration enum = request.getParameterNames();
		ArrayList ar = new ArrayList();
		while(enum.hasMoreElements()){
			String name = (String)enum.nextElement();
			if(name.startsWith("vertical") || name.startsWith("cross"))//polarization
				ar.add(name);
		}
		
		String[][] values = new String[ar.size()][];
		
		for(int i = 0; i < ar.size(); i++){
			String[] params = new String[3];
			String name = (String)ar.get(i);
			if(name.startsWith("vertical")){
				params[0] = name.substring(8);//chanal
				params[1] = "V";//polarization
			}
			else if(name.startsWith("cross")){
				params[0] = name.substring(5);//chanal
				params[1] = "C";//polarization
			}
			
			params[2] = request.getParameter(name);//power
			values[i] = params;
		}

		return values;
	}catch(Exception e){
		e.printStackTrace(System.out);
		throw e;
	}	
}
private String[][] createParams(HttpServletRequest request, String band) throws Exception{
//—оздаем двумерный массив. Ёто параметры дл€ ChanalPowerAccessBean
//ѕервый элемент - канал, второй - пол€ризаци€, третий - мощность

	try{		
		Enumeration enum = request.getParameterNames();
		ArrayList ar = new ArrayList();
		while(enum.hasMoreElements()){
			String name = (String)enum.nextElement();
			if(name.startsWith("vertical" + band) || name.startsWith("cross" + band))//polarization
				ar.add(name);
		}
		
		String[][] values = new String[ar.size()][];
		int bandLenghtStr = band.length();
		for(int i = 0; i < ar.size(); i++){
			String[] params = new String[3];
			String name = (String)ar.get(i);
			if(name.startsWith("vertical" + band)){
				params[0] = name.substring(8 + bandLenghtStr);//chanal
				params[1] = "V";//polarization
			}
			else if(name.startsWith("cross" + band)){
				params[0] = name.substring(5 + bandLenghtStr);//chanal
				params[1] = "C";//polarization
			}
			
			params[2] = request.getParameter(name);//power
			values[i] = params;
		}

		return values;
	}catch(Exception e){
		e.printStackTrace(System.out);
		throw e;
	}	
}
private void job(HttpServletRequest request) throws Exception {
    //ѕервый элемент - канал, второй - пол€ризаци€, третий - мощность

    //public void ejbCreate(int argEquipment, int argChanal, String argPolarization, int argPower) 
    try {
        String basestation = request.getParameter("basestation");
        if (basestation.endsWith("#"))
            basestation = basestation.substring(basestation.length() - 1);
        String[][] params900 = createParams(request, "9");
        String[][] params1800 = createParams(request, "18");

/*        for(int i=0; i<params900.length; i++){
	       String[] param = params900[i];
	       System.out.println(
                        "900:basestation="+ basestation+"\tchanal="+ param[0]
                         + "\tpolarization="+ param[1]+"\tpower="+ param[2]);
        }
        for(int i=0; i<params1800.length; i++){
	       String[] param = params1800[i];
	       System.out.println(
                        "1800:basestation="+ basestation+"\tchanal="+ param[0]
                         + "\tpolarization="+ param[1]+"\tpower="+ param[2]);
        }
*/        
        int basestationInt = (new Integer(basestation)).intValue();
        
		JdbcConnection jcon = new JdbcConnection();
		java.sql.Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement("DELETE FROM chanalpowers WHERE equipment = ?");
			st.setInt(1, basestationInt);
			st.executeUpdate();
			st.close();
			StringBuffer sqlInsert = new StringBuffer();
			sqlInsert.append(" INSERT INTO chanalpowers ");
			sqlInsert.append(" (equipment, chanal, polarization, band, power) " );
			sqlInsert.append(" VALUES (?, ?, ?, ?, ?) " );
			st = con.prepareStatement(sqlInsert.toString());

			for (int i = 0; i < params900.length; i++) {
				String[] param = params900[i];
                try {
		            st.clearParameters();
		            st.setInt(1, basestationInt);
		            st.setInt(2, Integer.parseInt(param[0]));
		            st.setString(3, param[1]);
		            st.setInt(4, 900);
		            st.setInt(5, Integer.parseInt(param[2]));
		            st.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Error in EditChanalPowerAction. Msg is=" + e.getMessage());
                    System.out.println(
                        "900:basestation="+ basestation+"\tchanal="+ param[0]
                         + "\tpolarization="+ param[1]+"\tpower="+ param[2]);
                }
	        }
			for (int i = 0; i < params1800.length; i++) {
				String[] param = params1800[i];
                try {
		            st.clearParameters();
		            st.setInt(1, basestationInt);
		            st.setInt(2, Integer.parseInt(param[0]));
		            st.setString(3, param[1]);
		            st.setInt(4, 1800);
		            st.setInt(5, Integer.parseInt(param[2]));
		            st.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Error in EditChanalPowerAction. Msg is=" + e.getMessage());
                    if(e instanceof SQLException)
                    	System.out.println("Error in EditChanalPowerAction. Msg is=" + ((SQLException)e).getErrorCode());
                    System.out.println(
                        "1800:basestation="+ basestation+"\tchanal="+ param[0]
                         + "\tpolarization="+ param[1]+"\tpower="+ param[2]);
                }
	        }
				
			
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try { if(st != null) st.close(); } catch (Exception e) { e.printStackTrace(System.out); }
			try { if(con != null) con.close(); } catch (Exception e) { e.printStackTrace(System.out); }
		}

/*        for (int i = 0; i < params.length; i++) {
            String[] param = params[i];
            try {
                ChanalPowerAccessBean ab = new ChanalPowerAccessBean();
                ab.setInitKey_basestation_storageplace(new Integer(basestation));
                ab.setInitKey_chanal(Integer.parseInt(param[0]));
                ab.setInitKey_polarization(param[1]);
                ab.refreshCopyHelper();
				ab.setPower(Integer.parseInt(param[2]));
				ab.commitCopyHelper();
            } catch (Exception e) {
                try {
                    ChanalPowerAccessBean ab =
                        new ChanalPowerAccessBean(
                            Integer.parseInt(basestation),
                            Integer.parseInt(param[0]),
                            param[1],
                            Integer.parseInt(param[2]));
                } catch (Exception e2) {
                    System.out.println("Error in EditChanalPowerAction. Msg is=" + e.getMessage());
                    System.out.println(
                        "basestation="+ basestation+"\tchanal="+ param[0]
                         + "\tpolarization="+ param[1]+"\tpower="+ param[2]);
                }
            }
        }
*/        
		System.out.println("OK");
    } catch (Exception e) {
        e.printStackTrace(System.out);
        throw e;
    }
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

	super.perform(mapping, form, request, response);    

	try{
		job(request);
		System.out.println("after job");
		storeChanalPowerPermit(form);
		//ParamsParser.setState(request, Applications.BASESTATION, APPStates.VIEWCHANALPOWERS);
		ActionForward af = mapping.findForward("returnPage");
		String path = request.getParameter("returnPage")+"?basestation="+request.getParameter("basestation");
		af.setPath(path.substring(1));
		System.out.println("path="+path);
	    return af;
	}catch(Exception e){
		e.printStackTrace(System.out);
		ActionErrors errors = new ActionErrors();
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("chanalpower.error.edit"));		
		saveErrors(request, errors);
		
		//ParamsParser.setState(request, Applications.BASESTATION, APPStates.SECT_EDIT);
		ParamsParser.setState(request, Applications.BASESTATION, APPStates.MAIN);
	    return mapping.findForward("main");
	}
}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.08.2005 11:10:57)
	 * @param form org.apache.struts.action.ActionForm
	 */
	protected final void storeChanalPowerPermit(ActionForm form) {
		ShowChanalPowerForm aForm = (ShowChanalPowerForm)form;

		JdbcConnection jcon = new JdbcConnection();
		java.sql.Connection con = null;
		PreparedStatement st = null;
		try {
			con = jcon.getConnection();
			st = con.prepareStatement("DELETE FROM chanalpowerpermit WHERE equipment = ?");
			st.setInt(1, aForm.getBasestation());
			st.executeUpdate();
			st.close();
			StringBuffer sqlInsert = new StringBuffer();
			sqlInsert.append(" INSERT INTO chanalpowerpermit ");
			sqlInsert.append(" (idpermit, equipment, polarization, band, startnumber, endnumber) " );
			sqlInsert.append(" VALUES (?, ?, ?, ?, ?, ?) " );
			st = con.prepareStatement(sqlInsert.toString());

			ArrayList al = aForm.getRangeAll();
			Iterator it = al.iterator();
			while(it.hasNext()) {
				RangeAllow	ra = (RangeAllow)it.next();
				System.out.println("900 ra ["+ra.getStartnumber()+"] ["+ra.getEndnumber()+"]");
                try {
					Integer key = getNextKey(con, "tables.chanalpowerpermit");
					if(key != null) {
						String polar = ra.getPolar();
						if(polar != null) {
				            st.clearParameters();
				            st.setInt(1, key.intValue());
				            st.setInt(2, aForm.getBasestation());
				            st.setString(3, polar);
				            st.setInt(4, 900);
				            st.setInt(5, ra.getStartnumber().intValue());
				            st.setInt(6, ra.getEndnumber().intValue());
				            st.executeUpdate();
						}
					}
                } catch (Exception e) {
                    System.out.println("Error in EditChanalPowerAction. Msg is=" + e.getMessage());
                    System.out.println(
                        "900:basestation="+ aForm.getBasestation()+"\tstart="+ ra.getStartnumber()
                         + "\tpolarization="+ ra.getPolar()+"\tend="+ ra.getEndnumber());
                }
			}
			al = aForm.getRange1800All();
			it = al.iterator();
			while(it.hasNext()) {
				RangeAllow	ra = (RangeAllow)it.next();
				System.out.println("1800 ra ["+ra.getStartnumber()+"] ["+ra.getEndnumber()+"]");
                try {
					Integer key = getNextKey(con, "tables.chanalpowerpermit");
					if(key != null) {
						String polar = ra.getPolar();
						if(polar != null) {
				            st.clearParameters();
				            st.setInt(1, key.intValue());
				            st.setInt(2, aForm.getBasestation());
				            st.setString(3, polar);
				            st.setInt(4, 1800);
				            st.setInt(5, ra.getStartnumber().intValue());
				            st.setInt(6, ra.getEndnumber().intValue());
				            st.executeUpdate();
						}
					}
                } catch (Exception e) {
                    System.out.println("Error in EditChanalPowerAction. Msg is=" + e.getMessage());
                    System.out.println(
                        "1800:basestation="+ aForm.getBasestation()+"\tstart="+ ra.getStartnumber()
                         + "\tpolarization="+ ra.getPolar()+"\tend="+ ra.getEndnumber());
                }
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try { if(st != null) st.close(); } catch (Exception e) { e.printStackTrace(System.out); }
			try { if(con != null) con.close(); } catch (Exception e) { e.printStackTrace(System.out); }
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (23.08.2005 11:14:05)
	 * @return java.lang.Integer
	 * @param connection com.ibm.rmi.iiop.Connection
	 * @param tableName java.lang.String
	 */
	protected Integer getNextKey(Connection connection, String alias) {
        Integer result = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement("EXECUTE PROCEDURE getSequence(?)");
            pstmt.setString(1, alias);
            rs = pstmt.executeQuery();
            rs.next();
            result = new Integer(rs.getInt(1));
        } catch( Exception e ) {
            if(e instanceof SQLException) {
                System.out.println("---Code ["+((SQLException)e).getErrorCode()+"]");
            }
            e.printStackTrace();
        } finally {
            try{ if(rs != null) rs.close(); } catch( Throwable t )  {}
            try{ if(pstmt != null) pstmt.close(); } catch( Throwable t ) {}
        }
        return result;
	}
}
