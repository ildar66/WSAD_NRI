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
import java.sql.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
/**
 * Bean-form "лист отчётов из NFS".
 * Creation date: (01.06.2004 13:41:51)
 * @author: Shafigullin Ildar
 */
public class NFS_ListForm extends BrowseForm {
	private int leaseContract;
	private LeaseArendaAgreementNewVO agreement = new LeaseArendaAgreementNewVO();
	private java.lang.String filter = "";
	private int stateFilter = 4;
	private int checkCode = 0;
	private java.lang.String remoteUser;
	private int movePayNfsFlag = -1;
	private java.lang.String sortBy = "datePay desc";//признак сортировки
	private ArrayList listZP;
	private java.lang.Integer idZpNfs = new Integer(-1);
	private java.lang.String listZpStr ="";
	//работаем с разделением по филиалам:
	private Boolean isRegionID = new Boolean(true);
	private Integer regionID = null;	
/**
 * NFS_ListForm constructor comment.
 */
public NFS_ListForm() {
	super();
	setFinderMethodName("findListNFS");
	setStateFilter(4);
}
/**
 * Insert the method's description here./////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * Creation date: (01.06.2004 17:10:32)
 */
private void clearAllParams() {
	agreement = new LeaseArendaAgreementNewVO();
	stateFilter = 0;
	filter = "";
	checkCode = 0;
	movePayNfsFlag = -1;
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
		System.out.println("NFS_LIST: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	return new NFS_VO((CDBCRowObject)o);
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 16:18:29)
 * @return com.hps.july.arenda.valueobject.LeaseArendaAgreementNewVO
 */
public LeaseArendaAgreementNewVO getAgreement() {
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
 * Insert the method's description here.
 * Creation date: (17.06.2004 16:56:21)
 * @return int
 */
public int getCheckCode() {
	return checkCode;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 12:26:51)
 * @return java.lang.String
 */
public java.lang.String getFilter() {
	return filter;
}
/**
 * Возвращает параметры, которые будут подставлятся в метод поиска данных.
 * Creation date: (01.06.2004 13:41:51)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		getStateFilter() == 0 ? Boolean.TRUE : Boolean.FALSE,
		getFilter(),
		getStateFilter() == 1 ? Boolean.TRUE : Boolean.FALSE,
		getFilter(),
		getStateFilter() == 2 ? Boolean.TRUE : Boolean.FALSE,
		getFilter(),
		getStateFilter() == 3 ? Boolean.TRUE : Boolean.FALSE,
		getIdZpNfs(),
		getStateFilter() == 4 ? Boolean.TRUE : Boolean.FALSE,
		getListZpStr(),		
		getStateFilter() == 5 ? Boolean.TRUE : Boolean.FALSE,
		getFilter(),
		getStateFilter() == 6 ? Boolean.TRUE : Boolean.FALSE,
		getFilter(),
		isRegionID, getRegionID(),
		getSortBy()};
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2004 13:01:23)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdZpNfs() {
	return idZpNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 15:24:25)
 * @return int
 */
public int getLeaseContract() {
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2004 12:49:09)
 * @return java.util.ArrayList
 */
public ArrayList getListZP() {
	return listZP;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2004 17:51:22)
 * @return java.lang.String
 */
public java.lang.String getListZpStr() {
	return listZpStr;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2004 11:15:56)
 * @return int
 */
public int getMovePayNfsFlag() {
	return movePayNfsFlag;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2004 15:57:01)
 * @return java.lang.String
 */
public java.lang.String getSortBy() {
	return sortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 12:29:08)
 * @return int
 */
public int getStateFilter() {
	return stateFilter;
}
/**
 * Инициализация режима просмотра списка.
 * Creation date: (22.05.2002 16:35:23)
 * @return ActionForward
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.NFS_LIST);
	initRegionID(request);
	try {
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		bean.setInitKey_leaseDocument(getLeaseContract());
		bean.refreshCopyHelper();

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
	//System.out.println("request.getRemoteUser()="+request.getRemoteUser());
	remoteUser = request.getRemoteUser();
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (28.11.2005 12:31:52)
 */
private void initRegionID(HttpServletRequest request) {
	ProfileAccess profileAccess = getProfileAccess(request);
	if (profileAccess.getCurrRegion() != null) {
		Integer newRegionID = profileAccess.getCurrRegion().getVo().getRegionid();
		setRegionID(newRegionID);
	} else {
		//throw new RuntimeException("нет текущего региона для аренды!!!");
		System.out.println("нет текущего региона для аренды!!!");
		setRegionID(null);
	}    
}
/**
 * 
 * @param request
 * @return
 */
private ProfileAccess getProfileAccess(HttpServletRequest request){
	Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
	if(profile == null){
		throw new RuntimeException("Error:Profile = null");
	}
	ProfileAccess profileAccess= profile.getProfileAccess();
	if(profileAccess == null){
		throw new RuntimeException("Error:profile.getProfileAccess() = null");
	}
	return profileAccess;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2004 13:01:23)
 * @param newIdZpNfs java.lang.Integer
 */
private void initIdZpNfs() {
	ListIterator iter = getListZP().listIterator();
	while (iter.hasNext()) {
		NFS_ZP_forArendaAgreement_VO zp = (NFS_ZP_forArendaAgreement_VO) iter.next();
		if (zp.getIdZpNfs().equals(getIdZpNfs()))
			return;
	}
	//мы перешли к другому документу(или изменили список listZP):
	if (getListZP().isEmpty())
		setIdZpNfs(new Integer(-1));
	else {
		NFS_ZP_forArendaAgreement_VO zp = (NFS_ZP_forArendaAgreement_VO) getListZP().get(0);
		setIdZpNfs(zp.getIdZpNfs());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2004 12:34:14)
 * @param mainDoc int
 */
private void initListZp(int mainDoc) {
	CDBCResultSet rs = CDBC_NFS_Object.findListZP_NFS_forArendaAgreement(new Integer(mainDoc));
	java.util.ListIterator it = rs.listIterator();
	java.util.ArrayList listZP = new java.util.ArrayList();
	StringBuffer bf = new StringBuffer("");
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject) it.next();
		NFS_ZP_forArendaAgreement_VO zp = new NFS_ZP_forArendaAgreement_VO(ro);
		listZP.add(zp);
		//формируем список запроса:
		bf.append(zp.getIdZpNfs());
		if (it.hasNext())
			bf.append(", ");
	}
	this.listZP = listZP;
	setListZpStr(bf.toString());
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 16:57:23)
 * @return java.lang.String
 * @param errors org.apache.struts.action.ActionErrors
 * @param idPayNfs int
 */
private String movePayNfs2Nri(ActionErrors errors, int idPayNfs) {
	Connection con = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	String errorTxt = "";
	try {
		String sql = "execute procedure movePayNfs2Nri(?, ?, ?, ?)";
		con = new JdbcConnection().getConnection();
		cs = con.prepareCall(sql);

		System.out.println("idPayNfs= " + idPayNfs); //temp
		System.out.println("mainLeaseDoc= " + getAgreement().getO().getMainLeaseDocument().intValue()); //temp
		// Set operatorCode:
		int operatorCode = 0;
		try {
			operatorCode = OperatorObject.getOperatorCode(remoteUser).intValue();
		} catch (Exception e) {
			System.out.println("Невозможно присвоить 'operatorCode'."); //temp	
			e.printStackTrace();
		}
		System.out.println("operatorCode= " + operatorCode); //temp			

		cs.setInt(1, idPayNfs); //код платежа в системе NFS
		cs.setInt(2, getAgreement().getO().getMainLeaseDocument().intValue()); //код базового договора аренды NRI		
		cs.setInt(3, operatorCode); //код оператора запустившего процесс
		cs.setInt(4, movePayNfsFlag);//1- учесть в NRI, 0- не учитываем в NRI

		rs = cs.executeQuery();
		if (rs.next()) {
			int result = rs.getInt(1); //integer, -- Признак ошибки (0 без ошибок)
			if (result == 0) {
				System.out.println("Процедура 'movePayNfs2Nri' ok"); //temp
			} else {
				errorTxt = rs.getString(2); // char(255), -- сообщения об ошибках
				System.out.println("Процедура 'movePayNfs2Nri' errorTxt: " + errorTxt); //temp
			}
		} else {
			System.out.println("no DATA: execute procedure 'movePayNfs2Nri'"); //temp
		}

	} catch (Exception ex) {
		System.out.println("Error in execute procedure 'movePayNfs2Nri'. NFS_ListForm.movePayNfs2Nri(?, ?, ?, ?)");
		if (ex instanceof SQLException) {
			System.out.println("Error code=" + ((SQLException) ex).getErrorCode());
		}
		ex.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (cs != null)
				cs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	return errorTxt;

}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2004 16:56:21)
 * @param newCheckCode int
 */
public void setCheckCode(int newCheckCode) {
	checkCode = newCheckCode;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 12:26:51)
 * @param newFilter java.lang.String
 */
public void setFilter(java.lang.String newFilter) {
	filter = newFilter;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2004 13:01:23)
 * @param newIdZpNfs java.lang.Integer
 */
public void setIdZpNfs(java.lang.Integer newIdZpNfs) {
	idZpNfs = newIdZpNfs;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 15:24:25)
 * @param newLeaseContract int
 */
public void setLeaseContract(int newLeaseContract) {
	if (leaseContract != newLeaseContract) {
		filter = "";
		sortBy = "datePay desc";
	}
	leaseContract = newLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2004 12:49:09)
 * @param newListZP java.util.ArrayList
 */
public void setListZP(ArrayList newListZP) {
	listZP = newListZP;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2004 17:51:22)
 * @param newListZpStr java.lang.String
 */
public void setListZpStr(java.lang.String newListZpStr) {
	listZpStr = newListZpStr;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2004 16:19:53)
 */
private void setMainParams(LeaseArendaAgreementNewAccessBean mainBean) {
	try {
		agreement.setMainDocumentNumber(mainBean.getDocumentNumber());
		agreement.setMainDocumentDate(mainBean.getDocumentDate());
		agreement.setMainStartDate(mainBean.getStartDate());
		agreement.setMainEndDate(mainBean.getEndDate());
		agreement.setO(new LeaseArendaAgrmntVO());
		agreement.getO().setMainLeaseDocument(new Integer(mainBean.getLeaseDocument()));
		if (mainBean.getOrgCustomer() != null) {
			OrganizationVO customer = new OrganizationVO(new Integer(mainBean.getOrgCustomer().getOrganization()));
			customer.setName(mainBean.getOrgCustomer().getName());
			agreement.setMainOrgCustomer(customer);
		}
		if (mainBean.getOrgExecutor() != null) {
			OrganizationVO executor = new OrganizationVO(new Integer(mainBean.getOrgExecutor().getOrganization()));
			executor.setName(mainBean.getOrgExecutor().getName());
			agreement.setMainOrgExecutor(executor);
		}
		agreement.setMainPosition(DocumentLogic.getNameMainPosition(mainBean));
		//вычисляем список ЗП для главного документа:
		initListZp(mainBean.getLeaseDocument());
		initIdZpNfs();
	} catch (Exception e) {
		System.out.println("NFS_ListForm.setMainParams, EXCEPTION.");
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2004 11:15:56)
 * @param newMovePayNfsFlag int
 */
public void setMovePayNfsFlag(int newMovePayNfsFlag) {
	movePayNfsFlag = newMovePayNfsFlag;
}
/**
 * Insert the method's description here.
 * Creation date: (22.06.2004 15:57:01)
 * @param newSortBy java.lang.String
 */
public void setSortBy(java.lang.String newSortBy) {
	sortBy = newSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2004 12:29:08)
 * @param newStateFilter int
 */
public void setStateFilter(int newStateFilter) {
	stateFilter = newStateFilter;
}
/**
 * Метод для проверки правильности введеных значений.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(org.apache.struts.action.ActionErrors errors) throws Exception {
	if (checkCode != 0) {
		System.out.println("checkCode =" + checkCode);
		String errorTxt = movePayNfs2Nri(errors, checkCode);
		if (!errorTxt.equals("")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorTxt));
		}
		checkCode = 0;
		movePayNfsFlag = -1;
	}
}
	/**
	 * @return
	 */
	private Integer getRegionID() {
		return regionID;
	}

	/**
	 * @param integer
	 */
	private void setRegionID(Integer integer) {
		regionID = integer;
	}

}
