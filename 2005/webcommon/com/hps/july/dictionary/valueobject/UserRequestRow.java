/*
 * Created on 20.02.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.valueobject;

import java.util.ArrayList;
import java.util.ListIterator;

import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCUserRequestsObject;

/**
 * @author AAErmolov
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserRequestRow {
	private String request="";
	private String datetimein="";
	private String requesttype="";
	private String filialtype="";
	private String regionid="";
	private String worker="";
	private String module="";
	private String description="";
	private String status="";
	private String rfcnum="";

	public UserRequestRow(CDBCRowObject newRow){
		if (newRow.hasColumn("request")) setRequest(newRow.getColumn("request").asString());
		if (newRow.hasColumn("datetimein")) setDatetimein(newRow.getColumn("datetimein").asString());
		if (newRow.hasColumn("requesttype"))
			setRequesttype(
				CDBCUserRequestsObject.getRequesttype(
					new Integer(
						Integer.parseInt(newRow.getColumn("requesttype").asString()))));
		if (newRow.hasColumn("filialtype")) {
			switch (Integer.parseInt(newRow.getColumn("filialtype").asString())){
				case 1: setFilialtype("Консультация"); break;
				case 2: setFilialtype("Ошибка"); break;
				case 3: setFilialtype("Получение доступа"); break;
			}
		}
		if (newRow.hasColumn("regionid")) setRegionid(newRow.getColumn("regionid").asString());
		if (newRow.hasColumn("worker")) {
			String worker = CDBCUserRequestsObject.findMan(new Integer(Integer.parseInt(newRow.getColumn("worker").asString())))[0];
			setWorker(worker); 
		}
		if (newRow.hasColumn("module")) { 
			String module = CDBCUserRequestsObject.getModule(new Integer(Integer.parseInt(newRow.getColumn("module").asString())));
			setModule(module); 
		}
		if (newRow.hasColumn("description")) setDescription(newRow.getColumn("description").asString());
		if (newRow.hasColumn("status")) {
			switch (newRow.getColumn("status").asString().charAt(0)){
				case 'A': setStatus("Ожидает рассмотрения"); break;
				case 'B': setStatus("Рассмотрено"); break;
			}
		} 
		if (newRow.hasColumn("rfcnum")) setRfcnum(newRow.getColumn("rfcnum").asString());
	}
	
	public String getRequest(){return request;}
	public String getDatetimein(){return datetimein;}
	public String getRequesttype(){return requesttype;}
	public String getFilialtype(){return filialtype;}
	public String getRegionid(){return regionid;}
	public String getWorker(){return worker;}
	public String getModule(){return module;}
	public String getDescription(){return description;}
	public String getStatus(){return status;}
	public String getRfcnum(){return rfcnum;}

	public void setRequest(String newRequest){ request = newRequest; }
	public void setDatetimein(String newDatetimein){ datetimein = newDatetimein; }
	public void setRequesttype(String newRequesttype){ requesttype = newRequesttype; }
	public void setFilialtype(String newFilialtype){ filialtype = newFilialtype; }
	public void setRegionid(String newRegionid){ regionid = newRegionid; }
	public void setWorker(String newMan){ worker = newMan; }
	public void setModule(String newModule){ module = newModule; }
	public void setDescription(String newDescription){ description = newDescription; }
	public void setStatus(String newStatus){ status = newStatus; }
	public void setRfcnum(String newRfcnum){ rfcnum = newRfcnum; }
}
