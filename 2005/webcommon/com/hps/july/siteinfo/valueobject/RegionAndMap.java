package com.hps.july.siteinfo.valueobject;

import java.util.ArrayList;
import java.util.Collection;
import java.io.Serializable;

public class RegionAndMap extends Object implements Serializable {

    private ValueObject region = null;
    private ArrayList maps = new ArrayList();

    public RegionAndMap(ValueObject region) {
        this.region = region;
    }
    public RegionAndMap(ValueObject region, Collection maps) {
        this.region = region;
        this.maps.addAll(maps);
    }

    public ValueObject getRegion() {
        return region;
    }

    public void setRegion(ValueObject region) {
        this.region = region;
    }

    public Collection getMaps() {
        return this.maps;
    }

    public void addMap(ValueObject vo) {
        if(vo != null) {
            this.maps.add(vo);
        }
    }

    public Integer hasMaps() {
        return (this.maps.size() > 0)?new Integer(1):new Integer(0);
    }
}
