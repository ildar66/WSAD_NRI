package com.hps.july.arenda.formbean;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hps.july.web.util.*;

import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.arenda.cdbcobjects.*;
import com.hps.july.arenda.valueobject.*;
/**
 * Все договора по позиции.
 * Creation date: (21.12.2004 10:44:58)
 * @author: Shafigullin Ildar
 */
public class ListFromPositionForm extends com.hps.july.web.util.EditForm {
	private PositionVO position;
	private Collection arendaList;
	private java.lang.String[] stateArenda;
	private Collection abonentList;
	private java.lang.String stateAbonent;
	private String abonentSortBy;
	private java.math.BigDecimal sum1OtherCurAll; //итоrовая сумма1 для договоров аренды:
	private java.math.BigDecimal trafic1OtherCurAll; //итог для трафиков договоров аренды:
	private int cntPhoneAbContr;
	private java.math.BigDecimal balanceAbonentAll;
	private java.lang.String operation = "";
	private int findPositionBy = -1;
	private java.lang.String searchString;
	private java.util.Collection lawyearNoteList;
	private com.hps.july.arenda.valueobject.LicenciesTO licenciesTO;
	private java.math.BigDecimal balanceAbonentUseInAct;
	private int cntPhoneAbContrUseInAct;
	//работаем с разделением по филиалам:
	private Boolean isRegionID = new Boolean(true);
	private Integer regionID = null;
	//Ссудные договора:
	private Collection loanList;
	private java.lang.String stateLoan;
	private String loanSortBy;
	private String locationHash;
	/**
	 * Insert the method's description here.
	 * Creation date: (21.12.2004 15:20:30)
	 */
	public ListFromPositionForm() {
		setPosition(new PositionVO());
		setStateArenda(new String[] { "B", "D" });
		setStateAbonent("ALL");
		setAbonentSortBy("ban desc");
		setLastVisited(true);
		setStateLoan("0");
		setLoanSortBy("docdate desc");
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 15:14:33)
	 * @return java.util.Collection
	 */
	public java.util.Collection getAbonentList() {
		return abonentList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 14:56:33)
	 * @return java.lang.String
	 */
	public java.lang.String getAbonentSortBy() {
		return abonentSortBy;
	}
	/**
	 * Текущее приложение.
	 * Creation date: (21.12.2004 10:44:58)
	 * @return int
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 11:45:03)
	 * @return java.util.Collection
	 */
	public java.util.Collection getArendaList() {
		return arendaList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.12.2004 17:33:41)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getBalanceAbonentAll() {
		return balanceAbonentAll;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.09.2005 15:53:27)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getBalanceAbonentUseInAct() {
		return balanceAbonentUseInAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.12.2004 17:30:55)
	 * @return int
	 */
	public int getCntPhoneAbContr() {
		return cntPhoneAbContr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.09.2005 15:53:56)
	 * @return int
	 */
	public int getCntPhoneAbContrUseInAct() {
		return cntPhoneAbContrUseInAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 15:45:29)
	 */
	public java.util.ArrayList getEditRoles() {
		java.util.ArrayList roles = new java.util.ArrayList();
		roles.add("ArendaMainEconomist");
		roles.add("ArendaEconomist");
		roles.add("administrator");
		return roles;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.12.2004 15:40:03)
	 * @return int
	 */
	public int getFindPositionBy() {
		return findPositionBy;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.07.2005 20:18:11)
	 * @return java.util.Collection
	 */
	public java.util.Collection getLawyearNoteList() {
		return lawyearNoteList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.09.2005 18:46:19)
	 * @return com.hps.july.arenda.valueobject.LicenciesTO
	 */
	public com.hps.july.arenda.valueobject.LicenciesTO getLicenciesTO() {
		return licenciesTO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.12.2004 15:17:29)
	 * @return java.lang.String
	 */
	public java.lang.String getOperation() {
		return operation;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.12.2004 15:19:47)
	 * @return com.hps.july.arenda.valueobject.PositionVO
	 */
	public com.hps.july.arenda.valueobject.PositionVO getPosition() {
		return position;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2005 12:31:08)
	 * @return java.lang.Integer
	 */
	private java.lang.Integer getRegionID() {
		return regionID;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.12.2004 14:46:41)
	 * @return java.lang.String
	 */
	public java.lang.String getSearchString() {
		return searchString;
	}
	/**
	 * Текущее состояние приложения.
	 * Creation date: (21.12.2004 10:44:58)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.LIST_FROM_POSITION;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 14:52:25)
	 * @return java.lang.String
	 */
	public java.lang.String getStateAbonent() {
		return stateAbonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.12.2004 15:36:53)
	 * @return java.lang.String
	 */
	public java.lang.String[] getStateArenda() {
		return stateArenda;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (23.12.2004 17:43:42)
	 * @return java.lang.String
	 */
	private String getStateArendaList() {
		if (getStateArenda() == null)
			return null;
		java.util.List list = Arrays.asList(getStateArenda());
		StringBuffer bf = new StringBuffer();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			//формируем список запроса:
			bf.append("'" + it.next());
			if (it.hasNext())
				bf.append("', ");
			else
				bf.append("'");
		}
		return bf.toString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.12.2004 11:07:25)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSum1OtherCurAll() {
		return sum1OtherCurAll;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.12.2004 11:07:25)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getTrafic1OtherCurAll() {
		return trafic1OtherCurAll;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.07.2005 20:20:38)
	 */
	private void init(javax.servlet.http.HttpServletRequest request) {
		initRegionID(request);
		initArendaList();
		initAbonentList();
		initLawyearNoteList();
		setLicenciesTO(LicenceDAO.viewLicencesOnPosition(new Integer(position.getStorageplace())));
		initLoanList();
	}
	/**
	 * Список ссудных договоров:
	 *
	 */
	private void initLoanList(){
		com.hps.july.cdbc.lib.CDBCResultSet rs =
		CDBC_LoanContract_Object.findListByPosition(
				Boolean.TRUE,
				new Integer(position.getStorageplace()),
				getStateLoan().equals("0") ? Boolean.FALSE : Boolean.TRUE,
				getStateLoan(),
				isRegionID,
				getRegionID(),
				getLoanSortBy());

		setLoanList(new ArrayList(rs.getRowsCount()));
		ListIterator iter = rs.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			LoanContractVO vo = new LoanContractVO(ro);
			vo.setManagerVO(initWorkerVO(ro, "manager", "managername"));
			vo.setEconomistVO(initWorkerVO(ro, "economist", "economistname"));
			vo.setMainpositionVO(initStoragePlaceVO(ro, "mainposition", "mainpositionname"));
			vo.setPlanCurrVO(com.hps.july.arenda.cdbcobjects.CDBC_Helper.initCurrencyVO(ro, "plancurr", "plancurrname"));
			getLoanList().add(vo);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 14:24:32)
	 */
	private void initAbonentList() {
		com.hps.july.cdbc.lib.CDBCResultSet rs =
			CDBCAbonentBAN_Object.findLeaseAbonentBANbyPosition(
				Boolean.TRUE,
				new Integer(position.getStorageplace()),
				getStateAbonent().equals("ALL") ? Boolean.FALSE : Boolean.TRUE,
				getStateAbonent(),
				isRegionID,
				getRegionID(),
				getAbonentSortBy());

		setAbonentList(new ArrayList(rs.getRowsCount()));
		ListIterator iter = rs.listIterator();
		setBalanceAbonentAll(new java.math.BigDecimal(0));
		setCntPhoneAbContr(0);
		setBalanceAbonentUseInAct(new java.math.BigDecimal(0));
		setCntPhoneAbContrUseInAct(0);
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			LeaseAbonentBAN_VO vo = new LeaseAbonentBAN_VO(ro);
			vo.setManagerVO(initWorkerVO(ro, "manager", "managername"));
			vo.setEconomistVO(initWorkerVO(ro, "economist", "economistname"));
			vo.setCntPhone(((Integer) ro.getColumn("cntphoneabcontr").asObject()).intValue());
			vo.setBalansNRI((java.math.BigDecimal) ro.getColumn("balansnri").asObject());
			getAbonentList().add(vo);
			if (vo.getBalans() != null) {
				if (vo.getUseinacts()) {
					setBalanceAbonentUseInAct(getBalanceAbonentUseInAct().add(vo.getBalans()));
				} else {
					setBalanceAbonentAll(getBalanceAbonentAll().add(vo.getBalans()));
				}
			}
			if (vo.getUseinacts()) {
				setCntPhoneAbContrUseInAct(getCntPhoneAbContrUseInAct() + vo.getCntPhone());
			} else {
				setCntPhoneAbContr(getCntPhoneAbContr() + vo.getCntPhone());
			}
		}
	}
	/**
	 * Заполняем лист аренды.
	 * Creation date: (22.12.2004 11:18:28)
	 */
	private void initArendaList() {
		Arrays.sort(getStateArenda());
		com.hps.july.cdbc.lib.CDBCResultSet rs =
			CDBCArendaAgreementObject.findArendaAgreementsByPosition(
				Boolean.TRUE,
				new Integer(position.getStorageplace()),
				Arrays.binarySearch(getStateArenda(), "ALL") < 0 ? Boolean.TRUE : Boolean.FALSE,
				getStateArendaList(),
				isRegionID,
				getRegionID(),
				new Integer(1));
		setArendaList(new ArrayList(rs.getRowsCount()));
		ListIterator iter = rs.listIterator();
		setSum1OtherCurAll(new java.math.BigDecimal(0));
		setTrafic1OtherCurAll(new java.math.BigDecimal(0));
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			com.hps.july.arenda.valueobject.LeaseArendaAgrmntVO vo = new com.hps.july.arenda.valueobject.LeaseArendaAgrmntVO(ro);
			vo.setNeedofficialdoc(ro.getColumn("needofficialdoc").asString());

			LeaseArendaAgreementNewVO valueObject = new LeaseArendaAgreementNewVO(vo);
			valueObject.setMainDocumentNumber(ro.getColumn("maindocumentnumber").asString());
			valueObject.setMainStartDate((java.sql.Date) ro.getColumn("mainstartdate").asObject());
			valueObject.setMainDocumentDate((java.sql.Date) ro.getColumn("maindocdate").asObject());
			valueObject.setMainPosition(ro.getColumn("mainposition").asString());
			valueObject.setAllPositions(ro.getColumn("allposition").asString());
			valueObject.setTrafic1((java.math.BigDecimal) ro.getColumn("trafic1").asObject());
			valueObject.setTrafic2((java.math.BigDecimal) ro.getColumn("trafic2").asObject());
			valueObject.setAccept1((java.math.BigDecimal) ro.getColumn("accept1").asObject());
			valueObject.setAccept2((java.math.BigDecimal) ro.getColumn("accept2").asObject());
			valueObject.setResources(ro.getColumn("resource").asString());
			valueObject.setMainManager(initWorkerVO(ro, "mainmanager", "mainmanagername"));
			valueObject.setMainEconomist(initWorkerVO(ro, "maineconomist", "maineconomistname"));
			valueObject.setMainContractState(ro.getColumn("maincontractstate").asString());
			valueObject.setMainDateClose((java.sql.Date) ro.getColumn("maindateclose").asObject());

			getArendaList().add(valueObject);
			//подсчет итоговой суммы и трафика:(только для исполняющихся(mainContract)):
			if (valueObject.getMainContractState().equals("B")) {
				setSum1OtherCurAll(getSum1OtherCurAll().add((java.math.BigDecimal) ro.getColumn("sum1othercur").asObject()));
				setTrafic1OtherCurAll(getTrafic1OtherCurAll().add((java.math.BigDecimal) ro.getColumn("trafic1othercur").asObject()));
			}
			//кол-во проблем:
			valueObject.setCountProblemOnContract((Integer) ro.getColumn("countProblemOnContract").asObject());
		}
	}
	/**
	 * Инициализация коллекций перед отображением пользователю.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		resetForm();
		if (getOperation().equals("initPosition")) {
			if (initPosition()) {
				init(request);
				setOperation("");
			} else {
				setPosition(new PositionVO());
				//System.out.println("Позиция не найдена или позиций больше одной !!! -> Вызов справочника позиций");
				setOperation("alertDictionary");
			}
		} else {
			//сортировки и вход на форму:
			init(request);
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 14:24:32)
	 */
	private void initLawyearNoteList() {
		com.hps.july.cdbc.lib.CDBCResultSet rs = CDBC_LawyearNote_Object.findLawyearNote_byPosition(new Integer(position.getStorageplace()), null);
		setLawyearNoteList(new ArrayList(rs.getRowsCount()));
		ListIterator iter = rs.listIterator();
		while (iter.hasNext()) {
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			LawyearNoteOnPosition_VO vo = new LawyearNoteOnPosition_VO(ro);
			//vo.setEconomistVO(initWorkerVO(ro, "economist", "economistname"));
			vo.setCreatedName(ro.getColumn("createdname").asString());
			vo.setModifiedName(ro.getColumn("modifiedname").asString());
			getLawyearNoteList().add(vo);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.12.2004 15:21:41)
	 * @return boolean
	 */
	private boolean initPosition() {
		CDBCResultSet rs = null;
		String search = "";
		if (getFindPositionBy() == 1) {
			rs = CDBCArendaAgreementObject.findPositionsDopInfo(true, getPosition().getStorageplace(), false, null, false, null);
		} else if (getFindPositionBy() == 2) {
			rs = CDBCArendaAgreementObject.findPositionsDopInfo(false, -1, true, getPosition().getGsmid(), false, null);
			if (getPosition().getGsmid() != null)
				search = getPosition().getGsmid().toString();
		} else if (getFindPositionBy() == 3) {
			rs = CDBCArendaAgreementObject.findPositionsDopInfo(false, -1, false, null, true, getPosition().getDampsid());
			if (getPosition().getDampsid() != null)
				search = getPosition().getDampsid().toString();
		}
		setSearchString(search);
		if (rs == null || rs.getRowsCount() == 0 || rs.getRowsCount() > 1)
			return false;
		else {
			ListIterator iter = rs.listIterator();
			CDBCRowObject ro = (CDBCRowObject) iter.next();
			PositionVO posVO = new PositionVO(((Integer) ro.getColumn("storageplace").asObject()).intValue());
			try {
				posVO.setDampsid(Integer.valueOf(ro.getColumn("dampsid").asString()));
			} catch (NumberFormatException e) {
				posVO.setDampsid(null);
			}
			try {
				posVO.setGsmid(Integer.valueOf(ro.getColumn("gsmid").asString()));
			} catch (NumberFormatException e) {
				posVO.setGsmid(null);
			}
			posVO.setName(ro.getColumn("name").asString());
			posVO.setAddress(ro.getColumn("address").asString());
			setPosition(posVO);
			//доп. информация об опоре:
			PositionDopInfoVO dopInfo = new PositionDopInfoVO();
			dopInfo.setAntennPlaceName(ro.getColumn("antennplacename").asString());
			dopInfo.setApparatPlaceName(ro.getColumn("apparatplacename").asString());
			dopInfo.setApparatTypename(ro.getColumn("apparattypename").asString());
			dopInfo.setApplacetypeName(ro.getColumn("applacetypename").asString());
			dopInfo.setIsvc(ro.getColumn("isvc").asString());
			dopInfo.setOporaour(ro.getColumn("oporaour").asString());
			dopInfo.setOporaPlaceName(ro.getColumn("oporaplacename").asString());

			getPosition().setDopInfoVO(dopInfo);

			return true;
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2005 12:31:52)
	 */
	private void initRegionID(HttpServletRequest request) {
		ProfileAccess profileAccess = getProfileAccess(request);
		if (profileAccess.getCurrRegion() != null) {
			Integer newRegionID = profileAccess.getCurrRegion().getVo().getRegionid();
			setRegionID(newRegionID);
		} else {
			//throw new RuntimeException("нет текущего региона для аренды!!!");
			System.out.println("нет текущего региона для аренды!!!");
			setRegionID(null);
		}
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	private ProfileAccess getProfileAccess(HttpServletRequest request) {
		Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
		if (profile == null) {
			throw new RuntimeException("Error:Profile = null");
		}
		ProfileAccess profileAccess = profile.getProfileAccess();
		if (profileAccess == null) {
			throw new RuntimeException("Error:profile.getProfileAccess() = null");
		}
		return profileAccess;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 15:17:37)
	 */
	private WorkerVO initWorkerVO(CDBCRowObject ro, String key, String name) {
		if (ro.getColumn(key).asObject() != null) {
			WorkerVO vo = new WorkerVO((Integer) ro.getColumn(key).asObject());
			vo.setName(ro.getColumn(name).asString());
			return vo;
		} else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (12.10.2005 19:12:19)
	 */
	private StoragePlaceVO initStoragePlaceVO(CDBCRowObject ro, String key, String name) {
		if (ro.getColumn(key).asObject() != null) {
			StoragePlaceVO vo = new StoragePlaceVO(((Integer) ro.getColumn(key).asObject()).intValue());
			vo.setName(ro.getColumn(name).asString());
			return vo;
		} else
			return null;
	}	
	/**
	 * Insert the method's description here.
	 * Creation date: (27.12.2004 18:11:50)
	 */
	private void resetForm() {
		setAbonentList(Collections.EMPTY_LIST);
		setArendaList(Collections.EMPTY_LIST);
		setSum1OtherCurAll(new java.math.BigDecimal(0));
		setTrafic1OtherCurAll(new java.math.BigDecimal(0));
		setBalanceAbonentAll(new java.math.BigDecimal(0));
		setCntPhoneAbContr(0);
		setLawyearNoteList(Collections.EMPTY_LIST);
		setLicenciesTO(null);
		setLoanList(Collections.EMPTY_LIST);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 15:14:33)
	 * @param newAbonentList java.util.Collection
	 */
	private void setAbonentList(java.util.Collection newAbonentList) {
		abonentList = newAbonentList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 14:56:33)
	 * @param newAbonentSortBy java.lang.String
	 */
	public void setAbonentSortBy(java.lang.String newAbonentSortBy) {
		abonentSortBy = newAbonentSortBy;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 11:45:03)
	 * @param newArendaList java.util.Collection
	 */
	private void setArendaList(java.util.Collection newArendaList) {
		arendaList = newArendaList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.12.2004 17:33:41)
	 * @param newBalanceAbonentAll java.math.BigDecimal
	 */
	private void setBalanceAbonentAll(java.math.BigDecimal newBalanceAbonentAll) {
		balanceAbonentAll = newBalanceAbonentAll;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.09.2005 15:53:27)
	 * @param newBalanceAbonentUseInAct java.math.BigDecimal
	 */
	private void setBalanceAbonentUseInAct(java.math.BigDecimal newBalanceAbonentUseInAct) {
		balanceAbonentUseInAct = newBalanceAbonentUseInAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.12.2004 17:30:55)
	 * @param newCntPhoneAbContr int
	 */
	private void setCntPhoneAbContr(int newCntPhoneAbContr) {
		cntPhoneAbContr = newCntPhoneAbContr;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (05.09.2005 15:53:56)
	 * @param newCntPhoneAbContrUseInAct int
	 */
	private void setCntPhoneAbContrUseInAct(int newCntPhoneAbContrUseInAct) {
		cntPhoneAbContrUseInAct = newCntPhoneAbContrUseInAct;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.12.2004 15:40:03)
	 * @param newFindPositionBy int
	 */
	public void setFindPositionBy(int newFindPositionBy) {
		findPositionBy = newFindPositionBy;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.07.2005 20:18:11)
	 * @param newLawyearNoteList java.util.Collection
	 */
	private void setLawyearNoteList(java.util.Collection newLawyearNoteList) {
		lawyearNoteList = newLawyearNoteList;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.09.2005 18:46:19)
	 * @param newLicenciesTO com.hps.july.arenda.valueobject.LicenciesTO
	 */
	private void setLicenciesTO(com.hps.july.arenda.valueobject.LicenciesTO newLicenciesTO) {
		licenciesTO = newLicenciesTO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.12.2004 15:17:29)
	 * @param newOperation java.lang.String
	 */
	public void setOperation(java.lang.String newOperation) {
		operation = newOperation;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.12.2004 15:19:47)
	 * @param newPosition com.hps.july.arenda.valueobject.PositionVO
	 */
	private void setPosition(com.hps.july.arenda.valueobject.PositionVO newPosition) {
		position = newPosition;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.11.2005 12:31:08)
	 * @param newRegionID java.lang.Integer
	 */
	private void setRegionID(java.lang.Integer newRegionID) {
		regionID = newRegionID;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (28.12.2004 14:46:41)
	 * @param newSearchString java.lang.String
	 */
	public void setSearchString(java.lang.String newSearchString) {
		searchString = newSearchString;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.12.2004 14:52:25)
	 * @param newStateAbonent java.lang.String
	 */
	public void setStateAbonent(java.lang.String newStateAbonent) {
		stateAbonent = newStateAbonent;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.12.2004 15:36:53)
	 * @param newStateArenda java.lang.String
	 */
	public void setStateArenda(java.lang.String[] newStateArenda) {
		stateArenda = newStateArenda;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.12.2004 11:07:25)
	 * @param newSum1OtherCuriAll java.math.BigDecimal
	 */
	private void setSum1OtherCurAll(java.math.BigDecimal newSum1OtherCurAll) {
		sum1OtherCurAll = newSum1OtherCurAll;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (24.12.2004 11:07:25)
	 * @param newTrafic1OtherCurAll java.math.BigDecimal
	 */
	private void setTrafic1OtherCurAll(java.math.BigDecimal newTrafic1OtherCurAll) {
		trafic1OtherCurAll = newTrafic1OtherCurAll;
	}
	/**
	 * @return
	 */
	public java.lang.String getStateLoan() {
		return stateLoan;
	}

	/**
	 * @param string
	 */
	public void setStateLoan(java.lang.String string) {
		stateLoan = string;
	}

	/**
	 * @return
	 */
	public Collection getLoanList() {
		return loanList;
	}

	/**
	 * @param collection
	 */
	private void setLoanList(Collection collection) {
		loanList = collection;
	}

	/**
	 * @return
	 */
	public String getLoanSortBy() {
		return loanSortBy;
	}

	/**
	 * @param string
	 */
	public void setLoanSortBy(String string) {
		loanSortBy = string;
	}

	/**
	 * @return
	 */
	public String getLocationHash() {
		return locationHash;
	}

	/**
	 * @param string
	 */
	public void setLocationHash(String string) {
		locationHash = string;
	}

}
