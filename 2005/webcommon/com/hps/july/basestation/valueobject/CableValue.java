package com.hps.july.basestation.valueobject;

import java.math.*;
import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Служебный класс-контейнер с параметрами кабеля.
 * Используется при вводе антенн.
 */
public class CableValue
{
	private Integer id;
//	private int range; // 800, 900, 1800, 2000
	private StringAndIntegerProperty cabletype = new StringAndIntegerProperty(); // resource ->
	private StringAndBigDecimalProperty length = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(4,2);
	private StringAndIntegerProperty gnds = new StringAndIntegerProperty();
	private StringAndBigDecimalProperty ksvn800 = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(4,2);
	private StringAndBigDecimalProperty ksvn900 = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(4,2);
	private StringAndBigDecimalProperty ksvn1800 = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(4,2);
	private StringAndBigDecimalProperty ksvn2000 = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(4,2);
public CableValue() {
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getCabletype() {
	return cabletype;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getGnds() {
	return gnds;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getId() {
	return id;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getKsvn1800() {
	return ksvn1800;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getKsvn2000() {
	return ksvn2000;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getKsvn800() {
	return ksvn800;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getKsvn900() {
	return ksvn900;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public com.hps.july.web.util.StringAndBigDecimalProperty getLength() {
	return length;
}
/**
 * 
 * @param newId java.lang.Integer
 */
public void setId(java.lang.Integer newId) {
	id = newId;
}
}
