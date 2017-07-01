/*
 * Created on 01.08.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.inventory.actionbean;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hps.july.cdbc.objects.CDBCBaseStationObject;
import com.hps.july.config.beans.CfgBsstandsAccessBean;
import com.hps.july.inventory.formbean.ConfigEqEditForm;
import com.hps.july.inventory.valueobject.BSEquipCommonVO;
import com.hps.july.inventory.valueobject.StandVO;
import com.hps.july.web.util.ParamsParser;

/**
 * @author irogachev
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SaveBSConfigAction extends Action {
	
	public ActionForward perform(ActionMapping mapping, 
									ActionForm form, 
									HttpServletRequest request, 
									HttpServletResponse response) throws IOException, ServletException {
		
		ConfigEqEditForm configEqEditForm = (ConfigEqEditForm)form;
		ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.CONF_EQ_FORM);
		System.out.println("configEqEditForm = "+configEqEditForm);
		StandVO [] standVOArray = configEqEditForm.getStands();
		if (standVOArray != null) {
			System.out.println("standVOArray.length = " + standVOArray.length);
			for (int i = 0; i < standVOArray.length; i++) {
				StandVO curStandVO = standVOArray[i];
				String curStandState = curStandVO.getCurState(); 
				// по статусу записи делаем какое-либо действие (для K (keep) не делаем ничего)
				if ((BSEquipCommonVO.UPDATE_STATE.equals(curStandState)) || (BSEquipCommonVO.DELETE_STATE.equals(curStandState))) {
					updateStand(curStandVO);					
				} else if (BSEquipCommonVO.ADD_STATE.equals(curStandState)) {
					clearAddStand(curStandVO);					
				}
			}
			// удаление добавленных удаленных
			List getDeletedAddedStandsList = configEqEditForm.getDeletedAddedStandsList();
			for (int i = 0; i < getDeletedAddedStandsList.size(); i++) {
				StandVO curStandVO = (StandVO)getDeletedAddedStandsList.get(i);
				deleteStand(curStandVO, true);
			}
		}
		return mapping.findForward("main");
	}

	/**
	 * @param curStandVO
	 */
	private void clearAddStand(StandVO curStandVO) {
		deleteStand(curStandVO, false);
		addStand(curStandVO);
	}

	/**
	 * @param curStandVO
	 */
	private void addStand(StandVO curStandVO) {
		try {
			System.out.println("addStand curStandVO.getConfigId() = "+curStandVO.getConfigId());
			System.out.println("addStand curStandVO.getPartId() = "+curStandVO.getPartId());
			System.out.println("addStand curStandVO.getBaseStationId() = "+curStandVO.getBaseStationId());
			System.out.println("addStand curStandVO.getCurState() = "+curStandVO.getCurState());
			CfgBsstandsAccessBean cfgBsstandsAccessBean = new CfgBsstandsAccessBean(
					curStandVO.getConfigId().intValue(),
					curStandVO.getPartId().intValue(),
					curStandVO.getBaseStationId().intValue(),
					curStandVO.getCurState());
			System.out.println("addStand after constructor # cfgBsstandsAccessBean = "+cfgBsstandsAccessBean );
			if (cfgBsstandsAccessBean != null) {
				System.out.println("addStand other fields");
				cfgBsstandsAccessBean.setObjectStatus(curStandVO.getCurState());
				cfgBsstandsAccessBean.setStnomer(curStandVO.getNumber());
				cfgBsstandsAccessBean.setResource(new Integer(CDBCBaseStationObject.getIntegerString(curStandVO.getCurTypeId())));
				cfgBsstandsAccessBean.commitCopyHelper();
				System.out.println("addStand OK");
			}
		} catch (Exception e) {
			System.out.println("addStand exception");
			e.printStackTrace();
		}
		
	}

	/**
	 * @param curStandVO
	 */
	private void deleteStand(StandVO curStandVO, boolean showException) {
		// TODO Auto-generated method stub
		CfgBsstandsAccessBean cfgBsstandsAccessBean = foundStand(curStandVO, showException); 
		if (cfgBsstandsAccessBean != null) {
			try {
				cfgBsstandsAccessBean.getEJBRef().remove();
				System.out.println("deleteStand OK");
			} catch (Exception e) {
				if (showException) {
					System.out.println("deleteStand exception");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param curStandVO
	 */
	private void updateStand(StandVO curStandVO) {
		CfgBsstandsAccessBean cfgBsstandsAccessBean = foundStand(curStandVO, true); 
		if (cfgBsstandsAccessBean != null) {
			cfgBsstandsAccessBean.setObjectStatus(curStandVO.getCurState());
			cfgBsstandsAccessBean.setStnomer(curStandVO.getNumber());
			cfgBsstandsAccessBean.setResource(new Integer(CDBCBaseStationObject.getIntegerString(curStandVO.getCurTypeId())));
			// commit
			try {
				cfgBsstandsAccessBean.commitCopyHelper();
				System.out.println("updateStand OK");
			} catch (Exception e) {
				System.out.println("updateStand exception");
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param curStandVO
	 * @return
	 */
	private CfgBsstandsAccessBean foundStand(StandVO curStandVO, boolean showException) {
		CfgBsstandsAccessBean cfgBsstandsAccessBean = new CfgBsstandsAccessBean();
		System.out.println("foundStand curStandVO.getPartId() = "+curStandVO.getPartId()+" curStandVO.getConfigId() = "+curStandVO.getConfigId());
		cfgBsstandsAccessBean.setInitKey_standid(curStandVO.getPartId().intValue());
		cfgBsstandsAccessBean.setInitKey_savconfigid(curStandVO.getConfigId().intValue());
		try {
			cfgBsstandsAccessBean.refreshCopyHelper();
		} catch (Exception e) {
			if (showException) {
				System.out.println("foundStand exception");
				e.printStackTrace();
			}
			cfgBsstandsAccessBean = null;
		}
		System.out.println("foundStand is found");
		return cfgBsstandsAccessBean;
	}

}
