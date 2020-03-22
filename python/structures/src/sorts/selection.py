from structures.src.util.sort_util import swap

def sort(arr):
    out = list(arr)

    for i in range(0, len(out)):
        min_index = i

        for j in range(i, len(out)):
            if(out[j] < out[min_index]):
                min_index = j

        swap(out, i, min_index)

    return out
