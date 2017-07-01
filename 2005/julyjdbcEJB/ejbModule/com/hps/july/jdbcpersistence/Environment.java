package com.hps.july.jdbcpersistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Environment extends javax.ejb.EJBObject {
public static final String PROPERTY_DATASOURCE_NAME="DATASOURCE_NAME";
public static final String PROPERTY_FACTORY_CLASS="FACTORY_CLASS";
/**
 * 
 * @return java.util.Properties
 * @exception String The exception description.
 */
java.util.Properties getEnvironmentProperties() throws java.rmi.RemoteException;
}
