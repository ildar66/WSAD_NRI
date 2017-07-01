/*
 * Created on 26.09.2006
 *
 * Загрузка списка ресурсов антенн в аплет
 */
package com.hps.july.inventory.config;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.config.model.AppletPostResponse;
import com.hps.july.config.model.AntennaResourceDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.AntennaResourceVO;


/**
 * @author dima
 *
 */
public class LoadAntennaResources extends HttpServlet {

	/**
	 * 
	 */
	public LoadAntennaResources() {
		super();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			System.out.println("In find worker Service");
			int errorCode = 0;
			String errorMessage = "OK";
			ObjectInputStream in = new ObjectInputStream(request.getInputStream());
			AntennaResourceDataModel dm = null;
			try {
				dm = (AntennaResourceDataModel) in.readObject();
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
				Integer band = null;
				if ("900".equals(dm.getBand()))
					band = new Integer(900);
				else if ("1800".equals(dm.getBand()))
					band = new Integer(1800);
				dm.setResources(loadAntennaResources(band, dm.getPolarization(), dm.getModel()));
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
	public static ArrayList loadAntennaResources(Integer aband, String apolarization, String amodel) {
		CDBCResultSet rs = CDBCConfigObject.findAntennaResources(aband, apolarization, amodel);
		ListIterator it = rs.listIterator();


		Map result = new HashMap();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();

			AntennaResourceVO antenna = new AntennaResourceVO(((Integer)ro.getColumn("resource").asObject()).intValue(), ro.getColumn("model").asString(), 
															  ro.getColumn("name").asString(), ro.getColumn("polarization").asString(), ro.getColumn("band").asString());

			Integer id = new Integer(antenna.getCode());
			if (result.containsKey(id)) {
				((AntennaResourceVO)result.get(id)).setBands(((AntennaResourceVO)result.get(id)).getBands() + "/" + ro.getColumn("band").asString());
			} else {
				result.put(id, antenna);
			}
		}

		return new ArrayList(result.values());
	}

}
