/*
 * Created on 26.09.2006
 *
 * Загрузка списка ресурсов TRX в аплет
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.config.model.AppletPostResponse;
import com.hps.july.config.model.TrxResourceDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.ResourceVO;


/**
 * @author dima
 *
 */
public class LoadTrxResources extends HttpServlet {
	
	public static Integer TRX_CATEGORY = new Integer(23);

	/**
	 * 
	 */
	public LoadTrxResources() {
		super();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			System.out.println("In find trx resource Service");
			int errorCode = 0;
			String errorMessage = "OK";
			ObjectInputStream in = new ObjectInputStream(request.getInputStream());
			TrxResourceDataModel dm = null;
			try {
				dm = (TrxResourceDataModel) in.readObject();
			} catch (OptionalDataException e) {
				errorCode = -1;
				errorMessage = e.getMessage();
				e.printStackTrace(System.out);
			} catch (ClassNotFoundException e) {
				errorCode = -1;
				errorMessage = e.getMessage();
				e.printStackTrace(System.out);
			} catch (IOException e) {
				errorCode = -1;
				errorMessage = e.getMessage();
				e.printStackTrace(System.out);
			}
			in.close();
			
			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			
			
			AppletPostResponse apresp = new AppletPostResponse();
			
			if ((errorCode == 0) && (dm != null)) {
				dm.setResources(loadTrxResources(dm.getSearchby().getValue(), dm.getSearchparam()));
			}
			
			apresp.setErrorCode(errorCode);
			apresp.setErrorMessage(errorMessage);
			
			out.writeObject(apresp);
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение ресурсов из БД
	 *
	 */
	public static ArrayList loadTrxResources(String searchby, String searchvalue) {
		ArrayList resources = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findResources(searchby, searchvalue, TRX_CATEGORY);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			ResourceVO res = new ResourceVO(((Integer)ro.getColumn("resource").asObject()).intValue(), 
			ro.getColumn("model").asString());
			res.setFullname(ro.getColumn("name").asString()); 
			res.setManucode(ro.getColumn("manucode").asString()); 
			res.setNfscode(ro.getColumn("nfscode").asString()); 
			res.setManufname(ro.getColumn("manufname").asString()); 
			resources.add(res);
		}
		return resources;
	}

}
