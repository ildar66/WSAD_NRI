/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;

public class LeaseContractAccessBeanTable extends com.ibm.ivj.ejb.runtime.AbstractAccessBeanTable {

	static final long serialVersionUID = 3206093459760846163L;

   /**
	* This method was generated by the VisualAge for Java Access Bean SmartGuide.
	* Warning: Modifications will be lost when this part is regenerated.
	*/

	public LeaseContractAccessBeanTable () {
		super();
	}


   /**
	* This method was generated by the VisualAge for Java Access Bean SmartGuide.
	* Warning: Modifications will be lost when this part is regenerated.
	*/

	public java.util.Enumeration getLeaseContractAccessBean() {
		return super.getTable();
	}

   /**
	* This method was generated by the VisualAge for Java Access Bean SmartGuide.
	* Warning: Modifications will be lost when this part is regenerated.
	*/

	public LeaseContractAccessBean getLeaseContractAccessBean( int i ) {
		return (LeaseContractAccessBean) super.getRow(i);
	}

;
   /**
	* This method was generated by the VisualAge for Java Access Bean SmartGuide.
	* Warning: Modifications will be lost when this part is regenerated.
	*/

	public void setLeaseContractAccessBean( java.util.Enumeration e ) {
		super.setTable(e);
	}

   /**
	* This method was generated by the VisualAge for Java Access Bean SmartGuide.
	* Warning: Modifications will be lost when this part is regenerated.
	*/

	public void setLeaseContractAccessBean ( int i, LeaseContractAccessBean e ) {
		super.setRow(i, e);
	}

;
}