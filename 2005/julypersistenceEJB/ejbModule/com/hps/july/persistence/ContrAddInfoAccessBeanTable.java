/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;

public class ContrAddInfoAccessBeanTable extends com.ibm.ivj.ejb.runtime.AbstractAccessBeanTable {

    static final long serialVersionUID = 3206093459760846163L;

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public ContrAddInfoAccessBeanTable () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getContrAddInfoAccessBean() {
        return super.getTable();
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public ContrAddInfoAccessBean getContrAddInfoAccessBean( int i ) {
        return (ContrAddInfoAccessBean) super.getRow(i);
    }

;
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setContrAddInfoAccessBean( java.util.Enumeration e ) {
        super.setTable(e);
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setContrAddInfoAccessBean ( int i, ContrAddInfoAccessBean e ) {
        super.setRow(i, e);
    }

;
}
