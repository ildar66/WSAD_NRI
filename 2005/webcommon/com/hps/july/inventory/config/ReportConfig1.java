/*
 * Created on 26.04.2007
 *
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.ReportConfig1VO;

/**
 * @author dima
 *
 *	Отчет по изменениям конфигурации
 */
public class ReportConfig1 extends ReportBase {

	public ReportConfig1() {
		super();
	}
	
	protected String getTRXEquipCount(int config, String sector, short band) {
		String result = "-";
		CDBCResultSet rs = CDBCConfigObject.findTRXEquipCount(config, sector, band);
		Iterator it = rs.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			Integer cnt = (Integer)ro.getColumn("col1").asObject();
			if ( (cnt != null) && (cnt.intValue() > 0))
				result = cnt.toString();
		}
		return result;
	}

	protected String getAntEquipCount(int config, String sector, short band) {
		String result = "-";
		CDBCResultSet rs = CDBCConfigObject.findAntEquipCount(config, sector, band);
		Iterator it = rs.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			Integer cnt = (Integer)ro.getColumn("col1").asObject();
			if ( (cnt != null) && (cnt.intValue() > 0))
				result = cnt.toString();
		}
		return result;
	}
	
	/**
	 * Extract report VO fields from dataset
	 * @param ro
	 * @return
	 */
	protected ReportConfig1VO parseReportConfig1VO(CDBCRowObject ro) {
		ReportConfig1VO vo = new ReportConfig1VO();
		
		vo.setCategory(ro.getColumn("classname").asString());
		vo.setQty((BigDecimal)ro.getColumn("qty").asObject());
		return vo;
	}
	
	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {

		System.out.println("ReportConfig1 called");
		request.setAttribute("repdate", getReportDate(request));
		request.setAttribute("repuser", getUserName(request));

		//int document = getIntParam(request, "document");
		int configsrc = getIntParam(request, "configsrc");
		//int configdest = getIntParam(request, "configdest");
		
		CDBCConfigObject cfgobj = new CDBCConfigObject();
		
		CDBCResultSet rs = CDBCConfigObject.findBSInfo(configsrc);
		Iterator it = rs.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			request.setAttribute("bsnumber", ro.getColumn("number").asString());
			request.setAttribute("bsname", ro.getColumn("name").asString());
		}
		
		request.setAttribute("trxe", getTRXEquipCount(configsrc, "E", (short)900));
		request.setAttribute("trxf", getTRXEquipCount(configsrc, "F", (short)900));
		request.setAttribute("trxg", getTRXEquipCount(configsrc, "G", (short)900));
		request.setAttribute("trxh", getTRXEquipCount(configsrc, "H", (short)900));
		request.setAttribute("trxo", getTRXEquipCount(configsrc, "O", (short)900));

		request.setAttribute("trxa", getTRXEquipCount(configsrc, "A", (short)1800));
		request.setAttribute("trxb", getTRXEquipCount(configsrc, "B", (short)1800));
		request.setAttribute("trxc", getTRXEquipCount(configsrc, "C", (short)1800));
		request.setAttribute("trxd", getTRXEquipCount(configsrc, "D", (short)1800));
		request.setAttribute("trxo1800", getTRXEquipCount(configsrc, "O", (short)1800));
		
		request.setAttribute("ante", getAntEquipCount(configsrc, "E", (short)900));
		request.setAttribute("antf", getAntEquipCount(configsrc, "F", (short)900));
		request.setAttribute("antg", getAntEquipCount(configsrc, "G", (short)900));
		request.setAttribute("anth", getAntEquipCount(configsrc, "H", (short)900));
		request.setAttribute("anto", getAntEquipCount(configsrc, "O", (short)900));

		request.setAttribute("anta", getAntEquipCount(configsrc, "A", (short)1800));
		request.setAttribute("antb", getAntEquipCount(configsrc, "B", (short)1800));
		request.setAttribute("antc", getAntEquipCount(configsrc, "C", (short)1800));
		request.setAttribute("antd", getAntEquipCount(configsrc, "D", (short)1800));
		request.setAttribute("anto1800", getAntEquipCount(configsrc, "O", (short)1800));
		
		CDBCResultSet rs2 = CDBCConfigObject.reportEquipmentTotals(configsrc);
		Iterator it2 = rs2.listIterator();
		int index = 0;
		List summaryEquipList = new LinkedList();
		while (it2.hasNext()) {
			index++;
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			ReportConfig1VO vo = parseReportConfig1VO(ro);
			vo.setNumindex(new Integer(index));
			summaryEquipList.add(vo);
		}
		request.setAttribute("summaryEquipList", summaryEquipList);
		
		ActionForward ret = mapping.findForward("success");
		System.out.println("ReportConfig1 redirect to: " + ret.getPath());
		return ret;
	}
	
}
