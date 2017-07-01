package com.hps.july.arenda.cdbcobjects;

import com.hps.july.cdbc.lib.*;
import java.util.*;

/**
** JDBC - Объект для работы с отчетностью по договорам аренды".
* Creation date: (18.11.2004 12:26:23)
* @author: Shafigullin Ildar
*/
public class CDBC_ArendaReports {
/**
 * Отчет о стоимости договоров аренды.
 * Подсчитывает стоимость договоров аренды за период.
 *  логика отчета в хранимой процедуре
 * Creation date: (18.11.2004 12:35:39)
 */
public static CDBCResultSet reportArendaCosts(Integer argEconomist, java.sql.Date argStartDate, java.sql.Date argEndDate) {
	CDBCResultSet res = new CDBCResultSet();
	LinkedList params = new LinkedList();
	
	params.add(argEconomist);  // Ответственный экономист
	params.add(argStartDate);   // Дата начала отчета
	params.add(argEndDate);    // Дата окончания отчета
	
	res.executeQuery("EXECUTE PROCEDURE  getContrArOnOtv(?, ?, ?);", params.toArray());
	
	return res;
}
}
