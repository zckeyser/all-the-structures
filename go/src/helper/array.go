package helper

import "reflect"
import "errors"
import "fmt"

func IsSorted(arr []int) bool {
  if len(arr) != 0 {
    for i := 0; i < len(arr) - 1; i++ {
      if arr[i] > arr[i + 1] {
        return false
      }
    }
  }

  return true
}

func Swap(arr []int, i int, j int) (swapped []int, err error) {
  swapped = arr
  err = nil

  if i < 0 || i > len(arr) || j < 0 || j > len(arr) {
    err = errors.New(fmt.Sprintf("invalid index in i = %d, j = %d", i, j))
    return
  }

  tmp := swapped[i]
  swapped[i] = swapped[j]
  swapped[j] = tmp

  return
}
