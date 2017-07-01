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
import com.hps.july.config.model.WorkerDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.WorkerVO;


/**
 * @author dima
 *
 */
public class LoadWorkers extends HttpServlet {

	/**
	 * 
	 */
	public LoadWorkers() {
		super();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			System.out.println("In find worker Service");
			int errorCode = 0;
			String errorMessage = "OK";
			ObjectInputStream in = new ObjectInputStream(request.getInputStream());
			WorkerDataModel dm = null;
			try {
				dm = (WorkerDataModel) in.readObject();
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
				dm.setWorkers(loadWorkers(dm.getSearchParam()));
			}
			
			apresp.setErrorCode(errorCode);
			apresp.setErrorMessage(errorMessage);
			
			out.writeObject(apresp);
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение производителей из БД
	 *
	 */
	public static ArrayList loadWorkers(String alastname) {
		ArrayList workers = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findWorkers(alastname);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			workers.add(new WorkerVO(
				((Integer)ro.getColumn("worker").asObject()).intValue(), 
				ro.getColumn("name").asString()));
		}
		return workers;
	}

}
