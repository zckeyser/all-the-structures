class PriorityQueue(object):
    def __init__(self, levels):
        self.__queues = []

        for level in range(0, levels):
            self.__queues.append([])

    def push(self, value, level = 0):
        self.__queues[level].append(value)

    def pop(self):
        # we want to loop through self.__queues backwards
        for queue in self.__queues[::-1]:
            if queue:
                return queue.pop(0)

        return None

    def __len__(self):
        total = 0

        for queue in self.__queues:
            total += len(queue)

        return total

    def levels(self):
        return len(self.__queues)
