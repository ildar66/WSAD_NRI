package com.hps.july.inventory.formbean;

/**
 * Добавление акта монтажа АФС для антенн диапазона 900.
 * Creation date: (29.11.2004 17:31:09)
 * @author: Dmitry Dneprov
 */
public class AfsMountAct3Form extends AfsMountAct2Form {
/**
 * Текущее состояние приложения.
 * Creation date: (15.10.2004 17:26:12)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.AFSEDIT22;
}

protected void doInitfields(javax.servlet.http.HttpServletRequest request) {
	setSectorA("E");
	setSectorB("F");
	AfsMountAct2Form form1800 = (AfsMountAct2Form)request.getSession().getAttribute("AfsMountAct2Form");
	setIndiap(form1800.getIndiap());
	setUser(form1800.getUser());
	setIsAdmin(form1800.getIsAdmin());
	setPosnumber(form1800.getPosnumber());
	setOldposnumber(getPosnumber());
	setComplectcode(form1800.getComplectcode());
	setComplectname(form1800.getComplectname());
	setManycomplects(form1800.isManycomplects());
	setOldposnumber(form1800.getOldposnumber());
	setDiffs(form1800.getDiffs());
		
	if ((form1800.getResource10() != null) && isTwoDiapAntenn(form1800.getResource10().intValue())) {
		setResource10(form1800.getResource10());
		setSerial10A(form1800.getSerial10A());
		setSerial10B(form1800.getSerial10B());
		setSerial10C(form1800.getSerial10C());
		setNaklA(form1800.getNaklA());
		setAzimA(form1800.getAzimA());
		setHsetA(form1800.getHsetA());
	}
	if ((form1800.getResource20() != null) && isTwoDiapAntenn(form1800.getResource20().intValue())) {
		setResource20(form1800.getResource20());
		setSerial20A(form1800.getSerial20A());
		setSerial20B(form1800.getSerial20B());
		setSerial20C(form1800.getSerial20C());
		setNaklB(form1800.getNaklB());
		setAzimB(form1800.getAzimB());
		setHsetB(form1800.getHsetB());
	}
	if ((form1800.getResource30() != null) && isTwoDiapAntenn(form1800.getResource30().intValue())) {
		setResource30(form1800.getResource30());
		setSerial30A(form1800.getSerial30A());
		setSerial30B(form1800.getSerial30B());
		setSerial30C(form1800.getSerial30C());
		setNaklC(form1800.getNaklC());
		setAzimC(form1800.getAzimC());
		setHsetC(form1800.getHsetC());
	}
	if ((form1800.getResource40() != null) && isTwoDiapAntenn(form1800.getResource40().intValue())) {
		setResource40(form1800.getResource40());
		setSerial40A(form1800.getSerial40A());
		setSerial40B(form1800.getSerial40B());
		setSerial40C(form1800.getSerial40C());
		setNaklD(form1800.getNaklD());
		setAzimD(form1800.getAzimD());
		setHsetD(form1800.getHsetD());
	}
		
		
	setComcabAA(form1800.isComcabAA());
	setComcabAB(form1800.isComcabAB());
	setComcabAC(form1800.isComcabAC());
	setComcabBA(form1800.isComcabBA());
	setComcabBB(form1800.isComcabBB());
	setComcabBC(form1800.isComcabBC());
	setComcabCA(form1800.isComcabCA());
	setComcabCB(form1800.isComcabCB());
	setComcabCC(form1800.isComcabCC());
	setComcabDA(form1800.isComcabDA());
	setComcabDB(form1800.isComcabDB());
	setComcabDC(form1800.isComcabDC());

	if (form1800.isComcabAA()) {
		setGndcntAA(form1800.getGndcntAA());
		setQty50AA(form1800.getQty50AA());
		setSerial50AA(form1800.getSerial50AA());
	}
	if (form1800.isComcabAB()) {
		setGndcntAB(form1800.getGndcntAB());
		setQty50AB(form1800.getQty50AB());
		setSerial50AB(form1800.getSerial50AB());
	}
	if (form1800.isComcabAC()) {
		setGndcntAC(form1800.getGndcntAC());
		setQty50AC(form1800.getQty50AC());
		setSerial50AC(form1800.getSerial50AC());
	}
		
	if (form1800.isComcabBA()) {
		setGndcntBA(form1800.getGndcntBA());
		setQty50BA(form1800.getQty50BA());
		setSerial50BA(form1800.getSerial50BA());
	}
	if (form1800.isComcabBB()) {
		setGndcntBB(form1800.getGndcntBB());
		setQty50BB(form1800.getQty50BB());
		setSerial50BB(form1800.getSerial50BB());
	}
	if (form1800.isComcabBC()) {
		setGndcntBC(form1800.getGndcntBC());
		setQty50BC(form1800.getQty50BC());
		setSerial50BC(form1800.getSerial50BC());
	}
		
	if (form1800.isComcabCA()) {
		setGndcntCA(form1800.getGndcntCA());
		setQty50CA(form1800.getQty50CA());
		setSerial50CA(form1800.getSerial50CA());
	}
	if (form1800.isComcabCB()) {
		setGndcntCB(form1800.getGndcntCB());
		setQty50CB(form1800.getQty50CB());
		setSerial50CB(form1800.getSerial50CB());
	}
	if (form1800.isComcabCC()) {
		setGndcntCC(form1800.getGndcntCC());
		setQty50CC(form1800.getQty50CC());
		setSerial50CC(form1800.getSerial50CC());
	}
		
	if (form1800.isComcabDA()) {
		setGndcntDA(form1800.getGndcntDA());
		setQty50DA(form1800.getQty50DA());
		setSerial50DA(form1800.getSerial50DA());
	}
	if (form1800.isComcabDB()) {
		setGndcntDB(form1800.getGndcntDB());
		setQty50DB(form1800.getQty50DB());
		setSerial50DB(form1800.getSerial50DB());
	}
	if (form1800.isComcabDC()) {
		setGndcntDC(form1800.getGndcntDC());
		setQty50DC(form1800.getQty50DC());
		setSerial50DC(form1800.getSerial50DC());
	}

	Integer defcabtype = new Integer(com.hps.july.util.AppUtils.getNamedValueInt("AntennaCableType"));
		
	if (isComcabAA() || isComcabAB() || isComcabAC())
		setResource50A(form1800.getResource50A());
	else
		setResource50A(defcabtype);
			
	if (isComcabBA() || isComcabBB() || isComcabBC())
		setResource50B(form1800.getResource50B());
	else
		setResource50B(defcabtype);
			
	if (isComcabCA() || isComcabCB() || isComcabCC())
		setResource50C(form1800.getResource50C());
	else
		setResource50C(defcabtype);
			
	if (isComcabDA() || isComcabDB() || isComcabDC())
		setResource50D(form1800.getResource50D());
	else
		setResource50D(defcabtype);

	//  InDiap:    1 - 1800 only
	//                   2 - 900   only
	//                   3 - 1800/900
	if ( (getIndiap() == 2) || (getIndiap() == 3) )
		setDiap("900");
	else
		setDiap("1800");
	setOwnercode(form1800.getOwnercode());
	setActdate(form1800.getActdate());
	setInsuranceMan(form1800.getInsuranceMan());
	setProvidercode(form1800.getProvidercode());
	setProvidername(form1800.getProvidername());
	setWorkercode(form1800.getWorkercode());
	setWorkername(form1800.getWorkername());
	setWorkertitle(form1800.getWorkertitle());
	//System.out.println("AFS3 - INIT, posnumber=" + getPosnumber());
}

/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	if ( (getIndiap() == 1) || (getIndiap() == 2) ) {
		super.initRecord(request);
	} else {
		doInitfields(request);
	}
}

public void loadRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	preloadRecord();
	String reqState = getProcessState();
	if (!("C".equalsIgnoreCase(reqState) || "P".equalsIgnoreCase(reqState) || "Edit".equals(getAction()))) 
		super.loadRecord(request);
	if ( (getIndiap() == 1) || (getIndiap() == 2) ) {
		// No action
	} else {
		doInitfields(request);
	}
	if ("C".equalsIgnoreCase(reqState) || "P".equalsIgnoreCase(reqState) || "Edit".equals(getAction()) ) 
		super.loadRecord(request);
}

}
