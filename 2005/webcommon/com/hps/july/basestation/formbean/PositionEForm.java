package com.hps.july.basestation.formbean;

import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.*;
import java.math.BigDecimal;
import com.hps.july.jdbcpersistence.lib.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.apptags.*;

/**
 * Форма параметров позиции
 */
public class PositionEForm
	extends com.hps.july.web.util.EditForm 
	implements Checks
{
	private java.lang.String address;

	private StringAndInteger storageplace=new StringAndInteger();
	private java.lang.Integer netzonecode;
	private com.hps.july.persistence.NetZoneAccessBean netzones;
	private String posstate;
	private StringAndIntegerProperty regioncode=new StringAndInteger();
	private Vector regions;

	private String regname;
	private String supregname;
	private String zonename;

	private String name;
	private String fullName;

	private StringAndBigDecimalProperty latitude = new StringAndBigDecimal();
	private StringAndBigDecimalProperty longitude = new StringAndBigDecimal();

	private boolean admin = false;
	private String remoteUser;
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:46:22)
 */
public PositionEForm() {
	super();
	
	}
/**
 * Insert the method's description here.
 * Creation date: (12.05.2003 21:57:52)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 */
public boolean canModifyRegion(HttpServletRequest request) throws Exception {
	return HasRegionAccessTag.hasAccess(request,getStorageplaceFrm(),"Edit");
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
    throws Exception
{
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setStorageplace(keyGen.getNextKey("tables.storageplaces"));
	PositionAccessBean bean = new PositionAccessBean(
		getStorageplace(),
		getName(),
		getAddress(),
		getNetzonecode(),
		new BigDecimal("0"),
		new BigDecimal("0"),
		Integer.parseInt(getRegioncode()),
		POSITION_PLANSTATE_Fact
	);
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public NetZoneAccessBean constructNetzones() throws Exception {

	//if (netzones == null) {	
		// Construct workers bean
		if (netzonecode != null) {
			netzones = new NetZoneAccessBean();
			netzones.setInitKey_netzone(netzonecode.intValue());
			netzones.refreshCopyHelper();
		}
	//}
	return netzones;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	try {
		PositionAccessBean posBean = (PositionAccessBean) bean;
		//DebugSupport.printlnTest("PositionForm fillRecord started ");
		setZonename(posBean.getNetZone().getName());
		setName(posBean.getName());
		setRegname(posBean.getRegion().getRegname());
		setAddress(posBean.getAddress());
		setPosstate(posBean.getPosstate());
		//DebugSupport.printlnTest("zonename= "+getZonename());

		String gsm = posBean.getGsmid() != null ? "D" + posBean.getGsmid() : "";
		String damps = posBean.getDampsid() != null ? "A" + posBean.getDampsid() : "";

		fullName =
			gsm
				+ (gsm.length() > 0 && damps.length() > 0 ? " " : "")
				+ damps
				+ (gsm.length() > 0 || damps.length() > 0 ? " " : "")
				+ getName();

		setLatitude(posBean.getLatitude());
		setLongitude(posBean.getLongitude());
    } catch (Exception e) {
        new DebugSupport().printlnError(e);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:07:28)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAddrRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	roles.add("siteProjector");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAllRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	PositionAccessBean bean = new PositionAccessBean();
	bean.setInitKey_storageplace( getStorageplace() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 12:18:33)
 * @return java.lang.String
 */
public java.lang.String getFullName() {
	return fullName;
}
public java.math.BigDecimal getLatitude() {
	return latitude.getBigDecimal();
}
public String getLatitudeFrm() {
	return latitude.getString();
}
public java.math.BigDecimal getLongitude() {
	return longitude.getBigDecimal();
}
public String getLongitudeFrm() {
	return longitude.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 12:25:19)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public NetZone getNetZone() throws Exception {

	NetZoneAccessBean bean = constructNetzones();
	if (bean != null)
	  return (NetZone)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:54:44)
 * @return java.lang.Integer
 */
public java.lang.Integer getNetzonecode() {
	return netzonecode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.05.2002 14:05:43)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getNetzones() {
	try {
		com.hps.july.persistence.NetZoneAccessBean bean = new com.hps.july.persistence.NetZoneAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosstate() {
	return posstate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 19:56:03)
 * @return com.hps.july.persistence.RegionBean
 */
public Region getRegion() throws Exception {
    System.out.println("getRegion invoked");

    if (regioncode.isEmpty()) {
        return null;
    }
    RegionAccessBean bean = new RegionAccessBean();
    bean.setInitKey_regionid(regioncode.getInteger().intValue());
    bean.refreshCopyHelper();

    return (Region) bean.getEJBRef();
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 20:17:22)
 * @return java.lang.String
 */
public String getRegioncode() throws Exception {
	DebugSupport.printlnTest("getRegioncode started");
	if(regioncode==null){
		int id=((RegionObject)getRegions().elementAt(0)).getId();
		DebugSupport.printlnTest("getRegioncode id="+id);
		regioncode=new StringAndInteger();
		regioncode.setInteger(new Integer(id));
		
		}
	
	return regioncode.getString();
}
public java.util.Vector getRegions() throws Exception {
	try {
		//DebugSupport.printlnTest("positionForm.getRegions started request="+request);
        if(regions == null) {
	        regions = new RegionObject().findAllEdit(remoteUser,isAdmin(),"all");
        }
        return regions;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 19:56:03)
 * @return com.hps.july.persistence.RegionBean
 */
public String getRegname() throws Exception {

    System.out.println("getRegname invoked");

    try {
        return getRegion().getRegname();
    } catch (Exception e) {
        
	    return (regname==null||regname.trim().length()==0)?"":regname;

    }

}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.EDITPOS;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @return int
 */
public int getStorageplace() {

	
	return storageplace.getInteger()==null?0:storageplace.getInteger().intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @return int
 */
public String getStorageplaceFrm() {
	return storageplace.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 14:39:23)
 * @return java.lang.String
 */
public String getSupregname() throws Exception {

    try {
        Region region = getRegion();
        return region.getSuperregion().getSupregname();
    } catch (Exception e) {
        return (supregname==null||supregname.trim().length()==0)?"":supregname;
    }
    
}
/**
 * Insert the method's description here.
 * Creation date: (03.04.2003 22:59:00)
 * @return java.lang.String
 */
public java.lang.String getZonename() {
	return zonename;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(EquipmentListForm listForm) throws Exception {
    DebugSupport.printlnTest("PositionForm initRecord started");

    //setPlanstate(POSITION_PLANSTATE_Plan);
    setAddress("");
    setName("");
    regioncode.setString("");
    setRegname("");
    setSupregname("");
    setZonename("");
    setFullName("");
    setLongitudeFrm("");
    setLatitudeFrm("");
    //setStorageplaceFrm("");
    try {
        if (listForm != null) {

            Integer[] reg = listForm.getRegionsSelector().getRegioncodes();
            if (reg.length > 0) {

                regioncode.setInteger(reg[0]);
                DebugSupport.printlnTest("PositionForm initRecord regioncode=" + regioncode);
            }

        }

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 21:54:02)
 * @return java.lang.Boolean
 */
public Boolean isAdmin() {
	 return new Boolean(admin);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:07:28)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 12:18:33)
 * @param newFullName java.lang.String
 */
public void setFullName(java.lang.String newFullName) {
	fullName = newFullName;
}
public void setLatitude(java.math.BigDecimal newLatitude) {
	latitude.setBigDecimal(newLatitude);
}
public void setLatitudeFrm(String newLatitude) {
	latitude.setString(newLatitude);
}
public void setLongitude(java.math.BigDecimal newLongitude) {
	longitude.setBigDecimal(newLongitude);
}
public void setLongitudeFrm(String newLongitude) {
	longitude.setString(newLongitude);
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 12:25:19)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setNetZone(NetZoneAccessBean newNetZone) throws Exception {
	if (newNetZone == null) {
	    netzonecode = new Integer(0);
	}
	else {
		netzonecode = new Integer(newNetZone.getNetzone());
		zonename=newNetZone.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:54:44)
 * @param newNetzonecode java.lang.Integer
 */
public void setNetzonecode(java.lang.Integer newNetzonecode) {
	netzonecode = newNetzonecode;
}
/**
 * 
 * @param newPosstate java.lang.String
 */
public void setPosstate(java.lang.String newPosstate) {
	posstate = newPosstate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 19:57:37)
 * @param bean com.hps.july.persistence.RegionAccessBean
 */
public void setRegion(RegionAccessBean bean) throws Exception {
	if(bean!=null){
	regioncode=new StringAndIntegerProperty();	
    regioncode.setInteger(new Integer(bean.getRegionid()));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 20:27:43)
 * @param str java.lang.String
 */
public void setRegioncode(String str) throws Exception {
	regioncode.setString(str);


	
	}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 14:39:23)
 * @return java.lang.String
 */
public void setRegname(String val) {

   regname=val;
}
public void setRequestData(HttpServletRequest request)
{
	admin = request.isUserInRole("administrator");
	remoteUser = request.getRemoteUser();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace.setInteger(new Integer(newStorageplace));
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @param newStorageplace int
 */
public void setStorageplaceFrm(String newStorageplace) {
	
	
	storageplace.setString(newStorageplace);

	DebugSupport.printlnTest("PositionForm setStorageplaceFrm storageplace="+getStorageplace());
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 14:39:23)
 * @return java.lang.String
 */
public void setSupregname(String val) {

   supregname=val;
}
/**
 * Insert the method's description here.
 * Creation date: (03.04.2003 22:59:00)
 * @param newZonename java.lang.String
 */
public void setZonename(java.lang.String newZonename) {
	zonename = newZonename;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {

    if ((getName() == null) || (getName().length() == 0))
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.empty.position.name"));

    if ((getAddress() == null) || (getAddress().length() == 0))
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.empty.position.addr"));
    /*
        if (!errors.empty())
            throw new ValidationException();
    */
}
}
