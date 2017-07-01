package com.hps.july.basestation.formbean;

import com.hps.july.trailcom.beans.*;
import com.hps.july.trailcom.beans.HopAccessBean;
import java.sql.*;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import com.hps.july.persistence2.*;
import java.util.*;
import javax.servlet.http.*;
import com.hps.july.web.util.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;

/**
 * Форма редактирования параметров частотного разрешения
 */
public class FrequencyLicenceForm
	extends DocForm
{
	private Integer freqpermid;
	private StringAndIntegerProperty filenumber = new StringAndIntegerProperty();
	private String etap; // CHAR(20)
	private String comment; // VARCHAR(255)
	private Integer[] comlines;
	private Integer[] numbersinfile;
	private String[] sfonumber;
public FrequencyLicenceForm() {
	super();
	comment = null;
	etap = null;
	filenumber.setString("");
	freqpermid = null;
	comlines = null;
}
public static void createComlinelink(int fpid, Integer fn, int comlineid, int numberinfile, String sfonumber)
	throws Exception
{
System.out.println("FPID:"+fpid+",COMID:"+comlineid+",NF:"+numberinfile);
	Perm2HopAccessBean p2h = new Perm2HopAccessBean(fpid,comlineid);
	p2h.setNumberinfile(new Integer(numberinfile));
	p2h.commitCopyHelper();

	HopAccessBean h = new HopAccessBean();
	h.setInitKey_hopsid(comlineid);
	h.refreshCopyHelper();
	if("0".equals(h.getPermstatus())) {
		h.setPermstatus("1");
		h.commitCopyHelper();
	}

	RRLHops2AccessBean rrl = new RRLHops2AccessBean();
	rrl.setInitKey_hopid_hopsid(new Integer(comlineid));
	rrl.refreshCopyHelper();
	rrl.setFile_number(fn);
	rrl.setNumber_in_file(new Integer(numberinfile));
	rrl.setSfonumber(sfonumber);
	rrl.commitCopyHelper();
}
public static Integer createFreqperm(Integer fn, String etp, String comm, Integer[] cl, Integer[] nf, String[] sfn)
	throws Exception
{
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	int fpid = keyGen.getNextKey("tables.freqpermissions");
	
	FreqPermissionAccessBean fp = new FreqPermissionAccessBean(fpid);
	fp.setFilenumber(fn);
	fp.setEtap(etp);
	fp.setComment(comm);
	fp.commitCopyHelper();

	// create comline links
	updatePerm2hops(fpid,cl,nf,sfn,fn);

	return new Integer(fpid);
}
public int getApplication() {
	return com.hps.july.constants.Applications.BASESTATION;
}
public Integer[] getComlines() {
	return comlines;
}
public Iterator getComlinesList() {
	try {
		CDBCResultSet rs = (new CDBCSitedocsObject()).findFrequencyLicenceComlines(freqpermid);
		return rs.listIterator();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return new ArrayList().iterator();
	}
}
public String getComment() {
	return comment;
}
public String getEtap() {
	return etap;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getFilenumber() {
	return filenumber;
}
public Integer getFreqpermid() {
	return freqpermid;
}
/**
 * 
 * @return java.lang.Integer[]
 */
public java.lang.Integer[] getNumbersinfile() {
	return numbersinfile;
}
/**
 * 
 * @return java.lang.String[]
 */
public java.lang.String[] getSfonumber() {
	return sfonumber;
}
public int getState() {
	return com.hps.july.basestation.APPStates.FREQLICENCE_FORM;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setUser(request);
	super.initRecord(request);
}
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setUser(request);
	try {
		FreqPermissionAccessBean fp = new FreqPermissionAccessBean();
		fp.setInitKey_freqpermid(getFreqpermid().intValue());
		fp.refreshCopyHelper();
		filenumber.setInteger(fp.getFilenumber());
		etap = fp.getEtap();
		comment = fp.getComment();
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}

	try {
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}

	/*
	try {
		ArrayList arr = new ArrayList();
		CDBCSitedocsObject sdo = new CDBCSitedocsObject();
		CDBCResultSet rs = sdo.findGKRCHRegions(new Integer(getSitedoc()));
		Iterator it = rs.listIterator();
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			arr.add((Integer)ro.getColumn("regionid").asObject());
		}
		regions = new Integer[arr.size()];
		for(int i = 0; i < arr.size(); i++) {
			regions[i] = (Integer)arr.get(i);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	*/
}
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	setUser(request);

	// Delete documents
	SitedocFacadeAccessBean be = new SitedocFacadeAccessBean();
	CDBCSitedocsObject sdo = new CDBCSitedocsObject();
	CDBCResultSet rs = sdo.findFrequencyLicenceHistory(getFreqpermid(),new Integer(1));
	Iterator it = rs.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Object o = ro.getColumn("sitedoc").asObject();
		if(o != null && o instanceof Integer) {
			be.deleteEtapDoc(((Integer)o).intValue());
		}
	}
	
	// Delete hops links
	removeComlineLinks(freqpermid.intValue());

	FreqPermissionAccessBean fp = new FreqPermissionAccessBean();
	fp.setInitKey_freqpermid(freqpermid.intValue());
	fp.refreshCopyHelper();
	fp.getEJBRef().remove();
	return null;
}
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	setUser(request);
	freqpermid = createFreqperm(filenumber.getInteger(),getEtap(),getComment(),comlines,numbersinfile,sfonumber);
	return null;
}
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
	setUser(request);
	try {
		FreqPermissionAccessBean fp = new FreqPermissionAccessBean();
		fp.setInitKey_freqpermid(freqpermid.intValue());
		fp.refreshCopyHelper();
		fp.setFilenumber(filenumber.getInteger());
		fp.setEtap(getEtap());
		fp.setComment(getComment());
		fp.commitCopyHelper();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.freqform.updatefiled");
	}
	// update comline links
	try {
		updatePerm2hops(freqpermid.intValue(),comlines,numbersinfile,sfonumber,filenumber.getInteger());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.freqform.updatecomlinefiled");
	}
	
	return null;
}
public static void removeComlineLinks(int fpid)
{
	Connection con = null;
	PreparedStatement pst = null;
	try {
		JdbcConnection jcon = new JdbcConnection();
		con = jcon.getConnection();
		pst = con.prepareStatement("UPDATE rrl_hops2 SET file_number = NULL, number_in_file = NULL WHERE hopsid IN (SELECT p2h.hopsid FROM perm2hops p2h WHERE p2h.freqpermid = ?) ");
		pst.setInt(1,fpid);
		pst.executeUpdate();
		pst.close();
		pst = con.prepareStatement("DELETE FROM perm2hops WHERE perm2hops.freqpermid = ?");
		pst.setInt(1,fpid);
		pst.executeUpdate();
	} catch (Exception ee) {
		ee.printStackTrace(System.out);
	} finally {
		try {if(pst!=null)pst.close();} catch (Exception e) { /* Ignore error */ }
		try {if(con!=null)con.close();} catch (Exception e) { /* Ignore error */ }
	}
}
public static void removeComlineLinks(int fpid, int hopsid)
{
	Connection con = null;
	PreparedStatement pst = null;
	try {
		JdbcConnection jcon = new JdbcConnection();
		con = jcon.getConnection();
		pst = con.prepareStatement("UPDATE rrl_hops2 SET file_number = NULL, number_in_file = NULL WHERE hopsid = ? ");
		pst.setInt(1,hopsid);
		pst.executeUpdate();
		pst.close();
		pst = con.prepareStatement("DELETE FROM perm2hops WHERE perm2hops.freqpermid = ? AND perm2hops.hopsid = ? ");
		pst.setInt(1,fpid);
		pst.setInt(1,hopsid);
		pst.executeUpdate();
	} catch (Exception ee) {
		ee.printStackTrace(System.out);
	} finally {
		try {if(pst!=null)pst.close();} catch (Exception e) { /* Ignore error */ }
		try {if(con!=null)con.close();} catch (Exception e) { /* Ignore error */ }
	}
}
public void setComlines(Integer[] newComlines) {
	comlines = newComlines;
}
public void setComment(String newComment) {
	comment = newComment;
}
public void setEtap(String newEtap) {
	etap = newEtap;
}
public void setFreqpermid(Integer newFreqpermid) {
	freqpermid = newFreqpermid;
}
/**
 * 
 * @param newNumbersinfile java.lang.Integer[]
 */
public void setNumbersinfile(java.lang.Integer[] newNumbersinfile) {
	numbersinfile = newNumbersinfile;
}
/**
 * 
 * @param newSfonumber java.lang.String[]
 */
public void setSfonumber(java.lang.String[] newSfonumber) {
	sfonumber = newSfonumber;
}
public static void updateComlinelink(int fpid, Integer fn, int comlineid, int numberinfile, String sfn)
	throws Exception
{
System.out.println("FPID:"+fpid+",COMID:"+comlineid+",NF:"+numberinfile);
	Perm2HopAccessBean p2h = new Perm2HopAccessBean();
	p2h.setInitKey_freqpermid(fpid);
	p2h.setInitKey_hopsid(comlineid);
	p2h.refreshCopyHelper();
	p2h.setNumberinfile(new Integer(numberinfile));
	p2h.commitCopyHelper();

	HopAccessBean h = new HopAccessBean();
	h.setInitKey_hopsid(comlineid);
	h.refreshCopyHelper();
	if("0".equals(h.getPermstatus())) {
		h.setPermstatus("1");
		h.commitCopyHelper();
	}

	RRLHops2AccessBean rrl = new RRLHops2AccessBean();
	rrl.setInitKey_hopid_hopsid(new Integer(comlineid));
	rrl.refreshCopyHelper();
	rrl.setFile_number(fn);
	rrl.setNumber_in_file(new Integer(numberinfile));
	rrl.setSfonumber(sfn);
	rrl.commitCopyHelper();
}
public static void updatePerm2hops(int fpid, Integer[] cl, Integer[] nf, String[] sfonumber, Integer fn)
	throws Exception
{
	CDBCSitedocsObject sdo = new CDBCSitedocsObject();
//	sdo.find
	if(cl != null) {
		sdo.deleteFL2HopsUnusedLinks(new Integer(fpid),cl);
		for(int i = 0; i < cl.length; i++) {
			if(cl[i] != null) {
				Iterator it = sdo.findFL2HopsLink(new Integer(fpid),cl[i]);
				if(it.hasNext()) {
					updateComlinelink(fpid,fn,cl[i].intValue(),(nf[i] != null)?nf[i].intValue():1, sfonumber[i]);
				} else {
					createComlinelink(fpid,fn,cl[i].intValue(),(nf[i] != null)?nf[i].intValue():1, sfonumber[i]);
				}
			}
		}
	}
}
public void validateValues(ActionErrors errors)
	throws Exception 
{
	if(filenumber.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.freqform.filenumber.empty"));
	} else if(!filenumber.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.freqform.filenumber.invalid"));
	} else {
		// Проверить совпадение номера
		CDBCSitedocsObject sdo = new CDBCSitedocsObject();
		CDBCResultSet rs = sdo.findFrequencyLicenceByFN(filenumber.getInteger(),getFreqpermid());
		Iterator it = rs.listIterator();
		if(it.hasNext()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.freqform.filenumber.duplicate"));
		}
	}

	if(etap != null && !"".equals(etap.trim())) {
		etap = etap.trim();
		if(etap.length() > 20) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.freqfrom.etap.length"));
		}
	}

	if(comment != null && !"".equals(comment.trim())) {
		comment = comment.trim();
		if(comment.length() > 255) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.freqfrom.comment.length"));
		}
	}

	if(comlines == null || comlines.length < 1) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.freqform.comlines.empty"));
	}

	if(!errors.empty()) {
		throw new ValidationException();
	}
}
}
