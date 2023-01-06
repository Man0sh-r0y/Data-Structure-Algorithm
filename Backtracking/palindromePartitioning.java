import java.util.*;

public class palindromePartitioning {

    public static void partition(String str, int index, List<List<String>> ans, List<String> list) {

        if (index == str.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(str, index, i)) {
                list.add(str.substring(index, i + 1));
                partition(str, index + 1, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> ans = new ArrayList<>();
        partition(str, 0, ans, new ArrayList<>());
        System.out.println(ans);
    }
}
