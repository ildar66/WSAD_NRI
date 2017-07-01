/*
 * Created on 07.08.2006
 *
 * Загрузка списка документов в аплет
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
import com.hps.july.config.model.DocumentDataModel;
import com.hps.july.config.model.CDBCConfigObject;
import com.hps.july.config.model.DocumentVO;
import com.hps.july.config.model.ExpeditionVO;
import com.hps.july.config.model.OrganizationVO;
import com.hps.july.config.model.StoreVO;
import com.hps.july.config.model.WorkerVO;


/**
 * @author dima
 *
 */
public class LoadDocuments extends HttpServlet {

	/**
	 * 
	 */
	public LoadDocuments() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			String contentType = "application/x-java-serialized-object";
			response.setContentType(contentType);
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			
			int ibasestation = Integer.parseInt(request.getParameter("basestation"));
			DocumentDataModel dm = new DocumentDataModel();
			dm.setDocuments(loadDocuments(ibasestation));
			
			out.writeObject(dm);
			out.flush();
	}
	
	/**
	 * Чтение документов из БД
	 *
	 */
	public static ArrayList loadDocuments(int ibasestation) {
		ArrayList docs = new ArrayList();
		CDBCResultSet rs = CDBCConfigObject.findCfgDocuments(ibasestation);
		ListIterator it = rs.listIterator();
		while (it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			DocumentVO doc = new DocumentVO();
			doc.setCode(((Integer)ro.getColumn("document").asObject()).intValue());
			doc.setConfigSource(((Integer)ro.getColumn("savconfigid_old").asObject()).intValue());
			doc.setConfigDest(((Integer)ro.getColumn("savconfigid_new").asObject()).intValue());
			doc.setDocindex(((Integer)ro.getColumn("blankindex").asObject()).intValue());
			doc.setDocnumber(ro.getColumn("blanknumber").asString());
			doc.setDocdate((java.util.Date)ro.getColumn("blankdate").asObject());
			doc.setState(ro.getColumn("state").asString());
			Integer storedem = (Integer)ro.getColumn("storedem").asObject();
			if (storedem != null) {
				doc.setStore1(new StoreVO(storedem.intValue(), 
					ro.getColumn("storedemname").asString()));
			}
			Integer storebad = (Integer)ro.getColumn("storebad").asObject();
			if (storebad != null) {
				doc.setStore2(new StoreVO(storebad.intValue(), 
					ro.getColumn("storebadname").asString()));
			}
			ExpeditionVO expvo = null;
			Integer iworker = (Integer)ro.getColumn("expeditor").asObject();
			Integer iorganization = (Integer)ro.getColumn("organization").asObject();
			if (iworker != null) {
				expvo = new ExpeditionVO(((Integer)ro.getColumn("from").asObject()).intValue(),
					new WorkerVO(iworker.intValue(), ro.getColumn("expname").asString()));
			} else if (iorganization != null) {
				expvo = new ExpeditionVO(((Integer)ro.getColumn("from").asObject()).intValue(),
					new OrganizationVO(iorganization.intValue(), ro.getColumn("expname").asString(),
					ro.getColumn("insuranceman").asString()));
			}
			doc.setExpeditor(expvo);
			int haveInserts = ((Integer)ro.getColumn("haveinserts").asObject()).intValue();
			int haveChanges = ((Integer)ro.getColumn("havechanges").asObject()).intValue();
			int haveDeletes = ((Integer)ro.getColumn("havedeletes").asObject()).intValue();
			doc.setHaveInserts(haveInserts==1);
			doc.setHaveChanges(haveChanges==1);
			doc.setHaveDeletes(haveDeletes==1);
			docs.add(doc);
		}
		return docs;
	}

}
