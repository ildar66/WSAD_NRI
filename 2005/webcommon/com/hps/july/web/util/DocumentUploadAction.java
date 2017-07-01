package com.hps.july.web.util;

import org.apache.struts.action.*;

import javax.servlet.http.*;

import com.hps.july.valueobject.WordDocument;
/**
 * Insert the type's description here.
 * Creation date: (15.11.2005 12:40:34)
 * @author: Shafigullin Ildar
 */
public class DocumentUploadAction extends com.hps.july.web.util.AbstractDocumentUploadAction {
	/**
		@return String - ����������� ��������� �� ������ ��� ������ ������������
	*/
	public String storeInDatabase(ActionMapping mapping, DocumentUploadForm form, HttpServletRequest request, HttpServletResponse response) {
		String result = null;
		Integer typeDoc = null; //��� ���������
		String objectType = null; //��� ���������
		try {
			typeDoc = form.getTypeDoc();
			objectType = form.getObjectType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!form.isEmpty()) {
			try {
				System.out.println("form.getDocumentid()="+form.getDocumentid() + "; typeDoc="+typeDoc + "; objectType="+objectType);//temp
				//�������� � �������� ������������:
				WordDocument docWord = new WordDocument(new Integer(form.getDocumentid()), typeDoc, objectType, form.getFilebody().getFileData(), form.getFilebody().getFileName());
				DocumentWordDownload_Object.storeWordExternal(docWord, request.getRemoteUser());

			} catch (Exception e) {
				e.printStackTrace(System.out);
				result = "������ ���������� � DocumentUploadAction:" + e.getMessage();
			}
		}
		return result;
	}
}
