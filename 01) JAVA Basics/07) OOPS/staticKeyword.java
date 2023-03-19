public class staticKeyword {
    public static void main(String args[]) {
        Student s1 = new Student();
        s1.SchoolName = "JVM";

        Student s2 = new Student();
        System.out.println(s2.SchoolName);// JVM

        Student s3 = new Student();
        s3.SchoolName = "ABC";
        System.out.println(s2.SchoolName);// ABC
    }
}

class Student {
    String name;
    int roll;
    static String SchoolName;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
