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
public interface LeaseChargesBeanFinderHelper extends com.hps.july.persistence.LeaseDocPositionBeanFinderHelper {
	public static final String findByLeaseContractWhereClause = "leasecontract = ?";
	public java.sql.PreparedStatement findByQBE2(Integer leaseRule,
    java.sql.Date startDate, 	java.sql.Date finishDate, // диапазон дат для date
    Boolean isSource, String source) throws Exception;
	public java.sql.PreparedStatement findByQBE3(Integer leaseContract, Integer resource, 
		java.sql.Date startInterval, java.sql.Date finishInterval) throws Exception;
	public java.sql.PreparedStatement findByQBE4(
        Integer contract, 
        Boolean isStartDate, java.sql.Date actStartDate, 
        Boolean isEndDate, java.sql.Date actEndDate,
        Boolean isRemainder, java.math.BigDecimal remainder,
        Boolean isResource, Integer resource,
        Boolean isCalcPosOnly,
        Integer order) throws Exception;
}
