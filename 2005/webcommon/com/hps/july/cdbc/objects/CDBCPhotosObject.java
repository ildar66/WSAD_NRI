package com.hps.july.cdbc.objects;

import com.hps.july.cdbc.lib.*;
import com.hps.july.util.*;
import java.util.*;

/**
 * Объект для работы с фотографиями.
 * Creation date: (10.03.2004 15:14:25)
 * @author: Dmitry Dneprov
 */
public class CDBCPhotosObject {

	public final static String SQL_SELECT_PEOPLE_BY_LOGIN = (" SELECT "
		+ "  pl.man, TRIM(nvl(pl.lastname,'')) ||' '||TRIM(nvl(pl.firstname,''))||' '|| TRIM(nvl(pl.middlename,'')) phname "
		+ "  FROM operators o, people pl "
		+ "  WHERE o.loiginid = ? AND o.man = pl.man ");

	public final static String SQL_PHOTO_SELECT_UNIQUE_GROUP = (" SELECT unique groupname as gn FROM photos WHERE storageplace = ?" );
	public final static String SQL_PHOTOS_SELECT_IMAGE_BY_POSITIONS = (" SELECT photoimage, TRIM(photofilename) as photofilename FROM photos "
		+ "  WHERE storageplace = ?");
	public final static String SQL_PHOTO_SELECT_IMAGE = (" SELECT photoimage, smallimage, TRIM(photofilename) as photofilename FROM photos "
		+ "  WHERE photo = ?");
	public final static String SQL_PHOTO_SELECT_SMALLIMAGE = (" SELECT smallimage, TRIM(photofilename) as photofilename FROM photos "
		+ "  WHERE photo = ?");
	public final static String SQL_PHOTO_SELECT_BIGIMAGE = (" SELECT photoimage, TRIM(photofilename) as photofilename FROM photos "
		+ "  WHERE photo = ?");
	
	public final static String SQL_PHOTO_SELECT_WITHOUT_IMAGES = (" SELECT "
		+ "  p.storageplace, p.description, p.date, TRIM(nvl(p.photofilename,'')) as photofilename, p.photographer, p.exphotgrname, TRIM(nvl(p.mime_type,'')) as mime_type, "
		+ "  TRIM(nvl(pl.lastname,'')) ||' '||TRIM(nvl(pl.firstname,''))||' '|| TRIM(nvl(pl.middlename,'')) phname, "
		+ "  po.gsmid g, po.dampsid d, TRIM(nvl(sp.name,'')) pname, p.groupname FROM positions po, storagePlaces sp, photos p, outer (workers w, people pl) "
		+ "  WHERE photo = ? AND w.worker = p.photographer AND w.man = pl.man "
		+ "  AND p.storageplace = po.storageplace AND po.storageplace = sp.storageplace ");
	public final static String SQL_PHOTO_INSERT = (" INSERT INTO photos "
		+ " (photo, storageplace, description, date, photofilename, "
		+ " photoimage, smallimage, mime_type, exphotgrname, photographer, groupname, modified, created, modifiedby, createdby) "
		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT, CURRENT, ?, ?) ");
	public final static String SQL_PHOTO_UPDATE = (" UPDATE photos "
		+ "SET description = ?, date = ?, photographer = ?, exphotgrname = ?, groupname = ?, modified = CURRENT, modifiedby = ? WHERE photo = ?" );
	public final static String SQL_PHOTO_UPDATE_WITH_IMAGE = (" UPDATE photos "
		+ " SET description = ?, date = ?, photographer = ?, exphotgrname = ?, groupname = ?, modified = CURRENT, modifiedby = ?, photofilename = ?, photoimage = ?, smallimage = ?, mime_type = ? WHERE photo = ?");
	public final static String SQL_PHOTO_DELETE = (" DELETE FROM photos WHERE photo = ?");
/**
 * CDBCPositionObject constructor comment.
 */
public CDBCPhotosObject() {
	super();
}
/**
 * Возвращает список заголовков фотографий (без blob-ов)
 */
public CDBCResultSet findPhoto(
	Integer storageplace,
	Boolean isDate, java.sql.Date startDate, java.sql.Date stopDate, 
	Boolean isPhotographer, Integer photographerId
	) throws java.lang.Exception {
		
	int i;
	ArrayList args = new ArrayList();

	// Prepare query	
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT p.photo, p.storageplace, p.date, p.photofilename filename, p.photographer, ");
    sb.append("p.description, TRIM(nvl(pl.lastname,'')) ||' '|| TRIM(nvl(pl.firstname,''))||' '|| TRIM(nvl(pl.middlename,'')) phname, nvl(p.exphotgrname, '') exname "); 
    sb.append("FROM photos p, outer (workers w, people pl) ");
    sb.append("WHERE ");
    sb.append(" w.worker = p.photographer AND w.man = pl.man ");

    sb.append(" AND p.storageplace = ? ");
    args.add(storageplace);
    
    if (isDate.booleanValue()) {
        sb.append(" AND (p.date between ? and ?) ");
	    args.add(startDate);
	    args.add(stopDate);
    }
    
    if (isPhotographer.booleanValue()) {
        sb.append(" AND p.photographer = ? ");
	    args.add(photographerId);
    }
     
    
	//append order by clause
	String orderBy = "p.date asc, p.photographer asc";
	/*
	switch( order.intValue() ) {
		case 1:
			orderBy = "date asc";
			break;
		case 2:
			orderBy = "date desc";
			break;
	}
	*/
	sb.append( " ORDER BY ");
	sb.append(orderBy );

	//System.out.println("SQL=" + sb.toString());
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(),  args.toArray());
	return res;
}
/**
 * Возвращает список заголовков фотографий (без blob-ов)
 */
public CDBCResultSet findPhoto(
	Integer storageplace,
	Boolean isDate, java.sql.Date startDate, java.sql.Date stopDate, 
	Boolean isPhotographer, Integer photographerId, String groupName
	) throws java.lang.Exception {
		
	int i;
	ArrayList args = new ArrayList();

	// Prepare query	
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT p.photo, p.storageplace, p.date, p.photofilename filename, p.photographer, ");
    sb.append("p.description, TRIM(nvl(pl.lastname,'')) ||' '|| TRIM(nvl(pl.firstname,''))||' '|| TRIM(nvl(pl.middlename,'')) phname, nvl(p.exphotgrname, '') exname, p.groupname "); 
    sb.append("FROM photos p, outer (workers w, people pl) ");
    sb.append("WHERE ");
    sb.append(" w.worker = p.photographer AND w.man = pl.man ");

    sb.append(" AND p.storageplace = ? ");
    args.add(storageplace);
    
    if (isDate.booleanValue()) {
        sb.append(" AND (p.date between ? and ?) ");
	    args.add(startDate);
	    args.add(stopDate);
    }
    
    if (isPhotographer.booleanValue()) {
        sb.append(" AND p.photographer = ? ");
	    args.add(photographerId);
    }

    if(groupName != null && groupName.length() > 0) {
	    sb.append(" AND UPPER(p.groupname) MATCHES UPPER(?)");
	    args.add(groupName);
    }
     
    
	//append order by clause
	String orderBy = "p.date asc, p.photographer asc";
	/*
	switch( order.intValue() ) {
		case 1:
			orderBy = "date asc";
			break;
		case 2:
			orderBy = "date desc";
			break;
	}
	*/
	sb.append( " ORDER BY ");
	sb.append(orderBy );

	//System.out.println("SQL=" + sb.toString());
	
	CDBCResultSet res = new CDBCResultSet();
	res.executeQuery(sb.toString(),  args.toArray());
	return res;
}
/**
 * Main Метод для проверки работы других методов.
 * Creation date: (10.03.2004 16:03:42)
 * @param args java.lang.String[]
 */
public static void main(String[] args) throws Exception {

	/*  DEBUG ***************************
	com.hps.july.jdbcpersistence.lib.TimeCounter tc = new com.hps.july.jdbcpersistence.lib.TimeCounter("LEASEPAYMENTS");
	tc.start();
	CDBCLeasePaymentObject o = new CDBCLeasePaymentObject();
	CDBCResultSet rs = o.findByQBE5(
		Boolean.TRUE, new Integer(4227),	// Boolean isLeaseContract, Integer leaseContract
		Boolean.FALSE, null, null,	// Boolean isDate, Date fromDate, Date toDate
		new Boolean(false), new Integer(0),									// Boolean isResource, Integer resource
		new Boolean(true), new String[] { "N", "C" },						// Boolean isDocposvid, String[] docposvid
		new Integer(1)
		);
	tc.finish("SQL");

	tc.start();
	java.util.ListIterator it = rs.listIterator();
	System.out.println("start");
	while (it.hasNext()) {
		CDBCRowObject ro = (CDBCRowObject) it.next();
		CDBCColumnObject co1 = (CDBCColumnObject) ro.getColumn("leasedocposition");
		CDBCColumnObject co2 = (CDBCColumnObject) ro.getColumn("resname");
		System.out.println("" + co1.asObject() + "  '" + co2.asString() + "'");
	}
	tc.finish("Iterate");
	*/
}
}
