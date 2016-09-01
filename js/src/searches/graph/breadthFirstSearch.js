function BreadthFirstSearch() { }

// in reality, this is a breadth first traversal
// however, the exact same algorithm could be used
// to search, except instead of adding to output you'd
// compare the current node's value against a target
BreadthFirstSearch.prototype = (function() {
    // for some reason I couldn't get my generically defined function to work
    function index(arr, node) {
        for(var i = 0; i < arr.length; i++) {
            if(node.equals(arr[i])) {
                return i;
            }
        }

        return -1;
    }

    function traverse(root) {
        // initialize our values
        var visited = [];
        var queue = new Queue();

        queue.push(root);

        var output = '';

        while(!queue.empty()) {
            var curr = queue.pop();

            output += curr.value + ' ';

            visited.push(curr);

            for(var i = 0; i < curr.neighbors.length; i++) {
                var node = curr.neighbors[i];

                if(node &&
                    index(queue.values, node) === -1 &&
                    index(visited, node) === -1) {

                    queue.push(node);
                }
            }
        }

        return output.trim();
    }

    return {
        traverse: traverse
    }
}.call(this))
