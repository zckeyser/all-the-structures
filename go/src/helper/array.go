package helper

func IsSorted(arr []int) bool {
  if len(arr) == 0 {
    return true
  }

  for i := 0; i < len(arr) - 1; i++ {
    if arr[i] > arr[i + 1] {
      return false
    }
  }

  return true
}

func Swap(arr []int, i int, j int) (swapped []int) {
  swapped = arr

  tmp := swapped[i]
  swapped[i] = swapped[j]
  swapped[j] = tmp

  return
}
