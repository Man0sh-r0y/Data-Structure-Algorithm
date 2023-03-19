public class TernaryOperator {
    public static void main(String[] args) {
        // Ternary Operator
        int number = 4;
        String type = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println(type);

        int marks = 67;
        String reportCard = (marks > 33) ? "Pass" : "Fail";
        System.out.println(reportCard);
    }
}
