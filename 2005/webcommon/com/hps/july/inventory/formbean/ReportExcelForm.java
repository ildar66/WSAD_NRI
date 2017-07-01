package com.hps.july.inventory.formbean;

import java.util.ArrayList;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.*;
import com.hps.july.web.util.*;
import com.hps.july.report.*;
import java.io.File;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import jxl.Workbook;
import jxl.write.*;
/**
 * Базовая форма для отчётов
 */
public class ReportExcelForm extends EditForm
{	
    
	private int agregationType;
	private java.lang.String serial;
	private java.lang.Boolean showAgregated;
	private java.util.List places;
	private java.lang.Boolean isManuf;
	private java.lang.Boolean isSerial;
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 10:33:31)
 */
public ReportExcelForm() {
	isSerial = java.lang.Boolean.FALSE;
	isManuf = java.lang.Boolean.FALSE;
	places = new ArrayList();
	//loadData();
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 13:26:07)
 * @return int
 */
public int getAgregationType() {
	return agregationType;
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2005 17:23:19)
 * @return byte[]
 */
public byte[] getExcelFile() {
		WritableWorkbook workbook;
   		WritableSheet sheet;
    	Label columnLabel;
    	Label cellLabel;
    	WritableFont arial10font;
    	WritableCellFormat arial10format;
    	ByteArrayOutputStream baos;

	
		try {
			baos = new java.io.ByteArrayOutputStream();	
			
            workbook = Workbook.createWorkbook(baos);
            sheet = workbook.createSheet("sheet", 0);
            arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
            arial10format = new WritableCellFormat(arial10font);
            arial10format.setAlignment(Alignment.CENTRE);
            for(int i = 0; i < 5; i++)
                sheet.addCell(new Label(i, 0, "wew"));

            sheet.addCell(new Label(3, 1, "sheet", arial10format));
            for(int i = 0; i < 5; i++)
                sheet.addCell(new Label(i, 2, "wewe"));

            for(int i = 0; i < 10; i++) {
                columnLabel = new Label(i, 3, "name1", arial10format);
                sheet.addCell(columnLabel);
            }

            arial10font = new WritableFont(WritableFont.ARIAL, 10);
            arial10format = new WritableCellFormat(arial10font);
            arial10format.setAlignment(Alignment.CENTRE);
            for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 6; j++) {
                    cellLabel = new Label(j, i + 4, "test", arial10format);
                    sheet.addCell(cellLabel);
                }

            }

            workbook.write();
            workbook.close();

        }
        catch(WriteException e) {return null; }
        catch(IOException e) { return null;}

        return baos.toByteArray();
}
public String getFullStorageNameSQL(String tablepref, String fieldname) {
	return	"CASE "+tablepref+".type WHEN 'P' THEN ''  WHEN 'X' THEN '' WHEN 'S' THEN '' ELSE "+
			"NVL((SELECT NVL('D'||pm.gsmid||' ','') || NVL('A'||pm.dampsid||' ', '') || TRIM(sm.name) || ' / ' FROM equipment em, positions pm, storageplaces sm WHERE em.position = pm.storageplace AND pm.storageplace = sm.storageplace AND em.equipment = "+tablepref+".storageplace),'') "+
			"END || "+
			"CASE "+tablepref+".type "+
			"WHEN 'P' THEN (SELECT NVL('A'||p.dampsid||' ','') || NVL('D' || p.gsmid || ' ', '') || TRIM(s.name) FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = "+tablepref+".storageplace) "+
			"WHEN 'S' THEN "+tablepref+".name "+
			"WHEN 'X' THEN (SELECT NVL(trim(o.name),trim(p.lastname) || ' ' || trim(p.firstname) || ' ' || trim(p.middlename)) FROM expedition e, outer organizations o, outer (workers w, people p) WHERE o.organization = e.organization AND e.expeditor = w.worker AND p.man = w.man AND e.expedition = "+tablepref+".storageplace) "+
			"WHEN 'E' THEN "+tablepref+".name "+
			"WHEN 'B' THEN (SELECT 'БС ' || CASE bs.type WHEN 'D' THEN 'DAMPS' WHEN 'S' THEN 'GSM' WHEN 'C' THEN 'DCS' WHEN 'G' THEN 'GSM/DCS' ELSE '' END || ' ' || bs.number || ', ' || bs.name FROM basestations bs WHERE bs.equipment = "+tablepref+".storageplace) "+
			"WHEN 'C' THEN (SELECT 'ТС ' || CASE ce.type WHEN 'R' THEN 'РРЛ ' WHEN 'O' THEN 'ВО ' ELSE '' END || ' ' || TRIM("+tablepref+".name) FROM comequipment ce WHERE ce.equipment = "+tablepref+".storageplace) "+
			"WHEN 'O' THEN (SELECT 'Контроллер ' || NVL(c.number,'') || CASE TRIM(c.name) WHEN '' THEN '' WHEN NULL THEN '' ELSE ', ' || TRIM(c.name) END FROM controllers c WHERE c.equipment = "+tablepref+".storageplace) "+
			"WHEN 'W' THEN (SELECT 'Коммутатор ' || NVL(s.number || ' ','') || TRIM("+tablepref+".name) FROM switches s WHERE s.equipment = "+tablepref+".storageplace) "+
			"WHEN 'T' THEN (SELECT CASE o.type WHEN 'A' THEN 'Всп. Сооружения' WHEN 'B' THEN 'Всп. Техн. оборуд.' WHEN 'C' THEN 'Всп. Хоз. оборуд.' WHEN 'E' THEN 'Всп. Конд. и вент.' ELSE 'Оборуд.' END FROM otherequipment o WHERE o.equipment = "+tablepref+".storageplace) "+
			"WHEN 'R' THEN (SELECT 'Репитер ' || TRIM(r.model) FROM repiters rp, resources r WHERE rp.equipment = "+tablepref+".storageplace AND rp.resource = r.resource) "+
			"WHEN 'L' THEN (SELECT 'WLAN ' || TRIM("+tablepref+".name) || NVL(' '||w.number,'') FROM wlan w  WHERE w.equipment = "+tablepref+".storageplace) "+
			"END "+fieldname+" ";
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 13:48:54)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsManuf() {
	return isManuf;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 13:49:14)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSerial() {
	return isSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 14:13:30)
 * @return java.util.List
 */
public java.util.List getPlaces() {
	return places;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 13:26:26)
 * @return java.lang.String
 */
public java.lang.String getSerial() {
	return serial;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 13:26:58)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowAgregated() {
	return showAgregated;
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPTXLS;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 14:26:57)
 */
public void loadData() {

	

	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	Statement stmt = null;

	places.clear();

	try {
		con = new JdbcConnection().getConnection();
		

		String s;
		String s2;
		String s3;
		String buildin = "";
		String buildinser = "";
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		String serialS = "";
		String manufS = "";
		String orS = "";
		if(getIsSerial().booleanValue()){
			serialS = "sc.serialnumber like ?";
		}
		if(getIsManuf().booleanValue()){
			manufS = "sc.inventserial like ?";
		}
		if(getIsSerial().booleanValue() && getIsManuf().booleanValue()){
			orS = " or ";
		}	
		
		s = "SELECT r.name name,r.manucode manucode, " +
			"r.model model,sc.serialnumber, sc.inventserial manufserial, "+ 
			getFullStorageNameSQL("sp","storageplacename")+ ", "+

			"sc.storagecard card, sc.resource resource, sc.storageplace storageplace " +
			"FROM storagecards sc, resources r, storageplaces sp ,resourcesubtypes rst,resourcetypes rt " +
			"WHERE sc.resource = r.resource AND sc.storageplace = sp.storageplace " +
			"AND r.resourcesubtype = rst.resourcesubtype " +
			"AND rst.resourcetype = rt.resourcetype AND sc.closed = 'N' "  +
			"AND (" + serialS + orS + manufS + ")";
			
			
		s2 = "select name from resources where resource = (select resource from storagecards " + 
		      "where storagecard =(select agregate from agregatecontents where agregatepart = ?))";
		      
		s3 = "select serialnumber from storagecards where storagecard =(select agregate " +
			"from agregatecontents where agregatepart = ?)";      	
			
		pstmt =	con.prepareStatement(s);
		pstmt2 = con.prepareStatement(s2);
		pstmt3 = con.prepareStatement(s3);

		// BEE00001541
		serial = replaceForbiddenChar(serial, '\\');
		serial = replaceForbiddenChar(serial, '%');
		serial = replaceForbiddenChar(serial, '_');
		serial = serial!=null?serial.replace('*','%'):"";
		 
		// System.out.println("### loadData() serial = " + serial); 
		 
		// pstmt.setString(1, serial!=null?serial.replace('*','%'):"");
		pstmt.setString(1, serial);
		
		if(getIsSerial().booleanValue() && getIsManuf().booleanValue()){
			pstmt.setString(2, serial!=null?serial.replace('*','%'):"");
		}
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			ReportExcelTO rto = new ReportExcelTO();
			
			//rto.setView(rs.getString("vid")!=null?rs.getString("vid"):"");
			//rto.setType(rs.getString("type")!=null?rs.getString("type"):"");
			String name = rs.getString("name");
			rto.setName(name!=null?name:"");
			rto.setManucode(rs.getString("manucode")!=null?rs.getString("manucode"):"");
			rto.setModel(rs.getString("model")!=null?rs.getString("model"):"");
			String ser = rs.getString("serialnumber");
			rto.setSerialnumber(ser!=null?ser:"");
			rto.setManufnumber(rs.getString("manufserial")!=null?rs.getString("manufserial"):"");
			rto.setStorageplace(rs.getString("storageplacename")!=null?rs.getString("storageplacename"):"");
			
			String card = rs.getString("card");

			pstmt2.setString(1, card);
			rs3 = pstmt2.executeQuery();
			buildin = "";
			if (rs3.next()) {
				buildin = rs3.getString("name")!=null?rs3.getString("name"):"";
			}
			rto.setBuildin(buildin);

			pstmt3.setString(1, card);
			rs3 = pstmt3.executeQuery();
			buildinser = "";
			if (rs3.next()) {
				buildinser = rs3.getString("serialnumber")!=null?rs3.getString("serialnumber"):"";
			}
			
			rto.setBuildinser(buildinser);
			
			places.add(rto);
			
			if(showAgregated.booleanValue()){
				stmt = con.createStatement();
				
				String sql = "SELECT  r.name name,r.manucode manucode,r.model model,sc.serialnumber, sc.inventserial manufserial, "+
					getFullStorageNameSQL("sp","storageplacename")+ ", "+				
				"sc.storagecard card, sc.resource resource, sc.storageplace storageplace " +
				"FROM storagecards sc, resources r, storageplaces sp ,resourcesubtypes rst " +
				"WHERE sc.resource = r.resource AND sc.storageplace = sp.storageplace AND r.resourcesubtype = rst.resourcesubtype AND " + 
				"sc.storagecard in (SELECT agregatepart FROM agregatecontents a1 WHERE a1.agregate = "+card+") " +
				"ORDER BY r.name";
				
				
				rs2 = stmt.executeQuery(sql);
				while(rs2.next()) {
					ReportExcelTO rto2 = new ReportExcelTO();
					//rto2.setView("");
					//rto2.setType(rs2.getString("type")!=null?rs2.getString("type"):"");
					rto2.setName(rs2.getString("name")!=null?rs2.getString("name"):"");
					rto2.setManucode(rs2.getString("manucode")!=null?rs2.getString("manucode"):"");
					rto2.setModel(rs2.getString("model")!=null?rs2.getString("model"):"");
					rto2.setSerialnumber(rs2.getString("serialnumber")!=null?rs2.getString("serialnumber"):"");
					rto2.setManufnumber(rs2.getString("manufserial")!=null?rs2.getString("manufserial"):"");
					rto2.setStorageplace(/*rs2.getString("storageplacename")!=null?rs2.getString("storageplacename"):*/"");
					rto2.setBuildin(name);
					rto2.setBuildinser(ser);
					places.add(rto2);
				}
				
			}



			
		}
		/*else {
			// no storagecards with this SERNO
			//resourcetitle = "Оборудование с таким серийным номером не найдено";
		}*/
		

		
				
			
				
		
		if(rs!=null) rs.close();
		if(rs2!=null) rs2.close();
		if(rs3!=null) rs3.close();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(stmt!=null)   stmt.close();
			if(pstmt!=null)  pstmt.close();
			if(pstmt2!=null) pstmt2.close();
			if(pstmt3!=null) pstmt3.close();
			if(con!=null)    con.close();
		}
		catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	
}
/**
 * @param serial
 * @param c
 * @return
 */
private String replaceForbiddenChar(String serial, char c) {
	String outString = "";
	if (serial != null) {
		StringBuffer inSb = new StringBuffer(serial);
		StringBuffer outSb = new StringBuffer();
		for (int i = 0; i < inSb.length(); i++) {
			char curChur = inSb.charAt(i);
			if (curChur == c) {
				outSb.append('\\');
			}
			outSb.append(curChur);
		}
		outString = outSb.toString();
	} 
	return outString;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 13:26:07)
 * @param newAgregationType int
 */
public void setAgregationType(int newAgregationType) {
	agregationType = newAgregationType;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 13:48:54)
 * @param newIsManuf java.lang.Boolean
 */
public void setIsManuf(java.lang.Boolean newIsManuf) {
	isManuf = newIsManuf;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2005 13:49:14)
 * @param newIsserial java.lang.Boolean
 */
public void setIsSerial(java.lang.Boolean newIsSerial) {
	isSerial = newIsSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 14:13:30)
 * @param newPlaces java.util.List
 */
public void setPlaces(java.util.List newPlaces) {
	places = newPlaces;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 13:26:26)
 * @param newSerial java.lang.String
 */
public void setSerial(java.lang.String newSerial) {
	serial = newSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2005 13:26:58)
 * @param newShowAgregated java.lang.Boolean
 */
public void setShowAgregated(java.lang.Boolean newShowAgregated) {
	showAgregated = newShowAgregated;
}
}
