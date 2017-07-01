package com.hps.july.arenda.valueobject;

import com.hps.july.persistence.LeaseMutualActBLOBAccessBean;
import com.hps.july.persistence.LeaseMutualActNewAccessBean;
/**
 * Контейнер "Акты взаимозачета"
 * Creation date: (19.12.2002 11:04:12)
 * @author: Sergey Gourov
 */
public class LeaseMutualActNewABEx
	extends LeaseMutualActNewAccessBean
{
public boolean isWordfilePresent()
{
	boolean result = false;
	try {
		LeaseMutualActBLOBAccessBean blob = new LeaseMutualActBLOBAccessBean();
		if(blob.getActfilename() != null && !"".equals(blob.getActfilename())) {
			result = true;
		}
	} catch(Exception e) {
		System.out.println("LeaseMutualActNewABEx.WORDFILE: Exception of class "+e.getClass().getName());
//		e.printStackTrace();
	}
	return result;
}
}
