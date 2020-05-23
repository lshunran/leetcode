/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
// var uniquePaths = function(m, n) {
//     let dp = new Array(m);

//     for(let i = 0; i < m; i++){
//         dp[i] = new Array(n);
//     }

//     dp[m - 1].fill(1, 0);

//     for(let i = m - 2; i >= 0; i--){
//         dp[i][n - 1] = 1;
//         for(let j = n - 2; j >= 0; j--){
//             dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
//         }
//     }

//     return dp[0][0];

// };


var uniquePaths = function(m, n) {
    let dp = new Array(n);

    dp.fill(1, 0);

    for(let i = m - 2; i >= 0; i--){
        for(let j = n - 2; j >= 0; j--){
            dp[j] = dp[j + 1] + dp[j];
        }
    }

    return dp[0];

};

uniquePaths(3, 2);