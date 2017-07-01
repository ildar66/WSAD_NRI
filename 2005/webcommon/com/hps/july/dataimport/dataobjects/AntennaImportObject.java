package com.hps.july.dataimport.dataobjects;

import java.util.*;
import com.hps.july.persistence.*;
import java.math.BigDecimal;
import javax.ejb.FinderException;
import com.hps.july.jdbcpersistence.lib.DebugSupport;
import com.hps.july.jdbcpersistence.lib.TablesRef;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.basestation.valueobject.BaseStationObject;
import java.math.BigDecimal;
/**
 * Объект импорта антенн.
 * Creation date: (05.06.2003 14:34:09)
 * @author: Alexander Shrago
 */
public class AntennaImportObject extends AbstractImportObject {
    private String number;
    //private String name;
    private BaseStationImportObject baseStation;
    
    private AntennaResourceAccessBean resource;
    private String kindant;
    private BigDecimal azimut;
    private BigDecimal hset1;
    private BigDecimal nakl;
    private BigDecimal lencable;
    private CableResourceAccessBean cableres;
    private int index;
    private Hashtable sectors;

   
    
    
   

/**
 * PositionImportObject constructor comment.
 */
public AntennaImportObject(BlockData bld,BaseStationImportObject bs,int index) {
	super(bld);
	baseStation=bs;
	this.index=index;
	
	
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2003 12:45:08)
 * @param band int
 */
public void addWorkBand(int band) {

    try {
        new AntennaWorkBandAccessBean(getAntennaBean().getIdanten(), (short)band);

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        getBsRecordLogger().writeError("antenna.band.error",getYKey(),band+"");
    }

}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2003 17:35:29)
 */
public void checkFields() throws Throwable {
getNumber();
getResource();
getAzimut();
getKindant();
getNakl();
getHset1();
getCableres();
getLencable();	
	}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public void create() throws Throwable {
    try {
        com.hps.july.commonbean.KeyGeneratorAccessBean keyGen =
            new com.hps.july.commonbean.KeyGeneratorAccessBean();

        AntennaAccessBean ant = new AntennaAccessBean(
        /*int argIdanten,*/ keyGen.getNextKey(TablesRef.ANTENNES),
        /*int argResource,*/ getResource().getResource(),
        /*java.lang.String argNumant,*/ getNumber(),
        /*java.lang.String argKindant,*/ getKindant(),
        /*java.math.BigDecimal argNakl,*/ getNakl(),
        /*java.math.BigDecimal argAzant,*/ getAzimut(),
        /*java.math.BigDecimal argHset1,*/ getHset1(),
        /*java.math.BigDecimal argLencable,*/ getLencable(),
        /*int argEquipment*/ getBaseStation().getBaseStationBean().getStorageplace());

        if (getCableres() != null) {

            ant.setCableres(
                (CableResource) javax.rmi.PortableRemoteObject.narrow(
                    getCableres().getEJBRef(),
                    CableResource.class));
        } else {
            ant.setCableres(null);
        }

        ant.setByhand(Boolean.TRUE);

        ant.commitCopyHelper();

        setBean(ant);

        DebugSupport.printlnTest("antenna created id=" + getAntennaBean().getIdanten());
        DebugSupport.printlnTest(
            "resource=" + getAntennaBean().getResourceKey().resource);
        DebugSupport.printlnTest("numant=" + getAntennaBean().getNumant());
        //DebugSupport.printlnTest("kindant=" + getAntennaBean().getKindant());
        //DebugSupport.printlnTest("nakl=" + getAntennaBean().getNakl());
        //DebugSupport.printlnTest("azant=" + getAntennaBean().getAzant());
        //DebugSupport.printlnTest("hset1=" + getAntennaBean().getHset1());
        //DebugSupport.printlnTest("lencable=" + getAntennaBean().getLencable());
        DebugSupport.printlnTest(
            "ant=" + getAntennaBean().getEquipmentKey().storageplace);
        /*
                DebugSupport.printlnTest(
                    "cableres=" + getAntennaBean().getCableresKey().resource);
        */
        //DebugSupport.printlnTest("byhand=" + getAntennaBean().getByhand());

    } catch (Exception e) {
        getBsRecordLogger(BsRecordLogger.ACTION_I).writeError(
            "antenna.create.error",
            getYKey());

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

    try {

        DebugSupport.printlnTest("find antenna");
        DebugSupport.printlnTest(
            "bs=" + getBaseStation().getBaseStationBean().getStorageplace());
        DebugSupport.printlnTest("number=" + getNumber());
        AntennaAccessBeanTable table = new AntennaAccessBeanTable();

        table.setAntennaAccessBean(
            new AntennaAccessBean().findByEquipmentOrderByNumAsc(
                new Integer(getBaseStation().getBaseStationBean().getStorageplace())));

        Vector objs = new Vector();

        for (int i = 0; i < table.numberOfRows(); i++) {
            if (table.getAntennaAccessBean(i).getNumant().equals(getNumber())) {

                objs.add(table.getAntennaAccessBean(i));
            }
        }

        if (objs.size() == 0) {
            throw new FinderException("table is empty");
        }

        if (objs.size() > 1) {
            System.out.println("error!! few antennes were found. number=" + number);
        }
        setBean((AntennaAccessBean) objs.get(0));
        return true;

        //return null;

    } catch (FinderException e) {
        return false;
    } catch (Exception e) {

        getBsRecordLogger().writeError("antenna.finder.error", getYKey());
        throw new Throwable(e.getMessage());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 21:07:22)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
public AntennaAccessBean getAntennaBean() {
	
	return getBean()==null?null:(AntennaAccessBean)getBean();
	
	
}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2003 22:08:16)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getAzimut() throws Throwable {

    if (azimut == null) {
        azimut = getBigDecimal("O",  "antenna.azimut.error");
    }
    return azimut;
  

}
/**
 * Insert the method's description here.
 * Creation date: (11.06.2003 18:22:34)
 * @return com.hps.july.dataimport.dataobjects.BaseStationImportObject
 */
public BaseStationImportObject getBaseStation() {
	return baseStation;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 17:00:33)
 * @return java.lang.Integer
 */
public CableResourceAccessBean getCableres() throws Throwable {

    final String cellIndex = "S";
    if (cableres != null) {
        return cableres;
    }

    int subTypeCable = 0;
    try {
        NamedValueAccessBean v = new NamedValueAccessBean();
        v.setInitKey_id("ResourceSubType_Cable");
        v.refreshCopyHelper();
        subTypeCable = v.getIntvalue();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }

    try {
        String model = ((String[]) getBlockData().get(cellIndex))[getIndex()];

        if ((model != null) && (model.trim().length() > 0)) {
            model = model.trim();
            CableResourceAccessBeanTable table = new CableResourceAccessBeanTable();
            table
                .setCableResourceAccessBean(new CableResourceAccessBean().findResourcesByQBE(
            /*Boolean isSubtypekey,*/ Boolean.FALSE,
            /*ResourceSubTypeKey subtypeKey,*/ new ResourceSubTypeKey(subTypeCable),
            /*Boolean isModel,*/ Boolean.TRUE,
            /*String model,*/ model,
            /*Boolean isName,*/ Boolean.FALSE,
            /*String name,*/ "",
            /*Integer order*/ new Integer(1)));

            Vector res = new Vector();
            for (int i = 0; i < table.numberOfRows(); i++) {
                res.add(table.getCableResourceAccessBean(i));
            }
            if (res.size() < 1) {
                throw new FinderException("cableres not found");
            }
            if (res.size() > 1) {
                getBsRecordLogger().writeError(
                    "antenna.cableres.warning.few",
                    getCellXY(cellIndex));
            }

            cableres = (CableResourceAccessBean) res.get(0);
        } else {
            cableres = null;
        }

    } catch (Exception e) {
	    DebugSupport.printlnError(e);
//        getBsRecordLogger().writeError("antenna.cableres.error", getCellXY(cellIndex));
//        throw new Throwable(e.getMessage());
		cableres = null;
    }
    //cableres.refreshCopyHelper();
    return cableres;
}
/**
 * Insert the method's description here.
 * Creation date: (16.06.2003 19:08:35)
 * @return int
 */
public int getFirstSectorNum() throws Throwable {
	return Integer.parseInt(getNumber().substring(0,1));
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2003 22:22:35)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getHset1() throws Throwable {
    
        if (hset1 == null) {
            hset1 = getBigDecimal("N", "antenna.hset1.error");
        }

        return hset1;
 
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 20:47:29)
 * @return int
 */
public int getIndex() {
	return index;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 16:31:37)
 * @return java.lang.String
 */
public java.lang.String getKindant() throws Throwable {
    try {
        if (kindant == null) {
            if (getCellString("L").equals("TR")) kindant = "D";
            else if (getCellString("L").equals("T")) kindant = "T";
            else if (getCellString("L").equals("R")) kindant = "R";
            else throw new Exception("invalid kindant");
        }

        return kindant;
    } catch (Exception e) {
        getBsRecordLogger().writeError("antenna.indant.error", getCellXY("L"));
        throw new Throwable(e.getMessage());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 16:32:15)
 * @return java.math.BigDecimal
 */
public BigDecimal getLencable() throws Throwable {
    try {
        if (lencable != null) {
            return lencable;
        }

        String par = getCellString("T");
        if (par == null || par.length() == 0) {
            //if (isPlan()) {
                lencable = new BigDecimal(0);
                return lencable;
            //} else {
            //    getBsRecordLogger().writeError("antenna.lencable.empty", getCellXY("T"));
            //    throw new Exception("lencable empty for fact BS");
            //}

        }
        lencable = getBigDecimal("T", "antenna.lencable.error");

        return lencable;
    } catch (Exception e) {
     throw new Throwable(e.getMessage()); 
	    
	    //throw new Throwable(e.getMessage());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (14.06.2003 22:22:35)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNakl() throws Throwable {
   
        if (nakl == null) {

            nakl = getBigDecimal("M", "antenna.nakl.error");
        }
        return nakl;
   
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 12:44:34)
 */
public String getNumber() throws Throwable {
    

        if (number == null) {
            number = "-1";
            number = getInteger("J", "antenna.number.error").toString();
            if (number.length() == 1) {
                number = "0" + number;
            }
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
        if (getNumber().equals("-1")) {
            throw new Exception("number=-1");
        }

        return getNumber();
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
    return "антенна";
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 17:00:33)
 * @return java.lang.Integer
 */
public AntennaResourceAccessBean getResource() throws Throwable {

    if (resource != null) {
        return resource;
    }

    int subTypeAntenna = 0;
    try {
        NamedValueAccessBean v = new NamedValueAccessBean();
        v.setInitKey_id("ResourceSubType_Antenna");
        v.refreshCopyHelper();
        subTypeAntenna = v.getIntvalue();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }

    try {
        AntennaResourceAccessBeanTable table = new AntennaResourceAccessBeanTable();
        table
            .setAntennaResourceAccessBean(
                new AntennaResourceAccessBean()
                .findResourcesByQBE(
        /*Boolean isSubtypekey,*/ Boolean.FALSE,
        /*ResourceSubTypeKey subtypeKey,*/ new ResourceSubTypeKey(subTypeAntenna),
        /*Boolean isModel,*/ Boolean.TRUE,
        /*String model,*/ ((String[]) getBlockData().get("K"))[getIndex()],
        /*Boolean isName,*/ Boolean.FALSE,
        /*String name,*/ "",
        /*Integer order*/ new Integer(1)));

        Vector res = new Vector();
        for (int i = 0; i < table.numberOfRows(); i++) {
            res.add(table.getAntennaResourceAccessBean(i));
        }
         if (res.size() == 0) {
            throw new Exception(
                "antenna resource not found model "
                    + ((String[]) getBlockData().get("K"))[index]);
        }
         if (res.size() > 1) {
             getBsRecordLogger().writeError(
                "antenna.resource.warning.few",
                getCellXY("K"));
        }

        resource = (AntennaResourceAccessBean) res.get(0);
    } catch (Exception e) {
        getBsRecordLogger().writeError("antenna.resource.error", getCellXY("K"));
        throw new Throwable(e.getMessage());
    }
    return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 20:35:14)
 * @return int
 */
public int getSectorCount() throws Throwable {

    int count;
    String codesString = ((String[]) getBlockData().get("P"))[index];
    String qt = ((String[]) getBlockData().get("Q"))[index];
    String rt = ((String[]) getBlockData().get("R"))[index];
    if (codesString == null || codesString.trim().length() == 0) {
        return 0;
    } else {
        StringTokenizer st = new StringTokenizer(codesString, "/");
        count = st.countTokens();

    }
    if (qt != null
        && qt.trim().length() > 0
        && new StringTokenizer(qt, "/").countTokens() != count) {

        getBsRecordLogger().writeError("antenna.sectors.q", getCellXY("Q"));
        throw new Throwable("invalid data in " + getCellXY("Q"));
    }

    if (rt != null
        && rt.trim().length() > 0
        && new StringTokenizer(rt, "/").countTokens() != count) {

        getBsRecordLogger().writeError("antenna.sectors.r", getCellXY("R"));
        throw new Throwable("invalid data in " + getCellXY("R"));
    }
    return count;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 19:28:28)
 * @return boolean
 */
private boolean hasResourceBand(int band) throws Throwable {
    try {
        AntennaResourceBandAccessBeanTable table =
            new AntennaResourceBandAccessBeanTable();
        table.setAntennaResourceBandAccessBean(
            new AntennaResourceBandAccessBean().findAntennaResourceBandsByResource(
                new ResourceKey(getResource().getResource())));
        for (int i = 0; i < table.numberOfRows(); i++) {
            if (table.getAntennaResourceBandAccessBean(i).getBand() == band) {
                return true;
            }

        }
        return false;
    } catch (FinderException e) {
        return false;
    } catch (Throwable ex) {
        DebugSupport.printlnError(ex);
        throw ex;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2003 19:28:28)
 * @return boolean
 */
private boolean hasWorkBand(int band) throws Throwable {
    try {
        AntennaWorkBandAccessBeanTable table = new AntennaWorkBandAccessBeanTable();
        table.setAntennaWorkBandAccessBean(
            new AntennaWorkBandAccessBean().findAntennaWorkBandsByAntenna(
                new AntennaKey(getAntennaBean().getIdanten())));
        for (int i = 0; i < table.numberOfRows(); i++) {
            if (table.getAntennaWorkBandAccessBean(i).getBand() == band) {
                return true;
            }

        }
        return false;
    } catch (FinderException e) {
        return false;
    } catch (Throwable ex) {
        DebugSupport.printlnError(ex);
        throw ex;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 18:36:26)
 */
public void process() {
    try {
        super.process();
        removeSectorLinks();

        int count = getSectorCount(); //check sector fields

        SectorImportObject sector = null;
        for (int i = 0; i < count; i++) {
            try {
                sector = new SectorImportObject(getBlockData(), this, i);
                sector.process();
                if (!hasResourceBand(sector.getBand())) {
                    getBsRecordLogger().writeError(
                        "antenna.band.support.error",
                        getYKey(),
                        sector.getBand() + "");
                } else {
                    if (!hasWorkBand(sector.getBand())) {
                        addWorkBand(sector.getBand());
                    }
                }
            } catch (Throwable tr) {
            }
        }
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        writeError();
    } catch (Throwable tr) {
        DebugSupport.printlnError(tr);

    }

}
/**
 * Insert the method's description here.
 * Creation date: (13.06.2003 19:17:40)
 */
public void removeSectorLinks() throws Throwable {

try{	
    Antena2sectorAccessBeanTable table = new Antena2sectorAccessBeanTable();
    table.setAntena2sectorAccessBean(
        new Antena2sectorAccessBean().findAntena2sectorsByAntenna(
            (AntennaKey) getAntennaBean().getEJBRef().getPrimaryKey()));
    for (int i = 0; i <table.numberOfRows() ; i++){
    	table.getAntena2sectorAccessBean(i).getEJBRef().remove();
    }
}catch(Exception e){
	DebugSupport.printlnError(e);
	
	getBsRecordLogger().writeError("antenna.sector.remove.error",getYKey());
	throw new Throwable(e.getMessage());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2003 17:48:17)
 */
public void update() throws Throwable {
    try {

        getAntennaBean().setAzant(getAzimut());
        getAntennaBean().setResource(
            (AntennaResource) javax.rmi.PortableRemoteObject.narrow(
                getResource().getEJBRef(),
                AntennaResource.class));
        if (getCableres() != null) {

            getAntennaBean().setCableres(
                (CableResource) javax.rmi.PortableRemoteObject.narrow(
                    getCableres().getEJBRef(),
                    CableResource.class));
        } else {
            getAntennaBean().setCableres(null);
        }
        getAntennaBean().setHset1(getHset1());
        getAntennaBean().setKindant(getKindant());
        getAntennaBean().setNakl(getNakl());
        getAntennaBean().setLencable(getLencable());
        getAntennaBean().setByhand(Boolean.TRUE);
        getAntennaBean().commitCopyHelper();

        DebugSupport.printlnTest("antenna updated id=" + getAntennaBean().getIdanten());
        /*
        DebugSupport.printlnTest(
            "resource=" + getAntennaBean().getResourceKey().resource);
        */
        //DebugSupport.printlnTest("numant="+getAntennaBean().getNumant());
        //DebugSupport.printlnTest("kindant=" + getAntennaBean().getKindant());
        //DebugSupport.printlnTest("nakl=" + getAntennaBean().getNakl());
        //DebugSupport.printlnTest("azant=" + getAntennaBean().getAzant());
        //DebugSupport.printlnTest("hset1=" + getAntennaBean().getHset1());
        //DebugSupport.printlnTest("lencable=" + getAntennaBean().getLencable());
        //DebugSupport.printlnTest("bs="+getAntennaBean().getEquipmentKey().storageplace);
        /*
        DebugSupport.printlnTest(
            "cableres=" + getAntennaBean().getCableresKey().resource);
        DebugSupport.printlnTest("byhand=" + getAntennaBean().getByhand());
        */
    } catch (Exception e) {

        getBsRecordLogger(BsRecordLogger.ACTION_U).writeError(
            "antenna.update.error",
            getYKey());
        //DebugSupport.printlnError(e);
        throw new Throwable(e.getMessage());

    }

}
}
