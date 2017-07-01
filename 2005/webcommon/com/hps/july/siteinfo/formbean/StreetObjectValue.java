package com.hps.july.siteinfo.formbean;

/**
 * ������ 'Value Object' ��� ����������� ���������� � ����� � ������ �� �������
 * Creation date: (19.05.2004 17:04:51)
 * @author: Vadim Glushkov
 */
public class StreetObjectValue {
    private String name = null;
    private String type = null;

    /**
     * �����������
     * @param name
     * @param type
     */
    public StreetObjectValue(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * ����� ���������� ��� ������������ �������
     * @return java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * ����� ��� ��������� ����� ������������ �������
     * @param name java.lang.String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ����� ���������� ��� ������������ �������
     * @return java.lang.String
     */
    public String getType() {
        return type;
    }

    /**
     * ����� ��� ��������� ���� ������������ �������
     * @param type java.lang.String
     */
    public void setType(String type) {
        this.type = type;
    }
}
