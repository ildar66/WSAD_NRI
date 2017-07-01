package com.hps.july.commonbean;

import java.util.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import com.hps.july.persistence.*;
import com.hps.july.organizer.valueobject.*;
/**
 * This is a Session Bean Class
 * ѕолучение списка задач, доступных оператору
 */
public class OrganizerBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * ѕолучение списка задач, доступных оператору.
 * Creation date: (18.02.2002 10:39:15)
 * @return java.util.List
 * @param operator int
 */
public OperatorTask[] getOperatorTasks(String operator)  throws java.rmi.RemoteException {
	ArrayList al = new ArrayList();
	try {
		//System.out.println( "operator="+operator );
		OperatorAccessBean operatorBean = (new OperatorAccessBean()).findByLogin( operator );
		Enumeration e = operatorBean.getOperators2Roles();
		//System.out.println( "before first enumeration=" );
		while( e.hasMoreElements() ) {
			Object o = e.nextElement();
			Operators2RolesAccessBean o2r  = new Operators2RolesAccessBean( (EJBObject)o );
			RoleAccessBean role = new RoleAccessBean();
			role.setInitKey_role( o2r.getRoleKey().role );
			role.refreshCopyHelper();
			//System.out.println( "inside first enumeration role_='"+role.getRole()+"'" );
			Roles2TasksAccessBean r2t= new Roles2TasksAccessBean();
			Enumeration tasks = r2t.findRoles2TasksByRoleString( o2r.getRoleKey().role );
			//System.out.println( "before second enumeration=" );
			while( tasks.hasMoreElements() ) {
				//System.out.println( "inside second enumeration" );
				Object oo = tasks.nextElement();
				//System.out.println( "object class="+oo.getClass().getName() );
				Roles2TasksAccessBean r2task = (Roles2TasksAccessBean)oo;
				TaskAccessBean task = r2task.getTask();
				//System.out.println( "inside second enumeration task="+task.getTaskname() );
				OperatorTask ot = new OperatorTask( task.getTask(), task.getTaskname(), role.getRole(), task.getContext() );
				int idx = Collections.binarySearch( al, ot );
				if( idx < 0 ) {
					al.add( ot );
					//System.out.println( "adding element" );
					Collections.sort( al ); 
				} else {
					((OperatorTask)al.get( idx )).addRole( role.getRole() );
				}
			} 
		}
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While getting task list: ", e );
	} catch( Throwable t ) {
		System.out.println( "EXCEPTION "+t );		
		t.printStackTrace();
	}
	//System.out.println( "ret number="+al.size() );
	return (OperatorTask[])al.toArray(new OperatorTask[] {} );
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}
