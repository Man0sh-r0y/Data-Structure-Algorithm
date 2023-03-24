import java.util.TreeSet;

public class _11_IntroToTreeSet {
    public static void main(String[] args) {
        TreeSet<String> cities = new TreeSet<>();
        cities.add("Kolkata");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bengaluru");
        cities.add("Noida");
        cities.add("Chennai");
        // TreeSet internally implemented using TreeMap
        // So datas will be stored according to sorted order
        System.out.println(cities);
    }
}
