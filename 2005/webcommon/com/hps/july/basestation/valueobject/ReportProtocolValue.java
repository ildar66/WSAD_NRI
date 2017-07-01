package com.hps.july.basestation.valueobject;

import java.math.BigDecimal;

public class ReportProtocolValue {
	private ReportProtocolPosition a;
	private ReportProtocolPosition b;
public ReportProtocolValue() {
	super();
}
public ReportProtocolValue(ReportProtocolPosition pa, ReportProtocolPosition pb) {
	this();
	a = pa;
	b = pb;
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.ReportProtocolPosition
 */
public ReportProtocolPosition getA() {
	return a;
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.ReportProtocolPosition
 */
public ReportProtocolPosition getB() {
	return b;
}
/**
 * 
 * @param newA com.hps.july.basestation.valueobject.ReportProtocolPosition
 */
public void setA(ReportProtocolPosition newA) {
	a = newA;
}
/**
 * 
 * @param newB com.hps.july.basestation.valueobject.ReportProtocolPosition
 */
public void setB(ReportProtocolPosition newB) {
	b = newB;
}
}
