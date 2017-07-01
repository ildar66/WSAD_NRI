package com.hps.july.report.word;

import com.hps.july.persistence.WorkerAccessBean;
import com.hps.july.cdbc.lib.CDBCRowObject;
import java.util.HashMap;
import java.util.ListIterator;
import com.hps.july.persistence.PeopleAccessBean;
import java.util.Enumeration;
import com.hps.july.persistence.DocumentPositionAccessBean;
import com.hps.july.persistence.PayOffActAccessBean;
import java.sql.*;
import javax.sql.*;

/**
 * Печать акта недостачи при инвентаризации
 */
public class PayoffReport
{
	private Integer doc;
	private java.util.HashMap header = new java.util.HashMap();
	private java.util.ArrayList data = new java.util.ArrayList();
	private boolean error = false;
	/**
	 * ContractSupply constructor comment.
	 */
	public PayoffReport(Integer docId) {
		doc = docId;
	}
    public String getData( int i, String param ) {

		return (String)((HashMap)data.get(i)).get(param);
	    
    }
    public int getDataSize() {
		return data.size();
	    
    }
/**
 * Insert the method's description here.
 * Creation date: (20.10.2005 13:18:40)
 * @return java.lang.String
 */
public String getHeader(String param) {
	return header.get(param)!=null?(String)header.get(param):"";
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2005 16:04:33)
 * @return boolean
 */
public boolean isError() {
	return error;
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2005 13:35:04)
 */
public void processReport() {
		
			try{
	
				PayOffActAccessBean bean = new PayOffActAccessBean();
				bean.setInitKey_document(doc.intValue());
					
				
				WorkerAccessBean wbean = bean.getChairMan();
				String fullname1 = "";
				if(wbean!=null){
					fullname1 = wbean.getMan().getFullName();
				}
				WorkerAccessBean wbean2 = bean.getMember1();
				String fullname2 = "";
				if(wbean2!=null){
					fullname2 = wbean2.getMan().getFullName();
				}

				header.put("blanknumber",bean.getBlanknumber());
				header.put("blankdate",bean.getBlankdate().toString());
				header.put("iuser1",fullname1);
				header.put("iuser2",fullname2);
				

				com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
				com.hps.july.cdbc.lib.CDBCResultSet rs = c.listPayoffItems(doc,new Integer(1));
				ListIterator it = rs.listIterator();
				while(it.hasNext()){
					HashMap hmrow = new HashMap();
					CDBCRowObject ro = (CDBCRowObject)it.next();
					String order = ro.getColumn("order").asString();
					hmrow.put("order",order);
					String name = ro.getColumn("name").asString();
					hmrow.put("name",name);
					String model = ro.getColumn("model").asString();
					hmrow.put("model",model);
					String invnum = ro.getColumn("invnum").asString();
					hmrow.put("invnum",invnum);
					String qty = ro.getColumn("qty").asString();
					hmrow.put("qty",qty);
					String unitname = ro.getColumn("unitname").asString();
					hmrow.put("unitname",unitname);
					String price = ro.getColumn("price").asString();
					hmrow.put("price",price);
					String summ = ro.getColumn("summ").asString();
					hmrow.put("summ",summ);	
					data.add(hmrow);
				}
				

			}catch(Exception e){
				e.printStackTrace(System.out);
				setError(true);
			}
	
	
	
	
	
	
		
	
}
/**
 * Insert the method's description here.
 * Creation date: (20.10.2005 16:04:33)
 * @param newError boolean
 */
public void setError(boolean newError) {
	error = newError;
}
}
