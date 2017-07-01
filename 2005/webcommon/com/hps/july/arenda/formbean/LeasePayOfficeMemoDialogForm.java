/*
 * Created on 15.01.2006
 *
 * "Служебные записки на оплату" EditForm Object
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.arenda.cdbcobjects.CDBC_Helper;
import com.hps.july.arenda.cdbcobjects.CDBC_LeasePayOfficeMemo_Object;
import com.hps.july.arenda.valueobject.CurrencyVO;
import com.hps.july.arenda.valueobject.NFS_ZP_VO;
import com.hps.july.arenda.valueobject.PeopleVO;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBC_Accounts_Object;
import com.hps.july.cdbc.objects.CDBC_Banks_Object;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.cdbc.objects.CDBC_NFS_Object;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.hps.july.cdbc.objects.CDBC_Vendor_Object;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import com.hps.july.logic.DocumentLogic;
import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.persistence.LeasePayRuleAccessBean;
import com.hps.july.persistence.OrganizationNfsAccessBean;
import com.hps.july.persistence.PositionAccessBean;
import com.hps.july.persistence.RateAccessBean;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.valueobject.Accounts_TO;
import com.hps.july.valueobject.Accounts_VO;
import com.hps.july.valueobject.Banks_VO;
import com.hps.july.valueobject.LeasePayOfficeMemo_TO;
import com.hps.july.valueobject.LeasePayOfficeMemo_VO;
import com.hps.july.valueobject.VendorSite_VO;
import com.hps.july.valueobject.Vendor_VO;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.StringAndBigDecimalProperty;
import com.hps.july.web.util.ValidationException;
import java.math.BigDecimal;

/**
 * @author IShaffigulin
 *
 * "Служебные записки на оплату" EditForm Object
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeasePayOfficeMemoDialogForm extends EditForm {
	private int id;
	private boolean flagOperation;
	private LeasePayOfficeMemo_TO to;
	private int idContract;
	private java.util.List currencies;
	private java.lang.String operation = "";
	private PeopleVO operatorVO;
	private Vendor_VO vendor_VO;
	private VendorSite_VO vendorSite_VO;
	private Accounts_TO orgAcc;
	//дефолтная ставка НДС:
	private StringAndBigDecimalProperty calcNdsRate;
	//операция копирования:
	public final static String COPY = "copy";
	//операция выбор правила оплаты:
	public final static String LEASE_RULE = "leaseRule";
	//операция опредедения курса из условий ruleRate:
	public final static String CALC_RATE = "calcRate";
	//операция выбора ЗП из справочника:
	public final static String CHANGE_DATA_ZP = "changeData";
	private int leaseRule;
	//информация о ЗП:
	private NFS_ZP_VO dataZP;

	/**
	 * @author IShaffigulin
	 *
	 * Информация о договоре
	 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
	 */
	public class ContractInfo {
		private String docNumber;
		private Date docDate;
		private String orgExecutorName;
		private String orgExecutorInn;
		private String positionName;
		private Integer positionGsm;
		private String mainResource;
		private Integer codeActiveDocument;

		/**
		 * @return
		 */
		public Date getDocDate() {
			return docDate;
		}

		/**
		 * @return
		 */
		public String getDocNumber() {
			return docNumber;
		}

		/**
		 * @param date
		 */
		private void setDocDate(Date date) {
			docDate = date;
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
		public String getOrgExecutorInn() {
			return orgExecutorInn;
		}

		/**
		 * @return
		 */
		public String getOrgExecutorName() {
			return orgExecutorName;
		}

		private void setOrgExecutor(OrganizationNfsAccessBean orgExecutor) throws Exception {
			setOrgExecutorName(orgExecutor.getName());
			setOrgExecutorInn(orgExecutor.getInn());
		}

		/**
		 * @param string
		 */
		private void setOrgExecutorInn(String string) {
			orgExecutorInn = string;
		}

		/**
		 * @param string
		 */
		private void setOrgExecutorName(String string) {
			orgExecutorName = string;
		}
		/**
		 * главная позиция
		 * Creation date: (02.04.2004 17:42:53)
		 */
		private void setMainPosition(PositionAccessBean mainPos) throws Exception {
			if (mainPos != null) {
				setPositionName(com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(mainPos));
				setPositionGsm(mainPos.getGsmid());
			} else {
				setPositionGsm(null);
				setPositionName(null);
			}
		}
		/**
		 * @return
		 */
		public String getPositionName() {
			return positionName;
		}

		/**
		 * @param string
		 */
		private void setPositionName(String string) {
			positionName = string;
		}

		/**
		 * @return
		 */
		public Integer getPositionGsm() {
			return positionGsm;
		}

		/**
		 * @param integer
		 */
		private void setPositionGsm(Integer integer) {
			positionGsm = integer;
		}

		/**
		 * @return
		 */
		public String getMainResource() {
			return mainResource;
		}

		/**
		 * @param string
		 */
		private void setMainResource(String string) {
			mainResource = string;
		}

		/**
		 * @return
		 */
		public Integer getCodeActiveDocument() {
			return codeActiveDocument;
		}

		/**
		 * @param integer
		 */
		public void setCodeActiveDocument(Integer integer) {
			codeActiveDocument = integer;
		}

	}

	private ContractInfo contractInfo;
	/**
	 * Информация о договоре
	 */
	private ContractInfo initContractInfo(int idContract) {
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(idContract);
			bean.refreshCopyHelper();
			LeaseArendaAgreementNewAccessBean beanMain = null;
			if (bean.getMainDocument() != null) {
				beanMain = new LeaseArendaAgreementNewAccessBean();
				beanMain.setInitKey_leaseDocument(bean.getMainDocument().intValue());
				beanMain.refreshCopyHelper();
			} else {
				beanMain = bean;
			}
			//заполняем ContractInfo
			ContractInfo info = new ContractInfo();
			info.setDocNumber(beanMain.getDocumentNumber());
			info.setDocDate(beanMain.getDocumentDate());
			info.setOrgExecutor(beanMain.getOrgExecutor());
			info.setMainPosition(beanMain.getMainposition());
			info.setCodeActiveDocument(beanMain.getActivecontract());
			Integer mainResource = beanMain.getMainresource();
			if (mainResource != null) {
				ResourceAccessBean resourceAB = new ResourceAccessBean();
				resourceAB.setInitKey_resource(mainResource.intValue());
				info.setMainResource(resourceAB.getName());
			}

			return info;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка initContract для getIdContract =" + idContract);
			return null;
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:01:54)
	 */
	public LeasePayOfficeMemoDialogForm() {
		setCurrencies(CDBC_MapFactory.getListCurrencies());
		// For NDS calculation in form:
		calcNdsRate = new StringAndBigDecimalProperty();
		java.math.BigDecimal aval = com.hps.july.util.AppUtils.getNamedValueBigDecimal(com.hps.july.util.AppUtils.DEFAULT_RATE_NDS);
		setCalcNdsRate(aval.toString());
		System.out.println("LeasePayOfficeMemoDialogForm: NDS Rate:" + aval);
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
		return com.hps.july.arenda.APPStates.LEASE_PAY_OFFICE_MEMO_DIALOG;
	}

	/**
	 * @return
	 */
	public boolean isFlagOperation() {
		return flagOperation;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public int getIdContract() {
		return idContract;
	}

	/**
	 * @param b
	 */
	public void setFlagOperation(boolean b) {
		flagOperation = b;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * @param i
	 */
	public void setIdContract(int i) {
		idContract = i;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		setFlagOperation(false);
		if (operatorVO == null)
			operatorVO = CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser());
	}
	/**
	 * 
	 * @return String
	public String getContractInfo() {
		return CDBC_Helper.getContractInfo(getIdContract());
	}
	 */
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#loadRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void loadRecord(HttpServletRequest request) throws Exception {
		to = CDBC_LeasePayOfficeMemo_Object.find(getId());
		setIdContract(getTo().getVo().getLeaseContract().intValue());
		//счет:
		Accounts_VO accountVO = CDBC_Accounts_Object.find(getTo().getVo().getOrgAcc());
		Banks_VO bankVO = CDBC_Banks_Object.find(accountVO.getBank());
		Accounts_TO accTO = new Accounts_TO(accountVO);
		accTO.setBank_VO(bankVO);
		setOrgAcc(accTO);
		//получатель:
		setVendorSite_VO(CDBC_VendorSite_Object.find(accountVO.getIdVendorSite()));
		setVendor_VO(CDBC_Vendor_Object.find(getVendorSite_VO().getIdVendor()));
		//инфо о договоре:
		setContractInfo(initContractInfo(getTo().getVo().getLeaseContract().intValue()));
		//ЗП:
		if (getTo().getVo().getIdZpNfs() != null) {
			setDataZP(initDataZP(getTo().getVo().getIdZpNfs()));
		} else {
			setDataZP(null);
		}
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void initRecord(HttpServletRequest request) throws Exception {
		int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leaseOfficeMemo");
		if (COPY.equals(getOperation())) {
			copyFromID(request, key);
		} else {
			init(key);
		}
	}
	private void copyFromID(HttpServletRequest request, int key) throws Exception {
		loadRecord(request);
		CDBC_Helper.initDomainObject(getTo().getVo(), getOperatorVO());
		setId(key);
		getTo().getVo().setIdOfficeMemo(new Integer(key));
		getTo().getVo().setState("1");
		setOperation("");
	}
	private void init(int key) throws Exception {
		setId(key);
		to = new LeasePayOfficeMemo_TO(new LeasePayOfficeMemo_VO(new Integer(key)));
		to.getVo().setState("1"); //редактируется
		to.getVo().setLeaseContract(new Integer(getIdContract()));
		to.setRateNdsStr(getCalcNdsRate());
		CDBC_Helper.initDomainObject(getTo().getVo(), getOperatorVO());

		Integer nullKey = new Integer(-1);
		//инит получатель:
		setVendorSite_VO(new VendorSite_VO(nullKey));
		setVendor_VO(new Vendor_VO(nullKey));
		//инит счет:
		Accounts_TO accounts_TO = new Accounts_TO(new Accounts_VO(nullKey));
		accounts_TO.setBank_VO(new Banks_VO(nullKey));
		setOrgAcc(accounts_TO);
		//инфо о договоре:
		setContractInfo(initContractInfo(getIdContract()));
		//из активного(ratecalcrule, ratecalcruleday, ratedelta) :
		fillDataFromActiveDoc();
		setDataZP(null);
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции : LeasePayOfficeMemo_VO:id" + getTo().getVo().getIdOfficeMemo();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			setFlagOperation(false);
		} else {
			setFlagOperation(true);
		}
		return "success";
	}
	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeasePayOfficeMemo_Object.delete(getTo().getVo());
		return process(flag, errors);
	}

	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeasePayOfficeMemo_Object.add(getTo().getVo());
		return process(flag, errors);
	}

	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		CDBC_Helper.updateDomainObject(getTo().getVo(), getOperatorVO());
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeasePayOfficeMemo_Object.edit(getTo().getVo());
		return process(flag, errors);
	}

	/**
	 * @return
	 */
	public java.util.List getCurrencies() {
		return currencies;
	}

	/**
	 * @param list
	 */
	private void setCurrencies(java.util.List list) {
		currencies = list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 16:42:13)
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}
	/**
	 * @return
	 */
	public java.lang.String getOperation() {
		return operation;
	}

	/**
	 * @param string
	 */
	public void setOperation(java.lang.String string) {
		operation = string;
	}

	/**
	 * @return
	 */
	private PeopleVO getOperatorVO() {
		return operatorVO;
	}

	/**
	 * @param peopleVO
	 */
	private void setOperatorVO(PeopleVO peopleVO) {
		operatorVO = peopleVO;
	}

	/**
	 * @return
	 */
	public LeasePayOfficeMemo_TO getTo() {
		return to;
	}

	/**
	 * @param memo_TO
	 */
	public void setTo(LeasePayOfficeMemo_TO memo_TO) {
		to = memo_TO;
	}

	/**
	 * @return
	 */
	public Vendor_VO getVendor_VO() {
		return vendor_VO;
	}

	/**
	 * @return
	 */
	public VendorSite_VO getVendorSite_VO() {
		return vendorSite_VO;
	}

	/**
	 * @param vendor_VO
	 */
	public void setVendor_VO(Vendor_VO vendor_VO) {
		this.vendor_VO = vendor_VO;
	}

	/**
	 * @param site_VO
	 */
	public void setVendorSite_VO(VendorSite_VO site_VO) {
		vendorSite_VO = site_VO;
	}

	/**
	 * @return
	 */
	public Accounts_TO getOrgAcc() {
		return orgAcc;
	}

	/**
	 * @param accounts_TO
	 */
	public void setOrgAcc(Accounts_TO accounts_TO) {
		orgAcc = accounts_TO;
	}
	/**
	 * 
	 * @return String
	 */
	private String getCalcNdsRate() {
		return calcNdsRate.getString();
	}
	/**
	 * @param newNdsRate String
	 */
	private void setCalcNdsRate(String newNdsRateStr) {
		calcNdsRate.setString(newNdsRateStr);
	}
	/**
	 * @param info
	 */
	public void setContractInfo(ContractInfo info) {
		contractInfo = info;
	}

	/**
	 * @return
	 */
	public ContractInfo getContractInfo() {
		return contractInfo;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		//определение курса:
		processCalcOptions(errors);

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	/**
	 * 
	 * @param errors
	 */
	private void processCalcOptions(ActionErrors errors) throws ValidationException {
		if (CALC_RATE.equals(getOperation())) {
			//опредедения курса из условий ruleRate:
			if (getTo().getVo().getRuleRate().equals(LeasePayOfficeMemo_VO.ruleRate_onDate)) {
				rateFromDate(errors);
			} else if (getTo().getVo().getRuleRate().equals(LeasePayOfficeMemo_VO.ruleRate_onDogovor)) {
				rateFromDogovor(errors);
			}
		} else if (LEASE_RULE.equals(getOperation())) {
			//данные из правил оплаты:
			changeLeasePayRule(errors);
		} else if (CHANGE_DATA_ZP.equals(getOperation())) {
			//данные из ЗП:
			if (getTo().getVo().getIdZpNfs() != null)
				changeDataZP(errors);
		}

	}
	/**
	 * 
	 * @param errors
	 */
	private void changeLeasePayRule(ActionErrors errors) throws ValidationException {
		//изменено правило оплаты:
		try {
			LeasePayRuleAccessBean leaseRuleAB = initLeasePayRuleAB(getLeaseRule());
			if (leaseRuleAB.getPayType().equals("M")) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "нельзя выбрать для типа оплаты - взаимозачет"));
			} else {
				//валюта:
				getTo().getVo().setCurrency(new Integer(leaseRuleAB.getCurrency().getCurrency()));
				//назначение платежа:
				getTo().getVo().setPurpose(leaseRuleAB.getPayPurpose());
				//счет:
				int keyOrgAcc = leaseRuleAB.getOrgAcc().getAccount();
				getTo().getVo().setOrgAcc(new Integer(keyOrgAcc));
				Accounts_VO accountVO = CDBC_Accounts_Object.find(getTo().getVo().getOrgAcc());
				Banks_VO bankVO = CDBC_Banks_Object.find(accountVO.getBank());
				Accounts_TO accTO = new Accounts_TO(accountVO);
				accTO.setBank_VO(bankVO);
				setOrgAcc(accTO);
				//получатель:
				setVendorSite_VO(CDBC_VendorSite_Object.find(accountVO.getIdVendorSite()));
				setVendor_VO(CDBC_Vendor_Object.find(getVendorSite_VO().getIdVendor()));
				//сумма:
				BigDecimal sum = leaseRuleAB.getSum();
				String payPeriod = leaseRuleAB.getPayPeriod();
				if ("Q".equals(payPeriod)) {
					sum = sum.divide(new BigDecimal(4), 2);
				} else if ("M".equals(payPeriod)) {
					sum = sum.divide(new BigDecimal(12), 2);
				}
				getTo().getVo().setSum(sum);
				//ндс:
				BigDecimal rateNds = getTo().getVo().getRateNds();
				BigDecimal nds = null;
				if (rateNds != null) {
					nds = sum.multiply(rateNds).divide(rateNds.add(new BigDecimal(100)), 2);
					//nds = nds.scale(2);
				}
				getTo().getVo().setNds(nds);
			}
		} catch (Exception e) {
			System.out.println("Ошибка changeLeasePayRule for getLeaseRule=" + getLeaseRule());
			e.printStackTrace(System.out);
		}
		setOperation("");
		throw new ValidationException();
	}
	/**
	 * 
	 * @param errors
	 */
	private LeasePayRuleAccessBean initLeasePayRuleAB(int idLeaseRule) {
		LeasePayRuleAccessBean leasePayRuleAB = null;
		try {
			leasePayRuleAB = new LeasePayRuleAccessBean();
			leasePayRuleAB.setInitKey_leaseRule(idLeaseRule);
			leasePayRuleAB.refreshCopyHelper();

			//setData("№ " + leaseRuleAB.getDocumentNumber() + " ,от " + format.format(leaseRuleAB.getDocumentDate()) + " ,c " + format.format(leaseRuleAB.getStartDate())+ " по " + format.format(leaseRuleAB.getEndDate()) + " сумма: " + LeasePayRuleAccessBean.getSumm1() + " " + LeasePayRuleAccessBean.getCurrency1().getShortname());
		} catch (Exception e) {
			System.out.println("Ошибка initLeasePayRuleAB for idLeaseRule=" + idLeaseRule);
			e.printStackTrace(System.out);
			//setData("");
		}
		return leasePayRuleAB;
	}
	/**
	 * 
	 * @param errors
	 */
	private void rateFromDate(ActionErrors errors) throws ValidationException {
		//опр. курс на дату:
		System.out.println("определяем Курс на дату:" + getTo().getRateDateStr());
		try {
			int rateType = com.hps.july.util.AppUtils.getNamedValueInt("BASE_RATETYPE_ARENDA");
			System.out.println("RATEDATECALC rateType:" + rateType);
			RateAccessBean ratefind = new RateAccessBean();
			RateAccessBean rate = ratefind.findByTypeCurrencyForDate(new Integer(rateType), getTo().getVo().getCurrency(), getTo().getVo().getRateDate());
			getTo().getVo().setRateValue(rate.getValue());
		} catch (Exception e) {
			System.out.println("Ошибка определения Курса на дату:" + getTo().getRateDateStr());
			e.printStackTrace(System.out);
		}
		setOperation("");
		throw new ValidationException();

	}
	/**
	 * 
	 * @param errors
	 */
	private void rateFromDogovor(ActionErrors errors) throws ValidationException {
		//опр. курс по договору:
		System.out.println("определяем курс по договору IdContract=" + getIdContract());
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "execute procedure DefRateForOplOnContr(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			con = new JdbcConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, getTo().getVo().getCurrency().intValue()); //валюта
			ps.setDate(2, null); //дата платежа
			ps.setDate(3, getTo().getVo().getBillDate()); //дата счета
			ps.setDate(4, getTo().getVo().getBeginDate()); //дата начала периода
			ps.setDate(5, getTo().getVo().getEndDate()); //дата окончания периода
			ps.setString(6, getTo().getVo().getRateCalcRule()); //правило опр. курса
			if (getTo().getVo().getRateCalcRuleDay() != null) {
				ps.setInt(7, getTo().getVo().getRateCalcRuleDay().intValue()); //день				
			} else {
				ps.setInt(7, 0); //день
			}
			ps.setBigDecimal(8, getTo().getVo().getRateDelta()); //наценка
			ps.setInt(9, 0); //код журнала (если нет, то ноль)
			rs = ps.executeQuery();
			if (rs.next()) {
				BigDecimal payRate = rs.getBigDecimal(1);
				Date payDate = rs.getDate(2);
				int result = rs.getInt(3);
				String errorTxt = rs.getString(4);
				if (result == 0) {
					getTo().getVo().setRateValue(payRate);
					getTo().getVo().setRateDate(payDate);
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
				}
			} else {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report.rate"));
			}
		} catch (Exception ex) {
			System.out.println("Error in execute procedure DefRateForOplOnContr()");
			if (ex instanceof SQLException) {
				System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Error code=" + ((SQLException) ex).getErrorCode()));
			}
			ex.printStackTrace();
		} finally {
			finallyMetod(con, ps, rs);
		}
		setOperation("");
		throw new ValidationException();
	}
	/**
	 * 
	 * @param con
	 * @param ps
	 * @param rs
	 */
	private void finallyMetod(Connection con, PreparedStatement ps, ResultSet rs) {
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
	/**
	 * 
	 * @throws Exception
	 */
	private void fillDataFromActiveDoc() throws Exception {
		LeaseArendaAgreementNewAccessBean activDoc = DocumentLogic.getActiveDocument(getIdContract());
		getTo().getVo().setRateCalcRule(activDoc.getRatecalcrule());
		if (activDoc.getRatecalcruleday() != null) {
			getTo().getVo().setRateCalcRuleDay(new Integer(activDoc.getRatecalcruleday().intValue()));
		}
		getTo().getVo().setRateDelta(activDoc.getRatedelta());
	}
	/**
	 * @return
	 */
	public int getLeaseRule() {
		return leaseRule;
	}

	/**
	 * @param i
	 */
	public void setLeaseRule(int i) {
		leaseRule = i;
	}
	/**
	 * 
	 * @param errors
	 */
	private NFS_ZP_VO initDataZP(Integer idZp) {
		CDBCRowObject ro = CDBC_NFS_Object.findZP_NFS(idZp.intValue());
		if (ro != null) {
			NFS_ZP_VO zp = new NFS_ZP_VO(ro);
			zp.initVendor(ro);
			zp.getVendor().setVendorcode((Integer)ro.getColumn("codevendor_zp").asObject());			
			zp.initSite(ro);			
			//setDataZP(vo.getNumZp());
			return zp;
		} else {
			//setDataZP("");
			return null;
		}
	}
	/**
	 * 
	 * @param errors
	 */
	private void changeDataZP(ActionErrors errors) throws ValidationException {
		//изменен ЗП:
		Integer idZpNfs = getTo().getVo().getIdZpNfs();
		if (idZpNfs != null) {
			setDataZP(initDataZP(idZpNfs));
			//getTo().getVo().setOldSumZP(zp.getSumZp().subtract(zp.getNdsZp()));
		}
		setOperation("");
		throw new ValidationException();
	}
	/**
	 * @return
	 */
	public NFS_ZP_VO getDataZP() {
		return dataZP;
	}

	/**
	 * @param string
	 */
	private void setDataZP(NFS_ZP_VO zp) {
		dataZP = zp;
	}

}
