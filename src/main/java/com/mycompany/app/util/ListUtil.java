package com.mycompany.app.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    public static <T> ArrayList<T> arrayListOf(List<T>... params) {
        ArrayList<T> result = new ArrayList<>();
        for (List<T> param: params) {
            result.addAll(param);
        }
        return result;
    }
}
