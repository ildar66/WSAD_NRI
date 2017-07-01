package com.hps.july.inventory.formbean;

import java.math.BigDecimal;
import javax.ejb.ObjectNotFoundException;
import com.hps.july.inventory.sessionbean.*;
import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.basestation.valueobject.*;

/**
 * Форма редактирования строки актов монтажа АФС.
 * Форма используется для ввода и редактирования антенны и кабеля
 */
public class AfsAPositionForm
	extends DocumentPositionForm
{
	private String antennaType = "A";
	
	private StringAndIntegerProperty order = new StringAndIntegerProperty();

	private Boolean sectorA = Boolean.FALSE;
	private Boolean sectorB = Boolean.FALSE;
	private Boolean sectorC = Boolean.FALSE;
	private Boolean sectorD = Boolean.FALSE;
	private Boolean sectorE = Boolean.FALSE;
	private Boolean sectorF = Boolean.FALSE;
	private Boolean sectorG = Boolean.FALSE;
	private Boolean sectorH = Boolean.FALSE;
	private Boolean sectorO = Boolean.FALSE;
	private Boolean sectorO1800 = Boolean.FALSE;

	private String num_ant; // 32

	private StringAndBigDecimalProperty az_ant = new StringAndBigDecimalProperty();
	private String az_variation;

	private String kind_ant;
	private String locationtype;

	private StringAndIntegerProperty antenna = new StringAndIntegerProperty();
	private String antennamodel;
	private String antennaname;

	private StringAndBigDecimalProperty qty = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty price = new StringAndBigDecimalProperty();
	
	private String serialnumber;
	private String manufserial;

	private String fitplace;

	private StringAndBigDecimalProperty nakl = new StringAndBigDecimalProperty();
	private String nakl_variation;

	private StringAndBigDecimalProperty h_set1 = new StringAndBigDecimalProperty();

    private StringAndBigDecimal inputpower = new StringAndBigDecimal(6, 2);
/*	
	private StringAndIntegerProperty cable = new StringAndIntegerProperty();
	private String cablemodel;
	private String cablename;

	private StringAndIntegerProperty cableowner = new StringAndIntegerProperty();
	
	private StringAndBigDecimalProperty len_cable = new StringAndBigDecimalProperty();
	private StringAndBigDecimalProperty cable_price = new StringAndBigDecimalProperty();
	
	private String party;
	private StringAndIntegerProperty ground = new StringAndIntegerProperty();
	private String groundmodel;
	private String groundname;

	private StringAndIntegerProperty groundqty = new StringAndIntegerProperty();
*/

	private Boolean ddk;
	private Boolean has_flt;
	private Boolean has_lna;
	private Boolean has_buster;

	private String antpol = "C";

	private StringAndIntegerProperty doc = new StringAndIntegerProperty();
	private StringAndIntegerProperty docposition = new StringAndIntegerProperty();
	private StringAndIntegerProperty owner = new StringAndIntegerProperty();

	private Integer expedition;

	private java.lang.String comment;

	private CableValue cab1 = new CableValue();
	private CableValue cab2 = new CableValue();
	private CableValue cab3 = new CableValue();
	private CableValue cab4 = new CableValue();
public AfsAPositionForm() {
	super();
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
/*	
	if(cable.getInteger() != null) {
		try {
			corCable();
		} catch(Exception e) {
			e.printStackTrace(System.out);
			throw e;
		}
	}
*/
	updateCables();

/*
	try {
		if("Add".equals(getAction()) || "Edit".equals(getAction())) {
			ProcessingPositionError err = addPosition2Document(docposition.getInteger());
			if ((err != null) && (err.getErrorCode() != 0))
				System.out.println("COPY AGREGATE CONTENTS ERROR: " + err.getErrorCode());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
*/
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception 
{
	deleteCables();
	// if cable is present delete it
	/*
	try {
		removePositionFromDocument(docposition.getInteger());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.internalrpos.removeagregates");
	}
	*/
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	AfsMountPosAccessBean p = (AfsMountPosAccessBean)bean;
	p.setNum_ant(num_ant);
	p.setAz_ant(az_ant.getBigDecimal());
	p.setAz_variation(az_variation);
	p.setKind_ant(kind_ant);
	p.setResource((Resource)constructAntenna().getEJBRef());
	p.setQty(qty.getBigDecimal());
	p.setPrice(price.getBigDecimal());
	p.setSerialnumber(serialnumber);
	p.setManufserial(manufserial);
	p.setNewplace(fitplace);
	p.setNakl(nakl.getBigDecimal());
	p.setNakl_variation(nakl_variation);
	p.setH_set1(h_set1.getBigDecimal());
//	p.setKswn(kswn.getBigDecimal());
	p.setDdk(ddk);
	p.setHas_buster(has_buster);
	p.setHas_flt(has_flt);
	p.setHas_lna(has_lna);
	p.setInput_power(inputpower.getBigDecimal());
	p.setComment(comment);

	if(getFictionSerial() != null && getFictionSerial().booleanValue()) {
		p.setIsfictserial(true);
		p.setSerialnumber(null);
	} else {
		p.setIsfictserial(false);
		p.setSerialnumber(getSnumber());
	}
	p.setRealserial(null);
	/*
	try {
		if ("Edit".equals(getAction()))
			removePositionFromDocument(docposition.getInteger());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.internalrpos.removeagregates");
	}
	*/
}
public ResourceAccessBean constructAntenna() throws java.lang.Exception {
	ResourceAccessBean bean = new ResourceAccessBean();
	bean.setInitKey_resource(antenna.getInteger().intValue());
	bean.refreshCopyHelper();
	antennamodel = bean.getModel();
	antennaname = bean.getName();
	return bean;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	AfsForm aform = (AfsForm)request.getSession().getAttribute( "AfsForm" );
	doc.setInteger(aform.getDocumentId());
//	antennaType = aform.getAntennaType();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docposition.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
	AfsMountPosAccessBean bean = new AfsMountPosAccessBean(
		docposition.getInteger().intValue(),
		antenna.getInteger(),
		owner.getInteger(),
		doc.getInteger(),
		order.getInteger().intValue(),
		qty.getBigDecimal(),
		price.getBigDecimal(),
		getSourceBoxed(),
		getResultBoxed(),
		getSourceBroken(),
		getResultBroken(),
		getSourceClosed(),
		getResultClosed()
	);
	if("A".equals(antennaType) || "B".equals(antennaType)) {
		bean.setDocpostype(antennaType);
	} else {
		throw new Exception("antennaType uncorrenct!");
	}
	return bean;
}
public DocumentPositionAccessBean constructDocumentPosition(StorageCardAccessBean sc, 
	DocumentAccessBean document, int newDocposition, DocumentPositionAccessBean position, 
	int order, AgregateContentAccessBean agr) throws Exception
{
	/*
		AfsMountPosAccessBean pos = new AfsMountPosAccessBean( 
			newDocposition, 
			new Integer(sc.getResourceKey().resource), new Integer(sc.getOwnerKey().organization), 
			new Integer(document.getDocument()), 
			order, sc.getQty(), sc.getPrice(), sc.getBoxed(), position.getResultBoxed(), sc.getBroken(), 
			position.getResultBroken(), sc.getClosed(), position.getResultClosed() );
		pos.setParty( sc.getParty() );
		pos.setSerialnumber( sc.getSerialnumber() );
		pos.setConfiguration( sc.getConfiguration() );
		pos.setAgregate( (DocumentPosition)(position.getEJBRef()) );
		pos.setDocQty(sc.getQty());
		pos.commitCopyHelper();
		return new DocumentPositionAccessBean(pos.getEJBRef());
	*/
	throw new Exception("Will be work later");
}
public Resource constructGround(Integer cableres)
{
	Resource r = null;
	com.hps.july.cdbc.objects.CDBCResourcesObject ro = new com.hps.july.cdbc.objects.CDBCResourcesObject();
	Integer gndres = ro.getCableGroundResource(cableres);
	if(gndres != null) {
		try {
			ResourceAccessBean bean = new ResourceAccessBean();
			bean.setInitKey_resource(gndres.intValue());
			bean.refreshCopyHelper();
			r = (Resource)bean.getEJBRef();
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	return r;
}
public AfsMountPosAccessBean createCable(KeyGeneratorAccessBean kg, CableValue cv)
	throws Exception
{
	if(cv.getCabletype().getInteger() != null && cv.getCabletype().getInteger().intValue() != 0) {
		AfsMountPosAccessBean cp = new AfsMountPosAccessBean();
		int cablepos = kg.getNextKey("tables.docpositions");
		cv.setId(new Integer(cablepos));
		cp = new AfsMountPosAccessBean(
			cablepos,
			cv.getCabletype().getInteger(),
			owner.getInteger(),
			doc.getInteger(),
			order.getInteger().intValue(),
			cv.getLength().getBigDecimal(),
			new BigDecimal(0.0), // Price
			getSourceBoxed(),
			getResultBoxed(),
			getSourceBroken(),
			getResultBroken(),
			getSourceClosed(),
			getResultClosed()
		);
		cp.setDocpostype("C");
		cp.setLen_cable(cv.getLength().getBigDecimal());
		cp.setParentdocpos(docposition.getInteger());
		cp.setParty("");
		cp.setGroundresource(constructGround(cv.getCabletype().getInteger()));
		cp.setGroundcnt(cv.getGnds().getInteger());
		cp.setComment(comment);
		if(cv.getKsvn900().getBigDecimal() != null) {
			cp.setKsvn900(cv.getKsvn900().getBigDecimal());
		}
		if(cv.getKsvn1800().getBigDecimal() != null) {
			cp.setKsvn1800(cv.getKsvn1800().getBigDecimal());
		}
		cp.commitCopyHelper();
		return cp;
	} else {
		return null;
	}
}
public void deleteCables()
	throws Exception
{
	AfsMountPosAccessBean cp = new AfsMountPosAccessBean();
	Enumeration en = cp.findChildrenByParent(docposition.getInteger());
	while(en.hasMoreElements()) {
		AfsMountPosAccessBean e = (AfsMountPosAccessBean)en.nextElement();
		e.getEJBRef().remove();
	}
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	try {
		AfsMountPosAccessBean ab = (AfsMountPosAccessBean)bean;
		antenna.setInteger(new Integer(ab.getResourceKey().resource));
		antennaname = ab.getResource().getName();
		antennamodel = ab.getResource().getModel();
		fitplace = ab.getNewplace();
		owner.setInteger(new Integer(ab.getOwner().getOrganization()));
		order.setInteger(new Integer(ab.getOrder()));
		num_ant = ab.getNum_ant();
		az_ant.setBigDecimal(ab.getAz_ant());
		az_variation = ab.getAz_variation();
		kind_ant = ab.getKind_ant();
		qty.setBigDecimal(ab.getQty());
		price.setBigDecimal(ab.getPrice());
		fitplace = ab.getNewplace();
		nakl.setBigDecimal(ab.getNakl());
		nakl_variation = ab.getNakl_variation();
		h_set1.setBigDecimal(ab.getH_set1());
		inputpower.setBigDecimal(ab.getInput_power());
		comment = ab.getComment();
		if(ab.getIsfictserial()) {
			setFictionSerial(new Boolean(ab.getIsfictserial()));
			setSnumber("");
		} else {
			setFictionSerial(new Boolean(ab.getIsfictserial()));
			setSnumber(ab.getSerialnumber());
		}

		AntennaResourceAccessBean ar = new AntennaResourceAccessBean();
		ar.setInitKey_resource(ab.getResourceKey().resource);
		ar.refreshCopyHelper();
		antpol = ar.getPolarization();
//		kswn.setBigDecimal(ab.getKswn());
		// get cable
/*
		try {
			AfsMountPosAccessBean pos = new AfsMountPosAccessBean();
			pos = pos.findChildByParent(new Integer(ab.getDocposition()));
			cable.setInteger(new Integer(pos.getResource().getResource()));
			cablename = pos.getResource().getName();
			cablemodel = pos.getResource().getModel();
			len_cable.setBigDecimal(pos.getLen_cable());
			party = pos.getParty();
			ground.setInteger(new Integer(pos.getGroundresource().getResource()));
			groundname = pos.getGroundresource().getName();
			groundmodel = pos.getGroundresource().getModel();
			groundqty.setInteger(pos.getGroundcnt());
		} catch(ObjectNotFoundException onfe) {
		}
*/
		AfsMountPosAccessBean cp = new AfsMountPosAccessBean();
		Enumeration en = cp.findChildrenByParent(docposition.getInteger());
		if(en.hasMoreElements()) {
			AfsMountPosAccessBean e = (AfsMountPosAccessBean)en.nextElement();
			cab1.setId(new Integer(e.getDocposition()));
			cab1.getCabletype().setInteger(new Integer(e.getResource().getResource()));
			cab1.getLength().setBigDecimal(e.getLen_cable());
//	e.getGroundresource().getResource()
			cab1.getGnds().setInteger(e.getGroundcnt());
			cab1.getKsvn900().setBigDecimal(e.getKsvn900());
			cab1.getKsvn1800().setBigDecimal(e.getKsvn1800());
		}
		if(en.hasMoreElements()) {
			AfsMountPosAccessBean e = (AfsMountPosAccessBean)en.nextElement();
			cab2.setId(new Integer(e.getDocposition()));
			cab2.getCabletype().setInteger(new Integer(e.getResource().getResource()));
			cab2.getLength().setBigDecimal(e.getLen_cable());
//	e.getGroundresource().getResource()
			cab2.getGnds().setInteger(e.getGroundcnt());
			cab2.getKsvn900().setBigDecimal(e.getKsvn900());
			cab2.getKsvn1800().setBigDecimal(e.getKsvn1800());
		}
		if(en.hasMoreElements()) {
			AfsMountPosAccessBean e = (AfsMountPosAccessBean)en.nextElement();
			cab3.setId(new Integer(e.getDocposition()));
			cab3.getCabletype().setInteger(new Integer(e.getResource().getResource()));
			cab3.getLength().setBigDecimal(e.getLen_cable());
//	e.getGroundresource().getResource()
			cab3.getGnds().setInteger(e.getGroundcnt());
			cab3.getKsvn900().setBigDecimal(e.getKsvn900());
			cab3.getKsvn1800().setBigDecimal(e.getKsvn1800());
		}
		if(en.hasMoreElements()) {
			AfsMountPosAccessBean e = (AfsMountPosAccessBean)en.nextElement();
			cab4.setId(new Integer(e.getDocposition()));
			cab4.getCabletype().setInteger(new Integer(e.getResource().getResource()));
			cab4.getLength().setBigDecimal(e.getLen_cable());
//	e.getGroundresource().getResource()
			cab4.getGnds().setInteger(e.getGroundcnt());
			cab4.getKsvn900().setBigDecimal(e.getKsvn900());
			cab4.getKsvn1800().setBigDecimal(e.getKsvn1800());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getAntenna() {
	return antenna;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAntennamodel() {
	return antennamodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAntennaname() {
	return antennaname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAntennaType() {
	return antennaType;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAntpol() {
	return antpol;
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getAz_ant() {
	return az_ant;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAz_variation() {
	return az_variation;
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
public java.util.Enumeration getCableTypes()
	throws Exception
{
	java.util.Vector vec = new java.util.Vector();
	CableResourceAccessBeanTable table = new CableResourceAccessBeanTable();
    table.setCableResourceAccessBean(
        new CableResourceAccessBean().findByQBE4(
            Boolean.FALSE,
            new Integer(0),
            Boolean.FALSE,
            new Integer(0),
            new Integer(1)));

    for (int i = 0; i <table.numberOfRows() ; i++) {
		vec.addElement(new CableResourceObject(table.getCableResourceAccessBean(i)));
	}

    return vec.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 12:06:28)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	AfsForm aform = (AfsForm)request.getSession().getAttribute( "AfsForm" );
	doc.setInteger(aform.getDocumentId());
	AfsMountPosAccessBean bean = new AfsMountPosAccessBean();
	bean.setInitKey_docposition(docposition.getInteger().intValue());
	return bean;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDdk() {
	return ddk;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getDoc() {
	return doc;
}
public String getDocpos() {
	return docposition.getString();
}
public com.hps.july.web.util.StringAndIntegerProperty getDocposition() {
	return docposition;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getExpedition() {
	return expedition;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFitplace() {
	return fitplace;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getH_set1() {
	return h_set1;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHas_buster() {
	return has_buster;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHas_flt() {
	return has_flt;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getHas_lna() {
	return has_lna;
}
/**
 * 
 * @return com.hps.july.jdbcpersistence.lib.StringAndBigDecimal
 */
public com.hps.july.jdbcpersistence.lib.StringAndBigDecimal getInputpower() {
	return inputpower;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getKind_ant() {
	return kind_ant;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getLocationtype() {
	return locationtype;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufserial() {
	return manufserial;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getNakl() {
	return nakl;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNakl_variation() {
	return nakl_variation;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNum_ant() {
	return num_ant;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getOrder() {
	return order;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getOwner() {
	return owner;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getPrice() {
	return price;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getQty() {
	return qty;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorA() {
	return sectorA;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorB() {
	return sectorB;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorC() {
	return sectorC;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorD() {
	return sectorD;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorE() {
	return sectorE;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorF() {
	return sectorF;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorG() {
	return sectorG;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorH() {
	return sectorH;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorO() {
	return sectorO;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getSectorO1800() {
	return sectorO1800;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSnumber() {
	return serialnumber;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITAFSPOSA;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	AfsForm form = (AfsForm)request.getSession().getAttribute("AfsForm");
	doc.setInteger(form.getDocumentId());
//	antennaType = form.getAntennaType();
	owner.setInteger(form.getOwnerId());
	kind_ant = "T";
	try {
		AfsMountPosAccessBean dp = new AfsMountPosAccessBean();
		dp = dp.findMaxOrderPosition( doc.getInteger() );
		order.setInteger(new Integer(dp.getOrder()+1));
	} catch(Exception e) {
		order.setInteger(new Integer(1));
	}
}
	public void removePositionFromDocument(Integer docPosition) throws java.rmi.RemoteException {
		try {
			AfsMountPosAccessBean position = new AfsMountPosAccessBean();
			position.setInitKey_docposition( docPosition.intValue() );
			position.refreshCopyHelper();

			AfsMountPosAccessBeanTable parts = new AfsMountPosAccessBeanTable();
			parts.setAfsMountPosAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(position.getAgregateParts(), AfsMountPosAccessBean.class ));

			for( int i = 0; i < parts.numberOfRows(); i++ ) {
				AfsMountPosAccessBean part = parts.getAfsMountPosAccessBean(i);
				part.refreshCopyHelper();
				part.getEJBRef().remove();
			}
		} catch( Exception e ) {
			throw new java.rmi.RemoteException( "While adding position to document.", e );
		}
	}
/**
 * 
 * @param newAntenna com.hps.july.web.util.StringAndIntegerProperty
 */
public void setAntenna(com.hps.july.web.util.StringAndIntegerProperty newAntenna) {
	antenna = newAntenna;
}
/**
 * 
 * @param newAntennamodel java.lang.String
 */
public void setAntennamodel(java.lang.String newAntennamodel) {
	antennamodel = newAntennamodel;
}
/**
 * 
 * @param newAntennaname java.lang.String
 */
public void setAntennaname(java.lang.String newAntennaname) {
	antennaname = newAntennaname;
}
/**
 * 
 * @param newAntennaType java.lang.String
 */
public void setAntennaType(java.lang.String newAntennaType) {
	antennaType = newAntennaType;
}
/**
 * 
 * @param newAntpol java.lang.String
 */
public void setAntpol(java.lang.String newAntpol) {
	antpol = newAntpol;
}
/**
 * 
 * @param newAz_variation java.lang.String
 */
public void setAz_variation(java.lang.String newAz_variation) {
	az_variation = newAz_variation;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2004 12:06:28)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * 
 * @param newDdk java.lang.Boolean
 */
public void setDdk(java.lang.Boolean newDdk) {
	ddk = newDdk;
}
public void setDocpos(String newDocposition) {
	docposition.setString(newDocposition);
}
/**
 * 
 * @param newExpedition java.lang.Integer
 */
public void setExpedition(java.lang.Integer newExpedition) {
	expedition = newExpedition;
}
/**
 * 
 * @param newFitplace java.lang.String
 */
public void setFitplace(java.lang.String newFitplace) {
	fitplace = newFitplace;
}
/**
 * 
 * @param newHas_buster java.lang.Boolean
 */
public void setHas_buster(java.lang.Boolean newHas_buster) {
	has_buster = newHas_buster;
}
/**
 * 
 * @param newHas_flt java.lang.Boolean
 */
public void setHas_flt(java.lang.Boolean newHas_flt) {
	has_flt = newHas_flt;
}
/**
 * 
 * @param newHas_lna java.lang.Boolean
 */
public void setHas_lna(java.lang.Boolean newHas_lna) {
	has_lna = newHas_lna;
}
/**
 * 
 * @param newKind_ant java.lang.String
 */
public void setKind_ant(java.lang.String newKind_ant) {
	kind_ant = newKind_ant;
}
/**
 * 
 * @param newLocationtype java.lang.String
 */
public void setLocationtype(java.lang.String newLocationtype) {
	locationtype = newLocationtype;
}
/**
 * 
 * @param newManufserial java.lang.String
 */
public void setManufserial(java.lang.String newManufserial) {
	manufserial = newManufserial;
}
/**
 * 
 * @param newNakl_variation java.lang.String
 */
public void setNakl_variation(java.lang.String newNakl_variation) {
	nakl_variation = newNakl_variation;
}
/**
 * 
 * @param newNum_ant java.lang.String
 */
public void setNum_ant(java.lang.String newNum_ant) {
	num_ant = newNum_ant;
}
/**
 * 
 * @param newSectorA java.lang.Boolean
 */
public void setSectorA(java.lang.Boolean newSectorA) {
	sectorA = newSectorA;
}
/**
 * 
 * @param newSectorB java.lang.Boolean
 */
public void setSectorB(java.lang.Boolean newSectorB) {
	sectorB = newSectorB;
}
/**
 * 
 * @param newSectorC java.lang.Boolean
 */
public void setSectorC(java.lang.Boolean newSectorC) {
	sectorC = newSectorC;
}
/**
 * 
 * @param newSectorD java.lang.Boolean
 */
public void setSectorD(java.lang.Boolean newSectorD) {
	sectorD = newSectorD;
}
/**
 * 
 * @param newSectorE java.lang.Boolean
 */
public void setSectorE(java.lang.Boolean newSectorE) {
	sectorE = newSectorE;
}
/**
 * 
 * @param newSectorF java.lang.Boolean
 */
public void setSectorF(java.lang.Boolean newSectorF) {
	sectorF = newSectorF;
}
/**
 * 
 * @param newSectorG java.lang.Boolean
 */
public void setSectorG(java.lang.Boolean newSectorG) {
	sectorG = newSectorG;
}
/**
 * 
 * @param newSectorH java.lang.Boolean
 */
public void setSectorH(java.lang.Boolean newSectorH) {
	sectorH = newSectorH;
}
/**
 * 
 * @param newSectorO java.lang.Boolean
 */
public void setSectorO(java.lang.Boolean newSectorO) {
	sectorO = newSectorO;
}
/**
 * 
 * @param newSectorO1800 java.lang.Boolean
 */
public void setSectorO1800(java.lang.Boolean newSectorO1800) {
	sectorO1800 = newSectorO1800;
}
public void setSnumber(java.lang.String newSerialnumber) {
	serialnumber = newSerialnumber;
}
public void updateCables()
	throws UpdateValidationException
{
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	try {
		deleteCables();
		createCable(keyGen,cab1);
		createCable(keyGen,cab2);
		createCable(keyGen,cab3);
		createCable(keyGen,cab4);
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.afsamount.cableupdate");
	}
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if (order.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.order"));
	} else if (!order.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.order"));
	}

	boolean fserial = getFictionSerial() != null && getFictionSerial().booleanValue();
	
	boolean sectorSelected = false;

	if(sectorA != null) sectorSelected |= sectorA.booleanValue();
	if(sectorB != null) sectorSelected |= sectorB.booleanValue();
	if(sectorC != null) sectorSelected |= sectorC.booleanValue();
	if(sectorD != null) sectorSelected |= sectorD.booleanValue();
	if(sectorE != null) sectorSelected |= sectorE.booleanValue();
	if(sectorF != null) sectorSelected |= sectorF.booleanValue();
	if(sectorG != null) sectorSelected |= sectorG.booleanValue();
	if(sectorH != null) sectorSelected |= sectorH.booleanValue();
	if(sectorO != null) sectorSelected |= sectorO.booleanValue();
	if(sectorO1800 != null) sectorSelected |= sectorO1800.booleanValue();

	if(!sectorSelected) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.sector"));
	}
		
	if (num_ant != null && !"".equals(num_ant.trim())) {
		num_ant = num_ant.trim();
		if(num_ant.length() > 32) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.num_ant"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.num_ant"));
	}

	if(az_ant.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.az_ant"));
	} else if(!az_ant.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.az_ant"));
	} else {
		if(az_ant.getBigDecimal().doubleValue() < 0.0d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.az_antless"));
		} else if(az_ant.getBigDecimal().doubleValue() > 360.0d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.az_antbig"));
		}
	}

	if(az_variation != null && az_variation.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.az_variation"));
	}

	if(kind_ant == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.kind_ant"));
	} else if(!"R".equals(kind_ant) && !"T".equals(kind_ant) && !"D".equals(kind_ant)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.kind_ant"));
	}
	
	if (antenna.isEmpty()) {
		// Find resource by serialnumber if its empty
		if ( (serialnumber != null && serialnumber.length() > 0) ) {
			try {
				StorageCardAccessBean ab = new StorageCardAccessBean();
				StorageCardAccessBean card = ab.findBySerial(serialnumber);
				antenna.setInteger(new Integer(card.getResource().getResource()));
				antennaname = card.getResource().getName();
				antennamodel = card.getResource().getModel();
				price.setBigDecimal(card.getPrice());
				qty.setString("1");
				fitplace = card.getPlace();
				setManufserial(card.getManufserial());
			} catch(Exception e) {
			}
//		} else {
//			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.serialparty"));
		}
	}
	
	if(antenna.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.antenna"));
		throw new ValidationException();
	} else if(!antenna.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.antenna"));
		throw new ValidationException();
	}

	try {
		ResourceAccessBean bean = constructAntenna();
		String policy = bean.getCountpolicy();
		if("S".equals(policy)) {
			if ( !fserial && (serialnumber == null || "".equals(serialnumber))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.serial"));
			}
			qty.setString("1");
			if(!fserial && serialnumber != null && !"".equals(serialnumber)) {
				try {
					StorageCardAccessBean ab = new StorageCardAccessBean();
					StorageCardAccessBean card = ab.findBySerial(serialnumber);
					if( card.getResource().getResource() != antenna.getInteger().intValue()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.diffresources"));
					}
					price.setBigDecimal(card.getPrice());
					setSourceBoxed(card.getBoxed());
					setSourceBroken(card.getBroken());
					setSourceClosed(card.getClosed());
					setOwnercode(new Integer(card.getOwner().getOrganization()));
					setManufserial(card.getManufserial());
				} catch(Exception e) {
//					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.serial"));
					qty.setString("1");
					price.setString("0.00");
				}
			}
			try {
				AntennaResourceAccessBean c = new AntennaResourceAccessBean();
				c.setInitKey_resource(bean.getResource());
				c.refreshCopyHelper();
				antpol = c.getPolarization();
			} catch(Exception e) {
				e.printStackTrace(System.out);
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.antennaresource"));
			}
			if(fitplace == null || "".equals(fitplace.trim())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.fitplace"));
			} else {
				fitplace = fitplace.trim();
				if(fitplace.length() > 40) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.fitplace"));
				}
			}
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.notserial"));
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afspos.resource"));
	}

	if(manufserial != null && manufserial.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.manufserial"));
	}

	if(price.getBigDecimal() == null) {
		price.setString("0.00");
	}

	if(!qty.isEmpty()) {
		if (!qty.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.qty"));
		} else if (qty.getBigDecimal().doubleValue() <= 0.0d) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.qtylow"));
		}
	} else {
		qty.setString("1");
	}

	setResultBoxed(getSourceBoxed());
	setResultBroken(getSourceBroken());
	setResultClosed(getSourceClosed());
/*
	// cable check
	if(cable.isEmpty()) {
		try {
			StorageCardAccessBean ab = new StorageCardAccessBean();
			StorageCardAccessBean card = ab.findByStorageOwnerParty(expedition, cableowner.getInteger(), party);
			cable.setInteger(new Integer(card.getResource().getResource()));
			cablename = card.getResource().getName();
			cablemodel = card.getResource().getModel();
			cable_price.setBigDecimal(card.getPrice());
		} catch(Exception e) {
		}
	}

	if(cableowner.isEmpty()) {
		cableowner.setInteger(owner.getInteger());
	}

	if(cable.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.cable"));
	} else if(!cable.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cable"));
	} else {
		try {
			ResourceAccessBean bean = constructCable();
			try {
				CableResourceAccessBean c = new CableResourceAccessBean();
				c.setInitKey_resource(bean.getResource());
				c.refreshCopyHelper();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cableresource"));
			}
			cable_price.setString("0.00");
			if("P".equals(bean.getCountpolicy())) {
				if(party == null || "".equals(party.trim())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cableparty"));
				} else {
					try {
						StorageCardAccessBean ab = new StorageCardAccessBean();
						StorageCardAccessBean card = ab.findByStorageOwnerParty(expedition, cableowner.getInteger(), party);
						cable.setInteger(new Integer(card.getResource().getResource()));
						cablename = card.getResource().getName();
						cablemodel = card.getResource().getModel();
						cable_price.setBigDecimal(card.getPrice());
					} catch(Exception e) {
						cable_price.setString("0.00");
					}
				}
			} else
			if("S".equals(bean.getCountpolicy())) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cablecantserial"));
			}
			if(len_cable.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.len_cable"));
			} else if(!len_cable.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.len_cable"));
			}
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afspos.cable"));
		}
		if(!ground.isEmpty()) {
			try {
				ResourceAccessBean bean = constructGround();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.afspos.ground"));
			}
		}
		if(!groundqty.isEmpty()) {
			if(!groundqty.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.groundqty"));
			}
		}
	}
*/
	if(
		(cab1.getCabletype().getInteger() == null || cab1.getCabletype().getInteger().intValue() == 0) &&
		(cab2.getCabletype().getInteger() == null || cab2.getCabletype().getInteger().intValue() == 0) &&
		(cab3.getCabletype().getInteger() == null || cab3.getCabletype().getInteger().intValue() == 0) &&
		(cab4.getCabletype().getInteger() == null || cab4.getCabletype().getInteger().intValue() == 0)
	) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cableselect"));
	}
	if(cab1.getCabletype().getInteger() != null && cab1.getCabletype().getInteger().intValue() != 0) {
		if(cab1.getLength().isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.cabl.length"));
		}
		//System.out.println("----boolean " + cab1.getLength().isOk());
		//System.out.println("---- " + cab1.getLength());
		if(!cab1.getLength().isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cabl.length"));
		}
		if(!cab1.getGnds().isEmpty() && !cab1.getGnds().isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cabl.gnds"));
		}
	}
	if(cab2.getCabletype().getInteger() != null && cab2.getCabletype().getInteger().intValue() != 0) {
		if(cab2.getLength().isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.cab2.length"));
		}
		if(!cab2.getLength().isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cab2.length"));
		}
		if(!cab2.getGnds().isEmpty() && !cab2.getGnds().isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cab2.gnds"));
		}
	}
	if(cab3.getCabletype().getInteger() != null && cab3.getCabletype().getInteger().intValue() != 0) {
		if(cab3.getLength().isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.cab3.length"));
		}
		if(!cab3.getLength().isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cab3.length"));
		}
		if(!cab3.getGnds().isEmpty() && !cab3.getGnds().isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cab3.gnds"));
		}
	}
	if(cab4.getCabletype().getInteger() != null && cab4.getCabletype().getInteger().intValue() != 0) {
		if(cab4.getLength().isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.afspos.cab4.length"));
		}
		if(!cab4.getLength().isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cab4.length"));
		}
		if(!cab4.getGnds().isEmpty() && !cab4.getGnds().isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.afspos.cab4.gnds"));
		}
	}

	if(price.getBigDecimal() == null) {
		price.setString("0.00");
	}
/*	
	if(cable_price.getBigDecimal() == null) {
		cable_price.setString("0.00");
	}
*/
	if (!errors.empty())
		throw new ValidationException();
}
}
