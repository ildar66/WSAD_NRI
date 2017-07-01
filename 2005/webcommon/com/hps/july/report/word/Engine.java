package com.hps.july.report.word;

/**
 * Insert the type's description here.
 * Creation date: (23.06.2005 16:20:47)
 * @author: Shafigullin Ildar
 */
public class Engine {
    private java.lang.String reportTitle;
    private java.lang.String[] columns;
    private java.lang.Object[][] data;
    private java.lang.Object[] prompt;
    private final static java.text.SimpleDateFormat sdFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
    private java.util.Map columnsMap;
/**
 * Engine constructor comment.
 */
public Engine() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:36:17)
 * @return java.lang.String[]
 */
public java.lang.String[] getColumns() {
	return columns;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:36:45)
 * @return java.lang.Object[][]
 */
public java.lang.Object[][] getData() {
	return data;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2005 11:00:31)
 */
public Object getData(int i, int j) {
    Object o = data[i][j];
    if (o != null) {
        return o;
    } else {
        return "";
    }
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2005 16:30:08)
 */
public Object getData(int i, String key) {
    Integer value = (Integer) columnsMap.get(key);
    if (value != null) {
        Object o = data[i][value.intValue()];
        if (o != null) {
            return o;
        } else {
            return "";
        }
    } else {
	    String errorStr = "Key: " + key + " not found!!!";
	    System.out.println(errorStr);
	    throw new ReportException(errorStr);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2005 11:00:31)
 */
public String getDateStr(int i, int j) {
    Object o = data[i][j];
    try {
        if (o != null) {
            return sdFormat.format((java.util.Date)o);
        } else {
            return "";
        }
    } catch (ClassCastException cce) {
        System.out.println("Actual class of data[" + i + "][" + j + "]:" + o.getClass().getName());
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2005 11:00:31)
 */
public String getDateStr(int i, String key) {
    Integer value = (Integer) columnsMap.get(key);
    if (value != null) {
        Object o = data[i][value.intValue()];
        try {
            if (o != null) {
                return sdFormat.format((java.util.Date) o);
            } else {
                return "";
            }
        } catch (ClassCastException cce) {
            System.out.println("Actual class of data[" + i + "][" + value.intValue() + "]:" + o.getClass().getName());
            return null;
        }
    } else {
        String errorStr = "Key: " + key + " not found!!!";
        System.out.println(errorStr);
        throw new ReportException(errorStr);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:43:20)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getPrompt() {
	return prompt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:26:23)
 */
public Object getPrompt(int i) {
    return prompt[i];
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:22:05)
 * @return java.lang.String
 */
public java.lang.String getReportTitle() throws ReportException{
	return reportTitle;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:36:17)
 * @param newColumns java.lang.String[]
 */
private void initColumns(java.lang.String[] newColumns) {
    columns = newColumns;
    if (newColumns != null) {
        columnsMap = new java.util.HashMap();
        for (int i = 0; i < newColumns.length; i++){
        	columnsMap.put(newColumns[i], new Integer(i));
        }
    }
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:36:45)
 * @param newData java.lang.Object[][]
 */
private void initData(java.lang.Object[][] newData) {
	data = newData;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:28:56)
 */
public void setData(java.lang.String[] param1, java.lang.Object[][] param2) throws java.lang.Throwable {
    initColumns(param1);
    initData(param2);
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:43:20)
 * @param newPrompt java.lang.Object[]
 */
public void setPrompt(java.lang.Object[] newPrompt) {
	prompt = newPrompt;
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2005 16:22:05)
 * @param newReportTitle java.lang.String
 */
public void setReportTitle(java.lang.String newReportTitle) {
	reportTitle = newReportTitle;
}
}
