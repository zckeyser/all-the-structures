import structures.src.util.constants as const

# dictionary implementation
# this is kinda impractical since this is a builtin and very much not pythonic
# but I wanted to match the fact that I implemented in Java
class Dictionary(object):
    def __init__(self):
        self.__size = 0
        self.__values = [None] * const.DEFAULT_DICTIONARY_SIZE

    # double the internal list's size and move all the old items into it
    def __expand(self):
        values = list(self.__values)
        self.__values = [None] * len(self.__values) * 2

        # we're resetting size because this will be recalculated as we
        # re-add the newly hashed items
        self.__size = 0

        for entry in values:
            if entry != None:
                key = entry[0]
                value = entry[1]
                self[key] = value

    # find the internal index of the entry with the given key
    # -1 is returned if it is not found
    def __indexof(self, key):
        i = hash(key) % len(self.__values)

        if self.__values[i] == None:
            return -1

        if self.__values[i][0] == key:
            return i
        else:
            j = i + 1
            # scan through filled buckets to see if it's been fulfilled linearly
            while self.__values[j] != None and self.__values[j][0] != key and j != i:
                # loop around to the beginning if we hit the end
                if j == len(self.__values) - 1:
                    j = 0
                else:
                    j += 1

            # see if we found it
            if self.__values[j] != None and self.__values[j][0] == key:
                return j
            else:
                return -1

    # to override the [] operator
    def __getitem__(self, key):
        i = self.__indexof(key)

        if i == -1:
            return None
        else:
            return self.__values[i][1]

    # also to override the [] operator
    def __setitem__(self, key, value):
        i = hash(key) % len(self.__values)

        if self.__values[i] == None:
            self.__values[i] = (key, value)
            self.__size += 1
        elif self.__values[i][0] == key:
            self.__values[i] = (key, value)
        else:
            j = i + 1 if i < len(self.__values) - 1 else 0

            # use linear scanning to find the next open bucket
            while self.__values[j] != None and j != i:
                # loop around to the beginning if we hit the end
                if j == len(self.__values) - 1:
                    j = 0
                else:
                    j += 1

            # we're full and need to expand self.__values
            if j == i:
                self.__expand()

                # reinsert with the newly opened up array
                self.__setitem__(key, value)
            else:
                # we found an open spot
                self.__values[j] = (key, value)
                self.__size += 1

    # remove the entry with the given key
    def remove(self, key):
        i = self.__indexof(key)

        if i != -1:
            self.__values[i] = None
            self.__size -= 1

    def contains_key(self, key):
        return self[key] != None

    def __len__(self):
        return self.__size
