package com.hps.july.arenda.actionbean;

import com.hps.july.web.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
/**
 * ���������� ��������� WORD..
 * Creation date: (09.11.2004 13:13:12)
 * @author: Shafigullin Ildar
 */
public class MemoWordUploadAction extends AbstractDocumentUploadAction {
/**
	������������ ��������: null - ��� ������,
	String - ����������� ��������� �� ������ ��� ������ ������������
*/
public String storeInDatabase(ActionMapping mapping, DocumentUploadForm form, HttpServletRequest request, HttpServletResponse response) {
	String result = null;
	if (!form.isEmpty()) {
		try {
			//System.out.println("form.getDocumentid()="+form.getDocumentid());//temp
			//System.out.println("form.getFilebody().getFileName()="+form.getFilebody().getFileName());//temp
			//System.out.println("form.getFilebody().getFileData().length="+form.getFilebody().getFileData().length);//temp
			com.hps.july.cdbc.objects.CDBC_Memo_Object .storeWord(form.getDocumentid(), form.getFilebody().getFileName(), form.getFilebody().getFileData());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			result = "������ ���������� � CompletWorkAktWordUploadAction:" + e.getMessage();
		}
	}
	return result;
}
}
