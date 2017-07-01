package com.hps.july.security.formbean;

import com.hps.july.persistence.*;

import com.hps.july.web.util.StringAndIntegerProperty;

/**
 * Форма списка прав доступа к региону.
 * Creation date: (27.03.2003 19:21:02)
 * @author: Alexander Makanin
 */
public class RegionAccessListForm extends SuperRegionAccessListForm {
    private int superregionid;
    private boolean allsuperregions;

    /**
     * RegionAccessListForm constructor comment.
     */
    public RegionAccessListForm() {
        super();
        //this.setFinderMethodName("findRegionBySuperregion");
        this.setFinderMethodName("findByQBE");
        viewplan = new int[0];
        editplan = new int[0];
        viewfact = new int[0];
        editfact = new int[0];
        this.superregionid = 1;//central
    }
    /**
     * Creation date: (24.03.2003 19:44:28)
     * @return java.lang.Object[] - filter params.
     */
    public Object[] getFilterParams() {
        return new Object[] {new Boolean(!allsuperregions) , new Integer(superregionid),
		new Boolean(false), new String("") , new Integer(1)};
    }
    /**
     * Insert the method's description here.
     * Creation date: (28.03.2003 8:51:54)
     * @return int
     */
    public int getSuperregionid() {
        return superregionid;
    }
/**
* Insert the method's description here.
* Creation date: (18.06.2002 16:12:47)
* @return java.util.Enumeration
*/
public java.util.Enumeration getSuperregions() {
    try {
        SuperRegionAccessBean bean = new SuperRegionAccessBean();
        return bean.findAllOrderByCodeAsc();
    } catch (Exception e) {
        return (new java.util.Vector()).elements();
    }
}
    /**
     * Insert the method's description here.
     * Creation date: (28.03.2003 11:36:11)
     * @return boolean
     */
    public boolean isAllsuperregions() {
        return allsuperregions;
    }
    /**
     * Insert the method's description here.
     * Creation date: (28.03.2003 11:36:11)
     * @param newAllsuperregions boolean
     */
    public void setAllsuperregions(boolean newAllsuperregions) {
        allsuperregions = newAllsuperregions;
    }
    /**
     * Insert the method's description here.
     * Creation date: (28.03.2003 8:51:54)
     * @param newSuperregionid int
     */
    public void setSuperregionid(int newSuperregionid) {
        superregionid = newSuperregionid;
    }
}
