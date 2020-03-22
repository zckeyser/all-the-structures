import structures.src.util.sort_util as util

# TODO fix this -- this implementation doesn't actually reap the speed benefits of quicksort
# due to the required copying of the underlying arrays
def quicksort(arr):
   if arr == []: return []
   return quicksort([n for n in arr[1:] if n < arr[0]]) + arr[0:1] + \
          quicksort([n for n in arr[1:] if n >= arr[0]])
