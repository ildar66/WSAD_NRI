package com.hps.july.arenda.formbean;

/**
 * Form-Bean.
 * канал "сальдо"
 * Creation date: (23.12.2002 16:07:09)
 * @author: Sergey Gourov
 */
public class ChannelSaldoForm extends SaldoForm {
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 16:30:36)
 */
public ChannelSaldoForm() {
	super();
	listForm = "ChannelSaldoListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 13:09:52)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHANNEL_SALDO_EDIT;
}
}
