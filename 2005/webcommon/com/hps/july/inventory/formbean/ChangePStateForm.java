package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.inventory.sessionbean.*;

/**
 * Форма изменения состояния документа "Акт замены/модернизации на позиции"
 */
public class ChangePStateForm
	extends AbstractDocumentStateForm
{
public ChangePStateForm() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHPST;
}
}
