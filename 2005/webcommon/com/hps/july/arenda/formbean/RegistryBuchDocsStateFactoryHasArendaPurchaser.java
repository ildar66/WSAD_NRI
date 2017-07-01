/*
 * Created on 25.12.2006
 *
 * StateFactory - Формирование списка возможных состояний описи документов для региона, где есть закупщики по аренде.
 */
package com.hps.july.arenda.formbean;

import java.util.*;

import com.hps.july.arenda.valueobject.RegistryBuchDocsState;

/**
 * @author IShaffigulin
 *
 * StateFactory - Формирование списка возможных состояний описи документов для региона, где есть закупщики по аренде.
 */
public class RegistryBuchDocsStateFactoryHasArendaPurchaser extends AbstractRegistryBuchDocsStateFactory {
	/**
	 * списки возможных состояний:
	 */
	/** PREPARATION_STATE_LIST(подготовка описи) */
	//PREPARATION_STATE_LIST_IG(подготовка описи) для экономистов:
	public final static List PREPARATION_STATE_LIST_IG = new java.util.ArrayList();
	static {
		PREPARATION_STATE_LIST_IG.add(PREPARATION_STATE);
		PREPARATION_STATE_LIST_IG.add(SEND_PURCHASER_STATE);
	}
	//PREPARATION_STATE_LIST_RG (подготовка описи) для RG:
	public final static List PREPARATION_STATE_LIST_RG = new java.util.ArrayList();
	static {
		PREPARATION_STATE_LIST_RG.add(PREPARATION_STATE);
	}
	//PREPARATION_STATE_LIST_AG (подготовка описи) бухгалтеров:
	public final static List PREPARATION_STATE_LIST_AG = PREPARATION_STATE_LIST_RG;
	//PREPARATION_STATE_LIST_RG (подготовка описи) для закупщиков:
	public final static List PREPARATION_STATE_LIST_PG = PREPARATION_STATE_LIST_RG;

	/**SEND_PURCHASER_STATE_LIST(отправлена закупщику)*/
	//SEND_PURCHASER_STATE_LIST_IG(отправлена закупщику) для экономистов:
	public final static List SEND_PURCHASER_STATE_LIST_IG = new java.util.ArrayList();
	static {
		SEND_PURCHASER_STATE_LIST_IG.add(PREPARATION_STATE);
		SEND_PURCHASER_STATE_LIST_IG.add(SEND_PURCHASER_STATE);
	}
	//SEND_PURCHASER_STATE_LIST_RG(отправлена закупщику) для RG:
	public final static List SEND_PURCHASER_STATE_LIST_RG = new java.util.ArrayList();
	static {
		SEND_PURCHASER_STATE_LIST_RG.add(SEND_PURCHASER_STATE);
		SEND_PURCHASER_STATE_LIST_RG.add(EDIT_PURCHASER_STATE);
	}
	//SEND_PURCHASER_STATE_LIST_AG(отправлена закупщику) для бухгалтеров:
	public final static List SEND_PURCHASER_STATE_LIST_AG = new java.util.ArrayList();
	static {
		SEND_PURCHASER_STATE_LIST_AG.add(SEND_PURCHASER_STATE);
	}
	//SEND_PURCHASER_STATE_LIST_PG(отправлена закупщику) для закупщиков:
	public final static List SEND_PURCHASER_STATE_LIST_PG = SEND_PURCHASER_STATE_LIST_RG;

	/**EDIT_PURCHASER_STATE_LIST(обрабатывается закупщиком)*/
	//EDIT_PURCHASER_STATE_LIST_IG(обрабатывается закупщиком) для экономистов:
	public final static List EDIT_PURCHASER_STATE_LIST_IG = new java.util.ArrayList();
	static {
		EDIT_PURCHASER_STATE_LIST_IG.add(EDIT_PURCHASER_STATE);
	}
	//EDIT_PURCHASER_STATE_LIST_RG(обрабатывается закупщиком) для RG:
	public final static List EDIT_PURCHASER_STATE_LIST_RG = new java.util.ArrayList();
	static {
		EDIT_PURCHASER_STATE_LIST_RG.add(SEND_PURCHASER_STATE);
		EDIT_PURCHASER_STATE_LIST_RG.add(EDIT_PURCHASER_STATE);
		EDIT_PURCHASER_STATE_LIST_RG.add(SEND_ACCOUNTANT_STATE);
	}
	//EDIT_PURCHASER_STATE_LIST_AG(обрабатывается закупщиком) для бухгалтеров:
	public final static List EDIT_PURCHASER_STATE_LIST_AG = EDIT_PURCHASER_STATE_LIST_IG;
	//EDIT_PURCHASER_STATE_LIST_PG(обрабатывается закупщиком) для закупщиков:
	public final static List EDIT_PURCHASER_STATE_LIST_PG = EDIT_PURCHASER_STATE_LIST_RG;

	/** SEND_ACCOUNTANT_STATE_LIST(отправлена бухгалтеру)*/
	//SEND_ACCOUNTANT_STATE_LIST_IG(отправлена бухгалтеру) для экономистов:
	public final static List SEND_ACCOUNTANT_STATE_LIST_IG = new java.util.ArrayList();
	static {
		SEND_ACCOUNTANT_STATE_LIST_IG.add(SEND_ACCOUNTANT_STATE);
	}
	//SEND_ACCOUNTANT_STATE_LIST_RG(отправлена бухгалтеру) для RG:
	public final static List SEND_ACCOUNTANT_STATE_LIST_RG = new java.util.ArrayList();
	static {
		SEND_ACCOUNTANT_STATE_LIST_RG.add(EDIT_PURCHASER_STATE);
		SEND_ACCOUNTANT_STATE_LIST_RG.add(SEND_ACCOUNTANT_STATE);
		SEND_ACCOUNTANT_STATE_LIST_RG.add(EDIT_ACCOUNTANT_STATE);
	}
	//SEND_ACCOUNTANT_STATE_LIST_AG(отправлена бухгалтеру) для бухгалтеров:
	public final static List SEND_ACCOUNTANT_STATE_LIST_AG = SEND_ACCOUNTANT_STATE_LIST_RG;
	//SEND_ACCOUNTANT_STATE_LIST_PG(отправлена бухгалтеру) для закупщиков:
	public final static List SEND_ACCOUNTANT_STATE_LIST_PG = SEND_ACCOUNTANT_STATE_LIST_IG;

	/** EDIT_ACCOUNTANT_STATE_LIST(обрабатывается бухгалтером)*/
	//EDIT_ACCOUNTANT_STATE_LIST_IG(обрабатывается бухгалтером) для экономистов:
	public final static List EDIT_ACCOUNTANT_STATE_LIST_IG = new java.util.ArrayList();
	static {
		EDIT_ACCOUNTANT_STATE_LIST_IG.add(EDIT_ACCOUNTANT_STATE);
	}
	//EDIT_ACCOUNTANT_STATE_LIST_RG(обрабатывается бухгалтером) для RG:
	public final static List EDIT_ACCOUNTANT_STATE_LIST_RG = new java.util.ArrayList();
	static {
		EDIT_ACCOUNTANT_STATE_LIST_RG.add(SEND_ACCOUNTANT_STATE);
		EDIT_ACCOUNTANT_STATE_LIST_RG.add(EDIT_ACCOUNTANT_STATE);
		EDIT_ACCOUNTANT_STATE_LIST_RG.add(ACCEPTED_ACCOUNTANT_STATE);
	}
	//EDIT_ACCOUNTANT_STATE_LIST_AG(обрабатывается бухгалтером) для бухгалтеров:
	public final static List EDIT_ACCOUNTANT_STATE_LIST_AG = EDIT_ACCOUNTANT_STATE_LIST_RG;
	//EDIT_ACCOUNTANT_STATE_LIST_PG(обрабатывается бухгалтером) для закупщиков:
	public final static List EDIT_ACCOUNTANT_STATE_LIST_PG = EDIT_ACCOUNTANT_STATE_LIST_IG;

	/** ACCEPTED_ACCOUNTANT_STATE_LIST(принято бухгалт)*/
	//ACCEPTED_ACCOUNTANT_STATE_LIST_IG(принято бухгалт) для экономистов:
	public final static List ACCEPTED_ACCOUNTANT_STATE_LIST_IG = new java.util.ArrayList();
	static {
		ACCEPTED_ACCOUNTANT_STATE_LIST_IG.add(ACCEPTED_ACCOUNTANT_STATE);
	}
	//ACCEPTED_ACCOUNTANT_STATE_LIST_RG(принято бухгалт) для закупщиков + бухгалтеров:
	public final static List ACCEPTED_ACCOUNTANT_STATE_LIST_RG = new java.util.ArrayList();
	static {
		ACCEPTED_ACCOUNTANT_STATE_LIST_RG.add(EDIT_ACCOUNTANT_STATE);
		ACCEPTED_ACCOUNTANT_STATE_LIST_RG.add(ACCEPTED_ACCOUNTANT_STATE);
	}
	//ACCEPTED_ACCOUNTANT_STATE_LIST_AG(принято бухгалт) для бухгалтеров:
	public final static List ACCEPTED_ACCOUNTANT_STATE_LIST_AG = ACCEPTED_ACCOUNTANT_STATE_LIST_RG;
	//ACCEPTED_ACCOUNTANT_STATE_LIST_PG(принято бухгалт) для закупщиков:
	public final static List ACCEPTED_ACCOUNTANT_STATE_LIST_PG = ACCEPTED_ACCOUNTANT_STATE_LIST_IG;
	
	/** STATE_LIST_EXPERT */
	public final static List STATE_LIST_IRG = new java.util.ArrayList();
	static {
		STATE_LIST_IRG.add(PREPARATION_STATE);
		STATE_LIST_IRG.add(SEND_PURCHASER_STATE);
		STATE_LIST_IRG.add(EDIT_PURCHASER_STATE);
		STATE_LIST_IRG.add(SEND_ACCOUNTANT_STATE);
		STATE_LIST_IRG.add(EDIT_ACCOUNTANT_STATE);
		STATE_LIST_IRG.add(ACCEPTED_ACCOUNTANT_STATE);
	}	

	/* (non-Javadoc)
	 * @see com.hps.july.arenda.formbean.AbstractRegistryBuchDocsStateFactory#getAvailableStateList(java.lang.String)
	 */
	public List getAvailableStateList(String curState, String group) {
		if (group.equals(IG)) {
			return getAvailableStateListForInitialGroup(curState);
		} else if (group.equals(RG)) {
			return getAvailableStateListForReturnDocumentGroup(curState);
		} else if (group.equals(PG)) {
			return getAvailableStateListForPurchaserGroup(curState);
		} else if (group.equals(AG)) {
			return getAvailableStateListForAccountantGroup(curState);
		} else if (group.equals(IRG)) {
			return getAvailableStateListForExpertGroup(curState);
			
		} else {
			return getErrorStateList(curState, group);
		}
	}

	/**
	 * 
	 * @param curState
	 * @return
	 */
	private List getAvailableStateListForReturnDocumentGroup(String curState) {
		if (PREPARATION.equals(curState)) {
			return PREPARATION_STATE_LIST_RG;
		} else if (SEND_PURCHASER.equals(curState)) {
			return SEND_PURCHASER_STATE_LIST_RG;
		} else if (EDIT_PURCHASER.equals(curState)) {
			return EDIT_PURCHASER_STATE_LIST_RG;
		} else if (SEND_ACCOUNTANT.equals(curState)) {
			return SEND_ACCOUNTANT_STATE_LIST_RG;
		} else if (EDIT_ACCOUNTANT.equals(curState)) {
			return EDIT_ACCOUNTANT_STATE_LIST_RG;
		} else if (ACCEPTED_ACCOUNTANT.equals(curState)) {
			return ACCEPTED_ACCOUNTANT_STATE_LIST_RG;
		} else {
			return getErrorStateList(curState, RG);
		}
	}

	/**
	 * 
	 * @param curState
	 * @return
	 */
	private List getAvailableStateListForInitialGroup(String curState) {
		if (PREPARATION.equals(curState)) {
			return PREPARATION_STATE_LIST_IG;
		} else if (SEND_PURCHASER.equals(curState)) {
			return SEND_PURCHASER_STATE_LIST_IG;
		} else if (EDIT_PURCHASER.equals(curState)) {
			return EDIT_PURCHASER_STATE_LIST_IG;
		} else if (SEND_ACCOUNTANT.equals(curState)) {
			return SEND_ACCOUNTANT_STATE_LIST_IG;
		} else if (EDIT_ACCOUNTANT.equals(curState)) {
			return EDIT_ACCOUNTANT_STATE_LIST_IG;
		} else if (ACCEPTED_ACCOUNTANT.equals(curState)) {
			return ACCEPTED_ACCOUNTANT_STATE_LIST_IG;
		} else {
			return getErrorStateList(curState, IG);
		}
	}

	/**
	 * 
	 * @param curState
	 * @return
	 */
	private List getAvailableStateListForPurchaserGroup(String curState) {
		if (PREPARATION.equals(curState)) {
			return PREPARATION_STATE_LIST_PG;
		} else if (SEND_PURCHASER.equals(curState)) {
			return SEND_PURCHASER_STATE_LIST_PG;
		} else if (EDIT_PURCHASER.equals(curState)) {
			return EDIT_PURCHASER_STATE_LIST_PG;
		} else if (SEND_ACCOUNTANT.equals(curState)) {
			return SEND_ACCOUNTANT_STATE_LIST_PG;
		} else if (EDIT_ACCOUNTANT.equals(curState)) {
			return EDIT_ACCOUNTANT_STATE_LIST_PG;
		} else if (ACCEPTED_ACCOUNTANT.equals(curState)) {
			return ACCEPTED_ACCOUNTANT_STATE_LIST_PG;
		} else {
			return getErrorStateList(curState, PG);
		}
	}

	/**
	 * 
	 * @param curState
	 * @return
	 */
	private List getAvailableStateListForAccountantGroup(String curState) {
		if (PREPARATION.equals(curState)) {
			return PREPARATION_STATE_LIST_AG;
		} else if (SEND_PURCHASER.equals(curState)) {
			return SEND_PURCHASER_STATE_LIST_AG;
		} else if (EDIT_PURCHASER.equals(curState)) {
			return EDIT_PURCHASER_STATE_LIST_AG;
		} else if (SEND_ACCOUNTANT.equals(curState)) {
			return SEND_ACCOUNTANT_STATE_LIST_AG;
		} else if (EDIT_ACCOUNTANT.equals(curState)) {
			return EDIT_ACCOUNTANT_STATE_LIST_AG;
		} else if (ACCEPTED_ACCOUNTANT.equals(curState)) {
			return ACCEPTED_ACCOUNTANT_STATE_LIST_AG;
		} else {
			return getErrorStateList(curState, AG);
		}
	}
	
	/**
	 * 
	 * @param curState
	 * @return
	 */
	private List getAvailableStateListForExpertGroup(String curState) {
		if (PREPARATION.equals(curState)) {
			return STATE_LIST_IRG;
		} else if (SEND_PURCHASER.equals(curState)) {
			return STATE_LIST_IRG;
		} else if (EDIT_PURCHASER.equals(curState)) {
			return STATE_LIST_IRG;
		} else if (SEND_ACCOUNTANT.equals(curState)) {
			return STATE_LIST_IRG;
		} else if (EDIT_ACCOUNTANT.equals(curState)) {
			return STATE_LIST_IRG;
		} else if (ACCEPTED_ACCOUNTANT.equals(curState)) {
			return STATE_LIST_IRG;
		} else {
			return getErrorStateList(curState, AG);
		}
	}	
}
