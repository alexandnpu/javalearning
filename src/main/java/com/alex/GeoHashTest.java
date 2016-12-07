package com.alex;

import ch.hsr.geohash.GeoHash;

/**
 * Created by zhengchao on 16/10/24.
 */
public class GeoHashTest {
    public static void main(String[] args) {
        GeoHash geoHash = GeoHash.withBitPrecision(1, 1, 64);
        System.out.println(geoHash.toString());
        System.out.println("-------------------");
        for (GeoHash g : geoHash.getAdjacent()) {
            System.out.println(g.toString());
        }
    }
}
