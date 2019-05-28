/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.strings.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mohit Garg
 */
public class FindDuplicateFile {

    public static void main(String[] args) {
        FindDuplicateFile problems = new FindDuplicateFile();
        System.out.println(problems.findDuplicate(new String[]{
            "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root/ r5.txt(efgh)"
        }));
    }

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<>();
        int n = paths.length;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] path = getAllFiles(paths[i]);
            if (path.length > 0 && path[0].length() > 0) {
                for (int j = 1; j < path.length; j++) {
                    String content = path[j].substring(path[j].indexOf('(') + 1, path[j].indexOf(')'));
                    if (map.containsKey(content)) {
                        List<String> tempList = map.get(content);
                        tempList.add(path[0] + "/" + path[j].substring(0, path[j].indexOf('(')));
                        map.put(content, tempList);
                    } else {
                        List<String> tempList = new ArrayList<>();
                        tempList.add(path[0] + "/" + path[j].substring(0, path[j].indexOf('(')));
                        map.put(content, tempList);
                    }
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value.size() > 1) {
                list.add(value);
            }
        }
        return list;
    }

    public String[] getAllFiles(String path) {
        return path.split(" ");
    }

}
