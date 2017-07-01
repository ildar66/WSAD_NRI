package com.hps.july.basestation.valueobject;

import java.math.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Модель позиции
 */
public class PositionModel
	extends Model
{
	private StringAndInteger key = new StringAndInteger();
	private String name = "";
	private String id = "";
	private String address = "";
	private StringAndInteger superregion = new StringAndInteger();
	private StringAndInteger region = new StringAndInteger();
	private StringAndInteger netzone = new StringAndInteger();
	private String superregionname = "";
	private String regionname = "";
	private String netzonename = "";
	private StringAndBigDecimal latitude = new StringAndBigDecimal();
	private StringAndBigDecimal longitude = new StringAndBigDecimal();
	private StringAndInteger division = new StringAndInteger();

	private String posstate = "";
public PositionModel() {
	super();
}
public PositionAccessBean getAccessBean() {
	if(key.getInteger() == null) {
		return null;
	} else {
		try {
			PositionAccessBean p = new PositionAccessBean();
			p.setInitKey_storageplace(key.getInt());
			p.refreshCopyHelper();
			return p;
		} catch(Exception e) {
			return null;
		}
	}
}
public String getAddress() {
	return address;
}
public Integer getDivision() {
	return division.getInteger();
}
public String getDivisionFrm() {
	return division.getString();
}
public String getFullName() {
	return ("".equals(id)?"":id+" ")+name;
}
public String getId() {
	return id;
}
public Integer getKey() {
	return key.getInteger();
}
public String getKeyFrm() {
	return key.getString();
}
public BigDecimal getLatitude() {
	return latitude.getBigDecimal();
}
public String getLatitudeFrm() {
	return latitude.getString();
}
public BigDecimal getLongitude() {
	return longitude.getBigDecimal();
}
public String getLongitudeFrm() {
	return longitude.getString();
}
public String getName() {
	return name;
}
public Integer getNetzone() {
	return netzone.getInteger();
}
public String getNetzonename() {
	return netzonename;
}
public static String getPositionFullName(PositionAccessBean bean) {
	StringBuffer name = new StringBuffer("");
	try {
		if(bean.getGsmid() != null) {
			name.append("D");
			name.append(bean.getGsmid());
			name.append(" ");
		}
		if(bean.getDampsid() != null) {
			name.append("A");
			name.append(bean.getDampsid());
			name.append(" ");
		}
		name.append(bean.getName());
	} catch(Exception e) {
		// 
	}
	return name.toString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosstate() {
	return posstate;
}
public Integer getRegion() {
	return region.getInteger();
}
public String getRegionname() {
	return regionname;
}
public Integer getSuperregion() {
	return superregion.getInteger();
}
public String getSuperregionname() {
	return superregionname;
}
public void refresh()
{
	PositionAccessBean b = getAccessBean();
	refresh(b);
}
public void refresh(PositionAccessBean b)
{
	if(b == null) {
		id = "";
		name = "";
		address = "";
		superregion.setString("");
		superregionname = "";
		region.setString("");
		regionname = "";
		netzone.setString("");
		netzonename = "";
		latitude.setString("");
		longitude.setString("");
		division.setString("");
		setNotExist(true);
		setEmpty(key.isEmpty());
		setFormatError(!key.isOk());
	} else {
		try {
			key.setInt(b.getStorageplace());
			// Position name and id
			name = b.getName();
			id = "";
			if(b.getGsmid() != null) {
				id += "D" + b.getGsmid();
			}
			if(id.length() > 0) {
				id += " ";
			}
			if(b.getDampsid() != null) {
				id += "A" + b.getDampsid();
			}
			
			// Address and coords
			address = b.getAddress();
			latitude.setBigDecimal(b.getLatitude());
			longitude.setBigDecimal(b.getLongitude());
			posstate = b.getPosstate();

			DivisionAccessBean d = b.getDivision();
			if(d != null) {
				division.setInteger(
					new Integer(d.getDivision())
				);
			}
			
			// Regions and so on
			RegionAccessBean rb = b.getRegion();
			if(rb != null) {
				region.setInteger(new Integer(rb.getRegionid()));
				regionname = rb.getRegname();
				SuperRegionAccessBean srb = rb.getSuperregion();
				if(srb != null) {
					superregion.setInteger(new Integer(srb.getSupregid()));
					superregionname = "";
				} else {
					superregion.setString("");
					superregionname = "";
				}
			} else {
				region.setString("");
				regionname = "";
			}

			NetZoneAccessBean nz = b.getNetZone();
			if(nz != null) {
				netzone.setInteger(new Integer(nz.getNetzone()));
				netzonename = nz.getName();
			} else {
				netzone.setString("");
				netzonename = "";
			}
			setNotExist(false);
			setEmpty(false);
			setFormatError(false);
		} catch(Exception e) {
			setNotExist(true);
			setEmpty(key.isEmpty());
			setFormatError(!key.isOk());
			e.printStackTrace(System.out);
		}
	}
}
protected void setAddress(String newAddress) {
	address = newAddress;
}
protected void setId(String newId) {
	id = newId;
}
public void setKey(Integer newKey) {
	key.setInteger(newKey);
}
public void setKeyFrm(String newKey) {
	key.setString(newKey);
}
protected void setName(String newName) {
	name = newName;
}
protected void setNetzonename(String newNetzonename) {
	netzonename = newNetzonename;
}
/**
 * 
 * @param newPosstate java.lang.String
 */
public void setPosstate(java.lang.String newPosstate) {
	posstate = newPosstate;
}
protected void setRegionname(String newRegionname) {
	regionname = newRegionname;
}
protected void setSuperregionname(String newSuperregionname) {
	superregionname = newSuperregionname;
}
}
