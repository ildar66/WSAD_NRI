package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;

/**
 * Форма редактирования оборудования антенн из списка оборудования
 */
public class AntenaResourceWNForm extends AntenaForm {
public int getState() {
	return com.hps.july.dictionary.APPStates.ANTENA_RES_EDIT_WN;
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
//	super.initRecord(request);
	setActive(Boolean.TRUE);
	setName("Антенна");
	setComplect(Boolean.FALSE);
	setCountpolicy("S");
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
	setActive(Boolean.TRUE);
}
}
