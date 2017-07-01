package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;

/**
 * Форма редактирования параметров кабелей базовых станций из списка оборудования
 */
public class CableResourceWNForm extends CableForm {
public int getState() {
	return com.hps.july.dictionary.APPStates.CABLE_RES_EDIT_WN;
}
public void initRecord(HttpServletRequest request)
	throws Exception
{
	ResourceListForm aform = (ResourceListForm)request.getSession().getAttribute( "ResourceListForm" );
	setName("Кабель базовой станции");
	setComplect(Boolean.FALSE);
	setNode(Boolean.FALSE);
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
