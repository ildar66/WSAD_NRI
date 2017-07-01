/*
 * Created on 02.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.web.util;

import com.hps.july.terrabyte.core.Document;
import com.hps.july.terrabyte.ext.client.TerrabyteExternalClient;
import com.hps.july.terrabyte.ext.client.TerrabyteExternalClientFactory;
import com.hps.july.valueobject.WordDocument;

/**
 * @author IShaffigulin
 *
 *Загрузка/сохранение документов Word.
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DocumentWordDownload_Object {

	/**
	 * Загрузка документов Word.
	 * Creation date: (17.11.2005 10:21:14)
	 */
	public final static WordDocument loadWordExternal(Integer id, String objectTypes, String remoteUser)
		throws Exception {
		TerrabyteExternalClient client = TerrabyteExternalClientFactory.getClient();
		Document doc = client.getDocumentLastVersionByObject(id, objectTypes, remoteUser);
		java.io.InputStream stream = doc.getData();
		byte[] text = new byte[stream.available()];
		stream.read(text);
		stream.close();
		String filename = doc.getDocumentName();
		return new WordDocument(id, objectTypes, text, filename);
	}
	/**
	 * Coхранение документов Word.
	 * Creation date: (17.11.2005 9:43:21)
	 */
	public final static void storeWordExternal(WordDocument doc, String remoteUser) throws Exception {
		//String host = com.hps.july.util.AppUtils.getNamedValueString("TERRABYTE_HOST");
		//int port = com.hps.july.util.AppUtils.getNamedValueInt("TERRABYTE_PORT");
		//String operator = "NRI";
		TerrabyteExternalClient client = TerrabyteExternalClientFactory.getClient();
		String mimeType = "application/msword";
		client.addObjectDocument(
			new java.io.ByteArrayInputStream(doc.getText()),
			doc.getFilename(),
			doc.getId(),
			doc.getObjectType(),
			remoteUser,
			doc.getDocumentType(),
			mimeType);
		//client.addObjectDocument(doc, objectId, objectType, userName);    
	}

}
