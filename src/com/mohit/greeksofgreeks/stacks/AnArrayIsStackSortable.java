package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class AnArrayIsStackSortable {
    public static void main(String[] args) {
        AnArrayIsStackSortable sol = new AnArrayIsStackSortable();
        int arr[] = {2, 3, 1};
        System.out.println(sol.canSorted(arr));
    }


    public boolean canSorted(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int b_Arr_from_End = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!st.isEmpty()) {


                while (st.peek() == b_Arr_from_End + 1 && !st.isEmpty()) {
                    b_Arr_from_End++;
                    st.pop();

                    if (st.isEmpty()) break;

                }

                if (st.isEmpty()) {
                    st.push(arr[i]);
                } else {
                    if (arr[i] < st.peek()) {
                        st.push(arr[i]);
                    } else {
                        return false;
                    }
                }
            } else {
                st.push(arr[i]);
            }

        }
        return true;
    }


}