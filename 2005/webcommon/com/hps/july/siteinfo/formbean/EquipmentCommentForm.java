package com.hps.july.siteinfo.formbean;

import com.hps.july.siteinfo.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма редактирования комментария к оборудованию.
 * Creation date: (13.10.2004 14:41:56)
 * @author: Dmitry Dneprov
 */
public class EquipmentCommentForm extends com.hps.july.web.util.EditForm {
	private int storagecard;
	private java.lang.String comment;
/**
 * Текущее приложение.
 * Creation date: (13.10.2004 14:41:56)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2004 14:54:48)
 * @return java.lang.String
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * Метод для поиска текущей записи.
 * Creation date: (13.02.2002 10:12:41)
 */
public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	com.hps.july.persistence.StorageCardAccessBean bean = new com.hps.july.persistence.StorageCardAccessBean();
	bean.setInitKey_storagecard(getStoragecard()) ;
	return bean;
}
/**
 * Текущее состояние приложения.
 * Creation date: (13.10.2004 14:41:56)
 * @return int
 */
public int getState() {
	return APPStates.EDITCOMMENT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2004 14:54:37)
 * @return int
 */
public int getStoragecard() {
	return storagecard;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2004 14:54:48)
 * @param newComment java.lang.String
 */
public void setComment(java.lang.String newComment) {
	comment = newComment;
}
/**
 * Insert the method's description here.
 * Creation date: (13.10.2004 14:54:37)
 * @param newStoragecard int
 */
public void setStoragecard(int newStoragecard) {
	storagecard = newStoragecard;
}
}
