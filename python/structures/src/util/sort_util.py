import random

# checks if the given array is sorted
def is_sorted(arr):
    for i in range(1, len(arr)):
        if arr[i] < arr[i - 1]:
            return False
    # if nothing was out of order it must be sorted
    return True

# creates a random array of given size
def random_array(size):
    arr = []

    for i in range(0, size):
        arr.append(random.randint(-100000, 100000))

    return arr
