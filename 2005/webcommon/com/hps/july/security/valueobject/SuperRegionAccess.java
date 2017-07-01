package com.hps.july.security.valueobject;

import com.hps.july.persistence.SuperRegionAccessBean;
import com.hps.july.persistence.SuperRegionAccAccessBean;
import com.hps.july.security.formbean.*;
import java.util.*;

/**
 * Объект для вычисления доступа к суперрегионам.
 * Creation date: (26.03.2003 15:17:39)
 * @author: Alexander Makanin
 */
public class SuperRegionAccess {

    protected boolean viewplan;
    protected boolean editplan;
    protected boolean viewfact;
    protected boolean editfact;
    protected int superregionid;
    protected int operator;
    /**
     * SuperRegionAccess constructor comment.
     */
    public SuperRegionAccess() {
        super();
    }
    /**
     * SuperRegionAccess constructor comment.
     */
    public SuperRegionAccess(SuperRegionAccAccessBean ab) {
        try {
            this.editfact = ab.getEditfact();
            this.editplan = ab.getEditplan();
            this.viewfact = ab.getViewfact();
            this.viewplan = ab.getViewplan();
            this.superregionid = (ab.getSuperregionKey()).supregid;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
* Insert the method's description here.
* Creation date: (26.03.2003 20:10:33)
* @return java.util.Collection
*/
public static ArrayList collectionFromForm(SuperRegionAccessListForm sprregfrm) {
    ArrayList accessCollection = new ArrayList();

    ArrayList tempeditfact = new ArrayList();
    ArrayList tempeditplan = new ArrayList();
    ArrayList tempviewfact = new ArrayList();
    ArrayList tempviewplan = new ArrayList();

    for (int i = 0; i < sprregfrm.getEditfact().length; i++) {
        int supregid = sprregfrm.getEditfact()[i];
        tempeditfact.add(new Integer(supregid));
    }
    for (int i = 0; i < sprregfrm.getEditplan().length; i++) {
        int supregid = sprregfrm.getEditplan()[i];
        tempeditplan.add(new Integer(supregid));
    }
    for (int i = 0; i < sprregfrm.getViewfact().length; i++) {
        int supregid = sprregfrm.getViewfact()[i];
        tempviewfact.add(new Integer(supregid));
    }
    for (int i = 0; i < sprregfrm.getViewplan().length; i++) {
        int supregid = sprregfrm.getViewplan()[i];
        tempviewplan.add(new Integer(supregid));
    }

    ArrayList tempunited = new ArrayList();
    tempunited.removeAll(tempeditfact);
    tempunited.addAll(tempeditfact);
    tempunited.removeAll(tempeditplan);
    tempunited.addAll(tempeditplan);
    tempunited.removeAll(tempviewfact);
    tempunited.addAll(tempviewfact);
    tempunited.removeAll(tempviewplan);
    tempunited.addAll(tempviewplan);

    Iterator itr = tempunited.iterator();
    while (itr.hasNext()) {
        Integer i = (Integer) itr.next();{
            SuperRegionAccess sra = new SuperRegionAccess();
            sra.setSuperregionid(i.intValue());
            sra.setEditfact(tempeditfact.contains(i));
            sra.setEditplan(tempeditplan.contains(i));
            sra.setViewfact(tempviewfact.contains(i));
            sra.setViewplan(tempviewplan.contains(i));

            accessCollection.add(sra);
        }
    }
    return accessCollection;
}
    /**
    * Insert the method's description here.
    * Creation date: (26.03.2003 20:10:33)
    * @return java.util.Collection
    */
    public static SuperRegionAccessListForm formFromCollection(
        ArrayList accessCollection,
        SuperRegionAccessListForm sprregfrm) {

		sprregfrm.setViewplan(new int[0]);
        sprregfrm.setEditplan(new int[0]);
        sprregfrm.setViewfact(new int[0]);
        sprregfrm.setEditfact(new int[0]);
	        
        ArrayList tempeditfact = new ArrayList();
        ArrayList tempviewfact = new ArrayList();
        ArrayList tempeditplan = new ArrayList();
        ArrayList tempviewplan = new ArrayList();

        Iterator itr = accessCollection.iterator();
        while (itr.hasNext()) {
            SuperRegionAccess sra = (SuperRegionAccess) itr.next();
            if (sra.isEditfact()) {
                tempeditfact.add(new Integer(sra.getSuperregionid()));
            }
            if (sra.isViewfact()) {
                tempviewfact.add(new Integer(sra.getSuperregionid()));
            }
            if (sra.isEditplan()) {
                tempeditplan.add(new Integer(sra.getSuperregionid()));
            }
            if (sra.isViewplan()) {
                tempviewplan.add(new Integer(sra.getSuperregionid()));
            }
        }
        //sorting ??
        if (tempeditfact.size() > 0) {
            Object editfact[] = (Object[]) tempeditfact.toArray();
            int inteditfact[] = new int[editfact.length];
            for (int i = 0; i < editfact.length; i++) {
                inteditfact[i] = ((Integer) editfact[i]).intValue();
            }
            sprregfrm.setEditfact(inteditfact);
        }

        if (tempviewfact.size() > 0) {
            Object viewfact[] = (Object[]) tempviewfact.toArray();
            int intviewfact[] = new int[viewfact.length];
            for (int i = 0; i < viewfact.length; i++) {
                intviewfact[i] = ((Integer) viewfact[i]).intValue();
            }
            sprregfrm.setViewfact(intviewfact);
        }

        if (tempeditplan.size() > 0) {
            Object editplan[] = (Object[]) tempeditplan.toArray();
            int inteditplan[] = new int[editplan.length];
            for (int i = 0; i < editplan.length; i++) {
                inteditplan[i] = ((Integer) editplan[i]).intValue();
            }
            sprregfrm.setEditplan(inteditplan);
        }

        if (tempviewplan.size() > 0) {
            Object viewplan[] = (Object[]) tempviewplan.toArray();
            int intviewplan[] = new int[viewplan.length];
            for (int i = 0; i < viewplan.length; i++) {
                intviewplan[i] = ((Integer) viewplan[i]).intValue();
            }
            sprregfrm.setViewplan(intviewplan);
        }

        return sprregfrm;
    }
    /**
     * Insert the method's description here.
     * Creation date: (27.03.2003 10:13:21)
     * @return int
     */
    public int getOperator() {
        return operator;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 20:46:49)
     * @return int
     */
    public int getSuperregionid() {
        return superregionid;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 15:28:12)
     * @return boolean
     */
    public boolean isEditfact() {
        return editfact;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 15:27:18)
     * @return boolean
     */
    public boolean isEditplan() {
        return editplan;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 15:27:42)
     * @return boolean
     */
    public boolean isViewfact() {
        return viewfact;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 15:26:51)
     * @return boolean
     */
    public boolean isViewplan() {
        return viewplan;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 15:28:12)
     * @param newEditfact boolean
     */
    public void setEditfact(boolean newEditfact) {
        editfact = newEditfact;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 15:27:18)
     * @param newEditplan boolean
     */
    public void setEditplan(boolean newEditplan) {
        editplan = newEditplan;
    }
    /**
     * Insert the method's description here.
     * Creation date: (27.03.2003 10:13:21)
     * @param newOperator int
     */
    public void setOperator(int newOperator) {
        operator = newOperator;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 20:46:49)
     * @param newSuperregionid int
     */
    public void setSuperregionid(int newSuperregionid) {
        superregionid = newSuperregionid;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 15:27:42)
     * @param newViewfact boolean
     */
    public void setViewfact(boolean newViewfact) {
        viewfact = newViewfact;
    }
    /**
     * Insert the method's description here.
     * Creation date: (26.03.2003 15:26:51)
     * @param newViewplan boolean
     */
    public void setViewplan(boolean newViewplan) {
        viewplan = newViewplan;
    }
}
