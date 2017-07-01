package com.hps.july.arenda.actionbean;

import java.sql.*;
import com.hps.july.commonbean.*;
import java.util.*;
import java.sql.Date;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.persistence.*;
import com.hps.july.arenda.formbean.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.arenda.*;
import com.hps.july.constants.*;
import java.net.*;
/**
 * Action-class.
 * действие для "вычисление истории отчетов"
 * Creation date: (05.06.2003 15:19:28)
 * @author: Sergey Gourov
 */
public class ShowCalcHistoryReportAction extends com.hps.july.web.util.NavigatedAction {
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 11:55:09)
 */
private static void clearPartOfDate(final Calendar c) {
	c.clear(Calendar.HOUR);
	c.clear(Calendar.MINUTE);
	c.clear(Calendar.SECOND);
	c.clear(Calendar.MILLISECOND);
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	CalcHistoryForm oform = (CalcHistoryForm) form;
	int codeTask = 0;
	int baseContract = 0;
	
	int operator = 1; // only for wte!!! set operator = 0 for ws!!!
	try {
		operator = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName()).getOperator();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	GregorianCalendar cFrom = new GregorianCalendar();
	GregorianCalendar cTo = new GregorianCalendar();
	String forward = "", forwardOnError = "";	
	
	try {
		JournalAccessBean journal = new JournalAccessBean();
		codeTask = journal.taskStart(operator, "9");
		
		baseContract = new LeaseArendaAgreementProcessorAccessBean().getBaseContract(oform.getLeaseDocument());
		
		if ("1".equals(oform.getCountRecord())) {
			NamedValueAccessBean nvBean = new NamedValueAccessBean();
			nvBean.setInitKey_id("ARENDA_MIN_DATE");
			nvBean.refreshCopyHelper();
			
			cFrom.setTime(nvBean.getDatevalue());
			
			nvBean = new NamedValueAccessBean();
			nvBean.setInitKey_id("ARENDA_MAX_DATE");
			nvBean.refreshCopyHelper();
			
			cTo.setTime(nvBean.getDatevalue());
		} else if ("2".equals(oform.getCountRecord())) {
			cFrom.set(Calendar.MONTH, cFrom.getMinimum(Calendar.MONTH));
			cFrom.set(Calendar.DAY_OF_MONTH, cFrom.getMinimum(Calendar.DAY_OF_MONTH));
		} else if ("3".equals(oform.getCountRecord())) {
			cFrom.add(Calendar.YEAR, -1);
		}
		
		String s = "";
		if ("1".equals(oform.getReportType())) {
			s = "Short";
		} else if ("2".equals(oform.getReportType())) {
			s = "Full";
		}
		
		forward = "../crystalclear/HistoryDogovor" + s + ".rpt?dll=pdsaccdog.dll&prompt0=" + baseContract +
			"&prompt1=Date(" + cFrom.get(Calendar.YEAR) + "," + (cFrom.get(Calendar.MONTH) + 1) + "," + cFrom.get(Calendar.DAY_OF_MONTH) +
			")&prompt2=Date(" + cTo.get(Calendar.YEAR) + "," + (cTo.get(Calendar.MONTH) + 1) + "," + cTo.get(Calendar.DAY_OF_MONTH) + ")";
		forwardOnError = "/" + URLEncoder.encode(forward);
		
		// всю цепочку договоров
		Vector v = new Vector();
		
		LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
		laanBean.setInitKey_leaseDocument(baseContract);
		laanBean.refreshCopyHelper();
		if (laanBean.getContractState().equals("B")) {
			v.addElement(new Integer(baseContract));
		}
		
		Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(
			new Integer(baseContract),	// java.lang.Integer mainLeaseDocument
			new Boolean(false), null,	// java.lang.Boolean isIsActive, java.lang.Boolean isActive
			new Boolean(true), "B",		// java.lang.Boolean isContractState, String contractState
			new Integer(1));			// java.lang.Integer order
		while (e.hasMoreElements()) {
			laanBean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			v.addElement(new Integer(laanBean.getLeaseDocument()));
		}
		
		e = new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
		while (e.hasMoreElements()) {
			ResourceAccessBean rBean = (ResourceAccessBean) e.nextElement();
			
			Enumeration en = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
				new Integer(baseContract), new Integer(rBean.getResource()));
			while (en.hasMoreElements()) {
				LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) en.nextElement();
				if (lsBean.getIstemp().booleanValue()) {
					if (lsBean.getAct() != null) {
						int actCode = lsBean.getActKey().leaseDocument;
						new ArendaTransactionMethodAccessBean().rollbackCalcAct(new Integer(actCode), codeTask);
						LeaseMutualActInfoAccessBean lmaiBean = new LeaseMutualActInfoAccessBean();
						lmaiBean.setInitKey_leasedocument(actCode);
						lmaiBean.refreshCopyHelper();
						lmaiBean.getEJBRef().remove();

						LeaseMutualActNewAccessBean lmaBean = new LeaseMutualActNewAccessBean();
						lmaBean.setInitKey_leaseDocument(actCode);
						lmaBean.refreshCopyHelper();
						try {
							lmaBean.getEJBRef().remove();
						} catch (Exception ex) {
							journal.addMsgInJournal(codeTask, "E", "Невозможно удалить временный акт, код акта - " + actCode);
						}
					} else {
						journal.addMsgInJournal(codeTask, "E", "Отсутствует акт у временного сальдо, код договора - " + baseContract);
					}
				}
			}
		}
		
		e = new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
		while (e.hasMoreElements()) {
			ResourceAccessBean rBean = (ResourceAccessBean) e.nextElement();
			
			Enumeration en = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
				new Integer(baseContract), new Integer(rBean.getResource()));
			if (en.hasMoreElements()) {
				LeaseSaldoAccessBean lsBean = (LeaseSaldoAccessBean) en.nextElement();
				if (lsBean.getIstemp().booleanValue()) {
					journal.addMsgInJournal(codeTask, "E", "Не рассчитано временное сальдо, т.к. осталось не удаленным временное " +
						"сальдо от предыдущего расчета (код договора = " + baseContract +")");
				} else {
					GregorianCalendar cStart = new GregorianCalendar();
					cStart.setTime(lsBean.getSalDate());
					cStart.add(Calendar.DAY_OF_MONTH, 1);
					Date dStart = new Date(cStart.getTime().getTime());
					
					GregorianCalendar cEnd = new GregorianCalendar();
					clearPartOfDate(cEnd);
					Date dEnd = new Date(cEnd.getTime().getTime());
					
					boolean isExistDocPos = false;
					Enumeration enum = new LeaseDocPositionAccessBean().findByQBE5(
						new Boolean(true), new Integer(baseContract),	// Boolean isLeaseContract, Integer leaseContract
						new Boolean(true), dStart, dEnd,				// Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate
						new Boolean(true), new Integer(rBean.getResource()),	// Boolean isResource, Integer resource
						new Boolean(true), new String[] { "N", "C" },	// Boolean isDocposvid, String[] docposvid
						new Integer(1));								// java.lang.Integer order
					if (enum.hasMoreElements()) {
						isExistDocPos = true;
					}
					
					int i = 0;
					int reglamentCode = 0;
					enum = new LeaseMutualReglamentAccessBean().findByResourceContractMaxDateStart(new Integer(rBean.getResource()), new Integer(baseContract));
					while (enum.hasMoreElements()) {
						LeaseMutualReglamentAccessBean lmrBean = (LeaseMutualReglamentAccessBean) enum.nextElement();
						reglamentCode = lmrBean.getLeaseDocument();
						i++;
					}
					
					if (i > 1 && isExistDocPos) {
						journal.addMsgInJournal(codeTask, "E", "Для договора " + baseContract + " и услуги " + rBean.getResource() + " найдено несколько активных регламентов");
					} else if (i == 0 && isExistDocPos) {
						journal.addMsgInJournal(codeTask, "E", "Для договора " + baseContract + " и услуги " + rBean.getResource() + " НЕ найдено ни одного активного регламента");
					} else if (i == 1) {
						// удаляю временные акты, которые относятся к регламенту
						enum = new LeaseMutualActNewAccessBean().findLeaseMutualActNewByLeaseMutualReglament(new LeaseDocumentKey(reglamentCode));
						while (enum.hasMoreElements()) {
							LeaseMutualActNewAccessBean lmanBean = (LeaseMutualActNewAccessBean) enum.nextElement();
							if (lmanBean.getIstemp()) {
								try {
									LeaseMutualActInfoAccessBean lmaiBean = new LeaseMutualActInfoAccessBean();
									lmaiBean.setInitKey_leasedocument(lmanBean.getLeaseDocument());
									lmaiBean.refreshCopyHelper();
									
									lmaiBean.getEJBRef().remove();
								} catch (Exception ex) {}
								try {
									lmanBean.getEJBRef().remove();
								} catch (Exception ex) {
									journal.addMsgInJournal(codeTask, "E", "Невозможно удалить временный акт, код - " + lmanBean.getLeaseDocument());
								}
							}
						}
						
						int actCode = new KeyGeneratorAccessBean().getNextKey("tables.leasedocuments");
						LeaseMutualActNewAccessBean lmanBean = new LeaseMutualActNewAccessBean(
							actCode,													// argLeaseDocument int
							new Date(new GregorianCalendar().getTime().getTime()),		// argDocDate java.sql.Date
							"temp_" + actCode,											// argDocNumber java.lang.String
							new Integer(reglamentCode),									// argLeaseMutualReglament java.lang.Integer
							"O",														// argState java.lang.String
							dStart,														// actstartdate java.sql.Date
							dEnd,														// actenddate java.sql.Date
							true);														// argIsTemp boolean
						lmanBean.setFooter("");
						lmanBean.setHeader("");
						lmanBean.commitCopyHelper();
						
						LeaseMutualActInfoAccessBean lmaiBean = new LeaseMutualActInfoAccessBean(actCode);
						lmaiBean.setLastcalctime(new Timestamp(new GregorianCalendar().getTime().getTime()));
						lmaiBean.refreshCopyHelper();
						
						new CalculateArendaActAccessBean().calcAct(new Integer(actCode), operator, null, codeTask);
					}
				}
			} else {
				journal.addMsgInJournal(codeTask, "E", "Нет сальдо, код договора - " + baseContract);
			}
		}
		
		journal.taskEnd(codeTask);
		
		e = new LeaseTaskJournalAccessBean().findByTaskStartOrderByJrndateAscAndTaskjournalAsc(new Integer(codeTask),
			new Boolean(true), new Boolean(true), new Boolean(false));
		if (e.hasMoreElements()) {
			// go error screen
			return new ActionForward("ShowErrorCalcHistoryList.do?taskStartcode=" + codeTask + "&reportUrl=" + forwardOnError, true);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return new ActionForward("ShowErrorCalcHistoryList.do?taskStartcode=" + codeTask + "&reportUrl=" + forwardOnError, true);
	}
	
	// go report
	return new ActionForward(forward, true);
}
}
