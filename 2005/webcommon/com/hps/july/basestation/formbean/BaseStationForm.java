package com.hps.july.basestation.formbean;

import com.hps.july.basestation.valueobject.AntennaObject;
import com.hps.july.basestation.valueobject.SectorObject;
import com.hps.july.basestation.valueobject.BaseStationObject;
import java.util.*;
import com.ibm.ivj.ejb.runtime.*;
import javax.ejb.*;
import com.hps.july.persistence.*;
import com.hps.july.persistence.PositionAccessBean;

import com.hps.july.siteinfo.formbean.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.sitedoc.valueobject.*;

/**
 * Ѕазова€ форма редактировани€ базовой станции
 */
public abstract class BaseStationForm
	extends com.hps.july.jdbcpersistence.lib.EditCopyForm
{
	private PositionForm positionForm=null;
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 13:17:58)
 */
public void beforeDelete(
    AbstractEntityAccessBean bean,
    javax.servlet.http.HttpServletRequest request)
    throws Exception {

    DebugSupport.printlnTest("BaseStationForm beforeDelete() started");

    DebugSupport.printlnTest("!!!deleteChanalPowers() started");	
    deleteChanalPowers();
    DebugSupport.printlnTest("!!!deleteChanalPowers() finished");

    //DebugSupport.printlnTest("!!!deleteAntennes started");	
    deleteAntennes();
    //DebugSupport.printlnTest("!!!deleteAntennes finished");

    //DebugSupport.printlnTest("!!!deleteSectors started");
    deleteSectors();
    //DebugSupport.printlnTest("!!!deleteSectors finished");

    //DebugSupport.printlnTest("!!!deleteDocuments started");
    SiteDocObject.deleteDocuments(getBasestation());
    //DebugSupport.printlnTest("!!!deleteDocuments finished");	

}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 18:29:13)
 */
public void deleteAntennes() throws Exception {

    try {
        AntennaAccessBeanTable table = new AntennaAccessBeanTable();
        AntennaObject  antenna = null;
        table.setAntennaAccessBean(
            new AntennaAccessBean().findByEquipmentOrderByNumAsc(
                new Integer(getBasestation())));
        for (int i = 0; i < table.numberOfRows(); i++) {
            antenna = new AntennaObject(table.getAntennaAccessBean(i));
            antenna.deleteWorkBands();
            antenna.deleteSectorLinks();
            antenna.getEJBRef().remove();
            DebugSupport.printlnTest("Antenna was deleted");
        }
    } catch (FinderException e) {
        DebugSupport.printlnTest("There are no antennes");
    }

}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 14:01:07)
 * @return boolean
 */
public void deleteChanalPowers() throws Exception {
    try {

        java.util.Enumeration enum =
            new ChanalPowerAccessBean().findChanalPowersByBasestation(
                new StoragePlaceKey(getBasestation()));

        while (enum.hasMoreElements()) {

            ((ChanalPowerAccessBean) enum.nextElement()).getEJBRef().remove();

        }

    } catch (FinderException e) {

    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 18:29:13)
 */
public void deleteSectors() throws Exception {
    try {
        SectorAccessBeanTable table = new SectorAccessBeanTable();
         SectorObject sector = null;
        table.setSectorAccessBean(
            new SectorAccessBean().findByBasestationOrderByNumberAsc(
                new Integer(getBasestation())));
        for (int i = 0; i < table.numberOfRows(); i++) {
            sector = new SectorObject(table.getSectorAccessBean(i));
            sector.deleteAntennaLinks();
            sector.getEJBRef().remove();
            DebugSupport.printlnTest("sector was deleted");

        }
    } catch (FinderException e) {
        DebugSupport.printlnTest("There are no sectors");
    }

}
public void fillPositionForm(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	int appHome = 0;
	try {
		appHome = ((Integer)request.getSession().getAttribute(AppConstants.APP_HOME)).intValue();
	} catch(Exception e) {
		System.out.println("Undefined APP_HOME");
	}
    if (appHome == Applications.SITEINFO) {
		getPositionForm().initCollections(request);
		int positionId = Integer.parseInt(request.getParameter("position"));
		PositionAccessBean bean=new PositionAccessBean();
		bean.setInitKey_storageplace(positionId);
		bean.refreshCopyHelper();
		BeanUtils.copyProperties(getPositionForm(),bean);
		getPositionForm().fillRecord(bean);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 20:49:13)
 * @return java.lang.String
 */
public abstract int getBasestation();
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 20:50:10)
 * @return java.lang.String
 */
public abstract String getContrNumberFrm();
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 20:50:10)
 * @return java.lang.String
 */
public abstract String getNumberFrm();
/**
 * Insert the method's description here.
 * Creation date: (12.05.2003 9:41:52)
 * @return com.hps.july.persistence.Position
 */
public abstract com.hps.july.persistence.Position getPosition() throws Exception;
public PositionForm getPositionForm() {
	if(positionForm==null) {
		positionForm = new PositionForm();
	}
	//DebugSupport.printlnTest("getPositionForm positionForm="+positionForm);
	return  positionForm;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 20:49:13)
 * @return java.lang.String
 */
public abstract String getStationName();
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 20:48:17)
 * @return java.lang.String
 */
public abstract String getStationType();
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 20:48:17)
 * @return java.lang.String
 */
public String getStationTypeName() {
    if (getStationType().equals(BaseStationObject.TYPE_CHECK_DAMPS_D)) {
        return BaseStationObject.TYPE_VALUE_DAMPS_D;
    } else
        if (getStationType().equals(BaseStationObject.TYPE_CHECK_DCS_C)) {
            return BaseStationObject.TYPE_VALUE_DCS_C;
        } else
            if (getStationType().equals(BaseStationObject.TYPE_CHECK_GSM_G)) {
                return BaseStationObject.TYPE_VALUE_GSM_G;
            } else
                if (getStationType().equals(BaseStationObject.TYPE_CHECK_GSM_S)) {
                    return BaseStationObject.TYPE_VALUE_GSM_S;
                }

    return null;

}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 20:50:10)
 * @return java.lang.String
 */
public abstract String getSwitchNumberFrm();
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 14:01:07)
 * @return boolean
 */
public boolean hasAntennes() throws Exception {

    try {
        Enumeration enum =
            new AntennaAccessBean().findByEquipmentOrderByNumAsc(
                new Integer(getBasestation()));
        if (enum == null || !enum.hasMoreElements())
            throw new FinderException();
        return true;
    } catch (FinderException e) {
        return false;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 14:01:07)
 * @return boolean
 */
public boolean hasChanalPowers() throws Exception{
    try {
        new ChanalPowerAccessBean().findChanalPowersByBasestation(
            new StoragePlaceKey(getBasestation()));
        return true;
    } catch (FinderException e) {
        return false;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 14:01:07)
 * @return boolean
 */
public boolean hasDocumentLinks() throws Exception {
    try {
        new Sitedoc2SplaceAccessBean().findSitedoc2SplacesByStoragePlace(
            new StoragePlaceKey(getBasestation()));
        return true;
    } catch (FinderException e) {
        return false;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 14:01:07)
 * @return boolean
 */
public boolean hasDocuments() throws Exception {
    try {
        Sitedoc2SplaceAccessBeanTable table = new Sitedoc2SplaceAccessBeanTable();
        Sitedoc2SplaceAccessBeanTable table1 = new Sitedoc2SplaceAccessBeanTable();

        table.setSitedoc2SplaceAccessBean(
            new Sitedoc2SplaceAccessBean().findSitedoc2SplacesByStoragePlace(
                new StoragePlaceKey(getBasestation())));
        if (table.numberOfRows() == 0) {
            return false;
        }
        SiteDocAccessBean doc = null;
        for (int i = 0; i < table.numberOfRows(); i++) {
            doc = table.getSitedoc2SplaceAccessBean(i).getSiteDoc();
            if (doc.getProjectAction() == null) {
                table1.setSitedoc2SplaceAccessBean(
                    new Sitedoc2SplaceAccessBean().findSitedoc2SplacesBySiteDoc(
                        new SiteDocKey(doc.getSitedoc())));
                if (table1.numberOfRows() == 1)
                    return true;
            }

        }

        return false;
    } catch (FinderException e) {
        return false;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (18.08.2003 14:01:07)
 * @return boolean
 */
public boolean hasSectors() throws Exception {

    try {
        Enumeration enum =
            new SectorAccessBean().findByBasestationOrderByNumberAsc(
                new Integer(getBasestation()));
        if (enum == null || !enum.hasMoreElements())
            throw new FinderException();
        return true;
    } catch (FinderException e) {
        return false;
    }

}
public void initCollections(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initCollections(request);
	getPositionForm().initCollections(request);
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2003 20:49:13)
 * @return java.lang.String
 */
public abstract void setBasestation(int val);
public void setPositionForm(PositionForm newPositionForm) {
	positionForm = newPositionForm;
}
}
