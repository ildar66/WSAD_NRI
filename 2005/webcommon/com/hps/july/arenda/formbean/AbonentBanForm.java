package com.hps.july.arenda.formbean;

import java.util.*;
import java.sql.Date;
import javax.servlet.http.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.cdbc.objects.CDBC_OwnerContract2FilialNri_Object;
import com.hps.july.commonbean.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import com.hps.july.util.*;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.Currency;
/**
 * "Абонентские договора" Form-Bean.
 * Creation date: (03.07.2004 19:46:10)
 * @author: Shafigullin Ildar
 */
public class AbonentBanForm extends EditForm {
	private int leaseDocument;
	private LeaseAbonentBAN_VO abonent;
	//для контроля за ведением договора:
	private PeopleVO operatorVO;
	//Список исполнителей:
	private List customers;
	/**
	 */	
	public AbonentBanForm() {
		init();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:21:31)
	 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 */
	public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("abonentBanLeaseDocument", new Object[] { new Boolean(true), new Integer(getLeaseDocument())});
	}
	public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request) throws Exception {

		LeaseAbonentBANAccessBean leaseban = (LeaseAbonentBANAccessBean) bean;
		leaseban.setDocumentNumber("" + abonent.getBan());
		leaseban.setBan(abonent.getBan());
		leaseban.setUseallben(abonent.getUseallben());
		leaseban.setFlagworkpie(abonent.getFlagworkpie());
		leaseban.setUseinacts(abonent.getUseinacts());
		leaseban.setTechcontract(abonent.getTechcontract());
		leaseban.setDocumentDate(abonent.getDocdate());
		//создаем тип обработки:
		if (abonent.getUseinacts())
			leaseban.setProctype(null);
		else
			leaseban.setProctype(abonent.getProctype());

		//создаем Организация заказчик:
		if (abonent.getOrgCustomer().getOrganization() != null) {
			int key = abonent.getOrgCustomer().getOrganization().intValue();
			try {
				leaseban.setOrgCustomer(getOrganization(key));
				leaseban.setCustname(abonent.getOrgCustomer().getName());
			} catch (Exception e) {
				throw new UpdateValidationException("error.abonentban.save.orgcustomer");
			}

		}
		//создаем Организация исполнитель:
		if (abonent.getOrgExecutor().getOrganization() != null) {
			int key = abonent.getOrgExecutor().getOrganization().intValue();
			try {
				leaseban.setOrgExecutor(getOrganization(key));
			} catch (Exception e) {
				throw new UpdateValidationException("error.abonentban.save.orgcustomer");
			}

		}

		//создаем Главную позицию:
		int storageplace = abonent.getMainpositionVO().getStorageplace();
		if (storageplace != 0) {
			leaseban.setMainposition(new Integer(storageplace));
		} else {
			leaseban.setMainposition(null);
		}

		//создаем Ответственный экономист:
		if (abonent.getEconomistVO().getWorker() != null) {
			int key = abonent.getEconomistVO().getWorker().intValue();
			try {
				leaseban.setEconomist(getWorker(key));
			} catch (Exception e) {
				//throw new UpdateValidationException("error.abonentban.save.economist");
			}
		} else {
			try {
				leaseban.setEconomist(null);
			} catch (Exception e) {
				//throw new UpdateValidationException("error.abonentban.save.manager");
			}
		}
		//создаем Ответственный менеджера:
		if (abonent.getManagerVO().getWorker() != null) {
			int key = abonent.getManagerVO().getWorker().intValue();
			try {
				leaseban.setManager(getWorker(key));
			} catch (Exception e) {
				//throw new UpdateValidationException("error.abonentban.save.manager");
			}
		} else {
			try {
				leaseban.setManager(null);
			} catch (Exception e) {
				//throw new UpdateValidationException("error.abonentban.save.manager");
			}
		}
		//контроль доступа:
		if (getOperatorVO() != null) {
			leaseban.setModifiedby(getOperatorVO().getMan());
			leaseban.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		}
	}
	public AbstractEntityAccessBean constructBean(HttpServletRequest request) throws Exception {
		setLeaseDocument(new KeyGeneratorAccessBean().getNextKey("tables.leasedocuments"));
		Date currentDate = new Date(System.currentTimeMillis());
			LeaseAbonentBANAccessBean bean = new LeaseAbonentBANAccessBean(getLeaseDocument(), currentDate, // docdate
		"" + abonent.getBan(), "C", // contracttype
		"A", // contractstate
		abonent.getOrgCustomer().getOrganization(), abonent.getOrgExecutor().getOrganization(), currentDate, // startdate
		currentDate, // enddate
	"N", "M", abonent.getOrgCustomer().getName(), abonent.getOrgExecutor().getName(), abonent.getBan(), abonent.getFlagworkpie());

		//устанавливаем остальные поля:
		bean.setUseallben(abonent.getUseallben());
		bean.setUseinacts(abonent.getUseinacts());
		bean.setTechcontract(abonent.getTechcontract());
		//"ChargeNds" устанавливаем всегда в false:
		bean.setChargeNds(false);
		//создаем тип обработки:
		if (abonent.getUseinacts())
			bean.setProctype(null);
		else
			bean.setProctype(abonent.getProctype());

		//создаем Главную позицию:
		int storageplace = abonent.getMainpositionVO().getStorageplace();
		if (storageplace != 0) {
			bean.setMainposition(new Integer(storageplace));
		}

		//создаем Ответственный экономист:
		if (abonent.getEconomistVO().getWorker() != null) {
			int key = abonent.getEconomistVO().getWorker().intValue();
			try {
				bean.setEconomist(getWorker(key));
			} catch (Exception e) {
				//throw new UpdateValidationException("error.abonentban.save.economist");
			}

		}

		//создаем Ответственный менеджера:
		if (abonent.getManagerVO().getWorker() != null) {
			int key = abonent.getManagerVO().getWorker().intValue();
			try {
				bean.setManager(getWorker(key));
			} catch (Exception e) {
				//throw new UpdateValidationException("error.abonentban.save.manager");
			}
		}
		//устанавливаем основную валюту:
		NamedValueAccessBean nvBean = new NamedValueAccessBean();
		nvBean.setInitKey_id("USD");
		nvBean.refreshCopyHelper();
		CurrencyAccessBean cBean = new CurrencyAccessBean();
		cBean.setInitKey_currency(nvBean.getIntvalue());
		cBean.refreshCopyHelper();
		bean.setCurrency1((Currency) cBean.getEJBRef());
		//для разделения по филиалам:
		Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
		bean.setRegionid(profile.getProfileAccess().getCurrRegion().getVo().getRegionid().intValue());
		//контроль доступа:
		if (getOperatorVO() != null) {
			bean.setCreatedby(getOperatorVO().getMan());
			bean.setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
			bean.setModifiedby(getOperatorVO().getMan());
			bean.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		}
		return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.07.2004 16:09:24)
	 * @return com.hps.july.arenda.valueobject.LeaseAbonentBAN_VO
	 */
	public LeaseAbonentBAN_VO getAbonent() {
		return abonent;
	}
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}
	public AbstractEntityAccessBean getDataBean(HttpServletRequest request) {
		LeaseAbonentBANAccessBean bean = new LeaseAbonentBANAccessBean();
		bean.setInitKey_leaseDocument(leaseDocument);

		return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.07.2004 13:02:52)
	 * @return java.util.ArrayList
	 */
	public ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		//roles.add("ArendaMainEconomist");
		//roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}
	/**
	 * 
	 * @return int
	 */
	public int getLeaseDocument() {
		return leaseDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.12.2005 13:00:19)
	 * @return com.hps.july.arenda.valueobject.PeopleVO
	 */
	private com.hps.july.arenda.valueobject.PeopleVO getOperatorVO() {
		return operatorVO;
	}
	private OrganizationNfs getOrganization(int key) throws java.lang.Exception {
		OrganizationNfsAccessBean customer = new OrganizationNfsAccessBean();
		customer.setInitKey_organization(key);
		customer.refreshCopyHelper();

		return (OrganizationNfs) customer.getEJBRef();
	}
	public int getState() {
		return com.hps.july.arenda.APPStates.ABONENTBAN_EDIT;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2004 15:46:54)
	 * @return com.hps.july.persistence.WorkerAccessBean
	 * @exception java.lang.Exception The exception description.
	 */
	private Worker getWorker(int key) throws java.lang.Exception {
		WorkerAccessBean economist = new WorkerAccessBean();
		economist.setInitKey_worker(key);
		economist.refreshCopyHelper();

		return (Worker) economist.getEJBRef();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (15.07.2004 17:29:07)
	 */
	private void init() {
		abonent = new LeaseAbonentBAN_VO();
		abonent.setOrgCustomer(new OrganizationVO());
		abonent.setOrgExecutor(new OrganizationVO());
		abonent.setMainpositionVO(new StoragePlaceVO());
		abonent.setManagerVO(new WorkerVO());
		abonent.setEconomistVO(new WorkerVO());
	}
	/**
	 * Инициализация коллекций перед отображением пользователю.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception { //для контроля доступа:
		if (operatorVO == null) {
			operatorVO = com.hps.july.arenda.cdbcobjects.CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser());
		}
		//Список исполнителей:
		initCustomers(request);		
	}
	public void initRecord(HttpServletRequest request) throws Exception {
		init();
		//init orgExecutor:
		NamedValueAccessBean nv = new NamedValueAccessBean();
		nv.setInitKey_id("Vimpelcom");
		nv.refreshCopyHelper();
		//OrganizationNfs org = getOrganization(nv.getIntvalue());
		OrganizationNfsAccessBean org = new OrganizationNfsAccessBean();
		org.setInitKey_organization(nv.getIntvalue());
		org.refreshCopyHelper();
		OrganizationVO orgExecutor = new OrganizationVO(new Integer(org.getOrganization()));
		orgExecutor.setName(org.getName());
		abonent.setOrgExecutor(orgExecutor);
		//init:
		abonent.setUseallben(true);
		abonent.setFlagworkpie(true);
	}
	/**
	 * Метод загрузки данных в форму
	 * Creation date: (13.02.2002 10:12:41)
	 */
	public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		LeaseAbonentBANAccessBean leaseban = new LeaseAbonentBANAccessBean();
		leaseban.setInitKey_leaseDocument(leaseDocument);
		BeanUtils.copyProperties(this.getAbonent(), leaseban);
		//не совпадающие имена:
		this.getAbonent().setDocdate(leaseban.getDocumentDate());
		//OrgCustomer:
		if (leaseban.getOrgCustomer() != null) {
			int key = leaseban.getOrgCustomer().getOrganization();
			OrganizationVO orgCustomer = new OrganizationVO(new Integer(key));
			orgCustomer.setName(leaseban.getOrgCustomer().getName());
			abonent.setOrgCustomer(orgCustomer);
		} else
			abonent.setOrgCustomer(new OrganizationVO());
		//OrgExecutor:	
		if (leaseban.getOrgExecutor() != null) {
			int key = leaseban.getOrgExecutor().getOrganization();
			OrganizationVO orgExecutor = new OrganizationVO(new Integer(key));
			orgExecutor.setName(leaseban.getOrgExecutor().getName());
			abonent.setOrgExecutor(orgExecutor);
		} else
			abonent.setOrgExecutor(new OrganizationVO());
		//Mainposition:
		if (leaseban.getMainposition() != null) {
			int key = leaseban.getMainposition().intValue();
			PositionAccessBean mainPosAB = new PositionAccessBean();
			mainPosAB.setInitKey_storageplace(key);
			mainPosAB.refreshCopyHelper();
			StoragePlaceVO mainPosVO = new StoragePlaceVO(key);
			mainPosVO.setName(mainPosAB.getName());
			abonent.setMainpositionVO(mainPosVO);
		} else
			abonent.setMainpositionVO(new StoragePlaceVO());
		//Economist:
		if (leaseban.getEconomist() != null) {
			int key = leaseban.getEconomist().getWorker();
			WorkerVO economist = new WorkerVO(new Integer(key));
			economist.setName(leaseban.getEconomist().getMan().getFullName());
			abonent.setEconomistVO(economist);
		} else {
			abonent.setEconomistVO(new WorkerVO());
		}
		//Manager:
		if (leaseban.getManager() != null) {
			int key = leaseban.getManager().getWorker();
			WorkerVO manager = new WorkerVO(new Integer(key));
			manager.setName(leaseban.getManager().getMan().getFullName());
			abonent.setManagerVO(manager);
		} else {
			abonent.setManagerVO(new WorkerVO());
		}
	}
	/**
	 * Этот метод вызывается в режиме удаления записи.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		try {
			AbstractEntityAccessBean bean = getDataBean(request);
			bean.refreshCopyHelper();
			beforeDelete(bean, request);
			bean.getEJBRef().remove();
			afterDelete(request);
			return null;
		} catch (Exception e) {
			loadRecord(request);
			throw e;
		}
	}
	/**
	 * Этот метод вызывается в режиме добавления записи.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		AbstractEntityAccessBean bean = null;
		bean = constructBean(request);
		bean.commitCopyHelper();
		afterUpdate(bean, request);
		return null;
	}
	/**
	 * Этот метод вызывается в режиме изменения записи.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		AbstractEntityAccessBean bean = getDataBean(request);
		beforeUpdate(bean, request);
		bean.commitCopyHelper();
		afterUpdate(bean, request);
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.07.2004 16:09:24)
	 * @param newAbonent com.hps.july.arenda.valueobject.LeaseAbonentBAN_VO
	 */
	public void setAbonent(LeaseAbonentBAN_VO newAbonent) {
		abonent = newAbonent;
	}
	/**
	 * 
	 * @param newLeaseDocument int
	 */
	public void setLeaseDocument(int newLeaseDocument) {
		leaseDocument = newLeaseDocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.12.2005 13:00:19)
	 * @param newOperatorVO com.hps.july.arenda.valueobject.PeopleVO
	 */
	private void setOperatorVO(com.hps.july.arenda.valueobject.PeopleVO newOperatorVO) {
		operatorVO = newOperatorVO;
	}
	private void validateIndexInTable(ActionErrors errors) throws Exception {
		try {
			Integer banKey = new Integer(abonent.getBan());
			LeaseAbonentBANAccessBean ab = new LeaseAbonentBANAccessBean();
			Enumeration enum = ab.findByBAN(banKey);
			while (enum.hasMoreElements()) {
				LeaseAbonentBANAccessBean temp = (LeaseAbonentBANAccessBean) enum.nextElement();
				if (temp.getLeaseDocument() != getLeaseDocument()) {
					boolean beanFlagworkpie = temp.getFlagworkpie();
					if (beanFlagworkpie == abonent.getFlagworkpie()) {
						if (beanFlagworkpie) {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.validateIndexInTable", banKey, ""));
							break;
						} else {
							errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.validateIndexInTable", banKey, getServlet().getResources().getMessage("error.no") + " "));
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error in AbonentBanForm.validateIndexInTable(ActionErrors errors)");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	public void validateValues(ActionErrors errors) throws Exception {

		if (abonent.getBan() == 0) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonentban.ban.empty"));
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonentban.ban.invalid"));
		}

		if (abonent.getOrgCustomer().getOrganization() == null) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonentban.orgcustomer.empty"));
		}

		if (!abonent.getUseinacts() && abonent.getProctype().equals("")) {
			//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.abonentban.proctype.empty"));
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Выберите 'тип обработки'"));
		}

		validateIndexInTable(errors);

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.07.2002 13:06:43)
	 * @return java.util.Enumeration

	public java.util.Enumeration getCustomers() {
		try {
			Enumeration e = new OrganizationAccessBean().findOurOrganizations();
			if (getAction().equals("Add")) {
				CustomerValueObject valueObject = new CustomerValueObject();
				valueObject.setOrganization(null);
				valueObject.setName("");

				Vector v = new Vector();
				v.add(0, valueObject);

				while (e.hasMoreElements()) {
					OrganizationAccessBean bean = (OrganizationAccessBean) e.nextElement();
					CustomerValueObject valueObjectLocal = new CustomerValueObject();
					valueObjectLocal.setOrganization(new Integer(bean.getOrganization()));
					valueObjectLocal.setName(bean.getName());
					v.addElement(valueObjectLocal);
				}

				return v.elements();
			} else {
				return e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new java.util.Vector().elements();
		}
	}
	*/	
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 16:26:21)
	 */
	public String getDocdateStr() {
		if (abonent != null && abonent.getDocdate() != null) {
			StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
			sd.setSqlDate(abonent.getDocdate());
			return sd.getString();
		}
		return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 16:29:10)
	 */
	public void setDocdateStr(String newDocdateStr) {
		StringAndSqlDateProperty sd = new StringAndSqlDateProperty();
		sd.setString(newDocdateStr);
		abonent.setDocdate(sd.getSqlDate());
	}
	/**
	 * @return
	 */
	public List getCustomers() {
		return customers;
	}

	/**
	 * @param list
	 */
	private void setCustomers(List list) {
		customers = list;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.11.2005 17:21:24)
	 */
	private void initCustomers(HttpServletRequest request) {
		Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
		if (profile.getProfileAccess().getCurrRegion() != null) {
			Integer regionID = profile.getProfileAccess().getCurrRegion().getVo().getRegionid();
			//List custList = CDBC_OrganizationObject.findOurOrganizations(regionID, "nameOrg");
			List custList = CDBC_OwnerContract2FilialNri_Object.getList(regionID, "name");
			setCustomers(custList);
		} else {
			//throw new RuntimeException("нет текущего региона для аренды!!!");
			System.out.println("нет текущего региона для аренды!!!");
		}
	}	

}
