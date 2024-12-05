public class Primes {
    public static void main(String[] args) {
        // Replace this statement with your code
        if (args.length == 0) {
            System.out.println("Please provide an integer input.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        if (n < 2) {
            System.out.println("No primes available for numbers less than 2.");
            return;
        }

        boolean[] prime = sieveOfEratosthenes(n);

        System.out.println("Prime numbers up to " + n + ":");
        printPrimes(prime);

        int primeCount = countPrimes(prime);
        int percentage = (int) (((double) primeCount / n) * 100);
        System.out.println(
                "There are " + primeCount + " primes between 2 and " + n + " (" + percentage + "% are primes).");
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true; // Assume all numbers are prime initially
        }

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    prime[multiple] = false;
                }
            }
        }
        return prime;
    }

    public static void printPrimes(boolean[] prime) {
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                System.out.println(i);
            }
        }
    }

    public static int countPrimes(boolean[] prime) {
        int count = 0;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                count++;
            }
        }
        return count;
    }
}
