package com.hps.july.arenda.formbean;

import com.hps.july.web.util.*;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.arenda.cdbcobjects.*;
import com.ibm.rmi.corba.IsA;

/**
 * Form-Bean.
 * список параметров запроса отчетов "Аренды".
 * Creation date: (20.02.2003 14:35:33)
 */
public class ArendaReport3ParamsForm extends ReportForm {
	private java.lang.String comand;
	private Report_VO report;
	/**
	 * ArendaReport3ParamsForm constructor comment.
	 */
	public ArendaReport3ParamsForm() {
		super();
		comand = "getContrArOnOtv";
		setReport(new Report_VO(comand));
		setLastVisited(true);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.02.2005 15:41:23)
	 * @return java.lang.String
	 */
	public java.lang.String getComand() {
		return comand;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.03.2005 16:21:35)
	 * @return java.lang.String
	 */
	public java.lang.String getParams() {
		return "comand="
			+ getComand()
			+ "&startdateFrm="
			+ report.getDataPeriod().getFromDateFrm()
			+ "&finishdateFrm="
			+ report.getDataPeriod().getToDateFrm()
			+ "&otv.worker="
			+ report.getOtv().getWorker();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 14:42:20)
	 * @return com.hps.july.arenda.valueobject.Report_VO
	 */
	public com.hps.july.arenda.valueobject.Report_VO getReport() {
		return report;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (20.02.2003 14:35:33)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.ARENDA_REPORT3_PARAMS;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.02.2005 15:41:23)
	 * @param newComand java.lang.String
	 */
	public void setComand(java.lang.String newComand) {
		comand = newComand;
		report.setType(new Report_VO.ReportType(comand));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 14:42:20)
	 * @param newReport com.hps.july.arenda.valueobject.Report_VO
	 */
	private void setReport(
		com.hps.july.arenda.valueobject.Report_VO newReport) {
		report = newReport;
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		Profile profile =
			(Profile) request.getSession().getAttribute(Profile.PROFILE);
		report.setCurReg(profile.getProfileAccess().getCurrRegion());
	}

}
