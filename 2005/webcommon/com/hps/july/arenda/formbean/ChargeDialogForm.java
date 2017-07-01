/*
 * Created on 27.01.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.formbean;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethodAccessBean;
import com.hps.july.arenda.valueobject.CurrencyVO;
import com.hps.july.arenda.valueobject.ResourceVO;
import com.hps.july.cdbc.objects.CDBCLeaseChargesObject;
import com.hps.july.logic.DocumentLogic;
import com.hps.july.persistence.CurrencyAccessBean;
import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.persistence.LeaseResourceAccessBean;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.valueobject.LeaseCharge_VO;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.StringAndBigDecimalProperty;
import com.hps.july.web.util.ValidationException;

/**
 * @author IShaffigulin
 * form-bean(форма для начислений)
 * выведена в диалог из ChargeForm
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChargeDialogForm extends EditForm {
	private int id;
	private boolean flagOperation;
	private LeaseCharge_VO vo;
	private int idContract;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private ArrayList currencies;
	private ArrayList resources;
	private java.lang.Boolean isCorrection;
	//ставка НДС:
	private StringAndBigDecimalProperty ndsRate;
	private String oldVoStr;
	private java.lang.String calctype;

	/**
	 * Insert the method's description here.
	 * Creation date: (08.07.2002 13:03:45)
	 */
	public ChargeDialogForm() {
		initCurrencies();
		ndsRate = new StringAndBigDecimalProperty();
	}

	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		//boolean flag = CDBCLeaseChargesObject.delete(getVo());
		//return process(flag, errors);
		try {
			String errorStr = CDBCLeaseChargesObject.delete(getVo().getLeaseDocPosition());
			if (errorStr != null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
				setFlagOperation(false);
			} else {
				setFlagOperation(true);
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + ".processDelete:errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		//boolean flag = CDBCLeaseChargesObject.add(getVo());
		//return process(flag, errors);
		try {
			String errorStr = CDBCLeaseChargesObject.insertCharge(getVo());
			if (errorStr != null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
				setFlagOperation(false);
			} else {
				setFlagOperation(true);
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + ".processInsert:errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		//boolean flag = CDBCLeaseChargesObject.edit(getVo());
		//return process(flag, errors);
		try {
			String errorStr = CDBCLeaseChargesObject.updateCharge(getVo());
			if (errorStr != null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
				setFlagOperation(false);
			} else {
				setFlagOperation(true);
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + ".processUpdate:errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
		return "success";		
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (05.07.2002 14:02:29)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.CHARGE_DIALOG;
	}

	/**
	 * @return
	 */
	public boolean isFlagOperation() {
		return flagOperation;
	}

	/**
	 * @param b
	 */
	private void setFlagOperation(boolean b) {
		flagOperation = b;
	}

	/**
	 * Используеться тагом "canedit" для разрешения просмотра(редактирования) полей и пр.
	 * Creation date: (12.04.2004 16:47:06)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		return roles;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:02:34)
	 */
	private void initCurrencies() {
		try {
			ArrayList listCurrencies = new ArrayList();
			CurrencyAccessBean bean = new CurrencyAccessBean();
			Enumeration enum = bean.findAllOrderByNameAsc();
			while (enum.hasMoreElements()) {
				CurrencyAccessBean ab = (CurrencyAccessBean) enum.nextElement();
				CurrencyVO vo = new CurrencyVO(new Integer(ab.getCurrency()));
				vo.setName(ab.getName());
				listCurrencies.add(vo);
			}
			setCurrencies(listCurrencies);
		} catch (Exception e) {
			System.out.println("ChargeDialogForm.initCurrencies(): Ошибка формирования листа валют!!!");
			e.printStackTrace(System.out);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException The exception description.
	 */
	public void validateValues(ActionErrors errors) throws Exception {

		if (getAction().equals("Add")) {
			//vo.setRemainderSum(vo.getSumm());
			//vo.setDocPosVid(getIsCorrection().booleanValue() ? "C" : "N");
			//vo.setDate(vo.getEndDate()); //temp
		} else if (getAction().equals("Edit")) {
			if (!(getVo().toString()).equals(getOldVoStr()))
				vo.setSource("M");
			//vo.setDocPosVid(getIsCorrection().booleanValue() ? "C" : "N");
			//vo.setDate(vo.getEndDate()); //temp		
		}
		calcNDS(errors);
		//processValidate(errors);

		/**		
				if (date.isEmpty()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.date"));
				} else if (!date.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.date"));
				}
		
				boolean isBegin = false, isEnd = false;
		
				if (begindate.isEmpty()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.begindate"));
				} else if (!begindate.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.begindate"));
				} else
					isBegin = true;
		
				if (enddate.isEmpty()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.enddate"));
				} else if (!enddate.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.enddate"));
				} else
					isEnd = true;
		
				if (isBegin && isEnd && enddate.getSqlDate().compareTo(begindate.getSqlDate()) < 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.dates"));
				}
		
				if (resourcecode.isEmpty()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.resource"));
				} else if (!resourcecode.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.resource"));
				} else {
					try {
						constructResource();
					} catch (Exception e) {
						if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.resource"));
						}
					}
				}
		
				if (summ.isEmpty()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.sum"));
				} else if (!summ.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.sum"));
				} else if (summ.getBigDecimal().doubleValue() <= 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.sum.sign"));
				}
		
				if (currencycode == null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.currency"));
				} else {
					try {
						constructCurrency();
					} catch (Exception e) {
						if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.currency"));
						}
					}
				}
		
				if (sumnds.isEmpty()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.ndsum"));
				} else if (!sumnds.isOk()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.ndsum"));
				} else if (sumnds.getBigDecimal().compareTo(new BigDecimal(0)) < 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.ndsum2"));
				}
		
				if (getByhandraterur().booleanValue()) {
					if (remainderrate2rur.isEmpty()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.rate"));
					} else if (!remainderrate2rur.isOk()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.rate"));
					} else if (remainderrate2rur.getBigDecimal().compareTo(new BigDecimal(0)) < 0) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.rate2"));
					}
				}
		
				////1
		
				if (!((getSource().equals("M") || getSource().equals("A")) && getDocposvid().equals("N"))) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.source"));
				}
		
				if (getSource().equals("B")
					|| getSource().equals("P")
					|| getDocposvid().equals("Q")
					|| getDocposvid().equals("K")
					|| getDocposvid().equals("Z")) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.wrong"));
				}
		
				if (!getAction().equals("Add") && !checkLink2Pay()) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.haspay"));
				}
		
				//if (getState() == APPStates.CHARGE_EDIT || getState() == APPStates.HISTORY_CHARGE_EDIT) {
				if (!getIsCorrection().booleanValue()) {
					Enumeration e =
						new LeaseArendaAgreementNewAccessBean().findByContractAndResource(
							getLeaseContractCodeMain(),
							getResourcecode(),
							new Integer(2));
					if (e.hasMoreElements()) {
						LeaseArendaAgreementNewAccessBean laanBeen = (LeaseArendaAgreementNewAccessBean) e.nextElement();
		
						LeaseChargeRuleAccessBean lcrBean = null;
						int i = 0;
		
						Enumeration n =
							new LeaseChargeRuleAccessBean().findByLeaseDocumentAndResource(
								getLeaseContractCodeMain(),
								getResourcecode(),
								new Integer(1));
						while (n.hasMoreElements()) {
							lcrBean = (LeaseChargeRuleAccessBean) n.nextElement();
							i++;
						}
		
						switch (i) {
							case 0 :
								errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.hasnochargerule"));
								break;
							case 1 :
								if (lcrBean.getChargeDateRule().equals("S")) {
									setDate(getBegindate());
								} else if (lcrBean.getChargeDateRule().equals("E")) {
									setDate(getEnddate());
								}
								break;
							default :
								errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.hasmuchchargerule"));
						}
					} else {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.hasnochargerule"));
					}
				}
				//} else {
				//	setDate(getEnddate());
				//}
		
				///2
		
				*/
		/** Вместо этой проверки сделать проверку по UsedInAct
		if (!date.isEmpty() && date.isOk() && !checkOpenPeriod()) {
		
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(
				"error.charge.notopenperiod2", formatSalDate()));
		}
		*/
		/**
		if (isInAct(getLeaseDocPosition())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.charge.applied"));
		}
		
		if (!errors.empty()) {
			throw new ValidationException();
		}
		
		setDocposvid(getIsCorrection().booleanValue() ? "C" : "N");
		*/
	}

	private void calcNDS(ActionErrors errors) throws Exception {
		//Рассчитываем НДС
		if (getCalctype().equals("N")) {
			if (vo.getSumm() != null && vo.getBeginDate() != null && !(vo.getSumm().doubleValue() <= 0)) {
				vo.setSumNds(
					new ArendaDocumentTransactionMethodAccessBean().calcNds(
						vo.getResource(),
						vo.getBeginDate(),
						vo.getSumm(),
						"1"));
			} else {
				if (vo.getSumm() == null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.charge.sum2"));
				} else if (vo.getSumm().doubleValue() <= 0) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.charge.sum.sign2"));
				}
				if (vo.getBeginDate() == null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.begindate.empty"));
				}
			}
			throw new ValidationException();
		}
	}

	/**
	 * @return
	 */
	public java.util.ArrayList getCurrencies() {
		return currencies;
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
	public LeaseCharge_VO getVo() {
		return vo;
	}

	/**
	 * @param list
	 */
	private void setCurrencies(java.util.ArrayList list) {
		currencies = list;
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
	 * @param chargeVO
	 */
	public void setVo(LeaseCharge_VO chargeVO) {
		vo = chargeVO;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		setFlagOperation(false);
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#loadRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void loadRecord(HttpServletRequest request) throws Exception {
		vo = CDBCLeaseChargesObject.find(getId());
		setIdContract(getVo().getLeaseContract().intValue());
		initResources(new Integer(getIdContract()));
		setIsCorrection(vo.getDocPosVid().equals("C") ? new Boolean(true) : new Boolean(false));
		calsRateNds();
		setOldVoStr(getVo().toString());
	}

	/**
	 * @return
	 */
	public ArrayList getResources() {
		return resources;
	}

	/**
	 * @param list
	 */
	private void setResources(ArrayList list) {
		resources = list;
	}

	/**
	 * @param list
	 */
	private void initResources(Integer aIdContract) {
		try {
			ArrayList listResources = new ArrayList();
			java.util.Vector v = new java.util.Vector();
			v.addElement(aIdContract);

			Enumeration e =
				new LeaseArendaAgreementNewAccessBean().findByQBE2(
					aIdContract,
					new Boolean(false),
					null,
					new Boolean(false),
					null,
					new Integer(1));
			while (e.hasMoreElements()) {
				LeaseArendaAgreementNewAccessBean laanBean = (LeaseArendaAgreementNewAccessBean) e.nextElement();
				v.addElement(new Integer(laanBean.getLeaseDocument()));
			}

			Enumeration enum = new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
			while (enum.hasMoreElements()) {
				ResourceAccessBean ab = (ResourceAccessBean) enum.nextElement();
				ResourceVO vo = new ResourceVO(new Integer(ab.getResource()));
				vo.setName(ab.getName());
				listResources.add(vo);
			}
			setResources(listResources);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ChargeDialogForm.initResources(): Ошибка формирования листа ресурсов!!!");
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getBeginDateStr() {
		if (getVo() != null && getVo().getBeginDate() != null) {
			return format.format(new java.util.Date(getVo().getBeginDate().getTime()));
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setBeginDateStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setBeginDate(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setBeginDate(new java.sql.Date(d.getTime()));
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getEndDateStr() {
		if (getVo() != null && getVo().getEndDate() != null) {
			return format.format(new java.util.Date(getVo().getEndDate().getTime()));
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setEndDateStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setEndDate(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setEndDate(new java.sql.Date(d.getTime()));
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getDateStr() {
		if (getVo() != null && getVo().getDate() != null) {
			return format.format(new java.util.Date(getVo().getDate().getTime()));
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setDateStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setDate(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setDate(new java.sql.Date(d.getTime()));
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 18:51:35)
	 */
	public String getSummStr() {
		if (vo != null && vo.getSumm() != null)
			return vo.getSumm().toString();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 18:53:10)
	 */
	public void setSummStr(String amountStr) {
		if (vo != null && !amountStr.equals(""))
			vo.setSumm(new java.math.BigDecimal(amountStr));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 18:51:35)
	 */
	public String getSumNdsStr() {
		if (vo != null && vo.getSumNds() != null)
			return vo.getSumNds().toString();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 18:53:10)
	 */
	public void setSumNdsStr(String amountStr) {
		if (vo != null && !amountStr.equals(""))
			vo.setSumNds(new java.math.BigDecimal(amountStr));
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 18:51:35)
	 */
	public String getRemainderRate2RurStr() {
		if (vo != null && vo.getRemainderRate2Rur() != null)
			return vo.getRemainderRate2Rur().toString();
		else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 18:53:10)
	 */
	public void setRemainderRate2RurStr(String amountStr) {
		if (vo != null && !amountStr.equals(""))
			vo.setRemainderRate2Rur(new java.math.BigDecimal(amountStr));
	}
	/**
	 * @return
	 */
	public java.lang.Boolean getIsCorrection() {
		return isCorrection;
	}

	/**
	 * @param boolean1
	 */
	public void setIsCorrection(java.lang.Boolean boolean1) {
		isCorrection = boolean1;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initRecord(javax.servlet.http.HttpServletRequest)
	 */
	public void initRecord(HttpServletRequest request) throws Exception {
		setIsCorrection(new Boolean(false));
		// For NDS calculation in form
		java.math.BigDecimal aval =
			com.hps.july.util.AppUtils.getNamedValueBigDecimal(com.hps.july.util.AppUtils.DEFAULT_RATE_NDS);
		setNdsRate(aval);
		int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leasedocpositions");
		setId(key);
		vo = new LeaseCharge_VO(new Integer(key));
		vo.setLeaseContract(new Integer(getIdContract()));
		vo.setSource("M");
		vo.setDocPosVid("N");
		initResources(new Integer(getIdContract()));
		initFlagsNeedSchetFactAndCompletWorkAct(getIdContract());		
	}
	/**
	 * Инициализация флагов необходимости создания С-Ф и актов вып.работ.
	 *
	 */
	private void initFlagsNeedSchetFactAndCompletWorkAct(int idContract) {
		try {
			//setNeedSf: При создании начисления галка "Сформировать СФ" проставляется, если в договоре "Годовая стоимость": "том числе НДС" :
			LeaseArendaAgreementNewAccessBean beanMain = DocumentLogic.getMainDocument(idContract);
			if(beanMain.getChargeNds())	{
				vo.setNeedSf("N");	
			}else{
				vo.setNeedSf("Y");	
			}
			//setNeedCwAct:галка  "Сформировать акт вып. работ" проставляется в зависимости от типа  "Услуги" (Resource) в начислении и ее типа в LeaseResources.NeedCwAct
			ArrayList listResources = getResources();
			if(listResources != null && listResources.size() > 0){
				ResourceVO resVO = (ResourceVO)listResources.get(0);
				Integer key = resVO.getResource();
				LeaseResourceAccessBean leaseResAB = new LeaseResourceAccessBean();
				leaseResAB.setInitKey_resource(key.intValue());
				if(leaseResAB.isNeedCwAct()){
					vo.setNeedCwAct("Y");
				}else{
					vo.setNeedCwAct("N");
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		} catch (FinderException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @return java.lang.String
	 */
	public java.lang.String getBillDateStr() {
		if (getVo() != null && getVo().getBillDate() != null) {
			return format.format(new java.util.Date(getVo().getBillDate().getTime()));
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 * @param newDateActStr java.lang.String
	 */
	public void setBillDateStr(java.lang.String newDateStr) throws java.text.ParseException {
		if (newDateStr == null || newDateStr.trim().length() == 0) {
			getVo().setBillDate(null);
		} else {
			java.util.Date d = format.parse(newDateStr);
			getVo().setBillDate(new java.sql.Date(d.getTime()));
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 16:23:53)
	 */
	public void calsRateNds() {
		if (vo.getSumm() == null || vo.getSumNds() == null)
			return;
		double summ = vo.getSumm().doubleValue();
		double sumNds = vo.getSumNds().doubleValue();
		double nds = 100 * sumNds / (summ - sumNds);
		if ((nds > 19) || (nds < 21))
			setNdsRate(new BigDecimal("20"));
		if ((nds > 17) || (nds < 19))
			setNdsRate(new BigDecimal("18"));
		setNdsRate(new BigDecimal(Math.round(nds)));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.03.2004 15:26:59)
	 */
	public java.math.BigDecimal getNdsRate() {
		return ndsRate.getBigDecimal();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.03.2004 15:27:33)
	 */
	public String getNdsRateFrm() {
		return ndsRate.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.03.2004 15:28:48)
	 */
	public void setNdsRate(java.math.BigDecimal newNdsRate) {
		ndsRate.setBigDecimal(newNdsRate);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.03.2004 15:29:31)
	 */
	public void setNdsRateFrm(String newNdsRateStr) {
		ndsRate.setString(newNdsRateStr);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "Ошибка CRUD операции : LeaseCharge_VO:id" + getVo().getLeaseDocPosition();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			setFlagOperation(false);
		} else {
			setFlagOperation(true);
		}
		return "success";
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.12.2002 15:14:34)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getByhandraterur() {
		return "Y".equals(vo.getByHandRateRur()) ? Boolean.TRUE : Boolean.FALSE;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.12.2002 15:14:34)
	 * @param newByhandraterur java.lang.Boolean
	 */
	public void setByhandraterur(java.lang.Boolean newByhandraterur) {
		if (newByhandraterur.booleanValue())
			getVo().setByHandRateRur("Y");
		else
			getVo().setByHandRateRur("N");
	}
	/**
	 * @return
	 */
	private String getOldVoStr() {
		return oldVoStr;
	}

	/**
	 * @param charge_VO
	 */
	private void setOldVoStr(String charge_VO_Str) {
		oldVoStr = charge_VO_Str;
	}

	/**
	 * @return
	 */
	public java.lang.String getCalctype() {
		return calctype;
	}

	/**
	 * @param string
	 */
	public void setCalctype(java.lang.String string) {
		calctype = string;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (19.10.2005 18:50:24)
	 * @return java.lang.String
	 */
	private void processValidate(ActionErrors errors) throws ValidationException {
		try {
			String errorStr = CDBCLeaseChargesObject.checkChangeCharge(getVo());
			if (errorStr != null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			}
		} catch (Exception e) {
			System.out.println("processValidate():errorTxt: " + e);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
			e.printStackTrace();
		}
		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.12.2002 15:14:34)
	 * @return java.lang.Boolean
	 */	
	public java.lang.Boolean getNeedSf() {
		return "Y".equals(vo.getNeedSf()) ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (13.12.2002 15:14:34)
	 * @param newNeedSf java.lang.Boolean
	 */	
	public void setNeedSf(java.lang.Boolean newNeedSf) {
		if (newNeedSf.booleanValue())
			getVo().setNeedSf("Y");
		else
			getVo().setNeedSf("N");
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (13.12.2002 15:14:34)
	 * @return java.lang.Boolean
	 */	
	public java.lang.Boolean getNeedCwAct() {
		return "Y".equals(getVo().getNeedCwAct()) ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (13.12.2002 15:14:34)
	 * @param newNeedCwAct java.lang.Boolean
	*/
	public void setNeedCwAct(java.lang.Boolean newNeedCwAct) {
		if (newNeedCwAct.booleanValue())
			getVo().setNeedCwAct("Y");
		else
			getVo().setNeedCwAct("N");
	}

}
