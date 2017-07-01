/*
 * Created on 19.05.2006
 *
 * "Проблемы ведения договоров" EditForm Object
 */
package com.hps.july.arenda.formbean;

import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.arenda.cdbcobjects.CDBC_Helper;
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseContractProblem_Object;
import com.hps.july.arenda.valueobject.PeopleVO;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.logic.DocumentLogic;
import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.persistence.OrganizationNfsAccessBean;
import com.hps.july.persistence.PeopleAccessBean;
import com.hps.july.persistence.PositionAccessBean;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.valueobject.LeaseContractProblem_TO;
import com.hps.july.valueobject.LeaseContractProblem_VO;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.StringAndBigDecimalProperty;
import com.hps.july.web.util.ValidationException;

/**
 * @author IShaffigulin
 *
 * "Проблемы ведения договоров" EditForm Object
 */
public class LeaseContractProblemDialogForm extends EditForm {
	private int id;
	private boolean flagOperation;
	private LeaseContractProblem_TO to;
	private int idContract;
	private java.lang.String operation = "";
	private PeopleVO operatorVO;

	private ContractInfo contractInfo;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");

	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:01:54)
	 */
	public LeaseContractProblemDialogForm() {
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
		private Integer executor;
		private String executorName;

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

		private void setExecutor(PeopleAccessBean peopleAB) throws Exception{
			setExecutor(new Integer(peopleAB.getMan()));
			setExecutorName(peopleAB.getFullName());
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

		/**
		 * @return
		 */
		public Integer getExecutor() {
			return executor;
		}

		/**
		 * @return
		 */
		public String getExecutorName() {
			return executorName;
		}

		/**
		 * @param integer
		 */
		private void setExecutor(Integer integer) {
			executor = integer;
		}

		/**
		 * @param string
		 */
		private void setExecutorName(String string) {
			executorName = string;
		}

	}
	/**
	 * Информация о договоре
	 */
	private ContractInfo initContractInfo(int contractID) {
		try {
			LeaseArendaAgreementNewAccessBean beanMain = DocumentLogic.getMainDocument(contractID);
			//заполняем ContractInfo
			ContractInfo info = new ContractInfo();
			info.setDocNumber(beanMain.getDocumentNumber());
			info.setDocDate(beanMain.getDocumentDate());
			//info.setOrgExecutor(beanMain.getOrgExecutor());
			//info.setMainPosition(beanMain.getMainposition());
			//info.setCodeActiveDocument(beanMain.getActivecontract());
			//info.setMainResource(beanMain.getMainresource());
			info.setExecutor(beanMain.getManager().getMan());
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
		return com.hps.july.arenda.APPStates.LEASE_CONTRACT_PROBLEM_DIALOG;
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
	public LeaseContractProblem_TO getTo() {
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
	public void setTo(LeaseContractProblem_TO aTO) {
		to = aTO;
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
		int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leaseContractProblem");
		setId(key);
		to = new LeaseContractProblem_TO(new LeaseContractProblem_VO(new Integer(key)));
		to.getVo().setState(LeaseContractProblem_VO.stateEdit); //редактируется
		to.getVo().setLeaseContract(new Integer(getIdContract()));
		CDBC_Helper.initDomainObject(getTo().getVo(), getOperatorVO());
		//init Инициатор:
		to.getVo().setOwner(getOperatorVO().getMan());
		to.setOwnerName(getOperatorVO().getName());

		//init инфо о договоре:
		setContractInfo(initContractInfo(getIdContract()));
		//init Исполнитель:
		to.getVo().setExecutor(getContractInfo().getExecutor());
		to.setExecutorName(getContractInfo().getExecutorName());
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#loadRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void loadRecord(HttpServletRequest request) throws Exception {
		to = CDBC_LeaseContractProblem_Object.find(getId());
		setIdContract(getTo().getVo().getLeaseContract().intValue());
		//инфо о договоре:
		//setContractInfo(initContractInfo(getTo().getVo().getLeaseContract().intValue()));
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
			String errorStr = "Ошибка CRUD операции : LeaseContractProblem_VO:id" + getTo().getVo().getIdProblem();
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
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeaseContractProblem_Object.delete(getTo().getVo());
		return process(flag, errors);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processInsert(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processInsert(HttpServletRequest request, ActionErrors errors) throws Exception {
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeaseContractProblem_Object.add(getTo().getVo());
		return process(flag, errors);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processUpdate(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processUpdate(HttpServletRequest request, ActionErrors errors) throws Exception {
		CDBC_Helper.updateDomainObject(getTo().getVo(), getOperatorVO());
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeaseContractProblem_Object.edit(getTo().getVo());
		return process(flag, errors);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#validateValues(org.apache.struts.action.ActionErrors)
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		//processCalcOptions:
		//processCalcOptions(errors);

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
}
