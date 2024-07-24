public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] t = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    t[i][j] = 0;
                } else {
                    t[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(t[i][j - coins[i - 1]] + 1, t[i - 1][j]);

                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][amount] == Integer.MAX_VALUE - 1 ? -1 : t[n][amount];

    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int result = cc.coinChange(coins, amount);
        System.out.println("The minimum number of coins needed is: " + result);
    }
}
