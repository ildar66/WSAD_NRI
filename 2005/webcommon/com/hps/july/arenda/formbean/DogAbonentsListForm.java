package com.hps.july.arenda.formbean;

/**
 * bean-form
 * Лист абонентских договоров.
 * Creation date: (04.10.2002 10:16:45)
 * @author: Dmitry Dneprov
 */
public class DogAbonentsListForm extends com.hps.july.web.util.BrowseForm {
	private Integer order;
	private int contract;
/**
 * AbonentsListForm constructor comment.
 */
public DogAbonentsListForm() {
	super();
	setFinderMethodName("1");
	order = new Integer(1);
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2003 15:05:01)
 * @return int
 */
public int getContract() {
	return contract;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("ArendaMainEconomist");
	roles.add("ArendaEconomist");
	roles.add("administrator");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	
	try {
		order = new Integer(Integer.parseInt(super.getFinderMethodName()));
	} catch (NumberFormatException e) {
	}

	return new Object[] { new Integer(getContract()),
		order
	};
}
public String getFinderMethodName() {
	return "findByContract";
}
/**
 * Insert the method's description here.
 * Creation date: (13.11.2003 15:05:01)
 * @param newContract int
 */
public void setContract(int newContract) {
	contract = newContract;
}
}
