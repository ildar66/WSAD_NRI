package com.hps.july.arenda.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
/**
 * Form-Bean.
 * канал "состояний"(лист)
 * Creation date: (20.07.2002 13:14:54)
 * @author: Sergey Gourov
 */
public class ChannelStateForm extends StateForm {
/**
 * Insert the method's description here.
 * Creation date: (20.07.2002 13:14:54)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.STATE_CHANNELARENDA_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	super.validateValues(errors);
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
