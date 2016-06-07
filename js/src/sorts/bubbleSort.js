function BubbleSort() { }

// standard BubbleSort implementation
// has O(n^2) time complexity
// while very simple, is also never useful in the real world
// due to its extreme inefficiency
BubbleSort.prototype = {
  sort: function(arr) {
    // until we're done sorting
    while(!util.isSorted(arr)) {
      // check each index value to see if it's greater than index + 1 value
      // if it is, swap them. Repeat until sorted
      for(var i = 0; i < arr.length - 1; i++) {
        if(arr[i] > arr[i + 1]) {
          util.swap(arr, i, i + 1);
        }
      }
    }
  }
}
