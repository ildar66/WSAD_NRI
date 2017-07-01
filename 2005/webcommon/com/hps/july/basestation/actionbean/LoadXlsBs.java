package com.hps.july.basestation.actionbean;


import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import java.util.*;
import com.hps.july.basestation.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.constants.Applications;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.util.*;
import com.hps.july.basestation.formbean.*;
import org.apache.struts.upload.FormFile;
//import com.hps.july.dataimport.beans.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Обработчик импорта данных по базовым станциям
 */
public class LoadXlsBs extends Action {
private int importXls(LoadXlsBsForm f, HttpServletRequest request, int taskId)
    throws Exception
{
	return 0;
	/*
	int impsesid = 0;
	Hashtable params = f.getInputParameters();
	File fileXls = null;

    try {
		int operator = 1; // only for wte!!! set operator = 0 for ws!!!
		try {
			operator = new OperatorAccessBean()
                    .findByLogin(request.getUserPrincipal().getName())
                    .getOperator();
        } catch (Exception ex) {
            System.out.println("Can't get Operator from request\n");
        }

        fileXls = readFile(request);
        byte[] data = receiveFileData(fileXls);
System.out.println("Received data len:"+(data != null?data.length:-1));
        DataImportAccessBean diab = new DataImportAccessBean();
System.out.println("Start processBS");
		long t = System.currentTimeMillis();
        impsesid = diab.processBs(fileXls.getName(), data, taskId, operator, params);
System.out.println("End processBS:"+(System.currentTimeMillis()-t));
		//Importer importer =
        //    new Importer(fileXls.getName(), data, taskId, operator, params);
        //impsesid = importer.process();
    } catch (Exception e) {
        System.out.println("Error in LoadXlsBs.importXls");
        e.printStackTrace(System.out);
		return 0;
	}
	if (impsesid == 0) {
        ActionErrors errors = new ActionErrors();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.load", fileXls.getName()));
        saveErrors(request, errors);
	    request.getSession().setAttribute("impsesid", new Integer(impsesid));
        throw new Exception();

    }
    request.getSession().setAttribute("impsesid", new Integer(impsesid));
    return impsesid;
        */
}
public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
{
//	navigate(mapping,form,request,response);
		
    int task = 3;
    request.getSession().setAttribute("task", new Integer(task));

    ActionErrors errors = new ActionErrors();
    try {
        DebugSupport.println("loadXlsBs perform started");
        LoadXlsBsForm aform = (LoadXlsBsForm) form;
        //aform.setRequest(request);
        aform.setRequestParams(request);
        if (request.getParameter("maxReport") == null) {
			aform.setMaxReport(false);
		}
		if (request.getParameter("submit.x") != null) {
			DebugSupport.println("loadXlsBs perform before validate");
			aform.validateValues(errors,request);
			DebugSupport.println("loadXlsBs perform after validate");
			boolean maxReport = aform.isMaxReport();
			importXls(aform, request, task);
			return mapping.findForward(maxReport ? "xlsMaxReport" : "xlsMinReport");
        }
    } catch (ValidationException e) {
        DebugSupport.printlnTest("!!!!!!errors=" + errors);
        DebugSupport.printlnError(e);
        saveErrors(request, errors);
        // do nothing 
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
    ParamsParser.setState(request, Applications.BASESTATION, APPStates.IMPORTXLS_BS);
    return mapping.findForward("main");
}
private File readFile(HttpServletRequest request) throws Exception {

    //read
    try {

        String fileName = request.getParameter("file");
        File uploadDir = new File(AppConstants.uploadDir);
        File xlsFile = new File(uploadDir, fileName);

        return xlsFile;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
private byte[] receiveFileData(File file)
	throws Exception
{
    //read
	java.io.FileInputStream fInpstream = null;
    try {
        byte[] bt = new byte[new Long(file.length()).intValue()];
        
		fInpstream = new java.io.FileInputStream(file);
		int res = fInpstream.read(bt);
        /*
		char[] ch = new char[new Long(file.length()).intValue()];
        FileReader reader = new FileReader(file.getPath());
        reader.read(ch);
        String str = new String(ch);
        bt= str.getBytes("Cp1251");
        int res = new Long(file.length()).intValue();
        */
        return bt;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    } finally {
	    if(fInpstream != null) fInpstream.close();
    }
}
}
