package com.hps.july.config.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * Model - provides data to the visual form
 * + applet data transfer logic
 * @author dima
 *
 */
public class CfgDataModel implements Serializable, AbstractDataModel
{
	//static final long serialVersionUID = 9009817436211052065L;

	private BasestationData bsdata = null;
	private ArrayList repiters = null;
	private ArrayList bsstands = null;
	private ArrayList trxes = null;
	private ArrayList antennes = null;
	private HashMap otherequip = null;
	private HashMap sectors = null;
	private boolean configChanged = false;
	private boolean doCalc = false;
	private boolean doAutoCalc = false;
	private boolean undoCalc = false;
	private boolean deleteDocument = false;
	
	private DocumentVO document = null;
	private BaseStationVO basestation;
	private ArrayList saveErrors;
	private ArrayList calcErrors;
	private ArrayList uncalcErrors;
	private ArrayList deleteErrors;
	private EquipCategoryVO equipCategory;
	private EquipCategoryVO equipCategoryChild;
	private Integer parentEquipObject;
	private transient int equipidcounter;
	private transient int bsstandidcounter;
	private transient HashMap trxCntInStands; // TRX count in each BS Stand 
	private transient HashMap antCount; // Antennes count in sectors
	private transient HashMap trxCount; // Trx count in sectors
	private transient HashMap otherCount; // Other equipment count in sectors
	private transient boolean trxesChanged = false;
	private transient boolean antennesChanged = false;
	private transient boolean sectorsChanged = false;
	
	public CfgDataModel() {
		bsdata = new BasestationData();
		repiters = new ArrayList();
		bsstands = new ArrayList();
		trxes = new ArrayList();
		antennes = new ArrayList();
		otherequip = new HashMap();
		sectors = new HashMap();
		document = new DocumentVO();
		basestation = new BaseStationVO();
		saveErrors = new ArrayList();
		calcErrors = new ArrayList();
		equipCategory = null;
		equipCategoryChild = null;
		parentEquipObject = null;
		equipidcounter = 0;
		bsstandidcounter = 0;
		trxCntInStands = new HashMap();
		antCount = new HashMap();
		trxCount = new HashMap();
	}
	
	/**
	 * Копирование всех полей объекта в текущий
	 * @param dm
	 */
	public void assignObject(CfgDataModel dm) {
		this.configChanged = dm.configChanged;
		this.bsdata = dm.bsdata;
		this.repiters = dm.repiters;
		this.bsstands = dm.bsstands;
		this.trxes = dm.trxes;
		this.antennes = dm.antennes;
		this.sectors = dm.sectors;
		this.otherequip = dm.otherequip;
		this.document = dm.document;
		this.basestation = dm.basestation;
		this.saveErrors = dm.saveErrors;
		this.calcErrors = dm.calcErrors;
		this.uncalcErrors = dm.uncalcErrors;
	}
	
	// Подсчет количества трансиверов для каждой стойки БС
	public void recalcTrxCntInStands() {
		trxCntInStands = new HashMap();
		Iterator it = trxes.iterator();
		while (it.hasNext()) {
			TrxVO trx = (TrxVO)it.next();
			if (!"D".equals(trx.getRecordStatus())) {
				BSStandVO bsvo = trx.getBsstand();
				Integer cnt = (Integer)trxCntInStands.get(bsvo);
				if (cnt == null) {
					cnt = new Integer(1);
				} else {
					cnt = new Integer(cnt.intValue() + 1);
				}
				trxCntInStands.put(bsvo, cnt);
			}
		}
	}
	
	// Подсчет количества TRX в секторе
	public int getTRXCountInSector(short diap, String sectLetter) {
		int res = 0;
		SectorVO sectEtalon = new SectorVO();
		sectEtalon.setBand(diap);
		sectEtalon.setNamesect(sectLetter);
		Integer cnt = (Integer)trxCount.get(sectEtalon);
		if (cnt != null)
			res = cnt.intValue();
		return res;
	}
	
	// Подсчет количества антенн в секторе
	public int getAntCountInSector(short diap, String sectLetter) {
		int res = 0;
		SectorVO sectEtalon = new SectorVO();
		sectEtalon.setBand(diap);
		sectEtalon.setNamesect(sectLetter);
		Integer cnt = (Integer)antCount.get(sectEtalon);
		if (cnt != null)
			res = cnt.intValue();
		return res;
	}

	// Подсчет количества прочего оборудования в секторе
	public int getOtherEquipCountInSector(short diap, String sectLetter) {
		int res = 0;
		SectorVO sectEtalon = new SectorVO();
		sectEtalon.setBand(diap);
		sectEtalon.setNamesect(sectLetter);
		Integer cnt = (Integer)otherCount.get(sectEtalon);
		if (cnt != null)
			res = cnt.intValue();
		return res;
	}
	
	// Пересчет количества антенн в секторе
	public void recalcAntCount() {
		antCount = new HashMap();
		Iterator it = getAntennes().iterator();
		while (it.hasNext()) {
			AntennaVO ant = (AntennaVO)it.next();
			if (!"D".equals(ant.getRecordStatus())) {
				// 900
				SectorVO sect900 = ant.getSector900();
				Integer cnt900 = (Integer)antCount.get(sect900);
				int count900 = 0;
				if (cnt900 != null)
					count900 = cnt900.intValue();
				if ((sect900 != null) && !"D".equals(sect900.getRecordStatus()))
					count900++;
				antCount.put(sect900, new Integer(count900));
			
				// 1800
				SectorVO sect1800 = ant.getSector1800();
				Integer cnt1800 = (Integer)antCount.get(sect1800);
				int count1800 = 0;
				if (cnt1800 != null)
					count1800 = cnt1800.intValue();
				if ((sect1800 != null) && !"D".equals(sect1800.getRecordStatus()))
					count1800++;
				antCount.put(sect1800, new Integer(count1800));
			}
		}
	}

	private void recalcTrxCountInDiap(TrxVO trx, short diap) {
		for (int i=0; i<5; i++) {
			SectorVO sect = trx.getSectorInDiap(diap, i);
			if (sect != null) {
				Integer cnt = (Integer)trxCount.get(sect);
				int count = 0;
				if (cnt != null)
					count = cnt.intValue();
				if ((sect != null) && !"D".equals(sect.getRecordStatus()))
					count++;
				trxCount.put(sect, new Integer(count));
			}
		}
	}

	// Пересчет количества TRX в секторе
	public void recalcTrxCount() {
		trxCount = new HashMap();
		Iterator it = getTrxes().iterator();
		while (it.hasNext()) {
			TrxVO trx = (TrxVO)it.next();
			if (!"D".equals(trx.getRecordStatus())) {
				recalcTrxCountInDiap(trx, SectorVO.DIAP900);
				recalcTrxCountInDiap(trx, SectorVO.DIAP1800);
			}
		}
	}
	
	private void recalcOtherEquipCountInDiap(EquipObjectVO eovo, short diap) {
		for (int i=0; i<5; i++) {
			SectorVO sect = eovo.getSectorInDiap(diap, i);
			if (sect != null) {
				Integer cnt = (Integer)otherCount.get(sect);
				int count = 0;
				if (cnt != null)
					count = cnt.intValue();
				if ((sect != null) && !"D".equals(sect.getRecordStatus()))
					count++;
				otherCount.put(sect, new Integer(count));
			}
		}
	}

	// Пересчет количества прочего оборудования в секторе
	public void recalcOtherEquipCount() {
		otherCount = new HashMap();
		Iterator itc = getOtherequip().keySet().iterator();
		while (itc.hasNext()) {
			EquipObjectKeyVO key = (EquipObjectKeyVO)itc.next();
			ArrayList equips = (ArrayList)getOtherequip().get(key);
			if (equips != null) {
				Iterator it = equips.iterator();
				while (it.hasNext()) {
					EquipObjectVO eovo = (EquipObjectVO)it.next();
					if (!"D".equals(eovo.getRecordStatus())) {
						recalcOtherEquipCountInDiap(eovo, SectorVO.DIAP900);
						recalcOtherEquipCountInDiap(eovo, SectorVO.DIAP1800);
					}
				}
			}
		}
	}
	
	public EquipCategoryVO getCurCategory(boolean isChild) {
		EquipCategoryVO curCategory = null;
		if (isChild) {
			curCategory = getEquipCategoryChild();
		} else {
			curCategory = getEquipCategory();
		}
		return curCategory;
	}
	
	public Integer getCurParent(boolean isChild) {
		Integer curParent = null;
		if (isChild) {
			curParent = getParentEquipObject();
		}
		return curParent;
	}
	
	/**
	 * Данные БС (даты)
	 * @return
	 */
	public BasestationData getBSData() {
		return bsdata;
	}
	
	public SectorVO findSector(SectorVO sect) {
		
		if (sect != null) {
			SectorVO existSect = (SectorVO)getSectors().get(sect);
			if (existSect == null) {
				getSectors().put(sect, sect);
				existSect = sect;
			}
			return existSect;
		}
		return null;
	}
	
	/**
	 * Шкафы (стойки)
	 * @return
	 */
	public ArrayList getBSStands() {
		return bsstands;
	}
	
	public String getLoadURL() {
		int idoc = 0;
		int ibs = 0;
		if (document != null) {
			idoc = document.getCode();
		}
		
		if (basestation != null) {
			ibs = basestation.getCode();
		}
		return "/inventory/LoadConfig?document=" + idoc + "&basestation=" + ibs;
	}
	
	public String getSaveURL() {
		return null;
	}
	
	public String getPostURL() {
		return "/inventory/SaveConfig";
	}

	public void writeData(ObjectOutputStream out) throws IOException {
		out.writeObject(this);
	}
	
	public void readData(ObjectInputStream in) throws IOException, ClassNotFoundException {
		CfgDataModel dm = (CfgDataModel)in.readObject();
		assignObject(dm);
	}
	
	
	/**
	 * @return
	 */
	public boolean isConfigChanged() {
		return configChanged;
	}

	/**
	 * @param b
	 */
	public void setConfigChanged(boolean b) {
		configChanged = b;
	}

	/**
	 * @return
	 */
	public DocumentVO getDocument() {
		return document;
	}

	/**
	 * @param documentVO
	 */
	public void setDocument(DocumentVO documentVO) {
		//System.out.println("setDocument");
		//System.out.println("name = " + documentVO.getExpeditor()==null? "null" : documentVO.getExpeditor().toString());
		document = documentVO;
	}

	/**
	 * @return
	 */
	public boolean isDoCalc() {
		return doCalc;
	}

	/**
	 * @param b
	 */
	public void setDoCalc(boolean b) {
		doCalc = b;
	}

	/**
	 * @return
	 */
	public BaseStationVO getBasestation() {
		return basestation;
	}

	/**
	 * @param stationVO
	 */
	public void setBasestation(BaseStationVO stationVO) {
		basestation = stationVO;
	}

	/**
	 * @return
	 */
	public ArrayList getCalcErrors() {
		return calcErrors;
	}

	/**
	 * @return
	 */
	public ArrayList getSaveErrors() {
		return saveErrors;
	}

	/**
	 * @param list
	 */
	public void setCalcErrors(ArrayList list) {
		calcErrors = list;
	}

	/**
	 * @param list
	 */
	public void setSaveErrors(ArrayList list) {
		saveErrors = list;
	}

	/**
	 * @return
	 */
	public ArrayList getAntennes() {
		return antennes;
	}

	/**
	 * @param list
	 */
	public void setAntennes(ArrayList list) {
		antennes = list;
	}

	/**
	 * @return
	 */
	public HashMap getSectors() {
		return sectors;
	}

	/**
	 * @param map
	 */
	public void setSectors(HashMap map) {
		sectors = map;
	}

	/**
	 * @return
	 */
	public ArrayList getTrxes() {
		return trxes;
	}

	/**
	 * @param list
	 */
	public void setTrxes(ArrayList list) {
		trxes = list;
	}

	/**
	 * @return
	 */
	public ArrayList getRepiters() {
		return repiters;
	}

	/**
	 * @param list
	 */
	public void setRepiters(ArrayList list) {
		repiters = list;
	}

	/**
	 * @return
	 */
	public HashMap getOtherequip() {
		return otherequip;
	}

	/**
	 * @param list
	 */
	public void setOtherequip(HashMap list) {
		otherequip = list;
	}

	/**
	 * @return
	 */
	public Integer getParentEquipObject() {
		return parentEquipObject;
	}

	/**
	 * @param integer
	 */
	public void setParentEquipObject(Integer integer) {
		parentEquipObject = integer;
	}

	/**
	 * @return
	 */
	public int getEquipidcounter() {
		return equipidcounter;
	}
	
	public int generateEquipidcounter() {
		equipidcounter--;
		return equipidcounter;
	}

	/**
	 * @param i
	 */
	public void setEquipidcounter(int i) {
		equipidcounter = i;
	}

	/**
	 * @return
	 */
	public HashMap getTrxCntInStands() {
		return trxCntInStands;
	}

	/**
	 * @param map
	 */
	public void setTrxCntInStands(HashMap map) {
		trxCntInStands = map;
	}

	/**
	 * @return
	 */
	public int getBsstandidcounter() {
		return bsstandidcounter;
	}
	
	public int generateBsstandidcounter() {
		bsstandidcounter++;
		return bsstandidcounter;
	}

	/**
	 * @param i
	 */
	public void setBsstandidcounter(int i) {
		bsstandidcounter = i;
	}

	/**
	 * @return
	 */
	public boolean isDoAutoCalc() {
		return doAutoCalc;
	}

	/**
	 * @param b
	 */
	public void setDoAutoCalc(boolean b) {
		doAutoCalc = b;
	}

	public boolean getUndoCalc() {
		return undoCalc;
	}

	public void setUndoCalc(boolean b) {
		undoCalc = b;
	}

	public ArrayList getDeleteErrors() {
		return deleteErrors;
	}

	public ArrayList getUncalcErrors() {
		return uncalcErrors;
	}

	public void setDeleteErrors(ArrayList list) {
		deleteErrors = list;
	}

	public void setUncalcErrors(ArrayList list) {
		uncalcErrors = list;
	}

	public boolean getDeleteDocument() {
		return deleteDocument;
	}

	public void setDeleteDocument(boolean b) {
		deleteDocument = b;
	}

    public String toString() {
        return "CfgDataModel{" +
                "bsdata=" + bsdata +
                ", repiters=" + repiters +
                ", bsstands=" + bsstands +
                ", trxes=" + trxes +
                ", antennes=" + antennes +
                ", otherequip=" + otherequip +
                ", sectors=" + sectors +
                ", configChanged=" + configChanged +
                ", doCalc=" + doCalc +
                ", doAutoCalc=" + doAutoCalc +
				", undoCalc=" + undoCalc +
                ", document=" + document +
                ", basestation=" + basestation +
                ", saveErrors=" + saveErrors +
                ", calcErrors=" + calcErrors +
                ", equipCategory=" + equipCategory +
                ", equipCategoryChild=" + equipCategoryChild +
                ", parentEquipObject=" + parentEquipObject +
                ", equipidcounter=" + equipidcounter +
                ", bsstandidcounter=" + bsstandidcounter +
                ", trxCntInStands=" + trxCntInStands +
                '}';
    }

	/**
	 * @return
	 */
	public boolean isAntennesChanged() {
		return antennesChanged;
	}

	/**
	 * @return
	 */
	public boolean isSectorsChanged() {
		return sectorsChanged;
	}

	/**
	 * @return
	 */
	public boolean isTrxesChanged() {
		return trxesChanged;
	}

	/**
	 * @param b
	 */
	public void setAntennesChanged(boolean b) {
		antennesChanged = b;
	}

	/**
	 * @param b
	 */
	public void setSectorsChanged(boolean b) {
		sectorsChanged = b;
	}

	/**
	 * @param b
	 */
	public void setTrxesChanged(boolean b) {
		trxesChanged = b;
	}

	/**
	 * @return
	 */
	public EquipCategoryVO getEquipCategory() {
		return equipCategory;
	}

	/**
	 * @param categoryVO
	 */
	public void setEquipCategory(EquipCategoryVO categoryVO) {
		equipCategory = categoryVO;
	}

	/**
	 * @return
	 */
	public EquipCategoryVO getEquipCategoryChild() {
		return equipCategoryChild;
	}

	/**
	 * @param categoryVO
	 */
	public void setEquipCategoryChild(EquipCategoryVO categoryVO) {
		equipCategoryChild = categoryVO;
	}

}
