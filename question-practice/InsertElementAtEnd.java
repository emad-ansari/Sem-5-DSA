import java.util.Arrays;

// Solve in O(1) time complexity
public class InsertElementAtEnd {
    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40, 50, 60};
        System.out.println("After appending element: " + Arrays.toString(insertAtEnd(arr, arr.length, 100)));

    }
    public static int[] insertAtEnd(int[] arr, int sizeOfArray, int element){
        arr[sizeOfArray - 1] = element;
        return arr;
    }

}
