package helper

import "reflect"
import "errors"
import "fmt"

func IsOfComparable(arr []interface{}) bool {
  // need to be able to get an element to check if the contained elements are comparable
  if len(arr) == 0 {
    return false
  } else {
    return reflect.TypeOf(arr[0]).Comparable()
  }
}

func IsSorted(arr []interface{}) (isSorted bool, err error) {
  if len(arr) == 0 {
    err = nil
    isSorted = true
  } else if !IsOfComparable(arr) {
    err = errors.New("slice must contain a comparable type")
    isSorted = false
  } else {
    for i := 0; i < len(arr) - 1; i++ {
      if arr[i] > arr[i + 1] {
        isSorted = false
        break
      }
    }

    err = nil
  }

  return
}

func Swap(arr []interface{}, i int, j int) (swapped []interface{}, err error) {
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
