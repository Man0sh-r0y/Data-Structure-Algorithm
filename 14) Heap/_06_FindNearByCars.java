import java.util.PriorityQueue;

public class _06_FindNearByCars {

    static class Point implements Comparable<Point> {// To comapre class object while storing in PQ
        int x;// x axis coordinate
        int y;// y axis coordinate
        int distSq;// Distance Square Root
        int indx; // index of the Point

        Point(int x, int y, int indx) {
            this.x = x;
            this.y = y;
            this.indx = indx;
            this.distSq = (int) Math.pow(x * x + y * y, 0.5);
        }

        @Override
        public int compareTo(Point p) {
            return this.distSq - p.distSq;// as we are sorting objects based on their distance square root
        }
    }

    public static void main(String[] args) {
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2; // I have to find nearby k cars

        PriorityQueue<Point> pq = new PriorityQueue<>();
        // inserting in PQ
        for (int i = 0; i < points.length; i++) {
            pq.add(new Point(points[i][0], points[i][1], i));
        }

        // printing nearby k cars
        for (int i = 0; i < k; i++) {
            System.out.println("Car " + pq.remove().indx);
        }
    }
}
