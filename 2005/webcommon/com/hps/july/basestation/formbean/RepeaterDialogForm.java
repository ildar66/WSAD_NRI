package com.hps.july.basestation.formbean;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import javax.servlet.http.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import org.apache.struts.action.*;
import java.math.*;
import com.hps.july.persistence.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.web.util.*;
import com.hps.july.basestation.valueobject.*;
import com.hps.july.sitedoc.valueobject.*;
import com.hps.july.constants.Applications;

/**
 *	Форма добавления и редактирования репитера.
 *	Соответствие между полями (видимыми) из формы и EJB:
 *		Позиция			- position		# записывается только код текущей позиции
 *			Регион			- берётся из позиции
 *			Зона сети		- берётся из позиции
 *			Адрес			- берётся из позиции
 *			Широта			- берётся из позиции
 *			Долгота			- берётся из позиции
 *
 *		Донорная БС		- donor_bs
 *		Донорный сектор	- donor_sector
 *		Тип подключения	- conn_type
 *		Донор. антена	- donor_ant
 *		Азимут			- берётся из антены
 *		Класс обор.		- repeaterclass
 *		Тип репитера	- repeater_type
*/
public class RepeaterDialogForm
	extends EquipmentPForm
	//extends EditForm
{
	private PositionModel positionModel = new PositionModel();
	// ----
	private BaseStationModel donorbs = new BaseStationModel();
	private SectorModel donorsector = new SectorModel();
	private AntennaModel donorantenna = new AntennaModel();

	private String repeaterclass;
	private String donor_type;
	private RepeaterResourceModel repeater = new RepeaterResourceModel();
	private StringAndBigDecimal repeaterpower = new StringAndBigDecimal();
	private StringAndInteger numchanels = new StringAndInteger();
	private StringAndInteger number = new StringAndInteger();
	private StringAndBigDecimal bandwidth = new StringAndBigDecimal();

//	private int donor_sectCode;
//	private java.lang.String repiter_class;
//	private StringAndBigDecimalProperty reppower = new StringAndBigDecimalProperty();
//	private com.hps.july.persistence.AntennaAccessBean donor_ant;
//	private com.hps.july.persistence.RepiterResAccessBean resource;
	private boolean flagOperation;
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
    throws Exception
{
	try {
		Enumeration e = new AntennaAccessBean().findByEquipmentOrderByNumAsc(new Integer(getStorageplace()));
		while(e.hasMoreElements()) {
			AntennaAccessBean b = (AntennaAccessBean)e.nextElement();
			b.getEJBRef().remove();
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	SiteDocObject.deleteDocuments(getStorageplace());
}
private AntennaAccessBean constructAntenna() throws Exception {
	/*
	if (!antennadonorcode.isEmpty() && antennadonorcode.isOk()) {
		donor_ant = new AntennaAccessBean();
		donor_ant.setInitKey_idanten(getAntennadonorcode().intValue());
		donor_ant.refreshCopyHelper();
	}
	*/
	return donorantenna.getAccessBean();
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
    throws Exception
{
	// get a new storageplace
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setStorageplace(keyGen.getNextKey("tables.storageplaces"));

	System.out.println("#RPT#: storageplace:"+getStorageplace());
	System.out.println("#RPT#: positionModel.division:"+positionModel.getDivision());
	System.out.println("#RPT#: positionModel.key:"+positionModel.getKey());
	System.out.println("#RPT#: donorsector:"+donorsector.getKey());
	System.out.println("#RPT#: donot_type:"+donor_type);
	System.out.println("#RPT#: repeaterclass:"+repeaterclass);
	System.out.println("#RPT#: repeater.key:"+repeater.getKey());
	System.out.println("#RPT#: reppower:"+getReppower());

	RepiterAccessBean bean = new RepiterAccessBean(
		getStorageplace(),
		positionModel.getDivision(),
		"repeater", // name
		"-", // address
		positionModel.getKey(),
		donorsector.getKey(),
		donor_type,
		repeaterclass,
		repeater.getKey(),
		getReppower(),
		getNumber()
	);

	System.out.println("#RPT#: CREATED!");
	
    return bean;
}
private RepiterResAccessBean constructRepeaterRes()
	throws Exception
{
	/*
	if (!resourcecode.isEmpty() && resourcecode.isOk()) {
		resource = new RepiterResAccessBean();
		resource.setInitKey_resource(getResourcecode().intValue());
		resource.refreshCopyHelper();
	}
	return resource;
	*/
	return repeater.getAccessBean();
}
public void fillRecord(AbstractEntityAccessBean bean) {
}
public Integer getAntennadonorcode() {
	return donorantenna.getKey();
}
public String getAntennadonorcodeFrm() {
	if(donorantenna.getKey() != null) {
		return donorantenna.getKey().toString();
	} else {
		return "";
	}
}
public String getAzimut() {
	return donorantenna.getAzimutFrm();
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2003 16:40:25)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getBandwidth() {
	return bandwidth.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2003 16:40:25)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getBandwidthFrm() {
	return bandwidth.getString();
}
public AbstractEntityAccessBean getDataBean(HttpServletRequest request) {
	try {
		RepiterAccessBean bean = new RepiterAccessBean();
		bean.setInitKey_storageplace(getStorageplace());
		bean.refreshCopyHelper();
		
		return bean;
	} catch (Exception e) {
		DebugSupport.printlnError(e);
		return null;
	}
}
public Antenna getDonor_ant() throws Exception {
    AntennaAccessBean bean = constructAntenna();
    return bean != null ? (Antenna) bean.getEJBRef() : null;
}
public int getDonor_sectCode() {
	if(donorsector.getKey() != null) {
		return donorsector.getKey().intValue();
	} else {
		return 0;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2003 12:16:24)
 * @return java.lang.String
 */
public java.lang.String getDonor_type() {
	return donor_type;
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.AntennaModel
 */
public com.hps.july.basestation.valueobject.AntennaModel getDonorantenna() {
	return donorantenna;
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.BaseStationModel
 */
public com.hps.july.basestation.valueobject.BaseStationModel getDonorbs() {
	return donorbs;
}
public String getDonorresourcename() {
	return donorantenna.getFullName();
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.SectorModel
 */
public com.hps.july.basestation.valueobject.SectorModel getDonorsector() {
	return donorsector;
}
public String getListAttributeName() {
	return "RepeaterList";
}
public String getName() {
	return "-";
}
public int getNumber() {
	return number.getInt();
}
public String getNumberFrm() {
	return number.getString();
}
public Integer getNumchanals() {
	return numchanels.getInteger();
}
public String getNumchanalsFrm() {
	return numchanels.getString();
}
public Position getPosition() {
	PositionAccessBean p = positionModel.getAccessBean();
	if(p == null) {
		return null;
	} else {
		try {
			return (Position)positionModel.getAccessBean().getEJBRef();
		} catch(Exception e) {
			return null;
		}
	}
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.PositionModel
 */
public com.hps.july.basestation.valueobject.PositionModel getPositionModel() {
	return positionModel;
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.RepeaterResourceModel
 */
public com.hps.july.basestation.valueobject.RepeaterResourceModel getRepeater() {
	return repeater;
}
public String getRepiter_class() {
	return repeaterclass;
}
public BigDecimal getReppower() {
	return repeaterpower.getBigDecimal();
}
public String getReppowerFrm() {
	return repeaterpower.getString();
}
public RepiterRes getResource() {
	try {
		RepiterResAccessBean ab = repeater.getAccessBean();
		System.out.println("REPEATER_FORM.GET_RES:"+ab.getResource());
		if(ab != null) {
			return (RepiterRes)ab.getEJBRef();
		} else {
			return null;
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
	
}
public Integer getResourcecode() {
	return repeater.getKey();
}
public String getResourcecodeFrm() {
	return repeater.getKeyFrm();
}
public java.lang.String getResourcename() {
	return repeater.getName();
}
public int getState() {
    return com.hps.july.basestation.APPStates.REPEATER_DIALOG;
}
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    /** 
    if ("Edit".equals(getAction()) || "View".equals(getAction())) {
        Enumeration e = new AntennaAccessBean().findByEquipmentOrderByNumAsc(new Integer(getStorageplace()));

        if (e.hasMoreElements()) {
            request.setAttribute("antennes", e);
        } else {
            request.setAttribute("antennes", new Vector().elements());
        }
    }
  */
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	try {
		if(request.getParameter("positionIdFrm") != null) {
			positionModel.setKeyFrm(request.getParameter("positionIdFrm"));
		} else {
		    positionModel.setKey(null);
		}
		positionModel.refresh();
		donorbs.setKey(null);
		donorbs.refresh();
		if(request.getParameter("idsect") != null) {
			donorsector.setKeyFrm(request.getParameter("idsect"));
			donorsector.refresh();
//			donorsector.getAccessBean().getEquipment();
			try {
				donorbs.refresh(donorsector.getAccessBean().getEquipment());
			} catch(Exception e) {
			}
		} else {
			donorsector.setKey(null);
			donorsector.refresh();
		}
		donor_type = "";
		donorantenna.setKey(null);
		donorantenna.refresh();
		repeaterclass = "";
		repeater.setKey(null);
		repeater.refresh();
		repeaterpower.setBigDecimal(null);
		numchanels.setInteger(null);
		bandwidth.setBigDecimal(null);
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw e;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2005 15:49:07)
 * @return boolean
 */
public boolean isFlagOperation() {
	return flagOperation;
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    super.processDelete(request, errors);
	setFlagOperation(true);
    return "success";
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    super.processInsert(request, errors);
	setFlagOperation(true);
    return "success";
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
    super.processUpdate(request, errors);
	setFlagOperation(true);
    return "success";
}
public void setAntennadonorcode(Integer newAntennadonorcode) {
	donorantenna.setKey(newAntennadonorcode);
	//antennadonorcode.setInteger(newAntennadonorcode);
}
public void setAntennadonorcodeFrm(String newAntennadonorcode) {
	donorantenna.setKeyFrm(newAntennadonorcode);
}
public void setAzimut(String newAzimut) {
//	donorantenna.setAzimut(azimut = newAzimut;
	System.out.println("RepeaterForm.setAimut CALLED!");
}
public void setBandwidth(BigDecimal newBandwidth) {
	bandwidth.setBigDecimal(newBandwidth);
}
public void setBandwidthFrm(String newBandwidth) {
	bandwidth.setString(newBandwidth);
}
public void setDonor_ant(AntennaAccessBean newDonor_ant) throws Exception {
	if (newDonor_ant != null) {
		donorantenna.refresh(newDonor_ant);
//		antennadonorcode.setInteger(null);
//		setDonorresourcename(null);
//		setAzimut(null);
	} else {
		donorantenna.setKey(null);
//		antennadonorcode.setInteger(new Integer(newDonor_ant.getIdanten()));
//		setDonorresourcename(newDonor_ant.getResource().getName());
//		setAzimut(newDonor_ant.getAzant().toString());
    }
}
public void setDonor_sect(SectorAccessBean newDonor_sect)
	throws Exception
{
	if (newDonor_sect != null) {
		donorsector.refresh(newDonor_sect);
		try {
			donorbs.refresh(donorsector.getAccessBean().getEquipment());
		} catch(Exception e) {
		}
	} else {
		donorsector.setKey(null);
    }
}
public void setDonor_sectCode(int newDonor_sectCode) {
	donorsector.setKey(new Integer(newDonor_sectCode));
//	donor_sectCode = newDonor_sectCode;
}
public void setDonor_type(java.lang.String newDonor_type) {
	donor_type = newDonor_type;
}
public void setDonorresourcename(java.lang.String newDonorresourcename) {
	//donorresourcename = newDonorresourcename;
	System.out.println("RepeaterForm.setDonorresource CALLED! :"+newDonorresourcename);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2005 15:49:07)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
public void setNumber(int newNumber) {
	number.setInt(newNumber);
}
public void setNumberFrm(String newNumber) {
	number.setString(newNumber);
}
public void setNumchanals(Integer newNumchanals) {
	numchanels.setInteger(newNumchanals);
}
public void setNumchanalsFrm(String newNumchanals) {
	numchanels.setString(newNumchanals);
}
public void setPosition(PositionAccessBean newPosition)
	throws Exception
{
	positionModel.refresh(newPosition);
}
public void setRepiter_class(java.lang.String newRepiter_class) {
	repeaterclass = newRepiter_class;
}
public void setReppower(BigDecimal newReppower) {
	repeaterpower.setBigDecimal(newReppower);
}
public void setReppowerFrm(String newReppower) {
	repeaterpower.setString(newReppower);
}
public void setResource(com.hps.july.persistence.RepiterResAccessBean newResource) {
	repeater.refresh(newResource);
	//resource = newResource;
}
public void setResourcecode(Integer newResourcecode) {
	repeater.setKey(newResourcecode);
//	resourcecode.setInteger(newResourcecode);
}
public void setResourcecodeFrm(String newResourcecode) {
	repeater.setKeyFrm(newResourcecode);
	//resourcecode.setString(newResourcecode);
}
public void setResourcename(java.lang.String newResourcename) {
//	resourcename = newResourcename;
	System.out.println("RepeaterForm.setResourcename CALLED! :"+newResourcename);
}
public void validateValues(ActionErrors errors)
	throws Exception
{
	// check position
	positionModel.refresh();
	if(positionModel.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.position.empty"));
	} else if(positionModel.isFormatError()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.position.keyformat"));
	} else if(positionModel.isNotExist()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.position.notfound"));
	}

	donorbs.refresh();
	// check sector
	System.out.println("donorsector.getKeyFrm()= " + donorsector.getKeyFrm());//temp
	donorsector.refresh();
	if(donorsector.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.sector.empty"));
	} else if(donorsector.isFormatError()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.sector.keyformat"));
	} else if(donorsector.isNotExist()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.sector.notfound"));
	} else {
		try {
			SectorAccessBean s = donorsector.getAccessBean();
System.out.println("Sector:"+s);
			BaseStationAccessBean bs = s.getEquipment();
System.out.println("BaseStation:"+bs);
			donorbs.refresh(bs);
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.sector.bs"));
		}
	}
	// check connection type (donor_type)
	
	if(donor_type == null || "".equals(donor_type.trim())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.donor_type.empty"));
	} else {
		donor_type = donor_type.trim();
		if(!"A".equals(donor_type) && !"B".equals(donor_type) && !"C".equals(donor_type)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.donor_type.invalid"));
		}
	}

	// check antenna if is
	donorantenna.refresh();
	if(!donorantenna.isEmpty()) {
		if(donorantenna.isFormatError()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.donorantenna.keyformat"));
		} else if(donorantenna.isNotExist()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.donorantenna.notfound"));
		} else {
		}
	}

	// check repeater class
	if(repeaterclass == null || "".equals(repeaterclass.trim())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.repeaterclass.empty"));
	} else {
		repeaterclass = repeaterclass.trim();
		if(!"A".equals(repeaterclass) && !"B".equals(repeaterclass) && !"C".equals(repeaterclass) && !"D".equals(repeaterclass) && !"E".equals(repeaterclass)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.repeaterclass.invalid"));
		}
	}

	// check repeater
	repeater.refresh();
	if(repeater.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.repeater.empty"));
	} else if(repeater.isFormatError()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.repeater.keyformat"));
	} else if(repeater.isNotExist()){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.repeater.notfound"));
	}

	if (("B".equals(repeaterclass) || "C".equals(repeaterclass))) {
		SectorAccessBean sectorBean = donorsector.getAccessBean();
		Integer trxnum = sectorBean.getTrxnum();
		if (getNumchanals() == null) {
			if(trxnum != null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.trxnum.invalidcn",trxnum));
			}
		} else {
			if(trxnum == null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.trxnum.invalidtn", getNumchanals()));
			} else {
				if(getNumchanals().intValue() != trxnum.intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.trxnum.invalid", getNumchanals(), trxnum));
				}
			}
		}
	}

	if (number.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.number.empty"));
	} else if(!number.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.number.invalid"));
	}

	if (repeaterpower.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.reppower.empty"));
	} else if (!repeaterpower.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.reppower.invalid"));
	}
	
	if (!numchanels.isEmpty() && !numchanels.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.numchanals.invalid"));
	}
	
	if (!bandwidth.isEmpty() && !bandwidth.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.bandwidth.invalid"));
	}

	if (!getPwrvalProp().isOk()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.pwrval", getPwrvalProp().formatMessage()));
    }
	
	// check state
	if(getEquipmentState() == null || "".equals(getEquipmentState().trim())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.equipmentstate.empty"));
	} else {
		setEquipmentState(getEquipmentState().trim());
		if("MPRTWD".indexOf(getEquipmentState()) < 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.repeater.equipmentstate.invalid"));
		}
	}
    
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
