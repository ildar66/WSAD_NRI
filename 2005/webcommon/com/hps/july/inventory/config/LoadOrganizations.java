/*
 * Created on 07.08.2006
 *
 * Загрузка списка складов в аплет
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
import com.hps.july.config.model.OrganizationDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.OrganizationVO;


/**
 * @author dima
 *
 */
public class LoadOrganizations extends HttpServlet {

	/**
	 * 
	 */
	public LoadOrganizations() {
		super();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			System.out.println("In find organization Service");
			int errorCode = 0;
			String errorMessage = "OK";
			ObjectInputStream in = new ObjectInputStream(request.getInputStream());
			OrganizationDataModel dm = null;
			try {
				dm = (OrganizationDataModel) in.readObject();
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
				dm.setOrganizations(loadOrganizations(dm.getSearchParam()));
			}
			
			apresp.setErrorCode(errorCode);
			apresp.setErrorMessage(errorMessage);
			
			out.writeObject(apresp);
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение организаций из БД
	 *
	 */
	public static ArrayList loadOrganizations(String alastname) {
		ArrayList organizations = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findOrganizations(alastname);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			organizations.add(new OrganizationVO(
				((Integer)ro.getColumn("organization").asObject()).intValue(), 
				ro.getColumn("name").asString(), ""));
		}
		return organizations;
	}

}
