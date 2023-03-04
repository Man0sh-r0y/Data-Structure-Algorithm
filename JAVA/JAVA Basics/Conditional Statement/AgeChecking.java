public class AgeChecking {
    public static void main(String[] args) {
        // Age Checking
        int age = 20;
        if (age >= 18) {
            System.out.println("Adult");
        } else if (age > 13 && age < 18) {
            System.out.println("Teeneger");
        } else {
            System.out.println("Not Adult");

        }
    }
}
