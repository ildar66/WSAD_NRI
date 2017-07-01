package com.hps.july.siteinfo.valueobject;

/**
 * Реализация компаратора для сортировки списка оборудования
 * @author: Alexander Shrago
 */
/** 
 * @deprecated 
 * В настоящее время для вывода и сортировки списка оборудования исользуется com.hps.july.cdbc.objects.CDBCEquipmentObject
*/

public class EquipmentComparator implements java.util.Comparator {
	private int order;
/**
 * EquipmentComparator constructor comment.
 */
public EquipmentComparator() {
	super();
}
/**
 * EquipmentComparator constructor comment.
 */
public EquipmentComparator(int order) {
	super();
	this.order=order;
}
/**
 * Compares its two arguments for order.  Returns a negative integer,
 * zero, or a positive integer as the first argument is less than, equal
 * to, or greater than the second.<p>
 *
 * The implementor must ensure that <tt>sgn(compare(x, y)) ==
 * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
 * implies that <tt>compare(x, y)</tt> must throw an exception if and only
 * if <tt>compare(y, x)</tt> throws an exception.)<p>
 *
 * The implementor must also ensure that the relation is transitive:
 * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
 * <tt>compare(x, z)&gt;0</tt>.<p>
 *
 * Finally, the implementer must ensure that <tt>compare(x, y)==0</tt>
 * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
 * <tt>z</tt>.<p>
 *
 * It is generally the case, but <i>not</i> strictly required that 
 * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
 * any comparator that violates this condition should clearly indicate
 * this fact.  The recommended language is "Note: this comparator
 * imposes orderings that are inconsistent with equals."
 * 
 * @return a negative integer, zero, or a positive integer as the
 * 	       first argument is less than, equal to, or greater than the
 *	       second. 
 * @throws ClassCastException if the arguments' types prevent them from
 * 	       being compared by this Comparator.
 */
public int compare(Object o1, Object o2) {
    try {
        EquipmentObject eq1 = (EquipmentObject) o1;
        EquipmentObject eq2 = (EquipmentObject) o2;

        switch (order) {
            case EquipmentObject.ORDER_TYPE_ASC :
                {
                    return eq1.getOrderIndex() - eq2.getOrderIndex();
                }
            case EquipmentObject.ORDER_TYPE_DESC :
                {
                    return eq2.getOrderIndex() - eq1.getOrderIndex();
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
        com.hps.july.jdbcpersistence.lib.DebugSupport.printlnError(e);
        return -1;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2003 20:16:52)
 * @return int
 */
public int getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 * Creation date: (08.06.2003 20:16:52)
 * @param newOrder int
 */
public void setOrder(int newOrder) {
	order = newOrder;
}
}
