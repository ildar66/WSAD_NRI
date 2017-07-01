package com.hps.july.basestation.formbean;

import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import javax.servlet.http.*;
import java.util.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.constants.*;

import com.hps.july.basestation.valueobject.*;
import com.hps.july.siteinfo.valueobject.RegionsSelector;
import com.hps.july.persistence2.FreqPermissionAccessBean;

/**
 * Форма списка документов по истории получения частотного разрешения
 */
public class FreqLicenceHistoryListForm
	extends com.hps.july.web.util.BrowseForm
{
	private String fileNumber;
	private int freqpermid;
public FreqLicenceHistoryListForm() {
	super();
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCSitedocsObject";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getFileNumber() {
	return fileNumber;
}
public Object[] getFilterParams() {
	return new Object[] {
		new Integer(freqpermid),
		getOrder()
	};
}
public java.lang.String getFinderMethodName() {
	return "findFrequencyLicenceHistory";
}
public int getFreqpermid() {
	return freqpermid;
}
public Integer getOrder() {
	return new Integer(1);
}
public int getState() {
	return com.hps.july.basestation.APPStates.FREQLICENCE_HIST;
}
/**
 * 
 * @param newFileNumber java.lang.String
 */
public void setFileNumber(java.lang.String newFileNumber) {
	fileNumber = newFileNumber;
}
public void setFreqpermid(int newFreqpermid) {
	freqpermid = newFreqpermid;
}
public void validateValues(org.apache.struts.action.ActionErrors errors)
	throws Exception
{
	try {
		FreqPermissionAccessBean bean = new FreqPermissionAccessBean();
		bean.setInitKey_freqpermid(getFreqpermid());
		bean.refreshCopyHelper();
		fileNumber = String.valueOf(bean.getFilenumber());
	} catch(Exception e) {
		fileNumber = "???";
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
