package com.hps.july.inventory.formbean;

public class CardRLookupListForm extends CardLookupListForm {
public CardRLookupListForm() {
	super();
	this.setFinderMethodName( "findRealStorageCards" );
}
public int getAppState() {
	return com.hps.july.inventory.APPStates.CRDRLOOKUP;
}
public java.lang.String getFinderMethodName() {
	return "findRealStorageCards";
}
}
