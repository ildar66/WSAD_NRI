package com.hps.july.arenda.valueobject;

/**
 * ������ ���������� ��� �������� � ����������� VO.
 * Creation date: (07.11.2005 13:31:54)
 * @author: Shafigullin Ildar
 */
public class LeaseRegistryBuchDocs_VO extends com.hps.july.valueobject.DomainObject {
	private java.lang.Integer idRegistryDoc; //���
	private java.lang.Integer typeRegistry; //��� �����(1-�����/�������, 2-���� ����������� �����, 3-��������, 4-��-� � ���� ���. �����, 5- ���� ������������)
	private java.lang.String state; //���������
	private java.lang.Integer owner; //������ �� People (���������)
	private java.lang.Integer regionID; //������� ������
	private java.lang.Integer typeTransferRegistry; //��� �������� �����(1-������ �����, 2-���������� �����):
	public final static String TYPE_TRANSFER_REGISTRY_REAL = "1";
	public final static String TYPE_TRANSFER_REGISTRY_RETURN = "2";
	private Integer idRegistryDocPurcher; //����� �������� ���������
	private Integer idRegistryDocAccountant; //����� �������� ����������
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
			typeRegistryStr = "�����-�������";
		} else if (2 == typeRegistry.intValue()) {
			typeRegistryStr = "���� ���.�����";
		} else if (3 == typeRegistry.intValue()) {
			typeRegistryStr = "��������";
		} else if (4 == typeRegistry.intValue()) {
			typeRegistryStr = "��-� � ���� ��";
		} else if (5 == typeRegistry.intValue()) {
			typeRegistryStr = "���� ��";			
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
			stateStr = "���������� �����";
		} else if ("2".equals(state)) {
			stateStr = "���������� � �����������";
		} else if ("3".equals(state)) {
			stateStr = "������� ������������";
		} else if ("4".equals(state)) {
			stateStr = "���������� ���������";
		} else if ("5".equals(state)) {
			stateStr = "�������������� ����������";
		} else if ("6".equals(state)) {
			stateStr = "�������������� �����������";
		} else if ("7".equals(state)) {
			stateStr = "�������� ����������"; // (������ ��� ��������)
		} else if ("8".equals(state)) {
			stateStr = "������� �����������"; // (������ ��� ��������)			
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
			typeTransferRegistryStr = "������";
		} else if (TYPE_TRANSFER_REGISTRY_RETURN.equals(typeTransferRegistryStr)) {
			typeTransferRegistryStr = "�������";
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
