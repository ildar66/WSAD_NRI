package com.hps.july.dataimport.dataobjects;

import java.util.*;
import com.hps.july.persistence.*;
import java.math.BigDecimal;
import javax.ejb.FinderException;
import com.hps.july.jdbcpersistence.lib.DebugSupport;
import com.hps.july.jdbcpersistence.lib.TablesRef;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.basestation.valueobject.BaseStationObject;
/**
 * Объект импорта базовых станций.
 * Creation date: (05.06.2003 14:34:09)
 * @author: Alexander Shrago
 */
public class BaseStationImportObject extends AbstractImportObject {
    private Integer number;
    private String name;
    private Boolean onair=Boolean.TRUE;
    private String equipmentState=BaseStationObject.STATE_CHECK_WORK_W;
    private String stationType=BaseStationObject.TYPE_CHECK_GSM_G;
    private PositionImportObject position;

/**
 * PositionImportObject constructor comment.
 */
public BaseStationImportObject(BlockData bld,PositionImportObject pos) {
	super(bld);
	
	position=pos;
	
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2003 17:35:29)
 */
public void checkFields() throws Throwable {
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public void create() throws Throwable {
    try {
        com.hps.july.commonbean.KeyGeneratorAccessBean keyGen =
            new com.hps.july.commonbean.KeyGeneratorAccessBean();

        BaseStationAccessBean bs = new BaseStationAccessBean(

        /*int argStorageplace,*/ keyGen.getNextKey(TablesRef.BASESTATIONS),
        /*Integer argDivision,*/ null,
        /*String argName,*/ getName(),
        /*String argAddress,*/ null,
        /*Integer argPosition,*/ new Integer(getPosition().getPositionBean().getStorageplace()),
        /*String argType,*/ getStationType(),
        /*Boolean argRepeater,*/ Boolean.FALSE,
        /*Integer argNumber,*/ getNumber(),
        /*String argSName*/ getName());

        setBean(bs);

        DebugSupport.printlnTest("bs created id="+getBaseStationBean().getStorageplace());
        DebugSupport.printlnTest("name="+getBaseStationBean().getName());
        DebugSupport.printlnTest("position="+getBaseStationBean().getPositionKey().storageplace);
        DebugSupport.printlnTest("type="+getBaseStationBean().getStationType());
        DebugSupport.printlnTest("number="+getBaseStationBean().getNumber());
        

    } catch (Exception e) {
        //setError(0, "bs.create.error");
        getBsRecordLogger(BsRecordLogger.ACTION_I).writeError("bs.create.error",getYKey());
        //DebugSupport.printlnError(e);
        throw new Throwable(e.getMessage());

    }

}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 21:34:23)
 * @return com.hps.july.dataimport.dataobjects.PositionImportObject
 */
public boolean find() throws Throwable {
    DebugSupport.printlnTest("find basestation");
    DebugSupport.printlnTest("number=" + getNumber());
    DebugSupport.printlnTest("type=" + getStationType());
    DebugSupport.printlnTest(
        "position=" + getPosition().getPositionBean().getStorageplace());

    return find(
        getNumber(),
        getStationType(),
        new Integer(getPosition().getPositionBean().getStorageplace()));

}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 21:34:23)
 * @return com.hps.july.dataimport.dataobjects.PositionImportObject
 */
private boolean find(Integer number, String stationType, Integer pos)
    throws Throwable {

    try {
        BaseStationAccessBeanTable table = new BaseStationAccessBeanTable();

        table.setBaseStationAccessBean(
            new BaseStationAccessBean().findByBSNumber(getNumber()));

        Vector objs = new Vector();

        for (int i = 0; i < table.numberOfRows(); i++) {
            if (table.getBaseStationAccessBean(i).getPositionKey().storageplace
                == pos.intValue()
                && table.getBaseStationAccessBean(i).getStationType().equals(getStationType())) {

                objs.add(table.getBaseStationAccessBean(i));
            }
        }

        if (objs.size() == 0) {
            throw new FinderException("table is empty");
        }

        if (objs.size() > 1) {
            System.out.println(
                "error!! few basestation were found. number="
                    + number
                    + " position="
                    + pos
                    + " stationType="
                    + stationType);
        }
        setBean((BaseStationAccessBean) objs.get(0));
        return true;

        //return null;

    } catch (FinderException e) {
        return false;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        getBsRecordLogger().writeError("bs.finder.error",getYKey());
        throw new Throwable(e.getMessage());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 21:07:22)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
public BaseStationAccessBean getBaseStationBean() {
	
	return getBean()==null?null:(BaseStationAccessBean)getBean();
	
	
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 18:03:11)
 * @return java.lang.String
 */
public java.lang.String getName() throws Throwable{

    
    return position.getGsmName();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 12:44:34)
 */
public Integer getNumber() throws Throwable {
if(number==null){
	number=new Integer(-1);
	number=position.getGsmid();
	}
 
 return number;
 }
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 13:30:03)
 * @return java.lang.String
 */
public java.lang.String getObjectKey() {

    try {
        if (getNumber().intValue() == -1) {
            throw new Exception("number=-1");
        }
        return getNumber().toString();
    } catch (Throwable e) {
        return "?";

    }
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2003 22:33:28)
 * @return java.lang.String
 */
public String getObjectLabel() {
    return "БС";
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 20:13:51)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getOnair() {
	return onair;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 20:50:17)
 * @return com.hps.july.dataimport.dataobjects.PositionImportObject
 */
public PositionImportObject getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 20:27:09)
 * @return java.lang.String
 */
public java.lang.String getStationType() {
	return stationType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 18:36:26)
 */
public void process() {

    try {
        super.process();
        for (int i = 0; i < ((String[]) getBlockData().get("K")).length; i++) {
            new AntennaImportObject(getBlockData(), this, i).process();
        }
        return;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        writeError();
    } catch (Throwable tr) {
        DebugSupport.printlnError(tr);
    }

}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 20:50:18)
 * @param newPosition com.hps.july.dataimport.dataobjects.PositionImportObject
 */
public void setPosition(PositionImportObject newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public void update() throws Throwable {
    try {
        getBaseStationBean().setStationName(getName());

        getBaseStationBean().commitCopyHelper();

        DebugSupport.printlnTest("bs updated id="+getBaseStationBean().getStorageplace());
        DebugSupport.printlnTest("name="+getBaseStationBean().getStationName());
        
        

        

        //getBsRecordLogger(BsRecordLogger.ACTION_U).writeSuccess();

    } catch (Exception e) {
	    getBsRecordLogger(BsRecordLogger.ACTION_U).writeError("bs.update.error",getYKey());
        //setError(0, "position.update.error");
        DebugSupport.printlnError(e);
        throw new Throwable(e.getMessage());

    }

}
}
