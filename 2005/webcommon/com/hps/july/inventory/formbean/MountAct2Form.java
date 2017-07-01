package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import org.apache.struts.taglib.template.GetTag;

import com.hps.july.logic.VisualDocTypes;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * Форма ввода акта монтажа блоков в виде сложного документа.
 * Creation date: (15.10.2004 17:26:12)
 * @author: Dmitry Dneprov
 */
public class MountAct2Form extends DocumentForm {
	private java.lang.String actdate;
	private java.lang.String posnumber;
	private java.lang.String serial10;
	private java.lang.String serial30;
	private java.lang.String serial20;
	private java.lang.String comment10;
	private java.lang.Integer ownercode;
	private int document;
	private java.lang.String comment20;
	private java.lang.String comment30;
	private java.lang.String qty20;
	private java.lang.String qty110;
	private java.lang.String qty100;
	private java.lang.String qty90;
	private java.lang.String qty80;
	private java.lang.String qty70;
	private java.lang.String qty75;
	private java.lang.String qty60;
	private java.lang.String qty50;
	private java.lang.String qty10;
	private java.lang.String qty30;
	private java.lang.String serial40;
	private java.lang.String serial50;
	private java.lang.String serial60;
	private java.lang.String serial70;
	private java.lang.String serial75;
	private java.lang.String serial80;
	private java.lang.String serial90;
	private java.lang.String serial100;
	private java.lang.String serial110;
	private java.lang.String comment40;
	private java.lang.String comment50;
	private java.lang.String comment60;
	private java.lang.String comment70;
	private java.lang.String comment75;
	private java.lang.String comment80;
	private java.lang.String comment90;
	private java.lang.String comment100;
	private java.lang.String comment110;
	private java.lang.String comment170;
	private java.lang.String comment180;
	private java.lang.String serial170;
	private java.lang.String serial180;
	private java.lang.String serial240;
	private java.lang.String serial270;
	private java.lang.String serial260;
	private java.lang.String serial250;
	private java.lang.String serial210;
	private java.lang.String serial220;
	private java.lang.String serial200;
	private java.lang.String serial190;
	private java.lang.String comment190;
	private java.lang.String comment200;
	private java.lang.String comment210;
	private java.lang.String comment220;
	private java.lang.String comment240;
	private java.lang.String comment270;
	private java.lang.String comment260;
	private java.lang.String comment250;
	private java.lang.String qty190;
	private java.lang.String qty180;
	private java.lang.String qty170;
	private java.lang.String qty200;
	private java.lang.String qty210;
	private java.lang.String qty240;
	private java.lang.String qty270;
	private java.lang.String qty260;
	private java.lang.String qty250;
	private java.lang.String qty220;
	private java.lang.Integer resource40;
	private java.lang.Integer resource240;
	private java.lang.Integer resource270;
	private java.lang.Integer resource260;
	private java.lang.Integer resource250;
	private java.lang.Integer resource210;
	private java.lang.Integer resource220;
	private java.lang.Integer resource200;
	private java.lang.Integer resource190;
	private java.lang.Integer resource180;
	private java.lang.Integer resource170;
	private java.lang.Integer resource110;
	private java.lang.Integer resource100;
	private java.lang.Integer resource90;
	private java.lang.Integer resource80;
	private java.lang.Integer resource30;
	private java.lang.Integer resource20;
	private java.lang.Integer resource10;
	private java.lang.Integer resource50;
	private java.lang.Integer resource60;
	private java.lang.Integer resource70;
	private java.lang.Integer resource75;
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
	private java.lang.String qty40;
	private java.lang.Boolean isAdmin;
	private int refreshFields;
	private int positioncode;
	private java.util.ArrayList bsList = new java.util.ArrayList();
	private java.lang.Integer projectid;
	private java.lang.String projectname;
	private boolean needapprove;
	private java.lang.String readprjstatus;
	private String dstate;
	private Integer visualtype;
	private String vistypename;

	public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request)
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
	
	public Integer getDocumentId() {
		return new Integer(document);
	}

	/**
	 * Метод для поиска текущей записи.
	 * Creation date: (13.02.2002 10:12:41)
	 */
	public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
		throws Exception
	{
		InternalWayBillAccessBean abean = new InternalWayBillAccessBean();
		abean.setInitKey_document(getDocument());
		return abean;	
	}
	
	protected void fillPosition(CDBCRowObject ro) {
		// Filling position data
		Integer visualtagid = (Integer)ro.getColumn("visualtagid").asObject();
		Integer resource = (Integer)ro.getColumn("resource").asObject();
		String serial = ro.getColumn("serialnumber").asString();
		String qty = ro.getColumn("qty").asString();
		String comment = ro.getColumn("comment").asString();
		if (visualtagid != null) {
			switch (visualtagid.intValue()) {
				case 10: setResource10(resource); setSerial10(serial); setQty10(qty); setComment10(comment); break;
				case 20: setResource20(resource); setSerial20(serial); setQty20(qty); setComment20(comment); break;
				case 30: setResource30(resource); setSerial30(serial); setQty30(qty); setComment30(comment); break;
				case 40: setResource40(resource); setSerial40(serial); setQty40(qty); setComment40(comment); break;
				case 50: setResource50(resource); setSerial50(serial); setQty50(qty); setComment50(comment); break;
				case 60: setResource60(resource); setSerial60(serial); setQty60(qty); setComment60(comment); break;
				case 70: setResource70(resource); setSerial70(serial); setQty70(qty); setComment70(comment); break;
				case 75: setResource75(resource); setSerial75(serial); setQty75(qty); setComment75(comment); break;
				case 80: setResource80(resource); setSerial80(serial); setQty80(qty); setComment80(comment); break;
				case 90: setResource90(resource); setSerial90(serial); setQty90(qty); setComment90(comment); break;
				case 100: setResource100(resource); setSerial100(serial); setQty100(qty); setComment100(comment); break;
				case 110: setResource110(resource); setSerial110(serial); setQty110(qty); setComment110(comment); break;
				case 170: setResource170(resource); setSerial170(serial); setQty170(qty); setComment170(comment); break;
				case 180: setResource180(resource); setSerial180(serial); setQty180(qty); setComment180(comment); break;
				case 190: setResource190(resource); setSerial190(serial); setQty190(qty); setComment190(comment); break;
				case 200: setResource200(resource); setSerial200(serial); setQty200(qty); setComment200(comment); break;
				case 210: setResource210(resource); setSerial210(serial); setQty210(qty); setComment210(comment); break;
				case 220: setResource220(resource); setSerial220(serial); setQty220(qty); setComment220(comment); break;
				case 240: setResource240(resource); setSerial240(serial); setQty240(qty); setComment240(comment); break;
				case 250: setResource250(resource); setSerial250(serial); setQty250(qty); setComment250(comment); break;
				case 260: setResource260(resource); setSerial260(serial); setQty260(qty); setComment260(comment); break;
				case 270: setResource270(resource); setSerial270(serial); setQty270(qty); setComment270(comment); break;
			}
		}
	}

	/**
	 * Метод для вычисления полей перед отображением.
	 * Creation date: (13.02.2002 10:27:25)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void fillRecord(AbstractEntityAccessBean bean) {
		try {
			InternalWayBillAccessBean abean = (InternalWayBillAccessBean)bean;
			
			StringAndIntegerProperty bi = new StringAndIntegerProperty();
			bi.setInteger(new Integer(abean.getBlankindex()));
			setPosnumber(bi.getString());
			
			StringAndSqlDateProperty bd = new StringAndSqlDateProperty();
			bd.setSqlDate(abean.getBlankdate());
			setActdate(bd.getString());
			
			ExpeditionAccessBean exped = new ExpeditionAccessBean();
			exped.setInitKey_storageplace(abean.getFromKey().storageplace);
			exped.refreshCopyHelper();
			
			setProvidercode(new Integer(exped.getOrganization().getOrganization()).toString());
			setProvidername(exped.getOrganization().getName()); 
			
			setOwnercode(new Integer(abean.getOwnerKey().organization));
			setComplectcode(new Integer(abean.getTo().getStorageplace()));
			setComplectname(abean.getTo().getName());
			
			setNeedapprove(abean.getNeedapprove());
			setProjectid(abean.getProjectid());
			setProjectname("");
			setInsuranceMan(abean.getInsuranseMan());
			
			setWorkercode(new Integer(abean.getMonter().getWorker()).toString());
			setWorkername(abean.getMonter().getMan().getLastname() + " " +
			  abean.getMonter().getMan().getFirstname() + " " +
			  abean.getMonter().getMan().getMiddlename());
			  
			setDState(abean.getDocumentState());
			setProcessState("");
			setVisualtype(abean.getVisualtype());
			  
			CDBCDocuments d = new CDBCDocuments();
			CDBCResultSet rs = d.listAllMountItems(new Integer(abean.getDocument()), new Integer(1));
			ListIterator it = rs.listIterator();
			while (it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				fillPosition(ro);
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
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
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getBasestationres() {
	return  com.hps.july.logic.InputCategoryObject.listCategoryResourcesGSMBS(new Integer(36));
/*	
	return  new CDBCResourcesObject().findBasestationResources(
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		Boolean.FALSE, null,
		"*",
		Boolean.FALSE, null,
		new Integer(3));
		*/
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2005 16:49:54)
 * @return java.util.List
 */
public java.util.ArrayList getBsList() {
	return bsList;
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public String getCategoryId(int i) {
	String result = ""; 
	
	switch (i) {
		case 10: {
			result = "1"; break;		
		}case 20: {
			result = "2"; break;		
		}case 30: {
			result = "3"; break;		
		}case 40: {
			result = "36"; break;		
		}case 50: {
			result = "36"; break;		
		}case 60: {
			result = "36"; break;		
		}case 70: {
			result = "36"; break;		
		}case 75: {
			result = "36"; break;		
		}case 80: {
			result = "4"; break;		
		}case 90: {
			result = "5"; break;		
		}case 100: {
			result = "6"; break;		
		}case 110: {
			result = "7"; break;		
		}case 170: {
			result = "8"; break;		
		}case 180: {
			result = "9"; break;		
		}case 190: {
			result = "10"; break;		
		}case 200: {
			result = "11"; break;		
		}case 210: {
			result = "12"; break;		
		}case 220: {
			result = "12"; break;		
		}case 240: {
			result = "13"; break;		
		}case 250: {
			result = "13"; break;		
		}case 260: {
			result = "37"; break;		
		}case 270: {
			result = "37"; break;		
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
	return  getCategoryResources(new Integer(1));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources100() {
	return  getCategoryResources(new Integer(6));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources110() {
	return  getCategoryResources(new Integer(7));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources170() {
	return  getCategoryResources(new Integer(8));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources180() {
	return  getCategoryResources(new Integer(9));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources190() {
	return  getCategoryResources(new Integer(10));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources20() {
	return  getCategoryResources(new Integer(2));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources200() {
	return  getCategoryResources(new Integer(11));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources210() {
	return  getCategoryResources(new Integer(12));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources220() {
	return  getCategoryResources(new Integer(12));
}
/**
 * Выдает список ресурсов указанной категории.
 * PDA-1
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources240() {
	return  getCategoryResources(new Integer(13));
}
/**
 * Выдает список ресурсов указанной категории.
 * PDA-2
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources250() {
	return  getCategoryResources(new Integer(13));
}
/**
 * Выдает список ресурсов указанной категории.
 * Инжектор-1
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources260() {
	return  getCategoryResources(new Integer(37));
}
/**
 * Выдает список ресурсов указанной категории.
 * Инжектор-2
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources270() {
	return  getCategoryResources(new Integer(37));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources30() {
	return  getCategoryResources(new Integer(3));
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources40() {
	return  getBasestationres();
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources50() {
	return  getBasestationres();
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources60() {
	return  getBasestationres();
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources70() {
	return  getBasestationres();
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources75() {
	return  getBasestationres();
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources80() {
	return  getCategoryResources(new Integer(4));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources90() {
	return  getCategoryResources(new Integer(5));
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:39:04)
 * @return java.lang.String
 */
public java.lang.String getComment10() {
	return comment10;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:47:14)
 * @return java.lang.String
 */
public java.lang.String getComment100() {
	return comment100;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:47:27)
 * @return java.lang.String
 */
public java.lang.String getComment110() {
	return comment110;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:48:18)
 * @return java.lang.String
 */
public java.lang.String getComment170() {
	return comment170;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:48:31)
 * @return java.lang.String
 */
public java.lang.String getComment180() {
	return comment180;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:49:42)
 * @return java.lang.String
 */
public java.lang.String getComment190() {
	return comment190;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:12:22)
 * @return java.lang.String
 */
public java.lang.String getComment20() {
	return comment20;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:49:55)
 * @return java.lang.String
 */
public java.lang.String getComment200() {
	return comment200;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:50:07)
 * @return java.lang.String
 */
public java.lang.String getComment210() {
	return comment210;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 18:43:10)
 * @return java.lang.String
 */
public java.lang.String getComment220() {
	return comment220;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:50:47)
 * @return java.lang.String
 */
public java.lang.String getComment240() {
	return comment240;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:50)
 * @return java.lang.String
 */
public java.lang.String getComment250() {
	return comment250;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:50)
 * @return java.lang.String
 */
public java.lang.String getComment260() {
	return comment260;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:50)
 * @return java.lang.String
 */
public java.lang.String getComment270() {
	return comment270;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:13:11)
 * @return java.lang.String
 */
public java.lang.String getComment30() {
	return comment30;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:01)
 * @return java.lang.String
 */
public java.lang.String getComment40() {
	return comment40;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:14)
 * @return java.lang.String
 */
public java.lang.String getComment50() {
	return comment50;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:26)
 * @return java.lang.String
 */
public java.lang.String getComment60() {
	return comment60;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:38)
 * @return java.lang.String
 */
public java.lang.String getComment70() {
	return comment70;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2004 01:56:25)
 * @return java.lang.String
 */
public java.lang.String getComment75() {
	return comment75;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:50)
 * @return java.lang.String
 */
public java.lang.String getComment80() {
	return comment80;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:47:01)
 * @return java.lang.String
 */
public java.lang.String getComment90() {
	return comment90;
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
 * Creation date: (15.10.2004 18:05:17)
 * @return int
 */
public int getDocument() {
	return document;
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
 * Creation date: (29.11.2004 12:37:37)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAdmin() {
	return isAdmin;
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
 * Creation date: (09.09.2005 14:57:49)
 * @return java.lang.Integer
 */
public Integer getPoscode() {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2005 16:34:43)
 * @return int
 */
public int getPositioncode() {
	return positioncode;
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
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty10() {
	return qty10;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty100() {
	return qty100;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty110() {
	return qty110;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty170() {
	return qty170;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty180() {
	return qty180;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:51:28)
 * @return java.lang.String
 */
public java.lang.String getQty190() {
	return qty190;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:15:32)
 * @return java.lang.String
 */
public java.lang.String getQty20() {
	return qty20;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:51:48)
 * @return java.lang.String
 */
public java.lang.String getQty200() {
	return qty200;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:52:02)
 * @return java.lang.String
 */
public java.lang.String getQty210() {
	return qty210;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 18:43:10)
 * @return java.lang.String
 */
public java.lang.String getQty220() {
	return qty220;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty240() {
	return qty240;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:11)
 * @return java.lang.String
 */
public java.lang.String getQty250() {
	return qty250;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:11)
 * @return java.lang.String
 */
public java.lang.String getQty260() {
	return qty260;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:11)
 * @return java.lang.String
 */
public java.lang.String getQty270() {
	return qty270;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:15:47)
 * @return java.lang.String
 */
public java.lang.String getQty30() {
	return qty30;
}
/**
 * Insert the method's description here.
 * Creation date: (25.10.2004 11:06:58)
 * @return java.lang.String
 */
public java.lang.String getQty40() {
	return qty40;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty50() {
	return qty50;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty60() {
	return qty60;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty70() {
	return qty70;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2004 01:56:49)
 * @return java.lang.String
 */
public java.lang.String getQty75() {
	return qty75;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty80() {
	return qty80;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty90() {
	return qty90;
}

/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 14:50:54)
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
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource170() {
	return resource170;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource180() {
	return resource180;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource190() {
	return resource190;
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
public java.lang.Integer getResource200() {
	return resource200;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource210() {
	return resource210;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 18:43:10)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource220() {
	return resource220;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource240() {
	return resource240;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:27:35)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource250() {
	return resource250;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:27:35)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource260() {
	return resource260;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:27:35)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource270() {
	return resource270;
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
 * Creation date: (16.10.2004 00:15:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource50() {
	return resource50;
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
 * Creation date: (24.12.2004 01:57:13)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource75() {
	return resource75;
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
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial10() {
	return serial10;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial100() {
	return serial100;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial110() {
	return serial110;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial170() {
	return serial170;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial180() {
	return serial180;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial190() {
	return serial190;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial20() {
	return serial20;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial200() {
	return serial200;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial210() {
	return serial210;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 18:43:10)
 * @return java.lang.String
 */
public java.lang.String getSerial220() {
	return serial220;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial240() {
	return serial240;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:26:57)
 * @return java.lang.String
 */
public java.lang.String getSerial250() {
	return serial250;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:26:57)
 * @return java.lang.String
 */
public java.lang.String getSerial260() {
	return serial260;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:26:57)
 * @return java.lang.String
 */
public java.lang.String getSerial270() {
	return serial270;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial30() {
	return serial30;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial40() {
	return serial40;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial50() {
	return serial50;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial60() {
	return serial60;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial70() {
	return serial70;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2004 01:57:39)
 * @return java.lang.String
 */
public java.lang.String getSerial75() {
	return serial75;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial80() {
	return serial80;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial90() {
	return serial90;
}
/**
 * Текущее состояние приложения.
 * Creation date: (15.10.2004 17:26:12)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.MOUNTEDIT2;
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
 * Insert the method's description here.
 * Creation date: (07.09.2005 16:48:39)
 */
private void initBsList() {
    CDBCResultSet res = CDBCBaseStationObject.getBSResSetFromPosition(getPositioncode(), null);
	Iterator it = res.listIterator();
	while(it.hasNext()) {	
		BsVO bs = new BsVO();	
		CDBCRowObject ro = (CDBCRowObject)it.next();
		String number = ro.getColumn("number").asString();		
		String type = ro.getColumn("type").asString();
		String name = ro.getColumn("name").asString();
		bs.setName(number + "    " + type + "  " + name);
		bs.setType(new Integer(number));
		bsList.add(bs);
	}
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    setManycomplects(false);
    setComplectcode(null);
    setOldposnumber("");
    int defOwner = com.hps.july.util.AppUtils.getNamedValueInt("INVENTORY_DEFOWNER");
    if (defOwner != 0)
    setOwnercode(new Integer(defOwner));
    initBsList();
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
 * Creation date: (15.10.2004 17:32:15)
 * @param newActdate java.lang.String
 */
public void setActdate(java.lang.String newActdate) {
	actdate = newActdate;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 17:39:04)
 * @param newComment10 java.lang.String
 */
public void setComment10(java.lang.String newComment10) {
	comment10 = newComment10;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:47:14)
 * @param newComment100 java.lang.String
 */
public void setComment100(java.lang.String newComment100) {
	comment100 = newComment100;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:47:27)
 * @param newComment110 java.lang.String
 */
public void setComment110(java.lang.String newComment110) {
	comment110 = newComment110;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:48:18)
 * @param newComment170 java.lang.String
 */
public void setComment170(java.lang.String newComment170) {
	comment170 = newComment170;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:48:31)
 * @param newComment180 java.lang.String
 */
public void setComment180(java.lang.String newComment180) {
	comment180 = newComment180;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:49:42)
 * @param newComment190 java.lang.String
 */
public void setComment190(java.lang.String newComment190) {
	comment190 = newComment190;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:12:22)
 * @param newComment20 java.lang.String
 */
public void setComment20(java.lang.String newComment20) {
	comment20 = newComment20;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:49:55)
 * @param newComment200 java.lang.String
 */
public void setComment200(java.lang.String newComment200) {
	comment200 = newComment200;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:50:07)
 * @param newComment210 java.lang.String
 */
public void setComment210(java.lang.String newComment210) {
	comment210 = newComment210;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 18:43:10)
 * @param newComment220 java.lang.String
 */
public void setComment220(java.lang.String newComment220) {
	comment220 = newComment220;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:50:47)
 * @param newComment240 java.lang.String
 */
public void setComment240(java.lang.String newComment240) {
	comment240 = newComment240;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:50)
 * @param newComment250 java.lang.String
 */
public void setComment250(java.lang.String newComment250) {
	comment250 = newComment250;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:50)
 * @param newComment260 java.lang.String
 */
public void setComment260(java.lang.String newComment260) {
	comment260 = newComment260;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:50)
 * @param newComment270 java.lang.String
 */
public void setComment270(java.lang.String newComment270) {
	comment270 = newComment270;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:13:11)
 * @param newComment30 java.lang.String
 */
public void setComment30(java.lang.String newComment30) {
	comment30 = newComment30;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:01)
 * @param newComment40 java.lang.String
 */
public void setComment40(java.lang.String newComment40) {
	comment40 = newComment40;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:14)
 * @param newComment50 java.lang.String
 */
public void setComment50(java.lang.String newComment50) {
	comment50 = newComment50;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:26)
 * @param newComment60 java.lang.String
 */
public void setComment60(java.lang.String newComment60) {
	comment60 = newComment60;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:38)
 * @param newComment70 java.lang.String
 */
public void setComment70(java.lang.String newComment70) {
	comment70 = newComment70;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2004 01:56:25)
 * @param newComment75 java.lang.String
 */
public void setComment75(java.lang.String newComment75) {
	comment75 = newComment75;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:46:50)
 * @param newComment80 java.lang.String
 */
public void setComment80(java.lang.String newComment80) {
	comment80 = newComment80;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:47:01)
 * @param newComment90 java.lang.String
 */
public void setComment90(java.lang.String newComment90) {
	comment90 = newComment90;
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
 * Creation date: (15.10.2004 18:05:17)
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
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
 * Creation date: (29.11.2004 12:37:37)
 * @param newIsAdmin java.lang.Boolean
 */
public void setIsAdmin(java.lang.Boolean newIsAdmin) {
	isAdmin = newIsAdmin;
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
 * Creation date: (07.09.2005 16:34:43)
 * @param newPositioncode int
 */
public void setPositioncode(int newPositioncode) {
	positioncode = newPositioncode;
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
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty10 java.lang.String
 */
public void setQty10(java.lang.String newQty10) {
	qty10 = newQty10;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty100 java.lang.String
 */
public void setQty100(java.lang.String newQty100) {
	qty100 = newQty100;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty110 java.lang.String
 */
public void setQty110(java.lang.String newQty110) {
	qty110 = newQty110;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty170 java.lang.String
 */
public void setQty170(java.lang.String newQty170) {
	qty170 = newQty170;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty180 java.lang.String
 */
public void setQty180(java.lang.String newQty180) {
	qty180 = newQty180;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:51:28)
 * @param newQty190 java.lang.String
 */
public void setQty190(java.lang.String newQty190) {
	qty190 = newQty190;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:15:32)
 * @param newQty20 java.lang.String
 */
public void setQty20(java.lang.String newQty20) {
	qty20 = newQty20;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:51:48)
 * @param newQty200 java.lang.String
 */
public void setQty200(java.lang.String newQty200) {
	qty200 = newQty200;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:52:02)
 * @param newQty210 java.lang.String
 */
public void setQty210(java.lang.String newQty210) {
	qty210 = newQty210;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 18:43:10)
 * @param newQty220 java.lang.String
 */
public void setQty220(java.lang.String newQty220) {
	qty220 = newQty220;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty240 java.lang.String
 */
public void setQty240(java.lang.String newQty240) {
	qty240 = newQty240;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:11)
 * @param newQty250 java.lang.String
 */
public void setQty250(java.lang.String newQty250) {
	qty250 = newQty250;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:11)
 * @param newQty260 java.lang.String
 */
public void setQty260(java.lang.String newQty260) {
	qty260 = newQty260;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:28:11)
 * @param newQty270 java.lang.String
 */
public void setQty270(java.lang.String newQty270) {
	qty270 = newQty270;
}
/**
 * Insert the method's description here.
 * Creation date: (15.10.2004 23:15:47)
 * @param newQty30 java.lang.String
 */
public void setQty30(java.lang.String newQty30) {
	qty30 = newQty30;
}
/**
 * Insert the method's description here.
 * Creation date: (25.10.2004 11:06:58)
 * @param newQty40 java.lang.String
 */
public void setQty40(java.lang.String newQty40) {
	qty40 = newQty40;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty50 java.lang.String
 */
public void setQty50(java.lang.String newQty50) {
	qty50 = newQty50;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty60 java.lang.String
 */
public void setQty60(java.lang.String newQty60) {
	qty60 = newQty60;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty70 java.lang.String
 */
public void setQty70(java.lang.String newQty70) {
	qty70 = newQty70;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2004 01:56:49)
 * @param newQty75 java.lang.String
 */
public void setQty75(java.lang.String newQty75) {
	qty75 = newQty75;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty80 java.lang.String
 */
public void setQty80(java.lang.String newQty80) {
	qty80 = newQty80;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty90 java.lang.String
 */
public void setQty90(java.lang.String newQty90) {
	qty90 = newQty90;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2005 17:00:15)
 * @param newReadprjstatus java.lang.String
 */
public void setReadprjstatus(java.lang.String newReadprjstatus) {
	readprjstatus = newReadprjstatus;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 14:50:54)
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
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource170 java.lang.Integer
 */
public void setResource170(java.lang.Integer newResource170) {
	resource170 = newResource170;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource180 java.lang.Integer
 */
public void setResource180(java.lang.Integer newResource180) {
	resource180 = newResource180;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource190 java.lang.Integer
 */
public void setResource190(java.lang.Integer newResource190) {
	resource190 = newResource190;
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
 * @param newResource200 java.lang.Integer
 */
public void setResource200(java.lang.Integer newResource200) {
	resource200 = newResource200;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource210 java.lang.Integer
 */
public void setResource210(java.lang.Integer newResource210) {
	resource210 = newResource210;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 18:43:10)
 * @param newResource220 java.lang.Integer
 */
public void setResource220(java.lang.Integer newResource220) {
	resource220 = newResource220;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource240 java.lang.Integer
 */
public void setResource240(java.lang.Integer newResource240) {
	resource240 = newResource240;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:27:35)
 * @param newResource250 java.lang.Integer
 */
public void setResource250(java.lang.Integer newResource250) {
	resource250 = newResource250;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:27:35)
 * @param newResource260 java.lang.Integer
 */
public void setResource260(java.lang.Integer newResource260) {
	resource260 = newResource260;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:27:35)
 * @param newResource270 java.lang.Integer
 */
public void setResource270(java.lang.Integer newResource270) {
	resource270 = newResource270;
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
 * Creation date: (16.10.2004 00:15:25)
 * @param newResource50 java.lang.Integer
 */
public void setResource50(java.lang.Integer newResource50) {
	resource50 = newResource50;
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
 * Creation date: (24.12.2004 01:57:13)
 * @param newResource75 java.lang.Integer
 */
public void setResource75(java.lang.Integer newResource75) {
	resource75 = newResource75;
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
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial10 java.lang.String
 */
public void setSerial10(java.lang.String newSerial10) {
	serial10 = newSerial10;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial100 java.lang.String
 */
public void setSerial100(java.lang.String newSerial100) {
	serial100 = newSerial100;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial110 java.lang.String
 */
public void setSerial110(java.lang.String newSerial110) {
	serial110 = newSerial110;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial170 java.lang.String
 */
public void setSerial170(java.lang.String newSerial170) {
	serial170 = newSerial170;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial180 java.lang.String
 */
public void setSerial180(java.lang.String newSerial180) {
	serial180 = newSerial180;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial190 java.lang.String
 */
public void setSerial190(java.lang.String newSerial190) {
	serial190 = newSerial190;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial20 java.lang.String
 */
public void setSerial20(java.lang.String newSerial20) {
	serial20 = newSerial20;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial200 java.lang.String
 */
public void setSerial200(java.lang.String newSerial200) {
	serial200 = newSerial200;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial210 java.lang.String
 */
public void setSerial210(java.lang.String newSerial210) {
	serial210 = newSerial210;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2004 18:43:10)
 * @param newSerial220 java.lang.String
 */
public void setSerial220(java.lang.String newSerial220) {
	serial220 = newSerial220;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial240 java.lang.String
 */
public void setSerial240(java.lang.String newSerial240) {
	serial240 = newSerial240;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:26:57)
 * @param newSerial250 java.lang.String
 */
public void setSerial250(java.lang.String newSerial250) {
	serial250 = newSerial250;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:26:57)
 * @param newSerial260 java.lang.String
 */
public void setSerial260(java.lang.String newSerial260) {
	serial260 = newSerial260;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 11:26:57)
 * @param newSerial270 java.lang.String
 */
public void setSerial270(java.lang.String newSerial270) {
	serial270 = newSerial270;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial30 java.lang.String
 */
public void setSerial30(java.lang.String newSerial30) {
	serial30 = newSerial30;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial40 java.lang.String
 */
public void setSerial40(java.lang.String newSerial40) {
	serial40 = newSerial40;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial50 java.lang.String
 */
public void setSerial50(java.lang.String newSerial50) {
	serial50 = newSerial50;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial60 java.lang.String
 */
public void setSerial60(java.lang.String newSerial60) {
	serial60 = newSerial60;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial70 java.lang.String
 */
public void setSerial70(java.lang.String newSerial70) {
	serial70 = newSerial70;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2004 01:57:39)
 * @param newSerial75 java.lang.String
 */
public void setSerial75(java.lang.String newSerial75) {
	serial75 = newSerial75;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial80 java.lang.String
 */
public void setSerial80(java.lang.String newSerial80) {
	serial80 = newSerial80;
}
/**
 * Insert the method's description here.
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial90 java.lang.String
 */
public void setSerial90(java.lang.String newSerial90) {
	serial90 = newSerial90;
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
public void validateResource(Integer argResource, String argSerial, String argQty, String argMsgKey, ActionErrors errors) {
	
	String editPos = "resource" + argMsgKey;
	
	// Проверим заполнение обоих полей или что оба незаполнены
	if  (argResource == null)
		return;

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

	if ("S".equals(policy)) {
		editPos = "serial" + argMsgKey;
		if  ( (argSerial == null) || (argSerial.trim().length() == 0) ) 
			errors.add(editPos, new ActionError("error.mountact2.empty.serial"));
	} else if ("P".equals(policy)) {
		editPos = "serial" + argMsgKey;
		if  ( (argSerial == null) || (argSerial.trim().length() == 0) ) 
			errors.add(editPos, new ActionError("error.mountact2.empty.party"));
	} else if ("B".equals(policy)) {
		editPos = "serial" + argMsgKey;
		if  ( (argQty == null) || (argQty.trim().length() == 0) )
			errors.add(editPos, new ActionError("error.mountact2.empty.qty"));
		else {
			// Проверим количество
			com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sb = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 3);
			sb.setString(argQty);
			if (!sb.isOk())
				errors.add(editPos, new ActionError("error.mountact2.bad.qty"));
		}
	}
}
/**
 * Метод для проверки правильности ввода значений в поля ввода.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException - 
 * при этом исключении ошибки отображаются пользователю.
 */
public void validateValues(ActionErrors errors) throws Exception {

	if (!"C".equalsIgnoreCase(getProcessState())) {
		StringAndIntegerProperty si = new StringAndIntegerProperty();
		StringAndIntegerProperty di = new StringAndIntegerProperty();
		
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
					//System.out.println("MACT2: RESULT ROWS=" + res.getRowsCount());
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
			
		validateResource(getResource10(), getSerial10(), getQty10(), "10", errors);
		validateResource(getResource20(), getSerial20(), getQty20(), "20", errors);
		validateResource(getResource30(), getSerial30(), getQty30(), "30", errors);
		validateResource(getResource40(), getSerial40(), getQty40(), "40", errors);
		validateResource(getResource50(), getSerial50(), getQty50(), "50", errors);
		validateResource(getResource60(), getSerial60(), getQty60(), "60", errors);
		validateResource(getResource70(), getSerial70(), getQty70(), "70", errors);
		validateResource(getResource75(), getSerial75(), getQty75(), "75", errors);
		validateResource(getResource80(), getSerial80(), getQty80(), "80", errors);
		validateResource(getResource90(), getSerial90(), getQty90(), "90", errors);
		validateResource(getResource100(), getSerial100(), getQty100(), "100", errors);
		validateResource(getResource110(), getSerial110(), getQty110(), "110", errors);
		validateResource(getResource170(), getSerial170(), getQty170(), "170", errors);
		validateResource(getResource180(), getSerial180(), getQty180(), "180", errors);
		validateResource(getResource190(), getSerial190(), getQty190(), "190", errors);
		validateResource(getResource200(), getSerial200(), getQty200(), "200", errors);
		validateResource(getResource210(), getSerial210(), getQty210(), "210", errors);
		validateResource(getResource220(), getSerial220(), getQty210(), "220", errors);
		validateResource(getResource240(), getSerial240(), getQty240(), "240", errors);
		validateResource(getResource250(), getSerial250(), getQty250(), "250", errors);
		validateResource(getResource260(), getSerial260(), getQty260(), "260", errors);
		validateResource(getResource270(), getSerial270(), getQty270(), "270", errors);
	
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
		StringAndSqlDateProperty ad = new StringAndSqlDateProperty();
		ad.setString(actdate);
		if (ad.isEmpty())
			errors.add("actdate", new ActionError("error.mountact2.empty.actdate"));
	}
	if (!errors.empty()) {
		// Для вывода общего сообщения об ошибках
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mountact2.haveerrors"));
		throw new ValidationException();
	}
}

/*
	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String string) {
		processState = string;
	}

	public Boolean getWarnProc() {
		return warnProc;
	}

	public void setWarnProc(Boolean boolean1) {
		warnProc = boolean1;
	}
*/

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
		setVistypename("");
		 
		if (VisualDocTypes.BTS_MOUNT_ACT_ALCATEL.equals(visualtype)) {
			setVistypename("Alcatel");
		} else if (VisualDocTypes.BTS_MOUNT_ACT_ERIC.equals(visualtype)) {
			setVistypename("Ericsson"); 
		} else if (VisualDocTypes.BTS_MOUNT_ACT_NOKIA.equals(visualtype)) {
			setVistypename("Nokia"); 
		} else if (VisualDocTypes.BTS_MOUNT_ACT_SIEMENS.equals(visualtype)) {
			setVistypename("Siemens"); 
		} else if (VisualDocTypes.BTS_MOUNT_ACT_HUAWEI.equals(visualtype)) {
			setVistypename("Huawei"); 
		}
	}

	/**
	 * @return
	 */
	public String getVistypename() {
		return vistypename;
	}

	/**
	 * @param string
	 */
	public void setVistypename(String string) {
		vistypename = string;
	}

}
