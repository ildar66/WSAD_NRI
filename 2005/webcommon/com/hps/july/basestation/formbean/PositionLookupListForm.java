package com.hps.july.basestation.formbean;

import com.hps.july.siteinfo.valueobject.*;
import com.hps.july.basestation.valueobject.*;
import java.util.*;
import com.hps.july.jdbcpersistence.lib.*;

/**
 * Форма выбора позиции
 */
public class PositionLookupListForm
	extends com.hps.july.siteinfo.formbean.PositionListForm
{
/**
 * PositionLookupListForm constructor comment.
 */
public PositionLookupListForm() {
	super();
	setLastVisited(false);
}
public java.lang.String getFinderMethodName() {
	return "findPositionsLookup";
}
}
