/*
 * Created on 12.09.2006
 *
 */
package com.hps.july.inventory.actionbean;

import java.util.ArrayList;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.util.MessageResources;

import com.hps.july.cdbc.objects.CDBCInventoryDocumentError;
import com.hps.july.cdbc.objects.CDBCStoragecardsObject;
import com.hps.july.inventory.sessionbean.CurrencySumProcessingError;
import com.hps.july.inventory.sessionbean.DocumentProcessingException;
import com.hps.july.inventory.sessionbean.ProcessingPositionError;
import com.hps.july.inventory.valueobject.ChangePositionValue;
import com.hps.july.persistence.ChangeActPositionAccessBean;
import com.hps.july.persistence.CurrencyAccessBean;
import com.hps.july.persistence.DocumentAccessBean;
import com.hps.july.persistence.DocumentPositionAccessBean;
import com.hps.july.persistence.FaultReportAccessBean;
import com.hps.july.persistence.I13nActAccessBean;
import com.hps.july.persistence.OrganizationAccessBean;
import com.hps.july.persistence.RateTypeAccessBean;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.persistence.StoragePlaceAccessBean;

/**
 * Document Processor error reporting tool
 * @author dima
 *
 */
public class NIDocumentTranslateErrors {

	public static int DOCTYPE_SIMPLE = 0;
	public static int DOCTYPE_CHANGE = 1;
	public static int DOCTYPE_FAULT = 2;
	public static int DOCTYPE_FKBS = 3;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	public static MessageResources messageRes = MessageResources.getMessageResources("com.hps.july.inventory.ApplicationResources");
	
	public NIDocumentTranslateErrors() {
		super();
	}
	
	public static void translateDocErrors(Integer docCode, DocumentProcessingException x, ActionErrors errors) {
		com.hps.july.cdbc.objects.CDBCInventoryDocumentError cdbcIDER;
		cdbcIDER = new com.hps.july.cdbc.objects.CDBCInventoryDocumentError();
		int doctype = DOCTYPE_SIMPLE;
		try {
			String letter = com.hps.july.cdbc.objects.CDBCDocuments.getDocumentTypeLetter(docCode.intValue());
			if("H".equals(letter)) {
				doctype = DOCTYPE_CHANGE;
			} else if("F".equals(letter)) {
				doctype = DOCTYPE_FAULT;
			} else if("G".equals(letter)) {
				doctype = DOCTYPE_FKBS;
			}
		} catch(Throwable tt) {
			// suppress
		}
		
		ActionError e;
		int errorcode = x.getErrorCode();
		System.out.println("ExceptionErrorCode=" + errorcode);
		switch(errorcode) {
		case 7:  // Warnings - user confirm
		case 0:
			ArrayList list = x.getPositionErrors();
			if(list == null)
				return;
			java.util.Iterator it = list.iterator();
			if(it.hasNext()) {
				if (errors != null)
					errors.clear();
			}
			while(it.hasNext()) {
				Object o = it.next();
				if(!(o instanceof ProcessingPositionError)) {
					continue;
				}
				ProcessingPositionError er = (ProcessingPositionError)o;
				e = translateProcessingErrors(docCode,doctype,er);
				if(!cdbcIDER.addDocumentError(docCode, new Integer(er.getPositionCode()), new Integer(er.getErrorLevel()), getErrorText(e))) {
					if (errors != null)
						errors.add(ActionErrors.GLOBAL_ERROR, e);
				}
			}
			break;
		case 1:
			if (errors != null)
				errors.clear();
			e = new ActionError("error.documentprocessing.instate");
			if(!cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		case 2:
			if (errors != null)
				errors.clear();
			String otherdoc = "?";
			try {
				DocumentAccessBean d = new DocumentAccessBean();
				d.setInitKey_document(x.getOtherDocument().intValue());
				d.refreshCopyHelper();
				otherdoc = getDocumentTypeName(d);
				otherdoc += " № " + d.getBlankindex();
				if(d.getBlanknumber() != null) {
					otherdoc += d.getBlanknumber();
				}
				otherdoc += " от "+format.format(d.getBlankdate());
			} catch(Exception ex) {
				log(ex);
			}
			e = new ActionError("error.documentprocessing.otherdocsexist",otherdoc);
			if(!cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		case 3:
			CurrencySumProcessingError err = new CurrencySumProcessingError();
			err.setErrorCode(x.getCurErrorCode());
			err.setCurDate(x.getCurDate());
			err.setCurrency(x.getCurrency());
			err.setRateType(x.getRateType());
			if (errors != null)
				errors.clear();
			translateCurrencySumErrors(err,errors);
			break;
		case 4:
			if (errors != null)
				errors.clear();
			e = new ActionError("error.documentprocessing.bigprice");
			if(!cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		case 5:
			if (errors != null)
				errors.clear();
			e = new ActionError(x.getErrorMessage());
			if(!cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		case 6:
			if (errors != null)
				errors.clear();
			e = new ActionError(x.getErrorMessage());
			if(!cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		case 31:
		case 32:
			if (errors != null)
				errors.clear();
			e = new ActionError("error.documentprocessing.configchanged");
			if(!cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		default:
			if (errors != null)
				errors.clear();
			e = new ActionError("error.documentprocessing.unknowndocerror");
			if(!cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		}
	}
	
	/**
	 * Преобразование класса ошибки в строку, содержащую расшифровку ошибки.
	 * Creation date: (24.09.2004 19:21:22)
	 * @return java.lang.String
	 * @param e org.apache.struts.action.ActionError
	 */
	public static String getErrorText(ActionError e) {
	   String  message = e.getKey();
		try {
			message = messageRes.getMessage(e.getKey(), e.getValues());
		} catch (Exception ee) {
			// Message not found
		}
		return message;
	}

	public static String getDocumentTypeName(DocumentAccessBean bean) {
		String type = messageRes.getMessage("label.document.unknown");
	
		try {
			type = com.hps.july.cdbc.objects.CDBCDocuments.getDocumentTypeName(new Integer(bean.getDocument()));
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return type;
		
	}
	
	
	public static boolean translateDocumentProcessingErrors(ActionErrors errors, 
			DocumentProcessingException documentProcessingException, Integer documentId){
		
		CDBCInventoryDocumentError cdbcIDER = new CDBCInventoryDocumentError();
		// Определим код документа
		int doctype = DOCTYPE_SIMPLE;
	
		try {
			String letter = com.hps.july.cdbc.objects.CDBCDocuments.getDocumentTypeLetter(documentId.intValue());
			if("H".equals(letter)) {
				doctype = DOCTYPE_CHANGE;
			} else if("F".equals(letter)) {
				doctype = DOCTYPE_FAULT;
			} else if("G".equals(letter)) {
				doctype = DOCTYPE_FKBS;
			}
		} catch(Throwable tt) {
			// suppress
		}
		
		boolean warnProc = false;
		
		ActionError e;
		int errorcode = documentProcessingException.getErrorCode();
		switch(errorcode) {
		case 7:
			warnProc = true;
		case 0:
			ArrayList list = documentProcessingException.getPositionErrors();
			if(list == null)
				return warnProc;
			java.util.Iterator it = list.iterator();
			if(it.hasNext()) {
				if (errors != null)
					errors.clear();
			}
			while(it.hasNext()) {
				Object o = it.next();
				if(!(o instanceof ProcessingPositionError)) {
					continue;
				}
				ProcessingPositionError er = (ProcessingPositionError)o;
				e = translateProcessingErrors(documentId,doctype,er);
				if(!cdbcIDER.addDocumentError(documentId, new Integer(er.getPositionCode()), new Integer(er.getErrorLevel()), getErrorText(e))) {
					if (errors != null)
						errors.add(ActionErrors.GLOBAL_ERROR, e);
				}
			}
			break;
		case 1:
			if (errors != null)
				errors.clear();
			e = new ActionError("error.documentprocessing.instate");
			if(!cdbcIDER.addDocumentError(documentId, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		case 2:
			if (errors != null)
				errors.clear();
			String otherdoc = "?";
			try {
				DocumentAccessBean d = new DocumentAccessBean();
				d.setInitKey_document(documentProcessingException.getOtherDocument().intValue());
				d.refreshCopyHelper();
				otherdoc = getDocumentTypeName(d);
				otherdoc += " № " + d.getBlankindex();
				if(d.getBlanknumber() != null) {
					otherdoc += d.getBlanknumber();
				}
				otherdoc += " от "+format.format(d.getBlankdate());
			} catch(Exception ex) {
				log(ex);
			}
			e = new ActionError("error.documentprocessing.otherdocsexist",otherdoc);
			if(!cdbcIDER.addDocumentError(documentId, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		case 3:
			CurrencySumProcessingError err = new CurrencySumProcessingError();
			err.setErrorCode(documentProcessingException.getCurErrorCode());
			err.setCurDate(documentProcessingException.getCurDate());
			err.setCurrency(documentProcessingException.getCurrency());
			err.setRateType(documentProcessingException.getRateType());
			if (errors != null)
				errors.clear();
			translateCurrencySumErrors(err,errors);
			break;
		case 4:
			if (errors != null)
				errors.clear();
			e = new ActionError("error.documentprocessing.bigprice");
			if(!cdbcIDER.addDocumentError(documentId, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		case 5:
			if (errors != null)
				errors.clear();
			e = new ActionError(documentProcessingException.getErrorMessage());
			if(!cdbcIDER.addDocumentError(documentId, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		case 6:
			if (errors != null)
				errors.clear();
			e = new ActionError(documentProcessingException.getErrorMessage());
			if(!cdbcIDER.addDocumentError(documentId, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		default:
			if (errors != null)
				errors.clear();
			e = new ActionError("error.documentprocessing.unknowndocerror");
			if(!cdbcIDER.addDocumentError(documentId, new Integer(0), getErrorText(e))) {
				if (errors != null)
					errors.add(ActionErrors.GLOBAL_ERROR, e);
			}
			break;
		}
		
		return warnProc;
	}
	
	public static ActionError translateProcessingErrors(Integer docCode, int doctype, ProcessingPositionError er){
		ActionError e;
		try {
			String param0,param1,param2,param3;
			String oldSer = null;
			String agrSer = null;
			String newSer = null;
			String oldRes = null;
			String agrRes = null;
			String newRes = null;
			int poscode = er.getPositionCode();
			StoragePlaceAccessBean storage = null;
			StoragePlaceAccessBean storageto = null;
	
			if(doctype == DOCTYPE_CHANGE) {
				try {
					ChangeActPositionAccessBean pos = new ChangeActPositionAccessBean();
					pos.setInitKey_code(poscode);
					pos.refreshCopyHelper();
					ChangePositionValue pv = new ChangePositionValue(pos);
					param0 = pv.getOresname()+", "+pv.getOresmodel()+". S/N:"+pv.getOldserial()+": ";
					storage = pos.getChangeAct().getFrom();
				} catch(Exception exc) {
					log(exc);
					param0 = "";
				}
			} else if(doctype == DOCTYPE_FAULT) {
				try {
					FaultReportAccessBean fa = new FaultReportAccessBean();
					fa.setInitKey_document(docCode.intValue());
					fa.refreshCopyHelper();
					oldSer = fa.getOldserial();
					agrSer = fa.getAgregateserial();
					newSer = fa.getNewserial();
					storage = fa.getFrom();
					storageto = fa.getTo();
	
					if(fa.getOldresource()!=null){
						ResourceAccessBean bean = new ResourceAccessBean();
						bean.setInitKey_resource(fa.getOldresource().intValue());
						bean.refreshCopyHelper();
						oldRes = bean.getModel();
					}else oldRes = "";
	
					if(fa.getAgregateresource()!=null){
						ResourceAccessBean bean2 = new ResourceAccessBean();
						bean2.setInitKey_resource(fa.getAgregateresource().intValue());
						bean2.refreshCopyHelper();
						agrRes = bean2.getModel();
					}else agrRes = "";
	
					if(fa.getNewresource()!=null){
						ResourceAccessBean bean3 = new ResourceAccessBean();
						bean3.setInitKey_resource(fa.getNewresource().intValue());
						bean3.refreshCopyHelper();
						newRes = bean3.getModel();
					}else agrRes = "";
					
				} catch(Exception exc) {
					log(exc);
					param0 = "";
				}
				
				param0 = "";
				switch(poscode) {
				case 1:
					param0 = "Неисправное оборудование: ";
					break;
				case 2:
					param0 = "Устройство: ";
					break;
				case 3:
					param0 = "Обрудование на замену: ";
					break;
				}
			} else if(doctype == DOCTYPE_FKBS) {
					param0 = "";
					storage = null;
					storageto = null;
			} else {
				try {
					DocumentPositionAccessBean pos = new DocumentPositionAccessBean();
					pos.setInitKey_docposition(poscode);
					pos.refreshCopyHelper();
					param0 = "Позиция № "+pos.getOrder() + ": (" + pos.getResource().getResource() + ") ["+
						pos.getResource().getName()+", "+pos.getResource().getModel()+"]. ";
					storage = pos.getDocument().getFrom();
					storageto = pos.getDocument().getTo();
				} catch(Exception ex) {
					log(ex);
					param0 = "";
				}
			}
			switch(er.getErrorCode()) {
			case ProcessingPositionError.ERRORS.BAD_AGREGATION_NOTEXISTS:
				param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
				e = new ActionError("error.documentprocessing.bad_agregation_notexists",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.BAD_AGREGATION_NOTSUPPORTED:
				e = new ActionError("error.documentprocessing.bad_agregation_notsupported",param0);
				break;
			case ProcessingPositionError.ERRORS.BAD_AGREGATION_QTY:
				param1 = "";
				if(er.getQty() != null) {
					param1 = String.valueOf(er.getQty());
				}
				e = new ActionError("error.documentprocessing.bad_agregation_qty",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.BAD_AGREGATION:
				e = new ActionError("error.documentprocessing.bad_agregation",param0);
				break;
			case ProcessingPositionError.ERRORS.CARD_ALREADY_EXISTS:
				param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
				param2 = CDBCStoragecardsObject.findStorageNameBySerial(er.getSerial());
				e = new ActionError("error.documentprocessing.card_already_exists",param0,param1,param2);
				break;
			case ProcessingPositionError.ERRORS.CARD_CLOSED:
				e = new ActionError("error.documentprocessing.card_closed",param0);
				break;
			case ProcessingPositionError.ERRORS.UNKNOWN_POLICY:
				param1 = "";
				try {
					ResourceAccessBean rb = new ResourceAccessBean();
					rb.setInitKey_resource(er.getResource());
					rb.refreshCopyHelper();
					param1 = "Ресурс: " + rb.getModel() + " " +rb.getName();
				} catch (Exception ee) {					
				}
				e = new ActionError("error.documentprocessing.unknownpolicy",param0, param1);
				break;
			case ProcessingPositionError.ERRORS.INVENTARIZATION_BEFORE:
				param1 = "Код:"+er.getI13nAct();
				if(er.getI13nAct() > 0) {
					try {
						I13nActAccessBean bean = new I13nActAccessBean();
						bean.setInitKey_document(er.getI13nAct());
						bean.refreshCopyHelper();
						param1 = "№ "+bean.getBlankindex();
						if(bean.getBlanknumber() != null) {
							param1 += bean.getBlanknumber();
						}
						param1 += " от "+format.format(bean.getBlankdate());
					} catch(Exception e1) {
					}
				}
				e = new ActionError("error.documentprocessing.inventarization_before",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.NO_CARD:
				param1 = "";
				param2 = "";
				switch(poscode) {
				case 1:
					param1 = oldSer;
					param2 = oldRes; 
					break;
				case 2:
					param1 = agrSer;
					param2 = agrRes;
					break;
				case 3:
					param1 = newSer;
					param2 = newRes;
					break;
				}
				e = new ActionError("error.documentprocessing.no_card",param0,param2,param1);
				break;
			case ProcessingPositionError.ERRORS.NO_SUCH_PARTY:
				param1 = er.getParty();
				param2 = "";
				e = new ActionError("error.documentprocessing.no_such_party",param0,param1,param2);
				break;
			case ProcessingPositionError.ERRORS.NOT_IN_STORAGE:
				if(doctype == DOCTYPE_FKBS) {
					System.out.println("res=" + er.getResource() + ", ser=" + er.getSerial());
					param0 = CDBCStoragecardsObject.formatResourceName(er.getResource(), er.getSerial());
					param1 = CDBCStoragecardsObject.findStorageNameBySerialResource(er.getResource(), er.getSerial());
					e = new ActionError("error.documentprocessing.not_in_storage.3",param0,param1);
				} else {
					if(er.getStorage() > 0) {
						param1 = CDBCStoragecardsObject.findStorageName(er.getStorage());
						e = new ActionError("error.documentprocessing.not_in_storage.2",param0,param1);
					} else {
						param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
						param2 = CDBCStoragecardsObject.findStorageNameBySerial(er.getSerial());
						e = new ActionError("error.documentprocessing.not_in_storage.1",param0,param1,param2);
					}
				}
				break;
			case ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE:
				param1 = CDBCStoragecardsObject.findBySerial(er.getSerial());
				if(storage != null) {
					param2 = " "+CDBCStoragecardsObject.findStorageName(storage.getStorageplace());
				} else {
					param2 = "";
				}
		
				param3 = " "+CDBCStoragecardsObject.findStorageName(er.getStorage());
				if(param3 == null || "".equals(param3)) {
					param3 = " в другом месте";
				}
				e = new ActionError("error.documentprocessing.head_not_in_storage",param0,param1,param2,param3);
				break;
			case ProcessingPositionError.ERRORS.NOT_SUCH_PRODUCT:
				param1 = "";
				if(storage != null) {
					param1 = CDBCStoragecardsObject.findStorageName(storage.getStorageplace());
				}
				e = new ActionError("error.documentprocessing.not_such_product",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.NOT_THE_SAME_OWNER:
				try {
					OrganizationAccessBean bean = new OrganizationAccessBean();
					bean.setInitKey_organization(er.getOwner());
					bean.refreshCopyHelper();
					param1 = bean.getName();
				} catch(Exception ex) {
					param1 = ""+er.getOwner();
				}
				e = new ActionError("error.documentprocessing.not_the_same_owner",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.NOT_THE_SAME_DOC_OWNER:
				try {
					OrganizationAccessBean bean = new OrganizationAccessBean();
					bean.setInitKey_organization(er.getOwner());
					bean.refreshCopyHelper();
					param1 = bean.getName();
				} catch(Exception ex) {
					param1 = ""+er.getOwner();
				}
				e = new ActionError("error.documentprocessing.not_the_same_doc_owner",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE:
				try {
					ResourceAccessBean bean = new ResourceAccessBean();
					bean.setInitKey_resource(er.getResource());
					bean.refreshCopyHelper();
					param1 = bean.getName()+" "+bean.getModel();
					String policy = bean.getCountpolicy();
					if("S".equals(policy)) {
						param2 = "соответствующий указанному с/н";
					} else if("P".equals(policy)) {
						param2 = "соответствующий указанной партии";
					} else {
						param2 = "";
					}
				} catch(Exception ex) {
					param1 = ""+er.getResource();
					param2 = "";
				}
				e = new ActionError("error.documentprocessing.not_the_same_resource",param0,param1,param2);
				break;
			case ProcessingPositionError.ERRORS.NOTENOUGHQTY:
				if(er.getQty() != null) {
					param1 = er.getQty().toString();
				} else {
					param1 = "0";
				}
				e = new ActionError("error.documentprocessing.notenoughqty",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.POSITION_HIDDEN:
				param1 = ""+er.getLastDocumentCode();
				try {
					DocumentAccessBean bean = new DocumentAccessBean();
					bean.setInitKey_document(er.getLastDocumentCode());
					bean.refreshCopyHelper();
					param1 = getDocumentTypeName(bean);
					param1 += " № "+bean.getBlankindex();
					if(bean.getBlanknumber() != null) {
						param1 += bean.getBlanknumber();
					}
					param1 += " от "+format.format(bean.getBlankdate());
				} catch(Exception ex) {
					ex.printStackTrace(System.out);
				}
				e = new ActionError("error.documentprocessing.positionhidden",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.NOT_THE_SAME_STATE:
				e = new ActionError("error.documentprocessing.not_the_same_state",param0);
				break;
			case ProcessingPositionError.ERRORS.NOT_THE_SAME_PRICE:
				param1 = ""+er.getPrice();
				e = new ActionError("error.documentprocessing.not_the_same_price",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.CARD_IS_BOXED:
				e = new ActionError("error.documentprocessing.card_is_boxed",param0);
				break;
			case ProcessingPositionError.ERRORS.CARD_ALREADY_BOUND:
				param1 = "";
				param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
				e = new ActionError("error.documentprocessing.card_already_bound",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.INVALID_RESOURCE:
				param1 = "";
				try {
					ResourceAccessBean r = new ResourceAccessBean();
					r.setInitKey_resource(er.getResource());
					r.refreshCopyHelper();
					param1 = r.getName() + " " + r.getModel();
				} catch(Exception exc) {
				}
				e = new ActionError("error.documentprocessing.invalid_resource",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.DUPLICATE_SERIAL:
				e = new ActionError("error.documentprocessing.duplicate_serial",param0);
				break;
			case ProcessingPositionError.ERRORS.DUPLICATE_PARTY:
				e = new ActionError("error.documentprocessing.duplicate_party",param0);
				break;
			case ProcessingPositionError.ERRORS.DUPLICATE_RESOURCE:
				e = new ActionError("error.documentprocessing.duplicate_resource",param0);
				break;
			case ProcessingPositionError.ERRORS.NO_SERIAL:
				param1 = CDBCStoragecardsObject.findBySerial(er.getSerial());
				e = new ActionError("error.documentprocessing.noserial",param0,param1);
				break;
			case ProcessingPositionError.ERRORS.LOST_AGRAGATE:
				e = new ActionError("error.documentprocessing.lostagregate",param0);
				break;
			case ProcessingPositionError.ERRORS.UNAPPROVED_DOCUMENT:
				param1 = CDBCStoragecardsObject.findStorageName(er.getStorage());
				param2 = ""+er.getLastDocumentCode();
				try {
					DocumentAccessBean bean = new DocumentAccessBean();
					bean.setInitKey_document(er.getLastDocumentCode());
					bean.refreshCopyHelper();
					param2 = getDocumentTypeName(bean);
					param2 += " № "+bean.getBlankindex();
					if(bean.getBlanknumber() != null) {
						param2 += bean.getBlanknumber();
					}
					param2 += " от " + format.format(bean.getBlankdate());
				} catch(Exception ex) {
					ex.printStackTrace(System.out);
				}
				e = new ActionError("error.documentprocessing.unapproved", param1, param2);
				break;
			case ProcessingPositionError.ERRORS.APPROVED_DOCUMENT:
				e = new ActionError("error.documentprocessing.approved");
				break;
			default:
				e = new ActionError("error.documentprocessing.unknown",/*" "+errornames[*/new Integer(er.getErrorCode())/*]*/);
			}
		} catch(Exception ex) {
			e = new ActionError("error.documentprocessing.databean",ex.getMessage());
			log(ex);
		}
		return e;
	}
	
	public static void translateCurrencySumErrors(CurrencySumProcessingError cse, ActionErrors errors) {
		ActionError e;
		switch(cse.getErrorCode()) {
		case CurrencySumProcessingError.ERRORS.BAD_RATE:
			String curDate, rateTypeName, currencyName;
			curDate = format.format(cse.getCurDate());
			try {
				RateTypeAccessBean rt = new RateTypeAccessBean();
				rt.setInitKey_ratetype(cse.getRateType().intValue());
				rt.refreshCopyHelper();
				rateTypeName = rt.getName();
			} catch(Exception ex) {
				rateTypeName = "" + cse.getRateType();
			}
			try {
				CurrencyAccessBean cur = new CurrencyAccessBean();
				cur.setInitKey_currency(cse.getCurrency().intValue());
				cur.refreshCopyHelper();
				currencyName = cur.getName();
			} catch(Exception ex2) {
				currencyName = "" + cse.getCurrency();
			}
			e = new ActionError("error.currencyprocessing.bad_rate",curDate,rateTypeName,currencyName);
			break;
		case CurrencySumProcessingError.ERRORS.BAD_RATE_TYPE:
			e = new ActionError("error.currencyprocessing.bad_rate_type",cse.getRateType());
			break;
		case CurrencySumProcessingError.ERRORS.NO_BASE_CURRENCY:
			e = new ActionError("error.currencyprocessing.bad_base_currency");
			break;
		case CurrencySumProcessingError.ERRORS.NO_BASE_RATE_TYPE:
			e = new ActionError("error.currencyprocessing.bad_base_rate_type");
			break;
		default:
			e = new ActionError("error.currencyprocessing.unknown",""+cse.getErrorCode());
			break;
		}
		if (errors != null)
			errors.add(ActionErrors.GLOBAL_ERROR, e);
	}

	public static void log(Exception e) {
		//System.out.println("DPA>>> EXCEPTION: "+e.getClass().getName());
	}
}
