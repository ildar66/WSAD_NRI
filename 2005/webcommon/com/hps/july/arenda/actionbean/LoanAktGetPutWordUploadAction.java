package com.hps.july.arenda.actionbean;

import org.apache.struts.action.*;
import javax.servlet.http.*;

import com.hps.july.web.util.*;
import com.hps.july.arenda.cdbcobjects.*;

/**
 * Insert the type's description here.
 * Creation date: (15.11.2005 12:40:34)
 * @author: Shafigullin Ildar
 */
public class LoanAktGetPutWordUploadAction extends com.hps.july.web.util.AbstractDocumentUploadAction {
/**
	Этот метод необъодимо перекрыть и записать полученный blob в базу данных.
	Возвращаемое значение: null - все хорошо,
	String - расшифровка сообщения об ошибке для показа пользователю
*/
public String storeInDatabase(ActionMapping mapping, DocumentUploadForm form, HttpServletRequest request, HttpServletResponse response) {
    String result = null;
    boolean isCDBCstory = false;
    if (!form.isEmpty()) {
        try {
            //System.out.println("form.getDocumentid()="+form.getDocumentid());//temp
            //System.out.println("form.getFilebody().getFileName()="+form.getFilebody().getFileName());//temp
            //System.out.println("form.getFilebody().getFileData().length="+form.getFilebody().getFileData().length);//temp
            if (isCDBCstory) {
                if (!CDBC_LoanAktGetPut_Object.storeWord(form.getDocumentid(), form.getFilebody().getFileName(), form.getFilebody().getFileData()))
                    result = "Ошибка сохранения в LoanAktGetPutWordUploadAction";
            } else {
                //Сохрание с внешними библиотеками:
                CDBC_LoanAktGetPut_Object.storeWordExternal(
                    new com.hps.july.valueobject.WordDocument(new Integer(form.getDocumentid()), form.getFilebody().getFileData(), form.getFilebody().getFileName()),
                    request.getRemoteUser());
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            result = "Ошибка сохранения в LoanAktGetPutWordUploadAction:" + e.getMessage();
        }
    }
    return result;
}
}
