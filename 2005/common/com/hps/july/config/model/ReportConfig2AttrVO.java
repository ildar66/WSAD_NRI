package com.hps.july.config.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReportConfig2AttrVO implements Serializable {
	
	private String attribute;
	private String value;
	

	public ReportConfig2AttrVO() {
		super();
	}

	/**
	 * @return
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param string
	 */
	public void setAttribute(String string) {
		attribute = string;
	}

	/**
	 * @param string
	 */
	public void setValue(String string) {
		value = string;
	}

}
