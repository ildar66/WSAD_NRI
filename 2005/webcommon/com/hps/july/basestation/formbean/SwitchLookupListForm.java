package com.hps.july.basestation.formbean;

/**
 * Форма выбора коммутатора
 */
public class SwitchLookupListForm
	extends com.hps.july.web.util.BrowseForm
{
	private String type; // '1' - DAMPS, '2' - GSM/DCS
	private String constructionState; // '1' - Plan, '2' - Fact
public SwitchLookupListForm() {
	this.setFinderMethodName( "findByQBE2" );
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getConstructionState() {
	return constructionState;
}
public java.lang.Object[] getFilterParams() {
System.out.println("SWCH_LOOKUP:Type:"+type+", State:"+constructionState);
	return new Object[] {
		Boolean.FALSE, new Integer(0),
		new Boolean(hasTypeFilter()), (hasTypeFilter())?type:"",
		(constructionState == null || "".equals(constructionState))?Boolean.FALSE:Boolean.TRUE, (constructionState == null)?"":constructionState,
		new Integer(1)
	};
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
public boolean hasConstructionStateFilter() {
	return false;
}
public boolean hasTypeFilter() {
	return (type != null && !"".equals(type));
}
public void setConstructionState(java.lang.String newConstructionState) {
	constructionState = newConstructionState;
}
/**
 * 
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
