package com.hps.july.arenda.formbean;

import com.hps.july.web.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
/**
 * Form-Bean "Служебных записок"
 * Creation date: (26.07.2004 12:10:30)
 * @author: Shafigullin Ildar
 */
public class MemoDetachForm extends EditForm {
	private int idHeader;
	private Memo_VO memo;
	private ArrayList memoTargets;
	private com.hps.july.arenda.valueobject.MemoPos_VO memoPos;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private java.lang.String operation ="";
	private int numPos;
	private java.util.ArrayList listArendaContractsInfo;
/**
 * Insert the method's description here.
 * Creation date: (26.07.2004 12:27:49)
 */
public MemoDetachForm() {
	init();
	initListMemoTargets();
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 17:11:12)
 */
private void addMemoPos() {
	if (memo.getListMemoPos() != null) {
		memo.getListMemoPos().add(memoPos);
		//инициализируем позицию:
		memoPos = new MemoPos_VO();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2004 19:04:46)
 */
private void deleteMemoPos() {
	if (memo.getListMemoPos() != null) {
		MemoPos_VO posVO = (MemoPos_VO) memo.getListMemoPos().get(getNumPos());
		if (posVO.getIdPos() != null) {
			try {
				//System.out.println("memo="+getMemo());//temp
				boolean ok = CDBC_MemoPos_Object.deleteMemoPos(posVO.getIdPos().intValue());
				if (!ok) {
					String errorStr = "Ошибка удаления записи: MemoPos:idPos" + posVO.getIdPos();
					//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
				}
				//инициализируем позицию:
				memoPos = new MemoPos_VO();
			} catch (Exception e) {
				System.out.println("MemoDetachForm.processDelete():errorTxt: " + e);
				//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", e));
				e.printStackTrace();
			}
		}
		memo.getListMemoPos().remove(getNumPos());
	}
}
/**
 * Текущее приложение.
 * Creation date: (26.07.2004 12:10:30)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2004 12:25:03)
 * @return int
 */
public int getIdHeader() {
	return idHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2005 15:43:11)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getListArendaContractsInfo() {
	return listArendaContractsInfo;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 17:45:37)
 * @return java.util.ArrayList
 * @param idHeader java.lang.Integer
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
 * Creation date: (01.09.2004 16:20:28)
 */
private PeopleVO getManVO_fromOperatorCode(javax.servlet.http.HttpServletRequest request) {
	//инициализируем исполнителя:
	PeopleVO manVO = null;
	try {
		Integer oper = OperatorObject.getOperatorCode(request.getRemoteUser());
		OperatorAccessBean oab = new OperatorAccessBean();
		oab.setInitKey_operator(oper.intValue());
		oab.refreshCopyHelper();
		int man = oab.getManKey().man;
		PeopleAccessBean pab = new PeopleAccessBean();
		pab.setInitKey_man(man);
		manVO = new PeopleVO(new Integer(man));
		manVO.setName(pab.getFullName());
	} catch (Exception e) {
		System.out.println("Cannot determine operator");
		e.printStackTrace(System.out);
	}
	return manVO;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2004 12:25:53)
 * @return com.hps.july.arenda.valueobject.Memo_VO
 */
public Memo_VO getMemo() {
	return memo;
}
/**
 * Insert the method's description here.
 * Creation date: (17.09.2004 16:57:36)
 */
public String getMemoAbonentBillInfo() {
	if (memo != null && memo.getLeasebill() != null) {
		CDBCRowObject ro = CDBC_AbonentBills_Object.findAbonentBill(memo.getLeasebill().intValue());
		AbonentBill_VO vo = new AbonentBill_VO(ro);
		return "№ " + vo.getBillnumber() + " от " + format.format(vo.getBilldate());
	}
	return "";
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2004 12:11:57)
 */
public String getMemoDateStr() {
	if (memo != null && memo.getDate() != null)
		return format.format(new java.util.Date(memo.getDate().getTime()));
	else
		return "";
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 14:49:09)
 * @return com.hps.july.arenda.valueobject.MemoPos_VO
 */
public com.hps.july.arenda.valueobject.MemoPos_VO getMemoPos() {
	return memoPos;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 15:28:32)
 */
public String getMemoPosCardamountStr() {
	if (memoPos != null && memoPos.getCardamount() != null)
		return memoPos.getCardamount().toString();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 15:31:53)
 */
public String getMemoPosEnddateStr() {
	if (memoPos != null && memoPos.getEnddate() != null)
		return format.format(new java.util.Date(memoPos.getEnddate().getTime()));
	else
		return "";
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 15:30:12)
 */
public String getMemoPosStartdateStr() {
	if (memoPos != null && memoPos.getStartdate() != null)
		return format.format(new java.util.Date(memoPos.getStartdate().getTime()));
	else
		return "";
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 16:03:58)
 * @return java.util.ArrayList
 */
public ArrayList getMemoTargets() {
	return memoTargets;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2004 17:38:46)
 * @return int
 */
public int getNumPos() {
	return numPos;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 17:06:26)
 * @return java.lang.String
 */
public java.lang.String getOperation() {
	return operation;
}
/**
 * Текущее состояние приложения.
 * Creation date: (26.07.2004 12:10:30)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.MEMO_DETACH_FORM;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2004 16:43:39)
 */
public ArrayList getUseTypes() {
	return memo.getMemoType().getUseTypes();
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2004 12:27:12)
 */
private void init() {
	memo = new Memo_VO();
	memo.setOrgCustomer(new OrganizationVO());
	memo.setPositionVO(new PositionVO());
}
/**
 * Insert the method's description here.
 * Creation date: (17.02.2005 15:43:11)
  */
private void initListArendaContractsInfo() {
    if (getMemo().getOrgCustomer().getOrganization() != null || getMemo().getPositionVO().getStorageplace() != 0) {
        listArendaContractsInfo =
            CDBC_Memo_Object.findListArendaContracts(
                null,
                getMemo().getOrgCustomer().getOrganization(),
                getMemo().getPositionVO().getStorageplace());
    } else {
        listArendaContractsInfo = new ArrayList();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 16:03:17)
 */
private void initListMemoTargets() {
	memoTargets = new ArrayList();
	CDBCResultSet rs = CDBC_Memo_Object.findAllMemoTargets();
	java.util.ListIterator it = rs.listIterator();
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject) it.next();
		MemoTarget_VO vo = new MemoTarget_VO((Integer) ro.getColumn("idtarget").asObject());
		vo.setName(ro.getColumn("name").asString());
		memoTargets.add(vo);
	}
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	//операция с "позицией":
	if (!operation.equals("")) {
		operation = "";
		return;
	}

	//проверяем изменил ли пользователь тип?
	String memoType = request.getParameter("type");
	if (request.getParameter("type") != null) {
		memo.setType(memoType);
		return;
	}

	//стандартная инициализация:
	init();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	int key = keyGen.getNextKey("tables.OfficeMemoHeaders");
	//System.out.println("key=" + key); //temp
	setIdHeader(key);	
	getMemo().setIdHeader(new Integer(key));
	getMemo().setNumber(String.valueOf(key));
	getMemo().setDate(new java.sql.Date(System.currentTimeMillis()));
	//getMemo().setAbonentContract(new Integer(getAbonentContract()));
	getMemo().setManVO(new PeopleVO());
	getMemo().setManVO(getManVO_fromOperatorCode(request));
	getMemo().setListMemoPos(new ArrayList());
	getMemo().setType("1");
	//инициализируем позицию:
	memoPos = new MemoPos_VO();
	//инициализируем список договоров аренды:
	listArendaContractsInfo = new ArrayList();
}
/**
 * Метод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    //операция с "позицией":
    if (!operation.equals("")) {
        operation = "";
        return;
    }
    //проверяем изменил ли пользователь тип?:
    String memoType = request.getParameter("type");
    if (request.getParameter("type") != null) {
        memo.setType(memoType);
        return;
    }
    //инициализация:
    init();
    CDBCRowObject ro = CDBC_Memo_Object.findMemoDetach(getIdHeader());
    if (ro != null) {
        memo = new Memo_VO(ro);
        memo.initDetachInfo(ro);
        getMemo().setListMemoPos(getListMemoPosForMemo(memo.getIdHeader()));
        //инициализируем позицию:
        memoPos = new MemoPos_VO();
        //инициализируем список договоров аренды:
        initListArendaContractsInfo();
    } else {
        System.out.println("Нет записи с idHeader=" + getIdHeader());
        throw new Exception("Нет записи с idHeader=" + getIdHeader());
    }
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	try {
		//System.out.println("memo="+getMemo());//temp
		boolean ok = CDBC_Memo_Object.deleteMemo(getIdHeader());
		if (!ok) {
			String errorStr = "Ошибка удаления записи: Memo:idHeader" + getIdHeader();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
		}
	} catch (Exception e) {
		System.out.println("MemoForm.processDelete():errorTxt: " + e);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", e));
		e.printStackTrace();
	}
	return "success"; 
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    if (operation.equalsIgnoreCase("addMemoPos")) {
        addMemoPos();
        return "processMemoPos";
    }
    if (operation.equalsIgnoreCase("setMemoPos")) {
        setMemoPos();
        return "processMemoPos";
    }
    if (operation.equalsIgnoreCase("updateMemoPos")) {
        updateMemoPos();
        return "processMemoPos";
    }
    if (operation.equalsIgnoreCase("deleteMemoPos")) {
        deleteMemoPos();
        return "processMemoPos";
    }
	if (operation.equalsIgnoreCase("updateListArendaContractsInfo")) {
		initListArendaContractsInfo();
		return "processMemoPos";
	}    
    try {
        boolean ok = CDBC_Memo_Object.addMemoDetach(getMemo());
        if (!ok) {
            String errorStr = "Ошибка добаления записи: Memo:idHeader=" + memo.getIdHeader();
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
            return null;
        }
        //поиск и добавление в базу новых позиций:
        Iterator iter = getMemo().getListMemoPos().iterator();
        while (iter.hasNext()) {
            MemoPos_VO memoPos_VO = (MemoPos_VO) iter.next();
            if (memoPos_VO.getIdPos() == null) {
                KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
                int key = keyGen.getNextKey("tables.OfficeMemoPos");
                //System.out.println("OfficeMemoPos_key=" + key); //temp
                memoPos_VO.setIdPos(new Integer(key));
                memoPos_VO.setIdHeader(getMemo().getIdHeader());
                ok = CDBC_MemoPos_Object.addMemoPos(memoPos_VO);
                if (!ok) {
                    String errorStr = "Ошибка добаления записи: MemoPos:idPos =" + memoPos.getIdPos();
                    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
                }
            }
        }
    } catch (Exception e) {
        System.out.println("MemoForm.processInsert():errorTxt: " + e);
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", e));
        e.printStackTrace();
    }
    return null;
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	if (operation.equalsIgnoreCase("addMemoPos")) {
		addMemoPos();
		return "processMemoPos";
	}
	if (operation.equalsIgnoreCase("setMemoPos")) {
		setMemoPos();
		return "processMemoPos";
	}	
	if (operation.equalsIgnoreCase("updateMemoPos")) {
		updateMemoPos();
		return "processMemoPos";
	}
	if (operation.equalsIgnoreCase("deleteMemoPos")) {
		deleteMemoPos();
		return "processMemoPos";
	}
	if (operation.equalsIgnoreCase("updateListArendaContractsInfo")) {
		initListArendaContractsInfo();
		return "processMemoPos";
	}			
	try {
		boolean ok = CDBC_Memo_Object.editMemoDetach(getMemo());
		if (!ok) {
			String errorStr = "Ошибка редактирования записи: Memo:idHeader" + memo.getIdHeader();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
		}
		//поиск и добавление в базу новых позиций:
		Iterator iter = getMemo().getListMemoPos().iterator();
		while (iter.hasNext()) {
			MemoPos_VO memoPos_VO = (MemoPos_VO) iter.next();
			if (memoPos_VO.getIdPos() == null) {
				KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
				int key = keyGen.getNextKey("tables.OfficeMemoPos");
				//System.out.println("OfficeMemoPos_key=" + key); //temp
				memoPos_VO.setIdPos(new Integer(key));
				memoPos_VO.setIdHeader(getMemo().getIdHeader());
				ok = CDBC_MemoPos_Object.addMemoPos(memoPos_VO);
				if (!ok) {
					String errorStr = "Ошибка добаления записи: MemoPos:idPos" + memoPos.getIdPos();
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
				}
			}
		}
	} catch (Exception e) {
		System.out.println("MemoDetachForm.processUpdate():errorTxt: " + e);
		e.printStackTrace();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", e));
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2004 12:25:03)
 * @param newIdHeader int
 */
public void setIdHeader(int newIdHeader) {
	idHeader = newIdHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2004 12:25:53)
 * @param newMemo com.hps.july.arenda.valueobject.Memo_VO
 */
public void setMemo(Memo_VO newMemo) {
	memo = newMemo;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2004 12:13:32)
 */
public void setMemoDateStr(String dateStr) throws java.text.ParseException {
	if (memo != null && dateStr != null && !dateStr.equals("")) {
		java.util.Date d = format.parse(dateStr);
		java.sql.Date data = new java.sql.Date(d.getTime());
		memo.setDate(data);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2004 17:37:16)
 */
private void setMemoPos() {
	if (memo.getListMemoPos() != null) {
		MemoPos_VO posVO = (MemoPos_VO)memo.getListMemoPos().get(getNumPos());
		//устанавливаем позицию:
		memoPos = posVO;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 14:49:09)
 * @param newMemoPos com.hps.july.arenda.valueobject.MemoPos_VO
 */
public void setMemoPos(com.hps.july.arenda.valueobject.MemoPos_VO newMemoPos) {
	memoPos = newMemoPos;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 15:29:09)
 */
public void setMemoPosCardamountStr(String amountStr) {
	if (memoPos != null && !amountStr.equals(""))
	try {
		memoPos.setCardamount(new java.math.BigDecimal(amountStr));
	} catch (NumberFormatException e) {
		System.out.println("NumberFormatException for setMemoPosCardamountStr: "+e.getMessage());
	}		
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 15:33:49)
 */
public void setMemoPosEnddateStr(String dateStr) throws java.text.ParseException {
	if (memoPos != null && dateStr != null && !dateStr.equals("")) {
		java.util.Date d = format.parse(dateStr);
		java.sql.Date data = new java.sql.Date(d.getTime());
		memoPos.setEnddate(data);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 15:33:25)
 */
public void setMemoPosStartdateStr(String dateStr) throws java.text.ParseException {
	if (memoPos != null && dateStr != null && !dateStr.equals("")) {
		java.util.Date d = format.parse(dateStr);
		java.sql.Date data = new java.sql.Date(d.getTime());
		memoPos.setStartdate(data);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2004 16:03:58)
 * @param newMemoTargets java.util.ArrayList
 */
public void setMemoTargets(ArrayList newMemoTargets) {
	memoTargets = newMemoTargets;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2004 17:38:46)
 * @param newNumPos int
 */
public void setNumPos(int newNumPos) {
	numPos = newNumPos;
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2004 17:06:26)
 * @param newOperation java.lang.String
 */
public void setOperation(java.lang.String newOperation) {
	operation = newOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (03.09.2004 18:34:07)
 */
private void updateMemoPos() {
	if (memoPos != null) {
		try {
			//System.out.println("memo="+getMemo());//temp
			boolean ok = CDBC_MemoPos_Object.editMemoPos(getMemoPos());
			if (!ok) {
				String errorStr = "Ошибка редактирования записи: MemoPos:idPos" + memoPos.getIdPos();
				//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
			}
		} catch (Exception e) {
			System.out.println("MemoDetachForm.updateMemoPos:errorTxt: " + e);
			//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", e));
			e.printStackTrace();
		}
		//инициализируем позицию:
		memoPos = new MemoPos_VO();
	}
}
/**
 * Метод для проверки правильности ввода значений в поля ввода.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException - 
 * при этом исключении ошибки отображаются пользователю.
 */
public void validateValues(ActionErrors errors) throws Exception {
    if (memo.getOrgCustomer().getOrganization() == null) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonentban.orgcustomer.empty"));
    }
    if (memo.getPositionVO().getStorageplace() <= 0) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Введите позицию !"));
    }    
    if (!errors.empty()) {
        throw new ValidationException();
    }
}
}
