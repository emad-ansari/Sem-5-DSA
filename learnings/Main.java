package learnings;

public class Main {
    public static void main(String[] args) {
        int n = 20;
        // can you find the prime factors of n??
        // for (int i = 2; i * i <= n ;i++) {
        //     while (n % i == 0) {
        //         System.out.print(i + " ");
        //         n /= i;
        //     }
        // }
        // if (n != 1) System.out.println(n);
        printNPrimeNumbers(n);
    }

    // seive 
    public static void printNPrimeNumbers(int n) {
        boolean[] primes  = new boolean[n + 1];
        // precompute  
        for (int p = 0; p <= n; p++) primes[p] = true;

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int p = i * i; p <= n; p += i) primes[p] = false;
            }
        }

        // now print all primes
        for (int i = 2; i <=n ; i++) {
            if (primes[i]) System.out.print(i + " ");
        }
    }
}
