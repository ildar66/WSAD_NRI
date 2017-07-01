package com.hps.july.arenda.formbean;

import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.naming.NamingException;

import org.apache.struts.action.ActionErrors;

import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.persistence.LeaseDocumentKey;
import com.hps.july.persistence.LeaseOnPositionAccessBean;
import com.hps.july.persistence.Position;
import com.hps.july.persistence.PositionAccessBean;

/**
* Привязка позиций БС к договорам и доп соглашениям аренды .
* Creation date: (28.04.2005 10:10:12)
* @author: Shafigullin Ildar
*/
public class ArendaPositionDialogForm extends com.hps.july.web.util.EditForm {
    private java.lang.Integer lookupCode = null; //для операций с "Позиции размещения БС". 
	private int leaseDocument = -1;//код документа.
	private java.lang.String returnForm = null;//куда возвращаться
/**
  * Добавление позиции БС.
 * Creation date: (28.04.2005 11:27:41)
 */
private void addPositionFromLookup() {
    if (lookupCode != null) {
        try {
            // Включаем позицию:
            LeaseOnPositionAccessBean lopBean = new LeaseOnPositionAccessBean(new Integer(leaseDocument), lookupCode);
        } catch (javax.ejb.DuplicateKeyException dke) {
            System.out.println("ArendaPositionDialogForm :  Позиция уже включена: (" + leaseDocument + "," + lookupCode + ")");
            //dke.printStackTrace(System.out);
        } catch (Exception e) {
            // Позиция создаться не может(или)
            System.out.println("ArendaPositionDialogForm : Can't add position(" + leaseDocument + "," + lookupCode + ")");
            e.printStackTrace(System.out);
        }
    } else {
        System.out.println("ArendaPositionDialogForm:  lookupCode  = null");
    }
}
/**
 * Метод очищает главную позицию в договоре.
 * Creation date: (13.02.2002 10:17:44)
 */
public void afterDelete(javax.servlet.http.HttpServletRequest request) throws Exception {
    LeaseArendaAgreementNewAccessBean ab = new LeaseArendaAgreementNewAccessBean();
    ab.setInitKey_leaseDocument(getLeaseDocument());
    ab.refreshCopyHelper();
    try {
		PositionAccessBean position = ab.getMainposition();
		if (position != null) {
			int storageplace = position.getStorageplace();
			if (getLookupCode() == null || storageplace == getLookupCode().intValue()) {
				ab.setMainposition(null); 
			}
		} 
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("!!! e.getClass()=" + e.getClass() + " e.toString()= "+ e.toString());
	}
}
/**
 * Текущее приложение.
 * Creation date: (28.04.2005 10:10:12)
 * @return int
 */
public int getApplication() {
    return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2005 11:30:24)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2005 11:29:24)
 * @return java.lang.Integer
 */
public java.lang.Integer getLookupCode() {
	return lookupCode;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2005 12:06:29)
 * @return java.lang.String
 */
public java.lang.String getReturnForm() {
	return returnForm;
}
/**
 * Текущее состояние приложения.
 * Creation date: (28.04.2005 10:10:12)
 * @return int
 */
public int getState() {
	return 0;
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	if(getLookupCode() != null){
		LeaseOnPositionAccessBean bean = new LeaseOnPositionAccessBean();
		bean.setInitKey_leaseArendaAgreementNew_leaseDocument(new Integer(getLeaseDocument()));
		bean.setInitKey_position_storageplace(getLookupCode());
		bean.getEJBRef().remove();
	}else{
		Enumeration e = new LeaseOnPositionAccessBean().findLeaseonpositionsByLeaseArendaAgreementNew(new LeaseDocumentKey(getLeaseDocument()));
		while (e.hasMoreElements()) {
			LeaseOnPositionAccessBean ab = (LeaseOnPositionAccessBean) e.nextElement();
			ab.getEJBRef().remove();		
		}
	}
	afterDelete(request);
	return returnForm;
}

/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    addPositionFromLookup();
    return returnForm;
}
/**
 * Изменение главной позиции:
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    try {
        LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
        bean.setInitKey_leaseDocument(getLeaseDocument());
        bean.refreshCopyHelper();
        PositionAccessBean positionAB = new PositionAccessBean();
        positionAB.setInitKey_storageplace(getLookupCode().intValue());
        positionAB.refreshCopyHelper();
        bean.setMainposition((Position) positionAB.getEJBRef());
        bean.refreshCopyHelper();
    } catch (Exception e) {
        e.printStackTrace(System.out);
        // Errors during change
        //ActionErrors errors = new ActionErrors();
        //errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.change.positionMain"));
        //saveErrors(request, errors);
    }
    return returnForm;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2005 11:30:24)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2005 11:29:24)
 * @param newLookupCode java.lang.Integer
 */
public void setLookupCode(java.lang.Integer newLookupCode) {
	lookupCode = newLookupCode;
}
/**
 * Insert the method's description here.
 * Creation date: (28.04.2005 12:06:29)
 * @param newReturnForm java.lang.String
 */
public void setReturnForm(java.lang.String newReturnForm) {
	returnForm = newReturnForm;
}
}
