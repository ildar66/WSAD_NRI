package com.hps.july.dataimport.dataobjects;

/**
 * �������� ���������� ������ ������.
 * Creation date: (04.06.2003 20:45:52)
 * @author: Alexander Shrago
 */
public class TestBsBlockHandler extends java.util.Hashtable {

	private int row;
	private int sessid;
	
	private java.util.Map params;
	
	
public TestBsBlockHandler(
    int sessid,
    int row,
    java.util.Map cells,
    java.util.Map parameters) {

    super(cells);
    this.sessid = sessid;
    this.row = row;

    this.params = parameters;
}
public TestBsBlockHandler(java.util.Map t) {
	super(t);
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 20:56:32)
 * @return int
 */
public int getErrcount() {
	return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 20:56:32)
 * @return int
 */
public int getReccount() {
	return 0;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2003 21:05:57)
 * @return int
 */
public int getSessid() {
	return sessid;
}
public void process() {
}
/**
 * ������ ��� ������� ������� ������ �� ������� ��������.
 * Creation date: (04.06.2003 21:05:57)
 * @param newSessid int
 */
public void setSessid(int newSessid) {
	sessid = newSessid;
}
}
