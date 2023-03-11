public class FirstOccurence {

    public static int findFirstIndx(String str, String val) {
        if (str.length() == 0) {
            return -1;
        }
        if (str.startsWith(val)) {
            return 0;
        }
        int indx = findFirstIndx(str.substring(1), val);
        if (indx == -1) {
            return -1;
        }
        return indx + 1;
    }

    public static void main(String[] args) {
        String str = "hello";
        String val = "ll";
        int indx = findFirstIndx(str, val);
        System.out.println(indx);
    }
}
