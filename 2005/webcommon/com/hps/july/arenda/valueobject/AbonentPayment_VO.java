package com.hps.july.arenda.valueobject;

/**
* Bean-Wrapper 
 *"������� �� ����������� ��������� �� ��������".
 * Creation date: (09.03.2005 14:47:55)
 * @author: Shafigullin Ildar
 */
public class AbonentPayment_VO {
	public boolean byhand; //������� ������ ��������� ����
	public boolean flagworknri; //������� ��������� ����� � NRI
	public boolean needpay; //������� ������������� ������� � NRI
	public int paypos; //���������� ID
	public String recordstatus; //������ ������
	public Integer resource; //������
	public java.math.BigDecimal sumfreerur; //����� ���������������� � ������
	public java.math.BigDecimal sumfreeusd; //����� ���������������� � USD
	public java.math.BigDecimal sumnrirur; //����� ������� � ������ � NRI
	public java.math.BigDecimal sumnriusd; //����� ������� � USD � NRI
	public java.math.BigDecimal sumpayrur; //����� ������� � ������ �� ��������
	public java.math.BigDecimal sumpayusd; //����� ������� � USD �� ��������
	public String typename; //������������ ���� �������
	public java.lang.Integer leasedocument; //��� ���������
	public Short ben; //BEN ��� �������
	public String pymtype; //��� ��� �������
	public java.sql.Date paydate; //���� �������
	public String paynumber; //����� �������
	public String changeneedpay; //������� ��������� needpay
	private java.math.BigDecimal payrate; //���� �������
	private String payPurpose; //���������� �������
	/**
	 * AbonentPayment_VO constructor comment.
	 */
	public AbonentPayment_VO() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.lang.Short
	 */
	public java.lang.Short getBen() {
		return ben;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.lang.String
	 */
	public java.lang.String getChangeneedpay() {
		return changeneedpay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getLeasedocument() {
		return leasedocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.sql.Date
	 */
	public java.sql.Date getPaydate() {
		return paydate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.lang.String
	 */
	public java.lang.String getPaynumber() {
		return paynumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return int
	 */
	public int getPaypos() {
		return paypos;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.03.2005 16:30:29)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getPayrate() {
		return payrate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.lang.String
	 */
	public java.lang.String getPymtype() {
		return pymtype;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.lang.String
	 */
	public java.lang.String getRecordstatus() {
		return recordstatus;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getResource() {
		return resource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumfreerur() {
		return sumfreerur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumfreeusd() {
		return sumfreeusd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumnrirur() {
		return sumnrirur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumnriusd() {
		return sumnriusd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumpayrur() {
		return sumpayrur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.math.BigDecimal
	 */
	public java.math.BigDecimal getSumpayusd() {
		return sumpayusd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return java.lang.String
	 */
	public java.lang.String getTypename() {
		return typename;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return boolean
	 */
	public boolean isByhand() {
		return byhand;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return boolean
	 */
	public boolean isFlagworknri() {
		return flagworknri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @return boolean
	 */
	public boolean isNeedpay() {
		return needpay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newBen java.lang.Short
	 */
	public void setBen(java.lang.Short newBen) {
		ben = newBen;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newByhand boolean
	 */
	public void setByhand(boolean newByhand) {
		byhand = newByhand;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newChangeneedpay java.lang.String
	 */
	public void setChangeneedpay(java.lang.String newChangeneedpay) {
		changeneedpay = newChangeneedpay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newFlagworknri boolean
	 */
	public void setFlagworknri(boolean newFlagworknri) {
		flagworknri = newFlagworknri;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newLeasedocument java.lang.Integer
	 */
	public void setLeasedocument(java.lang.Integer newLeasedocument) {
		leasedocument = newLeasedocument;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newNeedpay boolean
	 */
	public void setNeedpay(boolean newNeedpay) {
		needpay = newNeedpay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newPaydate java.sql.Date
	 */
	public void setPaydate(java.sql.Date newPaydate) {
		paydate = newPaydate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newPaynumber java.lang.String
	 */
	public void setPaynumber(java.lang.String newPaynumber) {
		paynumber = newPaynumber;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newPaypos int
	 */
	public void setPaypos(int newPaypos) {
		paypos = newPaypos;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.03.2005 16:30:29)
	 * @param newPayrate java.math.BigDecimal
	 */
	public void setPayrate(java.math.BigDecimal newPayrate) {
		payrate = newPayrate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newPymtype java.lang.String
	 */
	public void setPymtype(java.lang.String newPymtype) {
		pymtype = newPymtype;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newRecordstatus java.lang.String
	 */
	public void setRecordstatus(java.lang.String newRecordstatus) {
		recordstatus = newRecordstatus;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newResource java.lang.Integer
	 */
	public void setResource(java.lang.Integer newResource) {
		resource = newResource;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newSumfreerur java.math.BigDecimal
	 */
	public void setSumfreerur(java.math.BigDecimal newSumfreerur) {
		sumfreerur = newSumfreerur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newSumfreeusd java.math.BigDecimal
	 */
	public void setSumfreeusd(java.math.BigDecimal newSumfreeusd) {
		sumfreeusd = newSumfreeusd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newSumnrirur java.math.BigDecimal
	 */
	public void setSumnrirur(java.math.BigDecimal newSumnrirur) {
		sumnrirur = newSumnrirur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newSumnriusd java.math.BigDecimal
	 */
	public void setSumnriusd(java.math.BigDecimal newSumnriusd) {
		sumnriusd = newSumnriusd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newSumpayrur java.math.BigDecimal
	 */
	public void setSumpayrur(java.math.BigDecimal newSumpayrur) {
		sumpayrur = newSumpayrur;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newSumpayusd java.math.BigDecimal
	 */
	public void setSumpayusd(java.math.BigDecimal newSumpayusd) {
		sumpayusd = newSumpayusd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.03.2005 15:06:11)
	 * @param newTypename java.lang.String
	 */
	public void setTypename(java.lang.String newTypename) {
		typename = newTypename;
	}
	/**
	 * Returns a String that represents the value of this object.
	 * @return a string representation of the receiver
	 */
	public String toString() {
		return "AbonentPayment: Paypos=" + getPaypos() + "; paynumber=" + getPaynumber();
	}
	/**
	 * @return
	 */
	public String getPayPurpose() {
		return payPurpose;
	}

	/**
	 * @param string
	 */
	public void setPayPurpose(String string) {
		payPurpose = string;
	}

}
