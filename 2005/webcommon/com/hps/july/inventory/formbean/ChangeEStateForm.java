package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.inventory.sessionbean.*;

/**
 * Форма изменения состояния документа "Акт замены при ремонте"
 */
public class ChangeEStateForm
	extends AbstractDocumentStateForm
{
public ChangeEStateForm() {
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHEST;
}
}
