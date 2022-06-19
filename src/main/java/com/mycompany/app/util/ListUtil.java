package com.mycompany.app.util;

import java.util.ArrayList;
import java.util.Collections;

public class ListUtil {
    /**
     * Return a ArrayList from params
     * @param params
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> arrayListOf(T... params) {
        ArrayList<T> result = new ArrayList<>();
        Collections.addAll(result, params);
        return result;
    }
}
