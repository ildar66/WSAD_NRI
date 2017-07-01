/*
 * Created on 14.09.2006
 *
 * Загрузка списка производителей кабелей в аплет
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
import com.hps.july.config.model.CableManufDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.ManufacturerVO;


/**
 * @author dima
 *
 */
public class LoadCableManuf extends HttpServlet {

	/**
	 * 
	 */
	public LoadCableManuf() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			
			CableManufDataModel dm = new CableManufDataModel();
			dm.setManufacturers(loadManufacturers());
			
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение производителей из БД
	 *
	 */
	public static ArrayList loadManufacturers() {
		ArrayList manufacturers = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findCableManufacturers();
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			manufacturers.add(new ManufacturerVO(
				((Integer)ro.getColumn("organization").asObject()).intValue(), 
				ro.getColumn("shortname").asString()));
		}
		return manufacturers;
	}

}
