/*
 * Created on 27.06.2006
 *
 * "Проблемы ведения договоров" VO.
 */
package com.hps.july.valueobject;

/**
 * @author IShaffigulin
 *
 * "Проблемы ведения договоров" VO.
 */
public class LeaseContractProblem_VO extends DomainObject {
	private Integer idProblem = null; //pk
	private Integer leaseContract = null; //ссылка на контракт
	private String note = null; //Описание проблемы
	/*
	 * константы типов проблем:
	 * 1-"нельзя оформить ЗП"
	 * 2-"нельзя оформить Платеж"
	 * 3-"отсутствуют первичные документы (счета фактуры\акты выполненных работ)"
	 * 4-"отсутствуют подписанные акты взаимозачета"
	 * 5-"задолженность по абонентскому договору"
	 * 6-"проблема разработчиков NRI"
	 */
	private Integer typeProblem = null; //Тип проблемы
	/*
	 * константы состояния проблем:
	 * 1-"Редактируется"
	 * 2-"Передана на устраненение"
	 * 3-"Устранена"
	 */
	public final static Integer stateEdit = new Integer(1);
	public final static Integer statePassOnFixed = new Integer(2);
	public final static Integer stateFixed = new Integer(3);
	private Integer state = null; //Состояние
	private String stateStr = "???";//Состояние string
	private Integer executor = null; //Исполнитель
	private Integer owner = null; //Инициатор
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
		String typeProblemStr = "Неизвестный тип=" + getTypeProblem();
		if (new Integer(1).equals(getTypeProblem())) {
			typeProblemStr = "нельзя оформить ЗП";
		} else if (new Integer(2).equals(getTypeProblem())) {
			typeProblemStr = "нельзя оформить Платеж";
		} else if (new Integer(3).equals(getTypeProblem())) {
			typeProblemStr = "отсутствуют первичные документы";
		} else if (new Integer(4).equals(getTypeProblem())) {
			typeProblemStr = "отсутствуют подписанные акты взаимозачета";
		} else if (new Integer(5).equals(getTypeProblem())) {
 		    typeProblemStr = "задолженность по абонентскому договору";
		} else if (new Integer(6).equals(getTypeProblem())) {
			typeProblemStr = "проблема разработчиков NRI";
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
			stateStr = "Редактируется";
		}else if(LeaseContractProblem_VO.statePassOnFixed.equals(aState)){
			stateStr = "Передана на устраненение";
		}else if(LeaseContractProblem_VO.stateFixed.equals(aState)){
			stateStr = "Устранена";
		}else{
			stateStr = String.valueOf(aState);
		}
	}

}
