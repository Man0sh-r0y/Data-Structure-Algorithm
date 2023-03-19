import java.util.PriorityQueue;

public class WeakestSoldier {

    static class Row implements Comparable<Row> {
        int countSoldier;// in every row how many soldier are there
        int indx;// index of the every row

        Row(int soldier, int indx) {
            this.countSoldier = soldier;
            this.indx = indx;
        }

        // Now comapring based on solider number of each row
        // if soldier are same in 2 rows then compare will be done based on their indx
        // more number of soldier=> strong soldier
        // same soldier but leser index => weakest soldier
        @Override
        public int compareTo(Row r) {
            if (this.countSoldier == r.countSoldier) {
                return this.indx - r.indx;
            } else {
                return this.countSoldier - r.countSoldier;
            }
        }
    }

    public static void findWeakSoldier(int army[][], int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        // storing in PQ
        for (int i = 0; i < army.length; i++) {
            int countSoldier = 0;
            for (int j = 0; j < army[i].length; j++) {
                countSoldier += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(countSoldier, i));
        }

        // printing k weakest soldiers
        for (int i = 0; i < k; i++) {
            System.out.println("Index of weakest soldier Row -> " + pq.remove().indx + " ");
        }
    }

    public static void main(String[] args) {
        int army[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };
        int k = 2; // I have to find k weakest soldiers
        findWeakSoldier(army, k);
    }
}
