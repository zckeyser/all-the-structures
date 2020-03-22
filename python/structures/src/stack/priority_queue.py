# ordered linked list implementation of a priority queue
class PriorityQueue(object):
    def __init__(self):
        self._values = None

    def __max__(self):
        return self._values.value if self._values else None

    def enqueue(self, value, key):
        to_insert = _PriorityQueueNode(value, key)

        if self._values == None:
            self._values = to_insert
        elif key > self._values.key:
            to_insert.next = self._values
            self._values = to_insert
        else:
            curr = self._values
            while curr.next != None and curr.next.key >= key:
                curr = curr.next

            nxt = curr.next
            curr.next = to_insert
            curr.next.next = nxt


    def extract_max(self):
        if self._values:
            retval = self._values.value
            self._values = self._values.next if self._values.next else None
            return retval
        else:
            return None

    def __len__(self):
        return len(self._values) if self._values != None else 0


class _PriorityQueueNode(object):
    def __init__(self, value, key):
        self.key = key
        self.value = value
        self.next = None

    def __len__(self):
        return 1 if self.next == None else len(self.next) + 1
