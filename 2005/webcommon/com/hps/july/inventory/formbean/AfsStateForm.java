package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.inventory.sessionbean.*;

/**
 * Форма изменения состояния акта монтажа АФС.
 */
public class AfsStateForm extends AbstractDocumentStateForm {
	private Boolean askBeforeCalc = Boolean.FALSE;
	private Boolean askBeforeUndo = Boolean.FALSE;
	private Boolean removeUserChanges = Boolean.TRUE;
public AfsStateForm() {
	super();
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	try {
		if(removeUserChanges == null) {
			removeUserChanges = Boolean.TRUE;
		}
		ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
		if("1".equals(getOldDocumentState()) && "2".equals(getDocumentState())) {
//System.out.println("AFS STATE: Call processor.process("+getDoc()+","+removeUserChanges+")");
			processor.processDocument(new Integer(getDoc()),removeUserChanges.booleanValue());
		} else
		if("2".equals(getOldDocumentState()) && "1".equals(getDocumentState())) {
//System.out.println("AFS STATE: Call processor.cancel("+getDoc()+","+removeUserChanges+")");
			processor.cancelDocument(new Integer(getDoc()),removeUserChanges.booleanValue());
		}
	} catch(Exception e) {
		setDocumentState(getOldDocumentState());
		throw e;
	}
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	try {
		ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
//System.out.println("AFS STATE: call check:"+getDoc());
		boolean b = processor.checkAddInfoModification(new Integer(getDoc()));
		if("1".equals(getOldDocumentState())) {
			askBeforeCalc = new Boolean(b);
			askBeforeUndo = Boolean.FALSE;
		} else
		if("2".equals(getOldDocumentState())) {
			askBeforeCalc = Boolean.FALSE;
			askBeforeUndo = new Boolean(b);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public java.lang.Boolean getAskBeforeCalc() {
	return askBeforeCalc;
}
public java.lang.Boolean getAskBeforeUndo() {
	return askBeforeUndo;
}
public java.lang.Boolean getRemoveUserChanges() {
	return removeUserChanges;
}
public int getState() {
	return com.hps.july.inventory.APPStates.AFSSTATE;
}
public void setAskBeforeCalc(java.lang.Boolean newAskBeforeCalc) {
	askBeforeCalc = newAskBeforeCalc;
}
public void setAskBeforeUndo(java.lang.Boolean newAskBeforeUndo) {
	askBeforeUndo = newAskBeforeUndo;
}
public void setRemoveUserChanges(java.lang.Boolean newRemoveUserChanges) {
	removeUserChanges = newRemoveUserChanges;
}
}
