def traverse(root):
    output = ''

    stack = [root]
    visited = []

    while len(stack) > 0:
        # pop the next item off the stack
        curr = stack.pop(0)

        # add all unvisited neighbors to the queue
        for neighbor in curr.neighbors:
            if neighbor not in visited:
                stack.append(neighbor)

        output += str(curr.value) + ' '

    return output.strip()
