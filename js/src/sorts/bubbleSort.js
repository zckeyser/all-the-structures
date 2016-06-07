function BubbleSort() {}

// standard BubbleSort implementation
// has O(n^2) time complexity
// while very simple, is also never useful in the real world
// due to its extreme inefficiency
BubbleSort.prototype = {
  sort: function(arr) {
    var input = arr.slice(0);

    // until we're done sorting
    while(!util.isSorted(input)) {
      // check each index value to see if it's greater than index + 1 value
      // if it is, swap them. Repeat until sorted
      for(var i = 0; i < input.length - 1; i++) {
        if(input[i] > input[i + 1]) {
          util.swap(input, i, i + 1);
        }
      }
    }

    return input;
  }
}
