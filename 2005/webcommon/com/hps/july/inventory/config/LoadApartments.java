/*
 * Created on 01.06.2007
 *
 * Загрузка помещений в аплет
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.config.model.ApartmentDataModel;
import com.hps.july.config.model.ApartmentVO;
import com.hps.july.config.model.CDBCConfigObject;


/**
 * @author dima
 *
 */
public class LoadApartments extends HttpServlet {

	/**
	 * 
	 */
	public LoadApartments() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			
			Integer position = null;
			try {
				int iposition = Integer.parseInt(request.getParameter("position"));
				position = new Integer(iposition);
			} catch (NumberFormatException e) {
				e.printStackTrace(System.out);
			}
			ApartmentDataModel dm = new ApartmentDataModel();
			dm.setApartments(loadAppartments(position));
			
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение производителей из БД
	 *
	 */
	public static List loadAppartments(Integer position) {
		List appartments = new ArrayList();
		appartments.add(new ApartmentVO(null, ""));
		CDBCResultSet rs = CDBCConfigObject.findApartments(position);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			appartments.add(new ApartmentVO(
				(Integer)ro.getColumn("apartmentid").asObject(), 
				ro.getColumn("apartname").asString()));
		}
		return appartments;
	}

}
