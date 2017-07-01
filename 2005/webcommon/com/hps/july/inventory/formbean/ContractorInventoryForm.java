package com.hps.july.inventory.formbean;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import com.hps.july.inventory.sessionbean.ProcessorFacadeAccessBean;
import java.util.ListIterator;
import java.util.LinkedList;
import java.sql.Statement;
import com.hps.july.jdbcpersistence.lib.JdbcConnection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Types;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import org.apache.struts.util.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Iterator;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.inventory.sessionbean.*;
import com.hps.july.inventory.valueobject.*;

/**
 * Форма ввода и редактирования шапки документа "Внутренний приходный ордер"
 */
public class ContractorInventoryForm
	extends com.hps.july.web.util.EditForm
{
	private String blanknumber;
	private StringAndIntegerProperty blankindex;	
	private StringAndSqlDateProperty blankdate;
	private StringAndIntegerProperty owner;
	private String ownername;	
	private StringAndIntegerProperty renter;
	private String rentername;
	private String documentState;
	private StringAndIntegerProperty position;
	private String positionname;
	private String positionid;
	private StringAndIntegerProperty document;
	private StringAndIntegerProperty expedition;
	private boolean isautodoc = false;

	private Integer upstype;
	private String upsserial;
	private String upsnote;
	private ArrayList bis = new ArrayList();
	private ArrayList acc = new ArrayList();
	private java.lang.Integer bstypetmp;
	private java.lang.String bscnttmp;
	private java.lang.String accnttmp;
	private java.lang.Integer actypetmp;

	private java.lang.String insuranseMan;
	private java.lang.Integer complectbs;
	private java.lang.String complectbsname;
	private java.lang.Integer idact;
	private java.lang.String complectacname;
	private java.lang.Integer complectac;
	private java.lang.String bpcnttmp;
	private java.lang.Integer bptypetmp;
	private java.lang.String complectbpname;
	private java.lang.Integer complectbp;
	private ArrayList bip = new ArrayList();
	private java.lang.Integer vbptypetmp;
	private java.lang.String vbpcnttmp;
	private java.lang.Integer complectvbp;
	private java.lang.String complectvbpname;
	private java.util.ArrayList vbip = new ArrayList();
	private java.lang.Integer batypetmp;
	private java.lang.String bacnttmp;
	private java.lang.Integer complectba;
	private java.lang.String complectbaname;
	private ArrayList bia = new ArrayList();
	private java.lang.String bacategtmp;
	public final int BS_EADU = 8;
	public final int BS_INV_AV = 9;
	public final int BSC_INV_AV = 25;
	public final int BS_SH = 4;
	public final int BSC_SH = 19;
	public final int BS_AVR = 5;
	public final int BSC_AVR = 20;
	public final int BSC_P_COM = 21;
	private java.lang.String socategtmp;
	private java.lang.String socnttmp;
	private java.lang.Integer sotypetmp;
	private java.lang.Integer complectso;
	private java.lang.String complectsoname;
	private ArrayList sio = new ArrayList();
	public final int BS_COND = 10;
	public final int BSC_COND = 26;
	public final int BS_PAN_SIG = 6;
	public final int BSC_PAN_SIG = 38;
	public final int BS_IST_PIT_UZO = 7;
	public final int BSC_IST_PIT_UZO = 22;
	private java.lang.String pocategtmp;
	private java.lang.String pocnttmp;
	private java.lang.Integer potypetmp;
	private ArrayList pio = new ArrayList();
	private java.lang.Integer complectpo;
	private java.lang.String complectponame;
	public final int MSU_IBP = 43;
	public final int MSU_USIL = 44;
	public final int MSU_INJ = 45;
	private java.lang.String mucategtmp;
	private java.lang.String mucnttmp;
	private java.lang.Integer mutypetmp;
	private ArrayList mio = new ArrayList();
	private java.lang.Integer complectmu;
	private java.lang.String complectmuname;
	public final int AFS_IN_DEL = 41;
	public final int AFS_IN_DIP = 46;
	public final int AFS_IN_COMB = 47;
	private java.lang.String cdcategtmp;
	private java.lang.String cdcnttmp;
	private java.lang.Integer cdtypetmp;
	private ArrayList cio = new ArrayList();
	private java.lang.Integer complectcd;
	private java.lang.String complectcdname;
	public final int BSC_OSN_ST = 48;
	public final int BSC_ST_RASH = 49;
	private java.lang.String cbscategtmp;
	private java.lang.String cbscnttmp;
	private java.lang.Integer cbstypetmp;
	private java.lang.Integer complectcbs;
	private java.lang.String complectcbsname;
	private java.util.ArrayList cbis = new ArrayList();
	public final int BSC_BP = 14;
	private java.lang.String cbpcategtmp;
	private java.lang.String cbpcnttmp;
	private java.lang.Integer cbptypetmp;
	private java.lang.Integer complectcbp;
	private java.lang.String complectcbpname;
	private java.util.ArrayList cbip = new ArrayList();
	public final int BS_BP = 1;
	public final int REP = 39;
	private java.lang.Integer rptypetmp;
	private java.lang.String rpcnttmp;
	private java.lang.Integer complectrp;
	private java.lang.String complectrpname;
	private java.util.ArrayList rip = new ArrayList();
	public final int AFS_ANT = 27;
	private java.lang.String ancnttmp;
	private java.lang.Integer antypetmp;
	private java.lang.Integer complectan;
	private java.lang.String complectanname;
	private ArrayList ain = new ArrayList();
	public final int AFS_AFT = 28;
	private ArrayList aif = new ArrayList();
	private java.lang.String aftcnttmp;
	private java.lang.String aftcategtmp;
	private java.lang.Integer afttypetmp;
	private java.lang.Integer complectaft;
	private java.lang.String complectaftname;
	public final int BS_BP_VIPR = 2;
	public final int ACC_BS = 3;
	public final int ACC_BSC = 16;
	public final int BS_PR_UZO = 50;
	public final static String C_CABLE_0 = "Кабель р/ч 0\"";
	public final static String C_CABLE_14 = "Кабель р/ч 1/4\"";
	public final static java.lang.String C_CABLE_12 = "Кабель р/ч 1/2\"";
	public final static java.lang.String C_CABLE_114 = "Кабель р/ч 1 1/4\"";
	public final static java.lang.String C_CABLE_158 = "Кабель р/ч 1 5/8\"";
	public final static java.lang.String C_CABLE_78 = "Кабель р/ч 7/8\"";
	public final static java.lang.String C_BS = "Базовая станция";
	public final static java.lang.String C_IBP = "Источник питания";
	private java.lang.Boolean warnProc;
	private java.lang.String processState;
	public final static java.lang.String C_YPIT = "Ячейка питания";
	private java.lang.String act;
	private java.lang.String docs;
	private StringAndIntegerProperty storagemancode;
	private java.lang.String storagemanname;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	public static MessageResources messageRes = MessageResources.getMessageResources("com.hps.july.inventory.ApplicationResources");
	private java.util.ArrayList calcerrors = new java.util.ArrayList();
	private java.util.ArrayList headercalcerrors = new java.util.ArrayList();
	private java.lang.String procnttmp;
	private java.lang.Integer complectpro;
	private java.lang.String complectproname;
	private java.util.ArrayList prio = new java.util.ArrayList();
	private int refreshFields;
	private int storageplace;
	private java.util.ArrayList stio = new ArrayList();
	private java.lang.String protypetmp;
	private java.lang.String propolicytmp;
	public final static java.lang.String C_CABLE_1751 = "Кабель р/ч РК-50-1751С\"";
	private boolean autodoc;
public ContractorInventoryForm() {	
	expedition = new StringAndIntegerProperty();
	owner = new StringAndIntegerProperty();
	blankindex = new StringAndIntegerProperty();	
	blankdate = new StringAndSqlDateProperty();
	renter = new StringAndIntegerProperty();	
	position = new StringAndIntegerProperty();
	document = new StringAndIntegerProperty();
	expedition = new StringAndIntegerProperty();
	storagemancode = new StringAndIntegerProperty();
	bscnttmp = "1";
	bpcnttmp = "1";
	accnttmp = "1";
	vbpcnttmp = "1";
	bacnttmp = "1";
	socnttmp = "1";
	pocnttmp = "1";
	mucnttmp = "1";
	cdcnttmp = "1";
	cbscnttmp = "1";
	cbpcnttmp = "1";
	rpcnttmp = "1";
	ancnttmp = "1";
	aftcnttmp = "1";
	procnttmp = "1";
	autodoc= false;
	
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	super.afterUpdate(bean,request); // Support for document calculation
	if("Add".equals(getAction())) {
		setAction("Edit");
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	
}
private void checkSize(java.util.ArrayList arList, int index) {
	int asize = arList.size();
	if (asize < (index+1)) {
		for (int i=0; i < index+1 - asize; i++) {
			arList.add(new PosVO());
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.09.2005 13:31:17)
 */
public void clearAll() {
	bis.clear();
    bip.clear();
    vbip.clear();
    acc.clear();
    bia.clear();
    sio.clear();
    pio.clear();
    mio.clear();
    cio.clear();
    cbis.clear();
    cbip.clear();
    rip.clear();
    ain.clear();
    aif.clear();
    prio.clear();
    stio.clear();
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocument(keyGen.getNextKey("tables.documents"));

	/*InternalWayBillAccessBean bean = new InternalWayBillAccessBean(
		getDocument(),
		owner.getInteger(),
		null,
		storage.getInteger(),
		blankdate.getSqlDate(),
		getBlankindex(),
		(blanknumber != null)?blanknumber:"",
		"1",
		Boolean.TRUE,
		Boolean.TRUE,
		fixing
	);*/
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2005 17:40:08)
 */
public void constructDocPositions(int doc,Integer complect,ArrayList data) throws Exception{

	for(int i = 0; i < data.size(); i++) {			
			
		if(data.get(i)!=null && ((PosVO)data.get(i)).getType()!=null &&((PosVO)data.get(i)).getType().intValue() != -1) {
			
			PosVO vo = (PosVO)data.get(i);
			if(complect.intValue()!=vo.getComplect().intValue()){
				continue;
			}
			
			Integer resourcecode = vo.getType();
			int order = 0;
			try {
				DocumentPositionAccessBean fbean = new DocumentPositionAccessBean();
				DocumentPositionAccessBean bean = fbean.findMaxOrderPosition(new Integer(doc));
				order = bean.getOrder() + 1;
			} catch(Exception e) {
				order = 1;
			}

			StringAndIntegerProperty scount = vo.getCount();
			java.math.BigDecimal qty = null;
            if(!scount.isEmpty()){
	            qty = new java.math.BigDecimal(scount.getString());
            }else{
	            qty = new java.math.BigDecimal("0.0");
            }
            
			
			String bis_policy = null;
			try {
				ResourceAccessBean rb = new ResourceAccessBean();
				rb.setInitKey_resource(resourcecode.intValue());
				rb.refreshCopyHelper();
				bis_policy = rb.getCountpolicy();
			} catch(Exception e) {
				qty = new java.math.BigDecimal("1.0");
			}
				
			if("S".equals(bis_policy) || "P".equals(bis_policy)) {
				qty = new java.math.BigDecimal("1.0");
			}

			

            String sn = vo.getSn();
			
			KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
			int docpos = keyGen.getNextKey("tables.docpositions");
			I13nActPositionAccessBean bean = new I13nActPositionAccessBean(
				docpos,
				resourcecode,
				getOwnerId(),
				new Integer(doc),
				order,
				qty,
				new java.math.BigDecimal("0.0"),
				Boolean.FALSE, 
				Boolean.FALSE, 
				Boolean.FALSE, 
				Boolean.FALSE, 
				"N",
				Boolean.FALSE, Boolean.FALSE
			);
			bean.setSerialnumber(sn);
			bean.setNewplace("-");			
			bean.setIsfictserial(vo.getFictionSerial()!=null?vo.getFictionSerial().booleanValue():false);
			bean.commitCopyHelper();

			
		}
	}	

	
	
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2005 17:40:08)
 */
public void constructDocuments(int doc,Integer complect,int index) throws Exception{
	
	I13nActAccessBean bean = new I13nActAccessBean(
		doc,
		getOwnerId(),
		complect,
		complect,
		/*new java.sql.Date(System.currentTimeMillis())*/getBlankdate(),
		index,
		getBlanknumber(),
		getDocumentState(),
		null,
		"F"
	);
	WorkerAccessBean wab = new WorkerAccessBean();
	wab.setInitKey_worker(getStoragemancode().intValue());
	wab.refreshCopyHelper(); 
	bean.setStorageManager((Worker)wab.getEJBRef());
	bean.setIsautodoc(true);
	bean.commitCopyHelper();
	
}
public PositionAccessBean constructPosition() throws java.lang.Exception {
	PositionAccessBean bean = new PositionAccessBean();
	bean.setInitKey_storageplace(position.getInteger().intValue());
	bean.refreshCopyHelper();
	setPosition(bean);
	return bean;
}
public void createAccRow(int i, int idact,int position, ArrayList array, Connection conn, int group, KeyGeneratorAccessBean keyGen)
	throws Exception
{	
	if(array.get(i)!=null && ((PosVO)array.get(i)).getType().intValue() != -1) {

		PosVO vo = (PosVO)array.get(i);
		int id = keyGen.getNextKey("tables.invcontractitems");
	
		PreparedStatement ps = null;

		try{
			ps = conn.prepareStatement("insert into invcontractitems values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			int count = 0;
			if(vo.getCount()!=null && vo.getCount().getInteger()!=null){
				count = vo.getCount().getInteger().intValue();
			}
			
	   		ps.setInt(1,id);
	   		ps.setInt(2,idact);
	   		ps.setInt(3,group);
	    	ps.setInt(4,vo.getType()!=null?vo.getType().intValue():0);
	    	ps.setNull(5,java.sql.Types.INTEGER);
	    	ps.setInt(6,count);
	    	ps.setString(7,vo.getSn());
	    	ps.setString(8,vo.getComment()!=null?vo.getComment():"");
	    	ps.setNull(9,java.sql.Types.INTEGER);
	    	if(vo.getNote()!=null && isValidDec(vo.getNote())){
	    		ps.setBigDecimal(10,new java.math.BigDecimal(vo.getNote()));
	    	}else{
		    	ps.setNull(10,java.sql.Types.DECIMAL);
	    	}
	    	if(vo.getRoomnumber()!=null && isValidDec(vo.getRoomnumber()) && isValidDec(vo.getRoomnumber())){
	    		ps.setBigDecimal(11,new java.math.BigDecimal(vo.getRoomnumber()));
	    	}else{
		    	ps.setNull(11,java.sql.Types.DECIMAL);
	    	}
	    	ps.setNull(12,java.sql.Types.CHAR);
	    	ps.setNull(13,java.sql.Types.CHAR);
	    	ps.setNull(14,java.sql.Types.DECIMAL);
	    	ps.setNull(15,java.sql.Types.CHAR);
	    	ps.setInt(16,vo.getComplect().intValue());
	    	ps.setInt(17,position);
	    	ps.setInt(18,vo.getResourcecateg());
	    	if(vo.getFictionSerial()!=null){
	    		ps.setString(19,vo.getFictionSerial().booleanValue()?"Y":"N");
	    	}else{
		    	ps.setString(19,"N");
	    	}
	    	ps.setNull(20,java.sql.Types.INTEGER);
	    	ps.setNull(21,java.sql.Types.CHAR);
	    	
	    	ps.execute();	
		}catch(Exception e){
			e.printStackTrace(System.out);
		}finally{
	    	try{
		    	if(ps!=null) ps.close();
	    	}catch(Exception exc){
			    exc.printStackTrace(System.out);
	    	}
    	}
	}
}
public void createAftRow(int i, int idact,int position, ArrayList array, Connection conn, int group, KeyGeneratorAccessBean keyGen)
	throws Exception
{	
	if(array.get(i)!=null && ((PosVO)array.get(i)).getType().intValue() != -1) {

		PosVO vo = (PosVO)array.get(i);
		int id = keyGen.getNextKey("tables.invcontractitems");
	
		PreparedStatement ps = null;

		try{
			ps = conn.prepareStatement("insert into invcontractitems values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			int count = 0;
			if(vo.getCount()!=null && vo.getCount().getInteger()!=null){
				count = vo.getCount().getInteger().intValue();
			}
			
	   		ps.setInt(1,id);
	   		ps.setInt(2,idact);
	   		ps.setInt(3,group);
	    	ps.setInt(4,vo.getType()!=null?vo.getType().intValue():0);
	    	ps.setInt(5,vo.getCateg().intValue());
	    	ps.setInt(6,count);
	    	ps.setNull(7,java.sql.Types.CHAR);
	    	ps.setNull(8,java.sql.Types.CHAR);
	    	ps.setNull(9,java.sql.Types.INTEGER);	    	
	    	ps.setNull(10,java.sql.Types.DECIMAL);
	    	ps.setNull(11,java.sql.Types.DECIMAL);
	    	ps.setNull(12,java.sql.Types.CHAR);	 
	    	ps.setString(13,vo.getSector());
	    	if(isValidDec(vo.getKsb())){
	    		ps.setBigDecimal(14,new java.math.BigDecimal(vo.getKsb()));
	    	}else{
		    	ps.setNull(14,java.sql.Types.DECIMAL);
	    	}
	    	ps.setString(15,vo.getGsm());
	    	ps.setInt(16,vo.getComplect().intValue());
	    	ps.setInt(17,position);
	    	ps.setInt(18,vo.getResourcecateg());
	    	if(vo.getFictionSerial()!=null){
	    		ps.setString(19,vo.getFictionSerial().booleanValue()?"Y":"N");
	    	}else{
		    	ps.setString(19,"N");
	    	}
			ps.setNull(20,java.sql.Types.INTEGER);
			ps.setNull(21,java.sql.Types.CHAR);
	    	
	    	ps.execute();	
		}catch(Exception e){
			e.printStackTrace(System.out);
		}finally{
	    	try{
		    	if(ps!=null) ps.close();
	    	}catch(Exception exc){
			    exc.printStackTrace(System.out);
	    	}
    	}
	}
}
public void createBpaRow(int i, int idact,int position, ArrayList array, Connection conn, int group, KeyGeneratorAccessBean keyGen)
	throws Exception
{	
	if(array.get(i)!=null && ((PosVO)array.get(i)).getType().intValue() != -1) {

		PosVO vo = (PosVO)array.get(i);
		int id = keyGen.getNextKey("tables.invcontractitems");
	
		PreparedStatement ps = null;

		try{
			ps = conn.prepareStatement("insert into invcontractitems values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			int count = 0;
			if(vo.getCount()!=null && vo.getCount().getInteger()!=null){
				count = vo.getCount().getInteger().intValue();
			}
			
	   		ps.setInt(1,id);
	   		ps.setInt(2,idact);
	   		ps.setInt(3,group);
	    	ps.setInt(4,vo.getType()!=null?vo.getType().intValue():0);
	    	ps.setInt(5,vo.getCateg().intValue());
	    	ps.setInt(6,count);
	    	ps.setString(7,vo.getSn());
	    	ps.setString(8,vo.getNote()!=null?vo.getNote():"");
	    	if(vo.getRoomnumber()!=null && !vo.getRoomnumber().equals("") && isValidInt(vo.getRoomnumber())){
		    	ps.setInt(9,new Integer(vo.getRoomnumber()).intValue());
	    	}else{
		    	ps.setNull(9,java.sql.Types.INTEGER);
	    	}
	    	ps.setNull(10,java.sql.Types.DECIMAL);
	    	ps.setNull(11,java.sql.Types.DECIMAL);
	    	ps.setNull(12,java.sql.Types.CHAR);
	    	ps.setNull(13,java.sql.Types.CHAR);
	    	ps.setNull(14,java.sql.Types.DECIMAL);
	    	ps.setNull(15,java.sql.Types.CHAR);
	    	ps.setInt(16,vo.getComplect().intValue());
	    	ps.setInt(17,position);
	    	ps.setInt(18,vo.getResourcecateg());
	    	
			if(vo.getFictionSerial()!=null){
	    		ps.setString(19,vo.getFictionSerial().booleanValue()?"Y":"N");
	    	}else{
		    	ps.setString(19,"N");
	    	}	
			ps.setNull(20,java.sql.Types.INTEGER);
			ps.setNull(21,java.sql.Types.CHAR);
	    	
	    	ps.execute();	
		}catch(Exception e){
			e.printStackTrace(System.out);
		}finally{
	    	try{
		    	if(ps!=null) ps.close();
	    	}catch(Exception exc){
			    exc.printStackTrace(System.out);
	    	}
    	}
	}
}
public void createRow(int i, int idact, int position, ArrayList array, Connection conn, int group, KeyGeneratorAccessBean keyGen)
	throws Exception
{	
	if(array.get(i)!=null && ((PosVO)array.get(i)).getType().intValue() != -1) {

		PosVO vo = (PosVO)array.get(i);
		int id = keyGen.getNextKey("tables.invcontractitems");
	
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		try{
			ps = conn.prepareStatement("insert into invcontractitems values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps2 = conn.prepareStatement("select resource from resources where model=?");
			
			int count = 0;
			if(vo.getCount()!=null && vo.getCount().getInteger()!=null){
				count = vo.getCount().getInteger().intValue();
			}
			
	   		ps.setInt(1,id);
	   		ps.setInt(2,idact);
	   		ps.setInt(3,group);
	   		if(group!=15){
	    		ps.setInt(4,vo.getType()!=null?vo.getType().intValue():0);
	   		}else{
		   		int type = 0;
				ps2.setString(1,vo.getTypename()); 
				rs = ps2.executeQuery();
				if(rs.next()) {
					type = rs.getInt(1);
				}
				ps.setInt(4,type);
	   		}
	    	ps.setNull(5,java.sql.Types.INTEGER);
	    	ps.setInt(6,count);
	    	ps.setString(7,vo.getSn());	   
			ps.setString(8,vo.getNote()!=null?vo.getNote():"");
	    	
	    	if(group==13){
		    	ps.setNull(9,java.sql.Types.INTEGER);
	    	}else{		    	
	    		if(vo.getRoomnumber()!=null && !vo.getRoomnumber().equals("") && isValidInt(vo.getRoomnumber())){
		    		ps.setInt(9,new Integer(vo.getRoomnumber()).intValue());
	    		}else{
		    		ps.setNull(9,java.sql.Types.INTEGER);
	    		}
	    	}
	    	ps.setNull(10,java.sql.Types.DECIMAL);
	    	ps.setNull(11,java.sql.Types.DECIMAL);
	    	if(group==13){
		    	ps.setString(12,vo.getRoomnumber());	    		
	    	}else{
		    	ps.setNull(12,java.sql.Types.CHAR);
	    	}
	    	ps.setNull(13,java.sql.Types.CHAR);
	    	ps.setNull(14,java.sql.Types.DECIMAL);
	    	ps.setNull(15,java.sql.Types.CHAR);
	    	ps.setInt(16,vo.getComplect().intValue());
	    	ps.setInt(17,position);
	    	ps.setInt(18,vo.getResourcecateg());

	    	if(vo.getFictionSerial()!=null){
	    		ps.setString(19,vo.getFictionSerial().booleanValue()?"Y":"N");
	    	}else{
		    	ps.setString(19,"N");
	    	}
	    	ps.setNull(20,java.sql.Types.INTEGER);
			ps.setString(21,vo.getComment()!=null?vo.getComment():"");
	    	
	    	ps.execute();	
		}catch(Exception e){
			e.printStackTrace(System.out);
		}finally{
	    	try{
		    	if(rs!=null) rs.close();
		    	if(ps!=null) ps.close();
		    	if(ps2!=null) ps2.close();
	    	}catch(Exception exc){
			    exc.printStackTrace(System.out);
	    	}
    	}
	}
}
public void deleteDocument(Integer docId, ActionErrors errors)
	throws UpdateValidationException
{
	try {
		JdbcConnection jdbc = new JdbcConnection();
		Connection c = jdbc.getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			cs = c.prepareCall("EXECUTE PROCEDURE DELETEDOCUMENT(?)");
			cs.setInt(1,docId.intValue());
			boolean b = cs.execute();
			rs = cs.getResultSet();
			if(rs.next()) {
				int errorcode = rs.getInt(1); // Error code
				int edpos = rs.getInt(2); // ErrorDocumentPosition
				int cdc = rs.getInt(3); // ConflictDocumentCode
				//System.out.println(">>>>>error.document.delete." + errorcode + " - " + edpos + " - " + cdc);
				//errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.document.delete."+errorcode,new Integer(edpos),new Integer(cdc)));

			} 
		} finally {
			if(rs != null) { rs.close(); }
			if(cs != null) { cs.close(); }
			if(c != null) { c.close(); }
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
		//throw new UpdateValidationException("error.document.delete");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2005 12:30:14)
 */
public void deleteDocumentOld(int doc){

	try{
	
		I13nActAccessBean bean = new I13nActAccessBean();
		bean.setInitKey_document(doc);

		DocumentPositionAccessBean bean2 = new DocumentPositionAccessBean();	
		Enumeration enum = bean2.findByDocOrderByAgregateAsc(new Integer(doc));
	
		while(enum.hasMoreElements()){
			DocumentPositionAccessBean bean3 = (DocumentPositionAccessBean)enum.nextElement();
			bean3.getEJBRef().remove();
		}
		
		bean.getEJBRef().remove();

	}catch(Exception e){
		e.printStackTrace(System.out);
	}
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getAcc(int index) {
	checkSize(acc, index);
	return (PosVO)acc.get(index);
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
	int[] categs = new int[]{ACC_BS,ACC_BSC};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (30.08.2005 14:05:41)
 * @return java.lang.String
 */
public java.lang.String getAct() {
	return act;
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
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:53:55)
 * @return java.lang.String
 */
public java.lang.String getAftcategtmp() {
	return aftcategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:52:56)
 * @return java.lang.String
 */
public java.lang.String getAftcnttmp() {
	return aftcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getAFTCount() {
	return aif.size();
}
public java.util.Iterator getAFTResourcesList() {
	int[] categs = new int[]{AFS_AFT};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:54:39)
 * @return java.lang.Integer
 */
public java.lang.Integer getAfttypetmp() {
	return afttypetmp;
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getAif(int index) {
	checkSize(aif, index);
	return (PosVO)aif.get(index);
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getAin(int index) {
	checkSize(ain, index);
	return (PosVO)ain.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 12:52:35)
 * @return java.lang.String
 */
public java.lang.String getAncnttmp() {
	return ancnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getANCount() {
	return ain.size();
}
public java.util.Iterator getANResourcesList() {
	int[] categs = new int[]{AFS_ANT};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 12:53:24)
 * @return java.lang.Integer
 */
public java.lang.Integer getAntypetmp() {
	return antypetmp;
}
public int getApplication() {
	return com.hps.july.constants.Applications.INVENTORY;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 12:06:35)
 * @return java.lang.String
 */
public java.lang.String getBacategtmp() {
	return bacategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 11:01:36)
 * @return java.lang.String
 */
public java.lang.String getBacnttmp() {
	return bacnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getBACount() {
	return bia.size();
}
public String getBaJSData()
{
	try {
		Iterator it = getBAResourcesList();

		StringBuffer body = new StringBuffer();		
		body.append("var bajs = new Array(\r\n");
		
		while (it.hasNext()) {
			try {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				body.append("new Array(");
				body.append(ro.getColumn("resource").asString());
				body.append(", ");
				String categid = ro.getColumn("categid").asString();
				if(categid.equals(String.valueOf(BS_INV_AV)) || categid.equals(String.valueOf(BSC_INV_AV))){
					body.append("1");
				}else if(categid.equals(String.valueOf(BS_EADU))){
					body.append("2");
				}
				
				body.append(", \"");
				body.append(ro.getColumn("model").asString());
				if(it.hasNext()) {
					body.append("\"), \r\n");
				} else {
					body.append("\") \r\n");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		body.append("); \r\n");

		
		return body.toString();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return "";
}
public java.util.Iterator getBAResourcesList() {
	int[] categs = new int[]{BS_INV_AV,BS_EADU};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 10:59:32)
 * @return java.lang.Integer
 */
public java.lang.Integer getBatypetmp() {
	return batypetmp;
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getBia(int index) {
	checkSize(bia, index);
	return (PosVO)bia.get(index);
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getBip(int index) {
	checkSize(bip, index);
	return (PosVO)bip.get(index);
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getBis(int index) {
	checkSize(bis, index);
	return (PosVO)bis.get(index);
}
public java.util.Iterator getBIS1ResourcesList() {
	com.hps.july.cdbc.lib.CDBCResultSet rs = com.hps.july.cdbc.objects.CDBCDictionaryObject.listContrItemsByResource(3);
	return rs.listIterator();
}
public java.sql.Date getBlankdate() {
	return blankdate.getSqlDate();
}
public String getBlankdatestr() {
	return blankdate.getString();
}
public int getBlankindex() {
	if(!blankindex.isEmpty() && blankindex.isOk())
		return blankindex.getInteger().intValue();
	else
		return 0;
}
public String getBlankindexFrm() {
	return blankindex.getString();
}
public String getBlanknumber() {
	return blanknumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 16:44:19)
 * @return java.lang.String
 */
public java.lang.String getBpcnttmp() {
	return bpcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getBPCount() {	
	return bip.size();
}
public java.util.Iterator getBPResourcesList() {
	int[] categs = new int[]{BS_BP};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 16:48:31)
 * @return java.lang.Integer
 */
public java.lang.Integer getBptypetmp() {
	return bptypetmp;
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
/**
 * Insert the method's description here.
 * Creation date: (02.09.2005 18:11:37)
 */
public java.util.ArrayList getCalcerrors() {
	return calcerrors;
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getCbip(int index) {
	checkSize(cbip, index);
	return (PosVO)cbip.get(index);
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getCbis(int index) {
	checkSize(cbis, index);
	return (PosVO)cbis.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:13:19)
 * @return java.lang.String
 */
public java.lang.String getCbpcategtmp() {
	return cbpcategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:13:56)
 * @return java.lang.String
 */
public java.lang.String getCbpcnttmp() {
	return cbpcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getCBPCount() {
	return cbip.size();
}
public java.util.Iterator getCBPResourcesList() {
	int[] categs = new int[]{BSC_BP};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:14:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getCbptypetmp() {
	return cbptypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:55:36)
 * @return java.lang.String
 */
public java.lang.String getCbscategtmp() {
	return cbscategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:56:03)
 * @return java.lang.String
 */
public java.lang.String getCbscnttmp() {
	return cbscnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getCBSCount() {
	return cbis.size();
}
public String getCbsJSData()
{
	try {
		Iterator it = getCBSResourcesList();

		StringBuffer body = new StringBuffer();		
		body.append("var cbsjs = new Array(\r\n");
		
		while (it.hasNext()) {
			try {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				body.append("new Array(");
				body.append(ro.getColumn("resource").asString());
				body.append(", ");
				String categid = ro.getColumn("categid").asString();
				if(categid.equals(String.valueOf(BSC_OSN_ST))){
					body.append("1");
				}else if(categid.equals(String.valueOf(BSC_ST_RASH))){
					body.append("2");
				}
				
				body.append(", \"");
				body.append(ro.getColumn("model").asString());
				if(it.hasNext()) {
					body.append("\"), \r\n");
				} else {
					body.append("\") \r\n");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		body.append("); \r\n");

		
		return body.toString();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return "";
}
public java.util.Iterator getCBSResourcesList() {
	int[] categs = new int[]{BSC_OSN_ST,BSC_ST_RASH};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:56:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getCbstypetmp() {
	return cbstypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:22:00)
 * @return java.lang.String
 */
public java.lang.String getCdcategtmp() {
	return cdcategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:22:32)
 * @return java.lang.String
 */
public java.lang.String getCdcnttmp() {
	return cdcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getCDCount() {
	return cio.size();
}
public String getCdJSData()
{
	try {
		Iterator it = getCDResourcesList();

		StringBuffer body = new StringBuffer();		
		body.append("var cdjs = new Array(\r\n");
		
		while (it.hasNext()) {
			try {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				body.append("new Array(");
				body.append(ro.getColumn("resource").asString());
				body.append(", ");
				String categid = ro.getColumn("categid").asString();
				if(categid.equals(String.valueOf(AFS_IN_DEL))){
					body.append("1");
				}else if(categid.equals(String.valueOf(AFS_IN_DIP))){
					body.append("2");
				}else if(categid.equals(String.valueOf(AFS_IN_COMB))){
					body.append("3");
				}
				
				body.append(", \"");
				body.append(ro.getColumn("model").asString());
				if(it.hasNext()) {
					body.append("\"), \r\n");
				} else {
					body.append("\") \r\n");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		body.append("); \r\n");

		
		return body.toString();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return "";
}
public java.util.Iterator getCDResourcesList() {
	int[] categs = new int[]{AFS_IN_DEL,AFS_IN_DIP,AFS_IN_COMB};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:22:56)
 * @return java.lang.Integer
 */
public java.lang.Integer getCdtypetmp() {
	return cdtypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:55:49)
 * @return java.lang.String
 * @param s java.lang.String
 */
public String getCellXY(String s) {
	StringBuffer sb = new StringBuffer();
	char[] ch = s.toCharArray();
	int i;
	for(i=0;i<ch.length;i++){
		boolean is = Character.isLetter(ch[i]);
		if(is){
			sb.append(ch[i]);
		}else{
			sb.append(',');
			break;
		}
	}
	
	for(int j=i;j<ch.length;j++){
		boolean is = Character.isLetter(ch[j]);		
			sb.append(ch[j]);
		
	}	
	return sb.toString();
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getCio(int index) {
	checkSize(cio, index);
	return (PosVO)cio.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 10:45:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectac() {
	return complectac;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 10:44:44)
 * @return java.lang.String
 */
public java.lang.String getComplectacname() {
	return complectacname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:57:38)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectaft() {
	return complectaft;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:58:01)
 * @return java.lang.String
 */
public java.lang.String getComplectaftname() {
	return complectaftname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 12:54:54)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectan() {
	return complectan;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 12:55:14)
 * @return java.lang.String
 */
public java.lang.String getComplectanname() {
	return complectanname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 11:03:58)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectba() {
	return complectba;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 11:04:49)
 * @return java.lang.String
 */
public java.lang.String getComplectbaname() {
	return complectbaname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 16:51:20)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectbp() {
	return complectbp;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 16:50:55)
 * @return java.lang.String
 */
public java.lang.String getComplectbpname() {
	return complectbpname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 18:02:58)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectbs() {
	return complectbs;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 18:03:24)
 * @return java.lang.String
 */
public java.lang.String getComplectbsname() {
	return complectbsname;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:18:04)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectcbp() {
	return complectcbp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:25:36)
 * @return java.lang.String
 */
public java.lang.String getComplectcbpname() {
	return complectcbpname;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:58:31)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectcbs() {
	return complectcbs;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:59:15)
 * @return java.lang.String
 */
public java.lang.String getComplectcbsname() {
	return complectcbsname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:54:46)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectcd() {
	return complectcd;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:55:05)
 * @return java.lang.String
 */
public java.lang.String getComplectcdname() {
	return complectcdname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:40:05)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectmu() {
	return complectmu;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:40:32)
 * @return java.lang.String
 */
public java.lang.String getComplectmuname() {
	return complectmuname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:50:13)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectpo() {
	return complectpo;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:50:38)
 * @return java.lang.String
 */
public java.lang.String getComplectponame() {
	return complectponame;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 14:25:17)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectpro() {
	return complectpro;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 14:25:38)
 * @return java.lang.String
 */
public java.lang.String getComplectproname() {
	return complectproname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 17:16:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectrp() {
	return complectrp;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 17:16:36)
 * @return java.lang.String
 */
public java.lang.String getComplectrpname() {
	return complectrpname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:57:39)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectso() {
	return complectso;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:58:18)
 * @return java.lang.String
 */
public java.lang.String getComplectsoname() {
	return complectsoname;
}
/**
 * Insert the method's description here.
 * Creation date: (02.08.2005 15:11:11)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplectvbp() {
	return complectvbp;
}
/**
 * Insert the method's description here.
 * Creation date: (02.08.2005 15:11:50)
 * @return java.lang.String
 */
public java.lang.String getComplectvbpname() {
	return complectvbpname;
}
public Enumeration getCurrencies() {
	try {
		CurrencyAccessBean bean = new CurrencyAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2005 16:15:51)
 * @return java.lang.String
 */
public java.lang.String getDocs() {
	return docs;
}
public int getDocument() {
	if(document.getInteger() != null)
		return document.getInteger().intValue();
	else
		return 0;
}
public Integer getDocumentId() {
	return document.getInteger();
}
public Enumeration getDocumentPositions()
	throws Exception
{
//	InternalWayBillPositionAccessBean fb = new InternalWayBillPositionAccessBean();
//	return fb.findDocPositionsByDocOrderByOrderAsc(getDocumentId());
	return /*super.getDocumentPositions()*/null;
}
public java.lang.String getDocumentState() {
	return documentState;
}
public String getDocumentstr() {
	if(document!=null)
		return document.getString();
	else
		return "";	
}
public static String getDocumentTypeName(DocumentAccessBean bean) {
	String type = messageRes.getMessage("label.document.unknown");

	try {
		type = com.hps.july.cdbc.objects.CDBCDocuments.getDocumentTypeName(new Integer(bean.getDocument()));
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}

	return type;
}
/**
 * Преобразование класса ошибки в строку, содержащую расшифровку ошибки.
 * Creation date: (24.09.2004 19:21:22)
 * @return java.lang.String
 * @param e org.apache.struts.action.ActionError
 */
public String getErrorText(ActionError e) {
   String  message = e.getKey();
    try {
	    message = getServlet().getResources().getMessage(e.getKey(), e.getValues());
    } catch (Exception ee) {
	    // Message not found
    }
	return message;
}
public Integer getExpeditionId() {
	return expedition.getInteger();
}
public String getExpeditionstr() {
	return expedition.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (02.09.2005 18:25:22)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getHeadercalcerrors() {
	return headercalcerrors;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 13:50:03)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdact() {
	return idact;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:37:16)
 * @return java.lang.String
 */
public java.lang.String getInsuranseMan() {
	return insuranseMan;
}
public boolean getIsautodoc() {
	return isautodoc;
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listInternalStorageInItems(getDocumentId(),new Integer(1));
	return rs.listIterator();
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getMio(int index) {
	checkSize(mio, index);
	return (PosVO)mio.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:14:33)
 * @return java.lang.String
 */
public java.lang.String getMucategtmp() {
	return mucategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:15:13)
 * @return java.lang.String
 */
public java.lang.String getMucnttmp() {
	return mucnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getMUCount() {
	return mio.size();
}
public String getMuJSData()
{
	try {
		Iterator it = getMUResourcesList();

		StringBuffer body = new StringBuffer();		
		body.append("var mujs = new Array(\r\n");
		
		while (it.hasNext()) {
			try {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				body.append("new Array(");
				body.append(ro.getColumn("resource").asString());
				body.append(", ");
				String categid = ro.getColumn("categid").asString();
				if(categid.equals(String.valueOf(MSU_IBP))){
					body.append("1");
				}else if(categid.equals(String.valueOf(MSU_USIL))){
					body.append("2");
				}else if(categid.equals(String.valueOf(MSU_INJ))){
					body.append("3");
				}
				
				body.append(", \"");
				body.append(ro.getColumn("model").asString());
				if(it.hasNext()) {
					body.append("\"), \r\n");
				} else {
					body.append("\") \r\n");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		body.append("); \r\n");

		
		return body.toString();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return "";
}
public java.util.Iterator getMUResourcesList() {
	int[] categs = new int[]{MSU_IBP,MSU_USIL,MSU_INJ};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:15:44)
 * @return java.lang.Integer
 */
public java.lang.Integer getMutypetmp() {
	return mutypetmp;
}
public Organization getOwner() {
	if(!owner.isEmpty() && owner.isOk()) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			return (Organization)bean.getEJBRef();
		} catch(Exception e) {}
	}
	return null;
}
public String getOwnercode() {
	return owner.getString();
}
public Integer getOwnerId() {
	return owner.getInteger();
}
public String getOwnername() {
	return owner.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 11:40:25)
 * @return java.util.Enumeration
 */
public Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getPio(int index) {
	checkSize(pio, index);
	return (PosVO)pio.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:31:52)
 * @return java.lang.String
 */
public java.lang.String getPocategtmp() {
	return pocategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:32:22)
 * @return java.lang.String
 */
public java.lang.String getPocnttmp() {
	return pocnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getPOCount() {
	return pio.size();
}
public String getPoJSData()
{
	try {
		Iterator it = getPOResourcesList();

		StringBuffer body = new StringBuffer();		
		body.append("var pojs = new Array(\r\n");
		
		while (it.hasNext()) {
			try {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				body.append("new Array(");
				body.append(ro.getColumn("resource").asString());
				body.append(", ");
				String categid = ro.getColumn("categid").asString();
				if(categid.equals(String.valueOf(BS_COND)) || categid.equals(String.valueOf(BSC_COND))){
					body.append("1");
				}else if(categid.equals(String.valueOf(BS_PAN_SIG)) || categid.equals(String.valueOf(BSC_PAN_SIG))){
					body.append("2");
				}else if(categid.equals(String.valueOf(BS_IST_PIT_UZO)) || categid.equals(String.valueOf(BSC_IST_PIT_UZO))){
					body.append("3");
				}else if(categid.equals(String.valueOf(BS_PR_UZO))){
					body.append("4");
				}
				
				body.append(", \"");
				body.append(ro.getColumn("model").asString());
				if(it.hasNext()) {
					body.append("\"), \r\n");
				} else {
					body.append("\") \r\n");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		body.append("); \r\n");

		
		return body.toString();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return "";
}
public java.util.Iterator getPOResourcesList() {
	int[] categs = new int[]{BS_COND,BSC_COND,BS_PAN_SIG,BSC_PAN_SIG,BS_IST_PIT_UZO,BSC_IST_PIT_UZO,BS_PR_UZO};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
public Position getPosition() {
	try {
		return (Position)constructPosition().getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public String getPositioncode() {
	return position.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 11:14:23)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:32:54)
 * @return java.lang.Integer
 */
public java.lang.Integer getPotypetmp() {
	return potypetmp;
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getPrio(int index) {
	checkSize(prio, index);
	return (PosVO)prio.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2005 17:13:23)
 * @return java.lang.String
 */
public java.lang.String getProcessState() {
	return processState;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 14:24:12)
 * @return java.lang.String
 */
public java.lang.String getProcnttmp() {
	return procnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getPROCount() {
	return prio.size();
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2005 14:51:25)
 * @return java.lang.String
 */
public java.lang.String getPropolicytmp() {
	return propolicytmp;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2005 13:57:24)
 * @return java.lang.String
 */
public java.lang.String getProtypetmp() {
	return protypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2005 15:18:09)
 * @return int
 */
public int getRefreshFields() {
	return refreshFields;
}
public String getRentercode() {
	return renter.getString();
}
public java.lang.String getRentername() {
	return rentername;
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getRip(int index) {
	checkSize(rip, index);
	return (PosVO)rip.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 17:05:44)
 * @return java.lang.String
 */
public java.lang.String getRpcnttmp() {
	return rpcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getRPCount() {
	return rip.size();
}
public java.util.Iterator getRPResourcesList() {
	int[] categs = new int[]{REP};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 17:04:56)
 * @return java.lang.String
 */
public java.lang.Integer getRptypetmp() {
	return rptypetmp;
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
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getSio(int index) {
	checkSize(sio, index);
	return (PosVO)sio.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:53:07)
 * @return java.lang.String
 */
public java.lang.String getSocategtmp() {
	return socategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:53:37)
 * @return java.lang.String
 */
public java.lang.String getSocnttmp() {
	return socnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getSOCount() {
	return sio.size();
}
public String getSoJSData()
{
	try {
		Iterator it = getSOResourcesList();

		StringBuffer body = new StringBuffer();		
		body.append("var sojs = new Array(\r\n");
		
		while (it.hasNext()) {
			try {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				body.append("new Array(");
				body.append(ro.getColumn("resource").asString());
				body.append(", ");
				String categid = ro.getColumn("categid").asString();
				if(categid.equals(String.valueOf(BS_SH)) || categid.equals(String.valueOf(BSC_SH))){
					body.append("1");
				}else if(categid.equals(String.valueOf(BS_AVR)) || categid.equals(String.valueOf(BSC_AVR))){
					body.append("2");
				}else if(categid.equals(String.valueOf(BSC_P_COM))){
					body.append("3");
				}
				
				body.append(", \"");
				body.append(ro.getColumn("model").asString());
				if(it.hasNext()) {
					body.append("\"), \r\n");
				} else {
					body.append("\") \r\n");
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
				break;
			}
		}
		body.append("); \r\n");

		
		return body.toString();
	} catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return "";
}
public java.util.Iterator getSOResourcesList() {
	int[] categs = new int[]{BS_SH,BS_AVR,BSC_P_COM};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:54:03)
 * @return java.lang.Integer
 */
public java.lang.Integer getSotypetmp() {
	return sotypetmp;
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCONTR;
}
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getStio(int index) {
	checkSize(stio, index);
	return (PosVO)stio.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getSTIOCount() {
	return stio.size();
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2005 15:51:09)
 * @return java.lang.Integer
 */
public java.lang.Integer getStoragemancode() {
	return storagemancode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2005 15:51:31)
 * @return java.lang.String
 */
public java.lang.String getStoragemanname() {
	return storagemanname;
}
/**
 * Insert the method's description here.
 * Creation date: (16.09.2005 11:48:50)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
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
/**
 * 
 * @return com.hps.july.inventory.formbean.BSVO[]
 */
public com.hps.july.inventory.formbean.PosVO getVbip(int index) {
	checkSize(vbip, index);
	return (PosVO)vbip.get(index);
}
/**
 * Insert the method's description here.
 * Creation date: (02.08.2005 15:10:00)
 * @return java.lang.String
 */
public java.lang.String getVbpcnttmp() {
	return vbpcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (31.05.2005 16:48:05)
 * @return int
 */
public int getVBPCount() {	
	return vbip.size();
}
public java.util.Iterator getVBPResourcesList() {
	int[] categs = new int[]{BS_BP_VIPR};
	CDBCResultSet rs = CDBCDictionaryObject.listContrItemsByCateg(categs);
	return rs.listIterator();
}
/**
 * Insert the method's description here.
 * Creation date: (02.08.2005 15:09:35)
 * @return java.lang.Integer
 */
public java.lang.Integer getVbptypetmp() {
	return vbptypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2005 17:05:02)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getWarnProc() {
	return warnProc;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	super.initRecord(request);
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	// blanknumber = "";
	blankindex = new StringAndIntegerProperty();
	blankindex.setInteger(new Integer(keyGen.getNextKey("tables.invcontracts")));
	blanknumber = blankindex.getString();
	blankdate = new StringAndSqlDateProperty();
	document = new StringAndIntegerProperty();
	documentState = "1";
	expedition = new StringAndIntegerProperty();
	owner = new StringAndIntegerProperty();
	ownername = "";
	position = new StringAndIntegerProperty();
	positionname = "";
	positionid = "";
	renter = new StringAndIntegerProperty();
	rentername = "";
	insuranseMan = "";
	isautodoc = false;
	processState = "";
	docs = "";
	storagemancode = new StringAndIntegerProperty();
	warnProc = Boolean.FALSE;
	storageplace = 0;
	complectbsname = "";
	complectacname = "";
	complectbpname = "";
	complectbaname = "";
	complectvbpname = "";
	complectsoname = "";
	complectponame = "";
	complectmuname = "";
	complectcdname = "";
	complectcbsname = "";
	complectcbpname = "";
	complectrpname = "";
	complectanname = "";
	complectaftname = "";
	complectproname = "";
	bis.clear();
	acc.clear();
	bip.clear();
	vbip.clear();
	bia.clear();
	sio.clear();
	pio.clear();
	mio.clear();
	cio.clear();
	cbis.clear();
	cbip.clear();
	rip.clear();	
	ain.clear();
	aif.clear();
	prio.clear();
	stio.clear();
	bstypetmp = new Integer(0);
	actypetmp = new Integer(0);
	bptypetmp = new Integer(0);
	vbptypetmp = new Integer(0);
	batypetmp = new Integer(0);
	sotypetmp = new Integer(0);
	potypetmp = new Integer(0);
	mutypetmp = new Integer(0);
	cdtypetmp = new Integer(0);
	cbstypetmp = new Integer(0);
	cbptypetmp = new Integer(0);
	rptypetmp = new Integer(0);
	antypetmp = new Integer(0);
	afttypetmp = new Integer(0);
	setAutodoc(false);
	
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2005 17:53:34)
 * @return boolean
 */
public boolean isAutodoc() {
	return autodoc;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2005 17:48:34)
 * @return boolean
 */
public boolean isValidDec(String value) {
	try{
		Double.parseDouble(value);
	}catch(NumberFormatException nfe){
		return false;
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2005 17:48:34)
 * @return boolean
 */
public boolean isValidInt(String value) {
	try{
		Integer.parseInt(value);
	}catch(NumberFormatException nfe){
		return false;
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 12:56:20)
 */
public void loadGroup(Integer id,int group,ArrayList array) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String sql = "select * from invcontractitems where idact=? and group=?";
		CDBCResultSet resbs = new CDBCResultSet();
		LinkedList params = new LinkedList();
		params.add(id);
		params.add(new Integer(group));
		resbs.executeQuery(sql, params.toArray());

		Iterator it2 = resbs.listIterator();
		while(it2.hasNext()) {
			PosVO row = new PosVO();
			
			CDBCRowObject ro2 = (CDBCRowObject)it2.next();

			Object o3 = ro2.getColumn("id").asObject();
			Integer idd = new Integer(((Number)o3).intValue());
			
			Object o = ro2.getColumn("resource").asObject();
			Integer type = new Integer(((Number)o).intValue());
			
			Object o2 = ro2.getColumn("quantity").asObject();
			Integer count = new Integer(((Number)o2).intValue());

			Object o4 = ro2.getColumn("position").asObject();
			int position = ((Number)o4).intValue();

			Object o5 = ro2.getColumn("categresource").asObject();
			int categresource = ((Number)o5).intValue();
			
			Integer complect = (Integer)(ro2.getColumn("complect").asObject());

			String fictSerial = ro2.getColumn("isfictserial").asString();

			try{
				EquipmentSetAccessBean eqa = new EquipmentSetAccessBean();
				eqa.setInitKey_storageplace(complect.intValue());
				eqa.refreshCopyHelper();

				row.setComplect(complect);
				row.setComplectname(com.hps.july.inventory.valueobject.EquipmentObject.getEquipmentSetName(eqa));
			}catch(javax.ejb.ObjectNotFoundException ex){
				row.setComplect(null);
				row.setComplectname("");
			}
			
			String serial = ro2.getColumn("serial").asString();

			if(group==4){
				java.math.BigDecimal beginvolt = (java.math.BigDecimal)(ro2.getColumn("beginvolt").asObject());	
				java.math.BigDecimal afterhour = (java.math.BigDecimal)(ro2.getColumn("afterhour").asObject());
				String comment = ro2.getColumn("comment").asString();
				
				row.setNote(beginvolt != null?beginvolt.toString():"");
				row.setRoomnumber(afterhour != null?afterhour.toString():"");
				row.setComment(comment);
			}else if(group==5 || group==6 || group==7 || group==8 || group==9|| group==10){
				String comment = ro2.getColumn("comment").asString();	
				String roomnumber = ro2.getColumn("roomnumber").asString();
				Integer categ = (Integer)(ro2.getColumn("categ").asObject());
				
				row.setCateg(categ);
				row.setNote(comment);
				row.setRoomnumber(roomnumber);
			}else if(group==14){
				java.math.BigDecimal ksv = (java.math.BigDecimal)(ro2.getColumn("ksv").asObject());
				Integer categ = (Integer)(ro2.getColumn("categ").asObject());
				String sector = ro2.getColumn("sector").asString();
				String gsm = ro2.getColumn("gsm").asString();
				
				row.setCateg(categ);
				row.setKsb(ksv!=null?ksv.toString():null);
				row.setSector(sector);
				row.setGsm(gsm);
			}else{
				String comment = ro2.getColumn("comment").asString();
				String note = ro2.getColumn("note").asString();		
				String roomnumber = ro2.getColumn("roomnumber").asString();
				if(group==13){
					roomnumber = ro2.getColumn("azimuth").asString();
				}else if(group==15 || group==16){
					try {
						conn = new JdbcConnection().getConnection();
						ps = conn.prepareStatement("select * from resources where resource=?");
						ps.setInt(1,type.intValue()); 
						rs = ps.executeQuery();
						if(rs.next()) {
							String typename = rs.getString("model");
							String categname = rs.getString("name");
							String policy = rs.getString("countpolicy");							
							row.setTypename(typename);
							row.setCategname(categname);
							row.setPolicy(policy);
						}
			
					}catch(Exception e) {
						e.printStackTrace(System.out);
					}finally{
	    				try{	
		   	 				if(rs!=null) rs.close(); 
		   	 				if(ps!=null) ps.close();
		   	 				if(conn!=null) conn.close();
	    				}catch(Exception exc){
		   	 				exc.printStackTrace(System.out);
	   	    			}
    				}
				}
				
				row.setNote(comment);
				row.setComment(note);
				row.setRoomnumber(roomnumber);
			}

			if(type.intValue()!=0){
				String sql2 = "select categid from categresources where resource = ?";
				CDBCResultSet selcat = new CDBCResultSet();
				LinkedList params2 = new LinkedList();
				params2.add(type);
				selcat.executeQuery(sql2, params2.toArray());
				Iterator it3 = selcat.listIterator();
				if(it3.hasNext()){
					CDBCRowObject ro3 = (CDBCRowObject)it3.next();
					Integer catg = (Integer)(ro3.getColumn("categid").asObject());
					row.setResourcecateg(catg.intValue());
				}
			}
			
			row.setId(idd);
			row.setType(type);			
			row.getCount().setInteger(count);						
			row.setPosition(position);
			row.setResourcecateg(categresource);
			row.setFictionSerial("Y".equals(fictSerial)?Boolean.TRUE:Boolean.FALSE);			
			row.setSn("Y".equals(fictSerial)?"с/н неизвестен":serial);
			
			Iterator iter = calcerrors.iterator();
			while(iter.hasNext()){
				String error = (String)iter.next();
				StringTokenizer st = new StringTokenizer(error,"@");
				int pos = new Integer(st.nextToken()).intValue();
								
				if(pos == position){
					String er = st.nextToken(); 
					row.getCalcerrors().add(er);
				}
			}
				
			array.add(row);

			
		}
	
}
public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	bis.clear();
	acc.clear();
	bip.clear();
	vbip.clear();
	bia.clear();
	sio.clear();
	pio.clear();
	mio.clear();
	cio.clear();
	cbis.clear();
	cbip.clear();
	rip.clear();	
	ain.clear();
	aif.clear();
	prio.clear();
	stio.clear();

	complectbsname = "";
	complectacname = "";
	complectbpname = "";
	complectbaname = "";
	complectvbpname = "";
	complectsoname = "";
	complectponame = "";
	complectmuname = "";
	complectcdname = "";
	complectcbsname = "";
	complectcbpname = "";
	complectrpname = "";
	complectanname = "";
	complectaftname = "";
	complectproname = "";
	
	processState = "";
	warnProc = Boolean.FALSE;
	
	Integer id = new Integer(0);

	if(request.getSession().getAttribute("idact")!=null){		
	 	id = (Integer)(request.getSession().getAttribute("idact"));
	}else if(request.getParameter("act")!=null){
		id = new Integer(request.getParameter("act"));
	}else{
		id = new Integer(getAct());
	}

	//System.out.println("**********id: "  + id);
	setAct(id.toString());
		
	LinkedList params = new LinkedList();
	String sql = "select * from invcontracts where id=?";
	params.add(id);
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sql, params.toArray());
	
	Iterator it = res.listIterator();
	if(it.hasNext()) {		
		CDBCRowObject ro = (CDBCRowObject)it.next();
		String insman = ro.getColumn("insuranceman").asString();		
		String state = ro.getColumn("state").asString();
		Integer pos = (Integer)(ro.getColumn("position").asObject());
		storageplace = pos.intValue();
		String org = ro.getColumn("organization").asString();		
		String bindex = ro.getColumn("orderindex").asString();		
		String bnumber = ro.getColumn("ordernumber").asString();		
		Object odate = ro.getColumn("date").asObject();
		java.sql.Date date = (java.sql.Date)odate;
		String documents = ro.getColumn("documents").asString();				
		String scontractor = ro.getColumn("contractor").asString();		
		Integer contractor = (Integer)ro.getColumn("contractor").asObject();
		Integer sman = (Integer)(ro.getColumn("sman").asObject());
		//Integer idact = (Integer)(ro.getColumn("id").asObject());

		/*LinkedList params2 = new LinkedList();
		String sql2 = "select * from invcontracts where id=?";
		params.add(id);
		CDBCResultSet res = new CDBCResultSet();
		res.executeQuery(sql, params.toArray());*/
		
		setIdact(id);
		setInsuranseMan(insman);
		setDocumentState(state);
		setOwnercode(org);
		if(bindex!=null && !"".equals(bindex)){
			blankindex.setInteger(new Integer(bindex));
		}else{
			blankindex.setInteger(id);
		}
		setBlanknumber(bnumber);
		setBlankdate(date);
		setDocs(documents);
		//setAutodoc(false);

		if(sman!=null){
			WorkerAccessBean wab = new WorkerAccessBean();
			wab.setInitKey_worker(sman.intValue());
			wab.refreshCopyHelper();
			setStoragemancode(sman);
			setStoragemanname(wab.getMan().getFullName());
		}	
		
		try {
		
			PositionAccessBean pab = new PositionAccessBean();
			pab.setInitKey_storageplace(pos.intValue());
			pab.refreshCopyHelper();
			setPositioncode(String.valueOf(pab.getStorageplace()));
			setPositionname(pab.getName());
			positionid = "";
			if(pab.getGsmid() != null) {
				positionid = positionid + "D" + pab.getGsmid();
			}
			positionid = positionid + " ";
			if(pab.getDampsid() != null) {
				positionid = positionid + "A" + pab.getDampsid();
			}	
				
			if(contractor!=null){	
				OrganizationAccessBean oab = new OrganizationAccessBean();
				oab.setInitKey_organization(contractor.intValue());
				oab.refreshCopyHelper();
				setRentercode(scontractor);
				setRentername(oab.getName());
			}else{
				setRentercode("");
				setRentername("");
			}

			
		} catch(Exception e) {
			setPositioncode("");
			setPositionname("");
		}
		
		
		loadGroup(id,1,bis);
		loadGroup(id,2,bip);
		loadGroup(id,3,vbip);
		loadGroup(id,4,acc);
		loadGroup(id,5,bia);
		loadGroup(id,6,sio);
		loadGroup(id,7,pio);
		loadGroup(id,8,mio);
		loadGroup(id,9,cio);
		loadGroup(id,10,cbis);
		loadGroup(id,11,cbip);
		loadGroup(id,12,rip);
		loadGroup(id,13,ain);
		loadGroup(id,14,aif);
		loadGroup(id,15,prio);
		loadGroup(id,16,stio);
	}

	
	
}
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors)
	throws Exception
{
	Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps2 = null;
   
    try {
        conn = new JdbcConnection().getConnection();

        ps = conn.prepareStatement("delete from invcontracts where id=?");
        ps2 = conn.prepareStatement("delete from invcontractitems where idact=?");

        ps.setString(1, getAct());
        ps2.setString(1, getAct());
        
        ps.execute();
        ps2.execute();
        

    } catch (Exception e) {
        e.printStackTrace(System.out);
    } finally {
        try {
            if (ps != null)  ps.close();
            if (ps2 != null)  ps2.close();
            if (conn != null)  conn.close();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
	
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2005 19:05:18)
 * @param doc int
 */
public void processDocument(int id,Connection conn,ActionErrors errors) {
    PreparedStatement ps3 = null;
    PreparedStatement ps4 = null;
	ResultSet rs = null;
	ResultSet rs2 = null;

	ArrayList calc = new ArrayList();
	ProcessorFacadeAccessBean processor = new ProcessorFacadeAccessBean();	
    ActionError e;
    try {

		ps3 = conn.prepareStatement("update invcontracts set state = ? where id = ?");
        ps4 = conn.prepareStatement("select documents from invcontracts where id = ?");
	    
        ps4.setInt(1, id);
        rs = ps4.executeQuery();
        if(rs.next()){
        	String docs = rs.getString(1);

        	boolean wp = warnProc != null && warnProc.booleanValue();
        	if ("P".equals(getProcessState())) {

            	if (docs != null) {
                	StringTokenizer st = new StringTokenizer(docs, ",");

                	while (st.hasMoreTokens()) {
	                	//System.out.println("+++begin");
	                	//System.out.println("****docs: " + docs);
                    	processor.processDocument(new Integer(st.nextToken()), false, wp);
                    	//System.out.println("+++end");
                	}

                	ps3.setString(1, "2");
                	ps3.setInt(2, id);
                	ps3.execute();

                	warnProc = null;
                	setAction("View");
            	}
        	} else if ("C".equals(getProcessState())) {

                if (docs != null) {
                    StringTokenizer st = new StringTokenizer(docs, ",");

                    setAction("View");
                    while (st.hasMoreTokens()) {
	                    Integer d = new Integer(st.nextToken());
	                    //System.out.println("+++begincancel");
                        processor.cancelDocument(d);
                        //System.out.println("+++endcancel");
                        deleteDocument(d,errors);
                    }
                    setAction("Edit");

                    ps3.setString(1, "1");
                    ps3.setInt(2, id);
                    ps3.execute();
                }

        	}
        }
    }catch (DocumentProcessingException dex) {	    

	    //System.out.println("+++++++DocumentProcessingException!!!");
		
	    processState = "C";
		ArrayList list = dex.getPositionErrors();
		if(list == null)
			return;
		java.util.Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object o = it.next(); 
			if(!(o instanceof ProcessingPositionError)) {
				continue;
			}
			ProcessingPositionError er = (ProcessingPositionError)o;
			e = translateProcessingErrors(er);
		}

		setAutodoc(true);
		
		try{
		rs2 = ps4.executeQuery();    
		if(rs2.next()){
        	String docs = rs2.getString(1);
        	if (docs != null) {
                    StringTokenizer st = new StringTokenizer(docs, ",");
                    
                    while (st.hasMoreTokens()) {
	                    Integer d = new Integer(st.nextToken());
                        processor.cancelDocument(d);
                        deleteDocument(d,errors);
                    }
                    
                }
		}
	    }catch(Exception ex){
	    }
        
    }catch (Exception ex) {
	    //System.out.println("+++++++Exception!!!");
        ex.printStackTrace(System.out);        
    }finally {
        try {        
	        if(rs!=null) rs.close(); 
            if(ps3 != null)  ps3.close();
            if(ps4 != null)  ps4.close();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }    
    
}
public String processInsert(javax.servlet.http.HttpServletRequest request,ActionErrors errors)    throws Exception {
    Connection conn = null;
    PreparedStatement ps = null;

    ArrayList complects = new ArrayList();
    Integer complecttemp = null;
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    int id = keyGen.getNextKey("tables.invcontracts");

    try {
        conn = new JdbcConnection().getConnection();

        ps =
            conn.prepareStatement("insert into invcontracts values(?,?,?,?,?,?,?,?,?,?,?)");

        ps.setInt(1, id);
        ps.setInt(2, getOwnerId().intValue());
        ps.setInt(3, new Integer(getPositioncode()).intValue());
        ps.setDate(4, getBlankdate());
        ps.setInt(5, getBlankindex());
        ps.setString(6, getBlanknumber());
        ps.setInt(7, new Integer(getRentercode()).intValue());
        ps.setString(8, getInsuranseMan());
        ps.setString(9, "1");
        ps.setInt(11, getStoragemancode().intValue());

        int position = 1;
        //Создание бс
        for (int i = 0; i < bis.size(); i++) {
            if (bis.get(i) != null
                && ((PosVO) bis.get(i)).getType() != null
                && ((PosVO) bis.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, bis, conn, 1, keyGen);
                position++;
                complecttemp = ((PosVO) bis.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }
        //Создание ист пит базовой станции
        for (int i = 0; i < bip.size(); i++) {
            if (bip.get(i) != null
                && ((PosVO) bip.get(i)).getType() != null
                && ((PosVO) bip.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, bip, conn, 2, keyGen);
                position++;
                complecttemp = ((PosVO) bip.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание выпрям ист пит базовой станции
        for (int i = 0; i < vbip.size(); i++) {
            if (vbip.get(i) != null
                && ((PosVO) vbip.get(i)).getType() != null
                && ((PosVO) vbip.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, vbip, conn, 3, keyGen);
                position++;
                complecttemp = ((PosVO) vbip.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание акк баз станций
        for (int i = 0; i < acc.size(); i++) {
            if (acc.get(i) != null
                && ((PosVO) acc.get(i)).getType() != null
                && ((PosVO) acc.get(i)).getType().intValue() != -1) {
                createAccRow(i, id, position, acc, conn, 4, keyGen);
                position++;
                complecttemp = ((PosVO) acc.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание блока преобразования аварий
        for (int i = 0; i < bia.size(); i++) {
            if (bia.get(i) != null
                && ((PosVO) bia.get(i)).getType() != null
                && ((PosVO) bia.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, bia, conn, 5, keyGen);
                position++;
                complecttemp = ((PosVO) bia.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание силового оборудования
        for (int i = 0; i < sio.size(); i++) {
            if (sio.get(i) != null
                && ((PosVO) sio.get(i)).getType() != null
                && ((PosVO) sio.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, sio, conn, 6, keyGen);
                position++;
                complecttemp = ((PosVO) sio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание прочего оборудования
        for (int i = 0; i < pio.size(); i++) {
            if (pio.get(i) != null
                && ((PosVO) pio.get(i)).getType() != null
                && ((PosVO) pio.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, pio, conn, 7, keyGen);
                position++;
                complecttemp = ((PosVO) pio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Малошумящий усилитель
        for (int i = 0; i < mio.size(); i++) {
            if (mio.get(i) != null
                && ((PosVO) mio.get(i)).getType() != null
                && ((PosVO) mio.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, mio, conn, 8, keyGen);
                position++;
                complecttemp = ((PosVO) mio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Комбайнеры делители
        for (int i = 0; i < cio.size(); i++) {
            if (cio.get(i) != null
                && ((PosVO) cio.get(i)).getType() != null
                && ((PosVO) cio.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, cio, conn, 9, keyGen);
                position++;
                complecttemp = ((PosVO) cio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Аппаратура контроллера базовых станций
        for (int i = 0; i < cbis.size(); i++) {
            if (cbis.get(i) != null
                && ((PosVO) cbis.get(i)).getType() != null
                && ((PosVO) cbis.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, cbis, conn, 10, keyGen);
                position++;
                complecttemp = ((PosVO) cbis.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание ист пит контроллера базовой станции
        for (int i = 0; i < cbip.size(); i++) {
            if (cbip.get(i) != null
                && ((PosVO) cbip.get(i)).getType() != null
                && ((PosVO) cbip.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, cbip, conn, 11, keyGen);
                position++;
                complecttemp = ((PosVO) cbip.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Репитер

        for (int i = 0; i < rip.size(); i++) {
            if (rip.get(i) != null
                && ((PosVO) rip.get(i)).getType() != null
                && ((PosVO) rip.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, rip, conn, 12, keyGen);
                position++;
                complecttemp = ((PosVO) rip.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Антенны

        for (int i = 0; i < ain.size(); i++) {
            if (ain.get(i) != null
                && ((PosVO) ain.get(i)).getType() != null
                && ((PosVO) ain.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, ain, conn, 13, keyGen);
                position++;
                complecttemp = ((PosVO) ain.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //кабели
        for (int i = 0; i < aif.size(); i++) {
            if (aif.get(i) != null
                && ((PosVO) aif.get(i)).getType() != null
                && ((PosVO) aif.get(i)).getType().intValue() != -1) {
                createAftRow(i, id, position, aif, conn, 14, keyGen);
                position++;
                complecttemp = ((PosVO) aif.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //прочее оборудование
        for (int i = 0; i < prio.size(); i++) {
            if (prio.get(i) != null
                && ((PosVO) prio.get(i)).getTypename() != null) {
                createRow(i, id, position, prio, conn, 15, keyGen);
                position++;
                complecttemp = ((PosVO) prio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }
        
        setAct(String.valueOf(id));

        headercalcerrors.clear();
        calcerrors.clear();        

        ps.setString(10, "");
        ps.execute();

    } catch (Exception e) {
        e.printStackTrace(System.out);
    } finally {
        try {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    return null;
}
public String processUpdate(
    javax.servlet.http.HttpServletRequest request,
    ActionErrors errors)
    throws Exception {

    ArrayList complects = new ArrayList();
    Integer complecttemp = null;
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps4 = null;

    int id = getIdact().intValue();
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();

    try {
        conn = new JdbcConnection().getConnection();

        StringBuffer sb = new StringBuffer();
        sb.append("update invcontracts set organization = ?,");
        sb.append(
            "position = ?,date = ?,orderindex = ?,ordernumber = ?,contractor = ?,");
        sb.append("insuranceman = ?,state = ?,documents=?,sman=? where id = ?");

        ps = conn.prepareStatement(sb.toString());
        ps.setInt(1, getOwnerId().intValue());
        ps.setInt(2, new Integer(getPositioncode()).intValue());
        ps.setDate(3, getBlankdate());
        ps.setInt(4, getBlankindex());
        ps.setString(5, getBlanknumber());
        ps.setInt(6, new Integer(getRentercode()).intValue());
        ps.setString(7, getInsuranseMan());
        ps.setString(8, "1");
        ps.setInt(10, getStoragemancode().intValue());
        ps.setInt(11, id);

		ps4 = conn.prepareStatement("select documents from invcontracts where id = ?");
        
        ps2 = conn.prepareStatement("delete from invcontractitems where idact=? and group <> 16");
        ps2.setInt(1, id);
        ps2.execute();

        int position = 1;
        //Создание бс
        for (int i = 0; i < bis.size(); i++) {
            if (bis.get(i) != null
                && ((PosVO) bis.get(i)).getType() != null
                && ((PosVO) bis.get(i)).getType().intValue() != -1) {	              
                createRow(i, id, position, bis, conn, 1, keyGen);
                position++;
                complecttemp = ((PosVO) bis.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание ист пит базовой станции
        for (int i = 0; i < bip.size(); i++) {
            if (bip.get(i) != null
                && ((PosVO) bip.get(i)).getType() != null
                && ((PosVO) bip.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, bip, conn, 2, keyGen);
                position++;
                complecttemp = ((PosVO) bip.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание выпрям ист пит базовой станции
        for (int i = 0; i < vbip.size(); i++) {
            if (vbip.get(i) != null
                && ((PosVO) vbip.get(i)).getType() != null
                && ((PosVO) vbip.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, vbip, conn, 3, keyGen);
                position++;
                complecttemp = ((PosVO) vbip.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание акк баз станций
        for (int i = 0; i < acc.size(); i++) {
            if (acc.get(i) != null
                && ((PosVO) acc.get(i)).getType() != null
                && ((PosVO) acc.get(i)).getType().intValue() != -1) {
                createAccRow(i, id, position, acc, conn, 4, keyGen);
                position++;
                complecttemp = ((PosVO) acc.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание блока преобразования аварий
        for (int i = 0; i < bia.size(); i++) {
            if (bia.get(i) != null
                && ((PosVO) bia.get(i)).getType() != null
                && ((PosVO) bia.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, bia, conn, 5, keyGen);
                position++;
                complecttemp = ((PosVO) bia.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание силового оборудования
        for (int i = 0; i < sio.size(); i++) {
            if (sio.get(i) != null
                && ((PosVO) sio.get(i)).getType() != null
                && ((PosVO) sio.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, sio, conn, 6, keyGen);
                position++;
                complecttemp = ((PosVO) sio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание прочего оборудования
        for (int i = 0; i < pio.size(); i++) {
            if (pio.get(i) != null
                && ((PosVO) pio.get(i)).getType() != null
                && ((PosVO) pio.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, pio, conn, 7, keyGen);
                position++;
                complecttemp = ((PosVO) pio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Малошумящий усилитель
        for (int i = 0; i < mio.size(); i++) {
            if (mio.get(i) != null
                && ((PosVO) mio.get(i)).getType() != null
                && ((PosVO) mio.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, mio, conn, 8, keyGen);
                position++;
                complecttemp = ((PosVO) mio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Комбайнеры делители
        for (int i = 0; i < cio.size(); i++) {
            if (cio.get(i) != null
                && ((PosVO) cio.get(i)).getType() != null
                && ((PosVO) cio.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, cio, conn, 9, keyGen);
                position++;
                complecttemp = ((PosVO) cio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Аппаратура контроллера базовых станций
        for (int i = 0; i < cbis.size(); i++) {
            if (cbis.get(i) != null
                && ((PosVO) cbis.get(i)).getType() != null
                && ((PosVO) cbis.get(i)).getType().intValue() != -1) {
                createBpaRow(i, id, position, cbis, conn, 10, keyGen);
                position++;
                complecttemp = ((PosVO) cbis.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Создание ист пит контроллера базовой станции
        for (int i = 0; i < cbip.size(); i++) {
            if (cbip.get(i) != null
                && ((PosVO) cbip.get(i)).getType() != null
                && ((PosVO) cbip.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, cbip, conn, 11, keyGen);
                position++;
                complecttemp = ((PosVO) cbip.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Репитер
        for (int i = 0; i < rip.size(); i++) {
            if (rip.get(i) != null
                && ((PosVO) rip.get(i)).getType() != null
                && ((PosVO) rip.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, rip, conn, 12, keyGen);
                position++;
                complecttemp = ((PosVO) rip.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //Антенны
        for (int i = 0; i < ain.size(); i++) {
            if (ain.get(i) != null
                && ((PosVO) ain.get(i)).getType() != null
                && ((PosVO) ain.get(i)).getType().intValue() != -1) {
                createRow(i, id, position, ain, conn, 13, keyGen);
                position++;
                complecttemp = ((PosVO) ain.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //кабели
        for (int i = 0; i < aif.size(); i++) {
            if (aif.get(i) != null
                && ((PosVO) aif.get(i)).getType() != null
                && ((PosVO) aif.get(i)).getType().intValue() != -1) {
                createAftRow(i, id, position, aif, conn, 14, keyGen);
                position++;
                complecttemp = ((PosVO) aif.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //прочее оборудование
        for (int i = 0; i < prio.size(); i++) {
            if (prio.get(i) != null
                && ((PosVO) prio.get(i)).getTypename() != null) {
                createRow(i, id, position, prio, conn, 15, keyGen);
                position++;
                complecttemp = ((PosVO) prio.get(i)).getComplect();
                if (!complects.contains(complecttemp))
                    complects.add(complecttemp);
            }
        }

        //----------------------------------
        headercalcerrors.clear();
        calcerrors.clear();
        request.getSession().removeAttribute("xlserrors");
        //----------------------------------

        String sdocs = "";
        ps4.setInt(1, id);
        ResultSet rs5 = ps4.executeQuery();
        if(rs5.next()){
	        sdocs = rs5.getString(1);
        }
        		
        if (("View".equals(getAction()) || "Edit".equals(getAction()))
            && getProcessState() != null  && !"".equals(getProcessState())) {
	         
            //-----------create documents

			if("P".equals(getProcessState())){
        		 
				/*if (!sdocs.equals("")) {
                	StringTokenizer st = new StringTokenizer(sdocs, ",");
				
               	 	while (st.hasMoreTokens()) {
                    	String ndoc = st.nextToken();
                    	if (!ndoc.equals("")) {
                       	 	deleteDocument(new Integer(ndoc).intValue());
                    	}
                	}

            	}*/	
            	sdocs = "";
            	Iterator iter = complects.iterator();
            	while (iter.hasNext()) {
                	int doc = keyGen.getNextKey("tables.documents");
                	int index = keyGen.getNextKey("tables.i13nactnumber");

                	Integer complect = (Integer) iter.next();

                	constructDocuments(doc, complect, index);
                	constructDocPositions(doc, complect, bis);
                	constructDocPositions(doc, complect, bip);
                	constructDocPositions(doc, complect, vbip);
                	constructDocPositions(doc, complect, acc);
                	constructDocPositions(doc, complect, bia);
                	constructDocPositions(doc, complect, sio);
                	constructDocPositions(doc, complect, pio);
                	constructDocPositions(doc, complect, mio);
                	constructDocPositions(doc, complect, cio);
                	constructDocPositions(doc, complect, cbis);
                	constructDocPositions(doc, complect, cbip);
                	constructDocPositions(doc, complect, rip);
                	constructDocPositions(doc, complect, ain);
                	constructDocPositions(doc, complect, aif);
                	constructDocPositions(doc, complect, prio);
                	constructDocPositions(doc, complect, stio);

 	                sdocs = sdocs +"," + doc + ",";
            	}
            
			}
        }   
        
            
        ps.setString(9, sdocs);
        ps.execute();

         
        if (("View".equals(getAction()) || "Edit".equals(getAction()))
            && getProcessState() != null  && !"".equals(getProcessState())) {
	          processDocument(id,conn,errors);  
        }

    } catch (Exception e) {
        e.printStackTrace(System.out);
    } finally {
        try {
            if(ps != null) ps.close();
            if(ps2 != null) ps2.close();   
            if(ps4 != null) ps4.close(); 
            if(conn != null) conn.close();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    return null;

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
 * Creation date: (30.08.2005 14:05:41)
 * @param newAct java.lang.String
 */
public void setAct(java.lang.String newAct) {
	act = newAct;
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
 * Creation date: (23.08.2005 15:53:55)
 * @param newAftcategtmp java.lang.String
 */
public void setAftcategtmp(java.lang.String newAftcategtmp) {
	aftcategtmp = newAftcategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:52:56)
 * @param newAftcnttmp java.lang.String
 */
public void setAftcnttmp(java.lang.String newAftcnttmp) {
	aftcnttmp = newAftcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:54:39)
 * @param newAfttypetmp java.lang.Integer
 */
public void setAfttypetmp(java.lang.Integer newAfttypetmp) {
	afttypetmp = newAfttypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 12:52:35)
 * @param newAncnttmp java.lang.String
 */
public void setAncnttmp(java.lang.String newAncnttmp) {
	ancnttmp = newAncnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 12:53:24)
 * @param newAntypetmp java.lang.Integer
 */
public void setAntypetmp(java.lang.Integer newAntypetmp) {
	antypetmp = newAntypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2005 17:53:34)
 * @param newAutodoc boolean
 */
public void setAutodoc(boolean newAutodoc) {
	autodoc = newAutodoc;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 12:06:35)
 * @param newBacategtmp java.lang.String
 */
public void setBacategtmp(java.lang.String newBacategtmp) {
	bacategtmp = newBacategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 11:01:36)
 * @param newBacnttmp java.lang.String
 */
public void setBacnttmp(java.lang.String newBacnttmp) {
	bacnttmp = newBacnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 10:59:32)
 * @param newBatypetmp java.lang.Integer
 */
public void setBatypetmp(java.lang.Integer newBatypetmp) {
	batypetmp = newBatypetmp;
}
public void setBlankdate(java.sql.Date newDate) {
	blankdate.setSqlDate(newDate);
}
public void setBlankdatestr(String newBlankdate) {
	blankdate.setString(newBlankdate);
}
public void setBlankindex(int newBlankindex) {
	blankindex.setInteger(new Integer(newBlankindex));
}
public void setBlankindexFrm(String newBlankindex) {
	if(blankindex!=null){
		blankindex.setString(newBlankindex);
	}
}
public void setBlanknumber(String newNumber) {
	blanknumber = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 16:44:19)
 * @param newBpcnttmp java.lang.String
 */
public void setBpcnttmp(java.lang.String newBpcnttmp) {
	bpcnttmp = newBpcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 16:48:31)
 * @param newBptypetmp java.lang.Integer
 */
public void setBptypetmp(java.lang.Integer newBptypetmp) {
	bptypetmp = newBptypetmp;
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
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:13:19)
 * @param newCbpcategtmp java.lang.String
 */
public void setCbpcategtmp(java.lang.String newCbpcategtmp) {
	cbpcategtmp = newCbpcategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:13:56)
 * @param newCbpcnttmp java.lang.String
 */
public void setCbpcnttmp(java.lang.String newCbpcnttmp) {
	cbpcnttmp = newCbpcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:14:42)
 * @param newCbptypetmp java.lang.Integer
 */
public void setCbptypetmp(java.lang.Integer newCbptypetmp) {
	cbptypetmp = newCbptypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:55:36)
 * @param newCbscategtmp java.lang.String
 */
public void setCbscategtmp(java.lang.String newCbscategtmp) {
	cbscategtmp = newCbscategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:56:03)
 * @param newCbscnttmp java.lang.String
 */
public void setCbscnttmp(java.lang.String newCbscnttmp) {
	cbscnttmp = newCbscnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:56:56)
 * @param newCbstypetmp java.lang.Integer
 */
public void setCbstypetmp(java.lang.Integer newCbstypetmp) {
	cbstypetmp = newCbstypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:22:00)
 * @param newCdcategtmp java.lang.String
 */
public void setCdcategtmp(java.lang.String newCdcategtmp) {
	cdcategtmp = newCdcategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:22:32)
 * @param newCdcnttmp java.lang.String
 */
public void setCdcnttmp(java.lang.String newCdcnttmp) {
	cdcnttmp = newCdcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:22:56)
 * @param newCdtypetmp java.lang.Integer
 */
public void setCdtypetmp(java.lang.Integer newCdtypetmp) {
	cdtypetmp = newCdtypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 10:45:38)
 * @param newComplectac java.lang.Integer
 */
public void setComplectac(java.lang.Integer newComplectac) {
	complectac = newComplectac;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 10:44:44)
 * @param newComplectacname java.lang.String
 */
public void setComplectacname(java.lang.String newComplectacname) {
	complectacname = newComplectacname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:57:38)
 * @param newComplectaft java.lang.Integer
 */
public void setComplectaft(java.lang.Integer newComplectaft) {
	complectaft = newComplectaft;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:58:01)
 * @param newComplectaftname java.lang.String
 */
public void setComplectaftname(java.lang.String newComplectaftname) {
	complectaftname = newComplectaftname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 12:54:54)
 * @param newComplectan java.lang.Integer
 */
public void setComplectan(java.lang.Integer newComplectan) {
	complectan = newComplectan;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2005 12:55:14)
 * @param newComplectanname java.lang.String
 */
public void setComplectanname(java.lang.String newComplectanname) {
	complectanname = newComplectanname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 11:03:58)
 * @param newComplectba java.lang.Integer
 */
public void setComplectba(java.lang.Integer newComplectba) {
	complectba = newComplectba;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2005 11:04:49)
 * @param newComplectbaname java.lang.String
 */
public void setComplectbaname(java.lang.String newComplectbaname) {
	complectbaname = newComplectbaname;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 16:51:20)
 * @param newComplectbp java.lang.Integer
 */
public void setComplectbp(java.lang.Integer newComplectbp) {
	complectbp = newComplectbp;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2005 16:50:55)
 * @param newComplectbpname java.lang.String
 */
public void setComplectbpname(java.lang.String newComplectbpname) {
	complectbpname = newComplectbpname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 18:02:58)
 * @param newComplect java.lang.Integer
 */
public void setComplectbs(java.lang.Integer newComplectbs) {
	complectbs = newComplectbs;
}
/**
 * Insert the method's description here.
 * Creation date: (27.07.2005 18:03:24)
 * @param newComplectname java.lang.String
 */
public void setComplectbsname(java.lang.String newComplectbsname) {
	complectbsname = newComplectbsname;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:18:04)
 * @param newComplectcbp java.lang.Integer
 */
public void setComplectcbp(java.lang.Integer newComplectcbp) {
	complectcbp = newComplectcbp;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 17:25:36)
 * @param newComplectcbpname java.lang.String
 */
public void setComplectcbpname(java.lang.String newComplectcbpname) {
	complectcbpname = newComplectcbpname;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:58:31)
 * @param newComplectcbs java.lang.Integer
 */
public void setComplectcbs(java.lang.Integer newComplectcbs) {
	complectcbs = newComplectcbs;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 14:59:15)
 * @param newComplectcbsname java.lang.String
 */
public void setComplectcbsname(java.lang.String newComplectcbsname) {
	complectcbsname = newComplectcbsname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:54:46)
 * @param newComplectcd java.lang.Integer
 */
public void setComplectcd(java.lang.Integer newComplectcd) {
	complectcd = newComplectcd;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 17:55:05)
 * @param newComplectcdname java.lang.String
 */
public void setComplectcdname(java.lang.String newComplectcdname) {
	complectcdname = newComplectcdname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:40:05)
 * @param newComplectmu java.lang.Integer
 */
public void setComplectmu(java.lang.Integer newComplectmu) {
	complectmu = newComplectmu;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:40:32)
 * @param newComplectmuname java.lang.String
 */
public void setComplectmuname(java.lang.String newComplectmuname) {
	complectmuname = newComplectmuname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:50:13)
 * @param newComplectpo java.lang.Integer
 */
public void setComplectpo(java.lang.Integer newComplectpo) {
	complectpo = newComplectpo;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:50:38)
 * @param newComplectponame java.lang.String
 */
public void setComplectponame(java.lang.String newComplectponame) {
	complectponame = newComplectponame;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 14:25:17)
 * @param newComplectpro java.lang.Integer
 */
public void setComplectpro(java.lang.Integer newComplectpro) {
	complectpro = newComplectpro;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 14:25:38)
 * @param newComplectproname java.lang.String
 */
public void setComplectproname(java.lang.String newComplectproname) {
	complectproname = newComplectproname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 17:16:06)
 * @param newComplectrp java.lang.Integer
 */
public void setComplectrp(java.lang.Integer newComplectrp) {
	complectrp = newComplectrp;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 17:16:36)
 * @param newComplectrpname java.lang.String
 */
public void setComplectrpname(java.lang.String newComplectrpname) {
	complectrpname = newComplectrpname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:57:39)
 * @param newComplectso java.lang.Integer
 */
public void setComplectso(java.lang.Integer newComplectso) {
	complectso = newComplectso;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:58:18)
 * @param newComplectsoname java.lang.String
 */
public void setComplectsoname(java.lang.String newComplectsoname) {
	complectsoname = newComplectsoname;
}
/**
 * Insert the method's description here.
 * Creation date: (02.08.2005 15:11:11)
 * @param newComplectvbp java.lang.Integer
 */
public void setComplectvbp(java.lang.Integer newComplectvbp) {
	complectvbp = newComplectvbp;
}
/**
 * Insert the method's description here.
 * Creation date: (02.08.2005 15:11:50)
 * @param newComplectvbpname java.lang.String
 */
public void setComplectvbpname(java.lang.String newComplectvbpname) {
	complectvbpname = newComplectvbpname;
}
/**
 * Insert the method's description here.
 * Creation date: (31.08.2005 16:15:51)
 * @param newDocs java.lang.String
 */
public void setDocs(java.lang.String newDocs) {
	docs = newDocs;
}
public void setDocument(int newDocument) {
	if(document!=null){
		document.setInteger(new Integer(newDocument));
	}
}
public void setDocumentState(java.lang.String newDocumentState) {
	documentState = newDocumentState;
}
public void setDocumentstr(String newDocument) {
	document.setString(newDocument);
}
public void setExpeditionstr(String newDocument) {
	expedition.setString(newDocument);
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2005 13:50:03)
 * @param newIdact java.lang.Integer
 */
public void setIdact(java.lang.Integer newIdact) {
	idact = newIdact;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2005 15:37:16)
 * @param newInsuranseMan java.lang.String
 */
public void setInsuranseMan(java.lang.String newInsuranseMan) {
	insuranseMan = newInsuranseMan;
}
public void setIsautodoc(boolean newIsautodoc) {
	isautodoc = newIsautodoc;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:14:33)
 * @param newMucategtmp java.lang.String
 */
public void setMucategtmp(java.lang.String newMucategtmp) {
	mucategtmp = newMucategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:15:13)
 * @param newMucnttmp java.lang.String
 */
public void setMucnttmp(java.lang.String newMucnttmp) {
	mucnttmp = newMucnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:15:44)
 * @param newMutypetmp java.lang.Integer
 */
public void setMutypetmp(java.lang.Integer newMutypetmp) {
	mutypetmp = newMutypetmp;
}
public void setOwnercode(String newNumber) {
	owner.setString(newNumber);
}
public void setOwnername(String newName) {
	ownername = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:31:52)
 * @param newPocategtmp java.lang.String
 */
public void setPocategtmp(java.lang.String newPocategtmp) {
	pocategtmp = newPocategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:32:22)
 * @param newPocnttmp java.lang.String
 */
public void setPocnttmp(java.lang.String newPocnttmp) {
	pocnttmp = newPocnttmp;
}
public void setPosition(PositionAccessBean pos) {
	try {
		position.setInteger(new Integer(pos.getStorageplace()));
		positionname = pos.getName();
		positionid = "";
		if(pos.getGsmid() != null) {
			positionid = positionid + "D" + pos.getGsmid();
		}
		positionid = positionid + " ";
		if(pos.getDampsid() != null) {
			positionid = positionid + "A" + pos.getDampsid();
		}
	} catch(Exception e) {
		positionname = "";
		positionid = "";
	}
}
public void setPositioncode(String newPosition) {
	position.setString(newPosition);
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 11:14:23)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:46:27)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 11:32:54)
 * @param newPotypetmp java.lang.Integer
 */
public void setPotypetmp(java.lang.Integer newPotypetmp) {
	potypetmp = newPotypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2005 17:13:23)
 * @param newProcessState java.lang.String
 */
public void setProcessState(java.lang.String newProcessState) {
	processState = newProcessState;
}
/**
 * Insert the method's description here.
 * Creation date: (06.09.2005 14:24:12)
 * @param newProcnttmp java.lang.String
 */
public void setProcnttmp(java.lang.String newProcnttmp) {
	procnttmp = newProcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2005 14:51:25)
 * @param newPropolicytmp java.lang.String
 */
public void setPropolicytmp(java.lang.String newPropolicytmp) {
	propolicytmp = newPropolicytmp;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2005 13:57:24)
 * @param newProtypetmp java.lang.String
 */
public void setProtypetmp(java.lang.String newProtypetmp) {
	protypetmp = newProtypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (07.09.2005 15:18:09)
 * @param newRefreshFields int
 */
public void setRefreshFields(int newRefreshFields) {
	refreshFields = newRefreshFields;
}
public void setRentercode(String newRenter) {
	renter.setString(newRenter);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 12:22:39)
 * @param newRentername java.lang.String
 */
public void setRentername(java.lang.String newRentername) {
	rentername = newRentername;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 17:05:44)
 * @param newRpcnttmp java.lang.String
 */
public void setRpcnttmp(java.lang.String newRpcnttmp) {
	rpcnttmp = newRpcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 17:04:56)
 * @param newRpcategtmp java.lang.String
 */
public void setRptypetmp(java.lang.Integer newRptypetmp) {
	rptypetmp = newRptypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:53:07)
 * @param newSocategtmp java.lang.String
 */
public void setSocategtmp(java.lang.String newSocategtmp) {
	socategtmp = newSocategtmp;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:53:37)
 * @param newSocnttmp java.lang.String
 */
public void setSocnttmp(java.lang.String newSocnttmp) {
	socnttmp = newSocnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2005 15:54:03)
 * @param newSotypetmp java.lang.Integer
 */
public void setSotypetmp(java.lang.Integer newSotypetmp) {
	sotypetmp = newSotypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2005 15:51:09)
 * @param newStoragemancode java.lang.Integer
 */
public void setStoragemancode(java.lang.Integer newStoragemancode) {	
	storagemancode.setInteger(newStoragemancode);
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2005 15:51:31)
 * @param newStoragemanname java.lang.String
 */
public void setStoragemanname(java.lang.String newStoragemanname) {
	storagemanname = newStoragemanname;
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
/**
 * Insert the method's description here.
 * Creation date: (02.08.2005 15:10:00)
 * @param newVbpcnttmp java.lang.String
 */
public void setVbpcnttmp(java.lang.String newVbpcnttmp) {
	vbpcnttmp = newVbpcnttmp;
}
/**
 * Insert the method's description here.
 * Creation date: (02.08.2005 15:09:35)
 * @param newVbptypetmp java.lang.Integer
 */
public void setVbptypetmp(java.lang.Integer newVbptypetmp) {
	vbptypetmp = newVbptypetmp;
}
/**
 * Insert the method's description here.
 * Creation date: (29.08.2005 17:05:02)
 * @param newWarnProc java.lang.Boolean
 */
public void setWarnProc(java.lang.Boolean newWarnProc) {
	warnProc = newWarnProc;
}
private ActionError translateProcessingErrors(ProcessingPositionError er)
{
	ActionError e;
	try {
		String param0,param1,param2,param3;
		int poscode = er.getPositionCode();
		int bpos = 0;
		StoragePlaceAccessBean storage = null;
		StoragePlaceAccessBean storageto = null;
		try {
			DocumentPositionAccessBean pos = new DocumentPositionAccessBean();
			pos.setInitKey_docposition(poscode);
			pos.refreshCopyHelper();
			bpos = pos.getOrder();

			//System.out.println("//////Позиция № "+pos.getOrder() + ": (" + pos.getResource().getResource());
			param0 = /*"Позиция № "+pos.getOrder() + ": (" + pos.getResource().getResource() + ")*/ "["+
				pos.getResource().getName()+", "+pos.getResource().getModel()+"]. ";
			storage = pos.getDocument().getFrom();
			storageto = pos.getDocument().getTo();
		} catch(Exception ex) {
			try {
				ChangeActPositionAccessBean pos = new ChangeActPositionAccessBean();
				pos.setInitKey_code(poscode);
				pos.refreshCopyHelper();
				bpos =  pos.getCode();
				ChangePositionValue pv = new ChangePositionValue(pos);
				param0 = /*"Позиция № "+pos.getCode()+":*/ "("+pv.getOres()+")"+ pv.getOresname()+", "+pv.getOresmodel()+". S/N:"+pv.getOldserial()+". ";
				storage = pos.getChangeAct().getFrom();
			} catch(Exception exc) {
				//log(exc);
				param0 = "";
			}
		}

		
		
		switch(er.getErrorCode()) {
		case ProcessingPositionError.ERRORS.BAD_AGREGATION_NOTEXISTS:
			param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
			/*
			if(er.getSerial() != null) {
				
				try {
					StorageCardAccessBean b = (new StorageCardAccessBean()).findBySerial(er.getSerial());
					param1 = b.getResource().getName() + " " + b.getResource().getModel()+" с/н "+er.getSerial();
				} catch(Exception exc) {
					param1 = "с/н "+er.getSerial();
				}
			}
			*/
			e = new ActionError("error.documentprocessing.bad_agregation_notexists",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.BAD_AGREGATION_NOTSUPPORTED:
			e = new ActionError("error.documentprocessing.bad_agregation_notsupported",param0);
			break;
		case ProcessingPositionError.ERRORS.BAD_AGREGATION_QTY:
			param1 = "";
			if(er.getQty() != null) {
				param1 = String.valueOf(er.getQty());
			}
			e = new ActionError("error.documentprocessing.bad_agregation_qty",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.BAD_AGREGATION:
			e = new ActionError("error.documentprocessing.bad_agregation",param0);
			break;
		case ProcessingPositionError.ERRORS.CARD_ALREADY_EXISTS:
			param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
			param2 = CDBCStoragecardsObject.findStorageNameBySerial(er.getSerial());
			/*
			if(er.getSerial() != null) {
				try {
					StorageCardAccessBean b = (new StorageCardAccessBean()).findBySerial(er.getSerial());
					param1 = b.getResource().getName() + " " + b.getResource().getModel()+" с/н "+er.getSerial();
					param2 = " "+getSpname(b.getCurrentstorage());
				} catch(Exception exc) {
					param1 = "с/н "+er.getSerial();
				}
			}
			*/
			e = new ActionError("error.documentprocessing.card_already_exists",param0,param1,param2);
			break;
		case ProcessingPositionError.ERRORS.CARD_CLOSED:
			e = new ActionError("error.documentprocessing.card_closed",param0);
			break;
		case ProcessingPositionError.ERRORS.UNKNOWN_POLICY:
			param1 = "";
			try {
				ResourceAccessBean rb = new ResourceAccessBean();
				rb.setInitKey_resource(er.getResource());
				rb.refreshCopyHelper();
				param1 = "Ресурс: " + rb.getModel() + " " +rb.getName();
			} catch (Exception ee) {					
			}
			e = new ActionError("error.documentprocessing.unknownpolicy",param0, param1);
			break;
		case ProcessingPositionError.ERRORS.INVENTARIZATION_BEFORE:
			param1 = "Код:"+er.getI13nAct();
			if(er.getI13nAct() > 0) {
				try {
					I13nActAccessBean bean = new I13nActAccessBean();
					bean.setInitKey_document(er.getI13nAct());
					bean.refreshCopyHelper();
					param1 = "№ "+bean.getBlankindex();
					if(bean.getBlanknumber() != null) {
						param1 += bean.getBlanknumber();
					}
					param1 += " от "+format.format(bean.getBlankdate());
				} catch(Exception e1) {
				}
			}
			e = new ActionError("error.documentprocessing.inventarization_before",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.NO_CARD:
			param1 = CDBCStoragecardsObject.findBySerial(er.getSerial()); //er.getSerial();
/*
			param2 = "";
			if(er.getSerial() != null) {
				try {
					StorageCardAccessBean b = (new StorageCardAccessBean()).findBySerial(er.getSerial());
					StoragePlaceAccessBean sp = b.getCurrentstorage();
					param2 = getSpname(sp);
				} catch(Exception exc) {
					param2 = "";
				}
			}
*/
			e = new ActionError("error.documentprocessing.no_card",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.NO_SUCH_PARTY:
			param1 = er.getParty();
			param2 = "";
			// @TODO: find storage
			e = new ActionError("error.documentprocessing.no_such_party",param0,param1,param2);
			break;
		case ProcessingPositionError.ERRORS.NOT_IN_STORAGE:
			if(er.getStorage() > 0) {
				param1 = CDBCStoragecardsObject.findStorageName(er.getStorage());
/*
				try {
					StoragePlaceAccessBean bean = new StoragePlaceAccessBean();
					bean.setInitKey_storageplace(er.getStorage());
					bean.refreshCopyHelper();
					param1 = getSpname(bean);
				} catch(Exception exc) {
					param1 = "";
				}
*/
				e = new ActionError("error.documentprocessing.not_in_storage.2",param0,param1);
			} else {
				param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
				param2 = CDBCStoragecardsObject.findStorageNameBySerial(er.getSerial());
/*
				if(param1 != null) {
					try {
						StorageCardAccessBean b = (new StorageCardAccessBean()).findBySerial(er.getSerial());
						StoragePlaceAccessBean sp = b.getCurrentstorage();
						param2 = getSpname(sp);
					} catch(Exception exc) {
					}
				}
*/
				e = new ActionError("error.documentprocessing.not_in_storage.1",param0,param1,param2);
			}
			break;
		case ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE:
			param1 = CDBCStoragecardsObject.findBySerial(er.getSerial());
			if(storage != null) {
				param2 = CDBCStoragecardsObject.findStorageName(storage.getStorageplace());
			} else {
				param2 = "";
			}
	
			param3 = CDBCStoragecardsObject.findStorageName(er.getStorage());
			if(param3 == null || "".equals(param3)) {
				param3 = " в другом месте";
			}
/*
			try {
				StoragePlaceAccessBean sp = new StoragePlaceAccessBean();
				sp.setInitKey_storageplace(er.getStorage());
				sp.refreshCopyHelper();
				param3 = " "+getSpname(sp);
			} catch(Exception exc) {
			}
*/
			e = new ActionError("error.documentprocessing.head_not_in_storage",param0,param1,param2,param3);
			break;
		case ProcessingPositionError.ERRORS.NOT_SUCH_PRODUCT:
			param1 = "";
			if(storage != null) {
				param1 = CDBCStoragecardsObject.findStorageName(storage.getStorageplace());
			}
			e = new ActionError("error.documentprocessing.not_such_product",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.NOT_THE_SAME_OWNER:
			try {
				OrganizationAccessBean bean = new OrganizationAccessBean();
				bean.setInitKey_organization(er.getOwner());
				bean.refreshCopyHelper();
				param1 = bean.getName();
			} catch(Exception ex) {
				param1 = ""+er.getOwner();
			}
			e = new ActionError("error.documentprocessing.not_the_same_owner",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.NOT_THE_SAME_DOC_OWNER:
			try {
				OrganizationAccessBean bean = new OrganizationAccessBean();
				bean.setInitKey_organization(er.getOwner());
				bean.refreshCopyHelper();
				param1 = bean.getName();
			} catch(Exception ex) {
				param1 = ""+er.getOwner();
			}
			e = new ActionError("error.documentprocessing.not_the_same_doc_owner",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE:
			try {
				ResourceAccessBean bean = new ResourceAccessBean();
				bean.setInitKey_resource(er.getResource());
				bean.refreshCopyHelper();
				param1 = bean.getName()+" "+bean.getModel();
				String policy = bean.getCountpolicy();
				if("S".equals(policy)) {
//					param2 = "соответствующий с/н "+"SN";
					param2 = "соответствующий указанному с/н";
				} else if("P".equals(policy)) {
//					param2 = "соответствующий партии "+"party";
					param2 = "соответствующий указанной партии";
				} else {
					param2 = "";
				}
			} catch(Exception ex) {
				param1 = ""+er.getResource();
				param2 = "";
			}
			e = new ActionError("error.documentprocessing.not_the_same_resource",param0,param1,param2);
			break;
		case ProcessingPositionError.ERRORS.NOTENOUGHQTY:
			if(er.getQty() != null) {
				param1 = er.getQty().toString();
			} else {
				param1 = "0";
			}
			e = new ActionError("error.documentprocessing.notenoughqty",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.POSITION_HIDDEN:
			param1 = ""+er.getLastDocumentCode();
			try {
				DocumentAccessBean bean = new DocumentAccessBean();
				bean.setInitKey_document(er.getLastDocumentCode());
				bean.refreshCopyHelper();
				param1 = getDocumentTypeName(bean);
				param1 += " № "+bean.getBlankindex();
				if(bean.getBlanknumber() != null) {
					param1 += bean.getBlanknumber();
				}
				param1 += " от "+format.format(bean.getBlankdate());
			} catch(Exception ex) {
				ex.printStackTrace(System.out);
			}
			e = new ActionError("error.documentprocessing.positionhidden",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.NOT_THE_SAME_STATE:
			e = new ActionError("error.documentprocessing.not_the_same_state",param0);
			break;
		case ProcessingPositionError.ERRORS.NOT_THE_SAME_PRICE:
			param1 = ""+er.getPrice();
			e = new ActionError("error.documentprocessing.not_the_same_price",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.CARD_IS_BOXED:
			e = new ActionError("error.documentprocessing.card_is_boxed",param0);
			break;
		case ProcessingPositionError.ERRORS.CARD_ALREADY_BOUND:
			param1 = "";
			param1 = CDBCStoragecardsObject.findResourceIdentityBySerial(er.getSerial());
/*
			try {
				StorageCardAccessBean b = new StorageCardAccessBean();
				b.setInitKey_storagecard(er.getStoragecard());
				b.refreshCopyHelper();
				param1 = b.getResource().getName() + " " + b.getResource().getModel()+" с/н: "+b.getSerialnumber();
			} catch(Exception exc) {
				param1 = String.valueOf(er.getStoragecard());
			}
*/
			e = new ActionError("error.documentprocessing.card_already_bound",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.INVALID_RESOURCE:
			param1 = "";
			try {
				ResourceAccessBean r = new ResourceAccessBean();
				r.setInitKey_resource(er.getResource());
				r.refreshCopyHelper();
				param1 = r.getName() + " " + r.getModel();
			} catch(Exception exc) {
			}
			e = new ActionError("error.documentprocessing.invalid_resource",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.DUPLICATE_SERIAL:
			e = new ActionError("error.documentprocessing.duplicate_serial",param0);
			break;
		case ProcessingPositionError.ERRORS.DUPLICATE_PARTY:
			e = new ActionError("error.documentprocessing.duplicate_party",param0);
			break;
		case ProcessingPositionError.ERRORS.DUPLICATE_RESOURCE:
			e = new ActionError("error.documentprocessing.duplicate_resource",param0);
			break;
		case ProcessingPositionError.ERRORS.NO_SERIAL:
			param1 = CDBCStoragecardsObject.findBySerial(er.getSerial());
			e = new ActionError("error.documentprocessing.noserial",param0,param1);
			break;
		case ProcessingPositionError.ERRORS.LOST_AGRAGATE:
			e = new ActionError("error.documentprocessing.lostagregate",param0);
			break;
		default:
			e = new ActionError("error.documentprocessing.unknown",/*" "+errornames[*/new Integer(er.getErrorCode())/*]*/);
		}

		if(bpos!=0){			
			calcerrors.add(bpos + "@" + getErrorText(e));
		}else{
			headercalcerrors.add(getErrorText(e));
		}
		
	} catch(Exception ex) {
		e = new ActionError("error.documentprocessing.databean",ex.getMessage());
		//log(ex);
	}
	return e;
}
public String validateACC(PosVO acc, int index, ActionErrors errors) {
	Integer type = acc.getType();
	String sn = acc.getSn();
	StringAndIntegerProperty count = acc.getCount();
	String beginv = acc.getNote();
	String afterhour = acc.getRoomnumber();
	Integer complect = acc.getComplect();
	Boolean fictSerial = acc.getFictionSerial();
	
	String acc_policy = null;
	if(type.intValue() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.empty",String.valueOf(index)));
		return null;
	} else {
		try {
			ResourceAccessBean rb = new ResourceAccessBean();
			rb.setInitKey_resource(type.intValue());
			rb.refreshCopyHelper();
			acc_policy = rb.getCountpolicy();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.invalid",String.valueOf(index)));
		}
	}

	if("S".equals(acc_policy) || "P".equals(acc_policy)) {
		// check serialnumber
		
		if(fictSerial!=null && !fictSerial.booleanValue() && (sn == null || "".equals(sn.trim()))) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.sn.empty",String.valueOf(index)));
		}
		if(sn!=null && (sn.indexOf(",")!=-1 || sn.indexOf(";")!=-1)){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.sn.invalid",String.valueOf(index)));
		}
		
		/*if(!count.isEmpty() && !count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.count.invalid",String.valueOf(index)));
		}else if(!count.isEmpty() && count.isOk() && count.getInteger().intValue()!=1){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.count.notone",String.valueOf(index)));
		}*/
		
	} else if("B".equals(acc_policy)) {
		//check count
		if(count.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.count.empty",String.valueOf(index)));
		}
		if(!count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.count.invalid",String.valueOf(index)));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.invalid_policy",String.valueOf(index)));
	}
	
	if(beginv != null && (!"".equals(beginv.trim()))) {
		try{
			Double.parseDouble(beginv);
		}catch(NumberFormatException nfe){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.beginv.invalid",String.valueOf(index)));
		}
	}

	if(afterhour != null && (!"".equals(afterhour.trim()))) {
		try{
			Double.parseDouble(afterhour);
		}catch(NumberFormatException nfe){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.afterhour.invalid",String.valueOf(index)));
		}
	}

	if(complect==null){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.acc.complect.empty",String.valueOf(index)));
	}
	
	return null;
}
public String validateAIF(PosVO aif, int index, ActionErrors errors) {
	Integer type = aif.getType();
	String sector = aif.getSector();
	StringAndIntegerProperty count = aif.getCount();
	String ksv = aif.getKsb();
	String scateg = "";
	int categ = aif.getCateg().intValue();
	Integer complect = aif.getComplect();	
	
	if(categ==1) scateg = C_CABLE_0;
	else if(categ==2) scateg = C_CABLE_14;
	else if(categ==3) scateg = C_CABLE_12;
	else if(categ==4) scateg = C_CABLE_114;
	else if(categ==5) scateg = C_CABLE_158;
	else if(categ==6) scateg = C_CABLE_78;
	
	
	if(type.intValue() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.aif.empty",scateg,String.valueOf(index)));
		return null;
	}else {
		try {
			ResourceAccessBean rb = new ResourceAccessBean();
			rb.setInitKey_resource(type.intValue());
			rb.refreshCopyHelper();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.aif.invalid",scateg,String.valueOf(index)));
		}
	}
		
		if(sector == null || "".equals(sector.trim())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.aif.sector.empty",scateg,String.valueOf(index)));
		}
		
	
		//check count
		if(count.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.aif.count.empty",scateg,String.valueOf(index)));
		}
		if(!count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.aif.count.invalid",scateg,String.valueOf(index)));
		}
	
	
	if(ksv != null && (!"".equals(ksv.trim()))) {
		try{
			Double.parseDouble(ksv);
		}catch(NumberFormatException nfe){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.aif.ksv.invalid",scateg,String.valueOf(index)));
		}
	}

	if(complect==null){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor.aif.complect.empty",scateg,String.valueOf(index)));
	}
	
	return null;
}
public String validateBIA(PosVO bis, int index, String prefix, ActionErrors errors) {
	Integer type = bis.getType();
	String sn = bis.getSn();
	StringAndIntegerProperty count = bis.getCount();
	String unote = bis.getNote();
	String room = bis.getRoomnumber();
	String scateg = "";
	int categ = bis.getCateg().intValue();
	Integer complect = bis.getComplect();
	Boolean fictSerial = bis.getFictionSerial();

	if(prefix.equals("bia")){
		if(categ==1) scateg = "Инвертер аварий";
		else if(categ==2) scateg = "Блок внешних аварий";
	}else if(prefix.equals("sio")){
		if(categ==1) scateg = "Щит питания";
		else if(categ==2) scateg = "АВР";
		else if(categ==3) scateg = "Панель коммутационная";
	}else if(prefix.equals("pio")){
		if(categ==1) scateg = "Кондиционер";
		else if(categ==2) scateg = "Панель сигнализации";
		else if(categ==3) scateg = "Источник питания УЗО";
		else if(categ==4) scateg = "Преобразователь УЗО";
	}else if(prefix.equals("mio")){
		if(categ==1) scateg = "МШУ.Источник питания";
		else if(categ==2) scateg = "МШУ.Усилитель";
		else if(categ==3) scateg = "МШУ.Инжектор";
	}else if(prefix.equals("cio")){
		if(categ==1) scateg = "Делитель";
		else if(categ==2) scateg = "Диплексер";
		else if(categ==3) scateg = "Комбайнер 900/1800";
	}else if(prefix.equals("cbis")){
		if(categ==1) scateg = "Основная стойка";
		else if(categ==2) scateg = "Стойка расширения";
	}
	
	String bis_policy = null;
	if(type.intValue() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".empty",scateg,String.valueOf(index)));
		return null;
	} else {
		try {
			ResourceAccessBean rb = new ResourceAccessBean();
			rb.setInitKey_resource(type.intValue());
			rb.refreshCopyHelper();
			bis_policy = rb.getCountpolicy();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".invalid",scateg,String.valueOf(index)));
		}
	}

	if("S".equals(bis_policy) || "P".equals(bis_policy)) {
		// check serialnumber
		
		if(fictSerial!=null && !fictSerial.booleanValue() && (sn == null || "".equals(sn.trim()))) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".sn.empty",scateg,String.valueOf(index)));
		}
		if(sn!=null && (sn.indexOf(",")!=-1 || sn.indexOf(";")!=-1)){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".sn.invalid",scateg,String.valueOf(index)));
		}
		/*if(!count.isEmpty() && !count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.invalid",scateg,String.valueOf(index)));
		}else if(!count.isEmpty() && count.isOk() && count.getInteger().intValue()!=1){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.notone",scateg,String.valueOf(index)));
		}*/
		
	} else if("B".equals(bis_policy)) {
		//check count
		if(count.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.empty",scateg,String.valueOf(index)));
		}
		if(!count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.invalid",scateg,String.valueOf(index)));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".invalid_policy",scateg,String.valueOf(index)));
	}

	
		if(unote != null && (unote.trim()).length() > 255) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".note.length",scateg,String.valueOf(index)));
		}
	
	if(room != null && (!"".equals(room.trim()))) {
		try{
			Integer.parseInt(room);
		}catch(NumberFormatException nfe){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".room.invalid",scateg,String.valueOf(index)));
		}
	}

	if(complect==null){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".complect.empty",scateg,String.valueOf(index)));
	}
	
	return null;	
}
public String validateBIS(PosVO bis, int index, String prefix, ActionErrors errors) {
	Integer type = bis.getType();
	String sn = bis.getSn();
	StringAndIntegerProperty count = bis.getCount();
	String unote = bis.getNote();
	String room = bis.getRoomnumber();
	Integer complect = bis.getComplect();
	Boolean fictSerial = bis.getFictionSerial();
	
	String bis_policy = null;
	if(type.intValue() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".empty",String.valueOf(index)));
		return null;
	} else {
		try {
			ResourceAccessBean rb = new ResourceAccessBean();
			rb.setInitKey_resource(type.intValue());
			rb.refreshCopyHelper();
			bis_policy = rb.getCountpolicy();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".invalid",String.valueOf(index)));
		}
	}

	if("S".equals(bis_policy) || "P".equals(bis_policy)) {
		// check serialnumber
		
		if(fictSerial!=null && !fictSerial.booleanValue() && (sn == null || "".equals(sn.trim()))) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".sn.empty",String.valueOf(index)));
		}
		if(sn!=null && (sn.indexOf(",")!=-1 || sn.indexOf(";")!=-1)){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".sn.invalid",String.valueOf(index)));
		}
		/*if(!count.isEmpty() && !count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.invalid",String.valueOf(index)));
		}else if(!count.isEmpty() && count.isOk() && count.getInteger().intValue()!=1){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.notone",String.valueOf(index)));
		}*/
		
	} else if("B".equals(bis_policy)) {
		//check count
		if(count.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.empty",String.valueOf(index)));
		}
		if(!count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.invalid",String.valueOf(index)));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".invalid_policy",String.valueOf(index)));
	}

	if(!prefix.equals("vbip") || !prefix.equals("cbip") || !prefix.equals("rip") || !prefix.equals("ain")){
		if(unote != null && (unote.trim()).length() > 255) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".note.length",String.valueOf(index)));
		}
	}

	if(!prefix.equals("cbip") || !prefix.equals("rip") || !prefix.equals("ain")){
		if(room != null && (!"".equals(room.trim()))) {
			try{
				Integer.parseInt(room);
			}catch(NumberFormatException nfe){
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".room.invalid",String.valueOf(index)));
			}
		}
	}

	if(complect==null){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".complect.empty",String.valueOf(index)));
	}
	
	return null;	
}
public String validatePO(PosVO bis, int index, String prefix, ActionErrors errors) {
	String typename = bis.getTypename();
	String sn = bis.getSn();
	StringAndIntegerProperty count = bis.getCount();
	String unote = bis.getNote();
	String room = bis.getRoomnumber();
	Integer complect = bis.getComplect();
	Boolean fictSerial = bis.getFictionSerial();

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String bis_policy = null;
	if(typename == null || "".equals(typename)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".empty",String.valueOf(index)));
		return null;
	} else {
		try {
			conn = new JdbcConnection().getConnection();
			ps = conn.prepareStatement("select resource from resources where model=?");
			ps.setString(1,typename); 
			rs = ps.executeQuery();
			if(!rs.next()) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".invalid",String.valueOf(index),typename));
				return null;
			}else{
				try {
					int type = rs.getInt(1);
					bis.setType(new Integer(type));
					ResourceAccessBean rb = new ResourceAccessBean();
					rb.setInitKey_resource(type);
					rb.refreshCopyHelper();
					bis_policy = rb.getCountpolicy();
					bis.setPolicy(bis_policy);
				} catch(Exception e) {
					e.printStackTrace(System.out);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace(System.out);
		}finally{
	    	try{	
		   	 if(rs!=null) rs.close(); 
		   	 if(ps!=null) ps.close();
		   	 if(conn!=null) conn.close();
	    	}catch(Exception exc){
		   	 exc.printStackTrace(System.out);
	   	    }
    	}
	}

	if("S".equals(bis_policy) || "P".equals(bis_policy)) {
		// check serialnumber
		
		if(fictSerial!=null && !fictSerial.booleanValue() && (sn == null || "".equals(sn.trim()))) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".sn.empty",String.valueOf(index)));
		}
		if(sn!=null && (sn.indexOf(",")!=-1 || sn.indexOf(";")!=-1)){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".sn.invalid",String.valueOf(index)));
		}
		/*if(!count.isEmpty() && !count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.invalid",String.valueOf(index)));
		}else if(!count.isEmpty() && count.isOk() && count.getInteger().intValue()!=1){
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.notone",String.valueOf(index)));
		}*/
		
	} else if("B".equals(bis_policy)) {
		//check count
		if(count.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.empty",String.valueOf(index)));
		}
		if(!count.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".count.invalid",String.valueOf(index)));
		}
	} else {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".invalid_policy",String.valueOf(index)));
	}

	if(!prefix.equals("vbip") || !prefix.equals("cbip") || !prefix.equals("rip") || !prefix.equals("ain")){
		if(unote != null && (unote.trim()).length() > 255) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".note.length",String.valueOf(index)));
		}
	}

	if(!prefix.equals("cbip") || !prefix.equals("rip") || !prefix.equals("ain")){
		if(room != null && (!"".equals(room.trim()))) {
			try{
				Integer.parseInt(room);
			}catch(NumberFormatException nfe){
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".room.invalid",String.valueOf(index)));
			}
		}
	}

	if(complect==null){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.contractor."+prefix+".complect.empty",String.valueOf(index)));
	}
	
	return null;	
}
public void validateValues(ActionErrors errors) throws Exception 
{
	
	if(blankdate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invcontr.blankdate"));
	}
	else if(!blankdate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invcontr.blankdate"));
	}

	if(blanknumber != null && !"".equals(blanknumber)) {
		if(blanknumber.length() > 40) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.blanknumber"));
		}
	} else {
		blanknumber = "";
	}

	if(blanknumber.trim().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} 

	if(blankindex.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.empty"));
	} else if(!blankindex.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.blankindex.invalid"));
	}

	if(owner.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invcontr.owner"));
	}
	else if(!owner.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invcontr.owner"));
	}
	else {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(owner.getInteger().intValue());
			bean.refreshCopyHelper();
			setOwnername(bean.getName());
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.invcontr.owner"));
		}
	}
		
	

	//if("P".equals(type)) {
		if(renter.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invcontr.renter"));
		}
		else if(!renter.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invcontr.renter"));
		}
		else {
			try {
				OrganizationAccessBean bean = new OrganizationAccessBean();
				bean.setInitKey_organization(renter.getInteger().intValue());
				bean.refreshCopyHelper();
				setRentername(bean.getName());
				if(Boolean.FALSE.equals(bean.getIsprovider())) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invcontr.notrenter"));
				}
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.invcontr.renter"));
			}
		}
		
	
	if(!position.isEmpty()) {
		if(!position.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invcontr.position"));
		} else {
			try {
				PositionAccessBean bean = constructPosition();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.invcontr.position"));
			}
		}
	}else{
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invcontr.position"));
	}


	if(storagemancode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.invcontr.sman"));
	}
	else if(!storagemancode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invcontr.sman"));
	}

	if(!"1".equals(documentState) && !"2".equals(documentState)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.invcontr.state"));
	}
	
	//====
	if (getComplectbs()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectbs()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectbs"));
	if (getComplectac()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectac()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectac"));
	if (getComplectbp()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectbp()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectbp"));
	if (getComplectvbp()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectvbp()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectvbp"));
	if (getComplectba()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectba()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectba"));
	if (getComplectso()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectso()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectso"));
	if (getComplectpo()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectpo()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectpo"));
	if (getComplectmu()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectmu()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectmu"));
	if (getComplectcd()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectcd()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectcd"));
	if (getComplectcbs()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectcbs()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectcbs"));
	if (getComplectcbp()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectcbp()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectcbp"));
	if (getComplectrp()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectrp()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectrp"));
	if (getComplectan()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectan()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectan"));
	if (getComplectaft()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectaft()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectaft"));
	if (getComplectpro()!=null)
		if(!com.hps.july.inventory.formbean.CheckOldBS.canProcessFKBS(getComplectpro()))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.fkbs.complectpro"));
	//====

	//базовая станция
	if(bis != null) {
		for(int i = 0; i < bis.size(); i++) {			
			if(bis.get(i)!=null && ((PosVO)bis.get(i)).getType()!=null && ((PosVO)bis.get(i)).getType().intValue() != -1) {
				validateBIS((PosVO)bis.get(i), i+1, "bis", errors);
			}else{
				bis.remove(i);
				i--;
			}
		}
	} 

	//Ист пит базовой станции
	if(bip != null) {
		for(int i = 0; i < bip.size(); i++) {
			if(bip.get(i)!=null && ((PosVO)bip.get(i)).getType()!=null &&((PosVO)bip.get(i)).getType().intValue() != -1) {
				validateBIS((PosVO)bip.get(i), i+1, "bip", errors);
			}else{
				bip.remove(i);
				i--;
			}
		}
	}

	//Выпрям ист пит базовой станции
	
	if(vbip != null) {
		for(int i = 0; i < vbip.size(); i++) {
			if(vbip.get(i)!=null && ((PosVO)vbip.get(i)).getType()!=null &&((PosVO)vbip.get(i)).getType().intValue() != -1) {
				validateBIS((PosVO)vbip.get(i), i+1, "vbip", errors);
			}else{
				vbip.remove(i);
				i--;
			}
		}
	}

	//Акк баз станций
	if(acc != null) {
		for(int i = 0; i < acc.size(); i++) {
			if(acc.get(i)!=null && ((PosVO)acc.get(i)).getType()!=null &&((PosVO)acc.get(i)).getType().intValue() != -1) {
				validateACC((PosVO)acc.get(i), i+1, errors);
			}else{
				acc.remove(i);
				i--;
			}
		}
	}	

	//Блок преобразования аварий
	if(bia != null) {
		for(int i = 0; i < bia.size(); i++) {
			if(bia.get(i)!=null && ((PosVO)bia.get(i)).getType()!=null &&((PosVO)bia.get(i)).getType().intValue() != -1) {
				validateBIA((PosVO)bia.get(i), i+1, "bia", errors);
			}else{
				bia.remove(i);
				i--;
			}
		}
	}

	//Cиловое оборудования
	if(sio != null) {
		for(int i = 0; i < sio.size(); i++) {
			if(sio.get(i)!=null && ((PosVO)sio.get(i)).getType()!=null &&((PosVO)sio.get(i)).getType().intValue() != -1) {
				validateBIA((PosVO)sio.get(i), i+1, "sio", errors);
			}else{
				sio.remove(i);
				i--;
			}
		}
	}

	//Прочее оборудование
	if(pio != null) {
		for(int i = 0; i < pio.size(); i++) {
			if(pio.get(i)!=null && ((PosVO)pio.get(i)).getType()!=null &&((PosVO)pio.get(i)).getType().intValue() != -1) {
				validateBIA((PosVO)pio.get(i), i+1, "pio", errors);
			}else{
				pio.remove(i);
				i--;
			}
		}
	}

	//Малошумящий усилитель
	if(mio != null){
		for(int i = 0; i < mio.size(); i++) {
			if(mio.get(i)!=null && ((PosVO)mio.get(i)).getType()!=null &&((PosVO)mio.get(i)).getType().intValue() != -1) {
				validateBIA((PosVO)mio.get(i), i+1, "mio", errors);
			}else{
				mio.remove(i);
				i--;
			}
		}
	}
	
	//Комбайнеры делители
	if(cio != null){	
		for(int i = 0; i < cio.size(); i++) {
			if(cio.get(i)!=null && ((PosVO)cio.get(i)).getType()!=null &&((PosVO)cio.get(i)).getType().intValue() != -1) {
				validateBIA((PosVO)cio.get(i), i+1, "cio", errors);
			}else{
				cio.remove(i);
				i--;
			}
		}
	}

	//Аппаратура контроллера базовых станций
	if(cbis != null){
		for(int i = 0; i < cbis.size(); i++) {
			if(cbis.get(i)!=null && ((PosVO)cbis.get(i)).getType()!=null &&((PosVO)cbis.get(i)).getType().intValue() != -1) {
				validateBIA((PosVO)cbis.get(i), i+1, "cbis", errors);
			}else{
				cbis.remove(i);
				i--;
			}
		}
	}

	//Ист пит контроллера базовой станции
	if(cbip != null){
		for(int i = 0; i < cbip.size(); i++) {
			if(cbip.get(i)!=null && ((PosVO)cbip.get(i)).getType()!=null &&((PosVO)cbip.get(i)).getType().intValue() != -1) {
				validateBIS((PosVO)cbip.get(i), i+1, "cbip", errors);
			}else{
				cbip.remove(i);
				i--;
			}
		}
	}
	
	//Репитер
	if(rip != null){	
		for(int i = 0; i < rip.size(); i++) {
			if(rip.get(i)!=null && ((PosVO)rip.get(i)).getType()!=null &&((PosVO)rip.get(i)).getType().intValue() != -1) {
				validateBIS((PosVO)rip.get(i), i+1, "rip", errors);
			}else{
				rip.remove(i);
				i--;
			}
		}
	}
	//Антенны
	if(ain != null){	
		for(int i = 0; i < ain.size(); i++) {
			if(ain.get(i)!=null && ((PosVO)ain.get(i)).getType()!=null &&((PosVO)ain.get(i)).getType().intValue() != -1) {
				validateBIS((PosVO)ain.get(i), i+1, "ain", errors);
			}else{
				ain.remove(i);
				i--;
			}
		}
	}

	//кабели
	if(aif != null){
		for(int i = 0; i < aif.size(); i++) {
			if(aif.get(i)!=null && ((PosVO)aif.get(i)).getType()!=null &&((PosVO)aif.get(i)).getType().intValue() != -1) {
				validateAIF((PosVO)aif.get(i), i+1, errors);
			}else{
				aif.remove(i);
				i--;
			}
		}
	}

	//Прочее оборудование
	if(prio != null){
		for(int i = 0; i < prio.size(); i++) {
			if(prio.get(i)!=null && ((PosVO)prio.get(i)).getTypename()!=null) {
				validatePO((PosVO)prio.get(i), i+1, "prio", errors);
			}else{
				prio.remove(i);
				i--;
			}
		}
	}

	//Старое оборудование
	if(stio != null){
		for(int i = 0; i < stio.size(); i++) {
			if(stio.get(i)!=null && ((PosVO)stio.get(i)).getTypename()!=null) {
				validatePO((PosVO)stio.get(i), i+1, "stio", errors);
			}else{
				stio.remove(i);
				i--;
			}
		}
	}
	
	if (!errors.empty()){
		throw new ValidationException();		
	}	
}
}
