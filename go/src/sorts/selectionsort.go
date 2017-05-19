package sorts

func SelectionSort(arr []int) ([]int) {
  sorted := make([]int, len(arr))
  copy(sorted, arr)

  for i := 0; i < len(sorted); i++ {
    min := i

    for j := i; j < len(sorted); j++ {
      if sorted[j] < sorted[min] {
        min = j
      }
    }

    sorted[i], sorted[min] = sorted[min], sorted[i]
  }

  return sorted
}
