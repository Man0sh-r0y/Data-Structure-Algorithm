public class removeDublicates {

    public static void RemoveDublicates(int n, boolean map[], String str, StringBuilder newStr) {
        if (n == str.length()) {
            System.out.print(newStr);
            return;
        }
        char currChar = str.charAt(n);
        if (map[currChar - 'a']) {
            RemoveDublicates(n + 1, map, str, newStr);
        } else {
            map[currChar - 'a'] = true;
            newStr = newStr.append(currChar);
            RemoveDublicates(n + 1, map, str, newStr);
        }
    }

    public static void main(String[] args) {
        // appnnacollege => apnacoleg
        String str = "appnnacollege";
        RemoveDublicates(0, new boolean[26], str, new StringBuilder(" "));
    }
}
