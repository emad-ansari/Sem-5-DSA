package subarray;

/*
 * Subarray: if number of element in an array = n
 * then total possible subarray = n * (n + 1) / 2
 */
public class PrintAllSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        printallSubarray(nums);
    }
    public static void printallSubarray(int[] nums ) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int  k = i;
                System.out.print("[");
                while (k <= j) {
                    if (k == j) {
                        System.out.println(nums[k++] + "]");
                    }
                    else System.out.print(nums[k++] +  ", ");
                }
            }
        }
    }
    
}
