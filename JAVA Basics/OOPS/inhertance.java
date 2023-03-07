public class inhertance {
    public static void main(String args[]) {
        fish shark = new fish();
        shark.eat();

        dogs dobby = new dogs();
        dobby.legs = 4;
    }
}

// Base Class
class Animal {
    String color;

    void eat() {
        System.out.println("Eats");
    }

    void breathe() {
        System.out.println("breathes");
    }
}

// Derived Class
class fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swims in Water");
    }
}

class Mammel extends Animal {
    int legs;

    void swim() {
        System.out.println("Walks");
    }
}

class dogs extends Mammel {
    String breed;
}

class Birds extends Animal {
    void fly() {
        System.out.println("fly");
    }
}
