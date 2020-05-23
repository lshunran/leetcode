/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if(prices.length < 2) return 0;
    let profit = 0;
    let minPrice = Number.MAX_VALUE;

    for(let i = 0; i < prices.length; i++){
        if(prices[i] < minPrice){
            minPrice = prices[i];
        }else{
            profit = Math.max(profit,  prices[i] - minPrice);
        }
    }

    return profit;
};