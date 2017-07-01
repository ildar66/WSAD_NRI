package com.hps.july.arenda.valueobject;

import java.sql.Date;

import com.hps.july.logic.DataPeriod;
import com.hps.july.web.util.StringAndSqlDateProperty;
import com.hps.july.valueobject.RegionsAccess_TO;
/**
* Insert the type's description here.
* Creation date: (03.03.2005 12:26:05)
* @author: Shafigullin Ildar
*/
public class Report_VO {
	private Report_VO.ReportType type; //тип отчета
	private com.hps.july.logic.DataPeriod dataPeriod;
	private StringAndSqlDateProperty data;
	private WorkerVO otv;
	private com.hps.july.valueobject.RegionsAccess_TO curReg;
	//описатель типа отчета:
	public static class ReportType {
		private java.lang.String name; //имя отчета
		private java.lang.String typeDescription;
		private boolean isDataPeriod = false;
		private boolean isData = false;
		private boolean isOtv = false;
		private java.lang.String dataDescription = "Дата";		
		public ReportType(String aName) {
			name = aName;
			if (name.equalsIgnoreCase("getContrArOnOtv")) {
				typeDescription = "Общая статистика по договорам аренды  действующие за период";
				isDataPeriod = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("repWarningProlong")) {
				typeDescription = "Отчет о необходимости продления договоров";
				isData = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("repWarningAkt")) {
				typeDescription = "Отчет-предупреждение о необходимости формировать акты взаимозачета";
				isData = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("listSfOnOtv")) {
				typeDescription = "Счета-фактуры";
				isDataPeriod = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("listAllContractsArenda")) {
				typeDescription = "Все договора аренды";
				isOtv = true;
			} else if (name.equalsIgnoreCase("workTimeOnEconomist")) {
				typeDescription = "Трудоемкость по экономистам";
				isDataPeriod = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("getListNewContracts")) {
				typeDescription = "Новые договора за период";
				isDataPeriod = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("getListBadCharges")) {
				typeDescription = "Наличие с.ф. и актов выполненных работ";
				isDataPeriod = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("repYearPriceBS")) {
				typeDescription = "Стоимость позиций";
				isDataPeriod = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("repArendaListOfMmOpl")) {
				typeDescription = "Список служебных записок";
				isDataPeriod = true;
				isOtv = true;				
			} else if (name.equalsIgnoreCase("repArendaListAbonent")) {
				typeDescription = "Статистика по абонентским договорам";
				isData = true;
				dataDescription = "Дата определения курса";
			} else if (name.equalsIgnoreCase("fillTmpListPayOnCategory")) {
				typeDescription = "Платежи по позициям с разбивкой по категориям затрат";
				isDataPeriod = true;
			} else if (name.equalsIgnoreCase("repTemplateListZpNextPeriod")) {
				typeDescription = "Планирование ЗП за период";
				isDataPeriod = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("fillTmpListDocumenstOnPeriod")) {
				typeDescription = "Отчет по первичным документам";
				isDataPeriod = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("fillTmpListContractsOnPeriod")) {
				typeDescription = "Договора с поставщиками в валюте и рублях";
				isDataPeriod = true;
				isOtv = true;
			} else if (name.equalsIgnoreCase("repContractCustomersOnPeriod")) {
				typeDescription = "По поставщикам за период";
				isDataPeriod = true;
			} else if (name.equalsIgnoreCase("repListContractsForNFS")) {
				typeDescription = "Данные по договорам аренды для НФС";
				isData = true;
				isOtv = true;				
			} else {
				typeDescription = "Неизвестный тип отчета!";
				isDataPeriod = true;
				isOtv = true;
				System.out.println("Неизвестный тип отчета!");
			}
		}
		public java.lang.String getName() {
			return name;
		}
		public String getTypeDescription() {
			return typeDescription;
		}
		public boolean getIsDataPeriod() {
			return isDataPeriod;
		}
		public boolean getIsData() {
			return isData;
		}
		public boolean getIsOtv() {
			return isOtv;
		}
		public String getDataDescription() {
			return dataDescription;
		}
	}
	/**
	 * Report_VO constructor comment.
	 */
	public Report_VO(String aName) {
		super();
		setType(new Report_VO.ReportType(aName));
		data = new StringAndSqlDateProperty();
		setData(new java.sql.Date(System.currentTimeMillis()));
		setDataPeriod(new DataPeriod());
		setOtv(new WorkerVO());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 12:30:37)
	 * @return java.sql.Date
	 */
	public java.sql.Date getData() {
		return data.getSqlDate();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.03.2005 12:06:27)
	 */
	public String getDataFrm() {
		return data.getString();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 12:30:04)
	 * @return com.hps.july.logic.DataPeriod
	 */
	public com.hps.july.logic.DataPeriod getDataPeriod() {
		return dataPeriod;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 13:55:47)
	 * @return com.hps.july.arenda.valueobject.WorkerVO
	 */
	public WorkerVO getOtv() {
		return otv;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 12:29:05)
	 * @return java.lang.String
	 */
	public Report_VO.ReportType getType() {
		return type;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 12:30:37)
	 * @param newData java.sql.Date
	 */
	public void setData(java.sql.Date newData) {
		data.setSqlDate(newData);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (04.03.2005 12:07:53)
	 */
	public void setDataFrm(String newDataStr) {
		data.setString(newDataStr);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 12:30:04)
	 * @param newDataPeriod com.hps.july.logic.DataPeriod
	 */
	public void setDataPeriod(com.hps.july.logic.DataPeriod newDataPeriod) {
		dataPeriod = newDataPeriod;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 13:55:47)
	 * @param newOtv com.hps.july.arenda.valueobject.WorkerVO
	 */
	public void setOtv(WorkerVO newOtv) {
		otv = newOtv;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (03.03.2005 12:29:05)
	 * @param newTypeReport_VO.ReportType
	 */
	public void setType(Report_VO.ReportType newType) {
		type = newType;
	}
	/**
	 * @return
	 */
	public RegionsAccess_TO getCurReg() {
		return curReg;
	}

	/**
	 * @param access_TO
	 */
	public void setCurReg(RegionsAccess_TO access_TO) {
		curReg = access_TO;
	}

}
