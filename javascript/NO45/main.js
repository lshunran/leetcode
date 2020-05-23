/**
 * @param {number[]} nums
 * @return {number}
 */
// var jump = function(nums) {
//     let steps = 0;
//     let pos = nums.length - 1;

//     while(pos > 0){
//         for(let i = 0; i < nums.length; i++){
//             if(nums[i] + i >= pos){
//                 pos = i;
//                 steps++;
//                 break;
//             }
//         }
//     }

//     return steps;
// };

var jump = function(nums) {
    let steps = 0;
    let end = 0;
    let maxPos = 0;

    for(let i = 0; i < nums.length - 1; i++){
        maxPos = Math.max(maxPos, nums[i] + i);
        

        if(i == end){
            end = maxPos;
            steps++;
        }
    }

    return steps;
};