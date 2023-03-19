public class TypeCasting {

    public static void main(String args[]) {
        // Implicit type conversation
        char ch = 'a';
        char ch2 = 'b';
        int number = ch;
        int number2 = ch2;
        System.out.println(number);// 97
        System.out.println(number2);// 98

        // Explicit Type Conversation
        float marks = 99.99f;
        int marks2 = (int) marks;
        System.out.println(marks2);// 99

        char a = 'a';
        char b = 'b';
        System.out.println((int) a); // 97
        System.out.println((int) b); // 98
        System.out.println(a); // a
        System.out.println(b - a); // 1

        // Type Promotion in Expressions
        short p = 5;
        byte q = 25;
        char c = 'c';
        byte bt = (byte) (a + b + c);// int to byte conversation
        System.out.println(bt); // 38

        int x = 10;
        float y = 10.56F;
        long z = 25;
        double w = 30;
        double ans = x + y + z + w;
        // all variables are converted into double.
        // then this double value is assingned in ans variable

        System.out.println(ans); // 75.56000137329102

        byte by = 5;
        byte by1 = (byte) (by * 2);
        System.out.println(by1); // 10

    }

}
