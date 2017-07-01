package com.hps.july.inventory.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.inventory.sessionbean.*;
import com.hps.july.inventory.formbean.*;
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
import org.apache.struts.util.PropertyUtils;

/**
 * Обработчик формы редактирования позиции "Внешнего приходного ордера"
 * При добавлении нескольких серийных позиций осуществляет переход на 
 * форму редактирования серийных номеров.
 * При удалении серийной позиции удаляет все записи с номерами
 */
public class AfsIndoorMountActProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Создание строки акта монтажа АФС - антена.
 * Creation date: (15.10.2004 17:57:33)
 * Номер антены вычисляется следующим образом:
 *   1-а цифра - по номеру сектора
 *   2-я цифра порядковый номер антены в секторе (для двухдиапазонных антенн берется младший номер)
 */
public Integer createAntena(Integer argDocument, int argOrder, Integer argOwner, Integer argResource, 
			String argSerial, String argQty, boolean argSectorA, boolean argSectorB, boolean argSectorC, 
			boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO, boolean argSectorO1800,
			String argAntNumSecondDigit, String argNakl, String argAzimut,String argComment) throws Exception {

		String [][] sectGSM = new String [][] { {"A", "1"}, {"B", "2"}, {"C", "3"}, {"D", "4"}, {"O1800", "0"},
			{"E", "5"}, {"F", "6"}, {"G", "7"}, {"H", "8"}, {"O", "9"} };
		
		int docpos = 0;
		StringAndBigDecimalProperty qty = new StringAndBigDecimalProperty();
		qty.setString(argQty);
		if (  (argResource != null)   &&   ( ( (argSerial != null) && (!"".equals(argSerial.trim()))  )  || (!qty.isEmpty()) )  ) {
			com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
			docpos = keyGen.getNextKey("tables.docpositions");

			String policy = "";
			// найдем ресурс			
			try {
				int bi = argResource.intValue();
				ResourceAccessBean res = new ResourceAccessBean();
				res.setInitKey_resource(bi);
				res.refreshCopyHelper();
				policy = res.getCountpolicy();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
			if ("S".equals(policy)	|| "P".equals(policy)) {
				qty.setString("1");
			} else {
				qty.setString(argQty);
			}

			//System.out.println("GEN ANT: serial=" + argSerial + ", qty=" + qty.getBigDecimal());

			// Создадим позицию документа
			//System.out.println("Before CrAnt: docpos=" + docpos + ", argResource=" + argResource + ",argowner=" + argOwner +
			//	", document = " + argDocument + ", order=" + argOrder + ", qty=" + qty.getBigDecimal());
			AfsMountPosAccessBean bean = new AfsMountPosAccessBean(
				docpos,
				argResource,
				argOwner,
				argDocument,
				argOrder,
				qty.getBigDecimal(),
				new java.math.BigDecimal(0),   // Price
				Boolean.FALSE, Boolean.FALSE, // Boxed
				Boolean.FALSE, Boolean.FALSE, // Broken
				Boolean.FALSE, Boolean.FALSE // Closed
			);
			
			if ("S".equals(policy)) {
				bean.setSerialnumber(argSerial);
			} else if ("P".equals(policy)) {
				bean.setParty(argSerial);
			}
			bean.setNewplace("-");
			bean.setComment(argComment);
			bean.setDocpostype("A");  // GSM антена
			bean.setH_set1(new java.math.BigDecimal(0));
			
			// Вычислим первую цифру номера антены
			//  Выберем наименьший из возможных номеров
			String antnum = "A";
			if (argSectorO) antnum = "9";
			if (argSectorH) antnum = "8";
			if (argSectorG) antnum = "7";
			if (argSectorF) antnum = "6";
			if (argSectorE) antnum = "5";
			if (argSectorD) antnum = "4";
			if (argSectorC) antnum = "3";
			if (argSectorB) antnum = "2";
			if (argSectorA) antnum = "1";
			if (argSectorO1800) antnum = "0";
			bean.setNum_ant(antnum + argAntNumSecondDigit);

			bean.setKind_ant("D"); // Приемно-передающая антенна

			qty.setString(argNakl);
			bean.setNakl(qty.getBigDecimal());
			
			qty.setString(argAzimut);
			bean.setAz_ant(qty.getBigDecimal());

			bean.setSectorA(new Boolean(argSectorA));
			bean.setSectorB(new Boolean(argSectorB));
			bean.setSectorC(new Boolean(argSectorC));
			bean.setSectorD(new Boolean(argSectorD));
			bean.setSectorE(new Boolean(argSectorE));
			bean.setSectorF(new Boolean(argSectorF));
			bean.setSectorG(new Boolean(argSectorG));
			bean.setSectorH(new Boolean(argSectorH));
			bean.setSectorO(new Boolean(argSectorO));
			bean.setSectorO1800(new Boolean(argSectorO1800));
			
			bean.commitCopyHelper();
			return new Integer(docpos);
		}
		return null;
}
/**
 * Создание строки акта монтажа АФС - кабель.
 * Creation date: (15.10.2004 17:57:33)
 */
public Integer createCable(Integer argParentPos, Integer argDocument, int argOrder, Integer argOwner, Integer argResource, 
			String argSerial, String argQty, boolean argSectorA, boolean argSectorB, boolean argSectorC, 
			boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO, boolean argSectorO1800,
			Integer argGroudResource, String argGroundCnt, String argKsvn, String argComment) throws Exception {

		int docpos = 0;
		String policy = "";
		// найдем ресурс
		if (argResource != null) {
			try {
				int bi = argResource.intValue();
				ResourceAccessBean res = new ResourceAccessBean();
				res.setInitKey_resource(bi);
				res.refreshCopyHelper();
				policy = res.getCountpolicy();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			StringAndBigDecimalProperty qty = new StringAndBigDecimalProperty();
			if ("S".equals(policy)	|| "P".equals(policy)) {
				qty.setString("1");
			} else {
				qty.setString(argQty);
			}
			if ((argResource != null) && qty.isOk() && !qty.isEmpty() )  {
				com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
				docpos = keyGen.getNextKey("tables.docpositions");

				
				//System.out.println("GEN CABLE: serial=" + argSerial + ", qty=" + qty.getBigDecimal());
				
				// Создадим позицию документа
				AfsMountPosAccessBean bean = new AfsMountPosAccessBean(
					docpos,
					argResource,
					argOwner,
					argDocument,
					argOrder,
					qty.getBigDecimal(),
					new java.math.BigDecimal(0),   // Price
					Boolean.FALSE, Boolean.FALSE, // Boxed
					Boolean.FALSE, Boolean.FALSE, // Broken
					Boolean.FALSE, Boolean.FALSE // Closed
				);
				
				if ("S".equals(policy)) {
					bean.setSerialnumber(argSerial);
				} else if ("P".equals(policy)) {
					bean.setParty(argSerial);
				}
				bean.setNewplace("-");
				bean.setComment(argComment);
				bean.setDocpostype("C");  // GSM кабель
				bean.setParentdocpos(argParentPos);
				bean.setLen_cable(qty.getBigDecimal());

				if (argGroudResource != null) {
					try {
						ResourceAccessBean res = new ResourceAccessBean();
						res.setInitKey_resource(argGroudResource.intValue());
						res.refreshCopyHelper();
						bean.setGroundresource((Resource)res.getEJBRef());
					} catch (Exception e) {
						e.printStackTrace(System.out);
					}
				}

				StringAndIntegerProperty si = new StringAndIntegerProperty();
				si.setString(argGroundCnt);
				bean.setGroundcnt(si.getInteger());

				qty.setString(argKsvn);
				if (argSectorA || argSectorB || argSectorC || argSectorD || argSectorO1800)
					bean.setKsvn1800(qty.getBigDecimal());
				if (argSectorE || argSectorF || argSectorG || argSectorH || argSectorO)
					bean.setKsvn900(qty.getBigDecimal());
				
				bean.commitCopyHelper();
				return new Integer(docpos);
			}
		}
		return null;
}
/**
 * Генерация позиции акта монтажа АФС по введенным данным.
 * Creation date: (15.10.2004 17:57:33)
 */
public Integer createPosition(Integer argParentPos, Integer argDocument, int argOrder, String argPostype, Integer argOwner, Integer argResource, String argSerial, String argQty, String argComment) throws Exception {

		if (argResource != null) {
			com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
			int docpos = keyGen.getNextKey("tables.docpositions");

			String policy = "";
			// найдем ресурс			
			try {
				int bi = argResource.intValue();
				ResourceAccessBean res = new ResourceAccessBean();
				res.setInitKey_resource(bi);
				res.refreshCopyHelper();
				policy = res.getCountpolicy();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
			StringAndBigDecimalProperty qty = new StringAndBigDecimalProperty();
			if ("S".equals(policy)	|| "P".equals(policy)) {
				qty.setString("1");
			} else {
				qty.setString(argQty);
			}

			// Создадим позицию документа
			AfsMountPosAccessBean bean = new AfsMountPosAccessBean(
				docpos,
				argResource,
				argOwner,
				argDocument,
				argOrder,
				qty.getBigDecimal(),
				new java.math.BigDecimal(0),   // Price
				Boolean.FALSE, Boolean.FALSE, // Boxed
				Boolean.FALSE, Boolean.FALSE, // Broken
				Boolean.FALSE, Boolean.FALSE // Closed
			);
			
			bean.setDocpostype(argPostype);  // Тип позиции
			
			if ("S".equals(policy)) {
				bean.setSerialnumber(argSerial);
			} else if ("P".equals(policy)) {
				bean.setParty(argSerial);
			}
			bean.setNewplace("-");
			bean.setComment(argComment);
			bean.setParentdocpos(argParentPos);
			bean.commitCopyHelper();
			return new Integer(docpos);
		}
		return null;
}
/**
 * Генерация акта монтажа по введенным данным.
 * Creation date: (15.10.2004 17:57:33)
 */
public void generateAfsMountAct(AfsIndoorMountActForm editForm,HttpServletRequest request, HttpServletResponse response) throws Exception {
		com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
		int doc = keyGen.getNextKey("tables.documents");
		editForm.setDocument(doc);
		StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
		blankdate.setString(editForm.getActdate());
		StringAndIntegerProperty blankindex = new StringAndIntegerProperty();
		blankindex.setString(editForm.getPosnumber());
		String blanknumber = editForm.getPosnumber();

		// Определим экспедицию
		Integer exped = null;
		StringAndIntegerProperty pcode = new StringAndIntegerProperty();
		pcode.setString(editForm.getProvidercode());
		try {
			java.util.Enumeration en = new ExpeditionAccessBean().findExpeditionByOrganization(new OrganizationKey(pcode.getInteger().intValue()));
			if(en.hasMoreElements()) {
				ExpeditionAccessBean exp1 = (ExpeditionAccessBean)en.nextElement();
				exped = new Integer(exp1.getStorageplace());
			} else {
				OrganizationAccessBean o = new OrganizationAccessBean();
				o.setInitKey_organization(pcode.getInteger().intValue());
				o.refreshCopyHelper();
				int expkey = keyGen.getNextKey("tables.storageplaces");
				ExpeditionAccessBean exp = new ExpeditionAccessBean(expkey, null, "", "");
				exp.setOrganization((Organization)o.getEJBRef());
				exp.setExpeditor(null);
				exp.setName(o.getName());
				exp.commitCopyHelper();
				exped = new Integer(expkey);
			}
		} catch (Exception ee) {
			ee.printStackTrace(System.out);
		}
		
		Integer owner = editForm.getOwnercode();
		// Создадим шапку документа
		AfsMountActAccessBean bean = new AfsMountActAccessBean(
			doc,
			owner,
			exped, 
			editForm.getComplectcode(),
			blankdate.getSqlDate(),
			blankindex.getInteger().intValue(),
			// "",
			blanknumber,
			"1",
			Boolean.TRUE,
			Boolean.TRUE,
			Boolean.FALSE
		);
		bean.setNeedapprove(editForm.isNeedapprove());
		bean.setProjectid(editForm.getProjectid());
		bean.setInsuranseMan(editForm.getInsuranceMan());
		bean.setAfstype("I");  // Indoor act
		
		StringAndIntegerProperty wrkcode = new StringAndIntegerProperty();
		wrkcode.setString(editForm.getWorkercode());
		WorkerAccessBean wrk = new WorkerAccessBean();
		wrk.setInitKey_worker(wrkcode.getInteger().intValue());
		wrk.refreshCopyHelper();
		bean.setMonter((Worker)wrk.getEJBRef());

		bean.commitCopyHelper();

		// Создадим позиции документа
		int order = 1;
		Integer docpos = null;

		// Создадим репитеры
		if ("B".equals(editForm.getEqtype())) {  // Только при монтаже на репитере
			for (int i=0; i < 2; i++) {
				docpos = createPosition(null, new Integer(doc), order, "D", owner, editForm.getRepmodel(i), editForm.getRepserial(i), "1", editForm.getRepcomment(i));
				if (docpos != null)
					order++;
			}
		}

		// Создадим антенны
		if ("A".equals(editForm.getEqtype())) {  // Создадим антенны для БС
			for (int i=0; i < editForm.getAntcount(); i++) {
				docpos = createAntena(new Integer(doc), order, owner, editForm.getAntmodel(i), 
					editForm.getAntserial(i), "1", 
					"A".equals(editForm.getSector()), 
					"B".equals(editForm.getSector()), 
					"C".equals(editForm.getSector()), 
					"D".equals(editForm.getSector()), 
					"E".equals(editForm.getSector()), 
					"F".equals(editForm.getSector()), 
					"G".equals(editForm.getSector()), 
					"H".equals(editForm.getSector()), 
					"O".equals(editForm.getSector()), 
					"O".equals(editForm.getSector()), 
					new Integer(i+1).toString(), null, null,editForm.getAntcomment(i));
				if (docpos != null) {
					order++;
					docpos = createCable(docpos, new Integer(doc), order, owner,
						editForm.getAntcable(i), null, editForm.getAntcablen(i),
					"A".equals(editForm.getSector()), 
					"B".equals(editForm.getSector()), 
					"C".equals(editForm.getSector()), 
					"D".equals(editForm.getSector()), 
					"E".equals(editForm.getSector()), 
					"F".equals(editForm.getSector()), 
					"G".equals(editForm.getSector()), 
					"H".equals(editForm.getSector()), 
					"O".equals(editForm.getSector()), 
					"O".equals(editForm.getSector()), 
						null, null, null,editForm.getAntcomment(i));
				}
			}
		} else {  // Создадим антенны для репитера
			for (int i=0; i < editForm.getAntcount(); i++) {
				docpos = createAntena(new Integer(doc), order, owner, editForm.getAntmodel(i), 
					editForm.getAntserial(i), "1",
					false, false, false, false, false, false, false, false, false, false,
					new Integer(i+1).toString(), null, null,null);
				if (docpos != null) {
					order++;
					docpos = createCable(docpos, new Integer(doc), order, owner,
						editForm.getAntcable(i), null, editForm.getAntcablen(i),
						false, false, false, false, false, false, false, false, false, false,
						null, null, null,null);
				}
			}
		}

		// Создадим делители
		for (int i=0; i < editForm.getDivcount(); i++) {
			docpos = createPosition(null, new Integer(doc), order, "E", owner, editForm.getDivmodel(i), editForm.getDivserial(i), "1", editForm.getDivcomment(i));
			if (docpos != null) {
				order++;
				docpos = createCable(docpos, new Integer(doc), order, owner,
					editForm.getDivcable(i), null, editForm.getDivcablen(i),
					false, false, false, false, false, false, false, false, false, false,
					null, null, null,editForm.getDivcomment(i));
			}
		}
}
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

		//is canceled
		if( isCancelled(request) ) {
			return  mapping.findForward( "errorgoback" ); 
		}

  		//process actions
  		AbstractEntityAccessBean bean = null;
		AfsIndoorMountActForm editForm = (AfsIndoorMountActForm)form;
	    try { 
			editForm.setReturnPage(mapping.findForward( "errorgoback" ).getPath());

			editForm.setUser(request.getRemoteUser());
			if (request.isUserInRole("administrator"))
				editForm.setIsAdmin(Boolean.TRUE);
			else
				editForm.setIsAdmin(Boolean.FALSE);
	  		
			if( editForm.getAction().equals("Add") ) {
				editForm.validateValues(errors);
				generateAfsMountAct(editForm, request, response);
				String sc = mapping.findForward( "success" ).getPath();
				int ind = sc.indexOf("?");
				if ( ind > 0)
					sc = sc.substring(0, ind);
				sc = sc + "?action=Edit&doc=" + editForm.getDocument();
	  	    	retVal = new ActionForward(sc, true); 
			}
	    } catch( ValidationException e ) {
		    if (e instanceof UpdateValidationException)
		    	ErrorProcessor.processException( errors, e );
		    // do nothing 
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
	  	    retVal = mapping.findForward( "main" ); 
	    } catch( Exception e ) {
		    e.printStackTrace(System.out);
		    ErrorProcessor.processException( errors, e );
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
	  	    retVal = mapping.findForward( "main" );
	  	    retVal = processException( errors, e, editForm, bean, retVal );
	    }
	    
		//process errors
	    if( !errors.empty() ) {
	 	  	saveErrors(request, errors);
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
	  	    retVal = mapping.findForward( "main" ); 
	    }

	    /*if (retVal != null)
	    	System.out.println("RetVal=" + retVal.getPath());
	    else
	    	System.out.println("RetVal=null");*/
	    return retVal;    
	}
}
