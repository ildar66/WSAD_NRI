package com.hps.july.project.valueobject;

/**
 * Счетчик обновлений страниц.
 * Creation date: (09.01.2004 11:49:17)
 * @author: Dmitry Dneprov
 */
public class RefreshCounter {
/**
 * RefreshCounter constructor comment.
 */
public RefreshCounter() {
	super();
}
/**
 * Отметить что требуется обновление.
 * Creation date: (09.01.2004 11:50:23)
 */
public static void markRefreshNeeded(javax.servlet.ServletContext application) {
		// Update Refresh counter from application
		String refrcnt = (String)application.getAttribute("REFRCNT");
		if (refrcnt == null) {
			refrcnt = "0";
		}
		int iRefrCnt = Integer.parseInt(refrcnt) + 1;
		refrcnt = "" + iRefrCnt;
		application.setAttribute("REFRCNT", refrcnt);
}
}
