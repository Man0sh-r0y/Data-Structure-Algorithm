import java.util.*;

public class _10_FractionalKnapsack {

    static class Item {
        int value, weight;

        public Item(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }

    public static double fractionalKnapsack(int capacity, Item arr[], int arrayLength) {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double valuePerWeight1 = (double) item1.value / (double) item1.weight;
                double valuePerWeight2 = (double) item2.value / (double) item2.weight;
                // sorting in decreasing order based on value per weight (value/weight)
                if(valuePerWeight1 > valuePerWeight2) return 1;
                else if(valuePerWeight1 < valuePerWeight2) return -1;
                else return 0;
            }
        });

        double maxVal = 0; // storing the maximum value of the knapsack

        for(int i=0; i<arrayLength; i++) {
            if(arr[i].weight <= capacity) {
                capacity -= arr[i].weight;
                maxVal += arr[i].value;
            } else {
                maxVal += ((double)arr[i].value / (double)arr[i].weight)) * capacity; // fractional value
                break;
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Item[] arr = new Item[]{new Item(60,10), new Item(100,20), new Item(120,30)};
        System.out.println(fractionalKnapsack(50, arr, arr.length));
    }
}
