package com.hps.july.arenda.formbean;

import com.hps.july.web.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import org.apache.struts.action.*;
import java.util.*;
import com.hps.july.commonbean.*;
/**
 * Form-Bean "позиции Служебных записок"
 * Creation date: (30.08.2004 13:55:51)
 * @author: Shafigullin Ildar
 */
public class MemoPosForm extends EditForm {
	private int idPos;
	private MemoPos_VO memoPos;
	private int idHeader;
	private MemoPosInfo memoPosInfo;
	private java.lang.String type;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private java.util.ArrayList phones;
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 14:01:32)
 */
public MemoPosForm() {
	init();
}
/**
 * Текущее приложение.
 * Creation date: (30.08.2004 13:55:51)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 14:28:21)
 * @return int
 */
public int getIdHeader() {
	return idHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 13:57:23)
 * @return int
 */
public int getIdPos() {
	return idPos;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 13:58:08)
 * @return com.hps.july.arenda.valueobject.MemoPos_VO
 */
public MemoPos_VO getMemoPos() {
	return memoPos;
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2004 14:34:41)
 * @return java.lang.String
 */
public String getMemoPosCardamountStr() {
	if (memoPos != null && memoPos.getCardamount() != null)
		return memoPos.getCardamount().toString();
	else
		return null;
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2004 15:36:35)
 * @return java.lang.String
 */
public String getMemoPosEnddateStr() {
	if (memoPos != null && memoPos.getEnddate() != null)
		return format.format(new java.util.Date(memoPos.getEnddate().getTime()));
	else
		return "";
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 16:34:40)
 * @return com.hps.july.arenda.valueobject.MemoPosInfo
 */
public com.hps.july.arenda.valueobject.MemoPosInfo getMemoPosInfo() {
	return memoPosInfo;
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2004 14:50:27)
 * @return java.lang.String
 */
public String getMemoPosStartdateStr() {
	if (memoPos != null && memoPos.getStartdate() != null)
		return format.format(new java.util.Date(memoPos.getStartdate().getTime()));
	else
		return "";
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:54:00)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getPhones() {
	return phones;
}
/**
 * Текущее состояние приложения.
 * Creation date: (30.08.2004 13:55:51)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.MEMO_POS_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 16:38:10)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 14:06:50)
 */
private void init() {
	memoPos = new MemoPos_VO();
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 11:51:30)
 */
private void initListPhones(Integer leaseDoc) {
	phones = new ArrayList();
	CDBCResultSet rs = CDBC_LeaseAbonentPhones_Object.findListPhones(leaseDoc);
	java.util.ListIterator it = rs.listIterator();
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject) it.next();
		LeaseAbonentPhone_VO vo = new LeaseAbonentPhone_VO(ro);
		phones.add(vo);
	}
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	init();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	int key = keyGen.getNextKey("tables.OfficeMemoPos");
	System.out.println("OfficeMemoPos_key=" + key); //temp
	getMemoPos().setIdPos(new Integer(key));
	getMemoPos().setIdHeader(new Integer(getIdHeader()));
}
/**
 * Метод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	init();
	CDBCRowObject ro = CDBC_MemoPos_Object.findMemoPos(getIdPos());
	if (ro != null) {
		memoPos = new MemoPos_VO(ro);
		setIdHeader(memoPos.getIdHeader().intValue());
	} else {
		System.out.println("Нет записи с idPos=" + getIdPos());
		throw new Exception("Нет записи с idPos=" + getIdPos());
	}
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
	try {
		//System.out.println("memo="+getMemo());//temp
		boolean ok = CDBC_MemoPos_Object.deleteMemoPos(getIdPos());
		if (!ok) {
			String errorStr = "Ошибка удаления записи: MemoPos:idPos" + getIdPos();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
		}
	} catch (Exception e) {
		System.out.println("MemoPosForm.processDelete():errorTxt: " + e);
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
	try {
		//System.out.println("memo="+getMemo());//temp
		boolean ok = CDBC_MemoPos_Object.addMemoPos(getMemoPos());
		if (!ok) {
			String errorStr = "Ошибка добаления записи: MemoPos:idPos" + memoPos.getIdPos();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
		}
	} catch (Exception e) {
		System.out.println("MemoPosForm.processInsert():errorTxt: " + e);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", e));
		e.printStackTrace();
	}
	return null;
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
	try {
		//System.out.println("memo="+getMemo());//temp
		boolean ok = CDBC_MemoPos_Object.editMemoPos(getMemoPos());
		if (!ok) {
			String errorStr = "Ошибка редактирования записи: MemoPos:idPos" + memoPos.getIdPos();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", errorStr));
		}
	} catch (Exception e) {
		System.out.println("MemoPosForm.processUpdate():errorTxt: " + e);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.defratepayoncontr", e));
		e.printStackTrace();
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 14:28:21)
 * @param newIdHeader int
 */
public void setIdHeader(int newIdHeader) {
	idHeader = newIdHeader;
	CDBCRowObject ro = CDBC_Memo_Object.findMemo(getIdHeader());
	if (ro != null) {
		Memo_VO memo = new Memo_VO(ro);
		//иницифлизируем тип служебки:
		memoPosInfo = new MemoPosInfo(memo.getType());
		//инициализируем список телефонов для абон. договора:
		initListPhones(memo.getAbonentContract());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 13:57:23)
 * @param newIdPos int
 */
public void setIdPos(int newIdPos) {
	idPos = newIdPos;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2004 13:58:08)
 * @param newMemoPos com.hps.july.arenda.valueobject.MemoPos_VO
 */
public void setMemoPos(MemoPos_VO newMemoPos) {
	memoPos = newMemoPos;
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2004 14:36:06)
 * @param amountStr java.lang.String
 */
public void setMemoPosCardamountStr(String amountStr) {
	if (memoPos != null&& !amountStr.equals(""))
		memoPos.setCardamount(new java.math.BigDecimal(amountStr));
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2004 15:37:03)
 * @param dateStr java.lang.String
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
 * Creation date: (31.08.2004 14:49:42)
 * @param dateStr String
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
 * Creation date: (30.08.2004 16:38:10)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
