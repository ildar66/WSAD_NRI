package com.hps.july.sitedoc.formbean;

import javax.ejb.ObjectNotFoundException;
import com.hps.july.trailcom.beans.*;
import javax.servlet.http.*;
import com.ibm.ivj.ejb.runtime.*;
import javax.ejb.FinderException;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import org.apache.struts.action.*;
import java.math.*;
import java.util.*;
import com.hps.july.sitedoc.valueobject.*;
import com.hps.july.sitedoc.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import javax.naming.*;
import javax.transaction.*;

/**
 * Форма редактирования документа
 *
 * Для перехода на форму SiteDocForm из других модулей
 * должны быть выставлены параметры appHome, objectType, objectId и action
 * в соответствии с тем от какого объекта происходит переход
 */
public class SiteDocForm extends EditForm {
	private String blanknumber;
	public static final String field_blanknumber="blanknumber";
	private StringAndSqlDateProperty blankdate=new StringAndSqlDateProperty();
	public static final String field_blankdate="blankdate";
	private String comment;
	public static final String field_comment="comment";
	private StringAndSqlDateProperty expiredate=new StringAndSqlDateProperty();
	public static final String field_expiredate="expiredate";
	private StringAndInteger siteDocTypeId=new StringAndInteger();
	private StringAndInteger projectActionId=new StringAndInteger();
	public static final String field_siteDocType="siteDocTypeId";
	private Integer projectId;
	private int sitedoc;
	private Integer objectId;
	private Integer storageplace;
	public Vector siteDocTypes;
	private Vector projectActions;
	private Integer manId;
	private String manFullname;
	private DocObjectDef objectDef;
	private String appHome;
	private String objectType;
public void afterUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
//	SiteDocListForm listForm = (SiteDocListForm) request.getSession().getAttribute("SiteDocListForm");
	SiteDocAccessBean docBean = (SiteDocAccessBean) bean;

	if(objectDef.isComline()) {
		Sitedoc2HopsAccessBean link;
		System.out.println("HOP LINK:INIT:"+objectDef.getHopId());
		if(objectDef.getHopId() == null) {
			throw new UpdateValidationException("error.createdocument.nohopid");
		}
		int hopid = objectDef.getHopId().intValue();
		try {
			link = new Sitedoc2HopsAccessBean();
			link.setInitKey_sitedoc(docBean.getSitedoc());
			link.setInitKey_hop_hopsid(new Integer(hopid));
			link.refreshCopyHelper();
		} catch(FinderException e) {
			try {
				System.out.println("HOP LINK:CREATE:"+docBean.getSitedoc()+","+hopid);
				link = new Sitedoc2HopsAccessBean(docBean.getSitedoc(),hopid);
			} catch(Exception ce) {
				ce.printStackTrace(System.out);
				throw ce;
			}
		}
    } else {
		Sitedoc2SplaceAccessBean link;
		int storageplace = objectDef.getStorageplace();
		try {
			link = new Sitedoc2SplaceAccessBean();
			link.setInitKey_siteDoc_sitedoc(new Integer(docBean.getSitedoc()));
			link.setInitKey_storagePlace_storageplace(new Integer(storageplace));
			link.refreshCopyHelper();
		} catch (FinderException e) {
			link = new Sitedoc2SplaceAccessBean(docBean.getSitedoc(), storageplace);
		}
	}
}
public void beforeDelete(AbstractEntityAccessBean bean, HttpServletRequest request)
    throws Exception
{
    SiteDocAccessBean bean1 = (SiteDocAccessBean) bean;
	Enumeration enum = null;
	try {
		enum = new Sitedoc2HopsAccessBean().
			findSitedoc2HopsBySitedoc(new Integer(bean1.getSitedoc()));
		while(enum.hasMoreElements()) {
            Object obj = enum.nextElement();
			((Sitedoc2HopsAccessBean)obj).getEJBRef().remove();
		}
	} catch(FinderException e) {
	}
    try {
        enum = new Sitedoc2SplaceAccessBean().
        	findSitedoc2SplacesBySiteDoc(new SiteDocKey(bean1.getSitedoc()));
        while (enum.hasMoreElements()) {
            Object obj = enum.nextElement();
            //DebugSupport.printlnTest("!!!beforeDelete obj class="+obj.getClass());
             ((Sitedoc2SplaceAccessBean) obj).getEJBRef().remove();
        }
    } catch (FinderException e) {
    }
    try {
        enum =
            new SiteDocFileAccessBean().
            	findBySitedocsOrderByPKAsc(new Integer(bean1.getSitedoc()));
        while (enum.hasMoreElements()) {
            ((SiteDocFileAccessBean)enum.nextElement()).getEJBRef().remove();
        }
    } catch (FinderException e1) {
    }
}
public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
    throws Exception
{
    String login = request.getRemoteUser();
    OperatorAccessBean operator = new OperatorAccessBean();
    operator = operator.findByLogin(login);
	People man = (People) operator.getMan().getEJBRef();
	manId = new Integer(man.getMan());
	manFullname = man.getFullName();
    ((SiteDocAccessBean) bean).setMan(man);
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
    throws java.lang.Exception
{
    KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
    sitedoc = keygen.getNextKey(TablesRef.SITEDOCS);
    String login = request.getRemoteUser();
    
    OperatorAccessBean operator = new OperatorAccessBean();
    operator = operator.findByLogin(login);

    SiteDocAccessBean bean = new SiteDocAccessBean(
	    sitedoc,
	    siteDocTypeId.getInt(),
	    operator.getManKey().man
	);

    return bean;
}
private ProjectAction constructProjectAction()
	throws Exception
{
    int id = 0;
    if (objectDef.isProject()) {

    } else if (objectDef.isProjectAction()) {
        projectActionId.setInt(objectDef.getObjId());
    } else {
        projectActionId.setInteger(null);
        return null;
    }
    DebugSupport.printlnTest("!!!type="+objectDef.getObjectType()+" projectActionId="+projectActionId.getInt());

    ProjectActionAccessBean bean = new ProjectActionAccessBean();
    bean.setInitKey_projectaction(projectActionId.getInt());
    bean.refreshCopyHelper();
    return (ProjectAction) bean.getEJBRef();
//    projectAction = ;
}
private SiteDocType constructSiteDocType()
	throws Exception
{
	SiteDocTypeAccessBean bean=new SiteDocTypeAccessBean();
	bean.setInitKey_sitedoctype(siteDocTypeId.getInt());
	bean.refreshCopyHelper();
	return (SiteDocType)bean.getEJBRef();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAppHome() {
	return appHome;
}
public int getApplication() {
	return com.hps.july.constants.Applications.SITEDOC;
}
public java.sql.Date getBlankdate(){
return blankdate.getSqlDate();
}
public String getBlankdateFrm(){
return blankdate.getString();
}
public String getBlanknumber(){
return blanknumber;
}
public String getComment(){
return comment;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(
    javax.servlet.http.HttpServletRequest request) {

    SiteDocAccessBean bean = new SiteDocAccessBean();
    try {
        bean.setInitKey_sitedoc(sitedoc);
        bean.refreshCopyHelper();

		if(bean.getMan() != null) {
			manId = new Integer(bean.getMan().getMan());
			manFullname = bean.getMan().getFullName();
		}
    } catch (Exception e) {
        DebugSupport.printlnError(e);
    }
    return bean;
}
public java.sql.Date getExpiredate(){

	DebugSupport.println("!!getExpiredate="+expiredate.getSqlDate());
	return expiredate.getSqlDate();
}
public String getExpiredateFrm(){
return expiredate.getString();
}
public Enumeration getFiles() {
    Enumeration enum = new Vector().elements();
    DebugSupport.printlnTest("1!!!!sitedoc="+sitedoc);
    try {
        enum =
            new SiteDocFileAccessBean().findBySitedocsOrderByPKAsc(new Integer(sitedoc));
    DebugSupport.printlnTest("1!!!!sitedoc="+sitedoc+" SiteDocForm getFiles enum " + enum+" hasMoreElements "+enum.hasMoreElements());
        if (enum == null)
            throw new FinderException();
    } catch (Exception e) {
	    e.printStackTrace(System.out);
        enum = new Vector().elements();
    }
    DebugSupport.printlnTest("2!!!!sitedoc="+sitedoc+" SiteDocForm getFiles enum " + enum+" hasMoreElements "+enum.hasMoreElements());
    return enum;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManFullname() {
	return manFullname;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getManId() {
	return manId;
}
/**
 * 
 * @return com.hps.july.sitedoc.valueobject.DocObjectDef
 */
public com.hps.july.sitedoc.valueobject.DocObjectDef getObjectDef() {
	return objectDef;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getObjectId() {
	return objectId;
}
public Vector getObjectList() throws Exception {
	Vector res = new LinkObject().findLinksList(
		getSitedoc(),
		objectDef.isComline()?objectDef.getObjId():0,
		objectDef.isComline()?0:objectDef.getStorageplace()
	);
	return res;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getObjectType() {
	return objectType;
}
public ProjectAction getProjectAction() throws Exception {
	try {
		return constructProjectAction();
	} catch (Exception e) {
		return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 19:27:39)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getProjectActionFrm() {
	DebugSupport.printlnTest("invoke getProjectActionIdFrm="+projectActionId.getString());
	
	return projectActionId.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 19:27:39)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getProjectActionId() {
	return projectActionId.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2003 19:00:13)
 * @return java.util.Enumeration
 */
public Vector getProjectActions() throws Exception {

    //Vector res = new Vector();
    try {

	    // Removed by DD
        //if (projectActions == null) {
            projectActions = new Vector();
            ProjectActionAccessBeanTable table = new ProjectActionAccessBeanTable();
            table
                .setProjectActionAccessBean(
                    new ProjectActionAccessBean().findByProjectOrderByOrderAsc(
						projectId));
            for (int i = 0; i < table.numberOfRows(); i++) {
                projectActions.add(table.getProjectActionAccessBean(i));

            }

        //}
        DebugSupport.printlnTest("!!!projectActions size=" + projectActions.size());
        return projectActions;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (29.06.2003 19:03:13)
 * @return int
 */
public int getSitedoc() {
	return sitedoc;
}
public SiteDocType getSiteDocType()
	throws Exception
{
	try {	
		return constructSiteDocType();
    } catch(Exception e) {
	    return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 19:27:39)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public Integer getSiteDocTypeId() {
	return siteDocTypeId.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 19:27:39)
 * @return com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public String getSiteDocTypeIdFrm() {
	return siteDocTypeId.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.06.2003 19:00:13)
 * @return java.util.Enumeration
 */
public Vector getSiteDocTypes() throws Exception {

    //Vector res = new Vector();
    try {
        if (siteDocTypes == null) {
	        siteDocTypes=new Vector();
            SiteDocTypeAccessBeanTable table = new SiteDocTypeAccessBeanTable();
            table.setSiteDocTypeAccessBean(new SiteDocTypeAccessBean().findAll());
            for (int i = 0; i < table.numberOfRows(); i++) {
                siteDocTypes.add(table.getSiteDocTypeAccessBean(i));

            }

        }
        //DebugSupport.printlnTest("siteDocTypes=" + siteDocTypes);
        return siteDocTypes;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }

}
public int getState() {
return APPStates.SiteDocForm;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 12:40:44)
 * @return java.lang.Integer
 */
public java.lang.Integer getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 10:28:44)
 * @return boolean
 */
public boolean hasFiles() throws Exception {
    int docId = getSitedoc();

    SiteDocFileAccessBeanTable table = new SiteDocFileAccessBeanTable();
    table.setSiteDocFileAccessBean(
        new SiteDocFileAccessBean().findBySitedocsOrderByPKAsc(new Integer(docId)));

    if (table.numberOfRows() > 0) {
        DebugSupport.printlnTest("validateFiles has links");
        return true;
    } else
        return false;
}
public boolean hasLinks()
	throws Exception
{
    int docId = getSitedoc();

    Enumeration en = new Sitedoc2SplaceAccessBean().findSitedoc2SplacesBySiteDoc(new SiteDocKey(docId));
    if(en.hasMoreElements()) {
	    return true;
    }

	en = new Sitedoc2HopsAccessBean().findSitedoc2HopsBySitedoc(new Integer(docId));
    if(en.hasMoreElements()) {
	    return true;
    }
	
	return false;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 10:28:44)
 * @return boolean
 */
public boolean hasProjectActions() throws Exception {
    int docId = getSitedoc();

    SiteDocAccessBean bean=new SiteDocAccessBean();
    bean.setInitKey_sitedoc(docId);
    bean.refreshCopyHelper();

    return bean.getProjectAction()!=null;
}
public void initCollections(javax.servlet.http.HttpServletRequest request)
    throws Exception
{
	if(request.getParameter("objectId") != null || request.getParameter("objectType") != null) {
		objectDef = DocObjectDef.getDef(getServlet().getServletContext(),request.getSession(),objectType,objectId.intValue(),appHome);
	} else {
		objectDef = DocObjectDef.getDef(request.getSession());
	}
//    listForm =
//        (SiteDocListForm) request.getSession().getAttribute("SiteDocListForm");
	objectId = new Integer(objectDef.getObjId());
	objectType = objectDef.getObjectType();
    //DebugSupport.printlnTest("SiteDocForm initRecord started objectId="+objectId);
//    project = null;

    if (objectDef.isProject()) {
//        project = listForm.getProject();
        projectId = objectDef.getProjectId();
        projectActionId = new StringAndInteger();
    }
    if (objectDef.isProjectAction()) {
        projectActionId.setString(""+objectDef.getObjId());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
    throws Exception {

    

    siteDocTypes = null;
    blankdate = new StringAndSqlDateProperty();
    expiredate = new StringAndSqlDateProperty();
    comment = "";
    blanknumber = "";

    siteDocTypeId = new StringAndInteger();
    if (getSiteDocTypes().size() > 0) {
        siteDocTypeId.setInt(
            ((SiteDocTypeAccessBean) getSiteDocTypes().get(0)).getSitedoctype());
    }

}
/**
 * 
 * @param newAppHome java.lang.String
 */
public void setAppHome(java.lang.String newAppHome) {
	appHome = newAppHome;
}
public void setBlankdate(java.sql.Date arg){
blankdate.setSqlDate(arg);
}
public void setBlankdateFrm(String arg){
blankdate.setString(arg);
}
public void setBlanknumber(String arg){
blanknumber=arg;
}
public void setComment(String arg){
comment=arg;
}
public void setExpiredate(java.sql.Date arg){
expiredate.setSqlDate(arg);
}
public void setExpiredateFrm(String arg){

	DebugSupport.printlnTest("!!!setExpiredateFrm arg="+arg);
	expiredate.setString(arg);
}
/**
 * 
 * @param newManFullname java.lang.String
 */
public void setManFullname(java.lang.String newManFullname) {
	manFullname = newManFullname;
}
/**
 * 
 * @param newManId java.lang.Integer
 */
public void setManId(java.lang.Integer newManId) {
	manId = newManId;
}
/**
 * 
 * @param newObjectDef com.hps.july.sitedoc.valueobject.DocObjectDef
 */
public void setObjectDef(com.hps.july.sitedoc.valueobject.DocObjectDef newObjectDef) {
	objectDef = newObjectDef;
}
/**
 * 
 * @param newObjectId java.lang.Integer
 */
public void setObjectId(java.lang.Integer newObjectId) {
	objectId = newObjectId;
}
/**
 * 
 * @param newObjectType java.lang.String
 */
public void setObjectType(java.lang.String newObjectType) {
	objectType = newObjectType;
}
public void setProjectAction(ProjectActionAccessBean projectAction)
	throws Exception
{
	if (projectAction != null) {
		projectActionId.setInt(projectAction.getProjectaction());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 19:27:39)
 * @param newSiteDocType com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setProjectActionFrm(String value) {
	projectActionId.setString(value);
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 19:27:39)
 * @param newSiteDocType com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setProjectActionId(Integer newSiteDocType) {
	projectActionId.setInteger(newSiteDocType);
}
/**
 * Insert the method's description here.
 * Creation date: (29.06.2003 19:03:13)
 * @param newSitedoc int
 */
public void setSitedoc(int newSitedoc) {
	sitedoc = newSitedoc;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 19:27:39)
 * @param newSiteDocType com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSiteDocType(SiteDocTypeAccessBean newSiteDocType) throws Exception {
	siteDocTypeId.setInt(newSiteDocType.getSitedoctype());
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 19:27:39)
 * @param newSiteDocType com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSiteDocTypeId(Integer newSiteDocType) {
	siteDocTypeId.setInteger(newSiteDocType);
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2003 19:27:39)
 * @param newSiteDocType com.hps.july.jdbcpersistence.lib.StringAndInteger
 */
public void setSiteDocTypeIdFrm(String newSiteDocType) {
	siteDocTypeId.setString(newSiteDocType);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 12:40:44)
 * @param newStorageplace java.lang.Integer
 */
public void setStorageplace(java.lang.Integer newStorageplace) {
	storageplace = newStorageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {

	if ("Add".equalsIgnoreCase(getAction())) {
		// Check for 1 cardpass and 1 listpass
		int iCardPassType = com.hps.july.util.AppUtils.getNamedValueInt("WayMapDocType");
		//int iListPassType = com.hps.july.util.AppUtils.getNamedValueInt("PassListDocType");

		if ( (getSiteDocTypeId() != null) && (getSiteDocTypeId().intValue() == iCardPassType) ) {
		    int siteDoc = 0;
		    Context initial = new InitialContext();
		    UserTransaction uTr = (UserTransaction) initial.lookup("java:comp/UserTransaction");
		    uTr.begin();
		    Sitedoc2SplaceAccessBean link = new Sitedoc2SplaceAccessBean();
		    int splace = 0;
		    if (getObjectId() != null)
		    	splace = getObjectId().intValue();
		    Enumeration enum = link.findSitedoc2SplacesByStoragePlace(new StoragePlaceKey(splace));
		    while (enum.hasMoreElements()) {
		            Sitedoc2SplaceAccessBean temp = (Sitedoc2SplaceAccessBean)enum.nextElement();
		            SiteDocAccessBean siteDocBean = temp.getSiteDoc();
		            if (iCardPassType == siteDocBean.getSiteDocTypeKey().sitedoctype) {
		            	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SiteDocForm.dupcardpass"));
		                break;
		            }
		    }
		    uTr.commit();
		}
	}
	
    try {
        constructSiteDocType();
        constructProjectAction();
        if (getBlanknumber() == null || getBlanknumber().trim().length() == 0) {
            errors.add(
                ActionErrors.GLOBAL_ERROR,
                new ActionError("error.SiteDocForm.blanknumber"));
        }

    } catch (Exception e) {
        DebugSupport.printlnError(e);
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.SiteDocForm.siteDocType"));
    }

    if (!errors.empty())
        throw new ValidationException();
}
}
