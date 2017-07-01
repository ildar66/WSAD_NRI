package com.hps.july.arenda.formbean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.constants.Applications;
import com.hps.july.arenda.APPStates;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.lib.*;
import java.math.*;
/**
 * Form-Bean "Связывает заказы на приобретение из NFS с договором аренды".
 * Creation date: (02.07.2004 11:38:28)
 * @author: Shafigullin Ildar
 */
public class ArendaToNfsZpListForm extends BrowseForm {
	private int leaseDocument;
	private java.lang.Integer idZpNfs; //уникальный код ЗП
	private LeaseArendaAgreementNewVO agreement;
/**
 * ArendaToNfsZpListForm constructor comment.
 */
public ArendaToNfsZpListForm() {
	setAction("View");
	setFinderMethodName("findListZP_NFS_forArendaAgreement");
	agreement = new LeaseArendaAgreementNewVO(new LeaseArendaAgrmntVO());
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
		System.out.println("ArendaToNfsZpListForm: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	return new NFS_ZP_forArendaAgreement_VO((CDBCRowObject)o);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:44:27)
 * @return com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO
 */
public com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO getAgreement() {
	return agreement;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_NFS_Object"; 
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (02.07.2004 11:38:28)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {agreement.getO().getMainLeaseDocument()};
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2004 12:57:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdZpNfs() {
	return idZpNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2004 11:42:49)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
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
	agreement = new LeaseArendaAgreementNewVO(new LeaseArendaAgrmntVO());
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2004 11:44:27)
 * @param newAgreement com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO
 */
public void setAgreement(com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO newAgreement) {
	agreement = newAgreement;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2004 12:57:49)
 * @param newIdZpNfs java.lang.Integer
 */
public void setIdZpNfs(java.lang.Integer newIdZpNfs) {
	idZpNfs = newIdZpNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2004 11:42:49)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
}
