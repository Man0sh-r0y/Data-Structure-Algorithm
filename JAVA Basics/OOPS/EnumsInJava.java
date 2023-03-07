public class EnumsInJava {
    // An enum is a special "class" that represents a group of constants
    // (unchangeable variables, like final variables).
    public enum Seasons {
        WINTER,
        SPRING,
        SUMMER,
        FALL
    }

    public static void main(String[] args) {
        // Trversing The enum
        for (Seasons s : Seasons.values()) {
            System.out.println(s);
        }
        // The enum type has a values() method,
        // which returns an array of all enum constants.
        System.out.println("Value of WINTER is : " + Seasons.valueOf("WINTER"));
        // The valueOf() method returns the value of given constant enum.
        System.out.println("Index of WINTER is: " + Seasons.valueOf("WINTER").ordinal());// 0
        System.out.println("Index of SUMMER is: " + Seasons.valueOf("SUMMER").ordinal());// 2
        // The ordinal() method returns the index of the enum value.
    }
}
