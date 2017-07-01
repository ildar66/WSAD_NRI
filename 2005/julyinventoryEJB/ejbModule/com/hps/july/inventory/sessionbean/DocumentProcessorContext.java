package com.hps.july.inventory.sessionbean;

import java.math.*;
import java.util.*;
import com.hps.july.persistence.*;
/**
 * Insert the type's description here.
 * Creation date: (12.09.2002 16:10:02)
 * @author: Oleg Gashnikov
 */
public class DocumentProcessorContext {
	ArrayList updatedBulkCards = new ArrayList();
	ArrayList updatedPartyCards = new ArrayList();
/**
 * DocumentProcessorContext constructor comment.
 */
public DocumentProcessorContext() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 17:36:19)
 * @return com.hps.july.persistence.StorageCardAccessBean
 * @param resource int
 * @param storage int
 * @param owner int
 * @exception java.lang.Exception The exception description.
 */
public StorageCardAccessBean getBulkCard(int resource, int storage, int owner) throws java.lang.Exception {
	StorageCardAccessBean ret = null;
	for( int i = 0; i < updatedBulkCards.size(); i++ ) {
		StorageCardAccessBean card = (StorageCardAccessBean)(updatedBulkCards.get( i ));
		if( card.getResourceKey().resource == resource && card.getCurrentstorageKey().storageplace == storage &&
			card.getOwnerKey().organization == owner ) {
				return card;
			}
	}
	return  (new StorageCardAccessBean()).findByStorageOwnerResource( new Integer(storage),
		new Integer( owner ), new Integer( resource ) );
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 17:36:19)
 * @return com.hps.july.persistence.StorageCardAccessBean
 * @param resource int
 * @param storage int
 * @param owner int
 * @exception java.lang.Exception The exception description.
 */
public StorageCardAccessBean getPartyCard(String party, int storage, int owner) throws java.lang.Exception {
	StorageCardAccessBean ret = null;
	for( int i = 0; i < updatedPartyCards.size(); i++ ) {
		StorageCardAccessBean card = (StorageCardAccessBean)(updatedPartyCards.get( i ));
		if( card.getParty().equals( party )  && card.getCurrentstorageKey().storageplace == storage &&
			card.getOwnerKey().organization == owner ) {
				return card;
			}
	}
	return (new StorageCardAccessBean()).findByStorageOwnerParty( new Integer(storage),
		new Integer( owner ), party ); 
}
/**
 * Insert the method's description here.
 * Creation date: (12.09.2002 17:24:18)
 * @param card com.hps.july.persistence.StorageCardAccessBean
 */
public void registerStorageCard(StorageCardAccessBean card) throws Exception {
	if( card.getPolicy().equals("B") ) {
		updatedBulkCards.add( card );
	} else if( card.getPolicy().equals("P") ) {
		updatedPartyCards.add( card );
	}
}
}
