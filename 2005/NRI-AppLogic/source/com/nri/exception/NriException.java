package com.nri.exception;

import java.io.Serializable;

public class NriException extends WrappedException implements Serializable {

	/**
	 * Constructor for NriException
	 */
	public NriException() {
		super();
	}

	/**
	 * Constructor for NriException
	 */
	public NriException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructor NriException.
	 * @param arg0
	 */
	public NriException(Exception arg0, String desc) {
		super(arg0, desc);
	}


}

