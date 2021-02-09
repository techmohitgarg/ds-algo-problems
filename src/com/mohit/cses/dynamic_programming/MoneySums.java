package com.mohit.cses.dynamic_programming;

import java.util.*;

public class MoneySums {
    public static void main(String[] args) {
        MoneySums sums = new MoneySums();
        Scanner sc = new Scanner(System.in);
        sums.moneySum_(sc);
    }


    private void moneySum_(Scanner sc) {
        int i, j = 0;

        int n = sc.nextInt();
        int a[] = new int[n];

        int sum = 0;

        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        boolean t[][] = new boolean[n + 1][sum + 1];

        j = 0;

        for (i = 0; i < n + 1; i++) t[i][j] = true;

        for (i = 1; i < n + 1; i++) {
            for (j = 1; j < sum + 1; j++) {
                if (a[i - 1] <= j)
                    t[i][j] = t[i - 1][j - a[i - 1]] || t[i - 1][j];
                else t[i][j] = t[i - 1][j];

            }
        }

        HashSet<Integer> hp = new HashSet<>();

        for (i = 1; i < n + 1; i++) {
            for (j = 1; j < sum + 1; j++) {
                if (t[i][j] == true) hp.add(j);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        Iterator<Integer> it = hp.iterator();

        while (it.hasNext()) {
            arr.add(it.next());
        }

        Collections.sort(arr);

        int l = arr.size();

        System.out.println(l);

        for (i = 0; i < l; i++) System.out.print(arr.get(i) + " ");
    }

    private int moneySum(Scanner sc) {

        int n = sc.nextInt();

        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            List<Integer> temp = new ArrayList<>();
            Iterator<Integer> iterable = result.iterator();

            while (iterable.hasNext()) {
                temp.add(x + iterable.next());
            }

            result.add(x);

            for (int val : temp) {
                result.add(val);
            }


        }

        System.out.println(result.size());
        Iterator<Integer> iterable = result.stream().sorted().iterator();
        while (iterable.hasNext()) {
            System.out.printf(iterable.next() + " ");
        }

        return 0;
    }
}
