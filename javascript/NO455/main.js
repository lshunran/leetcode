/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    if(g.length === 0 || s.length === 0) return 0;
    let _g = [...g];
    let _s = [...s];

    _g.sort((a, b) => a - b);
    _s.sort((a, b) => a - b);

    let gi = 0, si = 0, count = 0;

    while(gi < _g.length && si < _s.length){
        if(_s[si] >= _g[gi]){
            count++;
            si++;
            gi++
        }else{
            si++;
        }
    }

    return count;

};