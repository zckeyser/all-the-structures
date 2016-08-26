import structures.src.util.sort_util as util

# performs a pure selection sort on the given array, returning an ascending sorted version of the array
def sort(arr):
    out = list(arr)

    for i in range(1, len(out)):
        j = i

        while j > 0 and out[j - 1] > out[j]:
            util.swap(out, j, j - 1)
            j -= 1

    return out
