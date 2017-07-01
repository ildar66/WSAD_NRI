package com.hps.july.inventory.service;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.inventory.formbean.MountActBean;
import com.hps.july.inventory.formbean.MountActDocPositionBean;
import com.hps.july.inventory.formbean.MountActDocPositionListBean;
import com.hps.july.inventory.service.dao.BCResourceCategoryDao;
import com.hps.july.inventory.service.dao.BCResourceCategoryDaoJdbc;
import com.hps.july.inventory.service.dao.BaseStationDao;
import com.hps.july.inventory.service.dao.BaseStationDaoJdbc;
import com.hps.july.inventory.service.dao.DocPositionsDao;
import com.hps.july.inventory.service.dao.DocPositionsDaoJdbc;
import com.hps.july.inventory.service.dao.ResourceDao;
import com.hps.july.inventory.service.dao.ResourceDaoJdbc;
import com.hps.july.inventory.sessionbean.DocumentProcessingException;
import com.hps.july.inventory.sessionbean.ProcessorFacadeAccessBean;
import com.hps.july.inventory.valueobject.Category;
import com.hps.july.inventory.valueobject.Resource;
import com.hps.july.inventory.valueobject.VisualCategory;
import com.hps.july.persistence.DocumentPosition;
import com.hps.july.persistence.DocumentPositionAccessBean;
import com.hps.july.persistence.EquipmentSet;
import com.hps.july.persistence.EquipmentSetAccessBean;
import com.hps.july.persistence.Expedition;
import com.hps.july.persistence.ExpeditionAccessBean;
import com.hps.july.persistence.IBPMountPosAccessBean;
import com.hps.july.persistence.InternalWayBillAccessBean;
import com.hps.july.persistence.InternalWayBillPositionAccessBean;
import com.hps.july.persistence.Organization;
import com.hps.july.persistence.OrganizationAccessBean;
import com.hps.july.persistence.OrganizationKey;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.persistence.Worker;
import com.hps.july.persistence.WorkerAccessBean;
import com.hps.july.utils.Logger;
import com.hps.july.utils.ejbtransaction.EJBTransactionTemplate;
import com.hps.july.web.util.FormatUtils;

/**
 * @author dimitry
 * Created 10.04.2006
 */
public class MountActServiceImpl implements MountActService {

	protected Logger logger = new Logger(this.getClass());
	
	private BCResourceCategoryDao categoryDao = new BCResourceCategoryDaoJdbc();
	private ResourceDao resourceDao = new ResourceDaoJdbc();
	private BaseStationDao baseStationDao = new BaseStationDaoJdbc();
	private DocPositionsDao docPositionsDao = new DocPositionsDaoJdbc();
	
	// transaction support
	private EJBTransactionTemplate transactionTemplate = new EJBTransactionTemplate();
	
	public List getCategoryList(Integer parentCategoryId) {
		List categoryList = categoryDao.getBCCategoryList(parentCategoryId);
		return categoryList; 
	}

	public Category getCategory(Integer categoryId) {
		return categoryDao.getBCCategory(categoryId);
	}
	
	
	public List prepareCategoryList(Integer parentCategoryId){
		List categories = getCategoryList(parentCategoryId);
		for (int i=0;i<categories.size(); i++) {
			Category category = (Category) categories.get(i);
			VisualCategory visualCategory = category.getVisualCategory();
			if (visualCategory != null){
				visualCategory.setResources(getResources(visualCategory.getId()));
			}

			category.setChildrens(prepareCategoryList(category.getId()));
		}
		
		return categories;
	}
	
	public List prepareRootCategoryList(){
		return prepareCategoryList(null);
	}
	
	public List getResources(Integer visualCategoryId) {
		return resourceDao.getResourcesByVisualCategory(visualCategoryId);
	}

	public Resource getResource(Integer resourceId) {
		return resourceDao.getResource(resourceId);
	}
	
	public List getBSResSetFromPosition(Integer positionId) {
		return baseStationDao.getBSResSetFromPosition(positionId);
	}

	public List getComplects(String positionNumber, String userName, Boolean isAdmin) {
		if (positionNumber == null || positionNumber.equals("")) return new ArrayList();
		return baseStationDao.findComplects(positionNumber, userName, isAdmin);
	}

	public Enumeration getOwnerList() {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		try {
			return bean.findOurOrganizations();
		} catch (Exception e) {
			logger.error(e,e);
			return new Vector().elements();
		}
	}
	
	
	
	public MountActBean loadMountActBean(Integer documentId) throws Exception {
		InternalWayBillAccessBean bean = new InternalWayBillAccessBean();
		bean.setInitKey_document(documentId.intValue());
		bean.refreshCopyHelper();
		
		MountActBean actBean = new MountActBean();
		actBean.setDocumentId(FormatUtils.toInteger(bean.getDocument()));
		actBean.setPosNumber(FormatUtils.toString(bean.getBlankindex()));
		actBean.setDate(FormatUtils.toString(bean.getBlankdate()));
		
		ExpeditionAccessBean expeditionBean = new ExpeditionAccessBean();
		expeditionBean.setInitKey_storageplace(bean.getFromKey().storageplace);
		expeditionBean.refreshCopyHelper();
		
		actBean.setProviderCode(FormatUtils.toString(expeditionBean.getOrganization().getOrganization()));
		actBean.setProviderName(expeditionBean.getOrganization().getName()); 
		
		actBean.setOwnerCode(FormatUtils.toInteger(bean.getOwnerKey().organization));
		actBean.setComplectCode(FormatUtils.toInteger(bean.getTo().getStorageplace()));
		actBean.setComplectName(bean.getTo().getName());
		
		actBean.setNeedApprove(bean.getNeedapprove());
		actBean.setProjectId(bean.getProjectid());
		actBean.setProjectName("");
		actBean.setFrequencyRange(bean.getEquiptype());
		
		actBean.setInsuranceMan(bean.getInsuranseMan());
		
		actBean.setWorkerCode(FormatUtils.toString(bean.getMonter().getWorker()));
		actBean.setWorkerName(bean.getMonter().getMan().getLastname() + " " +
				  bean.getMonter().getMan().getFirstname() + " " +
				  bean.getMonter().getMan().getMiddlename());

		actBean.setDocumentState(Integer.valueOf(bean.getDocumentState()));
		
//		TODO		
//		actBean.setDState(bean.getDocumentState());
//		setProcessState("");
		
		actBean.setVisualType(bean.getVisualtype());
		
		MountActDocPositionListBean docPositions = loadDocPositions(actBean.getDocumentId());
		actBean.setDocPositions(docPositions);
		
		return actBean;
	}
	
	protected MountActDocPositionListBean loadDocPositions(Integer documentId) {
		return loadDocPositions(documentId, null);
	}
	
	protected MountActDocPositionListBean loadDocPositions(Integer documentId, MountActDocPositionBean parentDocPositionBean) {
		List docPositionList = docPositionsDao.loadDocPositionList(documentId, parentDocPositionBean != null ? parentDocPositionBean.getId() : null);

		MountActDocPositionListBean listBean = new MountActDocPositionListBean(parentDocPositionBean);
		// prepare docPositions
		for (int i=0; i<docPositionList.size(); i++){
			MountActDocPositionBean bean = (MountActDocPositionBean) docPositionList.get(i);
			Resource resource = resourceDao.getResource(bean.getResourceId());
			bean.setResource(resource);
			
			bean.setWorksNumberExist(bean.getWorksNumber() == null);
			bean.setInventoryNumberExist(bean.getInventoryNumber() == null);
			bean.setSubdivisionInventoryNumberExist(bean.getSubdivisionInventoryNumber() == null);
			
			bean.setDocPositions(loadDocPositions(documentId, bean));
			listBean.add(bean);
		}
		
		return listBean;
	}

	/**
	 * Определим экспедицию
	 * @param providerCode
	 * @return
	 */
	public ExpeditionAccessBean getExpeditionByOrganization(Integer providerCode){
		ExpeditionAccessBean expeditionAccessBean = null;

		KeyGeneratorAccessBean keyGenerator = new KeyGeneratorAccessBean();
		try {
			Enumeration en = new ExpeditionAccessBean().findExpeditionByOrganization(
					new OrganizationKey(FormatUtils.toInt(providerCode)));
			
			if(en.hasMoreElements()) {
				expeditionAccessBean = (ExpeditionAccessBean)en.nextElement();
				expeditionAccessBean.refreshCopyHelper();
			
			} else {
				OrganizationAccessBean organizationAccessBean = new OrganizationAccessBean();
				organizationAccessBean.setInitKey_organization(FormatUtils.toInt(providerCode));
				organizationAccessBean.refreshCopyHelper();
				
				int expkey = keyGenerator.getNextKey("tables.storageplaces");
				expeditionAccessBean = new ExpeditionAccessBean(expkey, null, "", "");
				expeditionAccessBean.setOrganization((Organization)organizationAccessBean.getEJBRef());
				expeditionAccessBean.setExpeditor(null);
				expeditionAccessBean.setName(organizationAccessBean.getName());
				expeditionAccessBean.commitCopyHelper();
			}
			
		} catch (Exception ee) {
			ee.printStackTrace(System.out);
		}
		
		return expeditionAccessBean;
	}
	
	
	public void saveOrUpdateMountActBean(final MountActBean mountActBean) throws Exception{

//		transactionTemplate.execute(new TransactionCallbackWithoutResult(){
//			protected void doInTransactionWithoutResult() throws Exception {

				KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
				InternalWayBillAccessBean bean;

				ExpeditionAccessBean expeditionAccessBean = getExpeditionByOrganization(
						FormatUtils.toInteger(mountActBean.getProviderCode()));
				
				// insert
				if (mountActBean.getDocumentId() == null || mountActBean.getDocumentId().intValue() == 0){
					mountActBean.setDocumentId(FormatUtils.toInteger(keyGen.getNextKey("tables.documents")));
					
					Integer ownerId = mountActBean.getOwnerCode();

					// validate complect code
					EquipmentSetAccessBean eab = new EquipmentSetAccessBean();
					eab.setInitKey_storageplace(FormatUtils.toInt(mountActBean.getComplectCode()));
					eab.refreshCopyHelper(); 
										
					// Создадим шапку документа
					bean = new InternalWayBillAccessBean(
						mountActBean.getDocumentId().intValue(),
						ownerId,
						FormatUtils.toInteger(expeditionAccessBean.getStorageplace()), 
						mountActBean.getComplectCode(),
						FormatUtils.toSqlDate(mountActBean.getDate()),
						FormatUtils.toInt(mountActBean.getPosNumber()),
						// "",
					    mountActBean.getPosNumber(),
						"1",
						Boolean.TRUE,
						Boolean.TRUE,
						Boolean.FALSE
					);
					
				}
				
				// update
				else {
					bean = new InternalWayBillAccessBean();
					bean.setInitKey_document(FormatUtils.toInt(mountActBean.getDocumentId()));
					bean.refreshCopyHelper();

					// Определим экспедицию
					Expedition expedition = (Expedition)PortableRemoteObject.narrow(
							expeditionAccessBean.getEJBRef(), Expedition.class);
					bean.setFrom(expedition); 
					
					// complectCode
					EquipmentSetAccessBean eab = new EquipmentSetAccessBean();
					eab.setInitKey_storageplace(FormatUtils.toInt(mountActBean.getComplectCode()));
					eab.refreshCopyHelper(); 
					bean.setTo((EquipmentSet)eab.getEJBRef()); 
					
					// owner
					OrganizationAccessBean organizationAccessBean = new OrganizationAccessBean();
					organizationAccessBean.setInitKey_organization(FormatUtils.toInt(mountActBean.getOwnerCode()));
					organizationAccessBean.refreshCopyHelper();
					bean.setOwner((Organization)organizationAccessBean.getEJBRef());
					
					bean.setBlankdate(FormatUtils.toSqlDate(mountActBean.getDate()));
					bean.setBlankindex(FormatUtils.toInt(mountActBean.getPosNumber()));
					bean.setBlanknumber(mountActBean.getPosNumber());
					
					// FIXME move to sessionBean
					docPositionsDao.deleteDocPositions(mountActBean.getDocumentId());
				}
				
				// monter
				WorkerAccessBean workerAccessBean = new WorkerAccessBean();
				workerAccessBean.setInitKey_worker(FormatUtils.toInt(mountActBean.getWorkerCode()));
				workerAccessBean.refreshCopyHelper();
				bean.setMonter((Worker)workerAccessBean.getEJBRef());
				
				bean.setNeedapprove(mountActBean.isNeedApprove());
				bean.setProjectid(mountActBean.getProjectId());

				bean.setInsuranseMan(mountActBean.getInsuranceMan());
				System.out.println("save VisualType: " + mountActBean.getVisualType());
				bean.setVisualtype(mountActBean.getVisualType());
				bean.setEquiptype(mountActBean.getFrequencyRange());
				
				bean.commitCopyHelper();
				
				createPositions(mountActBean.getDocPositions(), mountActBean.getOwnerCode(), mountActBean.getDocumentId());
//			}});
	}
	
	public void createPositions(MountActDocPositionListBean docPositionListBean, Integer ownerId, Integer documentId) throws RemoteException, CreateException, NamingException, FinderException {
		if (docPositionListBean == null)
			throw new IllegalArgumentException("Attribute docPositionListBean must be define. ");
		
		for (int i=0; i<docPositionListBean.size(); i++){
			MountActDocPositionBean bean = docPositionListBean.get(i);
			createPosition(bean, ownerId, documentId);
			
			createPositions(bean.getDocPositions(), ownerId, documentId);
		}
	}

	
	public void createPosition(MountActDocPositionBean docPosition, Integer ownerId, Integer documentId) throws RemoteException, CreateException, NamingException, FinderException {
		if (docPosition == null)
			throw new IllegalArgumentException("Attribute docPosition must be define");
		
		if (docPosition.getResourceId() == null)
			throw new IllegalArgumentException("Attribute docPosition.resourceId must be define");
		
		KeyGeneratorAccessBean keyGen = new com.hps.july.commonbean.KeyGeneratorAccessBean();
		docPosition.setId(new Integer(keyGen.getNextKey("tables.docpositions")));

		// FIXME move to sessionBean ?
		Category resourceCategory = getCategory(docPosition.getCategoryId());
		if (resourceCategory != null && resourceCategory.isIBPType())
			createIBPMountDocPosition(docPosition, ownerId, documentId);
		
		else createMountDocPosition(docPosition, ownerId, documentId);
	}

	
	private void createMountDocPosition(MountActDocPositionBean docPosition, Integer ownerId, Integer documentId) throws CreateException, NamingException, RemoteException, FinderException {
		
		InternalWayBillPositionAccessBean bean = new InternalWayBillPositionAccessBean(
				docPosition.getId().intValue(),
				docPosition.getResourceId(),
				ownerId,
				documentId,
				docPosition.getIndex(),
				new BigDecimal(1),
				new java.math.BigDecimal(0),   // Price
				Boolean.FALSE, Boolean.FALSE, // Boxed
				Boolean.FALSE, Boolean.FALSE, // Broken
				Boolean.FALSE, Boolean.FALSE // Closed
			);
		
		ResourceAccessBean resource = loadResourceBean(docPosition.getResourceId());
		String countpolicy = resource.getCountpolicy();
		
		if (Resource.SERIAL_STOCK_TAKING_TYPE.equals(countpolicy)){
			// Заводской номер
			if (docPosition.getWorksNumber() != null)
				bean.setSerialnumber(docPosition.getWorksNumber());
			// Инвентарный номер
			if (docPosition.getInventoryNumber() != null)
				bean.setManufserial(docPosition.getInventoryNumber());
			// Инвентарный номер подразделения
			if (docPosition.getSubdivisionInventoryNumber() != null)
				bean.setLocalserial(docPosition.getSubdivisionInventoryNumber());
			
		} else if (Resource.QUANTITY_STOCK_TAKING_TYPE.equals(countpolicy)) {
			bean.setQty(FormatUtils.toBigDecimal(docPosition.getQuantity().toString()));
		}

		// TODO партионный учет?
		bean.setNewplace("-");
//		bean.setComment(argComment);
		bean.setVisualtagid(docPosition.getCategoryId());
		
		if (docPosition.getParent() != null && docPosition.getParent().getId() != null
				&& docPosition.getParent().getId().intValue() != 0) {
			DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
			dp.setInitKey_docposition(docPosition.getParent().getId().intValue());

			dp.refreshCopyHelper();
			
			bean.setAgregate((DocumentPosition)dp.getEJBRef());
			bean.setAgregateSerial(docPosition.getParent().getWorksNumber());
			bean.setAgregateresource(new Integer(dp.getResourceKey().resource));
			bean.setParentbtsdocpos(docPosition.getParent().getId());
		}

		bean.commitCopyHelper();
	}

	private void createIBPMountDocPosition(MountActDocPositionBean docPosition, Integer ownerId, Integer documentId) throws RemoteException, CreateException, NamingException, FinderException {
		IBPMountPosAccessBean bean = new IBPMountPosAccessBean(
				docPosition.getId().intValue(),
				docPosition.getResourceId(),
				ownerId,
				documentId,
				docPosition.getIndex(),
				new BigDecimal(1),
				new java.math.BigDecimal(0),   // Price
				Boolean.FALSE, Boolean.FALSE, // Boxed
				Boolean.FALSE, Boolean.FALSE, // Broken
				Boolean.FALSE, Boolean.FALSE // Closed
			);

		ResourceAccessBean resource = loadResourceBean(docPosition.getResourceId());
		if (Resource.SERIAL_STOCK_TAKING_TYPE.equals(resource.getCountpolicy())){
			// Заводской номер
			if (docPosition.getWorksNumber() != null)
				bean.setSerialnumber(docPosition.getWorksNumber());
			// Инвентарный номер
			if (docPosition.getInventoryNumber() != null)
				bean.setManufserial(docPosition.getInventoryNumber());
			// Инвентарный номер подразделения
			if (docPosition.getSubdivisionInventoryNumber() != null)
				bean.setLocalserial(docPosition.getSubdivisionInventoryNumber());
			
		} else if (Resource.QUANTITY_STOCK_TAKING_TYPE.equals(resource.getCountpolicy())) {
			bean.setQty(FormatUtils.toBigDecimal(docPosition.getQuantity().toString()));
		}

		// TODO партионный учет?
			
		bean.setNewplace("-");
//		bean.setComment("");
		// TODO verify to save of categoryId
		bean.setVisualtagid(docPosition.getCategoryId());
		
		if (docPosition.getParent() != null && docPosition.getParent().getId() != null
				&& docPosition.getParent().getId().intValue() != 0) {
			DocumentPositionAccessBean dp = new DocumentPositionAccessBean();
			dp.setInitKey_docposition(docPosition.getParent().getId().intValue());

			dp.refreshCopyHelper();
			
			bean.setAgregate((DocumentPosition)dp.getEJBRef());
			bean.setAgregateSerial(docPosition.getParent().getWorksNumber());
			bean.setAgregateresource(new Integer(dp.getResourceKey().resource));
			bean.setParentbtsdocpos(docPosition.getParent().getId());
		}
		
		bean.commitCopyHelper();
	}

	protected ResourceAccessBean loadResourceBean(Integer resourceId){
		if (resourceId == null) return null;
		try {
			// Получение ресурса
			ResourceAccessBean resource = new ResourceAccessBean();
			resource.setInitKey_resource(resourceId.intValue());
			resource.refreshCopyHelper();
			return resource;
		} catch (Exception e){
			e.printStackTrace(System.out);
			return null;
		}		
	}

	/**
	 * Обсчет документа
	 */
	public void startDocumentCounting(Integer documentId, boolean isAutoCorrection) throws RemoteException, DocumentProcessingException, CreateException, NamingException {
		ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
		processor.processDocument(documentId,false,isAutoCorrection);
	}
	
	/**
	 * Снятие обсчета с документа
	 */
	public void cancelDocumentCounting(Integer documentId) throws RemoteException, DocumentProcessingException, CreateException, NamingException{
		ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();
		processor.cancelDocument(documentId);
	}
	
	
}
