package com.hps.july.inventory.formbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.hps.july.inventory.valueobject.Resource;
import com.hps.july.web.util.EditForm;
import com.hps.july.web.util.ValidateUtils;

/**
 * @author dimitry
 * Created 17.04.2006
 */
public class MountAct2Form2 extends EditForm { // ActionForm {
	private static final long serialVersionUID = 1L;

	private Integer oldPosNumber;
	// for support old july tags
	private String action = "Edit";
	
	private MountActBean mountAct = new MountActBean();
	
	private int controlButtonIndex = -1;
	private List controlButtonList = new ArrayList();
	
	private boolean deleteConfirm; 
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
	}
	
	
	public MountActControlButtonBean getControlButton(int index){
		if (index+1 > controlButtonList.size()){
			for (int i = controlButtonList.size(); i < index+1; i++){
				controlButtonList.add(new MountActControlButtonBean());
			}
		}
		return (MountActControlButtonBean) controlButtonList.get(index);
	}
	
	public int getControlButtonIndex() {
		return controlButtonIndex;
	}
	public void setControlButtonIndex(int controlButtonIndex) {
		this.controlButtonIndex = controlButtonIndex;
	}
	
	public MountActBean getMountAct() {
		return mountAct;
	}
	public void setMountAct(MountActBean mountAct) {
		this.mountAct = mountAct;
	}

	public Integer getOldPosNumber() {
		return oldPosNumber;
	}

	public void setOldPosNumber(Integer oldPosNumber) {
		this.oldPosNumber = oldPosNumber;
	}

	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}

	public String getProviderCode() {
		return getMountAct().getProviderCode();
	}

	public void setProviderCode(String providerCode) {
		getMountAct().setProviderCode(providerCode);
	}

	public String getProviderName() {
		return getMountAct().getProviderName();
	}

	public void setProviderName(String providerName) {
		getMountAct().setProviderName(providerName);
	}

	public String getWorkerCode() {
		return getMountAct().getWorkerCode();
	}

	public void setWorkerCode(String workerCode) {
		getMountAct().setWorkerCode(workerCode);
	}

	public String getWorkerName() {
		return getMountAct().getWorkerName();
	}

	public void setWorkerName(String workerName) {
		getMountAct().setWorkerName(workerName);
	}

	public String getWorkerTitle() {
		return getMountAct().getWorkerTitle();
	}

	public void setWorkerTitle(String workerTitle) {
		getMountAct().setWorkerTitle(workerTitle);
	}

	public Integer getDocument() {
		return getMountAct().getDocumentId();
	}

	public void setDocument(Integer document) {
		getMountAct().setDocumentId(document);
	}
	
	public ActionErrors preValidate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		// TODO check nothing? 
		
		return errors;
	}
	
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = preValidate(mapping, request);
		
		if (ValidateUtils.isEmpty(getMountAct().getPosNumber()))
			errors.add("mountAct.posNumber", new ActionError("error.mountact2.empty.posnumber"));
		
		else if (!ValidateUtils.isInteger(getMountAct().getPosNumber()))
			errors.add("mountAct.posNumber", new ActionError("error.mountact2.bad.posnumber"));
		
		else if (ValidateUtils.isEmpty(getMountAct().getComplectCode()))
			errors.add("mountAct.complectCode", new ActionError("error.mountact2.bad.complectCode"));
		
		if (ValidateUtils.isEmpty(getMountAct().getFrequencyRange()))
			errors.add("mountAct.frequencyRange", new ActionError("error.mountact2.empty.frequencyRange"));
		
		else if (!ValidateUtils.isContains(
				new String[] { MountActBean.GSM_FREQUENCY_TYPE, MountActBean.DCS_FREQUENCY_TYPE, 
						MountActBean.GSM_DCS_FREQUENCY_TYPE }, getMountAct().getFrequencyRange())) 
			errors.add("mountAct.frequencyRange", new ActionError("error.mountact2.bad.frequencyRange"));
		
		// check docPositions
		validateDocPositions(errors, getMountAct().getDocPositions().getDocPositions(), "mountAct.");

		// Проверим подрядчика
		if (ValidateUtils.isEmpty(getMountAct().getProviderCode()))
			errors.add("mountAct.providerCode", new ActionError("error.mountact2.empty.podrcode"));
		
		else if (!ValidateUtils.isInteger(getMountAct().getProviderCode()))
			errors.add("mountAct.providerCode", new ActionError("error.mountact2.bad.podrcode"));
		
		// Проверим ФИО подрядчика
		if (ValidateUtils.isEmpty(getMountAct().getInsuranceMan()))
			errors.add("mountAct.insuranceMan", new ActionError("error.mountact2.empty.insuranceman"));

		if (ValidateUtils.isEmpty(getMountAct().getWorkerCode()))
			errors.add("mountAct.workerCode", new ActionError("error.mountact2.empty.worker"));
		
		else if (!ValidateUtils.isInteger(getMountAct().getWorkerCode()))
			errors.add("mountAct.workerCode", new ActionError("error.mountact2.bad.worker"));
				
		if (ValidateUtils.isEmpty(getMountAct().getDate()))
			errors.add("mountAct.date", new ActionError("error.mountact2.empty.actdate"));

		if (!errors.empty())
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mountact2.haveerrors"));

//		Iterator itr = errors.properties();
//		System.out.print("Errors: [");
//		while (itr.hasNext()) {
//			System.out.print(itr.next() + ",");
//		}
//		System.out.println("]");
		
		return errors;
	}
	
	
	
	private void validateDocPositions(ActionErrors errors, Iterator docPositions, String parentPath) {
		
		for (int i=0; docPositions.hasNext(); i++){
			MountActDocPositionBean docPosition = (MountActDocPositionBean) docPositions.next();
			if (docPosition.getResource().getStockTakingType().equals(Resource.SERIAL_STOCK_TAKING_TYPE)){
				if (docPosition.getWorksNumber() != null && docPosition.getWorksNumber().equals(""))
					errors.add(parentPath + "docPosition["+docPosition.getIndex()+"].worksNumber", new ActionError("error.mountact2.empty.serial"));
				
				if (docPosition.getInventoryNumber() != null && docPosition.getInventoryNumber().equals(""))
					errors.add(parentPath + "docPosition["+docPosition.getIndex()+"].inventoryNumber", new ActionError("error.mountact2.empty.serial"));

				if (docPosition.getSubdivisionInventoryNumber() != null && docPosition.getSubdivisionInventoryNumber().equals(""))
					errors.add(parentPath + "docPosition["+docPosition.getIndex()+"].subdivisionInventoryNumber", new ActionError("error.mountact2.empty.serial"));
			}
			
			if (docPosition.getResource().getStockTakingType().equals(Resource.QUANTITY_STOCK_TAKING_TYPE)){
				if (docPosition.getQuantity() == null || docPosition.getQuantity().equals(new Integer(0)))
					errors.add(parentPath + "docPosition["+docPosition.getIndex()+"].quantity", new ActionError("error.mountact2.empty.qty"));
			}
			
			validateDocPositions(errors, docPosition.getDocPositions().getDocPositions(), parentPath + "docPosition["+i+"].");
		}
	}

	public Integer getVisualtype() {
		return getMountAct().getVisualType();
	}

	public void setVisualtype(Integer visualtype) {
		getMountAct().setVisualType(visualtype);
	}
	
	public int getApplication() {
		return com.hps.july.constants.Applications.INVENTORY;
	}
	
	public int getState() {
		return com.hps.july.inventory.APPStates.ASPPLIST;
	}
	
	/**
	 * @return
	 */
	public boolean isDeleteConfirm() {
		return deleteConfirm;
	}

	/**
	 * @param b
	 */
	public void setDeleteConfirm(boolean b) {
		deleteConfirm = b;
	}

}
