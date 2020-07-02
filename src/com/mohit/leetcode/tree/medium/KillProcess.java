package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class KillProcess {

    public static void main(String[] s) {
        KillProcess sol = new KillProcess();
        List<Integer> pid = new ArrayList<>();
        List<Integer> ppid = new ArrayList<>();
        int[] p1 = {1, 3, 10, 5};
        int[] p2 = {3, 0, 5, 3};
        for (int i = 0; i < p1.length; i++) {
            pid.add(p1[i]);
        }
        for (int i = 0; i < p2.length; i++) {
            ppid.add(p2[i]);
        }
        int killProcess = 3;

        System.out.println(sol.killProcess(pid, ppid, killProcess));
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> killProcess = new ArrayList<>();
        if (pid.size() == 0) return killProcess;

        // Key will be ppid And Value will be children list
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!hashMap.containsKey(ppid.get(i))) {
                hashMap.put(ppid.get(i), new ArrayList<>());
            }
            hashMap.get(ppid.get(i)).add(pid.get(i));
        }

        // If HashMap does not contains the kill process means kill process has no child
        if (!hashMap.containsKey(kill)) {
            killProcess.add(kill);
            return killProcess;
        } else {
            killProcess(killProcess, hashMap, kill);
        }
        return killProcess;
    }

    private void killProcess(List<Integer> killProcess, HashMap<Integer, ArrayList<Integer>> hashMap, int kill) {
        // Add the Process in the list
        killProcess.add(kill);

        if (!hashMap.containsKey(kill)) return;

        List<Integer> childList = hashMap.get(kill);
        for (int i = 0; i < childList.size(); i++) {
            killProcess(killProcess, hashMap, childList.get(i));
        }
        // Remove the kill process from hashMap
        hashMap.remove(kill);

    }
}
