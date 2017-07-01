package com.hps.july.web.util;

import java.sql.Date;
import java.util.Calendar;
/**
 * ����� ��� �������� �������� ���� Date.
 * Creation date: (24.04.2002 12:13:35)
 * @author: Oleg Gashnikov
 */
public class StringAndSqlDateProperty
	extends TwainProperty
{
	private String stringVal;
	private Date dateVal;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private static java.util.Calendar cal = new java.util.GregorianCalendar();
	/**
		Constructor
	*/
	public StringAndSqlDateProperty() {
		format = new java.text.SimpleDateFormat( "dd.MM.yyyy" );
	}
/**
 * ���������� ����.
 * Creation date: (24.04.2002 12:21:53)
 * @return java.math.BigDecimal
 */
public Date getSqlDate() {
	return dateVal;
}
/**
 * �������� ��������� �������������.
 * Creation date: (24.04.2002 12:21:18)
 * @return java.lang.String
 */
public String getString() {
	return stringVal;
}
/**
 * �������� ������� ��������.
 */
public boolean isEmpty() {
	return ((stringVal == null) || (stringVal.length() == 0));
}
/**
   * �������������� ������ � ����
*/
public static java.sql.Date parseDateString(String argStr)
	throws java.text.ParseException
{
	java.util.Date d = format.parse(argStr);
	java.sql.Date ds = new java.sql.Date(d.getTime());
//	System.out.println("PARSEDATE:"+ds+" util.Date:"+d);
	return ds;
}
/**
 * ������������� ����.
 * Creation date: (24.04.2002 12:15:32)
 * @param argBD java.math.BigDecimal
 */
public void setSqlDate(Date argBD) {
	dateVal = argBD;
	if (argBD == null)
	  stringVal = "";
	else
		stringVal =   
			format.format( new java.util.Date( argBD.getTime() ) );
	setOk( true );
}
/**
 * ���������� ��������� �������������.
 * Creation date: (24.04.2002 12:21:18)
 */
public void setString(String argStr) {
	stringVal = argStr;
	if (argStr == null || argStr.length() == 0) {
		dateVal = null;
		setOk( true );
	} else {
		//System.out.println("DEBUG: date='" + argStr + "'");
		try {
			dateVal = parseDateString(argStr);
			if( stringVal != null && stringVal.length() != 0 && dateVal == null )
				setOk( false );
			else
				setOk( true );
		} catch (Exception e) {
			e.printStackTrace(System.out);
			setOk( false );
		}
	}
}
}
