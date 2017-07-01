package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма добавления/удаления организации в группу
 * (вход из меню компаний)
 */
public class OrggroupFormC extends AbstractOrggroupForm {
/**
 * Insert the method's description here.
 * Creation date: (13.06.2002 17:28:02)
 * @return java.lang.String
 */
public java.lang.String getFormName() {
	return "OrggroupListCForm";
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITORGGC;
}
}
