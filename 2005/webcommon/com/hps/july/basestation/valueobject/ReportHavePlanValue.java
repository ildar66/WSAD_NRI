package com.hps.july.basestation.valueobject;

/**
 * Служебный класс для отчета "наличие выкопировок". Один объект соответствует строке
 * в будущей таблице отчета
 */
public class ReportHavePlanValue extends ReportValue{
	private java.lang.String hopsname;//Код пролёта
	private int numberinfile;//Номер пролёта в файле
	private String haveplan1;//<Значение поля Выкопировка позиции 1 в виде ключевой буквы
	private String haveplan2;//<Значение поля Выкопировка позиции 2 в виде ключевой буквы
	private String waymap1;
	private String waymap2;
/**
 * HavePlanReportValue constructor comment.
 */
public ReportHavePlanValue() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 17:07:27)
 * @return char
 */
public String getHaveplan1() {
	return haveplan1;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2004 11:34:20)
 * @return char
 */
public String getHaveplan2() {
	return haveplan2;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2004 18:20:54)
 * @return java.lang.String
 */
public java.lang.String getHopsname() {
	return hopsname;
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 16:56:46)
 * @return int
 */
public int getNumberinfile() {
	return numberinfile;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWaymap1() {
	return waymap1;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWaymap2() {
	return waymap2;
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 17:07:27)
 * @param newHaveplan char
 */
public void setHaveplan1(String newHaveplan) {
	haveplan1 = newHaveplan;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2004 11:34:20)
 * @param newHaveplan2 char
 */
public void setHaveplan2(String newHaveplan2) {
	haveplan2 = newHaveplan2;
}
/**
 * Insert the method's description here.
 * Creation date: (11.08.2004 18:20:54)
 * @param newHopsname java.lang.String
 */
public void setHopsname(java.lang.String newHopsname) {
	hopsname = newHopsname;
}
/**
 * Insert the method's description here.
 * Creation date: (10.08.2004 16:56:46)
 * @param newNumberinfile int
 */
public void setNumberinfile(int newNumberinfile) {
	numberinfile = newNumberinfile;
}
/**
 * 
 * @param newWaymap1 java.lang.String
 */
public void setWaymap1(java.lang.String newWaymap1) {
	waymap1 = newWaymap1;
}
/**
 * 
 * @param newWaymap2 java.lang.String
 */
public void setWaymap2(java.lang.String newWaymap2) {
	waymap2 = newWaymap2;
}
}
