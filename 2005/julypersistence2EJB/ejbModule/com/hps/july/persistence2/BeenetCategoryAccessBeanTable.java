/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence2;

import javax.ejb.*;

public class BeenetCategoryAccessBeanTable extends com.ibm.ivj.ejb.runtime.AbstractAccessBeanTable {

    static final long serialVersionUID = 3206093459760846163L;

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public BeenetCategoryAccessBeanTable () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getBeenetCategoryAccessBean() {
        return super.getTable();
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public BeenetCategoryAccessBean getBeenetCategoryAccessBean( int i ) {
        return (BeenetCategoryAccessBean) super.getRow(i);
    }

;
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setBeenetCategoryAccessBean( java.util.Enumeration e ) {
        super.setTable(e);
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setBeenetCategoryAccessBean ( int i, BeenetCategoryAccessBean e ) {
        super.setRow(i, e);
    }

;
}