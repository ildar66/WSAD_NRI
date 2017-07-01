package com.hps.july.inventory.formbean;

import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.Connection;
import java.util.Enumeration;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.cdbc.objects.*;

/**
 * Базовый класс для форм ввода строк акта замены/модернизации
 */
public class AbstractChangePositionForm extends com.hps.july.web.util.EditForm {
	private StringAndIntegerProperty code;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private String oldSerial;
	private StringAndIntegerProperty newresource;
	private String newresourcename;
	private String newresourcemodel;
	private String newSerial;
	private String oldmanufserial;
	private String manufserial;
	private StringAndIntegerProperty document;
	private Integer storageplace;
	private String att;
	private boolean browseBySerial;
	private boolean browseBySerialNew;
	
	private String oldlocalserial;
	private String localserial;
	
	private Boolean isSerialFict;
	private Boolean isManufSerialFict;
	private Boolean isInventSerialFict;
	
	private String oldSerialScr;
	private String newSerialScr;
	private String oldmanufserialScr;
	private String manufserialScr;
	private String oldlocalserialScr;
	private String localserialScr;

	public static final String NUMBER_IS_NOT_KNOWN = "Номер неизвестен";  
	
public AbstractChangePositionForm() {
	code = new StringAndIntegerProperty();
	resource = new StringAndIntegerProperty();
	resourcemodel = "";
	resourcename = "";
	newresource = new StringAndIntegerProperty();
	newresourcemodel = "";
	newresourcename = "";
	document = new StringAndIntegerProperty();
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	code.setInteger(new Integer(keyGen.getNextKey("tables.changeactpos")));
	ChangeActPositionAccessBean bean = new ChangeActPositionAccessBean(
		code.getInteger().intValue(),
		oldSerial,
		newSerial,
		document.getInteger()
	);
	return bean;
}
public ResourceAccessBean constructNewResource() throws java.lang.Exception {
	ResourceAccessBean bean = new ResourceAccessBean();
	bean.setInitKey_resource(newresource.getInteger().intValue());
	bean.refreshCopyHelper();
	newresourcemodel = bean.getModel();
	newresourcename = bean.getName();
	return bean;
}
public ResourceAccessBean constructResource() throws java.lang.Exception {
	ResourceAccessBean bean = new ResourceAccessBean();
	bean.setInitKey_resource(resource.getInteger().intValue());
	bean.refreshCopyHelper();
	resourcemodel = bean.getModel();
	resourcename = bean.getName();
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	/*
	try {
		ChangeActPositionAccessBean ab = (ChangeActPositionAccessBean)bean;
		try {
			StorageCardAccessBean fcard = new StorageCardAccessBean();
			StorageCardAccessBean card = null;
			if("2".equals(ab.getChangeAct().getDocumentState())) {
				card = fcard.findBySerial(ab.getNewSerial());
			} else {
				card = fcard.findBySerial(ab.getOldSerial());
			}
			if(card != null) {
				resource.setInteger(new Integer(card.getResource().getResource()));
				resourcemodel = card.getResource().getModel();
				resourcename = card.getResource().getName();
				oldmanufserial = card.getManufserial();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} catch(Exception e) {
	}
	*/
	try {
		ResourceAccessBean b = new ResourceAccessBean();
		b.setInitKey_resource(getOldresource().intValue());
		b.refreshCopyHelper();
		resourcename = b.getName();
		resourcemodel = b.getModel();
	} catch(Exception e) {
		resourcename = "";
		resourcemodel = "";
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAtt() {
	return att;
}
public java.lang.Integer getCode() {
	return code.getInteger();
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ChangeActPositionAccessBean bean = new ChangeActPositionAccessBean();
	bean.setInitKey_code(code.getInteger().intValue());
	return bean;
}
public java.lang.Integer getDocument() {
	return document.getInteger();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufserial() {
	return manufserial;
}
public Resource getNewresource() {
	try {
		return (Resource)constructNewResource().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getNewresourcecode() {
	return newresource.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNewresourcemodel() {
	return newresourcemodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNewresourcename() {
	return newresourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2002 11:45:36)
 * @return java.lang.String
 */
public java.lang.String getNewSerial() {
	return newSerial;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOldmanufserial() {
	return oldmanufserial;
}
public Integer getOldresource() {
	return resource.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2002 11:45:36)
 * @return java.lang.String
 */
public java.lang.String getOldSerial() {
	return oldSerial;
}
public Resource getResource() {
	try {
		return (Resource)constructResource().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getResourcecode() {
	return resource.getString();
}
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
public java.lang.String getResourcename() {
	return resourcename;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHP;
}
/**
 * Insert the method's description here.
 * Creation date: (02.08.2002 9:48:50)
 * @return java.lang.Integer
 */
public java.lang.Integer getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 14:48:06)
 * @return boolean
 */
public boolean isBrowseBySerial() {
	return browseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:02:29)
 * @return boolean
 */
public boolean isBrowseBySerialNew() {
	return browseBySerialNew;
}
/**
 * 
 * @param newAtt java.lang.String
 */
public void setAtt(java.lang.String newAtt) {
	att = newAtt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 14:48:06)
 * @param newBrowseBySerial boolean
 */
public void setBrowseBySerial(boolean newBrowseBySerial) {
	browseBySerial = newBrowseBySerial;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:02:29)
 * @param newBrowseBySerialNew boolean
 */
public void setBrowseBySerialNew(boolean newBrowseBySerialNew) {
	browseBySerialNew = newBrowseBySerialNew;
}
public void setCode(java.lang.Integer newNumber) {
	code.setInteger(newNumber);
}
public void setCodestr(String newNumber) {
	code.setString(newNumber);
}
public void setDocument(java.lang.Integer newNumber) {
	document.setInteger(newNumber);
}
/**
 * 
 * @param newManufserial java.lang.String
 */
public void setManufserial(java.lang.String newManufserial) {
	manufserial = newManufserial;
}
public void setNewresource(ResourceAccessBean newResource) {
	try {
		newresource.setInteger(new Integer(newResource.getResource()));
		newresourcename = newResource.getName();
		newresourcemodel = newResource.getModel();
	} catch(Exception e) {
		e.printStackTrace();
	}
}
public void setNewresourcecode(String newResource) {
	newresource.setString(newResource);
}
/**
 * 
 * @param newNewresourcemodel java.lang.String
 */
public void setNewresourcemodel(java.lang.String newNewresourcemodel) {
	newresourcemodel = newNewresourcemodel;
}
/**
 * 
 * @param newNewresourcename java.lang.String
 */
public void setNewresourcename(java.lang.String newNewresourcename) {
	newresourcename = newNewresourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2002 11:45:36)
 * @param newNewSerial java.lang.String
 */
public void setNewSerial(java.lang.String newNewSerial) {
	newSerial = newNewSerial;
}
/**
 * 
 * @param newOldmanufserial java.lang.String
 */
public void setOldmanufserial(java.lang.String newOldmanufserial) {
	oldmanufserial = newOldmanufserial;
}
public void setOldresource(Integer oldResource) {
	resource.setInteger(oldResource);
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2002 11:45:36)
 * @param newOldSerial java.lang.String
 */
public void setOldSerial(java.lang.String newOldSerial) {
	oldSerial = newOldSerial;
}
public void setResourcecode(String newResource) {
	resource.setString(newResource);
}
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
public void setStorageplace(java.lang.Integer newStorageplace) {
	storageplace = newStorageplace;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	setBrowseBySerial(false);
	setBrowseBySerialNew(false);
	
	if(resource.isEmpty()){
		setResourcemodel("");
		setResourcename("");
	}

	if(newresource.isEmpty()){
		setNewresourcemodel("");
		setNewresourcename("");
	}
	
	if (newresource.isEmpty()) {
		// Find new resource by serialnumber if its empty
		if ( (newSerial != null && newSerial.length() > 0) ) {

				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					// result = CDBCStoragecardsObject.findBySerialM(conn,getNewSerial());
					System.out.println("### newresource.isEmpty() ");
					result = CDBCStoragecardsObject.findBySerialM4Change(conn, getNewSerial(), getResourcecode());
				} catch(Exception e) {
					e.printStackTrace(System.err);
				}finally{
					try{
						if(conn!=null) conn.close();
					}catch(Exception e){
						e.printStackTrace(System.err);
					}
					
				}

				// if(result >= 2){
				if(result > 1){
					setBrowseBySerialNew(true);
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assemblingppos.several"));
					throw new ValidationException();
				}
				
				// Only serial number specified - find resource by serial number
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerialResource(newSerial, newresource.getInteger());
					newresource.setInteger(new Integer(card.getResource().getResource()));
					// может не давать изменить номер инвентарный	
					// setManufserial(card.getManufserial());
				} catch(Exception e) {
					e.printStackTrace();
				}
		} else{ 
				//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.serialparty"));
		}
	 } 

	if (resource.isEmpty()) {
		// Find old resource by serialnumber if its empty
		if ( (oldSerial != null && oldSerial.length() > 0) ) {

				Connection conn = null;
				int result = 0;

				try {
					
					conn = new JdbcConnection().getConnection();
					// result = CDBCStoragecardsObject.findBySerialM(conn,getOldSerial());
					System.out.println("### resource.isEmpty() ");
					result = CDBCStoragecardsObject.findBySerialM4Change(conn, getNewSerial(), getNewresourcecode());
					
				} catch(Exception e) {
					e.printStackTrace(System.err);
				}finally{
					try{
						if(conn!=null) conn.close();
					}catch(Exception e){
						e.printStackTrace(System.err);
					}
					
				}

				// if(result >= 2){
				if(result > 1){
					setBrowseBySerial(true);
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.assemblingppos.several"));
					throw new ValidationException();
				}
				
				// Only serial number specified - find resource by serial number
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerialResource(oldSerial, resource.getInteger());
					resource.setInteger(new Integer(card.getResource().getResource()));	
					// может не давать изменить номер инвентарный	
					// setManufserial(card.getManufserial());
				} catch(Exception e) {
					e.printStackTrace();
				}
		} else{ 
				//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.internalrpos.serialparty"));
		}
	} 

	
	
	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changepos.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changepos.resource"));
	}
	
	if ((oldSerial == null || "".equals(oldSerial))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changepos.oldserial"));
	}

	if(att != null && "U".equals(att)) {
		if(newresource.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.changepos.newresempty"));
		} else if(!newresource.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.changepos.newresinvalid"));
		}
	}
	
	if (((newSerial == null || "".equals(newSerial.trim()))) && ("C".equals(att))) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changepos.newserial"));
	}
	
	if (((newSerial == null || "".equals(newSerial.trim()))) && ("U".equals(att)) && (isSerialFict != null && ! isSerialFict.booleanValue())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changepos.sernums", "Заводской номер"));
	}

	if (((manufserial == null || "".equals(manufserial.trim()))) && (isManufSerialFict != null && ! isManufSerialFict.booleanValue())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changepos.sernums", "Инвентарный номер"));
	}

	if (((localserial == null || "".equals(localserial.trim()))) && (isInventSerialFict != null && ! isInventSerialFict.booleanValue())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.changepos.sernums", "Инв. подразделения номер"));
	}
	
	if(manufserial != null && manufserial.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	// Проверка на присутствие в документе такого же оборудования
	try {
		com.hps.july.cdbc.objects.CDBCDocuments cd = new com.hps.july.cdbc.objects.CDBCDocuments();
		if(getDocument() != null && resource.getInteger() != null) {
			int i = cd.checkChangeActPositionPresent(getDocument(),resource.getInteger(),getOldSerial(),getCode());
//System.out.println("ChPos Count:["+i+"]");
			
			if(i > 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.changepos.presentresource"));
			}
		}

		/*if(cd.hasSameSerialAndResource(newSerial,resource.getString(),document.getInteger(),docposition.getInteger())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.hassameserialandresource",resourcemodel,serialnumber));
		}*/
		
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}

	if (!errors.empty())
		throw new ValidationException();
	
	try {
		ResourceAccessBean bean = constructResource();
		String policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
System.out.println("CHANGE SERIAL: <"+oldSerial+">");
				StorageCardAccessBean card = ab.findBySerialResource(oldSerial, resource.getInteger());
				/*if( card.getResource().getResource() != resource.getInteger().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changepos.diffresources"));
				}*/
// @TODO: Эта строчка перезаписывает введённый "заводской серийный номер"
// setManufserial(card.getManufserial());
				setOldmanufserial(card.getManufserial());
				/*
				if( card.getCurrentstorage().getStorageplace() != storageplace.intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changepos.diffstorageplace"));
				}
				*/
//				setOwnercode(new Integer(card.getOwner().getOrganization()));
			} catch(Exception e) {
				e.printStackTrace(System.out);
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changepos.oldserial"));
			}
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changepos.notserialresource"));
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.changepos.resource"));
	}

	if(att != null && "U".equals(att)) {
		try {
			ResourceAccessBean nr = constructNewResource();
			if(!"S".equals(nr.getCountpolicy())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changepos.nonserialnewresource"));
			}
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.changepos.newresource"));
		}
	} else {
		newresource.setInteger(resource.getInteger());
	}

	/*if(att == null || !"U".equals(att)) {
		try {
			StorageCardAccessBean ab = new StorageCardAccessBean();
			StorageCardAccessBean card = ab.findBySerial(newSerial);
			if(card != null) {
				String spname = com.hps.july.inventory.actionbean.DocumentProcessAction.getSpname(card.getCurrentstorage());
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.changepos.newserial",newSerial,spname));
			}
		} catch(Exception e) {
			//e.printStackTrace(System.out);
		}
	}*/

	if (!errors.empty())
		throw new ValidationException();
}
	/**
	 * @return
	 */
	public String getLocalserial() {
		return localserial;
	}

	/**
	 * @return
	 */
	public String getOldlocalserial() {
		return oldlocalserial;
	}

	/**
	 * @param string
	 */
	public void setLocalserial(String string) {
		localserial = string;
	}

	/**
	 * @param string
	 */
	public void setOldlocalserial(String string) {
		oldlocalserial = string;
	}

	/**
	 * @return
	 */
	public Boolean getIsLocalserialFict() {
		if (localserial == null) {
			isInventSerialFict = new Boolean(true);
		}
		return isInventSerialFict;
	}

	/**
	 * @return
	 */
	public Boolean getIsManufSerialFict() {
		if ((manufserial == null) && (!ACTION_ADD.equals(getAction()))) {
			isManufSerialFict = new Boolean(true);
		} else {
			isManufSerialFict = new Boolean(false);
		}
		return isManufSerialFict;
	}

	/**
	 * @return
	 */
	public Boolean getIsSerialFict() {
		if ((newSerial == null) && (!ACTION_ADD.equals(getAction())))  {
			isSerialFict = new Boolean(true);
		} else {
			isSerialFict = new Boolean(false);
		}
		return isSerialFict;
	}

	/**
	 * @param boolean1
	 */
	public void setIsLocalserialFict(Boolean boolean1) {
		isInventSerialFict = boolean1;
		if (isInventSerialFict.booleanValue() == true) {
			localserial = null;
		}
	}

	/**
	 * @param boolean1
	 */
	public void setIsManufSerialFict(Boolean boolean1) {
		isManufSerialFict = boolean1;
		if (isManufSerialFict.booleanValue() == true) {
			manufserial = null;
		}
	}

	/**
	 * @param boolean1
	 */
	public void setIsSerialFict(Boolean boolean1) {
		isSerialFict = boolean1;
		if (isSerialFict.booleanValue() == true) {
			newSerial = null;
		}
	}

	/**
	 * @return
	 */
	public String getLocalserialScr() {
		if (localserial == null) {
			localserialScr = ""; // NUMBER_IS_NOT_KNOWN;
		} else {
			localserialScr = localserial;
		}
		return localserialScr;
	}

	/**
	 * @return
	 */
	public String getManufserialScr() {
		if (manufserial == null) {
			manufserialScr = ""; // NUMBER_IS_NOT_KNOWN;
		} else {
			manufserialScr = manufserial;
		}
		return manufserialScr;
	}

	/**
	 * @return
	 */
	public String getNewSerialScr() {
		if (newSerial == null) {
			// js подставит
			newSerialScr = ""; // NUMBER_IS_NOT_KNOWN; 
		} else {
			newSerialScr = newSerial;
		}
		return newSerialScr;
	}

	/**
	 * @return
	 */
	public String getOldlocalserialScr() {
		if (oldlocalserial == null) {
			oldlocalserialScr = NUMBER_IS_NOT_KNOWN;
		} else {
			oldlocalserialScr = oldlocalserial;
		}
		return oldlocalserialScr;
	}

	/**
	 * @return
	 */
	public String getOldmanufserialScr() {
		if (oldmanufserial == null) {
			oldmanufserialScr = NUMBER_IS_NOT_KNOWN;
		} else {
			oldmanufserialScr = oldmanufserial;
		}
		return oldmanufserialScr;
	}

	/**
	 * @return
	 */
	public String getOldSerialScr() {
		if (oldSerial == null) {
			oldSerialScr = NUMBER_IS_NOT_KNOWN;
		} else {
			oldSerialScr = oldSerial;
		}
		return oldSerialScr;
	}

	/**
	 * @param string
	 */
	public void setLocalserialScr(String string) {
		localserialScr = string;
		if (! NUMBER_IS_NOT_KNOWN.equals(localserialScr)) {
			localserial = localserialScr; 
		}
	}

	/**
	 * @param string
	 */
	public void setManufserialScr(String string) {
		manufserialScr = string;
		if (! NUMBER_IS_NOT_KNOWN.equals(manufserialScr)) {
			manufserial = manufserialScr; 
		}
	}

	/**
	 * @param string
	 */
	public void setNewSerialScr(String string) {
		newSerialScr = string;
		if (! NUMBER_IS_NOT_KNOWN.equals(newSerialScr)) {
			newSerial = newSerialScr; 
		}
	}

	/**
	 * @param string
	 */
	public void setOldlocalserialScr(String string) {
		oldlocalserialScr = string;
		if (! NUMBER_IS_NOT_KNOWN.equals(oldlocalserialScr)) {
			oldlocalserial = oldlocalserialScr; 
		}
	}

	/**
	 * @param string
	 */
	public void setOldmanufserialScr(String string) {
		oldmanufserialScr = string;
		if (! NUMBER_IS_NOT_KNOWN.equals(oldmanufserialScr)) {
			oldmanufserial = oldmanufserialScr; 
		}
	}

	/**
	 * @param string
	 */
	public void setOldSerialScr(String string) {
		oldSerialScr = string;
		if (! NUMBER_IS_NOT_KNOWN.equals(oldSerialScr)) {
			oldSerial = oldSerialScr; 
		}
	}

}
