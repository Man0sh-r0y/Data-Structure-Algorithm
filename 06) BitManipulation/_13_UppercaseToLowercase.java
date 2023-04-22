public class _13_UppercaseToLowercase {

    public static void uppercaseToLowercase() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' ') + " ");
        }
    }

    public static void main(String[] args) {
        uppercaseToLowercase();
    }
}
