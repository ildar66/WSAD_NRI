package com.hps.july.arenda.valueobject;

import java.sql.*;
import java.math.*;
import com.hps.july.cdbc.lib.*;
/**
* Контейнер Договора.
* Creation date: (24.03.2004 19:32:23)
* @author: Shafigullin Ildar
*/
public class LeaseContractVO extends LeaseDocumentVO {
    private String contractType; //Тип контракта(A-Аренда, B-Аренда у нас, C-Аб. договор, D-Дог. на аренду канала связи, S-Ссудный договор)
    private String contractState; //Состояние контракта(A-Вводится, B-Исполняется, C-Завершен, D-Редактируются неключевые параметры)
    private OrganizationVO orgCustomer; //Организация заказчик
    private OrganizationVO orgExecutor; //Организация исполнитель
    private String custName; //История изменения имени заказчика
    private String execName; //История изменения имени исполнителя
    private Date startDate; //Дата начала договора
    private Date endDate; //Дата окончания договора
    private java.lang.String docText; //Текст договора
    private java.lang.String docFileName; //Имя файла договора
    private java.lang.String docComment; //Комментарий к договору
    private java.lang.String docSubject; //Предмет договора
    private java.lang.String extendType; //Тип продления договора(N-Нет продления, A-Автоматическое продление, M-Продление доп. соглашением)
    private java.lang.String extendPeriod; //Период продления договора(Y-Год, M-11 месяцев,D-360 дней)
    private java.lang.String reportPeriod; //Период отчетности по договору(M-Месяц, Q-Квартал)
    private java.lang.Integer economist; //Ответственный экономист
    private CurrencyVO currency1; //Валюта 1
    private CurrencyVO currency2; //Валюта 2
    private BigDecimal summ1; //Сумма в валюте 1
    private java.math.BigDecimal summ2; //Сумма в валюте 2
    private java.lang.String ratecalcrule; //правило определения курса для платежей и начислений(A-на дату выставления счета, B-на дату платежа, C-за день до платежа, D-последняя дата оплачиваемого периода, E-начальная дата оплачиваемого периода, F-на Х число месяца предшествующего оплачиваемому периоду, G-на Х число последнего месяца предшествующего кварталу оплачиваемого периода, H-на последнюю дату предшествующего периода, I-на первое число следующего периода)
    private java.lang.Short ratecalcruleday; //Число месяца для некоторых вариантов расчета курса
    private java.math.BigDecimal ratedelta; //наценка в процентах для расчета курса
    private WorkerVO economistVO; //Ответственный экономист
    private WorkerVO managerVO; //Ответственный менеджер
	private java.lang.String chargeNds;
	private Date dateclose;
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 17:38:13)
 */
public LeaseContractVO() {}
/**
 * LeaseContractsVO constructor
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LeaseContractVO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super(ro);
	setContractType(ro.getColumn("contracttype").asString());
	setContractState(ro.getColumn("contractstate").asString());
	//Организация заказчик:
	initOrgCustomer(ro);
	//Организация исполнитель:
	initOrgExecutor(ro);
	setCustName(ro.getColumn("custname").asString());
	setExecName(ro.getColumn("execname").asString());
	setStartDate((Date) ro.getColumn("startdate").asObject());
	setEndDate((Date) ro.getColumn("enddate").asObject());
	setDocText("заполнить в LeaseContractVO"); //temp
	setDocFileName(ro.getColumn("docfilename").asString());
	setDocComment(ro.getColumn("doccomment").asString());
	setDocSubject(ro.getColumn("docsubject").asString());
	setExtendType(ro.getColumn("extendtype").asString());
	setExtendPeriod(ro.getColumn("extendperiod").asString());
	setReportPeriod(ro.getColumn("reportperiod").asString());
	setEconomist((Integer) ro.getColumn("economist").asObject());
	//Основная валюта:
	initCurrency1(ro);
	//Дополнительная валюта:
	initCurrency2(ro);
	setSumm1((BigDecimal) ro.getColumn("summ1").asObject());
	setSumm2((BigDecimal) ro.getColumn("summ2").asObject());
	setRatecalcrule(ro.getColumn("ratecalcrule").asString());
	setRatecalcruleday((Short) ro.getColumn("ratecalcruleday").asObject());
	setRatedelta((BigDecimal) ro.getColumn("ratedelta").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 18:42:15)
 * @return java.lang.String
 */
public java.lang.String getChargeNds() {
	return chargeNds;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:34:36)
 * @return java.lang.String
 */
public java.lang.String getContractState() {
	return contractState;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:34:18)
 * @return java.lang.String
 */
public java.lang.String getContractType() {
	return contractType;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:11:32)
 * @return java.lang.Integer
 */
public CurrencyVO getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:12:14)
 * @return java.lang.Integer
 */
public CurrencyVO getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:38:39)
 * @return java.lang.String
 */
public java.lang.String getCustName() {
	return custName;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:56:08)
 * @return java.lang.String
 */
public java.lang.String getDocComment() {
	return docComment;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:55:27)
 * @return java.lang.String
 */
public java.lang.String getDocFileName() {
	return docFileName;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:57:50)
 * @return java.lang.String
 */
public java.lang.String getDocSubject() {
	return docSubject;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:54:01)
 * @return java.lang.String
 */
public java.lang.String getDocText() {
	return docText;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:10:41)
 * @return java.lang.Integer
 */
public java.lang.Integer getEconomist() {
	return economist;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 15:28:28)
 * @return com.hps.july.arenda.valueobject.WorkerVO
 */
public WorkerVO getEconomistVO() {
	return economistVO;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:41:25)
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:39:25)
 * @return java.lang.String
 */
public java.lang.String getExecName() {
	return execName;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:09:11)
 * @return java.lang.String
 */
public java.lang.String getExtendPeriod() {
	return extendPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:59:27)
 * @return java.lang.String
 */
public java.lang.String getExtendType() {
	return extendType;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:12:17)
 * @return com.hps.july.arenda.valueobject.WorkerVO
 */
public WorkerVO getManagerVO() {
	return managerVO;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:37:03)
 * @return java.lang.Integer
 */
public OrganizationVO getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:37:45)
 * @return java.lang.Integer
 */
public OrganizationVO getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:15:00)
 * @return java.lang.String
 */
public java.lang.String getRatecalcrule() {
	return ratecalcrule;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:15:48)
 * @return java.lang.Integer
 */
public java.lang.Short getRatecalcruleday() {
	return ratecalcruleday;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:16:30)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRatedelta() {
	return ratedelta;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:09:59)
 * @return java.lang.String
 */
public java.lang.String getReportPeriod() {
	return reportPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:40:38)
 * @return java.sql.Date
 */
public Date getStartDate() {
	return startDate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:13:08)
 * @return java.math.BigDecimal
 */
public BigDecimal getSumm1() {
	return summ1;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:13:49)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm2() {
	return summ2;
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 10:48:27)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initCurrency1(CDBCRowObject ro) {
	if (ro.getColumn("currency1").asObject() != null) {
		CurrencyVO curr1 = new CurrencyVO((Integer) ro.getColumn("currency1").asObject());
		//curr1.setName(ro.getColunm("").toString());
		curr1.setShortname(ro.getColumn("curr1name").asString());
		setCurrency1(curr1);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 10:48:51)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initCurrency2(CDBCRowObject ro) {
	if (ro.getColumn("currency2").asObject() != null) {
		CurrencyVO curr2 = new CurrencyVO((Integer) ro.getColumn("currency2").asObject());
		//curr2.setName(ro.getColunm("").toString());
		curr2.setShortname(ro.getColumn("curr2name").asString());
		setCurrency2(curr2);
	}
}
/**
 * Creation date: (29.03.2004 10:35:08)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initOrgCustomer(CDBCRowObject ro) {
	if (ro.getColumn("orgcustomer").asObject() != null) {
		OrganizationVO orgCust = new OrganizationVO((Integer) ro.getColumn("orgcustomer").asObject());
		orgCust.setShortname(ro.getColumn("orgcustomername").asString());
		orgCust.setInn(ro.getColumn("orgcustomerinn").asString());
		setOrgCustomer(orgCust);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.03.2004 10:36:24)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initOrgExecutor(CDBCRowObject ro) {
	if (ro.getColumn("orgexecutor").asObject() != null) {
		OrganizationVO orgExec = new OrganizationVO((Integer) ro.getColumn("orgexecutor").asObject());
		orgExec.setShortname(ro.getColumn("orgexecutorname").asString());
		setOrgExecutor(orgExec);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2005 18:42:15)
 * @param newChargeNds java.lang.String
 */
public void setChargeNds(java.lang.String newChargeNds) {
	chargeNds = newChargeNds;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:34:36)
 * @param newContractState java.lang.String
 */
public void setContractState(java.lang.String newContractState) {
	contractState = newContractState;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:34:18)
 * @param newContractType java.lang.String
 */
public void setContractType(java.lang.String newContractType) {
	contractType = newContractType;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:11:32)
 * @param newCurrency1 java.lang.Integer
 */
public void setCurrency1(CurrencyVO newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:12:14)
 * @param newCurrency2 java.lang.Integer
 */
public void setCurrency2(CurrencyVO newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:38:39)
 * @param newCustName java.lang.String
 */
public void setCustName(java.lang.String newCustName) {
	custName = newCustName;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:56:08)
 * @param newDocComment java.lang.String
 */
public void setDocComment(java.lang.String newDocComment) {
	docComment = newDocComment;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:55:27)
 * @param newDocFileName java.lang.String
 */
public void setDocFileName(java.lang.String newDocFileName) {
	docFileName = newDocFileName;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:57:50)
 * @param newDocSubject java.lang.String
 */
public void setDocSubject(java.lang.String newDocSubject) {
	docSubject = newDocSubject;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:54:01)
 * @param newDocText java.lang.String
 */
public void setDocText(java.lang.String newDocText) {
	docText = newDocText;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:10:41)
 * @param newEconomist java.lang.Integer
 */
public void setEconomist(java.lang.Integer newEconomist) {
	economist = newEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 15:28:28)
 * @param newEconomistVO com.hps.july.arenda.valueobject.WorkerVO
 */
public void setEconomistVO(WorkerVO newEconomistVO) {
	economistVO = newEconomistVO;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:41:25)
 * @param newEndDate java.sql.Date
 */
public void setEndDate(java.sql.Date newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:39:25)
 * @param newExecName java.lang.String
 */
public void setExecName(java.lang.String newExecName) {
	execName = newExecName;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:09:11)
 * @param newExtendPeriod java.lang.String
 */
public void setExtendPeriod(java.lang.String newExtendPeriod) {
	extendPeriod = newExtendPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 10:59:27)
 * @param newExtendType java.lang.String
 */
public void setExtendType(java.lang.String newExtendType) {
	extendType = newExtendType;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:12:17)
 * @param newManagerVO com.hps.july.arenda.valueobject.WorkerVO
 */
public void setManagerVO(WorkerVO newManagerVO) {
	managerVO = newManagerVO;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:37:03)
 * @param newOrgCustomer java.lang.Integer
 */
public void setOrgCustomer(OrganizationVO newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:37:45)
 * @param newOrgExecutor java.lang.Integer
 */
public void setOrgExecutor(OrganizationVO newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:15:00)
 * @param newRatecalcrule java.lang.String
 */
public void setRatecalcrule(java.lang.String newRatecalcrule) {
	ratecalcrule = newRatecalcrule;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:15:48)
 * @param newRatecalcruleday java.lang.Short
 */
public void setRatecalcruleday(java.lang.Short newRatecalcruleday) {
	ratecalcruleday = newRatecalcruleday;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:16:30)
 * @param newRatedelta java.math.BigDecimal
 */
public void setRatedelta(java.math.BigDecimal newRatedelta) {
	ratedelta = newRatedelta;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:09:59)
 * @param newReportPeriod java.lang.String
 */
public void setReportPeriod(java.lang.String newReportPeriod) {
	reportPeriod = newReportPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (24.03.2004 19:40:38)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(Date newStartDate) {
	startDate = newStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:13:08)
 * @param newSumm1 java.math.BigDecimal
 */
public void setSumm1(BigDecimal newSumm1) {
	summ1 = newSumm1;
}
/**
 * Insert the method's description here.
 * Creation date: (25.03.2004 11:13:49)
 * @param newSumm2 java.math.BigDecimal
 */
public void setSumm2(java.math.BigDecimal newSumm2) {
	summ2 = newSumm2;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	String str = "LeaseContract: ContractType=" + getContractType() + "; docComment=" + getDocComment() + "; ";
	// This implementation forwards the message to super. You may replace or supplement this.
	return  str + super.toString();
}
	/**
	 * @return
	 */
	public Date getDateclose() {
		return dateclose;
	}

	/**
	 * @param date
	 */
	public void setDateclose(Date date) {
		dateclose = date;
	}

}
