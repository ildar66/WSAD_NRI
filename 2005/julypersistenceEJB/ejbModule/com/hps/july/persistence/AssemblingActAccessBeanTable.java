/**
 * This class was generated by the VisualAge for Java Access Bean SmartGuide.
 * Warning:  Modifications will be lost when this part is regenerated.
 */

package com.hps.july.persistence;

import javax.ejb.*;

public class AssemblingActAccessBeanTable extends com.ibm.ivj.ejb.runtime.AbstractAccessBeanTable {

    static final long serialVersionUID = 3206093459760846163L;

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public AssemblingActAccessBeanTable () {
        super();
    }


   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public java.util.Enumeration getAssemblingActAccessBean() {
        return super.getTable();
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public AssemblingActAccessBean getAssemblingActAccessBean( int i ) {
        return (AssemblingActAccessBean) super.getRow(i);
    }

;
   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setAssemblingActAccessBean( java.util.Enumeration e ) {
        super.setTable(e);
    }

   /**
    * This method was generated by the VisualAge for Java Access Bean SmartGuide.
    * Warning: Modifications will be lost when this part is regenerated.
    */

    public void setAssemblingActAccessBean ( int i, AssemblingActAccessBean e ) {
        super.setRow(i, e);
    }

;
}