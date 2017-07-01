package com.hps.july.arenda.formbean;

import com.hps.july.jdbcpersistence.lib.*;
import javax.naming.*;
import com.hps.july.jdbcpersistence.*;
import com.hps.july.platinum.sessionbean.*;
import com.hps.july.arenda.sessionbean.*;
import java.util.Enumeration;
import java.util.HashMap;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.hps.july.commonbean.*;
import com.hps.july.util.*;
import com.hps.july.valueobject.Currency_VO;
import com.hps.july.valueobject.VendorSite_VO;
import com.hps.july.web.util.*;
import java.sql.*;
import java.math.*;
import com.hps.july.arenda.*;
/**
* Bean-form "платежей договора аренды".
* Creation date: (27.01.2003 10:09:57)
*/

public class PaymentForm extends EditForm //UsPaymentForm
{
	/* 
	 * Таблица редактируемых и не редактируемых полей
	 * Должна инициализироваться один раз при создании формы
	 * в дальнейшем для выяснения какое поле редактируется
	 * должен вызываться метод isEditable(String field)
	 */
	private static HashMap editableMap = new HashMap();

	// AccessBeans
	// Should be removed in newer version carefully!
	private com.hps.july.persistence.AccountAccessBean orgAcc;
	private com.hps.july.persistence.CurrencyAccessBean currency;
	private com.hps.july.persistence.LeaseContractAccessBean leaseContract;
	private com.hps.july.persistence.ResourceAccessBean resource;
	private com.hps.july.persistence.LeaseMutualActNewAccessBean act;

	// Hidden properties
	private String SYNCNRIPLATINARENDA; // Флаг синхронизации с Platinum
	private Integer leaseContractcode; // Код договора
	private String stateOfContract; // Состояние договора
	private int leaseDocPosition; // Код платежа (позиции договора)
	private String paymentType; // Тип платежа
	private StringAndSqlDateProperty documentDate; // ??? ХЗ
	//проверить ? - заменено на mainPosition
	private String positionName; // Наименование позиции(заменено на mainPosition)

	private int rur = 0; // Б ХЗ(код национальная валюта убрать)
	private String rurName = null;//имя национальная валюта
	
	private String calcNdsRate;

	private Integer usedinactcode; // Код акта в котором зарегистрирован платёж

	private String calctype; // Определитель выполяемой расчётной функции
	private int fromcalc;

	// Properties
	// Номер договора
	private String documentNumber;

	// Срок действия договора
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty endDate;

	// Заказчик (Плательщик)
	private String orgCustomerContract;

	// Исполнитель
	private String orgExecutorContract;

	// Годовая стоимость договора
	private String costcurrency1; // Сумма 1
	private String curr1; // Валюта 1
	private String costcurrency2; // Сумма 2
	private String curr2; // Валюта 2

	// Состояние
	private String paymentstate; // Код состояния платежа

	// Номер и Дата ПП
	private String docNumber;
	private StringAndSqlDateProperty date;

	// Плательщик
	// см. orgCustomerContract
	// Получатель платежа
	private StringAndIntegerProperty orgExecutorcode;
	private String orgExecutorname;

	// Расчетный счет, Банк, Корсчет банка, БИК банка
	private StringAndIntegerProperty orgAcccode;
	private String orgAccname;
	private String bank;
	private String coraccount;
	private String bik;

	// Аванс
	private String ppType;

	// Есть ли счёт фактура
	private String isSchetFakt;

	// Выставляемый счёт
	private String billNumber;
	private StringAndSqlDateProperty billDate;

	// Период оплаты
	private StringAndSqlDateProperty begindate;
	private StringAndSqlDateProperty enddate;

	// Услуга
	private int resourcecode; // Использует коллекцию Resources

	// Сумма служебной записки, СТАВКА НДС, НДС, Валюта
	private StringAndBigDecimal summ;
	private StringAndBigDecimalProperty ndsRate;
	private StringAndBigDecimal sumnds;
	private Integer currencycode; // Использует getCurrencies

	// Правило определения курса по договору
	private String ratecalcrule;

	// Курс рубля к валюте служебной записки, курс определен на дату, дата для определения курса
	private StringAndBigDecimal payrate;
	private StringAndSqlDateProperty ratedate;
	private StringAndSqlDateProperty ratedatecalc;

	// Сумма в рублях
	protected StringAndBigDecimal sumRub;

	// в т.ч. НДС в рублях
	private StringAndBigDecimal ndsRub;

	// Назначение платежа
	private String payPurpose;

	// Параметры платежа системы Platinum
	//	private PlatinumPaymentProperties platinum;

	private Integer definerate;
	private String numberanddatepay;
	private String numpayplatinum;
	private String purposepay;
	private Integer typebasedoc;
	private Integer idbudjet;
	private Integer iddirect;
	private Integer idpaymode;
	private Integer idpaytype;
	private Integer idproject;
	private Integer idsubexpence;
	private Integer idtypeforbuch;
	private Integer paystateplatinum;
	private String paystateplatinumFrm;
	private Integer typeinstr;
	private Integer typerashod;
	private StringAndSqlDateProperty datebeforepay;
	private StringAndSqlDateProperty datebuch;
	private int idreference;
	private Integer idexpence;
	private Boolean nakladnaya;
	private Boolean tovcheck;
	private Boolean sf;
	private Boolean cascheck;
	private Boolean kvitpko;
	private Integer iditem;
	private StringAndBigDecimalProperty percentavans;
	private int arendaTypeInstrOpl;
	private Integer otvuser;
	private String otvuserFrm;
	private StringAndSqlTimestampProperty datenritoplatinum;
	private StringAndSqlTimestampProperty dateplatinum;
	private String flagsync;
	private String fl101;
	private String fl104;
	private String fl105;
	private String fl106;
	private String fl107;
	private String fl108;
	private String fl109;
	private String fl110;

	// From UsPaymentForm

	private String source;
	private String docposvid;
	protected String listForm;
	private int actcode;
	private Date saldate = null;
	private BigDecimal ratedelta;
	private Integer ratecalcruleday;

	static {
		initEditableMap();
	}
	// основная позиция:
	private java.lang.String mainPosition;
	// номер служебной записки:
	private java.lang.String officememonumber;
	//private com.hps.july.web.util.StringAndBigDecimalProperty ndsRate;
	//Признак оплаты НДС:
	private Boolean flagOplNds = null;
	
	
	public PaymentForm() {
		/*
		Form UsPaymentForm
		*/
		super();
		listForm = "UsPaymentsListForm";

		date = new StringAndSqlDateProperty();
		endDate = new StringAndSqlDateProperty();
		documentDate = new StringAndSqlDateProperty();
		sumnds = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		startDate = new StringAndSqlDateProperty();
		summ = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		payrate = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 4);
		sumRub = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		ndsRub = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		begindate = new StringAndSqlDateProperty();
		enddate = new StringAndSqlDateProperty();
		ratedate = new StringAndSqlDateProperty();
		ratedatecalc = new StringAndSqlDateProperty();

		setPaymentstate("G");
		setPaymentType("P");
		setSource("M");
		setDocposvid("N");

		ndsRate = new StringAndBigDecimalProperty();

		/*
		End from UsPaymentForm
		*/

		Date currdate = new Date(System.currentTimeMillis());

		/*orgCustomercode = new StringAndIntegerProperty();
		orgCustomercode.setInteger(new Integer(0));*/

		orgExecutorcode = new StringAndIntegerProperty();
		orgExecutorcode.setInteger(new Integer(0));

		orgAcccode = new StringAndIntegerProperty();
		orgAcccode.setInteger(new Integer(0));

		setPaymentType("O");
		setPpType("B");

		billDate = new StringAndSqlDateProperty();
		//billDate.setSqlDate(currdate);
		billDate.setSqlDate(null);

		listForm = "PaymentsListForm";

		//platinum
		datebeforepay = new StringAndSqlDateProperty();
		datebeforepay.setSqlDate(currdate);

		datebuch = new StringAndSqlDateProperty();
		datebuch.setSqlDate(currdate);

		percentavans = new StringAndBigDecimalProperty();

		setDefinerate(new Integer(0));
		setNumberanddatepay("");
		setNumpayplatinum("");
		setPurposepay("");

		setTypebasedoc(new Integer(0));
		setIdbudjet(new Integer(0));
		setIddirect(new Integer(0));
		setIdexpence(new Integer(0));
		setIdpaymode(new Integer(0));
		setIdpaytype(new Integer(0));
		setIdproject(new Integer(0));
		setIdsubexpence(new Integer(0));
		setIdtypeforbuch(new Integer(0));
		setPaystateplatinum(new Integer(0));
		setTypeinstr(new Integer(0));
		setTyperashod(new Integer(0));

		datenritoplatinum = new StringAndSqlTimestampProperty();
		dateplatinum = new StringAndSqlTimestampProperty();
		//
		//ndsRate = new StringAndBigDecimalProperty();
		setFlagOplNds(Boolean.FALSE);
	}
	public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception {
		//platinum
		if (getSYNCNRIPLATINARENDA().equals("ok")) {
			try {
				DopInfoLPaymentAccessBean bean = new DopInfoLPaymentAccessBean();
				bean.setInitKey_leasedocposition(getLeaseDocPosition());
				bean.refreshCopyHelper();

				bean.getEJBRef().remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		if ("ok".equals(getSYNCNRIPLATINARENDA())) {
			if (getAction().equals("Add")) {
				try {
					DopInfoLPaymentAccessBean diBean = new DopInfoLPaymentAccessBean(getLeaseDocPosition());
					setDopInfo(diBean);
					diBean.commitCopyHelper();
				} catch (Exception e) {
					e.printStackTrace(System.out);
					System.out.println("paymentform.java, Exception add platinum! leaseDocPosition=" + getLeaseDocPosition());
				}
			} else if (getAction().equals("Edit")) {
				try {
					DopInfoLPaymentAccessBean diBean = new DopInfoLPaymentAccessBean();
					diBean.setInitKey_leasedocposition(getLeaseDocPosition());
					diBean.refreshCopyHelper();
					setDopInfo(diBean);
					diBean.commitCopyHelper();
				} catch (javax.ejb.ObjectNotFoundException e) {
					try {
						DopInfoLPaymentAccessBean diBean = new DopInfoLPaymentAccessBean(getLeaseDocPosition());
						setDopInfo(diBean);
						diBean.commitCopyHelper();
					} catch (Exception ex) {
						e.printStackTrace(System.out);
					}
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}
		}
	}
	public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		//	super.beforeDelete(bean, request);
		// FROM Us PaymentForm
		String payState;
		if (bean instanceof LeasePayOrderAccessBean) {
			payState = ((LeasePayOrderAccessBean) bean).getPaymentstate();
		} else {
			payState = ((LeasePaymentAccessBean) bean).getPaymentstate();
		}

		if (!payState.equals("G")) { //Разрешаем для удаления платежи в состоянии редактируется
			if (!checkOpenPeriod()) { //Проверяем, чтобы платеж небыл в открытом периоде
				throw new UpdateValidationException("error.payment.notopenperiod");
			}
		}

		if (!((getSource().equals("M") || getSource().equals("A")) && getDocposvid().equals("N"))) {
			throw new UpdateValidationException("error.invalid.payment.source");
		}

		if (!checkLink2Pay()) {
			throw new UpdateValidationException("error.payment.haspay");
		}
		// END FROM UsPaymentForm

		Enumeration e = new LeaseCalcRateAccessBean().findLeaseCalcRatesByDocposition(new LeaseDocPositionKey(getLeaseDocPosition()));
		while (e.hasMoreElements()) {
			LeaseCalcRateAccessBean lcrBean = (LeaseCalcRateAccessBean) e.nextElement();
			lcrBean.getEJBRef().remove();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:21:31)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		// FROM UsPaymentForm
		/* cuz no super.beforeUpdate call
			if (getCurrencycode().intValue() == getRur()) {
				LeasePaymentAccessBean lpBean = (LeasePaymentAccessBean) bean;
				lpBean.setSumRub(lpBean.getSumm());
				lpBean.setNdsRub(lpBean.getSumnds());
				lpBean.setPayrate(new BigDecimal(1));
			}
		*/
		// END FROM UsPaymentForm

		if (new ArendaPlatinumProcessorAccessBean().isProcessingEnabled()) {
			java.util.GregorianCalendar c = new java.util.GregorianCalendar();
			setDate(new Date(c.getTime().getTime()));
		}

		if (getCurrencycode().intValue() == getRur()) {
			LeasePayOrderAccessBean lpoBean = (LeasePayOrderAccessBean) bean;
			lpoBean.setSumRub(lpoBean.getSumm());
			lpoBean.setNdsRub(lpoBean.getSumnds());
			lpoBean.setPayrate(new BigDecimal(1));
		}

		NamedValueAccessBean nvBean = new NamedValueAccessBean();
		if (getCurrencycode().intValue() == getRur() || !sumRub.isEmpty() || (!sumRub.isEmpty() && getSumRub().doubleValue() != 0)) {
			nvBean.setInitKey_id("ArendaOplRur");
		} else {
			nvBean.setInitKey_id("ArendaOplRurRate");
		}
		nvBean.refreshCopyHelper();

		setIdpaymode(new Integer(nvBean.getIntvalue()));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.01.2004 16:15:50)
	 */
	private void calcSumm(ActionErrors errors) {
		//	if (getCalctype().equals("CalcSumm")) 
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "execute procedure calcSumPay(?, ?, ?, ?, ?)";
			con = new JdbcConnection().getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, getLeaseContractcode().intValue()); //код договора - getLeaseContractcode().intValue()
			//System.out.println("getLeaseContractcode().intValue(): " + getLeaseContractcode().intValue()); //temp
			ps.setInt(2, getResourcecode()); //услуга - getResourcecode()
			//System.out.println("getResourcecode(): " + getResourcecode());
			ps.setDate(3, getBegindate()); //дата начала периода - getBegindate()
			//System.out.println("getBegindate(): " + getBegindate());
			ps.setDate(4, getEnddate()); //дата окончания периода - getEnddate()
			//System.out.println("getEnddate()" + getEnddate()); //temp
			ps.setInt(5, getCurrencycode().intValue()); //валюта - getCurrencycode().intValue()
			//System.out.println("getCurrencycode().intValue(): " + getCurrencycode().intValue()); //temp

			rs = ps.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				String errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
				BigDecimal summ = rs.getBigDecimal(3); //--Сумма 
				BigDecimal sumnds = rs.getBigDecimal(4); //-- НДС
				BigDecimal ndsRate = rs.getBigDecimal(5); //ставка НДС
				int curr = rs.getInt(6); //-- Валюта
				BigDecimal sumRub = rs.getBigDecimal(7); // -- Сумма в рублях
				BigDecimal ndsRub = rs.getBigDecimal(8); // -- НДС в рублях
				String payPyrpose = rs.getString(9); //НазначениеПП
				if (result == 0) {
					//System.out.println("summFrm: " + summ); //temp
					setSumm(summ);
					//System.out.println("sumndsFrm: " + sumnds); //temp
					setSumnds(sumnds);
					//System.out.println("ndsRate: " + ndsRate); //temp
					setNdsRate(ndsRate);
					//System.out.println("curr: " + curr); //temp
					setCurrencycode(new Integer(curr));
					//System.out.println("sumRubFrm: " + sumRub); //temp
					setSumRub(sumRub);
					//System.out.println("ndsRubFrm: " + ndsRub); //temp
					setNdsRub(ndsRub);
					setPayPurpose(payPyrpose);
				} else {
					System.out.println("errorTxt: " + errorTxt); //temp
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report.rate"));
				System.out.println("no DATA: execute procedure calcSumPay(?, ?, ?, ?, ?)"); //temp
			}

		} catch (Exception ex) {
			System.out.println("Error in execute procedure calcSumPay. PaymentForm.calsSumm()");
			if (ex instanceof SQLException) {
				System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
			}
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2002 19:11:33)
	 * @exception java.lang.Exception The exception description.
	 */
	private boolean checkLink2Pay() throws java.lang.Exception {
		Enumeration e = new LeaseDNOPAccessBean().findLeaseDNOPByLeaseCharge(new LeaseDocPositionKey(getLeaseDocPosition()));
		if (e.hasMoreElements()) {
			return false;
		}
		return true;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (16.12.2002 16:34:54)
	 * @return boolean
	 */
	public boolean checkOpenPeriod() throws Exception { // scope "public" - use in jsp
		Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(getLeaseContractcode(), new Integer(getResourcecode()));
		if (e.hasMoreElements()) {
			LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) e.nextElement();
			saldate = bean.getSalDate();
			return getDate().after(saldate) ? true : false;
		}
		return true;
	}
	public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
		// FROM UsPaymentForm
		/* cuz no super.constructBean call
			setLeaseDocPosition(new KeyGeneratorAccessBean().getNextKey("tables.leasedocpositions"));
			return new LeasePaymentAccessBean(getLeaseDocPosition(), getDate(), getLeaseContractcode(), getSource(), getDocposvid(),
				getBegindate(), getEnddate(), new Integer(getResourcecode()), getSumm(), getCurrencycode(), getSumnds(), getPaymentType(),
				getPaymentstate());
		*/
		// END FROM UsPayemntForm
		System.out.println("PAYFORM: construct");

		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		setLeaseDocPosition(keyGen.getNextKey("tables.leasedocpositions"));

		if (new ArendaPlatinumProcessorAccessBean().isProcessingEnabled()) {
			java.util.GregorianCalendar c = new java.util.GregorianCalendar();
			setDate(new Date(c.getTime().getTime()));
		}

		return new LeasePayOrderAccessBean(
			getLeaseDocPosition(),
			getDate(),
			getLeaseContractcode(),
			getSource(),
			getDocposvid(),
			getBegindate(),
			getEnddate(),
			new Integer(getResourcecode()),
			getSumm(),
			getCurrencycode(),
			getSumnds(),
			getPaymentType(),
			getPaymentstate(),
			getOrgAcccode(),
			getPayPurpose(),
			getPpType());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 15:34:33)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private CurrencyAccessBean constructCurrency() throws java.lang.Exception {
		if (currency == null) {
			if (getCurrencycode() != null) {
				currency = new CurrencyAccessBean();
				currency.setInitKey_currency(getCurrencycode().intValue());
				currency.refreshCopyHelper();
			}
		}
		return currency;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 15:34:33)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private LeaseContractAccessBean constructLeaseContract() throws java.lang.Exception {
		if (leaseContract == null) {
			if (getLeaseContractcode() != null) {
				leaseContract = new LeaseContractAccessBean();
				leaseContract.setInitKey_leaseDocument(getLeaseContractcode().intValue());
				leaseContract.refreshCopyHelper();
			}
		}
		return leaseContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 15:34:33)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private AccountAccessBean constructOrgAcc() throws java.lang.Exception {
		if (orgAcc == null) {
			if (!orgAcccode.isEmpty() && orgAcccode.isOk()) {
				orgAcc = new AccountAccessBean();
				orgAcc.setInitKey_account(orgAcccode.getInteger().intValue());
				orgAcc.refreshCopyHelper();
			}
		}
		return orgAcc;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 11:56:14)
	 * @return com.hps.july.persistence.ResourceAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private ResourceAccessBean constructResource() throws java.lang.Exception {
		if (resource == null) {
			if (resourcecode != 0) {
				resource = new ResourceAccessBean();
				resource.setInitKey_resource(resourcecode);
				resource.refreshCopyHelper();
			}
		}
		return resource;
	}
	public void fillRecord(AbstractEntityAccessBean bean) {
		System.out.println("PAYFORM: fillRecord");

		//	super.fillRecord(bean);
		// FROM UsPaymentForm
		LeasePaymentAccessBean abean = null;
		LeasePayOrderAccessBean bbean = null;
		LeaseContractAccessBean acontr = null;
		if (bean instanceof LeasePaymentAccessBean) {
			abean = (LeasePaymentAccessBean) bean;
			try {
				acontr = abean.getLeaseContract();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		} else if (bean instanceof LeasePayOrderAccessBean) {
			bbean = (LeasePayOrderAccessBean) bean;
			try {
				acontr = bbean.getLeaseContract();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}

		try {
			setLeaseContractcode(new Integer(acontr.getLeaseDocument()));
			setStateOfContract(acontr.getContractState());
			setDocumentNumber(acontr.getDocumentNumber());
			setDocumentDate(acontr.getDocumentDate());
			setOrgCustomerContract(acontr.getOrgCustomer().getName());
			setOrgExecutorContract(acontr.getOrgExecutor().getName());
			setStartDate(acontr.getStartDate());
			setEndDate(acontr.getEndDate());
			//		if (acontr.getCurrency1() != null) {
			//		    setCostcurrency1(acontr.getSumm1().toString());
			//		    setCurr1(acontr.getCurrency1().getShortname());
			//		} else {
			//			setCostcurrency1("");
			//			setCurr1("");
			//		}
			//		if (acontr.getCurrency2() != null) {
			//		    setCostcurrency2(acontr.getSumm2().toString());
			//		    setCurr2(acontr.getCurrency2().getShortname());
			//		} else {
			//			setCostcurrency2("");
			//			setCurr2("");
			//		}
			/**
			 * правило определения курса платежей по договору" при добавлении платежа
			 * должно отображаться из последнего действующего доп. соглашения.	
					setRatecalcrule(acontr.getRatecalcrule());
					if (acontr.getRatecalcruleday() != null)
						setRatecalcruleday(new Integer(acontr.getRatecalcruleday().intValue()));
					setRatedelta(acontr.getRatedelta());
			*/
			rateCalcRuleFromActiveDocument();
			setNdsRateFrm(getCalcNdsRate());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		// END FROM UsPayemntForm

		try {
			constructOrgAcc();
			setBank(orgAcc.getBank().getName());
			setCoraccount(orgAcc.getBank().getKoraccount());
			setBik(orgAcc.getBank().getBik());
			//setOrgExecutorcode(new Integer(orgAcc.getOrganizationKey().organization));
			//setOrgExecutorname(orgAcc.getOrganization().getName());
			//получаем их из VendorSite:
			VendorSite_VO vendorSite_VO = CDBC_VendorSite_Object.find(orgAcc.getIdVendorSite());
			if (vendorSite_VO != null) {
				setOrgExecutorcode(vendorSite_VO.getIdVendorSite());
				setOrgExecutorname(vendorSite_VO.getName());
			} else {
				setOrgExecutorcode(new Integer(-1));
				setOrgExecutorname("");
			}
		} catch (Exception e) {
			//		e.printStackTrace(System.out);
			setOrgExecutorcode(new Integer(-1));
			setOrgExecutorname("");
			setBank("");
			setCoraccount("");
			setBik("");
		}

		//platinum
		if ("ok".equals(getSYNCNRIPLATINARENDA())) {
			try {
				DopInfoLPaymentAccessBean pie = new DopInfoLPaymentAccessBean();
				pie.setInitKey_leasedocposition(getLeaseDocPosition());
				pie.refreshCopyHelper();

				setFl101(pie.getFl101());
				setFl104(pie.getFl104());
				setFl105(pie.getFl105());
				setFl106(pie.getFl106());
				setFl107(pie.getFl107());
				setFl108(pie.getFl108());
				setFl109(pie.getFl109());
				setFl110(pie.getFl110());
				setDatebeforepay(pie.getDatebeforepay());
				setDatebuch(pie.getDatebuch());
				setDefinerate(pie.getDefinerate());
				setIdbudjet(pie.getIdbudjet());
				setIditem(pie.getIdexpence());
				setIdpaymode(pie.getIdpaymode());
				setIdpaytype(pie.getIdpaytype());
				setNakladnaya(pie.getIsact());
				setCascheck(pie.getIskassacheck());
				setKvitpko(pie.getIskvitancia());
				setSf(pie.getIsschet());
				setTovcheck(pie.getIstovcheck());
				setNumberanddatepay(pie.getNumberanddatebasedoc());
				setNumpayplatinum(pie.getNumpayplatinum());
				setOtvuser(pie.getOtvuser());
				setPaystateplatinum(pie.getPaystateplatinum());
				setPercentavans(pie.getPercentavans());
				setPurposepay(pie.getPurposepay());
				setTypebasedoc(pie.getTypebasedoc());
				setTypeinstr(pie.getTypeinstr());
				setTyperashod(pie.getTyperashod());
				setDatenritoplatinum(pie.getDatenritoplatinum());
				setDateplatinum(pie.getDateplatinum());
				setFlagsync(pie.getFlagsync());

			} catch (Exception e) {
				e.printStackTrace(System.out);
				setFl101("");
				setFl104("");
				setFl105("");
				setFl106("");
				setFl107("");
				setFl108("");
				setFl109("");
				setFl110("");
				setDefinerate(new Integer(0));
				setNumberanddatepay("");
				setNumpayplatinum("");
				setPurposepay("");
				setTypebasedoc(new Integer(0));

				setIdbudjet(new Integer(0));
				setIddirect(new Integer(0));
				setIditem(new Integer(0));
				setIdpaymode(new Integer(0));
				setIdpaytype(new Integer(0));
				setIdproject(new Integer(0));
				setIdsubexpence(new Integer(0));
				setIdtypeforbuch(new Integer(0));
				setPaystateplatinum(new Integer(0));
				setTypeinstr(new Integer(0));
				setTyperashod(new Integer(0));

				setDatenritoplatinum(null);
				setDateplatinum(null);
				setFlagsync("");
			}

			setOtvuserFrm("");
			try {
				OperatorAccessBean oBean = new OperatorAccessBean();
				oBean.setInitKey_operator(getOtvuser().intValue());
				oBean.refreshCopyHelper();
				setOtvuserFrm(oBean.getMan().getFullName());
			} catch (NullPointerException npe) {
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}

			setPaystateplatinumFrm("");
			try {
				PIEReferenceAccessBean pieBean = new PIEReferenceAccessBean();
				pieBean.setInitKey_idreference(getPaystateplatinum().intValue());
				pieBean.refreshCopyHelper();

				setPaystateplatinumFrm(pieBean.getName());
			} catch (NullPointerException npe) {
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}
	//deprecated metod
	public String findPositionName(int leaseDocument) {
		String result = "";
		try {
			//System.out.println("{:-} FindPositionName:"+leaseDocument);
			LeaseOnPositionAccessBean lopaf = new LeaseOnPositionAccessBean();
			Enumeration en = lopaf.findLeaseonpositionsByLeaseArendaAgreementNew(new LeaseDocumentKey(leaseDocument));
			//System.out.println("{:-} FindPositionName:EN:"+en.hasMoreElements());
			if (en.hasMoreElements()) {
				LeaseOnPositionAccessBean lopa = (LeaseOnPositionAccessBean) en.nextElement();
				//System.out.println("{:-} FindPositionName:LOPA:"+lopa);
				PositionAccessBean pos = lopa.getPosition();
				//System.out.println("{:-} FindPositionName:POS:"+pos);
				if (pos != null) {
					/*
					if(pos.getGsmid() != null) {
						result += "D"+pos.getGsmid()+" ";
					}
					if(pos.getDampsid() != null) {
						result += "A"+pos.getDampsid()+" ";
					}
					*/
					result += pos.getName();
				}
				//System.out.println("{:-} FindPositionName:RESULT:"+result);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			result = "";
		}
		return result;
	}
	private String formatSalDate() {
		java.text.SimpleDateFormat ff = new java.text.SimpleDateFormat("dd.MM.yyyy");
		return ff.format(saldate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 16:25:15)
	 * @return int
	 */
	public int getActcode() {
		return actcode;
	}
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 14:21:02)
	 * @return int
	 */
	public int getArendaTypeInstrOpl() {
		return arendaTypeInstrOpl;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 12:18:43)
	 * @return java.lang.String
	 */
	public java.lang.String getBank() {
		return bank;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:43:00)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getBegindate() {
		return begindate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:43:00)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getBegindateFrm() {
		return begindate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 12:32:46)
	 * @return java.lang.String
	 */
	public java.lang.String getBik() {
		return bik;
	}
	public Date getBillDate() {
		return billDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 11:41:31)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getBillDateFrm() {
		return billDate.getString();
	}
	public java.lang.String getBillNumber() {
		return billNumber;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCalcNdsRate() {
		return calcNdsRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.01.2003 16:08:47)
	 * @return java.lang.String
	 */
	public java.lang.String getCalctype() {
		return calctype;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:33:48)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getCascheck() {
		return cascheck;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 12:32:25)
	 * @return java.lang.String
	 */
	public java.lang.String getCoraccount() {
		return coraccount;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 17:14:54)
	 * @return java.lang.String
	 */
	public java.lang.String getCostcurrency1() {
		return costcurrency1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 17:14:54)
	 * @return java.lang.String
	 */
	public java.lang.String getCostcurrency2() {
		return costcurrency2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.08.2002 15:23:48)
	 * @return java.lang.String
	 */
	public java.lang.String getCurr1() {
		return curr1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.08.2002 15:24:02)
	 * @return java.lang.String
	 */
	public java.lang.String getCurr2() {
		return curr2;
	}
	public Enumeration getCurrencies() {
		try {
			return new CurrencyAccessBean().findAllOrderByNameAsc();
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
		/**
		try {
			if ("Add".equalsIgnoreCase(getAction())) {
				return new CurrencyAccessBean().findAllOrderByNameAsc();
			} else {
				//нужно переопределить equals() и hashCode() в бинах(AB):
				LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
				bean.setInitKey_leaseDocument(getLeaseContractcode().intValue());
				bean.refreshCopyHelper();
		
				java.util.HashSet set = new java.util.HashSet();
				set.add(bean.getCurrency1());
		
				if (bean.getCurrency2() != null) {
					set.add(bean.getCurrency2());
				}
		
				if (bean.getCurrency1Key().currency != getRur()) {
					CurrencyAccessBean cBean = new CurrencyAccessBean();
					cBean.setInitKey_currency(getRur());
					cBean.refreshCopyHelper();
					set.add(cBean);
				}
				return java.util.Collections.enumeration(set);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
		*/
		/**
			try {
				LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
				bean.setInitKey_leaseDocument(getLeaseContractcode().intValue());
				bean.refreshCopyHelper();
				
				java.util.Vector v = new java.util.Vector();
				v.addElement(bean.getCurrency1());
		
				if (bean.getCurrency2() != null && bean.getCurrency1().getCurrency() != bean.getCurrency2().getCurrency() && bean.getCurrency2Key().currency != getRur()) {
					v.addElement(bean.getCurrency2());
				}
				
				if (bean.getCurrency1Key().currency != getRur()) {
					CurrencyAccessBean cBean = new CurrencyAccessBean();
					cBean.setInitKey_currency(getRur());
					cBean.refreshCopyHelper();
					v.addElement(cBean);
				}
					
				return v.elements();
			} catch(Exception e) {
				e.printStackTrace();
				return new java.util.Vector().elements();	
			}
		*/
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 15:32:41)
	 * @return com.hps.july.persistence.CurrencyAccessBean
	 */
	public Currency getCurrency() throws Exception {
		CurrencyAccessBean bean = constructCurrency();
		if (bean != null)
			return (Currency) bean.getEJBRef();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 13:32:59)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getCurrencycode() {
		return currencycode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.07.2002 14:02:29)
	 */
	public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		System.out.println("PAYFORM: getdata");
		// FROM UsPaymentForm
		/* no super call
			LeasePaymentAccessBean bean = new LeasePaymentAccessBean();
			bean.setInitKey_leaseDocPosition(getLeaseDocPosition());
			return bean;
		*/
		// END FROM UsPaymentForm
		try {
			LeaseDocPositionAccessBean ldpBean = new LeaseDocPositionAccessBean();
			ldpBean.setInitKey_leaseDocPosition(getLeaseDocPosition());
			ldpBean.refreshCopyHelper();

			if (ldpBean.getEJBRef() instanceof LeasePayOrder) {
				LeasePayOrderAccessBean bean = new LeasePayOrderAccessBean();
				bean.setInitKey_leaseDocPosition(getLeaseDocPosition());
				return bean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setAction("View");
		LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
		lpBean.setInitKey_leaseDocPosition(getLeaseDocPosition());
		return lpBean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 11:58:23)
	 * @return java.sql.Date
	 */
	public java.sql.Date getDate() {
		return date.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:27:25)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public java.sql.Date getDatebeforepay() {
		return datebeforepay.getSqlDate();
	}
	public String getDatebeforepaystr() {
		return datebeforepay.getString();
	}
	public java.sql.Date getDatebuch() {
		return datebuch.getSqlDate();
	}
	public String getDatebuchstr() {
		return datebuch.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 11:58:23)
	 * @return java.sql.Date
	 */
	public String getDateFrm() {
		return date.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:19:51)
	 * @return com.hps.july.web.util.StringAndSqlTimestampProperty
	 */
	public Timestamp getDatenritoplatinum() {
		return datenritoplatinum.getSqlTimestamp();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:19:51)
	 * @return com.hps.july.web.util.StringAndSqlTimestampProperty
	 */
	public String getDatenritoplatinumFrm() {
		return datenritoplatinum.getStringDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:23:12)
	 * @return com.hps.july.web.util.StringAndSqlTimestampProperty
	 */
	public Timestamp getDateplatinum() {
		return dateplatinum.getSqlTimestamp();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:23:12)
	 * @return com.hps.july.web.util.StringAndSqlTimestampProperty
	 */
	public String getDateplatinumFrm() {
		return dateplatinum.getStringDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:34:20)
	 * @return java.lang.String
	 */
	public java.lang.Integer getDefinerate() {
		return definerate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.08.2002 19:39:22)
	 * @return java.lang.String
	 */
	public java.lang.String getDocNumber() {
		return docNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:42:00)
	 * @return java.lang.String
	 */
	public java.lang.String getDocposvid() {
		return docposvid;
	}
	public java.sql.Date getDocumentDate() {
		return documentDate.getSqlDate();
	}
	public java.lang.String getDocumentDateFrm() {
		return documentDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 15:38:36)
	 * @return java.lang.String
	 */
	public java.lang.String getDocumentNumber() {
		return documentNumber;
	}
	/**
	 * RETURN:
	 *   0 - No edit permitted. If payment is used in act
	 *   1 - Edit all. If payment is not used in act and paymentstate = 'G' (Editing)
	 *   2 - Edit partially (period and service_resource). If paymentstate != 'G' and payment is not used in act
	 */
	public int getEditState() {
		if (usedinactcode != null) {
			return 0;
		} else {
			if ("G".equals(getPaymentstate())) {
				return 1;
			} else {
				return 2;
			}
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:45:19)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getEnddate() {
		return enddate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 17:07:12)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getEndDate() {
		return endDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:45:19)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getEnddateFrm() {
		return enddate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 17:07:12)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getEndDateFrm() {
		return endDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:32:27)
	 * @return java.lang.String
	 */
	public java.lang.String getFl101() {
		return fl101;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:32:55)
	 * @return java.lang.String
	 */
	public java.lang.String getFl104() {
		return fl104;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:33:10)
	 * @return java.lang.String
	 */
	public java.lang.String getFl105() {
		return fl105;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:33:25)
	 * @return java.lang.String
	 */
	public java.lang.String getFl106() {
		return fl106;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:33:40)
	 * @return java.lang.String
	 */
	public java.lang.String getFl107() {
		return fl107;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:33:54)
	 * @return java.lang.String
	 */
	public java.lang.String getFl108() {
		return fl108;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:34:07)
	 * @return java.lang.String
	 */
	public java.lang.String getFl109() {
		return fl109;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:34:22)
	 * @return java.lang.String
	 */
	public java.lang.String getFl110() {
		return fl110;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:29:04)
	 * @return java.lang.String
	 */
	public java.lang.String getFlagsync() {
		return flagsync;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.07.2003 15:00:46)
	 * @return int
	 */
	public int getFromcalc() {
		return fromcalc;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:42:41)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdbudjet() {
		return idbudjet;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:43:52)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIddirect() {
		return iddirect;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.02.2003 20:01:10)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdexpence() {
		return idexpence;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 11:59:57)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIditem() {
		return iditem;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:45:31)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdpaymode() {
		return idpaymode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:46:30)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdpaytype() {
		return idpaytype;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:47:19)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdproject() {
		return idproject;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.02.2003 19:19:04)
	 * @return int
	 */
	public int getIdreference() {
		return idreference;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:48:16)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdsubexpence() {
		return idsubexpence;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:51:49)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getIdtypeforbuch() {
		return idtypeforbuch;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.05.2003 16:16:33)
	 * @return java.lang.String
	 */
	public java.lang.String getIsSchetFakt() {
		return isSchetFakt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.05.2003 16:16:33)
	 * @return java.lang.String
	 */
	public boolean getIsSchetFaktFrm() {
		return isSchetFakt.equals("Y") ? true : false;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:34:35)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getKvitpko() {
		return kvitpko;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:05:33)
	 * @return com.hps.july.persistence.LeaseContractAccessBean
	 */
	public com.hps.july.persistence.LeaseContract getLeaseContract() throws Exception {
		LeaseContractAccessBean bean = constructLeaseContract();
		if (bean != null) {
			return (LeaseContract) bean.getEJBRef();
		} else {
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:07:34)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getLeaseContractcode() {
		return leaseContractcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 11:55:00)
	 * @return int
	 */
	public int getLeaseDocPosition() {
		return leaseDocPosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.03.2004 15:55:17)
	 * @return java.lang.String
	 */
	public java.lang.String getMainPosition() {
		return mainPosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:30:57)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getNakladnaya() {
		return nakladnaya;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.01.2004 13:31:23)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getNdsRate() {
		return ndsRate.getBigDecimal();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.01.2004 13:31:23)
	 * @return java.math.BigDecimal
	 */
	public String getNdsRateFrm() {
		return ndsRate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 15:15:50)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getNdsRub() {
		return ndsRub.getBigDecimal();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 15:15:50)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getNdsRubFrm() {
		return ndsRub.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:36:50)
	 * @return java.lang.String
	 */
	public java.lang.String getNumberanddatepay() {
		return numberanddatepay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:37:42)
	 * @return java.lang.String
	 */
	public java.lang.String getNumpayplatinum() {
		return numpayplatinum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:37:42)
	 * @return java.lang.String
	 */
	public java.lang.String getNumpayplatinumDis() {
		return numpayplatinum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.04.2004 12:02:13)
	 * @return java.lang.String
	 */
	public java.lang.String getOfficememonumber() {
		return officememonumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:40:11)
	 * @return com.hps.july.persistence.AccountAccessBean
	 */
	public Account getOrgAcc() throws Exception {
		AccountAccessBean bean = constructOrgAcc();
		if (bean != null)
			return (Account) bean.getEJBRef();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:41:14)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public Integer getOrgAcccode() {
		return orgAcccode.getInteger();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:41:14)
	 * @return com.hps.july.web.util.StringAndIntegerProperty
	 */
	public String getOrgAcccodeFrm() {
		return orgAcccode.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:44:07)
	 * @return java.lang.String
	 */
	public java.lang.String getOrgAccname() {
		return orgAccname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 12:33:54)
	 * @return java.lang.String
	 */
	public java.lang.String getOrgCustomerContract() {
		return orgCustomerContract;
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
	 * Creation date: (08.07.2002 12:33:54)
	 * @return java.lang.String
	 */
	public java.lang.String getOrgExecutorContract() {
		return orgExecutorContract;
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
	 * Creation date: (01.04.2003 15:54:45)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getOtvuser() {
		return otvuser;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 16:21:38)
	 * @return java.lang.String
	 */
	public java.lang.String getOtvuserFrm() {
		return otvuserFrm;
	}
	public java.util.Enumeration getOurBudjets() {
		try {
			// owner = customer from base contract
			LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
			lcBean.setInitKey_leaseDocument(getLeaseContractcode().intValue());
			lcBean.refreshCopyHelper();

			return new PIEBudjetAccessBean().findByOwnerAndRecordstatusOrderByNameAsc(new Integer(lcBean.getOrgCustomerKey().organization), "A");
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 14:50:29)
	 * @return java.util.Enumeration
	 */
	public Enumeration getOurDefinerates() {
		try {
			return new PIEReferenceAccessBean().findByOwnerAndSpravOrderByNameAsc(new Integer(0), PIERefCodes.DEFINERATE);
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	public Enumeration getOurExpences() {
		try {
			LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
			lcBean.setInitKey_leaseDocument(getLeaseContractcode().intValue());
			lcBean.refreshCopyHelper();

			return new PIEExpenceAccessBean().findByOwnerAndRecordstatusOrderByNameAsc(new Integer(lcBean.getOrgCustomerKey().organization), "A");
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	public Enumeration getOurInstructions() {
		try {
			return new PIEReferenceAccessBean().findByOwnerAndSpravOrderByNameAsc(new Integer(0), PIERefCodes.INSTRUCTION);
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	public Enumeration getOurPaymentmodes() {
		try {
			return new PIEReferenceAccessBean().findByOwnerAndSpravOrderByNameAsc(new Integer(0), PIERefCodes.PAYMENTMODE);
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	public Enumeration getOurPaymenttypes() {
		try {
			return new PIEReferenceAccessBean().findBySpravOrderByCodeAsc(PIERefCodes.PAYMENTTYPE);
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	public Enumeration getOurRashods() {
		try {
			return new PIEReferenceAccessBean().findByOwnerAndSpravOrderByNameAsc(new Integer(0), PIERefCodes.RASHOD);
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.03.2003 15:10:46)
	 * @return java.util.Enumeration
	 */
	public Enumeration getOurTypebasedocs() {
		try {
			return new PIEReferenceAccessBean().findByOwnerAndSpravOrderByNameAsc(new Integer(0), PIERefCodes.TYPEBASEDOC);
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	public Enumeration getOurTypeforbuch() {
		try {
			return new PIEReferenceAccessBean().findBySpravOrderByCodeAsc(PIERefCodes.TYPEFORBUCH);
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:58:55)
	 * @return java.lang.String
	 */
	public java.lang.String getPaymentstate() {
		return paymentstate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:37:33)
	 * @return java.lang.String
	 */
	public java.lang.String getPaymentType() {
		return paymentType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:56:37)
	 * @return java.lang.String
	 */
	public java.lang.String getPayPurpose() {
		return payPurpose;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 15:10:06)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getPayrate() {
		return payrate.getBigDecimal();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 15:10:06)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getPayrateFrm() {
		return payrate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:52:57)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getPaystateplatinum() {
		return paystateplatinum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.04.2003 16:41:43)
	 * @return java.lang.String
	 */
	public java.lang.String getPaystateplatinumFrm() {
		return paystateplatinumFrm;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 12:50:04)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getPercentavans() {
		return getTypeinstr().intValue() == getArendaTypeInstrOpl() ? percentavans.getBigDecimal() : null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 12:50:04)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getPercentavansFrm() {
		return percentavans.getString();
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getPositionName() {
		return positionName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:57:33)
	 * @return java.lang.String
	 */
	public java.lang.String getPpType() {
		return ppType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:40:52)
	 * @return java.lang.String
	 */
	public java.lang.String getPurposepay() {
		return purposepay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:40:52)
	 * @return java.lang.String
	 */
	public java.lang.String getPurposepayDis() {
		return purposepay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 11:45:34)
	 * @return java.lang.String
	 */
	public java.lang.String getRatecalcrule() {
		return ratecalcrule;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 11:48:22)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getRatecalcruleday() {
		return ratecalcruleday;
	}
	public java.sql.Date getRatedate() {
		return ratedate.getSqlDate();
	}
	public java.sql.Date getRatedatecalc() {
		return ratedatecalc.getSqlDate();
	}
	public String getRatedatecalcFrm() {
		return ratedatecalc.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.01.2003 17:59:15)
	 * @return java.sql.Date
	 */
	public String getRatedateFrm() {
		return ratedate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 11:47:51)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getRatedelta() {
		return ratedelta;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 11:54:08)
	 * @return com.hps.july.persistence.ResourceAccessBean
	 */
	public Resource getResource() throws Exception {
		ResourceAccessBean bean = constructResource();
		return bean != null ? (Resource) bean.getEJBRef() : null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:51:11)
	 * @return int
	 */
	public int getResourcecode() {
		return resourcecode;
	}
	public java.util.Enumeration getResources() {
		// FROM UsPaymentForm
		/* no super call
			try {
				NamedValueAccessBean bean = new NamedValueAccessBean();
				bean.setInitKey_id("ARENDA_TYPE");
				bean.refreshCopyHelper();
		
				return (new ResourceAccessBean()).findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
					new Boolean(false), null, new Boolean(false), null, new Integer(3));
			} catch(Exception e) {
				e.printStackTrace();
				return (new java.util.Vector()).elements();	
			}
		*/
		// END FROM UsPaymentForm
		try {
			java.util.Vector v = new java.util.Vector();
			v.addElement(getLeaseContractcode());

			Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(getLeaseContractcode(), new Boolean(false), null, new Boolean(false), null, new Integer(1));
			while (e.hasMoreElements()) {
				LeaseArendaAgreementNewAccessBean laanBean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
				v.addElement(new Integer(laanBean.getLeaseDocument()));
			}

			return new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.03.2003 14:50:41)
	 * @return int
	 */
	public int getRur() {
		return rur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:33:00)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getSf() {
		return sf;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:22:20)
	 * @return java.lang.String
	 */
	public java.lang.String getSource() {
		return source;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 17:01:33)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public Date getStartDate() {
		return startDate.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 17:01:33)
	 * @return com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public String getStartDateFrm() {
		return startDate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.07.2002 14:02:29)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.PAYMENT_EDIT;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 14:28:15)
	 * @return java.lang.String
	 */
	public java.lang.String getStateOfContract() {
		return stateOfContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 13:34:24)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumm() {
		return summ.getBigDecimal();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 13:34:24)
	 * @return java.math.BigDecimal
	 */
	public String getSummFrm() {
		return summ.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:43:41)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public BigDecimal getSumnds() {
		return sumnds.getBigDecimal();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:43:41)
	 * @return com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public String getSumndsFrm() {
		return sumnds.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:36:16)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumRub() {
		return sumRub.getBigDecimal();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:36:16)
	 * @return java.math.BigDecimal
	 */
	public String getSumRubFrm() {
		return sumRub.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.02.2003 15:20:20)
	 * @return java.lang.String
	 */
	public java.lang.String getSYNCNRIPLATINARENDA() {
		return SYNCNRIPLATINARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:32:02)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getTovcheck() {
		return tovcheck;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:41:31)
	 * @return java.lang.String
	 */
	public java.lang.Integer getTypebasedoc() {
		return typebasedoc;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:53:45)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getTypeinstr() {
		return typeinstr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:57:05)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getTyperashod() {
		return typerashod;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.11.2003 16:14:07)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getUsedinactcode() {
		return usedinactcode;
	}
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		System.out.println("PAYFORM: initCollections");
		//	super.initCollections(request);
		// FROM UsPaymentForm
		try {
			PaymentsListForm form = (PaymentsListForm) request.getSession().getAttribute(listForm);
			if (form != null) {
				setMainPosition(form.getMainPosition());
				setStateOfContract(form.getStateOfContract());
				setDocumentNumber(form.getDocumentNumber());
				setDocumentDate(form.getDocumentDate());
				setOrgCustomerContract(form.getOrgCustomer());
				setOrgExecutorContract(form.getOrgExecutor());
				setStartDate(form.getStartDate());
				setEndDate(form.getEndDate());
				if (form.getCurrency1() != null) {
					setCostcurrency1(form.getCurrency1().toString());
					setCurr1(form.getCurr1());
				} else {
					setCostcurrency1("");
				}
				if (form.getCurrency2() != null) {
					setCostcurrency2(form.getCurrency2().toString());
					setCurr2(form.getCurr2());
				} else {
					setCostcurrency2("");
				}
				setLeaseContractcode(new Integer(form.getLeaseContract()));
				setPositionName(findPositionName(form.getLeaseContract()));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		//Устанавливаем нац. валюту:
		//setRur(com.hps.july.util.AppUtils.getNamedValueInt("RUR"));
		Currency_VO nationalCurrencyVO = ProfileAccessHelper.getNationalCurrency_VO(request);
		if (nationalCurrencyVO != null) {
			setRur(nationalCurrencyVO.getCurrency().intValue());
			setRurName(nationalCurrencyVO.getShortname());
		} else {
			setRur(com.hps.july.util.AppUtils.getNamedValueInt("RUR"));
			setRurName("RUR");
		}

		// For NDS calculation in form
		java.math.BigDecimal aval = com.hps.july.util.AppUtils.getNamedValueBigDecimal(com.hps.july.util.AppUtils.DEFAULT_RATE_NDS);
		setCalcNdsRate(aval.toString());
		System.out.println("PAYFORM: NDS Rate:" + aval);
		// END FROM UsPaymentForm

		//platinum
		setSYNCNRIPLATINARENDA(null);
		try {
			if (new ArendaPlatinumProcessorAccessBean().isProcessingEnabled()) {
				setSYNCNRIPLATINARENDA("ok");

				try {
					NamedValueAccessBean nvBean = new NamedValueAccessBean();
					nvBean.setInitKey_id("ArendaPredopl");
					nvBean.refreshCopyHelper();

					setArendaTypeInstrOpl(nvBean.getIntvalue());
				} catch (Exception e) {
					e.printStackTrace();
					setArendaTypeInstrOpl(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		//platinum end
	}
	private static void initEditableMap() {
		String[] a;

		// Редактируется
		a = new String[] {
			"docNumber", "date",
			"orgExecutor",
				"orgAccount",
				"ppType",
				"billNumber",
				"billDate",
				"isSchetFakt",
				"begindate",
				"enddate",
				"resource",
				"summ",
				"ndsRate",
				"sumnds",
				"currencycode",
				"payrate",
				"sumRub",
				"ndsRub",
				"payPurpose" };
		java.util.Arrays.sort(a);
		editableMap.put("G", a);

		// Оплачен
		a = new String[] { "begindate", "enddate", "resource" };
		java.util.Arrays.sort(a);
		editableMap.put("P", a);

		// Оформляется
		a =
			new String[] {
				"date",
				"docNumber",
				"orgExecutor",
				"orgAccount",
				"ppType",
				"billNumber",
				"billDate",
				"isSchetFakt",
				"begindate",
				"enddate",
				"resource",
				"summ",
				"ndsRate",
				"sumnds",
				"currencycode",
				"payrate",
				"sumRub",
				"ndsRub",
				"payPurpose" };
		java.util.Arrays.sort(a);
		editableMap.put("N", a);

		// Напечатан
		a = new String[] { "" };
		java.util.Arrays.sort(a);
		editableMap.put("K", a);

		// Отправлен в бухгалтерию
		a = new String[] { "" };
		java.util.Arrays.sort(a);
		editableMap.put("M", a);

		// Возврат
		a = new String[] { "" };
		java.util.Arrays.sort(a);
		editableMap.put("V", a);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		System.out.println("PAYFORM: initrecord");
		//	super.initRecord(request);
		// FROM UsPaymentForm
		setDate(null);
		setBegindate(null);
		setEnddate(null);

		try {
			LeaseContractAccessBean acontr = new LeaseContractAccessBean();
			acontr.setInitKey_leaseDocument(getLeaseContractcode().intValue());
			acontr.refreshCopyHelper();
			/**
			 * правило определения курса платежей по договору" при добавлении платежа
			 * должно отображаться из последнего действующего доп. соглашения.	
					setRatecalcrule(acontr.getRatecalcrule());
					if (acontr.getRatecalcruleday() != null)
						setRatecalcruleday(new Integer(acontr.getRatecalcruleday().intValue()));
					setRatedelta(acontr.getRatedelta());
			*/
			rateCalcRuleFromActiveDocument();
			setNdsRateFrm(getCalcNdsRate());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		// END FROM UsPaymentForm
		/**
			* Получаем из 
			PaymentsListForm form = (PaymentsListForm) request.getSession().getAttribute(listForm);
		
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(form.getOrgExecutorcode());
			bean.refreshCopyHelper();
		
			setOrgExecutorcode(new Integer(bean.getOrganization()));
			setOrgExecutorname(bean.getName());
		
			AccountAccessBean aBean = null;
			Enumeration enum = new AccountAccessBean().findAccountByOrganization(new OrganizationKey(form.getOrgExecutorcode()));
			int i = 0;
			while (enum.hasMoreElements()) {
				aBean = (AccountAccessBean) enum.nextElement();
				if (++i > 1) {
					break;
				}
			}
			if (i == 1) {
				setOrgAcccode(new Integer(aBean.getAccount()));
				setOrgAccname(aBean.getAccountvalue());
				setBank(aBean.getBank().getName());
				setCoraccount(aBean.getBank().getKoraccount());
				setBik(aBean.getBank().getBik());
			}
		*/
		setOrgExecutorcode(new Integer(-1));
		setOrgExecutorname("");
		setOrgAcccode(null);
		setOrgAccname("");
		setBank("");
		setCoraccount("");
		setBik("");

		setIsSchetFakt("N");
		setFlagOplNds(Boolean.FALSE);

		// platinum
		if ("ok".equals(getSYNCNRIPLATINARENDA())) {

			// Set init values for FL101-FL110 tax fields - from previos payment
			Enumeration en = new LeasePaymentAccessBean().findByQBE(Boolean.TRUE, getLeaseContractcode(), Boolean.FALSE, null, null, Boolean.TRUE, new Integer(getResourcecode()), new Integer(2));
			while (en.hasMoreElements()) {
				LeasePaymentAccessBean lpab = (LeasePaymentAccessBean) en.nextElement();
				// Check if we have corresponding DopInfoLPayment
				try {
					DopInfoLPaymentAccessBean dab = new DopInfoLPaymentAccessBean();
					dab.setInitKey_leasedocposition(lpab.getLeaseDocPosition());
					dab.refreshCopyHelper();
					// Fill tax fields
					setFl101(dab.getFl101());
					setFl104(dab.getFl104());
					setFl105(dab.getFl105());
					setFl106(dab.getFl106());
					setFl107(dab.getFl107());
					setFl108(dab.getFl108());
					setFl109(dab.getFl109());
					setFl110(dab.getFl110());
					break;
				} catch (javax.ejb.ObjectNotFoundException e) {
					// Ignore
				} catch (Exception e) {
					e.printStackTrace(System.out);
					break;
				}
			}

			try {
				NamedValueAccessBean nvBean = new NamedValueAccessBean();
				nvBean.setInitKey_id("ArendaTypeRashod");
				nvBean.refreshCopyHelper();
				setTyperashod(new Integer(nvBean.getIntvalue()));
			} catch (Exception e) {
				e.printStackTrace();
				setTyperashod(new Integer(0));
			}

			try {
				NamedValueAccessBean nvBean = new NamedValueAccessBean();
				nvBean.setInitKey_id("ArendaTypeBaseDoc");
				nvBean.refreshCopyHelper();
				setTypebasedoc(new Integer(nvBean.getIntvalue()));
			} catch (Exception e) {
				e.printStackTrace();
				setTypebasedoc(new Integer(0));
			}

			try {
				LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
				lcBean.setInitKey_leaseDocument(getLeaseContractcode().intValue());
				lcBean.refreshCopyHelper();
				StringAndSqlDateProperty s = new StringAndSqlDateProperty();
				s.setSqlDate(lcBean.getDocumentDate());

				setNumberanddatepay("№ " + lcBean.getDocumentNumber() + " от " + s.getString());
			} catch (Exception e) {
				e.printStackTrace();
				setNumberanddatepay("");
			}

			try {
				NamedValueAccessBean nvBean = new NamedValueAccessBean();
				nvBean.setInitKey_id("ArendaTypeInstrOpl");
				nvBean.refreshCopyHelper();

				setTypeinstr(new Integer(nvBean.getIntvalue()));
			} catch (Exception e) {
				e.printStackTrace();
				setTypeinstr(new Integer(0));
			}

			java.util.GregorianCalendar c = new java.util.GregorianCalendar();
			c.add(java.util.Calendar.DAY_OF_MONTH, 10);
			setDatebuch(null);
			setDatebeforepay(new Date(c.getTime().getTime()));

			try {
				LeaseContractAccessBean lcBean = new LeaseContractAccessBean();
				lcBean.setInitKey_leaseDocument(getLeaseContractcode().intValue());
				lcBean.refreshCopyHelper();

				if (lcBean.getRatecalcrule().equals("B")) {
					setDefinerate(new Integer(AppUtils.getNamedValueInt("ArendaDayOpl")));
				} else if (lcBean.getRatecalcrule().equals("C")) {
					setDefinerate(new Integer(AppUtils.getNamedValueInt("ArendaBeforeDayOpl")));
				} else {
					setDefinerate(null);
				}
			} catch (Exception e) {
				setDefinerate(null);
			}

			setSf(new Boolean(true));

			try {
				OperatorAccessBean oBean = new OperatorAccessBean().findByLogin(request.getUserPrincipal().getName());
				setOtvuser(new Integer(oBean.getOperator()));
				setOtvuserFrm(oBean.getMan().getFullName());
			} catch (Exception e) {
				e.printStackTrace();
				setOtvuser(null);
				setOtvuserFrm("");
			}

			setPaystateplatinum(new Integer(0));
			setPaystateplatinumFrm("");

			try {
				PIEDopInfoContrAccessBean piedicBean = new PIEDopInfoContrAccessBean();
				piedicBean.setInitKey_leasedocument(getLeaseContractcode().intValue());
				piedicBean.refreshCopyHelper();

				setIdbudjet(piedicBean.getIdbudjet());
				setIditem(piedicBean.getIdexpense());
			} catch (Exception e) {
				e.printStackTrace();
				setIdbudjet(new Integer(0));
				setIditem(new Integer(0));
			}
		}
	}
	/**
	 * Возвращает true если нужно провять "Правило определения курса для Platinum"
	 * в validate.
	 */
	public boolean isCheckDefinerate() {
		if ((getCurrencycode() != null && getCurrencycode().intValue() == getRur()) || (getSumRub() != null)) {
			System.out.println("PaymentForm:CHECK_RATE:false");
			return false;
		} else {
			System.out.println("PaymentForm:CHECK_RATE:true");
			return true;
		}
	}
	public boolean isEditable(String field) {
		if (getPaymentstate() == null) {
			return false;
		}

		if (usedinactcode != null) {
			return false;
		} else {
			//		if("G".equals(getPaymentstate())) {
			//			return true;
			//		} else {
			String[] editableProperties = (String[]) editableMap.get(getPaymentstate());
			int res = java.util.Arrays.binarySearch(editableProperties, field);
			return (res >= 0);
			//		}
		}
	}
	public String isEditableStr(String field) {
		return String.valueOf(isEditable(field));
	}
	public static boolean isInAct(int payment) {
		boolean result = false;
		try {
			LeaseDocPositionAccessBean p = new LeaseDocPositionAccessBean();
			p.setInitKey_leaseDocPosition(payment);
			p.refreshCopyHelper();
			result = (p.getUsedinact() != null);
			p = null;
		} catch (javax.ejb.ObjectNotFoundException onf) {
			System.out.println("IS IN ACT: NotFound by " + payment);
		} catch (Exception e) {
			System.out.println("IS IN ACT: Exception " + e.getClass().getName());
		}
		return result;
	}
	private boolean isSYNCNRIPLATINARENDA() {
		try {
			NamedValueAccessBean ab = new NamedValueAccessBean();
			ab.setInitKey_id("SYNCNRIPLATINARENDA");
			ab.refreshCopyHelper();
			return ab.getIntvalue() == 1;
		} catch (Exception e) {
			System.out.println("Error in UsPaymentForm.isSYNCNRIPLATINARENDA()");
			e.printStackTrace(System.out);
		}
		return false;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.01.2004 14:25:23)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) {
		//	if (getCalctype().equals("CalcSumm")) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "execute procedure calcSumPay(?, ?, ?, ?, ?)";
			con = new JdbcConnection().getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, 4227); //код договора - getLeaseContractcode().intValue()
			ps.setInt(2, 10445); //услуга - getResourcecode()
			ps.setDate(3, new java.sql.Date(System.currentTimeMillis())); //дата начала периода - getBegindate()
			ps.setDate(4, new java.sql.Date(System.currentTimeMillis())); //дата окончания периода - getEnddate()
			ps.setInt(5, 840); //валюта - getCurrencycode().intValue()

			rs = ps.executeQuery();
			if (rs.next()) {
				int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
				String errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
				BigDecimal summFrm = rs.getBigDecimal(3); //--Сумма 
				BigDecimal sumndsFrm = rs.getBigDecimal(4); //-- НДС
				BigDecimal calcNdsRate = rs.getBigDecimal(5); //ставка НДС
				int curr = rs.getInt(6); //-- Валюта
				BigDecimal sumRubFrm = rs.getBigDecimal(7); // -- Сумма в рублях
				BigDecimal ndsRubFrm = rs.getBigDecimal(8); // -- НДС в рублях
				String НазначениеПП = rs.getString(9);

				if (result == 0) {
					System.out.println("errorTxt: " + errorTxt); //temp
					System.out.println("summFrm: " + summFrm); //temp
					System.out.println("sumndsFrm: " + sumndsFrm); //temp
					System.out.println("calcNdsRate: " + calcNdsRate); //temp
					System.out.println("curr: " + curr); //temp
					System.out.println("sumRubFrm: " + sumRubFrm); //temp
					System.out.println("ndsRubFrm: " + ndsRubFrm); //temp
					System.out.println("НазначениеПП: " + НазначениеПП); //temp
				} else {
					//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
				}
			} else {
				//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report.rate"));
				System.out.println("no DATA"); //temp
			}

			//Object[] o = new ArendaTransactionMethodAccessBean().defineRatePaymentOnContract(
			//getCurrencycode(), getLeaseContractcode(), getDate(), 
			//getBillDate(), getBegindate(), getEnddate(), null);
			//setPayrate((BigDecimal) o[0]);
			//setRatedate(new Date(((java.util.Date) o[1]).getTime()));
		} catch (Exception ex) {
			System.out.println("Error in execute procedure DefRatePayOnContr. PaymentForm.validateValues()");
			if (ex instanceof SQLException) {
				System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
			}
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}

		//	}

	}
	private void processCalcOptions(ActionErrors errors) throws java.lang.Exception {
		System.out.println("PAYFORM: processcalcoptions");
		if ("N".equals(getCalctype())) {
			if (begindate.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.begindate.empty"));
			}
			if (summ.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.sum.empty"));
			} else if (!summ.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.sum.error"));
			}

			if (!begindate.isEmpty() && !summ.isEmpty() && summ.isOk()) {
				setSumnds(new ArendaDocumentTransactionMethodAccessBean().calcNds(new Integer(getResourcecode()), getBegindate(), getSumm(), "1"));
			}
			setFromcalc(1);
			throw new ValidationException();
		}
		if ("NR".equals(getCalctype())) {
			if (getBegindate() != null && getSumRub() != null) {
				setNdsRub(new ArendaDocumentTransactionMethodAccessBean().calcNds(new Integer(getResourcecode()), getBegindate(), getSumRub(), "1"));
			}
			setFromcalc(1);
			throw new ValidationException();
		}
		if ("CalcSumm".equals(getCalctype())) {
			calcSumm(errors);
			setFromcalc(1);
			throw new ValidationException();
		}
		if ("R".equals(getCalctype())) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				String sql = "execute procedure DefRatePayOnContr(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				con = new JdbcConnection().getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, "L"); //i_FlagDefContract 
				ps.setInt(2, getLeaseContractcode().intValue()); //код договора
				ps.setInt(3, getCurrencycode().intValue()); //валюта
				ps.setDate(4, getDate()); //дата платежа
				ps.setDate(5, getBillDate()); //дата счета
				ps.setDate(6, getBegindate()); //дата начала периода
				ps.setDate(7, getEnddate()); //дата окончания периода
				ps.setInt(8, 0); //код платежа
				ps.setInt(9, 0); //код журнала (если нет, то ноль)
				rs = ps.executeQuery();
				if (rs.next()) {
					BigDecimal payRate = rs.getBigDecimal(1);
					Date payDate = rs.getDate(2);
					int result = rs.getInt(3);
					String errorTxt = rs.getString(4);
					if (result == 0) {
						setPayrate(payRate);
						setRatedate(payDate);
					} else {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
					}
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report.rate"));
				}
			} catch (Exception ex) {
				System.out.println("Error in execute procedure DefRatePayOnContr. PaymentForm.validateValues()");
				if (ex instanceof SQLException) {
					System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
				}
				ex.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
				try {
					if (ps != null)
						ps.close();
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
				try {
					if (con != null)
						con.close();
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}
			//}
			setFromcalc(1);
			throw new ValidationException();
		}
		if ("CD".equals(getCalctype())) {
			try {
				if (getCurrencycode() == null) {
					System.out.println("CURRENCY null");
					throw new Exception();
				}
				if (getRatedatecalc() == null) {
					System.out.println("RATEDATECALC null");
					throw new Exception();
				}
				int rateType = com.hps.july.util.AppUtils.getNamedValueInt("BASE_RATETYPE_ARENDA");
				System.out.println("RATEDATECALC rateType:" + rateType);
				RateAccessBean ratefind = new RateAccessBean();
				RateAccessBean rate = ratefind.findByTypeCurrencyForDate(new Integer(rateType), getCurrencycode(), getRatedatecalc());
				setPayrate(rate.getValue());
				setRatedate(getRatedatecalc());
			} catch (Exception e) {
				setPayrateFrm("???");
				e.printStackTrace(System.out);
			}
			setFromcalc(1);
			throw new ValidationException();
		}
	}
	/**
	 * правило определения курса платежей по договору" при редактировании(добавлении) платежа
	 * должна отображаться из последнего действующего доп. соглашения.
	 * Creation date: (02.03.2004 17:05:18)
	 */
	private void rateCalcRuleFromActiveDocument() {
		try {
			int baseContract = new LeaseArendaAgreementProcessorBean().getBaseContract(getLeaseContractcode().intValue());
			Enumeration e = new LeaseArendaAgreementNewAccessBean().findByQBE2(new Integer(baseContract), new Boolean(true), new Boolean(true), new Boolean(false), null, new Integer(1));
			if (e.hasMoreElements()) {
				LeaseArendaAgreementNewAccessBean bean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
				setRatecalcrule(bean.getRatecalcrule());
				if (bean.getRatecalcruleday() != null)
					setRatecalcruleday(new Integer(bean.getRatecalcruleday().intValue()));
				setRatedelta(bean.getRatedelta());

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("");
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 16:27:42)
	 * @param newAct com.hps.july.persistence.LeaseMutualActNewAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	public void setAct(LeaseMutualActNewAccessBean newAct) throws java.lang.Exception {
		try {
			if (newAct == null) {
				actcode = 0;
			} else {
				actcode = newAct.getLeaseDocument();
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			actcode = 0;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 16:25:15)
	 * @param newActcode int
	 */
	public void setActcode(int newActcode) {
		actcode = newActcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 14:21:02)
	 * @param newArendaTypeInstrOpl int
	 */
	public void setArendaTypeInstrOpl(int newArendaTypeInstrOpl) {
		arendaTypeInstrOpl = newArendaTypeInstrOpl;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 12:18:43)
	 * @param newBank java.lang.String
	 */
	public void setBank(java.lang.String newBank) {
		bank = newBank;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:43:00)
	 * @param newBegindate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setBegindate(Date newBegindate) {
		begindate.setSqlDate(newBegindate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:43:00)
	 * @param newBegindate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setBegindateFrm(String newBegindate) {
		begindate.setString(newBegindate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 12:32:46)
	 * @param newBik java.lang.String
	 */
	public void setBik(java.lang.String newBik) {
		bik = newBik;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 11:41:31)
	 * @param newBillDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setBillDate(Date newBillDate) {
		billDate.setSqlDate(newBillDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 11:41:31)
	 * @param newBillDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setBillDateFrm(String newBillDate) {
		billDate.setString(newBillDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 11:45:03)
	 * @param newBillNumber java.lang.String
	 */
	public void setBillNumber(java.lang.String newBillNumber) {
		billNumber = newBillNumber;
	}
	/**
	 * 
	 * @param newCalcNdsRate java.lang.String
	 */
	public void setCalcNdsRate(java.lang.String newCalcNdsRate) {
		calcNdsRate = newCalcNdsRate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.01.2003 16:08:47)
	 * @param newCalctype java.lang.String
	 */
	public void setCalctype(java.lang.String newCalctype) {
		calctype = newCalctype;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:33:48)
	 * @param newCascheck java.lang.Boolean
	 */
	public void setCascheck(java.lang.Boolean newCascheck) {
		cascheck = newCascheck;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 12:32:25)
	 * @param newCoraccount java.lang.String
	 */
	public void setCoraccount(java.lang.String newCoraccount) {
		coraccount = newCoraccount;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 17:14:54)
	 * @param newCostcurrency1 java.lang.String
	 */
	public void setCostcurrency1(java.lang.String newCostcurrency1) {
		costcurrency1 = newCostcurrency1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 17:14:54)
	 * @param newCostcurrency2 java.lang.String
	 */
	public void setCostcurrency2(java.lang.String newCostcurrency2) {
		costcurrency2 = newCostcurrency2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.08.2002 15:23:48)
	 * @param newCurr1 java.lang.String
	 */
	public void setCurr1(java.lang.String newCurr1) {
		curr1 = newCurr1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.08.2002 15:24:02)
	 * @param newCurr2 java.lang.String
	 */
	public void setCurr2(java.lang.String newCurr2) {
		curr2 = newCurr2;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 15:32:41)
	 * @param newCurency com.hps.july.persistence.CurrencyAccessBean
	 */
	public void setCurrency(com.hps.july.persistence.CurrencyAccessBean newCurrency) throws Exception {
		try {
			if (newCurrency == null) {
				currencycode = new Integer(0);
			} else {
				currencycode = new Integer(newCurrency.getCurrency());
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			currencycode = new Integer(0);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 13:32:59)
	 * @param newCurrencycode java.lang.Integer
	 */
	public void setCurrencycode(java.lang.Integer newCurrencycode) {
		currencycode = newCurrencycode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 11:58:23)
	 * @param newDate java.sql.Date
	 */
	public void setDate(java.sql.Date newDate) {
		date.setSqlDate(newDate);
	}
	public void setDatebeforepay(java.sql.Date newdate) {
		datebeforepay.setSqlDate(newdate);
	}
	public void setDatebeforepaystr(String newdatestr) {
		datebeforepay.setString(newdatestr);
	}
	public void setDatebuch(java.sql.Date newdate) {
		datebuch.setSqlDate(newdate);
	}
	public void setDatebuchstr(String newdatestr) {
		datebuch.setString(newdatestr);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 11:58:23)
	 * @param newDate java.sql.Date
	 */
	public void setDateFrm(String newDate) {
		date.setString(newDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:19:51)
	 * @param newDatenritoplatinum com.hps.july.web.util.StringAndSqlTimestampProperty
	 */
	public void setDatenritoplatinum(Timestamp newDatenritoplatinum) {
		datenritoplatinum.setSqlTimestamp(newDatenritoplatinum);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:19:51)
	 * @param newDatenritoplatinum com.hps.july.web.util.StringAndSqlTimestampProperty
	 */
	public void setDatenritoplatinumFrm(String newDatenritoplatinum) {
		datenritoplatinum.setString(newDatenritoplatinum);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:23:12)
	 * @param newDateplatinum com.hps.july.web.util.StringAndSqlTimestampProperty
	 */
	public void setDateplatinum(Timestamp newDateplatinum) {
		dateplatinum.setSqlTimestamp(newDateplatinum);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:23:12)
	 * @param newDateplatinum com.hps.july.web.util.StringAndSqlTimestampProperty
	 */
	public void setDateplatinumFrm(String newDateplatinum) {
		dateplatinum.setString(newDateplatinum);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:34:20)
	 * @param newDefinerate java.lang.String
	 */
	public void setDefinerate(java.lang.Integer newDefinerate) {
		definerate = newDefinerate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.08.2002 19:39:22)
	 * @param newDocNumber java.lang.String
	 */
	public void setDocNumber(java.lang.String newDocNumber) {
		docNumber = newDocNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:42:00)
	 * @param newDocposvid java.lang.String
	 */
	public void setDocposvid(java.lang.String newDocposvid) {
		docposvid = newDocposvid;
	}
	public void setDocumentDate(java.sql.Date newDocumentDate) {
		documentDate.setSqlDate(newDocumentDate);
	}
	public void setDocumentDateFrm(String newDocumentDate) {
		documentDate.setString(newDocumentDate);
	}
	public void setDocumentNumber(String newDocumentNumber) {
		documentNumber = newDocumentNumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.03.2003 11:46:30)
	 * @param bean com.hps.july.persistence.DopInfoLPaymentAccessBean
	 */
	private void setDopInfo(DopInfoLPaymentAccessBean bean) {
		bean.setFl101(getFl101());
		bean.setFl104(getFl104());
		bean.setFl105(getFl105());
		bean.setFl106(getFl106());
		bean.setFl107(getFl107());
		bean.setFl108(getFl108());
		bean.setFl109(getFl109());
		bean.setFl110(getFl110());
		bean.setDatebeforepay(getDatebeforepay());
		bean.setDatebuch(getDatebuch());
		bean.setDefinerate(getDefinerate());
		bean.setIdbudjet(getIdbudjet());
		bean.setIdexpence(getIditem());
		bean.setIdpaymode(getIdpaymode());
		bean.setIdpaytype(getIdpaytype());
		bean.setIsact(getNakladnaya());
		bean.setIskassacheck(getCascheck());
		bean.setIskvitancia(getKvitpko());
		bean.setIsschet(getSf());
		bean.setIstovcheck(getTovcheck());
		bean.setNumberanddatebasedoc(getNumberanddatepay());
		bean.setNumpayplatinum(getNumpayplatinum());
		bean.setOtvuser(getOtvuser());
		bean.setPaystateplatinum(getPaystateplatinum());
		bean.setPercentavans(getPercentavans());
		bean.setPurposepay(getPurposepay());
		bean.setTypebasedoc(getTypebasedoc());
		bean.setTypeinstr(getTypeinstr());
		bean.setTyperashod(getTyperashod());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:45:19)
	 * @param newEnddate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setEnddate(Date newEnddate) {
		enddate.setSqlDate(newEnddate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 17:07:12)
	 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setEndDate(Date newEndDate) {
		endDate.setSqlDate(newEndDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:45:19)
	 * @param newEnddate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setEnddateFrm(String newEnddate) {
		enddate.setString(newEnddate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 17:07:12)
	 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setEndDateFrm(String newEndDate) {
		endDate.setString(newEndDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:32:27)
	 * @param newFl101 java.lang.String
	 */
	public void setFl101(java.lang.String newFl101) {
		fl101 = newFl101;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:32:55)
	 * @param newFl104 java.lang.String
	 */
	public void setFl104(java.lang.String newFl104) {
		fl104 = newFl104;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:33:10)
	 * @param newFl105 java.lang.String
	 */
	public void setFl105(java.lang.String newFl105) {
		fl105 = newFl105;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:33:25)
	 * @param newFl106 java.lang.String
	 */
	public void setFl106(java.lang.String newFl106) {
		fl106 = newFl106;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:33:40)
	 * @param newFl107 java.lang.String
	 */
	public void setFl107(java.lang.String newFl107) {
		fl107 = newFl107;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:33:54)
	 * @param newFl108 java.lang.String
	 */
	public void setFl108(java.lang.String newFl108) {
		fl108 = newFl108;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:34:07)
	 * @param newFl109 java.lang.String
	 */
	public void setFl109(java.lang.String newFl109) {
		fl109 = newFl109;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.12.2003 10:34:22)
	 * @param newFl110 java.lang.String
	 */
	public void setFl110(java.lang.String newFl110) {
		fl110 = newFl110;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.04.2003 11:29:04)
	 * @param newFlagsync java.lang.String
	 */
	public void setFlagsync(java.lang.String newFlagsync) {
		flagsync = newFlagsync;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.07.2003 15:00:46)
	 * @param newFromcalc int
	 */
	public void setFromcalc(int newFromcalc) {
		fromcalc = newFromcalc;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:42:41)
	 * @param newIdbudjet java.lang.Integer
	 */
	public void setIdbudjet(java.lang.Integer newIdbudjet) {
		idbudjet = newIdbudjet;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:43:52)
	 * @param newIddirect java.lang.Integer
	 */
	public void setIddirect(java.lang.Integer newIddirect) {
		iddirect = newIddirect;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.02.2003 20:01:10)
	 * @param newIdexpence java.lang.Integer
	 */
	public void setIdexpence(java.lang.Integer newIdexpence) {
		idexpence = newIdexpence;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 11:59:57)
	 * @param newIditem java.lang.Integer
	 */
	public void setIditem(java.lang.Integer newIditem) {
		iditem = newIditem;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:45:31)
	 * @param newIdpaymode java.lang.Integer
	 */
	public void setIdpaymode(java.lang.Integer newIdpaymode) {
		idpaymode = newIdpaymode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:46:30)
	 * @param newIdpaytype java.lang.Integer
	 */
	public void setIdpaytype(java.lang.Integer newIdpaytype) {
		idpaytype = newIdpaytype;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:47:19)
	 * @param newIdproject java.lang.Integer
	 */
	public void setIdproject(java.lang.Integer newIdproject) {
		idproject = newIdproject;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.02.2003 19:19:04)
	 * @param newIdreference int
	 */
	public void setIdreference(int newIdreference) {
		idreference = newIdreference;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:48:16)
	 * @param newIdsubexpence java.lang.Integer
	 */
	public void setIdsubexpence(java.lang.Integer newIdsubexpence) {
		idsubexpence = newIdsubexpence;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:51:49)
	 * @param newIdtypeforbuch java.lang.Integer
	 */
	public void setIdtypeforbuch(java.lang.Integer newIdtypeforbuch) {
		idtypeforbuch = newIdtypeforbuch;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.05.2003 16:16:33)
	 * @param newIsSchetFakt java.lang.String
	 */
	public void setIsSchetFakt(java.lang.String newIsSchetFakt) {
		isSchetFakt = newIsSchetFakt;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.05.2003 16:16:33)
	 * @param newIsSchetFakt java.lang.String
	 */
	public void setIsSchetFaktFrm(boolean newIsSchetFakt) {
		setIsSchetFakt(newIsSchetFakt ? "Y" : "N");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:34:35)
	 * @param newKvitpko java.lang.Boolean
	 */
	public void setKvitpko(java.lang.Boolean newKvitpko) {
		kvitpko = newKvitpko;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:05:33)
	 * @param newLeaseContract com.hps.july.persistence.LeaseContractAccessBean
	 */
	public void setLeaseContract(com.hps.july.persistence.LeaseContractAccessBean newLeaseContract) throws Exception {
		try {
			if (newLeaseContract == null) {
				leaseContractcode = null;
			} else {
				leaseContractcode = new Integer(newLeaseContract.getLeaseDocument());
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			leaseContractcode = null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:07:34)
	 * @param newLeaseContractcode java.lang.Integer
	 */
	public void setLeaseContractcode(java.lang.Integer newLeaseContractcode) {
		leaseContractcode = newLeaseContractcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 11:55:00)
	 * @param newLeaseDocPosition int
	 */
	public void setLeaseDocPosition(int newLeaseDocPosition) {
		leaseDocPosition = newLeaseDocPosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.03.2004 15:55:17)
	 * @param newMainPosition java.lang.String
	 */
	public void setMainPosition(java.lang.String newMainPosition) {
		mainPosition = newMainPosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:30:57)
	 * @param newNakladnaya java.lang.Boolean
	 */
	public void setNakladnaya(java.lang.Boolean newNakladnaya) {
		nakladnaya = newNakladnaya;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.01.2004 13:31:23)
	 * @param newNdsRate java.math.BigDecimal
	 */
	public void setNdsRate(java.math.BigDecimal newNdsRate) {
		System.out.println("PAYFORM: setNdsRate(" + newNdsRate + ")");
		ndsRate.setBigDecimal(newNdsRate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.01.2004 13:31:23)
	 * @param newNdsRate String
	 */
	public void setNdsRateFrm(String newNdsRateStr) {
		System.out.println("PAYFORM: setNdsRateFrm(" + newNdsRateStr + ")");
		ndsRate.setString(newNdsRateStr);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 15:15:50)
	 * @param newNdsRub com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setNdsRub(BigDecimal newNdsRub) {
		ndsRub.setBigDecimal(newNdsRub);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 15:15:50)
	 * @param newNdsRub com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setNdsRubFrm(String newNdsRub) {
		ndsRub.setString(newNdsRub);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:36:50)
	 * @param newNumberanddatepay java.lang.String
	 */
	public void setNumberanddatepay(java.lang.String newNumberanddatepay) {
		numberanddatepay = newNumberanddatepay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:37:42)
	 * @param newNumpayplatinum java.lang.String
	 */
	public void setNumpayplatinum(java.lang.String newNumpayplatinum) {
		numpayplatinum = newNumpayplatinum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:37:42)
	 * @param newNumpayplatinum java.lang.String
	 */
	public void setNumpayplatinumDis(java.lang.String newNumpayplatinum) {
		numpayplatinum = newNumpayplatinum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.04.2004 12:02:13)
	 * @param newOfficememonumber java.lang.String
	 */
	public void setOfficememonumber(java.lang.String newOfficememonumber) {
		officememonumber = newOfficememonumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:40:11)
	 * @param newOrgAcc com.hps.july.persistence.AccountAccessBean
	 */
	public void setOrgAcc(com.hps.july.persistence.AccountAccessBean newOrgAcc) throws Exception {
		try {
			if (newOrgAcc == null) {
				orgAcccode.setInteger(null);
				orgAccname = "";
			} else {
				orgAcccode.setInteger(new Integer(newOrgAcc.getAccount()));
				orgAccname = newOrgAcc.getAccountvalue();
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			orgAcccode.setString("");
			orgAccname = "";
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:41:14)
	 * @param newOrgAcccode com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setOrgAcccode(Integer newOrgAcccode) {
		orgAcccode.setInteger(newOrgAcccode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:41:14)
	 * @param newOrgAcccode com.hps.july.web.util.StringAndIntegerProperty
	 */
	public void setOrgAcccodeFrm(String newOrgAcccode) {
		orgAcccode.setString(newOrgAcccode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:44:07)
	 * @param newOrgAccname java.lang.String
	 */
	public void setOrgAccname(java.lang.String newOrgAccname) {
		orgAccname = newOrgAccname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 12:33:54)
	 * @param newOrgCustomer java.lang.String
	 */
	public void setOrgCustomerContract(java.lang.String newOrgCustomerContract) {
		orgCustomerContract = newOrgCustomerContract;
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
	 * Creation date: (08.07.2002 12:33:54)
	 * @param newOrgExecutor java.lang.String
	 */
	public void setOrgExecutorContract(java.lang.String newOrgExecutorContract) {
		orgExecutorContract = newOrgExecutorContract;
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
	 * Creation date: (01.04.2003 15:54:45)
	 * @param newOtvuser java.lang.Integer
	 */
	public void setOtvuser(java.lang.Integer newOtvuser) {
		otvuser = newOtvuser;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 16:21:38)
	 * @param newOtvuserFrm java.lang.String
	 */
	public void setOtvuserFrm(java.lang.String newOtvuserFrm) {
		otvuserFrm = newOtvuserFrm;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:58:55)
	 * @param newPaymentsState java.lang.String
	 */
	public void setPaymentstate(java.lang.String newPaymentsState) {
		paymentstate = newPaymentsState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:37:33)
	 * @param newPaymentType java.lang.String
	 */
	public void setPaymentType(java.lang.String newPaymentType) {
		paymentType = newPaymentType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:56:37)
	 * @param newPayPurpose java.lang.String
	 */
	public void setPayPurpose(java.lang.String newPayPurpose) {
		if (newPayPurpose != null) {
			payPurpose = newPayPurpose.trim();
		} else {
			payPurpose = newPayPurpose;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 15:10:06)
	 * @param newPayrate com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setPayrate(BigDecimal newPayrate) {
		payrate.setBigDecimal(newPayrate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 15:10:06)
	 * @param newPayrate com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setPayrateFrm(String newPayrate) {
		payrate.setString(newPayrate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:52:57)
	 * @param newPaystateplatinum java.lang.Integer
	 */
	public void setPaystateplatinum(java.lang.Integer newPaystateplatinum) {
		paystateplatinum = newPaystateplatinum;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.04.2003 16:41:43)
	 * @param newPaystateplatinumFrm java.lang.String
	 */
	public void setPaystateplatinumFrm(java.lang.String newPaystateplatinumFrm) {
		paystateplatinumFrm = newPaystateplatinumFrm;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 12:50:04)
	 * @param newPercentavans com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setPercentavans(BigDecimal newPercentavans) {
		percentavans.setBigDecimal(newPercentavans);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.04.2003 12:50:04)
	 * @param newPercentavans com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setPercentavansFrm(String newPercentavans) {
		percentavans.setString(newPercentavans);
	}
	/**
	 * 
	 * @param newPositionName java.lang.String
	 */
	public void setPositionName(java.lang.String newPositionName) {
		positionName = newPositionName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:57:33)
	 * @param newPpType java.lang.String
	 */
	public void setPpType(java.lang.String newPpType) {
		ppType = newPpType;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:40:52)
	 * @param newPurposepay java.lang.String
	 */
	public void setPurposepay(java.lang.String newPurposepay) {
		purposepay = newPurposepay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:40:52)
	 * @param newPurposepay java.lang.String
	 */
	public void setPurposepayDis(java.lang.String newPurposepay) {
		purposepay = newPurposepay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 11:45:34)
	 * @param newRatecalcrule java.lang.String
	 */
	public void setRatecalcrule(java.lang.String newRatecalcrule) {
		ratecalcrule = newRatecalcrule;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 11:48:22)
	 * @param newRatecalcruleday java.lang.Integer
	 */
	public void setRatecalcruleday(java.lang.Integer newRatecalcruleday) {
		ratecalcruleday = newRatecalcruleday;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.01.2003 17:59:15)
	 * @param newRatedate java.sql.Date
	 */
	public void setRatedate(java.sql.Date newRatedate) {
		ratedate.setSqlDate(newRatedate);
	}
	public void setRatedatecalc(java.sql.Date newRatedate) {
		ratedatecalc.setSqlDate(newRatedate);
	}
	public void setRatedatecalcFrm(String newRatedate) {
		ratedatecalc.setString(newRatedate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.01.2003 17:59:15)
	 * @param newRatedate java.sql.Date
	 */
	public void setRatedateFrm(String newRatedate) {
		ratedate.setString(newRatedate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 11:47:51)
	 * @param newRatedelta java.math.BigDecimal
	 */
	public void setRatedelta(java.math.BigDecimal newRatedelta) {
		ratedelta = newRatedelta;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 11:54:08)
	 * @param newResource com.hps.july.persistence.ResourceAccessBean
	 */
	public void setResource(com.hps.july.persistence.ResourceAccessBean newResource) throws Exception {
		try {
			if (newResource == null) {
				resourcecode = 0;
			} else {
				resourcecode = newResource.getResource();
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			resourcecode = 0;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (17.12.2002 12:51:11)
	 * @param newResourcecode int
	 */
	public void setResourcecode(int newResourcecode) {
		resourcecode = newResourcecode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.03.2003 14:50:41)
	 * @param newRur int
	*/	 
	public void setRur(int newRur) {
		rur = newRur;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:33:00)
	 * @param newSf java.lang.Boolean
	 */
	public void setSf(java.lang.Boolean newSf) {
		sf = newSf;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:22:20)
	 * @param newSource java.lang.String
	 */
	public void setSource(java.lang.String newSource) {
		source = newSource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 17:01:33)
	 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setStartDate(Date newStartDate) {
		startDate.setSqlDate(newStartDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 17:01:33)
	 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
	 */
	public void setStartDateFrm(String newStartDate) {
		startDate.setString(newStartDate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 14:28:15)
	 * @param newStateOfContract java.lang.String
	 */
	public void setStateOfContract(java.lang.String newStateOfContract) {
		stateOfContract = newStateOfContract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 13:34:24)
	 * @param newSum java.math.BigDecimal
	 */
	public void setSumm(BigDecimal newSum) {
		summ.setBigDecimal(newSum);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 13:34:24)
	 * @param newSum java.math.BigDecimal
	 */
	public void setSummFrm(String newSum) {
		summ.setString(newSum);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:43:41)
	 * @param newNdSum com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setSumnds(BigDecimal newNds) {
		sumnds.setBigDecimal(newNds);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.07.2002 12:43:41)
	 * @param newNdSum com.hps.july.web.util.StringAndBigDecimalProperty
	 */
	public void setSumndsFrm(String newNds) {
		sumnds.setString(newNds);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:36:16)
	 * @param newSumRub java.math.BigDecimal
	 */
	public void setSumRub(java.math.BigDecimal newSumRub) {
		sumRub.setBigDecimal(newSumRub);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.07.2002 10:36:16)
	 * @param newSumRub java.math.BigDecimal
	 */
	public void setSumRubFrm(String newSumRub) {
		sumRub.setString(newSumRub);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.02.2003 15:20:20)
	 * @param newSYNCNRIPLATINARENDA java.lang.String
	 */
	public void setSYNCNRIPLATINARENDA(java.lang.String newSYNCNRIPLATINARENDA) {
		SYNCNRIPLATINARENDA = newSYNCNRIPLATINARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.03.2003 17:32:02)
	 * @param newTovcheck java.lang.Boolean
	 */
	public void setTovcheck(java.lang.Boolean newTovcheck) {
		tovcheck = newTovcheck;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:41:31)
	 * @param newTypebasedoc java.lang.String
	 */
	public void setTypebasedoc(java.lang.Integer newTypebasedoc) {
		typebasedoc = newTypebasedoc;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:53:45)
	 * @param newTypeinstr java.lang.Integer
	 */
	public void setTypeinstr(java.lang.Integer newTypeinstr) {
		typeinstr = newTypeinstr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (31.01.2003 15:57:05)
	 * @param newTyperashod java.lang.Integer
	 */
	public void setTyperashod(java.lang.Integer newTyperashod) {
		typerashod = newTyperashod;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.11.2003 16:14:07)
	 * @param newUsedinactcode java.lang.Integer
	 */
	public void setUsedinact(java.lang.Integer newUsedinactcode) {
		setUsedinactcode(newUsedinactcode);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.11.2003 16:14:07)
	 * @param newUsedinactcode java.lang.Integer
	 */
	public void setUsedinactcode(java.lang.Integer newUsedinactcode) {
		usedinactcode = newUsedinactcode;
	}
	public void validateValues(ActionErrors errors) throws Exception {
		setIsSchetFakt("N");
		setIsSchetFaktFrm(false);

		processCalcOptions(errors);

		validateValuesSuper(errors);

		if (orgAcccode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.orgaccount"));
		} else if (!orgAcccode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.orgaccount"));
		} else {
			try {
				constructOrgAcc();
			} catch (Exception e) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.orgaccount"));
				}
			}
		}

		if (getPayPurpose().equals("") || getPayPurpose() == null) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.paypurpose"));
		} else {
			// Check payPurpose length
			int maxpl = 80;
			try {
				NamedValueAccessBean nvb = new NamedValueAccessBean();
				nvb.setInitKey_id("PURPOSELENGTH");
				nvb.refreshCopyHelper();
				maxpl = nvb.getIntvalue();
			} catch (Exception e) {
			}
			if (getPayPurpose().length() > maxpl) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.paypurpose", new Integer(maxpl)));
			}
		}

		//platinum checks if needed
		if (getSYNCNRIPLATINARENDA() != null && !getSYNCNRIPLATINARENDA().equals("") && getState() == APPStates.PAYMENT_EDIT && getEditState() == 1) {
			if (getTyperashod() == null || getTyperashod().intValue() == 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.typerashod"));
			}

			if (getIdbudjet() == null || getIdbudjet().intValue() == 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.idbudjet"));
			}

			if (getIditem() == null || getIditem().intValue() == 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.iditem"));
			}

			if (getTypebasedoc() == null || getTypebasedoc().intValue() == 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.typebasedoc"));
			}

			if (getNumberanddatepay() == null || getNumberanddatepay().equals("")) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.nbrdateosnovanie"));
			}

			if (getTypeinstr() == null || getTypeinstr().intValue() == 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.typeinstr"));
			} else if (getTypeinstr().intValue() == getArendaTypeInstrOpl()) {
				if (percentavans.isEmpty()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.percentavans"));
				} else if (!percentavans.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinum.percentavans"));
				}
			}

			if (datebuch.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.datebuch"));
			}

			if (datebeforepay.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.datebeforepay"));
			}

			if (isCheckDefinerate()) {
				if (getDefinerate() == null || getDefinerate().intValue() == 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.kurserule"));
				}
			} else {
				setDefinerate(null);
			}

			// устанавливаем автоматически
			/*if (getIdpaymode() == null || getIdpaymode().intValue() == 0) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.platinum.idpaymode"));
			}*/

			// Проверяем налоговые поля

			if ((getFl101() != null) && (getFl101().length() > 0)) {
				if (getFl101().length() > 2) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinum.fl101"));
				}
			}
			if ((getFl104() != null) && (getFl104().length() > 0)) {
				if (getFl104().length() > 7) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinum.fl104"));
				}
			}
			if ((getFl105() != null) && (getFl105().length() > 0)) {
				if (getFl105().length() > 11) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinum.fl105"));
				}
			}
			if ((getFl106() != null) && (getFl106().length() > 0)) {
				if (getFl106().length() > 2) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinum.fl106"));
				}
			}
			if ((getFl107() != null) && (getFl107().length() > 0)) {
				if (getFl107().length() > 10) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinum.fl107"));
				}
			}
			if ((getFl108() != null) && (getFl108().length() > 0)) {
				if (getFl108().length() > 16) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinum.fl108"));
				}
			}
			if ((getFl109() != null) && (getFl109().length() > 0)) {
				if (getFl109().length() > 10) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinum.fl109"));
				}
			}
			if ((getFl110() != null) && (getFl110().length() > 0)) {
				if (getFl110().length() > 2) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.platinum.fl110"));
				}
			}
		}

		if (ppType != null && !"".equals(ppType)) {
			if ("C".equals(ppType)) {
				ppType = "B";
			}
			if ("off".equals(ppType) || "false".equals(ppType)) {
				ppType = "B";
			}
		} else {
			ppType = "B";
		}

		if (ppType != null && !"A".equals(ppType) && !"B".equals(ppType)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payments.pptype"));
		}
		//проверяем, выбрана ли валюта
		if (getCurrencycode().intValue() == 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payments.currencycode"));
		}

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	public void validateValuesSuper(ActionErrors errors) throws Exception {
		if (!((getState() == APPStates.PAYMENT_EDIT || getState() == APPStates.HISTORY_PAYMENT_EDIT) && new ArendaPlatinumProcessorAccessBean().isProcessingEnabled())) {
			if (date.isEmpty()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.date"));
			} else if (!date.isOk()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.date"));
			}
		}

		boolean isBegindate = false;
		boolean isEnddate = false;

		if (begindate.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.begindate"));
		} else if (!begindate.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.begindate"));
		} else {
			isBegindate = true;
		}

		if (enddate.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.enddate"));
		} else if (!enddate.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.enddate"));
		} else {
			isEnddate = true;
		}

		if (isBegindate && isEnddate && getBegindate().compareTo(getEnddate()) > 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.period"));
		}

		if (resourcecode == 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.resource"));
		} else {
			try {
				constructResource();
			} catch (Exception e) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.resource"));
				}
			}
		}

		boolean isPayrate = false;
		boolean isSumrub = false;

		if (summ.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.sum"));
		} else if (!summ.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.sum"));
		}

		if (sumnds.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payment.ndsum"));
		} else if (!sumnds.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.ndsum"));
		}

		if (!payrate.isEmpty()) {
			if (payrate.isOk()) {
				isPayrate = true;
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.payrate"));
			}
		}

		if (!sumRub.isEmpty()) {
			if (sumRub.isOk()) {
				isSumrub = true;
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.sumrub"));
			}
		}
		/**
		if (isPayrate && isSumrub && (sumRub.getBigDecimal().compareTo(payrate.getBigDecimal().multiply(summ.getBigDecimal()).setScale(2, BigDecimal.ROUND_HALF_UP)) != 0)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.calcsum"));
		}
		*/
		if (!ndsRub.isEmpty() && !ndsRub.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.ndsrub"));
		}
		//
		if (PaymentForm.isInAct(getLeaseDocPosition())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.applied"));
		}
		/*
		if (!isSYNCNRIPLATINARENDA() && !date.isEmpty() && date.isOk() && !checkOpenPeriod()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
				"error.payment.notopenperiod2", formatSalDate()));
		}
		*/

		if (!((getSource().equals("M") || getSource().equals("A")) && getDocposvid().equals("N"))) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payment.source"));
		}

		if (!getAction().equals("Add") && !checkLink2Pay()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payment.haspay"));
		}

		if (getState() == com.hps.july.arenda.APPStates.US_PAYMENT_EDIT && getState() == com.hps.july.arenda.APPStates.CHANNEL_PAYMENT_EDIT && !errors.empty()) {
			throw new ValidationException();
		}
	}
	/**
	 * @return
	 */
	public String getRurName() {
		return rurName;
	}

	/**
	 * @param currency_VO
	 */
	public void setRurName(String aRurName) {
		rurName = aRurName;
	}

	/**
	 * @return
	 */
	public Boolean getFlagOplNds() {
		return flagOplNds;
	}

	/**
	 * @param boolean1
	 */
	public void setFlagOplNds(Boolean boolean1) {
		flagOplNds = boolean1;
	}

}
