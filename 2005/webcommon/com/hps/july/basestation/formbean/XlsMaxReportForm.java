package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;
import java.util.*;
import java.text.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма подробного отчёта о результатах загрузки данных
 */
public class XlsMaxReportForm extends BrowseForm {
	private int impsesid;
public XlsMaxReportForm() {
    super();
    //action = null;
    //result = null;
    //errlabel = null;
    //recendtime = null;
    //keyfields = null;

    setFinderMethodName("findImportRecordsByImportsession");
}
	public java.lang.Object[] getFilterParams() {
		return new Object[] {
			new ImportSessionKey(impsesid)
		};
	}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2003 15:54:47)
 * @return int
 */
public int getImpsesid() {
	return impsesid;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2003 15:54:47)
 * @param newImpsesid int
 */
public void setImpsesid(int newImpsesid) {
	impsesid = newImpsesid;
}
}
