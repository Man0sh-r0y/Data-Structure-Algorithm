import java.util.*;

public class _29_LengthOfString {

    public static int findLengthOfString(int indx, String str) {
        if (str.charAt(indx) == '\0') {
            return indx;
        }
        return findLengthOfString(indx + 1, str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = sc.nextLine();
        str = str + "\0";
        System.out.println(findLengthOfString(0, str));
        sc.close();
    }
}
