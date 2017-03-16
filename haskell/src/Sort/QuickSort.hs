module Sort.QuickSort where
  -- this is the prettier, immutable version which isn't a true quicksort
  -- this is because one of the major advantages of quicksort is that it
  -- has in-place sorting, which allows for better utilization of the L1/L2
  -- caches in comparison to mergesort, despite having equal time complexity
  -- a true quicksort in hs can be found here: http://stackoverflow.com/a/7719971

  -- quicksort which uses the first element of the array as a pivot
  -- uses a 3-way partition, which is more efficient when the
  -- array has a lot of duplicates
  quicksort :: (Ord a) => [a] -> [a]
  quicksort [] = []
  quicksort (x:xs) = quicksort (filter (< x) xs)
                 ++ filter (== x) xs
                 ++ quicksort (filter (> x) xs)
