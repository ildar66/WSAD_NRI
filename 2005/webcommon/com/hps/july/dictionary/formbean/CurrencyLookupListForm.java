package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * ����� ������ ������
 */
public class CurrencyLookupListForm extends com.hps.july.web.util.BrowseForm {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public CurrencyLookupListForm() {
	this.setFinderMethodName( "findAllOrderByNameAsc" );
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
}
