# compares time for searching with binary and linear searches
import sys
import random

import structures.src.util.sort_util as util
import structures.src.util.timing as timing
import structures.src.util.constants as const

import structures.src.searches.list.linear as linearSearch
import structures.src.searches.list.binary as binarySearch

def main():
    size = const.ARRAY_SIZE

    if len(sys.argv) > 1:
        size = int(sys.argv[1])

    numItems = size / 100

    arr = util.random_array(size)

    targets = []

    print('Time to find ' + str(numItems) + ' items')

    # time to find 20 random items
    for i in range(0, numItems):
        targets.append(random.randint(0, size))

    linearTiming = 0
    binaryTiming = 0

    for target in targets:
        linearTiming += timing.time(linearSearch.contains, arr, target)
        binaryTiming += timing.time(binarySearch.contains, arr, target)

    print('Linear Search: ' + str(linearTiming) + 's')
    print('Binary Search: ' + str(binaryTiming) + 's')

if __name__ == '__main__':
    main()
