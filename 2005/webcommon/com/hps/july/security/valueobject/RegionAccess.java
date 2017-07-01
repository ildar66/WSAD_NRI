package com.hps.july.security.valueobject;

import com.hps.july.persistence.RegionAccessBean;
import com.hps.july.persistence.RegionAccAccessBean;
import com.hps.july.security.formbean.*;
import java.util.*;

/**
 * Объект для вычисления доступа к регионам.
 * Creation date: (28.03.2003 9:17:56)
 * @author: Alexander Makanin
 */
public class RegionAccess extends SuperRegionAccess {
    private int regionid;
    /**
     * RegionAccess constructor comment.
     */
    public RegionAccess() {
        super();
    }
    /**
    * SuperRegionAccess constructor comment.
    */
    public RegionAccess(RegionAccAccessBean ab) {
        try {
            this.editfact = ab.getEditfact();
            this.editplan = ab.getEditplan();
            this.viewfact = ab.getViewfact();
            this.viewplan = ab.getViewplan();
            this.regionid = (ab.getRegionKey()).regionid;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
* Insert the method's description here.
* Creation date: (26.03.2003 20:10:33)
* @return java.util.Collection
*/
public static ArrayList collectionFromForm(RegionAccessListForm regfrm) {
    ArrayList accessCollection = new ArrayList();

    ArrayList tempeditfact = new ArrayList();
    ArrayList tempeditplan = new ArrayList();
    ArrayList tempviewfact = new ArrayList();
    ArrayList tempviewplan = new ArrayList();

    for (int i = 0; i < regfrm.getEditfact().length; i++) {
        int regid = regfrm.getEditfact()[i];
        tempeditfact.add(new Integer(regid));
    }
    for (int i = 0; i < regfrm.getEditplan().length; i++) {
        int regid = regfrm.getEditplan()[i];
        tempeditplan.add(new Integer(regid));
    }
    for (int i = 0; i < regfrm.getViewfact().length; i++) {
        int regid = regfrm.getViewfact()[i];
        tempviewfact.add(new Integer(regid));
    }
    for (int i = 0; i < regfrm.getViewplan().length; i++) {
        int regid = regfrm.getViewplan()[i];
        tempviewplan.add(new Integer(regid));
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
        Integer i = (Integer) itr.next();
        {
            RegionAccess ra = new RegionAccess();
            ra.setRegionid(i.intValue());
            ra.setEditfact(tempeditfact.contains(i));
            ra.setEditplan(tempeditplan.contains(i));
            ra.setViewfact(tempviewfact.contains(i));
            ra.setViewplan(tempviewplan.contains(i));

            accessCollection.add(ra);
        }
    }
    return accessCollection;
}
    /**
    * Insert the method's description here.
    * Creation date: (26.03.2003 20:10:33)
    * @return java.util.Collection
    */
    public static RegionAccessListForm formFromCollection(
        ArrayList accessCollection,
        RegionAccessListForm regfrm) {

		regfrm.setViewplan(new int[0]);
        regfrm.setEditplan(new int[0]);
        regfrm.setViewfact(new int[0]);
        regfrm.setEditfact(new int[0]);
	        
        ArrayList tempeditfact = new ArrayList();
        ArrayList tempviewfact = new ArrayList();
        ArrayList tempeditplan = new ArrayList();
        ArrayList tempviewplan = new ArrayList();

        Iterator itr = accessCollection.iterator();
        while (itr.hasNext()) {
            RegionAccess sra = (RegionAccess) itr.next();
            if (sra.isEditfact()) {
                tempeditfact.add(new Integer(sra.getRegionid()));
            }
            if (sra.isViewfact()) {
                tempviewfact.add(new Integer(sra.getRegionid()));
            }
            if (sra.isEditplan()) {
                tempeditplan.add(new Integer(sra.getRegionid()));
            }
            if (sra.isViewplan()) {
                tempviewplan.add(new Integer(sra.getRegionid()));
            }
        }
        //sorting ??
        if (tempeditfact.size() > 0) {
            Object editfact[] = (Object[]) tempeditfact.toArray();
            int inteditfact[] = new int[editfact.length];
            for (int i = 0; i < editfact.length; i++) {
                inteditfact[i] = ((Integer) editfact[i]).intValue();
            }
            regfrm.setEditfact(inteditfact);
        }

        if (tempviewfact.size() > 0) {
            Object viewfact[] = (Object[]) tempviewfact.toArray();
            int intviewfact[] = new int[viewfact.length];
            for (int i = 0; i < viewfact.length; i++) {
                intviewfact[i] = ((Integer) viewfact[i]).intValue();
            }
            regfrm.setViewfact(intviewfact);
        }

        if (tempeditplan.size() > 0) {
            Object editplan[] = (Object[]) tempeditplan.toArray();
            int inteditplan[] = new int[editplan.length];
            for (int i = 0; i < editplan.length; i++) {
                inteditplan[i] = ((Integer) editplan[i]).intValue();
            }
            regfrm.setEditplan(inteditplan);
        }

        if (tempviewplan.size() > 0) {
            Object viewplan[] = (Object[]) tempviewplan.toArray();
            int intviewplan[] = new int[viewplan.length];
            for (int i = 0; i < viewplan.length; i++) {
                intviewplan[i] = ((Integer) viewplan[i]).intValue();
            }
            regfrm.setViewplan(intviewplan);
        }

        return regfrm;
    }
    /**
     * Insert the method's description here.
     * Creation date: (28.03.2003 9:22:55)
     * @return int
     */
    public int getRegionid() {
        return regionid;
    }
    /**
     * Insert the method's description here.
     * Creation date: (28.03.2003 9:22:55)
     * @param newRegionid int
     */
    public void setRegionid(int newRegionid) {
        regionid = newRegionid;
    }
}
