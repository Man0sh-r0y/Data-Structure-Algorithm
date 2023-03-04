public class Change_ith_bit {

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
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

    public static void main(String[] args) {
        System.out.println(clearIthBit(15, 3));
        System.out.println(UpdateIthBit(15, 1, 0));
        System.out.println(updateIthBit(15, 1, 0));
    }
}
