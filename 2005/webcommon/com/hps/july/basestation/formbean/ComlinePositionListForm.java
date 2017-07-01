package com.hps.july.basestation.formbean;

import com.hps.july.basestation.*;
import com.hps.july.basestation.valueobject.*;

/**
 * Форма списка линий связи включающих указанную позицию
 */
public class ComlinePositionListForm
	extends ComlineListForm
{
	private PositionModel posmodel;
public ComlinePositionListForm() {
	super();
	posmodel = new PositionModel();
}
public String actionName() {
	return "ShowComlinePositionList.do";
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCComlinesObject";
//	return "com.hps.july.basestation.valueobject.ComlineObject";
}
public java.lang.Object[] getFilterParams()
{
	return new Object[] { 
		(!posmodel.isEmpty())?posmodel.getKey():new Integer(0),
		getIsAdmin(),
		getUsername()
	};
}
public java.lang.String getFinderMethodName() {
	return "findComlinePositionList";
}
public String getPoscode() {
	return posmodel.getKeyFrm();
}
public String getPositionFullname()
{
	return posmodel.getFullName();
}
public int getState() {
	return APPStates.ComlinePositionListForm;
}
public void setPoscode(String poscode)
{
	posmodel.setKeyFrm(poscode);
	posmodel.refresh();
}
}
