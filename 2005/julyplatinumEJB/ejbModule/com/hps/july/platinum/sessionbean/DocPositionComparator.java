package com.hps.july.platinum.sessionbean;

/**
 * Insert the type's description here.
 * Creation date: (26.12.2002 17:16:50)
 * @author: Dmitry Dneprov
 */
public class DocPositionComparator implements java.util.Comparator {
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
public int compare(Object o1, Object o2) throws ClassCastException {

	if (!(o1 instanceof DocPositionObject))
		throw new ClassCastException();
		
	if (!(o2 instanceof DocPositionObject))
		throw new ClassCastException();

	DocPositionObject to1 = (DocPositionObject)o1;
	DocPositionObject to2 = (DocPositionObject)o2;

	if (to1.getBlankdate().getTime() < to2.getBlankdate().getTime())
		return -1;
	else if (to1.getBlankdate().getTime() > to2.getBlankdate().getTime())
		return 1;
	else if (to1.getLocType() < to2.getLocType())
		return -1;
	else if (to1.getLocType() > to2.getLocType())
		return 1;
	return 0;
}
	/**
	 * 
	 * Indicates whether some other object is &quot;equal to&quot; this
	 * Comparator.  This method must obey the general contract of
	 * <tt>Object.equals(Object)</tt>.  Additionally, this method can return
	 * <tt>true</tt> <i>only</i> if the specified Object is also a comparator
	 * and it imposes the same ordering as this comparator.  Thus,
	 * <code>comp1.equals(comp2)</code> implies that <tt>sgn(comp1.compare(o1,
	 * o2))==sgn(comp2.compare(o1, o2))</tt> for every object reference
	 * <tt>o1</tt> and <tt>o2</tt>.<p>
	 *
	 * Note that it is <i>always</i> safe <i>not</i> to override
	 * <tt>Object.equals(Object)</tt>.  However, overriding this method may,
	 * in some cases, improve performance by allowing programs to determine
	 * that two distinct Comparators impose the same order.
	 *
	 * @param   obj   the reference object with which to compare.
	 * @return  <code>true</code> only if the specified object is also
	 *		a comparator and it imposes the same ordering as this
	 *		comparator.
	 * @see     java.lang.Object#equals(java.lang.Object)
	 * @see java.lang.Object#hashCode()
	 */
public boolean equals(Object obj) {
	return false;
}
}
