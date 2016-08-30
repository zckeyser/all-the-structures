class Queue(object):
    def __init__(self):
        self.__values = []

    def push(self, value):
        self.__values.append(value)

    def pop(self):
        return self.__values.pop(0)

    def __len__(self):
        return len(self.__values)
