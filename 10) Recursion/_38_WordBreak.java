import java.util.*;

public class _38_WordBreak {

    public static void wordBreak(List<List<String>> ans, List<String> sen, String str, String dict[]) {

        if (str.length() == 0) {
            ans.add(new ArrayList<>(sen));
            return;
        }

        for (int i = 0; i < dict.length; i++) {
            if (str.startsWith(dict[i])) {
                sen.add(dict[i] + " "); // adding element
                wordBreak(ans, sen, str.substring(dict[i].length()), dict);
                sen.remove(sen.size() - 1);// backtrack
            }
        }
    }

    public static void main(String[] args) {
        String str = "catsanddog";
        String dict[] = { "cats", "cat", "and", "sand", "dog" };
        List<List<String>> ans = new ArrayList<>();
        wordBreak(ans, new ArrayList<>(), str, dict);
        System.out.println(ans);
    }
}
