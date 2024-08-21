package leetcode.easy;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/ [SOLVED]

public class FindNumberWithEvenDigits {
    public static void main(String[] args){
        int[] arr = {12,345,2,6,7896};
        System.out.println("Number with even number of digits: " + findNumbers(arr));

    }
    public static int findNumbers(int[] nums) {
        int countEvenDigitNumber = 0;
        for (int num : nums){
            if(isEvenDigit(num)){
                countEvenDigitNumber += 1;
            }
        }

        return countEvenDigitNumber;
    }
    public static boolean isEvenDigit(int num){
        return (int)(Math.log10(num) + 1) % 2 == 0;
    }
}
