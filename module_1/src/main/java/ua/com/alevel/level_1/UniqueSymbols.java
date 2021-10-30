package ua.com.alevel.level_1;

import java.util.HashSet;
import java.util.Set;

public final class UniqueSymbols {

    private UniqueSymbols() {
    }

    public static int getUniqueSymbolsCount(String userInput) {
        Set<String> uniqueNumbersSet = new HashSet<>();

        for (int i = 0; i < userInput.toCharArray().length; i++) {
            uniqueNumbersSet.add(String.valueOf(userInput.charAt(i)));
        }
        return uniqueNumbersSet.size();
    }
}