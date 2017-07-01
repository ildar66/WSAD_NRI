package com.hps.july.inventory.formbean;

import com.hps.july.persistence.ResourceSubTypeKey;

/**
 * ‘орма выбора набора оборудовани€ из справочника
 */
public class ResourceSetLookupListForm extends ResourceLookupListForm {
/**
 * ResourceComplectLookupListForm constructor comment.
 */
public ResourceSetLookupListForm() {
	this.setFinderMethodName( "findByQBE" );
	setSearchtype("C");
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		getIsResourcetype().booleanValue()?Boolean.TRUE:Boolean.FALSE, (getResourcesubtype() != null)?new ResourceSubTypeKey(getResourcesubtype().intValue()):new ResourceSubTypeKey(0),
		getIsSign().booleanValue()?Boolean.TRUE:Boolean.FALSE, (getSign() != null)?getSign():"",
		getIsName().booleanValue()?Boolean.TRUE:Boolean.FALSE, (getName() != null)?getName():"",
		new Integer(1)
	};
}
}
