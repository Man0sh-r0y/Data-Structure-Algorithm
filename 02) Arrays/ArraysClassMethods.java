package _01_Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    protected int value;

    public Student(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Student(" + this.value + ")";
    }
}

public class ArraysClassMethods {
    public static List<String> arrayToList(String[] arr){
        List<String> list = Arrays.asList(arr);
        return list;
    }

    public static List<Integer> arrayToList(Integer[] arr){
        List<Integer> list = Arrays.asList(arr);
        return list;
    }

    public static boolean check1DArrayEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2); // check if two 1D arrays are equal
    }

    public static boolean check2DArrayEqual(int[][] arr1, int[][] arr2) {
        return Arrays.deepEquals(arr1, arr2); // check if two 2D arrays are equal
    }

    public static int binarySearch(int[] arr, int targetElement){
        Arrays.sort(arr); // sort the array
        int index = Arrays.binarySearch(arr, targetElement); // search the element
        return index;
    }

    public static int binarySearch(int[] arr, int startIndex, int endIndex, int targetElement){
        Arrays.sort(arr); // sort the array
        int index = Arrays.binarySearch(arr, startIndex, endIndex, targetElement); // search the element
        return index;
    }

    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length); // copy the array of same size
    }

    public static int[] copyArray(int[] arr, int newLength) {
        return Arrays.copyOf(arr, newLength); // copy the array of new length
    }

    public static int[] copyArrayInRange(int[] arr, int startIndex, int endIndex) {
        return Arrays.copyOfRange(arr, startIndex, endIndex); // copy will be made from startIndex to endIndex - 1
    }

    public static int[] fillArray(int[] arr, int value) {
        Arrays.fill(arr, value); // fill all the index of the array with this single value
        return arr;
    }

    public static int findUnmatchedElement(int[] arr1, int[] arr2) {
        return Arrays.mismatch(arr1, arr2); // Finds and returns the index of the first unmatched element between the two specified arrays.
    }

    public static String print1DArray(int[] arr) {
        return Arrays.toString(arr); // print the array
    }

    public static String print2DArray(int[][] arr) {
        return Arrays.deepToString(arr); // print the array
    }

    public static int[] setAllArrayElement(int[] arr) {
        Arrays.setAll(arr, i -> arr[i] * arr[i]); // Here, i=index of array, and array elements set to arr[i] = arr[i] * arr[i]
        return arr;
    }

    public static int[] sortArrayElement(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static int[] sortArrayElementInRange(int[] arr, int startIndex, int endIndex) {
        Arrays.sort(arr, startIndex, endIndex);
        return arr;
    }

    public static Student[] sortObjectArray(Student[] arr) {
        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.value - b.value;
            }
        });
        return arr;
    }

    public static Student[] sortObjectArrayInRange(Student[] arr, int startIndex, int endIndex) {
        Arrays.sort(arr, startIndex, endIndex, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.value - b.value;
            }
        });
        return arr;
    }

}
