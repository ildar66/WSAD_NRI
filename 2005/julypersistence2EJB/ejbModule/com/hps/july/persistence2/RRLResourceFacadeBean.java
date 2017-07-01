package com.hps.july.persistence2;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import com.hps.july.persistence2.*;
import java.util.*;

/**
 * Логика работы с документами РРЛ
 * This is a Session Bean Class
 */
public class RRLResourceFacadeBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
/**
 * Создание ррл антенны
 * Creation date: (05.08.2004 11:54:27)
 */
public void createRRLAntena(com.hps.july.persistence2.RRLAntenaValue antenaValue) throws java.rmi.RemoteException{
	try {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		antenaValue.setResource(keyGen.getNextKey("tables.resources"));
		RRLAntennaResourceAccessBean bean = new RRLAntennaResourceAccessBean(
			antenaValue.getResource(),
			antenaValue.getName(), 
			antenaValue.getModel(), 
			antenaValue.getNotes(),
			antenaValue.getComplect(), 
			antenaValue.getCountpolicy(),
			antenaValue.getBoxable(), 
			antenaValue.getPriceable(), 
			antenaValue.getComplectpart(),
			antenaValue.getActive(), 
			antenaValue.getSubType(),
			antenaValue.getFreqdevlowk(),
			antenaValue.getFreqdevlowlog10(),
			antenaValue.getFreqdevhighk(), 
			antenaValue.getFreqdevhighlog10(),
	    	antenaValue.getMkkrrecomm(), 
	    	antenaValue.getProtocolnum(), 
			antenaValue.getProtocoldate());
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error creating RRLAntenaResource");
		e.printStackTrace(System.out);
	}
		
	
}
/**
 * Создание группы параметров ррл антенны, зависящих от ее диаметра
 * Creation date: (05.08.2004 11:55:02)
 */
public void createRRLAntParams(com.hps.july.persistence2.RRLResourceParamsValue paramsValue) throws java.rmi.RemoteException{
	try {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		paramsValue.setRrlantid(keyGen.getNextKey("tables.rrlantparams"));
		RRLAntParamsAccessBean bean = new RRLAntParamsAccessBean (
			paramsValue.getRrlantid(), 
			paramsValue.getResource(),
			paramsValue.getAntdiam(), 
			paramsValue.getAmplifkoeff(),
			paramsValue.getDnangleh(), 
			paramsValue.getDnanglew());
	} catch(Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error creating RRLAntParams");
		e.printStackTrace(System.out);
	}
}
/**
 * Создание группы параметров ррл антенны, зависящих от скорости потока
 * Creation date: (05.08.2004 12:17:55)
 */
public void createRRLSpeedParams(com.hps.july.persistence2.RRLResourceSpeedParamsValue speedValue) throws java.rmi.RemoteException{
	try {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		speedValue.setRrlspeedid(keyGen.getNextKey("tables.rrlspeedparams"));
		RRLSpeedParamsAccessBean bean = new RRLSpeedParamsAccessBean(
			speedValue.getRrlspeedid(),
			speedValue.getResource(),
			speedValue.getStreamspeed(),
			speedValue.getRadiationclass(),
			speedValue.getRecvsensitivity());
	} catch(Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error creating RRLSpeedParams");
		e.printStackTrace(System.out);
	}
}
/**
 * Удаление ррл антенны с сопутствующими параметрами, зависящими от
 * диаметра антенны и скорости потока
 * Creation date: (05.08.2004 12:18:20)
 */
public void deleteRRLAntena(int resource) throws java.rmi.RemoteException{
	try{
		RRLAntParamsAccessBean paramBean = new RRLAntParamsAccessBean();
		Enumeration paramsToDelete = paramBean.findByResource(resource);
		while(paramsToDelete.hasMoreElements()) {
			RRLAntParamsAccessBean param = (RRLAntParamsAccessBean)paramsToDelete.nextElement();
			param.getEJBRef().remove();
		}
		RRLSpeedParamsAccessBean speedBean = new RRLSpeedParamsAccessBean();
		Enumeration speedsToDelete = speedBean.findByResource(resource);
		while(speedsToDelete.hasMoreElements()) {
			RRLSpeedParamsAccessBean speed = (RRLSpeedParamsAccessBean)speedsToDelete.nextElement();
			speed.getEJBRef().remove();
		}
		RRLAntennaResourceAccessBean antenaBean = new RRLAntennaResourceAccessBean();
		antenaBean.setInitKey_resource(resource);
		antenaBean.refreshCopyHelper();
		antenaBean.getEJBRef().remove();
	} catch (Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error deleting rrl antena resource");
		e.printStackTrace(System.out);
	}
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
/**
 * Обновление ррл антенны
 * Creation date: (05.08.2004 16:49:16)
 */
public void updateRRLAntena(com.hps.july.persistence2.RRLAntenaValue antenaValue) throws java.rmi.RemoteException{
	try {
		RRLAntennaResourceAccessBean antenaBean = new RRLAntennaResourceAccessBean();
		antenaBean.setInitKey_resource(antenaValue.getResource());
		antenaBean.commitCopyHelper();
		antenaBean.getEJBRef().remove();
		this.createRRLAntena(antenaValue);
	} catch(Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error updating RRLAntenaResource");
		e.printStackTrace(System.out);
	}
}
/**
 * Обновление группы параметров ррл антенны, зависящих от ее диаметра
 * Creation date: (05.08.2004 16:52:10)
 * @param paramsValue com.hps.july.dictionary.valueobject.RRLResourceParamsValue
 */
public void updateRRLAntParams(com.hps.july.persistence2.RRLResourceParamsValue paramsValue) throws java.rmi.RemoteException{
	try{
		RRLAntParamsAccessBean paramsBean = new RRLAntParamsAccessBean();
		paramsBean.setInitKey_rrlantid(paramsValue.getRrlantid());
		paramsBean.commitCopyHelper();
		paramsBean.getEJBRef().remove();
		this.createRRLAntParams(paramsValue);
	} catch(Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error updating RRLAntParams");
		e.printStackTrace(System.out);
	}
}
/**
 * Обновление группы параметров ррл антенны, зависящих от скорости потока
 * Creation date: (05.08.2004 16:54:04)
 * @param speedValue com.hps.july.dictionary.valueobject.RRLResourceSpeedParamsValue
 */
public void updateRRLSpeedParams(com.hps.july.persistence2.RRLResourceSpeedParamsValue speedValue) throws java.rmi.RemoteException{
	try{
		RRLSpeedParamsAccessBean speedBean = new RRLSpeedParamsAccessBean();
		speedBean.setInitKey_rrlspeedid(speedValue.getRrlspeedid());
		speedBean.commitCopyHelper();
		speedBean.getEJBRef().remove();
		this.createRRLSpeedParams(speedValue);
	} catch(Exception e) {
		getSessionContext().setRollbackOnly();
		System.out.println("Error updating RRLSpeedParams");
		e.printStackTrace(System.out);
	}
}
}
