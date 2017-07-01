package com.hps.july.inventory.formbean;

import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.inventory.sessionbean.*;

/**
 * ‘орма изменени€ состо€ни€ документа "¬нутренн€€ расходна€ накладна€"
 */
public class InternalRStateForm extends AbstractDocumentStateForm {
public InternalRStateForm() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITIORST;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	super.validateValues(errors);
System.out.println("Special validate for InternalR");
	// check docposition with serial policy
	if("1".equals(getOldDocumentState())) {
System.out.println("Special validate for InternalR...");
	try {
		DocumentPositionAccessBean df = new DocumentPositionAccessBean();
		Enumeration en = 
			df.findDocPositionsByDocAndPolicyOrderByOrderAsc(new Integer(getDoc()),"S");
		int cnt = 0;
System.out.println("EN: "+en.hasMoreElements());
		while(en.hasMoreElements()) {
			DocumentPositionAccessBean d = (DocumentPositionAccessBean)en.nextElement();
			if("S".equals(d.getResource().getCountpolicy()) && (d.getSerialnumber() == null || "".equals(d.getSerialnumber().trim()))) {
				cnt++;
			}
		}
		if(cnt > 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.state.internalr.noserial"));
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.state.docposselect"));
	}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
