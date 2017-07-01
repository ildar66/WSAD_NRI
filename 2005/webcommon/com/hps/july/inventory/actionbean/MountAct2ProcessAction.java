package com.hps.july.inventory.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.inventory.sessionbean.*;
import com.hps.july.inventory.formbean.*;
import com.hps.july.logic.VisualDocTypes;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.cdbc.lib.CDBCResultSet;
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
public class MountAct2ProcessAction extends NIDocumentProcessAction {
	
	/**
	 * Генерация акта монтажа по введенным данным.
	 * Creation date: (15.10.2004 17:57:33)
	 */
	public Integer createPosition(Integer argDocument, int argOrder, Integer argVisualTagID, Integer argOwner, Integer argResource, String argSerial, String argQty, String argComment, Integer argParentPos, String argParentSerial, boolean argIBP) throws Exception {
	
			//System.out.println("MountAct2 process start");
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
					bean.setVisualtagid(argVisualTagID);
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
					//System.out.println("MountAct2 process, comment=" + argComment);
					if (argParentPos != null) {
						//System.out.println("MountAct2 process, with parent");
						DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
						dp.setInitKey_docposition(argParentPos.intValue());
						dp.refreshCopyHelper();
						bean.setAgregate((DocumentPosition)dp.getEJBRef());
						bean.setAgregateSerial(argParentSerial);
						bean.setAgregateresource(new Integer(dp.getResourceKey().resource));
						//System.out.println("MountAct2 process, resource = " + dp.getResourceKey().resource);
					}
					bean.setVisualtagid(argVisualTagID);
					bean.commitCopyHelper();
				}
				result = new Integer(docpos);
			}
			//System.out.println("MountAct2 process end");
			return result;
	}
	
	/**
	 * Генерация акта монтажа по введенным данным.
	 * Creation date: (15.10.2004 17:57:33)
	 */
	public void generateMountAct(MountAct2Form editForm, HttpServletRequest request) throws Exception {
			com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
			int doc = keyGen.getNextKey("tables.documents");
			editForm.setDocument(doc);
			StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
			blankdate.setString(editForm.getActdate());
			StringAndIntegerProperty blankindex = new StringAndIntegerProperty();
			blankindex.setString(editForm.getPosnumber());
	
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
				"",
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
			bean.setVisualtype(editForm.getVisualtype());
	
	
			bean.commitCopyHelper();

			generatePositions(doc, editForm);	
	}
	
	/**
	 * Генерация акта монтажа по введенным данным.
	 * Creation date: (15.10.2004 17:57:33)
	 */
	public void updateMountAct(MountAct2Form editForm, HttpServletRequest request) throws Exception {
			com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
			int doc = editForm.getDocument();
		    // Найдем и обновим шапку документа 
		    InternalWayBillAccessBean bean = new InternalWayBillAccessBean();
		    bean.setInitKey_document(editForm.getDocument());
		    bean.refreshCopyHelper();
			StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
			blankdate.setString(editForm.getActdate());
			StringAndIntegerProperty blankindex = new StringAndIntegerProperty();
			blankindex.setString(editForm.getPosnumber());
	
			// Определим экспедицию
			ExpeditionAccessBean exped = null;
			StringAndIntegerProperty pcode = new StringAndIntegerProperty();
			pcode.setString(editForm.getProvidercode());
			try {
				java.util.Enumeration en = new ExpeditionAccessBean().findExpeditionByOrganization(new OrganizationKey(pcode.getInteger().intValue()));
				if(en.hasMoreElements()) {
					exped = (ExpeditionAccessBean)en.nextElement();
					exped.refreshCopyHelper();
				} else {
					OrganizationAccessBean o = new OrganizationAccessBean();
					o.setInitKey_organization(pcode.getInteger().intValue());
					o.refreshCopyHelper();
					int expkey = keyGen.getNextKey("tables.storageplaces");
					exped = new ExpeditionAccessBean(expkey, null, "", "");
					exped.setOrganization((Organization)o.getEJBRef());
					exped.setExpeditor(null);
					exped.setName(o.getName());
					exped.commitCopyHelper();
				}
			} catch (Exception ee) {
				ee.printStackTrace(System.out);
			}
			
			Integer owner = editForm.getOwnercode();
			OrganizationAccessBean own = new OrganizationAccessBean();
			own.setInitKey_organization(owner.intValue());
			own.refreshCopyHelper();
			bean.setOwner((Organization)own.getEJBRef());
			Expedition ep = (Expedition)javax.rmi.PortableRemoteObject.narrow(exped.getEJBRef(), Expedition.class);
			bean.setFrom(ep); //exped,
			EquipmentSetAccessBean eab = new EquipmentSetAccessBean();
			eab.setInitKey_storageplace(editForm.getComplectcode().intValue());
			eab.refreshCopyHelper(); 
			bean.setTo((EquipmentSet)eab.getEJBRef()); // editForm.getComplectcode(),
			bean.setBlankdate(blankdate.getSqlDate());
			bean.setBlankindex(blankindex.getInteger().intValue());
			bean.setNeedapprove(editForm.isNeedapprove());
			bean.setProjectid(editForm.getProjectid());
			bean.setInsuranseMan(editForm.getInsuranceMan());
			
			StringAndIntegerProperty wrkcode = new StringAndIntegerProperty();
			wrkcode.setString(editForm.getWorkercode());
			WorkerAccessBean wrk = new WorkerAccessBean();
			wrk.setInitKey_worker(wrkcode.getInteger().intValue());
			wrk.refreshCopyHelper();
			
			bean.setMonter((Worker)wrk.getEJBRef());
			bean.setVisualtype(editForm.getVisualtype());
	
			bean.commitCopyHelper();

			deletePositions(doc);
			generatePositions(doc, editForm);	
	}
	
	// Удаление позиций документа
	protected void deletePositions(int doc) {
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeUpdate("  DELETE FROM docpositions WHERE document = ? AND agregate IS NOT NULL",
			new Object[] {new Integer(doc)});
		rs.executeUpdate("  DELETE FROM docpositions WHERE document = ?",
			new Object[] {new Integer(doc)});
	}
	
	protected void generatePositions(int doc, MountAct2Form editForm) throws Exception {
		// Создадим позиции документа
		Integer owner = editForm.getOwnercode();
		Integer document = new Integer(doc);
		int order=1;
		Integer docpos;
		docpos = createPosition(document, order++, new Integer(10), owner, editForm.getResource10(), editForm.getSerial10(), editForm.getQty10(), editForm.getComment10(), null, null, true);
		createPosition(document, 1, new Integer(20), owner, editForm.getResource20(), editForm.getSerial20(), editForm.getQty20(), editForm.getComment20(), docpos, editForm.getSerial10(), false);
		createPosition(document, 3, new Integer(30), owner, editForm.getResource30(), editForm.getSerial30(), editForm.getQty30(), editForm.getComment30(), docpos, editForm.getSerial10(), false);
		createPosition(document, order++, new Integer(40), owner, editForm.getResource40(), editForm.getSerial40(), editForm.getQty40(), editForm.getComment40(), null, null, false);
		createPosition(document, order++, new Integer(50), owner, editForm.getResource50(), editForm.getSerial50(), editForm.getQty50(), editForm.getComment50(), null, null, false);
		createPosition(document, order++, new Integer(60), owner, editForm.getResource60(), editForm.getSerial60(), editForm.getQty60(), editForm.getComment60(), null, null, false);
		createPosition(document, order++, new Integer(70), owner, editForm.getResource70(), editForm.getSerial70(), editForm.getQty70(), editForm.getComment70(), null, null, false);
		createPosition(document, order++, new Integer(75), owner, editForm.getResource75(), editForm.getSerial75(), editForm.getQty75(), editForm.getComment75(), null, null, false);
		createPosition(document, order++, new Integer(80), owner, editForm.getResource80(), editForm.getSerial80(), editForm.getQty80(), editForm.getComment80(), null, null, false);
		createPosition(document, order++, new Integer(90), owner, editForm.getResource90(), editForm.getSerial90(), editForm.getQty90(), editForm.getComment90(), null, null, false);
		createPosition(document, order++, new Integer(100), owner, editForm.getResource100(), editForm.getSerial100(), editForm.getQty100(), editForm.getComment100(), null, null, false);
		createPosition(document, order++, new Integer(110), owner, editForm.getResource110(), editForm.getSerial110(), editForm.getQty110(), editForm.getComment110(), null, null, false);
		createPosition(document, order++, new Integer(170), owner, editForm.getResource170(), editForm.getSerial170(), editForm.getQty170(), editForm.getComment170(), null, null, false);
		createPosition(document, order++, new Integer(180), owner, editForm.getResource180(), editForm.getSerial180(), editForm.getQty180(), editForm.getComment180(), null, null, false);
		createPosition(document, order++, new Integer(190), owner, editForm.getResource190(), editForm.getSerial190(), editForm.getQty190(), editForm.getComment190(), null, null, false);
		createPosition(document, order++, new Integer(200), owner, editForm.getResource200(), editForm.getSerial200(), editForm.getQty200(), editForm.getComment200(), null, null, false);
		createPosition(document, order++, new Integer(210), owner, editForm.getResource210(), editForm.getSerial210(), editForm.getQty210(), editForm.getComment210(), null, null, false);
		createPosition(document, order++, new Integer(220), owner, editForm.getResource220(), editForm.getSerial220(), editForm.getQty220(), editForm.getComment220(), null, null, false);
		createPosition(document, order++, new Integer(240), owner, editForm.getResource240(), editForm.getSerial240(), editForm.getQty240(), editForm.getComment240(), null, null, false);
		createPosition(document, order++, new Integer(250), owner, editForm.getResource250(), editForm.getSerial250(), editForm.getQty250(), editForm.getComment250(), null, null, false);
		createPosition(document, order++, new Integer(260), owner, editForm.getResource260(), editForm.getSerial260(), editForm.getQty260(), editForm.getComment260(), null, null, false);
		createPosition(document, order++, new Integer(270), owner, editForm.getResource270(), editForm.getSerial270(), editForm.getQty270(), editForm.getComment270(), null, null, false);
	}
	
	public ActionForward processInsert( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
		MountAct2Form meditForm = (MountAct2Form)editForm;
		//meditForm.setUser(request.getRemoteUser());
		//if (request.isUserInRole("administrator"))
		//	meditForm.setIsAdmin(Boolean.TRUE);
		//else
		//	meditForm.setIsAdmin(Boolean.FALSE);
		meditForm.validateValues(errors);
		generateMountAct(meditForm, request);
		ActionForward fwd = super.processInsert(mapping, request, errors, editForm);
		ActionForward retVal = null;
		if (fwd != null) {
			String sc = fwd.getPath();
			int ind = sc.indexOf("?");
			if ( ind > 0)
				sc = sc.substring(0, ind);
			sc = sc + "?action=Edit&document=" + meditForm.getDocumentId();
			retVal = new ActionForward(sc, true);
		}
		return retVal; 
	}
	
	public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm)
		throws Exception
	{
		MountAct2Form meditForm = (MountAct2Form)editForm;
		//meditForm.setUser(request.getRemoteUser());
		//meditForm.setUser(request.getRemoteUser());
		//if (request.isUserInRole("administrator"))
		//	meditForm.setIsAdmin(Boolean.TRUE);
		//else
		//	meditForm.setIsAdmin(Boolean.FALSE);
			
		String reqState = meditForm.getProcessState();
		if (!"C".equalsIgnoreCase(reqState)) {
			meditForm.validateValues(errors);
			updateMountAct(meditForm, request);
		}
		ActionForward fwd = super.processUpdate(mapping, request, errors, editForm);
		ActionForward retVal = fwd;
		if (fwd != null) {
			String sc = fwd.getPath();
			int ind = sc.indexOf("?");
			if ( ind > 0)
				sc = sc.substring(0, ind);
			if ("2".equals(meditForm.getDState()) || "P".equalsIgnoreCase(reqState)) {
				sc = sc + "?action=View&document=" + meditForm.getDocumentId();
			} else {
				sc = sc + "?action=Edit&document=" + meditForm.getDocumentId();
			}
			retVal = new ActionForward(sc, true);
		}
		return retVal;
	}

	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		MountAct2Form editForm = (MountAct2Form)form;
		editForm.setUser(request.getRemoteUser());
		if (request.isUserInRole("administrator"))
			editForm.setIsAdmin(Boolean.TRUE);
		else
			editForm.setIsAdmin(Boolean.FALSE);
		return super.perform(mapping, form, request, response);
	}
/*
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

		//is canceled
		if( isCancelled(request) ) {
			return  mapping.findForward( "errorgoback" ); 
		}

  		//process actions
  		AbstractEntityAccessBean bean = null;
		MountAct2Form editForm = (MountAct2Form)form;
	    try { 
			editForm.setReturnPage(mapping.findForward( "errorgoback" ).getPath());

			editForm.setUser(request.getRemoteUser());
			if (request.isUserInRole("administrator"))
				editForm.setIsAdmin(Boolean.TRUE);
			else
				editForm.setIsAdmin(Boolean.FALSE);
	  		
			if( editForm.getAction().equals("Add") ) {
				editForm.validateValues(errors);
				generateMountAct(editForm, request);
				String sc = mapping.findForward( "success" ).getPath();
				int ind = sc.indexOf("?");
				if ( ind > 0)
					sc = sc.substring(0, ind);
				sc = sc + "?action=Edit&doc=" + editForm.getDocument();
	  	    	retVal = new ActionForward(sc, true); 
			} else if (editForm.getAction().equals("Edit")) {
				editForm.validateValues(errors);
				updateMountAct(editForm, request);
				String sc = mapping.findForward( "success" ).getPath();
				int ind = sc.indexOf("?");
				if ( ind > 0)
					sc = sc.substring(0, ind);
				sc = sc + "?action=Edit&doc=" + editForm.getDocument();
				retVal = new ActionForward(sc, true); 
			} else if (editForm.getAction().equals("Delete")) {
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

	   // if (retVal != null)
	   // 	System.out.println("RetVal=" + retVal.getPath());
	   // else
	   // 	System.out.println("RetVal=null");
	    return retVal;    
	}
*/
}
