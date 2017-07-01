/*
 * Created on 21.11.2006
 *
 * Загрузка списка ресурсов в аплет
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
import com.hps.july.config.model.OtherEquipResourceDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.ResourceVO;


/**
 * @author dima
 *
 */
public class LoadResources extends HttpServlet {

	/**
	 * 
	 */
	public LoadResources() {
		super();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			System.out.println("In find resource Service");
			int errorCode = 0;
			String errorMessage = "OK";
			ObjectInputStream in = new ObjectInputStream(request.getInputStream());
			OtherEquipResourceDataModel dm = null;
			try {
				dm = (OtherEquipResourceDataModel) in.readObject();
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
				dm.setResources(loadResources(dm.getSearchby().getValue(), dm.getSearchparam(), dm.getEquipCategory()));
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
	public static ArrayList loadResources(String searchby, String searchvalue, Integer equipCategory) {
		ArrayList resources = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findResources(searchby, searchvalue, equipCategory);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			ResourceVO res = new ResourceVO(((Integer)ro.getColumn("resource").asObject()).intValue(), 
			ro.getColumn("model").asString());
			res.setFullname(ro.getColumn("name").asString()); 
			res.setManucode(ro.getColumn("manucode").asString()); 
			res.setNfscode(ro.getColumn("nfscode").asString()); 
			res.setManufname(ro.getColumn("manufname").asString()); 
			res.setPolicy(ro.getColumn("countpolicy").asString()); 
			resources.add(res);
		}
		return resources;
	}

}
