import java.util.PriorityQueue;

public class PQusingJAVACollections {
    // I have to prioritize student based on their rank
    // To compare student class object, I have to use a special type of interface
    // here student class is using interface called comparable using implements keyword
    // we are comparing students
    // This comparable interface is inbuilt interface in java
    // There are no such classes to compare between them, so this interface gives a special power for that classes can compare their objects
    // Now student class can compare on the basis of rank and roll no. etc.
    // There is a function called compareTo() in this Comparable interface. The student child class can implement parent's (this interface) function
    // Whenever child class implement parent class's function this concept is called function overriding
    static class student implements  Comparable<student>{
        String name;
        int rank;

        student(String name, int rank){
            this.name=name;
            this.rank=rank;
        }

        @Override// to use function overriding I have to use this keyword
        public int compareTo(student s2){
            return this.rank-s2.rank;
        }// Now I have overrriden this compareTo function
        // That's how we compare Class's Object

        // The Logic behind this compareTo function:
        // it this.rank-s2.rank gives -ve number then object 1 is having less rank than object 2. So lesser value will come before the higher value
        // if it's +ve then object 1 is having higher rank than object 2. Then object 2 will come first.
        // If it's 0 then both object's rank are same. So no change.
        // as java has its inbuilt feature , so sorting based on rank will be done automatically with this logic (return +ve , -ve , 0 value)
    }

    public static void main(String[] args) {
        PriorityQueue<student> pq = new PriorityQueue<>();
        // Added student object into the PQ
        pq.add(new student("Manash",1));
        pq.add(new student("Rahul",8));
        pq.add(new student("Priya",5));
        pq.add(new student("Payel",6));
        pq.add(new student("Sneha",4));
        pq.add(new student("Sakshi",2));
        // printing object with their rank
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }
        /*
        Output:
        Manash->1
        Sakshi->2
        Sneha->4
        Priya->5
        Payel->6
        Rahul->8
         */
    }
}
