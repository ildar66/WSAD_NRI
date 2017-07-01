package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import com.hps.july.cdbc.lib.*;

import com.hps.july.arenda.valueobject.*;
import com.hps.july.arenda.cdbcobjects.CDBC_CompletWorkActs_Object;
/**
 * Insert the type's description here.
 * Creation date: (02.11.2004 16:10:48)
 * @author: Shafigullin Ildar
 */
public class CompletWorkAktWordForm extends ActionForm {
	private int idcwacode;
	private CompletWorkAct_VO completWorkActVO;
	private PrintComplectAct_TO printComplectAct_TO;
/**
 * Insert the method's description here.
 * Creation date: (02.11.2004 16:20:25)
 * @return CompletWorkAct_VO
 */
public CompletWorkAct_VO getCompletWorkActVO() {
	return completWorkActVO;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2004 16:20:25)
 * @return int
 */
public int getIdcwacode() {
	return idcwacode;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2005 13:45:33)
 * @return com.hps.july.arenda.valueobject.WorkerVO
 */
public com.hps.july.arenda.valueobject.WorkerVO getLeader() {
	return printComplectAct_TO.getWorkVO();
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2005 14:31:02)
 * @return com.hps.july.arenda.valueobject.OrganizationVO
 */
public com.hps.july.arenda.valueobject.OrganizationVO getOrgCustomer() {
	return printComplectAct_TO.getOrgVO();
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2004 16:19:27)
 * @exception java.lang.Exception The exception description.
 */
public void init() throws java.lang.Exception {
    CDBCRowObject ro = CDBC_CompletWorkActs_Object.findCompletWorkAct(getIdcwacode());
    if (ro != null) {
        completWorkActVO = new CompletWorkAct_VO(ro);
		//setLeader(CDBC_CompletWorkActs_Object.getFioDoljnForAct(completWorkActVO.getIdcwacode()));
		//setOrgCustomer(CDBC_CompletWorkActs_Object.getOrgCustomerForAct(completWorkActVO.getIdcwacode()));
        PrintComplectAct_TO pcaTO = CDBC_CompletWorkActs_Object.getPrintComplectAct_TO(completWorkActVO.getIdcwacode());
		setPrintComplectAct_TO(pcaTO);	
    } else {
        System.out.println("Нет записи CompletWorkAct с idcwacode=" + getIdcwacode());
        throw new Exception("Нет записи CompletWorkAct с idcwacode=" + getIdcwacode());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2004 16:20:25)
 * @param newCompletWorkActVO CompletWorkAct_VO
 */
public void setCompletWorkActVO(CompletWorkAct_VO newCompletWorkActVO) {
	completWorkActVO = newCompletWorkActVO;
}
/**
 * Insert the method's description here.
 * Creation date: (02.11.2004 16:20:25)
 * @param newIdcwacode int
 */
public void setIdcwacode(int newIdcwacode) {
	idcwacode = newIdcwacode;
}
	/**
	 * @return
	 */
	public PrintComplectAct_TO getPrintComplectAct_TO() {
		return printComplectAct_TO;
	}

	/**
	 * @param act_TO
	 */
	private void setPrintComplectAct_TO(PrintComplectAct_TO act_TO) {
		printComplectAct_TO = act_TO;
	}

}
