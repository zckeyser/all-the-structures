// this approach is pretty bad but I wanted the end-result code
// to be more readable
// I'll probably switch this back later to better match js best practices

Array.prototype.swap = function(index_A, index_B) {
    var input = this;

    var temp = input[index_A];
    input[index_A] = input[index_B];
    input[index_B] = temp;
}

Array.prototype.isSorted = function() {
  var input = this;

  for(var i = 0; i < input.length - 1; i++) {
    if(input[i] > input[i + 1]) {
      return false;
    }
  }

  return true;
}
