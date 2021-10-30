package ua.com.alevel.level_2;

import java.util.Stack;

public class Bracket {
    private final char openBracket;
    private final char closeBracket;
    private boolean flagOpenBracket = false;
    private boolean flagCloseBracket = false;

    Bracket(char openBracket, char closeBracket) {
        this.openBracket = openBracket;
        this.closeBracket = closeBracket;
    }

    boolean isChangeBracketCondition(char outerChar) {
        flagOpenBracket = false;
        flagCloseBracket = false;
        if (outerChar == openBracket) {
            flagOpenBracket = true;
            return true;
        } else if (outerChar == closeBracket) {
            flagCloseBracket = true;
            return true;
        }
        return false;
    }

    public char getOpenBracket() {
        return openBracket;
    }

    public char getCloseBracket() {
        return closeBracket;
    }

    public boolean isFlagOpenBracket() {
        return flagOpenBracket;
    }

    public boolean isFlagCloseBracket() {
        return flagCloseBracket;
    }

    public static class CheckBracketsValidity {
        private static final Stack<Character> openBracketStack = new Stack<>();
        private static final Bracket[] bracketBox = {
                new Bracket('(', ')'),
                new Bracket('[', ']'),
                new Bracket('{', '}'),
        };

        public static String getTypeBrackets() {
            StringBuilder boxRet = new StringBuilder();
            for (Bracket tmpBrt : bracketBox) {
                boxRet.append(tmpBrt.getOpenBracket()).append(' ').append(tmpBrt.getCloseBracket()).append(',');
            }
            return boxRet.append('\n').toString();
        }

        public static boolean isValidString(String fromUser) {
            if (fromUser.isEmpty()) {
                return true;
            }
            if (fromUser.length() < 2)
                return false;

            boolean forRet = false;
            for (Bracket tmpBrt : bracketBox) {
                if (fromUser.indexOf(tmpBrt.getOpenBracket()) > -1 || fromUser.indexOf(tmpBrt.getCloseBracket()) > -1)
                    forRet = true;
            }
            return forRet;
        }

        public static boolean isLegalBrackets(String fromUser) {
            for (char tmpChar : fromUser.toCharArray()) {
                for (Bracket tmpBrt : bracketBox) {
                    if (tmpBrt.isChangeBracketCondition(tmpChar)) {
                        if (tmpBrt.isFlagOpenBracket())
                            openBracketStack.push(tmpBrt.getOpenBracket());
                        if (tmpBrt.isFlagCloseBracket())
                            if (openBracketStack.empty() || !openBracketStack.pop().equals(tmpBrt.getOpenBracket())) {
                                openBracketStack.clear();
                                return false;
                            }
                    }
                }
            }
            if (!openBracketStack.empty()) {
                openBracketStack.clear();
                return false;
            }
            return true;
        }
    }
}