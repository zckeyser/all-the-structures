// basic directed graph implementation
// this isn't tested directly, but rather through
// the graph traversal tests
function DirectedGraphNode(value) {
  this.value = value;
  this.neighbors = [];
}

DirectedGraphNode.prototype = (function() {
  function addNeighbor(node) {
    if(!(node instanceof DirectedGraphNode)) {
      console.log("warning: attempted to add non-DirectedGraphNode to directed graph");
      return;
    }

    if( _.findIndex(this.neighbors, node, node.equals) === -1) {
      this.neighbors.push(node);
    }
  }

  function removeEdge(node) {
    // find neighbor node's position
    var index = _.findIndex(neighbors, node, node.equals);

    // remove it if it was found
    if(index !== -1) {
      neighbors.splice(index, 1);
    }
  }

  function equals(node) {
    if(this.value === node.value && this.neighbors.length === node.neighbors.length) {
      if(this.neighbors.length === 0) {
        return true;
      }

      var equal = true;

      var neighborPairs = _.zip(_.sortBy(this.neighbors, 'value'), _.sortBy(node.neighbors, 'value'));

      _.forEach(neighborPairs, function(pair) {
        equal = equal && pair[0].equals(pair[1]);
      });

      return equal;
    }

    return false;
  }

  return {
    addNeighbor: addNeighbor,
    removeEdge: removeEdge,
    equals: equals
  }
}.call(this))
