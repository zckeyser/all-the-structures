import structures.src.util.sort_util as util

def sort(arr):
    out = list(arr)

    for i in range(0, len(out)):
        minIndex = i

        for j in range(i, len(out)):
            if(out[j] < out[minIndex]):
                minIndex = j

        util.swap(out, i, minIndex)

    return out
