/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;

public class EquipmentSetAccessBeanTable extends com.ibm.ivj.ejb.runtime.AbstractAccessBeanTable {

    static final long serialVersionUID = 3206093459760846163L;

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public EquipmentSetAccessBeanTable () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getEquipmentSetAccessBean() {
        return super.getTable();
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public EquipmentSetAccessBean getEquipmentSetAccessBean( int i ) {
        return (EquipmentSetAccessBean) super.getRow(i);
    }

;
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setEquipmentSetAccessBean( java.util.Enumeration e ) {
        super.setTable(e);
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setEquipmentSetAccessBean ( int i, EquipmentSetAccessBean e ) {
        super.setRow(i, e);
    }

;
}
