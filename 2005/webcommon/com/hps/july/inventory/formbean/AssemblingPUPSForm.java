package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.inventory.sessionbean.*;
import java.util.Enumeration;
import com.hps.july.inventory.valueobject.OuterDocPositionValue;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import java.util.*;

public class AssemblingPUPSForm
	extends AssemblingPPositionForm
{
	private Integer upstype;
	private String upsserial;
	private String upsnote;

	//private AssmBIS[] bis = new AssmBIS[7];
	private ArrayList bis = new ArrayList();
	//private AssmACC[] acc = new AssmACC[3];
	private ArrayList acc = new ArrayList();
	private java.lang.Integer bstypetmp;
	private java.lang.String bscnttmp;
	private java.lang.String accnttmp;
	private java.lang.Integer actypetmp;
	/*
	private Integer bis1type;
	private StringAndIntegerProperty bis1count = new StringAndIntegerProperty();
	private String bis1sn;
	private String bis1note;

	private Integer bis2type;
	private StringAndIntegerProperty bis2count = new StringAndIntegerProperty();
	private String bis2sn;
	private String bis2note;

	private Integer acctype;
	private StringAndIntegerProperty acccount = new StringAndIntegerProperty();
	private String accsn;
	*/
public AssemblingPUPSForm() {	
	super();
	bscnttmp = "1";
	accnttmp = "1";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	throw new UpdateValidationException("error.assups.afterupdate");
	/*
	System.out.println("AssemPosForm: enter;");
	try {
		if("Add".equals(getAction())) {
			ProcessingPositionError err = addPosition2Document(docpos.getInteger());
			if ((err != null) && (err.getErrorCode() != 0))
				System.out.println("COPY AGREGATE CONTENTS ERROR: " + err.getErrorCode());
		} else
		if("Edit".equals(getAction())) {
			ProcessingPositionError err = addPosition2Document(docpos.getInteger());
			if ((err != null) && (err.getErrorCode() != 0))
				System.out.println("COPY AGREGATE CONTENTS ERROR: " + err.getErrorCode());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	*/
}
public void beforeDelete(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception 
{
	throw new UpdateValidationException("error.assups.beforedelete");
	/*
	try {
		removePositionFromDocument(docpos.getInteger());
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.internalrpos.removeagregates");
	}
	*/
}
public void beforeUpdate(AbstractEntityAccessBean bean,	javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	throw new UpdateValidationException("error.assups.beforeupdate");
/*
	try {
		InternalWayBillPositionAccessBean p = (InternalWayBillPositionAccessBean)bean;
		if(getFictionSerial() != null && getFictionSerial().booleanValue()) {
			p.setIsfictserial(true);
			p.setSerialnumber(null);
		} else {
			p.setIsfictserial(false);
			p.setSerialnumber(getSnumber());
		}
		p.setRealserial(null);
		p.commitCopyHelper();
		if ("Edit".equals(getAction())) {
			removePositionFromDocument(docpos.getInteger());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.internalrpos.removeagregates");
	}
*/
}

private void checkACCSize(java.util.ArrayList arList, int index) {
	int asize = arList.size();
	if (asize < (index+1)) {
		for (int i=0; i < index+1 - asize; i++) {
			//System.out.println("***CheckSize: add element");
			arList.add(new AssmACC());
		}
	}
}

private void checkBISSize(java.util.ArrayList arList, int index) {
	int asize = arList.size();
	if (asize < (index+1)) {
		for (int i=0; i < index+1 - asize; i++) {
			//System.out.println("***CheckSize: add element");
			arList.add(new AssmBIS());
		}
	}
}
public void createACC(int i, KeyGeneratorAccessBean keyGen, IBPMountPosAccessBean bean)
	throws Exception
{
	if(acc.get(i)!=null && ((AssmACC)acc.get(i)).getType().intValue() != -1) {
		ResourceAccessBean racc = new ResourceAccessBean();
		racc.setInitKey_resource(((AssmACC)acc.get(i)).getType().intValue());
		racc.refreshCopyHelper();

		if("S".equals(racc.getCountpolicy())) {
			DocumentPositionAccessBean accs = new DocumentPositionAccessBean(
				keyGen.getNextKey("tables.docpositions"), ((AssmACC)acc.get(i)).getType(), ownercode, doc.getInteger(), 3,
				new java.math.BigDecimal("1"), /* Qty */
				new java.math.BigDecimal("0.00"), /* Price */
				getSourceBoxed(), getResultBoxed(),	getSourceBroken(), getResultBroken(), getSourceClosed(), getResultClosed()
			);
			accs.setAgregate((DocumentPosition)bean.getEJBRef());
			accs.setAgregateSerial(upsserial);
			accs.setSerialnumber(((AssmACC)acc.get(i)).getSn());
			accs.setRealserial(null);
			accs.setIsfictserial(false);
			accs.setNewplace(getFitplace());
			accs.setComment(null);
			accs.commitCopyHelper();
		} else {
			DocumentPositionAccessBean accb = new DocumentPositionAccessBean(
				keyGen.getNextKey("tables.docpositions"), ((AssmACC)acc.get(i)).getType(), ownercode, doc.getInteger(), 3,
				new java.math.BigDecimal(((AssmACC)acc.get(i)).getCount().getString()), /* Qty */
				new java.math.BigDecimal("0.00"), /* Price */
				getSourceBoxed(), getResultBoxed(),	getSourceBroken(), getResultBroken(), getSourceClosed(), getResultClosed()
			);
			accb.setAgregate((DocumentPosition)bean.getEJBRef());
			accb.setAgregateSerial(upsserial);
			accb.setSerialnumber(null);
			accb.setRealserial(null);
			accb.setIsfictserial(false);
			accb.setNewplace(getFitplace());
			accb.setComment(null);
			accb.commitCopyHelper();
		}
	}
}
public void createBIS(int i, KeyGeneratorAccessBean keyGen, IBPMountPosAccessBean bean)
	throws Exception
{
	if(bis.get(i)!=null && ((AssmBIS)bis.get(i)).getType().intValue() != -1) {
		ResourceAccessBean rbis = new ResourceAccessBean();
		rbis.setInitKey_resource(((AssmBIS)bis.get(i)).getType().intValue());
		rbis.refreshCopyHelper();

		if("S".equals(rbis.getCountpolicy())) {
			DocumentPositionAccessBean biss = new DocumentPositionAccessBean(
				keyGen.getNextKey("tables.docpositions"), ((AssmBIS)bis.get(i)).getType(), ownercode, doc.getInteger(), 1,
				new java.math.BigDecimal("1"), /* Qty */
				new java.math.BigDecimal("0.00"), /* Price */
				getSourceBoxed(), getResultBoxed(),	getSourceBroken(), getResultBroken(), getSourceClosed(), getResultClosed()
			);
			biss.setAgregate((DocumentPosition)bean.getEJBRef());
			biss.setAgregateSerial(upsserial);
			biss.setSerialnumber(((AssmBIS)bis.get(i)).getSn());
			biss.setRealserial(null);
			biss.setIsfictserial(false);
			biss.setNewplace(getFitplace());
			biss.setComment(((AssmBIS)bis.get(i)).getNote());
			biss.commitCopyHelper();
		} else {
			DocumentPositionAccessBean bisb = new DocumentPositionAccessBean(
				keyGen.getNextKey("tables.docpositions"), ((AssmBIS)bis.get(i)).getType(), ownercode, doc.getInteger(), 1,
				new java.math.BigDecimal(((AssmBIS)bis.get(i)).getCount().getString()), /* Qty */
				new java.math.BigDecimal("0.00"), /* Price */
				getSourceBoxed(), getResultBoxed(),	getSourceBroken(), getResultBroken(), getSourceClosed(), getResultClosed()
			);
			bisb.setAgregate((DocumentPosition)bean.getEJBRef());
			bisb.setAgregateSerial(upsserial);
			bisb.setSerialnumber(null);
			bisb.setRealserial(null);
			bisb.setIsfictserial(false);
			bisb.setNewplace(getFitplace());
			bisb.setComment(((AssmBIS)bis.get(i)).getNote());
			bisb.commitCopyHelper();
		}
	}
}
/**
 * 
 * @return com.hps.july.inventory.formbean.AssmACC[]
 */
public com.hps.july.inventory.formbean.AssmACC getAcc(int index) {
	checkACCSize(acc, index);
	return (AssmACC)acc.get(index);
}
public java.util.Iterator getACC2ResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listMountItemACCs();
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 10:59:22)
 * @return java.lang.String
 */
public java.lang.String getAccnttmp() {
	return accnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getACCount() {
	return acc.size();
}
public java.util.Iterator getACCResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listMountItemACCs();
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 10:59:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getActypetmp() {
	return actypetmp;
}
/**
 * 
 * @return com.hps.july.inventory.formbean.AssmBIS[]
 */
public com.hps.july.inventory.formbean.AssmBIS getBis(int index) {
	checkBISSize(bis, index);
	return (AssmBIS)bis.get(index);
}
public java.util.Iterator getBIS1ResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listMountItemBISs();
	return rs.listIterator();
}
public java.util.Iterator getBIS2ResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listMountItemBISs();
	return rs.listIterator();
}
public java.util.Iterator getBIS3ResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listMountItemBISs();
	return rs.listIterator();
}
public java.util.Iterator getBIS4ResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listMountItemBISs();
	return rs.listIterator();
}
public java.util.Iterator getBIS5ResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listMountItemBISs();
	return rs.listIterator();
}
public java.util.Iterator getBIS6ResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listMountItemBISs();
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 17:28:12)
 * @return java.lang.String
 */
public java.lang.String getBscnttmp() {
	return bscnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getBSCount() {
	return bis.size();
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 17:19:37)
 * @return java.lang.Integer
 */
public java.lang.Integer getBstypetmp() {
	return bstypetmp;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	/*
	AssemblingPForm aform = (AssemblingPForm)request.getSession().getAttribute( "AssemblingPForm" );
	doc.setInteger(aform.getDocumentId());
System.out.println("GET|DOC:"+aform.getDocumentId());
	positioncode = aform.getPositionKey();
	positionname = aform.getPositionname();
	positionid = aform.getPositionid();
	complectcode = aform.getComplectKey();
	complectname = aform.getComplectname();
	expedition = aform.getExpeditionKey();

	InternalWayBillPositionAccessBean bean = new InternalWayBillPositionAccessBean();
	bean.setInitKey_docposition(docpos.getInteger().intValue());
	return bean;
	*/
	return null;
}
public static java.util.ArrayList getSerials(String snlist) {
	ArrayList list = new ArrayList();
	if(snlist == null || "".equals(snlist.trim())) {
		return list;
	}

	snlist = snlist.trim();
	StringTokenizer st = new StringTokenizer(snlist,",;",false);
//	int i = 0;
	while(st.hasMoreTokens()) {
		String nt = st.nextToken();
		list.add(nt);
//		System.out.println("SN"+i+":"+nt);
//		i++;
	}
	return list;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITASPPU;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getUpsnote() {
	return upsnote;
}
public java.util.Iterator getUPSResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listMountItemUPSs();
	return rs.listIterator();
}
public String getUpsserial() {
	return upsserial;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getUpstype() {
	return upstype;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	AssemblingPForm form = (AssemblingPForm)request.getSession().getAttribute("AssemblingPForm");
	doc.setInteger(new Integer(form.getDoc()));
	positioncode = form.getPositionKey();
	positionname = form.getPositionname();
	positionid = form.getPositionid();
	ownercode = form.getOwnerKey();
	ownername = form.getOwnername();
	complectcode = form.getComplectKey();
	complectname = form.getComplectname();
	expedition = form.getExpeditionKey();
	CDBCDocuments cdd = new CDBCDocuments();
	getOrderProp().setInteger(new Integer(cdd.getNextDocumentOrder(doc.getInteger())));
}
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	/*
   	AbstractEntityAccessBean bean = getDataBean(request);
	BeanUtils.copyProperties( this, bean ); 
	fillRecord( bean );
	*/

	try {
		IBPMountPosAccessBean bean = new IBPMountPosAccessBean();
		bean.setInitKey_docposition(getDocpos().intValue());
		bean.refreshCopyHelper();

		upstype = new Integer(bean.getResource().getResource());
		upsserial = bean.getSerialnumber();
		upsnote = bean.getComment();
		ownercode = new Integer(bean.getOwnerKey().organization);
		bscnttmp = "1";
		accnttmp = "1";
		setOrder(bean.getOrder());

		doc.setInteger(new Integer(bean.getDocumentKey().document));
		
		
		CDBCResultSet rs = CDBCDocuments.getMountItemsAgregatedOnly(doc.getInteger(),docpos.getInteger(),new Integer(1));
		
		Iterator it = rs.listIterator();

		//int i = 0;
		//bis = new AssmBIS[7];
		bis = new ArrayList();
		
		while(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			
			Object o = ro.getColumn("resource").asObject();
			Integer type = new Integer(((Number)o).intValue());
			
			Object o2 = ro.getColumn("qty").asObject();
			Integer count = new Integer(((Number)o2).intValue());
			
			String notes = ro.getColumn("comment").asString();	
			String serial = ro.getColumn("serial").asString();

			/*
			bis[i] = new AssmBIS();
			bis[i].setType(type);			
			bis[i].getCount().setInteger(count);
			bis[i].setNote(notes);
			bis[i].setSn(serial);*/
			AssmBIS abis = new AssmBIS();
			
			abis.setType(type);			
			abis.getCount().setInteger(count);
			abis.setNote(notes);
			abis.setSn(serial);
			bis.add(abis);

			//i++;
		}


		CDBCResultSet rs2 = CDBCDocuments.getMountItemsAgregatedOnly(doc.getInteger(),docpos.getInteger(),new Integer(3));
		
		Iterator it2 = rs2.listIterator();
		
		//int j = 0;
		//acc = new AssmACC[3];
		acc = new ArrayList();
		
		while(it2.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it2.next();
			
			Object o = ro.getColumn("resource").asObject();
			Integer type = new Integer(((Number)o).intValue());
			
			Object o2 = ro.getColumn("qty").asObject();
			Integer count = new Integer(((Number)o2).intValue());

			String serial = ro.getColumn("serial").asString();
			
			AssmACC aacc = new AssmACC();	
			/*acc[j] = new AssmACC();
			acc[j].setType(type);			
			acc[j].getCount().setInteger(count);
			acc[j].setSn(serial);	*/

			aacc.setType(type);			
			aacc.getCount().setInteger(count);
			aacc.setSn(serial);
			acc.add(aacc);	
			
			//j++;
		}
			

	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw e;
	}
}
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	try {
		IBPMountPosAccessBean bean = new IBPMountPosAccessBean();
		bean.setInitKey_docposition(docpos.getInteger().intValue());
		bean.refreshCopyHelper();

		DocumentPositionAccessBean dpa = new DocumentPositionAccessBean();
		Enumeration en = dpa.findAgregatePartsByAgregate(new DocumentPositionKey(docpos.getInteger().intValue()));
		while(en.hasMoreElements()) {
			DocumentPositionAccessBean dp = (DocumentPositionAccessBean)en.nextElement();
			dp.getEJBRef().remove();
		}

		bean.getEJBRef().remove();
		/*	
		AbstractEntityAccessBean bean = null;
		bean = getDataBean(request);
		bean.refreshCopyHelper();
		beforeDelete(bean, request);
		bean.getEJBRef().remove();
		afterDelete(request);
		*/
	} catch(javax.ejb.ObjectNotFoundException onfe) {
		throw new UpdateValidationException("error.assups.cantfindposition");
	} catch(Exception e) {
		e.printStackTrace();
		throw new UpdateValidationException("error.assups.cantdelete");
	}
	
	return null;
}
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	AssemblingPForm aform = (AssemblingPForm)request.getSession().getAttribute( "AssemblingPForm" );
	doc.setInteger(new Integer(aform.getDoc()));
	ownercode = aform.getOwnerKey();
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	docpos.setInteger(new Integer(keyGen.getNextKey("tables.docpositions")));
	IBPMountPosAccessBean bean = new IBPMountPosAccessBean(
		docpos.getInteger().intValue(), upstype, ownercode,	doc.getInteger(),
		getOrderProp().getInteger().intValue(),
		new java.math.BigDecimal("1"), /* Qty */
		new java.math.BigDecimal("0.00"), /* Price */
		getSourceBoxed(), getResultBoxed(),	getSourceBroken(), getResultBroken(), getSourceClosed(), getResultClosed()
	);
	bean.setSerialnumber(upsserial);
	bean.setRealserial(null);
	bean.setIsfictserial(false);
	bean.setNewplace(getFitplace());
	bean.setComment(upsnote);
	bean.setOrder(getOrder());
	bean.commitCopyHelper();

	// Create bis
	for(int i = 0; i < bis.size(); i++) {
		if(bis.get(i)!=null && ((AssmBIS)bis.get(i)).getType().intValue() != -1) {
			createBIS(i,keyGen,bean);
		}
	}

	// Create acc
	for(int i = 0; i < acc.size(); i++) {
		if(acc.get(i)!=null && ((AssmACC)acc.get(i)).getType().intValue() != -1) {
			createACC(i,keyGen,bean);
		}
	}

	return null;
}
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
	try {
		IBPMountPosAccessBean bean = new IBPMountPosAccessBean();
		bean.setInitKey_docposition(docpos.getInteger().intValue());
		bean.refreshCopyHelper();

		
		DocumentPositionAccessBean dpa = new DocumentPositionAccessBean();
		Enumeration en = dpa.findAgregatePartsByAgregate(new DocumentPositionKey(docpos.getInteger().intValue()));
		while(en.hasMoreElements()) {
			DocumentPositionAccessBean dp = (DocumentPositionAccessBean)en.nextElement();
			dp.getEJBRef().remove();
		}

		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		// Update UPS

		bean.setSerialnumber(upsserial);
		bean.setRealserial(null);
		bean.setIsfictserial(false);
		bean.setNewplace(getFitplace());
		bean.setComment(upsnote);
		bean.setOrder(getOrder());		
		bean.commitCopyHelper();
		
		// Create BIS
		for(int i = 0; i < bis.size(); i++) {
			if(bis.get(i)!=null && ((AssmBIS)bis.get(i)).getType()!=null && ((AssmBIS)bis.get(i)).getType().intValue() != -1) {
				createBIS(i,keyGen,bean);
			}
		}
		// Create ACC
		for(int i = 0; i < acc.size(); i++) {
			if(acc.get(i)!=null && ((AssmACC)acc.get(i)).getType()!=null && ((AssmACC)acc.get(i)).getType().intValue() != -1) {
				createACC(i,keyGen,bean);
			}
		}
	} catch(javax.ejb.ObjectNotFoundException onfe) {
		throw new UpdateValidationException("error.assups.cantfindposition");
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.assups.cantdelete");
	}
	
	return null;
	/*
	AbstractEntityAccessBean bean = null;
	bean = getDataBean(request);
	BeanUtils.copyProperties(bean, this);
	beforeUpdate(bean, request);
	bean.commitCopyHelper();
	afterUpdate(bean, request);
	return null;
	*/

//	throw new UpdateValidationException("error.assups.cantupdate");
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 10:59:22)
 * @param newAccnttmp java.lang.String
 */
public void setAccnttmp(java.lang.String newAccnttmp) {
	accnttmp = newAccnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 10:59:59)
 * @param newActypetmp java.lang.Integer
 */
public void setActypetmp(java.lang.Integer newActypetmp) {
	actypetmp = newActypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 17:28:12)
 * @param newBscnttmp java.lang.String
 */
public void setBscnttmp(java.lang.String newBscnttmp) {
	bscnttmp = newBscnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 17:19:37)
 * @param newBstypetmp java.lang.Integer
 */
public void setBstypetmp(java.lang.Integer newBstypetmp) {
	bstypetmp = newBstypetmp;
}
/**
 * 
 * @param newUpsnote java.lang.String
 */
public void setUpsnote(java.lang.String newUpsnote) {
	upsnote = newUpsnote;
}
/**
 * 
 * @param newUpsserial java.lang.String
 */
public void setUpsserial(java.lang.String newUpsserial) {
	upsserial = newUpsserial;
}
/**
 * 
 * @param newUpstype java.lang.Integer
 */
public void setUpstype(java.lang.Integer newUpstype) {
	upstype = newUpstype;
}
public void validateACC(AssmACC _acc, int index, ActionErrors errors) {
	Integer _type = _acc.getType();
	String _sn = _acc.getSn();
	StringAndIntegerProperty _count = _acc.getCount();
	 
	String acc_policy = null;
	if(_type == null) {
		return;
		//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups."+prefix+".empty"));
	} else {
		try {
			ResourceAccessBean rb = new ResourceAccessBean();
			rb.setInitKey_resource(_type.intValue());
			rb.refreshCopyHelper();
			acc_policy = rb.getCountpolicy();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.acc.invalid",String.valueOf(index)));
		}
	}

	if("S".equals(acc_policy)) {
		java.util.ArrayList al = getSerials(_sn);
		if(al.size() < 1) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.acc.sn.empty",String.valueOf(index)));
		} else {
			for(int i = 0; i < al.size(); i++) {
				String serial = (String)al.get(i);
				if(serial == null || "".equals(serial.trim())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.acc.sn.invalid",String.valueOf(index)));
				}
			}
		}
	} else
	if("B".equals(acc_policy)) {
		if(_count.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.acc.count.empty",String.valueOf(index)));
		}
		if(!_count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.acc.count.invalid",String.valueOf(index)));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.acc.invalid_policy",String.valueOf(index)));
	}
}
public String validateBIS(AssmBIS _bis, int index, ActionErrors errors) {
	Integer _type = _bis.getType();
	String _sn = _bis.getSn();
	StringAndIntegerProperty _count = _bis.getCount();
	String _unote = _bis.getNote();
	
	String bis_policy = null;
	if(_type == null) {
		return null;
		//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups."+prefix+".empty"));
	} else {
		try {
			ResourceAccessBean rb = new ResourceAccessBean();
			rb.setInitKey_resource(_type.intValue());
			rb.refreshCopyHelper();
			bis_policy = rb.getCountpolicy();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.bis.invalid",String.valueOf(index)));
		}
	}

	if("S".equals(bis_policy)) {
		// check serialnumber
		java.util.ArrayList al = getSerials(_sn);
		if(al.size() < 1) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.bis.sn.empty",String.valueOf(index)));
		} else {
			for(int i = 0; i < al.size(); i++) {
				String serial = (String)al.get(i);
				if(serial == null || "".equals(serial.trim())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.bis.sn.invalid",String.valueOf(index)));
				}
			}
		}
	} else
	if("B".equals(bis_policy)) {
		if(_count.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.bis.count.empty",String.valueOf(index)));
		}
		if(!_count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.bis.count.invalid",String.valueOf(index)));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.bis.invalid_policy",String.valueOf(index)));
	}

	if(_unote != null && (_unote.trim()).length() > 255) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.bis.note.length",String.valueOf(index)));
	}

	return bis_policy;
}
public void validateUPS(Integer _type, String _usn, String _unote, String prefix, ActionErrors errors) {
	String ups_policy = null;
	if(_type == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups."+prefix+".empty"));
	} else {
		try {
			ResourceAccessBean rb = new ResourceAccessBean();
			rb.setInitKey_resource(_type.intValue());
			rb.refreshCopyHelper();
			ups_policy = rb.getCountpolicy();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups."+prefix+".invalid"));
		}
	}

	if("S".equals(ups_policy)) {
		// check serialnumber
		java.util.ArrayList al = getSerials(_usn);
		if(al.size() > 1) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups."+prefix+".sn.needone"));
		}
		if(al.size() < 1) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups."+prefix+".sn.empty"));
		}
		String serial = (String)al.get(0);
		if(serial == null || "".equals(serial.trim())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups."+prefix+".sn.empty"));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups."+prefix+".invalid_policy"));
	}

	if(_unote != null && (_unote.trim()).length() > 255) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups."+prefix+".note.length"));
	}
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if (getOrderProp().isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.order.empty"));
	} else if (!getOrderProp().isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.order.invalid"));
	}

	// Check UPS
	validateUPS(upstype, upsserial, upsnote, "ups", errors);

	// Check BIS	
	if(bis != null) {
		//System.out.println("-------bis size: " + bis.size());
		for(int i = 0; i < bis.size(); i++) {
			//System.out.println("-------bis: " + ((AssmBIS)bis.get(i)).getType());	
			if(bis.get(i)!=null && ((AssmBIS)bis.get(i)).getType()!=null && ((AssmBIS)bis.get(i)).getType().intValue() != -1) {
				validateBIS((AssmBIS)bis.get(i), i, errors);
			}
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.bisnull"));
	}

	// Check ACC
	if(acc != null) {
		for(int i = 0; i < acc.size(); i++) {
			if(acc.get(i)!=null && ((AssmACC)acc.get(i)).getType()!=null && ((AssmACC)acc.get(i)).getType().intValue() != -1) {
				validateACC((AssmACC)acc.get(i), i, errors);
			}
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.assmups.accnull"));
	}
	
	// Check fitplace
	setFitplace("ÈÁÏ");

	
	if (!errors.empty())
		throw new ValidationException();
}
}
