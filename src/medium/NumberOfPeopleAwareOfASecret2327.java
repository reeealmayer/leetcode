package medium;

public class NumberOfPeopleAwareOfASecret2327 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1]; // dp[i] = сколько людей узнали секрет в день i
        dp[1] = 1; // первый человек знает секрет в день 1

        long sharing = 0; // сколько человек могут делиться на текущий день

        for (int day = 2; day <= n; day++) {
            // те, кто начинают делиться сегодня
            if (day - delay >= 1) {
                sharing = (sharing + dp[day - delay]) % MOD;
            }
            // те, кто забывают сегодня и уже не делятся
            if (day - forget >= 1) {
                sharing = (sharing - dp[day - forget] + MOD) % MOD;
            }
            // новые люди в этот день = все, кто делятся
            dp[day] = sharing;
        }

        // считаем, сколько людей знают секрет к дню n (ещё не забыли)
        long result = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) {
                result = (result + dp[day]) % MOD;
            }
        }
        return (int) result;
    }
}
