/*
 * Created on 26.09.2006
 *
 */
package com.hps.july.config.model;

import java.io.Serializable;

/**
 * Ресурс типа антенна
 * @author dima
 *
 */
public class AntennaResourceVO extends ResourceVO implements Serializable, Comparable {

	private String fullname;
	private String polarization;
	private String bands;

	public AntennaResourceVO() {
		super();
	}

	public int hashCode() {
		return this.getCode();
	}

	public boolean equals(Object o1) {
		if (!(o1 instanceof AntennaResourceVO)) {
			return false;
		}

		AntennaResourceVO antennaResourceVO = (AntennaResourceVO) o1;
		return antennaResourceVO.getCode() == this.getCode();
	}


	public AntennaResourceVO(int acode, String aname, String afullname, String apolarization, String abands) {
		super(acode, aname);
		fullname = afullname;
		polarization = apolarization;
		bands = abands;
	}
	
	public static String getPolarizationName(String apolarization) {
		String result = "";
		if ("V".equals(apolarization))
			result = "Вертикальная";
		else if ("C".equals(apolarization))
			result = "Кросс";
		return result;
	}

	/**
	 * @return
	 */
	public String getBands() {
		return bands;
	}

	/**
	 * @return
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @return
	 */
	public String getPolarization() {
		return polarization;
	}

	/**
	 * @param string
	 */
	public void setBands(String string) {
		bands = string;
	}

	/**
	 * @param string
	 */
	public void setFullname(String string) {
		fullname = string;
	}

	/**
	 * @param string
	 */
	public void setPolarization(String string) {
		polarization = string;
	}

}
