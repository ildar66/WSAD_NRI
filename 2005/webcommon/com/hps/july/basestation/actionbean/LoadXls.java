package com.hps.july.basestation.actionbean;

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
 * ќбработчик импорта данных
 */
public class LoadXls extends FormProcessAction {
	/**
	 * Insert the method's description here.
	 * Creation date: (24.08.2005 18:50:02)
	 * @return java.util.Collection
	 * @param groups java.util.HashMap
	 */
    private Collection analysis(HashMap groups) {
        ArrayList result = new ArrayList();
        ArrayList result1 = new ArrayList();

        Set s = groups.keySet();
        for(Iterator iterator = s.iterator(); iterator.hasNext();) {
            Integer key = (Integer)iterator.next();
            ArrayList temp = (ArrayList)groups.get(key);
            if(temp.size() == 1) result.add((RangeAllow)temp.get(0));
            else {
                Object [] aTemp = temp.toArray();
                Arrays.sort(aTemp, new Comparator() {
                    public int compare(Object o, Object o1) {
                        RangeAllow a = (RangeAllow)o;
                        RangeAllow b = (RangeAllow)o1;
                        if(a.getCount().intValue() < b.getCount().intValue())
                            return 1;
                        else if(a.getCount().intValue() == b.getCount().intValue())
                            return 0;
                        else
                            return -1;
                    }
                });
                if(aTemp.length > 0) result.add((RangeAllow)aTemp[0]); 
                    
            }
        }
        Object [] resultAr = result.toArray();
		Arrays.sort(resultAr, new Comparator() { 
					public int compare(Object o, Object o1) {
						RangeAllow a = (RangeAllow)o;
			   			RangeAllow b = (RangeAllow)o1;
			      		if(a.getStartnumber().intValue() > b.getStartnumber().intValue())
			        		return 1;
			          	else if(a.getStartnumber().intValue() == b.getStartnumber().intValue())
			           		return 0;
			            else
			            	return -1;
			  		}
	    		});
		System.out.println("----->START");
        for(Iterator iterator = result.iterator(); iterator.hasNext();) {
            RangeAllow ra = (RangeAllow) iterator.next();
            System.out.println("S ["+ra.getStartnumber()+"] E ["+ra.getEndnumber()+"] C ["+ra.getCount()+"]");
        }
        for(int i = 0; i < resultAr.length; i++) {
            RangeAllow ra = (RangeAllow)resultAr[i];

            int k = -1;
            RangeAllow ra3 = null;
            for(int j = i + 1; j < resultAr.length; j++) {
                RangeAllow ra2 = (RangeAllow)resultAr[j];

                if(ra.getStartnumber().intValue() <= ra2.getStartnumber().intValue() &&
                        ra.getEndnumber().intValue() > ra2.getStartnumber().intValue()) {
                    k = j;
                    if(ra3 == null) {
                        if(ra.getCount().intValue() < ra2.getCount().intValue()) ra3 = ra2;
                        else ra3 = ra;
                    } else {
                        if(ra3.getCount().intValue() < ra2.getCount().intValue()) ra3 = ra2;
                    }
                }
            }
            if(k != -1 && ra3 != null) {
                result1.add(ra3);
                i = k++;
            } else {
                result1.add(ra);
            }
        }
        System.out.println("----------------------------");
        for(Iterator iterator = result1.iterator(); iterator.hasNext();) {
            RangeAllow ra = (RangeAllow) iterator.next();
            System.out.println("S ["+ra.getStartnumber()+"] E ["+ra.getEndnumber()+"] C ["+ra.getCount()+"]");
        }
		System.out.println("----->END");
        return result1;
	}
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
	try{		
		getSeq.setString( 1, alias );
		ResultSet rs = getSeq.executeQuery();
		rs.next();
		return rs.getInt( 1 );
	}catch(Exception e){
		return 0;
	}
		
}
private Collection getPermittedDiapasons(ActionForm form, HttpServletRequest request, FormFile formFile)
	throws Exception {

	ArrayList result = new ArrayList();	
	ArrayList result1800 = new ArrayList();	
    LoadXlsForm f = (LoadXlsForm) form;
    String fileXls = "";
    int fileSize = 0;
	String task = "";
	    
	Connection conn = null;
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	ResultSet rs = null;
	Workbook workbook = null;

	LoadXlsForm aform = (LoadXlsForm) form;
    try {
		conn = new JdbcConnection().getConnection();
		ps2 = conn.prepareStatement("select equipment from basestations where number = ?");

		
        fileXls = formFile.getFileName();
        fileSize = formFile.getFileSize();
        byte[] data = formFile.getFileData();

		java.io.ByteArrayInputStream file = new ByteArrayInputStream(data);
        
        workbook = Workbook.getWorkbook(file);
        
		Sheet sheet = null;


	    boolean cross = f.isCross();
	    boolean vertic = f.isVertic();
	    StringBuffer bs4Vert = null;
	    StringBuffer bs4Cross = null;
	    
		if(vertic) {
			sheet = workbook.getSheet(0);
			int rows = sheet.getRows();
			int columns = sheet.getColumns();
			
			for(int i = 3;i<rows;i++) {	
				try {
					String bs = sheet.getCell(1,i).getContents();
					//System.out.println("*******bs-" + i + ":" +bs);
					int bsNumber = 0;
					bsNumber = new Integer(bs).intValue();
					ps2.clearParameters();
					ps2.setInt(1, bsNumber);
					rs = ps2.executeQuery();
					if(rs.next()) bsNumber = rs.getInt("equipment");
					else bsNumber = 0;
					if(i == 3) {
						bs4Vert = new StringBuffer();
					}
					if(bsNumber != 0) {
						if(bs4Vert != null) {
							if(i != 3 && i < rows - 1) bs4Vert.append(",");
							bs4Vert.append(bsNumber);
						}
					}
				} catch(Exception e) {
				} finally {
					try { if(rs != null) rs.close(); } catch(Exception e) {}
				}
			}
			if(bs4Vert != null && bs4Vert.length() > 0) {
				System.out.println("SELECT band, startnumber, endnumber, polarization, count(idpermit) as c " +
						" FROM chanalpowerpermit " + 
						" WHERE polarization = 'V' AND band = ? " +
						" AND equipment IN (" + bs4Vert.toString() + ")  " +
						" group by startnumber, endnumber, polarization, band " +
						" order by startnumber ");
				ps = conn.prepareStatement("SELECT band, startnumber, endnumber, polarization, count(idpermit) as c " +
						" FROM chanalpowerpermit " + 
						" WHERE polarization = 'V' AND band = ? " +
						" AND equipment IN (" + bs4Vert.toString() + ")  " +
						" group by startnumber, endnumber, polarization, band " +
						" order by startnumber ");
				ps.setInt(1, Integer.parseInt(f.getDiapazon()));
				rs = ps.executeQuery();
				HashMap startNumbers = new HashMap();
				HashMap startNumbers1800 = new HashMap();
				int i = 0;
				while(rs.next()) {
					Integer startNumber = new Integer(rs.getInt("startnumber"));
					Integer endNumber = new Integer(rs.getInt("endnumber"));
					Integer c = new Integer(rs.getInt("c"));
					Integer band = new Integer(rs.getInt("band"));
					RangeAllow ra = new RangeAllow();
					ra.setCount(c);
					ra.setStartnumber(startNumber);
					ra.setEndnumber(endNumber);
					ra.setPolar("V");
					ra.setBand(band);
					if(band.intValue() == 900) {
						ArrayList temp = (ArrayList)startNumbers.get(startNumber);
						if(temp == null) temp = new ArrayList();
						temp.add(ra);
						startNumbers.put(startNumber, temp);
					} else {
						ArrayList temp = (ArrayList)startNumbers1800.get(startNumber);
						if(temp == null) temp = new ArrayList();
						temp.add(ra);
						startNumbers1800.put(startNumber, temp);
					}
				}
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(f.getDiapazon().equals("1800")) {
					System.out.println("----->1800");
					Collection c1800 = analysis(startNumbers1800);				
					result1800.addAll(c1800);
				} else {
					System.out.println("----->900");
					Collection c = analysis(startNumbers);
					result.addAll(c);
				}
			}
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if(cross) {
			sheet = workbook.getSheet(1);
			int rows = sheet.getRows();
			int columns = sheet.getColumns();
			
			for(int i = 3;i<rows;i++) {	
				try {
					String bs = sheet.getCell(1,i).getContents();
					//System.out.println("*******bs-" + i + ":" +bs);
					int bsNumber = 0;
					bsNumber = new Integer(bs).intValue();
					ps2.clearParameters();
					ps2.setInt(1, bsNumber);
					rs = ps2.executeQuery();
					if(rs.next()) bsNumber = rs.getInt("equipment");
					else bsNumber = 0;
					if(i == 3) {
						bs4Cross = new StringBuffer();
					}
					if(bsNumber != 0) {
						if(bs4Cross != null) {
							if(i != 3 && i < rows - 1) bs4Cross.append(",");
							bs4Cross.append(bsNumber);
						}
					}
				} catch(Exception e) {
				} finally {
					try { if(rs != null) rs.close(); } catch(Exception e) {}
				}
			}
			if(bs4Cross != null && bs4Cross.length() > 0) {
				System.out.println("SELECT band, startnumber, endnumber, polarization, count(idpermit) as c " +
						" FROM chanalpowerpermit " + 
						" WHERE polarization = 'C' AND band = ? " +
						" AND equipment IN (" + bs4Cross.toString() + ")  " +
						" group by startnumber, endnumber, polarization, band " +
						" order by startnumber ");
				ps = conn.prepareStatement("SELECT band, startnumber, endnumber, polarization, count(idpermit) as c " +
						" FROM chanalpowerpermit " + 
						" WHERE polarization = 'C' AND band = ? " +
						" AND equipment IN (" + bs4Cross.toString() + ")  " +
						" group by startnumber, endnumber, polarization, band " +
						" order by startnumber ");
				ps.setInt(1, Integer.parseInt(f.getDiapazon()));
				rs = ps.executeQuery();
				HashMap startNumbers = new HashMap();
				HashMap startNumbers1800 = new HashMap();
				int i = 0;
				while(rs.next()) {
					Integer startNumber = new Integer(rs.getInt("startnumber"));
					Integer endNumber = new Integer(rs.getInt("endnumber"));
					Integer c = new Integer(rs.getInt("c"));
					Integer band = new Integer(rs.getInt("band"));
					RangeAllow ra = new RangeAllow();
					ra.setCount(c);
					ra.setStartnumber(startNumber);
					ra.setEndnumber(endNumber);
					ra.setPolar("C");
					ra.setBand(band);
					if(band.intValue() == 900) {
						ArrayList temp = (ArrayList)startNumbers.get(startNumber);
						if(temp == null) temp = new ArrayList();
						temp.add(ra);
						startNumbers.put(startNumber, temp);
					} else {
						ArrayList temp = (ArrayList)startNumbers1800.get(startNumber);
						if(temp == null) temp = new ArrayList();
						temp.add(ra);
						startNumbers1800.put(startNumber, temp);
					}
				}
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(f.getDiapazon().equals("1800")) {
					Collection c1800 = analysis(startNumbers1800);				
					result1800.addAll(c1800);
				} else {
					Collection c = analysis(startNumbers);
					result.addAll(c);
				}
			}
		}
		f.setR900(result);
		f.setR1800(result1800);

    } catch (Exception e) {
        System.out.println("Error in LoadXls.importXls");
        e.printStackTrace(System.out);
    } finally {
	    try {
		    if(workbook != null) workbook.close(); 
		    if(rs != null) rs.close();
		    if(ps2 != null) ps2.close();
		    if(ps != null) ps.close();
		    if(conn != null) conn.close();
	    }catch(Exception exc){
		    exc.printStackTrace();
	    }
    }
    
    return result;

}
private int importXls(ActionForm form, HttpServletRequest request, int taskId, FormFile formFile)
    throws Exception {
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
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	//PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	PreparedStatement ps7 = null;
	PreparedStatement ps8 = null;
	PreparedStatement getSeq = null;
	Workbook workbook = null;

	LoadXlsForm aform = (LoadXlsForm) form;
	ArrayList list = aform.getRangeAll();
	
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

		/*if(taskId==1){
			task = "V";
		}else{
			task = "C";
		}*/
		
		startDate = new java.sql.Date(System.currentTimeMillis());
		
        fileXls = formFile.getFileName();
        fileSize = formFile.getFileSize();
        byte[] data = formFile.getFileData();

		java.io.ByteArrayInputStream file = new ByteArrayInputStream(data);
        
        workbook = Workbook.getWorkbook(file);
        
		Sheet sheet = null;

		ps = conn.prepareStatement("update chanalpowers set power= ? " + 
			"where equipment = (select equipment from basestations where number = ?)" + 
			" and chanal = ? and polarization = ?");

	    ps2 = conn.prepareStatement("select count(*) from basestations where number = ?");

	    ps3 = conn.prepareStatement("insert into importsessions values(?,?,?,?,?,?,?,?,?,?)");

		ps4 = conn.prepareStatement("insert into importrecords values(?,?,?,?,?,?,?,?,?,?)");

		/*ps5 = conn.prepareStatement("select equipment from chanalpowers where equipment = " + 
			"(select equipment from basestations where number = ?) and chanal = ? and polarization = ?");*/

		ps7 = conn.prepareStatement("insert into chanalpowers values((select equipment "+
			"from basestations where number = ?),?,?,?,?)");

		ps8 = conn.prepareStatement("insert into chanalpowerpermit values(?,(select equipment "+
			"from basestations where number = ?),?,?,?,?)");
		
		ps6 = conn.prepareStatement("update importsessions set importend= ? ," +
			"filetime = ? , reccount = ? , errcount = ?" +
			"where impsesid = ?");

		getSeq = conn.prepareStatement( "EXECUTE PROCEDURE getSequence(?)" );		

		//-------------------------
		
		impsesid = getNextKey(TablesRef.IMPORTSESSIONS ,getSeq);
		
		//-------------------------

		
		//ќтчет о сессии		
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

		ps3.execute();	

		for(int k=0;k<2;k++){

		if(taskId==1){
			task = "V";
			sheet = workbook.getSheet(0);
		}else if(taskId==2){
			task = "C";
			sheet = workbook.getSheet(1);
		}else if(taskId==0){
			if(k==0) task = "V";
			else if(k==1) task = "C";
			sheet = workbook.getSheet(k);
		}
		
		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		
		for(int i = 0;i<rows;i++){	
			
			String npp = sheet.getCell(0,i).getContents();
			String bs = sheet.getCell(1,i).getContents();
			System.out.println("*******bs-" + i + ":" +bs);
			int bsNumber = 0;

			if(!isValid(npp,bs)) continue;
						
			bsNumber = new Integer(bs).intValue();
			
			
			ps2.setInt(1,bsNumber);	
			ResultSet rs = ps2.executeQuery();

			int bscount = -1;
			rs.next();
			bscount = rs.getInt(1);
			
			ResultSet rs5 = null;
			
			if(bscount==1){	
				ps.setInt(2,bsNumber);
				ps.setString(4,task);
				ps7.setInt(1,bsNumber);
				ps7.setString(3,task);
				
				for(int j = 0;j<list.size();j++){
					RangeAllow ra = (RangeAllow)list.get(j);
					Integer startnumber = ra.getStartnumber();
					Integer endnumber = ra.getEndnumber();
					String polar = ra.getPolar();
					Integer band = ra.getBand();					

					int next = getNextKey("tables.chanalpowerpermit",getSeq);
					ps8.setInt(1,next);
					ps8.setInt(2,bsNumber);
					ps8.setString(3,polar);					
					ps8.setInt(4,band.intValue());
					ps8.setInt(5,startnumber!=null?startnumber.intValue():0);
					ps8.setInt(6,endnumber!=null?endnumber.intValue():0);

					ps8.execute();
				}
				
				//-------------------------------------------------
				for(int j = 2;j<columns;j++){
					Cell c = sheet.getCell(j,i);

					imprecid = getNextKey(TablesRef.IMPORTRECORDS,getSeq);
					loadRecDate = new java.sql.Date(System.currentTimeMillis());

					ps4.setInt(1,imprecid);
					ps4.setInt(2,impsesid);
					ps4.setDate(3,loadRecDate);
					ps4.setString(5,"E");
					ps4.setString(6,"error.record");
					ps4.setString(7,getCellXY(jxl.CellReferenceHelper.getCellReference(j,i)));
					ps4.setString(8,null);
					ps4.setString(9,null);
					ps4.setString(10,bsNumber+":"+(j-1)+":"+task);
					
					if(c!=null && c.getContents()!=null){

						try{
							
							Integer.parseInt(c.getContents());

							ps.setInt(3,j-1);
							ps.setInt(1,Integer.parseInt(c.getContents()));
							
							int result = ps.executeUpdate();
								
							ps4.setString(4,"U");
								
							if(result==0){
									
								ps7.setInt(2,j-1);
								ps7.setInt(4,Integer.parseInt(c.getContents()));
								ps7.setInt(5,Integer.parseInt("900"));
							
								ps7.execute();
								
								ps4.setString(4,"I");
							}
														
						}catch(NumberFormatException nfe){
							
							ps4.execute();
							errcount++;
						}

					}else{					
						
						ps4.execute();
						errcount++;
					}

						
					
					reccount++;	
				}

				//-------------------------------------------------
				
			}else if(bscount>1){
				imprecid = getNextKey(TablesRef.IMPORTRECORDS,getSeq);
				ps4.setInt(1,imprecid);
				ps4.setInt(2,impsesid);
				ps4.setDate(3,new java.sql.Date(System.currentTimeMillis()));
				ps4.setString(4,"I");
				ps4.setString(5,"E");
				ps4.setString(6,"error.bs.toomach");
				ps4.setString(7,String.valueOf(bsNumber));
				ps4.setString(8,null);
				ps4.setString(9,null);
				ps4.setString(10,String.valueOf(bsNumber));
				ps4.execute();
				errcount++;
			}else if(bscount==0){
				imprecid = getNextKey(TablesRef.IMPORTRECORDS,getSeq);
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
				ps4.execute();
				errcount++;
			}
			
			
		  }
	      if(taskId!=0) break;
    	}
		
		endDate = new java.sql.Date(System.currentTimeMillis());

		ps6.setDate(1,endDate);
		ps6.setDate(2,endDate);
		ps6.setInt(3,reccount);
		ps6.setInt(4,errcount);
		ps6.setInt(5,impsesid);
		ps6.execute();

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
		    if(ps!=null) ps.close();
		    if(ps2!=null) ps2.close();
		    if(ps3!=null) ps3.close();
		    if(ps4!=null) ps4.close();
		    //if(ps5!=null) ps5.close();
		    if(ps6!=null) ps6.close();
		    if(ps7!=null) ps7.close();
		    if(ps8!=null) ps8.close();
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
    return impsesid;

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
		System.out.println("*******exception");
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

		FormFile formFile = aform.getXslFile();    
		String str = formFile.getFileName();
		
	    boolean checkFile = checkFile(request,formFile);//alexshr 
	    boolean cross = aform.isCross();
	    boolean vertic = aform.isVertic();
	    
	    if (request.getParameter("maxReport") == null) {
            aform.setMaxReport(false);
        }	
	    boolean maxReport = aform.isMaxReport();

	    if (!checkFile) { //ѕервоначальный вход на страницу загрузки
			if(request.getParameter("submit.x") != null){
				ActionErrors errors = new ActionErrors();
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file"));		
				saveErrors(request, errors);
		    }
			ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
			//super.perform(mapping, aform, request, response);
			return mapping.findForward("main");
		} else {
			Collection stations = getPermittedDiapasons(form, request, formFile);
			ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLSSTEP2);
			//super.perform(mapping, aform, request, response);
	        return mapping.findForward("step2");
		}
/*	    else if (checkFile && cross && !vertic && maxReport) {
	        //”казан файл и кросс и подробный отчет
	        importXls(form, request, 2,formFile);
	        return mapping.findForward("xlsMaxReport");
	    } else if (checkFile && cross && !vertic && !maxReport) {
	        //”казан файл и кросс и не подробный отчет
	        importXls(form, request, 2,formFile);
	        return mapping.findForward("xlsMinReport");
	    } else if (checkFile && !cross && vertic && maxReport) {
	        //”казан файл и вертикаль и подробный отчет
	        importXls(form, request, 1,formFile);
	        return mapping.findForward("xlsMaxReport");
	    } else if (checkFile && !cross && vertic && !maxReport) {
	        //”казан файл и вертикаль и не подробный отчет
	        importXls(form, request, 1,formFile);
	        return mapping.findForward("xlsMinReport");
	    } else if (checkFile && cross && vertic && maxReport) {
	        //”казан файл и вертикаль и кросс и подробный отчет
	        importXls(form, request, 0,formFile);
	        return mapping.findForward("xlsMaxReport");
	    } else if (checkFile && cross && vertic && !maxReport) {
	        //”казан файл и вертикаль и кросс и не подробный отчет
	        importXls(form, request, 0,formFile);
	        return mapping.findForward("xlsMinReport");
	    } else if (checkFile && !cross && !vertic) {
	        ActionErrors errors = new ActionErrors();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.polar"));		
			saveErrors(request, errors);
			ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
			return mapping.findForward("main");
	    } else {
			ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
	        return mapping.findForward("main");
	    }
*/	    
	} catch(Exception e) {
		System.out.println("-----> ERROR !!!");
		ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS);
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
