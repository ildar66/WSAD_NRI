/*
 * Created on 24.01.2006
 *
 */
package com.hps.july.logic;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCDocuments;
import com.hps.july.persistence.DocumentPosition;
import com.hps.july.persistence.DocumentPositionAccessBean;
import com.hps.july.persistence.ExpeditionAccessBean;
import com.hps.july.persistence.IBPMountPosAccessBean;
import com.hps.july.persistence.InternalWayBillAccessBean;
import com.hps.july.persistence.InternalWayBillPositionAccessBean;
import com.hps.july.persistence.Organization;
import com.hps.july.persistence.OrganizationAccessBean;
import com.hps.july.persistence.OrganizationKey;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.persistence.Worker;
import com.hps.july.persistence.WorkerAccessBean;
import com.hps.july.valueobject.ComplexDocPosition;
import com.hps.july.valueobject.ComplexDocument;
import com.hps.july.web.util.StringAndBigDecimalProperty;
import com.hps.july.web.util.StringAndIntegerProperty;

/**
 * Логика работы с составными документами
 * @author Dmitry Dneprov
 *
 */
public class ComplexDocLogic {
	
	/**
	 * Преобразование количества из строки
	 * @param argQty
	 * @return
	 */
	public static java.math.BigDecimal qtyFromString(String argQty) {
		StringAndBigDecimalProperty qtyPrp = new StringAndBigDecimalProperty();
		qtyPrp.setString(argQty);
		return qtyPrp.getBigDecimal();
	}
	
	/**
	 * Создание составного документа в базе данных
	 * @param cdoch
	 * @param cdocposits
	 * @return
	 */
	public static boolean updateComplexDocCodes(ComplexDocument cdoch, ArrayList cdocposits) {
		boolean result = false;
		
		CDBCResultSet rs = new CDBCResultSet();
		result = rs.executeUpdate("BEGIN WORK", new Object[]{});
		if (result)
			result = rs.executeUpdate("UPDATE INTO complexdocs SET document = ? WHERE compdoc = ?",
				new Object[] {cdoch.getDocument(), cdoch.getCompdoc()} );
				
		ListIterator it = cdocposits.listIterator();
		while (it.hasNext()) {
			ComplexDocPosition cdp = (ComplexDocPosition)it.next();
			if (result)
				result = rs.executeUpdate("UPDATE complexdocpos SET docposition = ? WHERE compdocpos = ?",
					new Object[] {cdp.getDocposition(), cdp.getCompdocpos()});
		}
		
		if (result)
			result = rs.executeUpdate("COMMIT WORK", new Object[]{});
		else
			result = rs.executeUpdate("ROLLBACK WORK", new Object[]{});
			
		return result;
	}
	
	/**
	 * Создание составного документа в базе данных
	 * @param cdoch
	 * @param cdocposits
	 * @return
	 */
	public static boolean saveComplexDoc(ComplexDocument cdoch, ArrayList cdocposits) {
		boolean result = false;
		
		// Assign serial number to document
		com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
		Integer compdoc = null;
		try {
			compdoc = new Integer(keyGen.getNextKey("tables.documents"));
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		// Assign serial numbers to positions
		ListIterator it = cdocposits.listIterator();
		while (it.hasNext()) {
			Integer compdocpos = null;
			ComplexDocPosition cdp = (ComplexDocPosition)it.next();
			try {
				compdocpos = new Integer(keyGen.getNextKey("tables.documents"));
				cdp.setCompdocpos(compdocpos);
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
		CDBCResultSet rs = new CDBCResultSet();
		result = rs.executeUpdate("BEGIN WORK", new Object[]{});
		if (result)
			result = rs.executeUpdate("INSERT INTO complexdocs (compdoc, compdoctype, bsnumber, contrnumber, " +				"repnumber, equipment, organization, orgexped, owner, worker, docdate, projectid, needapprove)" +				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ", new Object[] {compdoc, cdoch.getCompdoctype(),
				cdoch.getBsnumber(), cdoch.getContrnumber(), cdoch.getRepnumber(), cdoch.getEquipment(),
				cdoch.getOrganization(), cdoch.getOrgexped(), cdoch.getOwner(), cdoch.getWorker(),
				cdoch.getDate(), cdoch.getProjectid(), cdoch.isNeedapprove()?"Y":"N"} );
				
		it = cdocposits.listIterator();
		while (it.hasNext()) {
			Integer compdocpos = null;
			ComplexDocPosition cdp = (ComplexDocPosition)it.next();
			if (result)
				result = rs.executeUpdate("INSERT INTO complexdocpos (compdocpos, compdoc, tagid, " +
					"resource, serial, qty, comment)" +
					"VALUES (?, ?, ?, ?, ?, ?, ?) ", new Object[] {cdp.getCompdocpos(), compdoc, cdp.getTagid(),
					cdp.getResource(), cdp.getSerial(), cdp.getQty(), cdp.getComment()});
		}
		
		if (result)
			result = rs.executeUpdate("COMMIT WORK", new Object[]{});
		else
			result = rs.executeUpdate("ROLLBACK WORK", new Object[]{});
			
		return result;
	}
	
	/**
	 * Чтение составного документа из базы данных
	 * @param docId
	 * @param cdoch
	 * @param cdocposits
	 * @return
	 */
	public static boolean loadComplexDoc(Integer docId, ComplexDocument cdoch, ArrayList cdocposits) {
		boolean result = false;
		
		CDBCResultSet rs = new CDBCResultSet();
		rs.executeQuery("SELECT * FROM complexdocs WHERE compdoc = ?", new Object[]{docId});
		ListIterator it = rs.listIterator();
		if (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			cdoch.setCompdoc((Integer)ro.getColumn("compdoc").asObject());
			cdoch.setCompdoctype((Integer)ro.getColumn("compdoctype").asObject());
			cdoch.setBsnumber(ro.getColumn("bsnumber").asString());
			cdoch.setContrnumber(ro.getColumn("contrnumber").asString());
			cdoch.setRepnumber(ro.getColumn("repnumber").asString());
			cdoch.setEquipment((Integer)ro.getColumn("equipment").asObject());
			cdoch.setOrganization((Integer)ro.getColumn("organization").asObject());
			cdoch.setOrgexped(ro.getColumn("orgexped").asString());
			cdoch.setOwner((Integer)ro.getColumn("owner").asObject());
			cdoch.setWorker((Integer)ro.getColumn("worker").asObject());
			cdoch.setDate((Date)ro.getColumn("docdate").asObject());
			cdoch.setProjectid((Integer)ro.getColumn("projectid").asObject());
			cdoch.setNeedapprove("Y".equals(ro.getColumn("needapprove").asString()));
		}
		CDBCResultSet rs2 = new CDBCResultSet();
		rs2.executeQuery("SELECT * FROM complexdocpos WHERE compdoc = ?", new Object[]{docId});
		ListIterator it2 = rs2.listIterator();
		if (it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			ComplexDocPosition cdp = new ComplexDocPosition((Integer)ro.getColumn("compdocpos").asObject(),
				(Integer)ro.getColumn("tagid").asObject(),
				(Integer)ro.getColumn("resource").asObject(),
				ro.getColumn("serial").asString(),
				(BigDecimal)ro.getColumn("qty").asObject(),
				ro.getColumn("comment").asString()
			);
			cdocposits.add(cdp);
		}
		return result;
	}

	/**
	 * Генерация акта монтажа по введенным данным.
	 * Creation date: (15.10.2004 17:57:33)
	 */
	public Integer createPosition(Integer argDocument, int argOrder, Integer argOwner, Integer argResource, String argSerial, java.math.BigDecimal argQty, String argComment, Integer argParentPos, String argParentSerial, boolean argIBP) throws Exception {
	
			Integer result = null;
			if (argResource != null) {
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
				
				BigDecimal qty = argQty;
				if ("S".equals(policy)	|| "P".equals(policy)) {
					qty = new BigDecimal("1");
				}
	
				// Создадим позицию документа
				if (argIBP) {
					IBPMountPosAccessBean bean = new IBPMountPosAccessBean(
						docpos,
						argResource,
						argOwner,
						argDocument,
						argOrder,
						qty,
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
					bean.setComment(argComment);
					bean.commitCopyHelper();
				} else {
					InternalWayBillPositionAccessBean bean = new InternalWayBillPositionAccessBean(
						docpos,
						argResource,
						argOwner,
						argDocument,
						argOrder,
						qty,
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
					bean.setComment(argComment);
					if (argParentPos != null) {
						DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
						dp.setInitKey_docposition(argParentPos.intValue());
						dp.refreshCopyHelper();
						bean.setAgregate((DocumentPosition)dp.getEJBRef());
						bean.setAgregateSerial(argParentSerial);
						bean.setAgregateresource(new Integer(dp.getResourceKey().resource));
					}
					bean.commitCopyHelper();
				}
				result = new Integer(docpos);
			}
			return result;
	}

	/**
	 * Генерация акта монтажа по введенным данным.
	 * Creation date: (15.10.2004 17:57:33)
	 */
	public void generateBTSMountAct(ComplexDocument cdoch, ArrayList cdocposits) throws Exception {
			com.hps.july.commonbean.KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
			int doc = keyGen.getNextKey("tables.documents");
	
			// Определим экспедицию
			Integer exped = null;
			try {
				java.util.Enumeration en = new ExpeditionAccessBean().findExpeditionByOrganization(new OrganizationKey(cdoch.getOrganization().intValue()));
				if(en.hasMoreElements()) {
					ExpeditionAccessBean exp1 = (ExpeditionAccessBean)en.nextElement();
					exped = new Integer(exp1.getStorageplace());
				} else {
					OrganizationAccessBean o = new OrganizationAccessBean();
					o.setInitKey_organization(cdoch.getOrganization().intValue());
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

			StringAndIntegerProperty blankindex = new StringAndIntegerProperty();
			blankindex.setString(cdoch.getBsnumber());			
			// Создадим шапку документа
			InternalWayBillAccessBean bean = new InternalWayBillAccessBean(
				doc,
				cdoch.getOwner(),
				exped, 
				cdoch.getEquipment(),
				cdoch.getDate(),
				blankindex.getInteger().intValue(),
				"",
				"1",
				Boolean.TRUE,
				Boolean.TRUE,
				Boolean.FALSE
			);
			bean.setNeedapprove(cdoch.isNeedapprove());
			bean.setProjectid(cdoch.getProjectid());
			bean.setInsuranseMan(cdoch.getOrgexped());
			
			WorkerAccessBean wrk = new WorkerAccessBean();
			wrk.setInitKey_worker(cdoch.getWorker().intValue());
			wrk.refreshCopyHelper();
			bean.setMonter((Worker)wrk.getEJBRef());
	
			bean.commitCopyHelper();
	
			Integer document = new Integer(doc);
			cdoch.setDocument(document);
			
			// Создадим позиции документа
			int order=1;
			Integer docpos;
			ListIterator it = cdocposits.listIterator();
			while (it.hasNext()) {
				ComplexDocPosition cdp = (ComplexDocPosition)it.next();
				docpos = createPosition(document, order++, cdoch.getOwner(), cdp.getResource(), cdp.getSerial(), cdp.getQty(), cdp.getComment(), null, null, false);
				cdp.setDocposition(docpos);
			}
			
			updateComplexDocCodes(cdoch, cdocposits);
			
			/*
			docpos = createPosition(document, order++, owner, editForm.getResource10(), editForm.getSerial10(), editForm.getQty10(), editForm.getComment10(), null, null, true);
			createPosition(document, 1, owner, editForm.getResource20(), editForm.getSerial20(), editForm.getQty20(), editForm.getComment20(), docpos, editForm.getSerial10(), false);
			createPosition(document, 3, owner, editForm.getResource30(), editForm.getSerial30(), editForm.getQty30(), editForm.getComment30(), docpos, editForm.getSerial10(), false);
			createPosition(document, order++, owner, editForm.getResource40(), editForm.getSerial40(), editForm.getQty40(), editForm.getComment40(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource50(), editForm.getSerial50(), editForm.getQty50(), editForm.getComment50(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource60(), editForm.getSerial60(), editForm.getQty60(), editForm.getComment60(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource70(), editForm.getSerial70(), editForm.getQty70(), editForm.getComment70(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource75(), editForm.getSerial75(), editForm.getQty75(), editForm.getComment75(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource80(), editForm.getSerial80(), editForm.getQty80(), editForm.getComment80(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource90(), editForm.getSerial90(), editForm.getQty90(), editForm.getComment90(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource100(), editForm.getSerial100(), editForm.getQty100(), editForm.getComment100(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource110(), editForm.getSerial110(), editForm.getQty110(), editForm.getComment110(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource170(), editForm.getSerial170(), editForm.getQty170(), editForm.getComment170(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource180(), editForm.getSerial180(), editForm.getQty180(), editForm.getComment180(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource190(), editForm.getSerial190(), editForm.getQty190(), editForm.getComment190(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource200(), editForm.getSerial200(), editForm.getQty200(), editForm.getComment200(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource210(), editForm.getSerial210(), editForm.getQty210(), editForm.getComment210(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource220(), editForm.getSerial220(), editForm.getQty220(), editForm.getComment220(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource240(), editForm.getSerial240(), editForm.getQty240(), editForm.getComment240(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource250(), editForm.getSerial250(), editForm.getQty250(), editForm.getComment250(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource260(), editForm.getSerial260(), editForm.getQty260(), editForm.getComment260(), null, null, false);
			createPosition(document, order++, owner, editForm.getResource270(), editForm.getSerial270(), editForm.getQty270(), editForm.getComment270(), null, null, false);
			*/
	}
	
}
