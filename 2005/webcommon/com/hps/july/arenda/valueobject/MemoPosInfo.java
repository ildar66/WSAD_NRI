package com.hps.july.arenda.valueobject;

/**
 * контейнер-фильтр "для Позиции служебной записки".
 * Creation date: (27.08.2004 15:33:16)
 * @author: Shafigullin Ildar
 */
public class MemoPosInfo {
	private boolean isIdPos; //Код позиции
	private boolean isIdHeader; //Код служебной записки
	private boolean isPhoneNumber; //Избирательный номер
	private boolean isTarifplan; //Тарифный план
	private boolean isComcardcnt; //Количество карт связи
	private boolean isCardamount; //Номинал карт
	private boolean isSimcardcnt; //Количество SIM карт
	private boolean isEquipname; //Наименование оборудования
	private boolean isEquipcnt; //Количество оборудования
	private boolean isDefectdescr; //Описание дефекта оборудования
	private boolean isService; //Услуга для подключения
	private boolean isOpertype; //Тип операции подключения
	private boolean isStartdate; //Дата начала
	private boolean isEnddate; //Дата окончания
	private boolean isGarantie; //Взимание гарантийного взноса
	private boolean isCardname; //Наименование карты услуг связи
	private boolean isBilldelivery;//Тип доставки счета
	private boolean isBilladdress;//Адрес доставки счета
/**
 * MemoPosInfo constructor comment.
 */
public MemoPosInfo() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:45:47)
 * @param memoTypeStr java.lang.String
 */
public MemoPosInfo(String memoTypeStr) {
    if (memoTypeStr.equalsIgnoreCase("0")) {
        isPhoneNumber = isTarifplan = isComcardcnt = isCardamount = isSimcardcnt = isEquipname = isEquipcnt = true;
        isDefectdescr = isService = isOpertype = isStartdate = isEnddate = isGarantie = isCardname = true;
    } else if (memoTypeStr.equalsIgnoreCase("1")) {
        isSimcardcnt = isTarifplan = isGarantie = isService = true;
    } else if (memoTypeStr.equalsIgnoreCase("2")) {
        isCardamount = isComcardcnt = isCardname = true;
    } else if (memoTypeStr.equalsIgnoreCase("3")) {
        isPhoneNumber = true;
    } else if (memoTypeStr.equalsIgnoreCase("4")) {
        isEquipcnt = isEquipname = isDefectdescr = true;
    } else if (memoTypeStr.equalsIgnoreCase("5")) {
        isPhoneNumber = true;
    } else if (memoTypeStr.equalsIgnoreCase("6")) {
        isPhoneNumber = true;
    } else if (memoTypeStr.equalsIgnoreCase("7")) {
        isPhoneNumber = isService = isStartdate = isEnddate = isGarantie = true;
    } else if (memoTypeStr.equalsIgnoreCase("8")) {
        isEquipcnt = isEquipname = true;
    } else if (memoTypeStr.equalsIgnoreCase("9")) {
        isPhoneNumber = isTarifplan = isStartdate = true;
    } else if (memoTypeStr.equalsIgnoreCase("A")) {
        isEquipcnt = isEquipname = true;
    } else if (memoTypeStr.equalsIgnoreCase("B")) {
        isPhoneNumber = isService = isStartdate = true;
    } else if (memoTypeStr.equalsIgnoreCase("C")) {
        isPhoneNumber = true;
    } else if (memoTypeStr.equalsIgnoreCase("D")) {
        isPhoneNumber = isService = isStartdate = isEnddate = isBilldelivery = isBilladdress = true;
    } else if (memoTypeStr.equalsIgnoreCase("E")) {
        isEquipcnt = isEquipname = isDefectdescr = true;
    } else if (memoTypeStr.equalsIgnoreCase("F")) {
        isEquipcnt = isEquipname = true;
    } else if (memoTypeStr.equalsIgnoreCase("J")) {
        isEquipcnt = isEquipname = true;        
    }
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2005 16:27:31)
 * @return boolean
 */
public boolean isIsBilladdress() {
	return isBilladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2005 16:26:53)
 * @return boolean
 */
public boolean isIsBilldelivery() {
	return isBilldelivery;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsCardamount() {
	return isCardamount;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsCardname() {
	return isCardname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsComcardcnt() {
	return isComcardcnt;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsDefectdescr() {
	return isDefectdescr;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsEnddate() {
	return isEnddate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsEquipcnt() {
	return isEquipcnt;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsEquipname() {
	return isEquipname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsGarantie() {
	return isGarantie;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsIdHeader() {
	return isIdHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsIdPos() {
	return isIdPos;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsOpertype() {
	return isOpertype;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsPhoneNumber() {
	return isPhoneNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsService() {
	return isService;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsSimcardcnt() {
	return isSimcardcnt;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsStartdate() {
	return isStartdate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.08.2004 15:41:13)
 * @return boolean
 */
public boolean isIsTarifplan() {
	return isTarifplan;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2005 16:27:31)
 * @param newIsBilladdress boolean
 */
public void setIsBilladdress(boolean newIsBilladdress) {
	isBilladdress = newIsBilladdress;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2005 16:26:53)
 * @param newIsBilldelivery boolean
 */
public void setIsBilldelivery(boolean newIsBilldelivery) {
	isBilldelivery = newIsBilldelivery;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	// This implementation forwards the message to super. You may replace or supplement this.
	return super.toString();
}
}
