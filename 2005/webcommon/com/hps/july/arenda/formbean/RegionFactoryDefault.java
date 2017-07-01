/*
 * Created on 12.04.2007
 *
 * DefaultRegionFactory for Region
 */
package com.hps.july.arenda.formbean;

/**
 * @author IShaffigulin
 *
 * DefaultRegionFactory for Region
 */
public class RegionFactoryDefault extends RegionFactoryAbstract {

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.AbstractRegionFactory#getWeArandaFormView()
	 */
	public WeArandaFormView getWeArandaFormView() {
		return new WeArandaFormViewDefault();
	}

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.RegionFactoryAbstract#getVendorFormView()
	 */
	public VendorFormView getVendorFormView() {
		return new VendorFormViewDefault();
	}

}
