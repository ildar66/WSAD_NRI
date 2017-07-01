package com.hps.july.basestation.actionbean;

import com.hps.july.basestation.formbean.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;

public class ProcessFrequencyLicenceAction
	extends FormProcessAction
{
/**
 * Передает обработку добавления в форму.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processInsert( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	ActionForward af = super.processInsert(mapping,request,errors,editForm);
	FrequencyLicenceForm f = (FrequencyLicenceForm)editForm;
	if(af != null) {
		System.out.println("PFLA:FORWARD:"+af.getPath());
		return af;
	} else {
		System.out.println("PFLA:FORWARD:NULL");
		String aaction = request.getParameter("aaction");
		System.out.println("PFLA:FORWARD:aaction="+aaction);
		if(aaction != null) {
			if("addcomline".equals(aaction)) {
				af = mapping.findForward("addcomline");
				if(af != null) {
					af = new ActionForward(af.getPath()+"&file_number="+f.getFilenumber().getString(),true);
				}
			} else if("editcomline".equals(aaction)) {
				String hopscode = request.getParameter("edithops");
				af = mapping.findForward("editcomline");
				if(af != null) {
					af = new ActionForward(af.getPath()+"&hopsid="+hopscode,true);
				}
			}
		}
		return af;
	}
}
/**
 * Передает обработку обновления в форму.
 * Creation date: (28.06.2002 16:40:18)
 * @return org.apache.struts.action.ActionMapping
 */
public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
	ActionForward af = super.processUpdate(mapping,request,errors,editForm);
	FrequencyLicenceForm f = (FrequencyLicenceForm)editForm;
	if(af != null) {
		System.out.println("PFLA:FORWARD:"+af.getPath());
		return af;
	} else {
		System.out.println("PFLA:FORWARD:NULL");
		String aaction = request.getParameter("aaction");
		System.out.println("PFLA:FORWARD:aaction="+aaction);
		if(aaction != null) {
			if("addcomline".equals(aaction)) {
				af = mapping.findForward("addcomline");
				if(af != null) {
					af = new ActionForward(af.getPath()+"&file_number="+f.getFilenumber().getString(),true);
				}
			} else if("editcomline".equals(aaction)) {
				String hopscode = request.getParameter("edithops");
				af = mapping.findForward("editcomline");
				if(af != null) {
					af = new ActionForward(af.getPath()+"&hopsid="+hopscode,true);
				}
			}
		}
		return af;
	}
}
}
