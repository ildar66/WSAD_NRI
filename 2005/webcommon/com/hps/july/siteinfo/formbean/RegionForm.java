package com.hps.july.siteinfo.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.siteinfo.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * ����� �������������� �������
 */
public class RegionForm extends com.hps.july.web.util.EditForm {
	private int regionid; // ������������� �������
	private String regname=""; // ������������ �������
	private StringAndIntegerProperty superRegionCode=new StringAndIntegerProperty(); // ������������ ������������
	private StringAndBigDecimalProperty sectorprefix=new StringAndBigDecimalProperty(); // ������� ������ �������
	private String sectorprefixFrm=""; // ������� ������ ������� ��� ����������� �� ��������
	
/**
 * ����� �������� ���������� ����������� ���������� EJB
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    regionid = keyGen.getNextKey(TablesRef.REGIONS);
    RegionAccessBean bean = new RegionAccessBean(
    /*int argRegionid,*/ regionid,
    /*int argSupregid,*/ superRegionCode.getInteger().intValue(),
    /*String argRegName,*/ regname,
    /*java.math.BigDecimal*/ sectorprefix.getBigDecimal());
    return bean;
}
/**
 * �����, ������������ ������������� web-������
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * �����, ������������ ��������� ���������� EJB, ���������� ������ � �������
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {
    RegionAccessBean bean = new RegionAccessBean();
    bean.setInitKey_regionid(regionid);
    return bean;
}
/**
 * ����� ���������� ������������� �������
 */
public int getRegionid() {
	return regionid;
}
/**
 * ����� ���������� ��� �������
 */
public java.lang.String getRegname() {
	return regname;
}
/**
 * ����� ���������� ������� ������ ������� �������
 */
public java.math.BigDecimal getSectorprefix() {
    return sectorprefix.getBigDecimal();
}
/**
 * ����� ���������� ������� ������ ������� ������� ��� ����������� �� ��������
 */
public java.lang.String getSectorprefixFrm() {
	return sectorprefixFrm;
}
/**
 * ����� ���������� ��������� ������ "������� �������� �������" ��� ����������� ��������"
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.REGIONEDIT;
}
/**
 * ����������� ������ �� ��������� EJB, ���������� ���������� � ������������.
 */
public SuperRegion getSuperregion() throws Exception {
    SuperRegionAccessBean bean = new SuperRegionAccessBean();
    bean.setInitKey_supregid(superRegionCode.getInteger().intValue());
    bean.refreshCopyHelper();

    return (SuperRegion) bean.getEJBRef();
}
/**
 * ����� ��������� ������������ ������������
 */
public String getSuperRegionCode() {
	return superRegionCode.getString();
}
/**
 * ����� ���������� ������ �� ��������� EJB, �������������� �����
 * ������� �������������
 */
public java.util.Enumeration getSuperRegions() throws Exception {
    SuperRegionAccessBeanTable table = new SuperRegionAccessBeanTable();
    table.setSuperRegionAccessBean(
        new SuperRegionAccessBean().findAllOrderByCodeAsc());

    if (superRegionCode.isEmpty()) {
        superRegionCode.setInteger(
            new Integer(table.getSuperRegionAccessBean(0).getSupregid()));
    }

    return table.rows();
}
/**
 * ����� ������������� �������� �������������� �������
 */
public void setRegionid(int newRegionid) {
	regionid = newRegionid;
}
/**
 * ����� ������������� �������� ������������ �������
 */
public void setRegname(java.lang.String newRegname) {
	regname = newRegname;
}
/**
 * ����� ������������� �������� �������� ������ �������
 */
public void setSectorprefix(java.math.BigDecimal newSectorprefix) {
	sectorprefix.setBigDecimal(newSectorprefix);
	sectorprefixFrm=sectorprefix.getString();
}
/**
 * ����� ������������� �������� �������� ������ ������� ��� �����������
 * �� ��������
 */
public void setSectorprefixFrm(java.lang.String newSectorprefixFrm) {
	sectorprefixFrm = newSectorprefixFrm;
}
/**
 * ����� ������������� �������� ���� ������������ � ������ �� ��������� EJB, 
 * ���������� ���������� � ������������.
 */
public void setSuperregion(SuperRegionAccessBean bean) throws Exception {
    superRegionCode.setInteger(new Integer(bean.getSupregid()));
return;
}
/**
 * ������������� �������� ������������ ������������
 */
public void setSuperRegionCode(String newSuperRegionCode) {
	superRegionCode.setString(newSuperRegionCode);
}
/**
 * ����� �������� ��������� ������������� ������
 */
public void validateValues(ActionErrors errors) throws Exception {

     if ((regname == null) || (regname.length() == 0))
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.empty.regionList.name"));

    try {
        sectorprefix.setString(sectorprefixFrm.trim());
        if (sectorprefix.getBigDecimal().scale() != 0||sectorprefixFrm.trim().length()>4)
            throw new NumberFormatException();
    } catch (Exception e) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.invalid.region.prefix"));
    }

    if (!errors.empty())
        throw new ValidationException();
}
}
