DEFAULT_DICTIONARY_SIZE = 64

# dictionary implementation
# certainly not a pythonic implementation (since it's a very standard builtin), but this is the general idea
class Dictionary(object):
    def __init__(self):
        self._size = 0
        self._values = [None] * DEFAULT_DICTIONARY_SIZE

    # double the internal list's size and move all the old items into it
    def _expand(self):
        values = list(self._values)
        self._values = [None] * len(self._values) * 2

        # we're resetting size because this will be recalculated as we
        # re-add the newly hashed items
        self._size = 0

        for entry in values:
            if entry != None:
                key = entry[0]
                value = entry[1]
                self[key] = value

    # find the internal index of the entry with the given key
    # -1 is returned if it is not found
    def _indexof(self, key):
        i = hash(key) % len(self._values)

        if self._values[i] == None:
            return -1

        if self._values[i][0] == key:
            return i
        else:
            j = i + 1
            # scan through filled buckets to see if it's been fulfilled linearly
            while self._values[j] != None and self._values[j][0] != key and j != i:
                # loop around to the beginning if we hit the end
                if j == len(self._values) - 1:
                    j = 0
                else:
                    j += 1

            # see if we found it
            if self._values[j] != None and self._values[j][0] == key:
                return j
            else:
                return -1

    # to override the [] operator
    def __getitem__(self, key):
        i = self._indexof(key)

        if i == -1:
            return None
        else:
            return self._values[i][1]

    # to override the [] operator
    def __setitem__(self, key, value):
        i = hash(key) % len(self._values)

        if self._values[i] == None:
            self._values[i] = (key, value)
            self._size += 1
        elif self._values[i][0] == key:
            self._values[i] = (key, value)
        else:
            j = i + 1 if i < len(self._values) - 1 else 0

            # use linear scanning to find the next open bucket
            while self._values[j] != None and j != i:
                # loop around to the beginning if we hit the end
                if j == len(self._values) - 1:
                    j = 0
                else:
                    j += 1

            # we're full and need to expand self._values
            if j == i:
                self._expand()

                # reinsert with the newly opened up array
                self.__setitem__(key, value)
            else:
                # we found an open spot
                self._values[j] = (key, value)
                self._size += 1

    # remove the entry with the given key
    def remove(self, key):
        i = self._indexof(key)

        if i != -1:
            self._values[i] = None
            self._size -= 1

    def contains_key(self, key):
        return self[key] != None

    def __len__(self):
        return self._size
