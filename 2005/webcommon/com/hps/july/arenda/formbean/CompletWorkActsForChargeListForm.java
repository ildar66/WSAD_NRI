package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.persistence.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.logic.DocumentLogic;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.arenda.cdbcobjects.CDBC_CompletWorkActs_Object;
import java.sql.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
/**
 * Акты выполненных работ по начислению.
 * Creation date: (25.10.2004 17:43:54)
 * @author: Shafigullin Ildar
 */
public class CompletWorkActsForChargeListForm extends BrowseForm {
	//private int idContract;
	private java.lang.String sortBy = "docdate desc";
	//private LeaseArendaAgreementNewVO agreement = null;
	private java.lang.String operation = "";
	private int idcwacode = -1;
	private java.lang.String toActState = "";
	private int chargeCode; //код начисления
	private Integer IdPosCWA = null; //Код сформированного акта
	private java.lang.Integer operatorCode = null;
	//текущие операции:
	public final static String operation_CREATE_CWA = "createCWA";
	public final static String operation_DELETE_CWA = "deleteItem";
	public final static String operation_CHANGE_ACT_STATE = "changeActState";
	/**
	 * CompletWorkActsListForm constructor comment.
	 */
	public CompletWorkActsForChargeListForm() {
		super();
		setFinderMethodName("findListCompletWorkActsForCharge");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:45:13)
	 * @param errors org.apache.struts.action.ActionErrors
	 */
	private void changeActState(ActionErrors errors) {
		String errorTxt = CDBC_CompletWorkActs_Object.changeActState(getIdcwacode(), getToActState(), getOperatorCode().intValue());
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.10.2004 15:41:44)
	 */
	private void clearAllParams() {
	}
	/**
	 * Для каждой строки броуза можно переопределить возвращаемый объект.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public Object constructRowModelBean(Object o) {
		if (o == null) {
			return o;
		}
		if (!(o instanceof CDBCRowObject)) {
			System.out.println("CompletWorkActsListForm: CLASS_CAST: " + o.getClass().getName());
			return o;
		}
		//return new CompletWorkAct_VO((CDBCRowObject) o);
		CDBCRowObject ro = (CDBCRowObject) o;
		CompletWorkAct_VO vo = new CompletWorkAct_VO(ro);
		vo.setNumRegistryDoc(ro.getColumn("numRegistryDoc").asString());
		vo.setDateRegistryDoc((java.sql.Date)ro.getColumn("dateRegistryDoc").asObject());

		return vo;		
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:54:28)
	 * @param errors org.apache.struts.action.ActionErrors
	 */
	private void deleteItem(ActionErrors errors) {
		try {
			String errorStr = CDBC_CompletWorkActs_Object.delete(new Integer(getIdcwacode()));
			if (errorStr != null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getName() + ".deleteItem():errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.10.2004 15:37:03)
	 * @return com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO
	
	public com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO getAgreement() {
		return agreement;
	}
	*/
	/**
	 * Возвращает имя bean для броуза.
	 * Creation date: (22.01.2002 11:33:25)
	 * @return java.lang.String
	 */
	public String getBrowseBeanName() {
		return "com.hps.july.arenda.cdbcobjects.CDBC_CompletWorkActs_Object";
	}
	/**
	 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
	 * Creation date: (25.10.2004 17:43:54)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		//return new Object[] { Boolean.TRUE, agreement.getO().getMainLeaseDocument(), getSortBy()};
		return new Object[] { new Integer(getChargeCode()), getSortBy()};
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 14:46:41)
	 * @return int
	
	public int getIdContract() {
		return idContract;
	}
	*/
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:29:42)
	 * @return int
	 */
	public int getIdcwacode() {
		return idcwacode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:22:52)
	 * @return java.lang.String
	 */
	public java.lang.String getOperation() {
		return operation;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 14:47:09)
	 * @return java.lang.String
	 */
	public java.lang.String getSortBy() {
		return sortBy;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:19:26)
	 * @return java.lang.String
	 */
	public java.lang.String getToActState() {
		return toActState;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.10.2004 15:37:03)
	 * @param newAgreement com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO
	
	private void initAgreement() {
		agreement = new LeaseArendaAgreementNewVO();
		agreement.setO(new LeaseArendaAgrmntVO());
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(getIdContract());
			bean.refreshCopyHelper();
			//устанавливаем из активного док.
			setCurrencyParams(bean);
			//устанавливаем из главного док.
			if (bean.getMainDocument() != null) {
				LeaseArendaAgreementNewAccessBean mbean = new LeaseArendaAgreementNewAccessBean();
				mbean.setInitKey_leaseDocument(bean.getMainDocument().intValue());
				mbean.refreshCopyHelper();
				setMainParams(mbean);
			} else {
				setMainParams(bean);
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			clearAllParams();
		}
	}
	 */
	/**
	 * Инициализация режима просмотра списка.
	 * Creation date: (22.05.2002 16:35:23)
	 * @return java.lang.Object
	 * @param o java.lang.Object
	 */
	public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ParamsParser.setState(request, Applications.ARENDA, APPStates.COMPLET_WORK_ACTS_FOR_CHARGE_LIST);
		//initAgreement();
		if (getOperatorCode() == null)
			initOperatorCode(request);
		return null;
	}
	/**
	 * Reset all bean properties to their default state.  This method is
	 * called before the properties are repopulated by the controller servlet.
	 * <p>
	 * The default implementation does nothing.  Subclasses should override
	 * this method to reset all bean properties to default values.
	 *
	 * @param mapping The mapping used to select this instance
	 * @param request The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		operation = "";
		idcwacode = -1;
		toActState = "";
		chargeCode = -1;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.10.2004 12:53:41)
	
	private void setCurrencyParams(LeaseArendaAgreementNewAccessBean bean) {
		try {
			agreement.getO().setSumm1(bean.getSumm1());
			CurrencyVO currVO = new CurrencyVO(new Integer(bean.getCurrency1().getCurrency()));
			currVO.setShortname(bean.getCurrency1().getShortname());
			agreement.getO().setCurrency1(currVO);
			agreement.getO().setSumm2(bean.getSumm2());
			if (bean.getCurrency2() != null) {
				currVO = new CurrencyVO(new Integer(bean.getCurrency2().getCurrency()));
				currVO.setShortname(bean.getCurrency2().getShortname());
				agreement.getO().setCurrency2(currVO);
			} else {
				agreement.getO().setCurrency2(null);
			}
		} catch (Exception e) {
			System.out.println("CompletWorkActsListForm.setCurrencyParams, EXCEPTION.");
			e.printStackTrace(System.out);
		}
	}
	 */
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 14:46:41)
	 * @param newIdContract int
	
	public void setIdContract(int newIdContract) {
		idContract = newIdContract;
	}
	*/
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:29:42)
	 * @param newIdcwacode int
	 */
	public void setIdcwacode(int newIdcwacode) {
		idcwacode = newIdcwacode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.10.2004 15:35:40)
	
	private void setMainParams(LeaseArendaAgreementNewAccessBean mainBean) {
		try {
			agreement.setMainDocumentNumber(mainBean.getDocumentNumber());
			agreement.setMainDocumentDate(mainBean.getDocumentDate());
			agreement.setMainStartDate(mainBean.getStartDate());
			agreement.setMainEndDate(mainBean.getEndDate());
			agreement.getO().setMainLeaseDocument(new Integer(mainBean.getLeaseDocument()));
			if (mainBean.getOrgCustomer() != null) {
				OrganizationVO customer = new OrganizationVO(new Integer(mainBean.getOrgCustomer().getOrganization()));
				customer.setName(mainBean.getOrgCustomer().getName());
				customer.setShortname(mainBean.getOrgCustomer().getShortname());
				customer.setDirectorfio(mainBean.getOrgCustomer().getDirectorinfo());
				customer.setLegaladdress(mainBean.getOrgCustomer().getLegaladdress());
				agreement.setMainOrgCustomer(customer);
			}
			if (mainBean.getOrgExecutor() != null) {
				OrganizationVO executor = new OrganizationVO(new Integer(mainBean.getOrgExecutor().getOrganization()));
				executor.setName(mainBean.getOrgExecutor().getName());
				executor.setShortname(mainBean.getOrgExecutor().getShortname());
				executor.setDirectorfio(mainBean.getOrgExecutor().getDirectorinfo());
				executor.setLegaladdress(mainBean.getOrgExecutor().getLegaladdress());
				agreement.setMainOrgExecutor(executor);
			}
			agreement.setMainPosition(DocumentLogic.getNameMainPosition(mainBean));
		} catch (Exception e) {
			System.out.println("CompletWorkActsListForm.setMainParams, EXCEPTION.");
			e.printStackTrace(System.out);
		}
	}
	 */
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2004 14:22:52)
	 * @param newOperation java.lang.String
	 */
	public void setOperation(java.lang.String newOperation) {
		operation = newOperation;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.10.2004 14:47:09)
	 * @param newSortBy java.lang.String
	 */
	public void setSortBy(java.lang.String newSortBy) {
		sortBy = newSortBy;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:19:26)
	 * @param newToActState java.lang.String
	 */
	public void setToActState(java.lang.String newToActState) {
		toActState = newToActState;
	}
	/**
	 * Метод для проверки правильности введеных значений.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException The exception description.
	 */
	public void validateValues(org.apache.struts.action.ActionErrors errors) throws Exception {
		if (operation.equalsIgnoreCase(operation_DELETE_CWA)) {
			deleteItem(errors);
		} else if (operation.equalsIgnoreCase(operation_CHANGE_ACT_STATE)) {
			changeActState(errors);
		} else if (operation.equalsIgnoreCase(operation_CREATE_CWA)) {
			createCWA(errors);
		}
	}
	/**
	 * @return
	 */
	public int getChargeCode() {
		return chargeCode;
	}

	/**
	 * @param i
	 */
	public void setChargeCode(int i) {
		chargeCode = i;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2004 14:45:13)
	 * @param errors org.apache.struts.action.ActionErrors
	 */
	private void createCWA(ActionErrors errors) {
		Object[] values = CDBC_CompletWorkActs_Object.prepareCWA(getChargeCode(), null, getOperatorCode().intValue());
		Integer result = (Integer) values[0]; //Признак ошибки (0 без ошибок)
		if (result.intValue() != 0) {
			String errorTxt = (String) values[1];
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorTxt));
			setIdPosCWA(null); //Признак ошибки
		} else {
			setIdPosCWA((Integer) values[2]);
		}
	}
	/**
	 * @return
	 */
	public Integer getIdPosCWA() {
		return IdPosCWA;
	}

	/**
	 * @param integer
	 */
	public void setIdPosCWA(Integer integer) {
		IdPosCWA = integer;
	}

	/**
	 * @return
	 */
	private java.lang.Integer getOperatorCode() {
		return operatorCode;
	}

	/**
	 * @param integer
	 */
	private void setOperatorCode(java.lang.Integer integer) {
		operatorCode = integer;
	}
	/**
	 * 
	 * @param request
	 */
	private void initOperatorCode(javax.servlet.http.HttpServletRequest request) {
		setOperatorCode(OperatorObject.getOperatorCode(request.getRemoteUser()));
	}
	/* (non-Javadoc)
	 * @see com.hps.july.web.util.BrowseForm#getEditRoles()
	 */
	public ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		roles.add("ArendaManager");
		roles.add("ArendaMainManager");
		return roles;
	}

}
