/*
 * Created on 27.01.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCLeaseChargesObject;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.persistence.LeaseContractAccessBean;
import com.hps.july.valueobject.LeaseCharge_TO;
import com.hps.july.valueobject.LeaseCharge_VO;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.StringAndSqlDateProperty;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChargeListForm extends EditForm {
	private java.lang.String sortBy;
	private List chargesList;
	private int leaseContract;
	private java.lang.Boolean isDate;
	private StringAndSqlDateProperty fromDate;
	private StringAndSqlDateProperty toDate;
	private java.lang.Boolean isResource;
	private int resource;
	private	Integer mainLeaseContractKey;
	private String docNumber;
	private Date docDate;

	public ChargeListForm() {
		setIsDate(new Boolean(true));
		setIsResource(new Boolean(true));

		setResource(0);
		setSortBy("beginDate desc");
		GregorianCalendar c = new GregorianCalendar();
		c.clear(Calendar.HOUR_OF_DAY);
		c.clear(Calendar.MINUTE);
		c.clear(Calendar.SECOND);
		c.clear(Calendar.MILLISECOND);

		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		toDate = new StringAndSqlDateProperty();
		toDate.setSqlDate(new Date(c.getTime().getTime()));

		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		fromDate = new StringAndSqlDateProperty();
		fromDate.setSqlDate(new Date(c.getTime().getTime()));
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.CHARGE_LIST;
	}

	/**
	 * @return
	 */
	public List getChargesList() {
		return chargesList;
	}

	/**
	 * @return
	 */
	public int getLeaseContract() {
		return leaseContract;
	}

	/**
	 * @return
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}

	/**
	 * @param list
	 */
	public void setChargesList(List list) {
		chargesList = list;
	}

	/**
	 * @param i
	 */
	public void setLeaseContract(int i) {
		leaseContract = i;
	}

	/**
	 * @param string
	 */
	public void setSortBy(java.lang.String string) {
		sortBy = string;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (27.06.2002 16:47:06)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		List list = null;
		if (getLeaseContract() != 0) {
			//Определяем главный договор:
			calcMainLeaseContractKey();
			list = new ArrayList();
			CDBCResultSet rSet =
				CDBCLeaseChargesObject
					.findByQBE5(
						Boolean.TRUE,
						getMainLeaseContractKey(),
						getIsDate().booleanValue() ? Boolean.FALSE : Boolean.TRUE,
						getFromDate(),
						getToDate(),
						getIsResource().booleanValue() ? Boolean.FALSE : Boolean.TRUE,
						new Integer(getResource()),
						new Boolean(true),
						new String[] { "N", "C" },
			//new Integer(2));
			getSortBy());
			ListIterator iter = rSet.listIterator();
			LeaseCharge_TO to = null;
			CDBCRowObject ro = null;
			while (iter.hasNext()) {
				ro = (CDBCRowObject) iter.next();
				to = new LeaseCharge_TO(CDBC_MapFactory.createLeaseCharge(ro));
				to.setCurName(ro.getColumn("curname").asString());
				to.setResName(ro.getColumn("resname").asString());
				list.add(to);
			}
			setChargesList(list);
			//System.out.println("list size=" + list.size());//temp
			request.setAttribute("numberOfLines", String.valueOf(list.size()));
		} else {
			setChargesList(Collections.EMPTY_LIST);
			request.setAttribute("numberOfLines", "нет записей");
		}
	}
	
	protected void calcMainLeaseContractKey() {
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(getLeaseContract());
			bean.refreshCopyHelper();
			if (bean.getMainDocument() != null) {
				setMainLeaseContractKey(bean.getMainDocument());
			} else {
				setMainLeaseContractKey( new Integer(getLeaseContract()) );
			}
			//информация  о договоре:
			afterSetMainContractKey(getMainLeaseContractKey());			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка нахождения mainLeaseContractKey для getLeaseContract =" + getLeaseContract());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:10:59)
	 * @param newContract java.lang.Integer
	 */
	private void afterSetMainContractKey(Integer mainDocument) {
		try {
			LeaseContractAccessBean ab = new LeaseContractAccessBean();
			ab.setInitKey_leaseDocument(mainDocument.intValue());
			ab.refreshCopyHelper();
			//если нужна доп инфо сделать DocInfo(object):
			setDocNumber(ab.getDocumentNumber());
			setDocDate(ab.getDocumentDate());
/**			
			if (ab.getOrgExecutor() != null) {
				setOrgname(ab.getOrgExecutor().getName());
			} else {
				setOrgname("");
			}
			if (ab.getOrgCustomer() != null) {
				setCustname(ab.getOrgCustomer().getName());
			} else {
				setCustname("");
			}
			if (ab.getEconomist() != null) {
				setEconomist(ab.getEconomist().getMan().getFullName());
			} else {
				setEconomist("");
			}
			//устанавливаем имя ресурса:
			LeaseArendaAgreementNewAccessBean laaAB =
				new LeaseArendaAgreementNewAccessBean();
			laaAB.setInitKey_leaseDocument(getMaincontract());
			//System.out.println("laaAB.getMainresource()= "+laaAB.getMainresource());//temp
			if (laaAB.getMainresource() != null) {
				setResource(laaAB.getMainresource());
				ResourceAccessBean resAB = new ResourceAccessBean();
				resAB.setInitKey_resource(getResource().intValue());
				setResname(resAB.getName());
			} else {
				setResource(new Integer(0));
				setResname("");
			}
*/			
		} catch (Exception e) {
			// Contract not found - clear fields
		}
	}	
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 10:43:17)
	 * @return java.sql.Date
	 */
	public java.sql.Date getFromDate() {
		return fromDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 10:43:17)
	 * @return java.sql.Date
	 */
	public String getFromDateFrm() {
		return fromDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 10:55:01)
	 * @return java.sql.Date
	 */
	public java.sql.Date getToDate() {
		return toDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 10:55:01)
	 * @return java.sql.Date
	 */
	public String getToDateFrm() {
		return toDate.getString();
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 10:43:17)
	 * @param newFromDate java.sql.Date
	 */
	public void setFromDate(java.sql.Date newFromDate) {
		fromDate.setSqlDate(newFromDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 10:43:17)
	 * @param newFromDate java.sql.Date
	 */
	public void setFromDateFrm(String newFromDate) {
		fromDate.setString(newFromDate);
	}
	/**
	* Insert the method's description here.
	* Creation date: (23.07.2002 10:55:01)
	* @param newToDate java.sql.Date
	*/
	public void setToDate(java.sql.Date newToDate) {
		toDate.setSqlDate(newToDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 10:55:01)
	 * @param newToDate java.sql.Date
	 */
	public void setToDateFrm(String newToDate) {
		toDate.setString(newToDate);
	} /**
					* Insert the method's description here.
					* Creation date: (23.07.2002 10:41:34)
					* @return java.lang.Boolean
					*/
	public java.lang.Boolean getIsDate() {
		return isDate;
	}
	/**
		* Insert the method's description here.
		* Creation date: (23.07.2002 10:41:34)
		* @param newIsDate java.lang.Boolean
		*/
	public void setIsDate(java.lang.Boolean newIsDate) {
		isDate = newIsDate;
	} /**
				   * Insert the method's description here.
				   * Creation date: (15.12.2002 20:15:35)
				   * @return java.lang.Boolean
				   */
	public java.lang.Boolean getIsResource() {
		return isResource;
	} /**
				* Insert the method's description here.
				* Creation date: (15.12.2002 20:15:35)
				* @param newIsResource java.lang.Boolean
				*/
	public void setIsResource(java.lang.Boolean newIsResource) {
		isResource = newIsResource;
	}
	/**
	 * @return
	 */
	public int getResource() {
		return resource;
	}

	/**
	 * @param i
	 */
	public void setResource(int i) {
		resource = i;
	}

	/**
	 * @return
	 */
	public Integer getMainLeaseContractKey() {
		return mainLeaseContractKey;
	}

	/**
	 * @param integer
	 */
	private void setMainLeaseContractKey(Integer integer) {
		mainLeaseContractKey = integer;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @param string
	 */
	private void setDocNumber(String string) {
		docNumber = string;
	}

	/**
	 * @return
	 */
	public Date getDocDate() {
		return docDate;
	}

	/**
	 * @param date
	 */
	private void setDocDate(Date date) {
		docDate = date;
	}

}
