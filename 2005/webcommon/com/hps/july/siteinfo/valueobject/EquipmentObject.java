package com.hps.july.siteinfo.valueobject;

import javax.ejb.EJBObject;
import java.util.*;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.jdbcpersistence.lib.*;
import com.hps.july.basestation.valueobject.BaseStationObject;

/**
 * Служебный класс для работы со списками оборудования и
 * параметрами каждого оборудования.
 */
public class EquipmentObject
	implements  Comparable, java.io.Serializable
{
	private AbstractEntityAccessBean equipmentSet;
	private java.lang.String equipmentType;
	private int equipmentTypeName;
	private boolean haveContents;
	public final static String TYPE_BS = "A";
	public final static String TYPE_ComEquipment = "B";
	public final static String TYPE_Controller = "C";
	public final static String TYPE_Switch = "D";
	public final static String TYPE_Other = "E";
	public final static String TYPE_Repeater = "R";
	public final static String TYPE_WLAN = "F";
	public final static String TYPE_Unknown = "N";

	public final static String Switch_Damps = "1";
	public final static String Switch_Gsm = "2";

	public final static String ComEquipment_Optic = "O";
	public final static String ComEquipment_Radio = "R";
	public final static String ComEquipment_Other = "A";

	public final static String Other_B = "B";
	public final static String Other_C = "C";
	public final static String Other_D = "D";
	public final static String Other_E = "E";

    public final static int ORDER_TYPE_ASC = 1;
    public final static int ORDER_TYPE_DESC = 2;
    public final static int ORDER_NUMBER_ASC = 3;
    public final static int ORDER_NUMBER_DESC = 4;
    public final static int ORDER_NAME_ASC = 5;
    public final static int ORDER_NAME_DESC = 6;

    private int order;
    private int orderIndex = 0;
/**
 * OperatorTask constructor comment.
 */
public EquipmentObject() {
	super();
}
/**
 * OperatorTask constructor comment.
 */
public EquipmentObject(EquipmentSetAccessBean argEquipmentSet) {
    super();
    setHaveContents(false);
    EquipmentSetAccessBean ebean = new EquipmentSetAccessBean();
    try {
        ebean.setInitKey_storageplace(argEquipmentSet.getStorageplace());
        ebean.refreshCopyHelper();
        equipmentSet = ebean;
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
    setEquipmentType(TYPE_Unknown);
    try {
        if (ebean.getEJBRef() instanceof BaseStation) {
            equipmentSet = new BaseStationAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_BS);
        }
        else if (ebean.getEJBRef() instanceof ComEquipment) {
            equipmentSet = new ComEquipmentAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_ComEquipment);
        }
        else if (ebean.getEJBRef() instanceof Controller) {
            equipmentSet = new ControllerAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_Controller);
        }
        else if (ebean.getEJBRef() instanceof Switch) {
            equipmentSet = new SwitchAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_Switch);
        }
        else if (ebean.getEJBRef() instanceof OtherEquipment) {
            equipmentSet = new OtherEquipmentAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_Other);
        }
        else if (ebean.getEJBRef() instanceof Repiter) {
            equipmentSet = new RepiterAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_Repeater);
        }
        else if (ebean.getEJBRef() instanceof WLAN) {
            equipmentSet = new WLANAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_WLAN);
        }

        // Check if we have contents
        java.util.Enumeration en =
            new StorageCardAccessBean().findByStorageNotAgregatedOrderByResourceAsc(
                new Integer(argEquipmentSet.getStorageplace()));
        if (en.hasMoreElements())
            setHaveContents(true);

    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
}
/**
 * OperatorTask constructor comment.
 */
public EquipmentObject(EquipmentSetAccessBean argEquipmentSet, int order) {
    super();
    this.order = order;
    DebugSupport.printlnTest(
        "EquipmentObject(EquipmentSetAccessBean argEquipmentSet, int order) order="
            + order);
    setHaveContents(false);
    EquipmentSetAccessBean ebean = new EquipmentSetAccessBean();
    try {
        ebean.setInitKey_storageplace(argEquipmentSet.getStorageplace());
        ebean.refreshCopyHelper();
        equipmentSet = ebean;
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
    setEquipmentType(TYPE_Unknown);
    try {
        if (ebean.getEJBRef() instanceof BaseStation) {
            equipmentSet = new BaseStationAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_BS);
        } else if (ebean.getEJBRef() instanceof ComEquipment) {
            equipmentSet = new ComEquipmentAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_ComEquipment);
        } else if (ebean.getEJBRef() instanceof Controller) {
            equipmentSet = new ControllerAccessBean(argEquipmentSet.getEJBRef());
            setEquipmentType(TYPE_Controller);
		} else if (ebean.getEJBRef() instanceof Switch) {
			equipmentSet = new SwitchAccessBean(argEquipmentSet.getEJBRef());
			setEquipmentType(TYPE_Switch);
		} else if (ebean.getEJBRef() instanceof OtherEquipment) {
			equipmentSet = new OtherEquipmentAccessBean(argEquipmentSet.getEJBRef());
			setEquipmentType(TYPE_Other);
		} else if (ebean.getEJBRef() instanceof Repiter) {
			equipmentSet = new RepiterAccessBean(argEquipmentSet.getEJBRef());
			setEquipmentType(TYPE_Repeater);
		} else if (ebean.getEJBRef() instanceof WLAN) {
			equipmentSet = new WLANAccessBean(argEquipmentSet.getEJBRef());
			setEquipmentType(TYPE_WLAN);
        }


        if (order == ORDER_TYPE_ASC || order == ORDER_TYPE_DESC) {
            calculateOrderIndex();
        }

        // Check if we have contents
        java.util.Enumeration en =
            new StorageCardAccessBean().findByStorageNotAgregatedOrderByResourceAsc(
                new Integer(argEquipmentSet.getStorageplace()));
        if (en.hasMoreElements())
            setHaveContents(true);

    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2003 17:22:04)
 * @param bean com.hps.july.persistence.EquipmentSetAccessBean
 */
public void calculateOrderIndex() throws Exception {

    try {
        DebugSupport.printlnTest("calculateOrderIndex started order=" + order);
        orderIndex = 0;
        EJBObject bean = getEquipmentSet().getEJBRef();
        String type="";
        if (bean instanceof Switch) {
type="switch";
            orderIndex = orderIndex+1 * 100;

            SwitchAccessBean sw = new SwitchAccessBean(bean);
            sw.refreshCopyHelper();
            if (sw.getSwitchType().equals(Switch_Damps)) {
                orderIndex = orderIndex+1 * 10;
            } else if (sw.getSwitchType().equals(Switch_Gsm)) {
                orderIndex = orderIndex+2 * 10;
            }
            //orderIndex = +sw.getNumber();

        } else if (bean instanceof Controller) {
	        type="controller";
            ControllerAccessBean ct = new ControllerAccessBean(bean);
            ct.refreshCopyHelper();
            orderIndex = orderIndex+2 * 100;
            //orderIndex = +ct.getNumber();

        } else if (bean instanceof BaseStation) {
	        type="basestation";
            BaseStationAccessBean bs = new BaseStationAccessBean(bean);
            bs.refreshCopyHelper();
            orderIndex = orderIndex+3 * 100;
            orderIndex =orderIndex
                + (bs.getStationType().equals(BaseStationObject.TYPE_CHECK_DAMPS_D) ? 1 : 2)
                    * 10;
            //orderIndex = +bs.getNumber();

        } else if (bean instanceof ComEquipment) {
	        type="comEquipment";
            ComEquipmentAccessBean ce = new ComEquipmentAccessBean(bean);
            ce.refreshCopyHelper();
            orderIndex = orderIndex+4 * 100;
            if (ce.getComEquipmentType().equals(ComEquipment_Optic)) {
                orderIndex = orderIndex+1 * 10;
            } else if (ce.getComEquipmentType().equals(ComEquipment_Radio)) {
                orderIndex = orderIndex+2 * 10;
            }else if (ce.getComEquipmentType().equals(ComEquipment_Other)) {
                orderIndex = orderIndex+3 * 10;
            }

        } else if (bean instanceof OtherEquipment) {
	        type="otherEquipment";
            orderIndex = orderIndex+5 * 100;
            OtherEquipmentAccessBean oe = new OtherEquipmentAccessBean(bean);
            oe.refreshCopyHelper();
            if (oe.getOtherEquipmentType().equals(Other_B)) {
                orderIndex = orderIndex+1 * 10;
            } else if (oe.getOtherEquipmentType().equals(Other_C)) {
                orderIndex = orderIndex+3 * 10;
            } else if (oe.getOtherEquipmentType().equals(Other_D)) {
                orderIndex = orderIndex+4 * 10;
            } else if (oe.getOtherEquipmentType().equals(Other_E)) {
                orderIndex = orderIndex+2 * 10;
            }
        } else if (bean instanceof WLAN) {
	        type="WLAN";
            orderIndex = orderIndex+6 * 100;
        }

        DebugSupport.printlnTest("calculateOrderIndex type="+type+" orderIndex=" + orderIndex);

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 11:49:34)
 * @return int
 * @param o java.lang.Object
 */
public int compareTo(Object o2) {
    try {
        EquipmentObject eq1 = this;
        EquipmentObject eq2 = (EquipmentObject) o2;
        int res = 0;

        switch (order) {
            case EquipmentObject.ORDER_TYPE_ASC :
                {
                    res = eq1.getOrderIndex() - eq2.getOrderIndex();
                    if (res != 0) {
                        return res;
                    } else {
                        return eq1.getNumber() - eq2.getNumber();
                    }
                }
            case EquipmentObject.ORDER_TYPE_DESC :
                {
                    res = eq2.getOrderIndex() - eq1.getOrderIndex();
                    if (res != 0) {
                        return res;
                    } else {
                        return eq2.getNumber() - eq1.getNumber();
                    }
                }
            case EquipmentObject.ORDER_NAME_ASC :
                {
                    return eq1.getName().compareTo(eq2.getName());
                }
            case EquipmentObject.ORDER_NAME_DESC :
                {
                    return eq2.getName().compareTo(eq1.getName());
                }
            case EquipmentObject.ORDER_NUMBER_ASC :
                {
                    return eq1.getNumber() - eq2.getNumber();
                }
            case EquipmentObject.ORDER_NUMBER_DESC :
                {
                    return eq2.getNumber() - eq1.getNumber();
                }
        }
        throw new Exception("unknown order");
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        return -1;
    }

    /*
    if( ! (o instanceof EquipmentObject) )
    	return -1;
    try {
    	if ((equipmentSet != null) && (((EquipmentObject)o).getEquipmentSet() != null))
    	  return new Integer( ((EquipmentSetAccessBean)equipmentSet).getStorageplace() ).compareTo( 
    		  new Integer( ((EquipmentSetAccessBean)((EquipmentObject)o).getEquipmentSet()).getStorageplace()) );
    	else if ((equipmentSet != null) && (((EquipmentObject)o).getEquipmentSet() != null))
    		return 0;
    	else
    	  return -1;
    } catch (Exception e) {
    	return -1;
    }
     */
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 11:19:23)
 * @return boolean
 * @param obj java.lang.Object
 */
public boolean equals(Object o) {
	if( ! (o instanceof EquipmentObject) )
		return false;
	try {
		if ((equipmentSet != null) && (((EquipmentObject)o).getEquipmentSet() != null))
		  return new Integer( ((EquipmentSetAccessBean)equipmentSet).getStorageplace() ).equals( 
			  new Integer( ((EquipmentSetAccessBean)((EquipmentObject)o).getEquipmentSet()).getStorageplace()) );
		else if ((equipmentSet != null) && (((EquipmentObject)o).getEquipmentSet() != null))
			return true;
		else
		  return false;
	} catch (Exception e) {
		return false;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2003 17:13:49)
 * @return java.util.Vector
 */
public Vector findEquipmentSetByPosition(Integer position, Integer order)
    throws Exception {
    try {
        Vector res = new Vector();
        EquipmentSetAccessBeanTable table = new EquipmentSetAccessBeanTable();
        table.setEquipmentSetAccessBean(
            new EquipmentSetAccessBean().findEquipmentSetByPosition(
                new StoragePlaceKey(position.intValue())));
        for (int i = 0; i < table.numberOfRows(); i++) {
            res.add(
                new EquipmentObject(table.getEquipmentSetAccessBean(i), order.intValue()));
        }
        //Collections.sort(res, new EquipmentComparator(order.intValue()));
        Collections.sort(res);
        return res;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 16:08:49)
 * @return com.hps.july.persistence.EquipmentSetAccessBean
 */
public AbstractEntityAccessBean getEquipmentSet() {
	return equipmentSet;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 16:24:37)
 * @return java.lang.String
 */
public java.lang.String getEquipmentType() {
	return equipmentType;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 16:24:57)
 * @return int
 */
public int getEquipmentTypeName() {
	return equipmentTypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2003 17:22:04)
 * @param bean com.hps.july.persistence.EquipmentSetAccessBean
 */
public String getName() throws Exception {

    try {
        EJBObject bean = getEquipmentSet().getEJBRef();
        if (bean instanceof Switch) {
            SwitchAccessBean sw = new SwitchAccessBean(bean);
            sw.refreshCopyHelper();
            return sw.getName();
		} else if (bean instanceof Controller) {
            ControllerAccessBean ct = new ControllerAccessBean(bean);
            ct.refreshCopyHelper();
            return ct.getName();
        } else if (bean instanceof BaseStation) {
            BaseStationAccessBean bs = new BaseStationAccessBean(bean);
            bs.refreshCopyHelper();
            return bs.getName();
        } else if (bean instanceof ComEquipment) {
            ComEquipmentAccessBean ce = new ComEquipmentAccessBean(bean);
            ce.refreshCopyHelper();
            return ce.getName();
        } else if (bean instanceof OtherEquipment) {
            OtherEquipmentAccessBean oe = new OtherEquipmentAccessBean(bean);
            oe.refreshCopyHelper();
            return oe.getName();
        } else if (bean instanceof WLAN) {
            WLANAccessBean we = new WLANAccessBean(bean);
            we.refreshCopyHelper();
            return we.getName();
        } else {
            throw new Exception("unknown type");
        }
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2003 17:22:04)
 * @param bean com.hps.july.persistence.EquipmentSetAccessBean
 */
public int getNumber() throws Exception {

    try {
        EJBObject bean = getEquipmentSet().getEJBRef();
        if (bean instanceof Switch) {
            SwitchAccessBean sw = new SwitchAccessBean(bean);
            sw.refreshCopyHelper();
            return sw.getNumber();
        } else if (bean instanceof Controller) {
            ControllerAccessBean ct = new ControllerAccessBean(bean);
            ct.refreshCopyHelper();
            return ct.getNumber();
        } else if (bean instanceof BaseStation) {
            BaseStationAccessBean bs = new BaseStationAccessBean(bean);
            bs.refreshCopyHelper();
            return bs.getNumber();
        } else if (bean instanceof ComEquipment) {
//            ComEquipmentAccessBean ce = new ComEquipmentAccessBean(bean);
//            ce.refreshCopyHelper();
            return 0;
        } else if (bean instanceof OtherEquipment) {
//            OtherEquipmentAccessBean oe = new OtherEquipmentAccessBean(bean);
//            oe.refreshCopyHelper();
            return 0;
        } else if (bean instanceof Repiter){
//	        RepiterAccessBean rep = new RepiterAccessBean(bean);
//	        rep.refreshCopyHelper();
	        return 0;
        } else if (bean instanceof Repiter){
	        WLANAccessBean we = new WLANAccessBean(bean);
	        we.refreshCopyHelper();
	        return we.getNumber();
        } else {
            throw new Exception("unknown type. Type is:"+bean.getClass().getName());
        }

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2003 20:29:49)
 * @return int
 */
public int getOrderIndex() {
	return orderIndex;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2002 11:22:11)
 * @return int
 */
public int hashCode() {
	try {
		if (equipmentSet != null)
		  return ((EquipmentSetAccessBean)equipmentSet).getStorageplace();
		else
		  return 0;
	} catch (Exception e) {
		return 0;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.01.2003 10:50:24)
 * @return boolean
 */
public boolean isHaveContents() {
	return haveContents;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 16:08:49)
 * @param newEquipmentSet com.hps.july.persistence.EquipmentSetAccessBean
 */
public void setEquipmentSet(AbstractEntityAccessBean newEquipmentSet) {
	equipmentSet = newEquipmentSet;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 16:24:37)
 * @param newEquipmentType java.lang.String
 */
public void setEquipmentType(java.lang.String newEquipmentType) {
	equipmentType = newEquipmentType;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 16:24:57)
 * @param newEquipmentTypeName int
 */
public void setEquipmentTypeName(int newEquipmentTypeName) {
	equipmentTypeName = newEquipmentTypeName;
}
/**
 * Insert the method's description here.
 * Creation date: (13.01.2003 10:50:24)
 * @param newHaveContents boolean
 */
public void setHaveContents(boolean newHaveContents) {
	haveContents = newHaveContents;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2003 20:29:49)
 * @param newOrderIndex int
 */
public void setOrderIndex(int newOrderIndex) {
	orderIndex = newOrderIndex;
}
}
