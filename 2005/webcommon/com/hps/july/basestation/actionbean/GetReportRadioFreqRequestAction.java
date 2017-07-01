package com.hps.july.basestation.actionbean;

import java.util.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.basestation.formbean.ReportFinderForm;
import org.apache.struts.action.*;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.persistence.NamedValueAccessBean;
import java.sql.*;
import com.hps.july.cdbc.lib.*;
import javax.servlet.http.*;

/**
 * Action для получения "Заявки на назначение радиочастот
 * для радиорелейных линий связи"
 */
public class GetReportRadioFreqRequestAction
	extends GetReportAction
{
private void fillAntennas(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE ap.antdiam "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r, rrlantparams ap "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND ap.resource = rh.resource_doc "+
		"AND (ap.antdiam = rh.diam_a_doc OR ap.antdiam = rh.diam_b_doc) "+
		"AND rh.resource_doc = r.resource AND fp.filenumber = ? "+
		"ORDER BY ap.antdiam ASC ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addAnttype((java.math.BigDecimal)ro.getColumn("antdiam").asObject());
	
	}
}
private void fillCoeff(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model, ap.amplifkoeff "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r, rrlantparams ap "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND rh.resource_doc = r.resource AND ap.resource = rh.resource_doc "+
		"AND (ap.antdiam = rh.diam_a_doc OR ap.antdiam = rh.diam_b_doc) "+
		"AND fp.filenumber = ? ORDER BY r.model ASC";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addCoeff(
			ro.getColumn("model").asString(),
			(java.math.BigDecimal)ro.getColumn("amplifkoeff").asObject()
		);
	}
}
private void fillFreqdev(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model, a.freqdevlowk "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r, rrlantennares a "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND a.resource = rh.resource_doc "+
		"AND rh.resource_doc = r.resource AND fp.filenumber = ? "+
		"ORDER BY r.model ASC ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addFreqdevs(
			ro.getColumn("model").asString(),
			(java.math.BigDecimal)ro.getColumn("freqdevlowk").asObject()
		);
	}
}
private void fillFreqranges(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model, sr.freqrange "+
		"FROM sitedocs2resources sr, gkrchdocs gd, sitedocs s, freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r "+
		"WHERE sr.sitedoc = gd.sitedoc AND gd.sitedoc = s.sitedoc "+
		"AND (s.expiredate >= TODAY OR s.expiredate IS NULL) "+
		"AND fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND sr.resource = rh.resource_doc "+
		"AND sr.resource = r.resource "+
		"AND fp.filenumber = ? "+
		"ORDER BY r.model ASC ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addFreqrange(
			ro.getColumn("model").asString(),
			ro.getColumn("freqrange").asString()
		);
	}
}
private void fillGKRCHs(ReportRadioFreqRequestVOs vo, int filenumber) {
	Iterator resit = getResourcesList(filenumber);
	while(resit.hasNext()) {
		CDBCRowObject resro = (CDBCRowObject)resit.next();
		String resmodel = resro.getColumn("model").asString();
		int resid = ((Number)resro.getColumn("resource").asObject()).intValue();

		// find GKRCH doc
		String q = "SELECT s.sitedoc, s.blanknumber, s.blankdate FROM sitedocs2resources sr, gkrchdocs gd, sitedocs s WHERE sr.resource = ? AND sr.sitedoc = s.sitedoc AND s.sitedoc = gd.sitedoc AND (s.expiredate >= TODAY OR s.expiredate IS NULL) ORDER BY s.blankdate DESC ";
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(q, new Object[] { new Integer(resid) });
		Iterator it = res.listIterator();
		if(it.hasNext()) {
			while(it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				vo.addGkrchs(
					resmodel,
					ro.getColumn("blanknumber").asString(),
					(java.sql.Date)ro.getColumn("blankdate").asObject()
				);
			}
		} else {
			vo.addGkrchs(resmodel,null, null);
		}
	}
	/*
	String q = 
		"SELECT UNIQUE r.model, s.blanknumber, s.blankdate "+
		"FROM sitedocs2resources sr, gkrchdocs gd, sitedocs s, freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r "+
		"WHERE sr.sitedoc = gd.sitedoc AND gd.sitedoc = s.sitedoc "+
		"AND (s.expiredate >= TODAY OR s.expiredate IS NULL) "+
		"AND fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND sr.resource = rh.resource_doc "+
		"AND sr.resource = r.resource "+
		"AND fp.filenumber = ? "+
		"ORDER BY r.model ASC, s.blankdate DESC, s.blanknumber ASC";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addGkrchs(
			ro.getColumn("model").asString(),
			ro.getColumn("blanknumber").asString(),
			(java.sql.Date)ro.getColumn("blankdate").asObject()
		);
	}
	*/
}
private void fillMKKR(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model, a.mkkrrecomm "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r, rrlantennares a "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND a.resource = rh.resource_doc "+
		"AND rh.resource_doc = r.resource AND fp.filenumber = ? "+
		"ORDER BY r.model ASC ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addMkkrplan(
			ro.getColumn("model").asString(),
			ro.getColumn("mkkrrecomm").asString()
		);
	}
}
private void fillModels(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND rh.resource_doc = r.resource AND fp.filenumber = ? "+
		"ORDER BY r.model ASC";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addModels(ro.getColumn("model").asString());
	}
}
private void fillPowers(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model, rh.power_doc "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND rh.resource_doc = r.resource AND fp.filenumber = ? "+
		"ORDER BY r.model ASC ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Double d = (Double)ro.getColumn("power_doc").asObject();
		vo.addPowers(
			ro.getColumn("model").asString(),
			new java.math.BigDecimal(d.toString())
		);
	}
}
private void fillRadioclasses(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model, sp.radiationclass "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r, rrlspeedparams sp "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND rh.resource_doc = r.resource AND sp.streamspeed = rh.speed_doc AND sp.resource = rh.resource_doc "+
		"AND fp.filenumber = ? ORDER BY r.model ASC ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addRadioclass(
			ro.getColumn("model").asString(),
			ro.getColumn("radiationclass").asString()
		);
	}
}
private void fillRRLs(ReportRadioFreqRequestVOs vo, int filenumber) {
	Iterator resit = getResourcesList(filenumber);
	while(resit.hasNext()) {
		CDBCRowObject resro = (CDBCRowObject)resit.next();
		String resmodel = resro.getColumn("model").asString();
		int resid = ((Number)resro.getColumn("resource").asObject()).intValue();

		String q = "SELECT s.sitedoc, s.blanknumber, s.blankdate FROM sitedocs2resources sr, rrldocs rd, sitedocs s WHERE sr.resource = ? AND sr.sitedoc = s.sitedoc AND s.sitedoc = rd.sitedoc ORDER BY s.blankdate DESC ";
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(q, new Object[] { new Integer(resid) });
		Iterator it = res.listIterator();
		if(it.hasNext()) {
			while(it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				vo.addRrls(
					resmodel,
					ro.getColumn("blanknumber").asString(),
					(java.sql.Date)ro.getColumn("blankdate").asObject()
				);
			}
		} else {
			vo.addRrls(resmodel,null, null);
		}
	}
/*
	String q = 
		"SELECT UNIQUE r.model, s.blanknumber, s.blankdate "+
		"FROM sitedocs2resources sr, rrldocs rrd, sitedocs s, freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r "+
		"WHERE sr.sitedoc = rrd.sitedoc AND rrd.sitedoc = s.sitedoc "+
		"AND fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND sr.resource = rh.resource_doc "+
		"AND sr.resource = r.resource "+
		"AND fp.filenumber = ? "+
		"ORDER BY r.model ASC, s.blankdate DESC, s.blanknumber ASC";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addRrls(
			ro.getColumn("model").asString(),
			ro.getColumn("blanknumber").asString(),
			(java.sql.Date)ro.getColumn("blankdate").asObject()
		);
	}
*/
}
private void fillRsenses(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model, sp.recvsensitivity "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r, rrlspeedparams sp "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND sp.streamspeed = rh.speed_doc "+
		"AND sp.resource = rh.resource_doc "+
		"AND rh.resource_doc = r.resource AND fp.filenumber = ? "+
		"ORDER BY r.model ASC ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addRsens(
			ro.getColumn("model").asString(),
			(java.math.BigDecimal)ro.getColumn("recvsensitivity").asObject()
		);
	}
}
private void fillSpeeds(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model, rh.speed_doc "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND rh.resource_doc = r.resource AND fp.filenumber = ? "+
		"ORDER BY r.model ASC ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addSpeeds(
			ro.getColumn("model").asString(),
			ro.getColumn("speed_doc").asString()
		);
	}
}
private void fillVendors(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE o.name "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r, organizations o "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND rh.resource_doc = r.resource AND r.manufacturer = o.organization "+
		"AND fp.filenumber = ? ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addVendors(ro.getColumn("name").asString());
	}
}
private void fillWidth(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = 
		"SELECT UNIQUE r.model, ap.dnanglew, ap.dnangleh "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r, rrlantparams ap "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND rh.resource_doc = r.resource AND ap.resource = rh.resource_doc "+
		"AND (ap.antdiam = rh.diam_a_doc OR ap.antdiam = rh.diam_b_doc) "+
		"AND fp.filenumber = ? ORDER BY r.model ASC ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.addWidths(
			ro.getColumn("model").asString(),
			ro.getColumn("dnanglew").asObject(),
			ro.getColumn("dnangleh").asObject()
		);
	}
}
public Object getReportList(ReportFinderForm finderForm, ActionErrors errors)
	throws java.lang.Exception
{
	ReportRadioFreqRequestVOs valueLists = new ReportRadioFreqRequestVOs();
	try {
		if(null == finderForm) {
			return null;
		}
		int filenumber = finderForm.getFilenumber();

		setHopscount(valueLists, filenumber);
		fillGKRCHs(valueLists, filenumber);
		fillModels(valueLists, filenumber);
		fillVendors(valueLists, filenumber);
		fillFreqranges(valueLists, filenumber);
		fillRadioclasses(valueLists, filenumber);
		fillMKKR(valueLists, filenumber);
		fillPowers(valueLists, filenumber);
		fillFreqdev(valueLists, filenumber);
		fillRsenses(valueLists, filenumber);
		fillAntennas(valueLists, filenumber);
		fillCoeff(valueLists, filenumber);
		fillWidth(valueLists, filenumber);
		fillSpeeds(valueLists, filenumber);
		fillRRLs(valueLists, filenumber);
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
		
	return valueLists;
}
private Iterator getResourcesList(int filenumber) {
	String q = 
		"SELECT UNIQUE r.resource, r.model "+
		"FROM freqpermissions fp, perm2hops p2h, rrl_hops2 rh, resources r "+
		"WHERE fp.freqpermid = p2h.freqpermid AND p2h.hopsid = rh.hopsid "+
		"AND r.resource = rh.resource_doc AND fp.filenumber = ? "+
		"ORDER BY r.model ASC";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	return res.listIterator();
}
/**
 * 
 * @return java.lang.String
 */
public String getUnderlineName() {
	return "ReportFrequencyRequestUnderlineName";
}
/**
 * 
 * @return java.lang.String
 */
public String getUnderlineTitle() {
	return "ReportFrequencyRequestUnderlineTitle";
}
private void setHopscount(ReportRadioFreqRequestVOs vo, int filenumber) {
	String q = "SELECT count(p2h.hopsid) hopscount FROM freqpermissions fp, perm2hops p2h WHERE fp.freqpermid = p2h.freqpermid AND fp.filenumber = ? ";
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(q, new Object[] { new Integer(filenumber) });
	Iterator it = res.listIterator();
	if(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		vo.setHopscount(((Number)ro.getColumn("hopscount").asObject()).intValue());
	} else {
		vo.setHopscount(0);
	}
}
/**
 * 
 * @param request javax.servlet.http.HttpServletRequest
 */
public void setUnderlineParamsToRequest(HttpServletRequest request) {
	NamedValueAccessBean nab = new NamedValueAccessBean();
	try{
		nab.setInitKey_id(getUnderlineTitle());
		nab.refreshCopyHelper();
		request.setAttribute("underlinetitle", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("underlinetitle", "");
		System.out.println("System constant 'ReportFrequencyRequestUnderlineTitle is missing!");
	}
	try {
		nab = new NamedValueAccessBean();
		nab.setInitKey_id(getUnderlineName());
		nab.refreshCopyHelper();
		request.setAttribute("underlinename", nab.getCharvalue());
	} catch (Exception e) {
		request.setAttribute("underlinename", "");
		System.out.println("System constant 'ReportFrequencyRequestUnderlineName is missing!");
	}
}
}
