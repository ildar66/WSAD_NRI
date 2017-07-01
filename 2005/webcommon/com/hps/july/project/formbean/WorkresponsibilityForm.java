package com.hps.july.project.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
 * Форма редактирования ответственного.
 * Creation date: (15.01.2002 14:08:44)
 * @author: Administrator
 */
public class WorkresponsibilityForm extends com.hps.july.web.util.EditForm {
	private com.hps.july.persistence.PositionAccessBean positions;
	private com.hps.july.persistence.WorkerAccessBean workers;
	private com.hps.july.persistence.ResponsibilityTypeAccessBean types;
	
	private com.hps.july.web.util.StringAndIntegerProperty workercode;
	private java.lang.String workername;
	private java.lang.Integer poscode;
	private java.lang.String posname;
	private com.hps.july.web.util.StringAndIntegerProperty typecode;
	private java.lang.String typename;
	private java.lang.String posid;
/**
 * Insert the method's description here.
 * Creation date: (05.06.2002 17:19:04)
 */
public WorkresponsibilityForm() {
	typecode = new com.hps.july.web.util.StringAndIntegerProperty();
	workercode = new com.hps.july.web.util.StringAndIntegerProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	WorkresponsibilityListForm aform = (WorkresponsibilityListForm)request.getSession().getAttribute( "WorkresponsibilityListForm" );
	setPoscode(new Integer(aform.getStorageplace()));
    PositionResponsibleWorkersAccessBean bean = new PositionResponsibleWorkersAccessBean(typecode.getInteger(), 
	    workercode.getInteger(), poscode );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public PositionAccessBean constructPositions() throws Exception {

	if (positions == null) {	
		// Construct workers bean
		if (poscode != null) {
			positions = new PositionAccessBean();
			positions.setInitKey_storageplace(poscode.intValue());
			positions.refreshCopyHelper();
		}
	}
	return positions;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public ResponsibilityTypeAccessBean constructTypes() throws Exception {

	if (types == null) {	
		// Construct workers bean
		if (!typecode.isEmpty()) 
			if (typecode.isOk()) {
				types = new ResponsibilityTypeAccessBean();
				types.setInitKey_responsibilityType(typecode.getInteger().intValue());
				types.refreshCopyHelper();
			}
	}
	return types;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public WorkerAccessBean constructWorkers() throws Exception {

	if (workers == null) {	
		// Construct workers bean
		if (!workercode.isEmpty()) 
			if (workercode.isOk()) {
				workers = new WorkerAccessBean();
				workers.setInitKey_worker(workercode.getInteger().intValue());
				workers.refreshCopyHelper();
			}
	}
	return workers;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.PROJECT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	PositionResponsibleWorkersAccessBean bean = new PositionResponsibleWorkersAccessBean();
	bean.setInitKey_position_storageplace( getPoscode() );
	bean.setInitKey_type_responsibilityType( getTypecode() );
	bean.setInitKey_resptype("W");
	//bean.setInitKey_worker_worker( getWorkercode() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:26)
 * @return java.lang.Integer
 */
public java.lang.Integer getPoscode() {
	return poscode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:12:34)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Position getPosition() throws Exception {

	PositionAccessBean bean = constructPositions();
	if (bean != null)
	  return (Position)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:46)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.project.APPStates.EDITWRSP;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public ResponsibilityType getType() throws Exception {

	ResponsibilityTypeAccessBean bean = constructTypes();
	if (bean != null)
	  return (ResponsibilityType)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:31:24)
 * @return java.lang.Integer
 */
public java.lang.Integer getTypecode() {
	return typecode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:32:25)
 * @return java.lang.String
 */
public java.lang.String getTypecodeFrm() {
	return typecode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:31:49)
 * @return java.lang.String
 */
public java.lang.String getTypename() {
	return typename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.05.2002 14:05:43)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getTyperesponsibilities() {
	try {
		com.hps.july.persistence.ResponsibilityTypeAccessBean bean = new com.hps.july.persistence.ResponsibilityTypeAccessBean();
		return bean.findAllOrderByCodeAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Worker getWorker() throws Exception {

	WorkerAccessBean bean = constructWorkers();
	if (bean != null)
	  return (Worker)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:29:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getWorkercode() {
	return workercode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:32:50)
 * @return int
 */
public String getWorkercodeFrm() {
	return workercode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:29:52)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	WorkresponsibilityListForm aform = (WorkresponsibilityListForm)request.getSession().getAttribute( "WorkresponsibilityListForm" );
	setPoscode(new Integer(aform.getStorageplace()));
	setPosid(aform.getPosid());
	setPosname(aform.getPosname());
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:26)
 * @param newPoscode java.lang.Integer
 */
public void setPoscode(java.lang.Integer newPoscode) {
	poscode = newPoscode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:12:34)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setPosition(PositionAccessBean newPosition) throws Exception {
	if (newPosition == null) {
	    poscode = new java.lang.Integer(0);
	    posid = "";
	    posname = "";
	}
	else {
		poscode = new Integer(newPosition.getStorageplace());
		posid = "";
		if (newPosition.getGsmid() != null)
			posid = "D" + newPosition.getGsmid() + " ";
		if (newPosition.getDampsid() != null)
			posid = posid + "A" + newPosition.getDampsid();
			
		posname = newPosition.getName();
		if ((newPosition.getDampsname() != null) && (newPosition.getDampsname().length() > 0) )
			posname = posname + " / " + newPosition.getDampsname();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:46)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setType(ResponsibilityTypeAccessBean newType) throws Exception {
	if (newType == null) {
	    typecode.setString("");
	    typename = "";
	}
	else {
		typecode.setInteger(new Integer(newType.getResponsibilityType()));
		typename = newType.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:31:24)
 * @param newTypecode java.lang.Integer
 */
public void setTypecode(java.lang.Integer newTypecode) {
	typecode.setInteger(newTypecode);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:32:25)
 * @param newTypecodeFrm java.lang.String
 */
public void setTypecodeFrm(java.lang.String newTypecodeFrm) {
	typecode.setString(newTypecodeFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:31:49)
 * @param newTypename java.lang.String
 */
public void setTypename(java.lang.String newTypename) {
	typename = newTypename;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setWorker(WorkerAccessBean newWorker) throws Exception {
	if (newWorker == null) {
	    workercode.setString("");
	    workername = "";
	}
	else {
		workercode.setInteger(new Integer(newWorker.getWorker()));
		workername = newWorker.getMan().getFullName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:29:36)
 * @param newWorkercode java.lang.Integer
 */
public void setWorkercode(java.lang.Integer newWorkercode) {
	workercode.setInteger(newWorkercode);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:32:50)
 * @param newWorkercodeFrm int
 */
public void setWorkercodeFrm(java.lang.String newWorkercodeFrm) {
	workercode.setString(newWorkercodeFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:29:52)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	
	try {
		if (getPoscode() != null)
			constructPositions();
	} catch (Exception ex) {
		if (ErrorProcessor.isRecordNotExistException(ex))
		  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.workresponsibility.position"));
		else
		  throw ex;
	}
	
	if (typecode.isEmpty())
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.workresponsibility.type"));
	else if (!typecode.isOk())
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.workresponsibility.type"));
	else
		try {
			constructTypes();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.workresponsibility.type"));
			else
			  throw ex;
		}
		
	if (workercode.isEmpty())
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.workresponsibility.worker"));
	else if (!workercode.isOk())
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.workresponsibility.worker"));
	else
		try {
			constructWorkers();
			if (workers.getDivision() == null)
			   errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.workresponsibility.worker1"));
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			   errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.workresponsibility.worker"));
			else
			   throw ex;
		}
	  
	if (errors.empty()) {
		// Check responsibility uniquiness
		boolean isUniqueResp = false;
		try {
			PositionResponsibleWorkersAccessBean abean = new PositionResponsibleWorkersAccessBean();
			abean.setInitKey_position_storageplace( getPoscode() );
			abean.setInitKey_type_responsibilityType( getTypecode() );
			abean.setInitKey_resptype("W");
			abean.refreshCopyHelper();
		} catch (Exception e) {
			if (ErrorProcessor.isRecordNotExistException(e))
				isUniqueResp = true;
			else
			  throw e;
		}

		if (!isUniqueResp) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.duplicate.workresponsibility.worker"));
		}
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
