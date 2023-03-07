public class shallow_deep_copy {
    public static void main(String args[]) {
        student s1 = new student();
        s1.name = "Manash";
        s1.roll = 89;
        s1.password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        student s2 = new student(s1);
        s2.password = "xyz";
        System.out.println(s1.password);
        System.out.println(s2.password);
        s1.marks[1] = 60;
        System.out.println(s2.marks[1]);
    }
}

class student {
    String name;
    int roll;
    String password;
    int marks[];

    class address {
        String city;
    }

    student() {
        marks = new int[3];
    }

    student(String name) {
        this.name = name;
    }

    // Shallow Copy Constructor
    student(student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        this.marks = s1.marks;
    }

    /*
     * // Deep Copy Constructor
     * student(student s1) {
     * marks = new int[3];
     * this.name = s1.name;
     * this.roll = s1.roll;
     * for (int i = 0; i < marks.length; i++) {
     * this.marks[i] = s1.marks[i];
     * }
     * }
     */
}
