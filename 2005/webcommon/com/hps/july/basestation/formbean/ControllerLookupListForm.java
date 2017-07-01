package com.hps.july.basestation.formbean;

/**
 * Форма выбора контроллера
 */
public class ControllerLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
public ControllerLookupListForm() {
	this.setFinderMethodName( "findControllerLookup" );
}
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.basestation.valueobject.ControllerModel";
	return "com.hps.july.cdbc.objects.CDBCEquipmentObject";
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { Boolean.FALSE, new Integer(0), new Integer(3) };
}
}
