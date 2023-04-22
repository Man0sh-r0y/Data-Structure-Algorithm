import java.util.LinkedHashMap;

public class _04_IntoToLinkedHashMap {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        // in which order we will put the hashmap element ,
        // prinitng will be done on that order
        lhm.put("India", 300);
        lhm.put("US", 200);
        lhm.put("Nepal", 100);
        lhm.put("Bhutan", 500);
        lhm.put("Chaina", 400);
        // All the function of hashmap is applicable here (With same time complexity)
        System.out.println(lhm);// {India=300, US=200, Nepal=100, Bhutan=500, Chaina=400}
    }
}
