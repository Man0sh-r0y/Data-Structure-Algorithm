public class _07_stringBuilder {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder("");// Initialize with empty String
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
    }

}
