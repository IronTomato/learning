package com.wnb.domain.region;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Regions {

    private static class RegionContainer {
        private Map<String, Region> allRegions;
        private Region rootRegion;

        private void refresh() {
            allRegions = new HashMap<>();
            rootRegion = new Region(Region.ROOT_CODE, "");
            Integer[] list = {1,2,4};
        }
    }
}
