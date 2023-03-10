public class RemoveDublicate {

    public static String removeDublicate(String str) {
        StringBuilder result = new StringBuilder("");
        int arr[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'a'] == 1) {
                result.append(str.charAt(i));
            }
            if (arr[str.charAt(i) - 'a'] > 1) {
                result.append(str.charAt(i));
                arr[str.charAt(i) - 'a'] = 0;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "mmaannaasshh";
        System.out.println(removeDublicate(str));
    }
}