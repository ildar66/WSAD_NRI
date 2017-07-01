package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.arenda.cdbcobjects.*;
import com.hps.july.persistence.*;
import com.hps.july.util.*;
import com.hps.july.logic.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.*;
/**
* Insert the type's description here.
* Creation date: (20.06.2005 17:42:07)
* @author: Shafigullin Ildar
*/
public class RateListForm extends com.hps.july.web.util.BrowseForm {
    private int docpositioncode;
	private LeaseCalcRate_VO rateVO;
	private java.lang.String operation;
	private int currencycode;
	private StringAndSqlDateProperty ratedatecalc;
	private java.lang.String headerUpdLeaseRates;
	private java.util.ArrayList currencies;
	private int isCalcAct;
/**
 * RateListForm constructor comment.
 */
public RateListForm() {
    super();
    setFinderMethodName("findListLeaseCalcRates");
    initRateVO();
    operation = "";
    currencycode = -1;
    ratedatecalc = new StringAndSqlDateProperty();
    initCurrencies();
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 18:07:15)
 */
private void addRateVO() {
    if (rateVO != null && rateVO.getLeaseDocPosition() == null) {
        try {
            rateVO.setLeaseDocPosition(new Integer(getDocpositioncode()));
            boolean ok = CDBC_LeaseCalcRates_Object.addLeaseCalcRate(getRateVO());
            if (!ok) {
                String errorStr = "Ошибка добавления записи: rateVO" + rateVO;
                System.out.println(errorStr);
                //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
            }
        } catch (Exception e) {
            System.out.println("RateListForm.addRate():errorTxt: " + e);
            //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
            e.printStackTrace();
        }
        //инициализируем позицию:
        initRateVO();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 17:32:11)
 */
private void calcRateOnDate() {
    if (rateVO != null && getRatedatecalc() != null) {
        Integer typeRate = new Integer(1);
        RateOnDate_VO vo =  CDBC_LeaseCalcRates_Object.getRateOnDate(rateVO.getCurrencyVO().getCurrency(), getRatedatecalc(), typeRate);
        rateVO.setRate(vo.getRate());
    }
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
		System.out.println("RateListForm: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	CDBCRowObject ro =(CDBCRowObject) o;
	LeaseCalcRate_VO vo = new LeaseCalcRate_VO(ro);
	vo.setSumLeaseCalcRate(ro.getColumn("sumleasecalcrate").asString());

	return vo; 
}
private void deleteRateVO() {
    if (rateVO != null) {
        try {
            boolean ok =
                CDBC_LeaseCalcRates_Object.deleteLeaseCalcRate(new Integer(getDocpositioncode()), new Integer(getCurrencycode()));
            if (!ok) {
                String errorStr = "Ошибка удаления записи RateListForm";
                System.out.println(errorStr);
                //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
            }
        } catch (Exception e) {
            System.out.println("RateListForm.deleteRateVO():errorTxt: " + e);
            //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
            e.printStackTrace();
        }
        //инициализируем позицию:
        initRateVO();
    }
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
    return "com.hps.july.arenda.cdbcobjects.CDBC_LeaseCalcRates_Object";
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 18:52:36)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getCurrencies() {
	return currencies;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 15:22:45)
 */
public java.util.Enumeration getCurrenciesOld() {
	try {
		return new CurrencyAccessBean().findAllOrderByNameAsc();
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 11:41:18)
 * @return int
 */
public int getCurrencycode() {
	return currencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:43:29)
 * @return int
 */
public int getDocpositioncode() {
	return docpositioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 12:26:28)
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("ArendaMainEconomist");
	roles.add("ArendaEconomist");
	roles.add("administrator");
	return roles;
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (20.06.2005 17:42:07)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
    return new Object[] { new Integer(getDocpositioncode()), "tempOrderBy" };
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 18:19:35)
 * @return java.lang.String
 */
public java.lang.String getHeaderUpdLeaseRates() {
	return headerUpdLeaseRates;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 12:13:33)
 * @return int
 */
public int getIsCalcAct() {
	return isCalcAct;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 17:25:58)
 * @return java.lang.String
 */
public java.lang.String getOperation() {
	return operation;
}
public java.sql.Date getRatedatecalc() {
	return ratedatecalc.getSqlDate();
}
public String getRatedatecalcFrm() {
	return ratedatecalc.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 17:43:06)
 */
public String getRateStr() {
    if (rateVO != null && rateVO.getRate() != null)
        return rateVO.getRate().toString();
    else
        return null;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 15:35:45)
 * @return com.hps.july.arenda.valueobject.LeaseCalcRate_VO
 */
public com.hps.july.arenda.valueobject.LeaseCalcRate_VO getRateVO() {
	return rateVO;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    ParamsParser.setState(request, Applications.ARENDA, APPStates.RATE_LIST);
    if (operation.equalsIgnoreCase("addRateVO")) {
        addRateVO();
        setCurrencycode(-1);
    } else if (operation.equalsIgnoreCase("setRateVO")) {
        setRateVO();
    } else if (operation.equalsIgnoreCase("updateRateVO")) {
        updateRateVO();
        setCurrencycode(-1);
    } else if (operation.equalsIgnoreCase("deleteRateVO")) {
        deleteRateVO();
        setCurrencycode(-1);
    } else if (operation.equalsIgnoreCase("calcRateOnDate")) {
 		calcRateOnDate();
     } else {
        initRateVO();
        setCurrencycode(-1);
    }
    setOperation("");
    return null;
}
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
        System.out.println("RateListForm.initCurrencies(): Ошибка формирования листа валют!!!");
        e.printStackTrace(System.out);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 18:19:13)
 */
private void initHeaderUpdLeaseRates() {
    Object[] ret = CDBC_LeaseCalcRates_Object.getHeaderUpdLeaseRates(new Integer(getDocpositioncode()));
    headerUpdLeaseRates = (String) ret[0];
    isCalcAct = ((Integer) ret[1]).intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 18:19:25)
 */
private void initRateVO() {
    LeaseCalcRate_VO vo = new LeaseCalcRate_VO();
    vo.setCurrencyVO(new CurrencyVO(new Integer(-1)));
    vo.setByhand("Y");
    vo.setSource(new Integer(0));
    setRateVO(vo);
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 18:52:36)
 * @param newCurrencies java.util.ArrayList
 */
public void setCurrencies(java.util.ArrayList newCurrencies) {
	currencies = newCurrencies;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 11:41:18)
 * @param newCurrencycode int
 */
public void setCurrencycode(int newCurrencycode) {
	currencycode = newCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2005 18:43:29)
 * @param newDocpositioncode int
 */
public void setDocpositioncode(int newDocpositioncode) {
	docpositioncode = newDocpositioncode;
	initHeaderUpdLeaseRates();
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 18:19:35)
 * @param newHeaderUpdLeaseRates java.lang.String
 */
public void setHeaderUpdLeaseRates(java.lang.String newHeaderUpdLeaseRates) {
	headerUpdLeaseRates = newHeaderUpdLeaseRates;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 12:13:33)
 * @param newIsCalcAct int
 */
public void setIsCalcAct(int newIsCalcAct) {
	isCalcAct = newIsCalcAct;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 17:25:58)
 * @param newOperation java.lang.String
 */
public void setOperation(java.lang.String newOperation) {
	operation = newOperation;
}
public void setRatedatecalc(java.sql.Date newRatedate) {
	ratedatecalc.setSqlDate(newRatedate);
}
public void setRatedatecalcFrm(String newRatedate) {
	ratedatecalc.setString(newRatedate);
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 17:40:17)
 */
public void setRateStr(String rateStr) {
    if (rateVO != null && rateStr != null && !rateStr.equals("")) {
        try {
            rateVO.setRate(new java.math.BigDecimal(rateStr));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace(System.out);
        }
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2005 11:24:36)
 */
private void setRateVO() {
    //устанавливаем rateVO:
    rateVO =  CDBC_LeaseCalcRates_Object.findLeaseCalcRate(new Integer(getDocpositioncode()), new Integer(getCurrencycode()));
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 15:35:45)
 * @param newRateVO com.hps.july.arenda.valueobject.LeaseCalcRate_VO
 */
public void setRateVO(com.hps.july.arenda.valueobject.LeaseCalcRate_VO newRateVO) {
	rateVO = newRateVO;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 18:10:05)
 */
private void updateRateVO() {
    if (rateVO != null) {
	    rateVO.setSource(new Integer(0));
	    rateVO.setByhand("Y");
        try {
             boolean ok = CDBC_LeaseCalcRates_Object.editLeaseCalcRate(getRateVO());
            if (!ok) {
                String errorStr = "Ошибка редактирования записи: rateVO:id=" + rateVO.getLeaseDocPosition();
                System.out.println(errorStr);
                //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
            }
        } catch (Exception e) {
            System.out.println("RateListForm.updateRate():errorTxt: " + e);
            //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", e));
            e.printStackTrace();
        }
        //инициализируем позицию:
        initRateVO();
    }
}
}
