public class MaxElement {
    public static void main(String[] args){
        int[] arr = {10, 20, 5, 6, 100, 70};
        System.out.println("Max element: " +  findMax(arr));
        System.out.println("Min element: " +  findMin(arr));

    }

    public static int findMax(int[] arr){
        int max = arr[0];
        for (int item :arr){
            if (item > max){
                max = item;
            }
        }
        return max;
    }

    public static int findMin(int[] arr){
        int min = arr[0];
        for (int item :arr){
            if (item < min){
                min = item;
            }
        }
        return min;
    }
}
