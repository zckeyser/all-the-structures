function DepthFirstSearch() { }

// in reality, this is a depth first traversal
// however, the exact same algorithm could be used
// to search, except instead of adding to output you'd
// compare the current node's value against a target
DepthFirstSearch.prototype = (function() {
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
        var stack = new Stack();

        stack.push(root);

        var output = '';

        while(!stack.empty()) {
            var curr = stack.pop();

            output += curr.value + ' ';

            visited.push(curr);

            for(var i = 0; i < curr.neighbors.length; i++) {
                var node = curr.neighbors[i];

                if(node &&
                    index(stack.values, node) === -1 &&
                    index(visited, node) === -1) {

                    stack.push(node);
                }
            }
        }

        return output.trim();
    }

    return {
        traverse: traverse
    }
}.call(this))
