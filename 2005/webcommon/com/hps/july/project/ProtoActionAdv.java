package com.hps.july.project;

/**
 * Объект-wrapper для класса ProtoActionAccessBean.
 * Creation date: (04.12.2002 11:35:50)
 * @author: Alexander Shrago
 */
public class ProtoActionAdv extends com.hps.july.persistence.ProtoActionAccessBean {
	private ProtoActionAdv stepbeforeProtoAction;
	private int stepbefore_order;
/**
 * ProtoActionAdv constructor comment.
 */
public ProtoActionAdv() {
	super();
}
/**
 * ProtoActionAdv constructor comment.
 * @param arg0 int
 * @param arg1 int
 * @param arg2 int
 * @param arg3 int
 * @param arg4 int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.naming.NamingException The exception description.
 */
public ProtoActionAdv(int arg0, int arg1, int arg2, int arg3, int arg4) throws javax.ejb.CreateException, java.rmi.RemoteException, javax.naming.NamingException {
	super(arg0, arg1, arg2, arg3, arg4);
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 11:45:17)
 * @param protoActionAdv com.hps.july.project.ProtoActionAdv
 */
public ProtoActionAdv(com.hps.july.persistence.ProtoActionAccessBean protoAction) throws Exception{
	super(protoAction.getEJBRef());
	
	Integer stepbefore=getStepbefore();//wait
	if(stepbefore!=null){
	stepbeforeProtoAction=new ProtoActionAdv();
	stepbeforeProtoAction.setInitKey_projectaction(stepbefore.intValue());
	stepbeforeProtoAction.refreshCopyHelper();
	}
	}
/**
 * ProtoActionAdv constructor comment.
 * @param o javax.ejb.EJBObject
 * @exception java.rmi.RemoteException The exception description.
 */
public ProtoActionAdv(javax.ejb.EJBObject o) throws java.rmi.RemoteException {
	super(o);
}
/**
 * Insert the method's description here.
 * Creation date: (13.01.2003 12:02:30)
 * @return int
 */
public int getDivisionKey() throws Exception{
	return getProjectActionType().getAction2divisionKey().division;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 12:13:11)
 * @return int
 */
public int getStepbefore_Order() throws Exception {
	return stepbeforeProtoAction==null?0:stepbeforeProtoAction.getOrder();
}
}
