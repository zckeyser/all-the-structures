import sys

import structures.src.util.sort_util as util
import structures.src.util.timing as timing
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

    print("Bubble Sort: " + str(timing.time(bubble_sort.sort, arr)) + "s")
    print("Insertion Sort: " + str(timing.time(insertion_sort.sort, arr)) + "s")
    print("Selection Sort: " + str(timing.time(selection_sort.sort, arr)) + "s")
    print("Merge Sort: " + str(timing.time(merge_sort.mergesort, arr)) + "s")
    print("Quick Sort: " + str(timing.time(qsort.quicksort, arr)) + "s")

if __name__ == '__main__':
    main()
