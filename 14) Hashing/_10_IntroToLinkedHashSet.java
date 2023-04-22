import java.util.LinkedHashSet;

public class _10_IntroToLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("Kolkata");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bengaluru");
        cities.add("Noida");
        cities.add("Chennai");
        // in which order we stored the data ,
        // in that same order printing will be done
        // that is the difference between HashSet and LinkedHashSet
        System.out.println(cities);
    }
}
