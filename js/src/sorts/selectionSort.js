function SelectionSort() {}

// standard Selection Sort implementation
// selection sort has a worst-case (and best-case) time efficiency of O(n^2)
// making it inefficient for real-world use
SelectionSort.prototype = {
  sort: function(arr) {
    var input = arr.slice(0);

    for(var i = 0; i < input.length - 1; i++) {
      // to find the index of the lowest value in the arr
      var min = i;

      for(var j = i + 1; j < input.length; j++) {
          if(input[j] < input[min]) {
            min = j;
          }
      }

      util.swap(input, i, min);
    }

    return input;
  }
}
