
public class _00_StringBuilderClassMethods {

    public static StringBuilder stringBuilderConstructor(String str) {
        return new StringBuilder(str); // return a StringBuilder object initialized with the given string
    }

    public static StringBuilder stringBuilderConstructor() {
        return new StringBuilder(); // return a StringBuilder object initialized with an empty string
    }

    public static StringBuilder stringBuilderConstructor(int capacity) {
        return new StringBuilder(capacity); // return a StringBuilder object initialized with the given capacity
    }

    public static StringBuilder stringBuilderConstructor(CharSequence seq) {
        return new StringBuilder(seq); // return a StringBuilder object initialized with the given CharSequence
    }

    public static StringBuilder appendString(StringBuilder sb, String str) {
        return sb.append(str); // append the given string to the end of the StringBuilder object
    }

    public static StringBuilder insertString(StringBuilder sb, int index, String str) {
        return sb.insert(index, str); // insert the given string at the given index of the StringBuilder object
    }

    public static StringBuilder setCharAtIndex(StringBuilder sb, int index, char ch) {
        sb.setCharAt(index, ch); // set the character at the given index of the StringBuilder object to the given character
        return sb;
    }

    public static StringBuilder deleteString(StringBuilder sb, int startIndex, int endIndex) {
        return sb.delete(startIndex, endIndex); // delete the characters from the given start index to the given end index of the StringBuilder object
    }

    public static StringBuilder deleteCharAt(StringBuilder sb, int index) {
        return sb.deleteCharAt(index); // delete the character at the given index of the StringBuilder object
    }

    public static StringBuilder replaceString(StringBuilder sb, int startIndex, int endIndex, String str) {
        return sb.replace(startIndex, endIndex, str); // replace the characters from the given start index to the given end index of the StringBuilder object with the given string
        // That means, We replace all the characters from the given start index to the given end index of the StringBuilder object with the given string
    }

    public static StringBuilder trimToSize(StringBuilder sb) {
        sb.trimToSize(); // trim the capacity of the StringBuilder object to its current length
        return sb;
    }

    public static StringBuilder reverseString(StringBuilder sb) {
        return sb.reverse(); // reverse the characters of the StringBuilder object
    }

    public static char charAt(StringBuilder sb, int index) {
        return sb.charAt(index); // return the character at the given index of the StringBuilder object
    }

    public static int indexOf(StringBuilder sb, String str) {
        return sb.indexOf(str); // return the index of the first occurrence of the given string in the StringBuilder object
    }

    public static int lastIndexOf(StringBuilder sb, String str) {
        return sb.lastIndexOf(str); // return the index of the last occurrence of the given string in the StringBuilder object
    }

    public static String substring(StringBuilder sb, int startIndex) {
        return sb.substring(startIndex); // return the substring from the given start index to the end of the StringBuilder object
    }

    public static String substring(StringBuilder sb, int startIndex, int endIndex) {
        return sb.substring(startIndex, endIndex); // return the substring from the given start index to the given end index of the StringBuilder object
    }

    public static String toString(StringBuilder sb) {
        return sb.toString(); // return the string representation of the StringBuilder object
    }

    public static int stringBuilderLength(StringBuilder sb) {
        return sb.length(); // return the length of the StringBuilder object
    }

    public static int stringBuilderCapacity(StringBuilder sb) {
        return sb.capacity(); // return the capacity of the StringBuilder object
    }

    public static void setLength(StringBuilder sb, int newLength) {
        sb.setLength(newLength); // set the length of the StringBuilder object to the given length
        //  If the new length is greater than the current length, null characters are added; if less, the sequence is truncated.
    }

    public static void ensureCapacity(StringBuilder sb, int minimumCapacity) {
        sb.ensureCapacity(minimumCapacity); // ensure that the capacity of the StringBuilder object is at least the given minimum capacity
        // If the current capacity is less than the argument, then a capacity increase will occur.
    }
}