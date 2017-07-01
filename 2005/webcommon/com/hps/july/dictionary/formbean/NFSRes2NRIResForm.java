/*
 * Форма редактирования связи ресурсов NFS и NRI
 * Created on 01.03.2006
 *
 */
package com.hps.july.dictionary.formbean;

import java.util.ListIterator;

import com.hps.july.cdbc.lib.CDBCResultSet;
import com.hps.july.cdbc.lib.CDBCRowObject;
import com.hps.july.cdbc.objects.CDBCResourcesObject;
import com.hps.july.constants.Applications;
import com.hps.july.dictionary.APPStates;
import com.hps.july.web.util.EditForm;

/**
 * @author dima
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NFSRes2NRIResForm extends EditForm {
	
	Integer resource;
	String searchby;
	String searchparam;
	String linkedres;
	
	public NFSRes2NRIResForm() {
		searchby = "A";
		searchparam = "";
	}
	
	public CDBCRowObject getResourceList() {
		CDBCRowObject result = null;
		
		CDBCResultSet rs = CDBCResourcesObject.findNRIResource(getResource());
		ListIterator it = rs.listIterator();
		if (it.hasNext())
			result = (CDBCRowObject)it.next();
		return result;
	}
	
	public CDBCResultSet getLinkedResourceList() {
		return CDBCResourcesObject.findLinkedNFSResources(getResource());
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getApplication()
	 */
	public int getApplication() {
		return Applications.DICTIONARY;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return APPStates.NFSRES2NRIRES;
	}

	/**
	 * @return
	 */
	public Integer getResource() {
		return resource;
	}

	/**
	 * @param integer
	 */
	public void setResource(Integer integer) {
		resource = integer;
	}

	/**
	 * @return
	 */
	public String getSearchby() {
		return searchby;
	}

	/**
	 * @return
	 */
	public String getSearchparam() {
		return searchparam;
	}

	/**
	 * @param string
	 */
	public void setSearchby(String string) {
		searchby = string;
	}

	/**
	 * @param string
	 */
	public void setSearchparam(String string) {
		searchparam = string;
	}

	/**
	 * @return
	 */
	public String getLinkedres() {
		return linkedres;
	}

	/**
	 * @param strings
	 */
	public void setLinkedres(String strings) {
		linkedres = strings;
	}

}
