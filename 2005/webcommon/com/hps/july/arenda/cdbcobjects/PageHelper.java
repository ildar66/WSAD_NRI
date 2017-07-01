/*
 * Created on 18.09.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.cdbcobjects;

import java.util.*;
import java.math.*;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PageHelper {
	public final static BigDecimal[] getListSumForPage(Page aPage) {
		List pageList = aPage.getList();
		BigDecimal[] retSum = new BigDecimal[aPage.getHeaders().size()];
		for (int i = 0; i < retSum.length; i++) {
			retSum[i] = new BigDecimal(0);
			
		}
		for (Iterator iter = pageList.iterator(); iter.hasNext();) {
			Object[] items = (Object[]) iter.next();
			for (int i = 0; i < items.length; i++) {
				Object item = items[i];
				if (item != null && item.getClass() == java.math.BigDecimal.class) {
					retSum[i] = retSum[i].add((BigDecimal) item);
				}
			}
		}
		return retSum;
	}
}
