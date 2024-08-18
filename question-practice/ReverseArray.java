import java.util.Arrays;



public class ReverseArray<T> {

    public static int[]  reverseArray(int[] arr) {
        int start = 0;
        int end  = arr.length - 1;
        while (start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }


    // Design a generic method which reverse any type of element array;
    public static <T>T[] reverse(T[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            T temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
    public static void main(String[] args){
        Integer[] arr = {10, 20, 5, 6, 100, 70};
        System.out.println(Arrays.toString(reverse(arr)));
        String[] stringArray = {"emd", "ars", "reh", "far"};
        System.out.println(Arrays.toString(reverse(stringArray)));

    }
}
