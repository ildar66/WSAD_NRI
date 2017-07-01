package com.hps.july.siteinfo.valueobject;

import java.io.Serializable;
import java.util.HashMap;

public class ValueObject implements Serializable {

    private Integer id = null;
    private String name = null;
    private HashMap attributes = new HashMap();

    public ValueObject() {
    }

    public ValueObject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ValueObject(HashMap attributes) {
        this.attributes = attributes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getAttribute(String name) {
        return this.attributes.get(name);
    }

    public void setAttribute(String name, String value) {
        this.attributes.put(name, value);
    }

    public boolean equals(Object o) {
        if(o instanceof ValueObject) {
            ValueObject vo = (ValueObject)o;
            boolean result1 = false;
            boolean result2 = false;
            if(this.id != null && vo.getId() != null &&
                    this.id.equals(vo.getId())) result1 = true;
            if(this.id == null && vo.getId() == null) result1 = true;
            if(this.name == null && vo.getName() == null) result2 = true;
            if(this.name != null && vo.getName() != null &&
                    this.name.equals(vo.getName())) result2 = true;
            return (result1 && result2);
        }
        return false;
    }

    public int hashCode() {
        int result;
        result = ((this.id != null)?this.id.hashCode():0);
        result = 29 * result + ((this.name != null)?this.name.hashCode():0);
        return result;
    }
}
