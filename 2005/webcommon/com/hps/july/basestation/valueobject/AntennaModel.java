package com.hps.july.basestation.valueobject;

import com.hps.july.jdbcpersistence.lib.DebugSupport;
import java.math.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Модель антенны. Предоставляет необходимые данные об антене по ключу
 */
public class AntennaModel
	extends Model
{
	private StringAndIntegerProperty key = new StringAndIntegerProperty();
	private String name;
	private String num;
	private StringAndBigDecimalProperty azimut = new StringAndBigDecimalProperty();
	private StringAndIntegerProperty resource = new StringAndIntegerProperty();
	private int sector_id;
public AntennaModel() {
	super();
	refresh();
}
public static void deleteSectorLinks(int id)
	throws Exception
{
    try {
		DebugSupport.printlnTest("deleteSectorLinks started ");
		//AntennaWorkBandAccessBean aBands = null;
		Antena2sectorAccessBeanTable table = new Antena2sectorAccessBeanTable();
		try {
			table.setAntena2sectorAccessBean(new Antena2sectorAccessBean().findAntena2sectorsByAntenna(new AntennaKey(id)));
            if (table.numberOfRows() == 0) {
				throw new javax.ejb.FinderException();
			}
		} catch (javax.ejb.FinderException e1) {
			DebugSupport.printlnTest("There are no sector links ");
			return;
        }
        for (int i = 0; i < table.numberOfRows(); i++) {
			table.getAntena2sectorAccessBean(i).getEJBRef().remove(); //delete
			DebugSupport.printlnTest("Sector link was deleted");
		}
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
    }
}
public static void deleteWorkBands(int id) throws Exception {
    try {
        AntennaWorkBandAccessBeanTable table = new AntennaWorkBandAccessBeanTable();
        try {
			table.setAntennaWorkBandAccessBean(new AntennaWorkBandAccessBean().findAntennaWorkBandsByAntenna(new AntennaKey(id)));
			if (table.numberOfRows() == 0)
				throw new javax.ejb.FinderException();
		} catch (javax.ejb.FinderException e1) {
			DebugSupport.printlnTest("Not to delete. findAntennaWorkBandsByAntenna not found for idAnten=" + id);
			return;
		}
		for (int i = 0; i < table.numberOfRows(); i++) {
			DebugSupport.printlnTest("before delete. WorkBands for idAnten=" + id);
			table.getAntennaWorkBandAccessBean(i).getEJBRef().remove(); //delete
			DebugSupport.printlnTest("WorkBands for idAnten=" + id + " was deleted");
		}
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
	}
}
public AntennaAccessBean getAccessBean() {
	if(key.getInteger() == null) {
		return null;
	} else {
		try {
			AntennaAccessBean p = new AntennaAccessBean();
			p.setInitKey_idanten(key.getInteger().intValue());
			p.refreshCopyHelper();
			return p;
		} catch(Exception e) {
			return null;
		}
	}
}
public BigDecimal getAzimut() {
	return azimut.getBigDecimal();
}
public String getAzimutFrm() {
	return azimut.getString();
}
public String getFullName() {
	String result = ((num == null)?"":num) + " " + ((name == null)?"":name);
	result = result.trim();
	return result;
}
public Integer getKey() {
	return key.getInteger();
}
public String getKeyFrm() {
	return key.getString();
}
public String getName() {
	return name;
}
public String getNum() {
	return num;
}
public Integer getResource() {
	return resource.getInteger();
}
public String getResourceFrm() {
	return resource.getString();
}
public void refresh() {
	AntennaAccessBean b = getAccessBean();
	refresh(b);
}
public void refresh(AntennaAccessBean b)
{
	if(b == null) {
		name = "";
		num = "";
		azimut.setString("");
		setNotExist(true);
		setEmpty(key.isEmpty());
		setFormatError(!key.isOk());
	} else {
		try {
			key.setInteger(new Integer(b.getIdanten()));
			num = b.getNumant();
			if(b.getResource() != null) {
				resource.setInteger(new Integer(b.getResource().getResource()));
				name = b.getResource().getModel();
			}
			azimut.setBigDecimal(b.getAzant());
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
protected void setAzimut(BigDecimal newAzimut) {
	azimut.setBigDecimal(newAzimut);
}
protected void setAzimutFrm(String newAzimut) {
	azimut.setString(newAzimut);
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
protected void setNum(String newNum) {
	num = newNum;
}
protected void setResource(Integer newKey) {
	resource.setInteger(newKey);
}
protected void setResourceFrm(String newKey) {
	resource.setString(newKey);
}
}
