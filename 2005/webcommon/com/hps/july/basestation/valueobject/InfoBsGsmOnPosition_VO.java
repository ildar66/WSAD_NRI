package com.hps.july.basestation.valueobject;

import java.sql.*;

import com.hps.july.basestation.formbean.EquipmentStatusConstants;
/**
 * Получаем краткое описание БС расположенных на позиции.
 * Creation date: (21.07.2005 16:16:50)
 * @author: Shafigullin Ildar
 */
public class InfoBsGsmOnPosition_VO extends EquipmentStatusConstants {
    private boolean isGSM; //наличие GSM
    private boolean isDCS; //наличие DCS
    private java.lang.String nameController; //наименование контроллера
    private java.lang.Integer countControllers; //количество контроллеров 
    private java.lang.String nameOtv; //отв. за эксплуатацию БС 
    private java.sql.Date min_date_bldbegGSM; //начало строительства GSM
    private java.sql.Date min_date_bldbegDCS; //начало строительства DCS
    private java.sql.Date min_date_assemb_afsGSM; //дата монтажа и тестирования АФС GSM
    private java.sql.Date min_date_assemb_afsDCS; //дата монтажа и тестирования АФС DSC
    private java.sql.Date min_date_assembGSM; //дата монтажа оборудования БС GSM
    private java.sql.Date min_date_assembDCS; //дата монтажа оборудования БС DCS
    private java.sql.Date min_date_testGSM; //дата тестирования GSM
    private java.sql.Date min_date_testDCS; //дата тестирования DSC
    private java.sql.Date min_date_connectGSM; //дата подключения к MSC GSM
    private java.sql.Date min_date_connectDCS; //дата подключения к MSC DCS
    private java.sql.Date min_date_onairGSM; //дата включения в эфир GSM
    private java.sql.Date min_date_onairDCS; //дата включения в эфир DCS
    private java.sql.Date min_date_prGSM; //дата приемки в эксплуатацию GSM
    private java.sql.Date min_date_prDCS; //дата приемки в эксплуатацию DCS
    //Конфигурация DCS:
    private java.lang.Integer trx_num1800_A;
    private java.lang.Integer trx_num1800_B;
    private java.lang.Integer trx_num1800_C;
    private java.lang.Integer trx_num1800_D;
    private java.lang.Integer trx_num1800_O;
    //Конфигурация GSM:
    private java.lang.Integer trx_num900_E;
    private java.lang.Integer trx_num900_F;
    private java.lang.Integer trx_num900_G;
    private java.lang.Integer trx_num900_H;
	private java.lang.Integer trx_num900_O;
	//
	private String state900;
	private String state1800;
	private String controllerState;
/**
 * InfoBsGsmOnPosition_VO constructor comment.
 */
public InfoBsGsmOnPosition_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:22:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getCountControllers() {
	return countControllers;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:20:42)
 * @return boolean
 */
public boolean getIsDCS() {
	return isDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:20:27)
 * @return boolean
 */
public boolean getIsGSM() {
	return isGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:27:27)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_assemb_afsDCS() {
	return min_date_assemb_afsDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:26:46)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_assemb_afsGSM() {
	return min_date_assemb_afsGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:29:45)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_assembDCS() {
	return min_date_assembDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:28:02)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_assembGSM() {
	return min_date_assembGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:26:07)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_bldbegDCS() {
	return min_date_bldbegDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:25:03)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_bldbegGSM() {
	return min_date_bldbegGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:34:15)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_connectDCS() {
	return min_date_connectDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:33:31)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_connectGSM() {
	return min_date_connectGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:35:56)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_onairDCS() {
	return min_date_onairDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:35:11)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_onairGSM() {
	return min_date_onairGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:37:03)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_prDCS() {
	return min_date_prDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:36:35)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_prGSM() {
	return min_date_prGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:32:37)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_testDCS() {
	return min_date_testDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:31:22)
 * @return java.sql.Date
 */
public java.sql.Date getMin_date_testGSM() {
	return min_date_testGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:21:07)
 * @return java.lang.String
 */
public java.lang.String getNameController() {
	return nameController;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:24:08)
 * @return java.lang.String
 */
public java.lang.String getNameOtv() {
	return nameOtv;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:38:09)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num1800_A() {
	return trx_num1800_A;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:38:36)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num1800_B() {
	return trx_num1800_B;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:38:53)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num1800_C() {
	return trx_num1800_C;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:39:12)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num1800_D() {
	return trx_num1800_D;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:39:32)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num1800_O() {
	return trx_num1800_O;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:39:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num900_E() {
	return trx_num900_E;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:40:09)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num900_F() {
	return trx_num900_F;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:40:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num900_G() {
	return trx_num900_G;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:41:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num900_H() {
	return trx_num900_H;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2005 10:30:04)
 * @return java.lang.Integer
 */
public java.lang.Integer getTrx_num900_O() {
	return trx_num900_O;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:22:55)
 * @param newCountControllers java.lang.Integer
 */
public void setCountControllers(java.lang.Integer newCountControllers) {
	countControllers = newCountControllers;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:20:42)
 * @param newIsDCS boolean
 */
public void setIsDCS(boolean newIsDCS) {
	isDCS = newIsDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:20:27)
 * @param newIsGSM boolean
 */
public void setIsGSM(boolean newIsGSM) {
	isGSM = newIsGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:27:27)
 * @param newMin_date_assemb_afsDCS java.sql.Date
 */
public void setMin_date_assemb_afsDCS(java.sql.Date newMin_date_assemb_afsDCS) {
	min_date_assemb_afsDCS = newMin_date_assemb_afsDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:26:46)
 * @param newMin_date_assemb_afsGSM java.sql.Date
 */
public void setMin_date_assemb_afsGSM(java.sql.Date newMin_date_assemb_afsGSM) {
	min_date_assemb_afsGSM = newMin_date_assemb_afsGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:29:45)
 * @param newMin_date_assembDCS java.sql.Date
 */
public void setMin_date_assembDCS(java.sql.Date newMin_date_assembDCS) {
	min_date_assembDCS = newMin_date_assembDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:28:02)
 * @param newMin_date_assembGSM java.sql.Date
 */
public void setMin_date_assembGSM(java.sql.Date newMin_date_assembGSM) {
	min_date_assembGSM = newMin_date_assembGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:26:07)
 * @param newMin_date_bldbegDCS java.sql.Date
 */
public void setMin_date_bldbegDCS(java.sql.Date newMin_date_bldbegDCS) {
	min_date_bldbegDCS = newMin_date_bldbegDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:25:03)
 * @param newMin_date_bldbegGSM java.sql.Date
 */
public void setMin_date_bldbegGSM(java.sql.Date newMin_date_bldbegGSM) {
	min_date_bldbegGSM = newMin_date_bldbegGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:34:15)
 * @param newMin_date_connectDCS java.sql.Date
 */
public void setMin_date_connectDCS(java.sql.Date newMin_date_connectDCS) {
	min_date_connectDCS = newMin_date_connectDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:33:31)
 * @param newMin_date_connectGSM java.sql.Date
 */
public void setMin_date_connectGSM(java.sql.Date newMin_date_connectGSM) {
	min_date_connectGSM = newMin_date_connectGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:35:56)
 * @param newMin_date_onairDCS java.sql.Date
 */
public void setMin_date_onairDCS(java.sql.Date newMin_date_onairDCS) {
	min_date_onairDCS = newMin_date_onairDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:35:11)
 * @param newMin_date_onairGSM java.sql.Date
 */
public void setMin_date_onairGSM(java.sql.Date newMin_date_onairGSM) {
	min_date_onairGSM = newMin_date_onairGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:37:03)
 * @param newMin_date_prDCS java.sql.Date
 */
public void setMin_date_prDCS(java.sql.Date newMin_date_prDCS) {
	min_date_prDCS = newMin_date_prDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:36:35)
 * @param newMin_date_prGSM java.sql.Date
 */
public void setMin_date_prGSM(java.sql.Date newMin_date_prGSM) {
	min_date_prGSM = newMin_date_prGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:32:37)
 * @param newMin_date_testDCS java.sql.Date
 */
public void setMin_date_testDCS(java.sql.Date newMin_date_testDCS) {
	min_date_testDCS = newMin_date_testDCS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:31:22)
 * @param newMin_date_testGSM java.sql.Date
 */
public void setMin_date_testGSM(java.sql.Date newMin_date_testGSM) {
	min_date_testGSM = newMin_date_testGSM;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:21:07)
 * @param newNameController java.lang.String
 */
public void setNameController(java.lang.String newNameController) {
	nameController = newNameController;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:24:08)
 * @param newNameOtv java.lang.String
 */
public void setNameOtv(java.lang.String newNameOtv) {
	nameOtv = newNameOtv;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:38:09)
 * @param newTrx_num1800_A java.lang.Integer
 */
public void setTrx_num1800_A(java.lang.Integer newTrx_num1800_A) {
	trx_num1800_A = newTrx_num1800_A;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:38:36)
 * @param newTrx_num1800_B java.lang.Integer
 */
public void setTrx_num1800_B(java.lang.Integer newTrx_num1800_B) {
	trx_num1800_B = newTrx_num1800_B;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:38:53)
 * @param newTrx_num1800_C java.lang.Integer
 */
public void setTrx_num1800_C(java.lang.Integer newTrx_num1800_C) {
	trx_num1800_C = newTrx_num1800_C;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:39:12)
 * @param newTrx_num1800_D java.lang.Integer
 */
public void setTrx_num1800_D(java.lang.Integer newTrx_num1800_D) {
	trx_num1800_D = newTrx_num1800_D;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:39:32)
 * @param newTrx_num1800_O java.lang.Integer
 */
public void setTrx_num1800_O(java.lang.Integer newTrx_num1800_O) {
	trx_num1800_O = newTrx_num1800_O;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:39:42)
 * @param newTrx_num900_E java.lang.Integer
 */
public void setTrx_num900_E(java.lang.Integer newTrx_num900_E) {
	trx_num900_E = newTrx_num900_E;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:40:09)
 * @param newTrx_num900_F java.lang.Integer
 */
public void setTrx_num900_F(java.lang.Integer newTrx_num900_F) {
	trx_num900_F = newTrx_num900_F;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:40:25)
 * @param newTrx_num900_G java.lang.Integer
 */
public void setTrx_num900_G(java.lang.Integer newTrx_num900_G) {
	trx_num900_G = newTrx_num900_G;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 16:41:25)
 * @param newTrx_num900_H java.lang.Integer
 */
public void setTrx_num900_H(java.lang.Integer newTrx_num900_H) {
	trx_num900_H = newTrx_num900_H;
}
/**
 * Insert the method's description here.
 * Creation date: (12.08.2005 10:30:04)
 * @param newTrx_num900_O java.lang.Integer
 */
public void setTrx_num900_O(java.lang.Integer newTrx_num900_O) {
	trx_num900_O = newTrx_num900_O;
}
	/**
	 * @return
	 */
	public String getState1800() {
		return state1800;
	}

	public String getState1800Label() {
		return getStateBsLabel(state1800);
	}

	/**
	 * @return
	 */
	public String getState900() {
		return state900;
	}

	public String getState900Label() {
		return getStateBsLabel(state900);
	}

	/**
	 * @param string
	 */
	public void setState1800(String string) {
		state1800 = string;
	}

	/**
	 * @param string
	 */
	public void setState900(String string) {
		state900 = string;
	}

	/**
	 * @return
	 */
	public String getControllerState() {
		return controllerState;
	}

	public String getControllerStateLabel() {
		return getStateEqLabel(controllerState);
	}

	/**
	 * @param string
	 */
	public void setControllerState(String string) {
		controllerState = string;
	}

}
