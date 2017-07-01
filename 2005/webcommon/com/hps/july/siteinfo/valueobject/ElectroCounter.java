package com.hps.july.siteinfo.valueobject;

import java.util.HashMap;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.text.FieldPosition;

/**
 * Служебный класс реализующий элемент списка электросчетчиков.
 * Creation date: (10.08.2004 18:58:41)
 * @author: Vadim Glushkov
 */
public class ElectroCounter {

	private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
	private HashMap attributes = null;

	private Integer id = null;
	private String vendorNumber = null;
	private String productionYear = null;
	private Date installationDate = null;
	private Integer initialSettings = null;
	private Date lastVerification = null;
	private Date nextVerification = null;
	private Integer verificationInterval = null;
	private Integer state = null;
	private Integer replacementCounter = null;
	private Date replacementDate = null;
	private String replacementReason = null;
	private Integer replacementSettings = null;
	private Integer modifieidBy = null;
	private Date modifiedDate = null;

	private Boolean isError = Boolean.FALSE;
	private Boolean isWarning = Boolean.FALSE;

	/**
	 * ElectroCounter constructor comment.
	 */
	public ElectroCounter() {
		this.attributes = new HashMap();
	}
	/**
	 * ElectroCounter constructor comment.
	 */
	public ElectroCounter(HashMap attributes) {
		this.attributes = attributes;
	}
	public Object getAttribute(String name) {
		return (name != null) ? attributes.get(name) : null;
	}
	public Boolean getError() {
		isError = (Boolean) attributes.get("error");
		return (isError != null) ? isError : Boolean.FALSE;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.08.2004 14:55:43)
	 * @return java.lang.String
	 */
	public String getFormatLastVerification() {
		this.lastVerification = (Date) attributes.get("last_verification");
		StringBuffer result = new StringBuffer("");
		if (this.lastVerification != null)
			result = sdf.format(this.lastVerification, result, new FieldPosition(0));
		return result.toString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (26.08.2004 14:49:40)
	 * @return java.lang.String
	 */
	public String getFormatNextVerification() {
		this.nextVerification = (Date) attributes.get("next_verification");
		StringBuffer result = new StringBuffer("");
		if (this.nextVerification != null)
			sdf.format(this.nextVerification, result, new FieldPosition(0));
		return result.toString();
	}
	public Integer getId() {
		id = (Integer) attributes.get("counterid");
		return (id != null) ? id : null;
	}
	public Integer getInitialSettings() {
		return initialSettings;
	}
	public Date getInstallationDate() {
		installationDate = (Date) attributes.get("installation_date");
		return (installationDate != null) ? installationDate : null;
	}
	public Date getLastVerification() {
		lastVerification = (Date) attributes.get("last_verification");
		return (lastVerification != null) ? lastVerification : null;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public Integer getModifieidBy() {
		return modifieidBy;
	}
	public String getName() {
		String name = (String) attributes.get("name");
		return (name != null) ? name : null;
	}
	public Date getNextVerification() {
		nextVerification = (Date) attributes.get("next_verification");
		return (nextVerification != null) ? nextVerification : null;
	}
	public String getProductionYear() {
		productionYear = (String) attributes.get("production_year");
		return (productionYear != null) ? productionYear : null;
	}
	public Integer getReplacementCounter() {
		return replacementCounter;
	}
	public Date getReplacementDate() {
		return replacementDate;
	}
	public String getReplacementReason() {
		return replacementReason;
	}
	public Integer getReplacementSettings() {
		return replacementSettings;
	}
	public Integer getState() {
		state = (Integer) attributes.get("cstate");
		return (state != null) ? state : null;
	}
	public String getStateStr() {
		String stateStr = String.valueOf(getState());
		if (getState().equals(new Integer(1))) {
			stateStr = "Активный";
		} else if (getState().equals(new Integer(2))) {
			stateStr = "Заменённый";
		} else if (getState().equals(new Integer(3))) {
			stateStr = "Демонтированный";
		}
		return stateStr;
	}
	public String getVendorNumber() {
		vendorNumber = (String) attributes.get("vendor_number");
		return (vendorNumber != null) ? vendorNumber : null;
	}
	public Integer getVerificationInterval() {
		return verificationInterval;
	}
	public Boolean getWarning() {
		isWarning = (Boolean) attributes.get("warning");
		return (isWarning != null) ? isWarning : Boolean.FALSE;
	}
	public void setError(Boolean error) {
		isError = error;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setInitialSettings(Integer initialSettings) {
		this.initialSettings = initialSettings;
	}
	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}
	public void setLastVerification(Date lastVerification) {
		this.lastVerification = lastVerification;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public void setModifieidBy(Integer modifieidBy) {
		this.modifieidBy = modifieidBy;
	}
	public void setNextVerification(Date nextVerification) {
		this.nextVerification = nextVerification;
	}
	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}
	public void setReplacementCounter(Integer replacementCounter) {
		this.replacementCounter = replacementCounter;
	}
	public void setReplacementDate(Date replacementDate) {
		this.replacementDate = replacementDate;
	}
	public void setReplacementReason(String replacementReason) {
		this.replacementReason = replacementReason;
	}
	public void setReplacementSettings(Integer replacementSettings) {
		this.replacementSettings = replacementSettings;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}
	public void setVerificationInterval(Integer verificationInterval) {
		this.verificationInterval = verificationInterval;
	}
	public void setWarning(Boolean warning) {
		isWarning = warning;
	}
	public String getIsVendorPowerSupply() {
		String isVendorPowerSupply = (String) attributes.get("isVendorPowerSupply");
		return (isVendorPowerSupply != null && isVendorPowerSupply.equals("Y")) ? "Арендодатель" : "";
	}
	public String getCode() {
		String code = (String) attributes.get("code");
		return (code != null) ? code : "";
	}
	public String getZoneName() {
		String zoneName = (String) attributes.get("zoneName");
		return (zoneName != null) ? zoneName : "";
	}
}
