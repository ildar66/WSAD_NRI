package com.hps.july.inventory.sessionbean;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * ProcessorFacadeAccessBean
 * @generated
 */
public class ProcessorFacadeAccessBean extends AbstractSessionAccessBean {
	/**
	 * @generated
	 */
	private ProcessorFacade __ejbRef;
	/**
	 * ProcessorFacadeAccessBean
	 * @generated
	 */
	public ProcessorFacadeAccessBean() {
		super();
	}
	/**
	 * ProcessorFacadeAccessBean
	 * @generated
	 */
	public ProcessorFacadeAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "com/hps/july/inventory/sessionbean/ProcessorFacade";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.inventory.sessionbean.ProcessorFacadeHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.inventory
				.sessionbean
				.ProcessorFacadeHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.inventory.sessionbean.ProcessorFacadeHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.inventory.sessionbean.ProcessorFacade ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.inventory
						.sessionbean
						.ProcessorFacade) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.inventory.sessionbean.ProcessorFacade.class);

		return __ejbRef;
	}
	/**
	 * instantiateEJB
	 * @generated
	 */
	protected void instantiateEJB()
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		if (ejbRef() != null)
			return;

		ejbRef = ejbHome().create();
	}
	/**
	 * deleteDocument
	 * @generated
	 */
	public void deleteDocument(java.lang.Integer documentCode)
		throws
			javax.naming.NamingException,
			com.hps.july.inventory.sessionbean.DocumentProcessingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().deleteDocument(documentCode);
	}
	/**
	 * cancelDocument
	 * @generated
	 */
	public void cancelDocument(
		java.lang.Integer docCode,
		boolean deleteAddInfo)
		throws
			javax.naming.NamingException,
			com.hps.july.inventory.sessionbean.DocumentProcessingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().cancelDocument(docCode, deleteAddInfo);
	}
	/**
	 * processDocument
	 * @generated
	 */
	public void processDocument(
		java.lang.Integer docCode,
		boolean deleteAddInfo,
		boolean generateAutoDocs)
		throws
			javax.naming.NamingException,
			com.hps.july.inventory.sessionbean.DocumentProcessingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().processDocument(docCode, deleteAddInfo, generateAutoDocs);
	}
	/**
	 * processDocument
	 * @generated
	 */
	public void processDocument(java.lang.Integer docCode)
		throws
			javax.naming.NamingException,
			com.hps.july.inventory.sessionbean.DocumentProcessingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().processDocument(docCode);
	}
	/**
	 * cancelDocument
	 * @generated
	 */
	public void cancelDocument(java.lang.Integer docCode)
		throws
			javax.naming.NamingException,
			com.hps.july.inventory.sessionbean.DocumentProcessingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().cancelDocument(docCode);
	}
	/**
	 * checkAddInfoModification
	 * @generated
	 */
	public boolean checkAddInfoModification(java.lang.Integer docCode)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().checkAddInfoModification(docCode);
	}
	/**
	 * processDocument
	 * @generated
	 */
	public void processDocument(
		java.lang.Integer docCode,
		boolean deleteAddInfo)
		throws
			javax.naming.NamingException,
			com.hps.july.inventory.sessionbean.DocumentProcessingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().processDocument(docCode, deleteAddInfo);
	}
}
