/*
 * Created on 06.03.2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * связь Пользователей системы NFS и NRI (VO).
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PeopleToNfsUser_TO {
	private Nfs_Users_VO vo;
	private Integer idUserNRI;//man(People)
	private String flagMain;//признак главного пользователя
	/**
	 * 
	 */
	public PeopleToNfsUser_TO(Nfs_Users_VO aVO) {
		vo = aVO;
	}

	/**
	 * @return
	 */
	public String getFlagMain() {
		return flagMain;
	}

	/**
	 * @return
	 */
	public Integer getIdUserNRI() {
		return idUserNRI;
	}

	/**
	 * @param string
	 */
	public void setFlagMain(String string) {
		flagMain = string;
	}

	/**
	 * @param integer
	 */
	public void setIdUserNRI(Integer integer) {
		idUserNRI = integer;
	}

	/**
	 * @return
	 */
	public Nfs_Users_VO getVo() {
		return vo;
	}

	/**
	 * @param users_VO
	 */
	public void setVo(Nfs_Users_VO users_VO) {
		vo = users_VO;
	}

}
