package com.hps.july.security.service;

/**
 * @author dkrivenko
 */
public interface JulySecurityService {

	/**
	 * @param operatorLogin
	 */
	void switchOperator(String operatorLogin) throws JulySecurityException;

}
