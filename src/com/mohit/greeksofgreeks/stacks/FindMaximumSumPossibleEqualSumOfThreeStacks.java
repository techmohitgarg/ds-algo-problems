package com.mohit.greeksofgreeks.stacks;

public class FindMaximumSumPossibleEqualSumOfThreeStacks {

    public static void main(String[] args) {
        FindMaximumSumPossibleEqualSumOfThreeStacks sol = new FindMaximumSumPossibleEqualSumOfThreeStacks();
        int stack1[] = {3, 2, 1, 1, 1};
        int stack2[] = {4, 3, 2};
        int stack3[] = {1, 1, 4, 1};
        System.out.println(sol.maxSum(stack1, stack2, stack3));
    }


    public int maxSum(int stack1[],
                      int stack2[],
                      int stack3[]) {

        int n1 = stack1.length, n2 = stack2.length, n3 = stack3.length;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int i = 0;
        while (i < n1 || i < n2 || i < n3) {
            if (i < n1) {
                sum1 += stack1[i];
            }
            if (i < n2) {
                sum2 += stack2[i];
            }
            if (i < n3) {
                sum3 += stack3[i];
            }
            i++;
        }
        i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2 && k < n3) {
            if (sum1 == sum2 && sum2 == sum3) return sum1;
            int max = Math.max(sum1, Math.max(sum2, sum3));
            if (max == sum1) {
                sum1 -= stack1[i++];
            } else if (max == sum2) {
                sum2 -= stack2[j++];
            } else if (max == sum3) {
                sum3 -= stack3[k++];
            }
        }
        return 0;
    }
}