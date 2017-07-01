/*
 * Created on 15.12.2006
 *
 * Загрузка списка контроллеров в аплет
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.config.model.ControllerDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.ControllerVO;


/**
 * @author dima
 *
 */
public class LoadControllers extends HttpServlet {

	/**
	 * 
	 */
	public LoadControllers() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			
			ControllerDataModel dm = new ControllerDataModel();
			dm.setControllers(loadControllers());
			
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение контроллеров из БД
	 *
	 */
	public static ArrayList loadControllers() {
		ArrayList controllers = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findControllers();
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			ControllerVO contr = new ControllerVO();
			Integer ccode = (Integer)ro.getColumn("storageplace").asObject();
			Integer cnumber = (Integer)ro.getColumn("number").asObject();
			String cname = ro.getColumn("name").asString();
			if ( (ccode != null) && (cnumber != null)) {
				contr.setCode(ccode.intValue());
				contr.setNumber(cnumber.intValue());
				contr.setName(cname);
				controllers.add(contr);
			}
		}
		return controllers;
	}

}
