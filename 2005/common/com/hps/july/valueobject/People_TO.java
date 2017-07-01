/*
 * Created on 26.07.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class People_TO extends Base_TO {
	private People_VO vo;
	private String remoteUser;
	private Integer operatorCode;
	/**
	 * People_TO constructor comment.
	 */
	public People_TO(People_VO aVO) {
		super();
		vo = aVO;
	}
	/**
	 * People_TO constructor comment.
	 */
	public People_TO(People_VO aVO, String aRemoteUser, Integer aOperatorCode) {
		super();
		setVo(aVO);
		setRemoteUser(aRemoteUser);
		setOperatorCode(aOperatorCode);
	}

	/**
	 * @return
	 */
	public People_VO getVo() {
		return vo;
	}

	/**
	 * @param people_VO
	 */
	public void setVo(People_VO people_VO) {
		vo = people_VO;
	}

	/**
	 * @return
	 */
	public Integer getOperatorCode() {
		return operatorCode;
	}

	/**
	 * @return
	 */
	public String getRemoteUser() {
		return remoteUser;
	}

	/**
	 * @param integer
	 */
	public void setOperatorCode(Integer integer) {
		operatorCode = integer;
	}

	/**
	 * @param string
	 */
	public void setRemoteUser(String string) {
		remoteUser = string;
	}

}
