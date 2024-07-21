import java.util.*;

public class _33_palindromePartitioning {

    private static boolean checkPalindrome(String str) {
        int l = 0, r = str.length() - 1; // left pointer and right pointer

        while(l < r) if(str.charAt(l++) != str.charAt(r--)) return false;

        return true;
    }

    private static void findPartition(int indx, String str, List<String> ds, List<List<String>> ans) {
        if(indx == str.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=indx; i<str.length(); i++) {
            String subString = str.substring(indx, i+1);
            
            if(checkPalindrome(subString)) {
                ds.add(subString);
                findPartition(i+1, str, ds, ans);
                ds.remove(ds.size()-1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        findPartition(0, s, ds, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
