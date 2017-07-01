package com.hps.july.platinum.sessionbean;

/**
 * Insert the type's description here.
 * Creation date: (20.12.2002 17:32:25)
 * @author: Dmitry Dneprov
 */
public class ERRORTYPES {
	public static final int NO_PROCESSING_REQ			= 1000;	// No processing required
	public static final int DETERMINE_STORAGE_REQ		= 1001;	// We need to determine storage as we are expeditor
	public static final int NO_DETERMINE_STORAGE_REQ	= 1002;	// We do not need to determine storage
	public static final int TOO_MANY_OWNERS				= 1003;	// Too many owners for positions in external document
	public static final int CANT_DETERMINE_STORAGE		= 1004;	// Cannot determine real storage
	public static final int RESOURCES_REQUEST			= 1005;	// I- Resource request
	public static final int STORAGEPLACES_REQUEST		= 1006;	// I- Storageplaces request
	public static final int USERS_REQUEST				= 1007;	// I- Users request
	public static final int VALUTES_REQUEST				= 1008;	// I- Valutes request
	public static final int NO_CONTRACT					= 1009;	// No contract for inwaybill
}
