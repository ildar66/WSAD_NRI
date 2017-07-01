package com.hps.july.basestation.valueobject;

/**
 * Класс-контейнер с информацией о канале и его мощьности
 */
public class ChanalPowers implements Comparable {
	private int chanal;
	private int vertical;
	private int cross;
public ChanalPowers(){
	this.chanal = 0;
	this.vertical = 0;
	this.cross = 0;
}
public ChanalPowers(int chanal){
	this.chanal = chanal;
	this.vertical = 0;
	this.cross = 0;
}
public int compareTo(Object obj){
	int chanal = ((ChanalPowers)obj).getChanal();
	if(chanal == 0) return -1;
	return (chanal < this.chanal ? 1 : (chanal == this.chanal ? 0 : -1));
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 19:10:48)
 * @return int
 */
public int getChanal() {
	return chanal;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 13:06:18)
 * @return int
 */
public int getCross() {
	return cross;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 13:06:18)
 * @return int
 */
public int getVertical() {
	return vertical;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2003 19:10:48)
 * @param newChanal int
 */
public void setChanal(int newChanal) {
	chanal = newChanal;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 13:06:18)
 * @param newCross int
 */
public void setCross(int newCross) {
	cross = newCross;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2003 13:06:18)
 * @param newVertical int
 */
public void setVertical(int newVertical) {
	vertical = newVertical;
}
public String toString(){

	return "chanal="+chanal+
			"\tvertical="+vertical+
			"\tcross="+cross;
}
}
