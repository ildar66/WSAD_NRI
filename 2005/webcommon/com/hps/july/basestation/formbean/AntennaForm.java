package com.hps.july.basestation.formbean;

import com.hps.july.cdbc.objects.*;
import com.hps.july.persistence2.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import org.apache.struts.action.*;
import java.math.*;
import com.hps.july.persistence.*;
import java.util.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.basestation.valueobject.*;

/**
 * Форма редактирования антены базовой станции
 */
public class AntennaForm
	extends BSEquipmentForm
{
    private int idanten;
    private com.hps.july.persistence.AntennaResourceAccessBean resource;
    private StringAndInteger resourceId = new StringAndInteger();
    private String resourceSerial;
//    private ResourceAccessBean groundresource;
//    private StringAndInteger groundresourceId = new StringAndInteger();
//    private String groundresourceName;
//    private StringAndInteger groundctnId = new StringAndInteger();
    private String resourceName;
    private String azvariation;
    private StringAndBigDecimal azant = new StringAndBigDecimal(6, 2);
    private StringAndBigDecimal hset1 = new StringAndBigDecimal(6, 2);
    private String naklvariation;
//    private StringAndBigDecimal ksvn = new StringAndBigDecimal(6, 2);
    private StringAndBigDecimal nakl = new StringAndBigDecimal(4, 2);
    private String kindant = AntennaObject.KINDANT_CHECK_R;
    private StringAndBigDecimal inputpower = new StringAndBigDecimal(6, 2);
    private String numant;
//    private StringAndBigDecimal lencable = new StringAndBigDecimal(6, 2);
//    private StringAndInteger cableType = new StringAndInteger();
	private int[] bandcodes = new int[] { };
	private String equipcomment;
    private String locationtype;
    private Boolean byhand;
    private String sumnakl;
    private String antpol = "C";

	private StringAndBigDecimal ea800 = new StringAndBigDecimal(4, 2);
	private StringAndBigDecimal ea900 = new StringAndBigDecimal(4, 2);
	private StringAndBigDecimal ea1800 = new StringAndBigDecimal(4, 2);
	private StringAndBigDecimal ea2000 = new StringAndBigDecimal(4, 2);

	private CableValue cab1 = new CableValue();
	private CableValue cab2 = new CableValue();
	private CableValue cab3 = new CableValue();
	private CableValue cab4 = new CableValue();

//    public static final String field_azvariation = "azvariation";
//    public static final String field_azant = "azant";
//    public static final String field_hset1 = "hset1";
//    public static final String field_naklvariation = "naklvariation";
//    public static final String field_kswn = "kswn";
//    public static final String field_nakl = "nakl";
//    public static final String field_kindant = "kindant";
//    public static final String field_inputpower = "inputpower";
//    public static final String field_numant = "numant";
//    public static final String field_lencable = "lencable";
	private java.lang.String datasource;
public void afterUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	System.out.println("!!!!!!afterUpdate started");
	try {
		if(request.getParameterValues("bandcodes")==null) {
			bandcodes=new int[0];
		}
		AntennaWorkBandAccessBean aBands = null;
		Arrays.sort(bandcodes);

		AntennaWorkBandAccessBeanTable table = new AntennaWorkBandAccessBeanTable();

		boolean hasAntennes = false;

		try {
			table.setAntennaWorkBandAccessBean(
				new AntennaWorkBandAccessBean().findAntennaWorkBandsByAntenna(
					new AntennaKey(getIdanten())));
			if (table.numberOfRows() == 0)
				throw new javax.ejb.FinderException();
			hasAntennes = true;
		} catch (javax.ejb.FinderException e1) {
			DebugSupport.printlnTest(
				"findAntennaWorkBandsByAntenna not found for idAnten=" + getIdanten());
		}

		if (hasAntennes) {
			DebugSupport.printlnTest("after update deleting for idAnten=" + getIdanten());
			for (int i = 0; i < table.numberOfRows(); i++) {
				if (Arrays.binarySearch(bandcodes, table.getAntennaWorkBandAccessBean(i).getBand()) < 0) {
                    table.getAntennaWorkBandAccessBean(i).getEJBRef().remove(); //delete
                }
            }
        }

        for (int i = 0; i < bandcodes.length; i++) {
            try {
                aBands = new AntennaWorkBandAccessBean();
                aBands.setInitKey_antenna_idanten(new Integer(getIdanten()));
                aBands.setInitKey_band((short) bandcodes[i]);
                aBands.refreshCopyHelper();
            } catch (javax.ejb.FinderException ef) {
                System.out.println("!!!!!!!!!!bandcodes[" + i + "]=" + bandcodes[i]);
                aBands = new AntennaWorkBandAccessBean(getIdanten(), (short) bandcodes[i]);
                //create
            }
        }

        updateCables();
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		throw e;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	deleteCables();
	AntennaObject.deleteWorkBands(getIdanten());
	AntennaObject.deleteSectorLinks(getIdanten());
}
public void beforeUpdate(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	AntennaAccessBean bs = (AntennaAccessBean)bean;
	bs.setDatasource(0);
}
public void checkCable(CableValue cv, ActionErrors errors, int n)
{
	if(cv.getCabletype().getInteger() != null && cv.getCabletype().getInteger().intValue() > 0) {
		if(cv.getLength() != null) {
			if(cv.getLength().isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.length.empty",new Integer(n)));
			} else if(!cv.getLength().isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.cable.length.invalid",new Integer(n)));
			}
		}
	}
}
public void clearRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	setIdanten(0);

	setAzantFrm("");
	setAzvariation("");
	bandcodes=new int[]{};
	setByhand(Boolean.FALSE);
//	setCableTypeFrm("");
	setEquipcomment("");
//	setGroundctnFrm("");
//	setGroundresourceIdFrm("");
//	setGroundresourceName("");
	setHset1Frm("");
	setInputpowerFrm("");
	setKindant(AntennaObject.KINDANT_CHECK_R);
//	setKsvnFrm("");
//	setLencableFrm("");
	setLocationtype(Checks.ANTENNA_LOCATIONTYPE_OUTDOOR_O);
	setNaklFrm("");
	setNaklvariation("");
	setNumant("");
	setResourceIdFrm("");
	setResourceName("");
	setAntpol("C");
	cab1 = new CableValue();
	cab2 = new CableValue();
	cab3 = new CableValue();
	cab4 = new CableValue();
	getCab1().getCabletype().setInteger(new Integer(com.hps.july.util.AppUtils.getNamedValueInt("AntennaCableType")));
}
public AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {

    setIdanten(new KeyGeneratorAccessBean().getNextKey(TablesRef.ANTENNES));

    
    return new AntennaAccessBean(
    /*int argIdanten,*/ getIdanten(),
    /*int argResource,*/ getResourceId().intValue(),
    /*String argNumant,*/ getNumant(),
    /*String argKindant,*/ getKindant(),
    /*java.math.BigDecimal argNakl,*/ getNakl(),
    /*java.math.BigDecimal argAzant,*/ getAzant(),
    /*java.math.BigDecimal argHset1,*/ getHset1(),
    /*java.math.BigDecimal argLencable,*/ new BigDecimal(0.0), //getLencable(),
    /*int argEquipment*/ getBsForm().getBasestation());
}
public void deleteCables()
	throws Exception
{
	try {
		AntennaCableAccessBean acf = new AntennaCableAccessBean();
		Enumeration en = acf.findByAnten(new Integer(getIdanten()));
		while(en.hasMoreElements()) {
			AntennaCableAccessBean ac = (AntennaCableAccessBean)en.nextElement();
			Enumeration cpen = (new CableWorkParamsAccessBean()).findByCable(new Integer(ac.getIdcable()));
			while(cpen.hasMoreElements()) {
				CableWorkParamsAccessBean cwp = (CableWorkParamsAccessBean)cpen.nextElement();
				cwp.getEJBRef().remove();
			}
			ac.getEJBRef().remove();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw e;
	}
}
public void fillRecord(AbstractEntityAccessBean bean) {
    super.fillRecord(bean);

    try {
	    AntennaAccessBean aant = new AntennaAccessBean();
	    aant.setInitKey_idanten(getIdanten());
	    aant.refreshCopyHelper();
	    antpol = aant.getResource().getPolarization();
	    
		//AntennaWorkBandAccessBean aBands = null;
		AntennaWorkBandAccessBeanTable table = new AntennaWorkBandAccessBeanTable();

		try {
			table.setAntennaWorkBandAccessBean(new AntennaWorkBandAccessBean().findAntennaWorkBandsByAntenna(new AntennaKey(getIdanten())));
			if(table.numberOfRows()==0)throw new javax.ejb.FinderException();
		} catch (javax.ejb.FinderException e1) {
			DebugSupport.printlnTest("fillRecord. findAntennaWorkBandsByAntenna not found for idAnten="	+ getIdanten());
			bandcodes = new int[] {	};
			return;
		}
		bandcodes=new int[table.numberOfRows()];
		for (int i = 0; i < table.numberOfRows(); i++) {
			AntennaWorkBandAccessBean a = table.getAntennaWorkBandAccessBean(i);
			bandcodes[i] = a.getBand();
        }

		try {
			if(resourceId.getInteger()!= null) {
				Enumeration en = (new AntennaResourceBandAccessBean()).findAntennaResourceBandsByResource(new ResourceKey(resourceId.getInt()));
				while(en.hasMoreElements()) {
					AntennaResourceBandAccessBean rb = (AntennaResourceBandAccessBean)en.nextElement();
					BigDecimal d = rb.getElectricangle();
					if(d != null) {
						switch((int)rb.getBand()) {
						case 800:
							ea800.setBigDecimal(d);
							break;
						case 900:
							ea900.setBigDecimal(d);
							break;
						case 1800:
							ea1800.setBigDecimal(d);
							break;
						case 2000:
							ea2000.setBigDecimal(d);
							break;
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}

		cab1 = new CableValue();
		cab2 = new CableValue();
		cab3 = new CableValue();
		cab4 = new CableValue();
		try {
			AntennaCableAccessBean ac = new AntennaCableAccessBean();
			Enumeration en = ac.findByAnten(new Integer(getIdanten()));
			if(en.hasMoreElements()) {
				setCable(cab1,(AntennaCableAccessBean)en.nextElement());
			}
			if(en.hasMoreElements()) {
				setCable(cab2,(AntennaCableAccessBean)en.nextElement());
			}
			if(en.hasMoreElements()) {
				setCable(cab3,(AntennaCableAccessBean)en.nextElement());
			}
			if(en.hasMoreElements()) {
				setCable(cab4,(AntennaCableAccessBean)en.nextElement());
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	} catch (Exception e) {
		DebugSupport.printlnError(e);
	}

	setDatasource("Внесено вручную");
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAntpol() {
	return antpol;
}
public BigDecimal getAzant(){
return azant.getBigDecimal();
}
public String getAzantFrm(){
return azant.getString();
}
public String getAzvariation(){
return azvariation;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2003 20:14:52)
 * @return java.lang.Integer[]
 */
public int[] getBandcodes() {
	return bandcodes;
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2003 12:47:06)
 * @return com.hps.july.basestation.formbean.BaseStationForm
 */
public BaseStationForm getBsForm() {
	
     //DebugSupport.printlnTest("getBsForm started. bsForm=" +super.getBsForm());
    return super.getBsForm();
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2003 13:44:53)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getByhand() {
	return byhand;
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.CableValue
 */
public com.hps.july.basestation.valueobject.CableValue getCab1() {
	return cab1;
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.CableValue
 */
public com.hps.july.basestation.valueobject.CableValue getCab2() {
	return cab2;
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.CableValue
 */
public com.hps.july.basestation.valueobject.CableValue getCab3() {
	return cab3;
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.CableValue
 */
public com.hps.july.basestation.valueobject.CableValue getCab4() {
	return cab4;
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 18:23:05)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getCableTypes() throws Exception {

    
	Vector vec=new Vector();
	CableResourceAccessBeanTable table = new CableResourceAccessBeanTable();
    table.setCableResourceAccessBean(
        new CableResourceAccessBean().findByQBE4(
            Boolean.FALSE,
            new Integer(0),
            Boolean.FALSE,
            new Integer(0),
            new Integer(1)));
    
//    if (cableType.getInteger() == null&&table.numberOfRows()>0) {
//        cableType.setInt(table.getCableResourceAccessBean(0).getResource());
//    }
	for (int i = 0; i <table.numberOfRows() ; i++) {
		vec.addElement(new CableResourceObject(table.getCableResourceAccessBean(i)));
	}  

    return vec.elements();
}
public AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {

    try {
        AntennaAccessBean bean = new AntennaAccessBean();
        bean.setInitKey_idanten(getIdanten());
        bean.refreshCopyHelper();
        return bean;
    } catch (Exception e) {
        new DebugSupport().printlnError(e, "getDataBean", this);
        return null;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 17:40:20)
 * @return java.lang.String
 */
public java.lang.String getDatasource() {
	return datasource;
}
public String getEa1800() {
	return ea1800.getString();
}
public String getEa2000() {
	return ea2000.getString();
}
public String getEa800() {
	return ea800.getString();
}
public String getEa900() {
	return ea900.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2003 20:56:37)
 * @return java.lang.String
 */
public java.lang.String getEquipcomment() {
	return equipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 18:03:14)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
public EquipmentSet getEquipment() throws Exception {
    return  (EquipmentSet)getBaseStation().getEJBRef();
}
public BigDecimal getHset1(){
return hset1.getBigDecimal();
}
public String getHset1Frm(){
return hset1.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 16:47:56)
 * @return int
 */
public int getIdanten() {
	return idanten;
}
public BigDecimal getInputpower(){
return inputpower.getBigDecimal();
}
public String getInputpowerFrm(){
return inputpower.getString();
}
public String getKindant(){
return kindant;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2003 11:43:27)
 * @return java.lang.String
 */
public java.lang.String getLocationtype() {
	return locationtype==null?"":locationtype;
}
public BigDecimal getNakl(){
return nakl.getBigDecimal();
}
public String getNaklFrm(){
return nakl.getString();
}
public String getNaklvariation(){
return naklvariation;
}
public String getNumant(){
return numant;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 11:31:18)
 * @return java.lang.String
 */
public String getResBandsString() throws Exception {
    try {
        if (resourceId.isEmpty())
            return "";

        AntennaResourceAccessBean res = new AntennaResourceAccessBean();
        res.setInitKey_resource(resourceId.getInt());
        res.refreshCopyHelper();

        return new AntenaValue(res).getRanges();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        return null;

    }
}
//end groundresource
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 16:46:14)
 * @return com.hps.july.persistence.AntennaResourceAccessBean
 */
public AntennaResource getResource() throws Exception {

    if (resource != null)
        return (AntennaResource) resource.getEJBRef();

    resource = new AntennaResourceAccessBean();
    resource.setInitKey_resource(getResourceId().intValue());
    resource.refreshCopyHelper();

    return (AntennaResource) resource.getEJBRef();

}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 16:56:48)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getResourceId() {
	return resourceId.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 16:56:48)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getResourceIdFrm() {
   return resourceId.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 16:56:48)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getResourceName() {
    return resourceName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourceSerial() {
	return resourceSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 21:01:41)
 * @return java.lang.String
 */
public String getSumnakl() throws Exception {

    try {
        if (getAction().equals("Add"))
            return "";

        BigDecimal s1 = getNakl() == null ? new BigDecimal(0) : getNakl();
		if("D".equals(getBsForm().getStationType())) {
			if(ea800.getBigDecimal() != null) {
				return s1.add(ea800.getBigDecimal()).toString();
			} else {
				return s1.toString();
			}
		} else {
			BigDecimal m1 = ea900.getBigDecimal() == null?new BigDecimal(0.0):ea900.getBigDecimal();
			BigDecimal m2 = ea1800.getBigDecimal() == null?new BigDecimal(0.0):ea1800.getBigDecimal();
			m1 = m1.add(s1);
			m2 = m2.add(s1);
			if(m1.equals(m2)) {
				return m1.toString();
			} else {
				return m1.toString() + "/" + m2.toString();
			}
		}
    } catch (Exception e) {
        DebugSupport.printlnError(e, "may be from validation");
        return "";
    }
}
/**
 * Insert the method's description here.
 * Creation date: (16.08.2003 20:53:30)
 */
public boolean hasSectorLinks() throws Exception {

    return AntennaObject.hasSectorLinks(getIdanten());
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	clearRecord(request);
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 15:58:16)
 */
public void prepareCopy(javax.servlet.http.HttpServletRequest request){
setState(com.hps.july.basestation.APPStates.ANT_COPY);	
	
	
	}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 15:58:16)
 */
public void prepareEdit(javax.servlet.http.HttpServletRequest request) {
   
setState(com.hps.july.basestation.APPStates.ANT_EDIT);
DebugSupport.printlnTest("!!!!AntennaForm prepareEdit state="+getState());        
 
}
/**
 * 
 * @param newAntpol java.lang.String
 */
public void setAntpol(java.lang.String newAntpol) {
	antpol = newAntpol;
}
public void setAzant(BigDecimal arg){
azant.setBigDecimal(arg);
}
public void setAzantFrm(String arg){
	azant.setString(arg);
}
public void setAzvariation(String arg){
azvariation=arg;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2003 20:14:52)
 * @param newBandcodes java.lang.Integer[]
 */
public void setBandcodes(int[] newBandcodes) {
    //bandcodes = newBandcodes;
    int j = 0;
    for (int i = 0; i < newBandcodes.length; i++) {
        if (newBandcodes[i] != 0)
            j++;
    }
    bandcodes = new int[j];

    j = 0;
    for (int i = 0; i < newBandcodes.length; i++) {
        if (newBandcodes[i] != 0)
            bandcodes[j++] = newBandcodes[i];
    }
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2003 12:47:06)
 * @param newBsForm com.hps.july.basestation.formbean.BaseStationForm
 */
public void setBsForm(BaseStationForm newBsForm) {
	super.setBsForm(newBsForm);
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2003 13:44:53)
 * @param newByhand java.lang.Boolean
 */
public void setByhand(java.lang.Boolean newByhand) {
	byhand = newByhand;
}
public void setCable(CableValue cv, AntennaCableAccessBean ace)
	throws Exception
{
	cv.setId(new Integer(ace.getIdcable()));
	cv.getCabletype().setInteger(new Integer(ace.getCableres()));
	cv.getLength().setBigDecimal(ace.getLencable());
	cv.getGnds().setInteger(ace.getGroundcnt());
//	cv.getGndtype(ace.getGroundresource());

	CableWorkParamsAccessBean cwp = new CableWorkParamsAccessBean();
	Enumeration en = cwp.findByCable(cv.getId());
	while(en.hasMoreElements()) {
		CableWorkParamsAccessBean cwpe = (CableWorkParamsAccessBean)en.nextElement();
		switch((int)cwpe.getBand()) {
		case 800:
			cv.getKsvn800().setBigDecimal(cwpe.getKsvn());
			break;
		case 900:
			cv.getKsvn900().setBigDecimal(cwpe.getKsvn());
			break;
		case 1800:
			cv.getKsvn1800().setBigDecimal(cwpe.getKsvn());
			break;
		case 2000:
			cv.getKsvn2000().setBigDecimal(cwpe.getKsvn());
			break;
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 17:40:20)
 * @param newDatasource java.lang.String
 */
public void setDatasource(java.lang.String newDatasource) {
	datasource = newDatasource;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2003 20:56:37)
 * @param newEquipcomment java.lang.String
 */
public void setEquipcomment(java.lang.String newEquipcomment) {
	equipcomment = newEquipcomment;
}
/**
 * Insert the method's description here.
 * Creation date: (26.03.2003 18:03:14)
 * @param newBaseStation com.hps.july.persistence.BaseStationAccessBean
 */
public void setEquipment(com.hps.july.persistence.EquipmentSetAccessBean newEq)
    throws Exception {
    try {

        setBaseStation(new BaseStationAccessBean(newEq.getEJBRef()));
        setBscode(new Integer(getBaseStation().getStorageplace()));
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2003 13:03:44)
 */
public void setGroundctn() {}
public void setHset1(BigDecimal arg){
hset1.setBigDecimal(arg);
}
public void setHset1Frm(String arg){
hset1.setString(arg);
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2003 16:47:56)
 * @param newIdanten int
 */
public void setIdanten(int newIdanten) {
	idanten = newIdanten;
}
public void setInputpower(BigDecimal arg){
inputpower.setBigDecimal(arg);
}
public void setInputpowerFrm(String arg){
inputpower.setString(arg);
}
public void setKindant(String arg){
kindant=arg;
}
/**
 * Insert the method's description here.
 * Creation date: (22.08.2003 11:43:27)
 * @param newLocationtype java.lang.String
 */
public void setLocationtype(java.lang.String newLocationtype) {
	locationtype = newLocationtype;
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 21:03:40)
 * @param val java.lang.String
 */
public void setLosscable(String val) {}
public void setNakl(BigDecimal arg){
nakl.setBigDecimal(arg);
}
public void setNaklFrm(String arg){
nakl.setString(arg);
}
public void setNaklvariation(String arg){
naklvariation=arg;
}
public void setNumant(String arg){
numant=arg;
}
public void setResource(AntennaResourceAccessBean newResource)
	throws Exception
{
	resource = newResource;
	resourceId.setInt(newResource.getResource());
	resourceName = newResource.getModel() + " " + newResource.getName();

//    setKsvn(newResource.getKsvn());
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 16:56:48)
 * @param newResourceId com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setResourceId(Integer newResourceId) {
    resourceId.setInteger(newResourceId);
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 16:56:48)
 * @param newResourceId com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setResourceIdFrm(String newResourceId) {
    resourceId.setString(newResourceId);
    resource=null;
}
/**
 * Insert the method's description here.
 * Creation date: (28.03.2003 16:56:48)
 * @param newResourceId com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setResourceName(String newResourceId) {
    resourceName=newResourceId;
}
/**
 * 
 * @param newResourceSerial java.lang.String
 */
public void setResourceSerial(java.lang.String newResourceSerial) {
	resourceSerial = newResourceSerial;
}
public void setSumnakl(String arg){

}
public void updateCables()
	throws Exception
{
	if("D".equals(getBsForm().getStationType())) {
		deleteCables();
		if("V".equals(antpol)) {
			updateDAMPSCable(cab1);
		} else if("C".equals(antpol)){
			updateDAMPSCable(cab1);
			updateDAMPSCable(cab2);
		}
	} else {
		deleteCables();
		if("V".equals(antpol)) {
			updateGSMCable(cab1);
			if(bandcodes != null && bandcodes.length > 1) {
				updateGSMCable(cab2);
			}
		} else if("C".equals(antpol)){
			updateGSMCable(cab1);
			updateGSMCable(cab2);
			if(bandcodes != null && bandcodes.length > 1) {
				updateGSMCable(cab3);
				updateGSMCable(cab4);
			}
		}
	}
}
public void updateDAMPSCable(CableValue cv)
	throws Exception
{
	CDBCResourcesObject ro = new CDBCResourcesObject();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	AntennaCableAccessBean ac;
/*
	if(cv.getId() != null) {
		ac = new AntennaCableAccessBean();
		ac.setInitKey_idcable(cv.getId().intValue());
		ac.refreshCopyHelper();
	} else {
*/
		int argCable = keyGen.getNextKey("tables.antennacables");
		cv.setId(new Integer(argCable));
		ac = new AntennaCableAccessBean(
			argCable,
			getIdanten(),
			cab1.getCabletype().getInteger().intValue(),
			cab1.getLength().getBigDecimal()
		);
/*
	}
*/
	ac.setGroundresource(ro.getCableGroundResource(new Integer(argCable)));
	ac.setGroundcnt(cab1.getGnds().getInteger());
	ac.commitCopyHelper();

System.out.println("B:800 BD:"+cv.getKsvn800().getBigDecimal());
	if(bandcodes != null && bandcodes.length > 0 && cv.getKsvn800().getBigDecimal() != null) {
/*
		try {
			CableWorkParamsAccessBean cwp800 = new CableWorkParamsAccessBean();
			cwp800.setInitKey_band((short)800);
			cwp800.setInitKey_id_anten(getIdanten());
			cwp800.setInitKey_id_cable(cv.getId().intValue());
			cwp800.refreshCopyHelper();
			cwp800.setKsvn(cab1.getKsvn800().getBigDecimal());
			cwp800.commitCopyHelper();
		} catch(javax.ejb.ObjectNotFoundException onfe) {
*/
			CableWorkParamsAccessBean cwp800 
				= new CableWorkParamsAccessBean((short)800,getIdanten(),cv.getId().intValue());
			cwp800.setKsvn(cv.getKsvn800().getBigDecimal());
			cwp800.commitCopyHelper();
/*
		}
*/
	}
}
public void updateGSMCable(CableValue cv)
	throws Exception
{
	if(cv.getCabletype().getInteger() == null || cv.getCabletype().getInteger().intValue() == 0) {
		return;
	}

	CDBCResourcesObject ro = new CDBCResourcesObject();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	AntennaCableAccessBean ac;
/*
	if(cv.getId() != null) {
		ac = new AntennaCableAccessBean();
		ac.setInitKey_idcable(cv.getId().intValue());
		ac.refreshCopyHelper();
	} else {
*/
		int argCable = keyGen.getNextKey("tables.antennacables");
		cv.setId(new Integer(argCable));
		ac = new AntennaCableAccessBean(
			argCable,
			getIdanten(),
			cv.getCabletype().getInteger().intValue(),
			cv.getLength().getBigDecimal()
		);
/*
	}
*/
	ac.setGroundresource(ro.getCableGroundResource(new Integer(argCable)));
	ac.setGroundcnt(cv.getGnds().getInteger());
	ac.commitCopyHelper();

	if(bandcodes != null && bandcodes.length > 0) {
		for(int i = 0; i < bandcodes.length; i++) {
//			short band = (short)bandcodes[i];
			BigDecimal bd = null;
			switch(bandcodes[i]) {
				case 800: bd = cv.getKsvn800().getBigDecimal(); break;
				case 900: bd = cv.getKsvn900().getBigDecimal(); break;
				case 1800: bd = cv.getKsvn1800().getBigDecimal(); break;
				case 2000: bd = cv.getKsvn2000().getBigDecimal(); break;
			}
System.out.println("B:"+bandcodes[i]+" BD:"+bd);
			if(bd != null) {
/*
				try {
					CableWorkParamsAccessBean cwp = new CableWorkParamsAccessBean();
					cwp.setInitKey_band((short)bandcodes[i]);
					cwp.setInitKey_id_anten(getIdanten());
					cwp.setInitKey_id_cable(cv.getId().intValue());
					cwp.refreshCopyHelper();
					cwp.setKsvn(bd);
					cwp.commitCopyHelper();
				} catch(javax.ejb.ObjectNotFoundException onfe) {
*/
					CableWorkParamsAccessBean cwp
						= new CableWorkParamsAccessBean((short)bandcodes[i],getIdanten(),cv.getId().intValue());
					cwp.setKsvn(bd);
					cwp.commitCopyHelper();
/*
				}
*/
			}
		}
	}
}
public void validateValues(ActionErrors errors)
	throws Exception
{
    try {
		//valid condition for azvariation
    } catch (Exception e) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.azvariation"));
    }

    try {
        resource = null;
        getResource();
    } catch (Exception e) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.resource"));
    }

    if (!azant.isOkAndNotEmpty()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.azant",azant.formatMessage()));
    } else if(azant.getBigDecimal().doubleValue() < 0.0d || azant.getBigDecimal().doubleValue() > 360.0d) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.azant.range"));
    }

    if (!hset1.isOkAndNotEmpty()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.hset1",hset1.formatMessage()));
    } else if(hset1.getBigDecimal().signum() < 0) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.hset1.less"));
    }

    try {
        //valid condition for naklvariation
    } catch (Exception e) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.AntennaForm.naklvariation"));
    }
    /*
    if (!kswn.isOk())
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.AntennaForm.kswn",kswn.formatMessage()));
    */
    if (!nakl.isOkAndNotEmpty()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.nakl",nakl.formatMessage()));
    }

    if (kindant == null || kindant.length() == 0) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.kindant"));
    }

    if(!inputpower.isEmpty()) {
	    if (!inputpower.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.inputpower",inputpower.formatMessage()));
		} else if(inputpower.getBigDecimal().signum() < 0 || inputpower.getBigDecimal().doubleValue() > 1000.d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.inputpower.less"));
	    }
    }

    try {
        //valid condition for numant
    } catch (Exception e) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.AntennaForm.numant"));
    }

    checkCable(cab1,errors,1);
    checkCable(cab2,errors,2);
    checkCable(cab3,errors,3);
    checkCable(cab4,errors,4);
/*
    if (lencable.isEmpty()) {
        lencable.setBigDecimal(new java.math.BigDecimal(0));
    } else if (!lencable.isOkAndNotEmpty()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.lencable",lencable.formatMessage()));
    } else if (lencable.getBigDecimal().signum() < 0) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.AntennaForm.lencable.less"));
    }

    if (!groundresourceId.isEmpty()) {
        try {
            constructGroundresource();
        } catch (Exception e) {
            errors.add(
                ActionErrors.GLOBAL_ERROR,
                new ActionError("error.AntennaForm.groundres"));
        }
    }

    if (!groundctnId.isOk()) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.AntennaForm.groundctn"));
    }
*/
    if (!errors.empty())
        throw new ValidationException();
}
}
