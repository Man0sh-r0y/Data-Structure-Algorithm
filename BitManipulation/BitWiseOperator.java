public class BitWiseOperator {

    public static void OddEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("Even Number.");
        } else {
            System.out.println("Odd Number.");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int UpdateIthBit(int n, int i, int newBit) {
        if (newBit == 0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // This is Different way from previous method
        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearIBits(int n, int i) {
        int bitMask = (~0) << i;
        return n & bitMask;
    }

    public static int clearIBitsinRange(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                // Check for LSB
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String args[]) {
        // AND Operator
        System.out.println(5 & 6);
        // OR Operator
        System.out.println(5 | 6);
        // XOR Operator
        System.out.println(5 ^ 6);
        // NOT Operator
        System.out.println(~5);
        // Binary Left Shift
        System.out.println(5 << 2);
        // Binary Right Shift
        System.out.println(6 >> 1);

        OddEven(16);
        System.out.println(getIthBit(15, 3));
        System.out.println(clearIthBit(15, 3));
        System.out.println(UpdateIthBit(15, 1, 0));
        System.out.println(updateIthBit(15, 1, 0));
        System.out.println(clearIBits(16, 5));
        System.out.println(clearIBitsinRange(10, 2, 4));
        System.out.println(countSetBits(15));
        System.out.println(fastExpo(3, 5));
    }
}