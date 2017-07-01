package com.hps.july.dataimport.dataobjects;

import javax.ejb.*;
import com.hps.july.persistence.*;
import com.hps.july.dataimport.lib.*;
/**
   * Ограничения мощности по каналам базовых станций
*/
public class BsChanalPower {
private ChanalPowerAccessBean bean;
private static BaseStationAccessBean basestation;	
/**
 * ChanalPower constructor comment.
 */
public BsChanalPower() {
	super();
	bean=new ChanalPowerAccessBean();
	
}
public BsChanalPower(
    Integer equipment,
    Integer chanal,
    Integer power,
    String polar)
    throws Exception {

    try {

        if (chanal.intValue() < 0 || chanal.intValue() > 124) {
            throw new com.hps.july.dataimport.lib.RecordLoggerTargetException(
                "chanalpower.error.chanal",
                new String[] { chanal + "" });
        }
        bean =
            new ChanalPowerAccessBean(
                basestation.getStorageplace(),
                chanal.intValue(),
                polar,
                power.intValue());

    } catch (com.hps.july.dataimport.lib.RecordLoggerTargetException e1) {

        throw e1;
    } catch (Exception e) {

        throw new Exception(e.getMessage());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (14.04.2003 14:31:38)
 * @return java.lang.Integer
 * @param code java.lang.Integer
 */
private void findBaseStation(Integer code) throws Exception {

    try {
        BaseStationAccessBeanTable table = new BaseStationAccessBeanTable();
        table.setBaseStationAccessBean(
            new BaseStationAccessBean().findByBSNumber(code));
        basestation = table.getBaseStationAccessBean(0);
    } catch (Exception e) {
	    basestation=null;
     throw new com.hps.july.dataimport.lib.RecordLoggerTargetException("error.bs.absent",new String[]{code.toString()},Importer.ERRACTION_NextRow);   
	    //throw new Exception("Base station not found");

    }

}
public boolean findByBsAndChanalAndPolar(
    Integer bs,
    Integer chanal,
    String polar)
    throws Exception {
    try {
        findBaseStation(bs);

        bean.setInitKey_basestation_storageplace(
            new Integer(basestation.getStorageplace()));
        bean.setInitKey_chanal(chanal.intValue());
        bean.setInitKey_polarization(polar);
        bean.refreshCopyHelper();
    } catch (com.hps.july.dataimport.lib.RecordLoggerTargetException e1) {
	    throw e1;
        //return false;    
    } catch (FinderException e2) {
        return false;
    } catch (Exception e3) {
        throw new Exception(e3.getMessage());
    }
    return true;
}
public void setPower(Integer power) throws Exception {

    try {

        bean.setPower(power.intValue());
        bean.commitCopyHelper();

    } catch (Exception e) {

        throw new Exception(e.getMessage());
    }

}
}
