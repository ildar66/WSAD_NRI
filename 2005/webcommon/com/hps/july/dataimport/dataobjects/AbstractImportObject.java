package com.hps.july.dataimport.dataobjects;

import java.util.*;
import com.hps.july.persistence.*;
import java.math.BigDecimal;
import javax.ejb.FinderException;
import com.hps.july.jdbcpersistence.lib.DebugSupport;
import com.hps.july.jdbcpersistence.lib.TablesRef;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
/**
 * Абстрактный объект импорта.
 * Creation date: (05.06.2003 14:34:09)
 * @author: Alexander Shrago
 */
public abstract class AbstractImportObject {
    private AbstractEntityAccessBean bean;
    private BlockData blockData;
    //private int reccount;
    //private int errcount;
    private boolean wasError=false;

/**
 * PositionImportObject constructor comment.
 */
public AbstractImportObject() {
	super();
}
/**
 * PositionImportObject constructor comment.
 */
public AbstractImportObject(BlockData bld) {
	super();
	blockData=bld;
	//bld.reccount++;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2003 17:35:29)
 */
public abstract void checkFields() throws Throwable; 
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public abstract void create() throws Throwable;
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 21:34:23)
 * @return com.hps.july.dataimport.dataobjects.PositionImportObject
 */
public abstract boolean find() throws Throwable;

/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 21:05:04)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getBean() {
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2003 18:46:27)
 * @return java.lang.Integer
 * @param dataKey java.lang.String
 * @param errKey java.lang.String
 * @param canNull boolean
 */
public BigDecimal getBigDecimal(String xKey,  String errKey) throws Throwable {

 int index=getIndex(); 
	try {
        String par = getCellString(xKey);
        
        // DD - Drop all characters before first digit - due to invalid symbols before number
        while ((par.substring(0, 1).compareTo("0") < 0) || (par.substring(0, 1).compareTo("9") > 0))
        	par = par.substring(1, par.length());
        DebugSupport.printlnTest("importing BigDecimal from string='" + par + "'");
		com.hps.july.web.util.StringAndBigDecimalProperty p = 
			new com.hps.july.web.util.StringAndBigDecimalProperty();
		p.setString(par);
		if(p.isEmpty() || !p.isOk()) {
			throw new NumberFormatException("Unparsable value ["+par+"]");
		}
		return p.getBigDecimal();
//        return new BigDecimal(par);
    } catch (Exception e) {
		getBsRecordLogger().writeError(errKey, getCellXY(xKey));
		DebugSupport.printlnError(e);
		throw new Throwable(e.getMessage());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 21:51:49)
 * @return com.hps.july.dataimport.dataobjects.BlockData
 */
public BlockData getBlockData() {
	return blockData;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2003 17:26:08)
 * @return com.hps.july.dataimport.dataobjects.BsRecordLogger
 */
public BsRecordLogger getBsRecordLogger() {
    
	String label;
    try {
        label = getObjectLabel() + "_" + getObjectKey();
    } catch (Exception e) {
        label = getObjectLabel() + "_?";
    }
    
    return new BsRecordLogger(blockData, getLabelKey());
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2003 17:26:08)
 * @return com.hps.july.dataimport.dataobjects.BsRecordLogger
 */
public BsRecordLogger getBsRecordLogger(String action) {
	
	String label;
    try {
        label = getObjectLabel() + "_" + getObjectKey();
    } catch (Exception e) {
        label = getObjectLabel() + "_?";
    }
	
	return new BsRecordLogger(blockData,label,action);
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2003 21:39:57)
 * @return java.lang.String
 * @param key java.lang.String
 */
public String getCellString(String key) {
	String res = ((String[]) blockData.get(key))[getIndex()];
	if (res != null)
		return res.trim();
	else
		return res;
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2003 20:37:16)
 * @return java.lang.String
 * @param xPar java.lang.String
 * @param yPar java.lang.String
 */
public String getCellXY(String xPar) {
	return "("+xPar+","+getYKey()+")";
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2003 22:44:43)
 * @return int
 */
public int getIndex() {
	return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2003 18:46:27)
 * @return java.lang.Integer
 * @param dataKey java.lang.String
 * @param errKey java.lang.String
 * @param canNull boolean
 */
public Integer getInteger(String xKey, String errKey) throws Throwable {
    int index = getIndex();
    try {
        String par = getCellString(xKey);
        return new Integer(par);
    } catch (Exception e) {

        
        getBsRecordLogger().writeError(errKey, getCellXY(xKey));
        DebugSupport.printlnError(e);
        throw new Throwable(e.getMessage());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2003 17:44:20)
 * @return java.lang.String
 */
public String getLabelKey() {
	return getObjectLabel()+"_"+getObjectKey();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 13:30:03)
 * @return java.lang.String
 */
public abstract String getObjectKey();
/**
 * Insert the method's description here.
 * Creation date: (16.06.2003 22:33:28)
 * @return java.lang.String
 */
public String getObjectLabel() {
    return "";
}
/**
 * Insert the method's description here.
 * Creation date: (05.06.2003 18:46:27)
 * @return java.lang.Integer
 * @param dataKey java.lang.String
 * @param errKey java.lang.String
 * @param canNull boolean
 */
public String getString(String xKey,  String emptyKey)
    throws Throwable {

int index=getIndex();
	    try {
        String par = getCellString(xKey);
        if (emptyKey != null) {
            if (par == null || par.length() == 0) {
                throw new Exception(
                    "BlockData getString must not be null h=" + xKey + " row=" + getYKey());
            }
        }
        return par;

        //return Integer.getInteger(par);
    } catch (Exception e) {

        
        getBsRecordLogger().writeError(emptyKey,getCellXY(xKey) );
        DebugSupport.printlnError(e);
        throw new Throwable(e.getMessage());
        //return null;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2003 17:10:18)
 * @return java.lang.String
 * @param index int
 */
public String getYKey() {
	int s=getIndex()+blockData.getRowStart();
	return s+"";
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2003 22:13:45)
 * @return boolean
 */
public boolean isWasError() {
	return wasError;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 18:36:26)
 */
public void process() throws Throwable {
    try {
        checkFields();

        if (find()) {
            update();
            DebugSupport.printlnTest(
                "update success " + getObjectLabel() + " " + getObjectKey());
            getBsRecordLogger(BsRecordLogger.ACTION_U).writeSuccess();
        } else {
            create();
            DebugSupport.printlnTest(
                "create success " + getObjectLabel() + " " + getObjectKey());
            getBsRecordLogger(BsRecordLogger.ACTION_I).writeSuccess();
        }
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        writeError();
        throw new Throwable(e.getMessage());

    }
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 21:05:04)
 * @param newBean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void setBean(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean newBean) {
	bean = newBean;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2003 22:13:45)
 * @param newWasError boolean
 */
public void setWasError(boolean newWasError) {
	wasError = newWasError;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public abstract void update() throws Throwable;
/**
 * Insert the method's description here.
 * Creation date: (16.06.2003 22:52:46)
 */
public void writeError() {

     getBsRecordLogger().writeError(
        "object.handler.error",
        getObjectLabel(),
        getYKey());

        }
}
