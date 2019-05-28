package com.mohit.interviewbit.array;

import java.util.ArrayList;

public class AntiDiagonals {

    public static void main(String[] s) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        list.add(list3);

        System.out.println(new AntiDiagonals().diagonal(list));
    }


    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int m = a.size();
        if (m == 0) {
            return list;
        }
        int n = a.get(0).size();
        if (m != n) {
            return list;
        }
        int i = 0;
        while (i < m * 2 - 1) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int j = 0;
            int k = i;
            if (k < n) {
                j = 0;
                while (k >= 0) {
                    arrayList.add(a.get(j).get(k));
                    j++;
                    k--;
                }
            } else {
                j = (i - n) + 1;
                k = n - 1;
                while (j < n) {
                    arrayList.add(a.get(j).get(k));
                    j++;
                    k--;
                }

            }
            list.add(arrayList);
            i++;
        }


        return list;
    }
}
