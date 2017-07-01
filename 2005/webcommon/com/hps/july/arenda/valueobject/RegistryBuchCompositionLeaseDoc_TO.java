/*
 * Created on 05.03.2006
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
public class RegistryBuchCompositionLeaseDoc_TO extends RegistryBuchComposition_TO {
	private Integer leaseDocument;

	private String docNumberDop;
	private Date docDateDop;
	private String nameCurrency;
	private BigDecimal sum;
	private String typeDoc;
	/**
	 * 
	 */
	public RegistryBuchCompositionLeaseDoc_TO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	public Date getDocDateDop() {
		return docDateDop;
	}

	/**
	 * @return
	 */
	public String getDocNumberDop() {
		return docNumberDop;
	}

	/**
	 * @return
	 */
	public Integer getLeaseDocument() {
		return leaseDocument;
	}

	/**
	 * @return
	 */
	public String getNameCurrency() {
		return nameCurrency;
	}

	/**
	 * @return
	 */
	public BigDecimal getSum() {
		return sum;
	}

	/**
	 * @return
	 */
	public String getTypeDoc() {
		return typeDoc;
	}

	/**
	 * @param date
	 */
	public void setDocDateDop(Date date) {
		docDateDop = date;
	}

	/**
	 * @param string
	 */
	public void setDocNumberDop(String string) {
		docNumberDop = string;
	}

	/**
	 * @param integer
	 */
	public void setLeaseDocument(Integer integer) {
		leaseDocument = integer;
	}

	/**
	 * @param string
	 */
	public void setNameCurrency(String string) {
		nameCurrency = string;
	}

	/**
	 * @param decimal
	 */
	public void setSum(BigDecimal decimal) {
		sum = decimal;
	}

	/**
	 * @param string
	 */
	public void setTypeDoc(String string) {
		typeDoc = string;
	}

}
