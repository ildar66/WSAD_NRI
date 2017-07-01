package com.hps.july.basestation.formbean;

import org.apache.struts.action.*;
import com.hps.july.web.util.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.*;
import com.hps.july.basestation.valueobject.*;
/**
* "Сектора базовых станций на позиции".
* Creation date: (08.08.2005 17:23:49)
* @author: Shafigullin Ildar
*/
public class SectorDialogForm extends com.hps.july.web.util.EditForm {
    private int id_sect;
    private com.hps.july.basestation.valueobject.Sector_VO vo;
    private boolean flagOperation;
    private int equipment;
    private BaseStationAccessBean baseStation;
    private java.lang.String lett;
    private java.lang.Integer index; //Индекс рег.	
	private java.lang.Integer prefixCelliD;
	private int positionID;
	private java.lang.String bsName;
	private java.lang.String stationType;
/**
 * Текущее приложение.
 * Creation date: (08.08.2005 17:23:49)
 * @return int
 */
public int getApplication() {
    return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 14:59:37)
 */
public String getAzimutStr() {
    if (vo != null && vo.getAzimut() != null)
        return vo.getAzimut().toString();
    else
        return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 11:47:40)
 * @return com.hps.july.persistence.BaseStationAccessBean
 */
private com.hps.july.persistence.BaseStationAccessBean getBaseStation() {
	return baseStation;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 17:20:38)
 * @return java.lang.String
 */
public java.lang.String getBsName() {
	return bsName;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 16:19:07)
 * @return int
 */
public int getEquipment() {
	return equipment;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 19:06:17)
 * @return int
 */
public int getId_sect() {
	return id_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 12:46:19)
 * @return java.lang.Integer
 */
public java.lang.Integer getIndex() {
	return index;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 14:08:30)
 */
public java.lang.String getIndexRR() {
    if (getPrefixCelliD() != null) {
        String num = String.valueOf(getPrefixCelliD().intValue());
        if (num != null) {
            int end = num.length() - 2;
            int start1 = end - 2;
            int start2 = end - 1;
            if (end >= 0 && start1 >= 0)
                return num.substring(start1, end);
            else if (end >= 0 && start2 >= 0)
                return num.substring(start2, end);
        }
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 14:09:41)
 */
public java.lang.String getIndexXX() {
    if (getPrefixCelliD() != null) {
        String num = String.valueOf(getPrefixCelliD().intValue());
        if (num != null) {
            int end = num.length();
            int start1 = end - 2;
            int start2 = end - 1;
            if (end >= 0 && start1 >= 0)
                return num.substring(start1, end);
            else if (end >= 0 && start2 >= 0)
                return num.substring(start2, end);
        }
    }
    return null;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:55:38)
 * @return java.lang.String
 */
public java.lang.String getLett() {
	return lett;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 13:53:45)
 * @return int
 */
public int getPositionID() {
	return positionID;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 13:28:28)
 * @return java.lang.Integer
 */
public java.lang.Integer getPrefixCelliD() {
	return prefixCelliD;
}
/**
 * Текущее состояние приложения.
 * Creation date: (08.08.2005 17:23:49)
 * @return int
 */
public int getState() {
	return com.hps.july.basestation.APPStates.SECTOR_DIALOG_FORM;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 17:27:14)
 * @return java.lang.String
 */
public java.lang.String getStationType() {
	return stationType;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 14:59:37)
 */
public String getTx_pwrStr() {
    if (vo != null && vo.getTx_pwr() != null)
        return vo.getTx_pwr().toString();
    else
        return null;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 19:06:43)
 * @return com.hps.july.basestation.valueobject.Sector_VO
 */
public com.hps.july.basestation.valueobject.Sector_VO getVo() {
	return vo;
}
/**
 * Insert the method's description here.
 * Creation date: (24.08.2005 17:22:22)
 */
private void initBaseStation() {
    try {
        baseStation = new BaseStationAccessBean();
        baseStation.setInitKey_storageplace(getEquipment());
        baseStation.refreshCopyHelper();
        setPrefixCelliD(baseStation.getPrefixcellid());
        setPositionID(baseStation.getPositionKey().storageplace);
        setBsName(baseStation.getName());
        setStationType(baseStation.getStationType());
        initIndex();
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("baseStation не инициализирован!!!");
    }
}
/**
 * Инициализация коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    setFlagOperation(false);
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 12:42:12)
 */
private void initIndex(){
    Integer ind =
        com.hps.july.cdbc.objects.CDBC_SuperRegions_Object.getIndexFromPosition(
            new Integer(getPositionID()));
    setIndex(ind);
}
/**
 * Инициализация полей в режиме добавления записи.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    setLett("");
    KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    int key = keyGen.getNextKey(com.hps.july.jdbcpersistence.lib.TablesRef.SECTORS);
    setId_sect(key);
    vo = new com.hps.july.basestation.valueobject.Sector_VO(new Integer(key));
    vo.setEquipment(new Integer(getEquipment()));
    vo.setBts_number("BTS_");
    vo.setDatasource(new Integer(0));
    vo.setByhand("Y");
    if (!getBaseStation().getStationType().equals(BaseStationObject.TYPE_CHECK_DAMPS_D)) {
        vo.setName_sect(getBaseStation().getName());
        if (getBaseStation().getPrefixcellid() != null) {
            vo.setNum_sect(String.valueOf(getBaseStation().getPrefixcellid()));
        }
        vo.setCellname(new Integer(getBaseStation().getNumber()));
    }
    if (getBaseStation().getStationType().equals(BaseStationObject.TYPE_CHECK_DAMPS_D)) {
        vo.setBand(new Short(BaseStationObject.BAND_CHECK_DAMPS_800));
    } else {
        vo.setBand(new Short(BaseStationObject.BAND_CHECK_GSM_900));
    }
    vo.setConf(SectorObject.CONF_CHECK_1);
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 19:31:27)
 * @return boolean
 */
public boolean isFlagOperation() {
	return flagOperation;
}
/**
 * Метод загрузки данных в форму
 * Creation date: (13.02.2002 10:12:41)
 */
public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    vo = com.hps.july.cdbc.objects.CDBC_Sector_Object.find(getId_sect());
    setEquipment(vo.getEquipment().intValue());
    if (vo.getNum_sect() != null && vo.getNum_sect().length() > 0) {
        lett = String.valueOf(vo.getNum_sect().charAt(vo.getNum_sect().length() - 1));
    }
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    boolean ok = com.hps.july.cdbc.objects.CDBC_Sector_Object.delete(getVo());
    if (!ok) {
        String errorStr = "Ошибка удаления записи: Sector:id" + getVo().getId_sect();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    boolean ok = com.hps.july.cdbc.objects.CDBC_Sector_Object.add(getVo());
    if (!ok) {
        String errorStr = "Ошибка добаления записи: Sector:id" + getVo().getId_sect();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    boolean ok = com.hps.july.cdbc.objects.CDBC_Sector_Object.edit(getVo());
    if (!ok) {
        String errorStr = "Ошибка редактирования записи: Sector:id" + getVo().getId_sect();
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
        setFlagOperation(false);
    } else {
        setFlagOperation(true);
    }
    return "success";
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 14:59:37)
 */
public void setAzimutStr(String azimutStr) {
	StringAndBigDecimalProperty strBD = new StringAndBigDecimalProperty();
	strBD.setString(azimutStr);
	vo.setAzimut(strBD.getBigDecimal());
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 11:47:40)
 * @param newBaseStation com.hps.july.persistence.BaseStationAccessBean
 */
private void setBaseStation(com.hps.july.persistence.BaseStationAccessBean newBaseStation) {
	baseStation = newBaseStation;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 17:20:38)
 * @param newBsName java.lang.String
 */
public void setBsName(java.lang.String newBsName) {
	bsName = newBsName;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 16:19:07)
 * @param newEquipment int
 */
public void setEquipment(int newEquipment) {
    equipment = newEquipment;
    initBaseStation();
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 19:31:27)
 * @param newFlagOperation boolean
 */
public void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 19:06:17)
 * @param newId_sect int
 */
public void setId_sect(int newId_sect) {
	id_sect = newId_sect;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 12:46:19)
 * @param newIndex java.lang.Integer
 */
public void setIndex(java.lang.Integer newIndex) {
	index = newIndex;
}
/**
 * Insert the method's description here.
 * Creation date: (23.08.2005 15:55:38)
 * @param newLett java.lang.String
 */
public void setLett(java.lang.String newLett) {
	lett = newLett;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 13:53:45)
 * @param newPositionID int
 */
public void setPositionID(int newPositionID) {
	positionID = newPositionID;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 13:28:28)
 * @param newPrefixCelliD java.lang.Integer
 */
public void setPrefixCelliD(java.lang.Integer newPrefixCelliD) {
	prefixCelliD = newPrefixCelliD;
}
/**
 * Insert the method's description here.
 * Creation date: (25.08.2005 17:27:14)
 * @param newStationType java.lang.String
 */
public void setStationType(java.lang.String newStationType) {
	stationType = newStationType;
}
/**
 * Insert the method's description here.
 * Creation date: (09.08.2005 14:59:37)
 */
public void setTx_pwrStr(String tx_pwrStr) {
	StringAndBigDecimalProperty strBD = new StringAndBigDecimalProperty();
	strBD.setString(tx_pwrStr);
	vo.setTx_pwr(strBD.getBigDecimal());
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2005 19:06:43)
 * @param newVo com.hps.july.basestation.valueobject.Sector_VO
 */
public void setVo(com.hps.july.basestation.valueobject.Sector_VO newVo) {
	vo = newVo;
}
/**
 * Метод для проверки правильности ввода значений в поля ввода.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException - 
 * при этом исключении ошибки отображаются пользователю.
 */
public void validateValues(ActionErrors errors) throws Exception {
    if ("Add".equals(getAction())) {
        if (vo.getNum_sect() == null || vo.getNum_sect().length() == 0) {
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.cellid"));
        } else if (vo.getNum_sect().length() > 5) {
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.cellid.length"));
        } else if (getLett() == null || getLett().length() == 0) {
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.lett"));
        } else if (getLett().length() > 1 || !Character.isDigit(getLett().charAt(0))) {
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.lett.length"));
        }
    } else {
        if (vo.getNum_sect() == null || vo.getNum_sect().length() == 0) {
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.cellid"));
        } else if (vo.getNum_sect().length() > 5) {
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.cellid.length"));
        }
    }

    if ((vo.getName_sect() == null) || (vo.getName_sect().length() == 0)) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.namesect"));
    }

    if (vo.getAzimut() == null) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.SectorForm.azimut", " не более 4 цифр до запятой и не более 2 цифр после запятой"));
    } else if (vo.getAzimut().doubleValue() < 0.0d || vo.getAzimut().doubleValue() > 360.0d) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.azimut.range"));
    }

    if (vo.getTrx_num() == null) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.trxnum"));
    }
    /**     
    	if(vo.getTrx_num2()==null) {
    	    errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.SectorForm.trxnum2"));
        }
      
    	if(!this.trxovrnum.isOk()) {
    	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.trxovrnum"));
        }
    
    	if (!txovrsetpwr.isOk()) {
            errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.txovrsetpwr",txovrsetpwr.formatMessage()));
    	}
    
    	if(!txpwr2.isEmpty()) {
    	    if (!txpwr2.isOk()) {
    	       errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.txsetpwr",txpwr2.formatMessage()));
    		} else if(txpwr2.getBigDecimal().signum() < 0) {
    	       errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.txsetpwr.less"));
    		}
    	}    	
    */

    if (vo.getTx_pwr() == null) {
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.SectorForm.txpwr", " не более 4 цифр до запятой и не более 2 цифр после запятой"));
    } else if (vo.getTx_pwr().signum() < 0) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.txpwr.less"));
    }

    if (vo.getPort_abis() == null) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.SectorForm.portabis"));
    }
    /**      
    	if(btsnumber == null) {
    		btsnumber = "";
    	}
    */
    if (vo.getConf() == null || vo.getConf().trim().length()==0) {
        errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Тип сектора ?"));
    }    
    if (!errors.empty())
        throw new ValidationException();
}
}
