package com.hps.july.arenda.actionbean;

import com.hps.july.web.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.arenda.cdbcobjects.*;
/**
 * Insert the type's description here.
 * Creation date: (09.11.2004 13:13:12)
 * @author: Shafigullin Ildar
 */
public class CompletWorkAktWordUploadAction extends AbstractDocumentUploadAction {
/**
	Возвращаемое значение: null - все хорошо,
	String - расшифровка сообщения об ошибке для показа пользователю
*/
public String storeInDatabase(ActionMapping mapping, DocumentUploadForm form, HttpServletRequest request, HttpServletResponse response) {
	String result = null;
	if (!form.isEmpty()) {
		try {
			//System.out.println("form.getDocumentid()="+form.getDocumentid());//temp
			//System.out.println("form.getFilebody().getFileName()="+form.getFilebody().getFileName());//temp
			//System.out.println("form.getFilebody().getFileData().length="+form.getFilebody().getFileData().length);//temp
			CDBC_CompletWorkActs_Object.storeWord(form.getDocumentid(), form.getFilebody().getFileName(), form.getFilebody().getFileData());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			result = "Ошибка сохранения в CompletWorkAktWordUploadAction:" + e.getMessage();
		}
	}
	return result;
}
}
