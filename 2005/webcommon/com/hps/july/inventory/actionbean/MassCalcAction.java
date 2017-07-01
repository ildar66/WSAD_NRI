package com.hps.july.inventory.actionbean;

import javax.ejb.*;
import java.util.*;
import com.ibm.ivj.ejb.runtime.AbstractAccessBean;
import com.hps.july.inventory.sessionbean.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.inventory.*;
import com.hps.july.constants.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.inventory.formbean.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;


/**
 * Обработчик массого обсчёта документов.
 * Создаёт Thread для обработки.
 * Если такой тред уже запущен выдёт результаты его работы.
 */
public class MassCalcAction extends com.hps.july.web.util.ReportAction {
	public static final String CALC_THREAD_NAME = "com.hps.july.inventory.masscalc";
/**
 * 
 * @param sb java.lang.StringBuffer
 * @param app java.lang.String
 */
public void appendCommaString(StringBuffer sb, String app) {
	if(sb == null) return;
	if(app != null) {
		if(sb.length() > 0) {
			sb.append(",");
		}
		sb.append(app);
	}
}
public void log(Exception e) {
	System.out.println(">>MASSCALC> EXCEPTION:"+e.getClass().getName());
//	e.printStackTrace(System.out);
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
  	ParamsParser.setState( request, Applications.INVENTORY, APPStates.MASSCALC );
  	MassCalcThread mct = null;
  	boolean startnew = false;

	MassCalcParamsForm frm = (MassCalcParamsForm)request.getSession().getAttribute("MassCalcParamsForm");
	
  	if(request.getSession().getAttribute(CALC_THREAD_NAME) == null) {
	  	startnew = true;
  	}
  	
  	if(startnew) {
		try {
			mct = processMasscalc(frm);
			if(mct != null) {
				Thread t = new Thread(mct,CALC_THREAD_NAME);
				t.start();
				request.getSession().setAttribute(CALC_THREAD_NAME,mct);
			}
		} catch(Exception e) {
			log(e);
		}
  	} else {
		if(request.getSession().getAttribute(CALC_THREAD_NAME) != null) {
		  	mct = (MassCalcThread)request.getSession().getAttribute(CALC_THREAD_NAME);
		}
  	}

  	if(mct != null) {
	  	if(request.getParameter("action") != null && "Finish".equals(request.getParameter("action"))) {
		  	mct.finish();
			while(!mct.isFinished()) {;}
			request.setAttribute("masscalc_interrupted", new Integer(0));
	  	}
		request.setAttribute("masscalc_overall", new Integer(mct.getDocuments().size()));
		request.setAttribute("masscalc_processed", new Integer(mct.getDocsProcessed()));
		request.setAttribute("masscalc_errors", new Integer(mct.getDocsError()));
		request.setAttribute("masscalc_doclist", mct.getResults().elements());
	  	if(!mct.isFinished()) {
			request.setAttribute("masscalc_needrefresh",new Object());
	  	} else {
		  	request.removeAttribute("masscalc_needrefresh");
	  	}
  	} else {
		request.setAttribute("masscalc_overall", new Integer(0));
		request.setAttribute("masscalc_processed", new Integer(0));
		request.setAttribute("masscalc_errors", new Integer(0));
	  	request.removeAttribute("masscalc_needrefresh");
  	}
  	
	super.perform( mapping, form, request, response );
	return mapping.findForward( "main" );
}
public MassCalcThread processMasscalc(MassCalcParamsForm frm)
	throws java.lang.Exception
{
//	ArrayList docl = new ArrayList();
	StringBuffer docstypes = new StringBuffer();
	
//	String[] docst = {
//		"WS","TS","NS","OS","ISS","ASA","ASS","PPP","PSS","P","H","HSS","TP",	"NP","APA","APD","IPP","HPP" 
//	};

	CDBCDocuments cdbcd = new CDBCDocuments();	
	Boolean isOwner = frm.getIsowner();
	if(isOwner == null) isOwner = Boolean.FALSE;
	else {
		isOwner = (isOwner.booleanValue()?Boolean.FALSE:Boolean.TRUE);
	}
	Integer owner = frm.getOwner();
	if(owner == null) owner = new Integer(0);
	String storagetype = frm.getStoragetype();
	Integer storage = null;
	if("1".equals(frm.getStoragetype())) {
		storage = frm.getPosition();
	} else if("2".equals(frm.getStoragetype())) {
		storage = frm.getStorage();
	} else if("3".equals(frm.getStoragetype())) {
		storage = frm.getWorker();
	} else if("4".equals(frm.getStoragetype())) {
		storage = frm.getOrganization();
	} else {
		storage = new Integer(0);
	}
	java.sql.Date datefrom = frm.getDatefrom();
	java.sql.Date dateto = frm.getDateto();

	boolean allStorage = frm.getIncSAll().booleanValue() || frm.getIncAll().booleanValue();
	boolean allPosition = frm.getIncPAll().booleanValue() || frm.getIncAll().booleanValue();
	boolean[] docs = new boolean[15];
	docs[0] = frm.getIncSExternal().booleanValue();
	if(allStorage || docs[0]) {
		appendCommaString(docstypes,"'WS'");
	}
	docs[1] = frm.getIncSInternal().booleanValue();
	if(allStorage || docs[1]) {
		appendCommaString(docstypes,"'TS'");
	}
	docs[2] = frm.getIncSInternalr().booleanValue();
	if(allStorage || docs[2]) {
		appendCommaString(docstypes,"'NS'");
	}
	docs[3] = frm.getIncSExternalr().booleanValue();
	if(allStorage || docs[3]) {
		appendCommaString(docstypes,"'OS'");
	}
	docs[4] = frm.getIncSInvact().booleanValue();
	if(allStorage || docs[4]) {
		appendCommaString(docstypes,"'ISS'");
	}
	docs[5] = frm.getIncSAssactb().booleanValue();
	if(allStorage || docs[5]) {
		appendCommaString(docstypes,"'ASSA','ASA'");
	}
	docs[6] = frm.getIncSDassactb().booleanValue();
	if(allStorage || docs[6]) {
		appendCommaString(docstypes,"'ASSD','ASD'");
	}
	docs[7] = frm.getIncSPayoff().booleanValue();
	if(allStorage || docs[7]) {
		appendCommaString(docstypes,"'PS'");
	}
	docs[8] = frm.getIncSChange().booleanValue();
	if(allStorage || docs[8]) {
		appendCommaString(docstypes,"'H','HSS'");
	}

	docs[9] = frm.getIncPAssact().booleanValue();
	if(allPosition || docs[9]) {
		appendCommaString(docstypes,"'TP','BP'");
	}
	docs[10] = frm.getIncPDassact().booleanValue();
	if(allPosition || docs[10]) {
		appendCommaString(docstypes,"'NP'");
	}
	docs[11] = frm.getIncPAssactb().booleanValue();
	if(allPosition || docs[11]) {
		appendCommaString(docstypes,"'APA'");
	}
	docs[12] = frm.getIncPDassactb().booleanValue();
	if(allPosition || docs[12]) {
		appendCommaString(docstypes,"'APD'");
	}
	docs[13] = frm.getIncPInvact().booleanValue();
	if(allPosition || docs[13]) {
		appendCommaString(docstypes,"'IPP'");
	}
	docs[14] = frm.getIncPChange().booleanValue();
	if(allPosition || docs[14]) {
		appendCommaString(docstypes,"'HPP','HP'");
	}

	Vector v = new Vector();
	Iterator it;
	ProcessorFacadeAccessBean pf = new ProcessorFacadeAccessBean();
	Integer curdoc = null;
	CDBCInventoryCalcObject co = new CDBCInventoryCalcObject();
	// Calculate documents
	try {
		int docscalcs = 0;
//		for(int i = 0; i < 15; i++) {
//			docscalcs = 0;
//			if(docs[i]) {
		String dt = docstypes.toString();
System.out.println("DOCTYPES:"+dt);
		if(dt != null && "".equals(dt.trim())) {
			dt = null;
		}
		it = co.findDocuments2Process(datefrom,dateto,(isOwner.booleanValue()?owner:null),storagetype,storage,dt,new Integer(0));
				//findDocuments(datefrom, dateto, isOwner, owner, storagetype, storage, docst[i]);
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
					// Fields:
					// documentid, doctype, docnumber, docdate, storage, getFullstoragename(storage) spname, opname
			int docid = ((Number)ro.getColumn("documentid").asObject()).intValue();
			String docnumber = ro.getColumn("docnumber").asString();
			java.sql.Date docdate = (java.sql.Date)ro.getColumn("docdate").asObject();
			MassCalcResultItem ri = new MassCalcResultItem();
			ri.setDocId(docid);
			ri.setDocNumber(docnumber);
			ri.setDocDate(docdate);
			ri.setDocType(ro.getColumn("doctype").asString());
			ri.setStoragename(ro.getColumn("spname").asString()); //cdbcd.getFullStorageName(sp));
			ri.setEnteror(ro.getColumn("opname").asString());
			ActionErrors errors = new ActionErrors();
			ri.setErrors(errors);
			ri.setState(0);
System.out.println("AddDoc["+ri.getDocType()+"]:"+docid+" "+ri.getDocNumber()+" of "+ri.getDocDate()+". /"+ri.getStoragename()+"/ "+ri.getEnteror());
			v.add(ri);
			if(frm.getMaxcount().getInteger() != null && v.size() >= frm.getMaxcount().getInteger().intValue()) {
				throw new ArrayIndexOutOfBoundsException(null);
			}
		}
//			}
//		}
	} catch(ArrayIndexOutOfBoundsException ae) {
		if(ae.getMessage() != null) {
			log(ae);
		}
	} catch(Exception e) {
		log(e);
	}
	MassCalcThread mct = null;
	
	if(v != null && !v.isEmpty()) {
		mct = new MassCalcThread();
		mct.setDocuments(v);
		mct.setDetailed("D".equals(frm.getProtocol()));
	}
	return mct;
}
}
