package sort

import "helper"

func BubbleSort(arr []interface{}) (sorted []interface{}, err error) {
  sorted := make([]interface[])
  sorted = copy(sorted, arr)

  // validate that we can sort the array
  if len(sorted) == 0 {
    err := nil
    return
  }

  if !helper.IsOfComparable(arr) {
    err := errors.New("slice elements must be of a comparable type")
    return
  }

  for isSorted, err := helper.IsSorted(sorted); !isSorted {
    if err != nil {
      return
    }

    for i := 0; i < len(sorted) - 1; i++ {
      if sorted[i] > sorted[i + 1] {
        if sorted, err = helper.Swap(sorted, i, i + 1); err != nil {
          // had a problem during the swap call
          return
        }
      }
    }
  }

  err = nil

  return
}
