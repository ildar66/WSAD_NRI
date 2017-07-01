package com.hps.july.inventory.actionbean;

import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;

/**
 * Обработчик формы списка позиций документа "Акт монтажа АФС"
 */
public class ShowAfsPositionListAction
	extends com.hps.july.web.util.BrowseAction
{
public String constructComplectName(EquipmentSetAccessBean equ)
	throws java.lang.Exception
{
	return com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(equ);
}
public void fillComplect(AfsMountActAccessBean bean, AfsPositionListForm aform)
	throws Exception
{
	try {
		EquipmentSetAccessBean equ = new EquipmentSetAccessBean();
		equ.setInitKey_storageplace(bean.getTo().getStorageplace());
		equ.refreshCopyHelper();
		if(equ.getEJBRef() instanceof BaseStation) {
			BaseStationAccessBean b = new BaseStationAccessBean(equ.getEJBRef());
			if("D".equals(b.getStationType())) {
				aform.setAntennaType("B"); // DAMPS
			} else {
				aform.setAntennaType("A"); // GSM
			}
		} else {
			// Вообще то ошибка, но ...
			aform.setAntennaType("A");
		}
		aform.setComplect(new Integer(equ.getStorageplace()));
		aform.setComplectname(constructComplectName(equ));
		PositionAccessBean p = equ.getPosition();
		aform.setPosition(new Integer(p.getStorageplace()));
		String positionid = "";
		if(p.getGsmid() != null) {
			positionid = "D"+p.getGsmid();
		}
		positionid += " ";
		if(p.getDampsid() != null) {
			positionid = "A"+p.getDampsid();
		}
		aform.setPositionid(positionid);
		aform.setPositionname(p.getName());
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public void fillExpedition(AfsMountActAccessBean bean, AfsPositionListForm aform)
	throws Exception
{
    aform.setType("?");
	try {
		ExpeditionAccessBean exp = new ExpeditionAccessBean();
		exp.setInitKey_storageplace(bean.getFrom().getStorageplace());
		exp.refreshCopyHelper();
		aform.setExpedition(new Integer(exp.getStorageplace()));
		if((exp.getOrganization() != null) && (exp.getExpeditor() == null)) {
			aform.setProvider(new Integer(exp.getOrganization().getOrganization()));
			aform.setProvidername(exp.getOrganization().getName());
			aform.setInsuranseMan(bean.getInsuranseMan());
			aform.setWorker(null);
			aform.setWorkername(null);
			aform.setWorkertitle(null);
			aform.setType("P");
		} else
		if((exp.getOrganization() == null) && (exp.getExpeditor() != null)) {
			aform.setProvider(null);
			aform.setProvidername(null);
			aform.setInsuranseMan("");
			aform.setWorker(new Integer(exp.getExpeditor().getWorker()));
			aform.setWorkername(exp.getExpeditor().getMan().getFullName());
			aform.setWorkertitle(exp.getExpeditor().getPosition().getName());
			aform.setType("W");
		}
	} catch(Exception e) {
	}	
}
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.persistence.AfsMountPosAccessBean";
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.INVENTORY, APPStates.AFSPOSLIST);
	AfsPositionListForm aform = (AfsPositionListForm)form;
    aform.setReadonly(Boolean.TRUE);
	if(aform.getDocument() != null) {
		try {
			AfsMountActAccessBean bean = new AfsMountActAccessBean();
			bean.setInitKey_document(aform.getDocument().intValue());
			bean.refreshCopyHelper();
			aform.setBlanknumber(bean.getBlanknumber());
			aform.setBlankindex(bean.getBlankindex());
			aform.setBlankdate(bean.getBlankdate());
			aform.setOwner(new Integer(bean.getOwner().getOrganization()));
			aform.setOwnername(bean.getOwner().getName());
			fillComplect(bean,aform);
			fillExpedition(bean,aform);
			if("1".equals(bean.getDocumentState())) {
				aform.setReadonly(Boolean.FALSE);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    super.perform(mapping, form, request, response);
    return mapping.findForward("main");
}
}
