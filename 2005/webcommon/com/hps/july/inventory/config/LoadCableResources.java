/*
 * Created on 14.09.2006
 *
 * Загрузка ресурсов типов кабелей в аплет
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
import com.hps.july.config.model.CableResourceDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.ResourceVO;


/**
 * @author dima
 *
 */
public class LoadCableResources extends HttpServlet {

	/**
	 * 
	 */
	public LoadCableResources() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			
			int imanuf = Integer.parseInt(request.getParameter("manuf"));
			CableResourceDataModel dm = new CableResourceDataModel();
			dm.setResources(loadResources(new Integer(imanuf)));
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение ресурсов типа кабель из БД
	 *
	 */
	public static ArrayList loadResources(Integer manuf) {
		ArrayList resources = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findCableResourcesByManuf(manuf);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			resources.add(new ResourceVO(
				((Integer)ro.getColumn("resource").asObject()).intValue(), 
				ro.getColumn("model").asString()));
		}
		return resources;
	}

}
