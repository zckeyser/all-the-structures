# class representing a directed graph node
class Node(object):
    def __init__(self, value):
        self.value = value
        self.neighbors = []

    def __eq__(self, node):
        if self.value != node.value:
            return False

        # precondition for neighbor equality
        if len(self.neighbors) != len(node.neighbors):
            return False

        # make sure each neighbor has a match with the other node
        # alongside the length check this checks for equality between
        # neighbor lists, ignoring order
        for otherNeighbor in node.neighbors:
            match = False

            for selfNeighbor in self.neighbors:
                if otherNeighbor == selfNeighbor:
                    match = True
                    break

                # if we didn't find a match, neighbors can't be equal
                if not match:
                    return False

        return True


    def addNeighbor(self, node):
        self.neighbors.append(node)

    def removeNeighbor(self, node):
        self.neighbors.remove(node)
