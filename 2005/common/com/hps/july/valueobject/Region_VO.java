/*
 * Created on 23.01.2006
 *
 * ���������� �������� (��������)VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * ���������� �������� (��������)VO
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Region_VO {
	private Integer regionID;//������������� �������
	private Integer supRegID;//������ �� �����������
	private String regName;//������������ �������
	//private BigDeccimal sectorprefix ������� ������ �������
	//private String hasmap ������� ������� �����
	//private fullarendainfo String ������� ������� ������ ���������� �� ������
	//private needapprove String ������� ������������ ����� �������
	//private modified ���� � ����� ��������� �����������
	//private created ���� � ����� ��������

	/**
	 * 
	 */
	public Region_VO(Integer aRegionId, Integer aSupRegId, String aRegName) {
		super();
		regionID = aRegionId;
		supRegID = aSupRegId;
		regName = aRegName;
	}

	/**
	 * @return
	 */
	public Integer getRegionID() {
		return regionID;
	}

	/**
	 * @return
	 */
	public String getRegName() {
		return regName;
	}

	/**
	 * @return
	 */
	public Integer getSupRegID() {
		return supRegID;
	}

	/**
	 * @param integer
	 */
	public void setRegionID(Integer integer) {
		regionID = integer;
	}

	/**
	 * @param string
	 */
	public void setRegName(String string) {
		regName = string;
	}

	/**
	 * @param integer
	 */
	public void setSupRegID(Integer integer) {
		supRegID = integer;
	}

}
