function MergeSort() {}

// we only want to expose the main sort's functionality
// so we can do this to encapsulate the merge() helper
MergeSort.prototype = {
  sort: (function() {
    function mergeSort(arr) {
      var input = arr.slice(0);

      if(input.length === 1) {
        return input;
      }

      var midpoint = Math.floor(input.length / 2);

      // merge the sorted subarrays of the first and second halves of this input
      return merge(this.sort(input.slice(0, midpoint)), this.sort(input.slice(midpoint)));
    }

    // merge two arrays together to form a single sorted array
    // the input arrays are assumed to be sorted already
    function merge(a, b) {
      var i = 0;
      var j = 0;

      var output = [];

      while(i < a.length || j < b.length) {
        if(i === a.length) {
          // if there's nothing left to merge from a, merge the rest of b
          output.concat(b.slice(j));
          break;
        } else if (j === b.length) {
          // if there's nothing left to merge from b, merge the rest of a
          output.concat(a.slice(i));
          break;
        } else if(a[i] < b[j]) {
          // if both arrays have values left and a's is lower, add that
          output.push(a[i]);
          i++;
        } else {
          // otherwise add the next value from b
          output.push(b[j]);
          j++;
        }
      }

      return output;
    }

    return mergeSort;
  }.call(this))
}
