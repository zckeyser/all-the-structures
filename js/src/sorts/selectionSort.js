function SelectionSort() {}

SelectionSort.prototype = {
  sort: function(arr) {
    for(var i = 0; i < arr.length - 1; i++) {
      // to find the index of the lowest value in the arr
      var min = i;

      for(var j = i + 1; j < arr.length; j++) {
          if(arr[j] < arr[min]) {
            min = j;
          }
      }

      util.swap(arr, i, min);
    }
  }
}
