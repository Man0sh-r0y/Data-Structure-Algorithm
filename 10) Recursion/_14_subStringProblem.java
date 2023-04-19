import java.util.ArrayList;

public class _14_subStringProblem {

    static ArrayList<String> list = new ArrayList<>();

    public static void SubString(String str, int n, int i, int j) {
        if (i == n - 1) {// created by Sayan Sen
            list.add(str.substring(n - 1));
            return;
        }
        if (j > n) {
            i += 1;
            SubString(str, n, i, j = i + 1);
            return;
        }
        list.add(str.substring(i, j));
        SubString(str, n, i, j + 1);
        return;
    }

    static ArrayList<String> list2 = new ArrayList<>();

    public static void uniqueSubSeq(String str) {
        if (str.isEmpty()) {// Created my own code
            return;
        }
        if (list2.indexOf(str) == -1) {
            list2.add(str);
        }
        uniqueSubSeq(str.substring(1));
        uniqueSubSeq(str.substring(0, str.length() - 1));
    }

    static ArrayList<String> list3 = new ArrayList<>();

    public static void SubStringStartAndEndSameChar(String str) {
        if (str.isEmpty()) {// Created my own code
            return;
        }
        char charAt1stPos = str.charAt(0);
        char charAtLastPos = str.charAt(str.length() - 1);
        if (list3.indexOf(str) == -1 && charAt1stPos == charAtLastPos) {
            list3.add(str);
        }
        SubStringStartAndEndSameChar(str.substring(1));
        SubStringStartAndEndSameChar(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        String str = "abcab";
        // SubString(str, str.length(), 0, 1);
        // System.out.println(list);
        // SubStringProblem(str);
        // System.out.println(list2);

        SubStringStartAndEndSameChar(str);
        System.out.println(list3);
    }
}
