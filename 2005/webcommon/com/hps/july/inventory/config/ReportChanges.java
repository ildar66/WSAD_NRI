/*
 * Created on 26.04.2007
 *
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.hps.july.cdbc.objects.CDBCOperatorObject;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.ReportChangesVO;
import com.hps.july.web.util.StringAndIntegerProperty;

/**
 * @author dima
 *
 *	Отчет по изменениям конфигурации
 */
public class ReportChanges extends ReportBase {

	public ReportChanges() {
		super();
	}
	
	/**
	 * Extract report VO fields from dataset
	 * @param ro
	 * @return
	 */
	protected ReportChangesVO parseReportAttributeChangesVO(CDBCRowObject ro) {
		ReportChangesVO vo = new ReportChangesVO();

		vo.setSection(ro.getColumn("col1").asString());
		vo.setLine((Integer)ro.getColumn("col2").asObject());
		vo.setCategory(ro.getColumn("col3").asString());
		vo.setEquiptype(ro.getColumn("col4").asString());
		vo.setAttribute(ro.getColumn("col5").asString());
		vo.setOldvalue(ro.getColumn("col6").asString());
		vo.setNewvalue(ro.getColumn("col7").asString());
		
		return vo;
	}
	
	/**
	 * Extract report VO fields from dataset
	 * @param ro
	 * @return
	 */
	protected ReportChangesVO parseReportChangesVO(CDBCRowObject ro) {
		ReportChangesVO vo = new ReportChangesVO();
		
		vo.setCategory(ro.getColumn("classname").asString());
		vo.setEquiptype(ro.getColumn("model").asString());
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
		if (localserial == null) 
			vo.setLocalserial("Неизвестен");
		else
			vo.setLocalserial(localserial);
		vo.setStandno(ro.getColumn("btsnum").asString());
		vo.setSectors900(ro.getColumn("sect900").asString());
		vo.setSectors1800(ro.getColumn("sect1800").asString());
		
		return vo;
	}

	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {
		
		System.out.println("ReportChanges called");
		
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
			ReportChangesVO vo = parseReportChangesVO(ro);
			vo.setNumindex(new Integer(index));
			addedEquipList.add(vo);
		}
		request.setAttribute("addedEquipList", addedEquipList);
		
		CDBCResultSet rs3 = CDBCConfigObject.findModifiedEquipment(configdest, "D");
		Iterator it3 = rs3.listIterator();
		List deletedEquipList = new LinkedList();
		index = 0;
		while (it3.hasNext()) {
			index++;
			CDBCRowObject ro = (CDBCRowObject)it3.next();
			ReportChangesVO vo = parseReportChangesVO(ro);
			vo.setNumindex(new Integer(index));
			deletedEquipList.add(vo);
		}
		request.setAttribute("deletedEquipList", deletedEquipList);
		
		CDBCResultSet rs4 = CDBCConfigObject.findModifiedAttributes(configsrc, configdest);
		Iterator it4 = rs4.listIterator();
		List updatedEquipList = new LinkedList();
		index = 0;
		while (it4.hasNext()) {
			index++;
			CDBCRowObject ro = (CDBCRowObject)it4.next();
			ReportChangesVO vo = parseReportAttributeChangesVO(ro);
			vo.setNumindex(new Integer(index));
			updatedEquipList.add(vo);
		}
		request.setAttribute("updatedEquipList", updatedEquipList);
		
		//response.sendError(response.SC_INTERNAL_SERVER_ERROR, result);
		System.out.println("ReportChanges forwarding to JSP");
		return mapping.findForward("success");  
	}
	
}
