package com.hps.july.sitedoc.valueobject;

import com.hps.july.jdbcpersistence.lib.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.hps.july.persistence.*;

/**
 * ��������� ����� ��� ��������� ������ ����� �����
 * � ���������� ������ �� ���
 */
public class LinkObject
    extends JdbcObject
    implements Checks, SearchConstants
{
	private Integer objectid; //PK
	private String objecttype;
	private String linktype;
	private String linkname;

    public static final String QUERY_SELECT_HOPS =
		"SELECT sd2h.hopsid objectid, 'H' objectType, "+
		"	CASE h.hopstype WHEN 'R' THEN '����� ����� ���'  WHEN 'O' THEN '����� ����� ����' END linktype, "+
		"	(SELECT hopsname FROM hopslabel WHERE hopslabelid = (SELECT MAX(hopslabelid) FROM hopslabel WHERE hopsid = h.hopsid)) linkname "+
		"FROM sitedocs2hops sd2h, hops h "+
		"WHERE sd2h.hopsid = h.hopsid AND sd2h.sitedoc = ? AND h.hopsid <> ? ";
    public static final String QUERY_SELECT_SP =
    	"SELECT sd2p.storageplace objectid, 'S' objectType, "+
		"CASE sp.type "+
		"WHEN 'P' THEN '�������' "+
		"WHEN 'E' THEN '�������������� ��������' "+
		"WHEN 'B' THEN (SELECT '������� ������� ' || DECODE(b.type,'D','DAMPS','S','GSM 900','C','DCS 1800','G','GSM 900/1800','?') FROM basestations b WHERE b.equipment = sp.storageplace) "+
		"WHEN 'C' THEN NVL((SELECT DECODE(ce.type,'R','������������ ���','O','������������ ����','A','��������������� ������������ ��','?') FROM comequipment ce WHERE ce.equipment = sp.storageplace),'������������ ��') "+
		"WHEN 'O' THEN '����������' "+
		"WHEN 'W' THEN (SELECT '���������' || DECODE(sw.type,'1',' DAMPS','2',' GSM/DCS','') FROM switches sw WHERE sw.equipment = sp.storageplace) "+
		"WHEN 'R' THEN (SELECT '�������' || DECODE(r.repiter_class,'A',', ������, ���������','B',', ������, ���������','C',', ������, ��������� � ��������� �������','D',', ������� ��������, ���������','E',', ����� ��������, ���������','') FROM repiters r WHERE r.equipment = sp.storageplace) "+
		"WHEN 'T' THEN '��������������� ������������' "+
		"END linktype, "+
		"CASE sp.type "+
		"WHEN 'P' THEN (SELECT NVL('D' || p.gsmid || ' ', '') || NVL('A'||p.dampsid||' ','') || TRIM(s.name)  FROM storageplaces s, positions p WHERE s.storageplace = p.storageplace AND s.storageplace = sp.storageplace) "+
		"WHEN 'E' THEN sp.name "+
		"WHEN 'B' THEN (SELECT TRIM(NVL(b.number || ' ','') || b.name) FROM basestations b WHERE b.equipment = sp.storageplace) "+
		"WHEN 'C' THEN sp.name "+
		"WHEN 'O' THEN (SELECT NVL(c.number || ' ' || sp.name, '') FROM controllers c WHERE c.equipment = sp.storageplace) "+
		"WHEN 'W' THEN (SELECT NVL(sw.number || ' ' || sp.name, '') FROM switches sw WHERE sw.equipment = sp.storageplace) "+
		"WHEN 'R' THEN (SELECT TRIM(re.model) FROM resources re, repiters r WHERE r.equipment = sp.storageplace AND r.resource = re.resource) "+
		"WHEN 'T' THEN (SELECT DECODE(o.type,'A','����������','B','�����������','C','�������������','D','������','') FROM otherequipment o WHERE o.equipment = sp.storageplace) "+
		"END linkname "+
		"FROM sitedocs2splace sd2p, storageplaces sp "+
		"WHERE sd2p.storageplace = sp.storageplace AND sp.type NOT IN ('S','X') AND sd2p.sitedoc = ? AND sp.storageplace <> ? ";
    /**
     * PositionObject constructor comment.
     */
    public LinkObject() throws Exception {
        super();
    }
public LinkObject(java.sql.ResultSet rs) throws Exception {
	super();
	try {
		objectid = new Integer(rs.getInt("objectid"));
		objecttype = getString(rs, "objectType"); 
		linktype = getString(rs, "linktype");
		linkname = getString(rs, "linkname");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
    }
}
public Vector findLinksList(int sitedoc, int hopsOID, int spOID)
	throws Exception
{
    Query query;
    
	query = new Query(RESULT_JdbcObjectEnum);
	query.append("(");
	query.append(QUERY_SELECT_HOPS,new Integer(sitedoc),new Integer(hopsOID));
	query.append(") UNION (");
	query.append(QUERY_SELECT_SP,new Integer(sitedoc),new Integer(spOID));
	query.append(")");
    query.append("ORDER BY 3,4");

    return findVector(query);
}
public java.lang.String getLinkname() {
	return linkname;
}
public java.lang.String getLinktype() {
	return linktype;
}
public java.lang.Integer getObjectid() {
	return objectid;
}
public java.lang.String getObjecttype() {
	return objecttype;
}
public void setLinkname(java.lang.String newLinkname) {
	linkname = newLinkname;
}
public void setLinktype(java.lang.String newLinktype) {
	linktype = newLinktype;
}
public void setObjectid(java.lang.Integer newObjectid) {
	objectid = newObjectid;
}
public void setObjecttype(java.lang.String newObjecttype) {
	objecttype = newObjecttype;
}
}
