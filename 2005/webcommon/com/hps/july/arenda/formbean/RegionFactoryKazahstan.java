/*
 * Created on 12.04.2007
 *
 * Factory for Kazahstan
 */
package com.hps.july.arenda.formbean;

/**
 * @author IShaffigulin
 *
 * Factory for Kazahstan
 */
public class RegionFactoryKazahstan extends RegionFactoryAbstract {

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.AbstractRegionFactory#getWeArandaFormView()
	 */
	public WeArandaFormView getWeArandaFormView() {
		return new WeArandaFormViewKazahstan();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.RegionFactoryAbstract#getVendorFormView()
	 */
	public VendorFormView getVendorFormView() {
		return new VendorFormViewKazahstan();
	}

}
