package com.hps.july.inventory.actionbean;

import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.inventory.sessionbean.*;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.*;
import com.hps.july.inventory.valueobject.*;

/**
 * Класс массового обсчёта документов.
 * Запускается MassCalcAction и последовательно обрабатывает документы.
 */
public class MassCalcThread implements Runnable {
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
//	private boolean[] docs;
//	private static String[] doct =
//		{ "W", "TS", "NS", "O", "IS", "AAS", "ADS", "P", "HS", "TP", "NP", "AAP", "ADP", "IP", "HP" };
	private boolean finished;
	private Vector documents;
	private Vector results;
	private int docsProcessed;
	private int docsError;
	private boolean detailed;
	private boolean running;
/*
	DocumentBean.type:
	
	1	C - contract
	2	I - inventarization
	3	W - inwaybills
	4	P - payoffact
	5	S - surplusact
	6	N - internaloutbill
	7	A - assemblingact
	8	H - changeact
	9	T - internalwaybill
	10	O - outwaybill

	doct[ 0] = "W";   // externalwaybill: doctype = W
	doct[ 1] = "TS";  // internalwaybill: doctype = T & to.storagetype is storage
	doct[ 2] = "NS";  // internaloutbill: doctype = N & to.storagetype is storage
	doct[ 3] = "O";   // outwaybill: doctype = O
	doct[ 4] = "IS";  // doctype = I & from.storagetype is storage
	doct[ 5] = "AAS"; // doctype = A & assacttype = A & to.storagetype is storage
	doct[ 6] = "ADS"; // doctype = A & assacttype = D & to.storagetype is storage
	doct[ 7] = "P";   // payoffact: doctype = P
	doct[ 8] = "HS";  // cahngesact: doctype = H & from.storagetype is storage
	doct[ 9] = "TP";  // internalwaybill: doctype = T & to.storagetype is equipment
	doct[10] = "NP";  // internaloutbill: doctype = N & to.storagetype is equipment
	doct[11] = "AAP"; // assact: doctype = A & assacttype = A & to.storagetype is equipment
	doct[12] = "ADP"; // dassact: doctype = A & assacttype = D & to.storagetype is equipment
	doct[13] = "IP";  // invpact: doctype = I & from.storagetype is equipment
	doct[14] = "HP";  // changepact: doctype = H & from.storagetype is equipment

*/
public MassCalcThread() {
	super();
	finished = false;
	documents = new Vector();
	results = new Vector();
	docsProcessed = 0;
	docsError = 0;
}
public void finish() {
	running = false;
}
/**
 * 
 * @return int
 */
public int getDocsError() {
	return docsError;
}
/**
 * 
 * @return int
 */
public int getDocsProcessed() {
	return docsProcessed;
}
/**
 * 
 * @return java.util.Vector
 */
public java.util.Vector getDocuments() {
	return documents;
}
/**
 * 
 * @return java.util.Vector
 */
public java.util.Vector getResults() {
	return results;
}
/**
 * 
 * @return boolean
 */
public boolean isDetailed() {
	return detailed;
}
public boolean isFinished() {
	return finished;
}
public void log(Exception e) {
	System.out.println(">>MASSTHREAD> EXCEPTION:"+e.getClass().getName());
}
public void processException(Exception re, MassCalcResultItem ri)
{
	ActionErrors errors = new ActionErrors();
	DocumentProcessingException dpe = DocumentProcessingExceptionChecker.check(re);
	if(dpe != null) {
		translateErrors(dpe, errors);
	} else {
		CurrencySumProcessingError cse = CurrencySumProcessingExceptionChecker.check(re);
		if(cse != null){
			DocumentProcessAction.translateCurrencySumErrors(cse,errors);
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.masscalc.unknown",re.getMessage()));
		}
	}
	ri.setState(2); // Processed but has errors (B-|)
	ri.setErrors(errors);
}
public void run()
{
	MassCalcResultItem r;
	ProcessorFacadeAccessBean pf = new ProcessorFacadeAccessBean();
	ActionErrors aerr = new ActionErrors();
	try {
		if(documents != null && !documents.isEmpty()) {
			Enumeration en = documents.elements();
			running = true;
			while(en.hasMoreElements() && running) {
				r = (MassCalcResultItem)en.nextElement();
				try {
					pf.processDocument(new Integer(r.getDocId()));
					r.setState(1); // It's cool! We did it! Yeehaaa!!!
					if(detailed) results.add(r);
				} catch(Exception re) {
					processException(re,r); // Shit happens! We should report it. Damn :((
					r.setState(2);
					results.add(r);
					docsError++;
				}
				/*
				Thread.currentThread().sleep(2167);
				r.setState(1);
				if((System.currentTimeMillis() % 100) > 80) {
					docsError++;
					r.setState(2);
					aerr = new ActionErrors();
					aerr.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.currencyprocessing.bad_base_currency"));
					aerr.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.currencyprocessing.bad_base_currency"));
					aerr.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.currencyprocessing.bad_base_currency"));
					r.setErrors(aerr);
					results.add(r);
				} else {
					if(detailed) results.add(r);
				}
				*/
				docsProcessed++;
				Thread.sleep(12);
			}
		}
	} catch(Exception e) {
		log(e);
	}
	finished = true;
}
/**
 * 
 * @param newDetailed boolean
 */
public void setDetailed(boolean newDetailed) {
	detailed = newDetailed;
}
/**
 * 
 * @param newDocsError int
 */
public void setDocsError(int newDocsError) {
	docsError = newDocsError;
}
/**
 * 
 * @param newDocsProcessed int
 */
public void setDocsProcessed(int newDocsProcessed) {
	docsProcessed = newDocsProcessed;
}
/**
 * 
 * @param newDocuments java.util.Vector
 */
public void setDocuments(java.util.Vector newDocuments) {
	documents = newDocuments;
}
/**
 * 
 * @param newResults java.util.Vector
 */
public void setResults(java.util.Vector newResults) {
	results = newResults;
}
public void translateErrors(DocumentProcessingException x, ActionErrors errors)
{
	ActionError e;
	int errorcode = x.getErrorCode();
	switch(errorcode) {
	case 7:
	case 0:
		ArrayList list = x.getPositionErrors();
		if(list == null)
			return;
		java.util.Iterator it = list.iterator();
		if(it.hasNext()) {
			errors.clear();
		}
		while(it.hasNext()) {
			Object o = it.next();
			if(!(o instanceof ProcessingPositionError)) {
				continue;
			}
			ProcessingPositionError er = (ProcessingPositionError)o;
			e = DocumentProcessAction.translateProcessingErrors(er);
			errors.add(ActionErrors.GLOBAL_ERROR, e);
		}
		break;
	case 1:
		errors.clear();
		e = new ActionError("error.documentprocessing.instate");
		errors.add(ActionErrors.GLOBAL_ERROR, e);
		break;
	case 2:
		errors.clear();
		String otherdoc = "?";
		try {
			DocumentAccessBean d = new DocumentAccessBean();
			d.setInitKey_document(x.getOtherDocument().intValue());
			d.refreshCopyHelper();
			otherdoc = DocumentProcessAction.getDocumentTypeName(d);
			otherdoc += " № " + d.getBlankindex();
			if(d.getBlanknumber() != null) {
				otherdoc += d.getBlanknumber();
			}
			otherdoc += " от "+format.format(d.getBlankdate());
		} catch(Exception ex) {
			log(ex);
		}
		e = new ActionError("error.documentprocessing.otherdocsexist",otherdoc);
		errors.add(ActionErrors.GLOBAL_ERROR, e);
		break;
	case 3:
		CurrencySumProcessingError err = new CurrencySumProcessingError();
		err.setErrorCode(x.getCurErrorCode());
		err.setCurDate(x.getCurDate());
		err.setCurrency(x.getCurrency());
		err.setRateType(x.getRateType());
		errors.clear();
		DocumentProcessAction.translateCurrencySumErrors(err,errors);
		break;
	case 4:
		errors.clear();
		e = new ActionError("error.documentprocessing.bigprice");
		errors.add(ActionErrors.GLOBAL_ERROR, e);
		break;
	case 5:
		errors.clear();
		e = new ActionError(x.getErrorMessage());
		errors.add(ActionErrors.GLOBAL_ERROR, e);
		break;
	case 6:
		errors.clear();
		e = new ActionError(x.getErrorMessage());
		errors.add(ActionErrors.GLOBAL_ERROR, e);
		break;
	default:
		errors.clear();
		e = new ActionError("error.documentprocessing.unknowndocerror");
		errors.add(ActionErrors.GLOBAL_ERROR, e);
		break;
	}
}
}
