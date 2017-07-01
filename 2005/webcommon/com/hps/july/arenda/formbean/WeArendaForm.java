package com.hps.july.arenda.formbean;

import com.hps.july.platinum.sessionbean.*; //platinum processor
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseOnPosition_Object;
import com.hps.july.arenda.cdbcobjects.CDBC_OrganizationObject;
import com.hps.july.arenda.sessionbean.*;
import org.apache.struts.util.*;
import com.hps.july.arenda.valueobject.*;
import java.util.*;
import com.ibm.ivj.ejb.runtime.*;
import java.math.*;
import org.apache.struts.action.*;

import com.hps.july.valueobject.Currency_VO;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.objects.CDBCArendaAgreementObject;
import com.hps.july.cdbc.objects.CDBC_OwnerContract2FilialNri_Object;
import com.hps.july.commonbean.*;
import java.sql.*;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.upload.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.persistence.Currency;
/**
 * Form-Bean
 * Информация о договорах аренды.
 * Creation date: (27.06.2002 17:40:14)
 * @author: Sergey Gourov
 */
public class WeArendaForm extends com.hps.july.web.util.EditForm {
    private int leaseDocument;
    private com.hps.july.web.util.StringAndSqlDateProperty documentDate;
    private java.lang.String documentNumber;
    private java.lang.String contractType;
    private java.lang.String contractState;
    private com.hps.july.web.util.StringAndIntegerProperty orgCustomercode;
    private com.hps.july.web.util.StringAndIntegerProperty orgExecutorcode;
    private com.hps.july.web.util.StringAndSqlDateProperty startDate;
    private com.hps.july.web.util.StringAndSqlDateProperty endDate;
    private com.hps.july.web.util.StringAndSqlDateProperty baseenddate;
    private java.lang.String extendType;
    private java.lang.String reportPeriod;
    private java.lang.String calcElectroType;
    private java.lang.Boolean isDogElectro;
    //private java.lang.String extendPeriod;
    private com.hps.july.persistence.OrganizationNfsAccessBean orgCustomer;
    private java.lang.String orgCustomername;
    private java.lang.String orgExecutorname;
    private com.hps.july.persistence.OrganizationNfsAccessBean orgExecutor;
    private com.hps.july.persistence.WorkerAccessBean economist;
    private java.lang.String economistname;
    private com.hps.july.web.util.StringAndIntegerProperty economistcode;
    private java.lang.String comment;
    private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal summ1;
    private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal summ2;
    private com.hps.july.persistence.CurrencyAccessBean currency1;
    private com.hps.july.persistence.CurrencyAccessBean currency2;
    private Integer currencycode1;
    private Integer currencycode2;
    private java.lang.String subject;
    //private int initialMainLeaseDoc;
    private java.lang.Boolean isSumm2;
    //private org.apache.struts.upload.FormFile formFile;
    private byte[] documentText;
    private java.lang.String docFileName;
    private java.lang.Boolean isDocumentText;
    protected java.lang.String errorEmptyDocNumber;
    private java.lang.Integer mainDocument;
    private java.lang.String mainDocumentNumber;
    private com.hps.july.web.util.StringAndSqlDateProperty mainDocumentDate;
    private java.lang.String custname;
    private java.lang.String execname;
    private java.lang.String dogelectonum;
    private com.hps.july.web.util.StringAndSqlDateProperty dogelectrodate;
    private java.lang.String ratecalcrule;
    private com.hps.july.web.util.StringAndIntegerProperty ratecalcruleday;
    private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal ratedelta;
    private java.lang.String SYNCNRIPLATINARENDA;
    private java.lang.String iddogovorplatinum;
    private java.lang.String vendor;
    private java.lang.String isPlatinumrecord; //if record is exist/found
    private int rur;

	//	private java.lang.String howGivePhones;
	//	private com.hps.july.web.util.StringAndIntegerProperty numberOfPhones;
	private StringAndIntegerProperty numberOfPhones; // Кол-во телефонов в собственность
	private StringAndIntegerProperty numberofphonestemp; // Кол-во телефонов во временное пользование
	private java.lang.Integer position; //главная позиция.
	private java.lang.String positionname; //имя главной позиции.
	private com.hps.july.persistence.WorkerAccessBean manager;
	private java.lang.String managername;
	private com.hps.july.web.util.StringAndIntegerProperty managercode;
	private boolean isPositionSelected;
	private boolean chargeNds;
	private boolean officialdoc;
	private java.sql.Date dateclose;
	private boolean needofficialdoc; //необходима регистрация в гос. органах.
	private java.lang.String changeenddate;
	//для контроля за ведением договора:
	private PeopleVO operatorVO;
	//период продления:
	private StringAndShort extendyears;
	private StringAndShort extendmonthes;
	private StringAndShort extenddays;
	//Акт приема-передачи:
	private boolean haveioact;
	private java.lang.String ioactnumber;
	private com.hps.july.web.util.StringAndSqlDateProperty ioactdate;
	//Налоговый агент:
	private boolean NalogAgent;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal RateNDS;
	//Список заказчиков:
	private List customers;
	//курсы валют:
	private boolean isRateLimit;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal rateLimitMin;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal rateLimitMax;
	private String posListSortBy;
	/**настройки по регионам*/
	private WeArandaFormView weArandaFormView = null;	
	private Integer regionID = null;//текущий регион
	private String buchdocnumber = null;//Номер договора в системе бух учета
	private Boolean havedocsigned = null;//У нас есть подписанный договор
	private Boolean havedocsignedcustomer = null;//У заказчика есть подписанный договор
	private java.sql.Timestamp created = null;//дата создания договора
	private String mainBuchDocNumber = null;//Номер главного договора в системе бух учета
	private java.sql.Timestamp mainCreated = null;//дата создания главного договора
	private final static BigDecimal MOUNTH = new BigDecimal(12);
	
	/**
	 * Insert the method's description here.
	 * Creation date: (03.07.2002 19:46:22)
	 */
	public WeArendaForm() {

		//platinum
		vendor = "";
		isPlatinumrecord = null; //no record found so far
		iddogovorplatinum = ""; //clear key field
		// end platinum

		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

		setCalcElectroType("1");
		setComment("");
		setContractState("A");
		setContractType("A");

		documentDate = new StringAndSqlDateProperty();
		//	documentDate.setSqlDate(date);
		//	setDocumentDate(date);

		mainDocumentDate = new StringAndSqlDateProperty();
		mainDocumentDate.setSqlDate(date);

		setDocumentNumber("");
		setSubject("");

		economistcode = new StringAndIntegerProperty();
		setEconomistcode(null);
		setEconomistname("");
		//patch SI start
		managercode = new StringAndIntegerProperty();
		setManagercode(null);
		setManagername("");
		//patch SI start

		endDate = new StringAndSqlDateProperty();
		endDate.setSqlDate(date);
		//	setEndDate(date);

		//setExtendPeriod("Y");
		//setExtendType("N");
		setExtendType("");

		setIsDogElectro(new Boolean(false));

		orgCustomercode = new StringAndIntegerProperty();
		setOrgCustomercode(new Integer(0));
		setOrgCustomername("");

		orgExecutorcode = new StringAndIntegerProperty();
		setOrgExecutorcode(null);
		setOrgExecutorname("");
		setReportPeriod("M");

		startDate = new StringAndSqlDateProperty();
		startDate.setSqlDate(date);
		//	setStartDate(date);

		setCurrencycode1(new Integer(0));
		setCurrencycode2(new Integer(0));

		summ1 = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		summ1.setBigDecimal(null);

		summ2 = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		summ2.setBigDecimal(null);

		setIsSumm2(new Boolean(false));

		setDocFileName("");
		setIsDocumentText(new Boolean(false));

		errorEmptyDocNumber = "error.empty.we.docnumber";
		dogelectrodate = new StringAndSqlDateProperty();

		ratecalcruleday = new StringAndIntegerProperty();
		ratedelta = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);

		//	setHowGivePhones("N");
		//	numberOfPhones = new StringAndIntegerProperty();
		//	setNumberOfPhones(null);

		numberOfPhones = new StringAndIntegerProperty();
		numberOfPhones.setInteger(null);
		numberofphonestemp = new StringAndIntegerProperty();
		numberofphonestemp.setInteger(null);

		baseenddate = new StringAndSqlDateProperty();
		baseenddate.setSqlDate(date);
		//инициализация периода продления:
		extendyears = new StringAndShort();
		extendmonthes = new StringAndShort();
		extenddays = new StringAndShort();
		//инициализация Акта приема-передачи:
		setHaveioact(false);
		ioactnumber = null;
		ioactdate = new StringAndSqlDateProperty();
		//инициализация Налоговый агент:
		setNalogAgent(false);
		RateNDS = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		RateNDS.setBigDecimal(null);
		//инициализация курсов:
		setIsRateLimit(false);
		rateLimitMin = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 4);
		rateLimitMin.setBigDecimal(null);
		rateLimitMax = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 4);
		rateLimitMax.setBigDecimal(null);
		/**настройки по регионам*/
		buchdocnumber = "";//Номер договора в системе бух учета
		havedocsigned = Boolean.FALSE;//У нас есть подписанный договор
		havedocsignedcustomer = Boolean.FALSE;//У заказчика есть подписанный договор

	}
	/**
	 * Включает позицию в акт по указанному leaseDocument и position
	 * При успешном добавлении позиции - cделать позицию главной.
	 */
	private void addMainPosition(LeaseArendaAgreementNewAccessBean bean) {
		if (position != null) {
			try {
				// Включает позицию в акт по указанному leaseDocument и position
				LeaseOnPositionAccessBean lopBean = new LeaseOnPositionAccessBean(new Integer(leaseDocument), position);
				// Сделать позицию главной
				bean.setMainposition((Position) lopBean.getPosition().getEJBRef());
			} catch (Exception e) {
				// Позиция создаться не может
				System.out.println("WeArendaForm.addMainPosition() : Can't create leaseOnPositions(" + leaseDocument + "," + position + ")");
				e.printStackTrace(System.out);
			}
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.03.2004 16:10:35)
	 */
	private void addManagerFromPosition() throws Exception {
		//System.out.println("Была выбрана позиция при добавлении записи"); //temp
		Integer typeOtvArenda = new Integer(com.hps.july.util.AppUtils.getNamedValueInt("RESPONSIBLE_ARENDA"));
		//System.out.println("typeOtvArenda: " + typeOtvArenda); //temp
		Enumeration enum = new PositionResponsibleWorkersAccessBean().findByPositionResponseType(getPosition(), typeOtvArenda);
		if (enum.hasMoreElements()) {
			PositionResponsibleWorkersAccessBean bean = (PositionResponsibleWorkersAccessBean) enum.nextElement();
			setManager(bean.getWorker());
			//System.out.println("ответственный менежер:" + getManager().getMan().getFullName()); //temp
		} else {
			setManager(null);
		}
		throw new ValidationException();
	}
	/**
	 * Creation date: (13.02.2002 10:17:44)
	 */
	public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception {
		//checkActive();//признак активности можно изменить только при смене состояния документа.

		/**
		 *признак активности можно изменить только при смене состояния документа:
		if (getMainDocument() != null) {
			new LeaseArendaAgreementProcessorAccessBean().changeActiveDocument(getMainDocument());
		}
		*/
	}
	/**
	 * Creation date: (13.02.2002 10:21:31)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		LeaseContractBLOBAccessBean beanBLOB = new LeaseContractBLOBAccessBean();
		beanBLOB.setInitKey_leaseDocument(getLeaseDocument());
		beanBLOB.refreshCopyHelper();
		/**
				if (getIsDocumentText().booleanValue() || (!formFile.getFileName().equals("") && formFile.getFileName() != null)) {
					beanBLOB.setDocumentText(getDocumentText());
				}
		*/
		beanBLOB.setComment(getComment());
		beanBLOB.setSubject(getSubject());
		beanBLOB.commitCopyHelper();
		// признак активносити не может измениться(редактируемое доп.соглашение  не активно)
		//checkActive();//признак активности можно изменить только при смене состояния документа.

		//add platinum, in that form we fill only 2 mandatory fields !
		////////////////////////////////////////////////////////////////////////////////////////////
		/**
		if (this.getAction().equals("Add")) {
			try {
				if (!vendor.equals("") && vendor != null) {
					//create record
					PIEDopInfoContrAccessBean pie;
					pie = new PIEDopInfoContrAccessBean(leaseDocument); //int argLeasedocument
					pie.refreshCopyHelper();
					pie.setVendor(vendor);
					//System.out.println("debug wearendaform.java, leaseDocument="+leaseDocument+" vendor="+vendor);
					pie.commitCopyHelper();
					return;
				} //if
			} catch (Exception e) {
				// e.printStackTrace();	
				System.out.println("wearendaform.java, Exception add plationum! leaseDocument=" + leaseDocument + " vendor=" + vendor);
				return;
			}
		} //if add
		*/
		/////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 *признак активности можно изменить только при смене состояния документа:
		 if (getMainDocument() != null) {
			new LeaseArendaAgreementProcessorAccessBean().changeActiveDocument(getMainDocument());
		}
		*/
		//patch SI start
		//добавление главной позиции:
		//if (this.getAction().equals("Add") && getMainDocument() == null) {
		if (this.getAction().equals("Add")) {
			addMainPosition((LeaseArendaAgreementNewAccessBean) bean);
		}
		//изменение исполнителя и отв. экономиста только для базового договора:
		if (this.getAction().equals("Edit") && getMainDocument() == null) {
			changeOrgExecutorAndEconomistAndManager((LeaseArendaAgreementNewAccessBean) bean);
		}
		//patch SI end
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:17:02)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		/**
		LeaseArendaAgreementNewAccessBean b = (LeaseArendaAgreementNewAccessBean) bean;
		if (b.getMainDocument() != null) {
			initialMainLeaseDoc = b.getMainDocument().intValue();
		}
		*/
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:21:31)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		/**	
		    if (!getIsDocumentText().booleanValue()) {
		        setDocumentText(formFile.getFileData());
		        if (!formFile.getFileName().equals("") && formFile.getFileName() != null) {
		            ((LeaseArendaAgreementNewAccessBean) bean).setDocFileName(formFile.getFileName());
		        }
		    } else {
		        setDocumentText(null);
		        ((LeaseArendaAgreementNewAccessBean) bean).setDocFileName(null);
		    }
		*/
		LeaseArendaAgreementNewAccessBean laanBean = (LeaseArendaAgreementNewAccessBean) bean;
		if (!checkRates()) {
			laanBean.setRatecalcrule(null);
			laanBean.setRatecalcruleday(null);
			laanBean.setRatedelta(null);
		}
		//контроль доступа:
		if (getOperatorVO() != null) {
			laanBean.setModifiedby(getOperatorVO().getMan());
			laanBean.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		}
		//устанавливаем Activecontract только при создании главного дока:
		if (laanBean.getMainDocument() == null && getAction().equals("Add")) {
			laanBean.setActivecontract(new Integer(laanBean.getLeaseDocument()));
		}
	}
	/**
	 * При разработке мы планировали что в каждом доп. соглашении может быть другая организация, но при работе столкнулись, что это неправильно.
	 * Сейчас организацию исполнителя (leasecontract.OrgExecutor )можно внести и изменить только в базовом договоре, 
	 * а в дополнительных соглашениях изменить организацию нельзя.
	 * !!! при изменении исполнителя в базовом - меняем его в доп. соглашениях.
	 * Creation date: (26.02.2004 18:20:42)
	 */
	private void changeOrgExecutorAndEconomistAndManager(LeaseArendaAgreementNewAccessBean mainAB) throws Exception {
		OrganizationNfs organzation = null;
		if (mainAB.getOrgExecutor() != null)
			organzation = (OrganizationNfs) mainAB.getOrgExecutor().getEJBRef();
		Worker economist = null;
		if (mainAB.getEconomist() != null)
			economist = (Worker) mainAB.getEconomist().getEJBRef();
		Worker manager = null;
		if (mainAB.getManager() != null)
			manager = (Worker) mainAB.getManager().getEJBRef();
		LeaseArendaAgreementNewAccessBean bean = null;
		//поиск доп. соглашений:
		Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(new Integer(leaseDocument), new Boolean(false), null, new Boolean(false), null, new Integer(1));
		while (e.hasMoreElements()) {
			bean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			bean.setOrgExecutor(organzation);
			bean.setEconomist(economist);
			bean.setManager(manager);
			bean.commitCopyHelper();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.01.2003 14:27:39)

	private void checkActive() throws Exception {
		if (initialMainLeaseDoc != 0) {
			LeaseArendaAgreementNewAccessBean bean = null;
			Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(new Integer(initialMainLeaseDoc), new Boolean(true), new Boolean(false), new Boolean(false), null, new Integer(2));
			if (e.hasMoreElements()) {
				bean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
			} else {
				bean = new LeaseArendaAgreementNewAccessBean();
				bean.setInitKey_leaseDocument(initialMainLeaseDoc);
				bean.refreshCopyHelper();
			}
			bean.setIsActive(new Boolean(true));
			bean.commitCopyHelper();
		}
	}
	 */	
	/**
	 * Insert the method's description here.
	 * Creation date: (24.07.2003 16:05:35)
	 * @return boolean
	 */
	private boolean checkRates() {
		return (getCurrencycode1().intValue() == getRur() && !getIsSumm2().booleanValue())
			|| (getCurrencycode1().intValue() == getRur() && getIsSumm2().booleanValue() && getCurrencycode2().intValue() == getRur()) ? false : true;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.06.2002 17:40:14)
	 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		setLeaseDocument(keyGen.getNextKey("tables.leasedocuments"));

		orgCustomer = constructCustomer();
		setCustname(orgCustomer.getName());
		setExecname(getOrgExecutorname());

		LeaseArendaAgreementNewAccessBean bean =
			new LeaseArendaAgreementNewAccessBean(
				getLeaseDocument(),
				getDocumentDate(),
				getDocumentNumber(),
				getContractType(),
				getContractState(),
				getOrgCustomercode(),
				getOrgExecutorcode(),
				getStartDate(),
				getEndDate(),
				getExtendType(),
				getReportPeriod(),
				new Boolean(true),
				"",
				getCalcElectroType(),
				getIsDogElectro(),
				getCustname(),
				getExecname(),
				getMainDocument());
		//для разделения по филиалам:
		bean.setRegionid(getRegionID().intValue());
		//контроль доступа:
		if (getOperatorVO() != null) {
			bean.setCreatedby(getOperatorVO().getMan());
			bean.setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
			bean.setModifiedby(getOperatorVO().getMan());
			bean.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		}

		return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:40:12)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private CurrencyAccessBean constructCurrency1() throws java.lang.Exception {
		//if (currency1 == null) {
		if (getCurrencycode1() != null) {
			currency1 = new CurrencyAccessBean();
			currency1.setInitKey_currency(getCurrencycode1().intValue());
			currency1.refreshCopyHelper();
		}
		//}
		return currency1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:40:12)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private CurrencyAccessBean constructCurrency2() throws java.lang.Exception {
		//if (currency2 == null) {
		if (getCurrencycode2() != null) {
			currency2 = new CurrencyAccessBean();
			currency2.setInitKey_currency(getCurrencycode2().intValue());
			currency2.refreshCopyHelper();
		}
		//}
		return currency2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 20:20:27)
	 * @return com.hps.july.persistence.OrganizationNfsAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private OrganizationNfsAccessBean constructCustomer() throws java.lang.Exception {
		//if (orgCustomer == null) {
		// Construct customer bean
		if (!orgCustomercode.isEmpty() && orgCustomercode.isOk()) {
			orgCustomer = new OrganizationNfsAccessBean();
			orgCustomer.setInitKey_organization(getOrgCustomercode().intValue());
			orgCustomer.refreshCopyHelper();
		}
		//}
		return orgCustomer;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:17:44)
	 * @return com.hps.july.persistence.WorkerAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private WorkerAccessBean constructEconomist() throws java.lang.Exception {
		//if (economist == null) {
		// Construct economist bean
		if (!economistcode.isEmpty() && economistcode.isOk()) {
			economist = new WorkerAccessBean();
			economist.setInitKey_worker(getEconomistcode().intValue());
			economist.refreshCopyHelper();
		}
		//}
		return economist;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 21:08:03)
	 * @return com.hps.july.persistence.OrganizationNfsAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	protected OrganizationNfsAccessBean constructExecutor() throws java.lang.Exception {
		//if (orgExecutor == null) {
		// Construct executor bean
		if (!orgExecutorcode.isEmpty() && orgExecutorcode.isOk()) {
			orgExecutor = new OrganizationNfsAccessBean();
			orgExecutor.setInitKey_organization(getOrgExecutorcode().intValue());
			orgExecutor.refreshCopyHelper();
		}
		//}
		/**
		if (orgExecutor.getBank().booleanValue()) {
			throw new javax.ejb.ObjectNotFoundException();
		}
		*/
		return orgExecutor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.03.2004 17:31:10)
	 */
	private WorkerAccessBean constructManager() throws java.lang.Exception {
		//if (manager == null) {
		// Construct manager bean
		if (!managercode.isEmpty() && managercode.isOk()) {
			manager = new WorkerAccessBean();
			manager.setInitKey_worker(getManagercode().intValue());
			manager.refreshCopyHelper();
		}
		//}
		return manager;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.06.2005 18:50:01)
	 */
	private void correctEndDate() {
		// setEndDate(getBaseenddate());
		if (getAction().equals("Add")) {
			setEndDate(getBaseenddate());
		} else if (getAction().equals("Edit")) {
			if ("N".equals(extendType) || "M".equals(extendType)) {
				setEndDate(getBaseenddate());
			} else if ("A".equals(extendType)) {
				//if (getBaseenddate().after(getEndDate()))
				//   setEndDate(getBaseenddate());
				//проверка признака ручной установки "endDate":
				//System.out.println("getChangeenddate()=" + getChangeenddate()); //temp
				if (!"A".equals(getChangeenddate()))
					setEndDate(getBaseenddate());
			}
		}

	}

	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:27:25)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void fillRecord(AbstractEntityAccessBean bean) {
		setIsDocumentText(new Boolean(false));
		economist = null;
		orgCustomer = null;
		orgExecutor = null;
		currency1 = null;
		currency2 = null;
		//patch SI start
		position = null;
		positionname = null;
		//patch SI end
		LeaseContractBLOBAccessBean beanBLOB = new LeaseContractBLOBAccessBean();
		beanBLOB.setInitKey_leaseDocument(getLeaseDocument());

		try {
			setComment(beanBLOB.getComment());
			setSubject(beanBLOB.getSubject());
		} catch (Exception e) {
			e.printStackTrace();
			setComment("");
			setSubject("");
		}

		if (getMainDocument() != null) {
			try {
				LeaseArendaAgreementNewAccessBean leaseBean = new LeaseArendaAgreementNewAccessBean();
				leaseBean.setInitKey_leaseDocument(getMainDocument().intValue());
				leaseBean.refreshCopyHelper();

				setMainDocumentDate(leaseBean.getDocumentDate());
				setMainDocumentNumber(leaseBean.getDocumentNumber());
				//patch SI start
				setMainBuchDocNumber(leaseBean.getBuchdocnumber());
				setMainCreated(leaseBean.getCreated());
				//PositionAccessBean mainPos = leaseBean.getMainposition();
				PositionAccessBean mainPos = ((LeaseArendaAgreementNewAccessBean) bean).getMainposition();
				if (mainPos != null) {
					setPositionname(com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(mainPos));
					setPosition(new Integer(mainPos.getStorageplace()));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			try {
				PositionAccessBean mainPos = ((LeaseArendaAgreementNewAccessBean) bean).getMainposition();
				if (mainPos != null) {
					setPositionname(com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(mainPos));
					setPosition(new Integer(mainPos.getStorageplace()));
				}
				//patch SI end
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// read platinum
		setVendor("");
		setIsPlatinumrecord(null); //no record
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.06.2002 17:40:14)
	 * @return int
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.05.2005 18:37:02)
	 * @return java.sql.Date
	 */
	public java.sql.Date getBaseenddate() {
		return baseenddate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.05.2005 10:44:53)
	 */
	public String getBaseenddateFrm() {
		return baseenddate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:53:35)
	 * @return java.lang.String
	 */
	public java.lang.String getCalcElectroType() {
		return calcElectroType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.08.2005 11:50:22)
	 * @return java.lang.String
	 */
	public java.lang.String getChangeenddate() {
		return changeenddate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.05.2004 11:43:36)
	 * @return boolean
	 */
	public boolean getChargeNds() {
		return chargeNds;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:32:53)
	 * @return java.lang.String
	 */
	public java.lang.String getComment() {
		return comment;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:05:10)
	 * @return java.lang.String
	 */
	public java.lang.String getContractState() {
		return contractState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:03:49)
	 * @return java.lang.String
	 */
	public java.lang.String getContractType() {
		return contractType;
	}
	public java.util.Enumeration getCurrencies() {
		try {
			CurrencyAccessBean bean = new CurrencyAccessBean();
			return bean.findAllOrderByNameAsc();
		} catch (Exception e) {
			return (new java.util.Vector()).elements();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:12:26)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 */
	public Currency getCurrency1() throws Exception {
		CurrencyAccessBean bean = constructCurrency1();
		if (bean != null)
			return (Currency) bean.getEJBRef();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:12:26)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 */
	public Currency getCurrency2() throws Exception {
		if (getIsSumm2().booleanValue()) {
			CurrencyAccessBean bean = constructCurrency2();
			if (bean != null) {
				return (Currency) bean.getEJBRef();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:27:40)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCurrencycode1() {
		return currencycode1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:27:40)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCurrencycode2() {
		return currencycode2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.10.2002 17:13:03)
	 * @return java.lang.String
	 */
	public java.lang.String getCustname() {
		return custname;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (27.06.2002 17:40:14)
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		bean.setInitKey_leaseDocument(getLeaseDocument());

		return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.03.2005 16:43:07)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDateclose() {
		return dateclose;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.08.2002 17:46:23)
	 * @return java.lang.String
	 */
	public java.lang.String getDocFileName() {
		return docFileName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 15:50:35)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getDocumentDate() {
		return documentDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 15:50:35)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getDocumentDateFrm() {
		return documentDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 15:52:00)
	 * @return java.lang.String
	 */
	public java.lang.String getDocumentNumber() {
		return documentNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.08.2002 17:36:50)
	 * @return byte[]
	 */
	public byte[] getDocumentText() {
		return documentText;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.10.2002 16:38:01)
	 * @return java.lang.String
	 */
	public java.lang.String getDogelectonum() {
		return isDogElectro.booleanValue() ? dogelectonum : null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.10.2002 16:39:16)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getDogelectrodate() {
		return isDogElectro.booleanValue() ? dogelectrodate.getSqlDate() : null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.10.2002 16:39:16)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getDogelectrodateFrm() {
		return dogelectrodate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:12:39)
	 * @return com.hps.july.persistence.WorkerAccessBean
	 */
	public Worker getEconomist() throws Exception {
		WorkerAccessBean bean = constructEconomist();
		if (bean != null) {
			return (Worker) bean.getEJBRef();
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:14:24)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public Integer getEconomistcode() {
		return economistcode.getInteger();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:14:24)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public String getEconomistcodeFrm() {
		return economistcode.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:13:29)
	 * @return java.lang.String
	 */
	public java.lang.String getEconomistname() {
		return economistname;
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
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:30:24)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getEndDate() {
		return endDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:30:24)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getEndDateFrm() {
		return endDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.10.2002 17:13:40)
	 * @return java.lang.String
	 */
	public java.lang.String getExecname() {
		return execname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 18:31:21)
	 * @return java.lang.String
	
	public java.lang.String getExtendPeriod() {
		return extendPeriod;
	}
	*/
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:42:05)
	 * @return java.lang.String
	 */
	public java.lang.String getExtendType() {
		return extendType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.08.2002 18:57:51)
	 * @return org.apache.struts.upload.FormFile
	
	public org.apache.struts.upload.FormFile getFormFile() {
		return formFile;
	}
	 */
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2003 13:40:29)
	 * @return java.lang.String
	 */
	public java.lang.String getIddogovorplatinum() {
		return iddogovorplatinum;
	}
	public String getInn() throws Exception {
		OrganizationNfsAccessBean bean = constructExecutor();
		if (bean != null) {
			return bean.getInn();
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.08.2002 17:49:43)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getIsDocumentText() {
		return isDocumentText;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.08.2002 10:44:22)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getIsDogElectro() {
		return isDogElectro;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.01.2003 13:01:41)
	 * @return java.lang.String
	 */
	public java.lang.String getIsPlatinumrecord() {
		return isPlatinumrecord;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.08.2002 17:17:15)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getIsSumm2() {
		return isSumm2;
	}
	public String getKpp() throws Exception {
		OrganizationNfsAccessBean bean = constructExecutor();
		if (bean != null) {
			return bean.getKpp();
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 15:49:05)
	 * @return int
	 */
	public int getLeaseDocument() {
		return leaseDocument;
	}
	public String getLegaladdress() throws Exception {
		OrganizationNfsAccessBean bean = constructExecutor();
		if (bean != null) {
			return bean.getLegaladdress();
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.08.2002 16:53:26)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getMainDocument() {
		return mainDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.08.2002 17:23:44)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getMainDocumentDate() {
		return mainDocumentDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.08.2002 17:23:44)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getMainDocumentDateFrm() {
		return mainDocumentDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.08.2002 17:35:41)
	 * @return java.lang.String
	 */
	public java.lang.String getMainDocumentNumber() {
		return mainDocumentNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.03.2004 16:56:12)
	 * @return com.hps.july.persistence.Worker
	 */
	public com.hps.july.persistence.Worker getManager() throws Exception {
		WorkerAccessBean bean = constructManager();
		if (bean != null) {
			return (Worker) bean.getEJBRef();
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.03.2004 16:56:12)
	 * @return Integer
	 */
	public Integer getManagercode() {
		return managercode.getInteger();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.03.2004 16:58:39)
	 */
	public String getManagercodeFrm() {
		return managercode.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.03.2004 16:56:12)
	 * @return java.lang.String
	 */
	public java.lang.String getManagername() {
		return managername;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.05.2005 10:43:08)
	 * @return boolean
	 */
	public boolean getNeedofficialdoc() {
		return needofficialdoc;
	}
	public Integer getNumberOfPhones() {
		return numberOfPhones.getInteger();
	}
	public String getNumberOfPhonesFrm() {
		return numberOfPhones.getString();
	}
	public Integer getNumberofphonestemp() {
		return numberofphonestemp.getInteger();
	}
	public String getNumberofphonestempFrm() {
		return numberofphonestemp.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.03.2005 10:54:43)
	 * @return boolean
	 */
	public boolean getOfficialdoc() {
		return officialdoc;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.12.2005 12:46:30)
	 * @return com.hps.july.arenda.valueobject.PeopleVO
	 */
	private com.hps.july.arenda.valueobject.PeopleVO getOperatorVO() {
		return operatorVO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 20:28:20)
	 * @return com.hps.july.persistence.OrganizationNfsAccessBean
	 */
	public OrganizationNfs getOrgCustomer() throws Exception {
		OrganizationNfsAccessBean bean = constructCustomer();
		if (bean != null) {
			return (OrganizationNfs) bean.getEJBRef();
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:14:33)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public Integer getOrgCustomercode() {
		return orgCustomercode.getInteger();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:14:33)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public String getOrgCustomercodeFrm() {
		return orgCustomercode.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 20:59:17)
	 * @return java.lang.String
	 */
	public java.lang.String getOrgCustomername() {
		return orgCustomername;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 21:10:26)
	 * @return com.hps.july.persistence.OrganizationNfsAccessBean
	 */
	public OrganizationNfs getOrgExecutor() throws Exception {
		OrganizationNfsAccessBean bean = constructExecutor();
		if (bean != null) {
			return (OrganizationNfs) bean.getEJBRef();
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:19:00)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public Integer getOrgExecutorcode() {
		return orgExecutorcode.getInteger();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:19:00)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public String getOrgExecutorcodeFrm() {
		return orgExecutorcode.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 21:05:44)
	 * @return java.lang.String
	 */
	public java.lang.String getOrgExecutorname() {
		return orgExecutorname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.12.2002 15:16:48)
	 * @return java.util.Map
	 */
	public Map getParamsForReglament() {
		try {
			Hashtable hashtable = new Hashtable(2);
			hashtable.put("isLeaseContract", new Boolean(false));
			hashtable.put("leaseContract", new Integer(new LeaseArendaAgreementProcessorAccessBean().getBaseContract(getLeaseDocument())));
			return hashtable;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Hashtable(2);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.02.2004 14:29:48)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getPosition() {
		return position;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.02.2004 14:30:34)
	 * @return java.lang.String
	 */
	public java.lang.String getPositionname() {
		return positionname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.11.2002 11:18:41)
	 * @return java.lang.String
	 */
	public java.lang.String getRatecalcrule() {
		return ratecalcrule;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2002 12:17:12)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public Short getRatecalcruleday() {
		return "F".equals(getRatecalcrule()) || "G".equals(getRatecalcrule()) ? new Short(ratecalcruleday.getInteger().shortValue()) : null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2002 12:17:12)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public String getRatecalcruledayFrm() {
		return ratecalcruleday.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2002 12:35:57)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getRatedelta() {
		return ratedelta.getBigDecimal();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2002 12:35:57)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getRatedeltaFrm() {
		return ratedelta.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:43:01)
	 * @return java.lang.String
	 */
	public java.lang.String getReportPeriod() {
		return reportPeriod;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.07.2003 11:37:40)
	 * @return int
	 */
	public int getRur() {
		return rur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:24:53)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getStartDate() {
		return startDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:24:53)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getStartDateFrm() {
		return startDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.06.2002 17:40:14)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.WE_ARENDA_EDIT;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 17:10:53)
	 * @return java.lang.String
	 */
	public java.lang.String getSubject() {
		return subject;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 13:08:55)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getSumm1() {
		return summ1.getBigDecimal();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 13:08:55)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getSumm1Frm() {
		return summ1.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 13:15:21)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getSumm2() {
		if (getIsSumm2().booleanValue()) {
			return summ2.getBigDecimal();
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 13:15:21)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getSumm2Frm() {
		return summ2.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2003 13:38:15)
	 * @return java.lang.String
	 */
	public java.lang.String getSYNCNRIPLATINARENDA() {
		return SYNCNRIPLATINARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.01.2003 10:21:56)
	 * @return java.lang.String
	 */
	public java.lang.String getVendor() {
		return vendor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		//для контроля доступа:
		setRegionID(ProfileAccessHelper.getCurrentRegionID(request));
		setWeArandaFormView(RegionFactoryAbstract.getFactory(getRegionID().intValue()).getWeArandaFormView());
		if (operatorVO == null) {
			operatorVO = com.hps.july.arenda.cdbcobjects.CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser());
		}
		//Устанавливаем нац. валюту:
		try {
			Currency_VO nationalCurrVO = ProfileAccessHelper.getNationalCurrency_VO(request);
			if (nationalCurrVO != null) {
				setRur(nationalCurrVO.getCurrency().intValue());
			} else {
				NamedValueAccessBean namedBean = new NamedValueAccessBean();
				namedBean.setInitKey_id("RUR");
				namedBean.refreshCopyHelper();
				setRur(namedBean.getIntvalue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			setRur(0);
		}

		//Список заказчиков:
		//initCustomers(request);
		setCustomers(CDBC_OwnerContract2FilialNri_Object.getList(getRegionID(), "name"));	
		/**
		    //platinum
		    setSYNCNRIPLATINARENDA(null);
		    try {
		        if (new ArendaPlatinumProcessorAccessBean().isProcessingEnabled()) {
		            setSYNCNRIPLATINARENDA("ok");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    //platinum end
		*/
		if (getAction().equals("View")) {
			LeaseArendaAgreementNewAccessBean laaBean = new LeaseArendaAgreementNewAccessBean();
			laaBean.setInitKey_leaseDocument(getLeaseDocument());
			laaBean.refreshCopyHelper();

			int doc4pos = getLeaseDocument();
			/** доп соглашения имеют свой список позиций 
			if (laaBean.getMainDocument() != null) {
			    doc4pos = laaBean.getMainDocument().intValue();
			}
			*/
			/**
			        Enumeration e = new LeaseOnPositionAccessBean().findLeaseonpositionsByLeaseArendaAgreementNew(new LeaseDocumentKey(doc4pos));
			
			        if (e.hasMoreElements()) {
			            Vector v = new Vector();
			            while (e.hasMoreElements()) {
			
			                LeaseOnPositionAccessBean bean = (LeaseOnPositionAccessBean) e.nextElement();
			                LeaseOnPositionValueObject valueObject = new LeaseOnPositionValueObject(bean);
			
			                try {
			                    PositionResponsibleWorkersAccessBean workResponsibility = new PositionResponsibleWorkersAccessBean();
			                    workResponsibility.setInitKey_resptype("W");
			                    workResponsibility.setInitKey_position_storageplace(new Integer(bean.getPosition().getStorageplace()));
			
			                    NamedValueAccessBean namedValue = new NamedValueAccessBean();
			                    namedValue.setInitKey_id("RESPONSIBLE_ARENDA");
			                    namedValue.refreshCopyHelper();
			
			                    workResponsibility.setInitKey_type_responsibilityType(new Integer(namedValue.getIntvalue()));
			                    workResponsibility.refreshCopyHelper();
			
			                    valueObject.setMainManager(workResponsibility.getWorker().getMan().getFullName());
			                } catch (Exception ex) {
			                    //ex.printStackTrace();
			                    valueObject.setMainManager("");
			                }
			
			                v.addElement(valueObject);
			            }
			            request.setAttribute("posList", v.elements());
			        }
			*/
			//Список позиций:
			request.setAttribute("posList", CDBC_LeaseOnPosition_Object.findPositionsByLeaseArendaAgreementNew(new Integer(doc4pos), getPosListSortBy()));
			//Список chargerulesList:
			Enumeration e = null;
			e = new LeaseChargeRuleAccessBean().findByLeaseDocument(new Integer(getLeaseDocument()), new Integer(1));
			if (e.hasMoreElements()) {
				request.setAttribute("chargerulesList", e);
			}
			//Список payryleList:
			e = new LeasePayRuleAccessBean().findByLeaseDocument(new Integer(getLeaseDocument()), new Boolean(false), new Integer(1));
			if (e.hasMoreElements()) {
				request.setAttribute("payrulesList", e);
			}
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		mainDocument = null;

		setIddogovorplatinum(""); //platinum
		setLeaseDocument(0); //platinum
		setVendor(""); //platinum
		isPlatinumrecord = null; //no record yet

		setCalcElectroType("1");
		setComment("");
		setContractState("A");
		setContractType("A");

		documentDate.setSqlDate(null);

		setDocumentNumber("");
		setSubject("");

		endDate.setSqlDate(null);
		baseenddate.setSqlDate(null);

		//setExtendPeriod("Y");
		//setExtendType("N");
		setExtendType("");

		setIsDogElectro(new Boolean(false));

		setReportPeriod("M");
		startDate.setSqlDate(null);

		NamedValueAccessBean namedValue = new NamedValueAccessBean();
		namedValue.setInitKey_id("BASE_CURRENCY");
		namedValue.refreshCopyHelper();

		setCurrencycode1(new Integer(namedValue.getIntvalue()));
		setCurrencycode2(new Integer(namedValue.getIntvalue()));
		summ1.setBigDecimal(null);
		summ2.setBigDecimal(null);
		setIsSumm2(new Boolean(false));
		setIsDocumentText(new Boolean(false));

		docFileName = null;
		///
		setRatecalcrule("");
		///
		setRatecalcruleday(null);
		setRatedelta(new BigDecimal(0));

		WeArendaListForm form = (WeArendaListForm) request.getSession().getAttribute("WeArendaListForm");

		if (!form.getIsCustomer().booleanValue()) {
			setOrgCustomercode(form.getCustomercode());
		} else {
			setOrgCustomercode(null);
		}

		if (!form.getIsExecutor().booleanValue()) {
			setOrgExecutorcode(form.getExecutorcode());
			try {
				setOrgExecutorname(constructExecutor().getName());
			} catch (Exception e) {
				e.printStackTrace();
				setOrgExecutorname("");
			}
		} else {
			setOrgExecutorcode(null);
			setOrgExecutorname("");
		}

		try {
			OperatorAccessBean bean = new OperatorAccessBean();
			OperatorAccessBean operator = bean.findByLogin(request.getUserPrincipal().getName());

			WorkerAccessBean worker = new WorkerAccessBean();
			Enumeration e = worker.findWorkersByMan(operator.getManKey());
			if (e.hasMoreElements()) {
				setEconomistcode(new Integer(((WorkerAccessBean) e.nextElement()).getWorker()));
				setEconomistname(constructEconomist().getMan().getFullName());
			} else {
				setEconomistcode(null);
				setEconomistname("");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setEconomistcode(null);
			setEconomistname("");
		}

		setNumberOfPhones(null);
		setNumberofphonestemp(null);
		//	setHowGivePhones("N");
		//	setNumberOfPhones(null);

		/*	if (!form.getIsEconomist().booleanValue()) {
				setEconomistcode(form.getEconomistcode());
				try {
					setEconomistname(constructEconomist().getMan().getFullName());
				} catch (Exception e) {
					e.printStackTrace();
					setEconomistname("");
				}
			} else {
				setEconomistcode(null);
				setEconomistname("");
			}*/

		//patch SI start
		//инициализируем главную позицию:
		setPosition(null);
		setPositionname(null);
		//инициализируем отв. менеджера:
		setManager(null);
		setChargeNds(false);
		//patch SI end
		setChangeenddate("H");
		//инициализация "Регистрация договора в гос.органах":
		setNeedofficialdoc(false);
		setOfficialdoc(false);
		//инициализация периода продления:
		extendyears = new StringAndShort();
		extendmonthes = new StringAndShort();
		extenddays = new StringAndShort();
		//инициализация Акта приема-передачи:
		setHaveioact(false);
		setIoactdate(null);
		setIoactnumber(null);
		//Налоговый агент:
		setNalogAgent(false);
		setRateNDS(null);
		/**инициализация настройки по регионам*/
		setBuchdocnumber("");//Номер договора в системе бух учета
		setHavedocsigned(Boolean.FALSE);//У нас есть подписанный договор
		setHavedocsignedcustomer(Boolean.FALSE);//У заказчика есть подписанный договор
		setCreated(new Timestamp(System.currentTimeMillis()));//дата создания договора		
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.05.2004 11:43:36)
	 * @return boolean
	 */
	public boolean isChargeNds() {
		return chargeNds;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.03.2004 14:28:45)
	 * @return boolean
	 */
	public boolean isIsPositionSelected() {
		return isPositionSelected;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		String errorTxt = CDBCArendaAgreementObject.deleteCascade(getLeaseDocument());
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30.05.2005 18:37:02)
	 * @param newBaseenddate java.sql.Date
	 */
	public void setBaseenddate(java.sql.Date newBaseenddate) {
		baseenddate.setSqlDate(newBaseenddate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.05.2005 10:43:54)
	 */
	public void setBaseenddateFrm(String newBaseenddateStr) {
		baseenddate.setString(newBaseenddateStr);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:53:35)
	 * @param newCalcElectroType java.lang.String
	 */
	public void setCalcElectroType(java.lang.String newCalcElectroType) {
		calcElectroType = newCalcElectroType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.08.2005 11:50:22)
	 * @param newChangeenddate java.lang.String
	 */
	public void setChangeenddate(java.lang.String newChangeenddate) {
		changeenddate = newChangeenddate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.05.2004 11:43:36)
	 * @param newChargeNds boolean
	 */
	public void setChargeNds(boolean newChargeNds) {
		chargeNds = newChargeNds;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:32:53)
	 * @param newComment java.lang.String
	 */
	public void setComment(java.lang.String newComment) {
		comment = newComment;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:05:10)
	 * @param newContractState java.lang.String
	 */
	public void setContractState(java.lang.String newContractState) {
		contractState = newContractState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:03:49)
	 * @param newContractType java.lang.String
	 */
	public void setContractType(java.lang.String newContractType) {
		contractType = newContractType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:12:26)
	 * @param newCurrency1 com.hps.july.persistence.CurrencyAccessBean
	 */
	public void setCurrency1(com.hps.july.persistence.CurrencyAccessBean newCurrency1) throws Exception {
		if (newCurrency1 == null) {
			currencycode1 = new Integer(0);
		} else {
			currencycode1 = new Integer(newCurrency1.getCurrency());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:12:26)
	 * @param newCurrency2 com.hps.july.persistence.CurrencyAccessBean
	 */
	public void setCurrency2(com.hps.july.persistence.CurrencyAccessBean newCurrency2) throws Exception {
		if (newCurrency2 == null) {
			currencycode2 = new Integer(0);
		} else {
			currencycode2 = new Integer(newCurrency2.getCurrency());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:27:40)
	 * @param newCurrencycode java.lang.Integer
	 */
	public void setCurrencycode1(java.lang.Integer newCurrencycode1) {
		currencycode1 = newCurrencycode1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 15:27:40)
	 * @param newCurrencycode java.lang.Integer
	 */
	public void setCurrencycode2(java.lang.Integer newCurrencycode2) {
		currencycode2 = newCurrencycode2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.10.2002 17:13:03)
	 * @param newCustname java.lang.String
	 */
	public void setCustname(java.lang.String newCustname) {
		custname = newCustname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.03.2005 16:43:07)
	 * @param newDateclose java.sql.Date
	 */
	public void setDateclose(java.sql.Date newDateclose) {
		dateclose = newDateclose;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.08.2002 17:46:23)
	 * @param newDocFileName java.lang.String
	 */
	public void setDocFileName(java.lang.String newDocFileName) {
		docFileName = newDocFileName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 15:50:35)
	 * @param newDocDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setDocumentDate(Date newDocumentDate) {
		documentDate.setSqlDate(newDocumentDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 15:50:35)
	 * @param newDocDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setDocumentDateFrm(String newDocumentDate) {
		documentDate.setString(newDocumentDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 15:52:00)
	 * @param newDocNumber java.lang.String
	 */
	public void setDocumentNumber(java.lang.String newDocumentNumber) {
		documentNumber = newDocumentNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.08.2002 17:36:50)
	 * @param newDocumentText byte[]
	 */
	public void setDocumentText(byte[] newDocumentText) {
		documentText = newDocumentText;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.10.2002 16:38:01)
	 * @param newDogelectonum java.lang.String
	 */
	public void setDogelectonum(java.lang.String newDogelectonum) {
		dogelectonum = newDogelectonum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.10.2002 16:39:16)
	 * @param newDogelectrodate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setDogelectrodate(Date newDogelectrodate) {
		dogelectrodate.setSqlDate(newDogelectrodate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.10.2002 16:39:16)
	 * @param newDogelectrodate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setDogelectrodateFrm(String newDogelectrodate) {
		dogelectrodate.setString(newDogelectrodate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:12:39)
	 * @param newEconomist com.hps.july.persistence.WorkerAccessBean
	 */
	public void setEconomist(com.hps.july.persistence.WorkerAccessBean newEconomist) throws Exception {
		if (newEconomist == null) {
			economistcode.setInteger(null);
			economistname = "";
		} else {
			economistcode.setInteger(new Integer(newEconomist.getWorker()));
			economistname = newEconomist.getMan().getFullName();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:14:24)
	 * @param newEconomistcode com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setEconomistcode(Integer newEconomistcode) {
		economistcode.setInteger(newEconomistcode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:14:24)
	 * @param newEconomistcode com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setEconomistcodeFrm(String newEconomistcode) {
		economistcode.setString(newEconomistcode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.07.2002 11:13:29)
	 * @param newEconomistname java.lang.String
	 */
	public void setEconomistname(java.lang.String newEconomistname) {
		economistname = newEconomistname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:30:24)
	 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setEndDate(Date newEndDate) {
		endDate.setSqlDate(newEndDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:30:24)
	 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setEndDateFrm(String newEndDate) {
		endDate.setString(newEndDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.10.2002 17:13:40)
	 * @param newExecname java.lang.String
	 */
	public void setExecname(java.lang.String newExecname) {
		execname = newExecname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 18:31:21)
	 * @param newExtendPeriod java.lang.String
	 
	public void setExtendPeriod(java.lang.String newExtendPeriod) {
		extendPeriod = newExtendPeriod;
	}
	*/
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:42:05)
	 * @param newExtendType java.lang.String
	 */
	public void setExtendType(java.lang.String newExtendType) {
		extendType = newExtendType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.08.2002 18:57:51)
	 * @param newFormFile org.apache.struts.upload.FormFile
	
	public void setFormFile(org.apache.struts.upload.FormFile newFormFile) {
		formFile = newFormFile;
	}
	 */
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2003 13:40:29)
	 * @param newIddogovorplatinum java.lang.String
	 */
	public void setIddogovorplatinum(java.lang.String newIddogovorplatinum) {
		iddogovorplatinum = newIddogovorplatinum;
	}
	public void setInn(String s) throws Exception {
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.08.2002 17:49:43)
	 * @param newIsDocumentText java.lang.Boolean
	 */
	public void setIsDocumentText(java.lang.Boolean newIsDocumentText) {
		isDocumentText = newIsDocumentText;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.08.2002 10:44:22)
	 * @param newIsDogElectro java.lang.Boolean
	 */
	public void setIsDogElectro(java.lang.Boolean newIsDogElectro) {
		isDogElectro = newIsDogElectro;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (29.01.2003 13:01:41)
	 * @param newIsPlatinumrecord java.lang.String
	 */
	public void setIsPlatinumrecord(java.lang.String newIsPlatinumrecord) {
		isPlatinumrecord = newIsPlatinumrecord;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.03.2004 14:28:45)
	 * @param newIsPositionSelected boolean
	 */
	public void setIsPositionSelected(boolean newIsPositionSelected) {
		isPositionSelected = newIsPositionSelected;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.08.2002 17:17:15)
	 * @param newIsSumm2 java.lang.Boolean
	 */
	public void setIsSumm2(java.lang.Boolean newIsSumm2) {
		isSumm2 = newIsSumm2;
	}
	public void setKpp() throws Exception {
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 15:49:05)
	 * @param newLeaseDocument int
	 */
	public void setLeaseDocument(int newLeaseDocument) {
		leaseDocument = newLeaseDocument;
	}
	public void setLegaladdress() throws Exception {
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.08.2002 16:53:26)
	 * @param newMainDocument java.lang.Integer
	 */
	public void setMainDocument(java.lang.Integer newMainDocument) {
		mainDocument = newMainDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.08.2002 17:23:44)
	 * @param newMainDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	protected void setMainDocumentDate(Date newMainDocumentDate) {
		mainDocumentDate.setSqlDate(newMainDocumentDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.08.2002 17:23:44)
	 * @param newMainDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	protected void setMainDocumentDateFrm(String newMainDocumentDate) {
		mainDocumentDate.setString(newMainDocumentDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.08.2002 17:35:41)
	 * @param newMainDocumentNumber java.lang.String
	 */
	protected void setMainDocumentNumber(java.lang.String newMainDocumentNumber) {
		mainDocumentNumber = newMainDocumentNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.03.2004 16:56:12)
	 * @param newManager com.hps.july.persistence.WorkerAccessBean
	 */
	public void setManager(com.hps.july.persistence.WorkerAccessBean newManager) throws Exception {
		if (newManager == null) {
			managercode.setInteger(null);
			managername = "";
		} else {
			managercode.setInteger(new Integer(newManager.getWorker()));
			managername = newManager.getMan().getFullName();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.03.2004 16:56:12)
	 * @param newManagercode com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setManagercode(Integer newManagercode) {
		managercode.setInteger(newManagercode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.03.2004 17:00:06)
	 */
	public void setManagercodeFrm(String newmanagercode) {
		managercode.setString(newmanagercode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.03.2004 16:56:12)
	 * @param newManagername java.lang.String
	 */
	public void setManagername(java.lang.String newManagername) {
		managername = newManagername;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.05.2005 10:43:08)
	 * @param newNeedofficialdoc boolean
	 */
	public void setNeedofficialdoc(boolean newNeedofficialdoc) {
		needofficialdoc = newNeedofficialdoc;
	}
	public void setNumberOfPhones(Integer newInt) {
		numberOfPhones.setInteger(newInt);
	}
	public void setNumberOfPhonesFrm(String newInt) {
		numberOfPhones.setString(newInt);
	}
	public void setNumberofphonestemp(Integer newInt) {
		numberofphonestemp.setInteger(newInt);
	}
	public void setNumberofphonestempFrm(String newInt) {
		numberofphonestemp.setString(newInt);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.03.2005 10:54:43)
	 * @param newOfficialdoc boolean
	 */
	public void setOfficialdoc(boolean newOfficialdoc) {
		officialdoc = newOfficialdoc;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.12.2005 12:46:30)
	 * @param newOperatorVO com.hps.july.arenda.valueobject.PeopleVO
	 */
	private void setOperatorVO(com.hps.july.arenda.valueobject.PeopleVO newOperatorVO) {
		operatorVO = newOperatorVO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 20:28:20)
	 * @param newOrgCustomer com.hps.july.persistence.OrganizationNfsAccessBean
	 */
	public void setOrgCustomer(com.hps.july.persistence.OrganizationNfsAccessBean newOrgCustomer) throws Exception {
		if (newOrgCustomer == null) {
			orgCustomercode.setInteger(new Integer(0));
			orgCustomername = "";
		} else {
			orgCustomercode.setInteger(new Integer(newOrgCustomer.getOrganization()));
			orgCustomername = newOrgCustomer.getName();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:14:33)
	 * @param newOrgCustomer com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setOrgCustomercode(Integer newOrgCustomercode) {
		orgCustomercode.setInteger(newOrgCustomercode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:14:33)
	 * @param newOrgCustomer com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setOrgCustomercodeFrm(String newOrgCustomer) {
		orgCustomercode.setString(newOrgCustomer);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 20:59:17)
	 * @param newOrgCustomername java.lang.String
	 */
	public void setOrgCustomername(java.lang.String newOrgCustomername) {
		orgCustomername = newOrgCustomername;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 21:10:26)
	 * @param newOrgExecutor com.hps.july.persistence.OrganizationNfsAccessBean
	 */
	public void setOrgExecutor(com.hps.july.persistence.OrganizationNfsAccessBean newOrgExecutor) throws Exception {
		if (newOrgExecutor == null) {
			orgExecutorcode.setInteger(new Integer(0));
			orgExecutorname = "";
		} else {
			orgExecutorcode.setInteger(new Integer(newOrgExecutor.getOrganization()));
			orgExecutorname = newOrgExecutor.getName();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:19:00)
	 * @param newOrgExecutor com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setOrgExecutorcode(Integer newOrgExecutorcode) {
		orgExecutorcode.setInteger(newOrgExecutorcode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:19:00)
	 * @param newOrgExecutor com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setOrgExecutorcodeFrm(String newOrgExecutorcode) {
		orgExecutorcode.setString(newOrgExecutorcode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 21:05:44)
	 * @param newOrgExecutorname java.lang.String
	 */
	public void setOrgExecutorname(java.lang.String newOrgExecutorname) {
		orgExecutorname = newOrgExecutorname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.02.2004 14:29:48)
	 * @param newPosition java.lang.Integer
	 */
	public void setPosition(java.lang.Integer newPosition) {
		position = newPosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.02.2004 14:30:34)
	 * @param newPositionname java.lang.String
	 */
	public void setPositionname(java.lang.String newPositionname) {
		positionname = newPositionname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.11.2002 11:18:41)
	 * @param newRatecalcrule java.lang.String
	 */
	public void setRatecalcrule(java.lang.String newRatecalcrule) {
		ratecalcrule = newRatecalcrule;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2002 12:17:12)
	 * @param newRatecalcruleday com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setRatecalcruleday(Short newRatecalcruleday) {
		if (newRatecalcruleday != null) {
			ratecalcruleday.setInteger(new Integer(newRatecalcruleday.intValue()));
		} else {
			ratecalcruleday.setInteger(null);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2002 12:17:12)
	 * @param newRatecalcruleday com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setRatecalcruledayFrm(String newRatecalcruleday) {
		ratecalcruleday.setString(newRatecalcruleday);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2002 12:35:57)
	 * @param newRatedelta com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setRatedelta(BigDecimal newRatedelta) {
		ratedelta.setBigDecimal(newRatedelta);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2002 12:35:57)
	 * @param newRatedelta com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setRatedeltaFrm(String newRatedelta) {
		ratedelta.setString(newRatedelta);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:43:01)
	 * @param newReportPeriod java.lang.String
	 */
	public void setReportPeriod(java.lang.String newReportPeriod) {
		reportPeriod = newReportPeriod;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.07.2003 11:37:40)
	 * @param newRur int
	 */
	public void setRur(int newRur) {
		rur = newRur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:24:53)
	 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setStartDate(Date newStartDate) {
		startDate.setSqlDate(newStartDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.07.2002 16:24:53)
	 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setStartDateFrm(String newStartDate) {
		startDate.setString(newStartDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 17:10:53)
	 * @param newSubject java.lang.String
	 */
	public void setSubject(java.lang.String newSubject) {
		subject = newSubject;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 13:08:55)
	 * @param newSumm1 com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setSumm1(BigDecimal newSumm1) {
		summ1.setBigDecimal(newSumm1);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 13:08:55)
	 * @param newSumm1 com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setSumm1Frm(String newSumm1) {
		summ1.setString(newSumm1);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 13:15:21)
	 * @param newSumm2 com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setSumm2(BigDecimal newSumm2) {
		summ2.setBigDecimal(newSumm2);
		if (newSumm2 != null) {
			setIsSumm2(new Boolean(true));
		} else {
			setIsSumm2(new Boolean(false));
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2002 13:15:21)
	 * @param newSumm2 com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setSumm2Frm(String newSumm2) {
		summ2.setString(newSumm2);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.01.2003 13:38:15)
	 * @param newSYNCNRIPLATINARENDA java.lang.String
	 */
	public void setSYNCNRIPLATINARENDA(java.lang.String newSYNCNRIPLATINARENDA) {
		SYNCNRIPLATINARENDA = newSYNCNRIPLATINARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.01.2003 10:21:56)
	 * @param newVendor java.lang.String
	 */
	public void setVendor(java.lang.String newVendor) {
		vendor = newVendor;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException The exception description.
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if (isIsPositionSelected() && getAction().equals("Add")) {
			//была выбрана позиция - выбираем ответственного менеджера по позиции:
			addManagerFromPosition();
		}
		if (managercode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.manager"));
		} else if (!managercode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.manager"));
		} else {
			try {
				constructManager();
			} catch (Exception ex) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.manager"));
				}
			}
		}

		if (getDocumentNumber() == null || getDocumentNumber().equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(errorEmptyDocNumber));
		}

		if (documentDate.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.docdate"));
		} else if (!documentDate.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.docdate"));
		}

		if (orgCustomercode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.customer"));
		} else if (!orgCustomercode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.customer"));
		}

		if (orgExecutorcode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.executor"));
		} else if (!orgExecutorcode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.executor"));
		} else {
			try {
				constructExecutor();
			} catch (Exception ex) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.executor"));
				}
			}
		}

		if (summ1.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.summ1"));
		} else if (!summ1.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.summ1"));
		} else if (summ1.getBigDecimal().doubleValue() < 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.summ1.sign"));
		}

		NamedValueAccessBean namedValue = new NamedValueAccessBean();
		namedValue.setInitKey_id("BASE_CURRENCY_ARENDA");
		namedValue.refreshCopyHelper();
		int ruble = namedValue.getIntvalue();

		if (getIsSumm2().booleanValue()) {
			if (summ2.isEmpty() || !summ2.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.summ2"));
			} else if (summ2.getBigDecimal().doubleValue() < 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.summ2.sign"));
			}
/**
			// одна из валют должна быть рубль
			
			int curcode1 = getCurrencycode1().intValue();
			int curcode2 = getCurrencycode2().intValue();

			if ((curcode1 == curcode2) || !((curcode1 == ruble && curcode2 != ruble) || (curcode1 != ruble && curcode2 == ruble))) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.oneruble2"));
			}
*/			
		}

		//if(getCurrencycode1().intValue() != ruble && getRatecalcrule().equals("")){
		//	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.ratecalcrule"));
		//}
		/**    
		    if (getExtendType() == null || getExtendType().equals("")) {
		        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.extendtype"));
		    } else if (getExtendType().equals("A") && (getExtendPeriod() == null || getExtendPeriod().equals("")) ) {
		        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.extendperiod"));
		    }
		*/
		if (getExtendType() == null || getExtendType().equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.extendtype"));
		}

		if (getExtendType().equals("A") && (getExtenddays() == null && getExtendmonthes() == null && getExtendyears() == null)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.extendperiod"));
		}

		if (startDate.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.startdate"));
		} else if (!startDate.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.startdate"));
		}

		//корректировка даты:
		correctEndDate();

		if (endDate.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.enddate"));
		} else if (!endDate.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.enddate"));
		}

		if (!startDate.isEmpty() && !endDate.isEmpty() && startDate.getSqlDate().compareTo(endDate.getSqlDate()) >= 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.equaldate"));
		}

		if (!startDate.isEmpty() && !baseenddate.isEmpty() && startDate.getSqlDate().compareTo(baseenddate.getSqlDate()) >= 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Дата окончания срока действия договора должна быть позже, чем дата начала срока действия договора "));
		}
		/**
			if (!baseenddate.isEmpty() && !endDate.isEmpty() && baseenddate.getSqlDate().compareTo(endDate.getSqlDate()) > 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Неправильная дата продления договора!"));
			}	
		*/
		if (getCalcElectroType() == null || getCalcElectroType().equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.calcelectrotype"));
		}

		if (getIsDogElectro() == null) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.isdogelectro"));
		}
		/*
			if (getHowGivePhones() == null || getHowGivePhones().equals("")) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.howgivephones"));
			}
			
			if (!numberOfPhones.isEmpty() && !numberOfPhones.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.numberofphones"));
			}
		*/
		if (!numberOfPhones.isEmpty()) {
			if (numberOfPhones.isOk()) {
				if (numberOfPhones.getInteger() != null && numberOfPhones.getInteger().intValue() < 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.negative.we.numberofphones"));
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.numberofphones"));
			}
		}

		if (!numberofphonestemp.isEmpty()) {
			if (numberofphonestemp.isOk()) {
				if (numberofphonestemp.getInteger() != null && numberofphonestemp.getInteger().intValue() < 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.negative.we.numberofphonestemp"));
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.numberofphonestemp"));
			}
		}

		if (economistcode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.economist"));
		} else if (!economistcode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.economist"));
		} else {
			try {
				constructEconomist();
			} catch (Exception ex) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.economist"));
				}
			}
		}

		if (checkRates()) {
			if ("F".equals(getRatecalcrule()) || "G".equals(getRatecalcrule())) {
				if (ratecalcruleday.isEmpty()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.ratecalcruleday"));
				} else if (!ratecalcruleday.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.ratecalcruleday"));
				}
			}

			if (ratedelta.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.we.ratedelta"));
			} else if (!ratedelta.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.ratedelta"));
			}
		}

		if (!startDate.isEmpty()) {
			if (getMainDocument() == null) { // check for min startDate (in the base contract)
				Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(new Integer(getLeaseDocument()), new Boolean(false), null, new Boolean(false), null, new Integer(1));
				if (e.hasMoreElements()) {
					LeaseArendaAgreementNewAccessBean laanBean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
					if (getStartDate().compareTo(laanBean.getStartDate()) >= 0) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.notminstartdate"));
					}
				}
			} else { // check for unic startDate
				LeaseArendaAgreementNewAccessBean laanBean = new LeaseArendaAgreementNewAccessBean();
				laanBean.setInitKey_leaseDocument(getMainDocument().intValue());
				laanBean.refreshCopyHelper();

				if (getStartDate().compareTo(laanBean.getStartDate()) <= 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.notminstartdate"));
				} else {
					Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(getMainDocument(), new Boolean(false), null, new Boolean(false), null, new Integer(1));
					while (e.hasMoreElements()) {
						laanBean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
						if (getLeaseDocument() != laanBean.getLeaseDocument() && getStartDate().compareTo(laanBean.getStartDate()) == 0) {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.we.notunicstartdate"));
							break;
						}
					}
				}
			}
		}

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	/**
	 * @return Short
	 */
	public Short getExtenddays() {
		return extenddays.getShort();
	}
	/**
	 * @return String
	 */
	public String getExtenddaysFrm() {
		return extenddays.getString();
	}
	/**
	 * @return 
	 */
	public Short getExtendmonthes() {
		return extendmonthes.getShort();
	}
	/**
	 * @return String
	 */
	public String getExtendmonthesFrm() {
		return extendmonthes.getString();
	}

	/**
	 * @return Short
	 */
	public Short getExtendyears() {
		return extendyears.getShort();
	}

	/**
	 * @return String
	 */
	public String getExtendyearsFrm() {
		return extendyears.getString();
	}

	/**
	 * @param property
	 */
	public void setExtenddaysFrm(String property) {
		extenddays.setString(property);
	}
	/**
	 * @param property
	 */
	public void setExtenddays(Short property) {
		extenddays.setShort(property);
	}
	/**
	 * @param property
	 */
	public void setExtendmonthesFrm(String property) {
		extendmonthes.setString(property);
	}
	/**
	 * @param property
	 */
	public void setExtendmonthes(Short property) {
		extendmonthes.setShort(property);
	}
	/**
	 * @param property
	 */
	public void setExtendyearsFrm(String property) {
		extendyears.setString(property);
	}
	/**
	 * @param property
	 */
	public void setExtendyears(Short property) {
		extendyears.setShort(property);
	}
	/**
	 * @return
	 */
	public boolean getHaveioact() {
		return haveioact;
	}

	/**
	 * @param boolean1
	 */
	public void setHaveioact(boolean boolean1) {
		haveioact = boolean1;
	}

	/**
	 * @return
	 */
	public java.lang.String getIoactnumber() {
		return haveioact ? ioactnumber : null;
	}

	/**
	 * @param string
	 */
	public void setIoactnumber(java.lang.String string) {
		ioactnumber = string;
	}

	/**
	 * 
	 * @param newIoactdate
	 */

	public void setIoactdate(Date newIoactdate) {
		ioactdate.setSqlDate(newIoactdate);
	}
	/**
	 * 
	 * @param newIoactdate
	 */

	public void setIoactdateFrm(String newIoactdate) {
		ioactdate.setString(newIoactdate);
	}
	/**
	 * 
	 * @return
	 */

	public Date getIoactdate() {
		return haveioact ? ioactdate.getSqlDate() : null;
	}
	/**
	 * 
	 * @return
	 */

	public String getIoactdateFrm() {
		return ioactdate.getString();
	}

	/**
	 * @return
	 */
	public boolean getNalogAgent() {
		return NalogAgent;
	}

	/**
	 * @param boolean1
	 */
	public void setNalogAgent(boolean boolean1) {
		NalogAgent = boolean1;
	}
	/**
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getRateNDS() {
		return RateNDS.getBigDecimal();
	}
	/**
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getRateNDSFrm() {
		return RateNDS.getString();
	}
	/**
	 * @param newRateNDS com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setRateNDS(BigDecimal newRateNDS) {
		RateNDS.setBigDecimal(newRateNDS);
	}
	/**
	 * @param newRateNDS com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setRateNDSFrm(String newRateNDS) {
		RateNDS.setString(newRateNDS);
	}
	/**
	 * @return
	 */
	public List getCustomers() {
		return customers;
	}

	/**
	 * @param list
	 */
	private void setCustomers(List list) {
		customers = list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.11.2005 17:21:24)

	private void initCustomers(HttpServletRequest request) {
		Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
		if (profile.getProfileAccess().getCurrRegion() != null) {
			Integer regionID = profile.getProfileAccess().getCurrRegion().getVo().getRegionid();
			//List custList = CDBC_OrganizationObject.findOurOrganizations(regionID, "nameOrg");
			List custList = CDBC_OwnerContract2FilialNri_Object.getList(regionID, "name");
			setCustomers(custList);
		} else {
			//throw new RuntimeException("нет текущего региона для аренды!!!");
			System.out.println("нет текущего региона для аренды!!!");
		}
	}
	 */	
	/**
	 * @return
	 */
	public boolean getIsRateLimit() {
		return isRateLimit;
	}

	/**
	 * @param b
	 * 
	 */
	public void setIsRateLimit(boolean b) {
		isRateLimit = b;
	}

	/**
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getRateLimitMin() {
		return rateLimitMin.getBigDecimal();
	}
	/**
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getRateLimitMinFrm() {
		return rateLimitMin.getString();
	}
	/**
	 * @param newRateLimitMin com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setRateLimitMin(BigDecimal newRateLimitMin) {
		rateLimitMin.setBigDecimal(newRateLimitMin);
	}
	/**
	 * @param newRateNDS com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setRateLimitMinFrm(String newRateLimitMin) {
		rateLimitMin.setString(newRateLimitMin);
	}

	/**
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getRateLimitMax() {
		return rateLimitMax.getBigDecimal();
	}
	/**
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getRateLimitMaxFrm() {
		return rateLimitMax.getString();
	}
	/**
	 * @param newRateLimitMax com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setRateLimitMax(BigDecimal newRateLimitMax) {
		rateLimitMax.setBigDecimal(newRateLimitMax);
	}
	/**
	 * @param newRateLimitMax com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setRateLimitMaxFrm(String newRateLimitMax) {
		rateLimitMax.setString(newRateLimitMax);
	}
	/**
	 * @return
	 */
	public String getPosListSortBy() {
		return posListSortBy;
	}

	/**
	 * @param string
	 */
	public void setPosListSortBy(String string) {
		posListSortBy = string;
	}

	/**
	 * @return
	 */
	public String getBuchdocnumber() {
		return buchdocnumber;
	}

	/**
	 * @return
	 */
	public Boolean getHavedocsigned() {
		return havedocsigned;
	}

	/**
	 * @return
	 */
	public Boolean getHavedocsignedcustomer() {
		return havedocsignedcustomer;
	}

	/**
	 * @param string
	 */
	public void setBuchdocnumber(String string) {
		buchdocnumber = string;
	}

	/**
	 * @param boolean1
	 */
	public void setHavedocsigned(Boolean boolean1) {
		havedocsigned = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setHavedocsignedcustomer(Boolean boolean1) {
		havedocsignedcustomer = boolean1;
	}

	/**
	 * @return
	 */
	public java.sql.Timestamp getCreated() {
		return created;
	}

	/**
	 * @param date
	 */
	public void setCreated(java.sql.Timestamp date) {
		created = date;
	}

	/**
	 * @return
	 */
	public String getMainBuchDocNumber() {
		return mainBuchDocNumber;
	}

	/**
	 * @param string
	 */
	protected void setMainBuchDocNumber(String string) {
		mainBuchDocNumber = string;
	}

	/**
	 * @return
	 */
	public java.sql.Timestamp getMainCreated() {
		return mainCreated;
	}

	/**
	 * @param timestamp
	 */
	protected void setMainCreated(java.sql.Timestamp timestamp) {
		mainCreated = timestamp;
	}

	/**
	 * @return
	 */
	private Integer getRegionID() {
		return regionID;
	}

	/**
	 * @param integer
	 */
	private void setRegionID(Integer integer) {
		regionID = integer;
	}

	/**
	 * @return
	 */
	public WeArandaFormView getWeArandaFormView() {
		return weArandaFormView;
	}

	/**
	 * @param view
	 */
	private void setWeArandaFormView(WeArandaFormView view) {
		weArandaFormView = view;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2007 13:08:55)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getSumm1MounthFrm() {
		if(summ1.getBigDecimal() != null){
			return summ1.getBigDecimal().divide(MOUNTH, 2, BigDecimal.ROUND_HALF_UP).toString();
		}else{
			return null;
		}
	}
}
