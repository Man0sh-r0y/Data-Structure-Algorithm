import java.util.*;

public class _37_ExpressionAddOperators {

    public static List<String> ans = new ArrayList<>();

    public static void dfs(int indx, String path, long result, long prevNum, String s, int target) {
        // System.out.println("path= " + path + " result= " + result + " string =" + s +
        // " prev= " + prevNum);//=> for decode purpose

        if (indx == s.length()) {
            if (result == target)
                ans.add(path);
            return;
        }
        for (int i = indx; i < s.length(); i++) {
            if (i > indx && s.charAt(i) == '0')
                break; // Skip leading zero number
            long currNum = Long.parseLong(s.substring(indx, i + 1));
            if (indx == 0) {
                dfs(i + 1, path + currNum, currNum, currNum, s, target); // First num, pick it without adding any
                                                                         // operator!
            } else {
                dfs(i + 1, path + "+" + currNum, result + currNum, currNum, s, target);
                dfs(i + 1, path + "-" + currNum, result - currNum, -currNum, s, target);
                dfs(i + 1, path + "*" + currNum, result - prevNum + prevNum * currNum, prevNum * currNum, s, target);
            }
        }
    }

    public static void main(String[] args) {
        String str = "123";
        int target = 6;
        dfs(0, "", 0, 0, str, target);
        System.out.println(ans);

    }
}