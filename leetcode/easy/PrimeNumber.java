package leetcode.easy;


// All prime number can be represented in form 6n + 1 or 6n - 1 but the number which can be represented in these two form is not necessarily a prime number.

// false solution
public class PrimeNumber {
    public static void main(String[] args){
        System.out.println("isPrime: " + isPrime(10));
        int[] arr = {11, 17, 19, 23, 97, 100, 200, 1001, 121, 143, 1000003, 2147483647};
        for (int item: arr){
            boolean ans = isPrime(item);
            if (ans) {
                System.out.println(item + " is prime number");
            }
            else {
                System.out.println(item + " is not prime number");
            }
        }

    }
    public static boolean isPrime(int num){
        if (num <= 1 ) return false;
        if (num == 2 || num == 3) return true;
        int rem1 = (num + 1 ) % 6;
        int rem2 = (num - 1) % 6;
        return rem1 == 0 || rem2 == 0;
    }
}

// How to find the all factor of number
