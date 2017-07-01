package com.hps.july.dictionary.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.cdbc.lib.*;
/**
* Insert the type's description here.
* Creation date: (18.10.2005 12:04:01)
* @author: Shafigullin Ildar
*/
public class PersonLookupListForm extends PersonListForm {
	private java.lang.String formname;
	private java.lang.String fieldnames;
/**
 * PersonLookupListForm constructor comment.
 */
public PersonLookupListForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2005 17:31:14)
 * @return java.lang.String
 */
public java.lang.String getFieldnames() {
	return fieldnames;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2005 17:31:01)
 * @return java.lang.String
 */
public java.lang.String getFormname() {
	return formname;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.PERSON_LOOKUP_LIST);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2005 17:31:14)
 * @param newFieldnames java.lang.String
 */
public void setFieldnames(java.lang.String newFieldnames) {
	fieldnames = newFieldnames;
}
/**
 * Insert the method's description here.
 * Creation date: (18.10.2005 17:31:01)
 * @param newFormname java.lang.String
 */
public void setFormname(java.lang.String newFormname) {
	formname = newFormname;
}
}
