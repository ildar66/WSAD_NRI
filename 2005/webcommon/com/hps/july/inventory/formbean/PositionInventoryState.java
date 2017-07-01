package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import java.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма изменения состояния документа "Акт инвентаризации на позиции"
 */
public class PositionInventoryState
	extends AbstractDocumentStateForm
{
public PositionInventoryState() {
	super();
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITINVS;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	super.validateValues(errors);
	// check docposition with serial policy
	if("1".equals(getOldDocumentState())) {
	try {
		DocumentPositionAccessBean df = new DocumentPositionAccessBean();
		Enumeration en = 
			df.findDocPositionsByDocAndPolicyOrderByOrderAsc(new Integer(getDoc()),"S");
		int cnt = 0;
//System.out.println("EN: "+en.hasMoreElements());
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
