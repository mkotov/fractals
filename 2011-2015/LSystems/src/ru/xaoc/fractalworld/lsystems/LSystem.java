package ru.xaoc.fractalworld.lsystems;

import java.util.HashMap;
import java.util.Map;

public class LSystem {
    private String first;
    private Map<Character, String> rules;

    public LSystem(String first, Map<Character, String> rules) {
        this.first = first;
        this.rules = rules;
    }

    public LSystem(String first, String[][] rules) {
        this.first = first;
        this.rules = new HashMap<Character, String>();
        for (int i = 0; i < rules.length; ++i) {
           this.rules.put(rules[i][0].charAt(0), rules[i][1]);
        }
    }

    private String apply(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            if (rules.containsKey(string.charAt(i))) {
                result.append(rules.get(string.charAt(i)));
            } else {
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }

    public String getResult(int depth) {
        String result = first;
        for (int i = 0; i < depth; ++i) {
            result = this.apply(result);
        }
        return result;
    }
}
