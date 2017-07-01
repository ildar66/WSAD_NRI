package com.hps.july.arenda.valueobject;

/**
 * Insert the type's description here.
 * Creation date: (28.05.2005 12:13:09)
 * @author: Shafigullin Ildar
 */
public class LicenciesShowColumn {
    private boolean isFas;
    private boolean isRutsr;
    private boolean isAir_gr;
    private boolean isAir_w;
    private boolean isGps;
    private boolean isGasn;
    private boolean isSes;
    private boolean isVch;
    private boolean isTu;
    private boolean isOtvod;
    private boolean isKadastr;
    private boolean isProperty;

    //public final static public "name" LicenciesShowColumn(isFas, iRutsr, isAir_gr, isAir_w, isGps, isGasn, isSes, isVch, isTu, isOtvod, isKadastr, isProperty);
    public final static LicenciesShowColumn forAdmin  = new LicenciesShowColumn(true, true,  true,  true,  true, true,  true,  true,  true,  true,  true,  true);
    public final static LicenciesShowColumn forLcsEditAllLicence = new LicenciesShowColumn(true, true,  true,  true,  true, true,  true,  true,  true,  true,  true,  true);
    public final static LicenciesShowColumn forLcsEditFAS  = new LicenciesShowColumn(true, true,  true,  true,  false, false,  false, true,  false,  false,  false,  false);
    public final static LicenciesShowColumn forLcsEditGPS = new LicenciesShowColumn(false, false,  false,  false,  true, false,  false,  false,  false,  false,  false,  false);
    public final static LicenciesShowColumn forLcsEditGASN = new LicenciesShowColumn(false, false,  false,  false,  false, true,  false,  false,  false,  false,  false,  false);
    public final static LicenciesShowColumn forLcsEditSES = new LicenciesShowColumn(false, false,  false,  false,  false, false,  true,  false,  false,  false,  false,  false);
    public final static LicenciesShowColumn forLcsEditElectro = new LicenciesShowColumn(false, false,  false,  false,  false, false,  false,  false,  true,  false,  false,  false);
    public final static LicenciesShowColumn forLcsEditLand = new LicenciesShowColumn(false, false,  false,  false,  false, false,  false,  false,  false,  true,  true,  false);
    public final static LicenciesShowColumn forLcsEditProperty = new LicenciesShowColumn(false, false,  false,  false,  false, false,  false,  false,  false,  false,  false,  true);
    
	private boolean isEdit = true;
/**
 * Insert the method's description here.
 * Creation date: (30.05.2005 13:15:28)
 */
public LicenciesShowColumn() {}
/**
 * LicenciesShowColumn constructor comment.
 */
public LicenciesShowColumn(
    boolean iFas,
    boolean iRutsr,
    boolean iAir_gr,
    boolean iAir_w,
    boolean iGps,
    boolean iGasn,
    boolean iSes,
    boolean iVch,
    boolean iTu,
    boolean iOtvod,
    boolean iKadastr,
    boolean iProperty) {
    super();
    isFas = iFas;
    isRutsr = iRutsr;
    isAir_gr = iAir_gr;
    isAir_w = iAir_w;
    isGps = iGps;
    isGasn = iGasn;
    isSes = iSes;
    isVch = iVch;
    isTu = iTu;
    isOtvod = iOtvod;
    isKadastr = iKadastr;
    isProperty = iProperty;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsAir_gr() {
	return isAir_gr;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsAir_w() {
	return isAir_w;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 11:20:59)
 * @return boolean
 */
public boolean getIsEdit() {
	return isEdit;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:14:20)
 * @return boolean
 */
public boolean getIsFas() {
	return isFas;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsGasn() {
	return isGasn;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsGps() {
	return isGps;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsKadastr() {
	return isKadastr;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsOtvod() {
	return isOtvod;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsProperty() {
	return isProperty;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsRutsr() {
	return isRutsr;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsSes() {
	return isSes;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsTu() {
	return isTu;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2005 12:19:31)
 * @return boolean
 */
public boolean getIsVch() {
	return isVch;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2005 13:05:01)
 */
public void or(LicenciesShowColumn lsc) {
    if (lsc.getIsFas())
        isFas = true;
    if (lsc.getIsRutsr())
        isRutsr = true;
    if (lsc.getIsAir_gr())
        isAir_gr = true;
    if (lsc.getIsAir_w())
        isAir_w = true;
    if (lsc.getIsGps())
        isGps = true;
    if (lsc.getIsGasn())
        isGasn = true;
    if (lsc.getIsSes())
        isSes = true;
    if (lsc.getIsVch())
        isVch = true;
    if (lsc.getIsTu())
        isTu = true;
    if (lsc.getIsOtvod())
        isOtvod = true;
    if (lsc.getIsKadastr())
        isKadastr = true;
    if (lsc.getIsProperty())
        isProperty = true;
}
/**
 * Insert the method's description here.
 * Creation date: (01.06.2005 11:20:59)
 * @param newIsEdit boolean
 */
public void setIsEdit(boolean newIsEdit) {
	isEdit = newIsEdit;
}
}
