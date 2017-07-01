/*
 * Created on 18.07.2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nri.exception;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NoSuchCompanyException extends NoSuchObjectException {

	/**
	 * 
	 */
	public NoSuchCompanyException() {
		super();
	}

	/**
	 * @param arg0
	 */
	public NoSuchCompanyException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param desc
	 */
	public NoSuchCompanyException(Exception arg0, String desc) {
		super(arg0, desc);
	}

}
