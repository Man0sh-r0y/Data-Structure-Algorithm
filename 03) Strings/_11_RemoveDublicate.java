public class _11_RemoveDublicate {

    public static String removeDublicate(String str) {
        StringBuilder result = new StringBuilder("");
        boolean arr[] = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'a']) {
                arr[str.charAt(i) - 'a'] = false;
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "mmaannaasshh";
        System.out.println(removeDublicate(str));
    }
}