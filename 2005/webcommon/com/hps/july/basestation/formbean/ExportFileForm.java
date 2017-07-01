package com.hps.july.basestation.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.util.ListIterator;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.constants.*;
import com.hps.july.jdbcpersistence.lib.*;


/**
 * Форма загрузки данных
 */
public class ExportFileForm extends ExportForm{
	public static java.lang.String HEXLOADCOORD = "hexagonLoadCoordinates";
	public static java.lang.String HEXLOADTRX = "hexagonloadtrx";
	public static java.lang.String HEXLOADANT = "hexagonUnloadAntens";
	public static java.lang.String HEXFREQCONSTR = "hexagonFreqConstraints";
	private java.lang.String[] loadCoordLabels = {"Sector","Latitude","Longitude","Azimuth"};
	private java.lang.String[] loadAntLabels = {"siteName","address","MSC","BSC","Eng","SectorName"
		,"SectorCode","Power","TransmitType","TransmitTypeU","BSIC","DTX","Traffic","CellID"
		,"LacID","RadNum","X","Y","AntennaHeight","Azimuth","Title","AntName","Status","AntennaID"
		,"Electrical Tilt","T or F","Sector BAND"};
	private java.lang.String[] freqConstrLabels = {"Sector","Frequency","Co"};
	private java.lang.String[] loadTrxLabels = {"Sector","TrxId","Type","Carrier"};
public ExportFileForm(){	
	setLastVisited(true);
}
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception{
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 11:14:39)
 * @return java.lang.String
 */
public String getAction() {
	return "Edit";
}
public int getApplication() {
return Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2005 10:41:06)
 * @return java.lang.String
 */
public String getFile() {
	Connection conn = null;
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
    
    try {
	    StringBuffer result = new StringBuffer();
		conn = new JdbcConnection().getConnection();
	    
	    if(getProc().equals(ExportFileForm.HEXLOADANT)){
			ps = conn.prepareStatement( "execute procedure " + getProc() + "(?,?,?);" );		
			ps.setInt(1,Integer.parseInt(getRegioncode()));
			ps.setFloat(2,Float.parseFloat(getMerid()));
			ps.setInt(3,getRecountCoord()?1:0);
		    
	    }else{		    
			ps = conn.prepareStatement( "execute procedure " + getProc() + "(?);" );		
			ps.setInt(1,Integer.parseInt(getRegioncode()));	
			
	    }
	    ResultSet rs = ps.executeQuery();	    
		ResultSetMetaData rsmd = rs.getMetaData();
		
		int column = rsmd.getColumnCount();		
		
			for(int i=0;i<column;i++){
				
				if(getProc().equals(ExportFileForm.HEXLOADANT)){	
					result.append("\"").append(loadAntLabels[i]).append("\"").append("\t");				
				}else if(getProc().equals(ExportFileForm.HEXLOADCOORD)){
					result.append(loadCoordLabels[i]).append("\t");				
				}else if(getProc().equals(ExportFileForm.HEXLOADTRX)){
					result.append("\"").append(loadTrxLabels[i]).append("\"").append("\t");
				}else if(getProc().equals(ExportFileForm.HEXFREQCONSTR)){
					result.append(freqConstrLabels[i]).append("\t");
				}
			}
				
		result.append("\r\n");
		
		while(rs.next()){
			for(int i = 1;i<=column;i++){
				String value = rs.getString(i);
				if(getProc().equals(ExportFileForm.HEXLOADCOORD) && value.indexOf("\"")!=-1){					
					value = value.substring(value.indexOf("\"")+1,value.lastIndexOf("\""));
				}
				result.append(value).append("\t");		
			}
			result.append("\r\n");
		}	
		return result.toString();	

    } catch (Exception e) {
        e.printStackTrace(System.out);
        return null;
    }finally{
	    try{
		    if(ps!=null) ps.close();
		    if(ps2!=null) ps2.close();
		    if(ps3!=null) ps3.close();
		    if(ps4!=null) ps4.close();		    
		    if(conn!=null) conn.close();
	    }catch(Exception exc){
		    exc.printStackTrace();
	    }
    }
}
public int getState(){
	return 0;
}
public void validateValues(ActionErrors errors) throws ValidationException 
{
	if(getProc().equals("hexagonUnloadAntens")){
		if (getMerid()==null || getMerid().equals("")){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.workresponsibility.position"));
		}
	}	
	if (!errors.empty())
	{
		throw new ValidationException();
	}
}
}
