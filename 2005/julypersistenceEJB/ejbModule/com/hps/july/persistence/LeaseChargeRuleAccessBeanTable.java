/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;

public class LeaseChargeRuleAccessBeanTable extends com.ibm.ivj.ejb.runtime.AbstractAccessBeanTable {

    static final long serialVersionUID = 3206093459760846163L;

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public LeaseChargeRuleAccessBeanTable () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getLeaseChargeRuleAccessBean() {
        return super.getTable();
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public LeaseChargeRuleAccessBean getLeaseChargeRuleAccessBean( int i ) {
        return (LeaseChargeRuleAccessBean) super.getRow(i);
    }

;
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setLeaseChargeRuleAccessBean( java.util.Enumeration e ) {
        super.setTable(e);
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setLeaseChargeRuleAccessBean ( int i, LeaseChargeRuleAccessBean e ) {
        super.setRow(i, e);
    }

;
}
