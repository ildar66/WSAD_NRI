package com.hps.july.siteinfo.formbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.jdbcpersistence.lib.*;
import java.sql.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.web.util.StringAndIntegerProperty;
import com.hps.july.cdbc.objects.CDBCPhotosObject;

/**
 * Форма редактирования данных о фотографии
 */
public class PhotoForm extends com.hps.july.web.util.EditForm {
	
	private com.hps.july.web.util.StringAndSqlDateProperty date;
	private java.lang.String description;
	private java.lang.String filename;
	private int photo;
	private java.lang.Integer poscode;
	private java.lang.String posname;
	public com.hps.july.persistence.PositionAccessBean positions;
	private org.apache.struts.upload.FormFile imageFrm;
	private byte[] image;
	private java.lang.String posid;
	private com.hps.july.web.util.StringAndIntegerProperty photographerId;
	private java.lang.String photographerName;
	private String javaVer;
	private java.lang.String externalPhotographer = null;
	private java.lang.String mimeType;

	private CDBCResultSet groupNames = new CDBCResultSet();
	private java.lang.String groupName = null;
	private java.lang.String groupName1 = null;
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:28:38)
 */
public PhotoForm() {
	photo = 0;
	poscode = new Integer(0);
	date = new com.hps.july.web.util.StringAndSqlDateProperty();
	photographerId = new com.hps.july.web.util.StringAndIntegerProperty();
	filename = "";
	posname = "";
	description = "";
	photographerName = "";
	javaVer="1.1.7";
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {
/*
	if ( (getImageFrm().getFileName() != null) && (getImageFrm().getFileName().length() > 0) ) {		
		//PhotoAccessBean abean = (PhotoAccessBean)bean;
		PhotoBlobAccessBean abean = new PhotoBlobAccessBean();
		abean.setInitKey_photo(getPhoto());
		abean.refreshCopyHelper();
		abean.setFilename( getImageFrm().getFileName() );
		abean.setImage( getImageFrm().getFileData() );
		abean.commitCopyHelper();
	}
*/	
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	PhotoListForm aform = (PhotoListForm)request.getSession().getAttribute( "PhotoListForm" );
	setPoscode(new Integer(aform.getStorageplace()));
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setPhoto(keyGen.getNextKey("tables.photos"));
    PhotoAccessBean bean = new PhotoAccessBean(getPhoto(), getPoscode(), getDescription(), getDate());
    
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public PositionAccessBean constructPositions() throws Exception {

	if (positions == null) {	
		// Construct workers bean
		if (poscode != null) {
			positions = new PositionAccessBean();
			positions.setInitKey_storageplace(poscode.intValue());
			positions.refreshCopyHelper();
		}
	}
	return positions;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	PhotoAccessBean bean = new PhotoAccessBean();
	bean.setInitKey_photo( getPhoto() );
	try {
		PhotoBlobAccessBean photoBlob = new PhotoBlobAccessBean();
		photoBlob.setInitKey_photo(getPhoto());
		photoBlob.refreshCopyHelper();
		setImage(photoBlob.getImage());
		setFilename(photoBlob.getFilename());
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:14:32)
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:15:11)
 * @return java.lang.String
 */
public java.lang.String getDateFrm() {
	return date.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:15:32)
 * @return java.lang.String
 */
public java.lang.String getDescription() {
	return description;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 18:21:15)
 * @return java.lang.String
 */
public java.lang.String getExternalPhotographer() {
	return externalPhotographer;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:15:55)
 * @return java.lang.String
 */
public java.lang.String getFilename() {
	return filename;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 10:59:00)
 * @return java.lang.String
 */
public java.lang.String getGroupName() {
	return groupName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 11:17:23)
 * @return java.lang.String
 */
public java.lang.String getGroupName1() {
	return groupName1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 10:58:06)
 * @return com.hps.july.cdbc.lib.CDBCResultSet
 */
public com.hps.july.cdbc.lib.CDBCResultSet getGroupNames() {
	return groupNames;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 11:36:57)
 * @return byte[]
 */
public byte[] getImage() {
	return image;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 11:35:37)
 * @return org.apache.struts.upload.FormFile
 */
public org.apache.struts.upload.FormFile getImageFrm() {
	return imageFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2003 15:24:29)
 * @return java.lang.String
 */
public java.lang.String getJavaVer() {
	return javaVer;
}
/**
 * Insert the method's description here.
 * Creation date: (16.03.2005 11:05:56)
 * @return java.lang.String
 */
public java.lang.String getMimeType() {
	return mimeType;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:16:18)
 * @return int
 */
public int getPhoto() {
	return photo;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2002 20:01:58)
 * @return java.lang.Integer
 */
public Worker getPhotographer() {

    if (!photographerId.isEmpty() && photographerId.isOk()) {
        try {
            WorkerAccessBean ab = new WorkerAccessBean();
            ab.setInitKey_worker(photographerId.getInteger().intValue());
            ab.refreshCopyHelper();
            return (Worker) ab.getEJBRef();
        } catch (Exception ex) {
            return null;
        }
    } else
        return null;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2002 20:03:45)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getPhotographerId() {
	return photographerId.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 10:01:44)
 * @return java.lang.String
 */
public java.lang.String getPhotographerName() {
	return photographerName;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:26)
 * @return java.lang.Integer
 */
public java.lang.Integer getPoscode() {
	return poscode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:12:13)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Position getPosition() throws Exception {

	PositionAccessBean bean = constructPositions();
	if (bean != null)
	  return (Position)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:46)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.EDITPHT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	PhotoListForm aform = (PhotoListForm)request.getSession().getAttribute( "PhotoListForm" );
	setPoscode(new Integer(aform.getStorageplace()));
	setPosid(aform.getPosid());
	setPosname(aform.getPosname());
	this.groupNames = new CDBCResultSet();
	try{
		this.groupNames.executeQuery(com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_SELECT_UNIQUE_GROUP, new Object [] { getPoscode() });
	}catch(Exception e1) {}
	
}
public boolean isSunJavaVersion(){
	return javaVer.compareTo("1.2") >= 0;
}
/**
 * Метод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	Connection connection = null;
	PreparedStatement prepstatement = null;
	ResultSet rs = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		prepstatement = connection.prepareStatement(
			com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_SELECT_WITHOUT_IMAGES
			//SQL_PHOTO_SELECT_WITHOUT_IMAGES
		);
		//System.out.println("SQL_PHOTO_SELECT_WITHOUT_IMAGES ["+SQL_PHOTO_SELECT_WITHOUT_IMAGES+"]");
		prepstatement.setObject(1, new Integer(getPhoto()));
		rs = prepstatement.executeQuery();
		if(rs.next()) {
			setPoscode(new Integer(rs.getInt("storageplace")));
			setDescription(rs.getString("description"));
			setDate(rs.getDate("date"));
			setFilename(rs.getString("photofilename"));
			int ph = rs.getInt("photographer");
			if(!rs.wasNull()) setPhotographerId((new Integer(ph)).toString());
			setExternalPhotographer(rs.getString("exphotgrname"));
			setPhotographerName(rs.getString("phname"));
			setPosname(rs.getString("pname"));
			StringBuffer num = new StringBuffer("");
			int g = rs.getInt("g");
			if(!rs.wasNull()) num.append("D").append(g);
			int d = rs.getInt("d");
			if(!rs.wasNull()) num.append("A").append(d);
			setPosid(num.toString());
			String groupName = rs.getString("groupName");
			setGroupName(groupName);
			setGroupName1(groupName);

		}
	} catch(Exception e) {
		System.out.println("Error loading image with id ["+getPhoto()+"], cause " + e.toString());
		e.printStackTrace();
	} finally {
		try { if(rs != null) rs.close(); } catch(Exception e) {} 
		try { if(prepstatement != null) prepstatement.close(); } catch(Exception e) {} 
		try { if(connection != null) connection.close(); } catch(Exception e) {} 
	}
	this.groupNames = new CDBCResultSet();
	try{
		this.groupNames.executeQuery(com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_SELECT_UNIQUE_GROUP, new Object [] { getPoscode() });
	}catch(Exception e1) {}
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {

	Connection connection = null;
	PreparedStatement prepstatement = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		prepstatement = connection.prepareStatement(com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_PHOTO_DELETE);
		prepstatement.setInt(1, getPhoto());
		prepstatement.executeUpdate();
	} catch(Exception e) {
		e.printStackTrace();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
	} finally {
		try { if(prepstatement != null) prepstatement.close(); } catch(Exception e) {} 
		try { if(connection != null) connection.close(); } catch(Exception e) {} 
	}
	return null;
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {

	//PhotoListForm aform = (PhotoListForm)request.getSession().getAttribute( "PhotoListForm" );
	//setPoscode(new Integer(aform.getStorageplace()));
	//KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	//setPhoto(keyGen.getNextKey("tables.photos"));
	//PhotoAccessBean bean = new PhotoAccessBean(getPhoto(), getPoscode(), getDescription(), getDate());

	//beforeUpdate(bean, request);
	//bean.commitCopyHelper();
	//afterUpdate(bean, request);
	return null;
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{

	Connection connection = null;
	PreparedStatement prepstatement = null;
	PreparedStatement selectPeople = null;
	Statement setQuery = null;	
	ResultSet rs = null;
	try {
		JdbcConnection jdbcCon = new JdbcConnection();
		connection = jdbcCon.getConnection();
		selectPeople = connection.prepareStatement(com.hps.july.cdbc.objects.CDBCPhotosObject.SQL_SELECT_PEOPLE_BY_LOGIN);
		selectPeople.setString(1, request.getRemoteUser());
		rs = selectPeople.executeQuery();
		Integer peopleId = null;
		if(rs.next()) {
			int peopleIdi = rs.getInt("man");
			if(!rs.wasNull()) peopleId = new Integer(peopleIdi);
		}
		
		String sqlQuery = (getImageFrm().getFileSize() == 0)?
		//(" UPDATE photos SET description = ?, date = ?, photographer = ?, exphotgrname = ? WHERE photo = ?" ):
		//(" UPDATE photos SET description = ?, date = ?, photographer = ?, exphotgrname = ?, photofilename = ?, photoimage = ?, smallimage = ?, mime_type = ? WHERE photo = ?");
		CDBCPhotosObject.SQL_PHOTO_UPDATE:CDBCPhotosObject.SQL_PHOTO_UPDATE_WITH_IMAGE;
		//System.out.println("sqlQuery ["+sqlQuery+"]");
		setQuery = connection.createStatement();
		prepstatement = connection.prepareStatement(sqlQuery);
		prepstatement.setObject(1, getDescription());
		prepstatement.setObject(2, getDate());
		Integer photographId = null;
		try {
			photographId = new Integer (getPhotographerId());
		} catch(Exception e) {}
		prepstatement.setObject(3, photographId);
		prepstatement.setObject(4, getExternalPhotographer());
		prepstatement.setObject(5, getGroupName1());
		prepstatement.setObject(6, peopleId);
		if(getImageFrm().getFileSize() > 0) {
			prepstatement.setObject(7, getImageFrm().getFileName());
			String mimeType = getImageFrm().getContentType();
			if(mimeType == null) {
				mimeType = com.hps.july.web.util.DataType.getID(getImageFrm().getFileName());
			}
			byte [] smallImage = null;
/*
			if(com.hps.july.web.util.DataType.getID(getImageFrm().getFileName()) != null) {
				smallImage = com.hps.july.web.util.ImageUtil.shrinkImage(getImageFrm().getFileData(), getImageFrm().getFileName());
			}
*/
			prepstatement.setObject(8, getImageFrm().getFileData());
			prepstatement.setObject(9, smallImage);
			prepstatement.setObject(10, mimeType);
		}
		prepstatement.setObject((getImageFrm().getFileSize() > 0)?11:7, new Integer(getPhoto()));
		prepstatement.executeUpdate();
		StringBuffer sb = new StringBuffer();
		sb.append("execute procedure setPhotoShrinkProcessToQuery('photoId=");
		sb.append(getPhoto());
		sb.append("')");
		setQuery.execute(sb.toString());
	} catch(Exception e) {
		if(e instanceof SQLException) System.out.println("ERROR RPOCESS UPDATE !!! " + ((SQLException)e).getErrorCode());
		System.out.println("ERROR RPOCESS UPDATE !!! " + e.toString());
		e.printStackTrace();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.someshit"));
	} finally {
		try { if(rs != null) rs.close(); } catch(Exception e) {} 
		try { if(setQuery != null) setQuery.close(); } catch(Exception e) {}		
		try { if(selectPeople != null) selectPeople.close(); } catch(Exception e) {} 
		try { if(prepstatement != null) prepstatement.close(); } catch(Exception e) {} 
		try { if(connection != null) connection.close(); } catch(Exception e) {} 
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:14:32)
 * @param newDate java.sql.Date
 */
public void setDate(java.sql.Date newDate) {
	date.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:15:11)
 * @param newDateFrm java.lang.String
 */
public void setDateFrm(java.lang.String newDateFrm) {
	date.setString(newDateFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:15:32)
 * @param newDescription java.lang.String
 */
public void setDescription(java.lang.String newDescription) {
	description = newDescription;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2005 18:21:15)
 * @param newExternalPhotographer java.lang.String
 */
public void setExternalPhotographer(java.lang.String newExternalPhotographer) {
	externalPhotographer = newExternalPhotographer;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:15:55)
 * @param newFilename java.lang.String
 */
public void setFilename(java.lang.String newFilename) {
	filename = newFilename;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 10:59:00)
 * @param newGroupName java.lang.String
 */
public void setGroupName(java.lang.String newGroupName) {
	groupName = newGroupName;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 11:17:23)
 * @param newGroupName1 java.lang.String
 */
public void setGroupName1(java.lang.String newGroupName1) {
	groupName1 = newGroupName1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.03.2005 10:58:06)
 * @param newGroupNames com.hps.july.cdbc.lib.CDBCResultSet
 */
public void setGroupNames(com.hps.july.cdbc.lib.CDBCResultSet newGroupNames) {
	groupNames = newGroupNames;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 11:36:57)
 * @param newImage byte[]
 */
public void setImage(byte[] newImage) {
	image = newImage;
}
/**
 * Insert the method's description here.
 * Creation date: (10.06.2002 11:35:37)
 * @param newImageFrm org.apache.struts.upload.FormFile
 */
public void setImageFrm(org.apache.struts.upload.FormFile newImageFrm) {
	imageFrm = newImageFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (30.07.2003 15:24:29)
 * @param newJavaVer java.lang.String
 */
public void setJavaVer(java.lang.String newJavaVer) {
	javaVer = newJavaVer;
}
/**
 * Insert the method's description here.
 * Creation date: (16.03.2005 11:05:56)
 * @param newMimeType java.lang.String
 */
public void setMimeType(java.lang.String newMimeType) {
	mimeType = newMimeType;
}
/**
 * Insert the method's description here.
 * Creation date: (06.06.2002 11:16:18)
 * @param newPhoto int
 */
public void setPhoto(int newPhoto) {
	photo = newPhoto;
}
/**
 * Insert the method's description here.
 * Creation date: (29.10.2002 20:01:58)
 * @param newPhotographer java.lang.Integer
 */
public void setPhotographer(WorkerAccessBean ab) {

	if (ab != null) {
		try {
    		photographerId.setInteger(new Integer(ab.getWorker()));            
            photographerName = ab.getMan().getLastname() + 
            	" " + ab.getMan().getFirstname() + " " + ab.getMan().getMiddlename();
        } catch (Exception ex) {
        }
    }
}
/**
 * Insert the method's description here.
 * Creation date: (31.10.2002 16:14:07)
 * @param id java.lang.String
 */
public void setPhotographerId(String id) {

	photographerId.setString(id);
}
/**
 * Insert the method's description here.
 * Creation date: (30.10.2002 10:01:44)
 * @param newPhotographerName java.lang.String
 */
public void setPhotographerName(java.lang.String newPhotographerName) {
	photographerName = newPhotographerName;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:26)
 * @param newPoscode java.lang.Integer
 */
public void setPoscode(java.lang.Integer newPoscode) {
	poscode = newPoscode;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:12:13)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setPosition(PositionAccessBean newPosition) throws Exception {
	if (newPosition == null) {
	    poscode = new java.lang.Integer(0);
	    posid = "";
	    posname = "";
	}
	else {
		poscode = new Integer(newPosition.getStorageplace());
		posid = "";
		if (newPosition.getGsmid() != null)
			posid = "D" + newPosition.getGsmid() + " ";
		if (newPosition.getDampsid() != null)
			posid = posid + "A" + newPosition.getDampsid();
			
		posname = newPosition.getName();
		if ((newPosition.getDampsname() != null) && (newPosition.getDampsname().length() > 0) )
			posname = posname + " / " + newPosition.getDampsname();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:30:46)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if (!photographerId.isEmpty() && !photographerId.isOk())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.photographer"));
	if (date.isEmpty())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.photo.date"));
	else if (!date.isOk())
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.photo.date"));
	  
	if ((getDescription() == null) || (getDescription().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.photo.description"));
	  
	//if ((getFilename() == null) || (getFilename().length() == 0))
	//  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.photo.filename"));
	  
	try {
		if (getPoscode() != null)
			constructPositions();
	} catch (Exception ex) {
		if (ErrorProcessor.isRecordNotExistException(ex))
		  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.photo.position"));
		else
		  throw ex;
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
