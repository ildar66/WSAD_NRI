package com.hps.july.arenda.valueobject;

/**
 * контейнер "Справочник работников".
 * Creation date: (12.04.2004 19:09:33)
 * @author: Shafigullin Ildar
 */
public class WorkerVO {
	private java.lang.String name;
	private java.lang.Integer worker;
	private PeopleVO man;
	private WorkPositions_VO position;
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 15:30:20)
 */
public WorkerVO() {}
/**
 * WorkerVO constructor comment.
 */
public WorkerVO(Integer worker) {
	super();
	this.worker = worker;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:15:51)
 * @return com.hps.july.arenda.valueobject.PeopleVO
 */
public PeopleVO getMan() {
	return man;
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2004 19:13:33)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:16:54)
 * @return com.hps.july.arenda.valueobject.Workpositions_VO
 */
public WorkPositions_VO getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:07:50)
 * @return java.lang.Integer
 */
public java.lang.Integer getWorker() {
	return worker;
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:05:36)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public void initMan(com.hps.july.cdbc.lib.CDBCRowObject ro) {
    man = new PeopleVO((Integer)ro.getColumn("man").asObject());
    man.setName(ro.getColumn("fullname").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (18.03.2005 16:16:54)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public void initPosition(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	position = new WorkPositions_VO((Integer)ro.getColumn("workposition").asObject());
	position.setName(ro.getColumn("wpname").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (12.04.2004 19:13:33)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (30.03.2005 12:48:10)
 * @param newPosition com.hps.july.arenda.valueobject.WorkPositions_VO
 */
public void setPosition(WorkPositions_VO newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2004 16:07:50)
 * @param newWorker java.lang.Integer
 */
public void setWorker(java.lang.Integer newWorker) {
	worker = newWorker;
}
}
