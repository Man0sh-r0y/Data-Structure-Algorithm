
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder("");
        if (strs.length == 1) {
            result.append(strs[0]);
            return result.toString();
        }
        for (int i = 1; i < strs[0].length() + 1; i++) {
            String commonPrefix = strs[0].substring(0, i);
            int flag = 0;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].startsWith(commonPrefix)) {
                    flag++;
                }
            }
            if (flag == strs.length) {
                result.append(commonPrefix.charAt(commonPrefix.length() - 1));
                // Every time substring is getting created (commonPrefix)
                // But we need the last char of every substring
                // (to avoid to store same char many times)
            } else {
                return result.toString();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] arr = { "flower", "flower", "flower", "flower" };
        String result = longestCommonPrefix(arr);
        System.out.println(result);
    }
}
