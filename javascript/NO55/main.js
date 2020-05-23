/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    let end = nums.length - 1;

    for(let i = nums.length - 1; i >= 0; i--){
        if(nums[i] + i >= end){
            end = i;
        }
    }
    if(end == 0){
        return true;
    }
    return false;
};