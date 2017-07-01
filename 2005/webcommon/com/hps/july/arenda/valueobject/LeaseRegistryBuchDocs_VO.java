package com.hps.july.arenda.valueobject;

/**
 * Список документов для передачи в бухгалтерию VO.
 * Creation date: (07.11.2005 13:31:54)
 * @author: Shafigullin Ildar
 */
public class LeaseRegistryBuchDocs_VO extends com.hps.july.valueobject.DomainObject {
	private java.lang.Integer idRegistryDoc; //код
	private java.lang.Integer typeRegistry; //тип описи(1-счета/фактуры, 2-акты выполненных работ, 3-договора, 4-Сч-ф и Акты вып. работ, 5- акты взаимозачета)
	private java.lang.String state; //состояние
	private java.lang.Integer owner; //ссылка на People (инициатор)
	private java.lang.Integer regionID; //текущий регион
	private java.lang.Integer typeTransferRegistry; //тип передачи описи(1-прямая опись, 2-возвратная опись):
	public final static String TYPE_TRANSFER_REGISTRY_REAL = "1";
	public final static String TYPE_TRANSFER_REGISTRY_RETURN = "2";
	private Integer idRegistryDocPurcher; //опись возврата Закупщика
	private Integer idRegistryDocAccountant; //опись возврата Бухгалтера
	/**
	 * LoanAktGetPut_VO constructor comment.
	 */
	public LeaseRegistryBuchDocs_VO(Integer id) {
		super();
		idRegistryDoc = id;
	}
	/**
	 * @return
	 */
	public java.lang.Integer getIdRegistryDoc() {
		return idRegistryDoc;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getOwner() {
		return owner;
	}

	/**
	 * @return
	 */
	public java.lang.String getState() {
		return state;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getTypeRegistry() {
		return typeRegistry;
	}

	/**
	 * @return String
	 */
	public java.lang.String getTypeRegistryStr() {
		String typeRegistryStr = String.valueOf(typeRegistry);
		if (1 == typeRegistry.intValue()) {
			typeRegistryStr = "счета-фактуры";
		} else if (2 == typeRegistry.intValue()) {
			typeRegistryStr = "акты вып.работ";
		} else if (3 == typeRegistry.intValue()) {
			typeRegistryStr = "договора";
		} else if (4 == typeRegistry.intValue()) {
			typeRegistryStr = "Сч-ф и Акты ВП";
		} else if (5 == typeRegistry.intValue()) {
			typeRegistryStr = "акты ВЗ";			
		}
		return typeRegistryStr;
	}

	/**
	 * @param integer
	 */
	public void setIdRegistryDoc(java.lang.Integer integer) {
		idRegistryDoc = integer;
	}

	/**
	 * @param integer
	 */
	public void setOwner(java.lang.Integer integer) {
		owner = integer;
	}

	/**
	 * @param string
	 */
	public void setState(java.lang.String string) {
		state = string;
	}

	/**
	 * @param integer
	 */
	public void setTypeRegistry(java.lang.Integer integer) {
		typeRegistry = integer;
	}
	/**
	 * @return String
	 */
	public java.lang.String getStateStr() {
		String stateStr = state;
		if ("1".equals(state)) {
			stateStr = "подготовка описи";
		} else if ("2".equals(state)) {
			stateStr = "отправлена в бухгалтерию";
		} else if ("3".equals(state)) {
			stateStr = "принята бухгалтерией";
		} else if ("4".equals(state)) {
			stateStr = "отправлена закупщику";
		} else if ("5".equals(state)) {
			stateStr = "обрабатывается закупщиком";
		} else if ("6".equals(state)) {
			stateStr = "обрабатывается бухгалтером";
		} else if ("7".equals(state)) {
			stateStr = "передано инициатору"; // (только для возврата)
		} else if ("8".equals(state)) {
			stateStr = "принято инициатором"; // (только для возврата)			
		}
		return stateStr;
	}
	/**
	 * @return
	 */
	public java.lang.Integer getRegionID() {
		return regionID;
	}

	/**
	 * @param integer
	 */
	public void setRegionID(java.lang.Integer integer) {
		regionID = integer;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getTypeTransferRegistry() {
		return typeTransferRegistry;
	}

	/**
	 * @return
	 */
	public java.lang.String getTypeTransferRegistryStr() {
		String typeTransferRegistryStr = String.valueOf(typeTransferRegistry);
		if (TYPE_TRANSFER_REGISTRY_REAL.equals(typeTransferRegistryStr)) {
			typeTransferRegistryStr = "прямая";
		} else if (TYPE_TRANSFER_REGISTRY_RETURN.equals(typeTransferRegistryStr)) {
			typeTransferRegistryStr = "возврат";
		}
		return typeTransferRegistryStr;
	}

	/**
	 * @param integer
	 */
	public void setTypeTransferRegistry(java.lang.Integer integer) {
		typeTransferRegistry = integer;
	}

	/**
	 * @return
	 */
	public Integer getIdRegistryDocAccountant() {
		return idRegistryDocAccountant;
	}

	/**
	 * @return
	 */
	public Integer getIdRegistryDocPurcher() {
		return idRegistryDocPurcher;
	}

	/**
	 * @param integer
	 */
	public void setIdRegistryDocAccountant(Integer integer) {
		idRegistryDocAccountant = integer;
	}

	/**
	 * @param integer
	 */
	public void setIdRegistryDocPurcher(Integer integer) {
		idRegistryDocPurcher = integer;
	}

}
