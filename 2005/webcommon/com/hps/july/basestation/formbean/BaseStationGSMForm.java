package com.hps.july.basestation.formbean;

import com.hps.july.basestation.valueobject.*;
import java.util.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.cdbc.lib.*;
/**
* Insert the type's description here.
* Creation date: (06.07.2005 16:18:36)
* @author: Shafigullin Ildar
*/
public class BaseStationGSMForm extends com.hps.july.web.util.EditForm {
    private java.lang.String operation = "";
    private int findPositionBy = -1;
    private java.lang.String searchString;
    private PositionVO position;
    private java.util.List donorRepiterList;
    private java.util.List repiterList;
    private java.lang.String repiterSortBy;
    private List bsList;
    private java.lang.String bsSortBy;
    private java.util.List controllerList;
	private java.lang.String controllerSortBy;
	private com.hps.july.basestation.valueobject.InfoBsGsmOnPosition_VO infoBsGsmOnPosition;
	private java.util.List equipDetList;
	private java.lang.String equipDetSortBy;
	private java.util.List docList;
	private java.util.List jobList;
	//пр€тать ли таблицы:
	private java.lang.String equipDetDisplay = "display:none";
	private java.lang.String bsDisplay = "display:none";
	private java.lang.String repiterDisplay = "display:none";
	private java.lang.String controllerDisplay = "display:none";
	private java.lang.String donorRepiterDisplay = "display:none";
	//показать документы или работы?
	private boolean isDocDisplay = false; // true;
	private boolean isJobDisplay = true; // false;
	private int workerID;
	// дл€ поиска 
	private java.lang.String searchParameterName = "PNM"; // пока нужен, чтобы тэг не ругалс€
	private java.lang.String searchParameterValue;
	// дл€ результатов поиск
	private java.lang.String srPozName;
	private java.lang.String srPozAddr;
	private java.lang.String srShirota;
	private java.lang.String srDolglta;
	private java.lang.String srPozCond;
	private java.lang.String srRegion;
	private java.lang.String srFilial;
	private java.lang.String srNetZona;
	
/**
 * Insert the method's description here.
 * Creation date: (06.07.2005 18:26:16)
 */
public BaseStationGSMForm() {
    setPosition(new PositionVO());
    setRepiterSortBy("donorBS");
    setBsSortBy("number");
    setControllerSortBy("number");
    setEquipDetSortBy("name");
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:16:58)
 */
private void changeWorker() {
    if (getPosition().getStorageplace() != 0) {
        Integer storagePlace = new Integer(getPosition().getStorageplace());
        WorkResponsibility_VO vo = CDBC_WorkResponsibility_Object.find(storagePlace, "W");
        if (vo != null) {
            vo.setWorker(new Integer(getWorkerID()));
            boolean ok = CDBC_WorkResponsibility_Object.edit(vo);
            //System.out.println("VO=" + vo); //temp
            //System.out.println("CDBC_WorkResponsibility_Object.edit(vo)= " + ok); //temp
        } else {
            String respType = "W";
            Integer respID = CDBC_WorkResponsibility_Object.findIdResponsibility();
            vo = new WorkResponsibility_VO(respID, storagePlace, respType);
            vo.setWorker(new Integer(getWorkerID()));
            boolean ok = CDBC_WorkResponsibility_Object.add(vo);
            //System.out.println("VO=" + vo); //temp            
            //System.out.println("CDBC_WorkResponsibility_Object.add(vo)=" + ok); //temp
        }
    }
}
/**
 * “екущее приложение.
 * Creation date: (06.07.2005 16:18:36)
 * @return int
 */
public int getApplication() {
    return com.hps.july.constants.Applications.BASESTATION;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 9:51:05)
 * @return java.lang.String
 */
public java.lang.String getBsDisplay() {
	return bsDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 15:07:46)
 * @return java.util.List
 */
public java.util.List getBsList() {
	return bsList;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 16:38:38)
 * @return java.lang.String
 */
public java.lang.String getBsSortBy() {
	return bsSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 9:53:29)
 * @return java.lang.String
 */
public java.lang.String getControllerDisplay() {
	return controllerDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 16:18:31)
 * @return java.util.List
 */
public java.util.List getControllerList() {
	return controllerList;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 16:20:06)
 * @return java.lang.String
 */
public java.lang.String getControllerSortBy() {
	return controllerSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 11:53:57)
 * @return java.util.List
 */
public java.util.List getDocList() {
	return docList;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 17:25:08)
 * @return java.lang.String
 */
public java.lang.String getDonorRepiterDisplay() {
	return donorRepiterDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 17:38:00)
 * @return java.util.List
 */
public java.util.List getDonorRepiterList() {
	return donorRepiterList;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 9:50:35)
 * @return java.lang.String
 */
public java.lang.String getEquipDetDisplay() {
	return equipDetDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 16:11:59)
 * @return java.util.List
 */
public java.util.List getEquipDetList() {
	return equipDetList;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 16:12:38)
 * @return java.lang.String
 */
public java.lang.String getEquipDetSortBy() {
	return equipDetSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2005 18:24:30)
 * @return int
 */
public int getFindPositionBy() {
	return findPositionBy;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 17:22:18)
 * @return com.hps.july.basestation.valueobject.InfoBsGsmOnPosition_VO
 */
public com.hps.july.basestation.valueobject.InfoBsGsmOnPosition_VO getInfoBsGsmOnPosition() {
	return infoBsGsmOnPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2005 18:23:59)
 * @return java.lang.String
 */
public java.lang.String getOperation() {
	return operation;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2005 18:32:28)
 * @return com.hps.july.basestation.valueobject.PositionVO
 */
public com.hps.july.basestation.valueobject.PositionVO getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 9:52:41)
 * @return java.lang.String
 */
public java.lang.String getRepiterDisplay() {
	return repiterDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 16:45:13)
 * @return java.util.List
 */
public java.util.List getRepiterList() {
	return repiterList;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2005 18:25:04)
 * @return java.lang.String
 */
public java.lang.String getRepiterSortBy() {
	return repiterSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2005 18:25:43)
 * @return java.lang.String
 */
public java.lang.String getSearchString() {
	return searchString;
}
/**
 * “екущее состо€ние приложени€.
 * Creation date: (06.07.2005 16:18:36)
 * @return int
 */
public int getState() {
	return com.hps.july.basestation.APPStates.BS_GSM;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:13:11)
 * @return int
 */
public int getWorkerID() {
	return workerID;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2005 11:16:10)
 */
private void init() {
    initDonorRepiterList();
    initRepiterList();
    initBsList();
    initControllerList();
    initInfoBsGsmOnPosition();
    initEquipDetList();
    initDocList();
	initJobList();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:37:35)
 */
private void initBsList() {
    if (getPosition().getStorageplace() != 0) {
        List list = CDBCBaseStationObject.getBSListFromPosition(getPosition().getStorageplace(), getBsSortBy());
        setBsList(list);
        if (list.size() != 0)
            setBsDisplay("");
        else
            setBsDisplay("display:none");
    } else {
        setBsList(Collections.EMPTY_LIST);
        setBsDisplay("display:none");
    }
}
/**
 * »нициализаци€ коллекций перед отображением пользователю.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    if (getOperation().equals("initPosition")) {
        resetForm();
        if (initPosition()) {
            init();
            setOperation("");
        } else {
            setPosition(new PositionVO());
            setInfoBsGsmOnPosition(null);
            //System.out.println("ѕозици€ не найдена или позиций больше одной !!! -> ¬ызов справочника позиций");
            setOperation("alertDictionary");
        }
    } else if (getOperation().equals("changeWorker")) {
        changeWorker();
        initInfoBsGsmOnPosition();
        setOperation("");
    } else {
        resetForm();
        //сортировки и вход на форму:
        init();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:37:35)
 */
private void initControllerList() {
    if (getPosition().getStorageplace() != 0) {
        List list = CDBCBaseStationObject.getControllerListFromPosition(getPosition().getStorageplace(), getControllerSortBy());
        setControllerList(list);
        if (list.size() != 0)
            setControllerDisplay("");
        else
            setControllerDisplay("display:none");
    } else {
        setControllerList(Collections.EMPTY_LIST);
        setControllerDisplay("display:none");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:37:35)
 */
private void initDocList() {
    if (getPosition().getStorageplace() != 0) {
		// это нужно разделить на документы и работы
        List list = CDBCBaseStationObject.getDocAndWorkListFromPosition(getPosition().getStorageplace(),
					CDBCBaseStationObject.documentType);
        setDocList(list);
    } else {
        setDocList(Collections.EMPTY_LIST);
    }
}
/**
 * 
 */
private void initJobList() {
	if (getPosition().getStorageplace() != 0) {
		// это нужно разделить на документы и работы
		List list = CDBCBaseStationObject.getDocAndWorkListFromPosition(getPosition().getStorageplace(),
					CDBCBaseStationObject.jobType);
		setJobList(list);
	} else {
		setJobList(Collections.EMPTY_LIST);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:37:35)
 */
private void initDonorRepiterList() {
    if (getPosition().getStorageplace() != 0) {
        List list = CDBCBaseStationObject.getDonorRepiterListFromPosition(getPosition().getStorageplace());
        setDonorRepiterList(list);
        if (list.size() != 0)
            setDonorRepiterDisplay("");
        else
            setDonorRepiterDisplay("display:none");
    } else {
        setDonorRepiterList(Collections.EMPTY_LIST);
        setDonorRepiterDisplay("display:none");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:37:35)
 */
private void initEquipDetList() {
    if (getPosition().getStorageplace() != 0) {
        List list = CDBCBaseStationObject.getEquipDetListFromPosition(getPosition().getStorageplace(), getEquipDetSortBy());
        setEquipDetList(list);
        if (list.size() != 0)
            setEquipDetDisplay("");
        else
            setEquipDetDisplay("display:none");
    } else {
        setEquipDetList(Collections.EMPTY_LIST);
        setEquipDetDisplay("display:none");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:37:35)
 */
private void initInfoBsGsmOnPosition() {
    if (getPosition().getStorageplace() != 0) {
        InfoBsGsmOnPosition_VO vo = CDBCBaseStationObject.getInfoBsGsmOnPosition(getPosition().getStorageplace());
        setInfoBsGsmOnPosition(vo);
    } else
        setInfoBsGsmOnPosition(null);
}
/**
 * Creation date: (27.12.2004 15:21:41)
 * @return boolean
 */
private boolean initPosition() {
    CDBCResultSet rs = null;
    String search = "";
    if (getFindPositionBy() == 1) {
    	System.out.println("initPosition() getPosition().getStorageplace() = " + getPosition().getStorageplace());
        rs = CDBCBaseStationObject.findPositionsDopInfo(true, getPosition().getStorageplace(), false, null, false, null);
    } else if (getFindPositionBy() == 2) {
        rs = CDBCBaseStationObject.findPositionsDopInfo(false, -1, true, getPosition().getGsmid(), false, null);
        if (getPosition().getGsmid() != null)
            search = getPosition().getGsmid().toString();
    } else if (getFindPositionBy() == 3) {
        rs = CDBCBaseStationObject.findPositionsDopInfo(false, -1, false, null, true, getPosition().getDampsid());
        if (getPosition().getDampsid() != null)
            search = getPosition().getDampsid().toString();
    } else if (getFindPositionBy() == 4) {
    	resetForm();
    	return true;
    }
    setSearchString(search);
	System.out.println("initPosition() rs = "+rs);
	if (rs != null) {
		System.out.println("initPosition() rs.getRowsCount() = "+rs.getRowsCount());
	}
    if (rs == null || rs.getRowsCount() == 0 || rs.getRowsCount() > 1) {
		System.out.println("initPosition() return false");
		return false;
    } else {
        ListIterator iter = rs.listIterator();
        CDBCRowObject ro = (CDBCRowObject) iter.next();
        PositionVO posVO = new PositionVO(ro);
        setPosition(posVO);
        //доп. информаци€ об опоре:
        PositionDopInfoVO dopInfo = new PositionDopInfoVO(ro);
        getPosition().setDopInfoVO(dopInfo);

        return true;
    }

}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 16:37:35)
 */
private void initRepiterList() {
    if (getPosition().getStorageplace() != 0) {
        List list = CDBCBaseStationObject.getRepiterListFromPosition(getPosition().getStorageplace(), getRepiterSortBy());
        setRepiterList(list);
        if (list.size() != 0)
            setRepiterDisplay("");
        else
            setRepiterDisplay("display:none");
    } else {
        setRepiterList(Collections.EMPTY_LIST);
        setRepiterDisplay("display:none");
    }
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 12:45:28)
 * @return boolean
 */
public boolean isIsDocDisplay() {
	return isDocDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2005 11:14:24)
 */
private void resetForm() {
    setDonorRepiterList(Collections.EMPTY_LIST);
    setRepiterList(Collections.EMPTY_LIST);
    setBsList(Collections.EMPTY_LIST);
    setControllerList(Collections.EMPTY_LIST);
    setEquipDetList(Collections.EMPTY_LIST);
    setDocList(Collections.EMPTY_LIST);
	setJobList(Collections.EMPTY_LIST);
    //пр€тать ли таблицы:
    setEquipDetDisplay("display:none");
    setBsDisplay("display:none");
    setRepiterDisplay("display:none");
    setControllerDisplay("display:none");
    setDonorRepiterDisplay("display:none");
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 9:51:05)
 * @param newBsDisplay java.lang.String
 */
private void setBsDisplay(java.lang.String newBsDisplay) {
	bsDisplay = newBsDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 15:07:46)
 * @param newBsList java.util.List
 */
private void setBsList(java.util.List newBsList) {
	bsList = newBsList;
}
/**
 * Insert the method's description here.
 * Creation date: (13.07.2005 16:38:38)
 * @param newBsSortBy java.lang.String
 */
public void setBsSortBy(java.lang.String newBsSortBy) {
	bsSortBy = newBsSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 9:53:29)
 * @param newControllerDisplay java.lang.String
 */
private void setControllerDisplay(java.lang.String newControllerDisplay) {
	controllerDisplay = newControllerDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 16:18:31)
 * @param newControllerList java.util.List
 */
private void setControllerList(java.util.List newControllerList) {
	controllerList = newControllerList;
}
/**
 * Insert the method's description here.
 * Creation date: (19.07.2005 16:20:06)
 * @param newControllerSortBy java.lang.String
 */
public void setControllerSortBy(java.lang.String newControllerSortBy) {
	controllerSortBy = newControllerSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 11:53:57)
 * @param newDocList java.util.List
 */
private void setDocList(java.util.List newDocList) {
	docList = newDocList;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 17:25:08)
 * @param newDonorRepiterDisplay java.lang.String
 */
public void setDonorRepiterDisplay(java.lang.String newDonorRepiterDisplay) {
	donorRepiterDisplay = newDonorRepiterDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2005 17:38:00)
 * @param newDonorRepiterList java.util.List
 */
private void setDonorRepiterList(java.util.List newDonorRepiterList) {
	donorRepiterList = newDonorRepiterList;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 9:50:35)
 * @param newEquipDetDisplay java.lang.String
 */
private void setEquipDetDisplay(java.lang.String newEquipDetDisplay) {
	equipDetDisplay = newEquipDetDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 16:11:59)
 * @param newEquipDetList java.util.List
 */
public void setEquipDetList(java.util.List newEquipDetList) {
	equipDetList = newEquipDetList;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2005 16:12:38)
 * @param newEquipDetSortBy java.lang.String
 */
public void setEquipDetSortBy(java.lang.String newEquipDetSortBy) {
	equipDetSortBy = newEquipDetSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2005 18:24:30)
 * @param newFindPositionBy int
 */
public void setFindPositionBy(int newFindPositionBy) {
	findPositionBy = newFindPositionBy;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2005 17:22:18)
 * @param newInfoBsGsmOnPosition com.hps.july.basestation.valueobject.InfoBsGsmOnPosition_VO
 */
private void setInfoBsGsmOnPosition(com.hps.july.basestation.valueobject.InfoBsGsmOnPosition_VO newInfoBsGsmOnPosition) {
	infoBsGsmOnPosition = newInfoBsGsmOnPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (28.07.2005 12:45:28)
 * @param newIsDocDisplay boolean
 */
public void setIsDocDisplay(boolean newIsDocDisplay) {
	isDocDisplay = newIsDocDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2005 18:23:59)
 * @param newOperation java.lang.String
 */
public void setOperation(java.lang.String newOperation) {
	operation = newOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2005 18:32:28)
 * @param newPosition com.hps.july.basestation.valueobject.PositionVO
 */
public void setPosition(com.hps.july.basestation.valueobject.PositionVO newPosition) {
    position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2005 9:52:41)
 * @param newRepiterDisplay java.lang.String
 */
private void setRepiterDisplay(java.lang.String newRepiterDisplay) {
	repiterDisplay = newRepiterDisplay;
}
/**
 * Insert the method's description here.
 * Creation date: (09.07.2005 16:45:13)
 * @param newRepiterList java.util.List
 */
private void setRepiterList(java.util.List newRepiterList) {
	repiterList = newRepiterList;
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2005 18:25:04)
 * @param newRepiterSortBy java.lang.String
 */
public void setRepiterSortBy(java.lang.String newRepiterSortBy) {
	repiterSortBy = newRepiterSortBy;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2005 18:25:43)
 * @param newSearchString java.lang.String
 */
public void setSearchString(java.lang.String newSearchString) {
	searchString = newSearchString;
}
/**
 * Insert the method's description here.
 * Creation date: (05.08.2005 14:13:11)
 * @param newWorkerID int
 */
public void setWorkerID(int newWorkerID) {
	workerID = newWorkerID;
}
	/**
	 * @return
	 */
	public java.util.List getJobList() {
		return jobList;
	}

	/**
	 * @param list
	 */
	public void setJobList(java.util.List list) {
		jobList = list;
	}

	/**
	 * @return
	 */
	public boolean isIsJobDisplay() {
		return isJobDisplay;
	}

	/**
	 * @param b
	 */
	public void setIsJobDisplay(boolean b) {
		isJobDisplay = b;
	}

	/**
	 * @return
	 */
	public java.lang.String getSearchParameterName() {
		return searchParameterName;
	}

	/**
	 * @param string
	 */
	public void setSearchParameterName(java.lang.String string) {
		searchParameterName = string;
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
	public void setSearchParameterValue(java.lang.String string) {
		searchParameterValue = string;
	}

	/**
	 * @return
	 */
	public java.lang.String getSrDolglta() {
		return srDolglta;
	}

	/**
	 * @return
	 */
	public java.lang.String getSrFilial() {
		return srFilial;
	}

	/**
	 * @return
	 */
	public java.lang.String getSrNetZona() {
		return srNetZona;
	}

	/**
	 * @return
	 */
	public java.lang.String getSrPozAddr() {
		return srPozAddr;
	}

	/**
	 * @return
	 */
	public java.lang.String getSrPozCond() {
		return srPozCond;
	}

	/**
	 * @return
	 */
	public java.lang.String getSrPozName() {
		return srPozName;
	}

	/**
	 * @return
	 */
	public java.lang.String getSrRegion() {
		return srRegion;
	}

	/**
	 * @return
	 */
	public java.lang.String getSrShirota() {
		return srShirota;
	}

	/**
	 * @param string
	 */
	public void setSrDolglta(java.lang.String string) {
		srDolglta = string;
	}

	/**
	 * @param string
	 */
	public void setSrFilial(java.lang.String string) {
		srFilial = string;
	}

	/**
	 * @param string
	 */
	public void setSrNetZona(java.lang.String string) {
		srNetZona = string;
	}

	/**
	 * @param string
	 */
	public void setSrPozAddr(java.lang.String string) {
		srPozAddr = string;
	}

	/**
	 * @param string
	 */
	public void setSrPozCond(java.lang.String string) {
		srPozCond = string;
	}

	/**
	 * @param string
	 */
	public void setSrPozName(java.lang.String string) {
		srPozName = string;
	}

	/**
	 * @param string
	 */
	public void setSrRegion(java.lang.String string) {
		srRegion = string;
	}

	/**
	 * @param string
	 */
	public void setSrShirota(java.lang.String string) {
		srShirota = string;
	}

}
