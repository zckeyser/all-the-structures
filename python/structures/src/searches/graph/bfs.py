def traverse(root):
    output = ''

    queue = [root]
    visited = []

    while len(queue) > 0:
        # pop the next item in the queue
        curr = queue.pop()

        # add all unvisited neighbors to the queue
        for neighbor in curr.neighbors:
            if neighbor not in visited:
                queue.append(neighbor)

        output += str(curr.value) + ' '

    return output.strip()
