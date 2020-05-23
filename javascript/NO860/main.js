/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    let five = 0, ten = 0;

    for(let i in bills){
        if(bills[i] === 5){
            five++;
        }
        if(bills[i] === 10){
            if(five > 0) {
                ten++;
                five--;
                continue;
            }else{
                return false;
            }
        }
        if(bills[i] === 20){
            if(ten > 0 && five >0){
                ten--;
                five--;
                continue;
            }else if(five >= 3){
                five -= 3;
                continue;
            }else{
                return false;
            }
        }
    }
    return true;
};