public class abstraction {
    public static void main(String args[]) {
        Horse h = new Horse();
        h.walk();
        System.out.println(h.color);
        h.changeColor();
        System.out.println(h.color);

        Chicken c = new Chicken();
        c.walk();

        Mustang M1 = new Mustang();

    }
}

abstract class Animal {
    String color;

    Animal() {
        color = "Brown";
        System.out.println("Animal constractor called");
    }

    void eat() {
        System.out.println("Animal Eats");
    }

    abstract void walk();
}

class Horse extends Animal {

    Horse() {
        System.out.println("Horse constractor called");
    }

    void changeColor() {
        color = "Dark-Brown";
    }

    void walk() {
        System.out.println("Wlaks in 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constractor called");
    }
}

class Chicken extends Animal {
    void walk() {
        System.out.println("Wlaks in 2 legs");
    }
}
