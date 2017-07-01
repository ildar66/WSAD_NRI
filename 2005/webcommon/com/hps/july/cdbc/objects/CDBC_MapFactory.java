package com.hps.july.cdbc.objects;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

import javax.rmi.PortableRemoteObject;

import com.hps.july.cdbc.lib.*;
import com.hps.july.persistence.CurrencyAccessBean;
import com.hps.july.persistence.OperatorAccessBean;
import com.hps.july.persistence.OperatorObject;
import com.hps.july.persistence.PeopleAccessBean;
import com.hps.july.persistence.WorkPosition;
import com.hps.july.persistence.WorkPositionAccessBean;
import com.hps.july.persistence.Worker;
import com.hps.july.valueobject.*;
/**
 * Insert the type's description here.
 * Creation date: (01.11.2005 15:22:49)
 * @author: Shafigullin Ildar
 */
public class CDBC_MapFactory {
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 15:24:04)
	 */
	public static final People_VO createPeople(CDBCRowObject ro) {
		People_VO vo = new People_VO((Integer) ro.getColumn("man").asObject());
		vo.setFirstname(ro.getColumn("firstname").asString());
		vo.setLastname(ro.getColumn("lastname").asString());
		vo.setMiddlename(ro.getColumn("middlename").asString());
		vo.setPassportser(ro.getColumn("passportser").asString());
		vo.setPassportdate((java.sql.Date) ro.getColumn("passportdate").asObject());
		vo.setPassportwhom(ro.getColumn("passportwhom").asString());
		vo.setIsactive(ro.getColumn("isactive").asString());
		vo.setTabnum((Integer) ro.getColumn("tabnum").asObject());
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 15:24:04)
	 */
	public static final Nfs_Users_VO createNfs_Users(CDBCRowObject ro) {
		Nfs_Users_VO vo = new Nfs_Users_VO((Integer) ro.getColumn("personID").asObject());
		vo.setIdUserNFS((Integer)ro.getColumn("idUserNFS").asObject());
		vo.setLogin(ro.getColumn("login").asString());
		vo.setFullName(ro.getColumn("fullName").asString());
		vo.setFlagWorkNRI(ro.getColumn("flagWorkNRI").asString());
		vo.setRecordStatus(ro.getColumn("recordStatus").asString());
		return vo;
	}	
	/**
	 * Insert the method's description here.
	 * Creation date: (21.11.2005 15:08:48)
	 */
	public static final RegionsAccess_VO createRegionsAccess(CDBCRowObject ro) {
		RegionsAccess_VO vo = new RegionsAccess_VO((Integer) ro.getColumn("accessid").asObject());
		vo.setOperatorid((Integer) ro.getColumn("operatorid").asObject());
		vo.setAccesstype(ro.getColumn("accesstype").asString());
		vo.setSupregionid((Integer) ro.getColumn("supregionid").asObject());
		vo.setRegionid((Integer) ro.getColumn("regionid").asObject());
		vo.setViewplan(ro.getColumn("viewplan").asString());
		vo.setViewfact(ro.getColumn("viewfact").asString());
		vo.setEditplan(ro.getColumn("editplan").asString());
		vo.setEditfact(ro.getColumn("editfact").asString());
		vo.setViewarenda(ro.getColumn("viewarenda").asString());
		vo.setEditarenda(ro.getColumn("editarenda").asString());
		vo.setHasArendaPurchaser(ro.getColumn("hasArendaPurchaser").asString());

		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.11.2005 12:07:10)
	 */
	public static final Role_VO createRole(CDBCRowObject ro) {
		String id = ro.getColumn("role").asString();
		String name = ro.getColumn("rolename").asString();
		Role_VO vo = new Role_VO(id, name);
		vo.setComment(ro.getColumn("comment").asString());
		vo.setSortOrder((Integer)ro.getColumn("sortOrder").asObject());
		vo.setTaskComment(ro.getColumn("taskComment").asString());
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.11.2005 11:26:57)
	 */
	public static final WorkPosition_VO createWorkPosition(CDBCRowObject ro) {
		WorkPosition_VO vo = new WorkPosition_VO((Integer) ro.getColumn("workposition").asObject());
		vo.setName(ro.getColumn("name").asString());
		vo.setIsactive(ro.getColumn("isactive").asString());
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (01.11.2005 15:24:04)
	 */
	public static final AdminRegion_VO createAdminRegion(CDBCRowObject ro) {
		AdminRegion_VO vo = new AdminRegion_VO((Integer) ro.getColumn("regionid").asObject());
		vo.setKzlregionid((Integer) ro.getColumn("kzlregionid").asObject());
		vo.setRegionname(ro.getColumn("regionname").asString());
		vo.setRegioncomment(ro.getColumn("regioncomment").asString());
		vo.setRegiontype((Integer) ro.getColumn("regiontype").asObject());
		vo.setRegionpopulation((Integer) ro.getColumn("regionpopulation").asObject());
		vo.setRuralpopulation((Integer) ro.getColumn("ruralpopulation").asObject());
		vo.setRegionarea((java.math.BigDecimal) ro.getColumn("regionarea").asObject());
		vo.setRegionlon((BigDecimal) ro.getColumn("regionlon").asObject());
		vo.setRegionlat((BigDecimal) ro.getColumn("regionlat").asObject());
		vo.setRegionkind(ro.getColumn("regionkind").asString());
		vo.setFilialnri((Integer) ro.getColumn("filialnri").asObject());
		vo.setParent_regionid((Integer) ro.getColumn("PARENT_REGIONID").asObject());
		vo.setKladrCode(ro.getColumn("kladrCode").asString());
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.01.2006 11:26:57)
	 */
	public static final SuperRegion_VO createSuperRegion(CDBCRowObject ro) {
		SuperRegion_VO vo = new SuperRegion_VO((Integer) ro.getColumn("supregid").asObject());
		vo.setSupRegName(ro.getColumn("supregname").asString());
		vo.setSupRegCode((Integer) ro.getColumn("supregcode").asObject());
		return vo;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.01.2006 11:26:57)
	 */
	public static final Region_VO createRegion(CDBCRowObject ro) {
		Region_VO vo =
			new Region_VO(
				(Integer) ro.getColumn("regionid").asObject(),
				(Integer) ro.getColumn("supregid").asObject(),
				ro.getColumn("regname").asString());
		return vo;
	}

	/**
	 * ћетод заполн€ет пол€ VO-наследников DomainObject.
	 * Creation date: (07.11.2005 14:23:56)
	 */
	public static final void mapDomainObject(com.hps.july.valueobject.DomainObject vo, CDBCRowObject ro) {
		vo.setCreated((java.sql.Timestamp) ro.getColumn("created").asObject());
		vo.setCreatedBy((Integer) ro.getColumn("createdby").asObject());
		vo.setModified((java.sql.Timestamp) ro.getColumn("modified").asObject());
		vo.setModifiedBy((Integer) ro.getColumn("modifiedby").asObject());
	}

	/**
	 * ћетод заполн€ет пол€ VO-наследников LeaseDocPosition_VO.
	 * Creation date: (07.11.2005 14:23:56)
	 */
	public static final void mapLeaseDocPositionObject(LeaseDocPosition_VO vo, CDBCRowObject ro) {
		vo.setLeaseDocPosition((Integer) ro.getColumn("leasedocposition").asObject());
		vo.setDocPosType(ro.getColumn("docpostype").asString());
		vo.setDate((Date) ro.getColumn("date").asObject());
		vo.setLeaseContract((Integer) ro.getColumn("leasecontract").asObject());
		vo.setSource(ro.getColumn("source").asString());
		vo.setDocPosVid(ro.getColumn("docposvid").asString());
		vo.setBeginDate((Date) ro.getColumn("begindate").asObject());
		vo.setEndDate((Date) ro.getColumn("enddate").asObject());
		vo.setAct((Integer) ro.getColumn("act").asObject());
		vo.setUsedInAct((Integer) ro.getColumn("usedinact").asObject());
		vo.setResource((Integer) ro.getColumn("resource").asObject());
		vo.setSumm((BigDecimal) ro.getColumn("summ").asObject());
		vo.setCurrency((Integer) ro.getColumn("currency").asObject());
		vo.setSumNds((BigDecimal) ro.getColumn("sumnds").asObject());
		vo.setOperator((Integer) ro.getColumn("operator").asObject());
		vo.setWillBeInAct((Integer) ro.getColumn("willbeinact").asObject());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21.01.2006 11:26:57)
	 */
	public static final LeaseCharge_VO createLeaseCharge(CDBCRowObject ro) {
		LeaseCharge_VO vo = new LeaseCharge_VO();
		mapDomainObject(vo, ro);
		mapLeaseDocPositionObject(vo, ro);
		
		vo.setLeaseRule((Integer)ro.getColumn("leaserule").asObject());
		vo.setRemainderSum((BigDecimal)ro.getColumn("remaindersum").asObject());
		vo.setRemainderRate2Rur((BigDecimal)ro.getColumn("remainderrate2rur").asObject());
		vo.setByHandRateRur(ro.getColumn("byhandraterur").asString());
		vo.setBillNumber(ro.getColumn("billnumber").asString());
		vo.setBillDate((Date)ro.getColumn("billdate").asObject());
		vo.setIsSchetFakt1(ro.getColumn("isschetfakt1").asString());
		vo.setIsSchetFakt2(ro.getColumn("isschetfakt2").asString());
		vo.setIsSchetFakt3(ro.getColumn("isschetfakt3").asString());
		vo.setUsedInCWAct((Integer)ro.getColumn("UsedInCWAct").asObject());
		vo.setIsWorkAct1(ro.getColumn("isWorkAct1").asString());
		vo.setIsWorkAct2(ro.getColumn("isWorkAct2").asString());
		vo.setIsWorkAct3(ro.getColumn("isWorkAct3").asString());
		vo.setOstSumForSF((BigDecimal)ro.getColumn("ostSumForSF").asObject());
		vo.setFlagSF((Integer)ro.getColumn("flagSF").asObject());
		vo.setOstSumForCwAct((BigDecimal)ro.getColumn("ostSumForCwAct").asObject());
		vo.setFlagCwAct((Integer)ro.getColumn("flagCwAct").asObject());
		vo.setNeedCwAct(ro.getColumn("needCwAct").asString());
		vo.setNeedSf(ro.getColumn("needSf").asString());		
		return vo;
	}
	
	/**
	 * create Bank_VO.
	 * Creation date: (02.11.2005 11:26:57)
	 */
	public static final Banks_VO createBank(CDBCRowObject ro) {
		Banks_VO vo = new Banks_VO((Integer) ro.getColumn("idBank").asObject());
		mapDomainObject(vo, ro);
		
		vo.setName(ro.getColumn("name").asString());
		vo.setBik(ro.getColumn("bik").asString());
		vo.setKorAccount(ro.getColumn("korAccount").asString());
		vo.setLegalAddress(ro.getColumn("legaladdress").asString());
		vo.setSwift(ro.getColumn("swift").asString());
		vo.setSource((Integer)ro.getColumn("source").asObject());
		vo.setRecordStatus(ro.getColumn("recordStatus").asString());
		return vo;
	}
	/**
	 * 
	 * @param aDomainObject
	 */
	public static void initDomainObject(DomainObject aDomainObject, People_VO aPeopleVO) {
		aDomainObject.setCreated(new java.sql.Timestamp(System.currentTimeMillis()));
		aDomainObject.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		if (aPeopleVO != null) {
			aDomainObject.setCreatedBy(aPeopleVO.getMan());
			aDomainObject.setModifiedBy(aPeopleVO.getMan());
		} else {
			System.err.println(" од оператора не инициализирован");
		}
	}	
	/**
	 * 
	 * @param aDomainObject
	 */
	public static void updateDomainObject(DomainObject aDomainObject, People_VO aPeopleVO) {
		aDomainObject.setModified(new java.sql.Timestamp(System.currentTimeMillis()));
		if (aPeopleVO != null) {
			aDomainObject.setModifiedBy(aPeopleVO.getMan());
		} else {
			System.err.println(" од оператора не инициализирован");
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.12.2005 12:08:46)
	 */
	public final static People_VO getPeopleVO_fromOperatorCode(String remoteUser) {
		//инициализируем исполнител€:
		People_VO peopleVO = null;
		try {
			Integer oper = OperatorObject.getOperatorCode(remoteUser);
			OperatorAccessBean oab = new OperatorAccessBean();
			oab.setInitKey_operator(oper.intValue());
			oab.refreshCopyHelper();
			int man = oab.getManKey().man;
			PeopleAccessBean pab = new PeopleAccessBean();
			pab.setInitKey_man(man);
			peopleVO = new People_VO(new Integer(man));
			peopleVO.setFirstname(pab.getFullName());
			peopleVO.setMiddlename(pab.getMiddlename());
			peopleVO.setLastname(pab.getLastname());
		} catch (Exception e) {
			System.out.println("Exception CDBC_MapFactory.getPeopleVO_fromOperatorCode remoteUser=" + remoteUser);
			System.out.println("Cannot determine operator");
			e.printStackTrace(System.out);
		}
		return peopleVO;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (02.12.2005 12:08:46)
	 */
	public final static People_TO getPeopleTO(String remoteUser) {
		//инициализируем исполнител€:
		People_TO peopleTO = null;
		try {
			Integer oper = OperatorObject.getOperatorCode(remoteUser);
			OperatorAccessBean oab = new OperatorAccessBean();
			oab.setInitKey_operator(oper.intValue());
			oab.refreshCopyHelper();
			int man = oab.getManKey().man;
			PeopleAccessBean pab = new PeopleAccessBean();
			pab.setInitKey_man(man);
			People_VO vo = new People_VO(new Integer(man));
			vo.setFirstname(pab.getFullName());
			vo.setMiddlename(pab.getMiddlename());
			vo.setLastname(pab.getLastname());
			peopleTO = new People_TO(vo, remoteUser, oper);
			
		} catch (Exception e) {
			System.out.println("Exception CDBC_MapFactory.getPeopleTO_fromOperatorCode remoteUser=" + remoteUser);
			System.out.println("Cannot determine operator");
			e.printStackTrace(System.out);
		}
		return peopleTO;
	}	
	/**
	 * create Vendor_VO.
	 * Creation date: (03.04.2006 11:26:57)
	 */
	public static final Vendor_VO createVendor(CDBCRowObject ro) {
		Vendor_VO vo = new Vendor_VO((Integer) ro.getColumn("idVendor").asObject());
		mapDomainObject(vo, ro);
		vo.setVendorCode((Integer)ro.getColumn("vendorcode").asObject());
		vo.setEnd_date_active((Timestamp)ro.getColumn("end_date_active").asObject());
		vo.setName(ro.getColumn("name").asString());
		vo.setInn(ro.getColumn("inn").asString());
		vo.setType(ro.getColumn("type").asString());
		vo.setUseInNri(ro.getColumn("useInNri").asString());
		vo.setRecordStatus(ro.getColumn("recordStatus").asString());
		vo.setSource((Integer)ro.getColumn("source").asObject());
		vo.setAccountManagerFio(ro.getColumn("accountmanagerfio").asString());
		vo.setDirectorFio(ro.getColumn("directorfio").asString());
		vo.setDirectorJob(ro.getColumn("directorjob").asString());
		vo.setPhisicalAddress(ro.getColumn("phisicaladdress").asString());
		vo.setLegalAddress(ro.getColumn("legaladdress").asString());
		vo.setComment(ro.getColumn("comment").asString());
		vo.setIdVendorNfs((Integer)ro.getColumn("idvendornfs").asObject());
		vo.setTypeVendor((Integer)ro.getColumn("typeVendor").asObject());
		
		vo.setLastName(ro.getColumn("lastName").asString());
		vo.setFirstName(ro.getColumn("firstName").asString());
		vo.setMiddleName(ro.getColumn("middleName").asString());
		vo.setPassportSer(ro.getColumn("passportSer").asString());
		vo.setPassportNum(ro.getColumn("passportNum").asString());
		vo.setPassportDate((Date)ro.getColumn("passportDate").asObject());
		vo.setPassportWhom(ro.getColumn("passportwhom").asString());
		vo.setNameForPrintDoc(ro.getColumn("nameForPrintDoc").asString());
		vo.setAddressForPrintDoc(ro.getColumn("addressForPrintDoc").asString());
		return vo;
	}
	
	/**
	 * create VendorSite_VO.
	 * Creation date: (03.04.2006 11:26:57)
	 */
	public static final VendorSite_VO createVendorSite(CDBCRowObject ro) {
		VendorSite_VO vo = new VendorSite_VO((Integer) ro.getColumn("idVendorSite").asObject());
		mapDomainObject(vo, ro);
		
		vo.setIdVendor((Integer)ro.getColumn("idVendor").asObject());
		vo.setIsOwnerContract(ro.getColumn("isOwnerContract").asString());
		vo.setIdOwnerNfs((Integer)ro.getColumn("idOwnerNfs").asObject());
		vo.setVendorSiteCode(ro.getColumn("vendorSiteCode").asString());
		vo.setName(ro.getColumn("name").asString());
		vo.setMatchOption(ro.getColumn("matchOption").asString());
		vo.setAddress(ro.getColumn("address").asString());
		vo.setKpp(ro.getColumn("kpp").asString());
		vo.setUseInNri(ro.getColumn("useInNri").asString());
		vo.setRecordStatus(ro.getColumn("recordStatus").asString());
		vo.setSource((Integer)ro.getColumn("source").asObject());
		vo.setAccountManagerFio(ro.getColumn("accountManagerFio").asString());
		vo.setDirectorFio(ro.getColumn("directorFio").asString());
		vo.setDirectorJob(ro.getColumn("directorJob").asString());		
		vo.setComment(ro.getColumn("comment").asString());
		vo.setIdVendorSiteNFS((Integer)ro.getColumn("idVendorSiteNFS").asObject());
		
		vo.setLastName(ro.getColumn("lastName").asString());
		vo.setFirstName(ro.getColumn("firstName").asString());
		vo.setMiddleName(ro.getColumn("middleName").asString());
		vo.setPassportSer(ro.getColumn("passportSer").asString());
		vo.setPassportNum(ro.getColumn("passportNum").asString());
		vo.setPassportDate((Date)ro.getColumn("passportDate").asObject());
		vo.setPassportWhom(ro.getColumn("passportwhom").asString());
		vo.setNameForPrintDoc(ro.getColumn("nameForPrintDoc").asString());
		vo.setAddressForPrintDoc(ro.getColumn("addressForPrintDoc").asString());

		return vo;
	}
	/**
	 * create Account_VO.
	 * Creation date: (02.11.2005 11:26:57)
	 */
	public static final Accounts_VO createAccount(CDBCRowObject ro) {
		Accounts_VO vo = new Accounts_VO((Integer) ro.getColumn("accountid").asObject());
		mapDomainObject(vo, ro);
		
		vo.setBank((Integer)ro.getColumn("bank").asObject());
		vo.setIdVendorSite((Integer)ro.getColumn("idVendorSite").asObject());
		vo.setAccount(ro.getColumn("account").asString());
		vo.setActive(new Boolean("Y".equals(ro.getColumn("active").asString())));
		return vo;
	}
	/**
	 * create createLeasePayOfficeMemo_VO.
	 * Creation date: (02.11.2005 11:26:57)
	 */
	public static final LeasePayOfficeMemo_VO createLeasePayOfficeMemo(CDBCRowObject ro) {
		LeasePayOfficeMemo_VO vo = new LeasePayOfficeMemo_VO((Integer) ro.getColumn("idOfficeMemo").asObject());
		mapDomainObject(vo, ro);
		
		vo.setLeaseContract((Integer)ro.getColumn("leasecontract").asObject());
		vo.setBeginDate((Date)ro.getColumn("beginDate").asObject());
		vo.setEndDate((Date)ro.getColumn("endDate").asObject());
		vo.setFlagAvans(ro.getColumn("flagAvans").asString());
		vo.setFlag3face(ro.getColumn("flag3face").asString());
		vo.setSum((BigDecimal)ro.getColumn("sum").asObject());
		vo.setNds((BigDecimal)ro.getColumn("nds").asObject());
		vo.setCurrency((Integer)ro.getColumn("currency").asObject());
		vo.setRuleRate(ro.getColumn("ruleRate").asString());
		vo.setOrgAcc((Integer)ro.getColumn("orgAcc").asObject());
		vo.setPurpose(ro.getColumn("purpose").asString());
		vo.setPp104(ro.getColumn("PP104").asString());
		vo.setPp105(ro.getColumn("PP105").asString());
		vo.setPpQueue((Integer)ro.getColumn("PPqueue").asObject());
		vo.setPpStatus(ro.getColumn("PPStatus").asString());
		vo.setState(ro.getColumn("state").asString());
		vo.setSumRub((BigDecimal)ro.getColumn("sumrub").asObject());
		vo.setNdsRub((BigDecimal)ro.getColumn("ndsrub").asObject());
		vo.setBillDate((Date)ro.getColumn("billdate").asObject());
		vo.setBillNumber(ro.getColumn("billnumber").asString());
		vo.setRateCalcRule((String)ro.getColumn("ratecalcrule").asObject());
		Short rateCalcRuleDay = (Short)ro.getColumn("ratecalcruleday").asObject();
		if(rateCalcRuleDay != null){
			vo.setRateCalcRuleDay(new Integer(rateCalcRuleDay.toString()));
		}
		vo.setRateDelta((BigDecimal)ro.getColumn("ratedelta").asObject());
		vo.setRateDate((Date)ro.getColumn("rateDate").asObject());
		vo.setRateValue((BigDecimal)ro.getColumn("RateValue").asObject());
		vo.setRateNds((BigDecimal)ro.getColumn("RateNds").asObject());
		vo.setIdZpNfs((Integer)ro.getColumn("idZpNfs").asObject());
		
		return vo;
	}
	/**
	 * create createLeaseZPOfficeMemo_VO.
	 * Creation date: (02.11.2005 11:26:57)
	 */
	public static final LeaseZPOfficeMemo_VO createLeaseZPOfficeMemo(CDBCRowObject ro) {
		LeaseZPOfficeMemo_VO vo = new LeaseZPOfficeMemo_VO((Integer) ro.getColumn("idOfficeMemo").asObject());
		mapDomainObject(vo, ro);
		
		vo.setLeaseContract((Integer)ro.getColumn("leasecontract").asObject());
		vo.setLeaseDopContract((Integer)ro.getColumn("leaseDopContract").asObject());
		vo.setFlagAddVendor(ro.getColumn("flagAddVendor").asString());
		vo.setFlagAddVendorSite(ro.getColumn("flagAddVendorSite").asString());
		vo.setFlagAddContract(ro.getColumn("flagAddContract").asString());
		vo.setTypeActionZP(ro.getColumn("TypeActionZP").asString());
		vo.setIdZP((Integer)ro.getColumn("idZP").asObject());
		vo.setOldSumZP((BigDecimal)ro.getColumn("oldSumZP").asObject());
		vo.setIdVendorSite((Integer)ro.getColumn("idVendorSite").asObject());
		vo.setIdResource((Integer)ro.getColumn("idResource").asObject());
		vo.setSumCharge((BigDecimal)ro.getColumn("SumCharge").asObject());
		vo.setSumZP((BigDecimal)ro.getColumn("sumZP").asObject());
		vo.setSumNdsZP((BigDecimal)ro.getColumn("sumNdsZP").asObject());
		vo.setIdCurrCharge((Integer)ro.getColumn("idCurrCharge").asObject());
		vo.setDateStartZP((Date)ro.getColumn("dateStartZP").asObject());
		vo.setDateEndZp((Date)ro.getColumn("dateEndZp").asObject());
		vo.setReason(ro.getColumn("reason").asString());
		vo.setRateNds((BigDecimal)ro.getColumn("rateNds").asObject());
		vo.setRateCalcRule(ro.getColumn("ratecalcrule").asString());
		vo.setRateDelta((BigDecimal)ro.getColumn("ratedelta").asObject());
		Short rateCalcRuleDay = (Short)ro.getColumn("ratecalcruleday").asObject();
		if(rateCalcRuleDay != null){
			vo.setRateCalcRuleDay(new Integer(rateCalcRuleDay.toString()));
		}
		vo.setRateFix((BigDecimal)ro.getColumn("rateFix").asObject());
		return vo;
	}
	
	/**
	 * Insert the method's description here.
	 * Creation date: (14.10.2005 19:02:34)
	 */
	public final static List getListCurrencies() {
		ArrayList listCurrencies = new ArrayList();
		try {
			CurrencyAccessBean bean = new CurrencyAccessBean();
			Enumeration enum = bean.findAllOrderByNameAsc();
			while (enum.hasMoreElements()) {
				CurrencyAccessBean ab = (CurrencyAccessBean) enum.nextElement();
				Currency_VO vo = new Currency_VO(new Integer(ab.getCurrency()));
				vo.setName(ab.getName());
				listCurrencies.add(vo);
			}
		} catch (Exception e) {
			System.out.println(" getListCurrencies(): ќшибка формировани€ листа валют!!!");
			e.printStackTrace(System.out);
		}
		return listCurrencies;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.07.2005 9:59:41)
	 */
	public static People_VO getPeopleVO_fromMan(Integer man) {
		//инициализируем People_VO:
		People_VO peopleVO = null;
		try {
			PeopleAccessBean pab = new PeopleAccessBean();
			pab.setInitKey_man(man.intValue());
			pab.refreshCopyHelper();
			peopleVO = new People_VO(man);
			peopleVO.setFirstname(pab.getFirstname());
			peopleVO.setMiddlename(pab.getMiddlename());
			peopleVO.setLastname(pab.getLastname());
			//setWorkers():
			Enumeration en = pab.getWorkers();
			ArrayList workers = new ArrayList();
			while(en.hasMoreElements()) {
				Worker wrkab = (Worker)PortableRemoteObject.narrow(en.nextElement(), Worker.class); 
				Worker_VO worker_VO=  new Worker_VO(new Integer(wrkab.getWorker()));
				worker_VO.setMan(man);
				worker_VO.setEmail(wrkab.getEmail());
				worker_VO.setFax(wrkab.getFax());
				worker_VO.setLocalPhone(wrkab.getLocalphone());
				worker_VO.setMobilePhone(wrkab.getMobilephone());
				Worker_TO to = new Worker_TO(worker_VO);
				//находим должность:
				WorkPosition workPos = wrkab.getPosition();;
				to.setWorkPositionName(workPos.getName());
				
				workers.add(to);
			}
			peopleVO.setWorkers(workers);
		} catch (Exception e) {
			System.out.println("Cannot getPeopleVO_fromMan= " + man);
			e.printStackTrace(System.out);
		}
		return peopleVO;
	}
	/**
	 * create createLeaseZPOfficeMemo_VO.
	 * Creation date: (02.11.2005 11:26:57)
	 */
	public static final LeaseContractProblem_VO createLeaseContractProblem(CDBCRowObject ro) {
		LeaseContractProblem_VO vo = new LeaseContractProblem_VO((Integer) ro.getColumn("idProblem").asObject());
		mapDomainObject(vo, ro);
		
		vo.setLeaseContract((Integer)ro.getColumn("leasecontract").asObject());
		vo.setNote(ro.getColumn("Note").asString());
		vo.setTypeProblem((Integer)ro.getColumn("TypeProblem").asObject());
		vo.setState((Integer)ro.getColumn("State").asObject());
		vo.setExecutor((Integer)ro.getColumn("executor").asObject());
		vo.setOwner((Integer)ro.getColumn("owner").asObject());
		return vo;
	}
	
	/**
	 * Insert the method's description here.
	 * Creation date: (03.11.2005 12:07:10)
	 */
	public static final Currency_VO createCurrency(CDBCRowObject ro) {
		Integer id = (Integer)ro.getColumn("currency").asObject();
		String name = ro.getColumn("name").asString();
		String shortName = ro.getColumn("shortname").asString();
		Currency_VO vo = new Currency_VO(id, name, shortName);
		return vo;
	}	

	/**
	 * create OperatorNRI.
	 * Creation date: (02.11.2005 11:26:57)
	 */
	public static final Operator_VO createOperator(CDBCRowObject ro) {
		Operator_VO vo = new Operator_VO((Integer) ro.getColumn("operator").asObject());
		//mapDomainObject(vo, ro);
		
		vo.setMan((Integer)ro.getColumn("man").asObject());
		vo.setLoiginID(ro.getColumn("loiginID").asString());
		vo.setIsEnabled(ro.getColumn("isEnabled").asString());
		vo.setMsuCode((Integer)ro.getColumn("msuCode").asObject());
		vo.setLastLoginTime((Timestamp)ro.getColumn("lastLoginTime").asObject());
		vo.setLastRegionID((Integer)ro.getColumn("lastRegionID").asObject());

		return vo;
	}
}
