/*
 * Created on 26.04.2007
 *
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import com.hps.july.config.model.ReportBTSMountActVO;

/**
 * @author dima
 *
 *	Отчет по изменениям конфигурации
 */
public class ReportBTSMountAct extends ReportBase {

	public ReportBTSMountAct() {
		super();
	}

	/**
	 * Extract report VO fields from dataset
	 * @param ro
	 * @return
	 */
	protected ReportBTSMountActVO parseReportBTSMountActVO(CDBCRowObject ro) {
		ReportBTSMountActVO vo = new ReportBTSMountActVO();
		
		vo.setEquiptype(ro.getColumn("name").asString() + ", " + ro.getColumn("model").asString());
		String policy = ro.getColumn("countpolicy").asString();
		if ("S".equals(policy))
			vo.setPolicy("Серийный");
		else if ("P".equals(policy))
			vo.setPolicy("Партионный");
		else
			vo.setPolicy("Количественный");
		vo.setQty((BigDecimal)ro.getColumn("qty").asObject());
		String isFictSerial = ro.getColumn("isfictserial").asString();
		if ("Y".equals(isFictSerial))
			vo.setSerialnumber("Неизвестен");
		else
			vo.setSerialnumber(ro.getColumn("serialnumber").asString());
		String inventserial = ro.getColumn("inventserial").asString();
		if (inventserial == null) 
			vo.setInventserial("Неизвестен");
		else
			vo.setInventserial(inventserial);
		String localserial = ro.getColumn("localserial").asString();
		vo.setComment(ro.getColumn("notes").asString());
		vo.setNfscode(ro.getColumn("nfscode").asString());
		vo.setUnitname(ro.getColumn("unitname").asString());
		
		return vo;
	}

	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {

		System.out.println("ReportBTSMountAct called");
		request.setAttribute("repdate", getReportDate(request));
		request.setAttribute("repuser", getUserName(request));

		int document = getIntParam(request, "document");
		int configsrc = getIntParam(request, "configsrc");
		int configdest = getIntParam(request, "configdest");
		
		CDBCConfigObject cfgobj = new CDBCConfigObject();
		
		CDBCResultSet rsDoc = CDBCConfigObject.loadCfgDocument(document);
		Iterator itDoc = rsDoc.listIterator();
		if (itDoc.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)itDoc.next();
			request.setAttribute("docnumber", ro.getColumn("blanknumber").asString());
			request.setAttribute("docdate", 
				new SimpleDateFormat("dd.MM.yyyy").format(ro.getColumn("blankdate").asObject()));
		}
		
		CDBCResultSet rs = CDBCConfigObject.findBSInfo(configdest);
		Iterator it = rs.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			request.setAttribute("bsnumber", ro.getColumn("number").asString());
			request.setAttribute("bsname", ro.getColumn("name").asString());
		}
		
		CDBCResultSet rs2 = CDBCConfigObject.findModifiedEquipment(configdest, "A");
		Iterator it2 = rs2.listIterator();
		List addedEquipList = new LinkedList();
		int index = 0;
		while (it2.hasNext()) {
			index++;
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			ReportBTSMountActVO vo = parseReportBTSMountActVO(ro);
			vo.setNumindex(new Integer(index));
			addedEquipList.add(vo);
		}
		request.setAttribute("addedEquipList", addedEquipList);
		ActionForward ret = mapping.findForward("success");
		System.out.println("ReportBTSMountAct redirect to: " + ret.getPath());
		return ret;
	}
	
}
