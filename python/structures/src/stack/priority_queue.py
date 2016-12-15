# ordered linked list implementation of a priority queue
class PriorityQueue(object):
    def __init__(self):
        self.__values = None

    def __max__(self):
        return self.__values.value if self.__values != None else None

    def enqueue(self, value, key):
        toInsert = _PriorityQueueNode(value, key)

        if self.__values == None:
            self.__values = toInsert
        elif key > self.__values.key:
            toInsert.next = self.__values
            self.__values = toInsert
        else:
            curr = self.__values
            while curr.next != None and curr.next.key >= key:
                curr = curr.next

            nxt = curr.next
            curr.next = toInsert
            curr.next.next = nxt


    def extract_max(self):
        if self.__values != None:
            retval = self.__values.value
            self.__values = self.__values.next if self.__values != None else None
            return retval
        else:
            return None

    def __len__(self):
        return len(self.__values) if self.__values != None else 0


class _PriorityQueueNode(object):
    def __init__(self, value, key):
        self.key = key
        self.value = value
        self.next = None

    def __len__(self):
        return 1 if self.next == None else len(self.next) + 1
