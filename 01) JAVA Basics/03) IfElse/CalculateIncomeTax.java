public class CalculateIncomeTax {
    public static void main(String[] args) {
        // Income Tax
        int income = 250000;
        int tax;
        if (income < 500000) {
            tax = 0;
        } else if (income >= 500000 && income < 1000000) {
            tax = (int) (income * 0.2);
        } else {
            tax = (int) (income * 0.3);
        }

    }
}
