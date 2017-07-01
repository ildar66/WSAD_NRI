package com.hps.july.inventory.formbean;

/**
 * Форма выбора видов оборудования попадающих в отчёт "Наличие оборудования"
 */
public class Report1rtLookupListForm extends com.hps.july.web.util.BrowseForm {
	private int[] selectedType;
public Report1rtLookupListForm() {
	this.setFinderMethodName( "findAll" );
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
public String getResultString() {
	StringBuffer sb = new StringBuffer();
	for(int i = 0; i < selectedType.length; i++) {
		if(i > 0) sb.append(',');
		sb.append(selectedType[i]);
	}
	return sb.toString();
}
public String getResultString(String promptName) { // suppose to be "prompt11"
	StringBuffer sb = new StringBuffer();
	if(selectedType != null) {
		for(int i = 0; i < selectedType.length; i++) {
			if(i > 0) {
				sb.append('&');
			}
			sb.append(promptName);
			sb.append(' ');
			sb.append(selectedType[i]);
		}
	}
	return sb.toString();
}
public synchronized int[] getSelectedType() {
	if(selectedType != null) {
/*
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < selectedType.length; i++) {
			if(i > 0) sb.append(',');
			sb.append(selectedType[i]);
		}
		System.out.println("G SelectedTypes:["+sb.toString()+"]");
*/
		return selectedType;
	} else {
		return new int[] {};
	}
}
public synchronized void setSelectedType(int[] newSelectedType) {
	selectedType = newSelectedType;
	if(newSelectedType == null) {
		selectedType = new int[] {};
	}
/*
	StringBuffer sb = new StringBuffer();
	for(int i = 0; i < selectedType.length; i++) {
		if(i > 0) sb.append(',');
		sb.append(selectedType[i]);
	}
	System.out.println("setSelectedTypes:["+sb.toString()+"]");
*/
}
}
