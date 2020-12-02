package com.mohit.leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OrderedStream {

    int nLen;
    int previous = 0;
    String[] data;

    public OrderedStream(int n) {
        this.nLen = n;
        data = new String[n + 1];
    }

    public List<String> insert(int id, String value) {
        data[id] = value;
        List<String> list = new ArrayList<>();
        for (int i = previous + 1; i < data.length; i++) {
            if (data[i] != null && data[i].length() > 0) {
                list.add(data[i]);
                previous++;
            } else {
                break;
            }
        }
        return list;
    }
}