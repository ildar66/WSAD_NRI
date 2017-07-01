package com.hps.july.persistence;

/**
 * Объект для работы с операторами системы.
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
     * Метод возвращает код оператора по его login.
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
            System.out.println("Не возможно определить код оператора, login=" + argLogin);
        }
        return result;
    }
}