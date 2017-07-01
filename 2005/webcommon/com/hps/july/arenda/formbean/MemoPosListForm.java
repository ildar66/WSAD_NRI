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
import com.hps.july.persistence.*;
import com.hps.july.util.*;
/**
 * Form-Bean "���� ������� ��������� �������"
 * Creation date: (26.08.2004 11:27:42)
 * @author: Shafigullin Ildar
 */
public class MemoPosListForm extends BrowseForm {
	private Memo_VO memo;
	private int idHeader;
/**
 * MemoPosListForm constructor comment.
 */
public MemoPosListForm() {
	super();
	setFinderMethodName("findListMemoPos");
}
/**
 * ��� ������ ������ ������ ����� �������������� ������������ ������.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	if (o == null) {
		return o;
	}
	if (!(o instanceof CDBCRowObject)) {
		System.out.println("MemoPos_LIST: CLASS_CAST: " + o.getClass().getName());
		return o;
	}
	return new MemoPos_VO((CDBCRowObject) o);
}
/**
 * ���������� ��� bean ��� ������.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBC_MemoPos_Object";
}
/**
 * ���������� ���������, ������� ����� ������������ � ����� ������ ������.
 * Creation date: (26.08.2004 11:27:42)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(getIdHeader())};
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 16:08:42)
 * @return int
 */
public int getIdHeader() {
	return idHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 11:44:18)
 * @return com.hps.july.arenda.valueobject.Memo_VO
 */
public Memo_VO getMemo() {
	return memo;
}
/**
 * ������������� ������ ��������� ������.
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
	ParamsParser.setState(request, Applications.ARENDA, APPStates.MEMO_POS_LIST);
	CDBCRowObject ro = CDBC_Memo_Object.findMemo(getIdHeader());
	if (ro != null) {
		memo = new Memo_VO(ro);
		ro = CDBC_Memo_Object.findMemoTarget(memo.getTarget().intValue());
		memo.setTargetVO(new MemoTarget_VO(ro));		
	} else {
		memo = null;
		System.out.println("��� ������ � idHeader=" + getIdHeader());
		//throw new Exception("��� ������ � idHeader=" + getIdHeader());
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 16:08:42)
 * @param newIdHeader int
 */
public void setIdHeader(int newIdHeader) {
	idHeader = newIdHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (26.08.2004 11:44:18)
 * @param newMemo com.hps.july.arenda.valueobject.Memo_VO
 */
public void setMemo(Memo_VO newMemo) {
	memo = newMemo;
}
}
