/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function (coins, amount) {
  //counts[amount] = counts[findMaxChange(coins, amount)] + 1;
  // if(amount == 0) return 0;
  // if(amount < 0) return -1;

  // return _coinChange(coins, amount, {});

  //------------------------------------------------
  let dp = [];
  dp[0] = 0;
  for (let i = 0; i <= amount; i++) {
    for (let j = 0; j < coins.length; j++) {
      pos = i + coins[j];
      if (!dp[pos]) {
        if (dp[i] != undefined) {
          dp[pos] = dp[i] + 1;
        }
      } else {
        dp[pos] = Math.min(dp[pos], dp[i] + 1);
      }
    }
  }
  return dp[amount] == undefined ? -1 : dp[amount];
};
coinChange([186,419,83,408],6249);
