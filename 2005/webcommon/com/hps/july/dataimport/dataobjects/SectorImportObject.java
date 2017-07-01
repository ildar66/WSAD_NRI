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
 * Объект импорта данных по секторам.
 * Creation date: (05.06.2003 14:34:09)
 * @author: Alexander Shrago
 */
public class SectorImportObject extends AbstractImportObject {
    
    private String number;
    private String name;
    private AntennaImportObject antenna;
    private String code;
    private short band;
    private Integer trxnum;
    private BigDecimal azimut;
    private Boolean haslna=Boolean.FALSE;
    private int order;
    private int orderNum;

    private static Hashtable mapOrderNumByCode;
    private static Hashtable mapCodeByOrderNum;
    private static Hashtable mapBandByOrderNum;
    

/**
 * PositionImportObject constructor comment.
 */
public SectorImportObject(BlockData bld,AntennaImportObject antenna,int order) {
	super(bld);
	this.antenna=antenna;
	this.order=order;
	
	
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 19:34:02)
 * @param sector com.hps.july.dataimport.dataobjects.SectorImportObject
 */
public void addAntennaLink()  {

    try {
        Antena2sectorAccessBean link =
            new Antena2sectorAccessBean(
                getAntenna().getAntennaBean().getIdanten(),
                getSectorBean().getIdsect(),Boolean.TRUE);
    } catch (Exception e) {
        getBsRecordLogger().writeError(
            "sector.addlink.invalid",
            getYKey(),
            code.substring(0, 1));
        
    }
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2003 17:35:29)
 */
public void checkFields() throws Throwable {
 getCode();   
	getName();
    getBand();
    getNumber();
    getHaslna();
    getTrxnum();
    
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public void create() throws Throwable {
    try {
        com.hps.july.commonbean.KeyGeneratorAccessBean keyGen =
            new com.hps.july.commonbean.KeyGeneratorAccessBean();

        SectorAccessBean bs = new SectorAccessBean(
        /*int argIdsect,*/ keyGen.getNextKey(TablesRef.SECTORS),
        /*int argEquipment,*/ getAntenna()
        .getAntennaBean()
        .getEquipmentKey()
        .storageplace,
        /*java.lang.String argNamesect,*/ getName(),
        /*short argBand,*/ getBand(),
        /*java.lang.String argNumsect*/ getNumber());

        bs.setAzimut(getAzimut());
        bs.setHaslna(getHaslna());
        bs.setTrxnum(getTrxnum());
        bs.setByhand(Boolean.TRUE);
        bs.commitCopyHelper();
        //getBsRecordLogger(BsRecordLogger.ACTION_I).writeSuccess();
        setBean(bs);

        DebugSupport.printlnTest("sector created id=" + getSectorBean().getIdsect());
        DebugSupport.printlnTest(
            "bs=" + getSectorBean().getEquipmentKey().storageplace);
        DebugSupport.printlnTest("namesect=" + getSectorBean().getNamesect());
        //DebugSupport.printlnTest("band=" + getSectorBean().getBand());
        //DebugSupport.printlnTest("azimut=" + getSectorBean().getAzimut());
        //DebugSupport.printlnTest("haslna=" + getSectorBean().getHaslna());
        //DebugSupport.printlnTest("trxnum=" + getSectorBean().getTrxnum());
        //DebugSupport.printlnTest("trxnum=" + getSectorBean().getTrxnum());

    } catch (Exception e) {
        getBsRecordLogger(BsRecordLogger.ACTION_I).writeError(
            "sector.create.error",
            getYKey(),
            getCode().substring(0, 1));
        //setError(0, "sector.create.error");
        //DebugSupport.printlnError(e);
        throw e;

    }

}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 21:34:23)
 * @return com.hps.july.dataimport.dataobjects.PositionImportObject
 */
public boolean find() throws Throwable {

    try {
        DebugSupport.printlnTest("find sector");
        DebugSupport.printlnTest(
            "bs=" + getAntenna().getAntennaBean().getEquipmentKey().storageplace);
        DebugSupport.printlnTest("numsect=" + getNumber());

        SectorAccessBeanTable table = new SectorAccessBeanTable();

        table.setSectorAccessBean(
            new SectorAccessBean().findByBasestationOrderByNumberAsc(
                new Integer(getAntenna().getAntennaBean().getEquipmentKey().storageplace)));

         Vector objs = new Vector();

        for (int i = 0; i < table.numberOfRows(); i++) {
            if (table.getSectorAccessBean(i).getNumsect().equals(getNumber())) {

                objs.add(table.getSectorAccessBean(i));
            }
        }

        if (objs.size() == 0) {
            throw new FinderException("table is empty");
        }

        if (objs.size() > 1) {
            DebugSupport.println("error!! few sectors were found. number=" + getNumber());
            getBsRecordLogger().writeError(
                "sector.finder.warning.few",
                getNumber(),
                getYKey());
        }
        setBean((SectorAccessBean) objs.get(0));
        return true;

        //return null;

    } catch (FinderException e) {
        return false;
    } catch (Exception e) {
        //setError(0, "sector.finder.error");
        getBsRecordLogger().writeError(
            "sector.finder.error",
            getYKey(),
            getCode().substring(0, 1));
        throw new Throwable(e.getMessage());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 20:01:45)
 * @return com.hps.july.dataimport.dataobjects.AntennaImportObject
 */
public AntennaImportObject getAntenna() {
	return antenna;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2003 22:08:16)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAzimut() throws Exception {
	return getAntenna().getAntennaBean().getAzant();
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2003 18:42:46)
 * @return short
 */
public short getBand() throws Throwable {
    if (band == 0) {
        band = getBandByOrderNum(getOrderNum());
    }

    return band;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2003 21:55:57)
 * @return java.util.Hashtable
 */
public static short getBandByOrderNum(int orderNum) {
	
	Hashtable table=getMapBandByOrderNum();
	return ((Short)table.get(new Integer(orderNum))).shortValue();
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2003 21:19:12)
 * @return java.lang.String
 */
public java.lang.String getCode() throws Throwable {
    try {
        if (code == null) {
            String codesString = getCellString("P");
            StringTokenizer st = new StringTokenizer(codesString, "/");

            for (int i = 0; i < order + 1; i++) {
                code = st.nextToken();
            }
            if (code.equals("O")) {
                code = getAntenna().getFirstSectorNum() == 0 ? "O_0" : "O_9";
            }
            orderNum = getOrderNum(); // checking!
        }

    } catch (Exception e) {
        
        getBsRecordLogger().writeError("sector.code.invalid", code, getCellXY("P"));
        throw new Throwable(e.getMessage());

    }catch (Throwable tr) {
          
        throw tr;

    }
    return code;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2003 21:19:12)
 * @return java.lang.String
 */
public Boolean getHaslna() throws Throwable {
    try {
        String codesString = getCellString("R");
        if (codesString.trim().length() == 0) {
            haslna = getBean() != null ? getSectorBean().getHaslna() : null;
        } else {

            String tok = null;
            StringTokenizer st = new StringTokenizer(codesString, "/");

            for (int i = 0; i < order + 1; i++) {
                tok = st.nextToken();
            }
            if (tok.equals("1")) {
                haslna = Boolean.TRUE;
            } else if (tok.equals("0")) {
                haslna = Boolean.FALSE;
            } else {
                getBsRecordLogger().writeError(
                    "sector.haslna.error",
                    getCellXY("R"),
                    getCode().substring(0, 1));
                throw new Exception(
                    "sector haslna error y="
                        + getCellXY("R")
                        + " code="
                        + getCode().substring(0, 1));

            }
        }
        return haslna;
    } catch (Exception e) {
        throw new Throwable(e.getMessage());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2003 22:44:43)
 * @return int
 */
public int getIndex() {
	return getAntenna().getIndex();
	
	
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2003 21:55:57)
 * @return java.util.Hashtable
 */
public static java.util.Hashtable getMapBandByOrderNum() {
	
	if(mapBandByOrderNum==null){
		mapBandByOrderNum=new Hashtable();
		mapBandByOrderNum.put(new Integer(1),new Short((short)1800));
		mapBandByOrderNum.put(new Integer(2),new Short((short)1800));
		mapBandByOrderNum.put(new Integer(3),new Short((short)1800));
		mapBandByOrderNum.put(new Integer(4),new Short((short)1800));
		mapBandByOrderNum.put(new Integer(0),new Short((short)1800));
		mapBandByOrderNum.put(new Integer(5),new Short((short)900));
		mapBandByOrderNum.put(new Integer(6),new Short((short)900));
		mapBandByOrderNum.put(new Integer(7),new Short((short)900));
		mapBandByOrderNum.put(new Integer(8),new Short((short)900));
		mapBandByOrderNum.put(new Integer(9),new Short((short)900));
		
		
		}
	
	
	return mapBandByOrderNum;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2003 21:55:57)
 * @return java.util.Hashtable
 */
public static java.util.Hashtable getMapOrderNumByCode() {
	
	if(mapOrderNumByCode==null){
		mapOrderNumByCode=new Hashtable();
		mapOrderNumByCode.put("A",new Integer(1));
		mapOrderNumByCode.put("B",new Integer(2));
		mapOrderNumByCode.put("C",new Integer(3));
		mapOrderNumByCode.put("D",new Integer(4));
		mapOrderNumByCode.put("O_0",new Integer(0));
		mapOrderNumByCode.put("E",new Integer(5));
		mapOrderNumByCode.put("F",new Integer(6));
		mapOrderNumByCode.put("G",new Integer(7));
		mapOrderNumByCode.put("H",new Integer(8));
		mapOrderNumByCode.put("O_9",new Integer(9));
		//mapOrderNumByCode.put(new Integer(9),"O");
		
		
		}
	
	
	return mapOrderNumByCode;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 18:03:11)
 * @return java.lang.String
 */
public java.lang.String getName() throws Throwable {
    if (name == null) {
        name =
            getAntenna().getBaseStation().getName() + "_" + getCode().substring(0, 1);
    }
    return name;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 12:44:34)
 */
public String getNumber() throws Throwable {
    
     if(number==null){
	     number="-1"; 
    	number=getAntenna().getBaseStation().getNumber() + "" + getOrderNum();
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
        String str = getNumber();
        if (getNumber().equals("-1")) {
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
    String par = "";
    try {
        par = getCode().substring(0, 1);
    } catch (Throwable e) {

    }
    return "сектор";
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2003 19:25:26)
 * @return int
 */
public int getOrderNum() throws Throwable {
	
	return getOrderNumByCode(getCode());
	
	
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2003 21:55:57)
 * @return java.util.Hashtable
 */
public  int getOrderNumByCode(String code) throws Exception {
    try {
        Hashtable table = getMapOrderNumByCode();
        return ((Integer) table.get(code)).intValue();
    } catch (Exception e) {
        //getBsRecordLogger().writeError("sector.code.invalid", code, getCellXY("E"));
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 21:07:22)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
public SectorAccessBean getSectorBean() {
	
	return getBean()==null?null:(SectorAccessBean)getBean();
	
	
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2003 21:19:12)
 * @return java.lang.String
 */
public Integer getTrxnum() throws Throwable {

    String codesString =
        getCellString("Q");
    if (codesString.trim().length() == 0) {
        trxnum = getBean() != null ? getSectorBean().getTrxnum() : null;
    } else {

        String tok = null;
        StringTokenizer st = new StringTokenizer(codesString, "/");

        for (int i = 0; i < order + 1; i++) {
            tok = st.nextToken();
        }

        try {
            trxnum = new Integer(tok);
        } catch (Exception e) {
            getBsRecordLogger().writeError(
                "sector.trxnum.error",
                getCellXY("Q"),
                getCode().substring(0, 1));
            throw new Throwable(
                "sector trxnum error y="
                    + getCellXY("Q")
                    + " code="
                    + getCode().substring(0, 1));

        }
    }
    return trxnum;

}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 18:36:26)
 */
public void process() throws Throwable {
    try {
        super.process();
        addAntennaLink();
    } catch (Exception e) {
        writeError();
        throw new Throwable(e.getMessage());
    }catch (Throwable tr) {
        
        throw tr;
    }
    

}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2003 22:08:16)
 * @param newAzimut java.math.BigDecimal
 */
public void setAzimut(java.math.BigDecimal newAzimut) {
	azimut = newAzimut;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2003 18:42:46)
 * @param newBand short
 */
public void setBand(short newBand) {
	band = newBand;
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2003 19:31:39)
 * @param newTrxnum java.lang.Integer
 */
public void setTrxnum(java.lang.Integer newTrxnum) {
	trxnum = newTrxnum;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public void update() throws Throwable {
    try {
        getSectorBean().setNamesect(getName());
        getSectorBean().setBand(getBand());
        getSectorBean().setTrxnum(getTrxnum());
        getSectorBean().setAzimut(getAzimut());
        getSectorBean().setHaslna(getHaslna());
        getSectorBean().setByhand(Boolean.TRUE);
        

        getSectorBean().commitCopyHelper();
        //getBsRecordLogger(BsRecordLogger.ACTION_U).writeSuccess();

        DebugSupport.printlnTest("sector updated id="+getSectorBean().getIdsect());
       /*
        //DebugSupport.printlnTest("bs="+getSectorBean().getEquipmentKey().storageplace);
        DebugSupport.printlnTest("namesect="+getSectorBean().getNamesect());
        DebugSupport.printlnTest("band="+getSectorBean().getBand());
        DebugSupport.printlnTest("azimut="+getSectorBean().getAzimut());
        DebugSupport.printlnTest("haslna="+getSectorBean().getHaslna());
        DebugSupport.printlnTest("trxnum="+getSectorBean().getTrxnum());
        DebugSupport.printlnTest("byhand="+getSectorBean().getByhand());
*/
    } catch (Exception e) {
        
	    getBsRecordLogger(BsRecordLogger.ACTION_U).writeError(
            "sector.create.error",
            getYKey(),
            getCode().substring(0,1));
	    //setError(0, "sector.update.error");
        //DebugSupport.printlnError(e);
        throw new Throwable(e.getMessage());

    }

}
}
