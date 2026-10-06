package com.example.yg_lab2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCounter {

    public static String getCharsCount(String input) {
        return String.valueOf(input.length());
    }

    public static String getWordsCount(String input) {
        return String.valueOf(input.split("\\w+").length);
    }

    public static String getSentencesCount(String input) {
        return String.valueOf(input.split("(?<=[.,!?])\\s+").length);
    }

    public static String getNumbersCount(String input) {
        Pattern digitRegex = Pattern.compile("\\d");
        Matcher countNumberMatcher = digitRegex.matcher(input);
        int count = 0;
        while (countNumberMatcher.find()) { count++; }
        return String.valueOf(count);
    }
}
