// basic directed graph implementation
// this isn't tested directly, but rather through
// the graph traversal tests
function DirectedGraphNode(value) {
  this.value = value;
  this.neighbors = [];
}

DirectedGraphNode.prototype = (function() {
    function compareValue(a, b) {
        if(a.value < b.value) {
            return -1;
        }

        if(a.value > b.value) {
            return 1
        }

        // must be equal
        return 0;
    }

    function equalsNode(node) {
        return function(other) {
            return node.equals(other);
        }
    }

    function addNeighbor(node) {
        if(!(node instanceof DirectedGraphNode)) {
            console.log("warning: attempted to add non-DirectedGraphNode to directed graph");
            return;
        }

        if(util.findIndex(this.neighbors, equalsNode(node)) === -1) {
            this.neighbors.push(node);
        }
    }

    function removeEdge(node) {
        // find neighbor node's position
        var index = util.findIndex(this.neighbors, equalsNode(node));

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

            thisSortedNeighbors = this.neighbors.slice(0);
            thisSortedNeighbors.sort(compareValue);

            otherSortedNeighbors = node.neighbors.slice(0);
            otherSortedNeighbors.sort(compareValue);

            for(var i = 0; i < thisSortedNeighbors.length; i++) {
                if(!thisSortedNeighbors[i].equals(otherSortedNeighbors[i])) {
                    return false;
                }
            }

            return true;
        }

        // either different value or different neighbor count
        return false;
    }

    return {
      addNeighbor: addNeighbor,
      removeEdge: removeEdge,
      equals: equals
    }
}.call(this))
