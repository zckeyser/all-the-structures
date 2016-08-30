class Stack(object):
    def __init__(self):
        self.__values = []

    def push(self, value):
        self.__values.append(value)

    def pop(self):
        return self.__values.pop()

    def __len__(self):
        return len(self.__values)
