/*
 * Created on 21.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

import com.hps.july.logic.DataPeriod;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RegistryBuchCompositionObject_TO extends RegistryBuchComposition_TO {
	public final static int TYPE_COMPOSITION_SF = 1;
	public final static int TYPE_COMPOSITION_CWA = 2;
	public final static int TYPE_COMPOSITION_LeaseDoc = 3;

	private Integer typeComposition;

	private Integer idComposition;
	private String numberComposition;
	private Date dateComposition;
	private BigDecimal sumComposition;
	private BigDecimal ndsComposition;
	private DataPeriod periodComposition;

	/**
	 * 
	 */
	public RegistryBuchCompositionObject_TO() {
		super();
	}

	/**
	 * @return
	 */
	public Date getDateComposition() {
		return dateComposition;
	}

	/**
	 * @return
	 */
	public Integer getIdComposition() {
		return idComposition;
	}

	/**
	 * @return
	 */
	public BigDecimal getNdsComposition() {
		return ndsComposition;
	}

	/**
	 * @return
	 */
	public String getNumberComposition() {
		return numberComposition;
	}

	/**
	 * @return
	 */
	public BigDecimal getSumComposition() {
		return sumComposition;
	}

	/**
	 * @param date
	 */
	public void setDateComposition(Date date) {
		dateComposition = date;
	}

	/**
	 * @param integer
	 */
	public void setIdComposition(Integer integer) {
		idComposition = integer;
	}

	/**
	 * @param decimal
	 */
	public void setNdsComposition(BigDecimal decimal) {
		ndsComposition = decimal;
	}

	/**
	 * @param string
	 */
	public void setNumberComposition(String string) {
		numberComposition = string;
	}

	/**
	 * @param decimal
	 */
	public void setSumComposition(BigDecimal decimal) {
		sumComposition = decimal;
	}

	/**
	 * @return
	 */
	public Integer getTypeComposition() {
		return typeComposition;
	}
	/**
	 * @return String
	 */
	public java.lang.String getTypeCompositionStr() {
		String typeCompositionStr = String.valueOf(typeComposition);
		if (TYPE_COMPOSITION_SF == typeComposition.intValue()) {
			typeCompositionStr = "с-ф";
		} else if (TYPE_COMPOSITION_CWA == typeComposition.intValue()) {
			typeCompositionStr = "акт ВР";
		} else if (TYPE_COMPOSITION_LeaseDoc == typeComposition.intValue()) {
			typeCompositionStr = "договор";
		}
		return typeCompositionStr;
	}

	/**
	 * @param integer
	 */
	public void setTypeComposition(Integer integer) {
		typeComposition = integer;
	}

	/**
	 * @return
	 */
	public String getDocStateStr() {
		String docStateStr = getDocState();
		if (TYPE_COMPOSITION_SF == typeComposition.intValue()) {
			docStateStr = RegistryBuchCompositionSF_TO.getDocStateInfo(getDocState());
		} else if (TYPE_COMPOSITION_CWA == typeComposition.intValue()) {
			docStateStr = RegistryBuchCompositionCWA_TO.getDocStateInfo(getDocState());
		}
		return docStateStr;
	}
	/**
	 * @return
	 */
	public DataPeriod getPeriodComposition() {
		return periodComposition;
	}

	/**
	 * @param period
	 */
	public void setPeriodComposition(DataPeriod period) {
		periodComposition = period;
	}

}
