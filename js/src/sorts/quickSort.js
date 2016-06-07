function QuickSort() {

}

QuickSort.prototype = {
  sort: (function() {
    function quickSort(arr) {
      if(arr.length <= 1) {
        return arr;
      }

      var input = arr.slice(0);

      // sorts given array in place
      quickSortHelper(input, 0, input.length - 1);

      return input;
    }

    function quickSortHelper(arr, left, right) {
      var index;

      if(arr.length > 1) {
        index = partition(arr, left, right);

        if(left < index - 1) {
          quickSortHelper(arr, left, index - 1);
        }

        if(index < right) {
          quickSortHelper(arr, index, right);
        }
      }
    }

    function partition(arr, left, right) {
      // select pivot at random
      var pivot = arr[util.getRandomInt(left, right + 1)];

      var i = left;
      var j = right;

      while(i <= j) {
        // find a number left of pivot to swap
        while(arr[i] < pivot) {
          i++;
        }

        // find a number right of pivot to swap
        while(arr[j] > pivot) {
          j--;
        }

        if(i <= j) {
            util.swap(arr, i, j);
            i++;
            j--;
        }
      }

      return i;
    }

    return quickSort;
  }.call(this))
}
