/*
 * Created on 01.06.2007
 *
 * Загрузка мест размещения антенн в аплет
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
import com.hps.july.config.model.AntPlaceDataModel;
import com.hps.july.config.model.AntPlaceVO;
import com.hps.july.config.model.CDBCConfigObject;


/**
 * @author dima
 *
 */
public class LoadAntPlaces extends HttpServlet {

	/**
	 * 
	 */
	public LoadAntPlaces() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			
			AntPlaceDataModel dm = new AntPlaceDataModel();
			dm.setAntPlaces(loadAntPlaces());
			
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение производителей из БД
	 *
	 */
	public static List loadAntPlaces() {
		List antplaces = new ArrayList();
		antplaces.add(new AntPlaceVO(null, ""));
		CDBCResultSet rs = CDBCConfigObject.findAntPlaces();
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			antplaces.add(new AntPlaceVO(
				(Integer)ro.getColumn("antplaceid").asObject(), 
				ro.getColumn("name").asString()));
		}
		return antplaces;
	}

}
