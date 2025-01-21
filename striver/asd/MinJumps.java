package striver.asd;

public class MinJumps {
    public static void main(String[] args){
        int[] arr = {9 ,10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println("Min Jumps: "+  minJumps(arr));
    }
    public static int minJumps(int[] arr) {
        // code here
        int minJumps = helper(arr, 0, 0);


        return minJumps == 0 ? -1 : minJumps;
    }

    public static int helper (int[] arr, int indx, int jumps) {
        if (indx > arr.length - 1) return jumps;

        int minJump = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[indx]; i++){
            minJump = Math.min(minJump, helper(arr, indx + i, jumps));
        }
        return minJump;
    }
}
