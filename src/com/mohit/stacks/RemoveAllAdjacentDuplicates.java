package com.mohit.stacks;

import java.util.Stack;

class RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicates duplicates = new RemoveAllAdjacentDuplicates();

    }

    public void removeAllAdjacentDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int skt = -1;
        int i = 0;
        while (i < arr.length) {
            if (skt == -1 || arr[skt] != arr[i]) {
                skt++;
                arr[skt] = arr[i];
                i++;
            } else {
                while (i < arr.length && arr[skt] == arr[i]) {
                    i++;
                    skt--;
                }
            }
        }

    }

}