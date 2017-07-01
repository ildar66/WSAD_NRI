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
import com.hps.july.config.model.ReportConfig2AttrVO;
import com.hps.july.config.model.ReportConfig2VO;

/**
 * @author dima
 *
 *	����� �� ���������� ������������
 */
public class ReportConfig2 extends ReportBase {

	public ReportConfig2() {
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
	protected ReportConfig2VO parseReportConfig2VOCommon(CDBCRowObject ro) {
		ReportConfig2VO vo = new ReportConfig2VO();
		
		vo.setCategory(ro.getColumn("classname").asString());
		vo.setEquiptype(ro.getColumn("model").asString());
		vo.setComment(ro.getColumn("notes").asString());
		String policy = ro.getColumn("policy").asString();
		if ("S".equals(policy))
			vo.setPolicy("��������");
		else if ("P".equals(policy))
			vo.setPolicy("����������");
		else
			vo.setPolicy("��������������");
		vo.setQty((BigDecimal)ro.getColumn("qty").asObject());
		String isFictSerial = ro.getColumn("isfictserial").asString();
		if ("Y".equals(isFictSerial))
			vo.setSerialnumber("����������");
		else
			vo.setSerialnumber(ro.getColumn("serialnumber").asString());
		String inventserial = ro.getColumn("inventserial").asString();
		if (inventserial == null) 
			vo.setInventserial("����������");
		else
			vo.setInventserial(inventserial);
		String localserial = ro.getColumn("localserial").asString();
		if (localserial == null) 
			vo.setLocalserial("����������");
		else
			vo.setLocalserial(localserial);
			
		vo.setAttributes(new LinkedList());
		return vo;
	}
	
	/**
	 * Extract report VO fields from dataset
	 * @param ro
	 * @return
	 */
	protected ReportConfig2VO parseReportConfig2VOBsStands(CDBCRowObject ro) {
		ReportConfig2VO vo = parseReportConfig2VOCommon(ro);
		
		ReportConfig2AttrVO attrvo1 = new ReportConfig2AttrVO();
		attrvo1.setAttribute("����� �����");
		attrvo1.setValue(ro.getColumn("stnomer").asString());
		vo.getAttributes().add(attrvo1);
		
		ReportConfig2AttrVO attrvo2 = new ReportConfig2AttrVO();
		attrvo2.setAttribute("���������� ����������� � �����");
		attrvo2.setValue(ro.getColumn("trxcount").asString());
		vo.getAttributes().add(attrvo2);
		
		return vo;
	}
	
	/**
	 * Extract report VO fields from dataset
	 * @param ro
	 * @return
	 */
	protected ReportConfig2VO parseReportConfig2VOTRX(CDBCRowObject ro) {
		ReportConfig2VO vo = parseReportConfig2VOCommon(ro);
		
		ReportConfig2AttrVO attrvo1 = new ReportConfig2AttrVO();
		attrvo1.setAttribute("����� �����");
		attrvo1.setValue(ro.getColumn("stnomer").asString());
		vo.getAttributes().add(attrvo1);
		
		ReportConfig2AttrVO attrvo2 = new ReportConfig2AttrVO();
		attrvo2.setAttribute("������ � ��������� 900");
		attrvo2.setValue(ro.getColumn("sect900").asString());
		vo.getAttributes().add(attrvo2);
		
		ReportConfig2AttrVO attrvo3 = new ReportConfig2AttrVO();
		attrvo3.setAttribute("������ � ��������� 1800");
		attrvo3.setValue(ro.getColumn("sect1800").asString());
		vo.getAttributes().add(attrvo3);
		
		return vo;
	}
	
	/**
	 * Extract report VO fields from dataset
	 * @param ro
	 * @return
	 */
	protected ReportConfig2VO parseReportConfig2VOAntennes(CDBCRowObject ro) {
		ReportConfig2VO vo = parseReportConfig2VOCommon(ro);
		
		ReportConfig2AttrVO attrvo1 = new ReportConfig2AttrVO();
		attrvo1.setAttribute("������, ����");
		attrvo1.setValue(ro.getColumn("az_ant").asString());
		vo.getAttributes().add(attrvo1);
		
		ReportConfig2AttrVO attrvo2 = new ReportConfig2AttrVO();
		attrvo2.setAttribute("������ � ��������� 900");
		attrvo2.setValue(ro.getColumn("sect900").asString());
		vo.getAttributes().add(attrvo2);
		
		ReportConfig2AttrVO attrvo3 = new ReportConfig2AttrVO();
		attrvo3.setAttribute("������ � ��������� 1800");
		attrvo3.setValue(ro.getColumn("sect1800").asString());
		vo.getAttributes().add(attrvo3);
		
		ReportConfig2AttrVO attrvo4 = new ReportConfig2AttrVO();
		attrvo4.setAttribute("������ �������, �");
		attrvo4.setValue(ro.getColumn("h_set1").asString());
		vo.getAttributes().add(attrvo4);
		
		ReportConfig2AttrVO attrvo5 = new ReportConfig2AttrVO();
		attrvo5.setAttribute("������������ ������, ����");
		attrvo5.setValue(ro.getColumn("nakl").asString());
		vo.getAttributes().add(attrvo5);
		
		ReportConfig2AttrVO attrvo6 = new ReportConfig2AttrVO();
		attrvo6.setAttribute("����������");
		attrvo6.setValue(ro.getColumn("locationtype").asString());
		vo.getAttributes().add(attrvo6);
		
		ReportConfig2AttrVO attrvo7 = new ReportConfig2AttrVO();
		attrvo7.setAttribute("����� ������ � ��������� 900");
		attrvo7.setValue(ro.getColumn("kind_ant900").asString());
		vo.getAttributes().add(attrvo7);
		
		ReportConfig2AttrVO attrvo8 = new ReportConfig2AttrVO();
		attrvo8.setAttribute("����� ������ � ��������� 1800");
		attrvo8.setValue(ro.getColumn("kind_ant1800").asString());
		vo.getAttributes().add(attrvo8);
		
		return vo;
	}
	
	/**
	 * Extract report VO fields from dataset
	 * @param ro
	 * @return
	 */
	protected ReportConfig2VO parseReportConfig2VOCables(CDBCRowObject ro) {
		ReportConfig2VO vo = parseReportConfig2VOCommon(ro);
		
		ReportConfig2AttrVO attrvo2 = new ReportConfig2AttrVO();
		attrvo2.setAttribute("���� � ��������� 900");
		attrvo2.setValue(ro.getColumn("kswn900").asString());
		vo.getAttributes().add(attrvo2);
		
		ReportConfig2AttrVO attrvo3 = new ReportConfig2AttrVO();
		attrvo3.setAttribute("���� � ��������� 1800");
		attrvo3.setValue(ro.getColumn("kswn1800").asString());
		vo.getAttributes().add(attrvo3);
		
		return vo;
	}
	
	/**
	 * Extract report VO fields from dataset
	 * @param ro
	 * @return
	 */
	protected ReportConfig2VO parseReportConfig2VOOther(CDBCRowObject ro) {
		ReportConfig2VO vo = parseReportConfig2VOCommon(ro);
		
		return vo;
	}
	
	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {

		System.out.println("ReportConfig2 called");
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
		
		int index = 0;
		List summaryEquipList = new LinkedList();
		
		CDBCResultSet rs2 = CDBCConfigObject.reportBSStandsConfig(configsrc);
		Iterator it2 = rs2.listIterator();
		while (it2.hasNext()) {
			index++;
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			ReportConfig2VO vo = parseReportConfig2VOBsStands(ro);
			vo.setNumindex(new Integer(index));
			summaryEquipList.add(vo);
		}
		
		CDBCResultSet rs3 = CDBCConfigObject.reportTRXConfig(configsrc);
		Iterator it3 = rs3.listIterator();
		while (it3.hasNext()) {
			index++;
			CDBCRowObject ro = (CDBCRowObject)it3.next();
			ReportConfig2VO vo = parseReportConfig2VOTRX(ro);
			vo.setNumindex(new Integer(index));
			summaryEquipList.add(vo);
		}
		
		CDBCResultSet rs4 = CDBCConfigObject.reportAntennesConfig(configsrc);
		Iterator it4 = rs4.listIterator();
		while (it4.hasNext()) {
			index++;
			CDBCRowObject ro = (CDBCRowObject)it4.next();
			ReportConfig2VO vo = parseReportConfig2VOAntennes(ro);
			vo.setNumindex(new Integer(index));
			summaryEquipList.add(vo);
		}
		
		CDBCResultSet rs5 = CDBCConfigObject.reportCablesConfig(configsrc);
		Iterator it5 = rs5.listIterator();
		while (it5.hasNext()) {
			index++;
			CDBCRowObject ro = (CDBCRowObject)it5.next();
			ReportConfig2VO vo = parseReportConfig2VOCables(ro);
			vo.setNumindex(new Integer(index));
			summaryEquipList.add(vo);
		}
		
		CDBCResultSet rs6 = CDBCConfigObject.reportOtherConfig(configsrc);
		Iterator it6 = rs6.listIterator();
		while (it6.hasNext()) {
			index++;
			CDBCRowObject ro = (CDBCRowObject)it6.next();
			ReportConfig2VO vo = parseReportConfig2VOOther(ro);
			vo.setNumindex(new Integer(index));
			summaryEquipList.add(vo);
		}
		
		
		request.setAttribute("summaryEquipList", summaryEquipList);
		
		ActionForward ret = mapping.findForward("success");
		System.out.println("ReportConfig2 redirect to: " + ret.getPath());
		return ret;
	}
	
}
