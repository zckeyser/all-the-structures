def traverse(root):
    output = ''

    queue = [root]
    visited = []

    while len(queue) > 0:
        # pop the next item in the queue
        curr = queue.pop(0)

        # add all unvisited neighbors to the queue
        for neighbor in curr.neighbors:
            if neighbor not in visited and neighbor not in queue:
                queue.append(neighbor)

        output += str(curr.value) + ' '

        visited.append(curr)

    return output.strip()
