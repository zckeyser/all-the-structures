package sorts

import "../helper"

func BubbleSort(arr []int) (sorted []int) {
  sorted = make([]int, len(arr))
  copy(sorted, arr)

  for !helper.IsSorted(sorted) {
    for i := 0; i < len(sorted) - 1; i++ {
      if sorted[i] > sorted[i + 1] {
        sorted = helper.Swap(sorted, i, i + 1)
      }
    }
  }

  return
}
