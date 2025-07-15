package not_sorted;

public class CountNumberOfArrays {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100_005;

    long[] fact = new long[MAX];
    long[] invFact = new long[MAX];

    public int countGoodArrays(int n, int m, int k) {
        precomputeFactorials(n); // вычисляем факториалы

        long C = comb(n - 1, k);
        long pow = modPow(m - 1, n - 1 - k);

        long ans = C * m % MOD * pow % MOD;

        return (int) ans;
    }

    void precomputeFactorials(int n) {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Программа завершает работу! Очистка ресурсов...");
            // Здесь твой код
        }));


    }
}
