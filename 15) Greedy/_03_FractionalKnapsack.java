import java.util.Arrays;
import java.util.Comparator;

public class _03_FractionalKnapsack {
    // Knapsack => bag
    // Question: Given the weights and profits of N items, in the form of {profit,
    // weight} put these items in a knapsack of capacity W to get the maximum total
    // profit in the knapsack. In Fractional Knapsack, we can break items for
    // maximizing the total value of the knapsack.

    // Approach:

    /*
     * (i) I've been given the weights and values in the array form of some items.
     * The weights and values of those items are in this array.
     * 
     * (ii) I have been given a knapsack with a capacity. I have to fill the
     * knapsack with these items.
     * 
     * (iii) I have to fill the knapsack in this way that I put more items and that
     * will give the maximum value (Profit)
     * 
     * (iv) To get the maximum value into the knapsack, I have to follow one way
     * 
     * (v) Atfirst I'll create Item class which can create objects with give values
     * and weights. I'll calculate the value per unit weight (value / weight) of
     * each item. For that I can have those items which has more value.
     * 
     * (vi) So at first I'll make Item objects with the given values and weights
     * 
     * (vii) Then I will make an Array which can store these Item Objects.
     * 
     * (viii) Now I'll sort the Array based on the value per unit weight of each
     * Item Object (Using Comparater). Sorting will be done in decending order as we
     * want maximum value per unit weight first.
     * 
     * (ix) Now I'll run a loop which will traverse over each item object stored in
     * the array. Array is sorted in decending order.
     * 
     * (x) I'll take a variable named 'totalProfit'. I'll traverse over each oject
     * in the Array. I'll calculate the weight of the object and will decrement it
     * from the knapsack capacity. Then I'll calculate the value of the object and
     * will add it into totalProfit variable untill unless the knapsack is getting
     * filled.
     * 
     * (xi) At a certain point if there are some available space in the knapsack but
     * the weight of the object is greater that the available space then I have to
     * take a little part of the object (Fractional weight)
     * 
     * (xii) So I will take the {(Available Capacity) / (Object Weight)}th part of
     * the object and will put it into the knapsack. Then capacity will be
     * deducted by this fractional amount. (capacity - this fraction)
     * The profit taken = object value * {(Available Capacity) / (Object Weight)}
     * 
     * (xiii) Now loop will be terminated as there are so such space available to
     * fill more items and this totalProfit will be our answer.
     * 
     */

    // Creating Item class which can create objects with given values and weights
    static class Items {// Item object is being created
        double weight, value;

        Items(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static double fractionalKnapsack(int[] weight, int[] value, int capacity) {
        Items[] items = new Items[weight.length];// I made an array named 'items' which can store Items types object
        // Step 1: Filling array with Item objects
        for (int i = 0; i < items.length; i++) {
            items[i] = new Items(weight[i], value[i]);// Item types object are stored
        }
        // Step 2: Sorting the Array in decending order based on their value per unit
        // weight (value / weight)
        Arrays.sort(items, new Comparator<Items>() {
            @Override
            public int compare(Items item1, Items item2) {
                Double ratio1 = Double.valueOf((double) item1.value / (double) item1.weight);
                Double ratio2 = Double.valueOf((double) item2.value / (double) item2.weight);
                // the (value/weight) ratio will be stored in this 'ratio' variable.
                // 'ratio1' is for the Item1 object
                // 'ratio2' is for the Item2 object
                // This ratio can be called as 'cost' of the Item
                return ratio2.compareTo(ratio1);// sort in decending order
                // We took ratio1 and ratio2 as Double object because compare() function can't
                // be applied on primitive data types. It can compare the object.
            }
        });

        double totalProfit = 0d;// as it's a double value so 0d is written
        // Step 3: Traverse over Array element and put the Item object into knapsack
        for (Items myItem : items) {
            int currWeight = (int) myItem.weight;// weight of the current object
            int currValue = (int) myItem.value;// value of the current object

            if (capacity - currWeight >= 0) {// Unitill the knapsack is getting filled
                capacity = capacity - currWeight;// Items are put into the knapsack and that much amount weight is
                // deducted from knapsack
                totalProfit += currValue;// The Item which has been put into the knapsack, the value of that Item is
                // added into this variable
            } else {// If some space available in knapsack but the whole object can't be put into
                // the knapsack. Only Fractional part of the object can only be taken
                double fraction = (double) capacity / (double) currWeight;// Fractional part of the taken object
                totalProfit += (currValue * fraction);// added the value of the fractional part of the object
                capacity = (int) (capacity - currValue * fraction);// that much fractional amount is deducted
                break;// loop is terminated as No space is available to fill knapsack
            }
        }
        return totalProfit;// Knapsack is filled with those items which can give the maximum Profit
    }

    public static void main(String[] args) {
        int[] value = { 60, 100, 120 };// value of the item
        int[] weight = { 10, 20, 30 };// weigth of the item
        int capacity = 50;// maximum capacity in knapsack (bag)
        // By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg.
        // knapsack space taken = 10 + 20 + (2/3)*30 = 50
        // Hence total price will be 60 + 100 + (2/3)*(120) = 240
        System.out.println(fractionalKnapsack(weight, value, capacity));
    }
}
