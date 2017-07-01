/*
 * Created on 12.04.2007
 *
 */
package com.hps.july.arenda.formbean;

/**
 * @author IShaffigulin
 *
 */
public class WeArandaFormViewKazahstan implements WeArandaFormView {

	/**
	 * 
	 */
	public WeArandaFormViewKazahstan() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.WeArandaFormView#isBuchdoc()
	 */
	public boolean isBuchdoc() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.WeArandaFormView#isHaveDocSigned()
	 */
	public boolean isHaveDocSigned() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.WeArandaFormView#getNameAccounting()
	 */
	public String getNameAccounting() {
		return "Scala";
	}

}
