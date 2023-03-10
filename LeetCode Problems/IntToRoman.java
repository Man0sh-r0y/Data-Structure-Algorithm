import java.util.*;

public class IntToRoman {

    public static TreeMap<Integer, String> mapIntWithRoman() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        return map;
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, String> map = mapIntWithRoman();
        ArrayList<Integer> mapInt = new ArrayList<>();
        for (int i : map.keySet()) {
            mapInt.add(i);
        }
        int size = mapInt.size();
        while (num != 0 && size > 0) {
            if (num - mapInt.get(size - 1) >= 0) {
                num = num - mapInt.get(size - 1);
                sb.append(map.get(mapInt.get(size - 1)));
            } else {
                size--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 27;
        String str = intToRoman(num);
        System.out.println(str);
    }
}
