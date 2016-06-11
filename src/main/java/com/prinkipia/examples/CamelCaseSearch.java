package com.prinkipia.examples;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

import static java.lang.Character.isUpperCase;

public class CamelCaseSearch {
    public static Set<String> camelCaseSearch(final String query, Set<String> corpus) {
        Set<String> matches = new TreeSet<>();
        if (query == null || query.isEmpty()) {
            return matches;
        }
        for (String value : corpus) {
            if (matches(query, value)) {
                matches.add(value);
            }
        }
        return matches;
    }

    private static boolean matches(String query, String value) {
        Pattern queryPattern = createPatternFromQuery(query);

        if (queryPattern.matcher(value).matches()) {
            return true;
        }
        return false;
    }

    // build regex where FB finds all F*B*
    private static Pattern createPatternFromQuery(String query) {
        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < query.length(); i++) {
            char c = query.charAt(i);
            if (isUpperCase(c) && regex.length() > 0) {
                regex.append(".*");
            }
            regex.append(c);
        }
        regex.append(".*");
        return Pattern.compile(regex.toString());
    }

    public static void main(String[] args) {

        Set<String> corpus = new HashSet<>();
        corpus.add("FooBar");
        corpus.add("FreeBooze");
        corpus.add("FooJar");
        Set<String> results = camelCaseSearch("FB", corpus);
        System.out.println(results);

        results = camelCaseSearch("", corpus);
        System.out.println(results);

        results = camelCaseSearch("FBa", corpus);
        System.out.println(results);
    }
}
