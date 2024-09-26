package leetcode.easy;

public class FindOccurrenceInSortedArray {
    public static void main(String[] args){
        int[] arr = { 18, 28, 28, 38, 48};
        System.out.println("Occurrence is: " + findOccurrence(arr, 28));
    }
    public static  int findOccurrence(int[] arr, int num){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            boolean numberEncountered = false;
            if (arr[i] == num){
                numberEncountered = true;
                int j  = i;
                while (j < arr.length && arr[j] == num){
                    count++;
                    j++;
                }
            }
            if (numberEncountered) break;
        }
        return count;
    }
}
