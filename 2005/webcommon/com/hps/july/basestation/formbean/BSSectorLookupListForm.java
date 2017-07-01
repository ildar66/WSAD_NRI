package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.util.*;
import com.hps.july.basestation.valueobject.*;

/**
 * ‘орма выбора сектора донорной базовой станции
 */
public class BSSectorLookupListForm
	extends BrowseForm
{
	private BaseStationModel bs = new BaseStationModel();
public BSSectorLookupListForm() {
	super();
}
/**
 * 
 * @return com.hps.july.basestation.valueobject.BaseStationModel
 */
public com.hps.july.basestation.valueobject.BaseStationModel getBs() {
	return bs;
}
public Object[] getFilterParams()
{
	return new Object[] { (bs.getKey()==null)?new Integer(0):bs.getKey() };
}
public String getFinderMethodName() {
	return "findByBasestationOrderByNumberAsc";
}
}
