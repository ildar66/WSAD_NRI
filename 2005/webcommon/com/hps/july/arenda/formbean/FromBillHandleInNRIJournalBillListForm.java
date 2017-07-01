package com.hps.july.arenda.formbean;

/**
 * Bean-form "Журнал обработки в NRI".
 * Creation date: (08.05.2003 11:41:48)
 * @author: Sergey Gourov
 */
public class FromBillHandleInNRIJournalBillListForm extends JournalProlongationsListForm {
	private int leaseBill;
/**
 * Insert the method's description here.
 * Creation date: (08.05.2003 12:21:54)
 * @return int
 */
public int getLeaseBill() {
	return leaseBill;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2003 12:21:54)
 * @param newLeaseBill int
 */
public void setLeaseBill(int newLeaseBill) {
	leaseBill = newLeaseBill;
}
}
