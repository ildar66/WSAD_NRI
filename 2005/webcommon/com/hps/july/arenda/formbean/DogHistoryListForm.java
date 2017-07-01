package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import java.util.*;

import com.hps.july.arenda.cdbcobjects.CDBC_LeaseOnPosition_Object;
import com.hps.july.arenda.sessionbean.*;
import com.hps.july.util.*;

/**
 * Форма - список истории договора аренда (HIstory).
 * Creation date: (04.11.2003 14:37:20)
 * @author: Dmitry Dneprov
 */
public class DogHistoryListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Integer contract;
	private java.lang.Integer operator;
	private java.lang.Integer resource;
	private java.sql.Date sdate;
	private java.util.Enumeration resources;
	private java.sql.Date edate;
	private java.lang.String dateper;
	private java.lang.String posname;
	private java.lang.String contrnum;
	private java.sql.Date contrdate;
	private java.lang.String orgname;
	private java.lang.String custname;
	private int maincontract;
	private int journalcode;
	private boolean manyresources;
	private java.lang.String resname;
	private int checkCode;

	private String economist;
	private String vendor;
	private java.lang.String manager;
	private java.lang.String comment;
	private java.lang.String subject;
	private boolean dirtyComment;
	/**
	 * DogHistoryListForm constructor comment.
	 */
	public DogHistoryListForm() {
		super();
		setDateper("A");
		//setContract(new Integer(0));
		setOperator(new Integer(0));
		setResource(new Integer(0));
		setFinderMethodName("findByQBE");
		setJournalcode(0);
		setManyresources(true);
		setEconomist("");
		setVendor(null);
		setManager("");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:10:59)
	 * @param newContract java.lang.Integer
	
	private void afterSetContract() {
		try {
			try {
				setMaincontract(
					new LeaseArendaAgreementProcessorAccessBean()
						.getBaseContract(
						getContract().intValue()));
			} catch (Exception ee) {
				// No main contract
				//setMaincontract(0);
				ee.printStackTrace(System.out);
			}
			LeaseContractAccessBean ab = new LeaseContractAccessBean();
			ab.setInitKey_leaseDocument(getMaincontract());
			ab.refreshCopyHelper();
			setPosname("");
			setContrnum(ab.getDocumentNumber());
			setContrdate(ab.getDocumentDate());
			if (ab.getOrgExecutor() != null) {
				setOrgname(ab.getOrgExecutor().getName());
			} else {
				setOrgname("");
			}
			if (ab.getOrgCustomer() != null) {
				setCustname(ab.getOrgCustomer().getName());
			} else {
				setCustname("");
			}
			if (ab.getEconomist() != null) {
				setEconomist(ab.getEconomist().getMan().getFullName());
			} else {
				setEconomist("");
			}
			try {
				PIEDopInfoContrAccessBean pica =
					new PIEDopInfoContrAccessBean();
				pica.setInitKey_leasedocument(ab.getLeaseDocument());
				pica.refreshCopyHelper();
				setVendor(pica.getVendor());
			} catch (Exception ee) {
				setVendor(null);
			}
		} catch (Exception e) {
			// Contract not found - clear fields
			setPosname("");
			setContrnum("");
			setContrdate(null);
			setOrgname("");
			setCustname("");
		}
	}
	 */
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:10:59)
	 * @param newContract java.lang.Integer
	 */
	private void afterSetMainContract(Integer mainDocument) {
		try {
			try {
				contract = com.hps.july.logic.DocumentLogic.getCodeActiveDocument(mainDocument.intValue());
			} catch (Exception ee) {
				ee.printStackTrace(System.out);
			}
			/** из главного */
			LeaseArendaAgreementNewAccessBean ab = new LeaseArendaAgreementNewAccessBean();
			ab.setInitKey_leaseDocument(getMaincontract());
			ab.refreshCopyHelper();
			setContrnum(ab.getDocumentNumber());
			setContrdate(ab.getDocumentDate());
			if (ab.getOrgExecutor() != null) {
				setOrgname(ab.getOrgExecutor().getName());
			} else {
				setOrgname("");
			}
			if (ab.getOrgCustomer() != null) {
				setCustname(ab.getOrgCustomer().getName());
			} else {
				setCustname("");
			}
			if (ab.getEconomist() != null) {
				setEconomist(ab.getEconomist().getMan().getFullName());
			} else {
				setEconomist("");
			}
			if (ab.getMainresource() != null) {
				setResource(ab.getMainresource());
				ResourceAccessBean resAB = new ResourceAccessBean();
				resAB.setInitKey_resource(getResource().intValue());
				setResname(resAB.getName());
			} else {
				setResource(new Integer(0));
				setResname("");
			}
			//устанавливаем отв. экономиста:
			WorkerAccessBean manager = ab.getManager();
			if (manager != null)
				setManager(manager.getMan().getFullName());
			else
				setManager("");

			/**из активного:*/
			LeaseArendaAgreementNewAccessBean laaAB = new LeaseArendaAgreementNewAccessBean();
			laaAB.setInitKey_leaseDocument(getContract().intValue());
			//устанавливаем главную позицию:
			setPosname(getNameMainPosition(laaAB));

		} catch (Exception e) {
			// Contract not found - clear fields
			e.printStackTrace();
			setPosname("");
			setContrnum("");
			setContrdate(null);
			setOrgname("");
			setCustname("");
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.12.2003 17:27:44)
	 * @return int
	 */
	public int getCheckCode() {
		return checkCode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.04.2004 14:05:26)
	 * @return java.lang.String
	 */
	public java.lang.String getComment() {
		return comment;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:10:59)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getContract() {
		return contract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 19:03:37)
	 * @return java.sql.Date
	 */
	public java.sql.Date getContrdate() {
		return contrdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 19:03:16)
	 * @return java.lang.String
	 */
	public java.lang.String getContrnum() {
		return contrnum;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCustname() {
		return custname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:13:04)
	 * @return java.lang.String
	 */
	public java.lang.String getDateper() {
		return dateper;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getEconomist() {
		return economist;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:12:32)
	 * @return java.sql.Date
	 */
	public java.sql.Date getEdate() {
		return edate;
	}
	/**
	 * Возвращает список ролей, которым разрешено редактирование.
	 * Creation date: (27.06.2002 16:47:06)
	 * @return java.util.ArrayList
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		//roles.add("ArendaDirector"); 
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");

		return roles;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 14:37:20)
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getFilterParams() {
		Boolean isByDates = Boolean.FALSE;
		setSdate(new java.sql.Date(new java.util.Date().getTime()));
		setEdate(new java.sql.Date(new java.util.Date().getTime()));
		if ("C".equals(getDateper())) {
			// Set period to current year
			isByDates = Boolean.TRUE;
			java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
			cal.setTime(new java.util.Date());
			int year = cal.get(java.util.GregorianCalendar.YEAR);

			// Start date
			cal.set(java.util.GregorianCalendar.DAY_OF_MONTH, 1);
			cal.set(java.util.GregorianCalendar.MONTH, 0);
			setSdate(new java.sql.Date(cal.getTime().getTime()));

			// End date
			cal.set(java.util.GregorianCalendar.DAY_OF_MONTH, 31);
			cal.set(java.util.GregorianCalendar.MONTH, 11);
			setEdate(new java.sql.Date(cal.getTime().getTime()));
		}

		if ("L".equals(getDateper())) {
			// Set period to last year
			isByDates = Boolean.TRUE;
			java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
			cal.setTime(new java.util.Date());

			// Start date
			setEdate(new java.sql.Date(cal.getTime().getTime()));

			// End date
			int year = cal.get(java.util.GregorianCalendar.YEAR);
			cal.set(java.util.GregorianCalendar.YEAR, year - 1);
			setSdate(new java.sql.Date(cal.getTime().getTime()));
		}

		return new Object[] { new Integer(getMaincontract()), getOperator(), getResource(), isByDates, getSdate(), getEdate(), new Integer(2)};
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 15:09:10)
	 * @return int
	 */
	public int getJournalcode() {
		return journalcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 15:13:37)
	 * @return int
	 */
	public int getMaincontract() {
		return maincontract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2004 15:24:05)
	 * @return java.lang.String
	 */
	public java.lang.String getManager() {
		return manager;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:11:19)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getOperator() {
		return operator;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 19:04:03)
	 * @return java.lang.String
	 */
	public java.lang.String getOrgname() {
		return orgname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.12.2002 15:16:48)
	 * @return java.util.Map
	 */
	public java.util.Map getParamsForReglament() {
		try {
			java.util.Hashtable hashtable = new java.util.Hashtable(2);
			hashtable.put("isLeaseContract", new Boolean(false));
			hashtable.put("leaseContract", new Integer(getMaincontract()));
			return hashtable;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new java.util.Hashtable(2);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 19:02:42)
	 * @return java.lang.String
	 */
	public java.lang.String getPosname() {
		return posname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.11.2003 16:56:59)
	 * @return java.lang.String
	 */
	public java.lang.String getResname() {
		return resname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:11:42)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getResource() {
		return resource;
	}
	public java.util.Enumeration getResources() {
		return resources;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:12:16)
	 * @return java.sql.Date
	 */
	public java.sql.Date getSdate() {
		return sdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.04.2004 14:05:47)
	 * @return java.lang.String
	 */
	public java.lang.String getSubject() {
		return subject;
	}
	/**
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getVendor() {
		return vendor;
	}
	public void initCollections() {
		/**		
		try {
			
			java.util.Vector v = new java.util.Vector();
			v.addElement(getContract());
		
			java.util.Enumeration e =
				new LeaseArendaAgreementNewAccessBean().findByQBE2(
					new Integer(getMaincontract()),
					new Boolean(false),
					null,
					new Boolean(false),
					null,
					new Integer(1));
			while (e.hasMoreElements()) {
				LeaseArendaAgreementNewAccessBean laanBean =
					(LeaseArendaAgreementNewAccessBean) e.nextElement();
				v.addElement(new Integer(laanBean.getLeaseDocument()));
			}
		
			java.util.Enumeration enr =
				new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
			ArrayList res = new ArrayList();
			boolean resInCollection = false;
			while (enr.hasMoreElements()) {
				ResourceAccessBean o = (ResourceAccessBean) enr.nextElement();
				res.add(o);
				if (o.getResource() == getResource().intValue())
					resInCollection = true;
			}
		
			// Selected resource not in current list - select first resource
			if (!resInCollection && res.size()!= 0) {
				ResourceAccessBean rbean = (ResourceAccessBean) res.get(0);
				setResource(new Integer(rbean.getResource()));
				setResname(rbean.getName());
			}
			if (res.size() == 0) {
				setResource(new Integer(0));
				setResname("");
			}
		
			// Check for more than 1 resource
			if (res.size() > 1)
				setManyresources(true);
			else
				setManyresources(false);
		
			resources = Collections.enumeration(res);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.04.2004 15:18:19)
	 * @return boolean
	 */
	public boolean isDirtyComment() {
		return dirtyComment;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.11.2003 16:55:47)
	 * @return boolean
	 */
	public boolean isManyresources() {
		return manyresources;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.12.2003 17:27:44)
	 * @param newCheckCode int
	 */
	public void setCheckCode(int newCheckCode) {
		checkCode = newCheckCode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.04.2004 14:05:26)
	 * @param newComment java.lang.String
	 */
	public void setComment(java.lang.String newComment) {
		comment = newComment;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:10:59)
	 * @param newContract java.lang.Integer
	 */
	public void setContract(java.lang.Integer newContract) {
		//теперь в этот метод передается код базового:
		/**
		contract = newContract;
		afterSetContract();
		*/
		maincontract = newContract.intValue();
		afterSetMainContract(newContract);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 19:03:37)
	 * @param newContrdate java.sql.Date
	 */
	public void setContrdate(java.sql.Date newContrdate) {
		contrdate = newContrdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 19:03:16)
	 * @param newContrnum java.lang.String
	 */
	public void setContrnum(java.lang.String newContrnum) {
		contrnum = newContrnum;
	}
	/**
	 * 
	 * @param newCustname java.lang.String
	 */
	public void setCustname(java.lang.String newCustname) {
		custname = newCustname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:13:04)
	 * @param newDateper java.lang.String
	 */
	public void setDateper(java.lang.String newDateper) {
		dateper = newDateper;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.04.2004 15:18:19)
	 * @param newDirtyComment boolean
	 */
	public void setDirtyComment(boolean newDirtyComment) {
		dirtyComment = newDirtyComment;
	}
	/**
	 * 
	 * @param newEconomist java.lang.String
	 */
	public void setEconomist(java.lang.String newEconomist) {
		economist = newEconomist;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:12:32)
	 * @param newEdate java.sql.Date
	 */
	public void setEdate(java.sql.Date newEdate) {
		edate = newEdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (11.11.2003 15:09:10)
	 * @param newJournalcode int
	 */
	public void setJournalcode(int newJournalcode) {
		journalcode = newJournalcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (06.11.2003 15:13:37)
	 * @param newMaincontract int
	 */
	public void setMaincontract(int newMaincontract) {
		maincontract = newMaincontract;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2004 15:24:05)
	 * @param newManager java.lang.String
	 */
	public void setManager(java.lang.String newManager) {
		manager = newManager;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.11.2003 16:55:47)
	 * @param newManyresources boolean
	 */
	public void setManyresources(boolean newManyresources) {
		manyresources = newManyresources;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:11:19)
	 * @param newOperator java.lang.Integer
	 */
	public void setOperator(java.lang.Integer newOperator) {
		operator = newOperator;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 19:04:03)
	 * @param newOrgname java.lang.String
	 */
	public void setOrgname(java.lang.String newOrgname) {
		orgname = newOrgname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 19:02:42)
	 * @param newPosname java.lang.String
	 */
	public void setPosname(java.lang.String newPosname) {
		posname = newPosname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.11.2003 16:56:59)
	 * @param newResname java.lang.String
	 */
	public void setResname(java.lang.String newResname) {
		resname = newResname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:11:42)
	 * @param newResource java.lang.Integer
	 */
	public void setResource(java.lang.Integer newResource) {
		resource = newResource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.11.2003 15:12:16)
	 * @param newSdate java.sql.Date
	 */
	public void setSdate(java.sql.Date newSdate) {
		sdate = newSdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.04.2004 14:05:47)
	 * @param newSubject java.lang.String
	 */
	public void setSubject(java.lang.String newSubject) {
		subject = newSubject;
	}

	/**
	 * 
	 * @param newVendor java.lang.String
	 */
	public void setVendor(java.lang.String newVendor) {
		vendor = newVendor;
	}

	/**
		 * Insert the method's description here.
		 * Creation date: (27.02.2004 18:27:09)
	*/
	private String getNameMainPosition(LeaseArendaAgreementNewAccessBean arendaBean) throws Exception {
		String name = "";
		PositionAccessBean bean = arendaBean.getMainposition();
		if (bean != null) {
			//name = com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(bean);
			name = CDBC_LeaseOnPosition_Object.getNamePosition(new Integer(bean.getStorageplace()));
		}
		return name;
	}

}
