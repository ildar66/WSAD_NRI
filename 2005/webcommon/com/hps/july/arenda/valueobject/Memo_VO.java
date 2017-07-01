package com.hps.july.arenda.valueobject;

import com.hps.july.cdbc.lib.*;
import java.sql.Date;
import java.util.ArrayList;
/**
* контейнер "Служебной записки".
* Creation date: (22.07.2004 18:00:10)
* @author: Shafigullin Ildar
*/
public class Memo_VO {
    private java.lang.Integer idHeader; //Код служебной записки
    private java.lang.Integer abonentContract; //Абонентский договор
    private java.lang.String number; //Номер
    private Date date; //Дата
    private java.lang.Integer man; //Исполнитель
    private java.lang.String type; //Тип служебной записики
    private java.lang.Integer target; //Получатель служебной записки
    private java.lang.String usetype; //Признак учета
    private java.lang.String from; //С кого
    private java.lang.String to; //На кого
    private java.lang.Integer leasebill; //Абонентский счет
    private java.lang.String filename; //Имя файла
    private byte[] filetext; //Текст файла
    private java.lang.String state; //Состояние
    private java.lang.Integer arendaContract; //Договор аренды
    private PeopleVO manVO;
    private MemoTarget_VO targetVO;
    private OrganizationVO orgCustomer; //Организация Арендодатель
    private StoragePlaceVO positionVO;//Позиция размещения оборудования

/**
* определяет тип "Служебной записки".
* Creation date: (22.07.2004 18:00:10)
* @author: Shafigullin Ildar
*/
public static class MemoType {
    private String type;
    private String typeDescription;
    private java.util.ArrayList useTypes;
    private boolean isFrom = false;
    private boolean isTo = false;
    private boolean isArendaContract = true;
    private boolean isLeaseBill = false;
    private MemoPosInfo memoPosInfo;
    private MemoType(String aType) {
        type = aType;
        memoPosInfo = new MemoPosInfo(aType);
        initTypeDescription();
        if (type.equalsIgnoreCase("1")) {
            useTypes = new ArrayList(3);
            useTypes.add(Use_A);
            useTypes.add(Use_B);
            useTypes.add(Use_C);
        } else if (type.equalsIgnoreCase("2")) {
            useTypes = new ArrayList(4);
            useTypes.add(Use_A);
            useTypes.add(Use_B);
            useTypes.add(Use_C);
            useTypes.add(Use_E);
        } else if (type.equalsIgnoreCase("3")) {
            useTypes = new ArrayList(3);
            useTypes.add(Use_A);
            useTypes.add(Use_B);
            useTypes.add(Use_C);
        } else if (type.equalsIgnoreCase("5")) {
            useTypes = new ArrayList(3);
            useTypes.add(Use_A);
            useTypes.add(Use_B);
            useTypes.add(Use_C);
        } else if (type.equalsIgnoreCase("6")) {
            useTypes = new ArrayList(3);
            useTypes.add(Use_A);
            useTypes.add(Use_B);
            useTypes.add(Use_C);
            isTo = isFrom = true;
        } else if (type.equalsIgnoreCase("7")) {
            isArendaContract = false;
        } else if (type.equalsIgnoreCase("8")) {
            useTypes = new ArrayList(4);
            useTypes.add(Use_A);
            useTypes.add(Use_B);
            useTypes.add(Use_C);
            useTypes.add(Use_D);
        } else if (type.equalsIgnoreCase("B")) {
            isArendaContract = false;
        } else if (type.equalsIgnoreCase("A")) {
            isLeaseBill = true;
            isArendaContract = false;
        } else if (type.equalsIgnoreCase("C")) {
            isArendaContract = false;
        } else if (type.equalsIgnoreCase("D")) {
            useTypes = new ArrayList(3);
            useTypes.add(Use_A);
            useTypes.add(Use_B);
            useTypes.add(Use_C);
        } else if (type.equalsIgnoreCase("F")) {
            useTypes = new ArrayList(1);
            useTypes.add(Use_D);
        } else if (type.equalsIgnoreCase("J")) {
            isLeaseBill = true;
            isArendaContract = false;
        } else {
            useTypes = null;
        }
    }
    public java.lang.String getType() {
        return type;
    }
    public ArrayList getUseTypes() {
        return useTypes;
    }
    public boolean getIsFrom() {
        return isFrom;
    }
    public boolean getIsTo() {
        return isTo;
    }
    public boolean getIsArendaContract() {
        return isArendaContract;
    }
    public boolean getIsLeaseBill() {
        return isLeaseBill;
    }
    public String toString() {
        return typeDescription;
    }
    private void initTypeDescription() {
        if (type.equalsIgnoreCase("0"))
            typeDescription = "Прочее";
        else if (type.equalsIgnoreCase("1"))
            typeDescription = "Выдать SIM карты";
        else if (type.equalsIgnoreCase("2"))
            typeDescription = "Выдача карт на услуги сотовой связи";
        else if (type.equalsIgnoreCase("3"))
            typeDescription = "Замена SIM карт  (Восстановление)";
        else if (type.equalsIgnoreCase("4"))
            typeDescription = "Ремонт оборудования";
        else if (type.equalsIgnoreCase("5"))
            typeDescription = "Замена номера";
        else if (type.equalsIgnoreCase("6"))
            typeDescription = "Переоформление";
        else if (type.equalsIgnoreCase("7"))
            typeDescription = "Подключить услугу";
        else if (type.equalsIgnoreCase("8"))
            typeDescription = "Выдать оборудование";
        else if (type.equalsIgnoreCase("9"))
            typeDescription = "Изменить тарифный план";
        else if (type.equalsIgnoreCase("A"))
            typeDescription = "Возврат оборудования";
        else if (type.equalsIgnoreCase("B"))
            typeDescription = "Отключить услугу";
        else if (type.equalsIgnoreCase("C"))
            typeDescription = "Отключить телефоны";
        else if (type.equalsIgnoreCase("D"))
            typeDescription = "Доставка";
        else if (type.equalsIgnoreCase("E"))
            typeDescription = "Ремонт оборудования для с.д.";
        else if (type.equalsIgnoreCase("F"))
            typeDescription = "Выдать оборудование для с.д.";
        else if (type.equalsIgnoreCase("J"))
            typeDescription = "Возврат оборудования для с.д.";

        else
            typeDescription = type;
    }
    public MemoPosInfo getMemoPosInfo() {
        return memoPosInfo;
    }
    public String getTypeDescription() {
        return typeDescription;
    }
}

    private Memo_VO.MemoType memoType;

    /**
    * определяет Признак учета для "Служебной записки".
    * Creation date: (22.07.2004 18:00:10)
    * @author: Shafigullin Ildar
    */
    public static class UseType {
        private String label;
        private String value;
        private String printLabel;
        private UseType(String value, String label, String printLabel) {
            this.label = label;
            this.value = value;
            this.printLabel = printLabel;
        }
        public String getLabel() {
            return label;
        }
        public String getValue() {
            return value;
        }
        public String getPrintLabel() {
            return printLabel;
        }
    }
    public static Memo_VO.UseType Use_A = new Memo_VO.UseType("A", "в счет расчетов", "в счет расчетов");
    public static Memo_VO.UseType Use_B = new Memo_VO.UseType("B", "безналичный", "по безналичному расчету");
    public static Memo_VO.UseType Use_C = new Memo_VO.UseType("C", "наличный", "за наличный расчет");
    public static Memo_VO.UseType Use_D = new Memo_VO.UseType("D", "во временное пользование", "во временное пользование");
    public static Memo_VO.UseType Use_E = new Memo_VO.UseType("E", "бесплатно", "без оплаты");
    //список позиций:
    private java.util.ArrayList listMemoPos;
    private com.hps.july.arenda.valueobject.Memo_VO.UseType useTypeVO;
	private java.lang.String txtArendaContract;//Текстовый описание догвоора аренды
	private java.lang.Integer loanContract;//Ссудный договор
/**
 * Memo_VO constructor comment.
 */
public Memo_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2004 18:09:16)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public Memo_VO(CDBCRowObject ro) {
	idHeader = (Integer) ro.getColumn("idheader").asObject();
	setAbonentContract((Integer) ro.getColumn("abonentcontract").asObject());
	setNumber((String)ro.getColumn("number").asObject());
	setDate((Date)ro.getColumn("date").asObject());
	initMan(ro);
	setType((String)ro.getColumn("type").asObject());
	setTarget((Integer)ro.getColumn("target").asObject());
	setUsetype((String)ro.getColumn("usetype").asObject());
	setFrom((String)ro.getColumn("from").asObject());
	setTo((String)ro.getColumn("to").asObject());
	setLeasebill((Integer)ro.getColumn("leasebill").asObject());
	setFilename((String)ro.getColumn("filename").asObject());
	setFiletext((byte[])ro.getColumn("filetext").asObject());
	setState((String)ro.getColumn("state").asObject());
	setArendaContract((Integer)ro.getColumn("arendacontract").asObject());
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:47:35)
 * @return java.lang.Integer
 */
public java.lang.Integer getAbonentContract() {
	return abonentContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:55:45)
 * @return java.lang.Integer
 */
public java.lang.Integer getArendaContract() {
	return arendaContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:48:54)
 * @return java.sql.Date
 */
public Date getDate() {
	return date;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:53:35)
 * @return java.lang.String
 */
public java.lang.String getFilename() {
	return filename;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:54:21)
 * @return byte[]
 */
public byte[] getFiletext() {
	return filetext;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:52:08)
 * @return java.lang.String
 */
public java.lang.String getFrom() {
	return from;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:47:15)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdHeader() {
	return idHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:53:01)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeasebill() {
	return leasebill;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 17:39:53)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getListMemoPos() {
	return listMemoPos;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2005 11:16:47)
 * @return java.lang.Integer
 */
public java.lang.Integer getLoanContract() {
	return loanContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:49:54)
 * @return java.lang.Integer
 */
public java.lang.Integer getMan() {
	return man;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 12:31:09)
 * @return com.hps.july.arenda.valueobject.PeopleVO
 */
public PeopleVO getManVO() {
	return manVO;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2004 14:13:07)
 * @return com.hps.july.arenda.valueobject.Memo_VO.MemoType
 */
public com.hps.july.arenda.valueobject.Memo_VO.MemoType getMemoType() {
	return memoType;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:47:54)
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (14.02.2005 16:11:48)
 * @return com.hps.july.arenda.valueobject.OrganizationVO
 */
public OrganizationVO getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (14.02.2005 16:12:59)
 * @return com.hps.july.arenda.valueobject.StoragePlaceVO
 */
public StoragePlaceVO getPositionVO() {
    return positionVO;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:55:11)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:50:54)
 * @return java.lang.Integer
 */
public java.lang.Integer getTarget() {
	return target;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 15:23:24)
 * @return com.hps.july.arenda.valueobject.MemoTarget_VO
 */
public MemoTarget_VO getTargetVO() {
	return targetVO;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:52:31)
 * @return java.lang.String
 */
public java.lang.String getTo() {
	return to;
}
/**
 * Insert the method's description here.
 * Creation date: (14.02.2005 16:13:29)
 * @return java.lang.String
 */
public java.lang.String getTxtArendaContract() {
	return txtArendaContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:50:24)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:51:31)
 * @return java.lang.String
 */
public java.lang.String getUsetype() {
	return usetype;
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 14:46:01)
 * @return com.hps.july.arenda.valueobject.Memo_VO.UseType
 */
public com.hps.july.arenda.valueobject.Memo_VO.UseType getUseTypeVO() {
	return useTypeVO;
}
/**
 * Insert the method's description here.
 * Creation date: (14.02.2005 16:28:14)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public void initDetachInfo(CDBCRowObject ro) {
    initPosition(ro);
    initOrgCustomer(ro);
    setTxtArendaContract(ro.getColumn("txtarendacontract").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 12:16:34)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initMan(CDBCRowObject ro) {
	if ((Integer) ro.getColumn("man").asObject() != null) {
		setMan((Integer) ro.getColumn("man").asObject());
		setManVO(new PeopleVO(getMan()));
		getManVO().setName(ro.getColumn("namepeople").asString());
		getManVO().setPhone(ro.getColumn("phonepeople").asString());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (14.02.2005 16:35:48)
 */
private void initOrgCustomer(CDBCRowObject ro) {
    if (ro.getColumn("orgcustomer").asObject() != null) {
        OrganizationVO orgCust = new OrganizationVO((Integer) ro.getColumn("orgcustomer").asObject());
        orgCust.setShortname(ro.getColumn("orgcustomername").asString());
        orgCust.setInn(ro.getColumn("orgcustomerinn").asString());
        setOrgCustomer(orgCust);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2004 14:51:22)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
private void initPosition(CDBCRowObject ro) {
	Integer pos = (Integer) ro.getColumn("position").asObject();
	if (pos != null) {
		//setPosition(mainPos);
		StoragePlaceVO vo = new StoragePlaceVO(pos.intValue());
		vo.setName(ro.getColumn("positionname").asString());
		setPositionVO(vo);
	} else {
		setPositionVO(null);
	}

}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:47:35)
 * @param newAbonentContract java.lang.Integer
 */
public void setAbonentContract(java.lang.Integer newAbonentContract) {
	abonentContract = newAbonentContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:55:45)
 * @param newArendaContract java.lang.Integer
 */
public void setArendaContract(java.lang.Integer newArendaContract) {
	arendaContract = newArendaContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:48:54)
 * @param newDate java.sql.Date
 */
public void setDate(Date newDate) {
	date = newDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:53:35)
 * @param newFilename java.lang.String
 */
public void setFilename(java.lang.String newFilename) {
	filename = newFilename;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:54:21)
 * @param newFiletext byte[]
 */
public void setFiletext(byte[] newFiletext) {
	filetext = newFiletext;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:52:08)
 * @param newFrom java.lang.String
 */
public void setFrom(java.lang.String newFrom) {
	from = newFrom;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:47:15)
 * @param newIdHeader java.lang.Integer
 */
public void setIdHeader(java.lang.Integer newIdHeader) {
	idHeader = newIdHeader;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:53:01)
 * @param newLeasebill java.lang.Integer
 */
public void setLeasebill(java.lang.Integer newLeasebill) {
	leasebill = newLeasebill;
}
/**
 * Insert the method's description here.
 * Creation date: (01.09.2004 17:39:53)
 * @param newListMemoPos java.util.ArrayList
 */
public void setListMemoPos(java.util.ArrayList newListMemoPos) {
	listMemoPos = newListMemoPos;
}
/**
 * Insert the method's description here.
 * Creation date: (27.10.2005 11:16:47)
 * @param newLoanContract java.lang.Integer
 */
public void setLoanContract(java.lang.Integer newLoanContract) {
	loanContract = newLoanContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:49:54)
 * @param newMan java.lang.Integer
 */
public void setMan(java.lang.Integer newMan) {
	man = newMan;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 12:31:09)
 * @param newManVO com.hps.july.arenda.valueobject.PeopleVO
 */
public void setManVO(PeopleVO newManVO) {
	manVO = newManVO;
}
/**
 * Insert the method's description here.
 * Creation date: (29.07.2004 14:13:07)
 * @param newMemoType com.hps.july.arenda.valueobject.Memo_VO.MemoType
 */
private void setMemoType(com.hps.july.arenda.valueobject.Memo_VO.MemoType newMemoType) {
	memoType = newMemoType;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:47:54)
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (14.02.2005 16:11:48)
 * @param newOrgCustomer com.hps.july.arenda.valueobject.OrganizationVO
 */
public void setOrgCustomer(OrganizationVO newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (14.02.2005 16:12:59)
 * @param newMainpositionVO com.hps.july.arenda.valueobject.StoragePlaceVO
 */
public void setPositionVO(StoragePlaceVO newPositionVO) {
	positionVO = newPositionVO;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:55:11)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:50:54)
 * @param newTarget java.lang.Integer
 */
public void setTarget(java.lang.Integer newTarget) {
	target = newTarget;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2004 15:23:24)
 * @param newTargetVO com.hps.july.arenda.valueobject.MemoTarget_VO
 */
public void setTargetVO(MemoTarget_VO newTargetVO) {
	targetVO = newTargetVO;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:52:31)
 * @param newTo java.lang.String
 */
public void setTo(java.lang.String newTo) {
	to = newTo;
}
/**
 * Insert the method's description here.
 * Creation date: (14.02.2005 16:13:29)
 * @param newTxtArendaContract java.lang.String
 */
public void setTxtArendaContract(java.lang.String newTxtArendaContract) {
	txtArendaContract = newTxtArendaContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:50:24)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
	setMemoType(new MemoType(type));
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2004 11:51:31)
 * @param newUsetype java.lang.String
 */
public void setUsetype(java.lang.String newUsetype) {
	usetype = newUsetype;
	if ("A".equalsIgnoreCase(newUsetype))
		setUseTypeVO(Use_A);
	else if ("B".equalsIgnoreCase(newUsetype))
		setUseTypeVO(Use_B);
	else if ("C".equalsIgnoreCase(newUsetype))
		setUseTypeVO(Use_C);
	else if ("D".equalsIgnoreCase(newUsetype))
		setUseTypeVO(Use_D);
	else if ("E".equalsIgnoreCase(newUsetype))
		setUseTypeVO(Use_E);
	else
		setUseTypeVO(null);
}
/**
 * Insert the method's description here.
 * Creation date: (13.09.2004 14:46:01)
 * @param newUseTypeVO com.hps.july.arenda.valueobject.Memo_VO.UseType
 */
public void setUseTypeVO(com.hps.july.arenda.valueobject.Memo_VO.UseType newUseTypeVO) {
	useTypeVO = newUseTypeVO;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "Memo_VO: idHeader=" + idHeader + "; Number= " + getNumber() + "; type= " + getType() + "; manVO=" + getManVO();
}
}
