package com.hps.july.basestation.actionbean;

import java.text.*;
import com.hps.july.commonbean.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.hps.july.basestation.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.constants.Applications;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.*;
import com.hps.july.basestation.formbean.*;
import org.apache.struts.upload.FormFile;
//import com.hps.july.dataimport.beans.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Data import handler 
 */
public class LoadXlsStep2 extends FormProcessAction {
private boolean checkFile(HttpServletRequest request) throws Exception {

    //read

    if (request.getParameter("file") == null) {
        return false;
    }

    String fileName = request.getParameter("file");
    File uploadDir = new File(AppConstants.uploadDir);
    File xlsFile = new File(uploadDir, fileName);

    if (xlsFile != null
        && xlsFile.getName().length() > 0
        && xlsFile.length() > 0) {
        if (xlsFile.getName().endsWith(".xls"))
            return true;
        else {
            ActionErrors errors = new ActionErrors();
            errors.add(
                ActionErrors.GLOBAL_ERROR,
                new ActionError("error.file.extension", ""));
            saveErrors(request, errors);
            throw new Exception();
        }
    }

    return false;
}
private boolean checkFile(HttpServletRequest request, FormFile file) throws Exception{

	if(file != null && file.getFileName().length() > 0 && file.getFileSize() > 0){
		if(file.getFileName().endsWith(".xls"))
			return true;
		else {
			ActionErrors errors = new ActionErrors();
		    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.extension", file.getFileName()));		
			saveErrors(request, errors);
			throw new Exception();
		}
	}
	
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:55:49)
 * @return java.lang.String
 * @param s java.lang.String
 */
public String getCellXY(String s) {
	StringBuffer sb = new StringBuffer();
	char[] ch = s.toCharArray();
	int i;
	for(i=0;i<ch.length;i++){
		boolean is = Character.isLetter(ch[i]);
		if(is){
			sb.append(ch[i]);
		}else{
			sb.append(',');
			break;
		}
	}
	
	for(int j=i;j<ch.length;j++){
		boolean is = Character.isLetter(ch[j]);		
			sb.append(ch[j]);
		
	}	
	return sb.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2005 11:30:09)
 * @return int
 * @param alias java.lang.String
 */
public int getNextKey(String alias,PreparedStatement getSeq) {
	ResultSet rs = null;
	try{
		getSeq.clearParameters();
		getSeq.setString(1, alias);
		rs = getSeq.executeQuery();
		rs.next();
		return rs.getInt( 1 );
	}catch(Exception e){
		return 0;
	} finally {
		try { if(rs != null) rs.close(); } catch(Exception e) {}
	}
		
}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.08.2005 11:07:41)
	 * @return java.lang.String
	 * @param startTime java.util.Date
	 * @param endTime java.util.Date
	 */
	protected String getTime(Date startTime, Date endTime) {
        DecimalFormat df = new DecimalFormat("00");
        df.setDecimalSeparatorAlwaysShown(false);

        long decelTime = endTime.getTime() - startTime.getTime();
        double hours = Math.floor(decelTime / 3600000);
        double min = Math.floor((decelTime % 3600000) / 60000);
        double sec = Math.floor((decelTime % 3600000 % 60000) / 1000);
        double mSec = Math.floor((decelTime % 3600000 % 60000 % 1000));
        StringBuffer sb = new StringBuffer();
        df.format(hours, sb, new FieldPosition(0));
        sb.append(":");
        df.format(min, sb, new FieldPosition(0));
        sb.append(":");
        df.format(sec, sb, new FieldPosition(0));
        df = new DecimalFormat("000");
        df.setDecimalSeparatorAlwaysShown(false);
        sb.append(":");
        df.format(mSec, sb, new FieldPosition(0));

        return sb.toString();

	}
private int importXls(ActionForm form, HttpServletRequest request, int taskId, FormFile formFile)
    throws Exception {
	System.out.println("Import started !--------->");
	Date sD = new Date();
    int impsesid = 0;
    int imprecid = 0;
    LoadXlsForm f = (LoadXlsForm) form;
    //File fileXls = null;
    String fileXls = "";
    int fileSize = 0;
	String task = "";
	java.sql.Date startDate = null;
	java.sql.Date endDate = null;
	java.sql.Date loadRecDate = null;
	    
	Connection conn = null;
	//PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	//PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	PreparedStatement ps7 = null;
	PreparedStatement ps8 = null;
	PreparedStatement ps9 = null;
	PreparedStatement ps10 = null;
	PreparedStatement getSeq = null;
	Workbook workbook = null;

	ResultSet rs = null;
	
	ArrayList list = null;
	if(f.getDiapazon().equals("900")) {
		list = f.getRangeAll();
	} else {
		list = f.getRange1800All();
	}
	
    boolean cross = f.isCross();
    boolean vertic = f.isVertic();
    request.getSession().setAttribute("task", taskId==0?new Integer(taskId+1):new Integer(taskId));
    
    try {
		conn = new JdbcConnection().getConnection();
	    
	    int reccount = 0;
	    int errcount = 0;
        int operator = 1; 
        try {
            operator =
                new OperatorAccessBean()
                    .findByLogin(request.getUserPrincipal().getName())
                    .getOperator();
        } catch (Exception ex) {
            System.out.println("Can't get Operator from request\n");
        }

		
		startDate = new java.sql.Date(System.currentTimeMillis());
		
        fileXls = formFile.getFileName();
        fileSize = formFile.getFileSize();
        byte[] data = formFile.getFileData();

		java.io.ByteArrayInputStream file = new ByteArrayInputStream(data);
        
        workbook = Workbook.getWorkbook(file);
        
		Sheet sheet = null;

/*
		ps = conn.prepareStatement("update chanalpowers set power= ? " + 
			"where equipment = (select equipment from basestations where number = ?)" + 
			" and chanal = ? and polarization = ?");
*/		
	    ps2 = conn.prepareStatement("select equipment from basestations where number = ?");

	    ps3 = conn.prepareStatement("insert into importsessions values(?,?,?,?,?,?,?,?,?,?)");

		ps4 = conn.prepareStatement("insert into importrecords values(?,?,?,?,?,?,?,?,?,?)");

		/*ps5 = conn.prepareStatement("select equipment from chanalpowers where equipment = " + 
			"(select equipment from basestations where number = ?) and chanal = ? and polarization = ?");*/

		ps7 = conn.prepareStatement("insert into chanalpowers values("+
			" ?,?,?,?,?)");

		ps8 = conn.prepareStatement("insert into chanalpowerpermit values(?,"+
			" ?,?,?,?,?)");
		
		ps9 = conn.prepareStatement("DELETE FROM chanalpowerpermit WHERE equipment = ? "+
			" AND band = ? ");
		
		ps10 = conn.prepareStatement("DELETE FROM chanalpowers WHERE equipment = ? "+
			" AND band = ? AND polarization = ?");

		ps6 = conn.prepareStatement("update importsessions set importend= ? ," +
			"filetime = ? , reccount = ? , errcount = ?" +
			"where impsesid = ?");

		getSeq = conn.prepareStatement( "EXECUTE PROCEDURE getSequence(?)" );		

		//-------------------------
		
		impsesid = getNextKey(TablesRef.IMPORTSESSIONS ,getSeq);
		
		//-------------------------

		
		//account about session		
		ps3.setInt(1,impsesid);
		ps3.setInt(2,taskId==0?taskId+1:taskId);
		ps3.setDate(3,startDate);
		ps3.setDate(4,startDate);
		ps3.setInt(5,operator);
		ps3.setString(6,fileXls);
		ps3.setInt(7,fileSize);
		ps3.setDate(8,startDate);
		ps3.setInt(9,0);
		ps3.setInt(10,0);

		ps3.executeUpdate();

		for(int k = 0; k < 2; k++) {
			
			if(k == 0 && vertic){
				task = "V";
				sheet = workbook.getSheet(0);
			} else if(k == 0) continue;
			
			if(k == 1 && cross){
				task = "C";
				sheet = workbook.getSheet(1);
			} else if(k == 1) continue;
		
			int rows = sheet.getRows();
			int columns = sheet.getColumns();
			//System.out.println("TASK ["+task+"] ["+f.getDiapazon()+"]");
		for(int i = 0;i<rows;i++){	
			
			String npp = sheet.getCell(0,i).getContents();
			String bs = sheet.getCell(1,i).getContents();
			//System.out.println("*******bs-" + i + ":" +bs);
			int bsNumber = 0;

			if(!isValid(npp,bs)) continue;
						
			bsNumber = new Integer(bs).intValue();
			
			
			ps2.setInt(1,bsNumber);	
			rs = ps2.executeQuery();

			int bsId = -1;
			if(rs.next()) {
				bsId = rs.getInt(1);
				
				if(bsId != -1) {
					//ps.setInt(2,bsNumber);
					//ps.setString(4,task);

					//delete all previous chanalpowerpermit for current BS number 
					//System.out.println("*******bs-:" +bs + "-" + f.getDiapazon());
					ps9.clearParameters();
					ps9.setInt(1, bsId);
					ps9.setInt(2, (new Integer(f.getDiapazon())).intValue());
					ps9.executeUpdate();
					ps10.clearParameters();
					ps10.setInt(1, bsId);
					ps10.setInt(2, (new Integer(f.getDiapazon())).intValue());
					ps10.setString(3, task);
					ps10.executeUpdate();
					
					for(int j = 0;j<list.size();j++){
						RangeAllow ra = (RangeAllow)list.get(j);
						Integer startnumber = ra.getStartnumber();
						Integer endnumber = ra.getEndnumber();
						String polar = ra.getPolar();
						Integer band = ra.getBand();
						//System.out.println("S:["+startnumber+"] E["+endnumber+"] B["+band+"] P["+polar+"]");
						if(polar != null && band != null) {
							int next = getNextKey("tables.chanalpowerpermit",getSeq);
							ps8.clearParameters();
							ps8.setInt(1,next);
							ps8.setInt(2,bsId);
							ps8.setString(3,polar);					
							ps8.setInt(4,band.intValue());
							ps8.setInt(5,startnumber!=null?startnumber.intValue():0);
							ps8.setInt(6,endnumber!=null?endnumber.intValue():0);

							ps8.executeUpdate();
						}
					}
					
					//-------------------------------------------------
					for(int j = 2;j<columns;j++){
						Cell c = sheet.getCell(j,i);

						
						if(c!=null && c.getContents()!=null){

							try{
								
								//Integer.parseInt(c.getContents());
								//ps.setInt(3,j-1);
								//ps.setInt(1,Integer.parseInt(c.getContents()));
								
								//int result = ps.executeUpdate();
									
								//ps4.setString(4,"U");
									
								//if(result==0){
									//System.out.println("C["+(j-1)+"] Con["+c.getContents()+"] D["+(f.getDiapazon())+"] ");	
									ps7.clearParameters();
									ps7.setInt(1,bsId);
									ps7.setString(3,task);
									ps7.setInt(2,j-1);
									ps7.setInt(4,Integer.parseInt(c.getContents()));
									ps7.setInt(5,Integer.parseInt(f.getDiapazon()));
								
									ps7.executeUpdate();
									
								//}
															
							}catch(NumberFormatException nfe){
								
								imprecid = getNextKey(TablesRef.IMPORTRECORDS,getSeq);
								loadRecDate = new java.sql.Date(System.currentTimeMillis());
								ps4.clearParameters();
								ps4.setInt(1,imprecid);
								ps4.setInt(2,impsesid);
								ps4.setDate(3,loadRecDate);
								ps4.setString(4,"I");
								ps4.setString(5,"E");
								ps4.setString(6,"error.record");
								ps4.setString(7,getCellXY(jxl.CellReferenceHelper.getCellReference(j,i)));
								ps4.setString(8,null);
								ps4.setString(9,null);
								ps4.setString(10,bsNumber+":"+(j-1)+":"+task);
								ps4.executeUpdate();
								errcount++;
							}

						}else{					
							
							imprecid = getNextKey(TablesRef.IMPORTRECORDS,getSeq);
							loadRecDate = new java.sql.Date(System.currentTimeMillis());
							ps4.clearParameters();
							ps4.setInt(1,imprecid);
							ps4.setInt(2,impsesid);
							ps4.setDate(3,loadRecDate);
							ps4.setString(4,"I");
							ps4.setString(5,"E");
							ps4.setString(6,"error.record");
							ps4.setString(7,getCellXY(jxl.CellReferenceHelper.getCellReference(j,i)));
							ps4.setString(8,null);
							ps4.setString(9,null);
							ps4.setString(10,bsNumber+":"+(j-1)+":"+task);
							ps4.executeUpdate();
							errcount++;
						}
						reccount++;	
					}
					//-------------------------------------------------
				}
			} else {
				imprecid = getNextKey(TablesRef.IMPORTRECORDS,getSeq);
				ps4.clearParameters();
				ps4.setInt(1,imprecid);
				ps4.setInt(2,impsesid);
				ps4.setDate(3,new java.sql.Date(System.currentTimeMillis()));
				ps4.setString(4,"I");
				ps4.setString(5,"E");
				ps4.setString(6,"error.bs.absent");
				ps4.setString(7,String.valueOf(bsNumber));
				ps4.setString(8,null);
				ps4.setString(9,null);
				ps4.setString(10,String.valueOf(bsNumber));
				ps4.executeUpdate();
				errcount++;
		  }			
			
		  }
	      //if(taskId!=0) break;
    	}
		
		endDate = new java.sql.Date(System.currentTimeMillis());

		ps6.setDate(1,endDate);
		ps6.setDate(2,endDate);
		ps6.setInt(3,reccount);
		ps6.setInt(4,errcount);
		ps6.setInt(5,impsesid);
		ps6.executeUpdate();

		list.clear();
        /*DataImportAccessBean diab = new DataImportAccessBean();
        impsesid = diab.process(fileXls, data, taskId, operator);*/

    } catch (Exception e) {
        System.out.println("Error in LoadXls.importXls");
        e.printStackTrace(System.out);
        return 0;
    }finally{
	    try{
		    if(workbook!=null) workbook.close(); 
		    //if(ps!=null) ps.close();
		    if(rs !=null) rs.close();
		    
		    if(ps2!=null) ps2.close();
		    if(ps3!=null) ps3.close();
		    if(ps4!=null) ps4.close();
		    //if(ps5!=null) ps5.close();
		    if(ps6!=null) ps6.close();
		    if(ps7!=null) ps7.close();
		    if(ps8!=null) ps8.close();
		    if(ps9!=null) ps9.close();
		    if(getSeq!=null) getSeq.close();
		    if(conn!=null) conn.close();
	    }catch(Exception exc){
		    exc.printStackTrace();
	    }
    }

    
    if (impsesid == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.file.load", fileXls));
        saveErrors(request, errors);
        throw new Exception();

    }
    request.getSession().setAttribute("impsesid", new Integer(impsesid));
	System.out.println("Import ended !---------> ["+getTime(sD, new Date())+"]");
    return impsesid;

}
/**
 * ѕризнак добавлени€ текущего URL в историю (навигации).
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isAddtoHistory() {
	return false;
}
/**
 * ѕризнак возврата на текущий режим.
 * Creation date: (08.10.2003 17:21:05)
 * @return boolean
 */
public boolean isReturnable() {
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2005 14:26:51)
 * @return boolean
 */
private boolean isValid(String npp,String bs) {
	try{
		Integer.parseInt(bs);
		Integer.parseInt(npp);
	}catch(NumberFormatException nfe){
		//System.out.println("*******exception");
		return false;
	}
	return true;
}
public ActionForward perform( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	navigate(mapping,form,request,response);
	try {
		request.getSession().setAttribute("task", new Integer(1));
	    LoadXlsForm aform = (LoadXlsForm) form;

		System.out.println("-------------------->STEP2");
		String step1 = aform.getStep1();
		System.out.println("-------------------->STEP2 ["+step1+"] ");
		if(step1 != null && step1.length() > 0) {
			aform.setStep1(null);
			ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLSSTEP2);
			//super.perform(mapping, aform, request, response);
			return mapping.findForward("main");
		}
		FormFile formFile = aform.getXslFile();
		String str = formFile.getFileName();

	    boolean checkFile = checkFile(request,formFile);//alexshr
	    boolean cross = aform.isCross();
	    boolean vertic = aform.isVertic();

	    if (request.getParameter("maxReport") == null) {
            aform.setMaxReport(false);
        }
	    boolean maxReport = aform.isMaxReport();

	    if (!checkFile) { 
			if(request.getParameter("submit.x") != null){
				ActionErrors errors = new ActionErrors();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file"));
				saveErrors(request, errors);
		    }
			ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
			//super.perform(mapping, aform, request, response);
			return mapping.findForward("main");
		} else if (checkFile && cross && !vertic && maxReport) {
	        importXls(form, request, 2,formFile);
			//super.perform(mapping, aform, request, response);
	        return mapping.findForward("xlsMaxReport");
	    } else if (checkFile && cross && !vertic && !maxReport) {
	        importXls(form, request, 2,formFile);
			//super.perform(mapping, aform, request, response);
	        return mapping.findForward("xlsMinReport");
	    } else if (checkFile && !cross && vertic && maxReport) {
	        importXls(form, request, 1,formFile);
			//super.perform(mapping, aform, request, response);
	        return mapping.findForward("xlsMaxReport");
	    } else if (checkFile && !cross && vertic && !maxReport) {
	        importXls(form, request, 1,formFile);
			//super.perform(mapping, aform, request, response);
	        return mapping.findForward("xlsMinReport");
	    } else if (checkFile && cross && vertic && maxReport) {
	        importXls(form, request, 0,formFile);
			//super.perform(mapping, aform, request, response);
	        return mapping.findForward("xlsMaxReport");
	    } else if (checkFile && cross && vertic && !maxReport) {
	        importXls(form, request, 0,formFile);
			//super.perform(mapping, aform, request, response);
	        return mapping.findForward("xlsMinReport");
	    } else if (checkFile && !cross && !vertic) {
	        ActionErrors errors = new ActionErrors();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.polar"));
			saveErrors(request, errors);
			ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
			//super.perform(mapping, aform, request, response);
			return mapping.findForward("main");
	    } else {
			ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
			//super.perform(mapping, aform, request, response);
	        return mapping.findForward("main");
	    }
	} catch(Exception e) {
		ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
		//super.perform(mapping, form, request, response);
		return mapping.findForward("main");
	}
}
private File readFile(HttpServletRequest request) throws Exception {

    //read
    try {

        String fileName = request.getParameter("file");
        File uploadDir = new File(AppConstants.uploadDir);
        File xlsFile = new File(uploadDir, fileName);

        return xlsFile;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
private byte[] receiveFileData(File file) throws Exception {
    //read
	java.io.FileInputStream fInpstream = null;
    try {
        byte[] bt = new byte[new Long(file.length()).intValue()];
		fInpstream = new java.io.FileInputStream(file);
        int res = fInpstream.read(bt);
        return bt;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    } finally {
	    if(fInpstream != null) fInpstream.close();
    }
}
}
