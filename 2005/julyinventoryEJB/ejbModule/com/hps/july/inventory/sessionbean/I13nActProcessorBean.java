package com.hps.july.inventory.sessionbean;

import com.hps.july.persistence.*;
import java.math.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.*;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is a Session Bean Class
 * Процессор актов инвентаризации
 */
public class I13nActProcessorBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx = null;
	private final static long serialVersionUID = 3206093459760846163L;

/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 19:33:44)
 * @param act com.hps.july.persistence.I13nActAccessBean
 * @exception java.lang.Exception The exception description.
 */
public void applyI13nBoundary(I13nActAccessBean act) throws java.lang.Exception {
	if( act.getType().equals( "F" ) ) {
		StorageCardAccessBeanTable cards = new StorageCardAccessBeanTable();
		cards.setStorageCardAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
			act.getFrom().getStorageCard(),
			StorageCardAccessBean.class
			) );
		for( int i = 0; i < cards.numberOfRows(); i++ ) {
			StorageCardAccessBean card = cards.getStorageCardAccessBean( i );
			if( card.getPolicy().equals( "S" ) )
				if( card.getAgregate() != null && card.getAgregate().hasMoreElements() )
					continue;
			new I13nDateSavingAccessBean( new Integer( act.getDocument() ), 
				new Integer( card.getStoragecard() ), card.getI13nDate() );
			card.setI13nDate( act.getBlankdate() );
			card.commitCopyHelper();
		}
	} else if( act.getType().equals( "P" ) ) {
		StorageCardAccessBeanTable cards = new StorageCardAccessBeanTable();
		cards.setStorageCardAccessBean( 
			(new StorageCardAccessBean()).findByStorageAndI13nResourceSetAct(
				new Integer( act.getFromKey().storageplace ), new Integer(act.getDocument() ) ) );
		for( int i = 0; i < cards.numberOfRows(); i++ ) {
			StorageCardAccessBean card = cards.getStorageCardAccessBean( i );
			if( card.getPolicy().equals( "S" ) ) {
				AgregateContentAccessBeanTable agregatePartsTable = new AgregateContentAccessBeanTable();
				agregatePartsTable.setAgregateContentAccessBean( 
					(new AgregateContentAccessBean()).findAgregateByParts( 
						new StorageCardKey(card.getStoragecard()) )
					);
				if( agregatePartsTable.numberOfRows() != 0 ) {		//эта карта часть агрегата !?
					continue;
				}
				new I13nDateSavingAccessBean( new Integer( act.getDocument() ), 
					new Integer( card.getStoragecard() ), card.getI13nDate() );
				card.setI13nDate( act.getBlankdate() );
				card.commitCopyHelper();
			} else if( card.getPolicy().equals( "P" ) || card.getPolicy().equals( "B" ) ) {
				new I13nDateSavingAccessBean( new Integer( act.getDocument() ), 
					new Integer( card.getStoragecard() ), card.getI13nDate() );
				card.setI13nDate( act.getBlankdate() );
				card.commitCopyHelper();
			}
		}
	} else if( act.getType().equals( "A" ) ) {
		StorageCardAccessBean agregate = act.getAgregate();
		new I13nDateSavingAccessBean( new Integer( act.getDocument() ), 
			new Integer( agregate.getStoragecard() ), agregate.getI13nDate() );
		agregate.setI13nDate( act.getBlankdate() );
		agregate.commitCopyHelper();
		
		AgregateContentAccessBeanTable agregatePartsTable = new AgregateContentAccessBeanTable();
		agregatePartsTable.setAgregateContentAccessBean( 
			(new AgregateContentAccessBean()).findAgregateContentByAgregate( 
				new StorageCardKey(act.getAgregate().getStoragecard()) )
			);

		for( int i = 0; i < agregatePartsTable.numberOfRows(); i++ ) { 
			StorageCardAccessBean part = agregatePartsTable.getAgregateContentAccessBean(i).getParts();
			if( !part.getPolicy().equals("S") ) {
				continue;
			}
			new I13nDateSavingAccessBean( new Integer( act.getDocument() ), 
				new Integer( part.getStoragecard() ), part.getI13nDate() );
			part.setI13nDate( act.getBlankdate() );
			part.commitCopyHelper();
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 11:22:38)
 * @return java.util.ArrayList
 * @param from java.util.ArrayList
 * @param to java.util.ArrayList
 */
public ArrayList calculateDelta(ArrayList from, ArrayList what ) {
	ArrayList delta = new ArrayList();
	for( int i = 0; i < from.size(); i++ ) { 
		StorageCellValueObject obj = findSuchObject( what, ((StorageCellValueObject)(from.get(i))) );
		if( obj == null ) {
			StorageCellValueObject oFrom = (StorageCellValueObject)from.get(i);
			if( !oFrom.getPolicy().equals( "S" ) && oFrom.getQty().equals(new BigDecimal(0)) )
				continue; 
			delta.add( oFrom );
			continue;
		} else {
			if( obj.getPolicy().equals( "S" ) ) {
				continue;
			} else {
				StorageCellValueObject fromObject = ((StorageCellValueObject)(from.get(i)));
				if( fromObject.getQty().compareTo( obj.getQty() ) > 0  ) {
					StorageCellValueObject o = new StorageCellValueObject();
					o.setBoxed( obj.isBoxed() );
					o.setBroken( obj.isBroken() );
					o.setOwner( obj.getOwner() );
					o.setParty( obj.getParty() );
					o.setPolicy( obj.getPolicy() );
					o.setPrice( fromObject.getPrice() );
					o.setQty( fromObject.getQty().subtract( obj.getQty() ) );
					o.setResource( obj.getResource() );
					o.setSerial( obj.getSerial() );
					o.setRealposition(obj.getRealposition());
					delta.add( o );
				} 
			}
		}
	}
	return delta;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 12:53:59)
 * @param argAct java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException cancelI13nAct(Integer argAct) throws java.rmi.RemoteException {

	try {
		I13nActAccessBean act = new I13nActAccessBean();
		act.setInitKey_document( argAct.intValue() );
		act.refreshCopyHelper();

		//check act state
		if( !act.getDocumentState().equals( "2" ) ) {
			return new DocumentProcessingException( 1, "Incompatible state" );			
		}

		//check for possibility
		Integer doccode = checkForPossibility( act );
		if( doccode != null) {
			DocumentProcessingException dex = new DocumentProcessingException( 2, "Operation invalid. Other documents exists." );
			dex.setOtherDocument(doccode);
			return dex; 
		}

		//cancel documents
		DocumentsLinkAccessBean payOffLink = (DocumentsLinkAccessBean)(((new DocumentsLinkAccessBean()).
			findByTypeAndDocFrom( "P", new Integer( act.getDocument() ) )).nextElement());
		DocumentsLinkAccessBean surPlusLink = (DocumentsLinkAccessBean)(((new DocumentsLinkAccessBean()).
			findByTypeAndDocFrom( "S", new Integer( act.getDocument() ) )).nextElement());
		int payOffCode = payOffLink.getDocumentTo().getDocument();
		int surplusCode = surPlusLink.getDocumentTo().getDocument();
		PayOffActAccessBean payOff 		= new PayOffActAccessBean();
		payOff.setInitKey_document( payOffCode );
		payOff.refreshCopyHelper();
		SurplusActAccessBean surPlus 	= new SurplusActAccessBean();
		surPlus.setInitKey_document( surplusCode );
		surPlus.refreshCopyHelper();

		/*return old i13ndate values - DEPRECATED!
		I13nDateSavingAccessBeanTable savings = new I13nDateSavingAccessBeanTable();
		savings.setI13nDateSavingAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
			act.getI13nDateSaving(),
			I13nDateSavingAccessBean.class
			) );
		for( int i = 0; i < savings.numberOfRows(); i++ ) {
			I13nDateSavingAccessBean sv = savings.getI13nDateSavingAccessBean(i);
			StorageCardAccessBean card = sv.getStorageCard();
			card.setI13nDate( sv.getOldI13nDate() );
			card.commitCopyHelper();
			sv.getEJBRef().remove();
		}*/
		
		// UnSend document to trailcom
		com.hps.july.trailcom.beans.TrailcomProcessorAccessBean trproc = new com.hps.july.trailcom.beans.TrailcomProcessorAccessBean();
		trproc.cancelDocument(new Integer(surPlus.getDocument()));
		trproc.cancelDocument(new Integer(payOff.getDocument()));
		
		//cancelling documents
		DocumentProcessorAccessBean processor = new DocumentProcessorAccessBean();
		Util.printDebug("Before cancel surplus.");
		DocumentProcessingException ex;
		ex = processor.cancelDocument( new Integer(surPlus.getDocument()) );
		if( ex != null ) {
			//processor.getEJBRef().remove();
			return ex;
		}
		Util.printDebug("Before cancel payoff.");
		ex = processor.cancelDocument( new Integer(payOff.getDocument()) );
		if( ex != null ) {
			//processor.getEJBRef().remove();
			return ex;
		}
		//processor.getEJBRef().remove();
		
		// UnSend I13NAct to Platinum
		com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean platproc = new com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean();
		platproc.cancelDocument(argAct);
		//platproc.cancelDocument(new Integer(payOffCode));
		//platproc.cancelDocument(new Integer(surplusCode));
		
		//delete doc links
		payOffLink.getEJBRef().remove();
		surPlusLink.getEJBRef().remove();
		
		DocumentPositionAccessBeanTable positions = new DocumentPositionAccessBeanTable();
		
		//clear last document in agregat for agregate	acts
		if( act.getType().equals("A") ) {
			CardTrackAccessBean track = null;
			StorageCardAccessBean card = act.getAgregate();
			try {
				track = 
					(new CardTrackAccessBean()).findBeforeDocument( new Integer(card.getStoragecard()), 
					new Integer( act.getDocument() ) );
				card.setLastDocument( (Document)(track.getDocument().getEJBRef()) );
				//card.setPrice(track.get)
			} catch( javax.ejb.ObjectNotFoundException e ) {
				card.setLastDocument( null );
			}

			// Update agregate price - back 
			java.math.BigDecimal totsum = new java.math.BigDecimal(0).setScale(2);
			positions.setDocumentPositionAccessBean( 
				(new DocumentPositionAccessBean()).findDocPositionsByDocOrderByOrderAsc( new Integer( surPlus.getDocument() ) ) );
			for( int i = 0; i < positions.numberOfRows(); i++ ) {
				DocumentPositionAccessBean vo = positions.getDocumentPositionAccessBean(i);
				totsum = totsum.add(vo.getPrice().multiply(vo.getQty()));
			}
			java.math.BigDecimal newPrice = card.getPrice().add(totsum);
			//System.out.println(">>>> I13N >>>> Totsum=" + totsum.toString() + ", newPrice=" + newPrice.toString());
			card.setPrice(newPrice);
			card.commitCopyHelper();
		}
		
		//delete documentpositions		
		positions.setDocumentPositionAccessBean( 
			(new DocumentPositionAccessBean()).findDocPositionsByDocOrderByOrderAsc( new Integer( payOff.getDocument() ) ) );
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			DocumentPositionAccessBean pos = positions.getDocumentPositionAccessBean(i);
			if( pos.getAgregateParts().hasMoreElements() ) {
				continue;
			}
			pos.getEJBRef().remove();
		}
		positions.setDocumentPositionAccessBean( 
			(new DocumentPositionAccessBean()).findDocPositionsByDocOrderByOrderAsc( new Integer( payOff.getDocument() ) ) );
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			positions.getDocumentPositionAccessBean(i).getEJBRef().remove();
		}
		
		positions.setDocumentPositionAccessBean( 
			(new DocumentPositionAccessBean()).findDocPositionsByDocOrderByOrderAsc( new Integer( surPlus.getDocument() ) ) );
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			DocumentPositionAccessBean pos = positions.getDocumentPositionAccessBean(i);
			if( pos.getAgregateParts().hasMoreElements() ) {
				continue;
			}
			pos.getEJBRef().remove();
		}
		positions.setDocumentPositionAccessBean( 
			(new DocumentPositionAccessBean()).findDocPositionsByDocOrderByOrderAsc( new Integer( surPlus.getDocument() ) ) );
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			positions.getDocumentPositionAccessBean(i).getEJBRef().remove();
		}
		
		//delete documents
		Util.printDebug("Before delete surplus.");
		payOff.getEJBRef().remove();
		Util.printDebug("Before delete payoff.");
		surPlus.getEJBRef().remove();

		
		//change act state
		act.setDocumentState( "1" );
		act.commitCopyHelper();

		
		return null;
	}catch( Exception e ) {
		throw new java.rmi.RemoteException( "While cancelling i13n act.", e );
	}

}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2002 20:01:48)
 * @param act com.hps.july.persistence.I13nActAccessBean
 * @exception com.hps.july.inventory.sessionbean.DocumentProcessingException The exception description.
 */
public ArrayList checkAct(I13nActAccessBean act) throws Exception {

	ArrayList al = new ArrayList();
	
	if( act.getType().equals("F") ) {
	} else if(act.getType().equals("P") ) {
		DocumentPositionAccessBeanTable positions = new DocumentPositionAccessBeanTable();
		positions.setDocumentPositionAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration( 
			act.getDocumentPosition(), DocumentPositionAccessBean.class
		) );
		for( int i = 0; i < positions.numberOfRows(); i++ ) {
			I13nActResourceSetAccessBean resInAct = new I13nActResourceSetAccessBean();
			resInAct.setInitKey_i13nAct_document( new Integer(act.getDocument()) );
			resInAct.setInitKey_resource_resource( new Integer(positions.getDocumentPositionAccessBean(i).getResourceKey().resource) );
			try {
				resInAct.refreshCopyHelper();
			} catch( javax.ejb.ObjectNotFoundException e ) {
				ProcessingPositionError err = new ProcessingPositionError();
				// DD - new error added
				err.setErrorCode( ProcessingPositionError.ERRORS.INVALID_RESOURCE );
				err.setMessage( "This resource can't be in i13n." );
				err.setPositionCode(positions.getDocumentPositionAccessBean(i).getDocposition());
				err.setResource(positions.getDocumentPositionAccessBean(i).getResourceKey().resource);
				al.add( err );
			}
		}		
	} else if(act.getType().equals("A") ) {
	}

	return al;
	
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 15:51:24)
 * @param act com.hps.july.persistence.I13nActAccessBean
 * @exception java.lang.Exception The exception description.
 */
public Integer checkForPossibility(I13nActAccessBean act) throws java.lang.Exception {
	Integer doccode = null;
	try {
		DocumentPositionAccessBean docpos = null;
		
		if( act.getType().equals( "F" ) ) {
			docpos = (DocumentPositionAccessBean) ( (new DocumentPositionAccessBean()).findByStorageAfterDate( new Integer( act.getFromKey().storageplace ), 
				act.getBlankdate() ) );
		} else if( act.getType().equals( "P" ) ) {
			docpos = (DocumentPositionAccessBean) ( (new DocumentPositionAccessBean()).findByResourceSetAndStorageAfterDate( new Integer( act.getDocument() ), 
				new Integer( act.getFromKey().storageplace ), act.getBlankdate() ) );
		} else if( act.getType().equals( "A" ) ) {
			docpos = (DocumentPositionAccessBean) ( (new DocumentPositionAccessBean()).findByAgregateAfterDate( act.getAgregate().getSerialnumber(), 
				act.getBlankdate() ) );
		}
		if (docpos != null) {
			doccode = new Integer(docpos.getDocument().getDocument());
		}
	} catch( javax.ejb.ObjectNotFoundException e ) {
		return doccode;
	}
	return doccode;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 15:53:37)
 * @return com.hps.july.persistence.PayOffActAccessBean
 * @param act com.hps.july.persistence.I13nActAccessBean
 * @param pList java.util.ArrayList
 */
public PayOffActAccessBean createNAct(I13nActAccessBean act, ArrayList pList) throws Exception {
	
	//creating act
	Util.printDebug("INV: PayOff header creating....");
	PayOffActAccessBean payOff = new PayOffActAccessBean( 
		(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.documents" ), 
		new Integer(act.getOwnerKey().organization ), new Integer( act.getFromKey().storageplace ), 
		new Integer( act.getToKey().storageplace ), act.getBlankdate(), 
		act.getBlankindex(), act.getBlanknumber(), "1", Boolean.TRUE, Boolean.FALSE );
	if (act.getStorageManager() != null)
		payOff.setStorageManager((Worker)act.getStorageManager().getEJBRef());
	payOff.setShowtouser(false);
	payOff.commitCopyHelper();

	//creating link 2 i13n
	Util.printDebug("INV: creating PayOff doc link....");
	new DocumentsLinkAccessBean( "P", new Integer( act.getDocument() ), new Integer( payOff.getDocument() ) );
		
	//creating positions
	DocumentProcessorAccessBean processor = new DocumentProcessorAccessBean();
	for( int i = 0; i < pList.size(); i++ ) {
		int poscode = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
		StorageCellValueObject vo = (StorageCellValueObject)(pList.get(i));
		vo.setVirtposition(new Integer(poscode));
		/*
		DocumentPositionAccessBean pos = new DocumentPositionAccessBean( 
			poscode, 
			new Integer(vo.getResource()), new Integer(vo.getOwner()), new Integer(payOff.getDocument()), 
			i+1, vo.getQty(), vo.getPrice(), Boolean.FALSE, new Boolean(vo.isBoxed()), Boolean.FALSE, 
			new Boolean(vo.isBroken()), Boolean.FALSE, Boolean.TRUE );
		*/
		
		Util.printDebug("INV: creating PayOff docposition....");
		DocumentPositionAccessBean pos = new DocumentPositionAccessBean( 
			poscode, 
			new Integer(vo.getResource()), new Integer(vo.getOwner()), new Integer(payOff.getDocument()), 
			i+1, vo.getQty(), vo.getPrice(), 
			new Boolean(vo.isBoxed()), new Boolean(vo.isBoxed()), 
			new Boolean(vo.isBroken()), new Boolean(vo.isBroken()), 
			Boolean.FALSE, Boolean.TRUE );
		
		pos.setParty( vo.getParty() );
		pos.setSerialnumber( vo.getSerial() );
		pos.setConfiguration( vo.getConfiguration() );
		pos.setNewplace(vo.getPlace());
		if( act.getType().equals("A") ) {
			pos.setOldAgregateSerial( act.getAgregate().getSerialnumber() );
		}
		pos.commitCopyHelper();
		if( !act.getType().equals("A") ) {
			processor.addPosition2Document( new Integer( pos.getDocposition() ) );
		}
	}
		
	return payOff;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 15:53:37)
 * @return com.hps.july.persistence.PayOffActAccessBean
 * @param act com.hps.july.persistence.I13nActAccessBean
 * @param pList java.util.ArrayList
 */
public SurplusActAccessBean createPAct(I13nActAccessBean act, ArrayList pList) throws Exception {
	//creating act
	Util.printDebug("INV: creating Surplus header....");
	SurplusActAccessBean surAct = new SurplusActAccessBean( 
		(new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey( "tables.documents" ), 
		new Integer(act.getOwnerKey().organization ), new Integer( act.getFromKey().storageplace ), 
		new Integer( act.getToKey().storageplace ), act.getBlankdate(), 
		act.getBlankindex(), act.getBlanknumber(), "1", Boolean.FALSE, Boolean.TRUE );
	if (act.getStorageManager() != null)
		surAct.setStorageManager((Worker)act.getStorageManager().getEJBRef());
	surAct.setShowtouser(false);
	surAct.commitCopyHelper();
	
	//creating link 2 i13n
	Util.printDebug("INV: creating Surplus doc link....");
	new DocumentsLinkAccessBean( "S", new Integer( act.getDocument() ), new Integer( surAct.getDocument() ) );
		
	//creating positions 
	DocumentProcessorAccessBean processor = new DocumentProcessorAccessBean();
	for( int i = 0; i < pList.size(); i++ ) {
		int poscode = (new com.hps.july.commonbean.KeyGeneratorAccessBean()).getNextKey("tables.docpositions");
		StorageCellValueObject vo = (StorageCellValueObject)(pList.get(i));
		vo.setVirtposition(new Integer(poscode));
		/*
		DocumentPositionAccessBean pos = new DocumentPositionAccessBean( 
			poscode, 
			new Integer(vo.getResource()), new Integer(vo.getOwner()), new Integer(surAct.getDocument()), 
			i+1, vo.getQty(), vo.getPrice(), Boolean.FALSE, new Boolean(vo.isBoxed()), Boolean.FALSE, 
			new Boolean(vo.isBroken()), Boolean.TRUE, Boolean.FALSE );
		*/
		Util.printDebug("INV: creating Surplus docpos....");
		DocumentPositionAccessBean pos = new DocumentPositionAccessBean( 
			poscode, 
			new Integer(vo.getResource()), new Integer(vo.getOwner()), new Integer(surAct.getDocument()), 
			i+1, vo.getQty(), vo.getPrice(), 
			new Boolean(vo.isBoxed()), new Boolean(vo.isBoxed()), 
			new Boolean(vo.isBroken()), new Boolean(vo.isBroken()), 
			Boolean.TRUE, Boolean.FALSE );
		pos.setParty( vo.getParty() );
		pos.setSerialnumber( vo.getSerial() );
		pos.setConfiguration( vo.getConfiguration() );
		pos.setNewplace( vo.getPlace() );
		pos.setManufserial(vo.getManufserial());
		if( act.getType().equals("A") ) {
			pos.setAgregateSerial( act.getAgregate().getSerialnumber() );
		}
		pos.commitCopyHelper();
		processor.addPosition2Document( new Integer( pos.getDocposition() ) );
	}
		
	return surAct;
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
 * Creation date: (18.06.2002 18:52:02)
 * @return com.hps.july.inventory.sessionbean.StorageCellValueObject
 * @param list java.util.ArrayList
 * @param obj com.hps.july.inventory.sessionbean.StorageCellValueObject
 */
public StorageCellValueObject findSuchObject(ArrayList list, StorageCellValueObject obj) {
	if (list == null)
		return null;
	if (obj == null)
		return null;
	for( int i = 0; i < list.size(); i++ ) {
		StorageCellValueObject lstObj = (StorageCellValueObject)(list.get(i));
		if (lstObj == null)
			continue;
		if( lstObj.getResource() != obj.getResource() )
			continue;
		if( lstObj.getOwner() != obj.getOwner() )
			continue;
		if( "S".equals(lstObj.getPolicy()) ) {
			if (lstObj.getSerial() != null) {
				if( !lstObj.getSerial().equals( obj.getSerial() ) )
					continue;
			} else {
				if (obj.getSerial() != null)
					continue;
			}
			if( lstObj.isBoxed() != obj.isBoxed() || lstObj.isBroken() != obj.isBroken() )
				continue;
			return lstObj;
		} else if( "P".equals(lstObj.getPolicy()) ) {
			if( !lstObj.getParty().equals( obj.getParty() ) )
				continue;
			return lstObj;			
		} else if( "B".equals(lstObj.getPolicy()) ) {
			return lstObj;			
		}
	}
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 14:05:06)
 * @return java.util.ArrayList
 * @param act com.hps.july.persistence.I13nActAccessBean
 * @exception java.lang.Exception The exception description.
 */
private ArrayList getCurrentStateForI13n(I13nActAccessBean act) throws java.lang.Exception {

	ArrayList result = new ArrayList(); 
	
	if( act.getType().equals("F") ) {			//full for this storage
		StorageCardAccessBeanTable cards = new StorageCardAccessBeanTable();
		cards.setStorageCardAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
			act.getFrom().getStorageCard()
			,StorageCardAccessBean.class ) 
		);
		for( int i = 0; i < cards.numberOfRows(); i++ ) {
			StorageCardAccessBean card = cards.getStorageCardAccessBean( i );

			if( card.getClosed().booleanValue() )
				continue;

			if( card.getPolicy().equals( "S" ) ) {
				AgregateContentAccessBeanTable agregateTable = new AgregateContentAccessBeanTable();
				agregateTable.setAgregateContentAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
					(new AgregateContentAccessBean()).findAgregateByParts( new StorageCardKey( card.getStoragecard() ) ),					
					AgregateContentAccessBean.class
					) );
				if( agregateTable.numberOfRows() != 0 ) {		//эта карта часть агрегата !?
					continue;
				}
				result.add( new StorageCellValueObject( card ) ); 
			} else if( card.getPolicy().equals( "P" ) || card.getPolicy().equals( "B" ) ) {
				AgregateContentAccessBeanTable agregateTable = new AgregateContentAccessBeanTable();
				agregateTable.setAgregateContentAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
					card.getAgregate(),					
					AgregateContentAccessBean.class
					) );
				BigDecimal nonAgregateQty = card.getQty();
				for( int j = 0; j < agregateTable.numberOfRows(); j++ ) {
					//String cardAgregateSerial = agregateTable.getAgregateContentAccessBean(1).getAgregate().getSerialnumber();
					//вычитаем к-во в агрегатах	
					nonAgregateQty = nonAgregateQty.subtract( agregateTable.getAgregateContentAccessBean(j).getQty() );
				}
				if( nonAgregateQty.equals(new BigDecimal("0.000")) ) {
					continue;
				} 
				BigDecimal qtyBroken = card.getQtyBroken();
				if( qtyBroken != null && qtyBroken.equals(new BigDecimal(0)) ) {
					card.setBroken( Boolean.FALSE );
					result.add( new StorageCellValueObject( card, nonAgregateQty.subtract( qtyBroken ) ) );
					card.setBroken( Boolean.TRUE );
					result.add( new StorageCellValueObject( card, qtyBroken ) );
				} else {
					result.add( new StorageCellValueObject( card, nonAgregateQty ) );
				}
			}
		}	

	} else if( act.getType().equals("P") ) {	//by product list
		StorageCardAccessBeanTable cards = new StorageCardAccessBeanTable();
		cards.setStorageCardAccessBean( 
			(new StorageCardAccessBean()).findByStorageAndI13nResourceSetAct(
				new Integer( act.getFromKey().storageplace ), new Integer(act.getDocument() ) ) );
		for( int i = 0; i < cards.numberOfRows(); i++ ) {
			StorageCardAccessBean card = cards.getStorageCardAccessBean( i );
			if( card.getClosed().booleanValue() )
				continue;
			if( card.getPolicy().equals( "S" ) ) {
				AgregateContentAccessBeanTable agregateTable = new AgregateContentAccessBeanTable();
				agregateTable.setAgregateContentAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
					(new AgregateContentAccessBean()).findAgregateByParts( new StorageCardKey( card.getStoragecard() ) ),					
					AgregateContentAccessBean.class
					) );
				if( agregateTable.numberOfRows() != 0 ) {		//эта карта часть агрегата !?
					continue;
				}
				result.add( new StorageCellValueObject( card ) );
			} else if( card.getPolicy().equals( "P" ) || card.getPolicy().equals( "B" ) ) {
				AgregateContentAccessBeanTable agregateTable = new AgregateContentAccessBeanTable();
				agregateTable.setAgregateContentAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
					(new AgregateContentAccessBean()).findAgregateByParts( new StorageCardKey( card.getStoragecard() ) ),					
					AgregateContentAccessBean.class
					) );
				BigDecimal nonAgregateQty = card.getQty();
				for( int j = 0; j < agregateTable.numberOfRows(); j++ ) {
					//String cardAgregateSerial = agregateTable.getAgregateContentAccessBean(1).getAgregate().getSerialnumber();
					//вычитаем к-во в агрегатах	
					nonAgregateQty = nonAgregateQty.subtract( agregateTable.getAgregateContentAccessBean(j).getAgregate().getQty() );
				}
				if( nonAgregateQty.equals(new BigDecimal(("0.000")) ) ) {
					continue;
				}
				BigDecimal qtyBroken = card.getQtyBroken();
				if( qtyBroken != null && qtyBroken.equals(new BigDecimal(0)) ) {
					card.setBroken( Boolean.FALSE );
					result.add( new StorageCellValueObject( card, nonAgregateQty.subtract( qtyBroken ) ) );
					card.setBroken( Boolean.TRUE );
					result.add( new StorageCellValueObject( card, qtyBroken ) );
				} else {
					result.add( new StorageCellValueObject( card, nonAgregateQty ) );
				}
			}
		}
				
	} else if( act.getType().equals("A") ) {	//by agregate
		StorageCardAccessBean agregate = act.getAgregate();

		AgregateContentAccessBeanTable agregatePartsTable = new AgregateContentAccessBeanTable();
		agregatePartsTable.setAgregateContentAccessBean( //new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration(
			(new AgregateContentAccessBean()).findAgregateContentByAgregate( 
				(StorageCardKey)(act.getAgregate().getEJBRef().getPrimaryKey()) )
				//, AgregateContentAccessBean.class ) 
		);

		for( int i = 0; i < agregatePartsTable.numberOfRows(); i++ ) {
			StorageCardAccessBean part = agregatePartsTable.getAgregateContentAccessBean(i).getParts();
			if( part.getClosed().booleanValue() )
				continue;
			if( part.getPolicy().equals( "S" ) ) {
				result.add( new StorageCellValueObject( part ) );				
			} else {
				result.add( new StorageCellValueObject( part, agregatePartsTable.getAgregateContentAccessBean(i).getQty() ) );				
			}
		}
		
	}
	
	return result;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 14:05:06)
 * @return java.util.ArrayList
 * @param act com.hps.july.persistence.I13nActAccessBean
 * @exception java.lang.Exception The exception description.
 */
private ArrayList getI13nSet(I13nActAccessBean act) throws java.lang.Exception {

	ArrayList result = new ArrayList();
	DocumentPositionAccessBeanTable positions = new DocumentPositionAccessBeanTable();
	positions.setDocumentPositionAccessBean( new com.ibm.ivj.ejb.runtime.AccessBeanEnumeration( 
		act.getDocumentPosition(), DocumentPositionAccessBean.class
	) );
	for( int i = 0; i < positions.numberOfRows(); i++ ) {
		result.add( new StorageCellValueObject( positions.getDocumentPositionAccessBean(i) ) );
	}
	return result;
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
 * Creation date: (15.06.2002 12:53:59)
 * @param argAct java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
public DocumentProcessingException processI13nAct(Integer argAct) throws java.rmi.RemoteException {
	try {
		I13nActAccessBean act = new I13nActAccessBean();
		act.setInitKey_document( argAct.intValue() );
		act.refreshCopyHelper();

		//check act state 
		if( !act.getDocumentState().equals( "1" ) ) {
			DocumentProcessingException dex = new DocumentProcessingException( 1, "Incompatible state" );
			return dex; 
		}

		//check overal act
		ArrayList errs = checkAct( act );
		if( errs.size() != 0 ) { 
			DocumentProcessingException e = new DocumentProcessingException();
			e.setErrorMessage( "Invalid i13n act!" );
			e.setPositionErrors( errs );
			return e;
		}

		//check for possibility
		Integer doccode = checkForPossibility( act );
		if( doccode != null) {
			DocumentProcessingException dex = new DocumentProcessingException( 2, "Operation invalid. Other documents exists." );
			dex.setOtherDocument(doccode);
			return dex; 
		}

		PayOffActAccessBean nAct 		= null;
		SurplusActAccessBean pAct 		= null;
		//calculate current set ( cSet)
		ArrayList cSet = getCurrentStateForI13n( act );   
		
		//get iSet
		ArrayList iSet = getI13nSet( act );
		
		//calculate pSet = iSet - cSset
		ArrayList pSet = calculateDelta( iSet, cSet );
		
		//calculate nSet = cSset - iSet 
		ArrayList nSet = calculateDelta( cSet, iSet ); 
		
		//create negate act (nSet)
		Util.printDebug("INV: Creating NAct");
		nAct = createNAct( act, nSet );  
		
		//create positive act (pSet)
		Util.printDebug("INV: Creating PAct");
		pAct = createPAct( act, pSet );
		
		
		//apply negate act
		DocumentProcessorAccessBean processor = new DocumentProcessorAccessBean();
		DocumentProcessingException ex;
		Util.printDebug("INV: Applying NAct");
		ex = processor.applyDocument( new Integer( nAct.getDocument() ) );
		if( ex != null ) {
			recodeToI13Positions( ex, nSet );
			return ex;
		}
		
		//apply positive act
		Util.printDebug("INV: Applying PAct");
		ex = processor.applyDocument( new Integer( pAct.getDocument() ) );
		if( ex != null ) {
			recodeToI13Positions( ex, pSet );
			return ex;
		}
		
		//set i13n atribute on all participating cards.
		//applyI13nBoundary( act ); deprecated!
		
		//set last document in agregat for agregat i13n
		if( act.getType().equals( "A" ) ) {
			StorageCardAccessBean agregat = act.getAgregate();
			agregat.refreshCopyHelper();
			agregat.setLastDocument( (Document)act.getEJBRef() );

			// Reduce price for main agregate
			java.math.BigDecimal totsum = new java.math.BigDecimal(0).setScale(2);
			for( int i = 0; i < pSet.size(); i++ ) {
				StorageCellValueObject vo = (StorageCellValueObject)(pSet.get(i));
				totsum = totsum.add(vo.getPrice().multiply(vo.getQty()));
			}
			if (agregat.getPrice().compareTo(totsum) < 0) {
				// Error - sum cannot be negative
				DocumentProcessingException dex = new DocumentProcessingException( 4, "Sum of agregate parts more than sum of agregate." );
				return dex; 
			}
			java.math.BigDecimal newPrice = agregat.getPrice().subtract(totsum);
			//System.out.println(">>>> I13N >>>> Totsum=" + totsum.toString() + ", newPrice=" + newPrice.toString());
			agregat.setPrice(newPrice);
			
			agregat.commitCopyHelper();
		}

		//change act state
		act.setDocumentState( "2" );
		act.commitCopyHelper();
		
		// Send I13NAct to Platinum
		com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean platproc = new com.hps.july.platinum.sessionbean.PlatinumProcessorAccessBean();
		Integer query = platproc.processVirtualDocument(argAct);
		platproc.processDocument(query, new Integer(nAct.getDocument()));
		platproc.processDocument(query, new Integer(pAct.getDocument()));

		// Send document to trailcom
		com.hps.july.trailcom.beans.TrailcomProcessorAccessBean trproc = new com.hps.july.trailcom.beans.TrailcomProcessorAccessBean();
		trproc.processDocument(new Integer(nAct.getDocument()));
		trproc.processDocument(new Integer(pAct.getDocument()));
		
		return null;
	}catch( Exception e ) { 
		throw new java.rmi.RemoteException( "While processing inventarization.", e );
	}
}
/**
 * Insert the method's description here.
 * Creation date: (18.11.2002 16:19:49)
 * @param ex com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param aSet java.util.ArrayList
 */
protected void recodeToI13Positions(DocumentProcessingException ex, ArrayList aSet) {
	ArrayList errs = ex.getPositionErrors();
	if (errs != null) {
		for( int i = 0; i < errs.size(); i++ ) {
			ProcessingPositionError err = (ProcessingPositionError)errs.get(i);
			// Find recode for position
			for( int j = 0; j < aSet.size(); j++ ) {
				StorageCellValueObject lstObj = (StorageCellValueObject)(aSet.get(j));
				if (lstObj.getVirtposition() != null)
					if (err.getPositionCode() == lstObj.getVirtposition().intValue()) {
						if (lstObj.getRealposition() != null)
							err.setPositionCode(lstObj.getRealposition().intValue());
						break;
					}
			}
		}
	}
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
