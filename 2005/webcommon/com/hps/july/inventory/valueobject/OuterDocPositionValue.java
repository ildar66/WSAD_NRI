package com.hps.july.inventory.valueobject;

import java.util.Enumeration;
import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка строк документов "Внешний приходный ордер"
 */
public class OuterDocPositionValue {
	private com.hps.july.persistence.OuterDocPositionAccessBean o;
	private int order;
	private java.math.BigDecimal qty;
	private java.math.BigDecimal price;
	private java.math.BigDecimal sum;
	private java.math.BigDecimal outerSum;
public OuterDocPositionValue(
	OuterDocPositionAccessBean o,
	int order,
	java.math.BigDecimal qty,
	java.math.BigDecimal price)
{
	this.o = o;
	this.order = order;
	this.qty = qty;
	this.price = price;
	this.sum = new java.math.BigDecimal(0.0d);
	this.outerSum = new java.math.BigDecimal(0.0d);
	try {
		o.refreshCopyHelper();
		java.math.BigDecimal outerQty = o.getOuterQty();
		java.math.BigDecimal outerPrice = o.getOuterPrice();
		if( outerQty != null && outerPrice != null) {
			setOuterSum(outerQty.multiply(outerPrice).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 18:01:36)
 * @param qty java.math.BigDecimal
 * @param price java.math.BigDecimal
 */
public void add(java.math.BigDecimal qty, java.math.BigDecimal price)
{
	this.qty = this.qty.add(qty);
	this.price = price;
	this.sum = this.sum.add((qty.multiply(price)).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
}
public com.hps.july.persistence.OuterDocPositionAccessBean getO() {
	return o;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 17:20:41)
 * @return int
 */
public int getOrder() {
	return order;
}
public java.math.BigDecimal getOuterSum() {
	return outerSum;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 17:20:41)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 17:20:41)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty() {
	return qty;
}
public java.math.BigDecimal getSum() {
	return sum;
}
public void setO(com.hps.july.persistence.OuterDocPositionAccessBean newO) {
	o = newO;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 17:20:41)
 * @param newOrder int
 */
public void setOrder(int newOrder) {
	order = newOrder;
}
public void setOuterSum(java.math.BigDecimal newOuterSum) {
	outerSum = newOuterSum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 17:20:41)
 * @param newPrice java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newPrice) {
	price = newPrice;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 17:20:41)
 * @param newQty java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newQty) {
	qty = newQty;
}
}
