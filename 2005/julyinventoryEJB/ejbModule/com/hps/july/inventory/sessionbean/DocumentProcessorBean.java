package com.hps.july.inventory.sessionbean;

import javax.transaction.*;
import com.hps.july.persistence.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import java.math.*;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Основной алгоритм обсчета документов
 */
public class DocumentProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

	private DocumentProcessorContext context;
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 18:07:07)
 */
public DocumentProcessorBean() {
	context = new DocumentProcessorContext();
	}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 17:46:11)
 * @return com.hps.july.inventory.sessionbean.ProcessingPositionError
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception java.rmi.RemoteException The exception description.
 */
public ProcessingPositionError addPosition2Document( Integer argPosition) throws java.rmi.RemoteException {
	try {
		System.out.println("AddPosition to document #1");
		DocumentPositionAccessBean position = new DocumentPositionAccessBean();
		position.setInitKey_docposition( argPosition.intValue() );
		position.refreshCopyHelper();
		System.out.println("AddPosition to document #2");
		DocumentAccessBean document = position.getDocument();
		document.refreshCopyHelper();
		System.out.println("AddPosition to document #3");
		if( document.getProcessSource().booleanValue() ) {
			if( position.getResource().getCountpolicy().equals("S") ) {
				if (position.getSerialnumber() == null)
					return null;
				//find corresponding storagecard
				StorageCardAccessBean card = (new StorageCardAccessBean()).findBySerial( position.getSerialnumber() );
				//must be the same storage
				if( card.getCurrentstorageKey().storageplace != document.getFromKey().storageplace ) {
					ProcessingPositionError error = new ProcessingPositionError();
					error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
					error.setStorage( card.getCurrentstorageKey().storageplace );
					error.setSerial( position.getSerialnumber() );
					return error;
				}
				//must be the same resource
				if( card.getResourceKey().resource != position.getResourceKey().resource ) {
					ProcessingPositionError error = new ProcessingPositionError();
					error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE );
					error.setResource( position.getResourceKey().resource );
					error.setSerial(position.getSerialnumber());
					return error;
				}
				//must be the same owner
				if( card.getOwnerKey().organization != position.getOwnerKey().organization ) {
					ProcessingPositionError error = new ProcessingPositionError();
					error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_OWNER );
					error.setOwner( position.getOwnerKey().organization );
					return error;
				}
				AgregateContentAccessBeanTable parts = new AgregateContentAccessBeanTable();
				parts.setAgregateContentAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
					card.getAgregateContent(), AgregateContentAccessBean.class ));
				int max = (new DocumentPositionAccessBean()).
					findMaxOrderPosition( new Integer( document.getDocument() ) ).getOrder();
				for( int i = 0; i < parts.numberOfRows(); i++ ) {
					StorageCardAccessBean sc = parts.getAgregateContentAccessBean(i).getParts();
					DocumentPositionAccessBean pos = new DocumentPositionAccessBean( 
						(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions"), 
						new Integer(sc.getResourceKey().resource), new Integer(sc.getOwnerKey().organization), 
						new Integer(document.getDocument()), 
						++max, parts.getAgregateContentAccessBean(i).getQty(), 
						sc.getPrice(), sc.getBoxed(), position.getResultBoxed(), sc.getBroken(), 
						position.getResultBroken(), sc.getClosed(), position.getResultClosed() );
					pos.setParty( sc.getParty() );
					pos.setSerialnumber( sc.getSerialnumber() );
					pos.setConfiguration( sc.getConfiguration() );
					pos.setAgregate( (DocumentPosition)(position.getEJBRef()) );
					pos.commitCopyHelper();
				}
			}
		}
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While adding position to document.", e );
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError applyDocPosition( DocumentAccessBean document, DocumentPositionAccessBean position) 
throws java.rmi.RemoteException {
	try {
		Util.printDebug( "Applying position code="+position.getDocposition()+" serial="+position.getSerialnumber() );
		
		ProcessingPositionError error = null;

		//check i13n
		int i13nAct = checkForI13n( document, position );
		if( i13nAct != 0 ) {
			error = new ProcessingPositionError();
			error.setErrorCode( ProcessingPositionError.ERRORS.INVENTARIZATION_BEFORE );
			error.setMessage( "Inventarization restrict this operation act="+i13nAct );
			error.setI13nAct(i13nAct);
			return error;
		}
		 
		if( position.getResource().getCountpolicy().equals( "S" ) ) {
			if( document.getProcessSource().booleanValue() && document.getProcessDestination().booleanValue() ) {
				error = processSerialPositionFromTo( document, position);
				if( error != null )
					return error;
			} else if( document.getProcessSource().booleanValue() && !document.getProcessDestination().booleanValue() ) {
				error = processSerialPositionFrom( document, position);
				if( error != null )
					return error;
			} else if( !document.getProcessSource().booleanValue() && document.getProcessDestination().booleanValue() ) {
				error = processSerialPositionTo( document, position);
				if( error != null )
					return error;
			} else if( !document.getProcessSource().booleanValue() && !document.getProcessDestination().booleanValue() ) {
			}
		} else {
			if( document.getProcessSource().booleanValue() ) {
				error = getNonSerialPositionFrom( document, position );
				if( error != null )
					return error;
			}
			if( document.getProcessDestination().booleanValue() ) {
				error = putNonSerialPositionTo( document, position ); 
				if( error != null )
					return error;
			}
		}
		
		return null;
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While appling position", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 11:08:04)
 * @return java.util.Enumeration 
 * @param docPosition java.lang.Integer 
 */
public DocumentProcessingException applyDocument(Integer argDoc ) 
	throws java.rmi.RemoteException  {
	try {
		//getDocument
		DocumentAccessBean document = new DocumentAccessBean();
		document.setInitKey_document( argDoc.intValue() );
		document.refreshCopyHelper();
		
		//check Document State 
		if( !document.getDocumentState().equals( "1" ) ) {
			return new DocumentProcessingException( 1, "Incompatible state" );
		}

		DocumentProcessingException exception = new DocumentProcessingException();
		HashMap agregateErrors = new HashMap();


		// DD - Check if document have duplicate serial numbers
		HashMap docSerials = new HashMap();
		DocumentPositionAccessBeanTable dPoss = new DocumentPositionAccessBeanTable();
		dPoss.setDocumentPositionAccessBean( 
			new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
			document.getDocumentPosition() ,DocumentPositionAccessBean.class ) 
		);
		for( int i = 0; i < dPoss.numberOfRows(); i++ ) {
			DocumentPositionAccessBean pos = dPoss.getDocumentPositionAccessBean(i);
			String aserial = null;
			if (pos.getSerialnumber() != null)
				aserial = pos.getSerialnumber();
			/*
			if (pos.getOldAgregateSerial() != null)
				aserial = pos.getOldAgregateSerial();
			if (pos.getAgregateSerial() != null)
				aserial = pos.getAgregateSerial();
			*/
			if (aserial != null) {

				if (docSerials.containsKey(aserial)) {
					ProcessingPositionError error = new ProcessingPositionError();
					error.setPositionCode( pos.getDocposition() );
					error.setErrorCode( ProcessingPositionError.ERRORS.DUPLICATE_SERIAL );
					error.setMessage( "Duplicate serial number in docpositions!" );
					System.out.println(">>>> APPLYDOC: Error code=" + error.getErrorCode() + 
						", pos=" + error.getPositionCode() + ", message=" + error.getMessage());
					exception.addError( error );
				} else {
					docSerials.put(aserial, pos);
				}
			}
		}

			
		// DD ---------------------------------------------------------------
		
		if( document.getProcessSource().booleanValue() ) {
			//check agregates  
			//find all bad agregate positions
			//for every document position check its storagecard agregation equalence
			DocumentPositionAccessBeanTable dPos = new DocumentPositionAccessBeanTable();
			dPos.setDocumentPositionAccessBean( 
				new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
				document.getDocumentPosition() ,DocumentPositionAccessBean.class ) 
			);
			for( int i = 0; i < dPos.numberOfRows(); i++ ) {
				DocumentPositionAccessBean pos = dPos.getDocumentPositionAccessBean(i);
				if( pos.getAgregate() != null || pos.getOldAgregateSerial() != null ) {
					String dpSerial = null;
					if( pos.getAgregate() != null ) {
						dpSerial = pos.getAgregate().getSerialnumber();
					} else {
						dpSerial = pos.getOldAgregateSerial();
					}
					try {
						StorageCardAccessBean agregateCard = (new StorageCardAccessBean()).findBySerial( dpSerial );
						/////////////////////// DD ///////////////////////////
						// Check if agregate head is in the FROM storage
						if (agregateCard.getCurrentstorageKey().storageplace != document.getFromKey().storageplace) {
							//////////////////////////////////
							ProcessingPositionError error = new ProcessingPositionError();
							error.setErrorCode( ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE );
							error.setSerial(dpSerial);
							error.setMessage( "#1 Trying to move head card from other storage serial=" + dpSerial );
							error.setStorage( agregateCard.getCurrentstorage().getStorageplace() );
							exception.addError( error );
							agregateErrors.put( new Integer(pos.getDocposition()), error );
						}
						/////////////////////// DD ///////////////////////////

						
						StorageCardAccessBean posCard = null;
						if( pos.getResource().getCountpolicy().equals("S") ) {
							posCard = (new StorageCardAccessBean()).findBySerial(pos.getSerialnumber());
						} else if(pos.getResource().getCountpolicy().equals("P") ) {
							posCard = (new StorageCardAccessBean()).findByStorageOwnerParty( 
								new Integer(document.getFromKey().storageplace),
								new Integer(pos.getOwnerKey().organization), pos.getParty()
								);
						} else if(pos.getResource().getCountpolicy().equals("B") ) {
							posCard = (new StorageCardAccessBean()).findByStorageOwnerResource( 
								new Integer(document.getFromKey().storageplace),
								new Integer(pos.getOwnerKey().organization), 
								new Integer(pos.getResourceKey().resource)
								);
						}
						AgregateContentAccessBean link = (new AgregateContentAccessBean()).findAgregateAndPart(
							new Integer(agregateCard.getStoragecard()), new Integer(posCard.getStoragecard()) );
						if( !pos.getResource().getCountpolicy().equals("S") ) {
							if( link.getQty().compareTo(pos.getQty()) < 0 ) {
								ProcessingPositionError error = new ProcessingPositionError();
								error.setPositionCode( pos.getDocposition() );
								error.setErrorCode( ProcessingPositionError.ERRORS.BAD_AGREGATION_QTY );
								error.setQty(link.getQty());
								error.setMessage( "Bad agregation for docposition!" );
								System.out.println(">>>> APPLYDOC: Error code=" + error.getErrorCode() + 
									", pos=" + error.getPositionCode() + ", message=" + error.getMessage());
								exception.addError( error );
								agregateErrors.put( new Integer(pos.getDocposition()), error );
							}
						}						
					} catch( javax.ejb.ObjectNotFoundException e ) {
						ProcessingPositionError error = new ProcessingPositionError();
						error.setPositionCode( pos.getDocposition() );
						error.setErrorCode( ProcessingPositionError.ERRORS.BAD_AGREGATION );
						error.setMessage( "Bad agregation for docposition!" );
						System.out.println(">>>> APPLYDOC: Error code=" + error.getErrorCode() + 
							", pos=" + error.getPositionCode() + ", message=" + error.getMessage());
						exception.addError( error ); 											
						agregateErrors.put( new Integer(pos.getDocposition()), error );
					}
				}
			}
			
			//for every serial document position check its storagecard agregate parts.
			for( int i = 0; i < dPos.numberOfRows(); i++ ) {
				DocumentPositionAccessBean pos = dPos.getDocumentPositionAccessBean(i);
				if( pos.getResource().getCountpolicy().equals("S") ) {
					try {
						StorageCardAccessBean agregateCard = (new StorageCardAccessBean()).findBySerial( pos.getSerialnumber() );
						AgregateContentAccessBeanTable cardsTable = new AgregateContentAccessBeanTable();
						cardsTable.setAgregateContentAccessBean(agregateCard.getAgregateContent());
						DocumentPositionAccessBeanTable docsTable = new DocumentPositionAccessBeanTable();
						docsTable.setDocumentPositionAccessBean(pos.getAgregateParts());
						int oldSerialNumber = 0;
						for( int j = 0; j < dPos.numberOfRows(); j++ ) {
							if( dPos.getDocumentPositionAccessBean(j).getOldAgregateSerial() != null &&
								dPos.getDocumentPositionAccessBean(j).getOldAgregateSerial().equals(pos.getSerialnumber())) {
								oldSerialNumber++;
								}
						}
						if( cardsTable.numberOfRows() != (docsTable.numberOfRows()+oldSerialNumber) ) {
							ProcessingPositionError error = new ProcessingPositionError();
							error.setPositionCode( pos.getDocposition() );
							error.setErrorCode( ProcessingPositionError.ERRORS.BAD_AGREGATION );
							error.setMessage( "Bad agregation for docposition!" );
							System.out.println(">>>> APPLYDOC: Error code=" + error.getErrorCode() + 
								", pos=" + error.getPositionCode() + ", message=" + error.getMessage());
							exception.addError( error );											
							agregateErrors.put( new Integer(pos.getDocposition()), error );
						}
					} catch( javax.ejb.ObjectNotFoundException e ) {
						/*
						ProcessingPositionError error = new ProcessingPositionError();
						error.setPositionCode( pos.getDocposition() );
						error.setErrorCode( ProcessingPositionError.ERRORS.BAD_AGREGATION );
						error.setMessage( "Bad agregation for docposition!" );
						exception.addError( error );											
						agregateErrors.put( new Integer(pos.getDocposition()), error );
						*/
						// No such serial - skip position
					}
				}
			}
			
			//for every serial document position check whether it part by other agregate in cards
			for( int i = 0; i < dPos.numberOfRows(); i++ ) {
				DocumentPositionAccessBean pos = dPos.getDocumentPositionAccessBean(i);
				if( pos.getAgregate() == null && pos.getOldAgregateSerial() == null && pos.getSerialnumber() != null ) {
					try {
						StorageCardAccessBean posCard = (new StorageCardAccessBean()).findBySerial(pos.getSerialnumber());
						if( posCard.getAgregate().hasMoreElements() ) {
							ProcessingPositionError error = new ProcessingPositionError();
							error.setPositionCode( pos.getDocposition() );
							error.setErrorCode( ProcessingPositionError.ERRORS.BAD_AGREGATION );
							error.setMessage( "Bad agregation for docposition!" );
							System.out.println(">>>> APPLYDOC: Error code=" + error.getErrorCode() + 
								", pos=" + error.getPositionCode() + ", message=" + error.getMessage());
							exception.addError( error );											
							agregateErrors.put( new Integer(pos.getDocposition()), error );
						}
					} catch( javax.ejb.ObjectNotFoundException e ) {
						/*
						ProcessingPositionError error = new ProcessingPositionError();
						error.setPositionCode( pos.getDocposition() );
						error.setErrorCode( ProcessingPositionError.ERRORS.BAD_AGREGATION );
						error.setMessage( "Bad agregation for docposition!" );
						exception.addError( error );											
						agregateErrors.put( new Integer(pos.getDocposition()), error );
						*/
						// No such serial - skip position
					}
				}
			}			
		}	

		//process positions
		DocumentPositionAccessBeanTable positions = new DocumentPositionAccessBeanTable();
		positions.setDocumentPositionAccessBean( (new DocumentPositionAccessBean()).findByDocOrderByAgregateAsc(
			new Integer( document.getDocument() ) ) );
		//process agregates heads
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			DocumentPositionAccessBean position = positions.getDocumentPositionAccessBean( i );
			if( agregateErrors.get( new Integer(position.getDocposition()))!= null ) {
				continue;
			}
			if( position.getAgregateParts().hasMoreElements() ) {
				ProcessingPositionError error = applyDocPosition( document, position );
				if( error != null ) {
					error.setPositionCode(position.getDocposition());
					System.out.println(">>>> APPLYDOC: Error code=" + error.getErrorCode() + 
						", pos=" + error.getPositionCode() + ", message=" + error.getMessage());
					exception.addError( error );
				}
			}
		}
		//process agregates parts
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			DocumentPositionAccessBean position = positions.getDocumentPositionAccessBean( i );
			if( agregateErrors.get( new Integer(position.getDocposition()))!= null ) {
				continue;
			}			
			if( position.getAgregateParts().hasMoreElements() ) {
				continue;
			}
			if( position.getAgregate() != null && agregateErrors.get( new Integer(position.getAgregate().getDocposition()))!= null ) {
				continue;
			} 
			ProcessingPositionError error = applyDocPosition( document, position ); 
			if( error != null ) {
				error.setPositionCode(position.getDocposition());
				System.out.println(">>>> APPLYDOC: Error code=" + error.getErrorCode() + 
					", pos=" + error.getPositionCode() + ", message=" + error.getMessage());
				exception.addError( error );
			}
		}

			
		/////////////// DD ////////////////////////
		// Update document code
		exception.setDocument(argDoc.intValue());
		/////////////// DD ////////////////////////
		 
		//check for error and throw exception
		if( exception.getPositionErrors() != null && exception.getPositionErrors().size() != 0 )
			return exception;
	 
		//process document
		document.setDocumentState( "2" );
		document.commitCopyHelper();
		
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While applying document.", e );
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError cancelDocPosition(
    DocumentAccessBean document,
    DocumentPositionAccessBean position)
    throws java.rmi.RemoteException { 

	try {
		
		ProcessingPositionError error = null;

		//check i13n
		int i13nAct = checkForI13n( document, position );
		if( i13nAct != 0 ) {
			error = new ProcessingPositionError();
			error.setErrorCode( ProcessingPositionError.ERRORS.INVENTARIZATION_BEFORE );
			error.setMessage( "Inventarization restrict this operation act="+i13nAct );
			error.setI13nAct(i13nAct);
			return error;
		}		
		 
		if( position.getResource().getCountpolicy().equals( "S" ) ) {
			if( document.getProcessSource().booleanValue() && document.getProcessDestination().booleanValue() ) {
				System.out.println(">>>> Calling UNPSPFT");
				error = unProcessSerialPositionFromTo( document, position);
				if( error != null )
					return error;
			} else if( document.getProcessSource().booleanValue() && !document.getProcessDestination().booleanValue() ) {
				System.out.println(">>>> Calling UNPSPF");
				error = unProcessSerialPositionFrom( document, position);
				if( error != null )
					return error;
			} else if( !document.getProcessSource().booleanValue() && document.getProcessDestination().booleanValue() ) {
				System.out.println(">>>> Calling UNPSPT");
				error = unProcessSerialPositionTo( document, position);
				if( error != null )
					return error;
			} else if( !document.getProcessSource().booleanValue() && !document.getProcessDestination().booleanValue() ) {
			}
		} else {
			if( document.getProcessDestination().booleanValue() ) {
				System.out.println(">>>> Calling UNPNSPT");
				error = unPutNonSerialPositionTo( document, position );
				if( error != null )
					return error;
			}
			if( document.getProcessSource().booleanValue() ) {
				System.out.println(">>>> Calling UNGNSPF");
				error = unGetNonSerialPositionFrom( document, position );
				if( error != null )
					return error;
			}
		}
		
		return null;
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While canceling position", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 11:08:04)
 * @return java.util.Enumeration
 * @param docPosition java.lang.Integer
 */
public DocumentProcessingException cancelDocument( Integer argDoc ) 
	throws java.rmi.RemoteException  {
	try { 
		//getDocument
		DocumentAccessBean document = new DocumentAccessBean();
		document.setInitKey_document( argDoc.intValue() );
		document.refreshCopyHelper();

		DocumentProcessingException exception = new DocumentProcessingException();		
		
		//check Document State 
		if( !document.getDocumentState().equals( "2" ) ) {
			return new DocumentProcessingException( 1, "Incompatible state" );
		}
		
		//process positions
		DocumentPositionAccessBeanTable positions = new DocumentPositionAccessBeanTable();
		positions.setDocumentPositionAccessBean( (new DocumentPositionAccessBean()).findByDocOrderByAgregateDesc(
			new Integer( document.getDocument() ) ) );
		//process agregate parts
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			DocumentPositionAccessBean position = positions.getDocumentPositionAccessBean( i );
			if( position.getAgregate() != null ) {
				ProcessingPositionError error = cancelDocPosition( document, position );
				if( error != null ) {
					error.setPositionCode( position.getDocposition() );
					System.out.println(">>>> CANCELDOC: Error code=" + error.getErrorCode() + 
						", pos=" + error.getPositionCode() + ", message=" + error.getMessage());
					exception.addError( error );
				}
			}				
		}
		//process the rest
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			DocumentPositionAccessBean position = positions.getDocumentPositionAccessBean( i );
			if( position.getAgregate() != null ) {
				continue;
			}
			ProcessingPositionError error = cancelDocPosition( document, position );
			if( error != null ) {
				error.setPositionCode( position.getDocposition() );
				System.out.println(">>>> CANCELDOC: Error code=" + error.getErrorCode() + 
					", pos=" + error.getPositionCode() + ", message=" + error.getMessage());
				exception.addError( error );
			}
		}

		//check for errors an throw exception
		if( exception.getPositionErrors().size() != 0 )
			return exception;
	
		//process document
		document.setDocumentState( "1" );
		document.commitCopyHelper(); 
				
		return null;
		
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While cancelling document.", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 12:48:02)
 * @return int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception java.lang.Exception The exception description.
 */
private int checkForI13n( DocumentAccessBean document, DocumentPositionAccessBean position ) throws java.lang.Exception {
	//check full i13n
	try {
		if( document.getProcessSource().booleanValue() ) {
			I13nActAccessBean i13nAct = (new I13nActAccessBean()).findFullByStorageAfterDate( new Integer(document.getFromKey().storageplace), 
				document.getBlankdate(), 
				new Integer(document.getDocument()) ); 
			return i13nAct.getDocument();
		}
	} catch( javax.ejb.ObjectNotFoundException e ) {
	}
	try {
		if( document.getProcessDestination().booleanValue() ) {
			I13nActAccessBean i13nAct = (new I13nActAccessBean()).findFullByStorageAfterDate( new Integer(document.getToKey().storageplace), 
				document.getBlankdate(),
				new Integer(document.getDocument()) ); 
			return i13nAct.getDocument();
		}
	} catch( javax.ejb.ObjectNotFoundException e ) {
	}
	
	//check slice i13n
	try {
		if( document.getProcessSource().booleanValue() ) {
			I13nActAccessBean i13nAct = (new I13nActAccessBean()).findAssortimentByStorageProductAfterDate( 
				new Integer( document.getFromKey().storageplace ),
				new Integer( position.getResourceKey().resource ),
				document.getBlankdate(),
				new Integer(document.getDocument()) ); 
		return i13nAct.getDocument();
		}
	} catch( javax.ejb.ObjectNotFoundException e ) {
	}
	try {
		if( document.getProcessDestination().booleanValue() ) {
			I13nActAccessBean i13nAct = (new I13nActAccessBean()).findAssortimentByStorageProductAfterDate( 
				new Integer( document.getToKey().storageplace ),
				new Integer( position.getResourceKey().resource ),
				document.getBlankdate(),
				new Integer(document.getDocument()) ); 
			return i13nAct.getDocument();
		}
	} catch( javax.ejb.ObjectNotFoundException e ) {
	}
	
	//check agregate i13n
	try {
		if( position.getOldAgregateSerial() != null ) {
			I13nActAccessBean i13nAct = (new I13nActAccessBean()).findAgregateByStorageSerialAfterDate( 
				position.getOldAgregateSerial(),
				document.getBlankdate(),
				new Integer(document.getDocument()) ); 
			return i13nAct.getDocument();
		}
	} catch( javax.ejb.ObjectNotFoundException e ) {
	}
	try {
		if( position.getAgregateSerial() != null ) {
			I13nActAccessBean i13nAct = (new I13nActAccessBean()).findAgregateByStorageSerialAfterDate( 
				position.getAgregateSerial(),
				document.getBlankdate(),
				new Integer(document.getDocument()) ); 
			return i13nAct.getDocument();
		}
	} catch( javax.ejb.ObjectNotFoundException e ) {
	}

	
	return 0;
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
 * Creation date: (30.05.2002 15:28:45)
 * @param document java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public java.math.BigDecimal getDocumentSum(Integer argDocument) throws java.rmi.RemoteException {
	try {
		DocumentPositionAccessBeanTable positions = new DocumentPositionAccessBeanTable();
		positions.setDocumentPositionAccessBean( 
			(new DocumentPositionAccessBean()).findDocPositionsByDocOrderByOrderAsc( argDocument )
		);
		java.math.BigDecimal sum = new java.math.BigDecimal( 0 );
		for( int i = 0; i < positions.numberOfRows(); i++ )
			sum = sum.add( positions.getDocumentPositionAccessBean( i ).getSum() );
		return sum;
	} catch( Exception e ) {
		throw new java.rmi.RemoteException( "While getting document sum", e );
	}
}
/**
 * Subtracting non-serial position from storageplace.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError getNonSerialPositionFrom( DocumentAccessBean document, DocumentPositionAccessBean position) 
throws java.rmi.RemoteException {
	try { 
		
		Util.printDebug(">>>>> GNSPF: #1, position=" + position.getDocposition());
		ProcessingPositionError error = new ProcessingPositionError();
		StorageCardAccessBean card = null;

		try {
			if( position.getResource().getCountpolicy().equals( "P" ) ) {
				card =  (new StorageCardAccessBean()).findByStorageOwnerParty( new Integer(document.getFromKey().storageplace),
					new Integer( position.getOwner().getOrganization() ), position.getParty() ); 
			} else if( position.getResource().getCountpolicy().equals( "B" )) {
				card =  (new StorageCardAccessBean()).findByStorageOwnerResource( new Integer(document.getFromKey().storageplace),
					new Integer( position.getOwner().getOrganization() ), new Integer( position.getResource().getResource() ) );
			}
		} catch( javax.ejb.ObjectNotFoundException e ) {
			if( position.getParty() != null ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.NO_SUCH_PARTY );
				error.setMessage( "No source for party="+position.getParty() );
				error.setParty( position.getParty() );
			} else {
				error.setErrorCode( ProcessingPositionError.ERRORS.NOT_SUCH_PRODUCT );
				error.setMessage( "No source for product="+position.getResourceKey().resource );
			}
			error.setStorage( document.getFromKey().storageplace );
			error.setOwner( position.getOwner().getOrganization() );
			error.setResource( position.getResourceKey().resource );
			return error;
		}
		
		//must be the same resource
		if( card.getResourceKey().resource != position.getResourceKey().resource ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE );
			error.setMessage( "No resource is wrong resource="+card.getResourceKey().resource );
			error.setResource( card.getResourceKey().resource );
			if( position.getParty() != null )
				error.setParty( position.getParty() );
			return error;					
		}		
		
		//found!!!		
		
		//get from source and check for qty presence
		if( card.getQty().compareTo( position.getQty() ) < 0 ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOTENOUGHQTY );
			error.setMessage( "Not enough "+position.getQty() );
			error.setQty( card.getQty() );
			return error;
		}
		
		//check for broken qty
		if( position.getSourceBroken().booleanValue() && 
			(card.getQtyBroken()==null || card.getQtyBroken().compareTo( position.getQty() ) < 0 )) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOTENOUGHQTY );
			error.setMessage( "Not enough "+position.getQty() );
			error.setQty( card.getQtyBroken() );
			return error;
		}
		
		//check for other agregates qty
		if( position.getAgregate() == null && position.getOldAgregateSerial() == null ) {//check for agregates
			BigDecimal inAgregates = new BigDecimal( 0 );
			AgregateContentAccessBeanTable agr = new AgregateContentAccessBeanTable();
			agr.setAgregateContentAccessBean( 
				new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration( card.getAgregate(),
				//(new AgregateContentAccessBean() ).findAgregateByParts( new StorageCardKey(card.getStoragecard()) ), 
				AgregateContentAccessBean.class ) );
			for( int i = 0; i < agr.numberOfRows(); i++ ) {
				inAgregates = inAgregates.add( agr.getAgregateContentAccessBean(i).getQty() );
			}
			//System.out.println(">>>> GNSP #1, inAgregates sum = " + inAgregates + ", card qty=" + card.getQty() +
			//	", docpos qty=" + position.getQty());
			if( card.getQty().subtract( inAgregates ).compareTo( position.getQty() ) < 0 ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.NOTENOUGHQTY );
				error.setMessage( "Not enough "+position.getQty() );
				error.setQty( card.getQty().subtract( inAgregates ) );
				return error;
			}				
		}
		
		//subtract from source
		position.setPrice( card.getPrice() );
		if( position.getSourceBroken().booleanValue() ) { 
			card.setQtyBroken( card.getQtyBroken().subtract( position.getQty() ) );
		}
		if( card.getPolicy().equals( "B" ) ) {
			if( card.getQty().equals( position.getQty() ) ) {
				card.setPrice( new BigDecimal(0) );
			} else {
				card.setPrice( card.getPrice().multiply(card.getQty()).subtract(position.getPrice().multiply(position.getQty())).
					divide( card.getQty().subtract(position.getQty()), 
					java.math.BigDecimal.ROUND_HALF_UP ).setScale( 2, java.math.BigDecimal.ROUND_HALF_UP ) );
			}
		}
		card.setQty( card.getQty().subtract( position.getQty() ) );
		Util.printDebug(">>>>> GNSPF: #2");
		if( card.getQty().equals(new BigDecimal("0.000")) ) {
			Util.printDebug(">>>>> GNSPF: #3 - closing card");
			card.setClosed(Boolean.TRUE);
		} 
		card.commitCopyHelper(); 
		
		//process agregation
		DocumentPositionAccessBean agregate = position.getAgregate();
		StorageCardAccessBean agregateCard = null;
		if( agregate != null || position.getOldAgregateSerial() != null ) {//agregate
			//String serial = null;
			try {
				if( agregate != null ) {
					//serial = agregate.getSerialnumber();
					//if( agregate.getResultClosed().booleanValue() ) {
						//agregateCard =  (new StorageCardAccessBean()).findClosedBySerialInStorage( serial, 
							//new Integer( document.getFromKey().storageplace) );
					//} else { 
						//agregateCard =  (new StorageCardAccessBean()).findBySerial(serial);
					//}
					agregateCard = agregate.getCardFrom();
				} else {
					//serial = position.getOldAgregateSerial();
					agregateCard =  (new StorageCardAccessBean()).findBySerial(position.getOldAgregateSerial());
				}
				
				/////////////////////// DD ///////////////////////////
				// Check if agregate head in already in the FROM storage
				/*
				if (agregateCard.getCurrentstorageKey().storageplace != document.getFromKey().storageplace) {
					//////////////////////////////////
					error.setErrorCode( ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE );
					error.setMessage( "Tring moove card from other stirage serial="+ agregateCard.getSerialnumber());
					error.setSerial(agregateCard.getSerialnumber());
					error.setStorage( agregateCard.getCurrentstorage().getStorageplace() );
					return error;					
				}
				*/
				/////////////////////// DD ///////////////////////////
					
			} catch( javax.ejb.ObjectNotFoundException e ) {
				// DD - we must report NO_CARD here
				error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
				//error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
				error.setMessage( "No such serial="+position.getOldAgregateSerial() );
				error.setSerial(position.getOldAgregateSerial());
				return error; 
			}
			AgregateContentAccessBean link = 
				(new AgregateContentAccessBean() ).findAgregateAndPart( 
					new Integer( agregateCard.getStoragecard() ), 
					new Integer( card.getStoragecard() ) );
			if( link.getQty().equals(position.getQty() ) ) {	
				link.getEJBRef().remove();
			} else if( link.getQty().compareTo(position.getQty()) < 0 ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.NOTENOUGHQTY );
				error.setMessage( "Not enough "+position.getQty() );
				error.setQty( link.getQty() );
				return error;
			} else {
				link.setQty(link.getQty().subtract(position.getQty()));
				link.commitCopyHelper();			
			}
		}
		
		position.setCardFrom( (StorageCard)(card.getEJBRef()) );
		position.commitCopyHelper();
		
	} catch( Exception e ) {
		throw new RemoteException( "While processing document position (getNonSerialPositionFrom) ", e );
	}
	return null;
}
/**
 * getSessionContext method comment
 * @return javax.ejb.SessionContext
 */
public javax.ejb.SessionContext getSessionContext() {
	return mySessionCtx;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError processSerialPositionFrom( DocumentAccessBean document, 
	DocumentPositionAccessBean position ) 
	throws java.rmi.RemoteException {
	try { 
		ProcessingPositionError error = new ProcessingPositionError();
		StorageCardAccessBean card = null;
		
		//find card
		try {
			card = (new StorageCardAccessBean()).
				findBySerial( position.getSerialnumber() );
		} catch( javax.ejb.ObjectNotFoundException e ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
			error.setMessage( "No card for serial="+position.getSerialnumber() );
			error.setSerial( position.getSerialnumber() );
			return error;					
		}

		//must be the same resource
		if( card.getResourceKey().resource != position.getResourceKey().resource ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE );
			error.setMessage( "No resource is wrong resource="+card.getResourceKey().resource );
			error.setResource( card.getResourceKey().resource );
			error.setSerial(position.getSerialnumber());
			return error;					
		}
			
		//must be in the same storage
		if( card.getCurrentstorageKey().storageplace != document.getFromKey().storageplace ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
			error.setMessage( "Tring moove card from other stirage serial="+position.getSerialnumber() );
			error.setStorage( card.getCurrentstorageKey().storageplace );
			error.setSerial( position.getSerialnumber() );
			return error;
		}
		
		//must be the same property
		if( card.getOwnerKey().organization != position.getOwnerKey().organization ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_OWNER );
			error.setMessage( "Tring moove alias owner card serial="+position.getSerialnumber() );
			error.setOwner( card.getOwner().getOrganization() );
			throw new DocPositionProcessingException( error );
		}
		
		//must be the same property as document owner - except inventarization
		// directed by Gena 11.07.03
		// Check for inventarization
		boolean isInvent = false;
		if (document.getEJBRef() instanceof PayOffAct) {
			Enumeration en = new DocumentsLinkAccessBean().findByTypeAndDocTo( "P", new Integer( document.getDocument() ) );
			if (en.hasMoreElements())
				isInvent = true;
		}

		if (!isInvent) {
			if( card.getOwnerKey().organization != document.getOwnerKey().organization ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_DOC_OWNER );
				error.setMessage( "Trying to move alias owner card serial="+position.getSerialnumber() );
				error.setOwner( card.getOwner().getOrganization() );
				throw new DocPositionProcessingException( error );
			}
		}
		
		//must be in same state
		if( card.getBoxed().booleanValue() != position.getSourceBoxed().booleanValue() || 
			card.getBroken().booleanValue() != position.getSourceBroken().booleanValue() ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_STATE );
			error.setMessage( "Tryng moove card in different state serial="+position.getSerialnumber() );
			error.setCardBoxed( card.getBoxed() );
			error.setCardBroken( card.getBroken() );
			throw new DocPositionProcessingException( error );
		}

		//must not be documents later them this one
		if( card.getLastDocument().getBlankdate().after( document.getBlankdate() ) ) {
			System.out.println(">>>> PSPF: card.lastDocument=" + card.getLastDocumentKey().document +
				",lastdocdate=" + card.getLastDocument().getBlankdate() +
				", document=" + document.getDocument() +
				",docdate=" + document.getBlankdate()
				);
			error.setErrorCode( ProcessingPositionError.ERRORS.POSITION_HIDDEN );
			error.setMessage( "Position hidden with serial="+position.getSerialnumber() );
			error.setLastDocumentCode( card.getLastDocument().getDocument() );
			return error;										
		}
		
		//must not be boxed
		if( card.getBoxed().booleanValue() ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.CARD_IS_BOXED );
			error.setMessage( "Can't move boxed card." );
			return error;										
		}

		//found!!!
		
		
		position.setCardFrom( (StorageCard)(card.getEJBRef()) );
		position.setPrice( card.getPrice() );

		/////////// DD ///////////////////
		// For non-agregated serial positions or block mount/unmount - update place
		boolean isProcessPlace = ( (position.getOldAgregateSerial() != null) || (position.getAgregateSerial() != null) ) ||
			( (position.getOldAgregateSerial() == null) && (position.getAgregateSerial() == null) && (position.getAgregate() == null) );
		if( isProcessPlace ) {
			position.setOldplace(card.getPlace());
		}
		/////////// DD ///////////////////

		
		position.commitCopyHelper();

		//process card
		card.setLastDocument( (Document)(document.getEJBRef()) );
		card.setBoxed( position.getResultBoxed() ); 
		card.setBroken( position.getResultBroken() );
		card.setClosed( position.getResultClosed() );
		String oldConfiguration = null;
		if( position.getConfiguration() != null && position.getConfiguration().length() != 0 ) {
			oldConfiguration = card.getConfiguration();
			card.setConfiguration( position.getConfiguration() );
		}

		/////////// DD ///////////////////
		// Set new place in card
		if( isProcessPlace ) {
			card.setPlace(position.getNewplace());
		}
		/////////// DD ///////////////////
		
		card.commitCopyHelper();

		//process agregation
		if( position.getOldAgregateSerial() != null ) {
			StorageCardAccessBean agregateCard = null;
			try {
					agregateCard  = (new StorageCardAccessBean()).findBySerial(position.getOldAgregateSerial());
					
					/////////////////////// DD ///////////////////////////
					// Check if agregate head in already in the FROM storage
					/*
					if (agregateCard.getCurrentstorageKey().storageplace != document.getFromKey().storageplace) {
						//////////////////////////////////
						error.setErrorCode( ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE );
						error.setSerial(position.getOldAgregateSerial());
						error.setMessage( "Tring moove card from other stirage serial="+position.getOldAgregateSerial() );
						error.setStorage( agregateCard.getCurrentstorage().getStorageplace() );
						throw new DocPositionProcessingException( error );					
					}
					*/
					/////////////////////// DD ///////////////////////////
					
			} catch( javax.ejb.ObjectNotFoundException e ) {
				    // DD - Card not found - we must report NO_CARD here
					error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
					//error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
					error.setMessage( "No such serial="+position.getOldAgregateSerial() );
					error.setSerial(position.getOldAgregateSerial());
					throw new DocPositionProcessingException( error );
			}
			AgregateContentAccessBean content = null;
			try {
				content = 
					(new AgregateContentAccessBean()).findAgregateAndPart( new Integer(agregateCard.getStoragecard()),
						new Integer(card.getStoragecard()) );
			} catch( javax.ejb.ObjectNotFoundException e ) {
					error.setErrorCode( ProcessingPositionError.ERRORS.BAD_AGREGATION_NOTEXISTS );
					error.setMessage( "Position not in agregat. Agregate serial="+position.getOldAgregateSerial() );
					error.setSerial(position.getOldAgregateSerial());
					throw new DocPositionProcessingException( error );
			}
			content.getEJBRef().remove();
			}
		

		//add card track
		CardTrackAccessBean track = new CardTrackAccessBean( 
			(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.cardtracks" ),
			new Integer( card.getStoragecard() ), new Integer( document.getDocument() ), 
			new java.sql.Timestamp((new java.util.Date()).getTime()), "C" );
		track.setConfiguration( oldConfiguration );
		if( document.getFrom() != null )
			track.setFrom( (StoragePlace)(document.getFrom().getEJBRef()) );
		if( document.getTo() != null )
			track.setTo( (StoragePlace)(document.getTo().getEJBRef()) );
		track.commitCopyHelper();

		return null;
		
	} catch( DocPositionProcessingException e ) {
		return e.getError();
	} catch( Exception e ) {
		throw new RemoteException( "While processing document position (processSerialPositionFrom) ", e );
	}

}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError processSerialPositionFromTo( DocumentAccessBean document, 
	DocumentPositionAccessBean position ) 
	throws java.rmi.RemoteException {
	try { 
		ProcessingPositionError error = new ProcessingPositionError();
		StorageCardAccessBean card = null;
		
		//find card
		try {
			card = (new StorageCardAccessBean()). 
				findBySerial( position.getSerialnumber() );
		} catch( javax.ejb.ObjectNotFoundException e ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
			error.setMessage( "No card for serial="+position.getSerialnumber() );
			error.setSerial( position.getSerialnumber() );
			return error;					
		}


		//must be the same resource
		if( card.getResourceKey().resource != position.getResourceKey().resource ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE );
			error.setMessage( "No resource is wrong resource="+card.getResourceKey().resource );
			error.setResource( card.getResourceKey().resource );
			error.setSerial( position.getSerialnumber() );
			return error;					
		}	
			
		//must be in the same storage
		if( card.getCurrentstorageKey().storageplace != document.getFromKey().storageplace ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
			error.setMessage( "Tring moove card from other stirage serial="+position.getSerialnumber() );
			error.setStorage( card.getCurrentstorage().getStorageplace() );
			return error;
		}
		
		//must be the same property
		if( card.getOwnerKey().organization != position.getOwnerKey().organization ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_OWNER );
			error.setMessage( "Tring moove alias owner card serial="+position.getSerialnumber() );
			error.setOwner( card.getOwner().getOrganization() );
			throw new DocPositionProcessingException( error );
		}
		 
		//must be in same state
		if( card.getBoxed().booleanValue() != position.getSourceBoxed().booleanValue() || 
			card.getBroken().booleanValue() != position.getSourceBroken().booleanValue() ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_STATE );
			error.setMessage( "Tryng moove card in different state serial="+position.getSerialnumber() );
			error.setCardBoxed( card.getBoxed() );
			error.setCardBroken( card.getBroken() );
			throw new DocPositionProcessingException( error );
		}

		//must not be documents later them this one
		if( card.getLastDocument() != null && card.getLastDocument().getBlankdate().after( document.getBlankdate() ) ) {
			System.out.println(">>>> PSPFT: card.lastDocument=" + card.getLastDocumentKey().document +
				",lastdocdate=" + card.getLastDocument().getBlankdate() +
				", document=" + document.getDocument() +
				",docdate=" + document.getBlankdate()
				);
			error.setErrorCode( ProcessingPositionError.ERRORS.POSITION_HIDDEN );
			error.setMessage( "Position hidden with serial="+position.getSerialnumber() );
			error.setLastDocumentCode( card.getLastDocument().getDocument() );
			return error;										
		}

		//must not be boxed
		if( card.getBoxed().booleanValue() ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.CARD_IS_BOXED );
			error.setMessage( "Can't move boxed card." );
			return error;										
		}

		//found!!!
		

		//process position	
		position.setCardFrom( (StorageCard)(card.getEJBRef()) );
		position.setCardTo( (StorageCard)(card.getEJBRef()) );
		position.setPrice( card.getPrice() );

		
		/////////// DD ///////////////////
		// For non-agregated serial positions or block mount/unmount - update place
		boolean isProcessPlace = ( (position.getOldAgregateSerial() != null) || (position.getAgregateSerial() != null) ) ||
			( (position.getOldAgregateSerial() == null) && (position.getAgregateSerial() == null) && (position.getAgregate() == null) );
		if( isProcessPlace ) {
			position.setOldplace(card.getPlace());
		}
		/////////// DD ///////////////////

		
		position.commitCopyHelper();

		//process card
		card.setLastDocument( (Document)(document.getEJBRef()) );
		card.setBoxed( position.getResultBoxed() ); 
		card.setBroken( position.getResultBroken() );
		card.setClosed( position.getResultClosed() );
		if( position.getNotes() != null && position.getNotes().length() != 0 ) {
			card.setNotes(position.getNotes());
		}


		/////////// DD ///////////////////
		// Set new place in card
		if( isProcessPlace ) {
			card.setPlace(position.getNewplace());
		}
		/////////// DD ///////////////////
		
		
		//change location
		StoragePlaceAccessBean storage = new StoragePlaceAccessBean();
		storage.setInitKey_storageplace( document.getToKey().storageplace );
		storage.refreshCopyHelper();
		card.setCurrentstorage( (StoragePlace)(storage.getEJBRef()) );
		String oldConfiguration = null;
		if( position.getConfiguration() != null && position.getConfiguration().length() != 0 ) {
			oldConfiguration = card.getConfiguration();
			card.setConfiguration( position.getConfiguration() );
		}
		card.commitCopyHelper();

		//process agregation - subtract
		if( position.getOldAgregateSerial() != null ) {
			StorageCardAccessBean agregateCard = null;
			try {
					agregateCard  = (new StorageCardAccessBean()).findBySerial(position.getOldAgregateSerial());
					
					/////////////////////// DD ///////////////////////////
					// Check if agregate head in already in the FROM storage
					/*
					if (agregateCard.getCurrentstorageKey().storageplace != document.getFromKey().storageplace) {
						//////////////////////////////////
						error.setErrorCode( ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE );
						error.setSerial(position.getOldAgregateSerial());
						error.setMessage( "Tring moove card from other stirage serial="+position.getOldAgregateSerial() );
						error.setStorage( agregateCard.getCurrentstorage().getStorageplace() );
						throw new DocPositionProcessingException( error );					
					}
					*/
					/////////////////////// DD ///////////////////////////
					
			} catch( javax.ejb.ObjectNotFoundException e ) {
				    //////// DD /////////////////
				    // Its wrong to report NOT_IN_STORAGE here
					//error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
					error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
					error.setMessage( "No such serial="+position.getOldAgregateSerial() );
					error.setSerial(position.getOldAgregateSerial());
					throw new DocPositionProcessingException( error );
			}
			AgregateContentAccessBean content = null;
			try {
				content = 
					(new AgregateContentAccessBean()).findAgregateAndPart( new Integer(agregateCard.getStoragecard()),
						new Integer(card.getStoragecard()) );
			} catch( javax.ejb.ObjectNotFoundException e ) {
					error.setErrorCode( ProcessingPositionError.ERRORS.BAD_AGREGATION_NOTEXISTS );
					error.setMessage( "Position not in agregat. Agregate serial="+position.getOldAgregateSerial() );
					error.setSerial(position.getOldAgregateSerial());
					throw new DocPositionProcessingException( error );
			}
			content.getEJBRef().remove();
		}
		//process agregation - add
		if( position.getAgregateSerial() != null ) {
			StorageCardAccessBean agregateCard = null;
			try {
				agregateCard = card.findBySerial( position.getAgregateSerial() );

				/////////////////////// DD ///////////////////////////
				// Check if agregate head in already in the TO storage
				/*
				if (agregateCard.getCurrentstorageKey().storageplace != document.getToKey().storageplace) {
					//////////////////////////////////
					error.setErrorCode( ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE );
					error.setSerial(position.getAgregateSerial());
					error.setMessage( "Tring moove card from other stirage serial="+position.getAgregateSerial() );
					error.setStorage( agregateCard.getCurrentstorage().getStorageplace() );
					throw new DocPositionProcessingException( error );					
				}
				*/
				/////////////////////// DD ///////////////////////////
				
				try	{
					new AgregateContentAccessBean( 
						new Integer( agregateCard.getStoragecard() ), 
						new Integer( card.getStoragecard() ), new java.math.BigDecimal(1) );
				} catch( Exception e ) {
					error.setErrorCode( ProcessingPositionError.ERRORS.CARD_ALREADY_BOUND );
					error.setMessage( "Position already bound to agregate." );
					error.setSerial(position.getAgregateSerial());
					throw new DocPositionProcessingException( error );					
				}
			} catch( javax.ejb.ObjectNotFoundException e ) {
					// DD - we must report NO_CARD here
					error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
					//error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
					error.setMessage( "No such serial="+position.getAgregateSerial() );
					error.setSerial(position.getAgregateSerial());
					throw new DocPositionProcessingException( error );
			}
		}

		//add card track
		CardTrackAccessBean track = new CardTrackAccessBean( 
			(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.cardtracks" ),
			new Integer( card.getStoragecard() ), new Integer( document.getDocument() ), 
			new java.sql.Timestamp((new java.util.Date()).getTime()), "M" );
		track.setConfiguration( oldConfiguration );
		if( document.getFrom() != null )
			track.setFrom( (StoragePlace)(document.getFrom().getEJBRef()) );
		if( document.getTo() != null )
			track.setTo( (StoragePlace)(document.getTo().getEJBRef()) );
		track.commitCopyHelper();

		return null;
		
	} catch( DocPositionProcessingException e ) {
		return e.getError(); 
	} catch( Exception e ) {
		throw new RemoteException( "Whle processing document position (processSerialPositionFromTo)", e );
	}

}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError processSerialPositionTo( DocumentAccessBean document, 
	DocumentPositionAccessBean position ) 
	throws java.rmi.RemoteException {
	try { 
		ProcessingPositionError error = new ProcessingPositionError();
		StorageCardAccessBean card = null;

		//find card
		if( !position.getResultBoxed().booleanValue() ) {
			boolean here = true;
			try {
			card = (new StorageCardAccessBean()).
				findBySerial( position.getSerialnumber() );
			} catch( javax.ejb.ObjectNotFoundException e ) {
				//it already here!
				here = false;
			}
			if( here && !card.getClosed().booleanValue() ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.CARD_ALREADY_EXISTS );
				error.setMessage( "Card for serial already is in database serial="+position.getSerialnumber() );
				error.setSerial( position.getSerialnumber() );
				return error;					
			}		
		}
		card = new StorageCardAccessBean( 
			(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.storagecards" ), 
			new Integer( position.getResourceKey().resource ), document.getBlankdate(), 
			new Integer( position.getOwner().getOrganization() ),
			position.getResource().getCountpolicy(), Boolean.FALSE, position.getQty(), position.getPrice() );

		
		/////////// DD ///////////////////
		// For non-agregated serial positions or block mount/unmount - update place
		boolean isProcessPlace = ( (position.getOldAgregateSerial() != null) || (position.getAgregateSerial() != null) ) ||
			( (position.getOldAgregateSerial() == null) && (position.getAgregateSerial() == null) && (position.getAgregate() == null) );
		if( isProcessPlace ) {
			position.setOldplace(card.getPlace());
		}
		/////////// DD ///////////////////
			
		card.setSerialnumber( position.getSerialnumber() );

		//process card
		card.setLastDocument( (Document)(document.getEJBRef()) );
		card.setBoxed( position.getResultBoxed() ); 
		card.setBroken( position.getResultBroken() );
		card.setClosed( position.getResultClosed() );
		card.setManufserial(position.getManufserial());
		if( position.getNotes() != null && position.getNotes().length() != 0 ) {
			card.setNotes(position.getNotes());
		}
		

		//set location
		StoragePlaceAccessBean storage = new StoragePlaceAccessBean();
		storage.setInitKey_storageplace( document.getToKey().storageplace );
		storage.refreshCopyHelper();
		card.setCurrentstorage( (StoragePlace)(storage.getEJBRef()) );
		String oldConfiguration = null;
		if( position.getConfiguration() != null && position.getConfiguration().length() != 0 ) {
			oldConfiguration = card.getConfiguration();
			card.setConfiguration( position.getConfiguration() );
		}
		
		/////////// DD ///////////////////
		// Set new place in card
		if( isProcessPlace ) {
			card.setPlace(position.getNewplace());
		}
		/////////// DD ///////////////////
		
		card.commitCopyHelper();

		//process agregation
		if( position.getAgregate() != null ) {
			new AgregateContentAccessBean( 
				new Integer( position.getAgregate().getCardToKey().storagecard ), 
				new Integer(card.getStoragecard()), new java.math.BigDecimal(1) );
		} else if( position.getAgregateSerial() != null ) {
			StorageCardAccessBean agregateCard = null;
			try {
				agregateCard = card.findBySerial( position.getAgregateSerial() );
				
				/////////////////////// DD ///////////////////////////
				// Check if agregate head in already in the TO storage
				/*
				if (agregateCard.getCurrentstorageKey().storageplace != document.getToKey().storageplace) {
					//////////////////////////////////
					error.setErrorCode( ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE );
					error.setMessage( "Tring moove card from other stirage serial="+position.getAgregateSerial() );
					error.setSerial(position.getAgregateSerial());
					error.setStorage( agregateCard.getCurrentstorage().getStorageplace() );
					throw new DocPositionProcessingException( error );					
				}
				*/
				/////////////////////// DD ///////////////////////////
				
				try	{
					new AgregateContentAccessBean( 
						new Integer( agregateCard.getStoragecard() ), 
						new Integer( card.getStoragecard() ), new java.math.BigDecimal(1) );
				} catch( Exception e ) {
					error.setErrorCode( ProcessingPositionError.ERRORS.CARD_ALREADY_BOUND );
					error.setMessage( "Position already bound to agregate." );
					error.setSerial(position.getAgregateSerial());
					return error;					
				}
			} catch( javax.ejb.ObjectNotFoundException e ) {
					// DD - we must report NO_CARD here
					error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
					//error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
					error.setMessage( "No such serial="+position.getAgregateSerial() );
					error.setSerial(position.getAgregateSerial());
					return error;
			}
		}
		

		//add card track
		CardTrackAccessBean track = new CardTrackAccessBean( 
			(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.cardtracks" ),
			new Integer( card.getStoragecard() ), new Integer( document.getDocument() ), 
			new java.sql.Timestamp((new java.util.Date()).getTime()), "O" );
		track.setConfiguration( oldConfiguration );
		if( document.getFrom() != null )
			track.setFrom( (StoragePlace)(document.getFrom().getEJBRef()) );
		if( document.getTo() != null )
			track.setTo( (StoragePlace)(document.getTo().getEJBRef()) );
		track.commitCopyHelper();

		//change position
		position.setCardTo( (StorageCard)(card.getEJBRef()) );

		
		position.commitCopyHelper();
		
		return null;
		
	} catch( Exception e ) {
		throw new RemoteException( "Whle processing document position (processSerialPositionTo)", e );
	}

}
/**
 * Adding non-serial position to storageplace.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError putNonSerialPositionTo( DocumentAccessBean document, DocumentPositionAccessBean position) 
throws java.rmi.RemoteException {
	try { 
		ProcessingPositionError error = new ProcessingPositionError();
			
		//process in mooving for parties
		StorageCardAccessBean targetCard = null;

		System.out.println(">>>>> PNSPT: #1");
		try {
			if( position.getResource().getCountpolicy().equals( "P" ) ) {
				System.out.println(">>>>> PNSPT: #2");
				targetCard =  context.getPartyCard( position.getParty(), 
					document.getToKey().storageplace, position.getOwnerKey().organization );
			} else if(position.getResource().getCountpolicy().equals( "B" )) {
				System.out.println(">>>>> PNSPT: #3");
				targetCard =  context.getBulkCard( position.getResourceKey().resource, document.getToKey().storageplace, 
					position.getOwnerKey().organization );
			}
			System.out.println(">>>>> PNSPT: #4");
			//must be the same resource
			if( targetCard.getResourceKey().resource != position.getResourceKey().resource ) {
				System.out.println(">>>>> PNSPT: #5");
				// DD if closed card not exactly the same - create new card
				if ((targetCard.getClosed() != null) && targetCard.getClosed().booleanValue())
					throw new javax.ejb.ObjectNotFoundException();
				System.out.println(">>>>> PNSPT: #5.1");
				error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE );
				error.setMessage( "No resource is wrong resource="+targetCard.getResourceKey().resource );
				error.setResource( targetCard.getResourceKey().resource );
				if (position.getParty() != null)
					error.setParty(position.getParty());
				return error;					
			}
						
			//process card
			System.out.println(">>>>> PNSPT: #6");
			if(targetCard.getPolicy().equals("P")) {
				System.out.println(">>>>> PNSPT: #7");
				if( !position.getPrice().equals(targetCard.getPrice()) ) {
					// DD if closed card not exactly the same - create new card
					if ((targetCard.getClosed() != null) && targetCard.getClosed().booleanValue())
						throw new javax.ejb.ObjectNotFoundException();
					error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_PRICE );
					error.setMessage( "Not the same price for incoming party price"+targetCard.getPrice() );
					error.setPrice(targetCard.getPrice());
					return error;
				}
			} else {
				java.math.BigDecimal newPrice = targetCard.getPrice().multiply(targetCard.getQty()).add(position.getPrice().multiply(position.getQty())).
					divide( targetCard.getQty().add(position.getQty() ), java.math.BigDecimal.ROUND_HALF_UP ).setScale( 2, java.math.BigDecimal.ROUND_HALF_UP );
				targetCard.setPrice(newPrice);
				System.out.println(">>>>> PNSPT: #8, new price=" + newPrice);
			}
			java.math.BigDecimal newQty = targetCard.getQty().add( position.getQty() );
			System.out.println(">>>>> PNSPT: #9, new qty=" + newQty);
			targetCard.setQty( newQty );
			
		} catch( javax.ejb.ObjectNotFoundException e ) {
			System.out.println(">>>>> PNSPT: #10");
			targetCard = new StorageCardAccessBean( 
				(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.storagecards" ), 
				new Integer( position.getResourceKey().resource ), 
				document.getBlankdate(), new Integer( position.getOwnerKey().organization ), 
				position.getResource().getCountpolicy(), Boolean.FALSE, position.getQty(), 
				position.getPrice() );
			System.out.println(">>>>> PNSPT: #11");
			targetCard.setCurrentstorage((StoragePlace)(document.getTo().getEJBRef()));
			System.out.println(">>>>> PNSPT: #12");
			if(position.getResource().getCountpolicy().equals( "P" )) {
				targetCard.setParty( position.getParty() );
			}
		}
				
		System.out.println(">>>>> PNSPT: #13");
		if( position.getResultBroken().booleanValue() ) {
			targetCard.setQtyBroken( (targetCard.getQtyBroken()==null)? position.getQty(): 
				targetCard.getQtyBroken().add( position.getQty() ) );
		}

		System.out.println(">>>>> PNSPT: #14");
		targetCard.setClosed( Boolean.FALSE );
		targetCard.commitCopyHelper();
		System.out.println(">>>>> PNSPT: #15");
		context.registerStorageCard( targetCard );
		System.out.println(">>>>> PNSPT: #16");

		//process agregation
		if( position.getAgregate() != null || position.getAgregateSerial() != null ) {
			//agregate
			StorageCardAccessBean agregateCard = null;
			if( position.getAgregate() != null ) {
				agregateCard = position.getAgregate().getCardTo();  
			} else {
				try {
					agregateCard = (new StorageCardAccessBean()).findBySerial( position.getAgregateSerial() );
				} catch( javax.ejb.ObjectNotFoundException e ) {
					// We must report NO_CARD here
					error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
					//error.setErrorCode( ProcessingPositionError.ERRORS.NOT_IN_STORAGE );
					error.setMessage( "No such serial="+position.getAgregateSerial() );
					error.setSerial(position.getAgregateSerial());
					return error;
				}
			}
			
			/////////////////////// DD ///////////////////////////
			// Check if agregate head in already in the TO storage
			/*
			if (agregateCard.getCurrentstorageKey().storageplace != document.getToKey().storageplace) {
				//////////////////////////////////
				error.setErrorCode( ProcessingPositionError.ERRORS.HEAD_NOT_IN_STORAGE );
				error.setMessage( "Tring moove card from other stirage serial="+ agregateCard.getSerialnumber() );
				error.setSerial(agregateCard.getSerialnumber());
				error.setStorage( agregateCard.getCurrentstorage().getStorageplace() );
				return error;					
			}
			*/
			/////////////////////// DD ///////////////////////////
			
			try {
				AgregateContentAccessBean link = (new AgregateContentAccessBean()).findAgregateAndPart(
					new Integer(agregateCard.getStoragecard()), new Integer(targetCard.getStoragecard()) );
				link.setQty(link.getQty().add(position.getQty()));
				link.commitCopyHelper();
			} catch( javax.ejb.ObjectNotFoundException e ) {
				new AgregateContentAccessBean( new Integer( agregateCard.getStoragecard() ), 
					new Integer(targetCard.getStoragecard()), position.getQty() );
			}
		}

		//process position
		System.out.println(">>>>> PNSPT: #17");
		position.setCardTo( (StorageCard)(targetCard.getEJBRef()) );
		System.out.println(">>>>> PNSPT: #18");
		position.commitCopyHelper();			
		System.out.println(">>>>> PNSPT: #19");
	} catch( Exception e ) { 
		throw new RemoteException( "Whle processing document position (putNonSerialPositionTo)", e );
	}

	return null;
}
/**
 * setSessionContext method comment
 * @param ctx javax.ejb.SessionContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setSessionContext(javax.ejb.SessionContext ctx) throws java.rmi.RemoteException {
	mySessionCtx = ctx;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError unGetNonSerialPositionFrom( DocumentAccessBean document, DocumentPositionAccessBean position) 
throws java.rmi.RemoteException {
	try { 
		ProcessingPositionError error = new ProcessingPositionError();
			
		//process in mooving for parties
		StorageCardAccessBean targetCard = null;

		try {	
			if( position.getResource().getCountpolicy().equals( "P" ) ) {
				targetCard =  (new StorageCardAccessBean()).findByStorageOwnerParty( new Integer(document.getFromKey().storageplace),
					new Integer( position.getOwner().getOrganization() ), position.getParty() ); 
			} else if(position.getResource().getCountpolicy().equals( "B" )) {
				targetCard =  (new StorageCardAccessBean()).findByStorageOwnerResource( new Integer(document.getFromKey().storageplace),
					new Integer( position.getOwner().getOrganization() ), new Integer( position.getResource().getResource() ) );
			}
			
			//must be the same resource
			if( targetCard.getResourceKey().resource != position.getResourceKey().resource ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE );
				error.setMessage( "No resource is wrong resource="+targetCard.getResourceKey().resource );
				error.setResource( targetCard.getResourceKey().resource );
				if (position.getParty() != null)
					error.setParty(position.getParty());
				return error;					
			}
			
			//process card
			targetCard.setPrice( (targetCard.getPolicy().equals("P"))? position.getPrice(): 
				targetCard.getPrice().multiply(targetCard.getQty()).add(position.getPrice().multiply(position.getQty())).
				divide( targetCard.getQty().add(position.getQty() ), 
				java.math.BigDecimal.ROUND_HALF_DOWN ).setScale( 2, java.math.BigDecimal.ROUND_HALF_DOWN ) );
			targetCard.setQty( targetCard.getQty().add( position.getQty() ) );
			targetCard.setClosed(Boolean.FALSE); // Be sure that card is opened
			
		} catch( javax.ejb.ObjectNotFoundException e ) {
			targetCard = new StorageCardAccessBean( 
				(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.storagecards" ), 
				new Integer( position.getResourceKey().resource ), 
				document.getBlankdate(), new Integer( position.getOwnerKey().organization ), 
				position.getResource().getCountpolicy(), Boolean.FALSE, position.getQty(), 
				position.getPrice() );
			targetCard.setCurrentstorage((StoragePlace)(document.getFrom().getEJBRef()));
			if(position.getResource().getCountpolicy().equals( "P" )) {
				targetCard.setParty( position.getParty() );
			}			
		}
		
		if( position.getSourceBroken().booleanValue() ) {
			targetCard.setQtyBroken( targetCard.getQtyBroken().add( position.getQty() ) );
		}
		
		targetCard.commitCopyHelper();

		//process agregation (create old agregate links again)
		if( position.getAgregate() != null || position.getOldAgregateSerial() != null ) {
			StorageCardAccessBean agregateCard = null;
			if( position.getAgregate() != null ) {
				if( position.getAgregate().getResultClosed().booleanValue() ) {
					agregateCard =  (new StorageCardAccessBean()).findClosedBySerialInStorage( 
						position.getAgregate().getSerialnumber(), 
						new Integer( document.getFromKey().storageplace) );
				} else {
					agregateCard = 
						(new StorageCardAccessBean()).findBySerial( position.getAgregate().getSerialnumber() );
				}
			} else {
				agregateCard = 
					(new StorageCardAccessBean()).findBySerial( position.getOldAgregateSerial() );
			}
			try {
				AgregateContentAccessBean link = (new AgregateContentAccessBean()).findAgregateAndPart(
					new Integer(agregateCard.getStoragecard()), new Integer(targetCard.getStoragecard()) );
				link.setQty(link.getQty().add(position.getQty()));
				link.commitCopyHelper();
			} catch( javax.ejb.ObjectNotFoundException e ) {
				new AgregateContentAccessBean( new Integer( agregateCard.getStoragecard() ), 
					new Integer(targetCard.getStoragecard()), position.getQty() );
			}
		} 


		//position
		position.setCardTo( null );
		position.setCardFrom( null );
		position.commitCopyHelper();
		
	} catch( Exception e ) {
		throw new RemoteException( "Whle processing document position (unGetNonSerialPositionFrom)", e );
	}

	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError unProcessSerialPositionFrom( DocumentAccessBean document, 
	DocumentPositionAccessBean position ) 
	throws java.rmi.RemoteException {
	try { 
		ProcessingPositionError error = new ProcessingPositionError();
		StorageCardAccessBean card = null;

		//find card
		card = position.getCardFrom();
		card.refreshCopyHelper();
 
		//check for latest documents
		if( card.getLastDocumentKey().document != document.getDocument() ) {
			
			System.out.println(">>>> UNPSPF: card.lastDocument=" + card.getLastDocumentKey().document +
				", document=" + document.getDocument());
			
			error.setErrorCode( ProcessingPositionError.ERRORS.POSITION_HIDDEN );
			error.setMessage( "Position hidden with serial="+position.getSerialnumber() );
//			error.setPosition( position );
			error.setLastDocumentCode( card.getLastDocumentKey().document );
			return error;										
		}
		
		//found!!!				
		
		//change state & set document 
		CardTrackAccessBean track = null;
		try { 
			track = (new CardTrackAccessBean()).findBeforeDocument( new Integer( card.getStoragecard() ), 
			new Integer( document.getDocument() ) );
			card.setLastDocument( (Document)(track.getDocument().getEJBRef()) );
			if( position.getConfiguration() != null && position.getConfiguration().length() != 0 )
				card.setConfiguration( track.getConfiguration() );
		} catch( javax.ejb.ObjectNotFoundException e ) {
			card.setLastDocument( null );
		}
		card.setBoxed( position.getSourceBoxed() );
		card.setBroken( position.getSourceBroken() );
		card.setClosed( position.getSourceClosed() );

		/////////// DD ///////////////////
		// For non-agregated serial positions or block mount/unmount - update place
		boolean isProcessPlace = ( (position.getOldAgregateSerial() != null) || (position.getAgregateSerial() != null) ) ||
			( (position.getOldAgregateSerial() == null) && (position.getAgregateSerial() == null) && (position.getAgregate() == null) );
		if( isProcessPlace ) {
			card.setPlace(position.getOldplace());
		}
		/////////// DD ///////////////////
		
		card.commitCopyHelper();

		//process agregation
		if( position.getOldAgregateSerial() != null ) {
			try {
				StorageCardAccessBean agregateCard  = 
					(new StorageCardAccessBean()).findBySerial(position.getOldAgregateSerial());
					new AgregateContentAccessBean( new Integer(agregateCard.getStoragecard()),
						new Integer(card.getStoragecard()), new java.math.BigDecimal(1) );
			} catch( javax.ejb.ObjectNotFoundException e ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
				error.setMessage( "No card with serial ="+position.getOldAgregateSerial() );
				error.setSerial(position.getOldAgregateSerial());
				return error;										
			}
		}
		

		
		//remove track record
		track = (new CardTrackAccessBean()).findLastDocumentTrack( new Integer(card.getStoragecard()),
				new Integer( document.getDocument() ) );
		track.getEJBRef().remove();		

		//change position from to
		position.setCardFrom( null );
		position.commitCopyHelper();

		return null;
					
	} catch( Exception e ) {
		throw new RemoteException( "Whle processing document position (unProcessSerialPositionFrom)", e );
	}

}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError unProcessSerialPositionFromTo( DocumentAccessBean document, 
	DocumentPositionAccessBean position ) 
	throws java.rmi.RemoteException {
	try { 
		ProcessingPositionError error = new ProcessingPositionError();
		StorageCardAccessBean card = null;

		//find card
		card = position.getCardTo();
		card.refreshCopyHelper();

		//check for latest documents
		if( card.getLastDocumentKey().document != document.getDocument() ) {
			System.out.println(">>>> UNPSPFT: card.lastDocument=" + card.getLastDocumentKey().document +
				", document=" + document.getDocument());
			error.setErrorCode( ProcessingPositionError.ERRORS.POSITION_HIDDEN );
			error.setMessage( "Position hidden with serial="+position.getSerialnumber() );
			error.setLastDocumentCode( card.getLastDocumentKey().document );
			return error;										
		}
		
		//found!!!				
		
		//change state & set document
		CardTrackAccessBean track = null;
		try {
			track = 
				(new CardTrackAccessBean()).findBeforeDocument( new Integer(card.getStoragecard()), 
				new Integer( document.getDocument() ) );
			card.setLastDocument( (Document)(track.getDocument().getEJBRef()) );
			if( position.getConfiguration() != null && position.getConfiguration().length() != 0 )
				card.setConfiguration( track.getConfiguration() );
		} catch( javax.ejb.ObjectNotFoundException e ) {
			card.setLastDocument( null );
			}
		card.setBoxed( position.getSourceBoxed() );
		card.setBroken( position.getSourceBroken() );
		card.setClosed( position.getSourceClosed() );
		card.setCurrentstorage( (StoragePlace)(document.getFrom().getEJBRef()) );
		
		/////////// DD ///////////////////
		// For non-agregated serial positions or block mount/unmount - update place
		boolean isProcessPlace = ( (position.getOldAgregateSerial() != null) || (position.getAgregateSerial() != null) ) ||
			( (position.getOldAgregateSerial() == null) && (position.getAgregateSerial() == null) && (position.getAgregate() == null) );
		if( isProcessPlace ) {
			card.setPlace(position.getOldplace());
		}
		/////////// DD ///////////////////

			
		card.commitCopyHelper();

		//process agregation
		//process agregation - subtract
		if( position.getAgregateSerial() != null ) {
			StorageCardAccessBean agregateCard  = 
				(new StorageCardAccessBean()).findBySerial(position.getAgregateSerial());
			AgregateContentAccessBean content = 
				(new AgregateContentAccessBean()).findAgregateAndPart( new Integer(agregateCard.getStoragecard()),
					new Integer(card.getStoragecard()) );
			content.getEJBRef().remove();
		}
		//process agregation - add
		if( position.getOldAgregateSerial() != null ) {
			try {
				new AgregateContentAccessBean( 
					new Integer(card.findBySerial( position.getOldAgregateSerial() ).getStoragecard() ), 
					new Integer(card.getStoragecard()), new java.math.BigDecimal(1) );
			} catch( javax.ejb.ObjectNotFoundException e ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
				error.setMessage( "No card with serial ="+position.getOldAgregateSerial() );
				error.setSerial(position.getOldAgregateSerial());
				return error;										
			}
		}
		
		
		//remove track record 
		track = (new CardTrackAccessBean()).findLastDocumentTrack( new Integer(card.getStoragecard()),
				new Integer( document.getDocument() ) );
		track.getEJBRef().remove();

		//change position from to
		position.setCardFrom( null ); 
		position.setCardTo( null );
		position.commitCopyHelper();

		return null;
		
	} catch( Exception e ) {
		throw new RemoteException( "Whle processing document position (unProcessSerialPositionFromTo)", e );
	}

}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError unProcessSerialPositionTo( DocumentAccessBean document, 
	DocumentPositionAccessBean position ) 
	throws java.rmi.RemoteException {
	try { 
		ProcessingPositionError error = new ProcessingPositionError();
		StorageCardAccessBean card = null;

		//find card
		card = position.getCardTo();
		card.refreshCopyHelper();

		//check for latest documents
		if( card.getLastDocumentKey().document != document.getDocument() ) {
			System.out.println(">>>> UNPSPF: card.lastDocument=" + card.getLastDocumentKey().document +
				", document=" + document.getDocument());
			error.setErrorCode( ProcessingPositionError.ERRORS.POSITION_HIDDEN );
			error.setMessage( "Position hidden with serial="+position.getSerialnumber() );
			error.setLastDocumentCode( card.getLastDocumentKey().document );
			return error;										
		}
		 
		//found!!!		 		
		
		/////////// DD ///////////////////
		// For non-agregated serial positions or block mount/unmount - update place
		boolean isProcessPlace = ( (position.getOldAgregateSerial() != null) || (position.getAgregateSerial() != null) ) ||
			( (position.getOldAgregateSerial() == null) && (position.getAgregateSerial() == null) && (position.getAgregate() == null) );
		if( isProcessPlace ) {
			card.setPlace(position.getOldplace());
		}
		/////////// DD ///////////////////
		
		//change position from to
		position.setCardTo( null );
		position.commitCopyHelper();
		//clearCardFromDocposition( position );
		//card.secondaryRemoveInDocumentPosition(((DocumentPosition)(javax.rmi.PortableRemoteObject.narrow(position.getEJBRef(),
		//DocumentPosition.class))));
		
		//((DocumentPosition)(javax.rmi.PortableRemoteObject.narrow(position.getEJBRef(),
		//	DocumentPosition.class))).get

		//process agregation
		try {		
			if( position.getAgregate() != null ) {
				(new AgregateContentAccessBean()).findAgregateAndPart( 
					new Integer(card.findBySerial(position.getAgregate().getSerialnumber()).getStoragecard()), 
					new Integer(card.getStoragecard())).getEJBRef().remove();
			} else if( position.getAgregateSerial() != null ) {
				new AgregateContentAccessBean().findAgregateAndPart(  
					new Integer(card.findBySerial(position.getAgregateSerial()).getStoragecard()), 
					new Integer(card.getStoragecard()) ).getEJBRef().remove();
			}
		} catch( javax.ejb.ObjectNotFoundException e ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NO_CARD );
			error.setMessage( "No card with serial ="+position.getOldAgregateSerial() );
			error.setSerial(position.getOldAgregateSerial());
			return error;										
		}

		//remove track record
		try {
			CardTrackAccessBean track = (new CardTrackAccessBean()).findLastDocumentTrack( new Integer(card.getStoragecard()),
					new Integer( document.getDocument() ) );
			track.getEJBRef().remove();
			System.err.println(">>>DEBUG. Removing card track");
		} catch( javax.ejb.ObjectNotFoundException e ) {
			System.err.println("Card track expected but not found! Card="+card.getStoragecard());
		}
		

		//remove card
		try {
			if( card.getAssemblingAct().hasMoreElements() ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.POSITION_HIDDEN );
				error.setMessage( "Position hidden with serial="+position.getSerialnumber() );
				AssemblingAct aa = (AssemblingAct)
					javax.rmi.PortableRemoteObject.narrow(card.getAssemblingAct().nextElement(), AssemblingAct.class );
				AssemblingActAccessBean aaab = new AssemblingActAccessBean(aa);
				aaab.refreshCopyHelper();	
				error.setLastDocumentCode( aaab.getDocument() );
				System.out.println(">>>> UNPSPT: card used as main agregate=" + aaab.getDocument());
				return error;										
			} else if( card.getI13nAct().hasMoreElements() ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.POSITION_HIDDEN );
				error.setMessage( "Position hidden with serial="+position.getSerialnumber() );
				I13nAct ia = (I13nAct)
					javax.rmi.PortableRemoteObject.narrow(card.getI13nAct().nextElement(), I13nAct.class );
				I13nActAccessBean iaab = new I13nActAccessBean(ia);
				iaab.refreshCopyHelper();
				error.setLastDocumentCode( iaab.getDocument() );
				System.out.println(">>>> UNPSPT: card used as main agregate in i13nact =" + iaab.getDocument());
				return error;										
			} /*else if( card.getOutDocumentPosition().hasMoreElements() ) {
				System.err.println(">>>ERROR. OutDocPosition reference removing card!");
			} else if( card.getInDocumentPosition().hasMoreElements() ) {
				System.err.println(">>>ERROR. InDocPosition reference removing card!");
			} else if( card.getCardTrack().hasMoreElements() ) {
				System.err.println(">>>ERROR. CardTrack reference removing card!");
			} else if( card.getAgregate().hasMoreElements() ) {
				System.err.println(">>>ERROR. Agregate reference removing card!");
			} else if( card.getAgregateContent().hasMoreElements() ) {
				System.err.println(">>>ERROR. AgregateContenet reference removing card!");
			}
			if( getSessionContext().getRollbackOnly() ) {
				System.err.println(">>>ERROR. ROLLBACK ONLY!");
			}*/
			card.getEJBRef().remove();
			//card.setClosed(Boolean.TRUE);
			//card.setLastDocument( null );
			//card.commitCopyHelper();
			//int i = 0;
		} catch( Exception e ) {
			//position hidden with unknown entity.
			//System.err.println("Exception during removing card VVVV");
			//e.printStackTrace();
			//System.err.println("Exception during removing card ^^^^");
			error.setErrorCode( ProcessingPositionError.ERRORS.POSITION_HIDDEN );
			error.setMessage( "Position hidden with serial="+position.getSerialnumber() );
			error.setLastDocumentCode( 0 );
			return error;										
		}
		return null;
	} catch( Exception e ) {
		throw new RemoteException( "Whle processing document position (unProcessSerialPositionTo)", e );
	}

}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 18:41:21)
 * @param from int
 * @param to int
 * @param position com.hps.july.persistence.DocumentPositionAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
protected ProcessingPositionError unPutNonSerialPositionTo( DocumentAccessBean document, DocumentPositionAccessBean position) 
throws java.rmi.RemoteException {
	try { 
		
		ProcessingPositionError error = new ProcessingPositionError();
		StorageCardAccessBean card = null; 

		try {
			if( position.getResource().getCountpolicy().equals( "P" ) ) {
				card =  (new StorageCardAccessBean()).findByStorageOwnerParty( new Integer(document.getToKey().storageplace),
					new Integer( position.getOwner().getOrganization() ), position.getParty() ); 
			} else if( position.getResource().getCountpolicy().equals( "B" )) {
				card =  (new StorageCardAccessBean()).findByStorageOwnerResource( new Integer(document.getToKey().storageplace),
					new Integer( position.getOwner().getOrganization() ), new Integer( position.getResource().getResource() ) );
			}
		} catch( javax.ejb.ObjectNotFoundException e ) {
			if( position.getParty() != null ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.NO_SUCH_PARTY );
				error.setMessage( "No source for party="+position.getParty() );
				error.setParty( position.getParty() );
			} else {
				error.setErrorCode( ProcessingPositionError.ERRORS.NOT_SUCH_PRODUCT );
				error.setMessage( "No source for product="+position.getResourceKey().resource );
			}
			error.setStorage( document.getToKey().storageplace );
			error.setOwner( position.getOwner().getOrganization() );
			error.setResource( position.getResourceKey().resource );
			return error;
		}
		
		//found!!!

		//must be the same resource
		if( card.getResourceKey().resource != position.getResourceKey().resource ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOT_THE_SAME_RESOURCE );
			error.setMessage( "No resource is wrong resource="+card.getResourceKey().resource );
			error.setResource( card.getResourceKey().resource );
			if (position.getParty() != null)
				error.setParty(position.getParty());
			return error;					
		}		
		
		
		//get from source and check for qty presence
		if( card.getQty().compareTo( position.getQty() ) < 0 ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOTENOUGHQTY );
			error.setMessage( "Not enough "+position.getQty() );
			error.setQty( card.getQty() );
			return error;
		}
		
		//check for broken qty
		if( position.getResultBroken().booleanValue() && card.getQtyBroken().compareTo( position.getQty() ) < 0 ) {
			error.setErrorCode( ProcessingPositionError.ERRORS.NOTENOUGHQTY );
			error.setMessage( "Not enough "+position.getQty() );
			error.setQty( card.getQtyBroken() );
			return error;
		}
		
		//check for other agregates qty
		if( position.getAgregate() == null && position.getAgregateSerial() == null ) {//check for agregates
			BigDecimal inAgregates = new BigDecimal( 0 );
			AgregateContentAccessBeanTable agr = new AgregateContentAccessBeanTable();
			agr.setAgregateContentAccessBean( 
				new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration( card.getAgregate(),
				//(new AgregateContentAccessBean() ).findAgregateByParts( new StorageCardKey(card.getStoragecard()) ), 
				AgregateContentAccessBean.class ) );
			for( int i = 0; i < agr.numberOfRows(); i++ ) {
				inAgregates = inAgregates.add( agr.getAgregateContentAccessBean(i).getQty() );
			}
			if( card.getQty().subtract( inAgregates ).compareTo( position.getQty() ) < 0 ) {
				error.setErrorCode( ProcessingPositionError.ERRORS.NOTENOUGHQTY );
				error.setMessage( "Not enough "+position.getQty() );
				error.setQty( card.getQty() );
				return error;
			}				
		}
		
		//subtract from source
		if( position.getResultBroken().booleanValue() ) {  
			card.setQtyBroken( card.getQtyBroken().subtract( position.getQty() ) );
		}
		if( card.getPolicy().equals( "B" ) ) {
			if( card.getQty().equals( position.getQty() ) ) {
				card.setPrice( new BigDecimal(0) );
			} else {
				card.setPrice( 
					card.getPrice().multiply(card.getQty()).subtract(position.getPrice().multiply(position.getQty())).
					divide( card.getQty().subtract(position.getQty()), 
					java.math.BigDecimal.ROUND_HALF_DOWN ).setScale( 2, java.math.BigDecimal.ROUND_HALF_DOWN ) );
			}
		}
		card.setQty( card.getQty().subtract( position.getQty() ) );
		if( card.getQty().equals(new BigDecimal("0.000")) ) {
			card.setClosed(Boolean.TRUE);
		}
		card.commitCopyHelper();
		
		//process agregation
		DocumentPositionAccessBean agregate = position.getAgregate();
		StorageCardAccessBean agregateCard = null;
		if( agregate != null || position.getAgregateSerial() != null ) {							//agregate
			if( agregate != null ) {
				agregateCard = (new StorageCardAccessBean()).findBySerial(agregate.getSerialnumber());
			} else {
				agregateCard = (new StorageCardAccessBean()).findBySerial(position.getAgregateSerial());
			}
			try {
				AgregateContentAccessBean link = 
					(new AgregateContentAccessBean() ).findAgregateAndPart( 
						new Integer( agregateCard.getStoragecard() ), 
						new Integer( card.getStoragecard() ) );
				if( link.getQty().equals(position.getQty() ) ) {	
					link.getEJBRef().remove();
				} else if( link.getQty().compareTo(position.getQty()) < 0 ) {
					error.setErrorCode( ProcessingPositionError.ERRORS.NOTENOUGHQTY );
					error.setMessage( "Not enough "+position.getQty() );
					error.setQty( link.getQty() );
					return error;
				} else {
					link.setQty(link.getQty().subtract(position.getQty()));
					link.commitCopyHelper();			
				}
			} catch( javax.ejb.ObjectNotFoundException e ) {
				//
				error.setErrorCode( ProcessingPositionError.ERRORS.NOTENOUGHQTY );
				error.setMessage( "Not enough "+position.getQty() );
				//error.setQty( card.getQty() );
				error.setQty(new BigDecimal(0));
				return error;
			}
		}
		
		position.setCardFrom( null );
		position.setCardTo( null );
		position.commitCopyHelper();
		
	} catch( Exception e ) {
		throw new RemoteException( "Whle processing document position (unPutNonSerialPositionTo)", e );
	}
	return null;
}
}
