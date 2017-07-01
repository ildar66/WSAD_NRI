package com.hps.july.siteinfo.formbean;

import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.web.util.ValidationException;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.siteinfo.TablesRef;
import com.hps.july.persistence2.CounterAccessBean;
import com.hps.july.persistence2.CounterInfoAccessBeanTable;
import com.hps.july.persistence2.CounterInfo;
import com.hps.july.cdbc.lib.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;
import java.util.Enumeration;
import java.util.Iterator;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

/**
 * Класс, реализующий форму редактирования  электросчётчиков
 * Creation date: (10.08.2004 18:13:28)
 * @author: Vadim Glushkov
 */
public class ElectroCounterForm extends com.hps.july.web.util.EditForm {

	private Integer counterid = null;
	private Integer counterinfo_id = null;
	private Integer positionid = null;
	private String position = null;

	private Integer cstate = null;

	private String initial_settingsFrm = null;
	private StringAndIntegerProperty initial_settings = new StringAndIntegerProperty();

	private String installation_dateFrm = null;
	private String last_verificationFrm = null;
	private String next_verificationFrm = null;

	private Integer nextid = null;
	private String place_info = null;
	private String production_year = null;

	private String replace_dateFrm = null;
	private com.hps.july.web.util.StringAndSqlDateProperty replace_date = new com.hps.july.web.util.StringAndSqlDateProperty();

	private String replace_reason = null;
	private String replace_settingsFrm = null;
	private StringAndIntegerProperty replace_settings = new StringAndIntegerProperty();

	private String dismantling_dateFrm = null;
	private com.hps.july.web.util.StringAndSqlDateProperty dismantling_date = new com.hps.july.web.util.StringAndSqlDateProperty();

	private String dismantling_reason = null;
	private String dismantling_settingsFrm = null;
	private String dismantling_setFrm = null;
	private StringAndIntegerProperty dismantling_settings = new StringAndIntegerProperty();
	private StringAndIntegerProperty dismantling_set = new StringAndIntegerProperty();

	private String vendor_number = null;
	private String verification_interFrm = null;

	private com.hps.july.web.util.StringAndSqlDateProperty installation_date = new com.hps.july.web.util.StringAndSqlDateProperty();
	private com.hps.july.web.util.StringAndSqlDateProperty last_verification = new com.hps.july.web.util.StringAndSqlDateProperty();
	private com.hps.july.web.util.StringAndSqlDateProperty next_verification = new com.hps.july.web.util.StringAndSqlDateProperty();

	private CDBCResultSet positionCounters = new CDBCResultSet();
	private CDBCResultSet counterModels = new CDBCResultSet();

	private boolean ignoreWarning = false;
	private Boolean isVendorPowerSupply = null;
	private String zoneName = null;
	private String modifiedByName = null;
	private Timestamp modifiedDate = null;

	public ElectroCounterForm() {
		super();
		setVerification_interFrm(new String("0"));
		setInitial_settingsFrm(new String("0"));
		setReplace_settingsFrm(new String("0"));
		setProduction_year(new String("2004"));
		setCstate(new Integer(1));
		setReturnPage("ShowElectroCounterList.do");
		setIsVendorPowerSupply(Boolean.TRUE);
		setZoneName("");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.08.2004 17:05:53)
	 * @param param com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public void beforeUpdate(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {

		try {
			CounterAccessBean counterBean = (CounterAccessBean) bean;

			counterBean.setModified_date(new java.sql.Timestamp(System.currentTimeMillis()));
			counterBean.setCounterinfo_id(this.counterinfo_id.intValue());
			if (this.positionid != null)
				counterBean.setPositionid(this.positionid.intValue());
			Integer cState = counterBean.getCstate();
			if (cState.intValue() == 1) {
				counterBean.setReplace_date(null);
				counterBean.setReplace_reason(null);
				counterBean.setReplace_settings(new Integer(0));
				counterBean.setNextid(null);
			} else if (cState.intValue() == 3) {
				counterBean.setNextid(null);
				counterBean.setReplace_date(new Date(System.currentTimeMillis()));
				counterBean.setReplace_reason(new String(""));
				counterBean.setReplace_settings(new Integer(0));
			} else if (cState.intValue() == 2) {
				counterBean.setDismantling_date(new Date(System.currentTimeMillis()));
				counterBean.setDismantling_reason(new String(""));
				counterBean.setDismantling_set(new Integer(0));
			}
			Integer nextId = counterBean.getNextid();
			if (nextid.intValue() == 0)
				counterBean.setNextid(null);
		} catch (Exception e) {
		}
	}
	/**
	 * Метод для создания новой записи.
	 * Creation date: (10.08.2004 18:13:28)
	 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		counterid = new Integer(keyGen.getNextKey(TablesRef.COUNTERS));
		CounterAccessBean bean = new CounterAccessBean(counterid.intValue(), counterinfo_id.intValue(), positionid.intValue());
		setReturnParam(counterid.toString());
		return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.08.2004 15:58:34)
	 * @param param com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean param) {

		try {
			CounterAccessBean counterBean = (CounterAccessBean) param;
			CDBCResultSet rs = new CDBCResultSet();
			StringBuffer sql = new StringBuffer("SELECT ");
			sql.append(" NVL('D' || p.gsmid || ' ','') ||  NVL('A' || p.dampsid || ' ','') || TRIM(sp.name) as name, p.netzone, n.name zoneName, ");
			sql.append(" c.counterinfo_id, ci.verification_inter, c.MODIFIED_DATE modifiedDate, getNameOperator(c.MODIFIEDBY) modifiedByName ");
			sql.append("FROM ");
			sql.append(" counters c, positions p, storageplaces sp, netzones n, counters_info ci ");
			sql.append("WHERE ");
			sql.append(" sp.storageplace = p.storageplace AND p.storageplace = c.positionid AND n.netzone = p.netzone AND c.counterinfo_id = ci.id AND c.positionid = ? AND c.counterid = ?");

			int positionId = counterBean.getPositionid();
			int counterId = counterBean.getCounterid();
			rs.executeQuery(sql.toString(), new Object[] { new Integer(positionId), new Integer(counterId)});
			Iterator iterator = rs.listIterator();
			if (iterator.hasNext()) {
				CDBCRowObject row = (CDBCRowObject) iterator.next();
				CDBCColumnObject object = row.getColumn("name");
				setPosition(object.asString());
				object = row.getColumn("counterinfo_id");
				setCounterinfo_id(new Integer(object.asString()));
				object = row.getColumn("verification_inter");
				setVerification_interFrm(object.asString());
				object = row.getColumn("zoneName");
				setZoneName(object.asString());
				object = row.getColumn("modifiedByName");
				setModifiedByName(object.asString());				
				object = row.getColumn("modifiedDate");
				setModifiedDate((Timestamp)object.asObject());				
			}

			StringBuffer sqlQuery = new StringBuffer("SELECT * FROM counters WHERE cstate != 3 AND positionid = ? AND counterid != ? ");
			this.positionCounters.executeQuery(sqlQuery.toString(), new Object[] { new Integer(positionId), new Integer(counterId)});

			/*			Integer cState = counterBean.getCstate();
						if(cState.intValue() == 3){
							setReplace_date1(counterBean.getReplace_date());
							setReplace_reason1(counterBean.getReplace_reason());
							setReplace_settings1(counterBean.getReplace_settings());
							setReplace_date(new java.sql.Date(System.currentTimeMillis()));
							setReplace_reason(new String(""));
							setReplace_settings(new Integer(0));
						} else if(cState.intValue() == 2){
							setReplace_date(counterBean.getReplace_date());
							setReplace_reason(counterBean.getReplace_reason());
							setReplace_settings(counterBean.getReplace_settings());
						}
			*/

		} catch (Exception e) {
		}

	}
	/**
	 * Текущее приложение.
	 * Creation date: (10.08.2004 18:13:28)
	 * @return int
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.SITEINFO;
	}
	public Integer getCounterid() {
		return counterid;
	}
	public Integer getCounterinfo_id() {
		return counterinfo_id;
	}
	public Iterator getCounterModels() throws Exception {
		return this.counterModels.listIterator();
	}
	public Integer getCstate() {
		return cstate;
	}
	/**
	 * Метод для поиска текущей записи.
	 * Creation date: (10.08.2004 18:13:28)
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		CounterAccessBean bean = new CounterAccessBean();
		bean.setInitKey_counterid(this.counterid.intValue());
		return bean;
	}
	public Date getDismantling_date() {
		return dismantling_date.getSqlDate();
	}
	public String getDismantling_dateFrm() {
		return this.dismantling_date.getString();
	}
	public String getDismantling_reason() {
		return dismantling_reason;
	}
	public Integer getDismantling_set() {
		return dismantling_set.getInteger();
	}
	public String getDismantling_setFrm() {
		return dismantling_set.getString();
	}
	public Integer getInitial_settings() {
		return initial_settings.getInteger();
	}
	public String getInitial_settingsFrm() {
		return initial_settings.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.08.2004 11:04:51)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public java.sql.Date getInstallation_date() {
		return this.installation_date.getSqlDate();
	}
	public String getInstallation_dateFrm() {
		return this.installation_date.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.08.2004 11:09:45)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public java.sql.Date getLast_verification() {
		return this.last_verification.getSqlDate();
	}
	public String getLast_verificationFrm() {
		return this.last_verification.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.08.2004 11:10:07)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public java.sql.Date getNext_verification() {
		return this.next_verification.getSqlDate();
	}
	public String getNext_verificationFrm() {
		return this.next_verification.getString();
	}
	public Integer getNextid() {
		return nextid;
	}
	public String getPlace_info() {
		return place_info;
	}
	public String getPosition() {
		return position;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.08.2004 17:51:35)
	 * @return java.util.Iterator
	 */
	public Iterator getPositionCounters() {
		return this.positionCounters.listIterator();
	}
	public Integer getPositionid() {
		return positionid;
	}
	public String getProduction_year() {
		return production_year;
	}
	public Date getReplace_date() {
		return replace_date.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.08.2004 17:40:09)
	 * @return java.lang.String
	 */
	public String getReplace_dateFrm() {
		return this.replace_date.getString();
	}
	public String getReplace_reason() {
		return replace_reason;
	}
	public Integer getReplace_settings() {
		return replace_settings.getInteger();
	}
	public String getReplace_settingsFrm() {
		return replace_settings.getString();
	}
	/**
	 * Текущее состояние приложения.
	 * Creation date: (10.08.2004 18:13:28)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.siteinfo.APPStates.ELECTTRO_COUNTER_EDIT;
	}
	public String getVendor_number() {
		return vendor_number;
	}
	public String getVerification_interFrm() {
		return verification_interFrm;
	}
	/**
	 * Инициализация коллекций перед отображением пользователю.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		try {
			StringBuffer sqlQuery = new StringBuffer("SELECT id, code, name, verification_inter FROM counters_info");
			this.counterModels.executeQuery(sqlQuery.toString(), new Object[] {
			});
		} catch (Exception e1) {
		}

	}
	/**
	 * Инициализация полей в режиме добавления записи.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2004 16:25:45)
	 * @return boolean
	 */
	public boolean isIgnoreWarning() {
		return ignoreWarning;
	}
	public void setCounterid(Integer counterid) {
		this.counterid = counterid;
	}
	public void setCounterinfo_id(Integer counterinfo_id) {
		this.counterinfo_id = counterinfo_id;
	}
	public void setCstate(Integer cstate) {
		this.cstate = cstate;
	}
	public void setDismantling_date(Date replace_date) {
		this.dismantling_date.setSqlDate(replace_date);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.08.2004 17:41:38)
	 * @param replace_date java.lang.String
	 */
	public void setDismantling_dateFrm(String replace_date) {
		this.dismantling_date.setString(replace_date);
	}
	public void setDismantling_reason(String replace_reason) {
		this.dismantling_reason = replace_reason;
	}
	public void setDismantling_set(Integer replace_settings) {
		this.dismantling_set.setInteger(replace_settings);
	}
	public void setDismantling_setFrm(String replace_settingsFrm) {
		this.dismantling_set.setString(replace_settingsFrm);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2004 16:25:45)
	 * @param newIgnoreWarning boolean
	 */
	public void setIgnoreWarning(boolean newIgnoreWarning) {
		ignoreWarning = newIgnoreWarning;
	}
	public void setInitial_settings(Integer initial_settings) {
		this.initial_settings.setInteger(initial_settings);
	}
	public void setInitial_settingsFrm(String initial_settingsFrm) {
		this.initial_settings.setString(initial_settingsFrm);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.08.2004 11:04:51)
	 * @param newInstallation_date com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setInstallation_date(java.sql.Date newInstallation_date) {
		this.installation_date.setSqlDate(newInstallation_date);

	}
	public void setInstallation_dateFrm(String installation_date) {
		this.installation_date.setString(installation_date);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.08.2004 11:09:45)
	 * @param newLast_verification com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setLast_verification(java.sql.Date newLast_verification) {
		this.last_verification.setSqlDate(newLast_verification);
	}
	public void setLast_verificationFrm(String last_verification) {
		this.last_verification.setString(last_verification);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.08.2004 11:10:07)
	 * @param newNext_verification com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setNext_verification(java.sql.Date newNext_verification) {
		this.next_verification.setSqlDate(newNext_verification);
	}
	public void setNext_verificationFrm(String next_verification) {
		this.next_verification.setString(next_verification);
	}
	public void setNextid(Integer nextid) {
		this.nextid = nextid;
	}
	public void setPlace_info(String place_info) {
		this.place_info = place_info;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setPositionid(Integer positionid) {
		this.positionid = positionid;
	}
	public void setProduction_year(String production_year) {
		this.production_year = production_year;
	}
	public void setReplace_date(Date replace_date) {
		this.replace_date.setSqlDate(replace_date);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.08.2004 17:41:38)
	 * @param replace_date java.lang.String
	 */
	public void setReplace_dateFrm(String replace_date) {
		this.replace_date.setString(replace_date);
	}
	public void setReplace_reason(String replace_reason) {
		this.replace_reason = replace_reason;
	}
	public void setReplace_settings(Integer replace_settings) {
		this.replace_settings.setInteger(replace_settings);
	}
	public void setReplace_settingsFrm(String replace_settingsFrm) {
		this.replace_settings.setString(replace_settingsFrm);
	}
	public void setVendor_number(String vendor_number) {
		this.vendor_number = vendor_number;
	}
	public void setVerification_interFrm(String verification_interFrm) {
		this.verification_interFrm = verification_interFrm;
	}
	/**
	 * Метод для проверки правильности ввода значений в поля ввода.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException - 
	 * при этом исключении ошибки отображаются пользователю.
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if (this.positionid == null && this.counterid == null)
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.electrocounter.position"));
		if (this.counterinfo_id == null || (this.counterinfo_id != null && this.counterinfo_id.intValue() == 0))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.electrocounter.counterinfo_id"));
		//проверка на уникальность:
		boolean checkWarning = true;
		if (getAction().equalsIgnoreCase(ACTION_ADD)) {
			checkWarning = checkUnique(errors);
		}
		//проверка по позиции:
		if (checkWarning) {
			checkWarning(errors);
		}

		if (!errors.empty())
			throw new ValidationException();
	}
	/**
	 * 
	 * @param errors
	 * @param checkWarning
	 * @return
	 */
	private boolean checkUnique(ActionErrors errors) {
		CDBCResultSet rs1 = new CDBCResultSet();
		try {
			rs1.executeQuery("SELECT c.counterid FROM counters c WHERE c.COUNTERINFO_ID = ? AND UPPER(c.vendor_number) MATCHES UPPER(?) ", new Object[] { this.counterinfo_id, this.vendor_number });
			int c1 = rs1.getRowsCount();
			if (c1 > 0) {
				errors.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("error.electrocounter.number.exist", "Электросчётчик с именем " + this.vendor_number + " и выбранной моделью уже присутствует в системе"));
				return false;
			}
		} catch (Exception e) {
			System.out.println(" errror checking counters by number  ");
			e.printStackTrace(System.out);
		}
		return true;
	}

	/**
	 * 
	 * @param errors
	 */
	private void checkWarning(ActionErrors errors) {
		if (!isIgnoreWarning()) {
			CDBCResultSet rs = new CDBCResultSet();
			try {
				rs.executeQuery("SELECT c.counterid FROM counters c WHERE c.positionid = ? ", new Object[] { this.positionid });
				int c = rs.getRowsCount();
				if (c > 0) {
					errors.add(
						"org.apache.struts.action.GLOBAL_WARNING",
						new ActionError("error.counters.txt", "На позиции уже установленны электросчётчики в количестве " + c + " . Если Вас это устраивает, то нажмите сохранить еще раз"));
					setIgnoreWarning(true);
				}
			} catch (Exception e) {
				System.out.println(" ERROR checking countest on position ");
				e.printStackTrace(System.out);
			}
		}
	}
	/**
	 * @return
	 */
	public Boolean getIsVendorPowerSupply() {
		return isVendorPowerSupply;
	}

	/**
	 * @param boolean1
	 */
	public void setIsVendorPowerSupply(Boolean boolean1) {
		isVendorPowerSupply = boolean1;
	}

	/**
	 * @return
	 */
	public String getZoneName() {
		return zoneName;
	}

	/**
	 * @param string
	 */
	public void setZoneName(String string) {
		zoneName = string;
	}

	/**
	 * @return
	 */
	public String getModifiedByName() {
		return modifiedByName;
	}

	/**
	 * @param string
	 */
	private void setModifiedByName(String string) {
		modifiedByName = string;
	}

	/**
	 * @return
	 */
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param timestamp
	 */
	private void setModifiedDate(Timestamp timestamp) {
		modifiedDate = timestamp;
	}

}
