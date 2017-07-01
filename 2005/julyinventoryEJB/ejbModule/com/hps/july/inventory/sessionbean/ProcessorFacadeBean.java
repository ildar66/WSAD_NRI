package com.hps.july.inventory.sessionbean;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import com.hps.july.persistence.*;
import java.sql.*;
import javax.sql.*;

/**
 * This is a Session Bean Class
 * Фасад для вызова соответствующего обсчета документа
 */
public class ProcessorFacadeBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;
	public final static String INVENTORY_VARIANT = "INVENTORY_VARIANT";
	public final static String ACCOUNTING_VARIANT = "AccountingVariant ";
/**
 * Снятие обсчета с документа.
 * Creation date: (03.09.2002 17:52:17)
 * @param docCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public void cancelDocument(Integer docCode) 
	throws java.rmi.RemoteException, DocumentProcessingException {

    try {
	    cancelDocument(docCode, true);
    } catch (Exception e) {
        if (e instanceof DocumentProcessingException)
        	throw (DocumentProcessingException)e;  
        throw new java.rmi.RemoteException("While cancelling document", e);
    }
}
/**
 * Снятие обсчета с документа.
 * Creation date: (03.09.2002 17:52:17)
 * @param docCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public void cancelDocument(Integer docCode, boolean deleteAddInfo) 
	throws java.rmi.RemoteException, DocumentProcessingException {

		int variant = determineVariant(INVENTORY_VARIANT);

		if (variant == 2) { // Вариант расчетов с использованием хранимых процедур
			javax.transaction.UserTransaction tranCtx = null;
			DocumentProcessingException exception = new DocumentProcessingException();
			try {
				java.sql.Connection con = getConnection();
				try {
					Statement st = con.createStatement();
					System.out.println("EXECUTING UnProcessDocument");
					ResultSet rs = st.executeQuery("EXECUTE PROCEDURE UnProcessDocument(" + docCode + ")");
					int errorCode = 0;
					while (rs.next()) {
						errorCode = rs.getInt(1);
						recodeError(rs, exception);
					}
					System.out.println("UnProcessDocument: result = " + errorCode);
					if (errorCode != 0)
						throw exception;

					tranCtx = getSessionContext().getUserTransaction();

					// Выполним снятие расчета для акта монтажа АФС
					// Begin the transaction
					tranCtx.begin();
					
					DocumentAccessBean document = new DocumentAccessBean();
					document.setInitKey_document( docCode.intValue() );
					document.refreshCopyHelper();

					//doc type dispatching
					EJBObject ref = document.getEJBRef();
					DocumentProcessingException ex = null;
					if( ref instanceof AfsMountAct ) {
						(new AfsActProcessorAccessBean()).cancelAFSInfo( docCode, deleteAddInfo );
					}
					//Commit the transaction
					tranCtx.commit();
					tranCtx = null;
						
				} finally {
					con.close();
				}	
			} catch( Exception e ) {
				try { if (tranCtx != null) tranCtx.rollback(); } catch (Exception ee) {}
		        if (e instanceof DocumentProcessingException)
		        	throw (DocumentProcessingException)e;  
				throw new java.rmi.RemoteException( "While canceling document with add info", e );
			}
			
		} else {    // Вариант расчетов с использованием EJB
	    javax.transaction.UserTransaction tranCtx = null;
	    try {
	        tranCtx = getSessionContext().getUserTransaction();
	        tranCtx.begin();
	        DocumentAccessBean document = new DocumentAccessBean();
	        document.setInitKey_document(docCode.intValue());
	        document.refreshCopyHelper();

	        //check act state 
	        if (!document.getDocumentState().equals("2")) {
	            throw new DocumentProcessingException(1, "Incompatible state");
	        }

	        //doc type dispatching
	        EJBObject ref = document.getEJBRef();
	        DocumentProcessingException ex = null;
	        if (ref instanceof I13nAct) {
	            ex = (new I13nActProcessorAccessBean()).cancelI13nAct(docCode);
	        } else
	            if (ref instanceof ChangeAct) {
	                ex = (new ChangeActProcessorAccessBean()).cancelChangeAct(docCode);
	            } else
	                if (ref instanceof AssemblingAct) {
	                    ex = (new AssemblingActProcessorAccessBean()).cancelAssemblingAct(docCode);
	                } else
	                    if (ref instanceof InwayBill) {
	                        ex = (new InWayBillProcessorAccessBean()).cancelDocument(docCode);
	                    } else
	                        if (ref instanceof FaultReport) {
	                            ex = (new FaultReportProcessorAccessBean()).cancelFaultReport(docCode);
		                    } else
		                        if (ref instanceof AfsMountAct) {
		                            ex = (new AfsActProcessorAccessBean()).cancelDocument(docCode, deleteAddInfo);
		                        } else {
		                            RealDocumentProcessorAccessBean processor =
		                                new RealDocumentProcessorAccessBean();
		                            ex = processor.cancelDocument(docCode);
		                            //processor.getEJBRef().remove();
		                        }

	        if (ex != null) {
	            throw ex;
	        }
	        //Commit the transaction
	        tranCtx.commit();

	    } catch (Exception e) {
	        if (tranCtx != null) {
	            try {
	                tranCtx.rollback();
	            } catch (Exception ee) {
	                e.printStackTrace(System.out);
	            }
	        }
	        if (e instanceof DocumentProcessingException)
	        	throw (DocumentProcessingException)e;  
	        throw new java.rmi.RemoteException("While cancelling document with add info", e);
	    }
	}
}
/**
 * Checks if additional information for document was modified by hand.
 * Creation date: (03.09.2002 17:52:17)
 * @param docCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public boolean checkAddInfoModification(Integer docCode) throws java.rmi.RemoteException {

	boolean result = false;

	System.out.println("PFAC: Check add info modification called");
	
    javax.transaction.UserTransaction tranCtx = null;
    try {
        tranCtx = getSessionContext().getUserTransaction();
        tranCtx.begin();
        DocumentAccessBean document = new DocumentAccessBean();
        document.setInitKey_document(docCode.intValue());
        document.refreshCopyHelper();

        //doc type dispatching
        EJBObject ref = document.getEJBRef();
        
        if (ref instanceof AfsMountAct) {
			System.out.println("PFAC: instance of AFSMountAct");
            result = (new AfsActProcessorAccessBean()).checkAddInfoModification(docCode);
        } else {
			System.out.println("PFAC: instance of " + ref.getClass().getName());
        }

        //Commit the transaction
        tranCtx.commit();

    } catch (Exception e) {
        if (tranCtx != null) {
            try {
                tranCtx.rollback();
            } catch (Exception ee) {
                e.printStackTrace(System.out);
            }
        }
        throw new java.rmi.RemoteException("While checking add info modification", e);
    }

    return result;
}
/**
 * Определение варианта расчетов.
 * 1 - с использованием EJB
 * 2 - c использованием хранимых
 * Creation date: (19.08.2004 17:37:32)
 * @return int
 */
private int determineVariant(String argVariant) {
	int result = 1;
	try {
		NamedValueAccessBean nv = new NamedValueAccessBean();
		nv.setInitKey_id(argVariant);
		nv.refreshCopyHelper();
		int res = nv.getIntvalue();
		if ( (res == 1) || (res ==2) )
			result = res;
		else
			System.out.println("Invalid value for Constant " + ", using EJB for Inventory");
	} catch (Exception e) {
		System.out.println("Constant " + " not found, using EJB for Inventory");
	}
	return result;
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {}
/**
 * ejbCreate method comment
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate() throws javax.ejb.CreateException, java.rmi.RemoteException {}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException {}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 19:10:28)
 * @return java.sql.Connection
 */
private java.sql.Connection getConnection() throws Exception {
	Properties prp = new com.hps.july.jdbcpersistence.EnvironmentAccessBean().getEnvironmentProperties();
	String dsName = prp.getProperty("DATASOURCE_NAME");
	String factoryClass = prp.getProperty("FACTORY_CLASS");
	
	javax.naming.InitialContext ctx = null;
	Properties prop = new Properties();
	prop.put( javax.naming.Context.PROVIDER_URL, "iiop://" );
	prop.put( javax.naming.Context.INITIAL_CONTEXT_FACTORY, factoryClass );
	ctx = new javax.naming.InitialContext();
	javax.sql.DataSource ds = (javax.sql.DataSource)ctx.lookup( dsName );
	
	return ds.getConnection();
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Очень старая точка входа обсчета документа.
 * Creation date: (03.09.2002 17:52:17)
 * @param docCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public void processDocument(Integer docCode) 
	throws java.rmi.RemoteException, DocumentProcessingException {
	
    try {
	    processDocument(docCode, true);
    } catch (Exception e) {
        if (e instanceof DocumentProcessingException)
        	throw (DocumentProcessingException)e;  
        throw new java.rmi.RemoteException("While applying document", e);
    }
	
}
/**
 * Старая точка входа обсчета документа.
 * Creation date: (03.09.2002 17:52:17)
 * @param docCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public void processDocument(Integer docCode, boolean deleteAddInfo)	throws java.rmi.RemoteException, DocumentProcessingException {
    try {
	    processDocument(docCode, deleteAddInfo, false);
    } catch (Exception e) {
        if (e instanceof DocumentProcessingException)
        	throw (DocumentProcessingException)e;  
        throw new java.rmi.RemoteException("While applying document", e);
    }
}
	
public void deleteDocument(Integer documentCode) throws java.rmi.RemoteException, DocumentProcessingException {
	int variant = determineVariant(INVENTORY_VARIANT);

	if (variant == 2) { // Вариант расчетов с использованием хранимых процедур
		javax.transaction.UserTransaction tranCtx = null;
		DocumentProcessingException exception = new DocumentProcessingException();
		try {
			java.sql.Connection con = getConnection();
			try {
				PreparedStatement st = con.prepareStatement("EXECUTE PROCEDURE DeleteDocument(?)");
				st.setInt(1, documentCode.intValue());

				System.out.println("EXECUTING DeleteDocument");
				ResultSet rs = st.executeQuery();
				
				int errorCode = 0;
				while (rs.next()) {
					errorCode = rs.getInt(1);
					recodeError(rs, exception);
				}
				System.out.println("DeleteDocument: result = " + errorCode);

				if ( (errorCode != 0) && (exception.getErrorCode() == 0) ) {
					// Если есть предупреждения
					java.util.Iterator it = exception.getPositionErrors().iterator();
					while (it.hasNext()) {
						ProcessingPositionError err = (ProcessingPositionError)it.next();
						if (err.getErrorLevel() == 2) {
							exception.setErrorCode(7); // Запросим подтверждение пользователя на исправление ошибок
							break;
						}
					}
				}
				System.out.println("In EJB Error code = " + exception.getErrorCode());
					
				if (errorCode != 0)
					throw exception;

			} finally {
				con.close();
			}	
		} catch( Exception e ) {
			if (e instanceof DocumentProcessingException)
				throw (DocumentProcessingException)e;  
			throw new java.rmi.RemoteException( "While deleting document", e );
		}
			
	} else {    // Вариант расчетов с использованием EJB
		throw new UnsupportedOperationException("this variant not supported. Ask Nikolay Izhikov or Dmitriy Dneprov");
	}
}	
	
/**
 * Основная точка входа для обсчета документа.
 * Creation date: (03.09.2002 17:52:17)
 * @param docCode java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public void processDocument(Integer docCode, boolean deleteAddInfo, boolean generateAutoDocs) 
	throws java.rmi.RemoteException, DocumentProcessingException {

		int variant = determineVariant(INVENTORY_VARIANT);

		if (variant == 2) { // Вариант расчетов с использованием хранимых процедур
			javax.transaction.UserTransaction tranCtx = null;
			DocumentProcessingException exception = new DocumentProcessingException();
			try {
				java.sql.Connection con = getConnection();
				try {
					int paramGenerateAutoDocs = 0;
					if (generateAutoDocs)
						paramGenerateAutoDocs = 1;
					Statement st = con.createStatement();
					System.out.println("EXECUTING ProcessDocument");
					ResultSet rs = st.executeQuery("EXECUTE PROCEDURE ProcessDocument(" + docCode + ", " + paramGenerateAutoDocs + ")");
					int errorCode = 0;
					while (rs.next()) {
						errorCode = rs.getInt(1);
						recodeError(rs, exception);
					}
					System.out.println("ProcessDocument: result = " + errorCode);

					// Определим вариант расчетов
					int accVariant = determineVariant(ACCOUNTING_VARIANT);

					// Вариант 1: Ошибки исправляет пользователь
					// Вариант 2: Пользователь может разрешить автоматическое устранение ошибок
					if ( (errorCode != 0) && (accVariant == 2) && (exception.getErrorCode() == 0) && (!generateAutoDocs) ) {
						// Если есть предупреждения
						java.util.Iterator it = exception.getPositionErrors().iterator();
						while (it.hasNext()) {
							ProcessingPositionError err = (ProcessingPositionError)it.next();
							if (err.getErrorLevel() == 2) {
								exception.setErrorCode(7); // Запросим подтверждение пользователя на исправление ошибок
								break;
							}
						}
					}
					System.out.println("In EJB Error code = " + exception.getErrorCode());
					
					if (errorCode != 0)
						throw exception;

					tranCtx = getSessionContext().getUserTransaction();

					// Выполним расчет для акта монтажа АФС
					// Begin the transaction
					tranCtx.begin();
					
					DocumentAccessBean document = new DocumentAccessBean();
					document.setInitKey_document( docCode.intValue() );
					document.refreshCopyHelper();

					//doc type dispatching
					EJBObject ref = document.getEJBRef();
					DocumentProcessingException ex = null;
					if( ref instanceof AfsMountAct ) {
						(new AfsActProcessorAccessBean()).applyAFSInfo( docCode, deleteAddInfo );
					}
					//Commit the transaction
					tranCtx.commit();
					tranCtx = null;
					
				} finally {
					con.close();
				}	
			} catch( Exception e ) {
				try { if (tranCtx != null) tranCtx.rollback(); } catch (Exception ee) {}
		        if (e instanceof DocumentProcessingException)
		        	throw (DocumentProcessingException)e;  
				throw new java.rmi.RemoteException( "While applying document with add info", e );
			}
			
		} else {    // Вариант расчетов с использованием EJB
			javax.transaction.UserTransaction tranCtx = null;
			
			try {
				tranCtx = getSessionContext().getUserTransaction();


				// Start preprocessing in separate transaction
				
				// Begin the transaction
				tranCtx.begin();
				
				DocumentAccessBean document = new DocumentAccessBean();
				document.setInitKey_document( docCode.intValue() );
				document.refreshCopyHelper();

				//check act state 
				if( !document.getDocumentState().equals( "1" ) ) {
					tranCtx.rollback();
					throw new DocumentProcessingException( 1, "Incompatible state" );			
				}
				
				DocumentPreprocessorAccessBean preprocessor = new DocumentPreprocessorAccessBean();
				DocumentProcessingException ex = preprocessor.preprocessDocument( docCode.intValue() );
				if (ex != null) {
					tranCtx.rollback();
					throw ex;
				}

				//Commit the transaction
				tranCtx.commit();


				tranCtx = getSessionContext().getUserTransaction();
				// Begin the transaction
				tranCtx.begin();
				
				document = new DocumentAccessBean();
				document.setInitKey_document( docCode.intValue() );
				document.refreshCopyHelper();

				//check act state 
				if( !document.getDocumentState().equals( "1" ) ) {
					tranCtx.rollback();
					throw new DocumentProcessingException( 1, "Incompatible state" );			
				}
				
				//doc type dispatching
				EJBObject ref = document.getEJBRef();
				ex = null;
				if( ref instanceof I13nAct ) {
					ex = (new I13nActProcessorAccessBean()).processI13nAct( docCode );
				} else if( ref instanceof ChangeAct ) {
					ex = (new ChangeActProcessorAccessBean()).applyChangeAct( docCode );
				} else if( ref instanceof AssemblingAct ) {
					ex = (new AssemblingActProcessorAccessBean()).applyAssemblingAct( docCode );
				} else if( ref instanceof InwayBill ) {
					ex = (new InWayBillProcessorAccessBean()).applyDocument( docCode );
				} else if( ref instanceof FaultReport ) {
					ex = (new FaultReportProcessorAccessBean()).applyFaultReport( docCode );
				} else if( ref instanceof AfsMountAct ) {
					ex = (new AfsActProcessorAccessBean()).applyDocument( docCode, deleteAddInfo );
				} else {
					RealDocumentProcessorAccessBean processor = new RealDocumentProcessorAccessBean();
					ex = processor.applyDocument( docCode );
					//processor.getEJBRef().remove();
				}
			
				if( ex != null ) {
					tranCtx.rollback();
					throw ex;
				}
					
				//Commit the transaction
				tranCtx.commit();

				// Additional processing (platinum) in a new transaction
				tranCtx = getSessionContext().getUserTransaction();
				// Begin the transaction
				tranCtx.begin();
				
				document = new DocumentAccessBean();
				document.setInitKey_document( docCode.intValue() );
				document.refreshCopyHelper();
				
				//doc type dispatching
				ref = document.getEJBRef();
				ex = null;
				if( ref instanceof ChangeAct ) {
					// Send ChangeAct to Platinum
					
					// find surplus
					DocumentsLinkAccessBean surplusLink = null;
					java.util.Enumeration en1 = new DocumentsLinkAccessBean().findByTypeAndDocFrom("S", docCode);
					if (en1.hasMoreElements())
						surplusLink = (DocumentsLinkAccessBean)en1.nextElement();

					// find payOff
					DocumentsLinkAccessBean payoffLink = null;
					java.util.Enumeration en2 = new DocumentsLinkAccessBean().findByTypeAndDocFrom("P", docCode);
					if (en2.hasMoreElements())
						payoffLink = (DocumentsLinkAccessBean)en2.nextElement();
					
					com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean platproc = new com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean();
					Integer query = platproc.processVirtualDocument(docCode);
					if (payoffLink != null) {
						int payoffCode = payoffLink.getDocumentTo().getDocument();
						platproc.processDocument(query, new Integer(payoffCode));
					}
					if (surplusLink != null) {
						int surplusCode = surplusLink.getDocumentTo().getDocument();
						platproc.processDocument(query, new Integer(surplusCode));
					}
				}
			
				if( ex != null ) {
					tranCtx.rollback();
					throw ex;
				}
					
				//Commit the transaction
				tranCtx.commit();
				
			} catch( Exception e ) {
				if (tranCtx != null) {
					try {
						tranCtx.rollback();
					} catch (Exception ee) {
						e.printStackTrace(System.out);
					}
				}
		        if (e instanceof DocumentProcessingException)
		        	throw (DocumentProcessingException)e;  
				throw new java.rmi.RemoteException( "While applying document with add info", e );
			}
		}
	}
/**
 * Перекодировка из ошибок хранимой в ошибки EJB.
 * Creation date: (19.08.2004 18:25:10)
 */
public void recodeError(ResultSet rs, DocumentProcessingException exception) {
		ProcessingPositionError error = new ProcessingPositionError();
		try {
			int errorCode = rs.getInt(1);
			int ejbErrorCode = 0;
			switch (errorCode) {
				case 0:  // Нет ошибок хранимой
					System.out.println(">>>> PROCESSDOC: SPL OK");
					break;
				case 200: // Неверное состояние документа
					exception.setErrorCode(1);
					exception.setErrorMessage("Incompatible state");
					break;
				case 31: // Конфигурация оборудования уже изменилась
					exception.setErrorCode(31);
					exception.setErrorMessage("Config already changed");
					break;
				case 32: // Ошибка при изменении конфигурация оборудования
					exception.setErrorCode(32);
					exception.setErrorMessage("Config changed error");
					break;
				default:
					error.setErrorCode( errorCode );
					error.setMessage( "Error" );
					error.setPositionCode( rs.getInt(2) );
					error.setLastDocumentCode( rs.getInt(3) );
					error.setI13nAct(error.getLastDocumentCode());
					error.setI13nDate(rs.getDate(4));
					error.setOwner(rs.getInt(5));
					error.setParty(rs.getString(6));
					error.setResource(rs.getInt(7));
					error.setSerial(rs.getString(8));
					error.setStorage(rs.getInt(9));
					error.setPrice(rs.getBigDecimal(10));
					error.setQty(rs.getBigDecimal(11));
					error.setStoragecard(rs.getInt(12));
					error.setErrorLevel(rs.getInt(13));
					System.out.println(">>>> PROCESSDOC: SPL ERROR: Error code=" + error.getErrorCode() + 
						", pos=" + error.getPositionCode() + ", document=" + error.getLastDocumentCode() + 
						", resource = " + error.getResource() + ", serial = " + error.getSerial());
					exception.addError( error );
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
			exception.setErrorCode(-1);
			exception.setErrorMessage("Error while getting error");
		}
		System.out.println("recodeError  docError=" + exception.getErrorCode());
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
}
