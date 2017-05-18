package sorts

import "../helper"

func InsertionSort(arr []int) ([]int) {
  sorted := make([]int, len(arr))
  copy(sorted, arr)

  for i := 1; i < len(sorted); i++ {
    for j := i - 1; j > 0 && sorted[i] < sorted[j]; j-- {
      sorted = helper.Swap(sorted, i, j)
    }
  }

  return sorted
}
