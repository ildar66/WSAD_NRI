package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
import java.util.*;

/**
** JDBC - ������ ��� ������ � ����������� �� ��������� ������".
* Creation date: (18.11.2004 12:26:23)
* @author: Shafigullin Ildar
*/
public class CDBC_ArendaReports {
/**
 * ����� � ��������� ��������� ������.
 * ������������ ��������� ��������� ������ �� ������.
 *  ������ ������ � �������� ���������
 * Creation date: (18.11.2004 12:35:39)
 */
public static CDBCResultSet reportArendaCosts(Integer argEconomist, java.sql.Date argStartDate, java.sql.Date argEndDate) {
	CDBCResultSet res = new CDBCResultSet();
	LinkedList params = new LinkedList();
	
	params.add(argEconomist);  // ������������� ���������
	params.add(argStartDate);   // ���� ������ ������
	params.add(argEndDate);    // ���� ��������� ������
	
	res.executeQuery("EXECUTE PROCEDURE  getContrArOnOtv(?, ?, ?);", params.toArray());
	
	return res;
}
}
