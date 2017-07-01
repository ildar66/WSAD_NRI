/*
 * Created on 11.01.2007
 */
package com.hps.july.dictionary.valueobject;

/**
 * @author irogachev
 */
public class CurBaseStationComplect_VO {

	private String id;
	private String codenri;
	private String sect_a;
	private String sect_b;
	private String sect_c;
	private String sect_d;
	private String sect_e;
	private String sect_f;
	private String sect_g;
	private String sect_h;
	private String nfsitem_id;
	private String nfsitem_Name;
	private String nfsId;
	private String conftype;
	private String voltage; 
	private String sect_o900;
	private String sect_o1800;

	public CurBaseStationComplect_VO() {
		super();
	}

	/**
	 * @return
	 */
	public String getCodenri() {
		return codenri;
	}

	/**
	 * @return
	 */
	public String getConftype() {
		return conftype;
	}

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getNfsitem_id() {
		return nfsitem_id;
	}

	/**
	 * @return
	 */
	public String getSect_a() {
		return sect_a;
	}

	/**
	 * @return
	 */
	public String getSect_b() {
		return sect_b;
	}

	/**
	 * @return
	 */
	public String getSect_c() {
		return sect_c;
	}

	/**
	 * @return
	 */
	public String getSect_d() {
		return sect_d;
	}

	/**
	 * @return
	 */
	public String getSect_e() {
		return sect_e;
	}

	/**
	 * @return
	 */
	public String getSect_f() {
		return sect_f;
	}

	/**
	 * @return
	 */
	public String getSect_g() {
		return sect_g;
	}

	/**
	 * @return
	 */
	public String getSect_h() {
		return sect_h;
	}

	/**
	 * @return
	 */
	public String getVoltage() {
		return voltage;
	}

	/**
	 * @param string
	 */
	public void setCodenri(String string) {
		codenri = string;
	}

	/**
	 * @param string
	 */
	public void setConftype(String string) {
		conftype = string;
	}

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setNfsitem_id(String string) {
		nfsitem_id = string;
	}

	/**
	 * @param string
	 */
	public void setSect_a(String string) {
		sect_a = string;
	}

	/**
	 * @param string
	 */
	public void setSect_b(String string) {
		sect_b = string;
	}

	/**
	 * @param string
	 */
	public void setSect_c(String string) {
		sect_c = string;
	}

	/**
	 * @param string
	 */
	public void setSect_d(String string) {
		sect_d = string;
	}

	/**
	 * @param string
	 */
	public void setSect_e(String string) {
		sect_e = string;
	}

	/**
	 * @param string
	 */
	public void setSect_f(String string) {
		sect_f = string;
	}

	/**
	 * @param string
	 */
	public void setSect_g(String string) {
		sect_g = string;
	}

	/**
	 * @param string
	 */
	public void setSect_h(String string) {
		sect_h = string;
	}

	/**
	 * @param string
	 */
	public void setVoltage(String inVoltage) {
		/*
		if ((inVoltage != null) && (inVoltage.length() > 0) && 
			(Character.isDigit(inVoltage.charAt(0)))) {
			Double intVoltage = new Double(inVoltage);
			inVoltage = String.valueOf(intVoltage.intValue());
		} else {
			inVoltage = "";
		}
		*/
		voltage = getIntQ(inVoltage);
	}

	/**
	 * @return
	 */
	public String getNfsitem_Name() {
		return nfsitem_Name;
	}

	/**
	 * @param string
	 */
	public void setNfsitem_Name(String string) {
		nfsitem_Name = string;
	}

	/**
	 * @return
	 */
	public String getNfsId() {
		return nfsId;
	}

	/**
	 * @param string
	 */
	public void setNfsId(String string) {
		nfsId = string;
	}

	public String getSect_o900() {
		return sect_o900;
	}
	public void setSect_o900(String newSect_o900) {
		sect_o900 = newSect_o900;
	}
	public String getSect_o1800() {
		return sect_o1800;
	}
	public void setSect_o1800(String newSect_o1800) {
		sect_o1800 = newSect_o1800;
	}

	public static String getIntQ(String inDoubleStr) {
		String outStr;
		if ((inDoubleStr != null) && (inDoubleStr.length() > 0) && (Character.isDigit(inDoubleStr.charAt(0)))) {
			Double intVoltage = new Double(inDoubleStr);
			outStr = String.valueOf(intVoltage.intValue());
		} else {
			outStr = "";
		}
		return outStr;
	}

}
