/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if(s.length == 0) return 0;
    let start = 0;
    let len = 1;
    let sub = s.substr(start, len);
    let maxLen = 1;

    while(start < s.length ){
        if(sub.indexOf(s.charAt(start + len)) == -1){
            len++;
            maxLen = Math.max(maxLen, len);
        }else{
            start++;
            if(len > 1)len--;
        }
        sub = s.substr(start, len);
    }

    return maxLen;

};

console.log(lengthOfLongestSubstring('pwwkew'));