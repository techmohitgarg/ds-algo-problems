package com.mohit.cses.dynamic_programming;

import javax.swing.text.html.StyleSheet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Projects {
    public static void main(String[] args) {
        Projects projects = new Projects();

        Scanner scanner = new Scanner(System.in);

        projects.projectsMaxProfit(scanner);
    }


    private void projectsMaxProfit(Scanner sc) {
        int n = sc.nextInt();

        int[][] projects = new int[n][3];
        for (int p = 0; p < n; p++) {
            projects[p][0] = sc.nextInt();
            projects[p][1] = sc.nextInt();
            projects[p][2] = sc.nextInt();
        }
        // Sort the Array according the end date of increasing order
        Arrays.sort(projects, Comparator.comparingInt(o -> o[1]));

    }
}
