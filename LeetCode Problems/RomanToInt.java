import java.util.*;

public class RomanToInt {
    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // for IV,IX,XL,XC,CD,CM
            if (i + 2 < s.length() + 1) {
                String str1 = s.substring(i, i + 2);
                if (map.containsKey(str1) != false) {
                    ans += map.get(str1);
                    i++;// as 2 character already taken
                    continue;
                }
            }
            // for other keys
            String str2 = s.substring(i, i + 1);// single character taken
            ans += map.get(str2);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "MCMXCIV";
        // String str2 = "III";
        int ans = romanToInt(str1);
        System.out.println(ans);

    }
}
