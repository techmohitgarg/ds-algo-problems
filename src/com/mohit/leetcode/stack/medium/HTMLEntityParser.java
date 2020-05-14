package com.mohit.leetcode.stack.medium;

import java.util.HashMap;

public class HTMLEntityParser {

    public static void main(String[] args) {
        HTMLEntityParser sol = new HTMLEntityParser();
        System.out.println(sol.entityParser("&amp; is an HTML entity but &ambassador; is not.").equals("& is an HTML entity but &ambassador; is not."));
        System.out.println(sol.entityParser("and I quote: &quot;...&quot;").equals("and I quote: \"...\""));
    }


    public String entityParser(String text) {

        if (text.length() == 0) return text;

        HashMap<String, String> htmlTagValues = new HashMap<>();
        htmlTagValues.put("&quot;", "\"");
        htmlTagValues.put("&apos;", "\'");
        htmlTagValues.put("&amp;", "&");
        htmlTagValues.put("&gt", ">");
        htmlTagValues.put("&lt", "<");
        htmlTagValues.put("&frasl;", "/");


        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == '&') {
                int start = i;
                while (i < text.length() && text.charAt(start) == '&' && text.charAt(i) != ';') {
                    i++;
                }
                String value = text.substring(start, i + 1);
                if (htmlTagValues.containsKey(value)) {
                    sb.append(htmlTagValues.get(value));
                } else {
                    sb.append(value);
                }
            } else {
                sb.append(text.charAt(i));

            }
            i++;
        }
        return sb.toString();
    }

}