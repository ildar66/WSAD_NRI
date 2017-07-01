package com.nri.exception;
public class DuplicateKeyException extends MappingException {

	/**
	 * Constructor for DuplicateKeyException
	 */
	public DuplicateKeyException() {
		super();
	}

	/**
	 * Constructor for DuplicateKeyException
	 */
	public DuplicateKeyException(String arg0) {
		super(arg0);
	}
	
	public DuplicateKeyException(Exception arg0, String desc) {
		super(arg0, desc);
	}

}

