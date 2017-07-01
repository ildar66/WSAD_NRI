package com.hps.july.arenda.formbean;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.arenda.cdbcobjects.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.valueobject.Vendor_VO;
/**
 * Insert the type's description here.
 * Creation date: (11.11.2005 16:18:55)
 * @author: Shafigullin Ildar
 */
public class LoanAktGetPutWordForm extends WordForm {
    private int id;
    private LoanAktGetPut_TO to;
    private LoanContractVO loanContractVO;
    private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private boolean isFiz;
/**
 * Insert the method's description here.
 * Creation date: (14.11.2005 17:07:44)
 */
public String getAktAbonentBillInfo() {
    if (to.getVo() != null && to.getVo().getIdLeasebill() != null) {
        CDBCRowObject ro = CDBC_AbonentBills_Object.findAbonentBill(to.getVo().getIdLeasebill().intValue());
        AbonentBill_VO vo = new AbonentBill_VO(ro);
        return "№ " + vo.getBillnumber() + " от " + format.format(vo.getBilldate());
    }
    return "";
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2005 17:30:16)
 * @return int
 */
public int getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2005 18:36:47)
 * @return boolean
 */
public boolean getIsFiz() {
	return isFiz;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2005 19:28:08)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getListBillPos() {
    java.util.Enumeration enum = null;
    try {
        Integer keyLeasebill = to.getVo().getIdLeasebill();
        enum = new com.hps.july.persistence.AbonentBillPosAccessBean().findByLeaseBill(keyLeasebill);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return enum;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2005 16:28:08)
 * @return com.hps.july.arenda.valueobject.LoanContractVO
 */
public com.hps.july.arenda.valueobject.LoanContractVO getLoanContractVO() {
	return loanContractVO;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2005 12:41:31)
 * @return com.hps.july.arenda.valueobject.LoanAktGetPut_TO
 */
public com.hps.july.arenda.valueobject.LoanAktGetPut_TO getTo() {
	return to;
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2005 16:18:55)
 */
public void init(HttpServletRequest request) throws Exception {
    to = com.hps.july.arenda.cdbcobjects.CDBC_LoanAktGetPut_Object.find(getId());
    loanContractVO = CDBC_LoanContract_Object.find(to.getVo().getLoanContract().intValue());
    //определяем кто orgCustomer (физ. или юр. лицо?)
    Integer orgKey = loanContractVO.getOrgCustomer().getOrganization();
    //setIsFiz(com.hps.july.arenda.cdbcobjects.CDBC_Person_Object.find(orgKey.intValue()) != null);
    Integer vendorType = CDBC_VendorSite_Object.findTO(orgKey).getVendor_VO().getTypeVendor();
	setIsFiz(vendorType.intValue() == Vendor_VO.TYPE_VENDOR_PHYSICAL);
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2005 17:30:16)
 * @param newId int
 */
public void setId(int newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2005 18:36:47)
 * @param newIsFiz boolean
 */
private void setIsFiz(boolean newIsFiz) {
	isFiz = newIsFiz;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2005 16:28:08)
 * @param newLoanContractVO com.hps.july.arenda.valueobject.LoanContractVO
 */
private void setLoanContractVO(com.hps.july.arenda.valueobject.LoanContractVO newLoanContractVO) {
	loanContractVO = newLoanContractVO;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2005 12:41:31)
 * @param newTo com.hps.july.arenda.valueobject.LoanAktGetPut_TO
 */
private void setTo(com.hps.july.arenda.valueobject.LoanAktGetPut_TO newTo) {
	to = newTo;
}
}
