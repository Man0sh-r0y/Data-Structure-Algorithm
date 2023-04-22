public class _11_Swap2Numbers {
    public static void main(String[] args) {
        int x = 2;
        int y = 4;
        // Printing Before Swap
        System.out.println("Before swapping x = " + x + ", y = " + y);
        // Swapping using XOR
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        // Prinitng after Swap
        System.out.println("After swapping x = " + x + ", y = " + y);
    }
}
