package com.hps.july.arenda.formbean;

/**
 * bean-form
 * Лист истории вычислений.
 * Creation date: (06.06.2003 17:07:31)
 * @author: Sergey Gourov
 */
public class ErrorCalcHistoryList extends JournalProlongationsListForm {
	private java.lang.String reportUrl;
	private int order;
/**
 * Insert the method's description here.
 * Creation date: (18.09.2003 15:43:01)
 */
public ErrorCalcHistoryList() {
	setFinderMethodName("2");
	order = 2;
}
/**
 * Insert the method's description here.
 * Creation date: (26.09.2002 11:57:38)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	try {
		order = Integer.parseInt(super.getFinderMethodName());
	} catch (NumberFormatException e) {}
	
	return new Object[] { new Integer(getTaskStartcode()), getIsError(), getIsWarning(), getIsSuccess(), new Integer(order) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByQBE";
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 15:25:24)
 * @return java.lang.String
 */
public java.lang.String getReportUrl() {
	try {
		return java.net.URLDecoder.decode(reportUrl);
	} catch (Exception e) {
		e.printStackTrace();
		return "";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (09.06.2003 15:25:24)
 * @param newReportUrl java.lang.String
 */
public void setReportUrl(java.lang.String newReportUrl) {
	reportUrl = newReportUrl;
}
}
