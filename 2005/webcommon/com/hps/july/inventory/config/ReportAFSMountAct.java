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

/**
 * @author dima
 *
 *	Отчет по изменениям конфигурации
 */
public class ReportAFSMountAct extends ReportBase {
	
	protected static int MSHU_CLASS = 9;
	protected static int BOOSTER_CLASS = 34;
	protected static int FILTER_CLASS = 29;
	protected static int COMBINER_CLASS = 13;
	
	protected static int CABLE_DIAM_12 = 1; 
	protected static int CABLE_DIAM_78 = 3;
	protected static int CABLE_DIAM_114 = 5;

	public ReportAFSMountAct() {
		super();
	}
	
	protected String findAntennaResource(int config, String sector, short band) {
		String result = "";
		
		// Find antenna resources
		CDBCResultSet rs2 = CDBCConfigObject.reportAFSAntennes(config, sector, band);
		Iterator it2 = rs2.listIterator();
		String model = null;
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn("model").asString();
			boolean doAdd = false;
			if (model != null) {
				if (!model.equals(m)) {
					doAdd = true;
				}
			} else {
				doAdd = true;
			}
			if (doAdd) {
				model = m;
				if (result.trim().length() > 0)
					result = result + ", ";
				result = result + model;
			}
		}
		
		return result;
	}

	protected String findAntennaHSet(int config, String sector, short band) {
		String result = "";
		
		// Find antenna resources
		CDBCResultSet rs2 = CDBCConfigObject.reportAFSAntennes(config, sector, band);
		Iterator it2 = rs2.listIterator();
		BigDecimal hset = null;
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			BigDecimal m = (BigDecimal)ro.getColumn("h_set1").asObject();
			boolean doAdd = false;
			if (hset != null) {
				if (!hset.equals(m)) {
					doAdd = true;
				}
			} else {
				doAdd = true;
			}
			if (doAdd) {
				hset = m;
				if (result.trim().length() > 0)
					result = result + ", ";
				result = result + hset;
			}
		}
		
		return result;
	}

	protected String findAntennaAzimut(int config, String sector, short band) {
		String result = "";
		
		// Find antenna resources
		CDBCResultSet rs2 = CDBCConfigObject.reportAFSAntennes(config, sector, band);
		Iterator it2 = rs2.listIterator();
		BigDecimal azimut = null;
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			BigDecimal m = (BigDecimal)ro.getColumn("az_ant").asObject();
			boolean doAdd = false;
			if (azimut != null) {
				if (!azimut.equals(m)) {
					doAdd = true;
				}
			} else {
				doAdd = true;
			}
			if (doAdd) {
				azimut = m;
				if (result.trim().length() > 0)
					result = result + ", ";
				result = result + azimut;
			}
		}
		
		return result;
	}

	protected String findOtherEquip(int config, int classid) {
		String result = "";
		
		CDBCResultSet rs2 = CDBCConfigObject.reportOtherEquipByClass(config, classid);
		Iterator it2 = rs2.listIterator();
		String value = null;
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn("model").asString();
			String s = ro.getColumn("serialnumber").asString();
			if ( (s != null) && (s.trim().length() > 0) )
				value = m + "," + s;
			else
				value = m;
			if (result.trim().length() > 0)
				result = result + "; ";
			result = result + value;
		}
		
		return result;
	}

	/*
	protected void reportAntennaSerials(HttpServletRequest request, int config, String attrName, String sector, short band) {
		// Find antenna resources
		CDBCResultSet rs2 = CDBCConfigObject.reportAFSAntennes(config, sector, band);
		Iterator it2 = rs2.listIterator();
		String model = null;
		if (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn("serialnumber").asString();
			String sn = "ser" + attrName + "A";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		if (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn("serialnumber").asString();
			String sn = "ser" + attrName + "B";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn("serialnumber").asString();
			String sn = "ser" + attrName + "C";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		
	}
	*/
	
	protected void reportAntennaParams(String paramName, HttpServletRequest request, int config) {
		clearAntennaParams(paramName, request);
		
		reportAntennaParam(paramName, request, config, "A", "A", (short)1800);
		reportAntennaParam(paramName, request, config, "B", "B", (short)1800);
		reportAntennaParam(paramName, request, config, "C", "C", (short)1800);
		reportAntennaParam(paramName, request, config, "D", "D", (short)1800);
		reportAntennaParam(paramName, request, config, "A", "E", (short)900);
		reportAntennaParam(paramName, request, config, "B", "F", (short)900);
		reportAntennaParam(paramName, request, config, "C", "G", (short)900);
		reportAntennaParam(paramName, request, config, "D", "H", (short)900);
		
	}
	
	protected void clearAntennaParams(String paramName, HttpServletRequest request) {
		request.setAttribute(paramName + "AA", "");
		request.setAttribute(paramName + "AB", "");
		request.setAttribute(paramName + "AC", "");
		
		request.setAttribute(paramName + "BA", "");
		request.setAttribute(paramName + "BB", "");
		request.setAttribute(paramName + "BC", "");
		
		request.setAttribute(paramName + "CA", "");
		request.setAttribute(paramName + "CB", "");
		request.setAttribute(paramName + "CC", "");
		
		request.setAttribute(paramName + "DA", "");
		request.setAttribute(paramName + "DB", "");
		request.setAttribute(paramName + "DC", "");
		
	}
	
	protected void reportAntennaParam(String paramName, HttpServletRequest request, int config, String attrName, String sector, short band) {
		// Find antenna resources
		CDBCResultSet rs2 = CDBCConfigObject.reportAFSAntennes(config, sector, band);
		Iterator it2 = rs2.listIterator();
		String model = null;
		if (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn(paramName).asString();
			String sn = paramName + attrName + "A";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		if (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn(paramName).asString();
			String sn = paramName + attrName + "B";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn(paramName).asString();
			String sn = paramName + attrName + "C";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		
	}
	
	protected void setAttribute(HttpServletRequest request, String attrName, String val1, String val2) {
		//System.out.println("Setting attribute: " + attrName + ", val1=" + val1 + ", val2=" + val2);
		if (val1.equals(val2))
			request.setAttribute(attrName, val1);
		else {
			if ( (val2 == null) || (val2.trim().length() == 0) )
				request.setAttribute(attrName, val1);
			else if (val1.trim().length() > 0)
				request.setAttribute(attrName, val1 + " / " + val2);
			else
				request.setAttribute(attrName, val2);
		}
	}
	
	protected void reportCables(HttpServletRequest request, String paramName, int config, 
			Integer cableDiam, String dbcolumn) {
		clearAntennaParams(paramName, request);
		reportCableAttribute(paramName, request, config, "A", "A", (short)1800, cableDiam, dbcolumn);
		reportCableAttribute(paramName, request, config, "B", "B", (short)1800, cableDiam, dbcolumn);
		reportCableAttribute(paramName, request, config, "C", "C", (short)1800, cableDiam, dbcolumn);
		reportCableAttribute(paramName, request, config, "D", "D", (short)1800, cableDiam, dbcolumn);
		reportCableAttribute(paramName, request, config, "A", "E", (short)900, cableDiam, dbcolumn);
		reportCableAttribute(paramName, request, config, "B", "F", (short)900, cableDiam, dbcolumn);
		reportCableAttribute(paramName, request, config, "C", "G", (short)900, cableDiam, dbcolumn);
		reportCableAttribute(paramName, request, config, "D", "H", (short)900, cableDiam, dbcolumn);
	}
	
	protected String reportCableAttribute(String paramName, HttpServletRequest request, int config, 
			String attrName, String sector, short band, Integer cableDiam, String dbcolumn) {
		String result = "";
		
		CDBCResultSet rs2 = CDBCConfigObject.reportAFSCables(config, sector, band, cableDiam);
		Iterator it2 = rs2.listIterator();
		String model = null;
		Integer idantenold = null;
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			Integer idanten = (Integer)ro.getColumn("id_anten").asObject();
			if ( (idantenold != null) && (!idanten.equals(idantenold)) ) {
				idantenold = idanten;
				break;
			}
			idantenold = idanten;
			String m = ro.getColumn(dbcolumn).asString();
			String sn = paramName + attrName + "A";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			Integer idanten = (Integer)ro.getColumn("id_anten").asObject();
			if ( (idantenold != null) && (!idanten.equals(idantenold)) ) {
				idantenold = idanten;
				break;
			}
			idantenold = idanten;
			String m = ro.getColumn(dbcolumn).asString();
			String sn = paramName + attrName + "B";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			Integer idanten = (Integer)ro.getColumn("id_anten").asObject();
			if ( (idantenold != null) && (!idanten.equals(idantenold)) ) {
				idantenold = idanten;
				break;
			}
			idantenold = idanten;
			String m = ro.getColumn(dbcolumn).asString();
			String sn = paramName + attrName + "C";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		
		return result;
	}
	
	protected String reportCableType(String paramName, HttpServletRequest request, int config, String attrName, 
			String sector, short band, Integer cableDiam) {
		String result = "";
		
		CDBCResultSet rs2 = CDBCConfigObject.reportAFSCables(config, sector, band, cableDiam);
		Iterator it2 = rs2.listIterator();
		String model = null;
		if (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn("qty").asString();
			String sn = paramName + attrName + "A";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		if (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn("qty").asString();
			String sn = paramName + attrName + "B";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		while (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			String m = ro.getColumn("qty").asString();
			String sn = paramName + attrName + "C";
			setAttribute(request, sn, (String)request.getAttribute(sn), m);
		}
		
		return result;
	}

	protected String reportSectors(int config) {
		String result = "";
		
		CDBCResultSet rs2 = CDBCConfigObject.reportSectors(config);
		Iterator it2 = rs2.listIterator();
		String sectname = "";
		int count = 0;
		if (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			sectname = ro.getColumn("name_sect").asString();
			count++;
		}
		if (count == 0) {
			result = "нестандартная ориентация секторов";
		} else if (count == 1) {
			if ("O".equals(sectname))
				result = "OMNI";
			else
				result = "1 сектор";
		} else {
			result = count + " секторов";
		}
		
		return result;
	}

	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {

		System.out.println("ReportAFSMountAct called");
		request.setAttribute("repdate", getReportDate(request));
		request.setAttribute("repuser", getUserName(request));

		int document = getIntParam(request, "document");
		//int configsrc = getIntParam(request, "configsrc");
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

		setAttribute(request, "resA", findAntennaResource(configdest, "A", (short)1800), 
			findAntennaResource(configdest, "E", (short)900));		
		setAttribute(request, "resB", findAntennaResource(configdest, "B", (short)1800), 
			findAntennaResource(configdest, "F", (short)900));		
		setAttribute(request, "resC", findAntennaResource(configdest, "C", (short)1800), 
			findAntennaResource(configdest, "G", (short)900));		
		setAttribute(request, "resD", findAntennaResource(configdest, "D", (short)1800), 
			findAntennaResource(configdest, "H", (short)900));
			
		reportAntennaParams("serialnumber", request, configdest);

		setAttribute(request, "hsetA", findAntennaHSet(configdest, "A", (short)1800), 
			findAntennaHSet(configdest, "E", (short)900));		
		setAttribute(request, "hsetB", findAntennaHSet(configdest, "B", (short)1800), 
			findAntennaHSet(configdest, "F", (short)900));		
		setAttribute(request, "hsetC", findAntennaHSet(configdest, "C", (short)1800), 
			findAntennaHSet(configdest, "G", (short)900));		
		setAttribute(request, "hsetD", findAntennaHSet(configdest, "D", (short)1800), 
			findAntennaHSet(configdest, "H", (short)900));

		setAttribute(request, "azimutA", findAntennaAzimut(configdest, "A", (short)1800), 
			findAntennaAzimut(configdest, "E", (short)900));		
		setAttribute(request, "azimutB", findAntennaAzimut(configdest, "B", (short)1800), 
			findAntennaAzimut(configdest, "F", (short)900));		
		setAttribute(request, "azimutC", findAntennaAzimut(configdest, "C", (short)1800), 
			findAntennaAzimut(configdest, "G", (short)900));		
		setAttribute(request, "azimutD", findAntennaAzimut(configdest, "D", (short)1800), 
			findAntennaAzimut(configdest, "H", (short)900));
			
		setAttribute(request, "mshu", findOtherEquip(configdest, MSHU_CLASS), 
			findOtherEquip(configdest, BOOSTER_CLASS));
			
		request.setAttribute("filter", findOtherEquip(configdest, FILTER_CLASS));
		request.setAttribute("combiner", findOtherEquip(configdest, COMBINER_CLASS));

		reportAntennaParams("nakl", request, configdest);
		reportAntennaParams("kswn", request, configdest);

		reportCables(request, "cable1", configdest, new Integer(CABLE_DIAM_12), "qty");		
		reportCables(request, "cable2", configdest, new Integer(CABLE_DIAM_78), "qty");		
		reportCables(request, "cable3", configdest, new Integer(CABLE_DIAM_114), "qty");		
		reportCables(request, "cableres", configdest, null, "model");		
		
		request.setAttribute("originals", reportSectors(configdest));
		
		ActionForward ret = mapping.findForward("success");
		System.out.println("ReportAFSMountAct redirect to: " + ret.getPath());
		return ret;
	}
	
}
