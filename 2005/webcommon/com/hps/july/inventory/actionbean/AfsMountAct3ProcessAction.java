package com.hps.july.inventory.actionbean;

import com.hps.july.persistence.*;
import com.hps.july.inventory.sessionbean.*;
import com.hps.july.inventory.formbean.*;
import com.hps.july.logic.VisualDocTypes;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import javax.naming.*;
import javax.ejb.*;
import java.util.Enumeration;
import java.util.ArrayList;
import com.ibm.ivj.ejb.runtime.AccessBeanEnumeration;
import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.constants.*;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.PropertyUtils;

/**
 * Обработчик формы редактирования позиции "Внешнего приходного ордера"
 * При добавлении нескольких серийных позиций осуществляет переход на 
 * форму редактирования серийных номеров.
 * При удалении серийной позиции удаляет все записи с номерами
 */
public class AfsMountAct3ProcessAction extends NIDocumentProcessAction {
	private class AntennCodes {
		Integer ant1;
		Integer ant2;
		Integer ant3;
		Integer cable1;
		Integer cable2;
		Integer cable3;
	}
/**
 * Создание строки акта монтажа АФС - антена.
 * Creation date: (15.10.2004 17:57:33)
 * Номер антены вычисляется следующим образом:
 *   1-а цифра - по номеру сектора
 *   2-я цифра порядковый номер антены в секторе (для двухдиапазонных антенн берется младший номер)
 */
public int createAntena(Integer argDocument, int argOrder, Integer argOwner, Integer argResource, 
			String argSerial, String argQty, boolean argSectorA, boolean argSectorB, boolean argSectorC, 
			boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO, boolean argSectorO1800,
			String argAntNumSecondDigit, String argNakl, String argAzimut, String argHset,
			int argVisualTagId, int argVisualTagBase) throws Exception {

		String [][] sectGSM = new String [][] { {"A", "1"}, {"B", "2"}, {"C", "3"}, {"D", "4"}, {"O1800", "0"},
			{"E", "5"}, {"F", "6"}, {"G", "7"}, {"H", "8"}, {"O", "9"} };
		
		int docpos = 0;
		StringAndBigDecimalProperty qty = new StringAndBigDecimalProperty();
		qty.setString(argQty);
		if (  (argResource != null)   &&   ( ( (argSerial != null) && (!"".equals(argSerial.trim()))  )  || (!qty.isEmpty()) )  ) {
			com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
			docpos = keyGen.getNextKey("tables.docpositions");

			String policy = "";
			// найдем ресурс			
			try {
				int bi = argResource.intValue();
				ResourceAccessBean res = new ResourceAccessBean();
				res.setInitKey_resource(bi);
				res.refreshCopyHelper();
				policy = res.getCountpolicy();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
			if ("S".equals(policy)	|| "P".equals(policy)) {
				qty.setString("1");
			} else {
				qty.setString(argQty);
			}

			//System.out.println("GEN ANT: serial=" + argSerial + ", qty=" + qty.getBigDecimal());

			// Создадим позицию документа
			//System.out.println("Before CrAnt: docpos=" + docpos + ", argResource=" + argResource + ",argowner=" + argOwner +
			//	", document = " + argDocument + ", order=" + argOrder + ", qty=" + qty.getBigDecimal());
			AfsMountPosAccessBean bean = new AfsMountPosAccessBean(
				docpos,
				argResource,
				argOwner,
				argDocument,
				argOrder,
				qty.getBigDecimal(),
				new java.math.BigDecimal(0),   // Price
				Boolean.FALSE, Boolean.FALSE, // Boxed
				Boolean.FALSE, Boolean.FALSE, // Broken
				Boolean.FALSE, Boolean.FALSE // Closed
			);
			
			if ("S".equals(policy)) {
				bean.setSerialnumber(argSerial);
			} else if ("P".equals(policy)) {
				bean.setParty(argSerial);
			}
			bean.setNewplace("-");
			bean.setComment(null);
			bean.setDocpostype("A");  // GSM антена
			qty.setString(argHset);
			bean.setH_set1(qty.getBigDecimal());
			
			// Вычислим первую цифру номера антены
			//  Выберем наименьший из возможных номеров
			String antnum = "";
			if (argSectorO) antnum = "9";
			if (argSectorH) antnum = "8";
			if (argSectorG) antnum = "7";
			if (argSectorF) antnum = "6";
			if (argSectorE) antnum = "5";
			if (argSectorD) antnum = "4";
			if (argSectorC) antnum = "3";
			if (argSectorB) antnum = "2";
			if (argSectorA) antnum = "1";
			if (argSectorO1800) antnum = "0";
			bean.setNum_ant(antnum + argAntNumSecondDigit);

			bean.setKind_ant("D"); // Приемно-передающая антенна

			qty.setString(argNakl);
			bean.setNakl(qty.getBigDecimal());
			
			qty.setString(argAzimut);
			bean.setAz_ant(qty.getBigDecimal());

			bean.setSectorA(new Boolean(argSectorA));
			bean.setSectorB(new Boolean(argSectorB));
			bean.setSectorC(new Boolean(argSectorC));
			bean.setSectorD(new Boolean(argSectorD));
			bean.setSectorE(new Boolean(argSectorE));
			bean.setSectorF(new Boolean(argSectorF));
			bean.setSectorG(new Boolean(argSectorG));
			bean.setSectorH(new Boolean(argSectorH));
			bean.setSectorO(new Boolean(argSectorO));
			bean.setSectorO1800(new Boolean(argSectorO1800));
			
			bean.setVisualtagid(new Integer(argVisualTagId + argVisualTagBase));
			bean.commitCopyHelper();
		}
		return docpos;
}
/**
 * Создание строки акта монтажа АФС - кабель.
 * Creation date: (15.10.2004 17:57:33)
 */
public Integer createCable(Integer argParentPos, Integer argDocument, int argOrder, Integer argOwner, Integer argResource, 
			String argSerial, String argQty, boolean argSectorA, boolean argSectorB, boolean argSectorC, 
			boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO, boolean argSectorO1800,
			Integer argGroudResource, String argGroundCnt, String argKsvn,
			int argVisualTagId, int argVisualTagBase) throws Exception {

		int docpos = 0;
		String policy = "";
		// найдем ресурс
		if (argResource != null) {
			try {
				int bi = argResource.intValue();
				ResourceAccessBean res = new ResourceAccessBean();
				res.setInitKey_resource(bi);
				res.refreshCopyHelper();
				policy = res.getCountpolicy();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			StringAndBigDecimalProperty qty = new StringAndBigDecimalProperty();
			if ("S".equals(policy)	|| "P".equals(policy)) {
				qty.setString("1");
			} else {
				qty.setString(argQty);
			}
			if ((argResource != null) && qty.isOk() && !qty.isEmpty() )  {
				com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
				docpos = keyGen.getNextKey("tables.docpositions");

				
				//System.out.println("GEN CABLE: serial=" + argSerial + ", qty=" + qty.getBigDecimal());
				
				// Создадим позицию документа
				AfsMountPosAccessBean bean = new AfsMountPosAccessBean(
					docpos,
					argResource,
					argOwner,
					argDocument,
					argOrder,
					qty.getBigDecimal(),
					new java.math.BigDecimal(0),   // Price
					Boolean.FALSE, Boolean.FALSE, // Boxed
					Boolean.FALSE, Boolean.FALSE, // Broken
					Boolean.FALSE, Boolean.FALSE // Closed
				);
				
				if ("S".equals(policy)) {
					bean.setSerialnumber(argSerial);
				} else if ("P".equals(policy)) {
					bean.setParty(argSerial);
				}
				bean.setNewplace("-");
				bean.setComment(null);
				bean.setDocpostype("C");  // GSM кабель
				bean.setParentdocpos(argParentPos);
				bean.setLen_cable(qty.getBigDecimal());

				if (argGroudResource != null) {
					try {
						ResourceAccessBean res = new ResourceAccessBean();
						res.setInitKey_resource(argGroudResource.intValue());
						res.refreshCopyHelper();
						bean.setGroundresource((Resource)res.getEJBRef());
					} catch (Exception e) {
						e.printStackTrace(System.out);
					}
				}

				StringAndIntegerProperty si = new StringAndIntegerProperty();
				si.setString(argGroundCnt);
				bean.setGroundcnt(si.getInteger());

				qty.setString(argKsvn);
				if (argSectorA || argSectorB || argSectorC || argSectorD || argSectorO1800)
					bean.setKsvn1800(qty.getBigDecimal());
				if (argSectorE || argSectorF || argSectorG || argSectorH || argSectorO)
					bean.setKsvn900(qty.getBigDecimal());
				
				bean.setVisualtagid(new Integer(argVisualTagId+argVisualTagBase));
				bean.commitCopyHelper();
				return new Integer(docpos);
			}
		}
		return null;
}
/**
 * Генерация позиции акта монтажа АФС по введенным данным.
 * Creation date: (15.10.2004 17:57:33)
 */
protected int createPosition(Integer argDocument, int argOrder, Integer argOwner, Integer argResource, 
				String argSerial, String argQty, int argVisualTagId, int argVisualTagBase) throws Exception {

		StringAndBigDecimalProperty qty = new StringAndBigDecimalProperty();
		qty.setString(argQty);
		if ((argResource != null) && (   ((argSerial != null) && (argSerial.trim().length() > 0) ) || !qty.isEmpty() ) ) {
			argOrder++;
			com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
			int docpos = keyGen.getNextKey("tables.docpositions");

			String policy = "";
			// найдем ресурс			
			try {
				int bi = argResource.intValue();
				ResourceAccessBean res = new ResourceAccessBean();
				res.setInitKey_resource(bi);
				res.refreshCopyHelper();
				policy = res.getCountpolicy();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
			if ("S".equals(policy)	|| "P".equals(policy)) {
				qty.setString("1");
			} else {
				qty.setString(argQty);
			}
			
			//System.out.println("GEN POS: serial=" + argSerial + ", qty=" + qty.getBigDecimal());

			// Создадим позицию документа
			AfsMountPosAccessBean bean = new AfsMountPosAccessBean(
				docpos,
				argResource,
				argOwner,
				argDocument,
				argOrder,
				qty.getBigDecimal(),
				new java.math.BigDecimal(0),   // Price
				Boolean.FALSE, Boolean.FALSE, // Boxed
				Boolean.FALSE, Boolean.FALSE, // Broken
				Boolean.FALSE, Boolean.FALSE // Closed
			);
			
			if ("S".equals(policy)) {
				bean.setSerialnumber(argSerial);
			} else if ("P".equals(policy)) {
				bean.setParty(argSerial);
			}
			bean.setNewplace("-");
			bean.setDocpostype("D");  // простая позиция
			bean.setVisualtagid(new Integer(argVisualTagId + argVisualTagBase));
			bean.commitCopyHelper();
		}
		return argOrder;
}
/**
 * Генерация позиции акта монтажа АФС по введенным данным.
 * Creation date: (15.10.2004 17:57:33)
 */
protected int createPositions(Integer document, int order, Integer owner, AfsMountAct2Form edit2Form, int visualTagBase) throws Exception {
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60AA(), edit2Form.getQty60AA(), 601, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60AB(), edit2Form.getQty60AB(), 602, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60AC(), edit2Form.getQty60AC(), 603, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60BA(), edit2Form.getQty60BA(), 604, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60BB(), edit2Form.getQty60BB(), 605, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60BC(), edit2Form.getQty60BC(), 606, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60CA(), edit2Form.getQty60CA(), 607, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60CB(), edit2Form.getQty60CB(), 608, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60CC(), edit2Form.getQty60CC(), 609, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60DA(), edit2Form.getQty60DA(), 610, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60DB(), edit2Form.getQty60DB(), 611, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource60(), edit2Form.getSerial60DC(), edit2Form.getQty60DC(), 612, visualTagBase);
		
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70AA(), edit2Form.getQty70AA(), 701, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70AB(), edit2Form.getQty70AB(), 702, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70AC(), edit2Form.getQty70AC(), 703, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70BA(), edit2Form.getQty70BA(), 704, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70BB(), edit2Form.getQty70BB(), 705, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70BC(), edit2Form.getQty70BC(), 706, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70CA(), edit2Form.getQty70CA(), 707, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70CB(), edit2Form.getQty70CB(), 708, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70CC(), edit2Form.getQty70CC(), 709, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70DA(), edit2Form.getQty70DA(), 710, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70DB(), edit2Form.getQty70DB(), 711, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource70(), edit2Form.getSerial70DC(), edit2Form.getQty70DC(), 712, visualTagBase);
		
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80AA(), edit2Form.getQty80AA(), 801, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80AB(), edit2Form.getQty80AB(), 802, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80AC(), edit2Form.getQty80AC(), 803, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80BA(), edit2Form.getQty80BA(), 804, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80BB(), edit2Form.getQty80BB(), 805, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80BC(), edit2Form.getQty80BC(), 806, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80CA(), edit2Form.getQty80CA(), 807, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80CB(), edit2Form.getQty80CB(), 808, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80CC(), edit2Form.getQty80CC(), 809, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80DA(), edit2Form.getQty80DA(), 810, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80DB(), edit2Form.getQty80DB(), 811, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource80(), edit2Form.getSerial80DC(), edit2Form.getQty80DC(), 812, visualTagBase);
		
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90AA(), edit2Form.getQty90AA(), 901, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90AB(), edit2Form.getQty90AB(), 902, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90AC(), edit2Form.getQty90AC(), 903, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90BA(), edit2Form.getQty90BA(), 904, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90BB(), edit2Form.getQty90BB(), 905, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90BC(), edit2Form.getQty90BC(), 906, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90CA(), edit2Form.getQty90CA(), 907, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90CB(), edit2Form.getQty90CB(), 908, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90CC(), edit2Form.getQty90CC(), 909, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90DA(), edit2Form.getQty90DA(), 910, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90DB(), edit2Form.getQty90DB(), 911, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource90(), edit2Form.getSerial90DC(), edit2Form.getQty90DC(), 912, visualTagBase);
		
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100AA(), edit2Form.getQty100AA(), 1001, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100AB(), edit2Form.getQty100AB(), 1002, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100AC(), edit2Form.getQty100AC(), 1003, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100BA(), edit2Form.getQty100BA(), 1004, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100BB(), edit2Form.getQty100BB(), 1005, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100BC(), edit2Form.getQty100BC(), 1006, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100CA(), edit2Form.getQty100CA(), 1007, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100CB(), edit2Form.getQty100CB(), 1008, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100CC(), edit2Form.getQty100CC(), 1009, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100DA(), edit2Form.getQty100DA(), 1010, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100DB(), edit2Form.getQty100DB(), 1011, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource100(), edit2Form.getSerial100DC(), edit2Form.getQty100DC(), 1012, visualTagBase);
		
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110AA(), edit2Form.getQty110AA(), 1101, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110AB(), edit2Form.getQty110AB(), 1102, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110AC(), edit2Form.getQty110AC(), 1103, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110BA(), edit2Form.getQty110BA(), 1104, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110BB(), edit2Form.getQty110BB(), 1105, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110BC(), edit2Form.getQty110BC(), 1106, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110CA(), edit2Form.getQty110CA(), 1107, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110CB(), edit2Form.getQty110CB(), 1108, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110CC(), edit2Form.getQty110CC(), 1109, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110DA(), edit2Form.getQty110DA(), 1110, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110DB(), edit2Form.getQty110DB(), 1111, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource110(), edit2Form.getSerial110DC(), edit2Form.getQty110DC(), 1112, visualTagBase);
		
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120AA(), edit2Form.getQty120AA(), 1201, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120AB(), edit2Form.getQty120AB(), 1202, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120AC(), edit2Form.getQty120AC(), 1203, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120BA(), edit2Form.getQty120BA(), 1204, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120BB(), edit2Form.getQty120BB(), 1205, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120BC(), edit2Form.getQty120BC(), 1206, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120CA(), edit2Form.getQty120CA(), 1207, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120CB(), edit2Form.getQty120CB(), 1208, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120CC(), edit2Form.getQty120CC(), 1209, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120DA(), edit2Form.getQty120DA(), 1210, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120DB(), edit2Form.getQty120DB(), 1211, visualTagBase);
		order = createPosition(document, order, owner, edit2Form.getResource120(), edit2Form.getSerial120DC(), edit2Form.getQty120DC(), 1212, visualTagBase);

		return order;
}

protected int determineVisualBase(boolean argSectorA, boolean argSectorB, boolean argSectorC, 
							boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
							boolean argSectorO, boolean argSectorO1800) {
	int visualTagBase = 0;
	if (argSectorE || argSectorF || argSectorG || argSectorH || argSectorO)
		visualTagBase = VisualDocTypes.VISUAL_TAG_BASE;
	return visualTagBase;
}

/**
 * Генерация данных для сектора.
 * Creation date: (15.10.2004 17:57:33)
 */
protected int createSectorA(Integer document, int order, Integer owner, Integer groundResource, AfsMountAct2Form edit2Form,
		    boolean argSectorA, boolean argSectorB, boolean argSectorC, 
			boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO, boolean argSectorO1800, AntennCodes antCodes
	) throws Exception {
		int docpos;
		int visualTagBase = determineVisualBase(argSectorA, argSectorB, argSectorC, 
				argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, 
				argSectorO, argSectorO1800);

		// Определим тип поляризации - кросс антенна может быть только одна
		boolean isCross = false;
		if (edit2Form.getResource10() != null)
			isCross = edit2Form.isCrossAntenn(edit2Form.getResource10().intValue());
		if ( (antCodes.ant1 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource10().intValue()))  ) {
			docpos = antCodes.ant1.intValue();
			updateAntena(docpos, 
				//	      E                     F                    G                     H               O   
				argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
		} else {
			docpos = createAntena(document, order, owner, edit2Form.getResource10(), edit2Form.getSerial10A(), edit2Form.getQty10A(),
				//	   A       B        C       D        E       F        G        H       O     O1800
				argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
				//   2 цифра,          наклон,                    азимут
				    "1",        edit2Form.getNaklA(),   edit2Form.getAzimA(), edit2Form.getHsetA(), 101, visualTagBase);
		}
		if (docpos != 0) {
			//System.out.println("CRSA: antCodes.ant1=" + antCodes.ant1+ ", edit2Form.isComcabAA()=" + edit2Form.isComcabAA());
			if ( ((antCodes.ant1 != null) && !edit2Form.isComcabAA()) || (antCodes.ant1 == null) ) {
				//System.out.println("CRSA: #1");
				order++;
				Integer parpos = new Integer(docpos);
				antCodes.cable1 = createCable(parpos, document, order, owner, edit2Form.getResource50A(), 
					edit2Form.getSerial50AA(), edit2Form.getQty50AA(),
					//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
					groundResource, edit2Form.getGndcntAA(), edit2Form.getKsvnAA(), 501, visualTagBase);

				if (isCross) {
					order++;
					antCodes.cable2 = createCable(parpos, document, order, owner, edit2Form.getResource50A(), 
						edit2Form.getSerial50AB(), edit2Form.getQty50AB(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntAB(), edit2Form.getKsvnAB(), 502, visualTagBase);
				}
			} else {
				//System.out.println("CRSA: #2");
				updateCable(antCodes.cable1, 
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						edit2Form.getKsvnAA());
				if (isCross) {
					updateCable(antCodes.cable2, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnAB());
				}
			}
			antCodes.ant1 = new Integer(docpos);
		}

		if (!isCross) {	
			if ( (antCodes.ant2 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource10().intValue()))  ) {
				docpos = antCodes.ant2.intValue();
				updateAntena(docpos, 
					//	      E                     F                    G                     H               O   
					argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
			} else {
				docpos = createAntena(document, order, owner, edit2Form.getResource10(), edit2Form.getSerial10B(), edit2Form.getQty10B(),
					//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
					//   2 цифра,          наклон,                    азимут
					    "2",        edit2Form.getNaklA(),   edit2Form.getAzimA(), edit2Form.getHsetA(), 102, visualTagBase);
			}
			if (docpos != 0) {
				if ( ((antCodes.ant2 != null) && !edit2Form.isComcabAB()) || (antCodes.ant2 == null) ) {
					order++;
					Integer parpos = new Integer(docpos);
					antCodes.cable2 = createCable(parpos, document, order, owner, edit2Form.getResource50A(), 
						edit2Form.getSerial50AB(), edit2Form.getQty50AB(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntAB(), edit2Form.getKsvnAB(), 502, visualTagBase);
				} else {
					updateCable(antCodes.cable2, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnAB());
				}
				antCodes.ant2 = new Integer(docpos);
			}
			
			if ( (antCodes.ant3 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource10().intValue()))  ) {
				docpos = antCodes.ant3.intValue();
				updateAntena(docpos, 
					//	      E                     F                    G                     H               O   
					argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
			} else {
				docpos = createAntena(document, order, owner, edit2Form.getResource10(), edit2Form.getSerial10C(), edit2Form.getQty10C(),
					//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
					//   2 цифра,          наклон,                    азимут
					    "3",        edit2Form.getNaklA(),   edit2Form.getAzimA(), edit2Form.getHsetA(), 103, visualTagBase);
			}
			if (docpos != 0) {
				if ( ((antCodes.ant3 != null) && !edit2Form.isComcabAC()) || (antCodes.ant3 == null) ) {
					order++;
					Integer parpos = new Integer(docpos);
					antCodes.cable3 = createCable(parpos, document, order, owner, edit2Form.getResource50A(), 
						edit2Form.getSerial50AC(), edit2Form.getQty50AC(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntAC(), edit2Form.getKsvnAC(), 503, visualTagBase);
				} else {
					updateCable(antCodes.cable3, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnAC());
				}
				antCodes.ant3 = new Integer(docpos);
			}
		}
		return order;
}
/**
 * Генерация данных для сектора.
 * Creation date: (15.10.2004 17:57:33)
 */
protected int createSectorB(Integer document, int order, Integer owner, Integer groundResource, AfsMountAct2Form edit2Form,
		    boolean argSectorA, boolean argSectorB, boolean argSectorC, 
			boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO, boolean argSectorO1800, AntennCodes antCodes
	) throws Exception {
		int docpos;
		int visualTagBase = determineVisualBase(argSectorA, argSectorB, argSectorC, 
				argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, 
				argSectorO, argSectorO1800);
		
		// Определим тип поляризации - кросс антенна может быть только одна
		boolean isCross = false;
		if (edit2Form.getResource20() != null)
			isCross = edit2Form.isCrossAntenn(edit2Form.getResource20().intValue());
			
		if ( (antCodes.ant1 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource20().intValue()))  ) {
			docpos = antCodes.ant1.intValue();
			updateAntena(docpos, 
				//	      E                     F                    G                     H               O   
				argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
		} else {
			docpos = createAntena(document, order, owner, edit2Form.getResource20(), edit2Form.getSerial20A(), edit2Form.getQty20A(),
			//	   A       B        C       D        E       F        G        H       O     O1800
				argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
			//   2 цифра,          наклон,                    азимут
				    "1",        edit2Form.getNaklB(),   edit2Form.getAzimB(), edit2Form.getHsetB(), 201, visualTagBase);
		}
		if (docpos != 0) {
			if ( ((antCodes.ant1 != null) && !edit2Form.isComcabBA()) || (antCodes.ant1 == null) ) {
				order++;
				Integer parpos = new Integer(docpos);
				antCodes.cable1 = createCable(parpos, document, order, owner, edit2Form.getResource50B(), 
					edit2Form.getSerial50BA(), edit2Form.getQty50BA(),
					//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
					groundResource, edit2Form.getGndcntBA(), edit2Form.getKsvnBA(), 504, visualTagBase);
				if (isCross) {
					order++;
					antCodes.cable2 = createCable(parpos, document, order, owner, edit2Form.getResource50B(), 
						edit2Form.getSerial50BB(), edit2Form.getQty50BB(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntBB(), edit2Form.getKsvnBB(), 505, visualTagBase);
				}
			} else {
				updateCable(antCodes.cable1, 
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						edit2Form.getKsvnBA());
				if (isCross) {
					updateCable(antCodes.cable2, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnBB());
				}
			}
			antCodes.ant1 = new Integer(docpos);
		}

		if (!isCross) {
			if ( (antCodes.ant2 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource20().intValue()))  ) {
				docpos = antCodes.ant2.intValue();
				updateAntena(docpos, 
					//	      E                     F                    G                     H               O   
					argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
			} else {
				docpos = createAntena(document, order, owner, edit2Form.getResource20(), edit2Form.getSerial20B(), edit2Form.getQty20B(),
				//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
				//   2 цифра,          наклон,                    азимут
					    "2",        edit2Form.getNaklB(),   edit2Form.getAzimB(), edit2Form.getHsetB(), 202, visualTagBase);
			}
			if (docpos != 0) {
				if ( ((antCodes.ant2 != null) && !edit2Form.isComcabBB()) || (antCodes.ant2 == null) ) {
					order++;
					Integer parpos = new Integer(docpos);
					antCodes.cable2 = createCable(parpos, document, order, owner, edit2Form.getResource50B(), 
						edit2Form.getSerial50BB(), edit2Form.getQty50BB(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntBB(), edit2Form.getKsvnBB(), 505, visualTagBase);
				} else {
					updateCable(antCodes.cable2, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnBB());
				}
				antCodes.ant2 = new Integer(docpos);
			}
			
			if ( (antCodes.ant3 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource20().intValue()))  ) {
				docpos = antCodes.ant3.intValue();
				updateAntena(docpos, 
					//	      E                     F                    G                     H               O   
					argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
			} else {
				docpos = createAntena(document, order, owner, edit2Form.getResource20(), edit2Form.getSerial20C(), edit2Form.getQty20C(),
				//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
				//   2 цифра,          наклон,                    азимут
					    "3",        edit2Form.getNaklB(),   edit2Form.getAzimB(), edit2Form.getHsetB(), 203, visualTagBase);
			}
			if (docpos != 0) {
				if ( ((antCodes.ant3 != null) && !edit2Form.isComcabBC()) || (antCodes.ant3 == null) ) {
					order++;
					Integer parpos = new Integer(docpos);
					antCodes.cable3 = createCable(parpos, document, order, owner, edit2Form.getResource50B(), 
						edit2Form.getSerial50BC(), edit2Form.getQty50BC(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntBC(), edit2Form.getKsvnBC(), 506, visualTagBase);
				} else {
				updateCable(antCodes.cable3, 
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						edit2Form.getKsvnBC());
				}
				antCodes.ant3 = new Integer(docpos);
			}
		}
	    return order;	
}
/**
 * Генерация данных для сектора.
 * Creation date: (15.10.2004 17:57:33)
 */
protected int createSectorC(Integer document, int order, Integer owner, Integer groundResource, AfsMountAct2Form edit2Form,
		    boolean argSectorA, boolean argSectorB, boolean argSectorC, 
			boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO, boolean argSectorO1800, AntennCodes antCodes
	) throws Exception {
		int docpos;
		int visualTagBase = determineVisualBase(argSectorA, argSectorB, argSectorC, 
				argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, 
				argSectorO, argSectorO1800);
		
		// Определим тип поляризации - кросс антенна может быть только одна
		boolean isCross = false;
		if (edit2Form.getResource30() != null)
			isCross = edit2Form.isCrossAntenn(edit2Form.getResource30().intValue());
			
		if ( (antCodes.ant1 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource30().intValue()))  ) {
			docpos = antCodes.ant1.intValue();
			updateAntena(docpos, 
				//	      E                     F                    G                     H               O   
				argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
		} else {
			docpos = createAntena(document, order, owner, edit2Form.getResource30(), edit2Form.getSerial30A(), edit2Form.getQty30A(),
			//	   A       B        C       D        E       F        G        H       O     O1800
				argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
			//   2 цифра,          наклон,                    азимут
				    "1",        edit2Form.getNaklC(),  edit2Form.getAzimC(), edit2Form.getHsetC(), 301, visualTagBase);
		}
		if (docpos != 0) {
			if ( ((antCodes.ant1 != null) && !edit2Form.isComcabCA()) || (antCodes.ant1 == null) ) {
				order++;
				Integer parpos = new Integer(docpos);
				antCodes.cable1 = createCable(parpos, document, order, owner, edit2Form.getResource50C(), 
					edit2Form.getSerial50CA(), edit2Form.getQty50CA(),
					//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
					groundResource, edit2Form.getGndcntCA(), edit2Form.getKsvnCA(), 507, visualTagBase);
				if (isCross) {
					order++;
					antCodes.cable2 = createCable(parpos, document, order, owner, edit2Form.getResource50C(), 
						edit2Form.getSerial50CB(), edit2Form.getQty50CB(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntCB(), edit2Form.getKsvnCB(), 508, visualTagBase);
				}
			} else {
				updateCable(antCodes.cable1, 
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						edit2Form.getKsvnCA());
				if (isCross) {
					updateCable(antCodes.cable2, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnCB());
				}
			}
			antCodes.ant1 = new Integer(docpos);
		}

		if (!isCross) {
			if ( (antCodes.ant2 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource30().intValue()))  ) {
				docpos = antCodes.ant2.intValue();
				updateAntena(docpos, 
					//	      E                     F                    G                     H               O   
					argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
			} else {
				docpos = createAntena(document, order, owner, edit2Form.getResource30(), edit2Form.getSerial30B(), edit2Form.getQty30B(),
				//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
				//   2 цифра,          наклон,                    азимут
					    "2",        edit2Form.getNaklC(),   edit2Form.getAzimC(), edit2Form.getHsetC(), 302, visualTagBase);
			}
			if (docpos != 0) {
				if ( ((antCodes.ant2 != null) && !edit2Form.isComcabCB()) || (antCodes.ant2 == null) ) {
					order++;
					Integer parpos = new Integer(docpos);
					antCodes.cable2 = createCable(parpos, document, order, owner, edit2Form.getResource50C(), 
						edit2Form.getSerial50CB(), edit2Form.getQty50CB(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntCB(), edit2Form.getKsvnCB(), 508, visualTagBase);
				} else {
					updateCable(antCodes.cable2, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnCB());
				}
				antCodes.ant2 = new Integer(docpos);
			}
			
			if ( (antCodes.ant3 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource30().intValue()))  ) {
				docpos = antCodes.ant3.intValue();
				updateAntena(docpos, 
					//	      E                     F                    G                     H               O   
					argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
			} else {
				docpos = createAntena(document, order, owner, edit2Form.getResource30(), edit2Form.getSerial30C(), edit2Form.getQty30C(),
				//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
				//   2 цифра,          наклон,                    азимут
					    "3",        edit2Form.getNaklC(),   edit2Form.getAzimC(), edit2Form.getHsetC(), 303, visualTagBase);
			}
			if (docpos != 0) {
				if ( ((antCodes.ant3 != null) && !edit2Form.isComcabCC()) || (antCodes.ant3 == null) ) {
					order++;
					Integer parpos = new Integer(docpos);
					antCodes.cable3 = createCable(parpos, document, order, owner, edit2Form.getResource50C(), 
						edit2Form.getSerial50CC(), edit2Form.getQty50CC(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntCC(), edit2Form.getKsvnCC(), 509, visualTagBase);
				} else {
					updateCable(antCodes.cable3, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnCC());
				}
				antCodes.ant3 = new Integer(docpos);
			}
		}
		return order;
}
/**
 * Генерация данных для сектора.
 * Creation date: (15.10.2004 17:57:33)
 */
protected int createSectorD(Integer document, int order, Integer owner, Integer groundResource, AfsMountAct2Form edit2Form,
		    boolean argSectorA, boolean argSectorB, boolean argSectorC, 
			boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO, boolean argSectorO1800, AntennCodes antCodes
	) throws Exception {
		int docpos;
		int visualTagBase = determineVisualBase(argSectorA, argSectorB, argSectorC, 
				argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, 
				argSectorO, argSectorO1800);
		
		// Определим тип поляризации - кросс антенна может быть только одна
		boolean isCross = false;
		if (edit2Form.getResource40() != null)
			isCross = edit2Form.isCrossAntenn(edit2Form.getResource40().intValue());
			
		if ( (antCodes.ant1 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource40().intValue()))  ) {
			docpos = antCodes.ant1.intValue();
			updateAntena(docpos, 
				//	      E                     F                    G                     H               O   
				argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
		} else {
			docpos = createAntena(document, order, owner, edit2Form.getResource40(), edit2Form.getSerial40A(), edit2Form.getQty40A(),
			//	   A       B        C       D        E       F        G        H       O     O1800
				argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
			//   2 цифра,          наклон,                    азимут
				    "1",        edit2Form.getNaklD(),  edit2Form.getAzimD(), edit2Form.getHsetD(), 401, visualTagBase);
		}
		if (docpos != 0) {
			if ( ((antCodes.ant1 != null) && !edit2Form.isComcabDA()) || (antCodes.ant1 == null) ) {
				order++;
				Integer parpos = new Integer(docpos);
				antCodes.cable1 = createCable(parpos, document, order, owner, edit2Form.getResource50D(), 
					edit2Form.getSerial50DA(), edit2Form.getQty50DA(),
					//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
					groundResource, edit2Form.getGndcntDA(), edit2Form.getKsvnDA(), 510, visualTagBase);
				if (isCross) {
					order++;
					antCodes.cable2 = createCable(parpos, document, order, owner, edit2Form.getResource50D(), 
						edit2Form.getSerial50DB(), edit2Form.getQty50DB(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntDB(), edit2Form.getKsvnDB(), 511, visualTagBase);
				}
			} else {
				updateCable(antCodes.cable1, 
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						edit2Form.getKsvnDA());
				if (isCross) {
					updateCable(antCodes.cable2, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnDB());
				}
			}
			antCodes.ant1 = new Integer(docpos);
		}

		if (!isCross) {
			if ( (antCodes.ant2 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource40().intValue()))  ) {
				docpos = antCodes.ant2.intValue();
				updateAntena(docpos, 
					//	      E                     F                    G                     H               O   
					argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
			} else {
				docpos = createAntena(document, order, owner, edit2Form.getResource40(), edit2Form.getSerial40B(), edit2Form.getQty40B(),
				//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
				//   2 цифра,          наклон,                    азимут
					    "2",        edit2Form.getNaklD(),   edit2Form.getAzimD(), edit2Form.getHsetD(), 402, visualTagBase);
			}
			if (docpos != 0) {
				if ( ((antCodes.ant2 != null) && !edit2Form.isComcabDB()) || (antCodes.ant2 == null) ) {
					order++;
					Integer parpos = new Integer(docpos);
					antCodes.cable2 = createCable(parpos, document, order, owner, edit2Form.getResource50D(), 
						edit2Form.getSerial50DB(), edit2Form.getQty50DB(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntDB(), edit2Form.getKsvnDB(), 511, visualTagBase);
				} else {
					updateCable(antCodes.cable2, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnDB());
				}
				antCodes.ant2 = new Integer(docpos);
			}
			
			if ( (antCodes.ant3 != null) && (edit2Form.isTwoDiapAntenn(edit2Form.getResource40().intValue()))  ) {
				docpos = antCodes.ant3.intValue();
				updateAntena(docpos, 
					//	      E                     F                    G                     H               O   
					argSectorE, argSectorF, argSectorG, argSectorH, argSectorO);
			} else {
				docpos = createAntena(document, order, owner, edit2Form.getResource40(), edit2Form.getSerial40C(), edit2Form.getQty40C(),
				//	   A       B        C       D        E       F        G        H       O     O1800
					argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
				//   2 цифра,          наклон,                    азимут
					    "3",        edit2Form.getNaklD(),   edit2Form.getAzimD(), edit2Form.getHsetD(), 403, visualTagBase);
			}
			if (docpos != 0) {
				if ( ((antCodes.ant3 != null) && !edit2Form.isComcabDC()) || (antCodes.ant3 == null) ) {
					order++;
					Integer parpos = new Integer(docpos);
					antCodes.cable3 = createCable(parpos, document, order, owner, edit2Form.getResource50D(), 
						edit2Form.getSerial50DC(), edit2Form.getQty50DC(),
						//	   A       B        C       D        E       F        G        H       O     O1800
						argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
						groundResource, edit2Form.getGndcntDC(), edit2Form.getKsvnDC(), 512, visualTagBase);
				} else {
					updateCable(antCodes.cable3, 
							//	   A       B        C       D        E       F        G        H       O     O1800
							argSectorA, argSectorB, argSectorC, argSectorD, argSectorE, argSectorF, argSectorG, argSectorH, argSectorO, argSectorO1800,
							edit2Form.getKsvnDC());
				}
				antCodes.ant3 = new Integer(docpos);
			}
		}
		return order;
}
	/**
	 * Генерация акта монтажа по введенным данным.
	 * Creation date: (15.10.2004 17:57:33)
	 */
	public void generateAfsMountAct(AfsMountAct2Form edit2Form, AfsMountAct3Form edit3Form, HttpServletRequest request) throws Exception {
			com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
			int doc = keyGen.getNextKey("tables.documents");
			AfsMountAct2Form editForm = null;
			editForm = edit3Form;
			// GSM/DCS
			if ( (edit2Form != null) && (edit2Form.getIndiap() == 3 ) ) {
				editForm = edit2Form;
			}
			if (edit2Form != null)
				edit2Form.setDocument(doc);
			if (edit3Form != null)
				edit3Form.setDocument(doc);
			StringAndSqlDateProperty blankdate = new StringAndSqlDateProperty();
			blankdate.setString(editForm.getActdate());
			StringAndIntegerProperty blankindex = new StringAndIntegerProperty();
			blankindex.setString(editForm.getPosnumber());
			String blanknumber = editForm.getPosnumber();
	
			// Определим экспедицию
			Integer exped = null;
			StringAndIntegerProperty pcode = new StringAndIntegerProperty();
			pcode.setString(editForm.getProvidercode());
			try {
				java.util.Enumeration en = new ExpeditionAccessBean().findExpeditionByOrganization(new OrganizationKey(pcode.getInteger().intValue()));
				if(en.hasMoreElements()) {
					ExpeditionAccessBean exp1 = (ExpeditionAccessBean)en.nextElement();
					exped = new Integer(exp1.getStorageplace());
				} else {
					OrganizationAccessBean o = new OrganizationAccessBean();
					o.setInitKey_organization(pcode.getInteger().intValue());
					o.refreshCopyHelper();
					int expkey = keyGen.getNextKey("tables.storageplaces");
					ExpeditionAccessBean exp = new ExpeditionAccessBean(expkey, null, "", "");
					exp.setOrganization((Organization)o.getEJBRef());
					exp.setExpeditor(null);
					exp.setName(o.getName());
					exp.commitCopyHelper();
					exped = new Integer(expkey);
				}
			} catch (Exception ee) {
				ee.printStackTrace(System.out);
			}
			
			Integer owner = editForm.getOwnercode();
			// Создадим шапку документа
			AfsMountActAccessBean bean = new AfsMountActAccessBean(
				doc,
				owner,
				exped, 
				editForm.getComplectcode(),
				blankdate.getSqlDate(),
				blankindex.getInteger().intValue(),
				// "",
				blanknumber,
				"1",
				Boolean.TRUE,
				Boolean.TRUE,
				Boolean.FALSE
			);
			bean.setInsuranseMan(editForm.getInsuranceMan());
			
			StringAndIntegerProperty wrkcode = new StringAndIntegerProperty();
			wrkcode.setString(editForm.getWorkercode());
			WorkerAccessBean wrk = new WorkerAccessBean();
			wrk.setInitKey_worker(wrkcode.getInteger().intValue());
			wrk.refreshCopyHelper();
			bean.setMonter((Worker)wrk.getEJBRef());
			bean.setVisualtype(editForm.getVisualtype());
	
			bean.commitCopyHelper();
	
			// Создадим позиции документа
			Integer document = new Integer(doc);
			int order=1;
			int docpos = 0;
			Integer groundResource = null;
	
			// InDiap - параметр, показывающий какие диапазоны вводятся
			//    1 - 1800
			//    2 - 900
			//    3 - 1800/900
	
			AntennCodes antcodesA = new AntennCodes();
			AntennCodes antcodesB = new AntennCodes();
			AntennCodes antcodesC = new AntennCodes();
			AntennCodes antcodesD = new AntennCodes();
			if ( editForm.getIndiap() == 1) { // DCS, DCS/GSM
				// 1800
				if ("O".equals(editForm.getDiffs()))
					order = createSectorA(document, order, owner, groundResource, editForm, false, false, false, false, false, false, false, false, false, true, antcodesA);
					
				if ("1".equals(editForm.getDiffs()) || "2".equals(editForm.getDiffs()) )
					order = createSectorA(document, order, owner, groundResource, editForm, 
						"A".equals(editForm.getSectorA()),  "B".equals(editForm.getSectorA()),  "C".equals(editForm.getSectorA()),  "D".equals(editForm.getSectorA()), 
						false, false, false, false, false, false, antcodesA);
				if ("3".equals(editForm.getDiffs()) || "4".equals(editForm.getDiffs()))
					order = createSectorA(document, order, owner, groundResource, editForm, true, false, false, false, false, false, false, false, false, false, antcodesA);
					
				if ("2".equals(editForm.getDiffs()))
					order = createSectorB(document, order, owner, groundResource, editForm, 
						"A".equals(editForm.getSectorB()),  "B".equals(editForm.getSectorB()),  "C".equals(editForm.getSectorB()),  "D".equals(editForm.getSectorB()), 
						false, false, false, false, false, false, antcodesB);
					
				if ("3".equals(editForm.getDiffs()) || "4".equals(editForm.getDiffs()))
					order = createSectorB(document, order, owner, groundResource, editForm, false, true, false, false, false, false, false, false, false, false, antcodesB);
					
				if ("3".equals(editForm.getDiffs()) || "4".equals(editForm.getDiffs()))
					order = createSectorC(document, order, owner, groundResource, editForm, false, false, true, false, false, false, false, false, false, false, antcodesC);
				if ("4".equals(editForm.getDiffs()))
					order = createSectorD(document, order, owner, groundResource, editForm, false, false, false, true, false, false, false, false, false, false, antcodesD);
			}
	
			// GSM/DCS
			if ( editForm.getIndiap() == 3 ) {
				// 1800
				if ("O".equals(editForm.getDiffs())) {
						order = createSectorA(document, order, owner, groundResource, editForm, false, false, false, false, false, false, false, false, false, true, antcodesA);
				}
				
				if ("1".equals(editForm.getDiffs()) || "2".equals(editForm.getDiffs())) {
						order = createSectorA(document, order, owner, groundResource, editForm, 
							"A".equals(editForm.getSectorA()),  "B".equals(editForm.getSectorA()),  "C".equals(editForm.getSectorA()),  "D".equals(editForm.getSectorA()), 
							false, false, false, false, false, false, antcodesA);
				}
				if ("3".equals(editForm.getDiffs()) || "4".equals(editForm.getDiffs())) {
						order = createSectorA(document, order, owner, groundResource, editForm, true, false, false, false, false, false, false, false, false, false, antcodesA);
				}
					
				if ("2".equals(editForm.getDiffs())) {
						order = createSectorB(document, order, owner, groundResource, editForm, 
							"A".equals(editForm.getSectorB()),  "B".equals(editForm.getSectorB()),  "C".equals(editForm.getSectorB()),  "D".equals(editForm.getSectorB()), 
							false, false, false, false, 
							false, false, antcodesB);
				}
				if ("3".equals(editForm.getDiffs()) || "4".equals(editForm.getDiffs())) {
						order = createSectorB(document, order, owner, groundResource, editForm, false, true, false, false, false, false, false, false, false, false, antcodesB);
				}
				
				if ("3".equals(editForm.getDiffs()) || "4".equals(editForm.getDiffs())) {
						order = createSectorC(document, order, owner, groundResource, editForm, false, false, true, false, false, false, false, false, false, false, antcodesC);
				}
				if ("4".equals(editForm.getDiffs())) {
						order = createSectorD(document, order, owner, groundResource, editForm, false, false, false, true, false, false, false, false, false, false, antcodesD);
				}
	
				// 900
				if ("O".equals(edit3Form.getDiffs())) {
						order = createSectorA(document, order, owner, groundResource, edit3Form, false, false, false, false, false, false, false, false, true, false, antcodesA);
				}
				
				if ("1".equals(edit3Form.getDiffs()) || "2".equals(edit3Form.getDiffs())) {
						order = createSectorA(document, order, owner, groundResource, edit3Form, 
							false, false, false, false, 
							"A".equals(editForm.getSectorA()),  "B".equals(editForm.getSectorA()),  "C".equals(editForm.getSectorA()),  "D".equals(editForm.getSectorA()), 
							false, false, antcodesA);
				}
				if ("3".equals(edit3Form.getDiffs()) || "4".equals(edit3Form.getDiffs())) {
						order = createSectorA(document, order, owner, groundResource, edit3Form, false, false, false, false, true, false, false, false, false, false, antcodesA);
				}
				
				if ("2".equals(edit3Form.getDiffs())) {
						order = createSectorB(document, order, owner, groundResource, edit3Form, 
							false, false, false, false, 
							"A".equals(editForm.getSectorB()),  "B".equals(editForm.getSectorB()),  "C".equals(editForm.getSectorB()),  "D".equals(editForm.getSectorB()), 
							false, false, antcodesB);
				}
				if ("3".equals(edit3Form.getDiffs()) || "4".equals(edit3Form.getDiffs())) {
						order = createSectorB(document, order, owner, groundResource, edit3Form, false, false, false, false, false, true, false, false, false, false, antcodesB);
				}
				
				if ("3".equals(edit3Form.getDiffs()) || "4".equals(edit3Form.getDiffs())) {
						order = createSectorC(document, order, owner, groundResource, edit3Form, false, false, false, false, false, false, true, false, false, false, antcodesC);
				}
				if ("4".equals(edit3Form.getDiffs())) {
						order = createSectorD(document, order, owner, groundResource, edit3Form, false, false, false, false, false, false, false, true, false, false, antcodesD);
				}
			}
			// GSM only
			if ( editForm.getIndiap() == 2 ) {
				// 900
				if ("O".equals(edit3Form.getDiffs())) {
						order = createSectorA(document, order, owner, groundResource, edit3Form, false, false, false, false, false, false, false, false, true, false, antcodesA);
				}
				
				if ("1".equals(edit3Form.getDiffs()) || "2".equals(edit3Form.getDiffs())) {
						order = createSectorA(document, order, owner, groundResource, edit3Form, 
							false, false, false, false, 
							"A".equals(edit3Form.getSectorA()),  "B".equals(edit3Form.getSectorA()),  "C".equals(edit3Form.getSectorA()),  "D".equals(edit3Form.getSectorA()), 
							false, false, antcodesA);
				}
				if ("3".equals(edit3Form.getDiffs()) || "4".equals(edit3Form.getDiffs())) {
						order = createSectorA(document, order, owner, groundResource, edit3Form, false, false, false, false, true, false, false, false, false, false, antcodesA);
				}
				
				if ("2".equals(edit3Form.getDiffs())) {
						order = createSectorB(document, order, owner, groundResource, edit3Form, 
							false, false, false, false, 
							"A".equals(edit3Form.getSectorB()),  "B".equals(edit3Form.getSectorB()),  "C".equals(edit3Form.getSectorB()),  "D".equals(edit3Form.getSectorB()), 
							false, false, antcodesB);
				}
				if ("3".equals(edit3Form.getDiffs()) || "4".equals(edit3Form.getDiffs())) {
						order = createSectorB(document, order, owner, groundResource, edit3Form, false, false, false, false, false, true, false, false, false, false, antcodesB);
				}
				
				if ("3".equals(edit3Form.getDiffs()) || "4".equals(edit3Form.getDiffs())) {
						order = createSectorC(document, order, owner, groundResource, edit3Form, false, false, false, false, false, false, true, false, false, false, antcodesC);
				}
				if ("4".equals(edit3Form.getDiffs())) {
						order = createSectorD(document, order, owner, groundResource, edit3Form, false, false, false, false, false, false, false, true, false, false, antcodesD);
				}
			}
	
			if ( editForm.getIndiap() == 3 ) {
				order = createPositions(document, order, owner, edit2Form, 0);
				order = createPositions(document, order, owner, edit3Form, VisualDocTypes.VISUAL_TAG_BASE);
			} else if ( editForm.getIndiap() == 2 ) {
				order = createPositions(document, order, owner, edit3Form, VisualDocTypes.VISUAL_TAG_BASE);
			} else {
				order = createPositions(document, order, owner, edit3Form, 0);
			}
	}

	private void deleteAfsMountAct(Integer document) {
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery("EXECUTE PROCEDURE DeleteDocument(?)", new Object[] {document});
	}

	public ActionForward processInsert( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm) throws Exception {
		
		AfsMountAct3Form editForm3 = (AfsMountAct3Form)editForm;
		AfsMountAct2Form form1800 = (AfsMountAct2Form)request.getSession().getAttribute("AfsMountAct2Form");
		editForm3.setUser(request.getRemoteUser());
		if (request.isUserInRole("administrator"))
			editForm3.setIsAdmin(Boolean.TRUE);
		else
			editForm3.setIsAdmin(Boolean.FALSE);
		editForm3.validateValues(errors);
		generateAfsMountAct(form1800, editForm3, request);
		String sc = "";
		if (VisualDocTypes.AFS_MOUNT_ACT_1800_900.equals(editForm3.getVisualtype()))
			sc = "EditAfsMountAct2.do";
		else
			sc = "EditAfsMountAct3.do";
		sc = sc + "?action=Edit&document=" + editForm3.getDocumentId();
		request.getSession().removeAttribute("AfsMountAct2Form");
		ActionForward retVal = new ActionForward(sc, true); 
		return retVal; 
	}
	
	public ActionForward processUpdate( ActionMapping mapping, HttpServletRequest request, ActionErrors errors, EditForm editForm)
		throws Exception
	{
		AfsMountAct3Form editForm3 = (AfsMountAct3Form)editForm;
		AfsMountAct2Form form1800 = (AfsMountAct2Form)request.getSession().getAttribute("AfsMountAct2Form");
		if (request.isUserInRole("administrator"))
			editForm3.setIsAdmin(Boolean.TRUE);
		else
			editForm3.setIsAdmin(Boolean.FALSE);
				
		String reqState = editForm3.getProcessState();
		if (!"C".equalsIgnoreCase(reqState)) {
			editForm3.validateValues(errors);
			deleteAfsMountAct(editForm3.getDocumentId());
			generateAfsMountAct(form1800, editForm3, request);
		}
		super.processUpdate(mapping, request, errors, editForm3);
		ActionForward retVal = null;
		String sc = "";
		if (VisualDocTypes.AFS_MOUNT_ACT_1800_900.equals(editForm3.getVisualtype()))
			sc = "EditAfsMountAct2.do";
		else
			sc = "EditAfsMountAct3.do";
		if ("2".equals(editForm3.getDState()) || "P".equalsIgnoreCase(reqState)) {
			sc = sc + "?action=View&document=" + editForm3.getDocumentId();
		} else {
			sc = sc + "?action=Edit&document=" + editForm3.getDocumentId();
		}
		retVal = new ActionForward(sc, true);
		return retVal;
	}

	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		AfsMountAct3Form editForm3 = (AfsMountAct3Form)form;
		editForm3.setUser(request.getRemoteUser());
		if (request.isUserInRole("administrator"))
			editForm3.setIsAdmin(Boolean.TRUE);
		else
			editForm3.setIsAdmin(Boolean.FALSE);
		return super.perform(mapping, form, request, response);
	}
/*
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    ActionForward retVal = null;	
	    ActionErrors errors = new ActionErrors();

  		//process actions
  		AbstractEntityAccessBean bean = null;
		AfsMountAct3Form editForm = (AfsMountAct3Form)form;
		AfsMountAct2Form form1800 = (AfsMountAct2Form)request.getSession().getAttribute("AfsMountAct2Form");
		
		//is canceled
		if( isCancelled(request) ) {
				return  mapping.findForward( "errorgoback" ); 
		}

	    try { 
			editForm.setReturnPage(mapping.findForward( "errorgoback" ).getPath());

			editForm.setUser(request.getRemoteUser());
			if (request.isUserInRole("administrator"))
				editForm.setIsAdmin(Boolean.TRUE);
			else
				editForm.setIsAdmin(Boolean.FALSE);
	  		
			if( editForm.getAction().equals("Add") ) {
				editForm.validateValues(errors);
				generateAfsMountAct(form1800, editForm, request, response);
				String sc = mapping.findForward( "success" ).getPath();
				int ind = sc.indexOf("?");
				if ( ind > 0)
					sc = sc.substring(0, ind);
				sc = sc + "?action=Edit&doc=" + editForm.getDocument();
				request.getSession().removeAttribute("AfsMountAct2Form");
				retVal = new ActionForward(sc, true); 
			}
	    } catch( ValidationException e ) {
		    if (e instanceof UpdateValidationException)
		    	ErrorProcessor.processException( errors, e );
		    // do nothing 
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
	  	    retVal = mapping.findForward( "main" ); 
	    } catch( Exception e ) {
		    e.printStackTrace(System.out);
		    ErrorProcessor.processException( errors, e );
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
	  	    retVal = mapping.findForward( "main" );
	  	    retVal = processException( errors, e, editForm, bean, retVal );
	    }
	    
		//process errors
	    if( !errors.empty() ) {
	 	  	saveErrors(request, errors);
	  	    ParamsParser.setState( request, editForm.getApplication(), editForm.getState() );
	  	    retVal = mapping.findForward( "main" ); 
	    }

	    return retVal;    
	}
*/
	
/**
 * Обновление строки акта монтажа АФС - антена.
 * Обновляются сектора, обслуживаемые антенной
 * Creation date: (15.10.2004 17:57:33)
 */
public void updateAntena(int argDocpos, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO) throws Exception {

			AfsMountPosAccessBean bean = new AfsMountPosAccessBean();
			bean.setInitKey_docposition(argDocpos);
			bean.refreshCopyHelper();
			bean.setSectorE(new Boolean(argSectorE));
			bean.setSectorF(new Boolean(argSectorF));
			bean.setSectorG(new Boolean(argSectorG));
			bean.setSectorH(new Boolean(argSectorH));
			bean.setSectorO(new Boolean(argSectorO));
			bean.commitCopyHelper();
}
/**
 * Создание строки акта монтажа АФС - кабель.
 * Creation date: (15.10.2004 17:57:33)
 */
public void updateCable(Integer argDocpos, boolean argSectorA, boolean argSectorB, boolean argSectorC, 
			boolean argSectorD, boolean argSectorE, boolean argSectorF, boolean argSectorG, boolean argSectorH, 
			boolean argSectorO, boolean argSectorO1800, String argKsvn) throws Exception {

		if (argDocpos != null) {
				AfsMountPosAccessBean bean = new AfsMountPosAccessBean();
				bean.setInitKey_docposition(argDocpos.intValue());
				bean.refreshCopyHelper();

				StringAndBigDecimalProperty qty = new StringAndBigDecimalProperty();
				qty.setString(argKsvn);
				if (argSectorA || argSectorB || argSectorC || argSectorD || argSectorO1800)
					bean.setKsvn1800(qty.getBigDecimal());
				if (argSectorE || argSectorF || argSectorG || argSectorH || argSectorO)
					bean.setKsvn900(qty.getBigDecimal());
				
				bean.commitCopyHelper();
		}
}
}
