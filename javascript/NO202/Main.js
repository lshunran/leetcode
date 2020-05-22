/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    if(n === 1) return true;

    let slow = getNext(n);
    let fast = getNext(slow);

    while(slow !== 1 && fast !== 1 && slow !== fast){
        slow = getNext(slow);
        fast = getNext(getNext(fast));
    }

    if(slow === 1 || fast === 1){
        return true;
    }

    return false;

};

var getNext = function(n){

    if(n === 0) return 0;

    let totalSum = 0;

    while(n > 0){
        let d = n % 10;
        totalSum += d * d;
        n = Math.floor(n / 10);
    }

    return totalSum;

}