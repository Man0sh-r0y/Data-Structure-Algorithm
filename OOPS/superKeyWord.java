public class superKeyWord {
    public static void main(String args[]) {
        Horse h1 = new Horse();
        System.out.println(h1.color);
    }
}

class Animal {
    String color;

    Animal() {
        System.out.println("Animal Constractor is called");
    }
}

class Horse extends Animal {
    Horse() {
        super();
        super.color = "Brown";
        System.out.println("Horse Constrator is called");
    }
}
