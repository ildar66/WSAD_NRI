/*
 * Created on 03.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.arenda.APPStates;
import com.hps.july.constants.Applications;
import com.hps.july.persistence.LeaseTaskStartAccessBean;
import com.hps.july.web.util.ParamsParser;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class JournalListForm extends JournalProlongationsListForm {

	/**
	 * 
	 */
	public JournalListForm() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#initBrowse(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		//super.initBrowse(mapping, request, response);
		ParamsParser.setState(request, Applications.ARENDA, APPStates.JOURNAL_LIST);
		
		try {
			LeaseTaskStartAccessBean bean = new LeaseTaskStartAccessBean();
			bean.setInitKey_taskstart(getTaskStartcode());
			bean.refreshCopyHelper();
 	 		
			setFirstDate(bean.getDate1());
			setSecondDate(bean.getDate2());
			setStartDate(new Date(bean.getStartdate().getTime()));
			if (bean.getEnddate() != null) {
				setEndDate(new Date(bean.getEnddate().getTime()));
			}
			setOperatorname(bean.getStartOperator().getMan().getFullName());
		} catch (Exception e) {
			e.printStackTrace();
			setFirstDate(null);
			setSecondDate(null);
			setStartDate(null);
			setEndDate(null);
			setOperatorname("");
		}
		
		return null;		
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getBrowseBeanName()
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.persistence.LeaseTaskJournalAccessBean";
	}

}
