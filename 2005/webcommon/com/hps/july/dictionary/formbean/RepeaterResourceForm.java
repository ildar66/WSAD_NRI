package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;

/**
 * ‘орма редактировани€ оборудовани€ репитера
 */
public class RepeaterResourceForm extends RepeaterForm {
	
    public int getState() {
        return com.hps.july.dictionary.APPStates.REPEATER_RES_EDIT;
    }
public void initRecord(HttpServletRequest request) {
	ResourceListForm aform = (ResourceListForm) request.getSession().getAttribute("ResourceListForm");
	try {
		if (aform != null) {
			if(aform.getResourcetype().getInteger() != null) {
				setResourcetype(aform.getResourcetype().getInteger().intValue());
			} else {
				setResourcetype(0);
			}
			setResourcetypename(aform.getResourcetypename());
			if(aform.getResourcesubtype().getInteger() != null) {
				setResourcesubtype(aform.getResourcesubtype().getInteger().intValue());
			} else {
				setResourcesubtype(0);
			}
			setResourcesubtypename(aform.getResourcesubtypename());
		} else {
				setResourcetype(0);
				setResourcesubtype(0);
				setResourcesubtypename("");
		}
		setActive(Boolean.TRUE);
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
}
