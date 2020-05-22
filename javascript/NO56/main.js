/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    if(intervals.length < 2) return intervals;
    let sortedIntervals = intervals.sort((a, b) => a[0] - b[0]);
    let result = [sortedIntervals[0]];
    let pos = 0;

    for(let i = 1; i < sortedIntervals.length; i++){
        if(sortedIntervals[i][0] <= result[pos][1]){
            // merged
            if(sortedIntervals[i][1] > result[pos][1]){
                result[pos][1] = sortedIntervals[i][1];
            }
        }else{
            result.push(sortedIntervals[i]);
            pos++;
        }
    }

    return result;
};