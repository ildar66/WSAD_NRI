package com.hps.july.platinum.sessionbean.arenda;

/**
 * Insert the type's description here.
 * Creation date: (25.01.2003 21:28:09)
 * @author: Alexander Shrago
 */
import java.math.BigDecimal;
import com.hps.july.persistence.*;

public class SummBean {

    public BigDecimal summ;
    public  BigDecimal summRub;
    public  BigDecimal summNds;
    public  BigDecimal summNdsRub;
    public  int valuta;

/**
 * SummBean constructor comment.
 */
public SummBean() {
	super();
	summ=BigDecimal.valueOf(0,2);
	summNds=BigDecimal.valueOf(0,2);
	summRub=BigDecimal.valueOf(0,2);
	summNdsRub=BigDecimal.valueOf(0,2);
}
/**
 * SummBean constructor comment.
 */
public SummBean(BigDecimal summ,BigDecimal summNds,BigDecimal summRub,BigDecimal summRubNds,int valuta) {
	super();
	this.summ=summ;
	this.summNds=summNds;
	this.summRub=summRub;
	this.summNdsRub=summRubNds;
	this.valuta=valuta;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:03:46)
 * @return com.hps.july.platinum.sessionbean.arenda.SummBean
 * @param summBean com.hps.july.platinum.sessionbean.arenda.SummBean
 */
public SummBean add(SummBean summBean) throws Exception {

    if (valuta != summBean.valuta && valuta != 0)
        throw new Exception(LogMessages.MES_CurrencyErrorInLinkDocPositions.getText());

    return new SummBean(
        summ.add(summBean.summ),
        summNds.add(summBean.summNds),
        summRub.add(summBean.summRub),
        summNdsRub.add(summBean.summNdsRub),
        valuta);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 21:36:26)
 * @return com.hps.july.platinum.sessionbean.arenda.SummBean
 * @param piePay com.hps.july.persistence.PIEPayPlatinumAccessBean
 */
public static SummBean getInstance(LeaseDocPosition docPosition)
    throws Exception {

    if (docPosition instanceof LeasePayment) {
        LeasePayment payment = (LeasePayment) docPosition;
        return new SummBean(
            payment.getSumm(),
            payment.getSumnds(),
            payment.getSumRub(),
            payment.getNdsRub(),
            payment.getCurrencyKey().currency);
    } else {
        LeaseCharges charge = (LeaseCharges) docPosition;
        return new SummBean(
            charge.getSumm(),
            charge.getSumnds(),
            charge.getSumm().multiply(charge.getRemainderrate2rur()).setScale(
                2,
                BigDecimal.ROUND_HALF_UP),
            charge.getSumnds().multiply(charge.getRemainderrate2rur()).setScale(
                2,
                BigDecimal.ROUND_HALF_UP),
            charge.getCurrencyKey().currency);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 21:36:26)
 * @return com.hps.july.platinum.sessionbean.arenda.SummBean
 * @param piePay com.hps.july.persistence.PIEPayPlatinumAccessBean
 */
public static SummBean getInstance(
    com.hps.july.persistence.PIEPayPlatinumAccessBean piePay)
    throws Exception {
    return new SummBean(
        piePay.getSumm(),
        piePay.getSummnds(),
        piePay.getSummrub(),
        piePay.getSummndsrub(),
        piePay.getValute());
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm() {
	return summ;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSummNds() {
	return summNds;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSummNdsRub() {
	return summNdsRub;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSummRub() {
	return summRub;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @return int
 */
public int getValuta() {
	return valuta;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:03:46)
 * @return com.hps.july.platinum.sessionbean.arenda.SummBean
 * @param summBean com.hps.july.platinum.sessionbean.arenda.SummBean
 */
public SummBean min(SummBean summBean) throws Exception {
    return this.add(summBean.negate());
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 22:01:50)
 */
public SummBean negate() {

    return new SummBean(
        summ.negate(),
        summNds.negate(),
        summRub.negate(),
        summNdsRub.negate(),
        valuta);
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @param newSumm java.math.BigDecimal
 */
private void setSumm(java.math.BigDecimal newSumm) {
	summ = newSumm;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @param newSummNds java.math.BigDecimal
 */
private void setSummNds(java.math.BigDecimal newSummNds) {
	summNds = newSummNds;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @param newSummNdsRub java.math.BigDecimal
 */
private void setSummNdsRub(java.math.BigDecimal newSummNdsRub) {
	summNdsRub = newSummNdsRub;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @param newSummRub java.math.BigDecimal
 */
private void setSummRub(java.math.BigDecimal newSummRub) {
	summRub = newSummRub;
}
/**
 * Insert the method's description here.
 * Creation date: (26.01.2003 18:40:19)
 * @param newValuta int
 */
private void setValuta(int newValuta) {
	valuta = newValuta;
}
}
