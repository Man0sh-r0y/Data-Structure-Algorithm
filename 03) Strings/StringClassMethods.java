package _02_String;

public class StringClassMethods {
    public static String charArrayToString(char[] array) {
        return new String(array); // allocates a String from a given char array
    }

    public static String charArrayToString(char[] array, int startIndex, int endIndex) {
        return new String(array, startIndex, endIndex); // make string with given array but only choose from startIndex to endIndex
    }

    public static String unicodeArrayToString(int[] array, int startIndex, int endIndex) {
        return new String(array, startIndex, endIndex); // make string with given array but only choose from startIndex to endIndex
        // array contains unicode values of characters
    }

    public static String stringBufferToString(StringBuffer sb) {
        return new String(sb); // allocates String from given StringBuffer
    }

    public static String stringBuilderToString(StringBuilder sb) {
        return new String(sb); // allocates String from given StringBuilder
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase(); // Converts all of the characters in this String to upper case
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase(); // Converts all of the characters in this String to lower case 
    }

    public static String trimString(String str) {
        return str.trim(); // Returns the copy of the String, by removing whitespaces at both ends. It does not affect whitespaces in the middle.
    }

    public static boolean checkIfStringEmpty(String str) {
        return str.isEmpty(); // return true if the given string is empty, false otherwise
        // example: "" -> true
        // example: "abc" -> false
    }

    public static boolean checkIfStringEqual(String str1, String str2) {
        return str1.equals(str2); // Compares this string to the specified object.
    }

    public static boolean checkIfStringEqualIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2); // Compares this String to another String, ignoring case considerations (Uppercase or LowerCase).
    }

    public static String compareLexicographically(String str1, String str2) {
        // Lexicographical means in dictionary order.
        int result = str1.compareTo(str2);
        return result > 0 ? str1 + " is greater than " + str2 : 
               result < 0 ? str1 + " is less than " + str2 : str1 + " is equal to " + str2;
        // result < 0  // str1 comes before s2tr
        // result = 0  // str1 and str2 are equal.
        // result > 0   // str1 comes after str2.
    }

    public static String compareLexicographicallyIgnoreCase(String str1, String str2) {
        // Lexicographical means in dictionary order.
        int result = str1.compareToIgnoreCase(str2);
        return result > 0 ? str1 + " is greater than " + str2 : 
               result < 0 ? str1 + " is less than " + str2 : str1 + " is equal to " + str2;
        // result < 0  // str1 comes before s2tr
        // result = 0  // str1 and str2 are equal.
        // result > 0   // str1 comes after str2.
    }

    public static boolean checkStartOfString(String str, String prefix) {
        return str.startsWith(prefix); // Tests if this string starts with the specified prefix.
    }

    public static boolean checkEndOfString(String str, String suffix) {
        return str.endsWith(suffix); // Tests if this string ends with the specified suffix.
    }

    public static String concatString(String str1, String str2) {
        return str1.concat(str2); // returns concatenated string
    }

    public static char getChar(String str, int index) {
        return str.charAt(index); // returns char at given index
    }

    public static int getLength(String str) {
        return str.length(); // returns length of string
    }

    public static String getSubString(String str, int startIndex) {
        return str.substring(startIndex); // returns substring from startIndex to end of string
    }

    public static String getSubString(String str, int startIndex, int endIndex) {
        return str.substring(startIndex, endIndex); // returns substring from startIndex to endIndex
    }

    public static int getIndexOfFirstOccurence(String str, String s) {
        return str.indexOf(s); // Returns the index of the first occurrence of the specified string (s)
    }

    public static int getIndexOfFirstOccurence(String str, String s, int fromIndex) {
        return str.indexOf(s, fromIndex); // Returns the index of the first occurrence of the specified string (s) starting from the specified index (fromIndex)
    }

    public static int getIndexOfLastOccurence(String str, String s) {
        return str.lastIndexOf(s); // Returns the index of the last occurrence of the specified string (s)
    }

    public static String intToString(int num) {
        return String.valueOf(num); // return a string representation of the given integer
        // example: 123 -> "123"
    }

    public static String doubleToString(double num) {
        return String.valueOf(num); // return a string representation of the given double
        // example: 123.456 -> "123.456"
    }

    public static int stringToInt(String str) {
        return Integer.parseInt(str); // return an integer representation of the given string
        // example: "123" -> 123
    }

    public static boolean regexMatching(String str, String regex) {
        return str.matches(regex); // return true if the string matches the given regular expression
    }

    public static String replaceCharInString(String str, char oldChar, char newChar) {
        return str.replace(oldChar, newChar); // return a new string with all occurrences of old character replaced by new character
    }

    public static String replaceAllString(String str, String regex, String replacement) {
        return str.replaceAll(regex, replacement); // return a new string by replacing all occurrences of a specified substring with another string.
    }

    public static String[] splitString(String str, String regex) {
        return str.split(regex); // return an array of sub strings computed by splitting the given string based on given regex
        // spliting can be like "," or " " etc.
        // example: "a,b,c" -> ["a", "b", "c"]
        // example: "a b c" -> ["a", "b", "c"]
    }

    public static boolean stringContains(String str, String s) {
        return str.contains(s); // returns true if this string contains the specified given String
    }

    public static char[] stringToCharArray(String str) {
        return str.toCharArray(); // Converts this string to a new character array.
    }
}
