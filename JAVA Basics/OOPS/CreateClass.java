public class CreateClass {
    public static void main(String args[]) {
        // Pen Object
        Pen p1 = new Pen();
        p1.setColour("Blue");
        System.out.println(p1.colour);

        p1.setColour("Yellow");
        System.out.println(p1.colour);

        // Student Object
        Student s = new Student();
        s.name = "Manash";
        s.age = 19;
        s.calcPercentage(95, 90, 98);
        System.out.println("My marks = " + s.percentage);

        // Bank Account Object
        BankAccount myAccount = new BankAccount();
        myAccount.UserName = "Manash";
        myAccount.setPassword("abcdef");
    }
}

class Pen {
    String colour;
    int Tip;

    void setColour(String newColour) {
        colour = newColour;
    }

    void setTip(int newTip) {
        Tip = newTip;
    }
}

class Student {
    String name;
    int age;
    float percentage;

    void calcPercentage(int phy, int chem, int math) {
        percentage = (phy + chem + math) / 3;
    }
}

class BankAccount {
    public String UserName;
    private String Password;

    void setPassword(String newPassword) {
        Password = newPassword;
    }
}