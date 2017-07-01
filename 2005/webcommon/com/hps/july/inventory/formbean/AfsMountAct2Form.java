package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;

import com.hps.july.logic.VisualDocTypes;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.ListIterator;
import java.util.Vector;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * Форма ввода акта монтажа афс в виде сложного документа.
 * Creation date: (15.10.2004 17:26:12)
 * @author: Dmitry Dneprov
 */
public class AfsMountAct2Form extends DocumentForm {
	private java.lang.String actdate;
	private java.lang.String posnumber;
	private java.lang.String serial10C;
	private java.lang.String serial10B;
	private java.lang.String serial10A;
	private java.lang.String azimA;
	private java.lang.String naklA;
	private java.lang.String naklD;
	private java.lang.String naklC;
	private java.lang.String naklB;
	private java.lang.String azimD;
	private java.lang.String azimC;
	private java.lang.String azimB;
	private java.lang.String serial60AA;
	private java.lang.String qty60AA;
	private java.lang.String qty120AA;
	private java.lang.String qty110AA;
	private java.lang.String qty100AA;
	private java.lang.String qty90AA;
	private java.lang.String qty80AA;
	private java.lang.String qty70AA;
	private java.lang.String qty50AA;
	private java.lang.String ksvnAA;
	private java.lang.String serial50AA;
	private java.lang.String serial120AA;
	private java.lang.String serial110AA;
	private java.lang.String serial100AA;
	private java.lang.String serial90AA;
	private java.lang.String serial80AA;
	private java.lang.String serial70AA;
	private java.lang.String serial60BA;
	private java.lang.String qty60BA;
	private java.lang.String qty120BA;
	private java.lang.String qty110BA;
	private java.lang.String qty100BA;
	private java.lang.String qty90BA;
	private java.lang.String qty80BA;
	private java.lang.String qty70BA;
	private java.lang.String qty50BA;
	private java.lang.String ksvnBA;
	private java.lang.String gndcntBA;
	private java.lang.String serial50BA;
	private java.lang.String serial120BA;
	private java.lang.String serial110BA;
	private java.lang.String serial100BA;
	private java.lang.String serial90BA;
	private java.lang.String serial80BA;
	private java.lang.String serial70BA;
	private java.lang.String serial60CA;
	private java.lang.String qty60CA;
	private java.lang.String qty120CA;
	private java.lang.String qty110CA;
	private java.lang.String qty100CA;
	private java.lang.String qty90CA;
	private java.lang.String qty80CA;
	private java.lang.String qty70CA;
	private java.lang.String qty50CA;
	private java.lang.String ksvnCA;
	private java.lang.String gndcntCA;
	private java.lang.String serial50CA;
	private java.lang.String serial120CA;
	private java.lang.String serial110CA;
	private java.lang.String serial100CA;
	private java.lang.String serial90CA;
	private java.lang.String serial80CA;
	private java.lang.String serial70CA;
	private java.lang.String serial60DA;
	private java.lang.String qty60DA;
	private java.lang.String qty120DA;
	private java.lang.String qty110DA;
	private java.lang.String qty100DA;
	private java.lang.String qty90DA;
	private java.lang.String qty80DA;
	private java.lang.String qty70DA;
	private java.lang.String qty50DA;
	private java.lang.String ksvnDA;
	private java.lang.String gndcntDA;
	private java.lang.String serial50DA;
	private java.lang.String serial120DA;
	private java.lang.String serial110DA;
	private java.lang.String serial100DA;
	private java.lang.String serial90DA;
	private java.lang.String serial80DA;
	private java.lang.String serial70DA;
	private java.lang.String serial60DC;
	private java.lang.String qty60DC;
	private java.lang.String qty120DC;
	private java.lang.String qty110DC;
	private java.lang.String qty100DC;
	private java.lang.String qty90DC;
	private java.lang.String qty80DC;
	private java.lang.String qty70DC;
	private java.lang.String qty50DC;
	private java.lang.String ksvnDC;
	private java.lang.String gndcntDC;
	private java.lang.String serial50DC;
	private java.lang.String serial120DC;
	private java.lang.String serial110DC;
	private java.lang.String serial100DC;
	private java.lang.String serial90DC;
	private java.lang.String serial80DC;
	private java.lang.String serial70DC;
	private java.lang.String serial60DB;
	private java.lang.String qty60DB;
	private java.lang.String qty120DB;
	private java.lang.String qty110DB;
	private java.lang.String qty100DB;
	private java.lang.String qty90DB;
	private java.lang.String qty80DB;
	private java.lang.String qty70DB;
	private java.lang.String qty50DB;
	private java.lang.String ksvnDB;
	private java.lang.String gndcntDB;
	private java.lang.String serial50DB;
	private java.lang.String serial120DB;
	private java.lang.String serial110DB;
	private java.lang.String serial100DB;
	private java.lang.String serial90DB;
	private java.lang.String serial80DB;
	private java.lang.String serial70DB;
	private java.lang.String serial60CC;
	private java.lang.String qty60CC;
	private java.lang.String qty120CC;
	private java.lang.String qty110CC;
	private java.lang.String qty100CC;
	private java.lang.String qty90CC;
	private java.lang.String qty80CC;
	private java.lang.String qty70CC;
	private java.lang.String qty50CC;
	private java.lang.String ksvnCC;
	private java.lang.String gndcntCC;
	private java.lang.String serial50CC;
	private java.lang.String serial120CC;
	private java.lang.String serial110CC;
	private java.lang.String serial100CC;
	private java.lang.String serial90CC;
	private java.lang.String serial80CC;
	private java.lang.String serial70CC;
	private java.lang.String serial60CB;
	private java.lang.String qty60CB;
	private java.lang.String qty120CB;
	private java.lang.String qty110CB;
	private java.lang.String qty100CB;
	private java.lang.String qty90CB;
	private java.lang.String qty80CB;
	private java.lang.String qty70CB;
	private java.lang.String qty50CB;
	private java.lang.String ksvnCB;
	private java.lang.String gndcntCB;
	private java.lang.String serial50CB;
	private java.lang.String serial120CB;
	private java.lang.String serial110CB;
	private java.lang.String serial100CB;
	private java.lang.String serial90CB;
	private java.lang.String serial80CB;
	private java.lang.String serial70CB;
	private java.lang.String serial60BC;
	private java.lang.String qty60BC;
	private java.lang.String qty120BC;
	private java.lang.String qty110BC;
	private java.lang.String qty100BC;
	private java.lang.String qty90BC;
	private java.lang.String qty80BC;
	private java.lang.String qty70BC;
	private java.lang.String qty50BC;
	private java.lang.String ksvnBC;
	private java.lang.String gndcntBC;
	private java.lang.String serial50BC;
	private java.lang.String serial120BC;
	private java.lang.String serial110BC;
	private java.lang.String serial100BC;
	private java.lang.String serial90BC;
	private java.lang.String serial80BC;
	private java.lang.String serial70BC;
	private java.lang.String serial60BB;
	private java.lang.String qty60BB;
	private java.lang.String qty120BB;
	private java.lang.String qty110BB;
	private java.lang.String qty100BB;
	private java.lang.String qty90BB;
	private java.lang.String qty80BB;
	private java.lang.String qty70BB;
	private java.lang.String qty50BB;
	private java.lang.String ksvnBB;
	private java.lang.String gndcntBB;
	private java.lang.String serial50BB;
	private java.lang.String serial120BB;
	private java.lang.String serial110BB;
	private java.lang.String serial100BB;
	private java.lang.String serial90BB;
	private java.lang.String serial80BB;
	private java.lang.String serial70BB;
	private java.lang.String serial60AC;
	private java.lang.String qty60AC;
	private java.lang.String qty120AC;
	private java.lang.String qty110AC;
	private java.lang.String qty100AC;
	private java.lang.String qty90AC;
	private java.lang.String qty80AC;
	private java.lang.String qty70AC;
	private java.lang.String qty50AC;
	private java.lang.String ksvnAC;
	private java.lang.String gndcntAC;
	private java.lang.String serial50AC;
	private java.lang.String serial120AC;
	private java.lang.String serial110AC;
	private java.lang.String serial100AC;
	private java.lang.String serial90AC;
	private java.lang.String serial80AC;
	private java.lang.String serial70AC;
	private java.lang.String serial60AB;
	private java.lang.String qty60AB;
	private java.lang.String qty120AB;
	private java.lang.String qty110AB;
	private java.lang.String qty100AB;
	private java.lang.String qty90AB;
	private java.lang.String qty80AB;
	private java.lang.String qty70AB;
	private java.lang.String qty50AB;
	private java.lang.String ksvnAB;
	private java.lang.String gndcntAB;
	private java.lang.String serial50AB;
	private java.lang.String serial120AB;
	private java.lang.String serial110AB;
	private java.lang.String serial100AB;
	private java.lang.String serial90AB;
	private java.lang.String serial80AB;
	private java.lang.String serial70AB;
	private java.lang.String serial30C;
	private java.lang.String serial30B;
	private java.lang.String serial30A;
	private java.lang.String serial20C;
	private java.lang.String serial20B;
	private java.lang.String serial20A;
	private java.lang.Integer ownercode;
	private int document;
	private java.lang.String serial40C;
	private java.lang.String serial40B;
	private java.lang.String serial40A;
	private java.lang.Integer resource40;
	private java.lang.Integer resource110;
	private java.lang.Integer resource120;
	private java.lang.Integer resource100;
	private java.lang.Integer resource90;
	private java.lang.Integer resource80;
	private java.lang.Integer resource30;
	private java.lang.Integer resource20;
	private java.lang.Integer resource10;
	private java.lang.Integer resource50A;
	private java.lang.Integer resource50B;
	private java.lang.Integer resource50C;
	private java.lang.Integer resource50D;
	private java.lang.Integer resource60;
	private java.lang.Integer resource70;
	private java.lang.String providercode;
	private java.lang.String providername;
	private java.lang.String insuranceMan;
	private java.lang.String workercode;
	private java.lang.String workername;
	private java.lang.String workertitle;
	private java.lang.Integer complectcode;
	private java.lang.String complectname;
	private java.lang.String user;
	private boolean manycomplects;
	private java.lang.String oldposnumber;
	private java.lang.String qty10C;
	private java.lang.String qty10B;
	private java.lang.String qty10A;
	private boolean comcabAA;
	private String gndcntAA;
	private boolean comcabBA;
	private boolean comcabCA;
	private boolean comcabDA;
	private boolean comcabDC;
	private boolean comcabDB;
	private boolean comcabCC;
	private boolean comcabCB;
	private boolean comcabBC;
	private boolean comcabBB;
	private boolean comcabAC;
	private boolean comcabAB;
	private java.lang.String qty40C;
	private java.lang.String qty40B;
	private java.lang.String qty40A;
	private java.lang.String qty30C;
	private java.lang.String qty30B;
	private java.lang.String qty30A;
	private java.lang.String qty20C;
	private java.lang.String qty20B;
	private java.lang.String qty20A;
	private java.lang.Boolean isAdmin;
	private java.lang.String diffs;
	private java.lang.String diap;
	private int indiap;
	private int refreshFields;
	private java.lang.String sectorA;
	private java.lang.String sectorB;
	private boolean newform;
	private java.lang.String hsetA;
	private java.lang.String hsetB;
	private java.lang.String hsetC;
	private java.lang.String hsetD;
	private java.lang.Integer projectid;
	private java.lang.String projectname;
	private boolean needapprove;
	private java.lang.String readprjstatus;
	private Integer visualtype;
	private String dstate;

/**
 * Конструктор.
 * Creation date: (03.12.2004 15:47:42)
 */
public AfsMountAct2Form() {
	diffs = "3";
	Integer defcabtype = new Integer(com.hps.july.util.AppUtils.getNamedValueInt("AntennaCableType"));
	setResource50A(defcabtype);
	setResource50B(defcabtype);
	setResource50C(defcabtype);
	setResource50D(defcabtype);
	newform = false;
}

public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	return null;
}

public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	return null;
}

public String getDState() {
	return dstate;
}

public void setDState(String newState) {
	dstate = newState;
}
	
protected void preloadRecord() 	
	throws Exception
{
	AfsMountActAccessBean bean = new AfsMountActAccessBean();
	bean.setInitKey_document(getDocument());
	bean.refreshCopyHelper();
	setOwnercode(new Integer(bean.getOwner().getOrganization()));
	StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
	sd.setSqlDate(bean.getBlankdate());
	setActdate(sd.getString());
	setInsuranceMan(bean.getInsuranseMan());
	WorkerAccessBean wrk = bean.getMonter();
	wrk.refreshCopyHelper();
	StringAndIntegerProperty wrkcode = new StringAndIntegerProperty();
	wrkcode.setInteger(new Integer(wrk.getWorker()));
	setWorkercode(wrkcode.getString());
	setWorkername(wrk.getMan().getFullName());
	
	// Определим экспедицию
	ExpeditionAccessBean exp1 = new ExpeditionAccessBean(); 
	exp1.setInitKey_storageplace(bean.getFromKey().storageplace);
	exp1.refreshCopyHelper();
	
	StringAndIntegerProperty pcode = new StringAndIntegerProperty();
	pcode.setInteger(new Integer(exp1.getOrganization().getOrganization()));
	setProvidercode(pcode.getString());
	setProvidername(exp1.getOrganization().getName());
	
	BaseStationAccessBean bab = new BaseStationAccessBean();
	bab.setInitKey_storageplace(bean.getToKey().storageplace);
	StringAndIntegerProperty pn = new StringAndIntegerProperty();
	pn.setInteger(new Integer(bab.getNumber()));  
	setPosnumber(pn.getString());
	setComplectcode(new Integer(bab.getStorageplace()));
	setComplectname(bab.getName());
	setDState(bean.getDocumentState());
			
	setNeedapprove(bean.getNeedapprove());
	setProjectid(bean.getProjectid());
	setProjectname("");
	setVisualtype(bean.getVisualtype());
	if (VisualDocTypes.AFS_MOUNT_ACT_1800.equals(getVisualtype())) {
		setIndiap(1);
	} else if (VisualDocTypes.AFS_MOUNT_ACT_900.equals(getVisualtype())) {
		setIndiap(2);
	} else if (VisualDocTypes.AFS_MOUNT_ACT_1800_900.equals(getVisualtype())) {
		setIndiap(3);
	}
	setManycomplects(false);
	setOldposnumber(getPosnumber());
}
	
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	preloadRecord();

	setProcessState("");
	//request.getSession().removeAttribute("AfsMountAct2Form");
	int visualtagbase = 0;
	
	AfsMountAct2Form form2 = (AfsMountAct2Form)request.getSession().getAttribute("AfsMountAct2Form");
	boolean is900 = ((getState() == com.hps.july.inventory.APPStates.AFSEDIT22) && (form2 != null)) ||
		(getIndiap() == 2);
	if (is900)
		visualtagbase = VisualDocTypes.VISUAL_TAG_BASE;
	
	//  InDiap:    1 - 1800 only
	//                   2 - 900   only
	//                   3 - 1800/900
	if ( !is900 )
		setDiap("1800");
	else
		setDiap("900");
		
	CDBCResultSet rs = CDBCDocuments.listAllAfsMountItemParents(getDocumentId());
	ListIterator it = rs.listIterator();
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		Integer docpos = (Integer)ro.getColumn("docposition").asObject();
		Integer vid = (Integer)ro.getColumn("visualtagid").asObject();
		int visualtagid = 0;
		if (vid != null)
			visualtagid = vid.intValue() - visualtagbase;
		String docpostype = ro.getColumn("docpostype").asString();
		
		if ( 
		     ( VisualDocTypes.AFS_MOUNT_ACT_1800.equals(getVisualtype()) && isSector1800(ro) ) ||
			 ( VisualDocTypes.AFS_MOUNT_ACT_900.equals(getVisualtype()) && isSector900(ro) ) ||
		       VisualDocTypes.AFS_MOUNT_ACT_1800_900.equals(getVisualtype())
		   ) {
			
			if ( (101 == visualtagid) ||
				 (102 == visualtagid) ||
				 (103 == visualtagid)) {
				    fillAntennaA(ro, visualtagid);
				    setDiffs("1");
				}
			if ( (201 == visualtagid) ||
				 (202 == visualtagid) ||
				 (203 == visualtagid)) {
					fillAntennaB(ro, visualtagid);
					setDiffs("2");
				}
			if ( (301 == visualtagid) ||
				 (302 == visualtagid) ||
				 (303 == visualtagid)) {
					fillAntennaC(ro, visualtagid);
					setDiffs("3");
				}
			if ( (401 == visualtagid) ||
				 (402 == visualtagid) ||
				 (403 == visualtagid)) {
					fillAntennaD(ro, visualtagid);
					setDiffs("4");
				}
				
			CDBCResultSet rs2 = CDBCDocuments.listAllAfsMountItemsByParent(getDocumentId(), docpos);
			ListIterator it2 = rs2.listIterator();
			while (it2.hasNext()) {
				CDBCRowObject ro2 = (CDBCRowObject)it2.next();
				Integer vid2 = (Integer)ro2.getColumn("visualtagid").asObject();
				int visualtagid2 = 0;
				if (vid2 != null)
					visualtagid2 = vid2.intValue()- visualtagbase;
				if (501 == visualtagid2) fillCable("AA", ro2, is900);
				if (502 == visualtagid2) fillCable("AB", ro2, is900);
				if (503 == visualtagid2) fillCable("AC", ro2, is900);
	
				if (504 == visualtagid2) fillCable("BA", ro2, is900);
				if (505 == visualtagid2) fillCable("BB", ro2, is900);
				if (506 == visualtagid2) fillCable("BC", ro2, is900);
	
				if (507 == visualtagid2) fillCable("CA", ro2, is900);
				if (508 == visualtagid2) fillCable("CB", ro2, is900);
				if (509 == visualtagid2) fillCable("CC", ro2, is900);
	
				if (510 == visualtagid2) fillCable("DA", ro2, is900);
				if (511 == visualtagid2) fillCable("DB", ro2, is900);
				if (512 == visualtagid2) fillCable("DC", ro2, is900);
			}
		}
		if (601 == visualtagid) fillPosition("60", "AA", ro);
		if (602 == visualtagid) fillPosition("60", "AB", ro);
		if (603 == visualtagid) fillPosition("60", "AC", ro);
		if (604 == visualtagid) fillPosition("60", "BA", ro);
		if (605 == visualtagid) fillPosition("60", "BB", ro);
		if (606 == visualtagid) fillPosition("60", "BC", ro);
		if (607 == visualtagid) fillPosition("60", "CA", ro);
		if (608 == visualtagid) fillPosition("60", "CB", ro);
		if (609 == visualtagid) fillPosition("60", "CC", ro);
		if (610 == visualtagid) fillPosition("60", "DA", ro);
		if (611 == visualtagid) fillPosition("60", "DB", ro);
		if (612 == visualtagid) fillPosition("60", "DC", ro);

		if (701 == visualtagid) fillPosition("70", "AA", ro);
		if (702 == visualtagid) fillPosition("70", "AB", ro);
		if (703 == visualtagid) fillPosition("70", "AC", ro);
		if (704 == visualtagid) fillPosition("70", "BA", ro);
		if (705 == visualtagid) fillPosition("70", "BB", ro);
		if (706 == visualtagid) fillPosition("70", "BC", ro);
		if (707 == visualtagid) fillPosition("70", "CA", ro);
		if (708 == visualtagid) fillPosition("70", "CB", ro);
		if (709 == visualtagid) fillPosition("70", "CC", ro);
		if (710 == visualtagid) fillPosition("70", "DA", ro);
		if (711 == visualtagid) fillPosition("70", "DB", ro);
		if (712 == visualtagid) fillPosition("70", "DC", ro);

		if (801 == visualtagid) fillPosition("80", "AA", ro);
		if (802 == visualtagid) fillPosition("80", "AB", ro);
		if (803 == visualtagid) fillPosition("80", "AC", ro);
		if (804 == visualtagid) fillPosition("80", "BA", ro);
		if (805 == visualtagid) fillPosition("80", "BB", ro);
		if (806 == visualtagid) fillPosition("80", "BC", ro);
		if (807 == visualtagid) fillPosition("80", "CA", ro);
		if (808 == visualtagid) fillPosition("80", "CB", ro);
		if (809 == visualtagid) fillPosition("80", "CC", ro);
		if (810 == visualtagid) fillPosition("80", "DA", ro);
		if (811 == visualtagid) fillPosition("80", "DB", ro);
		if (812 == visualtagid) fillPosition("80", "DC", ro);

		if (901 == visualtagid) fillPosition("90", "AA", ro);
		if (902 == visualtagid) fillPosition("90", "AB", ro);
		if (903 == visualtagid) fillPosition("90", "AC", ro);
		if (904 == visualtagid) fillPosition("90", "BA", ro);
		if (905 == visualtagid) fillPosition("90", "BB", ro);
		if (906 == visualtagid) fillPosition("90", "BC", ro);
		if (907 == visualtagid) fillPosition("90", "CA", ro);
		if (908 == visualtagid) fillPosition("90", "CB", ro);
		if (909 == visualtagid) fillPosition("90", "CC", ro);
		if (910 == visualtagid) fillPosition("90", "DA", ro);
		if (911 == visualtagid) fillPosition("90", "DB", ro);
		if (912 == visualtagid) fillPosition("90", "DC", ro);

		if (1001 == visualtagid) fillPosition("100", "AA", ro);
		if (1002 == visualtagid) fillPosition("100", "AB", ro);
		if (1003 == visualtagid) fillPosition("100", "AC", ro);
		if (1004 == visualtagid) fillPosition("100", "BA", ro);
		if (1005 == visualtagid) fillPosition("100", "BB", ro);
		if (1006 == visualtagid) fillPosition("100", "BC", ro);
		if (1007 == visualtagid) fillPosition("100", "CA", ro);
		if (1008 == visualtagid) fillPosition("100", "CB", ro);
		if (1009 == visualtagid) fillPosition("100", "CC", ro);
		if (1010 == visualtagid) fillPosition("100", "DA", ro);
		if (1011 == visualtagid) fillPosition("100", "DB", ro);
		if (1012 == visualtagid) fillPosition("100", "DC", ro);

		if (1101 == visualtagid) fillPosition("110", "AA", ro);
		if (1102 == visualtagid) fillPosition("110", "AB", ro);
		if (1103 == visualtagid) fillPosition("110", "AC", ro);
		if (1104 == visualtagid) fillPosition("110", "BA", ro);
		if (1105 == visualtagid) fillPosition("110", "BB", ro);
		if (1106 == visualtagid) fillPosition("110", "BC", ro);
		if (1107 == visualtagid) fillPosition("110", "CA", ro);
		if (1108 == visualtagid) fillPosition("110", "CB", ro);
		if (1109 == visualtagid) fillPosition("110", "CC", ro);
		if (1110 == visualtagid) fillPosition("110", "DA", ro);
		if (1111 == visualtagid) fillPosition("110", "DB", ro);
		if (1112 == visualtagid) fillPosition("110", "DC", ro);

		if (1201 == visualtagid) fillPosition("120", "AA", ro);
		if (1202 == visualtagid) fillPosition("120", "AB", ro);
		if (1203 == visualtagid) fillPosition("120", "AC", ro);
		if (1204 == visualtagid) fillPosition("120", "BA", ro);
		if (1205 == visualtagid) fillPosition("120", "BB", ro);
		if (1206 == visualtagid) fillPosition("120", "BC", ro);
		if (1207 == visualtagid) fillPosition("120", "CA", ro);
		if (1208 == visualtagid) fillPosition("120", "CB", ro);
		if (1209 == visualtagid) fillPosition("120", "CC", ro);
		if (1210 == visualtagid) fillPosition("120", "DA", ro);
		if (1211 == visualtagid) fillPosition("120", "DB", ro);
		if (1212 == visualtagid) fillPosition("120", "DC", ro);
	}
}

private void callSetter(String argMethodName, Class argType, Object argValue) {
	try {
		Method serialSetter = this.getClass().getMethod( argMethodName, 
			new Class[] { argType } );
		serialSetter.invoke( this, new Object[] {argValue} );
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
}

private void fillPosition(String argIndex, String argSubIndex, CDBCRowObject ro) {
	callSetter("setResource"+argIndex, Integer.class, ro.getColumn("resource").asObject());
	callSetter("setSerial" + argIndex + argSubIndex, String.class, ro.getColumn("serialnumber").asString());
	callSetter("setQty" + argIndex + argSubIndex, String.class, ro.getColumn("qty").asString());
}

private void fillCable(String argIndex, CDBCRowObject ro, boolean is900) {
	callSetter("setResource50"+argIndex.substring(0, 1), Integer.class, ro.getColumn("resource").asObject());
	callSetter("setSerial50"+argIndex, String.class, ro.getColumn("serialnumber").asString());
	callSetter("setQty50"+argIndex, String.class, ro.getColumn("qty").asString());
	callSetter("setGndcnt"+argIndex, String.class, ro.getColumn("groundcnt").asString());
	if ( (ro.getColumn("ksvn900").asObject() != null) && (ro.getColumn("ksvn1800").asObject() != null) )
		callSetter("setComcab"+argIndex, boolean.class, new Boolean(true));
	else
		callSetter("setComcab"+argIndex, boolean.class, new Boolean(false));
	if (is900)
		callSetter("setKsvn"+argIndex, String.class, ro.getColumn("ksvn900").asString());
	else
		callSetter("setKsvn"+argIndex, String.class, ro.getColumn("ksvn1800").asString());
}

private boolean isSector1800(CDBCRowObject ro) {
	boolean result = false;
	if ("Y".equals(ro.getColumn("sectora").asString()))	result = true;
	if ("Y".equals(ro.getColumn("sectorb").asString()))	result = true;
	if ("Y".equals(ro.getColumn("sectorc").asString()))	result = true;
	if ("Y".equals(ro.getColumn("sectord").asString()))	result = true;
	if ("Y".equals(ro.getColumn("sectoro1800").asString()))	result = true;
	return result;
}

private boolean isSector900(CDBCRowObject ro) {
	boolean result = false;
	if ("Y".equals(ro.getColumn("sectore").asString()))	result = true;
	if ("Y".equals(ro.getColumn("sectorf").asString()))	result = true;
	if ("Y".equals(ro.getColumn("sectorg").asString()))	result = true;
	if ("Y".equals(ro.getColumn("sectorh").asString()))	result = true;
	if ("Y".equals(ro.getColumn("sectoro").asString()))	result = true;
	return result;
}

private String detSectorLetter(CDBCRowObject ro) {
	String result = "";
	if ("Y".equals(ro.getColumn("sectora").asString()))	result = "A";
	if ("Y".equals(ro.getColumn("sectorb").asString()))	result = "B";
	if ("Y".equals(ro.getColumn("sectorc").asString()))	result = "C";
	if ("Y".equals(ro.getColumn("sectord").asString()))	result = "D";
	if ("Y".equals(ro.getColumn("sectore").asString()))	result = "A";
	if ("Y".equals(ro.getColumn("sectorf").asString()))	result = "B";
	if ("Y".equals(ro.getColumn("sectorg").asString()))	result = "C";
	if ("Y".equals(ro.getColumn("sectorh").asString()))	result = "D";
	if ("Y".equals(ro.getColumn("sectoro1800").asString()))	result = "O";
	if ("Y".equals(ro.getColumn("sectoro").asString()))	result = "O";
	return result;
}

private void fillAntennaA(CDBCRowObject ro, int visualtagid) {
	Integer resource = (Integer)ro.getColumn("resource").asObject();
	String serial = ro.getColumn("serialnumber").asString();
	StringAndBigDecimalProperty az_ant = new StringAndBigDecimalProperty();
	az_ant.setBigDecimal((java.math.BigDecimal)ro.getColumn("az_ant").asObject());
	StringAndBigDecimalProperty h_set1 = new StringAndBigDecimalProperty();
	h_set1.setBigDecimal((java.math.BigDecimal)ro.getColumn("h_set1").asObject());
	StringAndBigDecimalProperty nakl = new StringAndBigDecimalProperty();
	nakl.setBigDecimal((java.math.BigDecimal)ro.getColumn("nakl").asObject());
	setResource10(resource);
	setAzimA(az_ant.getString());
	setHsetA(h_set1.getString());
	setNaklA(nakl.getString());
	if (101 == visualtagid)
		setSerial10A(serial);
	if (102 == visualtagid)
		setSerial10B(serial);
	if (103 == visualtagid)
		setSerial10C(serial);
		
	setSectorA(detSectorLetter(ro));
}

private void fillAntennaB(CDBCRowObject ro, int visualtagid) {
	Integer resource = (Integer)ro.getColumn("resource").asObject();
	String serial = ro.getColumn("serialnumber").asString();
	StringAndBigDecimalProperty az_ant = new StringAndBigDecimalProperty();
	az_ant.setBigDecimal((java.math.BigDecimal)ro.getColumn("az_ant").asObject());
	StringAndBigDecimalProperty h_set1 = new StringAndBigDecimalProperty();
	h_set1.setBigDecimal((java.math.BigDecimal)ro.getColumn("h_set1").asObject());
	StringAndBigDecimalProperty nakl = new StringAndBigDecimalProperty();
	nakl.setBigDecimal((java.math.BigDecimal)ro.getColumn("nakl").asObject());
	setResource20(resource);
	setAzimB(az_ant.getString());
	setHsetB(h_set1.getString());
	setNaklB(nakl.getString());
	if (201 == visualtagid)
		setSerial20A(serial);
	if (202 == visualtagid)
		setSerial20B(serial);
	if (203 == visualtagid)
		setSerial20C(serial);
		
	setSectorB(detSectorLetter(ro));
}

private void fillAntennaC(CDBCRowObject ro, int visualtagid) {
	Integer resource = (Integer)ro.getColumn("resource").asObject();
	String serial = ro.getColumn("serialnumber").asString();
	StringAndBigDecimalProperty az_ant = new StringAndBigDecimalProperty();
	az_ant.setBigDecimal((java.math.BigDecimal)ro.getColumn("az_ant").asObject());
	StringAndBigDecimalProperty h_set1 = new StringAndBigDecimalProperty();
	h_set1.setBigDecimal((java.math.BigDecimal)ro.getColumn("h_set1").asObject());
	StringAndBigDecimalProperty nakl = new StringAndBigDecimalProperty();
	nakl.setBigDecimal((java.math.BigDecimal)ro.getColumn("nakl").asObject());
	setResource30(resource);
	setAzimC(az_ant.getString());
	setHsetC(h_set1.getString());
	setNaklC(nakl.getString());
	if (301 == visualtagid)
		setSerial30A(serial);
	if (302 == visualtagid)
		setSerial30B(serial);
	if (303 == visualtagid)
		setSerial30C(serial);
		
}

private void fillAntennaD(CDBCRowObject ro, int visualtagid) {
	Integer resource = (Integer)ro.getColumn("resource").asObject();
	String serial = ro.getColumn("serialnumber").asString();
	StringAndBigDecimalProperty az_ant = new StringAndBigDecimalProperty();
	az_ant.setBigDecimal((java.math.BigDecimal)ro.getColumn("az_ant").asObject());
	StringAndBigDecimalProperty h_set1 = new StringAndBigDecimalProperty();
	h_set1.setBigDecimal((java.math.BigDecimal)ro.getColumn("h_set1").asObject());
	StringAndBigDecimalProperty nakl = new StringAndBigDecimalProperty();
	nakl.setBigDecimal((java.math.BigDecimal)ro.getColumn("nakl").asObject());
	setResource40(resource);
	setAzimD(az_ant.getString());
	setHsetD(h_set1.getString());
	setNaklD(nakl.getString());
	if (401 == visualtagid)
		setSerial40A(serial);
	if (402 == visualtagid)
		setSerial40B(serial);
	if (403 == visualtagid)
		setSerial40C(serial);
		
}

/**
 * Проверим нужно ли требовать согласование документа и есть ли проект.
 * Creation date: (15.12.2005 17:04:14)
 * @return boolean
 */

protected void checkProject(ActionErrors errors) {
	CDBCComProjectsObject cpob = new CDBCComProjectsObject();
	if (cpob.checkProject(getComplectcode())) {
		setProjectid(cpob.getProjectid());
		setProjectname(cpob.getProjectname());
		setNeedapprove(cpob.isNeedapprove());
	} else {
		setProjectid(cpob.getProjectid());
		setProjectname(cpob.getProjectname());
		setNeedapprove(cpob.isNeedapprove());
		errors.add("head", new ActionError("error.mountact2.invalid.project"));
	}
}


/**
 * ID проекта на строительство БС.
 * Creation date: (15.12.2005 16:54:28)
 * @return java.lang.Integer
 */
public java.lang.Integer getProjectid() {
	return projectid;
}

/**
 * Наименование проекта на строительство БС.
 * Creation date: (15.12.2005 16:54:54)
 * @return java.lang.String
 */
public java.lang.String getProjectname() {
	return projectname;
}

/**
 * Статус проекта на строительство БС (только чтение из БД)
 * Creation date: (15.12.2005 17:00:15)
 * @param newReadprjstatus java.lang.String
 */
public void setPrjstatus(java.lang.String newReadprjstatus) {
	readprjstatus = newReadprjstatus;
}

/**
 * Статус проекта на строительство БС (только чтение из БД)
 * @return
 */
public java.lang.String getReadprjstatus() {
	return readprjstatus;
}

/**
 * ID проекта на строительство БС
 * Creation date: (15.12.2005 16:54:28)
 * @param newProjectid java.lang.Integer
 */
public void setProjectid(java.lang.Integer newProjectid) {
	projectid = newProjectid;
}

/**
 * Наименование проекта на строительство БС
 * Creation date: (15.12.2005 16:54:54)
 * @param newProjectname java.lang.String
 */
public void setProjectname(java.lang.String newProjectname) {
	projectname = newProjectname;
}

/**
 * Документ требует согласования
 * Creation date: (15.12.2005 16:56:04)
 * @return boolean
 */
public boolean isNeedapprove() {
	return needapprove;
}

/**
 * Документ требует согласования
 * Creation date: (15.12.2005 16:56:04)
 * @param newNeedapprove boolean
 */
public void setNeedapprove(boolean newNeedapprove) {
	needapprove = newNeedapprove;
}

/**
 * Наименование статуса от проектировщиков
 * Creation date: (15.12.2005 16:56:04)
 * @param newNeedapprove boolean
 */
public String getPrjstatusname() {
	return CDBCComProjectsObject.formatProjectState(getReadprjstatus());
}


/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:32:15)
 * @return java.lang.String
 */
public java.lang.String getActdate() {
	return actdate;
}
/**
 * Текущее приложение.
 * Creation date: (15.10.2004 17:26:12)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:07:04)
 * @return java.lang.String
 */
public java.lang.String getAzimA() {
	return azimA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:07:04)
 * @return java.lang.String
 */
public java.lang.String getAzimB() {
	return azimB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:07:04)
 * @return java.lang.String
 */
public java.lang.String getAzimC() {
	return azimC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:07:04)
 * @return java.lang.String
 */
public java.lang.String getAzimD() {
	return azimD;
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getBasestationres() {
	return  new CDBCResourcesObject().findBasestationResources(
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		"*",
		Boolean.FALSE, null,
		new Integer(3));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public String getCategoryId(int i) {
	String result = ""; 
	
	switch (i) {
		case 10: {
			result = "27"; break;		
		}case 20: {
			result = "27"; break;		
		}case 30: {
			result = "27"; break;		
		}case 40: {
			result = "27"; break;		
		}case 50: {
			result = "28"; break;		
		}case 60: {
			result = "29"; break;		
		}case 80: {
			result = "31"; break;		
		}case 90: {
			result = "32"; break;		
		}case 100: {
			result = "33"; break;		
		}case 110: {
			result = "34"; break;		
		}case 120: {
			result = "35"; break;		
		}default: {
			result = "100";
		}
	}
	
	return result;
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources(Integer argCategory) {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResources(argCategory);
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources10() {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResourcesAntenna(new Integer(27), getDiap());
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources100() {
	return  getCategoryResources(new Integer(33));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources110() {
	return  getCategoryResources(new Integer(34));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources120() {
	return  getCategoryResources(new Integer(35));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources20() {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResourcesAntenna(new Integer(27), getDiap());
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources30() {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResourcesAntenna(new Integer(27), getDiap());
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources40() {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResourcesAntenna(new Integer(27), getDiap());
}
/**
 * Выдает список ресурсов типа кабель.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources50A() {
	return  getCategoryResources(new Integer(28));
}
/**
 * Выдает список ресурсов типа кабель.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources50B() {
	return  getCategoryResources(new Integer(28));
}
/**
 * Выдает список ресурсов типа кабель.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources50C() {
	return  getCategoryResources(new Integer(28));
}
/**
 * Выдает список ресурсов типа кабель.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources50D() {
	return  getCategoryResources(new Integer(28));
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources60() {
	return  getCategoryResources(new Integer(29));
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources70() {
	return  getCategoryResources(new Integer(30));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources80() {
	return  getCategoryResources(new Integer(31));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources90() {
	return  getCategoryResources(new Integer(32));
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:42:20)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectcode() {
	return complectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:42:39)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
/**
 * Выдает список комплектов оборудования с заданным номером GSM.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getComplects() {
	//System.out.println("AFS - getComplects, posnumer=" + getPosnumber());
		return new CDBCEquipmentObject().findBaseStations(
			Boolean.TRUE, null,
			CDBCEquipmentObject.TYPE_SEARCH_GSM,
			Boolean.TRUE, null,
			Boolean.TRUE,	null,
			CDBCEquipmentObject.SEARCHBY_NUMBER,
			getPosnumber(),
			Boolean.TRUE,	null,
			Boolean.TRUE,	null,
			Boolean.FALSE,	 "PMRTW",
			"PE",
			null,
			getIsAdmin(),
			getUser(),
			new Integer(CDBCEquipmentObject.ORDER_NAME_ASC)
		);
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 18:05:14)
 * @return java.lang.String
 */
public java.lang.String getDiap() {
	return diap;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 15:37:44)
 * @return java.lang.String
 */
public java.lang.String getDiffs() {
	return diffs;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 18:05:17)
 * @return int
 */
public int getDocument() {
	return document;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntAA() {
	return gndcntAA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntAB() {
	return gndcntAB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntAC() {
	return gndcntAC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntBA() {
	return gndcntBA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntBB() {
	return gndcntBB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntBC() {
	return gndcntBC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntCA() {
	return gndcntCA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntCB() {
	return gndcntCB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntCC() {
	return gndcntCC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntDA() {
	return gndcntDA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntDB() {
	return gndcntDB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @return java.lang.String
 */
public java.lang.String getGndcntDC() {
	return gndcntDC;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 14:44:55)
 * @return java.lang.String
 */
public java.lang.String getHsetA() {
	return hsetA;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 14:44:55)
 * @return java.lang.String
 */
public java.lang.String getHsetB() {
	return hsetB;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 14:44:55)
 * @return java.lang.String
 */
public java.lang.String getHsetC() {
	return hsetC;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 14:44:55)
 * @return java.lang.String
 */
public java.lang.String getHsetD() {
	return hsetD;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 17:08:44)
 * @return int
 */
public int getIndiap() {
	return indiap;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:33:36)
 * @return java.lang.String
 */
public java.lang.String getInsuranceMan() {
	return insuranceMan;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 12:33:18)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAdmin() {
	return isAdmin;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnAA() {
	return ksvnAA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnAB() {
	return ksvnAB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnAC() {
	return ksvnAC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnBA() {
	return ksvnBA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnBB() {
	return ksvnBB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnBC() {
	return ksvnBC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnCA() {
	return ksvnCA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnCB() {
	return ksvnCB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnCC() {
	return ksvnCC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnDA() {
	return ksvnDA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnDB() {
	return ksvnDB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @return java.lang.String
 */
public java.lang.String getKsvnDC() {
	return ksvnDC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:06:53)
 * @return java.lang.String
 */
public java.lang.String getNaklA() {
	return naklA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:06:53)
 * @return java.lang.String
 */
public java.lang.String getNaklB() {
	return naklB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:06:53)
 * @return java.lang.String
 */
public java.lang.String getNaklC() {
	return naklC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:06:53)
 * @return java.lang.String
 */
public java.lang.String getNaklD() {
	return naklD;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 20:41:33)
 * @return java.lang.String
 */
public java.lang.String getOldposnumber() {
	return oldposnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:47:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return ownercode;
}
/**
 * Список возможных владельцев.
 * Creation date: (19.06.2002 11:40:25)
 * @return java.util.Enumeration
 */
public Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:34:21)
 * @return java.lang.String
 */
public java.lang.String getPosnumber() {
	return posnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:32:55)
 * @return java.lang.String
 */
public java.lang.String getProvidercode() {
	return providercode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:33:12)
 * @return java.lang.String
 */
public java.lang.String getProvidername() {
	return providername;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100AA() {
	return qty100AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100AB() {
	return qty100AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100AC() {
	return qty100AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100BA() {
	return qty100BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100BB() {
	return qty100BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100BC() {
	return qty100BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100CA() {
	return qty100CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100CB() {
	return qty100CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100CC() {
	return qty100CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100DA() {
	return qty100DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100DB() {
	return qty100DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @return java.lang.String
 */
public java.lang.String getQty100DC() {
	return qty100DC;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:22)
 * @return java.lang.String
 */
public java.lang.String getQty10A() {
	return qty10A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:22)
 * @return java.lang.String
 */
public java.lang.String getQty10B() {
	return qty10B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:22)
 * @return java.lang.String
 */
public java.lang.String getQty10C() {
	return qty10C;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110AA() {
	return qty110AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110AB() {
	return qty110AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110AC() {
	return qty110AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110BA() {
	return qty110BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110BB() {
	return qty110BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110BC() {
	return qty110BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110CA() {
	return qty110CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110CB() {
	return qty110CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110CC() {
	return qty110CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110DA() {
	return qty110DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110DB() {
	return qty110DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty110DC() {
	return qty110DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120AA() {
	return qty120AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120AB() {
	return qty120AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120AC() {
	return qty120AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120BA() {
	return qty120BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120BB() {
	return qty120BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120BC() {
	return qty120BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120CA() {
	return qty120CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120CB() {
	return qty120CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120CC() {
	return qty120CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120DA() {
	return qty120DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120DB() {
	return qty120DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @return java.lang.String
 */
public java.lang.String getQty120DC() {
	return qty120DC;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @return java.lang.String
 */
public java.lang.String getQty20A() {
	return qty20A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @return java.lang.String
 */
public java.lang.String getQty20B() {
	return qty20B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @return java.lang.String
 */
public java.lang.String getQty20C() {
	return qty20C;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @return java.lang.String
 */
public java.lang.String getQty30A() {
	return qty30A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @return java.lang.String
 */
public java.lang.String getQty30B() {
	return qty30B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @return java.lang.String
 */
public java.lang.String getQty30C() {
	return qty30C;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @return java.lang.String
 */
public java.lang.String getQty40A() {
	return qty40A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @return java.lang.String
 */
public java.lang.String getQty40B() {
	return qty40B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @return java.lang.String
 */
public java.lang.String getQty40C() {
	return qty40C;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50AA() {
	return qty50AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50AB() {
	return qty50AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50AC() {
	return qty50AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50BA() {
	return qty50BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50BB() {
	return qty50BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50BC() {
	return qty50BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50CA() {
	return qty50CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50CB() {
	return qty50CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50CC() {
	return qty50CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50DA() {
	return qty50DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50DB() {
	return qty50DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty50DC() {
	return qty50DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60AA() {
	return qty60AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60AB() {
	return qty60AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60AC() {
	return qty60AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60BA() {
	return qty60BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60BB() {
	return qty60BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60BC() {
	return qty60BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60CA() {
	return qty60CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60CB() {
	return qty60CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60CC() {
	return qty60CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60DA() {
	return qty60DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60DB() {
	return qty60DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty60DC() {
	return qty60DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty70AA() {
	return qty70AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty70AB() {
	return qty70AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @return java.lang.String
 */
public java.lang.String getQty70AC() {
	return qty70AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty70BA() {
	return qty70BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty70BB() {
	return qty70BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty70BC() {
	return qty70BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty70CA() {
	return qty70CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty70CB() {
	return qty70CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty70CC() {
	return qty70CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty70DA() {
	return qty70DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty70DB() {
	return qty70DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty70DC() {
	return qty70DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80AA() {
	return qty80AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80AB() {
	return qty80AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80AC() {
	return qty80AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80BA() {
	return qty80BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80BB() {
	return qty80BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80BC() {
	return qty80BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80CA() {
	return qty80CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80CB() {
	return qty80CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80CC() {
	return qty80CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80DA() {
	return qty80DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80DB() {
	return qty80DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty80DC() {
	return qty80DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90AA() {
	return qty90AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90AB() {
	return qty90AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90AC() {
	return qty90AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90BA() {
	return qty90BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90BB() {
	return qty90BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90BC() {
	return qty90BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90CA() {
	return qty90CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90CB() {
	return qty90CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90CC() {
	return qty90CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90DA() {
	return qty90DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90DB() {
	return qty90DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @return java.lang.String
 */
public java.lang.String getQty90DC() {
	return qty90DC;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 14:37:37)
 * @return int
 */
public int getRefreshFields() {
	return refreshFields;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource10() {
	return resource10;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource100() {
	return resource100;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource110() {
	return resource110;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 11:50:53)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource120() {
	return resource120;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource20() {
	return resource20;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource30() {
	return resource30;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2004 00:15:11)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource40() {
	return resource40;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2004 15:31:14)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource50A() {
	return resource50A;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2004 15:31:14)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource50B() {
	return resource50B;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2004 15:31:14)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource50C() {
	return resource50C;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2004 15:31:14)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource50D() {
	return resource50D;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2004 00:15:39)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource60() {
	return resource60;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2004 00:15:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource70() {
	return resource70;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource80() {
	return resource80;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource90() {
	return resource90;
}
/**
 * Insert the method's description here.
 * Creation date: (28.12.2004 14:44:51)
 * @return java.lang.String
 */
public java.lang.String getSectorA() {
	return sectorA;
}
/**
 * Insert the method's description here.
 * Creation date: (28.12.2004 14:45:10)
 * @return java.lang.String
 */
public java.lang.String getSectorB() {
	return sectorB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100AA() {
	return serial100AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100AB() {
	return serial100AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100AC() {
	return serial100AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100BA() {
	return serial100BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100BB() {
	return serial100BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100BC() {
	return serial100BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100CA() {
	return serial100CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100CB() {
	return serial100CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100CC() {
	return serial100CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100DA() {
	return serial100DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100DB() {
	return serial100DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @return java.lang.String
 */
public java.lang.String getSerial100DC() {
	return serial100DC;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:12)
 * @return java.lang.String
 */
public java.lang.String getSerial10A() {
	return serial10A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:12)
 * @return java.lang.String
 */
public java.lang.String getSerial10B() {
	return serial10B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:12)
 * @return java.lang.String
 */
public java.lang.String getSerial10C() {
	return serial10C;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110AA() {
	return serial110AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110AB() {
	return serial110AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110AC() {
	return serial110AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110BA() {
	return serial110BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110BB() {
	return serial110BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110BC() {
	return serial110BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110CA() {
	return serial110CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110CB() {
	return serial110CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110CC() {
	return serial110CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110DA() {
	return serial110DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110DB() {
	return serial110DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial110DC() {
	return serial110DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120AA() {
	return serial120AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120AB() {
	return serial120AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120AC() {
	return serial120AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120BA() {
	return serial120BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120BB() {
	return serial120BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120BC() {
	return serial120BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120CA() {
	return serial120CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120CB() {
	return serial120CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120CC() {
	return serial120CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120DA() {
	return serial120DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120DB() {
	return serial120DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @return java.lang.String
 */
public java.lang.String getSerial120DC() {
	return serial120DC;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @return java.lang.String
 */
public java.lang.String getSerial20A() {
	return serial20A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @return java.lang.String
 */
public java.lang.String getSerial20B() {
	return serial20B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @return java.lang.String
 */
public java.lang.String getSerial20C() {
	return serial20C;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @return java.lang.String
 */
public java.lang.String getSerial30A() {
	return serial30A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @return java.lang.String
 */
public java.lang.String getSerial30B() {
	return serial30B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @return java.lang.String
 */
public java.lang.String getSerial30C() {
	return serial30C;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @return java.lang.String
 */
public java.lang.String getSerial40A() {
	return serial40A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @return java.lang.String
 */
public java.lang.String getSerial40B() {
	return serial40B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @return java.lang.String
 */
public java.lang.String getSerial40C() {
	return serial40C;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50AA() {
	return serial50AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50AB() {
	return serial50AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50AC() {
	return serial50AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50BA() {
	return serial50BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50BB() {
	return serial50BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50BC() {
	return serial50BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50CA() {
	return serial50CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50CB() {
	return serial50CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50CC() {
	return serial50CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50DA() {
	return serial50DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50DB() {
	return serial50DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @return java.lang.String
 */
public java.lang.String getSerial50DC() {
	return serial50DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60AA() {
	return serial60AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60AB() {
	return serial60AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60AC() {
	return serial60AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60BA() {
	return serial60BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60BB() {
	return serial60BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60BC() {
	return serial60BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60CA() {
	return serial60CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60CB() {
	return serial60CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60CC() {
	return serial60CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60DA() {
	return serial60DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60DB() {
	return serial60DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial60DC() {
	return serial60DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70AA() {
	return serial70AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70AB() {
	return serial70AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70AC() {
	return serial70AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70BA() {
	return serial70BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70BB() {
	return serial70BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70BC() {
	return serial70BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70CA() {
	return serial70CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70CB() {
	return serial70CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70CC() {
	return serial70CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70DA() {
	return serial70DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70DB() {
	return serial70DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial70DC() {
	return serial70DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80AA() {
	return serial80AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80AB() {
	return serial80AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80AC() {
	return serial80AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80BA() {
	return serial80BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80BB() {
	return serial80BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80BC() {
	return serial80BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80CA() {
	return serial80CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80CB() {
	return serial80CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80CC() {
	return serial80CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80DA() {
	return serial80DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80DB() {
	return serial80DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial80DC() {
	return serial80DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90AA() {
	return serial90AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90AB() {
	return serial90AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90AC() {
	return serial90AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90BA() {
	return serial90BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90BB() {
	return serial90BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90BC() {
	return serial90BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90CA() {
	return serial90CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90CB() {
	return serial90CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90CC() {
	return serial90CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90DA() {
	return serial90DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90DB() {
	return serial90DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @return java.lang.String
 */
public java.lang.String getSerial90DC() {
	return serial90DC;
}
/**
 * Текущее состояние приложения.
 * Creation date: (15.10.2004 17:26:12)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.AFSEDIT21;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 18:20:28)
 * @return java.lang.String
 */
public java.lang.String getUser() {
	return user;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:09)
 * @return java.lang.String
 */
public java.lang.String getWorkercode() {
	return workercode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:29)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:52)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	if (isNewform())
		request.getSession().removeAttribute("AfsMountAct2Form");
	setManycomplects(false);
	setComplectcode(null);
	setOldposnumber("");
	setSectorA("A");
	setSectorB("B");
	int defOwner = com.hps.july.util.AppUtils.getNamedValueInt("INVENTORY_DEFOWNER");
	if (defOwner != 0)
		setOwnercode(new Integer(defOwner));
	//  InDiap:    1 - 1800 only
	//                   2 - 900   only
	//                   3 - 1800/900
	if ( (getIndiap() == 1) || (getIndiap() == 3) )
		setDiap("1800");
	else
		setDiap("900");
}
/**
 * Проверяет есть ли хоть один общий кабель.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isAnyComcab() {
	return isComcabAA() || isComcabAB() || isComcabAC() || isComcabBA() || isComcabBB() || isComcabBC() || 
		isComcabCA() || isComcabCB() || isComcabCC() || isComcabDA() || isComcabDB() || isComcabDC();
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabAA() {
	return comcabAA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabAB() {
	return comcabAB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabAC() {
	return comcabAC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabBA() {
	return comcabBA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabBB() {
	return comcabBB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabBC() {
	return comcabBC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabCA() {
	return comcabCA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabCB() {
	return comcabCB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabCC() {
	return comcabCC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabDA() {
	return comcabDA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabDB() {
	return comcabDB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @return boolean
 */
public boolean isComcabDC() {
	return comcabDC;
}
/**
 * Проверяет, является ли антенна антенной с кросс-поляризацией.
 * Creation date: (19.10.2004 20:08:46)
 * @return boolean
 */
public boolean isCrossAntenn(int argResource) {
	try {
			AntennaResourceAccessBean aab = new AntennaResourceAccessBean();
			aab.setInitKey_resource(argResource);
			aab.refreshCopyHelper();
			return "C".equals(aab.getPolarization());
    } catch (Exception e) {
	    e.printStackTrace(System.out);
	}
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 20:08:46)
 * @return boolean
 */
public boolean isManycomplects() {
	return manycomplects;
}
/**
 * Insert the method's description here.
 * Creation date: (12.01.2005 15:12:55)
 * @return boolean
 */
public boolean isNewform() {
	return newform;
}
/**
 * Проверяет, является ли антенна двухдиапазонной.
 * Creation date: (19.10.2004 20:08:46)
 * @return boolean
 */
public boolean isTwoDiapAntenn(int argResource) {
	int ndiaps = 0;
	try {
			AntennaResourceBandAccessBeanTable table = new AntennaResourceBandAccessBeanTable();
			table.setAntennaResourceBandAccessBean(
				new AntennaResourceBandAccessBean().findAntennaResourceBandsByResource(
					new ResourceKey(argResource)));
			for (int i = 0; i < table.numberOfRows(); i++) {
				if (table.getAntennaResourceBandAccessBean(i).getBand() == 1800)
					ndiaps++; 
				if (table.getAntennaResourceBandAccessBean(i).getBand() == 900)
					ndiaps++; 
	        }
    } catch (Exception e) {
	    e.printStackTrace(System.out);
	}
	return ndiaps > 1;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:32:15)
 * @param newActdate java.lang.String
 */
public void setActdate(java.lang.String newActdate) {
	actdate = newActdate;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:07:04)
 * @param newAzimA java.lang.String
 */
public void setAzimA(java.lang.String newAzimA) {
	azimA = newAzimA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:07:04)
 * @param newAzimB java.lang.String
 */
public void setAzimB(java.lang.String newAzimB) {
	azimB = newAzimB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:07:04)
 * @param newAzimC java.lang.String
 */
public void setAzimC(java.lang.String newAzimC) {
	azimC = newAzimC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:07:04)
 * @param newAzimD java.lang.String
 */
public void setAzimD(java.lang.String newAzimD) {
	azimD = newAzimD;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabAA boolean
 */
public void setComcabAA(boolean newComcabAA) {
	comcabAA = newComcabAA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabAB boolean
 */
public void setComcabAB(boolean newComcabAB) {
	comcabAB = newComcabAB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabAC boolean
 */
public void setComcabAC(boolean newComcabAC) {
	comcabAC = newComcabAC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabBA boolean
 */
public void setComcabBA(boolean newComcabBA) {
	comcabBA = newComcabBA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabBB boolean
 */
public void setComcabBB(boolean newComcabBB) {
	comcabBB = newComcabBB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabBC boolean
 */
public void setComcabBC(boolean newComcabBC) {
	comcabBC = newComcabBC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabCA boolean
 */
public void setComcabCA(boolean newComcabCA) {
	comcabCA = newComcabCA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabCB boolean
 */
public void setComcabCB(boolean newComcabCB) {
	comcabCB = newComcabCB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabCC boolean
 */
public void setComcabCC(boolean newComcabCC) {
	comcabCC = newComcabCC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabDA boolean
 */
public void setComcabDA(boolean newComcabDA) {
	comcabDA = newComcabDA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabDB boolean
 */
public void setComcabDB(boolean newComcabDB) {
	comcabDB = newComcabDB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 10:54:26)
 * @param newComcabDC boolean
 */
public void setComcabDC(boolean newComcabDC) {
	comcabDC = newComcabDC;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:42:20)
 * @param newComplectcode java.lang.Integer
 */
public void setComplectcode(java.lang.Integer newComplectcode) {
	complectcode = newComplectcode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:42:39)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 18:05:14)
 * @param newDiap java.lang.String
 */
public void setDiap(java.lang.String newDiap) {
	diap = newDiap;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 15:37:44)
 * @param newDiffs java.lang.String
 */
public void setDiffs(java.lang.String newDiffs) {
	diffs = newDiffs;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 18:05:17)
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntAA java.lang.String
 */
public void setGndcntAA(java.lang.String newGndcntAA) {
	gndcntAA = newGndcntAA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntAB java.lang.String
 */
public void setGndcntAB(java.lang.String newGndcntAB) {
	gndcntAB = newGndcntAB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntAC java.lang.String
 */
public void setGndcntAC(java.lang.String newGndcntAC) {
	gndcntAC = newGndcntAC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntBA java.lang.String
 */
public void setGndcntBA(java.lang.String newGndcntBA) {
	gndcntBA = newGndcntBA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntBB java.lang.String
 */
public void setGndcntBB(java.lang.String newGndcntBB) {
	gndcntBB = newGndcntBB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntBC java.lang.String
 */
public void setGndcntBC(java.lang.String newGndcntBC) {
	gndcntBC = newGndcntBC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntCA java.lang.String
 */
public void setGndcntCA(java.lang.String newGndcntCA) {
	gndcntCA = newGndcntCA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntCB java.lang.String
 */
public void setGndcntCB(java.lang.String newGndcntCB) {
	gndcntCB = newGndcntCB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntCC java.lang.String
 */
public void setGndcntCC(java.lang.String newGndcntCC) {
	gndcntCC = newGndcntCC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntDA java.lang.String
 */
public void setGndcntDA(java.lang.String newGndcntDA) {
	gndcntDA = newGndcntDA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntDB java.lang.String
 */
public void setGndcntDB(java.lang.String newGndcntDB) {
	gndcntDB = newGndcntDB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:03:16)
 * @param newGndcntDC java.lang.String
 */
public void setGndcntDC(java.lang.String newGndcntDC) {
	gndcntDC = newGndcntDC;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 14:44:55)
 * @param newHsetA java.lang.String
 */
public void setHsetA(java.lang.String newHsetA) {
	hsetA = newHsetA;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 14:44:55)
 * @param newHsetB java.lang.String
 */
public void setHsetB(java.lang.String newHsetB) {
	hsetB = newHsetB;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 14:44:55)
 * @param newHsetC java.lang.String
 */
public void setHsetC(java.lang.String newHsetC) {
	hsetC = newHsetC;
}
/**
 * Insert the method's description here.
 * Creation date: (07.04.2005 14:44:55)
 * @param newHsetD java.lang.String
 */
public void setHsetD(java.lang.String newHsetD) {
	hsetD = newHsetD;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 17:08:44)
 * @param newIndiap int
 */
public void setIndiap(int newIndiap) {
	indiap = newIndiap;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:33:36)
 * @param newInsuranceMan java.lang.String
 */
public void setInsuranceMan(java.lang.String newInsuranceMan) {
	insuranceMan = newInsuranceMan;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 12:33:18)
 * @param newIsAdmin java.lang.Boolean
 */
public void setIsAdmin(java.lang.Boolean newIsAdmin) {
	isAdmin = newIsAdmin;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnAA java.lang.String
 */
public void setKsvnAA(java.lang.String newKsvnAA) {
	ksvnAA = newKsvnAA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnAB java.lang.String
 */
public void setKsvnAB(java.lang.String newKsvnAB) {
	ksvnAB = newKsvnAB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnAC java.lang.String
 */
public void setKsvnAC(java.lang.String newKsvnAC) {
	ksvnAC = newKsvnAC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnBA java.lang.String
 */
public void setKsvnBA(java.lang.String newKsvnBA) {
	ksvnBA = newKsvnBA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnBB java.lang.String
 */
public void setKsvnBB(java.lang.String newKsvnBB) {
	ksvnBB = newKsvnBB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnBC java.lang.String
 */
public void setKsvnBC(java.lang.String newKsvnBC) {
	ksvnBC = newKsvnBC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnCA java.lang.String
 */
public void setKsvnCA(java.lang.String newKsvnCA) {
	ksvnCA = newKsvnCA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnCB java.lang.String
 */
public void setKsvnCB(java.lang.String newKsvnCB) {
	ksvnCB = newKsvnCB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnCC java.lang.String
 */
public void setKsvnCC(java.lang.String newKsvnCC) {
	ksvnCC = newKsvnCC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnDA java.lang.String
 */
public void setKsvnDA(java.lang.String newKsvnDA) {
	ksvnDA = newKsvnDA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnDB java.lang.String
 */
public void setKsvnDB(java.lang.String newKsvnDB) {
	ksvnDB = newKsvnDB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 16:07:57)
 * @param newKsvnDC java.lang.String
 */
public void setKsvnDC(java.lang.String newKsvnDC) {
	ksvnDC = newKsvnDC;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 20:08:46)
 * @param newManycomplects boolean
 */
public void setManycomplects(boolean newManycomplects) {
	manycomplects = newManycomplects;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:06:53)
 * @param newNaklA java.lang.String
 */
public void setNaklA(java.lang.String newNaklA) {
	naklA = newNaklA;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:06:53)
 * @param newNaklB java.lang.String
 */
public void setNaklB(java.lang.String newNaklB) {
	naklB = newNaklB;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:06:53)
 * @param newNaklC java.lang.String
 */
public void setNaklC(java.lang.String newNaklC) {
	naklC = newNaklC;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2004 11:06:53)
 * @param newNaklD java.lang.String
 */
public void setNaklD(java.lang.String newNaklD) {
	naklD = newNaklD;
}
/**
 * Insert the method's description here.
 * Creation date: (12.01.2005 15:12:55)
 * @param newNewform boolean
 */
public void setNewform(boolean newNewform) {
	newform = newNewform;
}
/**
 * Insert the method's description here.
 * Creation date: (19.10.2004 20:41:33)
 * @param newOldposnumber java.lang.String
 */
public void setOldposnumber(java.lang.String newOldposnumber) {
	oldposnumber = newOldposnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:47:06)
 * @param newOwnercode java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwnercode) {
	ownercode = newOwnercode;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:34:21)
 * @param newPosnumber java.lang.String
 */
public void setPosnumber(java.lang.String newPosnumber) {
	posnumber = newPosnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:32:55)
 * @param newProvidercode java.lang.String
 */
public void setProvidercode(java.lang.String newProvidercode) {
	providercode = newProvidercode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:33:12)
 * @param newProvidername java.lang.String
 */
public void setProvidername(java.lang.String newProvidername) {
	providername = newProvidername;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100AA java.lang.String
 */
public void setQty100AA(java.lang.String newQty100AA) {
	qty100AA = newQty100AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100AB java.lang.String
 */
public void setQty100AB(java.lang.String newQty100AB) {
	qty100AB = newQty100AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100AC java.lang.String
 */
public void setQty100AC(java.lang.String newQty100AC) {
	qty100AC = newQty100AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100BA java.lang.String
 */
public void setQty100BA(java.lang.String newQty100BA) {
	qty100BA = newQty100BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100BB java.lang.String
 */
public void setQty100BB(java.lang.String newQty100BB) {
	qty100BB = newQty100BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100BC java.lang.String
 */
public void setQty100BC(java.lang.String newQty100BC) {
	qty100BC = newQty100BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100CA java.lang.String
 */
public void setQty100CA(java.lang.String newQty100CA) {
	qty100CA = newQty100CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100CB java.lang.String
 */
public void setQty100CB(java.lang.String newQty100CB) {
	qty100CB = newQty100CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100CC java.lang.String
 */
public void setQty100CC(java.lang.String newQty100CC) {
	qty100CC = newQty100CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100DA java.lang.String
 */
public void setQty100DA(java.lang.String newQty100DA) {
	qty100DA = newQty100DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100DB java.lang.String
 */
public void setQty100DB(java.lang.String newQty100DB) {
	qty100DB = newQty100DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:27)
 * @param newQty100DC java.lang.String
 */
public void setQty100DC(java.lang.String newQty100DC) {
	qty100DC = newQty100DC;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:22)
 * @param newQty10A java.lang.String
 */
public void setQty10A(java.lang.String newQty10A) {
	qty10A = newQty10A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:22)
 * @param newQty10B java.lang.String
 */
public void setQty10B(java.lang.String newQty10B) {
	qty10B = newQty10B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:22)
 * @param newQty10C java.lang.String
 */
public void setQty10C(java.lang.String newQty10C) {
	qty10C = newQty10C;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110AA java.lang.String
 */
public void setQty110AA(java.lang.String newQty110AA) {
	qty110AA = newQty110AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110AB java.lang.String
 */
public void setQty110AB(java.lang.String newQty110AB) {
	qty110AB = newQty110AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110AC java.lang.String
 */
public void setQty110AC(java.lang.String newQty110AC) {
	qty110AC = newQty110AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110BA java.lang.String
 */
public void setQty110BA(java.lang.String newQty110BA) {
	qty110BA = newQty110BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110BB java.lang.String
 */
public void setQty110BB(java.lang.String newQty110BB) {
	qty110BB = newQty110BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110BC java.lang.String
 */
public void setQty110BC(java.lang.String newQty110BC) {
	qty110BC = newQty110BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110CA java.lang.String
 */
public void setQty110CA(java.lang.String newQty110CA) {
	qty110CA = newQty110CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110CB java.lang.String
 */
public void setQty110CB(java.lang.String newQty110CB) {
	qty110CB = newQty110CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110CC java.lang.String
 */
public void setQty110CC(java.lang.String newQty110CC) {
	qty110CC = newQty110CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110DA java.lang.String
 */
public void setQty110DA(java.lang.String newQty110DA) {
	qty110DA = newQty110DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110DB java.lang.String
 */
public void setQty110DB(java.lang.String newQty110DB) {
	qty110DB = newQty110DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty110DC java.lang.String
 */
public void setQty110DC(java.lang.String newQty110DC) {
	qty110DC = newQty110DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120AA java.lang.String
 */
public void setQty120AA(java.lang.String newQty120AA) {
	qty120AA = newQty120AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120AB java.lang.String
 */
public void setQty120AB(java.lang.String newQty120AB) {
	qty120AB = newQty120AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120AC java.lang.String
 */
public void setQty120AC(java.lang.String newQty120AC) {
	qty120AC = newQty120AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120BA java.lang.String
 */
public void setQty120BA(java.lang.String newQty120BA) {
	qty120BA = newQty120BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120BB java.lang.String
 */
public void setQty120BB(java.lang.String newQty120BB) {
	qty120BB = newQty120BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120BC java.lang.String
 */
public void setQty120BC(java.lang.String newQty120BC) {
	qty120BC = newQty120BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120CA java.lang.String
 */
public void setQty120CA(java.lang.String newQty120CA) {
	qty120CA = newQty120CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120CB java.lang.String
 */
public void setQty120CB(java.lang.String newQty120CB) {
	qty120CB = newQty120CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120CC java.lang.String
 */
public void setQty120CC(java.lang.String newQty120CC) {
	qty120CC = newQty120CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120DA java.lang.String
 */
public void setQty120DA(java.lang.String newQty120DA) {
	qty120DA = newQty120DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120DB java.lang.String
 */
public void setQty120DB(java.lang.String newQty120DB) {
	qty120DB = newQty120DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:02:02)
 * @param newQty120DC java.lang.String
 */
public void setQty120DC(java.lang.String newQty120DC) {
	qty120DC = newQty120DC;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @param newQty20A java.lang.String
 */
public void setQty20A(java.lang.String newQty20A) {
	qty20A = newQty20A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @param newQty20B java.lang.String
 */
public void setQty20B(java.lang.String newQty20B) {
	qty20B = newQty20B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @param newQty20C java.lang.String
 */
public void setQty20C(java.lang.String newQty20C) {
	qty20C = newQty20C;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @param newQty30A java.lang.String
 */
public void setQty30A(java.lang.String newQty30A) {
	qty30A = newQty30A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @param newQty30B java.lang.String
 */
public void setQty30B(java.lang.String newQty30B) {
	qty30B = newQty30B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @param newQty30C java.lang.String
 */
public void setQty30C(java.lang.String newQty30C) {
	qty30C = newQty30C;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @param newQty40A java.lang.String
 */
public void setQty40A(java.lang.String newQty40A) {
	qty40A = newQty40A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @param newQty40B java.lang.String
 */
public void setQty40B(java.lang.String newQty40B) {
	qty40B = newQty40B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:08:46)
 * @param newQty40C java.lang.String
 */
public void setQty40C(java.lang.String newQty40C) {
	qty40C = newQty40C;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50AA java.lang.String
 */
public void setQty50AA(java.lang.String newQty50AA) {
	qty50AA = newQty50AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50AB java.lang.String
 */
public void setQty50AB(java.lang.String newQty50AB) {
	qty50AB = newQty50AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50AC java.lang.String
 */
public void setQty50AC(java.lang.String newQty50AC) {
	qty50AC = newQty50AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50BA java.lang.String
 */
public void setQty50BA(java.lang.String newQty50BA) {
	qty50BA = newQty50BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50BB java.lang.String
 */
public void setQty50BB(java.lang.String newQty50BB) {
	qty50BB = newQty50BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50BC java.lang.String
 */
public void setQty50BC(java.lang.String newQty50BC) {
	qty50BC = newQty50BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50CA java.lang.String
 */
public void setQty50CA(java.lang.String newQty50CA) {
	qty50CA = newQty50CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50CB java.lang.String
 */
public void setQty50CB(java.lang.String newQty50CB) {
	qty50CB = newQty50CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50CC java.lang.String
 */
public void setQty50CC(java.lang.String newQty50CC) {
	qty50CC = newQty50CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50DA java.lang.String
 */
public void setQty50DA(java.lang.String newQty50DA) {
	qty50DA = newQty50DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50DB java.lang.String
 */
public void setQty50DB(java.lang.String newQty50DB) {
	qty50DB = newQty50DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty50DC java.lang.String
 */
public void setQty50DC(java.lang.String newQty50DC) {
	qty50DC = newQty50DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60AA java.lang.String
 */
public void setQty60AA(java.lang.String newQty60AA) {
	qty60AA = newQty60AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60AB java.lang.String
 */
public void setQty60AB(java.lang.String newQty60AB) {
	qty60AB = newQty60AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60AC java.lang.String
 */
public void setQty60AC(java.lang.String newQty60AC) {
	qty60AC = newQty60AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60BA java.lang.String
 */
public void setQty60BA(java.lang.String newQty60BA) {
	qty60BA = newQty60BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60BB java.lang.String
 */
public void setQty60BB(java.lang.String newQty60BB) {
	qty60BB = newQty60BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60BC java.lang.String
 */
public void setQty60BC(java.lang.String newQty60BC) {
	qty60BC = newQty60BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60CA java.lang.String
 */
public void setQty60CA(java.lang.String newQty60CA) {
	qty60CA = newQty60CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60CB java.lang.String
 */
public void setQty60CB(java.lang.String newQty60CB) {
	qty60CB = newQty60CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60CC java.lang.String
 */
public void setQty60CC(java.lang.String newQty60CC) {
	qty60CC = newQty60CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60DA java.lang.String
 */
public void setQty60DA(java.lang.String newQty60DA) {
	qty60DA = newQty60DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60DB java.lang.String
 */
public void setQty60DB(java.lang.String newQty60DB) {
	qty60DB = newQty60DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty60DC java.lang.String
 */
public void setQty60DC(java.lang.String newQty60DC) {
	qty60DC = newQty60DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty70AA java.lang.String
 */
public void setQty70AA(java.lang.String newQty70AA) {
	qty70AA = newQty70AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty70AB java.lang.String
 */
public void setQty70AB(java.lang.String newQty70AB) {
	qty70AB = newQty70AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:08)
 * @param newQty70AC java.lang.String
 */
public void setQty70AC(java.lang.String newQty70AC) {
	qty70AC = newQty70AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty70BA java.lang.String
 */
public void setQty70BA(java.lang.String newQty70BA) {
	qty70BA = newQty70BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty70BB java.lang.String
 */
public void setQty70BB(java.lang.String newQty70BB) {
	qty70BB = newQty70BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty70BC java.lang.String
 */
public void setQty70BC(java.lang.String newQty70BC) {
	qty70BC = newQty70BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty70CA java.lang.String
 */
public void setQty70CA(java.lang.String newQty70CA) {
	qty70CA = newQty70CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty70CB java.lang.String
 */
public void setQty70CB(java.lang.String newQty70CB) {
	qty70CB = newQty70CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty70CC java.lang.String
 */
public void setQty70CC(java.lang.String newQty70CC) {
	qty70CC = newQty70CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty70DA java.lang.String
 */
public void setQty70DA(java.lang.String newQty70DA) {
	qty70DA = newQty70DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty70DB java.lang.String
 */
public void setQty70DB(java.lang.String newQty70DB) {
	qty70DB = newQty70DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty70DC java.lang.String
 */
public void setQty70DC(java.lang.String newQty70DC) {
	qty70DC = newQty70DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80AA java.lang.String
 */
public void setQty80AA(java.lang.String newQty80AA) {
	qty80AA = newQty80AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80AB java.lang.String
 */
public void setQty80AB(java.lang.String newQty80AB) {
	qty80AB = newQty80AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80AC java.lang.String
 */
public void setQty80AC(java.lang.String newQty80AC) {
	qty80AC = newQty80AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80BA java.lang.String
 */
public void setQty80BA(java.lang.String newQty80BA) {
	qty80BA = newQty80BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80BB java.lang.String
 */
public void setQty80BB(java.lang.String newQty80BB) {
	qty80BB = newQty80BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80BC java.lang.String
 */
public void setQty80BC(java.lang.String newQty80BC) {
	qty80BC = newQty80BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80CA java.lang.String
 */
public void setQty80CA(java.lang.String newQty80CA) {
	qty80CA = newQty80CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80CB java.lang.String
 */
public void setQty80CB(java.lang.String newQty80CB) {
	qty80CB = newQty80CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80CC java.lang.String
 */
public void setQty80CC(java.lang.String newQty80CC) {
	qty80CC = newQty80CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80DA java.lang.String
 */
public void setQty80DA(java.lang.String newQty80DA) {
	qty80DA = newQty80DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80DB java.lang.String
 */
public void setQty80DB(java.lang.String newQty80DB) {
	qty80DB = newQty80DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty80DC java.lang.String
 */
public void setQty80DC(java.lang.String newQty80DC) {
	qty80DC = newQty80DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90AA java.lang.String
 */
public void setQty90AA(java.lang.String newQty90AA) {
	qty90AA = newQty90AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90AB java.lang.String
 */
public void setQty90AB(java.lang.String newQty90AB) {
	qty90AB = newQty90AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90AC java.lang.String
 */
public void setQty90AC(java.lang.String newQty90AC) {
	qty90AC = newQty90AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90BA java.lang.String
 */
public void setQty90BA(java.lang.String newQty90BA) {
	qty90BA = newQty90BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90BB java.lang.String
 */
public void setQty90BB(java.lang.String newQty90BB) {
	qty90BB = newQty90BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90BC java.lang.String
 */
public void setQty90BC(java.lang.String newQty90BC) {
	qty90BC = newQty90BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90CA java.lang.String
 */
public void setQty90CA(java.lang.String newQty90CA) {
	qty90CA = newQty90CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90CB java.lang.String
 */
public void setQty90CB(java.lang.String newQty90CB) {
	qty90CB = newQty90CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90CC java.lang.String
 */
public void setQty90CC(java.lang.String newQty90CC) {
	qty90CC = newQty90CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90DA java.lang.String
 */
public void setQty90DA(java.lang.String newQty90DA) {
	qty90DA = newQty90DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90DB java.lang.String
 */
public void setQty90DB(java.lang.String newQty90DB) {
	qty90DB = newQty90DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:59:09)
 * @param newQty90DC java.lang.String
 */
public void setQty90DC(java.lang.String newQty90DC) {
	qty90DC = newQty90DC;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 14:37:37)
 * @param newRefreshFields int
 */
public void setRefreshFields(int newRefreshFields) {
	refreshFields = newRefreshFields;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource10 java.lang.Integer
 */
public void setResource10(java.lang.Integer newResource10) {
	resource10 = newResource10;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource100 java.lang.Integer
 */
public void setResource100(java.lang.Integer newResource100) {
	resource100 = newResource100;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource110 java.lang.Integer
 */
public void setResource110(java.lang.Integer newResource110) {
	resource110 = newResource110;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 11:50:53)
 * @param newResource120 java.lang.Integer
 */
public void setResource120(java.lang.Integer newResource120) {
	resource120 = newResource120;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource20 java.lang.Integer
 */
public void setResource20(java.lang.Integer newResource20) {
	resource20 = newResource20;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource30 java.lang.Integer
 */
public void setResource30(java.lang.Integer newResource30) {
	resource30 = newResource30;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2004 00:15:11)
 * @param newResource40 java.lang.Integer
 */
public void setResource40(java.lang.Integer newResource40) {
	resource40 = newResource40;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2004 15:31:14)
 * @param newResource50A java.lang.Integer
 */
public void setResource50A(java.lang.Integer newResource50A) {
	resource50A = newResource50A;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2004 15:31:14)
 * @param newResource50B java.lang.Integer
 */
public void setResource50B(java.lang.Integer newResource50B) {
	resource50B = newResource50B;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2004 15:31:14)
 * @param newResource50C java.lang.Integer
 */
public void setResource50C(java.lang.Integer newResource50C) {
	resource50C = newResource50C;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2004 15:31:14)
 * @param newResource50D java.lang.Integer
 */
public void setResource50D(java.lang.Integer newResource50D) {
	resource50D = newResource50D;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2004 00:15:39)
 * @param newResource60 java.lang.Integer
 */
public void setResource60(java.lang.Integer newResource60) {
	resource60 = newResource60;
}
/**
 * Insert the method's description here.
 * Creation date: (16.10.2004 00:15:55)
 * @param newResource70 java.lang.Integer
 */
public void setResource70(java.lang.Integer newResource70) {
	resource70 = newResource70;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource80 java.lang.Integer
 */
public void setResource80(java.lang.Integer newResource80) {
	resource80 = newResource80;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource90 java.lang.Integer
 */
public void setResource90(java.lang.Integer newResource90) {
	resource90 = newResource90;
}
/**
 * Insert the method's description here.
 * Creation date: (28.12.2004 14:44:51)
 * @param newSectorA java.lang.String
 */
public void setSectorA(java.lang.String newSectorA) {
	sectorA = newSectorA;
}
/**
 * Insert the method's description here.
 * Creation date: (28.12.2004 14:45:10)
 * @param newSectorB java.lang.String
 */
public void setSectorB(java.lang.String newSectorB) {
	sectorB = newSectorB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100AA java.lang.String
 */
public void setSerial100AA(java.lang.String newSerial100AA) {
	serial100AA = newSerial100AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100AB java.lang.String
 */
public void setSerial100AB(java.lang.String newSerial100AB) {
	serial100AB = newSerial100AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100AC java.lang.String
 */
public void setSerial100AC(java.lang.String newSerial100AC) {
	serial100AC = newSerial100AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100BA java.lang.String
 */
public void setSerial100BA(java.lang.String newSerial100BA) {
	serial100BA = newSerial100BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100BB java.lang.String
 */
public void setSerial100BB(java.lang.String newSerial100BB) {
	serial100BB = newSerial100BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100BC java.lang.String
 */
public void setSerial100BC(java.lang.String newSerial100BC) {
	serial100BC = newSerial100BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100CA java.lang.String
 */
public void setSerial100CA(java.lang.String newSerial100CA) {
	serial100CA = newSerial100CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100CB java.lang.String
 */
public void setSerial100CB(java.lang.String newSerial100CB) {
	serial100CB = newSerial100CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100CC java.lang.String
 */
public void setSerial100CC(java.lang.String newSerial100CC) {
	serial100CC = newSerial100CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100DA java.lang.String
 */
public void setSerial100DA(java.lang.String newSerial100DA) {
	serial100DA = newSerial100DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100DB java.lang.String
 */
public void setSerial100DB(java.lang.String newSerial100DB) {
	serial100DB = newSerial100DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:22:38)
 * @param newSerial100DC java.lang.String
 */
public void setSerial100DC(java.lang.String newSerial100DC) {
	serial100DC = newSerial100DC;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:12)
 * @param newSerial10A java.lang.String
 */
public void setSerial10A(java.lang.String newSerial10A) {
	serial10A = newSerial10A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:12)
 * @param newSerial10B java.lang.String
 */
public void setSerial10B(java.lang.String newSerial10B) {
	serial10B = newSerial10B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:10:12)
 * @param newSerial10C java.lang.String
 */
public void setSerial10C(java.lang.String newSerial10C) {
	serial10C = newSerial10C;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110AA java.lang.String
 */
public void setSerial110AA(java.lang.String newSerial110AA) {
	serial110AA = newSerial110AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110AB java.lang.String
 */
public void setSerial110AB(java.lang.String newSerial110AB) {
	serial110AB = newSerial110AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110AC java.lang.String
 */
public void setSerial110AC(java.lang.String newSerial110AC) {
	serial110AC = newSerial110AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110BA java.lang.String
 */
public void setSerial110BA(java.lang.String newSerial110BA) {
	serial110BA = newSerial110BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110BB java.lang.String
 */
public void setSerial110BB(java.lang.String newSerial110BB) {
	serial110BB = newSerial110BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110BC java.lang.String
 */
public void setSerial110BC(java.lang.String newSerial110BC) {
	serial110BC = newSerial110BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110CA java.lang.String
 */
public void setSerial110CA(java.lang.String newSerial110CA) {
	serial110CA = newSerial110CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110CB java.lang.String
 */
public void setSerial110CB(java.lang.String newSerial110CB) {
	serial110CB = newSerial110CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110CC java.lang.String
 */
public void setSerial110CC(java.lang.String newSerial110CC) {
	serial110CC = newSerial110CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110DA java.lang.String
 */
public void setSerial110DA(java.lang.String newSerial110DA) {
	serial110DA = newSerial110DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110DB java.lang.String
 */
public void setSerial110DB(java.lang.String newSerial110DB) {
	serial110DB = newSerial110DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial110DC java.lang.String
 */
public void setSerial110DC(java.lang.String newSerial110DC) {
	serial110DC = newSerial110DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120AA java.lang.String
 */
public void setSerial120AA(java.lang.String newSerial120AA) {
	serial120AA = newSerial120AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120AB java.lang.String
 */
public void setSerial120AB(java.lang.String newSerial120AB) {
	serial120AB = newSerial120AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120AC java.lang.String
 */
public void setSerial120AC(java.lang.String newSerial120AC) {
	serial120AC = newSerial120AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120BA java.lang.String
 */
public void setSerial120BA(java.lang.String newSerial120BA) {
	serial120BA = newSerial120BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120BB java.lang.String
 */
public void setSerial120BB(java.lang.String newSerial120BB) {
	serial120BB = newSerial120BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120BC java.lang.String
 */
public void setSerial120BC(java.lang.String newSerial120BC) {
	serial120BC = newSerial120BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120CA java.lang.String
 */
public void setSerial120CA(java.lang.String newSerial120CA) {
	serial120CA = newSerial120CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120CB java.lang.String
 */
public void setSerial120CB(java.lang.String newSerial120CB) {
	serial120CB = newSerial120CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120CC java.lang.String
 */
public void setSerial120CC(java.lang.String newSerial120CC) {
	serial120CC = newSerial120CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120DA java.lang.String
 */
public void setSerial120DA(java.lang.String newSerial120DA) {
	serial120DA = newSerial120DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120DB java.lang.String
 */
public void setSerial120DB(java.lang.String newSerial120DB) {
	serial120DB = newSerial120DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:23:11)
 * @param newSerial120DC java.lang.String
 */
public void setSerial120DC(java.lang.String newSerial120DC) {
	serial120DC = newSerial120DC;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @param newSerial20A java.lang.String
 */
public void setSerial20A(java.lang.String newSerial20A) {
	serial20A = newSerial20A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @param newSerial20B java.lang.String
 */
public void setSerial20B(java.lang.String newSerial20B) {
	serial20B = newSerial20B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @param newSerial20C java.lang.String
 */
public void setSerial20C(java.lang.String newSerial20C) {
	serial20C = newSerial20C;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @param newSerial30A java.lang.String
 */
public void setSerial30A(java.lang.String newSerial30A) {
	serial30A = newSerial30A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @param newSerial30B java.lang.String
 */
public void setSerial30B(java.lang.String newSerial30B) {
	serial30B = newSerial30B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @param newSerial30C java.lang.String
 */
public void setSerial30C(java.lang.String newSerial30C) {
	serial30C = newSerial30C;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @param newSerial40A java.lang.String
 */
public void setSerial40A(java.lang.String newSerial40A) {
	serial40A = newSerial40A;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @param newSerial40B java.lang.String
 */
public void setSerial40B(java.lang.String newSerial40B) {
	serial40B = newSerial40B;
}
/**
 * Insert the method's description here.
 * Creation date: (19.11.2004 12:09:56)
 * @param newSerial40C java.lang.String
 */
public void setSerial40C(java.lang.String newSerial40C) {
	serial40C = newSerial40C;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50AA java.lang.String
 */
public void setSerial50AA(java.lang.String newSerial50AA) {
	serial50AA = newSerial50AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50AB java.lang.String
 */
public void setSerial50AB(java.lang.String newSerial50AB) {
	serial50AB = newSerial50AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50AC java.lang.String
 */
public void setSerial50AC(java.lang.String newSerial50AC) {
	serial50AC = newSerial50AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50BA java.lang.String
 */
public void setSerial50BA(java.lang.String newSerial50BA) {
	serial50BA = newSerial50BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50BB java.lang.String
 */
public void setSerial50BB(java.lang.String newSerial50BB) {
	serial50BB = newSerial50BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50BC java.lang.String
 */
public void setSerial50BC(java.lang.String newSerial50BC) {
	serial50BC = newSerial50BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50CA java.lang.String
 */
public void setSerial50CA(java.lang.String newSerial50CA) {
	serial50CA = newSerial50CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50CB java.lang.String
 */
public void setSerial50CB(java.lang.String newSerial50CB) {
	serial50CB = newSerial50CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50CC java.lang.String
 */
public void setSerial50CC(java.lang.String newSerial50CC) {
	serial50CC = newSerial50CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50DA java.lang.String
 */
public void setSerial50DA(java.lang.String newSerial50DA) {
	serial50DA = newSerial50DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50DB java.lang.String
 */
public void setSerial50DB(java.lang.String newSerial50DB) {
	serial50DB = newSerial50DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 13:01:38)
 * @param newSerial50DC java.lang.String
 */
public void setSerial50DC(java.lang.String newSerial50DC) {
	serial50DC = newSerial50DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60AA java.lang.String
 */
public void setSerial60AA(java.lang.String newSerial60AA) {
	serial60AA = newSerial60AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60AB java.lang.String
 */
public void setSerial60AB(java.lang.String newSerial60AB) {
	serial60AB = newSerial60AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60AC java.lang.String
 */
public void setSerial60AC(java.lang.String newSerial60AC) {
	serial60AC = newSerial60AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60BA java.lang.String
 */
public void setSerial60BA(java.lang.String newSerial60BA) {
	serial60BA = newSerial60BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60BB java.lang.String
 */
public void setSerial60BB(java.lang.String newSerial60BB) {
	serial60BB = newSerial60BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60BC java.lang.String
 */
public void setSerial60BC(java.lang.String newSerial60BC) {
	serial60BC = newSerial60BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60CA java.lang.String
 */
public void setSerial60CA(java.lang.String newSerial60CA) {
	serial60CA = newSerial60CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60CB java.lang.String
 */
public void setSerial60CB(java.lang.String newSerial60CB) {
	serial60CB = newSerial60CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60CC java.lang.String
 */
public void setSerial60CC(java.lang.String newSerial60CC) {
	serial60CC = newSerial60CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60DA java.lang.String
 */
public void setSerial60DA(java.lang.String newSerial60DA) {
	serial60DA = newSerial60DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60DB java.lang.String
 */
public void setSerial60DB(java.lang.String newSerial60DB) {
	serial60DB = newSerial60DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial60DC java.lang.String
 */
public void setSerial60DC(java.lang.String newSerial60DC) {
	serial60DC = newSerial60DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70AA java.lang.String
 */
public void setSerial70AA(java.lang.String newSerial70AA) {
	serial70AA = newSerial70AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70AB java.lang.String
 */
public void setSerial70AB(java.lang.String newSerial70AB) {
	serial70AB = newSerial70AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70AC java.lang.String
 */
public void setSerial70AC(java.lang.String newSerial70AC) {
	serial70AC = newSerial70AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70BA java.lang.String
 */
public void setSerial70BA(java.lang.String newSerial70BA) {
	serial70BA = newSerial70BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70BB java.lang.String
 */
public void setSerial70BB(java.lang.String newSerial70BB) {
	serial70BB = newSerial70BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70BC java.lang.String
 */
public void setSerial70BC(java.lang.String newSerial70BC) {
	serial70BC = newSerial70BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70CA java.lang.String
 */
public void setSerial70CA(java.lang.String newSerial70CA) {
	serial70CA = newSerial70CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70CB java.lang.String
 */
public void setSerial70CB(java.lang.String newSerial70CB) {
	serial70CB = newSerial70CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70CC java.lang.String
 */
public void setSerial70CC(java.lang.String newSerial70CC) {
	serial70CC = newSerial70CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70DA java.lang.String
 */
public void setSerial70DA(java.lang.String newSerial70DA) {
	serial70DA = newSerial70DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70DB java.lang.String
 */
public void setSerial70DB(java.lang.String newSerial70DB) {
	serial70DB = newSerial70DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial70DC java.lang.String
 */
public void setSerial70DC(java.lang.String newSerial70DC) {
	serial70DC = newSerial70DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80AA java.lang.String
 */
public void setSerial80AA(java.lang.String newSerial80AA) {
	serial80AA = newSerial80AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80AB java.lang.String
 */
public void setSerial80AB(java.lang.String newSerial80AB) {
	serial80AB = newSerial80AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80AC java.lang.String
 */
public void setSerial80AC(java.lang.String newSerial80AC) {
	serial80AC = newSerial80AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80BA java.lang.String
 */
public void setSerial80BA(java.lang.String newSerial80BA) {
	serial80BA = newSerial80BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80BB java.lang.String
 */
public void setSerial80BB(java.lang.String newSerial80BB) {
	serial80BB = newSerial80BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80BC java.lang.String
 */
public void setSerial80BC(java.lang.String newSerial80BC) {
	serial80BC = newSerial80BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80CA java.lang.String
 */
public void setSerial80CA(java.lang.String newSerial80CA) {
	serial80CA = newSerial80CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80CB java.lang.String
 */
public void setSerial80CB(java.lang.String newSerial80CB) {
	serial80CB = newSerial80CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80CC java.lang.String
 */
public void setSerial80CC(java.lang.String newSerial80CC) {
	serial80CC = newSerial80CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80DA java.lang.String
 */
public void setSerial80DA(java.lang.String newSerial80DA) {
	serial80DA = newSerial80DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80DB java.lang.String
 */
public void setSerial80DB(java.lang.String newSerial80DB) {
	serial80DB = newSerial80DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial80DC java.lang.String
 */
public void setSerial80DC(java.lang.String newSerial80DC) {
	serial80DC = newSerial80DC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90AA java.lang.String
 */
public void setSerial90AA(java.lang.String newSerial90AA) {
	serial90AA = newSerial90AA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90AB java.lang.String
 */
public void setSerial90AB(java.lang.String newSerial90AB) {
	serial90AB = newSerial90AB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90AC java.lang.String
 */
public void setSerial90AC(java.lang.String newSerial90AC) {
	serial90AC = newSerial90AC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90BA java.lang.String
 */
public void setSerial90BA(java.lang.String newSerial90BA) {
	serial90BA = newSerial90BA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90BB java.lang.String
 */
public void setSerial90BB(java.lang.String newSerial90BB) {
	serial90BB = newSerial90BB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90BC java.lang.String
 */
public void setSerial90BC(java.lang.String newSerial90BC) {
	serial90BC = newSerial90BC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90CA java.lang.String
 */
public void setSerial90CA(java.lang.String newSerial90CA) {
	serial90CA = newSerial90CA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90CB java.lang.String
 */
public void setSerial90CB(java.lang.String newSerial90CB) {
	serial90CB = newSerial90CB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90CC java.lang.String
 */
public void setSerial90CC(java.lang.String newSerial90CC) {
	serial90CC = newSerial90CC;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90DA java.lang.String
 */
public void setSerial90DA(java.lang.String newSerial90DA) {
	serial90DA = newSerial90DA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90DB java.lang.String
 */
public void setSerial90DB(java.lang.String newSerial90DB) {
	serial90DB = newSerial90DB;
}
/**
 * Insert the method's description here.
 * Creation date: (26.11.2004 12:19:46)
 * @param newSerial90DC java.lang.String
 */
public void setSerial90DC(java.lang.String newSerial90DC) {
	serial90DC = newSerial90DC;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 18:20:28)
 * @param newUser java.lang.String
 */
public void setUser(java.lang.String newUser) {
	user = newUser;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:09)
 * @param newWorkercode java.lang.String
 */
public void setWorkercode(java.lang.String newWorkercode) {
	workercode = newWorkercode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:29)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2004 14:34:52)
 * @param newWorkertitle java.lang.String
 */
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
/**
 * Проверяет правильность заполнения полей ресурса и серийного номера,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public void validateAzimut(String argAzim, String argMsgKey, ActionErrors errors) {
	
	String editPos = "azim" + argMsgKey;
	
	com.hps.july.jdbcpersistence.lib.StringAndBigDecimal az = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(6, 2);
	az.setString(argAzim);
	if (az.isEmpty())
		errors.add(editPos, new ActionError("error.afsmountact2.empty.azim"));
	else if (!az.isOk())
		errors.add(editPos, new ActionError("error.afsmountact2.bad.azim"));
}
/**
 * Проверяет отсутствие заполнения полей ресурса и серийного номера,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public void validateEmpty(String argPolicy, String argSerial, String argQty, String argMsgKey, ActionErrors errors) {
	
	String editPos = "resource" + argMsgKey;
	
	String policy = argPolicy;

	if ("S".equals(policy)) {
			editPos = "serial" + argMsgKey;
			if  ( (argSerial != null) && (argSerial.trim().length() > 0) )
				errors.add(editPos, new ActionError("error.mountact2.notempty.serial"));
	} else if ("P".equals(policy)) {
			editPos = "serial" + argMsgKey;
			if  ( (argSerial != null) && (argSerial.trim().length() > 0) ) 
				errors.add(editPos, new ActionError("error.mountact2.notempty.party"));
	} else if ("B".equals(policy)) {
		editPos = "qty" + argMsgKey;
		if  ( (argQty != null) && (argQty.trim().length() > 0) )
			errors.add(editPos, new ActionError("error.mountact2.notempty.qty"));
	}
}
/**
 * Проверяет правильность заполнения полей ресурса и серийного номера,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public void validateGndcnt(String argGndcnt, Integer argResource, String argSerial, String argQty, String argMsgKey, ActionErrors errors) {
	
	String editPos = "gndcnt" + argMsgKey;
	
	com.hps.july.jdbcpersistence.lib.StringAndInteger sb = new com.hps.july.jdbcpersistence.lib.StringAndInteger();
	sb.setString(argGndcnt);
	com.hps.july.jdbcpersistence.lib.StringAndBigDecimal qty = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(6, 3);
	qty.setString(argQty);
	if (!sb.isEmpty() && !sb.isOk() && (argResource != null) && 
		(   ( (argSerial != null) && (argSerial.trim().length() != 0) )  || !qty.isEmpty()  )    ) {
				errors.add(editPos, new ActionError("error.afsmountact2.bad.gndcnt"));
	}
	if (!sb.isEmpty() && ( (argResource == null) || 
		(   ( (argSerial == null) || (argSerial.trim().length() == 0) )  && qty.isEmpty()  )  )  ) {
				errors.add(editPos, new ActionError("error.afsmountact2.extra.gndcnt"));
	}
}
/**
 * Проверяет правильность заполнения поля высота подвеса,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public void validateHSet(String argHSet, String argMsgKey, ActionErrors errors) {
	
	String editPos = "hset" + argMsgKey;
	
	com.hps.july.jdbcpersistence.lib.StringAndBigDecimal az = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(6, 2);
	az.setString(argHSet);
	if (az.isEmpty())
		errors.add(editPos, new ActionError("error.afsmountact2.empty.hset"));
	else if (!az.isOk())
		errors.add(editPos, new ActionError("error.afsmountact2.bad.hset"));
}
/**
 * Проверяет правильность заполнения полей ресурса и серийного номера,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public void validateKSVN(String argKSVN, Integer argResource, String argSerial, String argQty, String argMsgKey, ActionErrors errors) {
	
	String editPos = "ksvn" + argMsgKey;
	
	com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sb = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(6, 3);
	sb.setString(argKSVN);
	com.hps.july.jdbcpersistence.lib.StringAndBigDecimal qty = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(6, 3);
	qty.setString(argQty);
	if (!sb.isEmpty() && !sb.isOk() && (argResource != null) && 
		(   ( (argSerial != null) && (argSerial.trim().length() != 0) )  || !qty.isEmpty()  )    ) {
				errors.add(editPos, new ActionError("error.afsmountact2.bad.ksvn"));
	}
	if (!sb.isEmpty() && ( (argResource == null) || 
		(   ( (argSerial == null) || (argSerial.trim().length() == 0) )  && qty.isEmpty()  )  )  ) {
				errors.add(editPos, new ActionError("error.afsmountact2.extra.ksvn"));
	}
}
/**
 * Проверяет правильность заполнения полей ресурса и серийного номера,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public void validateNakl(String argNakl, String argMsgKey, ActionErrors errors) {
	
	String editPos = "nakl" + argMsgKey;
	
	com.hps.july.jdbcpersistence.lib.StringAndBigDecimal az = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(4, 2);
	az.setString(argNakl);
	if (az.isEmpty())
		errors.add(editPos, new ActionError("error.afsmountact2.empty.nakl"));
	else if (!az.isOk())
		errors.add(editPos, new ActionError("error.afsmountact2.bad.nakl"));
}
/**
 * Проверяет правильность заполнения полей ресурса и серийного номера,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public void validateParams(boolean reqParams, String argPolicy, String argSerial, String argQty, String argAntSerial, String argAntQty, String argMsgKey, ActionErrors errors) {

	String editPos1 = "serial" + argMsgKey;
	String editPos2 = "qty" + argMsgKey;
	com.hps.july.jdbcpersistence.lib.StringAndBigDecimal qty = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(6, 3);
	qty.setString(argQty);
	if (  
		(   ( (argAntSerial == null) || (argAntSerial.trim().length() == 0) )  && ( (argAntQty == null) || (argAntQty.trim().length() == 0) )  )
		&& 
		(   ( (argSerial != null) && (argSerial.trim().length() != 0) )  || !qty.isEmpty()  )  )   {
				errors.add(editPos1, new ActionError("error.afsmountact2.extra.param"));
				errors.add(editPos2, new ActionError("error.afsmountact2.extra.param"));
	}
		validateParams(reqParams, argPolicy, argSerial, argQty, argMsgKey, errors);
		
}
/**
 * Проверяет правильность заполнения полей ресурса и серийного номера,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public void validateParams(boolean reqParams, String argPolicy, String argSerial, String argQty, String argMsgKey, ActionErrors errors) {
	
	String editPos = "resource" + argMsgKey;
	
	String policy = argPolicy;

	if ("S".equals(policy)) {
		if (reqParams) {
			editPos = "serial" + argMsgKey;
			if  ( (argSerial == null) || (argSerial.trim().length() == 0) ) 
				errors.add(editPos, new ActionError("error.mountact2.empty.serial"));
		}
	} else if ("P".equals(policy)) {
		if (reqParams) {
			editPos = "serial" + argMsgKey;
			if  ( (argSerial == null) || (argSerial.trim().length() == 0) ) 
				errors.add(editPos, new ActionError("error.mountact2.empty.party"));
		}
	} else if ("B".equals(policy)) {
		//System.out.println("Validate #1");
		editPos = "qty" + argMsgKey;
		if  ( (argQty == null) || (argQty.trim().length() == 0) )
			//System.out.println("Validate #2");
			if (reqParams) 
				errors.add(editPos, new ActionError("error.mountact2.empty.qty"));
		else {
			//System.out.println("Validate #3");
			// Проверим количество
			com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sb = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 3);
			sb.setString(argQty);
			if (!sb.isOk()) {
				//System.out.println("Validate #4");
				errors.add(editPos, new ActionError("error.mountact2.bad.qty"));
			}
		}
	}
}
/**
 * Проверяет правильность заполнения полей ресурса и серийного номера,
 *  и добавляет ошибку в коллекцию ошибок если необходимо.
 * Creation date: (18.10.2004 14:52:16)
 * @param argResource java.lang.String
 * @param argSerial java.lang.String
 * @param argMsgKey java.lang.String
 */
public String validateResource(boolean reqResource, Integer argResource, String argMsgKey, ActionErrors errors) {
	
	String editPos = "resource" + argMsgKey;
	
	// Проверим заполнение обоих полей или что оба незаполнены
	if ( (!reqResource) && (argResource == null) )
		return "";

	if (argResource == null) {
		errors.add(editPos, new ActionError("error.mountact2.empty.resource"));
		return "";
	}
	String policy = "";
	// Проверим ресурс			
	try {
		int bi = argResource.intValue();
		ResourceAccessBean res = new ResourceAccessBean();
		res.setInitKey_resource(bi);
		res.refreshCopyHelper();
		policy = res.getCountpolicy();
	} catch (Exception e) {
		errors.add(editPos, new ActionError("error.mountact2.bad.resource"));
	}
	return policy;
}
/**
 * Метод для проверки правильности ввода значений в поля ввода.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException - 
 * при этом исключении ошибки отображаются пользователю.
 */
public void validateValues(ActionErrors errors) throws Exception {

	StringAndIntegerProperty si = new StringAndIntegerProperty();

	// Проверим номер позиции
	si.setString(getPosnumber());
	if (si.isEmpty())
		errors.add("head", new ActionError("error.mountact2.empty.posnumber"));
	else
		if (!si.isOk())
			errors.add("head", new ActionError("error.mountact2.bad.posnumber"));
		else {
			if (!getPosnumber().equals(getOldposnumber())) {
				setComplectcode(null);
				setComplectname("");
			}
			if (getComplectcode() == null) {
				// Определим комплект оборудования
				CDBCResultSet res = getComplects();
				//System.out.println("RESULT ROWS=" + res.getRowsCount());
				if (res.getRowsCount() > 1) {
					setManycomplects(true);
					errors.add("head", new ActionError("error.mountact2.toomany.complect"));
				} else if (res.getRowsCount() < 1) {
					setManycomplects(true);
					errors.add("head", new ActionError("error.mountact2.empty.complect"));
				} else {
					setManycomplects(false);
					java.util.ListIterator it = res.listIterator();
					CDBCRowObject ro = (CDBCRowObject)it.next();
					setComplectcode((Integer)ro.getColumn("equipment").asObject());
					setComplectname(ro.getColumn("name").asString());
				}
			}
		}

	setOldposnumber(getPosnumber());
	checkProject(errors);
	
	if (getRefreshFields() == 1)
		throw new ValidationException();
		
	// Проверим заполнение поля дата
	if ( (getActdate() == null) || "".equals(getActdate().trim()) )
		errors.add("actdate", new ActionError("error.mountact2.empty.actdate"));
	
	String policy;
	boolean isCross10 = false;
	boolean isCross20 = false;
	boolean isCross30 = false;
	boolean isCross40 = false;
	if (getResource10() != null)
		isCross10 = isCrossAntenn(getResource10().intValue());
	policy = validateResource(true, getResource10(), "10A", errors);
	validateParams(true, policy, getSerial10A(), getQty10A(), "10A", errors);
	if (isCross10) {
		validateEmpty(policy, getSerial10B(), getQty10B(), "10B", errors);
		validateEmpty(policy, getSerial10C(), getQty10C(), "10C", errors);
	} else {
		validateParams(false, policy, getSerial10B(), getQty10B(), "10B", errors);
		validateParams(false, policy, getSerial10C(), getQty10C(), "10C", errors);
	}
	if ("2".equals(getDiffs()) || "3".equals(getDiffs()) || "4".equals(getDiffs()) ) {
		policy = validateResource(true, getResource20(), "20A", errors);
		validateParams(true, policy, getSerial20A(), getQty20A(), "20A", errors);
		if (getResource20() != null)
			isCross20 = isCrossAntenn(getResource20().intValue());
		if (isCross20) {
			validateEmpty(policy, getSerial20B(), getQty20B(), "20B", errors);
			validateEmpty(policy, getSerial20C(), getQty20C(), "20C", errors);
		} else {
			validateParams(false, policy, getSerial20B(), getQty20B(), "20B", errors);
			validateParams(false, policy, getSerial20C(), getQty20C(), "20C", errors);
		}
	}
	if ("3".equals(getDiffs()) || "4".equals(getDiffs()) ) {
		policy = validateResource(true, getResource30(), "30A", errors);
		validateParams(true, policy, getSerial30A(), getQty30A(), "30A", errors);
		if (getResource30() != null)
			isCross30 = isCrossAntenn(getResource30().intValue());
		if (isCross30) {
			validateEmpty(policy, getSerial30B(), getQty30B(), "30B", errors);
			validateEmpty(policy, getSerial30C(), getQty30C(), "30C", errors);
		} else {
			validateParams(false, policy, getSerial30B(), getQty30B(), "30B", errors);
			validateParams(false, policy, getSerial30C(), getQty30C(), "30C", errors);
		}
	}
	if ("4".equals(getDiffs()) ) {
		policy = validateResource(true, getResource40(), "40A", errors);
		validateParams(true, policy, getSerial40A(), getQty40A(), "40A", errors);
		if (getResource40() != null)
			isCross40 = isCrossAntenn(getResource40().intValue());
		if (isCross40) {
			validateEmpty(policy, getSerial40B(), getQty40B(), "40B", errors);
			validateEmpty(policy, getSerial40C(), getQty40C(), "40C", errors);
		} else {
			validateParams(false, policy, getSerial40B(), getQty40B(), "40B", errors);
			validateParams(false, policy, getSerial40C(), getQty40C(), "40C", errors);
		}
	}

	validateAzimut(getAzimA(), "A", errors);
	validateHSet(getHsetA(), "A", errors);
	validateNakl(getNaklA(), "A", errors);
	if ("2".equals(getDiffs()) || "3".equals(getDiffs()) || "4".equals(getDiffs()) ) {
		validateAzimut(getAzimB(), "B", errors);
		validateHSet(getHsetB(), "B", errors);
		validateNakl(getNaklB(), "B", errors);
	}
	if ("3".equals(getDiffs()) || "4".equals(getDiffs()) ) {
		validateAzimut(getAzimC(), "C", errors);
		validateHSet(getHsetC(), "C", errors);
		validateNakl(getNaklC(), "C", errors);
	}
	if ("4".equals(getDiffs()) ) {
		validateAzimut(getAzimD(), "D", errors);
		validateHSet(getHsetD(), "D", errors);
		validateNakl(getNaklD(), "D", errors);
	}
			
		
	validateKSVN(getKsvnAA(), getResource10(), getSerial10A(), getQty10A(), "AA", errors);
	if (isCross10)
		validateKSVN(getKsvnAB(), getResource10(), getSerial10A(), getQty10A(), "AB", errors);
	else
		validateKSVN(getKsvnAB(), getResource10(), getSerial10B(), getQty10B(), "AB", errors);
	validateKSVN(getKsvnAC(), getResource10(), getSerial10C(), getQty10C(), "AC", errors);
	validateKSVN(getKsvnBA(), getResource20(), getSerial20A(), getQty20A(), "BA", errors);
	if (isCross20)
		validateKSVN(getKsvnBB(), getResource20(), getSerial20A(), getQty20A(), "BB", errors);
	else
		validateKSVN(getKsvnBB(), getResource20(), getSerial20B(), getQty20B(), "BB", errors);
	validateKSVN(getKsvnBC(), getResource20(), getSerial20C(), getQty20C(), "BC", errors);
	validateKSVN(getKsvnCA(), getResource30(), getSerial30A(), getQty30A(), "CA", errors);
	if (isCross30)
		validateKSVN(getKsvnCB(), getResource30(), getSerial30A(), getQty30A(), "CB", errors);
	else
		validateKSVN(getKsvnCB(), getResource30(), getSerial30B(), getQty30B(), "CB", errors);
	validateKSVN(getKsvnCC(), getResource30(), getSerial30C(), getQty30C(), "CC", errors);
	validateKSVN(getKsvnDA(), getResource40(), getSerial40A(), getQty40A(), "DA", errors);
	if (isCross40)
		validateKSVN(getKsvnDB(), getResource40(), getSerial40A(), getQty40A(), "DB", errors);
	else
		validateKSVN(getKsvnDB(), getResource40(), getSerial40B(), getQty40B(), "DB", errors);
	validateKSVN(getKsvnDC(), getResource40(), getSerial40C(), getQty40C(), "DC", errors);
		
	validateGndcnt(getGndcntAA(), getResource10(), getSerial10A(), getQty10A(), "AA", errors);
	if (isCross10)
		validateGndcnt(getGndcntAB(), getResource10(), getSerial10A(), getQty10A(), "AB", errors);
	else
		validateGndcnt(getGndcntAB(), getResource10(), getSerial10B(), getQty10B(), "AB", errors);
	validateGndcnt(getGndcntAC(), getResource10(), getSerial10C(), getQty10C(), "AC", errors);
	validateGndcnt(getGndcntBA(), getResource20(), getSerial20A(), getQty20A(), "BA", errors);
	if (isCross20)
		validateGndcnt(getGndcntBB(), getResource20(), getSerial20A(), getQty20A(), "BB", errors);
	else
		validateGndcnt(getGndcntBB(), getResource20(), getSerial20B(), getQty20B(), "BB", errors);
	validateGndcnt(getGndcntBC(), getResource20(), getSerial20C(), getQty20C(), "BC", errors);
	validateGndcnt(getGndcntCA(), getResource30(), getSerial30A(), getQty30A(), "CA", errors);
	if (isCross30)
		validateGndcnt(getGndcntCB(), getResource30(), getSerial30A(), getQty30A(), "CB", errors);
	else
		validateGndcnt(getGndcntCB(), getResource30(), getSerial30B(), getQty30B(), "CB", errors);
	validateGndcnt(getGndcntCC(), getResource30(), getSerial30C(), getQty30C(), "CC", errors);
	validateGndcnt(getGndcntDA(), getResource40(), getSerial40A(), getQty40A(), "DA", errors);
	if (isCross40)
		validateGndcnt(getGndcntDB(), getResource40(), getSerial40A(), getQty40A(), "DB", errors);
	else
		validateGndcnt(getGndcntDB(), getResource40(), getSerial40B(), getQty40B(), "DB", errors);
	validateGndcnt(getGndcntDC(), getResource40(), getSerial40C(), getQty40C(), "DC", errors);
		
	policy = validateResource(false, getResource50A(), "50A", errors);
	validateParams(false, policy, getSerial50AA(), getQty50AA(), getSerial10A(), getQty10A(), "50AA", errors);
	if (isCross10)
		validateParams(false, policy, getSerial50AB(), getQty50AB(), getSerial10A(), getQty10A(), "50AB", errors);
	else
		validateParams(false, policy, getSerial50AB(), getQty50AB(), getSerial10B(), getQty10B(), "50AB", errors);
	validateParams(false, policy, getSerial50AC(), getQty50AC(), getSerial10C(), getQty10C(), "50AC", errors);
	
	policy = validateResource(false, getResource50B(), "50B", errors);
	validateParams(false, policy, getSerial50BA(), getQty50BA(), getSerial20A(), getQty20A(), "50BA", errors);
	if (isCross20)
		validateParams(false, policy, getSerial50BB(), getQty50BB(), getSerial20A(), getQty20A(), "50BB", errors);
	else
		validateParams(false, policy, getSerial50BB(), getQty50BB(), getSerial20B(), getQty20B(), "50BB", errors);
	validateParams(false, policy, getSerial50BC(), getQty50BC(), getSerial20C(), getQty20C(), "50BC", errors);
	
	policy = validateResource(false, getResource50C(), "50C", errors);
	validateParams(false, policy, getSerial50CA(), getQty50CA(), getSerial30A(), getQty30A(), "50CA", errors);
	if (isCross30)
		validateParams(false, policy, getSerial50CB(), getQty50CB(), getSerial30A(), getQty30A(), "50CB", errors);
	else
		validateParams(false, policy, getSerial50CB(), getQty50CB(), getSerial30B(), getQty30B(), "50CB", errors);
	validateParams(false, policy, getSerial50CC(), getQty50CC(), getSerial30C(), getQty30C(), "50CC", errors);
	
	policy = validateResource(false, getResource50D(), "50D", errors);
	validateParams(false, policy, getSerial50DA(), getQty50DA(), getSerial40A(), getQty40A(), "50DA", errors);
	if (isCross40)
		validateParams(false, policy, getSerial50DB(), getQty50DB(), getSerial40A(), getQty40A(), "50DB", errors);
	else
		validateParams(false, policy, getSerial50DB(), getQty50DB(), getSerial40B(), getQty40B(), "50DB", errors);
	validateParams(false, policy, getSerial50DC(), getQty50DC(), getSerial40C(), getQty40C(), "50DC", errors);

	policy = validateResource(false, getResource60(), "60", errors);
	validateParams(false, policy, getSerial60AA(), getQty60AA(), getSerial10A(), getQty10A(), "60AA", errors);
	if (isCross10)
		validateParams(false, policy, getSerial60AB(), getQty60AB(), getSerial10A(), getQty10A(), "60AB", errors);
	else
		validateParams(false, policy, getSerial60AB(), getQty60AB(), getSerial10B(), getQty10B(), "60AB", errors);
	validateParams(false, policy, getSerial60AC(), getQty60AC(), getSerial10C(), getQty10C(), "60AC", errors);
	validateParams(false, policy, getSerial60BA(), getQty60BA(), getSerial20A(), getQty20A(), "60BA", errors);
	if (isCross20)
		validateParams(false, policy, getSerial60BB(), getQty60BB(), getSerial20A(), getQty20A(), "60BB", errors);
	else
		validateParams(false, policy, getSerial60BB(), getQty60BB(), getSerial20B(), getQty20B(), "60BB", errors);
	validateParams(false, policy, getSerial60BC(), getQty60BC(), getSerial20C(), getQty20C(), "60BC", errors);
	validateParams(false, policy, getSerial60CA(), getQty60CA(), getSerial30A(), getQty30A(), "60CA", errors);
	if (isCross30)
		validateParams(false, policy, getSerial60CB(), getQty60CB(), getSerial30A(), getQty30A(), "60CB", errors);
	else
		validateParams(false, policy, getSerial60CB(), getQty60CB(), getSerial30B(), getQty30B(), "60CB", errors);
	validateParams(false, policy, getSerial60CC(), getQty60CC(), getSerial30C(), getQty30C(), "60CC", errors);
	validateParams(false, policy, getSerial60DA(), getQty60DA(), getSerial40A(), getQty40A(), "60DA", errors);
	if (isCross40)
		validateParams(false, policy, getSerial60DB(), getQty60DB(), getSerial40A(), getQty40A(), "60DB", errors);
	else
		validateParams(false, policy, getSerial60DB(), getQty60DB(), getSerial40B(), getQty40B(), "60DB", errors);
	validateParams(false, policy, getSerial60DC(), getQty60DC(), getSerial40C(), getQty40C(), "60DC", errors);
	
	policy = validateResource(false, getResource70(), "70", errors);
	validateParams(false, policy, getSerial70AA(), getQty70AA(), getSerial10A(), getQty10A(), "70AA", errors);
	if (isCross10)
		validateParams(false, policy, getSerial70AB(), getQty70AB(), getSerial10A(), getQty10A(), "70AB", errors);
	else
		validateParams(false, policy, getSerial70AB(), getQty70AB(), getSerial10B(), getQty10B(), "70AB", errors);
	validateParams(false, policy, getSerial70AC(), getQty70AC(), getSerial10C(), getQty10C(), "70AC", errors);
	validateParams(false, policy, getSerial70BA(), getQty70BA(), getSerial20A(), getQty20A(), "70BA", errors);
	if (isCross20)
		validateParams(false, policy, getSerial70BB(), getQty70BB(), getSerial20A(), getQty20A(), "70BB", errors);
	else
		validateParams(false, policy, getSerial70BB(), getQty70BB(), getSerial20B(), getQty20B(), "70BB", errors);
	validateParams(false, policy, getSerial70BC(), getQty70BC(), getSerial20C(), getQty20C(), "70BC", errors);
	validateParams(false, policy, getSerial70CA(), getQty70CA(), getSerial30A(), getQty30A(), "70CA", errors);
	if (isCross30)
		validateParams(false, policy, getSerial70CB(), getQty70CB(), getSerial30A(), getQty30A(), "70CB", errors);
	else
		validateParams(false, policy, getSerial70CB(), getQty70CB(), getSerial30B(), getQty30B(), "70CB", errors);
	validateParams(false, policy, getSerial70CC(), getQty70CC(), getSerial30C(), getQty30C(), "70CC", errors);
	validateParams(false, policy, getSerial70DA(), getQty70DA(), getSerial40A(), getQty40A(), "70DA", errors);
	if (isCross40)
		validateParams(false, policy, getSerial70DB(), getQty70DB(), getSerial40A(), getQty40A(), "70DB", errors);
	else
		validateParams(false, policy, getSerial70DB(), getQty70DB(), getSerial40B(), getQty40B(), "70DB", errors);
	validateParams(false, policy, getSerial70DC(), getQty70DC(), getSerial40C(), getQty40C(), "70DC", errors);
	
	policy = validateResource(false, getResource80(), "80", errors);
	validateParams(false, policy, getSerial80AA(), getQty80AA(), getSerial10A(), getQty10A(), "80AA", errors);
	if (isCross10)
		validateParams(false, policy, getSerial80AB(), getQty80AB(), getSerial10A(), getQty10A(), "80AB", errors);
	else
		validateParams(false, policy, getSerial80AB(), getQty80AB(), getSerial10B(), getQty10B(), "80AB", errors);
	validateParams(false, policy, getSerial80AC(), getQty80AC(), getSerial10C(), getQty10C(), "80AC", errors);
	validateParams(false, policy, getSerial80BA(), getQty80BA(), getSerial20A(), getQty20A(), "80BA", errors);
	if (isCross20)
		validateParams(false, policy, getSerial80BB(), getQty80BB(), getSerial20A(), getQty20A(), "80BB", errors);
	else
		validateParams(false, policy, getSerial80BB(), getQty80BB(), getSerial20B(), getQty20B(), "80BB", errors);
	validateParams(false, policy, getSerial80BC(), getQty80BC(), getSerial20C(), getQty20C(), "80BC", errors);
	validateParams(false, policy, getSerial80CA(), getQty80CA(), getSerial30A(), getQty30A(), "80CA", errors);
	if (isCross30)
		validateParams(false, policy, getSerial80CB(), getQty80CB(), getSerial30A(), getQty30A(), "80CB", errors);
	else
		validateParams(false, policy, getSerial80CB(), getQty80CB(), getSerial30B(), getQty30B(), "80CB", errors);
	validateParams(false, policy, getSerial80CC(), getQty80CC(), getSerial30C(), getQty30C(), "80CC", errors);
	validateParams(false, policy, getSerial80DA(), getQty80DA(), getSerial40A(), getQty40A(), "80DA", errors);
	if (isCross40)
		validateParams(false, policy, getSerial80DB(), getQty80DB(), getSerial40A(), getQty40A(), "80DB", errors);
	else
		validateParams(false, policy, getSerial80DB(), getQty80DB(), getSerial40B(), getQty40B(), "80DB", errors);
	validateParams(false, policy, getSerial80DC(), getQty80DC(), getSerial40C(), getQty40C(), "80DC", errors);
	
	policy = validateResource(false, getResource90(), "90", errors);
	validateParams(false, policy, getSerial90AA(), getQty90AA(), getSerial10A(), getQty10A(), "90AA", errors);
	if (isCross10)
		validateParams(false, policy, getSerial90AB(), getQty90AB(), getSerial10A(), getQty10A(), "90AB", errors);
	else
		validateParams(false, policy, getSerial90AB(), getQty90AB(), getSerial10B(), getQty10B(), "90AB", errors);
	validateParams(false, policy, getSerial90AC(), getQty90AC(), getSerial10C(), getQty10C(), "90AC", errors);
	validateParams(false, policy, getSerial90BA(), getQty90BA(), getSerial20A(), getQty20A(), "90BA", errors);
	if (isCross20)
		validateParams(false, policy, getSerial90BB(), getQty90BB(), getSerial20A(), getQty20A(), "90BB", errors);
	else
		validateParams(false, policy, getSerial90BB(), getQty90BB(), getSerial20B(), getQty20B(), "90BB", errors);
	validateParams(false, policy, getSerial90BC(), getQty90BC(), getSerial20C(), getQty20C(), "90BC", errors);
	validateParams(false, policy, getSerial90CA(), getQty90CA(), getSerial30A(), getQty30A(), "90CA", errors);
	if (isCross30)
		validateParams(false, policy, getSerial90CB(), getQty90CB(), getSerial30A(), getQty30A(), "90CB", errors);
	else
		validateParams(false, policy, getSerial90CB(), getQty90CB(), getSerial30B(), getQty30B(), "90CB", errors);
	validateParams(false, policy, getSerial90CC(), getQty90CC(), getSerial30C(), getQty30C(), "90CC", errors);
	validateParams(false, policy, getSerial90DA(), getQty90DA(), getSerial40A(), getQty40A(), "90DA", errors);
	if (isCross40)
		validateParams(false, policy, getSerial90DB(), getQty90DB(), getSerial40A(), getQty40A(), "90DB", errors);
	else
		validateParams(false, policy, getSerial90DB(), getQty90DB(), getSerial40B(), getQty40B(), "90DB", errors);
	validateParams(false, policy, getSerial90DC(), getQty90DC(), getSerial40C(), getQty40C(), "90DC", errors);

	policy = validateResource(false, getResource100(), "100", errors);
	validateParams(false, policy, getSerial100AA(), getQty100AA(), getSerial10A(), getQty10A(), "100AA", errors);
	if (isCross10)
		validateParams(false, policy, getSerial100AB(), getQty100AB(), getSerial10A(), getQty10A(), "100AB", errors);
	else
		validateParams(false, policy, getSerial100AB(), getQty100AB(), getSerial10B(), getQty10B(), "100AB", errors);
	validateParams(false, policy, getSerial100AC(), getQty100AC(), getSerial10C(), getQty10C(), "100AC", errors);
	validateParams(false, policy, getSerial100BA(), getQty100BA(), getSerial20A(), getQty20A(), "100BA", errors);
	if (isCross20)
		validateParams(false, policy, getSerial100BB(), getQty100BB(), getSerial20A(), getQty20A(), "100BB", errors);
	else
		validateParams(false, policy, getSerial100BB(), getQty100BB(), getSerial20B(), getQty20B(), "100BB", errors);
	validateParams(false, policy, getSerial100BC(), getQty100BC(), getSerial20C(), getQty20C(), "100BC", errors);
	validateParams(false, policy, getSerial100CA(), getQty100CA(), getSerial30A(), getQty30A(), "100CA", errors);
	if (isCross30)
		validateParams(false, policy, getSerial100CB(), getQty100CB(), getSerial30A(), getQty30A(), "100CB", errors);
	else
		validateParams(false, policy, getSerial100CB(), getQty100CB(), getSerial30B(), getQty30B(), "100CB", errors);
	validateParams(false, policy, getSerial100CC(), getQty100CC(), getSerial30C(), getQty30C(), "100CC", errors);
	validateParams(false, policy, getSerial100DA(), getQty100DA(), getSerial40A(), getQty40A(), "100DA", errors);
	if (isCross40)
		validateParams(false, policy, getSerial100DB(), getQty100DB(), getSerial40A(), getQty40A(), "100DB", errors);
	else
		validateParams(false, policy, getSerial100DB(), getQty100DB(), getSerial40B(), getQty40B(), "100DB", errors);
	validateParams(false, policy, getSerial100DC(), getQty100DC(), getSerial40C(), getQty40C(), "100DC", errors);
	
	policy = validateResource(false, getResource110(), "110", errors);
	validateParams(false, policy, getSerial110AA(), getQty110AA(), getSerial10A(), getQty10A(), "110AA", errors);
	if (isCross10)
		validateParams(false, policy, getSerial110AB(), getQty110AB(), getSerial10A(), getQty10A(), "110AB", errors);
	else
		validateParams(false, policy, getSerial110AB(), getQty110AB(), getSerial10B(), getQty10B(), "110AB", errors);
	validateParams(false, policy, getSerial110AC(), getQty110AC(), getSerial10C(), getQty10C(), "110AC", errors);
	validateParams(false, policy, getSerial110BA(), getQty110BA(), getSerial20A(), getQty20A(), "110BA", errors);
	if (isCross20)
		validateParams(false, policy, getSerial110BB(), getQty110BB(), getSerial20A(), getQty20A(), "110BB", errors);
	else
		validateParams(false, policy, getSerial110BB(), getQty110BB(), getSerial20B(), getQty20B(), "110BB", errors);
	validateParams(false, policy, getSerial110BC(), getQty110BC(), getSerial20C(), getQty20C(), "110BC", errors);
	validateParams(false, policy, getSerial110CA(), getQty110CA(), getSerial30A(), getQty30A(), "110CA", errors);
	if (isCross30)
		validateParams(false, policy, getSerial110CB(), getQty110CB(), getSerial30A(), getQty30A(), "110CB", errors);
	else
		validateParams(false, policy, getSerial110CB(), getQty110CB(), getSerial30B(), getQty30B(), "110CB", errors);
	validateParams(false, policy, getSerial110CC(), getQty110CC(), getSerial30C(), getQty30C(), "110CC", errors);
	validateParams(false, policy, getSerial110DA(), getQty110DA(), getSerial40A(), getQty40A(), "110DA", errors);
	if (isCross40)
		validateParams(false, policy, getSerial110DB(), getQty110DB(), getSerial40A(), getQty40A(), "110DB", errors);
	else
		validateParams(false, policy, getSerial110DB(), getQty110DB(), getSerial40B(), getQty40B(), "110DB", errors);
	validateParams(false, policy, getSerial110DC(), getQty110DC(), getSerial40C(), getQty40C(), "110DC", errors);
	
	policy = validateResource(false, getResource120(), "120", errors);
	validateParams(false, policy, getSerial120AA(), getQty120AA(), getSerial10A(), getQty10A(), "120AA", errors);
	if (isCross10)
		validateParams(false, policy, getSerial120AB(), getQty120AB(), getSerial10A(), getQty10A(), "120AB", errors);
	else
		validateParams(false, policy, getSerial120AB(), getQty120AB(), getSerial10B(), getQty10B(), "120AB", errors);
	validateParams(false, policy, getSerial120AC(), getQty120AC(), getSerial10C(), getQty10C(), "120AC", errors);
	validateParams(false, policy, getSerial120BA(), getQty120BA(), getSerial20A(), getQty20A(), "120BA", errors);
	if (isCross20)
		validateParams(false, policy, getSerial120BB(), getQty120BB(), getSerial20A(), getQty20A(), "120BB", errors);
	else
		validateParams(false, policy, getSerial120BB(), getQty120BB(), getSerial20B(), getQty20B(), "120BB", errors);
	validateParams(false, policy, getSerial120BC(), getQty120BC(), getSerial20C(), getQty20C(), "120BC", errors);
	validateParams(false, policy, getSerial120CA(), getQty120CA(), getSerial30A(), getQty30A(), "120CA", errors);
	if (isCross30)
		validateParams(false, policy, getSerial120CB(), getQty120CB(), getSerial30A(), getQty30A(), "120CB", errors);
	else
		validateParams(false, policy, getSerial120CB(), getQty120CB(), getSerial30B(), getQty30B(), "120CB", errors);
	validateParams(false, policy, getSerial120CC(), getQty120CC(), getSerial30C(), getQty30C(), "120CC", errors);
	validateParams(false, policy, getSerial120DA(), getQty120DA(), getSerial40A(), getQty40A(), "120DA", errors);
	if (isCross40)
		validateParams(false, policy, getSerial120DB(), getQty120DB(), getSerial40A(), getQty40A(), "120DB", errors);
	else
		validateParams(false, policy, getSerial120DB(), getQty120DB(), getSerial40B(), getQty40B(), "120DB", errors);
	validateParams(false, policy, getSerial120DC(), getQty120DC(), getSerial40C(), getQty40C(), "120DC", errors);

	// Проверим подрядчика
	si.setString(getProvidercode());
	if (si.isEmpty())
		errors.add("podr", new ActionError("error.mountact2.empty.podrcode"));
	else
		if (!si.isOk())
			errors.add("podr", new ActionError("error.mountact2.bad.podrcode"));
		else {
			try {
				OrganizationAccessBean org = new OrganizationAccessBean();
				org.setInitKey_organization(si.getInteger().intValue());
				org.refreshCopyHelper();
				setProvidername(org.getName());
			} catch (Exception ee) {
				errors.add("podr", new ActionError("error.mountact2.bad.podrcode"));
			}
		}

	// Проверим ФИО подрядчика
	if ( (getInsuranceMan() == null) || (getInsuranceMan().trim().length() == 0) )
		errors.add("insman", new ActionError("error.mountact2.empty.insuranceman"));

	// Проверим сотрудника
	si.setString(getWorkercode());
	if (si.isEmpty())
		errors.add("worker", new ActionError("error.mountact2.empty.worker"));
	else	if (!si.isOk())
			errors.add("worker", new ActionError("error.mountact2.bad.worker"));
		else {
			try {
				WorkerAccessBean wrk = new WorkerAccessBean();
				wrk.setInitKey_worker(si.getInteger().intValue());
				wrk.refreshCopyHelper();
				PeopleAccessBean ppl = wrk.getMan();
				setWorkername(ppl.getLastname() + " " + ppl.getFirstname() + " " + ppl.getMiddlename());
				setWorkertitle(wrk.getPosition().getName());
			} catch (Exception ee) {
				errors.add("worker", new ActionError("error.mountact2.bad.worker"));
			}
		}
	if (!errors.empty()) {
		// Для вывода общего сообщения об ошибках
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mountact2.haveerrors"));
		throw new ValidationException();
	}
}
	/**
	 * @return
	 */
	public Integer getVisualtype() {
		return visualtype;
	}

	/**
	 * @param integer
	 */
	public void setVisualtype(Integer integer) {
		visualtype = integer;
	}
	
	public Integer getDocumentId() {
		return new Integer(document);
	}

}
