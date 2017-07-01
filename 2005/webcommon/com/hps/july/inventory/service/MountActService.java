package com.hps.july.inventory.service;

import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import com.hps.july.inventory.formbean.MountActBean;
import com.hps.july.inventory.sessionbean.DocumentProcessingException;
import com.hps.july.inventory.valueobject.Resource;

/**
 * @author dimitry
 * Created 10.04.2006
 */
public interface MountActService {

	List getCategoryList(Integer parentCategoryId);

	Resource getResource(Integer resourceId);

	List prepareCategoryList(Integer parentCategoryId);
	List prepareRootCategoryList();
	
	List getBSResSetFromPosition(Integer positionId);
	
	List getComplects(String positionNumber, String userName, Boolean isAdmin);

	Enumeration getOwnerList();
	
	/**
	 * Загрузка документа 
	 * @throws Exception 
	 */
	MountActBean loadMountActBean(Integer documentId) throws Exception;
	
	/**
	 * Сохранение или обновление документа 
	 * @param mountActBean
	 * @throws Exception 
	 */
	void saveOrUpdateMountActBean(MountActBean mountActBean) throws Exception;

	/**
	 * Обсчет документа
	 */
	void startDocumentCounting(Integer documentId, boolean isAutoCorrection) throws RemoteException, DocumentProcessingException, CreateException, NamingException;
	
	/**
	 * Снятие обсчета с документа
	 */
	void cancelDocumentCounting(Integer documentId) throws RemoteException, DocumentProcessingException, CreateException, NamingException;
	
}