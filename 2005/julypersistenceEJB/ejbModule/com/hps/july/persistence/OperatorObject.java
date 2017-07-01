package com.hps.july.persistence;

/**
 * ������ ��� ������ � ����������� �������.
 * Creation date: (21.05.2004 12:18:40)
 * @author: Dmitry Dneprov
 */
public class OperatorObject {
    /**
     * OperatorObject constructor comment.
     */
    public OperatorObject() {
        super();
    }
    /**
     * ����� ���������� ��� ��������� �� ��� login.
     * Creation date: (21.05.2004 12:20:08)
     * @return java.lang.Integer
     * @param argLogin java.lang.String
     */
    public static Integer getOperatorCode(String argLogin) {
        Integer result = null;
        String operatorName = argLogin;
        try {
            int index = operatorName.indexOf("/");
            if (index != -1)
                operatorName = operatorName.substring(index + 1);
            result =
                new Integer(new OperatorAccessBean().findByLogin(operatorName).getOperator());
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("�� �������� ���������� ��� ���������, login=" + argLogin);
        }
        return result;
    }
}