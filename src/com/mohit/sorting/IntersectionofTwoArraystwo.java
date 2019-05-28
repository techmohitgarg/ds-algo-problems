/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.sorting;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mohit
 */
public class IntersectionofTwoArraystwo {

    public static void main(String[] args) {
        IntersectionofTwoArraystwo intersectionofTwoArrays = new IntersectionofTwoArraystwo();
        int[] num_one = {1, 2, 2, 1};
        int[] num_two = {2, 2};
        intersectionofTwoArrays.intersection(num_one, num_two);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!hm.containsKey(nums1[i])) {
                hm.put(nums1[i], 1);
            } else {
                hm.put(nums1[i], hm.get(nums1[i]) + 1);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hm.containsKey(nums2[i]) && hm.get(nums2[i]) > 0) {
                arr.add(nums2[i]);
                hm.put(nums2[i], hm.get(nums2[i]) - 1);
            }
        }
        int[] is = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            is[i] = arr.get(i);
        }
        return is;
    }

}
