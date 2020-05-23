/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function (text1, text2) {
  let m = text1.length;
  let n = text2.length;

  if (m === 0 || n === 0) return 0;

  let dp = new Array(m);
  let firstLetterInText2 = text2.indexOf(text1.charAt(0));
  let firstLetterInText1 = text1.indexOf(text2.charAt(0));

  for (let i = 0; i < m; i++) {
    dp[i] = new Array(n);
    if (firstLetterInText1 > -1 && i >= firstLetterInText1) {
      dp[i][0] = 1;
    } else {
      dp[i][0] = 0;
    }
  }

  dp[0].fill(0, 1);
  if (firstLetterInText2 > -1) {
    dp[0].fill(1, firstLetterInText2);
  }

  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      if (text1.charAt(i) !== text2.charAt(j)) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      } else {
        dp[i][j] = dp[i - 1][j - 1] + 1;
      }
    }
  }

  return dp[m - 1][n - 1];
};

longestCommonSubsequence("abcde", "ace");
