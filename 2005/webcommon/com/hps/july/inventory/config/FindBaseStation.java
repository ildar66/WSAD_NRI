/*
 * Created on 07.08.2006
 *
 * Загрузка данных конфигурации в аплет
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.config.model.AppletPostResponse;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.FindBaseStationDataModel;
import com.hps.july.config.model.BaseStationVO;
;


/**
 * @author dima
 *
 */
public class FindBaseStation extends HttpServlet {

	/**
	 * 
	 */
	public FindBaseStation() {
		super();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			System.out.println("In FindBSService");
			int errorCode = 0;
			String errorMessage = "OK";
			ObjectInputStream in = new ObjectInputStream(request.getInputStream());
			FindBaseStationDataModel dm = null;
			try {
				dm = (FindBaseStationDataModel) in.readObject();
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
				dm.setBasestations(findBaseStations(dm.getSearchBy(), dm.getSearchParam(), dm.getOperator(), dm.isNeedWriteAccess()));
			}
			
			apresp.setErrorCode(errorCode);
			apresp.setErrorMessage(errorMessage);
			
			out.writeObject(apresp);
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Finding basestations
	 *
	 */
	public static ArrayList findBaseStations(String searchBy, String searchParam, String operator, boolean needWriteAccess) {
		ArrayList basestations = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findBaseStation(searchBy, searchParam);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			BaseStationVO baseStationVO = new BaseStationVO(((Integer)ro.getColumn("equipment").asObject()).intValue(),
															((Integer)ro.getColumn("number").asObject()).intValue(), 
															ro.getColumn("name").asString(),
															ro.getColumn("address").asString(),
															((Integer)ro.getColumn("position").asObject()).intValue());

			//System.out.println("checkBS = " + baseStationVO.getName() + ", id = " + baseStationVO.getCode());
			//boolean result = CDBCConfigObject.checkAccess(new Integer(baseStationVO.getCode()), operator, needWriteAccess);
			//System.out.println("result = " + result);
			//if (result) {
				basestations.add(baseStationVO);
			//}
		}
		return basestations;
	}
}
