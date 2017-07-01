package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;
import org.apache.struts.util.*;

/**
 * Служебный класс для вывода данных списка документов "Fault Report"
 */
public class FaultValue {
	private FaultReportAccessBean so;
	private int position;
	private String positionname;
	private String spnum;
	private int resource;
	private String resourcename;
	private String equipmentname;
	private String workername;
	private Integer dassdoc;
	private String dassacttype;
	private Integer assdoc;
	private String assacttype;
public FaultValue(Object o) {
	positionname = "?";
	position = 0;
	resourcename = "";
	spnum = "";
	equipmentname = "?";
	workername = "";
	dassdoc = null;
	assdoc = null;
	assacttype = null;
	try {
		((FaultReportAccessBean)o).refreshCopyHelper();
	} catch(Throwable t) {}
	if(o instanceof FaultReportAccessBean) {
		try {
			so = new FaultReportAccessBean(((FaultReportAccessBean)o).getEJBRef());
			so.refreshCopyHelper();
			if("P".equals(so.getEqplace())) {
				EquipmentSetAccessBean eq = new EquipmentSetAccessBean();
				eq.setInitKey_storageplace(so.getFrom().getStorageplace());
				eq.refreshCopyHelper();
				PositionAccessBean p = eq.getPosition();
				position = p.getStorageplace();
				positionname = "";
				if(p.getGsmid() != null) {
					positionname += "D"+p.getGsmid()+" ";
				}
				if(p.getDampsid() != null) {
					positionname += "A"+p.getDampsid()+" ";
				}
				positionname += p.getName();
			} else if("S".equals(so.getEqplace())) {
				position = so.getFrom().getStorageplace();
				positionname = so.getFrom().getName();
			} else if("W".equals(so.getEqplace())) {
				position = 0;
				positionname = "";
			}
			spnum = so.getOldserial();
			/*
			if(spnum != null) {
				try {
					StorageCardAccessBean sc = (new StorageCardAccessBean()).findBySerial(spnum);
					resource = sc.getResource().getResource();
					resourcename = sc.getResource().getName();
					if(sc.getResource().getModel() != null) {
						resourcename = " " + sc.getResource().getModel();
					}
					if((sc.getManufserial()!=null && !"".equals(sc.getManufserial().trim())) && !spnum.equals(sc.getManufserial())) {
						spnum += " ("+sc.getManufserial().trim()+")";
					}
				} catch(Exception e) {
				}
				
			}
			*/
			//
			resource = so.getOldresource().intValue();
			ResourceAccessBean res = new ResourceAccessBean();
			res.setInitKey_resource(resource);
			resourcename = res.getModel(); // Name();
			//
			workername = so.getTechStuff().getMan().getFullName();
			// find links for dismantling act
			DocumentsLinkAccessBean dl = new DocumentsLinkAccessBean();
			java.util.Enumeration en = dl.findByTypeAndDocFrom("D",new Integer(so.getDocument()));
			if(en.hasMoreElements()) {
				DocumentsLinkAccessBean dd = (DocumentsLinkAccessBean)en.nextElement();
				if(dd.getDocumentTo_document() != null) {
					dassdoc = dd.getDocumentTo_document();
					dassacttype = "DB";
					try {
						InternalOutBillAccessBean dab = new InternalOutBillAccessBean();
						dab.setInitKey_document(dassdoc.intValue());
						dab.refreshCopyHelper();
						dassacttype = "D";
					} catch(Exception e) {
					}
				}
			}
			en = dl.findByTypeAndDocFrom("M",new Integer(so.getDocument()));
			if(en.hasMoreElements()) {
				DocumentsLinkAccessBean dm = (DocumentsLinkAccessBean)en.nextElement();
				if(dm.getDocumentTo_document() != null) {
					assdoc = dm.getDocumentTo_document();
					assacttype = "AB";
					try {
						InternalWayBillAccessBean dab = new InternalWayBillAccessBean();
						dab.setInitKey_document(assdoc.intValue());
						dab.refreshCopyHelper();
						dassacttype = "A";
					} catch(Exception e) {
					}
				}
			}
System.out.println("*#* DASSACT:"+dassacttype+":"+dassdoc);
System.out.println("*#* ASSACT:"+assacttype+":"+assdoc);
		} catch(Exception e) {
		}
	} else {
		so = null;
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAssacttype() {
	return assacttype;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getAssdoc() {
	return assdoc;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDassacttype() {
	return dassacttype;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getDassdoc() {
	return dassdoc;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEquipmentname() {
	return equipmentname;
}
/**
 * 
 * @return int
 */
public int getPosition() {
	return position;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * 
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * 
 * @return com.hps.july.persistence.FaultReportAccessBean
 */
public com.hps.july.persistence.FaultReportAccessBean getSo() {
	return so;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSpnum() {
	return spnum;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * 
 * @param newAssacttype java.lang.String
 */
public void setAssacttype(java.lang.String newAssacttype) {
	assacttype = newAssacttype;
}
/**
 * 
 * @param newAssdoc java.lang.Integer
 */
public void setAssdoc(java.lang.Integer newAssdoc) {
	assdoc = newAssdoc;
}
/**
 * 
 * @param newDassacttype java.lang.String
 */
public void setDassacttype(java.lang.String newDassacttype) {
	dassacttype = newDassacttype;
}
/**
 * 
 * @param newDassdoc java.lang.Integer
 */
public void setDassdoc(java.lang.Integer newDassdoc) {
	dassdoc = newDassdoc;
}
/**
 * 
 * @param newEquipmentname java.lang.String
 */
public void setEquipmentname(java.lang.String newEquipmentname) {
	equipmentname = newEquipmentname;
}
/**
 * 
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
}
/**
 * 
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * 
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * 
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * 
 * @param newSo com.hps.july.persistence.FaultReportAccessBean
 */
public void setSo(com.hps.july.persistence.FaultReportAccessBean newSo) {
	so = newSo;
}
/**
 * 
 * @param newSpnum java.lang.String
 */
public void setSpnum(java.lang.String newSpnum) {
	spnum = newSpnum;
}
/**
 * 
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
}
