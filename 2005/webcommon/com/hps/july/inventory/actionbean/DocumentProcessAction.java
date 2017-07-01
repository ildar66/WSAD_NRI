package com.hps.july.inventory.actionbean;

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
import com.hps.july.cdbc.objects.CDBCStoragecardsObject;

/**
 * Обработчик смены состояния документов
 * Используется как для обычных документов так и для "Актов замены/модернизации"
 * Вызывает ProcessorFacade и обрабатывает полученные ошибки
 */
public class DocumentProcessAction extends AbstractProcessAction {
	public static MessageResources messageRes = MessageResources.getMessageResources("com.hps.july.inventory.ApplicationResources");
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
/*
	private static String[] errornames = new String[] {
		"0","BAD_AGREGATION", "INVENTARIZATION_BEFORE", "NOTENOUGHQTY", "CARD_CLOSED",
		"NOT_THE_SAME_OWNER", "NOT_THE_SAME_STATE", "NO_SUCH_PARTY", "NOT_SUCH_PRODUCT",
		"UNKNOWN_POLICY", "LOST_AGRAGATE", "NO_CARD", "NOT_IN_STORAGE", "CARD_ALREADY_EXISTS",
		"POSITION_HIDDEN", "NOT_THE_SAME_RESOURCE", "NOT_THE_SAME_PRICE", "CARD_IS_BOXED",
		"CARD_ALREADY_BOUND", "19", "20", "21", "22", "23", "24", "25"
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
				type = messageRes.getMessage("label.document.internalwaybill");
			} else {
				type = messageRes.getMessage("label.document.internalwaybill.m");
			}
		} else
		if(bean.getEJBRef() instanceof InternalOutBill) {
			EJBObject o = bean.getFrom().getEJBRef();
			if(o instanceof Storage) {
				type = messageRes.getMessage("label.document.internaloutbill");
			} else {
				type = messageRes.getMessage("label.document.internaloutbill.m");
			}
		} else
		if(bean.getEJBRef() instanceof OutWayBill) {
			type = messageRes.getMessage("label.document.outwaybill");
		} else
		if(bean.getEJBRef() instanceof I13nAct) {
			EJBObject o = bean.getFrom().getEJBRef();
			if(o instanceof Storage) {
				type = messageRes.getMessage("label.document.i13nact.s");
			} else {
				type = messageRes.getMessage("label.document.i13nact.p");
			}
		} else
		if(bean.getEJBRef() instanceof AssemblingAct) {
			AssemblingActAccessBean aa = new AssemblingActAccessBean(bean.getEJBRef());
			aa.refreshCopyHelper();
			EJBObject o = aa.getFrom().getEJBRef();
			if("A".equals(aa.getOperationType())) {
				if(o instanceof Storage) {
					type = messageRes.getMessage("label.document.assemblingact.as");
				} else {
					type = messageRes.getMessage("label.document.assemblingact.ap");
				}
			} else {
				if(o instanceof Storage) {
					type = messageRes.getMessage("label.document.assemblingact.ds");
				} else {
					type = messageRes.getMessage("label.document.assemblingact.dp");
				}
			}
		} else
		if(bean.getEJBRef() instanceof ChangeAct) {
			type = messageRes.getMessage("label.document.changeact");
		} else
		if(bean.getEJBRef() instanceof FaultReport) {
			type = messageRes.getMessage("label.document.faultreport");
		} else
		if(bean.getEJBRef() instanceof PayOffAct) {
			EJBObject o = bean.getFrom().getEJBRef();
			if(o instanceof Storage) {
				type = messageRes.getMessage("label.document.payoffact");
			} else {
				type = messageRes.getMessage("label.document.payoffinv");
			}
		} else
		if(bean.getEJBRef() instanceof SurplusAct) {
			type = messageRes.getMessage("label.document.surplusact");
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return r;
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
/**
 * Преобразование класса ошибки в строку, содержащую расшифровку ошибки.
 * Creation date: (24.09.2004 19:21:22)
 * @return java.lang.String
 * @param e org.apache.struts.action.ActionError
 */
public String getErrorText(ActionError e) {
   String  message = e.getKey();
    try {
	    message = getServlet().getResources().getMessage(e.getKey(), e.getValues());
    } catch (Exception ee) {
	    // Message not found
    }
	return message;
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
    /**
     * Основной метод обработки запроса.
     */
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		// Удалим старые ошибки обсчета документа
		com.hps.july.cdbc.objects.CDBCInventoryDocumentError cdbcIDER = new com.hps.july.cdbc.objects.CDBCInventoryDocumentError();
		cdbcIDER.clearDocumentErrors(docCode);
		return super.perform(mapping, form, request, response);
	}
public ActionForward processException(ActionErrors errors, Exception e, EditForm editForm, AbstractEntityAccessBean bean, ActionForward retVal)
{
	DocumentProcessingException dpe = DocumentProcessingExceptionChecker.check(e);
	if(dpe != null) {
		translateErrors(editForm, dpe, errors);
	} else {
		CurrencySumProcessingError cse = CurrencySumProcessingExceptionChecker.check(e);
		if(cse != null){
			translateCurrencySumErrors(cse,errors);
		} else {
			e.printStackTrace(System.out);
		}
	}

	return retVal;
}
public static void translateCurrencySumErrors(CurrencySumProcessingError cse, ActionErrors errors)
{
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
	errors.add(ActionErrors.GLOBAL_ERROR, e);
}
public void translateErrors(EditForm form, DocumentProcessingException x, ActionErrors errors)
{
	com.hps.july.cdbc.objects.CDBCInventoryDocumentError cdbcIDER;
	cdbcIDER = new com.hps.july.cdbc.objects.CDBCInventoryDocumentError();
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
	
	ActionError e;
	int errorcode = x.getErrorCode();

	switch(errorcode) {
	case 7:
		if(form != null) {
			try {
				PropertyUtils.setProperty(form,"warnProc",Boolean.TRUE);
			} catch(Throwable t) {
				//System.out.println("DOCPROCESSACTION[ WarnProcess not set for "+form.getClass().getName()+"]");
				t.printStackTrace(System.out);
			}
		}
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
			e = translateProcessingErrors(er);
			//errors.add(ActionErrors.GLOBAL_ERROR, e);
			cdbcIDER.addDocumentError(docCode, new Integer(er.getPositionCode()), new Integer(er.getErrorLevel()), getErrorText(e));
		}
		break;
	case 1:
		errors.clear();
		e = new ActionError("error.documentprocessing.instate");
		//errors.add(ActionErrors.GLOBAL_ERROR, e);
		cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e));
		break;
	case 2:
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
		//errors.add(ActionErrors.GLOBAL_ERROR, e);
		cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e));
		break;
	case 3:
		CurrencySumProcessingError err = new CurrencySumProcessingError();
		err.setErrorCode(x.getCurErrorCode());
		err.setCurDate(x.getCurDate());
		err.setCurrency(x.getCurrency());
		err.setRateType(x.getRateType());
		errors.clear();
		translateCurrencySumErrors(err,errors);
		break;
	case 4:
		errors.clear();
		e = new ActionError("error.documentprocessing.bigprice");
		//errors.add(ActionErrors.GLOBAL_ERROR, e);
		cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e));
		break;
	case 5:
		errors.clear();
		e = new ActionError(x.getErrorMessage());
		//errors.add(ActionErrors.GLOBAL_ERROR, e);
		cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e));
		break;
	case 6:
		errors.clear();
		e = new ActionError(x.getErrorMessage());
		//errors.add(ActionErrors.GLOBAL_ERROR, e);
		cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e));
		break;
	default:
		errors.clear();
		e = new ActionError("error.documentprocessing.unknowndocerror");
		//errors.add(ActionErrors.GLOBAL_ERROR, e);
		cdbcIDER.addDocumentError(docCode, new Integer(0), getErrorText(e));
		break;
	}
}
public static ActionError translateProcessingErrors(ProcessingPositionError er)
{
	ActionError e;
	try {
		String param0,param1,param2,param3;
		int poscode = er.getPositionCode();
		StoragePlaceAccessBean storage = null;
		StoragePlaceAccessBean storageto = null;
		try {
			DocumentPositionAccessBean pos = new DocumentPositionAccessBean();
			pos.setInitKey_docposition(poscode);
			pos.refreshCopyHelper();
			param0 = "Позиция № "+pos.getOrder() + ": (" + pos.getResource().getResource() + ") ["+
				pos.getResource().getName()+", "+pos.getResource().getModel()+"]. ";
			storage = pos.getDocument().getFrom();
			storageto = pos.getDocument().getTo();
		} catch(Exception ex) {
			try {
				ChangeActPositionAccessBean pos = new ChangeActPositionAccessBean();
				pos.setInitKey_code(poscode);
				pos.refreshCopyHelper();
				ChangePositionValue pv = new ChangePositionValue(pos);
				param0 = "Позиция № "+pos.getCode()+": ("+pv.getOres()+")"+ pv.getOresname()+", "+pv.getOresmodel()+". S/N:"+pv.getOldserial()+". ";
				storage = pos.getChangeAct().getFrom();
			} catch(Exception exc) {
				log(exc);
				param0 = "";
			}
		}
		switch(er.getErrorCode()) {
		case ProcessingPositionError.ERRORS.BAD_AGREGATION_NOTEXISTS:
			param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
			/*
			if(er.getSerial() != null) {
				
				try {
					StorageCardAccessBean b = (new StorageCardAccessBean()).findBySerial(er.getSerial());
					param1 = b.getResource().getName() + " " + b.getResource().getModel()+" с/н "+er.getSerial();
				} catch(Exception exc) {
					param1 = "с/н "+er.getSerial();
				}
			}
			*/
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
			/*
			if(er.getSerial() != null) {
				try {
					StorageCardAccessBean b = (new StorageCardAccessBean()).findBySerial(er.getSerial());
					param1 = b.getResource().getName() + " " + b.getResource().getModel()+" с/н "+er.getSerial();
					param2 = " "+getSpname(b.getCurrentstorage());
				} catch(Exception exc) {
					param1 = "с/н "+er.getSerial();
				}
			}
			*/
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
			param1 = CDBCStoragecardsObject.findBySerial(er.getSerial()); //er.getSerial();
/*
			param2 = "";
			if(er.getSerial() != null) {
				try {
					StorageCardAccessBean b = (new StorageCardAccessBean()).findBySerial(er.getSerial());
					StoragePlaceAccessBean sp = b.getCurrentstorage();
					param2 = getSpname(sp);
				} catch(Exception exc) {
					param2 = "";
				}
			}
*/
			e = new ActionError("error.documentprocessing.no_card",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.NO_SUCH_PARTY:
			param1 = er.getParty();
			param2 = "";
			// @TODO: find storage
			e = new ActionError("error.documentprocessing.no_such_party",param0,param1,param2);
			break;
		case ProcessingPositionError.ERRORS.NOT_IN_STORAGE:
			if(er.getStorage() > 0) {
				param1 = CDBCStoragecardsObject.findStorageName(er.getStorage());
/*
				try {
					StoragePlaceAccessBean bean = new StoragePlaceAccessBean();
					bean.setInitKey_storageplace(er.getStorage());
					bean.refreshCopyHelper();
					param1 = getSpname(bean);
				} catch(Exception exc) {
					param1 = "";
				}
*/
				e = new ActionError("error.documentprocessing.not_in_storage.2",param0,param1);
			} else {
				param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
				param2 = CDBCStoragecardsObject.findStorageNameBySerial(er.getSerial());
/*
				if(param1 != null) {
					try {
						StorageCardAccessBean b = (new StorageCardAccessBean()).findBySerial(er.getSerial());
						StoragePlaceAccessBean sp = b.getCurrentstorage();
						param2 = getSpname(sp);
					} catch(Exception exc) {
					}
				}
*/
				e = new ActionError("error.documentprocessing.not_in_storage.1",param0,param1,param2);
			}
			break;
		case ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE:
			param1 = CDBCStoragecardsObject.findBySerial(er.getSerial());
			if(storage != null) {
				param2 = CDBCStoragecardsObject.findStorageName(storage.getStorageplace());
			} else {
				param2 = "";
			}
	
			param3 = CDBCStoragecardsObject.findStorageName(er.getStorage());
			if(param3 == null || "".equals(param3)) {
				param3 = " в другом месте";
			}
/*
			try {
				StoragePlaceAccessBean sp = new StoragePlaceAccessBean();
				sp.setInitKey_storageplace(er.getStorage());
				sp.refreshCopyHelper();
				param3 = " "+getSpname(sp);
			} catch(Exception exc) {
			}
*/
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
//					param2 = "соответствующий с/н "+"SN";
					param2 = "соответствующий указанному с/н";
				} else if("P".equals(policy)) {
//					param2 = "соответствующий партии "+"party";
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
/*
			try {
				StorageCardAccessBean b = new StorageCardAccessBean();
				b.setInitKey_storagecard(er.getStoragecard());
				b.refreshCopyHelper();
				param1 = b.getResource().getName() + " " + b.getResource().getModel()+" с/н: "+b.getSerialnumber();
			} catch(Exception exc) {
				param1 = String.valueOf(er.getStoragecard());
			}
*/
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
		default:
			e = new ActionError("error.documentprocessing.unknown",/*" "+errornames[*/new Integer(er.getErrorCode())/*]*/);
		}
	} catch(Exception ex) {
		e = new ActionError("error.documentprocessing.databean",ex.getMessage());
		log(ex);
	}
	return e;
}
}
