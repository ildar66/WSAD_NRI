/*
 * Created on 27.06.2006
 *
 * "�������� ������� ���������" VO.
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * "�������� ������� ���������" VO.
 */
public class LeaseContractProblem_VO extends DomainObject {
	private Integer idProblem = null; //pk
	private Integer leaseContract = null; //������ �� ��������
	private String note = null; //�������� ��������
	/*
	 * ��������� ����� �������:
	 * 1-"������ �������� ��"
	 * 2-"������ �������� ������"
	 * 3-"����������� ��������� ��������� (����� �������\���� ����������� �����)"
	 * 4-"����������� ����������� ���� ������������"
	 * 5-"������������� �� ������������ ��������"
	 * 6-"�������� ������������� NRI"
	 */
	private Integer typeProblem = null; //��� ��������
	/*
	 * ��������� ��������� �������:
	 * 1-"�������������"
	 * 2-"�������� �� ������������"
	 * 3-"���������"
	 */
	public final static Integer stateEdit = new Integer(1);
	public final static Integer statePassOnFixed = new Integer(2);
	public final static Integer stateFixed = new Integer(3);
	private Integer state = null; //���������
	private String stateStr = "???";//��������� string
	private Integer executor = null; //�����������
	private Integer owner = null; //���������
	/**
	 * 
	 * @param aId
	 */

	public LeaseContractProblem_VO(Integer aId) {
		super();
		this.idProblem = aId;
	}
	/**
	 * @return
	 */
	public Integer getExecutor() {
		return executor;
	}

	/**
	 * @return
	 */
	public Integer getIdProblem() {
		return idProblem;
	}

	/**
	 * @return
	 */
	public Integer getLeaseContract() {
		return leaseContract;
	}

	/**
	 * @return
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @return
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @return
	 */
	public Integer getTypeProblem() {
		return typeProblem;
	}

	/**
	 * @return String
	 */
	public String getTypeProblemStr() {
		String typeProblemStr = "����������� ���=" + getTypeProblem();
		if (new Integer(1).equals(getTypeProblem())) {
			typeProblemStr = "������ �������� ��";
		} else if (new Integer(2).equals(getTypeProblem())) {
			typeProblemStr = "������ �������� ������";
		} else if (new Integer(3).equals(getTypeProblem())) {
			typeProblemStr = "����������� ��������� ���������";
		} else if (new Integer(4).equals(getTypeProblem())) {
			typeProblemStr = "����������� ����������� ���� ������������";
		} else if (new Integer(5).equals(getTypeProblem())) {
 		    typeProblemStr = "������������� �� ������������ ��������";
		} else if (new Integer(6).equals(getTypeProblem())) {
			typeProblemStr = "�������� ������������� NRI";
		}		
		return typeProblemStr;
	}

	/**
	 * @param integer
	 */
	public void setExecutor(Integer integer) {
		executor = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdProblem(Integer integer) {
		idProblem = integer;
	}

	/**
	 * @param integer
	 */
	public void setLeaseContract(Integer integer) {
		leaseContract = integer;
	}

	/**
	 * @param string
	 */
	public void setNote(String string) {
		note = string;
	}

	/**
	 * @param integer
	 */
	public void setState(Integer integer) {
		state = integer;
		setStateStr(state);
	}

	/**
	 * @param integer
	 */
	public void setTypeProblem(Integer integer) {
		typeProblem = integer;
	}

	/**
	 * @return
	 */
	public Integer getOwner() {
		return owner;
	}

	/**
	 * @param integer
	 */
	public void setOwner(Integer integer) {
		owner = integer;
	}

	/**
	 * @return
	 */
	public String getStateStr() {
		return stateStr;
	}

	/**
	 * @param string
	 */
	private void setStateStr(Integer aState) {
		if(LeaseContractProblem_VO.stateEdit.equals(aState)){
			stateStr = "�������������";
		}else if(LeaseContractProblem_VO.statePassOnFixed.equals(aState)){
			stateStr = "�������� �� ������������";
		}else if(LeaseContractProblem_VO.stateFixed.equals(aState)){
			stateStr = "���������";
		}else{
			stateStr = String.valueOf(aState);
		}
	}

}
