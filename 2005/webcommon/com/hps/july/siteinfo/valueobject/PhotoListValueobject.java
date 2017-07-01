package com.hps.july.siteinfo.valueobject;

import com.hps.july.persistence.*;
import javax.ejb.*;

/**
 * Класс-контейнер с информацией о фотографии
 * Используется в списке фотографий
 * @author: Maksim Gerasimov
 */
public class PhotoListValueobject {
	private PhotoAccessBean bean = null;
	private PhotoBlobAccessBean blob = null;
/**
 * PhotoList constructor comment.
 */
public PhotoListValueobject(PhotoAccessBean argPhotoAccessBean) {
	
	bean = argPhotoAccessBean;
	//System.out.println("PhotoAccessBean="+bean);
	try{
		if(bean != null){
			blob = new PhotoBlobAccessBean();
			blob.setInitKey_photo(bean.getPhoto());
			blob.refreshCopyHelper();
		}
		//System.out.println("PhotoBlobAccessBean="+blob);
	}catch(Exception e){
		System.out.println("PhotoListValueobject error");
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 16:21:49)
 * @return com.hps.july.persistence.PhotoAccessBean
 */
public com.hps.july.persistence.PhotoAccessBean getBean() {
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 16:21:49)
 * @return com.hps.july.persistence.PhotoBlobAccessBean
 */
public com.hps.july.persistence.PhotoBlobAccessBean getBlob() {
	return blob;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 16:21:49)
 * @param newBean com.hps.july.persistence.PhotoAccessBean
 */
public void setBean(com.hps.july.persistence.PhotoAccessBean newBean) {
	bean = newBean;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 16:21:49)
 * @param newBlob com.hps.july.persistence.PhotoBlobAccessBean
 */
public void setBlob(com.hps.july.persistence.PhotoBlobAccessBean newBlob) {
	blob = newBlob;
}
}
