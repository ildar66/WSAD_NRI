package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import java.util.ArrayList;
import com.hps.july.persistence.*;
/**
 * Form-Bean "для печати Служебных записок"
 * Creation date: (28.07.2004 14:31:50)
 * @author: Shafigullin Ildar
 */
public class MemoWordForm extends ActionForm {
	private int idHeader;
	private Memo_VO memo;
	private com.hps.july.persistence.LeaseContractAccessBean arendaContractVO;
	private com.hps.july.persistence.AbonentBillAccessBean leasebillVO;
	private boolean detach = false;
	private LeaseAbonentBANAccessBean abonent;
/**
 * Insert the method's description here.
 * Creation date: (31.10.2005 10:57:36)
 * @return com.hps.july.persistence.LeaseAbonentBANAccessBean
 */
public com.hps.july.persistence.LeaseAbonentBANAccessBean getAbonent() {
	return abonent;
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 15:46:18)
 * @return com.hps.july.persistence.LeaseContractAccessBean
 */
public com.hps.july.persistence.LeaseContractAccessBean getArendaContractVO() {
	return arendaContractVO;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 15:25:38)
 * @return int
 */
public int getIdHeader() {
	return idHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 16:58:15)
 * @return com.hps.july.persistence.AbonentBillAccessBean
 */
public com.hps.july.persistence.AbonentBillAccessBean getLeasebillVO() {
	return leasebillVO;
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2004 18:00:01)
 */
private ArrayList getListMemoPosForMemo(Integer idHeader) {
	CDBCResultSet rs = CDBC_MemoPos_Object.findListMemoPos(idHeader);
	java.util.ListIterator it = rs.listIterator();
	ArrayList resultList = new ArrayList();
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject) it.next();
		com.hps.july.arenda.valueobject.MemoPos_VO vo = new com.hps.july.arenda.valueobject.MemoPos_VO(ro);
		//System.out.println(vo);
		resultList.add(vo);
	}
	return resultList;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 15:26:00)
 * @return com.hps.july.arenda.valueobject.Memo_VO
 */
public Memo_VO getMemo() {
	return memo;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 15:38:11)
 */
public void init() throws Exception {
    CDBCRowObject res = null;
    if (detach)
        res = CDBC_Memo_Object.findMemoDetach(getIdHeader());
    else
        res = CDBC_Memo_Object.findMemo(getIdHeader());
    if (res != null) {
        memo = new Memo_VO(res);
        if (detach)
            memo.initDetachInfo(res);
        res = CDBC_Memo_Object.findMemoTarget(memo.getTarget().intValue());
        memo.setTargetVO(new MemoTarget_VO(res));
        memo.setListMemoPos(getListMemoPosForMemo(memo.getIdHeader()));
        if (memo.getType().equalsIgnoreCase("1") && memo.getArendaContract() != null)
            initArendaContractVO(memo.getArendaContract());
        else if (memo.getType().equalsIgnoreCase("2") && memo.getArendaContract() != null)
            initArendaContractVO(memo.getArendaContract());
        else if (memo.getType().equalsIgnoreCase("3") && memo.getArendaContract() != null)
            initArendaContractVO(memo.getArendaContract());
        else if (memo.getType().equalsIgnoreCase("5") && memo.getArendaContract() != null)
            initArendaContractVO(memo.getArendaContract());
        else if (memo.getType().equalsIgnoreCase("6") && memo.getArendaContract() != null)
            initArendaContractVO(memo.getArendaContract());
        else if (memo.getType().equalsIgnoreCase("8") && memo.getArendaContract() != null)
            initArendaContractVO(memo.getArendaContract());
        else if (memo.getType().equalsIgnoreCase("9") && memo.getArendaContract() != null)
            initArendaContractVO(memo.getArendaContract());
        else if (memo.getType().equalsIgnoreCase("A") && memo.getLeasebill() != null)
            initLeasebillVO(memo.getLeasebill());
        else if (memo.getType().equalsIgnoreCase("D") && memo.getArendaContract() != null)
            initArendaContractVO(memo.getArendaContract());
        else if (memo.getType().equalsIgnoreCase("F") && memo.getAbonentContract() != null) {
            initAbonent(memo.getAbonentContract());
        } else if (memo.getType().equalsIgnoreCase("J") && memo.getAbonentContract() != null) {
            initAbonent(memo.getAbonentContract());
            if (memo.getLeasebill() != null)
                initLeasebillVO(memo.getLeasebill());
        }
    } else {
        System.out.println("Нет записи с idHeader=" + getIdHeader());
        throw new Exception("Нет записи с idHeader=" + getIdHeader());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2005 10:57:56)
 */
private void initAbonent(Integer leaseDocument) {
    abonent= new LeaseAbonentBANAccessBean();
    abonent.setInitKey_leaseDocument(leaseDocument.intValue());
 }
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 15:23:28)
 * @param contractID java.lang.Integer
 */
private void initArendaContractVO(Integer contractID) {
	arendaContractVO = new LeaseContractAccessBean();
	arendaContractVO.setInitKey_leaseDocument(contractID.intValue());
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 16:56:13)
 * @param leaseBillID java.lang.Integer
 */
private void initLeasebillVO(Integer leaseBillID) {
	leasebillVO = new AbonentBillAccessBean();
	leasebillVO.setInitKey_leasebill(leaseBillID.intValue());
}
/**
 * Insert the method's description here.
 * Creation date: (14.03.2005 16:03:53)
 * @return boolean
 */
public boolean isDetach() {
	return detach;
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2005 10:57:36)
 * @param newAbonent com.hps.july.persistence.LeaseAbonentBANAccessBean
 */
public void setAbonent(com.hps.july.persistence.LeaseAbonentBANAccessBean newAbonent) {
	abonent = newAbonent;
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 15:46:18)
 * @param newArendaContractVO com.hps.july.persistence.LeaseContractAccessBean
 */
public void setArendaContractVO(com.hps.july.persistence.LeaseContractAccessBean newArendaContractVO) {
	arendaContractVO = newArendaContractVO;
}
/**
 * Insert the method's description here.
 * Creation date: (14.03.2005 16:03:53)
 * @param newDetach boolean
 */
public void setDetach(boolean newDetach) {
	detach = newDetach;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 15:25:38)
 * @param newIdHeader int
 */
public void setIdHeader(int newIdHeader) {
	idHeader = newIdHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 16:58:15)
 * @param newLeasebillVO com.hps.july.persistence.AbonentBillAccessBean
 */
public void setLeasebillVO(com.hps.july.persistence.AbonentBillAccessBean newLeasebillVO) {
	leasebillVO = newLeasebillVO;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 15:26:00)
 * @param newMemo com.hps.july.arenda.valueobject.Memo_VO
 */
public void setMemo(Memo_VO newMemo) {
	memo = newMemo;
}
}
