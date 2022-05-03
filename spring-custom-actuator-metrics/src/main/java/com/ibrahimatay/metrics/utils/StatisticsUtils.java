package com.ibrahimatay.metrics.utils;

import java.util.Map;

public class StatisticsUtils {
    public static int maxId(Map<Integer, String> objectStorage) {
        return objectStorage.keySet().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static long averageContentSize(Map<Integer, String> objectStorage) {
        return Math.round(objectStorage.values().stream()
                .mapToInt(String::length)
                .average()
                .orElse(0));
    }
}
