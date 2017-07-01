package com.hps.july.basestation.valueobject;

/**
 * Служебный класс-контейнер с информацией о типе этапа.
 * Используется для вывода этапов в списке выбора.
 */
public class EtaptypeVO
{
	private int etaptypeid;
	private String etaptypename;
public EtaptypeVO() {
	super();
}
public EtaptypeVO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super();
	Object o = ro.getColumn("etaptypeid").asObject();
	if(o != null && o instanceof Integer) {
		etaptypeid = ((Integer)o).intValue();
	} else {
		etaptypeid = 0;
	}
	etaptypename = ro.getColumn("ettypename").asString();
}
public int getEtaptypeid() {
	return etaptypeid;
}
public String getEtaptypename() {
	return etaptypename;
}
public void setEtaptypeid(int newEtaptypeid) {
	etaptypeid = newEtaptypeid;
}
public void setEtaptypename(String newEtaptypename)
{
	etaptypename = newEtaptypename;
}
}
