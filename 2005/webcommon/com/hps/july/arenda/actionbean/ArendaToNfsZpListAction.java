package com.hps.july.arenda.actionbean;

import com.hps.july.web.util.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;
import com.hps.july.arenda.*;
import com.hps.july.arenda.formbean.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.persistence2.*;
import com.hps.july.arenda.cdbcobjects.*;
import com.hps.july.cdbc.lib.*;
/**
 * Action-class "Связывает заказы на приобретение из NFS с договором аренды".
 * Creation date: (07.07.2004 14:59:17)
 * @author: Shafigullin Ildar
 */
public class ArendaToNfsZpListAction extends BrowseAction {
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
/**
 * Insert the method's description here.
 * Creation date: (07.07.2004 15:26:52)
 */
protected void addZP(ActionErrors errors, Integer idZp, Integer idMainLeaseDocument) {
	if (idZp != null && idMainLeaseDocument != null) {
		try {
			new LeaseZPAccessBean(idZp.intValue(), idMainLeaseDocument.intValue(), false);
		} catch (javax.ejb.DuplicateKeyException dke) {
			//уже есть такая запись
			System.out.println("ArendaToNfsListAction: уже есть такая запись(idZp=" + idZp + ", doc=" + idMainLeaseDocument + ")");
			dke.printStackTrace(System.out);
		} catch (Exception e) {
			String errorTxt = "ArendaToNfsListAction: ошибка создания записи(idZp=" + idZp + ", doc=" + idMainLeaseDocument + ")";
			System.out.println(errorTxt);
			//проверяем к какому договору приклеплен ZP:
			CDBCRowObject ro = CDBC_LeaseZP_Object.findLeaseZpFromIdZpNfs(idZp);
			if (ro != null) {
				String docnumber = ro.getColumn("docnumber").asString();
				java.sql.Date docdate = (java.sql.Date)ro.getColumn("docdate").asObject();
				String docdateStr = format.format(new java.util.Date(docdate.getTime()));
				errorTxt = "Заказ на приобретение уже прикреплен к договору с номером: " + docnumber + " от " + docdateStr;
			} else {
				errorTxt = "ошибка создания записи";
			}
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
			e.printStackTrace(System.out);
		}

	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2004 15:26:52)
 */
protected void deleteZP(Integer idZp, Integer idMainLeaseDocument) {
	if (idZp != null && idMainLeaseDocument != null) {
		try {
			LeaseZPAccessBean ab = new LeaseZPAccessBean();
			ab.setInitKey_idzpnfs(idZp.intValue());
			ab.setInitKey_leasedocposition(idMainLeaseDocument.intValue());
			ab.getEJBRef().remove();
		} catch (Exception e) {
			System.out.println("ArendaToNfsListAction: ошибка удаления записи(idZp=" + idZp + ", doc=" + idMainLeaseDocument + ")");
			e.printStackTrace(System.out);
		}

	}
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2004 15:26:52)
 */
protected void editIsActiveZP(Integer idZp, Integer idMainLeaseDocument) {
	if (idZp != null && idMainLeaseDocument != null) {
		try {
			LeaseZPAccessBean ab = new LeaseZPAccessBean();
			ab.setInitKey_idzpnfs(idZp.intValue());
			ab.setInitKey_leasedocposition(idMainLeaseDocument.intValue());
			ab.refreshCopyHelper();
			if (ab.getIsactive() == true)
				ab.setIsactive(false);
			else
				ab.setIsactive(true);
			ab.commitCopyHelper();
		} catch (Exception e) {
			System.out.println("ArendaToNfsListAction: ошибка установки активности записи(idZp=" + idZp + ", doc=" + idMainLeaseDocument + ")");
			e.printStackTrace(System.out);
		}

	}
}
/**
 * Process the specified HTTP request, and create the corresponding HTTP
 * response (or forward to another web component that will create it).
 * Return an <code>ActionForward</code> instance describing where and how
 * control should be forwarded, or <code>null</code> if the response has
 * already been completed.
 *
 * @param mapping The ActionMapping used to select this instance
 * @param actionForm The optional ActionForm bean for this request (if any)
 * @param request The HTTP request we are processing
 * @param response The HTTP response we are creating
 *
 * @exception IOException if an input/output error occurs
 * @exception ServletException if a servlet exception occurs
 */
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	ActionErrors errors = new ActionErrors();
	ArendaToNfsZpListForm eform = (ArendaToNfsZpListForm) form;
	try {
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		bean.setInitKey_leaseDocument(eform.getLeaseDocument());
		bean.refreshCopyHelper();
		if (bean.getMainDocument() != null) {
			Integer mainKey = bean.getMainDocument();
			bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(mainKey.intValue());
			bean.refreshCopyHelper();
		}
		setParametersFromMainLeaseDocumet(eform, bean);
	} catch (Exception e) {
		e.printStackTrace();
	}
	if (eform.getAction().equalsIgnoreCase("Add")) {
		addZP(errors, eform.getIdZpNfs(), eform.getAgreement().getO().getMainLeaseDocument());
		eform.setAction("View");
	} else if (eform.getAction().equalsIgnoreCase("Delete")) {
		deleteZP(eform.getIdZpNfs(), eform.getAgreement().getO().getMainLeaseDocument());
		eform.setAction("View");
	} else if (eform.getAction().equalsIgnoreCase("Edit")) {
		String isActive = request.getParameter("isActive.x");
		if ((isActive != null) && (Integer.parseInt(isActive) > 0)) {
			editIsActiveZP(eform.getIdZpNfs(), eform.getAgreement().getO().getMainLeaseDocument());
			eform.setAction("View");
		}
	}
	if (!errors.empty())
		saveErrors(request, errors);
	super.perform(mapping, form, request, response);
	ParamsParser.setState(request, Applications.ARENDA, APPStates.ARENDA_TO_NFS_ZP_LIST);
	return mapping.findForward("main");

}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2004 11:03:49)
 */
protected void setParametersFromMainLeaseDocumet(ArendaToNfsZpListForm eform, LeaseArendaAgreementNewAccessBean mainAB)
	throws Exception {
	eform.getAgreement().getO().setMainLeaseDocument(new Integer(mainAB.getLeaseDocument()));
	eform.getAgreement().setMainDocumentNumber(mainAB.getDocumentNumber());
	eform.getAgreement().setMainStartDate(mainAB.getStartDate());
	eform.getAgreement().setMainEndDate(mainAB.getEndDate());
	if (mainAB.getOrgCustomer() != null) {
		OrganizationVO customer = new OrganizationVO(new Integer(mainAB.getOrgCustomer().getOrganization()));
		customer.setName(mainAB.getOrgCustomer().getName());
		eform.getAgreement().setMainOrgCustomer(customer);
	}
	if (mainAB.getOrgExecutor() != null) {
		OrganizationVO executor = new OrganizationVO(new Integer(mainAB.getOrgExecutor().getOrganization()));
		executor.setName(mainAB.getOrgExecutor().getName());
		eform.getAgreement().setMainOrgExecutor(executor);
	}
	if (mainAB.getEconomist() != null) {
		WorkerVO mainEconomist = new WorkerVO(new Integer(mainAB.getEconomist().getWorker()));
		mainEconomist.setName(mainAB.getEconomist().getMan().getFullName());
		eform.getAgreement().setMainEconomist(mainEconomist);
	}
	eform.getAgreement().getO().setSumm1(mainAB.getSumm1());
	CurrencyVO curr1 = new CurrencyVO(new Integer(mainAB.getCurrency1().getCurrency()));
	curr1.setName(mainAB.getCurrency1().getShortname());
	eform.getAgreement().getO().setCurrency1(curr1);
	if (mainAB.getCurrency2() != null) {
		eform.getAgreement().getO().setSumm2(mainAB.getSumm2());
		CurrencyVO curr2 = new CurrencyVO(new Integer(mainAB.getCurrency2().getCurrency()));
		curr2.setName(mainAB.getCurrency2().getShortname());
		eform.getAgreement().getO().setCurrency2(curr2);
	}
}
}
