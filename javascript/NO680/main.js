/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function (s) {
  if (s.length < 2) return true;
  let reg = /^[A-Za-z0-9]*$/;
  let start = 0;
  let end = s.length - 1;
  s = s.toLocaleLowerCase();

  let bail = [...arguments][1];

  while (start < end) {
    while (!reg.test(s.charAt(start))) {
      start++;
    }
    while (!reg.test(s.charAt(end))) {
      end--;
    }

    if (s.charAt(start) === s.charAt(end)) {
      start++;
      end--;
    } else {
      if (!bail) {
        return (
          validPalindrome(s.substring(start + 1, end + 1), true) ||
          validPalindrome(s.substring(start, end), true)
        );
      } else {
        return false;
      }
    }
  }

  return true;
};

console.log(validPalindrome("ab"))