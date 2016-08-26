import structures.src.util.sort_util as util

def sort(arr):
    # want this to be pure
    out = list(arr)

    # keep doing it until we're sorted
    while not util.is_sorted(out):
        for i in range(0, len(out) - 1):
            # if this is out of order, swap it to the next slot
            if out[i] > out[i + 1]:
                util.swap(out, i, i + 1)

    return out
