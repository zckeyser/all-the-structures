function InsertionSort() {

}

InsertionSort.prototype = {
  sort: function(arr) {
    var input = arr.slice(0);

    for(var i = 0; i < input.length - 1; i++) {
      var j = i + 1;

      // swap the number at index i + 1 back until it's in the right place
      while(input[j] < input[j - 1]) {
        util.swap(input, j, j - 1);
        j--;
      }
    }

    return input;
  }
}
