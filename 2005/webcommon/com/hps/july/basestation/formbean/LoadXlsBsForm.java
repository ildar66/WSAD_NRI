package com.hps.july.basestation.formbean;

import java.io.File;
import com.hps.july.web.util.ValidationException;
import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.persistence.RegionAccessBean;
import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.dataimport.dataobjects.BsBlockHandler;
import com.hps.july.siteinfo.valueobject.Position;
import com.hps.july.apptags.*;

/**
 * Форма загрузки данных по БС
 */
public class LoadXlsBsForm extends com.hps.july.web.util.EditForm
{
	private boolean maxReport=false;
	private RegionAccessBean region;
	private StringAndInteger regionId=new StringAndInteger();
	private Vector regions;
	private String file;
	private String remoteUser;
	private boolean isAdmin;
public LoadXlsBsForm()
{
	super();
	setLastVisited(true);
}
public AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception{
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 14:21:26)
 */
private void constructRegion() throws Exception {
	try{
	region=new RegionAccessBean();
	region.setInitKey_regionid(regionId.getInt());
	region.refreshCopyHelper();
	}catch(Exception e){
		DebugSupport.printlnError(e);
		throw e;
		}
	
	}
public int getApplication(){
	return 0;
}
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request){
	return null;
}
public Hashtable getInputParameters() {
	Hashtable table=new Hashtable();
	table.put(BsBlockHandler.KEY_REGION,getRegionId());
//	table.put(BsBlockHandler.KEY_PLANSTATE,"2");
	return table;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 14:12:28)
 * @return java.lang.String
 */
public Integer getRegionId() {
	return regionId.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 14:12:28)
 * @return java.lang.String
 */
public String getRegionIdFrm() {
	return regionId.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 14:16:01)
 * @return java.lang.String
 */
public String getRegionName() throws Exception {
	return region.getRegname();
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 20:02:35)
 * @return java.util.Vector
 */
public java.util.Vector getRegions() throws Exception {
    try {
        //DebugSupport.printlnTest("positionForm.getRegions started request="+request);
        regions =
            regions == null
                ? new RegionObject().findAllEdit(
                    getRemoteUser(),
                    new Boolean(isAdmin),
                    SearchConstants.SEARCH_ALL)
                : regions;
        //DebugSupport.printlnTest("positionForm.getRegions vec=" + vec);
        return regions;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
public String getRemoteUser() {
	return remoteUser;
}
public int getState(){
	return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 14:59:57)
 * @return boolean
 */
public boolean isMaxReport() {
	return maxReport;
}
/**
 * Insert the method's description here.
 * Creation date: (11.04.2003 14:59:57)
 * @param newMaxReport boolean
 */
public void setMaxReport(boolean newMaxReport) {
	maxReport = newMaxReport;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 14:12:28)
 * @return java.lang.String
 */
public void setRegionIdFrm(String regFrm) throws Exception {
    regionId.setString(regFrm);
    if (regFrm.equals("0")) {
        region = null;
    }
    //constructRegion();
}
public void setRequestParams(HttpServletRequest request)
{
	remoteUser = request.getRemoteUser();
	isAdmin = request.isUserInRole("administrator");
}
public String toString(){
	StringBuffer sb = new StringBuffer();
	//sb.append("file="+file+";\n");
	//if(file != null)
	//	sb.append("fileName="+file.getFileName()+";\n");
	//sb.append("byCross="+byCross+";\n");
	sb.append("maxReport="+maxReport+";\n");
	return sb.toString();
}
private void validateFile(ActionErrors errors, HttpServletRequest request)
	throws Exception
{
    //read
	try	{
		if (request.getParameter("file") == null) {
			throw new Exception();
			//saveErrors(request, errors);
			//return false;
		}
		
		String fileName = request.getParameter("file");
		File uploadDir = new File(AppConstants.uploadDir);
		File xlsFile = new File(uploadDir, fileName);

		if (xlsFile != null && xlsFile.getName().length() > 0 && xlsFile.length() > 0) {
	        if (!xlsFile.getName().endsWith(".xls")) {
	            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.extension", xlsFile.getName()));
				//saveErrors(request, errors);
				//throw new Exception();
			}
	        if (xlsFile.length() < 0 || xlsFile.length() > 1048576) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file.length"));
	        }
		} else {
			throw new Exception();
		}
	} catch(Exception e) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.file"));
	}
    //return false;
}
private void validateRegion(ActionErrors errors,HttpServletRequest request)
	throws Exception
{
	if (!regionId.isOkAndNotEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.xlsbs.region"));
        return;
    } else if (
        !HasRegionAccessTag.hasAccessRegion(request, getRegionIdFrm(), HasRegionAccessTag.ACTION_ADD, "2")) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.xlsbs.region"));
    }

    try {
        constructRegion();
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }

}
public void validateValues(ActionErrors errors,HttpServletRequest request) throws Exception {

    if (request.getParameter("submit.x") != null) {
        validateFile(errors,request);
    }
    validateRegion(errors,request);

    if (!errors.empty())
        throw new ValidationException();
}
}
