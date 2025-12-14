package org.ryank;

public class Util {

    // Convert each word to Title Case
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) return str;
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (w.isEmpty()) continue;
            sb.append(Character.toUpperCase(w.charAt(0)));
            if (w.length() > 1) sb.append(w.substring(1).toLowerCase());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
