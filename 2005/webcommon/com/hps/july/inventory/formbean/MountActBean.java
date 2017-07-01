package com.hps.july.inventory.formbean;

import java.io.Serializable;

/**
 * @author dimitry
 * Created 21.04.2006
 */
public class MountActBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public static String GSM_FREQUENCY_TYPE = "S";
	public static String DCS_FREQUENCY_TYPE = "C";
	public static String GSM_DCS_FREQUENCY_TYPE = "G";
	
	public static Integer INTRODUCE_STATE = new Integer(1);
	public static Integer COUNTING_STATE = new Integer(2);
	
	private Integer positionCode;
	
	private Integer documentId;
	private String date;
	private String posNumber;

	private Integer complectCode;
	private String complectName;
	
	private Integer projectId;
	private String projectName;
	
	private String providerCode;
	private String providerName;

	private Integer ownerCode;
	
	private String workerCode;
	private String workerName;
	private String workerTitle;
	
	private String insuranceMan;

	// TODO поддержка фирм
	private Integer visualType = new Integer(1);
	private boolean needApprove;
	
	private Integer documentState;
	private String frequencyRange;
	
	
	/*
	 * OLD FIELDS 
	 */
	
	
	
	/*
	 * NEW FIELDS
	 */
	private MountActDocPositionListBean docPositions = new MountActDocPositionListBean(null);

	public MountActDocPositionListBean getDocPositions() {
		return docPositions;
	}
	
	public MountActDocPositionBean getDocPosition(int index){
		return docPositions.get(index);
	}
	
	
	public void setDocPositions(MountActDocPositionListBean docPositions) {
		this.docPositions = docPositions;
	}

	public Integer getComplectCode() {
		return complectCode;
	}

	public void setComplectCode(Integer complectCode) {
		this.complectCode = complectCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getInsuranceMan() {
		return insuranceMan;
	}

	public void setInsuranceMan(String insuranceMan) {
		this.insuranceMan = insuranceMan;
	}

	public boolean isNeedApprove() {
		return needApprove;
	}

	public void setNeedApprove(boolean needApprove) {
		this.needApprove = needApprove;
	}

	public Integer getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(Integer ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getPosNumber() {
		return posNumber;
	}

	public void setPosNumber(String posNumber) {
		this.posNumber = posNumber;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public Integer getDocumentState() {
		return documentState;
	}

	public void setDocumentState(Integer documentState) {
		this.documentState = documentState;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Integer getVisualType() {
		return visualType;
	}

	public void setVisualType(Integer visualType) {
		this.visualType = visualType;
	}

	public String getWorkerCode() {
		return workerCode;
	}

	public void setWorkerCode(String workerCode) {
		this.workerCode = workerCode;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerTitle() {
		return workerTitle;
	}

	public void setWorkerTitle(String workerTitle) {
		this.workerTitle = workerTitle;
	}

	public Integer getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(Integer positionCode) {
		this.positionCode = positionCode;
	}

	public String getComplectName() {
		return complectName;
	}

	public void setComplectName(String complectName) {
		this.complectName = complectName;
	}

	public boolean isCountingState() {
		return COUNTING_STATE.equals(getDocumentState());
	}

	public boolean isIntroduceState() {
		return getDocumentState() == null || INTRODUCE_STATE.equals(getDocumentState());
	}

	public String getFrequencyRange() {
		return frequencyRange;
	}

	public void setFrequencyRange(String frequencyRange) {
		this.frequencyRange = frequencyRange;
	}
	
	
}
