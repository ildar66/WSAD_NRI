/*
 * Created on 07.08.2006
 *
 * Загрузка списка складов в аплет
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
import com.hps.july.config.model.StoreDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.StoreVO;


/**
 * @author dima
 *
 */
public class LoadStores extends HttpServlet {

	/**
	 * 
	 */
	public LoadStores() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			
			StoreDataModel dm = new StoreDataModel();
			dm.setStores(loadStores());
			
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение производителей из БД
	 *
	 */
	public static ArrayList loadStores() {
		ArrayList stores = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findStores();
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			stores.add(new StoreVO(
				((Integer)ro.getColumn("storageplace").asObject()).intValue(), 
				ro.getColumn("name").asString()));
		}
		return stores;
	}

}
