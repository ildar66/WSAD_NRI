package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import com.hps.july.logic.DataPeriod;
import com.hps.july.dictionary.valueobject.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.hps.july.constants.Applications;
import java.util.*;
/**
 * Форма списка курсов валют
 */
public class CurrateListForm extends com.hps.july.web.util.BrowseForm {
    private java.lang.String sortBy; //признак сортировки
    private java.lang.Boolean isDataPeriod;
    private DataPeriod dataPeriod;
    private Boolean isCurrency;
    private CurrencyVO currency;
	private RateType_VO rateType;
	private java.util.ArrayList currencies;
	private java.util.ArrayList ratetypes;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public CurrateListForm() {
    this.setFinderMethodName("findListRates");
    sortBy = "date desc";
    dataPeriod = new DataPeriod();
    isDataPeriod = Boolean.TRUE;
    isCurrency = Boolean.FALSE;
    rateType = new RateType_VO(new Integer(1));
    rateType.setName("Курс ЦБ РФ ");
    //инициализация валюты условным значением:
    currency = new CurrencyVO(new Integer(-1)); 
    currency.setName("Все");
    initCurrencies();
    initRatetypes();
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
		System.out.println("CurrateListForm: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	CDBCRowObject ro =(CDBCRowObject) o;
	Integer iCurrency = (Integer)ro.getColumn("currency").asObject();
	String curName = ro.getColumn("currname").asString();
	CurrencyVO iCurrencyVO = new CurrencyVO(iCurrency);
	iCurrencyVO.setName(curName);
	Integer iRatetype = (Integer)ro.getColumn("ratetype").asObject();
	Rates_VO vo = new Rates_VO(iCurrencyVO, iRatetype);
	vo.setDate((java.sql.Date)ro.getColumn("date").asObject());
	vo.setValue((java.math.BigDecimal)ro.getColumn("value").asObject());

	return vo; 
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_Rates_Object"; 
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2005 11:59:37)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getCurrencies() {
	return currencies;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @return CurrencyVO
 */
public CurrencyVO getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @return com.hps.july.logic.DataPeriod
 */
public com.hps.july.logic.DataPeriod getDataPeriod() {
	return dataPeriod;
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictResAdmin");
	//roles.add("dictResOperator");
	roles.add("dictCurrateOperator");
	roles.add("ArendaMainEconomist");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] {
        rateType.getRatetype(),
        (getCurrency().getCurrency().intValue() == -1) ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE,        currency.getCurrency(),
        isDataPeriod,        dataPeriod.getFromDate(),        dataPeriod.getToDate(),
        getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsCurrency() {
	return isCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDataPeriod() {
	return isDataPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @return com.hps.july.dictionary.valueobject.RateType_VO
 */
public com.hps.july.dictionary.valueobject.RateType_VO getRateType() {
	return rateType;
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2005 14:07:03)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getRatetypes() {
	return ratetypes;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.DICTIONARY, com.hps.july.dictionary.APPStates.CRTLIST);
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2005 10:54:39)
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
        setCurrencies(listCurrencies) ;
    } catch (Exception e) {
        System.out.println("CurrateListForm.initCurrencies(): Ошибка формирования листа валют!!!");
        e.printStackTrace(System.out);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2005 14:11:53)
 */
private void initRatetypes() {
/**	
    try {
        ArrayList listRatetypes = new ArrayList();
        RateTypeAccessBean bean = new RateTypeAccessBean();
        Enumeration enum = bean.findAllOrderByNameAsc();
        while (enum.hasMoreElements()) {
            RateTypeAccessBean ab = (RateTypeAccessBean) enum.nextElement();
            RateType_VO vo = new RateType_VO(new Integer(ab.getRatetype()));
            vo.setName(ab.getName());
            listRatetypes.add(vo);	        
        }
 		setRatetypes(listRatetypes);
    } catch (Exception e) {
        System.out.println("CurrateListForm.initRatetypes(): Ошибка формирования листа валют!!!");
        e.printStackTrace(System.out);
    }
*/
	setRatetypes(CDBC_RateTypes_Object.getListRateTypes());    
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2005 11:59:37)
 * @param newCurrencies java.util.ArrayList
 */
private void setCurrencies(java.util.ArrayList newCurrencies) {
	currencies = newCurrencies;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @param newCurrency CurrencyVO
 */
public void setCurrency(CurrencyVO newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @param newDataPeriod com.hps.july.logic.DataPeriod
 */
public void setDataPeriod(com.hps.july.logic.DataPeriod newDataPeriod) {
	dataPeriod = newDataPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @param newIsCurrency java.lang.Boolean
 */
public void setIsCurrency(java.lang.Boolean newIsCurrency) {
	isCurrency = newIsCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @param newIsDataPeriod java.lang.Boolean
 */
public void setIsDataPeriod(java.lang.Boolean newIsDataPeriod) {
	isDataPeriod = newIsDataPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @param newRateType com.hps.july.dictionary.valueobject.RateType_VO
 */
public void setRateType(com.hps.july.dictionary.valueobject.RateType_VO newRateType) {
	rateType = newRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2005 14:07:03)
 * @param newRatetypes java.util.ArrayList
 */
private void setRatetypes(java.util.ArrayList newRatetypes) {
	ratetypes = newRatetypes;
}
/**
 * Insert the method's description here.
 * Creation date: (04.04.2005 17:03:42)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 10:50:26)
 * @param errors org.apache.struts.action.ActionErrors
 * @exception java.lang.Exception The exception description.
 */
public void validateValues(ActionErrors errors) throws java.lang.Exception {
/**	
	if(ratetype<=0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.currate.ratetype"));
	}	
	if(date.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.currate.date"));
	}
	if (!date.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.currate.date"));
	}
	
	if (!errors.empty())
		throw new ValidationException();
*/		
}
}
