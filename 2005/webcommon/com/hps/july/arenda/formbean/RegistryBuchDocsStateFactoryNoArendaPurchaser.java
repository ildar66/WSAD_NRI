/*
 * Created on 25.12.2006
 *
 * StateFactory - Формирование списка возможных состояний описи документов для региона, где нет закупщиков по аренде.
 */
package com.hps.july.arenda.formbean;

import java.util.*;

import com.hps.july.arenda.valueobject.RegistryBuchDocsState;

/**
 * @author IShaffigulin
 *
 * StateFactory - Формирование списка возможных состояний описи документов для региона, где нет закупщиков по аренде.
 */
public class RegistryBuchDocsStateFactoryNoArendaPurchaser extends AbstractRegistryBuchDocsStateFactory {
	//списки возможных состояний:

	//PREPARATION_STATE_LIST_IG(подготовка описи) для экономистов:
	public final static List PREPARATION_STATE_LIST_IG = new java.util.ArrayList();
	static {
		PREPARATION_STATE_LIST_IG.add(PREPARATION_STATE);
		PREPARATION_STATE_LIST_IG.add(SEND_ACCOUNTANT_STATE);
	}
	//PREPARATION_STATE_LIST_RG (подготовка описи) для бухгалтеров:
	public final static List PREPARATION_STATE_LIST_RG = new java.util.ArrayList();
	static {
		PREPARATION_STATE_LIST_RG.add(PREPARATION_STATE);
	}

	//SEND_ACCOUNTANT_STATE_LIST_IG(отправлена бухгалтеру) для экономистов:
	public final static List SEND_ACCOUNTANT_STATE_LIST_IG = new java.util.ArrayList();
	static {
		SEND_ACCOUNTANT_STATE_LIST_IG.add(PREPARATION_STATE);
		SEND_ACCOUNTANT_STATE_LIST_IG.add(SEND_ACCOUNTANT_STATE);
	}
	//SEND_ACCOUNTANT_STATE_LIST_RG(отправлена бухгалтеру) для бухгалтеров:
	public final static List SEND_ACCOUNTANT_STATE_LIST_RG = new java.util.ArrayList();
	static {
		SEND_ACCOUNTANT_STATE_LIST_RG.add(SEND_ACCOUNTANT_STATE);
		SEND_ACCOUNTANT_STATE_LIST_RG.add(EDIT_ACCOUNTANT_STATE);
	}

	//EDIT_ACCOUNTANT_STATE_LIST_IG(обрабатывается бухгалтером) для экономистов:
	public final static List EDIT_ACCOUNTANT_STATE_LIST_IG = new java.util.ArrayList();
	static {
		EDIT_ACCOUNTANT_STATE_LIST_IG.add(EDIT_ACCOUNTANT_STATE);
	}
	//EDIT_ACCOUNTANT_STATE_LIST_RG(обрабатывается бухгалтером) для бухгалтеров:
	public final static List EDIT_ACCOUNTANT_STATE_LIST_RG = new java.util.ArrayList();
	static {
		EDIT_ACCOUNTANT_STATE_LIST_RG.add(SEND_ACCOUNTANT_STATE);
		EDIT_ACCOUNTANT_STATE_LIST_RG.add(EDIT_ACCOUNTANT_STATE);
		EDIT_ACCOUNTANT_STATE_LIST_RG.add(ACCEPTED_ACCOUNTANT_STATE);
	}

	//ACCEPTED_ACCOUNTANT_STATE_LIST_IG(принято бухгалт) для экономистов:
	public final static List ACCEPTED_ACCOUNTANT_STATE_LIST_IG = new java.util.ArrayList();
	static {
		ACCEPTED_ACCOUNTANT_STATE_LIST_IG.add(ACCEPTED_ACCOUNTANT_STATE);
	}
	//ACCEPTED_ACCOUNTANT_STATE_LIST_RG(принято бухгалт) для бухгалтеров:
	public final static List ACCEPTED_ACCOUNTANT_STATE_LIST_RG = new java.util.ArrayList();
	static {
		ACCEPTED_ACCOUNTANT_STATE_LIST_RG.add(EDIT_ACCOUNTANT_STATE);
		ACCEPTED_ACCOUNTANT_STATE_LIST_RG.add(ACCEPTED_ACCOUNTANT_STATE);
	}
	/** STATE_LIST_EXPERT */
	public final static List STATE_LIST_IRG = new java.util.ArrayList();
	static {
		STATE_LIST_IRG.add(PREPARATION_STATE);
		STATE_LIST_IRG.add(SEND_ACCOUNTANT_STATE);
		//STATE_LIST_IRG.add(EDIT_ACCOUNTANT_STATE);
		STATE_LIST_IRG.add(ACCEPTED_ACCOUNTANT_STATE);
	}		

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.AbstractRegistryBuchDocsStateFactory#getAvailableStateList(java.lang.String)
	 */
	public List getAvailableStateList(String curState, String group) {
		if (group.equals(IG)) {
			return getAvailableStateListForInitialGroup(curState, group);
		} else if (group.equals(IRG)) {
			return getAvailableStateListForExpertGroup(curState, group);			
		} else {
			return getAvailableStateListForReturnDocumentGroup(curState, group);
		}
	}
	/**
	 * 
	 * @param curState
	 * @return
	 */
	private List getAvailableStateListForInitialGroup(String curState, String group) {
		if (PREPARATION.equals(curState)) {
			return PREPARATION_STATE_LIST_IG;
		} else if (SEND_ACCOUNTANT.equals(curState)) {
			return SEND_ACCOUNTANT_STATE_LIST_IG;
		} else if (EDIT_ACCOUNTANT.equals(curState)) {
			return EDIT_ACCOUNTANT_STATE_LIST_IG;
		} else if (ACCEPTED_ACCOUNTANT.equals(curState)) {
			return ACCEPTED_ACCOUNTANT_STATE_LIST_IG;
		}
		else {
			return getErrorStateList(curState, group);
		}
	}
	/**
	 * 
	 * @param curState
	 * @return
	 */
	private List getAvailableStateListForReturnDocumentGroup(String curState, String group) {
		if (PREPARATION.equals(curState)) {
			return PREPARATION_STATE_LIST_RG;
		} else if (SEND_ACCOUNTANT.equals(curState)) {
			return SEND_ACCOUNTANT_STATE_LIST_RG;
		} else if (EDIT_ACCOUNTANT.equals(curState)) {
			return EDIT_ACCOUNTANT_STATE_LIST_RG;
		} else if (ACCEPTED_ACCOUNTANT.equals(curState)) {
			return ACCEPTED_ACCOUNTANT_STATE_LIST_RG;
		}
		else {
			return getErrorStateList(curState, group);
		}
	}

	/**
	 * 
	 * @param curState
	 * @return
	 */
	private List getAvailableStateListForExpertGroup(String curState, String group) {
		if (PREPARATION.equals(curState)) {
			return STATE_LIST_IRG;
		} else if (SEND_ACCOUNTANT.equals(curState)) {
			return STATE_LIST_IRG;
		//} else if (EDIT_ACCOUNTANT.equals(curState)) {
		//	return STATE_LIST_IRG;
		} else if (ACCEPTED_ACCOUNTANT.equals(curState)) {
			return STATE_LIST_IRG;
		}
		else {
			return getErrorStateList(curState, group);
		}
	}
}
