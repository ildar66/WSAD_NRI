package com.hps.july.basestation.formbean;

import com.hps.july.persistence2.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.sitedoc.valueobject.*;
import com.hps.july.basestation.valueobject.ComlineRDocumentValue;
import com.hps.july.basestation.valueobject.NestedHopInfo;
import java.util.*;
import java.util.Vector;
import java.util.Enumeration;
import javax.servlet.http.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.trailcom.beans.*;
import com.hps.july.web.util.*;
import com.hps.july.jdbcpersistence.lib.*;
import org.apache.struts.action.*;
import java.math.*;
import com.hps.july.basestation.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования радиорелейной линии связи
 */
public class ComlineRForm extends EquipmentPForm {
	private String showType = null; // F - фактические данные, D - документарные
	private String cpy;
	
	private java.lang.String abis_number;
	private int equipmentid_enda;
	private int equipmentid_endb;
	private int hopsid;
	private String beenetid;
//	private java.lang.String hopstype;
	private java.lang.String lease_info;
	private java.lang.String rezerv;
	private java.lang.String speed;
	private java.lang.String speed_doc;
	private java.lang.String hopsname;

	private java.lang.String height_aFrm;
	private java.lang.String height_bFrm;
	private java.lang.String height_a_docFrm;
	private java.lang.String height_b_docFrm;

	private java.lang.String diam_aFrm;
	private java.lang.String diam_bFrm;
	private java.lang.String diam_a_docFrm;
	private java.lang.String diam_b_docFrm;

	private java.lang.String freqa1Frm;
	private java.lang.String freqa2Frm;
	private java.lang.String freqb1Frm;
	private java.lang.String freqb2Frm;
	private java.lang.String freqadocFrm;
	private java.lang.String freqbdocFrm;

	private java.lang.String poweraFrm;
	private java.lang.String powerbFrm;
	private java.lang.String powerdocFrm;

	private java.lang.Integer rescodea;
	private java.lang.String resnamea;
//	private java.lang.Integer rescodeb;
//	private java.lang.String resnameb;
	private java.lang.Integer rescodedoc;
	private java.lang.String resnamedoc;

	private java.lang.String azimutabdocFrm;
	private java.lang.String azimutbadocFrm;

	private java.lang.String posidaFrm;
	private java.lang.String posidbFrm;
	private java.lang.String posnamea;
	private java.lang.String posnameb;
	private java.lang.String commenta;
	private java.lang.String commentb;
	private java.lang.String equipnamea;
	private java.lang.String equipnameb;
	private java.lang.String equipmodela;
	private java.lang.String equipmodelb;
	private java.lang.String hopscomment;
	private java.lang.String azimutab;
	private java.lang.String azimutba;
	private PositionAccessBean positiona;
	private PositionAccessBean positionb;
	private java.lang.String hopslength;
	private java.lang.String newcomplecta;
	private java.lang.String newcomplectb;

	private boolean showregions;
	private String regiona;
	private String regionb;

	// A - Проектируется, B - Настраивается, C - Эксплуатируется, D - Выведен из эксплуатации
	private String hopstate;

	// Статус по разрешению
	// Соответствующие состояния описаны как label.comline.permstatus
	// 0 - 9
	private String permstatus;

	// Флаг подтверждения пользователем сохранения формы после предупреждений
	private boolean approve;

	private java.lang.String file_number;
	private java.lang.String old_file_number;
	private java.lang.String number_in_file;
	private java.lang.String comment_doc;
	private String sfonumber; // CHAR(20)
	private java.lang.String created;
	private java.lang.String createdBy;
	private java.lang.String modified;
	private java.lang.String modifiedBy;
	private int operator;
public void afterUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	StringAndIntegerProperty si = new StringAndIntegerProperty();
	// update com equipment if edit
	if("Add".equals(getAction()) || "Edit".equals(getAction())) {
		// update point a
		try {
			log("Get COMA "+getEquipmentid_enda());
			ComEquipmentAccessBean end1 = new ComEquipmentAccessBean();
			end1.setInitKey_storageplace(getEquipmentid_enda());
			end1.refreshCopyHelper();
			end1.setEquipcomment(getCommenta());
			end1.setResource(constructResource(getRescodea()));
			end1.setName(getEquipnamea());
			end1.commitCopyHelper();
		} catch(Exception e) {
			log("Error getting COMA "+getEquipmentid_enda());
		}

		// update point b
		try {
			log("Get COMB "+getEquipmentid_endb());
			ComEquipmentAccessBean end2 = new ComEquipmentAccessBean();
			end2.setInitKey_storageplace(getEquipmentid_endb());
			end2.refreshCopyHelper();
			end2.setEquipcomment(getCommentb());
			end2.setResource(constructResource(getRescodea()));
			end2.setName(getEquipnameb());
			end2.commitCopyHelper();
		} catch(Exception e) {
			log("Error getting COMB "+getEquipmentid_endb());
		}

		// Обновление файла и номера в файле
		if(request.isUserInRole("FreqManager") || request.isUserInRole("administrator")) {
			updateFrequencyLicence();
		}
	}
}
public void beforeDelete(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception 
{
	try {
		SiteDocObject.deleteHopsDocuments(new HopKey(getHopsid()));
//		Enumeration endoc = (new Sitedoc2HopsAccessBean()).findSitedoc2HopsByHop(new HopKey(getHopsid()));
//		while(endoc.hasMoreElements()) {
//			Sitedoc2HopsAccessBean doc2hop = (Sitedoc2HopsAccessBean)endoc.nextElement();
//			int sitedoc = doc2hop.getSitedoc();
//			boolean deletedocument = false;
//			SiteDocAccessBean sd = new SiteDocAccessBean();
//			sd.setInitKey_sitedoc(sitedoc);
//			sd.refreshCopyHelper();

//			PositionAccessBean posA = getPositionByEquipment(doc2hop.getHop().getEquipmentid_enda());
//			if(posA != null) {
				// add this document to position a
//				new Sitedoc2SplaceAccessBean(sitedoc,posA.getStorageplace());
//			}

//			PositionAccessBean posB = getPositionByEquipment(doc2hop.getHop().getEquipmentid_endb());
//			if(posB != null) {
				// add this document to position b
//				new Sitedoc2SplaceAccessBean(sitedoc,posB.getStorageplace());
//			}
			
//			doc2hop.getEJBRef().remove();
//		}

		// Before delete
		Enumeration en = (new HopLabelAccessBean()).findByHopsidOrderByHopslabelidAsc(new Integer(getHopsid()));
		while(en.hasMoreElements()) {
			HopLabelAccessBean hlbean = (HopLabelAccessBean)en.nextElement();
			hlbean.getEJBRef().remove();
		}
		
	    RRLHops2AccessBean rrlbean = new RRLHops2AccessBean();
	    rrlbean.setInitKey_hopid_hopsid(new Integer(getHopsid()));
	    rrlbean.refreshCopyHelper();
	    rrlbean.getEJBRef().remove();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		// say about errors on delete
	}
}
public void beforeUpdate(AbstractEntityAccessBean bean, HttpServletRequest request)
	throws Exception
{
	if(cpy != null && "fd".equals(cpy)) {
		copyFact2Doc();
		throw new ValidationException();
	} else if(cpy != null && "df".equals(cpy)) {
		copyDoc2Fact();
		throw new ValidationException();
	}
	
	if(bean == null) {
		throw new UpdateValidationException("error.comlineform.update.beanisnull");
	}
	/*
    // Create new comEquipment A if needed
    if("Add".equals(getAction())) {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		if ("Y".equals(getNewcomplecta())) {
			createComEquipmentA(keyGen);
	    }
		// Create new comEquipment B if needed
		if ("Y".equals(getNewcomplectb())) {
			createComEquipmentB(keyGen);
		}
    }
    */
	HopAccessBean bn = (HopAccessBean)bean;
	bn.setEquipmentid_enda(getEquipmentid_enda());
	bn.setEquipmentid_endb(getEquipmentid_endb());


	try {
          operator =
              new OperatorAccessBean()
                    .findByLogin(request.getUserPrincipal().getName())
                    .getOperator();
    } catch (Exception ex) {
          System.out.println("Can't get Operator from request\n");
    }
	
	bn.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
	bn.setModifiedby(new Integer(operator));

	if("Add".equals(getAction())) {
		bn.setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
		bn.setCreatedby(new Integer(operator));
	}
	
//	bn.setHopstype("R");

	Enumeration en = (new HopLabelAccessBean()).findByHopsidOrderByHopslabelidAsc(new Integer(getHopsid()));
	if(en.hasMoreElements()) {
		HopLabelAccessBean hlbean = (HopLabelAccessBean)en.nextElement();
		hlbean.setHopsname(getHopsname());
		hlbean.setHopsnamecomments(getHopscomment());
		hlbean.commitCopyHelper();
	} else {
		throw new UpdateValidationException("error.comlineform.update.hopslabelnotfound");
	}
	
    RRLHops2AccessBean rrlbean = new RRLHops2AccessBean();
    rrlbean.setInitKey_hopid_hopsid(new Integer(getHopsid()));
    rrlbean.refreshCopyHelper();
    
    rrlbean.setDiam_a(getDouble(getDiam_aFrm()));
    rrlbean.setDiam_b(getDouble(getDiam_bFrm()));
System.out.println("COMLine(Diam_b):"+getDiam_bFrm()+":");
    rrlbean.setDiam_a_doc(getDouble(getDiam_a_docFrm()));
    rrlbean.setDiam_b_doc(getDouble(getDiam_b_docFrm()));
    rrlbean.setHeight_a(getDouble(getHeight_aFrm()));
    rrlbean.setHeight_b(getDouble(getHeight_bFrm()));
System.out.println("COMLine(Height_b):"+getHeight_bFrm()+":");
    rrlbean.setHeight_a_doc(getDouble(getHeight_a_docFrm()));
    rrlbean.setHeight_b_doc(getDouble(getHeight_b_docFrm()));
    rrlbean.setFrequency_a1(getDouble(getFreqa1Frm()));
    rrlbean.setFrequency_a2(getDouble(getFreqa2Frm()));
    rrlbean.setFrequency_a2(getDouble(getFreqa2Frm()));
    rrlbean.setFrequency_a_doc(getDouble(getFreqadocFrm()));
    rrlbean.setFrequency_b1(getDouble(getFreqb1Frm()));
    rrlbean.setFrequency_b2(getDouble(getFreqb2Frm()));
    rrlbean.setFrequency_b_doc(getDouble(getFreqbdocFrm()));
    rrlbean.setPower_a(getDouble(getPoweraFrm()));
    rrlbean.setPower_b(getDouble(getPowerbFrm()));
	rrlbean.setPower_doc(getDouble(getPowerdocFrm()));
	rrlbean.setComment_a(getCommenta());
	rrlbean.setComment_b(getCommentb());
System.out.println("SPEED_DOC:"+getSpeed_doc());
	rrlbean.setSpeed_doc(getSpeed_doc());
	rrlbean.setResource_doc(getRescodedoc());
	rrlbean.setComment_doc(getComment_doc());

    StringAndBigDecimalProperty sbd = new StringAndBigDecimalProperty();
    sbd.setString(getAzimutabdocFrm());
	rrlbean.setAzimuthAB_Doc(sbd.getBigDecimal());
    sbd.setString(getAzimutbadocFrm());
	rrlbean.setAzimuthBA_Doc(sbd.getBigDecimal());
	
	rrlbean.commitCopyHelper();
}
public static BigDecimal calcAzimut(BigDecimal l1, BigDecimal f1, BigDecimal l2, BigDecimal f2)
{
	// ACOT( COS(F1)*TAN(F2)*COSEC(L2-L1) - SIN(F1)*COT(L2-L1) );
	if(l1 == null || f1 == null || l2 == null || f2 == null) {
		return null;
	}
	double f1r = Math.toRadians(f1.doubleValue());
	double f1r90 = Math.toRadians(90.0d-f1.doubleValue());
	double f2r = Math.toRadians(f2.doubleValue());
	double f2r90 = Math.toRadians(90.0d-f2.doubleValue());
	double l1r = Math.toRadians(l1.doubleValue());
	double l2r = Math.toRadians(l2.doubleValue());
	
	if((f1r == 0.0d && l1r == 0.0d) || (f2r == 0.0d && l2r == 0.0d) ) {
		return null;
	}

	// b = arccos(cos(90-lat2)*cos(90-lat1)+sin(90-lat2)*sin(90-lat1)*cos(lon2-lon1))
	// L = (ER) * b;
	// A = arcsin(sin(90-lat2)*sin(lon2-lon1)/sin(b))
	double b = Math.acos(Math.cos(f2r90)*Math.cos(f1r90)+Math.sin(f2r90)*Math.sin(f1r90)*Math.cos(l2r-l1r));
	double A = Math.asin(Math.sin(f2r90)*Math.sin(l2r-l1r)/Math.sin(b));
//	System.out.println("B:"+(Math.toDegrees(b)));
//	System.out.println("L:"+(6371.0d*b));
//	System.out.println("A:"+(Math.toDegrees(A)));
//	double b = Math.acos( Math.cos(lat2) * cos (90 - lat1) + sin (90 - lat2) * sin (90 - lat1) * cos (lon2 - lon1) )
    if ((f2r > f1r) && (l2r > l1r)) {
    }
    else if ((f2r < f1r) && (l2r < l1r))
    {
		A = Math.toRadians(180.0) - A;
    }
    else if ((f2r < f1r) && (l2r > l1r))
    {
		A = Math.toRadians(180.0) - A;
    }
    else if ((f2r > f1r) && (l2r < l1r))
    {
		A += Math.toRadians(360.0);
    }
	
	return (new BigDecimal(Math.toDegrees(A))).setScale(1,BigDecimal.ROUND_HALF_UP);

/*
double GCAzimuth(double lat1, double lon1, double lat2, double
                 lon2)
{
  double result = 0.0;

  INT32 ilat1 = (INT32)(0.50 + lat1 * 360000.0);
  INT32 ilat2 = (INT32)(0.50 + lat2 * 360000.0);
  INT32 ilon1 = (INT32)(0.50 + lon1 * 360000.0);
  INT32 ilon2 = (INT32)(0.50 + lon2 * 360000.0);

  lat1 *= GEO::DE2RA;
  lon1 *= GEO::DE2RA;
  lat2 *= GEO::DE2RA;
  lon2 *= GEO::DE2RA;

  if ((ilat1 == ilat2) && (ilon1 == ilon2))
  {
    return result;
  }
  else if (ilat1 == ilat2)
  {
    if (ilon1 > ilon2)
      result = 90.0;
    else
      result = 270.0;
  }
  else if (ilon1 == ilon2)
  {
    if (ilat1 > ilat2)
      result = 180.0;
  }
  else
  {
    double c = acos(sin(lat2)*sin(lat1) + cos(lat2)*cos(lat1)
                                         *cos((lon2-lon1)));
    double A = asin(cos(lat2)*sin((lon2-lon1))/sin(c));
    result = (A * GEO::RA2DE);


    if ((ilat2 > ilat1) && (ilon2 > ilon1))
    {
    }
    else if ((ilat2 < ilat1) && (ilon2 < ilon1))
    {
      result = 180.0 - result;
    }
    else if ((ilat2 < ilat1) && (ilon2 > ilon1))
    {
      result = 180.0 - result;
    }
    else if ((ilat2 > ilat1) && (ilon2 < ilon1))
    {
      result += 360.0;
    }
  }

*/
}
public static BigDecimal calcAzimutDoc(PositionAccessBean p1, PositionAccessBean p2)
{
	BigDecimal pAf = null;
	BigDecimal pAl = null;
	BigDecimal pBf = null;
	BigDecimal pBl = null;

	BigDecimal result = null;

	if(p1 == null || p2 == null) {
		return null;
	}

	try {
		pAf = p1.getLatitude();
		pAl = p1.getLongitude();
		pBf = p2.getLatitude();
		pBl = p2.getLongitude();
		result = calcAzimut(pAl,pAf,pBl,pBf);
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}

	return result;
}
public static BigDecimal calcLength(BigDecimal l1, BigDecimal f1, BigDecimal l2, BigDecimal f2)
{
	//ACOS(SIN(F1*PI/180)*SIN(F2*PI/180)+COS(F1*PI/180)*COS(F2*PI/180)*COS((L2-L1)*PI/180));
	if(l1 == null || f1 == null || l2 == null || f2 == null) {
		return null;
	}
	double f1r = Math.toRadians(f1.doubleValue());
	double f2r = Math.toRadians(f2.doubleValue());
	double l1r = Math.toRadians(l1.doubleValue());
	double l2r = Math.toRadians(l2.doubleValue());
//	System.out.println("["+f1.doubleValue()+","+l1.doubleValue()+"]-["+f2.doubleValue()+","+l2.doubleValue()+"]");
	if((f1r == 0.0d && l1r == 0.0d) || (f2r == 0.0d && l2r == 0.0d) ) {
		return null;
	}
	double r = //Math.toDegrees(
		Math.acos(
			Math.sin(f1r)*Math.sin(f2r)+
			Math.cos(f1r)*Math.cos(f2r)*Math.cos(l2r-l1r)
		) * 6371.0d;
	//) * 1.852d * 60.0d; // Sea mile * 60 degree seconds
	return (new BigDecimal(r)).setScale(1,BigDecimal.ROUND_HALF_UP);
/*
namespace GEO {
  const double PI = 3.14159265359;
  const double TWOPI = 6.28318530718;
  const double DE2RA = 0.01745329252;
  const double RA2DE = 57.2957795129;
  const double ERAD = 6378.135;
  const double ERADM = 6378135.0;
  const double AVG_ERAD = 6371.0;
  const double FLATTENING = 1.0/298.26;    // Earth flattening
                                           // (WGS '72)
  const double EPS = 0.000000000005;
  const double KM2MI = 0.621371;
}

double GCDistance(double lat1, double lon1, double lat2, double
                  lon2)
{
  lat1 *= GEO::DE2RA;
  lon1 *= GEO::DE2RA;
  lat2 *= GEO::DE2RA;
  lon2 *= GEO::DE2RA;
  double d = sin(lat1)*sin(lat2) + cos(lat1)*cos(lat2)*cos(lon1 -
                                                           lon2);
  return (GEO::AVG_ERAD * acos(d));
}
*/
}
public AbstractEntityAccessBean constructBean(HttpServletRequest request)
    throws java.lang.Exception
{
	//super.constructBean(request);

	HopAccessBean bean = null;	

	javax.naming.Context ctx = new javax.naming.InitialContext();
	javax.transaction.UserTransaction utrans = (javax.transaction.UserTransaction)ctx.lookup("jta/usertransaction");

	utrans.begin();
	try {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	    setHopsid(keyGen.getNextKey(TablesRef.HOPS));

	    // Create new comEquipment A if needed
		if ("Y".equals(getNewcomplecta())) {
			createComEquipmentA(keyGen);
	    }
	    
	    // Create new comEquipment B if needed
		if ("Y".equals(getNewcomplectb())) {
			createComEquipmentB(keyGen);
	    }

	    bean = new HopAccessBean(getHopsid(), getEquipmentid_enda(), getEquipmentid_endb());
	    setHopstype("R");
	    bean.commitCopyHelper();
	    
	    HopLabelAccessBean hlbean = new HopLabelAccessBean(keyGen.getNextKey(TablesRef.HOPSLABEL));
	    hlbean.setHopid((Hop)bean.getEJBRef());
	    hlbean.setHopsname(getHopsname());
	    hlbean.setHopsnamecomments(getHopscomment());
	    hlbean.commitCopyHelper();

	    RRLHops2AccessBean rrlbean = new RRLHops2AccessBean(getHopsid());
	    rrlbean.setDiam_a(getDouble(getDiam_aFrm()));
	    rrlbean.setDiam_b(getDouble(getDiam_bFrm()));
	    rrlbean.setDiam_a_doc(getDouble(getDiam_a_docFrm()));
	    rrlbean.setDiam_b_doc(getDouble(getDiam_b_docFrm()));
	    rrlbean.setHeight_a(getDouble(getHeight_aFrm()));
	    rrlbean.setHeight_b(getDouble(getHeight_bFrm()));
	    rrlbean.setHeight_a_doc(getDouble(getHeight_a_docFrm()));
	    rrlbean.setHeight_b_doc(getDouble(getHeight_b_docFrm()));
	    rrlbean.setFrequency_a1(getDouble(getFreqa1Frm()));
	    rrlbean.setFrequency_a2(getDouble(getFreqa2Frm()));
	    rrlbean.setFrequency_a_doc(getDouble(getFreqadocFrm()));
	    rrlbean.setFrequency_b1(getDouble(getFreqb1Frm()));
	    rrlbean.setFrequency_b2(getDouble(getFreqb2Frm()));
	    rrlbean.setFrequency_b_doc(getDouble(getFreqbdocFrm()));
	    rrlbean.setPower_a(getDouble(getPoweraFrm()));
	    rrlbean.setPower_b(getDouble(getPowerbFrm()));
	    rrlbean.setPower_doc(getDouble(getPowerdocFrm()));
	    rrlbean.setComment_a(getCommenta());
	    rrlbean.setComment_b(getCommentb());
	    rrlbean.setSpeed_doc(getSpeed_doc());
	    rrlbean.setResource_doc(getRescodedoc());
	    rrlbean.setFile_number(getInteger(getFile_number()));
	    rrlbean.setNumber_in_file(getInteger(getNumber_in_file()));
	    rrlbean.commitCopyHelper();
	    
	    utrans.commit();
	} catch (Exception e) {
		utrans.rollback();
		e.printStackTrace(System.out);
	}
    
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2003 13:33:22)
 * @return com.hps.july.persistence.PositionAccessBean
 * @param argPosition int
 */
private PositionAccessBean constructPosition(int argPosition) {
	PositionAccessBean result;
	try {
		result = new PositionAccessBean();
		result.setInitKey_storageplace(argPosition);
		result.refreshCopyHelper();
	} catch (Exception e) {
		// Incorrect position code - return null
		result = null;
	}
	return result;
}
public String constructPositionName(PositionAccessBean p) {
	try {
		String result = "";
		if(p.getGsmid() != null) {
			result += "D"+p.getGsmid()+" ";
		}
		if(p.getDampsid() != null) {
			result += "A"+p.getDampsid()+" ";
		}
		result += p.getName();
		return result;
	} catch(Exception e) {
		return "";
	}
}
private Resource constructResource(Integer argResourcecode) {
	ResourceAccessBean result = null;
	if(argResourcecode == null) {
		return null;
	}
	try {
		result = new ResourceAccessBean();
		result.setInitKey_resource(argResourcecode.intValue());
		result.refreshCopyHelper();
		return (Resource)result.getEJBRef();
	} catch (Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
public void copyDoc2Fact()
	throws UpdateValidationException
{
	height_aFrm = height_a_docFrm;
	height_bFrm = height_b_docFrm;
	diam_aFrm = diam_a_docFrm;
	diam_bFrm = diam_b_docFrm;
	freqa1Frm = freqadocFrm;
	freqb1Frm = freqbdocFrm;
	speed = speed_doc;
	rescodea = rescodedoc;
	resnamea = resnamedoc;
	poweraFrm = powerdocFrm;
	powerbFrm = powerdocFrm;
}
public void copyFact2Doc()
	throws UpdateValidationException
{
	height_a_docFrm = height_aFrm;
	height_b_docFrm = height_bFrm;
	diam_a_docFrm = diam_aFrm;
	diam_b_docFrm = diam_bFrm;
	freqadocFrm = freqa1Frm;
	freqbdocFrm = freqb1Frm;
	speed_doc = speed;
	rescodedoc = rescodea;
	resnamedoc = resnamea;
	powerdocFrm = poweraFrm;
	try {
		StringAndBigDecimalProperty sbd = new StringAndBigDecimalProperty();

		BigDecimal ab = calcAzimutDoc(positiona,positionb);
		if(ab != null) {
			ab = ab.setScale(0,BigDecimal.ROUND_HALF_UP);
			sbd.setBigDecimal(ab);
		}
		azimutabdocFrm = sbd.getString();

		BigDecimal ba = calcAzimutDoc(positionb,positiona);
		if(ba != null) {
			ba = ba.setScale(0,BigDecimal.ROUND_HALF_UP);
			sbd.setBigDecimal(ba);
		}
		azimutbadocFrm = sbd.getString();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		throw new UpdateValidationException("error.comline.calcazimuth");
	}
}
public void createComEquipmentA(KeyGeneratorAccessBean keyGen)
	throws Exception
{
	setEquipmentid_enda(keyGen.getNextKey("tables.storageplaces"));
	log("Create COMA "+getEquipmentid_enda());
	try {
		ComEquipmentAccessBean cma = new ComEquipmentAccessBean(
			getEquipmentid_enda(),
			null,
			getEquipnamea(),
			positiona.getAddress(),
			new Integer(positiona.getStorageplace())
		);
	    cma.setComEquipmentType("R");
		cma.setEquipcomment(getCommenta());
  		cma.setResource(constructResource(getRescodea()));
		cma.commitCopyHelper();
	} catch(Exception e) {
		log("Error creating COMA "+getEquipmentid_enda());
		throw e;
	}
}
public void createComEquipmentB(KeyGeneratorAccessBean keyGen)
	throws Exception
{
	setEquipmentid_endb(keyGen.getNextKey("tables.storageplaces"));
	log("Create COMB "+getEquipmentid_endb());
	try {
		ComEquipmentAccessBean cmb = new ComEquipmentAccessBean(
			getEquipmentid_endb(),
			null,
			getEquipnameb(),
			positionb.getAddress(),
			new Integer(positionb.getStorageplace())
		);
	    cmb.setComEquipmentType("R");
	    cmb.setEquipcomment(getCommentb());
	    cmb.setResource(constructResource(getRescodea()));
		cmb.commitCopyHelper();
	} catch(Exception e) {
		log("Error creating COMB "+getEquipmentid_endb());
		throw e;
	}
}
public void createHopsName()
	throws Exception
{
//<Наименование позиции A>(<Наименование комплекта оборудования А>)-<Наименование позиции Б>(<Наименование комплекта оборудования Б>)
// [Код позиции А] [разделитель] [Код позиции Б]
	String ptString = "-=+±";
	String posaid = formPosId(positiona.getGsmid(),positiona.getDampsid(),equipnamea);
	String posbid = formPosId(positionb.getGsmid(),positionb.getDampsid(),equipnameb);
	int ptindex = 0;

	CDBCComlinesObject co = new CDBCComlinesObject();
	CDBCResultSet rs = co.findHopsName(posaid,posbid);
	Iterator it = rs.listIterator();
	while(it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject)it.next();
		String name = ro.getColumn("hopsname").asString();
		if(name != null) {
			if(name.indexOf("-") > 0) {
				ptindex++;
			} else
			if(name.indexOf("=") > 0) {
				ptindex++;
			} else 
			if(name.indexOf("+") > 0) {
				ptindex++;
			}
		}
	}
	if(ptindex > 3) { ptindex = 3; }
	
	hopsname = posaid;
	if(hopsname != null && !"".equals(hopsname)) {
		hopsname += ptString.charAt(ptindex);
	}
	hopsname += posbid;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	StringAndInteger sip = new StringAndInteger();
	StringAndBigDecimal sbp = new StringAndBigDecimal();
	BigDecimal pAf = null;
	BigDecimal pAl = null;
	BigDecimal pBf = null;
	BigDecimal pBl = null;
    setNewcomplecta("N");
    setNewcomplectb("N");

	int regionacode = 0;
	int regionbcode = 0;
//    super.fillRecord(bean);
	try {
		HopAccessBean hop = (HopAccessBean)bean;
		setEquipmentid_enda(hop.getEquipmentid_enda());
		setEquipmentid_endb(hop.getEquipmentid_endb());

		String operModified = "";
		String operCreated = "";	
		
		try {	
			if(hop.getModifiedby()!=null){
				OperatorAccessBean operM = new OperatorAccessBean();
				operM.setInitKey_operator(hop.getModifiedby().intValue());
          		operModified = operM.getMan().getFullName();
			}

			if(hop.getCreatedby()!=null){
    		    OperatorAccessBean operC = new OperatorAccessBean();
    		    operC.setInitKey_operator(hop.getCreatedby().intValue());
          		operCreated = operC.getMan().getFullName();
			}
    	} catch (Exception ex) {
          System.err.println("***Can't find Operator");
          ex.printStackTrace(System.err);
    	}
		
		if(hop.getModified()!=null)	setModified(hop.getModified().toString());
		setModifiedBy(operModified);
		if(hop.getCreated()!=null)  setCreated(hop.getCreated().toString());
		setCreatedBy(operCreated);
		
	    System.out.println("Hops.Get("+getHopsid()+","+getEquipmentid_enda()+","+getEquipmentid_endb()+")");
		try {
			ComEquipmentAccessBean end1 = new ComEquipmentAccessBean();
			end1.setInitKey_storageplace(getEquipmentid_enda());
			end1.refreshCopyHelper();
			setCommenta(end1.getEquipcomment());
			equipnamea = end1.getName();
			ResourceAccessBean end1r = end1.getResource();
			if(end1r != null) {
				rescodea = new Integer(end1r.getResource());
				equipmodela = end1r.getModel();
				resnamea = equipmodela;
			} else {
				rescodea = null;
				equipmodela = "";
				resnamea = equipmodela;
			}
			PositionAccessBean end1p = end1.getPosition();
			if(end1p != null) {
				setPosidaFrm(""+end1p.getStorageplace());
				setPosnamea(constructPositionName(end1p));
			}
			pAf = end1p.getLatitude();
			pAl = end1p.getLongitude();
			RegionAccessBean reg = end1p.getRegion();
			if(reg != null) {
				regionacode = reg.getRegionid();
				regiona = reg.getRegname();
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
//			equipmodela = "?";
//			equipnamea = "?";
		}
		try {
			ComEquipmentAccessBean end2 = new ComEquipmentAccessBean();
			end2.setInitKey_storageplace(getEquipmentid_endb());
			end2.refreshCopyHelper();
			setCommentb(end2.getEquipcomment());
/*
			ResourceAccessBean end2r = end2.getResource();
			if(end2r != null) {
				rescodeb = new Integer(end2r.getResource());
				equipmodelb = end2r.getModel();
				resnameb = equipmodelb;
			} else {
				rescodeb = null;
				equipmodelb = "";
				resnameb = equipmodelb;
			}
*/
			equipnameb = end2.getName();
			PositionAccessBean end2p = end2.getPosition();
			if(end2p != null) {
				setPosidbFrm(""+end2p.getStorageplace());
				setPosnameb(constructPositionName(end2p));
			}
			pBf = end2p.getLatitude();
			pBl = end2p.getLongitude();
			RegionAccessBean reg = end2p.getRegion();
			if(reg != null) {
				regionbcode = reg.getRegionid();
				regionb = reg.getRegname();
			}
		} catch(Exception e) {
			e.printStackTrace(System.out);
//			equipmodelb = "?";
//			equipnameb = "?";
		}
		setHopstype(hop.getHopstype());
		if(regionacode != 0) {
			if(regionbcode != 0) {
				if(regionacode == regionbcode) {
					regionb = null;
				}
			} else {
				regiona = regionb;
				regionb = null;
			}
		} else {
			if(regionbcode != 0) {
				regiona = regionb;
				regionb = null;
			} else {
				showregions = false;
			}
		}
		if("View".equals(getAction()) || "Edit".equals(getAction())) {
			showregions = true;
		} else {
			showregions = false;
		}

		HopLabelAccessBean hlab = new HopLabelAccessBean();
		Enumeration en = hlab.findByHopsidOrderByHopslabelidAsc(new Integer(hop.getHopsid()));
		if(en.hasMoreElements()) {
			HopLabelAccessBean hl = (HopLabelAccessBean)en.nextElement();
			setHopsname(hl.getHopsname());
			setHopscomment(hl.getHopsnamecomments());
		}
		RRLHops2AccessBean h2b = new RRLHops2AccessBean();
		h2b.setInitKey_hopid_hopsid(new Integer(hop.getHopsid()));
		h2b.refreshCopyHelper();
		setDiam_aFrm(getBDString(h2b.getDiam_a(),sbp,1));
		setDiam_bFrm(getBDString(h2b.getDiam_b(),sbp,1));
		setDiam_a_docFrm(getBDString(h2b.getDiam_a_doc(),sbp,1));
		setDiam_b_docFrm(getBDString(h2b.getDiam_b_doc(),sbp,1));
		setHeight_aFrm(getBDString(h2b.getHeight_a(),sbp,1));
		setHeight_bFrm(getBDString(h2b.getHeight_b(),sbp,1));
		setHeight_a_docFrm(getBDString(h2b.getHeight_a_doc(),sbp,1));
		setHeight_b_docFrm(getBDString(h2b.getHeight_b_doc(),sbp,1));
		setFreqa1Frm(getBDString(h2b.getFrequency_a1(),sbp,3));
		setFreqa2Frm(getBDString(h2b.getFrequency_a2(),sbp,3));
		setFreqadocFrm(getBDString(h2b.getFrequency_a_doc(),sbp,3));
		setFreqb1Frm(getBDString(h2b.getFrequency_b1(),sbp,3));
		setFreqb2Frm(getBDString(h2b.getFrequency_b2(),sbp,3));
		setFreqbdocFrm(getBDString(h2b.getFrequency_b_doc(),sbp,3));
		setPoweraFrm(getBDString(h2b.getPower_a(),sbp,1));
		setPowerbFrm(getBDString(h2b.getPower_b(),sbp,1));
		setPowerdocFrm(getBDString(h2b.getPower_doc(),sbp,1));
		sip.setInteger(h2b.getFile_number()); setFile_number(sip.getString());
		setOld_file_number(getFile_number());
		setSfonumber(h2b.getSfonumber());
		sip.setInteger(h2b.getNumber_in_file()); setNumber_in_file(sip.getString());
		sbp.setBigDecimal(calcAzimut(pAl,pAf,pBl,pBf));
		setAzimutab(sbp.getString());
		sbp.setBigDecimal(calcAzimut(pBl,pBf,pAl,pAf));
		setAzimutba(sbp.getString());

		BigDecimal d = h2b.getAzimuthAB_Doc();
		if(d != null) { d = d.setScale(1,BigDecimal.ROUND_HALF_UP); }
		sbp.setBigDecimal(d);
		setAzimutabdocFrm(sbp.getString());
		d = h2b.getAzimuthBA_Doc();
		if(d != null) { d = d.setScale(1,BigDecimal.ROUND_HALF_UP); }
		sbp.setBigDecimal(d);
		setAzimutbadocFrm(sbp.getString());
		sbp.setBigDecimal(calcLength(pAl,pAf,pBl,pBf));
		setHopslength(sbp.getString());
		setSpeed_doc(h2b.getSpeed_doc());
		setComment_doc(h2b.getComment_doc());
		setRescodedoc(h2b.getResource_doc());
		if(getRescodedoc() != null) {
			try {
				ResourceAccessBean rdoc = new ResourceAccessBean();
				rdoc.setInitKey_resource(getRescodedoc().intValue());
				rdoc.refreshCopyHelper();
				resnamedoc = rdoc.getModel();
			} catch(Exception e) {
				resnamedoc = "";
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public static String formPosId(Integer idg, Integer ida, String complect)
{
	String r = "";
	if(idg != null || ida != null) {
		if(idg != null) {
			r += "D";
			for(int i = 0, m = 1000; i < 4; i++, m/=10) {
				r += String.valueOf((idg.intValue() / m) % 10);
			}
			if(ida != null) { r += " "; }
		} else
		if(ida != null) {
			r += "A";
			for(int i = 0, m = 1000; i < 4; i++, m/=10) {
				r += String.valueOf((ida.intValue() / m) % 10);
			}
		}
	} else {
		r = complect;
	}
	return r;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:45:34)
 * @return java.lang.String
 */
public java.lang.String getAbis_number() {
	return abis_number;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 14:05:32)
 * @return java.lang.String
 */
public java.lang.String getAzimutab() {
	return azimutab;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAzimutabdocFrm() {
	return azimutabdocFrm;
}
public java.lang.String getAzimutba() {
	return azimutba;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAzimutbadocFrm() {
	return azimutbadocFrm;
}
public String getBDString(BigDecimal bd, StringAndBigDecimalProperty sbp, int scale) {
	if(bd != null) {
		sbp.setBigDecimal(bd.setScale(scale,BigDecimal.ROUND_HALF_UP));
	} else {
		sbp.setBigDecimal(bd);
	}
	return sbp.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getBeenetid() {
	return beenetid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getComment_doc() {
	return comment_doc;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 14:08:15)
 * @return java.lang.String
 */
public java.lang.String getCommenta() {
	return commenta;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 14:08:30)
 * @return java.lang.String
 */
public java.lang.String getCommentb() {
	return commentb;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCpy() {
	return cpy;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 10:57:36)
 * @return java.lang.String
 */
public java.lang.String getCreated() {
	return created;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 10:57:58)
 * @return java.lang.String
 */
public java.lang.String getCreatedBy() {
	return createdBy;
}
public AbstractEntityAccessBean getDataBean(HttpServletRequest request)
{
    try {
		HopAccessBean bean = new HopAccessBean();
		bean.setInitKey_hopsid(getHopsid());
		bean.refreshCopyHelper();
		return bean;
    } catch (Exception e) {
		DebugSupport.printlnError(e);
		return null;
    }
}
public java.sql.Date getDate(Object o) {
	if(o == null) {
		return null;
	}
	if(o instanceof java.sql.Date) {
		return (java.sql.Date)o;
	} else if(o instanceof java.util.Date) {
		return new java.sql.Date(((java.util.Date)o).getTime());
	} else {
		return null;
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDiam_a_docFrm() {
	return diam_a_docFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:58:39)
 * @return java.lang.String
 */
public java.lang.String getDiam_aFrm() {
	return diam_aFrm;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDiam_b_docFrm() {
	return diam_b_docFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:58:54)
 * @return java.lang.String
 */
public java.lang.String getDiam_bFrm() {
	return diam_bFrm;
}
public Enumeration getDocuments() {
	CDBCRowObject ro = null;
	Vector v = new Vector();
	try {
//		Enumeration en = (new SiteDocAccessBean()).findByHop(new Integer(getHopsid()),new Integer(1));
		CDBCSitedocsObject o = new CDBCSitedocsObject();
		CDBCResultSet rs = o.findComlineDocuments(new Integer(getHopsid()), Boolean.TRUE);
		Iterator it = rs.listIterator();
		while(it.hasNext()) {
			ro = (CDBCRowObject)it.next();
			ComlineRDocumentValue val = new ComlineRDocumentValue();
			
			val.setDocid(getInt(ro.getColumn("sitedoc").asObject()));
			val.setRegdate(getDate(ro.getColumn("blankdate").asObject()));
			val.setNumber(ro.getColumn("blanknumber").asString());
			val.setDoctype(ro.getColumn("sitedoctypename").asString());
			val.setExpdate(getDate(ro.getColumn("expiredate").asObject()));
			val.setComments(ro.getColumn("comment").asString());
			v.add(val);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return v.elements();
}
private BigDecimal getDouble(String argStringVal) {
	BigDecimal result = null;
	StringAndBigDecimal sbd = new StringAndBigDecimal(20,10);
	sbd.setString(argStringVal);
	if (!sbd.isEmpty() && sbd.isOk())
		result = sbd.getBigDecimal();
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:46:58)
 * @return int
 */
public int getEquipmentid_enda() {
	return equipmentid_enda;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:47:13)
 * @return int
 */
public int getEquipmentid_endb() {
	return equipmentid_endb;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 21:15:46)
 * @return java.lang.String
 */
public java.lang.String getEquipmodela() {
	return equipmodela;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 21:15:59)
 * @return java.lang.String
 */
public java.lang.String getEquipmodelb() {
	return equipmodelb;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 21:15:16)
 * @return java.lang.String
 */
public java.lang.String getEquipnamea() {
	return equipnamea;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 21:15:30)
 * @return java.lang.String
 */
public java.lang.String getEquipnameb() {
	return equipnameb;
}
/**
 * Метод возвращает наименование style-класса для отображения поля ввода
 * @return java.lang.String имя style-класса
 * @param field java.lang.String Наименование поля ввода
 */
public String getFieldClassName(String field)
{
	if(field == null) {
		return "edit";
	}
	
	if("height_a".equals(field)) {
		if(isFieldEquals(height_aFrm,height_a_docFrm)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
	if("diam_a".equals(field)) {
		if(isFieldEquals(diam_aFrm,diam_a_docFrm)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
	if("freq_a".equals(field)) {
		if(isFieldEquals(freqa1Frm,freqadocFrm)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
	if("rescode_a".equals(field)) {
		if(isFieldEquals(rescodea,rescodedoc)) { return "editsmalldisabled"; } else { return "diffeditsmalldisabled"; }
	} else
	if("power_a".equals(field)) {
		if(isFieldEquals(poweraFrm,powerdocFrm)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
	if("height_b".equals(field)) {
		if(isFieldEquals(height_bFrm,height_b_docFrm)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
	if("diam_b".equals(field)) {
		if(isFieldEquals(diam_bFrm,diam_b_docFrm)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
	if("freq_b".equals(field)) {
		if(isFieldEquals(freqb1Frm,freqbdocFrm)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
//	if("rescode_b".equals(field)) {
//		if(isFieldEquals(rescodeb,rescodedoc)) { return "editsmalldisabled"; } else { return "diffeditsmalldisabled"; }
//	} else
	if("power_b".equals(field)) {
		if(isFieldEquals(powerbFrm,powerdocFrm)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
	if("speed".equals(field)) {
		if(isFieldEquals(speed,speed_doc)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
	if("power".equals(field)) {
		if(isFieldEquals(poweraFrm,powerdocFrm) || isFieldEquals(powerbFrm,powerdocFrm)) { return "editsmall"; } else { return "diffeditsmall"; }
	} else
	if("rescode".equals(field)) {
		if(isFieldEquals(rescodea,rescodedoc)/* || isFieldEquals(rescodeb,rescodedoc)*/) { return "editsmalldisabled"; } else { return "diffeditsmalldisabled"; }
	} else {
		return "edit";
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 14:15:17)
 * @return java.lang.String
 */
public java.lang.String getFile_number() {
	return file_number;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:59:54)
 * @return java.lang.String
 */
public java.lang.String getFreqa1Frm() {
	return freqa1Frm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 17:00:10)
 * @return java.lang.String
 */
public java.lang.String getFreqa2Frm() {
	return freqa2Frm;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFreqadocFrm() {
	return freqadocFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 17:00:26)
 * @return java.lang.String
 */
public java.lang.String getFreqb1Frm() {
	return freqb1Frm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 17:00:44)
 * @return java.lang.String
 */
public java.lang.String getFreqb2Frm() {
	return freqb2Frm;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFreqbdocFrm() {
	return freqbdocFrm;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHeight_a_docFrm() {
	return height_a_docFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:57:46)
 * @return java.lang.String
 */
public java.lang.String getHeight_aFrm() {
	return height_aFrm;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHeight_b_docFrm() {
	return height_b_docFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:58:05)
 * @return java.lang.String
 */
public java.lang.String getHeight_bFrm() {
	return height_bFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 14:04:48)
 * @return java.lang.String
 */
public java.lang.String getHopscomment() {
	return hopscomment;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:47:51)
 * @return int
 */
public int getHopsid() {
	return hopsid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 14:05:49)
 * @return java.lang.String
 */
public java.lang.String getHopslength() {
	return hopslength;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:55:56)
 * @return java.lang.String
 */
public java.lang.String getHopsname() {
	return hopsname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getHopstate() {
	return hopstate;
}
public java.lang.String getHopstype() {
	//return hopstype;
	return "R";
}
public int getInt(Object o) {
	if(o == null) {
		return 0;
	}
	if(o instanceof Integer) {
		return ((Integer)o).intValue();
	} else if(o instanceof BigDecimal) {
		return ((BigDecimal)o).intValue();
	} else {
		return 0;
	}
}
private Integer getInteger(String argStringVal) {
	Integer result = null;
	StringAndInteger sbd = new StringAndInteger();
	sbd.setString(argStringVal);
	if (!sbd.isEmpty() && sbd.isOk()) {
		result = sbd.getInteger();
	}
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:48:52)
 * @return java.lang.String
 */
public java.lang.String getLease_info() {
	return lease_info;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2003 17:52:10)
 * @return java.lang.String
 */
public String getListAttributeName() {
	return "ComlineListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 10:58:24)
 * @return java.lang.String
 */
public java.lang.String getModified() {
	return modified;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 11:02:29)
 * @return java.lang.String
 */
public java.lang.String getModifiedBy() {
	return modifiedBy;
}
public Enumeration getNesteda() {
	HopAccessBean hb = new HopAccessBean();
	Vector r = new Vector();
	try {
		Integer p = getInteger(posidaFrm);
		if(p != null) {
			Enumeration en = hb.findNestedLines(Boolean.TRUE, "R", new Integer(getHopsid()), p);
			while(en.hasMoreElements()) {
				HopAccessBean h = (HopAccessBean)en.nextElement();
				NestedHopInfo hi = new NestedHopInfo(h,p.intValue());
				r.add(hi);
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return r.elements();
}
public Enumeration getNestedb() {
	HopAccessBean hb = new HopAccessBean();
	Vector r = new Vector();
	try {
		Integer p = getInteger(posidbFrm);
		if(p != null) {
			Enumeration en = hb.findNestedLines(Boolean.TRUE, "R", new Integer(getHopsid()), p);
			while(en.hasMoreElements()) {
				HopAccessBean h = (HopAccessBean)en.nextElement();
				NestedHopInfo hi = new NestedHopInfo(h,p.intValue());
				r.add(hi);
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return r.elements();
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 15:57:51)
 * @return java.lang.String
 */
public java.lang.String getNewcomplecta() {
	return newcomplecta;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 15:58:06)
 * @return java.lang.String
 */
public java.lang.String getNewcomplectb() {
	return newcomplectb;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 14:15:35)
 * @return java.lang.String
 */
public java.lang.String getNumber_in_file() {
	return number_in_file;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOld_file_number() {
	return old_file_number;
}
public java.lang.String getPermstatus() {
	return permstatus;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 11:48:24)
 * @return java.lang.String
 */
public java.lang.String getPosidaFrm() {
	return posidaFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 11:48:38)
 * @return java.lang.String
 */
public java.lang.String getPosidbFrm() {
	return posidbFrm;
}
public PositionAccessBean getPositionByEquipment(int equipmentId)
{
	try {
		EquipmentSetAccessBean eq = new EquipmentSetAccessBean();
		eq.setInitKey_storageplace(equipmentId);
		eq.refreshCopyHelper();
		return eq.getPosition();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 11:50:36)
 * @return java.lang.String
 */
public java.lang.String getPosnamea() {
	return posnamea;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 11:50:48)
 * @return java.lang.String
 */
public java.lang.String getPosnameb() {
	return posnameb;
}
/**
 * Insert the method's description here.
 * Creation date: (06.10.2003 11:32:43)
 * @return java.lang.String
 */
public java.lang.String getPoweraFrm() {
	return poweraFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (06.10.2003 11:32:43)
 * @return java.lang.String
 */
public java.lang.String getPowerbFrm() {
	return powerbFrm;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPowerdocFrm() {
	return powerdocFrm;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRegiona() {
	return regiona;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRegionb() {
	return regionb;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 14:48:13)
 * @return java.lang.Integer
 */
public java.lang.Integer getRescodea() {
	return rescodea;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getRescodedoc() {
	return rescodedoc;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 17:36:59)
 * @return java.lang.String
 */
public java.lang.String getResnamea() {
	return resnamea;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResnamedoc() {
	return resnamedoc;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:51:41)
 * @return java.lang.String
 */
public java.lang.String getRezerv() {
	return rezerv;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSfonumber() {
	return sfonumber;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getShowType() {
	return showType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:52:48)
 * @return java.lang.String
 */
public java.lang.String getSpeed() {
	return speed;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSpeed_doc() {
	return speed_doc;
}
public int getState() {
	return APPStates.ComlineRForm;
}
public void initCollections(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	if((getShowType() == null || "".equals(getShowType()))) {
		if(request.isUserInRole("FreqManager") && !request.isUserInRole("administrator") &&	!request.isUserInRole("supregAdmin") && !request.isUserInRole("regionAdmin")) {
			setShowType("D");
		} else {
			setShowType("F");
		}
	}
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
    setNewcomplecta("Y");
    setNewcomplectb("Y");
    showregions = false;
    permstatus = "0";

    try {
	    Integer positionAid = getInteger(posidaFrm);
		if(positionAid != null) {
			PositionAccessBean p = constructPosition(positionAid.intValue());
			setPosnamea(constructPositionName(p));
	    }
    } catch(Exception e) {
	    setPosnamea("");
	    e.printStackTrace(System.out);
    }
}
/**
 * 
 * @return boolean
 */
public boolean isApprove() {
	return approve;
}
public boolean isFieldEquals(Integer a, Integer b) {
	if(a != null) {
		if(b != null) {
			return (a.intValue() == b.intValue());
		} else {
			return false;
		}
	} else {
		if(b != null) {
			return false;
		} else {
			return true;
		}
	}
}
public boolean isFieldEquals(String a, String b) {
	if(a != null) {
		if(b != null) {
			return a.equalsIgnoreCase(b);
		} else {
			return false;
		}
	} else {
		if(b != null) {
			return false;
		} else {
			return true;
		}
	}
}
public boolean isShowregions() {
	return showregions;
}
public void log(String s)
{
	System.out.println(":-: "+s);
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:45:34)
 * @param newAbis_number java.lang.String
 */
public void setAbis_number(java.lang.String newAbis_number) {
	abis_number = newAbis_number;
}
/**
 * 
 * @param newApprove boolean
 */
public void setApprove(boolean newApprove) {
	approve = newApprove;
}
public void setAzimutab(java.lang.String newAzimut) {
	azimutab = newAzimut;
}
/**
 * 
 * @param newAzimutabdocFrm java.lang.String
 */
public void setAzimutabdocFrm(java.lang.String newAzimutabdocFrm) {
	azimutabdocFrm = newAzimutabdocFrm;
}
public void setAzimutba(java.lang.String newAzimut) {
	azimutba = newAzimut;
}
/**
 * 
 * @param newAzimutbadocFrm java.lang.String
 */
public void setAzimutbadocFrm(java.lang.String newAzimutbadocFrm) {
	azimutbadocFrm = newAzimutbadocFrm;
}
/**
 * 
 * @param newBeenetid java.lang.String
 */
public void setBeenetid(java.lang.String newBeenetid) {
	beenetid = newBeenetid;
}
/**
 * 
 * @param newComment_doc java.lang.String
 */
public void setComment_doc(java.lang.String newComment_doc) {
	comment_doc = newComment_doc;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 14:08:15)
 * @param newCommenta java.lang.String
 */
public void setCommenta(java.lang.String newCommenta) {
	commenta = newCommenta;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 14:08:30)
 * @param newCommentb java.lang.String
 */
public void setCommentb(java.lang.String newCommentb) {
	commentb = newCommentb;
}
/**
 * 
 * @param newCpy java.lang.String
 */
public void setCpy(java.lang.String newCpy) {
	cpy = newCpy;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 10:57:36)
 * @param newCreated java.lang.String
 */
public void setCreated(java.lang.String newCreated) {
	created = newCreated;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 10:57:58)
 * @param newCreatedBy java.lang.String
 */
public void setCreatedBy(java.lang.String newCreatedBy) {
	createdBy = newCreatedBy;
}
/**
 * 
 * @param newDiam_a_docFrm java.lang.String
 */
public void setDiam_a_docFrm(java.lang.String newDiam_a_docFrm) {
	diam_a_docFrm = newDiam_a_docFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:58:39)
 * @param newDiam_aFrm java.lang.String
 */
public void setDiam_aFrm(java.lang.String newDiam_aFrm) {
	diam_aFrm = newDiam_aFrm;
}
/**
 * 
 * @param newDiam_b_docFrm java.lang.String
 */
public void setDiam_b_docFrm(java.lang.String newDiam_b_docFrm) {
	diam_b_docFrm = newDiam_b_docFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:58:54)
 * @param newDiam_bFrm java.lang.String
 */
public void setDiam_bFrm(java.lang.String newDiam_bFrm) {
	diam_bFrm = newDiam_bFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:46:58)
 * @param newEquipmentid_enda int
 */
public void setEquipmentid_enda(int newEquipmentid_enda) {
	equipmentid_enda = newEquipmentid_enda;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:47:13)
 * @param newEquipmentid_endb int
 */
public void setEquipmentid_endb(int newEquipmentid_endb) {
	equipmentid_endb = newEquipmentid_endb;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 21:15:46)
 * @param newEquipmodela java.lang.String
 */
public void setEquipmodela(java.lang.String newEquipmodela) {
	equipmodela = newEquipmodela;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 21:15:59)
 * @param newEquipmodelb java.lang.String
 */
public void setEquipmodelb(java.lang.String newEquipmodelb) {
	equipmodelb = newEquipmodelb;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 21:15:16)
 * @param newEquipnamea java.lang.String
 */
public void setEquipnamea(java.lang.String newEquipnamea) {
	equipnamea = newEquipnamea;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 21:15:30)
 * @param newEquipnameb java.lang.String
 */
public void setEquipnameb(java.lang.String newEquipnameb) {
	equipnameb = newEquipnameb;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 14:15:17)
 * @param newFile_number java.lang.String
 */
public void setFile_number(java.lang.String newFile_number) {
	file_number = newFile_number;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:59:54)
 * @param newFreqa1Frm java.lang.String
 */
public void setFreqa1Frm(java.lang.String newFreqa1Frm) {
	freqa1Frm = newFreqa1Frm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 17:00:10)
 * @param newFreqa2Frm java.lang.String
 */
public void setFreqa2Frm(java.lang.String newFreqa2Frm) {
	freqa2Frm = newFreqa2Frm;
}
/**
 * 
 * @param newFreqadocFrm java.lang.String
 */
public void setFreqadocFrm(java.lang.String newFreqadocFrm) {
	freqadocFrm = newFreqadocFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 17:00:26)
 * @param newFreqb1Frm java.lang.String
 */
public void setFreqb1Frm(java.lang.String newFreqb1Frm) {
	freqb1Frm = newFreqb1Frm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 17:00:44)
 * @param newFreqb2Frm java.lang.String
 */
public void setFreqb2Frm(java.lang.String newFreqb2Frm) {
	freqb2Frm = newFreqb2Frm;
}
/**
 * 
 * @param newFreqbdocFrm java.lang.String
 */
public void setFreqbdocFrm(java.lang.String newFreqbdocFrm) {
	freqbdocFrm = newFreqbdocFrm;
}
/**
 * 
 * @param newHeight_a_docFrm java.lang.String
 */
public void setHeight_a_docFrm(java.lang.String newHeight_a_docFrm) {
	height_a_docFrm = newHeight_a_docFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:57:46)
 * @param newHeight_aFrm java.lang.String
 */
public void setHeight_aFrm(java.lang.String newHeight_aFrm) {
	height_aFrm = newHeight_aFrm;
}
/**
 * 
 * @param newHeight_b_docFrm java.lang.String
 */
public void setHeight_b_docFrm(java.lang.String newHeight_b_docFrm) {
	height_b_docFrm = newHeight_b_docFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:58:05)
 * @param newHeight_bFrm java.lang.String
 */
public void setHeight_bFrm(java.lang.String newHeight_bFrm) {
	height_bFrm = newHeight_bFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 14:04:48)
 * @param newHopscomment java.lang.String
 */
public void setHopscomment(java.lang.String newHopscomment) {
	hopscomment = newHopscomment;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:47:51)
 * @param newHopsid int
 */
public void setHopsid(int newHopsid) {
	hopsid = newHopsid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 14:05:49)
 * @param newHopslength java.lang.String
 */
public void setHopslength(java.lang.String newHopslength) {
	hopslength = newHopslength;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:55:56)
 * @param newHopsname java.lang.String
 */
public void setHopsname(java.lang.String newHopsname) {
	hopsname = newHopsname;
}
/**
 * 
 * @param newHopstate java.lang.String
 */
public void setHopstate(java.lang.String newHopstate) {
	hopstate = newHopstate;
}
public void setHopstype(java.lang.String newHopstype) {
	//hopstype = newHopstype;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:48:52)
 * @param newLease_info java.lang.String
 */
public void setLease_info(java.lang.String newLease_info) {
	lease_info = newLease_info;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 10:58:24)
 * @param newModified java.lang.String
 */
public void setModified(java.lang.String newModified) {
	modified = newModified;
}
/**
 * Insert the method's description here.
 * Creation date: (17.06.2005 11:02:29)
 * @param newModifiedBy java.lang.String
 */
public void setModifiedBy(java.lang.String newModifiedBy) {
	modifiedBy = newModifiedBy;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 15:57:51)
 * @param newNewcomplecta java.lang.String
 */
public void setNewcomplecta(java.lang.String newNewcomplecta) {
	newcomplecta = newNewcomplecta;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 15:58:06)
 * @param newNewcomplectb java.lang.String
 */
public void setNewcomplectb(java.lang.String newNewcomplectb) {
	newcomplectb = newNewcomplectb;
}
/**
 * Insert the method's description here.
 * Creation date: (03.10.2003 14:15:35)
 * @param newNumber_in_file java.lang.String
 */
public void setNumber_in_file(java.lang.String newNumber_in_file) {
	number_in_file = newNumber_in_file;
}
/**
 * 
 * @param newOld_file_number java.lang.String
 */
public void setOld_file_number(java.lang.String newOld_file_number) {
	old_file_number = newOld_file_number;
}
public void setPermstatus(java.lang.String newPermstatus) {
	permstatus = newPermstatus;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 11:48:24)
 * @param newPosidaFrm java.lang.String
 */
public void setPosidaFrm(java.lang.String newPosidaFrm) {
	posidaFrm = newPosidaFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 11:48:38)
 * @param newPosidbFrm java.lang.String
 */
public void setPosidbFrm(java.lang.String newPosidbFrm) {
	posidbFrm = newPosidbFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 11:50:36)
 * @param newPosnamea java.lang.String
 */
public void setPosnamea(java.lang.String newPosnamea) {
	posnamea = newPosnamea;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 11:50:48)
 * @param newPosnameb java.lang.String
 */
public void setPosnameb(java.lang.String newPosnameb) {
	posnameb = newPosnameb;
}
/**
 * Insert the method's description here.
 * Creation date: (06.10.2003 11:32:43)
 * @param newPoweraFrm java.lang.String
 */
public void setPoweraFrm(java.lang.String newPoweraFrm) {
	poweraFrm = newPoweraFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (06.10.2003 11:32:43)
 * @param newPowerbFrm java.lang.String
 */
public void setPowerbFrm(java.lang.String newPowerbFrm) {
	powerbFrm = newPowerbFrm;
}
/**
 * 
 * @param newPowerdocFrm java.lang.String
 */
public void setPowerdocFrm(java.lang.String newPowerdocFrm) {
	powerdocFrm = newPowerdocFrm;
}
/**
 * 
 * @param newRegiona java.lang.String
 */
public void setRegiona(java.lang.String newRegiona) {
	regiona = newRegiona;
}
/**
 * 
 * @param newRegionb java.lang.String
 */
public void setRegionb(java.lang.String newRegionb) {
	regionb = newRegionb;
}
/**
 * Insert the method's description here.
 * Creation date: (22.09.2003 14:48:13)
 * @param newRescodea java.lang.Integer
 */
public void setRescodea(java.lang.Integer newRescodea) {
	rescodea = newRescodea;
}
/**
 * 
 * @param newRescodedoc java.lang.Integer
 */
public void setRescodedoc(java.lang.Integer newRescodedoc) {
	rescodedoc = newRescodedoc;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 17:36:59)
 * @param newResnamea java.lang.String
 */
public void setResnamea(java.lang.String newResnamea) {
	resnamea = newResnamea;
}
/**
 * 
 * @param newResnamedoc java.lang.String
 */
public void setResnamedoc(java.lang.String newResnamedoc) {
	resnamedoc = newResnamedoc;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:51:41)
 * @param newRezerv java.lang.String
 */
public void setRezerv(java.lang.String newRezerv) {
	rezerv = newRezerv;
}
/**
 * 
 * @param newSfonumber java.lang.String
 */
public void setSfonumber(java.lang.String newSfonumber) {
	sfonumber = newSfonumber;
}
/**
 * 
 * @param newShowregions boolean
 */
public void setShowregions(boolean newShowregions) {
	showregions = newShowregions;
}
/**
 * 
 * @param newShowType java.lang.String
 */
public void setShowType(java.lang.String newShowType) {
	showType = newShowType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.09.2003 16:52:48)
 * @param newSpeed java.lang.String
 */
public void setSpeed(java.lang.String newSpeed) {
	speed = newSpeed;
}
/**
 * 
 * @param newSpeed_doc java.lang.String
 */
public void setSpeed_doc(java.lang.String newSpeed_doc) {
	speed_doc = newSpeed_doc;
}
public void updateFrequencyLicence()
	throws UpdateValidationException
{
	CDBCSitedocsObject sdo = new CDBCSitedocsObject();
	StringAndIntegerProperty si = new StringAndIntegerProperty();
	si.setString(old_file_number);
	Integer OldFN = si.getInteger();
	si.setString(file_number);
System.out.println("OLD:"+OldFN+" NEW:"+si.getInteger());
	if(OldFN != null) {
		// Проверить старый номер на наличие связи
		// если номер поменялся удалить связь...
		if(si.getInteger() == null || (si.getInteger().intValue() != OldFN.intValue())) {
			CDBCResultSet rs = sdo.findFrequencyLicenceByFN(OldFN);
			Iterator it = rs.listIterator();
			Integer newNumberinfile = new Integer(1);
			if(it.hasNext()) {
				CDBCRowObject ro = (CDBCRowObject)it.next();
				int fpId = ((Number)ro.getColumn("freqpermid").asObject()).intValue();
				sdo.deleteFL2HopsLink(new Integer(fpId),new Integer(getHopsid()));
			}
		}
		if(si.getInteger() == null) {
			file_number = null;
			number_in_file = null;
		}
	}
	if(si.getInteger() != null) {
		int fpId = 0; 
		CDBCResultSet rs = sdo.findFrequencyLicenceByFN(si.getInteger());
		Iterator it = rs.listIterator();
		Integer newNumberinfile = new Integer(1);
		if(it.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject)it.next();
			fpId = ((Number)ro.getColumn("freqpermid").asObject()).intValue();
			newNumberinfile = sdo.findNewFrequencyLicenceComlineNumber(new Integer(fpId));
		} else {
			try {
				fpId = FrequencyLicenceForm.createFreqperm(
					si.getInteger(),"","",new Integer[] { new Integer(getHopsid()) }, new Integer[] { new Integer(1) }, new String[] { getSfonumber() }
					).intValue();
			} catch(Exception e) {
				e.printStackTrace(System.out);
				throw new UpdateValidationException("error.comliner.cantcreatenewpermission");
			}
		}

		try {
			Perm2HopAccessBean p2h = new Perm2HopAccessBean();
			p2h.setInitKey_freqpermid(fpId);
			p2h.setInitKey_hopsid(getHopsid());
			p2h.refreshCopyHelper();
			number_in_file = String.valueOf(p2h.getNumberinfile());
		} catch(javax.ejb.ObjectNotFoundException nfe) {
			try {
				Perm2HopAccessBean p2hnew = new Perm2HopAccessBean(fpId,getHopsid());
				p2hnew.setNumberinfile(newNumberinfile);
				p2hnew.commitCopyHelper();
			} catch(Exception e) {
				e.printStackTrace(System.out);
				throw new UpdateValidationException("error.comliner.cantcreatehopslink");
				/// Ой!!! Но уже при создании
			}
		} catch(Exception e) {
			/// ??? Ой!!!
			e.printStackTrace(System.out);
			throw new UpdateValidationException("error.comliner.hopslinkerror");
		}

		sdo.deleteFL2HopsComlines(new Integer(fpId),new Integer(getHopsid()));
	}

	// Update RRLHops2
	try {
		RRLHops2AccessBean rrlbean = new RRLHops2AccessBean();
		rrlbean.setInitKey_hopid_hopsid(new Integer(getHopsid()));
		rrlbean.refreshCopyHelper();
		rrlbean.setFile_number(getInteger(getFile_number()));
		rrlbean.setNumber_in_file(getInteger(getNumber_in_file()));
		rrlbean.setSfonumber(getSfonumber());
		rrlbean.commitCopyHelper();
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
public void validateValues(ActionErrors errors)
	throws Exception
{
/*
	if(cpy != null && "chD".equals(cpy)) {
		showType = "D";
		throw new ValidationException();
	} else if(cpy != null && "chF".equals(cpy)) {
		showType = "F";
		throw new ValidationException();
	}
*/
    //super.validateValues(errors);
    if(!"Add".equals(getAction())) {
	    setNewcomplecta("N");
	    setNewcomplectb("N");
    }
    
    StringAndBigDecimal sbd = new StringAndBigDecimal(20,10);
    StringAndBigDecimal sbd63 = new StringAndBigDecimal(20,10);
    StringAndInteger sint = new StringAndInteger();

    if(getHopsname() != null) {
	    setHopsname(getHopsname().trim());
    }

    if(getBeenetid() != null && getBeenetid().length() > 0) {
	    if(getBeenetid().length() > 8) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.beenetid"));
	    }
    }

    // Check complect A

    // Position
    sint.setString(getPosidaFrm());
    if (sint.isEmpty())
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.posida"));
    else if (!sint.isOk())
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.posida"));
    else {
	    positiona = constructPosition(sint.getInteger().intValue());
	    if (positiona == null) {
        	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.posida"));
	    }
    }

    System.out.println("NEW COMPLECT A: "+getNewcomplectb());
    // Complect
    if ("Y".equals(getNewcomplecta())) {
	    // New complect - check complect name
	    if (getEquipnamea() == null || getEquipnamea().trim().length() == 0)
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.equipnamea"));
    } else {
	    // Existing complect
	    if (getEquipmentid_enda() == 0) {
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.equipa"));
	    } else {
//			constructEquipment(getEquipmentid_enda());
	    }
    }

    sbd.setString(getAzimutabdocFrm());
	if (!sbd.isEmpty() && !sbd.isOk())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.azimutabdoc"));
	    
    // Height
    sbd.setString(getHeight_aFrm());
    if ((!sbd.isEmpty()) && (!sbd.isOk()))
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.heighta"));

    sbd.setString(getHeight_a_docFrm());
    if ((!sbd.isEmpty()) && (!sbd.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.heightadoc"));

    // Diameter
    sbd.setString(getDiam_aFrm());
    if ((!sbd.isEmpty()) && (!sbd.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.diama"));

    sbd.setString(getDiam_a_docFrm());
    if ((!sbd.isEmpty()) && (!sbd.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.diamadoc"));

    // Frequency 1
    sbd63.setString(getFreqa1Frm());
    if ((!sbd63.isEmpty()) && (!sbd63.isOk()))
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.freqa1"));
        
    // Frequency 2
    sbd63.setString(getFreqa2Frm());
    if ((!sbd63.isEmpty()) && (!sbd63.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.freqa2"));
        
    // Frequency doc
    sbd63.setString(getFreqadocFrm());
    if ((!sbd63.isEmpty()) && (!sbd63.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.freqadoc"));
        
    // Power
    sbd.setString(getPoweraFrm());
    if (!sbd.isEmpty() && !sbd.isOk()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.powera"));
    }

    // Equipment type
    if ("Y".equals(getNewcomplecta())) {
	    // Check here complect type
//	    if (getRescodea() == null)
//	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.rescodea"));
    }

    // Comment 
//    if (getCommenta() == null || getCommenta().trim().length() == 0)
//        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.commenta"));

        
    // Check complect B

    // Position
    sint.setString(getPosidbFrm());
    if (sint.isEmpty())
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.posidb"));
    else if (!sint.isOk())
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.posidb"));
    else {
	    positionb = constructPosition(sint.getInteger().intValue());
	    if (positionb == null)
        	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.posidb"));
    }

    System.out.println("NEW COMPLECT B: "+getNewcomplectb());
    // Complect
    if ("Y".equals(getNewcomplectb())) {
	    // New complect - check complect name
	    if (getEquipnameb() == null || getEquipnameb().trim().length() == 0)
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.equipnameb"));
    } else {
	    // Existing complect
	    if (getEquipmentid_endb() == 0)
	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.equipb"));
    }
	    
    sbd.setString(getAzimutbadocFrm());
	if (!sbd.isEmpty() && !sbd.isOk())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.azimutbadoc"));
		
    // Height
    sbd.setString(getHeight_bFrm());
    if ((!sbd.isEmpty()) && (!sbd.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.heightb"));

    sbd.setString(getHeight_b_docFrm());
    if ((!sbd.isEmpty()) && (!sbd.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.heightbdoc"));

    // Diameter
    sbd.setString(getDiam_bFrm());
    if ((!sbd.isEmpty()) && (!sbd.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.diamb"));

    sbd.setString(getDiam_b_docFrm());
    if ((!sbd.isEmpty()) && (!sbd.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.diambdoc"));

    // Frequency 1
    sbd63.setString(getFreqb1Frm());
    if ((!sbd63.isEmpty()) && (!sbd63.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.freqb1"));
        
    // Frequency 2
    sbd63.setString(getFreqb2Frm());
    if ((!sbd63.isEmpty()) && (!sbd63.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.freqb2"));
        
    // Frequency doc
    sbd63.setString(getFreqbdocFrm());
    if ((!sbd63.isEmpty()) && (!sbd63.isOk()))
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.freqbdoc"));
        
    // Power
    sbd.setString(getPowerbFrm());
    if (!sbd.isEmpty() && !sbd.isOk()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.powerb"));
    }

    // Equipment type
    if ("Y".equals(getNewcomplectb())) {
//	    if (getRescodeb() == null)
//	        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.rescodeb"));
    }

    // Comment
//    if (getCommentb() == null || getCommentb().trim().length() == 0)
//        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.empty.commentb"));
    sbd.setString(getPowerdocFrm());
    if (!sbd.isEmpty() && !sbd.isOk()) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.powerdoc"));
    }

//    if(showType != null && "D".equals(showType)) {
	    // Calculate azimut A to B and B to A
	    if(azimutabdocFrm == null || "".equals(azimutabdocFrm.trim())) {
		    // A - B
		    BigDecimal aab = calcAzimutDoc(positiona,positionb);
		    if(aab != null) {
			    aab = aab.setScale(0,BigDecimal.ROUND_HALF_UP);
			    sbd.setBigDecimal(aab);
		    }
		    azimutabdocFrm = sbd.getString();
	    }
	    if(azimutbadocFrm == null || "".equals(azimutbadocFrm.trim())) {
		    // B - A
		    BigDecimal aba = calcAzimutDoc(positionb,positiona);
		    if(aba != null) {
			    aba = aba.setScale(0,BigDecimal.ROUND_HALF_UP);
			    sbd.setBigDecimal(aba);
		    }
		    azimutbadocFrm = sbd.getString();
	    }
//    }

    if (!errors.empty())
        throw new ValidationException();

    if (getHopsname() == null || getHopsname().length() == 0) {
	    createHopsName();
    }
    if(getHopsname() != null && getHopsname().length() > 50) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.hopsname"));
    }

    if(getSfonumber() != null && getSfonumber().length() > 20) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("ComlineRForm.error.invalid.sfonumber"));
    }

    if (!errors.empty())
        throw new ValidationException();
}
}
