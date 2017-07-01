/*
 * Created on 20.04.2006
 *
 * "Служебные записки на изменение ЗП в системе НФС" WordForm Object
 */
package com.hps.july.arenda.formbean;

import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.hps.july.arenda.cdbcobjects.CDBC_LeaseZPOfficeMemo_Object;
import com.hps.july.arenda.valueobject.NFS_ZP_VO;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCArendaAgreementObject;
import com.hps.july.cdbc.objects.CDBC_MapFactory;
import com.hps.july.cdbc.objects.CDBC_NFS_Object;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.hps.july.cdbc.objects.CDBC_Vendor_Object;
import com.hps.july.persistence.LeaseArendaAgreementNewAccessBean;
import com.hps.july.persistence.PositionAccessBean;
import com.hps.july.persistence.ResourceAccessBean;
import com.hps.july.valueobject.*;

/**
 * @author IShaffigulin
 *
 * "Служебные записки на изменение ЗП в системе НФС" WordForm Object
 */
public class LeaseZPOfficeMemoWordForm extends WordForm {
	/**
	 * @author IShaffigulin
	 *
	 * Информация о договоре
	 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
	 */
	public class ContractInfo {
		private String docNumber;
		private Date docDate;
		private String positionName;
		private Integer positionGsm;
		private String allPosition;

		/**
		 * @return
		 */
		public Date getDocDate() {
			return docDate;
		}

		/**
		 * @return
		 */
		public String getDocNumber() {
			return docNumber;
		}

		/**
		 * @param date
		 */
		private void setDocDate(Date date) {
			docDate = date;
		}

		/**
		 * @param string
		 */
		private void setDocNumber(String string) {
			docNumber = string;
		}
		/**
		 * главная позиция
		 * Creation date: (02.04.2004 17:42:53)
		 */
		private void setMainPosition(PositionAccessBean mainPos) throws Exception {
			if (mainPos != null) {
				setPositionName(com.hps.july.basestation.valueobject.PositionModel.getPositionFullName(mainPos));
				setPositionGsm(mainPos.getGsmid());
			} else {
				setPositionGsm(null);
				setPositionName(null);
			}
		}
		/**
		 * @return
		 */
		public String getPositionName() {
			return positionName;
		}

		/**
		 * @param string
		 */
		private void setPositionName(String string) {
			positionName = string;
		}

		/**
		 * @return
		 */
		public Integer getPositionGsm() {
			return positionGsm;
		}

		/**
		 * @param integer
		 */
		private void setPositionGsm(Integer integer) {
			positionGsm = integer;
		}

		/**
		 * @return
		 */
		public String getAllPosition() {
			return allPosition;
		}

		/**
		 * @param string
		 */
		private void setAllPosition(String string) {
			allPosition = string;
		}

	}
	private int id;
	private LeaseZPOfficeMemo_TO to;
	private Vendor_VO vendor_VO;
	private VendorSite_VO vendorSite_VO;
	private Accounts_TO orgAcc;
	private ContractInfo contractInfo;
	private People_VO people_VO;

	private String dataZP;
	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.WordForm#init(javax.servlet.http.HttpServletRequest)
	 */
	public void init(HttpServletRequest request) throws Exception {
		to = CDBC_LeaseZPOfficeMemo_Object.find(getId());
		//setIdContract(getTo().getVo().getLeaseContract().intValue());

		//получатель:
		if (getTo().getVo().getIdVendorSite() != null) {
			setVendorSite_VO(CDBC_VendorSite_Object.find(getTo().getVo().getIdVendorSite()));
			setVendor_VO(CDBC_Vendor_Object.find(getVendorSite_VO().getIdVendor()));
		}
		//инфо о договоре:
		setContractInfo(initContractInfo(to.getVo().getLeaseContract().intValue()));
		//people from getCreatedBy:
		people_VO = CDBC_MapFactory.getPeopleVO_fromMan(to.getVo().getCreatedBy());
		if (getTo().getVo().getIdZP() != null) {
			initDataZP(getTo().getVo().getIdZP());
		}
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public Accounts_TO getOrgAcc() {
		return orgAcc;
	}

	/**
	 * @return
	 */
	public LeaseZPOfficeMemo_TO getTo() {
		return to;
	}

	/**
	 * @return
	 */
	public Vendor_VO getVendor_VO() {
		return vendor_VO;
	}

	/**
	 * @return
	 */
	public VendorSite_VO getVendorSite_VO() {
		return vendorSite_VO;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * @param accounts_TO
	 */
	private void setOrgAcc(Accounts_TO accounts_TO) {
		orgAcc = accounts_TO;
	}

	/**
	 * @param memo_TO
	 */
	private void setTo(LeaseZPOfficeMemo_TO memo_TO) {
		to = memo_TO;
	}

	/**
	 * @param vendor_VO
	 */
	private void setVendor_VO(Vendor_VO vendor_VO) {
		this.vendor_VO = vendor_VO;
	}

	/**
	 * @param site_VO
	 */
	private void setVendorSite_VO(VendorSite_VO site_VO) {
		vendorSite_VO = site_VO;
	}

	/**
	 * @return
	 */
	public ContractInfo getContractInfo() {
		return contractInfo;
	}

	/**
	 * @param info
	 */
	public void setContractInfo(ContractInfo info) {
		contractInfo = info;
	}
	/**
	 * Информация о договоре
	 */
	private ContractInfo initContractInfo(int idContract) {
		try {
			LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
			bean.setInitKey_leaseDocument(idContract);
			bean.refreshCopyHelper();
			LeaseArendaAgreementNewAccessBean beanMain = null;
			if (bean.getMainDocument() != null) {
				beanMain = new LeaseArendaAgreementNewAccessBean();
				beanMain.setInitKey_leaseDocument(bean.getMainDocument().intValue());
				beanMain.refreshCopyHelper();
			} else {
				beanMain = bean;
			}
			//заполняем ContractInfo
			ContractInfo info = new ContractInfo();
			info.setDocNumber(beanMain.getDocumentNumber());
			info.setDocDate(beanMain.getDocumentDate());
			//info.setOrgExecutor(beanMain.getOrgExecutor());
			info.setMainPosition(beanMain.getMainposition());
			info.setAllPosition(CDBCArendaAgreementObject.getListPosContract(beanMain.getLeaseDocument()));
			//Integer mainResource = beanMain.getMainresource();

			return info;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка initContract для getIdContract =" + idContract);
			return null;
		}
	}
	/**
	 * @return
	 */
	public People_VO getPeople_VO() {
		return people_VO;
	}

	/**
	 * @param people_VO
	 */
	private void setPeople_VO(People_VO people_VO) {
		this.people_VO = people_VO;
	}
	/**
	 * "Итого:(Сумма ЗП без НДС + Сумма НДС)"
	 * @return BigDecimal
	 */
	public BigDecimal getSumZP_Plus_SumNdsZP() {
		BigDecimal sumZP = getTo().getVo().getSumZP();
		BigDecimal sumNdsZP = getTo().getVo().getSumNdsZP();
		if (sumZP != null && getTo().getVo().getSumNdsZP() != null)
			return sumZP.add(sumNdsZP);
		else
			return null;
	}
	/**
	 * "Разница к добавлению:"
	 * @return BigDecimal
	 */
	public BigDecimal getSumZP_Minus_OldSumZP() {
		BigDecimal sumZP = getTo().getVo().getSumZP();
		BigDecimal oldSumZP = getTo().getVo().getOldSumZP();
		if (sumZP != null && oldSumZP != null)
			return sumZP.subtract(oldSumZP);
		else
			return null;
	}
	/**
	 * @return
	 */
	public String getDataZP() {
		return dataZP;
	}

	/**
	 * @param string
	 */
	private void setDataZP(String string) {
		dataZP = string;
	}
	/**
	 * 
	 * @param errors
	 */
	private NFS_ZP_VO initDataZP(Integer idZp) {
		CDBCRowObject ro = CDBC_NFS_Object.findZP_NFS(idZp.intValue());
		if (ro != null) {
			NFS_ZP_VO vo = new NFS_ZP_VO(ro);
			setDataZP(vo.getNumZp());
			return vo;
		} else {
			setDataZP("");
			return null;
		}
	}
}
