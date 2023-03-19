public class interfaces {
    public static void main(String args[]) {
        Queen q = new Queen();
        q.moves();

        Bear b1 = new Bear();
        b1.eatsmeat();
        b1.eatsplants();

    }
}

interface chessPlayer {
    void moves();
}

class Queen implements chessPlayer {
    public void moves() {
        System.out.println("Up down left right diagonal");
    }
}

class Rook implements chessPlayer {
    public void moves() {
        System.out.println("Up down left right");
    }
}

class King implements chessPlayer {
    public void moves() {
        System.out.println("Up down left right diagonal");
    }
}

// Multiple Inheritance
interface herbivore {
    void eatsplants();
}

interface carnivore {
    void eatsmeat();
}

class Bear implements herbivore, carnivore {

    public void eatsplants() {
        System.out.println("Eats plants");
    }

    public void eatsmeat() {
        System.out.println("Eats meat");
    }
}
