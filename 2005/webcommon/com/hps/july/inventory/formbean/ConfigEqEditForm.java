/*
 * Created on 21.06.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.inventory.formbean;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.NamingException;

import com.hps.july.cdbc.objects.CDBCBaseStationObject;
import com.hps.july.cdbc.objects.OptionItem;
import com.hps.july.inventory.valueobject.AntennVO;
import com.hps.july.inventory.valueobject.BSEquipCommonVO;
import com.hps.july.inventory.valueobject.DtRepiterVO;
import com.hps.july.inventory.valueobject.StandVO;
import com.hps.july.persistence.DocumentBean;
import com.hps.july.web.util.StringAndSqlDateProperty;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.config.beans.*;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ConfigEqEditForm extends DocumentForm {
	
	// для поиска 
	private String searchParameterName = "BNM"; // пока нужен, чтобы тэг не ругался
	private String searchParameterValue;
	// для результатов поиск
	private String bsNumber;
	private String bsName;
	private String posAddress;
	// для того чтобы знать какую часть формы самбитим
	private String partForSubmit;
	// констаны для указания части
	public static String WHOLE_PART = "WHOLE_PART";
	public static String STANDS_TITLE_PART = "STANDS_TITLE_PART";
	public static String STANDS_CONTENT_PART = "STANDS_CONTENT_PART";
	public static String ANTENNS_TITLE_PART = "ANTENNS_TITLE_PART";
	public static String ANTENNS_CONTENT_PART = "ANTENNS_CONTENT_PART";
	// секция 5
	public static String TYPE_900 = "C";  
	public static String TYPE_1800 = "S";  
	public static String TYPE_900_1800 = "G";  
	// 900 диапазон
	private Boolean isGsm; 
	private String gsmState;
	private StringAndSqlDateProperty gsmBsConstructionBegin;
	private StringAndSqlDateProperty gsmBsMountingTest;
	private StringAndSqlDateProperty gsmAfsMountingTest;
	private StringAndSqlDateProperty gsmBscConnection;
	private StringAndSqlDateProperty gsmOnAir;
	// 1800 диапазон
	private Boolean isDcs; 
	private String dcsState;
	private StringAndSqlDateProperty dcsBsConstructionBegin;
	private StringAndSqlDateProperty dcsBsMountingTest;
	private StringAndSqlDateProperty dcsAfsMountingTest;
	private StringAndSqlDateProperty dcsBscConnection;
	private StringAndSqlDateProperty dcsOnAir;
	// секция 6 репитеры
	private List dtRepList;
	// секция 7 
	// контроллер
	private List controllers;
	private String controllerId;
	// суммарные сектора
	// использование секторов
	private Boolean sumSector_O_900;
	private Boolean sumSector_E_900;
	private Boolean sumSector_F_900;
	private Boolean sumSector_G_900;
	private Boolean sumSector_H_900;
	private Boolean sumSector_O_1800;
	private Boolean sumSector_A_1800;
	private Boolean sumSector_B_1800;
	private Boolean sumSector_C_1800;
	private Boolean sumSector_D_1800;
	// количество трансиверов
	private Integer sumTrans_O_900;
	private Integer sumTrans_E_900;
	private Integer sumTrans_F_900;
	private Integer sumTrans_G_900;
	private Integer sumTrans_H_900;
	private Integer sumTrans_O_1800;
	private Integer sumTrans_A_1800;
	private Integer sumTrans_B_1800;
	private Integer sumTrans_C_1800;
	private Integer sumTrans_D_1800;
	// количество антенн
	private Integer sumAntenn_O_900;
	private Integer sumAntenn_E_900;
	private Integer sumAntenn_F_900;
	private Integer sumAntenn_G_900;
	private Integer sumAntenn_H_900;
	private Integer sumAntenn_O_1800;
	private Integer sumAntenn_A_1800;
	private Integer sumAntenn_B_1800;
	private Integer sumAntenn_C_1800;
	private Integer sumAntenn_D_1800;
	// секция 8 шкафы
	private StandVO [] stands;
	private Integer standsQuantity;
	private List standsProdusers;
	private String standsProduserId = "0";
	private Integer curStandId;
	private Integer deletedStandId;
	private Boolean isInsertNewStand;
	private List deletedAddedStandsList = new ArrayList();
	// для отладки
	private String debugInfo;
	// секция 9 трансиверы
	// секция 10 антенны
	private AntennVO [] antenns;
	private Integer antennsQuantity;
	private Integer curAntennId;
	//
	private List fidersProdusers;
	private String fidersProduserId = "0";
	
	public ConfigEqEditForm() throws RemoteException, CreateException, FinderException, NamingException {
		super();
		setLastVisited(true);
		setTestDate();
	}
	
	// деревянные данные по номеру конфигурации и по номеру БС
	public int getBaseStationId() {
		final int TEST_BS_NUM = 1436;
		return TEST_BS_NUM;
	}
	
	public int getConfigId() {
		final int TEST_CONFIG_NUM = 16; // 26;
		return TEST_CONFIG_NUM;
	}
	
	private void setTestDate() throws RemoteException, CreateException, FinderException, NamingException {
		// получаем данные из бинов
		// вызываем CfgBasestationAccessBean
		CfgBasestationAccessBean сfgBasestationAccessBean = new CfgBasestationAccessBean();
		// "деревянные" айди для конфигурации и бс
		сfgBasestationAccessBean.setInitKey_equipment(getBaseStationId());
		сfgBasestationAccessBean.setInitKey_savconfigid(getConfigId());
		сfgBasestationAccessBean.refreshCopyHelper();
		String type = сfgBasestationAccessBean.getType();
		System.out.println("### type = "+type);
		if (type.equals(TYPE_900_1800)) {
			isGsm = new Boolean(true); 
			isDcs = new Boolean(true);
		} else {
			if (type.equals(TYPE_900)) {
				isGsm = new Boolean(true); 
				isDcs = new Boolean(false);
			}
			if (type.equals(TYPE_1800)) {
				isGsm = new Boolean(false); 
				isDcs = new Boolean(true);
			}
		}
		// секция 4
		// 900 диапазон
		if (isGsm.booleanValue()) {
			gsmState = сfgBasestationAccessBean.getState900();
			//
			gsmBsConstructionBegin = new StringAndSqlDateProperty();
			gsmBsConstructionBegin.setSqlDate(сfgBasestationAccessBean.getDate_bldbeg());
			//
			gsmBsMountingTest = new StringAndSqlDateProperty();
			gsmBsMountingTest.setSqlDate(сfgBasestationAccessBean.getDate_assemb());
			System.out.println("### gsmBsMountingTest.getSqlDate() = "+gsmBsMountingTest.getSqlDate());
			System.out.println("### gsmBsMountingTest.getString() = "+gsmBsMountingTest.getString());
			//
			gsmAfsMountingTest = new StringAndSqlDateProperty();
			gsmAfsMountingTest.setSqlDate(сfgBasestationAccessBean.getDate_assemb_afs());
			//
			gsmBscConnection = new StringAndSqlDateProperty();
			gsmBscConnection.setSqlDate(сfgBasestationAccessBean.getDate_connect());
			//
			gsmOnAir = new StringAndSqlDateProperty();
			gsmOnAir.setSqlDate(сfgBasestationAccessBean.getDate_onair());
		}
		// 1800 диапазон
		if (isDcs.booleanValue()) {
			dcsState = сfgBasestationAccessBean.getState1800();
			//
			dcsBsConstructionBegin = new StringAndSqlDateProperty();
			dcsBsConstructionBegin.setSqlDate(сfgBasestationAccessBean.getDate_bldbeg2());
			//
			dcsBsMountingTest = new StringAndSqlDateProperty();
			dcsBsMountingTest.setSqlDate(сfgBasestationAccessBean.getDate_assemb2());
			System.out.println("### dcsBsMountingTest.getSqlDate() = "+dcsBsMountingTest.getSqlDate());
			System.out.println("### dcsBsMountingTest.getString() = "+dcsBsMountingTest.getString());
			//
			dcsAfsMountingTest = new StringAndSqlDateProperty();
			dcsAfsMountingTest.setSqlDate(сfgBasestationAccessBean.getDate_assemb_afs2());
			//
			dcsBscConnection = new StringAndSqlDateProperty();
			dcsBscConnection.setSqlDate(сfgBasestationAccessBean.getDate_connect2());
			//
			dcsOnAir = new StringAndSqlDateProperty();
			dcsOnAir.setSqlDate(сfgBasestationAccessBean.getDate_onair2());
		}
		// Тестовые данные 
		// секция 5
		// дочерние репитеры
		ArrayList dtRepArrList = new ArrayList();
		// 01
		DtRepiterVO dtRepiterVO_01 = new DtRepiterVO();
		dtRepiterVO_01.setNum(new Integer(1001));
		dtRepiterVO_01.setDonorSector("A");
		dtRepiterVO_01.setConnType("Радиоканал");
		dtRepiterVO_01.setState("Эксплуатируется");
		dtRepArrList.add(dtRepiterVO_01);
		// 02
		DtRepiterVO dtRepiterVO_02 = new DtRepiterVO();
		dtRepiterVO_02.setNum(new Integer(1002));
		dtRepiterVO_02.setDonorSector("B");
		dtRepiterVO_02.setConnType("Кабель");
		dtRepiterVO_02.setState("Строится");
		dtRepArrList.add(dtRepiterVO_02);
		// 03
		DtRepiterVO dtRepiterVO_03 = new DtRepiterVO();
		dtRepiterVO_03.setNum(new Integer(1003));
		dtRepiterVO_03.setDonorSector("C");
		dtRepiterVO_03.setConnType("Оптика");
		dtRepiterVO_03.setState("Тестируется");
		dtRepArrList.add(dtRepiterVO_03);
		// 04
		DtRepiterVO dtRepiterVO_04 = new DtRepiterVO();
		dtRepiterVO_04.setNum(new Integer(1004));
		dtRepiterVO_04.setDonorSector("D");
		dtRepiterVO_04.setConnType("Моптика");
		dtRepiterVO_04.setState("Демонтируется");
		dtRepArrList.add(dtRepiterVO_04);
		// 05
		DtRepiterVO dtRepiterVO_05 = new DtRepiterVO();
		dtRepiterVO_05.setNum(new Integer(1005));
		dtRepiterVO_05.setDonorSector("E");
		dtRepiterVO_05.setConnType("Клоптика");
		dtRepiterVO_05.setState("Демонтируется");
		dtRepArrList.add(dtRepiterVO_05);
		this.setDtRepList(dtRepArrList);
		// секция 7
		// контроллеры
		ArrayList controllerList = new ArrayList();
		//
		OptionItem ci00 = new OptionItem();
		// ci00.setCode(new Integer(0));
		ci00.setCode("0");
		ci00.setName("---");
		controllerList.add(ci00);
		//
		OptionItem ci01 = new OptionItem();
		// ci01.setCode(new Integer(1));
		ci01.setCode("1");
		ci01.setName("Контроллер 0001");
		controllerList.add(ci01);
		//
		OptionItem ci02 = new OptionItem();
		// ci02.setCode(new Integer(2));
		ci02.setCode("2");
		ci02.setName("Контроллер 0002");
		controllerList.add(ci02);
		//
		OptionItem ci03 = new OptionItem();
		// ci03.setCode(new Integer(3));
		ci03.setCode("3");
		ci03.setName("Контроллер 0003");
		controllerList.add(ci03);
		//
		this.setControllers(controllerList);
		//
		// суммарные сектора
		// 
		sumSector_O_900 = new Boolean(true); 
		sumSector_E_900 = new Boolean(true); 
		sumSector_F_900 = new Boolean(false); 
		sumSector_G_900 = new Boolean(false); 
		sumSector_H_900 = new Boolean(true); 
		sumSector_O_1800 = new Boolean(true); 
		sumSector_A_1800 = new Boolean(false); 
		sumSector_B_1800 = new Boolean(false); 
		sumSector_C_1800 = new Boolean(true); 
		sumSector_D_1800 = new Boolean(false); 
		//
		sumTrans_O_900 = new Integer(1);
		sumTrans_E_900 = new Integer(2);
		sumTrans_F_900 = new Integer(0);
		sumTrans_G_900 = new Integer(4);
		sumTrans_H_900 = new Integer(5);
		sumTrans_O_1800 = new Integer(11);
		sumTrans_A_1800 = new Integer(12);
		sumTrans_B_1800 = new Integer(13);
		sumTrans_C_1800 = new Integer(0);
		sumTrans_D_1800 = new Integer(15);
		// 
		sumAntenn_O_900 = new Integer(21);
		sumAntenn_E_900 = new Integer(0);
		sumAntenn_F_900 = new Integer(23);
		sumAntenn_G_900 = new Integer(24);
		sumAntenn_H_900 = new Integer(25);
		sumAntenn_O_1800 = new Integer(0);
		sumAntenn_A_1800 = new Integer(32);
		sumAntenn_B_1800 = new Integer(33);
		sumAntenn_C_1800 = new Integer(34);
		sumAntenn_D_1800 = new Integer(35);
		// 
		// секция 8
		// список шкафов
		// список типов шкафов (для теста общий для всех)
		ArrayList standTypesList = new ArrayList();
		//
		OptionItem st00 = new OptionItem();
		// st00.setCode(new Integer(0));
		st00.setCode("0");
		st00.setName("---");
		standTypesList.add(st00);
		//
		OptionItem st01 = new OptionItem();
		// st01.setCode(new Integer(1));
		st01.setCode("1");
		st01.setName("0001 Stand Type");
		standTypesList.add(st01);
		//
		OptionItem st02 = new OptionItem();
		// st02.setCode(new Integer(2));
		st02.setCode("2");
		st02.setName("0002 Stand Type");
		standTypesList.add(st02);
		//
		OptionItem st03 = new OptionItem();
		// st03.setCode(new Integer(3));
		st03.setCode("3");
		st03.setName("0003 Stand Type");
		standTypesList.add(st03);
		//
		OptionItem st04 = new OptionItem();
		// st04.setCode(new Integer(4));
		st04.setCode("4");
		st04.setName("0004 Stand Type");
		standTypesList.add(st04);
		//
		OptionItem st05 = new OptionItem();
		// st05.setCode(new Integer(5));
		st05.setCode("5");
		st05.setName("0005 Stand Type");
		standTypesList.add(st05);
		//
		// создаем экземпляры шкафов
		//
		// тянем список шкафов из базы
		StandVO[] standsArray = getStandsArrayFromPersistent(getConfigId(), getBaseStationId(), new Integer(standsProduserId).intValue());
		this.setStands(standsArray);
		if ((getStands() != null) && (getStands().length > 0) && (getStands()[0] != null)) {
			// делаем на прямую а в сете делаем проверку
			setCurStandId(new Integer(0));
			// curStandId = new Integer(0);
			setDeletedStandId(new Integer(0));
			setIsInsertNewStand(new Boolean(false));
		}
		// создаем экземпляры антенн
		//
		// тянем список антенн из базы
		AntennVO[] antennArray = getAntennArrayFromPersistent(getConfigId(), getBaseStationId(), new Integer(fidersProduserId).intValue());
		System.out.println("@@@@@ antennArray.length = " +antennArray.length);
		this.setAntenns(antennArray);
		if ((getAntenns() != null) && (getAntenns().length > 0) && (getAntenns()[0] != null)) {
			setCurAntennId(getAntenns()[0].getPartId());
		}
		// определение какие чек боксы в шкафах нужно закрывать
		// whatStandCheckBoxesShouldBeDisabled();
		//		
	}

	/**
	 * @param TEST_CONFIG_NUM
	 * @param TEST_BS_NUM
	 * @return
	 */
	private AntennVO[] getAntennArrayFromPersistent(int configId, int baseStationId, int curFiderProdId) {
		AntennVO[] antennVOArray = CDBCBaseStationObject.getAntennsArrayForConfiguration(configId, baseStationId, curFiderProdId);
		return antennVOArray;
	}

	/**
	 * @param TEST_CONFIG_NUM
	 * @return
	 */
	private StandVO[] getStandsArrayFromPersistent(int configId, int baseStationId, int curStandProdId) {
		StandVO[] standVOArray = CDBCBaseStationObject.getStandsArrayForConfiguration(configId, baseStationId, curStandProdId);
		return standVOArray;
	}

	private static final int checkQuantity = 10;
	/**
	 * 
	 */
	/*
	private void whatStandCheckBoxesShouldBeDisabled() {
		// 1. переливаем в цикле данные из шкафов в двухмурный логический массив исходных данных
		boolean [][] inCheckInfo = new boolean[this.getStandsQuantity().intValue()][checkQuantity];
		boolean [][] disCheckInfo = new boolean[this.getStandsQuantity().intValue()][checkQuantity];
		setInCheckInfo(inCheckInfo);
		// 2. получаем по массиву исходных данных массив закрытых флажков
		createDisArray(inCheckInfo, disCheckInfo);
		// 3. переливаем обратно из выходного массива в свойства закрытия флажков в шкафах
		setDisInfo(disCheckInfo);
	}
	*/

	/**
	 * @param disCheckInfo
	 */
	/*
	private void setDisInfo(boolean[][] disCheckInfo) {
		int standQ = this.getStandsQuantity().intValue();
		for (int i = 0; i < standQ; i++) {
			StandVO curStandVO = this.getStands()[i];
			boolean [] disCheckRow = disCheckInfo[i];
			curStandVO.setDisableOmni900(disCheckRow[0]); 
			curStandVO.setDisable900E(disCheckRow[1]); 
			curStandVO.setDisable900F(disCheckRow[2]);
			curStandVO.setDisable900G(disCheckRow[3]); 
			curStandVO.setDisable900H(disCheckRow[4]); 
			curStandVO.setDisableOmni1800(disCheckRow[5]); 
			curStandVO.setDisable1800A(disCheckRow[6]); 
			curStandVO.setDisable1800B(disCheckRow[7]); 
			curStandVO.setDisable1800C(disCheckRow[8]); 
			curStandVO.setDisable1800D(disCheckRow[9]); 
		}
		
	}
	*/

	/**
	 * @param inCheckInfo
	 * @param disCheckInfo
	 */
	private void createDisArray(boolean[][] inCheckInfo, boolean[][] disCheckInfo) {
		// для 0 и для 5 колонок
		boolean col_00 = getColValue(0, inCheckInfo);
		boolean col_05 = getColValue(5, inCheckInfo);
		boolean resOmni = col_00 || col_05;
		if (resOmni) {
			setDisValue(0, inCheckInfo, disCheckInfo);
			setDisValue(5, inCheckInfo, disCheckInfo);
		}
		for (int k = 1; k < 5; k++) {
			boolean col_900 = getColValue(k, inCheckInfo);
			if (col_900) {
				setDisValue(k, inCheckInfo, disCheckInfo);
			}
		}
		for (int k = 6; k < 10; k++) {
			boolean col_1800 = getColValue(k, inCheckInfo);
			if (col_1800) {
				setDisValue(k, inCheckInfo, disCheckInfo);
			}
		}
	}

	/**
	 * @param i
	 * @param inCheckInfo
	 * @param disCheckInfo
	 */
	private void setDisValue(int j, boolean[][] inCheckInfo, boolean[][] disCheckInfo) {
		for (int i = 0; i < this.getStandsQuantity().intValue(); i++) {
			boolean [] inCheckArray = inCheckInfo[i];
			boolean [] outCheckArray = disCheckInfo[i];
			outCheckArray[j] = ! inCheckArray[j];
		}
	}

	/**
	 * @param i
	 * @return
	 */
	private boolean getColValue(int j, boolean [][] inArray) {
		boolean outRes = false;
		for (int i = 0; i < this.getStandsQuantity().intValue(); i++) {
			boolean [] standCheckArray = inArray[i];
			boolean curCheck = standCheckArray[j];
			outRes = outRes || curCheck;
		}
		return outRes;
	}

	private static boolean getBooleanValue(Boolean theBool) {
		if (theBool == null) {
			return false;
		} else {
			return theBool.booleanValue();
		}
	}

	/**
	 * @param inCheckInfo
	 */
	/*
	private void setInCheckInfo(boolean[][] inCheckInfo) {
		int standQ = this.getStandsQuantity().intValue();
		for (int i = 0; i < standQ; i++) {
			StandVO curStandVO = this.getStands()[i];
			boolean [] standCheckRow = inCheckInfo[i];
			standCheckRow[0] = getBooleanValue(curStandVO.getIsOmni900()); 
			standCheckRow[1] = getBooleanValue(curStandVO.getIs900E()); 
			standCheckRow[2] = getBooleanValue(curStandVO.getIs900F());
			standCheckRow[3] = getBooleanValue(curStandVO.getIs900G()); 
			standCheckRow[4] = getBooleanValue(curStandVO.getIs900H()); 
			standCheckRow[5] = getBooleanValue(curStandVO.getIsOmni1800()); 
			standCheckRow[6] = getBooleanValue(curStandVO.getIs1800A()); 
			standCheckRow[7] = getBooleanValue(curStandVO.getIs1800B()); 
			standCheckRow[8] = getBooleanValue(curStandVO.getIs1800C()); 
			standCheckRow[9] = getBooleanValue(curStandVO.getIs1800D()); 
		}
	}
	*/

	/* (non-Javadoc)
	 * @see com.hps.july.inventory.formbean.DocumentForm#getDocumentId()
	 */
	public Integer getDocumentId() {
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// TODO Auto-generated method stub
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		// определение какие чек боксы в шкафах нужно закрывать
		// whatStandCheckBoxesShouldBeDisabled();
		//
		this.setAction("Edit");
		int returnValue = com.hps.july.inventory.APPStates.CONF_EQ_FORM;
		System.out.println("getState() partForSubmit = "+partForSubmit);
		System.out.println("getState() CONF_EQ_FORM");
		setLastVisited(true);
		if ((this.partForSubmit != null) && (! this.partForSubmit.equals(WHOLE_PART))) {
			if ((this.partForSubmit != null) && (this.partForSubmit.equals(STANDS_TITLE_PART))) {
				System.out.println("getState() CONF_EQ_FORM_STANDS_TITLE");
				returnValue = com.hps.july.inventory.APPStates.CONF_EQ_FORM_STANDS_TITLE;
				checkForAddNewStand();
				StandVO[] standsArray = refreshStandTypes(getStands());
				this.setStands(standsArray);
				System.out.println("##1 getState() getCurStandId() = " + getCurStandId());
			}
			if ((this.partForSubmit != null) && (this.partForSubmit.equals(STANDS_CONTENT_PART))) {
				// определяем какой шкаф изменился и меняем ему статус
				changeStandState();
				System.out.println("getState() CONF_EQ_FORM_STANDS_CONTENT");
				returnValue = com.hps.july.inventory.APPStates.CONF_EQ_FORM_STANDS_CONTENT;	
				System.out.println("##2 getState() getCurStandId() = " + getCurStandId());
			}
			
			if ((this.partForSubmit != null) && (this.partForSubmit.equals(ANTENNS_TITLE_PART))) {
				System.out.println("getState() CONF_EQ_FORM_ANTENNS_TITLE");
				AntennVO[] antennsArray = refreshAntennFiderTypes(getAntenns());
				returnValue = com.hps.july.inventory.APPStates.CONF_EQ_FORM_ANTENNS_TITLE;	
			}
			if ((this.partForSubmit != null) && (this.partForSubmit.equals(ANTENNS_CONTENT_PART))) {
				System.out.println("getState() CONF_EQ_FORM_ANTENNS_CONTENT");
				returnValue = com.hps.july.inventory.APPStates.CONF_EQ_FORM_ANTENNS_CONTENT;	
			}
			// вертаем в назад к целой форме
			setLastVisited(false);
			this.partForSubmit = WHOLE_PART;
		}	
		return returnValue;
	}

	private void checkForAddNewStand() {
		Boolean isInsertNewStand = getIsInsertNewStand();
		System.out.println("isInsertNewStand = " + isInsertNewStand);
 		if  ((isInsertNewStand != null) && (isInsertNewStand.booleanValue() == true)) {
			try {
				System.out.println("### 1");
				Integer newStandId = new Integer(new KeyGeneratorAccessBean().getNextKey("tables.bsstands"));
				System.out.println("### 2");
				// создаем новый шкаф
				StandVO newStandVO = new StandVO();
				newStandVO.setPartId(newStandId);
				newStandVO.setCurState(BSEquipCommonVO.ADD_STATE);
				newStandVO.setConfigId(new Integer(getConfigId()));
				newStandVO.setBaseStationId(new Integer(getBaseStationId()));
				// создаем новый массив
				StandVO [] newStandVOArray = new StandVO[getStands().length + 1];
				for (int i = 0; i < getStands().length + 1; i ++) {
					if (i == getStands().length) {
						newStandVOArray[i] = newStandVO; 
					} else {
						newStandVOArray[i] = getStands()[i]; 
					}
				}
				System.out.println("newStandVOArray = " + newStandVOArray);
				System.out.println("newStandVOArray.length = " + newStandVOArray.length);
				setStands(newStandVOArray);
				setIsInsertNewStand(new Boolean(false));
				// помечаем как текущий
				System.out.println("newStandVO.getPartId() = " + newStandVO.getPartId());
				setCurStandId(newStandVO.getPartId());
				// curStandId = newStandVO.getPartId();
				System.out.println("getCurStandId() = " + getCurStandId());
			} catch (Exception e) {
				System.out.println("### 3");
				e.printStackTrace();
			} 
		}
	}	

	/**
	 * 
	 */
	private void changeStandState() {
		Integer curStId = getCurStandId();
		Integer deletedStandId = getDeletedStandId();
		if ((deletedStandId != null) && (deletedStandId.intValue() > 0) ) {
			// перебираем массив шкафов и для текущего шкафа меняем статус
			for (int i = 0; i < this.getStands().length; i++) {
				StandVO curStandVO = this.getStands()[i];
				if (curStandVO.getPartId().equals(curStId)) {
					if ((curStandVO.getCurState().equals(BSEquipCommonVO.KEEP_STATE)) || 
						(curStandVO.getCurState().equals(BSEquipCommonVO.UPDATE_STATE))) {
						curStandVO.setCurState(BSEquipCommonVO.DELETE_STATE);
					} else if (curStandVO.getCurState().equals(BSEquipCommonVO.DELETE_STATE)) {
						curStandVO.setCurState(BSEquipCommonVO.UPDATE_STATE);
					} else if (curStandVO.getCurState().equals(BSEquipCommonVO.ADD_STATE)) {
						// нужно удалить данный шкаф через копирование в новый массив
						ArrayList bufAL = new ArrayList();
						for (int j = 0; j < this.getStands().length; j++) {
							if (j != i) {
								bufAL.add(this.getStands()[j]);
							} else {
								deletedAddedStandsList.add(this.getStands()[j]);
							}
						}	
						StandVO [] copyVOArray = new StandVO[bufAL.size()];
						for (int j = 0; j < bufAL.size(); j ++) {
							StandVO bufStandVO = (StandVO)bufAL.get(j);
							copyVOArray[j] = bufStandVO;  
						}
						this.setStands(copyVOArray);
						// назначаем новый текущий шкаф
						StandVO newCurStand; 
						if (copyVOArray.length > 0) {
							if (copyVOArray.length < i) {
								newCurStand = copyVOArray[i]; 
							} else {
								newCurStand = copyVOArray[i - 1]; 
							}
							setCurStandId(newCurStand.getPartId());
							// curStandId = newCurStand.getPartId(); 
						} else {
							setCurStandId(new Integer(0));
							// curStandId = new Integer(0); 
						}
					}	
				}
			}
			setDeletedStandId(new Integer(0));
		}
		else if (curStId != null) {
			// перебираем массив шкафов и для текущего шкафа меняем статус
			for (int i = 0; i < this.getStands().length; i++) {
				StandVO curStandVO = this.getStands()[i];
				if ((curStandVO.getPartId().equals(curStId)) && (curStandVO.getCurState().equals(BSEquipCommonVO.KEEP_STATE))) {
					curStandVO.setCurState(BSEquipCommonVO.UPDATE_STATE);
				}
			}
		}
	}

	/**
	 * @param antennVOs
	 * @return
	 */
	private AntennVO[] refreshAntennFiderTypes(AntennVO[] antennVOs) {
		for (int i = 0; i < antennVOs.length; i++) {
			
			antennVOs[i].setFiderType900List(CDBCBaseStationObject.getFiderModelsList(new Integer(this.getFidersProduserId()), 
			new Integer(CDBCBaseStationObject.getIntegerString(antennVOs[i].getFiderType900Id()))));
			antennVOs[i].setFiderType1800List(CDBCBaseStationObject.getFiderModelsList(new Integer(this.getFidersProduserId()), 
				new Integer(CDBCBaseStationObject.getIntegerString(antennVOs[i].getFiderType1800Id()))));
		}
		return antennVOs;
	}

	/**
	 * @param standVOs
	 * @return
	 */
	private StandVO[] refreshStandTypes(StandVO[] standVOs) {
		for (int i = 0; i < standVOs.length; i++) {
			standVOs[i].setTypes(CDBCBaseStationObject.getStandModelsList(new Integer(this.getStandsProduserId()).intValue(), 
								standVOs[i].getCurTypeId()));
		}
		return standVOs;
	}

	public int getApplication() {
		return com.hps.july.constants.Applications.INVENTORY;
	}
	
	public AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request)
		throws Exception {
		return null;
	}
	
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("administrator");
		roles.add("TechStuff");
		roles.add("siteExploitor");
		roles.add("siteStation");
		roles.add("siteTransport");
		return roles;
	}
	
	/**
	 * @return
	 */
	public java.lang.String getSearchParameterName() {
		return searchParameterName;
	}

	/**
	 * @return
	 */
	public java.lang.String getSearchParameterValue() {
		return searchParameterValue;
	}

	/**
	 * @param string
	 */
	public void setSearchParameterName(java.lang.String string) {
		searchParameterName = string;
	}

	/**
	 * @param string
	 */
	public void setSearchParameterValue(java.lang.String string) {
		searchParameterValue = string;
	}

	/**
	 * @return
	 */
	public String getBsName() {
		return bsName;
	}

	/**
	 * @return
	 */
	public String getBsNumber() {
		return bsNumber;
	}

	/**
	 * @return
	 */
	public String getPosAddress() {
		return posAddress;
	}

	/**
	 * @param string
	 */
	public void setBsName(String string) {
		bsName = string;
	}

	/**
	 * @param string
	 */
	public void setBsNumber(String string) {
		bsNumber = string;
	}

	/**
	 * @param string
	 */
	public void setPosAddress(String string) {
		posAddress = string;
	}

	/**
	 * @return
	 */
	public String getDcsAfsMountingTest() {
		return dcsAfsMountingTest.getString();
	}

	/**
	 * @return
	 */
	public String getDcsBscConnection() {
		return dcsBscConnection.getString();
	}

	/**
	 * @return
	 */
	public String getDcsBsConstructionBegin() {
		return dcsBsConstructionBegin.getString();
	}

	/**
	 * @return
	 */
	public String getDcsBsMountingTest() {
		return dcsBsMountingTest.getString();
	}

	/**
	 * @return
	 */
	public String getDcsOnAir() {
		return dcsOnAir.getString();
	}

	/**
	 * @return
	 */
	public String getDcsState() {
		return dcsState;
	}

	/**
	 * @return
	 */
	public String getGsmAfsMountingTest() {
		return gsmAfsMountingTest.getString();
	}

	/**
	 * @return
	 */
	public String getGsmBscConnection() {
		return gsmBscConnection.getString();
	}

	/**
	 * @return
	 */
	public String getGsmBsConstructionBegin() {
		return gsmBsConstructionBegin.getString();
	}

	/**
	 * @return
	 */
	public String getGsmBsMountingTest() {
		return gsmBsMountingTest.getString();
	}

	/**
	 * @return
	 */
	public String getGsmOnAir() {
		return gsmOnAir.getString();
	}

	/**
	 * @return
	 */
	public String getGsmState() {
		return gsmState;
	}

	/**
	 * @return
	 */
	public Boolean getIsDcs() {
		return isDcs;
	}

	/**
	 * @return
	 */
	public Boolean getIsGsm() {
		return isGsm;
	}

	/**
	 * @param date
	 */
	public void setDcsAfsMountingTest(String date) {
		dcsAfsMountingTest.setString(date);
	}

	/**
	 * @param date
	 */
	public void setDcsBscConnection(String date) {
		dcsBscConnection.setString(date);
	}

	/**
	 * @param date
	 */
	public void setDcsBsConstructionBegin(String date) {
		dcsBsConstructionBegin.setString(date);
	}

	/**
	 * @param date
	 */
	public void setDcsBsMountingTest(String date) {
		dcsBsMountingTest.setString(date);
	}

	/**
	 * @param date
	 */
	public void setDcsOnAir(String date) {
		dcsOnAir.setString(date);
	}

	/**
	 * @param string
	 */
	public void setDcsState(String string) {
		dcsState = string;
	}

	/**
	 * @param date
	 */
	public void setGsmAfsMountingTest(String date) {
		gsmAfsMountingTest.setString(date);
	}

	/**
	 * @param date
	 */
	public void setGsmBscConnection(String date) {
		gsmBscConnection.setString(date);
	}

	/**
	 * @param date
	 */
	public void setGsmBsConstructionBegin(String date) {
		gsmBsConstructionBegin.setString(date);
	}

	/**
	 * @param date
	 */
	public void setGsmBsMountingTest(String date) {
		gsmBsMountingTest.setString(date);
	}

	/**
	 * @param date
	 */
	public void setGsmOnAir(String date) {
		gsmOnAir.setString(date);
	}

	/**
	 * @param string
	 */
	public void setGsmState(String string) {
		gsmState = string;
	}

	/**
	 * @param boolean1
	 */
	public void setIsDcs(Boolean boolean1) {
		isDcs = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setIsGsm(Boolean boolean1) {
		isGsm = boolean1;
	}

	/**
	 * @return
	 */
	public List getDtRepList() {
		return dtRepList;
	}

	/**
	 * @param list
	 */
	public void setDtRepList(List list) {
		dtRepList = list;
	}

	/**
	 * @return
	 */
	public List getControllers() {
		return controllers;
	}

	/**
	 * @param list
	 */
	public void setControllers(List list) {
		controllers = list;
	}
	
	/**
	 * @return
	 */
	public String getControllerId() {
		return controllerId;
	}

	/**
	 * @param integer
	 */
	public void setControllerId(String string) {
		controllerId = string;
	}

	/**
	 * @return
	 */
	public StandVO[] getStands() {
		return stands;
	}

	/**
	 * @return
	 */
	public String getStandsProduserId() {
		return standsProduserId;
	}

	/**
	 * @return
	 */
	public List getStandsProdusers() {
		// забрать из базы
		if (standsProdusers == null) {
			List sp = CDBCBaseStationObject.getStandsProcucersList();
			System.out.println("ConfigEqEditForm getStandsProdusers sp.size() = "+sp.size());
			setStandsProdusers(sp);
			if (sp.size() > 0) {
				setStandsProduserId(((OptionItem)(sp.get(0))).getCode());
			}
		}
		return standsProdusers;
	}

	/**
	 * @param list
	 */
	public void setStands(StandVO[] array) {
		stands = array;
	}

	/**
	 * @param integer
	 */
	public void setStandsProduserId(String string) {
		standsProduserId = string;
	}

	/**
	 * @param list
	 */
	public void setStandsProdusers(List list) {
		standsProdusers = list;
	}

	/**
	 * @return
	 */
	public Integer getStandsQuantity() {
		// standsQuantity = new Integer(stands.length);
		int standsQuantity = 0;
		for (int i = 0; i < stands.length; i++) {
			if (! stands[i].getCurState().equals(BSEquipCommonVO.DELETE_STATE)) {
				standsQuantity++;
			}
		}
		return new Integer(standsQuantity);
	}

	/**
	 * @param integer
	 */
	public void setStandsQuantity(Integer integer) {
		// standsQuantity = integer;
	}

	/**
	 * @return
	 */
	public String getPartForSubmit() {
		return partForSubmit;
	}

	/**
	 * @param string
	 */
	public void setPartForSubmit(String string) {
		partForSubmit = string;
	}

	/**
	 * @return
	 */
	public String getDebugInfo() {
		debugInfo = new Date().toString().substring(11,19);
		return debugInfo;
	}

	/**
	 * @param string
	 */
	public void setDebugInfo(String string) {
		// debugInfo = string;
	}

	/**
	 * @return
	 */
	public String getFidersProduserId() {
		return fidersProduserId;
	}

	/**
	 * @return
	 */
	public List getFidersProdusers() {
		// забрать из базы
		if (fidersProdusers == null) {
			List sp = CDBCBaseStationObject.getFidersProcucersList();
			System.out.println("ConfigEqEditForm getFidersProdusers sp.size() = "+sp.size());
			setFidersProdusers(sp);
			if (sp.size() > 0) {
				setFidersProduserId(((OptionItem)(sp.get(0))).getCode());
			}
		}
		return fidersProdusers;
	}

	/**
	 * @param string
	 */
	public void setFidersProduserId(String string) {
		fidersProduserId = string;
	}

	/**
	 * @param list
	 */
	public void setFidersProdusers(List list) {
		fidersProdusers = list;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_A_1800() {
		return sumSector_A_1800;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_B_1800() {
		return sumSector_B_1800;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_C_1800() {
		return sumSector_C_1800;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_D_1800() {
		return sumSector_D_1800;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_E_900() {
		return sumSector_E_900;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_F_900() {
		return sumSector_F_900;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_G_900() {
		return sumSector_G_900;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_H_900() {
		return sumSector_H_900;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_O_1800() {
		return sumSector_O_1800;
	}

	/**
	 * @return
	 */
	public Boolean getSumSector_O_900() {
		return sumSector_O_900;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_A_1800(Boolean boolean1) {
		sumSector_A_1800 = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_B_1800(Boolean boolean1) {
		sumSector_B_1800 = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_C_1800(Boolean boolean1) {
		sumSector_C_1800 = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_D_1800(Boolean boolean1) {
		sumSector_D_1800 = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_E_900(Boolean boolean1) {
		sumSector_E_900 = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_F_900(Boolean boolean1) {
		sumSector_F_900 = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_G_900(Boolean boolean1) {
		sumSector_G_900 = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_H_900(Boolean boolean1) {
		sumSector_H_900 = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_O_1800(Boolean boolean1) {
		sumSector_O_1800 = boolean1;
	}

	/**
	 * @param boolean1
	 */
	public void setSumSector_O_900(Boolean boolean1) {
		sumSector_O_900 = boolean1;
	}

	/**
	 * @return
	 */
	public String getSumAntenn_A_1800_Str() {
		return convertSumIntToStr(sumAntenn_A_1800);
	}

	/**
	 * @return
	 */
	public String getSumAntenn_B_1800_Str() {
		return convertSumIntToStr(sumAntenn_B_1800);
	}

	/**
	 * @return
	 */
	public String getSumAntenn_C_1800_Str() {
		return convertSumIntToStr(sumAntenn_C_1800);
	}

	/**
	 * @return
	 */
	public String getSumAntenn_D_1800_Str() {
		return convertSumIntToStr(sumAntenn_D_1800);
	}

	/**
	 * @return
	 */
	public String getSumAntenn_E_900_Str() {
		return convertSumIntToStr(sumAntenn_E_900);
	}

	/**
	 * @return
	 */
	public String getSumAntenn_F_900_Str() {
		return convertSumIntToStr(sumAntenn_F_900);
	}

	/**
	 * @return
	 */
	public String getSumAntenn_G_900_Str() {
		return convertSumIntToStr(sumAntenn_G_900);
	}

	/**
	 * @return
	 */
	public String getSumAntenn_H_900_Str() {
		return convertSumIntToStr(sumAntenn_H_900);
	}

	/**
	 * @return
	 */
	public String getSumAntenn_O_1800_Str() {
		return convertSumIntToStr(sumAntenn_O_1800);
	}

	/**
	 * @return
	 */
	public String getSumAntenn_O_900_Str() {
		return convertSumIntToStr(sumAntenn_O_900);
	}

	/**
	 * @return
	 */
	public String getSumTrans_A_1800_Str() {
		return convertSumIntToStr(sumTrans_A_1800);
	}

	/**
	 * @return
	 */
	public String getSumTrans_B_1800_Str() {
		return convertSumIntToStr(sumTrans_B_1800);
	}

	/**
	 * @return
	 */
	public String getSumTrans_C_1800_Str() {
		return convertSumIntToStr(sumTrans_C_1800);
	}

	/**
	 * @return
	 */
	public String getSumTrans_D_1800_Str() {
		return convertSumIntToStr(sumTrans_D_1800);
	}

	/**
	 * @return
	 */
	public String getSumTrans_E_900_Str() {
		return convertSumIntToStr(sumTrans_E_900);
	}

	/**
	 * @return
	 */
	public String getSumTrans_F_900_Str() {
		return convertSumIntToStr(sumTrans_F_900);
	}

	/**
	 * @return
	 */
	public String getSumTrans_G_900_Str() {
		return convertSumIntToStr(sumTrans_G_900);
	}

	/**
	 * @return
	 */
	public String getSumTrans_H_900_Str() {
		return convertSumIntToStr(sumTrans_H_900);
	}

	/**
	 * @return
	 */
	public String getSumTrans_O_1800_Str() {
		return convertSumIntToStr(sumTrans_O_1800);
	}

	/**
	 * @return
	 */
	public String getSumTrans_O_900_Str() {
		return convertSumIntToStr(sumTrans_O_900);
	}

	private String convertSumIntToStr(Integer theInt) {
		String outStr = "-";
		int num = theInt.intValue();
		if (num > 0) {
			outStr = String.valueOf(num);			
		}
		return outStr;
	}

	/**
	 * @return
	 */
	public Integer getCurStandId() {
		return curStandId;
	}

	/**
	 * @param string
	 */
	public void setCurStandId(Integer integer) {
			curStandId = integer;
	}

	/**
	 * @return
	 */
	public AntennVO[] getAntenns() {
		return antenns;
	}

	/**
	 * @return
	 */
	public Integer getAntennsQuantity() {
		antennsQuantity = new Integer(antenns.length);
		return antennsQuantity;
	}

	/**
	 * @return
	 */
	public Integer getCurAntennId() {
		return curAntennId;
	}

	/**
	 * @param antennVOs
	 */
	public void setAntenns(AntennVO[] antennVOs) {
		antenns = antennVOs;
	}

	/**
	 * @param integer
	 */
	public void setCurAntennId(Integer integer) {
		curAntennId = integer;
	}

	/**
	 * @return
	 */
	public Integer getDeletedStandId() {
		return deletedStandId;
	}

	/**
	 * @param integer
	 */
	public void setDeletedStandId(Integer integer) {
		deletedStandId = integer;
	}

	/**
	 * @return
	 */
	public Boolean getIsInsertNewStand() {
		return isInsertNewStand;
	}

	/**
	 * @param boolean1
	 */
	public void setIsInsertNewStand(Boolean boolean1) {
		isInsertNewStand = boolean1;
	}

	/**
	 * @return
	 */
	public List getDeletedAddedStandsList() {
		return deletedAddedStandsList;
	}

	/**
	 * @param list
	 */
	public void setDeletedAddedStandsList(List list) {
		deletedAddedStandsList = list;
	}

}
