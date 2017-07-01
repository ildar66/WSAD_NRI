package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования склада
 */
public class StorageForm 
	extends com.hps.july.web.util.EditForm
{
	private int superregionid;
	private int regionid;
	
	private java.lang.Integer companycode;
	private java.lang.String companyname;
	private java.lang.Integer directioncode;
	private java.lang.String directionname;
	private java.lang.Integer servicecode;
	private java.lang.String servicename;
	private java.lang.Integer departmentcode;
	private java.lang.String departmentname;
	private java.lang.Integer groupcode;
	private java.lang.String groupname;
	private com.hps.july.persistence.CompanyAccessBean companies;
	private com.hps.july.persistence.DirectionAccessBean directions;
	private com.hps.july.persistence.ServiceAccessBean services;
	private com.hps.july.persistence.DepartmentAccessBean deparments;
	private com.hps.july.persistence.GroupAccessBean groups;
	private java.lang.String name;
	private java.lang.String address;
	private java.lang.String pstnphone;
	private java.lang.String internalphone;
	private int storageplace;
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 10:10:59)
 */
public StorageForm() {
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setStorageplace(keyGen.getNextKey("tables.storageplaces"));
    StorageAccessBean bean = new StorageAccessBean(
	    getStorageplace(),
	    new Integer(getDivision().getDivision()),
    	getName(),
    	getAddress(),
    	getRegionid()
    );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public CompanyAccessBean constructCompanies() throws Exception {

	if (companies == null) {	
		// Construct workers bean
		if (getCompanycode() != null) {
			companies = new CompanyAccessBean();
			companies.setInitKey_company(getCompanycode().intValue());
			companies.refreshCopyHelper();
		}
	}
	return companies;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public DepartmentAccessBean constructDepartments() throws Exception {

	if (deparments == null) {	
		// Construct workers bean
		if (getDepartmentcode() != null) {
			deparments = new DepartmentAccessBean();
			deparments.setInitKey_division(getDepartmentcode().intValue());
			deparments.refreshCopyHelper();
		}
	}
	return deparments;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public DirectionAccessBean constructDirections() throws Exception {

	if (directions == null) {	
		// Construct workers bean
		if (getDirectioncode() != null) {
			directions = new DirectionAccessBean();
			directions.setInitKey_division(getDirectioncode().intValue());
			directions.refreshCopyHelper();
		}
	}
	return directions;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public DivisionAccessBean constructDivision(java.lang.Integer aDivisionCode) throws Exception {

	DivisionAccessBean bean = null;
	if (aDivisionCode != null) {	
		bean = new DivisionAccessBean();
		bean.setInitKey_division(aDivisionCode.intValue());
		bean.refreshCopyHelper();
	}
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public GroupAccessBean constructGroups() throws Exception {

	if (groups == null) {	
		// Construct groups bean
		if (getGroupcode() != null) {
			groups = new GroupAccessBean();
			groups.setInitKey_division(getGroupcode().intValue());
			groups.refreshCopyHelper();
		}
	}
	return groups;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public ServiceAccessBean constructServices() throws Exception {

	if (services == null) {	
		// Construct services bean
		if (getServicecode() != null) {
			services = new ServiceAccessBean();
			services.setInitKey_division(getServicecode().intValue());
			services.refreshCopyHelper();
		}
	}
	return services;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	try {
		RegionAccessBean r = new RegionAccessBean();
		r.setInitKey_regionid(getRegionid());
		r.refreshCopyHelper();
		superregionid = r.getSuperregion().getSupregid();
	} catch(Exception e) {
		superregionid = 0;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:15:21)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:10:49)
 * @return com.hps.july.security.persistence.CompaniesAccessBean
 */
public com.hps.july.persistence.Company getCompany() throws Exception {
	if (getDivision() == null) {
		CompanyAccessBean bean = constructCompanies();
		if (bean != null)
		  return (Company)bean.getEJBRef();
		else
		  return null;
	}
	else
		return null;
		
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getCompanycode() {
	return companycode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:52)
 * @return java.lang.String
 */
public java.lang.String getCompanyname() {
	return companyname;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	StorageAccessBean bean = new StorageAccessBean();
	bean.setInitKey_storageplace( getStorageplace() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:40:39)
 * @return java.lang.Integer
 */
public java.lang.Integer getDepartmentcode() {
	return departmentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:40:54)
 * @return java.lang.String
 */
public java.lang.String getDepartmentname() {
	return departmentname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:12:28)
 * @return com.hps.july.security.persistence.DeparmentsAccessBean
 */
public com.hps.july.persistence.Department getDepartments() throws Exception {
	DepartmentAccessBean bean = constructDepartments();
	if (bean != null)
	  return (Department)bean.getEJBRef();
	else
	  return null;

}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:39:14)
 * @return java.lang.Integer
 */
public java.lang.Integer getDirectioncode() {
	return directioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:39:29)
 * @return java.lang.String
 */
public java.lang.String getDirectionname() {
	return directionname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:11:17)
 * @return com.hps.july.security.persistence.DirectionsAccessBean
 */
public com.hps.july.persistence.Direction getDirections() throws Exception {
	DirectionAccessBean bean = constructDirections();
	if (bean != null)
	  return (Direction)bean.getEJBRef();
	else
	  return null;

}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:12:57)
 * @return com.hps.july.security.persistence.GroupsAccessBean
 */
public Division getDivision() throws Exception {
	Division bean = null;
	if (getGroupcode() != null)
	  bean = (Division)getGroups();
	else if (getDepartmentcode() != null)
	  bean = (Division)getDepartments();
	else if (getServicecode() != null)
	  bean = (Division)getServices();
	else if (getDirectioncode() != null)
	  bean = (Division)getDirections();
	  
	return bean;

}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:41:15)
 * @return java.lang.Integer
 */
public java.lang.Integer getGroupcode() {
	return groupcode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:41:33)
 * @return java.lang.String
 */
public java.lang.String getGroupname() {
	return groupname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:12:57)
 * @return com.hps.july.security.persistence.GroupsAccessBean
 */
public com.hps.july.persistence.Group getGroups() throws Exception {
	GroupAccessBean bean = constructGroups();
	if (bean != null)
	  return (Group)bean.getEJBRef();
	else
	  return null;

}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:16:02)
 * @return java.lang.String
 */
public java.lang.String getInternalphone() {
	return internalphone;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:14:55)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:15:47)
 * @return java.lang.String
 */
public java.lang.String getPstnphone() {
	return pstnphone;
}
/**
 * 
 * @return int
 */
public int getRegionid() {
	return regionid;
}
public String getRegionidFrm() {
	return String.valueOf(regionid);
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:39:52)
 * @return java.lang.Integer
 */
public java.lang.Integer getServicecode() {
	return servicecode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:40:06)
 * @return java.lang.String
 */
public java.lang.String getServicename() {
	return servicename;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:11:40)
 * @return com.hps.july.security.persistence.ServicesAccessBean
 */
public com.hps.july.persistence.Service getServices() throws Exception {
	ServiceAccessBean bean = constructServices();
	if (bean != null)
	  return (Service)bean.getEJBRef();
	else
	  return null;

}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:29:31)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITSTRG;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:17:50)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * 
 * @return int
 */
public int getSuperregionid() {
	return superregionid;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	StorageListForm nzf = (StorageListForm)request.getSession().getAttribute("StorageListForm");
	com.hps.july.siteinfo.valueobject.RegionsSelector rs = nzf.getRegionsSelector();
	if(!rs.isAllRegions()) {
		Integer[] r = rs.getRegioncodes();
		if(r != null && r.length > 0 && r[0] != null) {
			regionid = r[0].intValue();
		}
	}
	try {
		RegionAccessBean ra = new RegionAccessBean();
		ra.setInitKey_regionid(regionid);
		ra.refreshCopyHelper();
		superregionid = ra.getSuperregion().getSupregid();
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:15:21)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:10:49)
 * @param newCompanies com.hps.july.security.persistence.CompaniesAccessBean
 */
public void setCompany(com.hps.july.persistence.CompanyAccessBean newCompanies) throws Exception {
	if (newCompanies == null) {
	  companycode = null;
	  companyname = "";
	}
	else {
		companycode = new Integer(newCompanies.getCompany());
		companyname = newCompanies.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:37)
 * @param newCompany java.lang.Integer
 */
public void setCompanycode(java.lang.Integer newCompany) {
	companycode = newCompany;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:38:52)
 * @param newCompanyname java.lang.String
 */
public void setCompanyname(java.lang.String newCompanyname) {
	companyname = newCompanyname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:40:39)
 * @param newDepartment java.lang.Integer
 */
public void setDepartmentcode(java.lang.Integer newDepartment) {
	departmentcode = newDepartment;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:40:54)
 * @param newDepartmentname java.lang.String
 */
public void setDepartmentname(java.lang.String newDepartmentname) {
	departmentname = newDepartmentname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:12:28)
 * @param newDeparments com.hps.july.security.persistence.DeparmentsAccessBean
 */
public void setDepartments(DepartmentAccessBean newDeparments) throws Exception {
	if (newDeparments == null) {
		departmentcode = null;
		departmentname = "";
	}
	else {
		departmentcode = new Integer(newDeparments.getDivision());
		departmentname = newDeparments.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:39:14)
 * @param newDirection java.lang.Integer
 */
public void setDirectioncode(java.lang.Integer newDirection) {
	directioncode = newDirection;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:39:29)
 * @param newDirectionname java.lang.String
 */
public void setDirectionname(java.lang.String newDirectionname) {
	directionname = newDirectionname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:11:17)
 * @param newDirections com.hps.july.security.persistence.DirectionsAccessBean
 */
public void setDirections(com.hps.july.persistence.DirectionAccessBean newDirections) throws Exception {
	if (newDirections == null) {
		directioncode = null;
		directionname = "";
	}
	else {
		directioncode = new Integer(newDirections.getDivision());
		directionname = newDirections.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:12:57)
 * @param newGroups com.hps.july.security.persistence.GroupsAccessBean
 */
public void setDivision(DivisionAccessBean newDivision) throws Exception {
	if (newDivision == null) {
		setGroups(null);
		setDepartments(null);
		setServices(null);
		setDirections(null);
		setCompany(null);
	}
	else {
		Division bean = (Division)newDivision.getEJBRef();
		if (bean instanceof Group) {
		  setGroups(new GroupAccessBean(bean));
		  setDepartments(new DepartmentAccessBean(bean.getParent()));
		  setServices(new ServiceAccessBean(bean.getParent().getParent()));
		  setDirections(new DirectionAccessBean(bean.getParent().getParent().getParent()));
		  setCompany(new CompanyAccessBean(bean.getParent().getParent().getParent().getCompany()));
		}
		if (bean instanceof Department) {
		  setDepartments(new DepartmentAccessBean(bean));
		  setServices(new ServiceAccessBean(bean.getParent()));
		  setDirections(new DirectionAccessBean(bean.getParent().getParent()));
		  setCompany(new CompanyAccessBean(bean.getParent().getParent().getCompany()));
		}
		if (bean instanceof Service) {
		  setServices(new ServiceAccessBean(bean));
		  setDirections(new DirectionAccessBean(bean.getParent()));
		  setCompany(new CompanyAccessBean(bean.getParent().getCompany()));
		}
		if (bean instanceof Direction) {
		  setDirections(new DirectionAccessBean(bean));
		  setCompany(new CompanyAccessBean(bean.getCompany()));
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:41:15)
 * @param newGroup java.lang.Integer
 */
public void setGroupcode(java.lang.Integer newGroup) {
	groupcode = newGroup;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:41:33)
 * @param newGroupname java.lang.String
 */
public void setGroupname(java.lang.String newGroupname) {
	groupname = newGroupname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:12:57)
 * @param newGroups com.hps.july.security.persistence.GroupsAccessBean
 */
public void setGroups(com.hps.july.persistence.GroupAccessBean newGroups) throws Exception {
	if (newGroups == null) {
		groupcode = null;
		groupname = "";
	}
	else {
		groupcode = new Integer(newGroups.getDivision());
		groupname = newGroups.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:16:02)
 * @param newInternalphone java.lang.String
 */
public void setInternalphone(java.lang.String newInternalphone) {
	internalphone = newInternalphone;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:14:55)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:15:47)
 * @param newPstnphone java.lang.String
 */
public void setPstnphone(java.lang.String newPstnphone) {
	pstnphone = newPstnphone;
}
/**
 * 
 * @param newRegionid int
 */
public void setRegionid(int newRegionid) {
	regionid = newRegionid;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:39:52)
 * @param newService java.lang.Integer
 */
public void setServicecode(java.lang.Integer newService) {
	servicecode = newService;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 10:40:06)
 * @param newServicename java.lang.String
 */
public void setServicename(java.lang.String newServicename) {
	servicename = newServicename;
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 11:11:40)
 * @param newServices com.hps.july.security.persistence.ServicesAccessBean
 */
public void setServices(com.hps.july.persistence.ServiceAccessBean newServices) throws Exception {
	if (newServices == null) {
		servicecode = null;
		servicename = "";
	}
	else {
		servicecode = new Integer(newServices.getDivision());
		servicename = newServices.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 15:17:50)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
/**
 * 
 * @param newSuperregionid int
 */
public void setSuperregionid(int newSuperregionid) {
	superregionid = newSuperregionid;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	
	if ((getName() == null) || (getName().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.storage.name"));
	  
	if ((getAddress() == null) || (getAddress().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.storage.address"));
	  
	try {
		
		if (getGroupcode() != null)
			constructGroups();
		else {
			
			try {
				
				if (getDepartmentcode() != null)
					constructDepartments();
				else {
					try {
						
						if (getServicecode() != null)
							constructServices();
						else {
							try {
								
								if (getDirectioncode() != null)
									constructDirections();
								else {
									errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.storage.direction"));
								}
							} catch (Exception ex) {
								if (ErrorProcessor.isRecordNotExistException(ex))
								  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.storage.direction"));
							}
						}
					} catch (Exception ex) {
						if (ErrorProcessor.isRecordNotExistException(ex))
						  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.storage.service"));
					}
				}
				
			} catch (Exception ex) {
				if (ErrorProcessor.isRecordNotExistException(ex))
				  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.storage.department"));
			}
		}

			
	} catch (Exception ex) {
		if (ErrorProcessor.isRecordNotExistException(ex))
		  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.storage.group"));
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
