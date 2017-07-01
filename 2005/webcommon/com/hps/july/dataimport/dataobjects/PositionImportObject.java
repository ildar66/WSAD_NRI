package com.hps.july.dataimport.dataobjects;

import java.util.*;
import com.hps.july.persistence.*;
import java.math.BigDecimal;
import javax.ejb.FinderException;
import com.hps.july.jdbcpersistence.lib.DebugSupport;
import com.hps.july.jdbcpersistence.lib.TablesRef;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
 * Объект импорта данных по позициям.
 * Creation date: (05.06.2003 14:34:09)
 * @author: Alexander Shrago
 */
public class PositionImportObject extends AbstractImportObject {
    private Integer gsmid;
    private String gsmName;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private NetZoneAccessBean netzone;
    private RegionAccessBean region;
//    private String planstate;
    private String objectKey;
/**
 * PositionImportObject constructor comment.
 */
public PositionImportObject(BlockData bld) {
	super(bld);
	
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2003 17:35:29)
 */
public  void checkFields() throws Throwable {
getGsmid();
getGsmName();
getAddress();
getNetzone();
getLatitude();
getLongitude();	
	}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public void create() throws Throwable {
    try {
        com.hps.july.commonbean.KeyGeneratorAccessBean keyGen =
            new com.hps.july.commonbean.KeyGeneratorAccessBean();

        PositionAccessBean pos =
            new PositionAccessBean(
                keyGen.getNextKey(TablesRef.POSITIONS),
                getGsmName(),
                getAddress(),
                new Integer(getNetzone().getNetzone()),
                getLatitude(),
                getLongitude(),
                getRegion().getRegionid(),
                "2");

        //getBsRecordLogger(BsRecordLogger.ACTION_I).writeSuccess();

        pos.setGsmid(getGsmid());

        pos.commitCopyHelper();

        setBean(pos);

        DebugSupport.printlnTest("position was created id=" + pos.getStorageplace());
        DebugSupport.printlnTest("name =" + pos.getName());
        //DebugSupport.printlnTest("adress=" + pos.getAddress());
        DebugSupport.printlnTest("netzone=" + pos.getNetZoneKey().netzone);
        //DebugSupport.printlnTest("latidude=" + pos.getLatitude());
        //DebugSupport.printlnTest("longitude=" + pos.getLongitude());
        DebugSupport.printlnTest("region=" + pos.getRegionKey().regionid);
        DebugSupport.printlnTest("palnstate=" + pos.getPlanstate());

    } catch (Exception e) {
        getBsRecordLogger(BsRecordLogger.ACTION_I).writeError(
            "position.create.error",
            getYKey());
        //setError(0, "position.create.error");
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

    return find(getGsmid());

}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 21:34:23)
 * @return com.hps.july.dataimport.dataobjects.PositionImportObject
 */
private boolean find(Integer gsmid) throws Throwable {

    try {
        DebugSupport.printlnTest("find position");
        DebugSupport.printlnTest("gsmid=" + gsmid);
        
//        DebugSupport.printlnTest("planstate=" + planstate);

        PositionAccessBeanTable table = new PositionAccessBeanTable();

        // Найдем позиции по данному GSMID
        table.setPositionAccessBean(
            new PositionAccessBean().findByQBE(
                Boolean.FALSE,
                new Integer(1),
                Boolean.TRUE,
                gsmid + "",
                Boolean.FALSE,
                "",
                Boolean.FALSE,
                "",
                Boolean.FALSE,
                "",
                new Integer(1)));

        Vector objs = new Vector();

        // Отберем из найденных позиций кандидатов на обновление
        for (int i = 0; i < table.numberOfRows(); i++) {
            if ( (table.getPositionAccessBean(i).getRegionKey().regionid == getRegion().getRegionid()) && 
	            (!"D".equals(table.getPositionAccessBean(i).getPosstate())) ) {
                	objs.add(table.getPositionAccessBean(i));
            }
        }

        if (objs.size() == 0) {
            throw new FinderException("table is empty");
        }

        // Если с одним GSMID в данном регионе существует более 1 позиции - это ошибка
        if (objs.size() > 1) {
        	getBsRecordLogger().writeError("position.finder.morethanone", getYKey());
        	throw new Throwable("More than 1 position with gsmid=" + getGsmid() + " found - error, region=" + getRegion().getRegionid());
        }

        // Переведем позицию в состояние - эксплуатируется
        PositionAccessBean pbean = (PositionAccessBean) objs.get(0);
        pbean.setPosstate("E");
        pbean.commitCopyHelper();
        setBean(pbean);
        return true;

        //return null;

    } catch (FinderException e) {
        DebugSupport.printlnTest("position not found");
        return false;
    } catch (Exception e) {
        //setError(0, "position.finder.error");
        getBsRecordLogger().writeError("position.finder.error", getYKey());
        throw new Throwable(e.getMessage());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 18:03:11)
 * @return java.lang.String
 */
public java.lang.String getAddress() throws Throwable{

    if (address == null) {
        address = getString("D",  "position.address.empty");

    }

    return address;
}
public final static java.math.BigDecimal getCoords(String field) {

 	if(field==null||field.trim().length()==0){
		return new BigDecimal(0);
	}   

 	// DD - new coords format ##-##-##,#
 	double gr = 0;
 	double min = 0;
 	double sec = 0;
 	String field1 = field.replace(',', '.');
 	StringTokenizer atoks = new StringTokenizer(field1, "-");
 	if (atoks.hasMoreTokens()) {
	 	gr = Double.valueOf(atoks.nextToken()).doubleValue();
 		if (atoks.hasMoreTokens()) {
	 		min = Double.valueOf(atoks.nextToken()).doubleValue();
 			if (atoks.hasMoreTokens()) {
	 			sec = Double.valueOf(atoks.nextToken()).doubleValue();
 			}
 		}
 	}
 	
 /*
	char quote = '"';
    String sq = String.valueOf(quote);

    int i = field.indexOf(",");
    if (i != -1)
        field = field.substring(0, i) + "." + field.substring(i + 1);

    i = field.indexOf("°");
    double gr = Double.valueOf(field.substring(0, i)).doubleValue();

    int j = field.indexOf("'");
    double min = Double.valueOf(field.substring(i + 1, j)).doubleValue();

    int k = field.indexOf(sq);
    double sec = Double.valueOf(field.substring(j + 1, k)).doubleValue();
*/
    
    double d = gr + min / 60 + sec / 3600;
System.out.println("D:"+d+", Gr:"+gr+", Min:"+min+", Sec:"+sec);    
    String round = String.valueOf(d);
    int i = round.indexOf(".");
    if (round.length() > i + 6 + 1)
        round = round.substring(0, i + 6 + 1);
        
    return new java.math.BigDecimal(round);

}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 12:44:34)
 */
public Integer getGsmid() throws Throwable {

 if(gsmid==null){
	 gsmid=new Integer(-1); 
	gsmid=getInteger("B","position.gsmid.invalid");
 }
 return gsmid;
 }
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 18:03:11)
 * @return java.lang.String
 */
public java.lang.String getGsmName() throws Throwable {
    try {
        if (gsmName == null) {
            gsmName = getString("C", "position.name.empty");

        }

        return gsmName;
    } catch (Exception e) {
        throw new Throwable(e.getMessage());
    }
}
public java.math.BigDecimal getLatitude() 
	throws Throwable
{
	if(latitude==null){
		try {
			latitude = parseDegree(((String[]) getBlockData().get("F"))[0]);
		} catch (Exception e) {
			DebugSupport.printlnError(e);
			getBsRecordLogger().writeError("position.latitude.error", getCellXY("F"));
			throw new Throwable(e.getMessage());
		}
	}
	return latitude;
}
public java.math.BigDecimal getLongitude() throws Throwable {
	if(longitude==null){
		try {
			longitude = getCoords(((String[]) getBlockData().get("G"))[0]);
		} catch (Exception e) {
			DebugSupport.printlnError(e);
			getBsRecordLogger().writeError("position.longitude.error", getCellXY("G"));
			throw new Throwable(e.getMessage());
		}
	}
	return longitude;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 12:44:34)
 */
public NetZoneAccessBean getNetzone() throws Throwable {

    if (netzone == null||true) {
        try {
            String code = getString("E",  "position.netzone.empty");
            NetZoneAccessBeanTable table = new NetZoneAccessBeanTable();
            table.setNetZoneAccessBean(new NetZoneAccessBean().findAllOrderByNameAsc());
            Integer val = null;
            for (int i = 0; i < table.numberOfRows(); i++) {
                if (table.getNetZoneAccessBean(i).getZonecode().equals(code)) {
                    netzone = table.getNetZoneAccessBean(i);
                    break;
                }
            }
        } catch (Exception e) {
DebugSupport.printlnError(e);
            getBsRecordLogger().writeError("position.netzone.invalid", getCellXY("E"));
            throw new Throwable(e.getMessage());
        }
        //setError("E",0,"position.netzone.invalid"); 
    }
    return netzone;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 13:30:03)
 * @return java.lang.String
 */
public java.lang.String getObjectKey() {
	
	try{
		if(getGsmid().intValue()==-1){
			throw new Exception("gsmid=-1");
			} 
	return getGsmid().toString();
	}catch(Throwable e){
		return "?";
		
		}
	}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2003 22:33:28)
 * @return java.lang.String
 */
public String getObjectLabel() {
    return "позиция";
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 21:01:47)
 * @return com.hps.july.persistence.PositionAccessBean
 */
public PositionAccessBean getPositionBean() {
	return getBean()==null?null:(PositionAccessBean)getBean();
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 12:44:34)
 */
public RegionAccessBean getRegion() throws Exception {

    if (region == null) {
        Integer regionId =
            (Integer) getBlockData().getProp().get(BsBlockHandler.KEY_REGION);
        region = new RegionAccessBean();
        region.setInitKey_regionid(regionId.intValue());
        region.refreshCopyHelper();
    }
    return region;
}
public static final BigDecimal parseDegree(String coords)
{
	String field = coords;

	if(field != null) { field = field.trim(); }	
	if(field == null || field.trim().length() == 0)	{
		throw new java.lang.NumberFormatException("Null coords");
	}

	field = field.replace(',', '.');
	StringTokenizer atoks = new StringTokenizer(field, "-", true);
	String next = "", prev = "";
	int tc = 0;
	double[] g = new double[3];
	for(int i = 0; i < 3 && atoks.hasMoreTokens(); ) {
		next = atoks.nextToken().trim();
		if("-".equals(next)) {
			tc++;
			if("-".equals(prev)) { i++; }
		} else {
			g[i] = Double.valueOf(next).doubleValue();
			i++;
		}
		prev = next;
	}
	if(atoks.hasMoreTokens() && tc > 2) {
		throw new NumberFormatException("Format unknown");
	}

	double d = g[0] + g[1] / 60 + g[2] / 3600;
	if(field.charAt(0) == '-') {
		d = -d;
	}
	if(Math.abs(d) > 360.0d) {
		throw new java.lang.NumberFormatException("Given value exceed 360 degree");
	}

	return new BigDecimal(d).setScale(6,BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 18:36:26)
 */
public void process() {
    try {
        super.process();

        new BaseStationImportObject(getBlockData(), this).process();

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        writeError();
    } catch (Throwable tr) {
        DebugSupport.printlnError(tr);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public void update() throws Throwable {
    try { 
        getPositionBean().setLatitude(getLatitude());
        getPositionBean().setLongitude(getLongitude());
        getPositionBean().setName(getGsmName());
        getPositionBean().setAddress(getAddress());
        getPositionBean().setNetZone(
            (NetZone) javax.rmi.PortableRemoteObject.narrow(
                getNetzone().getEJBRef(),
                NetZone.class));
        getPositionBean().setRegion(
            (Region) javax.rmi.PortableRemoteObject.narrow(
                getRegion().getEJBRef(),
                Region.class));
        getPositionBean().setGsmid(getGsmid());

        getPositionBean().commitCopyHelper();

        DebugSupport.printlnTest("position was updated id=" + getPositionBean().getStorageplace());
        DebugSupport.printlnTest("name =" + getPositionBean().getName());
        DebugSupport.printlnTest("adress=" + getPositionBean().getAddress());
        DebugSupport.printlnTest("netzone=" + getPositionBean().getNetZoneKey().netzone);
        DebugSupport.printlnTest("latidude=" + getPositionBean().getLatitude());
        DebugSupport.printlnTest("longitude=" + getPositionBean().getLongitude());
        //DebugSupport.printlnTest("region=" + getRegion().intValue());
        //DebugSupport.printlnTest("palnstate=" + getPlanstate());

        //getBsRecordLogger(BsRecordLogger.ACTION_U).writeSuccess();

    } catch (Exception e) {
        getBsRecordLogger(BsRecordLogger.ACTION_I).writeError(
            "position.update.error",
            getYKey());
        //setError(0, "position.update.error");
        //DebugSupport.printlnError(e);
        throw new Throwable(e.getMessage());

    }

}
}
