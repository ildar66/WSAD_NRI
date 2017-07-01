package com.hps.july.inventory.sessionbean;

/**
 * Insert the type's description here.
 * Creation date: (30.05.2002 13:36:17)
 * @author: Oleg Gashnikov
 */
public class ProcessingPositionError implements java.io.Serializable {
	private int errorCode;
	private java.lang.String message;
//	private com.hps.july.persistence.DocumentPositionAccessBean position;
public static class ERRORS {
	public static final int BAD_AGREGATION 				= 1;
	public static final int INVENTARIZATION_BEFORE 	= 2;
	public static final int NOTENOUGHQTY 					= 3;
	public static final int CARD_CLOSED 					= 4;
	public static final int NOT_THE_SAME_OWNER 		= 5;
	public static final int NOT_THE_SAME_STATE 		= 6;
	public static final int NO_SUCH_PARTY 				= 7;
	public static final int NOT_SUCH_PRODUCT 			= 8;
	public static final int UNKNOWN_POLICY 				= 9;
	public static final int LOST_AGRAGATE 				= 10;
	public static final int NO_CARD								= 11;
	public static final int NOT_IN_STORAGE				= 12;
	public static final int CARD_ALREADY_EXISTS		= 13;
	public static final int POSITION_HIDDEN				= 14;
	public static final int NOT_THE_SAME_RESOURCE	= 15;
	public static final int NOT_THE_SAME_PRICE		= 16;
	public static final int CARD_IS_BOXED					= 17;
	public static final int CARD_ALREADY_BOUND		= 18;
	public static final int BAD_AGREGATION_QTY 		= 19;
	public static final int BAD_AGREGATION_NOTSUPPORTED	= 20;
	public static final int BAD_AGREGATION_NOTEXISTS	= 21;
	public static final int INVALID_RESOURCE	= 22; // Resource is not present in resource list (inventarization)
	public static final int DUPLICATE_SERIAL	= 23; // Serial number is duplicated in docpositions
	public static final int HEAD_NOT_IN_STORAGE	= 24; // Head agregate is in another storage
	public static final int NOT_THE_SAME_DOC_OWNER = 25; // Owner in document differs from owner in docposition
	public static final int NO_SERIAL		= 26;
	public static final int DUPLICATE_PARTY	= 27; // Party number is duplicated in docpositions
	public static final int DUPLICATE_RESOURCE	= 28; // Resource is duplicated in docpositions
	public static final int UNAPPROVED_DOCUMENT	= 29; // Unapproved document exists and prevents to perform operation
	public static final int APPROVED_DOCUMENT	= 30; // Approved document exists and prevents to perform operation
	public static final int CONFIG_CHANGED	= 31; // Configuration have been already changed, so document based on old configuration cannot be applied
}
	private java.sql.Date I13nDate;
	private java.math.BigDecimal qty;
//	public com.hps.july.persistence.AgregateContentAccessBean agregationLink;
	public java.lang.String serial;
	public int storage;
	public int owner;
	public java.lang.Boolean cardBoxed;
	public java.lang.Boolean cardBroken;
	public java.lang.String party;
	public int lastDocumentCode;
	public int resource;
	private int i13nAct;
	private int positionCode;
	private java.math.BigDecimal price;
	private int storagecard;
	private int errorLevel;
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 10:09:41)
 * @return com.hps.july.persistence.AgregateContentAccessBean
 */
//public com.hps.july.persistence.AgregateContentAccessBean getAgregationLink() {
//	return agregationLink;
//}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:20:05)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCardBoxed() {
	return cardBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:20:23)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCardBroken() {
	return cardBroken;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:53:37)
 * @return int
 */
public int getErrorCode() {
	return errorCode;
}
/**
 * Уровень критичности ошибки
 * 1 - серьезная, требует вмешательства пользователя
 * 2 - может быть устранена автоматически.
 * Creation date: (27.09.2004 20:43:06)
 * @return int
 */
public int getErrorLevel() {
	return errorLevel;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2002 18:22:00)
 * @return int
 */
public int getI13nAct() {
	return i13nAct;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 13:13:24)
 * @return java.sql.Date
 */
public java.sql.Date getI13nDate() {
	return I13nDate;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:43:49)
 * @return int
 */
public int getLastDocumentCode() {
	return lastDocumentCode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:54:00)
 * @return java.lang.String
 */
public java.lang.String getMessage() {
	return message;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:19:28)
 * @return int
 */
public int getOwner() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:21:38)
 * @return java.lang.String
 */
public java.lang.String getParty() {
	return party;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:55:01)
 * @return com.hps.july.persistence.DocumentPositionAccessBean
 */
//public com.hps.july.persistence.DocumentPositionAccessBean getPosition() {
//	return position;
//}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:49:44)
 * @return int
 */
public int getPositionCode() {
	return positionCode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 12:20:34)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 13:14:55)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty() {
	return qty;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 14:33:09)
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:15:10)
 * @return java.lang.String
 */
public java.lang.String getSerial() {
	return serial;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:18:40)
 * @return int
 */
public int getStorage() {
	return storage;
}
/**
 * Insert the method's description here.
 * Creation date: (21.09.2004 17:38:29)
 * @return java.lang.Integer
 */
public int getStoragecard() {
	return storagecard;
}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 16:10:00)
 * @param out java.io.PrintWriter
 */
public void print(java.io.PrintWriter out) {
	out.println( "TESTMSG>>Error code 	\t\t="+errorCode );
	out.println( "TESTMSG>>Card boxed	\t\t="+cardBoxed );
	out.println( "TESTMSG>>Card broken	\t\t="+cardBroken );
	out.println( "TESTMSG>>i13nAct		\t\t="+i13nAct );
	out.println( "TESTMSG>>i13nDate		\t\t="+I13nDate );
	out.println( "TESTMSG>>lastDocumentCode\t\t="+lastDocumentCode );
	out.println( "TESTMSG>>message		\t\t="+message );
	out.println( "TESTMSG>>owner			\t\t="+owner );
	out.println( "TESTMSG>>party			\t\t="+party );
//	out.println( "TESTMSG>>position		\t\t="+position );
	out.println( "TESTMSG>>position code	\t\t="+positionCode );
	out.println( "TESTMSG>>qty			\t\t="+qty );
	out.println( "TESTMSG>>resource		\t\t="+resource );
	out.println( "TESTMSG>>serial		\t\t="+serial );
	out.println( "TESTMSG>>storage		\t\t="+storage );
	out.println( "TESTMSG>>price  		\t\t="+price );
	}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 10:09:41)
 * @param newAgregationLink com.hps.july.persistence.AgregateContentAccessBean
 */
//public void setAgregationLink(com.hps.july.persistence.AgregateContentAccessBean newAgregationLink) {
//	agregationLink = newAgregationLink;
//}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:20:05)
 * @param newCardBoxed java.lang.Boolean
 */
public void setCardBoxed(java.lang.Boolean newCardBoxed) {
	cardBoxed = newCardBoxed;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:20:23)
 * @param newCardBroken java.lang.Boolean
 */
public void setCardBroken(java.lang.Boolean newCardBroken) {
	cardBroken = newCardBroken;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:53:37)
 * @param newErrorCode int
 */
public void setErrorCode(int newErrorCode) {
	errorCode = newErrorCode;
}
/**
 * Уровень критичности ошибки
 * 1 - серьезная, требует вмешательства пользователя
 * 2 - может быть устранена автоматически.
 * Creation date: (27.09.2004 20:43:06)
 * @param newErrorLevel int
 */
public void setErrorLevel(int newErrorLevel) {
	errorLevel = newErrorLevel;
}
/**
 * Insert the method's description here.
 * Creation date: (20.06.2002 18:22:00)
 * @param newI13nAct int
 */
public void setI13nAct(int newI13nAct) {
	i13nAct = newI13nAct;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 13:13:24)
 * @param newI13nDate java.sql.Date
 */
public void setI13nDate(java.sql.Date newI13nDate) {
	I13nDate = newI13nDate;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:43:49)
 * @param newLastDocumentCode int
 */
public void setLastDocumentCode(int newLastDocumentCode) {
	lastDocumentCode = newLastDocumentCode;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:54:00)
 * @param newMessage java.lang.String
 */
public void setMessage(java.lang.String newMessage) {
	message = newMessage;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:19:28)
 * @param newOwner int
 */
public void setOwner(int newOwner) {
	owner = newOwner;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:21:38)
 * @param newParty java.lang.String
 */
public void setParty(java.lang.String newParty) {
	party = newParty;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 11:55:01)
 * @param newPosition com.hps.july.persistence.DocumentPositionAccessBean
 */
//public void setPosition(com.hps.july.persistence.DocumentPositionAccessBean newPosition) {
//	position = newPosition;
//}
/**
 * Insert the method's description here.
 * Creation date: (01.07.2002 13:49:44)
 * @param newPositionCode int
 */
public void setPositionCode(int newPositionCode) {
	positionCode = newPositionCode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.07.2002 12:20:34)
 * @param newPrice java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newPrice) {
	price = newPrice;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2002 13:14:55)
 * @param newQty java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newQty) {
	qty = newQty;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 14:33:09)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:15:10)
 * @param newSerial java.lang.String
 */
public void setSerial(java.lang.String newSerial) {
	serial = newSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (07.06.2002 13:18:40)
 * @param newStorage int
 */
public void setStorage(int newStorage) {
	storage = newStorage;
}
/**
 * Insert the method's description here.
 * Creation date: (21.09.2004 17:38:29)
 * @param newStoragecard java.lang.Integer
 */
public void setStoragecard(int newStoragecard) {
	storagecard = newStoragecard;
}
}
