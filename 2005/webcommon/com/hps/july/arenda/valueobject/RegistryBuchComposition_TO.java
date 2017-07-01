/*
 * Created on 21.02.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RegistryBuchComposition_TO {
	private String docNumber;
	private Date docDate;
	private String nameOrg;
	private String namePosition;
	private String numberPosition;
	private Integer economist;
	private Integer idRegistryDoc;
	private String nameOrgPrint;
	private String docState;

	/**
	 * 
	 */
	public RegistryBuchComposition_TO() {
		super();
	}

	/**
	 * @return
	 */
	public Date getDocDate() {
		return docDate;
	}

	/**
	 * @return
	 */
	public String getDocNumber() {
		return docNumber;
	}

	/**
	 * @return
	 */
	public Integer getEconomist() {
		return economist;
	}

	/**
	 * @return
	 */
	public Integer getIdRegistryDoc() {
		return idRegistryDoc;
	}

	/**
	 * @return
	 */
	public String getNameOrg() {
		return nameOrg;
	}

	/**
	 * @return
	 */
	public String getNamePosition() {
		return namePosition;
	}

	/**
	 * @param date
	 */
	public void setDocDate(Date date) {
		docDate = date;
	}

	/**
	 * @param string
	 */
	public void setDocNumber(String string) {
		docNumber = string;
	}

	/**
	 * @param integer
	 */
	public void setEconomist(Integer integer) {
		economist = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdRegistryDoc(Integer integer) {
		idRegistryDoc = integer;
	}

	/**
	 * @param string
	 */
	public void setNameOrg(String string) {
		nameOrg = string;
	}

	/**
	 * @param string
	 */
	public void setNamePosition(String string) {
		namePosition = string;
	}

	/**
	 * @return
	 */
	public String getNumberPosition() {
		return numberPosition;
	}

	/**
	 * @param string
	 */
	public void setNumberPosition(String string) {
		numberPosition = string;
	}

	/**
	 * @return
	 */
	public String getNameOrgPrint() {
		return nameOrgPrint;
	}

	/**
	 * @param string
	 */
	public void setNameOrgPrint(String string) {
		nameOrgPrint = string;
	}

	/**
	 * @return
	 */
	public String getDocState() {
		return docState;
	}
	
	/**
	 * @param string
	 */
	public void setDocState(String string) {
		docState = string;
	}

}
