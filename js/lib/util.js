// utilities specific to the project which are going to be reused
var util = (function() {
  // array utilities

  // returns an array of length len filled with random numbers
  // for consistency we're going to make this return the same array
  // every time it's called with the same length in a run
  var randCache = {}
  function randomArray(len) {
    // if we weren't given a length, use default
    len = len || globalConfig.DEFAULT_ARRAY_LENGTH;

    // if we haven't made an array of this length yet, do it now
    randCache[len] = randCache[len] || randomArrayHelper(len);

    // slice causes a copy to be returned
    // avoiding it being passed by reference
    return randCache[len].slice(0);
  }

  function isSorted(arr) {
    for(var i = 0; i < arr.length - 1; i++) {
      if(arr[i] > arr[i + 1]) {
        return false;
      }
    }

    return true;
  }

  function swap(arr, a, b) {
    var temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  // put this here to make the caching code more readable
  function randomArrayHelper(len) {
    var arr = [];

    // add len random #'s to arr
    for(var i = 0; i < len; i++) {
      arr.push(getRandomInt(-1000000, 1000000));
    }

    return arr;
  }

  // gets a random integer between min (inclusive) and max (exclusive)
  // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/random
  function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
  }

  // the actual exposed utils
  return {
    randomArray: randomArray,
    isSorted: isSorted,
    swap: swap,
    getRandomInt: getRandomInt
  };
}.call(this));
