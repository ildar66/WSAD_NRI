package com.hps.july.dataimport.lib;

/**
   * Вспомогательный класс импорта данных
*/

public class RecordLoggerTargetException
    extends java.lang.reflect.InvocationTargetException {
    private String errorLabel;
    private String errorAction;
    private String[] parameters;
public RecordLoggerTargetException() {
    super();
    errorAction = ColumnHandler.getDefErrAction();
}
public RecordLoggerTargetException(String errAction) {

    super();    
    errorAction = errAction;
}
public RecordLoggerTargetException(String errorLabel, String[] parameters) {
    super();
    this.errorLabel = errorLabel;
    this.parameters = parameters;
    errorAction = ColumnHandler.getDefErrAction();
}
public RecordLoggerTargetException(
    String errorLabel,
    String[] parameters,
    String errAction) {
	    
    super();
    this.errorLabel = errorLabel;
    this.parameters = parameters;
    errorAction = errAction;
}
public RecordLoggerTargetException(Throwable target) {
    super();

}
public RecordLoggerTargetException(Throwable target,String s) {
    super();

}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2003 15:32:09)
 * @return java.lang.String
 */
public java.lang.String getErrorAction() {
	return errorAction;
}
public java.lang.String getErrorLabel() {
    return errorLabel;
}
public java.lang.String[] getParameters() {
	return parameters;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2003 15:32:09)
 * @param newErrorAction java.lang.String
 */
public void setErrorAction(java.lang.String newErrorAction) {
	errorAction = newErrorAction;
}
public void setErrorLabel(java.lang.String newErrorLabel) {
	errorLabel = newErrorLabel;
}
public void setParameters(java.lang.String[] newParameters) {
	parameters = newParameters;
}
}
