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
public interface LeaseArendaAgreementNewBeanFinderHelper extends com.hps.july.persistence.LeaseContractBeanFinderHelper {
	
public java.sql.PreparedStatement findByContractAndResource(Integer contract, Integer resource, Integer order)
 throws Exception;
	java.sql.PreparedStatement findByQBE(
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isPosition, 			java.lang.Integer position, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber, 
	java.lang.Boolean isState, 				java.lang.String state, // состояние базового договора
	java.lang.Integer order) throws Exception;
public java.sql.PreparedStatement findByQBE2( java.lang.Integer mainLeaseDocument, 
	java.lang.Boolean isIsActive, 		Boolean isActive,
	java.lang.Boolean isContractState,  String contractState,
	java.lang.Integer order) throws Exception;
	 public java.sql.PreparedStatement findByQBE3(Boolean isEndDate, java.sql.Date startEndDate, java.sql.Date finishEndDate,
        Boolean isIsActive, Boolean isActive,
        Boolean isContractState, String ContractState,
        Boolean isExtendType, String ExtendType, Boolean isEconomist, Integer economist) throws Exception;
public java.sql.PreparedStatement findByQBE4(Boolean isEconomist, Integer economist) throws Exception;
	java.sql.PreparedStatement findByQBE5(
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isPosition, 			java.lang.Integer position, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber, 
	java.lang.Boolean isState, 				java.lang.String state, // состояние базового договора
	java.lang.Integer order) throws Exception;
}
