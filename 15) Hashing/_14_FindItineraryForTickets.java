import java.util.HashMap;

public class _14_FindItineraryForTickets {

    public static String getStartPoint(HashMap<String, String> tickets) {
        HashMap<String, String> reverseMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            reverseMap.put(tickets.get(key), key);
            // reversely stored tickets
        }

        for (String key : tickets.keySet()) {
            if (!reverseMap.containsKey(key))
                return key;
        }

        return null;// this situation will never come
    }

    public static void itineraryForTickets(HashMap<String, String> tickets) {
        String startPoint = getStartPoint(tickets);
        System.out.print(startPoint);
        for (int i = 0; i < tickets.size(); i++) {
            System.out.print(" -> " + tickets.get(startPoint));
            startPoint = tickets.get(startPoint);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        itineraryForTickets(tickets);
    }
}
