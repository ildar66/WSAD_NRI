package com.hps.july.dataimport.dataobjects;

import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.DebugSupport;

/**
 * Блок данных базовой станции.
 * Creation date: (04.06.2003 20:45:52)
 * @author: Alexander Shrago
 */
public class BsBlockHandler {

    //public final static String MK_
    
    private BlockData blockData;
    private java.util.Map params;
    private PositionImportObject position;
    private BaseStationImportObject basestation;
    private Vector antennes;
     private Vector sectors;
    

//    public static final String KEY_PLANSTATE = "planstate";
    public static final String KEY_REGION = "region";

//public static final String KEY_ROW = "row";
    

/**
 * BsBlockHandler constructor comment.
 * @param t java.util.Map
 */
public BsBlockHandler(int sessid,int row,java.util.Map cells,java.util.Map parameters) {
	super();
	blockData=new BlockData(sessid,row,cells,parameters);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 20:56:32)
 * @return int
 */
public int getErrcount() {
	return blockData.getErrcount();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 20:56:32)
 * @return int
 */
public int getReccount() {
	return blockData.getReccount();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 21:15:20)
 */
public void process() {

    try {
	    blockData.incReccount();
         position = new PositionImportObject(blockData);
        position.process();

       return;

    } catch (Exception e) {
        DebugSupport.printlnError(e);

    }
}
}
