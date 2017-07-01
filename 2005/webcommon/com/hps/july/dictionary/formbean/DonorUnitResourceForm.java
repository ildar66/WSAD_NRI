/*
 * Created on 27.12.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * Форма редактирования оборудования донорного блока репитера
 */

public class DonorUnitResourceForm extends DonorUnitForm {
	public int getState() {
		return com.hps.july.dictionary.APPStates.DONORUNIT_RES_EDIT;
	}
	public void initRecord(HttpServletRequest request)
	{
		ResourceListForm aform = (ResourceListForm)request.getSession().getAttribute( "ResourceListForm" );
		setName("Донорный блок репитера");
		setComplect(Boolean.FALSE);
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

/*
package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;

/**
 * Форма редактирования параметров кабелей базовых станций из списка оборудования
 *
public class CableResourceForm extends CableForm {
}
*/