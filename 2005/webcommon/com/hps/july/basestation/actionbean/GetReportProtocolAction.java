package com.hps.july.basestation.actionbean;

import com.hps.july.cdbc.objects.CDBCComlinesObject;
import com.hps.july.cdbc.lib.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.math.BigDecimal;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.basestation.formbean.ReportFinderForm;

public class GetReportProtocolAction
	extends GetReportAction
{
public ReportProtocolValue constructReportLine(CDBCRowObject ro)
	throws java.lang.Exception
{
	CDBCComlinesObject co = new CDBCComlinesObject();
	CDBCResultSet rs = co.getFASPermission(getIntColumn("hopsid",ro),getIntColumn("filenumber",ro));
	CDBCRowObject fasro = null;
	Iterator it = rs.listIterator();
//System.out.println("FASRO size:"+rs.getRowsCount());
	if(it.hasNext()) { 
		fasro = (CDBCRowObject)it.next();
//System.out.println("FAS NUM:"+getStringColumn("blanknumber",fasro));
	}
	String p1vi = co.getVendorids(getIntColumn("hopsid",ro),1);
	String p2vi = co.getVendorids(getIntColumn("hopsid",ro),2);

	//System.out.println("HS:"+getStringColumn("hopstate",ro));
	ReportProtocolPosition p1 = new ReportProtocolPosition();
		p1.setFilenumber(getStringColumn("filenumber",ro));
		p1.setGsmid(getIntegerColumn("pagsm",ro));
		p1.setPosname(getStringColumn("paname",ro));
		p1.setAddress(getStringColumn("paaddress",ro));
		p1.setLongitude(getDecimalColumn("palong",ro));
		p1.setLatitude(getDecimalColumn("palat",ro));
		p1.setGoslongitude(getStringColumn("pagoslong",ro));
		p1.setGoslatitude(getStringColumn("pagoslat",ro));
		p1.setResmodel(getStringColumn("pamodel",ro));
		p1.setFrequency(getStringColumn("pafreq",ro));
		p1.setHeight(getDoubleColumn("paheight",ro));
		p1.setPower(getDoubleColumn("papower",ro));
		p1.setGrchaddress(getStringColumn("pagrchaddr",ro));
		p1.setComment(getStringColumn("pacomment",ro));
		p1.setEmclass(getStringColumn("emclass",ro));
		p1.setHopsstate(getStringColumn("hopstate",ro));
		if(fasro != null) {	
			p1.setFasnum(getStringColumn("blanknumber",fasro));
			p1.setFasdate(getDateColumn("blankdate",fasro));
			p1.setFasexpire(getDateColumn("expiredate",fasro));
		}
		p1.setVendorid(p1vi);

	ReportProtocolPosition p2 = new ReportProtocolPosition();
		p2.setFilenumber(getStringColumn("filenumber",ro));
		p2.setGsmid(getIntegerColumn("pbgsm",ro));
		p2.setPosname(getStringColumn("pbname",ro));
		p2.setAddress(getStringColumn("pbaddress",ro));
		p2.setLongitude(getDecimalColumn("pblong",ro));
		p2.setLatitude(getDecimalColumn("pblat",ro));
		p2.setGoslongitude(getStringColumn("pbgoslong",ro));
		p2.setGoslatitude(getStringColumn("pbgoslat",ro));
		p2.setResmodel(getStringColumn("pbmodel",ro));
		p2.setFrequency(getStringColumn("pbfreq",ro));
		p2.setHeight(getDoubleColumn("pbheight",ro));
		p2.setPower(getDoubleColumn("pbpower",ro));
		p2.setGrchaddress(getStringColumn("pbgrchaddr",ro));
		p2.setComment(getStringColumn("pbcomment",ro));
		p2.setEmclass(getStringColumn("emclass",ro));
		p2.setHopsstate(getStringColumn("hopstate",ro));
		if(fasro != null) {
			p2.setFasnum(getStringColumn("blanknumber",fasro));
			p2.setFasdate(getDateColumn("blankdate",fasro));
			p2.setFasexpire(getDateColumn("expiredate",fasro));
		}
		p2.setVendorid(p2vi);

	ReportProtocolValue rl = new ReportProtocolValue(p1,p2);
	return rl;
}
private java.sql.Date getDateColumn(String name, CDBCRowObject ro) {
	try {
		return ((java.sql.Date)ro.getColumn(name).asObject());
	} catch(Exception e) {
		return null;
	}
}
private BigDecimal getDecimalColumn(String name, CDBCRowObject ro) {
	try {
		return ((BigDecimal)ro.getColumn(name).asObject());
	} catch(Exception e) {
		return null;
	}
}
private Double getDoubleColumn(String name, CDBCRowObject ro) {
	try {
		return ((Double)ro.getColumn(name).asObject());
	} catch(Exception e) {
		return null;
	}
}
private int getIntColumn(String name, CDBCRowObject ro) {
	try {
		return ((Number)ro.getColumn(name).asObject()).intValue();
	} catch(Exception e) {
		return -1;
	}
}
private Integer getIntegerColumn(String name, CDBCRowObject ro) {
	try {
		return new Integer(((Number)ro.getColumn(name).asObject()).intValue());
	} catch(Exception e) {
		return null;
	}
}
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors) throws Exception {
	if(null == finderForm) {
		return null;
	}
	int filenumber = finderForm.getFilenumber();
	ReportProtocolValue reportVal = null;
	LinkedList reportList = new LinkedList();
	try {
		CDBCComlinesObject co = new CDBCComlinesObject();
		CDBCResultSet rs = co.getReportProtocol(filenumber);
		Iterator it = rs.listIterator();
		while(it.hasNext()) {
			reportVal = this.constructReportLine((CDBCRowObject)it.next());
			reportList.add(reportVal);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
		throw new Exception();
	}
	return reportList;
}
private String getStringColumn(String name, CDBCRowObject ro) {
	return ro.getColumn(name).asString();
}
}
