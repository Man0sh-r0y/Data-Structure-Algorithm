package _02_String;

public class StringBufferClassMethods {
    public static StringBuffer stringBufferConstructor(String str) {
        return new StringBuffer(str); // return a StringBuffer object initialized with the given string
    }

    public static StringBuffer stringBufferConstructor() {
        return new StringBuffer(); // return a StringBuffer object initialized with an empty string
    }

    public static StringBuffer stringBufferConstructor(int capacity) {
        return new StringBuffer(capacity); // return a StringBuffer object initialized with the given capacity
    }

    public static StringBuffer stringBufferConstructor(CharSequence seq) {
        return new StringBuffer(seq); // return a StringBuffer object initialized with the given CharSequence
    }

    public static StringBuffer appendString(StringBuffer sb, String str) {
        return sb.append(str); // append the given string to the end of the StringBuffer object
    }

    public static StringBuffer insertString(StringBuffer sb, int index, String str) {
        return sb.insert(index, str); // insert the given string at the given index of the StringBuffer object
    }

    public static StringBuffer setCharAtIndex(StringBuffer sb, int index, char ch) {
        sb.setCharAt(index, ch); // set the character at the given index of the StringBuffer object to the given character
        return sb;
    }

    public static StringBuffer deleteString(StringBuffer sb, int startIndex, int endIndex) {
        return sb.delete(startIndex, endIndex); // delete the characters from the given start index to the given end index of the StringBuffer object
    }

    public static StringBuffer deleteCharAt(StringBuffer sb, int index) {
        return sb.deleteCharAt(index); // delete the character at the given index of the StringBuffer object
    }

    public static StringBuffer replaceString(StringBuffer sb, int startIndex, int endIndex, String str) {
        return sb.replace(startIndex, endIndex, str); // replace the characters from the given start index to the given end index of the StringBuffer object with the given string
        // That means, We replace all the characters from the given start index to the given end index of the StringBuffer object with the given string
    }

    public static StringBuffer trimToSize(StringBuffer sb) {
        sb.trimToSize(); // trim the capacity of the StringBuffer object to its current length
        return sb;
    }

    public static StringBuffer reverseString(StringBuffer sb) {
        return sb.reverse(); // reverse the characters of the StringBuffer object
    }

    public static char charAt(StringBuffer sb, int index) {
        return sb.charAt(index); // return the character at the given index of the StringBuffer object
    }

    public static int indexOf(StringBuffer sb, String str) {
        return sb.indexOf(str); // return the index of the first occurrence of the given string in the StringBuffer object
    }

    public static int lastIndexOf(StringBuffer sb, String str) {
        return sb.lastIndexOf(str); // return the index of the last occurrence of the given string in the StringBuffer object
    }

    public static String substring(StringBuffer sb, int startIndex) {
        return sb.substring(startIndex); // return the substring from the given start index to the end of the StringBuffer object
    }

    public static String substring(StringBuffer sb, int startIndex, int endIndex) {
        return sb.substring(startIndex, endIndex); // return the substring from the given start index to the given end index of the StringBuffer object
    }

    public static String toString(StringBuffer sb) {
        return sb.toString(); // return the string representation of the StringBuffer object
    }

    public static int stringBufferLength(StringBuffer sb) {
        return sb.length(); // return the length of the StringBuffer object
    }

    public static int stringBufferCapacity(StringBuffer sb) {
        return sb.capacity(); // return the capacity of the StringBuffer object
    }

    public static void setLength(StringBuffer sb, int newLength) {
        sb.setLength(newLength); // set the length of the StringBuffer object to the given length
        //  If the new length is greater than the current length, null characters are added; if less, the sequence is truncated.
    }

    public static void ensureCapacity(StringBuffer sb, int minimumCapacity) {
        sb.ensureCapacity(minimumCapacity); // ensure that the capacity of the StringBuffer object is at least the given minimum capacity
        // If the current capacity is less than the argument, then a capacity increase will occur.
    }
}

