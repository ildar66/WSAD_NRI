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
public class MountAct3ProcessAction extends com.hps.july.web.util.AbstractProcessAction {
/**
 * Генерация акта монтажа по введенным данным.
 * Creation date: (15.10.2004 17:57:33)
 */
public Integer createPosition(Integer argDocument, int argOrder, Integer argOwner, Integer argResource, String argSerial, String argQty, String argComment, Integer argParentPos, String argParentSerial, boolean argIBP) throws Exception {

	    Integer result = null;
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
			if (argIBP) {
				IBPMountPosAccessBean bean = new IBPMountPosAccessBean(
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
				bean.commitCopyHelper();
			} else {
				InternalWayBillPositionAccessBean bean = new InternalWayBillPositionAccessBean(
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
				if (argParentPos != null) {
					DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
					dp.setInitKey_docposition(argParentPos.intValue());
					dp.refreshCopyHelper();
					bean.setAgregate((DocumentPosition)dp.getEJBRef());
					bean.setAgregateSerial(argParentSerial);
					bean.setAgregateresource(new Integer(dp.getResourceKey().resource));
				}
				bean.commitCopyHelper();
			}
			result = new Integer(docpos);
		}
		return result;
}
/**
 * Генерация акта монтажа по введенным данным.
 * Creation date: (15.10.2004 17:57:33)
 */
public void generateMountAct(MountAct3Form editForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		InternalWayBillAccessBean bean = new InternalWayBillAccessBean(
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
		
		StringAndIntegerProperty wrkcode = new StringAndIntegerProperty();
		wrkcode.setString(editForm.getWorkercode());
		WorkerAccessBean wrk = new WorkerAccessBean();
		wrk.setInitKey_worker(wrkcode.getInteger().intValue());
		wrk.refreshCopyHelper();
		bean.setMonter((Worker)wrk.getEJBRef());

		bean.commitCopyHelper();

		// Создадим позиции документа
		Integer document = new Integer(doc);
		int order=1;
		Integer docpos;
		docpos = createPosition(document, order++, owner, editForm.getResource10(), editForm.getSerial10(), editForm.getQty10(), editForm.getComment10(), null, null, true);
		createPosition(document, 1, owner, editForm.getResource20(), editForm.getSerial20(), editForm.getQty20(), editForm.getComment20(), docpos, editForm.getSerial10(), false);
		createPosition(document, 3, owner, editForm.getResource30(), editForm.getSerial30(), editForm.getQty30(), editForm.getComment30(), docpos, editForm.getSerial10(), false);
		createPosition(document, order++, owner, editForm.getResource40(), editForm.getSerial40(), editForm.getQty40(), editForm.getComment40(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource50(), editForm.getSerial50(), editForm.getQty50(), editForm.getComment50(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource60(), editForm.getSerial60(), editForm.getQty60(), editForm.getComment60(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource70(), editForm.getSerial70(), editForm.getQty70(), editForm.getComment70(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource80(), editForm.getSerial80(), editForm.getQty80(), editForm.getComment80(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource85(), editForm.getSerial85(), editForm.getQty85(), editForm.getComment85(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource90(), editForm.getSerial90(), editForm.getQty90(), editForm.getComment90(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource100(), editForm.getSerial100(), editForm.getQty100(), editForm.getComment100(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource110(), editForm.getSerial110(), editForm.getQty110(), editForm.getComment110(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource120(), editForm.getSerial120(), editForm.getQty120(), editForm.getComment120(), null, null, false);
		createPosition(document, order++, owner, editForm.getResource130(), editForm.getSerial130(), editForm.getQty130(), editForm.getComment130(), null, null, false);
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
		MountAct3Form editForm = (MountAct3Form)form;
	    try { 
			editForm.setReturnPage(mapping.findForward( "errorgoback" ).getPath());

			editForm.setUser(request.getRemoteUser());
			if (request.isUserInRole("administrator"))
				editForm.setIsAdmin(Boolean.TRUE);
			else
				editForm.setIsAdmin(Boolean.FALSE);
	  		
			if( editForm.getAction().equals("Add") ) {
				editForm.validateValues(errors);
				generateMountAct(editForm, request, response);
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
