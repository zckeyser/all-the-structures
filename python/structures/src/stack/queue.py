class Queue(object):
    def __init__(self):
        self._values = []

    def push(self, value):
        self._values.append(value)

    def pop(self):
        return self._values.pop(0)

    def __len__(self):
        return len(self._values)
