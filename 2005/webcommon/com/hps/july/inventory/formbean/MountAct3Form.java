package com.hps.july.inventory.formbean;

import java.util.Iterator;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Vector;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * Форма ввода акта монтажа блоков в виде сложного документа.
 * Creation date: (15.10.2004 17:26:12)
 * @author: Dmitry Dneprov
 */
public class MountAct3Form extends com.hps.july.web.util.EditForm {
	private java.lang.String actdate;
	
	private java.lang.String oldposnumber;
	private java.lang.String posnumber;
	private String gsmidnumber;
	private String oldgsmnumber;
	private java.lang.Integer posbscode;
	private java.lang.String posbsname;
	
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
	private java.lang.String qty130;
	private java.lang.String qty120;
	private java.lang.String qty100;
	private java.lang.String qty90;
	private java.lang.String qty80;
	private java.lang.String qty85;
	private java.lang.String qty70;
	private java.lang.String qty60;
	private java.lang.String qty50;
	private java.lang.String qty10;
	private java.lang.String qty30;
	private java.lang.String serial40;
	private java.lang.String serial50;
	private java.lang.String serial60;
	private java.lang.String serial70;
	private java.lang.String serial80;
	private java.lang.String serial85;
	private java.lang.String serial90;
	private java.lang.String serial100;
	private java.lang.String serial110;
	private java.lang.String serial130;
	private java.lang.String serial120;
	private java.lang.String comment40;
	private java.lang.String comment50;
	private java.lang.String comment60;
	private java.lang.String comment70;
	private java.lang.String comment80;
	private java.lang.String comment85;
	private java.lang.String comment90;
	private java.lang.String comment100;
	private java.lang.String comment110;
	private java.lang.String comment130;
	private java.lang.String comment120;
	private java.lang.Integer resource40;
	private java.lang.Integer resource110;
	private java.lang.Integer resource130;
	private java.lang.Integer resource120;
	private java.lang.Integer resource100;
	private java.lang.Integer resource90;
	private java.lang.Integer resource80;
	private java.lang.Integer resource85;
	private java.lang.Integer resource30;
	private java.lang.Integer resource20;
	private java.lang.Integer resource10;
	private java.lang.Integer resource50;
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
	private boolean manypositions;
	private java.lang.String qty40;
	private java.lang.Boolean isAdmin;
	private int refreshFields;
	private java.lang.String type;
	private java.lang.String dtype;
	private int positioncode;
	private java.util.ArrayList cList = new java.util.ArrayList();
	private java.lang.Integer projectid;
	private java.lang.String projectname;
	private boolean needapprove;
	private java.lang.String readprjstatus;


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
 * Creation date: (09.09.2005 18:48:32)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getBsvList() {
	return cList;
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public String getCategoryId(int i) {
	String result = ""; 
	
	switch (i) {
		case 10: {
			result = "14"; break;		
		}case 20: {
			result = "15"; break;		
		}case 30: {
			result = "16"; break;		
		}case 40: {
			result = "17"; break;		
		}case 50: {
			result = "18"; break;		
		}case 60: {
			result = "19"; break;		
		}case 70: {
			result = "20"; break;		
		}case 80: {
			result = "21"; break;		
		}case 85: {
			result = "38"; break;		
		}case 90: {
			result = "22"; break;		
		}case 100: {
			result = "23"; break;		
		}case 110: {
			result = "24"; break;		
		}case 120: {
			result = "25"; break;		
		}case 130: {
			result = "26"; break;		
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
	return  getCategoryResources(new Integer(14));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources100() {
	return  getCategoryResources(new Integer(23));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources110() {
	return  getCategoryResources(new Integer(24));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources120() {
	return  getCategoryResources(new Integer(25));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources130() {
	return  getCategoryResources(new Integer(26));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources20() {
	return  getCategoryResources(new Integer(15));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources30() {
	return  getCategoryResources(new Integer(16));
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources40() {
	return  getCategoryResources(new Integer(17));
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources50() {
	return  getCategoryResources(new Integer(18));
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources60() {
	return  getCategoryResources(new Integer(19));
}
/**
 * Выдает список ресурсов типа базовая станция.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources70() {
	return  getCategoryResources(new Integer(20));
}
/**
 * Выдает список ресурсов указанной категории.
 * Панель коммутационная
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources80() {
	return  getCategoryResources(new Integer(21));
}
/**
 * Выдает список ресурсов указанной категории.
 * Панель сигнализации
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources85() {
	return  getCategoryResources(new Integer(38));
}
/**
 * Выдает список ресурсов указанной категории.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getCategoryResources90() {
	return  getCategoryResources(new Integer(22));
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2005 18:48:32)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getCList() {
	return cList;
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
 * Creation date: (29.10.2004 15:53:37)
 * @return java.lang.String
 */
public java.lang.String getComment120() {
	return comment120;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 15:53:37)
 * @return java.lang.String
 */
public java.lang.String getComment130() {
	return comment130;
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
 * Creation date: (15.10.2004 23:46:50)
 * @return java.lang.String
 */
public java.lang.String getComment80() {
	return comment80;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 12:00:31)
 * @return java.lang.String
 */
public java.lang.String getComment85() {
	return comment85;
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
	Integer num = new Integer(-100);
	try {
		num = new Integer(Integer.parseInt(getPosnumber()));
	} catch (Exception e) {
		num = null;
	}
/*
	if(posbscode != null) {
		if(complectcode != null) {
*/
			System.err.println("++++num:" + num);
			System.err.println("++++posbscode:" + posbscode);
			System.err.println("++++complectcode:" + complectcode);


			return new CDBCEquipmentObject().findActiveControllerLookup(
				new Boolean (num != null), num,
				new Boolean (posbscode != null), posbscode,
				new Boolean (complectcode != null), complectcode,
				new Integer(CDBCEquipmentObject.ORDER_NAME_ASC)
			);
/*
		} else {
			return new CDBCEquipmentObject().findActiveControllerLookup(
				Boolean.FALSE, 
				num,
				Boolean.TRUE,
				posbscode,
				new Integer(CDBCEquipmentObject.ORDER_NAME_ASC)
			);
		}
	} else {
		if(complectcode != null) {
			return new CDBCEquipmentObject().findActiveControllerLookup(
				Boolean.FALSE,
				num,
				Boolean.FALSE,
				posbscode,
				Boolean.TRUE,
				complectcode,
				new Integer(CDBCEquipmentObject.ORDER_NAME_ASC)
			);
		} else {
			return (new CDBCEquipmentObject()).findActiveControllerLookup(
				Boolean.TRUE,
				num,
				new Integer(CDBCEquipmentObject.ORDER_NAME_ASC)
			);
		}
	}
*/
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
 * Creation date: (03.06.2005 15:55:11)
 * @return java.lang.String
 */
public java.lang.String getDtype() {
	return dtype;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getGsmidnumber() {
	return gsmidnumber;
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
 * Creation date: (29.11.2004 12:38:21)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAdmin() {
	return isAdmin;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOldgsmnumber() {
	return oldgsmnumber;
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
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPosbscode() {
	return posbscode;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosbsname() {
	return posbsname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2005 18:30:51)
 * @return int
 */
public int getPositioncode() {
	return positioncode;
}
/**
 * Выдает список комплектов оборудования с заданным номером GSM.
 * Creation date: (18.10.2004 13:53:39)
 */
public CDBCResultSet getPositions() {
	Integer num = new Integer(0);
	try {
		num = new Integer(Integer.parseInt(getGsmidnumber()));
	} catch (Exception e) {
		// non-numeric....ignore
	}
	return (new CDBCPositionObject()).findPositionsLookup(
		Boolean.FALSE,		// java.lang.Boolean isNetZone,
		new Integer[] {},	// java.lang.Integer[] argNetZones,
		Boolean.TRUE,		// java.lang.Boolean isGsmId,
		getGsmidnumber(),	// java.lang.String argGsmId,
		Boolean.FALSE, "",	// java.lang.Boolean isDampsId,java.lang.String argDampsId,
		Boolean.FALSE, "",	// Boolean isName, java.lang.String argName,
		Boolean.FALSE, "",	// Boolean isBeenetid, java.lang.String argBeenetid,
		Boolean.FALSE, "",	// Boolean isAddr, java.lang.String argAddr,
		"",					// java.lang.String argRenterSearchType,
		new Integer(-1),	// java.lang.Integer argRenter,
		Boolean.FALSE,		// Boolean isResponsableWorker,
		new Integer(-1),	// Integer argResponsableWorker,
		com.hps.july.siteinfo.valueobject.Position.INACTION_All,			// String argInAction,
		"PE",				// String argPosstate,
		Boolean.FALSE,		// Boolean isRegions,
		new Integer[] {},	// Integer[] argRegions,
		Boolean.FALSE,		// Boolean isSupregs,
		new Integer[] {},	// Integer[] argSupregs,
    	getIsAdmin(),		// Boolean isAdmin,
		getUser(),			// String login,
		Boolean.FALSE,		// Boolean isTranspAll,
		Boolean.FALSE,		// Boolean isTranspRRL,
		Boolean.FALSE,		// Boolean isTranspVOT,
		Boolean.FALSE, "",	// Boolean isTranspID, java.lang.String argTranspId,
		Boolean.FALSE, "",  // Boolean isController, String argControllerNumber,
		Boolean.FALSE, "",	// Boolean isWLAN, String argWLANNumber,
		Boolean.FALSE, "",	// Boolean isRepeater, String argRepNumber,
		new Integer(1)		// java.lang.Integer order
	);
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
 * Creation date: (29.10.2004 15:54:09)
 * @return java.lang.String
 */
public java.lang.String getQty120() {
	return qty120;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 15:54:09)
 * @return java.lang.String
 */
public java.lang.String getQty130() {
	return qty130;
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
 * Creation date: (26.10.2004 18:48:40)
 * @return java.lang.String
 */
public java.lang.String getQty80() {
	return qty80;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 12:00:54)
 * @return java.lang.String
 */
public java.lang.String getQty85() {
	return qty85;
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
 * Creation date: (27.12.2004 14:51:13)
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
 * Creation date: (29.10.2004 15:54:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource120() {
	return resource120;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 15:54:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource130() {
	return resource130;
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
 * Creation date: (26.10.2004 18:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource80() {
	return resource80;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 12:01:13)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource85() {
	return resource85;
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
 * Creation date: (29.10.2004 15:55:05)
 * @return java.lang.String
 */
public java.lang.String getSerial120() {
	return serial120;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 15:55:05)
 * @return java.lang.String
 */
public java.lang.String getSerial130() {
	return serial130;
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
 * Creation date: (26.10.2004 18:51:24)
 * @return java.lang.String
 */
public java.lang.String getSerial80() {
	return serial80;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 12:01:35)
 * @return java.lang.String
 */
public java.lang.String getSerial85() {
	return serial85;
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
	return com.hps.july.inventory.APPStates.MOUNTEDIT3;
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
private void initCList() {
    CDBCResultSet res = CDBCBaseStationObject.getControllerResSetFromPosition(getPositioncode(), null);
	Iterator it = res.listIterator();
	while(it.hasNext()) {	
		BsVO bs = new BsVO();	
		CDBCRowObject ro = (CDBCRowObject)it.next();
		String number = ro.getColumn("number").asString();		
		String type = ro.getColumn("type").asString();
		String name = ro.getColumn("name").asString();
		bs.setName(number + "    " + type + "  " + name);
		bs.setType(new Integer(number));
		cList.add(bs);
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
	setDtype("F");
	int defOwner = com.hps.july.util.AppUtils.getNamedValueInt("INVENTORY_DEFOWNER");
	if (defOwner != 0)
		setOwnercode(new Integer(defOwner));
	initCList();
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
 * 
 * @return boolean
 */
public boolean isManypositions() {
	return manypositions;
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
 * Creation date: (29.10.2004 15:53:37)
 * @param newComment120 java.lang.String
 */
public void setComment120(java.lang.String newComment120) {
	comment120 = newComment120;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 15:53:37)
 * @param newComment130 java.lang.String
 */
public void setComment130(java.lang.String newComment130) {
	comment130 = newComment130;
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
 * Creation date: (15.10.2004 23:46:50)
 * @param newComment80 java.lang.String
 */
public void setComment80(java.lang.String newComment80) {
	comment80 = newComment80;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 12:00:31)
 * @param newComment85 java.lang.String
 */
public void setComment85(java.lang.String newComment85) {
	comment85 = newComment85;
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
 * Creation date: (03.06.2005 15:55:11)
 * @param newType java.lang.String
 */
public void setDtype(java.lang.String newType) {
	dtype = newType;
}
/**
 * 
 * @param newGsmidnumber java.lang.String
 */
public void setGsmidnumber(java.lang.String newGsmidnumber) {
	gsmidnumber = newGsmidnumber;
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
 * Creation date: (29.11.2004 12:38:21)
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
 * 
 * @param newManypositions boolean
 */
public void setManypositions(boolean newManypositions) {
	manypositions = newManypositions;
}
/**
 * 
 * @param newOldgsmnumber java.lang.String
 */
public void setOldgsmnumber(java.lang.String newOldgsmnumber) {
	oldgsmnumber = newOldgsmnumber;
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
 * 
 * @param newPosbscode java.lang.Integer
 */
public void setPosbscode(java.lang.Integer newPosbscode) {
	posbscode = newPosbscode;
}
/**
 * 
 * @param newPosbsname java.lang.String
 */
public void setPosbsname(java.lang.String newPosbsname) {
	posbsname = newPosbsname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2005 18:30:51)
 * @param newContrcode int
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
 * Creation date: (29.10.2004 15:54:09)
 * @param newQty120 java.lang.String
 */
public void setQty120(java.lang.String newQty120) {
	qty120 = newQty120;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 15:54:09)
 * @param newQty130 java.lang.String
 */
public void setQty130(java.lang.String newQty130) {
	qty130 = newQty130;
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
 * Creation date: (26.10.2004 18:48:40)
 * @param newQty80 java.lang.String
 */
public void setQty80(java.lang.String newQty80) {
	qty80 = newQty80;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 12:00:54)
 * @param newQty85 java.lang.String
 */
public void setQty85(java.lang.String newQty85) {
	qty85 = newQty85;
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
 * Creation date: (27.12.2004 14:51:13)
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
 * Creation date: (29.10.2004 15:54:42)
 * @param newResource120 java.lang.Integer
 */
public void setResource120(java.lang.Integer newResource120) {
	resource120 = newResource120;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 15:54:42)
 * @param newResource130 java.lang.Integer
 */
public void setResource130(java.lang.Integer newResource130) {
	resource130 = newResource130;
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
 * Creation date: (26.10.2004 18:45:38)
 * @param newResource80 java.lang.Integer
 */
public void setResource80(java.lang.Integer newResource80) {
	resource80 = newResource80;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 12:01:13)
 * @param newResource85 java.lang.Integer
 */
public void setResource85(java.lang.Integer newResource85) {
	resource85 = newResource85;
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
 * Creation date: (29.10.2004 15:55:05)
 * @param newSerial120 java.lang.String
 */
public void setSerial120(java.lang.String newSerial120) {
	serial120 = newSerial120;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2004 15:55:05)
 * @param newSerial130 java.lang.String
 */
public void setSerial130(java.lang.String newSerial130) {
	serial130 = newSerial130;
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
 * Creation date: (26.10.2004 18:51:24)
 * @param newSerial80 java.lang.String
 */
public void setSerial80(java.lang.String newSerial80) {
	serial80 = newSerial80;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2005 12:01:35)
 * @param newSerial85 java.lang.String
 */
public void setSerial85(java.lang.String newSerial85) {
	serial85 = newSerial85;
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
	StringAndIntegerProperty si = new StringAndIntegerProperty();
	StringAndIntegerProperty gi = new StringAndIntegerProperty();

	// Проверка номера позиции
	if(getGsmidnumber()==null) setGsmidnumber("");
	if(getPosnumber()==null) setPosnumber("");
	System.err.println("***gsm:" + getGsmidnumber());
	System.err.println("***pos:" + getPosnumber());
	System.err.println("***old:" + getOldgsmnumber());
	
	gi.setString(getGsmidnumber());
	si.setString(getPosnumber());
	if (!getGsmidnumber().equals(getOldgsmnumber())) {
		setPosbscode(null);
		setPosbsname("");
	}
	if(!gi.isEmpty()) {
		if(!gi.isOk()) {
			errors.add("head", new ActionError("error.mountact3.bad.gsmidnumber"));
		} else {
			if(getPosbscode() == null) {
				CDBCResultSet pr = getPositions();
//System.out.println("FIND POSITIONS BY["+getGsmidnumber()+"]:"+pr.getRowsCount());
				if(pr.getRowsCount() > 1) {
					setManypositions(true);
					// Позийий много
					errors.add("positi", new ActionError("error.mountact3.toomany.positions"));
				} else
				if(pr.getRowsCount() < 1) {
					setManypositions(false);
					// Позиций нет
					errors.add("positi", new ActionError("error.mountact3.empty.positions"));
				} else {
					setManypositions(false);
					// Одна позиция
					java.util.ListIterator it = pr.listIterator();
					CDBCRowObject ro = (CDBCRowObject)it.next();
					setPosbscode((Integer)ro.getColumn("storageplace").asObject());
					setPosbsname(ro.getColumn("posname").asString());
				}
			}
		}
	}
	if (!getPosnumber().equals(getOldposnumber())) {
		setComplectcode(null);
		setComplectname("");
	}
	if(posbscode == null && si.isEmpty()) {
		errors.add("head", new ActionError("error.mountact3.empty.posnumber"));
	} else 
	if(posbscode == null && !si.isOk()) {
		errors.add("head", new ActionError("error.mountact3.bad.posnumber"));
	} else {
//		if (getComplectcode() == null) {
			CDBCResultSet res =  getComplects();
			//System.out.println("FIND COMPLECTS BY["+getGsmidnumber()+","+getPosnumber()+"]:"+res.getRowsCount());
			if (res.getRowsCount() > 1) {
				setManycomplects(true);
				errors.add("head", new ActionError("error.mountact3.toomany.complect"));
			} else if (res.getRowsCount() < 1) {
				setManycomplects(false);
				errors.add("head", new ActionError("error.mountact3.empty.complect"));
			} else {
				setManycomplects(false);
				java.util.ListIterator it = res.listIterator();
				CDBCRowObject ro = (CDBCRowObject)it.next();
				setComplectcode((Integer)ro.getColumn("contrcode").asObject());
				setComplectname(ro.getColumn("contrname").asString());
				setPosnumber(ro.getColumn("contrnumber").asString());
			}
//		}
	}
	setOldgsmnumber(getGsmidnumber());
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
	validateResource(getResource80(), getSerial80(), getQty80(), "80", errors);
	validateResource(getResource85(), getSerial85(), getQty85(), "85", errors);
	validateResource(getResource90(), getSerial90(), getQty90(), "90", errors);
	validateResource(getResource100(), getSerial100(), getQty100(), "100", errors);
	validateResource(getResource110(), getSerial110(), getQty110(), "110", errors);
	validateResource(getResource120(), getSerial120(), getQty120(), "120", errors);
	validateResource(getResource130(), getSerial130(), getQty130(), "130", errors);

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
}
