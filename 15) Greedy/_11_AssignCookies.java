import java.util.*;

public class _11_AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // g[] determines the greed factor of each child
        Arrays.sort(s); // s[] determines the size of each cookie

        int i = 0; // it will traverse through g[]
        int  j = 0; // it will traverse through s[]
        int child = 0; // number of children who can eat the cookie

        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                child++; // number of children who can eat the cookie
                i++; // increement
                j++; // increment
            } else {
                j++; // only increment j index so that I can get bigger size of cookie
            }
        }

        return child;
    }

    public static void main(String[] args) {
        int[] g = { 1, 2, 3 };
        int[] s = { 1, 1 };
        System.out.println(findContentChildren(g, s));
    }
}
