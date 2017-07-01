package com.hps.july.arenda.cdbcobjects;

import java.math.BigDecimal;
import java.util.Enumeration;

import javax.rmi.PortableRemoteObject;

import com.hps.july.cdbc.lib.*;
import com.hps.july.arenda.formbean.AbstractRegistryBuchDocsStateFactory;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.persistence.*;
import com.hps.july.valueobject.DomainObject;
import com.hps.july.web.util.StringAndSqlDateProperty;

/**
 * Helper for CDBC .
 * Creation date: (19.10.2005 20:23:50)
 * @author: Shafigullin Ildar
 */
public class CDBC_Helper {
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 13:58:17)
	 */
	public static final LoanAktGetPut_VO createLoanAktGetPut(CDBCRowObject ro) {
		LoanAktGetPut_VO vo = new LoanAktGetPut_VO((Integer) ro.getColumn("idact").asObject(), (Integer) ro.getColumn("loanContract").asObject());
		vo.setNumberAct(ro.getColumn("numberact").asString());
		vo.setDateAct((java.sql.Date) ro.getColumn("dateAct").asObject());
		vo.setOurMan((Integer) ro.getColumn("ourman").asObject());
		vo.setOtherMan(ro.getColumn("otherman").asString());
		vo.setTypeAct(ro.getColumn("typeact").asString());
		vo.setIdLeasebill((Integer) ro.getColumn("idleasebill").asObject());

		mapDomainObject(vo, ro);
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.12.2005 12:08:46)
	 */
	public final static PeopleVO getPeopleVO_fromOperatorCode(String remoteUser) {
		//инициализируем исполнителя:
		PeopleVO peopleVO = null;
		try {
			Integer oper = OperatorObject.getOperatorCode(remoteUser);
			OperatorAccessBean oab = new OperatorAccessBean();
			oab.setInitKey_operator(oper.intValue());
			oab.refreshCopyHelper();
			int man = oab.getManKey().man;
			PeopleAccessBean pab = new PeopleAccessBean();
			pab.setInitKey_man(man);
			peopleVO = new PeopleVO(new Integer(man));
			peopleVO.setName(pab.getFullName());
			peopleVO.setOperatorCode(oper);
		} catch (Exception e) {
			System.out.println("Exception from CDBC_Helper.getPeopleVO_fromOperatorCode remoteUser=" + remoteUser);
			System.out.println("Cannot determine operator");
			e.printStackTrace(System.out);
		}
		return peopleVO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.10.2005 16:05:26)
	 */
	public static final CurrencyVO initCurrencyVO(CDBCRowObject ro, String key, String name) {
		if (ro.getColumn(key).asObject() != null) {
			CurrencyVO vo = new CurrencyVO(((Integer) ro.getColumn(key).asObject()));
			vo.setName(ro.getColumn(name).asString());
			return vo;
		} else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.10.2005 20:19:57)
	 */
	public static final StoragePlaceVO initStoragePlaceVO(CDBCRowObject ro, String key, String name) {
		if (ro.getColumn(key).asObject() != null) {
			StoragePlaceVO vo = new StoragePlaceVO(((Integer) ro.getColumn(key).asObject()).intValue());
			vo.setName(ro.getColumn(name).asString());
			return vo;
		} else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (19.10.2005 20:22:20)
	 */
	public static final WorkerVO initWorkerVO(CDBCRowObject ro, String key, String name) {
		if (ro.getColumn(key).asObject() != null) {
			WorkerVO vo = new WorkerVO((Integer) ro.getColumn(key).asObject());
			vo.setName(ro.getColumn(name).asString());
			return vo;
		} else
			return null;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 14:23:56)
	 */
	public static final void mapDomainObject(com.hps.july.valueobject.DomainObject vo, CDBCRowObject ro) {
		vo.setCreated((java.sql.Timestamp) ro.getColumn("created").asObject());
		vo.setCreatedBy((Integer) ro.getColumn("createdby").asObject());
		vo.setModified((java.sql.Timestamp) ro.getColumn("modified").asObject());
		vo.setModifiedBy((Integer) ro.getColumn("modifiedby").asObject());
	}
	/**
	 * 
	 * @param aDomainObject
	 */
	public static void initDomainObject(DomainObject aDomainObject, PeopleVO aPeopleVO) {
		aDomainObject.setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
		aDomainObject.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		if (aPeopleVO != null) {
			aDomainObject.setCreatedBy(aPeopleVO.getMan());
			aDomainObject.setModifiedBy(aPeopleVO.getMan());
		} else {
			System.err.println("Код оператора не инициализирован");
		}
	}
	/**
	 * 
	 * @param aDomainObject
	 */
	public static void updateDomainObject(DomainObject aDomainObject, PeopleVO aPeopleVO) {
		aDomainObject.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		if (aPeopleVO != null) {
			aDomainObject.setModifiedBy(aPeopleVO.getMan());
		} else {
			System.err.println("Код оператора не инициализирован");
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 13:58:17)
	 */
	public static final LeaseSchetFact_VO createLeaseSchetFakt(CDBCRowObject ro) {
		LeaseSchetFact_VO vo = new LeaseSchetFact_VO((Integer) ro.getColumn("idSchetFakt").asObject());
		vo.setIdContract((Integer) ro.getColumn("idContract").asObject());
		vo.setIdAkt((Integer) ro.getColumn("idAkt").asObject());
		vo.setIdCurrency((Integer) ro.getColumn("idCurrency").asObject());
		vo.setNumberSchetFakt(ro.getColumn("numberSchetFakt").asString());
		vo.setDateSchetFakt((java.sql.Date) ro.getColumn("dateSchetFakt").asObject());
		vo.setBaseDocNumber(ro.getColumn("baseDocNumber").asString());
		vo.setBaseDocDate((java.sql.Date) ro.getColumn("baseDocDate").asObject());
		vo.setDateStartSf((java.sql.Date) ro.getColumn("dateStartSf").asObject());
		vo.setDateEndSf((java.sql.Date) ro.getColumn("dateEndSf").asObject());
		vo.setState(ro.getColumn("state").asString());

		mapDomainObject(vo, ro);
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.07.2005 9:59:41)
	 * @deprecated
	 * см. getPeopleVO_fromOperatorCode(String)
	 */
	public static PeopleVO getPeopleVO_fromOperatorCode(javax.servlet.http.HttpServletRequest request) {
		//инициализируем исполнителя:
		PeopleVO peopleVO = null;
		try {
			Integer oper = OperatorObject.getOperatorCode(request.getRemoteUser());
			OperatorAccessBean oab = new OperatorAccessBean();
			oab.setInitKey_operator(oper.intValue());
			oab.refreshCopyHelper();
			int man = oab.getManKey().man;
			PeopleAccessBean pab = new PeopleAccessBean();
			pab.setInitKey_man(man);
			peopleVO = new PeopleVO(new Integer(man));
			peopleVO.setName(pab.getFullName());
		} catch (Exception e) {
			System.out.println("Cannot determine operator");
			e.printStackTrace(System.out);
		}
		return peopleVO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 13:58:17)
	 */
	public static final LeaseRegistryBuchDocs_VO createLeaseRegistryBuchDocs(CDBCRowObject ro) {
		LeaseRegistryBuchDocs_VO vo = new LeaseRegistryBuchDocs_VO((Integer) ro.getColumn("idRegistryDoc").asObject());
		vo.setTypeRegistry((Integer) ro.getColumn("typeRegistry").asObject());
		vo.setState(ro.getColumn("state").asString());
		vo.setOwner((Integer) ro.getColumn("owner").asObject());
		vo.setRegionID((Integer) ro.getColumn("regionid").asObject());
		vo.setTypeTransferRegistry((Integer) ro.getColumn("typeTransferRegistry").asObject());
		vo.setIdRegistryDocPurcher((Integer) ro.getColumn("idRegistryDocPurcher").asObject());
		vo.setIdRegistryDocAccountant((Integer) ro.getColumn("idRegistryDocAccountant").asObject());

		mapDomainObject(vo, ro);
		return vo;
	}

	/**
	 * список Истории изменения описей.
	 * Creation date: (27.03.2007 13:58:17)
	 */
	public static final LeaseRegistryBuchDocsHistory_VO createLeaseRegistryBuchDocsHistory(CDBCRowObject ro) {
		Integer historyId = (Integer) ro.getColumn("historyId").asObject(); //ID записи(PK).
		Integer idRegistryDoc = (Integer) ro.getColumn("idRegistryDoc").asObject(); //ID описи.
		Integer man = (Integer) ro.getColumn("man").asObject(); //код Оператора.
		java.sql.Timestamp actionTime = (java.sql.Timestamp) ro.getColumn("actionTime").asObject(); //Время записи.
		//Состояние:
		String stateStr = ro.getColumn("state").asString();
		RegistryBuchDocsState state = AbstractRegistryBuchDocsStateFactory.getState(stateStr);

		LeaseRegistryBuchDocsHistory_VO vo = new LeaseRegistryBuchDocsHistory_VO(historyId, idRegistryDoc, man, actionTime, state);
		return vo;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (27.07.2005 9:59:41)
	 */
	public static Integer getWorkerID_fromRemoteUser(String aRemoteUser) {
		Integer workerID = null;
		try {
			Integer oper = OperatorObject.getOperatorCode(aRemoteUser);
			OperatorAccessBean oab = new OperatorAccessBean();
			oab.setInitKey_operator(oper.intValue());
			oab.refreshCopyHelper();
			int man = oab.getManKey().man;
			PeopleAccessBean pab = new PeopleAccessBean();
			pab.setInitKey_man(man);
			pab.refreshCopyHelper();
			//WorkerAccessBeanTable wabt = new WorkerAccessBeanTable();
			Enumeration en = pab.getWorkers();
			if (en.hasMoreElements()) {
				Worker wrkab = (Worker) PortableRemoteObject.narrow(en.nextElement(), Worker.class);
				workerID = new Integer(wrkab.getWorker());
			}
		} catch (Exception e) {
			System.out.println("Cannot WorkerID");
			e.printStackTrace(System.out);
		}
		return workerID;
	}
	/**
	 * 
	 * @param IdContract
	 * @return String
	 */
	public static String getContractInfo(int IdContract) {
		String message = null;
		try {
			LeaseContractAccessBean bean = new LeaseContractAccessBean();
			bean.setInitKey_leaseDocument(IdContract);
			bean.refreshCopyHelper();
			if (bean.getContractType().equals("A")) {
				message = "Аренда";
			} else if (bean.getContractType().equals("B")) {
				message = "Аренда у нас";
			} else if (bean.getContractType().equals("C")) {
				message = "Аб.договор";
			} else if (bean.getContractType().equals("D")) {
				message = "Дог. на аренду канала связи";
			}
			StringAndSqlDateProperty dateProperty = new StringAndSqlDateProperty();
			dateProperty.setSqlDate(bean.getDocumentDate());
			message = message + ", № " + bean.getDocumentNumber() + ", от " + dateProperty.getString();
		} catch (Exception e) {
			System.out.println("Ощибка инициализации ContractInfo для IdContract()=" + IdContract);
			e.printStackTrace();
		}
		return message;

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 13:58:17)
	 */
	public static final LeasePriorCntForAct_VO createLeasePriorCntForAct(CDBCRowObject ro) {
		LeasePriorCntForAct_VO vo = new LeasePriorCntForAct_VO((Integer) ro.getColumn("idact").asObject(), (Integer) ro.getColumn("leasedocument").asObject());
		vo.setPriority((Integer) ro.getColumn("priority").asObject());

		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 13:58:17)
	 */
	public static final PositionVO createPositionVO(CDBCRowObject ro) {
		PositionVO vo = new PositionVO(((Integer) ro.getColumn("storageplace").asObject()).intValue());
		vo.setAddress(ro.getColumn("address").asString());
		vo.setClosedate((java.sql.Date) ro.getColumn("closedate").asObject());
		vo.setName(ro.getColumn("name").asString());
		//vo.setFullName()
		vo.setGsmid((Integer) ro.getColumn("gsmid").asObject());
		vo.setDampsid((Integer) ro.getColumn("dampsid").asObject());

		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (07.11.2005 13:58:17)
	 */
	public static final Dnop_VO createDnop_VO(CDBCRowObject ro) {
		Integer leaseCharge = ((Integer) ro.getColumn("leasecharge").asObject());
		Integer leasePayment = ((Integer) ro.getColumn("leasepayment").asObject());
		Dnop_VO vo = new Dnop_VO(leaseCharge, leasePayment);
		vo.setChargeSum((BigDecimal) ro.getColumn("chargesum").asObject());
		vo.setChargeRurRate((BigDecimal) ro.getColumn("chargerurrate").asObject());
		vo.setChargeRurSum((BigDecimal) ro.getColumn("chargerursum").asObject());
		vo.setPayRurSum((BigDecimal) ro.getColumn("payrursum").asObject());
		vo.setSource(ro.getColumn("source").asString());
		vo.setAct((Integer) ro.getColumn("act").asObject());
		vo.setUsedInAct((Integer) ro.getColumn("usedinact").asObject());
		vo.setByHandChrgRateRur(ro.getColumn("byhandchrgraterur").asString());
		return vo;
	}

	/**
	 * 
	 * @param ro
	 * @return
	 */
	public static final SaldoDetail_VO createSaldoDetail(CDBCRowObject ro) {
		SaldoDetail_VO vo = new SaldoDetail_VO((Integer) ro.getColumn("idSldDetail").asObject());
		vo.setLeaseContract((Integer) ro.getColumn("leasecontract").asObject());
		vo.setSalDate((java.sql.Date) ro.getColumn("saldate").asObject());
		vo.setResource((Integer) ro.getColumn("resource").asObject());
		vo.setMainCurrency((Integer) ro.getColumn("mainCurrency").asObject());
		vo.setAdditionalCurrency((Integer) ro.getColumn("additionalCurrency").asObject());
		vo.setAct((Integer) ro.getColumn("act").asObject());
		vo.setMainSum((BigDecimal) ro.getColumn("mainsum").asObject());
		vo.setMainNdsSum((BigDecimal) ro.getColumn("mainndssum").asObject());
		vo.setAdditionalSum((BigDecimal) ro.getColumn("additionalsum").asObject());
		vo.setAdditionalNdsSum((BigDecimal) ro.getColumn("additionalndssum").asObject());
		vo.setRateNds((BigDecimal) ro.getColumn("RateNds").asObject());
		vo.setGroupRec((Integer) ro.getColumn("GroupRec").asObject());
		vo.setSaldoByHand(ro.getColumn("saldobyhand").asString());
		vo.setNotes(ro.getColumn("notes").asString());
		vo.setMSumCalc((BigDecimal) ro.getColumn("mSumCalc").asObject());
		vo.setMNdsCalc((BigDecimal) ro.getColumn("mNDSCalc").asObject());
		vo.setASumCalc((BigDecimal) ro.getColumn("aSumCalc").asObject());
		vo.setANdsCalc((BigDecimal) ro.getColumn("aNDSCalc").asObject());
		vo.setOperator((Integer) ro.getColumn("operator").asObject());
		return vo;
	}
}
