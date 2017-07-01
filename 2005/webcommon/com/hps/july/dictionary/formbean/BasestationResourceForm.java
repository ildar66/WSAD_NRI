package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;

/**
 * ‘орма редактировани€ оборудовани€ базовых станций из списка оборудовани€
 */
public class BasestationResourceForm extends BasestationForm {
public int getState() {
	return com.hps.july.dictionary.APPStates.BASESTATION_RES_EDIT;
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
//	super.initRecord(request);
	setName(BASE_STAND_DEFAULT_NAME); // "Ѕазова€ станци€ GSM/DCS");
	setActive(Boolean.TRUE);
	setComplect(Boolean.FALSE);
	setNode(Boolean.FALSE);
	ResourceListForm aform = (ResourceListForm)request.getSession().getAttribute( "ResourceListForm" );
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
}
}
