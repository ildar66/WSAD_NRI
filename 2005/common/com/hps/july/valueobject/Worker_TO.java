/*
 * Created on 25.04.2006
 *
 *Справочник работников предприятия TO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * Справочник работников предприятия TO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Worker_TO {
	private Worker_VO vo;
	private String workPositionName;

	/**
	 * 
	 */
	public Worker_TO(Worker_VO aVO) {
		super();
		vo = aVO;
	}

	/**
	 * @return
	 */
	public Worker_VO getVo() {
		return vo;
	}

	/**
	 * @param worker_VO
	 */
	public void setVo(Worker_VO worker_VO) {
		vo = worker_VO;
	}

	/**
	 * @return
	 */
	public String getWorkPositionName() {
		return workPositionName;
	}

	/**
	 * @param string
	 */
	public void setWorkPositionName(String string) {
		workPositionName = string;
	}

}
