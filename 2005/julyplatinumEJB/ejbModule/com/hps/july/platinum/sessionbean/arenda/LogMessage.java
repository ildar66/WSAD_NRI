package com.hps.july.platinum.sessionbean.arenda;

/**
 * Insert the type's description here.
 * Creation date: (21.01.2003 18:41:49)
 * @author: Alexander Shrago
 */
public class LogMessage {

    private Object[] args;

    public LogMessageTemplate template;
/**
 * LogMessage constructor comment.
 */
public LogMessage(LogMessageTemplate template) {
    super();
    this.template = template;

}
/**
 * LogMessage constructor comment.
 */
public LogMessage(LogMessageTemplate template, Object[] args) {
    super();
    this.template = template;
    this.args = args;

}
/**
 * LogMessage constructor comment.
 */
public LogMessage(LogMessageTemplate template,  int arg) {
    super();
    this.template = template;
    args = new Object[] {  new Integer(arg)};

}
/**
 * LogMessage constructor comment.
 */
public LogMessage(LogMessageTemplate template, int arg1, String arg2) {
    super();
    this.template = template;
    args = new Object[] { new Integer(arg1), arg2};

}
/**
 * LogMessage constructor comment.
 */
public LogMessage(LogMessageTemplate template, String arg) {
    super();
    this.template = template;
    args = new Object[] { arg};

}
/**
 * LogMessage constructor comment.
 */
public LogMessage(LogMessageTemplate template, String arg1, int arg2) {
    super();
    this.template = template;
    args = new Object[] { arg1, new Integer(arg2)};

}
/**
 * LogMessage constructor comment.
 */
public LogMessage(
    LogMessageTemplate template,
    String arg1,
    String arg2,
    String arg3) {
    super();
    this.template = template;
    args = new Object[] { arg1, arg2, arg3 };

}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 13:37:08)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getArgs() {
	return args;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 14:33:41)
 * @return java.lang.String
 */
public java.lang.String getMessage() {
    return args == null ? template.getText() : java.text.MessageFormat.format(template.getText(), args);

}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 13:37:08)
 * @return java.lang.Object[]
 */
public void instArgs(Object[] args) {
	this.args=args;
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 13:37:08)
 * @param newArgs java.lang.Object[]
 */
public void instArgs(int ipar) {
    args = new Object[] { new Integer(ipar)};
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 13:37:08)
 * @param newArgs java.lang.Object[]
 */
public void instArgs(int ipar1, String spar2) {
    args = new Object[] { new Integer(ipar1), spar2 };
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 13:37:08)
 * @param newArgs java.lang.Object[]
 */
public void instArgs(String par1) {
    args = new Object[] { par1 };
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 13:37:08)
 * @param newArgs java.lang.Object[]
 */
public void instArgs(String spar1, int ipar2) {
    args = new Object[] { spar1, new Integer(ipar2)};
}
}
