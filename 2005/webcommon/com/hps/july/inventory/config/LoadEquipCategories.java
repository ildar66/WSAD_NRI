/*
 * Created on 20.11.2006
 *
 * Загрузка Категорий прочего оборудования в аплет
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.EquipCategoryDataModel;
import com.hps.july.config.model.EquipCategoryVO;


/**
 * @author dima
 *
 */
public class LoadEquipCategories extends HttpServlet {

	public LoadEquipCategories() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			
			EquipCategoryDataModel dm = new EquipCategoryDataModel();
			dm.setEquipcategories(loadEquipcategories());
			dm.setChildequipcategories(loadChildEquipcategories(dm.getEquipcategories()));
			
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение родительских категорий оборудования из БД
	 *
	 */
	public static ArrayList loadEquipcategories() {
		ArrayList equipcateg = new ArrayList();
		System.out.print("Load Equip Categories called");
		CDBCResultSet rs = CDBCConfigObject.findEquipcategories(false);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			equipcateg.add(new EquipCategoryVO(
				((Integer)ro.getColumn("classid").asObject()).intValue(), 
				ro.getColumn("classname").asString(),
				ro.getColumn("sectorslink").asString()
			));
		}
		return equipcateg;
	}
	
	/**
	 * Чтение дочерних категорий оборудования из БД
	 *
	 */
	public static HashMap loadChildEquipcategories(ArrayList parentequipcategs) {
		HashMap childequipcategset = new HashMap();
		Integer curCategory = null;
		System.out.print("Load Child Equip Categories called");
		CDBCResultSet rs = CDBCConfigObject.findEquipcategories(true);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			
			EquipCategoryVO eovo = new EquipCategoryVO(
				((Integer)ro.getColumn("classid").asObject()).intValue(), 
				ro.getColumn("classname").asString(),
				(Integer)ro.getColumn("parent_classid").asObject(),
				ro.getColumn("sectorslink").asString()
				);
			if (!eovo.getParentCode().equals(curCategory)) {
				curCategory = eovo.getParentCode(); 
			}
			ArrayList equipcateg = getMapCategory(childequipcategset, curCategory);
			equipcateg.add(eovo);
		}
		
		// Fill-in null categories with empty ArrayLists
		Iterator itp = parentequipcategs.iterator();
		while (itp.hasNext()) {
			EquipCategoryVO eovo = (EquipCategoryVO)itp.next();
			getMapCategory(childequipcategset, eovo.getParentCode());
		}
		return childequipcategset;
	}

	private static ArrayList getMapCategory(HashMap map, Integer category) {
		ArrayList equipcateg = (ArrayList)map.get(category);
		if (equipcateg == null) {
			equipcateg = new ArrayList();
			map.put(category, equipcateg);
		}
		return equipcateg;
	}
}
