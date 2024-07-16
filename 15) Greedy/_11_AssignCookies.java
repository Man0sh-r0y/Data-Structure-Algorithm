import java.util.*;

public class _11_AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // each child is denoted by i
        int  j = 0; // each cookie is denoted by j
        int child = 0; // number of children who can eat the cookie

        while(i < g.length && j < s.length) {
            
        }

        return child;
    }

    public static void main(String[] args) {
        int[] g = { 1, 2, 3 };
        int[] s = { 1, 1 };
        System.out.println(findContentChildren(g, s));
    }
}
