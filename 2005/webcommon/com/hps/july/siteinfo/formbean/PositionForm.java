package com.hps.july.siteinfo.formbean;

import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.persistence2.*;
import com.hps.july.siteinfo.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.siteinfo.valueobject.*;
import java.util.*;
import java.math.BigDecimal;
import com.hps.july.jdbcpersistence.lib.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.apptags.*;
import com.hps.july.siteinfo.actionbean.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;

/**
 * Форма редактирования/просмотра данных позиции.
 */
public class PositionForm extends com.hps.july.web.util.EditForm {
	private java.lang.String name;
	private java.lang.String address;
	private String docaddress;
	private StringAndInteger dampsid;
	private StringAndInteger gsmid;
	private boolean isAdmin;
	private boolean isFreqmanager;
	private java.lang.String dampsname;
	private java.lang.String details;
	private String latitudeFrm;
	private String longitudeFrm;
	private String linktogosnetlat;
	private String linktogosnetlon;
	private java.lang.String rentervolume;
	private com.hps.july.web.util.StringAndIntegerProperty rentercode;
	private java.lang.String rentername;
	private StringAndInteger storageplace=new StringAndInteger();
	private java.lang.Integer netzonecode;
	private com.hps.july.persistence.OrganizationAccessBean renters;
	private com.hps.july.persistence.NetZoneAccessBean netzones;
	private java.lang.Boolean inAction;
	private StringAndInteger regioncode = new StringAndInteger();
	private Vector regions;

	private StringAndSqlDateProperty datebeginbuild = new StringAndSqlDateProperty();
	private StringAndSqlDateProperty date_endbuild = new StringAndSqlDateProperty();
	private StringAndSqlDateProperty date_posclose = new StringAndSqlDateProperty();
	private String regname;
	private String supregname;
	private String zonename;

	private String dognumber;
	private StringAndSqlDateProperty dogdate;
	private String sqqty;
	private String paya;

	private String fullName;

	private int WAYMAPVARIANT = 1;
	public int MAXCONTAINERS = 100;
	
	private boolean haveWayMap;
	private java.lang.String user;
	private boolean showArendaTable;
	private String genpodrcode;
	private java.lang.String genpodrname;
	private java.lang.Integer antplaceid;
	private java.lang.Integer oporplaceid;
	private java.lang.String oportypecode;
	private java.lang.String oportypename;
	private StringAndBigDecimal oporaheight = new StringAndBigDecimal(4, 1);
	private StringAndSqlDateProperty oporadate = new StringAndSqlDateProperty();
	private java.lang.Boolean oporaour;
	private java.lang.Integer aptypeid;
	private java.lang.Integer applacetypeid;
	private java.lang.Integer applaceid;
	private java.lang.String posstate;
	private java.lang.String[] rescode;
	private java.lang.String[] contsizew;
	private java.lang.String[] contsizeh;
	private java.lang.String[] contsizel;
	private java.lang.String[] contyear;
	private java.lang.String[] resname;

	private String haveplan;

	private StringAndBigDecimalProperty _tempBd = new StringAndBigDecimalProperty();

	private String grchaddress; // CHAR(255)
	private String grchlat; // CHAR(12)
	private String grchlong; // CHAR(12)

	private String orderno; // CHAR(20)

	private String comment_doc; // 
	
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:46:22)
 */
public PositionForm() {
	super();
	rentercode = new com.hps.july.web.util.StringAndIntegerProperty();
	dampsid = new StringAndInteger();
	gsmid = new StringAndInteger();
	latitudeFrm = "";
	longitudeFrm = "";
	dogdate=new StringAndSqlDateProperty();

	try {
		NamedValueAccessBean nv = new NamedValueAccessBean();
		nv.setInitKey_id("WayMapVariant");
		nv.refreshCopyHelper();
		WAYMAPVARIANT = nv.getIntvalue();
	} catch (Exception e) {
		System.out.println("Error in PositionForm.constructor. On set WAYMAPVARIANT.");
		e.printStackTrace(System.out);
	}
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	// Запомним подрядчиков
	updatePodrOrganization(getGenpodrcode(), CDBCPositionObject.GENPODR);
	updatePodrOrganization(getOportypecode(), CDBCPositionObject.VCPODR);
	updateContainers();
}
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception 
{
	super.beforeDelete(bean,request);

	deletePodrOrganization(CDBCPositionObject.GENPODR);
	deletePodrOrganization(CDBCPositionObject.VCPODR);
}
/**
 * Insert the method's description here.
 * Creation date: (13.08.2003 17:07:01)
 * @return java.lang.String
 */
private void calculateFullName() throws Exception{
    String gsm = getGsmid() != null ? "D" + getGsmid() : "";
    String damps = getDampsid() != null ? "A" + getDampsid() : "";

    fullName =
        gsm
            + (gsm.length() > 0 && damps.length() > 0 ? " " : "")
            + damps
            + (gsm.length() > 0 || damps.length() > 0 ? " " : "")
            + getName();
    
}
/**
 * Очистка массивов списка контейнеров.
 * Creation date: (14.04.2004 14:00:14)
 * @return java.lang.String[]
 */
public void clearContainersArray() {
	rescode = new String [MAXCONTAINERS];
	resname = new String [MAXCONTAINERS];
	contsizew = new String [MAXCONTAINERS];
	contsizeh = new String [MAXCONTAINERS];
	contsizel = new String [MAXCONTAINERS];
	contyear = new String [MAXCONTAINERS];
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
    javax.servlet.http.HttpServletRequest request)
    throws java.lang.Exception {
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    setStorageplace(keyGen.getNextKey("tables.storageplaces"));
    PositionAccessBean bean =
        new PositionAccessBean(
            getStorageplace(),
            getName(),
            getAddress(),
            getNetzonecode(),
            getLatitude(), //latitude.getBigDecimal(),
            getLongitude(), //longitude.getBigDecimal(),
            Integer.parseInt(getRegioncode()),
            com.hps.july.siteinfo.valueobject.Position.PLANSTATE_CHECK_Fact);

    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public NetZoneAccessBean constructNetzones() throws Exception {
	//if (netzones == null) {	
		// Construct workers bean
System.out.println("POSITION_FORM[constructNetzone("+netzonecode+")");
		if (netzonecode != null) {
			netzones = new NetZoneAccessBean();
			netzones.setInitKey_netzone(netzonecode.intValue());
			netzones.refreshCopyHelper();
System.out.println("POSITION_FORM[constructNetzone("+netzonecode+"):Constructed.");
		}
	//}
	return netzones;
}
/**
 * Создает bean организаций.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public OrganizationAccessBean constructOrganization(int orgCode) throws Exception {

	OrganizationAccessBean res = null;
	try {
		res = new OrganizationAccessBean();
		res.setInitKey_organization(orgCode);
		res.refreshCopyHelper();
	} catch (javax.ejb.ObjectNotFoundException e) {
		// Invalid organization code entered
		res = null;
	}
	return res;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public OrganizationAccessBean constructRenters() throws Exception {

	// Construct workers bean
	if (!rentercode.isEmpty()) {
		if (rentercode.isOk()) {
			try {
				renters = new OrganizationAccessBean();
				renters.setInitKey_organization(rentercode.getInteger().intValue());
				renters.refreshCopyHelper();
			} catch (javax.ejb.ObjectNotFoundException e) {
				// Invalid renter code entered
				renters = null;
			}
		} else
			renters = null;
	} else
		renters = null;
	return renters;
}
public static String convertDegree(String coords)
{
	String field = coords;
	String result = "";
	int[] maxval = { 180, 60, 1000, 1000};

	if(field != null) { field = field.trim(); }	
	if(field == null || field.trim().length() == 0)	{
		throw new java.lang.NumberFormatException("error.convdegree.null");
	}

	field = field.replace(',', '.');
	field = field.replace('°', '-');
	field = field.replace('*', '-');
	field = field.replace('\'', '-');
	field = field.replace('"', '-');
	StringTokenizer atoks = new StringTokenizer(field, "-", true);
	String next = "", prev = "";
	int tc = 0;
	String[] g = new String[3];
	for(int i = 0; i < 3 && atoks.hasMoreTokens(); ) {
		next = atoks.nextToken().trim();
		if("-".equals(next)) {
			tc++;
			if("-".equals(prev)) { i++; }
		} else {
			g[i] = next;
			if(i < 2) {
				Integer gi = null;
				try {
					gi = new Integer(Integer.parseInt(g[i]));
				} catch(NumberFormatException e) {
					throw new NumberFormatException("error.convdegree.badformat"+i);
				}
				if(gi != null && gi.intValue() > maxval[i]) {
					throw new NumberFormatException("error.convdegree.badformat"+i);
				}
			}
			i++;
		}
		prev = next;
	}
	if(atoks.hasMoreTokens() && tc > 2) {
		throw new NumberFormatException("error.convdegree.unknownformat");
	}

	if(field.charAt(0) == '-') {
		result = "-";
	}

	if(g[0] != null) {
		result += g[0]+"°";
	} else {
		result += "00°";
	}
	if(g[1] != null) {
		result += g[1]+"'";
	}
	if(g[2] != null) {
		result += String.valueOf(g[2])+"\"";
	}

	return result;
}
private void deletePodrOrganization(String podrType) throws Exception {
	int gptype = AppUtils.getNamedValueInt(podrType);
	PositionResponsibleWorkersAccessBean pab = new PositionResponsibleWorkersAccessBean();
	boolean haveResponsible = false;
	try {
		pab.setInitKey_type_responsibilityType(new Integer(gptype));
		pab.setInitKey_position_storageplace(new Integer(getStorageplace()));
		pab.setInitKey_resptype("O");
		pab.refreshCopyHelper();
		haveResponsible = true;
	} catch (javax.ejb.ObjectNotFoundException e) {
		// Suppress not found exception
		pab = null;
	}
		
	if (haveResponsible) {
		com.hps.july.jdbcpersistence.lib.AbstractJournalProcessAction act = new com.hps.july.jdbcpersistence.lib.AbstractJournalProcessAction();
		act.deleteObject(pab.getEJBRef());
		//pab.getEJBRef().remove();
	}
}
/**
 * Определение видимости полей аренды.
 * Creation date: (14.04.2004 14:00:14)
 * @return java.lang.String[]
 */
public void determineArendaVisibility(PositionAccessBean posBean) throws Exception {
	if (posBean == null)
		setShowArendaTable(false);
	else {
		if (posBean.getRegion().getFullarendainfo())
			setShowArendaTable(true);
	}
	if ( "Add".equalsIgnoreCase(getAction()) || "Edit".equalsIgnoreCase(getAction()) ) {
		setShowArendaTable(false);
	}
}
/**
 * Заполнение массивов списка контейнеров.
 * Creation date: (14.04.2004 14:00:14)
 * @return java.lang.String[]
 */
public void fillContainersArray() {
	System.out.println("FillContainers array");
	clearContainersArray();
	ListIterator it = getContainers();
	int i = 0;
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		rescode [i] = ro.getColumn("resource").asString();
		resname [i] = ro.getColumn("name").asString() + " " + ro.getColumn("model").asString();
		contsizew [i] = ro.getColumn("contwidth").asString();
		contsizeh [i] = ro.getColumn("contheight").asString();
		contsizel [i] = ro.getColumn("contlength").asString();
		contyear [i] = ro.getColumn("contyear").asString();
		i = i + 1;
	}
}
/**
 * Заполнение полей для просмотра.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	fillContainersArray();
    try {
    	determineArendaVisibility((PositionAccessBean) bean);
        setZonename(((PositionAccessBean) bean).getNetZone().getName());
        calculateFullName();
    } catch (Exception e) {
        new DebugSupport().printlnError(e);
    }

    if ("View".equalsIgnoreCase(getAction())) {
	    // Check if we have waymap
	    CardPassWordUploadAction cua = new CardPassWordUploadAction();
        int docTypeCode = AppUtils.getNamedValueInt(cua.getDocType());
	    setHaveWayMap(cua.findDocument(getStorageplace(), docTypeCode) != 0);
    }

    // Найдем подрядчиков
    CDBCPositionObject po = new CDBCPositionObject();

    // Ген. подрядчик
    CDBCRowObject genpodr = po.findPodrOrganization(getStorageplace(), po.GENPODR);
    if (genpodr != null) {
	    setGenpodrcode(genpodr.getColumn("organization").asString());
	    String name = genpodr.getColumn("shortname").asString();
	    if ( (name == null) || (name.trim().length() == 0) )
	    	name = genpodr.getColumn("name").asString();
	    setGenpodrname(name);
    } else {
	    setGenpodrcode("");
	    setGenpodrname("");
    }
    // подрядчик выс. сооружений
    CDBCRowObject vcpodr = po.findPodrOrganization(getStorageplace(), po.VCPODR);
    if (vcpodr != null) {
	    setOportypecode(vcpodr.getColumn("organization").asString());
	    String name = vcpodr.getColumn("shortname").asString();
	    if ( (name == null) || (name.trim().length() == 0) )
	    	name = vcpodr.getColumn("name").asString();
	    setOportypename(name);
    } else {
	    setOportypecode("");
	    setOportypename("");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:07:28)
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * Набор ролей, которым можно редактировать поле "Краткая характеристика".
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAddrRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	roles.add("siteProjector");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	roles.add("siteTransport");
//	roles.add("FreqManager");

	return roles;
}
/**
 * Набор ролей, которым можно редактировать "Адрес, координаты".
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAddrRoles2() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	roles.add("siteProjector");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	roles.add("ArendaManager");
	roles.add("ArendaMainManager");
	roles.add("siteTransport");
//	roles.add("FreqManager");
	
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getAllRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	roles.add("siteTransport");
	return roles;
}
/**
 * Перечень мест размещения антенн.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public CDBCResultSet getAntennplaces() {
	try {
		return new CDBCPositionObject().findAllAntennPlaces();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:00:45)
 * @return java.lang.Integer
 */
public java.lang.Integer getAntplaceid() {
	return antplaceid;
}
/**
 * Перечень мест размещения аппаратной.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public CDBCResultSet getApparatplaces() {
	try {
		return new CDBCPositionObject().findAllApparatPlaces();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
/**
 * Перечень типов помещений аппаратной.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public CDBCResultSet getApparatplacetypes() {
	try {
		return new CDBCPositionObject().findAllApparatPlaceTypes();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
/**
 * Перечень мест типов аппаратной.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public CDBCResultSet getApparattypes() {
	try {
		return new CDBCPositionObject().findAllApparatTypes();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:51:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getApplaceid() {
	return applaceid;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:49:39)
 * @return java.lang.Integer
 */
public java.lang.Integer getApplacetypeid() {
	return applacetypeid;
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
 * Creation date: (08.04.2004 16:47:34)
 * @return java.lang.Integer
 */
public java.lang.Integer getAptypeid() {
	return aptypeid;
}
/**
 * Возвращает список договоров аренды по данной позиции.
 * Creation date: (17.03.2004 15:59:38)
 * @return java.util.ListIterator
 */
public ListIterator getArendaAgreements() {
	CDBCArendaAgreementObject co = new CDBCArendaAgreementObject();
	CDBCResultSet rs = co.findArendaAgreementsByPosition(new Integer(getStorageplace()));
	return rs.listIterator();
}
/**
 * Роли, которым разрешено смотреть суммы аренды.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getArendaMoneyRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("ArendaEconomist");
	roles.add("ArendaManager");
	roles.add("ArendaMainEconomist");
	roles.add("ArendaMainManager");
	roles.add("ArendaDirector");
	return roles;
}
/**
 * Роли, которым разрешено редактировать поля аренды.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getArendaRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	roles.add("ArendaEconomist");
	roles.add("ArendaManager");
	roles.add("ArendaMainEconomist");
	roles.add("ArendaMainManager");
	roles.add("ArendaDirector");
	return roles;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComment_doc() {
	return comment_doc;
}
/**
 * Список контейнеров по позиции.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public ListIterator getContainers() {
	try {
		return new CDBCPositionObject().findContainers(getStorageplace()).listIterator();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
/**
 * Получим текущую конфигурацию контейнеров в виде одной строки.
 * Creation date: (21.05.2004 16:24:51)
 * @return java.lang.String
 */
private String getContainersInfoString() {
	StringBuffer result = new StringBuffer();
	ListIterator it = getContainers();
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		result.append(ro.getColumn("model").asString());
		result.append(" ");
		result.append(ro.getColumn("contwidth").asString());
		result.append("x");
		result.append(ro.getColumn("contheight").asString());
		result.append("x");
		result.append(ro.getColumn("contlength").asString());
		result.append(" ");
		result.append(ro.getColumn("contyear").asString());
		result.append("\r\n");
	}
	return result.toString();
}
/**
 * Высота контейнера.
 * Creation date: (14.04.2004 14:00:14)
 * @return java.lang.String[]
 */
public java.lang.String getContsizeh(int index) {
	return contsizeh [index];
}
/**
 * Insert the method's description here.
 * Creation date: (14.04.2004 14:00:34)
 * @return java.lang.String[]
 */
public java.lang.String getContsizel(int index) {
	return contsizel [index];
}
/**
 * Insert the method's description here.
 * Creation date: (14.04.2004 13:59:56)
 * @return java.lang.String[]
 */
public java.lang.String getContsizew(int index) {
	return contsizew [index];
}
/**
 * Insert the method's description here.
 * Creation date: (14.04.2004 14:00:59)
 * @return java.lang.String[]
 */
public java.lang.String getContyear(int index) {
	return contyear [index];
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:10:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getDampsid() {
	return dampsid.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:22:14)
 * @return java.lang.String
 */
public java.lang.String getDampsidFrm() {
	return dampsid.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:11:45)
 * @return java.lang.String
 */
public java.lang.String getDampsname() {
	return dampsname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	PositionAccessBean bean = new PositionAccessBean();
	bean.setInitKey_storageplace( getStorageplace() );
	return bean;
}
public java.sql.Date getDate_endbuild() {
	return date_endbuild.getSqlDate();
}
public String getDate_endbuildFrm() {
	return date_endbuild.getString();
}
public java.sql.Date getDate_posclose() {
	return date_posclose.getSqlDate();
}
public String getDate_poscloseFrm() {
	return date_posclose.getString();
}
public java.sql.Date getDatebeginbuild() {
	return datebeginbuild.getSqlDate();
}
public String getDatebeginbuildFrm() {
	return datebeginbuild.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:12:48)
 * @return java.lang.String
 */
public java.lang.String getDetails() {
	return details;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDocaddress() {
	return docaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:35:23)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public java.sql.Date getDogdate() {
	return dogdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:35:23)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDogdateFrm() {
    if (dogdate == null)
        dogdate = new StringAndSqlDateProperty();
    return dogdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:35:23)
 * @return java.lang.String
 */
public java.lang.String getDognumber() {
	return dognumber;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	roles.add("siteProjector");
	roles.add("siteTransport");
	roles.add("ArendaManager");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	
	roles.add("ArendaEconomist");
	roles.add("ArendaMainEconomist");
	roles.add("ArendaMainManager");
	
	roles.add("FreqManager");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEposRoles() {
    java.util.ArrayList roles = new java.util.ArrayList();
    roles.add("administrator");
    roles.add("siteExploitor");
    roles.add("supregAdmin");
    roles.add("regionAdmin");

//alexshr 09.10.03    
    roles.add("ArendaEconomist");
    roles.add("ArendaMainEconomist");
    
	roles.add("siteTransport");
//	roles.add("FreqManager");

    return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2003 17:21:32)
 */
public void getFactIdByPlan() {}
public java.lang.String getFullName() {
	if(dampsname != null && !"".equals(dampsname)) {
		return name+"/ "+dampsname;
	} else {
		return name;
	}
}
/**
 * Генеральный подрядчик - код.
 * Creation date: (08.04.2004 15:58:51)
 * @return java.lang.Integer
 */
public String getGenpodrcode() {
	return genpodrcode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 15:59:09)
 * @return java.lang.String
 */
public java.lang.String getGenpodrname() {
	return genpodrname;
}
/**
 * Роли, которым разрешено редактировать привязку к госсети.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getGosnetRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	roles.add("FreqManager");
	return roles;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getGrchaddress() {
	return grchaddress;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getGrchlat() {
	return grchlat;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getGrchlong() {
	return grchlong;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:11:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getGsmid() {
	return gsmid.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:22:29)
 * @return java.lang.String
 */
public java.lang.String getGsmidFrm() {
	return gsmid.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHaveplan() {
	return haveplan;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2002 15:48:21)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getInAction() {
	return inAction;
}
public java.math.BigDecimal getLatitude() {
	try {
		return parseDegree(latitudeFrm);
	} catch(Exception e) {
		return null;
	}
}
public java.lang.String getLatitudeFrm() {
	return latitudeFrm;
}
public String getLinktogosnetlat() {
	return linktogosnetlat;
}
public java.lang.String getLinktogosnetlatFrm() {
	return linktogosnetlat;
}
public String getLinktogosnetlon() {
	return linktogosnetlon;
}
public java.lang.String getLinktogosnetlonFrm() {
	return linktogosnetlon;
}
public ListIterator getListBeenets() {
	CDBCBeenetObject cp = new CDBCBeenetObject();
	CDBCResultSet rs = cp.findPositionBeeNets(new Integer(getStorageplace()),new Integer(1));
	return rs.listIterator();
}
public Iterator getListBsdamps() {
	CDBCPositionObject cp = new CDBCPositionObject();
	CDBCResultSet rs = cp.findPositionBsDAMPSNumbers(getStorageplace());
	return rs.listIterator();
}
public Iterator getListBsgsm() {
	CDBCPositionObject cp = new CDBCPositionObject();
	CDBCResultSet rs = cp.findPositionBsGSMNumbers(getStorageplace());
	return rs.listIterator();
}
public ListIterator getListControllers() {
	CDBCPositionObject cp = new CDBCPositionObject();
	CDBCResultSet rs = cp.findPositionControllerNumbers(getStorageplace());
	return rs.listIterator();
}
public ListIterator getListSwitches() {
	CDBCPositionObject cp = new CDBCPositionObject();
	CDBCResultSet rs = cp.findPositionSwitchNumbers(getStorageplace());
	return rs.listIterator();
}
public Iterator getListWlan() {
	CDBCPositionObject cp = new CDBCPositionObject();
	CDBCResultSet rs = cp.findPositionWLANNumbers(getStorageplace());
	return rs.listIterator();
}
public java.math.BigDecimal getLongitude() {
	try {
		return parseDegree(longitudeFrm);
	} catch(Exception e) {
		return null;
	}
}
public String getLongitudeFrm() {
	return longitudeFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
public NetZone getNetZone() throws Exception {
	NetZoneAccessBean bean = constructNetzones();
	if (bean != null) {
		return (NetZone)bean.getEJBRef();
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:54:44)
 * @return java.lang.Integer
 */
public java.lang.Integer getNetzonecode() {
	return netzonecode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.05.2002 14:05:43)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getNetzones() {
	try {
		com.hps.july.persistence.NetZoneAccessBean bean = new com.hps.july.persistence.NetZoneAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:44:41)
 * @return java.sql.Date
 */
public java.sql.Date getOporadate() {
	return oporadate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2004 15:00:25)
 * @return java.lang.String
 */
public java.lang.String getOporadateFrm() {
	return oporadate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:04:18)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getOporaheight() {
	return oporaheight.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:04:49)
 * @return java.lang.String
 */
public java.lang.String getOporaheightFrm() {
	return oporaheight.getString();
}
/**
 * Признак - своя опора.
 * Creation date: (08.04.2004 16:45:58)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getOporaour() {
	return oporaour;
}
/**
 * Перечень мест размещения опор.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public CDBCResultSet getOporaplaces() {
	try {
		return new CDBCPositionObject().findAllOporaPlaces();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:01:44)
 * @return java.lang.Integer
 */
public java.lang.Integer getOporplaceid() {
	return oporplaceid;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:03:00)
 * @return java.lang.String
 */
public java.lang.String getOportypecode() {
	return oportypecode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:03:19)
 * @return java.lang.String
 */
public java.lang.String getOportypename() {
	return oportypename;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrderno() {
	return orderno;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPaya() {
    try {
        return new BigDecimal(paya);
    } catch (Exception e) {
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @return java.math.BigDecimal
 */
public String getPayaFrm() {
	return paya;
}
/**
 * Возвращает список позиций по договору аренды.
 * Creation date: (17.03.2004 15:59:38)
 * @return String
 */
public String getPositionNames(Integer argBaseDoc) {
	CDBCArendaAgreementObject co = new CDBCArendaAgreementObject();
	CDBCResultSet rs = co.findPositionsByArendaAgreement(argBaseDoc);
	ListIterator it = rs.listIterator();
	StringBuffer result = new StringBuffer();
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		result.append(ro.getColumn("name").asString());
		result.append(";");
	}
	return result.toString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:55:23)
 * @return java.lang.String
 */
public java.lang.String getPosstate() {
	return posstate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 19:56:03)
 * @return com.hps.july.persistence.RegionBean
 */
public Region getRegion() throws Exception {
    System.out.println("getRegion invoked");

    if (regioncode.isEmpty()) {
        return null;
    }
    RegionAccessBean bean = new RegionAccessBean();
    bean.setInitKey_regionid(regioncode.getInteger().intValue());
    bean.refreshCopyHelper();

    return (Region) bean.getEJBRef();
}
public String getRegioncode() throws Exception {
	return getRegionProp().getString();
}
public StringAndInteger getRegionProp() throws Exception {
	DebugSupport.printlnTest("getRegioncode started");
	if(regioncode==null){
		ListIterator li = getRegions().listIterator();
		if (li.hasNext()) {
			com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)li.next();
			Integer id=(Integer)(ro.getColumn("regionid").asObject());
			DebugSupport.printlnTest("getRegioncode id="+id);
			regioncode=new StringAndInteger();
			regioncode.setInteger(id);
		}
	}
	return regioncode;
}
/**
 * Возвращает список регионов, доступных пользователю.
 * Creation date: (19.02.2003 20:02:35)
 * @return java.util.Vector
 */
public com.hps.july.cdbc.lib.CDBCResultSet getRegions() throws Exception {
    try {
	    com.hps.july.cdbc.lib.CDBCResultSet vec = null;
	    if ("View".equalsIgnoreCase(getAction()))
        	vec = new com.hps.july.cdbc.objects.CDBCRegionsObject().findAllRegions(getUser(), isAdmin().booleanValue());
        else
        	vec = new com.hps.july.cdbc.objects.CDBCRegionsObject().findAllEditRegions(getUser(), isAdmin().booleanValue());
        return vec;
    } catch (Exception e) {
        DebugSupport.printlnError(e);
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 19:56:03)
 * @return com.hps.july.persistence.RegionBean
 */
public String getRegname() throws Exception {

    System.out.println("getRegname invoked");

    try {
        return getRegion().getRegname();
    } catch (Exception e) {
        
	    return (regname==null||regname.trim().length()==0)?"":regname;

    }

}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Organization getRenter() throws Exception {

	OrganizationAccessBean bean = constructRenters();
	if (bean != null)
	  return (Organization)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:16:47)
 * @return java.lang.Integer
 */
public java.lang.String getRentercode() {
	return rentercode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:17:03)
 * @return java.lang.String
 */
public java.lang.String getRentername() {
	return rentername;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:15:45)
 * @return java.lang.String
 */
public java.lang.String getRentervolume() {
	return rentervolume;
}
/**
 * Ресурс контейнера.
 * Creation date: (14.04.2004 13:59:26)
 * @return java.lang.String[]
 */
public java.lang.String getRescode(int index) {
	return rescode [index];
}
/**
 * Наименование ресурса контейнера.
 * Creation date: (15.04.2004 11:26:42)
 * @return java.lang.String[]
 */
public java.lang.String getResname(int index) {
	return resname [index];
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @return java.math.BigDecimal
 */
public BigDecimal getSqqty() {

    try {
        return new BigDecimal(sqqty);
    } catch (Exception e) {
        return null;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @return java.math.BigDecimal
 */
public String getSqqtyFrm() {
	return sqqty;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return getAction().equals("View")?APPStates.VIEWPOS:APPStates.EDITPOS;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @return int
 */
public int getStorageplace() {

	
	return storageplace.getInteger()==null?0:storageplace.getInteger().intValue();
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @return int
 */
public String getStorageplaceFrm() {
	return storageplace.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 14:39:23)
 * @return java.lang.String
 */
public String getSupregname() throws Exception {

    try {
        Region region = getRegion();
        return region.getSuperregion().getSupregname();
    } catch (Exception e) {
        return (supregname==null||supregname.trim().length()==0)?"":supregname;
    }
    
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getTomRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	//roles.add("siteProjector");
	roles.add("ArendaManager");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (17.03.2004 14:32:30)
 * @return java.lang.String
 */
public java.lang.String getUser() {
	return user;
}
/**
 * Роли, которым разрешено редактировать высотные сооружения.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getVcRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteProjector");
	roles.add("siteExploitor");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2003 11:31:27)
 * @return int
 */
public int getWAYMAPVARIANT() {	

	return WAYMAPVARIANT;
}
/**
 * Insert the method's description here.
 * Creation date: (03.04.2003 22:59:00)
 * @return java.lang.String
 */
public java.lang.String getZonename() {
	return zonename;
}
/**
 * Insert the method's description here.
 * Creation date: (12.05.2003 21:57:52)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 */
public boolean hasRegionAccess(HttpServletRequest request) throws Exception {
	return HasRegionAccessTag.hasAccess(request,getStorageplaceFrm(),"Edit");
}
/**
 * Insert the method's description here.
 * Creation date: (12.05.2003 21:57:52)
 * @return boolean
 * @param request javax.servlet.http.HttpServletRequest
 */
public boolean hasRegionEditAccess(HttpServletRequest request) throws Exception {
	return HasRegionAccessTag.hasAccess(request,getStorageplaceFrm(),"Edit");
}
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	setRequestData(request);
}
/**
 * Заполнение полей перед показом режима добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
    throws Exception {
    DebugSupport.printlnTest("PositionForm initRecord started");
    determineArendaVisibility(null);

	genpodrcode = null;
	genpodrname = null;
	antplaceid = null;
	oporplaceid = null;
	oportypecode = null;
	oportypename = null;
	oporaheight.setString("");
	oporadate.setString("");
	oporaour = null;
	aptypeid = null;
	applacetypeid = null;
	applaceid = null;
	posstate = "P";
	clearContainersArray();

	try {
        PositionListForm listForm = null;
        try {
            listForm =
                (PositionListForm) request.getSession().getAttribute("PositionListForm");
        } catch (Exception e) {
        }
        setAddress("");
        setDampsidFrm("");
        setDampsname("");
        setDetails("");
        setGsmidFrm("");
        setLatitudeFrm("");
        setLongitudeFrm("");
        setName("");
        setFullName("");
        setRentercode("");
        setRentername("");
        setRentervolume("");
        setInAction(Boolean.TRUE);
        dogdate.setSqlDate(null);
        datebeginbuild.setSqlDate(null);
        date_endbuild.setSqlDate(null);
        date_posclose.setSqlDate(null);
        regioncode.setString("");
        setRegname("");
        setSupregname("");
        setZonename("");
        setStorageplaceFrm("");
        if (listForm != null) {
            Integer[] reg = listForm.getRegionsSelector().getRegioncodes();
            if (reg.length > 0) {
                regioncode.setInteger(reg[0]);
                DebugSupport.printlnTest("PositionForm initRecord regioncode=" + regioncode);
            }
        }

    } catch (Exception e) {
        System.err.println(new Date());
        e.printStackTrace();
        throw e;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 21:54:02)
 * @return java.lang.Boolean
 */
public Boolean isAdmin() {
	return new Boolean(isAdmin);
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2004 14:49:46)
 * @return boolean
 */
public boolean isHaveWayMap() {
	return haveWayMap;
}
/**
 * Показывает, надо ли отображать список договоров аренды.
 * Creation date: (17.03.2004 15:08:33)
 * @return boolean
 */
public boolean isShowArendaTable() {
	return showArendaTable;
}
public static BigDecimal parseDegree(String coords)
{
	String field = coords;

	if(field != null) { field = field.trim(); }	
	if(field == null || field.trim().length() == 0)	{
		throw new java.lang.NumberFormatException("Null coords");
	}

	field = field.replace(',', '.');
	StringTokenizer atoks = new StringTokenizer(field, "-", true);
	String next = "", prev = "";
	int tc = 0;
	double[] g = new double[3];
	for(int i = 0; i < 3 && atoks.hasMoreTokens(); ) {
		next = atoks.nextToken().trim();
		if("-".equals(next)) {
			tc++;
			if("-".equals(prev)) { i++; }
		} else {
			g[i] = Double.valueOf(next).doubleValue();
			i++;
		}
		prev = next;
	}
	if(atoks.hasMoreTokens() && tc > 2) {
		throw new NumberFormatException("Format unknown");
	}

	double d = g[0] + g[1] / 60 + g[2] / 3600;
	if(field.charAt(0) == '-') {
		d = -d;
	}
	if(Math.abs(d) > 360.0d) {
		throw new java.lang.NumberFormatException("Given value exceed 360 degree");
	}

	return new BigDecimal(d).setScale(6,BigDecimal.ROUND_HALF_UP);
}
    /**
     * Reset all bean properties to their default state.  This method is
     * called before the properties are repopulated by the controller servlet.
     * <p>
     * The default implementation does nothing.  Subclasses should override
     * this method to reset all bean properties to default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
		clearContainersArray();
    }
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:07:28)
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:00:45)
 * @param newAntplaceid java.lang.Integer
 */
public void setAntplaceid(java.lang.Integer newAntplaceid) {
	antplaceid = newAntplaceid;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:51:55)
 * @param newApplaceid java.lang.Integer
 */
public void setApplaceid(java.lang.Integer newApplaceid) {
	applaceid = newApplaceid;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:49:39)
 * @param newApplacetypeid java.lang.Integer
 */
public void setApplacetypeid(java.lang.Integer newApplacetypeid) {
	applacetypeid = newApplacetypeid;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:47:34)
 * @param newAptypeid java.lang.Integer
 */
public void setAptypeid(java.lang.Integer newAptypeid) {
	aptypeid = newAptypeid;
}
/**
 * 
 * @param newComment_doc java.lang.String
 */
public void setComment_doc(java.lang.String newComment_doc) {
	comment_doc = newComment_doc;
}
/**
 * Высота контейнера.
 * Creation date: (14.04.2004 14:00:14)
 * @param newContsizeh java.lang.String[]
 */
public void setContsizeh(int index, java.lang.String newContsizeh) {
	contsizeh [index]= newContsizeh;
}
/**
 * Длина контейнера.
 * Creation date: (14.04.2004 14:00:34)
 * @param newContsizel java.lang.String[]
 */
public void setContsizel(int index, java.lang.String newContsizel) {
	contsizel [index] = newContsizel;
}
/**
 * Ширина контейнера.
 * Creation date: (14.04.2004 13:59:56)
 * @param newContsizew java.lang.String[]
 */
public void setContsizew(int index, java.lang.String newContsizew) {
	contsizew [index] = newContsizew;
}
/**
 * Год производства контейнера.
 * Creation date: (14.04.2004 14:00:59)
 * @param newContyear java.lang.String[]
 */
public void setContyear(int index, java.lang.String newContyear) {
	contyear [index] = newContyear;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:10:59)
 * @param newDampsid java.lang.Integer
 */
public void setDampsid(java.lang.Integer newDampsid) {
	dampsid.setInteger(newDampsid);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:22:14)
 * @param newDampsidFrm java.lang.String
 */
public void setDampsidFrm(java.lang.String newDampsidFrm) {
	dampsid.setString(newDampsidFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:11:45)
 * @param newDampsname java.lang.String
 */
public void setDampsname(java.lang.String newDampsname) {
	dampsname = newDampsname;
}
public void setDate_endbuild(java.sql.Date newDate) {
	date_endbuild.setSqlDate(newDate);
}
public void setDate_endbuildFrm(String newDate) {
	date_endbuild.setString(newDate);
}
public void setDate_posclose(java.sql.Date newDate) {
	date_posclose.setSqlDate(newDate);
}
public void setDate_poscloseFrm(String newDate) {
	date_posclose.setString(newDate);
}
public void setDatebeginbuild(java.sql.Date newDate) {
	datebeginbuild.setSqlDate(newDate);
}
public void setDatebeginbuildFrm(String newDate) {
	datebeginbuild.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:12:48)
 * @param newDetails java.lang.String
 */
public void setDetails(java.lang.String newDetails) {
	details = newDetails;
}
/**
 * 
 * @param newDocaddress java.lang.String
 */
public void setDocaddress(java.lang.String newDocaddress) {
	docaddress = newDocaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:35:23)
 * @param newDogdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDogdate(java.sql.Date newDogdate) {
	
	dogdate.setSqlDate(newDogdate);
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:35:23)
 * @param newDogdate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDogdateFrm(String newDogdate) {
	dogdate.setString(newDogdate);
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:35:23)
 * @param newDognumber java.lang.String
 */
public void setDognumber(java.lang.String newDognumber) {
	dognumber = newDognumber;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2003 12:18:33)
 * @param newFullName java.lang.String
 */
public void setFullName(java.lang.String newFullName) {
	fullName = newFullName;
}
/**
 * Генеральный подрядчик - код.
 * Creation date: (08.04.2004 15:58:51)
 * @param newGenpodrcode java.lang.Integer
 */
public void setGenpodrcode(String newGenpodrcode) {
	genpodrcode = newGenpodrcode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 15:59:09)
 * @param newGenpodrname java.lang.String
 */
public void setGenpodrname(java.lang.String newGenpodrname) {
	genpodrname = newGenpodrname;
}
/**
 * 
 * @param newGrchaddress java.lang.String
 */
public void setGrchaddress(java.lang.String newGrchaddress) {
	grchaddress = newGrchaddress;
}
/**
 * 
 * @param newGrchlat java.lang.String
 */
public void setGrchlat(java.lang.String newGrchlat) {
	grchlat = newGrchlat;
}
/**
 * 
 * @param newGrchlong java.lang.String
 */
public void setGrchlong(java.lang.String newGrchlong) {
	grchlong = newGrchlong;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:11:25)
 * @param newGsmid java.lang.Integer
 */
public void setGsmid(java.lang.Integer newGsmid) {
	gsmid.setInteger(newGsmid);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:22:29)
 * @param newGsmidFrm java.lang.String
 */
public void setGsmidFrm(java.lang.String newGsmidFrm) {
	gsmid.setString(newGsmidFrm);
}
/**
 * 
 * @param newHaveplan java.lang.String
 */
public void setHaveplan(java.lang.String newHaveplan) {
	haveplan = newHaveplan;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2004 14:49:46)
 * @param newHaveWayMap boolean
 */
public void setHaveWayMap(boolean newHaveWayMap) {
	haveWayMap = newHaveWayMap;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2002 15:48:21)
 * @param newInAction java.lang.Boolean
 */
public void setInAction(java.lang.Boolean newInAction) {
	inAction = newInAction;
}
public void setIsAdmin(Boolean newIsAdmin) {
	isAdmin = newIsAdmin.booleanValue();
}
public void setLatitude(java.math.BigDecimal newLatitude) {
	_tempBd.setBigDecimal(newLatitude);
	latitudeFrm = _tempBd.getString();
}
public void setLatitudeFrm(java.lang.String newLatitudeFrm)
{
	latitudeFrm = newLatitudeFrm;
}
public void setLinktogosnetlat(String newLatitude) {
	linktogosnetlat = newLatitude;
}
public void setLinktogosnetlatFrm(String newLatitudeFrm) {
	linktogosnetlat = newLatitudeFrm;
}
public void setLinktogosnetlon(String newLongitude) {
	linktogosnetlon = newLongitude;
}
public void setLinktogosnetlonFrm(String newLatitudeFrm) {
	linktogosnetlon = newLatitudeFrm;
}
public void setLongitude(java.math.BigDecimal newLongitude) {
	_tempBd.setBigDecimal(newLongitude);
	longitudeFrm = _tempBd.getString();
}
public void setLongitudeFrm(java.lang.String newLongitudeFrm) {
	longitudeFrm = newLongitudeFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setNetZone(NetZoneAccessBean newNetZone) throws Exception {
	if (newNetZone == null) {
	    netzonecode = new Integer(0);
	}
	else {
		netzonecode = new Integer(newNetZone.getNetzone());
		zonename=newNetZone.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 12:54:44)
 * @param newNetzonecode java.lang.Integer
 */
public void setNetzonecode(java.lang.Integer newNetzonecode) {
	netzonecode = newNetzonecode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:44:41)
 * @param newOporadate java.sql.Date
 */
public void setOporadate(java.sql.Date newOporadate) {
	oporadate.setSqlDate(newOporadate);
}
/**
 * Insert the method's description here.
 * Creation date: (09.04.2004 15:00:25)
 * @param newOporadateFrm java.lang.String
 */
public void setOporadateFrm(java.lang.String newOporadateFrm) {
	oporadate.setString(newOporadateFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:04:18)
 * @param newOporaheight java.math.BigDecimal
 */
public void setOporaheight(java.math.BigDecimal newOporaheight) {
	oporaheight.setBigDecimal(newOporaheight);
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:04:49)
 * @param newOporaheightFrm java.lang.String
 */
public void setOporaheightFrm(java.lang.String newOporaheightFrm) {
	oporaheight.setString(newOporaheightFrm);
}
/**
 * Признак - своя опора.
 * Creation date: (08.04.2004 16:45:58)
 * @param newOporaour java.lang.Boolean
 */
public void setOporaour(java.lang.Boolean newOporaour) {
	oporaour = newOporaour;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:01:44)
 * @param newOporplaceid java.lang.Integer
 */
public void setOporplaceid(java.lang.Integer newOporplaceid) {
	oporplaceid = newOporplaceid;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:03:00)
 * @param newOportypecode java.lang.String
 */
public void setOportypecode(java.lang.String newOportypecode) {
	oportypecode = newOportypecode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:03:19)
 * @param newOportypename java.lang.String
 */
public void setOportypename(java.lang.String newOportypename) {
	oportypename = newOportypename;
}
/**
 * 
 * @param newOrderno java.lang.String
 */
public void setOrderno(java.lang.String newOrderno) {
	orderno = newOrderno;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @param newPaya java.math.BigDecimal
 */
public void setPaya(java.math.BigDecimal newPaya) {
	paya=(newPaya==null?null:newPaya.toString());
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @param newPaya java.math.BigDecimal
 */
public void setPayaFrm(String newPaya) throws Exception {
	paya = newPaya;
}
/**
 * Insert the method's description here.
 * Creation date: (08.04.2004 16:55:23)
 * @param newPosstate java.lang.String
 */
public void setPosstate(java.lang.String newPosstate) {
	posstate = newPosstate;
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 19:57:37)
 * @param bean com.hps.july.persistence.RegionAccessBean
 */
public void setRegion(RegionAccessBean bean) throws Exception {
	if(bean!=null){
	regioncode=new StringAndInteger();	
    regioncode.setInteger(new Integer(bean.getRegionid()));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (19.02.2003 20:27:43)
 * @param str java.lang.String
 */
public void setRegioncode(String str) throws Exception {
	regioncode.setString(str);


	
	}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 14:39:23)
 * @return java.lang.String
 */
public void setRegname(String val) {

   regname=val;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setRenter(OrganizationAccessBean newOrganization) throws Exception {
	if (newOrganization == null) {
	    rentercode.setString("");
	    rentername = "";
	}
	else {
		rentercode.setInteger(new Integer(newOrganization.getOrganization()));
		rentername = newOrganization.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:16:47)
 * @param newRentercode java.lang.Integer
 */
public void setRentercode(java.lang.String newRentercode) {
	rentercode.setString(newRentercode);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:17:03)
 * @param newRentername java.lang.String
 */
public void setRentername(java.lang.String newRentername) {
	rentername = newRentername;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:15:45)
 * @param newRentervolume java.lang.String
 */
public void setRentervolume(java.lang.String newRentervolume) {
	rentervolume = newRentervolume;
}
public void setRequestData(HttpServletRequest request)
{
	setIsAdmin(new Boolean(request.isUserInRole("administrator")));
	isFreqmanager = request.isUserInRole("FreqManager");
	setUser(request.getRemoteUser());
}
/**
 * Ресурс контейнера.
 * Creation date: (14.04.2004 13:59:26)
 * @param newRescode java.lang.String[]
 */
public void setRescode(int index, java.lang.String newRescode) {
	rescode [index] = newRescode;
}
/**
 * Наименование ресурса контейнера.
 * Creation date: (15.04.2004 11:26:42)
 * @param newResname java.lang.String[]
 */
public void setResname(int index, java.lang.String newResname) {
	resname [index] = newResname;
}
/**
 * Insert the method's description here.
 * Creation date: (17.03.2004 15:08:33)
 * @param newShowArendaTable boolean
 */
public void setShowArendaTable(boolean newShowArendaTable) {
	showArendaTable = newShowArendaTable;
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @param newSqqty java.math.BigDecimal
 */
public void setSqqty(java.math.BigDecimal newSqqty) {
	sqqty = (newSqqty==null?null:newSqqty.toString());
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @param newPaya java.math.BigDecimal
 */
public void setSqqtyFrm(String arg) throws Exception {
	sqqty = arg;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace.setInteger(new Integer(newStorageplace));
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 11:33:09)
 * @param newStorageplace int
 */
public void setStorageplaceFrm(String newStorageplace) {
	
	
	storageplace.setString(newStorageplace);

	DebugSupport.printlnTest("PositionForm setStorageplaceFrm storageplace="+getStorageplace());
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2003 14:39:23)
 * @return java.lang.String
 */
public void setSupregname(String val) {

   supregname=val;
}
/**
 * Insert the method's description here.
 * Creation date: (17.03.2004 14:32:30)
 * @param newUser java.lang.String
 */
public void setUser(java.lang.String newUser) {
/*
	if(newUser == null) {
		try {
			throw new Exception("setUser(NULL)");
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	} else {
		System.out.println("PositionForm.setUser("+newUser+")");
	}
*/
	user = newUser;
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2003 11:31:27)
 * @param newWAYMAPVARIANT int
 */
public void setWAYMAPVARIANT(int newWAYMAPVARIANT) {
	WAYMAPVARIANT = newWAYMAPVARIANT;
}
/**
 * Insert the method's description here.
 * Creation date: (03.04.2003 22:59:00)
 * @param newZonename java.lang.String
 */
public void setZonename(java.lang.String newZonename) {
	zonename = newZonename;
}
/**
 * Обновление списка контейнеров для позиции.
 * Creation date: (04.06.2002 11:07:28)
 * @return java.lang.String
 */
public void updateContainers() throws Exception {
	   // Журналирований изменений контейнеров -
	   //    будем производить вручную, т.к. их надо
	   //    показывать вместе с изменением позиции
	   // Определим оператора
	   Integer oper = OperatorObject.getOperatorCode(getUser());
	   System.out.println("POS#1: oper=" + oper.toString());
	   CDBCLogObject log = new CDBCLogObject();
	   Integer logid = log.changesLog(log.POSITION, new Integer(getStorageplace()), new Integer(getStorageplace()), log.UPDATE, oper);
	   System.out.println("POS#2: logid=" + logid.toString());

	   // Запомним текущую конфигурацию контейнеров в виде текста
	   String beforeUpdContainers = getContainersInfoString();
	   
		// Обновим контейнеры
		CDBCPositionObject po = new CDBCPositionObject();
		po.deleteContainers(getStorageplace());
		StringAndIntegerProperty spres = new StringAndIntegerProperty();
		StringAndBigDecimal spw = new StringAndBigDecimal(4, 1);
		StringAndBigDecimal sph = new StringAndBigDecimal(4, 1);
		StringAndBigDecimal spl = new StringAndBigDecimal(4, 1);
		StringAndIntegerProperty spy = new StringAndIntegerProperty();
		KeyGeneratorAccessBean keygen = new KeyGeneratorAccessBean();
		for (int i= 0; i < MAXCONTAINERS; i++) {
			spres.setString(getRescode(i));
			spw.setString(getContsizew(i));
			sph.setString(getContsizeh(i));
			spl.setString(getContsizel(i));
			spy.setString(getContyear(i));
			if ( !spres.isEmpty() ) {
				int cont = keygen.getNextKey(com.hps.july.siteinfo.TablesRef.CONTTABLENAME);
				ContainerAccessBean ab = new ContainerAccessBean(cont, getStorageplace(), spres.getInteger().intValue());
				ab.setWidth(spw.getBigDecimal());
				ab.setHeight(sph.getBigDecimal());
				ab.setLength(spl.getBigDecimal());
				ab.setYear(spy.getInteger());
				ab.commitCopyHelper();
			}
		}
	   // После обновления контейнеров
	   // Запомним текущую конфигурацию контейнеров в виде текста
	   String afterUpdContainers = getContainersInfoString();

	   // Запишем в журнал
	   System.out.println("POS#3: before=" + beforeUpdContainers + "\r\n After=" + afterUpdContainers);
	   log.changesLogDetails(logid, "label.positions.containers", beforeUpdContainers, afterUpdContainers);
}
/**
 * Обновление подрядной организации.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
private void updatePodrOrganization(String podrCode, String podrType) throws Exception {
		// Запомним подрядчиков
		StringAndIntegerProperty sp = new StringAndIntegerProperty();
		sp.setString(podrCode);
		int gptype = AppUtils.getNamedValueInt(podrType);
		PositionResponsibleWorkersAccessBean pab = new PositionResponsibleWorkersAccessBean();
		boolean haveResponsible = false;
		try {
			pab.setInitKey_type_responsibilityType(new Integer(gptype));
			pab.setInitKey_position_storageplace(new Integer(getStorageplace()));
			pab.setInitKey_resptype("O");
			pab.refreshCopyHelper();
			haveResponsible = true;
		} catch (javax.ejb.ObjectNotFoundException e) {
			// Suppress not found exception
			pab = null;
		}
		
		if ( !sp.isEmpty() && sp.isOk() ) {
			if (!haveResponsible) {	
				pab = new PositionResponsibleWorkersAccessBean(new Integer(gptype),  new Integer(getStorageplace()), "O");
			}

			OrganizationAccessBean oab = constructOrganization(sp.getInteger().intValue());
			if (oab != null)
				pab.setOrganization((Organization)oab.getEJBRef());
			else
				pab.setOrganization(null);

			pab.commitCopyHelper();
		} else {
			if (haveResponsible) {
				com.hps.july.jdbcpersistence.lib.AbstractJournalProcessAction act = new com.hps.july.jdbcpersistence.lib.AbstractJournalProcessAction();
				act.deleteObject(pab.getEJBRef());
				//pab.getEJBRef().remove();
			}
		}
}
/**
 * Проверка правильности заполения полей.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors)
	throws Exception
{
	if (getRegionProp().isOkAndNotEmpty()) {
		if (!com.hps.july.apptags.HasRegionAccessTag.isRegionAccessible(getRegionProp().getInt(), "Edit", 
				getUser(), isAdmin().booleanValue()))
	        errors.add(ActionErrors.GLOBAL_ERROR,  new ActionError("error.invalid.position.region"));
	}
	if(this.netzonecode == null) {
        errors.add(ActionErrors.GLOBAL_ERROR,  new ActionError("error.invalid.position.netzone"));
	}

    if ((getName() == null) || (getName().length() == 0))
        errors.add(ActionErrors.GLOBAL_ERROR,  new ActionError("error.empty.position.name"));

    //if ((getDampsname() == null) || (getDampsname().length() == 0))
    //  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.position.dampsname"));
    DebugSupport.printlnTest("gsmid=" + gsmid.getInt());
    if (!gsmid.isOk()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.gsmid"));
    }
    if (!dampsid.isOk()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.dampsid"));

    }

    if ((getAddress() == null) || (getAddress().length() == 0)) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.position.addr"));
    }

	if(latitudeFrm == null || latitudeFrm.trim().length() < 1) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.position.latitude"));
	} else {
		try {
			parseDegree(latitudeFrm);
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.latitude"));
		}
	}
/*
	if (latitude.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.position.latitude"));
	} else if (!latitude.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.latitude"));
	}
*/
	if(longitudeFrm == null || longitudeFrm.trim().length() < 1) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.position.longitude"));
	} else {
		try {
			parseDegree(longitudeFrm);
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.longitude"));
		}
	}
/*
	if (longitude.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.position.longitude"));
	} else if (!longitude.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.longitude"));
	}
*/
	if (linktogosnetlat != null && !"".equals(linktogosnetlat)) {
		if(linktogosnetlat.length() > 12) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.linktogosnetlat"));
		} else {
			try {
				linktogosnetlat = convertDegree(linktogosnetlat);
			} catch(Exception e) {
				if(e.getMessage() != null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(e.getMessage()+".goslat"));
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.convdegree.goslat"));
				}
			}
		}
	}

    if (linktogosnetlon != null && !"".equals(linktogosnetlon))
    	if(linktogosnetlon.length() > 12) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.linktogosnetlon"));
    	} else {
			try {
				linktogosnetlon = convertDegree(linktogosnetlon);
			} catch(Exception e) {
				if(e.getMessage() != null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(e.getMessage()+".goslong"));
				} else {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.convdegree.goslong"));
				}
			}
    	}
/*
    if(isFreqManager()) {
		if ((getDocaddress() != null) || (getDocaddress().length() > 255)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.docaddr"));
	    }

		if ((getGkrchaddress() != null) || (getGkrchaddress().length() > 255)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.gkrchaddr"));
		}

    }
*/

	if(isFreqmanager || isAdmin) {
	    if (grchlat != null && !"".equals(grchlat)) {
		    if(grchlat.length() > 12) {
		        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.grchlat"));
		    } else {
				try {
					grchlat = convertDegree(grchlat);
				} catch(Exception e) {
					if(e.getMessage() != null) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(e.getMessage()+".grchlat"));
					} else {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.convdegree.grchlat"));
					}
				}
		    }
	    }

	    if (grchlong != null && !"".equals(grchlong)) {
		    if(grchlong.length() > 12) {
		        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.grchlong"));
		    } else {
				try {
					grchlong = convertDegree(grchlong);
				} catch(Exception e) {
					if(e.getMessage() != null) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(e.getMessage()+".grchlong"));
					} else {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.convdegree.grchlong"));
					}
				}
		    }
	    }
	    
		if (getComment_doc() != null && getComment_doc().length() > 255) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.comment_doc"));
		}
	}

    try {
        if (!rentercode.isEmpty() && rentercode.isOk()) {
            constructRenters();
            if (!renters.getIsrenter().booleanValue())
                errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.renter"));
        }
    } catch (Exception ex) {
        if (ErrorProcessor.isRecordNotExistException(ex))
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.renter"));
        else
            throw ex;
    }

    try {
        validSqqty();
    } catch (Exception esqqty) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.sqqty"));
    }
    try {
        validPaya();
    } catch (Exception esqqty) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.paya"));
    }

    // Проверим подрядчиков 
    	StringAndIntegerProperty sp = new StringAndIntegerProperty();
		sp.setString(getGenpodrcode());
		if ( !sp.isEmpty() && !sp.isOk() ) {
        	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.genpodr"));
		}
		sp.setString(getOportypecode());
		if ( !sp.isEmpty() && !sp.isOk() ) {
        	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.oporatype"));
		}

		// Проверим высоту опоры
		if ( !oporaheight.isEmpty() && !oporaheight.isOk() ) {
        	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.oporaheight", oporaheight.formatMessage()));
		}

		// Проверим контейнеры
		StringAndIntegerProperty spres = new StringAndIntegerProperty();
		StringAndBigDecimal spw = new StringAndBigDecimal(6, 2);
		StringAndBigDecimal sph = new StringAndBigDecimal(6, 2);
		StringAndBigDecimal spl = new StringAndBigDecimal(6, 2);
		StringAndIntegerProperty spy = new StringAndIntegerProperty();
		for (int i= 0; i < MAXCONTAINERS; i++) {
			spres.setString(getRescode(i));
			spw.setString(getContsizew(i));
			sph.setString(getContsizeh(i));
			spl.setString(getContsizel(i));
			spy.setString(getContyear(i));
			// Check if any of the fields are filled
			if (!spres.isEmpty() || !spw.isEmpty() || !sph.isEmpty() || !spl.isEmpty() || !spy.isEmpty() ) {
				if (spres.isEmpty() || !spres.isOk())
        			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.contres", spres.getString()));
        		if (!spres.isEmpty() && spres.isOk()) {
	        		// Test resource
	        		try {
	        			ResourceAccessBean rb = new ResourceAccessBean();
	        			rb.setInitKey_resource(spres.getInteger().intValue());
	        			rb.refreshCopyHelper();
	        		} catch (javax.ejb.ObjectNotFoundException e) {
        				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.contres", spres.getString()));
	        		}
        		}
        		if (!spw.isEmpty() && !spw.isOk()) 
        			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.contsizew", spw.getString(), spw.formatMessage()));
        		if (!sph.isEmpty() && !spw.isOk()) 
        			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.contsizeh", sph.getString(), sph.formatMessage()));
        		if (!spl.isEmpty() && !spw.isOk()) 
        			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.contsizel", spl.getString(), spl.formatMessage()));
        		if (!spy.isEmpty() && !spy.isOk()) 
        			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.contyear", spy.getString()));
        		if (!spy.isEmpty() && spy.isOk())
        			if (spy.getInteger().intValue() <= 0)
        				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.contyear", spy.getString()));
			}
		}

	if(haveplan != null && !"".equals(haveplan.trim())) {
		if(!"A".equals(haveplan) && !"B".equals(haveplan) && !"C".equals(haveplan) && !"D".equals(haveplan)) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.position.haveplan"));
		}
	} else {
		haveplan = null;
	}

    if (!errors.empty())
        throw new ValidationException();
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @return java.math.BigDecimal
 */
private void validPaya() {
 if(paya!=null&&paya.trim().length()!=0)    
	new BigDecimal(paya);
    
}
/**
 * Insert the method's description here.
 * Creation date: (15.03.2003 16:36:47)
 * @return java.math.BigDecimal
 */
private void validSqqty() {
if(sqqty!=null&&sqqty.trim().length()!=0)
    new BigDecimal(sqqty);
   
}
}
