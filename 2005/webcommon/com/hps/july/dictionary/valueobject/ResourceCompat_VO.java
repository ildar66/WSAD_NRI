/*
 * Created on 31.01.2007
 */
package com.hps.july.dictionary.valueobject;

/**
 * @author irogachev
 */
public class ResourceCompat_VO {
	
	private String resource1;
	private String resource2;
	// это псевдо только для чтения
	// private String id;

	public ResourceCompat_VO() {
		super();
	}

	/**
	 * @return
	 */
	public String getResource1() {
		return resource1;
	}

	/**
	 * @return
	 */
	public String getResource2() {
		return resource2;
	}

	/**
	 * @param string
	 */
	public void setResource1(String string) {
		resource1 = string;
	}

	/**
	 * @param string
	 */
	public void setResource2(String string) {
		resource2 = string;
	}

	/**
	 * @return
	 */
	public String getId() {
		return resource1+"#"+resource2;
	}

}
