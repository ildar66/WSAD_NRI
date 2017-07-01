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

/**
 * Обработчик списка документов "Акты монтажа блоков на позиции"
 */
public class ShowAssactBListAction
	extends BrowseAction
{
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState( request, Applications.INVENTORY, APPStates.ASSBLIST );
		AssactBListForm aform = (AssactBListForm)form;
		if(aform.getPosition() != null) {
			try {
				PositionAccessBean bean = new PositionAccessBean();
				bean.setInitKey_storageplace(aform.getPosition().intValue());
				bean.refreshCopyHelper();
				aform.setPositionname(bean.getName());
				aform.setPositionid("");
				if(bean.getGsmid() != null) {
					aform.setPositionid("D"+bean.getGsmid()+" ");
				}
				if(bean.getDampsid() != null) {
					aform.setPositionid(aform.getPositionid()+"A"+bean.getDampsid()+" ");
				}
				aform.setPosition(new Integer(bean.getStorageplace()));
			} catch(Exception e) {
			}
		}
		super.perform( mapping, form, request, response );
		return mapping.findForward( "main" );
	}
}
