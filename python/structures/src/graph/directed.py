# class representing a directed graph node
class Node(object):
    def __init__(self, value):
        self.value = value
        self.neighbors = []

    def add_neighbor(self, node):
        self.neighbors.append(node)

    def remove_neighbor(self, node):
        self.neighbors.remove(node)
