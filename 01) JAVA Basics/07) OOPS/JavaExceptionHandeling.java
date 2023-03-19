// When executing Java code, different errors can occur: coding errors made by the programmer, errors due to wrong input, or other unforeseeable things.
public class JavaExceptionHandeling {

    static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }

    public static void main(String[] args) {
        // The try statement allows you to define a block of code to be tested for
        // errors while it is being executed.

        // The catch statement allows you to define a block of code to be executed, if
        // an error occurs in the try block

        // Syntax
        // try {
        // // Block of code to try
        // } catch (Exception e) {
        // // Block of code to handle errors
        // }

        try {
            int[] myNumbers = { 1, 2, 3 };
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        // If an error occurs, we can use try...catch to catch the error
        // and execute some code to handle it

        // The finally statement lets you execute code,
        // after try...catch, regardless of the result
        try {
            int[] myNumbers = { 1, 2, 3 };
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("The 'try catch' is finished.");
        }

        // The throw statement is used together with an exception type. There are many
        // exception types available in Java: ArithmeticException,
        // FileNotFoundException, ArrayIndexOutOfBoundsException, SecurityException, etc
        checkAge(20);
        checkAge(17);

    }
}