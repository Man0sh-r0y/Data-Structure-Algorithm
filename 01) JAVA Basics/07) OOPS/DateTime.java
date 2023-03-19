import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime; // import the LocalTime class
import java.time.LocalDateTime; // import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class. Formatter for displaying and parsing date-time objects

public class DateTime {
    public static void main(String[] args) {
        LocalDate currDate = LocalDate.now(); // Create a date object
        System.out.println(currDate); // Display the current date

        LocalTime currTime = LocalTime.now();
        System.out.println(currTime);

        LocalDateTime currDateTime = LocalDateTime.now();// date & time both will be shown
        System.out.println(currDateTime);

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("After formatting: " + currDateTime.format(formatDate));
        // The ofPattern() method accepts all sorts of values,
        // if you want to display the date and time in a different format.
    }
}
