package com.hps.july.persistence;

/**
 * For each finder method, other than findByPrimaryKey and the finder methods generated 
 * for supporting assocations, which is defined in the home interface, an SQL query string
 * or a method declaration must be defined in this interface.
 *
 * For example, the home interface may contain the method:
 *		public java.util.Enumeration findGreaterThan(int threshold) throws java.rmi.RemoteException, javax.ejb.FinderException;
 * The user may provide one of the following three forms in this interface:
 *
 * SELECT Custom Finder:
 *    Note: For compatibility with old code.  Do not use this form for new development.
 *
 *    public static final String findGreaterThanQueryString = "SELECT * FROM MYTABLE T1 WHERE T1.VALUE > ?";
 *
 * WHERE Custom Finder:
 *
 *    public static final String findGreaterThanWhereClause = "T1.VALUE > ?";
 *    
 *    In case that there is no where clause in the SQL statement such as "SELECT * FROM MYTABLE",
 *    use a query string that always evaluates to true.  For example,
 *    public static final String findAllWhereClause = "1 = 1";
 *
 * Method Custom Finder:
 *
 *    public java.sql.PreparedStatement findGreaterThan(int threshold) throws Exception;
 *
 *    An implementation of this method must be provided in a class that follows these rules:
 *    1.  The name of the class is either <beanClassName>FinderObject or the name of the
 *         class is specified in the environment properties of the enterprise bean.  The name
 *         of the property must be CustomFinderClassName.  The value of the property must
 *         be the fully qualified class name (including the package name).
 *    2.  The class must be in the same package as the deployed code for the bean.
 *    3.  The class must extend com.ibm.vap.finders.VapEJSJDBCFinderObject and must 
 *         implement this finder helper interface.
 * 
 * This implementation will be referenced by the persister class generated when
 * deployed code is generated.
 *
 * If you will be exporting to Component Broker (CB), then you may provide one of the 
 * following four fields.  Each field's value needs to be written in OO SQL syntax.  Please refer to
 * the CB documentation for the exact syntax to be used.  Note, if one of these fields does not 
 * exist, a stub method will be generated on the finder helper class.
 *
 * Allowable CB Custom Finder Statements:
 *
 *    1.  findGreaterThanCBWhereClause - generates finder method using evaluate(...) or singleEvaluate(...)
 *    2.  findGreaterThanCBQueryString - generates finder method using extendedEvaluate(...) or extendedSingleEvaluate(...)
 *    3.  findGreaterThanCBLazyWhereClause - generates finder method using lazyEvaluate(...)
 *    4.  findGreaterThanCBLazyQueryString - generates finder method using extendedLazyEvaluate(...)
 *
 * Example:
 *    public static final String findGreaterThanCBWhereClause = "value_ > ?";
 **/
public interface StorageCardBeanFinderHelper {
	public static final String findBySerialWhereClause = "serialnumber=? and closed = \"N\"";
	public static final String findBySerieWhereClause = "serialnumber >= ? AND serialnumber <= ? and closed = \"N\"";
	public static final String findBySerialMaskOrderBySerialAscWhereClause = "upper(serialnumber) matches upper (?) and closed = \"N\" order by serialnumber ASC";
	public static final String findByPartyMaskOrderByPartyAscWhereClause = "upper(party) matches upper (?) and closed = \"N\" order by party ASC";
	public static final String findByPartieWhereClause = "party >= ? AND party <= ? and closed = \"N\"";
	public static final String findByStorageNotAgregatedOrderByResourceAscWhereClause = "storageplace = ? AND closed='N' AND " +
		" NOT EXISTS (SELECT agregate FROM agregatecontents agr WHERE agr.agregatepart = t1.storagecard) ORDER BY resource ASC";
	public static final String findByMainAgregateOrderByResourceAscWhereClause = "closed='N' AND " +
		" storagecard IN (SELECT agregatepart FROM agregatecontents agr WHERE agr.agregate = ?) ORDER BY resource ASC";
	public static final String findClosedBySerialInStorageWhereClause = "serialnumber=? and closed = \"Y\" and storageplace = ?";
	public static final String findByStorageOwnerPartyWhereClause = "closed = \"N\" and storageplace=? and owner = ? and party = ?";
	public static final String findByStorageOwnerResourceWhereClause = "closed = \"N\" and storageplace=? and owner = ? and resource = ?";
	public static final String findByStorageResourceWhereClause = "storageplace=? and resource=? and closed = \"N\"";
	public static final String findByStorageAndI13nResourceSetActWhereClause = "t1.storageplace = ? and t1.resource in ( "+
	"select i.resource from i13nactresourceset i where i.document = ?"+
	" )";
	public static final String findPosibillity2IgnoreI13nDateWhereClause = "t1.storagecard=? and exists "+
	"(select i.* from i13ndatesav i where i.storagecard=t1.storagecard and i.document in ("+
	"select d.documentfrom from docdependencies d where d.documentto=? and d.type in (\"P\", \"S\") "+
	"))";
	public static final String findBadAgregatesByDocumentWhereClause = 
"t1.storagecard in                                                             "+
"(                                                                             "+
"select s1.storagecard from storagecards s, agregatecontents a,                "+
"    storagecards s1, docpositions d                                           "+
"   where                                                                      "+
"       s.serialnumber = d.serialnumber and d.document = ? and                 "+
"        exists (                                                              "+
"            select dd.agregate                                                "+
"            from docpositions dd                                              "+
"            where dd.agregate = d.docposition and dd.document = d.document    "+
"        )                                                                     "+
"   and s.closed = \"N\"                                                         "+
"   and a.agregate = s.storagecard                                             "+
"   and s1.storagecard = a.agregatepart                                        "+
"   and not exists (                                                           "+
"    select ddd.docposition from docpositions ddd, docpositions dddd           "+
"     where                                                                    "+
"        ddd.agregate=dddd.docposition and                                     "+
"        dddd.serialnumber = s1.serialnumber and                               "+
"        dddd.document = ddd.document and                                      "+
"        ddd.document = d.document and                                         "+
"     (                                                                        "+
"     (s1.serialnumber = ddd.serialnumber                                      "+
"        and s1.policy = \"S\" and s1.closed = \"N\")                              "+
"     or                                                                       "+
"     (s1.party = ddd.party and s1.policy = \"P\" and ddd.qty = a.qty)           "+
"     or                                                                       "+
"     (s1.resource = ddd.resource and s1.policy = \"B\" and ddd.qty = a.qty)     "+
"     )                                                                        "+
"   )                                                                          "+
")                                                                             ";
	public java.sql.PreparedStatement findByResourceQBE( Integer argResourceSubType, Integer argStorage, String argPolicy,
	String argSerial, String argParty, Integer order ) throws Exception;
	public java.sql.PreparedStatement findByStorageNotInDoc(
    Integer storageplace,
    Boolean useAgregate, Integer agregate,
    Integer document,
    Integer order ) throws Exception;
	public java.sql.PreparedStatement findStorageCardByQBE(
    Integer storageplace,
    Boolean isOwner, Integer owner,
    Boolean isResourceset, Integer resourceset,
    Boolean isResource, Integer resource,
    Boolean isSubType, Integer resourceSubType,
    Boolean isModel, String model, /* match строчка */
    Boolean isName, String name, /* match строчка */
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer order
) throws Exception;
	public java.sql.PreparedStatement findStorageCardByQBE2(
    Boolean isSubType, Integer resourceSubType,
    Boolean isModel, String model, /* match строчка */
    Boolean isName, String name, /* match строчка */
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Integer connected, Integer owner,
    Integer order
) throws Exception;
	public java.sql.PreparedStatement findStorageCardByQBE3(
    Integer storageplace,
    Boolean isOwner, Integer owner,
    Boolean isResourceset, Integer resourceset,
    Boolean isResource, Integer resource,
    Boolean isSubType, Integer resourceSubType,
    Boolean isModel, String model, /* match строчка */
    Boolean isName, String name, /* match строчка */
    Boolean isManufacturer, Integer manufacturer,
    Boolean isManucode, String manucode,
    Boolean onlyWithoutParts,
    Integer brokenType,
    Integer documentKey,
    Boolean useExcludeFilter, Integer storageCard,
    Boolean usePolicy, String policy,
    Integer order
) throws Exception;
}
