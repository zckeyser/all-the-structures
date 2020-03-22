import structures.src.util.sort_util as util

def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    midpoint = int(len(arr) / 2)

    # merge the sorted left and right halves together
    return _merge(merge_sort(arr[:midpoint]), merge_sort(arr[midpoint:]))

# merge two arrays together into a single sorted array
# inputs are assumed to be sorted
def _merge(a, b):
    out = []
    i, j = 0, 0

    while i < len(a) and j < len(b):

        if i == len(a): # all a items have been merged
            out.append(b[j])
            j += 1
        elif j == len(b): # all b items have been merged
            out.append(a[i])
            i += 1
        elif a[i] < b[j]: # the next lowest item is in a
            out.append(a[i])
            i += 1
        else: # the next lowest item is in b
            out.append(b[j])
            j += 1

    return out
