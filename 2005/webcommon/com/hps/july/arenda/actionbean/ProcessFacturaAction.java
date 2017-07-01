package com.hps.july.arenda.actionbean;

import com.hps.july.arenda.cdbcobjects.CDBC_SchetFact_Object;
import com.hps.july.arenda.formbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.hps.july.web.util.*;
import com.hps.july.persistence.OperatorObject;
import com.hps.july.util.*;

/**
 * Действие с фактурой.
 * Creation date: (04.11.2003 10:58:11)
 * @author: Dmitry Dneprov
 */
public class ProcessFacturaAction extends com.hps.july.web.util.AbstractProcessAction {
	public ActionForward processInsert(
		ActionMapping mapping,
		HttpServletRequest request,
		ActionErrors errors,
		EditForm editForm)
		throws Exception {
		if (editForm instanceof FacturaForm) {
			FacturaForm f = (FacturaForm) editForm;
			//System.out.println("ProcessFacturaAction: BEFORE VALIDATE");	
			//	editForm.validateValues(errors);
			System.out.println("ProcessFacturaAction: BEFORE CREATE FACTURA");
			Integer operatorCode = OperatorObject.getOperatorCode(request.getRemoteUser());
			f.createFactura(errors, operatorCode);
			System.out.println("ProcessFacturaAction: AFTER CREATE FACTURA");

			// Forward to Edit acton of the form	
			ActionForward listSF = mapping.findForward("listSF");
			ActionForward ret =
				new ActionForward(
					listSF.getPath() + "&idPosSchetFakt=" + f.getIdPosSchetFakt() + "&idContract=" + f.getIdContract(),
					true);
			return ret;
		} else {
			super.processInsert(mapping, request, errors, editForm);
			return mapping.findForward("success");
		}
		/*
			super.processInsert( mapping, request, errors, editForm);
			AbstractEntityAccessBean bean = null;
			editForm.validateValues(errors);
			bean = editForm.constructBean( request );
		//System.out.println("AbstractProcessAction: BEFORE COPY PROPERTIES");
			BeanUtils.copyProperties( bean, editForm ); 
		//System.out.println("AbstractProcessAction: AFTER COPY PROPERTIES");
			editForm.beforeUpdate( bean, request );
			bean.commitCopyHelper(); 
			editForm.afterUpdate( bean, request );
		*/
	}
	public ActionForward processUpdate(
		ActionMapping mapping,
		HttpServletRequest request,
		ActionErrors errors,
		EditForm editForm)
		throws Exception {
		super.processUpdate(mapping, request, errors, editForm);
		return mapping.findForward("success");
		/*
				AbstractEntityAccessBean bean = null;
			editForm.validateValues(errors);
		    bean = editForm.getDataBean(request);
		    BeanUtils.copyProperties( bean, editForm ); 
		    editForm.beforeUpdate( bean, request );
		    bean.commitCopyHelper();
		    editForm.afterUpdate( bean, request );
		  	return null;
		*/
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.AbstractProcessAction#processDelete(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors, com.hps.july.web.util.EditForm)
	 */
	public ActionForward processDelete(
		ActionMapping mapping,
		HttpServletRequest request,
		ActionErrors errors,
		EditForm editForm)
		throws Exception {
		if (editForm instanceof FacturaMutactForm) {
			FacturaMutactForm fmForm = (FacturaMutactForm) editForm;
			//System.out.println("ProcessFacturaAction: BEFORE VALIDATE");	
			//	editForm.validateValues(errors);
			System.out.println("ProcessFacturaAction: BEFORE DELETE FACTURA IdSchetFakt=" + fmForm.getIdSchetFakt());
			//Integer operatorCode = OperatorObject.getOperatorCode(request.getRemoteUser());
			String retStr = CDBC_SchetFact_Object.delete(new Integer(fmForm.getIdSchetFakt()));
			if(retStr != null){
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", retStr));
				System.out.println("ProcessFacturaAction ErrorTxt: " + retStr);
				throw new ValidationException();
			}
			System.out.println("ProcessFacturaAction: AFTER DELETE FACTURA");

			return mapping.findForward("success");
		} else {
			return super.processDelete(mapping, request, errors, editForm);
		}
	}

}
