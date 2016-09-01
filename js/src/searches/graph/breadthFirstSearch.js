function BreadthFirstSearch() { }

// in reality, this is a breadth first traversal
// however, the exact same algorithm could be used
// to search, except instead of adding to output you'd
// compare the current node's value against a target
BreadthFirstSearch.prototype = (function() {
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

                if(!queue.contains(node, node.equals) &&
                    util.findIndex(visited, node.equals) === -1) {

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
