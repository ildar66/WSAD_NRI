package com.nri.exception;
public class MappingException extends NriException {

	/**
	 * Constructor for MappingException
	 */
	public MappingException() {
		super();
	}

	/**
	 * Constructor for MappingException
	 */
	public MappingException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructor MappingException.
	 * @param arg0
	 */
	public MappingException(Exception arg0,String desc) {
		super(arg0, desc);
	}


}

