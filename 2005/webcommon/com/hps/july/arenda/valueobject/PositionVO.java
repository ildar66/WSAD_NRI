package com.hps.july.arenda.valueobject;

/**
 * "Основные данные позиций (сайтов)" VO.
 * Creation date: (21.12.2004 14:57:41)
 * @author: Shafigullin Ildar
 */
public class PositionVO extends StoragePlaceVO {
	private Integer gsmid;
	private Integer dampsid;
	private PositionDopInfoVO dopInfoVO;
/**
 * PositionVO constructor comment.
 */
public PositionVO() {
	super();
}
/**
 * PositionVO constructor comment.
 * @param key int
 */
public PositionVO(int key) {
	super(key);
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 15:00:26)
 * @return int
 */
public Integer getDampsid() {
	return dampsid;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:10:10)
 * @return com.hps.july.arenda.valueobject.PositionDopInfoVO
 */
public PositionDopInfoVO getDopInfoVO() {
	return dopInfoVO;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 15:00:26)
 * @return int
 */
public Integer getGsmid() {
	return gsmid;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 15:00:26)
 * @param newDampsid int
 */
public void setDampsid(Integer newDampsid) {
	dampsid = newDampsid;
}
/**
 * Insert the method's description here.
 * Creation date: (27.12.2004 16:10:10)
 * @param newDopInfoVO com.hps.july.arenda.valueobject.PositionDopInfoVO
 */
public void setDopInfoVO(PositionDopInfoVO newDopInfoVO) {
	dopInfoVO = newDopInfoVO;
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2004 15:00:26)
 * @param newGsmid int
 */
public void setGsmid(Integer newGsmid) {
	gsmid = newGsmid;
}
}
