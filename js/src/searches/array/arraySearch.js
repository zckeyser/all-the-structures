function ArraySearch() { }

ArraySearch.prototype = (function() {
  // simple linear search
  // O(n) efficiency
  function linear(arr, target) {
    for(var i = 0; i < arr.length; i++) {
      if(arr[i] === target) {
        return true;
      }
    }

    return false;
  }

  function binary(arr, target) {
    if(arr.length === 1) {
      return arr[0] === target;
    }

    var index = Math.floor((arr.length - 1) / 2);

    if(arr[index] === target) {
      return true;
    } else if (arr[index] > target) {
      // if we're currently too high, check the left half
      return binary(arr.slice(0, index), target);
    } else {
      // if we're currently too low, check the right half
      return binary(arr.slice(index + 1), target);
    }
  }

  return {
    linear: linear,
    binary: binary
  }
}.call(this))
