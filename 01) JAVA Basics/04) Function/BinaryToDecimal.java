public class BinaryToDecimal {

    public static int binaryToDecimal(int BinaryNum) {
        int power = 0;
        int DecimalNumber = 0;
        while (BinaryNum > 0) {
            int lastDigit = BinaryNum % 10;
            DecimalNumber = DecimalNumber + (lastDigit * (int) Math.pow(2, power));
            power++;
            BinaryNum /= 10;
        }
        return DecimalNumber;
    }

    public static void main(String[] args) {
        // Binary to Decimal
        int BinaryNumber = 1010;
        System.out.println("Binary to Decimal Conversation is " + binaryToDecimal(BinaryNumber));
    }
}
