package com.hps.july.report.word;

import com.hps.july.persistence.ChangeActAccessBean;
import com.hps.july.persistence.WorkerAccessBean;
import com.hps.july.cdbc.lib.CDBCRowObject;
import java.util.HashMap;
import java.util.ListIterator;
import com.hps.july.persistence.PeopleAccessBean;
import java.util.Enumeration;
import com.hps.july.persistence.DocumentPositionAccessBean;
import java.sql.*;
import javax.sql.*;

/**
 * Печать акта недостачи при инвентаризации
 */
public class ChangeReport
{
	private Integer doc;
	private java.util.HashMap header = new java.util.HashMap();
	private java.util.ArrayList data = new java.util.ArrayList();
	private boolean error = false;
	/**
	 * ContractSupply constructor comment.
	 */
	public ChangeReport(Integer docId) {
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
	
				ChangeActAccessBean bean = new ChangeActAccessBean();
				bean.setInitKey_document(doc.intValue());

				String storagemanname = "";
				WorkerAccessBean w = bean.getStorageManager();
				if(w != null) {
					try {
						storagemanname = w.getMan().getFullName();
					}catch(Exception e) {
						e.printStackTrace(System.out);
				  	}
				}

				header.put("blanknumber",bean.getBlanknumber());
				header.put("blankdate",bean.getBlankdate().toString());
				header.put("storageman",storagemanname);

				com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
				com.hps.july.cdbc.lib.CDBCResultSet rs = c.listChangeActOnStorageItems(doc,new Integer(1));
				ListIterator it = rs.listIterator();
				while(it.hasNext()){
					HashMap hmrow = new HashMap();
					CDBCRowObject ro = (CDBCRowObject)it.next();

					
					String serialnumber = ro.getColumn("newserial").asString();
					if(serialnumber != null && !"".equals(serialnumber)) {
						String manufserial = ro.getColumn("inventserial").asString();
						if(manufserial != null && !"".equals(manufserial) && !serialnumber.equals(manufserial) ) {
							serialnumber += " ("+manufserial+")";
						}
						hmrow.put("serialnumber",serialnumber);
					}
					String oldserialnumber = ro.getColumn("oldserial").asString();
					if(oldserialnumber != null && !"".equals(oldserialnumber)) {
						String oldmanufserial = ro.getColumn("oldinventserial").asString();
						if(oldmanufserial != null && !"".equals(oldmanufserial) && !oldserialnumber.equals(oldmanufserial) ) {
							oldserialnumber += " ("+oldmanufserial+")";
						}
						hmrow.put("oldserialnumber",oldserialnumber);
					}
					
					
					String oresname = ro.getColumn("oresname").asString();
					hmrow.put("oresname",oresname);

					String nresname = ro.getColumn("nresname").asString();
					hmrow.put("nresname",nresname);

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
