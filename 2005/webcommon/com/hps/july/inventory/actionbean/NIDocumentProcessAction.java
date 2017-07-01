package com.hps.july.inventory.actionbean;

import java.lang.reflect.Method;
import com.hps.july.inventory.formbean.*;
import com.hps.july.persistence.*;
import com.hps.july.inventory.sessionbean.*;
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
import com.hps.july.cdbc.objects.CDBCInventoryDocumentError;
import com.hps.july.cdbc.objects.CDBCStoragecardsObject;

/**
 * Обработчик документов нового типа. Так же используется для смены состояний
 * Используется как для обычных документов так и для "Актов замены/модернизации"
 * Вызывает ProcessorFacade и обрабатывает полученные ошибки
 */
public class NIDocumentProcessAction extends NIProcessAction {
	

/*
	private static String[] errornames = new String[] {
		"0","BAD_AGREGATION", "INVENTARIZATION_BEFORE", "NOTENOUGHQTY", "CARD_CLOSED",
		"NOT_THE_SAME_OWNER", "NOT_THE_SAME_STATE", "NO_SUCH_PARTY", "NOT_SUCH_PRODUCT",
		"UNKNOWN_POLICY", "LOST_AGRAGATE", "NO_CARD", "NOT_IN_STORAGE", "CARD_ALREADY_EXISTS",
		"POSITION_HIDDEN", "NOT_THE_SAME_RESOURCE", "NOT_THE_SAME_PRICE", "CARD_IS_BOXED",
		"CARD_ALREADY_BOUND", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
	};
*/
	// Storage Source: false - from, true - to
	private static boolean[] storagesrc = new boolean[] {
		false, // InWayBill
		false, // InternalWayBill
		false, // 
		false,
		false,
		false,
		false,
		false,
		false,
		false,
		false,
		false
	};
/*
		"W",   // doctype = W & to.storagetype is storage | 
		"TS",  // doctype = T & to.storagetype is storage
		"NS",  // doctype = N & to.storagetype is storage
		"O",   // doctype = O & from.storagetype
		"IS",  // doctype = I & to.storagetype is storage
		
		"AAS", // doctype = A & assacttype = A & to.storagetype is storage
		"ADS", // doctype = A & assacttype = D & to.storagetype is storage
		"P",   // doctype = P & from.storageplace is storage
		"HS",  // doctype = H & from.storagetype is storage
		"TP",  // doctype = T & to.storagetype is equipment
		
		"NP",  // doctype = N & from.storagetype is equipment
		"AAP", // doctype = A & assacttype = A & to.storagetype is equipment
		"ADP", // doctype = A & assacttype = D & to.storagetype is equipment
		"IP",  // doctype = I & from.storagetype is equipment
		"HP"   // doctype = H & from.storagetype is equipment
	};
*/
	public static boolean getDocumentSourceStorage(DocumentAccessBean bean) {
		boolean r = false;
		String type;
		try {
			bean.refreshCopyHelper();
			if(bean.getEJBRef() instanceof InwayBill) {
				// r = false;
			} else
			if(bean.getEJBRef() instanceof InternalWayBill) {
				EJBObject o = bean.getTo().getEJBRef();
				if(o instanceof Storage) {
					type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.internalwaybill");
				} else {
					type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.internalwaybill.m");
				}
			} else
			if(bean.getEJBRef() instanceof InternalOutBill) {
				EJBObject o = bean.getFrom().getEJBRef();
				if(o instanceof Storage) {
					type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.internaloutbill");
				} else {
					type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.internaloutbill.m");
				}
			} else
			if(bean.getEJBRef() instanceof OutWayBill) {
				type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.outwaybill");
			} else
			if(bean.getEJBRef() instanceof I13nAct) {
				EJBObject o = bean.getFrom().getEJBRef();
				if(o instanceof Storage) {
					type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.i13nact.s");
				} else {
					type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.i13nact.p");
				}
			} else
			if(bean.getEJBRef() instanceof AssemblingAct) {
				AssemblingActAccessBean aa = new AssemblingActAccessBean(bean.getEJBRef());
				aa.refreshCopyHelper();
				EJBObject o = aa.getFrom().getEJBRef();
				if("A".equals(aa.getOperationType())) {
					if(o instanceof Storage) {
						type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.assemblingact.as");
					} else {
						type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.assemblingact.ap");
					}
				} else {
					if(o instanceof Storage) {
						type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.assemblingact.ds");
					} else {
						type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.assemblingact.dp");
					}
				}
			} else
			if(bean.getEJBRef() instanceof ChangeAct) {
				type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.changeact");
			} else
			if(bean.getEJBRef() instanceof FaultReport) {
				type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.faultreport");
			} else
			if(bean.getEJBRef() instanceof PayOffAct) {
				EJBObject o = bean.getFrom().getEJBRef();
				if(o instanceof Storage) {
					type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.payoffact");
				} else {
					type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.payoffinv");
				}
			} else
			if(bean.getEJBRef() instanceof SurplusAct) {
				type = NIDocumentTranslateErrors.messageRes.getMessage("label.document.surplusact");
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return r;
	}
	
	
	
	public static String getSpname(StoragePlaceAccessBean sp) throws java.lang.Exception {
		int sptype = StorageplaceUtils.getStorageplaceType(sp);
		String spname = StorageplaceUtils.getStorageplaceNameLite(sp);
		switch(sptype) {
		case StorageplaceUtils.TYPE_EQUIPMENT:
		case StorageplaceUtils.TYPE_POSITION:
			spname = "на позиции \""+spname+"\"";
			break;
		case StorageplaceUtils.TYPE_STORAGE:
			spname = "на складе \""+spname+"\"";
			break;
		case StorageplaceUtils.TYPE_EXPEDITOR:
			spname = "у сотрудника "+spname;
			break;
		case StorageplaceUtils.TYPE_ORGANIZATION:
			spname = "у подрядчика \""+spname+"\"";
			break;
		default:
			spname = "на \""+spname+"\"";
		}
		return spname;
	}

	
	public static void log(Exception e) {
		//System.out.println("DPA>>> EXCEPTION: "+e.getClass().getName());
	}

	
	public ActionForward processException(ActionErrors errors, Exception e, EditForm editForm, 
			AbstractEntityAccessBean bean, ActionForward retVal) {
		DocumentProcessingException dpe = DocumentProcessingExceptionChecker.check(e);
		if(dpe != null) {
			translateErrors(editForm, dpe, errors);
		} else {
			CurrencySumProcessingError cse = CurrencySumProcessingExceptionChecker.check(e);
			if(cse != null){
				NIDocumentTranslateErrors.translateCurrencySumErrors(cse,errors);
			} else {
				e.printStackTrace(System.out);
			}
		}
		return retVal;
	}

	public ActionForward processInsert( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
		ActionForward fwd = super.processInsert(mapping, request, errors, editForm);
		if(errors.empty()) {
			fwd = mapping.findForward("edit");
			editForm.setAction("Edit");
		}
		return fwd;
	}
	
		
	public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, 
			ActionErrors errors, EditForm editForm)	throws Exception {
		ActionForward fwd = null;
	
		Class formclass = editForm.getClass();
			
			try {			
				String dstate = (String)(formclass.getMethod( "getDState", null ).invoke( editForm, null ));			
				String pstate = (String)(formclass.getMethod( "getProcessState", null ).invoke( editForm, null ));
				
				if(!"1".equals(dstate) && !"C".equals(pstate)){
					return null;
				}	
				
			} catch( NoSuchMethodException e ) {
				e.printStackTrace(System.out);
			}
		
	
		
		//-----
		if(editForm instanceof DocumentForm) {
			DocumentForm df = (DocumentForm)editForm;
			if(df.getProcessState() != null) {
				if("P".equals(df.getProcessState()) || "PP".equals(df.getProcessState())) {
					fwd = mapping.findForward("edit");
				}
				if("C".equals(df.getProcessState()) || "CC".equals(df.getProcessState())) {
					fwd = mapping.findForward("edit");
					df.afterUpdate(df.getDataBean(request),request);
					return fwd;
				}
			}
		}
		ActionForward ofwd = super.processUpdate(mapping, request, errors, editForm);
		if(fwd == null) {
			return ofwd;
		} else {
			return fwd;
		}
	}
	
	

	public void translateErrors(EditForm form, DocumentProcessingException x, ActionErrors errors) {
		// Определим код документа
		Integer docCode = null;
	
		try {
			docCode = (Integer)PropertyUtils.getProperty(form,"doc");
		} catch(Throwable t) {}
		if (docCode == null) {
			try {
				docCode = (Integer)PropertyUtils.getProperty(form,"document");
			} catch(Throwable t) {}
		}
		int errorcode = x.getErrorCode();
		if (errorcode == 7) {
			if(form != null) {
				try {
					PropertyUtils.setProperty(form,"warnProc",Boolean.TRUE);
				} catch(Throwable t) {
					t.printStackTrace(System.out);
				}
			}
		}
		NIDocumentTranslateErrors.translateDocErrors(docCode, x, errors);	
	}

	/**
	 * translateDocumentProcessingErrors
	 * return isWarnPross
	 * 
	 * TODO move to JulyNIDocumentTranslateErrorsTool
	 */
	public boolean translateDocumentProcessingErrors(ActionErrors errors, 
			DocumentProcessingException documentProcessingException, Integer documentId){
				return NIDocumentTranslateErrors.translateDocumentProcessingErrors(errors, documentProcessingException, documentId);
			}


	public static ActionError translateProcessingErrors(int doctype, ProcessingPositionError er) {
		return NIDocumentTranslateErrors.translateProcessingErrors(null, doctype, er);
	}
	
}
