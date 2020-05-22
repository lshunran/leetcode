/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    if(s.length < 2) return true;
    let reg = /^[A-Za-z0-9]*$/;
    let start = 0;
    let end = s.length - 1;
    s = s.toLocaleLowerCase();


    while(start < end){
        while(!reg.test(s.charAt(start))){
            start++;
        }
        while(!reg.test(s.charAt(end))){
            end--;
        }

        if(s.charAt(start) === s.charAt(end)){
            start++;
            end--;
        }else{
            return false;
        }
    }

    return true;
};

console.log(isPalindrome("race a car"))