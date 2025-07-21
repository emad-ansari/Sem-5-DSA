package math;

public class PrimeNumber {
    public static void main(String[] args) {
        
    }
    // Time Complexity: O(sqrt(n))
    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    /*
     * Sieve of Eratosthenes: Print/Store all primes numbers upto n
     * 
     * Time Complexity: O(n * log(log(n)))
     * 
     */

    public static void sieve(int n) {
        if (n <= 1) return;

        boolean[] primes = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                for (int p = i * i; p <= n; p += i) {
                    primes[p] = false;
                }
            }
        }

        // print all primes numbers upto n
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
    
}
