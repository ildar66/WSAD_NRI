package com.hps.july.security.formbean;

import com.hps.july.web.util.BrowseForm;
import com.hps.july.persistence.OperatorKey;

/**
 * Форма редактирования прав доступа к суперрегионам.
 * Creation date: (25.03.2003 9:56:19)
 * @author: Alexander Makanin
 */  
public class SuperRegionAccessListForm extends BrowseForm {

    protected Integer operator;
    protected int[] viewplan;
    protected int[] editplan;
    protected int[] viewfact;
    protected int[] editfact;
    /**
     * SuperRegionAccessListForm constructor comment.
     */
    public SuperRegionAccessListForm() {
        super();
        this.setFinderMethodName("findAllOrderByCodeAsc");
        viewplan = new int[0];
        editplan = new int[0];
        viewfact = new int[0];
        editfact = new int[0];
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 17:32:45)
     * @return int[]
     */
    public int[] getEditfact() {
        return editfact;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 17:31:15)
     * @return int[]
     */
    public int[] getEditplan() {
        return editplan;
    }
    /**
     * Creation date: (24.03.2003 19:44:28)
     * @return java.lang.Object[] - filter params.
     */
    public Object[] getFilterParams() {
        return new Object[] {
        };
    }
    /**
     * Insert the method's description here.
     * Creation date: (25.03.2003 18:51:54)
     * @return int
     */
    public Integer getOperator() {
        return operator;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 17:32:11)
     * @return int[]
     */
    public int[] getViewfact() {
        return viewfact;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 16:26:00)
     * @return int[]
     */
    public int[] getViewplan() {
        return viewplan;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 17:32:45)
     * @param newEditfact int[]
     */
    public void setEditfact(int[] newEditfact) {
        editfact = newEditfact;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 17:31:15)
     * @param newEditplan int[]
     */
    public void setEditplan(int[] newEditplan) {
        editplan = newEditplan;
    }
    /**
     * Insert the method's description here.
     * Creation date: (25.03.2003 18:51:54)
     * @param newOperatorID int
     */
    public void setOperator(Integer newOperator) {
        operator = newOperator;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 17:32:11)
     * @param newViewfact int[]
     */
    public void setViewfact(int[] newViewfact) {
        viewfact = newViewfact;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 16:26:00)
     * @param newViewplan int[]
     */
    public void setViewplan(int[] newViewplan) {
        viewplan = newViewplan;
    }
}
