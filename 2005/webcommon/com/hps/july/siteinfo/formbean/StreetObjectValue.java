package com.hps.july.siteinfo.formbean;

/**
 * Шаблон 'Value Object' для отображения информации о метро и улицах на шаблоне
 * Creation date: (19.05.2004 17:04:51)
 * @author: Vadim Glushkov
 */
public class StreetObjectValue {
    private String name = null;
    private String type = null;

    /**
     * Конструктор
     * @param name
     * @param type
     */
    public StreetObjectValue(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Метод возвращает имя сохраненного объекта
     * @return java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для установки имени сохраняемого объекта
     * @param name java.lang.String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает тип сохраненного объекта
     * @return java.lang.String
     */
    public String getType() {
        return type;
    }

    /**
     * Метод для установки типа сохраняемого объекта
     * @param type java.lang.String
     */
    public void setType(String type) {
        this.type = type;
    }
}
