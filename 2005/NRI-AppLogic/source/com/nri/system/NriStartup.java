package com.nri.system;

/**
 * NRI Startup Class.
 */
public class NriStartup implements StartupCapable {
/**
 * NriStartup constructor comment.
 */
public NriStartup() {
	super();
}

public void end() {

	
}
/**
 * perform startup sequence.
 */
public void start() {

	// Initiliaze StrataSystem class 
	AppService.startup = this;
	
	// Initialize Properties Object
	AppService.property = new NriProperties();

	
}
}
