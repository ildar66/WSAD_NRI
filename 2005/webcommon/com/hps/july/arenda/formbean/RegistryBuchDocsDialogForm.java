package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;

import com.hps.july.arenda.cdbcobjects.CDBC_Helper;
import com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocs_Object;
import com.hps.july.arenda.valueobject.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.cdbc.objects.*;
import com.hps.july.web.util.Profile;
/**
 * Insert the type's description here.
 * Creation date: (08.11.2005 14:14:24)
 * @author: Shafigullin Ildar
 */
public class RegistryBuchDocsDialogForm extends com.hps.july.web.util.EditForm {
	private int id;
	private boolean flagOperation;
	private LeaseRegistryBuchDocs_TO to;
	private static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd.MM.yyyy");
	private PeopleVO operatorVO;
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:43:01)
	 */
	public RegistryBuchDocsDialogForm() {
	}
	/**
	 * ������� ����������.
	 * Creation date: (08.11.2005 14:14:24)
	 * @return int
	 */
	public int getApplication() {
		return com.hps.july.constants.Applications.ARENDA;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 15:50:19)
	 * @return int
	 */
	public int getId() {
		return id;
	}
	/**
	 * ������� ��������� ����������.
	 * Creation date: (08.11.2005 14:14:24)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.REGISTRY_BUCH_DOCS_DIALOG;
	}
	/**
	 * ������������� ��������� ����� ������������ ������������.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
		setFlagOperation(false);
		if (getOperatorVO() == null)
			setOperatorVO(CDBC_Helper.getPeopleVO_fromOperatorCode(request.getRemoteUser()));		
	}
	/**
	 * ������������� ����� � ������ ���������� ������.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		int key = new com.hps.july.commonbean.KeyGeneratorAccessBean().getNextKey("tables.leaseRegistryBuchDocs");
		setId(key);
		to = new LeaseRegistryBuchDocs_TO(new LeaseRegistryBuchDocs_VO(new Integer(key)));
		to.getVo().setState("1");
		to.getVo().setTypeTransferRegistry(new Integer(LeaseRegistryBuchDocs_VO.TYPE_TRANSFER_REGISTRY_REAL));
		to.getVo().setOwner(getOperatorVO().getMan());
		to.setOwnerName(getOperatorVO().getName());
		//��� ���������� �� ��������:
		Profile profile = (Profile) request.getSession().getAttribute(Profile.PROFILE);
		to.getVo().setRegionID(profile.getProfileAccess().getCurrRegion().getVo().getRegionid());
		
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 15:50:19)
	 * @return boolean
	 */
	public boolean isFlagOperation() {
		return flagOperation;
	}
	/**
	 * ����� �������� ������ � �����
	 * Creation date: (13.02.2002 10:12:41)
	 */
	public void loadRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		to = CDBC_LeaseRegistryBuchDocs_Object.find(getId());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2005 12:24:59)
	 * @return java.lang.String
	 * @param flag boolean
	 */
	private String process(boolean ok, ActionErrors errors) {
		if (!ok) {
			String errorStr = "������ CRUD �������� :" + to.getVo().getIdRegistryDoc();
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", errorStr));
			setFlagOperation(false);
		} else {
			setFlagOperation(true);
		}
		return "success";
	}
	/**
	 * ���� ����� ���������� � ������ �������� ������.
	 * Creation date: (10.02.2004 14:01:52)
	 */
	public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocs_Object.delete(to.getVo());
		return process(flag, errors);
	}
	/**
	 * ���� ����� ���������� � ������ ���������� ������.
	 * Creation date: (10.02.2004 14:06:40)
	 */
	public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		CDBC_Helper.initDomainObject(getTo().getVo(), getOperatorVO());		
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocs_Object.add(to.getVo());
		return process(flag, errors);
	}
	/**
	 * ���� ����� ���������� � ������ ��������� ������.
	 * Creation date: (10.02.2004 14:04:31)
	 */
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) {
		CDBC_Helper.updateDomainObject(getTo().getVo(), getOperatorVO());		
		boolean flag = com.hps.july.arenda.cdbcobjects.CDBC_LeaseRegistryBuchDocs_Object.edit(to.getVo());
		return process(flag, errors);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 15:50:19)
	 * @param newFlagOperation boolean
	 */
	public void setFlagOperation(boolean newFlagOperation) {
		flagOperation = newFlagOperation;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2005 15:50:19)
	 * @param newId int
	 */
	public void setId(int newId) {
		id = newId;
	}

	/**
	 * @return
	 */
	public LeaseRegistryBuchDocs_TO getTo() {
		return to;
	}

	/**
	 * @param docs_TO
	 */
	public void setTo(LeaseRegistryBuchDocs_TO docs_TO) {
		to = docs_TO;
	}

	/**
	 * @return
	 */
	private PeopleVO getOperatorVO() {
		return operatorVO;
	}

	/**
	 * @param peopleVO
	 */
	private void setOperatorVO(PeopleVO peopleVO) {
		operatorVO = peopleVO;
	}

}
