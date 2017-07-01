package com.hps.july.arenda.formbean;

import java.util.Vector;
import java.util.Enumeration;
import javax.servlet.http.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import com.hps.july.util.*;
import java.math.BigDecimal;
/**
 *  Form-Bean.
 * "Позиции абонентского счета".
 */
public class AbonentBillPosForm extends EditForm {
	private int billpos;
	private String billnumber;
	private java.sql.Date billdate;
	private BigDecimal billsum;
	private BigDecimal billsumnri;
	private BigDecimal billnds;
	private BigDecimal billndsnri;
	private java.sql.Date startdate;
	private java.sql.Date enddate;
	private String servname;
	private String summpure;
	private com.hps.july.web.util.StringAndBigDecimalProperty summpurenri;
	private String ndssumm;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal ndssummnri;
	private String nspsumm;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal nspsummnri;
	private String summ;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal summnri;
	private com.hps.july.persistence.ResourceAccessBean pos2resource;
	private int resource;
	private boolean sumbyhand;
	private java.lang.String billType;
	private String ndsrate;
	private java.lang.String sumchangereason;
public AbonentBillPosForm() {
	summpurenri = new StringAndBigDecimalProperty();
	ndssummnri = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	nspsummnri = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	summnri = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	// Check if we have RecalculateNds request
	String s = request.getParameter("recalcnds.x");
	if ( (s != null) && (Integer.parseInt(s) > 0) ) {
		// Determine rate
		java.math.BigDecimal rate = new java.math.BigDecimal("0.0");
		if (getBilldate() != null) {
			setNdssummnri(new com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodAccessBean().calcNds(new Integer(getResource()),
				getBilldate(), getSummnri(), "1"));
		}
		throw new ValidationException();
	}
	
	AbonentBillPosAccessBean abpBean = (AbonentBillPosAccessBean) bean;
	abpBean.setSummpurenri(abpBean.getSummnri().subtract(abpBean.getNdssummnri()).subtract(abpBean.getNspsummnri()));
	//setSumchangereason :
	AbonentBillAccessBean abBean = abpBean.getPos2bill();
	abBean.refreshCopyHelper();
	abBean.setSumchangereason(getSumchangereason());
	abBean.commitCopyHelper();
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
	throws Exception
{
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:56:14)
 * @return com.hps.july.persistence.ResourceAccessBean
 * @exception java.lang.Exception The exception description.
 */
private ResourceAccessBean constructResource() throws java.lang.Exception {
	if (pos2resource == null) {
		if (resource != 0) {
			pos2resource = new ResourceAccessBean();
			pos2resource.setInitKey_resource(resource);
			pos2resource.refreshCopyHelper();
		}
	}
	return pos2resource;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	try {
		AbonentBillPosAccessBean abpBean = (AbonentBillPosAccessBean) bean;

		setSummpure(abpBean.getSummpure().toString());
		setNdssumm(abpBean.getNdssumm().toString());
		setNspsumm(abpBean.getNspsumm().toString());
		setSumm(abpBean.getSumm().toString());
		setServname(abpBean.getItemname());
		setStartdate(abpBean.getPos2bill().getBillperiodstart());
		setEnddate(abpBean.getPos2bill().getBillperiodend());
		java.math.BigDecimal aval = AppUtils.getNamedValueBigDecimal(AppUtils.DEFAULT_RATE_NDS);
		setNdsrate(aval.toString());
		//причина изменения суммы в позиции счета:
		setSumchangereason(abpBean.getPos2bill().getSumchangereason());

	} catch (Exception e) {
		e.printStackTrace();
		setSummpure("");
		setNdssumm("");
		setNspsumm("");
		setSumm("");
		setServname("");
		setStartdate(null);
		setEnddate(null);
	}
}
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return java.sql.Date
 */
public java.sql.Date getBilldate() {
	return billdate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBillnds() {
	return billnds;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBillndsnri() {
	return billndsnri;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return java.lang.String
 */
public java.lang.String getBillnumber() {
	return billnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return int
 */
public int getBillpos() {
	return billpos;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBillsum() {
	return billsum;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getBillsumnri() {
	return billsumnri;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 15:37:47)
 * @return java.lang.String
 */
public java.lang.String getBillType() {
	return billType;
}
public AbstractEntityAccessBean getDataBean(HttpServletRequest request) {
	AbonentBillPosAccessBean bean = new AbonentBillPosAccessBean();
	bean.setInitKey_billpos(getBillpos());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return java.sql.Date
 */
public java.sql.Date getEnddate() {
	return enddate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.11.2003 12:04:40)
 * @return java.math.BigDecimal
 */
public String getNdsrate() {
	return ndsrate;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:44:12)
 * @return java.math.BigDecimal
 */
public String getNdssumm() {
	return ndssumm;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:44:58)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getNdssummnri() {
	return ndssummnri.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:44:58)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getNdssummnriFrm() {
	return ndssummnri.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:52:29)
 * @return java.math.BigDecimal
 */
public String getNspsumm() {
	return nspsumm;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:53:09)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getNspsummnri() {
	return nspsummnri.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:53:09)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getNspsummnriFrm() {
	return nspsummnri.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 16:04:33)
 * @return com.hps.july.persistence.ResourceAccessBean
 */
public Resource getPos2resource() throws Exception {
    ResourceAccessBean bean = constructResource();
    return bean != null ? (Resource) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 16:06:12)
 * @return int
 */
public int getResource() {
	return resource;
}
public Enumeration getServices() {
	try {
		return new ResourceAccessBean().findResourceBySubtype(new ResourceSubTypeKey(14));
	} catch(Exception e) {
		return new Vector().elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return java.lang.String
 */
public java.lang.String getServname() {
	return servname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @return java.sql.Date
 */
public java.sql.Date getStartdate() {
	return startdate;
}
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_BILL_POS_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 16:14:20)
 * @return boolean
 */
public boolean getSumbyhand() {
	return sumbyhand;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2004 16:16:02)
 * @return java.lang.String
 */
public java.lang.String getSumchangereason() {
	return sumchangereason;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:59:52)
 * @return java.math.BigDecimal
 */
public String getSumm() {
	return summ;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 15:00:52)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSummnri() {
	return summnri.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 15:00:52)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSummnriFrm() {
	return summnri.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:33:36)
 * @return java.math.BigDecimal
 */
public String getSummpure() {
	return summpure;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:34:22)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getSummpurenri() {
	return summpurenri.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:34:22)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getSummpurenriFrm() {
	return summpurenri.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	AbonentBillPosAccessBean bean = new AbonentBillPosAccessBean();
	bean.setInitKey_billpos(getBillpos());
	bean.refreshCopyHelper();

	setBillType(bean.getPos2bill().getBilltype());
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @param newBilldate java.sql.Date
 */
public void setBilldate(java.sql.Date newBilldate) {
	billdate = newBilldate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @param newBillnds java.math.BigDecimal
 */
public void setBillnds(java.math.BigDecimal newBillnds) {
	billnds = newBillnds;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @param newBillndsnri java.math.BigDecimal
 */
public void setBillndsnri(java.math.BigDecimal newBillndsnri) {
	billndsnri = newBillndsnri;
}
public void setBillnumber(java.lang.String newBillnumber) {
	billnumber = newBillnumber;
}
public void setBillpos(int newBillpos) {
	billpos = newBillpos;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @param newBillsum java.math.BigDecimal
 */
public void setBillsum(java.math.BigDecimal newBillsum) {
	billsum = newBillsum;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @param newBillsumnri java.math.BigDecimal
 */
public void setBillsumnri(java.math.BigDecimal newBillsumnri) {
	billsumnri = newBillsumnri;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2003 15:37:47)
 * @param newBillType java.lang.String
 */
public void setBillType(java.lang.String newBillType) {
	billType = newBillType;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @param newEnddate java.sql.Date
 */
public void setEnddate(java.sql.Date newEnddate) {
	enddate = newEnddate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.11.2003 12:04:40)
 * @param newNdsrate java.math.BigDecimal
 */
public void setNdsrate(String newNdsrate) {
	ndsrate = newNdsrate;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:44:12)
 * @param newNdssumm java.math.BigDecimal
 */
public void setNdssumm(String newNdssumm) {
	ndssumm = newNdssumm;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:44:58)
 * @param newNdssummnri com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setNdssummnri(BigDecimal newNdssummnri) {
	ndssummnri.setBigDecimal(newNdssummnri);
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:44:58)
 * @param newNdssummnri com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setNdssummnriFrm(String newNdssummnri) {
	ndssummnri.setString(newNdssummnri);
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:52:29)
 * @param newNspsumm java.math.BigDecimal
 */
public void setNspsumm(String newNspsumm) {
	nspsumm = newNspsumm;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:53:09)
 * @param newNspsummnri com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setNspsummnri(BigDecimal newNspsummnri) {
	nspsummnri.setBigDecimal(newNspsummnri);
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:53:09)
 * @param newNspsummnri com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setNspsummnriFrm(String newNspsummnri) {
	nspsummnri.setString(newNspsummnri);
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 16:04:33)
 * @param newPos2resource com.hps.july.persistence.ResourceAccessBean
 */
public void setPos2resource(com.hps.july.persistence.ResourceAccessBean newPos2resource) throws Exception {
	resource = newPos2resource == null ? 0 : newPos2resource.getResource();
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 16:06:12)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @param newServname java.lang.String
 */
public void setServname(java.lang.String newServname) {
	servname = newServname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 15:52:38)
 * @param newStartdate java.sql.Date
 */
public void setStartdate(java.sql.Date newStartdate) {
	startdate = newStartdate;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 16:14:20)
 * @param newSumbyhand boolean
 */
public void setSumbyhand(boolean newSumbyhand) {
	sumbyhand = newSumbyhand;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2004 16:16:02)
 * @param newSumchangereason java.lang.String
 */
public void setSumchangereason(java.lang.String newSumchangereason) {
	sumchangereason = newSumchangereason;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:59:52)
 * @param newSumm java.math.BigDecimal
 */
public void setSumm(String newSumm) {
	summ = newSumm;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 15:00:52)
 * @param newSummnri com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSummnri(BigDecimal newSummnri) {
	summnri.setBigDecimal(newSummnri);
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 15:00:52)
 * @param newSummnri com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSummnriFrm(String newSummnri) {
	summnri.setString(newSummnri);
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:33:36)
 * @param newSummpure java.math.BigDecimal
 */
public void setSummpure(String newSummpure) {
	summpure = newSummpure;
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:34:22)
 * @param newSummpurenri com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSummpurenri(BigDecimal newSummpurenri) {
	summpurenri.setBigDecimal(newSummpurenri);
}
/**
 * Insert the method's description here.
 * Creation date: (17.04.2003 14:34:22)
 * @param newSummpurenri com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setSummpurenriFrm(String newSummpurenri) {
	summpurenri.setString(newSummpurenri);
}
public void validateValues(ActionErrors errors) throws Exception {
	/**
		ndssummnri = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		nspsummnri = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		summnri
	*/
	if (summpurenri.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.abonentbillpos.summpurenri"));
	} else if (!summpurenri.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.abonentbillpos.summpurenri"));
	}

	if (ndssummnri.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.abonentbillpos.ndssummnri"));
	} else if (!ndssummnri.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.abonentbillpos.ndssummnri"));
	} else if (ndssummnri.getBigDecimal().signum() < 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.abonentbillpos.ndssummnri.negative"));
	}

	if (nspsummnri.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.abonentbillpos.nspsummnri"));
	} else if (!nspsummnri.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.abonentbillpos.nspsummnri"));
	} else if (nspsummnri.getBigDecimal().signum() < 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.abonentbillpos.nspsummnri.negative"));
	}

	if (summnri.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.abonentbillpos.summnri"));
		throw new ValidationException();
	} else if (!summnri.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.abonentbillpos.summnri"));
		throw new ValidationException();
	} else if (summnri.getBigDecimal().signum() < 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.abonentbillpos.summnri.negative"));
		throw new ValidationException();
	}

	if (sumbyhand) { //если отмечено "Признак ручной установки сумм"
		com.hps.july.web.util.StringAndBigDecimalProperty locSum = new com.hps.july.web.util.StringAndBigDecimalProperty();
		locSum.setString(summ);
		if (locSum.isEmpty() || !locSum.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.billing.sum"));
			throw new ValidationException();
		}
		if (summnri.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.nri.sum.empty"));
		} else if (!summnri.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.nri.sum.invalid"));
		}
		/**
		 * 15.04.04 закоментировано по согласованию с заказчиком
				else if (getSummnri().compareTo(locSum.getBigDecimal()) == 1) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.nri.sum.bigger"));
				}
		*/
		//проверка заполнения причины изменения суммы:
		if (sumchangereason == null || sumchangereason.trim().length() == 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.abonentbillpos.sumchangereason"));
		}
	}

	try {
		constructResource();
	} catch (Exception e) {
		if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.abonentbillpos.resource"));
		}
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
