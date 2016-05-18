package org.wnb.domain.region;

import java.util.HashMap;
import java.util.Map;

public class Region {

    public static final String ROOT_CODE = "0";
    private String code;
    private String name;
    private Region parent;

    private Map<String, Region> subregions = new HashMap<>();
    private Map<String, String> subregionNameMap = new HashMap<>();

    public Region() {
    }

    public Region(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getParent() {
        return parent;
    }

    public void setParent(Region parent) {
        this.parent = parent;
    }

    public void addSubregion(Region region) {
        if (subregions.containsKey(region.getCode()))
            throw new IllegalArgumentException("Subregion code exist.");
        subregions.put(region.getCode(), region);
        subregionNameMap.put(region.getName(), region.getCode());
    }

    public boolean isRoot() {
        return ROOT_CODE.equals(this.getCode());
    }

    public int getLevel() {
        return this.isRoot() ? 0 : getParent().getLevel() + 1;
    }

    public Region getRoot() {
        return this.isRoot() ? this : getParent().getRoot();
    }

    public Region getSubregionByCode(String code) {
        return subregions.get(code);
    }

    public Region getSubregionByName(String name) {
        return subregionNameMap.containsKey(name) ? subregions.get(subregionNameMap.get(name)) : null;
    }

}
