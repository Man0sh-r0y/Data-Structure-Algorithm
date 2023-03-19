public class DecimalToBinary {

    public static int decimalToBinary(int DecimalNum) {
        int power = 0;
        int BinaryNum = 0;
        while (DecimalNum > 0) {
            int remainder = DecimalNum % 2;
            BinaryNum = BinaryNum + (remainder * (int) Math.pow(10, power));
            power++;
            DecimalNum /= 2;
        }
        return BinaryNum;
    }

    public static void main(String[] args) {
        // Decimal to Binary
        int DecimalNumber = 10;
        System.out.println("Decimal to Binary Conversation is " + decimalToBinary(DecimalNumber));
    }
}
