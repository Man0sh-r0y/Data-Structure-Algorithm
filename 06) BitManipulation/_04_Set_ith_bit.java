public class _04_Set_ith_bit {
    public static int setIthBit(int n, int i) {
        return n | (1 << i);
    }

    public static void main(String[] args) {
        int n = 10;
        int i = 2;
        System.out.println(setIthBit(n, i));
    }
}
