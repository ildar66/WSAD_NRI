package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import java.util.HashMap;
import com.hps.july.persistence.EquipmentSetAccessBean;
import java.util.Iterator;
import java.util.LinkedList;
import com.hps.july.cdbc.objects.CDBCEquipmentObject;
import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import com.hps.july.web.util.ValidationException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;
import jxl.Cell;
import jxl.CellType;
import jxl.format.CellFormat;
import jxl.Sheet;
import jxl.Workbook;

/**
 * ‘орма загрузки данных
 */
public class AssemblingPLoadXlsForm extends com.hps.july.web.util.EditForm{
	private org.apache.struts.upload.FormFile xslFile;	
public AssemblingPLoadXlsForm(){
	setLastVisited(true);
}
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception{
	return null;
}
public int getApplication(){
	return com.hps.july.constants.Applications.INVENTORY;
}
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request){
	return null;
}
public int getState(){
	return com.hps.july.inventory.APPStates.ASPLOADXLS;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2005 15:59:21)
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getXslFile() {
	return xslFile;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2005 17:48:34)
 * @return boolean
 */
public boolean isValidDec(String value) {
	try{
		Double.parseDouble(value);
	}catch(NumberFormatException nfe){
		return false;
	}
	return true;
}
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{	
	
	Connection conn = null;
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;	
		
	Workbook workbook = null;

	try{
	
		FormFile formFile = getXslFile();
		String str = formFile.getFileName();

		byte[] data = formFile.getFileData();
		java.io.ByteArrayInputStream file = new ByteArrayInputStream(data);
        
    	workbook = Workbook.getWorkbook(file);
    	Sheet sheet = workbook.getSheet(0);

		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();

		conn = new JdbcConnection().getConnection();
		
		ps = conn.prepareStatement("select resource from resources where manucode=? or model=?");
		ps2 = conn.prepareStatement("select resource from storagecards where serialnumber =?");
		

		
		
		AssemblingPForm aform = (AssemblingPForm)request.getSession().getAttribute( "AssemblingPForm" );
		Integer doc = new Integer(aform.getDoc());
		String owncode = aform.getOwnercode();
			
		for(int i = 1;i<rows;i++){
			boolean present = false;
			String model = sheet.getCell(0,i).getContents().trim();
			String manucode = sheet.getCell(1,i).getContents().trim();
			String price = sheet.getCell(2,i).getContents().trim();
			String manuserial = sheet.getCell(3,i).getContents().trim();
			String molkom = sheet.getCell(4,i).getContents().trim();
			String serial = sheet.getCell(5,i).getContents().trim();
			String stplace = sheet.getCell(6,i).getContents().trim();
			
			int res = -1;
			ps.setString(1,model);
			ps.setString(2,model);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				res = rs.getInt("resource");
				if(rs.next()){
					res=-1;
				}
			}
			if(res==-1){
				ps.setString(1,manucode);
				ps.setString(2,manucode);

				
				rs2 = ps.executeQuery();
				if(rs2.next()){
					res = rs2.getInt("resource");
					if(rs2.next()){
						res=-1;
					}
				}
			}
			if(res==-1){
				ps2.setString(1,serial);
				
				rs2 = ps2.executeQuery();
				if(rs2.next()){
					res = rs2.getInt("resource");
					if(rs2.next()){
						res=-2;
					}
				}
			}


			if(res!=-1 && res !=-2){
				Integer docpos = new Integer(keyGen.getNextKey("tables.docpositions"));

				int order = 0;
				try {
					InternalWayBillPositionAccessBean ibean = new InternalWayBillPositionAccessBean();
					InternalWayBillPositionAccessBean ibean2 = ibean.findMaxOrderPosition(doc);
					order = ibean2.getOrder() + 1;
				} catch(Exception e) {
					order = 1;
				}

				
				InternalWayBillPositionAccessBean bean = new InternalWayBillPositionAccessBean(
					docpos.intValue(),
					new Integer(res),
					new Integer(owncode),
					doc,
					order,
					new java.math.BigDecimal("1"),
					isValidDec(price)?new java.math.BigDecimal(price):new java.math.BigDecimal("0.0"),
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE,
					Boolean.FALSE
				);
				bean.setSerialnumber(serial);
				bean.setManufserial(manuserial);
				bean.setNewplace(stplace);
				bean.commitCopyHelper();
			}else{
				if(res==-1){
					aform.getXlserrors().add("Ќе найдено соответствующее оборудование в системе дл€ значени€ "+model+
						", "+manucode+", "+serial);
				}else if(res==-2){
					aform.getXlserrors().add("Ќе найдено соответствующее оборудование в системе дл€ значени€ "+model+
						", "+manucode+".ƒл€ значени€  "+serial+" найдено более одного типа оборудовани€.");
				}
			}
			
		}
		
		
	}catch(jxl.read.biff.PasswordException ex){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.load.password", xslFile.getFileName()));
	}catch(ValidationException vex){
	}catch(Exception e){
		e.printStackTrace(System.out);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.load", xslFile.getFileName()));
	}finally{
	    try{
		    if(workbook!=null) workbook.close();
		    if(rs!=null) rs.close();
		    if(rs2!=null) rs2.close();
		    if(ps!=null) ps.close();
		    if(ps2!=null) ps2.close(); 
		    if(conn!=null) conn.close();
	    }catch(Exception exc){
		    exc.printStackTrace(System.out);
	    }
    }
	if (!errors.empty())
		throw new ValidationException();
	
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (18.05.2005 15:59:21)
 * @param newXslFile org.apache.struts.upload.FormFile
 */
public void setXslFile(org.apache.struts.upload.FormFile newXslFile) {
	xslFile = newXslFile;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	
	if(xslFile != null && xslFile.getFileName().length() > 0 && xslFile.getFileSize() > 0){
		if(!(xslFile.getFileName().endsWith(".xls"))){
		    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.extension", xslFile.getFileName()));		
		}
	}else
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file"));		

	
	if (!errors.empty())
		throw new ValidationException();	
}
}
