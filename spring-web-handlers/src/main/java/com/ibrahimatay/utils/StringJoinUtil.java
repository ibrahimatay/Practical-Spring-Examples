package com.ibrahimatay.utils;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StringJoinUtil {
    public static String join(Enumeration<String> enumeration) {
        return join(enumeration.asIterator());
    }

    public static String join(Iterator<String> iterator) {
        List<String> elements = new LinkedList<>();
        iterator.forEachRemaining(elements::add);
        return String.join(", ", elements);
    }
}
