def traverse(root):
    output = ''

    stack = [root]
    visited = []

    while len(stack) > 0:
        # pop the next item off the stack
        curr = stack.pop()

        # add all unvisited neighbors to the queue
        for neighbor in curr.neighbors:
            if neighbor not in visited and neighbor not in stack:
                stack.append(neighbor)

        output += str(curr.value) + ' '

        visited.append(curr)

    return output.strip()
