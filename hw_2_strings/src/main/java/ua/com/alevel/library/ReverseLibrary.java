package ua.com.alevel.library;

public final class ReverseLibrary {

    private ReverseLibrary() {
    }

    public static String reverse(String input) {
        char[] symbols = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            symbols[i] = input.charAt(input.length() - i - 1);
        }
        return new String(symbols);
    }

    public static String reverseSubstring(String input, String substring) {
        String reverseSubstring = reverse(substring);
        if (input.toLowerCase().contains(substring.toLowerCase())) {
            return input.replaceAll(substring, reverseSubstring);
        } else {
            return "This string does not contain such substring";
        }
    }

    public static String reverseByFirstAndLastIndexes(String input, int firstIndex, int lastIndex) {
        StringBuilder substring = new StringBuilder(input.length());
        for (int i = firstIndex; i <= lastIndex; i++) {
            substring.append(input.charAt(i));
        }
        return input.replaceAll(substring.toString(), reverse(substring.toString()));
    }
}

