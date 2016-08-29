import time
import sys

import structures.src.util.sort_util as util
import structures.src.util.constants as const

import structures.src.sorts.bubble as bubble_sort
import structures.src.sorts.insertion as insertion_sort
import structures.src.sorts.selection as selection_sort
import structures.src.sorts.merge as merge_sort
import structures.src.sorts.quick as qsort

def main():
    size = const.ARRAY_SIZE

    if len(sys.argv) > 1:
        size = int(sys.argv[1])

    arr = util.random_array(size)

    bubble_time = __time(bubble_sort.sort, arr)
    insertion_time = __time(insertion_sort.sort, arr)
    selection_time = __time(selection_sort.sort, arr)
    merge_time = __time(merge_sort.mergesort, arr)
    quick_time = __time(qsort.quicksort, arr)

    print "Bubble Sort: " + str(bubble_time) + "s"
    print "Insertion Sort: " + str(insertion_time) + "s"
    print "Selection Sort: " + str(selection_time) + "s"
    print "Merge Sort: " + str(merge_time) + "s"
    print "Quick Sort: " + str(quick_time) + "s"

def __time(function, *args):
    before = time.time()

    function(*args)

    after = time.time()

    return after - before

if __name__ == '__main__':
    main()
