package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.util.*;
import com.hps.july.basestation.valueobject.*;

/**
 * Форма выбора антенн сектора донорной базовой станции
 */
public class BSAntennaLookupListForm
	extends BrowseForm
{
	private BaseStationModel bs = new BaseStationModel();
	private SectorModel sector = new SectorModel();
public BSAntennaLookupListForm() {
	super();
}
public BaseStationModel getBs() {
	return bs;
}
public Object[] getFilterParams()
{
	return new Object[] {
		new SectorKey((sector.getKey()!=null)?sector.getKey().intValue():0)
	};
}
public String getFinderMethodName() {
	return "findAntena2sectorsBySector";
}
public SectorModel getSector() {
	return sector;
}
public void refreshFilter() {
	try {
		SectorAccessBean s = sector.getAccessBean();
		bs.setKey(new Integer(s.getEquipment().getStorageplace()));
	} catch(Exception e) {
		bs.setKeyFrm("");
	}
	sector.refresh();
	bs.refresh();
}
}
