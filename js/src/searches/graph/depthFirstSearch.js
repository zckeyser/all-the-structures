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

            for(var i = 0; i < curr.neighbors.length; i++) {
                var node = curr.neighbors[i];

                if(!stack.contains(node, node.equals) &&
                    util.findIndex(visited, function (other) { node.equals(other) }) === -1) {

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
