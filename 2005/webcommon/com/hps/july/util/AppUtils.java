package com.hps.july.util;

import java.util.*;
import java.math.BigDecimal;
import com.hps.july.persistence.*;
/**
 * ����� �������� ����������� �������, ����� ��� ���� �������.
 * Creation date: (25.11.2003 12:07:36)
 * @author: Dmitry Dneprov
 */
public class AppUtils {
    public final static String DEFAULT_RATE_NDS = "DefaultRateNds";
    public final static String ARENDA_RES_EQUIPMENT = "ARENDA_RES_EQUIPMENT";
    public final static String ARENDA_RES_CONNECT = "ARENDA_RES_CONNECT";
    public final static String RUR_CODE = "RUR";
    public final static String USD_CODE = "USD";

    public final static java.text.DecimalFormat nformat = new java.text.DecimalFormat("#,##0.####");
    public final static java.text.DecimalFormat cformat = new java.text.DecimalFormat("#,##0.00");
    public final static java.text.DecimalFormatSymbols decimalFormatSymbols = new java.text.DecimalFormatSymbols();

    private final static String sFormat = ".000000000000000000000000000000000000000000000";

    static {
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(' ');
        nformat.setDecimalFormatSymbols(decimalFormatSymbols);
        cformat.setDecimalFormatSymbols(decimalFormatSymbols);
    }
    //��� ������� ������� ������������ ����������:
    private final static HashMap hashVariable = new java.util.HashMap();
    private final static String[] arrayNonCashVariable = { "��� ���������� ���������� 1", "��� ���������� ���������� 2" };
    private final static List listNonCashVariable = Arrays.asList(arrayNonCashVariable); //������ ���������� ����������
/**
 * AppUtils constructor.
 */
public AppUtils() {
	super();
}
/**
 * �������� ��������� �������(*\/?<>|:" ) �� ������ '_'.
 * Creation date: (05.02.2004 17:25:33)
 */
public static String filter(String name) {
	char[] a = name.toCharArray();
	for (int i = 0; i < a.length; i++) {
		char c = a[i];
		if (c == '*'
			|| c == '\\'
			|| c == '/'
			|| c == '?'
			|| c == '<'
			|| c == '>'
			|| c == '|'
			|| c == ':'
			|| c == '"'
			|| c == ' ') {
			a[i] = '_';
		}
	}
	return new String(a);
}
/**
 * ��������� ���� � ��������� ������ �������� � JULY
 * @return java.lang.String
 */
public static String formatBigDecimal(BigDecimal number) {
	return nformat.format(number);
}
/**
 * ��������� ���� � ��������� ������ �������� � JULY
 * ����������� �������� ���������� ������ � ������� �����
 * @return java.lang.String
 */
public static String formatBigDecimal(BigDecimal number, int fractdigits) {
	java.text.DecimalFormat f = null;
	// new java.text.DecimalFormat("#,##0.####");
	if (fractdigits > 0 && fractdigits < sFormat.length()-1) {
		f = new java.text.DecimalFormat("#,##0" + sFormat.substring(0, fractdigits+1));
		f.setDecimalFormatSymbols(decimalFormatSymbols);
	} else {
		f = nformat;
	}
	return f.format(number);
}
/**
 * ��������� �������� �������� �������� �������� � ��������� ������ �������� � JULY
 * @return java.lang.String
 */
public static String formatCurrency(BigDecimal number) {
	return cformat.format(number);
}
	/**
 	 * ���������� ����������� �������� ���� String.
	 * Creation date: (07.10.2004 14:34:53)
	 * @return java.lang.String
	 * @param aName java.lang.String
	 */
	public static String getHelpFileName(int argApp, int argState) {

		StringBuffer result = new StringBuffer("/");
		if (argApp == com.hps.july.constants.Applications.ARENDA)
			result.append("arendahelp/arenda");
		else if (argApp == com.hps.july.constants.Applications.INVENTORY)
			result.append("inventoryhelp/inventory");
		else if (argApp == com.hps.july.constants.Applications.BASESTATION)
			result.append("basestationhelp/basestation");			
		result.append("" + argState);
		result.append(".doc");
		return result.toString();
	}
public static int getInventoryVariant()
{
	return getNamedValueInt("INVENTORY_VARIANT");
}
/**
 * ���������� ����������� �������� ���� BigDecimal.
 * Creation date: (25.11.2003 12:11:34)
 * @return java.math.BigDecimal
 * @param aName java.lang.String
 */
public static final java.math.BigDecimal getNamedValueBigDecimal(String aName) {
    //��� ������� ������� ������������ ����������:
    boolean flagCash = isCash(aName);
    if (flagCash && hashVariable.containsKey(aName)) {
        return (java.math.BigDecimal) hashVariable.get(aName);
    } else {
        java.math.BigDecimal result = null;
        try {
            NamedValueAccessBean nab = new NamedValueAccessBean();
            nab.setInitKey_id(aName);
            nab.refreshCopyHelper();
            result = nab.getDecimalvalue();
            if (flagCash)
                hashVariable.put(aName, result);
        } catch (Exception e) {
        	System.out.println("getNamedValueBigDecimal Cannot find NamedValue constant: " + aName);
            //e.printStackTrace(System.out);
        }
        return result;
    }
}
/**
 * ���������� ����������� �������� ���� int.
 * Creation date: (25.11.2003 12:11:34)
 * @return int
 * @param aName java.lang.String
 */
public static final int getNamedValueInt(String aName) {
    //��� ������� ������� ������������ ����������:
    boolean flagCash = isCash(aName);
    if (flagCash && hashVariable.containsKey(aName)) {
        return ((Integer) hashVariable.get(aName)).intValue();
    } else {
        int result = 0;
        try {
            NamedValueAccessBean nab = new NamedValueAccessBean();
            nab.setInitKey_id(aName);
            nab.refreshCopyHelper();
            result = nab.getIntvalue();
            if (flagCash)
                hashVariable.put(aName, new Integer(result));
        } catch (Exception e) {
			System.out.println("getNamedValueInt Cannot find NamedValue constant: " + aName);
            //e.printStackTrace(System.out);
        }
        return result;
    }
}
/**
 * ���������� ����������� �������� ���� String.
 * Creation date: (07.10.2004 14:34:53)
 * @return java.lang.String
 * @param aName java.lang.String
 */
public static final String getNamedValueString(String aName) {
    //��� ������� ������� ������������ ����������:
    boolean flagCash = isCash(aName);
    if (flagCash && hashVariable.containsKey(aName)) {
        return (String) hashVariable.get(aName);
    } else {
        String result = new String("");
        try {
            NamedValueAccessBean nab = new NamedValueAccessBean();
            nab.setInitKey_id(aName);
            nab.refreshCopyHelper();
            result = nab.getCharvalue();
            if (flagCash)
                hashVariable.put(aName, result);
        } catch (Exception e) {
			System.out.println("getNamedValueString Cannot find NamedValue constant: " + aName);
            //e.printStackTrace(System.out);
        }
        return result;
    }

}
/**
 * ��� ������� ������� ������������ ����������.
 * Creation date: (16.11.2005 11:36:32)
 */
private static final boolean isCash(String aName) {
    return !listNonCashVariable.contains(aName);
}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.10.2004 19:08:13)
	 * @return boolean
	 */
	public static boolean isMicrostrategyAccess(String userName) {

		int result = getNamedValueInt(com.hps.july.web.util.Constants.MICROSTRATEGY_VISIBILITY);

		if(userName != null) {
			StringBuffer sql = new StringBuffer("SELECT ");
			sql.append("	o.msucode ");
			sql.append("FROM ");
			sql.append("	operators o, msusers m ");
			sql.append("WHERE ");
			sql.append(" m.msucode = o.msucode AND o.loiginid = ?");
			com.hps.july.cdbc.lib.CDBCResultSet rs = new com.hps.july.cdbc.lib.CDBCResultSet();
			rs.executeQuery(sql.toString(), new Object[] { userName });
			Iterator iterator = rs.listIterator();
			if(!iterator.hasNext()) {
				result = 0;
			}
		} else result = 0;
		
		return (result == 1)?true:false;
	}
public static boolean isNewInventory()
{
	int ni = getNamedValueInt("AccountingVariant");
	return ni == 2;
}
/**
 * �������� ��� ������� � ������ �� '&nbsp;' (������������� ������)
 * ���������� ������������ ��� ������ ���� �������� ������� �� ����� � ����
 */
public static String replaceSpaces2Nbsp(String anumber) {
	if(anumber == null) {
		return "";
	}
	StringBuffer output = new StringBuffer();
	int si = 0, ei = 0;
	while((ei = anumber.indexOf(" ",si)) >= 0) {
		output.append(anumber.substring(si,ei));
		output.append("&nbsp;");
		si = ei + 1;
	}
	if(si < anumber.length()) {
		output.append(anumber.substring(si,anumber.length()));
	}
	return output.toString();
}
}
