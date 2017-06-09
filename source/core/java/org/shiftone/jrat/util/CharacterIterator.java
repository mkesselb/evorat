package org.shiftone.jrat.util;

public class CharacterIterator {

    private char[] chars;
    private int pos = -1;
    private char current;

    public CharacterIterator(String text) {
        this.chars = text.toCharArray();
    }

    public CharacterIterator(char[] chars) {
        this.chars = chars;
    }

    public boolean next() {

        pos++;

        if (pos >= chars.length) {
            return false;
        } else {
            current = chars[pos];

            return true;
        }
    }

    public char get() {
        return current;
    }
}
