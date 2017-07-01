/*
 * Created on 19.05.2006
 *
 * "Служебные записки на изменение ЗП в системе НФС" EditForm Object
 */
package com.hps.july.arenda.formbean;

import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.arenda.cdbcobjects.CDBC_Helper;
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseZPOfficeMemo_Object;
import com.hps.july.arenda.valueobject.NFS_ZP_VO;
import com.hps.july.arenda.valueobject.PeopleVO;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.cdbc.objects.CDBC_NFS_Object;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.hps.july.cdbc.objects.CDBC_Vendor_Object;
import com.hps.july.logic.DocumentLogic;
import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.persistence.OrganizationNfsAccessBean;
import com.hps.july.persistence.PositionAccessBean;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.valueobject.LeaseZPOfficeMemo_TO;
import com.hps.july.valueobject.LeaseZPOfficeMemo_VO;
import com.hps.july.valueobject.VendorSite_VO;
import com.hps.july.valueobject.Vendor_VO;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.StringAndBigDecimalProperty;
import com.hps.july.web.util.ValidationException;

/**
 * @author IShaffigulin
 *
 * "Служебные записки на изменение ЗП в системе НФС" EditForm Object
 */
public class LeaseZPOfficeMemoDialogForm extends EditForm {
	private int id;
	private boolean flagOperation;
	private LeaseZPOfficeMemo_TO to;
	private int idContract;
	private java.lang.String operation = "";
	private PeopleVO operatorVO;
	private Vendor_VO vendor_VO;
	private VendorSite_VO vendorSite_VO;

	private ContractInfo contractInfo;
	private String dataZP;
	private String dataDog;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	
	private java.util.List currencies = null;
	//дефолтная ставка НДС:
	private StringAndBigDecimalProperty calcNdsRate;
	
	public final static String OPERATION_NO = "";
	public final static String OPERATION_changeData = "changeData";
	public final static String OPERATION_fillSumZpOnArendaContract = "fillSumZpOnArendaContract";
		
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:01:54)
	 */
	public LeaseZPOfficeMemoDialogForm() {
		setCurrencies(CDBC_MapFactory.getListCurrencies());
		// For NDS calculation in form:
		calcNdsRate = new StringAndBigDecimalProperty();
		java.math.BigDecimal aval = com.hps.july.util.AppUtils.getNamedValueBigDecimal(com.hps.july.util.AppUtils.DEFAULT_RATE_NDS);
		setCalcNdsRate(aval.toString());
		System.out.println("LeaseZPOfficeMemoDialogForm: NDS Rate:" + aval);
	}
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
		private Integer idMainResource;

		/**
		 * 
		 */
		public ContractInfo() {
			super();
		}

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
		 * @param string
		 */
		private void setMainResource(Integer mainResource) throws Exception {
			if (mainResource != null) {
				ResourceAccessBean resourceAB = new ResourceAccessBean();
				resourceAB.setInitKey_resource(mainResource.intValue());
				setIdMainResource(mainResource);
				setMainResource(resourceAB.getName());
			}
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

		/**
		 * @return
		 */
		private Integer getIdMainResource() {
			return idMainResource;
		}

		/**
		 * @param integer
		 */
		private void setIdMainResource(Integer integer) {
			idMainResource = integer;
		}

	}
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
			info.setMainResource(beanMain.getMainresource());
			return info;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка initContract для getIdContract =" + idContract);
			return null;
		}
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
		return com.hps.july.arenda.APPStates.LEASE_ZP_OFFICE_MEMO_DIALOG;
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
	 * @return
	 */
	public LeaseZPOfficeMemo_TO getTo() {
		return to;
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

	/**
	 * @param memo_TO
	 */
	public void setTo(LeaseZPOfficeMemo_TO memo_TO) {
		to = memo_TO;
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
	 * @return
	 */
	public java.lang.String getOperation() {
		return operation;
	}

	/**
	 * @return
	 */
	private PeopleVO getOperatorVO() {
		return operatorVO;
	}

	/**
	 * @param string
	 */
	public void setOperation(java.lang.String string) {
		operation = string;
	}

	/**
	 * @param peopleVO
	 */
	private void setOperatorVO(PeopleVO peopleVO) {
		operatorVO = peopleVO;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void initRecord(HttpServletRequest request) throws Exception {
		int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leaseZPOfficeMemo");
		setId(key);
		to = new LeaseZPOfficeMemo_TO(new LeaseZPOfficeMemo_VO(new Integer(key)));
		//to.getVo().setState("1"); //редактируется
		to.getVo().setLeaseContract(new Integer(getIdContract()));
		to.setRateNds(getCalcNdsRate());
		CDBC_Helper.initDomainObject(getTo().getVo(), getOperatorVO());

		Integer nullKey = new Integer(-1);
		//инит получатель:
		setVendorSite_VO(new VendorSite_VO(nullKey));
		setVendor_VO(new Vendor_VO(nullKey));

		//инфо о договоре:
		setContractInfo(initContractInfo(getIdContract()));
		to.getVo().setIdResource(getContractInfo().getIdMainResource());
		setDataDog("");
		setDataZP("");
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#loadRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void loadRecord(HttpServletRequest request) throws Exception {
		to = CDBC_LeaseZPOfficeMemo_Object.find(getId());
		setIdContract(getTo().getVo().getLeaseContract().intValue());
		//получатель:
		if (getTo().getVo().getIdVendorSite() != null) {
			setVendorSite_VO(CDBC_VendorSite_Object.find(getTo().getVo().getIdVendorSite()));
			setVendor_VO(CDBC_Vendor_Object.find(getVendorSite_VO().getIdVendor()));
		}else{
			Integer nullKey = new Integer(-1);
			setVendorSite_VO(new VendorSite_VO(nullKey));
			setVendor_VO(new Vendor_VO(nullKey));			
		}
		//инфо о договоре:
		setContractInfo(initContractInfo(getTo().getVo().getLeaseContract().intValue()));
		//ЗП:
		if (getTo().getVo().getIdZP() != null) {
			initDataZP(getTo().getVo().getIdZP());
		}else{
			setDataZP("");
		}
		//Инфо о доп соглашении:
		if (getTo().getVo().getLeaseDopContract() != null) {
			initDataDog(getTo().getVo().getLeaseDopContract());
		}
	}

	/**
	 * @return
	 */
	public ContractInfo getContractInfo() {
		return contractInfo;
	}

	/**
	 * @param info
	 */
	private void setContractInfo(ContractInfo info) {
		contractInfo = info;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.05.2006 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции : LeaseZPOfficeMemo_VO:id" + getTo().getVo().getIdOfficeMemo();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			setFlagOperation(false);
		} else {
			setFlagOperation(true);
		}
		return "success";
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processDelete(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processDelete(HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeaseZPOfficeMemo_Object.delete(getTo().getVo());
		return process(flag, errors);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processInsert(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processInsert(HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeaseZPOfficeMemo_Object.add(getTo().getVo());
		return process(flag, errors);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processUpdate(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processUpdate(HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_Helper.updateDomainObject(getTo().getVo(), getOperatorVO());
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeaseZPOfficeMemo_Object.edit(getTo().getVo());
		return process(flag, errors);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		//определение CalcOptions:
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
		if (OPERATION_changeData.equals(getOperation())) {
			//изменен ЗП или доп.соглащение:
			if (getTo().getVo().getLeaseDopContract() != null)
				changeDataDog(errors);
			if (getTo().getVo().getIdZP() != null)
				changeDataZP(errors);
			setOperation(OPERATION_NO);
			throw new ValidationException();
		}else if(OPERATION_fillSumZpOnArendaContract.equals(getOperation())){
			fillSumZpOnArendaContract(errors);
			setOperation(OPERATION_NO);
			throw new ValidationException();			
		}
	}
	/**
	 * 
	 * @param errors
	 */
	private void changeDataDog(ActionErrors errors) {
		//изменен доп.соглащение:
		try {
			LeaseArendaAgreementNewAccessBean leaseDopContractAB = initDataDog(getTo().getVo().getLeaseDopContract());
			
			BigDecimal ndsZp = DocumentLogic.calcSumNds(leaseDopContractAB.getSumm1(), leaseDopContractAB.getRateNDS(), "Y");
			getTo().getVo().setSumNdsZP(ndsZp);
			boolean isSumNdsZpWithOutNds = leaseDopContractAB.getChargeNds();
			if(isSumNdsZpWithOutNds){
				getTo().getVo().setSumZP(leaseDopContractAB.getSumm1());				
			}else {
				getTo().getVo().setSumZP(leaseDopContractAB.getSumm1().subtract(ndsZp));
			}
			
			BigDecimal monthBD = new BigDecimal(12);
			getTo().getVo().setSumCharge(leaseDopContractAB.getSumm1().divide(monthBD, 2));
			getTo().getVo().setIdCurrCharge(new Integer(leaseDopContractAB.getCurrency1().getCurrency()));
			getTo().setCurName(leaseDopContractAB.getCurrency1().getName());
			getTo().getVo().setDateStartZP(leaseDopContractAB.getStartDate());
			getTo().getVo().setDateEndZp(leaseDopContractAB.getEndDate());
			getTo().getVo().setRateCalcRule(leaseDopContractAB.getRatecalcrule());
			Short rateCalcRuleDay = leaseDopContractAB.getRatecalcruleday();
			if(rateCalcRuleDay != null){
				getTo().getVo().setRateCalcRuleDay(new Integer(rateCalcRuleDay.toString()));				
			}
			getTo().getVo().setRateDelta(leaseDopContractAB.getRatedelta());
			//getTo().getVo().setRateFix(leaseDopContractAB.getRateFix());
			getTo().getVo().setRateNds(leaseDopContractAB.getRateNDS());
			//получатель:
			OrganizationNfsAccessBean orgExecutorAB = leaseDopContractAB.getOrgExecutor();
			if (orgExecutorAB != null) {
				int orgExecutor = orgExecutorAB.getOrganization();
				getTo().getVo().setIdVendorSite(new Integer(orgExecutor));
				setVendorSite_VO(CDBC_VendorSite_Object.find(getTo().getVo().getIdVendorSite()));
				setVendor_VO(CDBC_Vendor_Object.find(getVendorSite_VO().getIdVendor()));
			}			
		} catch (Exception e) {
			System.out.println("Ошибка changeDataDog for LeaseDopContract=" + getTo().getVo().getLeaseDopContract());
			e.printStackTrace(System.out);
		}
	}
	/**
	 * 
	 * @param errors
	 */
	private LeaseArendaAgreementNewAccessBean initDataDog(Integer idLeaseDopContract) {
		LeaseArendaAgreementNewAccessBean leaseDopContractAB = null;
		try {
			leaseDopContractAB = new LeaseArendaAgreementNewAccessBean();
			leaseDopContractAB.setInitKey_leaseDocument(idLeaseDopContract.intValue());
			leaseDopContractAB.refreshCopyHelper();

			setDataDog("№ " + leaseDopContractAB.getDocumentNumber() + " ,от " + format.format(leaseDopContractAB.getDocumentDate()) + " ,c " + format.format(leaseDopContractAB.getStartDate())+ " по " + format.format(leaseDopContractAB.getEndDate()) + " сумма: " + leaseDopContractAB.getSumm1() + " " + leaseDopContractAB.getCurrency1().getShortname());
		} catch (Exception e) {
			System.out.println("Ошибка initDataDog for LeaseDopContract=" + getTo().getVo().getLeaseDopContract());
			e.printStackTrace(System.out);
			setDataDog("");
		}
		return leaseDopContractAB;
	}
	/**
	 * 
	 * @param errors
	 */
	private void changeDataZP(ActionErrors errors) {
		//изменен ЗП:
		Integer idZpNfs = getTo().getVo().getIdZP();
		if (idZpNfs != null) {
			NFS_ZP_VO zp = initDataZP(idZpNfs);
			getTo().getVo().setOldSumZP(zp.getSumZp().subtract(zp.getNdsZp()));
		}
	}
	/**
	 * 
	 * @param errors
	 */
	private NFS_ZP_VO initDataZP(Integer idZp) {
		CDBCRowObject ro = CDBC_NFS_Object.findZP_NFS(idZp.intValue());
		if (ro != null) {
			NFS_ZP_VO vo = new NFS_ZP_VO(ro);
			setDataZP(vo.getNumZp());
			return vo;
		} else {
			setDataZP("");
			return null;
		}
	}
	/**
	 * 
	 * @param errors
	 */
	private void fillSumZpOnArendaContract(ActionErrors errors) {
		//расчет суммы:
		String errorTxt = CDBC_LeaseZPOfficeMemo_Object.fillSumZpOnArendaContract(getTo().getVo());
		if (errorTxt != null) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
		}
	}	
	/**
	 * "Итого:(Сумма ЗП без НДС + Сумма НДС)"
	 * @return BigDecimal
	 */
	public BigDecimal getSumZP_Plus_SumNdsZP() {
		BigDecimal sumZP = getTo().getVo().getSumZP();
		BigDecimal sumNdsZP = getTo().getVo().getSumNdsZP();
		if (sumZP != null && getTo().getVo().getSumNdsZP() != null)
			return sumZP.add(sumNdsZP);
		else
			return null;
	}
	/**
	 * "Разница к добавлению:"
	 * @return BigDecimal
	 */
	public BigDecimal getSumZP_Minus_OldSumZP() {
		BigDecimal sumZP = getTo().getVo().getSumZP();
		BigDecimal oldSumZP = getTo().getVo().getOldSumZP();
		if (sumZP != null && oldSumZP != null)
			return sumZP.subtract(oldSumZP);
		else
			return null;
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
	private void setVendor_VO(Vendor_VO vendor_VO) {
		this.vendor_VO = vendor_VO;
	}

	/**
	 * @param site_VO
	 */
	private void setVendorSite_VO(VendorSite_VO site_VO) {
		vendorSite_VO = site_VO;
	}

	/**
	 * @return
	 */
	public String getDataZP() {
		return dataZP;
	}

	/**
	 * @param string
	 */
	private void setDataZP(String string) {
		dataZP = string;
	}

	/**
	 * @return
	 */
	public String getDataDog() {
		return dataDog;
	}

	/**
	 * @param string
	 */
	private void setDataDog(String string) {
		dataDog = string;
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
}
