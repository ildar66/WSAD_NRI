package com.hps.july.basestation.valueobject;

/**
 * Класс ресурса кабелей
 * Используется в некоторых случаях для в формах списков
 */
public class CableResourceObject
	extends com.hps.july.persistence.CableResourceAccessBean
{
/**
 * CableResourceObject constructor comment.
 */
public CableResourceObject() {
	super();
}
/**
 * CableResourceObject constructor comment.
 * @param arg0 int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.naming.NamingException The exception description.
 */
public CableResourceObject(int arg0) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
	super(arg0);
}
/**
 * CableResourceObject constructor comment.
 * @param arg0 int
 * @param arg1 java.lang.String
 * @param arg2 java.lang.String
 * @param arg3 java.lang.String
 * @param arg4 java.lang.Boolean
 * @param arg5 java.lang.String
 * @param arg6 java.lang.Boolean
 * @param arg7 java.lang.Boolean
 * @param arg8 java.lang.Boolean
 * @param arg9 java.lang.Boolean
 * @param arg10 int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.naming.NamingException The exception description.
 */
public CableResourceObject(int arg0, String arg1, String arg2, String arg3, Boolean arg4, String arg5, Boolean arg6, Boolean arg7, Boolean arg8, Boolean arg9, int arg10, int argCableDiam) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
	super(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, argCableDiam);
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2003 22:37:33)
 * @param acBean com.hps.july.persistence.CableResourceAccessBean
 */
public CableResourceObject(
    com.hps.july.persistence.CableResourceAccessBean acBean) throws Exception {

    this(acBean.getEJBRef());

}
/**
 * CableResourceObject constructor comment.
 * @param o javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
public CableResourceObject(javax.ejb.EJBObject o) throws java.rmi.RemoteException {
	super(o);
}
/**
 * Insert the method's description here.
 * Creation date: (18.04.2003 22:46:13)
 * @return java.lang.String
 */
public String getfullName() throws Exception {
	return getModel()+" "+getName();
}
}
