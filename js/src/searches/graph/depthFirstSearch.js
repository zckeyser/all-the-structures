function DepthFirstSearch() { }

// in reality, this is a depth first traversal
// however, the exact same algorithm could be used
// to search, except instead of adding to output you'd
// compare the current node's value against a target
DepthFirstSearch.prototype = (function() {
  function traverse(root) {
    // initialize our values
    var visited = [];
    var stack = new Stack();

    stack.push(root);

    var output = '';

    while(!stack.empty()) {
      var curr = stack.pop();

      output += curr.value + ' ';

      visited.push(curr);

      _.forEach(curr.neighbors, function(node) {
        if(!stack.contains(node, node.equals) && _.findIndex(visited, node, node.equals) === -1) {
          stack.push(node);
        }
      });
    }

    return output.trim();
  }

  return {
    traverse: traverse
  }
}.call(this))
